package com.martian.mibook.account.request.book;

import com.martian.mibook.lib.account.request.auth.TYAuthParams;
import v8.a;

/* loaded from: classes3.dex */
public class MiBookPostCommentParams extends TYAuthParams {

    @a
    private String chapterId;

    @a
    private String chapterName;

    @a
    private String content;

    @a
    private String paragraphDesc;

    @a
    private Integer paragraphIdx;

    @a
    private Integer score;

    @a
    private String sourceId;

    @a
    private String sourceName;

    @a
    private Integer type;

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

    public String getParagraphDesc() {
        return this.paragraphDesc;
    }

    public Integer getParagraphIdx() {
        return this.paragraphIdx;
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

    public Integer getType() {
        return this.type;
    }

    public void setChapterId(String str) {
        this.chapterId = str;
    }

    public void setChapterName(String str) {
        this.chapterName = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setParagraphDesc(String str) {
        this.paragraphDesc = str;
    }

    public void setParagraphIdx(Integer num) {
        this.paragraphIdx = num;
    }

    public void setScore(Integer num) {
        this.score = num;
    }

    public void setSourceId(String str) {
        this.sourceId = str;
    }

    public void setSourceName(String str) {
        this.sourceName = str;
    }

    public void setType(Integer num) {
        this.type = num;
    }
}
