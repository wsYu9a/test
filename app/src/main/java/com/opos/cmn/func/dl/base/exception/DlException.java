package com.opos.cmn.func.dl.base.exception;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public final class DlException extends Exception implements Parcelable {
    public static final Parcelable.Creator<DlException> CREATOR = new Parcelable.Creator<DlException>() { // from class: com.opos.cmn.func.dl.base.exception.DlException.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DlException createFromParcel(Parcel parcel) {
            return new DlException(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DlException[] newArray(int i2) {
            return new DlException[i2];
        }
    };

    /* renamed from: a */
    private int f17330a;

    /* renamed from: b */
    private String f17331b;

    /* renamed from: c */
    private int f17332c;

    /* renamed from: com.opos.cmn.func.dl.base.exception.DlException$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<DlException> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DlException createFromParcel(Parcel parcel) {
            return new DlException(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DlException[] newArray(int i2) {
            return new DlException[i2];
        }
    }

    public DlException() {
        this.f17332c = -1;
        this.f17330a = 1000;
        this.f17331b = a.a(1000);
    }

    public DlException(int i2) {
        this.f17332c = -1;
        this.f17330a = i2;
        this.f17331b = a.a(i2);
    }

    public DlException(int i2, int i3) {
        this.f17332c = -1;
        this.f17330a = i2;
        this.f17332c = i3;
        this.f17331b = a.a(i2);
    }

    public DlException(int i2, int i3, String str) {
        this.f17332c = -1;
        this.f17330a = i2;
        this.f17332c = i3;
        this.f17331b = TextUtils.isEmpty(str) ? a.a(i2) : str;
    }

    public DlException(int i2, Throwable th) {
        super(th);
        this.f17332c = -1;
        this.f17330a = i2;
        this.f17331b = th.getMessage();
    }

    public DlException(int i2, Object... objArr) {
        this.f17332c = -1;
        this.f17330a = i2;
        this.f17331b = String.format(a.a(i2), objArr);
    }

    private DlException(Parcel parcel) {
        this.f17332c = -1;
        this.f17330a = parcel.readInt();
        this.f17331b = parcel.readString();
    }

    /* synthetic */ DlException(Parcel parcel, AnonymousClass1 anonymousClass1) {
        this(parcel);
    }

    public final int a() {
        return this.f17330a;
    }

    public final String b() {
        return this.f17331b;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return "DlException{code=" + this.f17330a + ", msg='" + this.f17331b + "', httpCode=" + this.f17332c + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f17330a);
        parcel.writeString(this.f17331b);
        parcel.writeInt(this.f17332c);
    }
}
