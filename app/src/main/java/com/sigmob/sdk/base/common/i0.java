package com.sigmob.sdk.base.common;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.czhj.sdk.logger.SigmobLog;
import com.umeng.analytics.pro.bt;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class i0 {

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f17866a;

        static {
            int[] iArr = new int[d.values().length];
            f17866a = iArr;
            try {
                iArr[d.SLOPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17866a[d.SWING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17866a[d.WRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class b implements SensorEventListener {

        /* renamed from: a */
        public static int[] f17867a = {25, 60, 50, 45, 35, 25, 20, 15, 10, 5, 1};

        /* renamed from: b */
        public static float[] f17868b = {4.0f, 10.0f, 8.0f, 6.0f, 5.0f, 4.0f, 3.0f, 2.0f, 1.8f, 1.5f, 1.0f};

        /* renamed from: c */
        public static float f17869c = 40.0f;
        public float A;
        public long D;
        public Integer E;

        /* renamed from: e */
        public final SensorManager f17871e;

        /* renamed from: f */
        public float[] f17872f;

        /* renamed from: g */
        public float[] f17873g;

        /* renamed from: j */
        public Float f17876j;

        /* renamed from: k */
        public c f17877k;

        /* renamed from: l */
        public float f17878l;

        /* renamed from: m */
        public float f17879m;

        /* renamed from: n */
        public float f17880n;

        /* renamed from: o */
        public long f17881o;

        /* renamed from: p */
        public boolean f17882p;

        /* renamed from: r */
        public float f17884r;

        /* renamed from: s */
        public float f17885s;

        /* renamed from: t */
        public float f17886t;

        /* renamed from: u */
        public d f17887u;

        /* renamed from: v */
        public long f17888v;

        /* renamed from: w */
        public float f17889w;

        /* renamed from: x */
        public float f17890x;

        /* renamed from: y */
        public float f17891y;

        /* renamed from: z */
        public boolean f17892z;

        /* renamed from: d */
        public int f17870d = 2;

        /* renamed from: h */
        public float[] f17874h = new float[9];

        /* renamed from: i */
        public float[] f17875i = new float[3];

        /* renamed from: q */
        public int f17883q = 0;
        public int B = 100;
        public int C = 2000;

        public b(Context context, c cVar, d dVar) {
            this.f17871e = (SensorManager) context.getSystemService(bt.f23586ac);
            this.f17877k = cVar;
            this.f17887u = dVar;
        }

        public void a() {
            SensorManager sensorManager = this.f17871e;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
            this.f17890x = 0.0f;
            this.f17891y = 0.0f;
            this.f17889w = 0.0f;
            this.f17878l = 0.0f;
            this.f17879m = 0.0f;
            this.f17880n = 0.0f;
            this.A = 0.0f;
            this.D = 0L;
            this.f17876j = null;
            this.f17877k = null;
        }

        public void b() {
            SensorManager sensorManager = this.f17871e;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
        }

        public void c(int i10) {
            this.E = Integer.valueOf(i10);
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i10) {
        }

        /* JADX WARN: Code restructure failed: missing block: B:152:0x03c5, code lost:
        
            if (r2 != null) goto L483;
         */
        /* JADX WARN: Removed duplicated region for block: B:103:0x029f  */
        /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:131:0x0330  */
        /* JADX WARN: Removed duplicated region for block: B:134:0x0344  */
        /* JADX WARN: Removed duplicated region for block: B:137:0x0358  */
        /* JADX WARN: Removed duplicated region for block: B:140:0x036d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:141:0x036e  */
        /* JADX WARN: Removed duplicated region for block: B:95:0x0286  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x0292  */
        @Override // android.hardware.SensorEventListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onSensorChanged(android.hardware.SensorEvent r18) {
            /*
                Method dump skipped, instructions count: 981
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.i0.b.onSensorChanged(android.hardware.SensorEvent):void");
        }

        public final void a(float[] fArr) {
            float f10;
            float sqrt = (float) Math.sqrt(Math.pow(fArr[0], 2.0d) + Math.pow(fArr[1], 2.0d) + Math.pow(fArr[2], 2.0d));
            long currentTimeMillis = System.currentTimeMillis();
            boolean z10 = currentTimeMillis - this.f17881o >= ((long) this.C);
            if (Math.abs(this.f17878l) < Math.abs(fArr[0])) {
                this.f17878l = fArr[0];
            }
            if (Math.abs(this.f17879m) < Math.abs(fArr[1])) {
                this.f17879m = fArr[1];
            }
            if (Math.abs(this.f17880n) < Math.abs(fArr[2])) {
                this.f17880n = fArr[2];
            }
            Integer num = this.E;
            if (num != null) {
                f10 = num.intValue();
            } else {
                int i10 = this.f17870d;
                f10 = (i10 <= 0 || i10 > 10) ? 4.0f : f17868b[i10];
            }
            f17869c = f10;
            SigmobLog.d("shake magnitude" + sqrt);
            float f11 = f17869c;
            if (sqrt > f11 && !this.f17882p && z10) {
                this.f17882p = true;
                c cVar = this.f17877k;
                if (cVar != null) {
                    cVar.a();
                    return;
                }
                return;
            }
            if (sqrt < f11 && this.f17882p && z10) {
                this.f17882p = false;
                this.f17881o = currentTimeMillis;
                HashMap hashMap = new HashMap();
                hashMap.put("x_max_acc", Float.valueOf(this.f17878l * this.B));
                hashMap.put("y_max_acc", Float.valueOf(this.f17879m * this.B));
                hashMap.put("z_max_acc", Float.valueOf(this.f17880n * this.B));
                this.f17878l = 0.0f;
                this.f17879m = 0.0f;
                this.f17880n = 0.0f;
                c cVar2 = this.f17877k;
                if (cVar2 != null) {
                    cVar2.a(hashMap);
                }
            }
        }

        public void b(int i10) {
            this.f17870d = i10;
        }

        public void c() {
            SensorManager sensorManager = this.f17871e;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
                SensorManager sensorManager2 = this.f17871e;
                sensorManager2.registerListener(this, sensorManager2.getDefaultSensor(4), 3);
                if (this.f17887u == d.SHAKE) {
                    return;
                }
                SensorManager sensorManager3 = this.f17871e;
                sensorManager3.registerListener(this, sensorManager3.getDefaultSensor(1), 3);
                SensorManager sensorManager4 = this.f17871e;
                sensorManager4.registerListener(this, sensorManager4.getDefaultSensor(2), 3);
            }
            this.f17876j = null;
        }

        public void a(int i10) {
            if (i10 > 0) {
                this.B = i10;
            }
        }
    }

    public interface c {
        void a();

        void a(float f10);

        void a(Map<String, Number> map);
    }

    public enum d {
        SWING,
        WRING,
        SLOPE,
        SHAKE
    }
}
