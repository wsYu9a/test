package com.sigmob.sdk.downloader.core.download;

import com.sigmob.sdk.downloader.core.exception.i;
import java.io.IOException;
import java.net.SocketException;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    public String f19214a;

    /* renamed from: b */
    public final com.sigmob.sdk.downloader.core.file.d f19215b;

    /* renamed from: c */
    public volatile boolean f19216c;

    /* renamed from: d */
    public volatile boolean f19217d;

    /* renamed from: e */
    public volatile boolean f19218e;

    /* renamed from: f */
    public volatile boolean f19219f;

    /* renamed from: g */
    public volatile boolean f19220g;

    /* renamed from: h */
    public volatile boolean f19221h;

    /* renamed from: i */
    public volatile IOException f19222i;

    public static class a extends d {
        public a(IOException iOException) {
            super(null);
            e(iOException);
        }
    }

    public d() {
        this.f19215b = null;
    }

    public void a(IOException iOException) {
        if (k()) {
            return;
        }
        if (iOException instanceof com.sigmob.sdk.downloader.core.exception.f) {
            c(iOException);
            return;
        }
        if (iOException instanceof i) {
            d(iOException);
            return;
        }
        if (iOException == com.sigmob.sdk.downloader.core.exception.b.f19266a) {
            l();
            return;
        }
        if (iOException instanceof com.sigmob.sdk.downloader.core.exception.e) {
            b(iOException);
            return;
        }
        if (iOException != com.sigmob.sdk.downloader.core.exception.c.f19267a) {
            e(iOException);
            if (iOException instanceof SocketException) {
                return;
            }
            com.sigmob.sdk.downloader.core.c.a("DownloadCache", "catch unknown error " + iOException);
        }
    }

    public IOException b() {
        return this.f19222i;
    }

    public String c() {
        return this.f19214a;
    }

    public com.sigmob.sdk.downloader.core.cause.b d() {
        return ((com.sigmob.sdk.downloader.core.exception.f) this.f19222i).a();
    }

    public boolean e() {
        return this.f19220g;
    }

    public boolean f() {
        return this.f19216c || this.f19217d || this.f19218e || this.f19219f || this.f19220g || this.f19221h;
    }

    public boolean g() {
        return this.f19221h;
    }

    public boolean h() {
        return this.f19216c;
    }

    public boolean i() {
        return this.f19218e;
    }

    public boolean j() {
        return this.f19219f;
    }

    public boolean k() {
        return this.f19217d;
    }

    public void l() {
        this.f19220g = true;
    }

    public void m() {
        this.f19217d = true;
    }

    public d(com.sigmob.sdk.downloader.core.file.d dVar) {
        this.f19215b = dVar;
    }

    public com.sigmob.sdk.downloader.core.file.d a() {
        com.sigmob.sdk.downloader.core.file.d dVar = this.f19215b;
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException();
    }

    public void b(IOException iOException) {
        this.f19221h = true;
        this.f19222i = iOException;
    }

    public void c(IOException iOException) {
        this.f19216c = true;
        this.f19222i = iOException;
    }

    public void d(IOException iOException) {
        this.f19218e = true;
        this.f19222i = iOException;
    }

    public void e(IOException iOException) {
        this.f19219f = true;
        this.f19222i = iOException;
    }

    public void a(String str) {
        this.f19214a = str;
    }
}
