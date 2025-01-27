package com.sigmob.windad;

/* loaded from: classes4.dex */
public interface WindAdDebugLogListener {

    public enum WindAdLogLevel {
        WindLogLevelError,
        WindLogLevelWarning,
        WindLogLevelInformation,
        WindLogLevelDebug
    }

    void windAdDebugLog(String str, WindAdLogLevel windAdLogLevel);
}
