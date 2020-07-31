/*
 * @(#) Orderdetail
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2019
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author 温思伟
 * <br> 2019-11-23 10:45:13
 */

package com.wsw.entity.db;

import java.util.Date;

import lombok.ToString;

@ToString
public class Orderdetail {
   public Integer odId;

   public Date odDate;

   public String odState;

   public Double odTotal;

   public Integer odCount;

   public Integer orId;

    public Orderdetail(Double odTotal, Integer orId, Integer odCount) {
        this.odTotal = odTotal;
        this.orId = orId;
        this.odCount = odCount;
    }

    public Orderdetail() {
    }

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public Date getOdDate() {
        return odDate;
    }

    public void setOdDate(Date odDate) {
        this.odDate = odDate;
    }

    public String getOdState() {
        return odState;
    }

    public void setOdState(String odState) {
        this.odState = odState;
    }

    public Double getOdTotal() {
        return odTotal;
    }

    public void setOdTotal(Double odTotal) {
        this.odTotal = odTotal;
    }

    public Integer getOdCount() {
        return odCount;
    }

    public void setOdCount(Integer odCount) {
        this.odCount = odCount;
    }

    public Integer getOrId() {
        return orId;
    }

    public void setOrId(Integer orId) {
        this.orId = orId;
    }
}