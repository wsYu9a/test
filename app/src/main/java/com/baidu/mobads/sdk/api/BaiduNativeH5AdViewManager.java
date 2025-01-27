package com.baidu.mobads.sdk.api;

import android.content.Context;

/* loaded from: classes.dex */
public class BaiduNativeH5AdViewManager {
    private static BaiduNativeH5AdViewManager theInstance;

    private BaiduNativeH5AdViewManager() {
    }

    public static synchronized BaiduNativeH5AdViewManager getInstance() {
        BaiduNativeH5AdViewManager baiduNativeH5AdViewManager;
        synchronized (BaiduNativeH5AdViewManager.class) {
            if (theInstance == null) {
                theInstance = new BaiduNativeH5AdViewManager();
            }
            baiduNativeH5AdViewManager = theInstance;
        }
        return baiduNativeH5AdViewManager;
    }

    public BaiduNativeH5AdView getBaiduNativeH5AdView(Context context, BaiduNativeAdPlacement baiduNativeAdPlacement, int i2) {
        BaiduNativeH5AdView adView = baiduNativeAdPlacement.getAdView();
        if (baiduNativeAdPlacement.getAdView() != null) {
            return adView;
        }
        BaiduNativeH5AdView baiduNativeH5AdView = new BaiduNativeH5AdView(context, i2);
        baiduNativeH5AdView.setAdPlacement(baiduNativeAdPlacement);
        baiduNativeAdPlacement.setAdView(baiduNativeH5AdView);
        return baiduNativeH5AdView;
    }
}
