package com.kwad.framework.filedownloader.a;

import com.kwad.framework.filedownloader.f.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class d {
    public static b a(Map<String, List<String>> map, b bVar, List<String> list) {
        int responseCode = bVar.getResponseCode();
        String bh2 = bVar.bh(m5.c.f28347t0);
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (bj(responseCode)) {
            if (bh2 == null) {
                throw new IllegalAccessException(f.b("receive %d (redirect) but the location is null with response [%s]", Integer.valueOf(responseCode), bVar.wl()));
            }
            if (com.kwad.framework.filedownloader.f.d.alt) {
                com.kwad.framework.filedownloader.f.d.c(d.class, "redirect to %s with %d, %s", bh2, Integer.valueOf(responseCode), arrayList);
            }
            bVar.wm();
            bVar = a(map, bh2);
            arrayList.add(bh2);
            bVar.execute();
            responseCode = bVar.getResponseCode();
            bh2 = bVar.bh(m5.c.f28347t0);
            i10++;
            if (i10 >= 10) {
                throw new IllegalAccessException(f.b("redirect too many times! %s", arrayList));
            }
        }
        if (list != null) {
            list.addAll(arrayList);
        }
        return bVar;
    }

    private static boolean bj(int i10) {
        return i10 == 301 || i10 == 302 || i10 == 303 || i10 == 300 || i10 == 307 || i10 == 308;
    }

    private static b a(Map<String, List<String>> map, String str) {
        b bl = com.kwad.framework.filedownloader.download.b.ww().bl(str);
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    bl.addHeader(key, it.next());
                }
            }
        }
        return bl;
    }
}
