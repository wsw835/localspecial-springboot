
package com.wsw.entity.db;

import lombok.ToString;

@ToString
public class User {
   public Integer uId;

   public String uName;

   public String uRealname;

   public String uTelephone;

   public String uPassword;

   public Integer uIsbusiness;

   public String uShop;

    public User(String uName, String uRealname, String uTelephone, String uPassword) {
        this.uName = uName;
        this.uRealname = uRealname;
        this.uTelephone = uTelephone;
        this.uPassword = uPassword;
    }

    public User(String uName) {
        this.uName = uName;
    }

    public User() {
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuRealname() {
        return uRealname;
    }

    public void setuRealname(String uRealname) {
        this.uRealname = uRealname;
    }

    public String getuTelephone() {
        return uTelephone;
    }

    public void setuTelephone(String uTelephone) {
        this.uTelephone = uTelephone;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public Integer getuIsbusiness() {
        return uIsbusiness;
    }

    public void setuIsbusiness(Integer uIsbusiness) {
        this.uIsbusiness = uIsbusiness;
    }

    public String getuShop() {
        return uShop;
    }

    public void setuShop(String uShop) {
        this.uShop = uShop;
    }
}
