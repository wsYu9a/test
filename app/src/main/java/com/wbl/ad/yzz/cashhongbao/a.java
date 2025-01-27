package com.wbl.ad.yzz.cashhongbao;

import android.os.Bundle;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.cashhongbao.d;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a extends com.wbl.ad.yzz.dialog.b {

    /* renamed from: a */
    @f.b.a.d
    public final d.a f31768a;

    /* renamed from: b */
    public d f31769b;

    /* renamed from: c */
    public d.b f31770c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@f.b.a.d d.a builder) {
        super(builder.getContext());
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f31768a = builder;
        this.f31770c = builder.c();
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15253, this, null);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15256, this, null);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15255, this, bundle);
    }

    @Override // android.app.Dialog
    public void onStop() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15250, this, null);
    }

    @Override // android.app.Dialog
    public void show() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15249, this, null);
    }
}
