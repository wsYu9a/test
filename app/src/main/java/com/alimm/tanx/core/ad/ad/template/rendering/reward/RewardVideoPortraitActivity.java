package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.TanxCoreManager;
import com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.FeedBackDialog;
import com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity;
import com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil;
import com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.ad.listener.bean.NewTrackItem;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.request.TanxPlayerError;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxRewardUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.TanxCountDownTimer;
import com.alimm.tanx.core.utils.VideoCacheManager;
import com.alimm.tanx.core.view.player.VideoScaleMode;
import com.alimm.tanx.core.view.player.core.ITanxPlayer;
import com.alimm.tanx.core.view.player.core.OnVideoBufferingListener;
import com.alimm.tanx.core.view.player.core.OnVideoErrorListener;
import com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener;
import com.alimm.tanx.core.view.player.core.PlayerBufferingState;
import com.alimm.tanx.core.view.player.core.PlayerState;
import com.alimm.tanx.core.view.player.ui.TanxPlayerView;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.List;

/* loaded from: classes.dex */
public class RewardVideoPortraitActivity extends Activity implements NotConfused {
    private Button btnForceClose;
    private FrameLayout flVideo;
    private LinearLayout flWeb;
    private ImageView ivAdLogo;
    private ImageView ivForceClose;
    private ImageView ivVoice;
    private LinearLayout llRewardVideoPlay;
    private TanxRewardVideoAdView mAdView;
    private TanxCountDownTimer mCountDownTimer;
    private ITanxRewardVideoAd mTanxAd;
    private ViewStub operationButton;
    private ITanxPlayer player;
    private TanxPlayerView playerView;
    private String reqID;
    private tanxc_new tanxRewardVideoExpressAd;
    private RewardWebViewUtil webViewUtil;
    private final String TAG = "RewardVideoPortraitActivity";
    private int nowVoiceRes = R.mipmap.ic_voice;
    private long nowCurrentPosition = 0;
    private long totalTime = 0;
    private String nowPlayerState = PointCategory.READY;
    private volatile boolean startTimerSwitch = false;
    private boolean h5Pause = false;
    private volatile boolean isFront = false;
    private boolean isFirstDraw = true;
    private boolean isSendRewardArrived = false;
    volatile boolean isHsUt = false;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity$1 */
    public class AnonymousClass1 implements RewardWebViewUtil.RewardInterface {

