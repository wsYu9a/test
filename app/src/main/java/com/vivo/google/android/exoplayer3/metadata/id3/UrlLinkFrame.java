package com.vivo.google.android.exoplayer3.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.vivo.google.android.exoplayer3.util.Util;

/* loaded from: classes4.dex */
public final class UrlLinkFrame extends Id3Frame {
    public static final Parcelable.Creator<UrlLinkFrame> CREATOR = new a();

    /* renamed from: b */
    public final String f27808b;

    /* renamed from: c */
    public final String f27809c;

    public static class a implements Parcelable.Creator<UrlLinkFrame> {
        @Override // android.os.Parcelable.Creator
        public UrlLinkFrame createFromParcel(Parcel parcel) {
            return new UrlLinkFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public UrlLinkFrame[] newArray(int i2) {
            return new UrlLinkFrame[i2];
        }
    }

    public UrlLinkFrame(Parcel parcel) {
        super(parcel.readString());
        this.f27808b = parcel.readString();
        this.f27809c = parcel.readString();
    }

    public UrlLinkFrame(String str, String str2, String str3) {
        super(str);
        this.f27808b = str2;
        this.f27809c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UrlLinkFrame.class != obj.getClass()) {
            return false;
        }
        UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
        return this.f27803a.equals(urlLinkFrame.f27803a) && Util.areEqual(this.f27808b, urlLinkFrame.f27808b) && Util.areEqual(this.f27809c, urlLinkFrame.f27809c);
    }

    public int hashCode() {
        int hashCode = (this.f27803a.hashCode() + 527) * 31;
        String str = this.f27808b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f27809c;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f27803a);
        parcel.writeString(this.f27808b);
        parcel.writeString(this.f27809c);
    }
}
