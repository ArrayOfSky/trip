package com.cust.trip.dao;

import com.cust.trip.bean.Kind;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KindMapper {

    List<Kind> selectAll();

    void insertKind(Kind kind);

    void deleteKind(String name);

    void updateKind(Kind kind);
}
