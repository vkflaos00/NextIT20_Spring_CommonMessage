package kr.or.nextit.free.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nextit.common.util.NextITSqlSessionFactory;
import kr.or.nextit.exception.BizNotEffectedException;
import kr.or.nextit.exception.BizNotFoundException;
import kr.or.nextit.exception.BizPasswordNotMatchedException;
import kr.or.nextit.free.mapper.IFreeBoardMapper;
import kr.or.nextit.free.vo.FreeBoardSearchVO;
import kr.or.nextit.free.vo.FreeBoardVO;

@Service("freeBoardService")
public class FreeBoardServiceImpl implements IFreeBoardService {

	//SqlSessionFactory sqlSessionFactory = NextITSqlSessionFactory.getSqlSessionFactory();
	
	@Autowired
	private IFreeBoardMapper freeMapper;

	@Override
	public void registerBoard(FreeBoardVO freeBoard) throws BizNotEffectedException {
		// TODO Auto-generated method stub
		System.out.println("FreeBoardServiceImpl registerBoard");
		
			
		String boNo = freeMapper.getFreeBoardKey();
		System.out.println("boNo: "+ boNo);
		freeBoard.setBoNo(boNo);
		
		int resultCnt = freeMapper.insertBoard(freeBoard);
		
		if(resultCnt != 1) {
			throw new BizNotEffectedException();
		}
	}


	@Override
	public List<FreeBoardVO> getBoardList(FreeBoardSearchVO searchVO) throws BizNotEffectedException {
		// TODO Auto-generated method stub
			
		int totalRowCount = freeMapper.getTotalRowCount(searchVO);
		
		searchVO.setTotalRowCount(totalRowCount);
		searchVO.pageSetting();
		System.out.println("searchVO.toString() "+ searchVO.toString());
		
		List<FreeBoardVO> freeBoardList = freeMapper.getBaordList(searchVO);
		
		if(freeBoardList == null) {
			throw new BizNotEffectedException();
		}
		return freeBoardList;
	}

	@Override
	public FreeBoardVO getBoard(String boNo) throws BizNotEffectedException {
		// TODO Auto-generated method stub
				
		System.out.println("getBoard_boNo: "+ boNo);

		FreeBoardVO freeBoard = freeMapper.getBoard(boNo);
		
		if(freeBoard == null ) {
			throw new BizNotEffectedException();
		}
		return freeBoard;
	}


	@Override
	public void increaseHit(String boNo) throws BizNotEffectedException {
		// TODO Auto-generated method stub
	
		int cnt = freeMapper.increaseHit(boNo);
		
		if( cnt != 1) {
			throw new BizNotEffectedException();
		}
	}

	@Override
	public void modifyBoard(FreeBoardVO freeBoard) throws BizNotFoundException, BizPasswordNotMatchedException, BizNotEffectedException {
		// TODO Auto-generated method stub

		
		FreeBoardVO  vo = freeMapper.getBoard(freeBoard.getBoNo());
		if( vo==null) {
			throw new BizNotFoundException();
		}
		if(!vo.getBoPass().equals(freeBoard.getBoPass())) {
			throw new BizPasswordNotMatchedException();
		}
	
		int resultCnt = freeMapper.updateBoard(freeBoard);
		if(resultCnt != 1 ){ 
			throw new BizNotEffectedException(); 
		}

	}

	
	@Override
	public void deleteBoard(FreeBoardVO freeBoard) throws BizNotFoundException, BizPasswordNotMatchedException, BizNotEffectedException {
		// TODO Auto-generated method stub
		
		FreeBoardVO  vo = freeMapper.getBoard(freeBoard.getBoNo());
		if( vo==null) {
			throw new BizNotFoundException();
		}
		
		if(!vo.getBoPass().equals(freeBoard.getBoPass())) { 
			throw new BizPasswordNotMatchedException(); 
		}
	
		int resultCnt = freeMapper.deleteBoard(freeBoard); 
		if(resultCnt != 1 ){ 
			throw new BizNotEffectedException(); 
		}
	}


	@Override
	public void hideBoard(String memId, String boNo) throws BizNotEffectedException {
		// TODO Auto-generated method stub
			
		FreeBoardVO freeBoard = new FreeBoardVO();
		freeBoard.setBoWriter(memId);
		freeBoard.setBoNo(boNo);
		
		int checkAdmin = freeMapper.checkAdmin(freeBoard);
		if( checkAdmin != 1) {
			throw new BizNotEffectedException();
		}
		
		int resultCnt = freeMapper.deleteBoard(freeBoard); 
		if(resultCnt != 1 ){ 
			throw new BizNotEffectedException(); 
		}
	}

	
}
