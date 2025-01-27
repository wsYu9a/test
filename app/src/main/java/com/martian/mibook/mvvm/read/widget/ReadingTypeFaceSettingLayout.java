package com.martian.mibook.mvvm.read.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.kwad.sdk.m.e;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.ReaderTypefaceManager;
import com.martian.mibook.databinding.ReaderTypefaceSettingLayoutBinding;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.read.adapter.TypeFaceGridAdapter;
import com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel;
import com.martian.mibook.mvvm.read.widget.ReadingTypeFaceSettingLayout;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.umeng.analytics.pro.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lc.b;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001)B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010$\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010#R\u0016\u0010(\u001a\u0004\u0018\u00010%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/martian/mibook/mvvm/read/widget/ReadingTypeFaceSettingLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "m", "()V", "i", "h", "Lcom/martian/mibook/mvvm/read/adapter/TypeFaceGridAdapter;", "b", "Lcom/martian/mibook/mvvm/read/adapter/TypeFaceGridAdapter;", "typeFaceGridAdapter", "Landroidx/fragment/app/FragmentActivity;", "c", "Lkotlin/Lazy;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "Lcom/martian/mibook/databinding/ReaderTypefaceSettingLayoutBinding;", "d", "Lcom/martian/mibook/databinding/ReaderTypefaceSettingLayoutBinding;", "mViewBinding", "Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", e.TAG, "getAppViewModel", "()Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "appViewModel", "Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "f", "getMViewModel", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "mViewModel", "Lcom/martian/mibook/mvvm/read/widget/a;", "getReadMenuCallBack", "()Lcom/martian/mibook/mvvm/read/widget/a;", "readMenuCallBack", "GridSpacingItemDecoration", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nReadingTypeFaceSettingLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadingTypeFaceSettingLayout.kt\ncom/martian/mibook/mvvm/read/widget/ReadingTypeFaceSettingLayout\n+ 2 Ext.kt\ncom/martian/mibook/mvvm/extensions/ExtKt\n*L\n1#1,173:1\n26#2:174\n*S KotlinDebug\n*F\n+ 1 ReadingTypeFaceSettingLayout.kt\ncom/martian/mibook/mvvm/read/widget/ReadingTypeFaceSettingLayout\n*L\n52#1:174\n*E\n"})
/* loaded from: classes3.dex */
public final class ReadingTypeFaceSettingLayout extends FrameLayout {

    /* renamed from: b, reason: from kotlin metadata */
    @l
    public TypeFaceGridAdapter typeFaceGridAdapter;

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public final Lazy com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String;

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public final ReaderTypefaceSettingLayoutBinding mViewBinding;

    /* renamed from: e */
    @k
    public final Lazy appViewModel;

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/martian/mibook/mvvm/read/widget/ReadingTypeFaceSettingLayout$GridSpacingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "", "spanCount", "spacing", "", "includeEdge", "<init>", "(Lcom/martian/mibook/mvvm/read/widget/ReadingTypeFaceSettingLayout;IIZ)V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", e.TAG, "I", "f", "g", "Z", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        /* renamed from: e */
        public final int spanCount;

        /* renamed from: f, reason: from kotlin metadata */
        public final int spacing;

        /* renamed from: g, reason: from kotlin metadata */
        public final boolean includeEdge;

