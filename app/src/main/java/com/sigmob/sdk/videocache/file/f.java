package com.sigmob.sdk.videocache.file;

import android.text.TextUtils;
import com.sigmob.sdk.videocache.r;

/* loaded from: classes4.dex */
public class f implements c {

    /* renamed from: a */
    public static final int f20599a = 4;

    @Override // com.sigmob.sdk.videocache.file.c
    public String a(String str) {
        String b10 = b(str);
        String a10 = r.a(str);
        if (TextUtils.isEmpty(b10)) {
            return a10;
        }
        return a10 + p1.b.f29697h + b10;
    }

    public final String b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || lastIndexOf + 6 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }
}
