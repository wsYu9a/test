package com.wbl.ad.yzz.sensor;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.sensor.SensorsDataMiniAPI;
import java.lang.Thread;

/* loaded from: classes5.dex */
public class l implements Thread.UncaughtExceptionHandler {

    /* renamed from: b */
    public static l f33825b;

    /* renamed from: a */
    public final Thread.UncaughtExceptionHandler f33826a = Thread.getDefaultUncaughtExceptionHandler();

    public class a implements SensorsDataMiniAPI.c {

        /* renamed from: a */
        public final /* synthetic */ Throwable f33827a;

        public a(l lVar, Throwable th) {
            this.f33827a = th;
        }

        @Override // com.wbl.ad.yzz.sensor.SensorsDataMiniAPI.c
        public void a(SensorsDataMiniAPI sensorsDataMiniAPI) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9773, this, sensorsDataMiniAPI);
        }
    }

    public class b implements SensorsDataMiniAPI.c {
        public b(l lVar) {
        }

        @Override // com.wbl.ad.yzz.sensor.SensorsDataMiniAPI.c
        public void a(SensorsDataMiniAPI sensorsDataMiniAPI) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9776, this, sensorsDataMiniAPI);
        }
    }

    public l() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9775, null, null);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9770, this, null);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9769, this, thread, th);
    }
}
