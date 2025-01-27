package com.shu.priory.download;

import android.content.Context;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.download.b.c;
import com.shu.priory.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public class a implements com.shu.priory.download.a.b, c.a {

    /* renamed from: a */
    private static a f16927a;

    /* renamed from: e */
    private com.shu.priory.download.b.a f16931e;

    /* renamed from: f */
    private com.shu.priory.download.c.a f16932f;

    /* renamed from: g */
    private Context f16933g;

    /* renamed from: d */
    private List<com.shu.priory.download.d.a> f16930d = new ArrayList();

    /* renamed from: c */
    private ConcurrentHashMap<Integer, com.shu.priory.download.b.a.a> f16929c = new ConcurrentHashMap<>();

    /* renamed from: b */
    private ExecutorService f16928b = Executors.newFixedThreadPool(2);

    private a(Context context) {
        this.f16933g = context;
        com.shu.priory.download.c.b bVar = new com.shu.priory.download.c.b(context);
        this.f16932f = bVar;
        this.f16931e = new com.shu.priory.download.b.b(bVar);
    }

    public static com.shu.priory.download.a.b a(Context context) {
        synchronized (a.class) {
            try {
                if (f16927a == null) {
                    f16927a = new a(context);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f16927a;
    }

    private void c() {
        for (com.shu.priory.download.d.a aVar : this.f16930d) {
            if (aVar.g() == 3) {
                h(aVar);
                return;
            }
        }
    }

    private void h(com.shu.priory.download.d.a aVar) {
        if (this.f16929c.size() >= 2) {
            aVar.a(3);
            this.f16931e.a(aVar);
            return;
        }
        com.shu.priory.download.b.c cVar = new com.shu.priory.download.b.c(this.f16928b, this.f16931e, aVar, this);
        this.f16929c.put(Integer.valueOf(aVar.h()), cVar);
        aVar.a(1);
        this.f16931e.a(aVar);
        cVar.a();
    }

    @Override // com.shu.priory.download.a.b
    public com.shu.priory.download.d.a b(int i10) {
        return this.f16932f.a(i10);
    }

    @Override // com.shu.priory.download.a.b
    public void d(com.shu.priory.download.d.a aVar) {
        h.a(SDKConstants.TAG, "resume download");
        aVar.a(7);
        this.f16931e.a(aVar);
        com.shu.priory.download.b.a.a aVar2 = this.f16929c.get(Integer.valueOf(aVar.h()));
        if (aVar2 != null) {
            aVar2.a();
        }
    }

    @Override // com.shu.priory.download.a.b
    public void e(com.shu.priory.download.d.a aVar) {
        h.a(SDKConstants.TAG, "cancel download");
        aVar.a(8);
        this.f16931e.a(aVar);
        File file = new File(aVar.c());
        this.f16929c.remove(Integer.valueOf(aVar.h()));
        this.f16930d.remove(aVar);
        if (file.exists()) {
            file.delete();
        }
    }

    @Override // com.shu.priory.download.b.c.a
    public void f(com.shu.priory.download.d.a aVar) {
        if (aVar != null) {
            this.f16929c.remove(Integer.valueOf(aVar.h()));
            this.f16930d.remove(aVar);
        }
        c();
    }

    @Override // com.shu.priory.download.b.c.a
    public void g(com.shu.priory.download.d.a aVar) {
        if (aVar != null) {
            this.f16929c.remove(Integer.valueOf(aVar.h()));
            this.f16930d.remove(aVar);
        }
    }

    @Override // com.shu.priory.download.a.b
    public com.shu.priory.download.d.a a(int i10) {
        for (com.shu.priory.download.d.a aVar : this.f16930d) {
            if (aVar.h() == i10) {
                return aVar;
            }
        }
        return null;
    }

    @Override // com.shu.priory.download.a.b
    public void b() {
        try {
            for (com.shu.priory.download.d.a aVar : a()) {
                File file = new File(aVar.c());
                if (file.exists() && file.delete()) {
                    this.f16932f.b(aVar);
                }
            }
        } catch (Exception e10) {
            h.d(SDKConstants.TAG, "clearAllDownloaded:" + e10.getMessage());
        }
    }

    @Override // com.shu.priory.download.a.b
    public void c(com.shu.priory.download.d.a aVar) {
        h.a(SDKConstants.TAG, "pause download");
        aVar.a(6);
        this.f16931e.a(aVar);
    }

    public List<com.shu.priory.download.d.a> a() {
        return this.f16932f.a();
    }

    public void b(com.shu.priory.download.d.a aVar) {
        this.f16930d.add(aVar);
        h(aVar);
    }

    @Override // com.shu.priory.download.a.b
    public void a(com.shu.priory.download.d.a aVar) {
        b(aVar);
    }
}
