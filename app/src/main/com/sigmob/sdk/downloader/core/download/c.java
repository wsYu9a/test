package com.sigmob.sdk.downloader.core.download;

import com.sigmob.sdk.downloader.core.connection.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: h */
    public static final String f19204h = "ConnectTrial";

    /* renamed from: i */
    public static final Pattern f19205i = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");

    /* renamed from: j */
    public static final Pattern f19206j = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");

    /* renamed from: a */
    public final com.sigmob.sdk.downloader.f f19207a;

    /* renamed from: b */
    public final com.sigmob.sdk.downloader.core.breakpoint.c f19208b;

    /* renamed from: c */
    public boolean f19209c;

    /* renamed from: d */
    public long f19210d;

    /* renamed from: e */
    public String f19211e;

    /* renamed from: f */
    public String f19212f;

    /* renamed from: g */
    public int f19213g;

    public c(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        this.f19207a = fVar;
        this.f19208b = cVar;
    }

    public static String b(a.InterfaceC0584a interfaceC0584a) throws IOException {
        return a(interfaceC0584a.c("Content-Disposition"));
    }

    public static long c(a.InterfaceC0584a interfaceC0584a) {
        long b10 = b(interfaceC0584a.c("Content-Range"));
        if (b10 != -1) {
            return b10;
        }
        if (!c(interfaceC0584a.c("Transfer-Encoding"))) {
            com.sigmob.sdk.downloader.core.c.c(f19204h, "Transfer-Encoding isn't chunked but there is no valid instance length found either!");
        }
        return -1L;
    }

    public void a() throws IOException {
        com.sigmob.sdk.downloader.g.j().f().a(this.f19207a);
        com.sigmob.sdk.downloader.g.j().f().a();
        com.sigmob.sdk.downloader.core.connection.a a10 = com.sigmob.sdk.downloader.g.j().c().a(this.f19207a.e());
        try {
            if (!com.sigmob.sdk.downloader.core.c.a((CharSequence) this.f19208b.c())) {
                a10.a("If-Match", this.f19208b.c());
            }
            a10.a("Range", "bytes=0-0");
            Map<String, List<String>> m10 = this.f19207a.m();
            if (m10 != null) {
                com.sigmob.sdk.downloader.core.c.b(m10, a10);
            }
            com.sigmob.sdk.downloader.c a11 = com.sigmob.sdk.downloader.g.j().b().a();
            a11.a(this.f19207a, a10.d());
            a.InterfaceC0584a execute = a10.execute();
            this.f19207a.a(execute.b());
            com.sigmob.sdk.downloader.core.c.a(f19204h, "task[" + this.f19207a.b() + "] redirect location: " + this.f19207a.t());
            this.f19213g = execute.f();
            this.f19209c = d(execute);
            this.f19210d = c(execute);
            this.f19211e = a(execute);
            this.f19212f = b(execute);
            Map<String, List<String>> e10 = execute.e();
            if (e10 == null) {
                e10 = new HashMap<>();
            }
            a11.b(this.f19207a, this.f19213g, e10);
            boolean a12 = a(this.f19210d, execute);
            a10.a();
            if (a12) {
                i();
            }
        } catch (Throwable th2) {
            a10.a();
            throw th2;
        }
    }

    public String d() {
        return this.f19211e;
    }

    public String e() {
        return this.f19212f;
    }

    public boolean f() {
        return this.f19209c;
    }

    public boolean g() {
        return this.f19210d == -1;
    }

    public boolean h() {
        return (this.f19208b.c() == null || this.f19208b.c().equals(this.f19211e)) ? false : true;
    }

    public void i() throws IOException {
        com.sigmob.sdk.downloader.core.connection.a a10 = com.sigmob.sdk.downloader.g.j().c().a(this.f19207a.e());
        com.sigmob.sdk.downloader.c a11 = com.sigmob.sdk.downloader.g.j().b().a();
        try {
            a10.a(com.sigmob.sdk.downloader.core.c.f19078a);
            Map<String, List<String>> m10 = this.f19207a.m();
            if (m10 != null) {
                com.sigmob.sdk.downloader.core.c.b(m10, a10);
            }
            a11.a(this.f19207a, a10.d());
            a.InterfaceC0584a execute = a10.execute();
            a11.b(this.f19207a, execute.f(), execute.e());
            this.f19210d = com.sigmob.sdk.downloader.core.c.c(execute.c("Content-Length"));
            a10.a();
        } catch (Throwable th2) {
            a10.a();
            throw th2;
        }
    }

    public static String a(a.InterfaceC0584a interfaceC0584a) {
        return interfaceC0584a.c("Etag");
    }

    public static boolean d(a.InterfaceC0584a interfaceC0584a) throws IOException {
        if (interfaceC0584a.f() == 206) {
            return true;
        }
        return "bytes".equals(interfaceC0584a.c("Accept-Ranges"));
    }

    public long b() {
        return this.f19210d;
    }

    public int c() {
        return this.f19213g;
    }

    public static long b(String str) {
        if (str == null) {
            return -1L;
        }
        String[] split = str.split("/");
        if (split.length >= 2) {
            try {
                return Long.parseLong(split[1]);
            } catch (NumberFormatException unused) {
                com.sigmob.sdk.downloader.core.c.c(f19204h, "parse instance length failed with " + str);
            }
        }
        return -1L;
    }

    public static boolean c(String str) {
        return str != null && str.equals("chunked");
    }

    public boolean a(long j10, a.InterfaceC0584a interfaceC0584a) {
        String c10;
        if (j10 != -1) {
            return false;
        }
        String c11 = interfaceC0584a.c("Content-Range");
        return (c11 == null || c11.length() <= 0) && !c(interfaceC0584a.c("Transfer-Encoding")) && (c10 = interfaceC0584a.c("Content-Length")) != null && c10.length() > 0;
    }

    public static String a(String str) throws IOException {
        String group;
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = f19205i.matcher(str);
            if (matcher.find()) {
                group = matcher.group(1);
            } else {
                Matcher matcher2 = f19206j.matcher(str);
                group = matcher2.find() ? matcher2.group(1) : null;
            }
            if (group != null && group.contains("../")) {
                throw new com.sigmob.sdk.downloader.core.exception.a("The filename [" + group + "] from the response is not allowable, because it contains '../', which can raise the directory traversal vulnerability");
            }
            return group;
        } catch (IllegalStateException unused) {
            return null;
        }
    }
}
