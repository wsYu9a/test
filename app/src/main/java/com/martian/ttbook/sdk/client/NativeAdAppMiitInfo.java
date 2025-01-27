package com.martian.ttbook.sdk.client;

import java.util.List;

/* loaded from: classes4.dex */
public interface NativeAdAppMiitInfo {
    String getAppName();

    String getAuthorName();

    long getPackageSizeBytes();

    List<String> getPermissions();

    String getPermissionsUrl();

    String getPrivacyAgreement();

    String getVersionName();
}
