package cn.edu.hqu.cst.java.rent.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import cn.edu.hqu.cst.java.rent.domain.entity.RelationInfo;
import cn.edu.hqu.cst.java.rent.domain.entity.Student;
import cn.edu.hqu.cst.java.rent.domain.entity.Student_House;
import cn.edu.hqu.cst.java.rent.service.HouseService;
import cn.edu.hqu.cst.java.rent.service.MasterService;
import cn.edu.hqu.cst.java.rent.service.StudentService;
import cn.edu.hqu.cst.java.rent.service.Student_HouseService;

@Controller
@RequestMapping("/house")
public class HouseController {
	@Autowired
	HouseService houseService;
	@Autowired
	MasterService masterService;
	@Autowired
	StudentService studentService;
	@Autowired
	Student_HouseService student_houseService;

	@RequestMapping(value = "/{masterId}", method = RequestMethod.GET)
	public String manageMasterHouse(@PathVariable int masterId, Model model) {
		// if (!model.containsAttribute("house")) {
		// House house = houseService.getHouseDetailByMasterId(masterId);
		// model.addAttribute(house);
		// }
		List<House> houseList = houseService.getHouseDetailByMasterId(masterId);
		model.addAttribute("houseList", houseList);
		Master master = masterService.getUserDetail(masterId);
		model.addAttribute("master", master);
		return "house_profile";
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	public String showUpdateHouseForm(Model model, @PathVariable int id) {
		model.addAttribute(houseService.getHouseDetail(id));
		return "house_update";
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	public String processUpdateHouse(@Valid House house, Errors errors, RedirectAttributes model, @PathVariable int id)
			throws IOException {
		if (errors.hasErrors()) {
			return "house_update";
		} else {
			houseService.updateHouseInfo(house);
			model.addAttribute(house);
			return "redirect:/house/" + house.getMasterid();
		}
	}

	@RequestMapping(value = "/{id}/unrent", method = RequestMethod.GET)
	public String unrentHouse1(Model model, @PathVariable int id) {
		House house = houseService.getHouseDetail(id);
		model.addAttribute(masterService.getUserDetail(house.getMasterid()));
		houseService.unrentHouse(house.getId());
		return "master_profile";
	}

	@RequestMapping(value = "/{id}/allList", method = RequestMethod.GET)
	public String getAllHouse(Model model, @PathVariable int id) {
		List<House> houseList = houseService.getAllHouseList();
		Student student = studentService.getUserDetail(id);
		model.addAttribute("houseList", houseList);
		model.addAttribute(student);
		return "house_list";
	}

	@RequestMapping(value = "/relation/{studentid}", method = RequestMethod.GET)
	public String relationForm(@PathVariable int studentid, Model model) {
		List<Student_House> student_house = student_houseService.getDetailInfoByStudentid(studentid);
		List<RelationInfo> relationInfos = new ArrayList<>();
		for (int i = 0; i < student_house.size(); i++) {
			RelationInfo relationInfo = new RelationInfo();
			Student_House student_housetmp = student_house.get(i);
			relationInfo.setId(student_housetmp.getId());
			relationInfo.setHouseid(student_housetmp.getHouseid());
			Master master = masterService.getUserDetail(student_housetmp.getMasterid());
			relationInfo.setMastername(master.getName());
			relationInfo.setMasterphone(master.getPhoneNumber());
			Student student = studentService.getUserDetail(student_housetmp.getStudentid());
			relationInfo.setStudentname(student.getName());
			relationInfo.setStudentphone(student.getPhoneNumber());
			relationInfo.setMeetplace(student_housetmp.getMeetplace());
			relationInfo.setMeettime(student_housetmp.getMeettime());
			relationInfos.add(relationInfo);
			System.out.println(master.getName());
		}
		model.addAttribute("relationInfos", relationInfos);
		Student student = studentService.getUserDetail(studentid);
		model.addAttribute("student", student);
		return "studentMsg";
	}
}
