package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashAdListener;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import com.shu.priory.config.AdKeys;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class di extends bi {
    private static int J;
    private static di P;
    private int A;
    private int B;
    private int C;
    private int D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private int I;
    private SplashAdListener K;
    private SplashAd.OnFinishListener L;
    private SplashAd.SplashFocusAdListener M;
    private SplashAd.SplashCardAdListener N;
    private RequestParameters O;
    private a Q;
    private SplashAd.SplashAdDownloadDialogListener R;
    private HashMap<String, String> S;

    /* renamed from: a */
    protected int f7174a;

    /* renamed from: t */
    protected int f7175t;

    /* renamed from: u */
    public boolean f7176u;

    /* renamed from: v */
    public boolean f7177v;

    /* renamed from: w */
    public boolean f7178w;

    /* renamed from: x */
    public boolean f7179x;

    /* renamed from: y */
    private RelativeLayout f7180y;

    /* renamed from: z */
    private String f7181z;

    public di(Context context, String str, int i10, int i11, int i12, int i13, boolean z10, boolean z11, boolean z12, boolean z13) {
        super(context);
        this.I = 60;
        this.f7174a = 67;
        this.f7175t = -16777216;
        this.f7177v = false;
        this.f7178w = false;
        this.f7179x = false;
        this.f7181z = str;
        this.A = i10;
        this.B = i11;
        this.C = i12;
        this.D = i13;
        this.E = z10;
        this.F = z11;
        this.G = z13;
        this.H = z12;
    }

    private void b(Intent intent, SplashAd.OnFinishListener onFinishListener) {
        Context context = this.f6880i;
        if (context == null || intent == null) {
            return;
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        this.f6880i.startActivity(intent);
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
            return;
        }
        Context context2 = this.f6880i;
        if (context2 instanceof Activity) {
            ((Activity) context2).finish();
        }
    }

    public static void e(int i10) {
        J = i10;
    }

    private String k(String str) {
        if (this.O == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Map<String, String> extras = this.O.getExtras();
            if (extras != null) {
                return extras.get(str);
            }
            return null;
        } catch (Throwable th2) {
            this.f6882k.d(bi.f6873b, th2);
            return null;
        }
    }

    public void c(int i10) {
        this.f7175t = i10;
    }

    public void d(int i10) {
        this.I = i10;
    }

    public boolean f() {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("event_type", "splash_focus_card_enable");
            a(jSONObject, hashMap);
            Object obj = hashMap.get("splash_focus_card_enable");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        } catch (JSONException e10) {
            bt.a().c(e10);
            return false;
        } catch (Throwable th2) {
            bt.a().c(th2);
            return false;
        }
    }

    public a g() {
        return this.Q;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void h(IOAdEvent iOAdEvent) {
        this.f7177v = true;
        SplashAdListener splashAdListener = this.K;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdClick();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.M;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onAdClick();
        }
        SplashAd.SplashCardAdListener splashCardAdListener = this.N;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public JSONObject j() {
        String str = "1";
        this.f6890s = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_SPLASH);
            this.f6884m.createProdHandler(jSONObject2);
            m();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_SPLASH);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f7181z);
            jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,HTML,MSSP,VIDEO,RSPLASHHTML");
            jSONObject.put("n", "1");
            jSONObject.put("at", "26");
            jSONObject.put(IAdInterListener.AdReqParam.MIME_TYPE, "video/mp4,image/jpg,image/gif,image/png");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.A);
            jSONObject.put("h", "" + this.B);
            jSONObject.put("msa", 399);
            if (!TextUtils.isEmpty(this.f6888q)) {
                jSONObject.put("appid", this.f6888q);
            }
            String k10 = k(SplashAd.KEY_USE_ADAPTIVE_AD);
            if (!TextUtils.isEmpty(k10)) {
                if (!Boolean.parseBoolean(k10)) {
                    str = "0";
                }
                jSONObject.put("adtv", str);
            }
            jSONObject = m.a(jSONObject, b(this.S));
            b(jSONObject);
            return jSONObject;
        } catch (Exception e10) {
            e10.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void q() {
        SplashAdListener splashAdListener = this.K;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdPresent();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.M;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onAdIconShow();
        }
        SplashAd.SplashCardAdListener splashCardAdListener = this.N;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardShow();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void t() {
        SplashAd.OnFinishListener onFinishListener = this.L;
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
            this.L = null;
        } else {
            Context context = this.f6880i;
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
        }
        this.f6880i = null;
        this.f7180y = null;
        super.t();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void u() {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.R;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADPrivacyLpClose();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void v() {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.R;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADFunctionLpClose();
    }

    public void a(RelativeLayout relativeLayout) {
        this.f7180y = relativeLayout;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void c() {
        SplashAdListener splashAdListener = this.K;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdCacheFailed();
        }
        super.c();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void d() {
        SplashAdListener splashAdListener = this.K;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onLpClosed();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.M;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onLpClosed();
        }
        super.d();
    }

    public void e() {
        IAdInterListener iAdInterListener;
        if (this.f7176u || (iAdInterListener = this.f6884m) == null) {
            return;
        }
        iAdInterListener.setAdContainer(this.f7180y);
        this.f6884m.showAd();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void g(IOAdEvent iOAdEvent) {
        if (this.f7178w) {
            return;
        }
        this.f7178w = true;
        Map<String, Object> data = iOAdEvent.getData();
        if (this.M != null && data != null && data.containsKey("splash_close_reason")) {
            this.M.onAdClose();
            return;
        }
        SplashAd.SplashCardAdListener splashCardAdListener = this.N;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardClose();
            return;
        }
        super.g(iOAdEvent);
        SplashAdListener splashAdListener = this.K;
        if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
            return;
        }
        ((SplashInteractionListener) splashAdListener).onAdDismissed();
    }

    public void a(int i10) {
        this.f7174a = i10;
    }

    public void a(SplashAdListener splashAdListener) {
        this.K = splashAdListener;
    }

    public void a(SplashAd.SplashFocusAdListener splashFocusAdListener) {
        this.M = splashFocusAdListener;
        this.f7178w = false;
    }

    public void c(Map<String, String> map) {
        try {
            this.S = m.a(map);
        } catch (Throwable unused) {
            this.S = new HashMap<>();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void e(IOAdEvent iOAdEvent) {
        SplashAdListener splashAdListener = this.K;
        if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
            return;
        }
        ((SplashInteractionListener) splashAdListener).onAdExposed();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", this.D);
            jSONObject.put("splashTipStyle", this.C);
            jSONObject.put("bitmapDisplayMode", J);
            jSONObject.put("countDownNew", "true");
            jSONObject.put("Display_Down_Info", "" + this.E);
            jSONObject.put("popDialogIfDl", "" + this.F);
            jSONObject.put("limitRegionClick", "" + this.G);
            jSONObject.put("displayClickButton", "" + this.H);
            jSONObject.put("needCache", true);
            jSONObject.put("onlyLoadAd", this.f7176u);
            jSONObject.put("cacheVideoOnlyWifi", true);
            jSONObject.put("shakeLogoSize", this.I);
            jSONObject.put("twistLogoHeightDp", this.f7174a);
            jSONObject.put("twistBgColor", this.f7175t);
            RequestParameters requestParameters = this.O;
            if (requestParameters != null) {
                a(requestParameters.getExtras());
            }
            return m.a(jSONObject, b(this.f6886o));
        } catch (Exception e10) {
            e10.printStackTrace();
            return jSONObject;
        }
    }

    public void a(SplashAd.SplashCardAdListener splashCardAdListener) {
        this.N = splashCardAdListener;
        this.f7178w = false;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void e(String str) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.R;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADPrivacyLpShow();
    }

    public boolean b(Activity activity) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            this.f6884m.removeAllListeners();
            this.f6884m.addEventListener(z.L, this.f6883l);
            this.f6884m.addEventListener(z.G, this.f6883l);
            this.f6884m.addEventListener(z.V, this.f6883l);
            this.K = null;
            jSONObject.putOpt("event_type", "splash_focus_card");
            hashMap.put("splash_focus_activity", activity);
            a(jSONObject, hashMap);
            Object obj = hashMap.get("splash_focus_card_show");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        } catch (JSONException e10) {
            bt.a().c(e10);
            return false;
        } catch (Throwable th2) {
            bt.a().c(th2);
            return false;
        }
    }

    public void a(RequestParameters requestParameters) {
        this.O = requestParameters;
        c(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void f(String str) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.R;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADFunctionLpShow();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a() {
        IAdInterListener iAdInterListener = this.f6884m;
        if (iAdInterListener == null) {
            this.f6885n = false;
            return;
        }
        this.f6885n = true;
        if (!this.f7176u) {
            iAdInterListener.setAdContainer(this.f7180y);
        }
        this.f6884m.loadAd(j(), k());
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void g(String str) {
        SplashAdListener splashAdListener = this.K;
        if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
            return;
        }
        ((SplashInteractionListener) splashAdListener).onAdSkip();
    }

    public void a(@NonNull Intent intent, @Nullable SplashAd.OnFinishListener onFinishListener) {
        try {
            if (!this.f7177v && intent != null && this.f6884m != null && !this.f7179x && (this.f6880i instanceof Activity)) {
                this.L = onFinishListener;
                JSONObject jSONObject = new JSONObject();
                HashMap hashMap = new HashMap();
                try {
                    jSONObject.putOpt("event_type", "splash_focus_start_activity");
                    hashMap.put("splash_focus_user_intent", intent);
                } catch (JSONException e10) {
                    bt.a().a(e10);
                }
                this.f6884m.removeAllListeners();
                this.f6884m.addEventListener(z.Y, this.f6883l);
                this.f6884m.addEventListener(z.L, this.f6883l);
                this.f6884m.addEventListener(z.G, this.f6883l);
                this.f6884m.addEventListener(z.V, this.f6883l);
                this.f6884m.addEventListener(z.W, this.f6883l);
                a(jSONObject, hashMap);
                this.K = null;
                P = this;
                bd.a().a(new dj(this), 3L, TimeUnit.SECONDS);
                return;
            }
            b(intent, onFinishListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
            b(intent, onFinishListener);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void b() {
        SplashAdListener splashAdListener = this.K;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdCacheSuccess();
        }
        super.b();
    }

    public Object j(String str) {
        if (this.Q == null) {
            return null;
        }
        if (AdKeys.REQUEST_ID.equals(str)) {
            return this.Q.V();
        }
        return this.Q.a(str);
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void b(String str, boolean z10) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.R;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        if (z10) {
            splashAdDownloadDialogListener.adDownloadWindowShow();
        } else {
            splashAdDownloadDialogListener.adDownloadWindowClose();
        }
    }

    public static void a(Activity activity, JSONObject jSONObject, SplashAd.SplashFocusAdListener splashFocusAdListener) {
        di diVar = P;
        if (diVar != null) {
            diVar.a(splashFocusAdListener);
            HashMap hashMap = new HashMap();
            JSONObject jSONObject2 = new JSONObject();
            try {
                try {
                    try {
                        jSONObject2.putOpt("event_type", "splash_focus_register_transition");
                        jSONObject2.putOpt("splash_focus_params", jSONObject);
                        hashMap.put("splash_focus_activity", activity);
                        P.a(jSONObject2, hashMap);
                    } catch (JSONException e10) {
                        bt.a().c(e10);
                    }
                } finally {
                    P = null;
                }
                P = null;
            } catch (Throwable th2) {
                P = null;
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(IOAdEvent iOAdEvent) {
        List<a> a10;
        if (iOAdEvent != null && (a10 = b.a(iOAdEvent.getMessage()).a()) != null && a10.size() > 0) {
            this.Q = a10.get(0);
        }
        SplashAdListener splashAdListener = this.K;
        if (splashAdListener != null) {
            splashAdListener.onADLoaded();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(int i10, String str, String str2) {
        this.f7179x = true;
        SplashAdListener splashAdListener = this.K;
        if (splashAdListener != null) {
            splashAdListener.onAdFailed("广告无填充");
        }
        super.a(i10, str, str2);
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(String str, int i10, String str2) {
        this.f7179x = true;
        if (this.K != null) {
            a(i10 + "==" + str);
            this.K.onAdFailed(str);
        }
        super.a(str, i10, str2);
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(String str, boolean z10) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.R;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        if (z10) {
            splashAdDownloadDialogListener.onADPermissionShow();
        } else {
            splashAdDownloadDialogListener.onADPermissionClose();
        }
    }

    public void a(SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener) {
        this.R = splashAdDownloadDialogListener;
    }

    public void a(MotionEvent motionEvent) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("e_d_t", motionEvent.getDownTime());
            jSONObject.put("e_e_t", motionEvent.getEventTime());
            jSONObject.put("e_a", motionEvent.getAction());
            jSONObject.put("e_x", motionEvent.getX());
            jSONObject.put("e_y", motionEvent.getY());
            jSONObject.put("e_m_s", motionEvent.getMetaState());
            jSONObject.put("event_type", "x_event");
            a(jSONObject);
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z10, LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        a aVar = this.Q;
        if (aVar != null) {
            a(aVar.I(), z10, linkedHashMap, biddingListener);
        } else {
            a(this.f6881j, z10, linkedHashMap, biddingListener);
        }
    }

    public void a(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("msg", str);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("msg", "sendSplashFailedLog");
            } catch (JSONException e10) {
                bt.a().a(e10);
            }
            a(jSONObject, hashMap);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
