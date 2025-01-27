package com.martian.mibook.mvvm.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import ba.m;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.theme.MiReadingTheme;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel;
import com.martian.mibook.mvvm.widget.MiBookMarkHeader;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pf.d;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002`aB\u001f\b\u0007\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000f\u0010\fJ\u000f\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\fJ'\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0017¢\u0006\u0004\b\u001f\u0010 J7\u0010&\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b*\u0010+J\u001f\u0010.\u001a\u00020\n2\u0006\u0010-\u001a\u00020,2\u0006\u0010\"\u001a\u00020!H\u0003¢\u0006\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010@\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00109R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u001b\u0010K\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010MR\u001d\u0010U\u001a\u0004\u0018\u00010Q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010H\u001a\u0004\bS\u0010TR\u001d\u0010Y\u001a\u0004\u0018\u00010V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010H\u001a\u0004\bW\u0010XR\u0016\u0010\\\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010]\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010[R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_¨\u0006b"}, d2 = {"Lcom/martian/mibook/mvvm/widget/MiBookMarkHeader;", "Ltf/b;", "Lpf/d;", "Lk9/a;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", IAdInterListener.AdReqParam.WIDTH, "()V", "y", "onAttachedToWindow", "onDetachedFromWindow", "p", "Lpf/e;", "kernel", "", "height", "maxDragHeight", "d", "(Lpf/e;II)V", "Lpf/f;", "refreshLayout", bt.aO, "(Lpf/f;II)V", "Lcom/scwang/smart/refresh/layout/constant/RefreshState;", "oldState", "newState", "c", "(Lpf/f;Lcom/scwang/smart/refresh/layout/constant/RefreshState;Lcom/scwang/smart/refresh/layout/constant/RefreshState;)V", "", "isDragging", "", "percent", TypedValues.CycleType.S_WAVE_OFFSET, t.f11211k, "(ZFIII)V", "Lcom/martian/mibook/mvvm/widget/MiBookMarkHeader$a;", "onRefreshListener", "setOnRefreshListener", "(Lcom/martian/mibook/mvvm/widget/MiBookMarkHeader$a;)V", "Lcom/martian/mibook/mvvm/widget/MiBookMarkHeader$HeaderState;", "currentHeaderStatus", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/martian/mibook/mvvm/widget/MiBookMarkHeader$HeaderState;Z)V", e.TAG, "Lpf/e;", "mRefreshKernel", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "llMarkView", "Landroid/widget/ImageView;", "g", "Landroid/widget/ImageView;", "ivArrowView", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "tvTipsView", "i", "ivBookMark", "Landroid/graphics/PorterDuffColorFilter;", "j", "Landroid/graphics/PorterDuffColorFilter;", "bookMarkColorFilter", "k", "Lcom/martian/mibook/mvvm/widget/MiBookMarkHeader$a;", t.f11204d, "Lkotlin/Lazy;", "getMaxReleaseToRefreshHeight", "()I", "maxReleaseToRefreshHeight", "m", "F", "llMarkViewHeight", "n", "llMarkViewBottom", "Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "o", "getMViewModel", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "mViewModel", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "q", "Z", "isPullAddMark", "isRefreshing", "s", "Lcom/martian/mibook/mvvm/widget/MiBookMarkHeader$HeaderState;", "HeaderState", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class MiBookMarkHeader extends tf.b implements d, k9.a {

    /* renamed from: e */
    @l
    public pf.e mRefreshKernel;

    /* renamed from: f, reason: from kotlin metadata */
    @l
    public LinearLayout llMarkView;

    /* renamed from: g, reason: from kotlin metadata */
    @l
    public ImageView ivArrowView;

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public TextView tvTipsView;

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public ImageView ivBookMark;

    /* renamed from: j, reason: from kotlin metadata */
    @l
    public PorterDuffColorFilter bookMarkColorFilter;

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public a onRefreshListener;

    /* renamed from: l */
    @k
    public final Lazy maxReleaseToRefreshHeight;

    /* renamed from: m, reason: from kotlin metadata */
    public float llMarkViewHeight;

    /* renamed from: n, reason: from kotlin metadata */
    public float llMarkViewBottom;

    /* renamed from: o, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel;

    /* renamed from: p, reason: from kotlin metadata */
    @k
    public final Lazy com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String;

    /* renamed from: q, reason: from kotlin metadata */
    public boolean isPullAddMark;

    /* renamed from: r */
    public boolean isRefreshing;

    /* renamed from: s, reason: from kotlin metadata */
    @k
    public HeaderState currentHeaderStatus;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/martian/mibook/mvvm/widget/MiBookMarkHeader$HeaderState;", "", "(Ljava/lang/String;I)V", "NONE", "PullDownToRefresh", "ReleaseToRefresh", "RefreshReleased", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class HeaderState extends Enum<HeaderState> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ HeaderState[] $VALUES;
        public static final HeaderState NONE = new HeaderState("NONE", 0);
        public static final HeaderState PullDownToRefresh = new HeaderState("PullDownToRefresh", 1);
        public static final HeaderState ReleaseToRefresh = new HeaderState("ReleaseToRefresh", 2);
        public static final HeaderState RefreshReleased = new HeaderState("RefreshReleased", 3);

        private static final /* synthetic */ HeaderState[] $values() {
            return new HeaderState[]{NONE, PullDownToRefresh, ReleaseToRefresh, RefreshReleased};
        }

        static {
            HeaderState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private HeaderState(String str, int i10) {
            super(str, i10);
        }

        @k
        public static EnumEntries<HeaderState> getEntries() {
            return $ENTRIES;
        }

        public static HeaderState valueOf(String str) {
            return (HeaderState) Enum.valueOf(HeaderState.class, str);
        }

        public static HeaderState[] values() {
            return (HeaderState[]) $VALUES.clone();
        }
    }

    public interface a {
        void a(boolean z10);
    }

    public /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f15338a;

        static {
            int[] iArr = new int[HeaderState.values().length];
            try {
                iArr[HeaderState.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HeaderState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HeaderState.ReleaseToRefresh.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HeaderState.RefreshReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f15338a = iArr;
        }
    }

    @JvmOverloads
    public MiBookMarkHeader(@l Context context) {
        this(context, null, 2, null);
    }

    private final FragmentActivity getActivity() {
        return (FragmentActivity) this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String.getValue();
    }

    private final ReadingViewModel getMViewModel() {
        return (ReadingViewModel) this.mViewModel.getValue();
    }

    private final int getMaxReleaseToRefreshHeight() {
        return ((Number) this.maxReleaseToRefreshHeight.getValue()).intValue();
    }

    private final void w() {
        ReadingViewModel mViewModel;
        MutableLiveData<Boolean> J0;
        FragmentActivity activity = getActivity();
        if (activity == null || (mViewModel = getMViewModel()) == null || (J0 = mViewModel.J0()) == null) {
            return;
        }
        J0.observe(activity, new Observer() { // from class: rd.c
            public /* synthetic */ c() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MiBookMarkHeader.x(Function1.this, obj);
            }
        });
    }

    public static final void x(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void y() {
        this.llMarkView = (LinearLayout) findViewById(R.id.ll_mark);
        this.ivArrowView = (ImageView) findViewById(R.id.iv_arrow);
        this.tvTipsView = (TextView) findViewById(R.id.tv_tips);
        this.ivBookMark = (ImageView) findViewById(R.id.iv_book_mark);
        ImageView imageView = this.ivArrowView;
        if (imageView != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            imageView.setColorFilter(ExtKt.e(context, R.color.bookmark_tag_color), PorterDuff.Mode.SRC_IN);
        }
        LinearLayout linearLayout = this.llMarkView;
        if (linearLayout != null) {
            linearLayout.post(new Runnable() { // from class: rd.d
                public /* synthetic */ d() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MiBookMarkHeader.z(MiBookMarkHeader.this);
                }
            });
        }
    }

    public static final void z(MiBookMarkHeader this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.llMarkViewHeight = this$0.llMarkView != null ? r0.getHeight() : 0.0f;
        this$0.llMarkViewBottom = this$0.llMarkView != null ? r0.getBottom() : 0.0f;
    }

    @SuppressLint({"SetTextI18n"})
    public final synchronized void A(HeaderState headerState, boolean z10) {
        Drawable background;
        ImageView imageView;
        ViewPropertyAnimator animate;
        Drawable background2;
        Drawable background3;
        ImageView imageView2;
        ViewPropertyAnimator animate2;
        try {
            if (this.currentHeaderStatus != headerState) {
                this.currentHeaderStatus = headerState;
                int i10 = b.f15338a[headerState.ordinal()];
                if (i10 == 1 || i10 == 2) {
                    if (this.isPullAddMark) {
                        ImageView imageView3 = this.ivBookMark;
                        if (imageView3 != null && (background2 = imageView3.getBackground()) != null) {
                            background2.clearColorFilter();
                        }
                        TextView textView = this.tvTipsView;
                        if (textView != null) {
                            textView.setText(ExtKt.c("下拉添加书签"));
                        }
                    } else {
                        ImageView imageView4 = this.ivBookMark;
                        background = imageView4 != null ? imageView4.getBackground() : null;
                        if (background != null) {
                            background.setColorFilter(this.bookMarkColorFilter);
                        }
                        TextView textView2 = this.tvTipsView;
                        if (textView2 != null) {
                            textView2.setText(ExtKt.c("下拉移除书签"));
                        }
                    }
                    if (z10 && (imageView = this.ivArrowView) != null && (animate = imageView.animate()) != null) {
                        animate.rotation(0.0f);
                    }
                } else if (i10 == 3 || i10 == 4) {
                    if (this.isPullAddMark) {
                        ImageView imageView5 = this.ivBookMark;
                        background = imageView5 != null ? imageView5.getBackground() : null;
                        if (background != null) {
                            background.setColorFilter(this.bookMarkColorFilter);
                        }
                        TextView textView3 = this.tvTipsView;
                        if (textView3 != null) {
                            textView3.setText(ExtKt.c("松开添加书签"));
                        }
                    } else {
                        ImageView imageView6 = this.ivBookMark;
                        if (imageView6 != null && (background3 = imageView6.getBackground()) != null) {
                            background3.clearColorFilter();
                        }
                        TextView textView4 = this.tvTipsView;
                        if (textView4 != null) {
                            textView4.setText(ExtKt.c("松开移除书签"));
                        }
                    }
                    if (z10 && (imageView2 = this.ivArrowView) != null && (animate2 = imageView2.animate()) != null) {
                        animate2.rotation(180.0f);
                    }
                }
            }
        } finally {
        }
    }

    @Override // tf.b, sf.i
    @SuppressLint({"SetTextI18n"})
    public void c(@k pf.f refreshLayout, @k RefreshState oldState, @k RefreshState newState) {
        Drawable background;
        ViewPropertyAnimator animate;
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        if (newState == RefreshState.None) {
            ImageView imageView = this.ivArrowView;
            if (imageView != null && (animate = imageView.animate()) != null) {
                animate.rotation(0.0f);
            }
            if (this.isPullAddMark) {
                ImageView imageView2 = this.ivBookMark;
                if (imageView2 == null || (background = imageView2.getBackground()) == null) {
                    return;
                }
                background.clearColorFilter();
                return;
            }
            ImageView imageView3 = this.ivBookMark;
            Drawable background2 = imageView3 != null ? imageView3.getBackground() : null;
            if (background2 == null) {
                return;
            }
            background2.setColorFilter(this.bookMarkColorFilter);
        }
    }

    @Override // tf.b, pf.a
    public void d(@k pf.e kernel, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(kernel, "kernel");
        super.d(kernel, height, maxDragHeight);
        this.mRefreshKernel = kernel;
        kernel.l().C(false);
        kernel.l().N(false);
        getLayoutParams().height = getResources().getDisplayMetrics().heightPixels / 2;
        kernel.l().o0(0.35f);
        kernel.l().b0(500);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
        ConfigSingleton.D().h(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ConfigSingleton.D().X0(this);
    }

    @Override // k9.a
    public void p() {
        Drawable background;
        if (isInEditMode()) {
            return;
        }
        MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
        if (k10.getIsDarkTheme()) {
            setBackgroundColor(Color.parseColor("#08FFFFFF"));
        } else {
            setBackgroundColor(Color.parseColor("#80000000"));
        }
        this.bookMarkColorFilter = new PorterDuffColorFilter(k10.getItemColorPrimary(), PorterDuff.Mode.SRC_IN);
        if (this.isPullAddMark) {
            ImageView imageView = this.ivBookMark;
            if (imageView == null || (background = imageView.getBackground()) == null) {
                return;
            }
            background.clearColorFilter();
            return;
        }
        ImageView imageView2 = this.ivBookMark;
        Drawable background2 = imageView2 != null ? imageView2.getBackground() : null;
        if (background2 == null) {
            return;
        }
        background2.setColorFilter(this.bookMarkColorFilter);
    }

    @Override // tf.b, pf.a
    public void r(boolean z10, float f10, int i10, int i11, int i12) {
        super.r(z10, f10, i10, i11, i12);
        if (i10 <= 0) {
            this.isRefreshing = false;
            LinearLayout linearLayout = this.llMarkView;
            if (linearLayout != null) {
                linearLayout.setY(-this.llMarkViewHeight);
            }
            A(HeaderState.NONE, z10);
        } else {
            float f11 = i10;
            float f12 = this.llMarkViewHeight;
            if (f11 <= f12) {
                LinearLayout linearLayout2 = this.llMarkView;
                if (linearLayout2 != null) {
                    linearLayout2.setY(f11 - f12);
                }
            } else {
                LinearLayout linearLayout3 = this.llMarkView;
                if (linearLayout3 != null) {
                    linearLayout3.setY(0.0f);
                }
            }
        }
        if ((!z10 && this.currentHeaderStatus == HeaderState.ReleaseToRefresh) || this.currentHeaderStatus == HeaderState.RefreshReleased) {
            if (this.currentHeaderStatus == HeaderState.ReleaseToRefresh) {
                A(HeaderState.RefreshReleased, z10);
            }
            if (!this.isRefreshing) {
                this.isRefreshing = true;
                a aVar = this.onRefreshListener;
                if (aVar != null) {
                    aVar.a(this.isPullAddMark);
                }
                this.isPullAddMark = !this.isPullAddMark;
                A(HeaderState.NONE, z10);
                this.isRefreshing = false;
            }
        }
        if (i10 < getMaxReleaseToRefreshHeight()) {
            A(HeaderState.PullDownToRefresh, z10);
        } else if (z10) {
            A(HeaderState.ReleaseToRefresh, true);
        }
    }

    public final void setOnRefreshListener(@l a onRefreshListener) {
        this.onRefreshListener = onRefreshListener;
    }

    @Override // tf.b, pf.a
    @SuppressLint({"SetTextI18n"})
    public void t(@k pf.f refreshLayout, int i10, int i11) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        pf.e eVar = this.mRefreshKernel;
        if (eVar != null) {
            Intrinsics.checkNotNull(eVar);
            eVar.o(RefreshState.None);
            pf.e eVar2 = this.mRefreshKernel;
            Intrinsics.checkNotNull(eVar2);
            eVar2.o(RefreshState.RefreshFinish);
        }
    }

    @JvmOverloads
    public MiBookMarkHeader(@l Context context, @l AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.maxReleaseToRefreshHeight = LazyKt.lazy(new Function0<Integer>() { // from class: com.martian.mibook.mvvm.widget.MiBookMarkHeader$maxReleaseToRefreshHeight$2
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MiBookMarkHeader$maxReleaseToRefreshHeight$2(Context context2) {
                super(0);
                context = context2;
            }

            @Override // kotlin.jvm.functions.Function0
            @k
            public final Integer invoke() {
                return Integer.valueOf(m.a(context, 88.0f));
            }
        });
        this.mViewModel = LazyKt.lazy(new Function0<ReadingViewModel>() { // from class: com.martian.mibook.mvvm.widget.MiBookMarkHeader$mViewModel$2
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MiBookMarkHeader$mViewModel$2(Context context2) {
                super(0);
                context = context2;
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final ReadingViewModel invoke() {
                Object obj = context;
                if (obj instanceof FragmentActivity) {
                    return (ReadingViewModel) new ViewModelProvider((ViewModelStoreOwner) obj).get(ReadingViewModel.class);
                }
                return null;
            }
        });
        this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String = LazyKt.lazy(new Function0<FragmentActivity>() { // from class: com.martian.mibook.mvvm.widget.MiBookMarkHeader$activity$2
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MiBookMarkHeader$activity$2(Context context2) {
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
        this.f30866c = qf.b.f30068f;
        View.inflate(context2, R.layout.reader_widget_book_mark_header, this);
        w();
        y();
        this.isPullAddMark = true;
        this.currentHeaderStatus = HeaderState.NONE;
    }

    public /* synthetic */ MiBookMarkHeader(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }
}
