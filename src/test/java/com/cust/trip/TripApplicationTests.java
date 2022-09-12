package com.cust.trip;

import com.cust.trip.bean.Status;
import com.cust.trip.service.impl.StatusServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    void ProductServiceTest(){

    }

}
