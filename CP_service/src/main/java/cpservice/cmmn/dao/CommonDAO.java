package cpservice.cmmn.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cpservice.cmmn.domain.User;
import cpservice.fwd.service.FwdVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Repository
public class CommonDAO extends EgovAbstractMapper {
	
	SqlSession sqlSession;

	@SuppressWarnings("deprecation")
	public List<?> boardList(User vo) throws Exception{
		System.out.println("5");
		return list("boardList", vo);
	}

    
    
	
}
