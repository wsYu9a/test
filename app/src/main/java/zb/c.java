package zb;

import android.os.Handler;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import java.util.Hashtable;
import java.util.Map;
import wb.f;
import xb.g;

/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a */
    public final f f33734a;

    /* renamed from: b */
    public final int f33735b;

    /* renamed from: d */
    public final int f33737d;

    /* renamed from: e */
    public final ChapterList f33738e;

    /* renamed from: f */
    public final wb.b f33739f;

    /* renamed from: g */
    public boolean f33740g = false;

    /* renamed from: h */
    public final int f33741h = Runtime.getRuntime().availableProcessors() + 1;

    /* renamed from: i */
    public final g f33742i = new a();

    /* renamed from: c */
    public int f33736c = 0;

    public class a implements g {

        /* renamed from: a */
        public final Map<Integer, Integer> f33743a = new Hashtable();

        /* renamed from: b */
        public int f33744b = 0;

        /* renamed from: c */
        public int f33745c = 0;

        /* renamed from: d */
        public boolean f33746d = false;

        /* renamed from: e */
        public int f33747e = -1;

        public a() {
        }

        @Override // xb.g
        public void a(int i10, x8.c cVar) {
            if (c.this.i()) {
                return;
            }
            if (c()) {
                if (this.f33746d) {
                    return;
                }
                int i11 = this.f33747e;
                if (i11 != -1) {
                    c.this.t(i11);
                }
                c.this.q(new x8.c(-1, "Missing too much chapters."));
                this.f33746d = true;
                return;
            }
            Integer num = this.f33743a.get(Integer.valueOf(i10));
            if (num == null || num.intValue() <= 2) {
                if (num == null) {
                    num = 0;
                }
                this.f33743a.put(Integer.valueOf(i10), Integer.valueOf(num.intValue() + 1));
                c.this.s(i10);
                return;
            }
            d();
            if (c.this.f33736c >= c.this.f33737d) {
                int i12 = this.f33747e;
                if (i12 != -1) {
                    c.this.t(i12);
                }
                c.this.n(this.f33744b);
                return;
            }
            c cVar2 = c.this;
            int i13 = cVar2.f33735b;
            c cVar3 = c.this;
            int i14 = cVar3.f33736c;
            cVar3.f33736c = i14 + 1;
            cVar2.s(i13 + i14);
        }

        @Override // xb.g
        public void b(int i10, ChapterContent chapterContent) {
            this.f33745c++;
            this.f33747e = Math.max(i10, this.f33747e);
            if (c()) {
                if (this.f33746d) {
                    return;
                }
                int i11 = this.f33747e;
                if (i11 != -1) {
                    c.this.t(i11);
                }
                c.this.q(new x8.c(-1, "Missing too much chapters."));
                this.f33746d = true;
                return;
            }
            c cVar = c.this;
            cVar.m(Integer.valueOf((cVar.f33735b + c.this.f33736c) - 1), Integer.valueOf(c.this.f33735b + c.this.f33737d), 0);
            if (this.f33745c + this.f33744b >= c.this.f33737d) {
                c cVar2 = c.this;
                cVar2.t((cVar2.f33735b + c.this.f33736c) - 1);
                int i12 = this.f33744b;
                if (i12 > 0) {
                    c.this.n(i12);
                    return;
                } else {
                    c.this.l();
                    return;
                }
            }
            if (c.this.f33736c >= c.this.f33737d) {
                return;
            }
            if (c.this.i()) {
                c cVar3 = c.this;
                cVar3.t((cVar3.f33735b + c.this.f33736c) - 1);
                return;
            }
            c cVar4 = c.this;
            int i13 = cVar4.f33735b;
            c cVar5 = c.this;
            int i14 = cVar5.f33736c;
            cVar5.f33736c = 1 + i14;
            cVar4.s(i13 + i14);
        }

        public final boolean c() {
            return this.f33744b > 20;
        }

        public final void d() {
            this.f33744b++;
        }
    }

    public c(f fVar, ChapterList chapterList, int i10, int i11, wb.b bVar) {
        this.f33734a = fVar;
        this.f33738e = chapterList;
        this.f33735b = i10;
        int count = chapterList.getCount() - i10;
        this.f33737d = i11 > count ? count : i11;
        this.f33739f = bVar;
    }

    public void h() {
        this.f33740g = true;
        t(this.f33735b + this.f33736c);
        k();
    }

    public boolean i() {
        return this.f33740g;
    }

    public final /* synthetic */ void j(int i10) {
        zb.a s10;
        Chapter item = this.f33738e.getItem(i10);
        if (item == null || (s10 = this.f33739f.s(this.f33734a, i10, item, this.f33742i)) == null) {
            return;
        }
        s10.c(this.f33734a, item, i10);
        s10.a();
    }

    public abstract void k();

    public abstract void l();

    public abstract void m(Integer... numArr);

    public abstract void n(int i10);

    public abstract void o();

    public final void p() {
        o();
    }

    public abstract void q(x8.c cVar);

    public synchronized void r() {
        p();
        this.f33736c += Math.min(this.f33741h, this.f33737d);
        for (int i10 = 0; i10 < this.f33741h && i10 < this.f33737d; i10++) {
            s(this.f33735b + i10);
        }
    }

    public final void s(int i10) {
        new Handler().postDelayed(new Runnable() { // from class: zb.b

            /* renamed from: c */
            public final /* synthetic */ int f33733c;

            public /* synthetic */ b(int i102) {
                i10 = i102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                c.this.j(i10);
            }
        }, 500L);
    }

    public final void t(int i10) {
        Chapter item = this.f33738e.getItem(i10);
        if (item != null) {
            this.f33739f.G().O0(this.f33734a, item, i10, this.f33738e.getCount());
        }
    }
}
