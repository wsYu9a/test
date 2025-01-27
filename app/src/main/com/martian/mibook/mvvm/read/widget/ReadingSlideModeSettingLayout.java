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
import com.kwad.sdk.m.e;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.databinding.ReaderSlideModeSettingLayoutBinding;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.read.adapter.ClickRulesListAdapter;
import com.martian.mibook.mvvm.read.adapter.SlideModeListAdapter;
import com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel;
import com.umeng.analytics.pro.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\nR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001d\u0010#\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001d\u0010(\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u0004\u0018\u00010-8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcom/martian/mibook/mvvm/read/widget/ReadingSlideModeSettingLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "i", "()V", "Lcom/martian/mibook/application/ReadingInstance$SlideMode;", "slideMode", "n", "(Lcom/martian/mibook/application/ReadingInstance$SlideMode;)V", "", "isScrollSlideMode", "Lcom/martian/mibook/application/ReadingInstance$ClickRule;", "clickRule", "m", "(ZLcom/martian/mibook/application/ReadingInstance$ClickRule;)V", "h", "Lcom/martian/mibook/mvvm/read/adapter/SlideModeListAdapter;", "b", "Lcom/martian/mibook/mvvm/read/adapter/SlideModeListAdapter;", "slideModeListAdapter", "Lcom/martian/mibook/mvvm/read/adapter/ClickRulesListAdapter;", "c", "Lcom/martian/mibook/mvvm/read/adapter/ClickRulesListAdapter;", "clickRulesListAdapter", "Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "d", "Lkotlin/Lazy;", "getMViewModel", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "mViewModel", "Landroidx/fragment/app/FragmentActivity;", e.TAG, "getActivity", "()Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "Lcom/martian/mibook/databinding/ReaderSlideModeSettingLayoutBinding;", "f", "Lcom/martian/mibook/databinding/ReaderSlideModeSettingLayoutBinding;", "mViewBinding", "Lcom/martian/mibook/mvvm/read/widget/a;", "getReadMenuCallBack", "()Lcom/martian/mibook/mvvm/read/widget/a;", "readMenuCallBack", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nReadingSlideModeSettingLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadingSlideModeSettingLayout.kt\ncom/martian/mibook/mvvm/read/widget/ReadingSlideModeSettingLayout\n+ 2 Ext.kt\ncom/martian/mibook/mvvm/extensions/ExtKt\n*L\n1#1,134:1\n26#2:135\n*S KotlinDebug\n*F\n+ 1 ReadingSlideModeSettingLayout.kt\ncom/martian/mibook/mvvm/read/widget/ReadingSlideModeSettingLayout\n*L\n35#1:135\n*E\n"})
/* loaded from: classes3.dex */
public final class ReadingSlideModeSettingLayout extends FrameLayout {

    /* renamed from: b, reason: from kotlin metadata */
    @l
    public SlideModeListAdapter slideModeListAdapter;

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public ClickRulesListAdapter clickRulesListAdapter;

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel;

    /* renamed from: e */
    @k
    public final Lazy activity;

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final ReaderSlideModeSettingLayoutBinding mViewBinding;

    public static final class a implements SlideModeListAdapter.a {
        public a() {
        }

        @Override // com.martian.mibook.mvvm.read.adapter.SlideModeListAdapter.a
        public void a(@l View view, int i10, @k ReadingInstance.SlideMode slideMode) {
            Intrinsics.checkNotNullParameter(slideMode, "slideMode");
            ReadingSlideModeSettingLayout.this.n(slideMode);
        }
    }

    public static final class b implements ClickRulesListAdapter.a {
        public b() {
        }

