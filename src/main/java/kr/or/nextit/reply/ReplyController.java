package kr.or.nextit.reply;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.nextit.exception.BizNotEffectedException;
import kr.or.nextit.member.vo.MemberVO;
import kr.or.nextit.reply.service.IReplyService;
import kr.or.nextit.reply.vo.ReplyPagingVO;
import kr.or.nextit.reply.vo.ReplyVO;

@Controller
@RequestMapping("/reply")
public class ReplyController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//@Autowired
	//@Inject
	@Resource(name="replyService")
	private IReplyService replyService; 
	
	
	@RequestMapping("/replyRegister")
	public String replyRegister(@ModelAttribute ReplyVO reply) {
		logger.info("ReplyController replyRegister reply.toString()"
				+ reply.toString());
		try {
			replyService.replyRegister(reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/free/freeView";
	}

	@RequestMapping(value="/replyList", produces = "application/json;charset=utf-8")
	@ResponseBody
	//public List<ReplyVO> replyList(@ModelAttribute ReplyVO reply) {
	//public List<ReplyVO> replyList(@ModelAttribute ReplyPagingVO replyPagingVO) {
	public ReplyPagingVO replyList(@ModelAttribute ReplyPagingVO replyPagingVO) {
		logger.info("ReplyController replyList reply.toString"
						+ replyPagingVO.toString());
		
		
		
		//List<ReplyVO> replyList = replyService.getReplyListByParent(reply);
		List<ReplyVO> replyList = replyService.getReplyListByParent(replyPagingVO);
		replyPagingVO.setReplyList(replyList);
		
		logger.info("replyPagingVO.toString(): "+ replyPagingVO.toString());
		
		return replyPagingVO;
	}

	
	
	@RequestMapping("/replyDelete")
	@ResponseBody
	//public String replyDelete(@ModelAttribute ReplyVO reply
	public Map<String, Object> replyDelete(@ModelAttribute ReplyVO reply
			, HttpSession session) {
		logger.info("ReplyController replyDelete reply.toString"
				+ reply.toString());
		
		//작성자가 맞는지 검증
		MemberVO member = (MemberVO) session.getAttribute("memberVO");
		logger.info("replyDelete member.getMemId(): "+member.getMemId());
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(reply.getReMemId() != null && reply.getReMemId().equals(member.getMemId())) {
			try {
				replyService.replyDelete(reply);
				
				map.put("result", true);
			} catch (BizNotEffectedException e) {
				e.printStackTrace();
				map.put("result", false);
			}
		}
		//return "/free/freeView";
		return map;
	}
	
	
	@RequestMapping("/replyUpdate")
	@ResponseBody
	public Map<String, Object> replyUpdate(@ModelAttribute ReplyVO replyVO, HttpServletRequest request) {
		logger.info("replyVO.getReNo(): " + replyVO.getReNo() );
		
		replyVO.setReIp(request.getRemoteAddr());
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			replyService.replyUpdate(replyVO);
			map.put("result", true);
		} catch (BizNotEffectedException e) {
			e.printStackTrace();
			map.put("result", false);
		}
		return map;
	}
	
}
