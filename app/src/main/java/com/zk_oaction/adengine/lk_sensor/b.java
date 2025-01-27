package com.zk_oaction.adengine.lk_sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.umeng.analytics.pro.am;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes5.dex */
public class b implements SensorEventListener {

    /* renamed from: a */
    protected HashMap<String, d> f34959a = new HashMap<>();

    /* renamed from: b */
    private com.zk_oaction.adengine.lk_sdk.b f34960b;

    /* renamed from: c */
    private Context f34961c;

    /* renamed from: d */
    private HashMap<String, Integer> f34962d;

    /* renamed from: e */
    private SensorManager f34963e;

    class a extends Thread {

        /* renamed from: a */
        final /* synthetic */ String f34964a;

        /* renamed from: b */
        final /* synthetic */ String[] f34965b;

        /* renamed from: c */
        final /* synthetic */ boolean f34966c;

        a(String str, String[] strArr, boolean z) {
            this.f34964a = str;
            this.f34965b = strArr;
            this.f34966c = z;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                synchronized (b.this.f34959a) {
                    int b2 = b.this.b(this.f34964a);
                    Sensor defaultSensor = b.this.f34963e.getDefaultSensor(b2);
                    d cVar = this.f34964a.equals("gyroscope") ? new c(b.this.f34960b, this.f34964a, b2, defaultSensor, this.f34965b, b.this.f34963e) : this.f34964a.equals("accelerometer") ? new com.zk_oaction.adengine.lk_sensor.a(b.this.f34960b, this.f34964a, b2, defaultSensor, this.f34965b) : new d(b.this.f34960b, this.f34964a, b2, defaultSensor, this.f34965b);
                    if (b.this.f34963e != null && cVar.f34975c != null && !cVar.f34977e) {
                        if (this.f34966c) {
                            cVar.f34977e = true;
                            cVar.a();
                            b.this.f34963e.registerListener(b.this, cVar.f34975c, 2);
                        }
                        b.this.f34959a.put(this.f34964a, cVar);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public b(Context context, com.zk_oaction.adengine.lk_sdk.b bVar) {
        this.f34960b = bVar;
        this.f34961c = context;
        this.f34963e = (SensorManager) context.getSystemService(am.ac);
    }

    public int b(String str) {
        Integer num = this.f34962d.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private void i() {
        HashMap<String, Integer> hashMap = this.f34962d;
        if (hashMap == null || hashMap.size() <= 0) {
            this.f34962d = new HashMap<>();
            try {
                for (Field field : Sensor.class.getFields()) {
                    String name = field.getName();
                    if (name.startsWith("TYPE_")) {
                        try {
                            this.f34962d.put(name.substring(5).toLowerCase(Locale.US), Integer.valueOf(field.getInt(null)));
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public void d() {
        try {
            HashMap<String, d> hashMap = this.f34959a;
            if (hashMap == null || hashMap.size() <= 0) {
                return;
            }
            Iterator<Map.Entry<String, d>> it = this.f34959a.entrySet().iterator();
            while (it.hasNext()) {
                d value = it.next().getValue();
                if (this.f34963e != null && value != null && value.f34975c != null && !value.f34977e) {
                    value.f34977e = true;
                    value.a();
                    this.f34963e.registerListener(this, value.f34975c, 2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void e(String str, String[] strArr, boolean z) {
        try {
            i();
            if (this.f34963e == null) {
                this.f34963e = (SensorManager) this.f34961c.getSystemService(am.ac);
            }
            if (this.f34963e == null) {
                return;
            }
            new a(str, strArr, z).start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void g() {
        Sensor sensor;
        try {
            HashMap<String, d> hashMap = this.f34959a;
            if (hashMap == null || hashMap.size() <= 0) {
                return;
            }
            Iterator<Map.Entry<String, d>> it = this.f34959a.entrySet().iterator();
            while (it.hasNext()) {
                d value = it.next().getValue();
                SensorManager sensorManager = this.f34963e;
                if (sensorManager != null && value != null && (sensor = value.f34975c) != null && value.f34977e) {
                    value.f34977e = false;
                    sensorManager.unregisterListener(this, sensor);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void h() {
        try {
            HashMap<String, d> hashMap = this.f34959a;
            if (hashMap == null || hashMap.size() <= 0) {
                return;
            }
            this.f34959a.clear();
            this.f34959a = null;
        } catch (Throwable unused) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.f34960b == null) {
            return;
        }
        try {
            HashMap<String, d> hashMap = this.f34959a;
            if (hashMap == null || hashMap.size() <= 0) {
                return;
            }
            Iterator<Map.Entry<String, d>> it = this.f34959a.entrySet().iterator();
            while (it.hasNext()) {
                d value = it.next().getValue();
                if (value != null && sensorEvent.sensor.getType() == value.f34974b) {
                    value.b(sensorEvent);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
