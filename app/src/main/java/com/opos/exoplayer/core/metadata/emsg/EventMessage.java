package com.opos.exoplayer.core.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.metadata.Metadata;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class EventMessage implements Metadata.Entry {
    public static final Parcelable.Creator<EventMessage> CREATOR = new Parcelable.Creator<EventMessage>() { // from class: com.opos.exoplayer.core.metadata.emsg.EventMessage.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public EventMessage createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public EventMessage[] newArray(int i2) {
            return new EventMessage[i2];
        }
    };

    /* renamed from: a */
    public final String f19098a;

    /* renamed from: b */
    public final String f19099b;

    /* renamed from: c */
    public final long f19100c;

    /* renamed from: d */
    public final long f19101d;

    /* renamed from: e */
    public final long f19102e;

    /* renamed from: f */
    public final byte[] f19103f;

    /* renamed from: g */
    private int f19104g;

    /* renamed from: com.opos.exoplayer.core.metadata.emsg.EventMessage$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<EventMessage> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public EventMessage createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public EventMessage[] newArray(int i2) {
            return new EventMessage[i2];
        }
    }

    EventMessage(Parcel parcel) {
        this.f19098a = parcel.readString();
        this.f19099b = parcel.readString();
        this.f19101d = parcel.readLong();
        this.f19100c = parcel.readLong();
        this.f19102e = parcel.readLong();
        this.f19103f = parcel.createByteArray();
    }

    public EventMessage(String str, String str2, long j2, long j3, byte[] bArr, long j4) {
        this.f19098a = str;
        this.f19099b = str2;
        this.f19100c = j2;
        this.f19102e = j3;
        this.f19103f = bArr;
        this.f19101d = j4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || EventMessage.class != obj.getClass()) {
                return false;
            }
            EventMessage eventMessage = (EventMessage) obj;
            if (this.f19101d != eventMessage.f19101d || this.f19100c != eventMessage.f19100c || this.f19102e != eventMessage.f19102e || !u.a(this.f19098a, eventMessage.f19098a) || !u.a(this.f19099b, eventMessage.f19099b) || !Arrays.equals(this.f19103f, eventMessage.f19103f)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (this.f19104g == 0) {
            String str = this.f19098a;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.f19099b;
            int hashCode2 = (((hashCode + 527) * 31) + (str2 != null ? str2.hashCode() : 0)) * 31;
            long j2 = this.f19101d;
            int i2 = (hashCode2 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.f19100c;
            int i3 = (i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            long j4 = this.f19102e;
            this.f19104g = ((i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31) + Arrays.hashCode(this.f19103f);
        }
        return this.f19104g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f19098a);
        parcel.writeString(this.f19099b);
        parcel.writeLong(this.f19101d);
        parcel.writeLong(this.f19100c);
        parcel.writeLong(this.f19102e);
        parcel.writeByteArray(this.f19103f);
    }
}
