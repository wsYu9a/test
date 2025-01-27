package com.ss.android.socialbase.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public class HttpHeader implements Parcelable, Comparable {
    public static final Parcelable.Creator<HttpHeader> CREATOR = new Parcelable.Creator<HttpHeader>() { // from class: com.ss.android.socialbase.downloader.model.HttpHeader.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public HttpHeader createFromParcel(Parcel parcel) {
            return new HttpHeader(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public HttpHeader[] newArray(int i2) {
            return new HttpHeader[i2];
        }
    };
    private final String name;
    private final String value;

    /* renamed from: com.ss.android.socialbase.downloader.model.HttpHeader$1 */
    static class AnonymousClass1 implements Parcelable.Creator<HttpHeader> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public HttpHeader createFromParcel(Parcel parcel) {
            return new HttpHeader(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public HttpHeader[] newArray(int i2) {
            return new HttpHeader[i2];
        }
    }

    public HttpHeader(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof HttpHeader)) {
            return 1;
        }
        HttpHeader httpHeader = (HttpHeader) obj;
        if (TextUtils.equals(this.name, httpHeader.getName())) {
            return 0;
        }
        String str = this.name;
        if (str == null) {
            return -1;
        }
        int compareTo = str.compareTo(httpHeader.getName());
        if (compareTo > 0) {
            return 1;
        }
        return compareTo < 0 ? -1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HttpHeader httpHeader = (HttpHeader) obj;
        return TextUtils.equals(this.name, httpHeader.name) && TextUtils.equals(this.value, httpHeader.value);
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.value;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "HttpHeader{name='" + this.name + "', value='" + this.value + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.name);
        parcel.writeString(this.value);
    }

    protected HttpHeader(Parcel parcel) {
        this.name = parcel.readString();
        this.value = parcel.readString();
    }
}
