package com.martian.mibook.mvvm.read.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.databinding.ReaderMinimalistModeLayoutBinding;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel;
import com.martian.mibook.mvvm.read.widget.ReaderMinimalistModeLayout;
import com.martian.mibook.ui.reader.ReaderThemeSwitchButton;
import com.umeng.analytics.pro.f;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\nJ\u001b\u0010\u0013\u001a\u00020\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/martian/mibook/mvvm/read/widget/ReaderMinimalistModeLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "s", "()V", "h", "i", t.f11211k, "p", "q", "o", "", TTDownloadField.TT_TAG, "f", "(Ljava/lang/Boolean;)V", "Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "b", "Lkotlin/Lazy;", "getMViewModel", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "mViewModel", "Lcom/martian/mibook/databinding/ReaderMinimalistModeLayoutBinding;", "c", "Lcom/martian/mibook/databinding/ReaderMinimalistModeLayoutBinding;", "mViewBinding", "Lcom/martian/mibook/mvvm/read/widget/a;", "getReadMenuCallBack", "()Lcom/martian/mibook/mvvm/read/widget/a;", "readMenuCallBack", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nReaderMinimalistModeLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReaderMinimalistModeLayout.kt\ncom/martian/mibook/mvvm/read/widget/ReaderMinimalistModeLayout\n+ 2 Ext.kt\ncom/martian/mibook/mvvm/extensions/ExtKt\n*L\n1#1,129:1\n26#2:130\n*S KotlinDebug\n*F\n+ 1 ReaderMinimalistModeLayout.kt\ncom/martian/mibook/mvvm/read/widget/ReaderMinimalistModeLayout\n*L\n24#1:130\n*E\n"})
/* loaded from: classes3.dex */
public final class ReaderMinimalistModeLayout extends FrameLayout {

