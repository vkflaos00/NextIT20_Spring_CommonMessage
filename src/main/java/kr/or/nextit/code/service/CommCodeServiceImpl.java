package kr.or.nextit.code.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.or.nextit.HomeController;
import kr.or.nextit.code.mapper.ICommCodeMapper;
import kr.or.nextit.code.vo.CodeVO;


//@Component
//@Controller
//@Repository
@Service("codeService")
public class CommCodeServiceImpl implements ICommCodeService{

	//private static final Logger logger = LoggerFactory.getLogger(CommCodeServiceImpl.class);
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	//@Autowired
	//private ICommCodeDao codeDao;
	
	@Autowired
	private ICommCodeMapper codeMapper;
	
	
	@Override
	public List<CodeVO> getCodeListByParent(String commParent) {
		
		logger.debug("(logger.debug) {}"
				, (commParent == null) ? "commParent is null ": commParent);
		logger.info("(logger.info) {}"
				, (commParent == null) ? "commParent is null ": commParent);
		
		List<CodeVO> codeList= codeMapper.getCodeListByParent(commParent);
		return codeList;
		
	}

	
	
}
