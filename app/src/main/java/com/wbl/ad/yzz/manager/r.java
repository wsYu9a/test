package com.wbl.ad.yzz.manager;

import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.hardware.TriggerEvent;
import android.hardware.TriggerEventListener;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public final class r extends TriggerEventListener {

    /* renamed from: a */
    public static SensorManager f32985a;

    /* renamed from: b */
    @f.b.a.d
    public static final r f32986b = new r();

    public static final class a implements SensorListener {
        @Override // android.hardware.SensorListener
        public void onAccuracyChanged(int i2, int i3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12574, this, Integer.valueOf(i2), Integer.valueOf(i3));
        }

        @Override // android.hardware.SensorListener
        public void onSensorChanged(int i2, float[] fArr) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12573, this, Integer.valueOf(i2), fArr);
        }
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12576, this, null);
    }

    @Override // android.hardware.TriggerEventListener
    public void onTrigger(TriggerEvent triggerEvent) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12575, this, triggerEvent);
    }
}
