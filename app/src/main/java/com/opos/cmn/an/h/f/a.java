package com.opos.cmn.an.h.f;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.tencent.bugly.beta.tinker.TinkerReport;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    private static int[] f16532a;

    /* renamed from: b */
    private static float f16533b;

    /* renamed from: c */
    private static float f16534c;

    /* renamed from: d */
    private static float f16535d;

    /* renamed from: e */
    private static float f16536e;

    /* renamed from: f */
    private static float f16537f;

    /* renamed from: g */
    private static int f16538g;

    /* renamed from: h */
    private static WindowManager f16539h;

    /* renamed from: i */
    private static float f16540i;

    /* renamed from: j */
    private static float f16541j;
    private static final String k = "com." + com.opos.cmn.an.a.a.f16361e + ".inner.view.WindowManagerWrapper";

    public static int a(Context context, float f2) {
        return context != null ? (int) ((m(context) * f2) + 0.5f) : (int) f2;
    }

    public static WindowManager a(Context context) {
        if (f16539h == null && context != null) {
            f16539h = (WindowManager) context.getApplicationContext().getSystemService("window");
        }
        return f16539h;
    }

    public static void a(Context context, View view) {
        if (context == null || view == null) {
            return;
        }
        try {
            WindowManager a2 = a(context);
            if (a2 != null) {
                a2.removeView(view);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
        }
    }

    public static void a(Context context, View view, WindowManager.LayoutParams layoutParams) {
        if (context == null || view == null || layoutParams == null) {
            return;
        }
        try {
            WindowManager a2 = a(context);
            if (a2 != null) {
                a2.addView(view, layoutParams);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
        }
    }

    public static boolean a() {
        boolean a2 = a(com.opos.cmn.an.a.a.f16357a);
        com.opos.cmn.an.f.a.b("WinMgrTool", "isOPMobile=" + a2);
        return a2;
    }

    public static boolean a(Activity activity) {
        boolean z;
        if (activity != null) {
            try {
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
            }
            if ((activity.getWindow().getAttributes().flags & 1024) == 1024) {
                z = true;
                com.opos.cmn.an.f.a.b("WinMgrTool", "isActivityFullScreen=" + z);
                return z;
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b("WinMgrTool", "isActivityFullScreen=" + z);
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
    
        if (r4.toLowerCase().contains(r7) != false) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r7) {
        /*
            java.lang.String r0 = "WinMgrTool"
            java.lang.String r1 = ""
            boolean r2 = com.opos.cmn.an.c.a.a(r7)     // Catch: java.lang.Exception -> L5e
            if (r2 != 0) goto L62
            java.lang.String r2 = android.os.Build.BRAND     // Catch: java.lang.Exception -> L5e
            if (r2 == 0) goto Lf
            goto L10
        Lf:
            r2 = r1
        L10:
            java.lang.String r3 = android.os.Build.MANUFACTURER     // Catch: java.lang.Exception -> L5e
            if (r3 == 0) goto L15
            goto L16
        L15:
            r3 = r1
        L16:
            java.lang.String r4 = android.os.Build.MODEL     // Catch: java.lang.Exception -> L5e
            if (r4 == 0) goto L1b
            goto L1c
        L1b:
            r4 = r1
        L1c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5e
            r5.<init>()     // Catch: java.lang.Exception -> L5e
            java.lang.String r6 = "brand="
            r5.append(r6)     // Catch: java.lang.Exception -> L5e
            r5.append(r2)     // Catch: java.lang.Exception -> L5e
            java.lang.String r6 = ",manufacturer="
            r5.append(r6)     // Catch: java.lang.Exception -> L5e
            r5.append(r3)     // Catch: java.lang.Exception -> L5e
            java.lang.String r6 = ",model="
            r5.append(r6)     // Catch: java.lang.Exception -> L5e
            r5.append(r4)     // Catch: java.lang.Exception -> L5e
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L5e
            com.opos.cmn.an.f.a.b(r0, r5)     // Catch: java.lang.Exception -> L5e
            boolean r2 = r7.equalsIgnoreCase(r2)     // Catch: java.lang.Exception -> L5e
            if (r2 != 0) goto L5c
            boolean r2 = r7.equalsIgnoreCase(r3)     // Catch: java.lang.Exception -> L5e
            if (r2 != 0) goto L5c
            boolean r2 = com.opos.cmn.an.c.a.a(r4)     // Catch: java.lang.Exception -> L5e
            if (r2 != 0) goto L62
            java.lang.String r2 = r4.toLowerCase()     // Catch: java.lang.Exception -> L5e
            boolean r7 = r2.contains(r7)     // Catch: java.lang.Exception -> L5e
            if (r7 == 0) goto L62
        L5c:
            r7 = 1
            goto L63
        L5e:
            r7 = move-exception
            com.opos.cmn.an.f.a.c(r0, r1, r7)
        L62:
            r7 = 0
        L63:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "isLimitedBrandMobile ="
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.h.f.a.a(java.lang.String):boolean");
    }

    private static int[] a(Context context, boolean z) {
        try {
            if (f16532a == null && context != null) {
                DisplayMetrics p = p(context);
                int i2 = p.widthPixels;
                int i3 = p.heightPixels;
                int i4 = i2 > i3 ? i3 : i2;
                if (i2 <= i3) {
                    i2 = i3;
                }
                f16532a = new int[]{i4, i2};
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
        }
        if (f16532a == null) {
            return new int[]{-1, -1};
        }
        if (z || d(context)) {
            int[] iArr = f16532a;
            return new int[]{iArr[0], iArr[1]};
        }
        int[] iArr2 = f16532a;
        return new int[]{iArr2[1], iArr2[0]};
    }

    public static int b(Context context) {
        int i2 = a(context, true)[0];
        com.opos.cmn.an.f.a.b("WinMgrTool", "getScreenWidth=" + i2);
        return i2;
    }

    public static int b(Context context, float f2) {
        return context != null ? (int) ((f2 / m(context)) + 0.5f) : (int) f2;
    }

    public static int c(Context context) {
        int i2 = a(context, true)[1];
        com.opos.cmn.an.f.a.b("WinMgrTool", "getScreenHeight=" + i2);
        return i2;
    }

    public static int c(Context context, float f2) {
        return context != null ? (int) ((n(context) * f2) + 0.5f) : (int) f2;
    }

    public static boolean d(Context context) {
        try {
            Configuration configuration = context.getResources().getConfiguration();
            r1 = configuration == null || configuration.orientation == 1;
            com.opos.cmn.an.f.a.b("WinMgrTool", "isPortrait=" + r1);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
        }
        return r1;
    }

    public static float e(Context context) {
        float f2 = f16535d;
        if (0.0f != f2) {
            return f2;
        }
        if (context != null) {
            f16535d = o(context).density;
        }
        com.opos.cmn.an.f.a.b("WinMgrTool", "getAppDensity=" + f16535d);
        return f16535d;
    }

    public static float f(Context context) {
        float f2 = f16533b;
        if (0.0f != f2) {
            return f2;
        }
        if (context != null) {
            f16533b = p(context).density;
        }
        com.opos.cmn.an.f.a.b("WinMgrTool", "getDensity=" + f16533b);
        return f16533b;
    }

    public static float g(Context context) {
        float f2 = f16536e;
        if (0.0f != f2) {
            return f2;
        }
        if (context != null) {
            f16536e = o(context).scaledDensity;
        }
        com.opos.cmn.an.f.a.b("WinMgrTool", "getAppScaledDensity=" + f16536e);
        return f16536e;
    }

    public static float h(Context context) {
        float f2 = f16534c;
        if (0.0f != f2) {
            return f2;
        }
        if (context != null) {
            f16534c = p(context).scaledDensity;
        }
        com.opos.cmn.an.f.a.b("WinMgrTool", "getScaledDensity=" + f16534c);
        return f16534c;
    }

    public static int i(Context context) {
        if (context != null) {
            try {
                int j2 = j(context);
                if (j2 == 90) {
                    return 270;
                }
                if (j2 == 180) {
                    return TinkerReport.KEY_APPLIED_VERSION_CHECK;
                }
                if (j2 == 270) {
                    return 90;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
            }
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static int j(Context context) {
        ?? r0 = "";
        if (context != null) {
            try {
                WindowManager a2 = a(context);
                r0 = r0;
                if (a2 != null) {
                    try {
                        int rotation = a2.getDefaultDisplay().getRotation();
                        if (rotation == 1) {
                            return 90;
                        }
                        if (rotation == 2) {
                            return TinkerReport.KEY_APPLIED_VERSION_CHECK;
                        }
                        r0 = 3;
                        if (rotation == 3) {
                            return 270;
                        }
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
                        r0 = r0;
                    }
                }
            } catch (Exception e3) {
                com.opos.cmn.an.f.a.c("WinMgrTool", r0, e3);
            }
        }
        return 0;
    }

    public static int k(Context context) {
        int dimensionPixelSize;
        if (f16538g == 0) {
            try {
                if (Build.VERSION.SDK_INT >= 30) {
                    int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", BaseWrapper.BASE_PKG_SYSTEM);
                    if (identifier > 0) {
                        dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                    }
                } else {
                    Class<?> cls = Class.forName("com.android.internal.R$dimen");
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
                }
                f16538g = dimensionPixelSize;
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("WinMgrTool", "getStatusBarHeight", e2);
            }
        }
        com.opos.cmn.an.f.a.b("WinMgrTool", "getStatusBarHeight=" + f16538g);
        return f16538g;
    }

    public static float l(Context context) {
        try {
            return c(context) / b(context);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("WinMgrTool", "", e2);
            return 0.0f;
        }
    }

    public static float m(Context context) {
        float f2 = f16540i;
        if (0.0f != f2) {
            return f2;
        }
        if (context != null) {
            if (a() && e(context) == f(context) && b(context) == 1080) {
                f16540i = e(context) == 3.0f ? e(context) : 3.0f;
            } else {
                f16540i = e(context);
            }
        }
        com.opos.cmn.an.f.a.b("WinMgrTool", "getAppValidDensity=" + f16540i);
        return f16540i;
    }

    public static float n(Context context) {
        float f2 = f16541j;
        if (0.0f != f2) {
            return f2;
        }
        if (context != null) {
            if (a() && g(context) == h(context) && b(context) == 1080) {
                f16541j = g(context) == 3.0f ? g(context) : 3.0f;
            } else {
                f16541j = g(context);
            }
        }
        com.opos.cmn.an.f.a.b("WinMgrTool", "getAppValidScaledDensity=" + f16541j);
        return f16541j;
    }

    private static DisplayMetrics o(Context context) {
        if (context != null) {
            try {
                return context.getResources().getDisplayMetrics();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("WinMgrTool", "getAppDisplayMetrics", e2);
            }
        }
        return null;
    }

    private static DisplayMetrics p(Context context) {
        if (context != null) {
            try {
                Display defaultDisplay = a(context).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                try {
                    Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
                    return displayMetrics;
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("WinMgrTool", "getDisplayMetrics", e2);
                    return context.getResources().getDisplayMetrics();
                }
            } catch (Exception e3) {
                com.opos.cmn.an.f.a.c("WinMgrTool", "", e3);
            }
        }
        return null;
    }
}
