package com.martian.apptask.data;

import java.util.Date;

/* loaded from: classes2.dex */
public class AlipayRedpaper {
    private String adsTitle;
    private String adsUrl;
    private String bgImgUrl;
    private Date date;
    private String desc;
    private String downloadUrl;
    private boolean forceInstall = false;
    private String iconUrl;
    private int money;
    private String packageName;
    private String passcode;
    private int rpid;
    private String title;

    public String getAdsTitle() {
        return this.adsTitle;
    }

    public String getAdsUrl() {
        return this.adsUrl;
    }

    public String getBgImgUrl() {
        return this.bgImgUrl;
    }

    public Date getDate() {
        return this.date;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public int getMoney() {
        return this.money;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPasscode() {
        return this.passcode;
    }

    public int getRpid() {
        return this.rpid;
    }

    public long getTime() {
        return this.date.getTime();
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isForceInstall() {
        return this.forceInstall;
    }

    public void setAdsTitle(String adsTitle) {
        this.adsTitle = adsTitle;
    }

    public void setAdsUrl(String adsUrl) {
        this.adsUrl = adsUrl;
    }

    public void setBgImgUrl(String bgImgUrl) {
        this.bgImgUrl = bgImgUrl;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public void setForceInstall(boolean forceInstall) {
        this.forceInstall = forceInstall;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public void setRpid(int rpid) {
        this.rpid = rpid;
    }

    public void setTime(long time) {
        this.date = new Date(time);
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
