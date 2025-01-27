package com.martian.libmars.widget.scroller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.libmars.R;
import com.martian.libmars.widget.scroller.FastScroller;
import com.umeng.analytics.pro.f;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import w9.a;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0004\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u001aJ\u0015\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0017¢\u0006\u0004\b\u001e\u0010\u001aJ\u0017\u0010 \u001a\u00020\r2\b\b\u0001\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b \u0010\u0012J\u0017\u0010!\u001a\u00020\r2\b\b\u0001\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b!\u0010\u0012J\u0015\u0010\"\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0017¢\u0006\u0004\b\"\u0010\u001aJ\u0017\u0010#\u001a\u00020\r2\b\b\u0001\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b#\u0010\u0012J\u0017\u0010$\u001a\u00020\r2\b\b\u0001\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b$\u0010\u0012J\u0017\u0010&\u001a\u00020\r2\b\b\u0001\u0010%\u001a\u00020\b¢\u0006\u0004\b&\u0010\u0012J\u0017\u0010'\u001a\u00020\r2\b\b\u0001\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b'\u0010\u0012J-\u0010,\u001a\u00020\r2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b¢\u0006\u0004\b,\u0010-J\u0015\u00100\u001a\u00020\r2\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\rH\u0014¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\rH\u0014¢\u0006\u0004\b4\u00103J!\u00105\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b5\u00106R\u0016\u00109\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b,\u00108¨\u0006:"}, d2 = {"Lcom/martian/libmars/widget/scroller/FastScrollRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", f.X, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "visibility", "setVisibility", "(I)V", "Lcom/martian/libmars/widget/scroller/FastScroller$b;", "sectionIndexer", "setSectionIndexer", "(Lcom/martian/libmars/widget/scroller/FastScroller$b;)V", "", "enabled", "setFastScrollEnabled", "(Z)V", "hideScrollbar", "setHideScrollbar", "visible", "setTrackVisible", "color", "setTrackColor", "setHandleColor", "setBubbleVisible", "setBubbleColor", "setBubbleTextColor", "drawableRes", "setHandleDrawable", "setHandleViewColorFilter", "leftMargin", "topMargin", "rightMargin", "bottomMargin", "b", "(IIII)V", "Lw9/a;", "fastScrollStateChangeListener", "setFastScrollStateChangeListener", "(Lw9/a;)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "a", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/martian/libmars/widget/scroller/FastScroller;", "Lcom/martian/libmars/widget/scroller/FastScroller;", "mFastScroller", "libmars_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class FastScrollRecyclerView extends RecyclerView {

    /* renamed from: b, reason: from kotlin metadata */
    public FastScroller mFastScroller;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FastScrollRecyclerView(@k Context context, @k AttributeSet attrs) {
        this(context, attrs, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }

    public final void a(Context r82, AttributeSet attrs) {
        FastScroller fastScroller = new FastScroller(r82, attrs, 0, 4, null);
        this.mFastScroller = fastScroller;
        fastScroller.setId(R.id.fast_scroller);
    }

    public final void b(int leftMargin, int topMargin, int rightMargin, int bottomMargin) {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFastScroller");
            fastScroller = null;
        }
        fastScroller.D(leftMargin, topMargin, rightMargin, bottomMargin);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        FastScroller fastScroller = this.mFastScroller;
        FastScroller fastScroller2 = null;
        if (fastScroller == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFastScroller");
            fastScroller = null;
        }
        fastScroller.q(this);
        ViewParent parent = getParent();
        while (parent != null) {
            if (parent instanceof ConstraintLayout ? true : parent instanceof CoordinatorLayout ? true : parent instanceof FrameLayout ? true : parent instanceof RelativeLayout) {
                break;
            } else {
                parent = parent.getParent();
            }
        }
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            FastScroller fastScroller3 = this.mFastScroller;
            if (fastScroller3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFastScroller");
                fastScroller3 = null;
            }
            if (viewGroup.indexOfChild(fastScroller3) == -1) {
                FastScroller fastScroller4 = this.mFastScroller;
                if (fastScroller4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFastScroller");
                    fastScroller4 = null;
                }
                viewGroup.addView(fastScroller4);
                FastScroller fastScroller5 = this.mFastScroller;
                if (fastScroller5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFastScroller");
                } else {
                    fastScroller2 = fastScroller5;
                }
                fastScroller2.setLayoutParams(viewGroup);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFastScroller");
            fastScroller = null;
        }
        fastScroller.t();
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(@l RecyclerView.Adapter<?> adapter) {
        super.setAdapter(adapter);
        if (adapter instanceof FastScroller.b) {
            setSectionIndexer((FastScroller.b) adapter);
        } else if (adapter == 0) {
            setSectionIndexer(null);
        }
    }

    public final void setBubbleColor(@ColorInt int color) {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFastScroller");
            fastScroller = null;
        }
        fastScroller.setBubbleColor(color);
    }

    public final void setBubbleTextColor(@ColorInt int color) {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFastScroller");
            fastScroller = null;
        }
        fastScroller.setBubbleTextColor(color);
    }

    public final void setBubbleVisible(boolean visible) {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFastScroller");
            fastScroller = null;
        }
        fastScroller.setBubbleVisible(visible);
    }

    public final void setFastScrollEnabled(boolean enabled) {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFastScroller");
            fastScroller = null;
        }
        fastScroller.setEnabled(enabled);
    }

    public final void setFastScrollStateChangeListener(@k a fastScrollStateChangeListener) {
        Intrinsics.checkNotNullParameter(fastScrollStateChangeListener, "fastScrollStateChangeListener");
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFastScroller");
            fastScroller = null;
        }
        fastScroller.setFastScrollStateChangeListener(fastScrollStateChangeListener);
    }

    public final void setHandleColor(@ColorInt int color) {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFastScroller");
            fastScroller = null;
        }
        fastScroller.setHandleColor(color);
    }

    public final void setHandleDrawable(@DrawableRes int drawableRes) {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFastScroller");
            fastScroller = null;
        }
        fastScroller.setHandleDrawable(drawableRes);
    }

    public final void setHandleViewColorFilter(@ColorInt int color) {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFastScroller");
            fastScroller = null;
        }
        fastScroller.setHandleViewColorFilter(color);
    }

    public final void setHideScrollbar(boolean hideScrollbar) {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFastScroller");
            fastScroller = null;
        }
        fastScroller.setFadeScrollbar(hideScrollbar);
    }

    public final void setSectionIndexer(@l FastScroller.b sectionIndexer) {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFastScroller");
            fastScroller = null;
        }
        fastScroller.setSectionIndexer(sectionIndexer);
    }

    public final void setTrackColor(@ColorInt int color) {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFastScroller");
            fastScroller = null;
        }
        fastScroller.setTrackColor(color);
    }

    public final void setTrackVisible(boolean visible) {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFastScroller");
            fastScroller = null;
        }
        fastScroller.setTrackVisible(visible);
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFastScroller");
            fastScroller = null;
        }
        fastScroller.setVisibility(visibility);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastScrollRecyclerView(@k Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context, null);
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    public /* synthetic */ FastScrollRecyclerView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FastScrollRecyclerView(@k Context context, @k AttributeSet attrs, int i10) {
        super(context, attrs, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        a(context, attrs);
    }
}
