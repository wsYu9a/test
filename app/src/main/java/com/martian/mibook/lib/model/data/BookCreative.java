package com.martian.mibook.lib.model.data;

import com.maritan.mibook.lib.model.R;
import com.martian.libsupport.k;

/* loaded from: classes3.dex */
public class BookCreative {
    private String bgImg;
    private String content;
    private String fontColor;
    private Integer startPx;
    private Integer textRectBottom;
    private Integer textRectTop;
    private String title;
    private String titleColor;

    public String getBgImg() {
        return this.bgImg;
    }

    public String getContent() {
        return this.content;
    }

    public String getFontColor() {
        if (k.p(this.fontColor)) {
            return String.valueOf(R.color.pure_black);
        }
        if (this.fontColor.startsWith("#")) {
            return this.fontColor;
        }
        return "#" + this.fontColor;
    }

    public int getStartPx() {
        Integer num = this.startPx;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getTextRectBottom() {
        Integer num = this.textRectBottom;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getTextRectTop() {
        Integer num = this.textRectTop;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getTitle() {
        return this.title;
    }

    public String getTitleColor() {
        if (k.p(this.titleColor)) {
            return String.valueOf(R.color.pure_black);
        }
        if (this.titleColor.startsWith("#")) {
            return this.titleColor;
        }
        return "#" + this.titleColor;
    }

    public void setBgImg(String bgImg) {
        this.bgImg = bgImg;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public void setStartPx(Integer startPx) {
        this.startPx = startPx;
    }

    public void setTextRectBottom(Integer textRectBottom) {
        this.textRectBottom = textRectBottom;
    }

    public void setTextRectTop(Integer textRectTop) {
        this.textRectTop = textRectTop;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }
}
