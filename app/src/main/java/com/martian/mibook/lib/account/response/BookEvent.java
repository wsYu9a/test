package com.martian.mibook.lib.account.response;

import com.martian.libsupport.k;
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
    private Integer value = 1;

    public BookEvent addChapterId(String ccid) {
        if (!k.p(ccid)) {
            getReadChapterIds().add(ccid);
        }
        return this;
    }

    public String getCcids() {
        String str = "";
        for (String str2 : getReadChapterIds()) {
            if (!k.p(str)) {
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

    public Integer getValue() {
        return this.value;
    }

    public void incrValue(int adderValue) {
        this.value = Integer.valueOf(this.value.intValue() + adderValue);
    }

    public BookEvent setChapterIndex(Integer chapterIndex) {
        if (chapterIndex.intValue() >= 0) {
            this.chapterIndex = chapterIndex;
        }
        return this;
    }

    public BookEvent setEventType(Integer eventType) {
        this.eventType = eventType;
        return this;
    }

    public BookEvent setFirstRead(Boolean firstRead) {
        if (this.firstRead == null) {
            this.firstRead = firstRead;
        }
        return this;
    }

    public void setReadChapterIds(List<String> readChapterIds) {
        this.readChapterIds = readChapterIds;
    }

    public BookEvent setRecommendId(String recommendId) {
        this.recommendId = recommendId;
        return this;
    }

    public BookEvent setSourceId(String sourceId) {
        this.sourceId = sourceId;
        return this;
    }

    public BookEvent setSourceName(String sourceName) {
        this.sourceName = sourceName;
        return this;
    }

    public BookEvent setValue(Integer value) {
        this.value = value;
        return this;
    }
}