    /* renamed from: b, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel;

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public final ReaderMinimalistModeLayoutBinding mViewBinding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReaderMinimalistModeLayout(@k Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void g(ReaderMinimalistModeLayout readerMinimalistModeLayout, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = Boolean.FALSE;
        }
        readerMinimalistModeLayout.f(bool);
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

    public static final void j(ReaderMinimalistModeLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g(this$0, null, 1, null);
        a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.q0();
        }
    }

    public static final void k(ReaderMinimalistModeLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r();
    }

    public static final void l(ReaderMinimalistModeLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p();
    }

    public static final void m(ReaderMinimalistModeLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q();
    }

    public static final void n(ReaderMinimalistModeLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o();
    }

    public final void f(Boolean r32) {
        Object parent = this.mViewBinding.getRoot().getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view != null) {
            view.setTag(r32);
            BottomSheetBehavior from = BottomSheetBehavior.from(view);
            Intrinsics.checkNotNullExpressionValue(from, "from(...)");
            from.setState(5);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void h() {
        s();
        this.mViewBinding.tvShowMenuTips.setText(ExtKt.c("提示：点击屏幕中央可以呼出菜单"));
        this.mViewBinding.rbsTvTime.setText(new SimpleDateFormat("HH:mm", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis())));
        this.mViewBinding.tvShowBottomTextTips.setText(ExtKt.c("底部中间提示语"));
    }

    public final void i() {
        this.mViewBinding.ivClose.setOnClickListener(new View.OnClickListener() { // from class: hd.g1
            public /* synthetic */ g1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderMinimalistModeLayout.j(ReaderMinimalistModeLayout.this, view);
            }
        });
        this.mViewBinding.prefShowBonus.setOnClickListener(new View.OnClickListener() { // from class: hd.h1
            public /* synthetic */ h1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderMinimalistModeLayout.k(ReaderMinimalistModeLayout.this, view);
            }
        });
        this.mViewBinding.prefShowMenu.setOnClickListener(new View.OnClickListener() { // from class: hd.i1
            public /* synthetic */ i1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderMinimalistModeLayout.l(ReaderMinimalistModeLayout.this, view);
            }
        });
        this.mViewBinding.prefShowProgressTimePower.setOnClickListener(new View.OnClickListener() { // from class: hd.j1
            public /* synthetic */ j1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderMinimalistModeLayout.m(ReaderMinimalistModeLayout.this, view);
            }
        });
        this.mViewBinding.prefShowBottomTextTips.setOnClickListener(new View.OnClickListener() { // from class: hd.k1
            public /* synthetic */ k1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderMinimalistModeLayout.n(ReaderMinimalistModeLayout.this, view);
            }
        });
    }

    public final void o() {
        boolean isChecked = this.mViewBinding.prefShowBottomTextTips.isChecked();
        ac.a.L(getContext(), "底部文字提示-" + (isChecked ? "显示" : "隐藏"));
        ReadingInstance.z().r0(getContext(), isChecked);
        ReadingViewModel mViewModel = getMViewModel();
        if (mViewModel != null) {
            mViewModel.P2(isChecked);
        }
        a readMenuCallBack = getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.B0(isChecked);
        }
    }

    public final void p() {
        boolean isChecked = this.mViewBinding.prefShowMenu.isChecked();
        ac.a.L(getContext(), "菜单入口-" + (isChecked ? "显示" : "隐藏"));
        ReadingInstance.z().t0(getContext(), isChecked);
        ReadingViewModel mViewModel = getMViewModel();
        if (mViewModel != null) {
            mViewModel.R2(isChecked);
        }
        a readMenuCallBack = getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.a0(isChecked);
        }
    }

    public final void q() {
        boolean isChecked = this.mViewBinding.prefShowProgressTimePower.isChecked();
        ac.a.L(getContext(), "底部进度时间和电量-" + (isChecked ? "显示" : "隐藏"));
        ReadingInstance.z().q0(getContext(), isChecked);
        ReadingViewModel mViewModel = getMViewModel();
        if (mViewModel != null) {
            mViewModel.O2(isChecked);
        }
        a readMenuCallBack = getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.o(isChecked);
        }
    }

    public final void r() {
        boolean isChecked = this.mViewBinding.prefShowBonus.isChecked();
        ac.a.L(getContext(), "计时悬浮-" + (isChecked ? "显示" : "隐藏"));
        ReadingInstance.z().a0(getContext(), isChecked);
        ReadingViewModel mViewModel = getMViewModel();
        if (mViewModel != null) {
            mViewModel.Q2(isChecked);
        }
        a readMenuCallBack = getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.t(isChecked);
        }
    }

    public final void s() {
        ReaderThemeSwitchButton readerThemeSwitchButton = this.mViewBinding.prefShowBonus;
        ReadingViewModel mViewModel = getMViewModel();
        boolean z10 = false;
        readerThemeSwitchButton.setChecked(!((mViewModel == null || mViewModel.getPrefShowFloatBonus()) ? false : true));
        ReaderThemeSwitchButton readerThemeSwitchButton2 = this.mViewBinding.prefShowMenu;
        ReadingViewModel mViewModel2 = getMViewModel();
        readerThemeSwitchButton2.setChecked(!((mViewModel2 == null || mViewModel2.getPrefShowFloatMenu()) ? false : true));
        ReaderThemeSwitchButton readerThemeSwitchButton3 = this.mViewBinding.prefShowProgressTimePower;
        ReadingViewModel mViewModel3 = getMViewModel();
        readerThemeSwitchButton3.setChecked(!((mViewModel3 == null || mViewModel3.getPrefShowBottomStatus()) ? false : true));
        ReaderThemeSwitchButton readerThemeSwitchButton4 = this.mViewBinding.prefShowBottomTextTips;
        ReadingViewModel mViewModel4 = getMViewModel();
        if (mViewModel4 != null && !mViewModel4.getPrefShowBottomTips()) {
            z10 = true;
        }
        readerThemeSwitchButton4.setChecked(!z10);
    }

    public /* synthetic */ ReaderMinimalistModeLayout(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReaderMinimalistModeLayout(@k Context context, @l AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mViewModel = LazyKt.lazy(new Function0<ReadingViewModel>() { // from class: com.martian.mibook.mvvm.read.widget.ReaderMinimalistModeLayout$special$$inlined$activityViewModel$1
            final /* synthetic */ View $this_activityViewModel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReaderMinimalistModeLayout$special$$inlined$activityViewModel$1(View this) {
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
        ReaderMinimalistModeLayoutBinding inflate = ReaderMinimalistModeLayoutBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.mViewBinding = inflate;
        i();
        h();
    }
}
