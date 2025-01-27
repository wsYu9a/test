package com.aggmoread.sdk.z.d.a.a.d.b;

import android.text.TextUtils;
import com.aggmoread.sdk.client.AMConst;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.aggmoread.sdk.z.d.a.a.e.n;
import com.qq.e.comm.constants.Constants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a {

    /* renamed from: l */
    private static String f5840l = "AMHTAG";

    /* renamed from: f */
    public HashMap<String, Object> f5841f = new HashMap<>();

    /* renamed from: g */
    public d f5842g;

    /* renamed from: h */
    public e f5843h;

    /* renamed from: i */
    protected com.aggmoread.sdk.z.d.a.a.d.a.c f5844i;

    /* renamed from: j */
    protected String f5845j;

    /* renamed from: k */
    protected com.aggmoread.sdk.z.d.a.a.e.r.f f5846k;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.b.a$a */
    public class C0181a implements c<String> {

        /* renamed from: a */
        final /* synthetic */ k f5847a;

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.c.e f5848b;

        public C0181a(k kVar, com.aggmoread.sdk.z.d.a.a.c.e eVar) {
            this.f5847a = kVar;
            this.f5848b = eVar;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.b.a.c
        public void a(String str) {
            com.aggmoread.sdk.z.d.a.a.e.e.b("XXXXX", "title " + str);
            if (!TextUtils.isEmpty(str)) {
                if (m.j(a.this.f5843h)) {
                    this.f5847a.a(k.b.C, str);
                }
                m.a(a.this.f5841f, str);
            }
            this.f5847a.b();
            a.this.b(this.f5848b);
        }
    }

    public class b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ c f5850b;

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.b.a$b$a */
        public class RunnableC0182a implements Runnable {

            /* renamed from: b */
            final /* synthetic */ String f5852b;

            public RunnableC0182a(String str) {
                this.f5852b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = b.this.f5850b;
                if (cVar != null) {
                    cVar.a(this.f5852b);
                }
            }
        }

        public b(c cVar) {
            this.f5850b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    Thread.sleep(500L);
                    n.a(new RunnableC0182a(a.this.j()));
                } catch (Exception e10) {
                    com.aggmoread.sdk.z.d.a.a.e.e.b("XXXXX", "title info err " + e10.getMessage());
                    n.a(new RunnableC0182a(null));
                }
            } catch (Throwable th2) {
                n.a(new RunnableC0182a(null));
                throw th2;
            }
        }
    }

    public interface c<T> {
        void a(T t10);
    }

    public a(d dVar, e eVar) {
        this.f5846k = com.aggmoread.sdk.z.d.a.a.e.r.f.f6137b;
        this.f5842g = dVar;
        this.f5843h = eVar;
        this.f5845j = dVar.f5877w;
        this.f5846k = com.aggmoread.sdk.z.d.a.a.e.r.f.f6136a.a(eVar.f());
        n();
    }

    public void a(int i10, int i11) {
        com.aggmoread.sdk.z.d.a.a.e.e.a("bidding floor " + i10 + ", notice price " + i11);
        b(1, i11, null);
        i iVar = new i(1001006004, "广告无填充!");
        new k(this.f5842g, this.f5843h).a(8).a(iVar).a(k.b.f6049q, m.a(this.f5842g, this.f5843h, i10)).b();
        if (this.f5843h.l()) {
            return;
        }
        this.f5842g.f5861g.a(iVar);
    }

    public void b(int i10) {
        com.aggmoread.sdk.z.d.a.a.e.e.a("bidding win " + i10);
        if (!m.i(this.f5843h) && i10 > 0) {
            c(i10);
        }
    }

    public void c(int i10) {
    }

    public void i() {
        try {
            Map<Object, Object> a10 = l.a(this.f5842g);
            if (a10 != null) {
                Object obj = a10.get(Constants.KEYS.EXPOSED_CLICK_URL_KEY);
                Object obj2 = a10.get("image");
                Object obj3 = a10.get("mediaId");
                Object obj4 = a10.get("examineId");
                com.aggmoread.sdk.z.d.a.a.e.e.b(f5840l, "clickUrl = " + obj + ",\t image = " + obj2 + ",\t mediaId = " + obj3);
                this.f5841f.put("ext.MATERIAL_ID", obj3);
                this.f5841f.put("ext.EXAMINE_ID", obj4);
                this.f5841f.put("ext.IMG_URL", obj2);
                this.f5841f.put("ext.CLICK_URL", obj);
            }
        } catch (Exception e10) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5840l, "err " + e10.getMessage());
        }
    }

    public String j() {
        return null;
    }

    public com.aggmoread.sdk.z.d.a.a.d.a.c k() {
        com.aggmoread.sdk.z.d.a.a.d.a.c cVar = this.f5844i;
        return cVar != null ? cVar : this.f5842g.f5874t;
    }

    public void l() {
        a(new i(1001003005, "不支持的广告类型,请检查广告ID和接口是否一致: adType=" + this.f5842g.f5859e.a() + " adSource=" + this.f5843h.f()));
    }

    public boolean m() {
        return false;
    }

    public void n() {
        String c10 = this.f5843h.f5907c.c(e.c.T);
        this.f5843h.f();
        int b10 = this.f5843h.f5907c.b(e.c.V);
        this.f5841f.put(AMConst.ExtrasKey.AD_PLACEMENT_ID, c10);
        this.f5841f.put("EXTRA_KEY_network_name_text", m.d(this.f5843h));
        this.f5841f.put(AMConst.ExtrasKey.AD_PRIORITY, Integer.valueOf(b10));
        this.f5841f.put(AMConst.ExtrasKey.AD_ID, this.f5842g.f5857c);
    }

    public boolean o() {
        e eVar = this.f5843h;
        if (eVar == null || this.f5842g == null) {
            return true;
        }
        boolean z10 = (!eVar.d() || TextUtils.isEmpty(this.f5842g.f5877w) || TextUtils.isEmpty(this.f5842g.f5878x)) ? false : true;
        com.aggmoread.sdk.z.d.a.a.e.e.a("s2s " + z10);
        return !z10;
    }

    public void p() {
        if (m.c(this.f5843h)) {
            e eVar = this.f5843h;
            if (eVar != null) {
                eVar.a(false);
            }
            l();
            return;
        }
        b(new i(1001003005, "当前版本暂不支持. s =" + this.f5843h.f() + ", version: " + m.g(this.f5843h)));
    }

    public void a(com.aggmoread.sdk.z.d.a.a.c.e eVar) {
        a((Map<Object, Object>) null, eVar);
    }

    public void b(int i10, int i11, String str) {
    }

    private void a(c<String> cVar) {
        n.b(new b(cVar));
    }

    public void b(com.aggmoread.sdk.z.d.a.a.c.e eVar) {
        if (!m.b(this.f5843h) || eVar == null) {
            return;
        }
        eVar.onAdExposed();
    }

    public void b(i iVar) {
    }

    public void a(i iVar) {
        this.f5842g.a(iVar, this.f5843h, true);
        this.f5846k.a();
    }

    public void a(Map<Object, Object> map, com.aggmoread.sdk.z.d.a.a.c.e eVar) {
        String a10 = m.a(this.f5842g, this.f5843h, this.f5841f);
        k a11 = new k(this.f5842g, this.f5843h).a(6);
        a11.a(k.b.f6049q, a10);
        a11.a(map);
        if (m.e()) {
            a(new C0181a(a11, eVar));
        } else {
            a11.b();
            b(eVar);
        }
    }
}
