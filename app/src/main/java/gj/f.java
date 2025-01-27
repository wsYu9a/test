package gj;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.FormatStyle;

/* loaded from: classes4.dex */
public final class f extends b {

    /* renamed from: a */
    public static final ConcurrentMap<String, Object> f26302a = new ConcurrentHashMap(16, 0.75f, 2);

    @Override // gj.b
    public Locale[] a() {
        return DateFormat.getAvailableLocales();
    }

    @Override // gj.b
    public DateTimeFormatter b(FormatStyle formatStyle, FormatStyle formatStyle2, org.threeten.bp.chrono.b bVar, Locale locale) {
        if (formatStyle == null && formatStyle2 == null) {
            throw new IllegalArgumentException("Date and Time style must not both be null");
        }
        String str = bVar.getId() + '|' + locale.toString() + '|' + formatStyle + formatStyle2;
        ConcurrentMap<String, Object> concurrentMap = f26302a;
        Object obj = concurrentMap.get(str);
        if (obj != null) {
            if (obj.equals("")) {
                throw new IllegalArgumentException("Unable to convert DateFormat to DateTimeFormatter");
            }
            return (DateTimeFormatter) obj;
        }
        DateFormat dateTimeInstance = formatStyle != null ? formatStyle2 != null ? DateFormat.getDateTimeInstance(d(formatStyle), d(formatStyle2), locale) : DateFormat.getDateInstance(d(formatStyle), locale) : DateFormat.getTimeInstance(d(formatStyle2), locale);
        if (!(dateTimeInstance instanceof SimpleDateFormat)) {
            concurrentMap.putIfAbsent(str, "");
            throw new IllegalArgumentException("Unable to convert DateFormat to DateTimeFormatter");
        }
        DateTimeFormatter Q = new DateTimeFormatterBuilder().o(((SimpleDateFormat) dateTimeInstance).toPattern()).Q(locale);
        concurrentMap.putIfAbsent(str, Q);
        return Q;
    }

    public final int d(FormatStyle formatStyle) {
        return formatStyle.ordinal();
    }
}
