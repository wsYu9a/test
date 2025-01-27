package com.martian.mibook.lib.local.txt.data;

import com.martian.libsupport.j;
import com.martian.libsupport.k;
import com.martian.mibook.lib.model.data.abs.Chapter;

@j.g(name = "txtchapters")
/* loaded from: classes3.dex */
public class TXTChapter extends Chapter {

    @j.b
    @j.a
    private Integer _id;

    @j.b
    private String charset;

    @j.b
    private Long endOffset;

    @j.b
    private String filepath;

    @j.b
    private Long startOffset;

    @j.b
    private String title;

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

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public void setEndOffset(Long endOffset) {
        this.endOffset = endOffset;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public void setSrcLink(String link) {
        throw new UnsupportedOperationException();
    }

    public void setStartOffset(Long startOffset) {
        this.startOffset = startOffset;
    }

    public void setTitle(String title) {
        this.title = k.x(title);
    }
}
