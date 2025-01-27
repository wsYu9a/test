package com.sigmob.sdk.downloader.core.listener.assist;

import android.util.SparseArray;
import com.sigmob.sdk.downloader.core.listener.assist.b.c;
import com.sigmob.sdk.downloader.core.listener.assist.e;
import com.sigmob.sdk.downloader.f;

/* loaded from: classes4.dex */
public class b<T extends c> implements d {

    /* renamed from: a */
    public InterfaceC0591b f19331a;

    /* renamed from: b */
    public a f19332b;

    /* renamed from: c */
    public final e<T> f19333c;

    public interface a {
        boolean a(f fVar, int i10, long j10, c cVar);

        boolean a(f fVar, int i10, c cVar);

        boolean a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, boolean z10, c cVar2);

        boolean a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc, c cVar);
    }

    /* renamed from: com.sigmob.sdk.downloader.core.listener.assist.b$b */
    public interface InterfaceC0591b {
        void a(f fVar, int i10, com.sigmob.sdk.downloader.core.breakpoint.a aVar);

        void a(f fVar, long j10);

        void a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, boolean z10, c cVar2);

        void a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc, c cVar);

        void c(f fVar, int i10, long j10);
    }

    public static class c implements e.a {

        /* renamed from: a */
        public final int f19334a;

        /* renamed from: b */
        public com.sigmob.sdk.downloader.core.breakpoint.c f19335b;

        /* renamed from: c */
        public long f19336c;

        /* renamed from: d */
        public SparseArray<Long> f19337d;

        public c(int i10) {
            this.f19334a = i10;
        }

        public long a(int i10) {
            return this.f19337d.get(i10).longValue();
        }

        public SparseArray<Long> b() {
            return this.f19337d.clone();
        }

        public SparseArray<Long> c() {
            return this.f19337d;
        }

        public long d() {
            return this.f19336c;
        }

        public com.sigmob.sdk.downloader.core.breakpoint.c e() {
            return this.f19335b;
        }

        @Override // com.sigmob.sdk.downloader.core.listener.assist.e.a
        public int a() {
            return this.f19334a;
        }

        @Override // com.sigmob.sdk.downloader.core.listener.assist.e.a
        public void a(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
            this.f19335b = cVar;
            this.f19336c = cVar.j();
            SparseArray<Long> sparseArray = new SparseArray<>();
            int b10 = cVar.b();
            for (int i10 = 0; i10 < b10; i10++) {
                sparseArray.put(i10, Long.valueOf(cVar.b(i10).c()));
            }
            this.f19337d = sparseArray;
        }
    }

    public b(e.b<T> bVar) {
        this.f19333c = new e<>(bVar);
    }

    public void a(f fVar, int i10) {
        InterfaceC0591b interfaceC0591b;
        T b10 = this.f19333c.b(fVar, fVar.n());
        if (b10 == null) {
            return;
        }
        a aVar = this.f19332b;
        if ((aVar == null || !aVar.a(fVar, i10, b10)) && (interfaceC0591b = this.f19331a) != null) {
            interfaceC0591b.a(fVar, i10, b10.f19335b.b(i10));
        }
    }

    public a b() {
        return this.f19332b;
    }

    public b(e<T> eVar) {
        this.f19333c = eVar;
    }

    public void a(f fVar, int i10, long j10) {
        InterfaceC0591b interfaceC0591b;
        T b10 = this.f19333c.b(fVar, fVar.n());
        if (b10 == null) {
            return;
        }
        long longValue = b10.f19337d.get(i10).longValue() + j10;
        b10.f19337d.put(i10, Long.valueOf(longValue));
        b10.f19336c += j10;
        a aVar = this.f19332b;
        if ((aVar == null || !aVar.a(fVar, i10, j10, b10)) && (interfaceC0591b = this.f19331a) != null) {
            interfaceC0591b.c(fVar, i10, longValue);
            this.f19331a.a(fVar, b10.f19336c);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void b(boolean z10) {
        this.f19333c.b(z10);
    }

    public void a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, boolean z10) {
        InterfaceC0591b interfaceC0591b;
        T a10 = this.f19333c.a(fVar, cVar);
        a aVar = this.f19332b;
        if ((aVar == null || !aVar.a(fVar, cVar, z10, a10)) && (interfaceC0591b = this.f19331a) != null) {
            interfaceC0591b.a(fVar, cVar, z10, a10);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public boolean a() {
        return this.f19333c.a();
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void a(boolean z10) {
        this.f19333c.a(z10);
    }

    public void a(a aVar) {
        this.f19332b = aVar;
    }

    public void a(InterfaceC0591b interfaceC0591b) {
        this.f19331a = interfaceC0591b;
    }

    public synchronized void a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        T c10 = this.f19333c.c(fVar, fVar.n());
        a aVar2 = this.f19332b;
        if (aVar2 == null || !aVar2.a(fVar, aVar, exc, c10)) {
            InterfaceC0591b interfaceC0591b = this.f19331a;
            if (interfaceC0591b != null) {
                interfaceC0591b.a(fVar, aVar, exc, c10);
            }
        }
    }
}
