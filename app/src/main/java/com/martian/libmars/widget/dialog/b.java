package com.martian.libmars.widget.dialog;

import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.martian.libmars.R;
import com.martian.libmars.widget.dialog.MartianDialogFragment;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a */
    @l
    public DialogInterface.OnCancelListener f12738a;

    /* renamed from: b */
    @l
    public DialogInterface.OnDismissListener f12739b;

    /* renamed from: c */
    @l
    public DialogInterface.OnKeyListener f12740c;

    /* renamed from: d */
    @l
    public DialogInterface.OnShowListener f12741d;

    /* renamed from: e */
    public boolean f12742e;

    /* renamed from: f */
    public int f12743f;

    /* renamed from: g */
    public int f12744g;

    /* renamed from: h */
    public int f12745h;

    /* renamed from: i */
    public int f12746i;

    /* renamed from: j */
    public boolean f12747j;

    /* renamed from: k */
    public boolean f12748k;

    /* renamed from: l */
    public int f12749l = R.style.MartianDialogFragment_Dialog;

    /* renamed from: m */
    @l
    public MartianDialogFragment.b f12750m;

    /* renamed from: n */
    @l
    public WeakReference<View> f12751n;

    public static /* synthetic */ MartianDialogFragment G(b bVar, Fragment fragment, MartianDialogFragment martianDialogFragment, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            martianDialogFragment = new MartianDialogFragment();
        }
        if ((i10 & 4) != 0) {
            str = "MartianDialog";
        }
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        return bVar.D(fragment, martianDialogFragment, str, z10);
    }

    public static /* synthetic */ MartianDialogFragment H(b bVar, FragmentActivity fragmentActivity, MartianDialogFragment martianDialogFragment, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            martianDialogFragment = new MartianDialogFragment();
        }
        if ((i10 & 4) != 0) {
            str = "MartianDialog";
        }
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        return bVar.F(fragmentActivity, martianDialogFragment, str, z10);
    }

    public final void A(int i10) {
        this.f12744g = i10;
    }

    public final void B(@l WeakReference<View> weakReference) {
        this.f12751n = weakReference;
    }

    @l
    public final MartianDialogFragment C(@k Fragment parentFragment) {
        Intrinsics.checkNotNullParameter(parentFragment, "parentFragment");
        return G(this, parentFragment, new MartianDialogFragment(), "MartianDialog", false, 8, null);
    }

    @l
    public final MartianDialogFragment D(@k Fragment parentFragment, @l MartianDialogFragment martianDialogFragment, @l String str, boolean z10) {
        Intrinsics.checkNotNullParameter(parentFragment, "parentFragment");
        if (martianDialogFragment != null) {
            martianDialogFragment.p(this);
            FragmentManager childFragmentManager = parentFragment.getChildFragmentManager();
            if (z10) {
                if (!martianDialogFragment.isAdded()) {
                    childFragmentManager.beginTransaction().add(martianDialogFragment, str).commitAllowingStateLoss();
                }
            } else if (!childFragmentManager.isStateSaved() && !martianDialogFragment.isAdded()) {
                martianDialogFragment.show(childFragmentManager, str);
            }
        }
        return martianDialogFragment;
    }

    @l
    public final MartianDialogFragment E(@k FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return H(this, activity, new MartianDialogFragment(), "MartianDialog", false, 8, null);
    }

    @l
    public final MartianDialogFragment F(@k FragmentActivity activity, @l MartianDialogFragment martianDialogFragment, @l String str, boolean z10) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (martianDialogFragment != null) {
            martianDialogFragment.p(this);
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            if (z10) {
                if (!martianDialogFragment.isAdded()) {
                    supportFragmentManager.beginTransaction().add(martianDialogFragment, str).commitAllowingStateLoss();
                }
            } else if (!supportFragmentManager.isStateSaved() && !martianDialogFragment.isAdded()) {
                martianDialogFragment.show(supportFragmentManager, str);
            }
        }
        return martianDialogFragment;
    }

    @k
    public final b I(boolean z10) {
        this.f12747j = z10;
        return this;
    }

    @k
    public final b J(boolean z10) {
        this.f12748k = z10;
        return this;
    }

    @k
    public final b K(@l DialogInterface.OnCancelListener onCancelListener) {
        this.f12738a = onCancelListener;
        return this;
    }

    @k
    public final b L(@l DialogInterface.OnDismissListener onDismissListener) {
        this.f12739b = onDismissListener;
        return this;
    }

    @k
    public final b M(@l MartianDialogFragment.b bVar) {
        this.f12750m = bVar;
        return this;
    }

    @k
    public final b N(@l DialogInterface.OnKeyListener onKeyListener) {
        this.f12740c = onKeyListener;
        return this;
    }

    @k
    public final b O(@l DialogInterface.OnShowListener onShowListener) {
        this.f12741d = onShowListener;
        return this;
    }

    @k
    public final b P(int i10) {
        this.f12749l = i10;
        return this;
    }

    @k
    public final b Q(@l View view) {
        this.f12751n = new WeakReference<>(view);
        return this;
    }

    @k
    public final b R(int i10) {
        this.f12746i = i10;
        return this;
    }

    @k
    public final b S(int i10) {
        this.f12743f = i10;
        return this;
    }

    @k
    public final b T(int i10) {
        this.f12745h = i10;
        return this;
    }

    @k
    public final b U(boolean z10) {
        this.f12742e = z10;
        return this;
    }

    @k
    public final b V(int i10) {
        this.f12744g = i10;
        return this;
    }

    public final boolean a() {
        return this.f12747j;
    }

    public final boolean b() {
        return this.f12748k;
    }

    @l
    public final DialogInterface.OnCancelListener c() {
        return this.f12738a;
    }

    @l
    public final DialogInterface.OnDismissListener d() {
        return this.f12739b;
    }

    @l
    public final DialogInterface.OnKeyListener e() {
        return this.f12740c;
    }

    @l
    public final DialogInterface.OnShowListener f() {
        return this.f12741d;
    }

    @l
    public final MartianDialogFragment.b g() {
        return this.f12750m;
    }

    public final int h() {
        return this.f12749l;
    }

    public final int i() {
        return this.f12746i;
    }

    public final int j() {
        return this.f12743f;
    }

    public final int k() {
        return this.f12745h;
    }

    public final boolean l() {
        return this.f12742e;
    }

    public final int m() {
        return this.f12744g;
    }

    @l
    public final WeakReference<View> n() {
        return this.f12751n;
    }

    public final void o(boolean z10) {
        this.f12747j = z10;
    }

    public final void p(boolean z10) {
        this.f12748k = z10;
    }

    public final void q(@l DialogInterface.OnCancelListener onCancelListener) {
        this.f12738a = onCancelListener;
    }

    public final void r(@l DialogInterface.OnDismissListener onDismissListener) {
        this.f12739b = onDismissListener;
    }

    public final void s(@l DialogInterface.OnKeyListener onKeyListener) {
        this.f12740c = onKeyListener;
    }

    public final void t(@l DialogInterface.OnShowListener onShowListener) {
        this.f12741d = onShowListener;
    }

    public final void u(@l MartianDialogFragment.b bVar) {
        this.f12750m = bVar;
    }

    public final void v(int i10) {
        this.f12749l = i10;
    }

    public final void w(int i10) {
        this.f12746i = i10;
    }

    public final void x(int i10) {
        this.f12743f = i10;
    }

    public final void y(int i10) {
        this.f12745h = i10;
    }

    public final void z(boolean z10) {
        this.f12742e = z10;
    }
}
