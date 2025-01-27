package org.threeten.bp.chrono;

import fj.d;
import fj.e;
import ij.f;
import ij.i;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes4.dex */
public final class ThaiBuddhistChronology extends b implements Serializable {
    public static final ThaiBuddhistChronology INSTANCE = new ThaiBuddhistChronology();
    static final int YEARS_DIFFERENCE = 543;
    private static final long serialVersionUID = 2775954514031616474L;

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f29508a;

        static {
            int[] iArr = new int[ChronoField.values().length];
            f29508a = iArr;
            try {
                iArr[ChronoField.PROLEPTIC_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29508a[ChronoField.YEAR_OF_ERA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29508a[ChronoField.YEAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private ThaiBuddhistChronology() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.threeten.bp.chrono.b
    public List<e> eras() {
        return Arrays.asList(ThaiBuddhistEra.values());
    }

    @Override // org.threeten.bp.chrono.b
    public String getCalendarType() {
        return "buddhist";
    }

    @Override // org.threeten.bp.chrono.b
    public String getId() {
        return "ThaiBuddhist";
    }

    @Override // org.threeten.bp.chrono.b
    public boolean isLeapYear(long j10) {
        return IsoChronology.INSTANCE.isLeapYear(j10 - 543);
    }

    @Override // org.threeten.bp.chrono.b
    public fj.b<ThaiBuddhistDate> localDateTime(ij.b bVar) {
        return super.localDateTime(bVar);
    }

    @Override // org.threeten.bp.chrono.b
    public int prolepticYear(e eVar, int i10) {
        if (eVar instanceof ThaiBuddhistEra) {
            return eVar == ThaiBuddhistEra.BE ? i10 : 1 - i10;
        }
        throw new ClassCastException("Era must be BuddhistEra");
    }

    @Override // org.threeten.bp.chrono.b
    public ValueRange range(ChronoField chronoField) {
        int i10 = a.f29508a[chronoField.ordinal()];
        if (i10 == 1) {
            ValueRange range = ChronoField.PROLEPTIC_MONTH.range();
            return ValueRange.of(range.getMinimum() + 6516, range.getMaximum() + 6516);
        }
        if (i10 == 2) {
            ValueRange range2 = ChronoField.YEAR.range();
            return ValueRange.of(1L, (-(range2.getMinimum() + 543)) + 1, range2.getMaximum() + 543);
        }
        if (i10 != 3) {
            return chronoField.range();
        }
        ValueRange range3 = ChronoField.YEAR.range();
        return ValueRange.of(range3.getMinimum() + 543, range3.getMaximum() + 543);
    }

    @Override // org.threeten.bp.chrono.b
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a resolveDate(Map map, ResolverStyle resolverStyle) {
        return resolveDate((Map<f, Long>) map, resolverStyle);
    }

    @Override // org.threeten.bp.chrono.b
    public d<ThaiBuddhistDate> zonedDateTime(ij.b bVar) {
        return super.zonedDateTime(bVar);
    }

    @Override // org.threeten.bp.chrono.b
    public ThaiBuddhistDate dateEpochDay(long j10) {
        return new ThaiBuddhistDate(LocalDate.ofEpochDay(j10));
    }

    @Override // org.threeten.bp.chrono.b
    public ThaiBuddhistEra eraOf(int i10) {
        return ThaiBuddhistEra.of(i10);
    }

    /* JADX WARN: Type inference failed for: r11v20, types: [hj.c, org.threeten.bp.chrono.ThaiBuddhistDate] */
    /* JADX WARN: Type inference failed for: r11v36, types: [org.threeten.bp.chrono.ThaiBuddhistDate] */
    /* JADX WARN: Type inference failed for: r11v71, types: [org.threeten.bp.chrono.ThaiBuddhistDate] */
    @Override // org.threeten.bp.chrono.b
    public ThaiBuddhistDate resolveDate(Map<f, Long> map, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.EPOCH_DAY;
        if (map.containsKey(chronoField)) {
            return dateEpochDay(map.remove(chronoField).longValue());
        }
        ChronoField chronoField2 = ChronoField.PROLEPTIC_MONTH;
        Long remove = map.remove(chronoField2);
        if (remove != null) {
            if (resolverStyle != ResolverStyle.LENIENT) {
                chronoField2.checkValidValue(remove.longValue());
            }
            updateResolveMap(map, ChronoField.MONTH_OF_YEAR, hj.d.g(remove.longValue(), 12) + 1);
            updateResolveMap(map, ChronoField.YEAR, hj.d.e(remove.longValue(), 12L));
        }
        ChronoField chronoField3 = ChronoField.YEAR_OF_ERA;
        Long remove2 = map.remove(chronoField3);
        if (remove2 != null) {
            if (resolverStyle != ResolverStyle.LENIENT) {
                chronoField3.checkValidValue(remove2.longValue());
            }
            Long remove3 = map.remove(ChronoField.ERA);
            if (remove3 == null) {
                ChronoField chronoField4 = ChronoField.YEAR;
                Long l10 = map.get(chronoField4);
                if (resolverStyle != ResolverStyle.STRICT) {
                    updateResolveMap(map, chronoField4, (l10 == null || l10.longValue() > 0) ? remove2.longValue() : hj.d.q(1L, remove2.longValue()));
                } else if (l10 != null) {
                    updateResolveMap(map, chronoField4, l10.longValue() > 0 ? remove2.longValue() : hj.d.q(1L, remove2.longValue()));
                } else {
                    map.put(chronoField3, remove2);
                }
            } else if (remove3.longValue() == 1) {
                updateResolveMap(map, ChronoField.YEAR, remove2.longValue());
            } else {
                if (remove3.longValue() != 0) {
                    throw new DateTimeException("Invalid value for era: " + remove3);
                }
                updateResolveMap(map, ChronoField.YEAR, hj.d.q(1L, remove2.longValue()));
            }
        } else {
            ChronoField chronoField5 = ChronoField.ERA;
            if (map.containsKey(chronoField5)) {
                chronoField5.checkValidValue(map.get(chronoField5).longValue());
            }
        }
        ChronoField chronoField6 = ChronoField.YEAR;
        if (!map.containsKey(chronoField6)) {
            return null;
        }
        ChronoField chronoField7 = ChronoField.MONTH_OF_YEAR;
        if (map.containsKey(chronoField7)) {
            ChronoField chronoField8 = ChronoField.DAY_OF_MONTH;
            if (map.containsKey(chronoField8)) {
                int checkValidIntValue = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
                if (resolverStyle == ResolverStyle.LENIENT) {
                    return date(checkValidIntValue, 1, 1).plusMonths(hj.d.q(map.remove(chronoField7).longValue(), 1L)).plusDays(hj.d.q(map.remove(chronoField8).longValue(), 1L));
                }
                int checkValidIntValue2 = range(chronoField7).checkValidIntValue(map.remove(chronoField7).longValue(), chronoField7);
                int checkValidIntValue3 = range(chronoField8).checkValidIntValue(map.remove(chronoField8).longValue(), chronoField8);
                if (resolverStyle == ResolverStyle.SMART && checkValidIntValue3 > 28) {
                    checkValidIntValue3 = Math.min(checkValidIntValue3, date(checkValidIntValue, checkValidIntValue2, 1).lengthOfMonth());
                }
                return date(checkValidIntValue, checkValidIntValue2, checkValidIntValue3);
            }
            ChronoField chronoField9 = ChronoField.ALIGNED_WEEK_OF_MONTH;
            if (map.containsKey(chronoField9)) {
                ChronoField chronoField10 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                if (map.containsKey(chronoField10)) {
                    int checkValidIntValue4 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return date(checkValidIntValue4, 1, 1).plus(hj.d.q(map.remove(chronoField7).longValue(), 1L), (i) ChronoUnit.MONTHS).plus(hj.d.q(map.remove(chronoField9).longValue(), 1L), (i) ChronoUnit.WEEKS).plus(hj.d.q(map.remove(chronoField10).longValue(), 1L), (i) ChronoUnit.DAYS);
                    }
                    int checkValidIntValue5 = chronoField7.checkValidIntValue(map.remove(chronoField7).longValue());
                    ThaiBuddhistDate plus = date(checkValidIntValue4, checkValidIntValue5, 1).plus(((chronoField9.checkValidIntValue(map.remove(chronoField9).longValue()) - 1) * 7) + (chronoField10.checkValidIntValue(map.remove(chronoField10).longValue()) - 1), (i) ChronoUnit.DAYS);
                    if (resolverStyle != ResolverStyle.STRICT || plus.get(chronoField7) == checkValidIntValue5) {
                        return plus;
                    }
                    throw new DateTimeException("Strict mode rejected date parsed to a different month");
                }
                ChronoField chronoField11 = ChronoField.DAY_OF_WEEK;
                if (map.containsKey(chronoField11)) {
                    int checkValidIntValue6 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return date(checkValidIntValue6, 1, 1).plus(hj.d.q(map.remove(chronoField7).longValue(), 1L), (i) ChronoUnit.MONTHS).plus(hj.d.q(map.remove(chronoField9).longValue(), 1L), (i) ChronoUnit.WEEKS).plus(hj.d.q(map.remove(chronoField11).longValue(), 1L), (i) ChronoUnit.DAYS);
                    }
                    int checkValidIntValue7 = chronoField7.checkValidIntValue(map.remove(chronoField7).longValue());
                    ThaiBuddhistDate with = date(checkValidIntValue6, checkValidIntValue7, 1).plus(chronoField9.checkValidIntValue(map.remove(chronoField9).longValue()) - 1, (i) ChronoUnit.WEEKS).with(ij.d.k(DayOfWeek.of(chronoField11.checkValidIntValue(map.remove(chronoField11).longValue()))));
                    if (resolverStyle != ResolverStyle.STRICT || with.get(chronoField7) == checkValidIntValue7) {
                        return with;
                    }
                    throw new DateTimeException("Strict mode rejected date parsed to a different month");
                }
            }
        }
        ChronoField chronoField12 = ChronoField.DAY_OF_YEAR;
        if (map.containsKey(chronoField12)) {
            int checkValidIntValue8 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
            if (resolverStyle == ResolverStyle.LENIENT) {
                return dateYearDay(checkValidIntValue8, 1).plusDays(hj.d.q(map.remove(chronoField12).longValue(), 1L));
            }
            return dateYearDay(checkValidIntValue8, chronoField12.checkValidIntValue(map.remove(chronoField12).longValue()));
        }
        ChronoField chronoField13 = ChronoField.ALIGNED_WEEK_OF_YEAR;
        if (!map.containsKey(chronoField13)) {
            return null;
        }
        ChronoField chronoField14 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR;
        if (map.containsKey(chronoField14)) {
            int checkValidIntValue9 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
            if (resolverStyle == ResolverStyle.LENIENT) {
                return date(checkValidIntValue9, 1, 1).plus(hj.d.q(map.remove(chronoField13).longValue(), 1L), (i) ChronoUnit.WEEKS).plus(hj.d.q(map.remove(chronoField14).longValue(), 1L), (i) ChronoUnit.DAYS);
            }
            ?? plusDays = date(checkValidIntValue9, 1, 1).plusDays(((chronoField13.checkValidIntValue(map.remove(chronoField13).longValue()) - 1) * 7) + (chronoField14.checkValidIntValue(map.remove(chronoField14).longValue()) - 1));
            if (resolverStyle != ResolverStyle.STRICT || plusDays.get(chronoField6) == checkValidIntValue9) {
                return plusDays;
            }
            throw new DateTimeException("Strict mode rejected date parsed to a different year");
        }
        ChronoField chronoField15 = ChronoField.DAY_OF_WEEK;
        if (!map.containsKey(chronoField15)) {
            return null;
        }
        int checkValidIntValue10 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
        if (resolverStyle == ResolverStyle.LENIENT) {
            return date(checkValidIntValue10, 1, 1).plus(hj.d.q(map.remove(chronoField13).longValue(), 1L), (i) ChronoUnit.WEEKS).plus(hj.d.q(map.remove(chronoField15).longValue(), 1L), (i) ChronoUnit.DAYS);
        }
        ThaiBuddhistDate with2 = date(checkValidIntValue10, 1, 1).plus(chronoField13.checkValidIntValue(map.remove(chronoField13).longValue()) - 1, (i) ChronoUnit.WEEKS).with(ij.d.k(DayOfWeek.of(chronoField15.checkValidIntValue(map.remove(chronoField15).longValue()))));
        if (resolverStyle != ResolverStyle.STRICT || with2.get(chronoField6) == checkValidIntValue10) {
            return with2;
        }
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    }

    @Override // org.threeten.bp.chrono.b
    public d<ThaiBuddhistDate> zonedDateTime(Instant instant, ZoneId zoneId) {
        return super.zonedDateTime(instant, zoneId);
    }

    @Override // org.threeten.bp.chrono.b
    public ThaiBuddhistDate dateYearDay(e eVar, int i10, int i11) {
        return (ThaiBuddhistDate) super.dateYearDay(eVar, i10, i11);
    }

    @Override // org.threeten.bp.chrono.b
    public ThaiBuddhistDate date(e eVar, int i10, int i11, int i12) {
        return (ThaiBuddhistDate) super.date(eVar, i10, i11, i12);
    }

    @Override // org.threeten.bp.chrono.b
    public ThaiBuddhistDate dateNow() {
        return (ThaiBuddhistDate) super.dateNow();
    }

    @Override // org.threeten.bp.chrono.b
    public ThaiBuddhistDate dateYearDay(int i10, int i11) {
        return new ThaiBuddhistDate(LocalDate.ofYearDay(i10 - 543, i11));
    }

    @Override // org.threeten.bp.chrono.b
    public ThaiBuddhistDate date(int i10, int i11, int i12) {
        return new ThaiBuddhistDate(LocalDate.of(i10 - 543, i11, i12));
    }

    @Override // org.threeten.bp.chrono.b
    public ThaiBuddhistDate dateNow(ZoneId zoneId) {
        return (ThaiBuddhistDate) super.dateNow(zoneId);
    }

    @Override // org.threeten.bp.chrono.b
    public ThaiBuddhistDate date(ij.b bVar) {
        if (bVar instanceof ThaiBuddhistDate) {
            return (ThaiBuddhistDate) bVar;
        }
        return new ThaiBuddhistDate(LocalDate.from(bVar));
    }

    @Override // org.threeten.bp.chrono.b
    public ThaiBuddhistDate dateNow(Clock clock) {
        hj.d.j(clock, "clock");
        return (ThaiBuddhistDate) super.dateNow(clock);
    }
}
