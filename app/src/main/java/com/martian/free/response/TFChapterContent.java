package com.martian.free.response;

import android.text.TextUtils;
import com.martian.libsupport.j;
import com.martian.mibook.lib.model.data.abs.ChapterContent;

@j.g(name = "tf_chapter_content")
/* loaded from: classes2.dex */
public class TFChapterContent extends ChapterContent {

    @j.b
    private String bid;
    private Integer chargeType;

    @j.b
    @j.f
    private String cid;

    @j.b
    private String content;
    private Integer isTaked;
    private Integer price;
    private String title;

    public String getBid() {
        return this.bid;
    }

    public Integer getChargeType() {
        Integer num = this.chargeType;
        return Integer.valueOf(num == null ? -1 : num.intValue());
    }

    public String getCid() {
        return this.cid;
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

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public String getTitle() {
        return this.title;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public boolean isEmpty() {
        return TextUtils.isEmpty(this.content);
    }

    public boolean isTaked() {
        return getIsTaked() > 0;
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

    public void setContent(String content) {
        this.content = content;
    }

    public void setIsTaked(Integer isTaked) {
        this.isTaked = isTaked;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public void setSrcLink(String srcLink) {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }
}
