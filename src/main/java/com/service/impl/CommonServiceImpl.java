package com.service.impl;

import com.dao.CommonDao;
import com.service.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yuyu on 2017/4/18.
 */
@Service
public class CommonServiceImpl implements ICommonService {

    @Autowired
    private CommonDao commonDao;

    public void clean(Class clazz) {
        commonDao.clean(clazz);
    }

}
