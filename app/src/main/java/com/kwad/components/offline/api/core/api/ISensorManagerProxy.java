package com.kwad.components.offline.api.core.api;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* loaded from: classes3.dex */
public interface ISensorManagerProxy {
    SensorManager checkAndObtainSensorManager(Context context);

    Sensor getDefaultSensor(Context context, int i10);

    boolean registerListener(Context context, SensorEventListener sensorEventListener, Sensor sensor, int i10);

    void unregisterListener(SensorEventListener sensorEventListener);
}
