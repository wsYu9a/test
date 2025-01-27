package com.vivo.ad.view;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.umeng.analytics.pro.am;
import com.vivo.mobilead.util.VOpenLog;
import com.vivo.mobilead.util.a0;

/* loaded from: classes4.dex */
public class t implements SensorEventListener {
    private volatile boolean A;

    /* renamed from: e */
    private SensorManager f27089e;

    /* renamed from: j */
    private a f27094j;
    private Context k;
    private float l;
    private float m;
    private float n;
    private long o;
    private long z;

    /* renamed from: a */
    private double f27085a = 10.0d;

    /* renamed from: b */
    private double f27086b = 15.0d;

    /* renamed from: c */
    private long f27087c = 500;

    /* renamed from: d */
    private long f27088d = 100;

    /* renamed from: f */
    private final float[] f27090f = new float[3];

    /* renamed from: g */
    private final float[] f27091g = new float[3];

    /* renamed from: h */
    private final float[] f27092h = new float[9];

    /* renamed from: i */
    private final float[] f27093i = new float[3];
    private boolean p = true;
    private double q = 0.0d;
    private double r = 0.0d;
    private boolean s = true;
    private boolean t = false;
    private double u = Double.MAX_VALUE;
    double v = Double.MAX_VALUE;
    double w = 0.0d;
    double x = Double.MAX_VALUE;
    double y = Double.MAX_VALUE;

    public interface a {
        void a(double d2, double d3);
    }

    public t(Context context) {
        this.k = context;
    }

    private void a(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        float[] fArr2 = this.f27090f;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        this.t = true;
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.o;
        if (j2 < this.f27088d || j2 <= 0) {
            return;
        }
        this.o = currentTimeMillis;
        float[] fArr3 = sensorEvent.values;
        float f2 = fArr3[0];
        float f3 = fArr3[1];
        float f4 = fArr3[2];
        float f5 = f2 - this.l;
        float f6 = f3 - this.m;
        float f7 = f4 - this.n;
        this.l = f2;
        this.m = f3;
        this.n = f4;
        if (this.p) {
            this.p = false;
            return;
        }
        double sqrt = Math.sqrt((f5 * f5) + (f6 * f6) + (f7 * f7));
        double d2 = j2;
        Double.isNaN(d2);
        double d3 = (sqrt / d2) * 100.0d;
        this.r = Math.max(d3, this.r);
        this.q = d3;
    }

