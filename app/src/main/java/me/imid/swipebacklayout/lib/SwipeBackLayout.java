package me.imid.swipebacklayout.lib;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.imid.swipebacklayout.lib.c;

/* loaded from: classes5.dex */
public class SwipeBackLayout extends FrameLayout {

    /* renamed from: a */
    private static final int f35323a = 400;

    /* renamed from: b */
    private static final int f35324b = -1728053248;

    /* renamed from: c */
    private static final int f35325c = 255;

    /* renamed from: d */
    public static final int f35326d = 1;

    /* renamed from: e */
    public static final int f35327e = 2;

    /* renamed from: f */
    public static final int f35328f = 8;

    /* renamed from: g */
    public static final int f35329g = 11;

    /* renamed from: h */
    public static final int f35330h = 0;

    /* renamed from: i */
    public static final int f35331i = 1;

    /* renamed from: j */
    public static final int f35332j = 2;
    private static final float k = 0.3f;
    private static final int l = 10;
    private static final int[] m = {1, 2, 8, 11};
    private float A;
    private int B;
    private boolean C;
    private Rect D;
    private int E;
    private int n;
    private float o;
    private Activity p;
    private boolean q;
    private View r;
    private me.imid.swipebacklayout.lib.c s;
    private float t;
    private int u;
    private int v;
    private List<b> w;
    private Drawable x;
    private Drawable y;
    private Drawable z;

    public interface b {
        void a(int i2, float f2);

        void b();

        void c(int i2);
    }

    private class c extends c.AbstractC0829c {

        /* renamed from: a */
        private boolean f35333a;

        private c() {
        }

        @Override // me.imid.swipebacklayout.lib.c.AbstractC0829c
        public int a(View view, int i2, int i3) {
            if ((SwipeBackLayout.this.E & 1) != 0) {
                return Math.min(view.getWidth(), Math.max(i2, 0));
            }
            if ((SwipeBackLayout.this.E & 2) != 0) {
                return Math.min(0, Math.max(i2, -view.getWidth()));
            }
            return 0;
        }

        @Override // me.imid.swipebacklayout.lib.c.AbstractC0829c
        public int b(View view, int i2, int i3) {
            if ((SwipeBackLayout.this.E & 8) != 0) {
                return Math.min(0, Math.max(i2, -view.getHeight()));
            }
            return 0;
        }

        @Override // me.imid.swipebacklayout.lib.c.AbstractC0829c
        public int d(View view) {
            return SwipeBackLayout.this.n & 3;
        }

        @Override // me.imid.swipebacklayout.lib.c.AbstractC0829c
        public int e(View view) {
            return SwipeBackLayout.this.n & 8;
        }

        @Override // me.imid.swipebacklayout.lib.c.AbstractC0829c
        public void j(int i2) {
            super.j(i2);
            if (SwipeBackLayout.this.w == null || SwipeBackLayout.this.w.isEmpty()) {
                return;
            }
            Iterator it = SwipeBackLayout.this.w.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(i2, SwipeBackLayout.this.t);
            }
        }

