package com.vivo.google.android.exoplayer3.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.vivo.google.android.exoplayer3.util.Util;

/* loaded from: classes4.dex */
public final class CommentFrame extends Id3Frame {
    public static final Parcelable.Creator<CommentFrame> CREATOR = new a();

    /* renamed from: b */
    public final String f27796b;

    /* renamed from: c */
    public final String f27797c;

    /* renamed from: d */
    public final String f27798d;

    public static class a implements Parcelable.Creator<CommentFrame> {
        @Override // android.os.Parcelable.Creator
        public CommentFrame createFromParcel(Parcel parcel) {
            return new CommentFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CommentFrame[] newArray(int i2) {
            return new CommentFrame[i2];
        }
    }

    public CommentFrame(Parcel parcel) {
        super("COMM");
        this.f27796b = parcel.readString();
        this.f27797c = parcel.readString();
        this.f27798d = parcel.readString();
    }

    public CommentFrame(String str, String str2, String str3) {
        super("COMM");
        this.f27796b = str;
        this.f27797c = str2;
        this.f27798d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CommentFrame.class != obj.getClass()) {
            return false;
        }
        CommentFrame commentFrame = (CommentFrame) obj;
        return Util.areEqual(this.f27797c, commentFrame.f27797c) && Util.areEqual(this.f27796b, commentFrame.f27796b) && Util.areEqual(this.f27798d, commentFrame.f27798d);
    }

    public int hashCode() {
        String str = this.f27796b;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.f27797c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f27798d;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f27803a);
        parcel.writeString(this.f27796b);
        parcel.writeString(this.f27798d);
    }
}
