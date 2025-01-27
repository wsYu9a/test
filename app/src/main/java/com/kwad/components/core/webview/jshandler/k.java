package com.kwad.components.core.webview.jshandler;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.r.l;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class k implements SensorEventListener, com.kwad.sdk.core.webview.b.a {
    private Map<Integer, com.kwad.sdk.core.webview.b.c> Sl = new ConcurrentHashMap();

    /* renamed from: com.kwad.components.core.webview.jshandler.k$1 */
    final class AnonymousClass1 implements l.b {
        final /* synthetic */ com.kwad.sdk.core.webview.b.c Sm;

        AnonymousClass1(com.kwad.sdk.core.webview.b.c cVar) {
            cVar = cVar;
        }

        @Override // com.kwad.components.core.r.l.b
        public final void onFailed() {
            cVar.onError(-1, "sensor is not support");
        }
    }

    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int So;
        public ArrayList<Float> Sp;
        public int accuracy;
        public long timestamp;
        public int type;

        @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            this.So = jSONObject.optInt(com.umeng.analytics.pro.am.aU);
            this.timestamp = jSONObject.optLong("timestamp");
            this.accuracy = jSONObject.optInt("accuracy");
            JSONArray optJSONArray = jSONObject.optJSONArray("values");
            ArrayList<Float> arrayList = new ArrayList<>();
            if (optJSONArray == null) {
                this.Sp = arrayList;
                return;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                try {
                    Object obj = optJSONArray.get(i2);
                    if (obj != null) {
                        arrayList.add((Float) obj);
                    }
                } catch (Throwable unused) {
                }
            }
            this.Sp = arrayList;
        }

        @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            int i2 = this.type;
            if (i2 != 0) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "type", i2);
            }
            int i3 = this.So;
            if (i3 != 0) {
                com.kwad.sdk.utils.t.putValue(jSONObject, com.umeng.analytics.pro.am.aU, i3);
            }
            long j2 = this.timestamp;
            if (j2 != 0) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "timestamp", j2);
            }
            int i4 = this.accuracy;
            if (i4 != 0) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "accuracy", i4);
            }
            if (!this.Sp.isEmpty()) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "values", this.Sp);
            }
            return jSONObject;
        }
    }

    private void a(int i2, int i3, com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.r.l.pS().a(i2, i3, this, new l.b() { // from class: com.kwad.components.core.webview.jshandler.k.1
            final /* synthetic */ com.kwad.sdk.core.webview.b.c Sm;

            AnonymousClass1(com.kwad.sdk.core.webview.b.c cVar2) {
                cVar = cVar2;
            }

            @Override // com.kwad.components.core.r.l.b
            public final void onFailed() {
                cVar.onError(-1, "sensor is not support");
            }
        });
    }

    private void a(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 4) {
            type = 2;
        } else if (type == 10) {
            type = 1;
        }
        com.kwad.sdk.core.webview.b.c cVar = this.Sl.get(Integer.valueOf(type));
        if (cVar == null) {
            return;
        }
        ArrayList<Float> arrayList = new ArrayList<>();
        int i2 = 0;
        while (true) {
            float[] fArr = sensorEvent.values;
            if (i2 >= fArr.length) {
                a aVar = new a();
                aVar.Sp = arrayList;
                aVar.timestamp = sensorEvent.timestamp;
                aVar.accuracy = sensorEvent.accuracy;
                cVar.a(aVar);
                return;
            }
            arrayList.add(Float.valueOf(fArr[i2]));
            i2++;
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerSensorListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        if (TextUtils.isEmpty(str)) {
            cVar.onError(-1, "data is empty");
            return;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.Sl.put(Integer.valueOf(aVar.type), cVar);
        a(aVar.type, aVar.So, cVar);
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        com.kwad.components.core.r.l.pS().a(this);
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        a(sensorEvent);
    }
}
