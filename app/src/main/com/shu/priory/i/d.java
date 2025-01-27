package com.shu.priory.i;

import com.shu.priory.config.SDKConstants;
import com.shu.priory.utils.h;
import com.umeng.analytics.pro.f;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: a */
    public String f17131a;

    /* renamed from: b */
    public int f17132b;

    /* renamed from: c */
    public int f17133c;

    /* renamed from: d */
    public int f17134d;

    /* renamed from: e */
    public int f17135e;

    /* renamed from: f */
    public int f17136f;

    /* renamed from: g */
    public long f17137g;

    /* renamed from: h */
    public JSONObject f17138h;

    /* renamed from: i */
    public JSONArray f17139i;

    /* renamed from: j */
    public JSONArray f17140j;

    /* renamed from: k */
    public JSONArray f17141k;

    /* renamed from: l */
    public JSONArray f17142l;

    /* renamed from: m */
    public JSONArray f17143m;

    /* renamed from: n */
    public JSONArray f17144n;

    /* renamed from: o */
    public JSONArray f17145o;

    /* renamed from: p */
    public JSONArray f17146p;

    /* renamed from: q */
    public JSONArray f17147q;

    /* renamed from: r */
    public JSONArray f17148r;

    /* renamed from: s */
    public JSONArray f17149s;

    /* renamed from: t */
    public JSONArray f17150t;

    /* renamed from: u */
    public JSONArray f17151u;

    /* renamed from: v */
    public JSONArray f17152v;

    /* renamed from: w */
    public JSONArray f17153w;

    /* renamed from: x */
    public JSONArray f17154x;

    public d(com.shu.priory.g.a aVar) {
        try {
            this.f17131a = aVar.f17083j.optString("url");
            this.f17132b = aVar.f17083j.optInt("duration");
            this.f17133c = aVar.f17083j.optInt("width");
            this.f17134d = aVar.f17083j.optInt("height");
            this.f17135e = aVar.f17083j.optInt("format");
            this.f17136f = aVar.f17083j.optInt("bitrate");
            this.f17137g = aVar.f17083j.optLong(f.f23909q);
            this.f17138h = aVar.f17079f;
            JSONObject jSONObject = aVar.J;
            this.f17139i = jSONObject.optJSONArray("start_urls");
            this.f17140j = jSONObject.optJSONArray("first_quartile_urls");
            this.f17141k = jSONObject.optJSONArray("mid_point_urls");
            this.f17142l = jSONObject.optJSONArray("third_quartile_urls");
            this.f17143m = jSONObject.optJSONArray("complete_urls");
            this.f17144n = jSONObject.optJSONArray("pause_urls");
            this.f17145o = jSONObject.optJSONArray("resume_urls");
            this.f17146p = jSONObject.optJSONArray("skip_urls");
            this.f17147q = jSONObject.optJSONArray("mute_urls");
            this.f17148r = jSONObject.optJSONArray("unmute_urls");
            this.f17149s = jSONObject.optJSONArray("replay_urls");
            this.f17150t = jSONObject.optJSONArray("close_linear_urls");
            this.f17151u = jSONObject.optJSONArray("fullscreen_urls");
            this.f17152v = jSONObject.optJSONArray("exit_fullscreen_urls");
            this.f17153w = jSONObject.optJSONArray("up_scroll_urls");
            this.f17154x = jSONObject.optJSONArray("down_scroll_urls");
        } catch (Exception unused) {
            h.d(SDKConstants.TAG, "VideoAdSelected Invalid response data!");
        }
    }
}
