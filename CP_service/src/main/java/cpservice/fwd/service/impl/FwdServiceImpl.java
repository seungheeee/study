package cpservice.fwd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cpservice.cmmn.dao.CommonDAO;
import cpservice.cmmn.domain.User;
import cpservice.fwd.service.FwdService;
import cpservice.fwd.service.FwdVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("fwdService")
public class FwdServiceImpl extends EgovAbstractServiceImpl implements FwdService {
	
	@Resource(name = "commonDAO")
    public CommonDAO dao;

	@Override
    public List<?> boardList(User vo) throws Exception {
		 System.out.println("4");
        return dao.boardList(vo);
    }




}
