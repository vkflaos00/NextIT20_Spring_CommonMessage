package kr.or.nextit.reply.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.nextit.reply.vo.ReplyPagingVO;
import kr.or.nextit.reply.vo.ReplyVO;

@Mapper
public interface IReplyMapper {

	int replyRegister(ReplyVO reply);

	int getTotalRowCount(ReplyPagingVO replyPagingVO);
	
	//List<ReplyVO> getReplyListByParent(ReplyVO reply);
	List<ReplyVO> getReplyListByParent(ReplyPagingVO replyPagingVO);

	int replyDelete(ReplyVO reply);
	
	int replyUpdate(ReplyVO replyVO);

}
