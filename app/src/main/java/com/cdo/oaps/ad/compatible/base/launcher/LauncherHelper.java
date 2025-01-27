package com.cdo.oaps.ad.compatible.base.launcher;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.cdo.oaps.ad.Launcher;
import com.cdo.oaps.ad.OapsParser;
import com.cdo.oaps.ad.OapsWrapper;
import com.cdo.oaps.ad.a;
import com.cdo.oaps.ad.ad;
import com.cdo.oaps.ad.af;
import com.cdo.oaps.ad.m;
import com.cdo.oaps.ad.p;
import com.cdo.oaps.ad.s;
import com.cdo.oaps.ad.v;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import java.util.Map;

/* loaded from: classes.dex */
public class LauncherHelper {
    private static String a(Context context, String str) {
        return !TextUtils.isEmpty(str) ? ("mk".equals(str) || Launcher.Host.MK_OP.equals(str)) ? (p.b(context, a.b()) || p.b(context, af.f6508e) || !p.b(context, a.a())) ? "mk" : Launcher.Host.MK_OP : str : str;
    }

    public static boolean launchActivity(Context context, String str) {
        return launchActivity(context, OapsParser.decode(str));
    }

    public static boolean launchActivity(Context context, Map<String, Object> map) {
        BaseWrapper.wrapper(map).setHost(a(context, BaseWrapper.wrapper(map).getHost()));
        return m.a(OapsWrapper.wrapper(map).getHost()).a(context, map);
    }

    public static boolean launchService(Context context, String str) {
        return launchService(context, OapsParser.decode(str));
    }

    public static boolean launchService(Context context, Map<String, Object> map) {
        BaseWrapper.wrapper(map).setHost(a(context, BaseWrapper.wrapper(map).getHost()));
        return m.a(OapsWrapper.wrapper(map).getHost()).b(context, map);
    }

    public static boolean support(Context context, String str) {
        String str2;
        String str3 = null;
        try {
            Uri parse = Uri.parse(str);
            str2 = parse.getHost();
            try {
                str3 = parse.getPath();
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
                return support(context, str2, str3);
            }
        } catch (Throwable th2) {
            th = th2;
            str2 = null;
        }
        return support(context, str2, str3);
    }

    public static boolean support(Context context, String str, String str2) {
        if (Launcher.Host.GC.equals(str)) {
            return v.a(context, str2);
        }
        String a2 = a(context, str);
        if ("mk".equals(a2)) {
            return ad.a(context, str2);
        }
        if (Launcher.Host.MK_OP.equals(a2)) {
            return s.a(context, str2);
        }
        return false;
    }
}
