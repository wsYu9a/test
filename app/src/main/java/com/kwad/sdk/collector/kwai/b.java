package com.kwad.sdk.collector.kwai;

import com.kwad.sdk.c;
import com.kwad.sdk.collector.model.e;
import com.kwad.sdk.core.network.d;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b extends d {
    public b(Collection<e> collection) {
        putBody("collectData", a(collection));
        putBody("collectType", 1);
        putBody("sdkVersion", "3.3.40");
        putBody("sdkVersionCode", 3034000);
    }

    private static JSONArray a(Collection<e> collection) {
        JSONArray jSONArray = new JSONArray();
        Iterator<e> it = collection.iterator();
        while (it.hasNext()) {
            JSONObject tK = it.next().tK();
            if (tK != null) {
                jSONArray.put(tK);
            }
        }
        return jSONArray;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return c.sl();
    }
}
