package com.cust.trip.service.impl;

import com.cust.trip.bean.Kind;
import com.cust.trip.service.KindService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GYF
 * @Data 2022.9.9
 */
@Service
public class KindServiceImpl implements KindService {

    @Override
    public int addKind(Kind kind) {
        return 0;
    }

    @Override
    public int deleteKind(String name) {
        return 0;
    }

    @Override
    public List<Kind> selectAllKind() {
        return null;
    }

    @Override
    public Kind selectKindByName(String name) {
        return null;
    }

    @Override
    public int updateKind(String name1, String name2) {
        return 0;
    }

}
