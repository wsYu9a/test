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
import me.imid.swipebacklayout.lib.a;

/* loaded from: classes4.dex */
public class SwipeBackLayout extends FrameLayout {
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;
    public static final float D = 0.3f;
    public static final int E = 10;
    public static final int[] F = {1, 2, 8, 11};

    /* renamed from: t */
    public static final int f28635t = 400;

    /* renamed from: u */
    public static final int f28636u = -1728053248;

    /* renamed from: v */
    public static final int f28637v = 255;

    /* renamed from: w */
    public static final int f28638w = 1;

    /* renamed from: x */
    public static final int f28639x = 2;

    /* renamed from: y */
    public static final int f28640y = 8;

    /* renamed from: z */
    public static final int f28641z = 11;

    /* renamed from: b */
    public int f28642b;

    /* renamed from: c */
    public float f28643c;

    /* renamed from: d */
    public Activity f28644d;

    /* renamed from: e */
    public boolean f28645e;

    /* renamed from: f */
    public View f28646f;

    /* renamed from: g */
    public me.imid.swipebacklayout.lib.a f28647g;

    /* renamed from: h */
    public float f28648h;

    /* renamed from: i */
    public int f28649i;

    /* renamed from: j */
    public int f28650j;

    /* renamed from: k */
    public List<b> f28651k;

    /* renamed from: l */
    public Drawable f28652l;

    /* renamed from: m */
    public Drawable f28653m;

    /* renamed from: n */
    public Drawable f28654n;

    /* renamed from: o */
    public float f28655o;

    /* renamed from: p */
    public int f28656p;

    /* renamed from: q */
    public boolean f28657q;

    /* renamed from: r */
    public Rect f28658r;

    /* renamed from: s */
    public int f28659s;

    public interface b {
        void a(int i10, float f10);

        void c();

        void d(int i10);
    }

    public interface c extends b {
        void b();
    }

    public class d extends a.c {

        /* renamed from: a */
        public boolean f28660a;

        public d() {
        }

        @Override // me.imid.swipebacklayout.lib.a.c
        public int a(View view, int i10, int i11) {
            if ((SwipeBackLayout.this.f28659s & 1) != 0) {
                return Math.min(view.getWidth(), Math.max(i10, 0));
            }
            if ((SwipeBackLayout.this.f28659s & 2) != 0) {
                return Math.min(0, Math.max(i10, -view.getWidth()));
            }
            return 0;
        }

        @Override // me.imid.swipebacklayout.lib.a.c
        public int b(View view, int i10, int i11) {
            if ((SwipeBackLayout.this.f28659s & 8) != 0) {
                return Math.min(0, Math.max(i10, -view.getHeight()));
            }
            return 0;
        }

        @Override // me.imid.swipebacklayout.lib.a.c
        public int d(View view) {
            return SwipeBackLayout.this.f28642b & 3;
        }

        @Override // me.imid.swipebacklayout.lib.a.c
        public int e(View view) {
            return SwipeBackLayout.this.f28642b & 8;
        }

        @Override // me.imid.swipebacklayout.lib.a.c
        public void j(int i10) {
            super.j(i10);
            if (SwipeBackLayout.this.f28651k == null || SwipeBackLayout.this.f28651k.isEmpty()) {
                return;
            }
            Iterator it = SwipeBackLayout.this.f28651k.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(i10, SwipeBackLayout.this.f28648h);
            }
        }

