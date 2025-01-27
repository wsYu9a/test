package com.opos.mobad.provider.record;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public class CookieData implements Parcelable {
    public static final Parcelable.Creator<CookieData> CREATOR = new Parcelable.Creator<CookieData>() { // from class: com.opos.mobad.provider.record.CookieData.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CookieData createFromParcel(Parcel parcel) {
            return new CookieData(parcel.readString(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CookieData[] newArray(int i2) {
            return new CookieData[i2];
        }
    };

    /* renamed from: a */
    public final String f23149a;

    /* renamed from: b */
    public final long f23150b;

    /* renamed from: com.opos.mobad.provider.record.CookieData$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<CookieData> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CookieData createFromParcel(Parcel parcel) {
            return new CookieData(parcel.readString(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CookieData[] newArray(int i2) {
            return new CookieData[i2];
        }
    }

    public CookieData(String str, long j2) {
        this.f23149a = str;
        this.f23150b = j2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(TextUtils.isEmpty(this.f23149a) ? "" : this.f23149a);
        parcel.writeLong(this.f23150b);
    }
}
