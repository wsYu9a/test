package com.kwai.filedownloader.download;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHeaders;

/* loaded from: classes2.dex */
public final class ConnectTask {
    final int aGL;
    final com.kwai.filedownloader.c.b aGM;
    private com.kwai.filedownloader.download.a aGN;
    private String aGO;
    private Map<String, List<String>> aGP;
    private List<String> aGQ;
    final String url;

    class Reconnect extends Throwable {
        private static final long serialVersionUID = 2940866805654257562L;

        Reconnect() {
        }
    }

    static class a {
        private com.kwai.filedownloader.c.b aGM;
        private String aGO;
        private Integer aGR;
        private com.kwai.filedownloader.download.a aGS;
        private String url;

        a() {
        }

        final ConnectTask HE() {
            com.kwai.filedownloader.download.a aVar;
            Integer num = this.aGR;
            if (num == null || (aVar = this.aGS) == null || this.url == null) {
                throw new IllegalArgumentException();
            }
            return new ConnectTask(aVar, num.intValue(), this.url, this.aGO, this.aGM, (byte) 0);
        }

        public final a a(com.kwai.filedownloader.c.b bVar) {
            this.aGM = bVar;
            return this;
        }

        public final a a(com.kwai.filedownloader.download.a aVar) {
            this.aGS = aVar;
            return this;
        }

        public final a cQ(int i2) {
            this.aGR = Integer.valueOf(i2);
            return this;
        }

        public final a fn(String str) {
            this.url = str;
            return this;
        }

        public final a fo(String str) {
            this.aGO = str;
            return this;
        }
    }

    private ConnectTask(com.kwai.filedownloader.download.a aVar, int i2, String str, String str2, com.kwai.filedownloader.c.b bVar) {
        this.aGL = i2;
        this.url = str;
        this.aGO = str2;
        this.aGM = bVar;
        this.aGN = aVar;
    }

    /* synthetic */ ConnectTask(com.kwai.filedownloader.download.a aVar, int i2, String str, String str2, com.kwai.filedownloader.c.b bVar, byte b2) {
        this(aVar, i2, str, str2, bVar);
    }

    private void a(com.kwai.filedownloader.kwai.b bVar) {
        HashMap<String, List<String>> IA;
        com.kwai.filedownloader.c.b bVar2 = this.aGM;
        if (bVar2 == null || (IA = bVar2.IA()) == null) {
            return;
        }
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.i(this, "%d add outside header: %s", Integer.valueOf(this.aGL), IA);
        }
        for (Map.Entry<String, List<String>> entry : IA.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    bVar.addHeader(key, it.next());
                }
            }
        }
    }

    private void b(com.kwai.filedownloader.kwai.b bVar) {
        if (!TextUtils.isEmpty(this.aGO)) {
            bVar.addHeader(HttpHeaders.IF_MATCH, this.aGO);
        }
        com.kwai.filedownloader.download.a aVar = this.aGN;
        bVar.addHeader(HttpHeaders.RANGE, aVar.aGV == 0 ? com.kwai.filedownloader.e.f.j("bytes=%d-", Long.valueOf(aVar.aGU)) : com.kwai.filedownloader.e.f.j("bytes=%d-%d", Long.valueOf(aVar.aGU), Long.valueOf(this.aGN.aGV)));
    }

    private void c(com.kwai.filedownloader.kwai.b bVar) {
        com.kwai.filedownloader.c.b bVar2 = this.aGM;
        if (bVar2 == null || bVar2.IA().get("User-Agent") == null) {
            bVar.addHeader("User-Agent", com.kwai.filedownloader.e.f.Jh());
        }
    }

    final com.kwai.filedownloader.kwai.b HA() {
        com.kwai.filedownloader.kwai.b fp = b.HF().fp(this.url);
        a(fp);
        b(fp);
        c(fp);
        this.aGP = fp.V();
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "%s request header %s", Integer.valueOf(this.aGL), this.aGP);
        }
        fp.execute();
        ArrayList arrayList = new ArrayList();
        this.aGQ = arrayList;
        return com.kwai.filedownloader.kwai.d.a(this.aGP, fp, arrayList);
    }

    final boolean HB() {
        return this.aGN.aGU > 0;
    }

    final String HC() {
        List<String> list = this.aGQ;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.aGQ.get(r0.size() - 1);
    }

    public final com.kwai.filedownloader.download.a HD() {
        return this.aGN;
    }

    public final Map<String, List<String>> getRequestHeader() {
        return this.aGP;
    }
}
