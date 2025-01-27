package com.tencent.bugly.beta.upgrade;

/* loaded from: classes4.dex */
public interface UpgradeStateListener {
    void onDownloadCompleted(boolean z10);

    void onUpgradeFailed(boolean z10);

    void onUpgradeNoVersion(boolean z10);

    void onUpgradeSuccess(boolean z10);

    void onUpgrading(boolean z10);
}
