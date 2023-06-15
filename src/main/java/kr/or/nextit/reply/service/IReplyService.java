package kr.or.nextit.reply.service;

import java.util.List;

import kr.or.nextit.exception.BizNotEffectedException;
import kr.or.nextit.reply.vo.ReplyPagingVO;
import kr.or.nextit.reply.vo.ReplyVO;

public interface IReplyService {

	void replyRegister(ReplyVO reply) throws BizNotEffectedException;

	//List<ReplyVO> getReplyListByParent(ReplyVO reply);
	List<ReplyVO> getReplyListByParent(ReplyPagingVO replyPagingVO);

	void replyDelete(ReplyVO reply) throws BizNotEffectedException;
	
	void replyUpdate(ReplyVO replyVO) throws BizNotEffectedException;

}
