package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.z;

/* loaded from: classes.dex */
class bg implements z.a {

    /* renamed from: c */
    final /* synthetic */ bf f5592c;

    bg(bf bfVar) {
        this.f5592c = bfVar;
    }

    @Override // com.baidu.mobads.sdk.internal.z.a
    public void onFailure() {
        this.f5592c.f5589i.a(bf.f5582b, "AbstractProdTemplate,load-dex请求，回调失败");
        this.f5592c.j();
    }

    @Override // com.baidu.mobads.sdk.internal.z.a
    public void onSuccess() {
        this.f5592c.f5589i.a(bf.f5582b, "AbstractProdTemplate,load-dex请求，回调成功");
        this.f5592c.i();
    }
}
