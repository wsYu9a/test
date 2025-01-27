package com.kwad.sdk.utils;

import android.os.Build;
import android.text.TextUtils;
import com.martian.ads.ad.AdConfig;

/* loaded from: classes3.dex */
public final class ay {
    private static String aUm;
    private static String aUn;

    public static boolean NX() {
        return gW("EMUI");
    }

    public static boolean NY() {
        return gW("MIUI");
    }

    public static boolean NZ() {
        return gW("FLYME");
    }

    private static boolean gW(String str) {
        String str2 = aUm;
        if (str2 != null) {
            return str2.contains(str);
        }
        String str3 = bn.get("ro.build.version.opporom");
        aUn = str3;
        if (TextUtils.isEmpty(str3)) {
            String str4 = bn.get("ro.vivo.os.version");
            aUn = str4;
            if (TextUtils.isEmpty(str4)) {
                String str5 = bn.get("ro.build.version.emui");
                aUn = str5;
                if (TextUtils.isEmpty(str5)) {
                    String str6 = bn.get("ro.miui.ui.version.name");
                    aUn = str6;
                    if (TextUtils.isEmpty(str6)) {
                        String str7 = bn.get("ro.product.system.manufacturer");
                        aUn = str7;
                        if (TextUtils.isEmpty(str7)) {
                            String str8 = bn.get("ro.smartisan.version");
                            aUn = str8;
                            if (!TextUtils.isEmpty(str8)) {
                                aUm = "SMARTISAN";
                            } else if (bn.get("ro.product.manufacturer").toUpperCase().contains("SAMSUNG")) {
                                aUm = "SAMSUNG";
                            } else {
                                String str9 = Build.DISPLAY;
                                aUn = str9;
                                if (str9.toUpperCase().contains("FLYME")) {
                                    aUm = "FLYME";
                                } else {
                                    aUn = "unknown";
                                    aUm = Build.MANUFACTURER.toUpperCase();
                                }
                            }
                        } else {
                            aUm = ke.e.f27808f;
                        }
                    } else {
                        aUm = "MIUI";
                    }
                } else {
                    aUm = "EMUI";
                }
            } else {
                aUm = AdConfig.UnionType.VIVO;
            }
        } else {
            aUm = "OPPO";
        }
        return aUm.contains(str);
    }

    public static String getName() {
        if (aUm == null) {
            gW("");
        }
        return aUm;
    }

    public static String getVersion() {
        if (aUn == null) {
            gW("");
        }
        return aUn;
    }
}
