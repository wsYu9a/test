package org.threeten.bp;

import com.qq.e.comm.adevent.AdEventType;
import com.tencent.bugly.beta.tinker.TinkerReport;
import ij.c;
import ij.f;
import ij.h;
import java.util.Locale;
import org.mozilla.universalchardet.prober.g;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes4.dex */
public enum Month implements ij.b, c {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    public static final h<Month> FROM = new h<Month>() { // from class: org.threeten.bp.Month.a
        @Override // ij.h
        /* renamed from: b */
        public Month a(ij.b bVar) {
            return Month.from(bVar);
        }
    };
    private static final Month[] ENUMS = values();

    public class a implements h<Month> {
        @Override // ij.h
        /* renamed from: b */
        public Month a(ij.b bVar) {
            return Month.from(bVar);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f29488a;

        static {
            int[] iArr = new int[Month.values().length];
            f29488a = iArr;
            try {
                iArr[Month.FEBRUARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29488a[Month.APRIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29488a[Month.JUNE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29488a[Month.SEPTEMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f29488a[Month.NOVEMBER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f29488a[Month.JANUARY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f29488a[Month.MARCH.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f29488a[Month.MAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f29488a[Month.JULY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f29488a[Month.AUGUST.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f29488a[Month.OCTOBER.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f29488a[Month.DECEMBER.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public static Month from(ij.b bVar) {
        if (bVar instanceof Month) {
            return (Month) bVar;
        }
        try {
            if (!IsoChronology.INSTANCE.equals(org.threeten.bp.chrono.b.from(bVar))) {
                bVar = LocalDate.from(bVar);
            }
            return of(bVar.get(ChronoField.MONTH_OF_YEAR));
        } catch (DateTimeException e10) {
            throw new DateTimeException("Unable to obtain Month from TemporalAccessor: " + bVar + ", type " + bVar.getClass().getName(), e10);
        }
    }

    public static Month of(int i10) {
        if (i10 >= 1 && i10 <= 12) {
            return ENUMS[i10 - 1];
        }
        throw new DateTimeException("Invalid value for MonthOfYear: " + i10);
    }

    @Override // ij.c
    public ij.a adjustInto(ij.a aVar) {
        if (org.threeten.bp.chrono.b.from(aVar).equals(IsoChronology.INSTANCE)) {
            return aVar.with(ChronoField.MONTH_OF_YEAR, getValue());
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public int firstDayOfYear(boolean z10) {
        switch (b.f29488a[ordinal()]) {
            case 1:
                return 32;
            case 2:
                return (z10 ? 1 : 0) + 91;
            case 3:
                return (z10 ? 1 : 0) + 152;
            case 4:
                return (z10 ? 1 : 0) + g.f29296w;
            case 5:
                return (z10 ? 1 : 0) + 305;
            case 6:
                return 1;
            case 7:
                return (z10 ? 1 : 0) + 60;
            case 8:
                return (z10 ? 1 : 0) + 121;
            case 9:
                return (z10 ? 1 : 0) + TinkerReport.KEY_APPLIED_DEX_EXTRACT;
            case 10:
                return (z10 ? 1 : 0) + AdEventType.VIDEO_PRELOAD_ERROR;
            case 11:
                return (z10 ? 1 : 0) + 274;
            default:
                return (z10 ? 1 : 0) + 335;
        }
    }

    public Month firstMonthOfQuarter() {
        return ENUMS[(ordinal() / 3) * 3];
    }

    @Override // ij.b
    public int get(f fVar) {
        return fVar == ChronoField.MONTH_OF_YEAR ? getValue() : range(fVar).checkValidIntValue(getLong(fVar), fVar);
    }

    public String getDisplayName(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().r(ChronoField.MONTH_OF_YEAR, textStyle).Q(locale).d(this);
    }

    @Override // ij.b
    public long getLong(f fVar) {
        if (fVar == ChronoField.MONTH_OF_YEAR) {
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
        return fVar instanceof ChronoField ? fVar == ChronoField.MONTH_OF_YEAR : fVar != null && fVar.isSupportedBy(this);
    }

    public int length(boolean z10) {
        int i10 = b.f29488a[ordinal()];
        return i10 != 1 ? (i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5) ? 30 : 31 : z10 ? 29 : 28;
    }

    public int maxLength() {
        int i10 = b.f29488a[ordinal()];
        if (i10 != 1) {
            return (i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5) ? 30 : 31;
        }
        return 29;
    }

    public int minLength() {
        int i10 = b.f29488a[ordinal()];
        if (i10 != 1) {
            return (i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5) ? 30 : 31;
        }
        return 28;
    }

    public Month minus(long j10) {
        return plus(-(j10 % 12));
    }

    public Month plus(long j10) {
        return ENUMS[(ordinal() + (((int) (j10 % 12)) + 12)) % 12];
    }

    @Override // ij.b
    public <R> R query(h<R> hVar) {
        if (hVar == ij.g.a()) {
            return (R) IsoChronology.INSTANCE;
        }
        if (hVar == ij.g.e()) {
            return (R) ChronoUnit.MONTHS;
        }
        if (hVar == ij.g.b() || hVar == ij.g.c() || hVar == ij.g.f() || hVar == ij.g.g() || hVar == ij.g.d()) {
            return null;
        }
        return hVar.a(this);
    }

    @Override // ij.b
    public ValueRange range(f fVar) {
        if (fVar == ChronoField.MONTH_OF_YEAR) {
            return fVar.range();
        }
        if (!(fVar instanceof ChronoField)) {
            return fVar.rangeRefinedBy(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
    }
}
