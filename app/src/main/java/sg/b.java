package sg;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: classes4.dex */
public class b {
    public static String a(long j10, String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        return new SimpleDateFormat(str).format(calendar.getTime());
    }
}
