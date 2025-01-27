package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.shu.priory.config.AdKeys;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class dd extends bi {
    private ExpressInterstitialListener A;
    private ExpressInterstitialAd.InterAdDownloadWindowListener B;
    private ExpressInterstitialAd.InterstitialAdDislikeListener C;
    private a D;
    private boolean E;
    private boolean F;

    /* renamed from: a */
    RelativeLayout f7146a;

    /* renamed from: t */
    public boolean f7147t;

    /* renamed from: u */
    public boolean f7148u;

    /* renamed from: v */
    private int f7149v;

    /* renamed from: w */
    private String f7150w;

    /* renamed from: x */
    private String f7151x;

    /* renamed from: y */
    private int f7152y;

    /* renamed from: z */
    private int f7153z;

    public dd(Context context, RelativeLayout relativeLayout, String str) {
        super(context);
        this.f7149v = 8000;
        this.f7150w = IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL;
        this.f7152y = 600;
        this.f7153z = 500;
        this.E = false;
        this.f7146a = relativeLayout;
        this.f7151x = str;
    }

    public void a(ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener) {
        this.B = interAdDownloadWindowListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void b() {
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdCacheSuccess();
            this.A.onVideoDownloadSuccess();
        }
    }

    public void c(boolean z10) {
        this.E = z10;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void d(String str) {
    }

    public String e() {
        return this.f7150w;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void f(String str) {
    }

    public void g() {
        IAdInterListener iAdInterListener = this.f6884m;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void h(IOAdEvent iOAdEvent) {
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public JSONObject j() {
        this.f6890s = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.f7150w);
            this.f6884m.createProdHandler(jSONObject2);
            this.f6884m.setAdContainer(this.f7146a);
            m();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.f7150w);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f7151x);
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.f6888q)) {
                jSONObject.put("appid", this.f6888q);
            }
            if (cq.a().b()) {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
            } else {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
            }
            jSONObject.put("at", "10");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + ba.b(this.f6880i));
            jSONObject.put("h", "" + ba.c(this.f6880i));
            jSONObject.put("msa", 151);
            jSONObject.put("opt", 1);
            jSONObject = m.a(jSONObject, b(this.f6886o));
            b(jSONObject);
            return jSONObject;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("onlyLoadAd", this.f7147t);
            jSONObject.put(SplashAd.KEY_POPDIALOG_DOWNLOAD, this.E);
            jSONObject.put("use_dialog_container", this.F);
            jSONObject.put("timeout", this.f7149v);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void u() {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.B;
        if (interAdDownloadWindowListener != null) {
            interAdDownloadWindowListener.onADPrivacyClose();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void v() {
    }

    public a x() {
        return this.D;
    }

    public void a(ExpressInterstitialAd.InterstitialAdDislikeListener interstitialAdDislikeListener) {
        this.C = interstitialAdDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void c() {
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdCacheFailed();
            this.A.onVideoDownloadFailed();
        }
    }

    public void d(boolean z10) {
        this.F = z10;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void e(IOAdEvent iOAdEvent) {
        this.f7148u = false;
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADExposed();
        }
    }

    public boolean f() {
        return this.f7148u;
    }

    public void a(int i10) {
        this.f7149v = i10;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void d() {
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onLpClosed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void f(IOAdEvent iOAdEvent) {
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADExposureFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void g(IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdClose();
        }
    }

    public void a(ExpressInterstitialListener expressInterstitialListener) {
        this.A = expressInterstitialListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void b(String str, boolean z10) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.B;
        if (interAdDownloadWindowListener != null) {
            if (z10) {
                interAdDownloadWindowListener.adDownloadWindowShow();
            } else {
                interAdDownloadWindowListener.adDownloadWindowClose();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a() {
        IAdInterListener iAdInterListener = this.f6884m;
        if (iAdInterListener == null) {
            this.f6885n = false;
            return;
        }
        this.f7148u = false;
        this.f6885n = true;
        iAdInterListener.loadAd(j(), k());
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void c(IOAdEvent iOAdEvent) {
        ExpressInterstitialAd.InterstitialAdDislikeListener interstitialAdDislikeListener = this.C;
        if (interstitialAdDislikeListener == null || iOAdEvent == null) {
            return;
        }
        interstitialAdDislikeListener.interstitialAdDislikeClick();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void e(String str) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.B;
        if (interAdDownloadWindowListener != null) {
            interAdDownloadWindowListener.onADPrivacyClick();
        }
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.f7152y = width;
            this.f7153z = height;
        }
        a(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(String str, int i10, String str2) {
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdFailed(i10, str);
        }
        super.a(str, i10, str2);
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(int i10, String str, String str2) {
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onNoAd(i10, str);
        }
        super.a(i10, str, str2);
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(String str, boolean z10) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.B;
        if (interAdDownloadWindowListener != null) {
            if (z10) {
                interAdDownloadWindowListener.onADPermissionShow();
            } else {
                interAdDownloadWindowListener.onADPermissionClose();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(IOAdEvent iOAdEvent) {
        List<a> a10;
        if (iOAdEvent != null && (a10 = b.a(iOAdEvent.getMessage()).a()) != null && a10.size() > 0) {
            this.D = a10.get(0);
        }
        this.f7148u = true;
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADLoaded();
        }
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
        a aVar = this.D;
        if (aVar != null) {
            a(aVar.I(), z10, linkedHashMap, biddingListener);
        } else {
            a(this.f6881j, z10, linkedHashMap, biddingListener);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(Map<String, String> map) {
        try {
            this.f6886o = m.a(map);
        } catch (Throwable unused) {
            this.f6886o = new HashMap<>();
        }
    }

    public Object a(String str) {
        if (this.D == null) {
            return null;
        }
        if (AdKeys.REQUEST_ID.equals(str)) {
            return this.D.V();
        }
        return this.D.a(str);
    }
}
