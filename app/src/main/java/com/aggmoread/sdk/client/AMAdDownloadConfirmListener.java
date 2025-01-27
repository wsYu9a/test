package com.aggmoread.sdk.client;

import android.app.Activity;

/* loaded from: classes.dex */
public interface AMAdDownloadConfirmListener {

    public interface ApkInfoLoadListener {
        void onApkInfo(AMAdApkInfo aMAdApkInfo);

        void onApkInfoLoadFailed(AMError aMError);

        void onApkInfoLoading();
    }

    public interface Controller {
        void loadAppInfo(ApkInfoLoadListener apkInfoLoadListener);

        void onCancel();

        void onConfirm();
    }

    void onDownloadConfirm(Activity activity, int i10, Controller controller);
}
