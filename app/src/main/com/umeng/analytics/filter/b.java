package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* loaded from: classes4.dex */
public class b extends EventList {

    /* renamed from: a */
    private d f23364a;

    /* renamed from: b */
    private Object f23365b;

    public b(String str, String str2) {
        super(str, str2);
        this.f23365b = new Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    public void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.f23365b) {
            this.f23364a = null;
            this.f23364a = new d(true, this.mEventList);
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean a10;
        if (TextUtils.isEmpty(this.mEventList)) {
            return true;
        }
        synchronized (this.f23365b) {
            try {
                if (this.f23364a == null) {
                    this.f23364a = new d(true, this.mEventList);
                }
                a10 = this.f23364a.a(str);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return a10;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z10) {
        AnalyticsConfig.CLEAR_EKV_WL = z10;
    }
}