        public GridSpacingItemDecoration(int i10, int i11, boolean z10) {
            this.spanCount = i10;
            this.spacing = i11;
            this.includeEdge = z10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@k Rect outRect, @k View view, @k RecyclerView parent, @k RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            int i10 = this.spanCount;
            int i11 = childAdapterPosition % i10;
            if (this.includeEdge) {
                int i12 = this.spacing;
                outRect.left = i12 - ((i11 * i12) / i10);
                outRect.right = ((i11 + 1) * i12) / i10;
                if (childAdapterPosition < i10) {
                    outRect.top = i12;
                }
                outRect.bottom = i12;
                return;
            }
            int i13 = this.spacing;
            outRect.left = (i11 * i13) / i10;
            outRect.right = i13 - (((i11 + 1) * i13) / i10);
            if (childAdapterPosition >= i10) {
                outRect.top = i13;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReadingTypeFaceSettingLayout(@k Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final FragmentActivity getActivity() {
        return (FragmentActivity) this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String.getValue();
    }

    public final AppViewModel getAppViewModel() {
        return (AppViewModel) this.appViewModel.getValue();
    }

    public final ReadingViewModel getMViewModel() {
        return (ReadingViewModel) this.mViewModel.getValue();
    }

    public final a getReadMenuCallBack() {
        Object context = getContext();
        if (context instanceof a) {
            return (a) context;
        }
        return null;
    }

    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void k(ReadingTypeFaceSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h();
        a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.q0();
        }
    }

    public static final void l(ReadingTypeFaceSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.X();
        }
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

    @SuppressLint({"NotifyDataSetChanged", "ClickableViewAccessibility"})
    public final void i() {
        AppViewModel l12;
        MutableLiveData<Unit> i02;
        FragmentActivity activity = getActivity();
        BaseMVVMActivity baseMVVMActivity = activity instanceof BaseMVVMActivity ? (BaseMVVMActivity) activity : null;
        if (baseMVVMActivity != null && (l12 = baseMVVMActivity.l1()) != null && (i02 = l12.i0()) != null) {
            i02.observe(baseMVVMActivity, new Observer() { // from class: hd.q3
                public /* synthetic */ q3() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ReadingTypeFaceSettingLayout.j(Function1.this, obj);
                }
            });
        }
        if (this.mViewBinding.rvTf.getLayoutManager() == null) {
            this.mViewBinding.rvTf.setLayoutManager(new GridLayoutManager(getContext(), 2));
            this.mViewBinding.rvTf.addItemDecoration(new GridSpacingItemDecoration(2, ConfigSingleton.i(12.0f), false));
        }
        TypeFaceGridAdapter typeFaceGridAdapter = new TypeFaceGridAdapter();
        this.typeFaceGridAdapter = typeFaceGridAdapter;
        this.mViewBinding.rvTf.setAdapter(typeFaceGridAdapter);
        TypeFaceGridAdapter typeFaceGridAdapter2 = this.typeFaceGridAdapter;
        if (typeFaceGridAdapter2 != null) {
            ReaderTypefaceManager i22 = MiConfigSingleton.b2().i2();
            typeFaceGridAdapter2.y(i22 != null ? i22.f() : null);
        }
        this.mViewBinding.ivClose.setOnClickListener(new View.OnClickListener() { // from class: hd.r3
            public /* synthetic */ r3() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingTypeFaceSettingLayout.k(ReadingTypeFaceSettingLayout.this, view);
            }
        });
        this.mViewBinding.rvTf.setNestedScrollingEnabled(false);
        this.mViewBinding.typeFaceImport.setOnClickListener(new View.OnClickListener() { // from class: hd.s3
            public /* synthetic */ s3() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingTypeFaceSettingLayout.l(ReadingTypeFaceSettingLayout.this, view);
            }
        });
        TypeFaceGridAdapter typeFaceGridAdapter3 = this.typeFaceGridAdapter;
        if (typeFaceGridAdapter3 != null) {
            typeFaceGridAdapter3.v(new ReadingTypeFaceSettingLayout$initData$4(this));
        }
    }

    public final void m() {
        ReaderTypefaceManager i22 = MiConfigSingleton.b2().i2();
        if (i22 != null) {
            i22.s();
        }
        TypeFaceGridAdapter typeFaceGridAdapter = this.typeFaceGridAdapter;
        if (typeFaceGridAdapter != null) {
            ReaderTypefaceManager i23 = MiConfigSingleton.b2().i2();
            typeFaceGridAdapter.y(i23 != null ? i23.f() : null);
        }
    }

    public /* synthetic */ ReadingTypeFaceSettingLayout(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReadingTypeFaceSettingLayout(@k Context context, @l AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String = LazyKt.lazy(new Function0<FragmentActivity>() { // from class: com.martian.mibook.mvvm.read.widget.ReadingTypeFaceSettingLayout$activity$2
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadingTypeFaceSettingLayout$activity$2(Context context2) {
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
        ReaderTypefaceSettingLayoutBinding inflate = ReaderTypefaceSettingLayoutBinding.inflate(LayoutInflater.from(context2), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.mViewBinding = inflate;
        this.appViewModel = LazyKt.lazy(new Function0<AppViewModel>() { // from class: com.martian.mibook.mvvm.read.widget.ReadingTypeFaceSettingLayout$appViewModel$2
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadingTypeFaceSettingLayout$appViewModel$2(Context context2) {
                super(0);
                context = context2;
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final AppViewModel invoke() {
                return b.a(context);
            }
        });
        this.mViewModel = LazyKt.lazy(new Function0<ReadingViewModel>() { // from class: com.martian.mibook.mvvm.read.widget.ReadingTypeFaceSettingLayout$special$$inlined$activityViewModel$1
            final /* synthetic */ View $this_activityViewModel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadingTypeFaceSettingLayout$special$$inlined$activityViewModel$1(View this) {
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
        i();
    }
}
