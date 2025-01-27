package com.kwad.sdk.h;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
final class d implements b {
    public List<e> aNt;
    public long intervalTime;

    public final long KK() {
        long j10 = this.intervalTime;
        if (j10 > 0) {
            return j10;
        }
        return 5000L;
    }

    public final void parseJson(@Nullable JSONObject jSONObject) {
        this.intervalTime = jSONObject.optInt("intervalTime", 5000);
        this.aNt = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("configList");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                e eVar = new e();
                eVar.parseJson(optJSONArray.optJSONObject(i10));
                this.aNt.add(eVar);
            }
        }
    }

    @Override // com.kwad.sdk.h.b
    public final JSONObject toJson() {
        return null;
    }
}
