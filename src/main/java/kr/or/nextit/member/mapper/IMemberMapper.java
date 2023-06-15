package kr.or.nextit.member.mapper;

import java.util.List;

import javax.annotation.ManagedBean;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.nextit.common.vo.RoleInfoVO;
import kr.or.nextit.common.vo.UserRoleVO;
import kr.or.nextit.member.vo.MemberSearchVO;
import kr.or.nextit.member.vo.MemberVO;

@Mapper
public interface IMemberMapper {
	
	/**
	 * To get member information
	 * @author nextit
	 * @param memId
	 * @return MemberVO
	 */
	public MemberVO getMember(String memId);

	
	/**
	 * To insert member information
	 * @author nextit
	 * @param member
	 * @return int
	 */
	public int insertMember(MemberVO member);

	/**
	 * To insert memeber role
	 * @author nextit
	 * @param member
	 * @return int
	 */
	public int insertUserRole(MemberVO member);
	
	
	/**
	 * To check login
	 * @author nextit
	 * @param member
	 * @return MemberVO
	 */
	public MemberVO loginCheck(MemberVO member);

	/**
	 * To update member information
	 * @author nextit
	 * @param member
	 * @return int
	 */
	public int updateMember(MemberVO member);

	
	/**
	 * To delete member information
	 * @author nextit
	 * @param member
	 * @return int
	 */
	public int deleteMember(MemberVO member);

	/**
	 * To get user Role
	 * @author ssam
	 * @param member
	 * @return
	 */
	public List<UserRoleVO> getUserRole(MemberVO member);

	/**
	 * To get Member List
	 * @author ssam
	 * @param searchVO
	 * @return
	 */
	public List<MemberVO> getMemberList(MemberSearchVO searchVO);

	/**
	 * To get member count
	 * @author ssam
	 * @param searchVO
	 * @return
	 */
	public int getTotalRowCount(MemberSearchVO searchVO);


	public List<RoleInfoVO> getRoleInfo();

	
	/**
	 * To delete member role
	 * @author nextit
	 * @param memId
	 */
	public void deleteUserRole(String memId);
	
	/**
	 * To insert member role
	 * @author nextit
	 * @param memId
	 * @param role
	 */
	public void insertMultiRole(@Param("memId") String memId, @Param("role")String role);


	/**
	 * To check available id
	 * @author nextit
	 * @param memId
	 * @return int
	 */
	public int idCheck(String memId);

}
