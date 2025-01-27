package org.threeten.bp;

import androidx.media3.common.C;
import fj.e;
import hj.d;
import ij.c;
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
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.zone.ZoneOffsetTransition;

/* loaded from: classes4.dex */
public final class LocalDate extends org.threeten.bp.chrono.a implements ij.a, c, Serializable {
    static final long DAYS_0000_TO_1970 = 719528;
    private static final int DAYS_PER_CYCLE = 146097;
    private static final long serialVersionUID = 2942565459149668126L;
    private final short day;
    private final short month;
    private final int year;
    public static final LocalDate MIN = of(Year.MIN_VALUE, 1, 1);
    public static final LocalDate MAX = of(Year.MAX_VALUE, 12, 31);
    public static final h<LocalDate> FROM = new a();

    public class a implements h<LocalDate> {
        @Override // ij.h
        /* renamed from: b */
        public LocalDate a(ij.b bVar) {
            return LocalDate.from(bVar);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f29483a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f29484b;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            f29484b = iArr;
            try {
                iArr[ChronoUnit.DAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29484b[ChronoUnit.WEEKS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29484b[ChronoUnit.MONTHS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29484b[ChronoUnit.YEARS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f29484b[ChronoUnit.DECADES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f29484b[ChronoUnit.CENTURIES.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f29484b[ChronoUnit.MILLENNIA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f29484b[ChronoUnit.ERAS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            f29483a = iArr2;
            try {
                iArr2[ChronoField.DAY_OF_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f29483a[ChronoField.DAY_OF_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f29483a[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f29483a[ChronoField.YEAR_OF_ERA.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f29483a[ChronoField.DAY_OF_WEEK.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f29483a[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f29483a[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f29483a[ChronoField.EPOCH_DAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f29483a[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 9;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f29483a[ChronoField.MONTH_OF_YEAR.ordinal()] = 10;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f29483a[ChronoField.PROLEPTIC_MONTH.ordinal()] = 11;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f29483a[ChronoField.YEAR.ordinal()] = 12;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f29483a[ChronoField.ERA.ordinal()] = 13;
            } catch (NoSuchFieldError unused21) {
            }
        }
    }

    private LocalDate(int i10, int i11, int i12) {
        this.year = i10;
        this.month = (short) i11;
        this.day = (short) i12;
    }

    private static LocalDate create(int i10, Month month, int i11) {
        if (i11 <= 28 || i11 <= month.length(IsoChronology.INSTANCE.isLeapYear(i10))) {
            return new LocalDate(i10, month.getValue(), i11);
        }
        if (i11 == 29) {
            throw new DateTimeException("Invalid date 'February 29' as '" + i10 + "' is not a leap year");
        }
        throw new DateTimeException("Invalid date '" + month.name() + " " + i11 + "'");
    }

    public static LocalDate from(ij.b bVar) {
        LocalDate localDate = (LocalDate) bVar.query(g.b());
        if (localDate != null) {
            return localDate;
        }
        throw new DateTimeException("Unable to obtain LocalDate from TemporalAccessor: " + bVar + ", type " + bVar.getClass().getName());
    }

    private int get0(f fVar) {
        switch (b.f29483a[((ChronoField) fVar).ordinal()]) {
            case 1:
                return this.day;
            case 2:
                return getDayOfYear();
            case 3:
                return ((this.day - 1) / 7) + 1;
            case 4:
                int i10 = this.year;
                return i10 >= 1 ? i10 : 1 - i10;
            case 5:
                return getDayOfWeek().getValue();
            case 6:
                return ((this.day - 1) % 7) + 1;
            case 7:
                return ((getDayOfYear() - 1) % 7) + 1;
            case 8:
                throw new DateTimeException("Field too large for an int: " + fVar);
            case 9:
                return ((getDayOfYear() - 1) / 7) + 1;
            case 10:
                return this.month;
            case 11:
                throw new DateTimeException("Field too large for an int: " + fVar);
            case 12:
                return this.year;
            case 13:
                return this.year >= 1 ? 1 : 0;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
        }
    }

    private long getProlepticMonth() {
        return (this.year * 12) + (this.month - 1);
    }

    private long monthsUntil(LocalDate localDate) {
        return (((localDate.getProlepticMonth() * 32) + localDate.getDayOfMonth()) - ((getProlepticMonth() * 32) + getDayOfMonth())) / 32;
    }

    public static LocalDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static LocalDate of(int i10, Month month, int i11) {
        ChronoField.YEAR.checkValidValue(i10);
        d.j(month, "month");
        ChronoField.DAY_OF_MONTH.checkValidValue(i11);
        return create(i10, month, i11);
    }

    public static LocalDate ofEpochDay(long j10) {
        long j11;
        ChronoField.EPOCH_DAY.checkValidValue(j10);
        long j12 = 719468 + j10;
        if (j12 < 0) {
            long j13 = ((j10 + 719469) / 146097) - 1;
            j11 = j13 * 400;
            j12 += (-j13) * 146097;
        } else {
            j11 = 0;
        }
        long j14 = ((j12 * 400) + 591) / 146097;
        long j15 = j12 - ((((j14 * 365) + (j14 / 4)) - (j14 / 100)) + (j14 / 400));
        if (j15 < 0) {
            j14--;
            j15 = j12 - ((((365 * j14) + (j14 / 4)) - (j14 / 100)) + (j14 / 400));
        }
        int i10 = (int) j15;
        int i11 = ((i10 * 5) + 2) / 153;
        return new LocalDate(ChronoField.YEAR.checkValidIntValue(j14 + j11 + (i11 / 10)), ((i11 + 2) % 12) + 1, (i10 - (((i11 * 306) + 5) / 10)) + 1);
    }

    public static LocalDate ofYearDay(int i10, int i11) {
        long j10 = i10;
        ChronoField.YEAR.checkValidValue(j10);
        ChronoField.DAY_OF_YEAR.checkValidValue(i11);
        boolean isLeapYear = IsoChronology.INSTANCE.isLeapYear(j10);
        if (i11 != 366 || isLeapYear) {
            Month of2 = Month.of(((i11 - 1) / 31) + 1);
            if (i11 > (of2.firstDayOfYear(isLeapYear) + of2.length(isLeapYear)) - 1) {
                of2 = of2.plus(1L);
            }
            return create(i10, of2, (i11 - of2.firstDayOfYear(isLeapYear)) + 1);
        }
        throw new DateTimeException("Invalid date 'DayOfYear 366' as '" + i10 + "' is not a leap year");
    }

    public static LocalDate parse(CharSequence charSequence) {
        return parse(charSequence, DateTimeFormatter.f29511h);
    }

    public static LocalDate readExternal(DataInput dataInput) throws IOException {
        return of(dataInput.readInt(), dataInput.readByte(), dataInput.readByte());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private static LocalDate resolvePreviousValid(int i10, int i11, int i12) {
        if (i11 == 2) {
            i12 = Math.min(i12, IsoChronology.INSTANCE.isLeapYear((long) i10) ? 29 : 28);
        } else if (i11 == 4 || i11 == 6 || i11 == 9 || i11 == 11) {
            i12 = Math.min(i12, 30);
        }
        return of(i10, i11, i12);
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    @Override // org.threeten.bp.chrono.a, ij.c
    public ij.a adjustInto(ij.a aVar) {
        return super.adjustInto(aVar);
    }

    public LocalDateTime atStartOfDay() {
        return LocalDateTime.of(this, LocalTime.MIDNIGHT);
    }

    public int compareTo0(LocalDate localDate) {
        int i10 = this.year - localDate.year;
        if (i10 != 0) {
            return i10;
        }
        int i11 = this.month - localDate.month;
        return i11 == 0 ? this.day - localDate.day : i11;
    }

    public long daysUntil(LocalDate localDate) {
        return localDate.toEpochDay() - toEpochDay();
    }

    @Override // org.threeten.bp.chrono.a
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocalDate) && compareTo0((LocalDate) obj) == 0;
    }

    @Override // org.threeten.bp.chrono.a
    public String format(DateTimeFormatter dateTimeFormatter) {
        return super.format(dateTimeFormatter);
    }

    @Override // hj.c, ij.b
    public int get(f fVar) {
        return fVar instanceof ChronoField ? get0(fVar) : super.get(fVar);
    }

    public int getDayOfMonth() {
        return this.day;
    }

    public DayOfWeek getDayOfWeek() {
        return DayOfWeek.of(d.g(toEpochDay() + 3, 7) + 1);
    }

    public int getDayOfYear() {
        return (getMonth().firstDayOfYear(isLeapYear()) + this.day) - 1;
    }

    @Override // org.threeten.bp.chrono.a
    public e getEra() {
        return super.getEra();
    }

    @Override // ij.b
    public long getLong(f fVar) {
        return fVar instanceof ChronoField ? fVar == ChronoField.EPOCH_DAY ? toEpochDay() : fVar == ChronoField.PROLEPTIC_MONTH ? getProlepticMonth() : get0(fVar) : fVar.getFrom(this);
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

    @Override // org.threeten.bp.chrono.a
    public int hashCode() {
        int i10 = this.year;
        return (((i10 << 11) + (this.month << 6)) + this.day) ^ (i10 & (-2048));
    }

    @Override // org.threeten.bp.chrono.a
    public boolean isAfter(org.threeten.bp.chrono.a aVar) {
        return aVar instanceof LocalDate ? compareTo0((LocalDate) aVar) > 0 : super.isAfter(aVar);
    }

    @Override // org.threeten.bp.chrono.a
    public boolean isBefore(org.threeten.bp.chrono.a aVar) {
        return aVar instanceof LocalDate ? compareTo0((LocalDate) aVar) < 0 : super.isBefore(aVar);
    }

    @Override // org.threeten.bp.chrono.a
    public boolean isEqual(org.threeten.bp.chrono.a aVar) {
        return aVar instanceof LocalDate ? compareTo0((LocalDate) aVar) == 0 : super.isEqual(aVar);
    }

    @Override // org.threeten.bp.chrono.a
    public boolean isLeapYear() {
        return IsoChronology.INSTANCE.isLeapYear(this.year);
    }

    @Override // org.threeten.bp.chrono.a, ij.b
    public boolean isSupported(f fVar) {
        return super.isSupported(fVar);
    }

    @Override // org.threeten.bp.chrono.a
    public int lengthOfMonth() {
        short s10 = this.month;
        return s10 != 2 ? (s10 == 4 || s10 == 6 || s10 == 9 || s10 == 11) ? 30 : 31 : isLeapYear() ? 29 : 28;
    }

    @Override // org.threeten.bp.chrono.a
    public int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    public LocalDate minusDays(long j10) {
        return j10 == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1L) : plusDays(-j10);
    }

    public LocalDate minusMonths(long j10) {
        return j10 == Long.MIN_VALUE ? plusMonths(Long.MAX_VALUE).plusMonths(1L) : plusMonths(-j10);
    }

    public LocalDate minusWeeks(long j10) {
        return j10 == Long.MIN_VALUE ? plusWeeks(Long.MAX_VALUE).plusWeeks(1L) : plusWeeks(-j10);
    }

    public LocalDate minusYears(long j10) {
        return j10 == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1L) : plusYears(-j10);
    }

    public LocalDate plusDays(long j10) {
        return j10 == 0 ? this : ofEpochDay(d.l(toEpochDay(), j10));
    }

    public LocalDate plusMonths(long j10) {
        if (j10 == 0) {
            return this;
        }
        long j11 = (this.year * 12) + (this.month - 1) + j10;
        return resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(d.e(j11, 12L)), d.g(j11, 12) + 1, this.day);
    }

    public LocalDate plusWeeks(long j10) {
        return plusDays(d.n(j10, 7));
    }

    public LocalDate plusYears(long j10) {
        return j10 == 0 ? this : resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(this.year + j10), this.month, this.day);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.threeten.bp.chrono.a, hj.c, ij.b
    public <R> R query(h<R> hVar) {
        return hVar == g.b() ? this : (R) super.query(hVar);
    }

    @Override // hj.c, ij.b
    public ValueRange range(f fVar) {
        if (!(fVar instanceof ChronoField)) {
            return fVar.rangeRefinedBy(this);
        }
        ChronoField chronoField = (ChronoField) fVar;
        if (!chronoField.isDateBased()) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
        }
        int i10 = b.f29483a[chronoField.ordinal()];
        if (i10 == 1) {
            return ValueRange.of(1L, lengthOfMonth());
        }
        if (i10 == 2) {
            return ValueRange.of(1L, lengthOfYear());
        }
        if (i10 == 3) {
            return ValueRange.of(1L, (getMonth() != Month.FEBRUARY || isLeapYear()) ? 5L : 4L);
        }
        if (i10 != 4) {
            return fVar.range();
        }
        return ValueRange.of(1L, getYear() <= 0 ? C.NANOS_PER_SECOND : 999999999L);
    }

    @Override // org.threeten.bp.chrono.a
    public long toEpochDay() {
        long j10 = this.year;
        long j11 = this.month;
        long j12 = 365 * j10;
        long j13 = (j10 >= 0 ? j12 + (((3 + j10) / 4) - ((99 + j10) / 100)) + ((j10 + 399) / 400) : j12 - (((j10 / (-4)) - (j10 / (-100))) + (j10 / (-400)))) + (((367 * j11) - 362) / 12) + (this.day - 1);
        if (j11 > 2) {
            j13 = !isLeapYear() ? j13 - 2 : j13 - 1;
        }
        return j13 - DAYS_0000_TO_1970;
    }

    @Override // org.threeten.bp.chrono.a
    public String toString() {
        int i10 = this.year;
        short s10 = this.month;
        short s11 = this.day;
        int abs = Math.abs(i10);
        StringBuilder sb2 = new StringBuilder(10);
        if (abs >= 1000) {
            if (i10 > 9999) {
                sb2.append('+');
            }
            sb2.append(i10);
        } else if (i10 < 0) {
            sb2.append(i10 - 10000);
            sb2.deleteCharAt(1);
        } else {
            sb2.append(i10 + 10000);
            sb2.deleteCharAt(0);
        }
        sb2.append(s10 < 10 ? "-0" : "-");
        sb2.append((int) s10);
        sb2.append(s11 < 10 ? "-0" : "-");
        sb2.append((int) s11);
        return sb2.toString();
    }

    public LocalDate withDayOfMonth(int i10) {
        return this.day == i10 ? this : of(this.year, this.month, i10);
    }

    public LocalDate withDayOfYear(int i10) {
        return getDayOfYear() == i10 ? this : ofYearDay(this.year, i10);
    }

    public LocalDate withMonth(int i10) {
        if (this.month == i10) {
            return this;
        }
        ChronoField.MONTH_OF_YEAR.checkValidValue(i10);
        return resolvePreviousValid(this.year, i10, this.day);
    }

    public LocalDate withYear(int i10) {
        if (this.year == i10) {
            return this;
        }
        ChronoField.YEAR.checkValidValue(i10);
        return resolvePreviousValid(i10, this.month, this.day);
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.year);
        dataOutput.writeByte(this.month);
        dataOutput.writeByte(this.day);
    }

    public static LocalDate now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static LocalDate parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        d.j(dateTimeFormatter, "formatter");
        return (LocalDate) dateTimeFormatter.t(charSequence, FROM);
    }

    public ZonedDateTime atStartOfDay(ZoneId zoneId) {
        ZoneOffsetTransition transition;
        d.j(zoneId, "zone");
        LocalDateTime atTime = atTime(LocalTime.MIDNIGHT);
        if (!(zoneId instanceof ZoneOffset) && (transition = zoneId.getRules().getTransition(atTime)) != null && transition.isGap()) {
            atTime = transition.getDateTimeAfter();
        }
        return ZonedDateTime.of(atTime, zoneId);
    }

    @Override // org.threeten.bp.chrono.a
    public LocalDateTime atTime(LocalTime localTime) {
        return LocalDateTime.of(this, localTime);
    }

    @Override // org.threeten.bp.chrono.a, java.lang.Comparable
    public int compareTo(org.threeten.bp.chrono.a aVar) {
        return aVar instanceof LocalDate ? compareTo0((LocalDate) aVar) : super.compareTo(aVar);
    }

    @Override // org.threeten.bp.chrono.a
    public IsoChronology getChronology() {
        return IsoChronology.INSTANCE;
    }

    @Override // ij.a
    public long until(ij.a aVar, i iVar) {
        LocalDate from = from((ij.b) aVar);
        if (!(iVar instanceof ChronoUnit)) {
            return iVar.between(this, from);
        }
        switch (b.f29484b[((ChronoUnit) iVar).ordinal()]) {
            case 1:
                return daysUntil(from);
            case 2:
                return daysUntil(from) / 7;
            case 3:
                return monthsUntil(from);
            case 4:
                return monthsUntil(from) / 12;
            case 5:
                return monthsUntil(from) / 120;
            case 6:
                return monthsUntil(from) / 1200;
            case 7:
                return monthsUntil(from) / 12000;
            case 8:
                ChronoField chronoField = ChronoField.ERA;
                return from.getLong(chronoField) - getLong(chronoField);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + iVar);
        }
    }

    public static LocalDate now(Clock clock) {
        d.j(clock, "clock");
        return ofEpochDay(d.e(clock.instant().getEpochSecond() + clock.getZone().getRules().getOffset(r0).getTotalSeconds(), 86400L));
    }

    public LocalDateTime atTime(int i10, int i11) {
        return atTime(LocalTime.of(i10, i11));
    }

    public LocalDateTime atTime(int i10, int i11, int i12) {
        return atTime(LocalTime.of(i10, i11, i12));
    }

    public static LocalDate of(int i10, int i11, int i12) {
        ChronoField.YEAR.checkValidValue(i10);
        ChronoField.MONTH_OF_YEAR.checkValidValue(i11);
        ChronoField.DAY_OF_MONTH.checkValidValue(i12);
        return create(i10, Month.of(i11), i12);
    }

    public LocalDateTime atTime(int i10, int i11, int i12, int i13) {
        return atTime(LocalTime.of(i10, i11, i12, i13));
    }

    @Override // org.threeten.bp.chrono.a, hj.b, ij.a
    public LocalDate minus(ij.e eVar) {
        return (LocalDate) eVar.subtractFrom(this);
    }

    @Override // org.threeten.bp.chrono.a, hj.b, ij.a
    public LocalDate plus(ij.e eVar) {
        return (LocalDate) eVar.addTo(this);
    }

    @Override // org.threeten.bp.chrono.a, hj.b, ij.a
    public LocalDate with(c cVar) {
        if (cVar instanceof LocalDate) {
            return (LocalDate) cVar;
        }
        return (LocalDate) cVar.adjustInto(this);
    }

    public OffsetDateTime atTime(OffsetTime offsetTime) {
        return OffsetDateTime.of(LocalDateTime.of(this, offsetTime.toLocalTime()), offsetTime.getOffset());
    }

    @Override // org.threeten.bp.chrono.a, hj.b, ij.a
    public LocalDate minus(long j10, i iVar) {
        return j10 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, iVar).plus(1L, iVar) : plus(-j10, iVar);
    }

    @Override // org.threeten.bp.chrono.a, ij.a
    public LocalDate plus(long j10, i iVar) {
        if (iVar instanceof ChronoUnit) {
            switch (b.f29484b[((ChronoUnit) iVar).ordinal()]) {
                case 1:
                    return plusDays(j10);
                case 2:
                    return plusWeeks(j10);
                case 3:
                    return plusMonths(j10);
                case 4:
                    return plusYears(j10);
                case 5:
                    return plusYears(d.n(j10, 10));
                case 6:
                    return plusYears(d.n(j10, 100));
                case 7:
                    return plusYears(d.n(j10, 1000));
                case 8:
                    ChronoField chronoField = ChronoField.ERA;
                    return with((f) chronoField, d.l(getLong(chronoField), j10));
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported unit: " + iVar);
            }
        }
        return (LocalDate) iVar.addTo(this, j10);
    }

    @Override // org.threeten.bp.chrono.a, ij.a
    public LocalDate with(f fVar, long j10) {
        if (fVar instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) fVar;
            chronoField.checkValidValue(j10);
            switch (b.f29483a[chronoField.ordinal()]) {
                case 1:
                    return withDayOfMonth((int) j10);
                case 2:
                    return withDayOfYear((int) j10);
                case 3:
                    return plusWeeks(j10 - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH));
                case 4:
                    if (this.year < 1) {
                        j10 = 1 - j10;
                    }
                    return withYear((int) j10);
                case 5:
                    return plusDays(j10 - getDayOfWeek().getValue());
                case 6:
                    return plusDays(j10 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
                case 7:
                    return plusDays(j10 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
                case 8:
                    return ofEpochDay(j10);
                case 9:
                    return plusWeeks(j10 - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR));
                case 10:
                    return withMonth((int) j10);
                case 11:
                    return plusMonths(j10 - getLong(ChronoField.PROLEPTIC_MONTH));
                case 12:
                    return withYear((int) j10);
                case 13:
                    return getLong(ChronoField.ERA) == j10 ? this : withYear(1 - this.year);
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
            }
        }
        return (LocalDate) fVar.adjustInto(this, j10);
    }

    @Override // org.threeten.bp.chrono.a
    public Period until(org.threeten.bp.chrono.a aVar) {
        LocalDate from = from((ij.b) aVar);
        long prolepticMonth = from.getProlepticMonth() - getProlepticMonth();
        int i10 = from.day - this.day;
        if (prolepticMonth > 0 && i10 < 0) {
            prolepticMonth--;
            i10 = (int) (from.toEpochDay() - plusMonths(prolepticMonth).toEpochDay());
        } else if (prolepticMonth < 0 && i10 > 0) {
            prolepticMonth++;
            i10 -= from.lengthOfMonth();
        }
        return Period.of(d.r(prolepticMonth / 12), (int) (prolepticMonth % 12), i10);
    }
}
