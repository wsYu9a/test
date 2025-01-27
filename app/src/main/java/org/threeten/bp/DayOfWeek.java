package org.threeten.bp;

import ij.b;
import ij.c;
import ij.f;
import ij.g;
import ij.h;
import java.util.Locale;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes4.dex */
public enum DayOfWeek implements b, c {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public static final h<DayOfWeek> FROM = new h<DayOfWeek>() { // from class: org.threeten.bp.DayOfWeek.a
        @Override // ij.h
        /* renamed from: b */
        public DayOfWeek a(b bVar) {
            return DayOfWeek.from(bVar);
        }
    };
    private static final DayOfWeek[] ENUMS = values();

    public class a implements h<DayOfWeek> {
        @Override // ij.h
        /* renamed from: b */
        public DayOfWeek a(b bVar) {
            return DayOfWeek.from(bVar);
        }
    }

    public static DayOfWeek from(b bVar) {
        if (bVar instanceof DayOfWeek) {
            return (DayOfWeek) bVar;
        }
        try {
            return of(bVar.get(ChronoField.DAY_OF_WEEK));
        } catch (DateTimeException e10) {
            throw new DateTimeException("Unable to obtain DayOfWeek from TemporalAccessor: " + bVar + ", type " + bVar.getClass().getName(), e10);
        }
    }

    public static DayOfWeek of(int i10) {
        if (i10 >= 1 && i10 <= 7) {
            return ENUMS[i10 - 1];
        }
        throw new DateTimeException("Invalid value for DayOfWeek: " + i10);
    }

    @Override // ij.c
    public ij.a adjustInto(ij.a aVar) {
        return aVar.with(ChronoField.DAY_OF_WEEK, getValue());
    }

    @Override // ij.b
    public int get(f fVar) {
        return fVar == ChronoField.DAY_OF_WEEK ? getValue() : range(fVar).checkValidIntValue(getLong(fVar), fVar);
    }

    public String getDisplayName(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().r(ChronoField.DAY_OF_WEEK, textStyle).Q(locale).d(this);
    }

    @Override // ij.b
    public long getLong(f fVar) {
        if (fVar == ChronoField.DAY_OF_WEEK) {
            return getValue();
        }
        if (!(fVar instanceof ChronoField)) {
            return fVar.getFrom(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
    }

    public int getValue() {
        return ordinal() + 1;
    }

    @Override // ij.b
    public boolean isSupported(f fVar) {
        return fVar instanceof ChronoField ? fVar == ChronoField.DAY_OF_WEEK : fVar != null && fVar.isSupportedBy(this);
    }

    public DayOfWeek minus(long j10) {
        return plus(-(j10 % 7));
    }

    public DayOfWeek plus(long j10) {
        return ENUMS[(ordinal() + (((int) (j10 % 7)) + 7)) % 7];
    }

    @Override // ij.b
    public <R> R query(h<R> hVar) {
        if (hVar == g.e()) {
            return (R) ChronoUnit.DAYS;
        }
        if (hVar == g.b() || hVar == g.c() || hVar == g.a() || hVar == g.f() || hVar == g.g() || hVar == g.d()) {
            return null;
        }
        return hVar.a(this);
    }

    @Override // ij.b
    public ValueRange range(f fVar) {
        if (fVar == ChronoField.DAY_OF_WEEK) {
            return fVar.range();
        }
        if (!(fVar instanceof ChronoField)) {
            return fVar.rangeRefinedBy(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
    }
}
