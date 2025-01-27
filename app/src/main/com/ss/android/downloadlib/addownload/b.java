package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static volatile b f21177a;

    /* renamed from: b */
    private Handler f21178b = null;

    /* renamed from: com.ss.android.downloadlib.addownload.b$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f21179a;

        public AnonymousClass1(String str) {
            url = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.d().a(3, k.a(), null, "下载失败，请重试！", null, 0);
            e a10 = com.ss.android.downloadlib.g.a().a(url);
            if (a10 != null) {
                a10.g();
            }
        }
    }

    public static b a() {
        if (f21177a == null) {
            synchronized (b.class) {
                try {
                    if (f21177a == null) {
                        f21177a = new b();
                    }
                } finally {
                }
            }
        }
        return f21177a;
    }

    public boolean b() {
        return k.j().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }

    public void a(Context context, DownloadInfo downloadInfo) {
        if (b() && downloadInfo != null) {
            try {
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (this.f21178b == null) {
                this.f21178b = new Handler(Looper.getMainLooper());
            }
            String url = downloadInfo.getUrl();
            Downloader.getInstance(context).clearDownloadData(downloadInfo.getId());
            this.f21178b.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.b.1

                /* renamed from: a */
                final /* synthetic */ String f21179a;

                public AnonymousClass1(String url2) {
                    url = url2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    k.d().a(3, k.a(), null, "下载失败，请重试！", null, 0);
                    e a10 = com.ss.android.downloadlib.g.a().a(url);
                    if (a10 != null) {
                        a10.g();
                    }
                }
            });
        }
    }
}
