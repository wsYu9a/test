package com.martian.ttbook.b.a.i;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import java.io.File;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private static String f14989a = "com.martian.ttbook.sdk.adcomponents.adsdk.JhSdkDownloadProvider";

    public static Uri a(@NonNull Context context, @NonNull String str, @NonNull File file) {
        try {
            Class<?> cls = Class.forName(f14989a);
            return (Uri) cls.getMethod("getUriForFile", Context.class, String.class, File.class).invoke(cls, context, str, file);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
