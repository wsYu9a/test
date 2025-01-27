package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes3.dex */
public final class p {
    public static com.kwad.sdk.k.a.d aST;

    public static class a extends com.kwad.sdk.k.a.a {

        /* renamed from: com.kwad.sdk.utils.p$a$1 */
        public class AnonymousClass1 extends com.kwad.sdk.k.a.a {
            public AnonymousClass1(boolean z10) {
                super(z10);
            }

            @Override // com.kwad.sdk.k.a.a
            public final boolean bS(Context context) {
                String str = Build.PRODUCT;
                int i10 = (str.contains("sdk") || str.contains("Andy") || str.contains("ttVM_Hdragon") || str.contains("google_sdk") || str.contains("Droid4X") || str.contains("nox") || str.contains("sdk_x86") || str.contains("sdk_google") || str.contains("vbox86p") || str.contains("aries")) ? 1 : 0;
                String str2 = Build.MANUFACTURER;
                if (str2.equals("unknown") || str2.equals("Genymotion") || str2.contains("Andy") || str2.contains("MIT") || str2.contains("nox") || str2.contains("TiantianVM")) {
                    i10++;
                }
                String str3 = Build.BRAND;
                if (str3.equals("generic") || str3.equals("generic_x86") || str3.equals("TTVM") || str3.contains("Andy")) {
                    i10++;
                }
                String str4 = Build.DEVICE;
                if (str4.contains("generic") || str4.contains("generic_x86") || str4.contains("Andy") || str4.contains("ttVM_Hdragon") || str4.contains("Droid4X") || str4.contains("nox") || str4.contains("generic_x86_64") || str4.contains("vbox86p") || str4.contains("aries")) {
                    i10++;
                }
                String str5 = Build.MODEL;
                if (str5.equals("sdk") || str5.contains("Emulator") || str5.equals("google_sdk") || str5.contains("Droid4X") || str5.contains("TiantianVM") || str5.contains("Andy") || str5.equals("Android SDK built for x86_64") || str5.equals("Android SDK built for x86")) {
                    i10++;
                }
                String str6 = Build.HARDWARE;
                if (str6.equals("goldfish") || str6.equals("vbox86") || str6.contains("nox") || str6.contains("ttVM_x86")) {
                    i10++;
                }
                String str7 = Build.FINGERPRINT;
                if (str7.contains("generic/sdk/generic") || str7.contains("generic_x86/sdk_x86/generic_x86") || str7.contains("Andy") || str7.contains("ttVM_Hdragon") || str7.contains("generic_x86_64") || str7.contains("generic/google_sdk/generic") || str7.contains("vbox86p") || str7.contains("generic/vbox86p/vbox86p")) {
                    i10++;
                }
                try {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(Environment.getExternalStorageDirectory().toString());
                    char c10 = File.separatorChar;
                    sb2.append(c10);
                    sb2.append("windows");
                    sb2.append(c10);
                    sb2.append("BstSharedFolder");
                    if (new File(sb2.toString()).exists()) {
                        i10 += 10;
                    }
                } catch (Exception unused) {
                }
                return i10 > 3;
            }
        }

        /* renamed from: com.kwad.sdk.utils.p$a$2 */
        public class AnonymousClass2 extends com.kwad.sdk.k.a.a {
            public AnonymousClass2(boolean z10) {
                super(z10);
            }

            @Override // com.kwad.sdk.k.a.a
            public final boolean bS(Context context) {
                return "1".equals(bn.get("ro.kernel.qemu"));
            }
        }

        public a() {
            MU();
        }

