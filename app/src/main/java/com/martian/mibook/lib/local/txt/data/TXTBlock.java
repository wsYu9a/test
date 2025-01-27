package com.martian.mibook.lib.local.txt.data;

/* loaded from: classes3.dex */
public class TXTBlock {
    private String charset;
    private long endOffset;
    private String filepath;
    private int index;
    private long startOffset;

    public String getCharset() {
        return this.charset;
    }

    public long getEndOffset() {
        return this.endOffset;
    }

    public String getFilePath() {
        return this.filepath;
    }

    public int getIndex() {
        return this.index;
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    public void setCharset(String str) {
        this.charset = str;
    }

    public void setEndOffset(long j10) {
        this.endOffset = j10;
    }

    public void setFilepath(String str) {
        this.filepath = str;
    }

    public void setIndex(int i10) {
        this.index = i10;
    }

    public void setStartOffset(long j10) {
        this.startOffset = j10;
    }
}
