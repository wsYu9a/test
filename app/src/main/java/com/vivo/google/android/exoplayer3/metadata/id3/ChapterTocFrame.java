package com.vivo.google.android.exoplayer3.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.vivo.google.android.exoplayer3.util.Util;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new a();

    /* renamed from: b */
    public final String f27791b;

    /* renamed from: c */
    public final boolean f27792c;

    /* renamed from: d */
    public final boolean f27793d;

    /* renamed from: e */
    public final String[] f27794e;

    /* renamed from: f */
    public final Id3Frame[] f27795f;

    public static class a implements Parcelable.Creator<ChapterTocFrame> {
        @Override // android.os.Parcelable.Creator
        public ChapterTocFrame createFromParcel(Parcel parcel) {
            return new ChapterTocFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ChapterTocFrame[] newArray(int i2) {
            return new ChapterTocFrame[i2];
        }
    }

    public ChapterTocFrame(Parcel parcel) {
        super("CTOC");
        this.f27791b = parcel.readString();
        this.f27792c = parcel.readByte() != 0;
        this.f27793d = parcel.readByte() != 0;
        this.f27794e = parcel.createStringArray();
        int readInt = parcel.readInt();
        this.f27795f = new Id3Frame[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f27795f[i2] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public ChapterTocFrame(String str, boolean z, boolean z2, String[] strArr, Id3Frame[] id3FrameArr) {
        super("CTOC");
        this.f27791b = str;
        this.f27792c = z;
        this.f27793d = z2;
        this.f27794e = strArr;
        this.f27795f = id3FrameArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterTocFrame.class != obj.getClass()) {
            return false;
        }
        ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
        return this.f27792c == chapterTocFrame.f27792c && this.f27793d == chapterTocFrame.f27793d && Util.areEqual(this.f27791b, chapterTocFrame.f27791b) && Arrays.equals(this.f27794e, chapterTocFrame.f27794e) && Arrays.equals(this.f27795f, chapterTocFrame.f27795f);
    }

    public int hashCode() {
        int i2 = ((((this.f27792c ? 1 : 0) + 527) * 31) + (this.f27793d ? 1 : 0)) * 31;
        String str = this.f27791b;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f27791b);
        parcel.writeByte(this.f27792c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f27793d ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.f27794e);
        parcel.writeInt(this.f27795f.length);
        int i3 = 0;
        while (true) {
            Id3Frame[] id3FrameArr = this.f27795f;
            if (i3 >= id3FrameArr.length) {
                return;
            }
            parcel.writeParcelable(id3FrameArr[i3], 0);
            i3++;
        }
    }
}
