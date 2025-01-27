package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;

/* loaded from: classes4.dex */
public class ah implements ac {

    /* renamed from: a */
    private String f23400a;

    /* renamed from: b */
    private long f23401b;

    public ah(String str, long j10) {
        this.f23400a = str;
        this.f23401b = j10;
    }

    @Override // com.umeng.analytics.pro.ac
    public boolean a() {
        try {
            String str = au.f23461b + this.f23400a;
            SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
            if (a10 == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() - a10.getLong(str, 0L);
            if (currentTimeMillis > this.f23401b * 1000) {
                return true;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "internal period skipped. elapse: " + currentTimeMillis + "; config: " + (this.f23401b * 1000));
            return false;
        } catch (Throwable unused) {
            return false;
        }
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
