package com.martian.mibook.lib.yuewen.response;

import ba.k;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.mvvm.tts.service.BaseReadAloudService;

@k.h(name = "ywchapter")
/* loaded from: classes3.dex */
public class YWChapter extends Chapter {

    @k.a
    @k.b
    private Integer _id;

    @k.i
    @k.b
    private Long ccid;

    @k.b(name = BaseReadAloudService.f15168x)
    @k.f
    private Long chapterSort;

    @k.b(name = "title")
    private String chapterTitle;
    private Integer chargeType;

    @k.b
    private Integer freeStatus;

    @k.b
    private Integer isTaked;

    @k.b
    private Integer price;

    @k.b
    private String srcLink;

    @k.b
    private Integer vipflag;

    @k.b
    private Long words;

    public Long getCcid() {
        return this.ccid;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public String getChapterId() {
        return "" + this.ccid;
    }

    public Long getChapterSort() {
        return this.chapterSort;
    }

    public String getChapterTitle() {
        return this.chapterTitle;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public Integer getChargeType() {
        return this.chargeType;
    }

    public Integer getFreeStatus() {
        Integer num = this.freeStatus;
        if (num == null) {
            return 0;
        }
        return num;
    }

    public Integer getIsTaked() {
        Integer num = this.isTaked;
        if (num == null) {
            return 0;
        }
        return num;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public Integer getPrice() {
        Integer num = this.price;
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
        return this.chapterTitle;
    }

    public Integer getVipflag() {
        Integer num = this.vipflag;
        if (num == null) {
            return 0;
        }
        return num;
    }

    public Long getWords() {
        return this.words;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public boolean isFree() {
        return (getVipflag().intValue() == 1 && getIsTaked().intValue() == 0) ? false : true;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public boolean isVipChapter() {
        return getVipflag().intValue() == 1 && getFreeStatus().intValue() == 1;
    }

    public void setCcid(long j10) {
        this.ccid = Long.valueOf(j10);
    }

    public void setChapterSort(Long l10) {
        this.chapterSort = l10;
    }

    public void setChapterTitle(String str) {
        this.chapterTitle = str;
    }

    public void setChargeType(int i10) {
        this.chargeType = Integer.valueOf(i10);
    }

    public void setFreeStatus(Integer num) {
        this.freeStatus = num;
    }

    public void setIsTaked(Integer num) {
        this.isTaked = num;
    }

    public void setPrice(Integer num) {
        this.price = num;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public void setSrcLink(String str) {
        this.srcLink = str;
    }

    public void setVipflag(Integer num) {
        this.vipflag = num;
    }

    public void setWords(Long l10) {
        this.words = l10;
    }
}
