package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.internal.bw;

/* loaded from: classes.dex */
class ab implements bw.c {

    /* renamed from: a */
    final /* synthetic */ z f5495a;

    ab(z zVar) {
        this.f5495a = zVar;
    }

    @Override // com.baidu.mobads.sdk.internal.bw.c
    public void a(boolean z) {
        IXAdContainerFactory iXAdContainerFactory;
        if (z) {
            try {
                bw bwVar = f.f5802a;
                if (bwVar != null) {
                    this.f5495a.f5936b = bwVar.i();
                    iXAdContainerFactory = this.f5495a.f5936b;
                    if (iXAdContainerFactory != null) {
                        this.f5495a.k();
                        return;
                    }
                }
            } catch (Exception unused) {
                this.f5495a.a("加载dex异常");
                return;
            }
        }
        f.f5802a = null;
        this.f5495a.a("加载dex失败");
    }
}
