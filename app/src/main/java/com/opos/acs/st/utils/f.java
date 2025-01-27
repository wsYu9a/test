package com.opos.acs.st.utils;

import android.content.Context;
import com.umeng.analytics.AnalyticsConfig;
import java.lang.reflect.Field;
import java.util.TimerTask;

/* loaded from: classes4.dex */
public final class f extends TimerTask {

    /* renamed from: a */
    private long f16314a;

    /* renamed from: b */
    private long f16315b;

    /* renamed from: c */
    private long f16316c;

    /* renamed from: d */
    private Context f16317d;

    public f(Context context, long j2, long j3, long j4) {
        this.f16314a = 60000L;
        this.f16315b = 60000L;
        this.f16316c = 60000L;
        this.f16317d = context;
        this.f16314a = j2;
        this.f16315b = j3;
        this.f16316c = j4;
    }

    private void a(long j2) {
        a(TimerTask.class, this, AnalyticsConfig.RTD_PERIOD, Long.valueOf(j2));
    }

    private static boolean a(Class<?> cls, Object obj, String str, Object obj2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
            return true;
        } catch (Exception e2) {
            d.a("ReportTimerTask", "setDeclaredField!", e2);
            return false;
        }
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        long j2;
        d.a("ReportTimerTask", "schedule report task now!!!");
        Context context = this.f16317d;
        if (context != null) {
            if (!com.opos.cmn.an.h.c.a.d(context)) {
                d.a("ReportTimerTask", "schedule task no net!");
                return;
            }
            h.b(this.f16317d);
            long j3 = this.f16314a;
            if (j3 != 0) {
                long j4 = this.f16315b;
                if (j4 == 0 || j3 == j4) {
                    return;
                }
                if (h.d(this.f16317d) && this.f16316c == this.f16314a) {
                    a(this.f16315b);
                    j2 = this.f16315b;
                } else {
                    if (h.d(this.f16317d) || this.f16316c != this.f16315b) {
                        return;
                    }
                    a(this.f16314a);
                    j2 = this.f16314a;
                }
                this.f16316c = j2;
            }
        }
    }
}
