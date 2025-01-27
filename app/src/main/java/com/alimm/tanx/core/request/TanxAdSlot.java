package com.alimm.tanx.core.request;

import com.alimm.tanx.core.ad.ad.reward.model.VideoParam;
import com.alimm.tanx.core.ad.bean.RewardParam;
import com.alimm.tanx.core.constant.TanxAdTemplateId;
import com.alimm.tanx.core.utils.NotConfused;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class TanxAdSlot implements NotConfused, Serializable {
    private int adCount;
    private int adType;
    private boolean brandAd;
    private boolean cacheUnderWifi;
    private boolean clickAdClose;
    private int expressViewWidth;
    private String ext;
    private boolean feedBackDialog;
    private int height;
    private boolean isExpressRender;
    private TanxAdLoadType loadType;
    private String mediaExtra;
    private String mediaUid;
    private String[] nativeTemplateId;
    private boolean notAutoPlay;
    private int orientation;
    private String pid;
    private boolean playUnderWifi;
    private Boolean realtimeRequest;
    private String reqId;
    private RewardParam rewardParam;
    private boolean rtDownloadVideo;
    private boolean rtSelection;
    private List<TopCreative> topCreatives;
    private String userId;
    private VideoParam videoParam;
    private int width;

    public static class Builder implements NotConfused {
        private int adCount;
        private int adType;
        private boolean brandAd;
        private boolean cacheUnderWifi;
        private int expressViewWidth;
        private int height;
        private boolean isExpressRender;
        private String mediaUid;
        private String[] nativeTemplateId;
        private boolean notAutoPlay;
        private String pid;
        private boolean playUnderWifi;
        private RewardParam rewardParam;
        private int width;
        private boolean feedBackDialog = true;
        private VideoParam videoParam = new VideoParam();
        private String userId = "defaultUser";
        private String mediaExtra = "";
        private int orientation = 1;
        private boolean clickAdClose = false;
        private TanxAdLoadType loadType = TanxAdLoadType.PRELOAD;
        private boolean rtSelection = true;
        private boolean rtDownloadVideo = true;

        public Builder() {
            this.adCount = 1;
            this.adCount = 1;
        }

        public Builder adCount(int i10) {
            this.adCount = i10;
            return this;
        }

        public Builder adSize(int i10, int i11) {
            this.width = i10;
            this.height = i11;
            return this;
        }

        public Builder adType(int i10) {
            this.adType = i10;
            return this;
        }

        public TanxAdSlot build() {
            return new TanxAdSlot(this);
        }

        public String getMediaUid() {
            return this.mediaUid;
        }

        public RewardParam getRewardParam() {
            return this.rewardParam;
        }

        public Builder isExpressRender(boolean z10) {
            this.isExpressRender = z10;
            return this;
        }

        @Deprecated
        public Builder nativeTemplateId(String[] strArr) {
            this.nativeTemplateId = strArr;
            return this;
        }

        public Builder pid(String str) {
            this.pid = str;
            return this;
        }

        public Builder setBrandAd(boolean z10) {
            this.brandAd = z10;
            return this;
        }

        public Builder setCacheUnderWifi(boolean z10) {
            this.cacheUnderWifi = z10;
            return this;
        }

        public Builder setClickAdClose(boolean z10) {
            this.clickAdClose = z10;
            return this;
        }

        public Builder setExpressViewAcceptedSize(int i10) {
            this.expressViewWidth = i10;
            return this;
        }

        public Builder setFeedBackDialog(boolean z10) {
            this.feedBackDialog = z10;
            return this;
        }

        public Builder setLoadType(TanxAdLoadType tanxAdLoadType) {
            this.loadType = tanxAdLoadType;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.mediaExtra = str;
            return this;
        }

        public Builder setMediaUid(String str) {
            this.mediaUid = str;
            return this;
        }

        public Builder setNotAutoPlay(boolean z10) {
            this.notAutoPlay = z10;
            return this;
        }

        public Builder setOrientation(int i10) {
            this.orientation = i10;
            return this;
        }

        public Builder setPlayUnderWifi(boolean z10) {
            this.playUnderWifi = z10;
            return this;
        }

        public Builder setRewardParam(RewardParam rewardParam) {
            this.rewardParam = rewardParam;
            return this;
        }

        public Builder setRtDownloadVideo(boolean z10) {
            this.rtDownloadVideo = z10;
            return this;
        }

        public Builder setRtSelection(boolean z10) {
            this.rtSelection = z10;
            return this;
        }

        public Builder setUserId(String str) {
            this.userId = str;
            return this;
        }

        public Builder setVideoParam(VideoParam videoParam) {
            this.videoParam = videoParam;
            return this;
        }
    }

    public TanxAdSlot() {
        this.userId = "defaultUser";
        this.mediaExtra = "";
        this.orientation = 1;
        this.feedBackDialog = true;
        this.clickAdClose = false;
        this.rtSelection = true;
        this.rtDownloadVideo = true;
        this.adCount = 1;
    }

    private void setAdSlot(int i10) {
        setAdType(i10);
        if (i10 == 1) {
            if (isBrandAd()) {
                setNativeTemplateId(TanxAdTemplateId.SPLASH_BRAND_TEMPLATE);
                return;
            } else {
                setNativeTemplateId(TanxAdTemplateId.SPLASH_TEMPLATE);
                return;
            }
        }
        if (i10 == 2) {
            setNativeTemplateId(TanxAdTemplateId.FEED_TEMPLATE);
            return;
        }
        if (i10 == 3) {
            setNativeTemplateId(TanxAdTemplateId.REWARD_VIDEO_TEMPLATE);
        } else if (i10 == 4) {
            setNativeTemplateId(TanxAdTemplateId.REWARD_TEMPLATE);
        } else {
            if (i10 != 5) {
                return;
            }
            setNativeTemplateId(TanxAdTemplateId.TABLE_SCREEN_TEMPLATE);
        }
    }

    private String uuid() {
        return UUID.randomUUID().toString().replace("-", "") + "-" + (System.currentTimeMillis() / 1000);
    }

    public void addAdSlot(int i10) {
        setAdSlot(i10);
        setExpressRender(false);
    }

    public void addTemplateAdSlot(int i10) {
        setAdSlot(i10);
        setExpressRender(true);
    }

    public int getAdCount() {
        return this.adCount;
    }

    public int getAdType() {
        return this.adType;
    }

    public int getExpressViewWidth() {
        return this.expressViewWidth;
    }

    public String getExt() {
        return this.ext;
    }

    public int getHeight() {
        return this.height;
    }

    public TanxAdLoadType getLoadType() {
        return this.loadType;
    }

    public String getMediaExtra() {
        return this.mediaExtra;
    }

    public String getMediaUid() {
        return this.mediaUid;
    }

    public String[] getNativeTemplateId() {
        return this.nativeTemplateId;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public String getPid() {
        return this.pid;
    }

    public Boolean getRealtimeRequest() {
        return this.realtimeRequest;
    }

    public String getReqId() {
        return this.reqId;
    }

    public RewardParam getRewardParam() {
        return this.rewardParam;
    }

    public List<TopCreative> getTopCreatives() {
        return this.topCreatives;
    }

    public String getUserId() {
        return this.userId;
    }

    public VideoParam getVideoParam() {
        return this.videoParam;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isBrandAd() {
        return this.brandAd;
    }

    public boolean isCacheUnderWifi() {
        return this.cacheUnderWifi;
    }

    public boolean isClickAdClose() {
        return this.clickAdClose;
    }

    public boolean isExpressRender() {
        return this.isExpressRender;
    }

    public boolean isFeedBackDialog() {
        return this.feedBackDialog;
    }

    public boolean isNotAutoPlay() {
        return this.notAutoPlay;
    }

    public boolean isPlayUnderWifi() {
        return this.playUnderWifi;
    }

    public boolean isRtDownloadVideo() {
        return this.rtDownloadVideo;
    }

    public boolean isRtSelection() {
        return this.rtSelection;
    }

    public void setAdCount(int i10) {
        this.adCount = i10;
    }

    public void setAdType(int i10) {
        this.adType = i10;
    }

    public void setBrandAd(boolean z10) {
        this.brandAd = z10;
    }

    public void setCacheUnderWifi(boolean z10) {
        this.cacheUnderWifi = z10;
    }

    public void setClickAdClose(boolean z10) {
        this.clickAdClose = z10;
    }

    public void setExpressRender(boolean z10) {
        this.isExpressRender = z10;
    }

    public void setExpressViewWidth(int i10) {
        this.expressViewWidth = i10;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setFeedBackDialog(boolean z10) {
        this.feedBackDialog = z10;
    }

    public void setHeight(int i10) {
        this.height = i10;
    }

    public void setLoadType(TanxAdLoadType tanxAdLoadType) {
        this.loadType = tanxAdLoadType;
    }

    public void setMediaExtra(String str) {
        this.mediaExtra = str;
    }

    public void setMediaUid(String str) {
        this.mediaUid = str;
    }

    public void setNativeTemplateId(String[] strArr) {
        this.nativeTemplateId = strArr;
    }

    public void setNotAutoPlay(boolean z10) {
        this.notAutoPlay = z10;
    }

    public void setOrientation(int i10) {
        this.orientation = i10;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public void setPlayUnderWifi(boolean z10) {
        this.playUnderWifi = z10;
    }

    public void setRealtimeRequest(Boolean bool) {
        this.realtimeRequest = bool;
    }

    public void setReqId(String str) {
        this.reqId = str;
    }

    public void setRewardParam(RewardParam rewardParam) {
        this.rewardParam = rewardParam;
    }

    public void setRtDownloadVideo(boolean z10) {
        this.rtDownloadVideo = z10;
    }

    public void setRtSelection(boolean z10) {
        this.rtSelection = z10;
    }

    public void setTopCreatives(List<TopCreative> list) {
        this.topCreatives = list;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setVideoParam(VideoParam videoParam) {
        this.videoParam = videoParam;
    }

    public void setWidth(int i10) {
        this.width = i10;
    }

    public TanxAdSlot(Builder builder) {
        this.adCount = 1;
        this.userId = "defaultUser";
        this.mediaExtra = "";
        this.orientation = 1;
        this.feedBackDialog = true;
        this.clickAdClose = false;
        this.rtSelection = true;
        this.rtDownloadVideo = true;
        this.adType = builder.adType;
        this.pid = builder.pid;
        this.nativeTemplateId = builder.nativeTemplateId;
        this.adCount = Math.max(builder.adCount, 1);
        this.width = builder.width;
        this.height = builder.height;
        this.reqId = uuid();
        this.expressViewWidth = builder.expressViewWidth;
        this.cacheUnderWifi = builder.cacheUnderWifi;
        this.playUnderWifi = builder.playUnderWifi;
        this.notAutoPlay = builder.notAutoPlay;
        this.videoParam = builder.videoParam;
        this.feedBackDialog = builder.feedBackDialog;
        this.clickAdClose = builder.clickAdClose;
        this.mediaUid = builder.mediaUid;
        this.loadType = builder.loadType;
        this.rewardParam = builder.rewardParam;
        this.brandAd = builder.brandAd;
        this.rtSelection = builder.rtSelection;
        this.rtDownloadVideo = builder.rtDownloadVideo;
    }
}
