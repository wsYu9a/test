package com.kwad.sdk.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.kwad.sdk.utils.bf;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class bg implements SensorEventListener {
    private final b aUA;
    private final b aUB;
    private boolean aUC;
    private boolean aUD;
    private final bf.b aUE;
    private final b aUz;

    /* renamed from: com.kwad.sdk.utils.bg$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.c.d {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            bg.this.OA();
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            if (q.MY()) {
                bg.this.register();
            }
        }
    }

    /* renamed from: com.kwad.sdk.utils.bg$2 */
    public class AnonymousClass2 implements bf.b {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.utils.bf.b
        public final void onFailed() {
            bg.a(bg.this, true);
        }
    }

    public static class a {
        private static final bg aUG = new bg((byte) 0);
    }

    public static class b {
        private SensorEvent aUH;
        private long timestamp;

        private b() {
        }

        public final void P(List<com.kwad.sdk.k.a.e> list) {
            if (this.aUH == null) {
                return;
            }
            com.kwad.sdk.k.a.e eVar = new com.kwad.sdk.k.a.e();
            eVar.sensorType = this.aUH.sensor.getType();
            eVar.timestamp = this.timestamp / 1000;
            for (float f10 : this.aUH.values) {
                eVar.aRv.add(Float.valueOf(f10));
            }
            list.add(eVar);
        }

        public final void b(SensorEvent sensorEvent) {
            this.aUH = sensorEvent;
            this.timestamp = System.currentTimeMillis();
        }

        public /* synthetic */ b(byte b10) {
            this();
        }
    }

    public /* synthetic */ bg(byte b10) {
        this();
    }

    public synchronized void OA() {
        if (this.aUD) {
            bf.Ox().a(this);
            this.aUD = false;
        }
    }

    public static bg Oy() {
        return a.aUG;
    }

    public synchronized void register() {
        if (!this.aUC && !this.aUD) {
            this.aUD = true;
            try {
                bf.Ox().a(3, 3, this, this.aUE);
                bf.Ox().a(2, 3, this, this.aUE);
                bf.Ox().a(4, 3, this, this.aUE);
            } catch (Throwable unused) {
                this.aUC = true;
            }
        }
    }

    public final synchronized List<com.kwad.sdk.k.a.e> Oz() {
        try {
            if (!q.MY()) {
                return null;
            }
            com.kwad.sdk.core.c.b.Fi();
            if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                register();
            }
            ArrayList arrayList = new ArrayList();
            this.aUz.P(arrayList);
            this.aUA.P(arrayList);
            this.aUB.P(arrayList);
            return arrayList;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            this.aUz.b(sensorEvent);
        } else if (type == 4) {
            this.aUA.b(sensorEvent);
        } else {
            if (type != 9) {
                return;
            }
            this.aUB.b(sensorEvent);
        }
    }

    private bg() {
        this.aUz = new b((byte) 0);
        this.aUA = new b((byte) 0);
        this.aUB = new b((byte) 0);
        this.aUC = false;
        this.aUE = new bf.b() { // from class: com.kwad.sdk.utils.bg.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.utils.bf.b
            public final void onFailed() {
                bg.a(bg.this, true);
            }
        };
        com.kwad.sdk.core.c.b.Fi();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.utils.bg.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                bg.this.OA();
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                if (q.MY()) {
                    bg.this.register();
                }
            }
        });
    }

    public static /* synthetic */ boolean a(bg bgVar, boolean z10) {
        bgVar.aUC = true;
        return true;
    }
}
