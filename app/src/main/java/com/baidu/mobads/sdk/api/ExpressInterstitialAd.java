package com.baidu.mobads.sdk.api;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.mobads.sdk.internal.co;
import com.baidu.mobads.sdk.internal.db;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ExpressInterstitialAd {
    private InterstitialAdDislikeListener mAdDislikeListener;
    private String mAdPlaceId;
    private String mAppsid;
    private int mBidFloor;
    private Context mContext;
    private ExpressInterstitialListener mExpressInterstitialListener;
    private int mHeight;
    private InterAdDownloadWindowListener mInterAdDownloadWindowListener;
    private db mNativeInterstitialAdProd;
    private RequestParameters mRequestParameters;
    private boolean mUseDialogContainer;
    private boolean mUseDialogFrame;
    private int mWidth;
    private boolean onlyFetchAd;

    /* renamed from: com.baidu.mobads.sdk.api.ExpressInterstitialAd$1 */
    class AnonymousClass1 implements co.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.internal.co.a
        public void onAttachedToWindow() {
        }

        @Override // com.baidu.mobads.sdk.internal.co.a
        @SuppressLint({"MissingSuperCall"})
        public void onDetachedFromWindow() {
            if (ExpressInterstitialAd.this.mNativeInterstitialAdProd != null) {
                ExpressInterstitialAd.this.mNativeInterstitialAdProd.p();
            }
        }

        @Override // com.baidu.mobads.sdk.internal.co.a
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            return i2 == 4;
        }

        @Override // com.baidu.mobads.sdk.internal.co.a
        public void onLayoutComplete(int i2, int i3) {
        }

        @Override // com.baidu.mobads.sdk.internal.co.a
        public void onWindowFocusChanged(boolean z) {
        }

        @Override // com.baidu.mobads.sdk.internal.co.a
        public void onWindowVisibilityChanged(int i2) {
        }
    }

    public interface InterAdDownloadWindowListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();

        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyClick();

        void onADPrivacyClose();
    }

    public interface InterstitialAdDislikeListener {
        void interstitialAdDislikeClick();
    }

    public ExpressInterstitialAd(Context context, String str) {
        this(context, str, 500, 600);
    }

    private void initNativeInterstitialAdProd() {
        co coVar = new co(this.mContext);
        coVar.a(new co.a() { // from class: com.baidu.mobads.sdk.api.ExpressInterstitialAd.1
            AnonymousClass1() {
            }

            @Override // com.baidu.mobads.sdk.internal.co.a
            public void onAttachedToWindow() {
            }

            @Override // com.baidu.mobads.sdk.internal.co.a
            @SuppressLint({"MissingSuperCall"})
            public void onDetachedFromWindow() {
                if (ExpressInterstitialAd.this.mNativeInterstitialAdProd != null) {
                    ExpressInterstitialAd.this.mNativeInterstitialAdProd.p();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.co.a
            public boolean onKeyDown(int i2, KeyEvent keyEvent) {
                return i2 == 4;
            }

            @Override // com.baidu.mobads.sdk.internal.co.a
            public void onLayoutComplete(int i2, int i3) {
            }

            @Override // com.baidu.mobads.sdk.internal.co.a
            public void onWindowFocusChanged(boolean z) {
            }

            @Override // com.baidu.mobads.sdk.internal.co.a
            public void onWindowVisibilityChanged(int i2) {
            }
        });
        this.mNativeInterstitialAdProd = new db(this.mContext, coVar, this.mAdPlaceId);
        if (!TextUtils.isEmpty(this.mAppsid)) {
            this.mNativeInterstitialAdProd.o = this.mAppsid;
        }
        db dbVar = this.mNativeInterstitialAdProd;
        dbVar.p = this.mBidFloor;
        dbVar.q = this.onlyFetchAd;
        dbVar.a(this.mExpressInterstitialListener);
        this.mNativeInterstitialAdProd.a(this.mInterAdDownloadWindowListener);
        this.mNativeInterstitialAdProd.a(this.mAdDislikeListener);
        this.mNativeInterstitialAdProd.c(this.mUseDialogFrame);
        this.mNativeInterstitialAdProd.d(this.mUseDialogContainer);
        RequestParameters requestParameters = this.mRequestParameters;
        if (requestParameters != null) {
            this.mNativeInterstitialAdProd.a(requestParameters);
        }
    }

    private void reallyLoad() {
        initNativeInterstitialAdProd();
        this.mNativeInterstitialAdProd.a();
    }

    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    public void biddingSuccess(String str) {
        db dbVar = this.mNativeInterstitialAdProd;
        if (dbVar != null) {
            dbVar.a(true, str);
        }
    }

    public void destroy() {
        db dbVar = this.mNativeInterstitialAdProd;
        if (dbVar == null) {
            return;
        }
        dbVar.e();
    }

    public String getBiddingToken() {
        this.onlyFetchAd = true;
        initNativeInterstitialAdProd();
        return this.mNativeInterstitialAdProd.m();
    }

    public String getECPMLevel() {
        a w;
        db dbVar = this.mNativeInterstitialAdProd;
        return (dbVar == null || (w = dbVar.w()) == null) ? "" : w.z();
    }

    public boolean isReady() {
        IAdInterListener iAdInterListener;
        db dbVar = this.mNativeInterstitialAdProd;
        if (dbVar == null || (iAdInterListener = dbVar.k) == null) {
            return false;
        }
        return iAdInterListener.isAdReady();
    }

    public void load() {
        if (this.mContext == null) {
            av.c().e("ExpressInterstitialAd", "请传一个非空的context再进行load");
        } else {
            this.onlyFetchAd = true;
            reallyLoad();
        }
    }

    public void loadBiddingAd(String str) {
        db dbVar = this.mNativeInterstitialAdProd;
        if (dbVar != null) {
            dbVar.c(str);
        }
    }

    public void setAdDislikeListener(InterstitialAdDislikeListener interstitialAdDislikeListener) {
        this.mAdDislikeListener = interstitialAdDislikeListener;
    }

    public void setAppSid(String str) {
        this.mAppsid = str;
    }

    public void setBidFloor(int i2) {
        this.mBidFloor = i2;
    }

    @Deprecated
    public void setBiddingData(String str) {
        db dbVar = this.mNativeInterstitialAdProd;
        if (dbVar != null) {
            dbVar.b(str);
        }
    }

    public void setDialogFrame(boolean z) {
        this.mUseDialogFrame = z;
    }

    public void setDownloadListener(InterAdDownloadWindowListener interAdDownloadWindowListener) {
        this.mInterAdDownloadWindowListener = interAdDownloadWindowListener;
    }

    public void setLoadListener(ExpressInterstitialListener expressInterstitialListener) {
        this.mExpressInterstitialListener = expressInterstitialListener;
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        this.mRequestParameters = requestParameters;
    }

    public void show() {
        db dbVar = this.mNativeInterstitialAdProd;
        if (dbVar == null) {
            return;
        }
        if (dbVar.g()) {
            this.mNativeInterstitialAdProd.h();
        } else {
            this.mNativeInterstitialAdProd.f((IOAdEvent) null);
        }
    }

    public void useUseDialogContainer(boolean z) {
        this.mUseDialogContainer = z;
    }

    public ExpressInterstitialAd(Context context, String str, int i2, int i3) {
        this.mUseDialogFrame = false;
        this.mBidFloor = -1;
        this.mUseDialogContainer = false;
        this.mContext = context;
        this.mAdPlaceId = str;
        this.mWidth = i2;
        this.mHeight = i3;
    }

    public void biddingFail(String str, HashMap<String, Object> hashMap) {
        db dbVar = this.mNativeInterstitialAdProd;
        if (dbVar != null) {
            dbVar.a(false, str, hashMap);
        }
    }

    public void show(Activity activity) {
        db dbVar = this.mNativeInterstitialAdProd;
        if (dbVar == null) {
            return;
        }
        dbVar.a(activity);
        show();
    }
}