        /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity$1$1 */
        public class RunnableC02081 implements Runnable {
            public RunnableC02081() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RewardVideoPortraitActivity.this.ivForceClose.setVisibility(8);
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void adClose() {
            RewardVideoPortraitActivity.this.adCloseUpload();
            RewardVideoPortraitActivity.this.finish();
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void adSkip(boolean z10) {
            if (RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd != null && RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for() != null) {
                RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for().onSkippedVideo();
            }
            if (z10) {
                RewardVideoPortraitActivity.this.adCloseUpload();
                RewardVideoPortraitActivity.this.finish();
            } else if (RewardVideoPortraitActivity.this.playerView != null) {
                RewardVideoPortraitActivity.this.playerView.stop();
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public long getCurrentTime() {
            if (RewardVideoPortraitActivity.this.playerView == null) {
                return 0L;
            }
            RewardVideoPortraitActivity.this.nowCurrentPosition = r0.playerView.getCurrentPosition() / 1000;
            LogUtils.d("RewardVideoPortraitActivity", "当前视频进度：" + RewardVideoPortraitActivity.this.nowCurrentPosition);
            return RewardVideoPortraitActivity.this.nowCurrentPosition;
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public String getPlayState() {
            return RewardVideoPortraitActivity.this.nowPlayerState;
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public long getTotalTime() {
            if (RewardVideoPortraitActivity.this.playerView == null) {
                return 0L;
            }
            RewardVideoPortraitActivity.this.totalTime = r0.playerView.getDuration() / 1000;
            return RewardVideoPortraitActivity.this.totalTime;
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void h5NotifyDrawSuccess() {
            RewardVideoPortraitActivity.this.ivForceClose.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.1.1
                public RunnableC02081() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    RewardVideoPortraitActivity.this.ivForceClose.setVisibility(8);
                }
            });
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public void onScroll(int i10, int i11) {
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public void setPlayer(Boolean bool, Boolean bool2) {
            if (RewardVideoPortraitActivity.this.playerView != null) {
                if (bool != null) {
                    if (bool.booleanValue()) {
                        RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_do.mute = true;
                        RewardVideoPortraitActivity.this.playerView.mute();
                    } else {
                        RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_do.mute = false;
                        RewardVideoPortraitActivity.this.playerView.resumeVolume();
                    }
                }
                if (bool2 != null) {
                    if (bool2.booleanValue()) {
                        RewardVideoPortraitActivity.this.h5Pause = true;
                        RewardVideoPortraitActivity.this.playerView.pause();
                    } else {
                        RewardVideoPortraitActivity.this.h5Pause = false;
                        RewardVideoPortraitActivity.this.playerView.start();
                    }
                }
            }
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void webDrawStatus(boolean z10) {
            if (z10 || RewardVideoPortraitActivity.this.isHsUt) {
                return;
            }
            TanxBaseUt.utErrorCode(RewardVideoPortraitActivity.this.mTanxAd, UtErrorCode.CRASH_H5_ERROR);
            RewardVideoPortraitActivity.this.isHsUt = true;
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void webError(int i10, String str) {
            LogUtils.e("RewardVideoPortraitActivity", "激励视频：webError: cmd :" + i10 + " msg:" + str);
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public void webNotifyCountDown(int i10, int i11) {
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity$2 */
    public class AnonymousClass2 implements ITanxInteractionListener<ITanxRewardVideoAd> {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
        public /* synthetic */ void onAdClicked(TanxAdView tanxAdView, ITanxRewardVideoAd iTanxRewardVideoAd) {
            tanxc_do();
        }

        public void tanxc_do() {
            LogUtils.d("RewardVideoPortraitActivity", "onAdClicked");
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
        /* renamed from: tanxc_do */
        public void onAdShow(ITanxRewardVideoAd iTanxRewardVideoAd) {
            LogUtils.d("RewardVideoPortraitActivity", "onAdShow");
            if (RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd == null || RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for() == null) {
                return;
            }
            RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for().onAdShow(iTanxRewardVideoAd);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity$3 */
    public class AnonymousClass3 extends TanxCountDownTimer {

        /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity$3$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RewardVideoPortraitActivity.this.btnForceClose.setVisibility(0);
            }
        }

        public AnonymousClass3(long j10, long j11) {
            super(j10, j11);
        }

        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
        public void onFinish() {
            LogUtils.d("adCloseStartTimer", "onFinish");
            RewardVideoPortraitActivity.this.startTimerSwitch = false;
        }

        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
        public void onTick(long j10) {
            int round = Math.round(j10 / 1000.0f);
            if (round <= 1) {
                RewardVideoPortraitActivity.this.btnForceClose.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.3.1
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        RewardVideoPortraitActivity.this.btnForceClose.setVisibility(0);
                    }
                });
            }
            LogUtils.d("adCloseStartTimer", round + "");
        }
    }

    private void adCloseStartTimer() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("startTimer - startSwitch:");
        sb2.append(this.startTimerSwitch);
        sb2.append("  btnForceClose.Visibility：");
        sb2.append(this.btnForceClose.getVisibility() == 0);
        sb2.append(" isFront：");
        sb2.append(this.isFront);
        LogUtils.d("adCloseStartTimer", sb2.toString());
        try {
            if (this.isFront && !this.startTimerSwitch && this.btnForceClose.getVisibility() != 0) {
                TanxPlayerView tanxPlayerView = this.playerView;
                if (tanxPlayerView == null || tanxPlayerView.getState() == null || (this.playerView.getState() != PlayerState.COMPLETED && this.playerView.getState() != PlayerState.END)) {
                    String str = "";
                    if (this.playerView != null) {
                        str = "" + this.playerView.getState();
                    }
                    LogUtils.d("adCloseStartTimer", "不满足启动条件playerView.getState():" + str);
                    return;
                }
                LogUtils.d("adCloseStartTimer", "启动强制关闭倒计时");
                AnonymousClass3 anonymousClass3 = new TanxCountDownTimer(10000L, 1000L) { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.3

                    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity$3$1 */
                    public class AnonymousClass1 implements Runnable {
                        public AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            RewardVideoPortraitActivity.this.btnForceClose.setVisibility(0);
                        }
                    }

                    public AnonymousClass3(long j10, long j11) {
                        super(j10, j11);
                    }

                    @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                    public void onFinish() {
                        LogUtils.d("adCloseStartTimer", "onFinish");
                        RewardVideoPortraitActivity.this.startTimerSwitch = false;
                    }

                    @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                    public void onTick(long j10) {
                        int round = Math.round(j10 / 1000.0f);
                        if (round <= 1) {
                            RewardVideoPortraitActivity.this.btnForceClose.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.3.1
                                public AnonymousClass1() {
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    RewardVideoPortraitActivity.this.btnForceClose.setVisibility(0);
                                }
                            });
                        }
                        LogUtils.d("adCloseStartTimer", round + "");
                    }
                };
                this.mCountDownTimer = anonymousClass3;
                anonymousClass3.start();
                this.startTimerSwitch = true;
                return;
            }
            LogUtils.d("adCloseStartTimer", "return");
        } catch (Exception e10) {
            LogUtils.e("adCloseStartTimer", e10);
        }
    }

    public void adCloseUpload() {
        ITanxRewardVideoAd iTanxRewardVideoAd = this.mTanxAd;
        if (iTanxRewardVideoAd == null || iTanxRewardVideoAd.getBidInfo() == null || this.mTanxAd.getBidInfo().getEventTrack() == null) {
            return;
        }
        InteractionUpload interactionUpload = InteractionUpload.getInstance();
        List<NewTrackItem> eventTrack = this.mTanxAd.getBidInfo().getEventTrack();
        InteractionUpload.getInstance();
        interactionUpload.uploadInteraction(5, eventTrack, 3);
    }

    private void adCloseUtAndUpload() {
        RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
        if (rewardWebViewUtil != null) {
            rewardWebViewUtil.tanxc_if(2);
        }
        adCloseUpload();
    }

    private void bindMonitor() {
        this.mTanxAd.bindRewardVideoAdView(this.mAdView, new ITanxInteractionListener<ITanxRewardVideoAd>() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.2
            public AnonymousClass2() {
            }

            @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
            public /* synthetic */ void onAdClicked(TanxAdView tanxAdView, ITanxRewardVideoAd iTanxRewardVideoAd) {
                tanxc_do();
            }

            public void tanxc_do() {
                LogUtils.d("RewardVideoPortraitActivity", "onAdClicked");
            }

            @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
            /* renamed from: tanxc_do */
            public void onAdShow(ITanxRewardVideoAd iTanxRewardVideoAd) {
                LogUtils.d("RewardVideoPortraitActivity", "onAdShow");
                if (RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd == null || RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for() == null) {
                    return;
                }
                RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for().onAdShow(iTanxRewardVideoAd);
            }
        });
    }

    /* renamed from: dispatchBufferingState */
    public void lambda$initVideo$7(PlayerBufferingState playerBufferingState) {
        this.nowPlayerState = TextUtils.isEmpty(tanxc_do.tanxc_do(playerBufferingState)) ? this.nowPlayerState : tanxc_do.tanxc_do(playerBufferingState);
        LogUtils.d("RewardVideoPortraitActivity", "nowPlayerState:" + this.nowPlayerState);
        RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
        if (rewardWebViewUtil != null) {
            rewardWebViewUtil.tanxc_do(tanxc_do.tanxc_do(playerBufferingState));
        }
        if (playerBufferingState != PlayerBufferingState.BUFFERING_START && playerBufferingState == PlayerBufferingState.BUFFERING_END) {
            timerCancel();
        }
    }

    /* renamed from: dispatchStateChange */
    public void lambda$initVideo$6(ITanxPlayer iTanxPlayer, PlayerState playerState) {
        try {
            String tanxc_do = tanxc_do.tanxc_do(playerState);
            if (TextUtils.isEmpty(tanxc_do)) {
                tanxc_do = this.nowPlayerState;
            }
            this.nowPlayerState = tanxc_do;
            LogUtils.d("RewardVideoPortraitActivity", "nowPlayerState:" + this.nowPlayerState);
            RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
            if (rewardWebViewUtil != null) {
                rewardWebViewUtil.tanxc_do(tanxc_do.tanxc_do(playerState));
            }
            if (playerState == PlayerState.STARTED) {
                if (this.isFirstDraw) {
                    LogUtils.d("utLog", "utViewDraw");
                    TanxRewardUt.utViewDraw(this.mTanxAd, 1);
                }
                this.isFirstDraw = false;
                timerCancel();
                ITanxRewardVideoAd iTanxRewardVideoAd = this.mTanxAd;
                if (iTanxRewardVideoAd != null) {
                    iTanxRewardVideoAd.onResourceLoadSuccess();
                }
            }
            if (playerState == PlayerState.COMPLETED || playerState == PlayerState.END) {
                videoCompleteAndRewardArrived();
            }
        } catch (Exception e10) {
            LogUtils.e("RewardVideoPortraitActivity", e10);
        }
    }

    private boolean getIntentData() {
        try {
            String stringExtra = getIntent().getStringExtra("REQ_ID");
            this.reqID = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                return false;
            }
            tanxc_new tanxc_newVar = (tanxc_new) tanxc_if.tanxc_do.get(this.reqID);
            this.tanxRewardVideoExpressAd = tanxc_newVar;
            if (tanxc_newVar == null) {
                return false;
            }
            this.mTanxAd = tanxc_newVar.tanxc_if;
            return true;
        } catch (Exception e10) {
            LogUtils.e(e10);
            return false;
        }
    }

    private void init() {
        this.llRewardVideoPlay = (LinearLayout) findViewById(R.id.ll_reward_video_play);
        this.ivVoice = (ImageView) findViewById(R.id.iv_voice);
        this.ivForceClose = (ImageView) findViewById(R.id.iv_force_close);
        this.mAdView = (TanxRewardVideoAdView) findViewById(R.id.root_view);
        this.flVideo = (FrameLayout) findViewById(R.id.fl_video);
        this.flWeb = (LinearLayout) findViewById(R.id.fl_reward_video_portrait_wb);
        this.btnForceClose = (Button) findViewById(R.id.btn_force_close);
    }

    private void initVideo() {
        try {
            TanxPlayerView tanxPlayerView = new TanxPlayerView(this);
            this.playerView = tanxPlayerView;
            this.flVideo.addView(tanxPlayerView, 0, new FrameLayout.LayoutParams(-1, -1, 17));
            ITanxPlayer create = TanxCoreManager.getInstance().getTanxCoreInstanceConfig().getTanxPlayer().create();
            this.player = create;
            this.playerView.setTanxPlayer(create);
            this.playerView.setDataSource(this.mTanxAd.getBidInfo().getCreativeItem().getVideo());
            this.playerView.setVideoScaleMode(VideoScaleMode.FIT_CENTER);
            this.playerView.setCover(this.mTanxAd.getBidInfo().getCreativeItem().getImageUrl());
            LogUtils.d("RewardVideoPortraitActivity", this.mTanxAd.getBidInfo().getCreativeItem().getVideo());
            this.playerView.prepare();
            if (this.tanxRewardVideoExpressAd.tanxc_do.mute) {
                this.playerView.mute();
            } else {
                this.playerView.resumeVolume();
            }
            this.playerView.setOnVideoStateChangeListener(new OnVideoStateChangeListener() { // from class: r1.a
                public /* synthetic */ a() {
                }

                @Override // com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener
                public final void onStateChange(ITanxPlayer iTanxPlayer, PlayerState playerState) {
                    RewardVideoPortraitActivity.this.lambda$initVideo$6(iTanxPlayer, playerState);
                }
            });
            this.playerView.setOnVideoBufferingListener(new OnVideoBufferingListener() { // from class: r1.b
                public /* synthetic */ b() {
                }

                @Override // com.alimm.tanx.core.view.player.core.OnVideoBufferingListener
                public final void OnBufferStateChanged(PlayerBufferingState playerBufferingState) {
                    RewardVideoPortraitActivity.this.lambda$initVideo$7(playerBufferingState);
                }
            });
            this.playerView.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: r1.c
                public /* synthetic */ c() {
                }

                @Override // com.alimm.tanx.core.view.player.core.OnVideoErrorListener
                public final boolean onError(ITanxPlayer iTanxPlayer, TanxPlayerError tanxPlayerError) {
                    boolean lambda$initVideo$8;
                    lambda$initVideo$8 = RewardVideoPortraitActivity.this.lambda$initVideo$8(iTanxPlayer, tanxPlayerError);
                    return lambda$initVideo$8;
                }
            });
        } catch (Exception e10) {
            LogUtils.d("RewardVideoPortraitActivity", "initVideo()-" + LogUtils.getStackTraceMessage(e10));
            TanxRewardUt.utViewDraw(this.mTanxAd, 0);
        }
    }

