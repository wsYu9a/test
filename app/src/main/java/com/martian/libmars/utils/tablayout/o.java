package com.martian.libmars.utils.tablayout;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import androidx.appcompat.widget.AppCompatTextView;
import com.martian.libmars.utils.tablayout.CommonNavigator;

/* loaded from: classes2.dex */
public class o extends AppCompatTextView implements CommonNavigator.b {

    /* renamed from: e */
    protected int f10267e;

    /* renamed from: f */
    protected int f10268f;

    /* renamed from: g */
    protected int f10269g;

    /* renamed from: h */
    protected int f10270h;

    /* renamed from: i */
    protected int f10271i;

    public o(Context context, boolean changeFont) {
        super(context, null);
        this.f10269g = -1;
        this.f10270h = -1;
        f(changeFont);
    }

    private void f(boolean changeFont) {
        setGravity(17);
        if (changeFont && com.martian.libmars.d.h.F().v0() != null) {
            setTypeface(com.martian.libmars.d.h.F().v0());
            setIncludeFontPadding(false);
        }
        getPaint().setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
    }

    public void a(int index, int totalCount) {
        setTextColor(this.f10268f);
        int i2 = this.f10270h;
        if (i2 != -1) {
            setBackgroundResource(i2);
        }
        if (this.f10271i == 0) {
            getPaint().setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        } else {
            getPaint().setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        }
    }

    public void b(int index, int totalCount, float enterPercent, boolean leftToRight) {
    }

    public void c(int index, int totalCount) {
        setTextColor(this.f10267e);
        int i2 = this.f10269g;
        if (i2 != -1) {
            setBackgroundResource(i2);
        }
        if (this.f10271i <= 1) {
            getPaint().setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        } else {
            getPaint().setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        }
    }

    public void d(int index, int totalCount, float leavePercent, boolean leftToRight) {
    }

    @Override // com.martian.libmars.utils.tablayout.CommonNavigator.b
    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    @Override // com.martian.libmars.utils.tablayout.CommonNavigator.b
    public int getContentLeft() {
        String charSequence;
        Rect rect = new Rect();
        if (getText().toString().contains("\n")) {
            charSequence = "";
            for (String str : getText().toString().split("\\n")) {
                if (str.length() > charSequence.length()) {
                    charSequence = str;
                }
            }
        } else {
            charSequence = getText().toString();
        }
        getPaint().getTextBounds(charSequence, 0, charSequence.length(), rect);
        return (getLeft() + (getWidth() / 2)) - (rect.width() / 2);
    }

    @Override // com.martian.libmars.utils.tablayout.CommonNavigator.b
    public int getContentRight() {
        String charSequence;
        Rect rect = new Rect();
        if (getText().toString().contains("\n")) {
            charSequence = "";
            for (String str : getText().toString().split("\\n")) {
                if (str.length() > charSequence.length()) {
                    charSequence = str;
                }
            }
        } else {
            charSequence = getText().toString();
        }
        getPaint().getTextBounds(charSequence, 0, charSequence.length(), rect);
        return getLeft() + (getWidth() / 2) + (rect.width() / 2);
    }

    @Override // com.martian.libmars.utils.tablayout.CommonNavigator.b
    public int getContentTop() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public int getNormalColor() {
        return this.f10268f;
    }

    public int getSelectedColor() {
        return this.f10267e;
    }

    public int getmNormalRes() {
        return this.f10270h;
    }

    public int getmSelectedRes() {
        return this.f10269g;
    }

    public void setNormalColor(int normalColor) {
        this.f10268f = normalColor;
    }

    public void setPadding(int padding) {
        int b2 = com.martian.libmars.d.h.b(padding);
        setPadding(b2, 0, b2, 0);
    }

    public void setSelectedColor(int selectedColor) {
        this.f10267e = selectedColor;
    }

    public void setTextStyleMode(int textStyleMode) {
        this.f10271i = textStyleMode;
    }

    public void setmNormalRes(int mNormalRes) {
        this.f10270h = mNormalRes;
    }

    public void setmSelectedRes(int mSelectedRes) {
        this.f10269g = mSelectedRes;
    }
}
