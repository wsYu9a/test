package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.message.BackTraceElement;
import com.kwad.sdk.crash.message.Backtrace;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class bs implements com.kwad.sdk.core.d<Backtrace> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(Backtrace backtrace, JSONObject jSONObject) {
        a2(backtrace, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(Backtrace backtrace, JSONObject jSONObject) {
        return b2(backtrace, jSONObject);
    }

    /* renamed from: a */
    private static void a2(Backtrace backtrace, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        backtrace.mBacktraces = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("mBacktraces");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                BackTraceElement backTraceElement = new BackTraceElement();
                backTraceElement.parseJson(optJSONArray.optJSONObject(i10));
                backtrace.mBacktraces.add(backTraceElement);
            }
        }
        backtrace.mFrame = jSONObject.optInt("mFrame");
    }

    /* renamed from: b */
    private static JSONObject b2(Backtrace backtrace, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "mBacktraces", backtrace.mBacktraces);
        int i10 = backtrace.mFrame;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "mFrame", i10);
        }
        return jSONObject;
    }
}
