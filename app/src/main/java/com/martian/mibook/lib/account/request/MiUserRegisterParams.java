package com.martian.mibook.lib.account.request;

import v8.a;

/* loaded from: classes3.dex */
public class MiUserRegisterParams extends TYHttpGetParams {

    @a
    private String city;

    @a
    private String country;

    @a
    private String device_id;

    @a
    private String gender;

    @a
    private String header;

    @a
    private String nickname;

    @a
    private String province;

    @a
    private String qq_access_token;

    @a
    private String qq_openid;

    @a
    private String qq_pf;

    @a
    private String wx_openid;

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    @Override // com.martian.libmars.comm.request.MTHttpGetParams
    public String getDevice_id() {
        return this.device_id;
    }

    public String getGender() {
        return this.gender;
    }

    public String getHeader() {
        return this.header;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getProvince() {
        return this.province;
    }

    public String getQq_access_token() {
        return this.qq_access_token;
    }

    public String getQq_openid() {
        return this.qq_openid;
    }

    public String getQq_pf() {
        return this.qq_pf;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "qq_login.do";
    }

    public String getWx_openid() {
        return this.wx_openid;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    @Override // com.martian.libmars.comm.request.MTHttpGetParams
    public void setDevice_id(String str) {
        this.device_id = str;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public void setHeader(String str) {
        this.header = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setQQGender(String str) {
        if (str.equals("男")) {
            this.gender = "M";
        } else if (str.equals("女")) {
            this.gender = "F";
        } else {
            this.gender = "N";
        }
    }

    public void setQq_access_token(String str) {
        this.qq_access_token = str;
    }

    public void setQq_openid(String str) {
        this.qq_openid = str;
    }

    public void setQq_pf(String str) {
        this.qq_pf = str;
    }

    public void setWx_openid(String str) {
        this.wx_openid = str;
    }
}
