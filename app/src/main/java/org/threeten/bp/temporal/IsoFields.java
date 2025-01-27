package org.threeten.bp.temporal;

import com.tencent.bugly.beta.tinker.TinkerReport;
import hj.d;
import ij.b;
import ij.f;
import ij.i;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.ResolverStyle;

/* loaded from: classes4.dex */
public final class IsoFields {

    /* renamed from: a */
    public static final f f29616a = Field.DAY_OF_QUARTER;

    /* renamed from: b */
    public static final f f29617b = Field.QUARTER_OF_YEAR;

    /* renamed from: c */
    public static final f f29618c = Field.WEEK_OF_WEEK_BASED_YEAR;

    /* renamed from: d */
    public static final f f29619d = Field.WEEK_BASED_YEAR;

    /* renamed from: e */
    public static final i f29620e = Unit.WEEK_BASED_YEARS;

    /* renamed from: f */
    public static final i f29621f = Unit.QUARTER_YEARS;

    public enum Field implements f {
        DAY_OF_QUARTER { // from class: org.threeten.bp.temporal.IsoFields.Field.1
            @Override // ij.f
            public <R extends ij.a> R adjustInto(R r10, long j10) {
                long from = getFrom(r10);
                range().checkValidValue(j10, this);
                ChronoField chronoField = ChronoField.DAY_OF_YEAR;
                return (R) r10.with(chronoField, r10.getLong(chronoField) + (j10 - from));
            }

            @Override // ij.f
            public i getBaseUnit() {
                return ChronoUnit.DAYS;
            }

            @Override // ij.f
            public long getFrom(b bVar) {
                if (!bVar.isSupported(this)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
                }
                return bVar.get(ChronoField.DAY_OF_YEAR) - Field.QUARTER_DAYS[((bVar.get(ChronoField.MONTH_OF_YEAR) - 1) / 3) + (IsoChronology.INSTANCE.isLeapYear(bVar.getLong(ChronoField.YEAR)) ? 4 : 0)];
            }

            @Override // ij.f
            public i getRangeUnit() {
                return IsoFields.f29621f;
            }

            @Override // ij.f
            public boolean isSupportedBy(b bVar) {
                return bVar.isSupported(ChronoField.DAY_OF_YEAR) && bVar.isSupported(ChronoField.MONTH_OF_YEAR) && bVar.isSupported(ChronoField.YEAR) && Field.isIso(bVar);
            }

            @Override // ij.f
            public ValueRange range() {
                return ValueRange.of(1L, 90L, 92L);
            }

            @Override // ij.f
            public ValueRange rangeRefinedBy(b bVar) {
                if (!bVar.isSupported(this)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
                }
                long j10 = bVar.getLong(Field.QUARTER_OF_YEAR);
                if (j10 == 1) {
                    return IsoChronology.INSTANCE.isLeapYear(bVar.getLong(ChronoField.YEAR)) ? ValueRange.of(1L, 91L) : ValueRange.of(1L, 90L);
                }
                return j10 == 2 ? ValueRange.of(1L, 91L) : (j10 == 3 || j10 == 4) ? ValueRange.of(1L, 92L) : range();
            }

            @Override // org.threeten.bp.temporal.IsoFields.Field, ij.f
            public b resolve(Map<f, Long> map, b bVar, ResolverStyle resolverStyle) {
                LocalDate plusDays;
                ChronoField chronoField = ChronoField.YEAR;
                Long l10 = map.get(chronoField);
                f fVar = Field.QUARTER_OF_YEAR;
                Long l11 = map.get(fVar);
                if (l10 == null || l11 == null) {
                    return null;
                }
                int checkValidIntValue = chronoField.checkValidIntValue(l10.longValue());
                long longValue = map.get(Field.DAY_OF_QUARTER).longValue();
                if (resolverStyle == ResolverStyle.LENIENT) {
                    plusDays = LocalDate.of(checkValidIntValue, 1, 1).plusMonths(d.n(d.q(l11.longValue(), 1L), 3)).plusDays(d.q(longValue, 1L));
                } else {
                    int checkValidIntValue2 = fVar.range().checkValidIntValue(l11.longValue(), fVar);
                    if (resolverStyle == ResolverStyle.STRICT) {
                        int i10 = 91;
                        if (checkValidIntValue2 == 1) {
                            if (!IsoChronology.INSTANCE.isLeapYear(checkValidIntValue)) {
                                i10 = 90;
                            }
                        } else if (checkValidIntValue2 != 2) {
                            i10 = 92;
                        }
                        ValueRange.of(1L, i10).checkValidValue(longValue, this);
                    } else {
                        range().checkValidValue(longValue, this);
                    }
                    plusDays = LocalDate.of(checkValidIntValue, ((checkValidIntValue2 - 1) * 3) + 1, 1).plusDays(longValue - 1);
                }
                map.remove(this);
                map.remove(chronoField);
                map.remove(fVar);
                return plusDays;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "DayOfQuarter";
            }
        },
        QUARTER_OF_YEAR { // from class: org.threeten.bp.temporal.IsoFields.Field.2
            @Override // ij.f
            public <R extends ij.a> R adjustInto(R r10, long j10) {
                long from = getFrom(r10);
                range().checkValidValue(j10, this);
                ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
                return (R) r10.with(chronoField, r10.getLong(chronoField) + ((j10 - from) * 3));
            }

            @Override // ij.f
            public i getBaseUnit() {
                return IsoFields.f29621f;
            }

            @Override // ij.f
            public long getFrom(b bVar) {
                if (bVar.isSupported(this)) {
                    return (bVar.getLong(ChronoField.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: QuarterOfYear");
            }

            @Override // ij.f
            public i getRangeUnit() {
                return ChronoUnit.YEARS;
            }

            @Override // ij.f
            public boolean isSupportedBy(b bVar) {
                return bVar.isSupported(ChronoField.MONTH_OF_YEAR) && Field.isIso(bVar);
            }

            @Override // ij.f
            public ValueRange range() {
                return ValueRange.of(1L, 4L);
            }

            @Override // ij.f
            public ValueRange rangeRefinedBy(b bVar) {
                return range();
            }

            @Override // java.lang.Enum
            public String toString() {
                return "QuarterOfYear";
            }
        },
        WEEK_OF_WEEK_BASED_YEAR { // from class: org.threeten.bp.temporal.IsoFields.Field.3
            @Override // ij.f
            public <R extends ij.a> R adjustInto(R r10, long j10) {
                range().checkValidValue(j10, this);
                return (R) r10.plus(d.q(j10, getFrom(r10)), ChronoUnit.WEEKS);
            }

            @Override // ij.f
            public i getBaseUnit() {
                return ChronoUnit.WEEKS;
            }

            @Override // org.threeten.bp.temporal.IsoFields.Field, ij.f
            public String getDisplayName(Locale locale) {
                d.j(locale, "locale");
                return "Week";
            }

            @Override // ij.f
            public long getFrom(b bVar) {
                if (bVar.isSupported(this)) {
                    return Field.getWeek(LocalDate.from(bVar));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // ij.f
            public i getRangeUnit() {
                return IsoFields.f29620e;
            }

            @Override // ij.f
            public boolean isSupportedBy(b bVar) {
                return bVar.isSupported(ChronoField.EPOCH_DAY) && Field.isIso(bVar);
            }

            @Override // ij.f
            public ValueRange range() {
                return ValueRange.of(1L, 52L, 53L);
            }

            @Override // ij.f
            public ValueRange rangeRefinedBy(b bVar) {
                if (bVar.isSupported(this)) {
                    return Field.getWeekRange(LocalDate.from(bVar));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // org.threeten.bp.temporal.IsoFields.Field, ij.f
            public b resolve(Map<f, Long> map, b bVar, ResolverStyle resolverStyle) {
                f fVar;
                LocalDate with;
                long j10;
                f fVar2 = Field.WEEK_BASED_YEAR;
                Long l10 = map.get(fVar2);
                ChronoField chronoField = ChronoField.DAY_OF_WEEK;
                Long l11 = map.get(chronoField);
                if (l10 == null || l11 == null) {
                    return null;
                }
                int checkValidIntValue = fVar2.range().checkValidIntValue(l10.longValue(), fVar2);
                long longValue = map.get(Field.WEEK_OF_WEEK_BASED_YEAR).longValue();
                if (resolverStyle == ResolverStyle.LENIENT) {
                    long longValue2 = l11.longValue();
                    if (longValue2 > 7) {
                        long j11 = longValue2 - 1;
                        j10 = j11 / 7;
                        longValue2 = (j11 % 7) + 1;
                    } else if (longValue2 < 1) {
                        j10 = (longValue2 / 7) - 1;
                        longValue2 = (longValue2 % 7) + 7;
                    } else {
                        j10 = 0;
                    }
                    fVar = fVar2;
                    with = LocalDate.of(checkValidIntValue, 1, 4).plusWeeks(longValue - 1).plusWeeks(j10).with((f) chronoField, longValue2);
                } else {
                    fVar = fVar2;
                    int checkValidIntValue2 = chronoField.checkValidIntValue(l11.longValue());
                    if (resolverStyle == ResolverStyle.STRICT) {
                        Field.getWeekRange(LocalDate.of(checkValidIntValue, 1, 4)).checkValidValue(longValue, this);
                    } else {
                        range().checkValidValue(longValue, this);
                    }
                    with = LocalDate.of(checkValidIntValue, 1, 4).plusWeeks(longValue - 1).with((f) chronoField, checkValidIntValue2);
                }
                map.remove(this);
                map.remove(fVar);
                map.remove(chronoField);
                return with;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "WeekOfWeekBasedYear";
            }
        },
        WEEK_BASED_YEAR { // from class: org.threeten.bp.temporal.IsoFields.Field.4
            @Override // ij.f
            public <R extends ij.a> R adjustInto(R r10, long j10) {
                if (!isSupportedBy(r10)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
                }
                int checkValidIntValue = range().checkValidIntValue(j10, Field.WEEK_BASED_YEAR);
                LocalDate from = LocalDate.from((b) r10);
                int i10 = from.get(ChronoField.DAY_OF_WEEK);
                int week = Field.getWeek(from);
                if (week == 53 && Field.getWeekRange(checkValidIntValue) == 52) {
                    week = 52;
                }
                return (R) r10.with(LocalDate.of(checkValidIntValue, 1, 4).plusDays((i10 - r6.get(r0)) + ((week - 1) * 7)));
            }

            @Override // ij.f
            public i getBaseUnit() {
                return IsoFields.f29620e;
            }

            @Override // ij.f
            public long getFrom(b bVar) {
                if (bVar.isSupported(this)) {
                    return Field.getWeekBasedYear(LocalDate.from(bVar));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
            }

            @Override // ij.f
            public i getRangeUnit() {
                return ChronoUnit.FOREVER;
            }

            @Override // ij.f
            public boolean isSupportedBy(b bVar) {
                return bVar.isSupported(ChronoField.EPOCH_DAY) && Field.isIso(bVar);
            }

            @Override // ij.f
            public ValueRange range() {
                return ChronoField.YEAR.range();
            }

            @Override // ij.f
            public ValueRange rangeRefinedBy(b bVar) {
                return ChronoField.YEAR.range();
            }

            @Override // java.lang.Enum
            public String toString() {
                return "WeekBasedYear";
            }
        };

        private static final int[] QUARTER_DAYS = {0, 90, TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, com.umeng.commonsdk.stateless.b.f24569a, 0, 91, TinkerReport.KEY_APPLIED_DEX_EXTRACT, 274};

        /* renamed from: org.threeten.bp.temporal.IsoFields$Field$1 */
        public enum AnonymousClass1 extends Field {
            @Override // ij.f
            public <R extends ij.a> R adjustInto(R r10, long j10) {
                long from = getFrom(r10);
                range().checkValidValue(j10, this);
                ChronoField chronoField = ChronoField.DAY_OF_YEAR;
                return (R) r10.with(chronoField, r10.getLong(chronoField) + (j10 - from));
            }

            @Override // ij.f
            public i getBaseUnit() {
                return ChronoUnit.DAYS;
            }

            @Override // ij.f
            public long getFrom(b bVar) {
                if (!bVar.isSupported(this)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
                }
                return bVar.get(ChronoField.DAY_OF_YEAR) - Field.QUARTER_DAYS[((bVar.get(ChronoField.MONTH_OF_YEAR) - 1) / 3) + (IsoChronology.INSTANCE.isLeapYear(bVar.getLong(ChronoField.YEAR)) ? 4 : 0)];
            }

            @Override // ij.f
            public i getRangeUnit() {
                return IsoFields.f29621f;
            }

            @Override // ij.f
            public boolean isSupportedBy(b bVar) {
                return bVar.isSupported(ChronoField.DAY_OF_YEAR) && bVar.isSupported(ChronoField.MONTH_OF_YEAR) && bVar.isSupported(ChronoField.YEAR) && Field.isIso(bVar);
            }

            @Override // ij.f
            public ValueRange range() {
                return ValueRange.of(1L, 90L, 92L);
            }

            @Override // ij.f
            public ValueRange rangeRefinedBy(b bVar) {
                if (!bVar.isSupported(this)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
                }
                long j10 = bVar.getLong(Field.QUARTER_OF_YEAR);
                if (j10 == 1) {
                    return IsoChronology.INSTANCE.isLeapYear(bVar.getLong(ChronoField.YEAR)) ? ValueRange.of(1L, 91L) : ValueRange.of(1L, 90L);
                }
                return j10 == 2 ? ValueRange.of(1L, 91L) : (j10 == 3 || j10 == 4) ? ValueRange.of(1L, 92L) : range();
            }

            @Override // org.threeten.bp.temporal.IsoFields.Field, ij.f
            public b resolve(Map<f, Long> map, b bVar, ResolverStyle resolverStyle) {
                LocalDate plusDays;
                ChronoField chronoField = ChronoField.YEAR;
                Long l10 = map.get(chronoField);
                f fVar = Field.QUARTER_OF_YEAR;
                Long l11 = map.get(fVar);
                if (l10 == null || l11 == null) {
                    return null;
                }
                int checkValidIntValue = chronoField.checkValidIntValue(l10.longValue());
                long longValue = map.get(Field.DAY_OF_QUARTER).longValue();
                if (resolverStyle == ResolverStyle.LENIENT) {
                    plusDays = LocalDate.of(checkValidIntValue, 1, 1).plusMonths(d.n(d.q(l11.longValue(), 1L), 3)).plusDays(d.q(longValue, 1L));
                } else {
                    int checkValidIntValue2 = fVar.range().checkValidIntValue(l11.longValue(), fVar);
                    if (resolverStyle == ResolverStyle.STRICT) {
                        int i10 = 91;
                        if (checkValidIntValue2 == 1) {
                            if (!IsoChronology.INSTANCE.isLeapYear(checkValidIntValue)) {
                                i10 = 90;
                            }
                        } else if (checkValidIntValue2 != 2) {
                            i10 = 92;
                        }
                        ValueRange.of(1L, i10).checkValidValue(longValue, this);
                    } else {
                        range().checkValidValue(longValue, this);
                    }
                    plusDays = LocalDate.of(checkValidIntValue, ((checkValidIntValue2 - 1) * 3) + 1, 1).plusDays(longValue - 1);
                }
                map.remove(this);
                map.remove(chronoField);
                map.remove(fVar);
                return plusDays;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "DayOfQuarter";
            }
        }

        /* renamed from: org.threeten.bp.temporal.IsoFields$Field$2 */
        public enum AnonymousClass2 extends Field {
            @Override // ij.f
            public <R extends ij.a> R adjustInto(R r10, long j10) {
                long from = getFrom(r10);
                range().checkValidValue(j10, this);
                ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
                return (R) r10.with(chronoField, r10.getLong(chronoField) + ((j10 - from) * 3));
            }

            @Override // ij.f
            public i getBaseUnit() {
                return IsoFields.f29621f;
            }

            @Override // ij.f
            public long getFrom(b bVar) {
                if (bVar.isSupported(this)) {
                    return (bVar.getLong(ChronoField.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: QuarterOfYear");
            }

            @Override // ij.f
            public i getRangeUnit() {
                return ChronoUnit.YEARS;
            }

            @Override // ij.f
            public boolean isSupportedBy(b bVar) {
                return bVar.isSupported(ChronoField.MONTH_OF_YEAR) && Field.isIso(bVar);
            }

            @Override // ij.f
            public ValueRange range() {
                return ValueRange.of(1L, 4L);
            }

            @Override // ij.f
            public ValueRange rangeRefinedBy(b bVar) {
                return range();
            }

            @Override // java.lang.Enum
            public String toString() {
                return "QuarterOfYear";
            }
        }

        /* renamed from: org.threeten.bp.temporal.IsoFields$Field$3 */
        public enum AnonymousClass3 extends Field {
            @Override // ij.f
            public <R extends ij.a> R adjustInto(R r10, long j10) {
                range().checkValidValue(j10, this);
                return (R) r10.plus(d.q(j10, getFrom(r10)), ChronoUnit.WEEKS);
            }

            @Override // ij.f
            public i getBaseUnit() {
                return ChronoUnit.WEEKS;
            }

            @Override // org.threeten.bp.temporal.IsoFields.Field, ij.f
            public String getDisplayName(Locale locale) {
                d.j(locale, "locale");
                return "Week";
            }

            @Override // ij.f
            public long getFrom(b bVar) {
                if (bVar.isSupported(this)) {
                    return Field.getWeek(LocalDate.from(bVar));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // ij.f
            public i getRangeUnit() {
                return IsoFields.f29620e;
            }

            @Override // ij.f
            public boolean isSupportedBy(b bVar) {
                return bVar.isSupported(ChronoField.EPOCH_DAY) && Field.isIso(bVar);
            }

            @Override // ij.f
            public ValueRange range() {
                return ValueRange.of(1L, 52L, 53L);
            }

            @Override // ij.f
            public ValueRange rangeRefinedBy(b bVar) {
                if (bVar.isSupported(this)) {
                    return Field.getWeekRange(LocalDate.from(bVar));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // org.threeten.bp.temporal.IsoFields.Field, ij.f
            public b resolve(Map<f, Long> map, b bVar, ResolverStyle resolverStyle) {
                f fVar;
                LocalDate with;
                long j10;
                f fVar2 = Field.WEEK_BASED_YEAR;
                Long l10 = map.get(fVar2);
                ChronoField chronoField = ChronoField.DAY_OF_WEEK;
                Long l11 = map.get(chronoField);
                if (l10 == null || l11 == null) {
                    return null;
                }
                int checkValidIntValue = fVar2.range().checkValidIntValue(l10.longValue(), fVar2);
                long longValue = map.get(Field.WEEK_OF_WEEK_BASED_YEAR).longValue();
                if (resolverStyle == ResolverStyle.LENIENT) {
                    long longValue2 = l11.longValue();
                    if (longValue2 > 7) {
                        long j11 = longValue2 - 1;
                        j10 = j11 / 7;
                        longValue2 = (j11 % 7) + 1;
                    } else if (longValue2 < 1) {
                        j10 = (longValue2 / 7) - 1;
                        longValue2 = (longValue2 % 7) + 7;
                    } else {
                        j10 = 0;
                    }
                    fVar = fVar2;
                    with = LocalDate.of(checkValidIntValue, 1, 4).plusWeeks(longValue - 1).plusWeeks(j10).with((f) chronoField, longValue2);
                } else {
                    fVar = fVar2;
                    int checkValidIntValue2 = chronoField.checkValidIntValue(l11.longValue());
                    if (resolverStyle == ResolverStyle.STRICT) {
                        Field.getWeekRange(LocalDate.of(checkValidIntValue, 1, 4)).checkValidValue(longValue, this);
                    } else {
                        range().checkValidValue(longValue, this);
                    }
                    with = LocalDate.of(checkValidIntValue, 1, 4).plusWeeks(longValue - 1).with((f) chronoField, checkValidIntValue2);
                }
                map.remove(this);
                map.remove(fVar);
                map.remove(chronoField);
                return with;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "WeekOfWeekBasedYear";
            }
        }

        /* renamed from: org.threeten.bp.temporal.IsoFields$Field$4 */
        public enum AnonymousClass4 extends Field {
            @Override // ij.f
            public <R extends ij.a> R adjustInto(R r10, long j10) {
                if (!isSupportedBy(r10)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
                }
                int checkValidIntValue = range().checkValidIntValue(j10, Field.WEEK_BASED_YEAR);
                LocalDate from = LocalDate.from((b) r10);
                int i10 = from.get(ChronoField.DAY_OF_WEEK);
                int week = Field.getWeek(from);
                if (week == 53 && Field.getWeekRange(checkValidIntValue) == 52) {
                    week = 52;
                }
                return (R) r10.with(LocalDate.of(checkValidIntValue, 1, 4).plusDays((i10 - r6.get(r0)) + ((week - 1) * 7)));
            }

            @Override // ij.f
            public i getBaseUnit() {
                return IsoFields.f29620e;
            }

            @Override // ij.f
            public long getFrom(b bVar) {
                if (bVar.isSupported(this)) {
                    return Field.getWeekBasedYear(LocalDate.from(bVar));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
            }

            @Override // ij.f
            public i getRangeUnit() {
                return ChronoUnit.FOREVER;
            }

            @Override // ij.f
            public boolean isSupportedBy(b bVar) {
                return bVar.isSupported(ChronoField.EPOCH_DAY) && Field.isIso(bVar);
            }

            @Override // ij.f
            public ValueRange range() {
                return ChronoField.YEAR.range();
            }

            @Override // ij.f
            public ValueRange rangeRefinedBy(b bVar) {
                return ChronoField.YEAR.range();
            }

            @Override // java.lang.Enum
            public String toString() {
                return "WeekBasedYear";
            }
        }

        public static int getWeek(LocalDate localDate) {
            int ordinal = localDate.getDayOfWeek().ordinal();
            int dayOfYear = localDate.getDayOfYear() - 1;
            int i10 = (3 - ordinal) + dayOfYear;
            int i11 = i10 - ((i10 / 7) * 7);
            int i12 = i11 - 3;
            if (i12 < -3) {
                i12 = i11 + 4;
            }
            if (dayOfYear < i12) {
                return (int) getWeekRange(localDate.withDayOfYear(TinkerReport.KEY_APPLIED_VERSION_CHECK).minusYears(1L)).getMaximum();
            }
            int i13 = ((dayOfYear - i12) / 7) + 1;
            if (i13 != 53 || i12 == -3 || (i12 == -2 && localDate.isLeapYear())) {
                return i13;
            }
            return 1;
        }

        public static int getWeekBasedYear(LocalDate localDate) {
            int year = localDate.getYear();
            int dayOfYear = localDate.getDayOfYear();
            if (dayOfYear <= 3) {
                return dayOfYear - localDate.getDayOfWeek().ordinal() < -2 ? year - 1 : year;
            }
            if (dayOfYear >= 363) {
                return ((dayOfYear - 363) - (localDate.isLeapYear() ? 1 : 0)) - localDate.getDayOfWeek().ordinal() >= 0 ? year + 1 : year;
            }
            return year;
        }

        public static ValueRange getWeekRange(LocalDate localDate) {
            return ValueRange.of(1L, getWeekRange(getWeekBasedYear(localDate)));
        }

        public static boolean isIso(b bVar) {
            return org.threeten.bp.chrono.b.from(bVar).equals(IsoChronology.INSTANCE);
        }

        @Override // ij.f
        public String getDisplayName(Locale locale) {
            d.j(locale, "locale");
            return toString();
        }

        @Override // ij.f
        public boolean isDateBased() {
            return true;
        }

        @Override // ij.f
        public boolean isTimeBased() {
            return false;
        }

        @Override // ij.f
        public b resolve(Map<f, Long> map, b bVar, ResolverStyle resolverStyle) {
            return null;
        }

        /* synthetic */ Field(a aVar) {
            this();
        }

        public static int getWeekRange(int i10) {
            LocalDate of2 = LocalDate.of(i10, 1, 1);
            if (of2.getDayOfWeek() != DayOfWeek.THURSDAY) {
                return (of2.getDayOfWeek() == DayOfWeek.WEDNESDAY && of2.isLeapYear()) ? 53 : 52;
            }
            return 53;
        }
    }

    public enum Unit implements i {
        WEEK_BASED_YEARS("WeekBasedYears", Duration.ofSeconds(31556952)),
        QUARTER_YEARS("QuarterYears", Duration.ofSeconds(7889238));

        private final Duration duration;
        private final String name;

        Unit(String str, Duration duration) {
            this.name = str;
            this.duration = duration;
        }

        @Override // ij.i
        public <R extends ij.a> R addTo(R r10, long j10) {
            int i10 = a.f29622a[ordinal()];
            if (i10 == 1) {
                return (R) r10.with(IsoFields.f29619d, d.l(r10.get(r0), j10));
            }
            if (i10 == 2) {
                return (R) r10.plus(j10 / 256, ChronoUnit.YEARS).plus((j10 % 256) * 3, ChronoUnit.MONTHS);
            }
            throw new IllegalStateException("Unreachable");
        }

        @Override // ij.i
        public long between(ij.a aVar, ij.a aVar2) {
            int i10 = a.f29622a[ordinal()];
            if (i10 == 1) {
                f fVar = IsoFields.f29619d;
                return d.q(aVar2.getLong(fVar), aVar.getLong(fVar));
            }
            if (i10 == 2) {
                return aVar.until(aVar2, ChronoUnit.MONTHS) / 3;
            }
            throw new IllegalStateException("Unreachable");
        }

        @Override // ij.i
        public Duration getDuration() {
            return this.duration;
        }

        @Override // ij.i
        public boolean isDateBased() {
            return true;
        }

        @Override // ij.i
        public boolean isDurationEstimated() {
            return true;
        }

        @Override // ij.i
        public boolean isSupportedBy(ij.a aVar) {
            return aVar.isSupported(ChronoField.EPOCH_DAY);
        }

        @Override // ij.i
        public boolean isTimeBased() {
            return false;
        }

        @Override // java.lang.Enum, ij.i
        public String toString() {
            return this.name;
        }
    }

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f29622a;

        static {
            int[] iArr = new int[Unit.values().length];
            f29622a = iArr;
            try {
                iArr[Unit.WEEK_BASED_YEARS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29622a[Unit.QUARTER_YEARS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public IsoFields() {
        throw new AssertionError("Not instantiable");
    }
}
