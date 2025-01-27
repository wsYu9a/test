package y5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes2.dex */
public final class u extends t {
    public static void q(Collection<String> collection, Collection<String> collection2, String str) {
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

    @Override // y5.t
    /* renamed from: r */
    public v k(t5.k kVar) {
        boolean z10;
        String str;
        String c10 = t.c(kVar);
        String str2 = null;
        if (!c10.startsWith("sms:") && !c10.startsWith("SMS:") && !c10.startsWith("mms:") && !c10.startsWith("MMS:")) {
            return null;
        }
        Map<String, String> m10 = t.m(c10);
        if (m10 == null || m10.isEmpty()) {
            z10 = false;
            str = null;
        } else {
            str2 = m10.get("subject");
            str = m10.get("body");
            z10 = true;
        }
        int indexOf = c10.indexOf(63, 4);
        String substring = (indexOf < 0 || !z10) ? c10.substring(4) : c10.substring(4, indexOf);
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        int i10 = -1;
        while (true) {
            int i11 = i10 + 1;
            int indexOf2 = substring.indexOf(44, i11);
            if (indexOf2 <= i10) {
                q(arrayList, arrayList2, substring.substring(i11));
                return new v((String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()]), str2, str);
            }
            q(arrayList, arrayList2, substring.substring(i11, indexOf2));
            i10 = indexOf2;
        }
    }
}
