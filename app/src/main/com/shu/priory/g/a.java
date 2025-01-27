package com.shu.priory.g;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.baidu.mobads.sdk.internal.bm;
import com.shu.priory.config.AdError;
import com.shu.priory.config.AdKeys;
import com.shu.priory.config.ErrorCode;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.utils.h;
import com.tencent.open.SocialConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a {
    public double A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public JSONArray G;
    public JSONObject H;
    public String I;
    public JSONObject J;
    public String K;
    public String L;
    public int M;
    public String N;
    public String O;
    public int P;
    public int Q = 1;
    public int R = 0;
    public JSONObject S;
    public String T;
    public String U;
    public String V;

    /* renamed from: a */
    public int f17074a;

    /* renamed from: b */
    public String f17075b;

    /* renamed from: c */
    public double f17076c;

    /* renamed from: d */
    public String f17077d;

    /* renamed from: e */
    public JSONObject f17078e;

    /* renamed from: f */
    public JSONObject f17079f;

    /* renamed from: g */
    public JSONObject f17080g;

    /* renamed from: h */
    public JSONObject f17081h;

    /* renamed from: i */
    public JSONObject f17082i;

    /* renamed from: j */
    public JSONObject f17083j;

    /* renamed from: k */
    public JSONObject f17084k;

    /* renamed from: l */
    public String f17085l;

    /* renamed from: m */
    public String f17086m;

    /* renamed from: n */
    public JSONObject f17087n;

    /* renamed from: o */
    public String f17088o;

    /* renamed from: p */
    public String f17089p;

    /* renamed from: q */
    public String f17090q;

    /* renamed from: r */
    public int f17091r;

    /* renamed from: s */
    public String f17092s;

    /* renamed from: t */
    public String f17093t;

    /* renamed from: u */
    public String f17094u;

    /* renamed from: v */
    public String f17095v;

    /* renamed from: w */
    public double f17096w;

    /* renamed from: x */
    public String f17097x;

    /* renamed from: y */
    public int f17098y;

    /* renamed from: z */
    public double f17099z;

    public void a() {
        this.f17074a = -1;
        this.f17075b = "";
        this.f17076c = -1.0d;
        this.f17077d = "";
        this.f17078e = null;
        this.f17079f = null;
        this.f17080g = null;
        this.f17081h = null;
        this.f17082i = null;
        this.f17083j = null;
        this.f17084k = null;
        this.f17085l = "";
        this.f17086m = "";
        this.f17087n = null;
        this.f17088o = "";
        this.f17089p = "";
        this.f17090q = "";
        this.f17091r = -1;
        this.f17092s = "";
        this.f17093t = "";
        this.f17094u = "";
        this.f17095v = "";
        this.f17096w = -1.0d;
        this.f17097x = "";
        this.f17098y = -1;
        this.f17099z = -1.0d;
        this.A = -1.0d;
        this.B = "";
        this.C = "";
        this.D = "";
        this.E = "";
        this.F = "";
        this.G = null;
        this.H = null;
        this.J = null;
        this.K = "";
        this.L = "";
        this.M = -1;
        this.N = "";
        this.T = "";
        this.U = "";
        this.V = "";
    }

    public void a(JSONObject jSONObject) throws AdError {
        try {
            a();
            this.f17074a = jSONObject.optInt(ExposeManager.UtArgsNames.templateId);
            this.f17075b = jSONObject.optString(ExposeManager.UtArgsNames.creativeId);
            this.f17076c = jSONObject.optDouble("price");
            this.f17077d = jSONObject.optString("deal_id");
            this.f17078e = jSONObject.optJSONObject(com.baidu.mobads.sdk.internal.a.f6640f);
            this.f17079f = jSONObject.optJSONObject(SocialConstants.PARAM_IMG_URL);
            this.f17080g = jSONObject.optJSONObject("img1");
            this.f17081h = jSONObject.optJSONObject("img2");
            this.f17082i = jSONObject.optJSONObject("img3");
            this.f17083j = jSONObject.optJSONObject("video");
            this.f17084k = jSONObject.optJSONObject("audio");
            this.f17085l = jSONObject.optString("title");
            this.f17086m = jSONObject.optString(SocialConstants.PARAM_APP_DESC);
            this.f17087n = jSONObject.optJSONObject("icon");
            this.f17088o = jSONObject.optString("content");
            this.f17089p = jSONObject.optString("ctatext");
            this.f17090q = jSONObject.optString("app_name");
            this.f17091r = jSONObject.optInt("downloads");
            this.f17092s = jSONObject.optString("rating");
            this.f17093t = jSONObject.optString("app_download_url");
            this.f17094u = jSONObject.optString("app_intro_url");
            this.f17095v = jSONObject.optString(AdKeys.APP_VER);
            this.f17096w = jSONObject.optDouble("app_size");
            this.f17097x = jSONObject.optString("phone");
            this.f17098y = jSONObject.optInt("likes");
            this.f17099z = jSONObject.optDouble("original_price");
            this.A = jSONObject.optDouble("current_price");
            this.B = jSONObject.optString("sponsored");
            this.C = jSONObject.optString("address");
            this.D = jSONObject.optString("app_id");
            this.E = jSONObject.optString("package_name");
            this.F = jSONObject.optString(bm.f6905j);
            this.G = jSONObject.optJSONArray("display_labels");
            this.H = jSONObject.optJSONObject("voice_ad_url");
            this.I = jSONObject.optString("close_icon");
            this.J = jSONObject.optJSONObject("monitor");
            this.K = jSONObject.optString("deeplink");
            this.L = jSONObject.optString("landing");
            this.M = jSONObject.optInt("action_type");
            this.N = jSONObject.optString("ad_source_mark");
            this.P = jSONObject.optInt("cache_time", 0) * 60000;
            this.O = jSONObject.optString("win_notice_url");
            this.Q = jSONObject.optInt("interact", 1);
            this.R = jSONObject.optInt("click_type");
            this.S = jSONObject.optJSONObject("shake_info");
            this.T = jSONObject.optString("app_permission");
            this.U = jSONObject.optString("developer_name");
            this.V = jSONObject.optString("app_privacy_url");
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "parseAdData error:" + th2.getMessage());
            throw new AdError(ErrorCode.ERROR_SERVER);
        }
    }
}
