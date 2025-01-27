package com.vivo.advv.vaf.virtualview.view.scroller;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.vivo.advv.Utils;
import com.vivo.advv.expr.common.ExprCode;
import com.vivo.advv.vaf.expr.engine.ExprEngine;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.core.Layout;
import com.vivo.advv.vaf.virtualview.core.NativeViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.event.EventData;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import com.vivo.advv.virtualview.common.StringBase;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class Scroller extends NativeViewBase {
    private static final String TAG = "Scroller_TMTEST";
    protected ExprCode mAutoRefreshCode;
    protected int mAutoRefreshThreshold;
    protected int mFirstSpace;
    protected int mLastSpace;
    protected int mLineSpace;
    protected int mMode;
    protected ScrollerImp mNative;
    protected int mOrientation;
    protected int mSpan;
    protected boolean mSupportSticky;

    public static class Builder implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new Scroller(vafContext, viewCache);
        }
    }

    public static class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        private int mFirstSpace;
        private int mLastSpace;
        private Scroller mScroller;
        private int mSpace;

        public SpaceItemDecoration(Scroller scroller, int i2, int i3, int i4) {
            this.mScroller = scroller;
            this.mSpace = i2;
            this.mFirstSpace = i3;
            this.mLastSpace = i4;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (this.mFirstSpace != 0 && recyclerView.getChildPosition(view) == 0) {
                if (this.mScroller.getOrientation() == 0) {
                    rect.left = this.mFirstSpace;
                } else {
                    rect.top = this.mFirstSpace;
                }
            }
            if (this.mLastSpace != 0) {
                View nativeView = this.mScroller.getNativeView();
                if ((nativeView instanceof ScrollerStickyParent ? (ScrollerImp) ((ScrollerStickyParent) nativeView).getChildAt(0) : (ScrollerImp) this.mScroller.getNativeView()).getAdapter() == null || r5.getItemCount() - 1 != recyclerView.getChildPosition(view)) {
                    return;
                }
                if (this.mScroller.getOrientation() == 0) {
                    rect.right = this.mLastSpace;
                } else {
                    rect.bottom = this.mLastSpace;
                }
            }
        }

        public void setSpace(int i2, int i3, int i4) {
            this.mSpace = i2;
            this.mFirstSpace = i3;
            this.mLastSpace = i4;
        }
    }

    public Scroller(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        this.mSpan = 0;
        this.mAutoRefreshThreshold = 5;
        this.mLineSpace = 0;
        this.mFirstSpace = 0;
        this.mLastSpace = 0;
        this.mSupportSticky = false;
        this.mMode = 1;
        this.mOrientation = 1;
        ScrollerImp scrollerImp = new ScrollerImp(vafContext, this);
        this.mNative = scrollerImp;
        this.__mNative = scrollerImp;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void appendData(Object obj) {
        super.appendData(obj);
        if (obj instanceof JSONObject) {
            obj = ((JSONObject) obj).opt(this.mDataTag);
        }
        this.mNative.appendData(obj);
    }

    public void callAutoRefresh() {
        if (this.mAutoRefreshCode != null) {
            ExprEngine exprEngine = this.mContext.getExprEngine();
            if (exprEngine != null) {
                exprEngine.getEngineContext().getDataManager().replaceData(getViewCache().getComponentData());
            }
            if (exprEngine == null || !exprEngine.execute(this, this.mAutoRefreshCode)) {
                VVLog.e(TAG, "callAutoRefresh execute failed");
            }
        }
        this.mContext.getEventManager().emitEvent(2, EventData.obtainData(this.mContext, this));
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void destroy() {
        super.destroy();
        this.mNative.destroy();
        this.mNative = null;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public boolean isContainer() {
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.NativeViewBase, com.vivo.advv.vaf.virtualview.core.ViewBase
    public void onParseValueFinished(float f2) {
        super.onParseValueFinished(f2);
        int i2 = this.mLineSpace;
        if (i2 != 0 || this.mFirstSpace != 0 || this.mLastSpace != 0) {
            this.mNative.addItemDecoration(new SpaceItemDecoration(this, i2, this.mFirstSpace, this.mLastSpace));
        }
        this.mNative.setModeOrientation(this.mMode, this.mOrientation);
        this.mNative.setSupportSticky(this.mSupportSticky);
        if (!this.mSupportSticky) {
            this.__mNative = this.mNative;
        } else if (this.mNative.getParent() == null) {
            ScrollerStickyParent scrollerStickyParent = new ScrollerStickyParent(this.mContext.forViewConstruction());
            ScrollerImp scrollerImp = this.mNative;
            Layout.Params params = this.mParams;
            scrollerStickyParent.addView(scrollerImp, params.mLayoutWidth, params.mLayoutHeight);
            this.__mNative = scrollerStickyParent;
        }
        this.mNative.setBackgroundColor(this.mBackground);
        this.mNative.setAutoRefreshThreshold(this.mAutoRefreshThreshold);
        this.mNative.setSpan(this.mSpan);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, ExprCode exprCode) {
        boolean attribute = super.setAttribute(i2, exprCode);
        if (attribute) {
            return attribute;
        }
        if (i2 != 173466317) {
            return false;
        }
        this.mAutoRefreshCode = exprCode;
        return true;
    }

    public void setAutoRefreshThreshold(int i2) {
        this.mNative.setAutoRefreshThreshold(i2);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void setData(Object obj) {
        super.setData(obj);
        if (obj instanceof JSONObject) {
            obj = ((JSONObject) obj).optJSONArray(this.mDataTag);
        }
        this.mNative.setData(obj);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setRPAttribute(int i2, float f2) {
        boolean rPAttribute = super.setRPAttribute(i2, f2);
        if (rPAttribute) {
            return rPAttribute;
        }
        if (i2 == -1807275662) {
            this.mLineSpace = rp2px(f2);
            return true;
        }
        if (i2 == -172008394) {
            this.mFirstSpace = rp2px(f2);
            return true;
        }
        if (i2 == 3536714) {
            this.mSpan = rp2px(f2);
            return true;
        }
        if (i2 != 2002099216) {
            return false;
        }
        this.mLastSpace = rp2px(f2);
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, float f2) {
        boolean attribute = super.setAttribute(i2, f2);
        if (attribute) {
            return attribute;
        }
        if (i2 == -1807275662) {
            this.mLineSpace = Utils.dp2px(f2);
            return true;
        }
        if (i2 == -172008394) {
            this.mFirstSpace = Utils.dp2px(f2);
            return true;
        }
        if (i2 == 3536714) {
            this.mSpan = Utils.dp2px(f2);
            return true;
        }
        if (i2 != 2002099216) {
            return false;
        }
        this.mLastSpace = Utils.dp2px(f2);
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setRPAttribute(int i2, int i3) {
        boolean rPAttribute = super.setRPAttribute(i2, i3);
        if (rPAttribute) {
            return rPAttribute;
        }
        if (i2 == -1807275662) {
            this.mLineSpace = rp2px(i3);
            return true;
        }
        if (i2 == -172008394) {
            this.mFirstSpace = rp2px(i3);
            return true;
        }
        if (i2 == 3536714) {
            this.mSpan = rp2px(i3);
            return true;
        }
        if (i2 != 2002099216) {
            return false;
        }
        this.mLastSpace = rp2px(i3);
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, int i3) {
        boolean attribute = super.setAttribute(i2, i3);
        if (attribute) {
            return attribute;
        }
        switch (i2) {
            case StringBase.STR_ID_lineSpace /* -1807275662 */:
                this.mLineSpace = Utils.dp2px(i3);
                return true;
            case StringBase.STR_ID_orientation /* -1439500848 */:
                if (i3 == 1) {
                    this.mOrientation = 0;
                } else if (i3 == 0) {
                    this.mOrientation = 1;
                }
                return true;
            case StringBase.STR_ID_supportSticky /* -977844584 */:
                this.mSupportSticky = i3 > 0;
                return true;
            case StringBase.STR_ID_firstSpace /* -172008394 */:
                this.mFirstSpace = Utils.dp2px(i3);
                return true;
            case StringBase.STR_ID_autoRefreshThreshold /* -51356769 */:
                this.mAutoRefreshThreshold = i3;
                return true;
            case StringBase.STR_ID_mode /* 3357091 */:
                this.mMode = i3;
                return true;
            case StringBase.STR_ID_span /* 3536714 */:
                this.mSpan = Utils.dp2px(i3);
                return true;
            case StringBase.STR_ID_lastSpace /* 2002099216 */:
                this.mLastSpace = Utils.dp2px(i3);
                return true;
            default:
                return false;
        }
    }
}
