package com.martian.mibook.lib.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import ba.k;
import ba.l;
import ub.b;

@k.h(name = "mireading_records")
/* loaded from: classes3.dex */
public class MiReadingRecord implements Parcelable {
    private static final int CONTENT_INDEX_MASK = 268435455;
    public static final Parcelable.Creator<MiReadingRecord> CREATOR = new Parcelable.Creator<MiReadingRecord>() { // from class: com.martian.mibook.lib.model.data.MiReadingRecord.1
        @Override // android.os.Parcelable.Creator
        public MiReadingRecord createFromParcel(Parcel parcel) {
            return new MiReadingRecord(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public MiReadingRecord[] newArray(int i10) {
            return new MiReadingRecord[i10];
        }
    };
    public static final int RECORD_TYPE_INDEX = 0;
    private static final int RECORD_TYPE_MASK = -268435456;
    public static final int RECORD_TYPE_POS = 1;

    @k.b
    private Integer audiobook;

    @k.b
    private String bookId;

    @k.b
    private String bookName;

    @k.b
    private Integer chapterIndex;

    @k.b
    private String chapterLink;

    @k.b
    private String chapterTitle;

    @k.b
    private Integer contentIndex;
    private Integer contentLength;
    private String cover;

    @k.b
    @k.f(ascend = false)
    private Long lastReadingTime;

    @k.b
    private Integer recordRead;

    @k.g
    @k.b(name = "zsId")
    private String sourceString;

    /* renamed from: com.martian.mibook.lib.model.data.MiReadingRecord$1 */
    public class AnonymousClass1 implements Parcelable.Creator<MiReadingRecord> {
        @Override // android.os.Parcelable.Creator
        public MiReadingRecord createFromParcel(Parcel parcel) {
            return new MiReadingRecord(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public MiReadingRecord[] newArray(int i10) {
            return new MiReadingRecord[i10];
        }
    }

    public enum RecordType {
        Default(0),
        Record(10),
        FirstRead(30);

        private final int value;

        RecordType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    public /* synthetic */ MiReadingRecord(Parcel parcel, b bVar) {
        this(parcel);
    }

    private int getRecordRead() {
        if (this.recordRead == null) {
            setRecordRead(false);
        }
        return this.recordRead.intValue();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof MiReadingRecord) {
            return l.o(this.sourceString, ((MiReadingRecord) obj).sourceString);
        }
        return false;
    }

    public int getAudiobook() {
        Integer num = this.audiobook;
        if (num == null) {
            return 0;
        }
        return num.intValue();
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

    public String getChapterTitle() {
        return this.chapterTitle;
    }

    public Integer getContentIndex() {
        if (this.contentIndex == null) {
            setContentPos(0);
        }
        return Integer.valueOf(this.contentIndex.intValue() & CONTENT_INDEX_MASK);
    }

    public Integer getContentLength() {
        return this.contentLength;
    }

    public Integer getContentPos() {
        return getContentIndex();
    }

    public String getCover() {
        return this.cover;
    }

    public long getLastReadingTime() {
        Long l10 = this.lastReadingTime;
        if (l10 == null) {
            return -1L;
        }
        return l10.longValue();
    }

    public String getReadingStatus() {
        if (!l.q(getChapterTitle())) {
            return getChapterTitle();
        }
        return Math.max(0, getChapterIndex()) + "章";
    }

    public int getRecordType() {
        Integer num = this.contentIndex;
        if (num == null) {
            return 0;
        }
        return (num.intValue() & RECORD_TYPE_MASK) >> 28;
    }

    public String getSourceString() {
        return this.sourceString;
    }

    public int hashCode() {
        String str = this.sourceString;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public boolean isAudiobook() {
        Integer num = this.audiobook;
        return num != null && num.intValue() > 0;
    }

    public boolean isFirstRead() {
        if (getRecordRead() != RecordType.FirstRead.value) {
            return false;
        }
        this.recordRead = Integer.valueOf(RecordType.Record.value);
        return true;
    }

    public boolean needRecord() {
        return getRecordRead() == RecordType.FirstRead.value || getRecordRead() == RecordType.Record.value;
    }

    public void setAudiobook(Integer num) {
        this.audiobook = num;
    }

    public MiReadingRecord setBookName(String str) {
        this.bookName = str;
        return this;
    }

    public MiReadingRecord setChapterIndex(Integer num) {
        this.chapterIndex = num;
        return this;
    }

    public void setChapterTitle(String str) {
        this.chapterTitle = str;
    }

    public void setContentLength(Integer num) {
        this.contentLength = num;
    }

    public void setContentPos(Integer num) {
        if (num == null) {
            this.contentIndex = null;
        } else {
            this.contentIndex = Integer.valueOf(num.intValue() | 268435456);
        }
    }

    public void setCover(String str) {
        this.cover = str;
    }

    public void setLastReadingTime(Long l10) {
        this.lastReadingTime = l10;
    }

    public void setRecordRead(boolean z10) {
        this.recordRead = Integer.valueOf((z10 ? RecordType.FirstRead : RecordType.Default).value);
    }

    public void setRecordType(int i10) {
        Integer num = this.contentIndex;
        if (num == null) {
            this.contentIndex = Integer.valueOf(i10);
        } else {
            this.contentIndex = Integer.valueOf(((i10 << 28) + CONTENT_INDEX_MASK) & num.intValue());
        }
    }

    public MiReadingRecord setSourceString(String str) {
        this.sourceString = str;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeValue(this.chapterIndex);
        parcel.writeValue(this.contentIndex);
        parcel.writeValue(this.bookId);
        parcel.writeValue(this.sourceString);
        parcel.writeValue(this.chapterLink);
        parcel.writeValue(this.chapterTitle);
        parcel.writeValue(this.bookName);
        parcel.writeValue(this.audiobook);
    }

    public MiReadingRecord() {
    }

    private MiReadingRecord(Parcel parcel) {
        this.chapterIndex = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.contentIndex = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.bookId = (String) parcel.readValue(String.class.getClassLoader());
        this.sourceString = (String) parcel.readValue(String.class.getClassLoader());
        this.chapterLink = (String) parcel.readValue(String.class.getClassLoader());
        this.chapterTitle = (String) parcel.readValue(String.class.getClassLoader());
        this.bookName = (String) parcel.readValue(String.class.getClassLoader());
        this.audiobook = (Integer) parcel.readValue(String.class.getClassLoader());
    }
}