    private void b(SensorEvent sensorEvent) {
        if (this.t) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.z > this.f27087c) {
                f();
                this.z = currentTimeMillis;
            }
            float[] fArr = sensorEvent.values;
            float[] fArr2 = this.f27091g;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.getRotationMatrix(this.f27092h, null, this.f27090f, this.f27091g);
            SensorManager.getOrientation(this.f27092h, this.f27093i);
            if (this.s) {
                this.s = false;
                double c2 = c(Math.toDegrees(this.f27093i[0]));
                this.u = c2;
                this.v = c2;
                return;
            }
            double c3 = c(Math.toDegrees(this.f27093i[0]));
            if (Math.abs(c3 - this.v) < 2.0d) {
                return;
            }
            this.v = c3;
            double d2 = this.u;
            if (0.0d <= d2 && d2 < 180.0d) {
                if (c3 >= d2 && c3 < d2 + 180.0d) {
                    if (a0.a(this.y, Double.MAX_VALUE) || c3 > this.y) {
                        this.y = c3;
                        return;
                    } else {
                        if (a0.a(this.x, Double.MAX_VALUE)) {
                            this.x = c3;
                            return;
                        }
                        return;
                    }
                }
                if (a0.a(this.x, Double.MAX_VALUE)) {
                    this.x = c3;
                    return;
                }
                double d3 = this.x;
                double a2 = a(c3, this.u, d3);
                this.x = a2;
                if (d3 == a2 && a0.a(this.y, Double.MAX_VALUE)) {
                    this.y = c3;
                    return;
                }
                return;
            }
            if (180.0d > d2 || d2 >= 360.0d) {
                return;
            }
            if (c3 >= d2 - 180.0d && c3 < d2) {
                if (a0.a(this.x, Double.MAX_VALUE) || c3 < this.x) {
                    this.x = c3;
                    return;
                } else {
                    if (a0.a(this.y, Double.MAX_VALUE)) {
                        this.y = c3;
                        return;
                    }
                    return;
                }
            }
            if (a0.a(this.y, Double.MAX_VALUE)) {
                this.y = c3;
                return;
            }
            double d4 = this.y;
            double a3 = a(c3, this.u, d4);
            this.y = a3;
            if (d4 == a3 && a0.a(this.x, Double.MAX_VALUE)) {
                this.x = c3;
            }
        }
    }

    private double c(double d2) {
        return (d2 + 720.0d) % 360.0d;
    }

    private void f() {
        this.s = true;
        this.A = false;
        this.u = Double.MAX_VALUE;
        this.x = Double.MAX_VALUE;
        this.y = Double.MAX_VALUE;
    }

    public double c() {
        return this.r;
    }

    public void d() {
        if (this.k != null || this.A) {
            this.A = true;
            SensorManager sensorManager = (SensorManager) this.k.getSystemService(am.ac);
            this.f27089e = sensorManager;
            if (sensorManager != null) {
                Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                if (defaultSensor != null) {
                    try {
                        this.f27089e.registerListener(this, defaultSensor, 3, 2);
                    } catch (Exception e2) {
                        VOpenLog.d("ShakeListener", "" + e2.getMessage());
                    }
                }
                Sensor defaultSensor2 = this.f27089e.getDefaultSensor(2);
                if (defaultSensor2 != null) {
                    try {
                        this.f27089e.registerListener(this, defaultSensor2, 3, 2);
                    } catch (Exception e3) {
                        VOpenLog.d("ShakeListener", "" + e3.getMessage());
                    }
                }
            }
        }
    }

    public void e() {
        if (this.f27089e != null) {
            try {
                this.A = false;
                this.f27089e.unregisterListener(this);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor;
        if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensorEvent.values == null) {
            return;
        }
        if (sensor.getType() == 1) {
            a(sensorEvent);
        } else if (sensorEvent.sensor.getType() == 2) {
            b(sensorEvent);
        }
        double a2 = a();
        boolean z = a2 > this.f27086b;
        if (z) {
            VOpenLog.d("ShakeListener", String.format("limitValue1 = %s, initAngle = %s, limitValue2 = %s", Double.valueOf(this.x), Double.valueOf(this.u), Double.valueOf(this.y)));
        }
        double d2 = this.q;
        if (d2 < this.f27085a || !z) {
            return;
        }
        a aVar = this.f27094j;
        if (aVar != null) {
            aVar.a(a2, d2);
        }
        e();
    }

    public double a() {
        double d2;
        if (a0.a(this.x, Double.MAX_VALUE) || a0.a(this.y, Double.MAX_VALUE)) {
            if (!a0.a(this.x, Double.MAX_VALUE)) {
                if (Math.abs(this.x - this.u) > 180.0d) {
                    this.w = 360.0d - Math.abs(this.x - this.u);
                } else {
                    this.w = Math.abs(this.x - this.u);
                }
            }
            if (!a0.a(this.y, Double.MAX_VALUE)) {
                if (Math.abs(this.y - this.u) > 180.0d) {
                    this.w = 360.0d - Math.abs(this.y - this.u);
                } else {
                    this.w = Math.abs(this.y - this.u);
                }
            }
        } else {
            if (Math.abs(this.x - this.u) > 180.0d) {
                if (360.0d - Math.abs(this.x - this.u) > this.f27086b) {
                    double abs = 360.0d - Math.abs(this.x - this.u);
                    if (abs > this.w) {
                        this.w = abs;
                    }
                    return abs;
                }
                d2 = 360.0d - Math.abs(this.x - this.u);
                if (d2 > this.w) {
                    this.w = d2;
                }
            } else {
                if (Math.abs(this.x - this.u) > this.f27086b) {
                    double abs2 = Math.abs(this.x - this.u);
                    if (abs2 > this.w) {
                        this.w = abs2;
                    }
                    return abs2;
                }
                r8 = Math.abs(this.x - this.u) > 0.0d ? Math.abs(this.x - this.u) : 0.0d;
                if (r8 > this.w) {
                    this.w = r8;
                }
                d2 = r8;
            }
            if (Math.abs(this.y - this.x) > 180.0d) {
                if (360.0d - Math.abs(this.y - this.x) > this.f27086b) {
                    double abs3 = 360.0d - Math.abs(this.y - this.x);
                    if (abs3 > this.w) {
                        this.w = abs3;
                    }
                    return abs3;
                }
                if (360.0d - Math.abs(this.y - this.x) > d2) {
                    d2 = 360.0d - Math.abs(this.y - this.x);
                }
                if (d2 > this.w) {
                    this.w = d2;
                }
            } else {
                if (Math.abs(this.y - this.x) > this.f27086b) {
                    double abs4 = Math.abs(this.y - this.x);
                    if (abs4 > this.w) {
                        this.w = abs4;
                    }
                    return abs4;
                }
                if (Math.abs(this.y - this.x) > d2) {
                    d2 = Math.abs(this.y - this.x);
                }
                if (d2 > this.w) {
                    this.w = d2;
                }
            }
            if (Math.abs(this.y - this.u) > 180.0d) {
                if (360.0d - Math.abs(this.y - this.u) > this.f27086b) {
                    double abs5 = 360.0d - Math.abs(this.y - this.u);
                    if (abs5 > this.w) {
                        this.w = abs5;
                    }
                    return abs5;
                }
                r8 = 360.0d - Math.abs(this.y - this.u) > d2 ? 360.0d - Math.abs(this.y - this.u) : d2;
                if (r8 > this.w) {
                    this.w = r8;
                }
            } else {
                if (Math.abs(this.y - this.u) > this.f27086b) {
                    double abs6 = Math.abs(this.y - this.u);
                    if (abs6 > this.w) {
                        this.w = abs6;
                    }
                    return abs6;
                }
                if (Math.abs(this.y - this.u) > d2) {
                    d2 = Math.abs(this.y - this.u);
                }
                r8 = d2;
                if (r8 > this.w) {
                    this.w = r8;
                }
            }
        }
        return r8;
    }

    public double b() {
        return this.w;
    }

    public void b(long j2) {
        this.f27088d = j2;
    }

    public void b(double d2) {
        this.f27085a = d2;
    }

    private double a(double d2, double d3, double d4) {
        double d5 = d2 - d3;
        if (Math.abs(d5) > 180.0d) {
            double d6 = d4 - d3;
            if (Math.abs(d6) > 180.0d) {
                if (360.0d - Math.abs(d5) > 360.0d - Math.abs(d6)) {
                    return d2;
                }
            } else if (360.0d - Math.abs(d5) > Math.abs(d6)) {
                return d2;
            }
        } else {
            double d7 = d4 - d3;
            if (Math.abs(d7) > 180.0d) {
                if (Math.abs(d5) > 360.0d - Math.abs(d7)) {
                    return d2;
                }
            } else if (Math.abs(d5) > Math.abs(d7)) {
                return d2;
            }
        }
        return d4;
    }

    public void a(a aVar) {
        this.f27094j = aVar;
    }

    public void a(long j2) {
        this.f27087c = j2;
    }

    public void a(double d2) {
        this.f27086b = d2;
    }
}
