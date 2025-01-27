package com.kwad.sdk.crash.a;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class b {
    private Set<String> arm = new HashSet();
    private Set<String> arn = new HashSet();

    public final synchronized void a(String[] strArr, String[] strArr2) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            this.arm.add(str);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (strArr2 != null && strArr2.length > 0) {
            for (String str2 : strArr2) {
                if (!TextUtils.isEmpty(str2)) {
                    this.arn.add(str2);
                }
            }
        }
    }

    public final synchronized String[] zA() {
        Set<String> set;
        set = this.arn;
        return (String[]) set.toArray(new String[set.size()]);
    }

    public final synchronized String[] zM() {
        Set<String> set;
        set = this.arm;
        return (String[]) set.toArray(new String[set.size()]);
    }
}