        private void MU() {
            ArrayList arrayList = new ArrayList();
            this.aRk = arrayList;
            arrayList.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.p.a.1
                public AnonymousClass1(boolean z10) {
                    super(z10);
                }

                @Override // com.kwad.sdk.k.a.a
                public final boolean bS(Context context) {
                    String str = Build.PRODUCT;
                    int i10 = (str.contains("sdk") || str.contains("Andy") || str.contains("ttVM_Hdragon") || str.contains("google_sdk") || str.contains("Droid4X") || str.contains("nox") || str.contains("sdk_x86") || str.contains("sdk_google") || str.contains("vbox86p") || str.contains("aries")) ? 1 : 0;
                    String str2 = Build.MANUFACTURER;
                    if (str2.equals("unknown") || str2.equals("Genymotion") || str2.contains("Andy") || str2.contains("MIT") || str2.contains("nox") || str2.contains("TiantianVM")) {
                        i10++;
                    }
                    String str3 = Build.BRAND;
                    if (str3.equals("generic") || str3.equals("generic_x86") || str3.equals("TTVM") || str3.contains("Andy")) {
                        i10++;
                    }
                    String str4 = Build.DEVICE;
                    if (str4.contains("generic") || str4.contains("generic_x86") || str4.contains("Andy") || str4.contains("ttVM_Hdragon") || str4.contains("Droid4X") || str4.contains("nox") || str4.contains("generic_x86_64") || str4.contains("vbox86p") || str4.contains("aries")) {
                        i10++;
                    }
                    String str5 = Build.MODEL;
                    if (str5.equals("sdk") || str5.contains("Emulator") || str5.equals("google_sdk") || str5.contains("Droid4X") || str5.contains("TiantianVM") || str5.contains("Andy") || str5.equals("Android SDK built for x86_64") || str5.equals("Android SDK built for x86")) {
                        i10++;
                    }
                    String str6 = Build.HARDWARE;
                    if (str6.equals("goldfish") || str6.equals("vbox86") || str6.contains("nox") || str6.contains("ttVM_x86")) {
                        i10++;
                    }
                    String str7 = Build.FINGERPRINT;
                    if (str7.contains("generic/sdk/generic") || str7.contains("generic_x86/sdk_x86/generic_x86") || str7.contains("Andy") || str7.contains("ttVM_Hdragon") || str7.contains("generic_x86_64") || str7.contains("generic/google_sdk/generic") || str7.contains("vbox86p") || str7.contains("generic/vbox86p/vbox86p")) {
                        i10++;
                    }
                    try {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(Environment.getExternalStorageDirectory().toString());
                        char c10 = File.separatorChar;
                        sb2.append(c10);
                        sb2.append("windows");
                        sb2.append(c10);
                        sb2.append("BstSharedFolder");
                        if (new File(sb2.toString()).exists()) {
                            i10 += 10;
                        }
                    } catch (Exception unused) {
                    }
                    return i10 > 3;
                }
            });
            this.aRk.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.p.a.2
                public AnonymousClass2(boolean z10) {
                    super(z10);
                }

