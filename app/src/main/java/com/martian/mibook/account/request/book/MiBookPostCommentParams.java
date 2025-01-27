package com.martian.mibook.account.request.book;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.auth.TYAuthParams;

/* loaded from: classes3.dex */
public class MiBookPostCommentParams extends TYAuthParams {

    @a
    private String chapterId;

    @a
    private String chapterName;

    @a
    private String content;

    @a
    private Integer score;

    @a
    private String sourceId;

    @a
    private String sourceName;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "post_comment.do";
    }

    public String getChapterId() {
        return this.chapterId;
    }

    public String getChapterName() {
        return this.chapterName;
    }

    public String getContent() {
        return this.content;
    }

    public Integer getScore() {
        return this.score;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
