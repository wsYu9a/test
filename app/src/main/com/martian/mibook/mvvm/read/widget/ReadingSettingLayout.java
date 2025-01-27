package com.martian.mibook.mvvm.read.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.m.e;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.ScrollTabWidget;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.ReaderThemeManager;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.data.theme.MiReadingTheme;
import com.martian.mibook.databinding.ReaderSettingLayoutBinding;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel;
import com.martian.mibook.mvvm.read.widget.ReadingSettingLayout;
import com.martian.mibook.mvvm.read.widget.a;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 12\u00020\u0001:\u00012B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ\u0019\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u000fH\u0003¢\u0006\u0004\b\u0015\u0010\u0012J\u001f\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u000eJ\u000f\u0010\u001b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\u000eJ\u000f\u0010\u001c\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001c\u0010\u000eJ\r\u0010\u001d\u001a\u00020\n¢\u0006\u0004\b\u001d\u0010\u000eR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001d\u0010'\u001a\u0004\u0018\u00010\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001d\u0010,\u001a\u0004\u0018\u00010(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010+R\u0016\u00100\u001a\u0004\u0018\u00010-8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/martian/mibook/mvvm/read/widget/ReadingSettingLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "brightness", "", "setBrightnessProgress", "(I)V", "F", "()V", "", "isChecked", "M", "(Z)V", "K", "smooth", "N", "oldTabIndex", "tabIndex", "I", "(II)V", bt.aO, "G", "onAttachedToWindow", "L", "Lcom/martian/mibook/databinding/ReaderSettingLayoutBinding;", "b", "Lcom/martian/mibook/databinding/ReaderSettingLayoutBinding;", "mViewBinding", "Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "c", "Lkotlin/Lazy;", "getMViewModel", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "mViewModel", "Landroidx/fragment/app/FragmentActivity;", "d", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "Lcom/martian/mibook/mvvm/read/widget/a;", "getReadMenuCallBack", "()Lcom/martian/mibook/mvvm/read/widget/a;", "readMenuCallBack", e.TAG, "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nReadingSettingLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadingSettingLayout.kt\ncom/martian/mibook/mvvm/read/widget/ReadingSettingLayout\n+ 2 Ext.kt\ncom/martian/mibook/mvvm/extensions/ExtKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,340:1\n26#2:341\n1864#3,3:342\n*S KotlinDebug\n*F\n+ 1 ReadingSettingLayout.kt\ncom/martian/mibook/mvvm/read/widget/ReadingSettingLayout\n*L\n112#1:341\n215#1:342,3\n*E\n"})
/* loaded from: classes3.dex */
public final class ReadingSettingLayout extends FrameLayout {

    /* renamed from: e */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f */
    public static final int f14968f = 5;

    /* renamed from: g */
    @l
    public static ValueAnimator f14969g;

    /* renamed from: b, reason: from kotlin metadata */
    @k
    public final ReaderSettingLayoutBinding mViewBinding;

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel;

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public final Lazy com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String;

