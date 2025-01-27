package com.kwad.sdk.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* loaded from: classes3.dex */
public class bh {
    private static bh aUI;
    private SensorManager aUJ;

    public static bh OC() {
        if (aUI == null) {
            synchronized (bh.class) {
                try {
                    if (aUI == null) {
                        aUI = new bh();
                    }
                } finally {
                }
            }
        }
        return aUI;
    }

    private static boolean OD() {
        return !az.Oo();
    }

    private boolean OE() {
        boolean OD = OD();
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "checkEnableSensor enable:" + OD);
        if (OD) {
            return true;
        }
        this.aUJ = null;
        return false;
    }

    private SensorManager dl(Context context) {
        if (this.aUJ == null) {
            this.aUJ = (SensorManager) context.getSystemService(com.umeng.analytics.pro.bt.f23586ac);
        }
        return this.aUJ;
    }

    public final SensorManager checkAndObtainSensorManager(Context context) {
        if (OE()) {
            return dl(context);
        }
        return null;
    }

    public final Sensor getDefaultSensor(Context context, int i10) {
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "getDefaultSensor type:" + i10);
        if (OE()) {
            return dl(context).getDefaultSensor(i10);
        }
        return null;
    }

    public final boolean registerListener(Context context, SensorEventListener sensorEventListener, Sensor sensor, int i10) {
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "registerListener sensor:" + sensor + ", listener: " + sensorEventListener);
        if (!OE()) {
            return false;
        }
        try {
            return dl(context).registerListener(sensorEventListener, sensor, i10);
        } catch (Exception unused) {
            return false;
        }
    }

    public final void unregisterListener(SensorEventListener sensorEventListener) {
        SensorManager sensorManager;
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "unregisterListener listener:" + sensorEventListener);
        if (OE() && (sensorManager = this.aUJ) != null) {
            try {
                sensorManager.unregisterListener(sensorEventListener);
            } catch (Throwable unused) {
            }
        }
    }
}
