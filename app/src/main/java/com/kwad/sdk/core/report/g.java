package com.kwad.sdk.core.report;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public final class g extends com.kwad.sdk.core.network.d {
    public g(List<q> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<q> it = list.iterator();
        while (it.hasNext()) {
            com.kwad.sdk.utils.t.putValue(jSONArray, it.next().buildReportData());
        }
        putBody("actionList", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.c.sg();
    }
}
