package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class ApkSignerData extends a implements Parcelable {
    public static final Parcelable.Creator<ApkSignerData> CREATOR = new Parcelable.Creator<ApkSignerData>() { // from class: com.opos.mobad.model.data.ApkSignerData.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ApkSignerData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            return new ApkSignerData(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ApkSignerData[] newArray(int i2) {
            return new ApkSignerData[i2];
        }
    };

    /* renamed from: a */
    public final String f21698a;

    /* renamed from: b */
    public final String f21699b;

    /* renamed from: c */
    public final String f21700c;

    /* renamed from: com.opos.mobad.model.data.ApkSignerData$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<ApkSignerData> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ApkSignerData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            return new ApkSignerData(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ApkSignerData[] newArray(int i2) {
            return new ApkSignerData[i2];
        }
    }

    public ApkSignerData(String str, String str2, String str3) {
        this.f21698a = str;
        this.f21699b = str2;
        this.f21700c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ApkSignerData{md5=" + this.f21698a + ", sha1='" + this.f21699b + "', sha256=" + this.f21700c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f21698a);
        parcel.writeString(this.f21699b);
        parcel.writeString(this.f21700c);
    }
}
