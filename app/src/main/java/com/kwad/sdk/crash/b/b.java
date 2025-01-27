package com.kwad.sdk.crash.b;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public final class b {
    private Set<String> aKn = new HashSet();
    private Set<String> aKo = new HashSet();

    public final synchronized String[] Jm() {
        Set<String> set;
        set = this.aKo;
        return (String[]) set.toArray(new String[set.size()]);
    }

    public final synchronized String[] Jx() {
        Set<String> set;
        set = this.aKn;
        return (String[]) set.toArray(new String[set.size()]);
    }

    public final synchronized void a(String[] strArr, String[] strArr2) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            this.aKn.add(str);
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (strArr2 != null && strArr2.length > 0) {
            for (String str2 : strArr2) {
                if (!TextUtils.isEmpty(str2)) {
                    this.aKo.add(str2);
                }
            }
        }
    }
}
