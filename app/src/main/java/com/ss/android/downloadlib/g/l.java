package com.ss.android.downloadlib.g;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes4.dex */
public class l {

    public static class a {

        /* renamed from: a */
        private static l f21667a = new l();
    }

    public /* synthetic */ l(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static l a() {
        return a.f21667a;
    }

    public void b(String str, String str2, String str3) {
        Log.e("[TTDownloaderLogger]", ((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : String.format("sdk:%s.%s:", str, str2)) + str3);
    }

    private l() {
    }

    public void a(String str, String str2, String str3) {
        Log.d("[TTDownloaderLogger]", ((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : String.format("sdk:%s.%s:", str, str2)) + str3);
    }
}
