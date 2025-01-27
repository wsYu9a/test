package org.threeten.bp.chrono;

import androidx.exifinterface.media.ExifInterface;
import fj.e;
import hj.d;
import ij.f;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.Month;
import org.threeten.bp.Year;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes4.dex */
public final class IsoChronology extends b implements Serializable {
    public static final IsoChronology INSTANCE = new IsoChronology();
    private static final long serialVersionUID = -1440403870442975015L;

    private IsoChronology() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.threeten.bp.chrono.b
    public List<e> eras() {
        return Arrays.asList(IsoEra.values());
    }

    @Override // org.threeten.bp.chrono.b
    public String getCalendarType() {
        return "iso8601";
    }

    @Override // org.threeten.bp.chrono.b
    public String getId() {
        return ExifInterface.TAG_RW2_ISO;
    }

    @Override // org.threeten.bp.chrono.b
    public boolean isLeapYear(long j10) {
        return (3 & j10) == 0 && (j10 % 100 != 0 || j10 % 400 == 0);
    }

    @Override // org.threeten.bp.chrono.b
    public int prolepticYear(e eVar, int i10) {
        if (eVar instanceof IsoEra) {
            return eVar == IsoEra.CE ? i10 : 1 - i10;
        }
        throw new ClassCastException("Era must be IsoEra");
    }

    @Override // org.threeten.bp.chrono.b
    public ValueRange range(ChronoField chronoField) {
        return chronoField.range();
    }

    @Override // org.threeten.bp.chrono.b
    public /* bridge */ /* synthetic */ a resolveDate(Map map, ResolverStyle resolverStyle) {
        return resolveDate((Map<f, Long>) map, resolverStyle);
    }

    @Override // org.threeten.bp.chrono.b
    public LocalDate dateEpochDay(long j10) {
        return LocalDate.ofEpochDay(j10);
    }

    @Override // org.threeten.bp.chrono.b
    public IsoEra eraOf(int i10) {
        return IsoEra.of(i10);
    }

    @Override // org.threeten.bp.chrono.b
    public LocalDateTime localDateTime(ij.b bVar) {
        return LocalDateTime.from(bVar);
    }

