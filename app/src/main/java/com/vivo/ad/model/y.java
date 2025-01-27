package com.vivo.ad.model;

import com.vivo.ic.jsonparser.JsonParserUtil;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class y implements Serializable {

    /* renamed from: a */
    private String f26946a;

    /* renamed from: b */
    private String f26947b;

    /* renamed from: c */
    private String f26948c;

    /* renamed from: d */
    private String f26949d;

    /* renamed from: e */
    private String f26950e;

    /* renamed from: f */
    private long f26951f;

    /* renamed from: g */
    private String f26952g;

    /* renamed from: h */
    private String f26953h;

    /* renamed from: j */
    private String f26955j;

    /* renamed from: i */
    private boolean f26954i = false;
    private int k = 1;

    public y(JSONObject jSONObject) {
        this.f26955j = "";
        this.f26946a = jSONObject.toString();
        this.f26947b = JsonParserUtil.getString("styleId", jSONObject);
        this.f26948c = JsonParserUtil.getString("templateId", jSONObject);
        this.f26949d = JsonParserUtil.getString("pUrl", jSONObject);
        this.f26950e = JsonParserUtil.getString("lUrl", jSONObject);
        this.f26951f = JsonParserUtil.getLong("waitStyleTime", jSONObject, 0L);
        this.f26952g = JsonParserUtil.getString("lViewType", jSONObject);
        this.f26953h = JsonParserUtil.getString("pViewType", jSONObject);
        this.f26955j = JsonParserUtil.getString("dynamicConfigValue", jSONObject);
    }

    public String a() {
        return this.f26955j;
    }

    public String b() {
        return this.f26950e;
    }

    public String c() {
        return this.f26949d;
    }

    public String d() {
        return this.f26946a;
    }

    public int e() {
        return this.k;
    }

    public String f() {
        return this.f26947b;
    }

    public String g() {
        return this.f26948c;
    }

    public String h() {
        int i2 = this.k;
        return i2 == 1 ? this.f26949d : i2 == 2 ? this.f26950e : "";
    }

    public String i() {
        int i2 = this.k;
        return i2 == 1 ? this.f26953h : i2 == 2 ? this.f26952g : "";
    }

    public long j() {
        return this.f26951f;
    }

    public boolean k() {
        return this.f26954i;
    }

    public void a(int i2) {
        this.k = i2;
    }

    public void a(boolean z) {
        this.f26954i = z;
    }
}
