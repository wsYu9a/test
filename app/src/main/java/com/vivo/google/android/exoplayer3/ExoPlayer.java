package com.vivo.google.android.exoplayer3;

import androidx.annotation.Nullable;
import com.vivo.google.android.exoplayer3.source.MediaSource;
import com.vivo.google.android.exoplayer3.source.TrackGroupArray;
import com.vivo.google.android.exoplayer3.trackselection.TrackSelectionArray;

/* loaded from: classes4.dex */
public interface ExoPlayer {
    public static final int STATE_BUFFERING = 2;
    public static final int STATE_ENDED = 4;
    public static final int STATE_IDLE = 1;
    public static final int STATE_READY = 3;

    public interface EventListener {
        void onLoadingChanged(boolean z);

        void onPlaybackParametersChanged(PlaybackParameters playbackParameters);

        void onPlayerError(ExoPlaybackException exoPlaybackException);

        void onPlayerStateChanged(boolean z, int i2);

        void onPositionDiscontinuity();

        void onTimelineChanged(Timeline timeline, Object obj);

        void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray);
    }

    public interface ExoPlayerComponent {
        void handleMessage(int i2, Object obj);
    }

    public static final class ExoPlayerMessage {
        public final Object message;
        public final int messageType;
        public final ExoPlayerComponent target;

        public ExoPlayerMessage(ExoPlayerComponent exoPlayerComponent, int i2, Object obj) {
            this.target = exoPlayerComponent;
            this.messageType = i2;
            this.message = obj;
        }
    }

    void addListener(EventListener eventListener);

    void blockingSendMessages(ExoPlayerMessage... exoPlayerMessageArr);

    int getBufferedPercentage();

    long getBufferedPosition();

    Object getCurrentManifest();

    int getCurrentPeriodIndex();

    long getCurrentPosition();

    Timeline getCurrentTimeline();

    TrackGroupArray getCurrentTrackGroups();

    TrackSelectionArray getCurrentTrackSelections();

    int getCurrentWindowIndex();

    long getDuration();

    boolean getPlayWhenReady();

    PlaybackParameters getPlaybackParameters();

    int getPlaybackState();

    int getRendererCount();

    int getRendererType(int i2);

    boolean isCurrentWindowDynamic();

    boolean isCurrentWindowSeekable();

    boolean isLoading();

    void prepare(MediaSource mediaSource);

    void prepare(MediaSource mediaSource, boolean z, boolean z2);

    void release();

    void removeListener(EventListener eventListener);

    void seekTo(int i2, long j2);

    void seekTo(long j2);

    void seekToDefaultPosition();

    void seekToDefaultPosition(int i2);

    void sendMessages(ExoPlayerMessage... exoPlayerMessageArr);

    void setPlayWhenReady(boolean z);

    void setPlaybackParameters(@Nullable PlaybackParameters playbackParameters);

    void stop();
}
