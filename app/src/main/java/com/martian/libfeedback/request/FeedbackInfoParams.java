package com.martian.libfeedback.request;

import v8.c;

/* loaded from: classes3.dex */
public class FeedbackInfoParams extends FeedbacklTaskHttpPostParams {

    @c
    private Integer categoryId;

    @c
    private String ext;

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

    public String getExt() {
        return this.ext;
    }

    public String getPics() {
        return this.pics;
    }

    public String getQq() {
        return this.qq;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "authopt/feedback/add";
    }

    public Integer getSubCategoryId() {
        return this.subCategoryId;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setCategoryId(Integer num) {
        this.categoryId = num;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setPics(String str) {
        this.pics = str;
    }

    public void setQq(String str) {
        this.qq = str;
    }

    public void setSubCategoryId(Integer num) {
        this.subCategoryId = num;
    }

    public void setSubject(String str) {
        this.subject = str;
    }
}
