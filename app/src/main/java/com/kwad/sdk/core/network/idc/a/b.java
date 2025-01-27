package com.kwad.sdk.core.network.idc.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.x;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b implements com.kwad.sdk.core.b {
    private final Map<String, List<String>> aAP = new ConcurrentHashMap();

    @NonNull
    private Map<String, List<String>> FF() {
        return this.aAP;
    }

    public static b ei(String str) {
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(str));
        } catch (JSONException e10) {
            c.printStackTraceOnly(e10);
        }
        return bVar;
    }

    @NonNull
    public final Set<String> FG() {
        return this.aAP.keySet();
    }

    public final void a(b bVar) {
        this.aAP.clear();
        if (bVar != null) {
            this.aAP.putAll(bVar.FF());
        }
    }

    @NonNull
    public final List<String> eh(String str) {
        List<String> list = this.aAP.get(str);
        return list == null ? Collections.emptyList() : list;
    }

    public final boolean isEmpty() {
        return this.aAP.isEmpty();
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                hashMap.put(next, x.h(jSONObject.optJSONArray(next)));
            }
        }
        this.aAP.clear();
        this.aAP.putAll(hashMap);
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        Map<String, List<String>> map = this.aAP;
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            x.putValue(jSONObject, str, x.N(map.get(str)));
        }
        return jSONObject;
    }
}
