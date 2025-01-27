package com.kwad.sdk.h;

import org.json.JSONObject;

/* loaded from: classes3.dex */
final class i implements b {
    public String aNO;
    public String aNP;
    public String aNQ;
    public long aNR = System.currentTimeMillis();
    public double arO;

    public static i La() {
        return new i();
    }

    public final i gm(String str) {
        this.aNO = str;
        return this;
    }

    public final i gn(String str) {
        this.aNP = str;
        return this;
    }

    public final i go(String str) {
        this.aNQ = str;
        return this;
    }

    public final i n(double d10) {
        this.arO = d10;
        return this;
    }

    @Override // com.kwad.sdk.h.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, com.sigmob.sdk.base.k.B, Double.valueOf(this.arO));
        c.a(jSONObject, "ratio_count", Double.valueOf(j.o(this.arO)));
        c.putValue(jSONObject, "log_build_time_ms", this.aNR);
        c.putValue(jSONObject, "log_level", this.aNO);
        c.putValue(jSONObject, "log_tag", this.aNP);
        c.putValue(jSONObject, "log_content", this.aNQ);
        return jSONObject;
    }
}
