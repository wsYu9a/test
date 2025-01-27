package com.vivo.advv.vaf.virtualview.view.page;

import androidx.annotation.Keep;
import com.vivo.advv.expr.common.ExprCode;
import com.vivo.advv.vaf.expr.engine.ExprEngine;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.core.IBean;
import com.vivo.advv.vaf.virtualview.core.NativeViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.event.EventData;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import com.vivo.advv.vaf.virtualview.view.page.PageView;
import com.vivo.advv.virtualview.common.StringBase;

/* loaded from: classes4.dex */
public class Page extends NativeViewBase implements PageView.Listener {
    private static final String TAG = "Page_TMTEST";
    protected int mCurPos;
    protected PageImp mNative;
    protected ExprCode mPageFlipCode;
    protected int mPrePos;
    protected int mTotal;

    public static class Builder implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new Page(vafContext, viewCache);
        }
    }

    public Page(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        this.mCurPos = 0;
        this.mPrePos = 0;
        PageImp pageImp = new PageImp(vafContext);
        this.mNative = pageImp;
        this.__mNative = pageImp;
        pageImp.setListener(this);
    }

    private void callBean() {
        IBean bean = getBean();
        if (bean != null) {
            bean.doEvent(3, 0, null);
        }
    }

    public void callPageFlip() {
        this.mContext.getEventManager().emitEvent(3, new EventData(this.mContext, this));
        if (this.mPageFlipCode != null) {
            ExprEngine exprEngine = this.mContext.getExprEngine();
            if (exprEngine != null) {
                try {
                    exprEngine.getEngineContext().getDataManager().replaceData(getViewCache().getComponentData());
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (exprEngine == null || !exprEngine.execute(this, this.mPageFlipCode)) {
                VVLog.e(TAG, "callPageFlip execute failed");
            }
        }
    }

    public int getChildCount() {
        return this.mNative.size();
    }

    public int getCurPos() {
        return this.mCurPos;
    }

    public int getPrePos() {
        return this.mPrePos;
    }

    public int getTotal() {
        return this.mTotal;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public boolean isContainer() {
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.view.page.PageView.Listener
    public void onPageFlip(int i2, int i3) {
        this.mPrePos = this.mCurPos;
        this.mCurPos = i2 - 1;
        this.mTotal = i3;
        callBean();
        callPageFlip();
    }

    @Keep
    public void onScroll(int i2) {
        VVLog.d(TAG, "page scroll " + i2);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.NativeViewBase, com.vivo.advv.vaf.virtualview.core.ViewBase
    public void reset() {
        super.reset();
        this.mNative.reset();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, ExprCode exprCode) {
        boolean attribute = super.setAttribute(i2, exprCode);
        if (attribute) {
            return attribute;
        }
        if (i2 != -665970021) {
            return false;
        }
        this.mPageFlipCode = exprCode;
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void setData(Object obj) {
        this.mNative.setData(obj);
        super.setData(obj);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, int i3) {
        boolean attribute = super.setAttribute(i2, i3);
        if (attribute) {
            return attribute;
        }
        switch (i2) {
            case StringBase.STR_ID_orientation /* -1439500848 */:
                this.mNative.setOrientation(1 == i3);
                return true;
            case StringBase.STR_ID_animatorStyle /* -1171801334 */:
                this.mNative.setAnimationStyle(i3);
                return true;
            case StringBase.STR_ID_autoSwitch /* -380157501 */:
                this.mNative.setAutoSwitch(i3 > 0);
                return true;
            case StringBase.STR_ID_canSlide /* -137744447 */:
                this.mNative.setSlide(i3 > 0);
                return true;
            case StringBase.STR_ID_autoSwitchTime /* 78802736 */:
                this.mNative.setAutoSwitchTimeInterval(i3);
                return true;
            case StringBase.STR_ID_containerID /* 207632732 */:
                this.mNative.setContainerId(i3);
                return true;
            case StringBase.STR_ID_stayTime /* 1322318022 */:
                this.mNative.setStayTime(i3);
                return true;
            case StringBase.STR_ID_animatorTime /* 1347692116 */:
                this.mNative.setAnimatorTimeInterval(i3);
                return true;
            case StringBase.STR_ID_layoutOrientation /* 1942742086 */:
                this.mNative.setLayoutOrientation(i3 == 0);
                return true;
            default:
                return false;
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, String str) {
        boolean attribute = super.setAttribute(i2, str);
        if (attribute) {
            return attribute;
        }
        switch (i2) {
            case StringBase.STR_ID_autoSwitch /* -380157501 */:
                this.mViewCache.put(this, StringBase.STR_ID_autoSwitch, str, 4);
                return true;
            case StringBase.STR_ID_canSlide /* -137744447 */:
                this.mViewCache.put(this, StringBase.STR_ID_canSlide, str, 4);
                return true;
            case StringBase.STR_ID_autoSwitchTime /* 78802736 */:
                this.mViewCache.put(this, StringBase.STR_ID_autoSwitchTime, str, 0);
                return true;
            case StringBase.STR_ID_stayTime /* 1322318022 */:
                this.mViewCache.put(this, StringBase.STR_ID_stayTime, str, 0);
                return true;
            case StringBase.STR_ID_animatorTime /* 1347692116 */:
                this.mViewCache.put(this, StringBase.STR_ID_animatorTime, str, 0);
                return true;
            default:
                return false;
        }
    }
}
