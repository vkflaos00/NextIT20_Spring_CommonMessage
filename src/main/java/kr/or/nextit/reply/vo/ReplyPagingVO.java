package kr.or.nextit.reply.vo;

import java.util.List;

import kr.or.nextit.common.vo.PagingVO;

public class ReplyPagingVO extends PagingVO{
	
	private String reCategory;
	private String reParentNo;
	private List<ReplyVO> replyList;
	public String getReCategory() {
		return reCategory;
	}
	public void setReCategory(String reCategory) {
		this.reCategory = reCategory;
	}
	public String getReParentNo() {
		return reParentNo;
	}
	public void setReParentNo(String reParentNo) {
		this.reParentNo = reParentNo;
	}
	public List<ReplyVO> getReplyList() {
		return replyList;
	}
	public void setReplyList(List<ReplyVO> replyList) {
		this.replyList = replyList;
	}
	@Override
	public String toString() {
		return "ReplyPagingVO [reCategory=" + reCategory + ", reParentNo=" + reParentNo + ", replyList=" + replyList
				+ "]"
				+ super.toString();
	}
	
	
	

}
