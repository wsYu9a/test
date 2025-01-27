package com.shu.priory.utils;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: classes3.dex */
public class d {

    public static class a {

        /* renamed from: a */
        private static final d f17305a = new d();
    }

    private d() {
    }

    public static final d a() {
        return a.f17305a;
    }

    public /* synthetic */ d(AnonymousClass1 anonymousClass1) {
        this();
    }

    public String a(String str) {
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
