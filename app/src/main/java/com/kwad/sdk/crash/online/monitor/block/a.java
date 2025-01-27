package com.kwad.sdk.crash.online.monitor.block;

import android.os.Looper;
import android.util.Printer;
import com.kwad.sdk.utils.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class a {
    private static volatile boolean aKR;
    private static String aKS;
    private static List<String> aKT;
    private static List<String> aKU;
    private static volatile boolean aKV;
    private static volatile boolean aKW;

    public static boolean JD() {
        if (aKR) {
            return false;
        }
        try {
            return ((Printer) w.getField(Looper.getMainLooper(), "mLogging")) != null;
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.e("perfMonitor.MonitorDetector", "hasBlockMonitor ", e10);
            aKR = true;
            return false;
        }
    }

    public static boolean JE() {
        if (aKW) {
            return aKV;
        }
        try {
            String str = new String(com.kwad.sdk.core.a.c.EY().decode("Y29tLnRlbmNlbnQubWF0cml4Lk1hdHJpeA=="));
            com.kwad.sdk.core.d.c.d("perfMonitor.MonitorDetector", "hasMatrix after:" + str);
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            aKV = false;
            aKW = true;
            return aKV;
        }
    }

    public static void a(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        aKT = aVar.aLp;
        aKU = aVar.aLq;
    }

    public static boolean bD(boolean z10) {
        List<String> list = aKT;
        return (list == null || list.isEmpty()) ? g("Y29tLnRlbmNlbnQubWF0cml4LnRyYWNlLmNvcmUuTG9vcGVyTW9uaXRvcg==", true) : a(aKT, true);
    }

    public static boolean bE(boolean z10) {
        List<String> list = aKU;
        if (list == null || list.isEmpty()) {
            return false;
        }
        return a(aKU, false);
    }

    private static boolean g(String str, boolean z10) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return a(arrayList, z10);
    }

    private static boolean a(List<String> list, boolean z10) {
        if (aKR) {
            return false;
        }
        try {
            Printer printer = (Printer) w.getField(Looper.getMainLooper(), "mLogging");
            if (printer == null) {
                com.kwad.sdk.core.d.c.d("perfMonitor.MonitorDetector", "printer not hook");
            } else {
                aKS = printer.getClass().getName();
                com.kwad.sdk.core.d.c.d("perfMonitor.MonitorDetector", "originPrinter name:" + printer.getClass().getName());
                if (z10) {
                    f.fO(aKS);
                }
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    String str = new String(com.kwad.sdk.core.a.c.EY().decode(it.next()));
                    com.kwad.sdk.core.d.c.d("perfMonitor.MonitorDetector", "printer after:" + str);
                    if (printer.getClass().getName().contains(str)) {
                        com.kwad.sdk.core.d.c.d("perfMonitor.MonitorDetector", "printer monitor");
                        return true;
                    }
                }
            }
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.e("perfMonitor.MonitorDetector", "hasBlockMonitor ", e10);
            aKR = true;
        }
        return false;
    }
}
