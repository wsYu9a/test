package com.martian.mibook.lib.local.txt.data;

import ba.k;
import ba.l;
import com.martian.mibook.lib.model.data.abs.Chapter;

@k.h(name = "txtchapters")
/* loaded from: classes3.dex */
public class TXTChapter extends Chapter {

    @k.a
    @k.b
    private Integer _id;

    @k.b
    private String charset;

    @k.b
    private Long endOffset;

    @k.b
    private String filepath;

    @k.b
    private Long startOffset;

    @k.b
    private String title;

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public String getChapterId() {
        return "" + this._id;
    }

    public String getCharset() {
        return this.charset;
    }

    public Long getEndOffset() {
        return this.endOffset;
    }

    public String getFilepath() {
        return this.filepath;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public String getSrcLink() {
        return this.filepath;
    }

    public Long getStartOffset() {
        return this.startOffset;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public String getTitle() {
        return this.title;
    }

    public void setCharset(String str) {
        this.charset = str;
    }

    public void setEndOffset(Long l10) {
        this.endOffset = l10;
    }

    public void setFilepath(String str) {
        this.filepath = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public void setSrcLink(String str) {
        throw new UnsupportedOperationException();
    }

    public void setStartOffset(Long l10) {
        this.startOffset = l10;
    }

    public void setTitle(String str) {
        this.title = l.B(str);
    }
}
