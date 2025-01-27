package p002continue;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import bh.a0;
import bh.b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import p002continue.f;
import p002continue.g;

/* loaded from: classes4.dex */
public abstract class c<T> {

    /* renamed from: a */
    public final String f25193a;

    /* renamed from: b */
    public final boolean f25194b;

    /* renamed from: c */
    public final Creturn f25195c;

    /* renamed from: d */
    public long f25196d = 0;

    /* renamed from: e */
    public Throwable f25197e = null;

    /* renamed from: f */
    public T f25198f;

    public static class a extends c<Object> {
        public a(Creturn creturn) {
            super(creturn, "EventLoadCompleted", false);
        }

        @Override // p002continue.c
        public final void a() {
            Creturn creturn = this.f25195c;
            creturn.c(creturn.f25218a);
        }

        @Override // p002continue.c
        public final Map<String, Object> b() {
            Map<String, Object> b10 = super.b();
            ((HashMap) b10).put("loadedIds", this.f25195c.a());
            return b10;
        }
    }

    public static class b extends c<a> {

        public static class a {

            /* renamed from: a */
            public final List<bh.h<Cimport>> f25199a;

            /* renamed from: b */
            public final List<Cimport> f25200b;

            public a(List<bh.h<Cimport>> list, List<Cimport> list2) {
                this.f25199a = list;
                this.f25200b = list2;
            }
        }

        public b(Creturn creturn) {
            super(creturn, "EventDownloadCompleted", false);
        }

        @Override // p002continue.c
        public final void a() {
            a aVar = (a) this.f25198f;
            if (aVar == null || (aVar.f25199a.size() <= 0 && aVar.f25200b.size() <= 0)) {
                Creturn creturn = this.f25195c;
                creturn.c(creturn.f25218a);
                return;
            }
            Creturn creturn2 = this.f25195c;
            creturn2.c(creturn2.f25221d);
            Creturn creturn3 = this.f25195c;
            o oVar = new o(creturn3);
            oVar.f25198f = (T) new o.a(aVar.f25199a, aVar.f25200b);
            creturn3.b(oVar);
        }

