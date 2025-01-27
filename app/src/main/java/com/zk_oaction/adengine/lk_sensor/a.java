package com.zk_oaction.adengine.lk_sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.os.SystemClock;
import android.text.TextUtils;

/* loaded from: classes5.dex */
public class a extends d {

    /* renamed from: f */
    private static float f34954f = 0.8f;

    /* renamed from: g */
    public float[] f34955g;

    /* renamed from: h */
    public long f34956h;

    /* renamed from: i */
    private boolean f34957i;

    /* renamed from: j */
    private long f34958j;
    private float k;
    private float l;
    private float m;
    private float[] n;
    private float[] o;

    public a(com.zk_oaction.adengine.lk_sdk.b bVar, String str, int i2, Sensor sensor, String[] strArr) {
        super(bVar, str, i2, sensor, strArr);
        this.f34956h = 0L;
        this.l = 17.0f;
        this.m = 1000.0f;
        this.n = new float[3];
        this.o = new float[3];
        try {
            if (this.f34975c == null) {
                return;
            }
            this.f34955g = new float[3];
        } catch (Throwable unused) {
        }
    }

    @Override // com.zk_oaction.adengine.lk_sensor.d
    public void a() {
        super.a();
        this.f34956h = 0L;
        this.k = 0.0f;
    }

    @Override // com.zk_oaction.adengine.lk_sensor.d
    public void b(SensorEvent sensorEvent) {
        try {
            if (this.k != 0.0f) {
                if (this.f34956h == 0) {
                    this.f34956h = System.currentTimeMillis();
                }
                for (int i2 = 0; i2 < 3; i2++) {
                    String[] strArr = this.f34976d;
                    if (strArr[i2] != null) {
                        float[] fArr = this.n;
                        float f2 = f34954f;
                        float f3 = fArr[i2];
                        float[] fArr2 = sensorEvent.values;
                        fArr[i2] = ((1.0f - f2) * fArr2[i2]) + (f3 * f2);
                        this.o[i2] = fArr2[i2] - fArr[i2];
                        float[] fArr3 = this.f34955g;
                        fArr3[i2] = (fArr3[i2] * 0.85f) + (fArr2[i2] * 0.15f);
                        this.f34973a.h(strArr[i2], "" + this.f34955g[i2]);
                    }
                }
                String j2 = this.f34973a.j("shake_range");
                if (!TextUtils.isEmpty(j2)) {
                    this.l = Float.parseFloat(j2);
                }
                String j3 = this.f34973a.j("shake_wait");
                if (!TextUtils.isEmpty(j3)) {
                    this.m = Float.parseFloat(j3);
                }
                if (Math.abs(this.o[0]) <= this.l && Math.abs(this.o[1]) <= this.l && Math.abs(this.o[2]) <= this.l) {
                    if (Math.abs(SystemClock.uptimeMillis() - this.f34958j) > this.m) {
                        this.f34957i = false;
                    }
                }
                if (!this.f34957i && System.currentTimeMillis() - this.f34956h > 500) {
                    String j4 = this.f34973a.j("shake");
                    if (j4 == null || j4.isEmpty()) {
                        j4 = "0";
                    }
                    int parseInt = Integer.parseInt(j4);
                    this.f34973a.h("shake", "" + (parseInt + 1));
                    this.f34957i = true;
                    this.f34958j = SystemClock.uptimeMillis();
                }
            }
            this.k = sensorEvent.timestamp;
        } catch (Throwable unused) {
        }
    }
}
