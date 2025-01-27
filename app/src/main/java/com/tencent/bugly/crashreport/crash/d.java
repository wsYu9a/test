package com.tencent.bugly.crashreport.crash;

import com.tencent.bugly.proguard.P;
import com.tencent.bugly.proguard.qa;
import java.util.List;

/* loaded from: classes4.dex */
public class d implements P {

    /* renamed from: a */
    final /* synthetic */ List f22445a;

    /* renamed from: b */
    final /* synthetic */ e f22446b;

    public d(e eVar, List list) {
        this.f22446b = eVar;
        this.f22445a = list;
    }

    @Override // com.tencent.bugly.proguard.P
    public void a(int i10) {
    }

    @Override // com.tencent.bugly.proguard.P
    public void a(int i10, qa qaVar, long j10, long j11, boolean z10, String str) {
        this.f22446b.a(z10, this.f22445a);
    }
}
