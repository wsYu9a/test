package com.kwad.framework.filedownloader.a;

import com.kwad.framework.filedownloader.f.c;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.j;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class c implements com.kwad.framework.filedownloader.a.b {
    protected URLConnection air;

    public static class a {
        private Proxy ais;
        private Integer ait;
        private Integer aiu;
    }

    public static class b implements c.b {
        private final a aiv;

        public b() {
            this(null);
        }

        @Override // com.kwad.framework.filedownloader.f.c.b
        public final com.kwad.framework.filedownloader.a.b bi(String str) {
            return new c(str, this.aiv);
        }

        private b(a aVar) {
            this.aiv = null;
        }
    }

    public c(String str, a aVar) {
        this(new URL(str), aVar);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void addHeader(String str, String str2) {
        this.air.addRequestProperty(str, str2);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final String bh(String str) {
        return this.air.getHeaderField(str);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void execute() {
        this.air.connect();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final InputStream getInputStream() {
        return ((j) ServiceProvider.get(j.class)).wrapInputStream(this.air.getInputStream());
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final int getResponseCode() {
        URLConnection uRLConnection = this.air;
        if (!(uRLConnection instanceof HttpURLConnection)) {
            return 0;
        }
        try {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        } catch (Throwable th2) {
            throw new IOException(th2);
        }
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> wk() {
        return this.air.getRequestProperties();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> wl() {
        return this.air.getHeaderFields();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void wm() {
    }

    private c(URL url, a aVar) {
        if (aVar == null || aVar.ais == null) {
            this.air = url.openConnection();
        } else {
            this.air = url.openConnection(aVar.ais);
        }
        try {
            TLSConnectionUtils.wrapHttpURLConnection(this.air);
        } catch (Throwable unused) {
        }
        if (aVar != null) {
            if (aVar.ait != null) {
                this.air.setReadTimeout(aVar.ait.intValue());
            }
            if (aVar.aiu != null) {
                this.air.setConnectTimeout(aVar.aiu.intValue());
            }
        }
    }
}
