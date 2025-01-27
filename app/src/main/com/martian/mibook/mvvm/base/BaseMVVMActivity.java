package com.martian.mibook.mvvm.base;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;
import com.gyf.immersionbar.d;
import com.kwad.sdk.m.e;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.databinding.LayoutToolbarBinding;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.umeng.analytics.MobclickAgent;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import k9.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import r3.c;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\f\b\u0001\u0010\u0004*\u0006\u0012\u0002\b\u00030\u00032\b\u0012\u0004\u0012\u00028\u00000\u00052\u00020\u0006B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\bJ\u000f\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\bJ\u0019\u0010\u001d\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010\bJ\u000f\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b \u0010\bJ\u000f\u0010!\u001a\u00020\tH\u0014¢\u0006\u0004\b!\u0010\bJ\u000f\u0010\"\u001a\u00020\tH\u0014¢\u0006\u0004\b\"\u0010\bJ\u000f\u0010#\u001a\u00020\tH\u0014¢\u0006\u0004\b#\u0010\bJ\u000f\u0010$\u001a\u00020\tH\u0016¢\u0006\u0004\b$\u0010\bJ\u000f\u0010%\u001a\u00020\tH\u0016¢\u0006\u0004\b%\u0010\bJ\u000f\u0010&\u001a\u00020\tH\u0016¢\u0006\u0004\b&\u0010\bJ\u0017\u0010)\u001a\u00020\t2\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\tH\u0016¢\u0006\u0004\b+\u0010\bJ!\u0010/\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010-H\u0014¢\u0006\u0004\b/\u00100J\u0019\u00101\u001a\u00020\t2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0004\b1\u00102J#\u00105\u001a\u00020\t2\b\u00104\u001a\u0004\u0018\u0001032\b\u0010.\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0004\b5\u00106J#\u00109\u001a\u00020\t2\b\u00108\u001a\u0004\u0018\u0001072\b\u0010.\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\tH\u0016¢\u0006\u0004\b;\u0010\bJ\u000f\u0010<\u001a\u00020\tH\u0016¢\u0006\u0004\b<\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010\u001eR\u001b\u0010F\u001a\u00028\u00018VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001d\u0010K\u001a\u0004\u0018\u00010G8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bH\u0010C\u001a\u0004\bI\u0010J¨\u0006L"}, d2 = {"Lcom/martian/mibook/mvvm/base/BaseMVVMActivity;", "Landroidx/viewbinding/ViewBinding;", "VB", "Lcom/martian/mibook/mvvm/base/BaseViewModel;", "VM", "Lcom/martian/mibook/mvvm/base/BaseActivity;", "Lk9/b;", "<init>", "()V", "", "i1", "", "darkMode", "w1", "(Z)V", "Ljava/lang/Class;", "o1", "()Ljava/lang/Class;", "Z0", "()Landroidx/viewbinding/ViewBinding;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "b1", "r1", "q1", "Lcom/martian/libmars/databinding/LayoutToolbarBinding;", "toolbarBinding", "s1", "(Lcom/martian/libmars/databinding/LayoutToolbarBinding;)V", "p1", "k1", "onResume", "onPause", "onDestroy", "finish", "u1", c.f30241d, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "A0", "loading", "Lcom/martian/libmars/widget/recyclerview/LoadingTip;", "loadingTip", "y1", "(ZLcom/martian/libmars/widget/recyclerview/LoadingTip;)V", "C1", "(Lcom/martian/libmars/widget/recyclerview/LoadingTip;)V", "Lcom/martian/mibook/mvvm/net/ErrorResult;", "errorResult", "A1", "(Lcom/martian/mibook/mvvm/net/ErrorResult;Lcom/martian/libmars/widget/recyclerview/LoadingTip;)V", "", "title", "z1", "(Ljava/lang/String;Lcom/martian/libmars/widget/recyclerview/LoadingTip;)V", "E1", "x1", e.TAG, "Lcom/martian/libmars/databinding/LayoutToolbarBinding;", "n1", "()Lcom/martian/libmars/databinding/LayoutToolbarBinding;", "D1", "f", "Lkotlin/Lazy;", "m1", "()Lcom/martian/mibook/mvvm/base/BaseViewModel;", "mViewModel", "Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "g", "l1", "()Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "appViewModel", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public abstract class BaseMVVMActivity<VB extends ViewBinding, VM extends BaseViewModel<?>> extends BaseActivity<VB> implements b {

    /* renamed from: e */
    @l
    public LayoutToolbarBinding toolbarBinding;

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel = LazyKt.lazy(new Function0<VM>(this) { // from class: com.martian.mibook.mvvm.base.BaseMVVMActivity$mViewModel$2
        final /* synthetic */ BaseMVVMActivity<VB, VM> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseMVVMActivity$mViewModel$2(BaseMVVMActivity<VB, VM> this) {
            super(0);
            this.this$0 = this;
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final BaseViewModel invoke() {
            return (BaseViewModel) new ViewModelProvider(this.this$0).get(this.this$0.o1());
        }
    });

    /* renamed from: g, reason: from kotlin metadata */
    @k
    public final Lazy appViewModel = LazyKt.lazy(new Function0<AppViewModel>(this) { // from class: com.martian.mibook.mvvm.base.BaseMVVMActivity$appViewModel$2
        final /* synthetic */ BaseMVVMActivity<VB, VM> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseMVVMActivity$appViewModel$2(BaseMVVMActivity<VB, VM> this) {
            super(0);
            this.this$0 = this;
        }

        @Override // kotlin.jvm.functions.Function0
        @l
        public final AppViewModel invoke() {
            return lc.b.a(this.this$0);
        }
    });

    public static final void B1(ErrorResult errorResult, LoadingTip this_apply) {
        String errorMsg;
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (errorResult == null || errorResult.getErrorCode() != -100002) {
            this_apply.setLoadingTip(LoadingTip.LoadStatus.serverError);
        } else {
            this_apply.setLoadingTip(LoadingTip.LoadStatus.network_error);
        }
        Integer num = null;
        if (ba.l.q(errorResult != null ? errorResult.getErrorMsg() : null)) {
            return;
        }
        if (errorResult != null && (errorMsg = errorResult.getErrorMsg()) != null) {
            num = Integer.valueOf(errorMsg.length());
        }
        Intrinsics.checkNotNull(num);
        if (num.intValue() < 20) {
            this_apply.setTips(ExtKt.c(errorResult.getErrorMsg()));
        }
    }

    public static final void j1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void t1(BaseMVVMActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    private final void w1(boolean darkMode) {
        ConfigSingleton.D().b1(darkMode);
        A0();
    }

    @Override // k9.b
    public void A0() {
        q1();
        E1();
    }

    public void A1(@l ErrorResult errorResult, @l LoadingTip loadingTip) {
        if (loadingTip != null) {
            loadingTip.post(new Runnable() { // from class: lc.e

                /* renamed from: c */
                public final /* synthetic */ LoadingTip f28086c;

                public /* synthetic */ e(LoadingTip loadingTip2) {
                    loadingTip = loadingTip2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    BaseMVVMActivity.B1(ErrorResult.this, loadingTip);
                }
            });
        }
    }

    public void C1(@l LoadingTip loadingTip) {
        if (loadingTip != null) {
            loadingTip.setLoadingTip(LoadingTip.LoadStatus.finish);
        }
    }

    public final void D1(@l LayoutToolbarBinding layoutToolbarBinding) {
        this.toolbarBinding = layoutToolbarBinding;
    }

    public void E1() {
        View findViewById = findViewById(R.id.night_mask);
        FrameLayout frameLayout = findViewById instanceof FrameLayout ? (FrameLayout) findViewById : null;
        if (!ConfigSingleton.D().H0()) {
            if (frameLayout == null) {
                return;
            }
            frameLayout.setVisibility(8);
        } else {
            if (frameLayout == null) {
                frameLayout = new FrameLayout(this);
                frameLayout.setId(R.id.night_mask);
                frameLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.semi_transparent_dark));
                getWindow().addContentView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
            }
            frameLayout.setVisibility(0);
        }
    }

    @Override // com.martian.mibook.mvvm.base.BaseActivity
    @k
    public VB Z0() {
        Type[] actualTypeArguments;
        Type genericSuperclass = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = genericSuperclass instanceof ParameterizedType ? (ParameterizedType) genericSuperclass : null;
        Type type = (parameterizedType == null || (actualTypeArguments = parameterizedType.getActualTypeArguments()) == null) ? null : (Type) ArraysKt.getOrNull(actualTypeArguments, 0);
        Class cls = type instanceof Class ? (Class) type : null;
        if (cls == null) {
            throw new IllegalStateException("Unable to determine binding class.");
        }
        Object invoke = cls.getMethod("inflate", LayoutInflater.class).invoke(null, getLayoutInflater());
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type VB of com.martian.mibook.mvvm.base.BaseMVVMActivity");
        return (VB) invoke;
    }

    @Override // com.martian.mibook.mvvm.base.BaseActivity
    public void b1(@l Bundle savedInstanceState) {
        super.b1(savedInstanceState);
        p1();
        q1();
        View findViewById = findViewById(R.id.actionbar_root_view);
        LayoutToolbarBinding a10 = findViewById != null ? LayoutToolbarBinding.a(findViewById) : null;
        this.toolbarBinding = a10;
        s1(a10);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        v1();
    }

    public final void i1() {
        MutableLiveData<Unit> h02;
        AppViewModel l12 = l1();
        if (l12 == null || (h02 = l12.h0()) == null) {
            return;
        }
        h02.observe(this, new Observer() { // from class: lc.c
            public /* synthetic */ c() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseMVVMActivity.j1(Function1.this, obj);
            }
        });
    }

    public void k1() {
    }

    @l
    public AppViewModel l1() {
        return (AppViewModel) this.appViewModel.getValue();
    }

    @k
    public VM m1() {
        return (VM) this.mViewModel.getValue();
    }

    @l
    /* renamed from: n1, reason: from getter */
    public final LayoutToolbarBinding getToolbarBinding() {
        return this.toolbarBinding;
    }

    @k
    public Class<VM> o1() {
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

    @Override // com.martian.mibook.mvvm.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@k Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        int i10 = newConfig.uiMode & 48;
        if (i10 == 16) {
            w1(false);
        } else {
            if (i10 != 32) {
                return;
            }
            w1(true);
        }
    }

    @Override // com.martian.mibook.mvvm.base.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@l Bundle savedInstanceState) {
        r1();
        super.onCreate(savedInstanceState);
        u1();
        i1();
        k1();
        E1();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        x1();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (ConfigSingleton.D().V0()) {
            MobclickAgent.onPause(this);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (ConfigSingleton.D().V0()) {
            MobclickAgent.onResume(this);
        }
    }

    public void p1() {
    }

    public void q1() {
        boolean A0 = ConfigSingleton.D().A0();
        d.q3(this).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
    }

    public void r1() {
        setTheme(MiConfigSingleton.b2().r2().e().themeNoActionBar);
    }

    public void s1(@l LayoutToolbarBinding toolbarBinding) {
        if (toolbarBinding != null) {
            d.l2(this, toolbarBinding.f12250j);
            toolbarBinding.f12245e.setOnClickListener(new View.OnClickListener() { // from class: lc.d
                public /* synthetic */ d() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseMVVMActivity.t1(BaseMVVMActivity.this, view);
                }
            });
            toolbarBinding.f12247g.setVisibility(8);
        }
    }

    public void u1() {
        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }

    public void v1() {
        overridePendingTransition(R.anim.activity_back_in, R.anim.activity_back_out);
    }

    public void x1() {
        View findViewById = findViewById(R.id.night_mask);
        FrameLayout frameLayout = findViewById instanceof FrameLayout ? (FrameLayout) findViewById : null;
        if (frameLayout != null) {
            View findViewById2 = findViewById(android.R.id.content);
            Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) findViewById2).removeView(frameLayout);
        }
    }

    public void y1(boolean loading, @l LoadingTip loadingTip) {
        if (loading) {
            if (loadingTip != null) {
                loadingTip.setLoadingTip(LoadingTip.LoadStatus.loading);
            }
        } else {
            if ((loadingTip != null ? loadingTip.getCurrentStatus() : null) == LoadingTip.LoadStatus.loading) {
                C1(loadingTip);
            }
        }
    }

    public void z1(@l String title, @l LoadingTip loadingTip) {
        if (loadingTip != null) {
            loadingTip.setLoadingTip(LoadingTip.LoadStatus.empty);
            if (ba.l.q(title)) {
                return;
            }
            loadingTip.setTips(ExtKt.c(title));
        }
    }
}
