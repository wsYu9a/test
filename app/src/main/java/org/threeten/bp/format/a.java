package org.threeten.bp.format;

import gj.e;
import hj.d;
import ij.f;
import ij.g;
import ij.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    public Locale f29596a;

    /* renamed from: b */
    public e f29597b;

    /* renamed from: c */
    public org.threeten.bp.chrono.b f29598c;

    /* renamed from: d */
    public ZoneId f29599d;

    /* renamed from: e */
    public boolean f29600e;

    /* renamed from: f */
    public boolean f29601f;

    /* renamed from: g */
    public final ArrayList<b> f29602g;

    public final class b extends hj.c {

        /* renamed from: b */
        public org.threeten.bp.chrono.b f29603b;

        /* renamed from: c */
        public ZoneId f29604c;

        /* renamed from: d */
        public final Map<f, Long> f29605d;

        /* renamed from: e */
        public boolean f29606e;

        /* renamed from: f */
        public Period f29607f;

        /* renamed from: g */
        public List<Object[]> f29608g;

        public /* synthetic */ b(a aVar, C0760a c0760a) {
            this();
        }

        public b a() {
            b bVar = a.this.new b();
            bVar.f29603b = this.f29603b;
            bVar.f29604c = this.f29604c;
            bVar.f29605d.putAll(this.f29605d);
            bVar.f29606e = this.f29606e;
            return bVar;
        }

        public gj.a b() {
            gj.a aVar = new gj.a();
            aVar.f26281b.putAll(this.f29605d);
            aVar.f26282c = a.this.h();
            ZoneId zoneId = this.f29604c;
            if (zoneId != null) {
                aVar.f26283d = zoneId;
            } else {
                aVar.f26283d = a.this.f29599d;
            }
            aVar.f26286g = this.f29606e;
            aVar.f26287h = this.f29607f;
            return aVar;
        }

        @Override // hj.c, ij.b
        public int get(f fVar) {
            if (this.f29605d.containsKey(fVar)) {
                return d.r(this.f29605d.get(fVar).longValue());
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
        }

        @Override // ij.b
        public long getLong(f fVar) {
            if (this.f29605d.containsKey(fVar)) {
                return this.f29605d.get(fVar).longValue();
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
        }

        @Override // ij.b
        public boolean isSupported(f fVar) {
            return this.f29605d.containsKey(fVar);
        }

        @Override // hj.c, ij.b
        public <R> R query(h<R> hVar) {
            return hVar == g.a() ? (R) this.f29603b : (hVar == g.g() || hVar == g.f()) ? (R) this.f29604c : (R) super.query(hVar);
        }

        public String toString() {
            return this.f29605d.toString() + "," + this.f29603b + "," + this.f29604c;
        }

        public b() {
            this.f29603b = null;
            this.f29604c = null;
            this.f29605d = new HashMap();
            this.f29607f = Period.ZERO;
        }
    }

    public a(DateTimeFormatter dateTimeFormatter) {
        this.f29600e = true;
        this.f29601f = true;
        ArrayList<b> arrayList = new ArrayList<>();
        this.f29602g = arrayList;
        this.f29596a = dateTimeFormatter.h();
        this.f29597b = dateTimeFormatter.g();
        this.f29598c = dateTimeFormatter.f();
        this.f29599d = dateTimeFormatter.k();
        arrayList.add(new b());
    }

    public static boolean d(char c10, char c11) {
        return c10 == c11 || Character.toUpperCase(c10) == Character.toUpperCase(c11) || Character.toLowerCase(c10) == Character.toLowerCase(c11);
    }

    public void b(DateTimeFormatterBuilder.q qVar, long j10, int i10, int i11) {
        b f10 = f();
        if (f10.f29608g == null) {
            f10.f29608g = new ArrayList(2);
        }
        f10.f29608g.add(new Object[]{qVar, Long.valueOf(j10), Integer.valueOf(i10), Integer.valueOf(i11)});
    }

    public boolean c(char c10, char c11) {
        return l() ? c10 == c11 : d(c10, c11);
    }

    public a e() {
        return new a(this);
    }

    public final b f() {
        return this.f29602g.get(r0.size() - 1);
    }

    public void g(boolean z10) {
        if (z10) {
            this.f29602g.remove(r2.size() - 2);
        } else {
            this.f29602g.remove(r2.size() - 1);
        }
    }

    public org.threeten.bp.chrono.b h() {
        org.threeten.bp.chrono.b bVar = f().f29603b;
        if (bVar != null) {
            return bVar;
        }
        org.threeten.bp.chrono.b bVar2 = this.f29598c;
        return bVar2 == null ? IsoChronology.INSTANCE : bVar2;
    }

    public Locale i() {
        return this.f29596a;
    }

    public Long j(f fVar) {
        return f().f29605d.get(fVar);
    }

    public e k() {
        return this.f29597b;
    }

    public boolean l() {
        return this.f29600e;
    }

    public boolean m() {
        return this.f29601f;
    }

    public void n(boolean z10) {
        this.f29600e = z10;
    }

    public void o(Locale locale) {
        d.j(locale, "locale");
        this.f29596a = locale;
    }

    public void p(ZoneId zoneId) {
        d.j(zoneId, "zone");
        f().f29604c = zoneId;
    }

    public void q(org.threeten.bp.chrono.b bVar) {
        d.j(bVar, "chrono");
        b f10 = f();
        f10.f29603b = bVar;
        if (f10.f29608g != null) {
            ArrayList<Object[]> arrayList = new ArrayList(f10.f29608g);
            f10.f29608g.clear();
            for (Object[] objArr : arrayList) {
                ((DateTimeFormatterBuilder.q) objArr[0]).c(this, ((Long) objArr[1]).longValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
            }
        }
    }

    public int r(f fVar, long j10, int i10, int i11) {
        d.j(fVar, "field");
        Long put = f().f29605d.put(fVar, Long.valueOf(j10));
        return (put == null || put.longValue() == j10) ? i11 : ~i10;
    }

    public void s() {
        f().f29606e = true;
    }

    public void t(boolean z10) {
        this.f29601f = z10;
    }

    public String toString() {
        return f().toString();
    }

    public void u() {
        this.f29602g.add(f().a());
    }

    public boolean v(CharSequence charSequence, int i10, CharSequence charSequence2, int i11, int i12) {
        if (i10 + i12 > charSequence.length() || i11 + i12 > charSequence2.length()) {
            return false;
        }
        if (l()) {
            for (int i13 = 0; i13 < i12; i13++) {
                if (charSequence.charAt(i10 + i13) != charSequence2.charAt(i11 + i13)) {
                    return false;
                }
            }
            return true;
        }
        for (int i14 = 0; i14 < i12; i14++) {
            char charAt = charSequence.charAt(i10 + i14);
            char charAt2 = charSequence2.charAt(i11 + i14);
            if (charAt != charAt2 && Character.toUpperCase(charAt) != Character.toUpperCase(charAt2) && Character.toLowerCase(charAt) != Character.toLowerCase(charAt2)) {
                return false;
            }
        }
        return true;
    }

    public b w() {
        return f();
    }

    public a(Locale locale, e eVar, org.threeten.bp.chrono.b bVar) {
        this.f29600e = true;
        this.f29601f = true;
        ArrayList<b> arrayList = new ArrayList<>();
        this.f29602g = arrayList;
        this.f29596a = locale;
        this.f29597b = eVar;
        this.f29598c = bVar;
        this.f29599d = null;
        arrayList.add(new b());
    }

    public a(a aVar) {
        this.f29600e = true;
        this.f29601f = true;
        ArrayList<b> arrayList = new ArrayList<>();
        this.f29602g = arrayList;
        this.f29596a = aVar.f29596a;
        this.f29597b = aVar.f29597b;
        this.f29598c = aVar.f29598c;
        this.f29599d = aVar.f29599d;
        this.f29600e = aVar.f29600e;
        this.f29601f = aVar.f29601f;
        arrayList.add(new b());
    }
}
