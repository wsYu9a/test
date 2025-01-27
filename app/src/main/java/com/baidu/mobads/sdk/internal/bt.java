package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.cf;

/* loaded from: classes.dex */
class bt implements cf.a {

    /* renamed from: a */
    final /* synthetic */ bs f5658a;

    bt(bs bsVar) {
        this.f5658a = bsVar;
    }

    @Override // com.baidu.mobads.sdk.internal.cf.a
    public void a(bu buVar) {
        this.f5658a.a(bw.k, buVar, "download apk successfully, downloader exit");
        bs unused = bs.f5650h = null;
    }

    @Override // com.baidu.mobads.sdk.internal.cf.a
    public void b(bu buVar) {
        this.f5658a.a(bw.l, buVar, "downloadApk failed");
    }
}
