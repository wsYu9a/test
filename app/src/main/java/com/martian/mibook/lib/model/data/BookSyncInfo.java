package com.martian.mibook.lib.model.data;

/* loaded from: classes3.dex */
public class BookSyncInfo {

    /* renamed from: ca, reason: collision with root package name */
    private String f13982ca;
    private Integer cl;
    private Integer cp;
    private Integer cx;
    private Integer op;
    private Long opt;
    private String ss;
    private Integer top;
    public static final Integer OP_UPDATE = 1;
    public static final Integer OP_DELETE = 2;

    public String getCategory() {
        return this.f13982ca;
    }

    public Integer getCidx() {
        return this.cx;
    }

    public Integer getContentLength() {
        return this.cl;
    }

    public Integer getContentPosition() {
        return this.cp;
    }

    public Integer getOp() {
        return this.op;
    }

    public Long getOpt() {
        return this.opt;
    }

    public String getSourceString() {
        return this.ss;
    }

    public Integer getTop() {
        return this.top;
    }

    public void setCategory(String str) {
        this.f13982ca = str;
    }

    public void setCidx(Integer num) {
        this.cx = num;
    }

    public void setContentLength(Integer num) {
        this.cl = num;
    }

    public void setContentPosition(Integer num) {
        this.cp = num;
    }

    public void setOp(int i10) {
        this.op = Integer.valueOf(i10);
    }

    public void setOpt(Long l10) {
        this.opt = l10;
    }

    public void setSourceString(String str) {
        this.ss = str;
    }

    public void setTop(Integer num) {
        this.top = num;
    }
}
