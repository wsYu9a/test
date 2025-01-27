package com.ss.android.downloadlib.addownload.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.g.m;
import com.ss.android.downloadlib.i;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static final String f21142a = "a";

    /* renamed from: b */
    private static a f21143b;

    /* renamed from: c */
    @NonNull
    private CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.b.a> f21144c;

    /* renamed from: d */
    private boolean f21145d = false;

    /* renamed from: e */
    private String f21146e;

    /* renamed from: f */
    private b f21147f;

    /* renamed from: com.ss.android.downloadlib.addownload.a.a$1 */
    public class AnonymousClass1 implements b.InterfaceC0631b {

        /* renamed from: a */
        final /* synthetic */ com.ss.android.downloadad.api.a.b f21148a;

        /* renamed from: b */
        final /* synthetic */ Context f21149b;

        /* renamed from: c */
        final /* synthetic */ com.ss.android.downloadlib.addownload.b.a f21150c;

        /* renamed from: d */
        final /* synthetic */ InterfaceC0636a f21151d;

        public AnonymousClass1(com.ss.android.downloadad.api.a.b bVar, Context context, com.ss.android.downloadlib.addownload.b.a aVar, InterfaceC0636a interfaceC0636a) {
            d10 = bVar;
            context = context;
            aVar = aVar;
            interfaceC0636a = interfaceC0636a;
        }

        @Override // com.ss.android.download.api.model.b.InterfaceC0631b
        public void a(DialogInterface dialogInterface) {
            com.ss.android.downloadlib.d.a.a().b("backdialog_install", d10);
            com.ss.android.socialbase.appdownloader.d.a(context, (int) aVar.f21181a);
            dialogInterface.dismiss();
        }

        @Override // com.ss.android.download.api.model.b.InterfaceC0631b
        public void b(DialogInterface dialogInterface) {
            com.ss.android.downloadlib.d.a.a().b("backdialog_exit", d10);
            InterfaceC0636a interfaceC0636a = interfaceC0636a;
            if (interfaceC0636a != null) {
                interfaceC0636a.a();
            }
            a.this.b("");
            dialogInterface.dismiss();
        }

        @Override // com.ss.android.download.api.model.b.InterfaceC0631b
        public void c(DialogInterface dialogInterface) {
            a.this.b("");
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.a.a$a */
    public interface InterfaceC0636a {
        void a();
    }

    private a() {
        b bVar = new b();
        this.f21147f = bVar;
        this.f21144c = bVar.a("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static a a() {
        if (f21143b == null) {
            f21143b = new a();
        }
        return f21143b;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f21146e = "";
        } else if (TextUtils.equals(this.f21146e, str)) {
            this.f21146e = "";
        }
    }

    private boolean a(Activity activity, DownloadInfo downloadInfo, boolean z10, InterfaceC0636a interfaceC0636a) {
        if (downloadInfo == null) {
            try {
                if (this.f21144c.isEmpty()) {
                    return false;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        if (activity != null && !activity.isFinishing()) {
            boolean z11 = true;
            if (downloadInfo != null && this.f21144c.isEmpty()) {
                a(activity, new com.ss.android.downloadlib.addownload.b.a(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z10, interfaceC0636a);
                return true;
            }
            long lastModified = downloadInfo != null ? new File(downloadInfo.getTargetFilePath()).lastModified() : 0L;
            CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.b.a> copyOnWriteArrayList = this.f21144c;
            ListIterator<com.ss.android.downloadlib.addownload.b.a> listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    z11 = false;
                    break;
                }
                com.ss.android.downloadlib.addownload.b.a previous = listIterator.previous();
                if (previous != null && !m.e(k.a(), previous.f21184d) && m.a(previous.f21187g)) {
                    if (new File(previous.f21187g).lastModified() >= lastModified) {
                        a(activity, previous, z10, interfaceC0636a);
                    } else {
                        a(activity, new com.ss.android.downloadlib.addownload.b.a(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z10, interfaceC0636a);
                    }
                }
            }
            com.ss.android.downloadlib.g.k.a(f21142a, "tryShowInstallDialog isShow:" + z11, null);
            return z11;
        }
        return false;
    }

    @MainThread
    public boolean a(Activity activity, boolean z10, InterfaceC0636a interfaceC0636a) {
        if (k.j().optInt("disable_install_app_dialog") == 1 || this.f21145d) {
            return false;
        }
        return a(activity, a(activity), z10, interfaceC0636a);
    }

    public void a(Context context, com.ss.android.downloadlib.addownload.b.a aVar, boolean z10, InterfaceC0636a interfaceC0636a) {
        this.f21144c.clear();
        a(context, aVar, interfaceC0636a, z10);
        this.f21145d = true;
        i.a(context).c();
        this.f21147f.b("sp_ad_install_back_dialog", "key_uninstalled_list");
        com.ss.android.downloadlib.g.k.a(f21142a, "tryShowInstallDialog isShow:true", null);
    }

    public DownloadInfo a(Context context) {
        long b10;
        List<DownloadInfo> successedDownloadInfosWithMimeType;
        DownloadInfo downloadInfo = null;
        try {
            b10 = i.a(context).b();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (k.j().optInt("enable_miniapp_dialog", 0) != 0 && (successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive")) != null && !successedDownloadInfosWithMimeType.isEmpty()) {
            long j10 = 0;
            for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                if (downloadInfo2 != null && !m.e(context, downloadInfo2.getPackageName()) && m.a(downloadInfo2.getTargetFilePath())) {
                    long lastModified = new File(downloadInfo2.getTargetFilePath()).lastModified();
                    if (lastModified >= b10 && downloadInfo2.getExtra() != null) {
                        try {
                            if (new JSONObject(downloadInfo2.getExtra()).has("isMiniApp") && (j10 == 0 || lastModified > j10)) {
                                downloadInfo = downloadInfo2;
                                j10 = lastModified;
                            }
                        } catch (Exception e11) {
                            e11.printStackTrace();
                        }
                    }
                }
            }
            return downloadInfo;
        }
        return null;
    }

    public void a(long j10, long j11, long j12, String str, String str2, String str3, String str4) {
        for (int i10 = 0; i10 < this.f21144c.size(); i10++) {
            com.ss.android.downloadlib.addownload.b.a aVar = this.f21144c.get(i10);
            if (aVar != null && aVar.f21182b == j11) {
                this.f21144c.set(i10, new com.ss.android.downloadlib.addownload.b.a(j10, j11, j12, str, str2, str3, str4));
                this.f21147f.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.f21144c);
                return;
            }
        }
        this.f21144c.add(new com.ss.android.downloadlib.addownload.b.a(j10, j11, j12, str, str2, str3, str4));
        this.f21147f.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.f21144c);
    }

    private void a(Context context, com.ss.android.downloadlib.addownload.b.a aVar, InterfaceC0636a interfaceC0636a, boolean z10) {
        com.ss.android.downloadad.api.a.b d10 = f.a().d(aVar.f21182b);
        if (d10 == null) {
            com.ss.android.downloadlib.e.c.a().a("showBackInstallDialog nativeModel null");
            return;
        }
        k.d().b(new b.a(context).a(z10 ? "应用安装确认" : "退出确认").b(String.format("%1$s下载完成，是否立即安装？", TextUtils.isEmpty(aVar.f21185e) ? "刚刚下载的应用" : aVar.f21185e)).c("立即安装").d(z10 ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).a(false).a(m.a(context, aVar.f21187g)).a(new b.InterfaceC0631b() { // from class: com.ss.android.downloadlib.addownload.a.a.1

            /* renamed from: a */
            final /* synthetic */ com.ss.android.downloadad.api.a.b f21148a;

            /* renamed from: b */
            final /* synthetic */ Context f21149b;

            /* renamed from: c */
            final /* synthetic */ com.ss.android.downloadlib.addownload.b.a f21150c;

            /* renamed from: d */
            final /* synthetic */ InterfaceC0636a f21151d;

            public AnonymousClass1(com.ss.android.downloadad.api.a.b d102, Context context2, com.ss.android.downloadlib.addownload.b.a aVar2, InterfaceC0636a interfaceC0636a2) {
                d10 = d102;
                context = context2;
                aVar = aVar2;
                interfaceC0636a = interfaceC0636a2;
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC0631b
            public void a(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.a.a().b("backdialog_install", d10);
                com.ss.android.socialbase.appdownloader.d.a(context, (int) aVar.f21181a);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC0631b
            public void b(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.a.a().b("backdialog_exit", d10);
                InterfaceC0636a interfaceC0636a2 = interfaceC0636a;
                if (interfaceC0636a2 != null) {
                    interfaceC0636a2.a();
                }
                a.this.b("");
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC0631b
            public void c(DialogInterface dialogInterface) {
                a.this.b("");
            }
        }).a(1).a());
        com.ss.android.downloadlib.d.a.a().b("backdialog_show", d102);
        this.f21146e = aVar2.f21184d;
    }

    public boolean a(String str) {
        return TextUtils.equals(this.f21146e, str);
    }

    public void a(com.ss.android.downloadad.api.a.b bVar) {
        if (k.j().optInt("enable_open_app_dialog", 0) == 1 && !bVar.Z() && bVar.q() && Build.VERSION.SDK_INT < 34) {
            bVar.k(true);
            TTDelegateActivity.a(bVar);
        }
    }
}
