package com.martian.ttbook.b.a.i;

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
import com.martian.ttbook.b.a.i.a;
import com.martian.ttbook.b.a.i.n;
import com.martian.ttbook.sdk.adcomponents.adsdk.JhSdkDownloadNotifyClickReceiver;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class b extends b.d.e.c.a.b {

    /* renamed from: a */
    static final AtomicInteger f14964a = new AtomicInteger(10000);

    /* renamed from: b */
    private Context f14965b;

    /* renamed from: c */
    private String f14966c;

    /* renamed from: d */
    private com.martian.ttbook.b.a.i.c f14967d;

    /* renamed from: e */
    private int f14968e;

    /* renamed from: f */
    private e f14969f;

    /* renamed from: g */
    private a.AbstractC0281a f14970g;

    /* renamed from: h */
    private n f14971h;

    /* renamed from: i */
    private String f14972i;

    /* renamed from: j */
    private String f14973j;
    private k k;
    private com.martian.ttbook.b.a.k.h l;
    private String m;
    final Runnable n;

    class a extends i {

        /* renamed from: b */
        final /* synthetic */ String f14974b;

        /* renamed from: c */
        final /* synthetic */ String f14975c;

        /* renamed from: d */
        final /* synthetic */ String f14976d;

        /* renamed from: com.martian.ttbook.b.a.i.b$a$a */
        class C0282a extends l {

            /* renamed from: b */
            final /* synthetic */ File f14978b;

            C0282a(File file) {
                this.f14978b = file;
            }

            @Override // com.martian.ttbook.b.a.i.l
            public void a(Intent intent, String str, String str2, String str3) {
                b.d.e.c.a.d.k("ApiDownloadHelper", "onCompleted enter , onNotificationClicked = " + str2 + ", downloadId = " + b.this.f14968e);
                b.this.l(this.f14978b, d.f14982c);
                b.this.f14967d.c((long) b.this.f14968e, -2002, "click notification install apk");
            }
        }

        a(String str, String str2, String str3) {
            this.f14974b = str;
            this.f14975c = str2;
            this.f14976d = str3;
        }

        @Override // com.martian.ttbook.b.a.i.i
        public void a() {
            b.d.e.c.a.d.k("ApiDownloadHelper", "onConnectSuccess enter");
            f.b().c(this.f14974b, 1);
        }

        @Override // com.martian.ttbook.b.a.i.i
        public void c(int i2, String str) {
            f.b().c(this.f14974b, 0);
            b.d.e.c.a.d.k("ApiDownloadHelper", "onError enter , code = " + i2 + " , message = " + str);
            b.this.f14967d.f((long) b.this.f14968e, i2, str);
        }

        @Override // com.martian.ttbook.b.a.i.i
        public void d(File file) {
            if (file == null || !file.exists()) {
                f.b().c(this.f14974b, 0);
                b.d.e.c.a.d.k("ApiDownloadHelper", "onCompleted enter , downloadFile not found");
                b.this.f14967d.c(b.this.f14968e, -2001, "download file not found error");
                return;
            }
            f.b().c(this.f14974b, 3);
            b.this.f14972i = file.getAbsolutePath();
            b.d.e.c.a.d.k("ApiDownloadHelper", "onCompleted enter , downloadFile = " + file.getAbsolutePath() + " , downloadId = " + b.this.f14968e);
            b.this.f14967d.e((long) b.this.f14968e);
            com.martian.ttbook.b.a.i.e.c(this.f14975c, new C0282a(file));
            b.this.m(this.f14976d, file);
        }

        @Override // com.martian.ttbook.b.a.i.i
        public void f() {
            f.b().c(this.f14974b, 2);
            b.d.e.c.a.d.k("ApiDownloadHelper", "onStartReadBytes enter");
            b.this.f14967d.d();
        }
    }

    /* renamed from: com.martian.ttbook.b.a.i.b$b */
    class C0283b extends a.AbstractC0281a {
        C0283b(b bVar) {
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            if (bVar.j(bVar.f14965b, b.this.f14966c) || b.this.f14967d == null) {
                return;
            }
            b.this.f14967d.c(b.this.f14968e, -2005, "user cancel install");
        }
    }

    public static final class d extends Enum<d> {

        /* renamed from: b */
        public static final d f14981b = new d("DOWNLOAD_COMPLETED", 0);

        /* renamed from: c */
        public static final d f14982c = new d("NOTIFICATION_CLICK", 1);

        /* renamed from: d */
        public static final d f14983d = new d("INSTALLER_BRIDGE", 2);

        private d(String str, int i2) {
            super(str, i2);
        }
    }

    private class e extends BroadcastReceiver {

        /* renamed from: a */
        private String f14984a;

        /* renamed from: b */
        private com.martian.ttbook.b.a.i.c f14985b;

        class a extends l {
            a() {
            }

            @Override // com.martian.ttbook.b.a.i.l
            public void a(Intent intent, String str, String str2, String str3) {
                e.this.f14985b.c(b.this.f14968e, -2003, "click notification open apk");
                b.this.f(str3);
                com.martian.ttbook.b.a.i.e.b(str);
            }
        }

        public e(String str, com.martian.ttbook.b.a.i.c cVar) {
            this.f14984a = str;
            this.f14985b = cVar;
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
                    b.d.e.c.a.d.k("ApiDownloadHelper", "installedPackageName " + dataString + " ， packageName " + this.f14984a + " , downloadListener = " + this.f14985b);
                    if (TextUtils.isEmpty(this.f14984a) || (dataString != null && dataString.contains(this.f14984a))) {
                        this.f14985b.b(b.this.f14968e);
                        com.martian.ttbook.b.a.k.e.d(b.this.n);
                        b.this.f14965b.unregisterReceiver(this);
                        if (b.this.k != null) {
                            b.this.k.j();
                            com.martian.ttbook.b.a.i.e.b(b.this.f14973j);
                            com.martian.ttbook.b.a.i.e.c(b.this.f14973j, new a());
                        }
                        if (b.this.l == null || TextUtils.isEmpty(this.f14984a)) {
                            return;
                        }
                        b.this.l.d(this.f14984a);
                    }
                }
            }
        }
    }

    public b(Context context, String str, com.martian.ttbook.b.a.i.c cVar) {
        com.martian.ttbook.b.a.i.c cVar2 = com.martian.ttbook.b.a.i.c.f14988a;
        this.f14967d = cVar2;
        this.f14968e = 0;
        this.n = new c();
        this.f14965b = context;
        this.m = str;
        this.f14967d = cVar == null ? cVar2 : cVar;
    }

    private String e(File file) {
        return com.martian.ttbook.b.a.k.c.a(this.f14965b, file.getAbsolutePath()).f();
    }

    private boolean h(Context context) {
        b.d.e.c.a.d.k("ApiDownloadHelper", "checkInstallPermission");
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        boolean canRequestPackageInstalls = context.getPackageManager().canRequestPackageInstalls();
        b.d.e.c.a.d.k("ApiDownloadHelper", "checkInstallPermission hasInstallPermission = " + canRequestPackageInstalls);
        return canRequestPackageInstalls;
    }

    private boolean i(Context context, Intent intent) {
        return context.getPackageManager().resolveActivity(intent, 0) != null;
    }

    public boolean j(Context context, String str) {
        return com.martian.ttbook.b.a.k.d.d(context, str);
    }

    public static File o(Context context) {
        File externalCacheDir = context.getApplicationContext().getExternalCacheDir();
        return externalCacheDir != null ? externalCacheDir : context.getApplicationContext().getCacheDir();
    }

    private boolean q(String str) {
        v();
        if (this.f14969f == null) {
            this.f14969f = new e(str, this.f14967d);
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addDataScheme("package");
            this.f14965b.registerReceiver(this.f14969f, intentFilter);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f14967d.c(this.f14968e, -2009, "start listen package error");
            return false;
        }
    }

    public static File s(Context context) {
        return new File(o(context), "jhs_download");
    }

    public void f(String str) {
        try {
            Intent launchIntentForPackage = this.f14965b.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                this.f14965b.startActivity(launchIntentForPackage);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void g(String str, String str2, String str3) {
        b.d.e.c.a.d.k("ApiDownloadHelper", "areNotificationsEnabled = " + NotificationManagerCompat.from(this.f14965b).areNotificationsEnabled());
        this.f14968e = f14964a.incrementAndGet();
        this.f14966c = str2;
        b.d.e.c.a.d.k("ApiDownloadHelper", "downloadApk enter , packageName = " + str2 + ",ulr = " + str);
        File s = s(this.f14965b);
        String a2 = g.a(str);
        String str4 = a2 + ".apk";
        File file = new File(s, str4);
        int a3 = f.b().a(a2);
        if (a3 == 1 || a3 == 2) {
            this.f14967d.a();
            return;
        }
        if (a3 == 3 && m(str2, file)) {
            this.f14967d.d();
            this.f14967d.e(this.f14968e);
            return;
        }
        if (file.exists()) {
            try {
                com.martian.ttbook.b.a.k.c.a(this.f14965b, file.getAbsolutePath()).f();
                if (m(str2, file)) {
                    this.f14967d.d();
                    this.f14967d.e(this.f14968e);
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.f14973j = str;
        Intent intent = new Intent(this.f14965b, (Class<?>) com.martian.ttbook.b.a.i.e.a());
        intent.putExtra("apkUrl", str);
        intent.putExtra("apkPath", file.getAbsolutePath());
        intent.putExtra(DBDefinition.PACKAGE_NAME, str2);
        intent.setAction(JhSdkDownloadNotifyClickReceiver.ACTION_NOTIFICATION_CLICK);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f14965b, this.f14968e, intent, 67108864);
        int i2 = com.martian.ttbook.b.a.g.a.f().g().f4618d;
        if (i2 == 0) {
            i2 = this.f14965b.getApplicationContext().getApplicationInfo().icon;
        }
        this.k = new k(this.f14965b, this.f14968e, broadcast, a2, TextUtils.isEmpty(str3) ? "" : str3, "正在下载...", i2);
        n f2 = new n.a(this.f14965b).i(str).d(s.getAbsolutePath()).h(str4).e(false).g(3).a(3).c(this.k).b(new a(a2, str, str2)).f();
        this.f14971h = f2;
        f2.y();
        Toast.makeText(this.f14965b, "开始下载", 0).show();
    }

    boolean l(File file, d dVar) {
        if (!h(this.f14965b)) {
            this.f14967d.c(-1L, -2010, "no install permission");
        }
        b.d.e.c.a.d.k("ApiDownloadHelper", "startInstaller apkFile = " + file.getName() + ", isExist = " + file.exists());
        Context context = this.f14965b;
        Intent intent = new Intent("android.intent.action.VIEW");
        b.d.e.c.a.d.k("ApiDownloadHelper", "pkg = " + context.getPackageName());
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                Uri a2 = com.martian.ttbook.b.a.i.d.a(context, context.getPackageName() + ".wy.fileprovider", file);
                b.d.e.c.a.d.k("ApiDownloadHelper", "localUri = " + a2);
                intent.setDataAndType(a2, AdBaseConstants.MIME_APK);
                intent.addFlags(1);
            } else {
                intent.setDataAndType(Uri.fromFile(file), AdBaseConstants.MIME_APK);
            }
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            if (i(context, intent)) {
                try {
                    b.d.e.c.a.d.k("ApiDownloadHelper", "installer startActivity intent = " + intent);
                    context.startActivity(intent);
                    t();
                    this.f14967d.g((long) this.f14968e);
                    p();
                    return true;
                } catch (Exception e2) {
                    b.d.e.c.a.d.k("ApiDownloadHelper", "start installer error , message = " + e2.getMessage());
                    this.f14967d.c((long) this.f14968e, -2007, "start installer error");
                    e2.printStackTrace();
                }
            } else {
                this.f14967d.c(this.f14968e, -2008, "installer not found");
                b.d.e.c.a.d.k("ApiDownloadHelper", "installer not found");
            }
            return false;
        } catch (Exception e3) {
            e3.printStackTrace();
            b.d.e.c.a.d.k("ApiDownloadHelper", "startInstaller exception e  = " + e3.getMessage());
            this.f14967d.c((long) this.f14968e, -2006, "installer intent builder error");
            return false;
        }
    }

    public boolean m(String str, File file) {
        k kVar = this.k;
        if (kVar != null && !kVar.e()) {
            try {
                this.k.b(com.martian.ttbook.b.a.k.c.a(this.f14965b, file.getAbsolutePath()).c());
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = e(file);
            }
            b.d.e.c.a.d.k("ApiDownloadHelper", "downComplete willListenPackageName= " + str);
            if (j(this.f14965b, str)) {
                f(str);
                b.d.e.c.a.d.k("ApiDownloadHelper", "downComplete clickStartApp");
                return true;
            }
            q(str);
            boolean l = l(file, d.f14981b);
            b.d.e.c.a.d.k("ApiDownloadHelper", "isStartInstallerSuccess = " + l);
            return l;
        } catch (PackageManager.NameNotFoundException e3) {
            e3.printStackTrace();
            b.d.e.c.a.d.k("ApiDownloadHelper", "onCompleted enter , package name not found");
            this.f14967d.c(this.f14968e, -2001, "file not found error");
            return false;
        }
    }

    public void p() {
        if (this.l == null) {
            this.l = com.martian.ttbook.b.a.k.h.a(this.f14965b, "appInstallInfo");
        }
        if (TextUtils.isEmpty(this.f14966c) || this.l.f(this.f14966c)) {
            return;
        }
        this.l.e(this.f14966c, this.f14966c + "#" + System.currentTimeMillis() + "#" + this.m);
    }

    public void t() {
        C0283b c0283b = new C0283b(this);
        this.f14970g = c0283b;
        com.martian.ttbook.b.a.i.a.a(0, c0283b);
    }

    void v() {
        e eVar = this.f14969f;
        if (eVar != null) {
            try {
                this.f14965b.unregisterReceiver(eVar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