        @Override // p002continue.c
        public final Map<String, Object> b() {
            Map<String, Object> b10 = super.b();
            a aVar = (a) this.f25198f;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (aVar != null) {
                Iterator<bh.h<Cimport>> it = aVar.f25199a.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().f1621e);
                }
                Iterator<Cimport> it2 = aVar.f25200b.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(it2.next().f23do);
                }
            }
            HashMap hashMap = (HashMap) b10;
            hashMap.put("loadIds", arrayList);
            hashMap.put("deleteIds", arrayList2);
            return b10;
        }
    }

    /* renamed from: continue.c$c */
    public static class C0683c extends c<bh.h<Cimport>> {
        public C0683c(Creturn creturn) {
            super(creturn, "EventLoadFail", true);
        }

        @Override // p002continue.c
        public final void a() {
        }

        @Override // p002continue.c
        public final Map<String, Object> b() {
            Map<String, Object> b10 = super.b();
            bh.h hVar = (bh.h) this.f25198f;
            ((HashMap) b10).put("id", hVar != null ? hVar.f1621e : "");
            return b10;
        }
    }

    public static class d extends c<bh.h<Cimport>> {
        public d(Creturn creturn) {
            super(creturn, "EventLoadSuccess", true);
        }

        @Override // p002continue.c
        public final void a() {
        }

        @Override // p002continue.c
        public final Map<String, Object> b() {
            Map<String, Object> b10 = super.b();
            bh.h hVar = (bh.h) this.f25198f;
            ((HashMap) b10).put("id", hVar != null ? hVar.f1621e : "");
            return b10;
        }
    }

    public static class e extends c<String> {
        public e(Creturn creturn) {
            super(creturn, "EventQuery", true);
        }

        @Override // p002continue.c
        public final void a() {
            Creturn creturn = this.f25195c;
            creturn.c(creturn.f25219b);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    d(p002continue.a.b(this.f25195c.f25222e), System.currentTimeMillis() - currentTimeMillis);
                } catch (Exception e10) {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    Creturn creturn2 = this.f25195c;
                    h hVar = new h(creturn2);
                    hVar.f25196d = currentTimeMillis2;
                    hVar.f25197e = e10;
                    creturn2.b(hVar);
                }
            } catch (Throwable th2) {
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                Creturn creturn3 = this.f25195c;
                h hVar2 = new h(creturn3);
                hVar2.f25196d = currentTimeMillis3;
                hVar2.f25197e = th2;
                creturn3.b(hVar2);
            }
        }

        @Override // p002continue.c
        public final Map<String, Object> b() {
            Map<String, Object> b10 = super.b();
            ((HashMap) b10).put("loadedIds", this.f25195c.a());
            return b10;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<continue.import>] */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.util.ArrayList, java.util.List<continue.import>] */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayList, java.util.List<continue.import>] */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList, java.util.List<continue.import>] */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.util.ArrayList, java.util.List<continue.import>] */
        public final void d(Cnative cnative, long j10) {
            if (cnative.f32if.size() <= 0) {
                Creturn creturn = this.f25195c;
                n nVar = new n(creturn);
                RuntimeException runtimeException = new RuntimeException("response.data empty");
                nVar.f25196d = j10;
                nVar.f25197e = runtimeException;
                creturn.b(nVar);
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = cnative.f32if.iterator();
            while (it.hasNext()) {
                Cimport cimport = (Cimport) it.next();
                if (!cimport.f30try) {
                    p002continue.f fVar = f.b.f25213a;
                    if (fVar.o(cimport.f23do)) {
                        Iterator it2 = ((ArrayList) fVar.i()).iterator();
                        while (it2.hasNext()) {
                            bh.h hVar = (bh.h) it2.next();
                            if (TextUtils.equals(cimport.f23do, hVar.f1621e) && cimport.f22case > hVar.f1622f) {
                                arrayList.add(cimport);
                            }
                        }
                    } else {
                        try {
                            File file = new File(a0.f(g.a.f25217a.f25214a.f25222e, cimport.f23do, false), "local.info");
                            if (a0.l(file)) {
                                if (cimport.f22case < Cimport.m48do(a0.t(file)).f22case) {
                                }
                            }
                        } catch (IOException unused) {
                        }
                    }
                }
                arrayList.add(cimport);
            }
            cnative.f32if.clear();
            cnative.f32if.addAll(arrayList);
            if (cnative.f32if.size() <= 0) {
                Creturn creturn2 = this.f25195c;
                n nVar2 = new n(creturn2);
                nVar2.f25196d = j10;
                nVar2.f25197e = null;
                creturn2.b(nVar2);
                return;
            }
            Creturn creturn3 = this.f25195c;
            p pVar = new p(creturn3);
            pVar.f25196d = j10;
            pVar.f25197e = null;
            pVar.f25198f = (T) cnative.f32if;
            creturn3.b(pVar);
        }
    }

    public static class f extends c<bh.h<Cimport>> {
        public f(Creturn creturn) {
            super(creturn, "EventColdLoadFail", true);
        }

        @Override // p002continue.c
        public final void a() {
        }

        @Override // p002continue.c
        public final Map<String, Object> b() {
            Map<String, Object> b10 = super.b();
            bh.h hVar = (bh.h) this.f25198f;
            ((HashMap) b10).put("id", hVar != null ? hVar.f1621e : "");
            return b10;
        }
    }

    public static class g extends c<Cimport> {
        public g(Creturn creturn) {
            super(creturn, "EventDownloadFail", true);
        }

        @Override // p002continue.c
        public final void a() {
        }

        @Override // p002continue.c
        public final Map<String, Object> b() {
            Map<String, Object> b10 = super.b();
            Cimport cimport = (Cimport) this.f25198f;
            ((HashMap) b10).put("id", cimport != null ? cimport.f23do : "");
            return b10;
        }
    }

    public static class h extends c<Object> {
        public h(Creturn creturn) {
            super(creturn, "EventQueryFail", true);
        }

        @Override // p002continue.c
        public final void a() {
            Creturn creturn = this.f25195c;
            creturn.c(creturn.f25218a);
        }
    }

    public static class i extends c<Cimport> {
        public i(Creturn creturn) {
            super(creturn, "EventDeleteFail", true);
        }

        @Override // p002continue.c
        public final void a() {
        }

        @Override // p002continue.c
        public final Map<String, Object> b() {
            Map<String, Object> b10 = super.b();
            Cimport cimport = (Cimport) this.f25198f;
            ((HashMap) b10).put("id", cimport != null ? cimport.f23do : "");
            return b10;
        }
    }

    public static class j extends c<bh.h<Cimport>> {
        public j(Creturn creturn) {
            super(creturn, "EventDownloadSuccess", true);
        }

        @Override // p002continue.c
        public final void a() {
        }

        @Override // p002continue.c
        public final Map<String, Object> b() {
            Map<String, Object> b10 = super.b();
            bh.h hVar = (bh.h) this.f25198f;
            ((HashMap) b10).put("id", hVar != null ? hVar.f1621e : "");
            return b10;
        }
    }

    public static class k extends c<bh.h<Cimport>> {
        public k(Creturn creturn) {
            super(creturn, "EventColdLoadSuccess", true);
        }

        @Override // p002continue.c
        public final void a() {
        }

        @Override // p002continue.c
        public final Map<String, Object> b() {
            Map<String, Object> b10 = super.b();
            bh.h hVar = (bh.h) this.f25198f;
            ((HashMap) b10).put("id", hVar != null ? hVar.f1621e : "");
            return b10;
        }
    }

    public static class l extends c<Cimport> {
        public l(Creturn creturn) {
            super(creturn, "EventSaveLocalSuccess", true);
        }

        @Override // p002continue.c
        public final void a() {
        }

        @Override // p002continue.c
        public final Map<String, Object> b() {
            Map<String, Object> b10 = super.b();
            Cimport cimport = (Cimport) this.f25198f;
            ((HashMap) b10).put("id", cimport != null ? cimport.f23do : "");
            return b10;
        }
    }

    public static class m extends c<Cimport> {
        public m(Creturn creturn) {
            super(creturn, "EventDeleteSuccess", true);
        }

        @Override // p002continue.c
        public final void a() {
        }

        @Override // p002continue.c
        public final Map<String, Object> b() {
            Map<String, Object> b10 = super.b();
            Cimport cimport = (Cimport) this.f25198f;
            ((HashMap) b10).put("id", cimport != null ? cimport.f23do : "");
            return b10;
        }
    }

    public static class n extends c<Object> {
        public n(Creturn creturn) {
            super(creturn, "EventQueryNoPlugin", true);
        }

        @Override // p002continue.c
        public final void a() {
            Creturn creturn = this.f25195c;
            creturn.c(creturn.f25218a);
        }
    }

    public static class o extends c<a> {

        public static class a {

            /* renamed from: a */
            public final List<bh.h<Cimport>> f25201a;

            /* renamed from: b */
            public final List<Cimport> f25202b;

            public a(List<bh.h<Cimport>> list, List<Cimport> list2) {
                this.f25201a = list;
                this.f25202b = list2;
            }
        }

        public o(Creturn creturn) {
            super(creturn, "EventLoad", false);
        }

        @Override // p002continue.c
        public final void a() {
            Creturn creturn;
            a aVar;
            try {
                a aVar2 = (a) this.f25198f;
                Iterator<Cimport> it = aVar2.f25202b.iterator();
                while (it.hasNext()) {
                    e(it.next());
                }
                for (bh.h<Cimport> hVar : aVar2.f25201a) {
                    d(hVar, hVar.f1625i);
                }
                creturn = this.f25195c;
                aVar = new a(creturn);
            } catch (Throwable th2) {
                try {
                    b.a.f1608a.c("EventLoad", th2, "EventLoad FAIl");
                    creturn = this.f25195c;
                    aVar = new a(creturn);
                } catch (Throwable th3) {
                    Creturn creturn2 = this.f25195c;
                    creturn2.b(new a(creturn2));
                    throw th3;
                }
            }
            creturn.b(aVar);
        }

        @Override // p002continue.c
        public final Map<String, Object> b() {
            Map<String, Object> b10 = super.b();
            a aVar = (a) this.f25198f;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (aVar != null) {
                Iterator<bh.h<Cimport>> it = aVar.f25201a.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().f1621e);
                }
                Iterator<Cimport> it2 = aVar.f25202b.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(it2.next().f23do);
                }
            }
            HashMap hashMap = (HashMap) b10;
            hashMap.put("loadIds", arrayList);
            hashMap.put("deleteIds", arrayList2);
            return b10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void d(bh.h<Cimport> hVar, Cimport cimport) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                Cimport cimport2 = (Cimport) hVar.f1625i;
                p002continue.f fVar = f.b.f25213a;
                if (fVar.o(hVar.f1621e)) {
                    bh.h hVar2 = (bh.h) ((HashMap) fVar.t()).get(hVar.f1621e);
                    if (hVar2 != null && hVar2.f1622f < hVar.f1622f) {
                        cimport.m52if(a0.p(this.f25195c.f25222e, cimport2.f23do, true));
                    }
                    b.a.f1608a.i("EventLoad", "load exists! id:%s", cimport.f23do);
                    return;
                }
                fVar.z(hVar);
                cimport.m52if(a0.p(this.f25195c.f25222e, cimport2.f23do, true));
                Creturn creturn = this.f25195c;
                d dVar = new d(creturn);
                dVar.f25196d = System.currentTimeMillis() - currentTimeMillis;
                dVar.f25197e = null;
                dVar.f25198f = hVar;
                creturn.b(dVar);
                b.a.f1608a.i("EventLoad", "load id:%s:%s", cimport.f23do, String.valueOf(cimport.f22case));
            } catch (Throwable th2) {
                b.a.f1608a.c("EventLoad", th2, "load FAIL");
                Creturn creturn2 = this.f25195c;
                C0683c c0683c = new C0683c(creturn2);
                c0683c.f25196d = System.currentTimeMillis() - currentTimeMillis;
                c0683c.f25197e = th2;
                c0683c.f25198f = hVar;
                creturn2.b(c0683c);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void e(Cimport cimport) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                p002continue.f fVar = f.b.f25213a;
                if (fVar.o(cimport.f23do)) {
                    fVar.s(cimport.f23do);
                    Context context = this.f25195c.f25222e;
                    a0.s(a0.e(context, cimport.f23do, String.valueOf(cimport.f22case), false));
                    a0.s(a0.p(context, cimport.f23do, false));
                    Creturn creturn = this.f25195c;
                    m mVar = new m(creturn);
                    mVar.f25196d = System.currentTimeMillis() - currentTimeMillis;
                    mVar.f25197e = null;
                    mVar.f25198f = cimport;
                    creturn.b(mVar);
                    b.a.f1608a.i("EventLoad", "deleteImpl Id:%s", cimport.f23do);
                } else {
                    b.a.f1608a.m("EventLoad", "deleteImpl NoPlugin id:%s", cimport.f23do);
                }
            } catch (Throwable th2) {
                b.a.f1608a.o("EventLoad", th2, "deleteImpl FAIL id:%s", cimport.f23do);
                Creturn creturn2 = this.f25195c;
                i iVar = new i(creturn2);
                iVar.f25196d = System.currentTimeMillis() - currentTimeMillis;
                iVar.f25197e = th2;
                iVar.f25198f = cimport;
                creturn2.b(iVar);
            }
        }
    }

    public static class p extends c<List<Cimport>> {
        public p(Creturn creturn) {
            super(creturn, "EventQuerySuccess", true);
        }

        @Override // p002continue.c
        public final void a() {
            Creturn creturn = this.f25195c;
            creturn.c(creturn.f25220c);
            Creturn creturn2 = this.f25195c;
            q qVar = new q(creturn2);
            qVar.f25198f = (T) ((List) this.f25198f);
            creturn2.b(qVar);
        }

        @Override // p002continue.c
        public final Map<String, Object> b() {
            Map<String, Object> b10 = super.b();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List<Cimport> list = (List) this.f25198f;
            if (list != null) {
                for (Cimport cimport : list) {
                    if (cimport.f30try) {
                        arrayList2.add(cimport.f23do);
                    } else {
                        arrayList.add(cimport.f23do);
                    }
                }
            }
            HashMap hashMap = (HashMap) b10;
            hashMap.put("loadIds", arrayList);
            hashMap.put("deleteIds", arrayList2);
            return b10;
        }
    }

    public static class q extends c<List<Cimport>> {
        public q(Creturn creturn) {
            super(creturn, "EventDownload", false);
        }

        /* JADX WARN: Type inference failed for: r6v4, types: [T, continue.import, java.lang.Object] */
        @Override // p002continue.c
        public final void a() {
            List list = (List) this.f25198f;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            long currentTimeMillis = System.currentTimeMillis();
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ?? r62 = (T) ((Cimport) it.next());
                            if (r62.f30try) {
                                arrayList2.add(r62);
                            } else {
                                long currentTimeMillis2 = System.currentTimeMillis();
                                try {
                                    Context context = this.f25195c.f25222e;
                                    bh.h<Cimport> b10 = a0.b(context, r62);
                                    if (b10 != null) {
                                        arrayList.add(b10);
                                    } else {
                                        T t10 = (T) p002continue.a.a(context, r62, a0.d(context, r62.f23do, String.valueOf(r62.f22case)));
                                        j jVar = new j(this.f25195c);
                                        jVar.f25196d = System.currentTimeMillis() - currentTimeMillis2;
                                        jVar.f25197e = null;
                                        jVar.f25198f = t10;
                                        this.f25195c.b(jVar);
                                        arrayList.add(t10);
                                    }
                                } catch (Throwable th2) {
                                    g gVar = new g(this.f25195c);
                                    gVar.f25196d = System.currentTimeMillis() - currentTimeMillis2;
                                    gVar.f25197e = th2;
                                    gVar.f25198f = r62;
                                    this.f25195c.b(gVar);
                                }
                            }
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        b bVar = new b(this.f25195c);
                        bVar.f25196d = System.currentTimeMillis() - currentTimeMillis;
                        bVar.f25197e = th3;
                        bVar.f25198f = null;
                        this.f25195c.b(bVar);
                        b.a.f1608a.c("EventDownload", th3, "downloadIfNeed FAIL");
                    } finally {
                        Creturn creturn = this.f25195c;
                        b bVar2 = new b(creturn);
                        bVar2.f25198f = (T) new b.a(arrayList, arrayList2);
                        creturn.b(bVar2);
                    }
                }
            }
        }

        @Override // p002continue.c
        public final Map<String, Object> b() {
            Map<String, Object> b10 = super.b();
            List list = (List) this.f25198f;
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Cimport) it.next()).f23do);
                }
            }
            ((HashMap) b10).put("ids", arrayList);
            return b10;
        }
    }

    public static class r extends c<Cimport> {
        public r(Creturn creturn) {
            super(creturn, "EventSaveLocalFail", true);
        }

        @Override // p002continue.c
        public final void a() {
        }

        @Override // p002continue.c
        public final Map<String, Object> b() {
            Map<String, Object> b10 = super.b();
            Cimport cimport = (Cimport) this.f25198f;
            ((HashMap) b10).put("id", cimport != null ? cimport.f23do : "");
            return b10;
        }
    }

    public c(Creturn creturn, String str, boolean z10) {
        this.f25193a = str;
        this.f25194b = z10;
        this.f25195c = creturn;
    }

    public abstract void a();

    public Map<String, Object> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("costTime", Long.valueOf(this.f25196d));
        Throwable th2 = this.f25197e;
        hashMap.put("exception", th2 != null ? Log.getStackTraceString(th2) : "");
        return hashMap;
    }

    public final String c() {
        Map<String, Object> b10 = b();
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, Object> entry : b10.entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    jSONObject.put(entry.getKey(), value);
                }
            }
            return jSONObject.toString();
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }
}
