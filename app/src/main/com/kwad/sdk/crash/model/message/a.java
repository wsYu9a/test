package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.crash.d;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a {
    private JSONObject aKP = new JSONObject();

    private void put(String str, Object obj) {
        try {
            this.aKP.put(str, obj);
        } catch (Throwable th2) {
            c.printStackTraceOnly(th2);
        }
    }

    public final void a(String str, JSONObject jSONObject) {
        put(str, jSONObject);
    }

    public final void fH(String str) {
        put(d.aKe, str);
    }

    public final void putInt(String str, int i10) {
        put(str, Integer.valueOf(i10));
    }

    public final void putString(String str, String str2) {
        if (TextUtils.isEmpty(str2) || str2.length() > 100) {
            c.d("AnrAndNativeAdExceptionCollector", "string value to long ,max is 100");
        } else {
            put(str, str2);
        }
    }

    public final String toString() {
        return this.aKP.toString();
    }
}
