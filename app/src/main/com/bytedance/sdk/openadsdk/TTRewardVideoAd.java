package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;

/* loaded from: classes2.dex */
public interface TTRewardVideoAd extends TTClientBidding {
    public static final String REWARD_EXTRA_KEY_ERROR_CODE = "reward_extra_key_error_code";
    public static final String REWARD_EXTRA_KEY_ERROR_MSG = "reward_extra_key_error_msg";
    public static final String REWARD_EXTRA_KEY_HAS_VIDEO_COMPLETE_REWARD = "reward_extra_key_has_video_complete_reward";
    public static final String REWARD_EXTRA_KEY_IS_SERVER_VERIFY = "reward_extra_key_is_server_verify";
    public static final String REWARD_EXTRA_KEY_REWARD_AMOUNT = "reward_extra_key_reward_amount";
    public static final String REWARD_EXTRA_KEY_REWARD_NAME = "reward_extra_key_reward_name";
    public static final String REWARD_EXTRA_KEY_REWARD_PROPOSE = "reward_extra_key_reward_propose";
    public static final int REWARD_TYPE_CLICK_LANDING = 4;
    public static final int REWARD_TYPE_DEFAULT = 0;
    public static final int REWARD_TYPE_INTERACT = 1;
    public static final int REWARD_TYPE_PLAYABLE = 3;
    public static final int REWARD_TYPE_VIDEO_COMPLETE = 2;

    public interface RewardAdInteractionListener {
        void onAdClose();

        void onAdShow();

        void onAdVideoBarClick();

        void onRewardArrived(boolean z10, int i10, Bundle bundle);

        @Deprecated
        void onRewardVerify(boolean z10, int i10, String str, int i11, String str2);

        void onSkippedVideo();

        void onVideoComplete();

        void onVideoError();
    }

    public interface RewardAdPlayAgainController {
        public static final String KEY_PLAY_AGAIN_ALLOW = "play_again_allow";
        public static final String KEY_PLAY_AGAIN_REWARD_AMOUNT = "play_again_reward_amount";
        public static final String KEY_PLAY_AGAIN_REWARD_NAME = "play_again_reward_name";

        public interface Callback {
            void onConditionReturn(Bundle bundle);
        }

        void getPlayAgainCondition(int i10, Callback callback);
    }

    long getExpirationTimestamp();

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    int getRewardVideoAdType();

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setRewardAdInteractionListener(RewardAdInteractionListener rewardAdInteractionListener);

    void setRewardPlayAgainController(RewardAdPlayAgainController rewardAdPlayAgainController);

    void setRewardPlayAgainInteractionListener(RewardAdInteractionListener rewardAdInteractionListener);

    @Deprecated
    void setShowDownLoadBar(boolean z10);

    void showRewardVideoAd(Activity activity);

    void showRewardVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str);
}
