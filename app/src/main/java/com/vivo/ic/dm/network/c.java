package com.vivo.ic.dm.network;

import com.vivo.ic.VLog;
import com.vivo.ic.dm.Constants;
import com.vivo.ic.dm.DownloadInfo;
import com.vivo.ic.spmanager.VivoPreference;
import com.vivo.ic.spmanager.VivoPreferenceManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: b */
    private static final String f28525b = "DM";

    /* renamed from: a */
    private static final String f28524a = Constants.PRE_TAG + "DownloadSpUtil";

    /* renamed from: c */
    private static VivoPreference f28526c = VivoPreferenceManager.getInstance().getPreference();

    /* renamed from: d */
    private static Map<String, Long> f28527d = new HashMap();

    public static void a(com.vivo.ic.dm.c[] cVarArr) {
        if (cVarArr != null) {
            for (com.vivo.ic.dm.c cVar : cVarArr) {
                String a2 = a(cVar.f28403a, cVar.f28404b);
                b(a2, cVar.f28407e);
                VLog.d(f28524a, "saveAllChildProgress key:" + a2 + ",value:" + cVar.f28407e);
            }
        }
    }

    private static void b(String str, long j2) {
        f28527d.put(str, Long.valueOf(j2));
        f28526c.putLongAsync(str, j2);
    }

    public static long b(DownloadInfo downloadInfo, int i2) {
        long a2 = a(a(downloadInfo.getId(), i2), 0L);
        VLog.d(f28524a, "getChildProgress key:" + i2 + ",value:" + a2);
        return a2;
    }

    public static void a(com.vivo.ic.dm.c cVar) {
        if (cVar != null) {
            a(cVar.f28403a, cVar.f28404b, cVar.f28407e);
        }
    }

    public static void a(long j2, int i2, long j3) {
        b(a(j2, i2), j3);
    }

    public static long[] a(DownloadInfo downloadInfo, int i2) {
        long[] jArr = new long[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            String a2 = a(downloadInfo.getId(), i3);
            jArr[i3] = a(a2, 0L);
            VLog.d(f28524a, "getChildProgress key:" + a2 + ",value:" + jArr[i3]);
        }
        return jArr;
    }

    private static long a(String str, long j2) {
        Long l = f28527d.get(str);
        if (l == null) {
            return f28526c.getLong(str, j2);
        }
        return l.longValue();
    }

    private static void a(String str) {
        f28526c.removeAsync(str);
        f28527d.remove(str);
    }

    public static void a() {
        f28527d.clear();
    }

    public static void a(long j2) {
        int i2 = 0;
        String a2 = a(j2, 0);
        while (f28526c.isKeyExist(a2)) {
            a(a2);
            VLog.d(f28524a, "clearChildProgress key:" + a2);
            i2++;
            a2 = a(j2, (long) i2);
        }
    }

    private static String a(long j2, long j3) {
        return "DM-" + j2 + "-" + j3;
    }
}
