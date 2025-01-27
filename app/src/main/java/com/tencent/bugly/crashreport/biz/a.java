package com.tencent.bugly.crashreport.biz;

import com.tencent.bugly.proguard.P;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.qa;
import java.util.List;

/* loaded from: classes4.dex */
class a implements P {

    /* renamed from: a */
    final /* synthetic */ List f24717a;

    /* renamed from: b */
    final /* synthetic */ c f24718b;

    a(c cVar, List list) {
        this.f24718b = cVar;
        this.f24717a = list;
    }

    @Override // com.tencent.bugly.proguard.P
    public void a(int i2) {
    }

    @Override // com.tencent.bugly.proguard.P
    public void a(int i2, qa qaVar, long j2, long j3, boolean z, String str) {
        if (z) {
            X.a("[UserInfo] Successfully uploaded user info.", new Object[0]);
            long currentTimeMillis = System.currentTimeMillis();
            for (UserInfoBean userInfoBean : this.f24717a) {
                userInfoBean.f24712f = currentTimeMillis;
                this.f24718b.a(userInfoBean, true);
            }
        }
    }
}
