package kr.or.nextit.code.service;

import java.util.List;

import kr.or.nextit.code.vo.CodeVO;

public interface ICommCodeService {

	public List<CodeVO> getCodeListByParent(String commParent);
}
