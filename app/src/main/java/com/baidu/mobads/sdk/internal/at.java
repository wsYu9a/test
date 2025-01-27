package com.baidu.mobads.sdk.internal;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.av;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class at extends av.a {

    /* renamed from: a */
    public static final String f5543a = "local";

    /* renamed from: b */
    private static final int f5544b = 4000;

    /* renamed from: c */
    private static final int f5545c = 23;

    /* renamed from: d */
    private static final int f5546d = 5;

    /* renamed from: e */
    private static final Pattern f5547e = Pattern.compile("(\\$\\d+)+$");

    /* renamed from: f */
    private static final char f5548f = 9556;

    /* renamed from: g */
    private static final char f5549g = 9562;

    /* renamed from: h */
    private static final char f5550h = 9567;

    /* renamed from: i */
    private static final char f5551i = 9553;

    /* renamed from: j */
    private static final String f5552j = "════════════════════════════════════════════";
    private static final String k = "------------------------------------------";
    private static final String l = "╔════════════════════════════════════════════════════════════════════════════════════════";
    private static final String m = "╚════════════════════════════════════════════════════════════════════════════════════════";
    private static final String n = "╟------------------------------------------------------------------------------------";

    @Override // com.baidu.mobads.sdk.internal.av.a
    @NonNull
    String a() {
        return f5543a;
    }

    protected String a(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        Matcher matcher = f5547e.matcher(className);
        if (matcher.find()) {
            className = matcher.replaceAll("");
        }
        String substring = className.substring(className.lastIndexOf(46) + 1);
        return (substring.length() <= 23 || Build.VERSION.SDK_INT >= 24) ? substring : substring.substring(0, 23);
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    final String b() {
        String b2 = super.b();
        if (b2 != null) {
            return b2;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        return stackTrace.length <= 5 ? "" : a(stackTrace[5]);
    }

    protected String c() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        boolean z = false;
        int i2 = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Matcher matcher = f5547e.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            if (!className.equals(av.class.getName()) && !className.equals(bq.class.getName())) {
                if (z) {
                    break;
                }
            } else {
                z = true;
            }
            i2++;
        }
        return "   (" + stackTrace[i2].getFileName() + ":" + stackTrace[i2].getLineNumber() + ")# " + stackTrace[i2].getMethodName();
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    protected void a(int i2, String str, String str2, Throwable th) {
        int min;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("当前线程：");
            sb.append(Thread.currentThread().getName());
            sb.append(";  ");
            sb.append("调用位置：");
            sb.append(c());
            sb.append(";  ");
            sb.append("打印消息：");
            if (str2.length() > f5544b) {
                ArrayList arrayList = new ArrayList();
                int length = str2.length();
                int i3 = 0;
                while (i3 < length) {
                    int indexOf = str2.indexOf(10, i3);
                    if (indexOf == -1) {
                        indexOf = length;
                    }
                    while (true) {
                        min = Math.min(indexOf, i3 + f5544b);
                        arrayList.add(str2.substring(i3, min));
                        if (min >= indexOf) {
                            break;
                        } else {
                            i3 = min;
                        }
                    }
                    i3 = min + 1;
                }
                for (String str3 : (String[]) arrayList.toArray(new String[arrayList.size()])) {
                    a(i2, str, sb.toString() + str3);
                }
                return;
            }
            sb.append(str2);
            a(i2, str, sb.toString());
        } catch (Throwable th2) {
            a(6, str, th2.toString());
        }
    }

    private static void a(int i2, String str, String str2) {
        if (i2 == 7) {
            Log.wtf(str, str2);
        } else {
            Log.println(i2, str, str2);
        }
    }
}
