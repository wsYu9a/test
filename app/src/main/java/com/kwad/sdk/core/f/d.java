package com.kwad.sdk.core.f;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.utils.bf;
import java.util.Random;

/* loaded from: classes3.dex */
public final class d {
    private static float aEy = 9.81f;
    private static double aEz = 0.01d;

    @Nullable
    private b aEA;

    @Nullable
    private a aEB;
    private volatile boolean aEo = true;
    private final bf.b aEv = new bf.b() { // from class: com.kwad.sdk.core.f.d.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bf.b
        public final void onFailed() {
            if (d.this.aEA != null) {
                d.this.aEA.bw();
            }
        }
    };
    private float aEx;

    /* renamed from: com.kwad.sdk.core.f.d$1 */
    public class AnonymousClass1 implements bf.b {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bf.b
        public final void onFailed() {
            if (d.this.aEA != null) {
                d.this.aEA.bw();
            }
        }
    }

    public class a implements SensorEventListener {
        private Random aAE;
        private boolean aEE;
        private final float[] aED = {0.0f, 0.0f, 9.8f};
        private final float[] aEF = {0.0f, 0.0f, 0.0f};

        public a() {
            this.aEE = false;
            if (((DevelopMangerComponents) com.kwad.sdk.components.d.f(DevelopMangerComponents.class)) != null) {
                this.aEE = false;
            }
        }

        private void He() {
            if (this.aAE == null) {
                this.aAE = new Random();
            }
            if (this.aAE.nextInt(100) == 1) {
                a(this.aED);
            }
        }

        private void a(float[] fArr) {
            c(fArr);
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[2];
            double abs = Math.abs(Math.sqrt((f10 * f10) + (f11 * f11) + (f12 * f12)));
            if (b(fArr)) {
                abs = Math.abs(abs - d.aEy);
            }
            if (!d.this.aEo || abs < d.this.aEx || d.this.aEA == null) {
                return;
            }
            d.a(d.this, false);
            d.this.aEA.a(abs);
        }

        private static boolean b(float[] fArr) {
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[2];
            return Math.abs(Math.abs(Math.sqrt((double) (((f10 * f10) + (f11 * f11)) + (f12 * f12)))) - ((double) d.aEy)) <= d.aEz;
        }

        private void c(float[] fArr) {
            float[] fArr2 = this.aEF;
            float f10 = fArr2[0];
            float f11 = (f10 == 0.0f && fArr2[1] == 0.0f && fArr2[2] == 0.0f) ? 1.0f : 0.6f;
            float f12 = 1.0f - f11;
            fArr[0] = (fArr[0] * f11) + (f10 * f12);
            fArr[1] = (fArr[1] * f11) + (fArr2[1] * f12);
            fArr[2] = (f11 * fArr[2]) + (f12 * fArr2[2]);
            System.arraycopy(fArr, 0, fArr2, 0, 3);
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i10) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            a(sensorEvent.values);
            if (this.aEE) {
                He();
            }
        }
    }

    public d(float f10) {
        if (f10 <= 0.0f) {
            this.aEx = 5.0f;
        } else {
            this.aEx = f10;
        }
    }

    public final synchronized void Hb() {
        this.aEo = true;
    }

    public final synchronized void bA(Context context) {
        if (context != null) {
            if (this.aEB != null) {
                bf.Ox().a(this.aEB);
                this.aEB = null;
            }
        }
    }

    public final void bz(Context context) {
        if (context == null) {
            com.kwad.sdk.core.d.c.d("ShakeDetector", "startDetect context is null");
            return;
        }
        this.aEo = true;
        if (this.aEB == null) {
            this.aEB = new a();
        }
        bf.Ox().a(1, 2, this.aEB, this.aEv);
    }

    public final void g(float f10) {
        this.aEx = f10;
    }

    public static /* synthetic */ boolean a(d dVar, boolean z10) {
        dVar.aEo = false;
        return false;
    }

    public final void a(@Nullable b bVar) {
        this.aEA = bVar;
    }
}
