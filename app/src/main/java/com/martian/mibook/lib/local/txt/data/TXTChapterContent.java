package com.martian.mibook.lib.local.txt.data;

import com.martian.mibook.lib.model.data.abs.ChapterContent;

/* loaded from: classes3.dex */
public class TXTChapterContent extends ChapterContent {
    private String content;
    private Long endOffset;
    private String filepath;
    private Long startOffset;
    private String title;

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

    public void setContent(String content) {
        this.content = content;
    }

    public void setEndOffset(Long endOffset) {
        this.endOffset = endOffset;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public void setSrcLink(String srcLink) {
        throw new UnsupportedOperationException();
    }

    public void setStartOffset(Long startOffset) {
        this.startOffset = startOffset;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public String getContent(int start, int end) {
        return this.content.substring(start, end);
    }
}
