package com.martian.mibook.lib.model.data;

/* loaded from: classes3.dex */
public class BookSyncInfo {
    public String ca;
    public Integer cl;
    public Integer cp;
    public Integer cx;
    public Integer op;
    public Long opt;
    public String ss;
    public Integer top;
    public static final Integer OP_UPDATE = 1;
    public static final Integer OP_DELETE = 2;

    public Integer getCidx() {
        return this.cx;
    }

    public String getClassify() {
        return this.ca;
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

    public Integer getOp() {
        return this.op;
    }

    public String getSourceString() {
        return this.ss;
    }

    public Integer getTop() {
        return this.top;
    }

    public void setCidx(Integer cidx) {
        this.cx = cidx;
    }

    public void setClassify(String ca) {
        this.ca = ca;
    }

    public void setContentLength(Integer cl) {
        this.cl = cl;
    }

    public void setContentPosition(Integer cp) {
        this.cp = cp;
    }

    public void setDate(Long opt) {
        this.opt = opt;
    }

    public void setOp(int op) {
        this.op = Integer.valueOf(op);
    }

    public void setSourceString(String ss) {
        this.ss = ss;
    }

    public void setTop(Integer top) {
        this.top = top;
    }
}
