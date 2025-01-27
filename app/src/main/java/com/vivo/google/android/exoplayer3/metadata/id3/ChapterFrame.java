package com.vivo.google.android.exoplayer3.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.vivo.google.android.exoplayer3.util.Util;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class ChapterFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterFrame> CREATOR = new a();

    /* renamed from: b */
    public final String f27785b;

    /* renamed from: c */
    public final int f27786c;

    /* renamed from: d */
    public final int f27787d;

    /* renamed from: e */
    public final long f27788e;

    /* renamed from: f */
    public final long f27789f;

    /* renamed from: g */
    public final Id3Frame[] f27790g;

    public static class a implements Parcelable.Creator<ChapterFrame> {
        @Override // android.os.Parcelable.Creator
        public ChapterFrame createFromParcel(Parcel parcel) {
            return new ChapterFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ChapterFrame[] newArray(int i2) {
            return new ChapterFrame[i2];
        }
    }

    public ChapterFrame(Parcel parcel) {
        super("CHAP");
        this.f27785b = parcel.readString();
        this.f27786c = parcel.readInt();
        this.f27787d = parcel.readInt();
        this.f27788e = parcel.readLong();
        this.f27789f = parcel.readLong();
        int readInt = parcel.readInt();
        this.f27790g = new Id3Frame[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f27790g[i2] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public ChapterFrame(String str, int i2, int i3, long j2, long j3, Id3Frame[] id3FrameArr) {
        super("CHAP");
        this.f27785b = str;
        this.f27786c = i2;
        this.f27787d = i3;
        this.f27788e = j2;
        this.f27789f = j3;
        this.f27790g = id3FrameArr;
    }

    @Override // com.vivo.google.android.exoplayer3.metadata.id3.Id3Frame, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterFrame.class != obj.getClass()) {
            return false;
        }
        ChapterFrame chapterFrame = (ChapterFrame) obj;
        return this.f27786c == chapterFrame.f27786c && this.f27787d == chapterFrame.f27787d && this.f27788e == chapterFrame.f27788e && this.f27789f == chapterFrame.f27789f && Util.areEqual(this.f27785b, chapterFrame.f27785b) && Arrays.equals(this.f27790g, chapterFrame.f27790g);
    }

    public int hashCode() {
        int i2 = (((((((this.f27786c + 527) * 31) + this.f27787d) * 31) + ((int) this.f27788e)) * 31) + ((int) this.f27789f)) * 31;
        String str = this.f27785b;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f27785b);
        parcel.writeInt(this.f27786c);
        parcel.writeInt(this.f27787d);
        parcel.writeLong(this.f27788e);
        parcel.writeLong(this.f27789f);
        parcel.writeInt(this.f27790g.length);
        for (Id3Frame id3Frame : this.f27790g) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }
}
