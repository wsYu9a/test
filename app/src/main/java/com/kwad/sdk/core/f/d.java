package com.kwad.sdk.core.f;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.umeng.analytics.pro.am;
import java.util.Random;

/* loaded from: classes2.dex */
public final class d {
    private volatile boolean alV = true;
    private float amd;

    @Nullable
    private b ame;

    @Nullable
    private a amf;

    class a implements SensorEventListener {
        private Random ahn;
        private boolean amh;
        private final float[] amg = {0.0f, 0.0f, 9.8f};
        private final float[] ami = {0.0f, 0.0f, 0.0f};

        public a() {
            this.amh = false;
            if (((DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class)) != null) {
                this.amh = false;
            }
        }

        private void a(float[] fArr) {
            b(fArr);
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            double sqrt = Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4));
            if (!d.this.alV || sqrt < d.this.amd || d.this.ame == null) {
                return;
            }
            d.a(d.this, false);
            d.this.ame.a(sqrt);
        }

        private void b(float[] fArr) {
            float f2 = fArr[0] * 0.6f;
            float[] fArr2 = this.ami;
            fArr[0] = f2 + (fArr2[0] * 0.39999998f);
            fArr[1] = (fArr[1] * 0.6f) + (fArr2[1] * 0.39999998f);
            fArr[2] = (fArr[2] * 0.6f) + (fArr2[2] * 0.39999998f);
            System.arraycopy(fArr, 0, fArr2, 0, 3);
        }

        private void xH() {
            if (this.ahn == null) {
                this.ahn = new Random();
            }
            if (this.ahn.nextInt(100) == 1) {
                a(this.amg);
            }
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            a(sensorEvent.values);
            if (this.amh) {
                xH();
            }
        }
    }

    public d(float f2) {
        if (f2 <= 0.0f) {
            this.amd = 5.0f;
        } else {
            this.amd = f2;
        }
    }

    static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.alV = false;
        return false;
    }

    public final void a(@Nullable b bVar) {
        this.ame = bVar;
    }

    public final void aX(Context context) {
        if (context == null) {
            com.kwad.sdk.core.d.b.d("ShakeDetector", "startDetect context is null");
            return;
        }
        SensorManager sensorManager = (SensorManager) context.getSystemService(am.ac);
        Sensor defaultSensor = sensorManager.getDefaultSensor(10);
        if (defaultSensor != null) {
            if (this.amf == null) {
                this.amf = new a();
            }
            sensorManager.registerListener(this.amf, defaultSensor, 2);
        } else {
            b bVar = this.ame;
            if (bVar != null) {
                bVar.bd();
            }
            com.kwad.sdk.core.d.b.d("ShakeDetector", "startDetect default linear acceleration is null");
        }
    }

    public final synchronized void aY(Context context) {
        if (context != null) {
            if (this.amf != null) {
                ((SensorManager) context.getSystemService(am.ac)).unregisterListener(this.amf);
                this.amf = null;
            }
        }
    }

    public final void e(float f2) {
        this.amd = f2;
    }

    public final synchronized void xD() {
        this.alV = true;
    }
}
