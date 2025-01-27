package com.martian.mibook.lib.model.data;

/* loaded from: classes3.dex */
public class MiBookShelfItem {

    /* renamed from: ca, reason: collision with root package name */
    public String f13983ca;
    public Integer cl;
    public Integer cp;
    public Integer cx;
    public Long opt;
    public String ss;
    public Integer top;

    public Integer getCidx() {
        return this.cx;
    }

    public String getClassify() {
        return this.f13983ca;
    }

    public Integer getContentLength() {
        return this.cl;
    }

    public Integer getContentPosition() {
        return this.cp;
    }

    public Long getDate() {
        return this.opt;
    }

    public String getSourceString() {
        return this.ss;
    }

    public Integer getTop() {
        return this.top;
    }

    public void setCidx(Integer num) {
        this.cx = num;
    }

    public void setClassify(String str) {
        this.f13983ca = str;
    }

    public void setContentLength(Integer num) {
        this.cl = num;
    }

    public void setContentPosition(Integer num) {
        this.cp = num;
    }

    public void setDate(Long l10) {
        this.opt = l10;
    }

    public void setSourceString(String str) {
        this.ss = str;
    }

    public void setTop(Integer num) {
        this.top = num;
    }
}
