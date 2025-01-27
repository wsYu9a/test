package com.wbl.ad.yzz.dialog;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class c extends TTDislikeDialogAbstract {

    /* renamed from: a */
    @f.b.a.e
    public a f31872a;

    public interface a {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@f.b.a.d Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14420, this, null);
    }

    public final void a(a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14419, this, aVar);
    }

    public void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14510, this, null);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public int getLayoutId() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14509, this, null);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public ViewGroup.LayoutParams getLayoutParams() {
        return (ViewGroup.LayoutParams) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14512, this, null);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public int[] getTTDislikeListViewIds() {
        return (int[]) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14511, this, null);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract, android.app.Dialog
    public void show() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14506, this, null);
    }
}
