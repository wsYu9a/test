package com.martian.mibook.mvvm.base;

import com.kuaishou.weapon.p0.t;
import com.umeng.analytics.pro.bt;
import kotlin.Metadata;
import lc.k;
import xi.l;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\"\u0010\u001e\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/martian/mibook/mvvm/base/DefaultViewModel;", "Lcom/martian/mibook/mvvm/base/BaseViewModel;", "Llc/k;", "<init>", "()V", "p", "()Llc/k;", "", "h", "Ljava/lang/Object;", "n", "()Ljava/lang/Object;", "s", "(Ljava/lang/Object;)V", "obj", "", "i", "I", "o", "()I", bt.aO, "(I)V", "what", "j", t.f11204d, "q", "arg1", "k", "m", t.f11211k, "arg2", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class DefaultViewModel extends BaseViewModel<k> {

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public Object obj;

    /* renamed from: i, reason: from kotlin metadata */
    public int what;

    /* renamed from: j, reason: from kotlin metadata */
    public int arg1;

    /* renamed from: k, reason: from kotlin metadata */
    public int arg2;

    /* renamed from: l, reason: from getter */
    public final int getArg1() {
        return this.arg1;
    }

    /* renamed from: m, reason: from getter */
    public final int getArg2() {
        return this.arg2;
    }

    @l
    /* renamed from: n, reason: from getter */
    public final Object getObj() {
        return this.obj;
    }

    /* renamed from: o, reason: from getter */
    public final int getWhat() {
        return this.what;
    }

    @Override // com.martian.mibook.mvvm.base.BaseViewModel
    @xi.k
    /* renamed from: p */
    public k i() {
        return new k();
    }

    public final void q(int i10) {
        this.arg1 = i10;
    }

    public final void r(int i10) {
        this.arg2 = i10;
    }

    public final void s(@l Object obj) {
        this.obj = obj;
    }

    public final void t(int i10) {
        this.what = i10;
    }
}
