package com.martian.mibook.mvvm.ui.dilaog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.d;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment;
import com.martian.libmars.widget.dialog.a;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.DialogActivateVipBinding;
import com.martian.mibook.lib.account.request.VipLinkParams;
import com.martian.mibook.mvvm.ui.dilaog.ActivateVipDialogFragment;
import com.martian.mibook.mvvm.ui.fragment.MiWebViewFragment;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lc.b;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001d\u0010%\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/martian/mibook/mvvm/ui/dilaog/ActivateVipDialogFragment;", "Lcom/martian/libmars/widget/dialog/MartianBottomSheetDialogFragment;", "<init>", "()V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "p", "(Landroid/view/View;)Landroid/view/View;", t.f11211k, "(Landroid/view/View;)V", "bottomSheet", "", "newState", "u", "(Landroid/view/View;I)V", "", "isRefreshWebView", "M", "(Z)V", "Lcom/martian/mibook/databinding/DialogActivateVipBinding;", "f", "Lcom/martian/mibook/databinding/DialogActivateVipBinding;", "binding", "Lcom/martian/mibook/mvvm/ui/fragment/MiWebViewFragment;", "g", "Lcom/martian/mibook/mvvm/ui/fragment/MiWebViewFragment;", "fragment", "Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "h", "Lkotlin/Lazy;", "H", "()Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "appViewModel", "i", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ActivateVipDialogFragment extends MartianBottomSheetDialogFragment {

    /* renamed from: i, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: j */
    @k
    public static final String f15213j = "ActivateVip";

    /* renamed from: k */
    @k
    public static final String f15214k = "sourceName";

    /* renamed from: l */
    @k
    public static final String f15215l = "sourceId";

    /* renamed from: m */
    @k
    public static final String f15216m = "openPath";

    /* renamed from: f, reason: from kotlin metadata */
    @l
    public DialogActivateVipBinding binding;

    /* renamed from: g, reason: from kotlin metadata */
    @l
    public MiWebViewFragment fragment;

    /* renamed from: h, reason: from kotlin metadata */
    @k
    public final Lazy appViewModel = LazyKt.lazy(new Function0<AppViewModel>() { // from class: com.martian.mibook.mvvm.ui.dilaog.ActivateVipDialogFragment$appViewModel$2
        public ActivateVipDialogFragment$appViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @l
        public final AppViewModel invoke() {
            return b.a(ActivateVipDialogFragment.this.getContext());
        }
    });

    /* renamed from: com.martian.mibook.mvvm.ui.dilaog.ActivateVipDialogFragment$a, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: com.martian.mibook.mvvm.ui.dilaog.ActivateVipDialogFragment$a$a */
        public static final class C0543a implements MartianBottomSheetDialogFragment.b {
            @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.b
            public void a(@k DialogFragment dialogFragment) {
                Intrinsics.checkNotNullParameter(dialogFragment, "dialogFragment");
                boolean A0 = MiConfigSingleton.b2().A0();
                d.y3(dialogFragment).W0(BarHide.FLAG_HIDE_NAVIGATION_BAR).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@k FragmentActivity activity, @l String str, @l String str2, @l String str3) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
            a10.k0(true).j0(true).n0(ConfigSingleton.i(468.0f)).q0(ConfigSingleton.i(16.0f)).s0(new C0543a());
            ActivateVipDialogFragment activateVipDialogFragment = new ActivateVipDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("sourceName", str2);
            bundle.putString("sourceId", str3);
            bundle.putString("openPath", str);
            activateVipDialogFragment.setArguments(bundle);
            a10.c0(activity, activateVipDialogFragment, "ActivateVip", true);
        }

        public Companion() {
        }
    }

    public static final class b implements MiWebViewFragment.b {

        /* renamed from: b */
        public final /* synthetic */ String f15221b;

        public b(String str) {
            this.f15221b = str;
        }

        @Override // com.martian.mibook.mvvm.ui.fragment.MiWebViewFragment.b
        public boolean a() {
            return false;
        }

        @Override // com.martian.mibook.mvvm.ui.fragment.MiWebViewFragment.b
        public void b(@l WebView webView, @l String str) {
            if (Intrinsics.areEqual(this.f15221b, webView != null ? webView.getUrl() : null)) {
                return;
            }
            DialogActivateVipBinding dialogActivateVipBinding = ActivateVipDialogFragment.this.binding;
            ThemeTextView themeTextView = dialogActivateVipBinding != null ? dialogActivateVipBinding.tvTitle : null;
            if (themeTextView == null) {
                return;
            }
            themeTextView.setText(str);
        }

        @Override // com.martian.mibook.mvvm.ui.fragment.MiWebViewFragment.b
        public void close() {
            ActivateVipDialogFragment.this.dismiss();
        }
    }

    private final AppViewModel H() {
        return (AppViewModel) this.appViewModel.getValue();
    }

    public static final void I(ActivateVipDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void K(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void N(ActivateVipDialogFragment activateVipDialogFragment, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        activateVipDialogFragment.M(z10);
    }

    @JvmStatic
    public static final void O(@k FragmentActivity fragmentActivity, @l String str, @l String str2, @l String str3) {
        INSTANCE.a(fragmentActivity, str, str2, str3);
    }

    public final void M(boolean isRefreshWebView) {
        MiWebViewFragment miWebViewFragment;
        ThemeImageView themeImageView;
        ThemeTextView themeTextView;
        ThemeImageView themeImageView2;
        ThemeLinearLayout root;
        ThemeImageView themeImageView3;
        ThemeTextView themeTextView2;
        ThemeImageView themeImageView4;
        ThemeLinearLayout root2;
        boolean s10 = MiConfigSingleton.b2().h2().s();
        Context context = getContext();
        if (context != null) {
            if (s10) {
                DialogActivateVipBinding dialogActivateVipBinding = this.binding;
                if (dialogActivateVipBinding != null && (root2 = dialogActivateVipBinding.getRoot()) != null) {
                    root2.setBackgroundResource(R.drawable.border_background_top_round_card_night_12dp);
                }
                DialogActivateVipBinding dialogActivateVipBinding2 = this.binding;
                if (dialogActivateVipBinding2 != null && (themeImageView4 = dialogActivateVipBinding2.timingWindowClose) != null) {
                    themeImageView4.setColorFilter(ContextCompat.getColor(context, R.color.night_item_color_primary));
                }
                DialogActivateVipBinding dialogActivateVipBinding3 = this.binding;
                if (dialogActivateVipBinding3 != null && (themeTextView2 = dialogActivateVipBinding3.tvTitle) != null) {
                    themeTextView2.setTextColor(ContextCompat.getColor(context, R.color.night_item_color_primary));
                }
                DialogActivateVipBinding dialogActivateVipBinding4 = this.binding;
                if (dialogActivateVipBinding4 != null && (themeImageView3 = dialogActivateVipBinding4.ivTopLine) != null) {
                    themeImageView3.setBackgroundResource(R.drawable.bg_divider_line_top_night);
                }
            } else {
                DialogActivateVipBinding dialogActivateVipBinding5 = this.binding;
                if (dialogActivateVipBinding5 != null && (root = dialogActivateVipBinding5.getRoot()) != null) {
                    root.setBackgroundResource(R.drawable.border_background_top_round_card_day_12dp);
                }
                DialogActivateVipBinding dialogActivateVipBinding6 = this.binding;
                if (dialogActivateVipBinding6 != null && (themeImageView2 = dialogActivateVipBinding6.timingWindowClose) != null) {
                    themeImageView2.setColorFilter(ContextCompat.getColor(context, R.color.day_item_color_primary));
                }
                DialogActivateVipBinding dialogActivateVipBinding7 = this.binding;
                if (dialogActivateVipBinding7 != null && (themeTextView = dialogActivateVipBinding7.tvTitle) != null) {
                    themeTextView.setTextColor(ContextCompat.getColor(context, R.color.day_text_color_primary));
                }
                DialogActivateVipBinding dialogActivateVipBinding8 = this.binding;
                if (dialogActivateVipBinding8 != null && (themeImageView = dialogActivateVipBinding8.ivTopLine) != null) {
                    themeImageView.setBackgroundResource(R.drawable.bg_divider_line_top);
                }
            }
        }
        if (!isRefreshWebView || (miWebViewFragment = this.fragment) == null) {
            return;
        }
        miWebViewFragment.V1(s10);
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
        View inflate = LayoutInflater.from(getContext()).inflate(com.martian.mibook.R.layout.dialog_activate_vip, (ViewGroup) null);
        this.binding = DialogActivateVipBinding.bind(inflate);
        return inflate;
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment
    public void r(@k View view) {
        MutableLiveData<Unit> h02;
        ThemeImageView themeImageView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.r(view);
        DialogActivateVipBinding dialogActivateVipBinding = this.binding;
        if (dialogActivateVipBinding != null && (themeImageView = dialogActivateVipBinding.timingWindowClose) != null) {
            themeImageView.setOnClickListener(new View.OnClickListener() { // from class: od.a
                public /* synthetic */ a() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ActivateVipDialogFragment.I(ActivateVipDialogFragment.this, view2);
                }
            });
        }
        AppViewModel H = H();
        if (H != null && (h02 = H.h0()) != null) {
            h02.observe(this, new Observer() { // from class: od.b
                public /* synthetic */ b() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ActivateVipDialogFragment.K(Function1.this, obj);
                }
            });
        }
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
        VipLinkParams vipLinkParams = new VipLinkParams();
        vipLinkParams.setNight_mode(Boolean.valueOf(MiConfigSingleton.b2().h2().s()));
        vipLinkParams.setNotchHeight(0);
        vipLinkParams.setHideNaviBar(0);
        vipLinkParams.setDialog(Boolean.TRUE);
        vipLinkParams.setEnableGuest(Boolean.valueOf(!MiConfigSingleton.b2().C2()));
        Bundle arguments = getArguments();
        vipLinkParams.setSource(arguments != null ? arguments.getString("openPath", "听书") : null);
        Bundle arguments2 = getArguments();
        vipLinkParams.setSourceName(arguments2 != null ? arguments2.getString("sourceName", "") : null);
        Bundle arguments3 = getArguments();
        vipLinkParams.setSourceId(arguments3 != null ? arguments3.getString("sourceId", "") : null);
        String httpUrl = vipLinkParams.toHttpUrl(z5.k.f33694e);
        MiWebViewFragment b10 = MiWebViewFragment.INSTANCE.b(httpUrl, false, Integer.valueOf(ConfigSingleton.i(416.0f)));
        this.fragment = b10;
        if (b10 != null) {
            b10.p2(new b(httpUrl));
            beginTransaction.replace(com.martian.mibook.R.id.fragment_container, b10);
            beginTransaction.commit();
        }
        M(false);
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment
    public void u(@k View bottomSheet, int newState) {
        AppViewModel H;
        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        super.u(bottomSheet, newState);
        if ((newState == 4 || newState == 5) && (H = H()) != null) {
            H.C0();
        }
    }
}
