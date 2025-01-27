package com.jd.ad.sdk.bl.dynamicrender;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.logger.Logger;
import com.umeng.analytics.pro.bt;
import java.util.ArrayList;
import java.util.List;
import l5.c;

/* loaded from: classes2.dex */
public abstract class ShakeListener implements SensorEventListener, Handler.Callback {
    public SensorManager jad_an;
    public float jad_bo;
    public float[] jad_cp;
    public final float[] jad_dq;
    public boolean jad_er;
    public float jad_fs;
    public List<Long> jad_hu;
    public List<Long> jad_iv;
    public float jad_jt;
    public long jad_jw;
    public long jad_kx;
    public Handler jad_ly;
    public long jad_mz;

    public ShakeListener(Context context) {
        this.jad_bo = 0.0f;
        this.jad_cp = new float[4];
        this.jad_dq = new float[4];
        this.jad_er = false;
        this.jad_fs = 0.0f;
        this.jad_jt = 0.0f;
        this.jad_hu = new ArrayList();
        this.jad_iv = new ArrayList();
        this.jad_jw = 0L;
        this.jad_mz = 0L;
        try {
            this.jad_an = (SensorManager) context.getSystemService(bt.f23586ac);
        } catch (SecurityException e10) {
            e10.printStackTrace();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        jad_an();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0041, code lost:
    
        if (r7.jad_bo > 0.0f) goto L75;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void jad_an() {
        /*
            r7 = this;
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L37
            long r2 = r7.jad_mz     // Catch: java.lang.Exception -> L37
            long r2 = r0 - r2
            double r2 = (double) r2     // Catch: java.lang.Exception -> L37
            r4 = 4656510908468559872(0x409f400000000000, double:2000.0)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L13
            return
        L13:
            r7.jad_mz = r0     // Catch: java.lang.Exception -> L37
            java.util.List<java.lang.Long> r0 = r7.jad_hu     // Catch: java.lang.Exception -> L37
            boolean r0 = r7.jad_an(r0)     // Catch: java.lang.Exception -> L37
            java.util.List<java.lang.Long> r1 = r7.jad_iv     // Catch: java.lang.Exception -> L37
            boolean r1 = r7.jad_an(r1)     // Catch: java.lang.Exception -> L37
            float r2 = r7.jad_fs     // Catch: java.lang.Exception -> L37
            r3 = 0
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L39
            float r5 = r7.jad_bo     // Catch: java.lang.Exception -> L37
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 <= 0) goto L39
            if (r0 == 0) goto L35
            if (r1 == 0) goto L35
            r0 = 1
            goto L43
        L35:
            r0 = 0
            goto L43
        L37:
            r0 = move-exception
            goto L50
        L39:
            if (r2 <= 0) goto L3d
            r0 = r1
            goto L43
        L3d:
            float r1 = r7.jad_bo     // Catch: java.lang.Exception -> L37
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 <= 0) goto L35
        L43:
            if (r0 == 0) goto L4c
            r7.onShake()     // Catch: java.lang.Exception -> L37
            r7.jad_dq()     // Catch: java.lang.Exception -> L37
            goto L56
        L4c:
            r7.jad_dq()     // Catch: java.lang.Exception -> L37
            goto L56
        L50:
            r7.jad_dq()
            r0.printStackTrace()
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.bl.dynamicrender.ShakeListener.jad_an():void");
    }

    public final synchronized void jad_bo() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.jad_jt > 0.0f) {
                if (currentTimeMillis - this.jad_jw > 1500.0d) {
                    this.jad_hu = new ArrayList();
                    this.jad_iv = new ArrayList();
                    jad_dq();
                }
                Handler handler = this.jad_ly;
                if (handler == null) {
                    if (handler == null) {
                        this.jad_ly = new Handler(Looper.getMainLooper(), this);
                    }
                    Handler handler2 = this.jad_ly;
                    if (handler2 != null) {
                        handler2.sendEmptyMessageDelayed(1, (long) (this.jad_jt * 1000.0f));
                    }
                }
            }
            this.jad_jw = currentTimeMillis;
            if (this.jad_hu == null) {
                this.jad_hu = new ArrayList();
            }
            this.jad_hu.add(Long.valueOf(currentTimeMillis));
            if (this.jad_jt == 0.0f) {
                jad_an();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void jad_cp() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.jad_jt > 0.0f) {
                if (currentTimeMillis - this.jad_kx > 1500.0d) {
                    this.jad_iv = new ArrayList();
                    this.jad_hu = new ArrayList();
                    jad_dq();
                }
                Handler handler = this.jad_ly;
                if (handler == null) {
                    if (handler == null) {
                        this.jad_ly = new Handler(Looper.getMainLooper(), this);
                    }
                    Handler handler2 = this.jad_ly;
                    if (handler2 != null) {
                        handler2.sendEmptyMessageDelayed(1, (long) (this.jad_jt * 1000.0f));
                    }
                }
            }
            this.jad_kx = currentTimeMillis;
            if (this.jad_iv == null) {
                this.jad_iv = new ArrayList();
            }
            this.jad_iv.add(Long.valueOf(currentTimeMillis));
            if (this.jad_jt == 0.0f) {
                jad_an();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void jad_dq() {
        Handler handler = this.jad_ly;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.jad_ly = null;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (sensorEvent.sensor.getType() == 1) {
                if (this.jad_bo > 0.0f) {
                    float[] fArr = sensorEvent.values;
                    if (Math.sqrt(Math.pow(fArr[0], 2.0d) + Math.pow(fArr[1], 2.0d) + Math.pow(fArr[2], 2.0d)) > this.jad_bo) {
                        jad_bo();
                    }
                }
            } else if (sensorEvent.sensor.getType() == 11 && this.jad_fs > 0.0f) {
                float[] fArr2 = sensorEvent.values;
                float[] fArr3 = this.jad_dq;
                System.arraycopy(fArr2, 0, fArr3, 0, fArr3.length);
                if (this.jad_er) {
                    float[] fArr4 = new float[4];
                    SensorManager.getQuaternionFromVector(fArr4, this.jad_cp);
                    float[] fArr5 = new float[4];
                    SensorManager.getQuaternionFromVector(fArr5, this.jad_dq);
                    float f10 = fArr4[0];
                    float f11 = fArr5[0];
                    float f12 = fArr4[1];
                    float f13 = fArr5[1];
                    float f14 = fArr4[2];
                    float f15 = fArr5[2];
                    float f16 = f14 * f15;
                    float f17 = fArr4[3] * fArr5[3];
                    if (this.jad_fs <= Math.toDegrees(Math.acos(Math.min(Math.max(((f17 + (f16 + ((f12 * f13) + (f10 * f11)))) * (((r9 * r11) + ((f14 * f15) + ((f12 * f13) + (f10 * f11)))) * 2.0f)) - 1.0f, -1.0d), 1.0d)))) {
                        this.jad_cp = fArr4;
                        jad_cp();
                    }
                } else {
                    float[] fArr6 = this.jad_dq;
                    System.arraycopy(fArr6, 0, this.jad_cp, 0, fArr6.length);
                    this.jad_er = true;
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public abstract void onShake();

    public void register() {
        try {
            SensorManager sensorManager = this.jad_an;
            if (sensorManager != null) {
                sensorManager.registerListener(this, sensorManager.getDefaultSensor(1), 2);
                SensorManager sensorManager2 = this.jad_an;
                sensorManager2.registerListener(this, sensorManager2.getDefaultSensor(11), 3);
            }
        } catch (Exception e10) {
            Logger.w("Exception while register shake listener: " + e10, new Object[0]);
        }
    }

    public void unregister() {
        jad_dq();
        SensorManager sensorManager = this.jad_an;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    public final boolean jad_an(List<Long> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        if (this.jad_jt == 0.0f) {
            return true;
        }
        if (list.size() < 2) {
            return false;
        }
        int size = list.size();
        double longValue = list.get(0).longValue();
        int i10 = size - 1;
        double longValue2 = list.get(i10).longValue();
        if (longValue2 - longValue <= c.f27899e) {
            return false;
        }
        double d10 = 0.0d;
        for (int i11 = 1; i11 < size; i11++) {
            double longValue3 = list.get(i11).longValue() - list.get(i11 - 1).longValue();
            if (longValue3 < c.f27899e) {
                return false;
            }
            d10 += longValue3;
        }
        double d11 = i10;
        return d10 / d11 <= ((double) (this.jad_jt * 1000.0f)) / d11 && ((double) System.currentTimeMillis()) - longValue2 < 1500.0d;
    }

    public ShakeListener(Context context, float f10, float f11, float f12) {
        this.jad_bo = 0.0f;
        this.jad_cp = new float[4];
        this.jad_dq = new float[4];
        this.jad_er = false;
        this.jad_fs = 0.0f;
        this.jad_jt = 0.0f;
        this.jad_hu = new ArrayList();
        this.jad_iv = new ArrayList();
        this.jad_jw = 0L;
        this.jad_mz = 0L;
        try {
            this.jad_an = (SensorManager) context.getSystemService(bt.f23586ac);
            this.jad_bo = f10;
            this.jad_fs = f11;
            this.jad_jt = f12;
        } catch (SecurityException e10) {
            e10.printStackTrace();
        }
    }

    public ShakeListener(Context context, float f10, float f11, float f12, boolean z10) {
        this.jad_bo = 0.0f;
        this.jad_cp = new float[4];
        this.jad_dq = new float[4];
        this.jad_er = false;
        this.jad_fs = 0.0f;
        this.jad_jt = 0.0f;
        this.jad_hu = new ArrayList();
        this.jad_iv = new ArrayList();
        this.jad_jw = 0L;
        this.jad_mz = 0L;
        try {
            this.jad_an = (SensorManager) context.getSystemService(bt.f23586ac);
            this.jad_bo = f10;
            this.jad_fs = f11;
            this.jad_jt = f12;
        } catch (SecurityException e10) {
            e10.printStackTrace();
        }
    }
}
