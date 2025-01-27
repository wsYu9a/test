package com.baidu.mobads.sdk.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.av;

/* loaded from: classes.dex */
public class as extends av.a {

    /* renamed from: a */
    public static final String f5542a = "debug";

    @Override // com.baidu.mobads.sdk.internal.av.a
    @NonNull
    String a() {
        return "debug";
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    protected boolean a(String str, int i2) {
        return av.f5555a.equals(str);
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    protected void a(int i2, String str, String str2, Throwable th) {
        a(i2, str, str2);
    }

    private static void a(int i2, String str, String str2) {
        try {
            if (i2 == 7) {
                Log.wtf(str, str2);
            } else {
                Log.println(i2, str, str2);
            }
        } catch (Throwable unused) {
        }
    }
}
