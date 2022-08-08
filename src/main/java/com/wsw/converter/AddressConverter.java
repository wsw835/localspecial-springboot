package com.wsw.converter;

import com.wsw.entity.db.Address;
import com.wsw.entity.vo.AddressVO;

public class AddressConverter {
    public static Address addressConverter(AddressVO addressVO, int uid) {
        Address address = new Address();
        address.setaAddr(addressVO.getAAddr());
        address.setaSenduser(addressVO.getASenduser());
        address.setaDetail(addressVO.getADetail());
        address.setaSendtel(addressVO.getASendtel());
        address.setaState(Integer.parseInt(addressVO.getAState()));
        address.setuId(uid);
        return address;
    }

}
