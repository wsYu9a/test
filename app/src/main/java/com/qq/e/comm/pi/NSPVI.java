package com.qq.e.comm.pi;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;

/* loaded from: classes4.dex */
public interface NSPVI extends LADI {
    void fetchAdOnly();

    void fetchAndShowIn(ViewGroup viewGroup);

    void fetchFullScreenAdOnly();

    void fetchFullScreenAndShowIn(ViewGroup viewGroup);

    String getAdNetWorkName();

    Bitmap getZoomOutBitmap();

    void preload();

    void setAdListener(ADListener aDListener);

    void setDeveloperLogo(int i2);

    void setDeveloperLogo(byte[] bArr);

    void setFetchDelay(int i2);

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    @Deprecated
    void setSkipView(View view);

    void setSupportZoomOut(boolean z);

    void showAd(ViewGroup viewGroup);

    void showFullScreenAd(ViewGroup viewGroup);

    void zoomOutAnimationFinish();
}
