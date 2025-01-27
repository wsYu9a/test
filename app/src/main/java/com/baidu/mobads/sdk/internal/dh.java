package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.baidu.mobads.sdk.api.ScreenVideoAdListener;
import com.shu.priory.config.AdKeys;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class dh extends bi {
    private String A;
    private a B;
    private RequestParameters C;

    /* renamed from: a */
    private boolean f7166a;

    /* renamed from: t */
    private int f7167t;

    /* renamed from: u */
    private String f7168u;

    /* renamed from: v */
    private ScreenVideoAdListener f7169v;

    /* renamed from: w */
    private final String f7170w;

    /* renamed from: x */
    private int f7171x;

    /* renamed from: y */
    private int f7172y;

    /* renamed from: z */
    private String f7173z;

    public dh(Context context, String str, boolean z10) {
        this(context, str, z10, IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO);
    }

    public void a(Context context) {
        if (this.f6884m != null) {
            JSONObject jSONObject = new JSONObject();
            HashMap hashMap = new HashMap();
            try {
                jSONObject.put("msg", "setContext");
                hashMap.put(com.umeng.analytics.pro.f.X, context);
            } catch (JSONException e10) {
                bt.a().a(e10);
            }
            a(jSONObject, hashMap);
            this.f6884m.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void b() {
        ScreenVideoAdListener screenVideoAdListener = this.f7169v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void c() {
        ScreenVideoAdListener screenVideoAdListener = this.f7169v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onVideoDownloadFailed();
        }
    }

    public void e() {
        IAdInterListener iAdInterListener = this.f6884m;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    public boolean f() {
        IAdInterListener iAdInterListener = this.f6884m;
        if (iAdInterListener != null) {
            return iAdInterListener.isAdReady();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void g(IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        float floatValue = (iOAdEvent == null || iOAdEvent.getData() == null) ? 0.0f : ((Float) iOAdEvent.getData().get("play_scale")).floatValue();
        ScreenVideoAdListener screenVideoAdListener = this.f7169v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdClose(floatValue);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void h(IOAdEvent iOAdEvent) {
        ScreenVideoAdListener screenVideoAdListener = this.f7169v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdClick();
        }
    }

    public void j(String str) {
        this.A = str;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", 8000);
            jSONObject.put("useSurfaceView", this.f7166a);
            jSONObject.put("downloadConfirmPolicy", this.f7167t);
            jSONObject.put("userid", this.f7173z);
            jSONObject.put("extra", this.A);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void q() {
        ScreenVideoAdListener screenVideoAdListener = this.f7169v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdShow();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void s() {
        ScreenVideoAdListener screenVideoAdListener = this.f7169v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.playCompletion();
        }
    }

    public String x() {
        a aVar = this.B;
        return aVar != null ? aVar.A() : "";
    }

    public dh(Context context, String str, boolean z10, String str2) {
        super(context);
        this.f7167t = 3;
        this.f7168u = str;
        this.f7166a = z10;
        this.f7170w = str2;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public JSONObject j() {
        this.f6890s = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.f7170w);
            this.f6884m.createProdHandler(jSONObject2);
            m();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.f7170w);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f7168u);
            jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON");
            jSONObject.put("n", "1");
            jSONObject.put("at", "10");
            if (!TextUtils.isEmpty(this.f6888q)) {
                jSONObject.put("appid", this.f6888q);
            }
            Rect a10 = ba.a(this.f6880i);
            this.f7171x = a10.width();
            this.f7172y = a10.height();
            if (this.f6880i.getResources().getConfiguration().orientation == 2) {
                this.f7171x = a10.height();
                this.f7172y = a10.width();
            }
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.f7171x);
            jSONObject.put("h", "" + this.f7172y);
            jSONObject.put("opt", 1);
            if (IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO.equals(this.f7170w)) {
                jSONObject.put("msa", 5285);
            }
            jSONObject = m.a(jSONObject, b(this.f6886o));
            b(jSONObject);
            return jSONObject;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void b(boolean z10) {
        ScreenVideoAdListener screenVideoAdListener = this.f7169v;
        if (screenVideoAdListener == null || !(screenVideoAdListener instanceof RewardVideoAd.RewardVideoAdListener)) {
            return;
        }
        ((RewardVideoAd.RewardVideoAdListener) screenVideoAdListener).onRewardVerify(z10);
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void g(String str) {
        ScreenVideoAdListener screenVideoAdListener = this.f7169v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdSkip(Float.parseFloat(str));
        }
    }

    public String g() {
        a aVar = this.B;
        if (aVar != null) {
            return aVar.z();
        }
        return "";
    }

    public Object k(String str) {
        if (this.B == null) {
            return null;
        }
        if (AdKeys.REQUEST_ID.equals(str)) {
            return this.B.V();
        }
        return this.B.a(str);
    }

    public void a(int i10) {
        this.f7167t = i10;
    }

    public void a(String str) {
        this.f7173z = str;
    }

    public void a(ScreenVideoAdListener screenVideoAdListener) {
        this.f7169v = screenVideoAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a() {
        IAdInterListener iAdInterListener = this.f6884m;
        if (iAdInterListener == null) {
            this.f6885n = false;
        } else {
            this.f6885n = true;
            iAdInterListener.loadAd(j(), k());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(IOAdEvent iOAdEvent) {
        List<a> a10;
        if (iOAdEvent != null && (a10 = b.a(iOAdEvent.getMessage()).a()) != null && a10.size() > 0) {
            this.B = a10.get(0);
        }
        ScreenVideoAdListener screenVideoAdListener = this.f7169v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdLoaded();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(String str, int i10, String str2) {
        super.a(str, i10, str2);
        ScreenVideoAdListener screenVideoAdListener = this.f7169v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdFailed(str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(int i10, String str, String str2) {
        super.a(i10, str, str2);
        ScreenVideoAdListener screenVideoAdListener = this.f7169v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdFailed(str);
        }
    }

    public void a(boolean z10, LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        a aVar = this.B;
        if (aVar != null) {
            a(aVar.I(), z10, linkedHashMap, biddingListener);
        } else {
            a(this.f6881j, z10, linkedHashMap, biddingListener);
        }
    }

    public void a(RequestParameters requestParameters) {
        this.C = requestParameters;
        a(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(Map<String, String> map) {
        try {
            this.f6886o = m.a(map);
        } catch (Throwable unused) {
            this.f6886o = new HashMap<>();
        }
    }
}
