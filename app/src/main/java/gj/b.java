package gj;

import java.util.Locale;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.FormatStyle;

/* loaded from: classes4.dex */
public abstract class b {
    public static b c() {
        return new f();
    }

    public Locale[] a() {
        throw new UnsupportedOperationException();
    }

    public abstract DateTimeFormatter b(FormatStyle formatStyle, FormatStyle formatStyle2, org.threeten.bp.chrono.b bVar, Locale locale);
}
