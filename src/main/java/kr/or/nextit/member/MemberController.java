package kr.or.nextit.member;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.nextit.code.service.CommCodeServiceImpl;
import kr.or.nextit.code.service.ICommCodeService;
import kr.or.nextit.code.vo.CodeVO;
import kr.or.nextit.common.valid.MemberModify;
import kr.or.nextit.common.valid.MemberRegister;
import kr.or.nextit.common.vo.ResultMessageVO;
import kr.or.nextit.common.vo.RoleInfoVO;
import kr.or.nextit.exception.BizDuplicateKeyException;
import kr.or.nextit.exception.BizNotEffectedException;
import kr.or.nextit.exception.BizNotFoundException;
import kr.or.nextit.exception.BizPasswordNotMatchedException;
import kr.or.nextit.exception.DaoException;
import kr.or.nextit.member.service.IMemberService;
import kr.or.nextit.member.service.MemberServiceImpl;
import kr.or.nextit.member.vo.MemberSearchVO;
import kr.or.nextit.member.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private ICommCodeService codeService;
	
	
	@Resource(name="memberService")
	private IMemberService memberService;
	
	
	/*
	 * @ModelAttribute 사용하면 자동으로 Model에 담아준다. 따라서 
	 * 어떤로직이라도 처리 후 화면에서 jobList와  hobbyList를 접근할 수 있습니다.
	 * */
	@ModelAttribute("jobList")
	public List<CodeVO> jobList(){
		return codeService.getCodeListByParent("JB00");
	}
	@ModelAttribute("hobbyList")
	public List<CodeVO> hobbyList(){
		return codeService.getCodeListByParent("HB00");
	}
	
	
	
	
	
	@RequestMapping(value = "/member/memberRegister", method = RequestMethod.POST)
	public String memberRegister(
			@Validated(value = MemberRegister.class) @ModelAttribute("member") MemberVO member
			,BindingResult error
			,Model model
			,ResultMessageVO resultMessageVO
			) {
		System.out.println("MemberController memberRegister member.toString(): "
			+ member.toString());
		
		if(error.hasErrors()) {
			return "/login/join";
		}
		
		try{
			if(member.getMemId() != null && ! member.getMemId().equals("")) {
				memberService.registerMember(member);
			}else {
				throw new Exception();
			}
			return "redirect:/login/sign";
			
		}catch(BizDuplicateKeyException bde){
			bde.printStackTrace();
			resultMessageVO.failSetting(false
					, "회원등록실패"
					,  "이미 사용중인 아이디 입니다. 다른 아이드를 사용해주세요");
		}catch(BizNotEffectedException bne){
			bne.printStackTrace();
			resultMessageVO.failSetting(false
					, "회원등록실패"
					,  "회원등록에 실패하였습니다. 전산실에 문의부탁드립니다. 042-719-8850");
		}catch(Exception de){
			de.printStackTrace();
			resultMessageVO.failSetting(false
					, "회원등록실패"
					,  "회원등록에 실패하였습니다. 전산실에 문의부탁드립니다. 042-719-8850");
		}
		
		model.addAttribute("resultMessageVO", resultMessageVO);
		return "/common/message";
	}
	
	
	@RequestMapping("/member/memberView")
	public String memberView(@RequestParam String memId
			, Model model) {
		System.out.println("MemberController memberView memId : "+ memId);
		try{
			MemberVO member = memberService.getMember(memId);
			member.setMemPass("");
			model.addAttribute("member", member);
		}catch(BizNotEffectedException bne){
			model.addAttribute("bne", bne);
			bne.printStackTrace();
		}catch(Exception de){
			model.addAttribute("de", de);
			de.printStackTrace();
		}
		return "/member/memberView";
	}
	
	
	@RequestMapping("/member/memberEdit")
	public String memberEdit(@RequestParam String memId
			,Model model) {
		System.out.println("MemberController memberEdit memId :"+ memId);
		try{
			MemberVO member = memberService.getMember(memId);
			member.setMemPass("");
			model.addAttribute("member", member);
		}catch(BizNotEffectedException bne){
			model.addAttribute("bne", bne);
			bne.printStackTrace();
		}catch(Exception de){
			model.addAttribute("de", de);
			de.printStackTrace();
		}
		return "/member/memberEdit";
	}
	
	@RequestMapping(value = "/member/memberModify", method = RequestMethod.POST)
	public String memberModify(
			@Validated(value = MemberModify.class) @ModelAttribute("member") MemberVO member
			,BindingResult error
			, Model model
			, ResultMessageVO resultMessageVO) {
		System.out.println("MemberController memberModify member.toStirng(): "
				+ member.toString());

		if(error.hasErrors()) {
			return "/member/memberEdit";
		}
		
		try{
			if(member.getMemId() !=null && ! member.getMemId().equals("") ) {
				memberService.modifyMember(member);
			}else {
				throw new Exception();
			}
			return "redirect:/member/memberView?memId="+member.getMemId();
			
		}catch(BizNotEffectedException bne){
			resultMessageVO.failSetting(false
					, "회원정보 수정 실패"
					, "회원정보 수정 실패 하였습니다. 전산실에 문의 부탁드립니다. 042-719-8850");
			bne.printStackTrace();
		}catch(BizPasswordNotMatchedException bpn){
			resultMessageVO.failSetting(false
					, "회원정보 수정 실패"
					, "입력하신 패스워드가 일치하지 않습니다. 다시 입력 해주세요");
			bpn.printStackTrace();
		}catch(BizNotFoundException bnf){
			resultMessageVO.failSetting(false
					, "회원정보 수정 실패"
					, "회원정보 수정 실패 하였습니다. 전산실에 문의 부탁드립니다. 042-719-8850");
			bnf.printStackTrace();
		}catch(Exception de){
			resultMessageVO.failSetting(false
					, "회원정보 수정 실패"
					, "회원정보 수정 실패 하였습니다. 전산실에 문의 부탁드립니다. 042-719-8850");
			de.printStackTrace();
		}
		
		model.addAttribute("resultMessageVO", resultMessageVO);
		return "/common/message";
	}
	

	@RequestMapping(value = "/member/memberDelete", method = RequestMethod.POST)
	public String memberDelete(@ModelAttribute MemberVO member
			, HttpServletRequest request
			, Model model
			, ResultMessageVO resultMessageVO) {
		System.out.println("MemberController memberDelete member.toString() :"
				+ member.toString());
		
		try{
			if(member.getMemId() !=null &&  ! member.getMemId().equals("")) {
				memberService.removeMember(member);
			}else {
				throw new Exception();
			}
			HttpSession session = request.getSession();
			session.removeAttribute("memberVO");
			return "redirect:/login/quit";
			
		}catch(BizNotFoundException bnf){
			//model.addAttribute("bnf", bnf);
			resultMessageVO.failSetting(false
					, "회원탈퇴 실패"
					, "회원탈퇴 실패하였습니다. 전산실에 문의 부탁드립니다. 042-719-8850");
			bnf.printStackTrace();
		}catch(BizPasswordNotMatchedException bpn){
			//model.addAttribute("bpn", bpn);
			resultMessageVO.failSetting(false
					, "회원정보 수정 실패"
					, "입력하신 패스워드가 일치하지 않습니다. 다시 입력 해주세요");
			bpn.printStackTrace();
		}catch(BizNotEffectedException bne){
			//model.addAttribute("bne", bne);
			resultMessageVO.failSetting(false
					, "회원탈퇴 실패"
					, "회원탈퇴 실패하였습니다. 전산실에 문의 부탁드립니다. 042-719-8850");
			bne.printStackTrace();
		}catch(Exception de){
			//model.addAttribute("de", de);
			resultMessageVO.failSetting(false
					, "회원탈퇴 실패"
					, "회원탈퇴 실패하였습니다. 전산실에 문의 부탁드립니다. 042-719-8850");
			de.printStackTrace();
		}
		//return "/member/memberDelete";
		model.addAttribute("resultMessageVO", resultMessageVO);
		return "/common/message";
	}


	@RequestMapping("/member/memberList")
	public String memberList(@ModelAttribute("searchVO") MemberSearchVO searchVO
			, Model model) {
		System.out.println("MemberController memberList ");
		
		try{
			List<MemberVO> memberList = memberService.getMemberList(searchVO);
			model.addAttribute("memberList", memberList);
		}catch(BizNotFoundException bnf){
			model.addAttribute("bnf", bnf);
			bnf.printStackTrace();
		}catch(Exception de){
			model.addAttribute("de", de);
			de.printStackTrace();
		}
		return "/member/memberList";
	}

	
	@RequestMapping(value="/member/memberMultiDelete", method=RequestMethod.POST)
	public String memberMultiDelete(@RequestParam String memMultiId
			, Model model
			, ResultMessageVO resultMessageVO) {
		System.out.println("MemberController memberMultiDelete memMultiId: "
				+ memMultiId);
		try{
			if( memMultiId !=null && memMultiId.length() >2 ) {
				memberService.removeMultiMember(memMultiId);
			}else {
				throw new Exception();
			}
			return "redirect:/member/memberList";
			
		}catch(BizNotEffectedException bne){
			bne.printStackTrace();
			//model.addAttribute("bne", bne);
			resultMessageVO.failSetting(false
					, "회원삭제 실패"
					, "회원삭제 실패하였습니다. 전산실에 문의 부탁드립니다. 042-719-8850");
		}catch(Exception de){
			de.printStackTrace();
			//model.addAttribute("de", de);
			resultMessageVO.failSetting(false
					, "회원삭제 실패"
					, "회원삭제 실패하였습니다. 전산실에 문의 부탁드립니다. 042-719-8850");
		}
		//return "/member/memberMultiDelete";
		
		model.addAttribute("resultMessageVO", resultMessageVO);
		return "/common/message";
	}


	@RequestMapping("/member/memberRole")
	public String memberRole(@RequestParam String memId
			, Model model) {
		System.out.println("MemberController memberRole memId :" + memId);
		
		try{
			MemberVO member = null;
			if( memId != null && ! memId.equals("")) {
				member	= memberService.getMemberRole(memId);
			}else {
				throw new Exception();
			}
			model.addAttribute("member", member);
		 	List<RoleInfoVO> roleInfoList = memberService.getRoleInfo();
		 	model.addAttribute("roleInfoList", roleInfoList);
		}catch(BizNotEffectedException bne){
			bne.printStackTrace();
			model.addAttribute("bne", bne);
		}catch(Exception de){
			de.printStackTrace();
			model.addAttribute("de", de);
		}
		return "/member/memberRole";
		
	}

	@RequestMapping(value = "/member/memberRoleUpdate", method=RequestMethod.POST)
	public String memberRoleUpdate(@RequestParam String memId
			, @RequestParam(required = false, name="userRole") String[] roles
			, Model model
			, ResultMessageVO resultMessageVO) {
		System.out.println("MemberController memberRoleUpdate memId : "
				+ memId 
				+ ", roles : "+ Arrays.toString(roles));
		try{
			if(memId !=null && ! memId.equals("")) {
				memberService.updateUserRole(memId, roles);
			}else {
				throw new Exception();
			}
			return "redirect:/member/memberList";
		/*}catch(BizNotEffectedException bne){
			//model.addAttribute("bne", bne);
			resultMessageVO.failSetting(false
					, "회원 권한 수정 실패"
					, "회원 권한 수정 실패 하였습니다. 전산실에 문의 부탁드립니다. 042-719-8850");
			bne.printStackTrace();*/
		}catch(Exception de){
			//model.addAttribute("de", de);
			resultMessageVO.failSetting(false
					, "회원 권한 수정 실패"
					, "회원 권한 수정 실패 하였습니다. 전산실에 문의 부탁드립니다. 042-719-8850");
			de.printStackTrace();
		}
		
		//return "/member/memberRoleUpdate";
		model.addAttribute("resultMessageVO", resultMessageVO);
		return "/common/message";
	}




}


