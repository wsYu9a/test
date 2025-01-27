package com.vivo.ad.model;

import com.vivo.ic.jsonparser.JsonParserUtil;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class k implements Serializable {

    /* renamed from: a */
    private float f26906a;

    /* renamed from: b */
    private float f26907b;

    /* renamed from: c */
    private float f26908c;

    /* renamed from: d */
    private float f26909d;

    /* renamed from: e */
    private float f26910e = 0.0f;

    public k(JSONObject jSONObject) {
        this.f26906a = JsonParserUtil.getFloat("posX", jSONObject, -1.0f);
        this.f26907b = JsonParserUtil.getFloat("posY", jSONObject, -1.0f);
        this.f26908c = JsonParserUtil.getFloat("width", jSONObject, -1.0f);
        this.f26909d = JsonParserUtil.getFloat("height", jSONObject, -1.0f);
    }

    public float a() {
        float f2 = this.f26910e;
        return ((double) f2) < 0.01d ? this.f26909d : this.f26909d * f2;
    }

    public float b() {
        float f2 = this.f26910e;
        return ((double) f2) <= 0.01d ? this.f26906a : this.f26906a * f2;
    }

    public float c() {
        float f2 = this.f26910e;
        return ((double) f2) <= 0.01d ? this.f26907b : this.f26907b * f2;
    }

    public float d() {
        float f2 = this.f26910e;
        return ((double) f2) <= 0.01d ? this.f26908c : this.f26908c * f2;
    }

    public float e() {
        return this.f26909d;
    }

    public float f() {
        return this.f26908c;
    }

    public boolean g() {
        return this.f26906a >= 0.0f && this.f26907b >= 0.0f && this.f26909d >= 0.0f && this.f26908c >= 0.0f;
    }

    public void a(float f2) {
        this.f26910e = f2;
    }
}
