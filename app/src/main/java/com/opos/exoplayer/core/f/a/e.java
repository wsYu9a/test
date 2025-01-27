package com.opos.exoplayer.core.f.a;

import androidx.annotation.NonNull;
import com.opos.exoplayer.core.f.h;
import com.opos.exoplayer.core.f.i;
import java.util.LinkedList;
import java.util.PriorityQueue;

/* loaded from: classes4.dex */
abstract class e implements com.opos.exoplayer.core.f.e {

    /* renamed from: a */
    private final LinkedList<a> f18607a = new LinkedList<>();

    /* renamed from: b */
    private final LinkedList<i> f18608b;

    /* renamed from: c */
    private final PriorityQueue<a> f18609c;

    /* renamed from: d */
    private a f18610d;

    /* renamed from: e */
    private long f18611e;

    /* renamed from: f */
    private long f18612f;

    private static final class a extends h implements Comparable<a> {

        /* renamed from: e */
        private long f18613e;

        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(@NonNull a aVar) {
            if (c() == aVar.c()) {
                long j2 = this.f17740c - aVar.f17740c;
                if (j2 == 0) {
                    j2 = this.f18613e - aVar.f18613e;
                    if (j2 == 0) {
                        return 0;
                    }
                }
                if (j2 <= 0) {
                    return -1;
                }
            } else if (!c()) {
                return -1;
            }
            return 1;
        }
    }

    private final class b extends i {
        private b() {
        }

        /* synthetic */ b(e eVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.opos.exoplayer.core.f.i
        public final void e() {
            e.this.a((i) this);
        }
    }

    public e() {
        for (int i2 = 0; i2 < 10; i2++) {
            this.f18607a.add(new a());
        }
        this.f18608b = new LinkedList<>();
        for (int i3 = 0; i3 < 2; i3++) {
            this.f18608b.add(new b());
        }
        this.f18609c = new PriorityQueue<>();
    }

    private void a(a aVar) {
        aVar.a();
        this.f18607a.add(aVar);
    }

    @Override // com.opos.exoplayer.core.f.e
    public void a(long j2) {
        this.f18611e = j2;
    }

    protected abstract void a(h hVar);

    protected void a(i iVar) {
        iVar.a();
        this.f18608b.add(iVar);
    }

    @Override // com.opos.exoplayer.core.b.c
    /* renamed from: b */
    public void a(h hVar) {
        com.opos.exoplayer.core.i.a.a(hVar == this.f18610d);
        if (hVar.d_()) {
            a(this.f18610d);
        } else {
            a aVar = this.f18610d;
            long j2 = this.f18612f;
            this.f18612f = 1 + j2;
            aVar.f18613e = j2;
            this.f18609c.add(this.f18610d);
        }
        this.f18610d = null;
    }

    @Override // com.opos.exoplayer.core.b.c
    public void c() {
        this.f18612f = 0L;
        this.f18611e = 0L;
        while (!this.f18609c.isEmpty()) {
            a(this.f18609c.poll());
        }
        a aVar = this.f18610d;
        if (aVar != null) {
            a(aVar);
            this.f18610d = null;
        }
    }

    @Override // com.opos.exoplayer.core.b.c
    public void d() {
    }

    protected abstract boolean e();

    protected abstract com.opos.exoplayer.core.f.d f();

    @Override // com.opos.exoplayer.core.b.c
    /* renamed from: g */
    public i b() {
        i iVar = null;
        if (!this.f18608b.isEmpty()) {
            while (!this.f18609c.isEmpty() && this.f18609c.peek().f17740c <= this.f18611e) {
                a poll = this.f18609c.poll();
                if (poll.c()) {
                    iVar = this.f18608b.pollFirst();
                    iVar.b(4);
                } else {
                    a((h) poll);
                    if (e()) {
                        com.opos.exoplayer.core.f.d f2 = f();
                        if (!poll.d_()) {
                            iVar = this.f18608b.pollFirst();
                            iVar.a(poll.f17740c, f2, Long.MAX_VALUE);
                        }
                    }
                    a(poll);
                }
                a(poll);
            }
        }
        return iVar;
    }

    @Override // com.opos.exoplayer.core.b.c
    /* renamed from: h */
    public h a() {
        com.opos.exoplayer.core.i.a.b(this.f18610d == null);
        if (this.f18607a.isEmpty()) {
            return null;
        }
        a pollFirst = this.f18607a.pollFirst();
        this.f18610d = pollFirst;
        return pollFirst;
    }
}
