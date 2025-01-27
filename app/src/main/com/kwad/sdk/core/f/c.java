package com.kwad.sdk.core.f;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.bf;
import java.util.Arrays;
import p3.f;

/* loaded from: classes3.dex */
public final class c {

    @Nullable
    private com.kwad.sdk.core.f.a aEt;

    @Nullable
    private a aEu;
    private AdMatrixInfo.RotateInfo rotateInfo;
    private volatile boolean aEo = true;
    private long aEp = 0;
    private double aEq = 9.999999717180685E-10d;
    private double[] aEr = {l5.c.f27899e, l5.c.f27899e, l5.c.f27899e};
    private double[] aEs = {l5.c.f27899e, l5.c.f27899e, l5.c.f27899e};
    private final bf.b aEv = new bf.b() { // from class: com.kwad.sdk.core.f.c.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bf.b
        public final void onFailed() {
            if (c.this.aEt != null) {
                c.this.aEt.bx();
            }
        }
    };

    /* renamed from: com.kwad.sdk.core.f.c$1 */
    public class AnonymousClass1 implements bf.b {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bf.b
        public final void onFailed() {
            if (c.this.aEt != null) {
                c.this.aEt.bx();
            }
        }
    }

    public class a implements SensorEventListener {
        private a() {
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i10) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[2];
            if (c.this.aEp != 0) {
                double d10 = (sensorEvent.timestamp - c.this.aEp) * c.this.aEq;
                double[] dArr = c.this.aEs;
                dArr[0] = dArr[0] + Math.toDegrees(f10 * d10);
                double[] dArr2 = c.this.aEs;
                dArr2[1] = dArr2[1] + Math.toDegrees(f11 * d10);
                double[] dArr3 = c.this.aEs;
                dArr3[2] = dArr3[2] + Math.toDegrees(f12 * d10);
                c.this.GY();
                c.this.GZ();
            }
            c.this.aEp = sensorEvent.timestamp;
        }

        public /* synthetic */ a(c cVar, byte b10) {
            this();
        }
    }

    public c(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    private void GX() {
        Arrays.fill(this.aEr, l5.c.f27899e);
        Arrays.fill(this.aEs, l5.c.f27899e);
        this.aEp = 0L;
    }

    public void GY() {
        if (this.aEo) {
            if (Math.abs(this.aEs[0]) > Math.abs(this.aEr[0])) {
                this.aEr[0] = this.aEs[0];
            }
            if (Math.abs(this.aEs[1]) > Math.abs(this.aEr[1])) {
                this.aEr[1] = this.aEs[1];
            }
            if (Math.abs(this.aEs[2]) > Math.abs(this.aEr[2])) {
                this.aEr[2] = this.aEs[2];
            }
        }
    }

    public void GZ() {
        AdMatrixInfo.RotateInfo rotateInfo;
        if (!this.aEo || (rotateInfo = this.rotateInfo) == null || this.aEt == null) {
            return;
        }
        if (!a(0, r0.rotateDegree, rotateInfo.f11970x.direction)) {
            if (!a(1, r0.rotateDegree, this.rotateInfo.f11971y.direction)) {
                if (!a(2, r0.rotateDegree, this.rotateInfo.f11972z.direction)) {
                    return;
                }
            }
        }
        this.aEo = false;
        this.aEt.o(Ha());
    }

    private String Ha() {
        return "{\"x\": " + this.aEr[0] + ",\"y\":" + this.aEr[1] + ",\"z\":" + this.aEr[2] + f.f29748d;
    }

    public final synchronized void bA(Context context) {
        if (context != null) {
            if (this.aEu != null) {
                bf.Ox().a(this.aEu);
                this.aEu = null;
            }
        }
    }

    public final void bz(Context context) {
        if (context == null) {
            return;
        }
        GX();
        this.aEo = true;
        if (this.aEu == null) {
            this.aEu = new a(this, (byte) 0);
        }
        bf.Ox().a(2, 2, this.aEu, this.aEv);
    }

    public final void b(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    public final void a(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    public final void a(@Nullable com.kwad.sdk.core.f.a aVar) {
        this.aEt = aVar;
    }

    private boolean a(int i10, double d10, int i11) {
        if (d10 <= l5.c.f27899e || Math.abs(this.aEs[i10]) < d10) {
            return false;
        }
        double d11 = this.aEs[i10];
        return (d11 <= l5.c.f27899e || i11 != 1) && (d11 >= l5.c.f27899e || i11 != 2);
    }
}
