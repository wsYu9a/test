package com.alipay.sdk.protocol;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class h extends i {
    private int l;
    private boolean m;

    protected h(b.b.a.c.e eVar, b.b.a.c.f fVar) {
        super(eVar, fVar);
        this.m = false;
    }

    private boolean i() {
        return this.m;
    }

    @Override // com.alipay.sdk.protocol.c
    public final void b(JSONObject jSONObject) {
        super.b(jSONObject);
        if (!jSONObject.has(b.b.a.b.c.f4210c)) {
            if (f.a(jSONObject.optString("status")) == f.POP_TYPE) {
                this.l = -10;
                return;
            } else {
                this.l = 8;
                return;
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(b.b.a.b.c.f4210c);
        String optString = optJSONObject.optString("type");
        this.k = Boolean.parseBoolean(optJSONObject.optString("oneTime"));
        if (TextUtils.equals("page", optString)) {
            this.m = true;
            this.l = 9;
            return;
        }
        if (TextUtils.equals("dialog", optString)) {
            this.l = 7;
            this.m = false;
            return;
        }
        if (!TextUtils.equals("toast", optString)) {
            if (TextUtils.equals("confirm", optString)) {
                return;
            }
            this.m = TextUtils.equals(optString, "fullscreen");
            this.l = 4;
            return;
        }
        b d2 = b.d(optJSONObject, b.b.a.b.c.f4211d);
        this.l = 6;
        if (d2 != null) {
            for (a aVar : a.a(d2)) {
                if (aVar == a.Confirm || aVar == a.Alert) {
                    this.l = 10;
                }
            }
        }
    }

    @Override // com.alipay.sdk.protocol.i
    public final boolean f() {
        int i2 = this.l;
        return i2 == 4 || i2 == 9;
    }

    @Override // com.alipay.sdk.protocol.i
    public final int g() {
        return this.l;
    }

    @Override // com.alipay.sdk.protocol.i
    public final String h() {
        return null;
    }
}
