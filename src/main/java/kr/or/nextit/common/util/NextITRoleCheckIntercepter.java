package kr.or.nextit.common.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.or.nextit.common.vo.UserRoleVO;
import kr.or.nextit.member.vo.MemberVO;

public class NextITRoleCheckIntercepter extends HandlerInterceptorAdapter{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//return super.preHandle(request, response, handler);
		
		//HttpSession session = request.getSession();
		//MemberVO member = (MemberVO) session.getAttribute("memberVO");
		
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("memberVO");
		
		if(member == null) {
			logger.info("(NextITRoleCheckIntercepter_preHandle) member is null");
			response.sendRedirect(request.getContextPath()+"/login/none");
			return false;
		}
		
		logger.info("NextITRoleCheckIntercepter member.toString():" 
				+ member.toString() );
		
		List<UserRoleVO> userRoleList =  member.getUserRoleList();
		
		for(UserRoleVO vo : userRoleList) {
			if("AD".equals( vo.getUserRole() )){
				return true;
			}
		}

		logger.info("(NextITRoleCheckIntercepter) Your Role is not Admin");
		response.sendError(403);
		return false;
	}

}
