package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.internal.bz;

/* loaded from: classes2.dex */
class ac implements bz.c {

    /* renamed from: a */
    final /* synthetic */ aa f6703a;

    public ac(aa aaVar) {
        this.f6703a = aaVar;
    }

    @Override // com.baidu.mobads.sdk.internal.bz.c
    public void a(boolean z10) {
        IXAdContainerFactory iXAdContainerFactory;
        if (z10) {
            try {
                bz bzVar = h.f7186a;
                if (bzVar != null) {
                    this.f6703a.f6691b = bzVar.i();
                    iXAdContainerFactory = this.f6703a.f6691b;
                    if (iXAdContainerFactory != null) {
                        this.f6703a.k();
                        return;
                    }
                }
            } catch (Exception unused) {
                this.f6703a.a("加载dex异常");
                return;
            }
        }
        h.f7186a = null;
        this.f6703a.a("加载dex失败");
    }
}
