package com.martian.mibook.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.martian.mibook.activity.reader.ReadingActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.book.ContentProperty;
import com.martian.mibook.j.x2;
import com.martian.mibook.lib.model.data.MiReadingContent;
import com.martian.mibook.lib.model.data.PageInfo;
import com.martian.mibook.lib.model.data.TextInfo;
import com.martian.mibook.ui.o.i4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes4.dex */
public class MyDrawTextView extends AppCompatTextView {

    /* renamed from: e */
    private final int f14160e;

    /* renamed from: f */
    private int f14161f;

    /* renamed from: g */
    private PageInfo f14162g;

    public MyDrawTextView(Context context) {
        super(context);
        this.f14160e = com.martian.libmars.d.h.b(32.0f);
    }

    private void f(String line, float widthExtra, boolean pi, ArrayList<TextInfo> textInfos) {
        textInfos.add(new TextInfo().setWidthExtra(widthExtra).setpStart(pi).setLine(MiConfigSingleton.V3().n(line)));
    }

    private int h(int contentIndex, int pos, MiReadingContent content, boolean addAds, String computeTitle, boolean mixAd, PageInfo pageInfo, int measureHeight) {
        int i2;
        int i3;
        String content2 = content.getContent(pos, content.getChapterContent().getContentLength());
        if (pos == 0 && contentIndex == 0 && !com.martian.libsupport.k.p(computeTitle)) {
            i3 = o(computeTitle, pageInfo);
        } else {
            if (!addAds) {
                i2 = 0;
                return i(pos, i2, content2, pageInfo, measureHeight);
            }
            if (!mixAd) {
                return pos;
            }
            i3 = i4.f14425g;
        }
        i2 = i3;
        return i(pos, i2, content2, pageInfo, measureHeight);
    }

    private int i(int pos, int iLineHeight, String estContent, PageInfo pageInfo, int measureHeight) {
        String substring;
        int i2;
        int lineHeight = getLineHeight();
        int measuredWidth = getMeasuredWidth();
        int length = estContent.length();
        float measureText = getPaint().measureText("啊");
        int i3 = 0;
        int i4 = 1;
        int i5 = iLineHeight;
        String str = estContent;
        int i6 = 0;
        boolean z = true;
        while (i5 < measureHeight && i6 < length) {
            int indexOf = str.indexOf("\n");
            if (indexOf == -1) {
                boolean z2 = true;
                boolean z3 = !z;
                while (str.length() != 0) {
                    int breakText = getPaint().breakText(str, z2, getWidth(), null);
                    if (breakText > str.length()) {
                        breakText = str.length();
                    }
                    i5 += lineHeight;
                    if ((z3 ? this.f14161f : 0) + i5 > measureHeight) {
                        break;
                    }
                    String substring2 = str.substring(0, breakText);
                    f(substring2, p(measuredWidth - getPaint().measureText(substring2), measureText, breakText - 1), z3, pageInfo.getTextInfos());
                    if (z3) {
                        int i7 = this.f14161f;
                        i5 += i7;
                        pageInfo.incrTotalParagraphExtraHeight(i7);
                        z3 = false;
                    }
                    i6 += breakText;
                    if (i6 >= length) {
                        break;
                    }
                    str = str.substring(breakText);
                    z2 = true;
                }
                return pos + i6;
            }
            if (indexOf == 0) {
                i6++;
                str = str.substring(i4);
            } else {
                int i8 = indexOf - 1;
                if (str.charAt(i8) == '\r') {
                    substring = str.substring(i3, i8);
                    i2 = 2;
                } else {
                    substring = str.substring(i3, indexOf);
                    i2 = 1;
                }
                boolean z4 = !z;
                while (substring.length() != 0) {
                    String str2 = str;
                    int i9 = indexOf;
                    int breakText2 = getPaint().breakText(substring, true, getWidth(), null);
                    if (breakText2 > substring.length()) {
                        breakText2 = substring.length();
                    }
                    i5 += lineHeight;
                    if ((z4 ? this.f14161f : 0) + i5 > measureHeight) {
                        return pos + i6;
                    }
                    String substring3 = substring.substring(0, breakText2);
                    f(substring3, p(measuredWidth - getPaint().measureText(substring3), measureText, breakText2 - 1), z4, pageInfo.getTextInfos());
                    if (z4) {
                        int i10 = this.f14161f;
                        i5 += i10;
                        pageInfo.incrTotalParagraphExtraHeight(i10);
                        z4 = false;
                    }
                    i6 += breakText2;
                    if (i6 + i2 >= length) {
                        return pos + i6 + i2;
                    }
                    substring = substring.substring(breakText2);
                    str = str2;
                    indexOf = i9;
                }
                i6 += i2;
                str = str.substring(indexOf + 1);
                i3 = 0;
                i4 = 1;
                z = false;
            }
        }
        return pos + i6;
    }

