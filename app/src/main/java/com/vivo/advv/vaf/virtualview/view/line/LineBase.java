package com.vivo.advv.vaf.virtualview.view.line;

import com.vivo.advv.Utils;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import com.vivo.advv.virtualview.common.StringBase;

/* loaded from: classes4.dex */
public abstract class LineBase extends ViewBase {
    private static final String TAG = "LineBase_TMTEST";
    protected float[] mDashEffect;
    protected boolean mIsHorizontal;
    protected int mLineColor;
    protected int mLineWidth;
    protected int mStyle;

    public LineBase(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        this.mDashEffect = new float[]{3.0f, 5.0f, 3.0f, 5.0f};
        this.mLineColor = -16777216;
        this.mLineWidth = 1;
        this.mIsHorizontal = true;
        this.mStyle = 1;
    }

    public int getColor() {
        return this.mLineColor;
    }

    public int getPaintWidth() {
        return this.mLineWidth;
    }

    public int getStyle() {
        return this.mStyle;
    }

    public boolean horizontal() {
        return this.mIsHorizontal;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, float f2) {
        if (i2 != 793104392) {
            return false;
        }
        int dp2px = Utils.dp2px(f2);
        this.mLineWidth = dp2px;
        if (dp2px > 0) {
            return true;
        }
        this.mLineWidth = 1;
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setPXAttribute(int i2, int i3) {
        boolean pXAttribute = super.setPXAttribute(i2, i3);
        if (pXAttribute) {
            return pXAttribute;
        }
        if (i2 != 793104392) {
            return false;
        }
        this.mLineWidth = i3;
        if (i3 <= 0) {
            this.mLineWidth = 1;
        }
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setRPAttribute(int i2, int i3) {
        boolean rPAttribute = super.setRPAttribute(i2, i3);
        if (rPAttribute) {
            return rPAttribute;
        }
        if (i2 != 793104392) {
            return false;
        }
        int rp2px = rp2px(i3);
        this.mLineWidth = rp2px;
        if (rp2px <= 0) {
            this.mLineWidth = 1;
        }
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, String str) {
        boolean attribute = super.setAttribute(i2, str);
        int i3 = 0;
        if (attribute) {
            return attribute;
        }
        if (i2 == 94842723) {
            this.mViewCache.put(this, StringBase.STR_ID_color, str, 3);
        } else {
            if (i2 != 1037639619) {
                return false;
            }
            if (str != null) {
                String trim = str.trim();
                if (trim.startsWith("[") && trim.endsWith("]")) {
                    String[] split = trim.substring(1, trim.length() - 1).split(",");
                    if (split.length > 0 && (split.length & 1) == 0) {
                        float[] fArr = new float[split.length];
                        while (i3 < split.length) {
                            try {
                                fArr[i3] = Float.parseFloat(split[i3]);
                                i3++;
                            } catch (NumberFormatException unused) {
                            }
                        }
                        if (i3 == split.length) {
                            this.mDashEffect = fArr;
                        }
                    } else {
                        VVLog.e(TAG, "length invalidate:" + split.length);
                    }
                } else {
                    VVLog.e(TAG, "no match []");
                }
            }
        }
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setRPAttribute(int i2, float f2) {
        boolean rPAttribute = super.setRPAttribute(i2, f2);
        if (rPAttribute) {
            return rPAttribute;
        }
        if (i2 != 793104392) {
            return false;
        }
        int rp2px = rp2px(f2);
        this.mLineWidth = rp2px;
        if (rp2px <= 0) {
            this.mLineWidth = 1;
        }
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, int i3) {
        boolean attribute = super.setAttribute(i2, i3);
        if (attribute) {
            return attribute;
        }
        if (i2 == -1439500848) {
            this.mIsHorizontal = i3 != 0;
        } else if (i2 == 94842723) {
            this.mLineColor = i3;
        } else if (i2 == 109780401) {
            this.mStyle = i3;
        } else {
            if (i2 != 793104392) {
                return false;
            }
            int dp2px = Utils.dp2px(i3);
            this.mLineWidth = dp2px;
            if (dp2px <= 0) {
                this.mLineWidth = 1;
            }
        }
        return true;
    }
}
