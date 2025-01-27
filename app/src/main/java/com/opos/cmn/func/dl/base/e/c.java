package com.opos.cmn.func.dl.base.e;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a */
    public int f17323a;

    /* renamed from: b */
    public long f17324b;

    /* renamed from: c */
    public long f17325c;

    /* renamed from: d */
    public volatile long f17326d;

    public c(int i2, long j2, long j3, long j4) {
        this.f17323a = i2;
        this.f17324b = j2;
        this.f17325c = j4;
        this.f17326d = j3;
    }

    public final String toString() {
        return "ThreadInfo{index=" + this.f17323a + ", startPos=" + this.f17324b + ", contentLen=" + this.f17325c + ", downloadedLen=" + this.f17326d + '}';
    }
}
