package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class g implements com.kwad.sdk.core.b {
    public int aaM;
    public int aaN;
    public String aaO;
    private String alL;
    private String alM;

    public static g xv() {
        return new g();
    }

    public final void cH(String str) {
        this.alM = str;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "user_id", this.alL);
        t.putValue(jSONObject, "thirdUserId", this.alM);
        int i2 = this.aaM;
        if (i2 != 0) {
            t.putValue(jSONObject, "thirdAge", i2);
        }
        int i3 = this.aaN;
        if (i3 != 0) {
            t.putValue(jSONObject, "thirdGender", i3);
        }
        t.putValue(jSONObject, "thirdInterest", this.aaO);
        return jSONObject;
    }
}
