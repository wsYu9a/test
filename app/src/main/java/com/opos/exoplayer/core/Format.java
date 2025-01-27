package com.opos.exoplayer.core;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.video.ColorInfo;
import com.umeng.analytics.pro.am;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class Format implements Parcelable {
    public static final Parcelable.Creator<Format> CREATOR = new Parcelable.Creator<Format>() { // from class: com.opos.exoplayer.core.Format.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Format createFromParcel(Parcel parcel) {
            return new Format(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Format[] newArray(int i2) {
            return new Format[i2];
        }
    };
    private int A;

    /* renamed from: a */
    public final String f17491a;

    /* renamed from: b */
    public final int f17492b;

    /* renamed from: c */
    public final String f17493c;

    /* renamed from: d */
    public final Metadata f17494d;

    /* renamed from: e */
    public final String f17495e;

    /* renamed from: f */
    public final String f17496f;

    /* renamed from: g */
    public final int f17497g;

    /* renamed from: h */
    public final List<byte[]> f17498h;

    /* renamed from: i */
    public final DrmInitData f17499i;

    /* renamed from: j */
    public final int f17500j;
    public final int k;
    public final float l;
    public final int m;
    public final float n;
    public final int o;
    public final byte[] p;
    public final ColorInfo q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public final int v;
    public final long w;
    public final int x;
    public final String y;
    public final int z;

    /* renamed from: com.opos.exoplayer.core.Format$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<Format> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Format createFromParcel(Parcel parcel) {
            return new Format(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Format[] newArray(int i2) {
            return new Format[i2];
        }
    }

    Format(Parcel parcel) {
        this.f17491a = parcel.readString();
        this.f17495e = parcel.readString();
        this.f17496f = parcel.readString();
        this.f17493c = parcel.readString();
        this.f17492b = parcel.readInt();
        this.f17497g = parcel.readInt();
        this.f17500j = parcel.readInt();
        this.k = parcel.readInt();
        this.l = parcel.readFloat();
        this.m = parcel.readInt();
        this.n = parcel.readFloat();
        this.p = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.o = parcel.readInt();
        this.q = (ColorInfo) parcel.readParcelable(ColorInfo.class.getClassLoader());
        this.r = parcel.readInt();
        this.s = parcel.readInt();
        this.t = parcel.readInt();
        this.u = parcel.readInt();
        this.v = parcel.readInt();
        this.x = parcel.readInt();
        this.y = parcel.readString();
        this.z = parcel.readInt();
        this.w = parcel.readLong();
        int readInt = parcel.readInt();
        this.f17498h = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f17498h.add(parcel.createByteArray());
        }
        this.f17499i = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
        this.f17494d = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
    }

    Format(String str, String str2, String str3, String str4, int i2, int i3, int i4, int i5, float f2, int i6, float f3, byte[] bArr, int i7, ColorInfo colorInfo, int i8, int i9, int i10, int i11, int i12, int i13, String str5, int i14, long j2, List<byte[]> list, DrmInitData drmInitData, Metadata metadata) {
        this.f17491a = str;
        this.f17495e = str2;
        this.f17496f = str3;
        this.f17493c = str4;
        this.f17492b = i2;
        this.f17497g = i3;
        this.f17500j = i4;
        this.k = i5;
        this.l = f2;
        this.m = i6;
        this.n = f3;
        this.p = bArr;
        this.o = i7;
        this.q = colorInfo;
        this.r = i8;
        this.s = i9;
        this.t = i10;
        this.u = i11;
        this.v = i12;
        this.x = i13;
        this.y = str5;
        this.z = i14;
        this.w = j2;
        this.f17498h = list == null ? Collections.emptyList() : list;
        this.f17499i = drmInitData;
        this.f17494d = metadata;
    }

    public static Format a(String str, String str2, int i2, String str3) {
        return a(str, str2, i2, str3, (DrmInitData) null);
    }

    public static Format a(String str, String str2, int i2, String str3, DrmInitData drmInitData) {
        return a(str, str2, null, -1, i2, str3, -1, drmInitData, Long.MAX_VALUE, Collections.emptyList());
    }

    public static Format a(String str, String str2, long j2) {
        return new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j2, null, null, null);
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, int i4, int i5, float f2, List<byte[]> list, int i6, float f3, DrmInitData drmInitData) {
        return a(str, str2, str3, i2, i3, i4, i5, f2, list, i6, f3, (byte[]) null, -1, (ColorInfo) null, drmInitData);
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, int i4, int i5, float f2, List<byte[]> list, int i6, float f3, byte[] bArr, int i7, ColorInfo colorInfo, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i2, i3, i4, i5, f2, i6, f3, bArr, i7, colorInfo, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, drmInitData, null);
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, List<byte[]> list, DrmInitData drmInitData, int i9, String str4, Metadata metadata) {
        return new Format(str, null, str2, str3, i2, i3, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i4, i5, i6, i7, i8, i9, str4, -1, Long.MAX_VALUE, list, drmInitData, metadata);
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6, List<byte[]> list, DrmInitData drmInitData, int i7, String str4) {
        return a(str, str2, str3, i2, i3, i4, i5, i6, -1, -1, list, drmInitData, i7, str4, (Metadata) null);
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, int i4, int i5, List<byte[]> list, DrmInitData drmInitData, int i6, String str4) {
        return a(str, str2, str3, i2, i3, i4, i5, -1, list, drmInitData, i6, str4);
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, String str4, int i4, DrmInitData drmInitData) {
        return a(str, str2, str3, i2, i3, str4, i4, drmInitData, Long.MAX_VALUE, Collections.emptyList());
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, String str4, int i4, DrmInitData drmInitData, long j2, List<byte[]> list) {
        return new Format(str, null, str2, str3, i2, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i3, str4, i4, j2, list, drmInitData, null);
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, List<byte[]> list, String str4, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i2, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i3, str4, -1, Long.MAX_VALUE, list, drmInitData, null);
    }

    public static Format a(String str, String str2, String str3, int i2, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i2, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, drmInitData, null);
    }

    @TargetApi(24)
    private static void a(MediaFormat mediaFormat, ColorInfo colorInfo) {
        if (colorInfo == null) {
            return;
        }
        a(mediaFormat, "color-transfer", colorInfo.f19202c);
        a(mediaFormat, "color-standard", colorInfo.f19200a);
        a(mediaFormat, "color-range", colorInfo.f19201b);
        a(mediaFormat, "hdr-static-info", colorInfo.f19203d);
    }

    @TargetApi(16)
    private static void a(MediaFormat mediaFormat, String str, float f2) {
        if (f2 != -1.0f) {
            mediaFormat.setFloat(str, f2);
        }
    }

    @TargetApi(16)
    private static void a(MediaFormat mediaFormat, String str, int i2) {
        if (i2 != -1) {
            mediaFormat.setInteger(str, i2);
        }
    }

    @TargetApi(16)
    private static void a(MediaFormat mediaFormat, String str, String str2) {
        if (str2 != null) {
            mediaFormat.setString(str, str2);
        }
    }

    @TargetApi(16)
    private static void a(MediaFormat mediaFormat, String str, byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public int a() {
        int i2;
        int i3 = this.f17500j;
        if (i3 == -1 || (i2 = this.k) == -1) {
            return -1;
        }
        return i3 * i2;
    }

    public Format a(int i2) {
        return new Format(this.f17491a, this.f17495e, this.f17496f, this.f17493c, this.f17492b, i2, this.f17500j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, this.x, this.y, this.z, this.w, this.f17498h, this.f17499i, this.f17494d);
    }

    public Format a(int i2, int i3) {
        return new Format(this.f17491a, this.f17495e, this.f17496f, this.f17493c, this.f17492b, this.f17497g, this.f17500j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, i2, i3, this.x, this.y, this.z, this.w, this.f17498h, this.f17499i, this.f17494d);
    }

    public Format a(long j2) {
        return new Format(this.f17491a, this.f17495e, this.f17496f, this.f17493c, this.f17492b, this.f17497g, this.f17500j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, this.x, this.y, this.z, j2, this.f17498h, this.f17499i, this.f17494d);
    }

    public Format a(DrmInitData drmInitData) {
        return new Format(this.f17491a, this.f17495e, this.f17496f, this.f17493c, this.f17492b, this.f17497g, this.f17500j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, this.x, this.y, this.z, this.w, this.f17498h, drmInitData, this.f17494d);
    }

    public Format a(Metadata metadata) {
        return new Format(this.f17491a, this.f17495e, this.f17496f, this.f17493c, this.f17492b, this.f17497g, this.f17500j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, this.x, this.y, this.z, this.w, this.f17498h, this.f17499i, metadata);
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat b() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.f17496f);
        a(mediaFormat, am.N, this.y);
        a(mediaFormat, "max-input-size", this.f17497g);
        a(mediaFormat, "width", this.f17500j);
        a(mediaFormat, "height", this.k);
        a(mediaFormat, "frame-rate", this.l);
        a(mediaFormat, "rotation-degrees", this.m);
        a(mediaFormat, "channel-count", this.r);
        a(mediaFormat, "sample-rate", this.s);
        for (int i2 = 0; i2 < this.f17498h.size(); i2++) {
            mediaFormat.setByteBuffer("csd-" + i2, ByteBuffer.wrap(this.f17498h.get(i2)));
        }
        a(mediaFormat, this.q);
        return mediaFormat;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || Format.class != obj.getClass()) {
                return false;
            }
            Format format = (Format) obj;
            if (this.f17492b != format.f17492b || this.f17497g != format.f17497g || this.f17500j != format.f17500j || this.k != format.k || this.l != format.l || this.m != format.m || this.n != format.n || this.o != format.o || this.r != format.r || this.s != format.s || this.t != format.t || this.u != format.u || this.v != format.v || this.w != format.w || this.x != format.x || !com.opos.exoplayer.core.i.u.a(this.f17491a, format.f17491a) || !com.opos.exoplayer.core.i.u.a(this.y, format.y) || this.z != format.z || !com.opos.exoplayer.core.i.u.a(this.f17495e, format.f17495e) || !com.opos.exoplayer.core.i.u.a(this.f17496f, format.f17496f) || !com.opos.exoplayer.core.i.u.a(this.f17493c, format.f17493c) || !com.opos.exoplayer.core.i.u.a(this.f17499i, format.f17499i) || !com.opos.exoplayer.core.i.u.a(this.f17494d, format.f17494d) || !com.opos.exoplayer.core.i.u.a(this.q, format.q) || !Arrays.equals(this.p, format.p) || this.f17498h.size() != format.f17498h.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f17498h.size(); i2++) {
                if (!Arrays.equals(this.f17498h.get(i2), format.f17498h.get(i2))) {
                    return false;
                }
            }
        }
        return true;
    }

    public int hashCode() {
        if (this.A == 0) {
            String str = this.f17491a;
            int hashCode = str == null ? 0 : str.hashCode();
            String str2 = this.f17495e;
            int hashCode2 = str2 == null ? 0 : str2.hashCode();
            String str3 = this.f17496f;
            int hashCode3 = str3 == null ? 0 : str3.hashCode();
            String str4 = this.f17493c;
            int hashCode4 = str4 == null ? 0 : str4.hashCode();
            int i2 = this.f17492b;
            int i3 = this.f17500j;
            int i4 = this.k;
            int i5 = this.r;
            int i6 = this.s;
            String str5 = this.y;
            int hashCode5 = str5 == null ? 0 : str5.hashCode();
            int i7 = this.z;
            DrmInitData drmInitData = this.f17499i;
            int hashCode6 = drmInitData == null ? 0 : drmInitData.hashCode();
            Metadata metadata = this.f17494d;
            this.A = ((hashCode6 + ((((hashCode5 + ((((((((((((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + 527) * 31)) * 31)) * 31)) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + i6) * 31)) * 31) + i7) * 31)) * 31) + (metadata != null ? metadata.hashCode() : 0);
        }
        return this.A;
    }

    public String toString() {
        return "Format(" + this.f17491a + ", " + this.f17495e + ", " + this.f17496f + ", " + this.f17492b + ", " + this.y + ", [" + this.f17500j + ", " + this.k + ", " + this.l + "], [" + this.r + ", " + this.s + "])";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f17491a);
        parcel.writeString(this.f17495e);
        parcel.writeString(this.f17496f);
        parcel.writeString(this.f17493c);
        parcel.writeInt(this.f17492b);
        parcel.writeInt(this.f17497g);
        parcel.writeInt(this.f17500j);
        parcel.writeInt(this.k);
        parcel.writeFloat(this.l);
        parcel.writeInt(this.m);
        parcel.writeFloat(this.n);
        parcel.writeInt(this.p != null ? 1 : 0);
        byte[] bArr = this.p;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.o);
        parcel.writeParcelable(this.q, i2);
        parcel.writeInt(this.r);
        parcel.writeInt(this.s);
        parcel.writeInt(this.t);
        parcel.writeInt(this.u);
        parcel.writeInt(this.v);
        parcel.writeInt(this.x);
        parcel.writeString(this.y);
        parcel.writeInt(this.z);
        parcel.writeLong(this.w);
        int size = this.f17498h.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeByteArray(this.f17498h.get(i3));
        }
        parcel.writeParcelable(this.f17499i, 0);
        parcel.writeParcelable(this.f17494d, 0);
    }
}
