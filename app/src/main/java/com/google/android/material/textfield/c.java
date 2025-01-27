package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.j.j;
import com.google.android.material.j.o;

/* loaded from: classes.dex */
class c extends j {

    @NonNull
    private final Paint D;

    @NonNull
    private final RectF E;
    private int F;

    c() {
        this(null);
    }

    private void P0(@NonNull Canvas canvas) {
        if (W0(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.F);
    }

    private void Q0(@NonNull Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (!W0(callback)) {
            S0(canvas);
            return;
        }
        View view = (View) callback;
        if (view.getLayerType() != 2) {
            view.setLayerType(2, null);
        }
    }

    private void S0(@NonNull Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.F = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        } else {
            this.F = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
        }
    }

    private void V0() {
        this.D.setStyle(Paint.Style.FILL_AND_STROKE);
        this.D.setColor(-1);
        this.D.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private boolean W0(Drawable.Callback callback) {
        return callback instanceof View;
    }

    boolean O0() {
        return !this.E.isEmpty();
    }

    void R0() {
        T0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    void T0(float f2, float f3, float f4, float f5) {
        RectF rectF = this.E;
        if (f2 == rectF.left && f3 == rectF.top && f4 == rectF.right && f5 == rectF.bottom) {
            return;
        }
        rectF.set(f2, f3, f4, f5);
        invalidateSelf();
    }

    void U0(@NonNull RectF rectF) {
        T0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // com.google.android.material.j.j, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Q0(canvas);
        super.draw(canvas);
        canvas.drawRect(this.E, this.D);
        P0(canvas);
    }

    c(@Nullable o oVar) {
        super(oVar == null ? new o() : oVar);
        this.D = new Paint(1);
        V0();
        this.E = new RectF();
    }
}
