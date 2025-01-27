package com.sigmob.sdk.downloader.core.breakpoint;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public final long f18998a;

    /* renamed from: b */
    public final long f18999b;

    /* renamed from: c */
    public final AtomicLong f19000c;

    public a(long j10, long j11) {
        this(j10, j11, 0L);
    }

    public a a() {
        return new a(this.f18998a, this.f18999b, this.f19000c.get());
    }

    public long b() {
        return this.f18999b;
    }

    public long c() {
        return this.f19000c.get();
    }

    public long d() {
        return this.f18998a + this.f19000c.get();
    }

    public long e() {
        long j10 = this.f18999b;
        if (j10 == -1) {
            return -1L;
        }
        return (this.f18998a + j10) - 1;
    }

    public long f() {
        return this.f18998a;
    }

    public void g() {
        this.f19000c.set(0L);
    }

    public String toString() {
        return "[" + this.f18998a + ", " + e() + ")-current:" + this.f19000c;
    }

    public a(long j10, long j11, long j12) {
        if (j10 < 0 || ((j11 < 0 && j11 != -1) || j12 < 0)) {
            throw new IllegalArgumentException();
        }
        this.f18998a = j10;
        this.f18999b = j11;
        this.f19000c = new AtomicLong(j12);
    }

    public void a(long j10) {
        this.f19000c.addAndGet(j10);
    }
}
