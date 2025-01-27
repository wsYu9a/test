package com.baidu.mobads.sdk.internal;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.ay;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class aw extends ay.a {

    /* renamed from: a */
    public static final String f6793a = "local";

    /* renamed from: b */
    private static final int f6794b = 4000;

    /* renamed from: c */
    private static final int f6795c = 23;

    /* renamed from: d */
    private static final int f6796d = 5;

    /* renamed from: e */
    private static final Pattern f6797e = Pattern.compile("(\\$\\d+)+$");

    /* renamed from: f */
    private static final char f6798f = 9556;

    /* renamed from: g */
    private static final char f6799g = 9562;

    /* renamed from: h */
    private static final char f6800h = 9567;

    /* renamed from: i */
    private static final char f6801i = 9553;

    /* renamed from: j */
    private static final String f6802j = "════════════════════════════════════════════";

    /* renamed from: k */
    private static final String f6803k = "------------------------------------------";

    /* renamed from: l */
    private static final String f6804l = "╔════════════════════════════════════════════════════════════════════════════════════════";

    /* renamed from: m */
    private static final String f6805m = "╚════════════════════════════════════════════════════════════════════════════════════════";

    /* renamed from: n */
    private static final String f6806n = "╟------------------------------------------------------------------------------------";

    @Override // com.baidu.mobads.sdk.internal.ay.a
    @NonNull
    public String a() {
        return f6793a;
    }

    @Override // com.baidu.mobads.sdk.internal.ay.a
    public final String b() {
        String b10 = super.b();
        if (b10 != null) {
            return b10;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        return stackTrace.length <= 5 ? "" : a(stackTrace[5]);
    }

    public String c() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        boolean z10 = false;
        int i10 = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Matcher matcher = f6797e.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            if (!className.equals(ay.class.getName()) && !className.equals(bt.class.getName())) {
                if (z10) {
                    break;
                }
            } else {
                z10 = true;
            }
            i10++;
        }
        return "   (" + stackTrace[i10].getFileName() + ":" + stackTrace[i10].getLineNumber() + ")# " + stackTrace[i10].getMethodName();
    }

    public String a(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        Matcher matcher = f6797e.matcher(className);
        if (matcher.find()) {
            className = matcher.replaceAll("");
        }
        String substring = className.substring(className.lastIndexOf(46) + 1);
        return (substring.length() <= 23 || Build.VERSION.SDK_INT >= 24) ? substring : substring.substring(0, 23);
    }

    @Override // com.baidu.mobads.sdk.internal.ay.a
    public void a(int i10, String str, String str2, Throwable th2) {
        int min;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("当前线程：");
            sb2.append(Thread.currentThread().getName());
            sb2.append(";  ");
            sb2.append("调用位置：");
            sb2.append(c());
            sb2.append(";  ");
            sb2.append("打印消息：");
            if (str2.length() > 4000) {
                ArrayList arrayList = new ArrayList();
                int length = str2.length();
                int i11 = 0;
                while (i11 < length) {
                    int indexOf = str2.indexOf(10, i11);
                    if (indexOf == -1) {
                        indexOf = length;
                    }
                    while (true) {
                        min = Math.min(indexOf, i11 + 4000);
                        arrayList.add(str2.substring(i11, min));
                        if (min >= indexOf) {
                            break;
                        } else {
                            i11 = min;
                        }
                    }
                    i11 = min + 1;
                }
                for (String str3 : (String[]) arrayList.toArray(new String[arrayList.size()])) {
                    a(i10, str, sb2.toString() + str3);
                }
                return;
            }
            sb2.append(str2);
            a(i10, str, sb2.toString());
        } catch (Throwable th3) {
            a(6, str, th3.toString());
        }
    }

    private static void a(int i10, String str, String str2) {
        if (i10 == 7) {
            Log.wtf(str, str2);
        } else {
            Log.println(i10, str, str2);
        }
    }
}
