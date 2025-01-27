package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ExitRetentionDialog;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.FeedBackDialog;
import com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil;
import com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.ad.listener.bean.NewTrackItem;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.image.ImageManager;
import com.alimm.tanx.core.image.util.ImageConfig;
import com.alimm.tanx.core.image.util.ScaleMode;
import com.alimm.tanx.core.image.util.TanxDrawable;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxRewardUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.TanxCountDownTimer;
import java.util.List;

/* loaded from: classes.dex */
public class RewardPortraitActivity extends Activity implements NotConfused {
    private com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.tanxc_if errorPopupWindow;
    private ExitRetentionDialog exitRetentionDialog;
    private FeedBackDialog feedBackDialog;
    private LinearLayout flWeb;
    private ImageView ivAdLogo;
    private ImageView ivVoice;
    private LinearLayout llRewardVideoPlay;
    private TanxRewardAdView mAdView;
    private TanxCountDownTimer mCountDownTimer;
    private ITanxRewardVideoAd mTanxAd;
    private String reqID;
    private RewardWebViewUtil.RewardInterface rewardInterface;
    private tanxc_new tanxRewardVideoExpressAd;
    private TextView tvRewardCountDownTxt;
    private TextView tvRewardVideoCountDown;
    private RewardWebViewUtil webViewUtil;
    private final String TAG = "RewardPortraitActivity";
    private int nowVoiceRes = R.mipmap.ic_voice;
    private volatile boolean startTimerSwitch = false;
    private volatile boolean timerFinishSwitch = false;
    private volatile boolean isFront = false;
    private boolean isSendRewardArrived = false;
    private volatile int nowWebViewSlideDistance = 0;
    private volatile int lastWebViewSlideDistance = 0;
    private final int SLIDE_CALCULATE_INTERVAL = 5;
    private volatile int nowCalculateNoSlide = 0;
    volatile boolean isHsUt = false;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity$1 */
    public class AnonymousClass1 implements ImageConfig.ImageBitmapCallback {
        final /* synthetic */ ImageConfig tanxc_do;

