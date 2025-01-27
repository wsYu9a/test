package org.threeten.bp.chrono;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.tencent.bugly.beta.tinker.TinkerReport;
import fj.c;
import hj.d;
import ij.e;
import ij.f;
import ij.i;
import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.ParseException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes4.dex */
public final class HijrahDate extends ChronoDateImpl<HijrahDate> implements Serializable {
    private static final Long[] ADJUSTED_CYCLES;
    private static final HashMap<Integer, Integer[]> ADJUSTED_CYCLE_YEARS;
    private static final Integer[] ADJUSTED_LEAST_MAX_VALUES;
    private static final Integer[] ADJUSTED_MAX_VALUES;
    private static final Integer[] ADJUSTED_MIN_VALUES;
    private static final HashMap<Integer, Integer[]> ADJUSTED_MONTH_DAYS;
    private static final HashMap<Integer, Integer[]> ADJUSTED_MONTH_LENGTHS;
    private static final int[] CYCLEYEAR_START_DATE;
    private static final String DEFAULT_CONFIG_FILENAME = "hijrah_deviation.cfg";
    private static final String DEFAULT_CONFIG_PATH;
    private static final Integer[] DEFAULT_CYCLE_YEARS;
    private static final Integer[] DEFAULT_LEAP_MONTH_DAYS;
    private static final Integer[] DEFAULT_LEAP_MONTH_LENGTHS;
    private static final Integer[] DEFAULT_MONTH_DAYS;
    private static final Integer[] DEFAULT_MONTH_LENGTHS;
    private static final char FILE_SEP;
    private static final int HIJRAH_JAN_1_1_GREGORIAN_DAY = -492148;
    private static final int[] LEAP_MONTH_LENGTH;
    private static final int[] LEAP_NUM_DAYS;
    private static final int[] LEAST_MAX_VALUES;
    private static final int MAX_ADJUSTED_CYCLE = 334;
    private static final int[] MAX_VALUES;
    public static final int MAX_VALUE_OF_ERA = 9999;
    private static final int[] MIN_VALUES;
    public static final int MIN_VALUE_OF_ERA = 1;
    private static final int[] MONTH_LENGTH;
    private static final int[] NUM_DAYS;
    private static final String PATH_SEP;
    private static final int POSITION_DAY_OF_MONTH = 5;
    private static final int POSITION_DAY_OF_YEAR = 6;
    private static final long serialVersionUID = -5207853542612002020L;
    private final transient int dayOfMonth;
    private final transient DayOfWeek dayOfWeek;
    private final transient int dayOfYear;
    private final transient HijrahEra era;
    private final long gregorianEpochDay;
    private final transient boolean isLeapYear;
    private final transient int monthOfYear;
    private final transient int yearOfEra;

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f29503a;

