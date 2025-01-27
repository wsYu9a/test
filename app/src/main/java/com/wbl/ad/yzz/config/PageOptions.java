package com.wbl.ad.yzz.config;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public final class PageOptions {
    private int bgType;
    private String book_id;
    private String busContext;
    private Map<String, String> extras;
    private int gender;
    private int isActiveCall;
    private boolean isAutoCalculateSection = false;
    private int isDarkMode;
    private int isFree;
    private String mBid;
    private AdBidCallback mBidCallback;
    private CheckNextChapterCallback mCheckNextChapterCallback;
    private int mExchangeRate;
    private int mFeeMode;
    private FreeTimeCallBack mFreeTimeCallBack;
    private int mLeaveLimit;
    private IMembershipCallback mMembershipCallback;
    private OnInfoEventListener mOnInfoEventListener;
    private RewardCallback mRewardCallback;
    private String mSceneId;
    private String mTopBarTitle;
    private int section;

    public static class Builder {
        private Map<String, String> extras = new HashMap();
        private boolean isAutoCalculateSection;
        private int mBgType;
        private String mBid;
        private AdBidCallback mBidCallback;
        private String mBookId;
        private String mBusContext;
        private int mChapterNo;
        private CheckNextChapterCallback mCheckNextChapterCallback;
        private int mExchangeRate;
        private int mFeeMode;
        private FreeTimeCallBack mFreeTimeCallBack;
        private int mGender;
        private int mIsActiveCall;
        private int mIsDarkMode;
        private int mIsFree;
        private int mLeaveLimit;
        private IMembershipCallback mMembershipCallback;
        private OnInfoEventListener mOnInfoEventListener;
        private RewardCallback mRewardCallback;
        private String mSceneId;
        private String mTopBarTitle;

        public Builder autoCalculateSection(boolean z) {
            this.isAutoCalculateSection = z;
            return this;
        }

        public Builder bgType(int i2) {
            this.mBgType = i2;
            return this;
        }

        public Builder bid(String str) {
            this.mBid = str;
            return this;
        }

        public Builder bidCallback(AdBidCallback adBidCallback) {
            this.mBidCallback = adBidCallback;
            return this;
        }

        public Builder bookId(String str) {
            this.mBookId = str;
            return this;
        }

        public PageOptions build() {
            PageOptions pageOptions = new PageOptions();
            pageOptions.setGender(this.mGender);
            pageOptions.setBusContext(this.mBusContext);
            pageOptions.setBgType(this.mBgType);
            pageOptions.setIsFree(this.mIsFree);
            pageOptions.setIsActiveCall(this.mIsActiveCall);
            pageOptions.setIsDarkMode(this.mIsDarkMode);
            pageOptions.setBook_id(this.mBookId);
            pageOptions.setSection(this.mChapterNo);
            pageOptions.setmFeeMode(this.mFeeMode);
            pageOptions.setmTopBarTitle(this.mTopBarTitle);
            pageOptions.setmExchangeRate(this.mExchangeRate);
            pageOptions.setmLeaveLimit(this.mLeaveLimit);
            pageOptions.setSceneId(this.mSceneId);
            pageOptions.setExtras(this.extras);
            pageOptions.setBid(this.mBid);
            pageOptions.setBidCallback(this.mBidCallback);
            pageOptions.setAutoCalculateSection(this.isAutoCalculateSection);
            pageOptions.setFreeTimeCallBack(this.mFreeTimeCallBack);
            pageOptions.setRewardCallback(this.mRewardCallback);
            pageOptions.setCheckNextChapterCallback(this.mCheckNextChapterCallback);
            pageOptions.setOnInfoEventListener(this.mOnInfoEventListener);
            pageOptions.setMembershipCallback(this.mMembershipCallback);
            return pageOptions;
        }

        public Builder busContext(String str) {
            this.mBusContext = str;
            return this;
        }

        public Builder chapterNo(int i2) {
            this.mChapterNo = i2;
            return this;
        }

        public Builder checkNextChapterCallback(CheckNextChapterCallback checkNextChapterCallback) {
            this.mCheckNextChapterCallback = checkNextChapterCallback;
            return this;
        }

        public Builder exchangeRate(int i2) {
            this.mExchangeRate = i2;
            return this;
        }

        public Builder freeTimeCallBack(FreeTimeCallBack freeTimeCallBack) {
            this.mFreeTimeCallBack = freeTimeCallBack;
            return this;
        }

        public Builder gender(int i2) {
            this.mGender = i2;
            return this;
        }

        public Builder isActiveCall(int i2) {
            this.mIsActiveCall = i2;
            return this;
        }

        public Builder isCharge(boolean z) {
            this.mFeeMode = z ? 1 : 0;
            return this;
        }

        public Builder isDarkMode(int i2) {
            this.mIsDarkMode = i2;
            return this;
        }

        public Builder isInNoAdTime(int i2) {
            this.mIsFree = i2;
            return this;
        }

        public Builder leaveLimit(int i2) {
            this.mLeaveLimit = i2;
            return this;
        }

        public Builder putExtra(String str, String str2) {
            try {
                this.extras.put(str, str2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return this;
        }

        public Builder rewardCallback(RewardCallback rewardCallback) {
            this.mRewardCallback = rewardCallback;
            return this;
        }

        public Builder sceneId(String str) {
            this.mSceneId = str;
            return this;
        }

        public Builder setMembershipCallback(IMembershipCallback iMembershipCallback) {
            this.mMembershipCallback = iMembershipCallback;
            return this;
        }

        public Builder setOnInfoEventListener(OnInfoEventListener onInfoEventListener) {
            this.mOnInfoEventListener = onInfoEventListener;
            return this;
        }

        public Builder topTitle(String str) {
            this.mTopBarTitle = str;
            return this;
        }
    }

    public void copyInfo(PageOptions pageOptions) {
        if (pageOptions == null) {
            return;
        }
        try {
            pageOptions.gender = this.gender;
            pageOptions.busContext = this.busContext;
            pageOptions.bgType = this.bgType;
            pageOptions.isFree = this.isFree;
            pageOptions.isActiveCall = this.isActiveCall;
            pageOptions.isDarkMode = this.isDarkMode;
            pageOptions.book_id = this.book_id;
            pageOptions.section = this.section;
            pageOptions.mFeeMode = this.mFeeMode;
            pageOptions.mTopBarTitle = getmTopBarTitle();
            pageOptions.mExchangeRate = this.mExchangeRate;
            pageOptions.mLeaveLimit = this.mLeaveLimit;
            pageOptions.mSceneId = this.mSceneId;
            pageOptions.extras = this.extras;
            pageOptions.mBid = this.mBid;
            pageOptions.mBidCallback = this.mBidCallback;
            pageOptions.isAutoCalculateSection = this.isAutoCalculateSection;
            pageOptions.mOnInfoEventListener = this.mOnInfoEventListener;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getBgType() {
        return this.bgType;
    }

    public String getBid() {
        return this.mBid;
    }

    public AdBidCallback getBidCallback() {
        return this.mBidCallback;
    }

    public String getBook_id() {
        return this.book_id;
    }

    public String getBusContext() {
        return this.busContext;
    }

    public CheckNextChapterCallback getCheckNextChapterCallback() {
        return this.mCheckNextChapterCallback;
    }

    public Map<String, String> getExtras() {
        return this.extras;
    }

    public FreeTimeCallBack getFreeTimeCallBack() {
        return this.mFreeTimeCallBack;
    }

    public int getGender() {
        return this.gender;
    }

    public int getIsActiveCall() {
        return this.isActiveCall;
    }

    public int getIsDarkMode() {
        return this.isDarkMode;
    }

    public int getIsFree() {
        return this.isFree;
    }

    public IMembershipCallback getMembershipCallback() {
        return this.mMembershipCallback;
    }

    public OnInfoEventListener getOnInfoEventListener() {
        return this.mOnInfoEventListener;
    }

    public RewardCallback getRewardCallback() {
        return this.mRewardCallback;
    }

    public String getSceneId() {
        return this.mSceneId;
    }

    public int getSection() {
        return this.section;
    }

    public int getmExchangeRate() {
        return this.mExchangeRate;
    }

    public int getmFeeMode() {
        return this.mFeeMode;
    }

    public int getmLeaveLimit() {
        return this.mLeaveLimit;
    }

    public String getmTopBarTitle() {
        return this.mTopBarTitle;
    }

    public boolean isAutoCalculateSection() {
        return this.isAutoCalculateSection;
    }

    public void setAutoCalculateSection(boolean z) {
        this.isAutoCalculateSection = z;
    }

    public void setBgType(int i2) {
        this.bgType = i2;
    }

    public void setBid(String str) {
        this.mBid = str;
    }

    public void setBidCallback(AdBidCallback adBidCallback) {
        this.mBidCallback = adBidCallback;
    }

    public void setBook_id(String str) {
        this.book_id = str;
    }

    public void setBusContext(String str) {
        this.busContext = str;
    }

    public void setCheckNextChapterCallback(CheckNextChapterCallback checkNextChapterCallback) {
        this.mCheckNextChapterCallback = checkNextChapterCallback;
    }

    public void setExtras(Map<String, String> map) {
        this.extras = map;
    }

    public void setFreeTimeCallBack(FreeTimeCallBack freeTimeCallBack) {
        this.mFreeTimeCallBack = freeTimeCallBack;
    }

    public void setGender(int i2) {
        this.gender = i2;
    }

    public void setIsActiveCall(int i2) {
        this.isActiveCall = i2;
    }

    public void setIsDarkMode(int i2) {
        this.isDarkMode = i2;
    }

    public void setIsFree(int i2) {
        this.isFree = i2;
    }

    public void setMembershipCallback(IMembershipCallback iMembershipCallback) {
        this.mMembershipCallback = iMembershipCallback;
    }

    public void setOnInfoEventListener(OnInfoEventListener onInfoEventListener) {
        this.mOnInfoEventListener = onInfoEventListener;
    }

    public void setRewardCallback(RewardCallback rewardCallback) {
        this.mRewardCallback = rewardCallback;
    }

    public void setSceneId(String str) {
        this.mSceneId = str;
    }

    public void setSection(int i2) {
        this.section = i2;
    }

    public void setmExchangeRate(int i2) {
        this.mExchangeRate = i2;
    }

    public void setmFeeMode(int i2) {
        this.mFeeMode = i2;
    }

    public void setmLeaveLimit(int i2) {
        this.mLeaveLimit = i2;
    }

    public void setmTopBarTitle(String str) {
        this.mTopBarTitle = str;
    }

    public String toString() {
        return "PageOptions{gender=" + this.gender + ", busContext='" + this.busContext + "', bgType=" + this.bgType + ", isFree=" + this.isFree + ", isActiveCall=" + this.isActiveCall + ", isDarkMode=" + this.isDarkMode + ", book_id='" + this.book_id + "', section=" + this.section + ", mFeeMode=" + this.mFeeMode + ", mTopBarTitle='" + this.mTopBarTitle + "', mExchangeRate=" + this.mExchangeRate + ", mLeaveLimit=" + this.mLeaveLimit + ", mBid='" + this.mBid + "', mBidCallback=" + this.mBidCallback + ", mFreeTimeCallBack=" + this.mFreeTimeCallBack + ", mRewardCallback=" + this.mRewardCallback + ", mCheckNextChapterCallback=" + this.mCheckNextChapterCallback + ", mSceneId='" + this.mSceneId + "', isAutoCalculateSection=" + this.isAutoCalculateSection + ", mOnInfoEventListener=" + this.mOnInfoEventListener + ", mMembershipCallback=" + this.mMembershipCallback + ", extras=" + this.extras + '}';
    }
}
