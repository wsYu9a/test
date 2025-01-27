package com.martian.mibook.data.book;

/* loaded from: classes3.dex */
public class ContentProperty {
    private int chapterIndex;
    private int chapterSize;
    private int contentIndex;
    private int lineHeight;
    private int lineWidth;
    private int measureHeight;
    private int paragraphExtraHeight;
    private float textSize;

    public int getChapterIndex() {
        return this.chapterIndex;
    }

    public int getChapterSize() {
        return this.chapterSize;
    }

    public int getContentIndex() {
        return this.contentIndex;
    }

    public int getLineHeight() {
        return this.lineHeight;
    }

    public int getLineWidth() {
        return this.lineWidth;
    }

    public int getMeasureHeight() {
        return this.measureHeight;
    }

    public int getParagraphExtraHeight() {
        return this.paragraphExtraHeight;
    }

    public float getTextSize() {
        return this.textSize;
    }

    public ContentProperty setChapterIndex(int chapterIndex) {
        this.chapterIndex = chapterIndex;
        return this;
    }

    public void setChapterSize(int chapterSize) {
        this.chapterSize = chapterSize;
    }

    public ContentProperty setContentIndex(int contentIndex) {
        this.contentIndex = contentIndex;
        return this;
    }

    public void setLineHeight(int lineHeight) {
        this.lineHeight = lineHeight;
    }

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    public void setMeasureHeight(int measureHeight) {
        this.measureHeight = measureHeight;
    }

    public void setParagraphExtraHeight(int paragraphExtraHeight) {
        this.paragraphExtraHeight = paragraphExtraHeight;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public String toString() {
        return "measureHeight:" + this.measureHeight + " lineHeight:" + this.lineHeight + " lineWidth:" + this.lineWidth + " paragraphExtraHeight:" + this.paragraphExtraHeight + " textSize:" + this.textSize;
    }
}
