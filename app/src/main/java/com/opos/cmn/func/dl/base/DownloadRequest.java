package com.opos.cmn.func.dl.base;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes4.dex */
public class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new Parcelable.Creator<DownloadRequest>() { // from class: com.opos.cmn.func.dl.base.DownloadRequest.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DownloadRequest createFromParcel(Parcel parcel) {
            return new DownloadRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DownloadRequest[] newArray(int i2) {
            return new DownloadRequest[i2];
        }
    };

    /* renamed from: a */
    public final String f17191a;

    /* renamed from: b */
    public final String f17192b;

    /* renamed from: c */
    public String f17193c;

    /* renamed from: d */
    public final int f17194d;

    /* renamed from: e */
    public final String f17195e;

    /* renamed from: f */
    public final int f17196f;

    /* renamed from: g */
    public final boolean f17197g;

    /* renamed from: h */
    public final boolean f17198h;

    /* renamed from: i */
    public final boolean f17199i;

    /* renamed from: j */
    public final Map<String, String> f17200j;

    /* renamed from: com.opos.cmn.func.dl.base.DownloadRequest$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<DownloadRequest> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DownloadRequest createFromParcel(Parcel parcel) {
            return new DownloadRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DownloadRequest[] newArray(int i2) {
            return new DownloadRequest[i2];
        }
    }

    public static class a {

        /* renamed from: a */
        public boolean f17201a;

        /* renamed from: b */
        private String f17202b;

        /* renamed from: c */
        private String f17203c;

        /* renamed from: d */
        private String f17204d;

        /* renamed from: e */
        private int f17205e;

        /* renamed from: f */
        private String f17206f;

        /* renamed from: g */
        private int f17207g;

        /* renamed from: h */
        private boolean f17208h;

        /* renamed from: i */
        private boolean f17209i;

        /* renamed from: j */
        private Map<String, String> f17210j;

        public a(String str) {
            this.f17202b = str;
        }

        public a a(String str) {
            this.f17206f = str;
            return this;
        }

        public a a(boolean z) {
            this.f17209i = z;
            return this;
        }

        public DownloadRequest a(Context context) {
            if (TextUtils.isEmpty(this.f17202b) || context == null) {
                throw new IllegalArgumentException("download url or context should not be null");
            }
            if (TextUtils.isEmpty(this.f17203c)) {
                this.f17203c = context.getExternalCacheDir().getAbsolutePath();
            }
            this.f17207g = com.opos.cmn.func.dl.base.h.a.a(this.f17202b, this.f17203c);
            return new DownloadRequest(this);
        }

        public a b(String str) {
            this.f17203c = str;
            return this;
        }

        public a b(boolean z) {
            this.f17208h = z;
            return this;
        }

        public a c(String str) {
            this.f17204d = str;
            return this;
        }

        public a c(boolean z) {
            this.f17201a = z;
            return this;
        }
    }

    private DownloadRequest(Parcel parcel) {
        this.f17191a = parcel.readString();
        this.f17192b = parcel.readString();
        this.f17193c = parcel.readString();
        this.f17194d = parcel.readInt();
        this.f17195e = parcel.readString();
        this.f17196f = parcel.readInt();
        this.f17197g = parcel.readByte() != 0;
        this.f17198h = parcel.readByte() != 0;
        this.f17199i = parcel.readByte() != 0;
        this.f17200j = parcel.readHashMap(Map.class.getClassLoader());
    }

    /* synthetic */ DownloadRequest(Parcel parcel, AnonymousClass1 anonymousClass1) {
        this(parcel);
    }

    private DownloadRequest(a aVar) {
        this.f17191a = aVar.f17202b;
        this.f17192b = aVar.f17203c;
        this.f17193c = aVar.f17204d;
        this.f17194d = aVar.f17205e;
        this.f17195e = aVar.f17206f;
        this.f17197g = aVar.f17201a;
        this.f17198h = aVar.f17208h;
        this.f17196f = aVar.f17207g;
        this.f17199i = aVar.f17209i;
        this.f17200j = aVar.f17210j;
    }

    /* synthetic */ DownloadRequest(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            DownloadRequest downloadRequest = (DownloadRequest) obj;
            if (!androidx.core.graphics.a.a(this.f17191a, downloadRequest.f17191a) || !androidx.core.graphics.a.a(this.f17192b, downloadRequest.f17192b)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f17191a, this.f17192b});
    }

    public String toString() {
        return "DownloadRequest{url='" + this.f17191a + "', dirPath='" + this.f17192b + "', fileName='" + this.f17193c + "', priority=" + this.f17194d + ", md5='" + this.f17195e + "', downloadId=" + this.f17196f + ", autoRetry=" + this.f17197g + ", downloadIfExist=" + this.f17198h + ", allowMobileDownload=" + this.f17199i + ", headerMap=" + this.f17200j + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f17191a);
        parcel.writeString(this.f17192b);
        parcel.writeString(this.f17193c);
        parcel.writeInt(this.f17194d);
        parcel.writeString(this.f17195e);
        parcel.writeInt(this.f17196f);
        parcel.writeInt(this.f17197g ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f17198h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f17199i ? (byte) 1 : (byte) 0);
        parcel.writeMap(this.f17200j);
    }
}
