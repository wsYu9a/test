package com.martian.mibook.mvvm.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.kwad.sdk.m.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u0004\u0018\u00018\u0000H$¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00028\u0001H$¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00028\u0001H&¢\u0006\u0004\b\u001a\u0010\bJ\u0019\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00018\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0014\u0010\n\u001a\u00028\u00018DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\b¨\u0006#"}, d2 = {"Lcom/martian/mibook/mvvm/base/BaseFragment;", "Landroidx/viewbinding/ViewBinding;", "RVB", "VB", "Lcom/martian/mibook/mvvm/base/LazyFragment;", "<init>", "()V", "o", "()Landroidx/viewbinding/ViewBinding;", "rootViewBinding", "mViewBinding", "", "p", "(Landroidx/viewbinding/ViewBinding;Landroidx/viewbinding/ViewBinding;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "m", "q", "(Landroid/os/Bundle;)V", e.TAG, "Landroidx/viewbinding/ViewBinding;", "_mRootViewBinding", "f", "_viewBinding", "n", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public abstract class BaseFragment<RVB extends ViewBinding, VB extends ViewBinding> extends LazyFragment {

    /* renamed from: e */
    @l
    public RVB _mRootViewBinding;

    /* renamed from: f, reason: from kotlin metadata */
    @l
    public VB _viewBinding;

    @k
    public abstract VB m();

    @k
    public final VB n() {
        VB vb2 = this._viewBinding;
        if (vb2 != null) {
            return vb2;
        }
        throw new IllegalStateException(("Fragment " + this + " viewBinding cannot be accessed").toString());
    }

    @l
    public abstract RVB o();

    @Override // androidx.fragment.app.Fragment
    @l
    public View onCreateView(@k LayoutInflater inflater, @l ViewGroup container, @l Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._mRootViewBinding = o();
        this._viewBinding = m();
        RVB rvb = this._mRootViewBinding;
        if (rvb == null) {
            return n().getRoot();
        }
        p(rvb, n());
        RVB rvb2 = this._mRootViewBinding;
        if (rvb2 != null) {
            return rvb2.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@k View view, @l Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        q(savedInstanceState);
        super.onViewCreated(view, savedInstanceState);
    }

    public abstract void p(@l RVB rootViewBinding, @k VB mViewBinding);

    public abstract void q(@l Bundle savedInstanceState);
}
