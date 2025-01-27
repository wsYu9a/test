package com.martian.mibook.lib.account.response;

import ba.l;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class BookEvent {
    private Integer chapterIndex;
    private Integer eventType;
    private Boolean firstRead;
    private List<String> readChapterIds;
    private String recommendId;
    private String sourceId;
    private String sourceName;

    /* renamed from: t */
    private Long f13981t;
    private Integer value = 1;

    public BookEvent addChapterId(String str) {
        if (!l.q(str)) {
            getReadChapterIds().add(str);
        }
        return this;
    }

    public String getCcids() {
        String str = "";
        for (String str2 : getReadChapterIds()) {
            if (!l.q(str)) {
                str = str + ",";
            }
            str = str + str2;
        }
        return str;
    }

    public Integer getChapterIndex() {
        return this.chapterIndex;
    }

    public Integer getEventType() {
        return this.eventType;
    }

    public boolean getFirstRead() {
        Boolean bool = this.firstRead;
        return bool != null && bool.booleanValue();
    }

    public List<String> getReadChapterIds() {
        if (this.readChapterIds == null) {
            this.readChapterIds = new ArrayList();
        }
        return this.readChapterIds;
    }

    public String getRecommendId() {
        return this.recommendId;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public Long getT() {
        return this.f13981t;
    }

    public Integer getValue() {
        return this.value;
    }

    public void incrValue(int i10) {
        this.value = Integer.valueOf(this.value.intValue() + i10);
    }

    public BookEvent setChapterIndex(Integer num) {
        if (num.intValue() >= 0) {
            this.chapterIndex = num;
        }
        return this;
    }

    public BookEvent setEventType(Integer num) {
        this.eventType = num;
        return this;
    }

    public BookEvent setFirstRead(Boolean bool) {
        if (this.firstRead == null) {
            this.firstRead = bool;
        }
        return this;
    }

    public void setReadChapterIds(List<String> list) {
        this.readChapterIds = list;
    }

    public BookEvent setRecommendId(String str) {
        this.recommendId = str;
        return this;
    }

    public BookEvent setSourceId(String str) {
        this.sourceId = str;
        return this;
    }

    public BookEvent setSourceName(String str) {
        this.sourceName = str;
        return this;
    }

    public BookEvent setT(Long l10) {
        this.f13981t = l10;
        return this;
    }

    public BookEvent setValue(Integer num) {
        this.value = num;
        return this;
    }
}
