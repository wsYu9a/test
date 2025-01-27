package com.ss.android.downloadlib.addownload.j;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ss.android.download.api.model.zx;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.addownload.zx.gv;
import com.ss.android.downloadlib.lg.nt;
import com.ss.android.downloadlib.lg.t;
import com.ss.android.downloadlib.y;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class j {

    /* renamed from: j */
    private static final String f24180j = "j";
    private static j zx;

    /* renamed from: g */
    private boolean f24181g = false;
    private zx gv;

    /* renamed from: i */
    @NonNull
    private CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.zx.j> f24182i;
    private String q;

    /* renamed from: com.ss.android.downloadlib.addownload.j.j$1 */
    class AnonymousClass1 implements zx.InterfaceC0493zx {

        /* renamed from: g */
        final /* synthetic */ InterfaceC0494j f24183g;

        /* renamed from: i */
        final /* synthetic */ com.ss.android.downloadlib.addownload.zx.j f24184i;

        /* renamed from: j */
        final /* synthetic */ com.ss.android.downloadad.api.j.zx f24185j;
        final /* synthetic */ Context zx;

        AnonymousClass1(com.ss.android.downloadad.api.j.zx zxVar, Context context, com.ss.android.downloadlib.addownload.zx.j jVar, InterfaceC0494j interfaceC0494j) {
            g2 = zxVar;
            context = context;
            jVar = jVar;
            interfaceC0494j = interfaceC0494j;
        }

        @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
        public void i(DialogInterface dialogInterface) {
            j.this.zx("");
        }

        @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
        public void j(DialogInterface dialogInterface) {
            com.ss.android.downloadlib.g.j.j().zx("backdialog_install", g2);
            com.ss.android.socialbase.appdownloader.g.j(context, (int) jVar.f24232j);
            dialogInterface.dismiss();
        }

        @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
        public void zx(DialogInterface dialogInterface) {
            com.ss.android.downloadlib.g.j.j().zx("backdialog_exit", g2);
            InterfaceC0494j interfaceC0494j = interfaceC0494j;
            if (interfaceC0494j != null) {
                interfaceC0494j.j();
            }
            j.this.zx("");
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.j.j$j */
    public interface InterfaceC0494j {
        void j();
    }

    private j() {
        zx zxVar = new zx();
        this.gv = zxVar;
        this.f24182i = zxVar.j("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static j j() {
        if (zx == null) {
            zx = new j();
        }
        return zx;
    }

    public void zx(String str) {
        if (TextUtils.isEmpty(str)) {
            this.q = "";
        } else if (TextUtils.equals(this.q, str)) {
            this.q = "";
        }
    }

    private boolean j(Activity activity, DownloadInfo downloadInfo, boolean z, InterfaceC0494j interfaceC0494j) {
        if (downloadInfo == null) {
            try {
                if (this.f24182i.isEmpty()) {
                    return false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (activity != null && !activity.isFinishing()) {
            boolean z2 = true;
            if (downloadInfo != null && this.f24182i.isEmpty()) {
                j(activity, new com.ss.android.downloadlib.addownload.zx.j(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0494j);
                return true;
            }
            long lastModified = downloadInfo != null ? new File(downloadInfo.getTargetFilePath()).lastModified() : 0L;
            CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.zx.j> copyOnWriteArrayList = this.f24182i;
            ListIterator<com.ss.android.downloadlib.addownload.zx.j> listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    z2 = false;
                    break;
                }
                com.ss.android.downloadlib.addownload.zx.j previous = listIterator.previous();
                if (previous != null && !nt.g(pa.getContext(), previous.f24230g) && nt.j(previous.lg)) {
                    if (new File(previous.lg).lastModified() >= lastModified) {
                        j(activity, previous, z, interfaceC0494j);
                    } else {
                        j(activity, new com.ss.android.downloadlib.addownload.zx.j(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0494j);
                    }
                }
            }
            t.j(f24180j, "tryShowInstallDialog isShow:" + z2, null);
            return z2;
        }
        return false;
    }

    @MainThread
    public boolean j(Activity activity, boolean z, InterfaceC0494j interfaceC0494j) {
        if (pa.k().optInt("disable_install_app_dialog") == 1 || this.f24181g) {
            return false;
        }
        return j(activity, j(activity), z, interfaceC0494j);
    }

    public void j(Context context, com.ss.android.downloadlib.addownload.zx.j jVar, boolean z, InterfaceC0494j interfaceC0494j) {
        this.f24182i.clear();
        j(context, jVar, interfaceC0494j, z);
        this.f24181g = true;
        y.j(context).i();
        this.gv.zx("sp_ad_install_back_dialog", "key_uninstalled_list");
        t.j(f24180j, "tryShowInstallDialog isShow:true", null);
    }

    public DownloadInfo j(Context context) {
        long zx2;
        List<DownloadInfo> successedDownloadInfosWithMimeType;
        DownloadInfo downloadInfo = null;
        try {
            zx2 = y.j(context).zx();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (pa.k().optInt("enable_miniapp_dialog", 0) != 0 && (successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK)) != null && !successedDownloadInfosWithMimeType.isEmpty()) {
            long j2 = 0;
            for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                if (downloadInfo2 != null && !nt.g(context, downloadInfo2.getPackageName()) && nt.j(downloadInfo2.getTargetFilePath())) {
                    long lastModified = new File(downloadInfo2.getTargetFilePath()).lastModified();
                    if (lastModified >= zx2 && downloadInfo2.getExtra() != null) {
                        try {
                            if (new JSONObject(downloadInfo2.getExtra()).has("isMiniApp") && (j2 == 0 || lastModified > j2)) {
                                downloadInfo = downloadInfo2;
                                j2 = lastModified;
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
            return downloadInfo;
        }
        return null;
    }

    public void j(long j2, long j3, long j4, String str, String str2, String str3, String str4) {
        for (int i2 = 0; i2 < this.f24182i.size(); i2++) {
            com.ss.android.downloadlib.addownload.zx.j jVar = this.f24182i.get(i2);
            if (jVar != null && jVar.zx == j3) {
                this.f24182i.set(i2, new com.ss.android.downloadlib.addownload.zx.j(j2, j3, j4, str, str2, str3, str4));
                this.gv.j("sp_ad_install_back_dialog", "key_uninstalled_list", this.f24182i);
                return;
            }
        }
        this.f24182i.add(new com.ss.android.downloadlib.addownload.zx.j(j2, j3, j4, str, str2, str3, str4));
        this.gv.j("sp_ad_install_back_dialog", "key_uninstalled_list", this.f24182i);
    }

    private void j(Context context, com.ss.android.downloadlib.addownload.zx.j jVar, InterfaceC0494j interfaceC0494j, boolean z) {
        com.ss.android.downloadad.api.j.zx g2 = gv.j().g(jVar.zx);
        if (g2 == null) {
            com.ss.android.downloadlib.q.i.j().j("showBackInstallDialog nativeModel null");
            return;
        }
        com.ss.android.download.api.config.nt i2 = pa.i();
        zx.j j2 = new zx.j(context).j(z ? "应用安装确认" : "退出确认");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(jVar.q) ? "刚刚下载的应用" : jVar.q;
        i2.zx(j2.zx(String.format("%1$s下载完成，是否立即安装？", objArr)).i("立即安装").g(z ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).j(false).j(nt.j(context, jVar.lg)).j(new zx.InterfaceC0493zx() { // from class: com.ss.android.downloadlib.addownload.j.j.1

            /* renamed from: g */
            final /* synthetic */ InterfaceC0494j f24183g;

            /* renamed from: i */
            final /* synthetic */ com.ss.android.downloadlib.addownload.zx.j f24184i;

            /* renamed from: j */
            final /* synthetic */ com.ss.android.downloadad.api.j.zx f24185j;
            final /* synthetic */ Context zx;

            AnonymousClass1(com.ss.android.downloadad.api.j.zx g22, Context context2, com.ss.android.downloadlib.addownload.zx.j jVar2, InterfaceC0494j interfaceC0494j2) {
                g2 = g22;
                context = context2;
                jVar = jVar2;
                interfaceC0494j = interfaceC0494j2;
            }

            @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
            public void i(DialogInterface dialogInterface) {
                j.this.zx("");
            }

            @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
            public void j(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.g.j.j().zx("backdialog_install", g2);
                com.ss.android.socialbase.appdownloader.g.j(context, (int) jVar.f24232j);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
            public void zx(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.g.j.j().zx("backdialog_exit", g2);
                InterfaceC0494j interfaceC0494j2 = interfaceC0494j;
                if (interfaceC0494j2 != null) {
                    interfaceC0494j2.j();
                }
                j.this.zx("");
                dialogInterface.dismiss();
            }
        }).j(1).j());
        com.ss.android.downloadlib.g.j.j().zx("backdialog_show", g22);
        this.q = jVar2.f24230g;
    }

    public boolean j(String str) {
        return TextUtils.equals(this.q, str);
    }

    public void j(com.ss.android.downloadad.api.j.zx zxVar) {
        if (pa.k().optInt("enable_open_app_dialog", 0) == 1 && !zxVar.cm() && zxVar.ei()) {
            zxVar.t(true);
            TTDelegateActivity.j(zxVar);
        }
    }
}