    private void k(Canvas canvas, Paint paint, TextInfo textInfo, float mLineX, float mLineY) {
        if (!textInfo.getNeedScale()) {
            canvas.drawText(textInfo.getLine(), mLineX, mLineY, paint);
            return;
        }
        float f2 = 0.0f;
        for (int i2 = 0; i2 < textInfo.getLine().length(); i2++) {
            String valueOf = String.valueOf(textInfo.getLine().charAt(i2));
            float measureText = paint.measureText(valueOf);
            canvas.drawText(valueOf, f2, mLineY, paint);
            f2 += measureText + textInfo.getWidthExtra();
        }
    }

    private float l(Canvas canvas, Paint paint, int mViewWidth, float lineHeight, float mLineY) {
        float f2;
        if (getPageInfo().getTitleInfos().isEmpty()) {
            return mLineY;
        }
        float textSize = getTextSize();
        paint.setTextSize(1.33f * textSize);
        float f3 = mLineY + this.f14160e;
        int i2 = 0;
        Iterator<TextInfo> it = getPageInfo().getTitleInfos().iterator();
        while (it.hasNext()) {
            TextInfo next = it.next();
            if (i2 == 0) {
                float measureText = paint.measureText(next.getLine());
                float f4 = mViewWidth;
                if (f4 > measureText) {
                    f2 = (f4 - measureText) / 2.0f;
                    i2++;
                    k(canvas, paint, next, f2, f3);
                    double d2 = f3;
                    double d3 = lineHeight;
                    Double.isNaN(d3);
                    Double.isNaN(d2);
                    f3 = (float) (d2 + (d3 * 1.33d));
                }
            }
            f2 = 0.0f;
            i2++;
            k(canvas, paint, next, f2, f3);
            double d22 = f3;
            double d32 = lineHeight;
            Double.isNaN(d32);
            Double.isNaN(d22);
            f3 = (float) (d22 + (d32 * 1.33d));
        }
        float f5 = f3 + this.f14160e;
        paint.setTextSize(textSize);
        return f5;
    }

    private String n(int index, int size) {
        if (size <= 0) {
            return "";
        }
        if (index >= size) {
            return "99.99%";
        }
        return String.format(Locale.getDefault(), "%.2f", Double.valueOf((index * 100.0f) / size)) + "%";
    }

