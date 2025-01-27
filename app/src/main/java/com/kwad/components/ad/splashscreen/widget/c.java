package com.kwad.components.ad.splashscreen.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public final class c extends AnimationDrawable {
    private float FA;
    private int FB;
    private Bitmap Fd;
    private Bitmap Fe;
    private Bitmap Ff;
    private Bitmap Fg;
    private Bitmap Fh;
    private Bitmap Fi;
    private int Fj;
    private RectF Fk;
    private Paint Fl;
    private Paint Fm;
    private PorterDuffXfermode Fn;
    private final int Fo;
    private final int Fp;
    private float Fq;
    private float Fr;
    private RectF Fs;
    private Paint Ft;
    private int Fu;
    private int Fv;
    private ValueAnimator Fw;
    private final float Fx = 6.0f;
    private final float Fy = 11.0f;
    private float Fz;
    private Context mContext;

    /* renamed from: com.kwad.components.ad.splashscreen.widget.c$1 */
    final class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass1() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            c.this.Fz = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            c cVar = c.this;
            cVar.c(cVar.Fz);
            c.this.invalidateSelf();
        }
    }

    public c(Context context, int i2) {
        this.mContext = context;
        this.Fo = com.kwad.sdk.c.kwai.a.a(context, 51.0f);
        this.Fp = com.kwad.sdk.c.kwai.a.a(context, 61.0f);
        this.FB = i2;
        init();
    }

    public void c(float f2) {
        if (f2 <= 6.0f) {
            float f3 = f2 / 6.0f;
            int i2 = this.FB;
            if (i2 == 0) {
                RectF rectF = this.Fs;
                float f4 = this.Fv * (1.0f - f3);
                rectF.top = f4;
                this.Fk.offsetTo(rectF.left + this.Fr, f4 + this.Fq);
                this.FA = (f3 * 30.0f) + 290.0f;
                return;
            }
            if (i2 == 1) {
                RectF rectF2 = this.Fs;
                float f5 = 1.0f - f3;
                float f6 = this.Fu * f5;
                rectF2.left = f6;
                this.Fk.offsetTo(f6 + this.Fr, rectF2.top + this.Fq);
                this.FA = f5 * 30.0f;
                return;
            }
            if (i2 != 2) {
                return;
            }
            RectF rectF3 = this.Fs;
            float f7 = this.Fu * f3;
            rectF3.right = f7;
            this.Fk.offsetTo(f7 + this.Fr, rectF3.top + this.Fq);
            this.FA = (f3 * 30.0f) + 330.0f;
        }
    }

    private void init() {
        float f2;
        float f3;
        Matrix matrix;
        float f4;
        this.Fd = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand);
        this.Fe = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_lt);
        this.Ff = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_lb);
        this.Fg = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_rt);
        this.Fh = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_rb);
        Bitmap decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_side_bg);
        int i2 = this.FB;
        if (i2 != 0) {
            if (i2 == 1) {
                matrix = new Matrix();
                f4 = 270.0f;
            } else if (i2 == 2) {
                matrix = new Matrix();
                f4 = 90.0f;
            }
            matrix.postRotate(f4);
            this.Fi = Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, true);
        } else {
            this.Fi = decodeResource;
        }
        this.Fj = com.kwad.sdk.c.kwai.a.a(this.mContext, 10.0f);
        this.Ft = new Paint(1);
        int i3 = this.FB;
        if (i3 == 0) {
            this.Fv = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgh);
            int dimension = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgw);
            this.Fu = dimension;
            this.Fq = (-this.Fp) * 0.22f;
            f2 = dimension;
            f3 = 0.08f;
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    this.Fv = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgw);
                    this.Fu = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgh);
                    this.Fq = this.Fv * 0.09f;
                    f2 = -this.Fo;
                    f3 = 0.5f;
                }
                this.Fs = new RectF(0.0f, 0.0f, this.Fu, this.Fv);
                this.Fl = new Paint(3);
                Paint paint = new Paint(3);
                this.Fm = paint;
                paint.setDither(true);
                float f5 = this.Fs.right;
                this.Fk = new RectF(f5 - this.Fo, 0.0f, f5, this.Fp);
                this.Fn = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 6.0f, 11.0f);
                this.Fw = ofFloat;
                ofFloat.setDuration(1100L);
                this.Fw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.c.1
                    AnonymousClass1() {
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.Fz = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        c cVar = c.this;
                        cVar.c(cVar.Fz);
                        c.this.invalidateSelf();
                    }
                });
                this.Fw.setRepeatCount(-1);
            }
            this.Fv = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgw);
            this.Fu = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgh);
            this.Fq = this.Fv * 0.09f;
            f2 = -this.Fo;
            f3 = 0.2f;
        }
        this.Fr = f2 * f3;
        this.Fs = new RectF(0.0f, 0.0f, this.Fu, this.Fv);
        this.Fl = new Paint(3);
        Paint paint2 = new Paint(3);
        this.Fm = paint2;
        paint2.setDither(true);
        float f52 = this.Fs.right;
        this.Fk = new RectF(f52 - this.Fo, 0.0f, f52, this.Fp);
        this.Fn = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 6.0f, 11.0f);
        this.Fw = ofFloat2;
        ofFloat2.setDuration(1100L);
        this.Fw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.c.1
            AnonymousClass1() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.this.Fz = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                c cVar = c.this;
                cVar.c(cVar.Fz);
                c.this.invalidateSelf();
            }
        });
        this.Fw.setRepeatCount(-1);
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void draw(@NonNull Canvas canvas) {
        Bitmap bitmap;
        if (this.Fs == null) {
            return;
        }
        canvas.save();
        canvas.translate((getIntrinsicWidth() - this.Fu) / 2, (getIntrinsicHeight() - this.Fv) / 2);
        float f2 = this.Fz;
        if (f2 <= 6.0f) {
            this.Ft.setAlpha((int) ((f2 * 255.0f) / 6.0f));
            this.Fm.setAlpha(255);
        } else {
            int i2 = (int) ((1.0f - ((f2 - 6.0f) / 5.0f)) * 255.0f);
            this.Ft.setAlpha(i2);
            this.Fm.setAlpha(i2);
        }
        int save = canvas.save();
        int saveLayer = canvas.saveLayer(this.Fs, this.Ft, 31);
        canvas.drawBitmap(this.Fi, (Rect) null, this.Fs, this.Ft);
        canvas.rotate(this.FA, this.Fk.centerX(), this.Fk.centerY());
        this.Fl.setXfermode(this.Fn);
        int i3 = this.FB;
        if (i3 != 0) {
            if (i3 == 1) {
                canvas.drawBitmap(this.Fe, (Rect) null, this.Fk, this.Fl);
                bitmap = this.Ff;
            }
            canvas.drawBitmap(this.Fd, (Rect) null, this.Fk, this.Fl);
            canvas.restoreToCount(saveLayer);
            canvas.rotate(this.FA, this.Fk.centerX(), this.Fk.centerY());
            canvas.drawBitmap(this.Fd, (Rect) null, this.Fk, this.Fm);
            canvas.restoreToCount(save);
            canvas.restore();
        }
        canvas.drawBitmap(this.Fg, (Rect) null, this.Fk, this.Fl);
        bitmap = this.Fh;
        canvas.drawBitmap(bitmap, (Rect) null, this.Fk, this.Fl);
        canvas.drawBitmap(this.Fd, (Rect) null, this.Fk, this.Fl);
        canvas.restoreToCount(saveLayer);
        canvas.rotate(this.FA, this.Fk.centerX(), this.Fk.centerY());
        canvas.drawBitmap(this.Fd, (Rect) null, this.Fk, this.Fm);
        canvas.restoreToCount(save);
        canvas.restore();
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.Fv + this.Fp + this.Fj;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.Fu + this.Fo;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ValueAnimator valueAnimator = this.Fw;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final void start() {
        ValueAnimator valueAnimator = this.Fw;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final void stop() {
        ValueAnimator valueAnimator = this.Fw;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
