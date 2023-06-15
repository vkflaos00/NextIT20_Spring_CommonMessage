package kr.or.nextit.common.vo;

public class PagingVO {

	private int curPage=1;           // 페이지 번호 ( 목록페이지 처음 요청때문에 초기값을 1으로 세팅 )
	private int rowSizePerPage=10;   // 한 페이지당 게시글 수  ( 기본 10 )
	private int pageSize=10;         // 리스트 하단에 보여줄 페이지 링크 갯수  ( 보통 10 )  
	private int totalRowCount ;      // 총 게시글 수 
	private int firstRow ;           // 해당 페이지의 시작 글 번호    
	private int lastRow;             // 해당 페이지의 마지막 글 번호  
	private int firstPage; 	         // 하단 페이지링크에서 시작  페이지 번호     
	private int lastPage;            // 하단 페이지링크에서 마지막 페이지 번호  
	private int totalPageCount;      // 하단 총 페이지링크 건수 
	
	public void pageSetting() {
		firstRow = totalRowCount - ( curPage -1 ) * rowSizePerPage ;
		lastRow = firstRow - (rowSizePerPage -1);
		if(lastRow < 0) {
			lastRow= 1 ;
		}
		totalPageCount=(totalRowCount-1)/rowSizePerPage +1;
		firstPage = (curPage-1)/pageSize*pageSize +1;
		lastPage = firstPage + pageSize -1;
		if(lastPage > totalPageCount) {
			lastPage = totalPageCount ; 
		}
	
	}
	
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getRowSizePerPage() {
		return rowSizePerPage;
	}
	public void setRowSizePerPage(int rowSizePerPage) {
		this.rowSizePerPage = rowSizePerPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRowCount() {
		return totalRowCount;
	}
	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
	}
	public int getFirstRow() {
		return firstRow;
	}
	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}
	public int getLastRow() {
		return lastRow;
	}
	public void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	@Override
	public String toString() {
		return "PagingVO [curPage=" + curPage + ", rowSizePerPage=" + rowSizePerPage + ", pageSize=" + pageSize
				+ ", totalRowCount=" + totalRowCount + ", firstRow=" + firstRow + ", lastRow=" + lastRow
				+ ", firstPage=" + firstPage + ", lastPage=" + lastPage + ", totalPageCount=" + totalPageCount + "]";
	}
	
	

}