    /* renamed from: com.martian.mibook.mvvm.read.widget.ReadingSettingLayout$a */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void h(Companion companion, Activity activity, float f10, Function0 function0, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                function0 = null;
            }
            companion.g(activity, f10, function0);
        }

        public static final void i(WindowManager.LayoutParams layoutParams, Window window, ValueAnimator animation) {
            Intrinsics.checkNotNullParameter(window, "$window");
            Intrinsics.checkNotNullParameter(animation, "animation");
            Object animatedValue = animation.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            layoutParams.screenBrightness = ((Float) animatedValue).floatValue() / 255.0f;
            window.setAttributes(layoutParams);
        }

        @JvmStatic
        public final void d(Activity activity) {
            Window window;
            WindowManager.LayoutParams attributes = (activity == null || (window = activity.getWindow()) == null) ? null : window.getAttributes();
            if (attributes != null) {
                attributes.screenBrightness = -1.0f;
            }
            Window window2 = activity != null ? activity.getWindow() : null;
            if (window2 == null) {
                return;
            }
            window2.setAttributes(attributes);
        }

        @JvmStatic
        public final void e(@l Activity activity) {
            if (ReadingInstance.z().V()) {
                d(activity);
            } else {
                f(activity, ReadingInstance.z().v());
            }
        }

        @JvmStatic
        public final void f(Activity activity, int i10) {
            Window window;
            if (i10 < 5) {
                i10 = 5;
            }
            WindowManager.LayoutParams attributes = (activity == null || (window = activity.getWindow()) == null) ? null : window.getAttributes();
            if (attributes != null) {
                attributes.screenBrightness = i10 / 255.0f;
            }
            Window window2 = activity != null ? activity.getWindow() : null;
            if (window2 == null) {
                return;
            }
            window2.setAttributes(attributes);
        }

        @JvmStatic
        public final void g(@l Activity activity, float f10, @l Function0<Unit> function0) {
            Window window = activity != null ? activity.getWindow() : null;
            if (window == null) {
                return;
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            ValueAnimator valueAnimator = ReadingSettingLayout.f14969g;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (ReadingInstance.z().V()) {
                if (function0 != null) {
                    function0.invoke();
                }
                attributes.screenBrightness = -1.0f;
                window.setAttributes(attributes);
                return;
            }
            float v10 = ReadingInstance.z().v();
            if (function0 != null) {
                function0.invoke();
            }
            if (f10 == -1.0f) {
                attributes.screenBrightness = v10 / 255.0f;
                window.setAttributes(attributes);
                return;
            }
            ReadingSettingLayout.f14969g = ValueAnimator.ofFloat(f10, v10);
            ValueAnimator valueAnimator2 = ReadingSettingLayout.f14969g;
            if (valueAnimator2 != null) {
                valueAnimator2.setDuration(500L);
            }
            ValueAnimator valueAnimator3 = ReadingSettingLayout.f14969g;
            if (valueAnimator3 != null) {
                valueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: hd.h3

                    /* renamed from: b */
                    public final /* synthetic */ WindowManager.LayoutParams f26590b;

                    /* renamed from: c */
                    public final /* synthetic */ Window f26591c;

                    public /* synthetic */ h3(WindowManager.LayoutParams attributes2, Window window2) {
                        attributes = attributes2;
                        window = window2;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator4) {
                        ReadingSettingLayout.Companion.i(attributes, window, valueAnimator4);
                    }
                });
            }
            ValueAnimator valueAnimator4 = ReadingSettingLayout.f14969g;
            if (valueAnimator4 != null) {
                valueAnimator4.start();
            }
        }

        public Companion() {
        }
    }

    public static final class b implements SeekBar.OnSeekBarChangeListener {
        public b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@k SeekBar seekBar, int i10, boolean z10) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            if (ReadingInstance.z().V()) {
                return;
            }
            ReadingSettingLayout.INSTANCE.f(ReadingSettingLayout.this.getActivity(), i10 + 5);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@k SeekBar seekBar) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@k SeekBar seekBar) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            ReadingInstance.z().f0(seekBar.getProgress() + 5);
            ReadingSettingLayout.this.M(false);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReadingSettingLayout(@k Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void A(ReadingSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.Y();
        }
    }

    public static final void B(ReadingSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.u();
        }
    }

    public static final void C(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void D(ReadingSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M(!ReadingInstance.z().V());
    }

    public static final void E(ReadingSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (ReadingInstance.z().m(this$0.getContext())) {
            this$0.mViewBinding.tvTextSize.setText(String.valueOf(ReadingInstance.z().x(this$0.getContext())));
            a readMenuCallBack = this$0.getReadMenuCallBack();
            if (readMenuCallBack != null) {
                readMenuCallBack.i();
            }
        }
    }

    @JvmStatic
    public static final void H(Activity activity, int i10) {
        INSTANCE.f(activity, i10);
    }

    @JvmStatic
    public static final void J(@l Activity activity, float f10, @l Function0<Unit> function0) {
        INSTANCE.g(activity, f10, function0);
    }

    public static /* synthetic */ void O(ReadingSettingLayout readingSettingLayout, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        readingSettingLayout.N(z10);
    }

    public static final void P(ReadingSettingLayout this$0, int i10, List tabReadingThemeList, int i11, boolean z10) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tabReadingThemeList, "$tabReadingThemeList");
        this$0.I(i10, i11);
        if (i11 >= 0 && i11 < tabReadingThemeList.size()) {
            ReaderThemeManager h22 = MiConfigSingleton.b2().h2();
            Intrinsics.checkNotNullExpressionValue(h22, "getReaderThemeMgr(...)");
            ReaderThemeManager.x(h22, (MiReadingTheme) tabReadingThemeList.get(i11), null, 2, null);
        }
        a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            a.C0540a.a(readMenuCallBack, false, 1, null);
        }
    }

    public final FragmentActivity getActivity() {
        return (FragmentActivity) this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String.getValue();
    }

    private final ReadingViewModel getMViewModel() {
        return (ReadingViewModel) this.mViewModel.getValue();
    }

    private final a getReadMenuCallBack() {
        Object context = getContext();
        if (context instanceof a) {
            return (a) context;
        }
        return null;
    }

    @JvmStatic
    public static final void r(Activity activity) {
        INSTANCE.d(activity);
    }

    @JvmStatic
    public static final void s(@l Activity activity) {
        INSTANCE.e(activity);
    }

    private final void setBrightnessProgress(int brightness) {
        this.mViewBinding.sbBrightness.setProgress(brightness >= 5 ? brightness - 5 : 5);
    }

    public static final void u(ReadingSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (ReadingInstance.z().J(this$0.getContext())) {
            this$0.mViewBinding.tvTextSize.setText(String.valueOf(ReadingInstance.z().x(this$0.getContext())));
            a readMenuCallBack = this$0.getReadMenuCallBack();
            if (readMenuCallBack != null) {
                readMenuCallBack.i();
            }
        }
    }

    public static final void v(ReadingSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.e();
        }
    }

    public static final void w(ReadingSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.l();
        }
    }

    public static final void x(ReadingSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.P();
        }
    }

    public static final void y(ReadingSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K();
    }

    public static final void z(ReadingSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.G0();
        }
    }

    public final void F() {
        this.mViewBinding.sbBrightness.setMax(250);
        setBrightnessProgress(ReadingInstance.z().v());
        this.mViewBinding.sbBrightness.setOnSeekBarChangeListener(new b());
        M(ReadingInstance.z().V());
        this.mViewBinding.tvTextSize.setText(String.valueOf(ReadingInstance.z().x(getContext())));
        if (MiConfigSingleton.b2().E2()) {
            this.mViewBinding.ivAutoSlideVip.setVisibility(8);
        } else {
            this.mViewBinding.ivAutoSlideVip.setVisibility(0);
        }
    }

    public final void G() {
        O(this, false, 1, null);
    }

    public final void I(int oldTabIndex, int tabIndex) {
        View c10;
        View c11;
        if (oldTabIndex != -1 && (c11 = this.mViewBinding.mtbReadingTheme.c(oldTabIndex)) != null) {
            c11.setSelected(false);
            TextView textView = (TextView) c11.findViewById(R.id.tv_theme_view_text);
            if (textView != null) {
                textView.setVisibility(4);
            }
        }
        if (tabIndex == -1 || (c10 = this.mViewBinding.mtbReadingTheme.c(tabIndex)) == null) {
            return;
        }
        TextView textView2 = (TextView) c10.findViewById(R.id.tv_theme_view_text);
        if (textView2 != null) {
            textView2.setVisibility(MiConfigSingleton.b2().H0() ? 0 : 4);
        }
        c10.setSelected(true);
    }

    public final void K() {
        ac.a.M(getContext(), "极简模式");
        a readMenuCallBack = getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.A();
        }
    }

    public final void L() {
        int v10 = ReadingInstance.z().v();
        if (ReadingInstance.z().V()) {
            this.mViewBinding.cbAutoBrightness.setAlpha(1.0f);
        } else {
            this.mViewBinding.cbAutoBrightness.setAlpha(0.2f);
        }
        this.mViewBinding.sbBrightness.setProgress(v10);
    }

    public final void M(boolean isChecked) {
        ReadingInstance.z().j0(isChecked);
        if (isChecked) {
            ac.a.L(getContext(), "亮度-跟谁系统");
            INSTANCE.d(getActivity());
        } else {
            ac.a.L(getContext(), "亮度-自定义");
            INSTANCE.f(getActivity(), ReadingInstance.z().v());
        }
        L();
    }

    @SuppressLint({"InflateParams"})
    public final void N(boolean smooth) {
        View c10;
        List<MiReadingTheme> n10 = MiConfigSingleton.b2().h2().n();
        MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
        int indexOf = n10.indexOf(k10);
        if (indexOf == -1) {
            if (k10.isCustomTheme()) {
                this.mViewBinding.ccvVip.setBorderColor(ContextCompat.getColor(getContext(), com.martian.libmars.R.color.vip_bg_end_color));
                this.mViewBinding.ccvVip.setCircleBackgroundDrawable(new ColorDrawable(k10.getBackgroundColor()));
                this.mViewBinding.tvThemeViewText.setTextColor(k10.getTextColorPrimary());
            } else {
                this.mViewBinding.ccvVip.setBorderColor(k10.getItemColorPrimary());
                this.mViewBinding.tvThemeViewText.setTextColor(k10.getItemColorPrimary());
                this.mViewBinding.ccvVip.setCircleBackgroundResource(Integer.valueOf(k10.getPreviewImageRes()));
            }
            this.mViewBinding.ccvVip.setSelected(true);
            if (MiConfigSingleton.b2().H0()) {
                this.mViewBinding.tvThemeViewText.setVisibility(0);
            } else {
                this.mViewBinding.tvThemeViewText.setVisibility(4);
            }
        } else {
            this.mViewBinding.ccvVip.setSelected(false);
            this.mViewBinding.ccvVip.setCircleBackgroundResource(null);
            this.mViewBinding.tvThemeViewText.setVisibility(4);
        }
        int i10 = 0;
        for (Object obj : n10) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            MiReadingTheme miReadingTheme = (MiReadingTheme) obj;
            View findViewWithTag = this.mViewBinding.mtbReadingTheme.findViewWithTag(Integer.valueOf(i10));
            if (findViewWithTag == null) {
                findViewWithTag = LayoutInflater.from(getContext()).inflate(R.layout.reading_theme_view, (ViewGroup) this.mViewBinding.mtbReadingTheme, false);
                findViewWithTag.setTag(Integer.valueOf(i10));
                this.mViewBinding.mtbReadingTheme.b(findViewWithTag);
            }
            ReaderCircularContainerView readerCircularContainerView = (ReaderCircularContainerView) findViewWithTag.findViewById(R.id.circular_container);
            TextView textView = (TextView) findViewWithTag.findViewById(R.id.tv_theme_view_text);
            if (readerCircularContainerView != null) {
                Intrinsics.checkNotNull(readerCircularContainerView);
                readerCircularContainerView.setCircleBackgroundColor(miReadingTheme.getBackgroundColor());
                readerCircularContainerView.setBorderColor(miReadingTheme.getItemColorPrimary());
                readerCircularContainerView.setSelected(false);
                ViewGroup.LayoutParams layoutParams = readerCircularContainerView.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                if (marginLayoutParams != null && i10 != 0) {
                    ReadingViewModel mViewModel = getMViewModel();
                    if (mViewModel == null || mViewModel.getIsPortrait()) {
                        marginLayoutParams.leftMargin = ConfigSingleton.i(20.0f);
                    } else {
                        marginLayoutParams.leftMargin = ConfigSingleton.i(40.0f);
                    }
                }
            }
            textView.setTextColor(miReadingTheme.getItemColorPrimary());
            if (MiConfigSingleton.b2().H0() && Intrinsics.areEqual(k10, miReadingTheme)) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(4);
            }
            i10 = i11;
        }
        if (indexOf != -1 && (c10 = this.mViewBinding.mtbReadingTheme.c(indexOf)) != null) {
            c10.setSelected(true);
        }
        if (smooth) {
            this.mViewBinding.mtbReadingTheme.smoothScrollTo(0, 0);
        }
        this.mViewBinding.mtbReadingTheme.setTabSelectionListener(new ScrollTabWidget.a() { // from class: hd.x2

            /* renamed from: b */
            public final /* synthetic */ int f26673b;

            /* renamed from: c */
            public final /* synthetic */ List f26674c;

            public /* synthetic */ x2(int indexOf2, List n102) {
                indexOf = indexOf2;
                n10 = n102;
            }

            @Override // com.martian.libmars.widget.ScrollTabWidget.a
            public final void a(int i12, boolean z10) {
                ReadingSettingLayout.P(ReadingSettingLayout.this, indexOf, n10, i12, z10);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        G();
    }

    public final void t() {
        AppViewModel l12;
        MutableLiveData<Unit> i02;
        FragmentActivity activity = getActivity();
        BaseMVVMActivity baseMVVMActivity = activity instanceof BaseMVVMActivity ? (BaseMVVMActivity) activity : null;
        if (baseMVVMActivity != null && (l12 = baseMVVMActivity.l1()) != null && (i02 = l12.i0()) != null) {
            i02.observe(baseMVVMActivity, new Observer() { // from class: hd.v2
                public /* synthetic */ v2() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ReadingSettingLayout.C(Function1.this, obj);
                }
            });
        }
        this.mViewBinding.cbAutoBrightnessView.setOnClickListener(new View.OnClickListener() { // from class: hd.z2
            public /* synthetic */ z2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingSettingLayout.D(ReadingSettingLayout.this, view);
            }
        });
        this.mViewBinding.llFontDown.setOnClickListener(new View.OnClickListener() { // from class: hd.a3
            public /* synthetic */ a3() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingSettingLayout.E(ReadingSettingLayout.this, view);
            }
        });
        this.mViewBinding.llFontUp.setOnClickListener(new View.OnClickListener() { // from class: hd.b3
            public /* synthetic */ b3() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingSettingLayout.u(ReadingSettingLayout.this, view);
            }
        });
        this.mViewBinding.ivTypefaceView.setOnClickListener(new View.OnClickListener() { // from class: hd.c3
            public /* synthetic */ c3() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingSettingLayout.v(ReadingSettingLayout.this, view);
            }
        });
        this.mViewBinding.lineSpaceSetting.setOnClickListener(new View.OnClickListener() { // from class: hd.d3
            public /* synthetic */ d3() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingSettingLayout.w(ReadingSettingLayout.this, view);
            }
        });
        this.mViewBinding.slideModeSetting.setOnClickListener(new View.OnClickListener() { // from class: hd.e3
            public /* synthetic */ e3() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingSettingLayout.x(ReadingSettingLayout.this, view);
            }
        });
        this.mViewBinding.llMinimalistMode.setOnClickListener(new View.OnClickListener() { // from class: hd.f3
            public /* synthetic */ f3() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingSettingLayout.y(ReadingSettingLayout.this, view);
            }
        });
        this.mViewBinding.llStartAutoSlide.setOnClickListener(new View.OnClickListener() { // from class: hd.g3
            public /* synthetic */ g3() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingSettingLayout.z(ReadingSettingLayout.this, view);
            }
        });
        this.mViewBinding.llMore.setOnClickListener(new View.OnClickListener() { // from class: hd.w2
            public /* synthetic */ w2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingSettingLayout.A(ReadingSettingLayout.this, view);
            }
        });
        this.mViewBinding.ccvVip.setOnClickListener(new View.OnClickListener() { // from class: hd.y2
            public /* synthetic */ y2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingSettingLayout.B(ReadingSettingLayout.this, view);
            }
        });
    }

    public /* synthetic */ ReadingSettingLayout(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReadingSettingLayout(@k Context context, @l AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        ReaderSettingLayoutBinding inflate = ReaderSettingLayoutBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.mViewBinding = inflate;
        this.mViewModel = LazyKt.lazy(new Function0<ReadingViewModel>() { // from class: com.martian.mibook.mvvm.read.widget.ReadingSettingLayout$special$$inlined$activityViewModel$1
            final /* synthetic */ View $this_activityViewModel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadingSettingLayout$special$$inlined$activityViewModel$1(View this) {
                super(0);
                this = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final ReadingViewModel invoke() {
                Context context2 = this.getContext();
                FragmentActivity fragmentActivity = context2 instanceof FragmentActivity ? (FragmentActivity) context2 : null;
                if (fragmentActivity == null || !(fragmentActivity instanceof BaseMVVMActivity)) {
                    return null;
                }
                BaseViewModel m12 = ((BaseMVVMActivity) fragmentActivity).m1();
                return (ReadingViewModel) (m12 instanceof ReadingViewModel ? m12 : null);
            }
        });
        this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String = LazyKt.lazy(new Function0<FragmentActivity>() { // from class: com.martian.mibook.mvvm.read.widget.ReadingSettingLayout$activity$2
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadingSettingLayout$activity$2(Context context2) {
                super(0);
                context = context2;
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final FragmentActivity invoke() {
                Context context2 = context;
                if (context2 instanceof FragmentActivity) {
                    return (FragmentActivity) context2;
                }
                return null;
            }
        });
        F();
        t();
    }
}
