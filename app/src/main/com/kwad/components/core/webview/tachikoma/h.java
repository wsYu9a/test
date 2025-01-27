package com.kwad.components.core.webview.tachikoma;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* loaded from: classes3.dex */
public final class h {
    private final Map<String, HashMap<Integer, String>> abI = new ConcurrentHashMap();
    private Map<String, Integer> abJ = new ConcurrentSkipListMap();
    private int abK = 0;

    public static class a {
        private static final h abL = new h();
    }

    private void aS(int i10) {
        if (this.abK + i10 > com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.awN)) {
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, Integer>> it = this.abJ.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Integer> next = it.next();
                arrayList.add(next.getKey());
                this.abK -= next.getValue().intValue();
                it.remove();
                if (this.abK <= com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.awN) - i10) {
                    break;
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.abI.remove((String) it2.next());
            }
        }
    }

    private static int aT(String str) {
        return ((str.length() * 2) + 44) / 1024;
    }

    private void q(String str, String str2) {
        int aT = aT(str2);
        this.abK += aT;
        this.abJ.put(str, Integer.valueOf(aT));
    }

    public static h tH() {
        return a.abL;
    }

    public final void b(String str, int i10, String str2) {
        if (TextUtils.isEmpty(str2) || com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.awN) == 0) {
            return;
        }
        if (this.abI.containsKey(str)) {
            HashMap<Integer, String> hashMap = this.abI.get(str);
            if (hashMap != null && hashMap.containsKey(Integer.valueOf(i10))) {
                return;
            } else {
                this.abI.remove(str);
            }
        }
        aS(aT(str2));
        HashMap<Integer, String> hashMap2 = new HashMap<>();
        hashMap2.put(Integer.valueOf(i10), str2);
        this.abI.put(str, hashMap2);
        q(str, str2);
    }

    public final String n(String str, int i10) {
        HashMap<Integer, String> hashMap;
        return (com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.awN) != 0 && this.abI.containsKey(str) && (hashMap = this.abI.get(str)) != null && hashMap.containsKey(Integer.valueOf(i10))) ? hashMap.get(Integer.valueOf(i10)) : "";
    }
}
