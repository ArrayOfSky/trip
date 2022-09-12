package com.cust.trip;

import com.cust.trip.bean.Status;
import com.cust.trip.service.impl.StatusServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TripApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void StatusControllerTest(){
        StatusServiceImpl statusService = new StatusServiceImpl();
        Status status  = new Status();
        status.setStatusKind("产品");
        status.setStatusDescription("销售中");
        int i  = statusService.insertStatus(status);
        System.out.println(i);
    }

}
