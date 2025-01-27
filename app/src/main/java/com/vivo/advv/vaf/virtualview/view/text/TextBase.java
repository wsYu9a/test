package com.vivo.advv.vaf.virtualview.view.text;

import android.text.TextUtils;
import com.vivo.advv.Utils;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.Helper.RtlHelper;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.virtualview.common.StringBase;

/* loaded from: classes4.dex */
public abstract class TextBase extends ViewBase {
    private static final String TAG = "TextBase_TMTEST";
    protected int mEllipsize;
    protected int mLines;
    protected String mText;
    protected int mTextColor;
    protected int mTextSize;
    protected int mTextStyle;
    protected String mTypeface;

    public TextBase(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        this.mLines = -1;
        this.mEllipsize = -1;
        this.mText = "";
        this.mTextColor = -16777216;
        this.mTextSize = Utils.dp2px(20.0d);
        this.mDataTag = "title";
        this.mTextStyle = 0;
    }

    public String getText() {
        return this.mText;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void onParseValueFinished(float f2) {
        super.onParseValueFinished(f2);
        if (isRtl()) {
            this.mGravity = RtlHelper.resolveRtlGravity(this.mGravity);
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, String str) {
        boolean attribute = super.setAttribute(i2, str);
        if (attribute) {
            return attribute;
        }
        switch (i2) {
            case StringBase.STR_ID_textColor /* -1063571914 */:
                this.mViewCache.put(this, StringBase.STR_ID_textColor, str, 3);
                break;
            case StringBase.STR_ID_textStyle /* -1048634236 */:
                this.mViewCache.put(this, StringBase.STR_ID_textStyle, str, 8);
                break;
            case StringBase.STR_ID_textSize /* -1003668786 */:
                this.mViewCache.put(this, StringBase.STR_ID_textSize, str, 1);
                break;
            case StringBase.STR_ID_typeface /* -675792745 */:
                this.mTypeface = str;
                break;
            case StringBase.STR_ID_text /* 3556653 */:
                if (!Utils.isEL(str)) {
                    this.mText = str;
                    break;
                } else {
                    this.mViewCache.put(this, StringBase.STR_ID_text, str, 2);
                    break;
                }
        }
        return attribute;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setRPAttribute(int i2, float f2) {
        boolean rPAttribute = super.setRPAttribute(i2, f2);
        if (rPAttribute) {
            return rPAttribute;
        }
        if (i2 != -1003668786) {
            return false;
        }
        this.mTextSize = rp2px(f2);
        return true;
    }

    public void setText(String str) {
        if (TextUtils.equals(str, this.mText)) {
            return;
        }
        this.mText = str;
        refresh();
    }

    public void setTextColor(int i2) {
        if (this.mTextColor != i2) {
            this.mTextColor = i2;
            this.mPaint.setColor(i2);
            refresh();
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setRPAttribute(int i2, int i3) {
        boolean rPAttribute = super.setRPAttribute(i2, i3);
        if (rPAttribute) {
            return rPAttribute;
        }
        if (i2 != -1003668786) {
            return false;
        }
        this.mTextSize = rp2px(i3);
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, float f2) {
        boolean attribute = super.setAttribute(i2, f2);
        if (attribute) {
            return attribute;
        }
        if (i2 != -1003668786) {
            return false;
        }
        this.mTextSize = Utils.dp2px(Math.round(f2));
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, int i3) {
        boolean attribute = super.setAttribute(i2, i3);
        if (attribute) {
            return attribute;
        }
        switch (i2) {
            case StringBase.STR_ID_textColor /* -1063571914 */:
                this.mTextColor = i3;
                return true;
            case StringBase.STR_ID_textStyle /* -1048634236 */:
                this.mTextStyle = i3;
                return true;
            case StringBase.STR_ID_textSize /* -1003668786 */:
                this.mTextSize = Utils.dp2px(i3);
                return true;
            case StringBase.STR_ID_lines /* 102977279 */:
                this.mLines = i3;
                return true;
            case StringBase.STR_ID_ellipsize /* 1554823821 */:
                this.mEllipsize = i3;
                return true;
            default:
                return false;
        }
    }
}
