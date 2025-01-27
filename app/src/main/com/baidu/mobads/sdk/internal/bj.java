package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.aa;

/* loaded from: classes2.dex */
class bj implements aa.a {

    /* renamed from: c */
    final /* synthetic */ bi f6892c;

    public bj(bi biVar) {
        this.f6892c = biVar;
    }

    @Override // com.baidu.mobads.sdk.internal.aa.a
    public void onFailure() {
        this.f6892c.f6882k.a(bi.f6873b, "AbstractProdTemplate,load-dex请求，回调失败");
        this.f6892c.i();
    }

    @Override // com.baidu.mobads.sdk.internal.aa.a
    public void onSuccess() {
        this.f6892c.f6882k.a(bi.f6873b, "AbstractProdTemplate,load-dex请求，回调成功");
        this.f6892c.h();
    }
}
