package com.cust.trip;

import com.cust.trip.bean.Order;
import com.cust.trip.dao.OrderMapper;
import io.swagger.annotations.Api;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TripApplicationTest {
    @Autowired
    OrderMapper orderMapper;
    @Test
    public void testOrder(){
        ArrayList<Order> array = (ArrayList<Order>) orderMapper.getAllOrders();
        System.out.println(array);
    }
}
