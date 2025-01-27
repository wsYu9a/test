package com.opos.cmn.func.dl.base.d;

import android.content.Context;
import android.content.IntentFilter;
import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.DownloadResponse;
import com.opos.cmn.func.dl.base.d.a;
import com.opos.cmn.func.dl.base.d.a.b;
import com.opos.cmn.func.dl.base.exception.DlException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: c */
    private static final String f17310c = "b";

    /* renamed from: a */
    public Context f17311a;

    /* renamed from: e */
    private com.opos.cmn.func.dl.base.f.a f17314e;

    /* renamed from: d */
    private List<DownloadRequest> f17313d = new ArrayList();

    /* renamed from: b */
    public C0392b f17312b = new C0392b();

    final class a extends com.opos.cmn.func.dl.base.a {
        a() {
        }

        @Override // com.opos.cmn.func.dl.base.a, com.opos.cmn.func.dl.base.b
        public final void a(DownloadRequest downloadRequest, DownloadResponse downloadResponse, DlException dlException) {
            if (downloadRequest.f17197g) {
                int a2 = dlException.a();
                if (a2 == 1003 || a2 == 1013) {
                    com.opos.cmn.an.f.a.b(b.f17310c, "add retry request:" + downloadRequest.toString());
                    for (int i2 = 0; i2 < b.this.f17313d.size(); i2++) {
                        if (downloadRequest.f17194d > ((DownloadRequest) b.this.f17313d.get(i2)).f17194d) {
                            b.this.f17313d.add(i2, downloadRequest);
                            return;
                        }
                    }
                    b.this.f17313d.add(downloadRequest);
                }
            }
        }

        @Override // com.opos.cmn.func.dl.base.a, com.opos.cmn.func.dl.base.b
        public final void d(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            b.this.a(downloadRequest);
        }
    }

    /* renamed from: com.opos.cmn.func.dl.base.d.b$b */
    final class C0392b implements a.c {
        C0392b() {
        }

        @Override // com.opos.cmn.func.dl.base.d.a.c
        public final void a() {
            synchronized (this) {
                com.opos.cmn.an.f.a.b(b.f17310c, "-----onMoblieAvailable !");
                Iterator it = new ArrayList(b.this.f17313d).iterator();
                while (it.hasNext()) {
                    b.this.f17314e.a((DownloadRequest) it.next(), false);
                }
            }
        }

        @Override // com.opos.cmn.func.dl.base.d.a.c
        public final void b() {
            synchronized (this) {
                com.opos.cmn.an.f.a.b(b.f17310c, "-----onWifiAvailable!");
                Iterator it = new ArrayList(b.this.f17313d).iterator();
                while (it.hasNext()) {
                    b.this.f17314e.a((DownloadRequest) it.next(), false);
                }
            }
        }

        @Override // com.opos.cmn.func.dl.base.d.a.c
        public final void c() {
            synchronized (this) {
                com.opos.cmn.an.f.a.b(b.f17310c, "-----onUnavailable");
            }
        }
    }

    public b(Context context, com.opos.cmn.func.dl.base.f.a aVar) {
        this.f17311a = context;
        this.f17314e = aVar;
        aVar.f17335c.a(new a());
        com.opos.cmn.func.dl.base.d.a a2 = com.opos.cmn.func.dl.base.d.a.a(context);
        C0392b c0392b = this.f17312b;
        if (a2.f17305b == null) {
            a2.f17305b = a2.new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.setPriority(Integer.MAX_VALUE);
            a2.f17304a.registerReceiver(a2.f17305b, intentFilter);
        }
        if (c0392b != null) {
            a2.f17306c.add(c0392b);
        }
    }

    public final void a(DownloadRequest downloadRequest) {
        this.f17313d.remove(downloadRequest);
    }
}
