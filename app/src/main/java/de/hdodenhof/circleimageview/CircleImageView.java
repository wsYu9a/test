package de.hdodenhof.circleimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;

/* loaded from: classes5.dex */
public class CircleImageView extends ImageView {

    /* renamed from: a */
    private static final ImageView.ScaleType f35214a = ImageView.ScaleType.CENTER_CROP;

    /* renamed from: b */
    private static final Bitmap.Config f35215b = Bitmap.Config.ARGB_8888;

    /* renamed from: c */
    private static final int f35216c = 2;

    /* renamed from: d */
    private static final int f35217d = 0;

    /* renamed from: e */
    private static final int f35218e = -16777216;

    /* renamed from: f */
    private static final int f35219f = 0;

    /* renamed from: g */
    private static final boolean f35220g = false;

    /* renamed from: h */
    private final RectF f35221h;

    /* renamed from: i */
    private final RectF f35222i;

    /* renamed from: j */
    private final Matrix f35223j;
    private final Paint k;
    private final Paint l;
    private final Paint m;
    private int n;
    private int o;
    private int p;
    private Bitmap q;
    private BitmapShader r;
    private int s;
    private int t;
    private float u;
    private float v;
    private ColorFilter w;
    private boolean x;
    private boolean y;
    private boolean z;

    public CircleImageView(Context context) {
        super(context);
        this.f35221h = new RectF();
        this.f35222i = new RectF();
        this.f35223j = new Matrix();
        this.k = new Paint();
        this.l = new Paint();
        this.m = new Paint();
        this.n = -16777216;
        this.o = 0;
        this.p = 0;
        b();
    }

    private Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = drawable instanceof ColorDrawable ? Bitmap.createBitmap(2, 2, f35215b) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f35215b);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void b() {
        super.setScaleType(f35214a);
        this.x = true;
        if (this.y) {
            d();
            this.y = false;
        }
    }

    private void d() {
        if (!this.x) {
            this.y = true;
            return;
        }
        if (getWidth() == 0 && getHeight() == 0) {
            return;
        }
        if (this.q == null) {
            invalidate();
            return;
        }
        Bitmap bitmap = this.q;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.r = new BitmapShader(bitmap, tileMode, tileMode);
        this.k.setAntiAlias(true);
        this.k.setShader(this.r);
        this.l.setStyle(Paint.Style.STROKE);
        this.l.setAntiAlias(true);
        this.l.setColor(this.n);
        this.l.setStrokeWidth(this.o);
        this.m.setStyle(Paint.Style.FILL);
        this.m.setAntiAlias(true);
        this.m.setColor(this.p);
        this.t = this.q.getHeight();
        this.s = this.q.getWidth();
        this.f35222i.set(0.0f, 0.0f, getWidth(), getHeight());
        this.v = Math.min((this.f35222i.height() - this.o) / 2.0f, (this.f35222i.width() - this.o) / 2.0f);
        this.f35221h.set(this.f35222i);
        if (!this.z) {
            RectF rectF = this.f35221h;
            int i2 = this.o;
            rectF.inset(i2, i2);
        }
        this.u = Math.min(this.f35221h.height() / 2.0f, this.f35221h.width() / 2.0f);
        e();
        invalidate();
    }

    private void e() {
        float width;
        float height;
        this.f35223j.set(null);
        float f2 = 0.0f;
        if (this.s * this.f35221h.height() > this.f35221h.width() * this.t) {
            width = this.f35221h.height() / this.t;
            f2 = (this.f35221h.width() - (this.s * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = this.f35221h.width() / this.s;
            height = (this.f35221h.height() - (this.t * width)) * 0.5f;
        }
        this.f35223j.setScale(width, width);
        Matrix matrix = this.f35223j;
        RectF rectF = this.f35221h;
        matrix.postTranslate(((int) (f2 + 0.5f)) + rectF.left, ((int) (height + 0.5f)) + rectF.top);
        this.r.setLocalMatrix(this.f35223j);
    }

    public boolean c() {
        return this.z;
    }

    public int getBorderColor() {
        return this.n;
    }

    public int getBorderWidth() {
        return this.o;
    }

    public int getFillColor() {
        return this.p;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return f35214a;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.q == null) {
            return;
        }
        if (this.p != 0) {
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.u, this.m);
        }
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.u, this.k);
        if (this.o != 0) {
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.v, this.l);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        d();
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(@ColorInt int i2) {
        if (i2 == this.n) {
            return;
        }
        this.n = i2;
        this.l.setColor(i2);
        invalidate();
    }

    public void setBorderColorResource(@ColorRes int i2) {
        setBorderColor(getContext().getResources().getColor(i2));
    }

    public void setBorderOverlay(boolean z) {
        if (z == this.z) {
            return;
        }
        this.z = z;
        d();
    }

    public void setBorderWidth(int i2) {
        if (i2 == this.o) {
            return;
        }
        this.o = i2;
        d();
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter == this.w) {
            return;
        }
        this.w = colorFilter;
        this.k.setColorFilter(colorFilter);
        invalidate();
    }

    public void setFillColor(@ColorInt int i2) {
        if (i2 == this.p) {
            return;
        }
        this.p = i2;
        this.m.setColor(i2);
        invalidate();
    }

    public void setFillColorResource(@ColorRes int i2) {
        setFillColor(getContext().getResources().getColor(i2));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.q = bitmap;
        d();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.q = a(drawable);
        d();
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i2) {
        super.setImageResource(i2);
        this.q = a(getDrawable());
        d();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.q = uri != null ? a(getDrawable()) : null;
        d();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != f35214a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f35221h = new RectF();
        this.f35222i = new RectF();
        this.f35223j = new Matrix();
        this.k = new Paint();
        this.l = new Paint();
        this.m = new Paint();
        this.n = -16777216;
        this.o = 0;
        this.p = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleImageView, i2, 0);
        this.o = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleImageView_civ_border_width, 0);
        this.n = obtainStyledAttributes.getColor(R.styleable.CircleImageView_civ_border_color, -16777216);
        this.z = obtainStyledAttributes.getBoolean(R.styleable.CircleImageView_civ_border_overlay, false);
        this.p = obtainStyledAttributes.getColor(R.styleable.CircleImageView_civ_fill_color, 0);
        obtainStyledAttributes.recycle();
        b();
    }
}
