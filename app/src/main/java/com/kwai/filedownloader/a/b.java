package com.kwai.filedownloader.a;

import android.util.SparseArray;
import com.kwai.filedownloader.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class b implements com.kwai.filedownloader.a.a {
    final SparseArray<com.kwai.filedownloader.c.c> aGt = new SparseArray<>();
    final SparseArray<List<com.kwai.filedownloader.c.a>> aGu = new SparseArray<>();

    class a implements a.InterfaceC0237a {
        a() {
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0237a
        public final void Hy() {
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0237a
        public final void a(int i2, com.kwai.filedownloader.c.c cVar) {
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0237a
        public final void c(com.kwai.filedownloader.c.c cVar) {
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwai.filedownloader.c.c> iterator() {
            return b.this.new C0238b();
        }
    }

    /* renamed from: com.kwai.filedownloader.a.b$b */
    class C0238b implements Iterator<com.kwai.filedownloader.c.c> {
        C0238b() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final /* bridge */ /* synthetic */ com.kwai.filedownloader.c.c next() {
            return null;
        }

        @Override // java.util.Iterator
        public final void remove() {
        }
    }

    private void d(com.kwai.filedownloader.c.c cVar) {
        synchronized (this.aGt) {
            this.aGt.put(cVar.getId(), cVar);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void A(int i2, int i3) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final a.InterfaceC0237a Hx() {
        return new a();
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, int i3, long j2) {
        List<com.kwai.filedownloader.c.a> list;
        synchronized (this.aGu) {
            list = this.aGu.get(i2);
        }
        if (list == null) {
            return;
        }
        for (com.kwai.filedownloader.c.a aVar : list) {
            if (aVar.getIndex() == i3) {
                aVar.am(j2);
                return;
            }
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, long j2, String str, String str2) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, String str, long j2, long j3, int i3) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, Throwable th) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, Throwable th, long j2) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(com.kwai.filedownloader.c.a aVar) {
        List<com.kwai.filedownloader.c.a> list;
        try {
            int id = aVar.getId();
            synchronized (this.aGu) {
                list = this.aGu.get(id);
                if (list == null) {
                    list = new ArrayList<>();
                    this.aGu.put(id, list);
                }
            }
            list.add(aVar);
        } catch (Exception unused) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void b(com.kwai.filedownloader.c.c cVar) {
        if (cVar == null) {
            com.kwai.filedownloader.e.d.h(this, "update but model == null!", new Object[0]);
            return;
        }
        if (cI(cVar.getId()) == null) {
            d(cVar);
            return;
        }
        synchronized (this.aGt) {
            this.aGt.remove(cVar.getId());
            this.aGt.put(cVar.getId(), cVar);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cH(int i2) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final com.kwai.filedownloader.c.c cI(int i2) {
        com.kwai.filedownloader.c.c cVar;
        synchronized (this.aGt) {
            cVar = this.aGt.get(i2);
        }
        return cVar;
    }

    @Override // com.kwai.filedownloader.a.a
    public final List<com.kwai.filedownloader.c.a> cJ(int i2) {
        List<com.kwai.filedownloader.c.a> list;
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (this.aGu) {
                list = this.aGu.get(i2);
            }
            if (list != null) {
                arrayList.addAll(list);
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cK(int i2) {
        try {
            synchronized (this.aGu) {
                this.aGu.remove(i2);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final boolean cL(int i2) {
        synchronized (this.aGt) {
            this.aGt.remove(i2);
        }
        return true;
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cM(int i2) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final void clear() {
        synchronized (this.aGt) {
            this.aGt.clear();
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void e(int i2, long j2) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final void f(int i2, long j2) {
        cL(i2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void g(int i2, long j2) {
    }
}
