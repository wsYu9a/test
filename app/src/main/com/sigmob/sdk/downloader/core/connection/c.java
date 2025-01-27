package com.sigmob.sdk.downloader.core.connection;

import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.i;
import com.sigmob.sdk.downloader.j;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class c implements com.sigmob.sdk.downloader.core.connection.a, a.InterfaceC0584a {

    /* renamed from: f */
    public static final String f19117f = "DownloadUrlConnection";

    /* renamed from: b */
    public URLConnection f19118b;

    /* renamed from: c */
    public a f19119c;

    /* renamed from: d */
    public URL f19120d;

    /* renamed from: e */
    public i f19121e;

    public static class a {

        /* renamed from: a */
        public Proxy f19122a;

        /* renamed from: b */
        public Integer f19123b;

        /* renamed from: c */
        public Integer f19124c;

        public a a(int i10) {
            this.f19124c = Integer.valueOf(i10);
            return this;
        }

        public a b(int i10) {
            this.f19123b = Integer.valueOf(i10);
            return this;
        }

        public a a(Proxy proxy) {
            this.f19122a = proxy;
            return this;
        }
    }

    public static class b implements a.b {

        /* renamed from: a */
        public final a f19125a;

        public b() {
            this(null);
        }

        @Override // com.sigmob.sdk.downloader.core.connection.a.b
        public com.sigmob.sdk.downloader.core.connection.a a(String str) throws IOException {
            return new c(str, this.f19125a);
        }

        public b(a aVar) {
            this.f19125a = aVar;
        }

        public com.sigmob.sdk.downloader.core.connection.a a(URL url) throws IOException {
            return new c(url, this.f19125a);
        }
    }

    /* renamed from: com.sigmob.sdk.downloader.core.connection.c$c */
    public static final class C0585c implements i {

        /* renamed from: a */
        public String f19126a;

        @Override // com.sigmob.sdk.downloader.i
        public void a(com.sigmob.sdk.downloader.core.connection.a aVar, a.InterfaceC0584a interfaceC0584a, Map<String, List<String>> map) throws IOException {
            c cVar = (c) aVar;
            int i10 = 0;
            for (int f10 = interfaceC0584a.f(); j.a(f10); f10 = cVar.f()) {
                cVar.a();
                i10++;
                if (i10 > 10) {
                    throw new ProtocolException("Too many redirect requests: " + i10);
                }
                String a10 = j.a(interfaceC0584a, f10);
                this.f19126a = a10;
                URI create = URI.create(a10);
                if (create != null && !create.isAbsolute()) {
                    try {
                        this.f19126a = ((c) aVar).f19120d.toURI().resolve(create).toString();
                    } catch (Throwable unused) {
                    }
                }
                cVar.f19120d = new URL(this.f19126a);
                cVar.g();
                com.sigmob.sdk.downloader.core.c.a(map, cVar);
                cVar.f19118b.connect();
            }
        }

        @Override // com.sigmob.sdk.downloader.i
        public String b() {
            return this.f19126a;
        }
    }

    public c(String str) throws IOException {
        this(str, (a) null);
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0584a
    public String b() {
        return this.f19121e.b();
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0584a
    public InputStream c() throws IOException {
        return this.f19118b.getInputStream();
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public Map<String, List<String>> d() {
        return this.f19118b.getRequestProperties();
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0584a
    public Map<String, List<String>> e() {
        return this.f19118b.getHeaderFields();
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public a.InterfaceC0584a execute() throws IOException {
        Map<String, List<String>> d10 = d();
        this.f19118b.connect();
        this.f19121e.a(this, this, d10);
        return this;
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0584a
    public int f() throws IOException {
        URLConnection uRLConnection = this.f19118b;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    public void g() throws IOException {
        com.sigmob.sdk.downloader.core.c.a(f19117f, "config connection for " + this.f19120d);
        a aVar = this.f19119c;
        this.f19118b = (aVar == null || aVar.f19122a == null) ? this.f19120d.openConnection() : this.f19120d.openConnection(this.f19119c.f19122a);
        URLConnection uRLConnection = this.f19118b;
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).setInstanceFollowRedirects(false);
        }
        a aVar2 = this.f19119c;
        if (aVar2 != null) {
            if (aVar2.f19123b != null) {
                this.f19118b.setReadTimeout(this.f19119c.f19123b.intValue());
            }
            if (this.f19119c.f19124c != null) {
                this.f19118b.setConnectTimeout(this.f19119c.f19124c.intValue());
            }
        }
    }

    public c(String str, a aVar) throws IOException {
        this(new URL(str), aVar);
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public String b(String str) {
        return this.f19118b.getRequestProperty(str);
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0584a
    public String c(String str) {
        return this.f19118b.getHeaderField(str);
    }

    public c(URL url, a aVar) throws IOException {
        this(url, aVar, new C0585c());
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public void a(String str, String str2) {
        this.f19118b.addRequestProperty(str, str2);
    }

    public c(URL url, a aVar, i iVar) throws IOException {
        this.f19119c = aVar;
        this.f19120d = url;
        this.f19121e = iVar;
        g();
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public void a() {
        try {
            InputStream inputStream = this.f19118b.getInputStream();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException | Exception unused) {
        }
    }

    public c(URLConnection uRLConnection) {
        this(uRLConnection, new C0585c());
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public boolean a(String str) throws ProtocolException {
        URLConnection uRLConnection = this.f19118b;
        if (!(uRLConnection instanceof HttpURLConnection)) {
            return false;
        }
        ((HttpURLConnection) uRLConnection).setRequestMethod(str);
        return true;
    }

    public c(URLConnection uRLConnection, i iVar) {
        this.f19118b = uRLConnection;
        this.f19120d = uRLConnection.getURL();
        this.f19121e = iVar;
    }
}
