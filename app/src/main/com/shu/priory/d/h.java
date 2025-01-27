package com.shu.priory.d;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.shu.priory.d.i;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class h implements i.a {

    /* renamed from: a */
    private static volatile h f16918a;

    /* renamed from: b */
    private final Context f16919b;

    /* renamed from: com.shu.priory.d.h$1 */
    public class AnonymousClass1 extends Thread {
        public AnonymousClass1() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                h.this.b();
                new i(h.this.f16919b, h.f16918a).a();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.shu.priory.d.h$2 */
    public class AnonymousClass2 extends Thread {
        public AnonymousClass2() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                SystemClock.sleep(5000L);
                h.this.f();
            } catch (Throwable unused) {
            }
        }
    }

    private h(Context context) {
        this.f16919b = context.getApplicationContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.ByteArrayOutputStream, java.io.Closeable] */
    private String b(String str) {
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        ?? r52;
        FileOutputStream fileOutputStream;
        int i10;
        String str2;
        File file = new File(str);
        FileOutputStream fileOutputStream2 = null;
        if (!file.exists() || file.length() <= 0) {
            return null;
        }
        File file2 = new File(str + p1.a.f29680b);
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable unused) {
            fileInputStream = null;
            bufferedInputStream = null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(fileInputStream);
        } catch (Throwable unused2) {
            bufferedInputStream = null;
            r52 = bufferedInputStream;
            fileOutputStream = r52;
            try {
                b(file2);
                b(file);
                return null;
            } finally {
                a(fileOutputStream);
                a(bufferedInputStream);
                a(fileInputStream);
                a((Closeable) r52);
            }
        }
        try {
            byte[] bArr = new byte[1024];
            r52 = new ByteArrayOutputStream();
            while (true) {
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    r52.write(bArr, 0, read);
                } catch (Throwable unused3) {
                    fileOutputStream = null;
                }
            }
            byte[] byteArray = r52.toByteArray();
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[byteArray.length - 16];
            int i11 = 0;
            int i12 = 0;
            int i13 = 1;
            for (i10 = 0; i10 < byteArray.length; i10++) {
                if (i11 >= 16 || i10 != i13) {
                    bArr3[i12] = byteArray[i10];
                    i12++;
                } else {
                    bArr2[i11] = byteArray[i10];
                    i13 += i11 + 3;
                    i11++;
                }
            }
            byte[] b10 = a.b(bArr3, bArr2);
            if (b10 != null) {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    fileOutputStream.write(b10);
                    fileOutputStream.flush();
                    str2 = file2.getAbsolutePath();
                    fileOutputStream2 = fileOutputStream;
                } catch (Throwable unused4) {
                    b(file2);
                    b(file);
                    return null;
                }
            } else {
                str2 = null;
            }
            a(fileOutputStream2);
            a(bufferedInputStream);
            a(fileInputStream);
            a((Closeable) r52);
            return str2;
        } catch (Throwable unused5) {
            r52 = 0;
            fileOutputStream = r52;
            b(file2);
            b(file);
            return null;
        }
    }

    private String e() {
        File file = new File(a());
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        File[] listFiles = file.listFiles();
        if (listFiles.length == 1 && listFiles[0].exists() && listFiles[0].isFile()) {
            return listFiles[0].getAbsolutePath();
        }
        b();
        return null;
    }

    public void f() {
        File[] listFiles;
        File file = new File(a());
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2 != null) {
                b(file2);
            }
        }
    }

    private boolean g() {
        try {
            Class.forName("com.iflytek.idata.extension.IFlyCollectorExt");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private String h() {
        try {
            ActivityManager activityManager = (ActivityManager) this.f16919b.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager == null) {
                return null;
            }
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null || runningAppProcesses.isEmpty()) {
                return null;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void c() {
        try {
            if (Build.VERSION.SDK_INT <= 29 && this.f16919b.getPackageName().equals(h()) && !g() && com.shu.priory.param.d.f(this.f16919b)) {
                new Thread() { // from class: com.shu.priory.d.h.1
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            h.this.b();
                            new i(h.this.f16919b, h.f16918a).a();
                        } catch (Throwable unused) {
                        }
                    }
                }.start();
            }
        } catch (Throwable unused) {
        }
    }

    public static h a(Context context) {
        if (f16918a == null) {
            synchronized (h.class) {
                try {
                    if (f16918a == null) {
                        f16918a = new h(context);
                    }
                } finally {
                }
            }
        }
        return f16918a;
    }

    public void b() {
        a(new File(a()));
    }

    private Object a(String str) {
        try {
            String b10 = b(str);
            if (TextUtils.isEmpty(b10)) {
                return null;
            }
            String a10 = d.a("33FBC46CBF0C2674E638EE9C34FA06F5AECBD391B4926E4C5E2F7762C5D4E6B35590B3AB5A01879305817B3BD5A0233A", "6C48747470516C6F6443634A6961454434");
            String a11 = d.a("524F4EA03A304B4FAA6F65C6679558AA6DAE66F68D0B58C0E2F85D11553D0FE1", "6C48747470516C6F6443634A6961454434");
            String a12 = d.a("48F1E63A746E1ED8FA7522856A8F4BDC079633D34AE1E5F98E7C7E00EDAD12E4", "6C48747470516C6F6443634A6961454434");
            if (!TextUtils.isEmpty(a10) && !TextUtils.isEmpty(a11) && !TextUtils.isEmpty(a12)) {
                String a13 = d.a("635D9CDAD288F6E202B882717E6551393F2F4DFD5C4D2242F06D9E7A9A71539AE0913881F25B7CAC217EA749F5B97CB9", "6C48747470516C6F6443634A6961454434");
                if (TextUtils.isEmpty(a13)) {
                    return null;
                }
                Class<?> cls = Class.forName(a10);
                Method method = Context.class.getMethod(a11, null);
                Method method2 = cls.getMethod(a12, String.class);
                Object newInstance = cls.getConstructor(String.class, String.class, String.class, Class.forName(a13)).newInstance(b10, a(), null, method.invoke(this.f16919b, null));
                return ((Class) method2.invoke(newInstance, "com.council.pd2.SDKManager")).getMethod("getInstance", Context.class).invoke(newInstance, this.f16919b);
            }
            return null;
        } catch (Throwable unused) {
            b();
            return null;
        }
    }

    private void b(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                b(file2);
            }
        }
        file.delete();
    }

    public String a() {
        String str = this.f16919b.getFilesDir().getAbsolutePath() + File.separator + "council/pd/cache";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    private void a(File file) {
        File[] listFiles;
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2 != null) {
                b(file2);
            }
        }
    }

    private void a(Object obj, List<String> list, String str) {
        if (obj == null) {
            return;
        }
        try {
            Method method = obj.getClass().getMethod("request", String.class, String.class);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                method.invoke(obj, it.next(), str);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.shu.priory.d.i.a
    public void a(List<String> list, String str) {
        String e10 = e();
        if (TextUtils.isEmpty(e10)) {
            return;
        }
        a(a(e10), list, str);
        new Thread() { // from class: com.shu.priory.d.h.2
            public AnonymousClass2() {
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    SystemClock.sleep(5000L);
                    h.this.f();
                } catch (Throwable unused) {
                }
            }
        }.start();
    }
}
