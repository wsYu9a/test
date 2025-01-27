package com.martian.mibook.lib.local.txt.data;

import com.martian.mibook.lib.model.data.abs.ChapterContent;

/* loaded from: classes3.dex */
public class TXTChapterContent extends ChapterContent {
    private String content;
    private Long endOffset;
    private String filepath;
    private Long startOffset;
    private String title;

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public String getContent() {
        return this.content;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public int getContentLength() {
        String str = this.content;
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    public Long getEndOffset() {
        return this.endOffset;
    }

    public String getFilepath() {
        return this.filepath;
    }

    public Long getStartOffset() {
        return this.startOffset;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public String getTitle() {
        return this.title;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public boolean isEmpty() {
        return getContentLength() == 0;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setEndOffset(Long l10) {
        this.endOffset = l10;
    }

    public void setFilepath(String str) {
        this.filepath = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public void setSrcLink(String str) {
        throw new UnsupportedOperationException();
    }

    public void setStartOffset(Long l10) {
        this.startOffset = l10;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public String getContent(int i10, int i11) {
        return this.content.substring(i10, i11);
    }
}
