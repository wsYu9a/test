package com.opos.mobad.service.tasks;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.omes.scorpion.OmasStub;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes4.dex */
public class b implements SensorEventListener {

    /* renamed from: a */
    private CountDownLatch f23773a;

    /* renamed from: b */
    private Map<Integer, float[]> f23774b;

    public Map<Integer, float[]> a(Context context, int[] iArr, int i2) {
        return (Map) OmasStub.omasObject(25, new Object[]{this, context, iArr, Integer.valueOf(i2)});
    }

    public void a() {
        OmasStub.omasVoid(26, new Object[]{this});
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        OmasStub.omasVoid(27, new Object[]{this, sensor, Integer.valueOf(i2)});
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        OmasStub.omasVoid(28, new Object[]{this, sensorEvent});
    }
}
