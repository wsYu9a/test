package com.martian.libsliding;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import com.martian.libsliding.f;
import com.martian.libsliding.slider.AutoSlider;
import com.martian.libsliding.slider.g;

/* loaded from: classes3.dex */
public class SlidingLayout extends ViewGroup {

    /* renamed from: a */
    private f f10499a;

    /* renamed from: b */
    private f.a f10500b;

    /* renamed from: c */
    private g f10501c;

    /* renamed from: d */
    private AutoSlider f10502d;

    /* renamed from: e */
    private boolean f10503e;

    /* renamed from: f */
    private e f10504f;

    /* renamed from: g */
    private boolean f10505g;

    /* renamed from: h */
    private float f10506h;

    /* renamed from: i */
    private float f10507i;

    /* renamed from: j */
    private a f10508j;
    Canvas k;
    Bitmap l;
    Bitmap m;
    boolean n;
    boolean o;
    boolean p;
    private boolean q;

    public interface a {
        void a(Object obj);

        void b(int touchResult);
    }

    public static class b extends View.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = ParcelableCompat.newCreator(new a());

        /* renamed from: a */
        Parcelable f10509a;

        /* renamed from: b */
        ClassLoader f10510b;

        static class a implements ParcelableCompatCreatorCallbacks<b> {
            a() {
            }

            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            /* renamed from: a */
            public b createFromParcel(Parcel in, ClassLoader loader) {
                return new b(in, loader);
            }

            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            /* renamed from: b */
            public b[] newArray(int size) {
                return new b[size];
            }
        }

        public b(Parcelable superState) {
            super(superState);
        }

        public String toString() {
            return "BaseSlidingLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeParcelable(this.f10509a, flags);
        }

