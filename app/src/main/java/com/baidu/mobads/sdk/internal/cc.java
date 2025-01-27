package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.cn;

/* loaded from: classes2.dex */
class cc implements cn.a {

    /* renamed from: a */
    final /* synthetic */ bz f7015a;

    public cc(bz bzVar) {
        this.f7015a = bzVar;
    }

    @Override // com.baidu.mobads.sdk.internal.cn.a
    public void a(String str) {
        try {
            this.f7015a.b();
            this.f7015a.a(str);
        } catch (Throwable th2) {
            bt.a().a(th2);
        }
    }
}
