package com.wbl.ad.yzz.util.f0.e;

import android.app.Activity;
import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes5.dex */
public final class n {

    /* renamed from: a */
    public static final Charset f34332a = Charset.forName("US-ASCII");

    /* renamed from: b */
    public static final char[] f34333b;

    /* renamed from: c */
    public static final char[] f34334c;

    static {
        Charset.forName("UTF-8");
        f34333b = "0123456789abcdef".toCharArray();
        f34334c = new char[64];
    }

    public static String a(byte[] bArr) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8294, null, bArr);
    }

    public static String a(byte[] bArr, char[] cArr) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8293, null, bArr, cArr);
    }

    public static void a(Closeable closeable) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8296, null, closeable);
    }

    public static void a(File file) throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8295, null, file);
    }

    public static boolean a(Activity activity) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8290, null, activity);
    }

    public static boolean a(Context context) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8289, null, context);
    }
}
