package com.opos.videocache.a;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public class e implements c {
    private String b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    @Override // com.opos.videocache.a.c
    public String a(String str) {
        String b2 = b(str);
        String d2 = com.opos.videocache.h.d(str);
        if (TextUtils.isEmpty(b2)) {
            return d2;
        }
        return d2 + "." + b2;
    }
}
