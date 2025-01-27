package com.wbl.ad.yzz.bean;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class m extends h {

    /* renamed from: b */
    public final h f31582b;

    /* renamed from: c */
    public final j f31583c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@f.b.a.e j jVar, @f.b.a.d h customTTAppDownloadListenerProxy, @f.b.a.e TTAppDownloadListener tTAppDownloadListener) {
        super(tTAppDownloadListener);
        Intrinsics.checkNotNullParameter(customTTAppDownloadListenerProxy, "customTTAppDownloadListenerProxy");
        this.f31583c = jVar;
        this.f31582b = customTTAppDownloadListenerProxy;
    }

    @Override // com.wbl.ad.yzz.bean.h
    public void a(String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14955, this, str, str2);
    }

    @Override // com.wbl.ad.yzz.bean.g
    public boolean a() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14950, this, null);
    }

    @Override // com.wbl.ad.yzz.bean.h
    public String c() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14949, this, null);
    }

    @Override // com.wbl.ad.yzz.bean.h
    public boolean d() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14952, this, null);
    }

    @Override // com.wbl.ad.yzz.bean.h
    public void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14951, this, null);
    }
}
