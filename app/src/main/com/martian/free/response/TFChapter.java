package com.martian.free.response;

import ba.k;
import com.martian.mibook.lib.model.data.abs.Chapter;

@k.h(name = "tfchapter")
/* loaded from: classes3.dex */
public class TFChapter extends Chapter {

    @k.a
    @k.b
    private Integer _id;

    @k.b
    private String bid;
    private Integer chargeType;

    @k.i
    @k.b
    private String cid;

    @k.b
    private Long modifiedOn;
    private Integer price;

    @k.b
    private String title;

    @k.b
    private Long words;

    public String getBid() {
        return this.bid;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public String getChapterId() {
        return this.cid;
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

    public void setBid(String str) {
        this.bid = str;
    }

    public void setChargeType(Integer num) {
        this.chargeType = num;
    }

    public void setCid(String str) {
        this.cid = str;
    }

    public void setModifiedOn(Long l10) {
        this.modifiedOn = l10;
    }

    public void setPrice(Integer num) {
        this.price = num;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public void setSrcLink(String str) {
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setWords(Long l10) {
        this.words = l10;
    }
}
