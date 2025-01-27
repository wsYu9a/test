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
public final class d extends AnimationDrawable {
    private float IA;
    private RectF IB;
    private Paint IC;
    private int ID;
    private int IE;
    private ValueAnimator IF;
    private final float IG = 6.0f;
    private final float IH = 11.0f;
    private float II;
    private float IJ;
    private int IK;
    private Bitmap Im;
    private Bitmap In;
    private Bitmap Io;
    private Bitmap Ip;
    private Bitmap Iq;
    private Bitmap Ir;
    private int Is;
    private RectF It;
    private Paint Iu;
    private Paint Iv;
    private PorterDuffXfermode Iw;
    private final int Ix;
    private final int Iy;
    private float Iz;
    private Context mContext;

    /* renamed from: com.kwad.components.ad.splashscreen.widget.d$1 */
    public class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass1() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.this.II = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            d dVar = d.this;
            dVar.e(dVar.II);
            d.this.invalidateSelf();
        }
    }

    public d(Context context, int i10) {
        this.mContext = context;
        this.Ix = com.kwad.sdk.c.a.a.a(context, 51.0f);
        this.Iy = com.kwad.sdk.c.a.a.a(context, 61.0f);
        this.IK = i10;
        init();
    }

    public void e(float f10) {
        if (f10 <= 6.0f) {
            float f11 = f10 / 6.0f;
            int i10 = this.IK;
            if (i10 == 0) {
                RectF rectF = this.IB;
                float f12 = this.IE * (1.0f - f11);
                rectF.top = f12;
                this.It.offsetTo(rectF.left + this.IA, f12 + this.Iz);
                this.IJ = (f11 * 30.0f) + 290.0f;
                return;
            }
            if (i10 == 1) {
                RectF rectF2 = this.IB;
                float f13 = 1.0f - f11;
                float f14 = this.ID * f13;
                rectF2.left = f14;
                this.It.offsetTo(f14 + this.IA, rectF2.top + this.Iz);
                this.IJ = f13 * 30.0f;
                return;
            }
            if (i10 != 2) {
                return;
            }
            RectF rectF3 = this.IB;
            float f15 = this.ID * f11;
            rectF3.right = f15;
            this.It.offsetTo(f15 + this.IA, rectF3.top + this.Iz);
            this.IJ = (f11 * 30.0f) + 330.0f;
        }
    }

    private void init() {
        this.Im = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand);
        this.In = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_lt);
        this.Io = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_lb);
        this.Ip = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_rt);
        this.Iq = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_rb);
        Bitmap decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_side_bg);
        int i10 = this.IK;
        if (i10 == 0) {
            this.Ir = decodeResource;
        } else if (i10 == 1) {
            Matrix matrix = new Matrix();
            matrix.postRotate(270.0f);
            this.Ir = Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, true);
        } else if (i10 == 2) {
            Matrix matrix2 = new Matrix();
            matrix2.postRotate(90.0f);
            this.Ir = Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix2, true);
        }
        this.Is = com.kwad.sdk.c.a.a.a(this.mContext, 10.0f);
        this.IC = new Paint(1);
        int i11 = this.IK;
        if (i11 == 0) {
            this.IE = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgh);
            int dimension = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgw);
            this.ID = dimension;
            this.Iz = (-this.Iy) * 0.22f;
            this.IA = dimension * 0.08f;
        } else if (i11 == 1) {
            this.IE = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgw);
            this.ID = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgh);
            this.Iz = this.IE * 0.09f;
            this.IA = (-this.Ix) * 0.2f;
        } else if (i11 == 2) {
            this.IE = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgw);
            this.ID = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgh);
            this.Iz = this.IE * 0.09f;
            this.IA = (-this.Ix) * 0.5f;
        }
        this.IB = new RectF(0.0f, 0.0f, this.ID, this.IE);
        this.Iu = new Paint(3);
        Paint paint = new Paint(3);
        this.Iv = paint;
        paint.setDither(true);
        float f10 = this.IB.right;
        this.It = new RectF(f10 - this.Ix, 0.0f, f10, this.Iy);
        this.Iw = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 6.0f, 11.0f);
        this.IF = ofFloat;
        ofFloat.setDuration(1100L);
        this.IF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.d.1
            public AnonymousClass1() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.II = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                d dVar = d.this;
                dVar.e(dVar.II);
                d.this.invalidateSelf();
            }
        });
        this.IF.setRepeatCount(-1);
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void draw(@NonNull Canvas canvas) {
        if (this.IB == null) {
            return;
        }
        canvas.save();
        canvas.translate((getIntrinsicWidth() - this.ID) / 2, (getIntrinsicHeight() - this.IE) / 2);
        float f10 = this.II;
        if (f10 <= 6.0f) {
            this.IC.setAlpha((int) ((f10 * 255.0f) / 6.0f));
            this.Iv.setAlpha(255);
        } else {
            int i10 = (int) ((1.0f - ((f10 - 6.0f) / 5.0f)) * 255.0f);
            this.IC.setAlpha(i10);
            this.Iv.setAlpha(i10);
        }
        int save = canvas.save();
        int saveLayer = canvas.saveLayer(this.IB, this.IC, 31);
        try {
            canvas.drawBitmap(this.Ir, (Rect) null, this.IB, this.IC);
        } catch (Throwable unused) {
        }
        canvas.rotate(this.IJ, this.It.centerX(), this.It.centerY());
        this.Iu.setXfermode(this.Iw);
        int i11 = this.IK;
        if (i11 == 0) {
            canvas.drawBitmap(this.Ip, (Rect) null, this.It, this.Iu);
            canvas.drawBitmap(this.Iq, (Rect) null, this.It, this.Iu);
        } else if (i11 == 1) {
            canvas.drawBitmap(this.In, (Rect) null, this.It, this.Iu);
            canvas.drawBitmap(this.Io, (Rect) null, this.It, this.Iu);
        }
        canvas.drawBitmap(this.Im, (Rect) null, this.It, this.Iu);
        canvas.restoreToCount(saveLayer);
        canvas.rotate(this.IJ, this.It.centerX(), this.It.centerY());
        canvas.drawBitmap(this.Im, (Rect) null, this.It, this.Iv);
        canvas.restoreToCount(save);
        canvas.restore();
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.IE + this.Iy + this.Is;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.ID + this.Ix;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ValueAnimator valueAnimator = this.IF;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final void start() {
        ValueAnimator valueAnimator = this.IF;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final void stop() {
        ValueAnimator valueAnimator = this.IF;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
