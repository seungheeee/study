package cpservice.fwd.service;

import java.util.List;

import cpservice.cmmn.domain.User;
import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface FwdService {

	 public List<?> boardList(User user) throws Exception;
	
}
