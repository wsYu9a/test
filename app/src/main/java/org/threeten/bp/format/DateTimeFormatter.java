package org.threeten.bp.format;

import com.martian.libmars.widget.FoldedTextView;
import gj.e;
import ij.f;
import ij.h;
import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import m5.d;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.a;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;

/* loaded from: classes4.dex */
public final class DateTimeFormatter {

    /* renamed from: h */
    public static final DateTimeFormatter f29511h;

    /* renamed from: i */
    public static final DateTimeFormatter f29512i;

    /* renamed from: j */
    public static final DateTimeFormatter f29513j;

    /* renamed from: k */
    public static final DateTimeFormatter f29514k;

    /* renamed from: l */
    public static final DateTimeFormatter f29515l;

    /* renamed from: m */
    public static final DateTimeFormatter f29516m;

    /* renamed from: n */
    public static final DateTimeFormatter f29517n;

    /* renamed from: o */
    public static final DateTimeFormatter f29518o;

    /* renamed from: p */
    public static final DateTimeFormatter f29519p;

    /* renamed from: q */
    public static final DateTimeFormatter f29520q;

    /* renamed from: r */
    public static final DateTimeFormatter f29521r;

    /* renamed from: s */
    public static final DateTimeFormatter f29522s;

    /* renamed from: t */
    public static final DateTimeFormatter f29523t;

    /* renamed from: u */
    public static final DateTimeFormatter f29524u;

    /* renamed from: v */
    public static final DateTimeFormatter f29525v;

    /* renamed from: w */
    public static final h<Period> f29526w;

    /* renamed from: x */
    public static final h<Boolean> f29527x;

    /* renamed from: a */
    public final DateTimeFormatterBuilder.g f29528a;

    /* renamed from: b */
    public final Locale f29529b;

    /* renamed from: c */
    public final e f29530c;

    /* renamed from: d */
    public final ResolverStyle f29531d;

    /* renamed from: e */
    public final Set<f> f29532e;

    /* renamed from: f */
    public final org.threeten.bp.chrono.b f29533f;

    /* renamed from: g */
    public final ZoneId f29534g;

    public class a implements h<Period> {
        @Override // ij.h
        /* renamed from: b */
        public Period a(ij.b bVar) {
            return bVar instanceof gj.a ? ((gj.a) bVar).f26287h : Period.ZERO;
        }
    }

    public class b implements h<Boolean> {
        @Override // ij.h
        /* renamed from: b */
        public Boolean a(ij.b bVar) {
            return bVar instanceof gj.a ? Boolean.valueOf(((gj.a) bVar).f26286g) : Boolean.FALSE;
        }
    }

