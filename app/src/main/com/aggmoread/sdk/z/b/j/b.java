package com.aggmoread.sdk.z.b.j;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.app.NotificationManagerCompat;
import com.aggmoread.sdk.a.adcomm.amsdk.AMCustomBroadReceiver;
import com.aggmoread.sdk.z.b.j.a;
import com.aggmoread.sdk.z.b.j.n;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class b extends com.aggmoread.sdk.z.b.b {

    /* renamed from: n */
    static final AtomicInteger f4561n = new AtomicInteger(10000);

    /* renamed from: a */
    private Context f4562a;

    /* renamed from: b */
    private String f4563b;

    /* renamed from: c */
    private com.aggmoread.sdk.z.b.j.c f4564c;

    /* renamed from: d */
    private int f4565d;

    /* renamed from: e */
    private e f4566e;

    /* renamed from: f */
    private a.AbstractC0076a f4567f;

    /* renamed from: g */
    private n f4568g;

    /* renamed from: h */
    private String f4569h;

    /* renamed from: i */
    private String f4570i;

    /* renamed from: j */
    private k f4571j;

    /* renamed from: k */
    private com.aggmoread.sdk.z.b.m.h f4572k;

    /* renamed from: l */
    private String f4573l;

    /* renamed from: m */
    final Runnable f4574m;

    public class a extends i {

        /* renamed from: b */
        final /* synthetic */ String f4575b;

        /* renamed from: c */
        final /* synthetic */ String f4576c;

        /* renamed from: d */
        final /* synthetic */ String f4577d;

        /* renamed from: com.aggmoread.sdk.z.b.j.b$a$a */
        public class C0077a extends l {

            /* renamed from: b */
            final /* synthetic */ File f4579b;

            public C0077a(File file) {
                this.f4579b = file;
            }

            @Override // com.aggmoread.sdk.z.b.j.l
            public void a(Intent intent, String str, String str2, String str3) {
                com.aggmoread.sdk.z.b.d.c("ApiDownloadHelper", "onCompleted enter , onNotificationClicked = " + str2 + ", downloadId = " + b.this.f4565d);
                b.this.a(this.f4579b, d.f4583c);
                b.this.f4564c.a((long) b.this.f4565d, -2002, "click notification install apk");
            }
        }

        public a(String str, String str2, String str3) {
            this.f4575b = str;
            this.f4576c = str2;
            this.f4577d = str3;
        }

        @Override // com.aggmoread.sdk.z.b.j.i
        public void a() {
            com.aggmoread.sdk.z.b.d.c("ApiDownloadHelper", "onConnectSuccess enter");
            f.a().a(this.f4575b, 1);
        }

        @Override // com.aggmoread.sdk.z.b.j.i
        public void c() {
            f.a().a(this.f4575b, 2);
            com.aggmoread.sdk.z.b.d.c("ApiDownloadHelper", "onStartReadBytes enter");
            b.this.f4564c.b();
        }

        @Override // com.aggmoread.sdk.z.b.j.i
        public void a(int i10, String str) {
            f.a().a(this.f4575b, 0);
            com.aggmoread.sdk.z.b.d.c("ApiDownloadHelper", "onError enter , code = " + i10 + " , message = " + str);
            b.this.f4564c.b((long) b.this.f4565d, i10, str);
        }

        @Override // com.aggmoread.sdk.z.b.j.i
        public void a(File file) {
            if (file != null && file.exists()) {
                f.a().a(this.f4575b, 3);
                b.this.f4569h = file.getAbsolutePath();
                com.aggmoread.sdk.z.b.d.c("ApiDownloadHelper", "onCompleted enter , downloadFile = " + file.getAbsolutePath() + " , downloadId = " + b.this.f4565d);
                b.this.f4564c.b((long) b.this.f4565d);
                com.aggmoread.sdk.z.b.j.e.a(this.f4576c, new C0077a(file));
                b.this.a(this.f4577d, file);
                return;
            }
            f.a().a(this.f4575b, 0);
            com.aggmoread.sdk.z.b.d.c("ApiDownloadHelper", "onCompleted enter , downloadFile not found");
            b.this.f4564c.a(b.this.f4565d, -2001, "download file not found error");
        }
    }

    /* renamed from: com.aggmoread.sdk.z.b.j.b$b */
    public class C0078b extends a.AbstractC0076a {
        public C0078b(b bVar) {
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            if (bVar.a(bVar.f4562a, b.this.f4563b) || b.this.f4564c == null) {
                return;
            }
            b.this.f4564c.a(b.this.f4565d, -2005, "user cancel install");
        }
    }

    public static final class d extends Enum<d> {

        /* renamed from: b */
        public static final d f4582b = new d("DOWNLOAD_COMPLETED", 0);

        /* renamed from: c */
        public static final d f4583c = new d("NOTIFICATION_CLICK", 1);

        /* renamed from: d */
        public static final d f4584d = new d("INSTALLER_BRIDGE", 2);

        private d(String str, int i10) {
            super(str, i10);
        }
    }

    public class e extends BroadcastReceiver {

        /* renamed from: a */
        private String f4585a;

        /* renamed from: b */
        private com.aggmoread.sdk.z.b.j.c f4586b;

        public class a extends l {
            public a() {
            }

            @Override // com.aggmoread.sdk.z.b.j.l
            public void a(Intent intent, String str, String str2, String str3) {
                e.this.f4586b.a(b.this.f4565d, -2003, "click notification open apk");
                b.this.a(str3);
                com.aggmoread.sdk.z.b.j.e.a(str);
            }
        }

        public e(String str, com.aggmoread.sdk.z.b.j.c cVar) {
            this.f4585a = str;
            this.f4586b = cVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.PACKAGE_ADDED".equals(action) || "android.intent.action.PACKAGE_REPLACED".equals(action)) {
                    String dataString = intent.getDataString();
                    if (dataString != null && dataString.startsWith("package:")) {
                        dataString = dataString.substring(8);
                    }
                    com.aggmoread.sdk.z.b.d.c("ApiDownloadHelper", "installedPackageName " + dataString + " ， packageName " + this.f4585a + " , downloadListener = " + this.f4586b);
                    if (TextUtils.isEmpty(this.f4585a) || (dataString != null && dataString.contains(this.f4585a))) {
                        this.f4586b.a(b.this.f4565d);
                        com.aggmoread.sdk.z.b.m.e.a(b.this.f4574m);
                        b.this.f4562a.unregisterReceiver(this);
                        if (b.this.f4571j != null) {
                            b.this.f4571j.g();
                            com.aggmoread.sdk.z.b.j.e.a(b.this.f4570i);
                            com.aggmoread.sdk.z.b.j.e.a(b.this.f4570i, new a());
                        }
                        if (b.this.f4572k == null || TextUtils.isEmpty(this.f4585a)) {
                            return;
                        }
                        b.this.f4572k.a(this.f4585a);
                    }
                }
            }
        }
    }

    public b(Context context, String str, com.aggmoread.sdk.z.b.j.c cVar) {
        com.aggmoread.sdk.z.b.j.c cVar2 = com.aggmoread.sdk.z.b.j.c.f4589a;
        this.f4564c = cVar2;
        this.f4565d = 0;
        this.f4574m = new c();
        this.f4562a = context;
        this.f4573l = str;
        this.f4564c = cVar == null ? cVar2 : cVar;
    }

    public static File b(Context context) {
        File externalCacheDir = context.getApplicationContext().getExternalCacheDir();
        return externalCacheDir != null ? externalCacheDir : context.getApplicationContext().getCacheDir();
    }

    public static File c(Context context) {
        return new File(b(context), "amdownload");
    }

    public void d() {
        if (this.f4572k == null) {
            this.f4572k = com.aggmoread.sdk.z.b.m.h.a(this.f4562a, "appInstallInfo");
        }
        if (TextUtils.isEmpty(this.f4563b) || this.f4572k.b(this.f4563b)) {
            return;
        }
        this.f4572k.b(this.f4563b, this.f4563b + "#" + System.currentTimeMillis() + "#" + this.f4573l);
    }

    public void e() {
        C0078b c0078b = new C0078b(this);
        this.f4567f = c0078b;
        com.aggmoread.sdk.z.b.j.a.a(0, c0078b);
    }

    public void f() {
        e eVar = this.f4566e;
        if (eVar != null) {
            try {
                this.f4562a.unregisterReceiver(eVar);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private String a(File file) {
        return com.aggmoread.sdk.z.b.m.c.a(this.f4562a, file.getAbsolutePath()).e();
    }

    private boolean b(String str) {
        f();
        if (this.f4566e == null) {
            this.f4566e = new e(str, this.f4564c);
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addDataScheme("package");
            this.f4562a.registerReceiver(this.f4566e, intentFilter);
            return true;
        } catch (Exception e10) {
            e10.printStackTrace();
            this.f4564c.a(this.f4565d, -2009, "start listen package error");
            return false;
        }
    }

    public void a(String str) {
        try {
            Intent launchIntentForPackage = this.f4562a.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                this.f4562a.startActivity(launchIntentForPackage);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void a(String str, String str2, String str3) {
        com.aggmoread.sdk.z.b.d.c("ApiDownloadHelper", "areNotificationsEnabled = " + NotificationManagerCompat.from(this.f4562a).areNotificationsEnabled());
        this.f4565d = f4561n.incrementAndGet();
        this.f4563b = str2;
        com.aggmoread.sdk.z.b.d.c("ApiDownloadHelper", "downloadApk enter , packageName = " + str2 + ",ulr = " + str);
        File c10 = c(this.f4562a);
        String a10 = g.a(str);
        String str4 = a10 + ".apk";
        File file = new File(c10, str4);
        int a11 = f.a().a(a10);
        if (a11 == 1 || a11 == 2) {
            this.f4564c.a();
            Toast.makeText(this.f4562a, "广告正在下载", 0).show();
            return;
        }
        if (a11 == 3 && a(str2, file)) {
            this.f4564c.b();
            this.f4564c.b(this.f4565d);
            return;
        }
        if (file.exists()) {
            try {
                com.aggmoread.sdk.z.b.m.c.a(this.f4562a, file.getAbsolutePath()).e();
                if (a(str2, file)) {
                    this.f4564c.b();
                    this.f4564c.b(this.f4565d);
                    return;
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        this.f4570i = str;
        Intent intent = new Intent(this.f4562a, (Class<?>) com.aggmoread.sdk.z.b.j.e.a());
        intent.putExtra("apkUrl", str);
        intent.putExtra("apkPath", file.getAbsolutePath());
        intent.putExtra("packageName", str2);
        intent.setAction(AMCustomBroadReceiver.ACTION_NOTIFICATION_CLICK);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f4562a, this.f4565d, intent, 67108864);
        int i10 = com.aggmoread.sdk.z.b.h.a.d().e().f4513c;
        if (i10 == 0) {
            i10 = this.f4562a.getApplicationContext().getApplicationInfo().icon;
        }
        this.f4571j = new k(this.f4562a, this.f4565d, broadcast, a10, TextUtils.isEmpty(str3) ? "" : str3, "正在下载...", i10);
        n a12 = new n.a(this.f4562a).c(str).a(c10.getAbsolutePath()).b(str4).a(false).b(3).a(3).a(this.f4571j).a(new a(a10, str, str2)).a();
        this.f4568g = a12;
        a12.m();
        Toast.makeText(this.f4562a, "开始下载", 0).show();
    }

    private boolean a(Context context) {
        boolean canRequestPackageInstalls;
        com.aggmoread.sdk.z.b.d.c("ApiDownloadHelper", "checkInstallPermission");
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        canRequestPackageInstalls = context.getPackageManager().canRequestPackageInstalls();
        com.aggmoread.sdk.z.b.d.c("ApiDownloadHelper", "checkInstallPermission hasInstallPermission = " + canRequestPackageInstalls);
        return canRequestPackageInstalls;
    }

    private boolean a(Context context, Intent intent) {
        return context.getPackageManager().resolveActivity(intent, 0) != null;
    }

    public boolean a(Context context, String str) {
        return com.aggmoread.sdk.z.b.m.d.c(context, str);
    }

    public boolean a(File file, d dVar) {
        if (!a(this.f4562a)) {
            this.f4564c.a(-1L, -2010, "no install permission");
        }
        com.aggmoread.sdk.z.b.d.c("ApiDownloadHelper", "startInstaller apkFile = " + file.getName() + ", isExist = " + file.exists());
        Context context = this.f4562a;
        Intent intent = new Intent("android.intent.action.VIEW");
        com.aggmoread.sdk.z.b.d.c("ApiDownloadHelper", "pkg = " + context.getPackageName());
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                Uri a10 = com.aggmoread.sdk.z.b.j.d.a(context, context.getPackageName() + ".am.download.fp", file);
                com.aggmoread.sdk.z.b.d.c("ApiDownloadHelper", "localUri = " + a10);
                intent.setDataAndType(a10, "application/vnd.android.package-archive");
                intent.addFlags(1);
            } else {
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            }
            intent.addFlags(268435456);
            if (a(context, intent)) {
                try {
                    com.aggmoread.sdk.z.b.d.c("ApiDownloadHelper", "installer startActivity intent = " + intent);
                    context.startActivity(intent);
                    e();
                    this.f4564c.c((long) this.f4565d);
                    d();
                    return true;
                } catch (Exception e10) {
                    com.aggmoread.sdk.z.b.d.c("ApiDownloadHelper", "start installer error , message = " + e10.getMessage());
                    this.f4564c.a((long) this.f4565d, -2007, "start installer error");
                    e10.printStackTrace();
                }
            } else {
                this.f4564c.a(this.f4565d, -2008, "installer not found");
                com.aggmoread.sdk.z.b.d.c("ApiDownloadHelper", "installer not found");
            }
            return false;
        } catch (Exception e11) {
            e11.printStackTrace();
            com.aggmoread.sdk.z.b.d.c("ApiDownloadHelper", "startInstaller exception e  = " + e11.getMessage());
            this.f4564c.a((long) this.f4565d, -2006, "installer intent builder error");
            return false;
        }
    }

    public boolean a(String str, File file) {
        k kVar = this.f4571j;
        if (kVar != null && !kVar.b()) {
            try {
                this.f4571j.a(com.aggmoread.sdk.z.b.m.c.a(this.f4562a, file.getAbsolutePath()).b());
            } catch (PackageManager.NameNotFoundException e10) {
                e10.printStackTrace();
            }
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = a(file);
            }
            com.aggmoread.sdk.z.b.d.c("ApiDownloadHelper", "downComplete willListenPackageName= " + str);
            if (!a(this.f4562a, str)) {
                b(str);
                boolean a10 = a(file, d.f4582b);
                com.aggmoread.sdk.z.b.d.c("ApiDownloadHelper", "isStartInstallerSuccess = " + a10);
                return a10;
            }
            a(str);
            com.aggmoread.sdk.z.b.d.c("ApiDownloadHelper", "downComplete clickStartApp");
            return true;
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            com.aggmoread.sdk.z.b.d.c("ApiDownloadHelper", "onCompleted enter , package name not found");
            this.f4564c.a(this.f4565d, -2001, "file not found error");
            return false;
        }
    }
}
