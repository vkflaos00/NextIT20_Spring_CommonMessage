package com.nextit.www;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextit.www.service.NextitApiService;

import kr.or.nextit.code.service.ICommCodeService;
import kr.or.nextit.code.vo.CodeVO;

@Controller
public class NextITApiController {
	
	@Autowired
	private NextitApiService apiService;
	
	@Resource(name="codeService")
	private ICommCodeService codeService;
	
	
	
	@RequestMapping("/apiJoin.do")
	public String apiJoin(Model model) {
		System.out.println("NextITApiController apiJoin");
		
		//apiService.apiJoin();
		
		List<CodeVO> jobList = codeService.getCodeListByParent("JB00");
		model.addAttribute("jobList", jobList);
		List<CodeVO> hobbyList = codeService.getCodeListByParent("HB00");
		model.addAttribute("hobbyList", hobbyList);
		
		return "/login/join";
	}

}
