package cn.vlion.ad.inland.base;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorBean;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorPara;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import com.umeng.analytics.pro.bt;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class g6 implements SensorEventListener, Handler.Callback {

    /* renamed from: a */
    public volatile SensorManager f2819a;

    /* renamed from: e */
    public volatile VlionSensorBean f2823e;

    /* renamed from: g */
    public long f2825g;

    /* renamed from: h */
    public long f2826h;

    /* renamed from: i */
    public ArrayList f2827i;

    /* renamed from: j */
    public ArrayList f2828j;

    /* renamed from: k */
    public long f2829k;

    /* renamed from: b */
    public volatile float[] f2820b = new float[4];

    /* renamed from: c */
    public volatile boolean f2821c = false;

    /* renamed from: d */
    public volatile float[] f2822d = new float[4];

    /* renamed from: l */
    public VlionSensorPara f2830l = new VlionSensorPara();

    /* renamed from: f */
    public volatile Handler f2824f = new Handler(Looper.getMainLooper(), this);

    public g6(Context context) {
        a(context);
    }

    public abstract void a();

    public final void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            this.f2819a = (SensorManager) context.getSystemService(bt.f23586ac);
            if (this.f2819a != null) {
                this.f2819a.registerListener(this, this.f2819a.getDefaultSensor(1), 2);
                this.f2819a.registerListener(this, this.f2819a.getDefaultSensor(11), 3);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public abstract void b();

    public abstract void c();

    public final void d() {
        try {
            if (this.f2824f != null) {
                this.f2824f.removeCallbacksAndMessages(null);
                this.f2824f = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message == null) {
            return true;
        }
        try {
            if (message.what != 100003) {
                return true;
            }
            a();
            return true;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return true;
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i10;
        float f10;
        float f11;
        float f12;
        double d10;
        try {
            if (this.f2823e == null) {
                return;
            }
            try {
                i10 = sensorEvent.sensor.getType();
            } catch (Exception unused) {
                i10 = -1;
            }
            if (i10 == 1) {
                float[] fArr = (float[]) sensorEvent.values.clone();
                float f13 = fArr[0];
                float f14 = fArr[1];
                float f15 = fArr[2];
                float pow = (float) Math.pow(f13, 2.0d);
                float pow2 = (float) Math.pow(f14, 2.0d);
                float pow3 = (float) Math.pow(f15, 2.0d);
                float sqrt = (float) Math.sqrt(pow + pow2 + pow3);
                if (this.f2823e == null || this.f2823e.f2393a <= 0 || sqrt <= this.f2823e.f2393a) {
                    return;
                }
                if (this.f2830l == null) {
                    this.f2830l = new VlionSensorPara();
                }
                this.f2830l.setSpeed((int) (f13 * 100.0f), (int) (pow2 * 100.0f), (int) (pow3 * 100.0f));
                b();
                return;
            }
            if (i10 == 11) {
                System.arraycopy(sensorEvent.values, 0, this.f2822d, 0, this.f2822d.length);
                if (!this.f2821c) {
                    System.arraycopy(this.f2822d, 0, this.f2820b, 0, this.f2822d.length);
                    this.f2821c = true;
                    return;
                }
                float[] fArr2 = new float[4];
                try {
                    SensorManager.getQuaternionFromVector(fArr2, this.f2820b);
                } catch (Exception unused2) {
                }
                float[] fArr3 = new float[4];
                try {
                    SensorManager.getQuaternionFromVector(fArr3, this.f2822d);
                } catch (Exception unused3) {
                }
                try {
                    f10 = fArr2[0] * fArr3[0];
                } catch (Exception unused4) {
                    f10 = -1.0f;
                }
                try {
                    f10 += fArr2[1] * fArr3[1];
                } catch (Exception unused5) {
                }
                try {
                    f10 += fArr2[2] * fArr3[2];
                } catch (Exception unused6) {
                }
                float f16 = 0.0f;
                try {
                    float f17 = fArr2[0];
                    float f18 = fArr3[0];
                    f10 = f18 * f17;
                    f11 = f18 - f17;
                } catch (Exception unused7) {
                    f11 = 0.0f;
                }
                try {
                    float f19 = fArr2[1];
                    float f20 = fArr3[1];
                    f10 += f19 * f20;
                    f12 = f20 - f19;
                } catch (Exception unused8) {
                    f12 = 0.0f;
                }
                try {
                    float f21 = fArr2[2];
                    float f22 = fArr3[2];
                    f10 += f21 * f22;
                    f16 = f22 - f21;
                } catch (Exception unused9) {
                }
                try {
                    d10 = (((fArr2[3] * fArr3[3]) + f10) * 2.0f) - 1.0f;
                } catch (Exception unused10) {
                    d10 = -1.0d;
                }
                try {
                    d10 = Math.toDegrees(Math.acos(Math.min(Math.max(d10, -1.0d), 1.0d)));
                } catch (Exception unused11) {
                }
                if (this.f2823e == null || this.f2823e.f2394b <= 0 || this.f2823e.f2394b > d10) {
                    return;
                }
                if (this.f2830l == null) {
                    this.f2830l = new VlionSensorPara();
                }
                this.f2830l.setRotate((int) Math.toDegrees(f11), (int) Math.toDegrees(f12), (int) Math.toDegrees(f16));
                c();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
