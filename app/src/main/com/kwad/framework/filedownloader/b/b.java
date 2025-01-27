package com.kwad.framework.filedownloader.b;

import android.util.SparseArray;
import com.kwad.framework.filedownloader.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class b implements com.kwad.framework.filedownloader.b.a {
    final SparseArray<com.kwad.framework.filedownloader.d.c> aiw = new SparseArray<>();
    final SparseArray<List<com.kwad.framework.filedownloader.d.a>> aix = new SparseArray<>();

    public class a implements a.InterfaceC0463a {
        public a() {
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0463a
        public final void a(int i10, com.kwad.framework.filedownloader.d.c cVar) {
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0463a
        public final void c(com.kwad.framework.filedownloader.d.c cVar) {
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwad.framework.filedownloader.d.c> iterator() {
            return b.this.new C0464b();
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0463a
        public final void wo() {
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.b.b$b */
    public class C0464b implements Iterator<com.kwad.framework.filedownloader.d.c> {
        public C0464b() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final /* bridge */ /* synthetic */ com.kwad.framework.filedownloader.d.c next() {
            return null;
        }

        @Override // java.util.Iterator
        public final void remove() {
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, long j10, String str, String str2) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(int i10, long j10) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bk(int i10) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c bl(int i10) {
        com.kwad.framework.filedownloader.d.c cVar;
        synchronized (this.aiw) {
            cVar = this.aiw.get(i10);
        }
        return cVar;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final List<com.kwad.framework.filedownloader.d.a> bm(int i10) {
        List<com.kwad.framework.filedownloader.d.a> list;
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (this.aix) {
                list = this.aix.get(i10);
            }
            if (list != null) {
                arrayList.addAll(list);
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bn(int i10) {
        try {
            synchronized (this.aix) {
                this.aix.remove(i10);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean bo(int i10) {
        synchronized (this.aiw) {
            this.aiw.remove(i10);
        }
        return true;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bp(int i10) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i10, long j10) {
        bo(i10);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        synchronized (this.aiw) {
            this.aiw.clear();
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i10, long j10) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void s(int i10, int i11) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0463a wn() {
        return new a();
    }

    private void d(com.kwad.framework.filedownloader.d.c cVar) {
        synchronized (this.aiw) {
            this.aiw.put(cVar.getId(), cVar);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, String str, long j10, long j11, int i11) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
            return;
        }
        if (bl(cVar.getId()) == null) {
            d(cVar);
            return;
        }
        synchronized (this.aiw) {
            this.aiw.remove(cVar.getId());
            this.aiw.put(cVar.getId(), cVar);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, Throwable th2) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, Throwable th2, long j10) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        List<com.kwad.framework.filedownloader.d.a> list;
        try {
            int id2 = aVar.getId();
            synchronized (this.aix) {
                try {
                    list = this.aix.get(id2);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.aix.put(id2, list);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            list.add(aVar);
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, int i11, long j10) {
        List<com.kwad.framework.filedownloader.d.a> list;
        synchronized (this.aix) {
            list = this.aix.get(i10);
        }
        if (list == null) {
            return;
        }
        for (com.kwad.framework.filedownloader.d.a aVar : list) {
            if (aVar.getIndex() == i11) {
                aVar.R(j10);
                return;
            }
        }
    }
}
