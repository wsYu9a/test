package com.martian.mibook.lib.model.data;

import ba.k;
import vb.e;

@k.h(name = "micache_records")
/* loaded from: classes3.dex */
public class MiCacheItem {

    @k.b
    private Integer chapterIndex;

    @k.b
    private String chapterLink;

    @k.b
    private Integer chapterSize;

    @k.b
    private String chapterTitle;

    @k.g
    @k.b
    private String sourceStr;

    public MiCacheItem() {
    }

    public Integer getChapterIndex() {
        return this.chapterIndex;
    }

    public String getChapterLink() {
        return this.chapterLink;
    }

    public Integer getChapterSize() {
        return this.chapterSize;
    }

    public String getChapterTitle() {
        return this.chapterTitle;
    }

    public String getSourceId() {
        return e.d(this.sourceStr);
    }

    public String getSourceName() {
        return e.e(this.sourceStr);
    }

    public String getSourceStr() {
        return this.sourceStr;
    }

    public void setChapterIndex(Integer num) {
        this.chapterIndex = num;
    }

    public void setChapterLink(String str) {
        this.chapterLink = str;
    }

    public void setChapterSize(Integer num) {
        this.chapterSize = num;
    }

    public void setChapterTitle(String str) {
        this.chapterTitle = str;
    }

    public void setSourceStr(String str) {
        this.sourceStr = str;
    }

    public MiCacheItem(String str, String str2, Integer num, Integer num2, String str3, String str4) {
        this.sourceStr = e.j(str, str2);
        this.chapterIndex = num;
        this.chapterSize = num2;
        this.chapterTitle = str3;
        this.chapterLink = str4;
    }
}