        @Override // com.martian.mibook.mvvm.read.adapter.ClickRulesListAdapter.a
        public void a(@l View view, int i10, boolean z10, @k ReadingInstance.ClickRule clickRule) {
            Intrinsics.checkNotNullParameter(clickRule, "clickRule");
            ReadingSlideModeSettingLayout.this.m(z10, clickRule);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReadingSlideModeSettingLayout(@k Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final FragmentActivity getActivity() {
        return (FragmentActivity) this.activity.getValue();
    }

    private final ReadingViewModel getMViewModel() {
        return (ReadingViewModel) this.mViewModel.getValue();
    }

    private final com.martian.mibook.mvvm.read.widget.a getReadMenuCallBack() {
        Object context = getContext();
        if (context instanceof com.martian.mibook.mvvm.read.widget.a) {
            return (com.martian.mibook.mvvm.read.widget.a) context;
        }
        return null;
    }

    public static final void j(ReadingSlideModeSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h();
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.q0();
        }
    }

    public static final void k(ReadingSlideModeSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h();
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.q0();
        }
    }

    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void h() {
        Object parent = this.mViewBinding.getRoot().getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view != null) {
            view.setTag(Boolean.FALSE);
            BottomSheetBehavior from = BottomSheetBehavior.from(view);
            Intrinsics.checkNotNullExpressionValue(from, "from(...)");
            from.setState(5);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a2, code lost:
    
        if (r2.getIsScrollMode() == true) goto L59;
     */
    @android.annotation.SuppressLint({"NotifyDataSetChanged", "ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i() {
        /*
            r5 = this;
            com.martian.mibook.databinding.ReaderSlideModeSettingLayoutBinding r0 = r5.mViewBinding
            com.martian.mibook.ui.reader.ReaderThemeImageView r0 = r0.ivClose
            hd.i3 r1 = new hd.i3
            r1.<init>()
            r0.setOnClickListener(r1)
            com.martian.mibook.databinding.ReaderSlideModeSettingLayoutBinding r0 = r5.mViewBinding
            com.martian.mibook.ui.reader.ReaderThemeTextView r0 = r0.tvExit
            hd.j3 r1 = new hd.j3
            r1.<init>()
            r0.setOnClickListener(r1)
            com.martian.mibook.databinding.ReaderSlideModeSettingLayoutBinding r0 = r5.mViewBinding
            androidx.recyclerview.widget.RecyclerView r0 = r0.rvSlideMode
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            r1 = 0
            if (r0 != 0) goto L33
            com.martian.mibook.databinding.ReaderSlideModeSettingLayoutBinding r0 = r5.mViewBinding
            androidx.recyclerview.widget.RecyclerView r0 = r0.rvSlideMode
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r3 = r5.getContext()
            r2.<init>(r3, r1, r1)
            r0.setLayoutManager(r2)
        L33:
            com.martian.mibook.databinding.ReaderSlideModeSettingLayoutBinding r0 = r5.mViewBinding
            androidx.recyclerview.widget.RecyclerView r0 = r0.rvClickRules
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            if (r0 != 0) goto L4d
            com.martian.mibook.databinding.ReaderSlideModeSettingLayoutBinding r0 = r5.mViewBinding
            androidx.recyclerview.widget.RecyclerView r0 = r0.rvClickRules
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r3 = r5.getContext()
            r2.<init>(r3, r1, r1)
            r0.setLayoutManager(r2)
        L4d:
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            boolean r2 = r0 instanceof com.martian.mibook.mvvm.base.BaseMVVMActivity
            if (r2 == 0) goto L58
            com.martian.mibook.mvvm.base.BaseMVVMActivity r0 = (com.martian.mibook.mvvm.base.BaseMVVMActivity) r0
            goto L59
        L58:
            r0 = 0
        L59:
            if (r0 == 0) goto L74
            com.martian.mibook.mvvm.ui.viewmodel.AppViewModel r2 = r0.l1()
            if (r2 == 0) goto L74
            androidx.lifecycle.MutableLiveData r2 = r2.i0()
            if (r2 == 0) goto L74
            com.martian.mibook.mvvm.read.widget.ReadingSlideModeSettingLayout$initData$3$1 r3 = new com.martian.mibook.mvvm.read.widget.ReadingSlideModeSettingLayout$initData$3$1
            r3.<init>()
            hd.k3 r4 = new hd.k3
            r4.<init>()
            r2.observe(r0, r4)
        L74:
            com.martian.mibook.mvvm.read.adapter.SlideModeListAdapter r0 = new com.martian.mibook.mvvm.read.adapter.SlideModeListAdapter
            r0.<init>()
            r5.slideModeListAdapter = r0
            com.martian.mibook.databinding.ReaderSlideModeSettingLayoutBinding r2 = r5.mViewBinding
            androidx.recyclerview.widget.RecyclerView r2 = r2.rvSlideMode
            r2.setAdapter(r0)
            com.martian.mibook.databinding.ReaderSlideModeSettingLayoutBinding r0 = r5.mViewBinding
            androidx.recyclerview.widget.RecyclerView r0 = r0.rvSlideMode
            r0.setNestedScrollingEnabled(r1)
            com.martian.mibook.mvvm.read.adapter.SlideModeListAdapter r0 = r5.slideModeListAdapter
            if (r0 == 0) goto L95
            com.martian.mibook.mvvm.read.widget.ReadingSlideModeSettingLayout$a r2 = new com.martian.mibook.mvvm.read.widget.ReadingSlideModeSettingLayout$a
            r2.<init>()
            r0.m(r2)
        L95:
            com.martian.mibook.mvvm.read.adapter.ClickRulesListAdapter r0 = new com.martian.mibook.mvvm.read.adapter.ClickRulesListAdapter
            com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel r2 = r5.getMViewModel()
            if (r2 == 0) goto La5
            boolean r2 = r2.getIsScrollMode()
            r3 = 1
            if (r2 != r3) goto La5
            goto La6
        La5:
            r3 = 0
        La6:
            r0.<init>(r3)
            r5.clickRulesListAdapter = r0
            com.martian.mibook.databinding.ReaderSlideModeSettingLayoutBinding r2 = r5.mViewBinding
            androidx.recyclerview.widget.RecyclerView r2 = r2.rvClickRules
            r2.setAdapter(r0)
            com.martian.mibook.databinding.ReaderSlideModeSettingLayoutBinding r0 = r5.mViewBinding
            androidx.recyclerview.widget.RecyclerView r0 = r0.rvClickRules
            r0.setNestedScrollingEnabled(r1)
            com.martian.mibook.mvvm.read.adapter.ClickRulesListAdapter r0 = r5.clickRulesListAdapter
            if (r0 == 0) goto Lc5
            com.martian.mibook.mvvm.read.widget.ReadingSlideModeSettingLayout$b r1 = new com.martian.mibook.mvvm.read.widget.ReadingSlideModeSettingLayout$b
            r1.<init>()
            r0.q(r1)
        Lc5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.read.widget.ReadingSlideModeSettingLayout.i():void");
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void m(boolean isScrollSlideMode, ReadingInstance.ClickRule clickRule) {
        if (isScrollSlideMode) {
            ReadingInstance.z().v0(getContext(), clickRule.getClickRuleValue() == ReadingInstance.ClickRule.RULE_5.getClickRuleValue());
        } else {
            if (clickRule.getClickRuleValue() == ReadingInstance.z().w(getContext())) {
                return;
            } else {
                ReadingInstance.z().g0(getContext(), clickRule.getClickRuleValue());
            }
        }
        ClickRulesListAdapter clickRulesListAdapter = this.clickRulesListAdapter;
        if (clickRulesListAdapter != null) {
            clickRulesListAdapter.notifyDataSetChanged();
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void n(ReadingInstance.SlideMode slideMode) {
        int E = ReadingInstance.z().E(getContext());
        if (slideMode.getSlideMode() == E) {
            return;
        }
        ReadingInstance.z().o0(getContext(), slideMode.getSlideMode());
        SlideModeListAdapter slideModeListAdapter = this.slideModeListAdapter;
        if (slideModeListAdapter != null) {
            slideModeListAdapter.notifyDataSetChanged();
        }
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.C0(E, slideMode.getSlideMode());
        }
        ReadingInstance.SlideMode slideMode2 = ReadingInstance.SlideMode.SCROLL_SLIDER;
        if (E == slideMode2.getSlideMode() || slideMode.getSlideMode() == slideMode2.getSlideMode()) {
            ClickRulesListAdapter clickRulesListAdapter = this.clickRulesListAdapter;
            if (clickRulesListAdapter != null) {
                ReadingViewModel mViewModel = getMViewModel();
                boolean z10 = false;
                if (mViewModel != null && mViewModel.getIsScrollMode()) {
                    z10 = true;
                }
                clickRulesListAdapter.p(z10);
            }
            ClickRulesListAdapter clickRulesListAdapter2 = this.clickRulesListAdapter;
            if (clickRulesListAdapter2 != null) {
                clickRulesListAdapter2.notifyDataSetChanged();
            }
        }
        ReadingViewModel mViewModel2 = getMViewModel();
        if (mViewModel2 != null) {
            mViewModel2.U2(ReadingInstance.z().N(getContext()), 1);
        }
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack2 = getReadMenuCallBack();
        if (readMenuCallBack2 != null) {
            readMenuCallBack2.o0();
        }
    }

    public /* synthetic */ ReadingSlideModeSettingLayout(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReadingSlideModeSettingLayout(@k Context context, @l AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mViewModel = LazyKt.lazy(new Function0<ReadingViewModel>() { // from class: com.martian.mibook.mvvm.read.widget.ReadingSlideModeSettingLayout$special$$inlined$activityViewModel$1
            final /* synthetic */ View $this_activityViewModel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadingSlideModeSettingLayout$special$$inlined$activityViewModel$1(View this) {
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
        this.activity = LazyKt.lazy(new Function0<FragmentActivity>() { // from class: com.martian.mibook.mvvm.read.widget.ReadingSlideModeSettingLayout$activity$2
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadingSlideModeSettingLayout$activity$2(Context context2) {
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
        ReaderSlideModeSettingLayoutBinding inflate = ReaderSlideModeSettingLayoutBinding.inflate(LayoutInflater.from(context2), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.mViewBinding = inflate;
        i();
    }
}
