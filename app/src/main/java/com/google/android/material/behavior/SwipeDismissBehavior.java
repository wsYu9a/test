package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;

/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a */
    public static final int f6742a = 0;

    /* renamed from: b */
    public static final int f6743b = 1;

    /* renamed from: c */
    public static final int f6744c = 2;

    /* renamed from: d */
    public static final int f6745d = 0;

    /* renamed from: e */
    public static final int f6746e = 1;

    /* renamed from: f */
    public static final int f6747f = 2;

    /* renamed from: g */
    private static final float f6748g = 0.5f;

    /* renamed from: h */
    private static final float f6749h = 0.0f;

    /* renamed from: i */
    private static final float f6750i = 0.5f;

    /* renamed from: j */
    ViewDragHelper f6751j;
    c k;
    private boolean l;
    private boolean n;
    private float m = 0.0f;
    int o = 2;
    float p = 0.5f;
    float q = 0.0f;
    float r = 0.5f;
    private final ViewDragHelper.Callback s = new a();

    class a extends ViewDragHelper.Callback {

        /* renamed from: a */
        private static final int f6752a = -1;

        /* renamed from: b */
        private int f6753b;

        /* renamed from: c */
        private int f6754c = -1;

        a() {
        }

        private boolean a(@NonNull View view, float f2) {
            if (f2 == 0.0f) {
                return Math.abs(view.getLeft() - this.f6753b) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.p);
            }
            boolean z = ViewCompat.getLayoutDirection(view) == 1;
            int i2 = SwipeDismissBehavior.this.o;
            if (i2 == 2) {
                return true;
            }
            if (i2 == 0) {
                if (z) {
                    if (f2 >= 0.0f) {
                        return false;
                    }
                } else if (f2 <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (i2 != 1) {
                return false;
            }
            if (z) {
                if (f2 <= 0.0f) {
                    return false;
                }
            } else if (f2 >= 0.0f) {
                return false;
            }
            return true;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@NonNull View view, int i2, int i3) {
            int width;
            int width2;
            int width3;
            boolean z = ViewCompat.getLayoutDirection(view) == 1;
            int i4 = SwipeDismissBehavior.this.o;
            if (i4 == 0) {
                if (z) {
                    width = this.f6753b - view.getWidth();
                    width2 = this.f6753b;
                } else {
                    width = this.f6753b;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i4 != 1) {
                width = this.f6753b - view.getWidth();
                width2 = view.getWidth() + this.f6753b;
            } else if (z) {
                width = this.f6753b;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.f6753b - view.getWidth();
                width2 = this.f6753b;
            }
            return SwipeDismissBehavior.c(width, i2, width2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NonNull View view, int i2, int i3) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(@NonNull View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(@NonNull View view, int i2) {
            this.f6754c = i2;
            this.f6753b = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i2) {
            c cVar = SwipeDismissBehavior.this.k;
            if (cVar != null) {
                cVar.b(i2);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i2, int i3, int i4, int i5) {
            float width = this.f6753b + (view.getWidth() * SwipeDismissBehavior.this.q);
            float width2 = this.f6753b + (view.getWidth() * SwipeDismissBehavior.this.r);
            float f2 = i2;
            if (f2 <= width) {
                view.setAlpha(1.0f);
            } else if (f2 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.b(0.0f, 1.0f - SwipeDismissBehavior.e(width, width2, f2), 1.0f));
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@NonNull View view, float f2, float f3) {
            int i2;
            boolean z;
            c cVar;
            this.f6754c = -1;
            int width = view.getWidth();
            if (a(view, f2)) {
                int left = view.getLeft();
                int i3 = this.f6753b;
                i2 = left < i3 ? i3 - width : i3 + width;
                z = true;
            } else {
                i2 = this.f6753b;
                z = false;
            }
            if (SwipeDismissBehavior.this.f6751j.settleCapturedViewAt(i2, view.getTop())) {
                ViewCompat.postOnAnimation(view, new d(view, z));
            } else {
                if (!z || (cVar = SwipeDismissBehavior.this.k) == null) {
                    return;
                }
                cVar.a(view);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i2) {
            int i3 = this.f6754c;
            return (i3 == -1 || i3 == i2) && SwipeDismissBehavior.this.a(view);
        }
    }

    class b implements AccessibilityViewCommand {
        b() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
            boolean z = false;
            if (!SwipeDismissBehavior.this.a(view)) {
                return false;
            }
            boolean z2 = ViewCompat.getLayoutDirection(view) == 1;
            int i2 = SwipeDismissBehavior.this.o;
            if ((i2 == 0 && z2) || (i2 == 1 && !z2)) {
                z = true;
            }
            int width = view.getWidth();
            if (z) {
                width = -width;
            }
            ViewCompat.offsetLeftAndRight(view, width);
            view.setAlpha(0.0f);
            c cVar = SwipeDismissBehavior.this.k;
            if (cVar != null) {
                cVar.a(view);
            }
            return true;
        }
    }

    public interface c {
        void a(View view);

        void b(int i2);
    }

    private class d implements Runnable {

        /* renamed from: a */
        private final View f6757a;

        /* renamed from: b */
        private final boolean f6758b;

        d(View view, boolean z) {
            this.f6757a = view;
            this.f6758b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.f6751j;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.f6757a, this);
            } else {
                if (!this.f6758b || (cVar = SwipeDismissBehavior.this.k) == null) {
                    return;
                }
                cVar.a(this.f6757a);
            }
        }
    }

    static float b(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    static int c(int i2, int i3, int i4) {
        return Math.min(Math.max(i2, i3), i4);
    }

    private void d(ViewGroup viewGroup) {
        if (this.f6751j == null) {
            this.f6751j = this.n ? ViewDragHelper.create(viewGroup, this.m, this.s) : ViewDragHelper.create(viewGroup, this.s);
        }
    }

    static float e(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    private void n(View view) {
        ViewCompat.removeAccessibilityAction(view, 1048576);
        if (a(view)) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new b());
        }
    }

    public boolean a(@NonNull View view) {
        return true;
    }

    public int f() {
        ViewDragHelper viewDragHelper = this.f6751j;
        if (viewDragHelper != null) {
            return viewDragHelper.getViewDragState();
        }
        return 0;
    }

    @Nullable
    @VisibleForTesting
    public c g() {
        return this.k;
    }

    public void h(float f2) {
        this.p = b(0.0f, f2, 1.0f);
    }

    public void i(float f2) {
        this.r = b(0.0f, f2, 1.0f);
    }

    public void j(@Nullable c cVar) {
        this.k = cVar;
    }

    public void k(float f2) {
        this.m = f2;
        this.n = true;
    }

    public void l(float f2) {
        this.q = b(0.0f, f2, 1.0f);
    }

    public void m(int i2) {
        this.o = i2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        boolean z = this.l;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z = coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.l = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.l = false;
        }
        if (!z) {
            return false;
        }
        d(coordinatorLayout);
        return this.f6751j.shouldInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, v, i2);
        if (ViewCompat.getImportantForAccessibility(v) == 0) {
            ViewCompat.setImportantForAccessibility(v, 1);
            n(v);
        }
        return onLayoutChild;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper = this.f6751j;
        if (viewDragHelper == null) {
            return false;
        }
        viewDragHelper.processTouchEvent(motionEvent);
        return true;
    }
}