    static {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        ChronoField chronoField = ChronoField.YEAR;
        SignStyle signStyle = SignStyle.EXCEEDS_PAD;
        DateTimeFormatterBuilder h10 = dateTimeFormatterBuilder.u(chronoField, 4, 10, signStyle).h('-');
        ChronoField chronoField2 = ChronoField.MONTH_OF_YEAR;
        DateTimeFormatterBuilder h11 = h10.t(chronoField2, 2).h('-');
        ChronoField chronoField3 = ChronoField.DAY_OF_MONTH;
        DateTimeFormatterBuilder t10 = h11.t(chronoField3, 2);
        ResolverStyle resolverStyle = ResolverStyle.STRICT;
        DateTimeFormatter R = t10.R(resolverStyle);
        IsoChronology isoChronology = IsoChronology.INSTANCE;
        DateTimeFormatter D = R.D(isoChronology);
        f29511h = D;
        f29512i = new DateTimeFormatterBuilder().I().a(D).m().R(resolverStyle).D(isoChronology);
        f29513j = new DateTimeFormatterBuilder().I().a(D).F().m().R(resolverStyle).D(isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilder2 = new DateTimeFormatterBuilder();
        ChronoField chronoField4 = ChronoField.HOUR_OF_DAY;
        DateTimeFormatterBuilder h12 = dateTimeFormatterBuilder2.t(chronoField4, 2).h(d.f28378d);
        ChronoField chronoField5 = ChronoField.MINUTE_OF_HOUR;
        DateTimeFormatterBuilder h13 = h12.t(chronoField5, 2).F().h(d.f28378d);
        ChronoField chronoField6 = ChronoField.SECOND_OF_MINUTE;
        DateTimeFormatter R2 = h13.t(chronoField6, 2).F().d(ChronoField.NANO_OF_SECOND, 0, 9, true).R(resolverStyle);
        f29514k = R2;
        f29515l = new DateTimeFormatterBuilder().I().a(R2).m().R(resolverStyle);
        f29516m = new DateTimeFormatterBuilder().I().a(R2).F().m().R(resolverStyle);
        DateTimeFormatter D2 = new DateTimeFormatterBuilder().I().a(D).h('T').a(R2).R(resolverStyle).D(isoChronology);
        f29517n = D2;
        DateTimeFormatter D3 = new DateTimeFormatterBuilder().I().a(D2).m().R(resolverStyle).D(isoChronology);
        f29518o = D3;
        f29519p = new DateTimeFormatterBuilder().a(D3).F().h('[').J().A().h(']').R(resolverStyle).D(isoChronology);
        f29520q = new DateTimeFormatterBuilder().a(D2).F().m().F().h('[').J().A().h(']').R(resolverStyle).D(isoChronology);
        f29521r = new DateTimeFormatterBuilder().I().u(chronoField, 4, 10, signStyle).h('-').t(ChronoField.DAY_OF_YEAR, 3).F().m().R(resolverStyle).D(isoChronology);
        DateTimeFormatterBuilder h14 = new DateTimeFormatterBuilder().I().u(IsoFields.f29619d, 4, 10, signStyle).i("-W").t(IsoFields.f29618c, 2).h('-');
        ChronoField chronoField7 = ChronoField.DAY_OF_WEEK;
        f29522s = h14.t(chronoField7, 1).F().m().R(resolverStyle).D(isoChronology);
        f29523t = new DateTimeFormatterBuilder().I().e().R(resolverStyle);
        f29524u = new DateTimeFormatterBuilder().I().t(chronoField, 4).t(chronoField2, 2).t(chronoField3, 2).F().l("+HHMMss", "Z").R(resolverStyle).D(isoChronology);
        HashMap hashMap = new HashMap();
        hashMap.put(1L, "Mon");
        hashMap.put(2L, "Tue");
        hashMap.put(3L, "Wed");
        hashMap.put(4L, "Thu");
        hashMap.put(5L, "Fri");
        hashMap.put(6L, "Sat");
        hashMap.put(7L, "Sun");
        HashMap hashMap2 = new HashMap();
        hashMap2.put(1L, "Jan");
        hashMap2.put(2L, "Feb");
        hashMap2.put(3L, "Mar");
        hashMap2.put(4L, "Apr");
        hashMap2.put(5L, "May");
        hashMap2.put(6L, "Jun");
        hashMap2.put(7L, "Jul");
        hashMap2.put(8L, "Aug");
        hashMap2.put(9L, "Sep");
        hashMap2.put(10L, "Oct");
        hashMap2.put(11L, "Nov");
        hashMap2.put(12L, "Dec");
        f29525v = new DateTimeFormatterBuilder().I().M().F().q(chronoField7, hashMap).i(", ").E().u(chronoField3, 1, 2, SignStyle.NOT_NEGATIVE).h(b5.a.O).q(chronoField2, hashMap2).h(b5.a.O).t(chronoField, 4).h(b5.a.O).t(chronoField4, 2).h(d.f28378d).t(chronoField5, 2).F().h(d.f28378d).t(chronoField6, 2).E().h(b5.a.O).l("+HHMM", "GMT").R(ResolverStyle.SMART).D(isoChronology);
        f29526w = new a();
        f29527x = new b();
    }

    public DateTimeFormatter(DateTimeFormatterBuilder.g gVar, Locale locale, e eVar, ResolverStyle resolverStyle, Set<f> set, org.threeten.bp.chrono.b bVar, ZoneId zoneId) {
        this.f29528a = (DateTimeFormatterBuilder.g) hj.d.j(gVar, "printerParser");
        this.f29529b = (Locale) hj.d.j(locale, "locale");
        this.f29530c = (e) hj.d.j(eVar, "decimalStyle");
        this.f29531d = (ResolverStyle) hj.d.j(resolverStyle, "resolverStyle");
        this.f29532e = set;
        this.f29533f = bVar;
        this.f29534g = zoneId;
    }

    public static DateTimeFormatter l(FormatStyle formatStyle) {
        hj.d.j(formatStyle, "dateStyle");
        return new DateTimeFormatterBuilder().j(formatStyle, null).P().D(IsoChronology.INSTANCE);
    }

    public static DateTimeFormatter m(FormatStyle formatStyle) {
        hj.d.j(formatStyle, "dateTimeStyle");
        return new DateTimeFormatterBuilder().j(formatStyle, formatStyle).P().D(IsoChronology.INSTANCE);
    }

    public static DateTimeFormatter n(FormatStyle formatStyle, FormatStyle formatStyle2) {
        hj.d.j(formatStyle, "dateStyle");
        hj.d.j(formatStyle2, "timeStyle");
        return new DateTimeFormatterBuilder().j(formatStyle, formatStyle2).P().D(IsoChronology.INSTANCE);
    }

    public static DateTimeFormatter o(FormatStyle formatStyle) {
        hj.d.j(formatStyle, "timeStyle");
        return new DateTimeFormatterBuilder().j(null, formatStyle).P().D(IsoChronology.INSTANCE);
    }

    public static DateTimeFormatter p(String str) {
        return new DateTimeFormatterBuilder().o(str).P();
    }

    public static DateTimeFormatter q(String str, Locale locale) {
        return new DateTimeFormatterBuilder().o(str).Q(locale);
    }

    public static final h<Period> y() {
        return f29526w;
    }

    public static final h<Boolean> z() {
        return f29527x;
    }

    public Format A() {
        return new ClassicFormat(this, null);
    }

    public Format B(h<?> hVar) {
        hj.d.j(hVar, "query");
        return new ClassicFormat(this, hVar);
    }

    public DateTimeFormatterBuilder.g C(boolean z10) {
        return this.f29528a.a(z10);
    }

    public DateTimeFormatter D(org.threeten.bp.chrono.b bVar) {
        return hj.d.c(this.f29533f, bVar) ? this : new DateTimeFormatter(this.f29528a, this.f29529b, this.f29530c, this.f29531d, this.f29532e, bVar, this.f29534g);
    }

    public DateTimeFormatter E(e eVar) {
        return this.f29530c.equals(eVar) ? this : new DateTimeFormatter(this.f29528a, this.f29529b, eVar, this.f29531d, this.f29532e, this.f29533f, this.f29534g);
    }

    public DateTimeFormatter F(Locale locale) {
        return this.f29529b.equals(locale) ? this : new DateTimeFormatter(this.f29528a, locale, this.f29530c, this.f29531d, this.f29532e, this.f29533f, this.f29534g);
    }

    public DateTimeFormatter G(Set<f> set) {
        if (set == null) {
            return new DateTimeFormatter(this.f29528a, this.f29529b, this.f29530c, this.f29531d, null, this.f29533f, this.f29534g);
        }
        if (hj.d.c(this.f29532e, set)) {
            return this;
        }
        return new DateTimeFormatter(this.f29528a, this.f29529b, this.f29530c, this.f29531d, Collections.unmodifiableSet(new HashSet(set)), this.f29533f, this.f29534g);
    }

    public DateTimeFormatter H(f... fVarArr) {
        if (fVarArr == null) {
            return new DateTimeFormatter(this.f29528a, this.f29529b, this.f29530c, this.f29531d, null, this.f29533f, this.f29534g);
        }
        HashSet hashSet = new HashSet(Arrays.asList(fVarArr));
        if (hj.d.c(this.f29532e, hashSet)) {
            return this;
        }
        return new DateTimeFormatter(this.f29528a, this.f29529b, this.f29530c, this.f29531d, Collections.unmodifiableSet(hashSet), this.f29533f, this.f29534g);
    }

    public DateTimeFormatter I(ResolverStyle resolverStyle) {
        hj.d.j(resolverStyle, "resolverStyle");
        return hj.d.c(this.f29531d, resolverStyle) ? this : new DateTimeFormatter(this.f29528a, this.f29529b, this.f29530c, resolverStyle, this.f29532e, this.f29533f, this.f29534g);
    }

    public DateTimeFormatter J(ZoneId zoneId) {
        return hj.d.c(this.f29534g, zoneId) ? this : new DateTimeFormatter(this.f29528a, this.f29529b, this.f29530c, this.f29531d, this.f29532e, this.f29533f, zoneId);
    }

    public final DateTimeParseException c(CharSequence charSequence, RuntimeException runtimeException) {
        String charSequence2;
        if (charSequence.length() > 64) {
            charSequence2 = charSequence.subSequence(0, 64).toString() + FoldedTextView.f12585y;
        } else {
            charSequence2 = charSequence.toString();
        }
        return new DateTimeParseException("Text '" + charSequence2 + "' could not be parsed: " + runtimeException.getMessage(), charSequence, 0, runtimeException);
    }

    public String d(ij.b bVar) {
        StringBuilder sb2 = new StringBuilder(32);
        e(bVar, sb2);
        return sb2.toString();
    }

    public void e(ij.b bVar, Appendable appendable) {
        hj.d.j(bVar, "temporal");
        hj.d.j(appendable, "appendable");
        try {
            gj.d dVar = new gj.d(bVar, this);
            if (appendable instanceof StringBuilder) {
                this.f29528a.print(dVar, (StringBuilder) appendable);
                return;
            }
            StringBuilder sb2 = new StringBuilder(32);
            this.f29528a.print(dVar, sb2);
            appendable.append(sb2);
        } catch (IOException e10) {
            throw new DateTimeException(e10.getMessage(), e10);
        }
    }

    public org.threeten.bp.chrono.b f() {
        return this.f29533f;
    }

    public e g() {
        return this.f29530c;
    }

    public Locale h() {
        return this.f29529b;
    }

    public Set<f> i() {
        return this.f29532e;
    }

    public ResolverStyle j() {
        return this.f29531d;
    }

    public ZoneId k() {
        return this.f29534g;
    }

    public ij.b r(CharSequence charSequence) {
        hj.d.j(charSequence, "text");
        try {
            return v(charSequence, null).n(this.f29531d, this.f29532e);
        } catch (DateTimeParseException e10) {
            throw e10;
        } catch (RuntimeException e11) {
            throw c(charSequence, e11);
        }
    }

    public ij.b s(CharSequence charSequence, ParsePosition parsePosition) {
        hj.d.j(charSequence, "text");
        hj.d.j(parsePosition, id.c.f26972i);
        try {
            return v(charSequence, parsePosition).n(this.f29531d, this.f29532e);
        } catch (IndexOutOfBoundsException e10) {
            throw e10;
        } catch (DateTimeParseException e11) {
            throw e11;
        } catch (RuntimeException e12) {
            throw c(charSequence, e12);
        }
    }

    public <T> T t(CharSequence charSequence, h<T> hVar) {
        hj.d.j(charSequence, "text");
        hj.d.j(hVar, "type");
        try {
            return (T) v(charSequence, null).n(this.f29531d, this.f29532e).d(hVar);
        } catch (DateTimeParseException e10) {
            throw e10;
        } catch (RuntimeException e11) {
            throw c(charSequence, e11);
        }
    }

    public String toString() {
        String gVar = this.f29528a.toString();
        return gVar.startsWith("[") ? gVar : gVar.substring(1, gVar.length() - 1);
    }

    public ij.b u(CharSequence charSequence, h<?>... hVarArr) {
        hj.d.j(charSequence, "text");
        hj.d.j(hVarArr, "types");
        if (hVarArr.length < 2) {
            throw new IllegalArgumentException("At least two types must be specified");
        }
        try {
            gj.a n10 = v(charSequence, null).n(this.f29531d, this.f29532e);
            for (h<?> hVar : hVarArr) {
                try {
                    return (ij.b) n10.d(hVar);
                } catch (RuntimeException unused) {
                }
            }
            throw new DateTimeException("Unable to convert parsed text to any specified type: " + Arrays.toString(hVarArr));
        } catch (DateTimeParseException e10) {
            throw e10;
        } catch (RuntimeException e11) {
            throw c(charSequence, e11);
        }
    }

    public final gj.a v(CharSequence charSequence, ParsePosition parsePosition) {
        String charSequence2;
        ParsePosition parsePosition2 = parsePosition != null ? parsePosition : new ParsePosition(0);
        a.b x10 = x(charSequence, parsePosition2);
        if (x10 != null && parsePosition2.getErrorIndex() < 0 && (parsePosition != null || parsePosition2.getIndex() >= charSequence.length())) {
            return x10.b();
        }
        if (charSequence.length() > 64) {
            charSequence2 = charSequence.subSequence(0, 64).toString() + FoldedTextView.f12585y;
        } else {
            charSequence2 = charSequence.toString();
        }
        if (parsePosition2.getErrorIndex() >= 0) {
            throw new DateTimeParseException("Text '" + charSequence2 + "' could not be parsed at index " + parsePosition2.getErrorIndex(), charSequence, parsePosition2.getErrorIndex());
        }
        throw new DateTimeParseException("Text '" + charSequence2 + "' could not be parsed, unparsed text found at index " + parsePosition2.getIndex(), charSequence, parsePosition2.getIndex());
    }

    public ij.b w(CharSequence charSequence, ParsePosition parsePosition) {
        return x(charSequence, parsePosition);
    }

    public final a.b x(CharSequence charSequence, ParsePosition parsePosition) {
        hj.d.j(charSequence, "text");
        hj.d.j(parsePosition, id.c.f26972i);
        org.threeten.bp.format.a aVar = new org.threeten.bp.format.a(this);
        int parse = this.f29528a.parse(aVar, charSequence, parsePosition.getIndex());
        if (parse < 0) {
            parsePosition.setErrorIndex(~parse);
            return null;
        }
        parsePosition.setIndex(parse);
        return aVar.w();
    }

    public static class ClassicFormat extends Format {
        private final DateTimeFormatter formatter;
        private final h<?> query;

        public ClassicFormat(DateTimeFormatter dateTimeFormatter, h<?> hVar) {
            this.formatter = dateTimeFormatter;
            this.query = hVar;
        }

        @Override // java.text.Format
        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            hj.d.j(obj, "obj");
            hj.d.j(stringBuffer, "toAppendTo");
            hj.d.j(fieldPosition, "pos");
            if (!(obj instanceof ij.b)) {
                throw new IllegalArgumentException("Format target must implement TemporalAccessor");
            }
            fieldPosition.setBeginIndex(0);
            fieldPosition.setEndIndex(0);
            try {
                this.formatter.e((ij.b) obj, stringBuffer);
                return stringBuffer;
            } catch (RuntimeException e10) {
                throw new IllegalArgumentException(e10.getMessage(), e10);
            }
        }

        @Override // java.text.Format
        public Object parseObject(String str) throws ParseException {
            hj.d.j(str, "text");
            try {
                h<?> hVar = this.query;
                return hVar == null ? this.formatter.v(str, null).n(this.formatter.j(), this.formatter.i()) : this.formatter.t(str, hVar);
            } catch (DateTimeParseException e10) {
                throw new ParseException(e10.getMessage(), e10.getErrorIndex());
            } catch (RuntimeException e11) {
                throw ((ParseException) new ParseException(e11.getMessage(), 0).initCause(e11));
            }
        }

        @Override // java.text.Format
        public Object parseObject(String str, ParsePosition parsePosition) {
            hj.d.j(str, "text");
            try {
                a.b x10 = this.formatter.x(str, parsePosition);
                if (x10 == null) {
                    if (parsePosition.getErrorIndex() < 0) {
                        parsePosition.setErrorIndex(0);
                    }
                    return null;
                }
                try {
                    gj.a n10 = x10.b().n(this.formatter.j(), this.formatter.i());
                    h<?> hVar = this.query;
                    return hVar == null ? n10 : n10.d(hVar);
                } catch (RuntimeException unused) {
                    parsePosition.setErrorIndex(0);
                    return null;
                }
            } catch (IndexOutOfBoundsException unused2) {
                if (parsePosition.getErrorIndex() < 0) {
                    parsePosition.setErrorIndex(0);
                }
                return null;
            }
        }
    }
}
