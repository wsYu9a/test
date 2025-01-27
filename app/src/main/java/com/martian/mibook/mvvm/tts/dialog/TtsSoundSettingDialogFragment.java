package com.martian.mibook.mvvm.tts.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import com.gyf.immersionbar.d;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment;
import com.martian.libmars.widget.dialog.a;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.DialogTtsSoundSettingBinding;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.tts.TtsEnginesUtil;
import com.martian.mibook.mvvm.tts.dialog.TtsSoundSettingDialogFragment;
import com.martian.mibook.mvvm.tts.viewmodel.AudiobookViewModel;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.rpauth.response.MartianRPAccount;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import l9.t0;
import lc.b;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0006\u0010\u0003J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0003¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u000b\u0010\u0003J\u0019\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\fH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0017¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010 \u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/martian/mibook/mvvm/tts/dialog/TtsSoundSettingDialogFragment;", "Lcom/martian/libmars/widget/dialog/MartianBottomSheetDialogFragment;", "<init>", "()V", "", ExifInterface.GPS_DIRECTION_TRUE, "b0", "", "percent", "d0", "(Ljava/lang/Integer;)V", "a0", "Landroid/view/View;", "view", "p", "(Landroid/view/View;)Landroid/view/View;", t.f11211k, "(Landroid/view/View;)V", "Lcom/martian/mibook/databinding/DialogTtsSoundSettingBinding;", "f", "Lcom/martian/mibook/databinding/DialogTtsSoundSettingBinding;", "binding", "Lcom/martian/mibook/mvvm/tts/viewmodel/AudiobookViewModel;", "g", "Lkotlin/Lazy;", ExifInterface.LATITUDE_SOUTH, "()Lcom/martian/mibook/mvvm/tts/viewmodel/AudiobookViewModel;", "mViewModel", "Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "h", "R", "()Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "appViewModel", "i", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class TtsSoundSettingDialogFragment extends MartianBottomSheetDialogFragment {

    /* renamed from: i, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: from kotlin metadata */
    @l
    public DialogTtsSoundSettingBinding binding;

    /* renamed from: g, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel = LazyKt.lazy(new Function0<AudiobookViewModel>() { // from class: com.martian.mibook.mvvm.tts.dialog.TtsSoundSettingDialogFragment$mViewModel$2
        public TtsSoundSettingDialogFragment$mViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @l
        public final AudiobookViewModel invoke() {
            FragmentActivity activity = TtsSoundSettingDialogFragment.this.getActivity();
            if (activity == null) {
                return null;
            }
            return (AudiobookViewModel) new ViewModelProvider(activity).get(AudiobookViewModel.class);
        }
    });

    /* renamed from: h, reason: from kotlin metadata */
    @k
    public final Lazy appViewModel = LazyKt.lazy(new Function0<AppViewModel>() { // from class: com.martian.mibook.mvvm.tts.dialog.TtsSoundSettingDialogFragment$appViewModel$2
        public TtsSoundSettingDialogFragment$appViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @l
        public final AppViewModel invoke() {
            return b.a(TtsSoundSettingDialogFragment.this.getContext());
        }
    });

    /* renamed from: com.martian.mibook.mvvm.tts.dialog.TtsSoundSettingDialogFragment$a, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: com.martian.mibook.mvvm.tts.dialog.TtsSoundSettingDialogFragment$a$a */
        public static final class C0541a implements MartianBottomSheetDialogFragment.b {
            @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.b
            public void a(@k DialogFragment dialogFragment) {
                Intrinsics.checkNotNullParameter(dialogFragment, "dialogFragment");
                boolean A0 = MiConfigSingleton.b2().A0();
                d.y3(dialogFragment).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @k
        public final TtsSoundSettingDialogFragment a(@k FragmentActivity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
            TtsSoundSettingDialogFragment ttsSoundSettingDialogFragment = new TtsSoundSettingDialogFragment();
            a10.k0(true).j0(true).w0(true).s0(new C0541a());
            a10.c0(activity, ttsSoundSettingDialogFragment, "TtsSoundSettingDialogFragment", true);
            return ttsSoundSettingDialogFragment;
        }

        public Companion() {
        }
    }

    public final AppViewModel R() {
        return (AppViewModel) this.appViewModel.getValue();
    }

    private final void T() {
        NonStickyLiveData<MartianRPAccount> Y;
        NonStickyLiveData<Pair<Integer, Object>> S;
        ThemeLinearLayout themeLinearLayout;
        ThemeLinearLayout themeLinearLayout2;
        ThemeImageView themeImageView;
        DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding = this.binding;
        if (dialogTtsSoundSettingBinding != null && (themeImageView = dialogTtsSoundSettingBinding.ivClose) != null) {
            themeImageView.setOnClickListener(new View.OnClickListener() { // from class: ld.c
                public /* synthetic */ c() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TtsSoundSettingDialogFragment.U(TtsSoundSettingDialogFragment.this, view);
                }
            });
        }
        DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding2 = this.binding;
        if (dialogTtsSoundSettingBinding2 != null && (themeLinearLayout2 = dialogTtsSoundSettingBinding2.modifyVoiceSetting) != null) {
            themeLinearLayout2.setOnClickListener(new View.OnClickListener() { // from class: ld.d
                public /* synthetic */ d() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TtsSoundSettingDialogFragment.W(TtsSoundSettingDialogFragment.this, view);
                }
            });
        }
        DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding3 = this.binding;
        if (dialogTtsSoundSettingBinding3 != null && (themeLinearLayout = dialogTtsSoundSettingBinding3.replaceVoicePlugin) != null) {
            themeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: ld.e
                public /* synthetic */ e() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TtsSoundSettingDialogFragment.X(TtsSoundSettingDialogFragment.this, view);
                }
            });
        }
        AppViewModel R = R();
        if (R != null && (S = R.S()) != null) {
            S.observe(this, new Observer() { // from class: ld.f
                public /* synthetic */ f() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TtsSoundSettingDialogFragment.Y(Function1.this, obj);
                }
            });
        }
        AppViewModel R2 = R();
        if (R2 == null || (Y = R2.Y()) == null) {
            return;
        }
        Y.observe(this, new Observer() { // from class: ld.g
            public /* synthetic */ g() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TtsSoundSettingDialogFragment.Z(Function1.this, obj);
            }
        });
    }

    public static final void U(TtsSoundSettingDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void W(TtsSoundSettingDialogFragment this$0, View view) {
        AudiobookViewModel S;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null) {
            if (TtsEnginesUtil.f15062a.e(context)) {
                TtsEnginesUtil.k(context, TtsEnginesUtil.EngineMode.SYSTEM);
                if (!Intrinsics.areEqual(TtsEnginesUtil.f15064c, TtsEnginesUtil.a(context)) && (S = this$0.S()) != null) {
                    S.C(context);
                }
            } else {
                TtsEnginesUtil.m(context);
            }
            this$0.a0();
        }
    }

    public static final void X(TtsSoundSettingDialogFragment this$0, View view) {
        AudiobookViewModel S;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            if (TtsEnginesUtil.f15062a.e(activity)) {
                TtsEnginesUtil.l(activity);
                t0.a(this$0.getContext(), ExtKt.c("滑动到最底部设置声音"));
            } else if (TtsEnginesUtil.i(activity)) {
                AppViewModel R = this$0.R();
                if (R != null) {
                    R.I0();
                }
                TtsEnginesUtil.k(activity, TtsEnginesUtil.EngineMode.GOOGLE);
                if (!Intrinsics.areEqual(TtsEnginesUtil.f15064c, TtsEnginesUtil.a(activity)) && (S = this$0.S()) != null) {
                    S.C(activity);
                }
            } else {
                AudiobookViewModel S2 = this$0.S();
                if (S2 != null) {
                    S2.I(Boolean.valueOf(MiConfigSingleton.b2().K2()));
                }
                DownloadTtsEngineDialogFragment.INSTANCE.a(activity, this$0.R(), new Function0<Unit>() { // from class: com.martian.mibook.mvvm.tts.dialog.TtsSoundSettingDialogFragment$initListener$3$1$1
                    public TtsSoundSettingDialogFragment$initListener$3$1$1() {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke */
                    public final void invoke2() {
                        TtsSoundSettingDialogFragment.this.dismiss();
                    }
                });
            }
            this$0.a0();
        }
    }

    public static final void Y(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Z(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @SuppressLint({"SetTextI18n"})
    public final void a0() {
        ImageView imageView;
        ThemeLinearLayout themeLinearLayout;
        ThemeLinearLayout themeLinearLayout2;
        ThemeLinearLayout themeLinearLayout3;
        ThemeLinearLayout themeLinearLayout4;
        Context context = getContext();
        if (context != null) {
            if (TtsEnginesUtil.f15062a.e(context)) {
                DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding = this.binding;
                TextView textView = dialogTtsSoundSettingBinding != null ? dialogTtsSoundSettingBinding.tvContent : null;
                if (textView != null) {
                    textView.setText(ExtKt.c("使用Google语音插件"));
                }
                DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding2 = this.binding;
                ImageView imageView2 = dialogTtsSoundSettingBinding2 != null ? dialogTtsSoundSettingBinding2.ivVip : null;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
                DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding3 = this.binding;
                TextView textView2 = dialogTtsSoundSettingBinding3 != null ? dialogTtsSoundSettingBinding3.tvDownload : null;
                if (textView2 != null) {
                    textView2.setText(ExtKt.c("去设置"));
                }
                DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding4 = this.binding;
                ImageView imageView3 = dialogTtsSoundSettingBinding4 != null ? dialogTtsSoundSettingBinding4.ivGoSetting : null;
                if (imageView3 != null) {
                    imageView3.setVisibility(0);
                }
                DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding5 = this.binding;
                TextView textView3 = dialogTtsSoundSettingBinding5 != null ? dialogTtsSoundSettingBinding5.tvSetting : null;
                if (textView3 != null) {
                    textView3.setText(ExtKt.c("立即使用"));
                }
                DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding6 = this.binding;
                ImageView imageView4 = dialogTtsSoundSettingBinding6 != null ? dialogTtsSoundSettingBinding6.tvSettingMore : null;
                if (imageView4 != null) {
                    imageView4.setVisibility(8);
                }
                DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding7 = this.binding;
                imageView = dialogTtsSoundSettingBinding7 != null ? dialogTtsSoundSettingBinding7.ivVip : null;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding8 = this.binding;
                if (dialogTtsSoundSettingBinding8 != null && (themeLinearLayout4 = dialogTtsSoundSettingBinding8.modifyVoiceSetting) != null) {
                    themeLinearLayout4.setBackgroundResource(R.color.day_text_color_thirdly_alpha10);
                }
                DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding9 = this.binding;
                if (dialogTtsSoundSettingBinding9 == null || (themeLinearLayout3 = dialogTtsSoundSettingBinding9.replaceVoicePlugin) == null) {
                    return;
                }
                themeLinearLayout3.setBackgroundResource(com.martian.mibook.R.drawable.bg_gender_guide_male);
                return;
            }
            DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding10 = this.binding;
            if (dialogTtsSoundSettingBinding10 != null && (themeLinearLayout2 = dialogTtsSoundSettingBinding10.modifyVoiceSetting) != null) {
                themeLinearLayout2.setBackgroundResource(com.martian.mibook.R.drawable.bg_gender_guide_male);
            }
            DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding11 = this.binding;
            if (dialogTtsSoundSettingBinding11 != null && (themeLinearLayout = dialogTtsSoundSettingBinding11.replaceVoicePlugin) != null) {
                themeLinearLayout.setBackgroundResource(R.color.day_text_color_thirdly_alpha10);
            }
            if (TtsEnginesUtil.i(context)) {
                AppViewModel R = R();
                if (R != null) {
                    R.I0();
                }
                DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding12 = this.binding;
                TextView textView4 = dialogTtsSoundSettingBinding12 != null ? dialogTtsSoundSettingBinding12.tvContent : null;
                if (textView4 != null) {
                    textView4.setText(ExtKt.c("使用Google语音插件"));
                }
                DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding13 = this.binding;
                TextView textView5 = dialogTtsSoundSettingBinding13 != null ? dialogTtsSoundSettingBinding13.tvDownload : null;
                if (textView5 != null) {
                    textView5.setText(ExtKt.c("立即使用"));
                }
                DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding14 = this.binding;
                ImageView imageView5 = dialogTtsSoundSettingBinding14 != null ? dialogTtsSoundSettingBinding14.ivGoSetting : null;
                if (imageView5 != null) {
                    imageView5.setVisibility(8);
                }
                DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding15 = this.binding;
                ImageView imageView6 = dialogTtsSoundSettingBinding15 != null ? dialogTtsSoundSettingBinding15.ivVip : null;
                if (imageView6 != null) {
                    imageView6.setVisibility(8);
                }
            } else {
                DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding16 = this.binding;
                TextView textView6 = dialogTtsSoundSettingBinding16 != null ? dialogTtsSoundSettingBinding16.tvContent : null;
                if (textView6 != null) {
                    textView6.setText(ExtKt.c("安装Google语音插件"));
                }
                DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding17 = this.binding;
                ImageView imageView7 = dialogTtsSoundSettingBinding17 != null ? dialogTtsSoundSettingBinding17.ivGoSetting : null;
                if (imageView7 != null) {
                    imageView7.setVisibility(8);
                }
                DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding18 = this.binding;
                ImageView imageView8 = dialogTtsSoundSettingBinding18 != null ? dialogTtsSoundSettingBinding18.ivVip : null;
                if (imageView8 != null) {
                    imageView8.setVisibility(0);
                }
                if (DownloadTtsEngineDialogFragment.INSTANCE.d()) {
                    DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding19 = this.binding;
                    TextView textView7 = dialogTtsSoundSettingBinding19 != null ? dialogTtsSoundSettingBinding19.tvDownload : null;
                    if (textView7 != null) {
                        textView7.setText(ExtKt.c("点击安装"));
                    }
                } else {
                    DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding20 = this.binding;
                    TextView textView8 = dialogTtsSoundSettingBinding20 != null ? dialogTtsSoundSettingBinding20.tvDownload : null;
                    if (textView8 != null) {
                        textView8.setText(ExtKt.c("点击下载"));
                    }
                }
            }
            DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding21 = this.binding;
            TextView textView9 = dialogTtsSoundSettingBinding21 != null ? dialogTtsSoundSettingBinding21.tvSetting : null;
            if (textView9 != null) {
                textView9.setText(ExtKt.c("去设置"));
            }
            DialogTtsSoundSettingBinding dialogTtsSoundSettingBinding22 = this.binding;
            imageView = dialogTtsSoundSettingBinding22 != null ? dialogTtsSoundSettingBinding22.tvSettingMore : null;
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(0);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void b0() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(o()), Dispatchers.getMain(), null, new TtsSoundSettingDialogFragment$setDownloadFinished$1(this, null), 2, null);
    }

    @SuppressLint({"SetTextI18n"})
    public final void d0(Integer percent) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(o()), Dispatchers.getMain(), null, new TtsSoundSettingDialogFragment$setDownloadProgress$1(this, percent, null), 2, null);
    }

    @JvmStatic
    @k
    public static final TtsSoundSettingDialogFragment e0(@k FragmentActivity fragmentActivity) {
        return INSTANCE.a(fragmentActivity);
    }

    public final AudiobookViewModel S() {
        return (AudiobookViewModel) this.mViewModel.getValue();
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment
    @l
    @SuppressLint({"InflateParams", "ClickableViewAccessibility"})
    public View p(@k View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View inflate = LayoutInflater.from(getContext()).inflate(com.martian.mibook.R.layout.dialog_tts_sound_setting, (ViewGroup) null);
        this.binding = DialogTtsSoundSettingBinding.bind(inflate);
        T();
        return inflate;
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment
    @SuppressLint({"SetTextI18n"})
    public void r(@k View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.r(view);
        a0();
    }
}
