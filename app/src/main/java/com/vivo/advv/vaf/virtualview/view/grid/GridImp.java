package com.vivo.advv.vaf.virtualview.view.grid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.vivo.advv.vaf.virtualview.container.ClickHelper;
import com.vivo.advv.vaf.virtualview.container.IActionListener;
import com.vivo.advv.vaf.virtualview.core.IContainer;
import com.vivo.advv.vaf.virtualview.core.IView;
import com.vivo.advv.vaf.virtualview.core.ViewBase;

/* loaded from: classes4.dex */
public class GridImp extends GridView implements IView, IContainer {
    private static final String TAG = "GridImp_TMTEST";
    protected int mBGColor;
    protected Paint mBackgroundPaint;
    protected ViewBase mVirtualView;

    public GridImp(Context context) {
        super(context);
        this.mBGColor = 0;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public void attachViews() {
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void comLayout(int i2, int i3, int i4, int i5) {
        layout(i2, i3, i4, i5);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public void destroy() {
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredHeight() {
        return getMeasuredHeight();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredWidth() {
        return getMeasuredWidth();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public View getHolderView() {
        return this;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public int getType() {
        return -1;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public ViewBase getVirtualView() {
        return this.mVirtualView;
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

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mBGColor != 0) {
            int borderWidth = this.mVirtualView.getBorderWidth();
            if (this.mBackgroundPaint == null) {
                Paint paint = new Paint();
                this.mBackgroundPaint = paint;
                paint.setColor(this.mBGColor);
            }
            float f2 = borderWidth;
            canvas.drawRect(f2, f2, this.mVirtualView.getComMeasuredWidth() - borderWidth, this.mVirtualView.getComMeasuredHeight() - borderWidth, this.mBackgroundPaint);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        this.mBGColor = i2;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public void setVirtualView(ViewBase viewBase, IActionListener iActionListener) {
        if (viewBase != null) {
            this.mVirtualView = viewBase;
            viewBase.setHoldView(this);
            if (this.mVirtualView.shouldDraw()) {
                setWillNotDraw(false);
            }
            new ClickHelper(this, iActionListener);
        }
    }
}
