package com.zk_oaction.adengine.lk_sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;

/* loaded from: classes5.dex */
public class c extends d {

    /* renamed from: f */
    private static int f34968f = 250;

    /* renamed from: g */
    public float[] f34969g;

    /* renamed from: h */
    public long f34970h;

    /* renamed from: i */
    public boolean f34971i;

    /* renamed from: j */
    private float f34972j;
    private float k;
    private float l;
    private float m;
    private boolean n;
    private float o;
    private float p;

    public c(com.zk_oaction.adengine.lk_sdk.b bVar, String str, int i2, Sensor sensor, String[] strArr, SensorManager sensorManager) {
        super(bVar, str, i2, sensor, strArr);
        this.n = false;
        this.o = 0.0f;
        this.p = 0.0f;
        this.f34970h = 0L;
        try {
            if (this.f34975c == null) {
                this.f34974b = 1;
                Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                this.f34975c = defaultSensor;
                if (defaultSensor == null) {
                    return;
                }
            }
            this.f34969g = new float[3];
        } catch (Throwable unused) {
        }
    }

    private void c(SensorEvent sensorEvent) {
        try {
            if (this.f34975c == null) {
                return;
            }
            int i2 = this.f34974b;
            if (i2 == 1) {
                float[] fArr = sensorEvent.values;
                float f2 = fArr[0];
                float f3 = fArr[1];
                float f4 = fArr[2];
                if (!this.n) {
                    this.o = f2;
                    this.p = f3;
                    this.n = true;
                    return;
                } else {
                    if (this.f34976d.length > 3) {
                        float abs = Math.abs(this.o - f2);
                        if (f4 < 0.0f) {
                            abs = Math.abs((Math.abs(this.o) - Math.abs(f2)) + 19.6f);
                        }
                        float max = Math.max(abs, Math.abs(this.p - f3)) / 9.8f;
                        this.f34973a.h(this.f34976d[3], "" + (max * 90.0f));
                        return;
                    }
                    return;
                }
            }
            if (i2 == 4) {
                if (this.m != 0.0f) {
                    if (this.f34970h == 0) {
                        this.f34970h = System.currentTimeMillis();
                    }
                    float f5 = (sensorEvent.timestamp - this.m) * 1.0E-9f;
                    float degrees = (float) Math.toDegrees(sensorEvent.values[0] * f5);
                    float degrees2 = (float) Math.toDegrees(sensorEvent.values[1] * f5);
                    float degrees3 = (float) Math.toDegrees(f5 * sensorEvent.values[2]);
                    if (!this.f34971i && ((Math.abs(degrees) > 3.0f || Math.abs(degrees2) > 3.0f || Math.abs(degrees3) > 3.0f) && System.currentTimeMillis() - this.f34970h <= f34968f)) {
                        return;
                    }
                    float f6 = degrees + this.f34972j;
                    float f7 = degrees2 + this.k;
                    float f8 = degrees3 + this.l;
                    if (this.f34976d.length > 3) {
                        float max2 = Math.max(Math.max(Math.abs(f6), Math.abs(f7)), Math.abs(f8));
                        this.f34973a.h(this.f34976d[3], "" + max2);
                    }
                    this.f34972j = f6;
                    this.k = f7;
                    this.l = f8;
                    this.f34971i = true;
                }
                this.m = sensorEvent.timestamp;
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.zk_oaction.adengine.lk_sensor.d
    public void a() {
        super.a();
        this.f34971i = false;
        this.n = false;
        this.f34970h = 0L;
        this.f34972j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0.0f;
    }

    @Override // com.zk_oaction.adengine.lk_sensor.d
    public void b(SensorEvent sensorEvent) {
        com.zk_oaction.adengine.lk_sdk.b bVar;
        String str;
        StringBuilder sb;
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                String[] strArr = this.f34976d;
                if (strArr[i2] != null) {
                    if (this.f34974b == 1) {
                        float[] fArr = this.f34969g;
                        fArr[i2] = (fArr[i2] * 0.85f) + (sensorEvent.values[i2] * 0.15f);
                        bVar = this.f34973a;
                        str = strArr[i2];
                        sb = new StringBuilder();
                        sb.append("");
                        sb.append(this.f34969g[i2]);
                    } else {
                        bVar = this.f34973a;
                        str = strArr[i2];
                        sb = new StringBuilder();
                        sb.append("");
                        sb.append(sensorEvent.values[i2] * 10.0f);
                    }
                    bVar.h(str, sb.toString());
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (this.f34976d.length > 3) {
            c(sensorEvent);
        }
    }
}
