package com.martian.rpauth.response;

import ba.j;
import java.util.Date;
import java.util.List;
import me.b;

@j.b(name = "rocket.com.rpauth.response.MartianRPUser")
/* loaded from: classes3.dex */
public class MartianRPUser implements b {

    @j.a
    private String city;

    @j.a
    private String country;
    private Date createdOn;

    @j.a
    private Long deadline;

    @j.a
    private String device_id;

    @j.a
    private String email;

    @j.a
    private Character gender;

    @j.a
    private String header;

    @j.a
    private String mobile;

    @j.a
    private String nickname;
    private String password;

    @j.a
    private String province;
    private String qq_openid;

    @j.a
    private String token;

    @j.a
    private Long uid;

    @j.a
    private String username;

    @j.a
    private Integer vcontributed;

    @j.a
    private List<MartianVContributor> vcontributors;

    @j.a
    private Integer vcount = 0;

    @j.a
    private Long vip_start_time;
    private String wx_openid;

    @Override // me.b
    public String getCity() {
        return this.city;
    }

    @Override // me.b
    public String getCountry() {
        return this.country;
    }

    @Override // me.b
    public Date getCreatedOn() {
        return this.createdOn;
    }

    @Override // me.b
    public Long getDeadline() {
        return this.deadline;
    }

    @Override // me.b
    public String getDevice_id() {
        return this.device_id;
    }

    @Override // me.b
    public String getEmail() {
        return this.email;
    }

    @Override // me.b
    public Character getGender() {
        return this.gender;
    }

    @Override // me.b
    public String getHeader() {
        return this.header;
    }

    @Override // me.b
    public String getMobile() {
        return this.mobile;
    }

    @Override // me.b
    public String getNickname() {
        return this.nickname;
    }

    @Override // me.b
    public String getPassword() {
        return this.password;
    }

    @Override // me.b
    public String getProvince() {
        return this.province;
    }

    @Override // me.b
    public String getQQ_openid() {
        return this.qq_openid;
    }

    @Override // me.b
    public String getToken() {
        return this.token;
    }

    @Override // me.b
    public Long getUid() {
        return this.uid;
    }

    @Override // me.b
    public String getUsername() {
        return this.username;
    }

    @Override // me.b
    public Integer getVcontributed() {
        return this.vcontributed;
    }

    public List<MartianVContributor> getVcontributors() {
        return this.vcontributors;
    }

    @Override // me.b
    public Integer getVcount() {
        return this.vcount;
    }

    @Override // me.b
    public Long getVipStartTime() {
        return this.vip_start_time;
    }

    @Override // me.b
    public String getWx_openid() {
        return this.wx_openid;
    }

    @Override // me.b
    public boolean isFemale() {
        return this.gender.charValue() == 'F';
    }

    @Override // me.b
    public boolean isMale() {
        return this.gender.charValue() == 'M';
    }

    @Override // me.b
    public boolean isUnknownGender() {
        return this.gender.charValue() == 'N';
    }

    @Override // me.b
    public void setCity(String str) {
        this.city = str;
    }

    @Override // me.b
    public void setCountry(String str) {
        this.country = str;
    }

    @Override // me.b
    public void setCreatedOn(Date date) {
        this.createdOn = date;
    }

    @Override // me.b
    public void setDeadline(Long l10) {
        this.deadline = l10;
    }

    @Override // me.b
    public void setDevice_id(String str) {
        this.device_id = str;
    }

    @Override // me.b
    public void setEmail(String str) {
        this.email = str;
    }

    @Override // me.b
    public void setGender(char c10) {
        this.gender = Character.valueOf(c10);
    }

    @Override // me.b
    public void setHeader(String str) {
        this.header = str;
    }

    @Override // me.b
    public void setMobile(String str) {
        this.mobile = str;
    }

    @Override // me.b
    public void setNickname(String str) {
        this.nickname = str;
    }

    @Override // me.b
    public void setPassword(String str) {
        this.password = str;
    }

    @Override // me.b
    public void setProvince(String str) {
        this.province = str;
    }

    @Override // me.b
    public void setQQGender(String str) {
        if (str.equals("男")) {
            this.gender = 'M';
        } else if (str.equals("女")) {
            this.gender = 'F';
        } else {
            this.gender = 'N';
        }
    }

    @Override // me.b
    public void setQQ_openid(String str) {
        this.qq_openid = str;
    }

    @Override // me.b
    public void setToken(String str) {
        this.token = str;
    }

    @Override // me.b
    public void setUid(Long l10) {
        this.uid = l10;
    }

    @Override // me.b
    public void setUsername(String str) {
        this.username = str;
    }

    @Override // me.b
    public void setVcontributed(Integer num) {
        this.vcontributed = num;
    }

    public void setVcontributors(List<MartianVContributor> list) {
        this.vcontributors = list;
    }

    @Override // me.b
    public void setVcount(Integer num) {
        this.vcount = num;
    }

    @Override // me.b
    public void setVipStartTime(Long l10) {
        this.vip_start_time = l10;
    }

    @Override // me.b
    public void setWXGender(int i10) {
        if (i10 == 1) {
            this.gender = 'M';
        } else if (i10 == 2) {
            this.gender = 'F';
        } else {
            this.gender = 'N';
        }
    }

    @Override // me.b
    public void setWx_openid(String str) {
        this.wx_openid = str;
    }
}
