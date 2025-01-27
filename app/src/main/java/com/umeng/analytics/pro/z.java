package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;

/* loaded from: classes4.dex */
class z implements y {

    /* renamed from: a */
    private long f24178a = AnalyticsConfig.kContinueSessionMillis;

    @Override // com.umeng.analytics.pro.y
    public void a(long j10) {
        this.f24178a = j10;
    }

    @Override // com.umeng.analytics.pro.y
    public long a() {
        return this.f24178a;
    }

    @Override // com.umeng.analytics.pro.y
    public String a(Context context) {
        String appkey = UMUtils.getAppkey(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (appkey != null) {
            return UMUtils.MD5(currentTimeMillis + appkey + "02:00:00:00:00:00");
        }
        throw new RuntimeException("Appkey is null or empty, Please check!");
    }

    @Override // com.umeng.analytics.pro.y
    public boolean a(long j10, long j11) {
        long currentTimeMillis = System.currentTimeMillis();
        return (j10 == 0 || currentTimeMillis - j10 >= this.f24178a) && j11 > 0 && currentTimeMillis - j11 > this.f24178a;
    }

    @Override // com.umeng.analytics.pro.y
    public void a(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString("session_id", str);
            edit.putLong(w.f24159b, 0L);
            edit.putLong(w.f24162e, currentTimeMillis);
            edit.putLong(w.f24163f, 0L);
            edit.commit();
        } catch (Exception unused) {
        }
    }
}
