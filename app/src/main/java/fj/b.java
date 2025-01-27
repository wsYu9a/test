package fj;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import ij.f;
import ij.g;
import ij.h;
import ij.i;
import java.util.Comparator;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.a;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;

/* loaded from: classes4.dex */
public abstract class b<D extends org.threeten.bp.chrono.a> extends hj.b implements ij.a, ij.c, Comparable<b<?>> {
    private static final Comparator<b<?>> DATE_TIME_COMPARATOR = new a();

    public class a implements Comparator<b<?>> {
        /* JADX WARN: Type inference failed for: r0v0, types: [org.threeten.bp.chrono.a] */
        /* JADX WARN: Type inference failed for: r2v0, types: [org.threeten.bp.chrono.a] */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(b<?> bVar, b<?> bVar2) {
            int b10 = hj.d.b(bVar.toLocalDate().toEpochDay(), bVar2.toLocalDate().toEpochDay());
            return b10 == 0 ? hj.d.b(bVar.toLocalTime().toNanoOfDay(), bVar2.toLocalTime().toNanoOfDay()) : b10;
        }
    }

    public static b<?> from(ij.b bVar) {
        hj.d.j(bVar, "temporal");
        if (bVar instanceof b) {
            return (b) bVar;
        }
        org.threeten.bp.chrono.b bVar2 = (org.threeten.bp.chrono.b) bVar.query(g.a());
        if (bVar2 != null) {
            return bVar2.localDateTime(bVar);
        }
        throw new DateTimeException("No Chronology found to create ChronoLocalDateTime: " + bVar.getClass());
    }

    public static Comparator<b<?>> timeLineOrder() {
        return DATE_TIME_COMPARATOR;
    }

    @Override // ij.c
    public ij.a adjustInto(ij.a aVar) {
        return aVar.with(ChronoField.EPOCH_DAY, toLocalDate().toEpochDay()).with(ChronoField.NANO_OF_DAY, toLocalTime().toNanoOfDay());
    }

    public abstract d<D> atZone(ZoneId zoneId);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && compareTo((b<?>) obj) == 0;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        hj.d.j(dateTimeFormatter, "formatter");
        return dateTimeFormatter.d(this);
    }

    public org.threeten.bp.chrono.b getChronology() {
        return toLocalDate().getChronology();
    }

    public int hashCode() {
        return toLocalDate().hashCode() ^ toLocalTime().hashCode();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.threeten.bp.chrono.a] */
    public boolean isAfter(b<?> bVar) {
        long epochDay = toLocalDate().toEpochDay();
        long epochDay2 = bVar.toLocalDate().toEpochDay();
        return epochDay > epochDay2 || (epochDay == epochDay2 && toLocalTime().toNanoOfDay() > bVar.toLocalTime().toNanoOfDay());
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.threeten.bp.chrono.a] */
    public boolean isBefore(b<?> bVar) {
        long epochDay = toLocalDate().toEpochDay();
        long epochDay2 = bVar.toLocalDate().toEpochDay();
        return epochDay < epochDay2 || (epochDay == epochDay2 && toLocalTime().toNanoOfDay() < bVar.toLocalTime().toNanoOfDay());
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [org.threeten.bp.chrono.a] */
    public boolean isEqual(b<?> bVar) {
        return toLocalTime().toNanoOfDay() == bVar.toLocalTime().toNanoOfDay() && toLocalDate().toEpochDay() == bVar.toLocalDate().toEpochDay();
    }

    @Override // ij.a
    public abstract b<D> plus(long j10, i iVar);

    @Override // hj.c, ij.b
    public <R> R query(h<R> hVar) {
        if (hVar == g.a()) {
            return (R) getChronology();
        }
        if (hVar == g.e()) {
            return (R) ChronoUnit.NANOS;
        }
        if (hVar == g.b()) {
            return (R) LocalDate.ofEpochDay(toLocalDate().toEpochDay());
        }
        if (hVar == g.c()) {
            return (R) toLocalTime();
        }
        if (hVar == g.f() || hVar == g.g() || hVar == g.d()) {
            return null;
        }
        return (R) super.query(hVar);
    }

    public long toEpochSecond(ZoneOffset zoneOffset) {
        hj.d.j(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        return ((toLocalDate().toEpochDay() * 86400) + toLocalTime().toSecondOfDay()) - zoneOffset.getTotalSeconds();
    }

    public Instant toInstant(ZoneOffset zoneOffset) {
        return Instant.ofEpochSecond(toEpochSecond(zoneOffset), toLocalTime().getNano());
    }

    public abstract D toLocalDate();

    public abstract LocalTime toLocalTime();

    public String toString() {
        return toLocalDate().toString() + 'T' + toLocalTime().toString();
    }

    @Override // ij.a
    public abstract b<D> with(f fVar, long j10);

    @Override // java.lang.Comparable
    public int compareTo(b<?> bVar) {
        int compareTo = toLocalDate().compareTo(bVar.toLocalDate());
        if (compareTo != 0) {
            return compareTo;
        }
        int compareTo2 = toLocalTime().compareTo(bVar.toLocalTime());
        return compareTo2 == 0 ? getChronology().compareTo(bVar.getChronology()) : compareTo2;
    }

    @Override // hj.b, ij.a
    public b<D> minus(ij.e eVar) {
        return toLocalDate().getChronology().ensureChronoLocalDateTime(super.minus(eVar));
    }

    @Override // hj.b, ij.a
    public b<D> plus(ij.e eVar) {
        return toLocalDate().getChronology().ensureChronoLocalDateTime(super.plus(eVar));
    }

    @Override // hj.b, ij.a
    public b<D> with(ij.c cVar) {
        return toLocalDate().getChronology().ensureChronoLocalDateTime(super.with(cVar));
    }

    @Override // hj.b, ij.a
    public b<D> minus(long j10, i iVar) {
        return toLocalDate().getChronology().ensureChronoLocalDateTime(super.minus(j10, iVar));
    }
}
