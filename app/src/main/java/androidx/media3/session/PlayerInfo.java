package androidx.media3.session;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.CheckResult;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Bundleable;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.session.PlayerInfo;
import b5.r;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* loaded from: classes.dex */
public class PlayerInfo implements Bundleable {
    public static final Bundleable.Creator<PlayerInfo> CREATOR;
    public static final PlayerInfo DEFAULT;
    public static final int DISCONTINUITY_REASON_DEFAULT = 0;
    private static final String FIELD_AUDIO_ATTRIBUTES;
    private static final String FIELD_CUE_GROUP;
    private static final String FIELD_CURRENT_TRACKS;
    private static final String FIELD_DEVICE_INFO;
    private static final String FIELD_DEVICE_MUTED;
    private static final String FIELD_DEVICE_VOLUME;
    private static final String FIELD_DISCONTINUITY_REASON;
    private static final String FIELD_IS_LOADING;
    private static final String FIELD_IS_PLAYING;
    private static final String FIELD_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    private static final String FIELD_MEDIA_ITEM_TRANSITION_REASON;
    private static final String FIELD_MEDIA_METADATA;
    private static final String FIELD_NEW_POSITION_INFO;
    private static final String FIELD_OLD_POSITION_INFO;
    private static final String FIELD_PLAYBACK_ERROR;
    private static final String FIELD_PLAYBACK_PARAMETERS;
    private static final String FIELD_PLAYBACK_STATE;
    private static final String FIELD_PLAYBACK_SUPPRESSION_REASON;
    private static final String FIELD_PLAYLIST_METADATA;
    private static final String FIELD_PLAY_WHEN_READY;
    private static final String FIELD_PLAY_WHEN_READY_CHANGED_REASON;
    private static final String FIELD_REPEAT_MODE;
    private static final String FIELD_SEEK_BACK_INCREMENT_MS;
    private static final String FIELD_SEEK_FORWARD_INCREMENT_MS;
    private static final String FIELD_SESSION_POSITION_INFO;
    private static final String FIELD_SHUFFLE_MODE_ENABLED;
    private static final String FIELD_TIMELINE;
    private static final String FIELD_TRACK_SELECTION_PARAMETERS;
    private static final String FIELD_VIDEO_SIZE;
    private static final String FIELD_VOLUME;
    public static final int MEDIA_ITEM_TRANSITION_REASON_DEFAULT = 0;
    public static final int PLAY_WHEN_READY_CHANGE_REASON_DEFAULT = 1;
    public final AudioAttributes audioAttributes;
    public final CueGroup cueGroup;
    public final Tracks currentTracks;
    public final DeviceInfo deviceInfo;
    public final boolean deviceMuted;
    public final int deviceVolume;
    public final int discontinuityReason;
    public final boolean isLoading;
    public final boolean isPlaying;
    public final long maxSeekToPreviousPositionMs;
    public final int mediaItemTransitionReason;
    public final MediaMetadata mediaMetadata;
    public final Player.PositionInfo newPositionInfo;
    public final Player.PositionInfo oldPositionInfo;
    public final boolean playWhenReady;
    public final int playWhenReadyChangedReason;
    public final PlaybackParameters playbackParameters;
    public final int playbackState;
    public final int playbackSuppressionReason;

    @Nullable
    public final PlaybackException playerError;
    public final MediaMetadata playlistMetadata;
    public final int repeatMode;
    public final long seekBackIncrementMs;
    public final long seekForwardIncrementMs;
    public final SessionPositionInfo sessionPositionInfo;
    public final boolean shuffleModeEnabled;
    public final Timeline timeline;
    public final TrackSelectionParameters trackSelectionParameters;
    public final VideoSize videoSize;
    public final float volume;

    public static class Builder {
        private AudioAttributes audioAttributes;
        private CueGroup cueGroup;
        private Tracks currentTracks;
        private DeviceInfo deviceInfo;
        private boolean deviceMuted;
        private int deviceVolume;
        private int discontinuityReason;
        private boolean isLoading;
        private boolean isPlaying;
        private long maxSeekToPreviousPositionMs;
        private int mediaItemTransitionReason;
        private MediaMetadata mediaMetadata;
        private Player.PositionInfo newPositionInfo;
        private Player.PositionInfo oldPositionInfo;
        private boolean playWhenReady;
        private int playWhenReadyChangedReason;
        private PlaybackParameters playbackParameters;
        private int playbackState;
        private int playbackSuppressionReason;

