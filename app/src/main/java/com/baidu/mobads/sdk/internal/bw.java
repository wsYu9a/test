package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.ci;

/* loaded from: classes2.dex */
class bw implements ci.a {

    /* renamed from: a */
    final /* synthetic */ bv f6973a;

    public bw(bv bvVar) {
        this.f6973a = bvVar;
    }

    @Override // com.baidu.mobads.sdk.internal.ci.a
    public void a(bx bxVar) {
        this.f6973a.a(bz.f6993k, bxVar, "download apk successfully, downloader exit");
        bv unused = bv.f6963h = null;
    }

    @Override // com.baidu.mobads.sdk.internal.ci.a
    public void b(bx bxVar) {
        this.f6973a.a(bz.f6994l, bxVar, "downloadApk failed");
    }
}
