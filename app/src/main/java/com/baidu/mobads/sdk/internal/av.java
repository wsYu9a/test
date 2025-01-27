package com.baidu.mobads.sdk.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.ay;

/* loaded from: classes2.dex */
public class av extends ay.a {

    /* renamed from: a */
    public static final String f6792a = "debug";

    @Override // com.baidu.mobads.sdk.internal.ay.a
    @NonNull
    public String a() {
        return "debug";
    }

    @Override // com.baidu.mobads.sdk.internal.ay.a
    public boolean a(String str, int i10) {
        return ay.f6809a.equals(str);
    }

    @Override // com.baidu.mobads.sdk.internal.ay.a
    public void a(int i10, String str, String str2, Throwable th2) {
        a(i10, str, str2);
    }

    private static void a(int i10, String str, String str2) {
        try {
            if (i10 == 7) {
                Log.wtf(str, str2);
            } else {
                Log.println(i10, str, str2);
            }
        } catch (Throwable unused) {
        }
    }
}
