package com.sigmob.sdk.base.services;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Base64;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.mta.PointEntitySensor;
import com.sigmob.sdk.base.mta.PointType;
import com.umeng.analytics.pro.bt;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
public class h implements SensorEventListener {

    /* renamed from: g */
    public static Handler f18371g = null;

    /* renamed from: h */
    public static int f18372h = 500;

    /* renamed from: c */
    public List<g> f18375c;

    /* renamed from: d */
    public SensorManager f18376d;

    /* renamed from: a */
    public DecimalFormat f18373a = new DecimalFormat("#######.######");

    /* renamed from: b */
    public g f18374b = new g();

    /* renamed from: e */
    public int f18377e = 300;

    /* renamed from: f */
    public int f18378f = 50;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == f.SENSOR_EVENT_BEGIN.b()) {
                i iVar = (i) message.obj;
                int size = h.this.f18375c.size() - 1;
                iVar.f18381a = (g) h.this.f18375c.get(size >= 0 ? size : 0);
                Message message2 = new Message();
                message2.what = f.SENSOR_EVENT_END.b();
                message2.obj = iVar;
                h.f18371g.sendMessageDelayed(message2, h.this.f18377e * (h.this.f18378f + 1));
                return;
            }
            if (message.what != f.SENSOR_EVENT_END.b()) {
                if (message.what == f.SENSOR_EVENT_PUSH.b()) {
                    try {
                        h.this.f18374b.f18370g = System.currentTimeMillis();
                        g clone = h.this.f18374b.clone();
                        if (h.this.f18375c.size() > h.f18372h) {
                            h.this.f18375c.remove(0);
                        }
                        if (clone != null) {
                            h.this.f18375c.add(clone);
                        }
                    } catch (CloneNotSupportedException e10) {
                        SigmobLog.e(e10.getMessage());
                    }
                    Message message3 = new Message();
                    message3.what = f.SENSOR_EVENT_PUSH.b();
                    h.f18371g.sendMessageDelayed(message3, h.this.f18377e);
                    return;
                }
                return;
            }
            i iVar2 = (i) message.obj;
            int indexOf = h.this.f18375c.indexOf(iVar2.f18381a);
            int i10 = indexOf - h.this.f18378f;
            if (indexOf >= 0 && indexOf >= h.this.f18378f) {
                r2 = i10;
            }
            int i11 = h.this.f18378f + indexOf;
            if (i11 > h.this.f18375c.size() - 1) {
                i11 = h.this.f18375c.size() - 1;
            }
            if (h.this.f18375c.size() > 0) {
                CopyOnWriteArrayList copyOnWriteArrayList = r2 < indexOf ? new CopyOnWriteArrayList(h.this.f18375c.subList(r2, indexOf)) : null;
                CopyOnWriteArrayList copyOnWriteArrayList2 = indexOf < i11 ? new CopyOnWriteArrayList(h.this.f18375c.subList(indexOf, i11)) : null;
                if (copyOnWriteArrayList == null && copyOnWriteArrayList2 == null) {
                    return;
                }
                h.this.a(copyOnWriteArrayList, copyOnWriteArrayList2, iVar2.f18382b, iVar2.f18383c);
            }
        }
    }

    public static class b {

        /* renamed from: a */
        public static final h f18380a = new h();
    }

    public String a(String str) {
        return str;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            this.f18374b.f18367d = (float[]) sensorEvent.values.clone();
            return;
        }
        if (type == 2) {
            this.f18374b.f18366c = (float[]) sensorEvent.values.clone();
            return;
        }
        if (type == 4) {
            this.f18374b.f18365b = (float[]) sensorEvent.values.clone();
            return;
        }
        if (type == 5) {
            this.f18374b.f18368e = (float[]) sensorEvent.values.clone();
        } else if (type == 9) {
            this.f18374b.f18364a = (float[]) sensorEvent.values.clone();
        } else {
            if (type != 10) {
                return;
            }
            this.f18374b.f18369f = (float[]) sensorEvent.values.clone();
        }
    }

    public static h c() {
        return b.f18380a;
    }

    public void a(String str, String str2) {
        if (com.sigmob.sdk.base.l.w().d() && com.sigmob.sdk.base.l.w().b(str)) {
            a(com.sigmob.sdk.a.d());
            Message message = new Message();
            i iVar = new i();
            iVar.f18382b = str;
            iVar.f18383c = str2;
            message.what = f.SENSOR_EVENT_BEGIN.b();
            message.obj = iVar;
            Handler handler = f18371g;
            if (handler != null) {
                handler.sendMessage(message);
            }
        }
    }

    public final String a(List<g> list) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        String a10;
        float[] fArr;
        String a11;
        float[] fArr2;
        String a12;
        float[] fArr3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        ArrayList arrayList8;
        String a13;
        float[] fArr4;
        ArrayList arrayList9;
        ArrayList arrayList10;
        ArrayList arrayList11;
        ArrayList arrayList12;
        ArrayList arrayList13;
        String a14;
        float[] fArr5;
        ArrayList arrayList14;
        ArrayList arrayList15;
        String a15;
        List<g> list2 = list;
        StringBuilder sb2 = new StringBuilder();
        if (list2 == null || list.size() == 0) {
            return sb2.toString();
        }
        ArrayList arrayList16 = new ArrayList();
        ArrayList arrayList17 = new ArrayList();
        ArrayList arrayList18 = new ArrayList();
        ArrayList arrayList19 = new ArrayList();
        ArrayList arrayList20 = new ArrayList();
        ArrayList arrayList21 = new ArrayList();
        ArrayList arrayList22 = new ArrayList();
        ArrayList arrayList23 = new ArrayList();
        ArrayList arrayList24 = new ArrayList();
        ArrayList arrayList25 = new ArrayList();
        ArrayList arrayList26 = new ArrayList();
        ArrayList arrayList27 = new ArrayList();
        ArrayList arrayList28 = new ArrayList();
        ArrayList arrayList29 = new ArrayList();
        ArrayList arrayList30 = new ArrayList();
        ArrayList arrayList31 = arrayList28;
        ArrayList arrayList32 = new ArrayList();
        int i10 = 0;
        while (i10 < list.size()) {
            g gVar = list2.get(i10);
            float[] fArr6 = gVar.f18364a;
            int i11 = i10;
            if (fArr6 != null) {
                arrayList2 = arrayList27;
                arrayList3 = arrayList26;
                if (fArr6.length > 2) {
                    arrayList16.add(a(this.f18373a.format(fArr6[0])));
                    arrayList = arrayList25;
                    arrayList17.add(a(this.f18373a.format(gVar.f18364a[1])));
                    a10 = a(this.f18373a.format(gVar.f18364a[2]));
                    arrayList18.add(a10);
                    fArr = gVar.f18365b;
                    if (fArr != null || fArr.length <= 2) {
                        arrayList19.add(a("0"));
                        arrayList20.add(a("0"));
                        a11 = a("0");
                    } else {
                        arrayList19.add(a(this.f18373a.format(fArr[0])));
                        arrayList20.add(a(this.f18373a.format(gVar.f18365b[1])));
                        a11 = a(this.f18373a.format(gVar.f18365b[2]));
                    }
                    arrayList21.add(a11);
                    fArr2 = gVar.f18366c;
                    if (fArr2 != null || fArr2.length <= 2) {
                        arrayList22.add(a("0"));
                        arrayList23.add(a("0"));
                        a12 = a("0");
                    } else {
                        arrayList22.add(a(this.f18373a.format(fArr2[0])));
                        arrayList23.add(a(this.f18373a.format(gVar.f18366c[1])));
                        a12 = a(this.f18373a.format(gVar.f18366c[2]));
                    }
                    arrayList24.add(a12);
                    fArr3 = gVar.f18367d;
                    if (fArr3 != null || fArr3.length <= 2) {
                        arrayList4 = arrayList2;
                        arrayList5 = arrayList3;
                        arrayList6 = arrayList;
                        arrayList7 = arrayList23;
                        arrayList8 = arrayList24;
                        arrayList6.add(a("0"));
                        arrayList5.add(a("0"));
                        a13 = a("0");
                    } else {
                        arrayList6 = arrayList;
                        arrayList6.add(a(this.f18373a.format(fArr3[0])));
                        arrayList5 = arrayList3;
                        arrayList5.add(a(this.f18373a.format(gVar.f18367d[1])));
                        arrayList7 = arrayList23;
                        arrayList8 = arrayList24;
                        a13 = a(this.f18373a.format(gVar.f18367d[2]));
                        arrayList4 = arrayList2;
                    }
                    arrayList4.add(a13);
                    fArr4 = gVar.f18369f;
                    if (fArr4 != null || fArr4.length <= 2) {
                        arrayList9 = arrayList4;
                        arrayList10 = arrayList29;
                        arrayList11 = arrayList30;
                        ArrayList arrayList33 = arrayList31;
                        arrayList12 = arrayList5;
                        arrayList13 = arrayList33;
                        arrayList13.add(a("0"));
                        arrayList10.add(a("0"));
                        a14 = a("0");
                    } else {
                        ArrayList arrayList34 = arrayList5;
                        arrayList9 = arrayList4;
                        arrayList13 = arrayList31;
                        arrayList13.add(a(this.f18373a.format(fArr4[0])));
                        arrayList12 = arrayList34;
                        arrayList10 = arrayList29;
                        arrayList10.add(a(this.f18373a.format(gVar.f18369f[1])));
                        a14 = a(this.f18373a.format(gVar.f18369f[2]));
                        arrayList11 = arrayList30;
                    }
                    arrayList11.add(a14);
                    fArr5 = gVar.f18368e;
                    if (fArr5 != null || fArr5.length <= 0) {
                        arrayList14 = arrayList6;
                        arrayList15 = arrayList32;
                        a15 = a("0");
                    } else {
                        arrayList14 = arrayList6;
                        a15 = a(this.f18373a.format(fArr5[0]));
                        arrayList15 = arrayList32;
                    }
                    arrayList15.add(a15);
                    i10 = i11 + 1;
                    list2 = list;
                    arrayList32 = arrayList15;
                    arrayList29 = arrayList10;
                    arrayList30 = arrayList11;
                    arrayList25 = arrayList14;
                    arrayList26 = arrayList12;
                    arrayList23 = arrayList7;
                    arrayList24 = arrayList8;
                    arrayList31 = arrayList13;
                    arrayList27 = arrayList9;
                } else {
                    arrayList = arrayList25;
                }
            } else {
                arrayList = arrayList25;
                arrayList2 = arrayList27;
                arrayList3 = arrayList26;
            }
            arrayList16.add(a("0"));
            arrayList17.add(a("0"));
            a10 = a("0");
            arrayList18.add(a10);
            fArr = gVar.f18365b;
            if (fArr != null) {
            }
            arrayList19.add(a("0"));
            arrayList20.add(a("0"));
            a11 = a("0");
            arrayList21.add(a11);
            fArr2 = gVar.f18366c;
            if (fArr2 != null) {
            }
            arrayList22.add(a("0"));
            arrayList23.add(a("0"));
            a12 = a("0");
            arrayList24.add(a12);
            fArr3 = gVar.f18367d;
            if (fArr3 != null) {
            }
            arrayList4 = arrayList2;
            arrayList5 = arrayList3;
            arrayList6 = arrayList;
            arrayList7 = arrayList23;
            arrayList8 = arrayList24;
            arrayList6.add(a("0"));
            arrayList5.add(a("0"));
            a13 = a("0");
            arrayList4.add(a13);
            fArr4 = gVar.f18369f;
            if (fArr4 != null) {
            }
            arrayList9 = arrayList4;
            arrayList10 = arrayList29;
            arrayList11 = arrayList30;
            ArrayList arrayList332 = arrayList31;
            arrayList12 = arrayList5;
            arrayList13 = arrayList332;
            arrayList13.add(a("0"));
            arrayList10.add(a("0"));
            a14 = a("0");
            arrayList11.add(a14);
            fArr5 = gVar.f18368e;
            if (fArr5 != null) {
            }
            arrayList14 = arrayList6;
            arrayList15 = arrayList32;
            a15 = a("0");
            arrayList15.add(a15);
            i10 = i11 + 1;
            list2 = list;
            arrayList32 = arrayList15;
            arrayList29 = arrayList10;
            arrayList30 = arrayList11;
            arrayList25 = arrayList14;
            arrayList26 = arrayList12;
            arrayList23 = arrayList7;
            arrayList24 = arrayList8;
            arrayList31 = arrayList13;
            arrayList27 = arrayList9;
        }
        sb2.append("{");
        sb2.append(String.format("\"gravity\":{%s}", String.format("\"x\":%s,\"y\":%s,\"z\":%s", arrayList16.toString(), arrayList17.toString(), arrayList18.toString())));
        sb2.append(",");
        sb2.append(String.format("\"gyroscope\":{%s}", String.format("\"x\":%s,\"y\":%s,\"z\":%s", arrayList19.toString(), arrayList20.toString(), arrayList21.toString())));
        sb2.append(",");
        sb2.append(String.format("\"magnetic_field\":{%s}", String.format("\"x\":%s,\"y\":%s,\"z\":%s", arrayList22.toString(), arrayList23.toString(), arrayList24.toString())));
        sb2.append(",");
        sb2.append(String.format("\"light\":%s", arrayList32.toString()));
        sb2.append(",");
        sb2.append(String.format("\"linear_acceleration\":{%s}", String.format("\"x\":%s,\"y\":%s,\"z\":%s", arrayList31.toString(), arrayList29.toString(), arrayList30.toString())));
        sb2.append(",");
        sb2.append(String.format("\"accelerometer\":{%s}", String.format("\"x\":%s,\"y\":%s,\"z\":%s", arrayList25.toString(), arrayList26.toString(), arrayList27.toString())));
        sb2.append(p3.f.f29748d);
        return Base64.encodeToString(sb2.toString().getBytes(), 2);
    }

    public void a(Context context) {
        try {
            if (this.f18376d != null) {
                if (com.sigmob.sdk.base.l.w().d()) {
                    return;
                }
                this.f18376d.unregisterListener(this);
                f18371g.removeCallbacksAndMessages(null);
                this.f18375c.clear();
                this.f18376d = null;
                return;
            }
            if (com.sigmob.sdk.base.l.w().d()) {
                SigmobLog.i("start anti spam motion");
                this.f18375c = new ArrayList();
                this.f18378f = com.sigmob.sdk.base.l.w().B();
                this.f18377e = com.sigmob.sdk.base.l.w().C();
                f18372h = com.sigmob.sdk.base.l.w().D();
                SensorManager sensorManager = (SensorManager) context.getSystemService(bt.f23586ac);
                this.f18376d = sensorManager;
                sensorManager.registerListener(this, sensorManager.getDefaultSensor(5), 3);
                SigmobLog.d("光线传感器 ");
                SensorManager sensorManager2 = this.f18376d;
                sensorManager2.registerListener(this, sensorManager2.getDefaultSensor(1), 3);
                SigmobLog.d("加速传感器 ");
                SensorManager sensorManager3 = this.f18376d;
                sensorManager3.registerListener(this, sensorManager3.getDefaultSensor(2), 3);
                SigmobLog.d("磁场传感器 ");
                SensorManager sensorManager4 = this.f18376d;
                sensorManager4.registerListener(this, sensorManager4.getDefaultSensor(4), 3);
                SigmobLog.d("陀螺仪 ");
                SensorManager sensorManager5 = this.f18376d;
                sensorManager5.registerListener(this, sensorManager5.getDefaultSensor(9), 3);
                SigmobLog.d("重力传感器 ");
                SensorManager sensorManager6 = this.f18376d;
                sensorManager6.registerListener(this, sensorManager6.getDefaultSensor(10), 3);
                SigmobLog.d("线性加速器 ");
                f18371g = new a(Looper.getMainLooper());
                Message message = new Message();
                message.what = f.SENSOR_EVENT_PUSH.b();
                Handler handler = f18371g;
                if (handler != null) {
                    handler.sendMessage(message);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(List<g> list, List<g> list2, String str, String str2) {
        PointEntitySensor pointEntitySensor = new PointEntitySensor();
        pointEntitySensor.setAc_type(PointType.ANTI_SPAM);
        pointEntitySensor.setCategory(str);
        pointEntitySensor.setMotion_before(a(list));
        pointEntitySensor.setMotion_after(a(list2));
        pointEntitySensor.setMotion_interval(String.valueOf(this.f18377e));
        pointEntitySensor.setLoad_id(str2);
        pointEntitySensor.commit();
    }

    public void a(int i10) {
        this.f18377e = i10;
    }
}