                @Override // com.kwad.sdk.k.a.a
                public final boolean bS(Context context) {
                    return "1".equals(bn.get("ro.kernel.qemu"));
                }
            });
        }
    }

    public static class b extends com.kwad.sdk.k.a.a {
    }

    public static class c extends com.kwad.sdk.k.a.a {
    }

    public static class d extends com.kwad.sdk.k.a.a {

        /* renamed from: com.kwad.sdk.utils.p$d$1 */
        public class AnonymousClass1 extends com.kwad.sdk.k.a.a {
            public AnonymousClass1(boolean z10) {
                super(z10);
            }

            @Override // com.kwad.sdk.k.a.a
            public final boolean bS(Context context) {
                return new File("/system/app/Superuser.apk").exists();
            }
        }

        /* renamed from: com.kwad.sdk.utils.p$d$2 */
        public class AnonymousClass2 extends com.kwad.sdk.k.a.a {
            public AnonymousClass2(boolean z10) {
                super(z10);
            }

            @Override // com.kwad.sdk.k.a.a
            public final boolean bS(Context context) {
                String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
                for (int i10 = 0; i10 < 5; i10++) {
                    if (new File(strArr[i10] + com.kuaishou.weapon.p0.bi.f10829y).exists()) {
                        return true;
                    }
                }
                return false;
            }
        }

        /* renamed from: com.kwad.sdk.utils.p$d$3 */
        public class AnonymousClass3 extends com.kwad.sdk.k.a.a {
            public AnonymousClass3(boolean z10) {
                super(z10);
            }

            @Override // com.kwad.sdk.k.a.a
            public final boolean bS(Context context) {
                return !TextUtils.isEmpty(p.g(new String[]{"/system/xbin/which", com.kuaishou.weapon.p0.bi.f10829y}));
            }
        }

        /* renamed from: com.kwad.sdk.utils.p$d$4 */
        public class AnonymousClass4 extends com.kwad.sdk.k.a.a {
            public AnonymousClass4(boolean z10) {
                super(z10);
            }

            @Override // com.kwad.sdk.k.a.a
            public final boolean bS(Context context) {
                Charset forName = Charset.forName("UTF-8");
                File file = new File("/data/su_test");
                try {
                    u.a(file, "ok", forName, false);
                    return u.a(file, forName).equals("ok");
                } catch (Throwable unused) {
                    return false;
                }
            }
        }

        public d() {
            MU();
        }

        private void MU() {
            ArrayList arrayList = new ArrayList();
            this.aRk = arrayList;
            arrayList.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.p.d.1
                public AnonymousClass1(boolean z10) {
                    super(z10);
                }

                @Override // com.kwad.sdk.k.a.a
                public final boolean bS(Context context) {
                    return new File("/system/app/Superuser.apk").exists();
                }
            });
            this.aRk.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.p.d.2
                public AnonymousClass2(boolean z10) {
                    super(z10);
                }

                @Override // com.kwad.sdk.k.a.a
                public final boolean bS(Context context) {
                    String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
                    for (int i10 = 0; i10 < 5; i10++) {
                        if (new File(strArr[i10] + com.kuaishou.weapon.p0.bi.f10829y).exists()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            this.aRk.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.p.d.3
                public AnonymousClass3(boolean z10) {
                    super(z10);
                }

                @Override // com.kwad.sdk.k.a.a
                public final boolean bS(Context context) {
                    return !TextUtils.isEmpty(p.g(new String[]{"/system/xbin/which", com.kuaishou.weapon.p0.bi.f10829y}));
                }
            });
            this.aRk.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.p.d.4
                public AnonymousClass4(boolean z10) {
                    super(z10);
                }

                @Override // com.kwad.sdk.k.a.a
                public final boolean bS(Context context) {
                    Charset forName = Charset.forName("UTF-8");
                    File file = new File("/data/su_test");
                    try {
                        u.a(file, "ok", forName, false);
                        return u.a(file, forName).equals("ok");
                    } catch (Throwable unused) {
                        return false;
                    }
                }
            });
        }
    }

    public static class e extends com.kwad.sdk.k.a.a {

        /* renamed from: com.kwad.sdk.utils.p$e$1 */
        public class AnonymousClass1 extends com.kwad.sdk.k.a.a {
            public AnonymousClass1(boolean z10) {
                super(z10);
            }

            @Override // com.kwad.sdk.k.a.a
            public final boolean bS(Context context) {
                return ap.an(context, "de.robv.android.xposed.installer") || ap.an(context, "com.saurik.substrate");
            }
        }

        /* renamed from: com.kwad.sdk.utils.p$e$2 */
        public class AnonymousClass2 extends com.kwad.sdk.k.a.a {
            public AnonymousClass2(boolean z10) {
                super(z10);
            }

            @Override // com.kwad.sdk.k.a.a
            public final boolean bS(Context context) {
                try {
                    throw new Exception("empty");
                } catch (Exception e10) {
                    boolean z10 = false;
                    int i10 = 0;
                    for (StackTraceElement stackTraceElement : e10.getStackTrace()) {
                        String className = stackTraceElement.getClassName();
                        String methodName = stackTraceElement.getMethodName();
                        if (className.equals("com.android.internal.os.ZygoteInit") && (i10 = i10 + 1) == 2) {
                            z10 = true;
                        }
                        if (className.equals("com.saurik.substrate.MS$2") && methodName.equals("invoked")) {
                            Log.wtf("HookDetection", "A method on the stack trace has been hooked using Substrate.");
                            z10 = true;
                        }
                        if (className.equals(com.kuaishou.weapon.p0.an.f10772b) && methodName.equals("main")) {
                            z10 = true;
                        }
                        if (className.equals(com.kuaishou.weapon.p0.an.f10772b) && methodName.equals("handleHookedMethod")) {
                            z10 = true;
                        }
                    }
                    return z10;
                }
            }
        }

        /* renamed from: com.kwad.sdk.utils.p$e$3 */
        public class AnonymousClass3 extends com.kwad.sdk.k.a.a {
            public AnonymousClass3(boolean z10) {
                super(z10);
            }

            @Override // com.kwad.sdk.k.a.a
            public final boolean bS(Context context) {
                FileReader fileReader;
                boolean z10 = false;
                BufferedReader bufferedReader = null;
                try {
                    HashSet<String> hashSet = new HashSet();
                    fileReader = new FileReader("/proc/" + Process.myPid() + "/maps");
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(fileReader);
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                if (!readLine.endsWith(".so") && !readLine.endsWith(".jar")) {
                                }
                                hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                            } catch (Exception unused) {
                                bufferedReader = bufferedReader2;
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                                return z10;
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedReader = bufferedReader2;
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                                throw th;
                            }
                        }
                        for (String str : hashSet) {
                            if (str.contains("com.saurik.substrate")) {
                                Log.wtf("HookDetection", "Substrate shared object found: " + str);
                                z10 = true;
                            }
                            if (str.contains("XposedBridge.jar")) {
                                Log.wtf("HookDetection", "Xposed JAR found: " + str);
                                z10 = true;
                            }
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                    } catch (Exception unused2) {
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Exception unused3) {
                    fileReader = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileReader = null;
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                return z10;
            }
        }

        public e() {
            MU();
        }

        private void MU() {
            ArrayList arrayList = new ArrayList();
            this.aRk = arrayList;
            arrayList.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.p.e.1
                public AnonymousClass1(boolean z10) {
                    super(z10);
                }

                @Override // com.kwad.sdk.k.a.a
                public final boolean bS(Context context) {
                    return ap.an(context, "de.robv.android.xposed.installer") || ap.an(context, "com.saurik.substrate");
                }
            });
            this.aRk.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.p.e.2
                public AnonymousClass2(boolean z10) {
                    super(z10);
                }

                @Override // com.kwad.sdk.k.a.a
                public final boolean bS(Context context) {
                    try {
                        throw new Exception("empty");
                    } catch (Exception e10) {
                        boolean z10 = false;
                        int i10 = 0;
                        for (StackTraceElement stackTraceElement : e10.getStackTrace()) {
                            String className = stackTraceElement.getClassName();
                            String methodName = stackTraceElement.getMethodName();
                            if (className.equals("com.android.internal.os.ZygoteInit") && (i10 = i10 + 1) == 2) {
                                z10 = true;
                            }
                            if (className.equals("com.saurik.substrate.MS$2") && methodName.equals("invoked")) {
                                Log.wtf("HookDetection", "A method on the stack trace has been hooked using Substrate.");
                                z10 = true;
                            }
                            if (className.equals(com.kuaishou.weapon.p0.an.f10772b) && methodName.equals("main")) {
                                z10 = true;
                            }
                            if (className.equals(com.kuaishou.weapon.p0.an.f10772b) && methodName.equals("handleHookedMethod")) {
                                z10 = true;
                            }
                        }
                        return z10;
                    }
                }
            });
            this.aRk.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.p.e.3
                public AnonymousClass3(boolean z10) {
                    super(z10);
                }

                @Override // com.kwad.sdk.k.a.a
                public final boolean bS(Context context) {
                    FileReader fileReader;
                    boolean z10 = false;
                    BufferedReader bufferedReader = null;
                    try {
                        HashSet<String> hashSet = new HashSet();
                        fileReader = new FileReader("/proc/" + Process.myPid() + "/maps");
                        try {
                            BufferedReader bufferedReader2 = new BufferedReader(fileReader);
                            while (true) {
                                try {
                                    String readLine = bufferedReader2.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    if (!readLine.endsWith(".so") && !readLine.endsWith(".jar")) {
                                    }
                                    hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                                } catch (Exception unused) {
                                    bufferedReader = bufferedReader2;
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                                    return z10;
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedReader = bufferedReader2;
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                                    throw th;
                                }
                            }
                            for (String str : hashSet) {
                                if (str.contains("com.saurik.substrate")) {
                                    Log.wtf("HookDetection", "Substrate shared object found: " + str);
                                    z10 = true;
                                }
                                if (str.contains("XposedBridge.jar")) {
                                    Log.wtf("HookDetection", "Xposed JAR found: " + str);
                                    z10 = true;
                                }
                            }
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                        } catch (Exception unused2) {
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Exception unused3) {
                        fileReader = null;
                    } catch (Throwable th4) {
                        th = th4;
                        fileReader = null;
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                    return z10;
                }
            });
        }
    }

    @WorkerThread
    public static synchronized com.kwad.sdk.k.a.d MT() {
        synchronized (p.class) {
            if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).zP()) {
                return null;
            }
            com.kwad.sdk.k.a.d dVar = aST;
            if (dVar != null) {
                return dVar;
            }
            Context applicationContext = ServiceProvider.getContext().getApplicationContext();
            com.kwad.sdk.k.a.d dVar2 = new com.kwad.sdk.k.a.d(applicationContext);
            boolean bR = new d().bR(applicationContext);
            boolean bR2 = new e().bR(applicationContext);
            boolean bR3 = new b().bR(applicationContext);
            boolean bR4 = new a().bR(applicationContext);
            boolean bR5 = new c().bR(applicationContext);
            dVar2.bM(bR);
            dVar2.bN(bR2);
            dVar2.bO(bR3);
            dVar2.bQ(bR4);
            dVar2.bR(bR5);
            aST = dVar2;
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
