package com.martian.libfeedback.request.url;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes2.dex */
public class FeedbackReportUrlParams extends FeedbacklUrlHttpGetParams {

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
    private String title;

    public String getChapterId() {
        return this.chapterId;
    }

    public Integer getCid() {
        return this.cid;
    }

    public boolean getEnableNotification() {
        return this.enableNotification;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "#/feedback_submit";
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public String getTitle() {
        return this.title;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public void setEnableNotification(boolean enableNotification) {
        this.enableNotification = enableNotification;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setSourceName(String souceName) {
        this.sourceName = souceName;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
