package com.czhj.sdk.common.utils;

import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

/* loaded from: classes2.dex */
public class AdvertisingId implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final long f8575c = 86400000;

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f8576a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8577b;
    public final String mAdvertisingId;
    public final boolean mDoNotTrack;

    public AdvertisingId(String str, String str2, boolean z10, long j10) {
        this.mAdvertisingId = str;
        this.f8577b = str2;
        this.mDoNotTrack = z10;
        Calendar calendar = Calendar.getInstance();
        this.f8576a = calendar;
        calendar.setTimeInMillis(j10);
    }

    public static String a() {
        return UUID.randomUUID().toString();
    }

    public static AdvertisingId generateExpiredAdvertisingId() {
        return new AdvertisingId(null, a(), false, Calendar.getInstance().getTimeInMillis() - 86400001);
    }

    public boolean b() {
        return Calendar.getInstance().getTimeInMillis() - this.f8576a.getTimeInMillis() >= 86400000;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdvertisingId)) {
            return false;
        }
        AdvertisingId advertisingId = (AdvertisingId) obj;
        return this.mDoNotTrack == advertisingId.mDoNotTrack && this.mAdvertisingId.equals(advertisingId.mAdvertisingId) && this.f8577b.equals(advertisingId.f8577b);
    }

    public int hashCode() {
        return (((this.mAdvertisingId.hashCode() * 31) + this.f8577b.hashCode()) * 31) + (this.mDoNotTrack ? 1 : 0);
    }

    public String toString() {
        return "AdvertisingId{mLastRotation=" + this.f8576a + ", mAdvertisingId='" + this.mAdvertisingId + "', mSigmobId='" + this.f8577b + "', mDoNotTrack=" + this.mDoNotTrack + '}';
    }
}
