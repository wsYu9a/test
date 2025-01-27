package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes.dex */
class r implements t {

    /* renamed from: a */
    protected a f7379a;

    @SuppressLint({"ViewConstructor", "PrivateApi"})
    static class a extends ViewGroup {

        /* renamed from: a */
        static Method f7380a;

        /* renamed from: b */
        ViewGroup f7381b;

        /* renamed from: c */
        View f7382c;

        /* renamed from: d */
        ArrayList<Drawable> f7383d;

        /* renamed from: e */
        r f7384e;

        /* renamed from: f */
        private boolean f7385f;

        static {
            try {
                Class cls = Integer.TYPE;
                f7380a = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", cls, cls, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        a(Context context, ViewGroup viewGroup, View view, r rVar) {
            super(context);
            this.f7383d = null;
            this.f7381b = viewGroup;
            this.f7382c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f7384e = rVar;
        }

        private void c() {
            if (this.f7385f) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        private void d() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f7383d;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f7385f = true;
                    this.f7381b.removeView(this);
                }
            }
        }

        private void e(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f7381b.getLocationOnScreen(iArr2);
            this.f7382c.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        public void a(Drawable drawable) {
            c();
            if (this.f7383d == null) {
                this.f7383d = new ArrayList<>();
            }
            if (this.f7383d.contains(drawable)) {
                return;
            }
            this.f7383d.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        public void b(View view) {
            c();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != this.f7381b && viewGroup.getParent() != null && ViewCompat.isAttachedToWindow(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f7381b.getLocationOnScreen(iArr2);
                    ViewCompat.offsetLeftAndRight(view, iArr[0] - iArr2[0]);
                    ViewCompat.offsetTopAndBottom(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            this.f7381b.getLocationOnScreen(new int[2]);
            this.f7382c.getLocationOnScreen(new int[2]);
            canvas.translate(r0[0] - r1[0], r0[1] - r1[1]);
            canvas.clipRect(new Rect(0, 0, this.f7382c.getWidth(), this.f7382c.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f7383d;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f7383d.get(i2).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected ViewParent f(int i2, int i3, Rect rect) {
            if (this.f7381b == null || f7380a == null) {
                return null;
            }
            try {
                e(new int[2]);
                f7380a.invoke(this.f7381b, Integer.valueOf(i2), Integer.valueOf(i3), rect);
                return null;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return null;
            }
        }

        public void g(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f7383d;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
                d();
            }
        }

        public void h(View view) {
            super.removeView(view);
            d();
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f7381b == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (this.f7381b == null) {
                invalidate(rect);
                return null;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            int[] iArr2 = new int[2];
            e(iArr2);
            rect.offset(iArr2[0], iArr2[1]);
            return super.invalidateChildInParent(iArr, rect);
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        }

        @Override // android.view.View
        protected boolean verifyDrawable(@NonNull Drawable drawable) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(drawable) || ((arrayList = this.f7383d) != null && arrayList.contains(drawable));
        }
    }

    r(Context context, ViewGroup viewGroup, View view) {
        this.f7379a = new a(context, viewGroup, view, this);
    }

    static r a(View view) {
        ViewGroup e2 = u.e(view);
        if (e2 == null) {
            return null;
        }
        int childCount = e2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = e2.getChildAt(i2);
            if (childAt instanceof a) {
                return ((a) childAt).f7384e;
            }
        }
        return new o(e2.getContext(), e2, view);
    }

    @Override // com.google.android.material.internal.t
    public void add(@NonNull Drawable drawable) {
        this.f7379a.a(drawable);
    }

    @Override // com.google.android.material.internal.t
    public void remove(@NonNull Drawable drawable) {
        this.f7379a.g(drawable);
    }
}
