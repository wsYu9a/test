package b.h.a.e;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a */
    private static final String[] f4973a = {null, null, null, null, null, null, null, null, null, null, "9.0", "9.5", "10.0", "10.5", null};

    public static final class a {

        /* renamed from: a */
        public static final String f4974a = d.d("ro.rom.version");
    }

    public static int a() {
        Log.v("BrandPBuild", " getOSVERSION " + a.f4974a);
        for (int length = f4973a.length + (-2); length >= 0; length--) {
            StringBuilder sb = new StringBuilder(" VERSIONS[ ");
            sb.append(length);
            sb.append("]");
            String[] strArr = f4973a;
            sb.append(strArr[length]);
            Log.v("BrandPBuild", sb.toString());
            String str = a.f4974a;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(strArr[length])) {
                if (!str.startsWith(strArr[length])) {
                    if (!str.startsWith(g.o + strArr[length])) {
                        if (str.startsWith(g.p + strArr[length])) {
                        }
                    }
                }
                return length + 1;
            }
        }
        return 0;
    }

    public static String c() {
        return d("ro.rom.version");
    }

    public static String d(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, EnvironmentCompat.MEDIA_UNKNOWN);
        } catch (Exception e2) {
            if (!b.h.a.c.j()) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
            e2.printStackTrace();
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }
}