        @Override // me.imid.swipebacklayout.lib.c.AbstractC0829c
        public void k(View view, int i2, int i3, int i4, int i5) {
            super.k(view, i2, i3, i4, i5);
            if ((SwipeBackLayout.this.E & 1) != 0) {
                SwipeBackLayout.this.t = Math.abs(i2 / (r3.r.getWidth() + SwipeBackLayout.this.x.getIntrinsicWidth()));
            } else if ((SwipeBackLayout.this.E & 2) != 0) {
                SwipeBackLayout.this.t = Math.abs(i2 / (r3.r.getWidth() + SwipeBackLayout.this.y.getIntrinsicWidth()));
            } else if ((SwipeBackLayout.this.E & 8) != 0) {
                SwipeBackLayout.this.t = Math.abs(i3 / (r3.r.getHeight() + SwipeBackLayout.this.z.getIntrinsicHeight()));
            }
            SwipeBackLayout.this.u = i2;
            SwipeBackLayout.this.v = i3;
            SwipeBackLayout.this.invalidate();
            if (SwipeBackLayout.this.t < SwipeBackLayout.this.o && !this.f35333a) {
                this.f35333a = true;
            }
            if (SwipeBackLayout.this.w != null && !SwipeBackLayout.this.w.isEmpty() && SwipeBackLayout.this.s.E() == 1 && SwipeBackLayout.this.t >= SwipeBackLayout.this.o && this.f35333a) {
                this.f35333a = false;
                Iterator it = SwipeBackLayout.this.w.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).b();
                }
            }
            if (SwipeBackLayout.this.t < 1.0f || SwipeBackLayout.this.p.isFinishing()) {
                return;
            }
            SwipeBackLayout.this.p.finish();
            SwipeBackLayout.this.p.overridePendingTransition(0, 0);
        }

        @Override // me.imid.swipebacklayout.lib.c.AbstractC0829c
        public void l(View view, float f2, float f3) {
            int i2;
            int width = view.getWidth();
            int height = view.getHeight();
            int i3 = 0;
            if ((SwipeBackLayout.this.E & 1) != 0) {
                i3 = (f2 > 0.0f || (f2 == 0.0f && SwipeBackLayout.this.t > SwipeBackLayout.this.o)) ? width + SwipeBackLayout.this.x.getIntrinsicWidth() + 10 : 0;
            } else if ((SwipeBackLayout.this.E & 2) != 0) {
                i3 = (f2 < 0.0f || (f2 == 0.0f && SwipeBackLayout.this.t > SwipeBackLayout.this.o)) ? -(width + SwipeBackLayout.this.x.getIntrinsicWidth() + 10) : 0;
            } else if ((SwipeBackLayout.this.E & 8) != 0 && (f3 < 0.0f || (f3 == 0.0f && SwipeBackLayout.this.t > SwipeBackLayout.this.o))) {
                i2 = -(height + SwipeBackLayout.this.z.getIntrinsicHeight() + 10);
                SwipeBackLayout.this.s.V(i3, i2);
                SwipeBackLayout.this.invalidate();
            }
            i2 = 0;
            SwipeBackLayout.this.s.V(i3, i2);
            SwipeBackLayout.this.invalidate();
        }

        @Override // me.imid.swipebacklayout.lib.c.AbstractC0829c
        public boolean m(View view, int i2) {
            boolean g2;
            boolean H = SwipeBackLayout.this.s.H(SwipeBackLayout.this.n, i2);
            boolean z = true;
            if (H) {
                if (SwipeBackLayout.this.s.H(1, i2)) {
                    SwipeBackLayout.this.E = 1;
                } else if (SwipeBackLayout.this.s.H(2, i2)) {
                    SwipeBackLayout.this.E = 2;
                } else if (SwipeBackLayout.this.s.H(8, i2)) {
                    SwipeBackLayout.this.E = 8;
                }
                if (SwipeBackLayout.this.w != null && !SwipeBackLayout.this.w.isEmpty()) {
                    Iterator it = SwipeBackLayout.this.w.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).c(SwipeBackLayout.this.E);
                    }
                }
                this.f35333a = true;
            }
            if (SwipeBackLayout.this.n == 1 || SwipeBackLayout.this.n == 2) {
                g2 = SwipeBackLayout.this.s.g(2, i2);
            } else {
                if (SwipeBackLayout.this.n != 8) {
                    if (SwipeBackLayout.this.n != 11) {
                        z = false;
                    }
                    return H & z;
                }
                g2 = SwipeBackLayout.this.s.g(1, i2);
            }
            z = true ^ g2;
            return H & z;
        }

        /* synthetic */ c(SwipeBackLayout swipeBackLayout, a aVar) {
            this();
        }
    }

    public SwipeBackLayout(Context context) {
        this(context, null);
    }

    private void r(Canvas canvas, View view) {
        int i2 = (this.B & 16777215) | (((int) ((((-16777216) & r0) >>> 24) * this.A)) << 24);
        int i3 = this.E;
        if ((i3 & 1) != 0) {
            canvas.clipRect(0, 0, view.getLeft(), getHeight());
        } else if ((i3 & 2) != 0) {
            canvas.clipRect(view.getRight(), 0, getRight(), getHeight());
        } else if ((i3 & 8) != 0) {
            canvas.clipRect(view.getLeft(), view.getBottom(), getRight(), getHeight());
        }
        canvas.drawColor(i2);
    }

    private void s(Canvas canvas, View view) {
        Rect rect = this.D;
        view.getHitRect(rect);
        if ((this.n & 1) != 0) {
            Drawable drawable = this.x;
            drawable.setBounds(rect.left - drawable.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
            this.x.setAlpha((int) (this.A * 255.0f));
            this.x.draw(canvas);
        }
        if ((this.n & 2) != 0) {
            Drawable drawable2 = this.y;
            int i2 = rect.right;
            drawable2.setBounds(i2, rect.top, drawable2.getIntrinsicWidth() + i2, rect.bottom);
            this.y.setAlpha((int) (this.A * 255.0f));
            this.y.draw(canvas);
        }
        if ((this.n & 8) != 0) {
            Drawable drawable3 = this.z;
            int i3 = rect.left;
            int i4 = rect.bottom;
            drawable3.setBounds(i3, i4, rect.right, drawable3.getIntrinsicHeight() + i4);
            this.z.setAlpha((int) (this.A * 255.0f));
            this.z.draw(canvas);
        }
    }

    private void setContentView(View view) {
        this.r = view;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.A = 1.0f - this.t;
        if (this.s.o(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        boolean z = view == this.r;
        boolean drawChild = super.drawChild(canvas, view, j2);
        if (this.A > 0.0f && z && this.s.E() != 0) {
            s(canvas, view);
            r(canvas, view);
        }
        return drawChild;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.q) {
            return false;
        }
        try {
            return this.s.W(motionEvent);
        } catch (ArrayIndexOutOfBoundsException unused) {
            return false;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.C = true;
        View view = this.r;
        if (view != null) {
            int i6 = this.u;
            view.layout(i6, this.v, view.getMeasuredWidth() + i6, this.v + this.r.getMeasuredHeight());
        }
        this.C = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.q) {
            return false;
        }
        this.s.K(motionEvent);
        return true;
    }

    public void p(b bVar) {
        if (this.w == null) {
            this.w = new ArrayList();
        }
        this.w.add(bVar);
    }

    public void q(Activity activity) {
        this.p = activity;
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{android.R.attr.windowBackground});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
        viewGroup2.setBackgroundResource(resourceId);
        viewGroup.removeView(viewGroup2);
        addView(viewGroup2);
        setContentView(viewGroup2);
        viewGroup.addView(this);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.C) {
            return;
        }
        super.requestLayout();
    }

    public void setEdgeSize(int i2) {
        this.s.Q(i2);
    }

    public void setEdgeTrackingEnabled(int i2) {
        this.n = i2;
        this.s.R(i2);
    }

    public void setEnableGesture(boolean z) {
        this.q = z;
    }

    public void setScrimColor(int i2) {
        this.B = i2;
        invalidate();
    }

    public void setScrollThresHold(float f2) {
        if (f2 >= 1.0f || f2 <= 0.0f) {
            throw new IllegalArgumentException("Threshold value should be between 0 and 1.0");
        }
        this.o = f2;
    }

    @Deprecated
    public void setSwipeListener(b bVar) {
        p(bVar);
    }

    public void t(b bVar) {
        List<b> list = this.w;
        if (list == null) {
            return;
        }
        list.remove(bVar);
    }

    public void u() {
        int intrinsicHeight;
        int intrinsicWidth;
        int width = this.r.getWidth();
        int height = this.r.getHeight();
        int i2 = this.n;
        int i3 = 0;
        if ((i2 & 1) != 0) {
            intrinsicWidth = width + this.x.getIntrinsicWidth() + 10;
            this.E = 1;
        } else {
            if ((i2 & 2) == 0) {
                if ((i2 & 8) != 0) {
                    intrinsicHeight = ((-height) - this.z.getIntrinsicHeight()) - 10;
                    this.E = 8;
                    this.s.X(this.r, i3, intrinsicHeight);
                    invalidate();
                }
                intrinsicHeight = 0;
                this.s.X(this.r, i3, intrinsicHeight);
                invalidate();
            }
            intrinsicWidth = ((-width) - this.y.getIntrinsicWidth()) - 10;
            this.E = 2;
        }
        i3 = intrinsicWidth;
        intrinsicHeight = 0;
        this.s.X(this.r, i3, intrinsicHeight);
        invalidate();
    }

    public void v(Context context, float f2) {
        this.s.U(context, f2);
    }

    public void w(int i2, int i3) {
        x(getResources().getDrawable(i2), i3);
    }

    public void x(Drawable drawable, int i2) {
        if ((i2 & 1) != 0) {
            this.x = drawable;
        } else if ((i2 & 2) != 0) {
            this.y = drawable;
        } else if ((i2 & 8) != 0) {
            this.z = drawable;
        }
        invalidate();
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.SwipeBackLayoutStyle);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.o = k;
        this.q = true;
        this.B = f35324b;
        this.D = new Rect();
        this.s = me.imid.swipebacklayout.lib.c.q(this, new c());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwipeBackLayout, i2, R.style.SwipeBackLayout);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwipeBackLayout_edge_size, -1);
        if (dimensionPixelSize > 0) {
            setEdgeSize(dimensionPixelSize);
        }
        setEdgeTrackingEnabled(m[obtainStyledAttributes.getInt(R.styleable.SwipeBackLayout_edge_flag, 0)]);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SwipeBackLayout_shadow_left, R.drawable.shadow_left);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.SwipeBackLayout_shadow_right, R.drawable.shadow_right);
        int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.SwipeBackLayout_shadow_bottom, R.drawable.shadow_bottom);
        w(resourceId, 1);
        w(resourceId2, 2);
        w(resourceId3, 8);
        obtainStyledAttributes.recycle();
        float f2 = getResources().getDisplayMetrics().density * 400.0f;
        this.s.T(f2);
        this.s.S(f2 * 2.0f);
    }
}
