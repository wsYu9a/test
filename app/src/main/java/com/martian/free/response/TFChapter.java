package com.martian.free.response;

import com.martian.libsupport.j;
import com.martian.mibook.lib.model.data.abs.Chapter;

@j.g(name = "tfchapter")
/* loaded from: classes2.dex */
public class TFChapter extends Chapter {

    @j.b
    @j.a
    private Integer _id;

    @j.b
    private String bid;
    private Integer chargeType;

    @j.b
    @j.h
    private String cid;

    @j.b
    private Long modifiedOn;
    private Integer price;

    @j.b
    private String title;

    @j.b
    private Long words;

    public String getBid() {
        return this.bid;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public Integer getChargeType() {
        Integer num = this.chargeType;
        return Integer.valueOf(num == null ? -1 : num.intValue());
    }

    public String getCid() {
        return this.cid;
    }

    public Long getModifiedOn() {
        return this.modifiedOn;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public Integer getPrice() {
        Integer num = this.price;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public String getSrcLink() {
        return "";
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public String getTitle() {
        return this.title;
    }

    public Long getWords() {
        return this.words;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public boolean isFree() {
        return true;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public boolean isVipChapter() {
        return false;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setModifiedOn(Long modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public void setSrcLink(String link) {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWords(Long words) {
        this.words = words;
    }
}
