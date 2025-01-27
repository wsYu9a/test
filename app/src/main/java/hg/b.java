package hg;

import com.tanx.exposer.achieve.AdMonitorType;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    public final int f26698a;

    /* renamed from: b */
    public final boolean f26699b;

    /* renamed from: c */
    public final boolean f26700c;

    /* renamed from: d */
    public final int f26701d;

    /* renamed from: e */
    public final List<AdMonitorType> f26702e;

    /* renamed from: f */
    public final pg.b f26703f;

    /* renamed from: g */
    public final rg.d f26704g;

    /* renamed from: h */
    public final mg.a f26705h;

    /* renamed from: i */
    public boolean f26706i;

    /* renamed from: j */
    public final String f26707j;

    /* renamed from: k */
    public final String f26708k;

    public static class a {

        /* renamed from: f */
        public final pg.a f26714f;

        /* renamed from: g */
        public final rg.a f26715g;

        /* renamed from: h */
        public mg.a f26716h;

        /* renamed from: j */
        public String f26718j;

        /* renamed from: k */
        public String f26719k;

        /* renamed from: l */
        public boolean f26720l;

        /* renamed from: a */
        public int f26709a = rg.b.a();

        /* renamed from: b */
        public boolean f26710b = true;

        /* renamed from: c */
        public boolean f26711c = true;

        /* renamed from: d */
        public int f26712d = 5;

        /* renamed from: e */
        public List<AdMonitorType> f26713e = Arrays.asList(AdMonitorType.CLICK, AdMonitorType.EXPOSE, AdMonitorType.INTERACT, AdMonitorType.INTERACT_DEDUPLICATION);

        /* renamed from: i */
        public boolean f26717i = false;

        public a(pg.a aVar, rg.a aVar2) {
            this.f26714f = aVar;
            this.f26715g = aVar2;
        }

        public a e(int i10) {
            this.f26709a = i10;
            return this;
        }

        public a f(String str, String str2) {
            this.f26718j = str;
            this.f26719k = str2;
            return this;
        }

        public a g(boolean z10) {
            this.f26710b = z10;
            return this;
        }

        public b h() {
            return new b(this);
        }

        public a j(boolean z10) {
            this.f26720l = z10;
            return this;
        }

        public a m(boolean z10) {
            this.f26711c = z10;
            return this;
        }
    }

    public b(a aVar) {
        int i10 = aVar.f26709a;
        this.f26698a = i10;
        this.f26699b = aVar.f26710b;
        this.f26700c = aVar.f26711c;
        this.f26701d = aVar.f26712d;
        this.f26702e = aVar.f26713e;
        this.f26703f = new pg.b(aVar.f26714f);
        this.f26704g = new rg.d(aVar.f26715g);
        this.f26705h = aVar.f26716h;
        this.f26706i = aVar.f26717i;
        this.f26707j = aVar.f26718j;
        this.f26708k = aVar.f26719k;
        sg.a.e(aVar.f26720l);
        rg.b.b(i10);
    }

    public List<AdMonitorType> a() {
        return this.f26702e;
    }

    public boolean b() {
        return this.f26706i;
    }

    public String c() {
        return this.f26707j;
    }

    public boolean d() {
        return this.f26699b;
    }

    public String e() {
        return this.f26708k;
    }

    public int f() {
        return this.f26701d;
    }

    public boolean g() {
        return this.f26700c;
    }

    public pg.a h() {
        return this.f26703f;
    }

    public rg.d i() {
        return this.f26704g;
    }

    public mg.a j() {
        return this.f26705h;
    }
}
