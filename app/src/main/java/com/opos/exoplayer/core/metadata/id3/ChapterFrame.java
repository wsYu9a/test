package com.opos.exoplayer.core.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.i.u;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class ChapterFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterFrame> CREATOR = new Parcelable.Creator<ChapterFrame>() { // from class: com.opos.exoplayer.core.metadata.id3.ChapterFrame.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ChapterFrame createFromParcel(Parcel parcel) {
            return new ChapterFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ChapterFrame[] newArray(int i2) {
            return new ChapterFrame[i2];
        }
    };

    /* renamed from: a */
    public final String f19120a;

    /* renamed from: b */
    public final int f19121b;

    /* renamed from: c */
    public final int f19122c;

    /* renamed from: d */
    public final long f19123d;

    /* renamed from: e */
    public final long f19124e;

    /* renamed from: g */
    private final Id3Frame[] f19125g;

    /* renamed from: com.opos.exoplayer.core.metadata.id3.ChapterFrame$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<ChapterFrame> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ChapterFrame createFromParcel(Parcel parcel) {
            return new ChapterFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ChapterFrame[] newArray(int i2) {
            return new ChapterFrame[i2];
        }
    }

    ChapterFrame(Parcel parcel) {
        super("CHAP");
        this.f19120a = parcel.readString();
        this.f19121b = parcel.readInt();
        this.f19122c = parcel.readInt();
        this.f19123d = parcel.readLong();
        this.f19124e = parcel.readLong();
        int readInt = parcel.readInt();
        this.f19125g = new Id3Frame[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f19125g[i2] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public ChapterFrame(String str, int i2, int i3, long j2, long j3, Id3Frame[] id3FrameArr) {
        super("CHAP");
        this.f19120a = str;
        this.f19121b = i2;
        this.f19122c = i3;
        this.f19123d = j2;
        this.f19124e = j3;
        this.f19125g = id3FrameArr;
    }

    @Override // com.opos.exoplayer.core.metadata.id3.Id3Frame, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || ChapterFrame.class != obj.getClass()) {
                return false;
            }
            ChapterFrame chapterFrame = (ChapterFrame) obj;
            if (this.f19121b != chapterFrame.f19121b || this.f19122c != chapterFrame.f19122c || this.f19123d != chapterFrame.f19123d || this.f19124e != chapterFrame.f19124e || !u.a(this.f19120a, chapterFrame.f19120a) || !Arrays.equals(this.f19125g, chapterFrame.f19125g)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i2 = this.f19121b;
        int i3 = this.f19122c;
        int i4 = (int) this.f19123d;
        int i5 = (int) this.f19124e;
        String str = this.f19120a;
        return (str != null ? str.hashCode() : 0) + ((((((((i2 + 527) * 31) + i3) * 31) + i4) * 31) + i5) * 31);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f19120a);
        parcel.writeInt(this.f19121b);
        parcel.writeInt(this.f19122c);
        parcel.writeLong(this.f19123d);
        parcel.writeLong(this.f19124e);
        parcel.writeInt(this.f19125g.length);
        for (Id3Frame id3Frame : this.f19125g) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }
}
