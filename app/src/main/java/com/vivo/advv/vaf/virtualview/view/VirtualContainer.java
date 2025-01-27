package com.vivo.advv.vaf.virtualview.view;

import android.view.View;
import android.view.ViewGroup;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.framework.cm.ContainerService;
import com.vivo.advv.vaf.virtualview.core.IContainer;
import com.vivo.advv.vaf.virtualview.core.IView;
import com.vivo.advv.vaf.virtualview.core.Layout;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.event.EventData;
import com.vivo.advv.vaf.virtualview.util.ViewUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes4.dex */
public class VirtualContainer extends ViewBase {
    private static final String TAG = "VContainer_TMTEST";
    private int mOrder;
    private IView mRealVB;

    public static class Builder implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new VirtualContainer(vafContext, viewCache);
        }
    }

    public VirtualContainer(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        this.mOrder = -1;
    }

    protected void attachViews(ViewBase viewBase) {
        if (!(viewBase instanceof Layout)) {
            View nativeView = viewBase.getNativeView();
            if (nativeView != null) {
                ((ViewGroup) this.mViewCache.getHolderView()).addView(nativeView);
                return;
            }
            return;
        }
        List<ViewBase> subViews = ((Layout) viewBase).getSubViews();
        if (subViews != null) {
            int size = subViews.size();
            for (int i2 = 0; i2 < size; i2++) {
                attachViews(subViews.get(i2));
            }
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void comLayout(int i2, int i3, int i4, int i5) {
        super.comLayout(i2, i3, i4, i5);
        IView iView = this.mRealVB;
        if (iView != null) {
            iView.comLayout(i2, i3, i4, i5);
        }
    }

    protected void detachViews(ViewBase viewBase) {
        if (!(viewBase instanceof Layout)) {
            View nativeView = viewBase.getNativeView();
            if (nativeView != null) {
                ((ViewGroup) this.mViewCache.getHolderView()).removeView(nativeView);
                return;
            }
            return;
        }
        List<ViewBase> subViews = ((Layout) viewBase).getSubViews();
        if (subViews != null) {
            int size = subViews.size();
            for (int i2 = 0; i2 < size; i2++) {
                detachViews(subViews.get(i2));
            }
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredHeight() {
        IView iView = this.mRealVB;
        if (iView != null) {
            return iView.getComMeasuredHeight();
        }
        return 0;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredWidth() {
        IView iView = this.mRealVB;
        if (iView != null) {
            return iView.getComMeasuredWidth();
        }
        return 0;
    }

    public int getOrder() {
        return this.mOrder;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void measureComponent(int i2, int i3) {
        int scaleWidthMeasureSpec = ViewUtils.scaleWidthMeasureSpec(i2, this.mScaleFactor, this.mParams);
        int scaleHeightMeasureSpec = ViewUtils.scaleHeightMeasureSpec(i3, this.mScaleFactor, this.mParams);
        IView iView = this.mRealVB;
        if (iView != null) {
            iView.measureComponent(scaleWidthMeasureSpec, scaleHeightMeasureSpec);
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
        IView iView = this.mRealVB;
        if (iView != null) {
            iView.onComLayout(z, i2, i3, i4, i5);
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComMeasure(int i2, int i3) {
        int scaleWidthMeasureSpec = ViewUtils.scaleWidthMeasureSpec(i2, this.mScaleFactor, this.mParams);
        int scaleHeightMeasureSpec = ViewUtils.scaleHeightMeasureSpec(i3, this.mScaleFactor, this.mParams);
        IView iView = this.mRealVB;
        if (iView != null) {
            iView.onComMeasure(scaleWidthMeasureSpec, scaleHeightMeasureSpec);
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void reset() {
        super.reset();
        if (this.mRealVB != null) {
            this.mContext.getContainerService().recycle((IContainer) this.mRealVB);
            ((ViewGroup) this.mViewCache.getHolderView()).removeView((View) this.mRealVB);
            this.mRealVB = null;
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, int i3) {
        boolean attribute = super.setAttribute(i2, i3);
        if (attribute) {
            return attribute;
        }
        if (i2 != 106006350) {
            return false;
        }
        this.mOrder = i3;
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void setData(Object obj) {
        JSONObject optJSONObject;
        super.setData(obj);
        ContainerService containerService = this.mContext.getContainerService();
        IView iView = this.mRealVB;
        if (iView != null) {
            containerService.recycle((IContainer) iView);
            ((ViewGroup) this.mViewCache.getHolderView()).removeView((View) this.mRealVB);
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            if (this.mOrder >= jSONArray.length() || (optJSONObject = jSONArray.optJSONObject(this.mOrder)) == null) {
                return;
            }
            IView iView2 = (IView) containerService.getContainer(optJSONObject.optString("type"));
            this.mRealVB = iView2;
            if (iView2 != null) {
                ViewBase virtualView = ((IContainer) iView2).getVirtualView();
                virtualView.setVData(optJSONObject);
                ((ViewGroup) this.mViewCache.getHolderView()).addView((View) this.mRealVB);
                if (virtualView.supportExposure()) {
                    this.mContext.getEventManager().emitEvent(1, EventData.obtainData(this.mContext, virtualView));
                }
            }
        }
    }
}
