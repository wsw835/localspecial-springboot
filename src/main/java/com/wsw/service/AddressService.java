package com.wsw.service;

import com.wsw.entity.db.Address;
import com.wsw.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressMapper addressMapper;

    public List<Address> selectAll(int uid) {
        List<Address> list = addressMapper.selectAll(uid);
        return list;
    }

    public void insert(Address address) {
        addressMapper.insert(address);
    }

    public void delete(String aid) {
        addressMapper.delete(aid);
    }

    public void update() {
        addressMapper.update();
    }
}
