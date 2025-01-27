package com.vivo.ad.model;

import android.text.TextUtils;
import com.vivo.ic.jsonparser.JsonParserUtil;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class d implements Serializable {

    /* renamed from: a */
    private String f26869a;

    /* renamed from: b */
    private int f26870b;

    /* renamed from: c */
    private int f26871c;

    /* renamed from: d */
    private k f26872d;

    /* renamed from: e */
    private k f26873e;

    /* renamed from: f */
    private k f26874f;

    /* renamed from: g */
    private z f26875g;

    public d(JSONObject jSONObject) {
        this.f26869a = JsonParserUtil.getString("url", jSONObject);
        this.f26870b = JsonParserUtil.getInt("type", jSONObject, -1);
        JSONObject object = JsonParserUtil.getObject("buttonArea", jSONObject);
        if (object != null) {
            this.f26872d = new k(object);
        }
        JSONObject object2 = JsonParserUtil.getObject("clickArea", jSONObject);
        if (object2 != null) {
            this.f26873e = new k(object2);
        }
        JSONObject object3 = JsonParserUtil.getObject("slideArea", jSONObject);
        if (object3 != null) {
            this.f26874f = new k(object3);
        }
        JSONObject object4 = JsonParserUtil.getObject("triggerThreshold", jSONObject);
        if (object4 != null) {
            this.f26875g = new z(object4);
        }
        this.f26871c = JsonParserUtil.getInt("layout", jSONObject);
    }

    public boolean a() {
        int i2 = this.f26870b;
        return i2 == 0 || i2 == 4;
    }

    public k b() {
        return this.f26872d;
    }

    public k c() {
        return this.f26873e;
    }

    public int d() {
        return this.f26871c;
    }

    public k e() {
        return this.f26874f;
    }

    public z f() {
        return this.f26875g;
    }

    public int g() {
        return this.f26870b;
    }

    public String h() {
        return this.f26869a;
    }

    public boolean i() {
        return this.f26870b == 5;
    }

    public boolean j() {
        int i2 = this.f26870b;
        return i2 == 3 || i2 == 4;
    }

    public boolean k() {
        int i2 = this.f26870b;
        return i2 == 1 || i2 == 2;
    }

    public boolean l() {
        k kVar;
        k kVar2;
        if (TextUtils.isEmpty(this.f26869a)) {
            return false;
        }
        int i2 = this.f26870b;
        if (i2 == 0 || i2 == 4) {
            k kVar3 = this.f26872d;
            return kVar3 != null && kVar3.g() && (kVar = this.f26873e) != null && kVar.g();
        }
        if (i2 != 1 && i2 != 2) {
            return (i2 == 3 || i2 == 5) && (kVar2 = this.f26872d) != null && kVar2.g();
        }
        k kVar4 = this.f26872d;
        return (kVar4 == null || !kVar4.g() || this.f26874f == null) ? false : true;
    }
}
