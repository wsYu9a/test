package p002continue;

import android.content.Context;
import bh.a0;
import bh.b;
import bh.h;
import bh.j;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p002continue.a;
import p002continue.c;
import p002continue.f;

/* loaded from: classes4.dex */
public final class d extends c<Object> {

    /* renamed from: g */
    public final List<String> f25203g;

    /* renamed from: h */
    public final List<c<?>> f25204h;

    public d(Creturn creturn) {
        super(creturn, "EventColdLoad", false);
        this.f25203g = new ArrayList();
        this.f25204h = new ArrayList();
    }

    public static List<h<Cimport>> d(Creturn creturn) {
        ArrayList arrayList = new ArrayList();
        Context context = creturn.f25222e;
        ArrayList arrayList2 = new ArrayList();
        File[] listFiles = a0.c(context).listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                File g10 = a0.g(file);
                if (a0.l(g10)) {
                    try {
                        Cimport m48do = Cimport.m48do(a0.t(g10));
                        arrayList2.add(a0.d(context, m48do.f23do, String.valueOf(m48do.f22case)));
                    } catch (IOException unused) {
                    }
                }
            }
        }
        if (arrayList2.size() > 0) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                File file2 = (File) it.next();
                if (file2.exists() && file2.isFile()) {
                    try {
                        arrayList.add(a0.o(file2));
                    } catch (Throwable th2) {
                        j jVar = b.a.f1608a;
                        StringBuilder a10 = nh.b.a("buildPlugin FAIL：");
                        a10.append(file2.getPath());
                        jVar.c("EventColdLoad", th2, a10.toString());
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, java.util.List<continue.c<?>>] */
    /* JADX WARN: Type inference failed for: r6v2, types: [T, bh.h] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.util.ArrayList, java.util.List<continue.c<?>>] */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.util.ArrayList, java.util.List<continue.c<?>>] */
    @Override // p002continue.c
    public final void a() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            e();
            Iterator it = ((ArrayList) d(this.f25195c)).iterator();
            while (it.hasNext()) {
                ?? r62 = (h) it.next();
                f fVar = f.b.f25213a;
                if (fVar.o(r62.f1621e)) {
                    b.a.f1608a.i("EventColdLoad", "load FAIL isPluginLoaded, id:%s model:%s", r62.f1621e, r62.f1625i);
                } else {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    try {
                        fVar.z(r62);
                        c.k kVar = new c.k(this.f25195c);
                        kVar.f25196d = System.currentTimeMillis() - currentTimeMillis2;
                        kVar.f25197e = null;
                        kVar.f25198f = r62;
                        this.f25204h.add(kVar);
                        b.a.f1608a.k("EventColdLoad", "load OK, id:" + r62.f1621e + ":" + r62.f1622f + ",cost " + (System.currentTimeMillis() - currentTimeMillis2) + "ms");
                        this.f25203g.add(r62.f1621e);
                    } catch (Throwable th2) {
                        b.a.f1608a.c("EventColdLoad", th2, "load FAIL, id:" + r62.f1621e + ":" + r62.f1622f + ",cost " + (System.currentTimeMillis() - currentTimeMillis2) + "ms");
                        ?? r82 = this.f25204h;
                        c.f fVar2 = new c.f(this.f25195c);
                        fVar2.f25196d = System.currentTimeMillis() - currentTimeMillis2;
                        fVar2.f25197e = th2;
                        fVar2.f25198f = r62;
                        r82.add(fVar2);
                    }
                }
            }
        } catch (Throwable th3) {
            ?? r12 = this.f25204h;
            c.f fVar3 = new c.f(this.f25195c);
            fVar3.f25196d = System.currentTimeMillis() - currentTimeMillis;
            fVar3.f25197e = th3;
            r12.add(fVar3);
        }
    }

    @Override // p002continue.c
    public final Map<String, Object> b() {
        Map<String, Object> b10 = super.b();
        ((HashMap) b10).put("ids", this.f25203g);
        return b10;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.ArrayList, java.util.List<continue.import>] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.ArrayList, java.util.List<continue.import>] */
    /* JADX WARN: Type inference failed for: r3v5, types: [T, continue.import] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.ArrayList, java.util.List<continue.c<?>>] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.ArrayList, java.util.List<continue.c<?>>] */
    public final void e() {
        Context context = this.f25195c.f25222e;
        try {
            Cnative m53do = Cnative.m53do(new JSONObject(new String(a.C0682a.a(context, "file:///android_asset/catpie/update.json"), "UTF-8")));
            ?? r32 = m53do.f32if;
            if (r32 == 0 || r32.size() <= 0) {
                return;
            }
            Iterator it = m53do.f32if.iterator();
            while (it.hasNext()) {
                ?? r33 = (Cimport) it.next();
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    File d10 = a0.d(context, r33.f23do, String.valueOf(r33.f22case));
                    File e10 = a0.e(context, r33.f23do, String.valueOf(r33.f22case), false);
                    if (!a0.l(d10) || !a0.l(e10) || Cimport.m47do(e10) == null || !a0.k(r33, d10)) {
                        r33.f21break = true;
                        a.a(context, r33, d10);
                        try {
                            r33.m52if(new File(d10.getParent(), "local.info"));
                        } catch (Throwable unused) {
                        }
                        try {
                            r33.m52if(new File(a0.f(context, r33.f23do, true), "local.info"));
                        } catch (Throwable unused2) {
                        }
                        ?? r62 = this.f25204h;
                        c.l lVar = new c.l(this.f25195c);
                        lVar.f25198f = r33;
                        lVar.f25196d = System.currentTimeMillis() - currentTimeMillis;
                        lVar.f25197e = null;
                        r62.add(lVar);
                    }
                } catch (Throwable th2) {
                    ?? r72 = this.f25204h;
                    c.r rVar = new c.r(this.f25195c);
                    rVar.f25198f = r33;
                    rVar.f25196d = System.currentTimeMillis() - currentTimeMillis;
                    rVar.f25197e = th2;
                    r72.add(rVar);
                }
            }
        } catch (JSONException e11) {
            throw new RuntimeException(e11);
        }
    }
}
