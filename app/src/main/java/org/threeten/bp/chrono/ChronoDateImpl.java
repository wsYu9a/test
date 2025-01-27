package org.threeten.bp.chrono;

import hj.d;
import ij.c;
import ij.i;
import java.io.Serializable;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.chrono.a;
import org.threeten.bp.temporal.ChronoUnit;

/* loaded from: classes4.dex */
abstract class ChronoDateImpl<D extends org.threeten.bp.chrono.a> extends org.threeten.bp.chrono.a implements ij.a, c, Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f29500a;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            f29500a = iArr;
            try {
                iArr[ChronoUnit.DAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29500a[ChronoUnit.WEEKS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29500a[ChronoUnit.MONTHS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29500a[ChronoUnit.YEARS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f29500a[ChronoUnit.DECADES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f29500a[ChronoUnit.CENTURIES.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f29500a[ChronoUnit.MILLENNIA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // org.threeten.bp.chrono.a
    public fj.b<?> atTime(LocalTime localTime) {
        return ChronoLocalDateTimeImpl.of(this, localTime);
    }

    public ChronoDateImpl<D> minusDays(long j10) {
        return j10 == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1L) : plusDays(-j10);
    }

    public ChronoDateImpl<D> minusMonths(long j10) {
        return j10 == Long.MIN_VALUE ? plusMonths(Long.MAX_VALUE).plusMonths(1L) : plusMonths(-j10);
    }

    public ChronoDateImpl<D> minusWeeks(long j10) {
        return j10 == Long.MIN_VALUE ? plusWeeks(Long.MAX_VALUE).plusWeeks(1L) : plusWeeks(-j10);
    }

    public ChronoDateImpl<D> minusYears(long j10) {
        return j10 == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1L) : plusYears(-j10);
    }

    public abstract ChronoDateImpl<D> plusDays(long j10);

    public abstract ChronoDateImpl<D> plusMonths(long j10);

    public ChronoDateImpl<D> plusWeeks(long j10) {
        return plusDays(d.n(j10, 7));
    }

    public abstract ChronoDateImpl<D> plusYears(long j10);

    @Override // ij.a
    public long until(ij.a aVar, i iVar) {
        org.threeten.bp.chrono.a date = getChronology().date(aVar);
        return iVar instanceof ChronoUnit ? LocalDate.from((ij.b) this).until(date, iVar) : iVar.between(this, date);
    }

    @Override // org.threeten.bp.chrono.a, ij.a
    public ChronoDateImpl<D> plus(long j10, i iVar) {
        if (iVar instanceof ChronoUnit) {
            switch (a.f29500a[((ChronoUnit) iVar).ordinal()]) {
                case 1:
                    return plusDays(j10);
                case 2:
                    return plusDays(d.n(j10, 7));
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
                default:
                    throw new DateTimeException(iVar + " not valid for chronology " + getChronology().getId());
            }
        }
        return (ChronoDateImpl) getChronology().ensureChronoLocalDate(iVar.addTo(this, j10));
    }

    @Override // org.threeten.bp.chrono.a
    public fj.c until(org.threeten.bp.chrono.a aVar) {
        throw new UnsupportedOperationException("Not supported in ThreeTen backport");
    }
}
