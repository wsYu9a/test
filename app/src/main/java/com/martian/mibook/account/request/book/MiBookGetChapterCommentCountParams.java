package com.martian.mibook.account.request.book;

import com.martian.mibook.lib.account.request.TYAuthoptParams;
import v8.a;

/* loaded from: classes3.dex */
public class MiBookGetChapterCommentCountParams extends TYAuthoptParams {

    @a
    private String chapterIds;

    @a
    private Integer page;

    @a
    private String sourceId;

    @a
    private String sourceName;

    @Override // com.martian.mibook.lib.account.request.TYAuthoptParams
    public String getAuthoptMethod() {
        return "comment_counts.do";
    }

    public String getChapterIds() {
        return this.chapterIds;
    }

    public Integer getPage() {
        return this.page;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setChapterIds(String str) {
        this.chapterIds = str;
    }

    public void setPage(Integer num) {
        this.page = num;
    }

    public void setSourceId(String str) {
        this.sourceId = str;
    }

    public void setSourceName(String str) {
        this.sourceName = str;
    }
}
