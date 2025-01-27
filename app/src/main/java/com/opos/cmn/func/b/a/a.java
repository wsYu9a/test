package com.opos.cmn.func.b.a;

import android.content.Context;
import com.opos.cmn.an.g.f;
import com.opos.cmn.an.g.h;
import com.opos.cmn.func.b.b.a.g;
import com.opos.cmn.func.b.b.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class a implements f {

    /* renamed from: b */
    private g f17059b;

    /* renamed from: a */
    private HashMap<Long, Long> f17058a = new HashMap<>();

    /* renamed from: c */
    private Object f17060c = new Object();

    /* renamed from: d */
    private Object f17061d = new Object();

    /* renamed from: com.opos.cmn.func.b.a.a$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.opos.cmn.func.b.b.d f17062a;

        /* renamed from: b */
        final /* synthetic */ Context f17063b;

        /* renamed from: c */
        final /* synthetic */ com.opos.cmn.an.g.f f17064c;

        /* renamed from: d */
        final /* synthetic */ com.opos.cmn.func.b.b.c f17065d;

        /* renamed from: e */
        final /* synthetic */ a f17066e;

        @Override // java.lang.Runnable
        public void run() {
            long a2 = h.a();
            this.f17066e.a(this.f17062a.f17157e, a2);
            try {
                try {
                    com.opos.cmn.func.b.b.e a3 = this.f17066e.a(h.a(this.f17063b, a2, this.f17064c), a2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("onResponse,");
                    sb.append(a3 == null ? "null" : a3.toString());
                    com.opos.cmn.an.f.a.b("AdNetHttpImpl", sb.toString());
                    com.opos.cmn.func.b.b.c cVar = this.f17065d;
                    if (cVar != null) {
                        if (a3 == null) {
                            cVar.a(new Exception("response is null"));
                        }
                        this.f17065d.a(a3);
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("AdNetHttpImpl", "", e2);
                }
            } finally {
                this.f17066e.a(this.f17062a.f17157e);
            }
        }
    }

    /* renamed from: com.opos.cmn.func.b.a.a$a */
    private static class C0386a<K, V> extends HashMap<K, V> {
        private C0386a() {
        }

        /* synthetic */ C0386a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            String str;
            if (obj == null) {
                return null;
            }
            String str2 = (String) obj;
            Iterator<Map.Entry<K, V>> it = entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = null;
                    break;
                }
                Map.Entry<K, V> next = it.next();
                if (str2.equalsIgnoreCase((String) next.getKey())) {
                    str = (String) next.getValue();
                    break;
                }
            }
            com.opos.cmn.an.f.a.b("AdNetHttpImpl", "HeaderMap name:" + str2 + " value:" + str);
            if (str != null) {
                return (V) str;
            }
            return null;
        }
    }

    private static class b implements com.opos.cmn.func.b.b.a {

        /* renamed from: a */
        private Map<String, String> f17067a;

        public b(Map<String, String> map) {
            this.f17067a = map;
        }

        @Override // com.opos.cmn.func.b.b.a
        public String a(String str) {
            Map<String, String> map;
            if (str == null || (map = this.f17067a) == null || map.size() == 0) {
                return null;
            }
            for (Map.Entry<String, String> entry : this.f17067a.entrySet()) {
                if (str.equalsIgnoreCase(entry.getKey())) {
                    return entry.getValue();
                }
            }
            return null;
        }
    }

    public com.opos.cmn.func.b.b.e a(com.opos.cmn.an.g.g gVar, long j2) {
        C0386a c0386a = null;
        if (gVar == null) {
            return null;
        }
        Map<String, String> map = gVar.f16515e;
        if (map != null) {
            try {
                map.remove(null);
                C0386a c0386a2 = new C0386a(null);
                try {
                    for (Map.Entry<String, String> entry : gVar.f16515e.entrySet()) {
                        c0386a2.put(entry.getKey(), entry.getValue());
                    }
                } catch (Exception unused) {
                }
                c0386a = c0386a2;
            } catch (Exception unused2) {
            }
        }
        return new e.a().a(gVar.f16511a).a(gVar.f16512b).a(gVar.f16514d).a(c0386a).a(new b(gVar.f16515e)).a(gVar.f16513c).b(j2).a();
    }

    public Long a(long j2) {
        try {
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("AdNetHttpImpl", "removeRequestFromMap fail", e2);
        }
        synchronized (this.f17060c) {
            Long l = this.f17058a.get(Long.valueOf(j2));
            if (l == null) {
                return null;
            }
            this.f17058a.remove(Long.valueOf(j2));
            return l;
        }
    }

    public void a(long j2, long j3) {
        com.opos.cmn.an.f.a.b("AdNetHttpImpl", "putCall requestId=" + j2 + " taskCode=" + j3);
        synchronized (this.f17060c) {
            this.f17058a.put(Long.valueOf(j2), Long.valueOf(j3));
            com.opos.cmn.an.f.a.b("AdNetHttpImpl", "putCall mCallsMap.size()=" + this.f17058a.size());
        }
    }

    private void a(Context context, g gVar) {
        if (this.f17059b == null) {
            synchronized (this.f17061d) {
                if (this.f17059b == null) {
                    if (gVar == null) {
                        this.f17059b = com.opos.cmn.func.b.a.a.b.a(context);
                    } else {
                        this.f17059b = gVar;
                    }
                }
            }
        }
    }

    private com.opos.cmn.an.g.f b(Context context, com.opos.cmn.func.b.b.d dVar) {
        if (dVar == null) {
            return null;
        }
        com.opos.cmn.func.b.b.d a2 = com.opos.cmn.func.b.a.a.b.a(context, dVar);
        f.a aVar = new f.a();
        aVar.b(a2.f17154b);
        Map<String, String> map = a2.f17155c;
        if (map != null) {
            aVar.a(map);
        }
        if (a2.f17153a == "GET") {
            aVar.a("GET");
        }
        if (a2.f17153a == "POST") {
            aVar.a("POST");
        }
        byte[] bArr = a2.f17156d;
        if (bArr != null) {
            aVar.a(bArr);
        }
        aVar.b(this.f17059b.f17139a);
        aVar.c(this.f17059b.f17140b);
        aVar.a(this.f17059b.f17142d);
        aVar.a(this.f17059b.f17141c);
        return aVar.a();
    }

    @Override // com.opos.cmn.func.b.a.e
    public com.opos.cmn.func.b.b.e a(Context context, com.opos.cmn.func.b.b.d dVar) {
        com.opos.cmn.an.f.a.b("AdNetHttpImpl", "execSync");
        if (dVar == null || context == null) {
            return null;
        }
        try {
            try {
                Context applicationContext = context.getApplicationContext();
                a(applicationContext, (g) null);
                com.opos.cmn.an.g.f b2 = b(applicationContext, dVar);
                if (b2 != null) {
                    com.opos.cmn.an.f.a.b("AdNetHttpImpl", b2.toString());
                    long a2 = h.a();
                    a(dVar.f17157e, a2);
                    com.opos.cmn.func.b.b.e a3 = a(h.a(applicationContext, a2, b2), a2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("onResponse,");
                    sb.append(a3 == null ? "null" : a3.toString());
                    com.opos.cmn.an.f.a.b("AdNetHttpImpl", sb.toString());
                    return a3;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("AdNetHttpImpl", "execSync fail", e2);
            }
            return null;
        } finally {
            a(dVar.f17157e);
        }
    }

    @Override // com.opos.cmn.func.b.a.d
    public void a(Context context) {
        a(context, (g) null);
    }
}
