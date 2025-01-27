package com.kwai.filedownloader.kwai;

import com.kwai.filedownloader.e.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHeaders;

/* loaded from: classes2.dex */
public class d {
    public static b a(Map<String, List<String>> map, b bVar, List<String> list) {
        int responseCode = bVar.getResponseCode();
        String o = bVar.o(HttpHeaders.LOCATION);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (cG(responseCode)) {
            if (o == null) {
                throw new IllegalAccessException(f.j("receive %d (redirect) but the location is null with response [%s]", Integer.valueOf(responseCode), bVar.W()));
            }
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(d.class, "redirect to %s with %d, %s", o, Integer.valueOf(responseCode), arrayList);
            }
            bVar.X();
            bVar = b(map, o);
            arrayList.add(o);
            bVar.execute();
            responseCode = bVar.getResponseCode();
            o = bVar.o(HttpHeaders.LOCATION);
            i2++;
            if (i2 >= 10) {
                throw new IllegalAccessException(f.j("redirect too many times! %s", arrayList));
            }
        }
        if (list != null) {
            list.addAll(arrayList);
        }
        return bVar;
    }

    private static b b(Map<String, List<String>> map, String str) {
        b fp = com.kwai.filedownloader.download.b.HF().fp(str);
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    fp.addHeader(key, it.next());
                }
            }
        }
        return fp;
    }

    private static boolean cG(int i2) {
        return i2 == 301 || i2 == 302 || i2 == 303 || i2 == 300 || i2 == 307 || i2 == 308;
    }
}
