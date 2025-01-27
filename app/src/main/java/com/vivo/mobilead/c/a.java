package com.vivo.mobilead.c;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.vivo.ad.model.q;
import com.vivo.ic.dm.DownloadManager;
import com.vivo.ic.dm.Downloads;
import com.vivo.mobilead.util.k0;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private String f28673a;

    /* renamed from: b */
    private String f28674b;

    /* renamed from: c */
    private String f28675c;

    /* renamed from: d */
    private String f28676d;

    /* renamed from: e */
    private long f28677e;

    /* renamed from: i */
    private com.vivo.ad.model.b f28681i;

    /* renamed from: j */
    private n f28682j;

    /* renamed from: f */
    private final CopyOnWriteArrayList<com.vivo.mobilead.unified.base.view.a> f28678f = new CopyOnWriteArrayList<>();

    /* renamed from: g */
    private final AtomicInteger f28679g = new AtomicInteger(0);

    /* renamed from: h */
    private int f28680h = Downloads.Impl.STATUS_PENDING;
    private final AtomicInteger k = new AtomicInteger(0);
    private final AtomicBoolean l = new AtomicBoolean(false);
    private final AtomicBoolean m = new AtomicBoolean(false);
    private final AtomicBoolean n = new AtomicBoolean(false);
    private final AtomicBoolean o = new AtomicBoolean(false);
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private com.vivo.mobilead.util.f1.b s = new c();

    /* renamed from: com.vivo.mobilead.c.a$a */
    class C0573a extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ int f28683a;

        C0573a(int i2) {
            this.f28683a = i2;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            if (this.f28683a == 192) {
                Iterator it = a.this.f28678f.iterator();
                while (it.hasNext()) {
                    ((com.vivo.mobilead.unified.base.view.a) it.next()).setInstallText("下载中");
                }
            } else if (Downloads.Impl.isStatusPause(a.this.f28680h)) {
                Iterator it2 = a.this.f28678f.iterator();
                while (it2.hasNext()) {
                    ((com.vivo.mobilead.unified.base.view.a) it2.next()).setInstallText("继续");
                }
            }
        }
    }

    class b extends com.vivo.mobilead.util.f1.b {
        b() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            Iterator it = a.this.f28678f.iterator();
            while (it.hasNext()) {
                ((com.vivo.mobilead.unified.base.view.a) it.next()).setInstallText("重试中");
            }
            com.vivo.mobilead.c.c.b().a();
        }
    }

    class c extends com.vivo.mobilead.util.f1.b {

        /* renamed from: com.vivo.mobilead.c.a$c$a */
        class C0574a extends com.vivo.mobilead.util.f1.b {
            C0574a() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                Iterator it = a.this.f28678f.iterator();
                while (it.hasNext()) {
                    ((com.vivo.mobilead.unified.base.view.a) it.next()).setInstallText("立即下载");
                }
                a aVar = a.this;
                aVar.a(aVar.f28675c);
            }
        }

        c() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            if (a.this.f28679g.incrementAndGet() <= 4) {
                a.this.h();
                return;
            }
            com.vivo.mobilead.util.f1.c.d(new C0574a());
            a.this.f28680h = Downloads.Impl.STATUS_PENDING;
            a.this.a();
            k0.a(a.this.f28681i, 0, a.this.f28680h, "");
        }
    }

    class d extends com.vivo.mobilead.util.f1.b {
        d() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            Iterator it = a.this.f28678f.iterator();
            while (it.hasNext()) {
                ((com.vivo.mobilead.unified.base.view.a) it.next()).setInstallText("安装中");
            }
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = a.this.f28678f.iterator();
            while (it.hasNext()) {
                ((com.vivo.mobilead.unified.base.view.a) it.next()).setInstallText("重试中");
            }
        }
    }

    class f implements Runnable {

        /* renamed from: com.vivo.mobilead.c.a$f$a */
        class RunnableC0575a implements Runnable {
            RunnableC0575a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                aVar.b(aVar.f28675c);
            }
        }

        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.vivo.mobilead.c.d.b();
                k0.c(a.this.f28681i);
                a aVar = a.this;
                aVar.f28677e = com.vivo.mobilead.c.d.a(aVar.f28673a, a.this.f28676d);
                if (a.this.f28677e != -1) {
                    a.this.j();
                    a.this.c(Downloads.Impl.STATUS_RUNNING);
                } else {
                    a.this.o();
                    com.vivo.mobilead.util.f1.c.d(new RunnableC0575a());
                }
            } catch (Exception unused) {
            }
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.o();
        }
    }

    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                DownloadManager.getInstance().pause(a.this.f28677e);
            } catch (Exception unused) {
            }
        }
    }

    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                DownloadManager.getInstance().resume(a.this.f28677e);
            } catch (Exception unused) {
            }
        }
    }

    class j extends com.vivo.mobilead.util.f1.b {
        j() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            DownloadManager.getInstance().cancel(a.this.f28677e);
        }
    }

    class k extends com.vivo.mobilead.util.f1.b {
        k(a aVar) {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            com.vivo.mobilead.c.c.b().a();
        }
    }

    class l implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f28696a;

        /* renamed from: b */
        final /* synthetic */ long f28697b;

        l(long j2, long j3) {
            this.f28696a = j2;
            this.f28697b = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = a.this.f28678f.iterator();
            while (it.hasNext()) {
                com.vivo.mobilead.unified.base.view.a aVar = (com.vivo.mobilead.unified.base.view.a) it.next();
                if (!"下载中".equals(aVar.getText().toString())) {
                    aVar.setInstallText("下载中");
                }
            }
            if (this.f28696a == 0) {
                return;
            }
            com.vivo.mobilead.c.c.b().a((this.f28697b * 100) / this.f28696a, a.this.f28674b);
        }
    }

    class m extends com.vivo.mobilead.util.f1.b {
        m() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            Iterator it = a.this.f28678f.iterator();
            while (it.hasNext()) {
                ((com.vivo.mobilead.unified.base.view.a) it.next()).setInstallText("继续");
            }
        }
    }

    public class n extends BroadcastReceiver {

        /* renamed from: com.vivo.mobilead.c.a$n$a */
        class C0576a extends com.vivo.mobilead.util.f1.b {
            C0576a() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                Iterator it = a.this.f28678f.iterator();
                while (it.hasNext()) {
                    ((com.vivo.mobilead.unified.base.view.a) it.next()).setInstallText("立即打开");
                }
            }
        }

        class b extends com.vivo.mobilead.util.f1.b {
            b() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                com.vivo.mobilead.c.d.a(a.this.f28676d);
            }
        }

        public n() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction() == null || !intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
                return;
            }
            a.this.f28680h = Downloads.Impl.STATUS_PENDING;
            a.this.n();
            com.vivo.mobilead.util.f1.c.d(new C0576a());
            com.vivo.mobilead.util.f1.c.a(new b());
            k0.b(a.this.f28681i);
        }
    }

    public a(com.vivo.ad.model.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f28681i = bVar;
        q y = bVar.y();
        if (y != null) {
            this.f28673a = y.k();
            this.f28674b = y.b();
            this.f28675c = y.d();
            this.f28676d = y.a();
        }
    }

    public void o() {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("uri", this.f28673a);
            contentValues.put("title", "下载中...");
            contentValues.put(Downloads.Column.FILE_NAME_HINT, com.vivo.mobilead.c.d.c(this.f28676d));
            contentValues.put(Downloads.Column.VISIBILITY, (Integer) 3);
            contentValues.put(Downloads.Column.APP_EXTRA_ONE, this.f28676d);
            this.f28677e = DownloadManager.getInstance().start(contentValues);
        } catch (Exception unused) {
        }
    }

    public void k() {
        com.vivo.mobilead.util.f1.c.a(new f());
    }

    public void l() {
        this.q = true;
        if (Downloads.Impl.isStatusPause(this.f28680h)) {
            this.r = true;
            return;
        }
        if (Downloads.Impl.isDownloading(this.f28680h)) {
            this.f28680h = Downloads.Impl.STATUS_PAUSED_BY_APP;
            g();
        } else if (this.p || Downloads.Impl.isStatusError(this.f28680h)) {
            com.vivo.mobilead.util.f1.c.a();
        }
    }

    public void m() {
        this.q = false;
        if (this.r) {
            return;
        }
        if (this.p || Downloads.Impl.isStatusError(this.f28680h)) {
            com.vivo.mobilead.util.f1.c.a(this.s, 15000L);
        } else if (Downloads.Impl.isStatusPause(this.f28680h)) {
            j();
        }
    }

    public void n() {
        if (this.k.get() == 0) {
            return;
        }
        this.k.decrementAndGet();
        this.f28680h = Downloads.Impl.STATUS_PENDING;
        try {
            if (com.vivo.mobilead.manager.f.j().c() != null && com.vivo.mobilead.manager.f.j().c().getApplicationContext() != null && this.f28682j != null) {
                com.vivo.mobilead.manager.f.j().c().getApplicationContext().getApplicationContext().unregisterReceiver(this.f28682j);
                this.f28682j = null;
            }
        } catch (Exception unused) {
        }
        Iterator<com.vivo.mobilead.unified.base.view.a> it = this.f28678f.iterator();
        while (it.hasNext()) {
            it.next().setText(this.f28681i);
        }
    }

    public void b() {
        if (Downloads.Impl.isStatusSuccess(this.f28680h)) {
            if (this.l.get()) {
                return;
            }
            this.l.set(true);
            d();
            this.l.set(false);
            return;
        }
        if (Downloads.Impl.isStatusPause(this.f28680h)) {
            if (this.m.get()) {
                return;
            }
            this.m.set(true);
            j();
            return;
        }
        if (Downloads.Impl.isDownloading(this.f28680h)) {
            if (this.n.get()) {
                return;
            }
            this.n.set(true);
            g();
            return;
        }
        if (Downloads.Impl.isStatusError(this.f28680h)) {
            com.vivo.mobilead.util.f1.c.d(new e());
        } else {
            if (this.o.get()) {
                return;
            }
            this.o.set(true);
            k();
        }
    }

    public boolean c() {
        int i2 = this.f28680h;
        return i2 == 190 || Downloads.Impl.isStatusPause(i2) || Downloads.Impl.isStatusSuccess(this.f28680h);
    }

    public void d(int i2) {
        q y;
        com.vivo.ad.model.b bVar = this.f28681i;
        if (bVar != null && (y = bVar.y()) != null && !com.vivo.mobilead.c.d.a(com.vivo.mobilead.manager.f.j().c(), this.f28676d, y.q())) {
            a(Downloads.Impl.STATUS_HTTP_DATA_ERROR);
            return;
        }
        this.f28680h = i2;
        d();
        a();
        k0.a(this.f28681i, 1, -1, "");
    }

    public boolean e() {
        return (Downloads.Impl.isStatusSuccess(this.f28680h) || this.f28680h == 190) ? false : true;
    }

    public boolean f() {
        return this.f28680h == 190;
    }

    public void g() {
        if (Downloads.Impl.isStatusSuccess(this.f28680h)) {
            return;
        }
        this.r = false;
        com.vivo.mobilead.util.f1.c.a(new h());
    }

    public void h() {
        com.vivo.mobilead.util.f1.c.a(new g());
    }

    public void i() {
        if (this.k.get() == 1) {
            return;
        }
        this.k.incrementAndGet();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        this.f28682j = new n();
        try {
            if (com.vivo.mobilead.manager.f.j().c() == null || com.vivo.mobilead.manager.f.j().c().getApplicationContext() == null) {
                return;
            }
            com.vivo.mobilead.manager.f.j().c().getApplicationContext().registerReceiver(this.f28682j, intentFilter);
        } catch (Exception unused) {
        }
    }

    public void j() {
        if (Downloads.Impl.isStatusSuccess(this.f28680h)) {
            return;
        }
        this.r = false;
        com.vivo.mobilead.util.f1.c.a(new i());
    }

    public void a(com.vivo.mobilead.unified.base.view.a aVar) {
        if (aVar == null || this.f28678f.contains(aVar)) {
            return;
        }
        this.f28678f.add(aVar);
    }

    public void c(int i2) {
        this.o.set(false);
        this.m.set(false);
        this.n.set(false);
        this.f28680h = i2;
        com.vivo.mobilead.util.f1.c.d(new C0573a(i2));
    }

    public void a() {
        this.f28679g.set(0);
        this.p = false;
        this.r = false;
        com.vivo.mobilead.util.f1.c.a(new j());
        com.vivo.mobilead.util.f1.c.d(new k(this));
    }

    public void d() {
        try {
            String a2 = com.vivo.mobilead.c.d.a(com.vivo.mobilead.manager.f.j().c(), this.f28676d);
            com.vivo.mobilead.util.f1.c.d(new d());
            k0.d(this.f28681i);
            if (Build.VERSION.SDK_INT >= 24) {
                a(com.vivo.mobilead.manager.f.j().c(), a2);
            } else {
                b(com.vivo.mobilead.manager.f.j().c(), a2);
            }
            i();
        } catch (Exception unused) {
        }
    }

    public void a(long j2, long j3) {
        if (this.q) {
            g();
        } else {
            com.vivo.mobilead.util.f1.c.d(new l(j3, j2));
        }
    }

    public void a(int i2) {
        this.f28680h = i2;
        com.vivo.mobilead.util.f1.c.d(new b());
        DownloadManager.getInstance().cancel(this.f28677e);
        com.vivo.mobilead.c.d.a(this.f28676d);
        if (this.q) {
            return;
        }
        com.vivo.mobilead.util.f1.c.a(this.s, 15000L);
        this.p = true;
    }

    public void b(com.vivo.mobilead.unified.base.view.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f28678f.remove(aVar);
    }

    public void a(Context context, String str) {
        Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".VFileProvider", new File(str));
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.addFlags(1);
        intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
        context.startActivity(intent);
    }

    public void b(int i2) {
        this.f28680h = i2;
        com.vivo.mobilead.util.f1.c.d(new m());
    }

    private void b(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse("file://" + str), AdBaseConstants.MIME_APK);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        context.startActivity(intent);
    }

    public void a(String str) {
        Context c2 = com.vivo.mobilead.manager.f.j().c();
        if (TextUtils.isEmpty(str) || c2 == null) {
            return;
        }
        Toast.makeText(c2, str + "下载失败", 0).show();
    }

    public void b(String str) {
        Context c2 = com.vivo.mobilead.manager.f.j().c();
        if (TextUtils.isEmpty(str) || c2 == null) {
            return;
        }
        Toast.makeText(c2, "开始下载" + str, 0).show();
    }
}
