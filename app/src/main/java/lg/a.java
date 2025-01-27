package lg;

import android.net.Uri;
import android.text.TextUtils;
import com.tanx.exposer.achieve.AdMonitorCommitResult;
import com.tanx.exposer.achieve.AdMonitorType;
import hg.c;
import hg.d;
import java.util.List;
import jg.b;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public List<String> f28108a;

    /* renamed from: b */
    public AdMonitorType f28109b;

    /* renamed from: c */
    public d f28110c;

    /* renamed from: d */
    public hg.b f28111d = c.c().i();

    /* renamed from: lg.a$a */
    public class RunnableC0734a implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ String f28112b;

        /* renamed from: c */
        public final /* synthetic */ String f28113c;

        /* renamed from: d */
        public final /* synthetic */ String f28114d;

        public RunnableC0734a(String str, String str2, String str3) {
            this.f28112b = str;
            this.f28113c = str2;
            this.f28114d = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b(this.f28112b, this.f28113c, this.f28114d);
        }
    }

    public static class b implements pg.c {

        /* renamed from: a */
        public final boolean f28116a;

        /* renamed from: b */
        public ig.b f28117b;

        /* renamed from: lg.a$b$a */
        public class RunnableC0735a implements Runnable {
            public RunnableC0735a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                jg.b bVar = b.e.f27574a;
                b bVar2 = b.this;
                bVar.e(bVar2.f28117b, bVar2.f28116a);
            }
        }

        /* renamed from: lg.a$b$b */
        public class RunnableC0736b implements Runnable {

            /* renamed from: b */
            public final /* synthetic */ int f28119b;

            /* renamed from: c */
            public final /* synthetic */ String f28120c;

            public RunnableC0736b(int i10, String str) {
                this.f28119b = i10;
                this.f28120c = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                jg.b bVar = b.e.f27574a;
                b bVar2 = b.this;
                bVar.d(bVar2.f28117b, this.f28119b, this.f28120c, bVar2.f28116a);
            }
        }

        public b(ig.b bVar, boolean z10) {
            this.f28117b = bVar;
            this.f28116a = z10;
        }

        @Override // pg.c
        public void a(int i10, String str) {
            qg.b.a(new RunnableC0736b(i10, str), 0L);
        }

        @Override // pg.c
        public void tanxc_do() {
            qg.b.a(new RunnableC0735a(), 0L);
        }
    }

    public a(AdMonitorType adMonitorType, List<String> list, d dVar) {
        this.f28109b = adMonitorType;
        this.f28108a = list;
        this.f28110c = dVar;
    }

    public AdMonitorCommitResult a() {
        for (String str : this.f28108a) {
            String c10 = sg.c.c(str);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(c10)) {
                rg.b.i(this.f28110c, this.f28109b, "url_is_empty_or_hash_error");
            } else {
                String host = Uri.parse(str).getHost();
                if (TextUtils.isEmpty(host)) {
                    rg.b.i(this.f28110c, this.f28109b, "domain_not_right");
                } else {
                    qg.b.a(new RunnableC0734a(str, host, c10), 0L);
                }
            }
        }
        return AdMonitorCommitResult.COMMITED;
    }

    public final void b(String str, String str2, String str3) {
        d dVar = this.f28110c;
        String d10 = dVar == null ? str : sg.c.d(str, dVar.b());
        rg.b.e(this.f28110c, this.f28109b, str2, str3);
        ig.b bVar = new ig.b(str, d10, this.f28109b, str2, str3, this.f28111d.f());
        bVar.g(this.f28110c);
        new ng.b(this.f28111d.h()).a(d10, new b(bVar, false));
    }
}
