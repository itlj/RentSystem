package cn.edu.hqu.cst.java.rent.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.hqu.cst.java.rent.domain.entity.Master;
import cn.edu.hqu.cst.java.rent.domain.entity.MasterMsg;
import cn.edu.hqu.cst.java.rent.domain.entity.RelationInfo;
import cn.edu.hqu.cst.java.rent.domain.entity.Student;
import cn.edu.hqu.cst.java.rent.domain.entity.Student_House;
import cn.edu.hqu.cst.java.rent.service.MasterMsgService;
import cn.edu.hqu.cst.java.rent.service.MasterService;
import cn.edu.hqu.cst.java.rent.service.StudentService;
import cn.edu.hqu.cst.java.rent.service.Student_HouseService;

@Controller
@RequestMapping("/masterMsg")
public class MasterMsgController {
	@Autowired
	MasterMsgService masterMsgService;

	@Autowired
	MasterService masterService;

	@Autowired
	Student_HouseService student_houseService;

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/{masterid}", method = RequestMethod.GET)
	public String getMessageList(@PathVariable int masterid, Model model) {
		// 账单
		List<MasterMsg> masterMsgList = masterMsgService.getAllMsgByMasterid(masterid);
		model.addAttribute("masterMsgList", masterMsgList);
		Master master = masterService.getUserDetail(masterid);
		model.addAttribute("master", master);
		// 见面信息
		List<Student_House> student_house = student_houseService.getDetailInfoByMasterid(masterid);
		List<RelationInfo> relationInfos = new ArrayList<>();
		for (int i = 0; i < student_house.size(); i++) {
			RelationInfo relationInfo = new RelationInfo();
			Student_House student_housetmp = student_house.get(i);
			relationInfo.setId(student_housetmp.getId());
			relationInfo.setHouseid(student_housetmp.getHouseid());
			Master mastertmp = masterService.getUserDetail(student_housetmp.getMasterid());
			relationInfo.setMastername(mastertmp.getName());
			relationInfo.setMasterphone(mastertmp.getPhoneNumber());
			Student studenttmp = studentService.getUserDetail(student_housetmp.getStudentid());
			relationInfo.setStudentname(studenttmp.getName());
			relationInfo.setStudentphone(studenttmp.getPhoneNumber());
			relationInfo.setMeetplace(student_housetmp.getMeetplace());
			relationInfo.setMeettime(student_housetmp.getMeettime());
			relationInfos.add(relationInfo);
			System.out.println(master.getName());
		}
		model.addAttribute("relationInfos", relationInfos);
		return "masterMsg";
	}
}