        @Nullable
        private PlaybackException playerError;
        private MediaMetadata playlistMetadata;
        private int repeatMode;
        private long seekBackIncrementMs;
        private long seekForwardIncrementMs;
        private SessionPositionInfo sessionPositionInfo;
        private boolean shuffleModeEnabled;
        private Timeline timeline;
        private TrackSelectionParameters trackSelectionParameters;
        private VideoSize videoSize;
        private float volume;

        public Builder(PlayerInfo playerInfo) {
            this.playerError = playerInfo.playerError;
            this.mediaItemTransitionReason = playerInfo.mediaItemTransitionReason;
            this.sessionPositionInfo = playerInfo.sessionPositionInfo;
            this.oldPositionInfo = playerInfo.oldPositionInfo;
            this.newPositionInfo = playerInfo.newPositionInfo;
            this.discontinuityReason = playerInfo.discontinuityReason;
            this.playbackParameters = playerInfo.playbackParameters;
            this.repeatMode = playerInfo.repeatMode;
            this.shuffleModeEnabled = playerInfo.shuffleModeEnabled;
            this.timeline = playerInfo.timeline;
            this.videoSize = playerInfo.videoSize;
            this.playlistMetadata = playerInfo.playlistMetadata;
            this.volume = playerInfo.volume;
            this.audioAttributes = playerInfo.audioAttributes;
            this.cueGroup = playerInfo.cueGroup;
            this.deviceInfo = playerInfo.deviceInfo;
            this.deviceVolume = playerInfo.deviceVolume;
            this.deviceMuted = playerInfo.deviceMuted;
            this.playWhenReady = playerInfo.playWhenReady;
            this.playWhenReadyChangedReason = playerInfo.playWhenReadyChangedReason;
            this.isPlaying = playerInfo.isPlaying;
            this.isLoading = playerInfo.isLoading;
            this.playbackSuppressionReason = playerInfo.playbackSuppressionReason;
            this.playbackState = playerInfo.playbackState;
            this.mediaMetadata = playerInfo.mediaMetadata;
            this.seekBackIncrementMs = playerInfo.seekBackIncrementMs;
            this.seekForwardIncrementMs = playerInfo.seekForwardIncrementMs;
            this.maxSeekToPreviousPositionMs = playerInfo.maxSeekToPreviousPositionMs;
            this.currentTracks = playerInfo.currentTracks;
            this.trackSelectionParameters = playerInfo.trackSelectionParameters;
        }

        public PlayerInfo build() {
            Assertions.checkState(this.timeline.isEmpty() || this.sessionPositionInfo.positionInfo.mediaItemIndex < this.timeline.getWindowCount());
            return new PlayerInfo(this.playerError, this.mediaItemTransitionReason, this.sessionPositionInfo, this.oldPositionInfo, this.newPositionInfo, this.discontinuityReason, this.playbackParameters, this.repeatMode, this.shuffleModeEnabled, this.videoSize, this.timeline, this.playlistMetadata, this.volume, this.audioAttributes, this.cueGroup, this.deviceInfo, this.deviceVolume, this.deviceMuted, this.playWhenReady, this.playWhenReadyChangedReason, this.playbackSuppressionReason, this.playbackState, this.isPlaying, this.isLoading, this.mediaMetadata, this.seekBackIncrementMs, this.seekForwardIncrementMs, this.maxSeekToPreviousPositionMs, this.currentTracks, this.trackSelectionParameters);
        }

