package org.threeten.bp.format;

import com.kwad.sdk.core.response.model.SdkConfigData;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import okhttp3.internal.http2.Http2Connection;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.c;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.WeekFields;

/* loaded from: classes4.dex */
public final class DateTimeFormatterBuilder {

    /* renamed from: h */
    public static final ij.h<ZoneId> f29535h = new a();

    /* renamed from: i */
    public static final Map<Character, ij.f> f29536i;

    /* renamed from: j */
    public static final Comparator<String> f29537j;

    /* renamed from: a */
    public DateTimeFormatterBuilder f29538a;

    /* renamed from: b */
    public final DateTimeFormatterBuilder f29539b;

    /* renamed from: c */
    public final List<h> f29540c;

    /* renamed from: d */
    public final boolean f29541d;

    /* renamed from: e */
    public int f29542e;

    /* renamed from: f */
    public char f29543f;

    /* renamed from: g */
    public int f29544g;

    public enum SettingsParser implements h {
        SENSITIVE,
        INSENSITIVE,
        STRICT,
        LENIENT;

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public int parse(org.threeten.bp.format.a aVar, CharSequence charSequence, int i10) {
            int ordinal = ordinal();
            if (ordinal == 0) {
                aVar.n(true);
            } else if (ordinal == 1) {
                aVar.n(false);
            } else if (ordinal == 2) {
                aVar.t(true);
            } else if (ordinal == 3) {
                aVar.t(false);
            }
            return i10;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public boolean print(gj.d dVar, StringBuilder sb2) {
            return true;
        }

        @Override // java.lang.Enum
        public String toString() {
            int ordinal = ordinal();
            if (ordinal == 0) {
                return "ParseCaseSensitive(true)";
            }
            if (ordinal == 1) {
                return "ParseCaseSensitive(false)";
            }
            if (ordinal == 2) {
                return "ParseStrict(true)";
            }
            if (ordinal == 3) {
                return "ParseStrict(false)";
            }
            throw new IllegalStateException("Unreachable");
        }
    }

    public class a implements ij.h<ZoneId> {
        @Override // ij.h
        /* renamed from: b */
        public ZoneId a(ij.b bVar) {
            ZoneId zoneId = (ZoneId) bVar.query(ij.g.g());
            if (zoneId == null || (zoneId instanceof ZoneOffset)) {
                return null;
            }
            return zoneId;
        }
    }

    public class b extends org.threeten.bp.format.b {

        /* renamed from: b */
        public final /* synthetic */ c.b f29545b;

        public b(c.b bVar) {
            this.f29545b = bVar;
        }

        @Override // org.threeten.bp.format.b
        public String c(ij.f fVar, long j10, TextStyle textStyle, Locale locale) {
            return this.f29545b.a(j10, textStyle);
        }

        @Override // org.threeten.bp.format.b
        public Iterator<Map.Entry<String, Long>> d(ij.f fVar, TextStyle textStyle, Locale locale) {
            return this.f29545b.b(textStyle);
        }
    }

    public class c implements Comparator<String> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.length() == str2.length() ? str.compareTo(str2) : str.length() - str2.length();
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a */
        public static final /* synthetic */ int[] f29547a;

