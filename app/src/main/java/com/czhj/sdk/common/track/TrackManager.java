package com.czhj.sdk.common.track;

import android.os.Handler;
import com.czhj.sdk.common.ThreadPool.RepeatingHandlerRunnable;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.SigmobRequestQueue;
import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.track.TrackingRequest;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.VolleyError;
import java.util.List;

/* loaded from: classes2.dex */
public class TrackManager {
    private static final int MAX_PARALLELS_NUM = 4;
    private static final TrackManager gInstance = new TrackManager();
    private static final int maxRetryNum = 20;
    private Listener mSigmobTrackListener;
    private Listener mToBidTrackListener;
    private RepeatingHandlerRunnable repeatingHandlerRunnable;
    private Handler retryHandler;
    private volatile int retryIndex;
    private List<AdTracker> trackers;
    private long retryExpiredTime = 180000;
    private long retryInterval = 10000;

    /* renamed from: com.czhj.sdk.common.track.TrackManager$1 */
    public class AnonymousClass1 implements Listener {
        final /* synthetic */ Listener val$listener;

        /* renamed from: com.czhj.sdk.common.track.TrackManager$1$1 */
        public class RunnableC02511 implements Runnable {
            public RunnableC02511() {
            }

            @Override // java.lang.Runnable
            public void run() {
                TrackManager.this.sendRetryTracking();
            }
        }

