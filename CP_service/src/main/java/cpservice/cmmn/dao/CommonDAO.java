package cpservice.cmmn.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import cpservice.cmmn.domain.User;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository
public class CommonDAO extends EgovAbstractMapper {
	

	@SuppressWarnings("deprecation")
	public List<?> boardList(User vo) throws Exception{
		System.out.println("5");
		return list("boardList", vo);
	}

    
    
	
}
