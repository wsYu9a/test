package com.zk_oaction.adengine.lk_sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: a */
    public com.zk_oaction.adengine.lk_sdk.b f34973a;

    /* renamed from: b */
    public int f34974b;

    /* renamed from: c */
    public Sensor f34975c;

    /* renamed from: d */
    public String[] f34976d;

    /* renamed from: e */
    public boolean f34977e;

    public d(com.zk_oaction.adengine.lk_sdk.b bVar, String str, int i2, Sensor sensor, String[] strArr) {
        this.f34973a = bVar;
        this.f34974b = i2;
        this.f34975c = sensor;
        if (strArr != null) {
            this.f34976d = (String[]) strArr.clone();
        }
    }

    public void a() {
    }

    public void b(SensorEvent sensorEvent) {
        try {
            String[] strArr = this.f34976d;
            if (strArr == null || strArr.length <= 0) {
                return;
            }
            for (int i2 = 0; i2 < sensorEvent.values.length; i2++) {
                String[] strArr2 = this.f34976d;
                if (strArr2[i2] != null) {
                    this.f34973a.h(strArr2[i2], "" + sensorEvent.values[i2]);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
