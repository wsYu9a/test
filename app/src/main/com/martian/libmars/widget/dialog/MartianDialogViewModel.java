package com.martian.libmars.widget.dialog;

import androidx.lifecycle.ViewModel;
import com.kwad.sdk.m.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\bR\"\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/martian/libmars/widget/dialog/MartianDialogViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "Lcom/martian/libmars/widget/dialog/a;", "mBuilder", "", "c", "(Lcom/martian/libmars/widget/dialog/a;)V", "Lcom/martian/libmars/widget/dialog/b;", "d", "(Lcom/martian/libmars/widget/dialog/b;)V", "a", "Lcom/martian/libmars/widget/dialog/a;", "()Lcom/martian/libmars/widget/dialog/a;", e.TAG, "mBottomSheetDialogBuilder", "b", "Lcom/martian/libmars/widget/dialog/b;", "()Lcom/martian/libmars/widget/dialog/b;", "f", "mDialogBuilder", "libmars_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class MartianDialogViewModel extends ViewModel {

    /* renamed from: a, reason: from kotlin metadata */
    @k
    public a mBottomSheetDialogBuilder = new a();

    /* renamed from: b, reason: from kotlin metadata */
    @k
    public b mDialogBuilder = new b();

    @k
    /* renamed from: a, reason: from getter */
    public final a getMBottomSheetDialogBuilder() {
        return this.mBottomSheetDialogBuilder;
    }

    @k
    /* renamed from: b, reason: from getter */
    public final b getMDialogBuilder() {
        return this.mDialogBuilder;
    }

    public final void c(@l a mBuilder) {
        if (mBuilder != null) {
            this.mBottomSheetDialogBuilder = mBuilder;
        }
    }

    public final void d(@l b mBuilder) {
        if (mBuilder != null) {
            this.mDialogBuilder = mBuilder;
        }
    }

    public final void e(@k a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mBottomSheetDialogBuilder = aVar;
    }

    public final void f(@k b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mDialogBuilder = bVar;
    }
}
