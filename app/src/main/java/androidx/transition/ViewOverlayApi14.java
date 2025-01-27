package androidx.transition;

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
class ViewOverlayApi14 implements ViewOverlayImpl {

    /* renamed from: a */
    protected OverlayViewGroup f3880a;

    ViewOverlayApi14(Context context, ViewGroup viewGroup, View view) {
        this.f3880a = new OverlayViewGroup(context, viewGroup, view, this);
    }

    static ViewOverlayApi14 a(View view) {
        ViewGroup b2 = b(view);
        if (b2 == null) {
            return null;
        }
        int childCount = b2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = b2.getChildAt(i2);
            if (childAt instanceof OverlayViewGroup) {
                return ((OverlayViewGroup) childAt).f3885e;
            }
        }
        return new ViewGroupOverlayApi14(b2.getContext(), b2, view);
    }

    static ViewGroup b(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void add(@NonNull Drawable drawable) {
        this.f3880a.add(drawable);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void remove(@NonNull Drawable drawable) {
        this.f3880a.remove(drawable);
    }

    static class OverlayViewGroup extends ViewGroup {

        /* renamed from: a */
        static Method f3881a;

        /* renamed from: b */
        ViewGroup f3882b;

        /* renamed from: c */
        View f3883c;

        /* renamed from: d */
        ArrayList<Drawable> f3884d;

        /* renamed from: e */
        ViewOverlayApi14 f3885e;

        /* renamed from: f */
        private boolean f3886f;

        static {
            try {
                Class cls = Integer.TYPE;
                f3881a = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", cls, cls, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        OverlayViewGroup(Context context, ViewGroup viewGroup, View view, ViewOverlayApi14 viewOverlayApi14) {
            super(context);
            this.f3884d = null;
            this.f3882b = viewGroup;
            this.f3883c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f3885e = viewOverlayApi14;
        }

        private void a() {
            if (this.f3886f) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        private void b() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f3884d;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f3886f = true;
                    this.f3882b.removeView(this);
                }
            }
        }

        private void c(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f3882b.getLocationOnScreen(iArr2);
            this.f3883c.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        public void add(Drawable drawable) {
            a();
            if (this.f3884d == null) {
                this.f3884d = new ArrayList<>();
            }
            if (this.f3884d.contains(drawable)) {
                return;
            }
            this.f3884d.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected ViewParent d(int i2, int i3, Rect rect) {
            if (!(this.f3882b instanceof ViewGroup) || f3881a == null) {
                return null;
            }
            try {
                c(new int[2]);
                f3881a.invoke(this.f3882b, Integer.valueOf(i2), Integer.valueOf(i3), rect);
                return null;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return null;
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            this.f3882b.getLocationOnScreen(new int[2]);
            this.f3883c.getLocationOnScreen(new int[2]);
            canvas.translate(r0[0] - r1[0], r0[1] - r1[1]);
            canvas.clipRect(new Rect(0, 0, this.f3883c.getWidth(), this.f3883c.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f3884d;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f3884d.get(i2).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f3882b == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (!(this.f3882b instanceof ViewGroup)) {
                invalidate(rect);
                return null;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            int[] iArr2 = new int[2];
            c(iArr2);
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

        public void remove(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f3884d;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
                b();
            }
        }

        @Override // android.view.View
        protected boolean verifyDrawable(@NonNull Drawable drawable) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(drawable) || ((arrayList = this.f3884d) != null && arrayList.contains(drawable));
        }

        public void remove(View view) {
            super.removeView(view);
            b();
        }

        public void add(View view) {
            a();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != this.f3882b && viewGroup.getParent() != null && ViewCompat.isAttachedToWindow(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f3882b.getLocationOnScreen(iArr2);
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
    }
}
