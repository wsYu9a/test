package com.martian.mibook.mvvm.payment.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.gyf.immersionbar.BarHide;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.FragmentVipPayDialogBinding;
import com.martian.mibook.databinding.VipPopupwindowAgreementBinding;
import com.martian.mibook.lib.account.activity.PopupLoginActivity;
import com.martian.mibook.lib.account.response.AliRechargeOrder;
import com.martian.mibook.lib.account.response.MiRechargeOrder;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.mibook.lib.account.response.WXRechargeOrder;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.payment.adapter.VipBenefitGridAdapter;
import com.martian.mibook.mvvm.payment.adapter.VipPaymentMethodAdapter;
import com.martian.mibook.mvvm.payment.adapter.VipProductAdapter;
import com.martian.mibook.mvvm.payment.data.VipInfo;
import com.martian.mibook.mvvm.payment.data.VipProduct;
import com.martian.mibook.mvvm.payment.fragment.VipPayDialogFragment;
import com.martian.mibook.mvvm.payment.ui.ThemeVipImageView;
import com.martian.mibook.mvvm.payment.ui.ThemeVipTextView;
import com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.rpauth.response.MartianRPAccount;
import java.util.List;
import je.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l9.i0;
import l9.m0;
import l9.t0;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 J2\u00020\u0001:\u0001KB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0006\u0010\u0003J\u0019\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u001b\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0012\u0010\u0003J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u0019\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0017¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010\u0003J\u001f\u0010*\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u001d\u0010I\u001a\u0004\u0018\u00010D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H¨\u0006L"}, d2 = {"Lcom/martian/mibook/mvvm/payment/fragment/VipPayDialogFragment;", "Lcom/martian/libmars/widget/dialog/MartianBottomSheetDialogFragment;", "<init>", "()V", "", "C0", "s0", "", "withCallback", "o0", "(Z)V", "J0", "L0", "M0", "show", "T0", "(Ljava/lang/Boolean;)V", "X0", "W0", "Lcom/martian/mibook/mvvm/payment/data/VipProduct;", "vipProduct", "V0", "(Lcom/martian/mibook/mvvm/payment/data/VipProduct;)V", "Y0", "P0", "q0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "p", "(Landroid/view/View;)Landroid/view/View;", t.f11211k, "(Landroid/view/View;)V", "onResume", "bottomSheet", "", "newState", "u", "(Landroid/view/View;I)V", "Lcom/martian/mibook/mvvm/payment/viewmodel/VipPayViewModel;", "f", "Lcom/martian/mibook/mvvm/payment/viewmodel/VipPayViewModel;", "mViewModel", "Lcom/martian/mibook/databinding/FragmentVipPayDialogBinding;", "g", "Lcom/martian/mibook/databinding/FragmentVipPayDialogBinding;", "mViewBinding", "Lcom/martian/mibook/mvvm/payment/adapter/VipProductAdapter;", "h", "Lcom/martian/mibook/mvvm/payment/adapter/VipProductAdapter;", "productAdapter", "Lcom/martian/mibook/mvvm/payment/adapter/VipBenefitGridAdapter;", "i", "Lcom/martian/mibook/mvvm/payment/adapter/VipBenefitGridAdapter;", "benefitGridAdapter", "Lcom/martian/mibook/mvvm/payment/adapter/VipPaymentMethodAdapter;", "j", "Lcom/martian/mibook/mvvm/payment/adapter/VipPaymentMethodAdapter;", "paymentMethodAdapter", "Landroid/app/AlertDialog;", "k", "Landroid/app/AlertDialog;", "payStatusDialog", "Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", t.f11204d, "Lkotlin/Lazy;", "r0", "()Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "appViewModel", "m", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class VipPayDialogFragment extends MartianBottomSheetDialogFragment {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: n, reason: collision with root package name */
    @k
    public static final String f14281n = "ActivateVip";

    /* renamed from: o, reason: collision with root package name */
    @k
    public static final String f14282o = "sourceName";

    /* renamed from: p, reason: collision with root package name */
    @k
    public static final String f14283p = "sourceId";

    /* renamed from: q, reason: collision with root package name */
    @k
    public static final String f14284q = "openPath";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public VipPayViewModel mViewModel;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public FragmentVipPayDialogBinding mViewBinding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @l
    public VipProductAdapter productAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @l
    public VipBenefitGridAdapter benefitGridAdapter;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @l
    public VipPaymentMethodAdapter paymentMethodAdapter;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @l
    public AlertDialog payStatusDialog;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @k
    public final Lazy appViewModel = LazyKt.lazy(new Function0<AppViewModel>() { // from class: com.martian.mibook.mvvm.payment.fragment.VipPayDialogFragment$appViewModel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @l
        public final AppViewModel invoke() {
            return lc.b.a(VipPayDialogFragment.this.getContext());
        }
    });

    /* renamed from: com.martian.mibook.mvvm.payment.fragment.VipPayDialogFragment$a, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: com.martian.mibook.mvvm.payment.fragment.VipPayDialogFragment$a$a, reason: collision with other inner class name */
        public static final class C0532a implements MartianBottomSheetDialogFragment.b {
            @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.b
            public void a(@k DialogFragment dialogFragment) {
                Intrinsics.checkNotNullParameter(dialogFragment, "dialogFragment");
                boolean A0 = MiConfigSingleton.b2().A0();
                com.gyf.immersionbar.d.y3(dialogFragment).W0(BarHide.FLAG_HIDE_NAVIGATION_BAR).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@k FragmentActivity activity, @l String str, @l String str2, @l String str3) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            com.martian.libmars.widget.dialog.a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
            a10.k0(true).j0(true).n0(ConfigSingleton.i(MiConfigSingleton.b2().K2() ? 640.0f : 570.0f)).q0(ConfigSingleton.i(16.0f)).s0(new C0532a());
            VipPayDialogFragment vipPayDialogFragment = new VipPayDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("sourceName", str2);
            bundle.putString("sourceId", str3);
            bundle.putString("openPath", str);
            vipPayDialogFragment.setArguments(bundle);
            a10.c0(activity, vipPayDialogFragment, "ActivateVip", true);
        }

        public Companion() {
        }
    }

    public static final class b extends ClickableSpan {
        public b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@k View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            VipPayViewModel vipPayViewModel = VipPayDialogFragment.this.mViewModel;
            if (vipPayViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                vipPayViewModel = null;
            }
            vipPayViewModel.h0(VipPayDialogFragment.this.getActivity(), "问题反馈");
            i.Y(VipPayDialogFragment.this.getActivity());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@k TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            ds.setUnderlineText(true);
        }
    }

    public static final class c extends ClickableSpan {
        public c() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@k View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            VipPayViewModel vipPayViewModel = VipPayDialogFragment.this.mViewModel;
            if (vipPayViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                vipPayViewModel = null;
            }
            vipPayViewModel.h0(VipPayDialogFragment.this.getActivity(), "微信客服");
            String wechatCustomerUrl = MiConfigSingleton.b2().c2().getWechatCustomerUrl();
            Intrinsics.checkNotNull(wechatCustomerUrl);
            if (StringsKt.contains$default((CharSequence) wechatCustomerUrl, (CharSequence) "{{UID}}", false, 2, (Object) null)) {
                Intrinsics.checkNotNull(wechatCustomerUrl);
                String t22 = MiConfigSingleton.b2().t2();
                Intrinsics.checkNotNullExpressionValue(t22, "getUserId(...)");
                wechatCustomerUrl = StringsKt.replace$default(wechatCustomerUrl, "{{UID}}", t22, false, 4, (Object) null);
            }
            MiWebViewActivity.J5(VipPayDialogFragment.this.getActivity(), wechatCustomerUrl, false, "", false, "", false, true);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@k TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            ds.setUnderlineText(true);
        }
    }

    public static final class d extends ClickableSpan {
        public d() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@k View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            lb.c.s(VipPayDialogFragment.this.getActivity());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@k TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            ds.setUnderlineText(true);
            Context context = VipPayDialogFragment.this.getContext();
            if (context != null) {
                ds.setColor(ContextCompat.getColor(context, R.color.day_text_color_primary));
            }
        }
    }

    public static final class e extends ClickableSpan {
        public e() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@k View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            lb.c.r(VipPayDialogFragment.this.getActivity());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@k TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            ds.setUnderlineText(true);
            Context context = VipPayDialogFragment.this.getContext();
            if (context != null) {
                ds.setColor(ContextCompat.getColor(context, R.color.day_text_color_primary));
            }
        }
    }

    public static final class f extends ClickableSpan {
        public f() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@k View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            lb.c.s(VipPayDialogFragment.this.getActivity());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@k TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            ds.setUnderlineText(true);
        }
    }

    public static final class g extends ClickableSpan {
        public g() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@k View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            lb.c.r(VipPayDialogFragment.this.getActivity());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@k TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            ds.setUnderlineText(true);
        }
    }

    public static final void A0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void B0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @SuppressLint({"NotifyDataSetChanged", "SetTextI18n"})
    private final void C0() {
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding = this.mViewBinding;
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding2 = null;
        if (fragmentVipPayDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding = null;
        }
        fragmentVipPayDialogBinding.actionbarBack.setImageResource(R.drawable.icon_more);
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding3 = this.mViewBinding;
        if (fragmentVipPayDialogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding3 = null;
        }
        fragmentVipPayDialogBinding3.actionbarBack.setOnClickListener(new View.OnClickListener() { // from class: ad.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipPayDialogFragment.D0(VipPayDialogFragment.this, view);
            }
        });
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding4 = this.mViewBinding;
        if (fragmentVipPayDialogBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding4 = null;
        }
        fragmentVipPayDialogBinding4.vipComboLoadingTip.setWithIcon(false);
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding5 = this.mViewBinding;
        if (fragmentVipPayDialogBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding5 = null;
        }
        fragmentVipPayDialogBinding5.vipComboLoadingTip.setBackgroundType(-1);
        J0();
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding6 = this.mViewBinding;
        if (fragmentVipPayDialogBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding6 = null;
        }
        fragmentVipPayDialogBinding6.vipComboRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding7 = this.mViewBinding;
        if (fragmentVipPayDialogBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding7 = null;
        }
        fragmentVipPayDialogBinding7.vipBenefitRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        VipPayViewModel vipPayViewModel = this.mViewModel;
        if (vipPayViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel = null;
        }
        this.benefitGridAdapter = new VipBenefitGridAdapter(vipPayViewModel, new Function1<Integer, Unit>() { // from class: com.martian.mibook.mvvm.payment.fragment.VipPayDialogFragment$initialView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i10) {
                FragmentActivity activity = VipPayDialogFragment.this.getActivity();
                if (activity != null) {
                    VipPayViewModel vipPayViewModel2 = VipPayDialogFragment.this.mViewModel;
                    if (vipPayViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                        vipPayViewModel2 = null;
                    }
                    od.k.p(activity, vipPayViewModel2.E(), i10);
                }
            }
        });
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding8 = this.mViewBinding;
        if (fragmentVipPayDialogBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding8 = null;
        }
        fragmentVipPayDialogBinding8.vipBenefitRecyclerView.setAdapter(this.benefitGridAdapter);
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding9 = this.mViewBinding;
        if (fragmentVipPayDialogBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding9 = null;
        }
        fragmentVipPayDialogBinding9.vipPaymentMethodRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        VipPayViewModel vipPayViewModel2 = this.mViewModel;
        if (vipPayViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel2 = null;
        }
        this.paymentMethodAdapter = new VipPaymentMethodAdapter(vipPayViewModel2, new Function1<Integer, Unit>() { // from class: com.martian.mibook.mvvm.payment.fragment.VipPayDialogFragment$initialView$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i10) {
                VipProductAdapter vipProductAdapter;
                VipPayViewModel vipPayViewModel3 = VipPayDialogFragment.this.mViewModel;
                VipPayViewModel vipPayViewModel4 = null;
                if (vipPayViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                    vipPayViewModel3 = null;
                }
                if (vipPayViewModel3.getPaymentMethod() == i10) {
                    return;
                }
                VipPayViewModel vipPayViewModel5 = VipPayDialogFragment.this.mViewModel;
                if (vipPayViewModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                } else {
                    vipPayViewModel4 = vipPayViewModel5;
                }
                vipPayViewModel4.l0(i10);
                vipProductAdapter = VipPayDialogFragment.this.productAdapter;
                if (vipProductAdapter != null) {
                    vipProductAdapter.p();
                }
                VipPayDialogFragment.this.W0();
            }
        });
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding10 = this.mViewBinding;
        if (fragmentVipPayDialogBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding10 = null;
        }
        fragmentVipPayDialogBinding10.vipPaymentMethodRecyclerView.setAdapter(this.paymentMethodAdapter);
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding11 = this.mViewBinding;
        if (fragmentVipPayDialogBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding11 = null;
        }
        fragmentVipPayDialogBinding11.vipComboLoadingTip.setOnClickListener(new View.OnClickListener() { // from class: ad.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipPayDialogFragment.E0(VipPayDialogFragment.this, view);
            }
        });
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding12 = this.mViewBinding;
        if (fragmentVipPayDialogBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding12 = null;
        }
        fragmentVipPayDialogBinding12.vipOpenTextButton.setOnClickListener(new View.OnClickListener() { // from class: ad.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipPayDialogFragment.F0(VipPayDialogFragment.this, view);
            }
        });
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding13 = this.mViewBinding;
        if (fragmentVipPayDialogBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding13 = null;
        }
        fragmentVipPayDialogBinding13.accountLinkAccountView.setOnClickListener(new View.OnClickListener() { // from class: ad.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipPayDialogFragment.G0(VipPayDialogFragment.this, view);
            }
        });
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding14 = this.mViewBinding;
        if (fragmentVipPayDialogBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding14 = null;
        }
        fragmentVipPayDialogBinding14.vipOrderRefresh.setOnClickListener(new View.OnClickListener() { // from class: ad.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipPayDialogFragment.H0(VipPayDialogFragment.this, view);
            }
        });
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding15 = this.mViewBinding;
        if (fragmentVipPayDialogBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding15 = null;
        }
        fragmentVipPayDialogBinding15.vipPrivacyCheck.setOnClickListener(new View.OnClickListener() { // from class: ad.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipPayDialogFragment.I0(VipPayDialogFragment.this, view);
            }
        });
        X0();
        W0();
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding16 = this.mViewBinding;
        if (fragmentVipPayDialogBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding16 = null;
        }
        fragmentVipPayDialogBinding16.vipContactCustomerService.setText(ExtKt.c("充值后会员未生效，请联系 "));
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding17 = this.mViewBinding;
        if (fragmentVipPayDialogBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding17 = null;
        }
        fragmentVipPayDialogBinding17.vipContactCustomerService.setMovementMethod(LinkMovementMethod.getInstance());
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding18 = this.mViewBinding;
        if (fragmentVipPayDialogBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding18 = null;
        }
        fragmentVipPayDialogBinding18.vipCustomerHint.setText(ExtKt.c("2.如有其他疑问，请通过 "));
        SpannableString spannableString = new SpannableString(ExtKt.c("问题反馈"));
        spannableString.setSpan(new b(), 0, 4, 17);
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding19 = this.mViewBinding;
        if (fragmentVipPayDialogBinding19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding19 = null;
        }
        fragmentVipPayDialogBinding19.vipCustomerHint.setMovementMethod(LinkMovementMethod.getInstance());
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding20 = this.mViewBinding;
        if (fragmentVipPayDialogBinding20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding20 = null;
        }
        fragmentVipPayDialogBinding20.vipCustomerHint.append(spannableString);
        if (TextUtils.isEmpty(MiConfigSingleton.b2().c2().getWechatCustomerUrl()) || !i8.g.p(getActivity())) {
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding21 = this.mViewBinding;
            if (fragmentVipPayDialogBinding21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                fragmentVipPayDialogBinding21 = null;
            }
            fragmentVipPayDialogBinding21.vipContactCustomerService.append(spannableString);
        } else {
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding22 = this.mViewBinding;
            if (fragmentVipPayDialogBinding22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                fragmentVipPayDialogBinding22 = null;
            }
            fragmentVipPayDialogBinding22.vipCustomerHint.append(" 或 ");
            SpannableString spannableString2 = new SpannableString(ExtKt.c("微信客服"));
            spannableString2.setSpan(new c(), 0, 4, 17);
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding23 = this.mViewBinding;
            if (fragmentVipPayDialogBinding23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                fragmentVipPayDialogBinding23 = null;
            }
            fragmentVipPayDialogBinding23.vipCustomerHint.append(spannableString2);
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding24 = this.mViewBinding;
            if (fragmentVipPayDialogBinding24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                fragmentVipPayDialogBinding24 = null;
            }
            fragmentVipPayDialogBinding24.vipContactCustomerService.append(spannableString2);
        }
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding25 = this.mViewBinding;
        if (fragmentVipPayDialogBinding25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
        } else {
            fragmentVipPayDialogBinding2 = fragmentVipPayDialogBinding25;
        }
        fragmentVipPayDialogBinding2.vipCustomerHint.append(ExtKt.c(" 获得支持"));
    }

    public static final void D0(VipPayDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void E0(VipPayDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VipPayViewModel vipPayViewModel = this$0.mViewModel;
        if (vipPayViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel = null;
        }
        vipPayViewModel.Z();
    }

    public static final void F0(VipPayDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VipPayViewModel vipPayViewModel = this$0.mViewModel;
        if (vipPayViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel = null;
        }
        if (vipPayViewModel.getVipRuleAgreed()) {
            this$0.q0();
        } else {
            this$0.P0();
        }
    }

    public static final void G0(VipPayDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            VipPayViewModel vipPayViewModel = this$0.mViewModel;
            VipPayViewModel vipPayViewModel2 = null;
            if (vipPayViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                vipPayViewModel = null;
            }
            vipPayViewModel.h0(activity, "关联账号");
            VipPayViewModel vipPayViewModel3 = this$0.mViewModel;
            if (vipPayViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            } else {
                vipPayViewModel2 = vipPayViewModel3;
            }
            PopupLoginActivity.q1(activity, vipPayViewModel2.getVipRuleAgreed() ? 200 : 1024, !MiConfigSingleton.b2().C2());
        }
    }

    public static final void H0(VipPayDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        p0(this$0, false, 1, null);
    }

    public static final void I0(VipPayDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VipPayViewModel vipPayViewModel = this$0.mViewModel;
        VipPayViewModel vipPayViewModel2 = null;
        if (vipPayViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel = null;
        }
        VipPayViewModel vipPayViewModel3 = this$0.mViewModel;
        if (vipPayViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        } else {
            vipPayViewModel2 = vipPayViewModel3;
        }
        vipPayViewModel.s0(!vipPayViewModel2.getVipRuleAgreed());
        this$0.X0();
    }

    @JvmStatic
    public static final void O0(@k FragmentActivity fragmentActivity, @l String str, @l String str2, @l String str3) {
        INSTANCE.a(fragmentActivity, str, str2, str3);
    }

    @SuppressLint({"InflateParams", "SetTextI18n"})
    private final void P0() {
        VipPayViewModel vipPayViewModel = null;
        View inflate = LayoutInflater.from(getActivity()).inflate(com.martian.mibook.R.layout.vip_popupwindow_agreement, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        final AlertDialog G = i0.G(getActivity(), inflate, false);
        VipPopupwindowAgreementBinding bind = VipPopupwindowAgreementBinding.bind(inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        bind.privacyDesc.setLineSpacing(0.0f, 1.2f);
        TextView textView = bind.privacyDesc;
        VipPayViewModel vipPayViewModel2 = this.mViewModel;
        if (vipPayViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel2 = null;
        }
        textView.setText(ExtKt.c(vipPayViewModel2.getIsVip() ? "如需续费，请先同意 " : "如需开通，请先同意 "));
        SpannableString spannableString = new SpannableString(ExtKt.c("会员服务协议"));
        spannableString.setSpan(new e(), 0, 6, 17);
        bind.privacyDesc.setMovementMethod(LinkMovementMethod.getInstance());
        bind.privacyDesc.append(spannableString);
        VipPayViewModel vipPayViewModel3 = this.mViewModel;
        if (vipPayViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel3 = null;
        }
        if (vipPayViewModel3.f0()) {
            bind.privacyDesc.append(" 和 ");
            SpannableString spannableString2 = new SpannableString(ExtKt.c("自动续费协议"));
            spannableString2.setSpan(new d(), 0, 6, 17);
            bind.privacyDesc.append(spannableString2);
        }
        bind.privacyKnown.setText(ExtKt.c("取消"));
        bind.privacyKnown.setOnClickListener(new View.OnClickListener() { // from class: ad.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipPayDialogFragment.Q0(G, view);
            }
        });
        ThemeTextView themeTextView = bind.privacyAgree;
        VipPayViewModel vipPayViewModel4 = this.mViewModel;
        if (vipPayViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        } else {
            vipPayViewModel = vipPayViewModel4;
        }
        themeTextView.setText(ExtKt.c(vipPayViewModel.getIsVip() ? "同意并续费" : "同意并开通"));
        bind.privacyAgree.setOnClickListener(new View.OnClickListener() { // from class: ad.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipPayDialogFragment.R0(VipPayDialogFragment.this, G, view);
            }
        });
    }

    public static final void Q0(AlertDialog alertDialog, View view) {
        alertDialog.dismiss();
    }

    public static final void R0(VipPayDialogFragment this$0, AlertDialog alertDialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VipPayViewModel vipPayViewModel = this$0.mViewModel;
        if (vipPayViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel = null;
        }
        vipPayViewModel.s0(true);
        this$0.X0();
        this$0.q0();
        alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T0(Boolean show) {
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding = null;
        if (Intrinsics.areEqual(show, Boolean.TRUE)) {
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding2 = this.mViewBinding;
            if (fragmentVipPayDialogBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            } else {
                fragmentVipPayDialogBinding = fragmentVipPayDialogBinding2;
            }
            fragmentVipPayDialogBinding.vipOrderResult.setVisibility(0);
            return;
        }
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding3 = this.mViewBinding;
        if (fragmentVipPayDialogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
        } else {
            fragmentVipPayDialogBinding = fragmentVipPayDialogBinding3;
        }
        fragmentVipPayDialogBinding.vipOrderResult.setVisibility(8);
    }

    public static /* synthetic */ void U0(VipPayDialogFragment vipPayDialogFragment, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = Boolean.TRUE;
        }
        vipPayDialogFragment.T0(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void V0(VipProduct vipProduct) {
        VipPayViewModel vipPayViewModel = this.mViewModel;
        VipPayViewModel vipPayViewModel2 = null;
        if (vipPayViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel = null;
        }
        vipPayViewModel.j0(vipProduct);
        if (MiConfigSingleton.b2().K2()) {
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding = this.mViewBinding;
            if (fragmentVipPayDialogBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                fragmentVipPayDialogBinding = null;
            }
            ThemeVipTextView themeVipTextView = fragmentVipPayDialogBinding.vipOpenText;
            VipPayViewModel vipPayViewModel3 = this.mViewModel;
            if (vipPayViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            } else {
                vipPayViewModel2 = vipPayViewModel3;
            }
            themeVipTextView.setText(vipPayViewModel2.G(vipProduct) + ExtKt.c(" 立即续费"));
        } else {
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding2 = this.mViewBinding;
            if (fragmentVipPayDialogBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                fragmentVipPayDialogBinding2 = null;
            }
            ThemeVipTextView themeVipTextView2 = fragmentVipPayDialogBinding2.vipOpenText;
            VipPayViewModel vipPayViewModel4 = this.mViewModel;
            if (vipPayViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            } else {
                vipPayViewModel2 = vipPayViewModel4;
            }
            themeVipTextView2.setText(vipPayViewModel2.G(vipProduct) + ExtKt.c(" 立即开通"));
        }
        W0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void W0() {
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding = this.mViewBinding;
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding2 = null;
        if (fragmentVipPayDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding = null;
        }
        fragmentVipPayDialogBinding.vipPrivacyCheckText.setText("");
        SpannableString spannableString = new SpannableString(ExtKt.c("会员服务协议"));
        spannableString.setSpan(new g(), 0, 6, 17);
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding3 = this.mViewBinding;
        if (fragmentVipPayDialogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding3 = null;
        }
        fragmentVipPayDialogBinding3.vipPrivacyCheckText.setMovementMethod(LinkMovementMethod.getInstance());
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding4 = this.mViewBinding;
        if (fragmentVipPayDialogBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding4 = null;
        }
        fragmentVipPayDialogBinding4.vipPrivacyCheckText.append(spannableString);
        VipPayViewModel vipPayViewModel = this.mViewModel;
        if (vipPayViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel = null;
        }
        if (vipPayViewModel.f0()) {
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding5 = this.mViewBinding;
            if (fragmentVipPayDialogBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                fragmentVipPayDialogBinding5 = null;
            }
            fragmentVipPayDialogBinding5.vipPrivacyCheckText.append(" ");
            SpannableString spannableString2 = new SpannableString(ExtKt.c("自动续费协议"));
            spannableString2.setSpan(new f(), 0, 6, 17);
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding6 = this.mViewBinding;
            if (fragmentVipPayDialogBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                fragmentVipPayDialogBinding6 = null;
            }
            fragmentVipPayDialogBinding6.vipPrivacyCheckText.append(spannableString2);
        }
        VipPayViewModel vipPayViewModel2 = this.mViewModel;
        if (vipPayViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel2 = null;
        }
        VipProduct currentVipProduct = vipPayViewModel2.getCurrentVipProduct();
        if (currentVipProduct != null) {
            VipPayViewModel vipPayViewModel3 = this.mViewModel;
            if (vipPayViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                vipPayViewModel3 = null;
            }
            if (vipPayViewModel3.f0() && !TextUtils.isEmpty(currentVipProduct.getPeriodTag())) {
                FragmentVipPayDialogBinding fragmentVipPayDialogBinding7 = this.mViewBinding;
                if (fragmentVipPayDialogBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    fragmentVipPayDialogBinding7 = null;
                }
                fragmentVipPayDialogBinding7.vipSubscribeDesc.setText(currentVipProduct.getPeriodTag());
                FragmentVipPayDialogBinding fragmentVipPayDialogBinding8 = this.mViewBinding;
                if (fragmentVipPayDialogBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                } else {
                    fragmentVipPayDialogBinding2 = fragmentVipPayDialogBinding8;
                }
                fragmentVipPayDialogBinding2.vipSubscribeDesc.append(ExtKt.c("，您可以随时在支付宝APP中进行解约"));
                return;
            }
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding9 = this.mViewBinding;
            if (fragmentVipPayDialogBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                fragmentVipPayDialogBinding9 = null;
            }
            fragmentVipPayDialogBinding9.vipSubscribeDesc.setText(currentVipProduct.getSubject());
            VipPayViewModel vipPayViewModel4 = this.mViewModel;
            if (vipPayViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                vipPayViewModel4 = null;
            }
            if (vipPayViewModel4.getIsChargeUser()) {
                FragmentVipPayDialogBinding fragmentVipPayDialogBinding10 = this.mViewBinding;
                if (fragmentVipPayDialogBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                } else {
                    fragmentVipPayDialogBinding2 = fragmentVipPayDialogBinding10;
                }
                fragmentVipPayDialogBinding2.vipSubscribeDesc.append(ExtKt.c("，畅享全站无广告免费阅读"));
                return;
            }
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding11 = this.mViewBinding;
            if (fragmentVipPayDialogBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            } else {
                fragmentVipPayDialogBinding2 = fragmentVipPayDialogBinding11;
            }
            fragmentVipPayDialogBinding2.vipSubscribeDesc.append(ExtKt.c("，畅享免广告阅读"));
        }
    }

    private final void X0() {
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding = this.mViewBinding;
        VipPayViewModel vipPayViewModel = null;
        if (fragmentVipPayDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding = null;
        }
        ThemeVipImageView themeVipImageView = fragmentVipPayDialogBinding.vipPrivacyCheckIcon;
        VipPayViewModel vipPayViewModel2 = this.mViewModel;
        if (vipPayViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        } else {
            vipPayViewModel = vipPayViewModel2;
        }
        themeVipImageView.setItemSelected(vipPayViewModel.getVipRuleAgreed());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n", "NotifyDataSetChanged"})
    public final void Y0() {
        boolean K2 = MiConfigSingleton.b2().K2();
        VipPayViewModel vipPayViewModel = this.mViewModel;
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding = null;
        if (vipPayViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel = null;
        }
        if (K2 != vipPayViewModel.getIsVip()) {
            VipPayViewModel vipPayViewModel2 = this.mViewModel;
            if (vipPayViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                vipPayViewModel2 = null;
            }
            vipPayViewModel2.q0(K2);
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding2 = this.mViewBinding;
            if (fragmentVipPayDialogBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                fragmentVipPayDialogBinding2 = null;
            }
            fragmentVipPayDialogBinding2.vipBgView.setVip(K2);
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding3 = this.mViewBinding;
            if (fragmentVipPayDialogBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                fragmentVipPayDialogBinding3 = null;
            }
            fragmentVipPayDialogBinding3.vipOpenText.setVip(K2);
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding4 = this.mViewBinding;
            if (fragmentVipPayDialogBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                fragmentVipPayDialogBinding4 = null;
            }
            fragmentVipPayDialogBinding4.vipOpenTextButton.setVip(K2);
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding5 = this.mViewBinding;
            if (fragmentVipPayDialogBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                fragmentVipPayDialogBinding5 = null;
            }
            fragmentVipPayDialogBinding5.vipOpenTextProgressbar.setVip(K2);
            VipBenefitGridAdapter vipBenefitGridAdapter = this.benefitGridAdapter;
            if (vipBenefitGridAdapter != null) {
                vipBenefitGridAdapter.notifyDataSetChanged();
            }
            VipProductAdapter vipProductAdapter = this.productAdapter;
            if (vipProductAdapter != null) {
                vipProductAdapter.notifyDataSetChanged();
            }
        }
        VipPayViewModel vipPayViewModel3 = this.mViewModel;
        if (vipPayViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel3 = null;
        }
        if (vipPayViewModel3.getIsChargeUser()) {
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding6 = this.mViewBinding;
            if (fragmentVipPayDialogBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                fragmentVipPayDialogBinding6 = null;
            }
            fragmentVipPayDialogBinding6.actionbarTitle.setText(getString(com.martian.mibook.R.string.vip_activity_title_charge_user));
        } else {
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding7 = this.mViewBinding;
            if (fragmentVipPayDialogBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                fragmentVipPayDialogBinding7 = null;
            }
            fragmentVipPayDialogBinding7.actionbarTitle.setText(getString(com.martian.mibook.R.string.vip_activity_title));
        }
        if (K2) {
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding8 = this.mViewBinding;
            if (fragmentVipPayDialogBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                fragmentVipPayDialogBinding8 = null;
            }
            fragmentVipPayDialogBinding8.accountVipStatusView.setVisibility(0);
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding9 = this.mViewBinding;
            if (fragmentVipPayDialogBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                fragmentVipPayDialogBinding9 = null;
            }
            fragmentVipPayDialogBinding9.actionbarTitle.setText(getString(com.martian.mibook.R.string.vip_center));
            long v22 = MiConfigSingleton.b2().v2();
            if (v22 > 0) {
                String str = ExtKt.c("会员至：") + ba.f.i(v22, "yyyy-MM-dd HH:mm");
                FragmentVipPayDialogBinding fragmentVipPayDialogBinding10 = this.mViewBinding;
                if (fragmentVipPayDialogBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    fragmentVipPayDialogBinding10 = null;
                }
                fragmentVipPayDialogBinding10.accountVipDesc.setText(str);
            } else {
                FragmentVipPayDialogBinding fragmentVipPayDialogBinding11 = this.mViewBinding;
                if (fragmentVipPayDialogBinding11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    fragmentVipPayDialogBinding11 = null;
                }
                fragmentVipPayDialogBinding11.accountVipDesc.setText(ExtKt.c("已开通会员"));
            }
            if (MiConfigSingleton.b2().N2()) {
                FragmentVipPayDialogBinding fragmentVipPayDialogBinding12 = this.mViewBinding;
                if (fragmentVipPayDialogBinding12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    fragmentVipPayDialogBinding12 = null;
                }
                fragmentVipPayDialogBinding12.accountLinkAccountView.setVisibility(8);
            } else {
                FragmentVipPayDialogBinding fragmentVipPayDialogBinding13 = this.mViewBinding;
                if (fragmentVipPayDialogBinding13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    fragmentVipPayDialogBinding13 = null;
                }
                fragmentVipPayDialogBinding13.accountLinkAccountView.setVisibility(0);
            }
        } else {
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding14 = this.mViewBinding;
            if (fragmentVipPayDialogBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                fragmentVipPayDialogBinding14 = null;
            }
            fragmentVipPayDialogBinding14.accountVipStatusView.setVisibility(8);
        }
        MiUser p10 = MiConfigSingleton.b2().G1().p();
        if (p10 != null) {
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding15 = this.mViewBinding;
            if (fragmentVipPayDialogBinding15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                fragmentVipPayDialogBinding15 = null;
            }
            fragmentVipPayDialogBinding15.accountVipTitle.setText(ExtKt.c(p10.getNickname()));
            Context context = getContext();
            String header = p10.getHeader();
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding16 = this.mViewBinding;
            if (fragmentVipPayDialogBinding16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            } else {
                fragmentVipPayDialogBinding = fragmentVipPayDialogBinding16;
            }
            m0.l(context, header, fragmentVipPayDialogBinding.vipHeader, com.martian.mibook.lib.account.R.drawable.day_img_heads);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(boolean withCallback) {
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding = this.mViewBinding;
        VipPayViewModel vipPayViewModel = null;
        if (fragmentVipPayDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding = null;
        }
        if (fragmentVipPayDialogBinding.vipOrderProgressbar.getVisibility() == 0) {
            t0.b(getActivity(), ExtKt.c("支付处理中,请稍候重试"));
            return;
        }
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding2 = this.mViewBinding;
        if (fragmentVipPayDialogBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding2 = null;
        }
        fragmentVipPayDialogBinding2.vipOrderProgressbar.setVisibility(0);
        VipPayViewModel vipPayViewModel2 = this.mViewModel;
        if (vipPayViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        } else {
            vipPayViewModel = vipPayViewModel2;
        }
        vipPayViewModel.x(withCallback);
    }

    public static /* synthetic */ void p0(VipPayDialogFragment vipPayDialogFragment, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        vipPayDialogFragment.o0(z10);
    }

    private final void q0() {
        if (!MiConfigSingleton.b2().C2() || MiConfigSingleton.b2().G1().i(getActivity())) {
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding = this.mViewBinding;
            VipPayViewModel vipPayViewModel = null;
            if (fragmentVipPayDialogBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                fragmentVipPayDialogBinding = null;
            }
            if (fragmentVipPayDialogBinding.vipOpenTextProgressbar.getVisibility() == 0) {
                t0.b(getActivity(), "订单创建中，请稍候");
                return;
            }
            FragmentVipPayDialogBinding fragmentVipPayDialogBinding2 = this.mViewBinding;
            if (fragmentVipPayDialogBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                fragmentVipPayDialogBinding2 = null;
            }
            fragmentVipPayDialogBinding2.vipOpenTextProgressbar.setVisibility(0);
            VipPayViewModel vipPayViewModel2 = this.mViewModel;
            if (vipPayViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            } else {
                vipPayViewModel = vipPayViewModel2;
            }
            vipPayViewModel.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppViewModel r0() {
        return (AppViewModel) this.appViewModel.getValue();
    }

    public static final void t0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void u0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void v0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void w0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void x0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void y0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void z0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void J0() {
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding = this.mViewBinding;
        if (fragmentVipPayDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding = null;
        }
        fragmentVipPayDialogBinding.vipComboLoadingTip.setLoadingTip(LoadingTip.LoadStatus.loading);
    }

    public final void L0() {
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding = this.mViewBinding;
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding2 = null;
        if (fragmentVipPayDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding = null;
        }
        fragmentVipPayDialogBinding.vipComboLoadingTip.setLoadingTip(LoadingTip.LoadStatus.empty);
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding3 = this.mViewBinding;
        if (fragmentVipPayDialogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
        } else {
            fragmentVipPayDialogBinding2 = fragmentVipPayDialogBinding3;
        }
        fragmentVipPayDialogBinding2.vipComboLoadingTip.setTips(ExtKt.c("未找到可用套餐"));
    }

    public final void M0() {
        FragmentVipPayDialogBinding fragmentVipPayDialogBinding = this.mViewBinding;
        if (fragmentVipPayDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            fragmentVipPayDialogBinding = null;
        }
        fragmentVipPayDialogBinding.vipComboLoadingTip.setLoadingTip(LoadingTip.LoadStatus.finish);
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@l Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mViewModel = (VipPayViewModel) new ViewModelProvider(this).get(VipPayViewModel.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Y0();
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@k View view, @l Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(view, "view");
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.addFlags(512);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment
    @l
    @SuppressLint({"InflateParams"})
    public View p(@k View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View inflate = LayoutInflater.from(getContext()).inflate(com.martian.mibook.R.layout.fragment_vip_pay_dialog, (ViewGroup) null);
        FragmentVipPayDialogBinding bind = FragmentVipPayDialogBinding.bind(inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.mViewBinding = bind;
        return inflate;
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment
    public void r(@k View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.r(view);
        VipPayViewModel vipPayViewModel = this.mViewModel;
        VipPayViewModel vipPayViewModel2 = null;
        if (vipPayViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel = null;
        }
        Bundle arguments = getArguments();
        vipPayViewModel.p0(arguments != null ? arguments.getString("sourceName", "") : null);
        VipPayViewModel vipPayViewModel3 = this.mViewModel;
        if (vipPayViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel3 = null;
        }
        Bundle arguments2 = getArguments();
        vipPayViewModel3.o0(arguments2 != null ? arguments2.getString("sourceId", "") : null);
        VipPayViewModel vipPayViewModel4 = this.mViewModel;
        if (vipPayViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel4 = null;
        }
        Bundle arguments3 = getArguments();
        vipPayViewModel4.n0(arguments3 != null ? arguments3.getString("openPath", "") : null);
        VipPayViewModel vipPayViewModel5 = this.mViewModel;
        if (vipPayViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        } else {
            vipPayViewModel2 = vipPayViewModel5;
        }
        vipPayViewModel2.h0(getActivity(), "曝光");
        C0();
        s0();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void s0() {
        NonStickyLiveData<MartianRPAccount> Y;
        VipPayViewModel vipPayViewModel = this.mViewModel;
        if (vipPayViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel = null;
        }
        NonStickyLiveData<VipInfo> O = vipPayViewModel.O();
        final Function1<VipInfo, Unit> function1 = new Function1<VipInfo, Unit>() { // from class: com.martian.mibook.mvvm.payment.fragment.VipPayDialogFragment$initialListener$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VipInfo vipInfo) {
                invoke2(vipInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@l VipInfo vipInfo) {
                FragmentVipPayDialogBinding fragmentVipPayDialogBinding;
                FragmentVipPayDialogBinding fragmentVipPayDialogBinding2;
                VipProductAdapter vipProductAdapter;
                FragmentVipPayDialogBinding fragmentVipPayDialogBinding3 = null;
                if (vipInfo != null) {
                    final VipPayDialogFragment vipPayDialogFragment = VipPayDialogFragment.this;
                    List<VipProduct> products = vipInfo.getProducts();
                    if (products != null) {
                        if (!(!products.isEmpty())) {
                            vipPayDialogFragment.L0();
                            return;
                        }
                        VipPayViewModel vipPayViewModel2 = vipPayDialogFragment.mViewModel;
                        if (vipPayViewModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                            vipPayViewModel2 = null;
                        }
                        vipPayViewModel2.r0(products);
                        vipPayDialogFragment.M0();
                        vipPayDialogFragment.V0(products.get(0));
                        VipPayViewModel vipPayViewModel3 = vipPayDialogFragment.mViewModel;
                        if (vipPayViewModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                            vipPayViewModel3 = null;
                        }
                        vipPayDialogFragment.productAdapter = new VipProductAdapter(products, vipPayViewModel3, new Function1<VipProduct, Unit>() { // from class: com.martian.mibook.mvvm.payment.fragment.VipPayDialogFragment$initialListener$1$1$1$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(VipProduct vipProduct) {
                                invoke2(vipProduct);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@k VipProduct vipProduct) {
                                VipPaymentMethodAdapter vipPaymentMethodAdapter;
                                VipPaymentMethodAdapter vipPaymentMethodAdapter2;
                                Intrinsics.checkNotNullParameter(vipProduct, "vipProduct");
                                VipPayDialogFragment.this.V0(vipProduct);
                                VipPayViewModel vipPayViewModel4 = VipPayDialogFragment.this.mViewModel;
                                VipPayViewModel vipPayViewModel5 = null;
                                if (vipPayViewModel4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                                    vipPayViewModel4 = null;
                                }
                                VipPayViewModel vipPayViewModel6 = VipPayDialogFragment.this.mViewModel;
                                if (vipPayViewModel6 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                                    vipPayViewModel6 = null;
                                }
                                if (!vipPayViewModel4.v0(vipPayViewModel6.getPaymentMethod())) {
                                    vipPaymentMethodAdapter = VipPayDialogFragment.this.paymentMethodAdapter;
                                    if (vipPaymentMethodAdapter != null) {
                                        vipPaymentMethodAdapter.notifyDataSetChanged();
                                        return;
                                    }
                                    return;
                                }
                                VipPayViewModel vipPayViewModel7 = VipPayDialogFragment.this.mViewModel;
                                if (vipPayViewModel7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                                    vipPayViewModel7 = null;
                                }
                                VipPayViewModel vipPayViewModel8 = VipPayDialogFragment.this.mViewModel;
                                if (vipPayViewModel8 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                                } else {
                                    vipPayViewModel5 = vipPayViewModel8;
                                }
                                vipPayViewModel7.l0(vipPayViewModel5.getPayMethodAlipay());
                                VipPayDialogFragment.this.V0(vipProduct);
                                vipPaymentMethodAdapter2 = VipPayDialogFragment.this.paymentMethodAdapter;
                                if (vipPaymentMethodAdapter2 != null) {
                                    vipPaymentMethodAdapter2.m();
                                }
                            }
                        });
                        fragmentVipPayDialogBinding2 = vipPayDialogFragment.mViewBinding;
                        if (fragmentVipPayDialogBinding2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                        } else {
                            fragmentVipPayDialogBinding3 = fragmentVipPayDialogBinding2;
                        }
                        RecyclerView recyclerView = fragmentVipPayDialogBinding3.vipComboRecyclerView;
                        vipProductAdapter = vipPayDialogFragment.productAdapter;
                        recyclerView.setAdapter(vipProductAdapter);
                        return;
                    }
                }
                fragmentVipPayDialogBinding = VipPayDialogFragment.this.mViewBinding;
                if (fragmentVipPayDialogBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                } else {
                    fragmentVipPayDialogBinding3 = fragmentVipPayDialogBinding;
                }
                LoadingTip loadingTip = fragmentVipPayDialogBinding3.vipComboLoadingTip;
                loadingTip.setLoadingTip(LoadingTip.LoadStatus.empty);
                loadingTip.setTips(ExtKt.c("未找到可用套餐"));
            }
        };
        O.observe(this, new Observer() { // from class: ad.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipPayDialogFragment.z0(Function1.this, obj);
            }
        });
        VipPayViewModel vipPayViewModel2 = this.mViewModel;
        if (vipPayViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel2 = null;
        }
        NonStickyLiveData<WXRechargeOrder> P = vipPayViewModel2.P();
        final Function1<WXRechargeOrder, Unit> function12 = new Function1<WXRechargeOrder, Unit>() { // from class: com.martian.mibook.mvvm.payment.fragment.VipPayDialogFragment$initialListener$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WXRechargeOrder wXRechargeOrder) {
                invoke2(wXRechargeOrder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@l WXRechargeOrder wXRechargeOrder) {
                FragmentVipPayDialogBinding fragmentVipPayDialogBinding;
                fragmentVipPayDialogBinding = VipPayDialogFragment.this.mViewBinding;
                VipPayViewModel vipPayViewModel3 = null;
                if (fragmentVipPayDialogBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    fragmentVipPayDialogBinding = null;
                }
                fragmentVipPayDialogBinding.vipOpenTextProgressbar.setVisibility(8);
                FragmentActivity activity = VipPayDialogFragment.this.getActivity();
                if (activity != null) {
                    VipPayDialogFragment vipPayDialogFragment = VipPayDialogFragment.this;
                    if (wXRechargeOrder == null) {
                        VipPayViewModel vipPayViewModel4 = vipPayDialogFragment.mViewModel;
                        if (vipPayViewModel4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                        } else {
                            vipPayViewModel3 = vipPayViewModel4;
                        }
                        vipPayViewModel3.h0(activity, "微信-创建订单失败");
                        t0.b(activity, ExtKt.c("创建订单失败"));
                        return;
                    }
                    VipPayViewModel vipPayViewModel5 = vipPayDialogFragment.mViewModel;
                    if (vipPayViewModel5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                        vipPayViewModel5 = null;
                    }
                    MiRechargeOrder miRechargeOrder = wXRechargeOrder.rechargeOrder;
                    vipPayViewModel5.h0(activity, "微信-" + (miRechargeOrder != null ? miRechargeOrder.money : null));
                    VipPayViewModel vipPayViewModel6 = vipPayDialogFragment.mViewModel;
                    if (vipPayViewModel6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                    } else {
                        vipPayViewModel3 = vipPayViewModel6;
                    }
                    vipPayViewModel3.u0(activity, wXRechargeOrder);
                }
            }
        };
        P.observe(this, new Observer() { // from class: ad.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipPayDialogFragment.A0(Function1.this, obj);
            }
        });
        VipPayViewModel vipPayViewModel3 = this.mViewModel;
        if (vipPayViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel3 = null;
        }
        NonStickyLiveData<AliRechargeOrder> I = vipPayViewModel3.I();
        final Function1<AliRechargeOrder, Unit> function13 = new Function1<AliRechargeOrder, Unit>() { // from class: com.martian.mibook.mvvm.payment.fragment.VipPayDialogFragment$initialListener$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AliRechargeOrder aliRechargeOrder) {
                invoke2(aliRechargeOrder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@l AliRechargeOrder aliRechargeOrder) {
                FragmentVipPayDialogBinding fragmentVipPayDialogBinding;
                fragmentVipPayDialogBinding = VipPayDialogFragment.this.mViewBinding;
                VipPayViewModel vipPayViewModel4 = null;
                if (fragmentVipPayDialogBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    fragmentVipPayDialogBinding = null;
                }
                fragmentVipPayDialogBinding.vipOpenTextProgressbar.setVisibility(8);
                FragmentActivity activity = VipPayDialogFragment.this.getActivity();
                if (activity != null) {
                    VipPayDialogFragment vipPayDialogFragment = VipPayDialogFragment.this;
                    if (aliRechargeOrder == null) {
                        VipPayViewModel vipPayViewModel5 = vipPayDialogFragment.mViewModel;
                        if (vipPayViewModel5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                        } else {
                            vipPayViewModel4 = vipPayViewModel5;
                        }
                        vipPayViewModel4.h0(activity, "支付宝-创建订单失败");
                        t0.b(activity, ExtKt.c("创建订单失败"));
                        return;
                    }
                    VipPayViewModel vipPayViewModel6 = vipPayDialogFragment.mViewModel;
                    if (vipPayViewModel6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                        vipPayViewModel6 = null;
                    }
                    MiRechargeOrder miRechargeOrder = aliRechargeOrder.rechargeOrder;
                    vipPayViewModel6.h0(activity, "支付宝-" + (miRechargeOrder != null ? miRechargeOrder.money : null));
                    VipPayViewModel vipPayViewModel7 = vipPayDialogFragment.mViewModel;
                    if (vipPayViewModel7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                    } else {
                        vipPayViewModel4 = vipPayViewModel7;
                    }
                    vipPayViewModel4.t0(activity, aliRechargeOrder);
                }
            }
        };
        I.observe(this, new Observer() { // from class: ad.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipPayDialogFragment.B0(Function1.this, obj);
            }
        });
        VipPayViewModel vipPayViewModel4 = this.mViewModel;
        if (vipPayViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel4 = null;
        }
        NonStickyLiveData<Unit> M = vipPayViewModel4.M();
        final VipPayDialogFragment$initialListener$4 vipPayDialogFragment$initialListener$4 = new VipPayDialogFragment$initialListener$4(this);
        M.observe(this, new Observer() { // from class: ad.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipPayDialogFragment.t0(Function1.this, obj);
            }
        });
        VipPayViewModel vipPayViewModel5 = this.mViewModel;
        if (vipPayViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel5 = null;
        }
        NonStickyLiveData<Unit> N = vipPayViewModel5.N();
        final Function1<Unit, Unit> function14 = new Function1<Unit, Unit>() { // from class: com.martian.mibook.mvvm.payment.fragment.VipPayDialogFragment$initialListener$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@l Unit unit) {
                AlertDialog alertDialog;
                alertDialog = VipPayDialogFragment.this.payStatusDialog;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                VipPayDialogFragment.p0(VipPayDialogFragment.this, false, 1, null);
            }
        };
        N.observe(this, new Observer() { // from class: ad.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipPayDialogFragment.u0(Function1.this, obj);
            }
        });
        VipPayViewModel vipPayViewModel6 = this.mViewModel;
        if (vipPayViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel6 = null;
        }
        NonStickyLiveData<Unit> J = vipPayViewModel6.J();
        final Function1<Unit, Unit> function15 = new Function1<Unit, Unit>() { // from class: com.martian.mibook.mvvm.payment.fragment.VipPayDialogFragment$initialListener$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@l Unit unit) {
                AlertDialog alertDialog;
                alertDialog = VipPayDialogFragment.this.payStatusDialog;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                VipPayDialogFragment.this.T0(Boolean.FALSE);
                t0.b(VipPayDialogFragment.this.getActivity(), ExtKt.c("充值取消"));
            }
        };
        J.observe(this, new Observer() { // from class: ad.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipPayDialogFragment.v0(Function1.this, obj);
            }
        });
        VipPayViewModel vipPayViewModel7 = this.mViewModel;
        if (vipPayViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel7 = null;
        }
        NonStickyLiveData<String> K = vipPayViewModel7.K();
        final Function1<String, Unit> function16 = new Function1<String, Unit>() { // from class: com.martian.mibook.mvvm.payment.fragment.VipPayDialogFragment$initialListener$7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@l String str) {
                AlertDialog alertDialog;
                alertDialog = VipPayDialogFragment.this.payStatusDialog;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                VipPayDialogFragment.this.T0(Boolean.FALSE);
                t0.b(VipPayDialogFragment.this.getActivity(), ExtKt.c("充值出错:" + str));
            }
        };
        K.observe(this, new Observer() { // from class: ad.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipPayDialogFragment.w0(Function1.this, obj);
            }
        });
        VipPayViewModel vipPayViewModel8 = this.mViewModel;
        if (vipPayViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel8 = null;
        }
        NonStickyLiveData<Boolean> L = vipPayViewModel8.L();
        final Function1<Boolean, Unit> function17 = new Function1<Boolean, Unit>() { // from class: com.martian.mibook.mvvm.payment.fragment.VipPayDialogFragment$initialListener$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                FragmentVipPayDialogBinding fragmentVipPayDialogBinding;
                AppViewModel r02;
                AppViewModel r03;
                fragmentVipPayDialogBinding = VipPayDialogFragment.this.mViewBinding;
                if (fragmentVipPayDialogBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    fragmentVipPayDialogBinding = null;
                }
                fragmentVipPayDialogBinding.vipOrderProgressbar.setVisibility(8);
                r02 = VipPayDialogFragment.this.r0();
                if (r02 != null) {
                    r02.F0(true);
                }
                r03 = VipPayDialogFragment.this.r0();
                if (r03 != null) {
                    AppViewModel.m0(r03, false, 1, null);
                }
                VipPayDialogFragment.this.T0(Boolean.valueOf(!bool.booleanValue()));
            }
        };
        L.observe(this, new Observer() { // from class: ad.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipPayDialogFragment.x0(Function1.this, obj);
            }
        });
        AppViewModel r02 = r0();
        if (r02 != null && (Y = r02.Y()) != null) {
            final Function1<MartianRPAccount, Unit> function18 = new Function1<MartianRPAccount, Unit>() { // from class: com.martian.mibook.mvvm.payment.fragment.VipPayDialogFragment$initialListener$9
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MartianRPAccount martianRPAccount) {
                    invoke2(martianRPAccount);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@l MartianRPAccount martianRPAccount) {
                    VipPayDialogFragment.this.Y0();
                    VipPayViewModel vipPayViewModel9 = VipPayDialogFragment.this.mViewModel;
                    VipPayViewModel vipPayViewModel10 = null;
                    if (vipPayViewModel9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                        vipPayViewModel9 = null;
                    }
                    VipProduct currentVipProduct = vipPayViewModel9.getCurrentVipProduct();
                    if (currentVipProduct != null) {
                        VipPayDialogFragment.this.V0(currentVipProduct);
                    }
                    if (MiConfigSingleton.b2().K2()) {
                        VipPayViewModel vipPayViewModel11 = VipPayDialogFragment.this.mViewModel;
                        if (vipPayViewModel11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                            vipPayViewModel11 = null;
                        }
                        if (vipPayViewModel11.getPaymentStatus() == 2) {
                            VipPayViewModel vipPayViewModel12 = VipPayDialogFragment.this.mViewModel;
                            if (vipPayViewModel12 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                                vipPayViewModel12 = null;
                            }
                            vipPayViewModel12.m0(0);
                            VipPayDialogFragment.this.T0(Boolean.FALSE);
                            VipPayViewModel vipPayViewModel13 = VipPayDialogFragment.this.mViewModel;
                            if (vipPayViewModel13 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                            } else {
                                vipPayViewModel10 = vipPayViewModel13;
                            }
                            vipPayViewModel10.h0(VipPayDialogFragment.this.getActivity(), "成功弹窗");
                            FragmentActivity activity = VipPayDialogFragment.this.getActivity();
                            if (activity != null) {
                                od.k.r(activity, false);
                            }
                        }
                    }
                }
            };
            Y.observe(this, new Observer() { // from class: ad.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    VipPayDialogFragment.y0(Function1.this, obj);
                }
            });
        }
        VipPayViewModel vipPayViewModel9 = this.mViewModel;
        if (vipPayViewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            vipPayViewModel9 = null;
        }
        vipPayViewModel9.Z();
        AppViewModel r03 = r0();
        if (r03 != null) {
            AppViewModel.m0(r03, false, 1, null);
        }
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment
    public void u(@k View bottomSheet, int newState) {
        AppViewModel r02;
        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        super.u(bottomSheet, newState);
        if ((newState == 4 || newState == 5) && (r02 = r0()) != null) {
            r02.C0();
        }
    }
}
