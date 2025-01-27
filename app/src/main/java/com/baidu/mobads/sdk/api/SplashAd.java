package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.ba;
import com.baidu.mobads.sdk.internal.bp;
import com.baidu.mobads.sdk.internal.bt;
import com.baidu.mobads.sdk.internal.cr;
import com.baidu.mobads.sdk.internal.dc;
import com.baidu.mobads.sdk.internal.di;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class SplashAd {
    private static final int BOTTOM_VIEW_ID = 4097;
    public static final String KEY_BIDFAIL_ADN = "adn";
    public static final String KEY_BIDFAIL_ECPM = "ecpm";
    public static final String KEY_DISPLAY_DOWNLOADINFO = "displayDownloadInfo";
    public static final String KEY_FETCHAD = "fetchAd";
    public static final String KEY_LOAD_AFTER_CACHE_END = "loadAfterCacheEnd";
    public static final String KEY_POPDIALOG_DOWNLOAD = "use_dialog_frame";
    public static final String KEY_PREFER_FULLSCREEN = "prefer_fullscreen";
    public static final String KEY_SHAKE_LOGO_SIZE = "shake_logo_size";
    public static final String KEY_TIMEOUT = "timeout";
    public static final String KEY_TWIST_BG_COLOR = "twist_bg_color";
    public static final String KEY_TWIST_LOGO_HEIGHT_DP = "twist_logo_height_dp";
    public static final String KEY_USE_ADAPTIVE_AD = "adaptive_ad";
    private static final int RT_SPLASH_LOAD_AD_TIMEOUT = 4200;
    private String mAdPlaceId;
    private di mAdProd;
    private String mAppSid;
    private int mBidFloor;
    private Context mContext;
    private Boolean mDisplayClickRegion;
    private boolean mDisplayDownInfo;
    private SplashAdDownloadDialogListener mDownloadDialogListener;
    private boolean mFetchAd;
    private boolean mFetchNotShow;
    private boolean mIsAdaptiveSplashAd;
    private Boolean mLimitRegionClick;
    private SplashAdListener mListener;
    private RequestParameters mParameter;
    private Boolean mPopDialogIfDL;
    private int mShakeLogoSize;
    private int mTimeout;
    private int mTipStyle;
    protected int mTwistBgColor;
    protected int mTwistLogoHeightDp;
    private ViewGroup mViewParent;

    /* renamed from: com.baidu.mobads.sdk.api.SplashAd$1 */
    class AnonymousClass1 implements SplashInteractionListener {
        public AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdCacheFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdCacheSuccess() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdClick() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdDismissed() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdExposed() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdPresent() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdSkip() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onLpClosed() {
        }
    }

    /* renamed from: com.baidu.mobads.sdk.api.SplashAd$2 */
    class AnonymousClass2 implements cr.a {
        private boolean mIsFirstOnLayout = true;
        final /* synthetic */ cr val$splashAdView;

        public AnonymousClass2(cr crVar) {
            crVar = crVar;
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void dispatchTouchEvent(MotionEvent motionEvent) {
            SplashAd.this.mAdProd.a(motionEvent);
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onAttachedToWindow() {
            if (SplashAd.this.mAdProd != null) {
                SplashAd.this.mAdProd.n();
            }
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onDetachedFromWindow() {
            if (SplashAd.this.mAdProd != null) {
                SplashAd.this.mAdProd.o();
            }
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public boolean onKeyDown(int i10, KeyEvent keyEvent) {
            return false;
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onLayoutComplete(int i10, int i11) {
            if (this.mIsFirstOnLayout) {
                if (SplashAd.this.mAdProd == null) {
                    SplashAd.this.callAdFailed("展现失败，请检查splashAd参数是否正确");
                    return;
                }
                SplashAd.this.mAdProd.f7176u = false;
                SplashAd.this.mFetchNotShow = false;
                this.mIsFirstOnLayout = false;
                SplashAd.this.mAdProd.a(crVar);
                SplashAd.this.mAdProd.e();
            }
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onWindowFocusChanged(boolean z10) {
            if (SplashAd.this.mAdProd != null) {
                SplashAd.this.mAdProd.a(z10);
            }
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onWindowVisibilityChanged(int i10) {
            if (SplashAd.this.mAdProd != null) {
                SplashAd.this.mAdProd.b(i10);
            }
        }
    }

    /* renamed from: com.baidu.mobads.sdk.api.SplashAd$3 */
    class AnonymousClass3 implements cr.a {
        final /* synthetic */ cr val$prodContainer;

        public AnonymousClass3(cr crVar) {
            crVar = crVar;
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void dispatchTouchEvent(MotionEvent motionEvent) {
            if (SplashAd.this.mAdProd != null) {
                SplashAd.this.mAdProd.a(motionEvent);
            }
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onAttachedToWindow() {
            if (SplashAd.this.mAdProd != null) {
                SplashAd.this.mAdProd.n();
            }
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onDetachedFromWindow() {
            if (SplashAd.this.mAdProd != null) {
                SplashAd.this.mAdProd.o();
            }
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public boolean onKeyDown(int i10, KeyEvent keyEvent) {
            return false;
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onLayoutComplete(int i10, int i11) {
            if (SplashAd.this.mAdProd != null) {
                return;
            }
            float e10 = ba.e(SplashAd.this.mContext);
            if (SplashAd.this.mParameter != null && SplashAd.this.mParameter.isCustomSize()) {
                if (SplashAd.this.mParameter.getWidth() > 0) {
                    i10 = (int) (SplashAd.this.mParameter.getWidth() * e10);
                }
                if (SplashAd.this.mParameter.getHeight() > 0) {
                    i11 = (int) (SplashAd.this.mParameter.getHeight() * e10);
                }
            }
            int i12 = i10;
            int i13 = i11;
            if (i12 < 200.0f * e10 || i13 < e10 * 150.0f) {
                bt.a().c(dc.a().a(bp.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
                if (SplashAd.this.mListener == null || !(SplashAd.this.mListener instanceof SplashInteractionListener)) {
                    return;
                }
                ((SplashInteractionListener) SplashAd.this.mListener).onAdDismissed();
                return;
            }
            SplashAd.this.mAdProd = new di(SplashAd.this.mContext, SplashAd.this.mAdPlaceId, i12, i13, SplashAd.this.mTipStyle, SplashAd.this.mTimeout, SplashAd.this.mDisplayDownInfo, SplashAd.this.mPopDialogIfDL.booleanValue(), SplashAd.this.mDisplayClickRegion.booleanValue(), SplashAd.this.mLimitRegionClick.booleanValue());
            SplashAd.this.mAdProd.a(crVar);
            SplashAd.this.mAdProd.d(SplashAd.this.mShakeLogoSize);
            SplashAd.this.mAdProd.a(SplashAd.this.mTwistLogoHeightDp);
            SplashAd.this.mAdProd.c(SplashAd.this.mTwistBgColor);
            SplashAd.this.mAdProd.h(SplashAd.this.mAppSid);
            SplashAd.this.mAdProd.f6889r = SplashAd.this.mBidFloor;
            SplashAd.this.mAdProd.a(SplashAd.this.mListener);
            if (SplashAd.this.mParameter != null) {
                SplashAd.this.mAdProd.a(SplashAd.this.mParameter);
            }
            SplashAd.this.mAdProd.f7176u = false;
            SplashAd.this.mAdProd.a(SplashAd.this.mDownloadDialogListener);
            SplashAd.this.mAdProd.a();
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onWindowFocusChanged(boolean z10) {
            if (SplashAd.this.mAdProd != null) {
                SplashAd.this.mAdProd.a(z10);
            }
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onWindowVisibilityChanged(int i10) {
            if (SplashAd.this.mAdProd != null) {
                SplashAd.this.mAdProd.b(i10);
            }
        }
    }

    public interface OnFinishListener {
        void onFinishActivity();
    }

    public interface SplashAdDownloadDialogListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();

        void onADFunctionLpClose();

        void onADFunctionLpShow();

        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyLpClose();

        void onADPrivacyLpShow();
    }

    public interface SplashCardAdListener {
        void onCardClick();

        void onCardClose();

        void onCardShow();
    }

    public interface SplashFocusAdListener {
        void onAdClick();

        void onAdClose();

        void onAdIconShow();

        void onLpClosed();
    }

    public SplashAd(Context context, String str, SplashAdListener splashAdListener) {
        this(context, str, null, splashAdListener);
    }

    private void addZeroPxSurfaceViewAvoidBlink(ViewGroup viewGroup, Context context) {
        try {
            viewGroup.addView(new SurfaceView(context), new RelativeLayout.LayoutParams(0, 0));
        } catch (Exception e10) {
            bt.a().a(e10);
        }
    }

    public void callAdFailed(String str) {
        if (this.mListener != null) {
            sendSplashFailedLog(str);
            this.mListener.onAdFailed(str);
        }
    }

    public static void registerEnterTransition(Activity activity, SplashFocusAdListener splashFocusAdListener) {
        di.a(activity, (JSONObject) null, splashFocusAdListener);
    }

    private void sendSplashFailedLog(String str) {
        try {
            di diVar = this.mAdProd;
            if (diVar != null) {
                diVar.a(str);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void sendSplashLog(ViewGroup viewGroup, View view) {
        try {
            HashMap hashMap = new HashMap();
            StringBuilder sb2 = new StringBuilder();
            boolean z10 = false;
            sb2.append(viewGroup == null);
            sb2.append("");
            hashMap.put("adContainer", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            if (this.mIsAdaptiveSplashAd && view == null) {
                z10 = true;
            }
            sb3.append(z10);
            sb3.append("");
            hashMap.put("isAdaptive", sb3.toString());
            hashMap.put("mFetchNotShow", this.mFetchNotShow + "");
            if (this.mAdProd != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("msg", "sendSplashLog");
                } catch (JSONException e10) {
                    bt.a().a(e10);
                }
                this.mAdProd.a(jSONObject, hashMap);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void setAppLogo(Object obj) {
        if (this.mAdProd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event_type", "splash_logo");
                HashMap hashMap = new HashMap();
                hashMap.put("appLogo", obj);
                this.mAdProd.a(jSONObject, hashMap);
            } catch (Throwable th2) {
                bt.a().d(th2);
            }
        }
    }

    private final void setAppLogoData(byte[] bArr) {
        setAppLogo(bArr);
    }

    private final void setAppLogoId(int i10) {
        setAppLogo(Integer.valueOf(i10));
    }

    private final void showWithBottomView(ViewGroup viewGroup, View view) {
        sendSplashLog(viewGroup, view);
        this.mViewParent = viewGroup;
        if (viewGroup == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("传入容器不可以为空");
                this.mListener.onAdFailed("传入容器不可以为空");
                return;
            }
            return;
        }
        if (this.mIsAdaptiveSplashAd && view == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                this.mListener.onAdFailed("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                return;
            }
            return;
        }
        if (!this.mFetchNotShow) {
            di diVar = this.mAdProd;
            if (diVar != null) {
                diVar.r();
            }
            callAdFailed("展现失败，请重新load");
            return;
        }
        this.mFetchNotShow = false;
        di diVar2 = this.mAdProd;
        if (diVar2 == null) {
            if (diVar2 != null) {
                diVar2.r();
            }
            callAdFailed("展现失败，请检查splashAd参数是否正确");
            return;
        }
        cr crVar = new cr(this.mContext);
        crVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (view != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            view.setId(4097);
            crVar.addView(view, layoutParams);
        }
        crVar.a(new cr.a() { // from class: com.baidu.mobads.sdk.api.SplashAd.2
            private boolean mIsFirstOnLayout = true;
            final /* synthetic */ cr val$splashAdView;

            public AnonymousClass2(cr crVar2) {
                crVar = crVar2;
            }

            @Override // com.baidu.mobads.sdk.internal.cr.a
            public void dispatchTouchEvent(MotionEvent motionEvent) {
                SplashAd.this.mAdProd.a(motionEvent);
            }

            @Override // com.baidu.mobads.sdk.internal.cr.a
            public void onAttachedToWindow() {
                if (SplashAd.this.mAdProd != null) {
                    SplashAd.this.mAdProd.n();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cr.a
            public void onDetachedFromWindow() {
                if (SplashAd.this.mAdProd != null) {
                    SplashAd.this.mAdProd.o();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cr.a
            public boolean onKeyDown(int i10, KeyEvent keyEvent) {
                return false;
            }

            @Override // com.baidu.mobads.sdk.internal.cr.a
            public void onLayoutComplete(int i10, int i11) {
                if (this.mIsFirstOnLayout) {
                    if (SplashAd.this.mAdProd == null) {
                        SplashAd.this.callAdFailed("展现失败，请检查splashAd参数是否正确");
                        return;
                    }
                    SplashAd.this.mAdProd.f7176u = false;
                    SplashAd.this.mFetchNotShow = false;
                    this.mIsFirstOnLayout = false;
                    SplashAd.this.mAdProd.a(crVar);
                    SplashAd.this.mAdProd.e();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cr.a
            public void onWindowFocusChanged(boolean z10) {
                if (SplashAd.this.mAdProd != null) {
                    SplashAd.this.mAdProd.a(z10);
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cr.a
            public void onWindowVisibilityChanged(int i10) {
                if (SplashAd.this.mAdProd != null) {
                    SplashAd.this.mAdProd.b(i10);
                }
            }
        });
        this.mViewParent.addView(crVar2);
    }

    public void biddingFail(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.a(false, linkedHashMap, biddingListener);
        }
    }

    public void biddingSuccess(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.a(true, linkedHashMap, biddingListener);
        }
    }

    public void destroy() {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.p();
        }
        this.mListener = null;
    }

    public void finishAndJump(Intent intent) {
        finishAndJump(intent, null);
    }

    public Object getAdDataForKey(String str) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            return diVar.j(str);
        }
        return null;
    }

    public String getBiddingToken() {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.r();
            this.mAdProd = null;
        }
        float e10 = ba.e(this.mContext);
        Rect a10 = ba.a(this.mContext);
        int width = a10.width();
        int height = a10.height();
        RequestParameters requestParameters = this.mParameter;
        if (requestParameters != null && requestParameters.isCustomSize()) {
            if (this.mParameter.getWidth() > 0) {
                width = (int) (this.mParameter.getWidth() * e10);
            }
            if (this.mParameter.getHeight() > 0) {
                height = (int) (this.mParameter.getHeight() * e10);
            }
        }
        int i10 = height;
        int i11 = width;
        if (i11 < 200.0f * e10 || i10 < e10 * 150.0f) {
            bt.a().c(dc.a().a(bp.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
            SplashAdListener splashAdListener = this.mListener;
            if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
                ((SplashInteractionListener) splashAdListener).onAdDismissed();
            }
            return null;
        }
        di diVar2 = new di(this.mContext, this.mAdPlaceId, i11, i10, this.mTipStyle, this.mTimeout, this.mDisplayDownInfo, this.mPopDialogIfDL.booleanValue(), this.mDisplayClickRegion.booleanValue(), this.mLimitRegionClick.booleanValue());
        this.mAdProd = diVar2;
        diVar2.d(this.mShakeLogoSize);
        this.mAdProd.a(this.mTwistLogoHeightDp);
        this.mAdProd.c(this.mTwistBgColor);
        this.mAdProd.h(this.mAppSid);
        di diVar3 = this.mAdProd;
        diVar3.f6889r = this.mBidFloor;
        diVar3.f7176u = true;
        RequestParameters requestParameters2 = this.mParameter;
        if (requestParameters2 != null) {
            diVar3.a(requestParameters2);
        }
        this.mAdProd.a(this.mListener);
        this.mFetchNotShow = true;
        this.mAdProd.a(this.mDownloadDialogListener);
        return this.mAdProd.l();
    }

    public String getECPMLevel() {
        a g10;
        di diVar = this.mAdProd;
        return (diVar == null || (g10 = diVar.g()) == null) ? "" : g10.z();
    }

    public String getPECPM() {
        a g10;
        di diVar = this.mAdProd;
        return (diVar == null || (g10 = diVar.g()) == null) ? "" : g10.A();
    }

    public final boolean hasSplashCardView() {
        di diVar = this.mAdProd;
        if (diVar != null) {
            return diVar.f();
        }
        return false;
    }

    public boolean isReady() {
        IAdInterListener iAdInterListener;
        di diVar = this.mAdProd;
        if (diVar == null || (iAdInterListener = diVar.f6884m) == null) {
            return false;
        }
        return iAdInterListener.isAdReady();
    }

    public final void load() {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.r();
            this.mAdProd = null;
        }
        float e10 = ba.e(this.mContext);
        Rect a10 = ba.a(this.mContext);
        int width = a10.width();
        int height = a10.height();
        RequestParameters requestParameters = this.mParameter;
        if (requestParameters != null && requestParameters.isCustomSize()) {
            if (this.mParameter.getWidth() > 0) {
                width = (int) (this.mParameter.getWidth() * e10);
            }
            if (this.mParameter.getHeight() > 0) {
                height = (int) (this.mParameter.getHeight() * e10);
            }
        }
        int i10 = height;
        int i11 = width;
        if (i11 < 200.0f * e10 || i10 < e10 * 150.0f) {
            bt.a().c(dc.a().a(bp.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
            SplashAdListener splashAdListener = this.mListener;
            if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
                return;
            }
            ((SplashInteractionListener) splashAdListener).onAdDismissed();
            return;
        }
        di diVar2 = new di(this.mContext, this.mAdPlaceId, i11, i10, this.mTipStyle, this.mTimeout, this.mDisplayDownInfo, this.mPopDialogIfDL.booleanValue(), this.mDisplayClickRegion.booleanValue(), this.mLimitRegionClick.booleanValue());
        this.mAdProd = diVar2;
        diVar2.d(this.mShakeLogoSize);
        this.mAdProd.a(this.mTwistLogoHeightDp);
        this.mAdProd.c(this.mTwistBgColor);
        this.mAdProd.h(this.mAppSid);
        di diVar3 = this.mAdProd;
        diVar3.f6889r = this.mBidFloor;
        diVar3.f7176u = true;
        RequestParameters requestParameters2 = this.mParameter;
        if (requestParameters2 != null) {
            diVar3.a(requestParameters2);
        }
        this.mAdProd.a(this.mListener);
        this.mFetchNotShow = true;
        this.mAdProd.a(this.mDownloadDialogListener);
        this.mAdProd.a();
    }

    public void loadAndShow(ViewGroup viewGroup) {
        if (viewGroup == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("传入容器不可以为空");
                this.mListener.onAdFailed("传入容器不可以为空");
                return;
            }
            return;
        }
        if (this.mIsAdaptiveSplashAd) {
            if (this.mListener != null) {
                sendSplashFailedLog("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                this.mListener.onAdFailed("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                return;
            }
            return;
        }
        addZeroPxSurfaceViewAvoidBlink(viewGroup, this.mContext);
        cr crVar = new cr(this.mContext);
        crVar.a(new cr.a() { // from class: com.baidu.mobads.sdk.api.SplashAd.3
            final /* synthetic */ cr val$prodContainer;

            public AnonymousClass3(cr crVar2) {
                crVar = crVar2;
            }

            @Override // com.baidu.mobads.sdk.internal.cr.a
            public void dispatchTouchEvent(MotionEvent motionEvent) {
                if (SplashAd.this.mAdProd != null) {
                    SplashAd.this.mAdProd.a(motionEvent);
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cr.a
            public void onAttachedToWindow() {
                if (SplashAd.this.mAdProd != null) {
                    SplashAd.this.mAdProd.n();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cr.a
            public void onDetachedFromWindow() {
                if (SplashAd.this.mAdProd != null) {
                    SplashAd.this.mAdProd.o();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cr.a
            public boolean onKeyDown(int i10, KeyEvent keyEvent) {
                return false;
            }

            @Override // com.baidu.mobads.sdk.internal.cr.a
            public void onLayoutComplete(int i10, int i11) {
                if (SplashAd.this.mAdProd != null) {
                    return;
                }
                float e10 = ba.e(SplashAd.this.mContext);
                if (SplashAd.this.mParameter != null && SplashAd.this.mParameter.isCustomSize()) {
                    if (SplashAd.this.mParameter.getWidth() > 0) {
                        i10 = (int) (SplashAd.this.mParameter.getWidth() * e10);
                    }
                    if (SplashAd.this.mParameter.getHeight() > 0) {
                        i11 = (int) (SplashAd.this.mParameter.getHeight() * e10);
                    }
                }
                int i12 = i10;
                int i13 = i11;
                if (i12 < 200.0f * e10 || i13 < e10 * 150.0f) {
                    bt.a().c(dc.a().a(bp.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
                    if (SplashAd.this.mListener == null || !(SplashAd.this.mListener instanceof SplashInteractionListener)) {
                        return;
                    }
                    ((SplashInteractionListener) SplashAd.this.mListener).onAdDismissed();
                    return;
                }
                SplashAd.this.mAdProd = new di(SplashAd.this.mContext, SplashAd.this.mAdPlaceId, i12, i13, SplashAd.this.mTipStyle, SplashAd.this.mTimeout, SplashAd.this.mDisplayDownInfo, SplashAd.this.mPopDialogIfDL.booleanValue(), SplashAd.this.mDisplayClickRegion.booleanValue(), SplashAd.this.mLimitRegionClick.booleanValue());
                SplashAd.this.mAdProd.a(crVar);
                SplashAd.this.mAdProd.d(SplashAd.this.mShakeLogoSize);
                SplashAd.this.mAdProd.a(SplashAd.this.mTwistLogoHeightDp);
                SplashAd.this.mAdProd.c(SplashAd.this.mTwistBgColor);
                SplashAd.this.mAdProd.h(SplashAd.this.mAppSid);
                SplashAd.this.mAdProd.f6889r = SplashAd.this.mBidFloor;
                SplashAd.this.mAdProd.a(SplashAd.this.mListener);
                if (SplashAd.this.mParameter != null) {
                    SplashAd.this.mAdProd.a(SplashAd.this.mParameter);
                }
                SplashAd.this.mAdProd.f7176u = false;
                SplashAd.this.mAdProd.a(SplashAd.this.mDownloadDialogListener);
                SplashAd.this.mAdProd.a();
            }

            @Override // com.baidu.mobads.sdk.internal.cr.a
            public void onWindowFocusChanged(boolean z10) {
                if (SplashAd.this.mAdProd != null) {
                    SplashAd.this.mAdProd.a(z10);
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cr.a
            public void onWindowVisibilityChanged(int i10) {
                if (SplashAd.this.mAdProd != null) {
                    SplashAd.this.mAdProd.b(i10);
                }
            }
        });
        crVar2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        viewGroup.addView(crVar2);
    }

    public void loadBiddingAd(String str) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.c(str);
        }
    }

    public void setAppSid(String str) {
        this.mAppSid = str;
    }

    public void setBidFloor(int i10) {
        this.mBidFloor = i10;
    }

    @Deprecated
    public void setBiddingData(String str) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.b(str);
        }
    }

    public void setDownloadDialogListener(SplashAdDownloadDialogListener splashAdDownloadDialogListener) {
        this.mDownloadDialogListener = splashAdDownloadDialogListener;
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.a(splashAdDownloadDialogListener);
        }
    }

    public void setListener(SplashAdListener splashAdListener) {
        this.mListener = splashAdListener;
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.a(splashAdListener);
        }
    }

    public final void show(ViewGroup viewGroup) {
        showWithBottomView(viewGroup, null);
    }

    public final boolean showSplashCardView(Activity activity, SplashCardAdListener splashCardAdListener) {
        di diVar = this.mAdProd;
        if (diVar == null) {
            return false;
        }
        diVar.a(splashCardAdListener);
        return this.mAdProd.b(activity);
    }

    public SplashAd(Context context, String str, RequestParameters requestParameters, SplashAdListener splashAdListener) {
        this.mTipStyle = 4;
        this.mFetchAd = true;
        this.mFetchNotShow = false;
        this.mDisplayDownInfo = true;
        this.mPopDialogIfDL = Boolean.FALSE;
        Boolean bool = Boolean.TRUE;
        this.mLimitRegionClick = bool;
        this.mDisplayClickRegion = bool;
        this.mTimeout = 4200;
        this.mShakeLogoSize = 60;
        this.mTwistLogoHeightDp = 67;
        this.mTwistBgColor = -16777216;
        this.mIsAdaptiveSplashAd = false;
        this.mBidFloor = -1;
        this.mListener = new SplashInteractionListener() { // from class: com.baidu.mobads.sdk.api.SplashAd.1
            public AnonymousClass1() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onADLoaded() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheSuccess() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdClick() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdDismissed() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdExposed() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onAdFailed(String str2) {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdPresent() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdSkip() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onLpClosed() {
            }
        };
        this.mContext = context;
        this.mAdPlaceId = str;
        if (splashAdListener != null) {
            this.mListener = splashAdListener;
        }
        if (TextUtils.isEmpty(str)) {
            sendSplashFailedLog("请您输入正确的广告位ID");
            this.mListener.onAdFailed("请您输入正确的广告位ID");
            return;
        }
        this.mParameter = requestParameters;
        if (requestParameters == null || requestParameters.getExtras() == null) {
            return;
        }
        String str2 = this.mParameter.getExtras().get(KEY_FETCHAD);
        if (!TextUtils.isEmpty(str2)) {
            this.mFetchAd = Boolean.parseBoolean(str2);
        }
        String str3 = this.mParameter.getExtras().get(KEY_DISPLAY_DOWNLOADINFO);
        if (!TextUtils.isEmpty(str3)) {
            this.mDisplayDownInfo = Boolean.parseBoolean(str3);
        }
        String str4 = this.mParameter.getExtras().get(KEY_POPDIALOG_DOWNLOAD);
        if (!TextUtils.isEmpty(str4)) {
            this.mPopDialogIfDL = Boolean.valueOf(str4);
        }
        String str5 = this.mParameter.getExtras().get(KEY_SHAKE_LOGO_SIZE);
        if (!TextUtils.isEmpty(str5)) {
            this.mShakeLogoSize = Integer.parseInt(str5);
        }
        String str6 = this.mParameter.getExtras().get(KEY_TWIST_LOGO_HEIGHT_DP);
        if (!TextUtils.isEmpty(str6)) {
            this.mTwistLogoHeightDp = Integer.parseInt(str6);
        }
        String str7 = this.mParameter.getExtras().get(KEY_TWIST_BG_COLOR);
        if (!TextUtils.isEmpty(str7)) {
            this.mTwistBgColor = Integer.parseInt(str7);
        }
        String str8 = this.mParameter.getExtras().get("timeout");
        if (!TextUtils.isEmpty(str8)) {
            this.mTimeout = Integer.parseInt(str8);
        }
        String str9 = this.mParameter.getExtras().get(KEY_USE_ADAPTIVE_AD);
        if (TextUtils.isEmpty(str9)) {
            return;
        }
        this.mIsAdaptiveSplashAd = Boolean.parseBoolean(str9);
    }

    public static void registerEnterTransition(Activity activity, SplashFocusParams splashFocusParams, SplashFocusAdListener splashFocusAdListener) {
        di.a(activity, splashFocusParams != null ? splashFocusParams.getFocusParams() : null, splashFocusAdListener);
    }

    public void finishAndJump(Intent intent, OnFinishListener onFinishListener) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.a(intent, onFinishListener);
        }
    }

    public static void registerEnterTransition(Activity activity, int i10, int i11, SplashFocusAdListener splashFocusAdListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("right_margin", i10);
            jSONObject.put("bottom_margin", i11);
        } catch (JSONException e10) {
            bt.a().a(e10);
        }
        di.a(activity, jSONObject, splashFocusAdListener);
    }

    @Deprecated
    public static void registerEnterTransition(Activity activity, int i10, int i11, int i12, SplashFocusAdListener splashFocusAdListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("right_margin", i10);
            jSONObject.put("bottom_margin", i11);
            jSONObject.put("anim_offset_y", i12);
        } catch (JSONException e10) {
            bt.a().a(e10);
        }
        di.a(activity, jSONObject, splashFocusAdListener);
    }
}
