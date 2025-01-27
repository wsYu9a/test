package com.martian.rpauth.response;

import com.martian.libsupport.h;
import com.martian.rpauth.b;
import java.util.Date;
import java.util.List;

@h.b(name = "rocket.com.rpauth.response.MartianRPUser")
/* loaded from: classes4.dex */
public class MartianRPUser implements b {

    @h.a
    private String city;

    @h.a
    private String country;
    private Date createdOn;

    @h.a
    private Long deadline;

    @h.a
    private String device_id;

    @h.a
    private String email;

    @h.a
    private Character gender;

    @h.a
    private String header;

    @h.a
    private String mobile;

    @h.a
    private String nickname;
    private String password;

    @h.a
    private String province;
    private String qq_openid;

    @h.a
    private String token;

    @h.a
    private Long uid;

    @h.a
    private String username;

    @h.a
    private Integer vcontributed;

    @h.a
    private List<MartianVContributor> vcontributors;

    @h.a
    private Integer vcount = 0;

    @h.a
    private Long vip_start_time;
    private String wx_openid;

    @Override // com.martian.rpauth.b
    public String getCity() {
        return this.city;
    }

    @Override // com.martian.rpauth.b
    public String getCountry() {
        return this.country;
    }

    @Override // com.martian.rpauth.b
    public Date getCreatedOn() {
        return this.createdOn;
    }

    @Override // com.martian.rpauth.b
    public Long getDeadline() {
        return this.deadline;
    }

    @Override // com.martian.rpauth.b
    public String getDevice_id() {
        return this.device_id;
    }

    @Override // com.martian.rpauth.b
    public String getEmail() {
        return this.email;
    }

    @Override // com.martian.rpauth.b
    public Character getGender() {
        return this.gender;
    }

    @Override // com.martian.rpauth.b
    public String getHeader() {
        return this.header;
    }

    @Override // com.martian.rpauth.b
    public String getMobile() {
        return this.mobile;
    }

    @Override // com.martian.rpauth.b
    public String getNickname() {
        return this.nickname;
    }

    @Override // com.martian.rpauth.b
    public String getPassword() {
        return this.password;
    }

    @Override // com.martian.rpauth.b
    public String getProvince() {
        return this.province;
    }

    @Override // com.martian.rpauth.b
    public String getQQ_openid() {
        return this.qq_openid;
    }

    @Override // com.martian.rpauth.b
    public String getToken() {
        return this.token;
    }

    @Override // com.martian.rpauth.b
    public Long getUid() {
        return this.uid;
    }

    @Override // com.martian.rpauth.b
    public String getUsername() {
        return this.username;
    }

    @Override // com.martian.rpauth.b
    public Integer getVcontributed() {
        return this.vcontributed;
    }

    public List<MartianVContributor> getVcontributors() {
        return this.vcontributors;
    }

    @Override // com.martian.rpauth.b
    public Integer getVcount() {
        return this.vcount;
    }

    @Override // com.martian.rpauth.b
    public Long getVipStartTime() {
        return this.vip_start_time;
    }

    @Override // com.martian.rpauth.b
    public String getWx_openid() {
        return this.wx_openid;
    }

    @Override // com.martian.rpauth.b
    public boolean isFemale() {
        return this.gender.charValue() == 'F';
    }

    @Override // com.martian.rpauth.b
    public boolean isMale() {
        return this.gender.charValue() == 'M';
    }

    @Override // com.martian.rpauth.b
    public boolean isUnknownGender() {
        return this.gender.charValue() == 'N';
    }

    @Override // com.martian.rpauth.b
    public void setCity(String city) {
        this.city = city;
    }

    @Override // com.martian.rpauth.b
    public void setCountry(String country) {
        this.country = country;
    }

    @Override // com.martian.rpauth.b
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Override // com.martian.rpauth.b
    public void setDeadline(Long deadline) {
        this.deadline = deadline;
    }

    @Override // com.martian.rpauth.b
    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    @Override // com.martian.rpauth.b
    public void setEmail(String email) {
        this.email = email;
    }

    @Override // com.martian.rpauth.b
    public void setGender(char gender) {
        this.gender = Character.valueOf(gender);
    }

    @Override // com.martian.rpauth.b
    public void setHeader(String header) {
        this.header = header;
    }

    @Override // com.martian.rpauth.b
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override // com.martian.rpauth.b
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override // com.martian.rpauth.b
    public void setPassword(String password) {
        this.password = password;
    }

    @Override // com.martian.rpauth.b
    public void setProvince(String province) {
        this.province = province;
    }

    @Override // com.martian.rpauth.b
    public void setQQGender(String qqGender) {
        if (qqGender.equals("男")) {
            this.gender = 'M';
        } else if (qqGender.equals("女")) {
            this.gender = 'F';
        } else {
            this.gender = 'N';
        }
    }

    @Override // com.martian.rpauth.b
    public void setQQ_openid(String qq_openid) {
        this.qq_openid = qq_openid;
    }

    @Override // com.martian.rpauth.b
    public void setToken(String token) {
        this.token = token;
    }

    @Override // com.martian.rpauth.b
    public void setUid(Long uid) {
        this.uid = uid;
    }

    @Override // com.martian.rpauth.b
    public void setUsername(String username) {
        this.username = username;
    }

    @Override // com.martian.rpauth.b
    public void setVcontributed(Integer vcontributed) {
        this.vcontributed = vcontributed;
    }

    public void setVcontributors(List<MartianVContributor> vcontributors) {
        this.vcontributors = vcontributors;
    }

    @Override // com.martian.rpauth.b
    public void setVcount(Integer vcount) {
        this.vcount = vcount;
    }

    @Override // com.martian.rpauth.b
    public void setVipStartTime(Long vip_start_time) {
        this.vip_start_time = vip_start_time;
    }

    @Override // com.martian.rpauth.b
    public void setWXGender(int intGender) {
        if (intGender == 1) {
            this.gender = 'M';
        } else if (intGender == 2) {
            this.gender = 'F';
        } else {
            this.gender = 'N';
        }
    }

    @Override // com.martian.rpauth.b
    public void setWx_openid(String wx_openid) {
        this.wx_openid = wx_openid;
    }
}
