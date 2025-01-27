package com.kwad.sdk.commercial.model;

import android.os.Looper;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.kwai.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ap;
import java.io.Serializable;

@KsJson
/* loaded from: classes2.dex */
public class SDKInitMsg extends a implements Serializable {
    private static final int CHILD_PROCESS = 2;
    private static final int DYNAMIC_DISABLE = 2;
    private static final int DYNAMIC_ENABLE = 1;
    public static final int FAIL = 2;
    public static final int FINISH = 1;
    private static final int MAIN_PROCESS = 1;
    private static final int MAIN_THREAD = 1;
    public static final int START = 0;
    private static final int WORK_THREAD = 2;
    private static final long serialVersionUID = 368743526206619387L;
    public String errorReason;
    public int initCount;
    public int initProcess;
    public int initStatus;
    public int initThread;
    public int intBuildNumber;
    public int intDynamicSDK;
    public long launchIntervalTime;
    public long totalDurationTime;

    public SDKInitMsg() {
        this.initProcess = ap.isInMainProcess(ServiceProvider.getContext()) ? 1 : 2;
        this.initThread = Looper.getMainLooper() == Looper.myLooper() ? 1 : 2;
        this.intDynamicSDK = com.kwad.b.kwai.a.Yg.booleanValue() ? 1 : 2;
        this.intBuildNumber = 463;
    }

    public SDKInitMsg setErrorReason(String str) {
        this.errorReason = str;
        return this;
    }

    public SDKInitMsg setInitCount(int i2) {
        this.initCount = i2;
        return this;
    }

    public SDKInitMsg setInitStatus(int i2) {
        this.initStatus = i2;
        return this;
    }

    public SDKInitMsg setLaunchIntervalTime(long j2) {
        this.launchIntervalTime = j2;
        return this;
    }

    public SDKInitMsg setTotalDurationTime(long j2) {
        this.totalDurationTime = j2;
        return this;
    }
}
