package com.martian.mibook.lib.model.data;

import com.martian.libsupport.j;
import com.martian.libsupport.k;
import com.martian.mibook.lib.model.manager.BookManager;

@j.g(name = "newmibookstore")
/* loaded from: classes3.dex */
public class MiBookStoreItem {
    private static final int DELETE_FLAG_MASK = 65535;
    private static final int UPDATE_FLAG_MASK = -65536;

    @j.b
    @j.a
    @j.e(ascend = false, index = 2)
    private Integer _id;

    @j.b
    private Integer addFlag;

    @j.b
    private Long addTime;

    @j.b
    @j.h
    private String bookId;

    @j.b
    private String bookName;

    @j.b(name = "dirId")
    private Integer chapterSize;

    @j.b
    private String coverUrl;

    @j.b
    private Integer deleteFlag;

    @j.b
    private String dirName;

    @j.b
    @j.e(ascend = false, index = 0)
    private Boolean flagTop;

    @j.b
    @j.e(ascend = false, index = 1)
    private Long lastReadingTime;

    @j.b
    private Integer readingChapterIndex;

    @j.b
    private Integer readingContentLength;

    @j.b
    private Integer readingContentPos;

    @j.b
    private String sourceString;

    public MiBook buildMibook() {
        MiBook miBook = new MiBook();
        miBook.setBookId(getBookId());
        if (k.p(getBookName())) {
            miBook.setBookName(getSourceString());
        } else {
            miBook.setBookName(getBookName());
        }
        miBook.setSourceString(getSourceString());
        return miBook;
    }

    public boolean equals(Object o) {
        if (!(o instanceof MiBookStoreItem)) {
            return false;
        }
        MiBookStoreItem miBookStoreItem = (MiBookStoreItem) o;
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
        return this.dirName;
    }

    public Long getLastReadingTime() {
        return this.lastReadingTime;
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
        return str != null ? str.hashCode() : this.sourceString.hashCode();
    }

    public boolean isFlagTop() {
        Boolean bool = this.flagTop;
        return bool != null && bool.booleanValue();
    }

    public boolean isPromoteBook() {
        Integer num = this.readingChapterIndex;
        return num != null && num.intValue() == BookManager.f14020b;
    }

    public boolean isReaded() {
        Integer num = this.readingChapterIndex;
        return num != null && num.intValue() >= 0;
    }

    public boolean isRecommendBook() {
        Integer num = this.readingChapterIndex;
        return num != null && num.intValue() == BookManager.f14019a;
    }

    public void setAddFlag(Integer addFlag) {
        this.addFlag = addFlag;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setChapterSize(Integer chapterSize) {
        this.chapterSize = chapterSize;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        if (this.deleteFlag == null) {
            this.deleteFlag = deleteFlag;
        } else {
            this.deleteFlag = Integer.valueOf(deleteFlag.intValue() + (this.deleteFlag.intValue() & (-65536)));
        }
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public void setFlagTop(boolean flagTop) {
        this.flagTop = Boolean.valueOf(flagTop);
    }

    public void setHasUpdate(boolean hasUpdate) {
        Integer num = this.deleteFlag;
        if (num == null) {
            this.deleteFlag = Integer.valueOf(hasUpdate ? 65536 : 0);
        } else {
            this.deleteFlag = Integer.valueOf((num.intValue() & 65535) + (hasUpdate ? 65536 : 0));
        }
    }

    public void setLastReadingTime(Long lastReadingTime) {
        this.lastReadingTime = lastReadingTime;
    }

    public void setReadingChapterIndex(Integer readingChapterIndex) {
        this.readingChapterIndex = readingChapterIndex;
    }

    public void setReadingContentLength(Integer readingContentLength) {
        this.readingContentLength = readingContentLength;
    }

    public void setReadingContentPos(Integer readingContentPos) {
        this.readingContentPos = readingContentPos;
    }

    public void setSourceString(String zsId) {
        this.sourceString = zsId;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }
}
