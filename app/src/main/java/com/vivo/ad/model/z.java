package com.vivo.ad.model;

import com.vivo.ic.jsonparser.JsonParserUtil;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class z implements Serializable {

    /* renamed from: a */
    private long f26956a;

    /* renamed from: b */
    private long f26957b;

    /* renamed from: c */
    private float f26958c;

    /* renamed from: d */
    private float f26959d;

    /* renamed from: e */
    private float f26960e;

    /* renamed from: f */
    private float f26961f = 0.0f;

    public z(JSONObject jSONObject) {
        this.f26956a = 500L;
        this.f26957b = 100L;
        this.f26958c = 15.0f;
        this.f26959d = 10.0f;
        this.f26960e = 10.0f;
        this.f26956a = JsonParserUtil.getLong("angleSamplingInterval", jSONObject, 500L);
        this.f26957b = JsonParserUtil.getLong("speedSamplingInterval", jSONObject, 100L);
        this.f26958c = JsonParserUtil.getFloat("angleLeft", jSONObject, 15.0f);
        this.f26959d = JsonParserUtil.getFloat("speed", jSONObject, 10.0f);
        this.f26960e = JsonParserUtil.getFloat("distance", jSONObject, 10.0f);
    }

    public float a() {
        return this.f26958c;
    }

    public long b() {
        return this.f26956a;
    }

    public float c() {
        float f2 = this.f26961f;
        return ((double) f2) < 0.01d ? this.f26960e : this.f26960e * f2;
    }

    public float d() {
        float f2 = this.f26961f;
        return ((double) f2) < 0.01d ? this.f26959d : this.f26959d * f2;
    }

    public float e() {
        return this.f26959d;
    }

    public long f() {
        return this.f26957b;
    }

    public void a(float f2) {
        this.f26961f = f2;
    }
}
