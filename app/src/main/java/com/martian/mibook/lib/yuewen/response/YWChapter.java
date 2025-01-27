package com.martian.mibook.lib.yuewen.response;

import com.martian.libsupport.j;
import com.martian.mibook.lib.model.data.abs.Chapter;

@j.g(name = "ywchapter")
/* loaded from: classes4.dex */
public class YWChapter extends Chapter {

    @j.b
    @j.a
    private Integer _id;

    @j.b
    @j.h
    private Long ccid;

    @j.b(name = "chapterIndex")
    @j.e
    private Long chapterSort;

    @j.b(name = "title")
    private String chapterTitle;
    private Integer chargeType;

    @j.b
    private Integer freeStatus;

    @j.b
    private Integer isTaked;

    @j.b
    private Integer price;

    @j.b
    private String srcLink;

    @j.b
    private Integer vipflag;

    @j.b
    private Long words;

    public Long getCcid() {
        return this.ccid;
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

    public void setCcid(long ccid) {
        this.ccid = Long.valueOf(ccid);
    }

    public void setChapterSort(Long chapterSort) {
        this.chapterSort = chapterSort;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public void setChargeType(int chargeType) {
        this.chargeType = Integer.valueOf(chargeType);
    }

    public void setFreeStatus(Integer freeStatus) {
        this.freeStatus = freeStatus;
    }

    public void setIsTaked(Integer isTaked) {
        this.isTaked = isTaked;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public void setSrcLink(String link) {
        this.srcLink = link;
    }

    public void setVipflag(Integer vipflag) {
        this.vipflag = vipflag;
    }

    public void setWords(Long words) {
        this.words = words;
    }
}
