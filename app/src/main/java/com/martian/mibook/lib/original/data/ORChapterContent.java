package com.martian.mibook.lib.original.data;

import com.martian.libsupport.j;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.Response;

@j.g(name = "or_chapter_contents")
/* loaded from: classes2.dex */
public class ORChapterContent extends ChapterContent implements Response {

    @j.b
    @j.f
    private Integer chapterId;
    private Integer coins;

    @j.b
    private String content;
    private Integer isTaked;

    @j.b
    private String srcLink;

    @j.b
    private String title;

    public Integer getChapterId() {
        return this.chapterId;
    }

    public Integer getCoins() {
        return this.coins;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public String getContent(int start, int end) {
        return this.content.substring(start, end);
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public int getContentLength() {
        return this.content.length();
    }

    public Integer getIsTaked() {
        return this.isTaked;
    }

    public String getSrcLink() {
        return this.srcLink;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public String getTitle() {
        return this.title;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public boolean isEmpty() {
        String str = this.content;
        return str == null || str.length() == 0;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setIsTaked(Integer isTaked) {
        this.isTaked = isTaked;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public void setSrcLink(String srcLink) {
        this.srcLink = srcLink;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }
}
