package com.vivo.advv.vaf.virtualview.view.nlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import com.vivo.advv.vaf.virtualview.Helper.VirtualViewUtils;
import com.vivo.advv.vaf.virtualview.container.ClickHelper;
import com.vivo.advv.vaf.virtualview.container.IActionListener;
import com.vivo.advv.vaf.virtualview.core.IContainer;
import com.vivo.advv.vaf.virtualview.core.Layout;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import java.util.List;

/* loaded from: classes4.dex */
public class NativeLayoutImpl extends ViewGroup implements IContainer, INativeLayoutImpl {
    private static final String TAG = "NativeLayoutImpl_TMTEST";
    protected ViewBase mView;

    public NativeLayoutImpl(Context context) {
        super(context);
    }

    private void onViewBaseLayout(boolean z, int i2, int i3, int i4, int i5) {
        ViewBase viewBase = this.mView;
        if (viewBase == null || !(viewBase instanceof INativeLayout) || viewBase.isGone()) {
            return;
        }
        ((INativeLayout) this.mView).onLayoutLayout(z, i2, i3, i4, i5);
    }

    private void onViewBaseMeasure(int i2, int i3) {
        ViewBase viewBase = this.mView;
        if (viewBase == null || !(viewBase instanceof INativeLayout)) {
            return;
        }
        if (!viewBase.isGone()) {
            ((INativeLayout) this.mView).onLayoutMeasure(i2, i3);
        }
        setMeasuredDimension(this.mView.getComMeasuredWidth(), this.mView.getComMeasuredHeight());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.vivo.advv.vaf.virtualview.view.nlayout.INativeLayoutImpl
    public void attachViews(ViewBase viewBase, View view) {
        List<ViewBase> subViews;
        viewBase.setDisplayViewContainer(view);
        if (!(viewBase instanceof Layout)) {
            View nativeView = viewBase.getNativeView();
            if (nativeView != null) {
                if (nativeView.getParent() == null) {
                    addView(nativeView, new ViewGroup.LayoutParams(viewBase.getComLayoutParams().mLayoutWidth, viewBase.getComLayoutParams().mLayoutHeight));
                    return;
                }
                ViewGroup.LayoutParams layoutParams = nativeView.getLayoutParams();
                layoutParams.width = viewBase.getComLayoutParams().mLayoutWidth;
                layoutParams.height = viewBase.getComLayoutParams().mLayoutHeight;
                nativeView.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        View nativeView2 = viewBase.getNativeView();
        int i2 = 0;
        if (nativeView2 == 0 || nativeView2 == this) {
            viewBase.setDisplayViewContainer(view);
            List<ViewBase> subViews2 = ((Layout) viewBase).getSubViews();
            if (subViews2 != null) {
                int size = subViews2.size();
                while (i2 < size) {
                    attachViews(subViews2.get(i2), view);
                    i2++;
                }
                return;
            }
            return;
        }
        if (nativeView2.getParent() == null) {
            addView(nativeView2, new ViewGroup.LayoutParams(viewBase.getComLayoutParams().mLayoutWidth, viewBase.getComLayoutParams().mLayoutHeight));
        } else {
            ViewGroup.LayoutParams layoutParams2 = nativeView2.getLayoutParams();
            layoutParams2.width = viewBase.getComLayoutParams().mLayoutWidth;
            layoutParams2.height = viewBase.getComLayoutParams().mLayoutHeight;
            nativeView2.setLayoutParams(layoutParams2);
        }
        if (!(nativeView2 instanceof INativeLayoutImpl) || (subViews = ((Layout) viewBase).getSubViews()) == null) {
            return;
        }
        int size2 = subViews.size();
        while (i2 < size2) {
            ((INativeLayoutImpl) nativeView2).attachViews(subViews.get(i2), nativeView2);
            i2++;
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public void destroy() {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        ViewBase viewBase = this.mView;
        if (viewBase != null) {
            VirtualViewUtils.clipCanvas(this, canvas, viewBase.getComMeasuredWidth(), this.mView.getComMeasuredHeight(), this.mView.getBorderWidth(), this.mView.getBorderTopLeftRadius(), this.mView.getBorderTopRightRadius(), this.mView.getBorderBottomLeftRadius(), this.mView.getBorderBottomRightRadius());
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.mView != null) {
            VirtualViewUtils.clipCanvas(this, canvas, getMeasuredWidth(), getMeasuredHeight(), this.mView.getBorderWidth(), this.mView.getBorderTopLeftRadius(), this.mView.getBorderTopRightRadius(), this.mView.getBorderBottomLeftRadius(), this.mView.getBorderBottomRightRadius());
        }
        super.draw(canvas);
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
        return this.mView;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        ViewBase viewBase = this.mView;
        if (viewBase != null && viewBase.getBackground() != 0) {
            VirtualViewUtils.drawBackground(canvas, this.mView.getBackground(), this.mView.getComMeasuredWidth(), this.mView.getComMeasuredHeight(), this.mView.getBorderWidth(), this.mView.getBorderTopLeftRadius(), this.mView.getBorderTopRightRadius(), this.mView.getBorderBottomLeftRadius(), this.mView.getBorderBottomRightRadius());
        }
        super.onDraw(canvas);
        ViewBase viewBase2 = this.mView;
        if (viewBase2 == null || !viewBase2.shouldDraw()) {
            return;
        }
        Object obj = this.mView;
        if (obj instanceof INativeLayout) {
            ((INativeLayout) obj).layoutDraw(canvas);
            this.mView.drawBorder(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        onViewBaseLayout(z, 0, 0, i4 - i2, i5 - i3);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        onViewBaseMeasure(i2, i3);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public void setVirtualView(ViewBase viewBase, IActionListener iActionListener) {
        if (viewBase != null) {
            this.mView = viewBase;
            viewBase.setHoldView(this);
            if (this.mView.shouldDraw()) {
                setWillNotDraw(false);
            }
            new ClickHelper(this, iActionListener);
        }
    }

    public void setVirtualViewOnly(ViewBase viewBase) {
        if (viewBase != null) {
            this.mView = viewBase;
            viewBase.setHoldView(this);
            if (this.mView.shouldDraw()) {
                setWillNotDraw(false);
            }
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public void attachViews() {
        attachViews(this.mView, this);
    }
}
