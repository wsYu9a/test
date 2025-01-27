package com.heytap.nearx.cloudconfig.stat;

import com.heytap.nearx.track.IExceptionProcess;
import com.heytap.nearx.track.INetworkAdapter;
import com.heytap.nearx.track.TrackContext;
import com.heytap.nearx.track.event.AccumulateTrackEvent;
import com.heytap.nearx.track.event.DurationTrackEvent;
import com.heytap.nearx.track.event.TrackEvent;
import com.heytap.nearx.track.internal.db.ExceptionEntity;
import com.heytap.nearx.track.internal.extension.TrackExtKt;

/* loaded from: classes.dex */
public class TrackApi_20246 {

    public static final class NearxAccumulateTrack extends AccumulateTrackEvent<NearxAccumulateTrack> {
        private NearxAccumulateTrack(String str, String str2) {
            super(str, str2);
        }

        public static NearxAccumulateTrack obtain(String str, String str2) {
            return new NearxAccumulateTrack(str, str2);
        }

        public void commit() {
            commit(TrackApi_20246.getContext());
        }
    }

    public static final class NearxDurationTrack extends DurationTrackEvent<NearxDurationTrack> {
        private NearxDurationTrack(String str, String str2) {
            super(str, str2);
        }

        public static NearxDurationTrack obtain(String str, String str2) {
            return new NearxDurationTrack(str, str2);
        }

        public void endCommit() {
            endCommit(TrackApi_20246.getContext());
        }
    }

    public static final class NearxTrack extends TrackEvent<NearxTrack> {
        private NearxTrack(String str, String str2) {
            super(str, str2);
        }

        public static NearxTrack obtain(String str, String str2) {
            return new NearxTrack(str, str2);
        }

        public void commit() {
            commit(TrackApi_20246.getContext());
        }
    }

    private TrackApi_20246() {
    }

    public static void forceUploadByUser() {
        TrackExtKt.executeIO(new Runnable() { // from class: com.heytap.nearx.cloudconfig.stat.TrackApi_20246.6
            @Override // java.lang.Runnable
            public void run() {
                TrackApi_20246.getContext().startUpload();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TrackContext getContext() {
        return TrackContext.get(20246L);
    }

    public static void recordException(final ExceptionEntity exceptionEntity) {
        TrackExtKt.executeIO(new Runnable() { // from class: com.heytap.nearx.cloudconfig.stat.TrackApi_20246.4
            @Override // java.lang.Runnable
            public void run() {
                TrackApi_20246.getContext().recordException(exceptionEntity);
            }
        });
    }

    public static void removeExceptionProcess() {
        TrackExtKt.executeIO(new Runnable() { // from class: com.heytap.nearx.cloudconfig.stat.TrackApi_20246.3
            @Override // java.lang.Runnable
            public void run() {
                TrackApi_20246.getContext().removeExceptionProcess();
            }
        });
    }

    public static void setConfig(final TrackContext.ContextConfig contextConfig) {
        TrackExtKt.executeIO(new Runnable() { // from class: com.heytap.nearx.cloudconfig.stat.TrackApi_20246.1
            @Override // java.lang.Runnable
            public void run() {
                TrackApi_20246.getContext().setConfig(contextConfig);
            }
        });
    }

    public static void setExceptionProcess(final IExceptionProcess iExceptionProcess) {
        TrackExtKt.executeIO(new Runnable() { // from class: com.heytap.nearx.cloudconfig.stat.TrackApi_20246.2
            @Override // java.lang.Runnable
            public void run() {
                TrackApi_20246.getContext().setExceptionProcess(iExceptionProcess);
            }
        });
    }

    public static void setNetworkAdapter(final INetworkAdapter iNetworkAdapter) {
        TrackExtKt.executeIO(new Runnable() { // from class: com.heytap.nearx.cloudconfig.stat.TrackApi_20246.5
            @Override // java.lang.Runnable
            public void run() {
                TrackApi_20246.getContext().setNetworkAdapter(iNetworkAdapter);
            }
        });
    }
}
