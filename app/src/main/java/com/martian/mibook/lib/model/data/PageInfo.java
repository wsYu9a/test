package com.martian.mibook.lib.model.data;

import com.martian.libmars.d.h;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class PageInfo {
    private int leftHeight;
    private int pageType;
    private ArrayList<TextInfo> textInfos;
    private String title;
    private int titleHeight;
    private ArrayList<TextInfo> titleInfos;
    private int totalParagraphExtraHeight;
    private int totalTextHeight;
    private int extraY = -1;
    private String progressStatus = "";

    public interface PageType {
        public static final int AD = 2;
        public static final int AD_END = 3;
        public static final int CHAPTER_END = 1;
        public static final int CONTENT = 0;
    }

    public int getExtraY() {
        return this.extraY;
    }

    public int getLeftHeight() {
        return this.leftHeight;
    }

    public int getPageType() {
        return this.pageType;
    }

    public String getProgressStatus() {
        return this.progressStatus;
    }

    public ArrayList<TextInfo> getTextInfos() {
        if (this.textInfos == null) {
            this.textInfos = new ArrayList<>();
        }
        return this.textInfos;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTitleHeight() {
        return this.titleHeight;
    }

    public ArrayList<TextInfo> getTitleInfos() {
        if (this.titleInfos == null) {
            this.titleInfos = new ArrayList<>();
        }
        return this.titleInfos;
    }

    public int getTotalParagraphExtraHeight() {
        return this.totalParagraphExtraHeight;
    }

    public int getTotalTextHeight() {
        return this.totalTextHeight;
    }

    public PageInfo incrTotalParagraphExtraHeight(int extraHeight) {
        this.totalParagraphExtraHeight += extraHeight;
        return this;
    }

    public boolean isAdPage() {
        int i2 = this.pageType;
        return i2 == 2 || i2 == 3;
    }

    public boolean isChapterEnd() {
        return this.pageType == 1;
    }

    public boolean isChapterEndAd() {
        return this.pageType == 3;
    }

    public PageInfo setExtraInfo(int measureHeight, int lineHeight, int pageType, boolean mixAd) {
        int size = getTextInfos().size();
        int totalParagraphExtraHeight = (size * lineHeight) + getTotalParagraphExtraHeight() + getTitleHeight();
        int i2 = measureHeight - totalParagraphExtraHeight;
        setPageType(pageType);
        if (pageType <= 0) {
            if (size > 0 && i2 > size) {
                setExtraY(Math.min(i2 / size, lineHeight));
            }
            return this;
        }
        if (pageType != 1) {
            i2 = measureHeight + (mixAd ? 0 : h.b(64.0f));
        }
        setLeftHeight(i2);
        setTotalTextHeight(totalParagraphExtraHeight);
        return this;
    }

    public PageInfo setExtraY(int extraY) {
        this.extraY = extraY;
        return this;
    }

    public PageInfo setLeftHeight(int leftHeight) {
        this.leftHeight = leftHeight;
        return this;
    }

    public void setPageType(int pageType) {
        this.pageType = pageType;
    }

    public PageInfo setProgressStatus(String progressStatus) {
        this.progressStatus = progressStatus;
        return this;
    }

    public PageInfo setTextInfos(ArrayList<TextInfo> textInfos) {
        this.textInfos = textInfos;
        return this;
    }

    public PageInfo setTitle(String title) {
        this.title = title;
        return this;
    }

    public void setTitleHeight(int titleHeight) {
        this.titleHeight = titleHeight;
    }

    public PageInfo setTitleInfos(ArrayList<TextInfo> titleInfos) {
        this.titleInfos = titleInfos;
        return this;
    }

    public PageInfo setTotalParagraphExtraHeight(int totalParagraphExtraHeight) {
        this.totalParagraphExtraHeight = totalParagraphExtraHeight;
        return this;
    }

    public PageInfo setTotalTextHeight(int totalTextHeight) {
        this.totalTextHeight = totalTextHeight;
        return this;
    }
}
