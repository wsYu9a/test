package com.martian.free.response;

import android.text.TextUtils;
import ba.k;
import com.martian.mibook.lib.model.data.abs.ChapterContent;

@k.h(name = "tf_chapter_content")
/* loaded from: classes3.dex */
public class TFChapterContent extends ChapterContent {

    @k.b
    private String bid;
    private Integer chargeType;

    @k.g
    @k.b
    private String cid;

    @k.b
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

    public void setBid(String str) {
        this.bid = str;
    }

    public void setChargeType(Integer num) {
        this.chargeType = num;
    }

    public void setCid(String str) {
        this.cid = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setIsTaked(Integer num) {
        this.isTaked = num;
    }

    public void setPrice(Integer num) {
        this.price = num;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public void setSrcLink(String str) {
    }

    public void setTitle(String str) {
        this.title = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterContent
    public String getContent() {
        return this.content;
    }
}
