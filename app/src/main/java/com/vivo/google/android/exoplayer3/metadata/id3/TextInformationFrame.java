package com.vivo.google.android.exoplayer3.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.vivo.google.android.exoplayer3.util.Util;

/* loaded from: classes4.dex */
public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator<TextInformationFrame> CREATOR = new a();

    /* renamed from: b */
    public final String f27806b;

    /* renamed from: c */
    public final String f27807c;

    public static class a implements Parcelable.Creator<TextInformationFrame> {
        @Override // android.os.Parcelable.Creator
        public TextInformationFrame createFromParcel(Parcel parcel) {
            return new TextInformationFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TextInformationFrame[] newArray(int i2) {
            return new TextInformationFrame[i2];
        }
    }

    public TextInformationFrame(Parcel parcel) {
        super(parcel.readString());
        this.f27806b = parcel.readString();
        this.f27807c = parcel.readString();
    }

    public TextInformationFrame(String str, String str2, String str3) {
        super(str);
        this.f27806b = str2;
        this.f27807c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TextInformationFrame.class != obj.getClass()) {
            return false;
        }
        TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
        return this.f27803a.equals(textInformationFrame.f27803a) && Util.areEqual(this.f27806b, textInformationFrame.f27806b) && Util.areEqual(this.f27807c, textInformationFrame.f27807c);
    }

    public int hashCode() {
        int hashCode = (this.f27803a.hashCode() + 527) * 31;
        String str = this.f27806b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f27807c;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f27803a);
        parcel.writeString(this.f27806b);
        parcel.writeString(this.f27807c);
    }
}
