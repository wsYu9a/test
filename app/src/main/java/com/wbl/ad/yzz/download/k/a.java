package com.wbl.ad.yzz.download.k;

import android.os.Bundle;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.download.k.b;
import f.b.a.d;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a extends com.wbl.ad.yzz.dialog.b {

    /* renamed from: a */
    @d
    public final b.a f32117a;

    /* renamed from: b */
    public b f32118b;

    /* renamed from: c */
    public b.InterfaceC0720b f32119c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@d b.a builder) {
        super(builder.getContext());
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f32117a = builder;
        this.f32119c = builder.c();
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13960, this, null);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13959, this, null);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13954, this, bundle);
    }

    @Override // android.app.Dialog
    public void onStop() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13953, this, null);
    }

    @Override // android.app.Dialog
    public void show() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13956, this, null);
    }
}
