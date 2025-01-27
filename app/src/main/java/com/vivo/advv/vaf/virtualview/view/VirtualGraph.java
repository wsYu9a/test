package com.vivo.advv.vaf.virtualview.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.vivo.advv.Utils;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.core.VirtualViewBase;
import com.vivo.advv.virtualview.common.StringBase;

/* loaded from: classes4.dex */
public class VirtualGraph extends VirtualViewBase {
    private static final String TAG = "VirtualGraph_TMTEST";
    protected int mColor;
    protected int mDiameterX;
    protected int mDiameterY;
    protected RectF mOvalRect;
    protected int mType;

    public static class Builder implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new VirtualGraph(vafContext, viewCache);
        }
    }

    public VirtualGraph(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        this.mType = 1;
        this.mImp.setAntiAlias(true);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected void makeContentRect() {
        Rect rect = this.mContentRect;
        if (rect == null) {
            float f2 = this.mDiameterX;
            float f3 = this.mScaleFactor;
            this.mContentRect = new Rect(0, 0, (int) (f2 * f3), (int) (this.mDiameterY * f3));
        } else {
            float f4 = this.mDiameterX;
            float f5 = this.mScaleFactor;
            rect.set(0, 0, (int) (f4 * f5), (int) (this.mDiameterY * f5));
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected void onComDraw(Canvas canvas) {
        super.onComDraw(canvas);
        float f2 = this.mPaddingLeft;
        float f3 = this.mScaleFactor;
        float f4 = f2 * f3;
        int i2 = (int) f4;
        int i3 = this.mDiameterX;
        float f5 = i3 * f3;
        int i4 = (int) f5;
        int i5 = this.mDiameterY;
        int i6 = (int) (i5 * f3);
        if (i3 > 0) {
            int i7 = this.mGravity;
            if ((i7 & 2) != 0) {
                i2 = (int) ((this.mMeasuredWidth - (this.mPaddingRight * f3)) - f5);
            } else if ((i7 & 4) != 0) {
                i2 = (this.mMeasuredWidth - i4) >> 1;
            }
        } else {
            i4 = (int) ((this.mMeasuredWidth - f4) - (this.mPaddingRight * f3));
        }
        float f6 = this.mPaddingTop * f3;
        int i8 = (int) f6;
        if (i5 > 0) {
            int i9 = this.mGravity;
            if ((i9 & 16) != 0) {
                i8 = (int) ((this.mMeasuredHeight - (this.mPaddingBottom * f3)) - (i5 * f3));
            } else if ((i9 & 32) != 0) {
                i8 = (this.mMeasuredHeight - ((int) (i5 * f3))) >> 1;
            }
        } else {
            i6 = (int) ((this.mMeasuredHeight - f6) - (this.mPaddingBottom * f3));
        }
        int i10 = this.mType;
        if (i10 == 1) {
            canvas.drawCircle(i2 + r0, i8 + r0, i4 >> 1, this.mPaint);
        } else if (i10 == 2) {
            canvas.drawRect(i2, i8, i2 + i4, i8 + i6, this.mPaint);
        } else {
            if (i10 != 3) {
                return;
            }
            if (this.mOvalRect == null) {
                this.mOvalRect = new RectF();
            }
            this.mOvalRect.set(i2, i8, i2 + i4, i8 + i6);
            canvas.drawOval(this.mOvalRect, this.mPaint);
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void onParseValueFinished(float f2) {
        super.onParseValueFinished(f2);
        if (1 == this.mType) {
            this.mDiameterY = this.mDiameterX;
        }
        this.mPaint.setColor(this.mColor);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, float f2) {
        boolean attribute = super.setAttribute(i2, f2);
        if (attribute) {
            return attribute;
        }
        if (i2 == 793104392) {
            this.mPaint.setStrokeWidth(Utils.dp2px(f2));
            return true;
        }
        if (i2 == 1360592235) {
            this.mDiameterX = Utils.dp2px(f2);
            return true;
        }
        if (i2 != 1360592236) {
            return false;
        }
        this.mDiameterY = Utils.dp2px(f2);
        return true;
    }

    public void setColor(int i2) {
        setColor(i2, 1);
    }

    public void setDiameterX(int i2) {
        setDiameterX(i2, 1);
    }

    public void setDiameterY(int i2) {
        setDiameterY(i2, 1);
    }

    public void setType(int i2) {
        setType(i2, 1);
    }

    public void setColor(int i2, int i3) {
        this.mColor = i2;
        this.mPaint.setColor(i2);
        if (i3 > 0) {
            refresh();
        }
    }

    public void setDiameterX(int i2, int i3) {
        this.mDiameterX = i2;
        if (1 == i2) {
            this.mDiameterY = i2;
        }
        if (i3 > 0) {
            refresh();
        }
    }

    public void setDiameterY(int i2, int i3) {
        this.mDiameterY = i2;
        if (i3 > 0) {
            refresh();
        }
    }

    public void setType(int i2, int i3) {
        this.mType = i2;
        if (i3 > 0) {
            refresh();
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, int i3) {
        boolean attribute = super.setAttribute(i2, i3);
        if (attribute) {
            return attribute;
        }
        switch (i2) {
            case StringBase.STR_ID_type /* 3575610 */:
                this.mType = i3;
                return true;
            case StringBase.STR_ID_color /* 94842723 */:
                this.mColor = i3;
                return true;
            case StringBase.STR_ID_paintStyle /* 789757939 */:
                if (i3 == 1) {
                    this.mPaint.setStyle(Paint.Style.STROKE);
                } else if (i3 == 2) {
                    this.mPaint.setStyle(Paint.Style.FILL);
                }
                return true;
            case StringBase.STR_ID_paintWidth /* 793104392 */:
                this.mPaint.setStrokeWidth(Utils.dp2px(i3));
                return true;
            case StringBase.STR_ID_diameterX /* 1360592235 */:
                this.mDiameterX = Utils.dp2px(i3);
                return true;
            case StringBase.STR_ID_diameterY /* 1360592236 */:
                this.mDiameterY = Utils.dp2px(i3);
                return true;
            default:
                return false;
        }
    }
}
