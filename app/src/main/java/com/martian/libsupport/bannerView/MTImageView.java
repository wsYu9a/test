package com.martian.libsupport.bannerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Checkable;
import android.widget.ImageView;
import com.martian.libsupport.bannerView.f.b;
import java.util.Arrays;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class MTImageView extends ImageView implements Checkable, com.martian.libsupport.bannerView.f.a {

    /* renamed from: a */
    com.martian.libsupport.bannerView.f.b f10573a;

    public MTImageView(Context context) {
        this(context, null);
    }

    @Override // com.martian.libsupport.bannerView.f.a
    public boolean a() {
        return this.f10573a.f10584d;
    }

    @Override // com.martian.libsupport.bannerView.f.a
    public boolean b() {
        return this.f10573a.f10589i;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        if (action == 0 || action == 1) {
            refreshDrawableState();
        } else if (action == 3) {
            setPressed(false);
            refreshDrawableState();
        }
        if (this.f10573a.f10590j.contains((int) ev.getX(), (int) ev.getY())) {
            return super.dispatchTouchEvent(ev);
        }
        setPressed(false);
        refreshDrawableState();
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.f10573a.e(this);
        if (!this.f10573a.f10589i) {
            super.draw(canvas);
            return;
        }
        canvas.save();
        canvas.clipPath(this.f10573a.f10582b);
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f10573a.a(this);
    }

    @Override // com.martian.libsupport.bannerView.f.a
    public float getBottomLeftRadius() {
        return this.f10573a.f10581a[4];
    }

    @Override // com.martian.libsupport.bannerView.f.a
    public float getBottomRightRadius() {
        return this.f10573a.f10581a[6];
    }

    @Override // com.martian.libsupport.bannerView.f.a
    public int getStrokeColor() {
        return this.f10573a.f10586f;
    }

    @Override // com.martian.libsupport.bannerView.f.a
    public int getStrokeWidth() {
        return this.f10573a.f10588h;
    }

    @Override // com.martian.libsupport.bannerView.f.a
    public float getTopLeftRadius() {
        return this.f10573a.f10581a[0];
    }

    @Override // com.martian.libsupport.bannerView.f.a
    public float getTopRightRadius() {
        return this.f10573a.f10581a[2];
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f10573a.l;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.f10573a.k, null, 31);
        super.onDraw(canvas);
        this.f10573a.c(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h2, int oldw, int oldh) {
        super.onSizeChanged(w, h2, oldw, oldh);
        this.f10573a.d(this, w, h2);
    }

    @Override // com.martian.libsupport.bannerView.f.a
    public void setBottomLeftRadius(int bottomLeftRadius) {
        float[] fArr = this.f10573a.f10581a;
        float f2 = bottomLeftRadius;
        fArr[6] = f2;
        fArr[7] = f2;
        invalidate();
    }

    @Override // com.martian.libsupport.bannerView.f.a
    public void setBottomRightRadius(int bottomRightRadius) {
        float[] fArr = this.f10573a.f10581a;
        float f2 = bottomRightRadius;
        fArr[4] = f2;
        fArr[5] = f2;
        invalidate();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        com.martian.libsupport.bannerView.f.b bVar = this.f10573a;
        if (bVar.l != checked) {
            bVar.l = checked;
            refreshDrawableState();
            com.martian.libsupport.bannerView.f.b bVar2 = this.f10573a;
            b.a aVar = bVar2.m;
            if (aVar != null) {
                aVar.a(this, bVar2.l);
            }
        }
    }

    @Override // com.martian.libsupport.bannerView.f.a
    public void setClipBackground(boolean clipBackground) {
        this.f10573a.f10589i = clipBackground;
        invalidate();
    }

    public void setOnCheckedChangeListener(b.a listener) {
        this.f10573a.m = listener;
    }

    @Override // com.martian.libsupport.bannerView.f.a
    public void setRadius(int radius) {
        Arrays.fill(this.f10573a.f10581a, radius);
        invalidate();
    }

    @Override // com.martian.libsupport.bannerView.f.a
    public void setRoundAsCircle(boolean roundAsCircle) {
        this.f10573a.f10584d = roundAsCircle;
        invalidate();
    }

    @Override // com.martian.libsupport.bannerView.f.a
    public void setStrokeColor(int strokeColor) {
        this.f10573a.f10586f = strokeColor;
        invalidate();
    }

    @Override // com.martian.libsupport.bannerView.f.a
    public void setStrokeWidth(int strokeWidth) {
        this.f10573a.f10588h = strokeWidth;
        invalidate();
    }

    @Override // com.martian.libsupport.bannerView.f.a
    public void setTopLeftRadius(int topLeftRadius) {
        float[] fArr = this.f10573a.f10581a;
        float f2 = topLeftRadius;
        fArr[0] = f2;
        fArr[1] = f2;
        invalidate();
    }

    @Override // com.martian.libsupport.bannerView.f.a
    public void setTopRightRadius(int topRightRadius) {
        float[] fArr = this.f10573a.f10581a;
        float f2 = topRightRadius;
        fArr[2] = f2;
        fArr[3] = f2;
        invalidate();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f10573a.l);
    }

    public MTImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MTImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        com.martian.libsupport.bannerView.f.b bVar = new com.martian.libsupport.bannerView.f.b();
        this.f10573a = bVar;
        bVar.b(context, attrs);
    }
}
