package com.alimm.tanx.core.net.okhttp.tanxc_do;

import android.os.Handler;
import android.text.TextUtils;
import com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.utils.FileUtil;
import com.alimm.tanx.core.utils.LogUtils;
import java.io.File;
import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes.dex */
public class tanxc_do {
    private boolean tanxc_byte;
    private final OkHttpClient tanxc_case = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_do(false);
    private final Handler tanxc_char = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_for();
    private long tanxc_do;
    private Request.Builder tanxc_else;
    private String tanxc_for;
    private String tanxc_if;
    private String tanxc_int;
    private String tanxc_new;
    private boolean tanxc_try;

    /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do$1 */
    public class AnonymousClass1 implements Callback {
        final /* synthetic */ OnDownloadListener tanxc_do;

        /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do$1$1 */
        public class RunnableC02121 implements Runnable {
            final /* synthetic */ IOException tanxc_do;

            public RunnableC02121(IOException iOException) {
                iOException = iOException;
            }

            @Override // java.lang.Runnable
            public void run() {
                OnDownloadListener onDownloadListener = onDownloadListener;
                UtErrorCode utErrorCode = UtErrorCode.NETWORK_DOWNLOAD_EXCEPTION;
                onDownloadListener.onDownloadFailed(utErrorCode.getIntCode(), utErrorCode.getMsg() + ": 下载失败监听回调 :" + LogUtils.getStackTraceMessage(iOException));
            }
        }

        /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do$1$2 */
        public class AnonymousClass2 implements FileUtil.WriteProgress {
            public AnonymousClass2() {
            }

            @Override // com.alimm.tanx.core.utils.FileUtil.WriteProgress
            public void error(Exception exc) {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                tanxc_do.this.tanxc_do(null, -1L, -1, exc, onDownloadListener);
            }

            @Override // com.alimm.tanx.core.utils.FileUtil.WriteProgress
            public void writeProgress(int i10) {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                tanxc_do.this.tanxc_do(null, -1L, i10, null, onDownloadListener);
            }
        }

