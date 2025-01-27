package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* loaded from: classes4.dex */
public class a extends EventList {

    /* renamed from: a */
    private d f23362a;

    /* renamed from: b */
    private Object f23363b;

    public a(String str, String str2) {
        super(str, str2);
        this.f23363b = new Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    public void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.f23363b) {
            this.f23362a = null;
            this.f23362a = new d(false, this.mEventList);
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean a10;
        if (TextUtils.isEmpty(this.mEventList)) {
            return false;
        }
        synchronized (this.f23363b) {
            try {
                if (this.f23362a == null) {
                    this.f23362a = new d(false, this.mEventList);
                }
                a10 = this.f23362a.a(str);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return a10;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z10) {
        AnalyticsConfig.CLEAR_EKV_BL = z10;
    }
}
