package com.martian.mibook.lib.original.data;

import ba.k;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.Response;

@k.h(name = "or_chapter_contents")
/* loaded from: classes3.dex */
public class ORChapterContent extends ChapterContent implements Response {

    @k.g
    @k.b
    private Integer chapterId;
    private Integer coins;

    @k.b
    private String content;
    private Integer isTaked;

    @k.b
    private String srcLink;

    @k.b
    private String title;

    public Integer getChapterId() {
        return this.chapterId;
    }

    public Integer getCoins() {
        return this.coins;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public String getContent(int i10, int i11) {
        return this.content.substring(i10, i11);
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

    public void setChapterId(Integer num) {
        this.chapterId = num;
    }

    public void setCoins(Integer num) {
        this.coins = num;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setIsTaked(Integer num) {
        this.isTaked = num;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public void setSrcLink(String str) {
        this.srcLink = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public String getContent() {
        return this.content;
    }
}
