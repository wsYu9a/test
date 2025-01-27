package com.vivo.ad.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes4.dex */
public class AppElement implements Serializable {
    private String developer;
    private String name;
    private List<s> permissionList;
    private String privacyPolicyUrl;
    private long size;
    private String versionName;

    public String getDeveloper() {
        return this.developer;
    }

    public String getName() {
        return this.name;
    }

    public List<s> getPermissionList() {
        return this.permissionList;
    }

    public String getPrivacyPolicyUrl() {
        return this.privacyPolicyUrl;
    }

    public long getSize() {
        return this.size;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setDeveloper(String str) {
        this.developer = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPermissionList(List<s> list) {
        this.permissionList = list;
    }

    public void setPrivacyPolicyUrl(String str) {
        this.privacyPolicyUrl = str;
    }

    public void setSize(long j2) {
        this.size = j2;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }
}
