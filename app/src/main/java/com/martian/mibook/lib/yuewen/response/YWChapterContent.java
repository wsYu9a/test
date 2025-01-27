package com.martian.mibook.lib.yuewen.response;

import android.text.TextUtils;
import com.martian.libsupport.j;
import com.martian.mibook.lib.model.data.abs.ChapterContent;

@j.g(name = "yw_chapter_content")
/* loaded from: classes4.dex */
public class YWChapterContent extends ChapterContent {

    @j.b
    private Long cbid;

    @j.b
    @j.f
    private Long ccid;

    @j.b
    private Integer chargeType;

    @j.b
    private String content;

    @j.b
    private Integer isTaked;

    @j.b
    private Integer price;

    @j.b
    private String srcLink;
    private String title;

    @j.b
    private Integer totalPrice;

    public long getCbid() {
        return this.cbid.longValue();
    }

    public long getCcid() {
        Long l = this.ccid;
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public Integer getChargeType() {
        return this.chargeType;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public String getContent(int start, int end) {
        return this.content.substring(start, end);
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

    public void setCbid(long cbid) {
        this.cbid = Long.valueOf(cbid);
    }

    public void setCcid(long ccid) {
        this.ccid = Long.valueOf(ccid);
    }

    public void setChargeType(int chargeType) {
        this.chargeType = Integer.valueOf(chargeType);
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setIsTaked(int isTaked) {
        this.isTaked = Integer.valueOf(isTaked);
    }

    public void setPrice(int price) {
        this.price = Integer.valueOf(price);
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public void setSrcLink(String srcLink) {
        this.srcLink = srcLink;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = Integer.valueOf(totalPrice);
    }

    public String getContent() {
        return this.content;
    }
}
