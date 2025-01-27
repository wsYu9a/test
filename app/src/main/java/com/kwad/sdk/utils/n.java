package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import androidx.core.os.EnvironmentCompat;
import com.kwad.sdk.service.ServiceProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class n {
    public static com.kwad.sdk.h.kwai.d azo;

    static class a extends com.kwad.sdk.h.kwai.a {

        /* renamed from: com.kwad.sdk.utils.n$a$1 */
        final class AnonymousClass1 extends com.kwad.sdk.h.kwai.a {
            AnonymousClass1(boolean z) {
                super(z);
            }

            @Override // com.kwad.sdk.h.kwai.a
            public final boolean bs(Context context) {
                String str = Build.PRODUCT;
                int i2 = (str.contains(com.baidu.mobads.sdk.internal.bj.f5602g) || str.contains("Andy") || str.contains("ttVM_Hdragon") || str.contains("google_sdk") || str.contains("Droid4X") || str.contains("nox") || str.contains("sdk_x86") || str.contains("sdk_google") || str.contains("vbox86p") || str.contains("aries")) ? 1 : 0;
                String str2 = Build.MANUFACTURER;
                if (str2.equals(EnvironmentCompat.MEDIA_UNKNOWN) || str2.equals("Genymotion") || str2.contains("Andy") || str2.contains("MIT") || str2.contains("nox") || str2.contains("TiantianVM")) {
                    i2++;
                }
                String str3 = Build.BRAND;
                if (str3.equals("generic") || str3.equals("generic_x86") || str3.equals("TTVM") || str3.contains("Andy")) {
                    i2++;
                }
                String str4 = Build.DEVICE;
                if (str4.contains("generic") || str4.contains("generic_x86") || str4.contains("Andy") || str4.contains("ttVM_Hdragon") || str4.contains("Droid4X") || str4.contains("nox") || str4.contains("generic_x86_64") || str4.contains("vbox86p") || str4.contains("aries")) {
                    i2++;
                }
                String str5 = Build.MODEL;
                if (str5.equals(com.baidu.mobads.sdk.internal.bj.f5602g) || str5.contains("Emulator") || str5.equals("google_sdk") || str5.contains("Droid4X") || str5.contains("TiantianVM") || str5.contains("Andy") || str5.equals("Android SDK built for x86_64") || str5.equals("Android SDK built for x86")) {
                    i2++;
                }
                String str6 = Build.HARDWARE;
                if (str6.equals("goldfish") || str6.equals("vbox86") || str6.contains("nox") || str6.contains("ttVM_x86")) {
                    i2++;
                }
                String str7 = Build.FINGERPRINT;
                if (str7.contains("generic/sdk/generic") || str7.contains("generic_x86/sdk_x86/generic_x86") || str7.contains("Andy") || str7.contains("ttVM_Hdragon") || str7.contains("generic_x86_64") || str7.contains("generic/google_sdk/generic") || str7.contains("vbox86p") || str7.contains("generic/vbox86p/vbox86p")) {
                    i2++;
                }
                try {
                    if (new File(Environment.getExternalStorageDirectory().toString() + File.separatorChar + "windows" + File.separatorChar + "BstSharedFolder").exists()) {
                        i2 += 10;
                    }
                } catch (Exception unused) {
                }
                return i2 > 3;
            }
        }

        /* renamed from: com.kwad.sdk.utils.n$a$2 */
        final class AnonymousClass2 extends com.kwad.sdk.h.kwai.a {
            AnonymousClass2(boolean z) {
                super(z);
            }

            @Override // com.kwad.sdk.h.kwai.a
            public final boolean bs(Context context) {
                return "1".equals(bc.get("ro.kernel.qemu"));
            }
        }

        public a() {
            CT();
        }

        private void CT() {
            ArrayList arrayList = new ArrayList();
            this.axx = arrayList;
            arrayList.add(new com.kwad.sdk.h.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.a.1
                AnonymousClass1(boolean z) {
                    super(z);
                }

                @Override // com.kwad.sdk.h.kwai.a
                public final boolean bs(Context context) {
                    String str = Build.PRODUCT;
                    int i2 = (str.contains(com.baidu.mobads.sdk.internal.bj.f5602g) || str.contains("Andy") || str.contains("ttVM_Hdragon") || str.contains("google_sdk") || str.contains("Droid4X") || str.contains("nox") || str.contains("sdk_x86") || str.contains("sdk_google") || str.contains("vbox86p") || str.contains("aries")) ? 1 : 0;
                    String str2 = Build.MANUFACTURER;
                    if (str2.equals(EnvironmentCompat.MEDIA_UNKNOWN) || str2.equals("Genymotion") || str2.contains("Andy") || str2.contains("MIT") || str2.contains("nox") || str2.contains("TiantianVM")) {
                        i2++;
                    }
                    String str3 = Build.BRAND;
                    if (str3.equals("generic") || str3.equals("generic_x86") || str3.equals("TTVM") || str3.contains("Andy")) {
                        i2++;
                    }
                    String str4 = Build.DEVICE;
                    if (str4.contains("generic") || str4.contains("generic_x86") || str4.contains("Andy") || str4.contains("ttVM_Hdragon") || str4.contains("Droid4X") || str4.contains("nox") || str4.contains("generic_x86_64") || str4.contains("vbox86p") || str4.contains("aries")) {
                        i2++;
                    }
                    String str5 = Build.MODEL;
                    if (str5.equals(com.baidu.mobads.sdk.internal.bj.f5602g) || str5.contains("Emulator") || str5.equals("google_sdk") || str5.contains("Droid4X") || str5.contains("TiantianVM") || str5.contains("Andy") || str5.equals("Android SDK built for x86_64") || str5.equals("Android SDK built for x86")) {
                        i2++;
                    }
                    String str6 = Build.HARDWARE;
                    if (str6.equals("goldfish") || str6.equals("vbox86") || str6.contains("nox") || str6.contains("ttVM_x86")) {
                        i2++;
                    }
                    String str7 = Build.FINGERPRINT;
                    if (str7.contains("generic/sdk/generic") || str7.contains("generic_x86/sdk_x86/generic_x86") || str7.contains("Andy") || str7.contains("ttVM_Hdragon") || str7.contains("generic_x86_64") || str7.contains("generic/google_sdk/generic") || str7.contains("vbox86p") || str7.contains("generic/vbox86p/vbox86p")) {
                        i2++;
                    }
                    try {
                        if (new File(Environment.getExternalStorageDirectory().toString() + File.separatorChar + "windows" + File.separatorChar + "BstSharedFolder").exists()) {
                            i2 += 10;
                        }
                    } catch (Exception unused) {
                    }
                    return i2 > 3;
                }
            });
            this.axx.add(new com.kwad.sdk.h.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.a.2
                AnonymousClass2(boolean z) {
                    super(z);
                }

                @Override // com.kwad.sdk.h.kwai.a
                public final boolean bs(Context context) {
                    return "1".equals(bc.get("ro.kernel.qemu"));
                }
            });
        }
    }

    static class b extends com.kwad.sdk.h.kwai.a {
    }

    static class c extends com.kwad.sdk.h.kwai.a {
    }

    static class d extends com.kwad.sdk.h.kwai.a {

        /* renamed from: com.kwad.sdk.utils.n$d$1 */
        final class AnonymousClass1 extends com.kwad.sdk.h.kwai.a {
            AnonymousClass1(boolean z) {
                super(z);
            }

            @Override // com.kwad.sdk.h.kwai.a
            public final boolean bs(Context context) {
                return new File("/system/app/Superuser.apk").exists();
            }
        }

        /* renamed from: com.kwad.sdk.utils.n$d$2 */
        final class AnonymousClass2 extends com.kwad.sdk.h.kwai.a {
            AnonymousClass2(boolean z) {
                super(z);
            }

            @Override // com.kwad.sdk.h.kwai.a
            public final boolean bs(Context context) {
                String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
                for (int i2 = 0; i2 < 5; i2++) {
                    if (new File(strArr[i2] + com.kuaishou.weapon.p0.bh.y).exists()) {
                        return true;
                    }
                }
                return false;
            }
        }

        /* renamed from: com.kwad.sdk.utils.n$d$3 */
        final class AnonymousClass3 extends com.kwad.sdk.h.kwai.a {
            AnonymousClass3(boolean z) {
                super(z);
            }

            @Override // com.kwad.sdk.h.kwai.a
            public final boolean bs(Context context) {
                return !TextUtils.isEmpty(n.g(new String[]{"/system/xbin/which", com.kuaishou.weapon.p0.bh.y}));
            }
        }

        /* renamed from: com.kwad.sdk.utils.n$d$4 */
        final class AnonymousClass4 extends com.kwad.sdk.h.kwai.a {
            AnonymousClass4(boolean z) {
                super(z);
            }

            @Override // com.kwad.sdk.h.kwai.a
            public final boolean bs(Context context) {
                Charset forName = Charset.forName("UTF-8");
                File file = new File("/data/su_test");
                try {
                    q.a(file, "ok", forName, false);
                    return q.a(file, forName).equals("ok");
                } catch (Throwable unused) {
                    return false;
                }
            }
        }

        public d() {
            CT();
        }

        private void CT() {
            ArrayList arrayList = new ArrayList();
            this.axx = arrayList;
            arrayList.add(new com.kwad.sdk.h.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.1
                AnonymousClass1(boolean z) {
                    super(z);
                }

                @Override // com.kwad.sdk.h.kwai.a
                public final boolean bs(Context context) {
                    return new File("/system/app/Superuser.apk").exists();
                }
            });
            this.axx.add(new com.kwad.sdk.h.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.2
                AnonymousClass2(boolean z) {
                    super(z);
                }

                @Override // com.kwad.sdk.h.kwai.a
                public final boolean bs(Context context) {
                    String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
                    for (int i2 = 0; i2 < 5; i2++) {
                        if (new File(strArr[i2] + com.kuaishou.weapon.p0.bh.y).exists()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            this.axx.add(new com.kwad.sdk.h.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.3
                AnonymousClass3(boolean z) {
                    super(z);
                }

                @Override // com.kwad.sdk.h.kwai.a
                public final boolean bs(Context context) {
                    return !TextUtils.isEmpty(n.g(new String[]{"/system/xbin/which", com.kuaishou.weapon.p0.bh.y}));
                }
            });
            this.axx.add(new com.kwad.sdk.h.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.4
                AnonymousClass4(boolean z) {
                    super(z);
                }

                @Override // com.kwad.sdk.h.kwai.a
                public final boolean bs(Context context) {
                    Charset forName = Charset.forName("UTF-8");
                    File file = new File("/data/su_test");
                    try {
                        q.a(file, "ok", forName, false);
                        return q.a(file, forName).equals("ok");
                    } catch (Throwable unused) {
                        return false;
                    }
                }
            });
        }
    }

    static class e extends com.kwad.sdk.h.kwai.a {

        /* renamed from: com.kwad.sdk.utils.n$e$1 */
        final class AnonymousClass1 extends com.kwad.sdk.h.kwai.a {
            AnonymousClass1(boolean z) {
                super(z);
            }

            @Override // com.kwad.sdk.h.kwai.a
            public final boolean bs(Context context) {
                return ak.ah(context, "de.robv.android.xposed.installer") || ak.ah(context, "com.saurik.substrate");
            }
        }

        /* renamed from: com.kwad.sdk.utils.n$e$2 */
        final class AnonymousClass2 extends com.kwad.sdk.h.kwai.a {
            AnonymousClass2(boolean z) {
                super(z);
            }

            @Override // com.kwad.sdk.h.kwai.a
            public final boolean bs(Context context) {
                try {
                    throw new Exception("empty");
                } catch (Exception e2) {
                    boolean z = false;
                    int i2 = 0;
                    for (StackTraceElement stackTraceElement : e2.getStackTrace()) {
                        String className = stackTraceElement.getClassName();
                        String methodName = stackTraceElement.getMethodName();
                        if (className.equals("com.android.internal.os.ZygoteInit") && (i2 = i2 + 1) == 2) {
                            z = true;
                        }
                        if (className.equals("com.saurik.substrate.MS$2") && methodName.equals("invoked")) {
                            Log.wtf("HookDetection", "A method on the stack trace has been hooked using Substrate.");
                            z = true;
                        }
                        if (className.equals(com.kuaishou.weapon.p0.an.f9076b) && methodName.equals("main")) {
                            z = true;
                        }
                        if (className.equals(com.kuaishou.weapon.p0.an.f9076b) && methodName.equals("handleHookedMethod")) {
                            z = true;
                        }
                    }
                    return z;
                }
            }
        }

        /* renamed from: com.kwad.sdk.utils.n$e$3 */
        final class AnonymousClass3 extends com.kwad.sdk.h.kwai.a {
            AnonymousClass3(boolean z) {
                super(z);
            }

            @Override // com.kwad.sdk.h.kwai.a
            public final boolean bs(Context context) {
                BufferedReader bufferedReader;
                FileReader fileReader;
                Throwable th;
                BufferedReader bufferedReader2 = null;
                boolean z = false;
                try {
                    HashSet<String> hashSet = new HashSet();
                    fileReader = new FileReader("/proc/" + Process.myPid() + "/maps");
                    try {
                        bufferedReader = new BufferedReader(fileReader);
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                                    hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                                }
                            } catch (Exception unused) {
                                bufferedReader2 = bufferedReader;
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                                com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                                return z;
                            } catch (Throwable th2) {
                                th = th2;
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                                throw th;
                            }
                        }
                        for (String str : hashSet) {
                            if (str.contains("com.saurik.substrate")) {
                                Log.wtf("HookDetection", "Substrate shared object found: " + str);
                                z = true;
                            }
                            if (str.contains("XposedBridge.jar")) {
                                Log.wtf("HookDetection", "Xposed JAR found: " + str);
                                z = true;
                            }
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    } catch (Exception unused2) {
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                        th = th;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                        throw th;
                    }
                } catch (Exception unused3) {
                    fileReader = null;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    fileReader = null;
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                return z;
            }
        }

        public e() {
            CT();
        }

        private void CT() {
            ArrayList arrayList = new ArrayList();
            this.axx = arrayList;
            arrayList.add(new com.kwad.sdk.h.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.e.1
                AnonymousClass1(boolean z) {
                    super(z);
                }

                @Override // com.kwad.sdk.h.kwai.a
                public final boolean bs(Context context) {
                    return ak.ah(context, "de.robv.android.xposed.installer") || ak.ah(context, "com.saurik.substrate");
                }
            });
            this.axx.add(new com.kwad.sdk.h.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.e.2
                AnonymousClass2(boolean z) {
                    super(z);
                }

                @Override // com.kwad.sdk.h.kwai.a
                public final boolean bs(Context context) {
                    try {
                        throw new Exception("empty");
                    } catch (Exception e2) {
                        boolean z = false;
                        int i2 = 0;
                        for (StackTraceElement stackTraceElement : e2.getStackTrace()) {
                            String className = stackTraceElement.getClassName();
                            String methodName = stackTraceElement.getMethodName();
                            if (className.equals("com.android.internal.os.ZygoteInit") && (i2 = i2 + 1) == 2) {
                                z = true;
                            }
                            if (className.equals("com.saurik.substrate.MS$2") && methodName.equals("invoked")) {
                                Log.wtf("HookDetection", "A method on the stack trace has been hooked using Substrate.");
                                z = true;
                            }
                            if (className.equals(com.kuaishou.weapon.p0.an.f9076b) && methodName.equals("main")) {
                                z = true;
                            }
                            if (className.equals(com.kuaishou.weapon.p0.an.f9076b) && methodName.equals("handleHookedMethod")) {
                                z = true;
                            }
                        }
                        return z;
                    }
                }
            });
            this.axx.add(new com.kwad.sdk.h.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.e.3
                AnonymousClass3(boolean z) {
                    super(z);
                }

                @Override // com.kwad.sdk.h.kwai.a
                public final boolean bs(Context context) {
                    BufferedReader bufferedReader;
                    FileReader fileReader;
                    Throwable th;
                    BufferedReader bufferedReader2 = null;
                    boolean z = false;
                    try {
                        HashSet<String> hashSet = new HashSet();
                        fileReader = new FileReader("/proc/" + Process.myPid() + "/maps");
                        try {
                            bufferedReader = new BufferedReader(fileReader);
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                                        hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                                    }
                                } catch (Exception unused) {
                                    bufferedReader2 = bufferedReader;
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                                    return z;
                                } catch (Throwable th2) {
                                    th = th2;
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                                    throw th;
                                }
                            }
                            for (String str : hashSet) {
                                if (str.contains("com.saurik.substrate")) {
                                    Log.wtf("HookDetection", "Substrate shared object found: " + str);
                                    z = true;
                                }
                                if (str.contains("XposedBridge.jar")) {
                                    Log.wtf("HookDetection", "Xposed JAR found: " + str);
                                    z = true;
                                }
                            }
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        } catch (Exception unused2) {
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = null;
                            th = th;
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                            throw th;
                        }
                    } catch (Exception unused3) {
                        fileReader = null;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedReader = null;
                        fileReader = null;
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                    return z;
                }
            });
        }
    }

    @WorkerThread
    public static synchronized com.kwad.sdk.h.kwai.d CS() {
        synchronized (n.class) {
            if (!((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sA()) {
                return null;
            }
            com.kwad.sdk.h.kwai.d dVar = azo;
            if (dVar != null) {
                return dVar;
            }
            Context applicationContext = ServiceProvider.getContext().getApplicationContext();
            com.kwad.sdk.h.kwai.d dVar2 = new com.kwad.sdk.h.kwai.d(applicationContext);
            boolean br = new d().br(applicationContext);
            boolean br2 = new e().br(applicationContext);
            boolean br3 = new b().br(applicationContext);
            boolean br4 = new a().br(applicationContext);
            boolean br5 = new c().br(applicationContext);
            dVar2.bp(br);
            dVar2.bq(br2);
            dVar2.br(br3);
            dVar2.bt(br4);
            dVar2.bu(br5);
            azo = dVar2;
            return dVar2;
        }
    }

    public static String g(String[] strArr) {
        try {
            return com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec(strArr).getInputStream());
        } catch (Exception unused) {
            return null;
        }
    }
}
