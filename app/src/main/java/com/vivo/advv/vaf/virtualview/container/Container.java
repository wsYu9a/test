package com.vivo.advv.vaf.virtualview.container;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import com.vivo.advv.vaf.virtualview.core.IContainer;
import com.vivo.advv.vaf.virtualview.core.IView;
import com.vivo.advv.vaf.virtualview.core.Layout;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.view.nlayout.INativeLayoutImpl;
import java.util.List;

/* loaded from: classes4.dex */
public class Container extends ViewGroup implements IContainer, IView {
    private static final String TAG = "Container_TMTEST";
    protected ViewBase mView;

    public Container(Context context) {
        super(context);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public void attachViews() {
        attachViews(this.mView, this);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void comLayout(int i2, int i3, int i4, int i5) {
        ViewBase viewBase = this.mView;
        if (viewBase == null || viewBase.isGone()) {
            return;
        }
        this.mView.comLayout(0, 0, i4 - i2, i5 - i3);
        layout(i2, i3, i4, i5);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public void destroy() {
        this.mView.destroy();
        this.mView = null;
    }

    public void detachViews() {
        removeAllViews();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredHeight() {
        ViewBase viewBase = this.mView;
        if (viewBase != null) {
            return viewBase.getComMeasuredHeight();
        }
        return 0;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredWidth() {
        ViewBase viewBase = this.mView;
        if (viewBase != null) {
            return viewBase.getComMeasuredWidth();
        }
        return 0;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public View getHolderView() {
        return this;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public int getType() {
        return 0;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public ViewBase getVirtualView() {
        return this.mView;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void measureComponent(int i2, int i3) {
        ViewBase viewBase = this.mView;
        if (viewBase != null) {
            if (!viewBase.isGone()) {
                this.mView.measureComponent(i2, i3);
            }
            setMeasuredDimension(this.mView.getComMeasuredWidth(), this.mView.getComMeasuredHeight());
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
        ViewBase viewBase = this.mView;
        if (viewBase == null || viewBase.isGone()) {
            return;
        }
        this.mView.onComLayout(z, i2, i3, i4, i5);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComMeasure(int i2, int i3) {
        ViewBase viewBase = this.mView;
        if (viewBase != null) {
            if (!viewBase.isGone()) {
                this.mView.onComMeasure(i2, i3);
            }
            setMeasuredDimension(this.mView.getComMeasuredWidth(), this.mView.getComMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        ViewBase viewBase = this.mView;
        if (viewBase == null || !viewBase.shouldDraw()) {
            return;
        }
        this.mView.comDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        onComLayout(z, 0, 0, i4 - i2, i5 - i3);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        onComMeasure(i2, i3);
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

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachViews(ViewBase viewBase, View view) {
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
        if (nativeView2 == 0) {
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
}
