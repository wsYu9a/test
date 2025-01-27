package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* loaded from: classes4.dex */
public class a extends EventList {

    /* renamed from: a */
    private d f25603a;

    /* renamed from: b */
    private Object f25604b;

    public a(String str, String str2) {
        super(str, str2);
        this.f25604b = new Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    protected void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.f25604b) {
            this.f25603a = null;
            this.f25603a = new d(false, this.mEventList);
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean a2;
        if (TextUtils.isEmpty(this.mEventList)) {
            return false;
        }
        synchronized (this.f25604b) {
            if (this.f25603a == null) {
                this.f25603a = new d(false, this.mEventList);
            }
            a2 = this.f25603a.a(str);
        }
        return a2;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z) {
        AnalyticsConfig.CLEAR_EKV_BL = z;
    }
}
