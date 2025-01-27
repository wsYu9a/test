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

    public void setCity(String str) {
        this.city = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setFigureurl(String str) {
        this.figureurl = str;
    }

    public void setFigureurl_1(String str) {
        this.figureurl_1 = str;
    }

    public void setFigureurl_2(String str) {
        this.figureurl_2 = str;
    }

    public void setFigureurl_qq_1(String str) {
        this.figureurl_qq_1 = str;
    }

    public void setFigureurl_qq_2(String str) {
        this.figureurl_qq_2 = str;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public void setIs_yellow_vip(Integer num) {
        this.is_yellow_vip = num;
    }

    public void setIs_yellow_year_vip(Integer num) {
        this.is_yellow_year_vip = num;
    }

    public void setLevel(Integer num) {
        this.level = num;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setVip(Integer num) {
        this.vip = num;
    }

    public void setYellow_vip_level(Integer num) {
        this.yellow_vip_level = num;
    }
}
