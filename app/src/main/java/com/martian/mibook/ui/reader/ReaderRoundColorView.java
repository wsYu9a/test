package com.martian.mibook.ui.reader;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.application.MiConfigSingleton;
import k9.a;

/* loaded from: classes3.dex */
public class ReaderRoundColorView extends View implements a {

    /* renamed from: b */
    public Paint f16020b;

    /* renamed from: c */
    public int f16021c;

    /* renamed from: d */
    public RectF f16022d;

    /* renamed from: e */
    public int f16023e;

    public ReaderRoundColorView(Context context) {
        super(context);
        a();
    }

    private void a() {
        if (isInEditMode()) {
            return;
        }
        this.f16021c = getContext().getResources().getColor(R.color.transparent);
        Paint paint = new Paint();
        this.f16020b = paint;
        paint.setColor(this.f16021c);
        this.f16020b.setAntiAlias(true);
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.martian.mibook.R.styleable.ReaderRoundColorView);
        this.f16023e = obtainStyledAttributes.getDimensionPixelSize(com.martian.mibook.R.styleable.ReaderRoundColorView_roundColorRadius, ConfigSingleton.i(17.0f));
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
        ConfigSingleton.D().h(this);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ConfigSingleton.D().X0(this);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f16022d == null) {
            this.f16022d = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        }
        RectF rectF = this.f16022d;
        int i10 = this.f16023e;
        canvas.drawRoundRect(rectF, i10, i10, this.f16020b);
    }

    @Override // k9.a
    public void p() {
        setRoundColor(MiConfigSingleton.b2().h2().k().getTextColorThirdly());
    }

    public void setRoundColor(int i10) {
        this.f16021c = i10;
        this.f16020b.reset();
        this.f16020b.setColor(i10);
        this.f16020b.setAntiAlias(true);
        invalidate();
    }

    public ReaderRoundColorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
        a();
    }

    public ReaderRoundColorView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b(context, attributeSet);
        a();
    }
}
