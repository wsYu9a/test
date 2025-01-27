package com.martian.mibook.lib.model.data;

import android.text.TextUtils;
import ba.l;
import com.martian.libmars.R;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class BookCreative implements Serializable {
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
        if (TextUtils.isEmpty(this.fontColor)) {
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
        if (l.q(this.titleColor)) {
            return String.valueOf(R.color.pure_black);
        }
        if (this.titleColor.startsWith("#")) {
            return this.titleColor;
        }
        return "#" + this.titleColor;
    }

    public void setBgImg(String str) {
        this.bgImg = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setFontColor(String str) {
        this.fontColor = str;
    }

    public void setStartPx(Integer num) {
        this.startPx = num;
    }

    public void setTextRectBottom(Integer num) {
        this.textRectBottom = num;
    }

    public void setTextRectTop(Integer num) {
        this.textRectTop = num;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTitleColor(String str) {
        this.titleColor = str;
    }
}
