package com.czhj.volley.toolbox;

import android.os.Looper;
import com.czhj.volley.RequestQueue;
import com.czhj.volley.toolbox.FileDownloadRequest;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class FileDownloader {

    /* renamed from: a */
    public final RequestQueue f8767a;

    /* renamed from: b */
    public final int f8768b;

    /* renamed from: c */
    public final LinkedList<DownloadController> f8769c;

    public class DownloadController {
        public static final int STATUS_DISCARD = 4;
        public static final int STATUS_DOWNLOADING = 1;
        public static final int STATUS_PAUSE = 2;
        public static final int STATUS_SUCCESS = 3;
        public static final int STATUS_WAITING = 0;

        /* renamed from: a */
        public FileDownloadRequest.FileDownloadListener f8770a;

        /* renamed from: b */
        public FileDownloadRequest f8771b;

        /* renamed from: c */
        public DownloadItem f8772c;

        /* renamed from: d */
        public int f8773d;

        /* renamed from: com.czhj.volley.toolbox.FileDownloader$DownloadController$1 */
        public class AnonymousClass1 implements FileDownloadRequest.FileDownloadListener {

            /* renamed from: a */
            public boolean f8775a;

            public AnonymousClass1() {
            }

            @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
            public void downloadProgress(DownloadItem downloadItem, long j10, long j11) {
                FileDownloadRequest.FileDownloadListener fileDownloadListener = DownloadController.this.f8770a;
                if (fileDownloadListener != null) {
                    fileDownloadListener.downloadProgress(downloadItem, j10, j11);
                }
            }

            @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
            public void onCancel(DownloadItem downloadItem) {
                this.f8775a = true;
                FileDownloadRequest.FileDownloadListener fileDownloadListener = DownloadController.this.f8770a;
                if (fileDownloadListener != null) {
                    fileDownloadListener.onCancel(downloadItem);
                }
                DownloadController downloadController = DownloadController.this;
                FileDownloader.this.a(downloadController);
            }

            @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
            public void onErrorResponse(DownloadItem downloadItem) {
                FileDownloadRequest.FileDownloadListener fileDownloadListener = DownloadController.this.f8770a;
                if (fileDownloadListener != null && !this.f8775a) {
                    fileDownloadListener.onErrorResponse(downloadItem);
                }
                DownloadController downloadController = DownloadController.this;
                FileDownloader.this.a(downloadController);
            }

            @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
            public void onSuccess(DownloadItem downloadItem) {
                DownloadController downloadController = DownloadController.this;
                downloadController.f8773d = 3;
                FileDownloadRequest.FileDownloadListener fileDownloadListener = downloadController.f8770a;
                if (fileDownloadListener != null && !this.f8775a) {
                    fileDownloadListener.onSuccess(downloadItem);
                }
                DownloadController downloadController2 = DownloadController.this;
                FileDownloader.this.a(downloadController2);
            }
        }

        public DownloadController(DownloadItem downloadItem, FileDownloadRequest.FileDownloadListener fileDownloadListener) {
            this.f8770a = fileDownloadListener;
            this.f8772c = downloadItem;
        }

        public boolean a() {
            if (this.f8773d != 0) {
                return false;
            }
            FileDownloadRequest buildRequest = FileDownloader.this.buildRequest(this.f8772c, new FileDownloadRequest.FileDownloadListener() { // from class: com.czhj.volley.toolbox.FileDownloader.DownloadController.1

                /* renamed from: a */
                public boolean f8775a;

                public AnonymousClass1() {
                }

                @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
                public void downloadProgress(DownloadItem downloadItem, long j10, long j11) {
                    FileDownloadRequest.FileDownloadListener fileDownloadListener = DownloadController.this.f8770a;
                    if (fileDownloadListener != null) {
                        fileDownloadListener.downloadProgress(downloadItem, j10, j11);
                    }
                }

                @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
                public void onCancel(DownloadItem downloadItem) {
                    this.f8775a = true;
                    FileDownloadRequest.FileDownloadListener fileDownloadListener = DownloadController.this.f8770a;
                    if (fileDownloadListener != null) {
                        fileDownloadListener.onCancel(downloadItem);
                    }
                    DownloadController downloadController = DownloadController.this;
                    FileDownloader.this.a(downloadController);
                }

                @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
                public void onErrorResponse(DownloadItem downloadItem) {
                    FileDownloadRequest.FileDownloadListener fileDownloadListener = DownloadController.this.f8770a;
                    if (fileDownloadListener != null && !this.f8775a) {
                        fileDownloadListener.onErrorResponse(downloadItem);
                    }
                    DownloadController downloadController = DownloadController.this;
                    FileDownloader.this.a(downloadController);
                }

                @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
                public void onSuccess(DownloadItem downloadItem) {
                    DownloadController downloadController = DownloadController.this;
                    downloadController.f8773d = 3;
                    FileDownloadRequest.FileDownloadListener fileDownloadListener = downloadController.f8770a;
                    if (fileDownloadListener != null && !this.f8775a) {
                        fileDownloadListener.onSuccess(downloadItem);
                    }
                    DownloadController downloadController2 = DownloadController.this;
                    FileDownloader.this.a(downloadController2);
                }
            });
            this.f8771b = buildRequest;
            this.f8773d = 1;
            RequestQueue requestQueue = FileDownloader.this.f8767a;
            if (requestQueue == null) {
                return false;
            }
            requestQueue.add(buildRequest);
            return true;
        }

        public boolean discard() {
            int i10 = this.f8773d;
            if (i10 == 0) {
                this.f8773d = 4;
                FileDownloader.this.a(this);
                FileDownloadRequest.FileDownloadListener fileDownloadListener = this.f8770a;
                if (fileDownloadListener != null) {
                    fileDownloadListener.onCancel(this.f8772c);
                }
                return true;
            }
            if (i10 == 4 || i10 == 3) {
                return false;
            }
            if (i10 == 1) {
                this.f8771b.cancel();
            }
            this.f8773d = 4;
            FileDownloader.this.a(this);
            return true;
        }

        public DownloadItem getDownloadItem() {
            return this.f8772c;
        }

        public FileDownloadRequest.FileDownloadListener getDownloadListener() {
            return this.f8770a;
        }

        public int getStatus() {
            return this.f8773d;
        }

        public String getStorePath() {
            return this.f8772c.filePath;
        }

        public String getUrl() {
            return this.f8772c.url;
        }

        public boolean isDownloading() {
            return this.f8773d == 1;
        }

        public boolean pause() {
            if (this.f8773d != 1) {
                return false;
            }
            this.f8773d = 2;
            this.f8771b.cancel();
            FileDownloader.this.a();
            return true;
        }

        public boolean resume() {
            if (this.f8773d != 2) {
                return false;
            }
            this.f8773d = 0;
            FileDownloader.this.a();
            return true;
        }

        public void setDownloadListener(FileDownloadRequest.FileDownloadListener fileDownloadListener) {
            this.f8770a = fileDownloadListener;
        }
    }

    public FileDownloader(RequestQueue requestQueue) {
        this(requestQueue, 0);
    }

    public void a(DownloadController downloadController) {
        synchronized (this.f8769c) {
            this.f8769c.remove(downloadController);
        }
        a();
    }

    public DownloadController add(DownloadItem downloadItem, FileDownloadRequest.FileDownloadListener fileDownloadListener) {
        DownloadController downloadController = get(downloadItem.filePath, downloadItem.url);
        if (downloadController == null) {
            downloadController = new DownloadController(downloadItem, fileDownloadListener);
            synchronized (this.f8769c) {
                this.f8769c.add(downloadController);
            }
            a();
        }
        return downloadController;
    }

    public final void b() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("FileDownloader must be invoked from the main thread.");
        }
    }

    public FileDownloadRequest buildRequest(DownloadItem downloadItem, FileDownloadRequest.FileDownloadListener fileDownloadListener) {
        return new FileDownloadRequest(downloadItem, fileDownloadListener);
    }

    public void clearAll() {
        synchronized (this.f8769c) {
            while (this.f8769c.size() > 0) {
                try {
                    this.f8769c.get(0).discard();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public DownloadController get(String str, String str2) {
        synchronized (this.f8769c) {
            try {
                Iterator<DownloadController> it = this.f8769c.iterator();
                while (it.hasNext()) {
                    DownloadController next = it.next();
                    if (next.getStorePath().equals(str) && next.getUrl().equals(str2)) {
                        return next;
                    }
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public List<DownloadController> getAll() {
        LinkedList<DownloadController> linkedList;
        synchronized (this.f8769c) {
            linkedList = this.f8769c;
        }
        return linkedList;
    }

    public FileDownloader(RequestQueue requestQueue, int i10) {
        this.f8769c = new LinkedList<>();
        this.f8768b = i10;
        this.f8767a = requestQueue;
    }

    public void a() {
        synchronized (this.f8769c) {
            try {
                Iterator<DownloadController> it = this.f8769c.iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    if (it.next().isDownloading()) {
                        i10++;
                    }
                }
                if (i10 >= this.f8768b) {
                    return;
                }
                Iterator<DownloadController> it2 = this.f8769c.iterator();
                while (it2.hasNext()) {
                    if (it2.next().a() && (i10 = i10 + 1) == this.f8768b) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
