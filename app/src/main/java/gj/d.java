package gj;

import ij.g;
import ij.h;
import java.util.Locale;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a */
    public ij.b f26288a;

    /* renamed from: b */
    public Locale f26289b;

    /* renamed from: c */
    public e f26290c;

    /* renamed from: d */
    public int f26291d;

    public class a extends hj.c {

        /* renamed from: b */
        public final /* synthetic */ org.threeten.bp.chrono.a f26292b;

        /* renamed from: c */
        public final /* synthetic */ ij.b f26293c;

        /* renamed from: d */
        public final /* synthetic */ org.threeten.bp.chrono.b f26294d;

        /* renamed from: e */
        public final /* synthetic */ ZoneId f26295e;

        public a(org.threeten.bp.chrono.a aVar, ij.b bVar, org.threeten.bp.chrono.b bVar2, ZoneId zoneId) {
            this.f26292b = aVar;
            this.f26293c = bVar;
            this.f26294d = bVar2;
            this.f26295e = zoneId;
        }

        @Override // ij.b
        public long getLong(ij.f fVar) {
            return (this.f26292b == null || !fVar.isDateBased()) ? this.f26293c.getLong(fVar) : this.f26292b.getLong(fVar);
        }

        @Override // ij.b
        public boolean isSupported(ij.f fVar) {
            return (this.f26292b == null || !fVar.isDateBased()) ? this.f26293c.isSupported(fVar) : this.f26292b.isSupported(fVar);
        }

        @Override // hj.c, ij.b
        public <R> R query(h<R> hVar) {
            return hVar == g.a() ? (R) this.f26294d : hVar == g.g() ? (R) this.f26295e : hVar == g.e() ? (R) this.f26293c.query(hVar) : hVar.a(this);
        }

        @Override // hj.c, ij.b
        public ValueRange range(ij.f fVar) {
            return (this.f26292b == null || !fVar.isDateBased()) ? this.f26293c.range(fVar) : this.f26292b.range(fVar);
        }
    }

    public d(ij.b bVar, DateTimeFormatter dateTimeFormatter) {
        this.f26288a = a(bVar, dateTimeFormatter);
        this.f26289b = dateTimeFormatter.h();
        this.f26290c = dateTimeFormatter.g();
    }

    public static ij.b a(ij.b bVar, DateTimeFormatter dateTimeFormatter) {
        org.threeten.bp.chrono.b f10 = dateTimeFormatter.f();
        ZoneId k10 = dateTimeFormatter.k();
        if (f10 == null && k10 == null) {
            return bVar;
        }
        org.threeten.bp.chrono.b bVar2 = (org.threeten.bp.chrono.b) bVar.query(g.a());
        ZoneId zoneId = (ZoneId) bVar.query(g.g());
        org.threeten.bp.chrono.a aVar = null;
        if (hj.d.c(bVar2, f10)) {
            f10 = null;
        }
        if (hj.d.c(zoneId, k10)) {
            k10 = null;
        }
        if (f10 == null && k10 == null) {
            return bVar;
        }
        org.threeten.bp.chrono.b bVar3 = f10 != null ? f10 : bVar2;
        if (k10 != null) {
            zoneId = k10;
        }
        if (k10 != null) {
            if (bVar.isSupported(ChronoField.INSTANT_SECONDS)) {
                if (bVar3 == null) {
                    bVar3 = IsoChronology.INSTANCE;
                }
                return bVar3.zonedDateTime(Instant.from(bVar), k10);
            }
            ZoneId normalized = k10.normalized();
            ZoneOffset zoneOffset = (ZoneOffset) bVar.query(g.d());
            if ((normalized instanceof ZoneOffset) && zoneOffset != null && !normalized.equals(zoneOffset)) {
                throw new DateTimeException("Invalid override zone for temporal: " + k10 + " " + bVar);
            }
        }
        if (f10 != null) {
            if (bVar.isSupported(ChronoField.EPOCH_DAY)) {
                aVar = bVar3.date(bVar);
            } else if (f10 != IsoChronology.INSTANCE || bVar2 != null) {
                for (ChronoField chronoField : ChronoField.values()) {
                    if (chronoField.isDateBased() && bVar.isSupported(chronoField)) {
                        throw new DateTimeException("Invalid override chronology for temporal: " + f10 + " " + bVar);
                    }
                }
            }
        }
        return new a(aVar, bVar, bVar3, zoneId);
    }

    public void b() {
        this.f26291d--;
    }

    public Locale c() {
        return this.f26289b;
    }

    public e d() {
        return this.f26290c;
    }

    public ij.b e() {
        return this.f26288a;
    }

    public Long f(ij.f fVar) {
        try {
            return Long.valueOf(this.f26288a.getLong(fVar));
        } catch (DateTimeException e10) {
            if (this.f26291d > 0) {
                return null;
            }
            throw e10;
        }
    }

    public <R> R g(h<R> hVar) {
        R r10 = (R) this.f26288a.query(hVar);
        if (r10 != null || this.f26291d != 0) {
            return r10;
        }
        throw new DateTimeException("Unable to extract value: " + this.f26288a.getClass());
    }

    public void h(ij.b bVar) {
        hj.d.j(bVar, "temporal");
        this.f26288a = bVar;
    }

    public void i(Locale locale) {
        hj.d.j(locale, "locale");
        this.f26289b = locale;
    }

    public void j() {
        this.f26291d++;
    }

    public String toString() {
        return this.f26288a.toString();
    }

    public d(ij.b bVar, Locale locale, e eVar) {
        this.f26288a = bVar;
        this.f26289b = locale;
        this.f26290c = eVar;
    }
}
