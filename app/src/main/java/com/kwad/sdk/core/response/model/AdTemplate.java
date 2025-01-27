package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.u;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

@KsJson
/* loaded from: classes2.dex */
public class AdTemplate extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    private static final long serialVersionUID = -5413539480595883024L;
    public long adLoadTotalTime;
    public long adShowStartTimeStamp;
    public int adStyle;
    public int contentType;
    public long downloadDuration;
    public String extra;
    public String impAdExtra;
    public boolean inPlayAgain;
    public long llsid;
    public long loadDataTime;
    public SceneImpl mAdScene;
    public long mBidEcpm;
    private BusinessType mBusinessType;
    public long mCurPlayTime;
    public transient boolean mDownloadFinishReported;
    public int mInitVoiceStatus;
    public String mOriginJString;
    public PageInfo mPageInfo;
    public int mPhotoResponseType;
    public transient boolean mPvReported;
    public transient boolean mTrackUrlReported;
    public boolean notNetworkRequest;
    public long posId;
    public int realShowType;
    public long showStartTime;

    @Nullable
    public TKAdLiveShopItemInfo tkLiveShopItemInfo;
    public int type;
    public List<AdInfo> adInfoList = new ArrayList();
    public PhotoInfo photoInfo = createPhotoInfo();
    public int positionShow = -1;
    public transient int adxResult = -1;
    private int serverPosition = -1;
    public boolean mIsFromContent = false;
    public boolean hasEnterAdWebViewLandPageActivity = false;
    public boolean mHasReportVideoLoad = false;
    public String mUniqueId = "";
    public boolean mHasSelected = false;
    public transient int downloadSource = 2;
    public transient String installFrom = "";
    public int mMediaPlayerType = 0;
    public VideoPlayerStatus mVideoPlayerStatus = new VideoPlayerStatus();
    public long mOutClickTimeParam = -1;
    public volatile long mVisibleTimeParam = -1;
    public int mIsLeftSlipStatus = 0;
    public boolean interactLandingPageShowing = false;
    public boolean mIsForceJumpLandingPage = false;
    public boolean mAdWebVideoPageShowing = false;
    public boolean mIsAudioEnable = false;
    public boolean mRewardVerifyCalled = false;
    public boolean mCheatingFlow = false;
    public boolean mXiaomiAppStoreDetailViewOpen = false;
    public boolean isWebViewDownload = false;
    public AdTemplate mPlayAgain = null;
    public boolean isPlayAgainData = false;
    public boolean watched = false;
    public boolean converted = false;
    public boolean fromCache = false;
    protected transient Map<String, Object> mLocalParams = new HashMap();

    @NonNull
    public AdStatusInfo mAdStatusInfo = new AdStatusInfo();

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject != null) {
            if (TextUtils.isEmpty(this.mOriginJString)) {
                this.mOriginJString = jSONObject.toString();
            }
            PhotoInfo createPhotoInfo = createPhotoInfo();
            createPhotoInfo.parseJson(jSONObject.optJSONObject("photoInfo"));
            setPhotoInfo(createPhotoInfo);
        }
        this.realShowType = this.contentType;
        if (TextUtils.isEmpty(this.mUniqueId)) {
            this.mUniqueId = String.valueOf(UUID.randomUUID());
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        t.a(jSONObject, "photoInfo", this.photoInfo);
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void beforeToJson(JSONObject jSONObject) {
        super.beforeToJson(jSONObject);
        if (TextUtils.isEmpty(this.mOriginJString)) {
            return;
        }
        try {
            u.merge(jSONObject, new JSONObject(this.mOriginJString));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    protected PhotoInfo createPhotoInfo() {
        return new PhotoInfo();
    }

    public boolean equals(@Nullable Object obj) {
        return obj instanceof AdTemplate ? this.mUniqueId.equals(((AdTemplate) obj).mUniqueId) : super.equals(obj);
    }

    public BusinessType getBusinessType() {
        BusinessType businessType = this.mBusinessType;
        if (businessType != null) {
            return businessType;
        }
        SceneImpl sceneImpl = this.mAdScene;
        if (sceneImpl != null) {
            this.mBusinessType = KSLoggerReporter.bv(sceneImpl.getAdStyle());
        }
        return this.mBusinessType;
    }

    public long getDownloadFinishTime() {
        return this.mAdStatusInfo.getDownloadFinishTime();
    }

    public long getDownloadSize() {
        return this.mAdStatusInfo.getDownloadSize();
    }

    public int getDownloadType() {
        return this.mAdStatusInfo.getDownloadType();
    }

    public long getLoadDataTime() {
        return this.mAdStatusInfo.getLoadDataTime();
    }

    @Nullable
    public <T> T getLocalParams(String str) {
        T t;
        if (TextUtils.isEmpty(str) || (t = (T) this.mLocalParams.get(str)) == null) {
            return null;
        }
        return t;
    }

    public Map<String, Object> getLocalParams() {
        return this.mLocalParams;
    }

    public AdTemplate getPlayAgain() {
        return this.mPlayAgain;
    }

    public int getServerPosition() {
        int i2 = this.serverPosition;
        return i2 != -1 ? i2 : getShowPosition();
    }

    public int getShowPosition() {
        return this.positionShow;
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    public long getmCurPlayTime() {
        return this.mCurPlayTime;
    }

    public boolean hasPlayAgain() {
        return this.mPlayAgain != null;
    }

    public int hashCode() {
        String str = this.mUniqueId;
        return str != null ? str.hashCode() : super.hashCode();
    }

    public boolean isLoadFromCache() {
        return this.mAdStatusInfo.isLoadFromCache();
    }

    @Nullable
    public Object putLocalParams(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mLocalParams.put(str, obj);
    }

    public void setCheatingFlow(boolean z) {
        if (this.mCheatingFlow) {
            return;
        }
        this.mCheatingFlow = z;
    }

    public void setDownloadFinishTime(long j2) {
        this.mAdStatusInfo.setDownloadFinishTime(j2);
    }

    public void setDownloadSize(long j2) {
        this.mAdStatusInfo.setDownloadSize(j2);
    }

    public void setDownloadType(int i2) {
        this.mAdStatusInfo.setDownloadType(i2);
    }

    public void setLoadDataTime(long j2) {
        this.mAdStatusInfo.setLoadDataTime(j2);
    }

    public void setLoadFromCache(boolean z) {
        this.mAdStatusInfo.setLoadFromCache(z);
    }

    protected void setPhotoInfo(PhotoInfo photoInfo) {
        this.photoInfo = photoInfo;
    }

    public void setPlayAgain(AdTemplate adTemplate) {
        this.mPlayAgain = adTemplate;
    }

    public void setServerPosition(int i2) {
        if (this.serverPosition == -1) {
            this.serverPosition = i2;
        }
    }

    public void setShowPosition(int i2) {
        this.positionShow = i2;
    }

    public void setmCurPlayTime(long j2) {
        this.mCurPlayTime = j2;
    }
}
