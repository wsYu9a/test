package com.martian.libfeedback.request;

import com.martian.libcomm.http.requests.d.c;

/* loaded from: classes2.dex */
public class FeedbackInfoParams extends FeedbacklTaskHttpPostParams {

    @c
    private Integer categoryId;

    @c
    private String pics;

    @c
    private String qq;

    @c
    private Integer subCategoryId;

    @c
    private String subject;

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public String getPics() {
        return this.pics;
    }

    public String getQq() {
        return this.qq;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "authopt/feedback/add";
    }

    public Integer getSubCategoryId() {
        return this.subCategoryId;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