        @CanIgnoreReturnValue
        public Builder setAudioAttributes(AudioAttributes audioAttributes) {
            this.audioAttributes = audioAttributes;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setCues(CueGroup cueGroup) {
            this.cueGroup = cueGroup;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setCurrentTracks(Tracks tracks) {
            this.currentTracks = tracks;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setDeviceInfo(DeviceInfo deviceInfo) {
            this.deviceInfo = deviceInfo;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setDeviceMuted(boolean z10) {
            this.deviceMuted = z10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setDeviceVolume(int i10) {
            this.deviceVolume = i10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setDiscontinuityReason(int i10) {
            this.discontinuityReason = i10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setIsLoading(boolean z10) {
            this.isLoading = z10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setIsPlaying(boolean z10) {
            this.isPlaying = z10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMaxSeekToPreviousPositionMs(long j10) {
            this.maxSeekToPreviousPositionMs = j10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMediaItemTransitionReason(int i10) {
            this.mediaItemTransitionReason = i10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMediaMetadata(MediaMetadata mediaMetadata) {
            this.mediaMetadata = mediaMetadata;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setNewPositionInfo(Player.PositionInfo positionInfo) {
            this.newPositionInfo = positionInfo;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setOldPositionInfo(Player.PositionInfo positionInfo) {
            this.oldPositionInfo = positionInfo;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPlayWhenReady(boolean z10) {
            this.playWhenReady = z10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPlayWhenReadyChangedReason(int i10) {
            this.playWhenReadyChangedReason = i10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPlaybackParameters(PlaybackParameters playbackParameters) {
            this.playbackParameters = playbackParameters;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPlaybackState(int i10) {
            this.playbackState = i10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPlaybackSuppressionReason(int i10) {
            this.playbackSuppressionReason = i10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPlayerError(@Nullable PlaybackException playbackException) {
            this.playerError = playbackException;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPlaylistMetadata(MediaMetadata mediaMetadata) {
            this.playlistMetadata = mediaMetadata;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setRepeatMode(int i10) {
            this.repeatMode = i10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSeekBackIncrement(long j10) {
            this.seekBackIncrementMs = j10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSeekForwardIncrement(long j10) {
            this.seekForwardIncrementMs = j10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSessionPositionInfo(SessionPositionInfo sessionPositionInfo) {
            this.sessionPositionInfo = sessionPositionInfo;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setShuffleModeEnabled(boolean z10) {
            this.shuffleModeEnabled = z10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setTimeline(Timeline timeline) {
            this.timeline = timeline;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
            this.trackSelectionParameters = trackSelectionParameters;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setVideoSize(VideoSize videoSize) {
            this.videoSize = videoSize;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setVolume(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
            this.volume = f10;
            return this;
        }
    }

    public static class BundlingExclusions implements Bundleable {
        public final boolean areCurrentTracksExcluded;
        public final boolean isTimelineExcluded;
        public static final BundlingExclusions NONE = new BundlingExclusions(false, false);
        private static final String FIELD_IS_TIMELINE_EXCLUDED = Util.intToStringMaxRadix(0);
        private static final String FIELD_ARE_CURRENT_TRACKS_EXCLUDED = Util.intToStringMaxRadix(1);
        public static final Bundleable.Creator<BundlingExclusions> CREATOR = new Bundleable.Creator() { // from class: p0.b0
            @Override // androidx.media3.common.Bundleable.Creator
            public final Bundleable fromBundle(Bundle bundle) {
                PlayerInfo.BundlingExclusions lambda$static$0;
                lambda$static$0 = PlayerInfo.BundlingExclusions.lambda$static$0(bundle);
                return lambda$static$0;
            }
        };

        public BundlingExclusions(boolean z10, boolean z11) {
            this.isTimelineExcluded = z10;
            this.areCurrentTracksExcluded = z11;
        }

        public static /* synthetic */ BundlingExclusions lambda$static$0(Bundle bundle) {
            return new BundlingExclusions(bundle.getBoolean(FIELD_IS_TIMELINE_EXCLUDED, false), bundle.getBoolean(FIELD_ARE_CURRENT_TRACKS_EXCLUDED, false));
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BundlingExclusions)) {
                return false;
            }
            BundlingExclusions bundlingExclusions = (BundlingExclusions) obj;
            return this.isTimelineExcluded == bundlingExclusions.isTimelineExcluded && this.areCurrentTracksExcluded == bundlingExclusions.areCurrentTracksExcluded;
        }

        public int hashCode() {
            return r.b(Boolean.valueOf(this.isTimelineExcluded), Boolean.valueOf(this.areCurrentTracksExcluded));
        }

        @Override // androidx.media3.common.Bundleable
        @UnstableApi
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putBoolean(FIELD_IS_TIMELINE_EXCLUDED, this.isTimelineExcluded);
            bundle.putBoolean(FIELD_ARE_CURRENT_TRACKS_EXCLUDED, this.areCurrentTracksExcluded);
            return bundle;
        }
    }

    static {
        SessionPositionInfo sessionPositionInfo = SessionPositionInfo.DEFAULT;
        Player.PositionInfo positionInfo = SessionPositionInfo.DEFAULT_POSITION_INFO;
        PlaybackParameters playbackParameters = PlaybackParameters.DEFAULT;
        VideoSize videoSize = VideoSize.UNKNOWN;
        Timeline timeline = Timeline.EMPTY;
        MediaMetadata mediaMetadata = MediaMetadata.EMPTY;
        DEFAULT = new PlayerInfo(null, 0, sessionPositionInfo, positionInfo, positionInfo, 0, playbackParameters, 0, false, videoSize, timeline, mediaMetadata, 1.0f, AudioAttributes.DEFAULT, CueGroup.EMPTY_TIME_ZERO, DeviceInfo.UNKNOWN, 0, false, false, 1, 0, 1, false, false, mediaMetadata, 0L, 0L, 0L, Tracks.EMPTY, TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT);
        FIELD_PLAYBACK_PARAMETERS = Util.intToStringMaxRadix(1);
        FIELD_REPEAT_MODE = Util.intToStringMaxRadix(2);
        FIELD_SHUFFLE_MODE_ENABLED = Util.intToStringMaxRadix(3);
        FIELD_TIMELINE = Util.intToStringMaxRadix(4);
        FIELD_VIDEO_SIZE = Util.intToStringMaxRadix(5);
        FIELD_PLAYLIST_METADATA = Util.intToStringMaxRadix(6);
        FIELD_VOLUME = Util.intToStringMaxRadix(7);
        FIELD_AUDIO_ATTRIBUTES = Util.intToStringMaxRadix(8);
        FIELD_DEVICE_INFO = Util.intToStringMaxRadix(9);
        FIELD_DEVICE_VOLUME = Util.intToStringMaxRadix(10);
        FIELD_DEVICE_MUTED = Util.intToStringMaxRadix(11);
        FIELD_PLAY_WHEN_READY = Util.intToStringMaxRadix(12);
        FIELD_PLAY_WHEN_READY_CHANGED_REASON = Util.intToStringMaxRadix(13);
        FIELD_PLAYBACK_SUPPRESSION_REASON = Util.intToStringMaxRadix(14);
        FIELD_PLAYBACK_STATE = Util.intToStringMaxRadix(15);
        FIELD_IS_PLAYING = Util.intToStringMaxRadix(16);
        FIELD_IS_LOADING = Util.intToStringMaxRadix(17);
        FIELD_PLAYBACK_ERROR = Util.intToStringMaxRadix(18);
        FIELD_SESSION_POSITION_INFO = Util.intToStringMaxRadix(19);
        FIELD_MEDIA_ITEM_TRANSITION_REASON = Util.intToStringMaxRadix(20);
        FIELD_OLD_POSITION_INFO = Util.intToStringMaxRadix(21);
        FIELD_NEW_POSITION_INFO = Util.intToStringMaxRadix(22);
        FIELD_DISCONTINUITY_REASON = Util.intToStringMaxRadix(23);
        FIELD_CUE_GROUP = Util.intToStringMaxRadix(24);
        FIELD_MEDIA_METADATA = Util.intToStringMaxRadix(25);
        FIELD_SEEK_BACK_INCREMENT_MS = Util.intToStringMaxRadix(26);
        FIELD_SEEK_FORWARD_INCREMENT_MS = Util.intToStringMaxRadix(27);
        FIELD_MAX_SEEK_TO_PREVIOUS_POSITION_MS = Util.intToStringMaxRadix(28);
        FIELD_TRACK_SELECTION_PARAMETERS = Util.intToStringMaxRadix(29);
        FIELD_CURRENT_TRACKS = Util.intToStringMaxRadix(30);
        CREATOR = new Bundleable.Creator() { // from class: androidx.media3.session.td
            @Override // androidx.media3.common.Bundleable.Creator
            public final Bundleable fromBundle(Bundle bundle) {
                PlayerInfo fromBundle;
                fromBundle = PlayerInfo.fromBundle(bundle);
                return fromBundle;
            }
        };
    }

    public PlayerInfo(@Nullable PlaybackException playbackException, int i10, SessionPositionInfo sessionPositionInfo, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i11, PlaybackParameters playbackParameters, int i12, boolean z10, VideoSize videoSize, Timeline timeline, MediaMetadata mediaMetadata, float f10, AudioAttributes audioAttributes, CueGroup cueGroup, DeviceInfo deviceInfo, int i13, boolean z11, boolean z12, int i14, int i15, int i16, boolean z13, boolean z14, MediaMetadata mediaMetadata2, long j10, long j11, long j12, Tracks tracks, TrackSelectionParameters trackSelectionParameters) {
        this.playerError = playbackException;
        this.mediaItemTransitionReason = i10;
        this.sessionPositionInfo = sessionPositionInfo;
        this.oldPositionInfo = positionInfo;
        this.newPositionInfo = positionInfo2;
        this.discontinuityReason = i11;
        this.playbackParameters = playbackParameters;
        this.repeatMode = i12;
        this.shuffleModeEnabled = z10;
        this.videoSize = videoSize;
        this.timeline = timeline;
        this.playlistMetadata = mediaMetadata;
        this.volume = f10;
        this.audioAttributes = audioAttributes;
        this.cueGroup = cueGroup;
        this.deviceInfo = deviceInfo;
        this.deviceVolume = i13;
        this.deviceMuted = z11;
        this.playWhenReady = z12;
        this.playWhenReadyChangedReason = i14;
        this.playbackSuppressionReason = i15;
        this.playbackState = i16;
        this.isPlaying = z13;
        this.isLoading = z14;
        this.mediaMetadata = mediaMetadata2;
        this.seekBackIncrementMs = j10;
        this.seekForwardIncrementMs = j11;
        this.maxSeekToPreviousPositionMs = j12;
        this.currentTracks = tracks;
        this.trackSelectionParameters = trackSelectionParameters;
    }

    public static PlayerInfo fromBundle(Bundle bundle) {
        AudioAttributes audioAttributes;
        CueGroup fromBundle;
        CueGroup cueGroup;
        DeviceInfo fromBundle2;
        boolean z10;
        MediaMetadata fromBundle3;
        Bundle bundle2 = bundle.getBundle(FIELD_PLAYBACK_ERROR);
        PlaybackException fromBundle4 = bundle2 == null ? null : PlaybackException.CREATOR.fromBundle(bundle2);
        int i10 = bundle.getInt(FIELD_MEDIA_ITEM_TRANSITION_REASON, 0);
        Bundle bundle3 = bundle.getBundle(FIELD_SESSION_POSITION_INFO);
        SessionPositionInfo fromBundle5 = bundle3 == null ? SessionPositionInfo.DEFAULT : SessionPositionInfo.CREATOR.fromBundle(bundle3);
        Bundle bundle4 = bundle.getBundle(FIELD_OLD_POSITION_INFO);
        Player.PositionInfo fromBundle6 = bundle4 == null ? SessionPositionInfo.DEFAULT_POSITION_INFO : Player.PositionInfo.CREATOR.fromBundle(bundle4);
        Bundle bundle5 = bundle.getBundle(FIELD_NEW_POSITION_INFO);
        Player.PositionInfo fromBundle7 = bundle5 == null ? SessionPositionInfo.DEFAULT_POSITION_INFO : Player.PositionInfo.CREATOR.fromBundle(bundle5);
        int i11 = bundle.getInt(FIELD_DISCONTINUITY_REASON, 0);
        Bundle bundle6 = bundle.getBundle(FIELD_PLAYBACK_PARAMETERS);
        PlaybackParameters fromBundle8 = bundle6 == null ? PlaybackParameters.DEFAULT : PlaybackParameters.CREATOR.fromBundle(bundle6);
        int i12 = bundle.getInt(FIELD_REPEAT_MODE, 0);
        boolean z11 = bundle.getBoolean(FIELD_SHUFFLE_MODE_ENABLED, false);
        Bundle bundle7 = bundle.getBundle(FIELD_TIMELINE);
        Timeline fromBundle9 = bundle7 == null ? Timeline.EMPTY : Timeline.CREATOR.fromBundle(bundle7);
        Bundle bundle8 = bundle.getBundle(FIELD_VIDEO_SIZE);
        VideoSize fromBundle10 = bundle8 == null ? VideoSize.UNKNOWN : VideoSize.CREATOR.fromBundle(bundle8);
        Bundle bundle9 = bundle.getBundle(FIELD_PLAYLIST_METADATA);
        MediaMetadata fromBundle11 = bundle9 == null ? MediaMetadata.EMPTY : MediaMetadata.CREATOR.fromBundle(bundle9);
        float f10 = bundle.getFloat(FIELD_VOLUME, 1.0f);
        Bundle bundle10 = bundle.getBundle(FIELD_AUDIO_ATTRIBUTES);
        AudioAttributes fromBundle12 = bundle10 == null ? AudioAttributes.DEFAULT : AudioAttributes.CREATOR.fromBundle(bundle10);
        Bundle bundle11 = bundle.getBundle(FIELD_CUE_GROUP);
        if (bundle11 == null) {
            audioAttributes = fromBundle12;
            fromBundle = CueGroup.EMPTY_TIME_ZERO;
        } else {
            audioAttributes = fromBundle12;
            fromBundle = CueGroup.CREATOR.fromBundle(bundle11);
        }
        Bundle bundle12 = bundle.getBundle(FIELD_DEVICE_INFO);
        if (bundle12 == null) {
            cueGroup = fromBundle;
            fromBundle2 = DeviceInfo.UNKNOWN;
        } else {
            cueGroup = fromBundle;
            fromBundle2 = DeviceInfo.CREATOR.fromBundle(bundle12);
        }
        DeviceInfo deviceInfo = fromBundle2;
        int i13 = bundle.getInt(FIELD_DEVICE_VOLUME, 0);
        boolean z12 = bundle.getBoolean(FIELD_DEVICE_MUTED, false);
        boolean z13 = bundle.getBoolean(FIELD_PLAY_WHEN_READY, false);
        int i14 = bundle.getInt(FIELD_PLAY_WHEN_READY_CHANGED_REASON, 1);
        int i15 = bundle.getInt(FIELD_PLAYBACK_SUPPRESSION_REASON, 0);
        int i16 = bundle.getInt(FIELD_PLAYBACK_STATE, 1);
        boolean z14 = bundle.getBoolean(FIELD_IS_PLAYING, false);
        boolean z15 = bundle.getBoolean(FIELD_IS_LOADING, false);
        Bundle bundle13 = bundle.getBundle(FIELD_MEDIA_METADATA);
        if (bundle13 == null) {
            z10 = z15;
            fromBundle3 = MediaMetadata.EMPTY;
        } else {
            z10 = z15;
            fromBundle3 = MediaMetadata.CREATOR.fromBundle(bundle13);
        }
        long j10 = bundle.getLong(FIELD_SEEK_BACK_INCREMENT_MS, 0L);
        long j11 = bundle.getLong(FIELD_SEEK_FORWARD_INCREMENT_MS, 0L);
        long j12 = bundle.getLong(FIELD_MAX_SEEK_TO_PREVIOUS_POSITION_MS, 0L);
        Bundle bundle14 = bundle.getBundle(FIELD_CURRENT_TRACKS);
        Tracks fromBundle13 = bundle14 == null ? Tracks.EMPTY : Tracks.CREATOR.fromBundle(bundle14);
        Bundle bundle15 = bundle.getBundle(FIELD_TRACK_SELECTION_PARAMETERS);
        return new PlayerInfo(fromBundle4, i10, fromBundle5, fromBundle6, fromBundle7, i11, fromBundle8, i12, z11, fromBundle10, fromBundle9, fromBundle11, f10, audioAttributes, cueGroup, deviceInfo, i13, z12, z13, i14, i15, i16, z14, z10, fromBundle3, j10, j11, j12, fromBundle13, bundle15 == null ? TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT : TrackSelectionParameters.fromBundle(bundle15));
    }

    private boolean isPlaying(int i10, boolean z10, int i11) {
        return i10 == 3 && z10 && i11 == 0;
    }

    @CheckResult
    public PlayerInfo copyWithAudioAttributes(AudioAttributes audioAttributes) {
        return new Builder(this).setAudioAttributes(audioAttributes).build();
    }

    public PlayerInfo copyWithCurrentTracks(Tracks tracks) {
        return new Builder(this).setCurrentTracks(tracks).build();
    }

    @CheckResult
    public PlayerInfo copyWithDeviceInfo(DeviceInfo deviceInfo) {
        return new Builder(this).setDeviceInfo(deviceInfo).build();
    }

    @CheckResult
    public PlayerInfo copyWithDeviceVolume(int i10, boolean z10) {
        return new Builder(this).setDeviceVolume(i10).setDeviceMuted(z10).build();
    }

    @CheckResult
    public PlayerInfo copyWithIsLoading(boolean z10) {
        return new Builder(this).setIsLoading(z10).build();
    }

    @CheckResult
    public PlayerInfo copyWithIsPlaying(boolean z10) {
        return new Builder(this).setIsPlaying(z10).build();
    }

    @CheckResult
    public PlayerInfo copyWithMaxSeekToPreviousPositionMs(long j10) {
        return new Builder(this).setMaxSeekToPreviousPositionMs(j10).build();
    }

    @CheckResult
    public PlayerInfo copyWithMediaItemTransitionReason(int i10) {
        return new Builder(this).setMediaItemTransitionReason(i10).build();
    }

    @CheckResult
    public PlayerInfo copyWithMediaMetadata(MediaMetadata mediaMetadata) {
        return new Builder(this).setMediaMetadata(mediaMetadata).build();
    }

    @CheckResult
    public PlayerInfo copyWithPlayWhenReady(boolean z10, int i10, int i11) {
        return new Builder(this).setPlayWhenReady(z10).setPlayWhenReadyChangedReason(i10).setPlaybackSuppressionReason(i11).setIsPlaying(isPlaying(this.playbackState, z10, i11)).build();
    }

    @CheckResult
    public PlayerInfo copyWithPlaybackParameters(PlaybackParameters playbackParameters) {
        return new Builder(this).setPlaybackParameters(playbackParameters).build();
    }

    @CheckResult
    public PlayerInfo copyWithPlaybackState(int i10, @Nullable PlaybackException playbackException) {
        return new Builder(this).setPlayerError(playbackException).setPlaybackState(i10).setIsPlaying(isPlaying(i10, this.playWhenReady, this.playbackSuppressionReason)).build();
    }

    @CheckResult
    public PlayerInfo copyWithPlayerError(PlaybackException playbackException) {
        return new Builder(this).setPlayerError(playbackException).build();
    }

    @CheckResult
    public PlayerInfo copyWithPlaylistMetadata(MediaMetadata mediaMetadata) {
        return new Builder(this).setPlaylistMetadata(mediaMetadata).build();
    }

    @CheckResult
    public PlayerInfo copyWithPositionInfos(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i10) {
        return new Builder(this).setOldPositionInfo(positionInfo).setNewPositionInfo(positionInfo2).setDiscontinuityReason(i10).build();
    }

    @CheckResult
    public PlayerInfo copyWithRepeatMode(int i10) {
        return new Builder(this).setRepeatMode(i10).build();
    }

    @CheckResult
    public PlayerInfo copyWithSeekBackIncrement(long j10) {
        return new Builder(this).setSeekBackIncrement(j10).build();
    }

    @CheckResult
    public PlayerInfo copyWithSeekForwardIncrement(long j10) {
        return new Builder(this).setSeekForwardIncrement(j10).build();
    }

    @CheckResult
    public PlayerInfo copyWithSessionPositionInfo(SessionPositionInfo sessionPositionInfo) {
        return new Builder(this).setSessionPositionInfo(sessionPositionInfo).build();
    }

    @CheckResult
    public PlayerInfo copyWithShuffleModeEnabled(boolean z10) {
        return new Builder(this).setShuffleModeEnabled(z10).build();
    }

    @CheckResult
    public PlayerInfo copyWithTimeline(Timeline timeline) {
        return new Builder(this).setTimeline(timeline).build();
    }

    @CheckResult
    public PlayerInfo copyWithTimelineAndMediaItemIndex(Timeline timeline, int i10) {
        Builder timeline2 = new Builder(this).setTimeline(timeline);
        Player.PositionInfo positionInfo = this.sessionPositionInfo.positionInfo;
        Player.PositionInfo positionInfo2 = new Player.PositionInfo(positionInfo.windowUid, i10, positionInfo.mediaItem, positionInfo.periodUid, positionInfo.periodIndex, positionInfo.positionMs, positionInfo.contentPositionMs, positionInfo.adGroupIndex, positionInfo.adIndexInAdGroup);
        boolean z10 = this.sessionPositionInfo.isPlayingAd;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        SessionPositionInfo sessionPositionInfo = this.sessionPositionInfo;
        return timeline2.setSessionPositionInfo(new SessionPositionInfo(positionInfo2, z10, elapsedRealtime, sessionPositionInfo.durationMs, sessionPositionInfo.bufferedPositionMs, sessionPositionInfo.bufferedPercentage, sessionPositionInfo.totalBufferedDurationMs, sessionPositionInfo.currentLiveOffsetMs, sessionPositionInfo.contentDurationMs, sessionPositionInfo.contentBufferedPositionMs)).build();
    }

    @CheckResult
    public PlayerInfo copyWithTimelineAndSessionPositionInfo(Timeline timeline, SessionPositionInfo sessionPositionInfo) {
        return new Builder(this).setTimeline(timeline).setSessionPositionInfo(sessionPositionInfo).build();
    }

    @CheckResult
    public PlayerInfo copyWithTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        return new Builder(this).setTrackSelectionParameters(trackSelectionParameters).build();
    }

    @CheckResult
    public PlayerInfo copyWithVideoSize(VideoSize videoSize) {
        return new Builder(this).setVideoSize(videoSize).build();
    }

    @CheckResult
    public PlayerInfo copyWithVolume(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return new Builder(this).setVolume(f10).build();
    }

    @Nullable
    public MediaItem getCurrentMediaItem() {
        if (this.timeline.isEmpty()) {
            return null;
        }
        return this.timeline.getWindow(this.sessionPositionInfo.positionInfo.mediaItemIndex, new Timeline.Window()).mediaItem;
    }

    public Bundle toBundle(Player.Commands commands, boolean z10, boolean z11) {
        Bundle bundle = new Bundle();
        boolean contains = commands.contains(16);
        boolean contains2 = commands.contains(17);
        PlaybackException playbackException = this.playerError;
        if (playbackException != null) {
            bundle.putBundle(FIELD_PLAYBACK_ERROR, playbackException.toBundle());
        }
        bundle.putInt(FIELD_MEDIA_ITEM_TRANSITION_REASON, this.mediaItemTransitionReason);
        bundle.putBundle(FIELD_SESSION_POSITION_INFO, this.sessionPositionInfo.toBundle(contains, contains2));
        bundle.putBundle(FIELD_OLD_POSITION_INFO, this.oldPositionInfo.toBundle(contains, contains2));
        bundle.putBundle(FIELD_NEW_POSITION_INFO, this.newPositionInfo.toBundle(contains, contains2));
        bundle.putInt(FIELD_DISCONTINUITY_REASON, this.discontinuityReason);
        bundle.putBundle(FIELD_PLAYBACK_PARAMETERS, this.playbackParameters.toBundle());
        bundle.putInt(FIELD_REPEAT_MODE, this.repeatMode);
        bundle.putBoolean(FIELD_SHUFFLE_MODE_ENABLED, this.shuffleModeEnabled);
        if (!z10 && contains2) {
            bundle.putBundle(FIELD_TIMELINE, this.timeline.toBundle());
        } else if (!contains2 && contains && !this.timeline.isEmpty()) {
            bundle.putBundle(FIELD_TIMELINE, this.timeline.toBundleWithOneWindowOnly(this.sessionPositionInfo.positionInfo.mediaItemIndex));
        }
        bundle.putBundle(FIELD_VIDEO_SIZE, this.videoSize.toBundle());
        if (commands.contains(18)) {
            bundle.putBundle(FIELD_PLAYLIST_METADATA, this.playlistMetadata.toBundle());
        }
        if (commands.contains(22)) {
            bundle.putFloat(FIELD_VOLUME, this.volume);
        }
        if (commands.contains(21)) {
            bundle.putBundle(FIELD_AUDIO_ATTRIBUTES, this.audioAttributes.toBundle());
        }
        if (commands.contains(28)) {
            bundle.putBundle(FIELD_CUE_GROUP, this.cueGroup.toBundle());
        }
        bundle.putBundle(FIELD_DEVICE_INFO, this.deviceInfo.toBundle());
        if (commands.contains(23)) {
            bundle.putInt(FIELD_DEVICE_VOLUME, this.deviceVolume);
            bundle.putBoolean(FIELD_DEVICE_MUTED, this.deviceMuted);
        }
        bundle.putBoolean(FIELD_PLAY_WHEN_READY, this.playWhenReady);
        bundle.putInt(FIELD_PLAYBACK_SUPPRESSION_REASON, this.playbackSuppressionReason);
        bundle.putInt(FIELD_PLAYBACK_STATE, this.playbackState);
        bundle.putBoolean(FIELD_IS_PLAYING, this.isPlaying);
        bundle.putBoolean(FIELD_IS_LOADING, this.isLoading);
        if (commands.contains(18)) {
            bundle.putBundle(FIELD_MEDIA_METADATA, this.mediaMetadata.toBundle());
        }
        bundle.putLong(FIELD_SEEK_BACK_INCREMENT_MS, this.seekBackIncrementMs);
        bundle.putLong(FIELD_SEEK_FORWARD_INCREMENT_MS, this.seekForwardIncrementMs);
        bundle.putLong(FIELD_MAX_SEEK_TO_PREVIOUS_POSITION_MS, this.maxSeekToPreviousPositionMs);
        if (!z11 && commands.contains(30)) {
            bundle.putBundle(FIELD_CURRENT_TRACKS, this.currentTracks.toBundle());
        }
        bundle.putBundle(FIELD_TRACK_SELECTION_PARAMETERS, this.trackSelectionParameters.toBundle());
        return bundle;
    }

    @Override // androidx.media3.common.Bundleable
    public Bundle toBundle() {
        return toBundle(new Player.Commands.Builder().addAllCommands().build(), false, false);
    }
}
