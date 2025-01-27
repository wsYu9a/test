package com.kwad.sdk.core.f;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.umeng.analytics.pro.am;

/* loaded from: classes2.dex */
public final class c {
    private volatile boolean alV = true;
    private long alW = 0;
    private double alX = 9.999999717180685E-10d;
    private double[] alY = {0.0d, 0.0d, 0.0d};
    private double[] alZ = {0.0d, 0.0d, 0.0d};

    @Nullable
    private com.kwad.sdk.core.f.a ama;

    @Nullable
    private a amb;
    private AdMatrixInfo.RotateInfo rotateInfo;

    class a implements SensorEventListener {
        private a() {
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            if (c.this.alW != 0) {
                double d2 = sensorEvent.timestamp - c.this.alW;
                double d3 = c.this.alX;
                Double.isNaN(d2);
                double d4 = d2 * d3;
                double[] dArr = c.this.alZ;
                double d5 = dArr[0];
                double d6 = f2;
                Double.isNaN(d6);
                dArr[0] = d5 + Math.toDegrees(d6 * d4);
                double[] dArr2 = c.this.alZ;
                double d7 = dArr2[1];
                double d8 = f3;
                Double.isNaN(d8);
                dArr2[1] = d7 + Math.toDegrees(d8 * d4);
                double[] dArr3 = c.this.alZ;
                double d9 = dArr3[2];
                double d10 = f4;
                Double.isNaN(d10);
                dArr3[2] = d9 + Math.toDegrees(d10 * d4);
                c.this.xE();
                c.this.xF();
            }
            c.this.alW = sensorEvent.timestamp;
        }
    }

    public c(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    private boolean a(int i2, double d2, int i3) {
        if (d2 <= 0.0d || Math.abs(this.alZ[i2]) < d2) {
            return false;
        }
        double[] dArr = this.alZ;
        return (dArr[i2] <= 0.0d || i3 != 1) && (dArr[i2] >= 0.0d || i3 != 2);
    }

    public void xE() {
        if (this.alV) {
            if (Math.abs(this.alZ[0]) > Math.abs(this.alY[0])) {
                this.alY[0] = this.alZ[0];
            }
            if (Math.abs(this.alZ[1]) > Math.abs(this.alY[1])) {
                this.alY[1] = this.alZ[1];
            }
            if (Math.abs(this.alZ[2]) > Math.abs(this.alY[2])) {
                this.alY[2] = this.alZ[2];
            }
        }
    }

    public void xF() {
        AdMatrixInfo.RotateInfo rotateInfo;
        if (!this.alV || (rotateInfo = this.rotateInfo) == null || this.ama == null) {
            return;
        }
        if (!a(0, r0.rotateDegree, rotateInfo.x.direction)) {
            if (!a(1, r1.rotateDegree, this.rotateInfo.y.direction)) {
                if (!a(2, r1.rotateDegree, this.rotateInfo.z.direction)) {
                    return;
                }
            }
        }
        this.alV = false;
        this.ama.ae(xG());
        this.alZ = new double[]{0.0d, 0.0d, 0.0d};
        this.alY = new double[]{0.0d, 0.0d, 0.0d};
    }

    private String xG() {
        return "{\"x\": " + this.alY[0] + ",\"y\":" + this.alY[1] + ",\"z\":" + this.alY[2] + "}";
    }

    public final void a(@Nullable com.kwad.sdk.core.f.a aVar) {
        this.ama = aVar;
    }

    public final void a(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    public final void aX(Context context) {
        if (context == null) {
            return;
        }
        SensorManager sensorManager = (SensorManager) context.getSystemService(am.ac);
        Sensor defaultSensor = sensorManager.getDefaultSensor(4);
        if (defaultSensor != null) {
            if (this.amb == null) {
                this.amb = new a(this, (byte) 0);
            }
            sensorManager.registerListener(this.amb, defaultSensor, 2);
        } else {
            com.kwad.sdk.core.f.a aVar = this.ama;
            if (aVar != null) {
                aVar.la();
            }
        }
    }

    public final synchronized void aY(Context context) {
        if (context != null) {
            if (this.amb != null) {
                ((SensorManager) context.getSystemService(am.ac)).unregisterListener(this.amb);
                this.amb = null;
            }
        }
    }

    public final synchronized void xD() {
        this.alV = true;
    }
}
