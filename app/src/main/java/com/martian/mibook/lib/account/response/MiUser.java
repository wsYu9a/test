package com.martian.mibook.lib.account.response;

import android.text.TextUtils;
import com.martian.libsupport.h;
import com.martian.rpauth.b;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class MiUser implements b {
    private Date createdOn;

    @h.a
    private Boolean guest;

    @h.a
    private Integer vcontributed;

    @h.a
    private List<MiVContributor> vcontributors;

    @h.a
    private Boolean weixinBound;

    @h.a
    private Long uid = -1L;

    @h.a
    private String username = "";

    @h.a
    private Character gender = 'N';

    @h.a
    private String header = "";
    private String wx_openid = "";
    private String qq_openid = "";

    @h.a
    private String mobile = "";

    @h.a
    private String email = "";

    @h.a
    private String device_id = "";
    private String password = "";

    @h.a
    private String nickname = "";

    @h.a
    private String province = "";

    @h.a
    private String city = "";

    @h.a
    private String country = "";

    @h.a
    private String token = "";

    @h.a
    private Integer vcount = 0;

    @h.a
    private Boolean loggingOff = Boolean.FALSE;

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
        return null;
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

    public Boolean getLoggingOff() {
        return this.loggingOff;
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

    @Override // com.martian.rpauth.b
    public Integer getVcount() {
        return this.vcount;
    }

    @Override // com.martian.rpauth.b
    public Long getVipStartTime() {
        return null;
    }

    public boolean getWeixinBound() {
        Boolean bool = this.weixinBound;
        return bool == null || bool.booleanValue();
    }

    @Override // com.martian.rpauth.b
    public String getWx_openid() {
        return this.wx_openid;
    }

    @Override // com.martian.rpauth.b
    public boolean isFemale() {
        return this.gender.charValue() == 'F';
    }

    public boolean isGuest() {
        Boolean bool = this.guest;
        return bool != null && bool.booleanValue();
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

    public void setGuest(Boolean guest) {
        this.guest = guest;
    }

    @Override // com.martian.rpauth.b
    public void setHeader(String header) {
        this.header = header;
    }

    public void setLoggingOff(Boolean loggingOff) {
        this.loggingOff = loggingOff;
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
        if (TextUtils.isEmpty(qqGender)) {
            this.gender = 'M';
            return;
        }
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

    public void setVcontributors(List<MiVContributor> vcontributors) {
        this.vcontributors = vcontributors;
    }

    @Override // com.martian.rpauth.b
    public void setVcount(Integer vcount) {
        this.vcount = vcount;
    }

    @Override // com.martian.rpauth.b
    public void setVipStartTime(Long vip_start_time) {
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

    public void setWeixinBound(Boolean weixinBound) {
        this.weixinBound = weixinBound;
    }

    @Override // com.martian.rpauth.b
    public void setWx_openid(String wx_openid) {
        this.wx_openid = wx_openid;
    }
}
