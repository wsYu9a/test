package com.kwad.components.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.kwad.components.core.s.o;
import com.kwad.sdk.utils.w;

/* loaded from: classes3.dex */
public class DetailWebRecycleView extends b {
    private int RH;
    private boolean RI;
    private boolean RJ;
    private int RK;
    private int RL;
    private boolean RM;
    a RN;
    private Runnable RO;
    private o RP;
    private int nu;

    /* renamed from: com.kwad.components.core.page.recycle.DetailWebRecycleView$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Object field = w.getField(DetailWebRecycleView.this, "mGapWorker");
                if (field != null) {
                    w.callMethod(field, "postFromTraversal", DetailWebRecycleView.this, 0, Integer.valueOf(DetailWebRecycleView.this.RH));
                }
            } catch (RuntimeException e10) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            }
        }
    }

    public interface a {
        boolean qI();
    }

    public DetailWebRecycleView(Context context) {
        this(context, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this.RP, 50L);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.RP);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar = this.RN;
        if (aVar != null && aVar.qI()) {
            return true;
        }
        this.RL = computeVerticalScrollOffset();
        if (motionEvent.getY() <= this.RK - this.RL) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.RL = computeVerticalScrollOffset;
        if (computeVerticalScrollOffset >= this.RK) {
            return false;
        }
        fling((int) f10, (int) f11);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.RL = computeVerticalScrollOffset;
        if (i11 > 0 && computeVerticalScrollOffset < this.RK && !this.RM && computeVerticalScrollOffset < this.nu) {
            scrollBy(0, i11);
            iArr[1] = i11;
        }
        if (i11 >= 0 || this.RL <= 0 || ViewCompat.canScrollVertically(view, -1)) {
            return;
        }
        scrollBy(0, i11);
        iArr[1] = i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i10) {
        super.onScrollStateChanged(i10);
        if (i10 == 0) {
            View childAt = getLayoutManager().getChildAt(getLayoutManager().getChildCount() - 1);
            if (childAt != null) {
                int bottom = childAt.getBottom();
                int bottom2 = getBottom() - getPaddingBottom();
                int position = getLayoutManager().getPosition(childAt);
                if (bottom == bottom2 && position == getLayoutManager().getItemCount() - 1) {
                    this.RM = true;
                    return;
                }
            }
            this.RM = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return (i10 & 2) != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.RJ) {
            this.RJ = false;
        } else {
            if (this.RI) {
                return;
            }
            super.requestChildFocus(view, view2);
        }
    }

    public void setInterceptRequestFocusForWeb(boolean z10) {
        this.RI = z10;
    }

    public void setInterceptRequestFocusForWebFiredOnce(boolean z10) {
        this.RJ = z10;
    }

    public void setInterceptTouchListener(a aVar) {
        this.RN = aVar;
    }

    public void setTopViewHeight(int i10) {
        this.RK = i10;
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.RH = 1000;
        this.RI = false;
        this.RJ = false;
        AnonymousClass1 anonymousClass1 = new Runnable() { // from class: com.kwad.components.core.page.recycle.DetailWebRecycleView.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Object field = w.getField(DetailWebRecycleView.this, "mGapWorker");
                    if (field != null) {
                        w.callMethod(field, "postFromTraversal", DetailWebRecycleView.this, 0, Integer.valueOf(DetailWebRecycleView.this.RH));
                    }
                } catch (RuntimeException e10) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
                }
            }
        };
        this.RO = anonymousClass1;
        this.RP = new o(anonymousClass1);
        if (context instanceof Activity) {
            this.nu = com.kwad.sdk.c.a.a.g((Activity) context);
        } else {
            this.nu = com.kwad.sdk.c.a.a.getScreenHeight(context);
        }
    }
}
