package com.wbl.ad.yzz.util;

import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.io.Closeable;
import java.io.File;

/* loaded from: classes5.dex */
public final class k {

    public interface a {
        void a(int i2);
    }

    public static File a(Context context, String str) {
        return (File) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8279, null, context, str);
    }

    public static String a(File file, a aVar) throws Exception {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8274, null, file, aVar);
    }

    public static void a(Closeable closeable) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8273, null, closeable);
    }

    public static void a(File file) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8276, null, file);
    }

    public static boolean a(File file, File file2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8275, null, file, file2);
    }

    public static byte[] a(int i2, File file, a aVar) {
        return (byte[]) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8366, null, Integer.valueOf(i2), file, aVar);
    }

    public static boolean b(File file) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8365, null, file);
    }

    public static boolean c(File file) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8368, null, file);
    }

    public static String d(File file) throws Exception {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8367, null, file);
    }

    public static boolean e(File file) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8362, null, file);
    }
}
