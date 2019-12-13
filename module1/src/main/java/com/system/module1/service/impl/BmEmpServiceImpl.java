package com.system.module1.service.impl;

import com.system.module1.dao.BmEmpDao;
import com.system.module1.entity.BmEmp;
import com.system.module1.service.BmEmpService;
import com.system.module1.util.EmpUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: dapeng_lgq
 * @since: JDK-1.8
 * @author: dapeng-liguoqing
 * @create: 2019/12/11 11:22
 * @version: 1.0
 * @description:
 **/
@Service
public class BmEmpServiceImpl implements BmEmpService {

    @Resource
    private BmEmpDao bmEmpDao;

    @Override
    public List<BmEmp> findVlookupBmEmp(EmpUtil bmEmp) {
        return bmEmpDao.findVlookupBmEmp(bmEmp);
    }
}
