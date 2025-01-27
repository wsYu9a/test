package org.threeten.bp;

import androidx.media3.common.C;
import hj.c;
import hj.d;
import ij.e;
import ij.f;
import ij.g;
import ij.h;
import ij.i;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.SignStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes4.dex */
public final class YearMonth extends c implements ij.a, ij.c, Comparable<YearMonth>, Serializable {
    public static final h<YearMonth> FROM = new a();
    private static final DateTimeFormatter PARSER = new DateTimeFormatterBuilder().u(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).h('-').t(ChronoField.MONTH_OF_YEAR, 2).P();
    private static final long serialVersionUID = 4183400860270640070L;
    private final int month;
    private final int year;

    public class a implements h<YearMonth> {
        @Override // ij.h
        /* renamed from: b */
        public YearMonth a(ij.b bVar) {
            return YearMonth.from(bVar);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f29494a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f29495b;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            f29495b = iArr;
            try {
                iArr[ChronoUnit.MONTHS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29495b[ChronoUnit.YEARS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29495b[ChronoUnit.DECADES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29495b[ChronoUnit.CENTURIES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f29495b[ChronoUnit.MILLENNIA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f29495b[ChronoUnit.ERAS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            f29494a = iArr2;
            try {
                iArr2[ChronoField.MONTH_OF_YEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f29494a[ChronoField.PROLEPTIC_MONTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f29494a[ChronoField.YEAR_OF_ERA.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f29494a[ChronoField.YEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f29494a[ChronoField.ERA.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private YearMonth(int i10, int i11) {
        this.year = i10;
        this.month = i11;
    }

    public static YearMonth from(ij.b bVar) {
        if (bVar instanceof YearMonth) {
            return (YearMonth) bVar;
        }
        try {
            if (!IsoChronology.INSTANCE.equals(org.threeten.bp.chrono.b.from(bVar))) {
                bVar = LocalDate.from(bVar);
            }
            return of(bVar.get(ChronoField.YEAR), bVar.get(ChronoField.MONTH_OF_YEAR));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain YearMonth from TemporalAccessor: " + bVar + ", type " + bVar.getClass().getName());
        }
    }

    private long getProlepticMonth() {
        return (this.year * 12) + (this.month - 1);
    }

    public static YearMonth now() {
        return now(Clock.systemDefaultZone());
    }

    public static YearMonth of(int i10, Month month) {
        d.j(month, "month");
        return of(i10, month.getValue());
    }

    public static YearMonth parse(CharSequence charSequence) {
        return parse(charSequence, PARSER);
    }

    public static YearMonth readExternal(DataInput dataInput) throws IOException {
        return of(dataInput.readInt(), dataInput.readByte());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 68, this);
    }

    @Override // ij.c
    public ij.a adjustInto(ij.a aVar) {
        if (org.threeten.bp.chrono.b.from(aVar).equals(IsoChronology.INSTANCE)) {
            return aVar.with(ChronoField.PROLEPTIC_MONTH, getProlepticMonth());
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public LocalDate atDay(int i10) {
        return LocalDate.of(this.year, this.month, i10);
    }

    public LocalDate atEndOfMonth() {
        return LocalDate.of(this.year, this.month, lengthOfMonth());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YearMonth)) {
            return false;
        }
        YearMonth yearMonth = (YearMonth) obj;
        return this.year == yearMonth.year && this.month == yearMonth.month;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        d.j(dateTimeFormatter, "formatter");
        return dateTimeFormatter.d(this);
    }

    @Override // hj.c, ij.b
    public int get(f fVar) {
        return range(fVar).checkValidIntValue(getLong(fVar), fVar);
    }

    @Override // ij.b
    public long getLong(f fVar) {
        int i10;
        if (!(fVar instanceof ChronoField)) {
            return fVar.getFrom(this);
        }
        int i11 = b.f29494a[((ChronoField) fVar).ordinal()];
        if (i11 == 1) {
            i10 = this.month;
        } else {
            if (i11 == 2) {
                return getProlepticMonth();
            }
            if (i11 == 3) {
                int i12 = this.year;
                if (i12 < 1) {
                    i12 = 1 - i12;
                }
                return i12;
            }
            if (i11 != 4) {
                if (i11 == 5) {
                    return this.year < 1 ? 0 : 1;
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
            }
            i10 = this.year;
        }
        return i10;
    }

    public Month getMonth() {
        return Month.of(this.month);
    }

    public int getMonthValue() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public int hashCode() {
        return this.year ^ (this.month << 27);
    }

    public boolean isAfter(YearMonth yearMonth) {
        return compareTo(yearMonth) > 0;
    }

    public boolean isBefore(YearMonth yearMonth) {
        return compareTo(yearMonth) < 0;
    }

    public boolean isLeapYear() {
        return IsoChronology.INSTANCE.isLeapYear(this.year);
    }

    @Override // ij.b
    public boolean isSupported(f fVar) {
        return fVar instanceof ChronoField ? fVar == ChronoField.YEAR || fVar == ChronoField.MONTH_OF_YEAR || fVar == ChronoField.PROLEPTIC_MONTH || fVar == ChronoField.YEAR_OF_ERA || fVar == ChronoField.ERA : fVar != null && fVar.isSupportedBy(this);
    }

    public boolean isValidDay(int i10) {
        return i10 >= 1 && i10 <= lengthOfMonth();
    }

    public int lengthOfMonth() {
        return getMonth().length(isLeapYear());
    }

    public int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    public YearMonth minusMonths(long j10) {
        return j10 == Long.MIN_VALUE ? plusMonths(Long.MAX_VALUE).plusMonths(1L) : plusMonths(-j10);
    }

    public YearMonth minusYears(long j10) {
        return j10 == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1L) : plusYears(-j10);
    }

    public YearMonth plusMonths(long j10) {
        if (j10 == 0) {
            return this;
        }
        long j11 = (this.year * 12) + (this.month - 1) + j10;
        return with(ChronoField.YEAR.checkValidIntValue(d.e(j11, 12L)), d.g(j11, 12) + 1);
    }

    public YearMonth plusYears(long j10) {
        return j10 == 0 ? this : with(ChronoField.YEAR.checkValidIntValue(this.year + j10), this.month);
    }

    @Override // hj.c, ij.b
    public <R> R query(h<R> hVar) {
        if (hVar == g.a()) {
            return (R) IsoChronology.INSTANCE;
        }
        if (hVar == g.e()) {
            return (R) ChronoUnit.MONTHS;
        }
        if (hVar == g.b() || hVar == g.c() || hVar == g.f() || hVar == g.g() || hVar == g.d()) {
            return null;
        }
        return (R) super.query(hVar);
    }

    @Override // hj.c, ij.b
    public ValueRange range(f fVar) {
        if (fVar == ChronoField.YEAR_OF_ERA) {
            return ValueRange.of(1L, getYear() <= 0 ? C.NANOS_PER_SECOND : 999999999L);
        }
        return super.range(fVar);
    }

    public String toString() {
        int abs = Math.abs(this.year);
        StringBuilder sb2 = new StringBuilder(9);
        if (abs < 1000) {
            int i10 = this.year;
            if (i10 < 0) {
                sb2.append(i10 - 10000);
                sb2.deleteCharAt(1);
            } else {
                sb2.append(i10 + 10000);
                sb2.deleteCharAt(0);
            }
        } else {
            sb2.append(this.year);
        }
        sb2.append(this.month < 10 ? "-0" : "-");
        sb2.append(this.month);
        return sb2.toString();
    }

    @Override // ij.a
    public long until(ij.a aVar, i iVar) {
        YearMonth from = from(aVar);
        if (!(iVar instanceof ChronoUnit)) {
            return iVar.between(this, from);
        }
        long prolepticMonth = from.getProlepticMonth() - getProlepticMonth();
        switch (b.f29495b[((ChronoUnit) iVar).ordinal()]) {
            case 1:
                return prolepticMonth;
            case 2:
                return prolepticMonth / 12;
            case 3:
                return prolepticMonth / 120;
            case 4:
                return prolepticMonth / 1200;
            case 5:
                return prolepticMonth / 12000;
            case 6:
                ChronoField chronoField = ChronoField.ERA;
                return from.getLong(chronoField) - getLong(chronoField);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + iVar);
        }
    }

    public YearMonth withMonth(int i10) {
        ChronoField.MONTH_OF_YEAR.checkValidValue(i10);
        return with(this.year, i10);
    }

    public YearMonth withYear(int i10) {
        ChronoField.YEAR.checkValidValue(i10);
        return with(i10, this.month);
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.year);
        dataOutput.writeByte(this.month);
    }

    public static YearMonth now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static YearMonth parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        d.j(dateTimeFormatter, "formatter");
        return (YearMonth) dateTimeFormatter.t(charSequence, FROM);
    }

    @Override // java.lang.Comparable
    public int compareTo(YearMonth yearMonth) {
        int i10 = this.year - yearMonth.year;
        return i10 == 0 ? this.month - yearMonth.month : i10;
    }

    public static YearMonth now(Clock clock) {
        LocalDate now = LocalDate.now(clock);
        return of(now.getYear(), now.getMonth());
    }

    public static YearMonth of(int i10, int i11) {
        ChronoField.YEAR.checkValidValue(i10);
        ChronoField.MONTH_OF_YEAR.checkValidValue(i11);
        return new YearMonth(i10, i11);
    }

    private YearMonth with(int i10, int i11) {
        return (this.year == i10 && this.month == i11) ? this : new YearMonth(i10, i11);
    }

    @Override // ij.a
    public YearMonth minus(e eVar) {
        return (YearMonth) eVar.subtractFrom(this);
    }

    @Override // ij.a
    public YearMonth plus(e eVar) {
        return (YearMonth) eVar.addTo(this);
    }

    @Override // ij.a
    public boolean isSupported(i iVar) {
        return iVar instanceof ChronoUnit ? iVar == ChronoUnit.MONTHS || iVar == ChronoUnit.YEARS || iVar == ChronoUnit.DECADES || iVar == ChronoUnit.CENTURIES || iVar == ChronoUnit.MILLENNIA || iVar == ChronoUnit.ERAS : iVar != null && iVar.isSupportedBy(this);
    }

    @Override // ij.a
    public YearMonth minus(long j10, i iVar) {
        return j10 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, iVar).plus(1L, iVar) : plus(-j10, iVar);
    }

    @Override // ij.a
    public YearMonth plus(long j10, i iVar) {
        if (iVar instanceof ChronoUnit) {
            switch (b.f29495b[((ChronoUnit) iVar).ordinal()]) {
                case 1:
                    return plusMonths(j10);
                case 2:
                    return plusYears(j10);
                case 3:
                    return plusYears(d.n(j10, 10));
                case 4:
                    return plusYears(d.n(j10, 100));
                case 5:
                    return plusYears(d.n(j10, 1000));
                case 6:
                    ChronoField chronoField = ChronoField.ERA;
                    return with((f) chronoField, d.l(getLong(chronoField), j10));
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported unit: " + iVar);
            }
        }
        return (YearMonth) iVar.addTo(this, j10);
    }

    @Override // ij.a
    public YearMonth with(ij.c cVar) {
        return (YearMonth) cVar.adjustInto(this);
    }

    @Override // ij.a
    public YearMonth with(f fVar, long j10) {
        if (fVar instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) fVar;
            chronoField.checkValidValue(j10);
            int i10 = b.f29494a[chronoField.ordinal()];
            if (i10 == 1) {
                return withMonth((int) j10);
            }
            if (i10 == 2) {
                return plusMonths(j10 - getLong(ChronoField.PROLEPTIC_MONTH));
            }
            if (i10 == 3) {
                if (this.year < 1) {
                    j10 = 1 - j10;
                }
                return withYear((int) j10);
            }
            if (i10 == 4) {
                return withYear((int) j10);
            }
            if (i10 == 5) {
                return getLong(ChronoField.ERA) == j10 ? this : withYear(1 - this.year);
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
        }
        return (YearMonth) fVar.adjustInto(this, j10);
    }
}
