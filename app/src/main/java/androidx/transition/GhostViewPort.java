package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class GhostViewPort extends ViewGroup implements GhostView {

    /* renamed from: a */
    ViewGroup f3775a;

    /* renamed from: b */
    View f3776b;

    /* renamed from: c */
    final View f3777c;

    /* renamed from: d */
    int f3778d;

    /* renamed from: e */
    @Nullable
    private Matrix f3779e;

    /* renamed from: f */
    private final ViewTreeObserver.OnPreDrawListener f3780f;

    /* renamed from: androidx.transition.GhostViewPort$1 */
    class AnonymousClass1 implements ViewTreeObserver.OnPreDrawListener {
        AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            View view;
            ViewCompat.postInvalidateOnAnimation(GhostViewPort.this);
            GhostViewPort ghostViewPort = GhostViewPort.this;
            ViewGroup viewGroup = ghostViewPort.f3775a;
            if (viewGroup == null || (view = ghostViewPort.f3776b) == null) {
                return true;
            }
            viewGroup.endViewTransition(view);
            ViewCompat.postInvalidateOnAnimation(GhostViewPort.this.f3775a);
            GhostViewPort ghostViewPort2 = GhostViewPort.this;
            ghostViewPort2.f3775a = null;
            ghostViewPort2.f3776b = null;
            return true;
        }
    }

    GhostViewPort(View view) {
        super(view.getContext());
        this.f3780f = new ViewTreeObserver.OnPreDrawListener() { // from class: androidx.transition.GhostViewPort.1
            AnonymousClass1() {
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                View view2;
                ViewCompat.postInvalidateOnAnimation(GhostViewPort.this);
                GhostViewPort ghostViewPort = GhostViewPort.this;
                ViewGroup viewGroup = ghostViewPort.f3775a;
                if (viewGroup == null || (view2 = ghostViewPort.f3776b) == null) {
                    return true;
                }
                viewGroup.endViewTransition(view2);
                ViewCompat.postInvalidateOnAnimation(GhostViewPort.this.f3775a);
                GhostViewPort ghostViewPort2 = GhostViewPort.this;
                ghostViewPort2.f3775a = null;
                ghostViewPort2.f3776b = null;
                return true;
            }
        };
        this.f3777c = view;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    static GhostViewPort a(View view, ViewGroup viewGroup, Matrix matrix) {
        GhostViewHolder ghostViewHolder;
        if (!(view.getParent() instanceof ViewGroup)) {
            throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
        }
        GhostViewHolder b2 = GhostViewHolder.b(viewGroup);
        GhostViewPort d2 = d(view);
        int i2 = 0;
        if (d2 != null && (ghostViewHolder = (GhostViewHolder) d2.getParent()) != b2) {
            i2 = d2.f3778d;
            ghostViewHolder.removeView(d2);
            d2 = null;
        }
        if (d2 == null) {
            if (matrix == null) {
                matrix = new Matrix();
                b(view, viewGroup, matrix);
            }
            d2 = new GhostViewPort(view);
            d2.g(matrix);
            if (b2 == null) {
                b2 = new GhostViewHolder(viewGroup);
            } else {
                b2.g();
            }
            c(viewGroup, b2);
            c(viewGroup, d2);
            b2.a(d2);
            d2.f3778d = i2;
        } else if (matrix != null) {
            d2.g(matrix);
        }
        d2.f3778d++;
        return d2;
    }

    static void b(View view, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        matrix.reset();
        ViewUtils.j(viewGroup2, matrix);
        matrix.preTranslate(-viewGroup2.getScrollX(), -viewGroup2.getScrollY());
        ViewUtils.k(viewGroup, matrix);
    }

    static void c(View view, View view2) {
        ViewUtils.g(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    static GhostViewPort d(View view) {
        return (GhostViewPort) view.getTag(R.id.ghost_view);
    }

    static void e(View view) {
        GhostViewPort d2 = d(view);
        if (d2 != null) {
            int i2 = d2.f3778d - 1;
            d2.f3778d = i2;
            if (i2 <= 0) {
                ((GhostViewHolder) d2.getParent()).removeView(d2);
            }
        }
    }

    static void f(@NonNull View view, @Nullable GhostViewPort ghostViewPort) {
        view.setTag(R.id.ghost_view, ghostViewPort);
    }

    void g(@NonNull Matrix matrix) {
        this.f3779e = matrix;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        f(this.f3777c, this);
        this.f3777c.getViewTreeObserver().addOnPreDrawListener(this.f3780f);
        ViewUtils.i(this.f3777c, 4);
        if (this.f3777c.getParent() != null) {
            ((View) this.f3777c.getParent()).invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f3777c.getViewTreeObserver().removeOnPreDrawListener(this.f3780f);
        ViewUtils.i(this.f3777c, 0);
        f(this.f3777c, null);
        if (this.f3777c.getParent() != null) {
            ((View) this.f3777c.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        CanvasUtils.a(canvas, true);
        canvas.setMatrix(this.f3779e);
        ViewUtils.i(this.f3777c, 0);
        this.f3777c.invalidate();
        ViewUtils.i(this.f3777c, 4);
        drawChild(canvas, this.f3777c, getDrawingTime());
        CanvasUtils.a(canvas, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    @Override // androidx.transition.GhostView
    public void reserveEndViewTransition(ViewGroup viewGroup, View view) {
        this.f3775a = viewGroup;
        this.f3776b = view;
    }

    @Override // android.view.View, androidx.transition.GhostView
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (d(this.f3777c) == this) {
            ViewUtils.i(this.f3777c, i2 == 0 ? 4 : 0);
        }
    }
}
