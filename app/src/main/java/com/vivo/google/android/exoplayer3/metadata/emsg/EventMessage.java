package com.vivo.google.android.exoplayer3.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import com.vivo.google.android.exoplayer3.metadata.Metadata;
import com.vivo.google.android.exoplayer3.util.Util;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class EventMessage implements Metadata.Entry {
    public static final Parcelable.Creator<EventMessage> CREATOR = new a();

    /* renamed from: a */
    public final String f27774a;

    /* renamed from: b */
    public final String f27775b;

    /* renamed from: c */
    public final long f27776c;

    /* renamed from: d */
    public final long f27777d;

    /* renamed from: e */
    public final byte[] f27778e;

    /* renamed from: f */
    public int f27779f;

    public static class a implements Parcelable.Creator<EventMessage> {
        @Override // android.os.Parcelable.Creator
        public EventMessage createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public EventMessage[] newArray(int i2) {
            return new EventMessage[i2];
        }
    }

    public EventMessage(Parcel parcel) {
        this.f27774a = parcel.readString();
        this.f27775b = parcel.readString();
        this.f27776c = parcel.readLong();
        this.f27777d = parcel.readLong();
        this.f27778e = parcel.createByteArray();
    }

    public EventMessage(String str, String str2, long j2, long j3, byte[] bArr) {
        this.f27774a = str;
        this.f27775b = str2;
        this.f27776c = j2;
        this.f27777d = j3;
        this.f27778e = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || EventMessage.class != obj.getClass()) {
            return false;
        }
        EventMessage eventMessage = (EventMessage) obj;
        return this.f27776c == eventMessage.f27776c && this.f27777d == eventMessage.f27777d && Util.areEqual(this.f27774a, eventMessage.f27774a) && Util.areEqual(this.f27775b, eventMessage.f27775b) && Arrays.equals(this.f27778e, eventMessage.f27778e);
    }

    public int hashCode() {
        if (this.f27779f == 0) {
            String str = this.f27774a;
            int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
            String str2 = this.f27775b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            long j2 = this.f27776c;
            int i2 = (hashCode2 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.f27777d;
            this.f27779f = ((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + Arrays.hashCode(this.f27778e);
        }
        return this.f27779f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f27774a);
        parcel.writeString(this.f27775b);
        parcel.writeLong(this.f27776c);
        parcel.writeLong(this.f27777d);
        parcel.writeByteArray(this.f27778e);
    }
}
