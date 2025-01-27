package com.kwad.components.ad.reward.monitor;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;

@KsJson
/* loaded from: classes.dex */
public class RewardMonitorInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static final int DOWNLOAD_TYPE_ALL = 2;
    public static final int DOWNLOAD_TYPE_ONLINE = 1;
    public static final int DOWNLOAD_TYPE_PART = 3;
    public static final int LOAD_STATUS_DATA_FINISH = 2;
    public static final int LOAD_STATUS_FAIL = 4;
    public static final int LOAD_STATUS_LOAD_FINISH = 3;
    public static final int LOAD_STATUS_START = 1;
    public static final int LOAD_TYPE_LOCAL = 2;
    public static final int LOAD_TYPE_NET = 1;
    public static final int PAGE_STATUS_ENTRY = 1;
    public static final int PAGE_STATUS_SHOW = 2;
    public static final int PAGE_STATUS_SHOW_AD_CALL = 3;
    public static final int REWARD_TYPE_DEEP = 1;
    public static final int REWARD_TYPE_NORMAL = 0;
    public static final long serialVersionUID = 1080394611500009098L;
    public int adCount;
    public long creativeId;
    public long currentDuration;
    public long dataDownloadInterval;
    public long dataLoadInterval;
    public long downloadDuration;
    public long downloadSize;
    public int downloadType;
    public int errorCode;
    public String errorMsg;
    public long loadDataDuration;
    public int loadStatus;
    public int loadType;
    public int pageStatus;
    public long posId;
    public long renderDuration;
    public long totalDuration;
    public long videoDuration;
    public String videoUrl;
    public int rewardType = -1;
    public int taskType = -1;
    public int taskStep = -1;

    public RewardMonitorInfo(long j2) {
        this.posId = j2;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        int i2 = this.rewardType;
        if (i2 != -1) {
            t.putValue(jSONObject, "reward_type", i2);
        } else {
            jSONObject.remove("reward_type");
        }
        int i3 = this.taskType;
        if (i3 != -1) {
            t.putValue(jSONObject, "task_type", i3);
        } else {
            jSONObject.remove("task_type");
        }
        int i4 = this.taskStep;
        if (i4 != -1) {
            t.putValue(jSONObject, "task_step", i4);
        } else {
            jSONObject.remove("task_step");
        }
    }

    public RewardMonitorInfo setAdCount(int i2) {
        this.adCount = i2;
        return this;
    }

    public RewardMonitorInfo setCreativeId(long j2) {
        this.creativeId = j2;
        return this;
    }

    public RewardMonitorInfo setCurrentDuration(long j2) {
        this.currentDuration = j2;
        return this;
    }

    public RewardMonitorInfo setDataDownloadInterval(long j2) {
        this.dataDownloadInterval = j2;
        return this;
    }

    public RewardMonitorInfo setDataLoadInterval(long j2) {
        this.dataLoadInterval = j2;
        return this;
    }

    public RewardMonitorInfo setDownloadDuration(long j2) {
        this.downloadDuration = j2;
        return this;
    }

    public RewardMonitorInfo setDownloadSize(long j2) {
        this.downloadSize = j2;
        return this;
    }

    public RewardMonitorInfo setDownloadType(int i2) {
        this.downloadType = i2;
        return this;
    }

    public RewardMonitorInfo setErrorCode(int i2) {
        this.errorCode = i2;
        return this;
    }

    public RewardMonitorInfo setErrorMsg(String str) {
        this.errorMsg = str;
        return this;
    }

    public RewardMonitorInfo setLoadDataDuration(long j2) {
        this.loadDataDuration = j2;
        return this;
    }

    public RewardMonitorInfo setLoadStatus(int i2) {
        this.loadStatus = i2;
        return this;
    }

    public RewardMonitorInfo setLoadType(int i2) {
        this.loadType = i2;
        return this;
    }

    public RewardMonitorInfo setPageStatus(int i2) {
        this.pageStatus = i2;
        return this;
    }

    public RewardMonitorInfo setRenderDuration(long j2) {
        this.renderDuration = j2;
        return this;
    }

    public RewardMonitorInfo setRewardType(int i2) {
        this.rewardType = i2;
        return this;
    }

    public RewardMonitorInfo setTaskStep(int i2) {
        this.taskStep = i2;
        return this;
    }

    public RewardMonitorInfo setTaskType(int i2) {
        this.taskType = i2;
        return this;
    }

    public RewardMonitorInfo setTotalDuration(long j2) {
        this.totalDuration = j2;
        return this;
    }

    public RewardMonitorInfo setVideoDuration(long j2) {
        this.videoDuration = j2;
        return this;
    }

    public RewardMonitorInfo setVideoUrl(String str) {
        this.videoUrl = str;
        return this;
    }
}
