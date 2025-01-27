package com.martian.mibook.lib.yuewen.response;

import android.text.TextUtils;
import ba.k;
import com.martian.mibook.lib.model.data.abs.ChapterContent;

@k.h(name = "yw_chapter_content")
/* loaded from: classes3.dex */
public class YWChapterContent extends ChapterContent {

    @k.b
    private Long cbid;

    @k.g
    @k.b
    private Long ccid;

    @k.b
    private Integer chargeType;

    @k.b
    private String content;

    @k.b
    private Integer isTaked;

    @k.b
    private Integer price;

    @k.b
    private String srcLink;
    private String title;

    @k.b
    private Integer totalPrice;

    public long getCbid() {
        return this.cbid.longValue();
    }

    public long getCcid() {
        Long l10 = this.ccid;
        if (l10 == null) {
            return -1L;
        }
        return l10.longValue();
    }

    public Integer getChargeType() {
        return this.chargeType;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public String getContent(int i10, int i11) {
        return this.content.substring(i10, i11);
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public int getContentLength() {
        return this.content.length();
    }

    public int getIsTaked() {
        Integer num = this.isTaked;
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    public Integer getPrice() {
        return this.price;
    }

    public String getSrcLink() {
        return this.srcLink;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public String getTitle() {
        return this.title;
    }

    public Integer getTotalPrice() {
        return this.totalPrice;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public boolean isEmpty() {
        return TextUtils.isEmpty(this.content);
    }

    public void setCbid(long j10) {
        this.cbid = Long.valueOf(j10);
    }

    public void setCcid(long j10) {
        this.ccid = Long.valueOf(j10);
    }

    public void setChargeType(int i10) {
        this.chargeType = Integer.valueOf(i10);
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setIsTaked(int i10) {
        this.isTaked = Integer.valueOf(i10);
    }

    public void setPrice(int i10) {
        this.price = Integer.valueOf(i10);
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public void setSrcLink(String str) {
        this.srcLink = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTotalPrice(int i10) {
        this.totalPrice = Integer.valueOf(i10);
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public String getContent() {
        return this.content;
    }
}
