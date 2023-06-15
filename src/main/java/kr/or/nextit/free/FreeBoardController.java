package kr.or.nextit.free;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.nextit.code.service.ICommCodeService;
import kr.or.nextit.code.vo.CodeVO;
import kr.or.nextit.common.valid.FreeFrom;
import kr.or.nextit.common.valid.FreeModify;
import kr.or.nextit.common.vo.ResultMessageVO;
import kr.or.nextit.exception.BizNotEffectedException;
import kr.or.nextit.exception.BizNotFoundException;
import kr.or.nextit.exception.BizPasswordNotMatchedException;
import kr.or.nextit.exception.DaoException;
import kr.or.nextit.free.service.FreeBoardServiceImpl;
import kr.or.nextit.free.service.IFreeBoardService;
import kr.or.nextit.free.vo.FreeBoardSearchVO;
import kr.or.nextit.free.vo.FreeBoardVO;


@Controller
@RequestMapping("/free")
public class FreeBoardController {
	
	@Resource(name="codeService")
	private ICommCodeService codeService;
	
	@ModelAttribute("categoryList")
	public List<CodeVO>	categoryList(){
		return codeService.getCodeListByParent("BC00");
	}
	
	@Resource(name="freeBoardService")
	private IFreeBoardService freeBoardService;	
	
	@RequestMapping("/freeList")
	public String freeList(@ModelAttribute("searchVO") FreeBoardSearchVO searchVO, Model model) {
		try{
			List<FreeBoardVO> freeBoardList = freeBoardService.getBoardList(searchVO);
			model.addAttribute("freeBoardList", freeBoardList);
		}catch(BizNotEffectedException bne){
			model.addAttribute("bne", bne);
			bne.printStackTrace();
		}catch(Exception de){
			model.addAttribute("de", de);
			de.printStackTrace();
		}
		return "/free/freeList";
	}
	

	@RequestMapping("/freeForm")
	public String freeForm(@ModelAttribute("freeBoard") FreeBoardVO freeBoard ) {
		return "/free/freeForm";
	}

	
	@RequestMapping("/freeRegister")
	public String freeRegister( @Validated(value = FreeFrom.class) @ModelAttribute("freeBoard") FreeBoardVO freeBoard
			, BindingResult error 
			,Model model
			,ResultMessageVO resultMessageVO) {
		if(error.hasErrors()) {
			return "/free/freeForm";
		}

		try{
			if(freeBoard.getBoTitle() != null && ! freeBoard.getBoTitle().equals("") ) {
				freeBoardService.registerBoard(freeBoard);
			}else {
				throw new Exception();
			}
			return "redirect:/free/freeList";
		}catch(Exception de){
			resultMessageVO.failSetting(false
					, "게시글 등록 실패"
					, "게시글 등록 실패 하였습니다. 전산실에 문의 부탁드립니다. 042-719-8850");
			de.printStackTrace();
		}
		model.addAttribute("resultMessageVO", resultMessageVO);
		return "/common/message";
		
	}
	

	@RequestMapping("/freeView")
	public String freeView(@ModelAttribute("searchVO") FreeBoardSearchVO searchVO, @RequestParam String boNo ,Model model) {
		try{
			FreeBoardVO freeBoard = freeBoardService.getBoard(boNo);
			freeBoardService.increaseHit(boNo);
			model.addAttribute("freeBoard", freeBoard);
		}catch(BizNotEffectedException bne){
			model.addAttribute("bne", bne);
			bne.printStackTrace();
		}catch(Exception de){
			model.addAttribute("de", de);
			de.printStackTrace();
		}
		
		return "/free/freeView";
	}
	

	@RequestMapping("/freeEdit")
	public String freeEdit(@ModelAttribute("searchVO") FreeBoardSearchVO searchVO, @RequestParam String boNo, Model model) {
		try{
			FreeBoardVO freeBoard = freeBoardService.getBoard(boNo);
			freeBoardService.increaseHit(boNo);
			System.out.println("freeBoard: "+ freeBoard.toString());
			model.addAttribute("freeBoard", freeBoard);
		}catch(BizNotEffectedException bne){
			model.addAttribute("bne", bne);
			bne.printStackTrace();
		}catch(Exception de){
			model.addAttribute("de", de);
			de.printStackTrace();
		}
		return "/free/freeEdit";
	}
	
	
	@RequestMapping("/freeModify")
	public String freeModify(@Validated(value = FreeModify.class) @ModelAttribute("freeBoard") FreeBoardVO freeBoard
			,BindingResult error
			, Model model
			, ResultMessageVO resultMessageVO) {

		if(error.hasErrors()) {
			return "/free/freeEdit";
		}
		try{
			if( freeBoard.getBoNo()!= null && ! freeBoard.getBoNo().equals("") ) {
				freeBoardService.modifyBoard(freeBoard);
			}else {
				throw new Exception();
			}
			return "redirect:/free/freeView?boNo="+freeBoard.getBoNo();
			
		}catch(BizPasswordNotMatchedException bpn){
			resultMessageVO.failSetting(false
					, "게시글 수정 실패"
					, "입력하신 비밀번호가 올바르지 않습니다. 다시 입력해주세요");
			bpn.printStackTrace();
		}catch(Exception de){
			resultMessageVO.failSetting(false
					, "게시글 수정 실패"
					, "게시글 수정 실패 하였습니다. 전산실에 문의 부탁드립니다. 042-719-8850");
			de.printStackTrace();
		}
		
		model.addAttribute("resultMessageVO", resultMessageVO);
		return "/common/message";
	}

	
	
	@RequestMapping("/freeDelete")
	public String freeDelete(@ModelAttribute FreeBoardVO freeBoard
			, Model model
			, ResultMessageVO resultMessageVO) {
		try{
			if( freeBoard.getBoNo()!= null && ! freeBoard.getBoNo().equals("") ) {
				freeBoardService.deleteBoard(freeBoard);
			}else {
				throw new Exception();
			}
			return "redirect:/free/freeList";
			
		}catch(BizPasswordNotMatchedException bpn){
			resultMessageVO.failSetting(false
					, "게시글 삭제 실패"
					, "입력하신 비밀번호가 올바르지 않습니다. 다시 입력해주세요");
			bpn.printStackTrace();
		}catch(Exception de){
			resultMessageVO.failSetting(false
					, "게시글 삭제 실패"
					, "게시글 삭제 실패 하였습니다. 전산실에 문의 부탁드립니다. 042-719-8850");
			de.printStackTrace();
		}
		model.addAttribute("resultMessageVO", resultMessageVO);
		return "/common/message";
	}
	

	@RequestMapping("/freeHide")
	public String freeHide(@RequestParam String memId
			, @RequestParam String boNo
			, Model model
			, ResultMessageVO resultMessageVO) {
		try{
			if( boNo != null && ! boNo.equals("") ) {   
				freeBoardService.hideBoard(memId, boNo);
			}else {
				throw new BizNotEffectedException();
			}
			return "redirect:/free/freeList";
		}catch(Exception de){
			resultMessageVO.failSetting(false
					, "게시글 숨김 실패"
					, "게시글 숨김 실패 하였습니다. 전산실에 문의 부탁드립니다. 042-719-8850");
			de.printStackTrace();
		}
		model.addAttribute("resultMessageVO", resultMessageVO);
		return "/common/message";
		
	}
	
}