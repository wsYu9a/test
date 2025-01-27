package com.ss.android.downloadlib.a.a;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.ss.android.downloadlib.a.a.b.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b[] newArray(int i10) {
            return new b[i10];
        }
    };

    /* renamed from: a */
    public int f21114a;

    /* renamed from: b */
    public int f21115b;

    /* renamed from: c */
    public String f21116c;

    /* renamed from: d */
    public int f21117d;

    /* renamed from: e */
    public String f21118e;

    /* renamed from: f */
    public String f21119f;

    /* renamed from: com.ss.android.downloadlib.a.a.b$1 */
    public static class AnonymousClass1 implements Parcelable.Creator<b> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b[] newArray(int i10) {
            return new b[i10];
        }
    }

    public b() {
        this.f21116c = "";
        this.f21118e = "";
        this.f21119f = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f21114a == bVar.f21114a && this.f21115b == bVar.f21115b) {
                String str = this.f21116c;
                if (str != null) {
                    return str.equals(bVar.f21116c);
                }
                if (bVar.f21116c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i10 = ((this.f21114a * 31) + this.f21115b) * 31;
        String str = this.f21116c;
        return i10 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f21114a);
        parcel.writeInt(this.f21115b);
        parcel.writeString(this.f21116c);
        parcel.writeString(this.f21118e);
        parcel.writeString(this.f21119f);
        parcel.writeInt(this.f21117d);
    }

    public b(Parcel parcel) {
        this.f21116c = "";
        this.f21118e = "";
        this.f21119f = "";
        this.f21114a = parcel.readInt();
        this.f21115b = parcel.readInt();
        this.f21116c = parcel.readString();
        this.f21118e = parcel.readString();
        this.f21119f = parcel.readString();
        this.f21117d = parcel.readInt();
    }
}