    private void initView() {
        initVideo();
        initWeb();
    }

    private void initWeb() {
        RewardWebViewUtil rewardWebViewUtil = new RewardWebViewUtil();
        this.webViewUtil = rewardWebViewUtil;
        rewardWebViewUtil.tanxc_do(this.flWeb, this.mTanxAd.getBidInfo(), this.mTanxAd.getAdSlot(), this.tanxRewardVideoExpressAd, new RewardWebViewUtil.RewardInterface() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.1

            /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity$1$1 */
            public class RunnableC02081 implements Runnable {
                public RunnableC02081() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    RewardVideoPortraitActivity.this.ivForceClose.setVisibility(8);
                }
            }

            public AnonymousClass1() {
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
            public void adClose() {
                RewardVideoPortraitActivity.this.adCloseUpload();
                RewardVideoPortraitActivity.this.finish();
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
            public void adSkip(boolean z10) {
                if (RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd != null && RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for() != null) {
                    RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for().onSkippedVideo();
                }
                if (z10) {
                    RewardVideoPortraitActivity.this.adCloseUpload();
                    RewardVideoPortraitActivity.this.finish();
                } else if (RewardVideoPortraitActivity.this.playerView != null) {
                    RewardVideoPortraitActivity.this.playerView.stop();
                }
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
            public long getCurrentTime() {
                if (RewardVideoPortraitActivity.this.playerView == null) {
                    return 0L;
                }
                RewardVideoPortraitActivity.this.nowCurrentPosition = r0.playerView.getCurrentPosition() / 1000;
                LogUtils.d("RewardVideoPortraitActivity", "当前视频进度：" + RewardVideoPortraitActivity.this.nowCurrentPosition);
                return RewardVideoPortraitActivity.this.nowCurrentPosition;
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
            public String getPlayState() {
                return RewardVideoPortraitActivity.this.nowPlayerState;
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
            public long getTotalTime() {
                if (RewardVideoPortraitActivity.this.playerView == null) {
                    return 0L;
                }
                RewardVideoPortraitActivity.this.totalTime = r0.playerView.getDuration() / 1000;
                return RewardVideoPortraitActivity.this.totalTime;
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
            public void h5NotifyDrawSuccess() {
                RewardVideoPortraitActivity.this.ivForceClose.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.1.1
                    public RunnableC02081() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        RewardVideoPortraitActivity.this.ivForceClose.setVisibility(8);
                    }
                });
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
            public void onScroll(int i10, int i11) {
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
            public void setPlayer(Boolean bool, Boolean bool2) {
                if (RewardVideoPortraitActivity.this.playerView != null) {
                    if (bool != null) {
                        if (bool.booleanValue()) {
                            RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_do.mute = true;
                            RewardVideoPortraitActivity.this.playerView.mute();
                        } else {
                            RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_do.mute = false;
                            RewardVideoPortraitActivity.this.playerView.resumeVolume();
                        }
                    }
                    if (bool2 != null) {
                        if (bool2.booleanValue()) {
                            RewardVideoPortraitActivity.this.h5Pause = true;
                            RewardVideoPortraitActivity.this.playerView.pause();
                        } else {
                            RewardVideoPortraitActivity.this.h5Pause = false;
                            RewardVideoPortraitActivity.this.playerView.start();
                        }
                    }
                }
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
            public void webDrawStatus(boolean z10) {
                if (z10 || RewardVideoPortraitActivity.this.isHsUt) {
                    return;
                }
                TanxBaseUt.utErrorCode(RewardVideoPortraitActivity.this.mTanxAd, UtErrorCode.CRASH_H5_ERROR);
                RewardVideoPortraitActivity.this.isHsUt = true;
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
            public void webError(int i10, String str) {
                LogUtils.e("RewardVideoPortraitActivity", "激励视频：webError: cmd :" + i10 + " msg:" + str);
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
            public void webNotifyCountDown(int i10, int i11) {
            }
        });
    }

    public /* synthetic */ boolean lambda$initVideo$8(ITanxPlayer iTanxPlayer, TanxPlayerError tanxPlayerError) {
        LogUtils.e("playerView", tanxPlayerError);
        tanxc_new tanxc_newVar = this.tanxRewardVideoExpressAd;
        if (tanxc_newVar != null && tanxc_newVar.tanxc_for() != null) {
            this.tanxRewardVideoExpressAd.tanxc_for().onVideoError(tanxPlayerError);
        }
        TanxRewardUt.utViewDraw(this.mTanxAd, 0);
        return false;
    }

    public /* synthetic */ void lambda$timerCancel$9() {
        this.btnForceClose.setVisibility(8);
    }

    private void timerCancel() {
        try {
            LogUtils.e("RewardVideoPortraitActivity", "adCloseTimerCancel");
            TanxCountDownTimer tanxCountDownTimer = this.mCountDownTimer;
            if (tanxCountDownTimer != null) {
                tanxCountDownTimer.cancel();
                this.mCountDownTimer = null;
            }
            this.btnForceClose.post(new Runnable() { // from class: r1.d
                public /* synthetic */ d() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    RewardVideoPortraitActivity.this.lambda$timerCancel$9();
                }
            });
            this.startTimerSwitch = false;
        } catch (Exception e10) {
            LogUtils.e("timerCancel", e10);
        }
    }

    private void videoCompleteAndRewardArrived() {
        adCloseStartTimer();
        LogUtils.d("RewardVideoPortraitActivity", "开始判断发奖 totalTime：" + this.totalTime + "  nowCurrentPosition：" + this.nowCurrentPosition + "  isSendRewardArrived:" + this.isSendRewardArrived);
        if (this.isSendRewardArrived) {
            return;
        }
        long j10 = this.totalTime;
        if (j10 <= 0 || j10 - this.nowCurrentPosition > 1) {
            return;
        }
        LogUtils.d("RewardVideoPortraitActivity", "触发发奖");
        this.isSendRewardArrived = true;
        TanxRewardUt.utIsRewardValid(this.mTanxAd, 0);
        this.tanxRewardVideoExpressAd.tanxc_for().onVideoComplete();
        this.tanxRewardVideoExpressAd.tanxc_for().onRewardArrived(true, 0, null);
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.ll_reward_video_feed_back) {
            new FeedBackDialog(this, R.style.CommonDialog, this.mTanxAd).show();
            return;
        }
        if (id2 == R.id.iv_voice) {
            int i10 = this.nowVoiceRes;
            int i11 = R.mipmap.ic_voice;
            if (i10 == i11) {
                i11 = R.mipmap.ic_mute;
            }
            this.ivVoice.setImageResource(i11);
            this.nowVoiceRes = i11;
            return;
        }
        if (id2 == R.id.ll_reward_video_play) {
            this.llRewardVideoPlay.setVisibility(8);
            return;
        }
        if (id2 == R.id.iv_close) {
            this.mTanxAd.click("", "");
            return;
        }
        if (id2 == R.id.btn_pre_load_h5) {
            this.mCountDownTimer.cancel();
            this.mCountDownTimer.resume();
            return;
        }
        if (id2 == R.id.btn_send_play_state) {
            RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
            if (rewardWebViewUtil != null) {
                rewardWebViewUtil.tanxc_do("2123");
                return;
            }
            return;
        }
        if (id2 == R.id.btn_send_audio) {
            RewardWebViewUtil rewardWebViewUtil2 = this.webViewUtil;
            if (rewardWebViewUtil2 != null) {
                rewardWebViewUtil2.tanxc_do(0);
                return;
            }
            return;
        }
        if (id2 == R.id.btn_force_close) {
            adCloseUtAndUpload();
            finish();
        } else if (id2 == R.id.iv_force_close) {
            adCloseUtAndUpload();
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_reward_video_portrait);
        if (!getIntentData()) {
            LogUtils.d("RewardVideoPortraitActivity", "getIntentData数据有问题。");
            finish();
        } else {
            init();
            initView();
            bindMonitor();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.playerView != null) {
                TanxRewardUt.utCloseAdVideoProgress(this.mTanxAd, r0.getCurrentPosition());
                this.playerView.release();
            }
            VideoCacheManager.getInstance().clearThis(this.tanxRewardVideoExpressAd);
            tanxc_if.tanxc_do(this.reqID);
            tanxc_new tanxc_newVar = this.tanxRewardVideoExpressAd;
            if (tanxc_newVar != null && tanxc_newVar.tanxc_for() != null) {
                this.tanxRewardVideoExpressAd.tanxc_for().onAdClose();
            }
            RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
            if (rewardWebViewUtil != null) {
                rewardWebViewUtil.tanxc_if();
            }
            timerCancel();
        } catch (Exception e10) {
            LogUtils.e("RewardVideoPortraitActivity", LogUtils.getStackTraceMessage(e10));
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "RewardVideoPortraitActivity", LogUtils.getStackTraceMessage(e10), "");
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (i10 != 4 || this.btnForceClose.getVisibility() != 0) {
            return true;
        }
        adCloseUtAndUpload();
        return super.onKeyUp(i10, keyEvent);
    }

    @Override // android.app.Activity
    public void onPause() {
        LogUtils.d("RewardVideoPortraitActivity", "onPause");
        super.onPause();
        this.isFront = false;
        timerCancel();
        if (this.playerView != null) {
            LogUtils.d("RewardVideoPortraitActivity", "playerView onPause");
            this.playerView.pause();
        }
        if (this.webViewUtil != null) {
            LogUtils.d("RewardVideoPortraitActivity", "webViewUtil onPause");
            this.webViewUtil.tanxc_for();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.isFront = true;
        TanxPlayerView tanxPlayerView = this.playerView;
        if (tanxPlayerView != null && tanxPlayerView.getState() == PlayerState.PAUSED && !this.h5Pause) {
            this.playerView.start();
        }
        RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
        if (rewardWebViewUtil != null) {
            rewardWebViewUtil.tanxc_int();
        }
        adCloseStartTimer();
    }
}
