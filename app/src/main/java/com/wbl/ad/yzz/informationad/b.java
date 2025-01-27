package com.wbl.ad.yzz.informationad;

import android.content.DialogInterface;
import android.os.Bundle;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.informationad.d;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b extends com.wbl.ad.yzz.dialog.b {

    /* renamed from: a */
    @f.b.a.d
    public final d.a f32767a;

    /* renamed from: b */
    public d f32768b;

    public static final class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12934, this, dialogInterface);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@f.b.a.d d.a builder) {
        super(builder.getContext());
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f32767a = builder;
    }

    public final d.a a() {
        return (d.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12933, this, null);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12936, this, null);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12935, this, null);
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12930, this, null);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12929, this, bundle);
    }

    @Override // android.app.Dialog
    public void onStop() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12932, this, null);
    }

    @Override // android.app.Dialog
    public void show() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12931, this, null);
    }
}
