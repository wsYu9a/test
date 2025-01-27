package ij;

import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.temporal.ChronoField;

/* loaded from: classes4.dex */
public final class g {

    /* renamed from: a */
    public static final h<ZoneId> f27019a = new a();

    /* renamed from: b */
    public static final h<org.threeten.bp.chrono.b> f27020b = new b();

    /* renamed from: c */
    public static final h<i> f27021c = new c();

    /* renamed from: d */
    public static final h<ZoneId> f27022d = new d();

    /* renamed from: e */
    public static final h<ZoneOffset> f27023e = new e();

    /* renamed from: f */
    public static final h<LocalDate> f27024f = new f();

    /* renamed from: g */
    public static final h<LocalTime> f27025g = new C0715g();

    public class a implements h<ZoneId> {
        @Override // ij.h
        /* renamed from: b */
        public ZoneId a(ij.b bVar) {
            return (ZoneId) bVar.query(this);
        }
    }

    public class b implements h<org.threeten.bp.chrono.b> {
        @Override // ij.h
        /* renamed from: b */
        public org.threeten.bp.chrono.b a(ij.b bVar) {
            return (org.threeten.bp.chrono.b) bVar.query(this);
        }
    }

    public class c implements h<i> {
        @Override // ij.h
        /* renamed from: b */
        public i a(ij.b bVar) {
            return (i) bVar.query(this);
        }
    }

    public class d implements h<ZoneId> {
        @Override // ij.h
        /* renamed from: b */
        public ZoneId a(ij.b bVar) {
            ZoneId zoneId = (ZoneId) bVar.query(g.f27019a);
            return zoneId != null ? zoneId : (ZoneId) bVar.query(g.f27023e);
        }
    }

    public class e implements h<ZoneOffset> {
        @Override // ij.h
        /* renamed from: b */
        public ZoneOffset a(ij.b bVar) {
            ChronoField chronoField = ChronoField.OFFSET_SECONDS;
            if (bVar.isSupported(chronoField)) {
                return ZoneOffset.ofTotalSeconds(bVar.get(chronoField));
            }
            return null;
        }
    }

    public class f implements h<LocalDate> {
        @Override // ij.h
        /* renamed from: b */
        public LocalDate a(ij.b bVar) {
            ChronoField chronoField = ChronoField.EPOCH_DAY;
            if (bVar.isSupported(chronoField)) {
                return LocalDate.ofEpochDay(bVar.getLong(chronoField));
            }
            return null;
        }
    }

    /* renamed from: ij.g$g */
    public class C0715g implements h<LocalTime> {
        @Override // ij.h
        /* renamed from: b */
        public LocalTime a(ij.b bVar) {
            ChronoField chronoField = ChronoField.NANO_OF_DAY;
            if (bVar.isSupported(chronoField)) {
                return LocalTime.ofNanoOfDay(bVar.getLong(chronoField));
            }
            return null;
        }
    }

    public static final h<org.threeten.bp.chrono.b> a() {
        return f27020b;
    }

    public static final h<LocalDate> b() {
        return f27024f;
    }

    public static final h<LocalTime> c() {
        return f27025g;
    }

    public static final h<ZoneOffset> d() {
        return f27023e;
    }

    public static final h<i> e() {
        return f27021c;
    }

    public static final h<ZoneId> f() {
        return f27022d;
    }

    public static final h<ZoneId> g() {
        return f27019a;
    }
}
