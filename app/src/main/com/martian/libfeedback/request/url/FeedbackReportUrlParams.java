package com.martian.libfeedback.request.url;

import v8.a;

/* loaded from: classes3.dex */
public class FeedbackReportUrlParams extends FeedbacklUrlHttpGetParams {

    @a
    private Integer categoryId;

    @a
    private String chapterId;

    @a
    private Integer cid;

    @a
    private boolean enableNotification;

    @a
    private String sourceId;

    @a
    private String sourceName;

    @a
    private Integer subCategoryId;

    @a
    private String title;

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public String getChapterId() {
        return this.chapterId;
    }

    public Integer getCid() {
        return this.cid;
    }

    public boolean getEnableNotification() {
        return this.enableNotification;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "#/feedback_submit";
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public Integer getSubCategoryId() {
        return this.subCategoryId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCategoryId(Integer num) {
        this.categoryId = num;
    }

    public void setChapterId(String str) {
        this.chapterId = str;
    }

    public void setCid(Integer num) {
        this.cid = num;
    }

    public void setEnableNotification(boolean z10) {
        this.enableNotification = z10;
    }

    public void setSourceId(String str) {
        this.sourceId = str;
    }

    public void setSourceName(String str) {
        this.sourceName = str;
    }

    public void setSubCategoryId(Integer num) {
        this.subCategoryId = num;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
