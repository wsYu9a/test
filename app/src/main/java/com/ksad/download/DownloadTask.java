package com.ksad.download;

import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.q;
import com.kwai.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwai.filedownloader.i;
import com.kwai.filedownloader.r;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class DownloadTask implements Serializable {
    private static final long serialVersionUID = -7092669850073266500L;
    private int mAllowedNetworkTypes;
    protected transient com.kwai.filedownloader.a mBaseDownloadTask;
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

    /* renamed from: com.ksad.download.DownloadTask$1 */
    final class AnonymousClass1 extends i {
        AnonymousClass1() {
        }

        @Override // com.kwai.filedownloader.i
        public final void a(com.kwai.filedownloader.a aVar) {
            DownloadTask.this.onStarted(aVar);
        }

        @Override // com.kwai.filedownloader.i
        public final void a(com.kwai.filedownloader.a aVar, int i2, int i3) {
            DownloadTask.this.onPending(aVar, i2, i3);
        }

        @Override // com.kwai.filedownloader.i
        public final void a(com.kwai.filedownloader.a aVar, String str, boolean z, int i2, int i3) {
            DownloadTask.this.onConnected(aVar, str, z, i2, i3);
        }

        @Override // com.kwai.filedownloader.i
        public final void a(com.kwai.filedownloader.a aVar, Throwable th) {
            DownloadTask.this.onError(aVar, th);
        }

        @Override // com.kwai.filedownloader.i
        public final void b(com.kwai.filedownloader.a aVar) {
            DownloadTask.this.onBlockCompleted(aVar);
        }

        @Override // com.kwai.filedownloader.i
        public final void b(com.kwai.filedownloader.a aVar, int i2, int i3) {
            DownloadTask.this.onDownloading(aVar, i2, i3);
        }

        @Override // com.kwai.filedownloader.i
        public final void c(com.kwai.filedownloader.a aVar) {
            DownloadTask.this.onCompleted(aVar);
        }

        @Override // com.kwai.filedownloader.i
        public final void c(com.kwai.filedownloader.a aVar, int i2, int i3) {
            DownloadTask.this.onPause(aVar, i2, i3);
        }

        @Override // com.kwai.filedownloader.i
        public final void d(com.kwai.filedownloader.a aVar) {
            DownloadTask.this.onWarn(aVar);
        }
    }

    /* renamed from: com.ksad.download.DownloadTask$2 */
    final class AnonymousClass2 implements com.kwad.sdk.e.a<d> {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.e.a
        /* renamed from: a */
        public void accept(d dVar) {
            dVar.i(DownloadTask.this);
        }
    }

    /* renamed from: com.ksad.download.DownloadTask$3 */
    final class AnonymousClass3 implements com.kwad.sdk.e.a<d> {
        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.e.a
        /* renamed from: a */
        public void accept(d dVar) {
            dVar.k(DownloadTask.this);
        }
    }

    /* renamed from: com.ksad.download.DownloadTask$4 */
    final class AnonymousClass4 implements com.kwad.sdk.e.a<d> {
        final /* synthetic */ boolean bx;

        AnonymousClass4(boolean z) {
            z = z;
        }

        @Override // com.kwad.sdk.e.a
        /* renamed from: a */
        public void accept(d dVar) {
            dVar.a(DownloadTask.this, z);
        }
    }

    /* renamed from: com.ksad.download.DownloadTask$5 */
    final class AnonymousClass5 implements com.kwad.sdk.e.a<d> {
        AnonymousClass5() {
        }

        @Override // com.kwad.sdk.e.a
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
        private String mDestinationDir = c.M().N().getPath();

        public DownloadRequest(String str) {
            this.mAllowedNetworkTypes = 3;
            this.mDownloadUrl = str;
            NetworkInfo bZ = ag.bZ(c.M().getContext());
            if (bZ == null || bZ.getType() != 0) {
                this.mAllowedNetworkTypes = 2;
            } else {
                this.mAllowedNetworkTypes = 3;
            }
        }

        public DownloadRequest addRequestHeader(String str, String str2) {
            ao.eK(str);
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

        public DownloadRequest setAllowedNetworkTypes(int i2) {
            this.mAllowedNetworkTypes = i2;
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

        public void setDownloadEnablePause(boolean z) {
            this.downloadEnablePause = z;
        }

        public DownloadRequest setInstallAfterDownload(boolean z) {
            this.mInstallAfterDownload = z;
            return this;
        }

        public void setIsPhotoAdDownloadRequest() {
            this.mIsPhotoAdDownloadRequest = true;
        }

        public DownloadRequest setNotificationVisibility(int i2) {
            this.mNotificationVisibility = i2;
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
        this.mBaseDownloadTask.k(this.mTag);
        this.mBaseDownloadTask.bR((this.mAllowedNetworkTypes ^ 2) == 0);
        for (Map.Entry<String, String> entry : this.mRequestHeaders.entrySet()) {
            this.mBaseDownloadTask.fk(entry.getKey());
            this.mBaseDownloadTask.al(entry.getKey(), entry.getValue());
        }
    }

    private void notify(DownloadTask downloadTask, com.kwad.sdk.e.a<d> aVar) {
        d O = c.M().O();
        if (O == null) {
            return;
        }
        if (downloadTask.isCanceled()) {
            O.v(downloadTask.getId());
        } else {
            aVar.accept(O);
        }
    }

    private void notifyDownloadCanceled() {
        d O = c.M().O();
        if (O == null) {
            return;
        }
        O.v(getId());
    }

    private void notifyDownloadCompleted(com.kwai.filedownloader.a aVar) {
        if ((this.mNotificationVisibility & 2) != 0) {
            notify(this, new com.kwad.sdk.e.a<d>() { // from class: com.ksad.download.DownloadTask.3
                AnonymousClass3() {
                }

                @Override // com.kwad.sdk.e.a
                /* renamed from: a */
                public void accept(d dVar) {
                    dVar.k(DownloadTask.this);
                }
            });
        }
    }

    private void notifyDownloadError(com.kwai.filedownloader.a aVar) {
        if ((this.mNotificationVisibility & 1) != 0) {
            notify(this, new com.kwad.sdk.e.a<d>() { // from class: com.ksad.download.DownloadTask.5
                AnonymousClass5() {
                }

                @Override // com.kwad.sdk.e.a
                /* renamed from: a */
                public void accept(d dVar) {
                    dVar.j(DownloadTask.this);
                }
            });
        }
    }

    private void notifyDownloadPending() {
        if ((this.mNotificationVisibility & 2) != 0) {
            notify(this, new com.kwad.sdk.e.a<d>() { // from class: com.ksad.download.DownloadTask.2
                AnonymousClass2() {
                }

                @Override // com.kwad.sdk.e.a
                /* renamed from: a */
                public void accept(d dVar) {
                    dVar.i(DownloadTask.this);
                }
            });
        }
    }

    private void notifyDownloadProgress(com.kwai.filedownloader.a aVar, boolean z) {
        if ((aVar.getSmallFileTotalBytes() == 0 && aVar.getSmallFileSoFarBytes() == 0) || TextUtils.isEmpty(aVar.getFilename()) || (this.mNotificationVisibility & 1) == 0) {
            return;
        }
        notify(this, new com.kwad.sdk.e.a<d>() { // from class: com.ksad.download.DownloadTask.4
            final /* synthetic */ boolean bx;

            AnonymousClass4(boolean z2) {
                z = z2;
            }

            @Override // com.kwad.sdk.e.a
            /* renamed from: a */
            public void accept(d dVar) {
                dVar.a(DownloadTask.this, z);
            }
        });
    }

    public void onBlockCompleted(com.kwai.filedownloader.a aVar) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void onCanceled(com.kwai.filedownloader.a aVar) {
        try {
            this.mIsCanceled = true;
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().d(this);
            }
            aVar.cancel();
            notifyDownloadCanceled();
            r.Hp().m(getId(), this.mBaseDownloadTask.getTargetFilePath());
            releaseDownloadTask();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onCompleted(com.kwai.filedownloader.a aVar) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            notifyDownloadCompleted(aVar);
            if (this.mWakeInstallApk) {
                installApk();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onConnected(com.kwai.filedownloader.a aVar, String str, boolean z, int i2, int i3) {
        long j2;
        long j3 = i3;
        try {
            j2 = h.getAvailableBytes(new File(this.mDestinationDir).exists() ? this.mDestinationDir : Environment.getExternalStorageDirectory().getPath());
        } catch (Exception e2) {
            e2.printStackTrace();
            j2 = j3;
        }
        if (j2 < j3) {
            c.M().cancel(aVar.getId());
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
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void onDownloading(com.kwai.filedownloader.a aVar, int i2, int i3) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().a(this, i2, i3);
            }
            notifyDownloadProgress(this.mBaseDownloadTask, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onError(com.kwai.filedownloader.a aVar, Throwable th) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().a(this, th);
            }
            notifyDownloadError(aVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void onLowStorage(com.kwai.filedownloader.a aVar) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().f(this);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onPause(com.kwai.filedownloader.a aVar, int i2, int i3) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().c(this);
            }
            notifyDownloadProgress(aVar, true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onPending(com.kwai.filedownloader.a aVar, int i2, int i3) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
            notifyDownloadPending();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void onResume(com.kwai.filedownloader.a aVar, int i2, int i3) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().e(this);
            }
            notifyDownloadProgress(aVar, true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onStarted(com.kwai.filedownloader.a aVar) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onWarn(com.kwai.filedownloader.a aVar) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
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

    void cancel() {
        try {
            onCanceled(this.mBaseDownloadTask);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void clearListener() {
        this.mDownloadListeners.clear();
    }

    int downLoadProgress() {
        long smallFileTotalBytes = this.mBaseDownloadTask.getSmallFileTotalBytes();
        int smallFileSoFarBytes = smallFileTotalBytes != 0 ? (int) ((this.mBaseDownloadTask.getSmallFileSoFarBytes() * 100.0f) / smallFileTotalBytes) : 0;
        if (smallFileSoFarBytes != 100 || q.H(new File(this.mBaseDownloadTask.getTargetFilePath()))) {
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
        return this.mBaseDownloadTask.Gq();
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

    void installApk() {
        try {
            c.M().g(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    void instantiateDownloadTask() {
        r.Hp();
        this.mBaseDownloadTask = r.fm(this.mUrl).bP(true).cv(3).f(TextUtils.isEmpty(this.mDestinationFileName) ? this.mDestinationDir : new File(this.mDestinationDir, this.mDestinationFileName).getPath(), TextUtils.isEmpty(this.mDestinationFileName)).a(new i() { // from class: com.ksad.download.DownloadTask.1
            AnonymousClass1() {
            }

            @Override // com.kwai.filedownloader.i
            public final void a(com.kwai.filedownloader.a aVar) {
                DownloadTask.this.onStarted(aVar);
            }

            @Override // com.kwai.filedownloader.i
            public final void a(com.kwai.filedownloader.a aVar, int i2, int i3) {
                DownloadTask.this.onPending(aVar, i2, i3);
            }

            @Override // com.kwai.filedownloader.i
            public final void a(com.kwai.filedownloader.a aVar, String str, boolean z, int i2, int i3) {
                DownloadTask.this.onConnected(aVar, str, z, i2, i3);
            }

            @Override // com.kwai.filedownloader.i
            public final void a(com.kwai.filedownloader.a aVar, Throwable th) {
                DownloadTask.this.onError(aVar, th);
            }

            @Override // com.kwai.filedownloader.i
            public final void b(com.kwai.filedownloader.a aVar) {
                DownloadTask.this.onBlockCompleted(aVar);
            }

            @Override // com.kwai.filedownloader.i
            public final void b(com.kwai.filedownloader.a aVar, int i2, int i3) {
                DownloadTask.this.onDownloading(aVar, i2, i3);
            }

            @Override // com.kwai.filedownloader.i
            public final void c(com.kwai.filedownloader.a aVar) {
                DownloadTask.this.onCompleted(aVar);
            }

            @Override // com.kwai.filedownloader.i
            public final void c(com.kwai.filedownloader.a aVar, int i2, int i3) {
                DownloadTask.this.onPause(aVar, i2, i3);
            }

            @Override // com.kwai.filedownloader.i
            public final void d(com.kwai.filedownloader.a aVar) {
                DownloadTask.this.onWarn(aVar);
            }
        });
    }

    public boolean isCanceled() {
        return this.mIsCanceled;
    }

    public boolean isCompleted() {
        return this.mBaseDownloadTask.Gq() == -3;
    }

    public boolean isError() {
        return this.mBaseDownloadTask.Gq() == -1;
    }

    public boolean isErrorBecauseWifiRequired() {
        return this.mBaseDownloadTask.Gx() && isError() && (this.mBaseDownloadTask.Gs() instanceof FileDownloadNetworkPolicyException);
    }

    public boolean isInvalid() {
        return this.mBaseDownloadTask.Gq() == 0;
    }

    public boolean isNotificationRemoved() {
        return this.notificationRemoved;
    }

    public boolean isPaused() {
        return this.mBaseDownloadTask.Gq() == -2;
    }

    public boolean isRunning() {
        return this.mBaseDownloadTask.isRunning();
    }

    boolean isUserPause() {
        return this.mUserPause;
    }

    void pause() {
        this.mBaseDownloadTask.pause();
        notifyDownloadProgress(this.mBaseDownloadTask, true);
    }

    public void removeListener(a aVar) {
        if (aVar != null) {
            this.mDownloadListeners.remove(aVar);
        }
    }

    void resume(DownloadRequest downloadRequest) {
        if (ag.isNetworkConnected(c.M().getContext())) {
            if (downloadRequest != null) {
                initDownloadRequestParams(downloadRequest);
                initDownloadTaskParams();
            }
            this.mUserPause = false;
            if (this.mBaseDownloadTask.isRunning()) {
                com.kwai.filedownloader.a aVar = this.mBaseDownloadTask;
                onResume(aVar, aVar.getSmallFileSoFarBytes(), this.mBaseDownloadTask.getSmallFileTotalBytes());
                return;
            }
            try {
                if (com.kwai.filedownloader.c.d.dd(this.mBaseDownloadTask.Gq())) {
                    this.mBaseDownloadTask.Gi();
                }
                submit();
                com.kwai.filedownloader.a aVar2 = this.mBaseDownloadTask;
                onResume(aVar2, aVar2.getSmallFileSoFarBytes(), this.mBaseDownloadTask.getSmallFileTotalBytes());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setAllowedNetworkTypes(int i2) {
        this.mAllowedNetworkTypes = i2;
        this.mBaseDownloadTask.bR((i2 ^ 2) == 0);
    }

    public void setNotificationRemoved(boolean z) {
        this.notificationRemoved = z;
    }

    public void submit() {
        try {
            if (this.mBaseDownloadTask.isRunning()) {
                return;
            }
            this.mBaseDownloadTask.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    com.kwai.filedownloader.a unwrap() {
        return this.mBaseDownloadTask;
    }

    void userPause() {
        this.mUserPause = true;
        pause();
    }
}
