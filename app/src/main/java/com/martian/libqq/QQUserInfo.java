package com.martian.libqq;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class QQUserInfo extends QQResult {
    private String city;
    private String country;
    private String figureurl;
    private String figureurl_1;
    private String figureurl_2;
    private String figureurl_qq_1;
    private String figureurl_qq_2;
    private String gender;
    private Integer is_yellow_vip;
    private Integer is_yellow_year_vip;
    private Integer level;
    private String nickname;
    private String province;
    private Integer vip;
    private Integer yellow_vip_level;

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getFigureurl() {
        return this.figureurl;
    }

    public String getFigureurl_1() {
        return this.figureurl_1;
    }

    public String getFigureurl_2() {
        return this.figureurl_2;
    }

    public String getFigureurl_qq_1() {
        return this.figureurl_qq_1;
    }

    public String getFigureurl_qq_2() {
        return this.figureurl_qq_2;
    }

    public String getGender() {
        return this.gender;
    }

    public String getHeaderUrl() {
        return !TextUtils.isEmpty(this.figureurl_qq_2) ? this.figureurl_qq_2 : !TextUtils.isEmpty(this.figureurl_qq_1) ? this.figureurl_qq_1 : !TextUtils.isEmpty(this.figureurl_2) ? this.figureurl_2 : !TextUtils.isEmpty(this.figureurl_1) ? this.figureurl_1 : !TextUtils.isEmpty(this.figureurl) ? this.figureurl : "";
    }

    public Integer getIs_yellow_vip() {
        return this.is_yellow_vip;
    }

    public Integer getIs_yellow_year_vip() {
        return this.is_yellow_year_vip;
    }

    public Integer getLevel() {
        return this.level;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getProvince() {
        return this.province;
    }

    public Integer getVip() {
        return this.vip;
    }

    public Integer getYellow_vip_level() {
        return this.yellow_vip_level;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setFigureurl(String figureurl) {
        this.figureurl = figureurl;
    }

    public void setFigureurl_1(String figureurl_1) {
        this.figureurl_1 = figureurl_1;
    }

    public void setFigureurl_2(String figureurl_2) {
        this.figureurl_2 = figureurl_2;
    }

    public void setFigureurl_qq_1(String figureurl_qq_1) {
        this.figureurl_qq_1 = figureurl_qq_1;
    }

    public void setFigureurl_qq_2(String figureurl_qq_2) {
        this.figureurl_qq_2 = figureurl_qq_2;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setIs_yellow_vip(Integer is_yellow_vip) {
        this.is_yellow_vip = is_yellow_vip;
    }

    public void setIs_yellow_year_vip(Integer is_yellow_year_vip) {
        this.is_yellow_year_vip = is_yellow_year_vip;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public void setYellow_vip_level(Integer yellow_vip_level) {
        this.yellow_vip_level = yellow_vip_level;
    }
}
