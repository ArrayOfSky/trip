package com.cust.trip.service.impl;
import com.cust.trip.bean.Manager;
import com.cust.trip.dao.ManagerMapper;
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
    public int login(Manager manager) {
        if(manager.getManagerPassword().isEmpty()||manager.getManagerAccount().isEmpty()){
            return 0;
        }
        Manager temp = managerMapper.selectManagerByAccount(manager.getManagerAccount());
        if(temp!=null&&manager.getManagerPassword().equals(temp.getManagerPassword())){
            return 1;
        }else{
            return 0;
        }
    }
}
