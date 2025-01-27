package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class b {
    private static List<String> aLb = null;
    private static List<String> aLc = null;
    private static int aLd = 5;

    public static void a(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        aLb = new ArrayList();
        List<String> list = aVar.aLo;
        if (list == null || list.isEmpty()) {
            aLb.add("com.kwad");
            aLb.add("com.kwai");
            aLb.add("com.ksad");
            aLb.add("tkruntime");
            aLb.add("tachikoma");
            aLb.add("kuaishou");
        } else {
            aLb.addAll(aVar.aLo);
        }
        aLd = aVar.aLt;
        aLc = new ArrayList();
        List<String> list2 = aVar.aLn;
        if (list2 != null && !list2.isEmpty()) {
            aLc.addAll(aVar.aLn);
            return;
        }
        aLc.add("android.");
        aLc.add("androidx.");
        aLc.add("org.");
        aLc.add("java.");
    }

    private static boolean fJ(String str) {
        List<String> list = aLc;
        if (list == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean fK(String str) {
        List<String> list = aLb;
        if (list == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static String fL(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split("\n");
        com.kwad.sdk.core.d.c.d("perfMonitor.Filter", "stacks after split:" + split.length);
        boolean z10 = false;
        int i10 = 0;
        for (String str2 : split) {
            if (z10 || !fJ(str2)) {
                if (i10 >= aLd) {
                    return "";
                }
                if (fK(str2)) {
                    return str;
                }
                i10++;
                z10 = true;
            }
        }
        return "";
    }
}
