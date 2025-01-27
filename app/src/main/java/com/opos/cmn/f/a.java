package com.opos.cmn.f;

import android.content.Context;
import com.opos.acs.st.InitParams;
import com.opos.acs.st.STManager;
import com.opos.cmn.an.a.b;
import java.util.Map;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: b */
    private static volatile STManager f17012b;

    /* renamed from: a */
    private static final byte[] f17011a = new byte[0];

    /* renamed from: c */
    private static final String f17013c = b.a("Y29tLm9wcG8udW5pb24=");

    public static int a() {
        return c().getSdkVerCode();
    }

    public static String a(Context context) {
        return "";
    }

    public static String a(Context context, String str, Map<String, String> map) {
        if (context == null || map == null || map.size() <= 0) {
            return "";
        }
        try {
            return c().onEvent(context, str, map);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.a("STool", "", th);
            return "";
        }
    }

    public static void a(Context context, String str, String str2) {
        if (context != null) {
            try {
                if (com.opos.cmn.an.c.a.a(str) || (!STManager.BRAND_OF_O.equalsIgnoreCase(str) && !STManager.BRAND_OF_P.equalsIgnoreCase(str) && !STManager.BRAND_OF_R.equalsIgnoreCase(str))) {
                    str = STManager.BRAND_OF_O;
                }
                c().init(context, str, str2, new InitParams.Builder().setPkgName(f17013c).setIsLoganInit(false).build());
                c().init(context, str, str2, new InitParams.Builder().setPkgName("com.opos.dy.mat").setIsLoganInit(false).build());
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.a("STool", "", th);
            }
        }
    }

    public static void b() {
        try {
            c().enableDebugLog();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("STool", "", (Throwable) e2);
        }
    }

    private static STManager c() {
        STManager sTManager = f17012b;
        if (sTManager == null) {
            synchronized (f17011a) {
                sTManager = f17012b;
                if (sTManager == null) {
                    sTManager = STManager.getInstance();
                    f17012b = sTManager;
                }
            }
        }
        return sTManager;
    }
}
