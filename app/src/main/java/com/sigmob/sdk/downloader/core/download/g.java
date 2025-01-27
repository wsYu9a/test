package com.sigmob.sdk.downloader.core.download;

import android.net.ConnectivityManager;
import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.exception.i;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: c */
    public static final String f19253c = "DownloadStrategy";

    /* renamed from: d */
    public static final long f19254d = 1048576;

    /* renamed from: e */
    public static final long f19255e = 5242880;

    /* renamed from: f */
    public static final long f19256f = 52428800;

    /* renamed from: g */
    public static final long f19257g = 104857600;

    /* renamed from: h */
    public static final Pattern f19258h = Pattern.compile(".*\\\\|/([^\\\\|/|?]*)\\??");

    /* renamed from: a */
    public Boolean f19259a = null;

    /* renamed from: b */
    public ConnectivityManager f19260b = null;

    public static class a {

        /* renamed from: a */
        public volatile String f19261a;

        /* renamed from: b */
        public final boolean f19262b = false;

        public a() {
        }

        public String a() {
            return this.f19261a;
        }

        public boolean b() {
            return this.f19262b;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                return this.f19261a == null ? ((a) obj).f19261a == null : this.f19261a.equals(((a) obj).f19261a);
            }
            return false;
        }

        public int hashCode() {
            if (this.f19261a == null) {
                return 0;
            }
            return this.f19261a.hashCode();
        }

        public a(String str) {
            this.f19261a = str;
        }

        public void a(String str) {
            this.f19261a = str;
        }
    }

    public static class b {

        /* renamed from: a */
        public a.InterfaceC0584a f19263a;

        /* renamed from: b */
        public com.sigmob.sdk.downloader.core.breakpoint.c f19264b;

        /* renamed from: c */
        public int f19265c;

        public b(a.InterfaceC0584a interfaceC0584a, int i10, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
            this.f19263a = interfaceC0584a;
            this.f19264b = cVar;
            this.f19265c = i10;
        }

        public void a() throws IOException {
            com.sigmob.sdk.downloader.core.breakpoint.a b10 = this.f19264b.b(this.f19265c);
            int f10 = this.f19263a.f();
            com.sigmob.sdk.downloader.core.cause.b a10 = com.sigmob.sdk.downloader.g.j().f().a(f10, b10.c() != 0, this.f19264b, this.f19263a.c("Etag"));
            if (a10 != null) {
                throw new com.sigmob.sdk.downloader.core.exception.f(a10);
            }
            if (com.sigmob.sdk.downloader.g.j().f().a(f10, b10.c() != 0)) {
                throw new i(f10, b10.c());
            }
        }
    }

    public boolean a(int i10, boolean z10) {
        if (i10 == 206 || i10 == 200) {
            return i10 == 200 && z10;
        }
        return true;
    }

    public long b() {
        return 10240L;
    }

    public int a(com.sigmob.sdk.downloader.f fVar, long j10) {
        if (fVar.u() != null) {
            return fVar.u().intValue();
        }
        if (j10 < 1048576) {
            return 1;
        }
        if (j10 < f19255e) {
            return 2;
        }
        if (j10 < f19256f) {
            return 3;
        }
        return j10 < f19257g ? 4 : 5;
    }

    public void b(String str, com.sigmob.sdk.downloader.f fVar) {
        if (com.sigmob.sdk.downloader.core.c.a((CharSequence) fVar.a())) {
            fVar.k().a(str);
        }
    }

    public String a(String str, com.sigmob.sdk.downloader.f fVar) throws IOException {
        if (!com.sigmob.sdk.downloader.core.c.a((CharSequence) str)) {
            return str;
        }
        String e10 = fVar.e();
        Matcher matcher = f19258h.matcher(e10);
        String str2 = null;
        while (matcher.find()) {
            str2 = matcher.group(1);
        }
        if (com.sigmob.sdk.downloader.core.c.a((CharSequence) str2)) {
            str2 = com.sigmob.sdk.downloader.core.c.b(e10);
        }
        if (str2 != null) {
            return str2;
        }
        throw new IOException("Can't find valid filename.");
    }

    public boolean b(com.sigmob.sdk.downloader.f fVar) {
        String a10 = com.sigmob.sdk.downloader.g.j().a().a(fVar.e());
        if (a10 == null) {
            return false;
        }
        fVar.k().a(a10);
        return true;
    }

    public com.sigmob.sdk.downloader.core.cause.b a(int i10, boolean z10, com.sigmob.sdk.downloader.core.breakpoint.c cVar, String str) {
        String c10 = cVar.c();
        if (i10 == 412) {
            return com.sigmob.sdk.downloader.core.cause.b.RESPONSE_PRECONDITION_FAILED;
        }
        if (!com.sigmob.sdk.downloader.core.c.a((CharSequence) c10) && !com.sigmob.sdk.downloader.core.c.a((CharSequence) str) && !str.equals(c10)) {
            return com.sigmob.sdk.downloader.core.cause.b.RESPONSE_ETAG_CHANGED;
        }
        if (i10 == 201 && z10) {
            return com.sigmob.sdk.downloader.core.cause.b.RESPONSE_CREATED_RANGE_NOT_FROM_0;
        }
        if (i10 == 205 && z10) {
            return com.sigmob.sdk.downloader.core.cause.b.RESPONSE_RESET_RANGE_NOT_FROM_0;
        }
        return null;
    }

    public boolean a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, long j10) {
        com.sigmob.sdk.downloader.core.breakpoint.g a10;
        com.sigmob.sdk.downloader.core.breakpoint.c a11;
        if (!fVar.C() || (a11 = (a10 = com.sigmob.sdk.downloader.g.j().a()).a(fVar, cVar)) == null) {
            return false;
        }
        a10.g(a11.g());
        if (a11.j() <= com.sigmob.sdk.downloader.g.j().f().b()) {
            return false;
        }
        if ((a11.c() != null && !a11.c().equals(cVar.c())) || a11.i() != j10 || a11.d() == null || !a11.d().exists()) {
            return false;
        }
        cVar.a(a11);
        com.sigmob.sdk.downloader.core.c.a(f19253c, "Reuse another same info: " + cVar);
        return true;
    }

    public void a() throws UnknownHostException {
        if (this.f19259a == null) {
            this.f19259a = Boolean.valueOf(com.sigmob.sdk.downloader.core.c.a(com.kuaishou.weapon.p0.g.f11101b));
        }
        if (this.f19259a.booleanValue()) {
            if (this.f19260b == null) {
                this.f19260b = (ConnectivityManager) com.sigmob.sdk.downloader.g.j().d().getSystemService("connectivity");
            }
            if (!com.sigmob.sdk.downloader.core.c.a(this.f19260b)) {
                throw new UnknownHostException("network is not available!");
            }
        }
    }

    public void a(com.sigmob.sdk.downloader.f fVar) throws IOException {
        if (this.f19259a == null) {
            this.f19259a = Boolean.valueOf(com.sigmob.sdk.downloader.core.c.a(com.kuaishou.weapon.p0.g.f11101b));
        }
        if (fVar.E()) {
            if (!this.f19259a.booleanValue()) {
                throw new IOException("required for access network state but don't have the permission of Manifest.permission.ACCESS_NETWORK_STATE, please declare this permission first on your AndroidManifest, so we can handle the case of downloading required wifi state.");
            }
            if (this.f19260b == null) {
                this.f19260b = (ConnectivityManager) com.sigmob.sdk.downloader.g.j().d().getSystemService("connectivity");
            }
            if (com.sigmob.sdk.downloader.core.c.b(this.f19260b)) {
                throw new com.sigmob.sdk.downloader.core.exception.d();
            }
        }
    }

    public boolean a(boolean z10) {
        if (com.sigmob.sdk.downloader.g.j().h().a()) {
            return z10;
        }
        return false;
    }

    public b a(a.InterfaceC0584a interfaceC0584a, int i10, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        return new b(interfaceC0584a, i10, cVar);
    }

    public void a(String str, com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) throws IOException {
        if (com.sigmob.sdk.downloader.core.c.a((CharSequence) fVar.a())) {
            String a10 = a(str, fVar);
            if (com.sigmob.sdk.downloader.core.c.a((CharSequence) fVar.a())) {
                synchronized (fVar) {
                    try {
                        if (com.sigmob.sdk.downloader.core.c.a((CharSequence) fVar.a())) {
                            fVar.k().a(a10);
                            cVar.f().a(a10);
                        }
                    } finally {
                    }
                }
            }
        }
    }

    public void a(com.sigmob.sdk.downloader.f fVar, j jVar) {
        long length;
        com.sigmob.sdk.downloader.core.breakpoint.c i10 = jVar.i(fVar.b());
        if (i10 == null) {
            i10 = new com.sigmob.sdk.downloader.core.breakpoint.c(fVar.b(), fVar.e(), fVar.c(), fVar.a());
            if (com.sigmob.sdk.downloader.core.c.c(fVar.A())) {
                length = com.sigmob.sdk.downloader.core.c.b(fVar.A());
            } else {
                File z10 = fVar.z();
                if (z10 == null) {
                    com.sigmob.sdk.downloader.core.c.c(f19253c, "file is not ready on valid info for task on complete state " + fVar);
                    length = 0;
                } else {
                    length = z10.length();
                }
            }
            long j10 = length;
            i10.a(new com.sigmob.sdk.downloader.core.breakpoint.a(0L, j10, j10));
        }
        f.c.a(fVar, i10);
    }
}
