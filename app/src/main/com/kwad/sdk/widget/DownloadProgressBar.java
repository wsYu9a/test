package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public class DownloadProgressBar extends View {
    Paint aWY;
    Paint aWZ;
    Paint aXa;
    private String aXb;
    private float aXc;
    private Rect aXd;
    private LinearGradient aXe;
    private LinearGradient aXf;
    private LinearGradient aXg;
    private Runnable aXh;
    private Matrix mMatrix;
    private Path mPath;
    private RectF mRectF;
    private long mStartTime;

    /* renamed from: com.kwad.sdk.widget.DownloadProgressBar$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            DownloadProgressBar.this.invalidate();
            if (DownloadProgressBar.this.getWindowVisibility() == 0) {
                DownloadProgressBar.this.postDelayed(this, 34L);
            }
        }
    }

    public DownloadProgressBar(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.aXh);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.clipPath(this.mPath);
        this.aWY.setShader(this.aXe);
        canvas.drawRect(this.mRectF, this.aWY);
        this.aWY.setShader(this.aXf);
        canvas.drawRect(0.0f, 0.0f, (getWidth() * this.aXc) / 100.0f, getHeight(), this.aWY);
        float f10 = this.aXc;
        float f11 = 0.0f;
        if (f10 > 0.0f && f10 < 100.0f) {
            long elapsedRealtime = (SystemClock.elapsedRealtime() - this.mStartTime) % 2500;
            float f12 = elapsedRealtime >= qe.a.f30009d ? 0.0f : elapsedRealtime / 1500.0f;
            this.mMatrix.reset();
            this.mMatrix.setScale(1.0f, f12);
            this.aXg.setLocalMatrix(this.mMatrix);
            this.aWZ.setShader(this.aXg);
            canvas.drawRect(0.0f, 0.0f, ((getWidth() * this.aXc) / 100.0f) * f12, getHeight(), this.aWZ);
            if (elapsedRealtime > 500 && elapsedRealtime <= qe.a.f30009d) {
                f11 = (elapsedRealtime - 500) / 1000.0f;
            }
            float width = ((getWidth() * this.aXc) / 100.0f) * f11;
            this.mMatrix.reset();
            this.mMatrix.setScale(1.0f, f12);
            this.aXg.setLocalMatrix(this.mMatrix);
            this.aWZ.setShader(this.aXg);
            canvas.drawRect(0.0f, 0.0f, width, getHeight(), this.aWZ);
        }
        String str = this.aXb;
        if (str != null) {
            this.aXa.getTextBounds(str, 0, str.length(), this.aXd);
            Rect rect = this.aXd;
            canvas.drawText(this.aXb, getWidth() / 2.0f, (getHeight() / 2.0f) - ((rect.top + rect.bottom) / 2.0f), this.aXa);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.aXe = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{1291525714, 1291569420}, new float[]{0.0f, 1.0f}, tileMode);
        this.aXf = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{-319918, -276212}, new float[]{0.0f, 1.0f}, tileMode);
        this.aWY.setShader(this.aXe);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{16501004, -276212}, new float[]{0.0f, 1.0f}, tileMode);
        this.aXg = linearGradient;
        this.aWZ.setShader(linearGradient);
        float f10 = i10;
        this.mRectF.set(0.0f, 0.0f, f10, i11);
        this.mPath.reset();
        float f11 = f10 / 2.0f;
        this.mPath.addRoundRect(this.mRectF, f11, f11, Path.Direction.CW);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i10) {
        super.onVisibilityChanged(view, i10);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        if (i10 != 0) {
            removeCallbacks(this.aXh);
            return;
        }
        float f10 = this.aXc;
        if (f10 <= 0.0f || f10 >= 100.0f) {
            return;
        }
        this.mStartTime = SystemClock.elapsedRealtime();
        post(this.aXh);
    }

    public void setProgress(float f10) {
        this.aXc = f10;
        invalidate();
        if (f10 == 0.0f || f10 == 100.0f) {
            removeCallbacks(this.aXh);
        } else if (getWindowVisibility() == 0 && this.mStartTime == 0) {
            post(this.aXh);
        }
    }

    public void setText(String str) {
        this.aXb = str;
        invalidate();
    }

    public DownloadProgressBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressBar(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.aXh = new Runnable() { // from class: com.kwad.sdk.widget.DownloadProgressBar.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                DownloadProgressBar.this.invalidate();
                if (DownloadProgressBar.this.getWindowVisibility() == 0) {
                    DownloadProgressBar.this.postDelayed(this, 34L);
                }
            }
        };
        this.aWY = new Paint(1);
        this.aWZ = new Paint(1);
        this.mRectF = new RectF();
        Paint paint = new Paint(1);
        this.aXa = paint;
        paint.setTextSize(com.kwad.sdk.c.a.a.a(context, 16.0f));
        this.aXa.setColor(-1);
        this.aXa.setTextAlign(Paint.Align.CENTER);
        this.aXd = new Rect();
        this.mMatrix = new Matrix();
        this.mPath = new Path();
    }
}
