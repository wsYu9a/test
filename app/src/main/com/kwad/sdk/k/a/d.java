package com.kwad.sdk.k.a;

import android.content.Context;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.x;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class d extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public int aRo = 0;
    public int aRp = 0;
    public int aRq = 0;
    public int aRr = 0;
    public int aRs = 0;
    public int aRt = 0;
    public int aRu = 0;

    public d(Context context) {
        if (context != null) {
            try {
                bP(Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0);
            } catch (Throwable unused) {
            }
        }
    }

    private void a(d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aRo = jSONObject.optInt("isRoot");
        dVar.aRp = jSONObject.optInt("isXPosed");
        dVar.aRq = jSONObject.optInt("isFrameworkHooked");
        dVar.aRr = jSONObject.optInt("isVirtual");
        dVar.aRs = jSONObject.optInt("isAdbEnabled");
        dVar.aRt = jSONObject.optInt("isEmulator");
        dVar.aRu = jSONObject.optInt("isGroupControl");
        super.afterParseJson(jSONObject);
    }

    private static JSONObject b(d dVar, JSONObject jSONObject) {
        x.putValue(jSONObject, "isRoot", dVar.aRo);
        x.putValue(jSONObject, "isXPosed", dVar.aRp);
        x.putValue(jSONObject, "isFrameworkHooked", dVar.aRq);
        x.putValue(jSONObject, "isVirtual", dVar.aRr);
        x.putValue(jSONObject, "isAdbEnabled", dVar.aRs);
        x.putValue(jSONObject, "isEmulator", dVar.aRt);
        x.putValue(jSONObject, "isGroupControl", dVar.aRu);
        return jSONObject;
    }

    private void bP(boolean z10) {
        this.aRs = bS(z10);
    }

    private static int bS(boolean z10) {
        return z10 ? 1 : 2;
    }

    public final void bM(boolean z10) {
        this.aRo = bS(z10);
    }

    public final void bN(boolean z10) {
        this.aRp = bS(z10);
    }

    public final void bO(boolean z10) {
        this.aRq = bS(z10);
    }

    public final void bQ(boolean z10) {
        this.aRt = bS(z10);
    }

    public final void bR(boolean z10) {
        this.aRu = bS(z10);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject b10 = b(this, new JSONObject());
        afterToJson(b10);
        return b10;
    }
}
