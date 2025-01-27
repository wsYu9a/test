package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.ad;
import com.baidu.mobads.sdk.internal.bm;
import com.baidu.mobads.sdk.internal.bq;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class NativeCPUManager {
    private static final String TAG = "NativeCPUManager";
    private CPUAdListener mCPUAdListener;
    private ad mCPUAdProd;
    private Context mContext;
    private int mPageSize = 10;
    private HashMap<String, Object> mParams = new HashMap<>();

    public interface CPUAdListener {
        void onAdError(String str, int i2);

        void onAdLoaded(List<IBasicCPUData> list);

        void onDisLikeAdClick(int i2, String str);

        void onExitLp();

        void onLpCustomEventCallBack(HashMap<String, Object> hashMap, DataPostBackListener dataPostBackListener);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    public interface DataPostBackListener {
        void postback(JSONObject jSONObject);
    }

    public NativeCPUManager(Context context, String str, CPUAdListener cPUAdListener) {
        this.mCPUAdProd = null;
        if (context == null || TextUtils.isEmpty(str)) {
            bq.a().c(TAG, "Init params error!");
            if (cPUAdListener != null) {
                cPUAdListener.onAdError("Input params error.", bm.INTERFACE_USE_PROBLEM.b());
                return;
            }
            return;
        }
        this.mCPUAdListener = cPUAdListener;
        this.mContext = context;
        ad adVar = new ad(context, str, this);
        this.mCPUAdProd = adVar;
        adVar.a(cPUAdListener);
    }

    public void loadAd(int i2, int i3, boolean z) {
        loadAd(i2, new int[]{i3}, z);
    }

    public void openAppActivity(String str) {
        ad adVar = this.mCPUAdProd;
        if (adVar != null) {
            adVar.a(str);
            this.mCPUAdProd.a();
        }
    }

    public void setPageSize(int i2) {
        if (i2 <= 0 || i2 > 20) {
            bq.a().c(TAG, "Input page size is wrong which should be in (0,20]!");
        } else {
            this.mPageSize = i2;
        }
    }

    public void setRequestParameter(CPUAdRequest cPUAdRequest) {
        if (cPUAdRequest == null || cPUAdRequest.getExtras() == null) {
            return;
        }
        this.mParams = cPUAdRequest.getExtras();
    }

    public void setRequestTimeoutMillis(int i2) {
        ad adVar = this.mCPUAdProd;
        if (adVar != null) {
            adVar.a(i2);
        }
    }

    private void loadAd(int i2, int[] iArr, boolean z) {
        if (i2 <= 0 || iArr == null) {
            bq.a().c(TAG, "LoadAd with terrible params!");
            return;
        }
        ad adVar = this.mCPUAdProd;
        if (adVar != null) {
            adVar.a(i2, this.mPageSize, iArr, z, this.mParams);
            this.mCPUAdProd.f();
            this.mCPUAdProd.a();
        }
    }
}
