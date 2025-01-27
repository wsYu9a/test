package com.martian.mibook.lib.account.request;

import com.martian.libcomm.http.requests.d.a;

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
    private String qq_appid;

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

    public String getQq_appid() {
        return this.qq_appid;
    }

    public String getQq_openid() {
        return this.qq_openid;
    }

    public String getQq_pf() {
        return this.qq_pf;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "qq_login.do";
    }

    public String getWx_openid() {
        return this.wx_openid;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override // com.martian.libmars.comm.request.MTHttpGetParams
    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setQQGender(String qqGender) {
        if (qqGender.equals("男")) {
            this.gender = "M";
        } else if (qqGender.equals("女")) {
            this.gender = "F";
        } else {
            this.gender = "N";
        }
    }

    public void setQq_access_token(String qq_access_token) {
        this.qq_access_token = qq_access_token;
    }

    public void setQq_appid(String qq_appid) {
        this.qq_appid = qq_appid;
    }

    public void setQq_openid(String qq_openid) {
        this.qq_openid = qq_openid;
    }

    public void setQq_pf(String qq_pf) {
        this.qq_pf = qq_pf;
    }

    public void setWx_openid(String wx_openid) {
        this.wx_openid = wx_openid;
    }
}
