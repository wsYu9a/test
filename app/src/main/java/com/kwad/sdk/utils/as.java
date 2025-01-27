package com.kwad.sdk.utils;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;

/* loaded from: classes2.dex */
public final class as {
    private static String aAk;
    private static String aAl;

    public static boolean DQ() {
        return aV(com.martian.mipush.d.f14902c);
    }

    public static boolean DR() {
        return aV(com.martian.mipush.d.f14901b);
    }

    public static boolean DS() {
        return aV(com.martian.mipush.d.f14903d);
    }

    private static boolean aV(String str) {
        String upperCase;
        String str2 = aAk;
        if (str2 != null) {
            return str2.contains(str);
        }
        String str3 = bc.get("ro.build.version.opporom");
        aAl = str3;
        if (TextUtils.isEmpty(str3)) {
            String str4 = bc.get("ro.vivo.os.version");
            aAl = str4;
            if (TextUtils.isEmpty(str4)) {
                String str5 = bc.get("ro.build.version.emui");
                aAl = str5;
                if (TextUtils.isEmpty(str5)) {
                    String str6 = bc.get("ro.miui.ui.version.name");
                    aAl = str6;
                    if (TextUtils.isEmpty(str6)) {
                        String str7 = bc.get("ro.product.system.manufacturer");
                        aAl = str7;
                        if (TextUtils.isEmpty(str7)) {
                            String str8 = bc.get("ro.smartisan.version");
                            aAl = str8;
                            if (TextUtils.isEmpty(str8)) {
                                String str9 = "SAMSUNG";
                                if (!bc.get("ro.product.manufacturer").toUpperCase().contains("SAMSUNG")) {
                                    String str10 = Build.DISPLAY;
                                    aAl = str10;
                                    String upperCase2 = str10.toUpperCase();
                                    str9 = com.martian.mipush.d.f14903d;
                                    if (!upperCase2.contains(com.martian.mipush.d.f14903d)) {
                                        aAl = EnvironmentCompat.MEDIA_UNKNOWN;
                                        upperCase = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                                aAk = str9;
                                return aAk.contains(str);
                            }
                            upperCase = com.martian.mipush.d.f14905f;
                        } else {
                            upperCase = "OnePlus";
                        }
                    } else {
                        upperCase = com.martian.mipush.d.f14901b;
                    }
                } else {
                    upperCase = com.martian.mipush.d.f14902c;
                }
            } else {
                upperCase = "VIVO";
            }
        } else {
            upperCase = "OPPO";
        }
        aAk = upperCase;
        return aAk.contains(str);
    }

    public static String getName() {
        if (aAk == null) {
            aV("");
        }
        return aAk;
    }

    public static String getVersion() {
        if (aAl == null) {
            aV("");
        }
        return aAl;
    }
}
