package com.martian.mibook.lib.model.f;

import android.os.Handler;
import com.martian.mibook.lib.model.c.g;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import java.util.Hashtable;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a */
    private final g f13999a;

    /* renamed from: b */
    private final int f14000b;

    /* renamed from: d */
    private final int f14002d;

    /* renamed from: e */
    private final ChapterList f14003e;

    /* renamed from: f */
    private final com.martian.mibook.lib.model.c.b f14004f;

    /* renamed from: g */
    private boolean f14005g = false;

    /* renamed from: h */
    private final int f14006h = Runtime.getRuntime().availableProcessors() + 1;

    /* renamed from: i */
    private final com.martian.mibook.lib.model.d.g f14007i = new a();

    /* renamed from: c */
    private int f14001c = 0;

    class a implements com.martian.mibook.lib.model.d.g {

        /* renamed from: a */
        private final Map<Integer, Integer> f14008a = new Hashtable();

        /* renamed from: b */
        private int f14009b = 0;

        /* renamed from: c */
        private int f14010c = 0;

        /* renamed from: d */
        private boolean f14011d = false;

        /* renamed from: e */
        private int f14012e = -1;

        a() {
        }

        private boolean c() {
            return this.f14009b > 20;
        }

        private void d(int index) {
            this.f14009b++;
        }

        @Override // com.martian.mibook.lib.model.d.g
        public void a(int chapterIndex, b.d.c.b.c errorResult) {
            if (c.this.h()) {
                return;
            }
            if (c()) {
                if (this.f14011d) {
                    return;
                }
                int i2 = this.f14012e;
                if (i2 != -1) {
                    c.this.t(i2);
                }
                c.this.q(new b.d.c.b.c(-1, "Missing too much chapters."));
                this.f14011d = true;
                return;
            }
            Integer num = this.f14008a.get(Integer.valueOf(chapterIndex));
            if (num == null || num.intValue() <= 2) {
                if (num == null) {
                    num = 0;
                }
                this.f14008a.put(Integer.valueOf(chapterIndex), Integer.valueOf(num.intValue() + 1));
                c.this.s(chapterIndex);
                return;
            }
            d(chapterIndex);
            if (c.this.f14001c < c.this.f14002d) {
                c cVar = c.this;
                cVar.s(cVar.f14000b + c.d(c.this));
            } else {
                int i3 = this.f14012e;
                if (i3 != -1) {
                    c.this.t(i3);
                }
                c.this.n(this.f14009b);
            }
        }

        @Override // com.martian.mibook.lib.model.d.g
        public void b(int chapterIndex, ChapterContent chapterContent) {
            this.f14010c++;
            this.f14012e = Math.max(chapterIndex, this.f14012e);
            if (c()) {
                if (this.f14011d) {
                    return;
                }
                int i2 = this.f14012e;
                if (i2 != -1) {
                    c.this.t(i2);
                }
                c.this.q(new b.d.c.b.c(-1, "Missing too much chapters."));
                this.f14011d = true;
                return;
            }
            c cVar = c.this;
            cVar.m(Integer.valueOf((cVar.f14000b + c.this.f14001c) - 1), Integer.valueOf(c.this.f14000b + c.this.f14002d), 0);
            if (this.f14010c + this.f14009b >= c.this.f14002d) {
                c cVar2 = c.this;
                cVar2.t((cVar2.f14000b + c.this.f14001c) - 1);
                int i3 = this.f14009b;
                if (i3 > 0) {
                    c.this.n(i3);
                    return;
                } else {
                    c.this.l();
                    return;
                }
            }
            if (c.this.f14001c >= c.this.f14002d) {
                return;
            }
            if (c.this.h()) {
                c cVar3 = c.this;
                cVar3.t((cVar3.f14000b + c.this.f14001c) - 1);
            } else {
                c cVar4 = c.this;
                cVar4.s(cVar4.f14000b + c.d(c.this));
            }
        }
    }

    public c(g source, ChapterList chapterList, int start, int size, com.martian.mibook.lib.model.c.b bookProvider) {
        this.f13999a = source;
        this.f14003e = chapterList;
        this.f14000b = start;
        int count = chapterList.getCount() - start;
        this.f14002d = size > count ? count : size;
        this.f14004f = bookProvider;
    }

    static /* synthetic */ int d(c cVar) {
        int i2 = cVar.f14001c;
        cVar.f14001c = i2 + 1;
        return i2;
    }

    /* renamed from: i */
    public /* synthetic */ void j(final int chapterIndex) {
        b t;
        Chapter item = this.f14003e.getItem(chapterIndex);
        if (item == null || (t = this.f14004f.t(this.f13999a, chapterIndex, item, this.f14007i)) == null) {
            return;
        }
        t.b(this.f13999a, item, chapterIndex);
        t.c();
    }

    private void p() {
        o();
    }

    public void s(final int chapterIndex) {
        new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.lib.model.f.a
            @Override // java.lang.Runnable
            public final void run() {
                c.this.j(chapterIndex);
            }
        }, 500L);
    }

    public void t(int chapterIndex) {
        Chapter item = this.f14003e.getItem(chapterIndex);
        if (item != null) {
            this.f14004f.E().q1(this.f13999a, item, chapterIndex, this.f14003e.getCount());
        }
    }

    public void g() {
        this.f14005g = true;
        t(this.f14000b + this.f14001c);
        k();
    }

    public boolean h() {
        return this.f14005g;
    }

    public abstract void k();

    public abstract void l();

    public abstract void m(Integer... values);

    public abstract void n(int failedSize);

    public abstract void o();

    public abstract void q(b.d.c.b.c errorResult);

    public synchronized void r() {
        p();
        this.f14001c += Math.min(this.f14006h, this.f14002d);
        for (int i2 = 0; i2 < this.f14006h && i2 < this.f14002d; i2++) {
            s(this.f14000b + i2);
        }
    }
}
