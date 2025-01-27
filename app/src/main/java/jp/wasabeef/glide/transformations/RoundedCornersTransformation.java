package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
public class RoundedCornersTransformation extends th.a {

    /* renamed from: e */
    public static final int f27592e = 1;

    /* renamed from: f */
    public static final String f27593f = "jp.wasabeef.glide.transformations.RoundedCornersTransformation.1";

    /* renamed from: a */
    public final int f27594a;

    /* renamed from: b */
    public final int f27595b;

    /* renamed from: c */
    public final int f27596c;

    /* renamed from: d */
    public final CornerType f27597d;

    public enum CornerType {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT
    }

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f27598a;

        static {
            int[] iArr = new int[CornerType.values().length];
            f27598a = iArr;
            try {
                iArr[CornerType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27598a[CornerType.TOP_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27598a[CornerType.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f27598a[CornerType.BOTTOM_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f27598a[CornerType.BOTTOM_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f27598a[CornerType.TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f27598a[CornerType.BOTTOM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f27598a[CornerType.LEFT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f27598a[CornerType.RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f27598a[CornerType.OTHER_TOP_LEFT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f27598a[CornerType.OTHER_TOP_RIGHT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f27598a[CornerType.OTHER_BOTTOM_LEFT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f27598a[CornerType.OTHER_BOTTOM_RIGHT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f27598a[CornerType.DIAGONAL_FROM_TOP_LEFT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f27598a[CornerType.DIAGONAL_FROM_TOP_RIGHT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public RoundedCornersTransformation(int radius, int margin) {
        this(radius, margin, CornerType.ALL);
    }

    @Override // th.a
    public Bitmap b(@NonNull Context context, @NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        int width = toTransform.getWidth();
        int height = toTransform.getHeight();
        Bitmap bitmap = pool.get(width, height, Bitmap.Config.ARGB_8888);
        bitmap.setHasAlpha(true);
        a(toTransform, bitmap);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(toTransform, tileMode, tileMode));
        n(canvas, paint, width, height);
        return bitmap;
    }

    public final void c(Canvas canvas, Paint paint, float right, float bottom) {
        RectF rectF = new RectF(this.f27596c, bottom - this.f27595b, r1 + r3, bottom);
        int i10 = this.f27594a;
        canvas.drawRoundRect(rectF, i10, i10, paint);
        int i11 = this.f27596c;
        canvas.drawRect(new RectF(i11, i11, i11 + this.f27595b, bottom - this.f27594a), paint);
        canvas.drawRect(new RectF(this.f27594a + r1, this.f27596c, right, bottom), paint);
    }

    public final void d(Canvas canvas, Paint paint, float right, float bottom) {
        int i10 = this.f27595b;
        RectF rectF = new RectF(right - i10, bottom - i10, right, bottom);
        int i11 = this.f27594a;
        canvas.drawRoundRect(rectF, i11, i11, paint);
        int i12 = this.f27596c;
        canvas.drawRect(new RectF(i12, i12, right - this.f27594a, bottom), paint);
        int i13 = this.f27594a;
        canvas.drawRect(new RectF(right - i13, this.f27596c, right, bottom - i13), paint);
    }

    public final void e(Canvas canvas, Paint paint, float right, float bottom) {
        RectF rectF = new RectF(this.f27596c, bottom - this.f27595b, right, bottom);
        int i10 = this.f27594a;
        canvas.drawRoundRect(rectF, i10, i10, paint);
        int i11 = this.f27596c;
        canvas.drawRect(new RectF(i11, i11, right, bottom - this.f27594a), paint);
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public boolean equals(Object o10) {
        if (o10 instanceof RoundedCornersTransformation) {
            RoundedCornersTransformation roundedCornersTransformation = (RoundedCornersTransformation) o10;
            if (roundedCornersTransformation.f27594a == this.f27594a && roundedCornersTransformation.f27595b == this.f27595b && roundedCornersTransformation.f27596c == this.f27596c && roundedCornersTransformation.f27597d == this.f27597d) {
                return true;
            }
        }
        return false;
    }

    public final void f(Canvas canvas, Paint paint, float right, float bottom) {
        int i10 = this.f27596c;
        int i11 = this.f27595b;
        RectF rectF = new RectF(i10, i10, i10 + i11, i10 + i11);
        int i12 = this.f27594a;
        canvas.drawRoundRect(rectF, i12, i12, paint);
        int i13 = this.f27595b;
        RectF rectF2 = new RectF(right - i13, bottom - i13, right, bottom);
        int i14 = this.f27594a;
        canvas.drawRoundRect(rectF2, i14, i14, paint);
        canvas.drawRect(new RectF(this.f27596c, r1 + r3, right - this.f27594a, bottom), paint);
        canvas.drawRect(new RectF(r1 + r2, this.f27596c, right, bottom - this.f27594a), paint);
    }

    public final void g(Canvas canvas, Paint paint, float right, float bottom) {
        int i10 = this.f27595b;
        RectF rectF = new RectF(right - i10, this.f27596c, right, r3 + i10);
        int i11 = this.f27594a;
        canvas.drawRoundRect(rectF, i11, i11, paint);
        RectF rectF2 = new RectF(this.f27596c, bottom - this.f27595b, r1 + r3, bottom);
        int i12 = this.f27594a;
        canvas.drawRoundRect(rectF2, i12, i12, paint);
        int i13 = this.f27596c;
        int i14 = this.f27594a;
        canvas.drawRect(new RectF(i13, i13, right - i14, bottom - i14), paint);
        int i15 = this.f27596c;
        int i16 = this.f27594a;
        canvas.drawRect(new RectF(i15 + i16, i15 + i16, right, bottom), paint);
    }

    public final void h(Canvas canvas, Paint paint, float right, float bottom) {
        int i10 = this.f27596c;
        RectF rectF = new RectF(i10, i10, i10 + this.f27595b, bottom);
        int i11 = this.f27594a;
        canvas.drawRoundRect(rectF, i11, i11, paint);
        canvas.drawRect(new RectF(this.f27594a + r1, this.f27596c, right, bottom), paint);
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public int hashCode() {
        return 425235636 + (this.f27594a * 10000) + (this.f27595b * 1000) + (this.f27596c * 100) + (this.f27597d.ordinal() * 10);
    }

    public final void i(Canvas canvas, Paint paint, float right, float bottom) {
        int i10 = this.f27596c;
        RectF rectF = new RectF(i10, i10, right, i10 + this.f27595b);
        int i11 = this.f27594a;
        canvas.drawRoundRect(rectF, i11, i11, paint);
        RectF rectF2 = new RectF(right - this.f27595b, this.f27596c, right, bottom);
        int i12 = this.f27594a;
        canvas.drawRoundRect(rectF2, i12, i12, paint);
        canvas.drawRect(new RectF(this.f27596c, r1 + r3, right - this.f27594a, bottom), paint);
    }

    public final void j(Canvas canvas, Paint paint, float right, float bottom) {
        int i10 = this.f27596c;
        RectF rectF = new RectF(i10, i10, right, i10 + this.f27595b);
        int i11 = this.f27594a;
        canvas.drawRoundRect(rectF, i11, i11, paint);
        int i12 = this.f27596c;
        RectF rectF2 = new RectF(i12, i12, i12 + this.f27595b, bottom);
        int i13 = this.f27594a;
        canvas.drawRoundRect(rectF2, i13, i13, paint);
        int i14 = this.f27596c;
        int i15 = this.f27594a;
        canvas.drawRect(new RectF(i14 + i15, i14 + i15, right, bottom), paint);
    }

    public final void k(Canvas canvas, Paint paint, float right, float bottom) {
        RectF rectF = new RectF(this.f27596c, bottom - this.f27595b, right, bottom);
        int i10 = this.f27594a;
        canvas.drawRoundRect(rectF, i10, i10, paint);
        RectF rectF2 = new RectF(right - this.f27595b, this.f27596c, right, bottom);
        int i11 = this.f27594a;
        canvas.drawRoundRect(rectF2, i11, i11, paint);
        int i12 = this.f27596c;
        int i13 = this.f27594a;
        canvas.drawRect(new RectF(i12, i12, right - i13, bottom - i13), paint);
    }

    public final void l(Canvas canvas, Paint paint, float right, float bottom) {
        int i10 = this.f27596c;
        RectF rectF = new RectF(i10, i10, i10 + this.f27595b, bottom);
        int i11 = this.f27594a;
        canvas.drawRoundRect(rectF, i11, i11, paint);
        RectF rectF2 = new RectF(this.f27596c, bottom - this.f27595b, right, bottom);
        int i12 = this.f27594a;
        canvas.drawRoundRect(rectF2, i12, i12, paint);
        canvas.drawRect(new RectF(r1 + r2, this.f27596c, right, bottom - this.f27594a), paint);
    }

    public final void m(Canvas canvas, Paint paint, float right, float bottom) {
        RectF rectF = new RectF(right - this.f27595b, this.f27596c, right, bottom);
        int i10 = this.f27594a;
        canvas.drawRoundRect(rectF, i10, i10, paint);
        int i11 = this.f27596c;
        canvas.drawRect(new RectF(i11, i11, right - this.f27594a, bottom), paint);
    }

    public final void n(Canvas canvas, Paint paint, float width, float height) {
        int i10 = this.f27596c;
        float f10 = width - i10;
        float f11 = height - i10;
        switch (a.f27598a[this.f27597d.ordinal()]) {
            case 1:
                int i11 = this.f27596c;
                RectF rectF = new RectF(i11, i11, f10, f11);
                int i12 = this.f27594a;
                canvas.drawRoundRect(rectF, i12, i12, paint);
                break;
            case 2:
                o(canvas, paint, f10, f11);
                break;
            case 3:
                p(canvas, paint, f10, f11);
                break;
            case 4:
                c(canvas, paint, f10, f11);
                break;
            case 5:
                d(canvas, paint, f10, f11);
                break;
            case 6:
                q(canvas, paint, f10, f11);
                break;
            case 7:
                e(canvas, paint, f10, f11);
                break;
            case 8:
                h(canvas, paint, f10, f11);
                break;
            case 9:
                m(canvas, paint, f10, f11);
                break;
            case 10:
                k(canvas, paint, f10, f11);
                break;
            case 11:
                l(canvas, paint, f10, f11);
                break;
            case 12:
                i(canvas, paint, f10, f11);
                break;
            case 13:
                j(canvas, paint, f10, f11);
                break;
            case 14:
                f(canvas, paint, f10, f11);
                break;
            case 15:
                g(canvas, paint, f10, f11);
                break;
            default:
                int i13 = this.f27596c;
                RectF rectF2 = new RectF(i13, i13, f10, f11);
                int i14 = this.f27594a;
                canvas.drawRoundRect(rectF2, i14, i14, paint);
                break;
        }
    }

    public final void o(Canvas canvas, Paint paint, float right, float bottom) {
        int i10 = this.f27596c;
        int i11 = this.f27595b;
        RectF rectF = new RectF(i10, i10, i10 + i11, i10 + i11);
        int i12 = this.f27594a;
        canvas.drawRoundRect(rectF, i12, i12, paint);
        int i13 = this.f27596c;
        int i14 = this.f27594a;
        canvas.drawRect(new RectF(i13, i13 + i14, i13 + i14, bottom), paint);
        canvas.drawRect(new RectF(this.f27594a + r1, this.f27596c, right, bottom), paint);
    }

    public final void p(Canvas canvas, Paint paint, float right, float bottom) {
        int i10 = this.f27595b;
        RectF rectF = new RectF(right - i10, this.f27596c, right, r3 + i10);
        int i11 = this.f27594a;
        canvas.drawRoundRect(rectF, i11, i11, paint);
        int i12 = this.f27596c;
        canvas.drawRect(new RectF(i12, i12, right - this.f27594a, bottom), paint);
        canvas.drawRect(new RectF(right - this.f27594a, this.f27596c + r1, right, bottom), paint);
    }

    public final void q(Canvas canvas, Paint paint, float right, float bottom) {
        int i10 = this.f27596c;
        RectF rectF = new RectF(i10, i10, right, i10 + this.f27595b);
        int i11 = this.f27594a;
        canvas.drawRoundRect(rectF, i11, i11, paint);
        canvas.drawRect(new RectF(this.f27596c, r1 + this.f27594a, right, bottom), paint);
    }

    public String toString() {
        return "RoundedTransformation(radius=" + this.f27594a + ", margin=" + this.f27596c + ", diameter=" + this.f27595b + ", cornerType=" + this.f27597d.name() + ")";
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f27593f + this.f27594a + this.f27595b + this.f27596c + this.f27597d).getBytes(Key.CHARSET));
    }

    public RoundedCornersTransformation(int radius, int margin, CornerType cornerType) {
        this.f27594a = radius;
        this.f27595b = radius * 2;
        this.f27596c = margin;
        this.f27597d = cornerType;
    }
}