        public AnonymousClass1(OnDownloadListener onDownloadListener) {
            onDownloadListener = onDownloadListener;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            tanxc_do.this.tanxc_if();
            tanxc_do.this.tanxc_char.post(new Runnable() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.1.1
                final /* synthetic */ IOException tanxc_do;

                public RunnableC02121(IOException iOException2) {
                    iOException = iOException2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    OnDownloadListener onDownloadListener = onDownloadListener;
                    UtErrorCode utErrorCode = UtErrorCode.NETWORK_DOWNLOAD_EXCEPTION;
                    onDownloadListener.onDownloadFailed(utErrorCode.getIntCode(), utErrorCode.getMsg() + ": 下载失败监听回调 :" + LogUtils.getStackTraceMessage(iOException));
                }
            });
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            try {
                tanxc_do.this.tanxc_if();
                File andCreateFile = FileUtil.getAndCreateFile(tanxc_do.this.tanxc_int, tanxc_do.this.tanxc_new);
                Long valueOf = Long.valueOf(response.body().getContentLength());
                if (tanxc_do.this.tanxc_do == valueOf.longValue()) {
                    tanxc_do.this.tanxc_do(andCreateFile, -1L, -1, null, onDownloadListener);
                    return;
                }
                tanxc_do.this.tanxc_do(null, tanxc_do.this.tanxc_try ? valueOf.longValue() + tanxc_do.this.tanxc_do : valueOf.longValue(), -1, null, onDownloadListener);
                if (response.body() != null) {
                    FileUtil.writeFile(response.body(), andCreateFile, tanxc_do.this.tanxc_do, tanxc_do.this.tanxc_try, new FileUtil.WriteProgress() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.1.2
                        public AnonymousClass2() {
                        }

                        @Override // com.alimm.tanx.core.utils.FileUtil.WriteProgress
                        public void error(Exception exc) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            tanxc_do.this.tanxc_do(null, -1L, -1, exc, onDownloadListener);
                        }

                        @Override // com.alimm.tanx.core.utils.FileUtil.WriteProgress
                        public void writeProgress(int i10) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            tanxc_do.this.tanxc_do(null, -1L, i10, null, onDownloadListener);
                        }
                    });
                }
                tanxc_do.this.tanxc_do(andCreateFile, -1L, -1, null, onDownloadListener);
            } catch (Exception e10) {
                LogUtils.e("OkDownloadBuilder", e10);
                tanxc_do.this.tanxc_do(null, -1L, -1, e10, onDownloadListener);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ int tanxc_do;
        final /* synthetic */ File tanxc_for;
        final /* synthetic */ OnDownloadListener tanxc_if;
        final /* synthetic */ long tanxc_int;
        final /* synthetic */ Exception tanxc_new;

        public AnonymousClass2(int i10, OnDownloadListener onDownloadListener, File file, long j10, Exception exc) {
            i10 = i10;
            onDownloadListener = onDownloadListener;
            file = file;
            j10 = j10;
            exc = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = i10;
            if (i10 > -1) {
                onDownloadListener.onDownloading(i10);
            }
            File file = file;
            if (file != null) {
                onDownloadListener.onDownloadSuccess(file);
            }
            long j10 = j10;
            if (j10 > -1) {
                onDownloadListener.onDownLoadTotal(j10);
            }
            if (exc != null) {
                OnDownloadListener onDownloadListener = onDownloadListener;
                UtErrorCode utErrorCode = UtErrorCode.NETWORK_DOWNLOAD_EXCEPTION;
                onDownloadListener.onDownloadFailed(utErrorCode.getIntCode(), utErrorCode.getMsg() + ": callBack e不为空:" + LogUtils.getStackTraceMessage(exc));
            }
        }
    }

    public tanxc_do tanxc_do() {
        Request.Builder builder = new Request.Builder();
        this.tanxc_else = builder;
        builder.url(this.tanxc_if);
        if (!TextUtils.isEmpty(this.tanxc_for)) {
            this.tanxc_else.tag(this.tanxc_for);
        }
        this.tanxc_else.cacheControl(CacheControl.FORCE_NETWORK);
        return this;
    }

    public tanxc_do tanxc_for(String str) {
        this.tanxc_if = str;
        return this;
    }

    public void tanxc_if() {
        if (this.tanxc_byte) {
            if (TextUtils.isEmpty(this.tanxc_for)) {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().remove(this.tanxc_if);
            } else {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().remove(this.tanxc_for);
            }
        }
    }

    public tanxc_do tanxc_int(String str) {
        this.tanxc_for = str;
        return this;
    }

    public tanxc_do tanxc_if(String str) {
        this.tanxc_new = str;
        return this;
    }

    public void tanxc_do(OnDownloadListener onDownloadListener) {
        if (this.tanxc_byte) {
            if (!TextUtils.isEmpty(this.tanxc_for)) {
                if (com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_for)) {
                    return;
                } else {
                    com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_for);
                }
            } else if (com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_if)) {
                return;
            } else {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_if);
            }
        }
        if (this.tanxc_try) {
            File file = new File(this.tanxc_int, this.tanxc_new);
            if (file.exists()) {
                this.tanxc_do = file.length();
                this.tanxc_else.header("RANGE", "bytes=" + this.tanxc_do + "-");
            }
        }
        this.tanxc_case.newCall(this.tanxc_else.build()).enqueue(new Callback() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.1
            final /* synthetic */ OnDownloadListener tanxc_do;

            /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do$1$1 */
            public class RunnableC02121 implements Runnable {
                final /* synthetic */ IOException tanxc_do;

                public RunnableC02121(IOException iOException2) {
                    iOException = iOException2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    OnDownloadListener onDownloadListener = onDownloadListener;
                    UtErrorCode utErrorCode = UtErrorCode.NETWORK_DOWNLOAD_EXCEPTION;
                    onDownloadListener.onDownloadFailed(utErrorCode.getIntCode(), utErrorCode.getMsg() + ": 下载失败监听回调 :" + LogUtils.getStackTraceMessage(iOException));
                }
            }

            /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do$1$2 */
            public class AnonymousClass2 implements FileUtil.WriteProgress {
                public AnonymousClass2() {
                }

                @Override // com.alimm.tanx.core.utils.FileUtil.WriteProgress
                public void error(Exception exc) {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    tanxc_do.this.tanxc_do(null, -1L, -1, exc, onDownloadListener);
                }

                @Override // com.alimm.tanx.core.utils.FileUtil.WriteProgress
                public void writeProgress(int i10) {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    tanxc_do.this.tanxc_do(null, -1L, i10, null, onDownloadListener);
                }
            }

            public AnonymousClass1(OnDownloadListener onDownloadListener2) {
                onDownloadListener = onDownloadListener2;
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException2) {
                tanxc_do.this.tanxc_if();
                tanxc_do.this.tanxc_char.post(new Runnable() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.1.1
                    final /* synthetic */ IOException tanxc_do;

                    public RunnableC02121(IOException iOException22) {
                        iOException = iOException22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        OnDownloadListener onDownloadListener2 = onDownloadListener;
                        UtErrorCode utErrorCode = UtErrorCode.NETWORK_DOWNLOAD_EXCEPTION;
                        onDownloadListener2.onDownloadFailed(utErrorCode.getIntCode(), utErrorCode.getMsg() + ": 下载失败监听回调 :" + LogUtils.getStackTraceMessage(iOException));
                    }
                });
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    tanxc_do.this.tanxc_if();
                    File andCreateFile = FileUtil.getAndCreateFile(tanxc_do.this.tanxc_int, tanxc_do.this.tanxc_new);
                    Long valueOf = Long.valueOf(response.body().getContentLength());
                    if (tanxc_do.this.tanxc_do == valueOf.longValue()) {
                        tanxc_do.this.tanxc_do(andCreateFile, -1L, -1, null, onDownloadListener);
                        return;
                    }
                    tanxc_do.this.tanxc_do(null, tanxc_do.this.tanxc_try ? valueOf.longValue() + tanxc_do.this.tanxc_do : valueOf.longValue(), -1, null, onDownloadListener);
                    if (response.body() != null) {
                        FileUtil.writeFile(response.body(), andCreateFile, tanxc_do.this.tanxc_do, tanxc_do.this.tanxc_try, new FileUtil.WriteProgress() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.1.2
                            public AnonymousClass2() {
                            }

                            @Override // com.alimm.tanx.core.utils.FileUtil.WriteProgress
                            public void error(Exception exc) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                tanxc_do.this.tanxc_do(null, -1L, -1, exc, onDownloadListener);
                            }

                            @Override // com.alimm.tanx.core.utils.FileUtil.WriteProgress
                            public void writeProgress(int i10) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                tanxc_do.this.tanxc_do(null, -1L, i10, null, onDownloadListener);
                            }
                        });
                    }
                    tanxc_do.this.tanxc_do(andCreateFile, -1L, -1, null, onDownloadListener);
                } catch (Exception e10) {
                    LogUtils.e("OkDownloadBuilder", e10);
                    tanxc_do.this.tanxc_do(null, -1L, -1, e10, onDownloadListener);
                }
            }
        });
    }

    public tanxc_do tanxc_do(String str) {
        this.tanxc_int = str;
        return this;
    }

    public tanxc_do tanxc_do(boolean z10) {
        this.tanxc_try = z10;
        return this;
    }

    public void tanxc_do(File file, long j10, int i10, Exception exc, OnDownloadListener onDownloadListener) {
        if (onDownloadListener != null) {
            this.tanxc_char.post(new Runnable() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.2
                final /* synthetic */ int tanxc_do;
                final /* synthetic */ File tanxc_for;
                final /* synthetic */ OnDownloadListener tanxc_if;
                final /* synthetic */ long tanxc_int;
                final /* synthetic */ Exception tanxc_new;

                public AnonymousClass2(int i102, OnDownloadListener onDownloadListener2, File file2, long j102, Exception exc2) {
                    i10 = i102;
                    onDownloadListener = onDownloadListener2;
                    file = file2;
                    j10 = j102;
                    exc = exc2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i102 = i10;
                    if (i102 > -1) {
                        onDownloadListener.onDownloading(i102);
                    }
                    File file2 = file;
                    if (file2 != null) {
                        onDownloadListener.onDownloadSuccess(file2);
                    }
                    long j102 = j10;
                    if (j102 > -1) {
                        onDownloadListener.onDownLoadTotal(j102);
                    }
                    if (exc != null) {
                        OnDownloadListener onDownloadListener2 = onDownloadListener;
                        UtErrorCode utErrorCode = UtErrorCode.NETWORK_DOWNLOAD_EXCEPTION;
                        onDownloadListener2.onDownloadFailed(utErrorCode.getIntCode(), utErrorCode.getMsg() + ": callBack e不为空:" + LogUtils.getStackTraceMessage(exc));
                    }
                }
            });
        }
    }
}
