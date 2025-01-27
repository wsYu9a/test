package com.baidu.mobads.sdk.api;

import android.content.Context;
import com.baidu.mobads.sdk.internal.de;
import com.baidu.mobads.sdk.internal.dm;
import java.util.HashMap;

/* loaded from: classes.dex */
public class FullScreenVideoAd {
    private static final String TAG = "FullScreenVideoAd";
    private dm mAdProd;
    private final Context mContext;
    private RequestParameters mRequestParameters;

    public interface FullScreenVideoAdListener extends ScreenVideoAdListener {
        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClick();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClose(float f2);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdFailed(String str);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdShow();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdSkip(float f2);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadFailed();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadSuccess();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void playCompletion();
    }

    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener) {
        this(context, str, fullScreenVideoAdListener, false);
    }

    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    public void biddingSuccess(String str) {
        dm dmVar = this.mAdProd;
        if (dmVar != null) {
            dmVar.a(true, str);
        }
    }

    public String getBiddingToken() {
        dm dmVar = this.mAdProd;
        if (dmVar != null) {
            return dmVar.m();
        }
        return null;
    }

    public String getECPMLevel() {
        dm dmVar = this.mAdProd;
        return dmVar != null ? dmVar.h() : "";
    }

    public boolean isReady() {
        dm dmVar = this.mAdProd;
        if (dmVar != null) {
            return dmVar.g();
        }
        return false;
    }

    public synchronized void load() {
        dm dmVar = this.mAdProd;
        if (dmVar != null) {
            dmVar.a();
        }
    }

    public void loadBiddingAd(String str) {
        dm dmVar = this.mAdProd;
        if (dmVar != null) {
            dmVar.c(str);
        }
    }

    public void setAppSid(String str) {
        dm dmVar = this.mAdProd;
        if (dmVar != null) {
            dmVar.g(str);
        }
    }

    public void setBidFloor(int i2) {
        dm dmVar = this.mAdProd;
        if (dmVar != null) {
            dmVar.p = i2;
        }
    }

    @Deprecated
    public void setBiddingData(String str) {
        dm dmVar = this.mAdProd;
        if (dmVar != null) {
            dmVar.b(str);
        }
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        dm dmVar;
        this.mRequestParameters = requestParameters;
        if (requestParameters == null || (dmVar = this.mAdProd) == null) {
            return;
        }
        dmVar.a(requestParameters);
    }

    public synchronized void show() {
        dm dmVar = this.mAdProd;
        if (dmVar != null) {
            dmVar.f();
        }
    }

    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener, boolean z) {
        this.mContext = context;
        de deVar = new de(context, str, z);
        this.mAdProd = deVar;
        deVar.a(fullScreenVideoAdListener);
    }

    public void biddingFail(String str, HashMap<String, Object> hashMap) {
        dm dmVar = this.mAdProd;
        if (dmVar != null) {
            dmVar.a(false, str, hashMap);
        }
    }
}
