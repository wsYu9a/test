package com.martian.mibook.data;

/* loaded from: classes3.dex */
public class TypoItem {
    private String cid;
    private String correctWords;
    private Integer end;
    private Integer pIdx;
    private Integer start;
    private String typo;

    public String getCid() {
        return this.cid;
    }

    public String getCorrectWords() {
        return this.correctWords;
    }

    public Integer getEnd() {
        return this.end;
    }

    public Integer getStart() {
        return this.start;
    }

    public String getTypo() {
        return this.typo;
    }

    public Integer getpIdx() {
        return this.pIdx;
    }

    public void setCid(String str) {
        this.cid = str;
    }

    public void setCorrectWords(String str) {
        this.correctWords = str;
    }

    public void setEnd(Integer num) {
        this.end = num;
    }

    public void setStart(Integer num) {
        this.start = num;
    }

    public void setTypo(String str) {
        this.typo = str;
    }

    public void setpIdx(Integer num) {
        this.pIdx = num;
    }
}
