package com.tencent.bugly.crashreport.biz;

import com.tencent.bugly.proguard.P;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.qa;
import java.util.List;

/* loaded from: classes4.dex */
public class a implements P {

    /* renamed from: a */
    final /* synthetic */ List f22248a;

    /* renamed from: b */
    final /* synthetic */ c f22249b;

    public a(c cVar, List list) {
        this.f22249b = cVar;
        this.f22248a = list;
    }

    @Override // com.tencent.bugly.proguard.P
    public void a(int i10) {
    }

    @Override // com.tencent.bugly.proguard.P
    public void a(int i10, qa qaVar, long j10, long j11, boolean z10, String str) {
        if (z10) {
            X.a("[UserInfo] Successfully uploaded user info.", new Object[0]);
            long currentTimeMillis = System.currentTimeMillis();
            for (UserInfoBean userInfoBean : this.f22248a) {
                userInfoBean.f22234f = currentTimeMillis;
                this.f22249b.a(userInfoBean, true);
            }
        }
    }
}
