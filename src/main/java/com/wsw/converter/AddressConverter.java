/*
 * @(#) AddressConverter
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2019
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author 温思伟
 * <br> 2019-09-23 20:43:11
 */

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
