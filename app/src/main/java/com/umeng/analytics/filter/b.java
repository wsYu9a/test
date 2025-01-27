package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* loaded from: classes4.dex */
public class b extends EventList {

    /* renamed from: a */
    private d f25605a;

    /* renamed from: b */
    private Object f25606b;

    public b(String str, String str2) {
        super(str, str2);
        this.f25606b = new Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    protected void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.f25606b) {
            this.f25605a = null;
            this.f25605a = new d(true, this.mEventList);
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean a2;
        if (TextUtils.isEmpty(this.mEventList)) {
            return true;
        }
        synchronized (this.f25606b) {
            if (this.f25605a == null) {
                this.f25605a = new d(true, this.mEventList);
            }
            a2 = this.f25605a.a(str);
        }
        return a2;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z) {
        AnalyticsConfig.CLEAR_EKV_WL = z;
    }
}
