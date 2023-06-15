package kr.or.nextit.free.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import kr.or.nextit.common.valid.FreeFrom;
import kr.or.nextit.common.valid.FreeModify;

public class FreeBoardVO {

	private String boNo;                    /* 글 번호 */

	@Size(min = 1, max = 200, message ="제목은 200글자 이내로 작성해주세요" 
			, groups = {FreeFrom.class, FreeModify.class })
	private String boTitle;                 /* 글 제목 */
	
	@NotEmpty(message = "글 분류 코드를 선택해주세요")
	private String boCategory;              /* 글 분류 코드 */
	
	@NotEmpty(message = "로그인 되어있지 않습니다. 로그인 해주세요")
	private String boWriter;                /* 작성자명 */

	@Pattern(regexp = "^\\w{4,20}$", message = "비밀번호는 알파벳과 숫자로 최소4글자 최대20글자 이내 입력해주세요" 
			, groups = {FreeFrom.class, FreeModify.class })
	private String boPass;                  /* 비밀번호 */
	
	@Size(min = 1, max = 5000, message ="내용은 5000글자 이내로 작성해주세요"
			, groups = FreeFrom.class)
	private String boContent;               /* 글 내용 */
	
	private String boIp;                    /* 등록자 IP */
	private int boHit;                      /* 조회수 */
	private String boRegDate;               /* 등록 일자 */
	private String boModDate;               /* 수정 일자 */
	private String boDelYn;                 /* 삭제 여부 */
	private String boDelId;                 /* 삭제 주체 */
	private String boDelDate;               /* 삭제 시간 */
	
	//boCategoryNm 추가
	private String boCategoryNm;					 
	
	//rnum 추가
	private String rnum; 
	
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public String getBoCategoryNm() {
		return boCategoryNm;
	}
	public void setBoCategoryNm(String boCategoryNm) {
		this.boCategoryNm = boCategoryNm;
	}
	
	
	public String getBoNo() {
		return boNo;
	}
	public void setBoNo(String boNo) {
		this.boNo = boNo;
	}
	public String getBoTitle() {
		return boTitle;
	}
	public void setBoTitle(String boTitle) {
		this.boTitle = boTitle;
	}
	public String getBoCategory() {
		return boCategory;
	}
	public void setBoCategory(String boCategory) {
		this.boCategory = boCategory;
	}
	public String getBoWriter() {
		return boWriter;
	}
	public void setBoWriter(String boWriter) {
		this.boWriter = boWriter;
	}
	public String getBoPass() {
		return boPass;
	}
	public void setBoPass(String boPass) {
		this.boPass = boPass;
	}
	public String getBoContent() {
		return boContent;
	}
	public void setBoContent(String boContent) {
		this.boContent = boContent;
	}
	public String getBoIp() {
		return boIp;
	}
	public void setBoIp(String boIp) {
		this.boIp = boIp;
	}
	public int getBoHit() {
		return boHit;
	}
	public void setBoHit(int boHit) {
		this.boHit = boHit;
	}
	public String getBoRegDate() {
		return boRegDate;
	}
	public void setBoRegDate(String boRegDate) {
		this.boRegDate = boRegDate;
	}
	public String getBoModDate() {
		return boModDate;
	}
	public void setBoModDate(String boModDate) {
		this.boModDate = boModDate;
	}
	public String getBoDelYn() {
		return boDelYn;
	}
	public void setBoDelYn(String boDelYn) {
		this.boDelYn = boDelYn;
	}
	public String getBoDelId() {
		return boDelId;
	}
	public void setBoDelId(String boDelId) {
		this.boDelId = boDelId;
	}
	public String getBoDelDate() {
		return boDelDate;
	}
	public void setBoDelDate(String boDelDate) {
		this.boDelDate = boDelDate;
	}
	@Override
	public String toString() {
		return "FreeBoardVO [boNo=" + boNo + ", boTitle=" + boTitle + ", boCategory=" + boCategory + ", boWriter="
				+ boWriter + ", boPass=" + boPass + ", boContent=" + boContent + ", boIp=" + boIp + ", boHit=" + boHit
				+ ", boRegDate=" + boRegDate + ", boModDate=" + boModDate + ", boDelYn=" + boDelYn + ", boDelId="
				+ boDelId + ", boDelDate=" + boDelDate + ", boCategoryNm=" + boCategoryNm + ", rnum=" + rnum + "]";
	}
 
	
	

	 
	
	
	
}