        static {
            int[] iArr = new int[SignStyle.values().length];
            f29547a = iArr;
            try {
                iArr[SignStyle.EXCEEDS_PAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29547a[SignStyle.ALWAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29547a[SignStyle.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29547a[SignStyle.NOT_NEGATIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static final class e implements h {

        /* renamed from: b */
        public final char f29548b;

        public e(char c10) {
            this.f29548b = c10;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public int parse(org.threeten.bp.format.a aVar, CharSequence charSequence, int i10) {
            if (i10 == charSequence.length()) {
                return ~i10;
            }
            return !aVar.c(this.f29548b, charSequence.charAt(i10)) ? ~i10 : i10 + 1;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public boolean print(gj.d dVar, StringBuilder sb2) {
            sb2.append(this.f29548b);
            return true;
        }

        public String toString() {
            if (this.f29548b == '\'') {
                return "''";
            }
            return "'" + this.f29548b + "'";
        }
    }

    public static final class f implements h {

        /* renamed from: b */
        public final TextStyle f29549b;

        public f(TextStyle textStyle) {
            this.f29549b = textStyle;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public int parse(org.threeten.bp.format.a aVar, CharSequence charSequence, int i10) {
            if (i10 < 0 || i10 > charSequence.length()) {
                throw new IndexOutOfBoundsException();
            }
            org.threeten.bp.chrono.b bVar = null;
            int i11 = -1;
            for (org.threeten.bp.chrono.b bVar2 : org.threeten.bp.chrono.b.getAvailableChronologies()) {
                String id2 = bVar2.getId();
                int length = id2.length();
                if (length > i11 && aVar.v(charSequence, i10, id2, 0, length)) {
                    bVar = bVar2;
                    i11 = length;
                }
            }
            if (bVar == null) {
                return ~i10;
            }
            aVar.q(bVar);
            return i10 + i11;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public boolean print(gj.d dVar, StringBuilder sb2) {
            org.threeten.bp.chrono.b bVar = (org.threeten.bp.chrono.b) dVar.g(ij.g.a());
            if (bVar == null) {
                return false;
            }
            if (this.f29549b == null) {
                sb2.append(bVar.getId());
                return true;
            }
            try {
                sb2.append(ResourceBundle.getBundle("org.threeten.bp.format.ChronologyText", dVar.c(), DateTimeFormatterBuilder.class.getClassLoader()).getString(bVar.getId()));
                return true;
            } catch (MissingResourceException unused) {
                sb2.append(bVar.getId());
                return true;
            }
        }
    }

    public static final class g implements h {

        /* renamed from: b */
        public final h[] f29550b;

        /* renamed from: c */
        public final boolean f29551c;

        public g(List<h> list, boolean z10) {
            this((h[]) list.toArray(new h[list.size()]), z10);
        }

        public g a(boolean z10) {
            return z10 == this.f29551c ? this : new g(this.f29550b, z10);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public int parse(org.threeten.bp.format.a aVar, CharSequence charSequence, int i10) {
            if (!this.f29551c) {
                for (h hVar : this.f29550b) {
                    i10 = hVar.parse(aVar, charSequence, i10);
                    if (i10 < 0) {
                        break;
                    }
                }
                return i10;
            }
            aVar.u();
            int i11 = i10;
            for (h hVar2 : this.f29550b) {
                i11 = hVar2.parse(aVar, charSequence, i11);
                if (i11 < 0) {
                    aVar.g(false);
                    return i10;
                }
            }
            aVar.g(true);
            return i11;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public boolean print(gj.d dVar, StringBuilder sb2) {
            int length = sb2.length();
            if (this.f29551c) {
                dVar.j();
            }
            try {
                for (h hVar : this.f29550b) {
                    if (!hVar.print(dVar, sb2)) {
                        sb2.setLength(length);
                        return true;
                    }
                }
                if (this.f29551c) {
                    dVar.b();
                }
                return true;
            } finally {
                if (this.f29551c) {
                    dVar.b();
                }
            }
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            if (this.f29550b != null) {
                sb2.append(this.f29551c ? "[" : "(");
                for (h hVar : this.f29550b) {
                    sb2.append(hVar);
                }
                sb2.append(this.f29551c ? "]" : ")");
            }
            return sb2.toString();
        }

        public g(h[] hVarArr, boolean z10) {
            this.f29550b = hVarArr;
            this.f29551c = z10;
        }
    }

    public interface h {
        int parse(org.threeten.bp.format.a aVar, CharSequence charSequence, int i10);

        boolean print(gj.d dVar, StringBuilder sb2);
    }

    public static class i implements h {

        /* renamed from: b */
        public final ij.f f29552b;

        /* renamed from: c */
        public final long f29553c;

        public i(ij.f fVar, long j10) {
            this.f29552b = fVar;
            this.f29553c = j10;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public int parse(org.threeten.bp.format.a aVar, CharSequence charSequence, int i10) {
            if (aVar.j(this.f29552b) == null) {
                aVar.r(this.f29552b, this.f29553c, i10, i10);
            }
            return i10;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public boolean print(gj.d dVar, StringBuilder sb2) {
            return true;
        }
    }

    public static final class j implements h {

        /* renamed from: b */
        public final ij.f f29554b;

        /* renamed from: c */
        public final int f29555c;

        /* renamed from: d */
        public final int f29556d;

        /* renamed from: e */
        public final boolean f29557e;

        public j(ij.f fVar, int i10, int i11, boolean z10) {
            hj.d.j(fVar, "field");
            if (!fVar.range().isFixed()) {
                throw new IllegalArgumentException("Field must have a fixed set of values: " + fVar);
            }
            if (i10 < 0 || i10 > 9) {
                throw new IllegalArgumentException("Minimum width must be from 0 to 9 inclusive but was " + i10);
            }
            if (i11 < 1 || i11 > 9) {
                throw new IllegalArgumentException("Maximum width must be from 1 to 9 inclusive but was " + i11);
            }
            if (i11 >= i10) {
                this.f29554b = fVar;
                this.f29555c = i10;
                this.f29556d = i11;
                this.f29557e = z10;
                return;
            }
            throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + i11 + " < " + i10);
        }

        public final long a(BigDecimal bigDecimal) {
            ValueRange range = this.f29554b.range();
            BigDecimal valueOf = BigDecimal.valueOf(range.getMinimum());
            return bigDecimal.multiply(BigDecimal.valueOf(range.getMaximum()).subtract(valueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(valueOf).longValueExact();
        }

        public final BigDecimal b(long j10) {
            ValueRange range = this.f29554b.range();
            range.checkValidValue(j10, this.f29554b);
            BigDecimal valueOf = BigDecimal.valueOf(range.getMinimum());
            BigDecimal divide = BigDecimal.valueOf(j10).subtract(valueOf).divide(BigDecimal.valueOf(range.getMaximum()).subtract(valueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
            BigDecimal bigDecimal = BigDecimal.ZERO;
            return divide.compareTo(bigDecimal) == 0 ? bigDecimal : gj.c.a(divide);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public int parse(org.threeten.bp.format.a aVar, CharSequence charSequence, int i10) {
            int i11 = 0;
            int i12 = aVar.m() ? this.f29555c : 0;
            int i13 = aVar.m() ? this.f29556d : 9;
            int length = charSequence.length();
            if (i10 == length) {
                return i12 > 0 ? ~i10 : i10;
            }
            if (this.f29557e) {
                if (charSequence.charAt(i10) != aVar.k().e()) {
                    return i12 > 0 ? ~i10 : i10;
                }
                i10++;
            }
            int i14 = i10;
            int i15 = i12 + i14;
            if (i15 > length) {
                return ~i14;
            }
            int min = Math.min(i13 + i14, length);
            int i16 = i14;
            while (true) {
                if (i16 >= min) {
                    break;
                }
                int i17 = i16 + 1;
                int b10 = aVar.k().b(charSequence.charAt(i16));
                if (b10 >= 0) {
                    i11 = (i11 * 10) + b10;
                    i16 = i17;
                } else if (i17 < i15) {
                    return ~i14;
                }
            }
            return aVar.r(this.f29554b, a(new BigDecimal(i11).movePointLeft(i16 - i14)), i14, i16);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public boolean print(gj.d dVar, StringBuilder sb2) {
            Long f10 = dVar.f(this.f29554b);
            if (f10 == null) {
                return false;
            }
            gj.e d10 = dVar.d();
            BigDecimal b10 = b(f10.longValue());
            if (b10.scale() != 0) {
                String a10 = d10.a(b10.setScale(Math.min(Math.max(b10.scale(), this.f29555c), this.f29556d), RoundingMode.FLOOR).toPlainString().substring(2));
                if (this.f29557e) {
                    sb2.append(d10.e());
                }
                sb2.append(a10);
                return true;
            }
            if (this.f29555c <= 0) {
                return true;
            }
            if (this.f29557e) {
                sb2.append(d10.e());
            }
            for (int i10 = 0; i10 < this.f29555c; i10++) {
                sb2.append(d10.h());
            }
            return true;
        }

        public String toString() {
            return "Fraction(" + this.f29554b + "," + this.f29555c + "," + this.f29556d + (this.f29557e ? ",DecimalPoint" : "") + ")";
        }
    }

    public static final class k implements h {

        /* renamed from: c */
        public static final long f29558c = 315569520000L;

        /* renamed from: d */
        public static final long f29559d = 62167219200L;

        /* renamed from: b */
        public final int f29560b;

        public k(int i10) {
            this.f29560b = i10;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public int parse(org.threeten.bp.format.a aVar, CharSequence charSequence, int i10) {
            int i11;
            int i12;
            org.threeten.bp.format.a e10 = aVar.e();
            int i13 = this.f29560b;
            int i14 = 0;
            int i15 = i13 < 0 ? 0 : i13;
            if (i13 < 0) {
                i13 = 9;
            }
            DateTimeFormatterBuilder h10 = new DateTimeFormatterBuilder().a(DateTimeFormatter.f29511h).h('T');
            ChronoField chronoField = ChronoField.HOUR_OF_DAY;
            DateTimeFormatterBuilder h11 = h10.t(chronoField, 2).h(m5.d.f28378d);
            ChronoField chronoField2 = ChronoField.MINUTE_OF_HOUR;
            DateTimeFormatterBuilder h12 = h11.t(chronoField2, 2).h(m5.d.f28378d);
            ChronoField chronoField3 = ChronoField.SECOND_OF_MINUTE;
            DateTimeFormatterBuilder t10 = h12.t(chronoField3, 2);
            ChronoField chronoField4 = ChronoField.NANO_OF_SECOND;
            int parse = t10.d(chronoField4, i15, i13, true).h('Z').P().C(false).parse(e10, charSequence, i10);
            if (parse < 0) {
                return parse;
            }
            long longValue = e10.j(ChronoField.YEAR).longValue();
            int intValue = e10.j(ChronoField.MONTH_OF_YEAR).intValue();
            int intValue2 = e10.j(ChronoField.DAY_OF_MONTH).intValue();
            int intValue3 = e10.j(chronoField).intValue();
            int intValue4 = e10.j(chronoField2).intValue();
            Long j10 = e10.j(chronoField3);
            Long j11 = e10.j(chronoField4);
            int intValue5 = j10 != null ? j10.intValue() : 0;
            int intValue6 = j11 != null ? j11.intValue() : 0;
            int i16 = ((int) longValue) % 10000;
            if (intValue3 == 24 && intValue4 == 0 && intValue5 == 0 && intValue6 == 0) {
                i12 = intValue5;
                i14 = 1;
                i11 = 0;
            } else if (intValue3 == 23 && intValue4 == 59 && intValue5 == 60) {
                aVar.s();
                i11 = intValue3;
                i12 = 59;
            } else {
                i11 = intValue3;
                i12 = intValue5;
            }
            try {
                return aVar.r(chronoField4, intValue6, i10, aVar.r(ChronoField.INSTANT_SECONDS, hj.d.o(longValue / 10000, f29558c) + LocalDateTime.of(i16, intValue, intValue2, i11, intValue4, i12, 0).plusDays(i14).toEpochSecond(ZoneOffset.UTC), i10, parse));
            } catch (RuntimeException unused) {
                return ~i10;
            }
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public boolean print(gj.d dVar, StringBuilder sb2) {
            Long f10 = dVar.f(ChronoField.INSTANT_SECONDS);
            ij.b e10 = dVar.e();
            ChronoField chronoField = ChronoField.NANO_OF_SECOND;
            Long valueOf = e10.isSupported(chronoField) ? Long.valueOf(dVar.e().getLong(chronoField)) : 0L;
            int i10 = 0;
            if (f10 == null) {
                return false;
            }
            long longValue = f10.longValue();
            int checkValidIntValue = chronoField.checkValidIntValue(valueOf.longValue());
            if (longValue >= -62167219200L) {
                long j10 = longValue - 253402300800L;
                long e11 = hj.d.e(j10, f29558c) + 1;
                LocalDateTime ofEpochSecond = LocalDateTime.ofEpochSecond(hj.d.h(j10, f29558c) - f29559d, 0, ZoneOffset.UTC);
                if (e11 > 0) {
                    sb2.append('+');
                    sb2.append(e11);
                }
                sb2.append(ofEpochSecond);
                if (ofEpochSecond.getSecond() == 0) {
                    sb2.append(":00");
                }
            } else {
                long j11 = longValue + f29559d;
                long j12 = j11 / f29558c;
                long j13 = j11 % f29558c;
                LocalDateTime ofEpochSecond2 = LocalDateTime.ofEpochSecond(j13 - f29559d, 0, ZoneOffset.UTC);
                int length = sb2.length();
                sb2.append(ofEpochSecond2);
                if (ofEpochSecond2.getSecond() == 0) {
                    sb2.append(":00");
                }
                if (j12 < 0) {
                    if (ofEpochSecond2.getYear() == -10000) {
                        sb2.replace(length, length + 2, Long.toString(j12 - 1));
                    } else if (j13 == 0) {
                        sb2.insert(length, j12);
                    } else {
                        sb2.insert(length + 1, Math.abs(j12));
                    }
                }
            }
            int i11 = this.f29560b;
            if (i11 == -2) {
                if (checkValidIntValue != 0) {
                    sb2.append('.');
                    if (checkValidIntValue % 1000000 == 0) {
                        sb2.append(Integer.toString((checkValidIntValue / 1000000) + 1000).substring(1));
                    } else if (checkValidIntValue % 1000 == 0) {
                        sb2.append(Integer.toString((checkValidIntValue / 1000) + 1000000).substring(1));
                    } else {
                        sb2.append(Integer.toString(checkValidIntValue + Http2Connection.DEGRADED_PONG_TIMEOUT_NS).substring(1));
                    }
                }
            } else if (i11 > 0 || (i11 == -1 && checkValidIntValue > 0)) {
                sb2.append('.');
                int i12 = 100000000;
                while (true) {
                    int i13 = this.f29560b;
                    if ((i13 != -1 || checkValidIntValue <= 0) && i10 >= i13) {
                        break;
                    }
                    int i14 = checkValidIntValue / i12;
                    sb2.append((char) (i14 + 48));
                    checkValidIntValue -= i14 * i12;
                    i12 /= 10;
                    i10++;
                }
            }
            sb2.append('Z');
            return true;
        }

        public String toString() {
            return "Instant()";
        }
    }

    public static final class l implements h {

        /* renamed from: b */
        public final TextStyle f29561b;

        public l(TextStyle textStyle) {
            this.f29561b = textStyle;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public int parse(org.threeten.bp.format.a aVar, CharSequence charSequence, int i10) {
            char charAt;
            if (!aVar.v(charSequence, i10, "GMT", 0, 3)) {
                return ~i10;
            }
            int i11 = i10 + 3;
            if (this.f29561b == TextStyle.FULL) {
                return new o("", "+HH:MM:ss").parse(aVar, charSequence, i11);
            }
            int length = charSequence.length();
            if (i11 == length) {
                return aVar.r(ChronoField.OFFSET_SECONDS, 0L, i11, i11);
            }
            char charAt2 = charSequence.charAt(i11);
            if (charAt2 != '+' && charAt2 != '-') {
                return aVar.r(ChronoField.OFFSET_SECONDS, 0L, i11, i11);
            }
            int i12 = charAt2 == '-' ? -1 : 1;
            if (i11 == length) {
                return ~i11;
            }
            int i13 = i10 + 4;
            char charAt3 = charSequence.charAt(i13);
            if (charAt3 < '0' || charAt3 > '9') {
                return ~i13;
            }
            int i14 = i10 + 5;
            int i15 = charAt3 - '0';
            if (i14 != length && (charAt = charSequence.charAt(i14)) >= '0' && charAt <= '9') {
                i15 = (i15 * 10) + (charAt - '0');
                if (i15 > 23) {
                    return ~i14;
                }
                i14 = i10 + 6;
            }
            int i16 = i14;
            if (i16 == length || charSequence.charAt(i16) != ':') {
                return aVar.r(ChronoField.OFFSET_SECONDS, i12 * SdkConfigData.DEFAULT_REQUEST_INTERVAL * i15, i16, i16);
            }
            int i17 = i16 + 1;
            int i18 = length - 2;
            if (i17 > i18) {
                return ~i17;
            }
            char charAt4 = charSequence.charAt(i17);
            if (charAt4 < '0' || charAt4 > '9') {
                return ~i17;
            }
            int i19 = i16 + 2;
            int i20 = charAt4 - '0';
            char charAt5 = charSequence.charAt(i19);
            if (charAt5 < '0' || charAt5 > '9') {
                return ~i19;
            }
            int i21 = i16 + 3;
            if ((i20 * 10) + (charAt5 - '0') > 59) {
                return ~i21;
            }
            if (i21 == length || charSequence.charAt(i21) != ':') {
                return aVar.r(ChronoField.OFFSET_SECONDS, i12 * ((i15 * SdkConfigData.DEFAULT_REQUEST_INTERVAL) + (r11 * 60)), i21, i21);
            }
            int i22 = i16 + 4;
            if (i22 > i18) {
                return ~i22;
            }
            char charAt6 = charSequence.charAt(i22);
            if (charAt6 < '0' || charAt6 > '9') {
                return ~i22;
            }
            int i23 = i16 + 5;
            int i24 = charAt6 - '0';
            char charAt7 = charSequence.charAt(i23);
            if (charAt7 < '0' || charAt7 > '9') {
                return ~i23;
            }
            int i25 = i16 + 6;
            return (i24 * 10) + (charAt7 - '0') > 59 ? ~i25 : aVar.r(ChronoField.OFFSET_SECONDS, i12 * ((i15 * SdkConfigData.DEFAULT_REQUEST_INTERVAL) + (r11 * 60) + r1), i25, i25);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public boolean print(gj.d dVar, StringBuilder sb2) {
            Long f10 = dVar.f(ChronoField.OFFSET_SECONDS);
            if (f10 == null) {
                return false;
            }
            sb2.append("GMT");
            if (this.f29561b == TextStyle.FULL) {
                return new o("", "+HH:MM:ss").print(dVar, sb2);
            }
            int r10 = hj.d.r(f10.longValue());
            if (r10 == 0) {
                return true;
            }
            int abs = Math.abs((r10 / SdkConfigData.DEFAULT_REQUEST_INTERVAL) % 100);
            int abs2 = Math.abs((r10 / 60) % 60);
            int abs3 = Math.abs(r10 % 60);
            sb2.append(r10 < 0 ? "-" : "+");
            sb2.append(abs);
            if (abs2 <= 0 && abs3 <= 0) {
                return true;
            }
            sb2.append(":");
            sb2.append((char) ((abs2 / 10) + 48));
            sb2.append((char) ((abs2 % 10) + 48));
            if (abs3 <= 0) {
                return true;
            }
            sb2.append(":");
            sb2.append((char) ((abs3 / 10) + 48));
            sb2.append((char) ((abs3 % 10) + 48));
            return true;
        }
    }

    public static final class m implements h {

        /* renamed from: b */
        public final FormatStyle f29562b;

        /* renamed from: c */
        public final FormatStyle f29563c;

        public m(FormatStyle formatStyle, FormatStyle formatStyle2) {
            this.f29562b = formatStyle;
            this.f29563c = formatStyle2;
        }

        public final DateTimeFormatter a(Locale locale, org.threeten.bp.chrono.b bVar) {
            return gj.b.c().b(this.f29562b, this.f29563c, bVar, locale);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public int parse(org.threeten.bp.format.a aVar, CharSequence charSequence, int i10) {
            return a(aVar.i(), aVar.h()).C(false).parse(aVar, charSequence, i10);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public boolean print(gj.d dVar, StringBuilder sb2) {
            return a(dVar.c(), org.threeten.bp.chrono.b.from(dVar.e())).C(false).print(dVar, sb2);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Localized(");
            Object obj = this.f29562b;
            if (obj == null) {
                obj = "";
            }
            sb2.append(obj);
            sb2.append(",");
            FormatStyle formatStyle = this.f29563c;
            sb2.append(formatStyle != null ? formatStyle : "");
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static class n implements h {

        /* renamed from: g */
        public static final int[] f29564g = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, Http2Connection.DEGRADED_PONG_TIMEOUT_NS};

        /* renamed from: b */
        public final ij.f f29565b;

        /* renamed from: c */
        public final int f29566c;

        /* renamed from: d */
        public final int f29567d;

        /* renamed from: e */
        public final SignStyle f29568e;

        /* renamed from: f */
        public final int f29569f;

        public /* synthetic */ n(ij.f fVar, int i10, int i11, SignStyle signStyle, int i12, a aVar) {
            this(fVar, i10, i11, signStyle, i12);
        }

        public boolean b(org.threeten.bp.format.a aVar) {
            int i10 = this.f29569f;
            return i10 == -1 || (i10 > 0 && this.f29566c == this.f29567d && this.f29568e == SignStyle.NOT_NEGATIVE);
        }

        public int c(org.threeten.bp.format.a aVar, long j10, int i10, int i11) {
            return aVar.r(this.f29565b, j10, i10, i11);
        }

        public n d() {
            return this.f29569f == -1 ? this : new n(this.f29565b, this.f29566c, this.f29567d, this.f29568e, -1);
        }

        public n e(int i10) {
            return new n(this.f29565b, this.f29566c, this.f29567d, this.f29568e, this.f29569f + i10);
        }

        /* JADX WARN: Removed duplicated region for block: B:66:0x0161  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x017f  */
        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int parse(org.threeten.bp.format.a r20, java.lang.CharSequence r21, int r22) {
            /*
                Method dump skipped, instructions count: 393
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.format.DateTimeFormatterBuilder.n.parse(org.threeten.bp.format.a, java.lang.CharSequence, int):int");
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public boolean print(gj.d dVar, StringBuilder sb2) {
            Long f10 = dVar.f(this.f29565b);
            if (f10 == null) {
                return false;
            }
            long a10 = a(dVar, f10.longValue());
            gj.e d10 = dVar.d();
            String l10 = a10 == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(a10));
            if (l10.length() > this.f29567d) {
                throw new DateTimeException("Field " + this.f29565b + " cannot be printed as the value " + a10 + " exceeds the maximum print width of " + this.f29567d);
            }
            String a11 = d10.a(l10);
            if (a10 >= 0) {
                int i10 = d.f29547a[this.f29568e.ordinal()];
                if (i10 == 1) {
                    if (this.f29566c < 19 && a10 >= f29564g[r4]) {
                        sb2.append(d10.g());
                    }
                } else if (i10 == 2) {
                    sb2.append(d10.g());
                }
            } else {
                int i11 = d.f29547a[this.f29568e.ordinal()];
                if (i11 == 1 || i11 == 2 || i11 == 3) {
                    sb2.append(d10.f());
                } else if (i11 == 4) {
                    throw new DateTimeException("Field " + this.f29565b + " cannot be printed as the value " + a10 + " cannot be negative according to the SignStyle");
                }
            }
            for (int i12 = 0; i12 < this.f29566c - a11.length(); i12++) {
                sb2.append(d10.h());
            }
            sb2.append(a11);
            return true;
        }

        public String toString() {
            int i10 = this.f29566c;
            if (i10 == 1 && this.f29567d == 19 && this.f29568e == SignStyle.NORMAL) {
                return "Value(" + this.f29565b + ")";
            }
            if (i10 == this.f29567d && this.f29568e == SignStyle.NOT_NEGATIVE) {
                return "Value(" + this.f29565b + "," + this.f29566c + ")";
            }
            return "Value(" + this.f29565b + "," + this.f29566c + "," + this.f29567d + "," + this.f29568e + ")";
        }

        public n(ij.f fVar, int i10, int i11, SignStyle signStyle) {
            this.f29565b = fVar;
            this.f29566c = i10;
            this.f29567d = i11;
            this.f29568e = signStyle;
            this.f29569f = 0;
        }

        public n(ij.f fVar, int i10, int i11, SignStyle signStyle, int i12) {
            this.f29565b = fVar;
            this.f29566c = i10;
            this.f29567d = i11;
            this.f29568e = signStyle;
            this.f29569f = i12;
        }

        public long a(gj.d dVar, long j10) {
            return j10;
        }
    }

    public static final class o implements h {

        /* renamed from: d */
        public static final String[] f29570d = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};

        /* renamed from: e */
        public static final o f29571e = new o("Z", "+HH:MM:ss");

        /* renamed from: f */
        public static final o f29572f = new o("0", "+HH:MM:ss");

        /* renamed from: b */
        public final String f29573b;

        /* renamed from: c */
        public final int f29574c;

        public o(String str, String str2) {
            hj.d.j(str, "noOffsetText");
            hj.d.j(str2, "pattern");
            this.f29573b = str;
            this.f29574c = a(str2);
        }

        public final int a(String str) {
            int i10 = 0;
            while (true) {
                String[] strArr = f29570d;
                if (i10 >= strArr.length) {
                    throw new IllegalArgumentException("Invalid zone offset pattern: " + str);
                }
                if (strArr[i10].equals(str)) {
                    return i10;
                }
                i10++;
            }
        }

        public final boolean b(int[] iArr, int i10, CharSequence charSequence, boolean z10) {
            int i11;
            int i12 = this.f29574c;
            if ((i12 + 3) / 2 < i10) {
                return false;
            }
            int i13 = iArr[0];
            if (i12 % 2 == 0 && i10 > 1) {
                int i14 = i13 + 1;
                if (i14 > charSequence.length() || charSequence.charAt(i13) != ':') {
                    return z10;
                }
                i13 = i14;
            }
            if (i13 + 2 > charSequence.length()) {
                return z10;
            }
            int i15 = i13 + 1;
            char charAt = charSequence.charAt(i13);
            int i16 = i13 + 2;
            char charAt2 = charSequence.charAt(i15);
            if (charAt < '0' || charAt > '9' || charAt2 < '0' || charAt2 > '9' || (i11 = ((charAt - '0') * 10) + (charAt2 - '0')) < 0 || i11 > 59) {
                return z10;
            }
            iArr[i10] = i11;
            iArr[0] = i16;
            return false;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public int parse(org.threeten.bp.format.a aVar, CharSequence charSequence, int i10) {
            int length = charSequence.length();
            int length2 = this.f29573b.length();
            if (length2 == 0) {
                if (i10 == length) {
                    return aVar.r(ChronoField.OFFSET_SECONDS, 0L, i10, i10);
                }
            } else {
                if (i10 == length) {
                    return ~i10;
                }
                if (aVar.v(charSequence, i10, this.f29573b, 0, length2)) {
                    return aVar.r(ChronoField.OFFSET_SECONDS, 0L, i10, i10 + length2);
                }
            }
            char charAt = charSequence.charAt(i10);
            if (charAt == '+' || charAt == '-') {
                int i11 = charAt == '-' ? -1 : 1;
                int[] iArr = new int[4];
                iArr[0] = i10 + 1;
                if (!b(iArr, 1, charSequence, true)) {
                    if (!b(iArr, 2, charSequence, this.f29574c >= 3) && !b(iArr, 3, charSequence, false)) {
                        return aVar.r(ChronoField.OFFSET_SECONDS, i11 * ((iArr[1] * 3600) + (iArr[2] * 60) + iArr[3]), i10, iArr[0]);
                    }
                }
            }
            return length2 == 0 ? aVar.r(ChronoField.OFFSET_SECONDS, 0L, i10, i10 + length2) : ~i10;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public boolean print(gj.d dVar, StringBuilder sb2) {
            Long f10 = dVar.f(ChronoField.OFFSET_SECONDS);
            if (f10 == null) {
                return false;
            }
            int r10 = hj.d.r(f10.longValue());
            if (r10 == 0) {
                sb2.append(this.f29573b);
            } else {
                int abs = Math.abs((r10 / SdkConfigData.DEFAULT_REQUEST_INTERVAL) % 100);
                int abs2 = Math.abs((r10 / 60) % 60);
                int abs3 = Math.abs(r10 % 60);
                int length = sb2.length();
                sb2.append(r10 < 0 ? "-" : "+");
                sb2.append((char) ((abs / 10) + 48));
                sb2.append((char) ((abs % 10) + 48));
                int i10 = this.f29574c;
                if (i10 >= 3 || (i10 >= 1 && abs2 > 0)) {
                    sb2.append(i10 % 2 == 0 ? ":" : "");
                    sb2.append((char) ((abs2 / 10) + 48));
                    sb2.append((char) ((abs2 % 10) + 48));
                    abs += abs2;
                    int i11 = this.f29574c;
                    if (i11 >= 7 || (i11 >= 5 && abs3 > 0)) {
                        sb2.append(i11 % 2 == 0 ? ":" : "");
                        sb2.append((char) ((abs3 / 10) + 48));
                        sb2.append((char) ((abs3 % 10) + 48));
                        abs += abs3;
                    }
                }
                if (abs == 0) {
                    sb2.setLength(length);
                    sb2.append(this.f29573b);
                }
            }
            return true;
        }

        public String toString() {
            return "Offset(" + f29570d[this.f29574c] + ",'" + this.f29573b.replace("'", "''") + "')";
        }
    }

    public static final class p implements h {

        /* renamed from: b */
        public final h f29575b;

        /* renamed from: c */
        public final int f29576c;

        /* renamed from: d */
        public final char f29577d;

        public p(h hVar, int i10, char c10) {
            this.f29575b = hVar;
            this.f29576c = i10;
            this.f29577d = c10;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public int parse(org.threeten.bp.format.a aVar, CharSequence charSequence, int i10) {
            boolean m10 = aVar.m();
            boolean l10 = aVar.l();
            if (i10 > charSequence.length()) {
                throw new IndexOutOfBoundsException();
            }
            if (i10 == charSequence.length()) {
                return ~i10;
            }
            int i11 = this.f29576c + i10;
            if (i11 > charSequence.length()) {
                if (m10) {
                    return ~i10;
                }
                i11 = charSequence.length();
            }
            int i12 = i10;
            while (i12 < i11) {
                if (!l10) {
                    if (!aVar.c(charSequence.charAt(i12), this.f29577d)) {
                        break;
                    }
                    i12++;
                } else {
                    if (charSequence.charAt(i12) != this.f29577d) {
                        break;
                    }
                    i12++;
                }
            }
            int parse = this.f29575b.parse(aVar, charSequence.subSequence(0, i11), i12);
            return (parse == i11 || !m10) ? parse : ~(i10 + i12);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public boolean print(gj.d dVar, StringBuilder sb2) {
            int length = sb2.length();
            if (!this.f29575b.print(dVar, sb2)) {
                return false;
            }
            int length2 = sb2.length() - length;
            if (length2 <= this.f29576c) {
                for (int i10 = 0; i10 < this.f29576c - length2; i10++) {
                    sb2.insert(length, this.f29577d);
                }
                return true;
            }
            throw new DateTimeException("Cannot print as output of " + length2 + " characters exceeds pad width of " + this.f29576c);
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Pad(");
            sb2.append(this.f29575b);
            sb2.append(",");
            sb2.append(this.f29576c);
            if (this.f29577d == ' ') {
                str = ")";
            } else {
                str = ",'" + this.f29577d + "')";
            }
            sb2.append(str);
            return sb2.toString();
        }
    }

    public static final class r implements h {

        /* renamed from: b */
        public final String f29581b;

        public r(String str) {
            this.f29581b = str;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public int parse(org.threeten.bp.format.a aVar, CharSequence charSequence, int i10) {
            if (i10 > charSequence.length() || i10 < 0) {
                throw new IndexOutOfBoundsException();
            }
            String str = this.f29581b;
            return !aVar.v(charSequence, i10, str, 0, str.length()) ? ~i10 : i10 + this.f29581b.length();
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public boolean print(gj.d dVar, StringBuilder sb2) {
            sb2.append(this.f29581b);
            return true;
        }

        public String toString() {
            return "'" + this.f29581b.replace("'", "''") + "'";
        }
    }

    public static final class s implements h {

        /* renamed from: b */
        public final ij.f f29582b;

        /* renamed from: c */
        public final TextStyle f29583c;

        /* renamed from: d */
        public final org.threeten.bp.format.b f29584d;

        /* renamed from: e */
        public volatile n f29585e;

        public s(ij.f fVar, TextStyle textStyle, org.threeten.bp.format.b bVar) {
            this.f29582b = fVar;
            this.f29583c = textStyle;
            this.f29584d = bVar;
        }

        public final n a() {
            if (this.f29585e == null) {
                this.f29585e = new n(this.f29582b, 1, 19, SignStyle.NORMAL);
            }
            return this.f29585e;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public int parse(org.threeten.bp.format.a aVar, CharSequence charSequence, int i10) {
            int length = charSequence.length();
            if (i10 < 0 || i10 > length) {
                throw new IndexOutOfBoundsException();
            }
            Iterator<Map.Entry<String, Long>> d10 = this.f29584d.d(this.f29582b, aVar.m() ? this.f29583c : null, aVar.i());
            if (d10 != null) {
                while (d10.hasNext()) {
                    Map.Entry<String, Long> next = d10.next();
                    String key = next.getKey();
                    if (aVar.v(key, 0, charSequence, i10, key.length())) {
                        return aVar.r(this.f29582b, next.getValue().longValue(), i10, i10 + key.length());
                    }
                }
                if (aVar.m()) {
                    return ~i10;
                }
            }
            return a().parse(aVar, charSequence, i10);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public boolean print(gj.d dVar, StringBuilder sb2) {
            Long f10 = dVar.f(this.f29582b);
            if (f10 == null) {
                return false;
            }
            String c10 = this.f29584d.c(this.f29582b, f10.longValue(), this.f29583c, dVar.c());
            if (c10 == null) {
                return a().print(dVar, sb2);
            }
            sb2.append(c10);
            return true;
        }

        public String toString() {
            if (this.f29583c == TextStyle.FULL) {
                return "Text(" + this.f29582b + ")";
            }
            return "Text(" + this.f29582b + "," + this.f29583c + ")";
        }
    }

    public static final class t implements h {

        /* renamed from: b */
        public final char f29586b;

        /* renamed from: c */
        public final int f29587c;

        public t(char c10, int i10) {
            this.f29586b = c10;
            this.f29587c = i10;
        }

        public final h a(WeekFields weekFields) {
            char c10 = this.f29586b;
            if (c10 == 'W') {
                return new n(weekFields.weekOfMonth(), 1, 2, SignStyle.NOT_NEGATIVE);
            }
            if (c10 == 'Y') {
                if (this.f29587c == 2) {
                    return new q(weekFields.weekBasedYear(), 2, 2, 0, q.f29578j);
                }
                ij.f weekBasedYear = weekFields.weekBasedYear();
                int i10 = this.f29587c;
                return new n(weekBasedYear, i10, 19, i10 < 4 ? SignStyle.NORMAL : SignStyle.EXCEEDS_PAD, -1, null);
            }
            if (c10 == 'c') {
                return new n(weekFields.dayOfWeek(), this.f29587c, 2, SignStyle.NOT_NEGATIVE);
            }
            if (c10 == 'e') {
                return new n(weekFields.dayOfWeek(), this.f29587c, 2, SignStyle.NOT_NEGATIVE);
            }
            if (c10 != 'w') {
                return null;
            }
            return new n(weekFields.weekOfWeekBasedYear(), this.f29587c, 2, SignStyle.NOT_NEGATIVE);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public int parse(org.threeten.bp.format.a aVar, CharSequence charSequence, int i10) {
            return a(WeekFields.of(aVar.i())).parse(aVar, charSequence, i10);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public boolean print(gj.d dVar, StringBuilder sb2) {
            return a(WeekFields.of(dVar.c())).print(dVar, sb2);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Localized(");
            char c10 = this.f29586b;
            if (c10 == 'Y') {
                int i10 = this.f29587c;
                if (i10 == 1) {
                    sb2.append("WeekBasedYear");
                } else if (i10 == 2) {
                    sb2.append("ReducedValue(WeekBasedYear,2,2,2000-01-01)");
                } else {
                    sb2.append("WeekBasedYear,");
                    sb2.append(this.f29587c);
                    sb2.append(",");
                    sb2.append(19);
                    sb2.append(",");
                    sb2.append(this.f29587c < 4 ? SignStyle.NORMAL : SignStyle.EXCEEDS_PAD);
                }
            } else {
                if (c10 == 'c' || c10 == 'e') {
                    sb2.append("DayOfWeek");
                } else if (c10 == 'w') {
                    sb2.append("WeekOfWeekBasedYear");
                } else if (c10 == 'W') {
                    sb2.append("WeekOfMonth");
                }
                sb2.append(",");
                sb2.append(this.f29587c);
            }
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static final class u implements h {

        /* renamed from: d */
        public static volatile Map.Entry<Integer, a> f29588d;

        /* renamed from: b */
        public final ij.h<ZoneId> f29589b;

        /* renamed from: c */
        public final String f29590c;

        public static final class a {

            /* renamed from: a */
            public final int f29591a;

            /* renamed from: b */
            public final Map<CharSequence, a> f29592b;

            /* renamed from: c */
            public final Map<String, a> f29593c;

            public /* synthetic */ a(int i10, a aVar) {
                this(i10);
            }

            public final void c(String str) {
                int length = str.length();
                int i10 = this.f29591a;
                if (length == i10) {
                    this.f29592b.put(str, null);
                    this.f29593c.put(str.toLowerCase(Locale.ENGLISH), null);
                } else if (length > i10) {
                    String substring = str.substring(0, i10);
                    a aVar = this.f29592b.get(substring);
                    if (aVar == null) {
                        aVar = new a(length);
                        this.f29592b.put(substring, aVar);
                        this.f29593c.put(substring.toLowerCase(Locale.ENGLISH), aVar);
                    }
                    aVar.c(str);
                }
            }

            public final a d(CharSequence charSequence, boolean z10) {
                return z10 ? this.f29592b.get(charSequence) : this.f29593c.get(charSequence.toString().toLowerCase(Locale.ENGLISH));
            }

            public a(int i10) {
                this.f29592b = new HashMap();
                this.f29593c = new HashMap();
                this.f29591a = i10;
            }
        }

        public u(ij.h<ZoneId> hVar, String str) {
            this.f29589b = hVar;
            this.f29590c = str;
        }

        public static a c(Set<String> set) {
            ArrayList arrayList = new ArrayList(set);
            Collections.sort(arrayList, DateTimeFormatterBuilder.f29537j);
            a aVar = new a(((String) arrayList.get(0)).length(), null);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                aVar.c((String) it.next());
            }
            return aVar;
        }

        public final ZoneId a(Set<String> set, String str, boolean z10) {
            if (str == null) {
                return null;
            }
            if (z10) {
                if (set.contains(str)) {
                    return ZoneId.of(str);
                }
                return null;
            }
            for (String str2 : set) {
                if (str2.equalsIgnoreCase(str)) {
                    return ZoneId.of(str2);
                }
            }
            return null;
        }

        public final int b(org.threeten.bp.format.a aVar, CharSequence charSequence, int i10, int i11) {
            String upperCase = charSequence.subSequence(i10, i11).toString().toUpperCase();
            org.threeten.bp.format.a e10 = aVar.e();
            if (i11 < charSequence.length() && aVar.c(charSequence.charAt(i11), 'Z')) {
                aVar.p(ZoneId.ofOffset(upperCase, ZoneOffset.UTC));
                return i11;
            }
            int parse = o.f29571e.parse(e10, charSequence, i11);
            if (parse < 0) {
                aVar.p(ZoneId.ofOffset(upperCase, ZoneOffset.UTC));
                return i11;
            }
            aVar.p(ZoneId.ofOffset(upperCase, ZoneOffset.ofTotalSeconds((int) e10.j(ChronoField.OFFSET_SECONDS).longValue())));
            return parse;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public int parse(org.threeten.bp.format.a aVar, CharSequence charSequence, int i10) {
            int i11;
            int length = charSequence.length();
            if (i10 > length) {
                throw new IndexOutOfBoundsException();
            }
            if (i10 == length) {
                return ~i10;
            }
            char charAt = charSequence.charAt(i10);
            if (charAt == '+' || charAt == '-') {
                org.threeten.bp.format.a e10 = aVar.e();
                int parse = o.f29571e.parse(e10, charSequence, i10);
                if (parse < 0) {
                    return parse;
                }
                aVar.p(ZoneOffset.ofTotalSeconds((int) e10.j(ChronoField.OFFSET_SECONDS).longValue()));
                return parse;
            }
            int i12 = i10 + 2;
            if (length >= i12) {
                char charAt2 = charSequence.charAt(i10 + 1);
                if (aVar.c(charAt, 'U') && aVar.c(charAt2, 'T')) {
                    int i13 = i10 + 3;
                    return (length < i13 || !aVar.c(charSequence.charAt(i12), 'C')) ? b(aVar, charSequence, i10, i12) : b(aVar, charSequence, i10, i13);
                }
                if (aVar.c(charAt, 'G') && length >= (i11 = i10 + 3) && aVar.c(charAt2, 'M') && aVar.c(charSequence.charAt(i12), 'T')) {
                    return b(aVar, charSequence, i10, i11);
                }
            }
            Set<String> a10 = jj.b.a();
            int size = a10.size();
            Map.Entry<Integer, a> entry = f29588d;
            if (entry == null || entry.getKey().intValue() != size) {
                synchronized (this) {
                    try {
                        entry = f29588d;
                        if (entry != null) {
                            if (entry.getKey().intValue() != size) {
                            }
                        }
                        entry = new AbstractMap.SimpleImmutableEntry<>(Integer.valueOf(size), c(a10));
                        f29588d = entry;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            a value = entry.getValue();
            String str = null;
            String str2 = null;
            while (value != null) {
                int i14 = value.f29591a + i10;
                if (i14 > length) {
                    break;
                }
                String charSequence2 = charSequence.subSequence(i10, i14).toString();
                value = value.d(charSequence2, aVar.l());
                str2 = str;
                str = charSequence2;
            }
            ZoneId a11 = a(a10, str, aVar.l());
            if (a11 == null) {
                a11 = a(a10, str2, aVar.l());
                if (a11 == null) {
                    if (!aVar.c(charAt, 'Z')) {
                        return ~i10;
                    }
                    aVar.p(ZoneOffset.UTC);
                    return i10 + 1;
                }
                str = str2;
            }
            aVar.p(a11);
            return i10 + str.length();
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public boolean print(gj.d dVar, StringBuilder sb2) {
            ZoneId zoneId = (ZoneId) dVar.g(this.f29589b);
            if (zoneId == null) {
                return false;
            }
            sb2.append(zoneId.getId());
            return true;
        }

        public String toString() {
            return this.f29590c;
        }
    }

    public static final class v implements h {

        /* renamed from: c */
        public static final Comparator<String> f29594c = new a();

        /* renamed from: b */
        public final TextStyle f29595b;

        public class a implements Comparator<String> {
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(String str, String str2) {
                int length = str2.length() - str.length();
                return length == 0 ? str.compareTo(str2) : length;
            }
        }

        public v(TextStyle textStyle) {
            this.f29595b = (TextStyle) hj.d.j(textStyle, "textStyle");
        }

        public final int a(org.threeten.bp.format.a aVar, CharSequence charSequence, int i10, String str) {
            int length = str.length();
            int i11 = i10 + length;
            if (i11 >= charSequence.length()) {
                aVar.p(ZoneId.of(str));
                return i11;
            }
            char charAt = charSequence.charAt(i11);
            if (charAt != '+' && charAt != '-') {
                aVar.p(ZoneId.of(str));
                return i11;
            }
            org.threeten.bp.format.a e10 = aVar.e();
            try {
                int parse = o.f29572f.parse(e10, charSequence, i11);
                if (parse < 0) {
                    aVar.p(ZoneId.of(str));
                    return i11;
                }
                ZoneOffset ofTotalSeconds = ZoneOffset.ofTotalSeconds((int) e10.j(ChronoField.OFFSET_SECONDS).longValue());
                aVar.p(length == 0 ? ofTotalSeconds : ZoneId.ofOffset(str, ofTotalSeconds));
                return parse;
            } catch (DateTimeException unused) {
                return ~i10;
            }
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public int parse(org.threeten.bp.format.a aVar, CharSequence charSequence, int i10) {
            int length = charSequence.length();
            if (i10 > length) {
                throw new IndexOutOfBoundsException();
            }
            if (i10 == length) {
                return ~i10;
            }
            char charAt = charSequence.charAt(i10);
            if (charAt == '+' || charAt == '-') {
                return i10 + 6 > length ? ~i10 : a(aVar, charSequence, i10, "");
            }
            if (aVar.v(charSequence, i10, "GMT", 0, 3)) {
                return a(aVar, charSequence, i10, "GMT");
            }
            if (aVar.v(charSequence, i10, "UTC", 0, 3)) {
                return a(aVar, charSequence, i10, "UTC");
            }
            if (aVar.v(charSequence, i10, "UT", 0, 2)) {
                return a(aVar, charSequence, i10, "UT");
            }
            TreeMap treeMap = new TreeMap(f29594c);
            for (String str : ZoneId.getAvailableZoneIds()) {
                treeMap.put(str, str);
                TimeZone timeZone = TimeZone.getTimeZone(str);
                int i11 = this.f29595b.asNormal() == TextStyle.FULL ? 1 : 0;
                String displayName = timeZone.getDisplayName(false, i11, aVar.i());
                if (str.startsWith("Etc/") || (!displayName.startsWith("GMT+") && !displayName.startsWith("GMT+"))) {
                    treeMap.put(displayName, str);
                }
                String displayName2 = timeZone.getDisplayName(true, i11, aVar.i());
                if (str.startsWith("Etc/") || (!displayName2.startsWith("GMT+") && !displayName2.startsWith("GMT+"))) {
                    treeMap.put(displayName2, str);
                }
            }
            for (Map.Entry entry : treeMap.entrySet()) {
                String str2 = (String) entry.getKey();
                if (aVar.v(charSequence, i10, str2, 0, str2.length())) {
                    aVar.p(ZoneId.of((String) entry.getValue()));
                    return i10 + str2.length();
                }
            }
            if (charAt != 'Z') {
                return ~i10;
            }
            aVar.p(ZoneOffset.UTC);
            return i10 + 1;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.h
        public boolean print(gj.d dVar, StringBuilder sb2) {
            ZoneId zoneId = (ZoneId) dVar.g(ij.g.g());
            if (zoneId == null) {
                return false;
            }
            if (zoneId.normalized() instanceof ZoneOffset) {
                sb2.append(zoneId.getId());
                return true;
            }
            ij.b e10 = dVar.e();
            ChronoField chronoField = ChronoField.INSTANT_SECONDS;
            sb2.append(TimeZone.getTimeZone(zoneId.getId()).getDisplayName(e10.isSupported(chronoField) ? zoneId.getRules().isDaylightSavings(Instant.ofEpochSecond(e10.getLong(chronoField))) : false, this.f29595b.asNormal() == TextStyle.FULL ? 1 : 0, dVar.c()));
            return true;
        }

        public String toString() {
            return "ZoneText(" + this.f29595b + ")";
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f29536i = hashMap;
        hashMap.put('G', ChronoField.ERA);
        hashMap.put('y', ChronoField.YEAR_OF_ERA);
        hashMap.put('u', ChronoField.YEAR);
        ij.f fVar = IsoFields.f29617b;
        hashMap.put('Q', fVar);
        hashMap.put('q', fVar);
        ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
        hashMap.put('M', chronoField);
        hashMap.put('L', chronoField);
        hashMap.put('D', ChronoField.DAY_OF_YEAR);
        hashMap.put('d', ChronoField.DAY_OF_MONTH);
        hashMap.put('F', ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        ChronoField chronoField2 = ChronoField.DAY_OF_WEEK;
        hashMap.put('E', chronoField2);
        hashMap.put('c', chronoField2);
        hashMap.put('e', chronoField2);
        hashMap.put('a', ChronoField.AMPM_OF_DAY);
        hashMap.put('H', ChronoField.HOUR_OF_DAY);
        hashMap.put('k', ChronoField.CLOCK_HOUR_OF_DAY);
        hashMap.put('K', ChronoField.HOUR_OF_AMPM);
        hashMap.put('h', ChronoField.CLOCK_HOUR_OF_AMPM);
        hashMap.put('m', ChronoField.MINUTE_OF_HOUR);
        hashMap.put('s', ChronoField.SECOND_OF_MINUTE);
        ChronoField chronoField3 = ChronoField.NANO_OF_SECOND;
        hashMap.put('S', chronoField3);
        hashMap.put('A', ChronoField.MILLI_OF_DAY);
        hashMap.put('n', chronoField3);
        hashMap.put('N', ChronoField.NANO_OF_DAY);
        f29537j = new c();
    }

    public DateTimeFormatterBuilder() {
        this.f29538a = this;
        this.f29540c = new ArrayList();
        this.f29544g = -1;
        this.f29539b = null;
        this.f29541d = false;
    }

    public static String D(FormatStyle formatStyle, FormatStyle formatStyle2, org.threeten.bp.chrono.b bVar, Locale locale) {
        hj.d.j(locale, "locale");
        hj.d.j(bVar, "chrono");
        if (formatStyle == null && formatStyle2 == null) {
            throw new IllegalArgumentException("Either dateStyle or timeStyle must be non-null");
        }
        DateFormat dateTimeInstance = formatStyle != null ? formatStyle2 != null ? DateFormat.getDateTimeInstance(formatStyle.ordinal(), formatStyle2.ordinal(), locale) : DateFormat.getDateInstance(formatStyle.ordinal(), locale) : DateFormat.getTimeInstance(formatStyle2.ordinal(), locale);
        if (dateTimeInstance instanceof SimpleDateFormat) {
            return ((SimpleDateFormat) dateTimeInstance).toPattern();
        }
        throw new IllegalArgumentException("Unable to determine pattern");
    }

    public DateTimeFormatterBuilder A() {
        g(new u(f29535h, "ZoneRegionId()"));
        return this;
    }

    public DateTimeFormatterBuilder B(TextStyle textStyle) {
        g(new v(textStyle));
        return this;
    }

    public DateTimeFormatterBuilder C(TextStyle textStyle, Set<ZoneId> set) {
        hj.d.j(set, "preferredZones");
        g(new v(textStyle));
        return this;
    }

    public DateTimeFormatterBuilder E() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.f29538a;
        if (dateTimeFormatterBuilder.f29539b == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        if (dateTimeFormatterBuilder.f29540c.size() > 0) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.f29538a;
            g gVar = new g(dateTimeFormatterBuilder2.f29540c, dateTimeFormatterBuilder2.f29541d);
            this.f29538a = this.f29538a.f29539b;
            g(gVar);
        } else {
            this.f29538a = this.f29538a.f29539b;
        }
        return this;
    }

    public DateTimeFormatterBuilder F() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.f29538a;
        dateTimeFormatterBuilder.f29544g = -1;
        this.f29538a = new DateTimeFormatterBuilder(dateTimeFormatterBuilder, true);
        return this;
    }

    public DateTimeFormatterBuilder G(int i10) {
        return H(i10, b5.a.O);
    }

    public DateTimeFormatterBuilder H(int i10, char c10) {
        if (i10 < 1) {
            throw new IllegalArgumentException("The pad width must be at least one but was " + i10);
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.f29538a;
        dateTimeFormatterBuilder.f29542e = i10;
        dateTimeFormatterBuilder.f29543f = c10;
        dateTimeFormatterBuilder.f29544g = -1;
        return this;
    }

    public DateTimeFormatterBuilder I() {
        g(SettingsParser.INSENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder J() {
        g(SettingsParser.SENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder K(ij.f fVar, long j10) {
        hj.d.j(fVar, "field");
        g(new i(fVar, j10));
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void L(char r8, int r9, ij.f r10) {
        /*
            Method dump skipped, instructions count: 586
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.format.DateTimeFormatterBuilder.L(char, int, ij.f):void");
    }

    public DateTimeFormatterBuilder M() {
        g(SettingsParser.LENIENT);
        return this;
    }

    public final void N(String str) {
        int i10;
        int i11 = 0;
        while (i11 < str.length()) {
            char charAt = str.charAt(i11);
            if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
                int i12 = i11 + 1;
                while (i12 < str.length() && str.charAt(i12) == charAt) {
                    i12++;
                }
                int i13 = i12 - i11;
                if (charAt == 'p') {
                    if (i12 >= str.length() || (((charAt = str.charAt(i12)) < 'A' || charAt > 'Z') && (charAt < 'a' || charAt > 'z'))) {
                        i10 = i13;
                        i13 = 0;
                    } else {
                        int i14 = i12 + 1;
                        while (i14 < str.length() && str.charAt(i14) == charAt) {
                            i14++;
                        }
                        i10 = i14 - i12;
                        i12 = i14;
                    }
                    if (i13 == 0) {
                        throw new IllegalArgumentException("Pad letter 'p' must be followed by valid pad pattern: " + str);
                    }
                    G(i13);
                    i13 = i10;
                }
                ij.f fVar = f29536i.get(Character.valueOf(charAt));
                if (fVar != null) {
                    L(charAt, i13, fVar);
                } else if (charAt == 'z') {
                    if (i13 > 4) {
                        throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                    }
                    if (i13 == 4) {
                        B(TextStyle.FULL);
                    } else {
                        B(TextStyle.SHORT);
                    }
                } else if (charAt != 'V') {
                    String str2 = "+0000";
                    if (charAt == 'Z') {
                        if (i13 < 4) {
                            l("+HHMM", "+0000");
                        } else if (i13 == 4) {
                            k(TextStyle.FULL);
                        } else {
                            if (i13 != 5) {
                                throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                            }
                            l("+HH:MM:ss", "Z");
                        }
                    } else if (charAt == 'O') {
                        if (i13 == 1) {
                            k(TextStyle.SHORT);
                        } else {
                            if (i13 != 4) {
                                throw new IllegalArgumentException("Pattern letter count must be 1 or 4: " + charAt);
                            }
                            k(TextStyle.FULL);
                        }
                    } else if (charAt == 'X') {
                        if (i13 > 5) {
                            throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                        }
                        l(o.f29570d[i13 + (i13 == 1 ? 0 : 1)], "Z");
                    } else if (charAt == 'x') {
                        if (i13 > 5) {
                            throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                        }
                        if (i13 == 1) {
                            str2 = "+00";
                        } else if (i13 % 2 != 0) {
                            str2 = "+00:00";
                        }
                        l(o.f29570d[i13 + (i13 == 1 ? 0 : 1)], str2);
                    } else if (charAt == 'W') {
                        if (i13 > 1) {
                            throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                        }
                        g(new t('W', i13));
                    } else if (charAt == 'w') {
                        if (i13 > 2) {
                            throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                        }
                        g(new t('w', i13));
                    } else {
                        if (charAt != 'Y') {
                            throw new IllegalArgumentException("Unknown pattern letter: " + charAt);
                        }
                        g(new t('Y', i13));
                    }
                } else {
                    if (i13 != 2) {
                        throw new IllegalArgumentException("Pattern letter count must be 2: " + charAt);
                    }
                    y();
                }
                i11 = i12 - 1;
            } else if (charAt == '\'') {
                int i15 = i11 + 1;
                int i16 = i15;
                while (i16 < str.length()) {
                    if (str.charAt(i16) == '\'') {
                        int i17 = i16 + 1;
                        if (i17 >= str.length() || str.charAt(i17) != '\'') {
                            break;
                        } else {
                            i16 = i17;
                        }
                    }
                    i16++;
                }
                if (i16 >= str.length()) {
                    throw new IllegalArgumentException("Pattern ends with an incomplete string literal: " + str);
                }
                String substring = str.substring(i15, i16);
                if (substring.length() == 0) {
                    h('\'');
                } else {
                    i(substring.replace("''", "'"));
                }
                i11 = i16;
            } else if (charAt == '[') {
                F();
            } else if (charAt == ']') {
                if (this.f29538a.f29539b == null) {
                    throw new IllegalArgumentException("Pattern invalid as it contains ] without previous [");
                }
                E();
            } else {
                if (charAt == '{' || charAt == '}' || charAt == '#') {
                    throw new IllegalArgumentException("Pattern includes reserved character: '" + charAt + "'");
                }
                h(charAt);
            }
            i11++;
        }
    }

    public DateTimeFormatterBuilder O() {
        g(SettingsParser.STRICT);
        return this;
    }

    public DateTimeFormatter P() {
        return Q(Locale.getDefault());
    }

    public DateTimeFormatter Q(Locale locale) {
        hj.d.j(locale, "locale");
        while (this.f29538a.f29539b != null) {
            E();
        }
        return new DateTimeFormatter(new g(this.f29540c, false), locale, gj.e.f26296e, ResolverStyle.SMART, null, null, null);
    }

    public DateTimeFormatter R(ResolverStyle resolverStyle) {
        return P().I(resolverStyle);
    }

    public DateTimeFormatterBuilder a(DateTimeFormatter dateTimeFormatter) {
        hj.d.j(dateTimeFormatter, "formatter");
        g(dateTimeFormatter.C(false));
        return this;
    }

    public DateTimeFormatterBuilder b() {
        g(new f(null));
        return this;
    }

    public DateTimeFormatterBuilder c(TextStyle textStyle) {
        hj.d.j(textStyle, "textStyle");
        g(new f(textStyle));
        return this;
    }

    public DateTimeFormatterBuilder d(ij.f fVar, int i10, int i11, boolean z10) {
        g(new j(fVar, i10, i11, z10));
        return this;
    }

    public DateTimeFormatterBuilder e() {
        g(new k(-2));
        return this;
    }

    public DateTimeFormatterBuilder f(int i10) {
        if (i10 >= -1 && i10 <= 9) {
            g(new k(i10));
            return this;
        }
        throw new IllegalArgumentException("Invalid fractional digits: " + i10);
    }

    public final int g(h hVar) {
        hj.d.j(hVar, "pp");
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.f29538a;
        int i10 = dateTimeFormatterBuilder.f29542e;
        if (i10 > 0) {
            if (hVar != null) {
                hVar = new p(hVar, i10, dateTimeFormatterBuilder.f29543f);
            }
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.f29538a;
            dateTimeFormatterBuilder2.f29542e = 0;
            dateTimeFormatterBuilder2.f29543f = (char) 0;
        }
        this.f29538a.f29540c.add(hVar);
        this.f29538a.f29544g = -1;
        return r4.f29540c.size() - 1;
    }

    public DateTimeFormatterBuilder h(char c10) {
        g(new e(c10));
        return this;
    }

    public DateTimeFormatterBuilder i(String str) {
        hj.d.j(str, "literal");
        if (str.length() > 0) {
            if (str.length() == 1) {
                g(new e(str.charAt(0)));
            } else {
                g(new r(str));
            }
        }
        return this;
    }

    public DateTimeFormatterBuilder j(FormatStyle formatStyle, FormatStyle formatStyle2) {
        if (formatStyle == null && formatStyle2 == null) {
            throw new IllegalArgumentException("Either the date or time style must be non-null");
        }
        g(new m(formatStyle, formatStyle2));
        return this;
    }

    public DateTimeFormatterBuilder k(TextStyle textStyle) {
        hj.d.j(textStyle, "style");
        if (textStyle != TextStyle.FULL && textStyle != TextStyle.SHORT) {
            throw new IllegalArgumentException("Style must be either full or short");
        }
        g(new l(textStyle));
        return this;
    }

    public DateTimeFormatterBuilder l(String str, String str2) {
        g(new o(str2, str));
        return this;
    }

    public DateTimeFormatterBuilder m() {
        g(o.f29571e);
        return this;
    }

    public DateTimeFormatterBuilder n(DateTimeFormatter dateTimeFormatter) {
        hj.d.j(dateTimeFormatter, "formatter");
        g(dateTimeFormatter.C(true));
        return this;
    }

    public DateTimeFormatterBuilder o(String str) {
        hj.d.j(str, "pattern");
        N(str);
        return this;
    }

    public DateTimeFormatterBuilder p(ij.f fVar) {
        return r(fVar, TextStyle.FULL);
    }

    public DateTimeFormatterBuilder q(ij.f fVar, Map<Long, String> map) {
        hj.d.j(fVar, "field");
        hj.d.j(map, "textLookup");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        TextStyle textStyle = TextStyle.FULL;
        g(new s(fVar, textStyle, new b(new c.b(Collections.singletonMap(textStyle, linkedHashMap)))));
        return this;
    }

    public DateTimeFormatterBuilder r(ij.f fVar, TextStyle textStyle) {
        hj.d.j(fVar, "field");
        hj.d.j(textStyle, "textStyle");
        g(new s(fVar, textStyle, org.threeten.bp.format.b.b()));
        return this;
    }

    public DateTimeFormatterBuilder s(ij.f fVar) {
        hj.d.j(fVar, "field");
        v(new n(fVar, 1, 19, SignStyle.NORMAL));
        return this;
    }

    public DateTimeFormatterBuilder t(ij.f fVar, int i10) {
        hj.d.j(fVar, "field");
        if (i10 >= 1 && i10 <= 19) {
            v(new n(fVar, i10, i10, SignStyle.NOT_NEGATIVE));
            return this;
        }
        throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i10);
    }

    public DateTimeFormatterBuilder u(ij.f fVar, int i10, int i11, SignStyle signStyle) {
        if (i10 == i11 && signStyle == SignStyle.NOT_NEGATIVE) {
            return t(fVar, i11);
        }
        hj.d.j(fVar, "field");
        hj.d.j(signStyle, "signStyle");
        if (i10 < 1 || i10 > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i10);
        }
        if (i11 < 1 || i11 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i11);
        }
        if (i11 >= i10) {
            v(new n(fVar, i10, i11, signStyle));
            return this;
        }
        throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i11 + " < " + i10);
    }

    public final DateTimeFormatterBuilder v(n nVar) {
        n d10;
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.f29538a;
        int i10 = dateTimeFormatterBuilder.f29544g;
        if (i10 < 0 || !(dateTimeFormatterBuilder.f29540c.get(i10) instanceof n)) {
            this.f29538a.f29544g = g(nVar);
        } else {
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.f29538a;
            int i11 = dateTimeFormatterBuilder2.f29544g;
            n nVar2 = (n) dateTimeFormatterBuilder2.f29540c.get(i11);
            int i12 = nVar.f29566c;
            int i13 = nVar.f29567d;
            if (i12 == i13 && nVar.f29568e == SignStyle.NOT_NEGATIVE) {
                d10 = nVar2.e(i13);
                g(nVar.d());
                this.f29538a.f29544g = i11;
            } else {
                d10 = nVar2.d();
                this.f29538a.f29544g = g(nVar);
            }
            this.f29538a.f29540c.set(i11, d10);
        }
        return this;
    }

    public DateTimeFormatterBuilder w(ij.f fVar, int i10, int i11, int i12) {
        hj.d.j(fVar, "field");
        v(new q(fVar, i10, i11, i12, null));
        return this;
    }

    public DateTimeFormatterBuilder x(ij.f fVar, int i10, int i11, org.threeten.bp.chrono.a aVar) {
        hj.d.j(fVar, "field");
        hj.d.j(aVar, "baseDate");
        v(new q(fVar, i10, i11, 0, aVar));
        return this;
    }

    public DateTimeFormatterBuilder y() {
        g(new u(ij.g.g(), "ZoneId()"));
        return this;
    }

    public DateTimeFormatterBuilder z() {
        g(new u(ij.g.f(), "ZoneOrOffsetId()"));
        return this;
    }

    public DateTimeFormatterBuilder(DateTimeFormatterBuilder dateTimeFormatterBuilder, boolean z10) {
        this.f29538a = this;
        this.f29540c = new ArrayList();
        this.f29544g = -1;
        this.f29539b = dateTimeFormatterBuilder;
        this.f29541d = z10;
    }

    public static final class q extends n {

        /* renamed from: j */
        public static final LocalDate f29578j = LocalDate.of(2000, 1, 1);

        /* renamed from: h */
        public final int f29579h;

        /* renamed from: i */
        public final org.threeten.bp.chrono.a f29580i;

        public q(ij.f fVar, int i10, int i11, int i12, org.threeten.bp.chrono.a aVar) {
            super(fVar, i10, i11, SignStyle.NOT_NEGATIVE);
            if (i10 < 1 || i10 > 10) {
                throw new IllegalArgumentException("The width must be from 1 to 10 inclusive but was " + i10);
            }
            if (i11 < 1 || i11 > 10) {
                throw new IllegalArgumentException("The maxWidth must be from 1 to 10 inclusive but was " + i11);
            }
            if (i11 < i10) {
                throw new IllegalArgumentException("The maxWidth must be greater than the width");
            }
            if (aVar == null) {
                long j10 = i12;
                if (!fVar.range().isValidValue(j10)) {
                    throw new IllegalArgumentException("The base value must be within the range of the field");
                }
                if (j10 + n.f29564g[i10] > 2147483647L) {
                    throw new DateTimeException("Unable to add printer-parser as the range exceeds the capacity of an int");
                }
            }
            this.f29579h = i12;
            this.f29580i = aVar;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.n
        public long a(gj.d dVar, long j10) {
            long abs = Math.abs(j10);
            int i10 = this.f29579h;
            if (this.f29580i != null) {
                i10 = org.threeten.bp.chrono.b.from(dVar.e()).date(this.f29580i).get(this.f29565b);
            }
            if (j10 >= i10) {
                int i11 = n.f29564g[this.f29566c];
                if (j10 < i10 + i11) {
                    return abs % i11;
                }
            }
            return abs % n.f29564g[this.f29567d];
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.n
        public boolean b(org.threeten.bp.format.a aVar) {
            if (aVar.m()) {
                return super.b(aVar);
            }
            return false;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.n
        public int c(org.threeten.bp.format.a aVar, long j10, int i10, int i11) {
            int i12 = this.f29579h;
            if (this.f29580i != null) {
                i12 = aVar.h().date(this.f29580i).get(this.f29565b);
                aVar.b(this, j10, i10, i11);
            }
            int i13 = i11 - i10;
            int i14 = this.f29566c;
            if (i13 == i14 && j10 >= 0) {
                long j11 = n.f29564g[i14];
                long j12 = i12;
                long j13 = j12 - (j12 % j11);
                j10 = i12 > 0 ? j13 + j10 : j13 - j10;
                if (j10 < j12) {
                    j10 += j11;
                }
            }
            return aVar.r(this.f29565b, j10, i10, i11);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.n
        public n d() {
            return this.f29569f == -1 ? this : new q(this.f29565b, this.f29566c, this.f29567d, this.f29579h, this.f29580i, -1);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.n
        /* renamed from: f */
        public q e(int i10) {
            return new q(this.f29565b, this.f29566c, this.f29567d, this.f29579h, this.f29580i, this.f29569f + i10);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.n
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ReducedValue(");
            sb2.append(this.f29565b);
            sb2.append(",");
            sb2.append(this.f29566c);
            sb2.append(",");
            sb2.append(this.f29567d);
            sb2.append(",");
            Object obj = this.f29580i;
            if (obj == null) {
                obj = Integer.valueOf(this.f29579h);
            }
            sb2.append(obj);
            sb2.append(")");
            return sb2.toString();
        }

        public q(ij.f fVar, int i10, int i11, int i12, org.threeten.bp.chrono.a aVar, int i13) {
            super(fVar, i10, i11, SignStyle.NOT_NEGATIVE, i13, null);
            this.f29579h = i12;
            this.f29580i = aVar;
        }
    }
}
