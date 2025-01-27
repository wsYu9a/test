package com.martian.ttbook.sdk.client.data;

import java.util.List;

/* loaded from: classes4.dex */
public class AdAppInfoData {
    private String appName;
    private String authorName;
    private long fileSize;
    private String iconUrl;
    private List<String> permissions;
    private String privacyAgreement;
    private long time;
    private String versionName;

    public AdAppInfoData() {
    }

    public AdAppInfoData(String str, String str2, String str3, long j2, long j3, String str4, List<String> list, String str5) {
        this.appName = str;
        this.authorName = str2;
        this.versionName = str3;
        this.fileSize = j2;
        this.time = j3;
        this.privacyAgreement = str4;
        this.permissions = list;
        this.iconUrl = str5;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public List<String> getPermissions() {
        return this.permissions;
    }

    public String getPrivacyAgreement() {
        return this.privacyAgreement;
    }

    public long getTime() {
        return this.time;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public void setFileSize(long j2) {
        this.fileSize = j2;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setPermissions(List<String> list) {
        this.permissions = list;
    }

    public void setPrivacyAgreement(String str) {
        this.privacyAgreement = str;
    }

    public void setTime(long j2) {
        this.time = j2;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }
}
