package com.martian.libmars.utils.tablayout;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import androidx.appcompat.widget.AppCompatTextView;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.utils.tablayout.CommonNavigator;

/* loaded from: classes3.dex */
public class SimplePagerTitleView extends AppCompatTextView implements CommonNavigator.b {

    /* renamed from: b */
    public int f12475b;

    /* renamed from: c */
    public int f12476c;

    /* renamed from: d */
    public int f12477d;

    /* renamed from: e */
    public int f12478e;

    /* renamed from: f */
    public int f12479f;

    /* renamed from: g */
    public Typeface f12480g;

    public SimplePagerTitleView(Context context, boolean z10) {
        super(context, null);
        this.f12477d = -1;
        this.f12478e = -1;
        this.f12480g = Typeface.DEFAULT;
        a(z10);
    }

    public final void a(boolean z10) {
        setGravity(17);
        if (z10 && ConfigSingleton.D().n0() != null) {
            setTypeface(ConfigSingleton.D().n0());
            setIncludeFontPadding(false);
        }
        getPaint().setTypeface(Typeface.create(this.f12480g, 1));
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
    }

    public void b(int i10, int i11) {
        setTextColor(this.f12476c);
        int i12 = this.f12478e;
        if (i12 != -1) {
            setBackgroundResource(i12);
        }
        if (this.f12479f == 0) {
            getPaint().setTypeface(Typeface.create(this.f12480g, 1));
        } else {
            getPaint().setTypeface(Typeface.create(this.f12480g, 0));
        }
    }

    public void c(int i10, int i11, float f10, boolean z10) {
    }

    public void d(int i10, int i11) {
        setTextColor(this.f12475b);
        int i12 = this.f12477d;
        if (i12 != -1) {
            setBackgroundResource(i12);
        }
        if (this.f12479f <= 1) {
            getPaint().setTypeface(Typeface.create(this.f12480g, 1));
        } else {
            getPaint().setTypeface(Typeface.create(this.f12480g, 0));
        }
    }

    public void e(int i10, int i11, float f10, boolean z10) {
    }

    @Override // com.martian.libmars.utils.tablayout.CommonNavigator.b
    public int getContentBottom() {
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
        return (getHeight() / 2) + (rect.height() / 2);
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
        return (getHeight() / 2) - (rect.height() / 2);
    }

    public int getNormalColor() {
        return this.f12476c;
    }

    public int getSelectedColor() {
        return this.f12475b;
    }

    public int getmNormalRes() {
        return this.f12478e;
    }

    public int getmSelectedRes() {
        return this.f12477d;
    }

    public void setNormalColor(int i10) {
        this.f12476c = i10;
    }

    public void setPadding(int i10) {
        int i11 = ConfigSingleton.i(i10);
        setPadding(i11, 0, i11, 0);
    }

    public void setSelectedColor(int i10) {
        this.f12475b = i10;
    }

    public void setTextStyleMode(int i10) {
        this.f12479f = i10;
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface) {
        this.f12480g = typeface;
    }

    public void setmNormalRes(int i10) {
        this.f12478e = i10;
    }

    public void setmSelectedRes(int i10) {
        this.f12477d = i10;
    }
}
