package com.cdo.oaps.ad;

import android.content.Context;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.cdo.oaps.ad.wrapper.PreDownWrapper;
import com.cdo.oaps.ad.wrapper.ResourceWrapper;
import com.cdo.oaps.ad.wrapper.SearchWrapper;
import com.cdo.oaps.ad.wrapper.WebWrapper;
import java.util.Map;

/* loaded from: classes.dex */
public class ad {

    /* renamed from: a */
    private static final int f6502a = 0;

    /* renamed from: b */
    private static final int f6503b = 1;

    private static int a(String str) {
        if (!"4".equals(str)) {
            if ("6".equals(str)) {
                return 1609;
            }
            if ("8".equals(str)) {
                return 1611;
            }
            if ("7".equals(str)) {
                return 1610;
            }
            if ("5".equals(str)) {
                return 1608;
            }
        }
        return 1607;
    }

    public static String a(Context context, BaseWrapper baseWrapper) {
        boolean equals = "1".equals(baseWrapper.getGoBack());
        String enterId = baseWrapper.getEnterId();
        String enterModule = baseWrapper.getEnterModule();
        return af.a(context, 4600) ? z.a(context, enterId, enterModule, equals) : af.a(context, 4550) ? t.a(context, enterId, enterModule, equals) : "";
    }

    public static String a(Context context, PreDownWrapper preDownWrapper) {
        if (!af.a(context, 4600)) {
            return "";
        }
        long id = preDownWrapper.getId();
        String pkgName = preDownWrapper.getPkgName();
        int type = preDownWrapper.getType();
        String enterId = preDownWrapper.getEnterId();
        return z.a(context, id, pkgName, type == 0 ? 0 : 1, enterId, preDownWrapper.getEnterModule(), preDownWrapper.getEnterModule2(), a(enterId));
    }

    public static String a(Context context, ResourceWrapper resourceWrapper) {
        long id = resourceWrapper.getId();
        String pkgName = resourceWrapper.getPkgName();
        boolean autoDown = resourceWrapper.getAutoDown();
        boolean equals = "1".equals(resourceWrapper.getGoBack());
        String enterId = resourceWrapper.getEnterId();
        String enterModule = resourceWrapper.getEnterModule();
        String enterModule2 = resourceWrapper.getEnterModule2();
        int a2 = a(enterId);
        return af.a(context, 4600) ? z.a(context, id, pkgName, autoDown, equals, enterId, enterModule, enterModule2, a2, resourceWrapper.getExtModule()) : af.a(context, 4550) ? t.a(context, id, pkgName, autoDown, equals, enterId, enterModule, a2, enterModule2) : "";
    }

    public static String a(Context context, SearchWrapper searchWrapper) {
        String keyword = searchWrapper.getKeyword();
        String pkgName = searchWrapper.getPkgName();
        boolean autoDown = searchWrapper.getAutoDown();
        boolean equals = "1".equals(searchWrapper.getGoBack());
        String enterId = searchWrapper.getEnterId();
        String enterModule = searchWrapper.getEnterModule();
        String enterModule2 = searchWrapper.getEnterModule2();
        int a2 = a(enterId);
        return af.a(context, 4600) ? z.a(context, keyword, pkgName, autoDown, equals, enterId, enterModule, enterModule2, a2) : af.a(context, 4550) ? t.a(context, keyword, pkgName, autoDown, equals, enterId, enterModule, enterModule2, a2) : "";
    }

    public static String a(Context context, WebWrapper webWrapper) {
        boolean equals = "1".equals(webWrapper.getGoBack());
        String url = webWrapper.getUrl();
        String enterId = webWrapper.getEnterId();
        String enterModule = webWrapper.getEnterModule();
        String enterModule2 = webWrapper.getEnterModule2();
        int a2 = a(enterId);
        return af.a(context, 4600) ? z.a(context, url, equals, enterId, enterModule, enterModule2, a2, webWrapper.getExtModule()) : af.a(context, 4550) ? t.a(context, url, equals, enterId, enterModule, a2, enterModule2) : "";
    }

    public static boolean a(Context context, String str) {
        if (!af.a(context, 5100)) {
            if (af.a(context, 4600)) {
                for (String str2 : af.f6511h) {
                    if (!str2.equals(str)) {
                    }
                }
                return false;
            }
            if (af.a(context, 4550)) {
                for (String str3 : af.f6510g) {
                    if (!str3.equals(str)) {
                    }
                }
                return false;
            }
            if (!af.a(context, 390)) {
                return false;
            }
            for (String str4 : af.f6509f) {
                if (!str4.equals(str)) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean a(Context context, Map<String, Object> map) {
        return a(context, map, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0148, code lost:
    
        if (com.cdo.oaps.ad.t.a(r11, r3, r5, r0.getEnterModule(), a(r8), r8, r0.getEnterModule2(), com.cdo.oaps.ad.a.b(r1 == 0 ? "Y29tLm9wcG8ubWFya2V0LnNlcnZpY2UucHJlX2Rvd25sb2FkLnN0YXJ0" : "Y29tLm9wcG8ubWFya2V0LnNlcnZpY2UucHJlX2Rvd25sb2FkLmNhbmNlbA==")) == false) goto L146;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(android.content.Context r11, java.util.Map<java.lang.String, java.lang.Object> r12, int r13) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cdo.oaps.ad.ad.a(android.content.Context, java.util.Map, int):boolean");
    }

    public static boolean b(Context context, Map<String, Object> map) {
        return a(context, map, 1);
    }
}
