package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.message.BackTraceElement;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class br implements com.kwad.sdk.core.d<BackTraceElement> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(BackTraceElement backTraceElement, JSONObject jSONObject) {
        a2(backTraceElement, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(BackTraceElement backTraceElement, JSONObject jSONObject) {
        return b2(backTraceElement, jSONObject);
    }

    /* renamed from: a */
    private static void a2(BackTraceElement backTraceElement, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        backTraceElement.mLine = jSONObject.optString("mLine");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(backTraceElement.mLine)) {
            backTraceElement.mLine = "";
        }
        backTraceElement.mMethodName = jSONObject.optString("mMethodName");
        if (obj.toString().equals(backTraceElement.mMethodName)) {
            backTraceElement.mMethodName = "";
        }
        backTraceElement.mFileName = jSONObject.optString("mFileName");
        if (obj.toString().equals(backTraceElement.mFileName)) {
            backTraceElement.mFileName = "";
        }
        backTraceElement.mLineNumber = jSONObject.optLong("mLineNumber");
        backTraceElement.mIndex = jSONObject.optInt("mIndex");
        backTraceElement.mNeedClustering = jSONObject.optBoolean("mNeedClustering");
    }

    /* renamed from: b */
    private static JSONObject b2(BackTraceElement backTraceElement, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = backTraceElement.mLine;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "mLine", backTraceElement.mLine);
        }
        String str2 = backTraceElement.mMethodName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "mMethodName", backTraceElement.mMethodName);
        }
        String str3 = backTraceElement.mFileName;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "mFileName", backTraceElement.mFileName);
        }
        long j10 = backTraceElement.mLineNumber;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "mLineNumber", j10);
        }
        int i10 = backTraceElement.mIndex;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "mIndex", i10);
        }
        boolean z10 = backTraceElement.mNeedClustering;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "mNeedClustering", z10);
        }
        return jSONObject;
    }
}
