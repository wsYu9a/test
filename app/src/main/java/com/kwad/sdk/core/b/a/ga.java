package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.message.JavaBackTraceElement;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ga implements com.kwad.sdk.core.d<JavaBackTraceElement> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(JavaBackTraceElement javaBackTraceElement, JSONObject jSONObject) {
        a2(javaBackTraceElement, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(JavaBackTraceElement javaBackTraceElement, JSONObject jSONObject) {
        return b2(javaBackTraceElement, jSONObject);
    }

    /* renamed from: a */
    private static void a2(JavaBackTraceElement javaBackTraceElement, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        javaBackTraceElement.mDeclaringClass = jSONObject.optString("mDeclaringClass");
        if (JSONObject.NULL.toString().equals(javaBackTraceElement.mDeclaringClass)) {
            javaBackTraceElement.mDeclaringClass = "";
        }
        javaBackTraceElement.mIsTitle = jSONObject.optBoolean("mIsTitle");
        javaBackTraceElement.mIsCausedBy = jSONObject.optBoolean("mIsCausedBy");
        javaBackTraceElement.mIsNative = jSONObject.optBoolean("mIsNative");
    }

    /* renamed from: b */
    private static JSONObject b2(JavaBackTraceElement javaBackTraceElement, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = javaBackTraceElement.mDeclaringClass;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "mDeclaringClass", javaBackTraceElement.mDeclaringClass);
        }
        boolean z10 = javaBackTraceElement.mIsTitle;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "mIsTitle", z10);
        }
        boolean z11 = javaBackTraceElement.mIsCausedBy;
        if (z11) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "mIsCausedBy", z11);
        }
        boolean z12 = javaBackTraceElement.mIsNative;
        if (z12) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "mIsNative", z12);
        }
        return jSONObject;
    }
}
