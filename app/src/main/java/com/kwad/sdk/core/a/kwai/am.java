package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class am implements com.kwad.sdk.core.d<AdMatrixInfo.AggregationCardInfo> {
    /* renamed from: a */
    private static void a2(AdMatrixInfo.AggregationCardInfo aggregationCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aggregationCardInfo.changeTime = jSONObject.optInt("changeTime");
        aggregationCardInfo.maxTimesPerDay = jSONObject.optInt("maxTimesPerDay");
        aggregationCardInfo.intervalTime = jSONObject.optLong("intervalTime", new Long("1200").longValue());
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.AggregationCardInfo aggregationCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aggregationCardInfo.changeTime;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "changeTime", i2);
        }
        int i3 = aggregationCardInfo.maxTimesPerDay;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "maxTimesPerDay", i3);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "intervalTime", aggregationCardInfo.intervalTime);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.AggregationCardInfo aggregationCardInfo, JSONObject jSONObject) {
        a2(aggregationCardInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.AggregationCardInfo aggregationCardInfo, JSONObject jSONObject) {
        return b2(aggregationCardInfo, jSONObject);
    }
}
