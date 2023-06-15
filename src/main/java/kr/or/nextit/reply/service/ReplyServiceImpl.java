package kr.or.nextit.reply.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nextit.exception.BizNotEffectedException;
import kr.or.nextit.reply.mapper.IReplyMapper;
import kr.or.nextit.reply.vo.ReplyPagingVO;
import kr.or.nextit.reply.vo.ReplyVO;

@Service("replyService")
public class ReplyServiceImpl implements IReplyService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private IReplyMapper replyMapper;
	
	@Override
	public void replyRegister(ReplyVO reply) throws BizNotEffectedException {
		// TODO Auto-generated method stub
		
		int cnt = replyMapper.replyRegister(reply);
		logger.info("ReplyServiceImpl replyRegister cnt :"+ cnt);
		
		if(cnt !=1) {
			throw new BizNotEffectedException();
		}
	}

	@Override
	//public List<ReplyVO> getReplyListByParent(ReplyVO reply) {
	public List<ReplyVO> getReplyListByParent(ReplyPagingVO replyPagingVO) {
		// TODO Auto-generated method stub
		
		//List<ReplyVO> replyList = replyMapper.getReplyListByParent(reply);

		int totalRowCount = replyMapper.getTotalRowCount(replyPagingVO);	
		replyPagingVO.setTotalRowCount(totalRowCount);
		replyPagingVO.pageSetting();
		
		List<ReplyVO> replyList = replyMapper.getReplyListByParent(replyPagingVO);
		
		logger.info("ReplyServiceImpl getReplyListByParent replyList"+replyList);
	
		return replyList;
	}

	@Override
	public void replyDelete(ReplyVO reply) throws BizNotEffectedException {
		// TODO Auto-generated method stub
		
		int cnt = replyMapper.replyDelete(reply);
		
		if(cnt != 1) {
			throw new BizNotEffectedException();
		}
	}
	
	@Override
	public void replyUpdate(ReplyVO replyVO) throws BizNotEffectedException {
		int cnt = replyMapper.replyUpdate(replyVO);
		logger.info("replyUpdate_cnt: "+ cnt);
		if( cnt != 1) {
			throw new BizNotEffectedException();
		}
	}
}
