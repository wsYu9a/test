package com.vivo.ad.g;

import android.util.Log;

/* loaded from: classes4.dex */
class f {

    /* renamed from: a */
    static boolean f26726a = false;

    static void a(String str, String str2) {
        if (f26726a) {
            Log.i("SecAppStore." + str, str2);
        }
    }

    static void a(String str, String str2, Throwable th) {
        if (f26726a) {
            Log.e("SecAppStore." + str, str2, th);
        }
    }
}
