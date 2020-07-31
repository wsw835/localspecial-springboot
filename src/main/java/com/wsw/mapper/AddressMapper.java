package com.wsw.mapper;

import com.wsw.entity.db.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface AddressMapper {

    void insert(Address address);

    List<Address> selectAll(int uid);

    void delete(@Param("aid") String aid);

    void update();
}