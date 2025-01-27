package ij;

import org.threeten.bp.DayOfWeek;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;

/* loaded from: classes4.dex */
public final class d {

    public static final class b implements ij.c {

        /* renamed from: b */
        public final int f27008b;

        /* renamed from: c */
        public final int f27009c;

        public /* synthetic */ b(int i10, DayOfWeek dayOfWeek, a aVar) {
            this(i10, dayOfWeek);
        }

        @Override // ij.c
        public ij.a adjustInto(ij.a aVar) {
            if (this.f27008b >= 0) {
                return aVar.with(ChronoField.DAY_OF_MONTH, 1L).plus((((this.f27009c - r10.get(ChronoField.DAY_OF_WEEK)) + 7) % 7) + ((this.f27008b - 1) * 7), ChronoUnit.DAYS);
            }
            ChronoField chronoField = ChronoField.DAY_OF_MONTH;
            ij.a with = aVar.with(chronoField, aVar.range(chronoField).getMaximum());
            long j10 = this.f27009c - with.get(ChronoField.DAY_OF_WEEK);
            if (j10 == 0) {
                j10 = 0;
            } else if (j10 > 0) {
                j10 -= 7;
            }
            return with.plus(j10 - (((-this.f27008b) - 1) * 7), ChronoUnit.DAYS);
        }

        public b(int i10, DayOfWeek dayOfWeek) {
            this.f27008b = i10;
            this.f27009c = dayOfWeek.getValue();
        }
    }

    public static class c implements ij.c {

        /* renamed from: c */
        public static final c f27010c = new c(0);

        /* renamed from: d */
        public static final c f27011d = new c(1);

        /* renamed from: e */
        public static final c f27012e = new c(2);

        /* renamed from: f */
        public static final c f27013f = new c(3);

        /* renamed from: g */
        public static final c f27014g = new c(4);

        /* renamed from: h */
        public static final c f27015h = new c(5);

        /* renamed from: b */
        public final int f27016b;

        public c(int i10) {
            this.f27016b = i10;
        }

        @Override // ij.c
        public ij.a adjustInto(ij.a aVar) {
            int i10 = this.f27016b;
            if (i10 == 0) {
                return aVar.with(ChronoField.DAY_OF_MONTH, 1L);
            }
            if (i10 == 1) {
                ChronoField chronoField = ChronoField.DAY_OF_MONTH;
                return aVar.with(chronoField, aVar.range(chronoField).getMaximum());
            }
            if (i10 == 2) {
                return aVar.with(ChronoField.DAY_OF_MONTH, 1L).plus(1L, ChronoUnit.MONTHS);
            }
            if (i10 == 3) {
                return aVar.with(ChronoField.DAY_OF_YEAR, 1L);
            }
            if (i10 == 4) {
                ChronoField chronoField2 = ChronoField.DAY_OF_YEAR;
                return aVar.with(chronoField2, aVar.range(chronoField2).getMaximum());
            }
            if (i10 == 5) {
                return aVar.with(ChronoField.DAY_OF_YEAR, 1L).plus(1L, ChronoUnit.YEARS);
            }
            throw new IllegalStateException("Unreachable");
        }
    }

    /* renamed from: ij.d$d */
    public static final class C0714d implements ij.c {

        /* renamed from: b */
        public final int f27017b;

        /* renamed from: c */
        public final int f27018c;

        public /* synthetic */ C0714d(int i10, DayOfWeek dayOfWeek, a aVar) {
            this(i10, dayOfWeek);
        }

        @Override // ij.c
        public ij.a adjustInto(ij.a aVar) {
            int i10 = aVar.get(ChronoField.DAY_OF_WEEK);
            int i11 = this.f27017b;
            if (i11 < 2 && i10 == this.f27018c) {
                return aVar;
            }
            if ((i11 & 1) == 0) {
                return aVar.plus(i10 - this.f27018c >= 0 ? 7 - r0 : -r0, ChronoUnit.DAYS);
            }
            return aVar.minus(this.f27018c - i10 >= 0 ? 7 - r1 : -r1, ChronoUnit.DAYS);
        }

        public C0714d(int i10, DayOfWeek dayOfWeek) {
            hj.d.j(dayOfWeek, "dayOfWeek");
            this.f27017b = i10;
            this.f27018c = dayOfWeek.getValue();
        }
    }

    public static ij.c a(int i10, DayOfWeek dayOfWeek) {
        hj.d.j(dayOfWeek, "dayOfWeek");
        return new b(i10, dayOfWeek);
    }

    public static ij.c b() {
        return c.f27010c;
    }

    public static ij.c c() {
        return c.f27012e;
    }

    public static ij.c d() {
        return c.f27015h;
    }

    public static ij.c e() {
        return c.f27013f;
    }

    public static ij.c f(DayOfWeek dayOfWeek) {
        hj.d.j(dayOfWeek, "dayOfWeek");
        return new b(1, dayOfWeek);
    }

    public static ij.c g() {
        return c.f27011d;
    }

    public static ij.c h() {
        return c.f27014g;
    }

    public static ij.c i(DayOfWeek dayOfWeek) {
        hj.d.j(dayOfWeek, "dayOfWeek");
        return new b(-1, dayOfWeek);
    }

    public static ij.c j(DayOfWeek dayOfWeek) {
        return new C0714d(2, dayOfWeek);
    }

    public static ij.c k(DayOfWeek dayOfWeek) {
        return new C0714d(0, dayOfWeek);
    }

    public static ij.c l(DayOfWeek dayOfWeek) {
        return new C0714d(3, dayOfWeek);
    }

    public static ij.c m(DayOfWeek dayOfWeek) {
        return new C0714d(1, dayOfWeek);
    }
}
