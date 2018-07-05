package cn.edu.hqu.cst.java.rent.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import cn.edu.hqu.cst.java.rent.domain.entity.Student;
import cn.edu.hqu.cst.java.rent.domain.entity.Student_House;
import cn.edu.hqu.cst.java.rent.service.HouseService;
import cn.edu.hqu.cst.java.rent.service.MasterService;
import cn.edu.hqu.cst.java.rent.service.StudentService;
import cn.edu.hqu.cst.java.rent.service.Student_HouseService;
import cn.edu.hqu.cst.java.rent.web.controller.FormEntity.User;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	@Autowired
	Student_HouseService student_houseService;
	@Autowired
	HouseService houseService;
	@Autowired
	MasterService masterService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterForm(Model model) {
		model.addAttribute(new Student());
		return "student_register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegister(@Valid Student student, Errors errors, RedirectAttributes model) throws IOException {
		if (errors.hasErrors()) {
			System.out.println("注册发生错误");
			return "student_register";
		} else if (!studentService.register(student)) {
			System.out.println("手机号已使用");
			errors.rejectValue("phoneNumber", "手机号已使用");
			return "student_register";
		} else {
			System.out.println("注册成功");
			model.addAttribute(student);
			return "redirect:/student/" + student.getId();
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String studentProfile(@PathVariable int id, Model model) {
		if (!model.containsAttribute("student")) {
			Student student = studentService.getUserDetail(id);
			model.addAttribute(student);
		}
		return "student_profile";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm(Model model) {
		model.addAttribute(new User());
		return "student_login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLogin(@Valid User user, Errors errors, RedirectAttributes model) {
		Student student = studentService.login(user.getPhoneNumber(), user.getPassword());
		if (student == null)
			return "student_login";

		model.addFlashAttribute(student);
		return "redirect:/student/" + student.getId();
	}

	List<String> meetingPlaceList = new ArrayList<>(
			Arrays.asList("老别墅西餐馆", "Hollys Coffee", "港町咖啡", "水岸咖啡", "枫多士", "星巴克", "KOI"));
	List<String> meetingTimeList = new ArrayList<>(
			Arrays.asList("周一下午2:30", "周二下午2:30", "周三下午2:30", "周四下午2:30", "周五下午2:30", "周六下午2:30", "周日下午2:30"));

	@RequestMapping(value = "/{studentid}/rent/{houseid}", method = RequestMethod.GET)
	public String rentHouse(RedirectAttributes model, @PathVariable int studentid, @PathVariable int houseid) {
		Student_House student_house = new Student_House();
		student_house.setHouseid(houseid);
		student_house.setStudentid(studentid);
		House house = houseService.getHouseDetail(houseid);
		student_house.setMasterid(house.getMasterid());
		java.util.Random r = new java.util.Random();
		student_house.setMeetplace(meetingPlaceList.get(Math.abs((r.nextInt())) % 7));
		student_house.setMeettime(meetingTimeList.get(Math.abs((r.nextInt())) % 7));
		student_houseService.addRecord(student_house);
		model.addFlashAttribute(student_house);
		Student student = studentService.getUserDetail(studentid);
		return "redirect:/house/relation/" + student.getId();
	}
}
