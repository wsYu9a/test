package com.kwad.sdk.h.kwai;

import android.hardware.SensorEvent;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class e extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int sensorType = -1;
    public List<Float> axI = new ArrayList();
    public long timestamp = 0;

    public static e a(SensorEvent sensorEvent, long j2) {
        if (sensorEvent == null) {
            return null;
        }
        e eVar = new e();
        eVar.sensorType = sensorEvent.sensor.getType();
        eVar.timestamp = j2 / 1000;
        for (float f2 : sensorEvent.values) {
            eVar.axI.add(Float.valueOf(f2));
        }
        return eVar;
    }

    private void a(e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.sensorType = jSONObject.optInt("sensorType");
        eVar.timestamp = jSONObject.optLong("timestamp");
        super.afterToJson(jSONObject);
    }

    private static JSONObject b(e eVar, JSONObject jSONObject) {
        t.putValue(jSONObject, "sensorType", eVar.sensorType);
        t.putValue(jSONObject, "timestamp", eVar.timestamp);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public final void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        t.putValue(jSONObject, "values", this.axI);
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject b2 = b(this, new JSONObject());
        afterToJson(b2);
        return b2;
    }
}
