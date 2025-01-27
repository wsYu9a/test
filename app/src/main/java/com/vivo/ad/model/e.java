package com.vivo.ad.model;

import com.tencent.bugly.beta.tinker.TinkerReport;
import com.vivo.ic.jsonparser.JsonParserUtil;
import com.vivo.mobilead.util.x0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class e implements Serializable {
    private int A;
    private List<i> B;
    private int C;
    private int D;

    /* renamed from: a */
    private int f26876a;

    /* renamed from: b */
    private int f26877b;

    /* renamed from: c */
    private int f26878c;

    /* renamed from: d */
    private int f26879d;

    /* renamed from: e */
    private int f26880e;

    /* renamed from: f */
    private int f26881f;

    /* renamed from: g */
    public int f26882g;

    /* renamed from: h */
    public int f26883h;

    /* renamed from: i */
    private int f26884i;

    /* renamed from: j */
    private int f26885j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private String t;
    private long u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public e(JSONObject jSONObject, int i2, boolean z) {
        this.A = 200;
        this.f26876a = JsonParserUtil.getInt("playEndInteraction", jSONObject, 2);
        this.f26877b = JsonParserUtil.getInt("interstitialStyle", jSONObject, 0);
        this.f26878c = JsonParserUtil.getInt("bannerStyle", jSONObject, 0);
        this.f26879d = JsonParserUtil.getInt("videoBtnStyle", jSONObject, 0);
        JsonParserUtil.getInt("videoBannerDldtype", jSONObject, 0);
        JsonParserUtil.getInt("endingCardDldtype", jSONObject, 0);
        this.f26880e = JsonParserUtil.getInt("showActiveReminder", jSONObject, 0);
        this.f26881f = JsonParserUtil.getInt("activeReminderInterval", jSONObject, 300000);
        JsonParserUtil.getInt("warmStartTotalInterval", jSONObject, 0);
        JsonParserUtil.getInt("warmStartCurrentInterval", jSONObject, 0);
        JsonParserUtil.getInt("warmStartReqInterval", jSONObject, 0);
        this.n = JsonParserUtil.getInt("monetVideoPlayType", jSONObject, 1);
        this.f26884i = JsonParserUtil.getInt("playPercentCloseBtn", jSONObject, 80);
        this.f26885j = JsonParserUtil.getInt("videoLoadCloseBtn", jSONObject, 5);
        this.k = JsonParserUtil.getInt("requestInterval", jSONObject, 0);
        this.l = JsonParserUtil.getInt("showInterval", jSONObject, TinkerReport.KEY_APPLIED_VERSION_CHECK);
        this.m = JsonParserUtil.getInt("reqCircleTime", jSONObject, 60);
        this.o = JsonParserUtil.getInt("spRenderType", jSONObject, 0);
        this.v = JsonParserUtil.getInt("showAdDetailElements", jSONObject, 0);
        this.x = JsonParserUtil.getInt("supportSlide", jSONObject, 0);
        int i3 = i2 == 2 ? 383 : ((i2 == 4 && z) || i2 == 9) ? 447 : 511;
        this.D = JsonParserUtil.getInt("showContentIncentiveAdType", jSONObject, 0);
        this.p = JsonParserUtil.getInt("clickableCtl", jSONObject, i3);
        if (this.D == 1) {
            this.q = JsonParserUtil.getInt("incentiveVideoGetRewardSec", jSONObject, 15);
            this.s = JsonParserUtil.getInt("showCloseBtnCountDownSec", jSONObject, 10);
        } else {
            this.q = JsonParserUtil.getInt("incentiveVideoGetRewardSec", jSONObject, 30);
            this.s = JsonParserUtil.getInt("showCloseBtnCountDownSec", jSONObject, 12);
        }
        this.r = JsonParserUtil.getInt("activityControl", jSONObject, 3);
        this.t = JsonParserUtil.getString("boxTitle", jSONObject);
        this.u = JsonParserUtil.getLong("adCacheEffectiveTime", jSONObject, 1800L);
        this.w = JsonParserUtil.getInt("h5CloseBtnDelayShowTime", jSONObject, 0);
        this.y = JsonParserUtil.getInt("portraitScreenLayout", jSONObject, 0);
        this.z = JsonParserUtil.getInt("landscapeLayout", jSONObject, 0);
        this.A = JsonParserUtil.getInt("clickH5MaxInterval", jSONObject, 200);
        this.f26882g = JsonParserUtil.getInt("topSlideDownDp", jSONObject, 0);
        this.f26883h = JsonParserUtil.getInt("topSlideDownToClick", jSONObject, 0);
        this.C = JsonParserUtil.getInt("adTagInteractiveType", jSONObject, 0);
        JSONArray jSONArray = JsonParserUtil.getJSONArray("adTagInteractiveInfoList", jSONObject);
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.B = new ArrayList(jSONArray.length());
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            try {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                if (jSONObject2 != null) {
                    this.B.add(new i(jSONObject2));
                }
            } catch (JSONException e2) {
                x0.b("TAG", "", e2);
            }
        }
    }

    public int A() {
        return this.f26885j;
    }

    public boolean B() {
        return this.C == 1;
    }

    public int a() {
        return this.f26881f;
    }

    public int b() {
        return this.r;
    }

    public long c() {
        return this.u;
    }

    public List<i> d() {
        return this.B;
    }

    public int e() {
        return this.f26878c;
    }

    public String f() {
        return this.t;
    }

    public int g() {
        return this.A;
    }

    public int h() {
        return this.p;
    }

    public int i() {
        return this.w;
    }

    public int j() {
        return this.m;
    }

    public int k() {
        return this.q;
    }

    public int l() {
        return this.f26877b;
    }

    public int m() {
        return this.z;
    }

    public int n() {
        return this.n;
    }

    public int o() {
        return this.f26876a;
    }

    public int p() {
        return this.f26884i;
    }

    public int q() {
        return this.y;
    }

    public int r() {
        return this.f26880e;
    }

    public int s() {
        return this.v;
    }

    public int t() {
        return this.s;
    }

    public int u() {
        return this.D;
    }

    public int v() {
        return this.o;
    }

    public int w() {
        return this.x;
    }

    public int x() {
        return this.f26882g;
    }

    public int y() {
        return this.f26883h;
    }

    public int z() {
        return this.f26879d;
    }

    public void a(int i2) {
        if (i2 == 9) {
            com.vivo.mobilead.manager.b.l().d(this.k);
        } else if (i2 == 5) {
            com.vivo.mobilead.manager.b.l().b(this.l);
        }
    }
}
