package com.kwad.components.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.kwad.components.core.r.n;
import com.kwad.sdk.utils.s;

/* loaded from: classes2.dex */
public class DetailWebRecycleView extends b {
    private int MA;
    private boolean MB;
    a MC;
    private Runnable MD;
    private n ME;
    private int Mw;
    private boolean Mx;
    private boolean My;
    private int Mz;
    private int mA;

    /* renamed from: com.kwad.components.core.page.recycle.DetailWebRecycleView$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Object d2 = s.d(DetailWebRecycleView.this, "mGapWorker");
                if (d2 != null) {
                    s.a(d2, "postFromTraversal", DetailWebRecycleView.this, 0, Integer.valueOf(DetailWebRecycleView.this.Mw));
                }
            } catch (RuntimeException e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
        }
    }

    public interface a {
        boolean oK();
    }

    public DetailWebRecycleView(Context context) {
        this(context, null);
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Mw = 1000;
        this.Mx = false;
        this.My = false;
        AnonymousClass1 anonymousClass1 = new Runnable() { // from class: com.kwad.components.core.page.recycle.DetailWebRecycleView.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Object d2 = s.d(DetailWebRecycleView.this, "mGapWorker");
                    if (d2 != null) {
                        s.a(d2, "postFromTraversal", DetailWebRecycleView.this, 0, Integer.valueOf(DetailWebRecycleView.this.Mw));
                    }
                } catch (RuntimeException e2) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                }
            }
        };
        this.MD = anonymousClass1;
        this.ME = new n(anonymousClass1);
        this.mA = context instanceof Activity ? com.kwad.sdk.c.kwai.a.d((Activity) context) : com.kwad.sdk.c.kwai.a.getScreenHeight(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this.ME, 50L);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.ME);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar = this.MC;
        if (aVar != null && aVar.oK()) {
            return true;
        }
        this.MA = computeVerticalScrollOffset();
        if (motionEvent.getY() <= this.Mz - this.MA) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.MA = computeVerticalScrollOffset;
        if (computeVerticalScrollOffset >= this.Mz) {
            return false;
        }
        fling((int) f2, (int) f3);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.MA = computeVerticalScrollOffset;
        if ((i3 > 0 && computeVerticalScrollOffset < this.Mz) && !this.MB && computeVerticalScrollOffset < this.mA) {
            scrollBy(0, i3);
            iArr[1] = i3;
        }
        if (i3 < 0 && this.MA > 0 && !ViewCompat.canScrollVertically(view, -1)) {
            scrollBy(0, i3);
            iArr[1] = i3;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i2) {
        super.onScrollStateChanged(i2);
        if (i2 == 0) {
            View childAt = getLayoutManager().getChildAt(getLayoutManager().getChildCount() - 1);
            if (childAt != null) {
                int bottom = childAt.getBottom();
                int bottom2 = getBottom() - getPaddingBottom();
                int position = getLayoutManager().getPosition(childAt);
                if (bottom == bottom2 && position == getLayoutManager().getItemCount() - 1) {
                    this.MB = true;
                    return;
                }
            }
            this.MB = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return (i2 & 2) != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.My) {
            this.My = false;
        } else {
            if (this.Mx) {
                return;
            }
            super.requestChildFocus(view, view2);
        }
    }

    public void setInterceptRequestFocusForWeb(boolean z) {
        this.Mx = z;
    }

    public void setInterceptRequestFocusForWebFiredOnce(boolean z) {
        this.My = z;
    }

    public void setInterceptTouchListener(a aVar) {
        this.MC = aVar;
    }

    public void setTopViewHeight(int i2) {
        this.Mz = i2;
    }
}
