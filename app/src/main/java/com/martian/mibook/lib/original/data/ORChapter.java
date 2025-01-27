package com.martian.mibook.lib.original.data;

import ba.k;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.mvvm.tts.service.BaseReadAloudService;

@k.h(name = "or_chapters")
/* loaded from: classes3.dex */
public class ORChapter extends Chapter {

    @k.a
    @k.b
    private Integer _id;

    @k.b
    private String bookId;

    @k.i
    @k.b
    private Integer chapterId;

    @k.b(name = BaseReadAloudService.f15168x)
    @k.f
    private Integer chapterOrder;

    @k.b
    private Integer coins;

    @k.b
    private String srcLink;

    @k.b(name = "title")
    private String title;

    public String getBookId() {
        return this.bookId;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public String getChapterId() {
        return this.chapterId + "";
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

    public void setBookId(String str) {
        this.bookId = str;
    }

    public void setChapterId(Integer num) {
        this.chapterId = num;
    }

    public void setChapterName(String str) {
        this.title = str;
    }

    public void setChapterOrder(Integer num) {
        this.chapterOrder = num;
    }

    public void setCoins(Integer num) {
        this.coins = num;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public void setSrcLink(String str) {
        this.srcLink = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void set_id(Integer num) {
        this._id = num;
    }
}
