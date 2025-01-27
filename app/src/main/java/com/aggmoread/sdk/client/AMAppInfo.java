package com.aggmoread.sdk.client;

import java.util.List;

/* loaded from: classes.dex */
public class AMAppInfo {
    private String appName;
    private String authorName;
    private String descriptionUrl;
    private String icpNumber;
    private long pacakgesSize;
    private String packageName;
    private List<Permission> permissionList;
    private String permissionsUrl;
    private String privacyAgreement;
    private String suitableAge;
    private String versionName;

    public static class Permission {
        public String desc;
        public String title;

        public Permission(String str, String str2) {
            this.title = str;
            this.desc = str2;
        }
    }

    public AMAppInfo(String str, String str2, long j10, String str3, List<Permission> list, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.appName = str;
        this.authorName = str2;
        this.pacakgesSize = j10;
        this.permissionsUrl = str3;
        this.permissionList = list;
        this.privacyAgreement = str4;
        this.versionName = str5;
        this.packageName = str6;
        this.descriptionUrl = str7;
        this.icpNumber = str8;
        this.suitableAge = str9;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public String getDescriptionUrl() {
        return this.descriptionUrl;
    }

    public String getIcpNumber() {
        return this.icpNumber;
    }

    public long getPacakgesSize() {
        return this.pacakgesSize;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public List<Permission> getPermissionList() {
        return this.permissionList;
    }

    public String getPermissionsUrl() {
        return this.permissionsUrl;
    }

    public String getPrivacyAgreement() {
        return this.privacyAgreement;
    }

    public String getSuitableAge() {
        return this.suitableAge;
    }

    public String getVersionName() {
        return this.versionName;
    }
}
