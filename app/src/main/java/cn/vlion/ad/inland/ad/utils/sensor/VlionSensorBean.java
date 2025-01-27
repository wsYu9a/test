package cn.vlion.ad.inland.ad.utils.sensor;

import cn.vlion.ad.inland.ad.utils.sensor.SensorManagerManager;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public class VlionSensorBean {

    /* renamed from: a */
    public int f2393a;

    /* renamed from: b */
    public int f2394b;

    /* renamed from: c */
    public float f2395c;

    /* renamed from: d */
    public SensorManagerManager.OnShakeListener f2396d;

    public VlionSensorBean(int i10, int i11, float f10, SensorManagerManager.OnShakeListener onShakeListener) {
        this.f2393a = i10;
        this.f2394b = i11;
        this.f2395c = f10;
        this.f2396d = onShakeListener;
    }

    public final String toString() {
        try {
            return "VlionSensorBean{shakeSpeed=" + this.f2393a + ", shakeDegrees=" + this.f2394b + ", shakeTime=" + this.f2395c + ", shakeListener=" + this.f2396d + '}';
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return "";
        }
    }
}