        /* renamed from: com.czhj.sdk.common.track.TrackManager$1$2 */
        public class AnonymousClass2 implements Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                TrackManager.this.sendRetryTracking();
            }
        }

        public AnonymousClass1(Listener listener) {
            listener = listener;
        }

        @Override // com.czhj.sdk.common.track.TrackManager.Listener
        public void onErrorResponse(AdTracker adTracker, VolleyError volleyError) {
            Listener listener = listener;
            if (listener != null) {
                listener.onErrorResponse(adTracker, volleyError);
            }
            TrackManager.this.retryHandler.post(new Runnable() { // from class: com.czhj.sdk.common.track.TrackManager.1.2
                public AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    TrackManager.this.sendRetryTracking();
                }
            });
        }

        @Override // com.czhj.sdk.common.track.TrackManager.Listener
        public void onSuccess(AdTracker adTracker, NetworkResponse networkResponse) {
            Listener listener = listener;
            if (listener != null) {
                listener.onSuccess(adTracker, networkResponse);
            }
            TrackManager.this.retryHandler.post(new Runnable() { // from class: com.czhj.sdk.common.track.TrackManager.1.1
                public RunnableC02511() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    TrackManager.this.sendRetryTracking();
                }
            });
        }
    }

    /* renamed from: com.czhj.sdk.common.track.TrackManager$2 */
    public class AnonymousClass2 implements TrackingRequest.RequestListener {
        final /* synthetic */ boolean val$inQueue;
        final /* synthetic */ boolean val$isRetrySend;
        final /* synthetic */ Listener val$listener;
        final /* synthetic */ AdTracker val$tracker;

        /* renamed from: com.czhj.sdk.common.track.TrackManager$2$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                adTracker.deleteDB();
            }
        }

        /* renamed from: com.czhj.sdk.common.track.TrackManager$2$2 */
        public class RunnableC02522 implements Runnable {
            public RunnableC02522() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                boolean z10 = z12;
                AdTracker adTracker = adTracker;
                if (!z10) {
                    adTracker.insertToDB(null);
                    return;
                }
                adTracker.setRetryCountInc();
                if (adTracker.getRetryCount() >= 20) {
                    adTracker.deleteDB();
                } else {
                    adTracker.updateToDB();
                }
            }
        }

        public AnonymousClass2(boolean z10, AdTracker adTracker, Listener listener, boolean z11) {
            z12 = z10;
            adTracker = adTracker;
            listener = listener;
            z11 = z11;
        }

        @Override // com.czhj.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            NetworkResponse networkResponse = volleyError.networkResponse;
            if (z11 && (adTracker.getRetryNum().intValue() > 0 || z12)) {
                ThreadPoolFactory.MainThreadRun(new Runnable() { // from class: com.czhj.sdk.common.track.TrackManager.2.2
                    public RunnableC02522() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        boolean z10 = z12;
                        AdTracker adTracker = adTracker;
                        if (!z10) {
                            adTracker.insertToDB(null);
                            return;
                        }
                        adTracker.setRetryCountInc();
                        if (adTracker.getRetryCount() >= 20) {
                            adTracker.deleteDB();
                        } else {
                            adTracker.updateToDB();
                        }
                    }
                });
            }
            Listener listener = listener;
            if (listener != null) {
                listener.onErrorResponse(adTracker, volleyError);
            }
            SigmobLog.e(volleyError.getMessage());
        }

        @Override // com.czhj.sdk.common.track.TrackingRequest.RequestListener
        public void onSuccess(NetworkResponse networkResponse) {
            if (z12) {
                ThreadPoolFactory.MainThreadRun(new Runnable() { // from class: com.czhj.sdk.common.track.TrackManager.2.1
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        adTracker.deleteDB();
                    }
                });
            }
            Listener listener = listener;
            if (listener != null) {
                listener.onSuccess(adTracker, networkResponse);
            }
        }
    }

    /* renamed from: com.czhj.sdk.common.track.TrackManager$3 */
    public class AnonymousClass3 extends RepeatingHandlerRunnable {
        public AnonymousClass3(Handler handler) {
            super(handler);
        }

        @Override // com.czhj.sdk.common.ThreadPool.RepeatingHandlerRunnable
        public void doWork() {
            try {
                TrackManager.this.retryFailTracking();
                TrackManager.this.repeatingHandlerRunnable.startRepeating(TrackManager.this.retryInterval);
            } catch (Throwable th2) {
                SigmobLog.e("retryFaildTracking error " + th2.getMessage());
            }
        }
    }

    public interface Listener {
        void onErrorResponse(AdTracker adTracker, VolleyError volleyError);

        void onSuccess(AdTracker adTracker, NetworkResponse networkResponse);
    }

    private TrackManager() {
    }

    public static TrackManager getInstance() {
        return gInstance;
    }

    public void retryFailTracking() {
        this.retryHandler.removeCallbacksAndMessages(null);
        AdTracker.cleanLimitAdTracker(3000L);
        this.trackers = AdTracker.getAdTrackerFromDB(3000, this.retryExpiredTime);
        this.retryIndex = 0;
        int size = this.trackers.size();
        if (size > 4) {
            size = 4;
        }
        for (int i10 = 0; i10 < size; i10++) {
            sendRetryTracking();
        }
        AdTracker.cleanExpiredAdTracker(this.retryExpiredTime);
    }

    public void sendRetryTracking() {
        if (this.trackers == null || this.retryIndex >= this.trackers.size()) {
            return;
        }
        List<AdTracker> list = this.trackers;
        int i10 = this.retryIndex;
        this.retryIndex = i10 + 1;
        AdTracker adTracker = list.get(i10);
        Listener listener = adTracker.getMessageType().equals(AdTracker.MessageType.TRACKING_URL) ? this.mSigmobTrackListener : this.mToBidTrackListener;
        if (listener == null) {
            return;
        }
        sendTracking(adTracker, null, false, true, new Listener() { // from class: com.czhj.sdk.common.track.TrackManager.1
            final /* synthetic */ Listener val$listener;

            /* renamed from: com.czhj.sdk.common.track.TrackManager$1$1 */
            public class RunnableC02511 implements Runnable {
                public RunnableC02511() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    TrackManager.this.sendRetryTracking();
                }
            }

            /* renamed from: com.czhj.sdk.common.track.TrackManager$1$2 */
            public class AnonymousClass2 implements Runnable {
                public AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    TrackManager.this.sendRetryTracking();
                }
            }

            public AnonymousClass1(Listener listener2) {
                listener = listener2;
            }

            @Override // com.czhj.sdk.common.track.TrackManager.Listener
            public void onErrorResponse(AdTracker adTracker2, VolleyError volleyError) {
                Listener listener2 = listener;
                if (listener2 != null) {
                    listener2.onErrorResponse(adTracker2, volleyError);
                }
                TrackManager.this.retryHandler.post(new Runnable() { // from class: com.czhj.sdk.common.track.TrackManager.1.2
                    public AnonymousClass2() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        TrackManager.this.sendRetryTracking();
                    }
                });
            }

            @Override // com.czhj.sdk.common.track.TrackManager.Listener
            public void onSuccess(AdTracker adTracker2, NetworkResponse networkResponse) {
                Listener listener2 = listener;
                if (listener2 != null) {
                    listener2.onSuccess(adTracker2, networkResponse);
                }
                TrackManager.this.retryHandler.post(new Runnable() { // from class: com.czhj.sdk.common.track.TrackManager.1.1
                    public RunnableC02511() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        TrackManager.this.sendRetryTracking();
                    }
                });
            }
        });
    }

    public static void sendTracking(AdTracker adTracker, BaseMacroCommon baseMacroCommon, boolean z10, boolean z11, Listener listener) {
        if (adTracker == null || adTracker.getMessageType() == AdTracker.MessageType.QUARTILE_EVENT) {
            return;
        }
        if (!adTracker.isTracked() || z10) {
            String url = adTracker.getUrl();
            if (baseMacroCommon != null) {
                url = baseMacroCommon.macroProcess(url);
            }
            if (!z10) {
                adTracker.setTracked();
            }
            boolean z12 = adTracker.getId() != null;
            adTracker.setUrl(url);
            TrackingRequest trackingRequest = new TrackingRequest(url, z12 ? 0 : adTracker.getRetryNum().intValue(), new TrackingRequest.RequestListener() { // from class: com.czhj.sdk.common.track.TrackManager.2
                final /* synthetic */ boolean val$inQueue;
                final /* synthetic */ boolean val$isRetrySend;
                final /* synthetic */ Listener val$listener;
                final /* synthetic */ AdTracker val$tracker;

                /* renamed from: com.czhj.sdk.common.track.TrackManager$2$1 */
                public class AnonymousClass1 implements Runnable {
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        adTracker.deleteDB();
                    }
                }

                /* renamed from: com.czhj.sdk.common.track.TrackManager$2$2 */
                public class RunnableC02522 implements Runnable {
                    public RunnableC02522() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        boolean z10 = z12;
                        AdTracker adTracker = adTracker;
                        if (!z10) {
                            adTracker.insertToDB(null);
                            return;
                        }
                        adTracker.setRetryCountInc();
                        if (adTracker.getRetryCount() >= 20) {
                            adTracker.deleteDB();
                        } else {
                            adTracker.updateToDB();
                        }
                    }
                }

                public AnonymousClass2(boolean z122, AdTracker adTracker2, Listener listener2, boolean z112) {
                    z12 = z122;
                    adTracker = adTracker2;
                    listener = listener2;
                    z11 = z112;
                }

                @Override // com.czhj.volley.Response.ErrorListener
                public void onErrorResponse(VolleyError volleyError) {
                    NetworkResponse networkResponse = volleyError.networkResponse;
                    if (z11 && (adTracker.getRetryNum().intValue() > 0 || z12)) {
                        ThreadPoolFactory.MainThreadRun(new Runnable() { // from class: com.czhj.sdk.common.track.TrackManager.2.2
                            public RunnableC02522() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                boolean z102 = z12;
                                AdTracker adTracker2 = adTracker;
                                if (!z102) {
                                    adTracker2.insertToDB(null);
                                    return;
                                }
                                adTracker2.setRetryCountInc();
                                if (adTracker.getRetryCount() >= 20) {
                                    adTracker.deleteDB();
                                } else {
                                    adTracker.updateToDB();
                                }
                            }
                        });
                    }
                    Listener listener2 = listener;
                    if (listener2 != null) {
                        listener2.onErrorResponse(adTracker, volleyError);
                    }
                    SigmobLog.e(volleyError.getMessage());
                }

                @Override // com.czhj.sdk.common.track.TrackingRequest.RequestListener
                public void onSuccess(NetworkResponse networkResponse) {
                    if (z12) {
                        ThreadPoolFactory.MainThreadRun(new Runnable() { // from class: com.czhj.sdk.common.track.TrackManager.2.1
                            public AnonymousClass1() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                adTracker.deleteDB();
                            }
                        });
                    }
                    Listener listener2 = listener;
                    if (listener2 != null) {
                        listener2.onSuccess(adTracker, networkResponse);
                    }
                }
            });
            SigmobRequestQueue commonRequestQueue = Networking.getCommonRequestQueue();
            SigmobRequestQueue adTrackerRetryQueue = Networking.getAdTrackerRetryQueue();
            if (commonRequestQueue == null && adTrackerRetryQueue == null) {
                SigmobLog.e("RequestQueue is null");
                return;
            }
            if (!z122 ? commonRequestQueue == null : adTrackerRetryQueue != null) {
                commonRequestQueue = adTrackerRetryQueue;
            }
            commonRequestQueue.add(trackingRequest);
        }
    }

    public void setRetryExpiredTime(long j10) {
        this.retryExpiredTime = j10 * 1000;
    }

    public void setRetryInterval(long j10) {
        this.retryInterval = j10 * 1000;
    }

    public void setSigmobTrackListener(Listener listener) {
        this.mSigmobTrackListener = listener;
    }

    public void setToBidTrackListener(Listener listener) {
        this.mToBidTrackListener = listener;
    }

    public void startRetryTracking() {
        if (this.repeatingHandlerRunnable != null) {
            return;
        }
        Handler handler = new Handler(ThreadPoolFactory.BackgroundThreadPool.getInstance().getIOLooper());
        this.retryHandler = handler;
        AnonymousClass3 anonymousClass3 = new RepeatingHandlerRunnable(handler) { // from class: com.czhj.sdk.common.track.TrackManager.3
            public AnonymousClass3(Handler handler2) {
                super(handler2);
            }

            @Override // com.czhj.sdk.common.ThreadPool.RepeatingHandlerRunnable
            public void doWork() {
                try {
                    TrackManager.this.retryFailTracking();
                    TrackManager.this.repeatingHandlerRunnable.startRepeating(TrackManager.this.retryInterval);
                } catch (Throwable th2) {
                    SigmobLog.e("retryFaildTracking error " + th2.getMessage());
                }
            }
        };
        this.repeatingHandlerRunnable = anonymousClass3;
        anonymousClass3.startRepeating(this.retryInterval);
    }
}
