package com.martian.free.request;

import com.martian.mibook.lib.account.request.auth.TYAuthParams;
import v8.a;

/* loaded from: classes3.dex */
public class TFBuyChapterParams extends TYAuthParams {

    @a
    private String chapterId;

    @a
    private String chapterName;

    @a
    private Integer price;

    @a
    private String sourceId;

    @a
    private String sourceName;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "ty/buy_chapter";
    }

    public String getChapterId() {
        return this.chapterId;
    }

    public String getChapterName() {
        return this.chapterName;
    }

    public Integer getPrice() {
        return this.price;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setChapterId(String str) {
        this.chapterId = str;
    }

    public void setChapterName(String str) {
        this.chapterName = str;
    }

    public void setPrice(Integer num) {
        this.price = num;
    }

    public void setSourceId(String str) {
        this.sourceId = str;
    }

    public void setSourceName(String str) {
        this.sourceName = str;
    }
}
