package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashAdListener;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class dn extends bf {
    private static int G;
    private static dn M;
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private int F;
    private SplashAdListener H;
    private SplashAd.OnFinishListener I;
    private SplashAd.SplashFocusAdListener J;
    private SplashAd.SplashCardAdListener K;
    private RequestParameters L;
    private a N;
    private SplashAd.SplashAdDownloadDialogListener O;
    private HashMap<String, String> P;

    /* renamed from: a */
    protected int f5798a;
    protected int q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    private RelativeLayout v;
    private String w;
    private int x;
    private int y;
    private int z;

    public dn(Context context, String str, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4) {
        super(context);
        this.F = 60;
        this.f5798a = 67;
        this.q = -16777216;
        this.s = false;
        this.t = false;
        this.u = false;
        this.w = str;
        this.x = i2;
        this.y = i3;
        this.z = i4;
        this.A = i5;
        this.B = z;
        this.C = z2;
        this.D = z4;
        this.E = z3;
    }

    private void b(Intent intent, SplashAd.OnFinishListener onFinishListener) {
        Context context = this.f5588h;
        if (context == null || intent == null) {
            return;
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        }
        this.f5588h.startActivity(intent);
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
            return;
        }
        Context context2 = this.f5588h;
        if (context2 instanceof Activity) {
            ((Activity) context2).finish();
        }
    }

    public static void e(int i2) {
        G = i2;
    }

    private String i(String str) {
        if (this.L == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Map<String, String> extras = this.L.getExtras();
            if (extras != null) {
                return extras.get(str);
            }
            return null;
        } catch (Throwable th) {
            this.f5589i.d(bf.f5582b, th);
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b_() {
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdCacheSuccess();
        }
        super.b_();
    }

    public void c(int i2) {
        this.q = i2;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void c_() {
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdCacheFailed();
        }
        super.c_();
    }

    public void d(int i2) {
        this.F = i2;
    }

    public void f() {
        IAdInterListener iAdInterListener;
        if (this.r || (iAdInterListener = this.k) == null) {
            return;
        }
        iAdInterListener.setAdContainer(this.v);
        this.k.showAd();
    }

    public boolean g() {
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
        } catch (JSONException e2) {
            bq.a().c(e2);
            return false;
        } catch (Throwable th) {
            bq.a().c(th);
            return false;
        }
    }

    public a h() {
        return this.N;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject k() {
        String str = "1";
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_SPLASH);
            this.k.createProdHandler(jSONObject2);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_SPLASH);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.w);
            jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,HTML,MSSP,VIDEO,RSPLASHHTML");
            jSONObject.put("n", "1");
            jSONObject.put("at", "26");
            jSONObject.put("mimetype", "video/mp4,image/jpg,image/gif,image/png");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.x);
            jSONObject.put("h", "" + this.y);
            jSONObject.put("msa", 399);
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            String i2 = i(SplashAd.KEY_USE_ADAPTIVE_AD);
            if (!TextUtils.isEmpty(i2)) {
                if (!Boolean.parseBoolean(i2)) {
                    str = "0";
                }
                jSONObject.put("adtv", str);
            }
            jSONObject = j.a(jSONObject, b(this.P));
            b(jSONObject);
            return jSONObject;
        } catch (Exception e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", this.A);
            jSONObject.put("splashTipStyle", this.z);
            jSONObject.put("bitmapDisplayMode", G);
            jSONObject.put("countDownNew", "true");
            jSONObject.put("Display_Down_Info", "" + this.B);
            jSONObject.put("popDialogIfDl", "" + this.C);
            jSONObject.put("limitRegionClick", "" + this.D);
            jSONObject.put("displayClickButton", "" + this.E);
            jSONObject.put("needCache", true);
            jSONObject.put("onlyLoadAd", this.r);
            jSONObject.put("cacheVideoOnlyWifi", true);
            jSONObject.put("shakeLogoSize", this.F);
            jSONObject.put("twistLogoHeightDp", this.f5798a);
            jSONObject.put("twistBgColor", this.q);
            RequestParameters requestParameters = this.L;
            if (requestParameters != null) {
                a(requestParameters.getExtras());
            }
            return j.a(jSONObject, b(this.m));
        } catch (Exception e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void q() {
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdPresent();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.J;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onAdIconShow();
        }
        SplashAd.SplashCardAdListener splashCardAdListener = this.K;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardShow();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void t() {
        SplashAd.OnFinishListener onFinishListener = this.I;
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
            this.I = null;
        } else {
            Context context = this.f5588h;
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
        }
        this.f5588h = null;
        this.v = null;
        super.t();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void u() {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADPrivacyLpClose();
    }

    public void a(RelativeLayout relativeLayout) {
        this.v = relativeLayout;
    }

    public void c(Map<String, String> map) {
        try {
            this.P = j.a(map);
        } catch (Throwable unused) {
            this.P = new HashMap<>();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void d() {
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onLpClosed();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.J;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onLpClosed();
        }
        super.d();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void e(String str) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADPrivacyLpShow();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void h(IOAdEvent iOAdEvent) {
        this.s = true;
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdClick();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.J;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onAdClick();
        }
        SplashAd.SplashCardAdListener splashCardAdListener = this.K;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardClick();
        }
    }

    public void a(int i2) {
        this.f5798a = i2;
    }

    public void a(SplashAdListener splashAdListener) {
        this.H = splashAdListener;
    }

    public void a(SplashAd.SplashFocusAdListener splashFocusAdListener) {
        this.J = splashFocusAdListener;
        this.t = false;
    }

    public void a(SplashAd.SplashCardAdListener splashCardAdListener) {
        this.K = splashCardAdListener;
        this.t = false;
    }

    public boolean b(Activity activity) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            this.k.removeAllListeners();
            this.k.addEventListener(w.M, this.f5590j);
            this.k.addEventListener(w.H, this.f5590j);
            this.k.addEventListener(w.W, this.f5590j);
            this.H = null;
            jSONObject.putOpt("event_type", "splash_focus_card");
            hashMap.put("splash_focus_activity", activity);
            a(jSONObject, hashMap);
            Object obj = hashMap.get("splash_focus_card_show");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        } catch (JSONException e2) {
            bq.a().c(e2);
            return false;
        } catch (Throwable th) {
            bq.a().c(th);
            return false;
        }
    }

    public void a(RequestParameters requestParameters) {
        this.L = requestParameters;
        c(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void g(IOAdEvent iOAdEvent) {
        if (this.t) {
            return;
        }
        this.t = true;
        Map<String, Object> data = iOAdEvent.getData();
        if (this.J != null && data != null && data.containsKey("splash_close_reason")) {
            this.J.onAdClose();
            return;
        }
        SplashAd.SplashCardAdListener splashCardAdListener = this.K;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardClose();
            return;
        }
        super.g(iOAdEvent);
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
            return;
        }
        ((SplashInteractionListener) splashAdListener).onAdDismissed();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener == null) {
            this.l = false;
            return;
        }
        this.l = true;
        if (!this.r) {
            iAdInterListener.setAdContainer(this.v);
        }
        this.k.loadAd(k(), l());
    }

    public void a(@NonNull Intent intent, @Nullable SplashAd.OnFinishListener onFinishListener) {
        try {
            if (!this.s && intent != null && this.k != null && !this.u && (this.f5588h instanceof Activity)) {
                this.I = onFinishListener;
                JSONObject jSONObject = new JSONObject();
                HashMap hashMap = new HashMap();
                try {
                    jSONObject.putOpt("event_type", "splash_focus_start_activity");
                    hashMap.put("splash_focus_user_intent", intent);
                } catch (JSONException e2) {
                    bq.a().a(e2);
                }
                this.k.removeAllListeners();
                this.k.addEventListener(w.Z, this.f5590j);
                this.k.addEventListener(w.M, this.f5590j);
                this.k.addEventListener(w.H, this.f5590j);
                this.k.addEventListener(w.W, this.f5590j);
                this.k.addEventListener(w.X, this.f5590j);
                a(jSONObject, hashMap);
                this.H = null;
                M = this;
                ba.a().a(new Cdo(this), 3L, TimeUnit.SECONDS);
                return;
            }
            b(intent, onFinishListener);
        } catch (Throwable th) {
            th.printStackTrace();
            b(intent, onFinishListener);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(String str, int i2) {
        this.u = true;
        if (this.H != null) {
            a(i2 + "==" + str);
            this.H.onAdFailed(str);
        }
        super.b(str, i2);
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(String str, boolean z) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        if (z) {
            splashAdDownloadDialogListener.adDownloadWindowShow();
        } else {
            splashAdDownloadDialogListener.adDownloadWindowClose();
        }
    }

    public static void a(Activity activity, JSONObject jSONObject, SplashAd.SplashFocusAdListener splashFocusAdListener) {
        dn dnVar = M;
        if (dnVar != null) {
            dnVar.a(splashFocusAdListener);
            HashMap hashMap = new HashMap();
            JSONObject jSONObject2 = new JSONObject();
            try {
                try {
                    jSONObject2.putOpt("event_type", "splash_focus_register_transition");
                    jSONObject2.putOpt("splash_focus_params", jSONObject);
                    hashMap.put("splash_focus_activity", activity);
                    M.a(jSONObject2, hashMap);
                } catch (JSONException e2) {
                    bq.a().c(e2);
                } catch (Throwable th) {
                    bq.a().c(th);
                }
            } finally {
                M = null;
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(IOAdEvent iOAdEvent) {
        List<a> a2;
        if (iOAdEvent != null && (a2 = b.a(iOAdEvent.getMessage()).a()) != null && a2.size() > 0) {
            this.N = a2.get(0);
        }
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null) {
            splashAdListener.onADLoaded();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(int i2, String str) {
        this.u = true;
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null) {
            splashAdListener.onAdFailed("广告无填充");
        }
        super.a(i2, str);
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(String str, boolean z) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        if (z) {
            splashAdDownloadDialogListener.onADPermissionShow();
        } else {
            splashAdDownloadDialogListener.onADPermissionClose();
        }
    }

    public void a(SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener) {
        this.O = splashAdDownloadDialogListener;
    }

    public void a(boolean z, String str) {
        a(z, str, (HashMap<String, Object>) null);
    }

    public void a(boolean z, String str, HashMap<String, Object> hashMap) {
        a aVar = this.N;
        if (aVar != null) {
            a(aVar.G(), z, str, hashMap);
        }
    }

    public void a(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("msg", str);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("msg", "sendSplashFailedLog");
            } catch (JSONException e2) {
                bq.a().a(e2);
            }
            a(jSONObject, hashMap);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
