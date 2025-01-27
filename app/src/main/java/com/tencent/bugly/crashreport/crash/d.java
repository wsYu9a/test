package com.tencent.bugly.crashreport.crash;

import com.tencent.bugly.proguard.P;
import com.tencent.bugly.proguard.qa;
import java.util.List;

/* loaded from: classes4.dex */
class d implements P {

    /* renamed from: a */
    final /* synthetic */ List f24838a;

    /* renamed from: b */
    final /* synthetic */ e f24839b;

    d(e eVar, List list) {
        this.f24839b = eVar;
        this.f24838a = list;
    }

    @Override // com.tencent.bugly.proguard.P
    public void a(int i2) {
    }

    @Override // com.tencent.bugly.proguard.P
    public void a(int i2, qa qaVar, long j2, long j3, boolean z, String str) {
        this.f24839b.a(z, this.f24838a);
    }
}
