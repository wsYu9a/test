package com.martian.libmars.widget.dialog;

import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a */
    @l
    public DialogInterface.OnCancelListener f12713a;

    /* renamed from: b */
    @l
    public DialogInterface.OnDismissListener f12714b;

    /* renamed from: c */
    @l
    public DialogInterface.OnKeyListener f12715c;

    /* renamed from: d */
    @l
    public DialogInterface.OnShowListener f12716d;

    /* renamed from: e */
    public boolean f12717e;

    /* renamed from: f */
    public int f12718f;

    /* renamed from: g */
    public int f12719g;

    /* renamed from: h */
    public int f12720h;

    /* renamed from: i */
    public int f12721i;

    /* renamed from: j */
    public boolean f12722j;

    /* renamed from: m */
    public boolean f12725m;

    /* renamed from: n */
    public int f12726n;

    /* renamed from: o */
    public boolean f12727o;

    /* renamed from: v */
    @l
    public MartianBottomSheetDialogFragment.b f12734v;

    /* renamed from: w */
    @l
    public WeakReference<View> f12735w;

    /* renamed from: x */
    public int f12736x;

    /* renamed from: y */
    public int f12737y;

    /* renamed from: k */
    public boolean f12723k = true;

    /* renamed from: l */
    public float f12724l = -1.0f;

    /* renamed from: p */
    public int f12728p = -1;

    /* renamed from: q */
    public int f12729q = 3;

    /* renamed from: r */
    public int f12730r = -1;

    /* renamed from: s */
    public boolean f12731s = true;

    /* renamed from: t */
    public boolean f12732t = true;

    /* renamed from: u */
    public boolean f12733u = true;

    public static /* synthetic */ MartianBottomSheetDialogFragment d0(a aVar, Fragment fragment, MartianBottomSheetDialogFragment martianBottomSheetDialogFragment, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            martianBottomSheetDialogFragment = new MartianBottomSheetDialogFragment();
        }
        return aVar.Z(fragment, martianBottomSheetDialogFragment, str);
    }

    public static /* synthetic */ MartianBottomSheetDialogFragment e0(a aVar, Fragment fragment, MartianBottomSheetDialogFragment martianBottomSheetDialogFragment, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            martianBottomSheetDialogFragment = new MartianBottomSheetDialogFragment();
        }
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        return aVar.a0(fragment, martianBottomSheetDialogFragment, str, z10);
    }

    public static /* synthetic */ MartianBottomSheetDialogFragment f0(a aVar, FragmentActivity fragmentActivity, MartianBottomSheetDialogFragment martianBottomSheetDialogFragment, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            martianBottomSheetDialogFragment = new MartianBottomSheetDialogFragment();
        }
        return aVar.b0(fragmentActivity, martianBottomSheetDialogFragment, str);
    }

    public static /* synthetic */ MartianBottomSheetDialogFragment g0(a aVar, FragmentActivity fragmentActivity, MartianBottomSheetDialogFragment martianBottomSheetDialogFragment, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            martianBottomSheetDialogFragment = new MartianBottomSheetDialogFragment();
        }
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        return aVar.c0(fragmentActivity, martianBottomSheetDialogFragment, str, z10);
    }

    public final void A(int i10) {
        this.f12729q = i10;
    }

    @k
    public final a A0(int i10) {
        this.f12718f = i10;
        return this;
    }

    public final void B(boolean z10) {
        this.f12722j = z10;
    }

    @k
    public final a B0(int i10) {
        this.f12720h = i10;
        return this;
    }

    public final void C(boolean z10) {
        this.f12727o = z10;
    }

    @k
    public final a C0(boolean z10) {
        this.f12717e = z10;
        return this;
    }

    public final void D(boolean z10) {
        this.f12723k = z10;
    }

    @k
    public final a D0(int i10) {
        this.f12719g = i10;
        return this;
    }

    public final void E(boolean z10) {
        this.f12733u = z10;
    }

    @k
    public final a E0(boolean z10) {
        this.f12725m = z10;
        return this;
    }

    public final void F(int i10) {
        this.f12730r = i10;
    }

    public final void G(boolean z10) {
        this.f12731s = z10;
    }

    public final void H(@l DialogInterface.OnCancelListener onCancelListener) {
        this.f12713a = onCancelListener;
    }

    public final void I(@l DialogInterface.OnDismissListener onDismissListener) {
        this.f12714b = onDismissListener;
    }

    public final void J(@l DialogInterface.OnKeyListener onKeyListener) {
        this.f12715c = onKeyListener;
    }

    public final void K(@l DialogInterface.OnShowListener onShowListener) {
        this.f12716d = onShowListener;
    }

    @k
    public final a L(@l DialogInterface.OnCancelListener onCancelListener) {
        this.f12713a = onCancelListener;
        return this;
    }

    public final void M(int i10) {
        this.f12737y = i10;
    }

    public final void N(int i10) {
        this.f12736x = i10;
    }

    public final void O(@l MartianBottomSheetDialogFragment.b bVar) {
        this.f12734v = bVar;
    }

    public final void P(int i10) {
        this.f12728p = i10;
    }

    public final void Q(boolean z10) {
        this.f12732t = z10;
    }

    public final void R(int i10) {
        this.f12726n = i10;
    }

    public final void S(int i10) {
        this.f12721i = i10;
    }

    public final void T(int i10) {
        this.f12718f = i10;
    }

    public final void U(int i10) {
        this.f12720h = i10;
    }

    public final void V(boolean z10) {
        this.f12717e = z10;
    }

    public final void W(int i10) {
        this.f12719g = i10;
    }

    public final void X(@l WeakReference<View> weakReference) {
        this.f12735w = weakReference;
    }

    public final void Y(boolean z10) {
        this.f12725m = z10;
    }

    @l
    public final MartianBottomSheetDialogFragment Z(@k Fragment parentFragment, @l MartianBottomSheetDialogFragment martianBottomSheetDialogFragment, @l String str) {
        Intrinsics.checkNotNullParameter(parentFragment, "parentFragment");
        return a0(parentFragment, martianBottomSheetDialogFragment, str, false);
    }

    public final float a() {
        return this.f12724l;
    }

    @l
    public final MartianBottomSheetDialogFragment a0(@k Fragment parentFragment, @l MartianBottomSheetDialogFragment martianBottomSheetDialogFragment, @l String str, boolean z10) {
        Intrinsics.checkNotNullParameter(parentFragment, "parentFragment");
        if (martianBottomSheetDialogFragment != null) {
            martianBottomSheetDialogFragment.w(this);
            FragmentManager childFragmentManager = parentFragment.getChildFragmentManager();
            if (z10) {
                if (!martianBottomSheetDialogFragment.isAdded()) {
                    childFragmentManager.beginTransaction().add(martianBottomSheetDialogFragment, str).commitAllowingStateLoss();
                }
            } else if (!childFragmentManager.isStateSaved() && !martianBottomSheetDialogFragment.isAdded()) {
                martianBottomSheetDialogFragment.show(childFragmentManager, str);
            }
        }
        return martianBottomSheetDialogFragment;
    }

    public final int b() {
        return this.f12729q;
    }

    @l
    public final MartianBottomSheetDialogFragment b0(@k FragmentActivity activity, @l MartianBottomSheetDialogFragment martianBottomSheetDialogFragment, @l String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return c0(activity, martianBottomSheetDialogFragment, str, false);
    }

    public final boolean c() {
        return this.f12722j;
    }

    @l
    public final MartianBottomSheetDialogFragment c0(@k FragmentActivity activity, @l MartianBottomSheetDialogFragment martianBottomSheetDialogFragment, @l String str, boolean z10) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (martianBottomSheetDialogFragment != null) {
            martianBottomSheetDialogFragment.w(this);
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            if (z10) {
                if (!martianBottomSheetDialogFragment.isAdded()) {
                    supportFragmentManager.beginTransaction().add(martianBottomSheetDialogFragment, str).commitAllowingStateLoss();
                }
            } else if (!supportFragmentManager.isStateSaved() && !martianBottomSheetDialogFragment.isAdded()) {
                martianBottomSheetDialogFragment.show(supportFragmentManager, str);
            }
        }
        return martianBottomSheetDialogFragment;
    }

    public final boolean d() {
        return this.f12727o;
    }

    public final boolean e() {
        return this.f12723k;
    }

    public final boolean f() {
        return this.f12733u;
    }

    public final int g() {
        return this.f12730r;
    }

    @l
    public final DialogInterface.OnCancelListener h() {
        return this.f12713a;
    }

    @k
    public final a h0(float f10) {
        this.f12724l = f10;
        return this;
    }

    @l
    public final DialogInterface.OnDismissListener i() {
        return this.f12714b;
    }

    @k
    public final a i0(int i10) {
        this.f12729q = i10;
        return this;
    }

    @l
    public final DialogInterface.OnKeyListener j() {
        return this.f12715c;
    }

    @k
    public final a j0(boolean z10) {
        this.f12722j = z10;
        return this;
    }

    @l
    public final DialogInterface.OnShowListener k() {
        return this.f12716d;
    }

    @k
    public final a k0(boolean z10) {
        this.f12727o = z10;
        return this;
    }

    public final int l() {
        return this.f12737y;
    }

    @k
    public final a l0(boolean z10) {
        this.f12723k = z10;
        return this;
    }

    public final int m() {
        return this.f12736x;
    }

    @k
    public final a m0(boolean z10) {
        this.f12733u = z10;
        return this;
    }

    @l
    public final MartianBottomSheetDialogFragment.b n() {
        return this.f12734v;
    }

    @k
    public final a n0(int i10) {
        this.f12730r = i10;
        return this;
    }

    public final int o() {
        return this.f12728p;
    }

    @k
    public final a o0(boolean z10) {
        this.f12731s = z10;
        return this;
    }

    public final int p() {
        return this.f12726n;
    }

    @k
    public final a p0(int i10) {
        this.f12737y = i10;
        return this;
    }

    public final int q() {
        return this.f12721i;
    }

    @k
    public final a q0(int i10) {
        this.f12736x = i10;
        return this;
    }

    public final int r() {
        return this.f12718f;
    }

    @k
    public final a r0(@l DialogInterface.OnDismissListener onDismissListener) {
        this.f12714b = onDismissListener;
        return this;
    }

    public final int s() {
        return this.f12720h;
    }

    @k
    public final a s0(@l MartianBottomSheetDialogFragment.b bVar) {
        this.f12734v = bVar;
        return this;
    }

    public final boolean t() {
        return this.f12717e;
    }

    @k
    public final a t0(@l DialogInterface.OnKeyListener onKeyListener) {
        this.f12715c = onKeyListener;
        return this;
    }

    public final int u() {
        return this.f12719g;
    }

    @k
    public final a u0(@l DialogInterface.OnShowListener onShowListener) {
        this.f12716d = onShowListener;
        return this;
    }

    @l
    public final WeakReference<View> v() {
        return this.f12735w;
    }

    @k
    public final a v0(int i10) {
        this.f12728p = i10;
        return this;
    }

    public final boolean w() {
        return this.f12725m;
    }

    @k
    public final a w0(boolean z10) {
        this.f12732t = z10;
        return this;
    }

    public final boolean x() {
        return this.f12731s;
    }

    @k
    public final a x0(int i10) {
        this.f12726n = i10;
        return this;
    }

    public final boolean y() {
        return this.f12732t;
    }

    @k
    public final a y0(@l View view) {
        this.f12735w = new WeakReference<>(view);
        return this;
    }

    public final void z(float f10) {
        this.f12724l = f10;
    }

    @k
    public final a z0(int i10) {
        this.f12721i = i10;
        return this;
    }
}
