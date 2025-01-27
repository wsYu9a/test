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

/* loaded from: classes4.dex */
public class CircleImageView extends ImageView {
    public static final boolean A = false;

    /* renamed from: u */
    public static final ImageView.ScaleType f25514u = ImageView.ScaleType.CENTER_CROP;

    /* renamed from: v */
    public static final Bitmap.Config f25515v = Bitmap.Config.ARGB_8888;

    /* renamed from: w */
    public static final int f25516w = 2;

    /* renamed from: x */
    public static final int f25517x = 0;

    /* renamed from: y */
    public static final int f25518y = -16777216;

    /* renamed from: z */
    public static final int f25519z = 0;

    /* renamed from: b */
    public final RectF f25520b;

    /* renamed from: c */
    public final RectF f25521c;

    /* renamed from: d */
    public final Matrix f25522d;

    /* renamed from: e */
    public final Paint f25523e;

    /* renamed from: f */
    public final Paint f25524f;

    /* renamed from: g */
    public final Paint f25525g;

    /* renamed from: h */
    public int f25526h;

    /* renamed from: i */
    public int f25527i;

    /* renamed from: j */
    public int f25528j;

    /* renamed from: k */
    public Bitmap f25529k;

    /* renamed from: l */
    public BitmapShader f25530l;

    /* renamed from: m */
    public int f25531m;

    /* renamed from: n */
    public int f25532n;

    /* renamed from: o */
    public float f25533o;

    /* renamed from: p */
    public float f25534p;

    /* renamed from: q */
    public ColorFilter f25535q;

    /* renamed from: r */
    public boolean f25536r;

    /* renamed from: s */
    public boolean f25537s;

    /* renamed from: t */
    public boolean f25538t;

    public CircleImageView(Context context) {
        super(context);
        this.f25520b = new RectF();
        this.f25521c = new RectF();
        this.f25522d = new Matrix();
        this.f25523e = new Paint();
        this.f25524f = new Paint();
        this.f25525g = new Paint();
        this.f25526h = -16777216;
        this.f25527i = 0;
        this.f25528j = 0;
        b();
    }

    public final Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = drawable instanceof ColorDrawable ? Bitmap.createBitmap(2, 2, f25515v) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f25515v);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public final void b() {
        super.setScaleType(f25514u);
        this.f25536r = true;
        if (this.f25537s) {
            d();
            this.f25537s = false;
        }
    }

    public boolean c() {
        return this.f25538t;
    }

    public final void d() {
        if (!this.f25536r) {
            this.f25537s = true;
            return;
        }
        if (getWidth() == 0 && getHeight() == 0) {
            return;
        }
        if (this.f25529k == null) {
            invalidate();
            return;
        }
        Bitmap bitmap = this.f25529k;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f25530l = new BitmapShader(bitmap, tileMode, tileMode);
        this.f25523e.setAntiAlias(true);
        this.f25523e.setShader(this.f25530l);
        this.f25524f.setStyle(Paint.Style.STROKE);
        this.f25524f.setAntiAlias(true);
        this.f25524f.setColor(this.f25526h);
        this.f25524f.setStrokeWidth(this.f25527i);
        this.f25525g.setStyle(Paint.Style.FILL);
        this.f25525g.setAntiAlias(true);
        this.f25525g.setColor(this.f25528j);
        this.f25532n = this.f25529k.getHeight();
        this.f25531m = this.f25529k.getWidth();
        this.f25521c.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f25534p = Math.min((this.f25521c.height() - this.f25527i) / 2.0f, (this.f25521c.width() - this.f25527i) / 2.0f);
        this.f25520b.set(this.f25521c);
        if (!this.f25538t) {
            RectF rectF = this.f25520b;
            int i10 = this.f25527i;
            rectF.inset(i10, i10);
        }
        this.f25533o = Math.min(this.f25520b.height() / 2.0f, this.f25520b.width() / 2.0f);
        e();
        invalidate();
    }

    public final void e() {
        float width;
        float height;
        this.f25522d.set(null);
        float f10 = 0.0f;
        if (this.f25531m * this.f25520b.height() > this.f25520b.width() * this.f25532n) {
            width = this.f25520b.height() / this.f25532n;
            f10 = (this.f25520b.width() - (this.f25531m * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = this.f25520b.width() / this.f25531m;
            height = (this.f25520b.height() - (this.f25532n * width)) * 0.5f;
        }
        this.f25522d.setScale(width, width);
        Matrix matrix = this.f25522d;
        RectF rectF = this.f25520b;
        matrix.postTranslate(((int) (f10 + 0.5f)) + rectF.left, ((int) (height + 0.5f)) + rectF.top);
        this.f25530l.setLocalMatrix(this.f25522d);
    }

    public int getBorderColor() {
        return this.f25526h;
    }

    public int getBorderWidth() {
        return this.f25527i;
    }

    public int getFillColor() {
        return this.f25528j;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return f25514u;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f25529k == null) {
            return;
        }
        if (this.f25528j != 0) {
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.f25533o, this.f25525g);
        }
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.f25533o, this.f25523e);
        if (this.f25527i != 0) {
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.f25534p, this.f25524f);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        d();
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z10) {
        if (z10) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(@ColorInt int i10) {
        if (i10 == this.f25526h) {
            return;
        }
        this.f25526h = i10;
        this.f25524f.setColor(i10);
        invalidate();
    }

    public void setBorderColorResource(@ColorRes int i10) {
        setBorderColor(getContext().getResources().getColor(i10));
    }

    public void setBorderOverlay(boolean z10) {
        if (z10 == this.f25538t) {
            return;
        }
        this.f25538t = z10;
        d();
    }

    public void setBorderWidth(int i10) {
        if (i10 == this.f25527i) {
            return;
        }
        this.f25527i = i10;
        d();
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter == this.f25535q) {
            return;
        }
        this.f25535q = colorFilter;
        this.f25523e.setColorFilter(colorFilter);
        invalidate();
    }

    public void setFillColor(@ColorInt int i10) {
        if (i10 == this.f25528j) {
            return;
        }
        this.f25528j = i10;
        this.f25525g.setColor(i10);
        invalidate();
    }

    public void setFillColorResource(@ColorRes int i10) {
        setFillColor(getContext().getResources().getColor(i10));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f25529k = bitmap;
        d();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.f25529k = a(drawable);
        d();
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i10) {
        super.setImageResource(i10);
        this.f25529k = a(getDrawable());
        d();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.f25529k = uri != null ? a(getDrawable()) : null;
        d();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != f25514u) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f25520b = new RectF();
        this.f25521c = new RectF();
        this.f25522d = new Matrix();
        this.f25523e = new Paint();
        this.f25524f = new Paint();
        this.f25525g = new Paint();
        this.f25526h = -16777216;
        this.f25527i = 0;
        this.f25528j = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleImageView, i10, 0);
        this.f25527i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleImageView_civ_border_width, 0);
        this.f25526h = obtainStyledAttributes.getColor(R.styleable.CircleImageView_civ_border_color, -16777216);
        this.f25538t = obtainStyledAttributes.getBoolean(R.styleable.CircleImageView_civ_border_overlay, false);
        this.f25528j = obtainStyledAttributes.getColor(R.styleable.CircleImageView_civ_fill_color, 0);
        obtainStyledAttributes.recycle();
        b();
    }
}
