package com.martian.rpauth;

import java.util.Date;

/* loaded from: classes.dex */
public interface b {
    String getCity();

    String getCountry();

    Date getCreatedOn();

    Long getDeadline();

    String getDevice_id();

    String getEmail();

    Character getGender();

    String getHeader();

    String getMobile();

    String getNickname();

    String getPassword();

    String getProvince();

    String getQQ_openid();

    String getToken();

    Long getUid();

    String getUsername();

    Integer getVcontributed();

    Integer getVcount();

    Long getVipStartTime();

    String getWx_openid();

    boolean isFemale();

    boolean isMale();

    boolean isUnknownGender();

    void setCity(String city);

    void setCountry(String country);

    void setCreatedOn(Date createdOn);

    void setDeadline(Long deadline);

    void setDevice_id(String device_id);

    void setEmail(String email);

    void setGender(char gender);

    void setHeader(String header);

    void setMobile(String mobile);

    void setNickname(String nickname);

    void setPassword(String password);

    void setProvince(String province);

    void setQQGender(String qqGender);

    void setQQ_openid(String qq_openid);

    void setToken(String token);

    void setUid(Long uid);

    void setUsername(String username);

    void setVcontributed(Integer vcontributed);

    void setVcount(Integer vcount);

    void setVipStartTime(Long vip_start_time);

    void setWXGender(int intGender);

    void setWx_openid(String wx_openid);
}
