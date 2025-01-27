package com.sigmob.sdk.downloader.core.listener.assist;

import android.util.SparseArray;
import com.sigmob.sdk.downloader.core.listener.assist.b;
import com.sigmob.sdk.downloader.core.listener.assist.e;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.k;

/* loaded from: classes4.dex */
public class c implements b.a, e.b<b> {

    /* renamed from: a */
    public a f19338a;

    public interface a {
        void a(f fVar, int i10, long j10, k kVar);

        void a(f fVar, int i10, com.sigmob.sdk.downloader.core.breakpoint.a aVar, k kVar);

        void a(f fVar, long j10, k kVar);

        void a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, boolean z10, b bVar);

        void a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc, k kVar);
    }

    public static class b extends b.c {

        /* renamed from: e */
        public k f19339e;

        /* renamed from: f */
        public SparseArray<k> f19340f;

        public b(int i10) {
            super(i10);
        }

        @Override // com.sigmob.sdk.downloader.core.listener.assist.b.c, com.sigmob.sdk.downloader.core.listener.assist.e.a
        public void a(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
            super.a(cVar);
            this.f19339e = new k();
            this.f19340f = new SparseArray<>();
            int b10 = cVar.b();
            for (int i10 = 0; i10 < b10; i10++) {
                this.f19340f.put(i10, new k());
            }
        }

        public k b(int i10) {
            return this.f19340f.get(i10);
        }

        public k f() {
            return this.f19339e;
        }
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.e.b
    /* renamed from: b */
    public b a(int i10) {
        return new b(i10);
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.a
    public boolean a(f fVar, int i10, b.c cVar) {
        b bVar = (b) cVar;
        bVar.f19340f.get(i10).b();
        a aVar = this.f19338a;
        if (aVar == null) {
            return true;
        }
        aVar.a(fVar, i10, cVar.f19335b.b(i10), bVar.b(i10));
        return true;
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.a
    public boolean a(f fVar, int i10, long j10, b.c cVar) {
        b bVar = (b) cVar;
        bVar.f19340f.get(i10).a(j10);
        bVar.f19339e.a(j10);
        a aVar = this.f19338a;
        if (aVar == null) {
            return true;
        }
        aVar.a(fVar, i10, cVar.f19337d.get(i10).longValue(), bVar.b(i10));
        this.f19338a.a(fVar, cVar.f19336c, bVar.f19339e);
        return true;
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.a
    public boolean a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, boolean z10, b.c cVar2) {
        a aVar = this.f19338a;
        if (aVar == null) {
            return true;
        }
        aVar.a(fVar, cVar, z10, (b) cVar2);
        return true;
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.a
    public boolean a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc, b.c cVar) {
        k kVar = ((b) cVar).f19339e;
        if (kVar != null) {
            kVar.b();
        } else {
            kVar = new k();
        }
        a aVar2 = this.f19338a;
        if (aVar2 == null) {
            return true;
        }
        aVar2.a(fVar, aVar, exc, kVar);
        return true;
    }

    public void a(a aVar) {
        this.f19338a = aVar;
    }
}
