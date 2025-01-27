package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class b {
    private static List<String> arR = null;
    private static List<String> arS = null;
    private static int arT = 5;

    public static void a(com.kwad.sdk.crash.online.monitor.kwai.a aVar) {
        arR = new ArrayList();
        List<String> list = aVar.asf;
        if (list == null || list.isEmpty()) {
            arR.add("com.kwad");
            arR.add("com.kwai");
            arR.add("com.ksad");
            arR.add("tkruntime");
            arR.add("tachikoma");
            arR.add("kuaishou");
        } else {
            arR.addAll(aVar.asf);
        }
        arT = aVar.ask;
        arS = new ArrayList();
        List<String> list2 = aVar.ase;
        if (list2 != null && !list2.isEmpty()) {
            arS.addAll(aVar.ase);
            return;
        }
        arS.add("android.");
        arS.add("androidx.");
        arS.add("org.");
        arS.add("java.");
    }

    private static boolean dF(String str) {
        List<String> list = arS;
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

    private static boolean dG(String str) {
        List<String> list = arR;
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

    public static String dH(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split("\n");
        com.kwad.sdk.core.d.b.d("perfMonitor.Filter", "stacks after split:" + split.length);
        boolean z = false;
        int i2 = 0;
        for (String str2 : split) {
            if (z || !dF(str2)) {
                if (i2 >= arT) {
                    return "";
                }
                if (dG(str2)) {
                    return str;
                }
                i2++;
                z = true;
            }
        }
        return "";
    }
}
