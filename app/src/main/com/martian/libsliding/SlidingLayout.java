package com.martian.libsliding;

import aa.f;
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
import com.martian.libsliding.SlidingLayout;
import com.martian.libsliding.a;
import com.martian.libsliding.slider.AutoSlider;
import z9.d;

/* loaded from: classes3.dex */
public class SlidingLayout extends ViewGroup {

    /* renamed from: b */
    public com.martian.libsliding.a f12915b;

    /* renamed from: c */
    public a.InterfaceC0522a f12916c;

    /* renamed from: d */
    public f f12917d;

    /* renamed from: e */
    public AutoSlider f12918e;

    /* renamed from: f */
    public boolean f12919f;

    /* renamed from: g */
    public d<?> f12920g;

    /* renamed from: h */
    public TouchBlockType f12921h;

    /* renamed from: i */
    public float f12922i;

    /* renamed from: j */
    public float f12923j;

    /* renamed from: k */
    public a f12924k;

    /* renamed from: l */
    public Canvas f12925l;

    /* renamed from: m */
    public Bitmap f12926m;

    /* renamed from: n */
    public Bitmap f12927n;

    /* renamed from: o */
    public boolean f12928o;

    /* renamed from: p */
    public boolean f12929p;

    /* renamed from: q */
    public boolean f12930q;

