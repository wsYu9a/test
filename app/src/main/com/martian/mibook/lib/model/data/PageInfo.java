package com.martian.mibook.lib.model.data;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class PageInfo {
    private boolean fullPageBeforeAdShow;
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

    public PageInfo incrTotalParagraphExtraHeight(int i10) {
        this.totalParagraphExtraHeight += i10;
        return this;
    }

    public boolean isChapterEnd() {
        return this.pageType == 1;
    }

    public boolean isFullPageBeforeAdShow() {
        return this.fullPageBeforeAdShow;
    }

    public PageInfo setExtraInfo(int i10, int i11, int i12) {
        int size = getTextInfos().size();
        int totalParagraphExtraHeight = (size * i11) + getTotalParagraphExtraHeight() + getTitleHeight();
        int i13 = i10 - totalParagraphExtraHeight;
        setPageType(i12);
        if (i12 > 0) {
            setLeftHeight(i13);
            setTotalTextHeight(totalParagraphExtraHeight);
            return this;
        }
        if (size > 0 && i13 > size) {
            setExtraY(Math.min(i13 / size, i11));
        }
        return this;
    }

    public PageInfo setExtraY(int i10) {
        this.extraY = i10;
        return this;
    }

    public void setFullPageBeforeAdShow(boolean z10) {
        this.fullPageBeforeAdShow = z10;
    }

    public PageInfo setLeftHeight(int i10) {
        this.leftHeight = i10;
        return this;
    }

    public void setPageType(int i10) {
        this.pageType = i10;
    }

    public PageInfo setProgressStatus(String str) {
        this.progressStatus = str;
        return this;
    }

    public PageInfo setTextInfos(ArrayList<TextInfo> arrayList) {
        this.textInfos = arrayList;
        return this;
    }

    public PageInfo setTitle(String str) {
        this.title = str;
        return this;
    }

    public void setTitleHeight(int i10) {
        this.titleHeight = i10;
    }

    public PageInfo setTitleInfos(ArrayList<TextInfo> arrayList) {
        this.titleInfos = arrayList;
        return this;
    }

    public PageInfo setTotalParagraphExtraHeight(int i10) {
        this.totalParagraphExtraHeight = i10;
        return this;
    }

    public PageInfo setTotalTextHeight(int i10) {
        this.totalTextHeight = i10;
        return this;
    }
}
