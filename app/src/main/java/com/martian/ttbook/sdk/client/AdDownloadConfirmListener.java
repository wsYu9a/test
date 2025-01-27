package com.martian.ttbook.sdk.client;

import android.app.Activity;
import com.martian.ttbook.sdk.client.data.AdAppInfoData;

/* loaded from: classes4.dex */
public interface AdDownloadConfirmListener {

    public interface ApkInfoLoadListener {
        void onApkInfo(AdAppInfoData adAppInfoData, AdExtras adExtras);

        void onApkInfoLoadFailed(AdError adError);

        void onApkInfoLoading();
    }

    public interface Controller {
        void loadAppInfo(ApkInfoLoadListener apkInfoLoadListener);

        void onCancel();

        void onConfirm();
    }

    void onDownloadConfirm(Activity activity, int i2, Controller controller);
}