    @Override // org.threeten.bp.chrono.b
    public LocalDate resolveDate(Map<f, Long> map, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.EPOCH_DAY;
        if (map.containsKey(chronoField)) {
            return LocalDate.ofEpochDay(map.remove(chronoField).longValue());
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
                    updateResolveMap(map, chronoField4, (l10 == null || l10.longValue() > 0) ? remove2.longValue() : d.q(1L, remove2.longValue()));
                } else if (l10 != null) {
                    updateResolveMap(map, chronoField4, l10.longValue() > 0 ? remove2.longValue() : d.q(1L, remove2.longValue()));
                } else {
                    map.put(chronoField3, remove2);
                }
            } else if (remove3.longValue() == 1) {
                updateResolveMap(map, ChronoField.YEAR, remove2.longValue());
            } else {
                if (remove3.longValue() != 0) {
                    throw new DateTimeException("Invalid value for era: " + remove3);
                }
                updateResolveMap(map, ChronoField.YEAR, d.q(1L, remove2.longValue()));
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
                int r10 = d.r(map.remove(chronoField7).longValue());
                int r11 = d.r(map.remove(chronoField8).longValue());
                if (resolverStyle == ResolverStyle.LENIENT) {
                    return LocalDate.of(checkValidIntValue, 1, 1).plusMonths(d.p(r10, 1)).plusDays(d.p(r11, 1));
                }
                if (resolverStyle != ResolverStyle.SMART) {
                    return LocalDate.of(checkValidIntValue, r10, r11);
                }
                chronoField8.checkValidValue(r11);
                if (r10 == 4 || r10 == 6 || r10 == 9 || r10 == 11) {
                    r11 = Math.min(r11, 30);
                } else if (r10 == 2) {
                    r11 = Math.min(r11, Month.FEBRUARY.length(Year.isLeap(checkValidIntValue)));
                }
                return LocalDate.of(checkValidIntValue, r10, r11);
            }
            ChronoField chronoField9 = ChronoField.ALIGNED_WEEK_OF_MONTH;
            if (map.containsKey(chronoField9)) {
                ChronoField chronoField10 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                if (map.containsKey(chronoField10)) {
                    int checkValidIntValue2 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return LocalDate.of(checkValidIntValue2, 1, 1).plusMonths(d.q(map.remove(chronoField7).longValue(), 1L)).plusWeeks(d.q(map.remove(chronoField9).longValue(), 1L)).plusDays(d.q(map.remove(chronoField10).longValue(), 1L));
                    }
                    int checkValidIntValue3 = chronoField7.checkValidIntValue(map.remove(chronoField7).longValue());
                    LocalDate plusDays = LocalDate.of(checkValidIntValue2, checkValidIntValue3, 1).plusDays(((chronoField9.checkValidIntValue(map.remove(chronoField9).longValue()) - 1) * 7) + (chronoField10.checkValidIntValue(map.remove(chronoField10).longValue()) - 1));
                    if (resolverStyle != ResolverStyle.STRICT || plusDays.get(chronoField7) == checkValidIntValue3) {
                        return plusDays;
                    }
                    throw new DateTimeException("Strict mode rejected date parsed to a different month");
                }
                ChronoField chronoField11 = ChronoField.DAY_OF_WEEK;
                if (map.containsKey(chronoField11)) {
                    int checkValidIntValue4 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return LocalDate.of(checkValidIntValue4, 1, 1).plusMonths(d.q(map.remove(chronoField7).longValue(), 1L)).plusWeeks(d.q(map.remove(chronoField9).longValue(), 1L)).plusDays(d.q(map.remove(chronoField11).longValue(), 1L));
                    }
                    int checkValidIntValue5 = chronoField7.checkValidIntValue(map.remove(chronoField7).longValue());
                    LocalDate with = LocalDate.of(checkValidIntValue4, checkValidIntValue5, 1).plusWeeks(chronoField9.checkValidIntValue(map.remove(chronoField9).longValue()) - 1).with(ij.d.k(DayOfWeek.of(chronoField11.checkValidIntValue(map.remove(chronoField11).longValue()))));
                    if (resolverStyle != ResolverStyle.STRICT || with.get(chronoField7) == checkValidIntValue5) {
                        return with;
                    }
                    throw new DateTimeException("Strict mode rejected date parsed to a different month");
                }
            }
        }
        ChronoField chronoField12 = ChronoField.DAY_OF_YEAR;
        if (map.containsKey(chronoField12)) {
            int checkValidIntValue6 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
            if (resolverStyle == ResolverStyle.LENIENT) {
                return LocalDate.ofYearDay(checkValidIntValue6, 1).plusDays(d.q(map.remove(chronoField12).longValue(), 1L));
            }
            return LocalDate.ofYearDay(checkValidIntValue6, chronoField12.checkValidIntValue(map.remove(chronoField12).longValue()));
        }
        ChronoField chronoField13 = ChronoField.ALIGNED_WEEK_OF_YEAR;
        if (!map.containsKey(chronoField13)) {
            return null;
        }
        ChronoField chronoField14 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR;
        if (map.containsKey(chronoField14)) {
            int checkValidIntValue7 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
            if (resolverStyle == ResolverStyle.LENIENT) {
                return LocalDate.of(checkValidIntValue7, 1, 1).plusWeeks(d.q(map.remove(chronoField13).longValue(), 1L)).plusDays(d.q(map.remove(chronoField14).longValue(), 1L));
            }
            LocalDate plusDays2 = LocalDate.of(checkValidIntValue7, 1, 1).plusDays(((chronoField13.checkValidIntValue(map.remove(chronoField13).longValue()) - 1) * 7) + (chronoField14.checkValidIntValue(map.remove(chronoField14).longValue()) - 1));
            if (resolverStyle != ResolverStyle.STRICT || plusDays2.get(chronoField6) == checkValidIntValue7) {
                return plusDays2;
            }
            throw new DateTimeException("Strict mode rejected date parsed to a different year");
        }
        ChronoField chronoField15 = ChronoField.DAY_OF_WEEK;
        if (!map.containsKey(chronoField15)) {
            return null;
        }
        int checkValidIntValue8 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
        if (resolverStyle == ResolverStyle.LENIENT) {
            return LocalDate.of(checkValidIntValue8, 1, 1).plusWeeks(d.q(map.remove(chronoField13).longValue(), 1L)).plusDays(d.q(map.remove(chronoField15).longValue(), 1L));
        }
        LocalDate with2 = LocalDate.of(checkValidIntValue8, 1, 1).plusWeeks(chronoField13.checkValidIntValue(map.remove(chronoField13).longValue()) - 1).with(ij.d.k(DayOfWeek.of(chronoField15.checkValidIntValue(map.remove(chronoField15).longValue()))));
        if (resolverStyle != ResolverStyle.STRICT || with2.get(chronoField6) == checkValidIntValue8) {
            return with2;
        }
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    }

    @Override // org.threeten.bp.chrono.b
    public LocalDate dateYearDay(e eVar, int i10, int i11) {
        return dateYearDay(prolepticYear(eVar, i10), i11);
    }

    @Override // org.threeten.bp.chrono.b
    public ZonedDateTime zonedDateTime(ij.b bVar) {
        return ZonedDateTime.from(bVar);
    }

    @Override // org.threeten.bp.chrono.b
    public LocalDate date(e eVar, int i10, int i11, int i12) {
        return date(prolepticYear(eVar, i10), i11, i12);
    }

    @Override // org.threeten.bp.chrono.b
    public LocalDate dateNow() {
        return dateNow(Clock.systemDefaultZone());
    }

    @Override // org.threeten.bp.chrono.b
    public LocalDate dateYearDay(int i10, int i11) {
        return LocalDate.ofYearDay(i10, i11);
    }

    @Override // org.threeten.bp.chrono.b
    public ZonedDateTime zonedDateTime(Instant instant, ZoneId zoneId) {
        return ZonedDateTime.ofInstant(instant, zoneId);
    }

    @Override // org.threeten.bp.chrono.b
    public LocalDate date(int i10, int i11, int i12) {
        return LocalDate.of(i10, i11, i12);
    }

    @Override // org.threeten.bp.chrono.b
    public LocalDate dateNow(ZoneId zoneId) {
        return dateNow(Clock.system(zoneId));
    }

    @Override // org.threeten.bp.chrono.b
    public LocalDate date(ij.b bVar) {
        return LocalDate.from(bVar);
    }

    @Override // org.threeten.bp.chrono.b
    public LocalDate dateNow(Clock clock) {
        d.j(clock, "clock");
        return date((ij.b) LocalDate.now(clock));
    }
}