        b(Parcel in, ClassLoader loader) {
            super(in);
            loader = loader == null ? getClass().getClassLoader() : loader;
            this.f10509a = in.readParcelable(loader);
            this.f10510b = loader;
        }
    }

    public SlidingLayout(Context context) {
        super(context);
        this.f10503e = false;
        this.f10505g = true;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        h(context);
    }

    private boolean F(float y) {
        return !n() && y > this.f10506h && y < this.f10507i;
    }

    private void h(Context context) {
        setClickable(true);
        this.f10499a = new f(context, new f.a() { // from class: com.martian.libsliding.b
            @Override // com.martian.libsliding.f.a
            public final void r(Point point) {
                SlidingLayout.this.p(point);
            }
        });
    }

    /* renamed from: o */
    public /* synthetic */ void p(Point point) {
        f.a aVar = this.f10500b;
        if (aVar != null) {
            aVar.r(point);
        }
    }

    private void u() {
        if (this.f10503e) {
            this.f10502d.d();
            return;
        }
        g gVar = this.f10501c;
        if (gVar != null) {
            gVar.d();
        }
    }

    public void A(boolean fromTouch) {
        if (this.f10501c == null || l()) {
            return;
        }
        this.f10501c.c(fromTouch);
    }

    public void B(int moveDirection) {
        a aVar = this.f10508j;
        if (aVar != null) {
            aVar.b(moveDirection);
        }
    }

    public void C(Object obj) {
        a aVar = this.f10508j;
        if (aVar != null) {
            aVar.a(obj);
        }
    }

    public boolean D() {
        if (this.f10502d == null) {
            i(false);
        }
        this.f10503e = true;
        return this.f10502d.I();
    }

    public boolean E() {
        this.f10503e = false;
        AutoSlider autoSlider = this.f10502d;
        if (autoSlider == null) {
            return false;
        }
        autoSlider.J();
        this.f10502d.q();
        this.f10502d = null;
        g gVar = this.f10501c;
        if (gVar != null) {
            gVar.e(this);
        }
        s();
        return true;
    }

    public void a(View view, boolean forceRedraw) {
        if (view.getWidth() == 0 || view.getHeight() == 0) {
            return;
        }
        Bitmap bitmap = this.l;
        if (bitmap == null || bitmap.getWidth() != view.getWidth() || this.l.getHeight() != view.getHeight()) {
            Bitmap bitmap2 = this.l;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.l = null;
            }
            try {
                this.l = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError unused) {
                System.gc();
                this.l = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            }
            this.n = false;
        }
        if (!this.n || forceRedraw) {
            Canvas canvas = this.k;
            if (canvas == null) {
                this.k = new Canvas(this.l);
            } else {
                canvas.setBitmap(this.l);
            }
            view.draw(this.k);
            this.n = true;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child) {
        ViewParent parent = child.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(child);
        }
        super.addView(child);
    }

    public void b(View view, boolean forceRedraw) {
        if (view.getWidth() == 0 || view.getHeight() == 0) {
            return;
        }
        Bitmap bitmap = this.m;
        if (bitmap == null || bitmap.getWidth() != view.getWidth() || this.m.getHeight() != view.getHeight()) {
            Bitmap bitmap2 = this.m;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.m = null;
            }
            try {
                this.m = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError unused) {
                System.gc();
                this.m = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            }
            this.p = false;
        }
        if (!this.p || forceRedraw) {
            Canvas canvas = this.k;
            if (canvas == null) {
                this.k = new Canvas(this.m);
            } else {
                canvas.setBitmap(this.m);
            }
            view.draw(this.k);
            this.p = true;
        }
    }

    public void c(View view, boolean forceRedraw) {
        if (view.getWidth() == 0 || view.getHeight() == 0) {
            return;
        }
        Bitmap bitmap = this.m;
        if (bitmap == null || bitmap.getWidth() != view.getWidth() || this.m.getHeight() != view.getHeight()) {
            Bitmap bitmap2 = this.m;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.m = null;
            }
            try {
                this.m = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError unused) {
                System.gc();
                this.m = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            }
            this.o = false;
        }
        if (!this.o || forceRedraw) {
            Canvas canvas = this.k;
            if (canvas == null) {
                this.k = new Canvas(this.m);
            } else {
                canvas.setBitmap(this.m);
            }
            view.draw(this.k);
            this.o = true;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (l()) {
            this.f10502d.g();
            return;
        }
        g gVar = this.f10501c;
        if (gVar != null) {
            gVar.g();
        }
    }

    public void d(int direction) {
        e(false, direction);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (l()) {
            this.f10502d.a(canvas);
            return;
        }
        g gVar = this.f10501c;
        if (gVar == null || !gVar.a(canvas)) {
            super.dispatchDraw(canvas);
        }
    }

    public void e(boolean forceRedraw, int direction) {
        View d2 = getAdapter().d();
        if (!this.n && d2 != null) {
            a(d2, forceRedraw);
        }
        if (direction == 1) {
            View h2 = getAdapter().h();
            if (!this.o && h2 != null) {
                c(h2, forceRedraw);
            }
            this.p = false;
            return;
        }
        View f2 = getAdapter().f();
        if (!this.p && f2 != null) {
            b(f2, forceRedraw);
        }
        this.o = false;
    }

    public void f() {
        Bitmap bitmap = this.l;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.l.recycle();
            this.l = null;
        }
        Bitmap bitmap2 = this.m;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.m.recycle();
            this.m = null;
        }
        this.k = null;
    }

    public void g(Canvas canvas, View child) {
        drawChild(canvas, child, getDrawingTime());
    }

    public e getAdapter() {
        return this.f10504f;
    }

    public Bitmap getCurrentViewBitmap() {
        return this.l;
    }

    public f.a getOnTapListener() {
        return this.f10500b;
    }

    public Bitmap getReuseBitmap() {
        return this.m;
    }

    public g getSlider() {
        return this.f10501c;
    }

    public void i(boolean enableCache) {
        this.f10502d = new com.martian.libsliding.slider.c();
        setCacheEnabled(enableCache);
        this.f10502d.e(this);
        t(this.f10502d);
    }

    public void j() {
        this.o = false;
        this.n = false;
        this.p = false;
        invalidate();
    }

    public boolean k() {
        return this.f10503e && !this.f10502d.y();
    }

    public boolean l() {
        return this.f10503e;
    }

    public boolean m() {
        return this.q;
    }

    public boolean n() {
        return this.f10505g;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        g gVar;
        return l() ? this.f10502d.h(event) : (F(event.getY()) || (gVar = this.f10501c) == null || !gVar.h(event)) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b2) {
        if (l()) {
            AutoSlider autoSlider = this.f10502d;
            if (autoSlider != null && autoSlider.b(changed, l, t, r, b2)) {
                return;
            }
        } else {
            g gVar = this.f10501c;
            if (gVar != null && gVar.b(changed, l, t, r, b2)) {
                return;
            }
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof b)) {
            super.onRestoreInstanceState(state);
            return;
        }
        super.onRestoreInstanceState(((b) state).getSuperState());
        e eVar = this.f10504f;
        if (eVar != null) {
            eVar.w();
            s();
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        e eVar = this.f10504f;
        if (eVar != null) {
            bVar.f10509a = eVar.x();
        }
        return bVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (l()) {
            if (this.f10502d.onTouchEvent(event)) {
                return true;
            }
        } else if (this.f10501c != null) {
            if (F(event.getY())) {
                return false;
            }
            if (this.f10501c.onTouchEvent(event)) {
                return true;
            }
        }
        this.f10499a.a(event);
        return true;
    }

    public void q() {
        e eVar = this.f10504f;
        if (eVar != null) {
            eVar.v();
        }
    }

    public void r() {
        AutoSlider autoSlider = this.f10502d;
        if (autoSlider == null) {
            return;
        }
        autoSlider.E();
    }

    public void s() {
        removeAllViews();
        if (this.f10504f != null) {
            u();
            C(getAdapter().c());
        }
    }

    public void setAdapter(e adapter) {
        this.f10504f = adapter;
        adapter.B(this);
        this.f10504f.w();
        s();
        postInvalidate();
    }

    public void setCacheEnabled(boolean enable) {
        this.q = enable;
    }

    public void setOnSlideChangeListener(a l) {
        this.f10508j = l;
    }

    public void setOnTapListener(f.a mOnTapListener) {
        this.f10500b = mOnTapListener;
    }

    public void setSlider(g slider) {
        this.f10501c = slider;
        slider.e(this);
        t(this.f10501c);
    }

    public void setTouchable(boolean touchable) {
        this.f10505g = touchable;
    }

    public void t(g slider) {
        removeAllViews();
        if (this.f10504f != null) {
            slider.d();
            C(getAdapter().c());
        }
    }

    public void v() {
        this.f10503e = true;
        if (this.f10502d.F()) {
            return;
        }
        this.f10502d.I();
    }

    public void w(float tY, float bY) {
        this.f10506h = tY;
        this.f10507i = bY;
    }

    public void x(int dpSpeed, boolean resume) {
        AutoSlider autoSlider = this.f10502d;
        if (autoSlider != null) {
            autoSlider.H(dpSpeed, resume);
        }
    }

    public void y(AutoSlider autoSlider, boolean enableCache) {
        setCacheEnabled(enableCache);
        this.f10502d = autoSlider;
        autoSlider.e(this);
        t(this.f10502d);
    }

    public void z(boolean fromTouch) {
        if (this.f10501c == null || l()) {
            return;
        }
        this.f10501c.f(fromTouch);
    }

    public SlidingLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f10503e = false;
        this.f10505g = true;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        h(context);
    }

    public SlidingLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f10503e = false;
        this.f10505g = true;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        h(context);
    }
}
