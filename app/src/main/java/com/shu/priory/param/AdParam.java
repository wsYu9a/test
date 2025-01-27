package com.shu.priory.param;

import com.shu.priory.config.AdKeys;
import com.sigmob.windad.WindAds;
import com.umeng.analytics.pro.by;

/* loaded from: classes3.dex */
public class AdParam {

    /* renamed from: a */
    private final String f17171a;

    /* renamed from: b */
    private final e f17172b = new e();

    public AdParam(String str) {
        this.f17171a = str;
        a();
    }

    private void a() {
        Boolean bool = Boolean.FALSE;
        setParameter(AdKeys.DEBUG_MODE, bool);
        Boolean bool2 = Boolean.TRUE;
        setParameter(AdKeys.BACK_KEY_ENABLE, bool2);
        setParameter(AdKeys.DOWNLOAD_ALERT, bool);
        setParameter(AdKeys.HTTP_REQUEST_TIMEOUT, Integer.valueOf(by.f23697b));
        setParameter(AdKeys.LOCK_SCREEN_AD, bool);
        setParameter(AdKeys.BANNER_RECYCLE, bool);
        setParameter(AdKeys.BANNER_INTERVAL, 30);
        setParameter(AdKeys.REQUEST_ID, b());
        setParameter(AdKeys.CURRENCY, WindAds.CNY);
        setParameter(AdKeys.IS_SHAKING_ALLOWED, bool2);
        setParameter(AdKeys.IS_LOCATION_ALLOWED, bool2);
        setParameter(AdKeys.IS_IMEI_ALLOWED, bool2);
        setParameter(AdKeys.IS_ANDROID_ID_ALLOWED, bool2);
        setAdUnitId(this.f17171a);
    }

    private String b() {
        return "AD_" + System.currentTimeMillis();
    }

    public int getAdHeight() {
        return ((Integer) this.f17172b.a("adh")).intValue();
    }

    public String getAdUnitId() {
        return (String) this.f17172b.a("adunit_id");
    }

    public int getAdWidth() {
        return ((Integer) this.f17172b.a("adw")).intValue();
    }

    public boolean getBooleanParam(String str) {
        try {
            return ((Boolean) this.f17172b.a(str)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public double getDoubleParam(String str) {
        try {
            return this.f17172b.a(str) != null ? ((Double) this.f17172b.a(str)).doubleValue() : l5.c.f27899e;
        } catch (Throwable unused) {
            return l5.c.f27899e;
        }
    }

    public int getIntParam(String str) {
        try {
            return ((Integer) this.f17172b.a(str)).intValue();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public Object getParameter(String str) {
        return this.f17172b.a(str);
    }

    public String getStringParam(String str) {
        try {
            return (String) this.f17172b.a(str);
        } catch (Throwable unused) {
            return "";
        }
    }

    public boolean hasParam(String str) {
        try {
            return this.f17172b.b(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public void setAdHeight(int i10) {
        this.f17172b.a("adh", Integer.valueOf(i10));
    }

    public void setAdUnitId(String str) {
        this.f17172b.a("adunit_id", str);
    }

    public void setAdWidth(int i10) {
        this.f17172b.a("adw", Integer.valueOf(i10));
    }

    public void setParameter(String str, Object obj) {
        this.f17172b.a(str, obj);
    }
}
