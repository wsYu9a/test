package com.vivo.advv.vaf.virtualview.core;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.vivo.advv.Utils;
import com.vivo.advv.expr.common.ExprCode;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.ViewFactory;
import com.vivo.advv.vaf.virtualview.container.IActionListener;
import com.vivo.advv.virtualview.common.StringBase;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class Layout extends ViewBase {
    private static final String TAG = "Layout_TMTEST";
    protected List<ViewBase> mSubViews;

    public Layout(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        this.mSubViews = new ArrayList();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
    
        if (r7 == (-2)) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
    
        if (r7 == (-2)) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        if (r7 == (-2)) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getChildMeasureSpec(int r5, int r6, int r7) {
        /*
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            int r5 = r5 - r6
            r6 = 0
            int r5 = java.lang.Math.max(r6, r5)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -2
            r3 = -1
            r4 = 1073741824(0x40000000, float:2.0)
            if (r0 == r1) goto L2f
            if (r0 == 0) goto L26
            if (r0 == r4) goto L1b
            goto L3d
        L1b:
            if (r7 < 0) goto L1e
            goto L31
        L1e:
            if (r7 != r3) goto L23
            r6 = 1073741824(0x40000000, float:2.0)
            goto L3b
        L23:
            if (r7 != r2) goto L3d
            goto L39
        L26:
            if (r7 < 0) goto L29
            goto L31
        L29:
            if (r7 != r3) goto L2c
            goto L2e
        L2c:
            if (r7 != r2) goto L3d
        L2e:
            goto L3b
        L2f:
            if (r7 < 0) goto L34
        L31:
            r6 = 1073741824(0x40000000, float:2.0)
            goto L3e
        L34:
            if (r7 != r3) goto L37
            goto L39
        L37:
            if (r7 != r2) goto L3d
        L39:
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
        L3b:
            r7 = r5
            goto L3e
        L3d:
            r7 = 0
        L3e:
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.advv.vaf.virtualview.core.Layout.getChildMeasureSpec(int, int, int):int");
    }

    public void addView(ViewBase viewBase) {
        this.mSubViews.add(viewBase);
        viewBase.mParent = this;
        viewBase.changeVisibility();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean changeVisibility() {
        boolean changeVisibility = super.changeVisibility();
        int size = this.mSubViews.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mSubViews.get(i2).changeVisibility();
        }
        return changeVisibility;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public boolean click(int i2, int i3, boolean z, IContainer iContainer, IActionListener iActionListener) {
        boolean z2 = false;
        for (int size = this.mSubViews.size() - 1; size >= 0; size--) {
            ViewBase viewBase = this.mSubViews.get(size);
            int absoluteDrawLeft = viewBase.getAbsoluteDrawLeft();
            int absoluteDrawTop = viewBase.getAbsoluteDrawTop();
            int comMeasuredWidth = viewBase.getComMeasuredWidth();
            int comMeasuredHeight = viewBase.getComMeasuredHeight();
            if (i2 >= absoluteDrawLeft && i2 < absoluteDrawLeft + comMeasuredWidth && i3 >= absoluteDrawTop && i3 <= absoluteDrawTop + comMeasuredHeight && (z2 = viewBase.click(i2, i3, z, iContainer, iActionListener))) {
                break;
            }
        }
        return !z2 ? super.click(i2, i3, z, iContainer, iActionListener) : z2;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void comDraw(Canvas canvas) {
        super.comDraw(canvas);
        int size = this.mSubViews.size();
        for (int i2 = 0; i2 < size; i2++) {
            ViewBase viewBase = this.mSubViews.get(i2);
            if (viewBase.shouldDraw()) {
                viewBase.comDraw(canvas);
            }
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void destroy() {
        super.destroy();
        int size = this.mSubViews.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mSubViews.get(i2).destroy();
        }
        this.mSubViews.clear();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public ViewBase findViewBaseById(int i2) {
        ViewBase findViewBaseById = super.findViewBaseById(i2);
        if (findViewBaseById == null) {
            int size = this.mSubViews.size();
            for (int i3 = 0; i3 < size; i3++) {
                findViewBaseById = this.mSubViews.get(i3).findViewBaseById(i2);
                if (findViewBaseById != null) {
                    break;
                }
            }
        }
        return findViewBaseById;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public ViewBase findViewBaseByName(String str) {
        ViewBase findViewBaseByName = super.findViewBaseByName(str);
        if (findViewBaseByName == null) {
            int size = this.mSubViews.size();
            for (int i2 = 0; i2 < size; i2++) {
                findViewBaseByName = this.mSubViews.get(i2).findViewBaseByName(str);
                if (findViewBaseByName != null) {
                    break;
                }
            }
        }
        return findViewBaseByName;
    }

    public Params generateParams(ViewFactory viewFactory) {
        return new Params(viewFactory);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public ViewBase getChild(int i2) {
        if (i2 < 0 || i2 >= this.mSubViews.size()) {
            return null;
        }
        return this.mSubViews.get(i2);
    }

    public final List<ViewBase> getSubViews() {
        return this.mSubViews;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public boolean handleEvent(int i2, int i3) {
        boolean z = false;
        for (int size = this.mSubViews.size() - 1; size >= 0; size--) {
            ViewBase viewBase = this.mSubViews.get(size);
            int absoluteDrawLeft = viewBase.getAbsoluteDrawLeft();
            int absoluteDrawTop = viewBase.getAbsoluteDrawTop();
            int comMeasuredWidth = viewBase.getComMeasuredWidth();
            int comMeasuredHeight = viewBase.getComMeasuredHeight();
            if (i2 >= absoluteDrawLeft && i2 < absoluteDrawLeft + comMeasuredWidth && i3 >= absoluteDrawTop && i3 <= absoluteDrawTop + comMeasuredHeight && (z = viewBase.handleEvent(i2, i3))) {
                break;
            }
        }
        return !z ? super.handleEvent(i2, i3) : z;
    }

    protected void measureComChild(ViewBase viewBase, int i2, int i3) {
        Params comLayoutParams = viewBase.getComLayoutParams();
        viewBase.measureComponent(getChildMeasureSpec(i2, (int) ((this.mPaddingLeft + this.mPaddingRight + (this.mBorderWidth << 1) + comLayoutParams.mLayoutMarginLeft + comLayoutParams.mLayoutMarginRight) * this.mScaleFactor), comLayoutParams.mLayoutWidth), getChildMeasureSpec(i3, (int) ((this.mPaddingTop + this.mPaddingBottom + (this.mBorderWidth << 1) + comLayoutParams.mLayoutMarginTop + comLayoutParams.mLayoutMarginBottom) * this.mScaleFactor), comLayoutParams.mLayoutHeight));
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected void onComDraw(Canvas canvas) {
        super.onComDraw(canvas);
        drawBorder(canvas);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void onParseValueFinished(float f2) {
        super.onParseValueFinished(f2);
        if (this.mPaint == null) {
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setStyle(Paint.Style.FILL);
            this.mPaint.setAntiAlias(true);
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void ready() {
        super.ready();
        int size = this.mSubViews.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mSubViews.get(i2).ready();
        }
    }

    public boolean removeView(ViewBase viewBase) {
        if (!this.mSubViews.contains(viewBase)) {
            return false;
        }
        this.mSubViews.remove(viewBase);
        viewBase.mParent = null;
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void reset() {
        super.reset();
        int size = this.mSubViews.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mSubViews.get(i2).reset();
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, float f2) {
        boolean attribute = super.setAttribute(i2, f2);
        if (attribute) {
            return attribute;
        }
        return false;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setRPAttribute(int i2, float f2) {
        boolean rPAttribute = super.setRPAttribute(i2, f2);
        if (rPAttribute) {
            return rPAttribute;
        }
        return false;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, int i3) {
        boolean attribute = super.setAttribute(i2, i3);
        if (attribute) {
            return attribute;
        }
        return false;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setRPAttribute(int i2, int i3) {
        boolean rPAttribute = super.setRPAttribute(i2, i3);
        if (rPAttribute) {
            return rPAttribute;
        }
        return false;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, String str) {
        boolean attribute = super.setAttribute(i2, str);
        if (attribute) {
            return attribute;
        }
        return false;
    }

    public static class Params {
        protected boolean isLayoutMarginBottomSet;
        protected boolean isLayoutMarginLeftSet;
        protected boolean isLayoutMarginRightSet;
        protected boolean isLayoutMarginTopSet;
        public int mLayoutMargin;
        private ViewFactory mViewFactory;
        public int mLayoutWidth = 0;
        public int mLayoutHeight = 0;
        public int mLayoutMarginLeft = 0;
        public int mLayoutMarginRight = 0;
        public int mLayoutMarginTop = 0;
        public int mLayoutMarginBottom = 0;

        public Params(ViewFactory viewFactory) {
            this.mViewFactory = viewFactory;
        }

        public int rp2px(double d2) {
            ViewFactory viewFactory = this.mViewFactory;
            return viewFactory != null ? viewFactory.rp2px(d2) : (int) d2;
        }

        public boolean setAttribute(int i2, float f2) {
            switch (i2) {
                case StringBase.STR_ID_layoutMarginTop /* -2037919555 */:
                    this.mLayoutMarginTop = Utils.dp2px(f2);
                    this.isLayoutMarginTopSet = true;
                    break;
                case StringBase.STR_ID_layoutMarginRight /* 62363524 */:
                    this.mLayoutMarginRight = Utils.dp2px(f2);
                    this.isLayoutMarginRightSet = true;
                    break;
                case StringBase.STR_ID_layoutMarginLeft /* 1248755103 */:
                    this.mLayoutMarginLeft = Utils.dp2px(f2);
                    this.isLayoutMarginLeftSet = true;
                    break;
                case StringBase.STR_ID_layoutMarginBottom /* 1481142723 */:
                    this.mLayoutMarginBottom = Utils.dp2px(f2);
                    this.isLayoutMarginBottomSet = true;
                    break;
                case StringBase.STR_ID_layoutHeight /* 1557524721 */:
                    if (f2 <= 0.0f) {
                        this.mLayoutHeight = (int) f2;
                        break;
                    } else {
                        this.mLayoutHeight = Utils.dp2px(f2);
                        break;
                    }
                case StringBase.STR_ID_layoutMargin /* 1697244536 */:
                    int dp2px = Utils.dp2px(f2);
                    this.mLayoutMargin = dp2px;
                    if (!this.isLayoutMarginLeftSet) {
                        this.mLayoutMarginLeft = dp2px;
                    }
                    if (!this.isLayoutMarginRightSet) {
                        this.mLayoutMarginRight = dp2px;
                    }
                    if (!this.isLayoutMarginTopSet) {
                        this.mLayoutMarginTop = dp2px;
                    }
                    if (!this.isLayoutMarginBottomSet) {
                        this.mLayoutMarginBottom = dp2px;
                        break;
                    }
                    break;
                case StringBase.STR_ID_layoutWidth /* 2003872956 */:
                    if (f2 <= 0.0f) {
                        this.mLayoutWidth = (int) f2;
                        break;
                    } else {
                        this.mLayoutWidth = Utils.dp2px(f2);
                        break;
                    }
            }
            return true;
        }

        public boolean setAttribute(int i2, ExprCode exprCode) {
            return false;
        }

        public boolean setPXAttribute(int i2, int i3) {
            switch (i2) {
                case StringBase.STR_ID_layoutMarginTop /* -2037919555 */:
                    this.mLayoutMarginTop = i3;
                    this.isLayoutMarginTopSet = true;
                    break;
                case StringBase.STR_ID_layoutMarginRight /* 62363524 */:
                    this.mLayoutMarginRight = i3;
                    this.isLayoutMarginRightSet = true;
                    break;
                case StringBase.STR_ID_layoutMarginLeft /* 1248755103 */:
                    this.mLayoutMarginLeft = i3;
                    this.isLayoutMarginLeftSet = true;
                    break;
                case StringBase.STR_ID_layoutMarginBottom /* 1481142723 */:
                    this.mLayoutMarginBottom = i3;
                    this.isLayoutMarginBottomSet = true;
                    break;
                case StringBase.STR_ID_layoutHeight /* 1557524721 */:
                    this.mLayoutHeight = i3;
                    break;
                case StringBase.STR_ID_layoutMargin /* 1697244536 */:
                    this.mLayoutMargin = i3;
                    if (!this.isLayoutMarginLeftSet) {
                        this.mLayoutMarginLeft = i3;
                    }
                    if (!this.isLayoutMarginRightSet) {
                        this.mLayoutMarginRight = i3;
                    }
                    if (!this.isLayoutMarginTopSet) {
                        this.mLayoutMarginTop = i3;
                    }
                    if (!this.isLayoutMarginBottomSet) {
                        this.mLayoutMarginBottom = i3;
                        break;
                    }
                    break;
                case StringBase.STR_ID_layoutWidth /* 2003872956 */:
                    this.mLayoutWidth = i3;
                    break;
            }
            return true;
        }

        public boolean setRPAttribute(int i2, float f2) {
            switch (i2) {
                case StringBase.STR_ID_layoutMarginTop /* -2037919555 */:
                    this.mLayoutMarginTop = rp2px(f2);
                    this.isLayoutMarginTopSet = true;
                    break;
                case StringBase.STR_ID_layoutMarginRight /* 62363524 */:
                    this.mLayoutMarginRight = rp2px(f2);
                    this.isLayoutMarginRightSet = true;
                    break;
                case StringBase.STR_ID_layoutMarginLeft /* 1248755103 */:
                    this.mLayoutMarginLeft = rp2px(f2);
                    this.isLayoutMarginLeftSet = true;
                    break;
                case StringBase.STR_ID_layoutMarginBottom /* 1481142723 */:
                    this.mLayoutMarginBottom = rp2px(f2);
                    this.isLayoutMarginBottomSet = true;
                    break;
                case StringBase.STR_ID_layoutHeight /* 1557524721 */:
                    this.mLayoutHeight = rp2px(f2);
                    break;
                case StringBase.STR_ID_layoutMargin /* 1697244536 */:
                    int rp2px = rp2px(f2);
                    this.mLayoutMargin = rp2px;
                    if (!this.isLayoutMarginLeftSet) {
                        this.mLayoutMarginLeft = rp2px;
                    }
                    if (!this.isLayoutMarginRightSet) {
                        this.mLayoutMarginRight = rp2px;
                    }
                    if (!this.isLayoutMarginTopSet) {
                        this.mLayoutMarginTop = rp2px;
                    }
                    if (!this.isLayoutMarginBottomSet) {
                        this.mLayoutMarginBottom = rp2px;
                        break;
                    }
                    break;
                case StringBase.STR_ID_layoutWidth /* 2003872956 */:
                    this.mLayoutWidth = rp2px(f2);
                    break;
            }
            return true;
        }

        public boolean setStrAttribute(int i2, int i3) {
            return false;
        }

        public boolean setRPAttribute(int i2, int i3) {
            switch (i2) {
                case StringBase.STR_ID_layoutMarginTop /* -2037919555 */:
                    this.mLayoutMarginTop = rp2px(i3);
                    this.isLayoutMarginTopSet = true;
                    break;
                case StringBase.STR_ID_layoutMarginRight /* 62363524 */:
                    this.mLayoutMarginRight = rp2px(i3);
                    this.isLayoutMarginRightSet = true;
                    break;
                case StringBase.STR_ID_layoutMarginLeft /* 1248755103 */:
                    this.mLayoutMarginLeft = rp2px(i3);
                    this.isLayoutMarginLeftSet = true;
                    break;
                case StringBase.STR_ID_layoutMarginBottom /* 1481142723 */:
                    this.mLayoutMarginBottom = rp2px(i3);
                    this.isLayoutMarginBottomSet = true;
                    break;
                case StringBase.STR_ID_layoutHeight /* 1557524721 */:
                    this.mLayoutHeight = rp2px(i3);
                    break;
                case StringBase.STR_ID_layoutMargin /* 1697244536 */:
                    int rp2px = rp2px(i3);
                    this.mLayoutMargin = rp2px;
                    if (!this.isLayoutMarginLeftSet) {
                        this.mLayoutMarginLeft = rp2px;
                    }
                    if (!this.isLayoutMarginRightSet) {
                        this.mLayoutMarginRight = rp2px;
                    }
                    if (!this.isLayoutMarginTopSet) {
                        this.mLayoutMarginTop = rp2px;
                    }
                    if (!this.isLayoutMarginBottomSet) {
                        this.mLayoutMarginBottom = rp2px;
                        break;
                    }
                    break;
                case StringBase.STR_ID_layoutWidth /* 2003872956 */:
                    this.mLayoutWidth = rp2px(i3);
                    break;
            }
            return true;
        }

        public boolean setAttribute(int i2, int i3) {
            switch (i2) {
                case StringBase.STR_ID_layoutMarginTop /* -2037919555 */:
                    this.mLayoutMarginTop = Utils.dp2px(i3);
                    this.isLayoutMarginTopSet = true;
                    break;
                case StringBase.STR_ID_layoutMarginRight /* 62363524 */:
                    this.mLayoutMarginRight = Utils.dp2px(i3);
                    this.isLayoutMarginRightSet = true;
                    break;
                case StringBase.STR_ID_layoutMarginLeft /* 1248755103 */:
                    this.mLayoutMarginLeft = Utils.dp2px(i3);
                    this.isLayoutMarginLeftSet = true;
                    break;
                case StringBase.STR_ID_layoutMarginBottom /* 1481142723 */:
                    this.mLayoutMarginBottom = Utils.dp2px(i3);
                    this.isLayoutMarginBottomSet = true;
                    break;
                case StringBase.STR_ID_layoutHeight /* 1557524721 */:
                    if (i3 > 0) {
                        this.mLayoutHeight = Utils.dp2px(i3);
                        break;
                    } else {
                        this.mLayoutHeight = i3;
                        break;
                    }
                case StringBase.STR_ID_layoutMargin /* 1697244536 */:
                    int dp2px = Utils.dp2px(i3);
                    this.mLayoutMargin = dp2px;
                    if (!this.isLayoutMarginLeftSet) {
                        this.mLayoutMarginLeft = dp2px;
                    }
                    if (!this.isLayoutMarginRightSet) {
                        this.mLayoutMarginRight = dp2px;
                    }
                    if (!this.isLayoutMarginTopSet) {
                        this.mLayoutMarginTop = dp2px;
                    }
                    if (!this.isLayoutMarginBottomSet) {
                        this.mLayoutMarginBottom = dp2px;
                        break;
                    }
                    break;
                case StringBase.STR_ID_layoutWidth /* 2003872956 */:
                    if (i3 > 0) {
                        this.mLayoutWidth = Utils.dp2px(i3);
                        break;
                    } else {
                        this.mLayoutWidth = i3;
                        break;
                    }
            }
            return true;
        }
    }
}
