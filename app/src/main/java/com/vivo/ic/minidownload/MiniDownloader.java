package com.vivo.ic.minidownload;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.vivo.ic.minidownload.MiniDownloadRunable;
import java.io.File;

/* loaded from: classes4.dex */
public class MiniDownloader {
    static final String DOWNLOAD_FAIL = "DOWNLOAD_FAIL:";
    static final String DOWNLOAD_SUCCESS = "DOWNLOAD_SUCCESS";
    static final String FILE_NAME = Environment.getExternalStorageDirectory() + "/Download/test.apk";
    static final String URL = "http://appstore.vivo.com.cn/appinfo/downloadApkFile?id=69112&stype=3&v_d_s_f=yes&app_version=1021&imei=865407010000009&model=vivo+X7Plus&elapsedtime=285813496&cs=0&av=23&an=6.0.1&u=150100434a4e42345207c969b41a4300&nt=WIFI&sourword=%E7%B3%97%E4%BA%8B%E7%99%BE%E7%A7%91&listpos=99&page_index=5&target=local&cfrom=35&related=-1&update=-1&module_id=2&v_d_f_f=final&tryTime=1&s=2%7C3134493712";
    final Context mContext;
    MiniDownloadRunable.DownloadCallback mDownloadCallback = new MiniDownloadRunable.DownloadCallback() { // from class: com.vivo.ic.minidownload.MiniDownloader.1

        /* renamed from: com.vivo.ic.minidownload.MiniDownloader$1$1 */
        class RunnableC05711 implements Runnable {
            RunnableC05711() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(MiniDownloader.this.mContext, MiniDownloader.DOWNLOAD_SUCCESS, 0).show();
            }
        }

        /* renamed from: com.vivo.ic.minidownload.MiniDownloader$1$2 */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ String val$reason;

            AnonymousClass2(String str) {
                str = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(MiniDownloader.this.mContext, MiniDownloader.DOWNLOAD_FAIL + str, 0).show();
            }
        }

        AnonymousClass1() {
        }

        @Override // com.vivo.ic.minidownload.MiniDownloadRunable.DownloadCallback
        public void onDownloadError(int i2, String str, Exception exc) {
            MiniDownloader.this.mUiHandler.post(new Runnable() { // from class: com.vivo.ic.minidownload.MiniDownloader.1.2
                final /* synthetic */ String val$reason;

                AnonymousClass2(String str2) {
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(MiniDownloader.this.mContext, MiniDownloader.DOWNLOAD_FAIL + str, 0).show();
                }
            });
        }

        @Override // com.vivo.ic.minidownload.MiniDownloadRunable.DownloadCallback
        public void onDownloadSuccess(File file) {
            MiniDownloader.this.mUiHandler.post(new Runnable() { // from class: com.vivo.ic.minidownload.MiniDownloader.1.1
                RunnableC05711() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(MiniDownloader.this.mContext, MiniDownloader.DOWNLOAD_SUCCESS, 0).show();
                }
            });
        }
    };
    final Handler mUiHandler;

    /* renamed from: com.vivo.ic.minidownload.MiniDownloader$1 */
    class AnonymousClass1 implements MiniDownloadRunable.DownloadCallback {

        /* renamed from: com.vivo.ic.minidownload.MiniDownloader$1$1 */
        class RunnableC05711 implements Runnable {
            RunnableC05711() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(MiniDownloader.this.mContext, MiniDownloader.DOWNLOAD_SUCCESS, 0).show();
            }
        }

        /* renamed from: com.vivo.ic.minidownload.MiniDownloader$1$2 */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ String val$reason;

            AnonymousClass2(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(MiniDownloader.this.mContext, MiniDownloader.DOWNLOAD_FAIL + str, 0).show();
            }
        }

        AnonymousClass1() {
        }

        @Override // com.vivo.ic.minidownload.MiniDownloadRunable.DownloadCallback
        public void onDownloadError(int i2, String str2, Exception exc) {
            MiniDownloader.this.mUiHandler.post(new Runnable() { // from class: com.vivo.ic.minidownload.MiniDownloader.1.2
                final /* synthetic */ String val$reason;

                AnonymousClass2(String str22) {
                    str = str22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(MiniDownloader.this.mContext, MiniDownloader.DOWNLOAD_FAIL + str, 0).show();
                }
            });
        }

        @Override // com.vivo.ic.minidownload.MiniDownloadRunable.DownloadCallback
        public void onDownloadSuccess(File file) {
            MiniDownloader.this.mUiHandler.post(new Runnable() { // from class: com.vivo.ic.minidownload.MiniDownloader.1.1
                RunnableC05711() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(MiniDownloader.this.mContext, MiniDownloader.DOWNLOAD_SUCCESS, 0).show();
                }
            });
        }
    }

    public MiniDownloader(Context context) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new RuntimeException("DownloadUtil must be created in main thread!");
        }
        this.mContext = context.getApplicationContext();
        this.mUiHandler = new Handler();
    }

    public void deleteFile() {
        new File(FILE_NAME).delete();
    }

    public void startDownload(boolean z) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new MiniDownloadRunable(this.mContext, URL, FILE_NAME, this.mDownloadCallback, z));
    }
}
