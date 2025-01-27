package com.sigmob.sdk.base.blurkit;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class c extends FrameLayout {

    /* renamed from: o */
    public static final float f17598o = 0.12f;

    /* renamed from: p */
    public static final int f17599p = 12;

    /* renamed from: q */
    public static final int f17600q = 24;

    /* renamed from: r */
    public static final float f17601r = 0.0f;

    /* renamed from: s */
    public static final float f17602s = Float.NaN;

    /* renamed from: a */
    public float f17603a;

    /* renamed from: b */
    public int f17604b;

    /* renamed from: c */
    public int f17605c;

    /* renamed from: d */
    public float f17606d;

    /* renamed from: e */
    public float f17607e;

    /* renamed from: f */
    public boolean f17608f;

    /* renamed from: g */
    public boolean f17609g;

    /* renamed from: h */
    public boolean f17610h;

    /* renamed from: i */
    public boolean f17611i;

    /* renamed from: j */
    public d f17612j;

    /* renamed from: k */
    public WeakReference<View> f17613k;

    /* renamed from: l */
    public Point f17614l;

    /* renamed from: m */
    public Bitmap f17615m;

    /* renamed from: n */
    public Choreographer.FrameCallback f17616n;

    public class a implements Choreographer.FrameCallback {
        public a() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j10) {
            c.this.invalidate();
            Choreographer.getInstance().postFrameCallbackDelayed(this, 1000 / c.this.f17605c);
        }
    }

    public c(Context context) {
        super(context, null);
        this.f17603a = 0.12f;
        this.f17604b = 12;
        this.f17605c = 24;
        this.f17606d = 0.0f;
        this.f17607e = Float.NaN;
        this.f17616n = new a();
    }

    private View getActivityView() {
        try {
            return ((Activity) getContext()).getWindow().getDecorView().findViewById(R.id.content);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    private Point getPositionInScreen() {
        PointF a10 = a((View) this);
        return new Point((int) a10.x, (int) a10.y);
    }

    public void b() {
        this.f17610h = true;
        this.f17614l = getPositionInScreen();
    }

    public void c() {
        this.f17611i = true;
        WeakReference<View> weakReference = this.f17613k;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View rootView = this.f17613k.get().getRootView();
        try {
            super.setAlpha(0.0f);
            this.f17615m = a(rootView, new Rect(0, 0, rootView.getWidth(), rootView.getHeight()), this.f17603a);
            if (Float.isNaN(this.f17607e)) {
                super.setAlpha(1.0f);
            } else {
                super.setAlpha(this.f17607e);
            }
            this.f17615m = com.sigmob.sdk.base.blurkit.a.a().a(this.f17615m, this.f17604b);
        } catch (Exception unused) {
        }
    }

    public void d() {
        if (this.f17608f) {
            this.f17608f = false;
            Choreographer.getInstance().removeFrameCallback(this.f17616n);
        }
    }

    public void e() {
        if (!this.f17608f && this.f17605c > 0) {
            this.f17608f = true;
            Choreographer.getInstance().postFrameCallback(this.f17616n);
        }
    }

    public void f() {
        this.f17610h = false;
        this.f17614l = null;
    }

    public void g() {
        this.f17611i = false;
        this.f17615m = null;
    }

    @Override // android.view.View
    public float getAlpha() {
        return this.f17607e;
    }

    public int getBlurRadius() {
        return this.f17604b;
    }

    public float getCornerRadius() {
        return this.f17606d;
    }

    public float getDownscaleFactor() {
        return this.f17603a;
    }

    public int getFPS() {
        return this.f17605c;
    }

    public boolean getPositionLocked() {
        return this.f17610h;
    }

    public boolean getViewLocked() {
        return this.f17611i;
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Bitmap a10 = a();
        if (a10 != null) {
            this.f17612j.setImageBitmap(a10);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f17609g = true;
        e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f17609g = false;
        d();
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        invalidate();
    }

    @Override // android.view.View
    public void setAlpha(float f10) {
        this.f17607e = f10;
        if (this.f17611i) {
            return;
        }
        super.setAlpha(f10);
    }

    public void setBlurRadius(int i10) {
        this.f17604b = i10;
        this.f17615m = null;
        invalidate();
    }

    public void setCornerRadius(float f10) {
        this.f17606d = f10;
        d dVar = this.f17612j;
        if (dVar != null) {
            dVar.setCornerRadius(f10);
        }
        invalidate();
    }

    public void setDownscaleFactor(float f10) {
        this.f17603a = f10;
        this.f17615m = null;
        invalidate();
    }

    public void setFPS(int i10) {
        if (this.f17608f) {
            d();
        }
        this.f17605c = i10;
        if (this.f17609g) {
            e();
        }
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17603a = 0.12f;
        this.f17604b = 12;
        this.f17605c = 24;
        this.f17606d = 0.0f;
        this.f17607e = Float.NaN;
        this.f17616n = new a();
        if (!isInEditMode()) {
            com.sigmob.sdk.base.blurkit.a.a(context);
        }
        d dVar = new d(getContext());
        this.f17612j = dVar;
        dVar.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f17612j);
        setCornerRadius(this.f17606d);
    }

    public final Bitmap a() {
        Point positionInScreen;
        Bitmap a10;
        if (getContext() != null && !isInEditMode()) {
            WeakReference<View> weakReference = this.f17613k;
            if (weakReference == null || weakReference.get() == null) {
                WeakReference<View> weakReference2 = new WeakReference<>(getActivityView());
                this.f17613k = weakReference2;
                if (weakReference2.get() == null) {
                    return null;
                }
            }
            if (this.f17610h) {
                if (this.f17614l == null) {
                    this.f17614l = getPositionInScreen();
                }
                positionInScreen = this.f17614l;
            } else {
                positionInScreen = getPositionInScreen();
            }
            super.setAlpha(0.0f);
            int width = this.f17613k.get().getWidth();
            int height = this.f17613k.get().getHeight();
            int width2 = (int) (getWidth() * this.f17603a);
            float height2 = getHeight();
            float f10 = this.f17603a;
            int i10 = (int) (height2 * f10);
            int i11 = (int) (positionInScreen.x * f10);
            int i12 = (int) (positionInScreen.y * f10);
            int width3 = getWidth() / 8;
            int height3 = getHeight() / 8;
            int i13 = -width3;
            if (i11 + i13 < 0) {
                i13 = 0;
            }
            if ((i11 + width) - width3 > width) {
                width3 = (width + width) - i11;
            }
            int i14 = -height3;
            if (i12 + i14 < 0) {
                i14 = 0;
            }
            if (getHeight() + i12 + height3 > height) {
                height3 = 0;
            }
            if (this.f17611i) {
                if (this.f17615m == null) {
                    c();
                }
                if (width2 == 0 || i10 == 0) {
                    return null;
                }
                a10 = Bitmap.createBitmap(this.f17615m, i11, i12, width2, i10);
            } else {
                try {
                    View view = this.f17613k.get();
                    int i15 = positionInScreen.x;
                    a10 = a(view, new Rect(i15 + i13, positionInScreen.y + i14, i15 + getWidth() + Math.abs(i13) + width3, positionInScreen.y + getHeight() + Math.abs(i14) + height3), this.f17603a);
                } catch (b | NullPointerException unused) {
                }
            }
            if (!this.f17611i) {
                a10 = Bitmap.createBitmap(com.sigmob.sdk.base.blurkit.a.a().a(a10, this.f17604b), (int) (Math.abs(i13) * this.f17603a), (int) (Math.abs(i14) * this.f17603a), width2, i10);
            }
            super.setAlpha(Float.isNaN(this.f17607e) ? 1.0f : this.f17607e);
            return a10;
        }
        return null;
    }

    public final Bitmap a(View view, Rect rect, float f10) throws b, NullPointerException {
        View rootView = view.getRootView();
        int width = (int) (rect.width() * f10);
        int height = (int) (rect.height() * f10);
        if (rootView.getWidth() <= 0 || rootView.getHeight() <= 0 || width <= 0 || height <= 0) {
            throw new b("No screen available (width or height = 0)");
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        matrix.preScale(f10, f10);
        matrix.postTranslate((-rect.left) * f10, (-rect.top) * f10);
        canvas.setMatrix(matrix);
        rootView.draw(canvas);
        return createBitmap;
    }

    public final PointF a(View view) {
        if (getParent() == null) {
            return new PointF();
        }
        try {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup == null) {
                return new PointF();
            }
            PointF a10 = a(viewGroup);
            a10.offset(view.getX(), view.getY());
            return a10;
        } catch (Exception unused) {
            return new PointF();
        }
    }
}
