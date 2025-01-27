package lg;

import android.net.Uri;
import android.text.TextUtils;
import com.tanx.exposer.achieve.AdMonitorCommitResult;
import com.tanx.exposer.achieve.AdMonitorType;
import hg.d;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import jg.b;
import lg.a;
import sg.c;

/* loaded from: classes4.dex */
public class b extends lg.a {

    /* renamed from: e */
    public static Queue<String> f28122e = new ConcurrentLinkedQueue();

    /* renamed from: f */
    public static Map<String, ig.b> f28123f = new ConcurrentHashMap();

    public class a implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ String f28124b;

        /* renamed from: c */
        public final /* synthetic */ String f28125c;

        /* renamed from: d */
        public final /* synthetic */ String f28126d;

        public a(String str, String str2, String str3) {
            this.f28124b = str;
            this.f28125c = str2;
            this.f28126d = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            bVar.d(this.f28124b, this.f28125c, this.f28126d, bVar.f28109b);
        }
    }

    /* renamed from: lg.b$b */
    public static class C0737b extends a.b {

        /* renamed from: lg.b$b$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                jg.b bVar = b.e.f27574a;
                C0737b c0737b = C0737b.this;
                bVar.e(c0737b.f28117b, c0737b.f28116a);
                b.f28123f.remove(C0737b.this.f28117b.n());
                if (b.f28122e.size() >= 1000) {
                    b.f28122e.poll();
                }
                b.f28122e.offer(C0737b.this.f28117b.n());
            }
        }

        /* renamed from: lg.b$b$b */
        public class RunnableC0738b implements Runnable {

            /* renamed from: b */
            public final /* synthetic */ int f28129b;

            /* renamed from: c */
            public final /* synthetic */ String f28130c;

            public RunnableC0738b(int i10, String str) {
                this.f28129b = i10;
                this.f28130c = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                jg.b bVar = b.e.f27574a;
                C0737b c0737b = C0737b.this;
                bVar.d(c0737b.f28117b, this.f28129b, this.f28130c, c0737b.f28116a);
                if (bVar.k(C0737b.this.f28117b)) {
                    return;
                }
                b.f28123f.remove(C0737b.this.f28117b.n());
            }
        }

        public C0737b(ig.b bVar, boolean z10) {
            super(bVar, z10);
        }

        @Override // lg.a.b, pg.c
        public void a(int i10, String str) {
            qg.b.a(new RunnableC0738b(i10, str), 0L);
        }

        @Override // lg.a.b, pg.c
        public void tanxc_do() {
            qg.b.a(new a(), 0L);
        }
    }

    public b(AdMonitorType adMonitorType, List<String> list, d dVar) {
        super(adMonitorType, list, dVar);
    }

    @Override // lg.a
    public AdMonitorCommitResult a() {
        for (String str : this.f28108a) {
            String c10 = c.c(str);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(c10)) {
                rg.b.i(this.f28110c, this.f28109b, "url_is_empty_or_hash_error");
            } else {
                String host = Uri.parse(str).getHost();
                if (TextUtils.isEmpty(host)) {
                    rg.b.i(this.f28110c, this.f28109b, "domain_not_right");
                } else if (f28122e.contains(c10)) {
                    rg.b.h(this.f28110c, this.f28109b);
                } else {
                    qg.b.a(new a(str, host, c10), 0L);
                }
            }
        }
        return AdMonitorCommitResult.COMMITED;
    }

    public final void d(String str, String str2, String str3, AdMonitorType adMonitorType) {
        if (f28122e.contains(str3)) {
            rg.b.h(this.f28110c, adMonitorType);
            return;
        }
        ig.b bVar = f28123f.get(str3);
        if (bVar != null) {
            b.e.f27574a.c(bVar);
            d dVar = this.f28110c;
            if (dVar != null) {
                sg.a.d("tanx_deduplication_request_pending", dVar.toString());
                return;
            }
            return;
        }
        rg.b.e(this.f28110c, this.f28109b, str2, str3);
        d dVar2 = this.f28110c;
        String d10 = dVar2 == null ? str : c.d(str, dVar2.b());
        ig.b bVar2 = new ig.b(str, d10, this.f28109b, str2, str3, this.f28111d.f());
        bVar2.g(this.f28110c);
        new ng.b(this.f28111d.h()).a(d10, new C0737b(bVar2, false));
        f28123f.put(str3, bVar2);
    }
}
