package com.sigmob.sdk.downloader.core.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class f implements com.sigmob.sdk.downloader.c {

    /* renamed from: a */
    public final com.sigmob.sdk.downloader.c[] f19347a;

    public static class a {

        /* renamed from: a */
        public List<com.sigmob.sdk.downloader.c> f19348a = new ArrayList();

        public a a(com.sigmob.sdk.downloader.c cVar) {
            if (cVar != null && !this.f19348a.contains(cVar)) {
                this.f19348a.add(cVar);
            }
            return this;
        }

        public boolean b(com.sigmob.sdk.downloader.c cVar) {
            return this.f19348a.remove(cVar);
        }

        public f a() {
            List<com.sigmob.sdk.downloader.c> list = this.f19348a;
            return new f((com.sigmob.sdk.downloader.c[]) list.toArray(new com.sigmob.sdk.downloader.c[list.size()]));
        }
    }

    public f(com.sigmob.sdk.downloader.c[] cVarArr) {
        this.f19347a = cVarArr;
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, int i10, int i11, Map<String, List<String>> map) {
        for (com.sigmob.sdk.downloader.c cVar : this.f19347a) {
            cVar.a(fVar, i10, i11, map);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void b(com.sigmob.sdk.downloader.f fVar, int i10, Map<String, List<String>> map) {
        for (com.sigmob.sdk.downloader.c cVar : this.f19347a) {
            cVar.b(fVar, i10, map);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void d(com.sigmob.sdk.downloader.f fVar, int i10, long j10) {
        for (com.sigmob.sdk.downloader.c cVar : this.f19347a) {
            cVar.d(fVar, i10, j10);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, int i10, Map<String, List<String>> map) {
        for (com.sigmob.sdk.downloader.c cVar : this.f19347a) {
            cVar.a(fVar, i10, map);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void b(com.sigmob.sdk.downloader.f fVar, int i10, long j10) {
        for (com.sigmob.sdk.downloader.c cVar : this.f19347a) {
            cVar.b(fVar, i10, j10);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, Map<String, List<String>> map) {
        for (com.sigmob.sdk.downloader.c cVar : this.f19347a) {
            cVar.a(fVar, map);
        }
    }

    public int b(com.sigmob.sdk.downloader.c cVar) {
        int i10 = 0;
        while (true) {
            com.sigmob.sdk.downloader.c[] cVarArr = this.f19347a;
            if (i10 >= cVarArr.length) {
                return -1;
            }
            if (cVarArr[i10] == cVar) {
                return i10;
            }
            i10++;
        }
    }

    public boolean a(com.sigmob.sdk.downloader.c cVar) {
        for (com.sigmob.sdk.downloader.c cVar2 : this.f19347a) {
            if (cVar2 == cVar) {
                return true;
            }
        }
        return false;
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, com.sigmob.sdk.downloader.core.cause.b bVar) {
        for (com.sigmob.sdk.downloader.c cVar2 : this.f19347a) {
            cVar2.a(fVar, cVar, bVar);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        for (com.sigmob.sdk.downloader.c cVar2 : this.f19347a) {
            cVar2.a(fVar, cVar);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, int i10, long j10) {
        for (com.sigmob.sdk.downloader.c cVar : this.f19347a) {
            cVar.a(fVar, i10, j10);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        for (com.sigmob.sdk.downloader.c cVar : this.f19347a) {
            cVar.a(fVar, aVar, exc);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar) {
        for (com.sigmob.sdk.downloader.c cVar : this.f19347a) {
            cVar.a(fVar);
        }
    }
}
