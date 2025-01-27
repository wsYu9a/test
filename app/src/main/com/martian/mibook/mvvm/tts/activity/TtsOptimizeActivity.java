package com.martian.mibook.mvvm.tts.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelKt;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.martian.libmars.databinding.LayoutToolbarBinding;
import com.martian.mibook.R;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ActivityTtsOptimizeBinding;
import com.martian.mibook.databinding.TtsSettingItemBinding;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.tts.TtsEnginesUtil;
import com.martian.mibook.mvvm.tts.activity.TtsOptimizeActivity;
import com.martian.mibook.mvvm.tts.dialog.DownloadTtsEngineDialogFragment;
import com.martian.mibook.mvvm.tts.viewmodel.AudiobookViewModel;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import java.util.List;
import je.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import l9.t0;
import xi.k;
import xi.l;

@Route(path = kc.a.f27758n)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0019\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0017¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0014\u0010\u0005J)\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0005J\u000f\u0010\u001c\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u001c\u0010\u0005J\u001d\u0010 \u001a\u00020\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0003¢\u0006\u0004\b \u0010!R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/martian/mibook/mvvm/tts/activity/TtsOptimizeActivity;", "Lcom/martian/mibook/mvvm/base/BaseMVVMActivity;", "Lcom/martian/mibook/databinding/ActivityTtsOptimizeBinding;", "Lcom/martian/mibook/mvvm/tts/viewmodel/AudiobookViewModel;", "<init>", "()V", "", "S1", "", "percent", "T1", "(Ljava/lang/Integer;)V", "Lcom/martian/libmars/databinding/LayoutToolbarBinding;", "toolbarBinding", "s1", "(Lcom/martian/libmars/databinding/LayoutToolbarBinding;)V", "Landroid/os/Bundle;", "savedInstanceState", "c1", "(Landroid/os/Bundle;)V", "onResume", "requestCode", "resultCode", "Landroid/content/Intent;", h3.e.f26408m, "onActivityResult", "(IILandroid/content/Intent;)V", "U1", "R1", "", "Lae/b;", "intentWrapperList", "X1", "(Ljava/util/List;)V", "", "h", "Lkotlin/Lazy;", "O1", "()Ljava/lang/String;", "tutorialUrl", "i", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class TtsOptimizeActivity extends BaseMVVMActivity<ActivityTtsOptimizeBinding, AudiobookViewModel> {

    /* renamed from: j */
    public static final int f15111j = 1025;

    /* renamed from: k */
    public static final int f15112k = 1001;

    /* renamed from: h, reason: from kotlin metadata */
    @k
    public final Lazy tutorialUrl = LazyKt.lazy(TtsOptimizeActivity$tutorialUrl$2.INSTANCE);

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ActivityTtsOptimizeBinding K1(TtsOptimizeActivity ttsOptimizeActivity) {
        return (ActivityTtsOptimizeBinding) ttsOptimizeActivity.a1();
    }

    public static final void P1(TtsOptimizeActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.W(this$0.getApplicationContext(), "听书中断-图文教程");
        MiWebViewActivity.startWebViewActivity(this$0, this$0.O1());
    }

    public static final void Q1(TtsOptimizeActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.W(this$0.getApplicationContext(), "听书中断-图文教程");
        MiWebViewActivity.startWebViewActivity(this$0, this$0.O1());
    }

    @SuppressLint({"SetTextI18n"})
    public final void S1() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(m1()), Dispatchers.getMain(), null, new TtsOptimizeActivity$setDownloadFinished$1(this, null), 2, null);
    }

    @SuppressLint({"SetTextI18n"})
    public final void T1(Integer percent) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(m1()), Dispatchers.getMain(), null, new TtsOptimizeActivity$setDownloadProgress$1(this, percent, null), 2, null);
    }

    public static final void V1(TtsOptimizeActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (TtsEnginesUtil.f15062a.e(this$0) || (TtsEnginesUtil.d(this$0) == TtsEnginesUtil.EngineMode.SYSTEM && TtsEnginesUtil.f(this$0))) {
            ac.a.W(this$0.getApplicationContext(), "听书中断-google-去设置");
            TtsEnginesUtil.l(this$0);
            t0.a(this$0, ExtKt.c("滑动到最底部设置声音"));
        } else if (TtsEnginesUtil.i(this$0)) {
            ac.a.W(this$0.getApplicationContext(), "听书中断-google-立即使用");
            AppViewModel l12 = this$0.l1();
            if (l12 != null) {
                l12.I0();
            }
            TtsEnginesUtil.k(this$0, TtsEnginesUtil.EngineMode.GOOGLE);
            this$0.setResult(1001);
            this$0.finish();
        } else {
            ac.a.W(this$0.getApplicationContext(), "听书中断-google-下载安装");
            DownloadTtsEngineDialogFragment.Companion.b(DownloadTtsEngineDialogFragment.INSTANCE, this$0, this$0.l1(), null, 4, null);
        }
        this$0.R1();
    }

    public static final void W1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Y1(ae.b intentWrapper, TtsOptimizeActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(intentWrapper, "$intentWrapper");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        intentWrapper.i(this$0);
    }

    public final String O1() {
        return (String) this.tutorialUrl.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    public final void R1() {
        if (TtsEnginesUtil.f15062a.e(this) || (TtsEnginesUtil.d(this) == TtsEnginesUtil.EngineMode.SYSTEM && TtsEnginesUtil.f(this))) {
            ((ActivityTtsOptimizeBinding) a1()).downloadStatus.setText(ExtKt.c("去设置"));
            ((ActivityTtsOptimizeBinding) a1()).ivGoogleTtsMore.setVisibility(0);
            ((ActivityTtsOptimizeBinding) a1()).ivVip.setVisibility(8);
        } else {
            if (TtsEnginesUtil.i(this)) {
                AppViewModel l12 = l1();
                if (l12 != null) {
                    l12.I0();
                }
                ((ActivityTtsOptimizeBinding) a1()).downloadStatus.setText(ExtKt.c("立即使用"));
                ((ActivityTtsOptimizeBinding) a1()).ivGoogleTtsMore.setVisibility(8);
                ((ActivityTtsOptimizeBinding) a1()).ivVip.setVisibility(8);
                return;
            }
            ((ActivityTtsOptimizeBinding) a1()).ivVip.setVisibility(0);
            ((ActivityTtsOptimizeBinding) a1()).ivGoogleTtsMore.setVisibility(8);
            if (DownloadTtsEngineDialogFragment.INSTANCE.d()) {
                ((ActivityTtsOptimizeBinding) a1()).downloadStatus.setText(ExtKt.c("点击安装"));
            } else {
                ((ActivityTtsOptimizeBinding) a1()).downloadStatus.setText(ExtKt.c("点击下载"));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void U1() {
        NonStickyLiveData<Pair<Integer, Object>> S;
        if (ke.e.c() || MiConfigSingleton.b2().C2()) {
            ((ActivityTtsOptimizeBinding) a1()).downloadGoogleTtsEngine.setVisibility(8);
            return;
        }
        R1();
        ((ActivityTtsOptimizeBinding) a1()).downloadGoogleTtsEngine.setOnClickListener(new View.OnClickListener() { // from class: jd.t0
            public /* synthetic */ t0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TtsOptimizeActivity.V1(TtsOptimizeActivity.this, view);
            }
        });
        AppViewModel l12 = l1();
        if (l12 == null || (S = l12.S()) == null) {
            return;
        }
        S.observe(this, new Observer() { // from class: jd.u0
            public /* synthetic */ u0() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TtsOptimizeActivity.W1(Function1.this, obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"InflateParams"})
    public final void X1(List<? extends ae.b> intentWrapperList) {
        if (intentWrapperList.isEmpty()) {
            return;
        }
        for (ae.b bVar : intentWrapperList) {
            View inflate = getLayoutInflater().inflate(R.layout.tts_setting_item, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            TtsSettingItemBinding bind = TtsSettingItemBinding.bind(inflate);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            bind.ttsSettingTitle.setText(bVar.c());
            bind.ttsSettingDesc.setText(bVar.a());
            bind.ttsSettingView.setOnClickListener(new View.OnClickListener() { // from class: jd.v0

                /* renamed from: c */
                public final /* synthetic */ TtsOptimizeActivity f27369c;

                public /* synthetic */ v0(TtsOptimizeActivity this) {
                    this = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TtsOptimizeActivity.Y1(ae.b.this, this, view);
                }
            });
            bind.ttsSettingStatus.setText(getString(bVar.d() ? R.string.already_set : R.string.go_to_setting));
            ((ActivityTtsOptimizeBinding) a1()).ttsOptimizeView.addView(bind.getRoot());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseActivity
    @SuppressLint({"SetTextI18n"})
    public void c1(@l Bundle savedInstanceState) {
        ac.a.W(getApplicationContext(), "听书中断-展示");
        ((ActivityTtsOptimizeBinding) a1()).bdReading.setOnClickListener(new View.OnClickListener() { // from class: jd.r0
            public /* synthetic */ r0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TtsOptimizeActivity.P1(TtsOptimizeActivity.this, view);
            }
        });
        ((ActivityTtsOptimizeBinding) a1()).clGuide.setOnClickListener(new View.OnClickListener() { // from class: jd.s0
            public /* synthetic */ s0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TtsOptimizeActivity.Q1(TtsOptimizeActivity.this, view);
            }
        });
        U1();
        List<ae.b> k10 = i.k(this);
        Intrinsics.checkNotNullExpressionValue(k10, "getIntentWrapperList(...)");
        X1(k10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @l Intent r32) {
        super.onActivityResult(requestCode, resultCode, r32);
        if (requestCode == 1025) {
            ((ActivityTtsOptimizeBinding) a1()).ttsOptimizeView.removeAllViews();
            List<ae.b> k10 = i.k(this);
            Intrinsics.checkNotNullExpressionValue(k10, "getIntentWrapperList(...)");
            X1(k10);
        }
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        R1();
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity
    @SuppressLint({"SetTextI18n"})
    public void s1(@l LayoutToolbarBinding toolbarBinding) {
        super.s1(toolbarBinding);
        if (toolbarBinding != null) {
            toolbarBinding.f12249i.setText(ExtKt.c("听书中断优化"));
            toolbarBinding.f12247g.setVisibility(0);
        }
    }
}