        @Override // me.imid.swipebacklayout.lib.a.c
        public void k(View view, int i10, int i11, int i12, int i13) {
            super.k(view, i10, i11, i12, i13);
            if ((SwipeBackLayout.this.f28659s & 1) != 0) {
                SwipeBackLayout.this.f28648h = Math.abs(i10 / (r3.f28646f.getWidth() + SwipeBackLayout.this.f28652l.getIntrinsicWidth()));
            } else if ((SwipeBackLayout.this.f28659s & 2) != 0) {
                SwipeBackLayout.this.f28648h = Math.abs(i10 / (r3.f28646f.getWidth() + SwipeBackLayout.this.f28653m.getIntrinsicWidth()));
            } else if ((SwipeBackLayout.this.f28659s & 8) != 0) {
                SwipeBackLayout.this.f28648h = Math.abs(i11 / (r3.f28646f.getHeight() + SwipeBackLayout.this.f28654n.getIntrinsicHeight()));
            }
            SwipeBackLayout.this.f28649i = i10;
            SwipeBackLayout.this.f28650j = i11;
            SwipeBackLayout.this.invalidate();
            if (SwipeBackLayout.this.f28648h < SwipeBackLayout.this.f28643c && !this.f28660a) {
                this.f28660a = true;
            }
            if (SwipeBackLayout.this.f28651k != null && !SwipeBackLayout.this.f28651k.isEmpty()) {
                Iterator it = SwipeBackLayout.this.f28651k.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).a(SwipeBackLayout.this.f28647g.E(), SwipeBackLayout.this.f28648h);
                }
            }
            if (SwipeBackLayout.this.f28651k != null && !SwipeBackLayout.this.f28651k.isEmpty() && SwipeBackLayout.this.f28647g.E() == 1 && SwipeBackLayout.this.f28648h >= SwipeBackLayout.this.f28643c && this.f28660a) {
                this.f28660a = false;
                Iterator it2 = SwipeBackLayout.this.f28651k.iterator();
                while (it2.hasNext()) {
                    ((b) it2.next()).c();
                }
            }
            if (SwipeBackLayout.this.f28648h < 1.0f || SwipeBackLayout.this.f28651k == null || SwipeBackLayout.this.f28651k.isEmpty()) {
                return;
            }
            for (b bVar : SwipeBackLayout.this.f28651k) {
                if (bVar instanceof c) {
                    ((c) bVar).b();
                }
            }
        }

        @Override // me.imid.swipebacklayout.lib.a.c
        public void l(View view, float f10, float f11) {
            int i10;
            int width = view.getWidth();
            int height = view.getHeight();
            int i11 = 0;
            if ((SwipeBackLayout.this.f28659s & 1) != 0) {
                i11 = (f10 > 0.0f || (f10 == 0.0f && SwipeBackLayout.this.f28648h > SwipeBackLayout.this.f28643c)) ? width + SwipeBackLayout.this.f28652l.getIntrinsicWidth() + 10 : 0;
            } else if ((SwipeBackLayout.this.f28659s & 2) != 0) {
                i11 = (f10 < 0.0f || (f10 == 0.0f && SwipeBackLayout.this.f28648h > SwipeBackLayout.this.f28643c)) ? -(width + SwipeBackLayout.this.f28652l.getIntrinsicWidth() + 10) : 0;
            } else if ((SwipeBackLayout.this.f28659s & 8) != 0 && (f11 < 0.0f || (f11 == 0.0f && SwipeBackLayout.this.f28648h > SwipeBackLayout.this.f28643c))) {
                i10 = -(height + SwipeBackLayout.this.f28654n.getIntrinsicHeight() + 10);
                SwipeBackLayout.this.f28647g.V(i11, i10);
                SwipeBackLayout.this.invalidate();
            }
            i10 = 0;
            SwipeBackLayout.this.f28647g.V(i11, i10);
            SwipeBackLayout.this.invalidate();
        }

        @Override // me.imid.swipebacklayout.lib.a.c
        public boolean m(View view, int i10) {
            boolean g10;
            boolean H = SwipeBackLayout.this.f28647g.H(SwipeBackLayout.this.f28642b, i10);
            boolean z10 = true;
            if (H) {
                if (SwipeBackLayout.this.f28647g.H(1, i10)) {
                    SwipeBackLayout.this.f28659s = 1;
                } else if (SwipeBackLayout.this.f28647g.H(2, i10)) {
                    SwipeBackLayout.this.f28659s = 2;
                } else if (SwipeBackLayout.this.f28647g.H(8, i10)) {
                    SwipeBackLayout.this.f28659s = 8;
                }
                if (SwipeBackLayout.this.f28651k != null && !SwipeBackLayout.this.f28651k.isEmpty()) {
                    Iterator it = SwipeBackLayout.this.f28651k.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).d(SwipeBackLayout.this.f28659s);
                    }
                }
                this.f28660a = true;
            }
            if (SwipeBackLayout.this.f28642b == 1 || SwipeBackLayout.this.f28642b == 2) {
                g10 = SwipeBackLayout.this.f28647g.g(2, i10);
            } else {
                if (SwipeBackLayout.this.f28642b != 8) {
                    if (SwipeBackLayout.this.f28642b != 11) {
                        z10 = false;
                    }
                    return H & z10;
                }
                g10 = SwipeBackLayout.this.f28647g.g(1, i10);
            }
            z10 = true ^ g10;
            return H & z10;
        }

        public /* synthetic */ d(SwipeBackLayout swipeBackLayout, a aVar) {
            this();
        }
    }

    public SwipeBackLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f28655o = 1.0f - this.f28648h;
        if (this.f28647g.o(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        boolean z10 = view == this.f28646f;
        boolean drawChild = super.drawChild(canvas, view, j10);
        if (this.f28655o > 0.0f && z10 && this.f28647g.E() != 0) {
            r(canvas, view);
            q(canvas, view);
        }
        return drawChild;
    }

    public void o(b bVar) {
        if (this.f28651k == null) {
            this.f28651k = new ArrayList();
        }
        this.f28651k.add(bVar);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f28645e) {
            return false;
        }
        try {
            return this.f28647g.W(motionEvent);
        } catch (ArrayIndexOutOfBoundsException unused) {
            return false;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        this.f28657q = true;
        View view = this.f28646f;
        if (view != null) {
            int i14 = this.f28649i;
            view.layout(i14, this.f28650j, view.getMeasuredWidth() + i14, this.f28650j + this.f28646f.getMeasuredHeight());
        }
        this.f28657q = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f28645e) {
            return false;
        }
        this.f28647g.K(motionEvent);
        return true;
    }

    public void p(Activity activity) {
        this.f28644d = activity;
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{android.R.attr.windowBackground});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
        viewGroup2.setBackgroundResource(resourceId);
        viewGroup.removeView(viewGroup2);
        addView(viewGroup2);
        setContentView(viewGroup2);
        o(new mi.c(activity));
        viewGroup.addView(this);
    }

    public final void q(Canvas canvas, View view) {
        int i10 = (this.f28656p & 16777215) | (((int) ((((-16777216) & r0) >>> 24) * this.f28655o)) << 24);
        int i11 = this.f28659s;
        if ((i11 & 1) != 0) {
            canvas.clipRect(0, 0, view.getLeft(), getHeight());
        } else if ((i11 & 2) != 0) {
            canvas.clipRect(view.getRight(), 0, getRight(), getHeight());
        } else if ((i11 & 8) != 0) {
            canvas.clipRect(view.getLeft(), view.getBottom(), getRight(), getHeight());
        }
        canvas.drawColor(i10);
    }

    public final void r(Canvas canvas, View view) {
        Rect rect = this.f28658r;
        view.getHitRect(rect);
        if ((this.f28642b & 1) != 0) {
            Drawable drawable = this.f28652l;
            drawable.setBounds(rect.left - drawable.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
            this.f28652l.setAlpha((int) (this.f28655o * 255.0f));
            this.f28652l.draw(canvas);
        }
        if ((this.f28642b & 2) != 0) {
            Drawable drawable2 = this.f28653m;
            int i10 = rect.right;
            drawable2.setBounds(i10, rect.top, drawable2.getIntrinsicWidth() + i10, rect.bottom);
            this.f28653m.setAlpha((int) (this.f28655o * 255.0f));
            this.f28653m.draw(canvas);
        }
        if ((this.f28642b & 8) != 0) {
            Drawable drawable3 = this.f28654n;
            int i11 = rect.left;
            int i12 = rect.bottom;
            drawable3.setBounds(i11, i12, rect.right, drawable3.getIntrinsicHeight() + i12);
            this.f28654n.setAlpha((int) (this.f28655o * 255.0f));
            this.f28654n.draw(canvas);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f28657q) {
            return;
        }
        super.requestLayout();
    }

    public void s(b bVar) {
        List<b> list = this.f28651k;
        if (list == null) {
            return;
        }
        list.remove(bVar);
    }

    public void setContentView(View view) {
        this.f28646f = view;
    }

    public void setEdgeSize(int i10) {
        this.f28647g.Q(i10);
    }

    public void setEdgeTrackingEnabled(int i10) {
        this.f28642b = i10;
        this.f28647g.R(i10);
    }

    public void setEnableGesture(boolean z10) {
        this.f28645e = z10;
    }

    public void setScrimColor(int i10) {
        this.f28656p = i10;
        invalidate();
    }

    public void setScrollThresHold(float f10) {
        if (f10 >= 1.0f || f10 <= 0.0f) {
            throw new IllegalArgumentException("Threshold value should be between 0 and 1.0");
        }
        this.f28643c = f10;
    }

    @Deprecated
    public void setSwipeListener(b bVar) {
        o(bVar);
    }

    public void t() {
        int intrinsicHeight;
        int intrinsicWidth;
        int width = this.f28646f.getWidth();
        int height = this.f28646f.getHeight();
        int i10 = this.f28642b;
        int i11 = 0;
        if ((i10 & 1) != 0) {
            intrinsicWidth = width + this.f28652l.getIntrinsicWidth() + 10;
            this.f28659s = 1;
        } else {
            if ((i10 & 2) == 0) {
                if ((i10 & 8) != 0) {
                    intrinsicHeight = ((-height) - this.f28654n.getIntrinsicHeight()) - 10;
                    this.f28659s = 8;
                    this.f28647g.X(this.f28646f, i11, intrinsicHeight);
                    invalidate();
                }
                intrinsicHeight = 0;
                this.f28647g.X(this.f28646f, i11, intrinsicHeight);
                invalidate();
            }
            intrinsicWidth = ((-width) - this.f28653m.getIntrinsicWidth()) - 10;
            this.f28659s = 2;
        }
        i11 = intrinsicWidth;
        intrinsicHeight = 0;
        this.f28647g.X(this.f28646f, i11, intrinsicHeight);
        invalidate();
    }

    public void u(Context context, float f10) {
        this.f28647g.U(context, f10);
    }

    public void v(int i10, int i11) {
        w(getResources().getDrawable(i10), i11);
    }

    public void w(Drawable drawable, int i10) {
        if ((i10 & 1) != 0) {
            this.f28652l = drawable;
        } else if ((i10 & 2) != 0) {
            this.f28653m = drawable;
        } else if ((i10 & 8) != 0) {
            this.f28654n = drawable;
        }
        invalidate();
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.SwipeBackLayoutStyle);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        this.f28643c = 0.3f;
        this.f28645e = true;
        this.f28656p = f28636u;
        this.f28658r = new Rect();
        this.f28647g = me.imid.swipebacklayout.lib.a.q(this, new d());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwipeBackLayout, i10, R.style.SwipeBackLayout);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwipeBackLayout_edge_size, -1);
        if (dimensionPixelSize > 0) {
            setEdgeSize(dimensionPixelSize);
        }
        setEdgeTrackingEnabled(F[obtainStyledAttributes.getInt(R.styleable.SwipeBackLayout_edge_flag, 0)]);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SwipeBackLayout_shadow_left, R.drawable.shadow_left);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.SwipeBackLayout_shadow_right, R.drawable.shadow_right);
        int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.SwipeBackLayout_shadow_bottom, R.drawable.shadow_bottom);
        v(resourceId, 1);
        v(resourceId2, 2);
        v(resourceId3, 8);
        obtainStyledAttributes.recycle();
        float f10 = getResources().getDisplayMetrics().density * 400.0f;
        this.f28647g.T(f10);
        this.f28647g.S(f10 * 2.0f);
    }
}
