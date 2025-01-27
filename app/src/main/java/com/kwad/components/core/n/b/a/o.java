package com.kwad.components.core.n.b.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.kwad.components.offline.api.core.api.ISensorManagerProxy;
import com.kwad.sdk.utils.bh;

/* loaded from: classes3.dex */
public final class o implements ISensorManagerProxy {
    @Override // com.kwad.components.offline.api.core.api.ISensorManagerProxy
    public final SensorManager checkAndObtainSensorManager(Context context) {
        return bh.OC().checkAndObtainSensorManager(context);
    }

    @Override // com.kwad.components.offline.api.core.api.ISensorManagerProxy
    public final Sensor getDefaultSensor(Context context, int i10) {
        return bh.OC().getDefaultSensor(context, i10);
    }

    @Override // com.kwad.components.offline.api.core.api.ISensorManagerProxy
    public final boolean registerListener(Context context, SensorEventListener sensorEventListener, Sensor sensor, int i10) {
        return bh.OC().registerListener(context, sensorEventListener, sensor, i10);
    }

    @Override // com.kwad.components.offline.api.core.api.ISensorManagerProxy
    public final void unregisterListener(SensorEventListener sensorEventListener) {
        bh.OC().unregisterListener(sensorEventListener);
    }
}
