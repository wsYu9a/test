package com.sigmob.sdk.base.common;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.czhj.sdk.logger.SigmobLog;
import com.umeng.analytics.pro.bt;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class y {

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f18044a;

        static {
            int[] iArr = new int[e.values().length];
            f18044a = iArr;
            try {
                iArr[e.SLOPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18044a[e.SWING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18044a[e.WRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static abstract class b {

        /* renamed from: b */
        public static int[] f18045b = {25, 60, 50, 45, 35, 25, 20, 15, 10, 5, 1};

        /* renamed from: c */
        public static float[] f18046c = {4.0f, 10.0f, 8.0f, 6.0f, 5.0f, 4.0f, 3.0f, 2.0f, 1.8f, 1.5f, 1.0f};

        /* renamed from: a */
        public int f18047a = 2;

        public abstract void a();

        public abstract void a(int i10);

        public abstract void b();

        public abstract void b(int i10);

        public abstract void c();
    }

    public interface c {
        void a();

        void a(float f10);

        void a(Map<String, Number> map);
    }

    public static class d extends b implements SensorEventListener {
        public static float C = 40.0f;
        public long A;
        public Integer B;

        /* renamed from: d */
        public final SensorManager f18048d;

        /* renamed from: e */
        public float[] f18049e;

        /* renamed from: f */
        public float[] f18050f;

        /* renamed from: i */
        public Float f18053i;

        /* renamed from: j */
        public c f18054j;

        /* renamed from: k */
        public float f18055k;

        /* renamed from: l */
        public float f18056l;

        /* renamed from: m */
        public float f18057m;

        /* renamed from: o */
        public float f18059o;

        /* renamed from: p */
        public float f18060p;

        /* renamed from: q */
        public float f18061q;

        /* renamed from: r */
        public e f18062r;

        /* renamed from: s */
        public long f18063s;

        /* renamed from: t */
        public float f18064t;

        /* renamed from: u */
        public float f18065u;

        /* renamed from: v */
        public float f18066v;

        /* renamed from: w */
        public boolean f18067w;

        /* renamed from: x */
        public float f18068x;

        /* renamed from: g */
        public float[] f18051g = new float[9];

        /* renamed from: h */
        public float[] f18052h = new float[3];

        /* renamed from: n */
        public int f18058n = 0;

        /* renamed from: y */
        public int f18069y = 100;

        /* renamed from: z */
        public int f18070z = 2000;

        public d(Context context, c cVar, e eVar) {
            this.f18048d = (SensorManager) context.getSystemService(bt.f23586ac);
            this.f18054j = cVar;
            this.f18062r = eVar;
        }

        @Override // com.sigmob.sdk.base.common.y.b
        public void a() {
            SensorManager sensorManager = this.f18048d;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
            this.f18065u = 0.0f;
            this.f18066v = 0.0f;
            this.f18064t = 0.0f;
            this.f18055k = 0.0f;
            this.f18056l = 0.0f;
            this.f18057m = 0.0f;
            this.f18068x = 0.0f;
            this.A = 0L;
            this.f18053i = null;
            this.f18054j = null;
        }

        @Override // com.sigmob.sdk.base.common.y.b
        public void b() {
            SensorManager sensorManager = this.f18048d;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
        }

        public void c(int i10) {
            if (i10 > 0) {
                this.f18069y = i10;
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i10) {
        }

        /* JADX WARN: Code restructure failed: missing block: B:152:0x03bb, code lost:
        
            if (r2 != null) goto L471;
         */
        /* JADX WARN: Removed duplicated region for block: B:103:0x0295  */
        /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:131:0x0326  */
        /* JADX WARN: Removed duplicated region for block: B:134:0x033a  */
        /* JADX WARN: Removed duplicated region for block: B:137:0x034e  */
        /* JADX WARN: Removed duplicated region for block: B:140:0x0363 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:141:0x0364  */
        /* JADX WARN: Removed duplicated region for block: B:95:0x027c  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x0288  */
        @Override // android.hardware.SensorEventListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onSensorChanged(android.hardware.SensorEvent r18) {
            /*
                Method dump skipped, instructions count: 971
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.y.d.onSensorChanged(android.hardware.SensorEvent):void");
        }

        @Override // com.sigmob.sdk.base.common.y.b
        public void a(int i10) {
            this.f18047a = i10;
        }

        @Override // com.sigmob.sdk.base.common.y.b
        public void b(int i10) {
            this.B = Integer.valueOf(i10);
        }

        @Override // com.sigmob.sdk.base.common.y.b
        public void c() {
            SensorManager sensorManager = this.f18048d;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
                SensorManager sensorManager2 = this.f18048d;
                sensorManager2.registerListener(this, sensorManager2.getDefaultSensor(1), 3);
                SensorManager sensorManager3 = this.f18048d;
                sensorManager3.registerListener(this, sensorManager3.getDefaultSensor(2), 3);
                SensorManager sensorManager4 = this.f18048d;
                sensorManager4.registerListener(this, sensorManager4.getDefaultSensor(4), 3);
            }
            this.f18053i = null;
        }
    }

    public enum e {
        SWING,
        WRING,
        SLOPE
    }

    public static class f extends b implements SensorEventListener {

        /* renamed from: m */
        public static float f18075m = 3.0f;

        /* renamed from: n */
        public static final long f18076n = 2000;

        /* renamed from: d */
        public final SensorManager f18077d;

        /* renamed from: e */
        public long f18078e;

        /* renamed from: f */
        public boolean f18079f;

        /* renamed from: g */
        public float f18080g;

        /* renamed from: h */
        public float f18081h;

        /* renamed from: i */
        public float f18082i;

        /* renamed from: j */
        public c f18083j;

        /* renamed from: k */
        public int f18084k = 100;

        /* renamed from: l */
        public Integer f18085l;

        public f(Context context, c cVar) {
            this.f18083j = cVar;
            this.f18077d = (SensorManager) context.getSystemService(bt.f23586ac);
        }

        @Override // com.sigmob.sdk.base.common.y.b
        public void a() {
            SensorManager sensorManager = this.f18077d;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
            this.f18078e = 0L;
            this.f18080g = 0.0f;
            this.f18081h = 0.0f;
            this.f18082i = 0.0f;
            this.f18083j = null;
        }

        @Override // com.sigmob.sdk.base.common.y.b
        public void b() {
            SensorManager sensorManager = this.f18077d;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
        }

        public void c(int i10) {
            if (i10 > 0) {
                this.f18084k = i10;
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i10) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 4) {
                a(sensorEvent.values);
            }
        }

        public final void a(float[] fArr) {
            float f10;
            float sqrt = (float) Math.sqrt(Math.pow(fArr[0], 2.0d) + Math.pow(fArr[1], 2.0d) + Math.pow(fArr[2], 2.0d));
            long currentTimeMillis = System.currentTimeMillis();
            boolean z10 = currentTimeMillis - this.f18078e >= f18076n;
            if (Math.abs(this.f18080g) < Math.abs(fArr[0])) {
                this.f18080g = fArr[0];
            }
            if (Math.abs(this.f18081h) < Math.abs(fArr[1])) {
                this.f18081h = fArr[1];
            }
            if (Math.abs(this.f18082i) < Math.abs(fArr[2])) {
                this.f18082i = fArr[2];
            }
            Integer num = this.f18085l;
            if (num != null) {
                f10 = num.intValue();
            } else {
                int i10 = this.f18047a;
                f10 = (i10 <= 0 || i10 > 10) ? 4.0f : b.f18046c[i10];
            }
            f18075m = f10;
            SigmobLog.d("shake magnitude" + sqrt);
            float f11 = f18075m;
            if (sqrt > f11 && !this.f18079f && z10) {
                this.f18079f = true;
                c cVar = this.f18083j;
                if (cVar != null) {
                    cVar.a();
                    return;
                }
                return;
            }
            if (sqrt < f11 && this.f18079f && z10) {
                this.f18079f = false;
                this.f18078e = currentTimeMillis;
                HashMap hashMap = new HashMap();
                hashMap.put("x_max_acc", Float.valueOf(this.f18080g * this.f18084k));
                hashMap.put("y_max_acc", Float.valueOf(this.f18081h * this.f18084k));
                hashMap.put("z_max_acc", Float.valueOf(this.f18082i * this.f18084k));
                this.f18080g = 0.0f;
                this.f18081h = 0.0f;
                this.f18082i = 0.0f;
                c cVar2 = this.f18083j;
                if (cVar2 != null) {
                    cVar2.a(hashMap);
                }
            }
        }

        @Override // com.sigmob.sdk.base.common.y.b
        public void b(int i10) {
            this.f18085l = Integer.valueOf(i10);
        }

        @Override // com.sigmob.sdk.base.common.y.b
        public void c() {
            SensorManager sensorManager = this.f18077d;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
                SensorManager sensorManager2 = this.f18077d;
                sensorManager2.registerListener(this, sensorManager2.getDefaultSensor(4), 3);
            }
        }

        @Override // com.sigmob.sdk.base.common.y.b
        public void a(int i10) {
            this.f18047a = i10;
        }
    }
}
