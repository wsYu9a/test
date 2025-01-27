package com.sigmob.sdk.downloader;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class m {

    /* renamed from: b */
    public final List<Integer> f19452b = new ArrayList();

    /* renamed from: c */
    public final c f19453c = new a();

    /* renamed from: a */
    public final SparseArray<ArrayList<c>> f19451a = new SparseArray<>();

    public class a implements c {
        public a() {
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(f fVar, int i10, int i11, Map<String, List<String>> map) {
            c[] b10 = m.b(fVar, m.this.f19451a);
            if (b10 == null) {
                return;
            }
            for (c cVar : b10) {
                if (cVar != null) {
                    cVar.a(fVar, i10, i11, map);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void b(f fVar, int i10, Map<String, List<String>> map) {
            c[] b10 = m.b(fVar, m.this.f19451a);
            if (b10 == null) {
                return;
            }
            for (c cVar : b10) {
                if (cVar != null) {
                    cVar.b(fVar, i10, map);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void d(f fVar, int i10, long j10) {
            c[] b10 = m.b(fVar, m.this.f19451a);
            if (b10 == null) {
                return;
            }
            for (c cVar : b10) {
                if (cVar != null) {
                    cVar.d(fVar, i10, j10);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(f fVar, int i10, Map<String, List<String>> map) {
            c[] b10 = m.b(fVar, m.this.f19451a);
            if (b10 == null) {
                return;
            }
            for (c cVar : b10) {
                if (cVar != null) {
                    cVar.a(fVar, i10, map);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void b(f fVar, int i10, long j10) {
            c[] b10 = m.b(fVar, m.this.f19451a);
            if (b10 == null) {
                return;
            }
            for (c cVar : b10) {
                if (cVar != null) {
                    cVar.b(fVar, i10, j10);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(f fVar, Map<String, List<String>> map) {
            c[] b10 = m.b(fVar, m.this.f19451a);
            if (b10 == null) {
                return;
            }
            for (c cVar : b10) {
                if (cVar != null) {
                    cVar.a(fVar, map);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, com.sigmob.sdk.downloader.core.cause.b bVar) {
            c[] b10 = m.b(fVar, m.this.f19451a);
            if (b10 == null) {
                return;
            }
            for (c cVar2 : b10) {
                if (cVar2 != null) {
                    cVar2.a(fVar, cVar, bVar);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
            c[] b10 = m.b(fVar, m.this.f19451a);
            if (b10 == null) {
                return;
            }
            for (c cVar2 : b10) {
                if (cVar2 != null) {
                    cVar2.a(fVar, cVar);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(f fVar, int i10, long j10) {
            c[] b10 = m.b(fVar, m.this.f19451a);
            if (b10 == null) {
                return;
            }
            for (c cVar : b10) {
                if (cVar != null) {
                    cVar.a(fVar, i10, j10);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
            c[] b10 = m.b(fVar, m.this.f19451a);
            if (b10 == null) {
                return;
            }
            for (c cVar : b10) {
                if (cVar != null) {
                    cVar.a(fVar, aVar, exc);
                }
            }
            if (m.this.f19452b.contains(Integer.valueOf(fVar.b()))) {
                m.this.b(fVar.b());
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(f fVar) {
            c[] b10 = m.b(fVar, m.this.f19451a);
            if (b10 == null) {
                return;
            }
            for (c cVar : b10) {
                if (cVar != null) {
                    cVar.a(fVar);
                }
            }
        }
    }

    public synchronized void b(f fVar, c cVar) {
        try {
            int b10 = fVar.b();
            ArrayList<c> arrayList = this.f19451a.get(b10);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f19451a.put(b10, arrayList);
            }
            if (!arrayList.contains(cVar)) {
                arrayList.add(cVar);
                if (cVar instanceof com.sigmob.sdk.downloader.core.listener.assist.d) {
                    ((com.sigmob.sdk.downloader.core.listener.assist.d) cVar).a(true);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized boolean c(f fVar, c cVar) {
        int b10 = fVar.b();
        ArrayList<c> arrayList = this.f19451a.get(b10);
        if (arrayList == null) {
            return false;
        }
        boolean remove = arrayList.remove(cVar);
        if (arrayList.isEmpty()) {
            this.f19451a.remove(b10);
        }
        return remove;
    }

    public synchronized void d(f fVar, c cVar) {
        b(fVar, cVar);
        fVar.a(this.f19453c);
    }

    public synchronized void e(f fVar, c cVar) {
        b(fVar, cVar);
        fVar.b(this.f19453c);
    }

    public synchronized void a(int i10) {
        if (this.f19452b.contains(Integer.valueOf(i10))) {
            return;
        }
        this.f19452b.add(Integer.valueOf(i10));
    }

    public synchronized void b(int i10) {
        this.f19451a.remove(i10);
    }

    public synchronized void c(int i10) {
        this.f19452b.remove(Integer.valueOf(i10));
    }

    public static c[] b(f fVar, SparseArray<ArrayList<c>> sparseArray) {
        ArrayList<c> arrayList = sparseArray.get(fVar.b());
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        c[] cVarArr = new c[arrayList.size()];
        arrayList.toArray(cVarArr);
        return cVarArr;
    }

    public synchronized void a(f fVar, c cVar) {
        b(fVar, cVar);
        if (!a(fVar)) {
            fVar.a(this.f19453c);
        }
    }

    public synchronized void a(c cVar) {
        try {
            int size = this.f19451a.size();
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < size; i10++) {
                ArrayList<c> valueAt = this.f19451a.valueAt(i10);
                if (valueAt != null) {
                    valueAt.remove(cVar);
                    if (valueAt.isEmpty()) {
                        arrayList.add(Integer.valueOf(this.f19451a.keyAt(i10)));
                    }
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f19451a.remove(((Integer) it.next()).intValue());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public c a() {
        return this.f19453c;
    }

    public boolean a(f fVar) {
        return l.e(fVar);
    }
}
