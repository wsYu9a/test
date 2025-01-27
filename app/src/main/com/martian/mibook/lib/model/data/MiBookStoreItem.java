package com.martian.mibook.lib.model.data;

import android.text.TextUtils;
import ba.k;
import ba.l;
import com.martian.mibook.lib.model.manager.BookManager;
import hf.e;

@k.h(name = "newmibookstore")
/* loaded from: classes3.dex */
public class MiBookStoreItem {
    private static final int DELETE_FLAG_MASK = 65535;
    private static final int UPDATE_FLAG_MASK = -65536;

    @k.a
    @k.b
    @k.f(ascend = false, index = 2)
    private Integer _id;

    @k.b
    private Integer addFlag;

    @k.b
    private Long addTime;

    @k.i
    @k.b
    private String bookId;

    @k.b
    private String bookName;

    @k.b(name = "dirId")
    private Integer chapterSize;

    @k.b
    private String coverUrl;

    @k.b
    private Integer deleteFlag;

    @k.b
    private String dirName;

    @k.b
    @k.f(ascend = false, index = 0)
    private Boolean flagTop;

    @k.b
    private Integer lastReadChapterSize;

    @k.b
    @k.f(ascend = false, index = 1)
    private Long lastReadingTime;

    @k.b
    private Integer readingChapterIndex;

    @k.b
    private Integer readingContentLength;

    @k.b
    private Integer readingContentPos;

    @k.b
    private String sourceString;

    public boolean equals(Object obj) {
        if (!(obj instanceof MiBookStoreItem)) {
            return false;
        }
        MiBookStoreItem miBookStoreItem = (MiBookStoreItem) obj;
        String str = this.bookId;
        if (str != null) {
            String str2 = miBookStoreItem.bookId;
            return str2 != null && str.equals(str2);
        }
        String str3 = miBookStoreItem.sourceString;
        return str3 != null && str3.equals(this.sourceString);
    }

    public Integer getAddFlag() {
        return this.addFlag;
    }

    public Long getAddTime() {
        return this.addTime;
    }

    public String getBookId() {
        return this.bookId;
    }

    public String getBookName() {
        return this.bookName;
    }

    public Integer getChapterSize() {
        return this.chapterSize;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public Integer getDeleteFlag() {
        Integer num = this.deleteFlag;
        if (num == null) {
            return null;
        }
        return Integer.valueOf(num.intValue() & 65535);
    }

    public String getDirName() {
        return l.q(this.dirName) ? BookrackCategoryManager.UN_CATEGORY : this.dirName;
    }

    public int getLastReadChapterSize() {
        Integer num = this.lastReadChapterSize;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Long getLastReadingTime() {
        return this.lastReadingTime;
    }

    public Boolean getRawFlagTop() {
        return this.flagTop;
    }

    public Integer getReadingChapterIndex() {
        return this.readingChapterIndex;
    }

    public Integer getReadingContentLength() {
        return this.readingContentLength;
    }

    public Integer getReadingContentPos() {
        return this.readingContentPos;
    }

    public String getSourceString() {
        if (TextUtils.isEmpty(this.sourceString) && !TextUtils.isEmpty(this.bookId)) {
            this.sourceString = this.bookId.replace(e.f26694a, "|");
        }
        return this.sourceString;
    }

    public Integer get_id() {
        return this._id;
    }

    public boolean hasUpdate() {
        Integer num = this.deleteFlag;
        return (num == null || (num.intValue() & (-65536)) == 0) ? false : true;
    }

    public int hashCode() {
        String str = this.bookId;
        if (str != null) {
            return str.hashCode();
        }
        String str2 = this.sourceString;
        if (str2 == null) {
            return 0;
        }
        return str2.hashCode();
    }

    public boolean isFlagTop() {
        Boolean bool = this.flagTop;
        return bool != null && bool.booleanValue();
    }

    public boolean isPromoteBook() {
        Integer num = this.readingChapterIndex;
        return num != null && num.intValue() == BookManager.f13985j;
    }

    public boolean isReaded() {
        Integer num = this.readingChapterIndex;
        return num != null && num.intValue() >= 0;
    }

    public boolean isRecommendBook() {
        Integer num = this.readingChapterIndex;
        return num != null && num.intValue() == BookManager.f13984i;
    }

    public void setAddFlag(Integer num) {
        this.addFlag = num;
    }

    public void setAddTime(Long l10) {
        this.addTime = l10;
    }

    public void setBookId(String str) {
        this.bookId = str;
    }

    public void setBookName(String str) {
        this.bookName = str;
    }

    public void setChapterSize(Integer num) {
        this.chapterSize = num;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setDeleteFlag(Integer num) {
        if (this.deleteFlag == null) {
            this.deleteFlag = num;
        } else {
            this.deleteFlag = Integer.valueOf(num.intValue() + (this.deleteFlag.intValue() & (-65536)));
        }
    }

    public void setDirName(String str) {
        this.dirName = str;
    }

    public void setFlagTop(boolean z10) {
        this.flagTop = Boolean.valueOf(z10);
    }

    public void setHasUpdate(boolean z10) {
        Integer num = this.deleteFlag;
        if (num == null) {
            this.deleteFlag = Integer.valueOf(z10 ? 65536 : 0);
        } else {
            this.deleteFlag = Integer.valueOf((num.intValue() & 65535) + (z10 ? 65536 : 0));
        }
    }

    public void setLastReadChapterSize(Integer num) {
        this.lastReadChapterSize = num;
    }

    public void setLastReadingTime(Long l10) {
        this.lastReadingTime = l10;
    }

    public void setReadingChapterIndex(Integer num) {
        this.readingChapterIndex = num;
    }

    public void setReadingContentLength(Integer num) {
        this.readingContentLength = num;
    }

    public void setReadingContentPos(Integer num) {
        this.readingContentPos = num;
    }

    public void setSourceString(String str) {
        this.sourceString = str;
    }

    public void set_id(Integer num) {
        this._id = num;
    }
}
