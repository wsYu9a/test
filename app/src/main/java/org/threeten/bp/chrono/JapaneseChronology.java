package org.threeten.bp.chrono;

import androidx.exifinterface.media.ExifInterface;
import fj.e;
import hj.d;
import ij.f;
import ij.i;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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
public final class JapaneseChronology extends b implements Serializable {
    private static final Map<String, String[]> ERA_FULL_NAMES;
    private static final Map<String, String[]> ERA_NARROW_NAMES;
    private static final Map<String, String[]> ERA_SHORT_NAMES;
    private static final String FALLBACK_LANGUAGE = "en";
    private static final long serialVersionUID = 459996390165777884L;
    private static final String TARGET_LANGUAGE = "ja";
    static final Locale LOCALE = new Locale(TARGET_LANGUAGE, "JP", "JP");
    public static final JapaneseChronology INSTANCE = new JapaneseChronology();

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f29504a;

        static {
            int[] iArr = new int[ChronoField.values().length];
            f29504a = iArr;
            try {
                iArr[ChronoField.DAY_OF_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29504a[ChronoField.DAY_OF_WEEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29504a[ChronoField.MICRO_OF_DAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29504a[ChronoField.MICRO_OF_SECOND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f29504a[ChronoField.HOUR_OF_DAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f29504a[ChronoField.HOUR_OF_AMPM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f29504a[ChronoField.MINUTE_OF_DAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f29504a[ChronoField.MINUTE_OF_HOUR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f29504a[ChronoField.SECOND_OF_DAY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f29504a[ChronoField.SECOND_OF_MINUTE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f29504a[ChronoField.MILLI_OF_DAY.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f29504a[ChronoField.MILLI_OF_SECOND.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f29504a[ChronoField.NANO_OF_DAY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f29504a[ChronoField.NANO_OF_SECOND.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f29504a[ChronoField.CLOCK_HOUR_OF_DAY.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f29504a[ChronoField.CLOCK_HOUR_OF_AMPM.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f29504a[ChronoField.EPOCH_DAY.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f29504a[ChronoField.PROLEPTIC_MONTH.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f29504a[ChronoField.ERA.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f29504a[ChronoField.YEAR.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f29504a[ChronoField.YEAR_OF_ERA.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f29504a[ChronoField.MONTH_OF_YEAR.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f29504a[ChronoField.DAY_OF_YEAR.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        ERA_NARROW_NAMES = hashMap;
        HashMap hashMap2 = new HashMap();
        ERA_SHORT_NAMES = hashMap2;
        HashMap hashMap3 = new HashMap();
        ERA_FULL_NAMES = hashMap3;
        hashMap.put("en", new String[]{"Unknown", "K", "M", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH, "H"});
        hashMap.put(TARGET_LANGUAGE, new String[]{"Unknown", "K", "M", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH, "H"});
        hashMap2.put("en", new String[]{"Unknown", "K", "M", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH, "H"});
        hashMap2.put(TARGET_LANGUAGE, new String[]{"Unknown", "慶", "明", "大", "昭", "平"});
        hashMap3.put("en", new String[]{"Unknown", "Keio", "Meiji", "Taisho", "Showa", "Heisei"});
        hashMap3.put(TARGET_LANGUAGE, new String[]{"Unknown", "慶応", "明治", "大正", "昭和", "平成"});
    }

    private JapaneseChronology() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    private JapaneseDate resolveEYD(Map<f, Long> map, ResolverStyle resolverStyle, JapaneseEra japaneseEra, int i10) {
        if (resolverStyle != ResolverStyle.LENIENT) {
            ChronoField chronoField = ChronoField.DAY_OF_YEAR;
            return dateYearDay((e) japaneseEra, i10, range(chronoField).checkValidIntValue(map.remove(chronoField).longValue(), chronoField));
        }
        int year = (japaneseEra.startDate().getYear() + i10) - 1;
        return dateYearDay(year, 1).plus(d.q(map.remove(ChronoField.DAY_OF_YEAR).longValue(), 1L), (i) ChronoUnit.DAYS);
    }

    private JapaneseDate resolveEYMD(Map<f, Long> map, ResolverStyle resolverStyle, JapaneseEra japaneseEra, int i10) {
        if (resolverStyle == ResolverStyle.LENIENT) {
            int year = (japaneseEra.startDate().getYear() + i10) - 1;
            return date(year, 1, 1).plus(d.q(map.remove(ChronoField.MONTH_OF_YEAR).longValue(), 1L), (i) ChronoUnit.MONTHS).plus(d.q(map.remove(ChronoField.DAY_OF_MONTH).longValue(), 1L), (i) ChronoUnit.DAYS);
        }
        ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
        int checkValidIntValue = range(chronoField).checkValidIntValue(map.remove(chronoField).longValue(), chronoField);
        ChronoField chronoField2 = ChronoField.DAY_OF_MONTH;
        int checkValidIntValue2 = range(chronoField2).checkValidIntValue(map.remove(chronoField2).longValue(), chronoField2);
        if (resolverStyle != ResolverStyle.SMART) {
            return date((e) japaneseEra, i10, checkValidIntValue, checkValidIntValue2);
        }
        if (i10 < 1) {
            throw new DateTimeException("Invalid YearOfEra: " + i10);
        }
        int year2 = (japaneseEra.startDate().getYear() + i10) - 1;
        if (checkValidIntValue2 > 28) {
            checkValidIntValue2 = Math.min(checkValidIntValue2, date(year2, checkValidIntValue, 1).lengthOfMonth());
        }
        JapaneseDate date = date(year2, checkValidIntValue, checkValidIntValue2);
        if (date.getEra() != japaneseEra) {
            if (Math.abs(date.getEra().getValue() - japaneseEra.getValue()) > 1) {
                throw new DateTimeException("Invalid Era/YearOfEra: " + japaneseEra + " " + i10);
            }
            if (date.get(ChronoField.YEAR_OF_ERA) != 1 && i10 != 1) {
                throw new DateTimeException("Invalid Era/YearOfEra: " + japaneseEra + " " + i10);
            }
        }
        return date;
    }

    @Override // org.threeten.bp.chrono.b
    public List<e> eras() {
        return Arrays.asList(JapaneseEra.values());
    }

    @Override // org.threeten.bp.chrono.b
    public String getCalendarType() {
        return "japanese";
    }

    @Override // org.threeten.bp.chrono.b
    public String getId() {
        return "Japanese";
    }

    @Override // org.threeten.bp.chrono.b
    public boolean isLeapYear(long j10) {
        return IsoChronology.INSTANCE.isLeapYear(j10);
    }

    @Override // org.threeten.bp.chrono.b
    public fj.b<JapaneseDate> localDateTime(ij.b bVar) {
        return super.localDateTime(bVar);
    }

    @Override // org.threeten.bp.chrono.b
    public int prolepticYear(e eVar, int i10) {
        if (!(eVar instanceof JapaneseEra)) {
            throw new ClassCastException("Era must be JapaneseEra");
        }
        int year = (((JapaneseEra) eVar).startDate().getYear() + i10) - 1;
        ValueRange.of(1L, (r6.endDate().getYear() - r6.startDate().getYear()) + 1).checkValidValue(i10, ChronoField.YEAR_OF_ERA);
        return year;
    }

    @Override // org.threeten.bp.chrono.b
    public ValueRange range(ChronoField chronoField) {
        int[] iArr = a.f29504a;
        switch (iArr[chronoField.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                return chronoField.range();
            default:
                Calendar calendar = Calendar.getInstance(LOCALE);
                int i10 = 0;
                switch (iArr[chronoField.ordinal()]) {
                    case 19:
                        JapaneseEra[] values = JapaneseEra.values();
                        return ValueRange.of(values[0].getValue(), values[values.length - 1].getValue());
                    case 20:
                        JapaneseEra[] values2 = JapaneseEra.values();
                        return ValueRange.of(JapaneseDate.MIN_DATE.getYear(), values2[values2.length - 1].endDate().getYear());
                    case 21:
                        JapaneseEra[] values3 = JapaneseEra.values();
                        int year = (values3[values3.length - 1].endDate().getYear() - values3[values3.length - 1].startDate().getYear()) + 1;
                        int i11 = Integer.MAX_VALUE;
                        while (i10 < values3.length) {
                            i11 = Math.min(i11, (values3[i10].endDate().getYear() - values3[i10].startDate().getYear()) + 1);
                            i10++;
                        }
                        return ValueRange.of(1L, 6L, i11, year);
                    case 22:
                        return ValueRange.of(calendar.getMinimum(2) + 1, calendar.getGreatestMinimum(2) + 1, calendar.getLeastMaximum(2) + 1, calendar.getMaximum(2) + 1);
                    case 23:
                        JapaneseEra[] values4 = JapaneseEra.values();
                        int i12 = 366;
                        while (i10 < values4.length) {
                            i12 = Math.min(i12, (values4[i10].startDate().lengthOfYear() - values4[i10].startDate().getDayOfYear()) + 1);
                            i10++;
                        }
                        return ValueRange.of(1L, i12, 366L);
                    default:
                        throw new UnsupportedOperationException("Unimplementable field: " + chronoField);
                }
        }
    }

    @Override // org.threeten.bp.chrono.b
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a resolveDate(Map map, ResolverStyle resolverStyle) {
        return resolveDate((Map<f, Long>) map, resolverStyle);
    }

    @Override // org.threeten.bp.chrono.b
    public fj.d<JapaneseDate> zonedDateTime(ij.b bVar) {
        return super.zonedDateTime(bVar);
    }

    @Override // org.threeten.bp.chrono.b
    public JapaneseDate dateEpochDay(long j10) {
        return new JapaneseDate(LocalDate.ofEpochDay(j10));
    }

    @Override // org.threeten.bp.chrono.b
    public JapaneseEra eraOf(int i10) {
        return JapaneseEra.of(i10);
    }

    /* JADX WARN: Type inference failed for: r12v17, types: [hj.c, org.threeten.bp.chrono.JapaneseDate] */
    /* JADX WARN: Type inference failed for: r12v33, types: [org.threeten.bp.chrono.JapaneseDate] */
    /* JADX WARN: Type inference failed for: r12v68, types: [org.threeten.bp.chrono.JapaneseDate] */
    @Override // org.threeten.bp.chrono.b
    public JapaneseDate resolveDate(Map<f, Long> map, ResolverStyle resolverStyle) {
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
            updateResolveMap(map, ChronoField.MONTH_OF_YEAR, d.g(remove.longValue(), 12) + 1);
            updateResolveMap(map, ChronoField.YEAR, d.e(remove.longValue(), 12L));
        }
        ChronoField chronoField3 = ChronoField.ERA;
        Long l10 = map.get(chronoField3);
        JapaneseEra eraOf = l10 != null ? eraOf(range(chronoField3).checkValidIntValue(l10.longValue(), chronoField3)) : null;
        ChronoField chronoField4 = ChronoField.YEAR_OF_ERA;
        Long l11 = map.get(chronoField4);
        if (l11 != null) {
            int checkValidIntValue = range(chronoField4).checkValidIntValue(l11.longValue(), chronoField4);
            if (eraOf == null && resolverStyle != ResolverStyle.STRICT && !map.containsKey(ChronoField.YEAR)) {
                List<e> eras = eras();
                eraOf = (JapaneseEra) eras.get(eras.size() - 1);
            }
            if (eraOf != null && map.containsKey(ChronoField.MONTH_OF_YEAR) && map.containsKey(ChronoField.DAY_OF_MONTH)) {
                map.remove(chronoField3);
                map.remove(chronoField4);
                return resolveEYMD(map, resolverStyle, eraOf, checkValidIntValue);
            }
            if (eraOf != null && map.containsKey(ChronoField.DAY_OF_YEAR)) {
                map.remove(chronoField3);
                map.remove(chronoField4);
                return resolveEYD(map, resolverStyle, eraOf, checkValidIntValue);
            }
        }
        ChronoField chronoField5 = ChronoField.YEAR;
        if (map.containsKey(chronoField5)) {
            ChronoField chronoField6 = ChronoField.MONTH_OF_YEAR;
            if (map.containsKey(chronoField6)) {
                ChronoField chronoField7 = ChronoField.DAY_OF_MONTH;
                if (map.containsKey(chronoField7)) {
                    int checkValidIntValue2 = chronoField5.checkValidIntValue(map.remove(chronoField5).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return date(checkValidIntValue2, 1, 1).plusMonths(d.q(map.remove(chronoField6).longValue(), 1L)).plusDays(d.q(map.remove(chronoField7).longValue(), 1L));
                    }
                    int checkValidIntValue3 = range(chronoField6).checkValidIntValue(map.remove(chronoField6).longValue(), chronoField6);
                    int checkValidIntValue4 = range(chronoField7).checkValidIntValue(map.remove(chronoField7).longValue(), chronoField7);
                    if (resolverStyle == ResolverStyle.SMART && checkValidIntValue4 > 28) {
                        checkValidIntValue4 = Math.min(checkValidIntValue4, date(checkValidIntValue2, checkValidIntValue3, 1).lengthOfMonth());
                    }
                    return date(checkValidIntValue2, checkValidIntValue3, checkValidIntValue4);
                }
                ChronoField chronoField8 = ChronoField.ALIGNED_WEEK_OF_MONTH;
                if (map.containsKey(chronoField8)) {
                    ChronoField chronoField9 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                    if (map.containsKey(chronoField9)) {
                        int checkValidIntValue5 = chronoField5.checkValidIntValue(map.remove(chronoField5).longValue());
                        if (resolverStyle == ResolverStyle.LENIENT) {
                            return date(checkValidIntValue5, 1, 1).plus(d.q(map.remove(chronoField6).longValue(), 1L), (i) ChronoUnit.MONTHS).plus(d.q(map.remove(chronoField8).longValue(), 1L), (i) ChronoUnit.WEEKS).plus(d.q(map.remove(chronoField9).longValue(), 1L), (i) ChronoUnit.DAYS);
                        }
                        int checkValidIntValue6 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
                        JapaneseDate plus = date(checkValidIntValue5, checkValidIntValue6, 1).plus(((chronoField8.checkValidIntValue(map.remove(chronoField8).longValue()) - 1) * 7) + (chronoField9.checkValidIntValue(map.remove(chronoField9).longValue()) - 1), (i) ChronoUnit.DAYS);
                        if (resolverStyle != ResolverStyle.STRICT || plus.get(chronoField6) == checkValidIntValue6) {
                            return plus;
                        }
                        throw new DateTimeException("Strict mode rejected date parsed to a different month");
                    }
                    ChronoField chronoField10 = ChronoField.DAY_OF_WEEK;
                    if (map.containsKey(chronoField10)) {
                        int checkValidIntValue7 = chronoField5.checkValidIntValue(map.remove(chronoField5).longValue());
                        if (resolverStyle == ResolverStyle.LENIENT) {
                            return date(checkValidIntValue7, 1, 1).plus(d.q(map.remove(chronoField6).longValue(), 1L), (i) ChronoUnit.MONTHS).plus(d.q(map.remove(chronoField8).longValue(), 1L), (i) ChronoUnit.WEEKS).plus(d.q(map.remove(chronoField10).longValue(), 1L), (i) ChronoUnit.DAYS);
                        }
                        int checkValidIntValue8 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
                        JapaneseDate with = date(checkValidIntValue7, checkValidIntValue8, 1).plus(chronoField8.checkValidIntValue(map.remove(chronoField8).longValue()) - 1, (i) ChronoUnit.WEEKS).with(ij.d.k(DayOfWeek.of(chronoField10.checkValidIntValue(map.remove(chronoField10).longValue()))));
                        if (resolverStyle != ResolverStyle.STRICT || with.get(chronoField6) == checkValidIntValue8) {
                            return with;
                        }
                        throw new DateTimeException("Strict mode rejected date parsed to a different month");
                    }
                }
            }
            ChronoField chronoField11 = ChronoField.DAY_OF_YEAR;
            if (map.containsKey(chronoField11)) {
                int checkValidIntValue9 = chronoField5.checkValidIntValue(map.remove(chronoField5).longValue());
                if (resolverStyle == ResolverStyle.LENIENT) {
                    return dateYearDay(checkValidIntValue9, 1).plusDays(d.q(map.remove(chronoField11).longValue(), 1L));
                }
                return dateYearDay(checkValidIntValue9, chronoField11.checkValidIntValue(map.remove(chronoField11).longValue()));
            }
            ChronoField chronoField12 = ChronoField.ALIGNED_WEEK_OF_YEAR;
            if (map.containsKey(chronoField12)) {
                ChronoField chronoField13 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR;
                if (map.containsKey(chronoField13)) {
                    int checkValidIntValue10 = chronoField5.checkValidIntValue(map.remove(chronoField5).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return date(checkValidIntValue10, 1, 1).plus(d.q(map.remove(chronoField12).longValue(), 1L), (i) ChronoUnit.WEEKS).plus(d.q(map.remove(chronoField13).longValue(), 1L), (i) ChronoUnit.DAYS);
                    }
                    ?? plusDays = date(checkValidIntValue10, 1, 1).plusDays(((chronoField12.checkValidIntValue(map.remove(chronoField12).longValue()) - 1) * 7) + (chronoField13.checkValidIntValue(map.remove(chronoField13).longValue()) - 1));
                    if (resolverStyle != ResolverStyle.STRICT || plusDays.get(chronoField5) == checkValidIntValue10) {
                        return plusDays;
                    }
                    throw new DateTimeException("Strict mode rejected date parsed to a different year");
                }
                ChronoField chronoField14 = ChronoField.DAY_OF_WEEK;
                if (map.containsKey(chronoField14)) {
                    int checkValidIntValue11 = chronoField5.checkValidIntValue(map.remove(chronoField5).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return date(checkValidIntValue11, 1, 1).plus(d.q(map.remove(chronoField12).longValue(), 1L), (i) ChronoUnit.WEEKS).plus(d.q(map.remove(chronoField14).longValue(), 1L), (i) ChronoUnit.DAYS);
                    }
                    JapaneseDate with2 = date(checkValidIntValue11, 1, 1).plus(chronoField12.checkValidIntValue(map.remove(chronoField12).longValue()) - 1, (i) ChronoUnit.WEEKS).with(ij.d.k(DayOfWeek.of(chronoField14.checkValidIntValue(map.remove(chronoField14).longValue()))));
                    if (resolverStyle != ResolverStyle.STRICT || with2.get(chronoField5) == checkValidIntValue11) {
                        return with2;
                    }
                    throw new DateTimeException("Strict mode rejected date parsed to a different month");
                }
            }
        }
        return null;
    }

    @Override // org.threeten.bp.chrono.b
    public fj.d<JapaneseDate> zonedDateTime(Instant instant, ZoneId zoneId) {
        return super.zonedDateTime(instant, zoneId);
    }

    @Override // org.threeten.bp.chrono.b
    public JapaneseDate dateYearDay(e eVar, int i10, int i11) {
        if (eVar instanceof JapaneseEra) {
            return JapaneseDate.ofYearDay((JapaneseEra) eVar, i10, i11);
        }
        throw new ClassCastException("Era must be JapaneseEra");
    }

    @Override // org.threeten.bp.chrono.b
    public JapaneseDate date(e eVar, int i10, int i11, int i12) {
        if (eVar instanceof JapaneseEra) {
            return JapaneseDate.of((JapaneseEra) eVar, i10, i11, i12);
        }
        throw new ClassCastException("Era must be JapaneseEra");
    }

    @Override // org.threeten.bp.chrono.b
    public JapaneseDate dateNow() {
        return (JapaneseDate) super.dateNow();
    }

    @Override // org.threeten.bp.chrono.b
    public JapaneseDate dateNow(ZoneId zoneId) {
        return (JapaneseDate) super.dateNow(zoneId);
    }

    @Override // org.threeten.bp.chrono.b
    public JapaneseDate dateNow(Clock clock) {
        d.j(clock, "clock");
        return (JapaneseDate) super.dateNow(clock);
    }

    @Override // org.threeten.bp.chrono.b
    public JapaneseDate dateYearDay(int i10, int i11) {
        LocalDate ofYearDay = LocalDate.ofYearDay(i10, i11);
        return date(i10, ofYearDay.getMonthValue(), ofYearDay.getDayOfMonth());
    }

    @Override // org.threeten.bp.chrono.b
    public JapaneseDate date(int i10, int i11, int i12) {
        return new JapaneseDate(LocalDate.of(i10, i11, i12));
    }

    @Override // org.threeten.bp.chrono.b
    public JapaneseDate date(ij.b bVar) {
        if (bVar instanceof JapaneseDate) {
            return (JapaneseDate) bVar;
        }
        return new JapaneseDate(LocalDate.from(bVar));
    }
}
