package org.threeten.bp;

import fj.c;
import hj.d;
import ij.e;
import ij.i;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.chrono.a;
import org.threeten.bp.chrono.b;
import org.threeten.bp.format.DateTimeParseException;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* loaded from: classes4.dex */
public final class Period extends c implements Serializable {
    private static final long serialVersionUID = -8290556941213247973L;
    private final int days;
    private final int months;
    private final int years;
    public static final Period ZERO = new Period(0, 0, 0);
    private static final Pattern PATTERN = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);

    private Period(int i10, int i11, int i12) {
        this.years = i10;
        this.months = i11;
        this.days = i12;
    }

    public static Period between(LocalDate localDate, LocalDate localDate2) {
        return localDate.until((a) localDate2);
    }

    private static Period create(int i10, int i11, int i12) {
        return ((i10 | i11) | i12) == 0 ? ZERO : new Period(i10, i11, i12);
    }

    public static Period from(e eVar) {
        if (eVar instanceof Period) {
            return (Period) eVar;
        }
        if ((eVar instanceof c) && !IsoChronology.INSTANCE.equals(((c) eVar).getChronology())) {
            throw new DateTimeException("Period requires ISO chronology: " + eVar);
        }
        d.j(eVar, "amount");
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (i iVar : eVar.getUnits()) {
            long j10 = eVar.get(iVar);
            if (iVar == ChronoUnit.YEARS) {
                i10 = d.r(j10);
            } else if (iVar == ChronoUnit.MONTHS) {
                i11 = d.r(j10);
            } else {
                if (iVar != ChronoUnit.DAYS) {
                    throw new DateTimeException("Unit must be Years, Months or Days, but was " + iVar);
                }
                i12 = d.r(j10);
            }
        }
        return create(i10, i11, i12);
    }

    public static Period of(int i10, int i11, int i12) {
        return create(i10, i11, i12);
    }

    public static Period ofDays(int i10) {
        return create(0, 0, i10);
    }

    public static Period ofMonths(int i10) {
        return create(0, i10, 0);
    }

    public static Period ofWeeks(int i10) {
        return create(0, 0, d.m(i10, 7));
    }

    public static Period ofYears(int i10) {
        return create(i10, 0, 0);
    }

    public static Period parse(CharSequence charSequence) {
        d.j(charSequence, "text");
        Matcher matcher = PATTERN.matcher(charSequence);
        if (matcher.matches()) {
            int i10 = "-".equals(matcher.group(1)) ? -1 : 1;
            String group = matcher.group(2);
            String group2 = matcher.group(3);
            String group3 = matcher.group(4);
            String group4 = matcher.group(5);
            if (group != null || group2 != null || group3 != null || group4 != null) {
                try {
                    return create(parseNumber(charSequence, group, i10), parseNumber(charSequence, group2, i10), d.k(parseNumber(charSequence, group4, i10), d.m(parseNumber(charSequence, group3, i10), 7)));
                } catch (NumberFormatException e10) {
                    throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Period", charSequence, 0).initCause(e10));
                }
            }
        }
        throw new DateTimeParseException("Text cannot be parsed to a Period", charSequence, 0);
    }

    private static int parseNumber(CharSequence charSequence, String str, int i10) {
        if (str == null) {
            return 0;
        }
        try {
            return d.m(Integer.parseInt(str), i10);
        } catch (ArithmeticException e10) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Period", charSequence, 0).initCause(e10));
        }
    }

    private Object readResolve() {
        return ((this.years | this.months) | this.days) == 0 ? ZERO : this;
    }

    @Override // fj.c, ij.e
    public ij.a addTo(ij.a aVar) {
        d.j(aVar, "temporal");
        int i10 = this.years;
        if (i10 != 0) {
            aVar = this.months != 0 ? aVar.plus(toTotalMonths(), ChronoUnit.MONTHS) : aVar.plus(i10, ChronoUnit.YEARS);
        } else {
            int i11 = this.months;
            if (i11 != 0) {
                aVar = aVar.plus(i11, ChronoUnit.MONTHS);
            }
        }
        int i12 = this.days;
        return i12 != 0 ? aVar.plus(i12, ChronoUnit.DAYS) : aVar;
    }

    @Override // fj.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Period)) {
            return false;
        }
        Period period = (Period) obj;
        return this.years == period.years && this.months == period.months && this.days == period.days;
    }

    @Override // fj.c, ij.e
    public long get(i iVar) {
        int i10;
        if (iVar == ChronoUnit.YEARS) {
            i10 = this.years;
        } else if (iVar == ChronoUnit.MONTHS) {
            i10 = this.months;
        } else {
            if (iVar != ChronoUnit.DAYS) {
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + iVar);
            }
            i10 = this.days;
        }
        return i10;
    }

    @Override // fj.c
    public b getChronology() {
        return IsoChronology.INSTANCE;
    }

    public int getDays() {
        return this.days;
    }

    public int getMonths() {
        return this.months;
    }

    @Override // fj.c, ij.e
    public List<i> getUnits() {
        return Collections.unmodifiableList(Arrays.asList(ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS));
    }

    public int getYears() {
        return this.years;
    }

    @Override // fj.c
    public int hashCode() {
        return this.years + Integer.rotateLeft(this.months, 8) + Integer.rotateLeft(this.days, 16);
    }

    @Override // fj.c
    public boolean isNegative() {
        return this.years < 0 || this.months < 0 || this.days < 0;
    }

    @Override // fj.c
    public boolean isZero() {
        return this == ZERO;
    }

    public Period minusDays(long j10) {
        return j10 == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1L) : plusDays(-j10);
    }

    public Period minusMonths(long j10) {
        return j10 == Long.MIN_VALUE ? plusMonths(Long.MAX_VALUE).plusMonths(1L) : plusMonths(-j10);
    }

    public Period minusYears(long j10) {
        return j10 == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1L) : plusYears(-j10);
    }

    public Period plusDays(long j10) {
        return j10 == 0 ? this : create(this.years, this.months, d.r(d.l(this.days, j10)));
    }

    public Period plusMonths(long j10) {
        return j10 == 0 ? this : create(this.years, d.r(d.l(this.months, j10)), this.days);
    }

    public Period plusYears(long j10) {
        return j10 == 0 ? this : create(d.r(d.l(this.years, j10)), this.months, this.days);
    }

    @Override // fj.c, ij.e
    public ij.a subtractFrom(ij.a aVar) {
        d.j(aVar, "temporal");
        int i10 = this.years;
        if (i10 != 0) {
            aVar = this.months != 0 ? aVar.minus(toTotalMonths(), ChronoUnit.MONTHS) : aVar.minus(i10, ChronoUnit.YEARS);
        } else {
            int i11 = this.months;
            if (i11 != 0) {
                aVar = aVar.minus(i11, ChronoUnit.MONTHS);
            }
        }
        int i12 = this.days;
        return i12 != 0 ? aVar.minus(i12, ChronoUnit.DAYS) : aVar;
    }

    @Override // fj.c
    public String toString() {
        if (this == ZERO) {
            return "P0D";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('P');
        int i10 = this.years;
        if (i10 != 0) {
            sb2.append(i10);
            sb2.append('Y');
        }
        int i11 = this.months;
        if (i11 != 0) {
            sb2.append(i11);
            sb2.append('M');
        }
        int i12 = this.days;
        if (i12 != 0) {
            sb2.append(i12);
            sb2.append('D');
        }
        return sb2.toString();
    }

    public long toTotalMonths() {
        return (this.years * 12) + this.months;
    }

    public Period withDays(int i10) {
        return i10 == this.days ? this : create(this.years, this.months, i10);
    }

    public Period withMonths(int i10) {
        return i10 == this.months ? this : create(this.years, i10, this.days);
    }

    public Period withYears(int i10) {
        return i10 == this.years ? this : create(i10, this.months, this.days);
    }

    @Override // fj.c
    public Period minus(e eVar) {
        Period from = from(eVar);
        return create(d.p(this.years, from.years), d.p(this.months, from.months), d.p(this.days, from.days));
    }

    @Override // fj.c
    public Period multipliedBy(int i10) {
        return (this == ZERO || i10 == 1) ? this : create(d.m(this.years, i10), d.m(this.months, i10), d.m(this.days, i10));
    }

    @Override // fj.c
    public Period negated() {
        return multipliedBy(-1);
    }

    @Override // fj.c
    public Period normalized() {
        long totalMonths = toTotalMonths();
        long j10 = totalMonths / 12;
        int i10 = (int) (totalMonths % 12);
        return (j10 == ((long) this.years) && i10 == this.months) ? this : create(d.r(j10), i10, this.days);
    }

    @Override // fj.c
    public Period plus(e eVar) {
        Period from = from(eVar);
        return create(d.k(this.years, from.years), d.k(this.months, from.months), d.k(this.days, from.days));
    }
}
