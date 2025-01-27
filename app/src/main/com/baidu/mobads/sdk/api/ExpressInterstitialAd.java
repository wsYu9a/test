package com.baidu.mobads.sdk.api;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.ay;
import com.baidu.mobads.sdk.internal.cr;
import com.baidu.mobads.sdk.internal.dd;
import java.util.LinkedHashMap;

/* loaded from: classes2.dex */
public class ExpressInterstitialAd {
    private InterstitialAdDislikeListener mAdDislikeListener;
    private String mAdPlaceId;
    private String mAppsid;
    private int mBidFloor;
    private Context mContext;
    private ExpressInterstitialListener mExpressInterstitialListener;
    private int mHeight;
    private InterAdDownloadWindowListener mInterAdDownloadWindowListener;
    private long mLoadTime;
    private dd mNativeInterstitialAdProd;
    private RequestParameters mRequestParameters;
    private boolean mUseDialogContainer;
    private boolean mUseDialogFrame;
    private int mWidth;
    private boolean onlyFetchAd;

    /* renamed from: com.baidu.mobads.sdk.api.ExpressInterstitialAd$1 */
    class AnonymousClass1 implements cr.a {
        public AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void dispatchTouchEvent(MotionEvent motionEvent) {
            ExpressInterstitialAd.this.mNativeInterstitialAdProd.a(motionEvent);
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onAttachedToWindow() {
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        @SuppressLint({"MissingSuperCall"})
        public void onDetachedFromWindow() {
            if (ExpressInterstitialAd.this.mNativeInterstitialAdProd != null) {
                ExpressInterstitialAd.this.mNativeInterstitialAdProd.o();
            }
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public boolean onKeyDown(int i10, KeyEvent keyEvent) {
            return i10 == 4;
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onLayoutComplete(int i10, int i11) {
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onWindowFocusChanged(boolean z10) {
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onWindowVisibilityChanged(int i10) {
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
        System.currentTimeMillis();
        cr crVar = new cr(this.mContext);
        crVar.a(new cr.a() { // from class: com.baidu.mobads.sdk.api.ExpressInterstitialAd.1
            public AnonymousClass1() {
            }

            @Override // com.baidu.mobads.sdk.internal.cr.a
            public void dispatchTouchEvent(MotionEvent motionEvent) {
                ExpressInterstitialAd.this.mNativeInterstitialAdProd.a(motionEvent);
            }

            @Override // com.baidu.mobads.sdk.internal.cr.a
            public void onAttachedToWindow() {
            }

            @Override // com.baidu.mobads.sdk.internal.cr.a
            @SuppressLint({"MissingSuperCall"})
            public void onDetachedFromWindow() {
                if (ExpressInterstitialAd.this.mNativeInterstitialAdProd != null) {
                    ExpressInterstitialAd.this.mNativeInterstitialAdProd.o();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cr.a
            public boolean onKeyDown(int i10, KeyEvent keyEvent) {
                return i10 == 4;
            }

            @Override // com.baidu.mobads.sdk.internal.cr.a
            public void onLayoutComplete(int i10, int i11) {
            }

            @Override // com.baidu.mobads.sdk.internal.cr.a
            public void onWindowFocusChanged(boolean z10) {
            }

            @Override // com.baidu.mobads.sdk.internal.cr.a
            public void onWindowVisibilityChanged(int i10) {
            }
        });
        this.mNativeInterstitialAdProd = new dd(this.mContext, crVar, this.mAdPlaceId);
        if (!TextUtils.isEmpty(this.mAppsid)) {
            this.mNativeInterstitialAdProd.f6888q = this.mAppsid;
        }
        dd ddVar = this.mNativeInterstitialAdProd;
        ddVar.f6889r = this.mBidFloor;
        ddVar.f7147t = this.onlyFetchAd;
        ddVar.a(this.mExpressInterstitialListener);
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

    public void biddingFail(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        dd ddVar = this.mNativeInterstitialAdProd;
        if (ddVar != null) {
            ddVar.a(false, linkedHashMap, biddingListener);
        }
    }

    public void biddingSuccess(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        dd ddVar = this.mNativeInterstitialAdProd;
        if (ddVar != null) {
            ddVar.a(true, linkedHashMap, biddingListener);
        }
    }

    public void destroy() {
        dd ddVar = this.mNativeInterstitialAdProd;
        if (ddVar == null) {
            return;
        }
        ddVar.p();
    }

    public Object getAdDataForKey(String str) {
        dd ddVar = this.mNativeInterstitialAdProd;
        if (ddVar != null) {
            return ddVar.a(str);
        }
        return null;
    }

    public String getBiddingToken() {
        this.onlyFetchAd = true;
        initNativeInterstitialAdProd();
        return this.mNativeInterstitialAdProd.l();
    }

    public String getECPMLevel() {
        a x10;
        dd ddVar = this.mNativeInterstitialAdProd;
        return (ddVar == null || (x10 = ddVar.x()) == null) ? "" : x10.z();
    }

    public String getPECPM() {
        a x10;
        dd ddVar = this.mNativeInterstitialAdProd;
        return (ddVar == null || (x10 = ddVar.x()) == null) ? "" : x10.A();
    }

    public boolean isReady() {
        IAdInterListener iAdInterListener;
        dd ddVar = this.mNativeInterstitialAdProd;
        if (ddVar == null || (iAdInterListener = ddVar.f6884m) == null) {
            return false;
        }
        return iAdInterListener.isAdReady();
    }

    public void load() {
        this.mLoadTime = System.currentTimeMillis();
        if (this.mContext == null) {
            ay.c().e("ExpressInterstitialAd", "请传一个非空的context再进行load");
        } else {
            this.onlyFetchAd = true;
            reallyLoad();
        }
    }

    public void loadBiddingAd(String str) {
        dd ddVar = this.mNativeInterstitialAdProd;
        if (ddVar != null) {
            ddVar.c(str);
        }
    }

    public void setAdDislikeListener(InterstitialAdDislikeListener interstitialAdDislikeListener) {
        this.mAdDislikeListener = interstitialAdDislikeListener;
    }

    public void setAppSid(String str) {
        this.mAppsid = str;
    }

    public void setBidFloor(int i10) {
        this.mBidFloor = i10;
    }

    @Deprecated
    public void setBiddingData(String str) {
        dd ddVar = this.mNativeInterstitialAdProd;
        if (ddVar != null) {
            ddVar.b(str);
        }
    }

    public void setDialogFrame(boolean z10) {
        this.mUseDialogFrame = z10;
    }

    public void setDownloadListener(InterAdDownloadWindowListener interAdDownloadWindowListener) {
        this.mInterAdDownloadWindowListener = interAdDownloadWindowListener;
    }

    public void setLoadListener(ExpressInterstitialListener expressInterstitialListener) {
        this.mExpressInterstitialListener = expressInterstitialListener;
        dd ddVar = this.mNativeInterstitialAdProd;
        if (ddVar != null) {
            ddVar.a(expressInterstitialListener);
        }
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        this.mRequestParameters = requestParameters;
    }

    public void show() {
        dd ddVar = this.mNativeInterstitialAdProd;
        if (ddVar == null) {
            return;
        }
        if (ddVar.f()) {
            this.mNativeInterstitialAdProd.g();
        } else {
            this.mNativeInterstitialAdProd.f((IOAdEvent) null);
        }
    }

    public void useUseDialogContainer(boolean z10) {
        this.mUseDialogContainer = z10;
    }

    public ExpressInterstitialAd(Context context, String str, int i10, int i11) {
        this.mUseDialogFrame = false;
        this.mBidFloor = -1;
        this.mUseDialogContainer = false;
        this.mContext = context;
        this.mAdPlaceId = str;
        this.mWidth = i10;
        this.mHeight = i11;
    }

    public void show(Activity activity) {
        dd ddVar = this.mNativeInterstitialAdProd;
        if (ddVar == null) {
            return;
        }
        ddVar.a(activity);
        show();
    }
}
