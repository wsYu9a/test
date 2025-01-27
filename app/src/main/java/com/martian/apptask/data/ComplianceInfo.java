package com.martian.apptask.data;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes3.dex */
public class ComplianceInfo {
    private String appDeveloperName;
    private String appFunctionDescUrl;
    private String appName;
    private String appPermissionUrl;
    private Map<String, String> appPermissions;
    private String appPrivacyUrl;
    private String appVersion;
    private String pkgName;

    public String getAppDeveloperName() {
        return this.appDeveloperName;
    }

    public String getAppFunctionDescUrl() {
        return this.appFunctionDescUrl;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppPermissionUrl() {
        return this.appPermissionUrl;
    }

    public Map<String, String> getAppPermissions() {
        return this.appPermissions;
    }

    public String getAppPrivacyUrl() {
        return this.appPrivacyUrl;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public ComplianceInfo setAppDeveloperName(String str) {
        this.appDeveloperName = str;
        return this;
    }

    public ComplianceInfo setAppFunctionDescUrl(String str) {
        this.appFunctionDescUrl = str;
        return this;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppPermissionUrl(String str) {
        this.appPermissionUrl = str;
    }

    public ComplianceInfo setAppPermissions(Map<String, String> map) {
        this.appPermissions = map;
        return this;
    }

    public ComplianceInfo setAppPrivacyUrl(String str) {
        this.appPrivacyUrl = str;
        return this;
    }

    public ComplianceInfo setAppVersion(String str) {
        if (!TextUtils.isEmpty(str) && !str.startsWith("版本")) {
            this.appVersion = "版本" + str;
        }
        return this;
    }

    public ComplianceInfo setPkgName(String str) {
        this.pkgName = str;
        return this;
    }
}
