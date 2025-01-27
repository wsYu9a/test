package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.circularreveal.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    private static final boolean f6954a = false;

    /* renamed from: b */
    public static final int f6955b = 0;

    /* renamed from: c */
    public static final int f6956c = 1;

    /* renamed from: d */
    public static final int f6957d = 2;

    /* renamed from: e */
    public static final int f6958e;

    /* renamed from: f */
    private final a f6959f;

    /* renamed from: g */
    @NonNull
    private final View f6960g;

    /* renamed from: h */
    @NonNull
    private final Path f6961h;

    /* renamed from: i */
    @NonNull
    private final Paint f6962i;

    /* renamed from: j */
    @NonNull
    private final Paint f6963j;

    @Nullable
    private c.e k;

    @Nullable
    private Drawable l;
    private Paint m;
    private boolean n;
    private boolean o;

    public interface a {
        void c(Canvas canvas);

        boolean d();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.google.android.material.circularreveal.b$b */
    public @interface InterfaceC0087b {
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            f6958e = 2;
        } else if (i2 >= 18) {
            f6958e = 1;
        } else {
            f6958e = 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(a aVar) {
        this.f6959f = aVar;
        View view = (View) aVar;
        this.f6960g = view;
        view.setWillNotDraw(false);
        this.f6961h = new Path();
        this.f6962i = new Paint(7);
        Paint paint = new Paint(1);
        this.f6963j = paint;
        paint.setColor(0);
    }

    private void d(@NonNull Canvas canvas, int i2, float f2) {
        this.m.setColor(i2);
        this.m.setStrokeWidth(f2);
        c.e eVar = this.k;
        canvas.drawCircle(eVar.f6969b, eVar.f6970c, eVar.f6971d - (f2 / 2.0f), this.m);
    }

    private void e(@NonNull Canvas canvas) {
        this.f6959f.c(canvas);
        if (r()) {
            c.e eVar = this.k;
            canvas.drawCircle(eVar.f6969b, eVar.f6970c, eVar.f6971d, this.f6963j);
        }
        if (p()) {
            d(canvas, -16777216, 10.0f);
            d(canvas, -65536, 5.0f);
        }
        f(canvas);
    }

    private void f(@NonNull Canvas canvas) {
        if (q()) {
            Rect bounds = this.l.getBounds();
            float width = this.k.f6969b - (bounds.width() / 2.0f);
            float height = this.k.f6970c - (bounds.height() / 2.0f);
            canvas.translate(width, height);
            this.l.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    private float i(@NonNull c.e eVar) {
        return com.google.android.material.f.a.b(eVar.f6969b, eVar.f6970c, 0.0f, 0.0f, this.f6960g.getWidth(), this.f6960g.getHeight());
    }

    private void k() {
        if (f6958e == 1) {
            this.f6961h.rewind();
            c.e eVar = this.k;
            if (eVar != null) {
                this.f6961h.addCircle(eVar.f6969b, eVar.f6970c, eVar.f6971d, Path.Direction.CW);
            }
        }
        this.f6960g.invalidate();
    }

    private boolean p() {
        c.e eVar = this.k;
        boolean z = eVar == null || eVar.a();
        return f6958e == 0 ? !z && this.o : !z;
    }

    private boolean q() {
        return (this.n || this.l == null || this.k == null) ? false : true;
    }

    private boolean r() {
        return (this.n || Color.alpha(this.f6963j.getColor()) == 0) ? false : true;
    }

    public void a() {
        if (f6958e == 0) {
            this.n = true;
            this.o = false;
            this.f6960g.buildDrawingCache();
            Bitmap drawingCache = this.f6960g.getDrawingCache();
            if (drawingCache == null && this.f6960g.getWidth() != 0 && this.f6960g.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.f6960g.getWidth(), this.f6960g.getHeight(), Bitmap.Config.ARGB_8888);
                this.f6960g.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.f6962i;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.n = false;
            this.o = true;
        }
    }

    public void b() {
        if (f6958e == 0) {
            this.o = false;
            this.f6960g.destroyDrawingCache();
            this.f6962i.setShader(null);
            this.f6960g.invalidate();
        }
    }

    public void c(@NonNull Canvas canvas) {
        if (p()) {
            int i2 = f6958e;
            if (i2 == 0) {
                c.e eVar = this.k;
                canvas.drawCircle(eVar.f6969b, eVar.f6970c, eVar.f6971d, this.f6962i);
                if (r()) {
                    c.e eVar2 = this.k;
                    canvas.drawCircle(eVar2.f6969b, eVar2.f6970c, eVar2.f6971d, this.f6963j);
                }
            } else if (i2 == 1) {
                int save = canvas.save();
                canvas.clipPath(this.f6961h);
                this.f6959f.c(canvas);
                if (r()) {
                    canvas.drawRect(0.0f, 0.0f, this.f6960g.getWidth(), this.f6960g.getHeight(), this.f6963j);
                }
                canvas.restoreToCount(save);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("Unsupported strategy " + i2);
                }
                this.f6959f.c(canvas);
                if (r()) {
                    canvas.drawRect(0.0f, 0.0f, this.f6960g.getWidth(), this.f6960g.getHeight(), this.f6963j);
                }
            }
        } else {
            this.f6959f.c(canvas);
            if (r()) {
                canvas.drawRect(0.0f, 0.0f, this.f6960g.getWidth(), this.f6960g.getHeight(), this.f6963j);
            }
        }
        f(canvas);
    }

    @Nullable
    public Drawable g() {
        return this.l;
    }

    @ColorInt
    public int h() {
        return this.f6963j.getColor();
    }

    @Nullable
    public c.e j() {
        c.e eVar = this.k;
        if (eVar == null) {
            return null;
        }
        c.e eVar2 = new c.e(eVar);
        if (eVar2.a()) {
            eVar2.f6971d = i(eVar2);
        }
        return eVar2;
    }

    public boolean l() {
        return this.f6959f.d() && !p();
    }

    public void m(@Nullable Drawable drawable) {
        this.l = drawable;
        this.f6960g.invalidate();
    }

    public void n(@ColorInt int i2) {
        this.f6963j.setColor(i2);
        this.f6960g.invalidate();
    }

    public void o(@Nullable c.e eVar) {
        if (eVar == null) {
            this.k = null;
        } else {
            c.e eVar2 = this.k;
            if (eVar2 == null) {
                this.k = new c.e(eVar);
            } else {
                eVar2.c(eVar);
            }
            if (com.google.android.material.f.a.e(eVar.f6971d, i(eVar), 1.0E-4f)) {
                this.k.f6971d = Float.MAX_VALUE;
            }
        }
        k();
    }
}
