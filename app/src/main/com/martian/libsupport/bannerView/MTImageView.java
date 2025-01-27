package com.martian.libsupport.bannerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Checkable;
import android.widget.ImageView;
import da.a;
import da.b;
import java.util.Arrays;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class MTImageView extends ImageView implements Checkable, a {

    /* renamed from: b */
    public b f13008b;

    public MTImageView(Context context) {
        this(context, null);
    }

    @Override // da.a
    public boolean a() {
        return this.f13008b.f25409d;
    }

    @Override // da.a
    public boolean b() {
        return this.f13008b.f25414i;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0 || action == 1) {
            refreshDrawableState();
        } else if (action == 3) {
            setPressed(false);
            refreshDrawableState();
        }
        if (this.f13008b.f25415j.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.dispatchTouchEvent(motionEvent);
        }
        setPressed(false);
        refreshDrawableState();
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.f13008b.e(this);
        if (!this.f13008b.f25414i) {
            super.draw(canvas);
            return;
        }
        canvas.save();
        canvas.clipPath(this.f13008b.f25407b);
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f13008b.a(this);
    }

    @Override // da.a
    public float getBottomLeftRadius() {
        return this.f13008b.f25406a[4];
    }

    @Override // da.a
    public float getBottomRightRadius() {
        return this.f13008b.f25406a[6];
    }

    @Override // da.a
    public int getStrokeColor() {
        return this.f13008b.f25411f;
    }

    @Override // da.a
    public int getStrokeWidth() {
        return this.f13008b.f25413h;
    }

    @Override // da.a
    public float getTopLeftRadius() {
        return this.f13008b.f25406a[0];
    }

    @Override // da.a
    public float getTopRightRadius() {
        return this.f13008b.f25406a[2];
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f13008b.f25417l;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.saveLayer(this.f13008b.f25416k, null, 31);
        super.onDraw(canvas);
        this.f13008b.c(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f13008b.d(this, i10, i11);
    }

    @Override // da.a
    public void setBottomLeftRadius(int i10) {
        float[] fArr = this.f13008b.f25406a;
        float f10 = i10;
        fArr[6] = f10;
        fArr[7] = f10;
        invalidate();
    }

    @Override // da.a
    public void setBottomRightRadius(int i10) {
        float[] fArr = this.f13008b.f25406a;
        float f10 = i10;
        fArr[4] = f10;
        fArr[5] = f10;
        invalidate();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        b bVar = this.f13008b;
        if (bVar.f25417l != z10) {
            bVar.f25417l = z10;
            refreshDrawableState();
            b bVar2 = this.f13008b;
            b.a aVar = bVar2.f25418m;
            if (aVar != null) {
                aVar.a(this, bVar2.f25417l);
            }
        }
    }

    @Override // da.a
    public void setClipBackground(boolean z10) {
        this.f13008b.f25414i = z10;
        invalidate();
    }

    public void setOnCheckedChangeListener(b.a aVar) {
        this.f13008b.f25418m = aVar;
    }

    @Override // da.a
    public void setRadius(int i10) {
        Arrays.fill(this.f13008b.f25406a, i10);
        invalidate();
    }

    @Override // da.a
    public void setRoundAsCircle(boolean z10) {
        this.f13008b.f25409d = z10;
        invalidate();
    }

    @Override // da.a
    public void setStrokeColor(int i10) {
        this.f13008b.f25411f = i10;
        invalidate();
    }

    @Override // da.a
    public void setStrokeWidth(int i10) {
        this.f13008b.f25413h = i10;
        invalidate();
    }

    @Override // da.a
    public void setTopLeftRadius(int i10) {
        float[] fArr = this.f13008b.f25406a;
        float f10 = i10;
        fArr[0] = f10;
        fArr[1] = f10;
        invalidate();
    }

    @Override // da.a
    public void setTopRightRadius(int i10) {
        float[] fArr = this.f13008b.f25406a;
        float f10 = i10;
        fArr[2] = f10;
        fArr[3] = f10;
        invalidate();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f13008b.f25417l);
    }

    public MTImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MTImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b bVar = new b();
        this.f13008b = bVar;
        bVar.b(context, attributeSet);
    }
}
