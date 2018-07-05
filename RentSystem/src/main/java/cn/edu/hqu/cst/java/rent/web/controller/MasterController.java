package cn.edu.hqu.cst.java.rent.web.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.edu.hqu.cst.java.rent.domain.entity.House;
import cn.edu.hqu.cst.java.rent.domain.entity.Master;
import cn.edu.hqu.cst.java.rent.domain.entity.MasterMsg;
import cn.edu.hqu.cst.java.rent.service.HouseService;
import cn.edu.hqu.cst.java.rent.service.MasterMsgService;
import cn.edu.hqu.cst.java.rent.service.MasterService;
import cn.edu.hqu.cst.java.rent.web.controller.FormEntity.User;

@Controller
@RequestMapping("/master")
public class MasterController {
	@Autowired
	MasterService masterService;
	@Autowired
	HouseService houseService;
	@Autowired
	MasterMsgService masterMsgService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterForm(Model model) {
		model.addAttribute(new Master());
		return "master_register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegister(@Valid Master master, Errors errors, RedirectAttributes model) throws IOException {
		if (errors.hasErrors())
			return "master_register";
		else if (!masterService.register(master)) {
			errors.rejectValue("phoneNumber", "手机号已使用");
			return "master_register";
		} else {
			model.addAttribute(master);
			return "redirect:/master/" + master.getId();
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String masterProfile(@PathVariable int id, Model model) {
		if (!model.containsAttribute("master")) {
			Master master = masterService.getUserDetail(id);
			model.addAttribute(master);
		}
		return "master_profile";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm(Model model) {
		model.addAttribute(new User());
		return "master_login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLogin(@Valid User user, Errors erros, RedirectAttributes model) {
		Master master = masterService.login(user.getPhoneNumber(), user.getPassword());

		if (master == null)
			return "master_login";

		model.addFlashAttribute(master);
		return "redirect:/master/" + master.getId();

	}

	@RequestMapping(value = "/{masterId}/houseRegister", method = RequestMethod.GET)
	public String showHouseRegisterForm(Model model, @PathVariable int masterId) {
		model.addAttribute(new House());
		model.addAttribute(masterService.getUserDetail(masterId));
		return "house_register";
	}

	@RequestMapping(value = "/{masterId}/houseRegister", method = RequestMethod.POST)
	public String processHouseRegister(@Valid House house, Errors errors, RedirectAttributes model,
			@PathVariable int masterId) throws IOException {
		// 下面这句花了我两个小时!!!
		house.setMasterid(masterId);
		if (errors.hasErrors()) {
			return "master_register";
		} else if (!houseService.rentHouse(house)) {
			return "master_register";
		} else {
			MasterMsg masterMsg = new MasterMsg();
			masterMsg.setCategory("上传房屋");
			masterMsg.setMasterid(masterId);
			masterMsg.setPrice("50RMB");
			java.util.Date date = new java.util.Date();
			masterMsg.setPostedtime(date.toString());
			masterMsg.setHouseid(house.getId());
			masterMsgService.addMsg(masterMsg);
			model.addAttribute(house);
			return "redirect:/house/" + house.getMasterid();
		}
	}

}
