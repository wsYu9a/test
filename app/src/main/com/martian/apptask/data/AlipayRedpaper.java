package com.martian.apptask.data;

import java.util.Date;

/* loaded from: classes3.dex */
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

    public void setAdsTitle(String str) {
        this.adsTitle = str;
    }

    public void setAdsUrl(String str) {
        this.adsUrl = str;
    }

    public void setBgImgUrl(String str) {
        this.bgImgUrl = str;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setForceInstall(boolean z10) {
        this.forceInstall = z10;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setMoney(int i10) {
        this.money = i10;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPasscode(String str) {
        this.passcode = str;
    }

    public void setRpid(int i10) {
        this.rpid = i10;
    }

    public void setTime(long j10) {
        this.date = new Date(j10);
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
