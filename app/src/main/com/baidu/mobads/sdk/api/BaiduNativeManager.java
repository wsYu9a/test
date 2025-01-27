package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.internal.ad;
import com.baidu.mobads.sdk.internal.ak;
import com.baidu.mobads.sdk.internal.de;
import com.baidu.mobads.sdk.internal.g;
import java.util.List;

/* loaded from: classes2.dex */
public class BaiduNativeManager {
    private static final int FEED_TIMEOUT = 8000;
    private static final String TAG = "BaiduNativeManager";
    private boolean isCacheVideo;
    private boolean isCacheVideoOnlyWifi;
    private final String mAdPlacementId;
    private String mAppSid;
    private int mBidFloor;
    private final Context mContext;
    private RequestParameters mRequestParameters;
    private int mTimeoutMillis;

    public interface EntryAdListener {
        void onLpClosed();

        void onNativeFail(int i10, String str);

        void onNativeLoad(List<EntryResponse> list);

        void onNoAd(int i10, String str);
    }

    public interface ExpressAdListener {
        void onLpClosed();

        void onNativeFail(int i10, String str, ExpressResponse expressResponse);

        void onNativeLoad(List<ExpressResponse> list);

        void onNoAd(int i10, String str, ExpressResponse expressResponse);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    public interface FeedAdListener {
        void onLpClosed();

        void onNativeFail(int i10, String str, NativeResponse nativeResponse);

        void onNativeLoad(List<NativeResponse> list);

        void onNoAd(int i10, String str, NativeResponse nativeResponse);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    @Deprecated
    public interface PortraitVideoAdListener extends FeedAdListener {
        void onAdClick();
    }

    public BaiduNativeManager(Context context, String str) {
        this(context, str, FEED_TIMEOUT);
    }

    private String getAdPlacemenId(RequestParameters requestParameters) {
        if (requestParameters != null) {
            String adPlacementId = requestParameters.getAdPlacementId();
            if (!TextUtils.isEmpty(adPlacementId)) {
                return adPlacementId;
            }
        }
        return this.mAdPlacementId;
    }

    private int getBidFloor(RequestParameters requestParameters) {
        int bidFloor;
        return (requestParameters == null || (bidFloor = requestParameters.getBidFloor()) <= 0) ? this.mBidFloor : bidFloor;
    }

    private void loadBiddingAd(RequestParameters requestParameters, String str, String str2, FeedAdListener feedAdListener, ExpressAdListener expressAdListener) {
        de deVar = new de(this.mContext, getAdPlacemenId(requestParameters), str, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            deVar.h(this.mAppSid);
        }
        deVar.f6889r = getBidFloor(requestParameters);
        deVar.c(this.isCacheVideoOnlyWifi);
        if (feedAdListener != null) {
            deVar.a(new ad(feedAdListener));
        } else if (expressAdListener != null) {
            deVar.a(expressAdListener);
            deVar.a(1);
        }
        deVar.a(new ak());
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        deVar.a(requestParameters);
        deVar.l();
        deVar.c(str2);
    }

    public String getExpressFeedBiddingToken(RequestParameters requestParameters) {
        de deVar = new de(this.mContext, getAdPlacemenId(requestParameters), "feed", this.isCacheVideo, this.mTimeoutMillis);
        deVar.a(1);
        RequestParameters build = requestParameters == null ? new RequestParameters.Builder().build() : requestParameters;
        if (!TextUtils.isEmpty(this.mAppSid)) {
            deVar.h(this.mAppSid);
        }
        deVar.f6889r = getBidFloor(requestParameters);
        deVar.a(build);
        this.mRequestParameters = build;
        return deVar.l();
    }

    public String getFeedBiddingToken(RequestParameters requestParameters) {
        de deVar = new de(this.mContext, getAdPlacemenId(requestParameters), "feed", this.isCacheVideo, this.mTimeoutMillis);
        RequestParameters build = requestParameters == null ? new RequestParameters.Builder().build() : requestParameters;
        if (!TextUtils.isEmpty(this.mAppSid)) {
            deVar.h(this.mAppSid);
        }
        deVar.f6889r = getBidFloor(requestParameters);
        deVar.a(build);
        this.mRequestParameters = build;
        return deVar.l();
    }

    public String getPortraitVideoBiddingToken(RequestParameters requestParameters) {
        de deVar = new de(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis);
        RequestParameters build = requestParameters == null ? new RequestParameters.Builder().build() : requestParameters;
        if (!TextUtils.isEmpty(this.mAppSid)) {
            deVar.h(this.mAppSid);
        }
        deVar.f6889r = getBidFloor(requestParameters);
        deVar.a(build);
        this.mRequestParameters = build;
        return deVar.l();
    }

    public void loadBidAdForExpress(String str, ExpressAdListener expressAdListener) {
        loadBiddingAd(this.mRequestParameters, "feed", str, null, expressAdListener);
    }

    public void loadBidAdForFeed(String str, FeedAdListener feedAdListener) {
        loadBiddingAd(this.mRequestParameters, "feed", str, feedAdListener, null);
    }

    @Deprecated
    public void loadBidAdForPortraitVideo(String str, PortraitVideoAdListener portraitVideoAdListener) {
        loadBiddingAd(this.mRequestParameters, IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, str, portraitVideoAdListener, null);
    }

    public void loadContentAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        g gVar = new g(this.mContext, new ad(feedAdListener), new de(this.mContext, getAdPlacemenId(requestParameters), "content", this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.isCacheVideoOnlyWifi);
        gVar.a(new ak());
        gVar.b(requestParameters);
    }

    public void loadExpressAd(RequestParameters requestParameters, ExpressAdListener expressAdListener) {
        g gVar = new g(this.mContext, getAdPlacemenId(requestParameters), expressAdListener, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.isCacheVideoOnlyWifi);
        gVar.a(new ak());
        gVar.b(requestParameters);
    }

    public void loadFeedAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        g gVar = new g(this.mContext, getAdPlacemenId(requestParameters), new ad(feedAdListener), this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.isCacheVideoOnlyWifi);
        gVar.a(new ak());
        gVar.b(requestParameters);
    }

