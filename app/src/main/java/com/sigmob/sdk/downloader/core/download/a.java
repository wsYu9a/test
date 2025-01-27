package com.sigmob.sdk.downloader.core.download;

import android.net.Uri;
import java.io.File;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public boolean f19191a;

    /* renamed from: b */
    public boolean f19192b;

    /* renamed from: c */
    public boolean f19193c;

    /* renamed from: d */
    public boolean f19194d;

    /* renamed from: e */
    public final com.sigmob.sdk.downloader.f f19195e;

    /* renamed from: f */
    public final com.sigmob.sdk.downloader.core.breakpoint.c f19196f;

    /* renamed from: g */
    public final long f19197g;

    public a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, long j10) {
        this.f19195e = fVar;
        this.f19196f = cVar;
        this.f19197g = j10;
    }

    public void a() {
        this.f19192b = d();
        this.f19193c = e();
        boolean f10 = f();
        this.f19194d = f10;
        this.f19191a = (this.f19193c && this.f19192b && f10) ? false : true;
    }

    public com.sigmob.sdk.downloader.core.cause.b b() {
        if (!this.f19193c) {
            return com.sigmob.sdk.downloader.core.cause.b.INFO_DIRTY;
        }
        if (!this.f19192b) {
            return com.sigmob.sdk.downloader.core.cause.b.FILE_NOT_EXIST;
        }
        if (!this.f19194d) {
            return com.sigmob.sdk.downloader.core.cause.b.OUTPUT_STREAM_NOT_SUPPORT;
        }
        throw new IllegalStateException("No cause find with dirty: " + this.f19191a);
    }

    public boolean c() {
        return this.f19191a;
    }

    public boolean d() {
        Uri A = this.f19195e.A();
        if (com.sigmob.sdk.downloader.core.c.c(A)) {
            return com.sigmob.sdk.downloader.core.c.b(A) > 0;
        }
        File z10 = this.f19195e.z();
        return z10 != null && z10.exists();
    }

    public boolean e() {
        int b10 = this.f19196f.b();
        if (b10 <= 0 || this.f19196f.l() || this.f19196f.d() == null) {
            return false;
        }
        if (!this.f19196f.d().equals(this.f19195e.z()) || this.f19196f.d().length() > this.f19196f.i()) {
            return false;
        }
        if (this.f19197g > 0 && this.f19196f.i() != this.f19197g) {
            return false;
        }
        for (int i10 = 0; i10 < b10; i10++) {
            if (this.f19196f.b(i10).b() <= 0) {
                return false;
            }
        }
        return true;
    }

    public boolean f() {
        if (com.sigmob.sdk.downloader.g.j().h().a()) {
            return true;
        }
        return this.f19196f.b() == 1 && !com.sigmob.sdk.downloader.g.j().i().b(this.f19195e);
    }

    public String toString() {
        return "fileExist[" + this.f19192b + "] infoRight[" + this.f19193c + "] outputStreamSupport[" + this.f19194d + "] " + super.toString();
    }
}
