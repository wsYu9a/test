package com.martian.mibook.lib.original.data;

import com.martian.libsupport.j;
import com.martian.mibook.lib.model.data.abs.Chapter;

@j.g(name = "or_chapters")
/* loaded from: classes2.dex */
public class ORChapter extends Chapter {

    @j.b
    @j.a
    private Integer _id;

    @j.b
    private String bookId;

    @j.b
    @j.h
    private Integer chapterId;

    @j.b(name = "chapterIndex")
    @j.e
    private Integer chapterOrder;

    @j.b
    private Integer coins;

    @j.b
    private String srcLink;

    @j.b(name = "title")
    private String title;

    public String getBookId() {
        return this.bookId;
    }

    public Integer getChapterId() {
        return this.chapterId;
    }

    public Integer getChapterOrder() {
        return this.chapterOrder;
    }

    public Integer getCoins() {
        return this.coins;
    }

    public Integer getIndex() {
        return this.chapterOrder;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public Integer getPrice() {
        Integer num = this.coins;
        if (num == null) {
            return 0;
        }
        return num;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public String getSrcLink() {
        return this.srcLink;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public String getTitle() {
        return this.title;
    }

    public Integer get_id() {
        return this._id;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public boolean isFree() {
        Integer num = this.coins;
        return num == null || num.intValue() <= 0;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public boolean isVipChapter() {
        return !isFree();
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public void setChapterName(String chapterName) {
        this.title = chapterName;
    }

    public void setChapterOrder(Integer chapterOrder) {
        this.chapterOrder = chapterOrder;
    }

    public void setCoins(Integer coin) {
        this.coins = coin;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public void setSrcLink(String link) {
        this.srcLink = link;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }
}
