package com.kwad.sdk;

import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import com.kwad.framework.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwad.framework.filedownloader.r;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.u;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class DownloadTask implements Serializable {
    private static final long serialVersionUID = -7092669850073266500L;
    public int downloadType;
    private int mAllowedNetworkTypes;
    protected transient com.kwad.framework.filedownloader.a mBaseDownloadTask;
    private String mDestinationDir;
    private String mDestinationFileName;
    private int mNotificationVisibility;
    private Map<String, String> mRequestHeaders;
    private Serializable mTag;
    private String mUrl;
    private boolean mUserPause;
    private boolean mWakeInstallApk;
    private transient List<a> mDownloadListeners = new ArrayList();
    private boolean mIsCanceled = false;
    public boolean downloadEnablePause = false;
    private boolean notificationRemoved = false;

    /* renamed from: com.kwad.sdk.DownloadTask$1 */
    public class AnonymousClass1 extends com.kwad.framework.filedownloader.i {
        public AnonymousClass1() {
        }

        @Override // com.kwad.framework.filedownloader.i
        public final void a(com.kwad.framework.filedownloader.a aVar, String str, boolean z10, int i10, int i11) {
            DownloadTask.this.onConnected(aVar, str, z10, i10, i11);
        }

        @Override // com.kwad.framework.filedownloader.i
        public final void b(com.kwad.framework.filedownloader.a aVar, int i10, int i11) {
            DownloadTask.this.onDownloading(aVar, i10, i11);
        }

        @Override // com.kwad.framework.filedownloader.i
        public final void c(com.kwad.framework.filedownloader.a aVar) {
            DownloadTask.this.onCompleted(aVar);
        }

        @Override // com.kwad.framework.filedownloader.i
        public final void d(com.kwad.framework.filedownloader.a aVar) {
            DownloadTask.this.onWarn(aVar);
        }

        @Override // com.kwad.framework.filedownloader.i
        public final void a(com.kwad.framework.filedownloader.a aVar) {
            DownloadTask.this.onStarted(aVar);
        }

        @Override // com.kwad.framework.filedownloader.i
        public final void b(com.kwad.framework.filedownloader.a aVar) {
            DownloadTask.this.onBlockCompleted(aVar);
        }

        @Override // com.kwad.framework.filedownloader.i
        public final void c(com.kwad.framework.filedownloader.a aVar, int i10, int i11) {
            DownloadTask.this.onPause(aVar, i10, i11);
        }

        @Override // com.kwad.framework.filedownloader.i
        public final void a(com.kwad.framework.filedownloader.a aVar, int i10, int i11) {
            DownloadTask.this.onPending(aVar, i10, i11);
        }

        @Override // com.kwad.framework.filedownloader.i
        public final void a(com.kwad.framework.filedownloader.a aVar, Throwable th2) {
            DownloadTask.this.onError(aVar, th2);
        }
    }

    /* renamed from: com.kwad.sdk.DownloadTask$2 */
    public class AnonymousClass2 implements com.kwad.sdk.f.a<d> {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: a */
        public void accept(d dVar) {
            dVar.i(DownloadTask.this);
        }
    }

    /* renamed from: com.kwad.sdk.DownloadTask$3 */
    public class AnonymousClass3 implements com.kwad.sdk.f.a<d> {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: a */
        public void accept(d dVar) {
            dVar.k(DownloadTask.this);
        }
    }

    /* renamed from: com.kwad.sdk.DownloadTask$4 */
    public class AnonymousClass4 implements com.kwad.sdk.f.a<d> {
        final /* synthetic */ boolean anJ;

        public AnonymousClass4(boolean z10) {
            z10 = z10;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: a */
        public void accept(d dVar) {
            dVar.a(DownloadTask.this, z10);
        }
    }

    /* renamed from: com.kwad.sdk.DownloadTask$5 */
    public class AnonymousClass5 implements com.kwad.sdk.f.a<d> {
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: a */
        public void accept(d dVar) {
            dVar.j(DownloadTask.this);
        }
    }

    public static class DownloadRequest implements Serializable {
        private static final long serialVersionUID = -3638290207248829674L;
        private int mAllowedNetworkTypes;
        private String mDestinationFileName;
        private String mDownloadUrl;
        private Serializable mTag;
        private final Map<String, String> mRequestHeaders = new HashMap();
        private boolean mInstallAfterDownload = true;

        @Deprecated
        private boolean mIsPhotoAdDownloadRequest = false;
        private int mNotificationVisibility = 0;
        public boolean downloadEnablePause = false;
        private String mDestinationDir = c.yU().yV().getPath();

        public DownloadRequest(String str) {
            this.mAllowedNetworkTypes = 3;
            this.mDownloadUrl = str;
            NetworkInfo cB = al.cB(c.yU().getContext());
            if (cB == null || cB.getType() != 0) {
                this.mAllowedNetworkTypes = 2;
            } else {
                this.mAllowedNetworkTypes = 3;
            }
        }

        public DownloadRequest addRequestHeader(String str, String str2) {
            au.gV(str);
            if (str.contains(":")) {
                throw new IllegalArgumentException("header may not contain ':'");
            }
            if (str2 == null) {
                str2 = "";
            }
            this.mRequestHeaders.put(str, str2);
            return this;
        }

        public int getAllowedNetworkTypes() {
            return this.mAllowedNetworkTypes;
        }

        public String getDestinationDir() {
            return this.mDestinationDir;
        }

        public String getDestinationFileName() {
            return this.mDestinationFileName;
        }

        public String getDownloadUrl() {
            return this.mDownloadUrl;
        }

        public Serializable getTag() {
            return this.mTag;
        }

        public boolean isDownloadEnablePause() {
            return this.downloadEnablePause;
        }

        public boolean isPhotoAdDownloadRequest() {
            return this.mIsPhotoAdDownloadRequest;
        }

        public DownloadRequest setAllowedNetworkTypes(int i10) {
            this.mAllowedNetworkTypes = i10;
            return this;
        }

        public DownloadRequest setDestinationDir(String str) {
            this.mDestinationDir = str;
            return this;
        }

        public DownloadRequest setDestinationFileName(String str) {
            this.mDestinationFileName = str;
            return this;
        }

        public void setDownloadEnablePause(boolean z10) {
            this.downloadEnablePause = z10;
        }

        public DownloadRequest setInstallAfterDownload(boolean z10) {
            this.mInstallAfterDownload = z10;
            return this;
        }

        public void setIsPhotoAdDownloadRequest() {
            this.mIsPhotoAdDownloadRequest = true;
        }

        public DownloadRequest setNotificationVisibility(int i10) {
            this.mNotificationVisibility = i10;
            return this;
        }

        public DownloadRequest setTag(Serializable serializable) {
            this.mTag = serializable;
            return this;
        }
    }

    public DownloadTask(DownloadRequest downloadRequest) {
        initDownloadRequestParams(downloadRequest);
        instantiateDownloadTask();
        initDownloadTaskParams();
    }

    private void initDownloadRequestParams(DownloadRequest downloadRequest) {
        this.mWakeInstallApk = downloadRequest.mInstallAfterDownload;
        this.mUrl = downloadRequest.mDownloadUrl;
        this.mAllowedNetworkTypes = downloadRequest.mAllowedNetworkTypes;
        this.mNotificationVisibility = downloadRequest.mNotificationVisibility;
        this.mDestinationDir = downloadRequest.mDestinationDir;
        this.mDestinationFileName = downloadRequest.mDestinationFileName;
        this.mRequestHeaders = downloadRequest.mRequestHeaders;
        this.mTag = downloadRequest.mTag;
        this.downloadEnablePause = downloadRequest.isDownloadEnablePause();
    }

    private void initDownloadTaskParams() {
        this.mBaseDownloadTask.e(this.mTag);
        this.mBaseDownloadTask.bd((this.mAllowedNetworkTypes ^ 2) == 0);
        for (Map.Entry<String, String> entry : this.mRequestHeaders.entrySet()) {
            this.mBaseDownloadTask.bf(entry.getKey());
            this.mBaseDownloadTask.t(entry.getKey(), entry.getValue());
        }
    }

    private void notify(DownloadTask downloadTask, com.kwad.sdk.f.a<d> aVar) {
        d yW = c.yU().yW();
        if (yW == null) {
            return;
        }
        if (downloadTask.isCanceled()) {
            yW.bW(downloadTask.getId());
        } else {
            aVar.accept(yW);
        }
    }

    private void notifyDownloadCanceled() {
        d yW = c.yU().yW();
        if (yW == null) {
            return;
        }
        yW.bW(getId());
    }

    private void notifyDownloadCompleted(com.kwad.framework.filedownloader.a aVar) {
        if ((this.mNotificationVisibility & 2) != 0) {
            notify(this, new com.kwad.sdk.f.a<d>() { // from class: com.kwad.sdk.DownloadTask.3
                public AnonymousClass3() {
                }

                @Override // com.kwad.sdk.f.a
                /* renamed from: a */
                public void accept(d dVar) {
                    dVar.k(DownloadTask.this);
                }
            });
        }
    }

    private void notifyDownloadError(com.kwad.framework.filedownloader.a aVar) {
        if ((this.mNotificationVisibility & 1) != 0) {
            notify(this, new com.kwad.sdk.f.a<d>() { // from class: com.kwad.sdk.DownloadTask.5
                public AnonymousClass5() {
                }

                @Override // com.kwad.sdk.f.a
                /* renamed from: a */
                public void accept(d dVar) {
                    dVar.j(DownloadTask.this);
                }
            });
        }
    }

    private void notifyDownloadPending() {
        if ((this.mNotificationVisibility & 2) != 0) {
            notify(this, new com.kwad.sdk.f.a<d>() { // from class: com.kwad.sdk.DownloadTask.2
                public AnonymousClass2() {
                }

                @Override // com.kwad.sdk.f.a
                /* renamed from: a */
                public void accept(d dVar) {
                    dVar.i(DownloadTask.this);
                }
            });
        }
    }

    private void notifyDownloadProgress(com.kwad.framework.filedownloader.a aVar, boolean z10) {
        if ((aVar.getSmallFileTotalBytes() == 0 && aVar.getSmallFileSoFarBytes() == 0) || TextUtils.isEmpty(aVar.getFilename()) || (this.mNotificationVisibility & 1) == 0) {
            return;
        }
        notify(this, new com.kwad.sdk.f.a<d>() { // from class: com.kwad.sdk.DownloadTask.4
            final /* synthetic */ boolean anJ;

            public AnonymousClass4(boolean z102) {
                z10 = z102;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: a */
            public void accept(d dVar) {
                dVar.a(DownloadTask.this, z10);
            }
        });
    }

    public void onBlockCompleted(com.kwad.framework.filedownloader.a aVar) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void onCanceled(com.kwad.framework.filedownloader.a aVar) {
        try {
            this.mIsCanceled = true;
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().d(this);
            }
            aVar.cancel();
            notifyDownloadCanceled();
            r.wc().q(getId(), this.mBaseDownloadTask.getTargetFilePath());
            releaseDownloadTask();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void onCompleted(com.kwad.framework.filedownloader.a aVar) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            notifyDownloadCompleted(aVar);
            if (this.mWakeInstallApk) {
                installApk();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void onConnected(com.kwad.framework.filedownloader.a aVar, String str, boolean z10, int i10, int i11) {
        long j10;
        long j11 = i11;
        try {
            j10 = new File(this.mDestinationDir).exists() ? com.kwad.sdk.crash.utils.h.getAvailableBytes(this.mDestinationDir) : com.kwad.sdk.crash.utils.h.getAvailableBytes(Environment.getExternalStorageDirectory().getPath());
        } catch (Exception e10) {
            e10.printStackTrace();
            j10 = j11;
        }
        if (j10 < j11) {
            c.yU().cancel(aVar.getId());
            notifyDownloadCanceled();
            onLowStorage(aVar);
            return;
        }
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
            notifyDownloadProgress(aVar, false);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void onDownloading(com.kwad.framework.filedownloader.a aVar, int i10, int i11) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().a(this, i10, i11);
            }
            notifyDownloadProgress(this.mBaseDownloadTask, false);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void onError(com.kwad.framework.filedownloader.a aVar, Throwable th2) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().a(this, th2);
            }
            notifyDownloadError(aVar);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void onLowStorage(com.kwad.framework.filedownloader.a aVar) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().f(this);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void onPause(com.kwad.framework.filedownloader.a aVar, int i10, int i11) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().c(this);
            }
            notifyDownloadProgress(aVar, true);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void onPending(com.kwad.framework.filedownloader.a aVar, int i10, int i11) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
            notifyDownloadPending();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void onResume(com.kwad.framework.filedownloader.a aVar, int i10, int i11) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().e(this);
            }
            notifyDownloadProgress(aVar, true);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void onStarted(com.kwad.framework.filedownloader.a aVar) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void onWarn(com.kwad.framework.filedownloader.a aVar) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.mDownloadListeners = new ArrayList();
    }

    private void releaseDownloadTask() {
        this.mBaseDownloadTask.a(null);
        clearListener();
    }

    public void addListener(a aVar) {
        if (aVar == null || this.mDownloadListeners.contains(aVar)) {
            return;
        }
        this.mDownloadListeners.add(aVar);
    }

    public void cancel() {
        try {
            onCanceled(this.mBaseDownloadTask);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void clearListener() {
        this.mDownloadListeners.clear();
    }

    public int downLoadProgress() {
        long smallFileTotalBytes = this.mBaseDownloadTask.getSmallFileTotalBytes();
        int smallFileSoFarBytes = smallFileTotalBytes != 0 ? (int) ((this.mBaseDownloadTask.getSmallFileSoFarBytes() * 100.0f) / smallFileTotalBytes) : 0;
        if (smallFileSoFarBytes != 100 || u.N(new File(this.mBaseDownloadTask.getTargetFilePath()))) {
            return smallFileSoFarBytes;
        }
        return 0;
    }

    public int getAllowedNetworkTypes() {
        return this.mAllowedNetworkTypes;
    }

    public String getDestinationDir() {
        return this.mDestinationDir;
    }

    public String getFilename() {
        return this.mBaseDownloadTask.getFilename();
    }

    public int getId() {
        return this.mBaseDownloadTask.getId();
    }

    public int getNotificationVisibility() {
        return this.mNotificationVisibility;
    }

    public String getPath() {
        return this.mBaseDownloadTask.getPath();
    }

    public int getSmallFileSoFarBytes() {
        return this.mBaseDownloadTask.getSmallFileSoFarBytes();
    }

    public int getSmallFileTotalBytes() {
        return this.mBaseDownloadTask.getSmallFileTotalBytes();
    }

    public int getSpeed() {
        return this.mBaseDownloadTask.getSpeed();
    }

    public int getStatus() {
        return this.mBaseDownloadTask.vd();
    }

    public long getStatusUpdateTime() {
        return this.mBaseDownloadTask.getStatusUpdateTime();
    }

    public Object getTag() {
        return this.mBaseDownloadTask.getTag();
    }

    public String getTargetFilePath() {
        return this.mBaseDownloadTask.getTargetFilePath();
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void installApk() {
        try {
            c.yU().g(this);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void instantiateDownloadTask() {
        r.wc();
        this.mBaseDownloadTask = r.bg(this.mUrl).bb(true).aY(3).c(TextUtils.isEmpty(this.mDestinationFileName) ? this.mDestinationDir : new File(this.mDestinationDir, this.mDestinationFileName).getPath(), TextUtils.isEmpty(this.mDestinationFileName)).a(new com.kwad.framework.filedownloader.i() { // from class: com.kwad.sdk.DownloadTask.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, String str, boolean z10, int i10, int i11) {
                DownloadTask.this.onConnected(aVar, str, z10, i10, i11);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void b(com.kwad.framework.filedownloader.a aVar, int i10, int i11) {
                DownloadTask.this.onDownloading(aVar, i10, i11);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void c(com.kwad.framework.filedownloader.a aVar) {
                DownloadTask.this.onCompleted(aVar);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void d(com.kwad.framework.filedownloader.a aVar) {
                DownloadTask.this.onWarn(aVar);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar) {
                DownloadTask.this.onStarted(aVar);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void b(com.kwad.framework.filedownloader.a aVar) {
                DownloadTask.this.onBlockCompleted(aVar);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void c(com.kwad.framework.filedownloader.a aVar, int i10, int i11) {
                DownloadTask.this.onPause(aVar, i10, i11);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, int i10, int i11) {
                DownloadTask.this.onPending(aVar, i10, i11);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, Throwable th2) {
                DownloadTask.this.onError(aVar, th2);
            }
        });
    }

    public boolean isCanceled() {
        return this.mIsCanceled;
    }

    public boolean isCompleted() {
        return this.mBaseDownloadTask.vd() == -3;
    }

    public boolean isError() {
        return this.mBaseDownloadTask.vd() == -1;
    }

    public boolean isErrorBecauseWifiRequired() {
        return this.mBaseDownloadTask.vk() && isError() && (this.mBaseDownloadTask.vf() instanceof FileDownloadNetworkPolicyException);
    }

    public boolean isInvalid() {
        return this.mBaseDownloadTask.vd() == 0;
    }

    public boolean isNotificationRemoved() {
        return this.notificationRemoved;
    }

    public boolean isPaused() {
        return this.mBaseDownloadTask.vd() == -2;
    }

    public boolean isRunning() {
        return this.mBaseDownloadTask.isRunning();
    }

    public boolean isUserPause() {
        return this.mUserPause;
    }

    public void pause() {
        this.mBaseDownloadTask.pause();
        notifyDownloadProgress(this.mBaseDownloadTask, true);
    }

    public void removeListener(a aVar) {
        if (aVar != null) {
            this.mDownloadListeners.remove(aVar);
        }
    }

    public void resume(DownloadRequest downloadRequest) {
        if (al.isNetworkConnected(c.yU().getContext())) {
            if (downloadRequest != null) {
                initDownloadRequestParams(downloadRequest);
                initDownloadTaskParams();
            }
            this.mUserPause = false;
            if (this.mBaseDownloadTask.isRunning()) {
                com.kwad.framework.filedownloader.a aVar = this.mBaseDownloadTask;
                onResume(aVar, aVar.getSmallFileSoFarBytes(), this.mBaseDownloadTask.getSmallFileTotalBytes());
                return;
            }
            try {
                if (com.kwad.framework.filedownloader.d.d.bG(this.mBaseDownloadTask.vd())) {
                    this.mBaseDownloadTask.uV();
                }
                submit();
                com.kwad.framework.filedownloader.a aVar2 = this.mBaseDownloadTask;
                onResume(aVar2, aVar2.getSmallFileSoFarBytes(), this.mBaseDownloadTask.getSmallFileTotalBytes());
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public void setAllowedNetworkTypes(int i10) {
        this.mAllowedNetworkTypes = i10;
        this.mBaseDownloadTask.bd((i10 ^ 2) == 0);
    }

    public void setNotificationRemoved(boolean z10) {
        this.notificationRemoved = z10;
    }

    public void submit() {
        try {
            if (this.mBaseDownloadTask.isRunning()) {
                return;
            }
            this.mBaseDownloadTask.start();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public com.kwad.framework.filedownloader.a unwrap() {
        return this.mBaseDownloadTask;
    }

    public void userPause() {
        this.mUserPause = true;
        pause();
    }
}
