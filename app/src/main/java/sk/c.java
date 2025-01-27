package sk;

import android.content.Context;

/* loaded from: classes5.dex */
public final class c {
    public static boolean a(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        String packageName = context.getPackageName();
        String str = "/data/data/" + packageName + "/files";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("/data/user/0/");
        sb2.append(packageName);
        sb2.append("/files");
        return (str.equals(absolutePath) || sb2.toString().equals(absolutePath)) ? false : true;
    }
}
