package com.google.zxing.client.result;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public final class u extends t {
    private static void q(Collection<String> collection, Collection<String> collection2, String str) {
        int indexOf = str.indexOf(59);
        if (indexOf < 0) {
            collection.add(str);
            collection2.add(null);
        } else {
            collection.add(str.substring(0, indexOf));
            String substring = str.substring(indexOf + 1);
            collection2.add(substring.startsWith("via=") ? substring.substring(4) : null);
        }
    }

    @Override // com.google.zxing.client.result.t
    /* renamed from: r */
    public v k(com.google.zxing.k kVar) {
        String str;
        String c2 = t.c(kVar);
        String str2 = null;
        if (!c2.startsWith("sms:") && !c2.startsWith("SMS:") && !c2.startsWith("mms:") && !c2.startsWith("MMS:")) {
            return null;
        }
        Map<String, String> m = t.m(c2);
        boolean z = false;
        if (m == null || m.isEmpty()) {
            str = null;
        } else {
            str2 = m.get("subject");
            str = m.get("body");
            z = true;
        }
        int indexOf = c2.indexOf(63, 4);
        String substring = (indexOf < 0 || !z) ? c2.substring(4) : c2.substring(4, indexOf);
        int i2 = -1;
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        while (true) {
            int i3 = i2 + 1;
            int indexOf2 = substring.indexOf(44, i3);
            if (indexOf2 <= i2) {
                q(arrayList, arrayList2, substring.substring(i3));
                return new v((String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()]), str2, str);
            }
            q(arrayList, arrayList2, substring.substring(i3, indexOf2));
            i2 = indexOf2;
        }
    }
}