    public void loadFeedEntryAd(RequestParameters requestParameters, EntryAdListener entryAdListener) {
        g gVar = new g(this.mContext, getAdPlacemenId(requestParameters), entryAdListener, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.b(requestParameters);
    }

    public void loadInsiteAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        g gVar = new g(this.mContext, new ad(feedAdListener), new de(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_INSITE, this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.isCacheVideoOnlyWifi);
        gVar.a(new ak());
        gVar.b(requestParameters);
    }

    public void loadPortraitVideoAd(RequestParameters requestParameters, PortraitVideoAdListener portraitVideoAdListener) {
        loadPortraitVideoAd(requestParameters, (FeedAdListener) portraitVideoAdListener);
    }

    public void loadPrerollVideo(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        g gVar = new g(this.mContext, getAdPlacemenId(requestParameters), new ad(feedAdListener), this.isCacheVideo, FEED_TIMEOUT, IAdInterListener.AdProdType.PRODUCT_PREROLL);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.b(requestParameters);
    }

    public void setAppSid(String str) {
        this.mAppSid = str;
    }

    public void setBidFloor(int i10) {
        this.mBidFloor = i10;
    }

    public void setCacheVideoOnlyWifi(boolean z10) {
        this.isCacheVideoOnlyWifi = z10;
    }

    @Deprecated
    public void setExpressFeedBiddingData(RequestParameters requestParameters, String str, ExpressAdListener expressAdListener) {
        g gVar = new g(this.mContext, getAdPlacemenId(requestParameters), expressAdListener, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.isCacheVideoOnlyWifi);
        gVar.a(new ak());
        gVar.a(requestParameters);
        gVar.a(str);
    }

    @Deprecated
    public void setFeedBiddingData(RequestParameters requestParameters, String str, FeedAdListener feedAdListener) {
        g gVar = new g(this.mContext, getAdPlacemenId(requestParameters), new ad(feedAdListener), this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.isCacheVideoOnlyWifi);
        gVar.a(new ak());
        gVar.a(requestParameters);
        gVar.a(str);
    }

    @Deprecated
    public void setPortraitVideoBiddingData(RequestParameters requestParameters, String str, PortraitVideoAdListener portraitVideoAdListener) {
        g gVar = new g(this.mContext, new ad(portraitVideoAdListener), new de(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.isCacheVideoOnlyWifi);
        gVar.a(new ak());
        gVar.a(requestParameters);
        gVar.a(str);
    }

    public BaiduNativeManager(Context context, String str, int i10) {
        this(context, str, true, i10);
    }

    public void loadBidAdForPortraitVideo(String str, FeedAdListener feedAdListener) {
        loadBiddingAd(this.mRequestParameters, IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, str, feedAdListener, null);
    }

    public void loadPortraitVideoAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        g gVar = new g(this.mContext, new ad(feedAdListener), new de(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.isCacheVideoOnlyWifi);
        gVar.a(new ak());
        gVar.b(requestParameters);
    }

    public BaiduNativeManager(Context context, String str, boolean z10) {
        this(context, str, z10, FEED_TIMEOUT);
    }

    public BaiduNativeManager(Context context, String str, boolean z10, int i10) {
        this.isCacheVideoOnlyWifi = false;
        this.mBidFloor = -1;
        this.mContext = context;
        this.mAdPlacementId = str;
        this.isCacheVideo = z10;
        this.mTimeoutMillis = i10;
    }
}
