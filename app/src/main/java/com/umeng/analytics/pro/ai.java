package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;

/* loaded from: classes4.dex */
public class ai implements ac {

    /* renamed from: a */
    private int f23402a;

    public ai(int i10) {
        this.f23402a = i10;
    }

    @Override // com.umeng.analytics.pro.ac
    public boolean a() {
        long j10 = 0;
        try {
            SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
            if (a10 != null) {
                j10 = a10.getLong(au.f23460a, 0L);
                if (j10 >= this.f23402a) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "launch times skipped. times: " + j10 + " ; config: " + this.f23402a);
        return false;
    }

    @Override // com.umeng.analytics.pro.ac
    public boolean b() {
        return !a();
    }

    @Override // com.umeng.analytics.pro.ac
    public long c() {
        return 0L;
    }
}
