package kr.or.nextit.member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.nextit.common.vo.RoleInfoVO;
import kr.or.nextit.exception.BizDuplicateKeyException;
import kr.or.nextit.exception.BizNotEffectedException;
import kr.or.nextit.exception.BizNotFoundException;
import kr.or.nextit.exception.BizPasswordNotMatchedException;
import kr.or.nextit.member.vo.MemberSearchVO;
import kr.or.nextit.member.vo.MemberVO;

public interface IMemberService {

	/**
	 * To register member 
	 * @author nextit
	 * @param member
	 * @throws BizDuplicateKeyException
	 * @throws BizNotEffectedException
	 */
	public void registerMember(MemberVO member) throws BizDuplicateKeyException, BizNotEffectedException;
	
	/**
	 * To check login 
	 * @author nextit
	 * @param member
	 * @param request
	 * @param response
	 * @return 
	 * @throws BizNotEffectedException
	 */
	public boolean loginCheck(MemberVO member, HttpServletRequest request, HttpServletResponse response) throws BizNotEffectedException;

	/**
	 * To get member information
	 * @param memId
	 * @return MemberVO
	 * @throws BizNotEffectedException
	 */
	public MemberVO getMember(String memId) throws BizNotEffectedException;
		
		
	/**
	 * To update member information
	 * @author nextit
	 * @param member
	 * @throws BizNotFoundException
	 * @throws BizPasswordNotMatchedException
	 * @throws BizNotEffectedException
	 */
	public void modifyMember(MemberVO member) throws BizNotFoundException, BizPasswordNotMatchedException, BizNotEffectedException;

	
	/**
	 * To delete member information
	 * @author nextit
	 * @param member
	 * @throws BizNotFoundException
	 * @throws BizPasswordNotMatchedException
	 * @throws BizNotEffectedException
	 */
	public void removeMember(MemberVO member) throws BizNotFoundException, BizPasswordNotMatchedException, BizNotEffectedException;

	
	/**
	 * To get Member List
	 * @author ssam
	 * @param searchVO
	 * @return
	 * @throws BizNotFoundException
	 */
	public List<MemberVO> getMemberList(MemberSearchVO searchVO) throws BizNotFoundException;	
	
	/**
	 * To remove members 
	 * @author ssam
	 * @param memMultiId
	 * @throws BizNotEffectedException 
	 */
	public void removeMultiMember(String memMultiId) throws BizNotEffectedException;

	/**
	 * To get member role
	 * @author ssam
	 * @param memId
	 * @return
	 * @throws BizNotEffectedException 
	 */
	public MemberVO getMemberRole(String memId) throws BizNotEffectedException;

	/**
	 * To get role info list
	 * @author ssam
	 * @return List<RoleInfoVO>
	 * @throws BizNotEffectedException 
	 */
	public List<RoleInfoVO> getRoleInfo() throws BizNotEffectedException	;


	/**
	 * To update membr role
	 * @author nextit
	 * @param memId
	 * @param roles
	 * @throws BizNotEffectedException 
	 */
	public void updateUserRole(String memId, String[] roles) throws BizNotEffectedException;

	/**
	 * To check available id 
	 * @author nextit
	 * @param memId
	 * @return boolean
	 */
	public boolean idCheck(String memId);













}



