package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* loaded from: classes4.dex */
public class zx {

    /* renamed from: j */
    private static volatile zx f24214j;
    private Handler zx = null;

    /* renamed from: com.ss.android.downloadlib.addownload.zx$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ String f24215j;

        AnonymousClass1(String str) {
            url = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            pa.i().j(3, pa.getContext(), null, "下载失败，请重试！", null, 0);
            q j2 = com.ss.android.downloadlib.lg.j().j(url);
            if (j2 != null) {
                j2.lg();
            }
        }
    }

    public static zx j() {
        if (f24214j == null) {
            synchronized (zx.class) {
                if (f24214j == null) {
                    f24214j = new zx();
                }
            }
        }
        return f24214j;
    }

    public boolean zx() {
        return pa.k().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }

    public void j(Context context, DownloadInfo downloadInfo) {
        if (zx() && downloadInfo != null) {
            try {
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.zx == null) {
                this.zx = new Handler(Looper.getMainLooper());
            }
            String url = downloadInfo.getUrl();
            Downloader.getInstance(context).clearDownloadData(downloadInfo.getId());
            this.zx.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.zx.1

                /* renamed from: j */
                final /* synthetic */ String f24215j;

                AnonymousClass1(String url2) {
                    url = url2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    pa.i().j(3, pa.getContext(), null, "下载失败，请重试！", null, 0);
                    q j2 = com.ss.android.downloadlib.lg.j().j(url);
                    if (j2 != null) {
                        j2.lg();
                    }
                }
            });
        }
    }
}
