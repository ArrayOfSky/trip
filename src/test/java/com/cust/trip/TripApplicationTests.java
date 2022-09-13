package com.cust.trip;

import com.cust.trip.bean.Kind;
import com.cust.trip.bean.Status;
import com.cust.trip.dao.KindMapper;
import com.cust.trip.service.impl.StatusServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class TripApplicationTests {

    @Autowired
    StatusServiceImpl statusService;

    @Test
    void contextLoads() {
    }

    @Test
    void StatusServiceTest(){
        Status status  = new Status();
        status.setStatusKind("产品");
        status.setStatusDescription("销售中");
        int i  = statusService.insertStatus(status);
        System.out.println(i);
    }

    @Autowired
    KindMapper kindMapper;
    @Test
    void ProductServiceTest(){
        Kind kind = kindMapper.selectKindByName("一日游");
        ArrayList<Kind> array = (ArrayList<Kind>) kindMapper.selectAll();
        System.out.println(kind);
        System.out.println(array);
    }

}
