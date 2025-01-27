package com.bytedance.sdk.openadsdk.api.plugin;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final StringBuffer f8042a = new StringBuffer();

    public static void a(String str, String str2) {
        StringBuffer stringBuffer = f8042a;
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append(';');
        stringBuffer.append(str);
        stringBuffer.append(';');
        stringBuffer.append(str2);
        stringBuffer.append('\n');
    }

    public static String a() {
        return f8042a.toString();
    }
}