    /* renamed from: r */
    public boolean f12931r;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: b */
        public Parcelable f12932b;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "BaseSlidingLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + p3.f.f29748d;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeParcelable(this.f12932b, i10);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f12932b = parcel.readParcelable(getClass().getClassLoader());
        }
    }

    public enum TouchBlockType {
        DEFAULT,
        AD,
        FORCE
    }

    public interface a {
        void a(Object obj);

        void b(int i10);
    }

    public SlidingLayout(Context context) {
        super(context);
        this.f12919f = false;
        this.f12921h = TouchBlockType.DEFAULT;
        this.f12928o = false;
        this.f12929p = false;
        this.f12930q = false;
        this.f12931r = false;
        i(context);
    }

    public void A(float f10, float f11) {
        if (p()) {
            this.f12922i = f10;
            this.f12923j = f11;
            setBlockType(TouchBlockType.AD);
        }
    }

    public void B(int i10, boolean z10) {
        AutoSlider autoSlider = this.f12918e;
        if (autoSlider != null) {
            autoSlider.I(i10, z10);
        }
    }

    public void C(AutoSlider autoSlider, boolean z10) {
        setCacheEnabled(z10);
        this.f12918e = autoSlider;
        autoSlider.g(this);
        x(this.f12918e);
    }

    public void D(boolean z10) {
        if (this.f12917d == null || n()) {
            return;
        }
        this.f12917d.h(z10);
    }

    public void E(boolean z10) {
        if (this.f12917d == null || n()) {
            return;
        }
        this.f12917d.d(z10);
    }

    public void F(int i10) {
        a aVar = this.f12924k;
        if (aVar != null) {
            aVar.b(i10);
        }
    }

    public void G(Object obj) {
        a aVar = this.f12924k;
        if (aVar != null) {
            aVar.a(obj);
        }
    }

    public boolean H() {
        if (this.f12918e == null) {
            j(false);
        }
        this.f12919f = true;
        return this.f12918e.J();
    }

    public boolean I() {
        this.f12919f = false;
        AutoSlider autoSlider = this.f12918e;
        if (autoSlider == null) {
            return false;
        }
        autoSlider.K();
        this.f12918e.r();
        this.f12918e = null;
        f fVar = this.f12917d;
        if (fVar != null) {
            fVar.g(this);
        }
        w();
        return true;
    }

    public final boolean J(float f10) {
        return l() && f10 > this.f12922i && f10 < this.f12923j;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(view);
        }
        super.addView(view);
    }

    public void b(View view, boolean z10) {
        if (view.getWidth() == 0 || view.getHeight() == 0) {
            return;
        }
        Bitmap bitmap = this.f12926m;
        if (bitmap == null || bitmap.getWidth() != view.getWidth() || this.f12926m.getHeight() != view.getHeight()) {
            Bitmap bitmap2 = this.f12926m;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.f12926m = null;
            }
            try {
                this.f12926m = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError unused) {
                System.gc();
                this.f12926m = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            }
            this.f12928o = false;
        }
        if (!this.f12928o || z10) {
            Canvas canvas = this.f12925l;
            if (canvas == null) {
                this.f12925l = new Canvas(this.f12926m);
            } else {
                canvas.setBitmap(this.f12926m);
            }
            view.draw(this.f12925l);
            this.f12928o = true;
        }
    }

    public void c(View view, boolean z10) {
        if (view.getWidth() == 0 || view.getHeight() == 0) {
            return;
        }
        Bitmap bitmap = this.f12927n;
        if (bitmap == null || bitmap.getWidth() != view.getWidth() || this.f12927n.getHeight() != view.getHeight()) {
            Bitmap bitmap2 = this.f12927n;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.f12927n = null;
            }
            try {
                this.f12927n = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError unused) {
                System.gc();
                this.f12927n = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            }
            this.f12930q = false;
        }
        if (!this.f12930q || z10) {
            Canvas canvas = this.f12925l;
            if (canvas == null) {
                this.f12925l = new Canvas(this.f12927n);
            } else {
                canvas.setBitmap(this.f12927n);
            }
            view.draw(this.f12925l);
            this.f12930q = true;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (n()) {
            this.f12918e.i();
            return;
        }
        f fVar = this.f12917d;
        if (fVar != null) {
            fVar.i();
        }
    }

    public void d(View view, boolean z10) {
        if (view.getWidth() == 0 || view.getHeight() == 0) {
            return;
        }
        Bitmap bitmap = this.f12927n;
        if (bitmap == null || bitmap.getWidth() != view.getWidth() || this.f12927n.getHeight() != view.getHeight()) {
            Bitmap bitmap2 = this.f12927n;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.f12927n = null;
            }
            try {
                this.f12927n = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError unused) {
                System.gc();
                this.f12927n = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            }
            this.f12929p = false;
        }
        if (!this.f12929p || z10) {
            Canvas canvas = this.f12925l;
            if (canvas == null) {
                this.f12925l = new Canvas(this.f12927n);
            } else {
                canvas.setBitmap(this.f12927n);
            }
            view.draw(this.f12925l);
            this.f12929p = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (n()) {
            this.f12918e.b(canvas);
            return;
        }
        f fVar = this.f12917d;
        if (fVar == null || !fVar.b(canvas)) {
            super.dispatchDraw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (!dispatchTouchEvent || motionEvent.getAction() == 0) {
            this.f12915b.a(motionEvent);
        }
        return dispatchTouchEvent;
    }

    public void e(int i10) {
        f(false, i10);
    }

    public void f(boolean z10, int i10) {
        View e10 = getAdapter().e();
        if (!this.f12928o && e10 != null) {
            b(e10, z10);
        }
        if (i10 == 1 && getAdapter().q()) {
            View i11 = getAdapter().i();
            if (!this.f12929p && i11 != null) {
                d(i11, z10);
            }
            this.f12930q = false;
            return;
        }
        if (getAdapter().p()) {
            View g10 = getAdapter().g();
            if (!this.f12930q && g10 != null) {
                c(g10, z10);
            }
            this.f12929p = false;
        }
    }

    public void g() {
        Bitmap bitmap = this.f12926m;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f12926m.recycle();
            this.f12926m = null;
        }
        Bitmap bitmap2 = this.f12927n;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.f12927n.recycle();
            this.f12927n = null;
        }
        this.f12925l = null;
    }

    public d<?> getAdapter() {
        return this.f12920g;
    }

    public Bitmap getCurrentViewBitmap() {
        return this.f12926m;
    }

    public Bitmap getReuseBitmap() {
        return this.f12927n;
    }

    public f getSlider() {
        return this.f12917d;
    }

    public void h(Canvas canvas, View view) {
        drawChild(canvas, view, getDrawingTime());
    }

    public final void i(Context context) {
        setClickable(true);
        this.f12915b = new com.martian.libsliding.a(context, new a.InterfaceC0522a() { // from class: z9.e
            public /* synthetic */ e() {
            }

            @Override // com.martian.libsliding.a.InterfaceC0522a
            public final void g0(Point point) {
                SlidingLayout.this.r(point);
            }
        });
    }

    public void j(boolean z10) {
        this.f12918e = new com.martian.libsliding.slider.a();
        setCacheEnabled(z10);
        this.f12918e.g(this);
        x(this.f12918e);
    }

    public void k() {
        this.f12929p = false;
        this.f12928o = false;
        this.f12930q = false;
        invalidate();
    }

    public boolean l() {
        return this.f12921h == TouchBlockType.AD;
    }

    public boolean m() {
        return this.f12919f && !this.f12918e.z();
    }

    public boolean n() {
        return this.f12919f;
    }

    public boolean o() {
        return this.f12931r;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return t(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (n()) {
            AutoSlider autoSlider = this.f12918e;
            if (autoSlider != null && autoSlider.c(z10, i10, i11, i12, i13)) {
                return;
            }
        } else {
            f fVar = this.f12917d;
            if (fVar != null && fVar.c(z10, i10, i11, i12, i13)) {
                return;
            }
        }
        for (int i14 = 0; i14 < getChildCount(); i14++) {
            View childAt = getChildAt(i14);
            if (childAt != null) {
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        measureChildren(i10, i11);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        super.onRestoreInstanceState(((SavedState) parcelable).getSuperState());
        d<?> dVar = this.f12920g;
        if (dVar != null) {
            dVar.w();
            w();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        d<?> dVar = this.f12920g;
        if (dVar != null) {
            savedState.f12932b = dVar.x();
        }
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return u(motionEvent);
    }

    public boolean p() {
        return this.f12921h == TouchBlockType.DEFAULT;
    }

    public boolean q() {
        return this.f12921h == TouchBlockType.FORCE;
    }

    public final /* synthetic */ void r(Point point) {
        a.InterfaceC0522a interfaceC0522a = this.f12916c;
        if (interfaceC0522a != null) {
            interfaceC0522a.g0(point);
        }
    }

    public void s() {
        d<?> dVar = this.f12920g;
        if (dVar != null) {
            dVar.v();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void setAdapter(d<T> dVar) {
        this.f12920g = dVar;
        dVar.A(this);
        this.f12920g.w();
        w();
        postInvalidate();
    }

    public void setBlockType(TouchBlockType touchBlockType) {
        this.f12921h = touchBlockType;
    }

    public void setCacheEnabled(boolean z10) {
        this.f12931r = z10;
    }

    public void setOnSlideChangeListener(a aVar) {
        this.f12924k = aVar;
    }

    public void setOnTapListener(a.InterfaceC0522a interfaceC0522a) {
        this.f12916c = interfaceC0522a;
    }

    public void setSlider(f fVar) {
        this.f12917d = fVar;
        fVar.g(this);
        x(this.f12917d);
    }

    public final boolean t(MotionEvent motionEvent) {
        f fVar;
        return n() ? this.f12918e.j(motionEvent) : (J(motionEvent.getY()) || (fVar = this.f12917d) == null || !fVar.j(motionEvent)) ? false : true;
    }

    public boolean u(MotionEvent motionEvent) {
        if (!n()) {
            f fVar = this.f12917d;
            if (fVar != null) {
                if (!fVar.e() && J(motionEvent.getY())) {
                    return false;
                }
                if (this.f12917d.onTouchEvent(motionEvent)) {
                    return true;
                }
            }
        } else if (this.f12918e.onTouchEvent(motionEvent)) {
            return true;
        }
        this.f12915b.b(motionEvent);
        return true;
    }

    public void v() {
        AutoSlider autoSlider = this.f12918e;
        if (autoSlider == null) {
            return;
        }
        autoSlider.F();
    }

    public void w() {
        removeAllViews();
        if (this.f12920g != null) {
            y();
            G(getAdapter().d());
        }
    }

    public void x(f fVar) {
        removeAllViews();
        if (this.f12920g != null) {
            fVar.f();
            G(getAdapter().d());
        }
    }

    public final void y() {
        if (this.f12919f) {
            this.f12918e.f();
            return;
        }
        f fVar = this.f12917d;
        if (fVar != null) {
            fVar.f();
        }
    }

    public void z() {
        this.f12919f = true;
        if (this.f12918e.G()) {
            return;
        }
        this.f12918e.J();
    }

    public SlidingLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12919f = false;
        this.f12921h = TouchBlockType.DEFAULT;
        this.f12928o = false;
        this.f12929p = false;
        this.f12930q = false;
        this.f12931r = false;
        i(context);
    }

    public SlidingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12919f = false;
        this.f12921h = TouchBlockType.DEFAULT;
        this.f12928o = false;
        this.f12929p = false;
        this.f12930q = false;
        this.f12931r = false;
        i(context);
    }
}
