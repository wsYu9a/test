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

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public void setEndOffset(long endOffset) {
        this.endOffset = endOffset;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setStartOffset(long startOffset) {
        this.startOffset = startOffset;
    }
}
