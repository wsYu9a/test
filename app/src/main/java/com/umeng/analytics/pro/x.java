package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;

/* loaded from: classes4.dex */
class x implements w {

    /* renamed from: a */
    private long f26026a = AnalyticsConfig.kContinueSessionMillis;

    x() {
    }

    @Override // com.umeng.analytics.pro.w
    public void a(long j2) {
        this.f26026a = j2;
    }

    @Override // com.umeng.analytics.pro.w
    public long a() {
        return this.f26026a;
    }

    @Override // com.umeng.analytics.pro.w
    public String a(Context context) {
        String appkey = UMUtils.getAppkey(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (appkey != null) {
            return UMUtils.MD5(currentTimeMillis + appkey + "02:00:00:00:00:00");
        }
        throw new RuntimeException("Appkey is null or empty, Please check!");
    }

    @Override // com.umeng.analytics.pro.w
    public boolean a(long j2, long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        return (j2 == 0 || currentTimeMillis - j2 >= this.f26026a) && j3 > 0 && currentTimeMillis - j3 > this.f26026a;
    }

    @Override // com.umeng.analytics.pro.w
    public void a(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString("session_id", str);
            edit.putLong(u.f26010b, 0L);
            edit.putLong(u.f26013e, currentTimeMillis);
            edit.putLong(u.f26014f, 0L);
            edit.commit();
        } catch (Exception unused) {
        }
    }
}
