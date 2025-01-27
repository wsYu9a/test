package com.opos.exoplayer.core.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.i.u;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new Parcelable.Creator<ChapterTocFrame>() { // from class: com.opos.exoplayer.core.metadata.id3.ChapterTocFrame.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ChapterTocFrame createFromParcel(Parcel parcel) {
            return new ChapterTocFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ChapterTocFrame[] newArray(int i2) {
            return new ChapterTocFrame[i2];
        }
    };

    /* renamed from: a */
    public final String f19126a;

    /* renamed from: b */
    public final boolean f19127b;

    /* renamed from: c */
    public final boolean f19128c;

    /* renamed from: d */
    public final String[] f19129d;

    /* renamed from: e */
    private final Id3Frame[] f19130e;

    /* renamed from: com.opos.exoplayer.core.metadata.id3.ChapterTocFrame$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<ChapterTocFrame> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ChapterTocFrame createFromParcel(Parcel parcel) {
            return new ChapterTocFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ChapterTocFrame[] newArray(int i2) {
            return new ChapterTocFrame[i2];
        }
    }

    ChapterTocFrame(Parcel parcel) {
        super("CTOC");
        this.f19126a = parcel.readString();
        this.f19127b = parcel.readByte() != 0;
        this.f19128c = parcel.readByte() != 0;
        this.f19129d = parcel.createStringArray();
        int readInt = parcel.readInt();
        this.f19130e = new Id3Frame[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f19130e[i2] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public ChapterTocFrame(String str, boolean z, boolean z2, String[] strArr, Id3Frame[] id3FrameArr) {
        super("CTOC");
        this.f19126a = str;
        this.f19127b = z;
        this.f19128c = z2;
        this.f19129d = strArr;
        this.f19130e = id3FrameArr;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || ChapterTocFrame.class != obj.getClass()) {
                return false;
            }
            ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
            if (this.f19127b != chapterTocFrame.f19127b || this.f19128c != chapterTocFrame.f19128c || !u.a(this.f19126a, chapterTocFrame.f19126a) || !Arrays.equals(this.f19129d, chapterTocFrame.f19129d) || !Arrays.equals(this.f19130e, chapterTocFrame.f19130e)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.f19127b;
        boolean z2 = this.f19128c;
        String str = this.f19126a;
        return (((((z ? 1 : 0) + 527) * 31) + (z2 ? 1 : 0)) * 31) + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f19126a);
        parcel.writeByte(this.f19127b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f19128c ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.f19129d);
        parcel.writeInt(this.f19130e.length);
        for (Id3Frame id3Frame : this.f19130e) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }
}
