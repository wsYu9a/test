package com.martian.mibook.lib.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.martian.libsupport.j;

@j.g(name = "mireading_records")
/* loaded from: classes.dex */
public class MiReadingRecord implements Parcelable {
    private static final int CONTENT_INDEX_MASK = 65535;
    private static final int CONTENT_SIZE_MASK = -65536;
    public static final Parcelable.Creator<MiReadingRecord> CREATOR = new Parcelable.Creator<MiReadingRecord>() { // from class: com.martian.mibook.lib.model.data.MiReadingRecord.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiReadingRecord createFromParcel(Parcel in) {
            return new MiReadingRecord(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiReadingRecord[] newArray(int size) {
            return new MiReadingRecord[size];
        }
    };

    @j.b
    private String bookId;

    @j.b
    private String bookName;

    @j.b
    private Integer chapterIndex;

    @j.b
    private String chapterLink;

    @j.b
    private String chapterTitle;

    @j.b
    private Integer contentIndex;
    private boolean isSelect;

    @j.b
    @j.e(ascend = false)
    private Long lastReadingTime;

    @j.b
    private Integer recordRead;

    @j.b(name = "zsId")
    @j.f
    private String sourceString;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBookId() {
        return this.bookId;
    }

    public String getBookName() {
        return this.bookName;
    }

    public int getChapterIndex() {
        Integer num = this.chapterIndex;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getChapterLink() {
        return this.chapterLink;
    }

    public String getChapterTitle() {
        return this.chapterTitle;
    }

    public Integer getContentIndex() {
        return Integer.valueOf(this.contentIndex.intValue() & 65535);
    }

    public Integer getContentSize() {
        return Integer.valueOf((this.contentIndex.intValue() & (-65536)) >>> 16);
    }

    public long getLastReadingTime() {
        Long l = this.lastReadingTime;
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public int getRecordRead() {
        Integer num = this.recordRead;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getSourceString() {
        return this.sourceString;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public boolean isWithAd() {
        return "withAd".equalsIgnoreCase(this.chapterLink);
    }

    public MiReadingRecord setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public MiReadingRecord setChapterIndex(Integer chapterIndex) {
        this.chapterIndex = chapterIndex;
        return this;
    }

    public void setChapterLink(String chapterLink) {
        this.chapterLink = chapterLink;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public MiReadingRecord setContentIndex(Integer contentIndex) {
        if (contentIndex == null) {
            return this;
        }
        if (this.contentIndex == null) {
            this.contentIndex = contentIndex;
        } else {
            this.contentIndex = Integer.valueOf(contentIndex.intValue() + (this.contentIndex.intValue() & (-65536)));
        }
        return this;
    }

    public void setContentSize(Integer contentSize) {
        if (contentSize == null) {
            return;
        }
        if (this.contentIndex == null) {
            this.contentIndex = Integer.valueOf(contentSize.intValue() << 16);
        } else {
            this.contentIndex = Integer.valueOf((contentSize.intValue() << 16) + (this.contentIndex.intValue() & 65535));
        }
    }

    public void setLastReadingTime(Long lastReadingTime) {
        this.lastReadingTime = lastReadingTime;
    }

    public void setRecordRead(Integer recordRead) {
        this.recordRead = recordRead;
    }

    public void setSelect(boolean select) {
        this.isSelect = select;
    }

    public MiReadingRecord setSourceString(String zsId) {
        this.sourceString = zsId;
        return this;
    }

    public void setWithAd(boolean withAd) {
        this.chapterLink = withAd ? "withAd" : "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeValue(this.chapterIndex);
        parcel.writeValue(this.contentIndex);
        parcel.writeValue(this.bookId);
        parcel.writeValue(this.sourceString);
        parcel.writeValue(this.chapterLink);
        parcel.writeValue(this.chapterTitle);
        parcel.writeValue(this.bookName);
    }

    public MiReadingRecord() {
        this.isSelect = false;
    }

    public void setRecordRead(boolean z) {
        this.recordRead = Integer.valueOf(z ? 1 : 0);
    }

    private MiReadingRecord(Parcel in) {
        this.isSelect = false;
        this.chapterIndex = (Integer) in.readValue(Integer.class.getClassLoader());
        this.contentIndex = (Integer) in.readValue(Integer.class.getClassLoader());
        this.bookId = (String) in.readValue(String.class.getClassLoader());
        this.sourceString = (String) in.readValue(String.class.getClassLoader());
        this.chapterLink = (String) in.readValue(String.class.getClassLoader());
        this.chapterTitle = (String) in.readValue(String.class.getClassLoader());
        this.bookName = (String) in.readValue(String.class.getClassLoader());
    }
}
