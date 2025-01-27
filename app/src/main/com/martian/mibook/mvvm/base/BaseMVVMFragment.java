package com.martian.mibook.mvvm.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.databinding.LibmarsStrfragmentBinding;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.mvvm.base.BaseMVVMFragment;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lc.b;
import r3.d;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\f\b\u0001\u0010\u0004*\u0006\u0012\u0002\b\u00030\u00032\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0007J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0014¢\u0006\u0004\b\u0016\u0010\u000eJ!\u0010\u0019\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0018\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001b\u0010\u0007J\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u0007J\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u001dH\u0014¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u001dH\u0014¢\u0006\u0004\b\"\u0010#J#\u0010&\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u001d2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$H\u0014¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u001dH\u0016¢\u0006\u0004\b)\u0010#J\u0017\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u001dH\u0016¢\u0006\u0004\b+\u0010#J\u0017\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J%\u00102\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u0001002\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b2\u00103J\u001b\u00104\u001a\u00020\b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b4\u00105J%\u00108\u001a\u00020\b2\b\u00107\u001a\u0004\u0018\u0001062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b8\u00109J%\u0010;\u001a\u00020\b2\b\u0010:\u001a\u0004\u0018\u0001002\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b;\u00103J\u000f\u0010<\u001a\u00020,H\u0007¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\bH&¢\u0006\u0004\b>\u0010\u0007R$\u0010F\u001a\u0004\u0018\u00010?8\u0014@\u0014X\u0094\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001b\u0010K\u001a\u00028\u00018VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u001d\u0010P\u001a\u0004\u0018\u00010L8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bM\u0010H\u001a\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010\"¨\u0006S"}, d2 = {"Lcom/martian/mibook/mvvm/base/BaseMVVMFragment;", "Landroidx/viewbinding/ViewBinding;", "VB", "Lcom/martian/mibook/mvvm/base/BaseViewModel;", "VM", "Lcom/martian/mibook/mvvm/base/BaseFragment;", "<init>", "()V", "", IAdInterListener.AdReqParam.WIDTH, "Ljava/lang/Class;", "M", "()Ljava/lang/Class;", "m", "()Landroidx/viewbinding/ViewBinding;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "y", "o", "rootViewBinding", "mViewBinding", "p", "(Landroidx/viewbinding/ViewBinding;Landroidx/viewbinding/ViewBinding;)V", "Y", "d0", "", "B", "()Z", "C", "loading", "Z", "(Z)V", "Lcom/martian/libmars/widget/recyclerview/LoadingTip;", "loadingTip", "g0", "(ZLcom/martian/libmars/widget/recyclerview/LoadingTip;)V", d.f30256x, "f0", "enable", "e0", "", "color", "b0", "(I)V", "", "tips", ExifInterface.LONGITUDE_WEST, "(Ljava/lang/String;Lcom/martian/libmars/widget/recyclerview/LoadingTip;)V", ExifInterface.GPS_DIRECTION_TRUE, "(Lcom/martian/libmars/widget/recyclerview/LoadingTip;)V", "Lcom/martian/mibook/mvvm/net/ErrorResult;", "errorResult", "Q", "(Lcom/martian/mibook/mvvm/net/ErrorResult;Lcom/martian/libmars/widget/recyclerview/LoadingTip;)V", "title", "O", "K", "()I", "i0", "Lcom/martian/libmars/databinding/LibmarsStrfragmentBinding;", "g", "Lcom/martian/libmars/databinding/LibmarsStrfragmentBinding;", "H", "()Lcom/martian/libmars/databinding/LibmarsStrfragmentBinding;", "a0", "(Lcom/martian/libmars/databinding/LibmarsStrfragmentBinding;)V", "mRootViewBinding", "h", "Lkotlin/Lazy;", "I", "()Lcom/martian/mibook/mvvm/base/BaseViewModel;", "mViewModel", "Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "i", "G", "()Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "appViewModel", "j", "isLoading", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public abstract class BaseMVVMFragment<VB extends ViewBinding, VM extends BaseViewModel<?>> extends BaseFragment<ViewBinding, VB> {

    /* renamed from: g, reason: from kotlin metadata */
    @l
    public LibmarsStrfragmentBinding mRootViewBinding;

    /* renamed from: h, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel = LazyKt.lazy(new Function0<VM>(this) { // from class: com.martian.mibook.mvvm.base.BaseMVVMFragment$mViewModel$2
        final /* synthetic */ BaseMVVMFragment<VB, VM> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseMVVMFragment$mViewModel$2(BaseMVVMFragment<VB, VM> this) {
            super(0);
            this.this$0 = this;
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final BaseViewModel invoke() {
            return (BaseViewModel) new ViewModelProvider(this.this$0).get(this.this$0.M());
        }
    });

    /* renamed from: i, reason: from kotlin metadata */
    @k
    public final Lazy appViewModel = LazyKt.lazy(new Function0<AppViewModel>(this) { // from class: com.martian.mibook.mvvm.base.BaseMVVMFragment$appViewModel$2
        final /* synthetic */ BaseMVVMFragment<VB, VM> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseMVVMFragment$appViewModel$2(BaseMVVMFragment<VB, VM> this) {
            super(0);
            this.this$0 = this;
        }

        @Override // kotlin.jvm.functions.Function0
        @l
        public final AppViewModel invoke() {
            return b.a(this.this$0.getContext());
        }
    });

    /* renamed from: j, reason: from kotlin metadata */
    public boolean isLoading;

    public static final void A(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void N(BaseMVVMFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Y();
    }

    public static /* synthetic */ void P(BaseMVVMFragment baseMVVMFragment, String str, LoadingTip loadingTip, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadingTipEmpty");
        }
        if ((i10 & 2) != 0) {
            loadingTip = null;
        }
        baseMVVMFragment.O(str, loadingTip);
    }

    public static /* synthetic */ void R(BaseMVVMFragment baseMVVMFragment, ErrorResult errorResult, LoadingTip loadingTip, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadingTipError");
        }
        if ((i10 & 2) != 0) {
            loadingTip = null;
        }
        baseMVVMFragment.Q(errorResult, loadingTip);
    }

    public static final void S(ErrorResult errorResult, LoadingTip this_apply) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (errorResult.getErrorCode() == -100002) {
            this_apply.setLoadingTip(LoadingTip.LoadStatus.network_error);
        } else {
            this_apply.setLoadingTip(LoadingTip.LoadStatus.serverError);
        }
        if (ba.l.q(errorResult.getErrorMsg()) || errorResult.getErrorMsg().length() >= 20) {
            return;
        }
        this_apply.setTips(ExtKt.c(errorResult.getErrorMsg()));
    }

    public static /* synthetic */ void U(BaseMVVMFragment baseMVVMFragment, LoadingTip loadingTip, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadingTipFinish");
        }
        if ((i10 & 1) != 0) {
            loadingTip = null;
        }
        baseMVVMFragment.T(loadingTip);
    }

    public static /* synthetic */ void X(BaseMVVMFragment baseMVVMFragment, String str, LoadingTip loadingTip, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadingTipLoading");
        }
        if ((i10 & 2) != 0) {
            loadingTip = null;
        }
        baseMVVMFragment.W(str, loadingTip);
    }

    public static /* synthetic */ void h0(BaseMVVMFragment baseMVVMFragment, boolean z10, LoadingTip loadingTip, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTipLoading");
        }
        if ((i10 & 2) != 0) {
            loadingTip = null;
        }
        baseMVVMFragment.g0(z10, loadingTip);
    }

    private final void w() {
        MutableLiveData<Unit> h02;
        AppViewModel G = G();
        if (G != null && (h02 = G.h0()) != null) {
            h02.observe(getViewLifecycleOwner(), new Observer() { // from class: lc.h
                public /* synthetic */ h() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BaseMVVMFragment.x(Function1.this, obj);
                }
            });
        }
        i0();
    }

    public static final void x(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void z(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public boolean B() {
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        return true;
    }

    /* renamed from: C, reason: from getter */
    public boolean getIsLoading() {
        return this.isLoading;
    }

    @l
    public AppViewModel G() {
        return (AppViewModel) this.appViewModel.getValue();
    }

    @l
    /* renamed from: H, reason: from getter */
    public LibmarsStrfragmentBinding getMRootViewBinding() {
        return this.mRootViewBinding;
    }

    @k
    public VM I() {
        return (VM) this.mViewModel.getValue();
    }

    @SuppressLint({"DiscouragedApi", "InternalInsetResource"})
    public final int K() {
        int identifier = getResources().getIdentifier(com.gyf.immersionbar.b.f10638c, "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @k
    public Class<VM> M() {
        Type[] actualTypeArguments;
        Type genericSuperclass = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = genericSuperclass instanceof ParameterizedType ? (ParameterizedType) genericSuperclass : null;
        Object obj = (parameterizedType == null || (actualTypeArguments = parameterizedType.getActualTypeArguments()) == null) ? null : (Type) ArraysKt.getOrNull(actualTypeArguments, 1);
        Class<VM> cls = obj instanceof Class ? (Class) obj : null;
        if (cls != null) {
            return cls;
        }
        throw new IllegalStateException("Unable to determine ViewModel class.");
    }

    public void O(@l String title, @l LoadingTip loadingTip) {
        if (getActivity() == null) {
            return;
        }
        if (loadingTip == null) {
            LibmarsStrfragmentBinding mRootViewBinding = getMRootViewBinding();
            loadingTip = mRootViewBinding != null ? mRootViewBinding.f12303e : null;
        }
        if (loadingTip != null) {
            loadingTip.setLoadingTip(LoadingTip.LoadStatus.empty);
            if (ba.l.q(title)) {
                return;
            }
            loadingTip.setTips(title != null ? ExtKt.c(title) : null);
        }
    }

    public void Q(@l ErrorResult errorResult, @l LoadingTip loadingTip) {
        if (getActivity() == null || errorResult == null) {
            return;
        }
        if (loadingTip == null) {
            LibmarsStrfragmentBinding mRootViewBinding = getMRootViewBinding();
            loadingTip = mRootViewBinding != null ? mRootViewBinding.f12303e : null;
        }
        if (loadingTip != null) {
            loadingTip.post(new Runnable() { // from class: lc.i

                /* renamed from: c */
                public final /* synthetic */ LoadingTip f28091c;

                public /* synthetic */ i(LoadingTip loadingTip2) {
                    loadingTip = loadingTip2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    BaseMVVMFragment.S(ErrorResult.this, loadingTip);
                }
            });
        }
    }

    public void T(@l LoadingTip loadingTip) {
        if (getActivity() == null) {
            return;
        }
        if (loadingTip == null) {
            LibmarsStrfragmentBinding mRootViewBinding = getMRootViewBinding();
            loadingTip = mRootViewBinding != null ? mRootViewBinding.f12303e : null;
        }
        if (loadingTip != null) {
            loadingTip.setLoadingTip(LoadingTip.LoadStatus.finish);
        }
    }

    public void W(@l String str, @l LoadingTip loadingTip) {
        if (getActivity() == null) {
            return;
        }
        if (loadingTip == null) {
            LibmarsStrfragmentBinding mRootViewBinding = getMRootViewBinding();
            loadingTip = mRootViewBinding != null ? mRootViewBinding.f12303e : null;
        }
        if (loadingTip != null) {
            loadingTip.setLoadingTip(LoadingTip.LoadStatus.loading);
            if (ba.l.q(str)) {
                return;
            }
            loadingTip.setTips(ConfigSingleton.D().s(str));
        }
    }

    public void Y() {
    }

    public void Z(boolean loading) {
        this.isLoading = loading;
    }

    public void a0(@l LibmarsStrfragmentBinding libmarsStrfragmentBinding) {
        this.mRootViewBinding = libmarsStrfragmentBinding;
    }

    public void b0(int color) {
        SwipeRefreshLayout swipeRefreshLayout;
        LibmarsStrfragmentBinding mRootViewBinding = getMRootViewBinding();
        if (mRootViewBinding == null || (swipeRefreshLayout = mRootViewBinding.f12302d) == null) {
            return;
        }
        swipeRefreshLayout.setColorSchemeResources(color);
    }

    public void d0() {
        SwipeRefreshLayout swipeRefreshLayout;
        LibmarsStrfragmentBinding mRootViewBinding = getMRootViewBinding();
        if (mRootViewBinding != null && (swipeRefreshLayout = mRootViewBinding.f12302d) != null && swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
        this.isLoading = false;
    }

    public void e0(boolean enable) {
        SwipeRefreshLayout swipeRefreshLayout;
        LibmarsStrfragmentBinding mRootViewBinding = getMRootViewBinding();
        if (mRootViewBinding == null || (swipeRefreshLayout = mRootViewBinding.f12302d) == null) {
            return;
        }
        swipeRefreshLayout.setEnabled(enable);
    }

    public void f0(boolean r22) {
        SwipeRefreshLayout swipeRefreshLayout;
        LibmarsStrfragmentBinding mRootViewBinding = getMRootViewBinding();
        if (mRootViewBinding == null || (swipeRefreshLayout = mRootViewBinding.f12302d) == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(r22);
    }

    public void g0(boolean loading, @l LoadingTip loadingTip) {
        LoadingTip loadingTip2;
        if (loadingTip == null) {
            LibmarsStrfragmentBinding mRootViewBinding = getMRootViewBinding();
            loadingTip2 = mRootViewBinding != null ? mRootViewBinding.f12303e : null;
        } else {
            loadingTip2 = loadingTip;
        }
        if (loading) {
            W("", loadingTip2);
            return;
        }
        if ((loadingTip2 != null ? loadingTip2.getCurrentStatus() : null) == LoadingTip.LoadStatus.loading) {
            T(loadingTip);
        }
    }

    public abstract void i0();

    @Override // com.martian.mibook.mvvm.base.BaseFragment
    @k
    public VB m() {
        Type[] actualTypeArguments;
        Type genericSuperclass = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = genericSuperclass instanceof ParameterizedType ? (ParameterizedType) genericSuperclass : null;
        Type type = (parameterizedType == null || (actualTypeArguments = parameterizedType.getActualTypeArguments()) == null) ? null : (Type) ArraysKt.getOrNull(actualTypeArguments, 0);
        Class cls = type instanceof Class ? (Class) type : null;
        if (cls == null) {
            throw new IllegalStateException("Unable to determine binding class.");
        }
        Object invoke = cls.getMethod("inflate", LayoutInflater.class).invoke(null, getLayoutInflater());
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type VB of com.martian.mibook.mvvm.base.BaseMVVMFragment");
        return (VB) invoke;
    }

    @Override // com.martian.mibook.mvvm.base.BaseFragment
    @l
    public ViewBinding o() {
        return null;
    }

    @Override // com.martian.mibook.mvvm.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@k View view, @l Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        w();
        y();
    }

    @Override // com.martian.mibook.mvvm.base.BaseFragment
    public void p(@l ViewBinding rootViewBinding, @k VB mViewBinding) {
        LoadingTip loadingTip;
        FrameLayout frameLayout;
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        Intrinsics.checkNotNullParameter(mViewBinding, "mViewBinding");
        if (rootViewBinding != null) {
            if (rootViewBinding instanceof LibmarsStrfragmentBinding) {
                a0((LibmarsStrfragmentBinding) rootViewBinding);
            }
            LibmarsStrfragmentBinding mRootViewBinding = getMRootViewBinding();
            if (mRootViewBinding != null && (swipeRefreshLayout2 = mRootViewBinding.f12302d) != null) {
                swipeRefreshLayout2.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: lc.j
                    public /* synthetic */ j() {
                    }

                    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                    public final void onRefresh() {
                        BaseMVVMFragment.N(BaseMVVMFragment.this);
                    }
                });
            }
            LibmarsStrfragmentBinding mRootViewBinding2 = getMRootViewBinding();
            if (mRootViewBinding2 != null && (swipeRefreshLayout = mRootViewBinding2.f12302d) != null) {
                swipeRefreshLayout.setColorSchemeResources(ConfigSingleton.D().l0());
            }
            LibmarsStrfragmentBinding mRootViewBinding3 = getMRootViewBinding();
            FrameLayout frameLayout2 = mRootViewBinding3 != null ? mRootViewBinding3.f12301c : null;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            LibmarsStrfragmentBinding mRootViewBinding4 = getMRootViewBinding();
            if (mRootViewBinding4 != null && (frameLayout = mRootViewBinding4.f12301c) != null) {
                frameLayout.addView(mViewBinding.getRoot());
            }
            LibmarsStrfragmentBinding mRootViewBinding5 = getMRootViewBinding();
            if (mRootViewBinding5 != null && (loadingTip = mRootViewBinding5.f12303e) != null) {
                loadingTip.setOnReloadListener(new Function0<Unit>(this) { // from class: com.martian.mibook.mvvm.base.BaseMVVMFragment$initRootView$1$3
                    final /* synthetic */ BaseMVVMFragment<VB, VM> this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public BaseMVVMFragment$initRootView$1$3(BaseMVVMFragment<VB, VM> this) {
                        super(0);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke */
                    public final void invoke2() {
                        this.this$0.Y();
                    }
                });
            }
            e0(false);
        }
    }

    public void y() {
        I().h().observe(getViewLifecycleOwner(), new Observer() { // from class: lc.f
            public /* synthetic */ f() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseMVVMFragment.z(Function1.this, obj);
            }
        });
        I().g().observe(getViewLifecycleOwner(), new Observer() { // from class: lc.g
            public /* synthetic */ g() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseMVVMFragment.A(Function1.this, obj);
            }
        });
    }
}
