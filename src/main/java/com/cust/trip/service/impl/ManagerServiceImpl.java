package com.cust.trip.service.impl;
import com.cust.trip.bean.Manager;
import com.cust.trip.dao.ManagerMapper;
import com.cust.trip.exceptionhandle.exception.manager.AccountInfoException;
import com.cust.trip.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author GYF
 * @Data 2022.9.14
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerMapper managerMapper;

    @Override
    public void login(Manager manager) {
        if(manager.getManagerPassword().isEmpty()||manager.getManagerAccount().isEmpty()){
            throw new AccountInfoException();
        }
        Manager temp = managerMapper.selectManagerByAccount(manager.getManagerAccount());
        if(temp==null||!(manager.getManagerPassword().equals(temp.getManagerPassword()))){
            throw new AccountInfoException();
        }
    }
}
