package com.vivo.advv.vaf.virtualview.view.text;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.vivo.advv.vaf.virtualview.Helper.VirtualViewUtils;
import com.vivo.advv.vaf.virtualview.core.IView;

/* loaded from: classes4.dex */
public class NativeTextImp extends TextView implements IView {
    private int mBackgroundColor;
    private int mBorderBottomLeftRadius;
    private int mBorderBottomRightRadius;
    private int mBorderColor;
    private int mBorderTopLeftRadius;
    private int mBorderTopRightRadius;
    private int mBorderWidth;

    public NativeTextImp(Context context) {
        super(context);
        this.mBackgroundColor = 0;
        this.mBorderTopLeftRadius = 0;
        this.mBorderTopRightRadius = 0;
        this.mBorderBottomLeftRadius = 0;
        this.mBorderBottomRightRadius = 0;
        this.mBorderWidth = 0;
        this.mBorderColor = -16777216;
        getPaint().setAntiAlias(true);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void comLayout(int i2, int i3, int i4, int i5) {
        layout(i2, i3, i4, i5);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredHeight() {
        return getMeasuredHeight();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredWidth() {
        return getMeasuredWidth();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void measureComponent(int i2, int i3) {
        measure(i2, i3);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
        onLayout(z, i2, i3, i4, i5);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComMeasure(int i2, int i3) {
        onMeasure(i2, i3);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i2 = this.mBackgroundColor;
        if (i2 != 0) {
            VirtualViewUtils.drawBackground(canvas, i2, canvas.getWidth(), canvas.getHeight(), this.mBorderWidth, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
        }
        super.onDraw(canvas);
        VirtualViewUtils.drawBorder(canvas, this.mBorderColor, canvas.getWidth(), canvas.getHeight(), this.mBorderWidth, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i2) {
        this.mBackgroundColor = i2;
    }

    public void setBorderBottomLeftRadius(int i2) {
        this.mBorderBottomLeftRadius = i2;
    }

    public void setBorderBottomRightRadius(int i2) {
        this.mBorderBottomRightRadius = i2;
    }

    public void setBorderColor(int i2) {
        this.mBorderColor = i2;
    }

    public void setBorderTopLeftRadius(int i2) {
        this.mBorderTopLeftRadius = i2;
    }

    public void setBorderTopRightRadius(int i2) {
        this.mBorderTopRightRadius = i2;
    }

    public void setBorderWidth(int i2) {
        this.mBorderWidth = i2;
    }
}