    private int o(String title, PageInfo pageInfo) {
        if (com.martian.libsupport.k.p(title)) {
            return 0;
        }
        pageInfo.setTitle(title);
        float textSize = getTextSize();
        getPaint().setTextSize(1.33f * textSize);
        int length = title.length();
        int measuredWidth = getMeasuredWidth();
        float measureText = getPaint().measureText("啊");
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int breakText = getPaint().breakText(title, true, getWidth(), null);
            if (breakText > title.length()) {
                breakText = title.length();
            }
            String substring = title.substring(0, breakText);
            f(substring, p(measuredWidth - getPaint().measureText(substring), measureText, breakText - 1), false, pageInfo.getTitleInfos());
            i2 += breakText;
            i3++;
            title = title.substring(breakText);
        }
        int lineHeight = (i3 * getLineHeight()) + (this.f14160e * 2);
        pageInfo.setTitleHeight(lineHeight);
        getPaint().setTextSize(textSize);
        return lineHeight;
    }

    private float p(float leftWidth, float wordWidth, int textSize) {
        if (leftWidth > wordWidth || textSize <= 0) {
            return 0.0f;
        }
        return leftWidth / textSize;
    }

    private void setCustomTypeface(String filepath) {
        Typeface b2;
        if (com.martian.libsupport.k.p(filepath) || (b2 = x2.b(filepath)) == null) {
            return;
        }
        getPaint().setTypeface(b2);
    }

    private void u() {
        getPaint().setTypeface(Typeface.DEFAULT);
    }

    public ContentProperty getContentProperty() {
        ContentProperty contentProperty = new ContentProperty();
        contentProperty.setMeasureHeight(getMeasuredHeight());
        contentProperty.setLineHeight(getLineHeight());
        contentProperty.setLineWidth(getWidth());
        contentProperty.setParagraphExtraHeight(this.f14161f);
        contentProperty.setTextSize(getPaint().getTextSize());
        return contentProperty;
    }

    public int getLeftHeight() {
        return getPageInfo().getLeftHeight();
    }

    public PageInfo getPageInfo() {
        if (this.f14162g == null) {
            this.f14162g = new PageInfo();
        }
        return this.f14162g;
    }

    public int getTextEndHeight() {
        return getTop() + getPageInfo().getTotalTextHeight();
    }

    public void j(final MiReadingContent content, int chapterSize, boolean enableAds, int adInterval, String computeTitle, boolean mixAd) {
        int i2;
        boolean z;
        int contentLength = content.getChapterContent().getContentLength();
        int measuredHeight = getMeasuredHeight();
        int lineHeight = getLineHeight();
        int chapterIndex = content.getChapterIndex() + 1;
        boolean z2 = chapterSize == chapterIndex;
        String n = n(chapterIndex, chapterSize);
        int i3 = 0;
        int i4 = 0;
        boolean z3 = false;
        int i5 = 0;
        while (i5 < contentLength) {
            if (!enableAds) {
                i2 = i3;
                z = z3;
            } else if (i3 >= adInterval) {
                i2 = 0;
                z = true;
            } else {
                i2 = i3 + 1;
                z = false;
            }
            PageInfo pageInfo = new PageInfo();
            int i6 = i4 + 1;
            int i7 = i2;
            int i8 = i5;
            String str = n;
            int h2 = h(i4, i5, content, z, computeTitle, mixAd, pageInfo, measuredHeight);
            int i9 = 2;
            if (h2 >= contentLength) {
                content.appendEndPos(contentLength);
                content.appendPageInfo(pageInfo.setExtraInfo(measuredHeight, lineHeight, 1, mixAd).setProgressStatus(z2 ? "100%" : str));
                if (i7 <= 2 || z2 || mixAd) {
                    return;
                }
                PageInfo pageInfo2 = new PageInfo();
                content.appendEndPos(contentLength);
                content.appendPageInfo(pageInfo2.setExtraInfo(measuredHeight, lineHeight, 3, false).setProgressStatus(""));
                return;
            }
            if (h2 == i8 && !z) {
                h2++;
            }
            i5 = h2;
            content.appendEndPos(i5);
            if (!z) {
                i9 = 0;
            }
            content.appendPageInfo(pageInfo.setExtraInfo(measuredHeight, lineHeight, i9, mixAd).setProgressStatus(str));
            n = str;
            i3 = i7;
            z3 = z;
            i4 = i6;
        }
    }

    public int m(int adHeight) {
        return getTop() + getPageInfo().getTotalTextHeight() + (getLeftHeight() > adHeight ? (getLeftHeight() - adHeight) / 2 : 0);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getPageInfo().getTextInfos().isEmpty()) {
            return;
        }
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.drawableState = getDrawableState();
        int measuredWidth = getMeasuredWidth();
        float textSize = getTextSize();
        int lineHeight = getLineHeight();
        Iterator<TextInfo> it = getPageInfo().getTextInfos().iterator();
        float f2 = textSize;
        int i2 = 0;
        while (it.hasNext()) {
            TextInfo next = it.next();
            if (i2 == 0) {
                f2 = l(canvas, paint, measuredWidth, lineHeight, f2);
            }
            i2++;
            if (next.ispStart()) {
                f2 += this.f14161f;
            }
            float f3 = f2;
            k(canvas, paint, next, 0.0f, f3);
            f2 = f3 + getPageInfo().getExtraY() + lineHeight;
        }
    }

    public boolean q() {
        return getPageInfo().isAdPage();
    }

    public boolean r() {
        return getPageInfo().isChapterEnd();
    }

    public boolean s() {
        return getPageInfo().isChapterEndAd();
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.f14162g = pageInfo;
    }

    public void t() {
        float S3 = MiConfigSingleton.V3().S3();
        setLineSpacing(0.0f, S3);
        float textSize = getTextSize();
        if (S3 == ReadingActivity.H) {
            this.f14161f = Math.max((int) textSize, com.martian.libmars.d.h.b(8.0f));
        } else if (S3 == ReadingActivity.I) {
            this.f14161f = Math.max((int) (textSize * 1.5f), com.martian.libmars.d.h.b(8.0f));
        } else {
            this.f14161f = Math.max((int) (textSize * 0.6f), com.martian.libmars.d.h.b(8.0f));
        }
    }

    public void v() {
        if (MiConfigSingleton.V3().B4().booleanValue()) {
            u();
        } else {
            setCustomTypeface(MiConfigSingleton.V3().A4());
        }
    }

    public MyDrawTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f14160e = com.martian.libmars.d.h.b(32.0f);
    }

    public MyDrawTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f14160e = com.martian.libmars.d.h.b(32.0f);
    }
}
