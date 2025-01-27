package org.threeten.bp.chrono;

import fj.e;
import hj.d;
import ij.c;
import ij.f;
import ij.g;
import ij.h;
import ij.i;
import java.util.Comparator;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;

/* loaded from: classes4.dex */
public abstract class a extends hj.b implements ij.a, c, Comparable<a> {
    private static final Comparator<a> DATE_COMPARATOR = new C0758a();

    /* renamed from: org.threeten.bp.chrono.a$a */
    public class C0758a implements Comparator<a> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return d.b(aVar.toEpochDay(), aVar2.toEpochDay());
        }
    }

    public static a from(ij.b bVar) {
        d.j(bVar, "temporal");
        if (bVar instanceof a) {
            return (a) bVar;
        }
        b bVar2 = (b) bVar.query(g.a());
        if (bVar2 != null) {
            return bVar2.date(bVar);
        }
        throw new DateTimeException("No Chronology found to create ChronoLocalDate: " + bVar.getClass());
    }

    public static Comparator<a> timeLineOrder() {
        return DATE_COMPARATOR;
    }

    public ij.a adjustInto(ij.a aVar) {
        return aVar.with(ChronoField.EPOCH_DAY, toEpochDay());
    }

    public fj.b<?> atTime(LocalTime localTime) {
        return ChronoLocalDateTimeImpl.of(this, localTime);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && compareTo((a) obj) == 0;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        d.j(dateTimeFormatter, "formatter");
        return dateTimeFormatter.d(this);
    }

    public abstract b getChronology();

    public e getEra() {
        return getChronology().eraOf(get(ChronoField.ERA));
    }

    public int hashCode() {
        long epochDay = toEpochDay();
        return getChronology().hashCode() ^ ((int) (epochDay ^ (epochDay >>> 32)));
    }

    public boolean isAfter(a aVar) {
        return toEpochDay() > aVar.toEpochDay();
    }

    public boolean isBefore(a aVar) {
        return toEpochDay() < aVar.toEpochDay();
    }

    public boolean isEqual(a aVar) {
        return toEpochDay() == aVar.toEpochDay();
    }

    public boolean isLeapYear() {
        return getChronology().isLeapYear(getLong(ChronoField.YEAR));
    }

    @Override // ij.b
    public boolean isSupported(f fVar) {
        return fVar instanceof ChronoField ? fVar.isDateBased() : fVar != null && fVar.isSupportedBy(this);
    }

    public abstract int lengthOfMonth();

    public int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    @Override // ij.a
    public abstract a plus(long j10, i iVar);

    @Override // hj.c, ij.b
    public <R> R query(h<R> hVar) {
        if (hVar == g.a()) {
            return (R) getChronology();
        }
        if (hVar == g.e()) {
            return (R) ChronoUnit.DAYS;
        }
        if (hVar == g.b()) {
            return (R) LocalDate.ofEpochDay(toEpochDay());
        }
        if (hVar == g.c() || hVar == g.f() || hVar == g.g() || hVar == g.d()) {
            return null;
        }
        return (R) super.query(hVar);
    }

    public long toEpochDay() {
        return getLong(ChronoField.EPOCH_DAY);
    }

    public String toString() {
        long j10 = getLong(ChronoField.YEAR_OF_ERA);
        long j11 = getLong(ChronoField.MONTH_OF_YEAR);
        long j12 = getLong(ChronoField.DAY_OF_MONTH);
        StringBuilder sb2 = new StringBuilder(30);
        sb2.append(getChronology().toString());
        sb2.append(" ");
        sb2.append(getEra());
        sb2.append(" ");
        sb2.append(j10);
        sb2.append(j11 < 10 ? "-0" : "-");
        sb2.append(j11);
        sb2.append(j12 < 10 ? "-0" : "-");
        sb2.append(j12);
        return sb2.toString();
    }

    public abstract fj.c until(a aVar);

    @Override // ij.a
    public abstract a with(f fVar, long j10);

    @Override // java.lang.Comparable
    public int compareTo(a aVar) {
        int b10 = d.b(toEpochDay(), aVar.toEpochDay());
        return b10 == 0 ? getChronology().compareTo(aVar.getChronology()) : b10;
    }

    @Override // hj.b, ij.a
    public a minus(ij.e eVar) {
        return getChronology().ensureChronoLocalDate(super.minus(eVar));
    }

    @Override // hj.b, ij.a
    public a plus(ij.e eVar) {
        return getChronology().ensureChronoLocalDate(super.plus(eVar));
    }

    @Override // hj.b, ij.a
    public a with(c cVar) {
        return getChronology().ensureChronoLocalDate(super.with(cVar));
    }

    @Override // ij.a
    public boolean isSupported(i iVar) {
        if (iVar instanceof ChronoUnit) {
            return iVar.isDateBased();
        }
        return iVar != null && iVar.isSupportedBy(this);
    }

    @Override // hj.b, ij.a
    public a minus(long j10, i iVar) {
        return getChronology().ensureChronoLocalDate(super.minus(j10, iVar));
    }
}
