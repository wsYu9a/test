package com.martian.mibook.lib.yuewen.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.auth.TYAuthParams;

/* loaded from: classes4.dex */
public class YWBuyChapterParams extends TYAuthParams {

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

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
