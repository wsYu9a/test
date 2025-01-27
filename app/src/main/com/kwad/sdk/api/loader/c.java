package com.kwad.sdk.api.loader;

import android.app.Application;

/* loaded from: classes3.dex */
public final class c {
    public static Application By() {
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }
}
