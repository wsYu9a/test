package com.vivo.advv.vaf.virtualview.view.text;

import android.graphics.Paint;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.LineHeightSpan;
import android.view.View;
import com.vivo.advv.Utils;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.core.ELIllegalArgumentException;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.util.ViewUtils;
import com.vivo.advv.virtualview.common.StringBase;

/* loaded from: classes4.dex */
public class NativeText extends TextBase {
    private static final String TAG = "NativeText_TMTEST";
    protected float mLineHeight;
    protected float mLineSpaceExtra;
    protected float mLineSpaceMultipiler;
    private int mMaxEms;
    private int mMaxHeight;
    private int mMaxWidth;
    protected NativeTextImp mNative;
    protected VVLineHeightSpannableStringBuilder mSpannableStringBuilder;
    protected boolean mSupportHtmlStyle;

    public static class Builder implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new NativeText(vafContext, viewCache);
        }
    }

    public static class VVLineHeightSpan implements LineHeightSpan {
        private int mHeight;

        VVLineHeightSpan(float f2) {
            this.mHeight = (int) Math.ceil(f2);
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence charSequence, int i2, int i3, int i4, int i5, Paint.FontMetricsInt fontMetricsInt) {
            int i6 = fontMetricsInt.descent;
            int i7 = this.mHeight;
            if (i6 > i7) {
                int min = Math.min(i7, i6);
                fontMetricsInt.descent = min;
                fontMetricsInt.bottom = min;
                fontMetricsInt.ascent = 0;
                fontMetricsInt.top = 0;
                return;
            }
            int i8 = fontMetricsInt.ascent;
            int i9 = -i8;
            if (i9 + i6 > i7) {
                fontMetricsInt.bottom = i6;
                int i10 = (-i7) + i6;
                fontMetricsInt.ascent = i10;
                fontMetricsInt.top = i10;
                return;
            }
            int i11 = fontMetricsInt.bottom;
            if (i9 + i11 > i7) {
                fontMetricsInt.top = i8;
                fontMetricsInt.bottom = i8 + i7;
                return;
            }
            int i12 = fontMetricsInt.top;
            if ((-i12) + i11 > i7) {
                fontMetricsInt.top = i11 - i7;
                return;
            }
            double d2 = i12;
            double d3 = (i7 - r6) / 2.0f;
            double ceil = Math.ceil(d3);
            Double.isNaN(d2);
            fontMetricsInt.top = (int) (d2 - ceil);
            double d4 = fontMetricsInt.bottom;
            double floor = Math.floor(d3);
            Double.isNaN(d4);
            int i13 = (int) (d4 + floor);
            fontMetricsInt.bottom = i13;
            fontMetricsInt.ascent = fontMetricsInt.top;
            fontMetricsInt.descent = i13;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public void setHeight(float f2) {
            this.mHeight = (int) Math.ceil(f2);
        }
    }

    public static class VVLineHeightSpannableStringBuilder extends SpannableStringBuilder {
        private VVLineHeightSpan mVVLineHeightSpan;

        public void setContent(CharSequence charSequence, float f2) {
            clear();
            clearSpans();
            VVLineHeightSpan vVLineHeightSpan = this.mVVLineHeightSpan;
            if (vVLineHeightSpan == null) {
                this.mVVLineHeightSpan = new VVLineHeightSpan(f2);
            } else {
                vVLineHeightSpan.setHeight(f2);
            }
            append(charSequence);
            setSpan(this.mVVLineHeightSpan, 0, charSequence.length(), 17);
        }
    }

    public NativeText(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        this.mSupportHtmlStyle = false;
        this.mLineSpaceMultipiler = 1.0f;
        this.mLineSpaceExtra = 0.0f;
        this.mLineHeight = Float.NaN;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mMaxEms = -1;
        this.mNative = new NativeTextImp(vafContext.forViewConstruction());
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void check() {
        super.check();
        String[] strArr = this.mCheckList;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.mCheckList.length; i2++) {
            if (!TextUtils.isEmpty(this.mText)) {
                String[] strArr2 = this.mCheckList;
                if (strArr2[i2] != null && strArr2[i2].hashCode() == 3556653 && ViewBase.EL_PATTERN.matcher(this.mText).find()) {
                    throw new ELIllegalArgumentException(2, "" + this.mText);
                }
            }
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void comLayout(int i2, int i3, int i4, int i5) {
        super.comLayout(i2, i3, i4, i5);
        this.mNative.comLayout(i2, i3, i4, i5);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredHeight() {
        return this.mNative.getComMeasuredHeight();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredWidth() {
        return this.mNative.getComMeasuredWidth();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public View getNativeView() {
        return this.mNative;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void measureComponent(int i2, int i3) {
        this.mNative.measureComponent(ViewUtils.scaleWidthMeasureSpec(i2, this.mScaleFactor, this.mParams), ViewUtils.scaleHeightMeasureSpec(i3, this.mScaleFactor, this.mParams));
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.mNative.onComLayout(z, i2, i3, i4, i5);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComMeasure(int i2, int i3) {
        this.mNative.onComMeasure(ViewUtils.scaleWidthMeasureSpec(i2, this.mScaleFactor, this.mParams), ViewUtils.scaleHeightMeasureSpec(i3, this.mScaleFactor, this.mParams));
    }

    @Override // com.vivo.advv.vaf.virtualview.view.text.TextBase, com.vivo.advv.vaf.virtualview.core.ViewBase
    public void onParseValueFinished(float f2) {
        super.onParseValueFinished(f2);
        int i2 = this.mMaxEms;
        if (i2 != -1) {
            this.mNative.setMaxEms(i2);
        } else {
            int i3 = this.mMaxWidth;
            if (i3 != Integer.MAX_VALUE) {
                this.mNative.setMaxWidth((int) (i3 * this.mScaleFactor));
            }
            int i4 = this.mMaxHeight;
            if (i4 != Integer.MAX_VALUE) {
                this.mNative.setMaxHeight((int) (i4 * this.mScaleFactor));
            }
        }
        int i5 = 0;
        this.mNative.setTextSize(0, this.mTextSize * this.mScaleFactor);
        this.mNative.setBorderColor(this.mBorderColor);
        this.mNative.setBorderWidth((int) (this.mBorderWidth * this.mScaleFactor));
        this.mNative.setBorderTopLeftRadius((int) (this.mBorderTopLeftRadius * this.mScaleFactor));
        this.mNative.setBorderTopRightRadius((int) (this.mBorderTopRightRadius * this.mScaleFactor));
        this.mNative.setBorderBottomLeftRadius((int) (this.mBorderBottomLeftRadius * this.mScaleFactor));
        this.mNative.setBorderBottomRightRadius((int) (this.mBorderBottomRightRadius * this.mScaleFactor));
        this.mNative.setBackgroundColor(this.mBackground);
        this.mNative.setTextColor(this.mTextColor);
        int i6 = this.mTextStyle;
        int i7 = (i6 & 1) != 0 ? 33 : 1;
        if ((i6 & 8) != 0) {
            i7 |= 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 8;
        }
        this.mNative.setPaintFlags(i7);
        if ((this.mTextStyle & 2) != 0) {
            this.mNative.setTypeface(null, 3);
        }
        int i8 = this.mLines;
        if (i8 > 0) {
            this.mNative.setLines(i8);
        }
        if (this.mEllipsize >= 0) {
            this.mNative.setEllipsize(TextUtils.TruncateAt.values()[this.mEllipsize]);
        }
        int i9 = this.mGravity;
        if ((i9 & 1) != 0) {
            i5 = 3;
        } else if ((i9 & 2) != 0) {
            i5 = 5;
        } else if ((i9 & 4) != 0) {
            i5 = 1;
        }
        if ((i9 & 8) != 0) {
            i5 |= 48;
        } else if ((i9 & 16) != 0) {
            i5 |= 80;
        } else if ((i9 & 32) != 0) {
            i5 |= 16;
        }
        this.mNative.setGravity(i5);
        this.mNative.setLineSpacing(this.mLineSpaceExtra, this.mLineSpaceMultipiler);
        if (TextUtils.isEmpty(this.mText)) {
            setRealText("");
        } else {
            setRealText(this.mText);
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void reset() {
        super.reset();
    }

    @Override // com.vivo.advv.vaf.virtualview.view.text.TextBase, com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, int i3) {
        boolean attribute = super.setAttribute(i2, i3);
        if (attribute) {
            return attribute;
        }
        switch (i2) {
            case StringBase.STR_ID_lineSpaceExtra /* -1118334530 */:
                this.mLineSpaceExtra = i3;
                return true;
            case StringBase.STR_ID_maxEms /* -1081163577 */:
                this.mMaxEms = i3;
                return true;
            case StringBase.STR_ID_maxHeight /* -906066005 */:
                this.mMaxHeight = Utils.dp2px(i3);
                return true;
            case StringBase.STR_ID_lineSpaceMultiplier /* -667362093 */:
                this.mLineSpaceMultipiler = i3;
                return true;
            case StringBase.STR_ID_lineHeight /* -515807685 */:
                this.mLineHeight = Utils.dp2px(i3);
                return true;
            case StringBase.STR_ID_maxLines /* 390232059 */:
                this.mNative.setMaxLines(i3);
                return true;
            case StringBase.STR_ID_maxWidth /* 400381634 */:
                this.mMaxWidth = Utils.dp2px(i3);
                return true;
            case StringBase.STR_ID_supportHTMLStyle /* 506010071 */:
                this.mSupportHtmlStyle = i3 > 0;
                return true;
            default:
                return false;
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void setData(Object obj) {
        super.setData(obj);
        if (obj instanceof String) {
            setRealText((String) obj);
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setPXAttribute(int i2, int i3) {
        boolean pXAttribute = super.setPXAttribute(i2, i3);
        if (pXAttribute) {
            return pXAttribute;
        }
        if (i2 == -906066005) {
            this.mMaxHeight = i3;
            return pXAttribute;
        }
        if (i2 != 400381634) {
            return false;
        }
        this.mMaxWidth = i3;
        return pXAttribute;
    }

    @Override // com.vivo.advv.vaf.virtualview.view.text.TextBase, com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setRPAttribute(int i2, int i3) {
        boolean rPAttribute = super.setRPAttribute(i2, i3);
        if (rPAttribute) {
            return rPAttribute;
        }
        if (i2 == -906066005) {
            this.mMaxHeight = rp2px(i3);
            return true;
        }
        if (i2 == -515807685) {
            this.mLineHeight = rp2px(i3);
            return true;
        }
        if (i2 != 400381634) {
            return false;
        }
        this.mMaxWidth = rp2px(i3);
        return true;
    }

    protected void setRealText(String str) {
        CharSequence charSequence = str;
        if (this.mSupportHtmlStyle) {
            charSequence = Html.fromHtml(str);
        }
        if (Float.isNaN(this.mLineHeight)) {
            this.mNative.setText(charSequence);
            return;
        }
        if (this.mSpannableStringBuilder == null) {
            this.mSpannableStringBuilder = new VVLineHeightSpannableStringBuilder();
        }
        this.mSpannableStringBuilder.setContent(charSequence, this.mLineHeight * this.mScaleFactor);
        this.mNative.setText(this.mSpannableStringBuilder);
    }

    @Override // com.vivo.advv.vaf.virtualview.view.text.TextBase
    public void setText(String str) {
        if (TextUtils.equals(str, this.mText)) {
            return;
        }
        this.mText = str;
        setRealText(str);
    }

    @Override // com.vivo.advv.vaf.virtualview.view.text.TextBase
    public void setTextColor(int i2) {
        if (this.mTextColor != i2) {
            this.mTextColor = i2;
            this.mNative.setTextColor(i2);
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.view.text.TextBase, com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setRPAttribute(int i2, float f2) {
        boolean rPAttribute = super.setRPAttribute(i2, f2);
        if (rPAttribute) {
            return rPAttribute;
        }
        if (i2 != -515807685) {
            return false;
        }
        this.mLineHeight = rp2px(f2);
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.view.text.TextBase, com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, float f2) {
        boolean attribute = super.setAttribute(i2, f2);
        if (attribute) {
            return attribute;
        }
        if (i2 == -1118334530) {
            this.mLineSpaceExtra = f2;
        } else if (i2 == -667362093) {
            this.mLineSpaceMultipiler = f2;
        } else if (i2 == -515807685) {
            this.mLineHeight = Utils.dp2px(f2);
        } else {
            if (i2 != 506010071) {
                return false;
            }
            this.mSupportHtmlStyle = f2 > 0.0f;
        }
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.view.text.TextBase, com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, String str) {
        boolean attribute = super.setAttribute(i2, str);
        if (attribute) {
            return attribute;
        }
        if (i2 != -515807685) {
            return false;
        }
        this.mViewCache.put(this, StringBase.STR_ID_lineHeight, str, 1);
        return true;
    }
}
