package com.martian.libmars.widget.scroller;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.R;
import com.martian.libmars.widget.scroller.FastScroller;
import com.umeng.analytics.pro.bt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import w9.a;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0002\u0098\u0001\u0018\u0000 .2\u00020\u0001:\u0003\u009b\u0001hB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0004\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001e\u0010\u0014J\u000f\u0010\u001f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\u0012\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0004\b\u0012\u0010$J\u0019\u0010'\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0004\b'\u0010(J\u0019\u0010+\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u000eH\u0002¢\u0006\u0004\b-\u0010 J\u000f\u0010.\u001a\u00020\u000eH\u0002¢\u0006\u0004\b.\u0010 J\u000f\u0010/\u001a\u00020\u000eH\u0002¢\u0006\u0004\b/\u0010 J\u000f\u00100\u001a\u00020\u000eH\u0002¢\u0006\u0004\b0\u0010 J\u0017\u00102\u001a\u00020\u000e2\u0006\u00101\u001a\u00020#H\u0002¢\u0006\u0004\b2\u00103J!\u00104\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00108\u001a\u00020\u000e2\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b8\u00109J\u0015\u00108\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020:¢\u0006\u0004\b8\u0010<J\u0017\u0010?\u001a\u00020\u000e2\b\u0010>\u001a\u0004\u0018\u00010=¢\u0006\u0004\b?\u0010@J\u0015\u0010A\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\bA\u0010BJ\r\u0010C\u001a\u00020\u000e¢\u0006\u0004\bC\u0010 J\u0015\u0010E\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020#¢\u0006\u0004\bE\u00103J\u0015\u0010G\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020#¢\u0006\u0004\bG\u00103J\u0015\u0010H\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020#¢\u0006\u0004\bH\u00103J\u0017\u0010I\u001a\u00020\u000e2\b\b\u0001\u0010\r\u001a\u00020\b¢\u0006\u0004\bI\u0010JJ\u0017\u0010K\u001a\u00020\u000e2\b\b\u0001\u0010\r\u001a\u00020\b¢\u0006\u0004\bK\u0010JJ\u0017\u0010M\u001a\u00020\u000e2\b\b\u0001\u0010L\u001a\u00020\b¢\u0006\u0004\bM\u0010JJ\u0017\u0010N\u001a\u00020\u000e2\b\b\u0001\u0010\r\u001a\u00020\b¢\u0006\u0004\bN\u0010JJ-\u0010S\u001a\u00020\u000e2\u0006\u0010O\u001a\u00020\b2\u0006\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020\b¢\u0006\u0004\bS\u0010TJ\u0017\u0010U\u001a\u00020\u000e2\b\b\u0001\u0010\r\u001a\u00020\b¢\u0006\u0004\bU\u0010JJ\u0017\u0010V\u001a\u00020\u000e2\b\b\u0001\u0010\r\u001a\u00020\b¢\u0006\u0004\bV\u0010JJ\u0015\u0010Y\u001a\u00020\u000e2\u0006\u0010X\u001a\u00020W¢\u0006\u0004\bY\u0010ZJ\u0017\u0010\\\u001a\u00020\u000e2\u0006\u0010[\u001a\u00020#H\u0016¢\u0006\u0004\b\\\u00103J\u0017\u0010_\u001a\u00020#2\u0006\u0010^\u001a\u00020]H\u0017¢\u0006\u0004\b_\u0010`J/\u0010d\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\b2\u0006\u0010a\u001a\u00020\b2\u0006\u0010b\u001a\u00020\b2\u0006\u0010c\u001a\u00020\bH\u0014¢\u0006\u0004\bd\u0010TJ#\u0010f\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\b2\b\b\u0001\u0010e\u001a\u00020\u0011H\u0007¢\u0006\u0004\bf\u0010gR\u0016\u0010j\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010l\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bk\u0010iR\u0016\u0010n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010iR\u0016\u0010p\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010iR\u0016\u0010r\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010iR\u0016\u0010u\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010v\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010tR\u0018\u0010y\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010|\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010~\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010{R\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001a\u0010\u0085\u0001\u001a\u00030\u0082\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001a\u0010\u0089\u0001\u001a\u00030\u0086\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001a\u0010\u008b\u0001\u001a\u00030\u0086\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u0088\u0001R\u0018\u0010\u008d\u0001\u001a\u00020%8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\bf\u0010\u008c\u0001R\u001a\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bA\u0010\u008e\u0001R\u001b\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u008e\u0001R\u001a\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b+\u0010\u008e\u0001R\u001a\u0010\u0094\u0001\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bC\u0010\u0093\u0001R\u0017\u0010\u0097\u0001\u001a\u00030\u0095\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0017\u0010\u0096\u0001R\u0017\u0010\u009a\u0001\u001a\u00030\u0098\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001c\u0010\u0099\u0001¨\u0006\u009c\u0001"}, d2 = {"Lcom/martian/libmars/widget/scroller/FastScroller;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", com.umeng.analytics.pro.f.X, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/graphics/drawable/Drawable;", "drawable", "color", "", "C", "(Landroid/graphics/drawable/Drawable;I)V", "", "y", "setRecyclerViewPosition", "(F)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "u", "(Landroidx/recyclerview/widget/RecyclerView;)F", "min", "max", "value", "v", "(III)I", "setViewPositions", "G", "()V", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager", "", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)Z", "Landroid/view/View;", "view", bt.aJ, "(Landroid/view/View;)Z", "Landroid/view/ViewPropertyAnimator;", "animator", "s", "(Landroid/view/ViewPropertyAnimator;)V", ExifInterface.LONGITUDE_EAST, IAdInterListener.AdReqParam.WIDTH, "F", "x", "selected", "setHandleSelected", "(Z)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/ViewGroup$LayoutParams;", "params", "setLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)V", "Landroid/view/ViewGroup;", "viewGroup", "(Landroid/view/ViewGroup;)V", "Lcom/martian/libmars/widget/scroller/FastScroller$b;", "sectionIndexer", "setSectionIndexer", "(Lcom/martian/libmars/widget/scroller/FastScroller$b;)V", "q", "(Landroidx/recyclerview/widget/RecyclerView;)V", bt.aO, "fadeScrollbar", "setFadeScrollbar", "visible", "setBubbleVisible", "setTrackVisible", "setTrackColor", "(I)V", "setHandleColor", "drawableRes", "setHandleDrawable", "setHandleViewColorFilter", "leftMargin", "topMargin", "rightMargin", "bottomMargin", "D", "(IIII)V", "setBubbleColor", "setBubbleTextColor", "Lw9/a;", "fastScrollStateChangeListener", "setFastScrollStateChangeListener", "(Lw9/a;)V", "enabled", "setEnabled", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "h", "oldw", "oldh", "onSizeChanged", "factor", "p", "(IF)I", "b", "I", "mBubbleColor", "c", "mHandleColor", "d", "mBubbleHeight", com.kwad.sdk.m.e.TAG, "mHandleHeight", "f", "mViewHeight", "g", "Z", "mFadeScrollbar", "mShowBubble", "i", "Lcom/martian/libmars/widget/scroller/FastScroller$b;", "mSectionIndexer", "j", "Landroid/view/ViewPropertyAnimator;", "mScrollbarAnimator", "k", "mBubbleAnimator", t.f11204d, "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Landroid/widget/TextView;", "m", "Landroid/widget/TextView;", "mBubbleView", "Landroid/widget/ImageView;", "n", "Landroid/widget/ImageView;", "mHandleView", "o", "mTrackView", "Landroid/view/View;", "mScrollbar", "Landroid/graphics/drawable/Drawable;", "mBubbleImage", t.f11211k, "mHandleImage", "mTrackImage", "Lw9/a;", "mFastScrollStateChangeListener", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "mScrollbarHider", "com/martian/libmars/widget/scroller/FastScroller$mScrollListener$1", "Lcom/martian/libmars/widget/scroller/FastScroller$mScrollListener$1;", "mScrollListener", "a", "libmars_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nFastScroller.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastScroller.kt\ncom/martian/libmars/widget/scroller/FastScroller\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,585:1\n1#2:586\n260#3:587\n*S KotlinDebug\n*F\n+ 1 FastScroller.kt\ncom/martian/libmars/widget/scroller/FastScroller\n*L\n324#1:587\n*E\n"})
/* loaded from: classes3.dex */
public final class FastScroller extends LinearLayout {
    public static final int A = 5;

    /* renamed from: w */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: x */
    public static final int f12844x = 100;

    /* renamed from: y */
    public static final int f12845y = 300;

    /* renamed from: z */
    public static final int f12846z = 1500;

    /* renamed from: b, reason: from kotlin metadata */
    @ColorInt
    public int mBubbleColor;

    /* renamed from: c, reason: from kotlin metadata */
    @ColorInt
    public int mHandleColor;

    /* renamed from: d, reason: from kotlin metadata */
    public int mBubbleHeight;

    /* renamed from: e */
    public int mHandleHeight;

    /* renamed from: f, reason: from kotlin metadata */
    public int mViewHeight;

    /* renamed from: g, reason: from kotlin metadata */
    public boolean mFadeScrollbar;

    /* renamed from: h, reason: from kotlin metadata */
    public boolean mShowBubble;

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public b mSectionIndexer;

    /* renamed from: j, reason: from kotlin metadata */
    @l
    public ViewPropertyAnimator mScrollbarAnimator;

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public ViewPropertyAnimator mBubbleAnimator;

    /* renamed from: l */
    @l
    public RecyclerView mRecyclerView;

    /* renamed from: m, reason: from kotlin metadata */
    public TextView mBubbleView;

    /* renamed from: n, reason: from kotlin metadata */
    public ImageView mHandleView;

    /* renamed from: o, reason: from kotlin metadata */
    public ImageView mTrackView;

    /* renamed from: p, reason: from kotlin metadata */
    public View mScrollbar;

    /* renamed from: q, reason: from kotlin metadata */
    @l
    public Drawable mBubbleImage;

    /* renamed from: r */
    @l
    public Drawable mHandleImage;

    /* renamed from: s, reason: from kotlin metadata */
    @l
    public Drawable mTrackImage;

    /* renamed from: t */
    @l
    public a mFastScrollStateChangeListener;

    /* renamed from: u, reason: from kotlin metadata */
    @k
    public final Runnable mScrollbarHider;

    /* renamed from: v, reason: from kotlin metadata */
    @k
    public final FastScroller$mScrollListener$1 mScrollListener;

    /* renamed from: com.martian.libmars.widget.scroller.FastScroller$a */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public interface b {
        @k
        String a(int i10);
    }

    public static final class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@k Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationCancel(animation);
            TextView textView = FastScroller.this.mBubbleView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBubbleView");
                textView = null;
            }
            textView.setVisibility(4);
            FastScroller.this.mBubbleAnimator = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@k Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationEnd(animation);
            TextView textView = FastScroller.this.mBubbleView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBubbleView");
                textView = null;
            }
            textView.setVisibility(4);
            FastScroller.this.mBubbleAnimator = null;
        }
    }

    public static final class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@k Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationCancel(animation);
            View view = FastScroller.this.mScrollbar;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mScrollbar");
                view = null;
            }
            view.setVisibility(4);
            FastScroller.this.mScrollbarAnimator = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@k Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationEnd(animation);
            View view = FastScroller.this.mScrollbar;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mScrollbar");
                view = null;
            }
            view.setVisibility(4);
            FastScroller.this.mScrollbarAnimator = null;
        }
    }

    public static final class e extends AnimatorListenerAdapter {
    }

    public static final class f extends AnimatorListenerAdapter {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FastScroller(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void B(FastScroller this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x();
    }

    public static final void r(FastScroller this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setViewPositions(this$0.u(this$0.mRecyclerView));
    }

    private final void setHandleSelected(boolean selected) {
        ImageView imageView = this.mHandleView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandleView");
            imageView = null;
        }
        imageView.setSelected(selected);
        if (this.mHandleColor != 0) {
            Drawable drawable = this.mHandleImage;
            Intrinsics.checkNotNull(drawable);
            C(drawable, selected ? this.mBubbleColor : this.mHandleColor);
        }
    }

    private final void setRecyclerViewPosition(float y10) {
        RecyclerView.Adapter adapter;
        RecyclerView.LayoutManager layoutManager;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || (adapter = recyclerView.getAdapter()) == null) {
            return;
        }
        int pageSize = adapter.getPageSize();
        ImageView imageView = this.mHandleView;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandleView");
            imageView = null;
        }
        float f10 = 0.0f;
        if (imageView.getY() != 0.0f) {
            ImageView imageView2 = this.mHandleView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHandleView");
                imageView2 = null;
            }
            float y11 = imageView2.getY() + this.mHandleHeight;
            int i10 = this.mViewHeight;
            f10 = y11 >= ((float) (i10 + (-5))) ? 1.0f : y10 / i10;
        }
        int roundToInt = MathKt.roundToInt(f10 * pageSize);
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (y(recyclerView2 != null ? recyclerView2.getLayoutManager() : null)) {
            roundToInt = pageSize - roundToInt;
        }
        int v10 = v(0, pageSize - 1, roundToInt);
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 != null && (layoutManager = recyclerView3.getLayoutManager()) != null) {
            layoutManager.scrollToPosition(v10);
        }
        b bVar = this.mSectionIndexer;
        if (bVar == null || !this.mShowBubble) {
            return;
        }
        TextView textView2 = this.mBubbleView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBubbleView");
        } else {
            textView = textView2;
        }
        textView.setText(bVar.a(v10));
    }

    public final void setViewPositions(float y10) {
        TextView textView = this.mBubbleView;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBubbleView");
            textView = null;
        }
        this.mBubbleHeight = textView.getHeight();
        ImageView imageView2 = this.mHandleView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandleView");
            imageView2 = null;
        }
        int height = imageView2.getHeight();
        this.mHandleHeight = height;
        int i10 = this.mViewHeight;
        int i11 = this.mBubbleHeight;
        int v10 = v(0, (i10 - i11) - (height / 2), (int) (y10 - i11));
        int v11 = v(0, this.mViewHeight - this.mHandleHeight, (int) (y10 - (r6 / 2)));
        if (this.mShowBubble) {
            TextView textView2 = this.mBubbleView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBubbleView");
                textView2 = null;
            }
            textView2.setY(v10);
        }
        ImageView imageView3 = this.mHandleView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandleView");
        } else {
            imageView = imageView3;
        }
        imageView.setY(v11);
    }

    public final void A(Context context, AttributeSet attributeSet) {
        boolean z10;
        int i10;
        int i11;
        boolean z11;
        View.inflate(context, R.layout.view_fastscroller, this);
        int i12 = 0;
        setClipChildren(false);
        setOrientation(0);
        View findViewById = findViewById(R.id.fastscroll_bubble);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mBubbleView = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.fastscroll_handle);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mHandleView = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.fastscroll_track);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.mTrackView = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.fastscroll_scrollbar);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.mScrollbar = findViewById4;
        int i13 = -16777216;
        boolean z12 = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FastScroller, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
            try {
                i10 = obtainStyledAttributes.getColor(R.styleable.FastScroller_bubbleColor, 0);
                i11 = obtainStyledAttributes.getColor(R.styleable.FastScroller_handleColor, 0);
                int color = obtainStyledAttributes.getColor(R.styleable.FastScroller_trackColor, 0);
                i13 = obtainStyledAttributes.getColor(R.styleable.FastScroller_bubbleTextColor, -16777216);
                z12 = obtainStyledAttributes.getBoolean(R.styleable.FastScroller_fadeScrollbar, true);
                z11 = obtainStyledAttributes.getBoolean(R.styleable.FastScroller_showBubble, false);
                boolean z13 = obtainStyledAttributes.getBoolean(R.styleable.FastScroller_showTrack, false);
                obtainStyledAttributes.recycle();
                z10 = z13;
                i12 = color;
            } catch (Throwable th2) {
                obtainStyledAttributes.recycle();
                throw th2;
            }
        } else {
            z10 = false;
            i10 = 0;
            i11 = 0;
            z11 = false;
        }
        setTrackColor(i12);
        setHandleColor(i11);
        setBubbleColor(i10);
        setBubbleTextColor(i13);
        setFadeScrollbar(z12);
        setBubbleVisible(z11);
        setTrackVisible(z10);
    }

    public final void C(Drawable drawable, int color) {
        if (color == 0) {
            return;
        }
        DrawableCompat.setTint(drawable, color);
    }

    public final void D(int leftMargin, int topMargin, int rightMargin, int bottomMargin) {
        ImageView imageView = this.mHandleView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandleView");
            imageView = null;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.leftMargin = leftMargin;
            marginLayoutParams.topMargin = topMargin;
            marginLayoutParams.rightMargin = rightMargin;
            marginLayoutParams.bottomMargin = bottomMargin;
        }
    }

    public final void E() {
        TextView textView = this.mBubbleView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBubbleView");
            textView = null;
        }
        if (z(textView)) {
            return;
        }
        TextView textView3 = this.mBubbleView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBubbleView");
            textView3 = null;
        }
        textView3.setVisibility(0);
        TextView textView4 = this.mBubbleView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBubbleView");
        } else {
            textView2 = textView4;
        }
        this.mBubbleAnimator = textView2.animate().alpha(1.0f).setDuration(100L).setListener(new e());
    }

    public final void F() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || recyclerView.computeVerticalScrollRange() - this.mViewHeight <= 0) {
            return;
        }
        float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.fastscroll_scrollbar_padding_end);
        View view = this.mScrollbar;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollbar");
            view = null;
        }
        view.setTranslationX(dimensionPixelSize);
        View view3 = this.mScrollbar;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollbar");
            view3 = null;
        }
        view3.setVisibility(0);
        View view4 = this.mScrollbar;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollbar");
        } else {
            view2 = view4;
        }
        this.mScrollbarAnimator = view2.animate().translationX(0.0f).alpha(1.0f).setDuration(300L).setListener(new f());
    }

    public final void G() {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        TextView textView = this.mBubbleView;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBubbleView");
            textView = null;
        }
        textView.measure(makeMeasureSpec, makeMeasureSpec);
        TextView textView2 = this.mBubbleView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBubbleView");
            textView2 = null;
        }
        this.mBubbleHeight = textView2.getMeasuredHeight();
        ImageView imageView2 = this.mHandleView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandleView");
            imageView2 = null;
        }
        imageView2.measure(makeMeasureSpec, makeMeasureSpec);
        ImageView imageView3 = this.mHandleView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandleView");
        } else {
            imageView = imageView3;
        }
        this.mHandleHeight = imageView.getMeasuredHeight();
    }

    @Override // android.view.View
    public void onSizeChanged(int r12, int h10, int oldw, int oldh) {
        super.onSizeChanged(r12, h10, oldw, oldh);
        this.mViewHeight = h10;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@k MotionEvent r82) {
        Intrinsics.checkNotNullParameter(r82, "event");
        int action = r82.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float y10 = r82.getY();
                    setViewPositions(y10);
                    setRecyclerViewPosition(y10);
                    return true;
                }
                if (action != 3) {
                    return super.onTouchEvent(r82);
                }
            }
            requestDisallowInterceptTouchEvent(false);
            setHandleSelected(false);
            if (this.mFadeScrollbar) {
                getHandler().postDelayed(this.mScrollbarHider, qe.a.f30009d);
            }
            w();
            a aVar = this.mFastScrollStateChangeListener;
            if (aVar != null) {
                Intrinsics.checkNotNull(aVar);
                aVar.a(this);
            }
            return true;
        }
        float x10 = r82.getX();
        ImageView imageView = this.mHandleView;
        View view = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandleView");
            imageView = null;
        }
        float x11 = imageView.getX();
        ImageView imageView2 = this.mHandleView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandleView");
            imageView2 = null;
        }
        if (x10 < x11 - ViewCompat.getPaddingStart(imageView2)) {
            return false;
        }
        View view2 = this.mScrollbar;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollbar");
        } else {
            view = view2;
        }
        if (view.getVisibility() != 0) {
            return false;
        }
        requestDisallowInterceptTouchEvent(true);
        setHandleSelected(true);
        getHandler().removeCallbacks(this.mScrollbarHider);
        s(this.mScrollbarAnimator);
        s(this.mBubbleAnimator);
        if (this.mShowBubble && this.mSectionIndexer != null) {
            E();
        }
        a aVar2 = this.mFastScrollStateChangeListener;
        if (aVar2 != null) {
            Intrinsics.checkNotNull(aVar2);
            aVar2.b(this);
        }
        float y11 = r82.getY();
        setViewPositions(y11);
        setRecyclerViewPosition(y11);
        return true;
    }

    @ColorInt
    public final int p(@ColorInt int color, @FloatRange(from = 0.0d, to = 1.0d) float factor) {
        return Color.argb(MathKt.roundToInt(Color.alpha(color) * factor), Color.red(color), Color.green(color), Color.blue(color));
    }

    public final void q(@k RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.mRecyclerView = recyclerView;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.addOnScrollListener(this.mScrollListener);
        post(new Runnable() { // from class: w9.b
            public /* synthetic */ b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                FastScroller.r(FastScroller.this);
            }
        });
    }

    public final void s(ViewPropertyAnimator animator) {
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void setBubbleColor(@ColorInt int color) {
        Drawable drawable;
        this.mBubbleColor = color;
        if (this.mBubbleImage == null && (drawable = ContextCompat.getDrawable(getContext(), R.drawable.fastscroll_bubble)) != null) {
            this.mBubbleImage = DrawableCompat.wrap(drawable);
        }
        Drawable drawable2 = this.mBubbleImage;
        Intrinsics.checkNotNull(drawable2);
        C(drawable2, this.mBubbleColor);
        TextView textView = this.mBubbleView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBubbleView");
            textView = null;
        }
        textView.setBackground(this.mBubbleImage);
    }

    public final void setBubbleTextColor(@ColorInt int color) {
        TextView textView = this.mBubbleView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBubbleView");
            textView = null;
        }
        textView.setTextColor(color);
    }

    public final void setBubbleVisible(boolean visible) {
        this.mShowBubble = visible;
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        setVisibility(enabled ? 0 : 4);
    }

    public final void setFadeScrollbar(boolean fadeScrollbar) {
        this.mFadeScrollbar = fadeScrollbar;
        View view = this.mScrollbar;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollbar");
            view = null;
        }
        view.setVisibility(fadeScrollbar ? 4 : 0);
    }

    public final void setFastScrollStateChangeListener(@k a fastScrollStateChangeListener) {
        Intrinsics.checkNotNullParameter(fastScrollStateChangeListener, "fastScrollStateChangeListener");
        this.mFastScrollStateChangeListener = fastScrollStateChangeListener;
    }

    public final void setHandleColor(@ColorInt int color) {
        Drawable drawable;
        this.mHandleColor = color;
        if (this.mHandleImage == null && (drawable = ContextCompat.getDrawable(getContext(), R.drawable.fastscroll_handle)) != null) {
            this.mHandleImage = DrawableCompat.wrap(drawable);
        }
        Drawable drawable2 = this.mHandleImage;
        Intrinsics.checkNotNull(drawable2);
        C(drawable2, this.mHandleColor);
        ImageView imageView = this.mHandleView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandleView");
            imageView = null;
        }
        imageView.setImageDrawable(this.mHandleImage);
    }

    public final void setHandleDrawable(@DrawableRes int drawableRes) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), drawableRes);
        if (drawable != null) {
            this.mHandleImage = DrawableCompat.wrap(drawable);
        }
        Drawable drawable2 = this.mHandleImage;
        Intrinsics.checkNotNull(drawable2);
        C(drawable2, this.mHandleColor);
        ImageView imageView = this.mHandleView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandleView");
            imageView = null;
        }
        imageView.setImageDrawable(this.mHandleImage);
    }

    public final void setHandleViewColorFilter(@ColorInt int color) {
        ImageView imageView = this.mHandleView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandleView");
            imageView = null;
        }
        imageView.setColorFilter(color);
    }

    @Override // android.view.View
    public void setLayoutParams(@k ViewGroup.LayoutParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        params.width = -2;
        super.setLayoutParams(params);
    }

    public final void setSectionIndexer(@l b sectionIndexer) {
        this.mSectionIndexer = sectionIndexer;
    }

    public final void setTrackColor(@ColorInt int color) {
        Drawable drawable;
        if (this.mTrackImage == null && (drawable = ContextCompat.getDrawable(getContext(), R.drawable.fastscroll_track)) != null) {
            this.mTrackImage = DrawableCompat.wrap(drawable);
        }
        Drawable drawable2 = this.mTrackImage;
        Intrinsics.checkNotNull(drawable2);
        C(drawable2, color);
        ImageView imageView = this.mTrackView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTrackView");
            imageView = null;
        }
        imageView.setImageDrawable(this.mTrackImage);
    }

    public final void setTrackVisible(boolean visible) {
        ImageView imageView = this.mTrackView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTrackView");
            imageView = null;
        }
        imageView.setVisibility(visible ? 0 : 4);
    }

    public final void t() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            Intrinsics.checkNotNull(recyclerView);
            recyclerView.removeOnScrollListener(this.mScrollListener);
            this.mRecyclerView = null;
        }
    }

    public final float u(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return 0.0f;
        }
        int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        int computeVerticalScrollRange = recyclerView.computeVerticalScrollRange();
        int i10 = this.mViewHeight;
        float f10 = computeVerticalScrollRange - i10;
        float f11 = computeVerticalScrollOffset;
        if (f10 <= 0.0f) {
            f10 = 1.0f;
        }
        return i10 * (f11 / f10);
    }

    public final int v(int min, int max, int value) {
        return Math.min(Math.max(min, value), max);
    }

    public final void w() {
        TextView textView = this.mBubbleView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBubbleView");
            textView = null;
        }
        if (z(textView)) {
            TextView textView3 = this.mBubbleView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBubbleView");
            } else {
                textView2 = textView3;
            }
            this.mBubbleAnimator = textView2.animate().alpha(0.0f).setDuration(100L).setListener(new c());
        }
    }

    public final void x() {
        float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.fastscroll_scrollbar_padding_end);
        View view = this.mScrollbar;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollbar");
            view = null;
        }
        this.mScrollbarAnimator = view.animate().translationX(dimensionPixelSize).alpha(0.0f).setDuration(300L).setListener(new d());
    }

    public final boolean y(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).getReverseLayout();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getReverseLayout();
        }
        return false;
    }

    public final boolean z(View view) {
        return view != null && view.getVisibility() == 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastScroller(@k Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mScrollbarHider = new Runnable() { // from class: w9.c
            public /* synthetic */ c() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                FastScroller.B(FastScroller.this);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.martian.libmars.widget.scroller.FastScroller$mScrollListener$1
            public FastScroller$mScrollListener$1() {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@k RecyclerView recyclerView, int newState) {
                boolean z10;
                ImageView imageView;
                Runnable runnable;
                Runnable runnable2;
                ViewPropertyAnimator viewPropertyAnimator;
                boolean z11;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, newState);
                if (FastScroller.this.isEnabled()) {
                    View view = null;
                    if (newState == 0) {
                        z10 = FastScroller.this.mFadeScrollbar;
                        if (z10) {
                            imageView = FastScroller.this.mHandleView;
                            if (imageView == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mHandleView");
                            } else {
                                view = imageView;
                            }
                            if (view.isSelected()) {
                                return;
                            }
                            Handler handler = FastScroller.this.getHandler();
                            runnable = FastScroller.this.mScrollbarHider;
                            handler.postDelayed(runnable, qe.a.f30009d);
                            return;
                        }
                        return;
                    }
                    if (newState != 1) {
                        return;
                    }
                    Handler handler2 = FastScroller.this.getHandler();
                    runnable2 = FastScroller.this.mScrollbarHider;
                    handler2.removeCallbacks(runnable2);
                    FastScroller fastScroller = FastScroller.this;
                    viewPropertyAnimator = fastScroller.mScrollbarAnimator;
                    fastScroller.s(viewPropertyAnimator);
                    FastScroller fastScroller2 = FastScroller.this;
                    View view2 = fastScroller2.mScrollbar;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mScrollbar");
                    } else {
                        view = view2;
                    }
                    z11 = fastScroller2.z(view);
                    if (z11) {
                        return;
                    }
                    FastScroller.this.F();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@k RecyclerView recyclerView, int dx, int dy) {
                ImageView imageView;
                float u10;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                imageView = FastScroller.this.mHandleView;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHandleView");
                    imageView = null;
                }
                if (imageView.isSelected() || !FastScroller.this.isEnabled()) {
                    return;
                }
                FastScroller fastScroller = FastScroller.this;
                u10 = fastScroller.u(recyclerView);
                fastScroller.setViewPositions(u10);
            }
        };
        A(context, null);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    }

    public final void setLayoutParams(@k ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        RecyclerView recyclerView = this.mRecyclerView;
        int id2 = recyclerView != null ? recyclerView.getId() : -1;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.fastscroll_scrollbar_margin_top);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.fastscroll_scrollbar_margin_bottom);
        if (id2 != -1) {
            if (viewGroup instanceof ConstraintLayout) {
                ConstraintSet constraintSet = new ConstraintSet();
                int id3 = getId();
                ConstraintLayout constraintLayout = (ConstraintLayout) viewGroup;
                constraintSet.clone(constraintLayout);
                constraintSet.connect(id3, 3, id2, 3);
                constraintSet.connect(id3, 4, id2, 4);
                constraintSet.connect(id3, 7, id2, 7);
                constraintSet.applyTo(constraintLayout);
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize2);
                setLayoutParams(layoutParams2);
            } else if (viewGroup instanceof CoordinatorLayout) {
                ViewGroup.LayoutParams layoutParams3 = getLayoutParams();
                Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
                CoordinatorLayout.LayoutParams layoutParams4 = (CoordinatorLayout.LayoutParams) layoutParams3;
                layoutParams4.setAnchorId(id2);
                layoutParams4.anchorGravity = GravityCompat.END;
                layoutParams4.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize2);
                setLayoutParams(layoutParams4);
            } else if (viewGroup instanceof FrameLayout) {
                ViewGroup.LayoutParams layoutParams5 = getLayoutParams();
                Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) layoutParams5;
                layoutParams6.gravity = GravityCompat.END;
                layoutParams6.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize2);
                setLayoutParams(layoutParams6);
            } else if (viewGroup instanceof RelativeLayout) {
                ViewGroup.LayoutParams layoutParams7 = getLayoutParams();
                Intrinsics.checkNotNull(layoutParams7, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) layoutParams7;
                layoutParams8.addRule(6, id2);
                layoutParams8.addRule(8, id2);
                layoutParams8.addRule(19, id2);
                layoutParams8.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize2);
                setLayoutParams(layoutParams8);
            } else {
                throw new IllegalArgumentException("Parent ViewGroup must be a ConstraintLayout, CoordinatorLayout, FrameLayout, or RelativeLayout");
            }
            G();
            return;
        }
        throw new IllegalArgumentException("RecyclerView must have a view ID".toString());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FastScroller(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mScrollbarHider = new Runnable() { // from class: w9.c
            public /* synthetic */ c() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                FastScroller.B(FastScroller.this);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.martian.libmars.widget.scroller.FastScroller$mScrollListener$1
            public FastScroller$mScrollListener$1() {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@k RecyclerView recyclerView, int newState) {
                boolean z10;
                ImageView imageView;
                Runnable runnable;
                Runnable runnable2;
                ViewPropertyAnimator viewPropertyAnimator;
                boolean z11;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, newState);
                if (FastScroller.this.isEnabled()) {
                    View view = null;
                    if (newState == 0) {
                        z10 = FastScroller.this.mFadeScrollbar;
                        if (z10) {
                            imageView = FastScroller.this.mHandleView;
                            if (imageView == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mHandleView");
                            } else {
                                view = imageView;
                            }
                            if (view.isSelected()) {
                                return;
                            }
                            Handler handler = FastScroller.this.getHandler();
                            runnable = FastScroller.this.mScrollbarHider;
                            handler.postDelayed(runnable, qe.a.f30009d);
                            return;
                        }
                        return;
                    }
                    if (newState != 1) {
                        return;
                    }
                    Handler handler2 = FastScroller.this.getHandler();
                    runnable2 = FastScroller.this.mScrollbarHider;
                    handler2.removeCallbacks(runnable2);
                    FastScroller fastScroller = FastScroller.this;
                    viewPropertyAnimator = fastScroller.mScrollbarAnimator;
                    fastScroller.s(viewPropertyAnimator);
                    FastScroller fastScroller2 = FastScroller.this;
                    View view2 = fastScroller2.mScrollbar;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mScrollbar");
                    } else {
                        view = view2;
                    }
                    z11 = fastScroller2.z(view);
                    if (z11) {
                        return;
                    }
                    FastScroller.this.F();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@k RecyclerView recyclerView, int dx, int dy) {
                ImageView imageView;
                float u10;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                imageView = FastScroller.this.mHandleView;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHandleView");
                    imageView = null;
                }
                if (imageView.isSelected() || !FastScroller.this.isEnabled()) {
                    return;
                }
                FastScroller fastScroller = FastScroller.this;
                u10 = fastScroller.u(recyclerView);
                fastScroller.setViewPositions(u10);
            }
        };
        A(context, attributeSet);
        LinearLayout.LayoutParams generateLayoutParams = generateLayoutParams(attributeSet);
        Intrinsics.checkNotNullExpressionValue(generateLayoutParams, "generateLayoutParams(...)");
        setLayoutParams(generateLayoutParams);
    }

    public /* synthetic */ FastScroller(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
