package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.AdView;
import com.baidu.mobads.sdk.api.AdViewListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class cp extends bf {

    /* renamed from: a */
    private RelativeLayout f5757a;
    private String q;
    private boolean r;
    private AdViewListener s;
    private int t;
    private int u;
    private AdView v;
    private RequestParameters w;

    public cp(AdView adView, Context context, RelativeLayout relativeLayout, String str, boolean z) {
        super(context);
        this.v = adView;
        this.f5757a = relativeLayout;
        this.q = str;
        this.r = z;
    }

    public void a(int i2) {
        this.t = i2;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(String str, int i2) {
        AdViewListener adViewListener = this.s;
        if (adViewListener != null) {
            adViewListener.onAdFailed(str);
        }
    }

    public void c(int i2) {
        this.u = i2;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void g(IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        AdViewListener adViewListener = this.s;
        if (adViewListener != null) {
            adViewListener.onAdClose(new JSONObject());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void h(IOAdEvent iOAdEvent) {
        AdViewListener adViewListener = this.s;
        if (adViewListener != null) {
            adViewListener.onAdClick(new JSONObject());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void q() {
        AdViewListener adViewListener = this.s;
        if (adViewListener != null) {
            adViewListener.onAdSwitch();
            this.s.onAdShow(new JSONObject());
        }
    }

    public void a(AdViewListener adViewListener) {
        this.s = adViewListener;
    }

    public void a(RequestParameters requestParameters) {
        this.w = requestParameters;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        if (this.k == null) {
            this.l = false;
            return;
        }
        this.l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, "banner");
            this.k.createProdHandler(jSONObject3);
            this.k.setAdContainer(this.f5757a);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, "banner");
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.q);
            jSONObject.put("at", "2");
            jSONObject.put("ABILITY", "BANNER_CLOSE,PAUSE,UNLIMITED_BANNER_SIZE,");
            jSONObject.put("AP", this.r);
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.t);
            jSONObject.put("h", "" + this.u);
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            RequestParameters requestParameters = this.w;
            if (requestParameters != null) {
                a(requestParameters.getExtras());
            }
            jSONObject2 = b(this.m);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.k.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(IOAdEvent iOAdEvent) {
        AdViewListener adViewListener = this.s;
        if (adViewListener != null) {
            adViewListener.onAdReady(this.v);
        }
    }
}
