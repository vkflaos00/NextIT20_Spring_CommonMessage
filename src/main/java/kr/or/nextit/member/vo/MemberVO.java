package kr.or.nextit.member.vo;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import kr.or.nextit.common.valid.MemberModify;
import kr.or.nextit.common.valid.MemberRegister;
import kr.or.nextit.common.vo.UserRoleVO;

public class MemberVO {

	//@NotEmpty(message="회원 아이디는 필수 입니다.")
	//@Size(min = 4, max = 10, message = "아이디는 영문,숫자 조합 4~10자로 입력해주세요")
	@Pattern(regexp = "^\\w{4,10}$"
			, message = "아이디는 영문,숫자 조합 4~10자로 입력해주세요"
			, groups = MemberRegister.class)
	private String memId;                 
	
	@Pattern(regexp = "^\\w{4,10}$"
			, message = "패스워드 영문,숫자 조합 4~10자로 입력해주세요"
			, groups = {MemberRegister.class, MemberModify.class})
	private String memPass;               
	
	@Size(min = 1, max = 40
			, message = "이름은 40자 이내로 입력해주세요"
			, groups = {MemberRegister.class, MemberModify.class})
	private String memName;               
	
	@NotEmpty(message = "생년월일을 입력해주세요")
	private String memBir;                
	
	@Positive(message = "숫자로만 입력해주세요")
	@Size(min = 5, max = 5, message = "우편번호는 5자리 입니다.")
	private String memZip;                
	
	private String memAdd1;               
	private String memAdd2;               
	
	@Pattern(regexp = "^[0-9]{10,11}$", message = "휴대폰 번호는 10또는 11자리 숫자로 입력해주세요")
	private String memHp;                 
	
	@NotEmpty(message = "이메일을 입력해주세요")
	@Email(message = "이메일 형식에 맞춰주세요")
	private String memMail;              
	
	@NotEmpty(message = "직업을 입력해주세요")
	private String memJob;     
	
	@NotEmpty(message = "취미를 입력해주세요")
	private String memHobby;  
	
	private int memMileage;               
	private String memDelYn;              
	private String memJoinDate;           
	private String memEditDate;           
	
	@Pattern(regexp = "^\\w{4,10}$"
			, message = "패스워드 영문,숫자 조합 4~10자로 입력해주세요"
			, groups = MemberModify.class)
	private String memPassNew;                     
	
	private String rememberMe;
	private List<UserRoleVO> userRoleList;
	private String rnum;
	 
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public List<UserRoleVO> getUserRoleList() {
		return userRoleList;
	}
	public void setUserRoleList(List<UserRoleVO> userRoleList) {
		this.userRoleList = userRoleList;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPass() {
		return memPass;
	}
	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemBir() {
		return memBir;
	}
	public void setMemBir(String memBir) {
		this.memBir = memBir;
	}
	public String getMemZip() {
		return memZip;
	}
	public void setMemZip(String memZip) {
		this.memZip = memZip;
	}
	public String getMemAdd1() {
		return memAdd1;
	}
	public void setMemAdd1(String memAdd1) {
		this.memAdd1 = memAdd1;
	}
	public String getMemAdd2() {
		return memAdd2;
	}
	public void setMemAdd2(String memAdd2) {
		this.memAdd2 = memAdd2;
	}
	public String getMemHp() {
		return memHp;
	}
	public void setMemHp(String memHp) {
		this.memHp = memHp;
	}
	public String getMemMail() {
		return memMail;
	}
	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}
	public String getMemJob() {
		return memJob;
	}
	public void setMemJob(String memJob) {
		this.memJob = memJob;
	}
	public String getMemHobby() {
		return memHobby;
	}
	public void setMemHobby(String memHobby) {
		this.memHobby = memHobby;
	}
	public int getMemMileage() {
		return memMileage;
	}
	public void setMemMileage(int memMileage) {
		this.memMileage = memMileage;
	}
	public String getMemDelYn() {
		return memDelYn;
	}
	public void setMemDelYn(String memDelYn) {
		this.memDelYn = memDelYn;
	}
	public String getMemJoinDate() {
		return memJoinDate;
	}
	public void setMemJoinDate(String memJoinDate) {
		this.memJoinDate = memJoinDate;
	}
	public String getMemEditDate() {
		return memEditDate;
	}
	public void setMemEditDate(String memEditDate) {
		this.memEditDate = memEditDate;
	}
	public String getMemPassNew() {
		return memPassNew;
	}
	public void setMemPassNew(String memPassNew) {
		this.memPassNew = memPassNew;
	}
	public String getRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}
	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memPass=" + memPass + ", memName=" + memName + ", memBir=" + memBir
				+ ", memZip=" + memZip + ", memAdd1=" + memAdd1 + ", memAdd2=" + memAdd2 + ", memHp=" + memHp
				+ ", memMail=" + memMail + ", memJob=" + memJob + ", memHobby=" + memHobby + ", memMileage="
				+ memMileage + ", memDelYn=" + memDelYn + ", memJoinDate=" + memJoinDate + ", memEditDate="
				+ memEditDate + ", memPassNew=" + memPassNew + ", rememberMe=" + rememberMe + ", userRoleList="
				+ userRoleList + ", rnum=" + rnum + "]";
	}
 
	
	
}
