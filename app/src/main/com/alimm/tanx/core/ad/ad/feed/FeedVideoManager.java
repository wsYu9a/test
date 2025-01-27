package com.alimm.tanx.core.ad.ad.feed;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.alimm.tanx.core.TanxCoreManager;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ad.listener.bean.NewTrackItem;
import com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback;
import com.alimm.tanx.core.ad.monitor.tanxc_for;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.request.TanxPlayerError;
import com.alimm.tanx.core.ut.impl.TanxRewardUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NetWorkUtil;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.PlayerListManager;
import com.alimm.tanx.core.utils.TanxCountDownTimer;
import com.alimm.tanx.core.utils.VideoCacheManager;
import com.alimm.tanx.core.view.feed.ITanxFeedCacheContext;
import com.alimm.tanx.core.view.player.VideoScaleMode;
import com.alimm.tanx.core.view.player.cache.VideoGetSizeManager;
import com.alimm.tanx.core.view.player.core.ITanxPlayer;
import com.alimm.tanx.core.view.player.core.OnVideoBufferingListener;
import com.alimm.tanx.core.view.player.core.OnVideoErrorListener;
import com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener;
import com.alimm.tanx.core.view.player.core.PlayerBufferingState;
import com.alimm.tanx.core.view.player.core.PlayerState;
import com.alimm.tanx.core.view.player.ui.TanxPlayerView;
import com.sigmob.sdk.downloader.core.download.g;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class FeedVideoManager implements ITanxVideoView, NotConfused, ITanxFeedCacheContext {
    private static final String TAG = "FeedVideoManager";
    private final ITanxFeedAd iTanxFeedAd;
    private ITanxFeedVideoAdListener iTanxFeedVideoAdListener;
    private ITanxFeedVideoMonitorCallback iTanxFeedVideoMonitorCallback;
    private ITanxPlayer player;
    private volatile TanxCountDownTimer tanxCountDownTimer;
    private final com.alimm.tanx.core.view.feed.tanxc_do tanxFeedVideoViewCache;
    private TanxVideoView tanxVideoView;
    private int duration = 0;
    private int nowCurrentCount = 0;
    private boolean nowViewAttach = false;
    private final long defaultVideoSize = g.f19256f;
    private boolean isPlayed = false;
    private boolean nowMute = false;
    private volatile boolean isShow = false;
    private volatile boolean video3SReportCompleted = false;

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager$1 */
    public class AnonymousClass1 implements ITanxFeedVideoMonitorCallback {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback
        public void attach() {
            LogUtils.d(FeedVideoManager.TAG, "attach() sessionId:" + FeedVideoManager.this.getSessionId());
            FeedVideoManager.this.startPlay(true);
            FeedVideoManager.this.iTanxFeedVideoAdListener.onVideoLoad(FeedVideoManager.this.iTanxFeedAd);
            FeedVideoManager.this.nowViewAttach = true;
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback
        public void detached() {
            try {
                FeedVideoManager.this.isShow = false;
                FeedVideoManager.this.nowViewAttach = false;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("detached:");
                sb2.append((FeedVideoManager.this.tanxVideoView == null || FeedVideoManager.this.tanxVideoView.getState() == null) ? "tanxVideoView为空" : FeedVideoManager.this.tanxVideoView.getState().name());
                sb2.append(" sessionId:");
                sb2.append(FeedVideoManager.this.getSessionId());
                LogUtils.d(FeedVideoManager.TAG, sb2.toString());
                FeedVideoManager.this.stop();
                FeedVideoManager.this.iTanxFeedVideoMonitorCallback = null;
            } catch (Exception e10) {
                LogUtils.e(e10);
            }
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
        public void exposure() {
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
        public void exposureTime(long j10) {
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
        public void onMonitor(Map<String, Object> map) {
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback
        public void remove() {
            LogUtils.d(FeedVideoManager.TAG, "remove() sessionId:" + FeedVideoManager.this.getSessionId());
            FeedVideoManager.this.isShow = false;
            FeedVideoManager.this.stop();
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback
        public void show() {
            LogUtils.d(FeedVideoManager.TAG, "show() sessionId:" + FeedVideoManager.this.getSessionId());
            FeedVideoManager.this.isShow = true;
            FeedVideoManager.this.startPlay(true);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager$2 */
    public class AnonymousClass2 implements OnVideoStateChangeListener {
        final /* synthetic */ com.alimm.tanx.core.ad.monitor.tanxc_do tanxc_do;

        public AnonymousClass2(com.alimm.tanx.core.ad.monitor.tanxc_do tanxc_doVar) {
            tanxc_forVar = tanxc_doVar;
        }

        @Override // com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener
        public void onStateChange(ITanxPlayer iTanxPlayer, PlayerState playerState) {
            LogUtils.d(FeedVideoManager.TAG, "onStateChange state " + playerState.name() + " url:" + iTanxPlayer.getUrl() + "  adMonitor.getAttachedWindow():" + tanxc_forVar.tanxc_goto() + ", isAttach:" + FeedVideoManager.this.isAttach());
            FeedVideoManager.this.initState(playerState);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager$3 */
    public class AnonymousClass3 implements OnVideoBufferingListener {
        public AnonymousClass3() {
        }

        @Override // com.alimm.tanx.core.view.player.core.OnVideoBufferingListener
        public void OnBufferStateChanged(PlayerBufferingState playerBufferingState) {
            LogUtils.d(FeedVideoManager.TAG, "OnBufferStateChanged()");
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager$4 */
    public class AnonymousClass4 implements OnVideoErrorListener {
        public AnonymousClass4() {
        }

        @Override // com.alimm.tanx.core.view.player.core.OnVideoErrorListener
        public boolean onError(ITanxPlayer iTanxPlayer, TanxPlayerError tanxPlayerError) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onError() e:");
            sb2.append(tanxPlayerError.getMessage());
            LogUtils.d(FeedVideoManager.TAG, sb2.toString() != null ? tanxPlayerError.getMessage() : "");
            FeedVideoManager.this.iTanxFeedVideoAdListener.onVideoError(tanxPlayerError);
            TanxRewardUt.utViewDraw(FeedVideoManager.this.iTanxFeedAd, 0);
            return false;
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager$5 */
    public class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedVideoManager.this.play();
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager$6 */
    public class AnonymousClass6 extends TanxCountDownTimer {
        public AnonymousClass6(long j10, long j11) {
            super(j10, j11);
        }

        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
        public void onFinish() {
            try {
                if (FeedVideoManager.this.iTanxFeedAd.getAdSlot().getVideoParam().looping) {
                    LogUtils.d(FeedVideoManager.TAG, "onFinish - tanxVideoView.getState()：" + FeedVideoManager.this.tanxVideoView.getState());
                    FeedVideoManager feedVideoManager = FeedVideoManager.this;
                    feedVideoManager.initState(feedVideoManager.tanxVideoView.getState());
                }
            } catch (Exception e10) {
                LogUtils.e(e10);
            }
            LogUtils.d(FeedVideoManager.TAG, "initVideoProgress - onFinish");
        }

        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
        public void onTick(long j10) {
            if (FeedVideoManager.this.tanxVideoView != null && FeedVideoManager.this.tanxVideoView.getState() != PlayerState.STARTED) {
                FeedVideoManager.this.stopVideoProgress();
            }
            FeedVideoManager.this.correctTimer(Long.valueOf(j10), FeedVideoManager.this.tanxVideoView);
            FeedVideoManager.this.nowCurrentCount = Math.round(j10 / 1000.0f);
            int round = Math.round(FeedVideoManager.this.duration / 1000.0f);
            long j11 = round;
            FeedVideoManager.this.iTanxFeedVideoAdListener.onProgressUpdate(FeedVideoManager.this.nowCurrentCount, j11);
            FeedVideoManager.this.exposeVideo3s(r1.nowCurrentCount, j11);
            LogUtils.d(FeedVideoManager.TAG, "initVideoProgress nowCurrentCount：" + FeedVideoManager.this.nowCurrentCount + " duration：" + round + " millisUntilFinished:" + j10);
            if (round - FeedVideoManager.this.nowCurrentCount > 1) {
                FeedVideoManager.this.isPlayed = true;
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager$7 */
    public static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] tanxc_do;

        static {
            int[] iArr = new int[PlayerState.values().length];
            tanxc_do = iArr;
            try {
                iArr[PlayerState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                tanxc_do[PlayerState.PREPARED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                tanxc_do[PlayerState.PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public FeedVideoManager(ITanxFeedAd iTanxFeedAd, com.alimm.tanx.core.view.feed.tanxc_do tanxc_doVar, Context context) {
        this.tanxFeedVideoViewCache = tanxc_doVar;
        this.iTanxFeedAd = iTanxFeedAd;
        initVideoView(context);
        LogUtils.d(TAG, iTanxFeedAd.getBidInfo().getCreativeItem().getVideo());
    }

    private void autoPlayCheck() {
        LogUtils.d(TAG, "autoPlayCheck");
        if (this.isPlayed) {
            LogUtils.d(TAG, "autoPlayCheck 续播");
            playItem(true);
            return;
        }
        if (this.iTanxFeedAd.getAdSlot().getVideoParam() != null && this.iTanxFeedAd.getAdSlot().getVideoParam().mute) {
            mute();
        }
        if (this.iTanxFeedAd.getAdSlot().isNotAutoPlay()) {
            LogUtils.d(TAG, "媒体设置不自动播放");
            playItem(false);
            return;
        }
        if (!this.iTanxFeedAd.getAdSlot().isPlayUnderWifi()) {
            LogUtils.d(TAG, "autoPlayCheck 媒体没设置直接起播");
            playItem(true);
            return;
        }
        LogUtils.d(TAG, "媒体设置wifi下自动播放 NetworkType" + NetWorkUtil.getNetworkType(TanxCoreSdk.getApplication()).getKey());
        if (NetWorkUtil.getNetworkType(TanxCoreSdk.getApplication()).getKey() == 1) {
            playItem(true);
            return;
        }
        LogUtils.d(TAG, "当前非wifi环境只准备，不自动播放");
        this.player.setPlayWhenReady(false);
        playItem(false);
    }

    private void callBackAndSetUi(PlayerState playerState) {
        if (this.tanxVideoView != null) {
            PlayerState playerState2 = PlayerState.STARTED;
            if (playerState == playerState2) {
                this.iTanxFeedVideoAdListener.onVideoAdStartPlay(this.iTanxFeedAd);
            } else if (playerState == PlayerState.PAUSED || playerState == PlayerState.STOPPED) {
                this.iTanxFeedVideoAdListener.onVideoAdPaused(this.iTanxFeedAd);
            } else if (playerState == PlayerState.COMPLETED || playerState == PlayerState.END) {
                this.iTanxFeedVideoAdListener.onVideoComplete();
            }
            if (playerState == PlayerState.IDLE || playerState == PlayerState.INITIALIZED || playerState == PlayerState.ERROR || playerState == PlayerState.PAUSED || playerState == PlayerState.STOPPED) {
                this.tanxVideoView.setPauseType();
                return;
            }
            if (playerState == PlayerState.PREPARING) {
                this.tanxVideoView.setLoadingType();
                return;
            }
            if (playerState == PlayerState.COMPLETED || playerState == PlayerState.END || playerState == playerState2) {
                this.tanxVideoView.setPlayType();
                return;
            }
            if (playerState == PlayerState.PREPARED) {
                LogUtils.d(TAG, "onStateChangeTest " + this.player.getState().name());
                ITanxPlayer iTanxPlayer = this.player;
                if (iTanxPlayer == null || iTanxPlayer.getState() == playerState2) {
                    return;
                }
                this.tanxVideoView.setPauseType();
            }
        }
    }

    private void cancelVideoProgress() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("cancelVideoProgress played:");
        TanxVideoView tanxVideoView = this.tanxVideoView;
        sb2.append(tanxVideoView != null ? tanxVideoView.getState().name() : "");
        LogUtils.d(TAG, sb2.toString());
        try {
            if (this.tanxCountDownTimer != null) {
                this.tanxCountDownTimer.cancel();
                this.tanxCountDownTimer = null;
            }
        } catch (Exception e10) {
            LogUtils.e(TAG, "cancelVideoProgress", e10);
        }
    }

    public void correctTimer(Long l10, TanxVideoView tanxVideoView) {
        int round;
        if (tanxVideoView != null) {
            if (l10 == null) {
                if (tanxVideoView.getDuration() - tanxVideoView.getCurrentPosition() <= 0 || this.tanxCountDownTimer == null) {
                    return;
                }
                this.tanxCountDownTimer.updateTime(tanxVideoView.getDuration() - tanxVideoView.getCurrentPosition());
                this.tanxCountDownTimer.resume();
                return;
            }
            int round2 = Math.round(l10.longValue() / 1000.0f);
            if (tanxVideoView.getCurrentPosition() <= 0 || (round = Math.round((tanxVideoView.getDuration() - tanxVideoView.getCurrentPosition()) / 1000.0f)) <= 1 || Math.abs(round - round2) <= 1 || this.tanxCountDownTimer == null) {
                return;
            }
            this.tanxCountDownTimer.updateTime(tanxVideoView.getDuration() - tanxVideoView.getCurrentPosition());
            this.tanxCountDownTimer.resume();
        }
    }

    public void exposeVideo3s(long j10, long j11) {
        ITanxFeedAd iTanxFeedAd;
        try {
            if (this.video3SReportCompleted || (iTanxFeedAd = this.iTanxFeedAd) == null || iTanxFeedAd.getBidInfo() == null || this.iTanxFeedAd.getBidInfo().getEventTrack() == null) {
                return;
            }
            LogUtils.d(TAG, "exposeVideo3s start current:" + j10 + " duration:" + j11);
            BidInfo bidInfo = this.iTanxFeedAd.getBidInfo();
            ArrayList arrayList = new ArrayList();
            if (bidInfo != null && bidInfo.getEventTrack() != null && bidInfo.getEventTrack().size() > 0) {
                for (int i10 = 0; i10 < bidInfo.getEventTrack().size(); i10++) {
                    NewTrackItem newTrackItem = bidInfo.getEventTrack().get(i10);
                    if (newTrackItem != null && newTrackItem.getType() == 2 && newTrackItem.getTime() != -1) {
                        int i11 = (int) (j11 - j10);
                        LogUtils.d(TAG, "exposeVideo3s startTime:" + i11 + " newTrackItem.getTime():" + newTrackItem.getTime());
                        if (i11 == newTrackItem.getTime()) {
                            arrayList.addAll(bidInfo.getEventTrack().get(i10).getUrl());
                        }
                    }
                }
            }
            if (arrayList.size() <= 0) {
                LogUtils.d(TAG, "exposeVideo3s urls 为空，不调用上报");
            } else {
                ExposeManager.tanxc_do().tanxc_do(bidInfo, this.iTanxFeedAd.getAdSlot().getReqId(), this.iTanxFeedAd.getAdSlot().getPid(), arrayList);
                this.video3SReportCompleted = true;
            }
        } catch (Exception e10) {
            LogUtils.e(TAG, e10);
        }
    }

    private TanxPlayerView getVideoView() {
        try {
            if (this.tanxVideoView == null) {
                initVideoView(TanxCoreSdk.getApplication());
            }
            this.tanxVideoView.setiTanxFeedVideoAdListener(this.iTanxFeedVideoAdListener);
        } catch (Exception e10) {
            LogUtils.d(TAG, "getVideoView()-" + LogUtils.getStackTraceMessage(e10));
            TanxRewardUt.utViewDraw(this.iTanxFeedAd, 0);
        }
        return this.tanxVideoView;
    }

    public void initState(PlayerState playerState) {
        playCheck(playerState);
        setVideoProgress(playerState, false);
        callBackAndSetUi(playerState);
    }

    private void initVideoProgress() {
        try {
            if (this.tanxCountDownTimer != null) {
                return;
            }
            TanxVideoView tanxVideoView = this.tanxVideoView;
            if (tanxVideoView != null) {
                this.duration = tanxVideoView.getDuration();
            }
            LogUtils.d(TAG, "initVideoProgress duration" + this.duration + "");
            if (this.tanxCountDownTimer == null) {
                this.tanxCountDownTimer = new TanxCountDownTimer(this.duration, 1000L) { // from class: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.6
                    public AnonymousClass6(long j10, long j11) {
                        super(j10, j11);
                    }

                    @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                    public void onFinish() {
                        try {
                            if (FeedVideoManager.this.iTanxFeedAd.getAdSlot().getVideoParam().looping) {
                                LogUtils.d(FeedVideoManager.TAG, "onFinish - tanxVideoView.getState()：" + FeedVideoManager.this.tanxVideoView.getState());
                                FeedVideoManager feedVideoManager = FeedVideoManager.this;
                                feedVideoManager.initState(feedVideoManager.tanxVideoView.getState());
                            }
                        } catch (Exception e10) {
                            LogUtils.e(e10);
                        }
                        LogUtils.d(FeedVideoManager.TAG, "initVideoProgress - onFinish");
                    }

                    @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                    public void onTick(long j10) {
                        if (FeedVideoManager.this.tanxVideoView != null && FeedVideoManager.this.tanxVideoView.getState() != PlayerState.STARTED) {
                            FeedVideoManager.this.stopVideoProgress();
                        }
                        FeedVideoManager.this.correctTimer(Long.valueOf(j10), FeedVideoManager.this.tanxVideoView);
                        FeedVideoManager.this.nowCurrentCount = Math.round(j10 / 1000.0f);
                        int round = Math.round(FeedVideoManager.this.duration / 1000.0f);
                        long j11 = round;
                        FeedVideoManager.this.iTanxFeedVideoAdListener.onProgressUpdate(FeedVideoManager.this.nowCurrentCount, j11);
                        FeedVideoManager.this.exposeVideo3s(r1.nowCurrentCount, j11);
                        LogUtils.d(FeedVideoManager.TAG, "initVideoProgress nowCurrentCount：" + FeedVideoManager.this.nowCurrentCount + " duration：" + round + " millisUntilFinished:" + j10);
                        if (round - FeedVideoManager.this.nowCurrentCount > 1) {
                            FeedVideoManager.this.isPlayed = true;
                        }
                    }
                };
            }
        } catch (Exception e10) {
            LogUtils.e(TAG, "initVideoProgress", e10);
        }
    }

    private void initVideoView(Context context) {
        try {
            TanxVideoView tanxc_do = this.tanxFeedVideoViewCache.tanxc_do(this, context);
            this.tanxVideoView = tanxc_do;
            tanxc_do.setTanxAd(this.iTanxFeedAd);
            ITanxPlayer create = TanxCoreManager.getInstance().getTanxCoreInstanceConfig().getTanxPlayer().create();
            this.player = create;
            create.setLooping(this.iTanxFeedAd.getAdSlot().getVideoParam().looping);
            AnonymousClass1 anonymousClass1 = new ITanxFeedVideoMonitorCallback() { // from class: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.1
                public AnonymousClass1() {
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback
                public void attach() {
                    LogUtils.d(FeedVideoManager.TAG, "attach() sessionId:" + FeedVideoManager.this.getSessionId());
                    FeedVideoManager.this.startPlay(true);
                    FeedVideoManager.this.iTanxFeedVideoAdListener.onVideoLoad(FeedVideoManager.this.iTanxFeedAd);
                    FeedVideoManager.this.nowViewAttach = true;
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback
                public void detached() {
                    try {
                        FeedVideoManager.this.isShow = false;
                        FeedVideoManager.this.nowViewAttach = false;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("detached:");
                        sb2.append((FeedVideoManager.this.tanxVideoView == null || FeedVideoManager.this.tanxVideoView.getState() == null) ? "tanxVideoView为空" : FeedVideoManager.this.tanxVideoView.getState().name());
                        sb2.append(" sessionId:");
                        sb2.append(FeedVideoManager.this.getSessionId());
                        LogUtils.d(FeedVideoManager.TAG, sb2.toString());
                        FeedVideoManager.this.stop();
                        FeedVideoManager.this.iTanxFeedVideoMonitorCallback = null;
                    } catch (Exception e10) {
                        LogUtils.e(e10);
                    }
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
                public void exposure() {
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
                public void exposureTime(long j10) {
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
                public void onMonitor(Map<String, Object> map) {
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback
                public void remove() {
                    LogUtils.d(FeedVideoManager.TAG, "remove() sessionId:" + FeedVideoManager.this.getSessionId());
                    FeedVideoManager.this.isShow = false;
                    FeedVideoManager.this.stop();
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback
                public void show() {
                    LogUtils.d(FeedVideoManager.TAG, "show() sessionId:" + FeedVideoManager.this.getSessionId());
                    FeedVideoManager.this.isShow = true;
                    FeedVideoManager.this.startPlay(true);
                }
            };
            this.iTanxFeedVideoMonitorCallback = anonymousClass1;
            tanxc_for tanxc_forVar = new tanxc_for(this.tanxVideoView, anonymousClass1);
            this.tanxVideoView.setAdMonitor(tanxc_forVar);
            this.tanxVideoView.setOnVideoStateChangeListener(new OnVideoStateChangeListener() { // from class: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.2
                final /* synthetic */ com.alimm.tanx.core.ad.monitor.tanxc_do tanxc_do;

                public AnonymousClass2(com.alimm.tanx.core.ad.monitor.tanxc_do tanxc_forVar2) {
                    tanxc_forVar = tanxc_forVar2;
                }

                @Override // com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener
                public void onStateChange(ITanxPlayer iTanxPlayer, PlayerState playerState) {
                    LogUtils.d(FeedVideoManager.TAG, "onStateChange state " + playerState.name() + " url:" + iTanxPlayer.getUrl() + "  adMonitor.getAttachedWindow():" + tanxc_forVar.tanxc_goto() + ", isAttach:" + FeedVideoManager.this.isAttach());
                    FeedVideoManager.this.initState(playerState);
                }
            });
            this.tanxVideoView.setOnVideoBufferingListener(new OnVideoBufferingListener() { // from class: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.3
                public AnonymousClass3() {
                }

                @Override // com.alimm.tanx.core.view.player.core.OnVideoBufferingListener
                public void OnBufferStateChanged(PlayerBufferingState playerBufferingState) {
                    LogUtils.d(FeedVideoManager.TAG, "OnBufferStateChanged()");
                }
            });
            this.tanxVideoView.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.4
                public AnonymousClass4() {
                }

                @Override // com.alimm.tanx.core.view.player.core.OnVideoErrorListener
                public boolean onError(ITanxPlayer iTanxPlayer, TanxPlayerError tanxPlayerError) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onError() e:");
                    sb2.append(tanxPlayerError.getMessage());
                    LogUtils.d(FeedVideoManager.TAG, sb2.toString() != null ? tanxPlayerError.getMessage() : "");
                    FeedVideoManager.this.iTanxFeedVideoAdListener.onVideoError(tanxPlayerError);
                    TanxRewardUt.utViewDraw(FeedVideoManager.this.iTanxFeedAd, 0);
                    return false;
                }
            });
            this.tanxVideoView.setPlayClickListener(new View.OnClickListener() { // from class: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.5
                public AnonymousClass5() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FeedVideoManager.this.play();
                }
            });
        } catch (Exception e10) {
            LogUtils.d(TAG, "initVideoView()-" + LogUtils.getStackTraceMessage(e10));
            TanxRewardUt.utViewDraw(this.iTanxFeedAd, 0);
        }
    }

    public boolean isAttach() {
        TanxVideoView tanxVideoView = this.tanxVideoView;
        return (tanxVideoView == null || tanxVideoView.getWindowToken() == null) ? false : true;
    }

    private void playCheck(PlayerState playerState) {
        if (!playerState.equals(PlayerState.STARTED) || this.nowViewAttach) {
            return;
        }
        stop();
    }

    private void playItem(boolean z10) {
        LogUtils.d(TAG, "playItem");
        if (this.tanxVideoView != null) {
            LogUtils.d(TAG, "playItem isIdle:" + this.tanxVideoView.getState() + "， isStart:" + z10 + "， isShow:" + this.isShow);
            int i10 = AnonymousClass7.tanxc_do[this.tanxVideoView.getState().ordinal()];
            if (i10 == 1) {
                if (!z10 || !this.isShow) {
                    this.player.setPlayWhenReady(false);
                }
                this.tanxVideoView.prepare();
            } else if (i10 == 2 || i10 == 3) {
                this.tanxVideoView.showCoverView(true);
            } else {
                LogUtils.d(TAG, "playItem default");
                this.tanxVideoView.showCoverView(false);
            }
            if (z10 && this.isShow) {
                LogUtils.d(TAG, "先暂停所有视频，再起播当前视频 当前sessionId:" + getSessionId());
                PlayerListManager.getInstance().stopOtherPlayer(this.iTanxFeedAd);
                this.player.setPlayWhenReady(true);
                this.tanxVideoView.prepare();
                LogUtils.d(TAG, "暂停完成，开始起播 tanxVideoView.getState()：" + this.tanxVideoView.getState());
                this.tanxVideoView.start();
            }
        }
    }

    private void setVideoProgress(PlayerState playerState, boolean z10) {
        if (playerState == PlayerState.STARTED) {
            startVideoProgress(z10);
        } else {
            stopVideoProgress();
        }
    }

    public void startPlay(boolean z10) {
        LogUtils.d(TAG, "startPlay fromAttach：" + z10);
        if (!videoSizeCheck(this.iTanxFeedAd)) {
            LogUtils.e(TAG, "视频体积超限");
            this.iTanxFeedVideoAdListener.onError(new TanxError(this.iTanxFeedAd.getRequestId(), "视频超限"));
            return;
        }
        if (this.tanxVideoView != null) {
            LogUtils.d(TAG, "startPlay tanxVideoView.getState()：" + this.tanxVideoView.getState().name());
            if (this.tanxVideoView.getState().equals(PlayerState.COMPLETED)) {
                return;
            }
            if (this.tanxVideoView.getState().equals(PlayerState.ERROR)) {
                this.tanxVideoView.reset();
            }
            if (this.tanxVideoView.getState().equals(PlayerState.IDLE)) {
                this.tanxVideoView.setTanxPlayer(this.player);
                this.tanxVideoView.setDataSource(this.iTanxFeedAd.getBidInfo().getCreativeItem().getVideo());
                this.tanxVideoView.setVideoScaleMode(VideoScaleMode.FIT_CENTER);
                this.tanxVideoView.setCover(this.iTanxFeedAd.getBidInfo().getCreativeItem().getImageUrl());
                if (z10) {
                    autoPlayCheck();
                } else {
                    playItem(true);
                }
            } else if (z10) {
                autoPlayCheck();
            } else {
                playItem(true);
            }
            this.iTanxFeedAd.onResourceLoadSuccess();
        }
    }

    private synchronized void startVideoProgress(boolean z10) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("startVideoProgress played:");
            TanxVideoView tanxVideoView = this.tanxVideoView;
            sb2.append(tanxVideoView != null ? tanxVideoView.getState().name() : "");
            LogUtils.d(TAG, sb2.toString());
            try {
                initVideoProgress();
                if (this.tanxCountDownTimer.isPaused() && this.tanxVideoView.getState() == PlayerState.STARTED) {
                    correctTimer(null, this.tanxVideoView);
                } else {
                    ITanxFeedAd iTanxFeedAd = this.iTanxFeedAd;
                    if (iTanxFeedAd == null || iTanxFeedAd.getAdSlot() == null || this.iTanxFeedAd.getAdSlot().getVideoParam() == null || !((this.iTanxFeedAd.getAdSlot().getVideoParam().looping || z10) && this.tanxCountDownTimer.getNowType() == 4)) {
                        this.tanxCountDownTimer.start();
                    } else {
                        this.tanxCountDownTimer.updateTime(this.tanxVideoView.getDuration() - this.tanxVideoView.getCurrentPosition());
                        this.tanxCountDownTimer.finishReStart();
                    }
                }
            } catch (Exception e10) {
                LogUtils.e(TAG, "startVideoProgress", e10);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void stop() {
        LogUtils.d(TAG, "stop()");
        TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView == null || tanxVideoView.getState() == null) {
            LogUtils.d(TAG, "stop() tanxVideoView 为空或者tanxVideoView.getState()为空");
            return;
        }
        if (!this.tanxVideoView.getState().equals(PlayerState.COMPLETED)) {
            this.tanxVideoView.stop();
            stopVideoProgress();
        } else {
            LogUtils.d(TAG, "stop() getState()不是COMPLETED，tanxVideoView.getState()：" + this.tanxVideoView.getState().name());
        }
    }

    public void stopVideoProgress() {
        TanxVideoView tanxVideoView;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("stopVideoProgress played:");
        TanxVideoView tanxVideoView2 = this.tanxVideoView;
        sb2.append(tanxVideoView2 != null ? tanxVideoView2.getState().name() : "");
        LogUtils.d(TAG, sb2.toString());
        try {
            if (this.tanxCountDownTimer == null || (tanxVideoView = this.tanxVideoView) == null || tanxVideoView.getState() == PlayerState.STARTED) {
                return;
            }
            this.tanxCountDownTimer.pause();
        } catch (Exception e10) {
            LogUtils.e(TAG, "startVideoProgress", e10);
        }
    }

    private boolean videoSizeCheck(ITanxFeedAd iTanxFeedAd) {
        Long l10;
        if (iTanxFeedAd == null || iTanxFeedAd.getBidInfo() == null || iTanxFeedAd.getBidInfo().getCreativeItem() == null || TextUtils.isEmpty(iTanxFeedAd.getBidInfo().getCreativeItem().getVideo())) {
            return true;
        }
        LinkedHashMap<String, Long> linkedHashMap = VideoGetSizeManager.mCachedVideoSizeMap;
        long j10 = 0;
        if (linkedHashMap != null && (l10 = linkedHashMap.get(iTanxFeedAd.getBidInfo().getCreativeItem().getVideo())) != null) {
            j10 = l10.longValue();
        }
        return j10 <= ((OrangeManager.getInstance().getThreshold(OrangeManager.FEED_VIDEO_MAX_SIZE) > (-1L) ? 1 : (OrangeManager.getInstance().getThreshold(OrangeManager.FEED_VIDEO_MAX_SIZE) == (-1L) ? 0 : -1)) > 0 ? OrangeManager.getInstance().getThreshold(OrangeManager.FEED_VIDEO_MAX_SIZE) * 1048576 : g.f19256f);
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void destroy() {
        LogUtils.d(TAG, "destroy");
        if (this.tanxVideoView != null) {
            LogUtils.d(TAG, "destroy tanxVideoView置空");
            this.tanxVideoView.release();
            this.tanxVideoView = null;
        }
        VideoCacheManager.getInstance().clearThis(this.iTanxFeedAd);
        cancelVideoProgress();
    }

    public String getSessionId() {
        ITanxFeedAd iTanxFeedAd = this.iTanxFeedAd;
        return (iTanxFeedAd == null || iTanxFeedAd.getBidInfo() == null) ? "null" : this.iTanxFeedAd.getBidInfo().getSessionId();
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public View getVideoAdView(ITanxFeedVideoAdListener iTanxFeedVideoAdListener) {
        this.iTanxFeedVideoAdListener = iTanxFeedVideoAdListener;
        return getVideoView();
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public boolean isMute() {
        return this.nowMute;
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void mute() {
        TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView != null) {
            tanxVideoView.mute();
            this.nowMute = true;
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void pause() {
        LogUtils.d(TAG, "pause() 调用pause()，当前sessionId:" + getSessionId());
        stop();
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void play() {
        startPlay(false);
    }

    @Override // com.alimm.tanx.core.view.feed.ITanxFeedCacheContext
    public View remove() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("remove state:");
        TanxVideoView tanxVideoView = this.tanxVideoView;
        sb2.append(tanxVideoView != null ? tanxVideoView.getState() : "null");
        sb2.append(" getSessionId:");
        sb2.append(getSessionId());
        LogUtils.d(TAG, sb2.toString());
        TanxVideoView tanxVideoView2 = this.tanxVideoView;
        if (tanxVideoView2 != null) {
            tanxVideoView2.release();
        }
        this.tanxVideoView = null;
        return tanxVideoView2;
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void replay() {
        TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView != null) {
            tanxVideoView.replay();
            setVideoProgress(this.tanxVideoView.getState(), true);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void resumeVolume() {
        TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView != null) {
            tanxVideoView.resumeVolume();
            this.nowMute = false;
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void setVolume(int i10) {
        TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView != null) {
            tanxVideoView.setVolume(i10);
            this.nowMute = i10 <= 0;
        }
    }
}
