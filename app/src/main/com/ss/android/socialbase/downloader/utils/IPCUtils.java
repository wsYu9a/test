package com.ss.android.socialbase.downloader.utils;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.AbsDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadExtListener;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator;
import com.ss.android.socialbase.downloader.depend.ProcessAidlCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator;
import com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadAidlTask;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class IPCUtils {
    private static Handler mMainThreadHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$1 */
    public static class AnonymousClass1 extends DownloadAidlTask.Stub {
        public AnonymousClass1() {
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IChunkCntAidlCalculator getChunkStrategy() throws RemoteException {
            return IPCUtils.convertCntCalculatorToAidl(DownloadTask.this.getChunkStrategy());
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlDepend getDepend() throws RemoteException {
            return IPCUtils.convertDependToAidl(DownloadTask.this.getDepend());
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadDiskSpaceAidlHandler getDiskSpaceHandler() throws RemoteException {
            return IPCUtils.convertDiskSpaceHandlerToAidl(DownloadTask.this.getDiskSpaceHandler());
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadCompleteAidlHandler getDownloadCompleteAidlHandlerByIndex(int i10) throws RemoteException {
            return IPCUtils.convertDownloadCompleteHandlerToAidl(DownloadTask.this.getDownloadCompleteHandlerByIndex(i10));
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public int getDownloadCompleteHandlerSize() throws RemoteException {
            return DownloadTask.this.getDownloadCompleteHandlers().size();
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public DownloadInfo getDownloadInfo() throws RemoteException {
            return DownloadTask.this.getDownloadInfo();
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlListener getDownloadListenerByIndex(int i10, int i11) throws RemoteException {
            return IPCUtils.convertListenerToAidl(DownloadTask.this.getDownloadListenerByIndex(DownloadUtils.convertListenerType(i10), i11), i10 != ListenerType.SUB.ordinal());
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public int getDownloadListenerSize(int i10) throws RemoteException {
            return DownloadTask.this.getDownloadListenerSize(DownloadUtils.convertListenerType(i10));
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener() throws RemoteException {
            return IPCUtils.convertDownloadNotificationEventListenerToAidl(DownloadTask.this.getNotificationEventListener());
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlFileProvider getFileProvider() throws RemoteException {
            return IPCUtils.convertFileProviderToAidl(DownloadTask.this.getFileUriProvider());
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadForbiddenAidlHandler getForbiddenHandler() throws RemoteException {
            return IPCUtils.convertForbiddenHandlerToAidl(DownloadTask.this.getForbiddenHandler());
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlInterceptor getInterceptor() throws RemoteException {
            return IPCUtils.convertInterceptorToAidl(DownloadTask.this.getInterceptor());
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlMonitorDepend getMonitorDepend() throws RemoteException {
            return IPCUtils.convertMonitorDependToAidl(DownloadTask.this.getMonitorDepend());
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public INotificationClickAidlCallback getNotificationClickCallback() throws RemoteException {
            return IPCUtils.convertNotificationClickCallbackToAidl(DownloadTask.this.getNotificationClickCallback());
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IRetryDelayTimeAidlCalculator getRetryDelayTimeCalculator() throws RemoteException {
            return IPCUtils.convertRetryDelayTimeCalculatorToAidl(DownloadTask.this.getRetryDelayTimeCalculator());
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlListener getSingleDownloadListener(int i10) throws RemoteException {
            return IPCUtils.convertListenerToAidl(DownloadTask.this.getSingleDownloadListener(DownloadUtils.convertListenerType(i10)), i10 != ListenerType.SUB.ordinal());
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$10 */
    public static class AnonymousClass10 implements IDownloadDiskSpaceCallback {
        public AnonymousClass10() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback
        public void onDiskCleaned() {
            try {
                IDownloadDiskSpaceAidlCallback.this.onDiskCleaned();
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$11 */
    public static class AnonymousClass11 extends IDownloadAidlDepend.Stub {
        public AnonymousClass11() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend
        public void monitorLogSend(DownloadInfo downloadInfo, BaseException baseException, int i10) throws RemoteException {
            IDownloadDepend.this.monitorLogSend(downloadInfo, baseException, i10);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$12 */
    public static class AnonymousClass12 extends IDownloadAidlMonitorDepend.Stub {
        public AnonymousClass12() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend
        public int[] getAdditionalMonitorStatus() throws RemoteException {
            IDownloadMonitorDepend iDownloadMonitorDepend = IDownloadMonitorDepend.this;
            if (iDownloadMonitorDepend instanceof AbsDownloadMonitorDepend) {
                return ((AbsDownloadMonitorDepend) iDownloadMonitorDepend).getAdditionalMonitorStatus();
            }
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend
        public String getEventPage() throws RemoteException {
            return IDownloadMonitorDepend.this.getEventPage();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend
        public void monitorLogSend(String str) throws RemoteException {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                IDownloadMonitorDepend.this.monitorLogSend(new JSONObject(str));
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$13 */
    public static class AnonymousClass13 extends IChunkCntAidlCalculator.Stub {
        public AnonymousClass13() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator
        public int calculateChunkCount(long j10) throws RemoteException {
            return IChunkCntCalculator.this.calculateChunkCount(j10);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$14 */
    public static class AnonymousClass14 extends IDownloadAidlInterceptor.Stub {
        public AnonymousClass14() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor
        public boolean intercept() throws RemoteException {
            return IDownloadInterceptor.this.intercepte();
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$15 */
    public static class AnonymousClass15 implements IDownloadNotificationEventListener {
        public AnonymousClass15() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
        public String getNotifyProcessName() {
            try {
                return IDownloadNotificationEventAidlListener.this.getNotifyProcessName();
            } catch (RemoteException e10) {
                e10.printStackTrace();
                return null;
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
        public boolean interceptAfterNotificationSuccess(boolean z10) {
            try {
                return IDownloadNotificationEventAidlListener.this.interceptAfterNotificationSuccess(z10);
            } catch (RemoteException e10) {
                e10.printStackTrace();
                return false;
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
        public void onNotificationEvent(int i10, DownloadInfo downloadInfo, String str, String str2) {
            try {
                IDownloadNotificationEventAidlListener.this.onNotificationEvent(i10, downloadInfo, str, str2);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$16 */
    public static class AnonymousClass16 implements IDownloadCompleteHandler {
        public AnonymousClass16() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
        public void handle(DownloadInfo downloadInfo) throws BaseException {
            try {
                IDownloadCompleteAidlHandler.this.handle(downloadInfo);
            } catch (RemoteException e10) {
                throw new BaseException(1008, e10);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
        public boolean needHandle(DownloadInfo downloadInfo) {
            try {
                return IDownloadCompleteAidlHandler.this.needHandle(downloadInfo);
            } catch (RemoteException e10) {
                e10.printStackTrace();
                return false;
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$17 */
    public static class AnonymousClass17 extends IDownloadCompleteAidlHandler.Stub {
        public AnonymousClass17() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler
        public void handle(DownloadInfo downloadInfo) throws RemoteException {
            try {
                IDownloadCompleteHandler.this.handle(downloadInfo);
            } catch (BaseException e10) {
                throw new IllegalArgumentException(e10);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler
        public boolean needHandle(DownloadInfo downloadInfo) throws RemoteException {
            return IDownloadCompleteHandler.this.needHandle(downloadInfo);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$18 */
    public static class AnonymousClass18 implements INotificationClickCallback {
        public AnonymousClass18() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
        public boolean onClickWhenInstalled(DownloadInfo downloadInfo) {
            try {
                return INotificationClickAidlCallback.this.onClickWhenInstalled(downloadInfo);
            } catch (RemoteException e10) {
                e10.printStackTrace();
                return false;
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
        public boolean onClickWhenSuccess(DownloadInfo downloadInfo) {
            try {
                return INotificationClickAidlCallback.this.onClickWhenSuccess(downloadInfo);
            } catch (RemoteException e10) {
                e10.printStackTrace();
                return false;
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
        public boolean onClickWhenUnSuccess(DownloadInfo downloadInfo) {
            try {
                return INotificationClickAidlCallback.this.onClickWhenUnSuccess(downloadInfo);
            } catch (RemoteException e10) {
                e10.printStackTrace();
                return false;
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$19 */
    public static class AnonymousClass19 implements IChunkCntCalculator {
        public AnonymousClass19() {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator
        public int calculateChunkCount(long j10) {
            try {
                return IChunkCntAidlCalculator.this.calculateChunkCount(j10);
            } catch (RemoteException e10) {
                e10.printStackTrace();
                return 0;
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2 */
    public static class AnonymousClass2 extends IDownloadAidlListener.Stub {
        final /* synthetic */ boolean val$isInMainThread;

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$1 */
        public class AnonymousClass1 implements Runnable {
            final /* synthetic */ DownloadInfo val$entity;

            public AnonymousClass1(DownloadInfo downloadInfo) {
                downloadInfo = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                IDownloadListener.this.onPrepare(downloadInfo);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$10 */
        public class AnonymousClass10 implements Runnable {
            final /* synthetic */ BaseException val$e;
            final /* synthetic */ DownloadInfo val$entity;

            public AnonymousClass10(DownloadInfo downloadInfo, BaseException baseException) {
                downloadInfo = downloadInfo;
                baseException = baseException;
            }

            @Override // java.lang.Runnable
            public void run() {
                IDownloadListener.this.onRetry(downloadInfo, baseException);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$11 */
        public class AnonymousClass11 implements Runnable {
            final /* synthetic */ BaseException val$e;
            final /* synthetic */ DownloadInfo val$entity;

            public AnonymousClass11(DownloadInfo downloadInfo, BaseException baseException) {
                downloadInfo = downloadInfo;
                baseException = baseException;
            }

            @Override // java.lang.Runnable
            public void run() {
                IDownloadListener.this.onRetryDelay(downloadInfo, baseException);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$12 */
        public class AnonymousClass12 implements Runnable {
            final /* synthetic */ DownloadInfo val$entity;

            public AnonymousClass12(DownloadInfo downloadInfo) {
                downloadInfo = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                ((IDownloadExtListener) IDownloadListener.this).onWaitingDownloadCompleteHandler(downloadInfo);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$2 */
        public class RunnableC06522 implements Runnable {
            final /* synthetic */ DownloadInfo val$entity;

            public RunnableC06522(DownloadInfo downloadInfo) {
                downloadInfo = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                IDownloadListener.this.onStart(downloadInfo);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$3 */
        public class AnonymousClass3 implements Runnable {
            final /* synthetic */ DownloadInfo val$entity;

            public AnonymousClass3(DownloadInfo downloadInfo) {
                downloadInfo = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                IDownloadListener.this.onProgress(downloadInfo);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$4 */
        public class AnonymousClass4 implements Runnable {
            final /* synthetic */ DownloadInfo val$entity;

            public AnonymousClass4(DownloadInfo downloadInfo) {
                downloadInfo = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                IDownloadListener.this.onPause(downloadInfo);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$5 */
        public class AnonymousClass5 implements Runnable {
            final /* synthetic */ DownloadInfo val$entity;

            public AnonymousClass5(DownloadInfo downloadInfo) {
                downloadInfo = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                IDownloadListener.this.onSuccessed(downloadInfo);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$6 */
        public class AnonymousClass6 implements Runnable {
            final /* synthetic */ BaseException val$e;
            final /* synthetic */ DownloadInfo val$entity;

            public AnonymousClass6(DownloadInfo downloadInfo, BaseException baseException) {
                downloadInfo = downloadInfo;
                baseException = baseException;
            }

            @Override // java.lang.Runnable
            public void run() {
                IDownloadListener.this.onFailed(downloadInfo, baseException);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$7 */
        public class AnonymousClass7 implements Runnable {
            final /* synthetic */ DownloadInfo val$entity;

            public AnonymousClass7(DownloadInfo downloadInfo) {
                downloadInfo = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                IDownloadListener.this.onCanceled(downloadInfo);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$8 */
        public class AnonymousClass8 implements Runnable {
            final /* synthetic */ DownloadInfo val$entity;

            public AnonymousClass8(DownloadInfo downloadInfo) {
                downloadInfo = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                IDownloadListener.this.onFirstStart(downloadInfo);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$9 */
        public class AnonymousClass9 implements Runnable {
            final /* synthetic */ DownloadInfo val$entity;

            public AnonymousClass9(DownloadInfo downloadInfo) {
                downloadInfo = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                IDownloadListener.this.onFirstSuccess(downloadInfo);
            }
        }

        public AnonymousClass2(boolean z10) {
            z10 = z10;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public int getOriginHashCode() throws RemoteException {
            return IDownloadListener.this.hashCode();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onCanceled(DownloadInfo downloadInfo) throws RemoteException {
            if (z10) {
                IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.7
                    final /* synthetic */ DownloadInfo val$entity;

                    public AnonymousClass7(DownloadInfo downloadInfo2) {
                        downloadInfo = downloadInfo2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IDownloadListener.this.onCanceled(downloadInfo);
                    }
                });
            } else {
                IDownloadListener.this.onCanceled(downloadInfo2);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onFailed(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
            if (z10) {
                IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.6
                    final /* synthetic */ BaseException val$e;
                    final /* synthetic */ DownloadInfo val$entity;

                    public AnonymousClass6(DownloadInfo downloadInfo2, BaseException baseException2) {
                        downloadInfo = downloadInfo2;
                        baseException = baseException2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IDownloadListener.this.onFailed(downloadInfo, baseException);
                    }
                });
            } else {
                IDownloadListener.this.onFailed(downloadInfo2, baseException2);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onFirstStart(DownloadInfo downloadInfo) throws RemoteException {
            if (z10) {
                IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.8
                    final /* synthetic */ DownloadInfo val$entity;

                    public AnonymousClass8(DownloadInfo downloadInfo2) {
                        downloadInfo = downloadInfo2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IDownloadListener.this.onFirstStart(downloadInfo);
                    }
                });
            } else {
                IDownloadListener.this.onFirstStart(downloadInfo2);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onFirstSuccess(DownloadInfo downloadInfo) throws RemoteException {
            if (z10) {
                IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.9
                    final /* synthetic */ DownloadInfo val$entity;

                    public AnonymousClass9(DownloadInfo downloadInfo2) {
                        downloadInfo = downloadInfo2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IDownloadListener.this.onFirstSuccess(downloadInfo);
                    }
                });
            } else {
                IDownloadListener.this.onFirstSuccess(downloadInfo2);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onPause(DownloadInfo downloadInfo) throws RemoteException {
            if (z10) {
                IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.4
                    final /* synthetic */ DownloadInfo val$entity;

                    public AnonymousClass4(DownloadInfo downloadInfo2) {
                        downloadInfo = downloadInfo2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IDownloadListener.this.onPause(downloadInfo);
                    }
                });
            } else {
                IDownloadListener.this.onPause(downloadInfo2);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onPrepare(DownloadInfo downloadInfo) throws RemoteException {
            if (z10) {
                IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.1
                    final /* synthetic */ DownloadInfo val$entity;

                    public AnonymousClass1(DownloadInfo downloadInfo2) {
                        downloadInfo = downloadInfo2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IDownloadListener.this.onPrepare(downloadInfo);
                    }
                });
            } else {
                IDownloadListener.this.onPrepare(downloadInfo2);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onProgress(DownloadInfo downloadInfo) throws RemoteException {
            if (z10) {
                IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.3
                    final /* synthetic */ DownloadInfo val$entity;

                    public AnonymousClass3(DownloadInfo downloadInfo2) {
                        downloadInfo = downloadInfo2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IDownloadListener.this.onProgress(downloadInfo);
                    }
                });
            } else {
                IDownloadListener.this.onProgress(downloadInfo2);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onRetry(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
            if (z10) {
                IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.10
                    final /* synthetic */ BaseException val$e;
                    final /* synthetic */ DownloadInfo val$entity;

                    public AnonymousClass10(DownloadInfo downloadInfo2, BaseException baseException2) {
                        downloadInfo = downloadInfo2;
                        baseException = baseException2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IDownloadListener.this.onRetry(downloadInfo, baseException);
                    }
                });
            } else {
                IDownloadListener.this.onRetry(downloadInfo2, baseException2);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
            if (z10) {
                IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.11
                    final /* synthetic */ BaseException val$e;
                    final /* synthetic */ DownloadInfo val$entity;

                    public AnonymousClass11(DownloadInfo downloadInfo2, BaseException baseException2) {
                        downloadInfo = downloadInfo2;
                        baseException = baseException2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IDownloadListener.this.onRetryDelay(downloadInfo, baseException);
                    }
                });
            } else {
                IDownloadListener.this.onRetryDelay(downloadInfo2, baseException2);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onStart(DownloadInfo downloadInfo) throws RemoteException {
            if (z10) {
                IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.2
                    final /* synthetic */ DownloadInfo val$entity;

                    public RunnableC06522(DownloadInfo downloadInfo2) {
                        downloadInfo = downloadInfo2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IDownloadListener.this.onStart(downloadInfo);
                    }
                });
            } else {
                IDownloadListener.this.onStart(downloadInfo2);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onSuccessed(DownloadInfo downloadInfo) throws RemoteException {
            if (z10) {
                IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.5
                    final /* synthetic */ DownloadInfo val$entity;

                    public AnonymousClass5(DownloadInfo downloadInfo2) {
                        downloadInfo = downloadInfo2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IDownloadListener.this.onSuccessed(downloadInfo);
                    }
                });
            } else {
                IDownloadListener.this.onSuccessed(downloadInfo2);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onWaitingDownloadCompleteHandler(DownloadInfo downloadInfo) throws RemoteException {
            IDownloadListener iDownloadListener = IDownloadListener.this;
            if (iDownloadListener instanceof IDownloadExtListener) {
                if (z10) {
                    IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.12
                        final /* synthetic */ DownloadInfo val$entity;

                        public AnonymousClass12(DownloadInfo downloadInfo2) {
                            downloadInfo = downloadInfo2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            ((IDownloadExtListener) IDownloadListener.this).onWaitingDownloadCompleteHandler(downloadInfo);
                        }
                    });
                } else {
                    ((IDownloadExtListener) iDownloadListener).onWaitingDownloadCompleteHandler(downloadInfo2);
                }
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$20 */
    public static class AnonymousClass20 implements IDownloadDepend {
        public AnonymousClass20() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadDepend
        public void monitorLogSend(DownloadInfo downloadInfo, BaseException baseException, int i10) {
            if (downloadInfo == null) {
                return;
            }
            try {
                IDownloadAidlDepend.this.monitorLogSend(downloadInfo, baseException, i10);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$21 */
    public static class AnonymousClass21 extends AbsDownloadMonitorDepend {
        public AnonymousClass21() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadMonitorDepend
        public int[] getAdditionalMonitorStatus() {
            try {
                return IDownloadAidlMonitorDepend.this.getAdditionalMonitorStatus();
            } catch (RemoteException e10) {
                e10.printStackTrace();
                return null;
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend
        public String getEventPage() {
            try {
                return IDownloadAidlMonitorDepend.this.getEventPage();
            } catch (RemoteException e10) {
                e10.printStackTrace();
                return "";
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend
        public void monitorLogSend(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            try {
                IDownloadAidlMonitorDepend.this.monitorLogSend(jSONObject.toString());
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$22 */
    public static class AnonymousClass22 implements IDownloadForbiddenHandler {
        public AnonymousClass22() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler
        public boolean onForbidden(IDownloadForbiddenCallback iDownloadForbiddenCallback) {
            try {
                return IDownloadForbiddenAidlHandler.this.onForbidden(IPCUtils.convertForbiddenCallbackToAidl(iDownloadForbiddenCallback));
            } catch (RemoteException e10) {
                e10.printStackTrace();
                return false;
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$23 */
    public static class AnonymousClass23 extends IDownloadForbiddenAidlCallback.Stub {
        public AnonymousClass23() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback
        public boolean hasCallback() {
            return IDownloadForbiddenCallback.this.hasCallback();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback
        public void onCallback(List<String> list) {
            IDownloadForbiddenCallback.this.onCallback(list);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$24 */
    public static class AnonymousClass24 extends ProcessAidlCallback.Stub {
        public AnonymousClass24() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.ProcessAidlCallback
        public void callback(int i10, int i11) {
            ProcessCallback.this.callback(i10, i11);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$25 */
    public static class AnonymousClass25 implements ProcessCallback {
        public AnonymousClass25() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.ProcessCallback
        public void callback(int i10, int i11) {
            try {
                ProcessAidlCallback.this.callback(i10, i11);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$26 */
    public static class AnonymousClass26 implements IDownloadDiskSpaceHandler {
        public AnonymousClass26() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler
        public boolean cleanUpDisk(long j10, long j11, IDownloadDiskSpaceCallback iDownloadDiskSpaceCallback) {
            try {
                return IDownloadDiskSpaceAidlHandler.this.cleanUpDisk(j10, j11, IPCUtils.convertDiskSpaceCallbackToAidl(iDownloadDiskSpaceCallback));
            } catch (RemoteException e10) {
                e10.printStackTrace();
                return false;
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$27 */
    public static class AnonymousClass27 extends IDownloadDiskSpaceAidlCallback.Stub {
        public AnonymousClass27() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback
        public void onDiskCleaned() throws RemoteException {
            IDownloadDiskSpaceCallback.this.onDiskCleaned();
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$28 */
    public static class AnonymousClass28 implements IRetryDelayTimeCalculator {
        public AnonymousClass28() {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator
        public long calculateRetryDelayTime(int i10, int i11) {
            try {
                return IRetryDelayTimeAidlCalculator.this.calculateRetryDelayTime(i10, i11);
            } catch (RemoteException e10) {
                e10.printStackTrace();
                return 0L;
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$29 */
    public static class AnonymousClass29 implements IDownloadInterceptor {
        public AnonymousClass29() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadInterceptor
        public boolean intercepte() {
            try {
                return IDownloadAidlInterceptor.this.intercept();
            } catch (RemoteException e10) {
                e10.printStackTrace();
                return false;
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$3 */
    public static class AnonymousClass3 extends IDownloadNotificationEventAidlListener.Stub {
        public AnonymousClass3() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
        public String getNotifyProcessName() throws RemoteException {
            return IDownloadNotificationEventListener.this.getNotifyProcessName();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
        public boolean interceptAfterNotificationSuccess(boolean z10) throws RemoteException {
            return IDownloadNotificationEventListener.this.interceptAfterNotificationSuccess(z10);
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
        public void onNotificationEvent(int i10, DownloadInfo downloadInfo, String str, String str2) throws RemoteException {
            IDownloadNotificationEventListener.this.onNotificationEvent(i10, downloadInfo, str, str2);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$30 */
    public static class AnonymousClass30 implements IDownloadFileUriProvider {
        public AnonymousClass30() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
        public Uri getUriForFile(String str, String str2) {
            try {
                return IDownloadAidlFileProvider.this.getUriForFile(str, str2);
            } catch (RemoteException e10) {
                e10.printStackTrace();
                return null;
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$31 */
    public static class AnonymousClass31 implements IDownloadExtListener {
        public AnonymousClass31() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onCanceled(DownloadInfo downloadInfo) {
            try {
                IDownloadAidlListener.this.onCanceled(downloadInfo);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
            try {
                IDownloadAidlListener.this.onFailed(downloadInfo, baseException);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFirstStart(DownloadInfo downloadInfo) {
            try {
                IDownloadAidlListener.this.onFirstStart(downloadInfo);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFirstSuccess(DownloadInfo downloadInfo) {
            try {
                IDownloadAidlListener.this.onFirstSuccess(downloadInfo);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPause(DownloadInfo downloadInfo) {
            try {
                IDownloadAidlListener.this.onPause(downloadInfo);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPrepare(DownloadInfo downloadInfo) {
            try {
                IDownloadAidlListener.this.onPrepare(downloadInfo);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onProgress(DownloadInfo downloadInfo) {
            try {
                IDownloadAidlListener.this.onProgress(downloadInfo);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
            try {
                IDownloadAidlListener.this.onRetry(downloadInfo, baseException);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
            try {
                IDownloadAidlListener.this.onRetryDelay(downloadInfo, baseException);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onStart(DownloadInfo downloadInfo) {
            try {
                IDownloadAidlListener.this.onStart(downloadInfo);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onSuccessed(DownloadInfo downloadInfo) {
            try {
                IDownloadAidlListener.this.onSuccessed(downloadInfo);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadExtListener
        public void onWaitingDownloadCompleteHandler(DownloadInfo downloadInfo) {
            try {
                IDownloadAidlListener.this.onWaitingDownloadCompleteHandler(downloadInfo);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$4 */
    public static class AnonymousClass4 extends INotificationClickAidlCallback.Stub {
        public AnonymousClass4() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback
        public boolean onClickWhenInstalled(DownloadInfo downloadInfo) throws RemoteException {
            return INotificationClickCallback.this.onClickWhenInstalled(downloadInfo);
        }

        @Override // com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback
        public boolean onClickWhenSuccess(DownloadInfo downloadInfo) throws RemoteException {
            return INotificationClickCallback.this.onClickWhenSuccess(downloadInfo);
        }

        @Override // com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback
        public boolean onClickWhenUnSuccess(DownloadInfo downloadInfo) throws RemoteException {
            return INotificationClickCallback.this.onClickWhenUnSuccess(downloadInfo);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$5 */
    public static class AnonymousClass5 extends IRetryDelayTimeAidlCalculator.Stub {
        public AnonymousClass5() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator
        public long calculateRetryDelayTime(int i10, int i11) throws RemoteException {
            return IRetryDelayTimeCalculator.this.calculateRetryDelayTime(i10, i11);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$6 */
    public static class AnonymousClass6 extends IDownloadForbiddenAidlHandler.Stub {
        public AnonymousClass6() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler
        public boolean onForbidden(IDownloadForbiddenAidlCallback iDownloadForbiddenAidlCallback) throws RemoteException {
            return IDownloadForbiddenHandler.this.onForbidden(IPCUtils.convertForbiddenCallbackFromAidl(iDownloadForbiddenAidlCallback));
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$7 */
    public static class AnonymousClass7 extends IDownloadAidlFileProvider.Stub {
        public AnonymousClass7() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider
        public Uri getUriForFile(String str, String str2) throws RemoteException {
            return IDownloadFileUriProvider.this.getUriForFile(str, str2);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$8 */
    public static class AnonymousClass8 implements IDownloadForbiddenCallback {
        public AnonymousClass8() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback
        public boolean hasCallback() {
            try {
                return IDownloadForbiddenAidlCallback.this.hasCallback();
            } catch (RemoteException e10) {
                e10.printStackTrace();
                return false;
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback
        public void onCallback(List<String> list) {
            try {
                IDownloadForbiddenAidlCallback.this.onCallback(list);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$9 */
    public static class AnonymousClass9 extends IDownloadDiskSpaceAidlHandler.Stub {
        public AnonymousClass9() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler
        public boolean cleanUpDisk(long j10, long j11, IDownloadDiskSpaceAidlCallback iDownloadDiskSpaceAidlCallback) throws RemoteException {
            return IDownloadDiskSpaceHandler.this.cleanUpDisk(j10, j11, IPCUtils.convertDiskSpaceCallbackFromAidl(iDownloadDiskSpaceAidlCallback));
        }
    }

    public static IChunkCntCalculator convertCntCalculatorFromAidl(IChunkCntAidlCalculator iChunkCntAidlCalculator) {
        if (iChunkCntAidlCalculator == null) {
            return null;
        }
        return new IChunkCntCalculator() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.19
            public AnonymousClass19() {
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator
            public int calculateChunkCount(long j10) {
                try {
                    return IChunkCntAidlCalculator.this.calculateChunkCount(j10);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                    return 0;
                }
            }
        };
    }

    public static IChunkCntAidlCalculator convertCntCalculatorToAidl(IChunkCntCalculator iChunkCntCalculator) {
        if (iChunkCntCalculator == null) {
            return null;
        }
        return new IChunkCntAidlCalculator.Stub() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.13
            public AnonymousClass13() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator
            public int calculateChunkCount(long j10) throws RemoteException {
                return IChunkCntCalculator.this.calculateChunkCount(j10);
            }
        };
    }

    public static IDownloadAidlDepend convertDependToAidl(IDownloadDepend iDownloadDepend) {
        if (iDownloadDepend == null) {
            return null;
        }
        return new IDownloadAidlDepend.Stub() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.11
            public AnonymousClass11() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend
            public void monitorLogSend(DownloadInfo downloadInfo, BaseException baseException, int i10) throws RemoteException {
                IDownloadDepend.this.monitorLogSend(downloadInfo, baseException, i10);
            }
        };
    }

    public static IDownloadDiskSpaceCallback convertDiskSpaceCallbackFromAidl(IDownloadDiskSpaceAidlCallback iDownloadDiskSpaceAidlCallback) {
        if (iDownloadDiskSpaceAidlCallback == null) {
            return null;
        }
        return new IDownloadDiskSpaceCallback() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.10
            public AnonymousClass10() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback
            public void onDiskCleaned() {
                try {
                    IDownloadDiskSpaceAidlCallback.this.onDiskCleaned();
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }
        };
    }

    public static IDownloadDiskSpaceAidlCallback convertDiskSpaceCallbackToAidl(IDownloadDiskSpaceCallback iDownloadDiskSpaceCallback) {
        if (iDownloadDiskSpaceCallback == null) {
            return null;
        }
        return new IDownloadDiskSpaceAidlCallback.Stub() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.27
            public AnonymousClass27() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback
            public void onDiskCleaned() throws RemoteException {
                IDownloadDiskSpaceCallback.this.onDiskCleaned();
            }
        };
    }

    public static IDownloadDiskSpaceHandler convertDiskSpaceHandlerFromAidl(IDownloadDiskSpaceAidlHandler iDownloadDiskSpaceAidlHandler) {
        if (iDownloadDiskSpaceAidlHandler == null) {
            return null;
        }
        return new IDownloadDiskSpaceHandler() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.26
            public AnonymousClass26() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler
            public boolean cleanUpDisk(long j10, long j11, IDownloadDiskSpaceCallback iDownloadDiskSpaceCallback) {
                try {
                    return IDownloadDiskSpaceAidlHandler.this.cleanUpDisk(j10, j11, IPCUtils.convertDiskSpaceCallbackToAidl(iDownloadDiskSpaceCallback));
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static IDownloadDiskSpaceAidlHandler convertDiskSpaceHandlerToAidl(IDownloadDiskSpaceHandler iDownloadDiskSpaceHandler) {
        if (iDownloadDiskSpaceHandler == null) {
            return null;
        }
        return new IDownloadDiskSpaceAidlHandler.Stub() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.9
            public AnonymousClass9() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler
            public boolean cleanUpDisk(long j10, long j11, IDownloadDiskSpaceAidlCallback iDownloadDiskSpaceAidlCallback) throws RemoteException {
                return IDownloadDiskSpaceHandler.this.cleanUpDisk(j10, j11, IPCUtils.convertDiskSpaceCallbackFromAidl(iDownloadDiskSpaceAidlCallback));
            }
        };
    }

    public static IDownloadCompleteHandler convertDownloadCompleteHandlerFromAidl(IDownloadCompleteAidlHandler iDownloadCompleteAidlHandler) {
        if (iDownloadCompleteAidlHandler == null) {
            return null;
        }
        return new IDownloadCompleteHandler() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.16
            public AnonymousClass16() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
            public void handle(DownloadInfo downloadInfo) throws BaseException {
                try {
                    IDownloadCompleteAidlHandler.this.handle(downloadInfo);
                } catch (RemoteException e10) {
                    throw new BaseException(1008, e10);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
            public boolean needHandle(DownloadInfo downloadInfo) {
                try {
                    return IDownloadCompleteAidlHandler.this.needHandle(downloadInfo);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static IDownloadCompleteAidlHandler convertDownloadCompleteHandlerToAidl(IDownloadCompleteHandler iDownloadCompleteHandler) {
        if (iDownloadCompleteHandler == null) {
            return null;
        }
        return new IDownloadCompleteAidlHandler.Stub() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.17
            public AnonymousClass17() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler
            public void handle(DownloadInfo downloadInfo) throws RemoteException {
                try {
                    IDownloadCompleteHandler.this.handle(downloadInfo);
                } catch (BaseException e10) {
                    throw new IllegalArgumentException(e10);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler
            public boolean needHandle(DownloadInfo downloadInfo) throws RemoteException {
                return IDownloadCompleteHandler.this.needHandle(downloadInfo);
            }
        };
    }

    public static IDownloadDepend convertDownloadDependFromAidl(IDownloadAidlDepend iDownloadAidlDepend) {
        if (iDownloadAidlDepend == null) {
            return null;
        }
        return new IDownloadDepend() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.20
            public AnonymousClass20() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadDepend
            public void monitorLogSend(DownloadInfo downloadInfo, BaseException baseException, int i10) {
                if (downloadInfo == null) {
                    return;
                }
                try {
                    IDownloadAidlDepend.this.monitorLogSend(downloadInfo, baseException, i10);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }
        };
    }

    public static IDownloadMonitorDepend convertDownloadMonitorDependFromAidl(IDownloadAidlMonitorDepend iDownloadAidlMonitorDepend) {
        if (iDownloadAidlMonitorDepend == null) {
            return null;
        }
        return new AbsDownloadMonitorDepend() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.21
            public AnonymousClass21() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadMonitorDepend
            public int[] getAdditionalMonitorStatus() {
                try {
                    return IDownloadAidlMonitorDepend.this.getAdditionalMonitorStatus();
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                    return null;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend
            public String getEventPage() {
                try {
                    return IDownloadAidlMonitorDepend.this.getEventPage();
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                    return "";
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend
            public void monitorLogSend(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                try {
                    IDownloadAidlMonitorDepend.this.monitorLogSend(jSONObject.toString());
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }
        };
    }

    public static IDownloadNotificationEventListener convertDownloadNotificationEventListenerFromAidl(IDownloadNotificationEventAidlListener iDownloadNotificationEventAidlListener) {
        if (iDownloadNotificationEventAidlListener == null) {
            return null;
        }
        return new IDownloadNotificationEventListener() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.15
            public AnonymousClass15() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
            public String getNotifyProcessName() {
                try {
                    return IDownloadNotificationEventAidlListener.this.getNotifyProcessName();
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                    return null;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
            public boolean interceptAfterNotificationSuccess(boolean z10) {
                try {
                    return IDownloadNotificationEventAidlListener.this.interceptAfterNotificationSuccess(z10);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
            public void onNotificationEvent(int i10, DownloadInfo downloadInfo, String str, String str2) {
                try {
                    IDownloadNotificationEventAidlListener.this.onNotificationEvent(i10, downloadInfo, str, str2);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }
        };
    }

    public static IDownloadNotificationEventAidlListener convertDownloadNotificationEventListenerToAidl(IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        if (iDownloadNotificationEventListener == null) {
            return null;
        }
        return new IDownloadNotificationEventAidlListener.Stub() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.3
            public AnonymousClass3() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
            public String getNotifyProcessName() throws RemoteException {
                return IDownloadNotificationEventListener.this.getNotifyProcessName();
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
            public boolean interceptAfterNotificationSuccess(boolean z10) throws RemoteException {
                return IDownloadNotificationEventListener.this.interceptAfterNotificationSuccess(z10);
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
            public void onNotificationEvent(int i10, DownloadInfo downloadInfo, String str, String str2) throws RemoteException {
                IDownloadNotificationEventListener.this.onNotificationEvent(i10, downloadInfo, str, str2);
            }
        };
    }

    public static DownloadTask convertDownloadTaskFromAidl(DownloadAidlTask downloadAidlTask) {
        if (downloadAidlTask == null) {
            return null;
        }
        try {
            DownloadTask downloadTask = new DownloadTask(downloadAidlTask.getDownloadInfo());
            downloadTask.chunkStategy(convertCntCalculatorFromAidl(downloadAidlTask.getChunkStrategy())).notificationEventListener(convertDownloadNotificationEventListenerFromAidl(downloadAidlTask.getDownloadNotificationEventListener())).interceptor(convertInterceptorFromAidl(downloadAidlTask.getInterceptor())).depend(convertDownloadDependFromAidl(downloadAidlTask.getDepend())).monitorDepend(convertDownloadMonitorDependFromAidl(downloadAidlTask.getMonitorDepend())).forbiddenHandler(convertForbiddenHandlerFromAidl(downloadAidlTask.getForbiddenHandler())).diskSpaceHandler(convertDiskSpaceHandlerFromAidl(downloadAidlTask.getDiskSpaceHandler())).fileUriProvider(convertFileProviderFromAidl(downloadAidlTask.getFileProvider())).notificationClickCallback(convertNotificationClickCallbackFromAidl(downloadAidlTask.getNotificationClickCallback())).retryDelayTimeCalculator(convertRetryDelayTimeCalculatorFromAidl(downloadAidlTask.getRetryDelayTimeCalculator()));
            ListenerType listenerType = ListenerType.MAIN;
            IDownloadAidlListener singleDownloadListener = downloadAidlTask.getSingleDownloadListener(listenerType.ordinal());
            if (singleDownloadListener != null) {
                downloadTask.mainThreadListenerWithHashCode(singleDownloadListener.hashCode(), convertListenerFromAidl(singleDownloadListener));
            }
            ListenerType listenerType2 = ListenerType.SUB;
            IDownloadAidlListener singleDownloadListener2 = downloadAidlTask.getSingleDownloadListener(listenerType2.ordinal());
            if (singleDownloadListener2 != null) {
                downloadTask.subThreadListenerWithHashCode(singleDownloadListener2.hashCode(), convertListenerFromAidl(singleDownloadListener2));
            }
            ListenerType listenerType3 = ListenerType.NOTIFICATION;
            IDownloadAidlListener singleDownloadListener3 = downloadAidlTask.getSingleDownloadListener(listenerType3.ordinal());
            if (singleDownloadListener3 != null) {
                downloadTask.notificationListenerWithHashCode(singleDownloadListener3.hashCode(), convertListenerFromAidl(singleDownloadListener3));
            }
            setDownloadListeners(downloadTask, downloadAidlTask, listenerType);
            setDownloadListeners(downloadTask, downloadAidlTask, listenerType2);
            setDownloadListeners(downloadTask, downloadAidlTask, listenerType3);
            setCompletedHandlers(downloadTask, downloadAidlTask);
            return downloadTask;
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static DownloadAidlTask convertDownloadTaskToAidl(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        return new DownloadAidlTask.Stub() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.1
            public AnonymousClass1() {
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IChunkCntAidlCalculator getChunkStrategy() throws RemoteException {
                return IPCUtils.convertCntCalculatorToAidl(DownloadTask.this.getChunkStrategy());
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlDepend getDepend() throws RemoteException {
                return IPCUtils.convertDependToAidl(DownloadTask.this.getDepend());
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadDiskSpaceAidlHandler getDiskSpaceHandler() throws RemoteException {
                return IPCUtils.convertDiskSpaceHandlerToAidl(DownloadTask.this.getDiskSpaceHandler());
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadCompleteAidlHandler getDownloadCompleteAidlHandlerByIndex(int i10) throws RemoteException {
                return IPCUtils.convertDownloadCompleteHandlerToAidl(DownloadTask.this.getDownloadCompleteHandlerByIndex(i10));
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public int getDownloadCompleteHandlerSize() throws RemoteException {
                return DownloadTask.this.getDownloadCompleteHandlers().size();
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public DownloadInfo getDownloadInfo() throws RemoteException {
                return DownloadTask.this.getDownloadInfo();
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlListener getDownloadListenerByIndex(int i10, int i11) throws RemoteException {
                return IPCUtils.convertListenerToAidl(DownloadTask.this.getDownloadListenerByIndex(DownloadUtils.convertListenerType(i10), i11), i10 != ListenerType.SUB.ordinal());
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public int getDownloadListenerSize(int i10) throws RemoteException {
                return DownloadTask.this.getDownloadListenerSize(DownloadUtils.convertListenerType(i10));
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener() throws RemoteException {
                return IPCUtils.convertDownloadNotificationEventListenerToAidl(DownloadTask.this.getNotificationEventListener());
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlFileProvider getFileProvider() throws RemoteException {
                return IPCUtils.convertFileProviderToAidl(DownloadTask.this.getFileUriProvider());
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadForbiddenAidlHandler getForbiddenHandler() throws RemoteException {
                return IPCUtils.convertForbiddenHandlerToAidl(DownloadTask.this.getForbiddenHandler());
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlInterceptor getInterceptor() throws RemoteException {
                return IPCUtils.convertInterceptorToAidl(DownloadTask.this.getInterceptor());
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlMonitorDepend getMonitorDepend() throws RemoteException {
                return IPCUtils.convertMonitorDependToAidl(DownloadTask.this.getMonitorDepend());
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public INotificationClickAidlCallback getNotificationClickCallback() throws RemoteException {
                return IPCUtils.convertNotificationClickCallbackToAidl(DownloadTask.this.getNotificationClickCallback());
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IRetryDelayTimeAidlCalculator getRetryDelayTimeCalculator() throws RemoteException {
                return IPCUtils.convertRetryDelayTimeCalculatorToAidl(DownloadTask.this.getRetryDelayTimeCalculator());
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlListener getSingleDownloadListener(int i10) throws RemoteException {
                return IPCUtils.convertListenerToAidl(DownloadTask.this.getSingleDownloadListener(DownloadUtils.convertListenerType(i10)), i10 != ListenerType.SUB.ordinal());
            }
        };
    }

    public static IDownloadFileUriProvider convertFileProviderFromAidl(IDownloadAidlFileProvider iDownloadAidlFileProvider) {
        if (iDownloadAidlFileProvider == null) {
            return null;
        }
        return new IDownloadFileUriProvider() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.30
            public AnonymousClass30() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str, String str2) {
                try {
                    return IDownloadAidlFileProvider.this.getUriForFile(str, str2);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                    return null;
                }
            }
        };
    }

    public static IDownloadAidlFileProvider convertFileProviderToAidl(IDownloadFileUriProvider iDownloadFileUriProvider) {
        if (iDownloadFileUriProvider == null) {
            return null;
        }
        return new IDownloadAidlFileProvider.Stub() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.7
            public AnonymousClass7() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider
            public Uri getUriForFile(String str, String str2) throws RemoteException {
                return IDownloadFileUriProvider.this.getUriForFile(str, str2);
            }
        };
    }

    public static IDownloadForbiddenCallback convertForbiddenCallbackFromAidl(IDownloadForbiddenAidlCallback iDownloadForbiddenAidlCallback) {
        if (iDownloadForbiddenAidlCallback == null) {
            return null;
        }
        return new IDownloadForbiddenCallback() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.8
            public AnonymousClass8() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback
            public boolean hasCallback() {
                try {
                    return IDownloadForbiddenAidlCallback.this.hasCallback();
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback
            public void onCallback(List<String> list) {
                try {
                    IDownloadForbiddenAidlCallback.this.onCallback(list);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }
        };
    }

    public static IDownloadForbiddenAidlCallback convertForbiddenCallbackToAidl(IDownloadForbiddenCallback iDownloadForbiddenCallback) {
        if (iDownloadForbiddenCallback == null) {
            return null;
        }
        return new IDownloadForbiddenAidlCallback.Stub() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.23
            public AnonymousClass23() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback
            public boolean hasCallback() {
                return IDownloadForbiddenCallback.this.hasCallback();
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback
            public void onCallback(List<String> list) {
                IDownloadForbiddenCallback.this.onCallback(list);
            }
        };
    }

    public static IDownloadForbiddenHandler convertForbiddenHandlerFromAidl(IDownloadForbiddenAidlHandler iDownloadForbiddenAidlHandler) {
        if (iDownloadForbiddenAidlHandler == null) {
            return null;
        }
        return new IDownloadForbiddenHandler() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.22
            public AnonymousClass22() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler
            public boolean onForbidden(IDownloadForbiddenCallback iDownloadForbiddenCallback) {
                try {
                    return IDownloadForbiddenAidlHandler.this.onForbidden(IPCUtils.convertForbiddenCallbackToAidl(iDownloadForbiddenCallback));
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static IDownloadForbiddenAidlHandler convertForbiddenHandlerToAidl(IDownloadForbiddenHandler iDownloadForbiddenHandler) {
        if (iDownloadForbiddenHandler == null) {
            return null;
        }
        return new IDownloadForbiddenAidlHandler.Stub() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.6
            public AnonymousClass6() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler
            public boolean onForbidden(IDownloadForbiddenAidlCallback iDownloadForbiddenAidlCallback) throws RemoteException {
                return IDownloadForbiddenHandler.this.onForbidden(IPCUtils.convertForbiddenCallbackFromAidl(iDownloadForbiddenAidlCallback));
            }
        };
    }

    public static IDownloadInterceptor convertInterceptorFromAidl(IDownloadAidlInterceptor iDownloadAidlInterceptor) {
        if (iDownloadAidlInterceptor == null) {
            return null;
        }
        return new IDownloadInterceptor() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.29
            public AnonymousClass29() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadInterceptor
            public boolean intercepte() {
                try {
                    return IDownloadAidlInterceptor.this.intercept();
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static IDownloadAidlInterceptor convertInterceptorToAidl(IDownloadInterceptor iDownloadInterceptor) {
        if (iDownloadInterceptor == null) {
            return null;
        }
        return new IDownloadAidlInterceptor.Stub() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.14
            public AnonymousClass14() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor
            public boolean intercept() throws RemoteException {
                return IDownloadInterceptor.this.intercepte();
            }
        };
    }

    public static IDownloadListener convertListenerFromAidl(IDownloadAidlListener iDownloadAidlListener) {
        if (iDownloadAidlListener == null) {
            return null;
        }
        return new IDownloadExtListener() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.31
            public AnonymousClass31() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onCanceled(DownloadInfo downloadInfo) {
                try {
                    IDownloadAidlListener.this.onCanceled(downloadInfo);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    IDownloadAidlListener.this.onFailed(downloadInfo, baseException);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstStart(DownloadInfo downloadInfo) {
                try {
                    IDownloadAidlListener.this.onFirstStart(downloadInfo);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstSuccess(DownloadInfo downloadInfo) {
                try {
                    IDownloadAidlListener.this.onFirstSuccess(downloadInfo);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPause(DownloadInfo downloadInfo) {
                try {
                    IDownloadAidlListener.this.onPause(downloadInfo);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPrepare(DownloadInfo downloadInfo) {
                try {
                    IDownloadAidlListener.this.onPrepare(downloadInfo);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onProgress(DownloadInfo downloadInfo) {
                try {
                    IDownloadAidlListener.this.onProgress(downloadInfo);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    IDownloadAidlListener.this.onRetry(downloadInfo, baseException);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    IDownloadAidlListener.this.onRetryDelay(downloadInfo, baseException);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onStart(DownloadInfo downloadInfo) {
                try {
                    IDownloadAidlListener.this.onStart(downloadInfo);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onSuccessed(DownloadInfo downloadInfo) {
                try {
                    IDownloadAidlListener.this.onSuccessed(downloadInfo);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadExtListener
            public void onWaitingDownloadCompleteHandler(DownloadInfo downloadInfo) {
                try {
                    IDownloadAidlListener.this.onWaitingDownloadCompleteHandler(downloadInfo);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }
        };
    }

    public static IDownloadAidlListener convertListenerToAidl(IDownloadListener iDownloadListener, boolean z10) {
        if (iDownloadListener == null) {
            return null;
        }
        return new IDownloadAidlListener.Stub() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2
            final /* synthetic */ boolean val$isInMainThread;

            /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$1 */
            public class AnonymousClass1 implements Runnable {
                final /* synthetic */ DownloadInfo val$entity;

                public AnonymousClass1(DownloadInfo downloadInfo2) {
                    downloadInfo = downloadInfo2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    IDownloadListener.this.onPrepare(downloadInfo);
                }
            }

            /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$10 */
            public class AnonymousClass10 implements Runnable {
                final /* synthetic */ BaseException val$e;
                final /* synthetic */ DownloadInfo val$entity;

                public AnonymousClass10(DownloadInfo downloadInfo2, BaseException baseException2) {
                    downloadInfo = downloadInfo2;
                    baseException = baseException2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    IDownloadListener.this.onRetry(downloadInfo, baseException);
                }
            }

            /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$11 */
            public class AnonymousClass11 implements Runnable {
                final /* synthetic */ BaseException val$e;
                final /* synthetic */ DownloadInfo val$entity;

                public AnonymousClass11(DownloadInfo downloadInfo2, BaseException baseException2) {
                    downloadInfo = downloadInfo2;
                    baseException = baseException2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    IDownloadListener.this.onRetryDelay(downloadInfo, baseException);
                }
            }

            /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$12 */
            public class AnonymousClass12 implements Runnable {
                final /* synthetic */ DownloadInfo val$entity;

                public AnonymousClass12(DownloadInfo downloadInfo2) {
                    downloadInfo = downloadInfo2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ((IDownloadExtListener) IDownloadListener.this).onWaitingDownloadCompleteHandler(downloadInfo);
                }
            }

            /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$2 */
            public class RunnableC06522 implements Runnable {
                final /* synthetic */ DownloadInfo val$entity;

                public RunnableC06522(DownloadInfo downloadInfo2) {
                    downloadInfo = downloadInfo2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    IDownloadListener.this.onStart(downloadInfo);
                }
            }

            /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$3 */
            public class AnonymousClass3 implements Runnable {
                final /* synthetic */ DownloadInfo val$entity;

                public AnonymousClass3(DownloadInfo downloadInfo2) {
                    downloadInfo = downloadInfo2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    IDownloadListener.this.onProgress(downloadInfo);
                }
            }

            /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$4 */
            public class AnonymousClass4 implements Runnable {
                final /* synthetic */ DownloadInfo val$entity;

                public AnonymousClass4(DownloadInfo downloadInfo2) {
                    downloadInfo = downloadInfo2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    IDownloadListener.this.onPause(downloadInfo);
                }
            }

            /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$5 */
            public class AnonymousClass5 implements Runnable {
                final /* synthetic */ DownloadInfo val$entity;

                public AnonymousClass5(DownloadInfo downloadInfo2) {
                    downloadInfo = downloadInfo2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    IDownloadListener.this.onSuccessed(downloadInfo);
                }
            }

            /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$6 */
            public class AnonymousClass6 implements Runnable {
                final /* synthetic */ BaseException val$e;
                final /* synthetic */ DownloadInfo val$entity;

                public AnonymousClass6(DownloadInfo downloadInfo2, BaseException baseException2) {
                    downloadInfo = downloadInfo2;
                    baseException = baseException2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    IDownloadListener.this.onFailed(downloadInfo, baseException);
                }
            }

            /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$7 */
            public class AnonymousClass7 implements Runnable {
                final /* synthetic */ DownloadInfo val$entity;

                public AnonymousClass7(DownloadInfo downloadInfo2) {
                    downloadInfo = downloadInfo2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    IDownloadListener.this.onCanceled(downloadInfo);
                }
            }

            /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$8 */
            public class AnonymousClass8 implements Runnable {
                final /* synthetic */ DownloadInfo val$entity;

                public AnonymousClass8(DownloadInfo downloadInfo2) {
                    downloadInfo = downloadInfo2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    IDownloadListener.this.onFirstStart(downloadInfo);
                }
            }

            /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$9 */
            public class AnonymousClass9 implements Runnable {
                final /* synthetic */ DownloadInfo val$entity;

                public AnonymousClass9(DownloadInfo downloadInfo2) {
                    downloadInfo = downloadInfo2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    IDownloadListener.this.onFirstSuccess(downloadInfo);
                }
            }

            public AnonymousClass2(boolean z102) {
                z10 = z102;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public int getOriginHashCode() throws RemoteException {
                return IDownloadListener.this.hashCode();
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onCanceled(DownloadInfo downloadInfo2) throws RemoteException {
                if (z10) {
                    IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.7
                        final /* synthetic */ DownloadInfo val$entity;

                        public AnonymousClass7(DownloadInfo downloadInfo22) {
                            downloadInfo = downloadInfo22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onCanceled(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onCanceled(downloadInfo22);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onFailed(DownloadInfo downloadInfo2, BaseException baseException2) throws RemoteException {
                if (z10) {
                    IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.6
                        final /* synthetic */ BaseException val$e;
                        final /* synthetic */ DownloadInfo val$entity;

                        public AnonymousClass6(DownloadInfo downloadInfo22, BaseException baseException22) {
                            downloadInfo = downloadInfo22;
                            baseException = baseException22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onFailed(downloadInfo, baseException);
                        }
                    });
                } else {
                    IDownloadListener.this.onFailed(downloadInfo22, baseException22);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onFirstStart(DownloadInfo downloadInfo2) throws RemoteException {
                if (z10) {
                    IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.8
                        final /* synthetic */ DownloadInfo val$entity;

                        public AnonymousClass8(DownloadInfo downloadInfo22) {
                            downloadInfo = downloadInfo22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onFirstStart(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onFirstStart(downloadInfo22);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onFirstSuccess(DownloadInfo downloadInfo2) throws RemoteException {
                if (z10) {
                    IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.9
                        final /* synthetic */ DownloadInfo val$entity;

                        public AnonymousClass9(DownloadInfo downloadInfo22) {
                            downloadInfo = downloadInfo22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onFirstSuccess(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onFirstSuccess(downloadInfo22);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onPause(DownloadInfo downloadInfo2) throws RemoteException {
                if (z10) {
                    IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.4
                        final /* synthetic */ DownloadInfo val$entity;

                        public AnonymousClass4(DownloadInfo downloadInfo22) {
                            downloadInfo = downloadInfo22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onPause(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onPause(downloadInfo22);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onPrepare(DownloadInfo downloadInfo2) throws RemoteException {
                if (z10) {
                    IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.1
                        final /* synthetic */ DownloadInfo val$entity;

                        public AnonymousClass1(DownloadInfo downloadInfo22) {
                            downloadInfo = downloadInfo22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onPrepare(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onPrepare(downloadInfo22);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onProgress(DownloadInfo downloadInfo2) throws RemoteException {
                if (z10) {
                    IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.3
                        final /* synthetic */ DownloadInfo val$entity;

                        public AnonymousClass3(DownloadInfo downloadInfo22) {
                            downloadInfo = downloadInfo22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onProgress(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onProgress(downloadInfo22);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onRetry(DownloadInfo downloadInfo2, BaseException baseException2) throws RemoteException {
                if (z10) {
                    IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.10
                        final /* synthetic */ BaseException val$e;
                        final /* synthetic */ DownloadInfo val$entity;

                        public AnonymousClass10(DownloadInfo downloadInfo22, BaseException baseException22) {
                            downloadInfo = downloadInfo22;
                            baseException = baseException22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onRetry(downloadInfo, baseException);
                        }
                    });
                } else {
                    IDownloadListener.this.onRetry(downloadInfo22, baseException22);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onRetryDelay(DownloadInfo downloadInfo2, BaseException baseException2) throws RemoteException {
                if (z10) {
                    IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.11
                        final /* synthetic */ BaseException val$e;
                        final /* synthetic */ DownloadInfo val$entity;

                        public AnonymousClass11(DownloadInfo downloadInfo22, BaseException baseException22) {
                            downloadInfo = downloadInfo22;
                            baseException = baseException22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onRetryDelay(downloadInfo, baseException);
                        }
                    });
                } else {
                    IDownloadListener.this.onRetryDelay(downloadInfo22, baseException22);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onStart(DownloadInfo downloadInfo2) throws RemoteException {
                if (z10) {
                    IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.2
                        final /* synthetic */ DownloadInfo val$entity;

                        public RunnableC06522(DownloadInfo downloadInfo22) {
                            downloadInfo = downloadInfo22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onStart(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onStart(downloadInfo22);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onSuccessed(DownloadInfo downloadInfo2) throws RemoteException {
                if (z10) {
                    IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.5
                        final /* synthetic */ DownloadInfo val$entity;

                        public AnonymousClass5(DownloadInfo downloadInfo22) {
                            downloadInfo = downloadInfo22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onSuccessed(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onSuccessed(downloadInfo22);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onWaitingDownloadCompleteHandler(DownloadInfo downloadInfo2) throws RemoteException {
                IDownloadListener iDownloadListener2 = IDownloadListener.this;
                if (iDownloadListener2 instanceof IDownloadExtListener) {
                    if (z10) {
                        IPCUtils.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.2.12
                            final /* synthetic */ DownloadInfo val$entity;

                            public AnonymousClass12(DownloadInfo downloadInfo22) {
                                downloadInfo = downloadInfo22;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                ((IDownloadExtListener) IDownloadListener.this).onWaitingDownloadCompleteHandler(downloadInfo);
                            }
                        });
                    } else {
                        ((IDownloadExtListener) iDownloadListener2).onWaitingDownloadCompleteHandler(downloadInfo22);
                    }
                }
            }
        };
    }

    public static IDownloadAidlMonitorDepend convertMonitorDependToAidl(IDownloadMonitorDepend iDownloadMonitorDepend) {
        if (iDownloadMonitorDepend == null) {
            return null;
        }
        return new IDownloadAidlMonitorDepend.Stub() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.12
            public AnonymousClass12() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend
            public int[] getAdditionalMonitorStatus() throws RemoteException {
                IDownloadMonitorDepend iDownloadMonitorDepend2 = IDownloadMonitorDepend.this;
                if (iDownloadMonitorDepend2 instanceof AbsDownloadMonitorDepend) {
                    return ((AbsDownloadMonitorDepend) iDownloadMonitorDepend2).getAdditionalMonitorStatus();
                }
                return null;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend
            public String getEventPage() throws RemoteException {
                return IDownloadMonitorDepend.this.getEventPage();
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend
            public void monitorLogSend(String str) throws RemoteException {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    IDownloadMonitorDepend.this.monitorLogSend(new JSONObject(str));
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
            }
        };
    }

    public static INotificationClickCallback convertNotificationClickCallbackFromAidl(INotificationClickAidlCallback iNotificationClickAidlCallback) {
        if (iNotificationClickAidlCallback == null) {
            return null;
        }
        return new INotificationClickCallback() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.18
            public AnonymousClass18() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
            public boolean onClickWhenInstalled(DownloadInfo downloadInfo) {
                try {
                    return INotificationClickAidlCallback.this.onClickWhenInstalled(downloadInfo);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
            public boolean onClickWhenSuccess(DownloadInfo downloadInfo) {
                try {
                    return INotificationClickAidlCallback.this.onClickWhenSuccess(downloadInfo);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
            public boolean onClickWhenUnSuccess(DownloadInfo downloadInfo) {
                try {
                    return INotificationClickAidlCallback.this.onClickWhenUnSuccess(downloadInfo);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static INotificationClickAidlCallback convertNotificationClickCallbackToAidl(INotificationClickCallback iNotificationClickCallback) {
        if (iNotificationClickCallback == null) {
            return null;
        }
        return new INotificationClickAidlCallback.Stub() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.4
            public AnonymousClass4() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback
            public boolean onClickWhenInstalled(DownloadInfo downloadInfo) throws RemoteException {
                return INotificationClickCallback.this.onClickWhenInstalled(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback
            public boolean onClickWhenSuccess(DownloadInfo downloadInfo) throws RemoteException {
                return INotificationClickCallback.this.onClickWhenSuccess(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback
            public boolean onClickWhenUnSuccess(DownloadInfo downloadInfo) throws RemoteException {
                return INotificationClickCallback.this.onClickWhenUnSuccess(downloadInfo);
            }
        };
    }

    public static ProcessCallback convertProcessAidlCallbackFromAidl(ProcessAidlCallback processAidlCallback) {
        if (processAidlCallback == null) {
            return null;
        }
        return new ProcessCallback() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.25
            public AnonymousClass25() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.ProcessCallback
            public void callback(int i10, int i11) {
                try {
                    ProcessAidlCallback.this.callback(i10, i11);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }
        };
    }

    public static ProcessAidlCallback convertProcessCallbackToAidl(ProcessCallback processCallback) {
        if (processCallback == null) {
            return null;
        }
        return new ProcessAidlCallback.Stub() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.24
            public AnonymousClass24() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.ProcessAidlCallback
            public void callback(int i10, int i11) {
                ProcessCallback.this.callback(i10, i11);
            }
        };
    }

    public static IRetryDelayTimeCalculator convertRetryDelayTimeCalculatorFromAidl(IRetryDelayTimeAidlCalculator iRetryDelayTimeAidlCalculator) {
        if (iRetryDelayTimeAidlCalculator == null) {
            return null;
        }
        return new IRetryDelayTimeCalculator() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.28
            public AnonymousClass28() {
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator
            public long calculateRetryDelayTime(int i10, int i11) {
                try {
                    return IRetryDelayTimeAidlCalculator.this.calculateRetryDelayTime(i10, i11);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                    return 0L;
                }
            }
        };
    }

    public static IRetryDelayTimeAidlCalculator convertRetryDelayTimeCalculatorToAidl(IRetryDelayTimeCalculator iRetryDelayTimeCalculator) {
        if (iRetryDelayTimeCalculator == null) {
            return null;
        }
        return new IRetryDelayTimeAidlCalculator.Stub() { // from class: com.ss.android.socialbase.downloader.utils.IPCUtils.5
            public AnonymousClass5() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator
            public long calculateRetryDelayTime(int i10, int i11) throws RemoteException {
                return IRetryDelayTimeCalculator.this.calculateRetryDelayTime(i10, i11);
            }
        };
    }

    private static void setCompletedHandlers(DownloadTask downloadTask, DownloadAidlTask downloadAidlTask) throws RemoteException {
        for (int i10 = 0; i10 < downloadAidlTask.getDownloadCompleteHandlerSize(); i10++) {
            IDownloadCompleteAidlHandler downloadCompleteAidlHandlerByIndex = downloadAidlTask.getDownloadCompleteAidlHandlerByIndex(i10);
            if (downloadCompleteAidlHandlerByIndex != null) {
                downloadTask.addDownloadCompleteHandler(convertDownloadCompleteHandlerFromAidl(downloadCompleteAidlHandlerByIndex));
            }
        }
    }

    private static void setDownloadListeners(DownloadTask downloadTask, DownloadAidlTask downloadAidlTask, ListenerType listenerType) throws RemoteException {
        SparseArray<IDownloadListener> sparseArray = new SparseArray<>();
        for (int i10 = 0; i10 < downloadAidlTask.getDownloadListenerSize(listenerType.ordinal()); i10++) {
            IDownloadAidlListener downloadListenerByIndex = downloadAidlTask.getDownloadListenerByIndex(listenerType.ordinal(), i10);
            if (downloadListenerByIndex != null) {
                sparseArray.put(downloadListenerByIndex.getOriginHashCode(), convertListenerFromAidl(downloadListenerByIndex));
            }
        }
        downloadTask.setDownloadListeners(sparseArray, listenerType);
    }
}
