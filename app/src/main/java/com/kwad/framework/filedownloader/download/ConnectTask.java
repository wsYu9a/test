package com.kwad.framework.filedownloader.download;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class ConnectTask {
    final int aiP;
    final com.kwad.framework.filedownloader.d.b aiQ;
    private com.kwad.framework.filedownloader.download.a aiR;
    private String aiS;
    private Map<String, List<String>> aiT;
    private List<String> aiU;
    final String url;

    public class Reconnect extends Throwable {
        private static final long serialVersionUID = 2940866805654257562L;

        public Reconnect() {
        }
    }

    public static class a {
        private com.kwad.framework.filedownloader.d.b aiQ;
        private String aiS;
        private Integer aiV;
        private com.kwad.framework.filedownloader.download.a aiW;
        private String url;

        public final a a(com.kwad.framework.filedownloader.d.b bVar) {
            this.aiQ = bVar;
            return this;
        }

        public final a bj(String str) {
            this.url = str;
            return this;
        }

        public final a bk(String str) {
            this.aiS = str;
            return this;
        }

        public final a bt(int i10) {
            this.aiV = Integer.valueOf(i10);
            return this;
        }

        public final ConnectTask wv() {
            com.kwad.framework.filedownloader.download.a aVar;
            Integer num = this.aiV;
            if (num == null || (aVar = this.aiW) == null || this.url == null) {
                throw new IllegalArgumentException();
            }
            return new ConnectTask(aVar, num.intValue(), this.url, this.aiS, this.aiQ, (byte) 0);
        }

        public final a a(com.kwad.framework.filedownloader.download.a aVar) {
            this.aiW = aVar;
            return this;
        }
    }

    public /* synthetic */ ConnectTask(com.kwad.framework.filedownloader.download.a aVar, int i10, String str, String str2, com.kwad.framework.filedownloader.d.b bVar, byte b10) {
        this(aVar, i10, str, str2, bVar);
    }

    private void a(com.kwad.framework.filedownloader.a.b bVar) {
        HashMap<String, List<String>> xs;
        com.kwad.framework.filedownloader.d.b bVar2 = this.aiQ;
        if (bVar2 == null || (xs = bVar2.xs()) == null) {
            return;
        }
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.e(this, "%d add outside header: %s", Integer.valueOf(this.aiP), xs);
        }
        for (Map.Entry<String, List<String>> entry : xs.entrySet()) {
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

    private void b(com.kwad.framework.filedownloader.a.b bVar) {
        if (!TextUtils.isEmpty(this.aiS)) {
            bVar.addHeader("If-Match", this.aiS);
        }
        com.kwad.framework.filedownloader.download.a aVar = this.aiR;
        bVar.addHeader("Range", aVar.aiZ == 0 ? com.kwad.framework.filedownloader.f.f.b("bytes=%d-", Long.valueOf(aVar.aiY)) : com.kwad.framework.filedownloader.f.f.b("bytes=%d-%d", Long.valueOf(aVar.aiY), Long.valueOf(this.aiR.aiZ)));
    }

    private void c(com.kwad.framework.filedownloader.a.b bVar) {
        com.kwad.framework.filedownloader.d.b bVar2 = this.aiQ;
        if (bVar2 == null || bVar2.xs().get("User-Agent") == null) {
            bVar.addHeader("User-Agent", com.kwad.framework.filedownloader.f.f.yb());
        }
    }

    public final Map<String, List<String>> getRequestHeader() {
        return this.aiT;
    }

    public final com.kwad.framework.filedownloader.a.b wr() {
        com.kwad.framework.filedownloader.a.b bl = b.ww().bl(this.url);
        a(bl);
        b(bl);
        c(bl);
        this.aiT = bl.wk();
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "%s request header %s", Integer.valueOf(this.aiP), this.aiT);
        }
        bl.execute();
        ArrayList arrayList = new ArrayList();
        this.aiU = arrayList;
        return com.kwad.framework.filedownloader.a.d.a(this.aiT, bl, arrayList);
    }

    public final boolean ws() {
        return this.aiR.aiY > 0;
    }

    public final String wt() {
        List<String> list = this.aiU;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.aiU.get(r0.size() - 1);
    }

    public final com.kwad.framework.filedownloader.download.a wu() {
        return this.aiR;
    }

    private ConnectTask(com.kwad.framework.filedownloader.download.a aVar, int i10, String str, String str2, com.kwad.framework.filedownloader.d.b bVar) {
        this.aiP = i10;
        this.url = str;
        this.aiS = str2;
        this.aiQ = bVar;
        this.aiR = aVar;
    }
}
