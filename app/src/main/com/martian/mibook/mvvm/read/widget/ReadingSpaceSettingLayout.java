package com.martian.mibook.mvvm.read.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.kwad.sdk.m.e;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.utils.tablayout.CommonNavigator;
import com.martian.libmars.utils.tablayout.ImagePagerTitleView;
import com.martian.libmars.utils.tablayout.LinePagerIndicator;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.databinding.ReaderSpaceSettingLayoutBinding;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.read.widget.ReadingSpaceSettingLayout;
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
import m9.d;
import m9.g;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 .2\u00020\u0001:\u0001/B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\nR\u001d\u0010!\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u0004\u0018\u00010*8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/martian/mibook/mvvm/read/widget/ReadingSpaceSettingLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "i", "()V", "k", "h", "", "index", "n", "(I)V", "", NotificationCompat.CATEGORY_EVENT, "", "space", "o", "(Ljava/lang/String;F)V", "", "smooth", "p", "(Z)V", "g", "Landroidx/fragment/app/FragmentActivity;", "b", "Lkotlin/Lazy;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "Lcom/martian/mibook/databinding/ReaderSpaceSettingLayoutBinding;", "c", "Lcom/martian/mibook/databinding/ReaderSpaceSettingLayoutBinding;", "mViewBinding", "Lm9/d;", "d", "Lm9/d;", "rowSpaceHelper", "Lcom/martian/mibook/mvvm/read/widget/a;", "getReadMenuCallBack", "()Lcom/martian/mibook/mvvm/read/widget/a;", "readMenuCallBack", e.TAG, "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ReadingSpaceSettingLayout extends FrameLayout {

    /* renamed from: e */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f */
    public static final float f14982f = 1.45f;

    /* renamed from: g */
    public static final float f14983g = 1.65f;

    /* renamed from: h */
    public static final float f14984h = 1.85f;

    /* renamed from: b, reason: from kotlin metadata */
    @k
    public final Lazy com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String;

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public final ReaderSpaceSettingLayoutBinding mViewBinding;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public d rowSpaceHelper;

    /* renamed from: com.martian.mibook.mvvm.read.widget.ReadingSpaceSettingLayout$a */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final class b extends m9.b {
        public b() {
        }

        public static final void k(ReadingSpaceSettingLayout this$0, int i10, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            d dVar = this$0.rowSpaceHelper;
            if (dVar != null) {
                dVar.j(i10, true);
            }
            this$0.postDelayed(new Runnable() { // from class: hd.o3

                /* renamed from: c */
                public final /* synthetic */ int f26626c;

                public /* synthetic */ o3(int i102) {
                    i10 = i102;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ReadingSpaceSettingLayout.b.l(ReadingSpaceSettingLayout.this, i10);
                }
            }, 150L);
        }

        public static final void l(ReadingSpaceSettingLayout this$0, int i10) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.n(i10);
        }

        @Override // m9.b
        public int a() {
            return 3;
        }

        @Override // m9.b
        @k
        public m9.e b(@k Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setXOffset(ConfigSingleton.i(2.0f));
            linePagerIndicator.h(ConfigSingleton.i(2.0f)).j(ConfigSingleton.i(16.0f)).d(Integer.valueOf(MiConfigSingleton.b2().h2().k().getPopupBackgroundColor()));
            return linePagerIndicator;
        }

        @Override // m9.b
        @k
        public g c(@k Context context, int i10) {
            Intrinsics.checkNotNullParameter(context, "context");
            ImagePagerTitleView imagePagerTitleView = new ImagePagerTitleView(context, ConfigSingleton.i(20.0f), ConfigSingleton.i(28.0f), 1.0f);
            int i11 = ConfigSingleton.i(4.0f);
            imagePagerTitleView.setPadding(0, i11, 0, i11);
            int i12 = i10 != 0 ? i10 != 2 ? R.drawable.reader_icon_space_normal : R.drawable.reader_icon_space_tight : R.drawable.reader_icon_space_loose;
            int textColorPrimary = MiConfigSingleton.b2().h2().k().getTextColorPrimary();
            imagePagerTitleView.f(Integer.valueOf(textColorPrimary), Integer.valueOf(textColorPrimary));
            imagePagerTitleView.g(i12, i12, i12, i12);
            imagePagerTitleView.setOnClickListener(new View.OnClickListener() { // from class: hd.p3

                /* renamed from: c */
                public final /* synthetic */ int f26632c;

                public /* synthetic */ p3(int i102) {
                    i10 = i102;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingSpaceSettingLayout.b.k(ReadingSpaceSettingLayout.this, i10, view);
                }
            });
            return imagePagerTitleView;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReadingSpaceSettingLayout(@k Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final FragmentActivity getActivity() {
        return (FragmentActivity) this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String.getValue();
    }

    private final a getReadMenuCallBack() {
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

    public static final void l(ReadingSpaceSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g();
        a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.q0();
        }
    }

    public static final void m(ReadingSpaceSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g();
        a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.q0();
        }
    }

    public static /* synthetic */ void q(ReadingSpaceSettingLayout readingSpaceSettingLayout, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        readingSpaceSettingLayout.p(z10);
    }

    public final void g() {
        Object parent = this.mViewBinding.getRoot().getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view != null) {
            view.setTag(Boolean.FALSE);
            BottomSheetBehavior from = BottomSheetBehavior.from(view);
            Intrinsics.checkNotNullExpressionValue(from, "from(...)");
            from.setState(5);
        }
    }

    public final void h() {
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setAdjustMode(true);
        commonNavigator.setMarginHorizontal(0);
        this.rowSpaceHelper = new d();
        commonNavigator.setAdapter(new b());
        this.mViewBinding.magicIndicatorRowSpace.setBackground(MiConfigSingleton.b2().h2().k().getRoundBgResTextThirdlyDrawable(getContext()));
        this.mViewBinding.magicIndicatorRowSpace.setNavigator(commonNavigator);
        d dVar = this.rowSpaceHelper;
        if (dVar != null) {
            dVar.d(this.mViewBinding.magicIndicatorRowSpace);
        }
        q(this, false, 1, null);
    }

    public final void i() {
        AppViewModel l12;
        MutableLiveData<Unit> i02;
        FragmentActivity activity = getActivity();
        BaseMVVMActivity baseMVVMActivity = activity instanceof BaseMVVMActivity ? (BaseMVVMActivity) activity : null;
        if (baseMVVMActivity == null || (l12 = baseMVVMActivity.l1()) == null || (i02 = l12.i0()) == null) {
            return;
        }
        i02.observe(baseMVVMActivity, new Observer() { // from class: hd.n3
            public /* synthetic */ n3() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingSpaceSettingLayout.j(Function1.this, obj);
            }
        });
    }

    public final void k() {
        this.mViewBinding.ivClose.setOnClickListener(new View.OnClickListener() { // from class: hd.l3
            public /* synthetic */ l3() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingSpaceSettingLayout.l(ReadingSpaceSettingLayout.this, view);
            }
        });
        this.mViewBinding.tvExit.setOnClickListener(new View.OnClickListener() { // from class: hd.m3
            public /* synthetic */ m3() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingSpaceSettingLayout.m(ReadingSpaceSettingLayout.this, view);
            }
        });
        h();
        q(this, false, 1, null);
    }

    public final void n(int index) {
        if (index == 0) {
            o("行距宽", 1.85f);
        } else if (index != 2) {
            o("行距正常", 1.65f);
        } else {
            o("行距紧", 1.45f);
        }
    }

    public final void o(String r22, float space) {
        ac.a.L(getContext(), r22);
        ReadingInstance.z().k0(getContext(), space);
        a readMenuCallBack = getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.i();
        }
    }

    public final void p(boolean smooth) {
        float A = ReadingInstance.z().A(getContext());
        int i10 = A == 1.85f ? 0 : A == 1.45f ? 2 : 1;
        d dVar = this.rowSpaceHelper;
        if (dVar != null) {
            dVar.j(i10, smooth);
        }
    }

    public /* synthetic */ ReadingSpaceSettingLayout(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReadingSpaceSettingLayout(@k Context context, @l AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String = LazyKt.lazy(new Function0<FragmentActivity>() { // from class: com.martian.mibook.mvvm.read.widget.ReadingSpaceSettingLayout$activity$2
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadingSpaceSettingLayout$activity$2(Context context2) {
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
        ReaderSpaceSettingLayoutBinding inflate = ReaderSpaceSettingLayoutBinding.inflate(LayoutInflater.from(context2), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.mViewBinding = inflate;
        k();
        i();
    }
}
