package com.aggmoread.sdk.z.b.j;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import java.io.File;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static String f4590a = "com.aggmoread.sdk.a.adcomm.amsdk.AMFilesProvider";

    public static Uri a(@NonNull Context context, @NonNull String str, @NonNull File file) {
        try {
            Class<?> cls = Class.forName(f4590a);
            return (Uri) cls.getMethod("getUriForFile", Context.class, String.class, File.class).invoke(cls, context, str, file);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