        public AnonymousClass1(ImageConfig imageConfig) {
            build = imageConfig;
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
        public void onFailure(String str) {
            RewardPortraitActivity.this.ivAdLogo.setVisibility(8);
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
        public void onSuccess(Bitmap bitmap) {
            RewardPortraitActivity.this.ivAdLogo.setImageBitmap(bitmap);
            RewardPortraitActivity.this.ivAdLogo.setVisibility(0);
            RewardPortraitActivity.this.ivAdLogo.setImageDrawable(new TanxDrawable(bitmap, build.getImageConfig()));
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity$2 */
    public class AnonymousClass2 implements RewardWebViewUtil.RewardInterface {

        /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity$2$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (RewardPortraitActivity.this.errorPopupWindow == null || !RewardPortraitActivity.this.errorPopupWindow.tanxc_do()) {
                    return;
                }
                RewardPortraitActivity.this.errorPopupWindow.tanxc_if();
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void adClose() {
            RewardPortraitActivity.this.adCloseUpload();
            RewardPortraitActivity.this.finish();
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void adSkip(boolean z10) {
            if (RewardPortraitActivity.this.tanxRewardVideoExpressAd != null && RewardPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for() != null) {
                RewardPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for().onSkippedVideo();
            }
            if (z10) {
                RewardPortraitActivity.this.adCloseUpload();
                RewardPortraitActivity.this.finish();
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public long getCurrentTime() {
            return 0L;
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public String getPlayState() {
            return null;
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public long getTotalTime() {
            return 0L;
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void h5NotifyDrawSuccess() {
            LogUtils.d("RewardPortraitActivity", "h5NotifyDrawSuccess");
            RewardPortraitActivity.this.flWeb.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.2.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (RewardPortraitActivity.this.errorPopupWindow == null || !RewardPortraitActivity.this.errorPopupWindow.tanxc_do()) {
                        return;
                    }
                    RewardPortraitActivity.this.errorPopupWindow.tanxc_if();
                }
            });
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public void onScroll(int i10, int i11) {
            RewardPortraitActivity.this.nowWebViewSlideDistance = i11;
            RewardPortraitActivity.this.startTimer();
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public void setPlayer(Boolean bool, Boolean bool2) {
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void webDrawStatus(boolean z10) {
            if (z10) {
                RewardPortraitActivity.this.mTanxAd.onResourceLoadSuccess();
                LogUtils.d("utLog", "utViewDraw");
                TanxRewardUt.utViewDraw(RewardPortraitActivity.this.mTanxAd, 1);
            } else {
                RewardPortraitActivity.this.showErrorDialog();
                if (RewardPortraitActivity.this.isHsUt) {
                    return;
                }
                TanxBaseUt.utErrorCode(RewardPortraitActivity.this.mTanxAd, UtErrorCode.CRASH_H5_ERROR);
                RewardPortraitActivity.this.isHsUt = true;
            }
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void webError(int i10, String str) {
            LogUtils.e("RewardPortraitActivity", "webError: cmd :" + i10 + " msg:" + str);
            RewardPortraitActivity.this.showErrorDialog();
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public void webNotifyCountDown(int i10, int i11) {
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity$3 */
    public class AnonymousClass3 implements ITanxInteractionListener<ITanxRewardVideoAd> {
        public AnonymousClass3() {
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
        public /* synthetic */ void onAdClicked(TanxAdView tanxAdView, ITanxRewardVideoAd iTanxRewardVideoAd) {
            tanxc_do();
        }

        public void tanxc_do() {
            LogUtils.d("RewardPortraitActivity", "onAdClicked");
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
        /* renamed from: tanxc_do */
        public void onAdShow(ITanxRewardVideoAd iTanxRewardVideoAd) {
            LogUtils.d("RewardPortraitActivity", "onAdShow");
            if (RewardPortraitActivity.this.tanxRewardVideoExpressAd == null || RewardPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for() == null) {
                return;
            }
            RewardPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for().onAdShow(iTanxRewardVideoAd);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity$4 */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity$4$1 */
        public class AnonymousClass1 implements View.OnClickListener {
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RewardPortraitActivity.this.errorPopupWindow.tanxc_if();
                RewardPortraitActivity.this.finish();
            }
        }

        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardPortraitActivity.this.errorPopupWindow.tanxc_do(RewardPortraitActivity.this.mAdView, new View.OnClickListener() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.4.1
                public AnonymousClass1() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RewardPortraitActivity.this.errorPopupWindow.tanxc_if();
                    RewardPortraitActivity.this.finish();
                }
            });
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity$5 */
    public class AnonymousClass5 implements ExitRetentionDialog.ClickCallBack {
        public AnonymousClass5() {
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ExitRetentionDialog.ClickCallBack
        public void continueClick() {
            TanxRewardUt.utSavePopPresist(RewardPortraitActivity.this.tanxRewardVideoExpressAd);
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ExitRetentionDialog.ClickCallBack
        public void exitClick() {
            TanxRewardUt.utSavePopCancel(RewardPortraitActivity.this.tanxRewardVideoExpressAd);
            if (RewardPortraitActivity.this.rewardInterface != null) {
                RewardPortraitActivity.this.rewardInterface.adClose();
            }
            RewardPortraitActivity.this.finish();
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity$6 */
    public class AnonymousClass6 extends TanxCountDownTimer {
        public AnonymousClass6(long j10, long j11) {
            super(j10, j11);
        }

        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
        public void onFinish() {
            LogUtils.d("startTimer", "onFinish");
            RewardPortraitActivity.this.tvRewardVideoCountDown.setVisibility(8);
            RewardPortraitActivity.this.tvRewardCountDownTxt.setText("已领取");
            RewardPortraitActivity.this.rewardArrived();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) RewardPortraitActivity.this.tvRewardCountDownTxt.getLayoutParams();
            marginLayoutParams.leftMargin = (int) TypedValue.applyDimension(1, 8.0f, RewardPortraitActivity.this.getResources().getDisplayMetrics());
            RewardPortraitActivity.this.tvRewardCountDownTxt.setLayoutParams(marginLayoutParams);
            RewardPortraitActivity.this.timerFinishSwitch = true;
            RewardPortraitActivity.this.startTimerSwitch = false;
        }

        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
        public void onTick(long j10) {
            if (RewardPortraitActivity.this.isDialogShow()) {
                RewardPortraitActivity.this.mCountDownTimer.pause();
            }
            if (!RewardPortraitActivity.this.isSlide() && RewardPortraitActivity.access$1404(RewardPortraitActivity.this) >= 5) {
                RewardPortraitActivity.this.mCountDownTimer.pause();
            }
            int round = Math.round(j10 / 1000.0f);
            if (RewardPortraitActivity.this.tvRewardVideoCountDown != null) {
                RewardPortraitActivity.this.tvRewardVideoCountDown.setText(round + "s");
            }
            LogUtils.d("startTimer", round + "");
        }
    }

    public static /* synthetic */ int access$1404(RewardPortraitActivity rewardPortraitActivity) {
        int i10 = rewardPortraitActivity.nowCalculateNoSlide + 1;
        rewardPortraitActivity.nowCalculateNoSlide = i10;
        return i10;
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
        this.mTanxAd.bindRewardVideoAdView(this.mAdView, new ITanxInteractionListener<ITanxRewardVideoAd>() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.3
            public AnonymousClass3() {
            }

            @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
            public /* synthetic */ void onAdClicked(TanxAdView tanxAdView, ITanxRewardVideoAd iTanxRewardVideoAd) {
                tanxc_do();
            }

            public void tanxc_do() {
                LogUtils.d("RewardPortraitActivity", "onAdClicked");
            }

            @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
            /* renamed from: tanxc_do */
            public void onAdShow(ITanxRewardVideoAd iTanxRewardVideoAd) {
                LogUtils.d("RewardPortraitActivity", "onAdShow");
                if (RewardPortraitActivity.this.tanxRewardVideoExpressAd == null || RewardPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for() == null) {
                    return;
                }
                RewardPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for().onAdShow(iTanxRewardVideoAd);
            }
        });
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

    private long getTimeCount() {
        try {
            ITanxRewardVideoAd iTanxRewardVideoAd = this.mTanxAd;
            if (iTanxRewardVideoAd == null || iTanxRewardVideoAd.getBidInfo() == null || this.mTanxAd.getBidInfo().getTemplateConf() == null || TextUtils.isEmpty(this.mTanxAd.getBidInfo().getTemplateConf().getCountDown())) {
                return 30L;
            }
            return Long.parseLong(this.mTanxAd.getBidInfo().getTemplateConf().getCountDown()) / 1000;
        } catch (Exception e10) {
            LogUtils.e(e10);
            return 30L;
        }
    }

    private void init() {
        this.llRewardVideoPlay = (LinearLayout) findViewById(R.id.ll_reward_video_play);
        this.ivVoice = (ImageView) findViewById(R.id.iv_voice);
        this.ivAdLogo = (ImageView) findViewById(R.id.iv_ad_logo);
        this.mAdView = (TanxRewardAdView) findViewById(R.id.root_view);
        this.flWeb = (LinearLayout) findViewById(R.id.fl_reward_video_portrait_wb);
        this.tvRewardVideoCountDown = (TextView) findViewById(R.id.tv_reward_count_down);
        this.tvRewardCountDownTxt = (TextView) findViewById(R.id.tv_reward_count_down_txt);
        this.tvRewardVideoCountDown.setText(getTimeCount() + "s");
    }

    private void initView() {
        initWeb();
        ITanxRewardVideoAd iTanxRewardVideoAd = this.mTanxAd;
        if (iTanxRewardVideoAd == null || iTanxRewardVideoAd.getBidInfo() == null || this.mTanxAd.getBidInfo().getCreativeItem() == null || TextUtils.isEmpty(this.mTanxAd.getBidInfo().getCreativeItem().getAdvLogo())) {
            return;
        }
        ImageConfig build = ImageManager.with(this.ivAdLogo.getContext()).url(this.mTanxAd.getBidInfo().getCreativeItem().getAdvLogo()).scaleMode(ScaleMode.FIT_CENTER).build();
        ImageManager.getLoader().load(build, new ImageConfig.ImageBitmapCallback() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.1
            final /* synthetic */ ImageConfig tanxc_do;

            public AnonymousClass1(ImageConfig build2) {
                build = build2;
            }

            @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
            public void onFailure(String str) {
                RewardPortraitActivity.this.ivAdLogo.setVisibility(8);
            }

            @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
            public void onSuccess(Bitmap bitmap) {
                RewardPortraitActivity.this.ivAdLogo.setImageBitmap(bitmap);
                RewardPortraitActivity.this.ivAdLogo.setVisibility(0);
                RewardPortraitActivity.this.ivAdLogo.setImageDrawable(new TanxDrawable(bitmap, build.getImageConfig()));
            }
        });
    }

    private void initWeb() {
        this.webViewUtil = new RewardWebViewUtil();
        this.rewardInterface = new RewardWebViewUtil.RewardInterface() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.2

            /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity$2$1 */
            public class AnonymousClass1 implements Runnable {
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (RewardPortraitActivity.this.errorPopupWindow == null || !RewardPortraitActivity.this.errorPopupWindow.tanxc_do()) {
                        return;
                    }
                    RewardPortraitActivity.this.errorPopupWindow.tanxc_if();
                }
            }

            public AnonymousClass2() {
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
            public void adClose() {
                RewardPortraitActivity.this.adCloseUpload();
                RewardPortraitActivity.this.finish();
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
            public void adSkip(boolean z10) {
                if (RewardPortraitActivity.this.tanxRewardVideoExpressAd != null && RewardPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for() != null) {
                    RewardPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for().onSkippedVideo();
                }
                if (z10) {
                    RewardPortraitActivity.this.adCloseUpload();
                    RewardPortraitActivity.this.finish();
                }
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
            public long getCurrentTime() {
                return 0L;
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
            public String getPlayState() {
                return null;
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
            public long getTotalTime() {
                return 0L;
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
            public void h5NotifyDrawSuccess() {
                LogUtils.d("RewardPortraitActivity", "h5NotifyDrawSuccess");
                RewardPortraitActivity.this.flWeb.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.2.1
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (RewardPortraitActivity.this.errorPopupWindow == null || !RewardPortraitActivity.this.errorPopupWindow.tanxc_do()) {
                            return;
                        }
                        RewardPortraitActivity.this.errorPopupWindow.tanxc_if();
                    }
                });
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
            public void onScroll(int i10, int i11) {
                RewardPortraitActivity.this.nowWebViewSlideDistance = i11;
                RewardPortraitActivity.this.startTimer();
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
            public void setPlayer(Boolean bool, Boolean bool2) {
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
            public void webDrawStatus(boolean z10) {
                if (z10) {
                    RewardPortraitActivity.this.mTanxAd.onResourceLoadSuccess();
                    LogUtils.d("utLog", "utViewDraw");
                    TanxRewardUt.utViewDraw(RewardPortraitActivity.this.mTanxAd, 1);
                } else {
                    RewardPortraitActivity.this.showErrorDialog();
                    if (RewardPortraitActivity.this.isHsUt) {
                        return;
                    }
                    TanxBaseUt.utErrorCode(RewardPortraitActivity.this.mTanxAd, UtErrorCode.CRASH_H5_ERROR);
                    RewardPortraitActivity.this.isHsUt = true;
                }
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
            public void webError(int i10, String str) {
                LogUtils.e("RewardPortraitActivity", "webError: cmd :" + i10 + " msg:" + str);
                RewardPortraitActivity.this.showErrorDialog();
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
            public void webNotifyCountDown(int i10, int i11) {
            }
        };
        this.webViewUtil.tanxc_do(this.flWeb, this.mTanxAd.getBidInfo(), this.mTanxAd.getAdSlot(), this.tanxRewardVideoExpressAd, this.rewardInterface);
    }

    public boolean isDialogShow() {
        ExitRetentionDialog exitRetentionDialog = this.exitRetentionDialog;
        if (exitRetentionDialog != null && exitRetentionDialog.isShowing()) {
            return true;
        }
        FeedBackDialog feedBackDialog = this.feedBackDialog;
        return feedBackDialog != null && feedBackDialog.isShowing();
    }

    public boolean isSlide() {
        if (this.lastWebViewSlideDistance == this.nowWebViewSlideDistance) {
            return false;
        }
        this.lastWebViewSlideDistance = this.nowWebViewSlideDistance;
        this.nowCalculateNoSlide = 0;
        return true;
    }

    public void rewardArrived() {
        try {
            LogUtils.d("RewardPortraitActivity", "开始判断发奖 isSendRewardArrived:" + this.isSendRewardArrived);
            if (this.isSendRewardArrived) {
                return;
            }
            LogUtils.d("RewardPortraitActivity", "触发发奖");
            this.isSendRewardArrived = true;
            TanxRewardUt.utIsRewardValid(this.mTanxAd, 0);
            this.tanxRewardVideoExpressAd.tanxc_for().onVideoComplete();
            this.tanxRewardVideoExpressAd.tanxc_for().onRewardArrived(true, 0, null);
        } catch (Exception e10) {
            LogUtils.e("RewardPortraitActivity", e10);
        }
    }

    public void showErrorDialog() {
        if (this.errorPopupWindow == null) {
            this.errorPopupWindow = new com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.tanxc_if(this);
        }
        this.flWeb.postDelayed(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.4

            /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity$4$1 */
            public class AnonymousClass1 implements View.OnClickListener {
                public AnonymousClass1() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RewardPortraitActivity.this.errorPopupWindow.tanxc_if();
                    RewardPortraitActivity.this.finish();
                }
            }

            public AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RewardPortraitActivity.this.errorPopupWindow.tanxc_do(RewardPortraitActivity.this.mAdView, new View.OnClickListener() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.4.1
                    public AnonymousClass1() {
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        RewardPortraitActivity.this.errorPopupWindow.tanxc_if();
                        RewardPortraitActivity.this.finish();
                    }
                });
            }
        }, 200L);
    }

    private void showExitRetentionDialog() {
        ITanxRewardVideoAd iTanxRewardVideoAd;
        if (this.isSendRewardArrived || (iTanxRewardVideoAd = this.mTanxAd) == null || iTanxRewardVideoAd.getBidInfo() == null || this.mTanxAd.getBidInfo().getTemplateConf() == null || (!TextUtils.isEmpty(this.mTanxAd.getBidInfo().getTemplateConf().getBackPop()) && this.mTanxAd.getBidInfo().getTemplateConf().getBackPop().equals("0"))) {
            RewardWebViewUtil.RewardInterface rewardInterface = this.rewardInterface;
            if (rewardInterface != null) {
                rewardInterface.adClose();
            }
            finish();
            return;
        }
        ExitRetentionDialog exitRetentionDialog = new ExitRetentionDialog(this, R.style.CommonDialog);
        this.exitRetentionDialog = exitRetentionDialog;
        exitRetentionDialog.setClickCallBack(new ExitRetentionDialog.ClickCallBack() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.5
            public AnonymousClass5() {
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ExitRetentionDialog.ClickCallBack
            public void continueClick() {
                TanxRewardUt.utSavePopPresist(RewardPortraitActivity.this.tanxRewardVideoExpressAd);
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ExitRetentionDialog.ClickCallBack
            public void exitClick() {
                TanxRewardUt.utSavePopCancel(RewardPortraitActivity.this.tanxRewardVideoExpressAd);
                if (RewardPortraitActivity.this.rewardInterface != null) {
                    RewardPortraitActivity.this.rewardInterface.adClose();
                }
                RewardPortraitActivity.this.finish();
            }
        });
        this.exitRetentionDialog.show();
        TanxRewardUt.utSavePopImp(this.tanxRewardVideoExpressAd);
    }

    public void startTimer() {
        if (!this.timerFinishSwitch && !isDialogShow() && isSlide() && this.isFront) {
            if (!this.startTimerSwitch) {
                this.mCountDownTimer = new TanxCountDownTimer(1000 * getTimeCount(), 1000L) { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.6
                    public AnonymousClass6(long j10, long j11) {
                        super(j10, j11);
                    }

                    @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                    public void onFinish() {
                        LogUtils.d("startTimer", "onFinish");
                        RewardPortraitActivity.this.tvRewardVideoCountDown.setVisibility(8);
                        RewardPortraitActivity.this.tvRewardCountDownTxt.setText("已领取");
                        RewardPortraitActivity.this.rewardArrived();
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) RewardPortraitActivity.this.tvRewardCountDownTxt.getLayoutParams();
                        marginLayoutParams.leftMargin = (int) TypedValue.applyDimension(1, 8.0f, RewardPortraitActivity.this.getResources().getDisplayMetrics());
                        RewardPortraitActivity.this.tvRewardCountDownTxt.setLayoutParams(marginLayoutParams);
                        RewardPortraitActivity.this.timerFinishSwitch = true;
                        RewardPortraitActivity.this.startTimerSwitch = false;
                    }

                    @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                    public void onTick(long j10) {
                        if (RewardPortraitActivity.this.isDialogShow()) {
                            RewardPortraitActivity.this.mCountDownTimer.pause();
                        }
                        if (!RewardPortraitActivity.this.isSlide() && RewardPortraitActivity.access$1404(RewardPortraitActivity.this) >= 5) {
                            RewardPortraitActivity.this.mCountDownTimer.pause();
                        }
                        int round = Math.round(j10 / 1000.0f);
                        if (RewardPortraitActivity.this.tvRewardVideoCountDown != null) {
                            RewardPortraitActivity.this.tvRewardVideoCountDown.setText(round + "s");
                        }
                        LogUtils.d("startTimer", round + "");
                    }
                };
                LogUtils.d("startTimer", "启动倒计时");
                this.mCountDownTimer.start();
                this.startTimerSwitch = true;
                return;
            }
            TanxCountDownTimer tanxCountDownTimer = this.mCountDownTimer;
            if (tanxCountDownTimer == null || !tanxCountDownTimer.isPaused()) {
                return;
            }
            LogUtils.d("startTimer", "倒计时resume()");
            this.mCountDownTimer.resume();
        }
    }

    private void timerCancel(boolean z10) {
        try {
            LogUtils.e("RewardPortraitActivity", "adCloseTimerCancel");
            if (!z10) {
                TanxCountDownTimer tanxCountDownTimer = this.mCountDownTimer;
                if (tanxCountDownTimer != null) {
                    tanxCountDownTimer.pause();
                    return;
                }
                return;
            }
            TanxCountDownTimer tanxCountDownTimer2 = this.mCountDownTimer;
            if (tanxCountDownTimer2 != null) {
                tanxCountDownTimer2.cancel();
                this.mCountDownTimer = null;
            }
            this.startTimerSwitch = false;
        } catch (Exception e10) {
            LogUtils.e("timerCancel", e10);
        }
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.ll_reward_video_feed_back) {
            FeedBackDialog feedBackDialog = new FeedBackDialog(this, R.style.CommonDialog, this.mTanxAd);
            this.feedBackDialog = feedBackDialog;
            feedBackDialog.show();
            TanxRewardUt.utFeedbackPopImp(this.tanxRewardVideoExpressAd);
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
        } else if (id2 == R.id.ll_reward_video_ad_count_down) {
            showExitRetentionDialog();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_reward_portrait);
        if (!getIntentData()) {
            LogUtils.d("RewardPortraitActivity", "getIntentData数据有问题。");
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
            tanxc_if.tanxc_do(this.reqID);
            tanxc_new tanxc_newVar = this.tanxRewardVideoExpressAd;
            if (tanxc_newVar != null && tanxc_newVar.tanxc_for() != null) {
                this.tanxRewardVideoExpressAd.tanxc_for().onAdClose();
            }
            RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
            if (rewardWebViewUtil != null) {
                rewardWebViewUtil.tanxc_if();
            }
            timerCancel(true);
        } catch (Exception e10) {
            LogUtils.e("RewardPortraitActivity", LogUtils.getStackTraceMessage(e10));
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "RewardPortraitActivity", LogUtils.getStackTraceMessage(e10), "");
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        return true;
    }

    @Override // android.app.Activity
    public void onPause() {
        LogUtils.d("RewardPortraitActivity", "onPause");
        super.onPause();
        this.isFront = false;
        timerCancel(false);
        if (this.webViewUtil != null) {
            LogUtils.d("RewardPortraitActivity", "webViewUtil onPause");
            this.webViewUtil.tanxc_for();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.isFront = true;
        RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
        if (rewardWebViewUtil != null) {
            rewardWebViewUtil.tanxc_int();
        }
    }
}