        static {
            int[] iArr = new int[ChronoField.values().length];
            f29503a = iArr;
            try {
                iArr[ChronoField.DAY_OF_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29503a[ChronoField.DAY_OF_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29503a[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29503a[ChronoField.YEAR_OF_ERA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f29503a[ChronoField.DAY_OF_WEEK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f29503a[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f29503a[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f29503a[ChronoField.EPOCH_DAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f29503a[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f29503a[ChronoField.MONTH_OF_YEAR.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f29503a[ChronoField.YEAR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f29503a[ChronoField.ERA.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static {
        int i10 = 0;
        int[] iArr = {0, 30, 59, 89, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_START_TOAST, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NEED_INDEPENDENT_PROCESS, 177, 207, 236, 266, 295, 325};
        NUM_DAYS = iArr;
        LEAP_NUM_DAYS = new int[]{0, 30, 59, 89, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_START_TOAST, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NEED_INDEPENDENT_PROCESS, 177, 207, 236, 266, 295, 325};
        MONTH_LENGTH = new int[]{30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29};
        LEAP_MONTH_LENGTH = new int[]{30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 30};
        MIN_VALUES = new int[]{0, 1, 0, 1, 0, 1, 1};
        LEAST_MAX_VALUES = new int[]{1, MAX_VALUE_OF_ERA, 11, 51, 5, 29, TinkerReport.KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND};
        MAX_VALUES = new int[]{1, MAX_VALUE_OF_ERA, 11, 52, 6, 30, TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL};
        CYCLEYEAR_START_DATE = new int[]{0, TinkerReport.KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, 709, DownloadErrorCode.ERROR_FILE_NOT_FOUND, 1417, 1772, 2126, 2481, 2835, 3189, 3544, 3898, 4252, 4607, 4961, 5315, 5670, 6024, 6379, 6733, 7087, 7442, 7796, 8150, 8505, 8859, 9214, 9568, 9922, 10277};
        char c10 = File.separatorChar;
        FILE_SEP = c10;
        PATH_SEP = File.pathSeparator;
        DEFAULT_CONFIG_PATH = "org" + c10 + "threeten" + c10 + "bp" + c10 + "chrono";
        ADJUSTED_MONTH_DAYS = new HashMap<>();
        ADJUSTED_MONTH_LENGTHS = new HashMap<>();
        ADJUSTED_CYCLE_YEARS = new HashMap<>();
        DEFAULT_MONTH_DAYS = new Integer[iArr.length];
        int i11 = 0;
        while (true) {
            int[] iArr2 = NUM_DAYS;
            if (i11 >= iArr2.length) {
                break;
            }
            DEFAULT_MONTH_DAYS[i11] = Integer.valueOf(iArr2[i11]);
            i11++;
        }
        DEFAULT_LEAP_MONTH_DAYS = new Integer[LEAP_NUM_DAYS.length];
        int i12 = 0;
        while (true) {
            int[] iArr3 = LEAP_NUM_DAYS;
            if (i12 >= iArr3.length) {
                break;
            }
            DEFAULT_LEAP_MONTH_DAYS[i12] = Integer.valueOf(iArr3[i12]);
            i12++;
        }
        DEFAULT_MONTH_LENGTHS = new Integer[MONTH_LENGTH.length];
        int i13 = 0;
        while (true) {
            int[] iArr4 = MONTH_LENGTH;
            if (i13 >= iArr4.length) {
                break;
            }
            DEFAULT_MONTH_LENGTHS[i13] = Integer.valueOf(iArr4[i13]);
            i13++;
        }
        DEFAULT_LEAP_MONTH_LENGTHS = new Integer[LEAP_MONTH_LENGTH.length];
        int i14 = 0;
        while (true) {
            int[] iArr5 = LEAP_MONTH_LENGTH;
            if (i14 >= iArr5.length) {
                break;
            }
            DEFAULT_LEAP_MONTH_LENGTHS[i14] = Integer.valueOf(iArr5[i14]);
            i14++;
        }
        DEFAULT_CYCLE_YEARS = new Integer[CYCLEYEAR_START_DATE.length];
        int i15 = 0;
        while (true) {
            int[] iArr6 = CYCLEYEAR_START_DATE;
            if (i15 >= iArr6.length) {
                break;
            }
            DEFAULT_CYCLE_YEARS[i15] = Integer.valueOf(iArr6[i15]);
            i15++;
        }
        ADJUSTED_CYCLES = new Long[MAX_ADJUSTED_CYCLE];
        int i16 = 0;
        while (true) {
            Long[] lArr = ADJUSTED_CYCLES;
            if (i16 >= lArr.length) {
                break;
            }
            lArr[i16] = Long.valueOf(i16 * 10631);
            i16++;
        }
        ADJUSTED_MIN_VALUES = new Integer[MIN_VALUES.length];
        int i17 = 0;
        while (true) {
            int[] iArr7 = MIN_VALUES;
            if (i17 >= iArr7.length) {
                break;
            }
            ADJUSTED_MIN_VALUES[i17] = Integer.valueOf(iArr7[i17]);
            i17++;
        }
        ADJUSTED_LEAST_MAX_VALUES = new Integer[LEAST_MAX_VALUES.length];
        int i18 = 0;
        while (true) {
            int[] iArr8 = LEAST_MAX_VALUES;
            if (i18 >= iArr8.length) {
                break;
            }
            ADJUSTED_LEAST_MAX_VALUES[i18] = Integer.valueOf(iArr8[i18]);
            i18++;
        }
        ADJUSTED_MAX_VALUES = new Integer[MAX_VALUES.length];
        while (true) {
            int[] iArr9 = MAX_VALUES;
            if (i10 >= iArr9.length) {
                try {
                    readDeviationConfig();
                    return;
                } catch (IOException | ParseException unused) {
                    return;
                }
            } else {
                ADJUSTED_MAX_VALUES[i10] = Integer.valueOf(iArr9[i10]);
                i10++;
            }
        }
    }

    private HijrahDate(long j10) {
        int[] hijrahDateInfo = getHijrahDateInfo(j10);
        checkValidYearOfEra(hijrahDateInfo[1]);
        checkValidMonth(hijrahDateInfo[2]);
        checkValidDayOfMonth(hijrahDateInfo[3]);
        checkValidDayOfYear(hijrahDateInfo[4]);
        this.era = HijrahEra.of(hijrahDateInfo[0]);
        int i10 = hijrahDateInfo[1];
        this.yearOfEra = i10;
        this.monthOfYear = hijrahDateInfo[2];
        this.dayOfMonth = hijrahDateInfo[3];
        this.dayOfYear = hijrahDateInfo[4];
        this.dayOfWeek = DayOfWeek.of(hijrahDateInfo[5]);
        this.gregorianEpochDay = j10;
        this.isLeapYear = isLeapYear(i10);
    }

    private static void addDeviationAsHijrah(int i10, int i11, int i12, int i13, int i14) {
        if (i10 < 1) {
            throw new IllegalArgumentException("startYear < 1");
        }
        if (i12 < 1) {
            throw new IllegalArgumentException("endYear < 1");
        }
        if (i11 < 0 || i11 > 11) {
            throw new IllegalArgumentException("startMonth < 0 || startMonth > 11");
        }
        if (i13 < 0 || i13 > 11) {
            throw new IllegalArgumentException("endMonth < 0 || endMonth > 11");
        }
        if (i12 > 9999) {
            throw new IllegalArgumentException("endYear > 9999");
        }
        if (i12 < i10) {
            throw new IllegalArgumentException("startYear > endYear");
        }
        if (i12 == i10 && i13 < i11) {
            throw new IllegalArgumentException("startYear == endYear && endMonth < startMonth");
        }
        boolean isLeapYear = isLeapYear(i10);
        Integer[] numArr = ADJUSTED_MONTH_DAYS.get(Integer.valueOf(i10));
        if (numArr == null) {
            if (!isLeapYear) {
                numArr = new Integer[NUM_DAYS.length];
                int i15 = 0;
                while (true) {
                    int[] iArr = NUM_DAYS;
                    if (i15 >= iArr.length) {
                        break;
                    }
                    numArr[i15] = Integer.valueOf(iArr[i15]);
                    i15++;
                }
            } else {
                numArr = new Integer[LEAP_NUM_DAYS.length];
                int i16 = 0;
                while (true) {
                    int[] iArr2 = LEAP_NUM_DAYS;
                    if (i16 >= iArr2.length) {
                        break;
                    }
                    numArr[i16] = Integer.valueOf(iArr2[i16]);
                    i16++;
                }
            }
        }
        Integer[] numArr2 = new Integer[numArr.length];
        for (int i17 = 0; i17 < 12; i17++) {
            if (i17 > i11) {
                numArr2[i17] = Integer.valueOf(numArr[i17].intValue() - i14);
            } else {
                Integer num = numArr[i17];
                num.intValue();
                numArr2[i17] = num;
            }
        }
        ADJUSTED_MONTH_DAYS.put(Integer.valueOf(i10), numArr2);
        Integer[] numArr3 = ADJUSTED_MONTH_LENGTHS.get(Integer.valueOf(i10));
        if (numArr3 == null) {
            if (!isLeapYear) {
                numArr3 = new Integer[MONTH_LENGTH.length];
                int i18 = 0;
                while (true) {
                    int[] iArr3 = MONTH_LENGTH;
                    if (i18 >= iArr3.length) {
                        break;
                    }
                    numArr3[i18] = Integer.valueOf(iArr3[i18]);
                    i18++;
                }
            } else {
                numArr3 = new Integer[LEAP_MONTH_LENGTH.length];
                int i19 = 0;
                while (true) {
                    int[] iArr4 = LEAP_MONTH_LENGTH;
                    if (i19 >= iArr4.length) {
                        break;
                    }
                    numArr3[i19] = Integer.valueOf(iArr4[i19]);
                    i19++;
                }
            }
        }
        Integer[] numArr4 = new Integer[numArr3.length];
        for (int i20 = 0; i20 < 12; i20++) {
            if (i20 == i11) {
                numArr4[i20] = Integer.valueOf(numArr3[i20].intValue() - i14);
            } else {
                Integer num2 = numArr3[i20];
                num2.intValue();
                numArr4[i20] = num2;
            }
        }
        ADJUSTED_MONTH_LENGTHS.put(Integer.valueOf(i10), numArr4);
        if (i10 != i12) {
            int i21 = i10 - 1;
            int i22 = i21 / 30;
            int i23 = i21 % 30;
            Integer[] numArr5 = ADJUSTED_CYCLE_YEARS.get(Integer.valueOf(i22));
            if (numArr5 == null) {
                int length = CYCLEYEAR_START_DATE.length;
                Integer[] numArr6 = new Integer[length];
                for (int i24 = 0; i24 < length; i24++) {
                    numArr6[i24] = Integer.valueOf(CYCLEYEAR_START_DATE[i24]);
                }
                numArr5 = numArr6;
            }
            for (int i25 = i23 + 1; i25 < CYCLEYEAR_START_DATE.length; i25++) {
                numArr5[i25] = Integer.valueOf(numArr5[i25].intValue() - i14);
            }
            ADJUSTED_CYCLE_YEARS.put(Integer.valueOf(i22), numArr5);
            int i26 = i12 - 1;
            int i27 = i26 / 30;
            if (i22 != i27) {
                int i28 = i22 + 1;
                while (true) {
                    Long[] lArr = ADJUSTED_CYCLES;
                    if (i28 >= lArr.length) {
                        break;
                    }
                    lArr[i28] = Long.valueOf(lArr[i28].longValue() - i14);
                    i28++;
                }
                int i29 = i27 + 1;
                while (true) {
                    Long[] lArr2 = ADJUSTED_CYCLES;
                    if (i29 >= lArr2.length) {
                        break;
                    }
                    lArr2[i29] = Long.valueOf(lArr2[i29].longValue() + i14);
                    i29++;
                    i27 = i27;
                }
            }
            int i30 = i27;
            int i31 = i26 % 30;
            Integer[] numArr7 = ADJUSTED_CYCLE_YEARS.get(Integer.valueOf(i30));
            if (numArr7 == null) {
                int length2 = CYCLEYEAR_START_DATE.length;
                Integer[] numArr8 = new Integer[length2];
                for (int i32 = 0; i32 < length2; i32++) {
                    numArr8[i32] = Integer.valueOf(CYCLEYEAR_START_DATE[i32]);
                }
                numArr7 = numArr8;
            }
            for (int i33 = i31 + 1; i33 < CYCLEYEAR_START_DATE.length; i33++) {
                numArr7[i33] = Integer.valueOf(numArr7[i33].intValue() + i14);
            }
            ADJUSTED_CYCLE_YEARS.put(Integer.valueOf(i30), numArr7);
        }
        boolean isLeapYear2 = isLeapYear(i12);
        Integer[] numArr9 = ADJUSTED_MONTH_DAYS.get(Integer.valueOf(i12));
        if (numArr9 == null) {
            if (!isLeapYear2) {
                numArr9 = new Integer[NUM_DAYS.length];
                int i34 = 0;
                while (true) {
                    int[] iArr5 = NUM_DAYS;
                    if (i34 >= iArr5.length) {
                        break;
                    }
                    numArr9[i34] = Integer.valueOf(iArr5[i34]);
                    i34++;
                }
            } else {
                numArr9 = new Integer[LEAP_NUM_DAYS.length];
                int i35 = 0;
                while (true) {
                    int[] iArr6 = LEAP_NUM_DAYS;
                    if (i35 >= iArr6.length) {
                        break;
                    }
                    numArr9[i35] = Integer.valueOf(iArr6[i35]);
                    i35++;
                }
            }
        }
        Integer[] numArr10 = new Integer[numArr9.length];
        for (int i36 = 0; i36 < 12; i36++) {
            if (i36 > i13) {
                numArr10[i36] = Integer.valueOf(numArr9[i36].intValue() + i14);
            } else {
                Integer num3 = numArr9[i36];
                num3.intValue();
                numArr10[i36] = num3;
            }
        }
        ADJUSTED_MONTH_DAYS.put(Integer.valueOf(i12), numArr10);
        Integer[] numArr11 = ADJUSTED_MONTH_LENGTHS.get(Integer.valueOf(i12));
        if (numArr11 == null) {
            if (!isLeapYear2) {
                numArr11 = new Integer[MONTH_LENGTH.length];
                int i37 = 0;
                while (true) {
                    int[] iArr7 = MONTH_LENGTH;
                    if (i37 >= iArr7.length) {
                        break;
                    }
                    numArr11[i37] = Integer.valueOf(iArr7[i37]);
                    i37++;
                }
            } else {
                numArr11 = new Integer[LEAP_MONTH_LENGTH.length];
                int i38 = 0;
                while (true) {
                    int[] iArr8 = LEAP_MONTH_LENGTH;
                    if (i38 >= iArr8.length) {
                        break;
                    }
                    numArr11[i38] = Integer.valueOf(iArr8[i38]);
                    i38++;
                }
            }
        }
        Integer[] numArr12 = new Integer[numArr11.length];
        for (int i39 = 0; i39 < 12; i39++) {
            if (i39 == i13) {
                numArr12[i39] = Integer.valueOf(numArr11[i39].intValue() + i14);
            } else {
                Integer num4 = numArr11[i39];
                num4.intValue();
                numArr12[i39] = num4;
            }
        }
        HashMap<Integer, Integer[]> hashMap = ADJUSTED_MONTH_LENGTHS;
        hashMap.put(Integer.valueOf(i12), numArr12);
        Integer[] numArr13 = hashMap.get(Integer.valueOf(i10));
        Integer[] numArr14 = hashMap.get(Integer.valueOf(i12));
        HashMap<Integer, Integer[]> hashMap2 = ADJUSTED_MONTH_DAYS;
        Integer[] numArr15 = hashMap2.get(Integer.valueOf(i10));
        Integer[] numArr16 = hashMap2.get(Integer.valueOf(i12));
        int intValue = numArr13[i11].intValue();
        int intValue2 = numArr14[i13].intValue();
        int intValue3 = numArr15[11].intValue() + numArr13[11].intValue();
        int intValue4 = numArr16[11].intValue() + numArr14[11].intValue();
        Integer[] numArr17 = ADJUSTED_MAX_VALUES;
        int intValue5 = numArr17[5].intValue();
        Integer[] numArr18 = ADJUSTED_LEAST_MAX_VALUES;
        int intValue6 = numArr18[5].intValue();
        if (intValue5 < intValue) {
            intValue5 = intValue;
        }
        if (intValue5 < intValue2) {
            intValue5 = intValue2;
        }
        numArr17[5] = Integer.valueOf(intValue5);
        if (intValue6 <= intValue) {
            intValue = intValue6;
        }
        if (intValue <= intValue2) {
            intValue2 = intValue;
        }
        numArr18[5] = Integer.valueOf(intValue2);
        int intValue7 = numArr17[6].intValue();
        int intValue8 = numArr18[6].intValue();
        if (intValue7 < intValue3) {
            intValue7 = intValue3;
        }
        if (intValue7 < intValue4) {
            intValue7 = intValue4;
        }
        numArr17[6] = Integer.valueOf(intValue7);
        if (intValue8 <= intValue3) {
            intValue3 = intValue8;
        }
        if (intValue3 <= intValue4) {
            intValue4 = intValue3;
        }
        numArr18[6] = Integer.valueOf(intValue4);
    }

    private static void checkValidDayOfMonth(int i10) {
        if (i10 < 1 || i10 > getMaximumDayOfMonth()) {
            throw new DateTimeException("Invalid day of month of Hijrah date, day " + i10 + " greater than " + getMaximumDayOfMonth() + " or less than 1");
        }
    }

    private static void checkValidDayOfYear(int i10) {
        if (i10 < 1 || i10 > getMaximumDayOfYear()) {
            throw new DateTimeException("Invalid day of year of Hijrah date");
        }
    }

    private static void checkValidMonth(int i10) {
        if (i10 < 1 || i10 > 12) {
            throw new DateTimeException("Invalid month of Hijrah date");
        }
    }

    private static void checkValidYearOfEra(int i10) {
        if (i10 < 1 || i10 > 9999) {
            throw new DateTimeException("Invalid year of Hijrah Era");
        }
    }

    public static HijrahDate from(ij.b bVar) {
        return HijrahChronology.INSTANCE.date(bVar);
    }

    private static Integer[] getAdjustedCycle(int i10) {
        Integer[] numArr;
        try {
            numArr = ADJUSTED_CYCLE_YEARS.get(Integer.valueOf(i10));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        return numArr == null ? DEFAULT_CYCLE_YEARS : numArr;
    }

    private static Integer[] getAdjustedMonthDays(int i10) {
        Integer[] numArr;
        try {
            numArr = ADJUSTED_MONTH_DAYS.get(Integer.valueOf(i10));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        return numArr == null ? isLeapYear((long) i10) ? DEFAULT_LEAP_MONTH_DAYS : DEFAULT_MONTH_DAYS : numArr;
    }

    private static Integer[] getAdjustedMonthLength(int i10) {
        Integer[] numArr;
        try {
            numArr = ADJUSTED_MONTH_LENGTHS.get(Integer.valueOf(i10));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        return numArr == null ? isLeapYear((long) i10) ? DEFAULT_LEAP_MONTH_LENGTHS : DEFAULT_MONTH_LENGTHS : numArr;
    }

    private static InputStream getConfigFileInputStream() throws IOException {
        ZipFile zipFile;
        String property = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigFile");
        if (property == null) {
            property = DEFAULT_CONFIG_FILENAME;
        }
        String property2 = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigDir");
        if (property2 != null) {
            if (property2.length() != 0 || !property2.endsWith(System.getProperty("file.separator"))) {
                property2 = property2 + System.getProperty("file.separator");
            }
            File file = new File(property2 + FILE_SEP + property);
            if (file.exists()) {
                return new FileInputStream(file);
            }
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(System.getProperty("java.class.path"), PATH_SEP);
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            File file2 = new File(nextToken);
            if (file2.exists()) {
                if (file2.isDirectory()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(nextToken);
                    char c10 = FILE_SEP;
                    sb2.append(c10);
                    String str = DEFAULT_CONFIG_PATH;
                    sb2.append(str);
                    if (new File(sb2.toString(), property).exists()) {
                        return new FileInputStream(nextToken + c10 + str + c10 + property);
                    }
                } else {
                    try {
                        zipFile = new ZipFile(file2);
                    } catch (IOException unused) {
                        zipFile = null;
                    }
                    if (zipFile != null) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(DEFAULT_CONFIG_PATH);
                        char c11 = FILE_SEP;
                        sb3.append(c11);
                        sb3.append(property);
                        String sb4 = sb3.toString();
                        ZipEntry entry = zipFile.getEntry(sb4);
                        if (entry == null) {
                            if (c11 == '/') {
                                sb4 = sb4.replace('/', '\\');
                            } else if (c11 == '\\') {
                                sb4 = sb4.replace('\\', '/');
                            }
                            entry = zipFile.getEntry(sb4);
                        }
                        if (entry != null) {
                            return zipFile.getInputStream(entry);
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    private static int getCycleNumber(long j10) {
        Long[] lArr = ADJUSTED_CYCLES;
        for (int i10 = 0; i10 < lArr.length; i10++) {
            try {
                if (j10 < lArr[i10].longValue()) {
                    return i10 - 1;
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
                return ((int) j10) / 10631;
            }
        }
        return ((int) j10) / 10631;
    }

    private static int getDayOfCycle(long j10, int i10) {
        Long l10;
        try {
            l10 = ADJUSTED_CYCLES[i10];
        } catch (ArrayIndexOutOfBoundsException unused) {
            l10 = null;
        }
        if (l10 == null) {
            l10 = Long.valueOf(i10 * 10631);
        }
        return (int) (j10 - l10.longValue());
    }

    private static int getDayOfMonth(int i10, int i11, int i12) {
        int intValue;
        Integer[] adjustedMonthDays = getAdjustedMonthDays(i12);
        if (i10 < 0) {
            i10 = isLeapYear((long) i12) ? i10 + TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL : i10 + TinkerReport.KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND;
            if (i11 <= 0) {
                return i10;
            }
            intValue = adjustedMonthDays[i11].intValue();
        } else {
            if (i11 <= 0) {
                return i10;
            }
            intValue = adjustedMonthDays[i11].intValue();
        }
        return i10 - intValue;
    }

    private static int getDayOfYear(int i10, int i11, int i12) {
        Integer[] adjustedCycle = getAdjustedCycle(i10);
        return i11 > 0 ? i11 - adjustedCycle[i12].intValue() : adjustedCycle[i12].intValue() + i11;
    }

    private static long getGregorianEpochDay(int i10, int i11, int i12) {
        return yearToGregorianEpochDay(i10) + getMonthDays(i11 - 1, i10) + i12;
    }

    private static int[] getHijrahDateInfo(long j10) {
        int i10;
        int i11;
        int monthOfYear;
        int dayOfMonth;
        int value;
        long j11 = j10 - (-492148);
        if (j11 >= 0) {
            int cycleNumber = getCycleNumber(j11);
            int dayOfCycle = getDayOfCycle(j11, cycleNumber);
            int yearInCycle = getYearInCycle(cycleNumber, dayOfCycle);
            i11 = getDayOfYear(cycleNumber, dayOfCycle, yearInCycle);
            i10 = (cycleNumber * 30) + yearInCycle + 1;
            monthOfYear = getMonthOfYear(i11, i10);
            dayOfMonth = getDayOfMonth(i11, monthOfYear, i10) + 1;
            value = HijrahEra.AH.getValue();
        } else {
            int i12 = (int) j11;
            int i13 = i12 / 10631;
            int i14 = i12 % 10631;
            if (i14 == 0) {
                i13++;
                i14 = -10631;
            }
            int yearInCycle2 = getYearInCycle(i13, i14);
            int dayOfYear = getDayOfYear(i13, i14, yearInCycle2);
            i10 = 1 - ((i13 * 30) - yearInCycle2);
            i11 = isLeapYear((long) i10) ? dayOfYear + TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL : dayOfYear + TinkerReport.KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND;
            monthOfYear = getMonthOfYear(i11, i10);
            dayOfMonth = getDayOfMonth(i11, monthOfYear, i10) + 1;
            value = HijrahEra.BEFORE_AH.getValue();
        }
        int i15 = (int) ((j10 - (-492153)) % 7);
        return new int[]{value, i10, monthOfYear + 1, dayOfMonth, i11 + 1, i15 + (i15 <= 0 ? 7 : 0)};
    }

    public static int getMaximumDayOfMonth() {
        return ADJUSTED_MAX_VALUES[5].intValue();
    }

    public static int getMaximumDayOfYear() {
        return ADJUSTED_MAX_VALUES[6].intValue();
    }

    private static int getMonthDays(int i10, int i11) {
        return getAdjustedMonthDays(i11)[i10].intValue();
    }

    public static int getMonthLength(int i10, int i11) {
        return getAdjustedMonthLength(i11)[i10].intValue();
    }

    private static int getMonthOfYear(int i10, int i11) {
        Integer[] adjustedMonthDays = getAdjustedMonthDays(i11);
        int i12 = 0;
        if (i10 >= 0) {
            while (i12 < adjustedMonthDays.length) {
                if (i10 < adjustedMonthDays[i12].intValue()) {
                    return i12 - 1;
                }
                i12++;
            }
            return 11;
        }
        int i13 = isLeapYear((long) i11) ? i10 + TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL : i10 + TinkerReport.KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND;
        while (i12 < adjustedMonthDays.length) {
            if (i13 < adjustedMonthDays[i12].intValue()) {
                return i12 - 1;
            }
            i12++;
        }
        return 11;
    }

    public static int getSmallestMaximumDayOfMonth() {
        return ADJUSTED_LEAST_MAX_VALUES[5].intValue();
    }

    public static int getSmallestMaximumDayOfYear() {
        return ADJUSTED_LEAST_MAX_VALUES[6].intValue();
    }

    private static int getYearInCycle(int i10, long j10) {
        Integer[] adjustedCycle = getAdjustedCycle(i10);
        int i11 = 0;
        if (j10 == 0) {
            return 0;
        }
        if (j10 > 0) {
            while (i11 < adjustedCycle.length) {
                if (j10 < adjustedCycle[i11].intValue()) {
                    return i11 - 1;
                }
                i11++;
            }
            return 29;
        }
        long j11 = -j10;
        while (i11 < adjustedCycle.length) {
            if (j11 <= adjustedCycle[i11].intValue()) {
                return i11 - 1;
            }
            i11++;
        }
        return 29;
    }

    public static int getYearLength(int i10) {
        Integer[] numArr;
        int i11 = i10 - 1;
        int i12 = i11 / 30;
        try {
            numArr = ADJUSTED_CYCLE_YEARS.get(Integer.valueOf(i12));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        if (numArr == null) {
            return isLeapYear((long) i10) ? TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL : TinkerReport.KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND;
        }
        int i13 = i11 % 30;
        if (i13 != 29) {
            return numArr[i13 + 1].intValue() - numArr[i13].intValue();
        }
        Long[] lArr = ADJUSTED_CYCLES;
        return (lArr[i12 + 1].intValue() - lArr[i12].intValue()) - numArr[i13].intValue();
    }

    public static HijrahDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static HijrahDate of(int i10, int i11, int i12) {
        return i10 >= 1 ? of(HijrahEra.AH, i10, i11, i12) : of(HijrahEra.BEFORE_AH, 1 - i10, i11, i12);
    }

    public static HijrahDate ofEpochDay(long j10) {
        return new HijrahDate(j10);
    }

    private static void parseLine(String str, int i10) throws ParseException {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf(58);
            if (indexOf == -1) {
                throw new ParseException("Offset has incorrect format at line " + i10 + p1.b.f29697h, i10);
            }
            try {
                int parseInt = Integer.parseInt(nextToken.substring(indexOf + 1, nextToken.length()));
                int indexOf2 = nextToken.indexOf(45);
                if (indexOf2 == -1) {
                    throw new ParseException("Start and end year/month has incorrect format at line " + i10 + p1.b.f29697h, i10);
                }
                String substring = nextToken.substring(0, indexOf2);
                String substring2 = nextToken.substring(indexOf2 + 1, indexOf);
                int indexOf3 = substring.indexOf(47);
                int indexOf4 = substring2.indexOf(47);
                if (indexOf3 == -1) {
                    throw new ParseException("Start year/month has incorrect format at line " + i10 + p1.b.f29697h, i10);
                }
                String substring3 = substring.substring(0, indexOf3);
                String substring4 = substring.substring(indexOf3 + 1, substring.length());
                try {
                    int parseInt2 = Integer.parseInt(substring3);
                    try {
                        int parseInt3 = Integer.parseInt(substring4);
                        if (indexOf4 == -1) {
                            throw new ParseException("End year/month has incorrect format at line " + i10 + p1.b.f29697h, i10);
                        }
                        String substring5 = substring2.substring(0, indexOf4);
                        String substring6 = substring2.substring(indexOf4 + 1, substring2.length());
                        try {
                            int parseInt4 = Integer.parseInt(substring5);
                            try {
                                int parseInt5 = Integer.parseInt(substring6);
                                if (parseInt2 == -1 || parseInt3 == -1 || parseInt4 == -1 || parseInt5 == -1) {
                                    throw new ParseException("Unknown error at line " + i10 + p1.b.f29697h, i10);
                                }
                                addDeviationAsHijrah(parseInt2, parseInt3, parseInt4, parseInt5, parseInt);
                            } catch (NumberFormatException unused) {
                                throw new ParseException("End month is not properly set at line " + i10 + p1.b.f29697h, i10);
                            }
                        } catch (NumberFormatException unused2) {
                            throw new ParseException("End year is not properly set at line " + i10 + p1.b.f29697h, i10);
                        }
                    } catch (NumberFormatException unused3) {
                        throw new ParseException("Start month is not properly set at line " + i10 + p1.b.f29697h, i10);
                    }
                } catch (NumberFormatException unused4) {
                    throw new ParseException("Start year is not properly set at line " + i10 + p1.b.f29697h, i10);
                }
            } catch (NumberFormatException unused5) {
                throw new ParseException("Offset is not properly set at line " + i10 + p1.b.f29697h, i10);
            }
        }
    }

    private static void readDeviationConfig() throws IOException, ParseException {
        InputStream configFileInputStream = getConfigFileInputStream();
        if (configFileInputStream == null) {
            return;
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(configFileInputStream));
            int i10 = 0;
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        bufferedReader2.close();
                        return;
                    } else {
                        i10++;
                        parseLine(readLine.trim(), i10);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static org.threeten.bp.chrono.a readExternal(DataInput dataInput) throws IOException {
        return HijrahChronology.INSTANCE.date(dataInput.readInt(), (int) dataInput.readByte(), (int) dataInput.readByte());
    }

    private Object readResolve() {
        return new HijrahDate(this.gregorianEpochDay);
    }

    private static HijrahDate resolvePreviousValid(int i10, int i11, int i12) {
        int monthDays = getMonthDays(i11 - 1, i10);
        if (i12 > monthDays) {
            i12 = monthDays;
        }
        return of(i10, i11, i12);
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    private static long yearToGregorianEpochDay(int i10) {
        Long l10;
        int i11 = i10 - 1;
        int i12 = i11 / 30;
        int i13 = i11 % 30;
        int intValue = getAdjustedCycle(i12)[Math.abs(i13)].intValue();
        if (i13 < 0) {
            intValue = -intValue;
        }
        try {
            l10 = ADJUSTED_CYCLES[i12];
        } catch (ArrayIndexOutOfBoundsException unused) {
            l10 = null;
        }
        if (l10 == null) {
            l10 = Long.valueOf(i12 * 10631);
        }
        return (l10.longValue() + intValue) - 492149;
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a
    public final fj.b<HijrahDate> atTime(LocalTime localTime) {
        return super.atTime(localTime);
    }

    @Override // ij.b
    public long getLong(f fVar) {
        int i10;
        int i11;
        if (!(fVar instanceof ChronoField)) {
            return fVar.getFrom(this);
        }
        switch (a.f29503a[((ChronoField) fVar).ordinal()]) {
            case 1:
                i10 = this.dayOfMonth;
                return i10;
            case 2:
                i10 = this.dayOfYear;
                return i10;
            case 3:
                i11 = (this.dayOfMonth - 1) / 7;
                i10 = i11 + 1;
                return i10;
            case 4:
                i10 = this.yearOfEra;
                return i10;
            case 5:
                i10 = this.dayOfWeek.getValue();
                return i10;
            case 6:
                i11 = (this.dayOfMonth - 1) % 7;
                i10 = i11 + 1;
                return i10;
            case 7:
                i11 = (this.dayOfYear - 1) % 7;
                i10 = i11 + 1;
                return i10;
            case 8:
                return toEpochDay();
            case 9:
                i11 = (this.dayOfYear - 1) / 7;
                i10 = i11 + 1;
                return i10;
            case 10:
                i10 = this.monthOfYear;
                return i10;
            case 11:
                i10 = this.yearOfEra;
                return i10;
            case 12:
                i10 = this.era.getValue();
                return i10;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
        }
    }

    @Override // org.threeten.bp.chrono.a
    public boolean isLeapYear() {
        return this.isLeapYear;
    }

    @Override // org.threeten.bp.chrono.a
    public int lengthOfMonth() {
        return getMonthLength(this.monthOfYear - 1, this.yearOfEra);
    }

    @Override // org.threeten.bp.chrono.a
    public int lengthOfYear() {
        return getYearLength(this.yearOfEra);
    }

    @Override // hj.c, ij.b
    public ValueRange range(f fVar) {
        if (!(fVar instanceof ChronoField)) {
            return fVar.rangeRefinedBy(this);
        }
        if (isSupported(fVar)) {
            ChronoField chronoField = (ChronoField) fVar;
            int i10 = a.f29503a[chronoField.ordinal()];
            return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? getChronology().range(chronoField) : ValueRange.of(1L, 1000L) : ValueRange.of(1L, 5L) : ValueRange.of(1L, lengthOfYear()) : ValueRange.of(1L, lengthOfMonth());
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
    }

    @Override // org.threeten.bp.chrono.a
    public long toEpochDay() {
        return getGregorianEpochDay(this.yearOfEra, this.monthOfYear, this.dayOfMonth);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, ij.a
    public /* bridge */ /* synthetic */ long until(ij.a aVar, i iVar) {
        return super.until(aVar, iVar);
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(get(ChronoField.YEAR));
        dataOutput.writeByte(get(ChronoField.MONTH_OF_YEAR));
        dataOutput.writeByte(get(ChronoField.DAY_OF_MONTH));
    }

    public static boolean isLeapYear(long j10) {
        if (j10 <= 0) {
            j10 = -j10;
        }
        return ((j10 * 11) + 14) % 30 < 11;
    }

    public static HijrahDate now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    @Override // org.threeten.bp.chrono.a
    public HijrahChronology getChronology() {
        return HijrahChronology.INSTANCE;
    }

    @Override // org.threeten.bp.chrono.a
    public HijrahEra getEra() {
        return this.era;
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<HijrahDate> plusDays(long j10) {
        return new HijrahDate(this.gregorianEpochDay + j10);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<HijrahDate> plusMonths(long j10) {
        if (j10 == 0) {
            return this;
        }
        int i10 = (this.monthOfYear - 1) + ((int) j10);
        int i11 = i10 / 12;
        int i12 = i10 % 12;
        while (i12 < 0) {
            i12 += 12;
            i11 = d.p(i11, 1);
        }
        return of(this.era, d.k(this.yearOfEra, i11), i12 + 1, this.dayOfMonth);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<HijrahDate> plusYears(long j10) {
        if (j10 == 0) {
            return this;
        }
        return of(this.era, d.k(this.yearOfEra, (int) j10), this.monthOfYear, this.dayOfMonth);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a
    public /* bridge */ /* synthetic */ c until(org.threeten.bp.chrono.a aVar) {
        return super.until(aVar);
    }

    public static HijrahDate now(Clock clock) {
        return HijrahChronology.INSTANCE.dateNow(clock);
    }

    public static HijrahDate of(HijrahEra hijrahEra, int i10, int i11, int i12) {
        d.j(hijrahEra, "era");
        checkValidYearOfEra(i10);
        checkValidMonth(i11);
        checkValidDayOfMonth(i12);
        return new HijrahDate(getGregorianEpochDay(hijrahEra.prolepticYear(i10), i11, i12));
    }

    @Override // org.threeten.bp.chrono.a, hj.b, ij.a
    public HijrahDate minus(e eVar) {
        return (HijrahDate) super.minus(eVar);
    }

    @Override // org.threeten.bp.chrono.a, hj.b, ij.a
    public HijrahDate with(ij.c cVar) {
        return (HijrahDate) super.with(cVar);
    }

    @Override // org.threeten.bp.chrono.a, hj.b, ij.a
    public HijrahDate minus(long j10, i iVar) {
        return (HijrahDate) super.minus(j10, iVar);
    }

    @Override // org.threeten.bp.chrono.a, hj.b, ij.a
    public HijrahDate plus(e eVar) {
        return (HijrahDate) super.plus(eVar);
    }

    /* JADX WARN: Type inference failed for: r6v14, types: [org.threeten.bp.chrono.HijrahDate] */
    /* JADX WARN: Type inference failed for: r6v16, types: [org.threeten.bp.chrono.HijrahDate] */
    /* JADX WARN: Type inference failed for: r6v18, types: [org.threeten.bp.chrono.HijrahDate] */
    /* JADX WARN: Type inference failed for: r6v21, types: [org.threeten.bp.chrono.HijrahDate] */
    /* JADX WARN: Type inference failed for: r6v8, types: [org.threeten.bp.chrono.HijrahDate] */
    @Override // org.threeten.bp.chrono.a, ij.a
    public HijrahDate with(f fVar, long j10) {
        if (fVar instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) fVar;
            chronoField.checkValidValue(j10);
            int i10 = (int) j10;
            switch (a.f29503a[chronoField.ordinal()]) {
                case 1:
                    return resolvePreviousValid(this.yearOfEra, this.monthOfYear, i10);
                case 2:
                    int i11 = i10 - 1;
                    return resolvePreviousValid(this.yearOfEra, (i11 / 30) + 1, (i11 % 30) + 1);
                case 3:
                    return plusDays((j10 - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH)) * 7);
                case 4:
                    if (this.yearOfEra < 1) {
                        i10 = 1 - i10;
                    }
                    return resolvePreviousValid(i10, this.monthOfYear, this.dayOfMonth);
                case 5:
                    return plusDays(j10 - this.dayOfWeek.getValue());
                case 6:
                    return plusDays(j10 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
                case 7:
                    return plusDays(j10 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
                case 8:
                    return new HijrahDate(i10);
                case 9:
                    return plusDays((j10 - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR)) * 7);
                case 10:
                    return resolvePreviousValid(this.yearOfEra, i10, this.dayOfMonth);
                case 11:
                    return resolvePreviousValid(i10, this.monthOfYear, this.dayOfMonth);
                case 12:
                    return resolvePreviousValid(1 - this.yearOfEra, this.monthOfYear, this.dayOfMonth);
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
            }
        }
        return (HijrahDate) fVar.adjustInto(this, j10);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a, ij.a
    public HijrahDate plus(long j10, i iVar) {
        return (HijrahDate) super.plus(j10, iVar);
    }

    public static HijrahDate of(LocalDate localDate) {
        return new HijrahDate(localDate.toEpochDay());
    }
}
