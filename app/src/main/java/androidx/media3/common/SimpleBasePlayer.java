package androidx.media3.common;

import android.graphics.Rect;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.FlagSet;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.Timeline;
import androidx.media3.common.Tracks;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import b5.z;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import l5.c;
import m0.p0;
import m0.t2;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import p5.c0;
import p5.f;

@UnstableApi
/* loaded from: classes.dex */
public abstract class SimpleBasePlayer extends BasePlayer {
    private static final long POSITION_DISCONTINUITY_THRESHOLD_MS = 1000;
    private final HandlerWrapper applicationHandler;
    private final Looper applicationLooper;
    private final ListenerSet<Player.Listener> listeners;
    private final HashSet<c0<?>> pendingOperations;
    private final Timeline.Period period;
    private boolean released;
    private State state;

    public static final class MediaItemData {
        private final MediaMetadata combinedMediaMetadata;
        public final long defaultPositionUs;
        public final long durationUs;
        public final long elapsedRealtimeEpochOffsetMs;
        public final boolean isDynamic;
        public final boolean isPlaceholder;
        public final boolean isSeekable;

        @Nullable
        public final MediaItem.LiveConfiguration liveConfiguration;

        @Nullable
        public final Object manifest;
        public final MediaItem mediaItem;

        @Nullable
        public final MediaMetadata mediaMetadata;
        private final long[] periodPositionInWindowUs;
        public final ImmutableList<PeriodData> periods;
        public final long positionInFirstPeriodUs;
        public final long presentationStartTimeMs;
        public final Tracks tracks;
        public final Object uid;
        public final long windowStartTimeMs;

        public static final class Builder {
            private long defaultPositionUs;
            private long durationUs;
            private long elapsedRealtimeEpochOffsetMs;
            private boolean isDynamic;
            private boolean isPlaceholder;
            private boolean isSeekable;

            @Nullable
            private MediaItem.LiveConfiguration liveConfiguration;

            @Nullable
            private Object manifest;
            private MediaItem mediaItem;

            @Nullable
            private MediaMetadata mediaMetadata;
            private ImmutableList<PeriodData> periods;
            private long positionInFirstPeriodUs;
            private long presentationStartTimeMs;
            private Tracks tracks;
            private Object uid;
            private long windowStartTimeMs;

            public /* synthetic */ Builder(MediaItemData mediaItemData, AnonymousClass1 anonymousClass1) {
                this(mediaItemData);
            }

            public MediaItemData build() {
                return new MediaItemData(this);
            }

            @CanIgnoreReturnValue
            public Builder setDefaultPositionUs(long j10) {
                Assertions.checkArgument(j10 >= 0);
                this.defaultPositionUs = j10;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setDurationUs(long j10) {
                Assertions.checkArgument(j10 == C.TIME_UNSET || j10 >= 0);
                this.durationUs = j10;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setElapsedRealtimeEpochOffsetMs(long j10) {
                this.elapsedRealtimeEpochOffsetMs = j10;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setIsDynamic(boolean z10) {
                this.isDynamic = z10;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setIsPlaceholder(boolean z10) {
                this.isPlaceholder = z10;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setIsSeekable(boolean z10) {
                this.isSeekable = z10;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setLiveConfiguration(@Nullable MediaItem.LiveConfiguration liveConfiguration) {
                this.liveConfiguration = liveConfiguration;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setManifest(@Nullable Object obj) {
                this.manifest = obj;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setMediaItem(MediaItem mediaItem) {
                this.mediaItem = mediaItem;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setMediaMetadata(@Nullable MediaMetadata mediaMetadata) {
                this.mediaMetadata = mediaMetadata;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPeriods(List<PeriodData> list) {
                int size = list.size();
                int i10 = 0;
                while (i10 < size - 1) {
                    Assertions.checkArgument(list.get(i10).durationUs != C.TIME_UNSET, "Periods other than last need a duration");
                    int i11 = i10 + 1;
                    for (int i12 = i11; i12 < size; i12++) {
                        Assertions.checkArgument(!list.get(i10).uid.equals(list.get(i12).uid), "Duplicate PeriodData UIDs in period list");
                    }
                    i10 = i11;
                }
                this.periods = ImmutableList.copyOf((Collection) list);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPositionInFirstPeriodUs(long j10) {
                Assertions.checkArgument(j10 >= 0);
                this.positionInFirstPeriodUs = j10;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPresentationStartTimeMs(long j10) {
                this.presentationStartTimeMs = j10;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setTracks(Tracks tracks) {
                this.tracks = tracks;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setUid(Object obj) {
                this.uid = obj;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setWindowStartTimeMs(long j10) {
                this.windowStartTimeMs = j10;
                return this;
            }

            public Builder(Object obj) {
                this.uid = obj;
                this.tracks = Tracks.EMPTY;
                this.mediaItem = MediaItem.EMPTY;
                this.mediaMetadata = null;
                this.manifest = null;
                this.liveConfiguration = null;
                this.presentationStartTimeMs = C.TIME_UNSET;
                this.windowStartTimeMs = C.TIME_UNSET;
                this.elapsedRealtimeEpochOffsetMs = C.TIME_UNSET;
                this.isSeekable = false;
                this.isDynamic = false;
                this.defaultPositionUs = 0L;
                this.durationUs = C.TIME_UNSET;
                this.positionInFirstPeriodUs = 0L;
                this.isPlaceholder = false;
                this.periods = ImmutableList.of();
            }

            private Builder(MediaItemData mediaItemData) {
                this.uid = mediaItemData.uid;
                this.tracks = mediaItemData.tracks;
                this.mediaItem = mediaItemData.mediaItem;
                this.mediaMetadata = mediaItemData.mediaMetadata;
                this.manifest = mediaItemData.manifest;
                this.liveConfiguration = mediaItemData.liveConfiguration;
                this.presentationStartTimeMs = mediaItemData.presentationStartTimeMs;
                this.windowStartTimeMs = mediaItemData.windowStartTimeMs;
                this.elapsedRealtimeEpochOffsetMs = mediaItemData.elapsedRealtimeEpochOffsetMs;
                this.isSeekable = mediaItemData.isSeekable;
                this.isDynamic = mediaItemData.isDynamic;
                this.defaultPositionUs = mediaItemData.defaultPositionUs;
                this.durationUs = mediaItemData.durationUs;
                this.positionInFirstPeriodUs = mediaItemData.positionInFirstPeriodUs;
                this.isPlaceholder = mediaItemData.isPlaceholder;
                this.periods = mediaItemData.periods;
            }
        }

        public /* synthetic */ MediaItemData(Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        private static MediaMetadata getCombinedMediaMetadata(MediaItem mediaItem, Tracks tracks) {
            MediaMetadata.Builder builder = new MediaMetadata.Builder();
            int size = tracks.getGroups().size();
            for (int i10 = 0; i10 < size; i10++) {
                Tracks.Group group = tracks.getGroups().get(i10);
                for (int i11 = 0; i11 < group.length; i11++) {
                    if (group.isTrackSelected(i11)) {
                        Format trackFormat = group.getTrackFormat(i11);
                        if (trackFormat.metadata != null) {
                            for (int i12 = 0; i12 < trackFormat.metadata.length(); i12++) {
                                trackFormat.metadata.get(i12).populateMediaMetadata(builder);
                            }
                        }
                    }
                }
            }
            return builder.populate(mediaItem.mediaMetadata).build();
        }

        public Timeline.Period getPeriod(int i10, int i11, Timeline.Period period) {
            if (this.periods.isEmpty()) {
                Object obj = this.uid;
                period.set(obj, obj, i10, this.positionInFirstPeriodUs + this.durationUs, 0L, AdPlaybackState.NONE, this.isPlaceholder);
            } else {
                PeriodData periodData = this.periods.get(i11);
                Object obj2 = periodData.uid;
                period.set(obj2, Pair.create(this.uid, obj2), i10, periodData.durationUs, this.periodPositionInWindowUs[i11], periodData.adPlaybackState, periodData.isPlaceholder);
            }
            return period;
        }

        public Object getPeriodUid(int i10) {
            if (this.periods.isEmpty()) {
                return this.uid;
            }
            return Pair.create(this.uid, this.periods.get(i10).uid);
        }

        public Timeline.Window getWindow(int i10, Timeline.Window window) {
            window.set(this.uid, this.mediaItem, this.manifest, this.presentationStartTimeMs, this.windowStartTimeMs, this.elapsedRealtimeEpochOffsetMs, this.isSeekable, this.isDynamic, this.liveConfiguration, this.defaultPositionUs, this.durationUs, i10, (i10 + (this.periods.isEmpty() ? 1 : this.periods.size())) - 1, this.positionInFirstPeriodUs);
            window.isPlaceholder = this.isPlaceholder;
            return window;
        }

        public Builder buildUpon() {
            return new Builder();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MediaItemData)) {
                return false;
            }
            MediaItemData mediaItemData = (MediaItemData) obj;
            return this.uid.equals(mediaItemData.uid) && this.tracks.equals(mediaItemData.tracks) && this.mediaItem.equals(mediaItemData.mediaItem) && Util.areEqual(this.mediaMetadata, mediaItemData.mediaMetadata) && Util.areEqual(this.manifest, mediaItemData.manifest) && Util.areEqual(this.liveConfiguration, mediaItemData.liveConfiguration) && this.presentationStartTimeMs == mediaItemData.presentationStartTimeMs && this.windowStartTimeMs == mediaItemData.windowStartTimeMs && this.elapsedRealtimeEpochOffsetMs == mediaItemData.elapsedRealtimeEpochOffsetMs && this.isSeekable == mediaItemData.isSeekable && this.isDynamic == mediaItemData.isDynamic && this.defaultPositionUs == mediaItemData.defaultPositionUs && this.durationUs == mediaItemData.durationUs && this.positionInFirstPeriodUs == mediaItemData.positionInFirstPeriodUs && this.isPlaceholder == mediaItemData.isPlaceholder && this.periods.equals(mediaItemData.periods);
        }

        public int hashCode() {
            int hashCode = (((((217 + this.uid.hashCode()) * 31) + this.tracks.hashCode()) * 31) + this.mediaItem.hashCode()) * 31;
            MediaMetadata mediaMetadata = this.mediaMetadata;
            int hashCode2 = (hashCode + (mediaMetadata == null ? 0 : mediaMetadata.hashCode())) * 31;
            Object obj = this.manifest;
            int hashCode3 = (hashCode2 + (obj == null ? 0 : obj.hashCode())) * 31;
            MediaItem.LiveConfiguration liveConfiguration = this.liveConfiguration;
            int hashCode4 = (hashCode3 + (liveConfiguration != null ? liveConfiguration.hashCode() : 0)) * 31;
            long j10 = this.presentationStartTimeMs;
            int i10 = (hashCode4 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
            long j11 = this.windowStartTimeMs;
            int i11 = (i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.elapsedRealtimeEpochOffsetMs;
            int i12 = (((((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.isSeekable ? 1 : 0)) * 31) + (this.isDynamic ? 1 : 0)) * 31;
            long j13 = this.defaultPositionUs;
            int i13 = (i12 + ((int) (j13 ^ (j13 >>> 32)))) * 31;
            long j14 = this.durationUs;
            int i14 = (i13 + ((int) (j14 ^ (j14 >>> 32)))) * 31;
            long j15 = this.positionInFirstPeriodUs;
            return ((((i14 + ((int) (j15 ^ (j15 >>> 32)))) * 31) + (this.isPlaceholder ? 1 : 0)) * 31) + this.periods.hashCode();
        }

        private MediaItemData(Builder builder) {
            int i10 = 0;
            if (builder.liveConfiguration == null) {
                Assertions.checkArgument(builder.presentationStartTimeMs == C.TIME_UNSET, "presentationStartTimeMs can only be set if liveConfiguration != null");
                Assertions.checkArgument(builder.windowStartTimeMs == C.TIME_UNSET, "windowStartTimeMs can only be set if liveConfiguration != null");
                Assertions.checkArgument(builder.elapsedRealtimeEpochOffsetMs == C.TIME_UNSET, "elapsedRealtimeEpochOffsetMs can only be set if liveConfiguration != null");
            } else if (builder.presentationStartTimeMs != C.TIME_UNSET && builder.windowStartTimeMs != C.TIME_UNSET) {
                Assertions.checkArgument(builder.windowStartTimeMs >= builder.presentationStartTimeMs, "windowStartTimeMs can't be less than presentationStartTimeMs");
            }
            int size = builder.periods.size();
            if (builder.durationUs != C.TIME_UNSET) {
                Assertions.checkArgument(builder.defaultPositionUs <= builder.durationUs, "defaultPositionUs can't be greater than durationUs");
            }
            this.uid = builder.uid;
            this.tracks = builder.tracks;
            this.mediaItem = builder.mediaItem;
            this.mediaMetadata = builder.mediaMetadata;
            this.manifest = builder.manifest;
            this.liveConfiguration = builder.liveConfiguration;
            this.presentationStartTimeMs = builder.presentationStartTimeMs;
            this.windowStartTimeMs = builder.windowStartTimeMs;
            this.elapsedRealtimeEpochOffsetMs = builder.elapsedRealtimeEpochOffsetMs;
            this.isSeekable = builder.isSeekable;
            this.isDynamic = builder.isDynamic;
            this.defaultPositionUs = builder.defaultPositionUs;
            this.durationUs = builder.durationUs;
            long j10 = builder.positionInFirstPeriodUs;
            this.positionInFirstPeriodUs = j10;
            this.isPlaceholder = builder.isPlaceholder;
            ImmutableList<PeriodData> immutableList = builder.periods;
            this.periods = immutableList;
            long[] jArr = new long[immutableList.size()];
            this.periodPositionInWindowUs = jArr;
            if (!immutableList.isEmpty()) {
                jArr[0] = -j10;
                while (i10 < size - 1) {
                    long[] jArr2 = this.periodPositionInWindowUs;
                    int i11 = i10 + 1;
                    jArr2[i11] = jArr2[i10] + this.periods.get(i10).durationUs;
                    i10 = i11;
                }
            }
            MediaMetadata mediaMetadata = this.mediaMetadata;
            this.combinedMediaMetadata = mediaMetadata == null ? getCombinedMediaMetadata(this.mediaItem, this.tracks) : mediaMetadata;
        }
    }

    public static final class PeriodData {
        public final AdPlaybackState adPlaybackState;
        public final long durationUs;
        public final boolean isPlaceholder;
        public final Object uid;

        public static final class Builder {
            private AdPlaybackState adPlaybackState;
            private long durationUs;
            private boolean isPlaceholder;
            private Object uid;

            public /* synthetic */ Builder(PeriodData periodData, AnonymousClass1 anonymousClass1) {
                this(periodData);
            }

            public PeriodData build() {
                return new PeriodData(this);
            }

            @CanIgnoreReturnValue
            public Builder setAdPlaybackState(AdPlaybackState adPlaybackState) {
                this.adPlaybackState = adPlaybackState;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setDurationUs(long j10) {
                Assertions.checkArgument(j10 == C.TIME_UNSET || j10 >= 0);
                this.durationUs = j10;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setIsPlaceholder(boolean z10) {
                this.isPlaceholder = z10;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setUid(Object obj) {
                this.uid = obj;
                return this;
            }

            public Builder(Object obj) {
                this.uid = obj;
                this.durationUs = 0L;
                this.adPlaybackState = AdPlaybackState.NONE;
                this.isPlaceholder = false;
            }

            private Builder(PeriodData periodData) {
                this.uid = periodData.uid;
                this.durationUs = periodData.durationUs;
                this.adPlaybackState = periodData.adPlaybackState;
                this.isPlaceholder = periodData.isPlaceholder;
            }
        }

        public /* synthetic */ PeriodData(Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public Builder buildUpon() {
            return new Builder();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PeriodData)) {
                return false;
            }
            PeriodData periodData = (PeriodData) obj;
            return this.uid.equals(periodData.uid) && this.durationUs == periodData.durationUs && this.adPlaybackState.equals(periodData.adPlaybackState) && this.isPlaceholder == periodData.isPlaceholder;
        }

        public int hashCode() {
            int hashCode = (217 + this.uid.hashCode()) * 31;
            long j10 = this.durationUs;
            return ((((hashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31) + this.adPlaybackState.hashCode()) * 31) + (this.isPlaceholder ? 1 : 0);
        }

        private PeriodData(Builder builder) {
            this.uid = builder.uid;
            this.durationUs = builder.durationUs;
            this.adPlaybackState = builder.adPlaybackState;
            this.isPlaceholder = builder.isPlaceholder;
        }
    }

    public static final class PlaceholderUid {
        private PlaceholderUid() {
        }

        public /* synthetic */ PlaceholderUid(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static final class PlaylistTimeline extends Timeline {
        private final int[] firstPeriodIndexByWindowIndex;
        private final HashMap<Object, Integer> periodIndexByUid;
        private final ImmutableList<MediaItemData> playlist;
        private final int[] windowIndexByPeriodIndex;

        public PlaylistTimeline(ImmutableList<MediaItemData> immutableList) {
            int size = immutableList.size();
            this.playlist = immutableList;
            this.firstPeriodIndexByWindowIndex = new int[size];
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                MediaItemData mediaItemData = immutableList.get(i11);
                this.firstPeriodIndexByWindowIndex[i11] = i10;
                i10 += getPeriodCountInMediaItem(mediaItemData);
            }
            this.windowIndexByPeriodIndex = new int[i10];
            this.periodIndexByUid = new HashMap<>();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                MediaItemData mediaItemData2 = immutableList.get(i13);
                for (int i14 = 0; i14 < getPeriodCountInMediaItem(mediaItemData2); i14++) {
                    this.periodIndexByUid.put(mediaItemData2.getPeriodUid(i14), Integer.valueOf(i12));
                    this.windowIndexByPeriodIndex[i12] = i13;
                    i12++;
                }
            }
        }

        private static int getPeriodCountInMediaItem(MediaItemData mediaItemData) {
            if (mediaItemData.periods.isEmpty()) {
                return 1;
            }
            return mediaItemData.periods.size();
        }

        @Override // androidx.media3.common.Timeline
        public int getFirstWindowIndex(boolean z10) {
            return super.getFirstWindowIndex(z10);
        }

        @Override // androidx.media3.common.Timeline
        public int getIndexOfPeriod(Object obj) {
            Integer num = this.periodIndexByUid.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        @Override // androidx.media3.common.Timeline
        public int getLastWindowIndex(boolean z10) {
            return super.getLastWindowIndex(z10);
        }

        @Override // androidx.media3.common.Timeline
        public int getNextWindowIndex(int i10, int i11, boolean z10) {
            return super.getNextWindowIndex(i10, i11, z10);
        }

        @Override // androidx.media3.common.Timeline
        public Timeline.Period getPeriod(int i10, Timeline.Period period, boolean z10) {
            int i11 = this.windowIndexByPeriodIndex[i10];
            return this.playlist.get(i11).getPeriod(i11, i10 - this.firstPeriodIndexByWindowIndex[i11], period);
        }

        @Override // androidx.media3.common.Timeline
        public Timeline.Period getPeriodByUid(Object obj, Timeline.Period period) {
            return getPeriod(((Integer) Assertions.checkNotNull(this.periodIndexByUid.get(obj))).intValue(), period, true);
        }

        @Override // androidx.media3.common.Timeline
        public int getPeriodCount() {
            return this.windowIndexByPeriodIndex.length;
        }

        @Override // androidx.media3.common.Timeline
        public int getPreviousWindowIndex(int i10, int i11, boolean z10) {
            return super.getPreviousWindowIndex(i10, i11, z10);
        }

        @Override // androidx.media3.common.Timeline
        public Object getUidOfPeriod(int i10) {
            int i11 = this.windowIndexByPeriodIndex[i10];
            return this.playlist.get(i11).getPeriodUid(i10 - this.firstPeriodIndexByWindowIndex[i11]);
        }

        @Override // androidx.media3.common.Timeline
        public Timeline.Window getWindow(int i10, Timeline.Window window, long j10) {
            return this.playlist.get(i10).getWindow(this.firstPeriodIndexByWindowIndex[i10], window);
        }

        @Override // androidx.media3.common.Timeline
        public int getWindowCount() {
            return this.playlist.size();
        }
    }

    public interface PositionSupplier {
        public static final PositionSupplier ZERO = t2.a(0);

        long get();
    }

    public static final class State {
        public final PositionSupplier adBufferedPositionMsSupplier;
        public final PositionSupplier adPositionMsSupplier;
        public final AudioAttributes audioAttributes;
        public final Player.Commands availableCommands;
        public final PositionSupplier contentBufferedPositionMsSupplier;
        public final PositionSupplier contentPositionMsSupplier;
        public final int currentAdGroupIndex;
        public final int currentAdIndexInAdGroup;
        public final CueGroup currentCues;
        public final int currentMediaItemIndex;
        public final DeviceInfo deviceInfo;

        @IntRange(from = 0)
        public final int deviceVolume;
        public final long discontinuityPositionMs;
        public final boolean hasPositionDiscontinuity;
        public final boolean isDeviceMuted;
        public final boolean isLoading;
        public final long maxSeekToPreviousPositionMs;
        public final boolean newlyRenderedFirstFrame;
        public final boolean playWhenReady;
        public final int playWhenReadyChangeReason;
        public final PlaybackParameters playbackParameters;
        public final int playbackState;
        public final int playbackSuppressionReason;

        @Nullable
        public final PlaybackException playerError;
        public final ImmutableList<MediaItemData> playlist;
        public final MediaMetadata playlistMetadata;
        public final int positionDiscontinuityReason;
        public final int repeatMode;
        public final long seekBackIncrementMs;
        public final long seekForwardIncrementMs;
        public final boolean shuffleModeEnabled;
        public final Size surfaceSize;
        public final Metadata timedMetadata;
        public final Timeline timeline;
        public final PositionSupplier totalBufferedDurationMsSupplier;
        public final TrackSelectionParameters trackSelectionParameters;
        public final VideoSize videoSize;

        @FloatRange(from = c.f27899e, to = 1.0d)
        public final float volume;

        public static final class Builder {
            private PositionSupplier adBufferedPositionMsSupplier;

            @Nullable
            private Long adPositionMs;
            private PositionSupplier adPositionMsSupplier;
            private AudioAttributes audioAttributes;
            private Player.Commands availableCommands;
            private PositionSupplier contentBufferedPositionMsSupplier;

            @Nullable
            private Long contentPositionMs;
            private PositionSupplier contentPositionMsSupplier;
            private int currentAdGroupIndex;
            private int currentAdIndexInAdGroup;
            private CueGroup currentCues;
            private int currentMediaItemIndex;
            private DeviceInfo deviceInfo;
            private int deviceVolume;
            private long discontinuityPositionMs;
            private boolean hasPositionDiscontinuity;
            private boolean isDeviceMuted;
            private boolean isLoading;
            private long maxSeekToPreviousPositionMs;
            private boolean newlyRenderedFirstFrame;
            private boolean playWhenReady;
            private int playWhenReadyChangeReason;
            private PlaybackParameters playbackParameters;
            private int playbackState;
            private int playbackSuppressionReason;

            @Nullable
            private PlaybackException playerError;
            private ImmutableList<MediaItemData> playlist;
            private MediaMetadata playlistMetadata;
            private int positionDiscontinuityReason;
            private int repeatMode;
            private long seekBackIncrementMs;
            private long seekForwardIncrementMs;
            private boolean shuffleModeEnabled;
            private Size surfaceSize;
            private Metadata timedMetadata;
            private Timeline timeline;
            private PositionSupplier totalBufferedDurationMsSupplier;
            private TrackSelectionParameters trackSelectionParameters;
            private VideoSize videoSize;
            private float volume;

            public /* synthetic */ Builder(State state, AnonymousClass1 anonymousClass1) {
                this(state);
            }

            public State build() {
                return new State(this);
            }

            @CanIgnoreReturnValue
            public Builder clearPositionDiscontinuity() {
                this.hasPositionDiscontinuity = false;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setAdBufferedPositionMs(PositionSupplier positionSupplier) {
                this.adBufferedPositionMsSupplier = positionSupplier;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setAdPositionMs(long j10) {
                this.adPositionMs = Long.valueOf(j10);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setAudioAttributes(AudioAttributes audioAttributes) {
                this.audioAttributes = audioAttributes;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setAvailableCommands(Player.Commands commands) {
                this.availableCommands = commands;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setContentBufferedPositionMs(PositionSupplier positionSupplier) {
                this.contentBufferedPositionMsSupplier = positionSupplier;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setContentPositionMs(long j10) {
                this.contentPositionMs = Long.valueOf(j10);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setCurrentAd(int i10, int i11) {
                Assertions.checkArgument((i10 == -1) == (i11 == -1));
                this.currentAdGroupIndex = i10;
                this.currentAdIndexInAdGroup = i11;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setCurrentCues(CueGroup cueGroup) {
                this.currentCues = cueGroup;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setCurrentMediaItemIndex(int i10) {
                this.currentMediaItemIndex = i10;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setDeviceInfo(DeviceInfo deviceInfo) {
                this.deviceInfo = deviceInfo;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setDeviceVolume(@IntRange(from = 0) int i10) {
                Assertions.checkArgument(i10 >= 0);
                this.deviceVolume = i10;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setIsDeviceMuted(boolean z10) {
                this.isDeviceMuted = z10;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setIsLoading(boolean z10) {
                this.isLoading = z10;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setMaxSeekToPreviousPositionMs(long j10) {
                this.maxSeekToPreviousPositionMs = j10;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setNewlyRenderedFirstFrame(boolean z10) {
                this.newlyRenderedFirstFrame = z10;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPlayWhenReady(boolean z10, int i10) {
                this.playWhenReady = z10;
                this.playWhenReadyChangeReason = i10;
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
            public Builder setPlaylist(List<MediaItemData> list) {
                HashSet hashSet = new HashSet();
                for (int i10 = 0; i10 < list.size(); i10++) {
                    Assertions.checkArgument(hashSet.add(list.get(i10).uid), "Duplicate MediaItemData UID in playlist");
                }
                this.playlist = ImmutableList.copyOf((Collection) list);
                this.timeline = new PlaylistTimeline(this.playlist);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPlaylistMetadata(MediaMetadata mediaMetadata) {
                this.playlistMetadata = mediaMetadata;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPositionDiscontinuity(int i10, long j10) {
                this.hasPositionDiscontinuity = true;
                this.positionDiscontinuityReason = i10;
                this.discontinuityPositionMs = j10;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setRepeatMode(int i10) {
                this.repeatMode = i10;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setSeekBackIncrementMs(long j10) {
                this.seekBackIncrementMs = j10;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setSeekForwardIncrementMs(long j10) {
                this.seekForwardIncrementMs = j10;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setShuffleModeEnabled(boolean z10) {
                this.shuffleModeEnabled = z10;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setSurfaceSize(Size size) {
                this.surfaceSize = size;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setTimedMetadata(Metadata metadata) {
                this.timedMetadata = metadata;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setTotalBufferedDurationMs(PositionSupplier positionSupplier) {
                this.totalBufferedDurationMsSupplier = positionSupplier;
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
                Assertions.checkArgument(f10 >= 0.0f && f10 <= 1.0f);
                this.volume = f10;
                return this;
            }

            public Builder() {
                this.availableCommands = Player.Commands.EMPTY;
                this.playWhenReady = false;
                this.playWhenReadyChangeReason = 1;
                this.playbackState = 1;
                this.playbackSuppressionReason = 0;
                this.playerError = null;
                this.repeatMode = 0;
                this.shuffleModeEnabled = false;
                this.isLoading = false;
                this.seekBackIncrementMs = 5000L;
                this.seekForwardIncrementMs = C.DEFAULT_SEEK_FORWARD_INCREMENT_MS;
                this.maxSeekToPreviousPositionMs = 3000L;
                this.playbackParameters = PlaybackParameters.DEFAULT;
                this.trackSelectionParameters = TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT;
                this.audioAttributes = AudioAttributes.DEFAULT;
                this.volume = 1.0f;
                this.videoSize = VideoSize.UNKNOWN;
                this.currentCues = CueGroup.EMPTY_TIME_ZERO;
                this.deviceInfo = DeviceInfo.UNKNOWN;
                this.deviceVolume = 0;
                this.isDeviceMuted = false;
                this.surfaceSize = Size.UNKNOWN;
                this.newlyRenderedFirstFrame = false;
                this.timedMetadata = new Metadata(C.TIME_UNSET, new Metadata.Entry[0]);
                this.playlist = ImmutableList.of();
                this.timeline = Timeline.EMPTY;
                this.playlistMetadata = MediaMetadata.EMPTY;
                this.currentMediaItemIndex = -1;
                this.currentAdGroupIndex = -1;
                this.currentAdIndexInAdGroup = -1;
                this.contentPositionMs = null;
                this.contentPositionMsSupplier = t2.a(C.TIME_UNSET);
                this.adPositionMs = null;
                PositionSupplier positionSupplier = PositionSupplier.ZERO;
                this.adPositionMsSupplier = positionSupplier;
                this.contentBufferedPositionMsSupplier = t2.a(C.TIME_UNSET);
                this.adBufferedPositionMsSupplier = positionSupplier;
                this.totalBufferedDurationMsSupplier = positionSupplier;
                this.hasPositionDiscontinuity = false;
                this.positionDiscontinuityReason = 5;
                this.discontinuityPositionMs = 0L;
            }

            @CanIgnoreReturnValue
            public Builder setAdPositionMs(PositionSupplier positionSupplier) {
                this.adPositionMs = null;
                this.adPositionMsSupplier = positionSupplier;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setContentPositionMs(PositionSupplier positionSupplier) {
                this.contentPositionMs = null;
                this.contentPositionMsSupplier = positionSupplier;
                return this;
            }

            private Builder(State state) {
                this.availableCommands = state.availableCommands;
                this.playWhenReady = state.playWhenReady;
                this.playWhenReadyChangeReason = state.playWhenReadyChangeReason;
                this.playbackState = state.playbackState;
                this.playbackSuppressionReason = state.playbackSuppressionReason;
                this.playerError = state.playerError;
                this.repeatMode = state.repeatMode;
                this.shuffleModeEnabled = state.shuffleModeEnabled;
                this.isLoading = state.isLoading;
                this.seekBackIncrementMs = state.seekBackIncrementMs;
                this.seekForwardIncrementMs = state.seekForwardIncrementMs;
                this.maxSeekToPreviousPositionMs = state.maxSeekToPreviousPositionMs;
                this.playbackParameters = state.playbackParameters;
                this.trackSelectionParameters = state.trackSelectionParameters;
                this.audioAttributes = state.audioAttributes;
                this.volume = state.volume;
                this.videoSize = state.videoSize;
                this.currentCues = state.currentCues;
                this.deviceInfo = state.deviceInfo;
                this.deviceVolume = state.deviceVolume;
                this.isDeviceMuted = state.isDeviceMuted;
                this.surfaceSize = state.surfaceSize;
                this.newlyRenderedFirstFrame = state.newlyRenderedFirstFrame;
                this.timedMetadata = state.timedMetadata;
                this.playlist = state.playlist;
                this.timeline = state.timeline;
                this.playlistMetadata = state.playlistMetadata;
                this.currentMediaItemIndex = state.currentMediaItemIndex;
                this.currentAdGroupIndex = state.currentAdGroupIndex;
                this.currentAdIndexInAdGroup = state.currentAdIndexInAdGroup;
                this.contentPositionMs = null;
                this.contentPositionMsSupplier = state.contentPositionMsSupplier;
                this.adPositionMs = null;
                this.adPositionMsSupplier = state.adPositionMsSupplier;
                this.contentBufferedPositionMsSupplier = state.contentBufferedPositionMsSupplier;
                this.adBufferedPositionMsSupplier = state.adBufferedPositionMsSupplier;
                this.totalBufferedDurationMsSupplier = state.totalBufferedDurationMsSupplier;
                this.hasPositionDiscontinuity = state.hasPositionDiscontinuity;
                this.positionDiscontinuityReason = state.positionDiscontinuityReason;
                this.discontinuityPositionMs = state.discontinuityPositionMs;
            }
        }

        public /* synthetic */ State(Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public Builder buildUpon() {
            return new Builder();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return this.playWhenReady == state.playWhenReady && this.playWhenReadyChangeReason == state.playWhenReadyChangeReason && this.availableCommands.equals(state.availableCommands) && this.playbackState == state.playbackState && this.playbackSuppressionReason == state.playbackSuppressionReason && Util.areEqual(this.playerError, state.playerError) && this.repeatMode == state.repeatMode && this.shuffleModeEnabled == state.shuffleModeEnabled && this.isLoading == state.isLoading && this.seekBackIncrementMs == state.seekBackIncrementMs && this.seekForwardIncrementMs == state.seekForwardIncrementMs && this.maxSeekToPreviousPositionMs == state.maxSeekToPreviousPositionMs && this.playbackParameters.equals(state.playbackParameters) && this.trackSelectionParameters.equals(state.trackSelectionParameters) && this.audioAttributes.equals(state.audioAttributes) && this.volume == state.volume && this.videoSize.equals(state.videoSize) && this.currentCues.equals(state.currentCues) && this.deviceInfo.equals(state.deviceInfo) && this.deviceVolume == state.deviceVolume && this.isDeviceMuted == state.isDeviceMuted && this.surfaceSize.equals(state.surfaceSize) && this.newlyRenderedFirstFrame == state.newlyRenderedFirstFrame && this.timedMetadata.equals(state.timedMetadata) && this.playlist.equals(state.playlist) && this.playlistMetadata.equals(state.playlistMetadata) && this.currentMediaItemIndex == state.currentMediaItemIndex && this.currentAdGroupIndex == state.currentAdGroupIndex && this.currentAdIndexInAdGroup == state.currentAdIndexInAdGroup && this.contentPositionMsSupplier.equals(state.contentPositionMsSupplier) && this.adPositionMsSupplier.equals(state.adPositionMsSupplier) && this.contentBufferedPositionMsSupplier.equals(state.contentBufferedPositionMsSupplier) && this.adBufferedPositionMsSupplier.equals(state.adBufferedPositionMsSupplier) && this.totalBufferedDurationMsSupplier.equals(state.totalBufferedDurationMsSupplier) && this.hasPositionDiscontinuity == state.hasPositionDiscontinuity && this.positionDiscontinuityReason == state.positionDiscontinuityReason && this.discontinuityPositionMs == state.discontinuityPositionMs;
        }

        public int hashCode() {
            int hashCode = (((((((((217 + this.availableCommands.hashCode()) * 31) + (this.playWhenReady ? 1 : 0)) * 31) + this.playWhenReadyChangeReason) * 31) + this.playbackState) * 31) + this.playbackSuppressionReason) * 31;
            PlaybackException playbackException = this.playerError;
            int hashCode2 = (((((((hashCode + (playbackException == null ? 0 : playbackException.hashCode())) * 31) + this.repeatMode) * 31) + (this.shuffleModeEnabled ? 1 : 0)) * 31) + (this.isLoading ? 1 : 0)) * 31;
            long j10 = this.seekBackIncrementMs;
            int i10 = (hashCode2 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
            long j11 = this.seekForwardIncrementMs;
            int i11 = (i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.maxSeekToPreviousPositionMs;
            int hashCode3 = (((((((((((((((((((((((((((((((((((((((((((((((((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + this.playbackParameters.hashCode()) * 31) + this.trackSelectionParameters.hashCode()) * 31) + this.audioAttributes.hashCode()) * 31) + Float.floatToRawIntBits(this.volume)) * 31) + this.videoSize.hashCode()) * 31) + this.currentCues.hashCode()) * 31) + this.deviceInfo.hashCode()) * 31) + this.deviceVolume) * 31) + (this.isDeviceMuted ? 1 : 0)) * 31) + this.surfaceSize.hashCode()) * 31) + (this.newlyRenderedFirstFrame ? 1 : 0)) * 31) + this.timedMetadata.hashCode()) * 31) + this.playlist.hashCode()) * 31) + this.playlistMetadata.hashCode()) * 31) + this.currentMediaItemIndex) * 31) + this.currentAdGroupIndex) * 31) + this.currentAdIndexInAdGroup) * 31) + this.contentPositionMsSupplier.hashCode()) * 31) + this.adPositionMsSupplier.hashCode()) * 31) + this.contentBufferedPositionMsSupplier.hashCode()) * 31) + this.adBufferedPositionMsSupplier.hashCode()) * 31) + this.totalBufferedDurationMsSupplier.hashCode()) * 31) + (this.hasPositionDiscontinuity ? 1 : 0)) * 31) + this.positionDiscontinuityReason) * 31;
            long j13 = this.discontinuityPositionMs;
            return hashCode3 + ((int) (j13 ^ (j13 >>> 32)));
        }

        private State(Builder builder) {
            int i10;
            if (builder.timeline.isEmpty()) {
                Assertions.checkArgument(builder.playbackState == 1 || builder.playbackState == 4, "Empty playlist only allowed in STATE_IDLE or STATE_ENDED");
                Assertions.checkArgument(builder.currentAdGroupIndex == -1 && builder.currentAdIndexInAdGroup == -1, "Ads not allowed if playlist is empty");
            } else {
                int i11 = builder.currentMediaItemIndex;
                if (i11 == -1) {
                    i10 = 0;
                } else {
                    Assertions.checkArgument(builder.currentMediaItemIndex < builder.timeline.getWindowCount(), "currentMediaItemIndex must be less than playlist.size()");
                    i10 = i11;
                }
                if (builder.currentAdGroupIndex != -1) {
                    Timeline.Period period = new Timeline.Period();
                    builder.timeline.getPeriod(SimpleBasePlayer.getPeriodIndexFromWindowPosition(builder.timeline, i10, builder.contentPositionMs != null ? builder.contentPositionMs.longValue() : builder.contentPositionMsSupplier.get(), new Timeline.Window(), period), period);
                    Assertions.checkArgument(builder.currentAdGroupIndex < period.getAdGroupCount(), "PeriodData has less ad groups than adGroupIndex");
                    int adCountInAdGroup = period.getAdCountInAdGroup(builder.currentAdGroupIndex);
                    if (adCountInAdGroup != -1) {
                        Assertions.checkArgument(builder.currentAdIndexInAdGroup < adCountInAdGroup, "Ad group has less ads than adIndexInGroupIndex");
                    }
                }
            }
            if (builder.playerError != null) {
                Assertions.checkArgument(builder.playbackState == 1, "Player error only allowed in STATE_IDLE");
            }
            if (builder.playbackState == 1 || builder.playbackState == 4) {
                Assertions.checkArgument(!builder.isLoading, "isLoading only allowed when not in STATE_IDLE or STATE_ENDED");
            }
            PositionSupplier b10 = builder.contentPositionMs != null ? (builder.currentAdGroupIndex == -1 && builder.playWhenReady && builder.playbackState == 3 && builder.playbackSuppressionReason == 0 && builder.contentPositionMs.longValue() != C.TIME_UNSET) ? t2.b(builder.contentPositionMs.longValue(), builder.playbackParameters.speed) : t2.a(builder.contentPositionMs.longValue()) : builder.contentPositionMsSupplier;
            PositionSupplier b11 = builder.adPositionMs != null ? (builder.currentAdGroupIndex != -1 && builder.playWhenReady && builder.playbackState == 3 && builder.playbackSuppressionReason == 0) ? t2.b(builder.adPositionMs.longValue(), 1.0f) : t2.a(builder.adPositionMs.longValue()) : builder.adPositionMsSupplier;
            this.availableCommands = builder.availableCommands;
            this.playWhenReady = builder.playWhenReady;
            this.playWhenReadyChangeReason = builder.playWhenReadyChangeReason;
            this.playbackState = builder.playbackState;
            this.playbackSuppressionReason = builder.playbackSuppressionReason;
            this.playerError = builder.playerError;
            this.repeatMode = builder.repeatMode;
            this.shuffleModeEnabled = builder.shuffleModeEnabled;
            this.isLoading = builder.isLoading;
            this.seekBackIncrementMs = builder.seekBackIncrementMs;
            this.seekForwardIncrementMs = builder.seekForwardIncrementMs;
            this.maxSeekToPreviousPositionMs = builder.maxSeekToPreviousPositionMs;
            this.playbackParameters = builder.playbackParameters;
            this.trackSelectionParameters = builder.trackSelectionParameters;
            this.audioAttributes = builder.audioAttributes;
            this.volume = builder.volume;
            this.videoSize = builder.videoSize;
            this.currentCues = builder.currentCues;
            this.deviceInfo = builder.deviceInfo;
            this.deviceVolume = builder.deviceVolume;
            this.isDeviceMuted = builder.isDeviceMuted;
            this.surfaceSize = builder.surfaceSize;
            this.newlyRenderedFirstFrame = builder.newlyRenderedFirstFrame;
            this.timedMetadata = builder.timedMetadata;
            this.playlist = builder.playlist;
            this.timeline = builder.timeline;
            this.playlistMetadata = builder.playlistMetadata;
            this.currentMediaItemIndex = builder.currentMediaItemIndex;
            this.currentAdGroupIndex = builder.currentAdGroupIndex;
            this.currentAdIndexInAdGroup = builder.currentAdIndexInAdGroup;
            this.contentPositionMsSupplier = b10;
            this.adPositionMsSupplier = b11;
            this.contentBufferedPositionMsSupplier = builder.contentBufferedPositionMsSupplier;
            this.adBufferedPositionMsSupplier = builder.adBufferedPositionMsSupplier;
            this.totalBufferedDurationMsSupplier = builder.totalBufferedDurationMsSupplier;
            this.hasPositionDiscontinuity = builder.hasPositionDiscontinuity;
            this.positionDiscontinuityReason = builder.positionDiscontinuityReason;
            this.discontinuityPositionMs = builder.discontinuityPositionMs;
        }
    }

    public SimpleBasePlayer(Looper looper) {
        this(looper, Clock.DEFAULT);
    }

    private static State buildStateForNewPosition(State.Builder builder, State state, long j10, List<MediaItemData> list, int i10, long j11, boolean z10) {
        long positionOrDefaultInMediaItem = getPositionOrDefaultInMediaItem(j10, state);
        boolean z11 = false;
        if (!list.isEmpty() && (i10 == -1 || i10 >= list.size())) {
            j11 = -9223372036854775807L;
            i10 = 0;
        }
        if (!list.isEmpty() && j11 == C.TIME_UNSET) {
            j11 = Util.usToMs(list.get(i10).defaultPositionUs);
        }
        boolean z12 = state.playlist.isEmpty() || list.isEmpty();
        if (!z12 && !state.playlist.get(getCurrentMediaItemIndexInternal(state)).uid.equals(list.get(i10).uid)) {
            z11 = true;
        }
        if (z12 || z11 || j11 < positionOrDefaultInMediaItem) {
            builder.setCurrentMediaItemIndex(i10).setCurrentAd(-1, -1).setContentPositionMs(j11).setContentBufferedPositionMs(t2.a(j11)).setTotalBufferedDurationMs(PositionSupplier.ZERO);
        } else if (j11 == positionOrDefaultInMediaItem) {
            builder.setCurrentMediaItemIndex(i10);
            if (state.currentAdGroupIndex == -1 || !z10) {
                builder.setCurrentAd(-1, -1).setTotalBufferedDurationMs(t2.a(getContentBufferedPositionMsInternal(state) - positionOrDefaultInMediaItem));
            } else {
                builder.setTotalBufferedDurationMs(t2.a(state.adBufferedPositionMsSupplier.get() - state.adPositionMsSupplier.get()));
            }
        } else {
            builder.setCurrentMediaItemIndex(i10).setCurrentAd(-1, -1).setContentPositionMs(j11).setContentBufferedPositionMs(t2.a(Math.max(getContentBufferedPositionMsInternal(state), j11))).setTotalBufferedDurationMs(t2.a(Math.max(0L, state.totalBufferedDurationMsSupplier.get() - (j11 - positionOrDefaultInMediaItem))));
        }
        return builder.build();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: m0.a2.<init>(androidx.media3.common.SimpleBasePlayer$State):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    private void clearVideoOutput(@androidx.annotation.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            r2.verifyApplicationThreadAndInitState()
            androidx.media3.common.SimpleBasePlayer$State r0 = r2.state
            r1 = 27
            boolean r1 = r2.shouldHandleCommand(r1)
            if (r1 != 0) goto Le
            return
        Le:
            p5.c0 r3 = r2.handleClearVideoOutput(r3)
            m0.a2 r1 = new m0.a2
            r1.<init>()
            r2.updateStateForPendingOperation(r3, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.clearVideoOutput(java.lang.Object):void");
    }

    private static long getContentBufferedPositionMsInternal(State state) {
        return getPositionOrDefaultInMediaItem(state.contentBufferedPositionMsSupplier.get(), state);
    }

    private static long getContentPositionMsInternal(State state) {
        return getPositionOrDefaultInMediaItem(state.contentPositionMsSupplier.get(), state);
    }

    private static int getCurrentMediaItemIndexInternal(State state) {
        int i10 = state.currentMediaItemIndex;
        if (i10 != -1) {
            return i10;
        }
        return 0;
    }

    private static int getCurrentPeriodIndexInternal(State state, Timeline.Window window, Timeline.Period period) {
        int currentMediaItemIndexInternal = getCurrentMediaItemIndexInternal(state);
        return state.timeline.isEmpty() ? currentMediaItemIndexInternal : getPeriodIndexFromWindowPosition(state.timeline, currentMediaItemIndexInternal, getContentPositionMsInternal(state), window, period);
    }

    private static long getCurrentPeriodOrAdPositionMs(State state, Object obj, Timeline.Period period) {
        return state.currentAdGroupIndex != -1 ? state.adPositionMsSupplier.get() : getContentPositionMsInternal(state) - state.timeline.getPeriodByUid(obj, period).getPositionInWindowMs();
    }

    private static Tracks getCurrentTracksInternal(State state) {
        return state.playlist.isEmpty() ? Tracks.EMPTY : state.playlist.get(getCurrentMediaItemIndexInternal(state)).tracks;
    }

    private static int getMediaItemIndexInNewPlaylist(List<MediaItemData> list, Timeline timeline, int i10, Timeline.Period period) {
        if (list.isEmpty()) {
            if (i10 < timeline.getWindowCount()) {
                return i10;
            }
            return -1;
        }
        Object periodUid = list.get(i10).getPeriodUid(0);
        if (timeline.getIndexOfPeriod(periodUid) == -1) {
            return -1;
        }
        return timeline.getPeriodByUid(periodUid, period).windowIndex;
    }

    private static int getMediaItemTransitionReason(State state, State state2, int i10, boolean z10, Timeline.Window window) {
        Timeline timeline = state.timeline;
        Timeline timeline2 = state2.timeline;
        if (timeline2.isEmpty() && timeline.isEmpty()) {
            return -1;
        }
        if (timeline2.isEmpty() != timeline.isEmpty()) {
            return 3;
        }
        Object obj = state.timeline.getWindow(getCurrentMediaItemIndexInternal(state), window).uid;
        Object obj2 = state2.timeline.getWindow(getCurrentMediaItemIndexInternal(state2), window).uid;
        if ((obj instanceof PlaceholderUid) && !(obj2 instanceof PlaceholderUid)) {
            return -1;
        }
        if (!obj.equals(obj2)) {
            if (i10 == 0) {
                return 1;
            }
            return i10 == 1 ? 2 : 3;
        }
        if (i10 != 0 || getContentPositionMsInternal(state) <= getContentPositionMsInternal(state2)) {
            return (i10 == 1 && z10) ? 2 : -1;
        }
        return 0;
    }

    private static MediaMetadata getMediaMetadataInternal(State state) {
        return state.playlist.isEmpty() ? MediaMetadata.EMPTY : state.playlist.get(getCurrentMediaItemIndexInternal(state)).combinedMediaMetadata;
    }

    public static int getPeriodIndexFromWindowPosition(Timeline timeline, int i10, long j10, Timeline.Window window, Timeline.Period period) {
        return timeline.getIndexOfPeriod(timeline.getPeriodPositionUs(window, period, i10, Util.msToUs(j10)).first);
    }

    private static long getPeriodOrAdDurationMs(State state, Object obj, Timeline.Period period) {
        state.timeline.getPeriodByUid(obj, period);
        int i10 = state.currentAdGroupIndex;
        return Util.usToMs(i10 == -1 ? period.durationUs : period.getAdDurationUs(i10, state.currentAdIndexInAdGroup));
    }

    private static int getPositionDiscontinuityReason(State state, State state2, boolean z10, Timeline.Window window, Timeline.Period period) {
        if (state2.hasPositionDiscontinuity) {
            return state2.positionDiscontinuityReason;
        }
        if (z10) {
            return 1;
        }
        if (state.playlist.isEmpty()) {
            return -1;
        }
        if (state2.playlist.isEmpty()) {
            return 4;
        }
        Object uidOfPeriod = state.timeline.getUidOfPeriod(getCurrentPeriodIndexInternal(state, window, period));
        Object uidOfPeriod2 = state2.timeline.getUidOfPeriod(getCurrentPeriodIndexInternal(state2, window, period));
        if ((uidOfPeriod instanceof PlaceholderUid) && !(uidOfPeriod2 instanceof PlaceholderUid)) {
            return -1;
        }
        if (uidOfPeriod2.equals(uidOfPeriod) && state.currentAdGroupIndex == state2.currentAdGroupIndex && state.currentAdIndexInAdGroup == state2.currentAdIndexInAdGroup) {
            long currentPeriodOrAdPositionMs = getCurrentPeriodOrAdPositionMs(state, uidOfPeriod, period);
            if (Math.abs(currentPeriodOrAdPositionMs - getCurrentPeriodOrAdPositionMs(state2, uidOfPeriod2, period)) < 1000) {
                return -1;
            }
            long periodOrAdDurationMs = getPeriodOrAdDurationMs(state, uidOfPeriod, period);
            return (periodOrAdDurationMs == C.TIME_UNSET || currentPeriodOrAdPositionMs < periodOrAdDurationMs) ? 5 : 0;
        }
        if (state2.timeline.getIndexOfPeriod(uidOfPeriod) == -1) {
            return 4;
        }
        long currentPeriodOrAdPositionMs2 = getCurrentPeriodOrAdPositionMs(state, uidOfPeriod, period);
        long periodOrAdDurationMs2 = getPeriodOrAdDurationMs(state, uidOfPeriod, period);
        return (periodOrAdDurationMs2 == C.TIME_UNSET || currentPeriodOrAdPositionMs2 < periodOrAdDurationMs2) ? 3 : 0;
    }

    private static Player.PositionInfo getPositionInfo(State state, boolean z10, Timeline.Window window, Timeline.Period period) {
        Object obj;
        MediaItem mediaItem;
        Object obj2;
        int i10;
        long j10;
        long j11;
        int currentMediaItemIndexInternal = getCurrentMediaItemIndexInternal(state);
        if (state.timeline.isEmpty()) {
            obj = null;
            mediaItem = null;
            obj2 = null;
            i10 = -1;
        } else {
            int currentPeriodIndexInternal = getCurrentPeriodIndexInternal(state, window, period);
            Object obj3 = state.timeline.getPeriod(currentPeriodIndexInternal, period, true).uid;
            Object obj4 = state.timeline.getWindow(currentMediaItemIndexInternal, window).uid;
            i10 = currentPeriodIndexInternal;
            mediaItem = window.mediaItem;
            obj = obj4;
            obj2 = obj3;
        }
        if (z10) {
            j10 = state.discontinuityPositionMs;
            j11 = state.currentAdGroupIndex == -1 ? j10 : getContentPositionMsInternal(state);
        } else {
            long contentPositionMsInternal = getContentPositionMsInternal(state);
            j10 = state.currentAdGroupIndex != -1 ? state.adPositionMsSupplier.get() : contentPositionMsInternal;
            j11 = contentPositionMsInternal;
        }
        return new Player.PositionInfo(obj, currentMediaItemIndexInternal, mediaItem, obj2, i10, j10, j11, state.currentAdGroupIndex, state.currentAdIndexInAdGroup);
    }

    private static long getPositionOrDefaultInMediaItem(long j10, State state) {
        if (j10 != C.TIME_UNSET) {
            return j10;
        }
        if (state.playlist.isEmpty()) {
            return 0L;
        }
        return Util.usToMs(state.playlist.get(getCurrentMediaItemIndexInternal(state)).defaultPositionUs);
    }

    private static State getStateWithNewPlaylist(State state, List<MediaItemData> list, Timeline.Period period) {
        State.Builder buildUpon = state.buildUpon();
        buildUpon.setPlaylist(list);
        Timeline timeline = buildUpon.timeline;
        long j10 = state.contentPositionMsSupplier.get();
        int currentMediaItemIndexInternal = getCurrentMediaItemIndexInternal(state);
        int mediaItemIndexInNewPlaylist = getMediaItemIndexInNewPlaylist(state.playlist, timeline, currentMediaItemIndexInternal, period);
        long j11 = mediaItemIndexInNewPlaylist == -1 ? C.TIME_UNSET : j10;
        for (int i10 = currentMediaItemIndexInternal + 1; mediaItemIndexInNewPlaylist == -1 && i10 < state.playlist.size(); i10++) {
            mediaItemIndexInNewPlaylist = getMediaItemIndexInNewPlaylist(state.playlist, timeline, i10, period);
        }
        if (state.playbackState != 1 && mediaItemIndexInNewPlaylist == -1) {
            buildUpon.setPlaybackState(4).setIsLoading(false);
        }
        return buildStateForNewPosition(buildUpon, state, j10, list, mediaItemIndexInNewPlaylist, j11, true);
    }

    private static State getStateWithNewPlaylistAndPosition(State state, List<MediaItemData> list, int i10, long j10) {
        State.Builder buildUpon = state.buildUpon();
        buildUpon.setPlaylist(list);
        if (state.playbackState != 1) {
            if (list.isEmpty() || (i10 != -1 && i10 >= list.size())) {
                buildUpon.setPlaybackState(4).setIsLoading(false);
            } else {
                buildUpon.setPlaybackState(2);
            }
        }
        return buildStateForNewPosition(buildUpon, state, state.contentPositionMsSupplier.get(), list, i10, j10, false);
    }

    private static Size getSurfaceHolderSize(SurfaceHolder surfaceHolder) {
        if (!surfaceHolder.getSurface().isValid()) {
            return Size.ZERO;
        }
        Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
        return new Size(surfaceFrame.width(), surfaceFrame.height());
    }

    private static int getTimelineChangeReason(List<MediaItemData> list, List<MediaItemData> list2) {
        if (list.size() != list2.size()) {
            return 0;
        }
        int i10 = 0;
        while (true) {
            if (i10 >= list.size()) {
                return 1;
            }
            Object obj = list.get(i10).uid;
            Object obj2 = list2.get(i10).uid;
            boolean z10 = (obj instanceof PlaceholderUid) && !(obj2 instanceof PlaceholderUid);
            if (!obj.equals(obj2) && !z10) {
                return 0;
            }
            i10++;
        }
    }

    private static boolean isPlaying(State state) {
        return state.playWhenReady && state.playbackState == 3 && state.playbackSuppressionReason == 0;
    }

    public /* synthetic */ State lambda$addMediaItems$3(State state, List list, int i10) {
        ArrayList arrayList = new ArrayList(state.playlist);
        for (int i11 = 0; i11 < list.size(); i11++) {
            arrayList.add(i11 + i10, getPlaceholderMediaItemData((MediaItem) list.get(i11)));
        }
        return !state.playlist.isEmpty() ? getStateWithNewPlaylist(state, arrayList, this.period) : getStateWithNewPlaylistAndPosition(state, arrayList, state.currentMediaItemIndex, state.contentPositionMsSupplier.get());
    }

    public static /* synthetic */ State lambda$clearVideoOutput$21(State state) {
        return state.buildUpon().setSurfaceSize(Size.ZERO).build();
    }

    public static /* synthetic */ State lambda$decreaseDeviceVolume$26(State state) {
        return state.buildUpon().setDeviceVolume(Math.max(0, state.deviceVolume - 1)).build();
    }

    public static /* synthetic */ State lambda$decreaseDeviceVolume$27(State state) {
        return state.buildUpon().setDeviceVolume(Math.max(0, state.deviceVolume - 1)).build();
    }

    public static /* synthetic */ State lambda$increaseDeviceVolume$24(State state) {
        return state.buildUpon().setDeviceVolume(state.deviceVolume + 1).build();
    }

    public static /* synthetic */ State lambda$increaseDeviceVolume$25(State state) {
        return state.buildUpon().setDeviceVolume(state.deviceVolume + 1).build();
    }

    public /* synthetic */ State lambda$moveMediaItems$4(State state, int i10, int i11, int i12) {
        ArrayList arrayList = new ArrayList(state.playlist);
        Util.moveItems(arrayList, i10, i11, i12);
        return getStateWithNewPlaylist(state, arrayList, this.period);
    }

    public /* synthetic */ void lambda$new$0(Player.Listener listener, FlagSet flagSet) {
        listener.onEvents(this, new Player.Events(flagSet));
    }

    public static /* synthetic */ State lambda$prepare$7(State state) {
        return state.buildUpon().setPlayerError(null).setPlaybackState(state.timeline.isEmpty() ? 4 : 2).build();
    }

    public static /* synthetic */ State lambda$release$13(State state) {
        return state;
    }

    public /* synthetic */ State lambda$removeMediaItems$6(State state, int i10, int i11) {
        ArrayList arrayList = new ArrayList(state.playlist);
        Util.removeRange(arrayList, i10, i11);
        return getStateWithNewPlaylist(state, arrayList, this.period);
    }

    public /* synthetic */ State lambda$replaceMediaItems$5(State state, List list, int i10, int i11) {
        ArrayList arrayList = new ArrayList(state.playlist);
        for (int i12 = 0; i12 < list.size(); i12++) {
            arrayList.add(i12 + i10, getPlaceholderMediaItemData((MediaItem) list.get(i12)));
        }
        State stateWithNewPlaylist = !state.playlist.isEmpty() ? getStateWithNewPlaylist(state, arrayList, this.period) : getStateWithNewPlaylistAndPosition(state, arrayList, state.currentMediaItemIndex, state.contentPositionMsSupplier.get());
        if (i11 >= i10) {
            return stateWithNewPlaylist;
        }
        Util.removeRange(arrayList, i11, i10);
        return getStateWithNewPlaylist(stateWithNewPlaylist, arrayList, this.period);
    }

    public static /* synthetic */ State lambda$seekTo$10(State state, int i10, long j10) {
        return getStateWithNewPlaylistAndPosition(state, state.playlist, i10, j10);
    }

    public static /* synthetic */ State lambda$setDeviceMuted$28(State state, boolean z10) {
        return state.buildUpon().setIsDeviceMuted(z10).build();
    }

    public static /* synthetic */ State lambda$setDeviceMuted$29(State state, boolean z10) {
        return state.buildUpon().setIsDeviceMuted(z10).build();
    }

    public static /* synthetic */ State lambda$setDeviceVolume$22(State state, int i10) {
        return state.buildUpon().setDeviceVolume(i10).build();
    }

    public static /* synthetic */ State lambda$setDeviceVolume$23(State state, int i10) {
        return state.buildUpon().setDeviceVolume(i10).build();
    }

    public /* synthetic */ State lambda$setMediaItemsInternal$2(List list, State state, int i10, long j10) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            arrayList.add(getPlaceholderMediaItemData((MediaItem) list.get(i11)));
        }
        return getStateWithNewPlaylistAndPosition(state, arrayList, i10, j10);
    }

    public static /* synthetic */ State lambda$setPlayWhenReady$1(State state, boolean z10) {
        return state.buildUpon().setPlayWhenReady(z10, 1).build();
    }

    public static /* synthetic */ State lambda$setPlaybackParameters$11(State state, PlaybackParameters playbackParameters) {
        return state.buildUpon().setPlaybackParameters(playbackParameters).build();
    }

    public static /* synthetic */ State lambda$setPlaylistMetadata$15(State state, MediaMetadata mediaMetadata) {
        return state.buildUpon().setPlaylistMetadata(mediaMetadata).build();
    }

    public static /* synthetic */ State lambda$setRepeatMode$8(State state, int i10) {
        return state.buildUpon().setRepeatMode(i10).build();
    }

    public static /* synthetic */ State lambda$setShuffleModeEnabled$9(State state, boolean z10) {
        return state.buildUpon().setShuffleModeEnabled(z10).build();
    }

    public static /* synthetic */ State lambda$setTrackSelectionParameters$14(State state, TrackSelectionParameters trackSelectionParameters) {
        return state.buildUpon().setTrackSelectionParameters(trackSelectionParameters).build();
    }

    public static /* synthetic */ State lambda$setVideoSurface$17(State state) {
        return state.buildUpon().setSurfaceSize(Size.UNKNOWN).build();
    }

    public static /* synthetic */ State lambda$setVideoSurfaceHolder$18(State state, SurfaceHolder surfaceHolder) {
        return state.buildUpon().setSurfaceSize(getSurfaceHolderSize(surfaceHolder)).build();
    }

    public static /* synthetic */ State lambda$setVideoSurfaceView$19(State state, SurfaceView surfaceView) {
        return state.buildUpon().setSurfaceSize(getSurfaceHolderSize(surfaceView.getHolder())).build();
    }

    public static /* synthetic */ State lambda$setVideoTextureView$20(State state, Size size) {
        return state.buildUpon().setSurfaceSize(size).build();
    }

    public static /* synthetic */ State lambda$setVolume$16(State state, float f10) {
        return state.buildUpon().setVolume(f10).build();
    }

    public static /* synthetic */ State lambda$stop$12(State state) {
        return state.buildUpon().setPlaybackState(1).setTotalBufferedDurationMs(PositionSupplier.ZERO).setContentBufferedPositionMs(t2.a(getContentPositionMsInternal(state))).setAdBufferedPositionMs(state.adPositionMsSupplier).setIsLoading(false).build();
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$31(State state, int i10, Player.Listener listener) {
        listener.onTimelineChanged(state.timeline, i10);
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$32(int i10, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, Player.Listener listener) {
        listener.onPositionDiscontinuity(i10);
        listener.onPositionDiscontinuity(positionInfo, positionInfo2, i10);
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$34(State state, Player.Listener listener) {
        listener.onPlayerErrorChanged(state.playerError);
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$35(State state, Player.Listener listener) {
        listener.onPlayerError((PlaybackException) Util.castNonNull(state.playerError));
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$36(State state, Player.Listener listener) {
        listener.onTrackSelectionParametersChanged(state.trackSelectionParameters);
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$39(State state, Player.Listener listener) {
        listener.onLoadingChanged(state.isLoading);
        listener.onIsLoadingChanged(state.isLoading);
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$40(State state, Player.Listener listener) {
        listener.onPlayerStateChanged(state.playWhenReady, state.playbackState);
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$41(State state, Player.Listener listener) {
        listener.onPlaybackStateChanged(state.playbackState);
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$42(State state, Player.Listener listener) {
        listener.onPlayWhenReadyChanged(state.playWhenReady, state.playWhenReadyChangeReason);
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$43(State state, Player.Listener listener) {
        listener.onPlaybackSuppressionReasonChanged(state.playbackSuppressionReason);
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$44(State state, Player.Listener listener) {
        listener.onIsPlayingChanged(isPlaying(state));
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$45(State state, Player.Listener listener) {
        listener.onPlaybackParametersChanged(state.playbackParameters);
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$46(State state, Player.Listener listener) {
        listener.onRepeatModeChanged(state.repeatMode);
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$47(State state, Player.Listener listener) {
        listener.onShuffleModeEnabledChanged(state.shuffleModeEnabled);
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$48(State state, Player.Listener listener) {
        listener.onSeekBackIncrementChanged(state.seekBackIncrementMs);
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$49(State state, Player.Listener listener) {
        listener.onSeekForwardIncrementChanged(state.seekForwardIncrementMs);
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$50(State state, Player.Listener listener) {
        listener.onMaxSeekToPreviousPositionChanged(state.maxSeekToPreviousPositionMs);
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$51(State state, Player.Listener listener) {
        listener.onAudioAttributesChanged(state.audioAttributes);
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$52(State state, Player.Listener listener) {
        listener.onVideoSizeChanged(state.videoSize);
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$53(State state, Player.Listener listener) {
        listener.onDeviceInfoChanged(state.deviceInfo);
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$54(State state, Player.Listener listener) {
        listener.onPlaylistMetadataChanged(state.playlistMetadata);
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$55(State state, Player.Listener listener) {
        listener.onSurfaceSizeChanged(state.surfaceSize.getWidth(), state.surfaceSize.getHeight());
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$56(State state, Player.Listener listener) {
        listener.onVolumeChanged(state.volume);
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$57(State state, Player.Listener listener) {
        listener.onDeviceVolumeChanged(state.deviceVolume, state.isDeviceMuted);
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$58(State state, Player.Listener listener) {
        listener.onCues(state.currentCues.cues);
        listener.onCues(state.currentCues);
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$59(State state, Player.Listener listener) {
        listener.onMetadata(state.timedMetadata);
    }

    public static /* synthetic */ void lambda$updateStateAndInformListeners$60(State state, Player.Listener listener) {
        listener.onAvailableCommandsChanged(state.availableCommands);
    }

    public /* synthetic */ void lambda$updateStateForPendingOperation$61(c0 c0Var) {
        Util.castNonNull(this.state);
        this.pendingOperations.remove(c0Var);
        if (!this.pendingOperations.isEmpty() || this.released) {
            return;
        }
        updateStateAndInformListeners(getState(), false, false);
    }

    public void postOrRunOnApplicationHandler(Runnable runnable) {
        if (this.applicationHandler.getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.applicationHandler.post(runnable);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: m0.h1.<init>(androidx.media3.common.SimpleBasePlayer, java.util.List, androidx.media3.common.SimpleBasePlayer$State, int, long):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"state"})
    private void setMediaItemsInternal(java.util.List<androidx.media3.common.MediaItem> r10, int r11, long r12) {
        /*
            r9 = this;
            r0 = -1
            r1 = 1
            if (r11 == r0) goto L9
            if (r11 < 0) goto L7
            goto L9
        L7:
            r0 = 0
            goto La
        L9:
            r0 = 1
        La:
            androidx.media3.common.util.Assertions.checkArgument(r0)
            androidx.media3.common.SimpleBasePlayer$State r5 = r9.state
            r0 = 20
            boolean r0 = r9.shouldHandleCommand(r0)
            if (r0 != 0) goto L26
            int r0 = r10.size()
            if (r0 != r1) goto L25
            r0 = 31
            boolean r0 = r9.shouldHandleCommand(r0)
            if (r0 != 0) goto L26
        L25:
            return
        L26:
            p5.c0 r0 = r9.handleSetMediaItems(r10, r11, r12)
            m0.h1 r1 = new m0.h1
            r2 = r1
            r3 = r9
            r4 = r10
            r6 = r11
            r7 = r12
            r2.<init>()
            r9.updateStateForPendingOperation(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.setMediaItemsInternal(java.util.List, int, long):void");
    }

    @RequiresNonNull({"state"})
    private boolean shouldHandleCommand(int i10) {
        return !this.released && this.state.availableCommands.contains(i10);
    }

    @RequiresNonNull({"state"})
    private void updateStateAndInformListeners(State state, boolean z10, boolean z11) {
        State state2 = this.state;
        this.state = state;
        if (state.hasPositionDiscontinuity || state.newlyRenderedFirstFrame) {
            this.state = state.buildUpon().clearPositionDiscontinuity().setNewlyRenderedFirstFrame(false).build();
        }
        boolean z12 = state2.playWhenReady != state.playWhenReady;
        boolean z13 = state2.playbackState != state.playbackState;
        Tracks currentTracksInternal = getCurrentTracksInternal(state2);
        Tracks currentTracksInternal2 = getCurrentTracksInternal(state);
        MediaMetadata mediaMetadataInternal = getMediaMetadataInternal(state2);
        MediaMetadata mediaMetadataInternal2 = getMediaMetadataInternal(state);
        int positionDiscontinuityReason = getPositionDiscontinuityReason(state2, state, z10, this.window, this.period);
        boolean z14 = !state2.timeline.equals(state.timeline);
        int mediaItemTransitionReason = getMediaItemTransitionReason(state2, state, positionDiscontinuityReason, z11, this.window);
        if (z14) {
            this.listeners.queueEvent(0, new ListenerSet.Event() { // from class: m0.m1

                /* renamed from: b */
                public final /* synthetic */ int f28202b;

                public /* synthetic */ m1(int i10) {
                    timelineChangeReason = i10;
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$31(SimpleBasePlayer.State.this, timelineChangeReason, (Player.Listener) obj);
                }
            });
        }
        if (positionDiscontinuityReason != -1) {
            this.listeners.queueEvent(11, new ListenerSet.Event() { // from class: m0.k0

                /* renamed from: a */
                public final /* synthetic */ int f28190a;

                /* renamed from: b */
                public final /* synthetic */ Player.PositionInfo f28191b;

                /* renamed from: c */
                public final /* synthetic */ Player.PositionInfo f28192c;

                public /* synthetic */ k0(int positionDiscontinuityReason2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
                    positionDiscontinuityReason = positionDiscontinuityReason2;
                    positionInfo = positionInfo;
                    positionInfo2 = positionInfo2;
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$32(positionDiscontinuityReason, positionInfo, positionInfo2, (Player.Listener) obj);
                }
            });
        }
        if (mediaItemTransitionReason != -1) {
            this.listeners.queueEvent(1, new ListenerSet.Event() { // from class: m0.w0

                /* renamed from: b */
                public final /* synthetic */ int f28241b;

                public /* synthetic */ w0(int mediaItemTransitionReason2) {
                    mediaItemTransitionReason = mediaItemTransitionReason2;
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).onMediaItemTransition(MediaItem.this, mediaItemTransitionReason);
                }
            });
        }
        if (!Util.areEqual(state2.playerError, state.playerError)) {
            this.listeners.queueEvent(10, new ListenerSet.Event() { // from class: m0.y0
                public /* synthetic */ y0() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$34(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
            if (state.playerError != null) {
                this.listeners.queueEvent(10, new ListenerSet.Event() { // from class: m0.z0
                    public /* synthetic */ z0() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        SimpleBasePlayer.lambda$updateStateAndInformListeners$35(SimpleBasePlayer.State.this, (Player.Listener) obj);
                    }
                });
            }
        }
        if (!state2.trackSelectionParameters.equals(state.trackSelectionParameters)) {
            this.listeners.queueEvent(19, new ListenerSet.Event() { // from class: m0.a1
                public /* synthetic */ a1() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$36(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
        }
        if (!currentTracksInternal.equals(currentTracksInternal2)) {
            this.listeners.queueEvent(2, new ListenerSet.Event() { // from class: m0.c1
                public /* synthetic */ c1() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).onTracksChanged(Tracks.this);
                }
            });
        }
        if (!mediaMetadataInternal.equals(mediaMetadataInternal2)) {
            this.listeners.queueEvent(14, new ListenerSet.Event() { // from class: m0.d1
                public /* synthetic */ d1() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).onMediaMetadataChanged(MediaMetadata.this);
                }
            });
        }
        if (state2.isLoading != state.isLoading) {
            this.listeners.queueEvent(3, new ListenerSet.Event() { // from class: m0.e1
                public /* synthetic */ e1() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$39(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
        }
        if (z12 || z13) {
            this.listeners.queueEvent(-1, new ListenerSet.Event() { // from class: m0.f1
                public /* synthetic */ f1() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$40(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
        }
        if (z13) {
            this.listeners.queueEvent(4, new ListenerSet.Event() { // from class: m0.x1
                public /* synthetic */ x1() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$41(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
        }
        if (z12 || state2.playWhenReadyChangeReason != state.playWhenReadyChangeReason) {
            this.listeners.queueEvent(5, new ListenerSet.Event() { // from class: m0.i2
                public /* synthetic */ i2() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$42(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
        }
        if (state2.playbackSuppressionReason != state.playbackSuppressionReason) {
            this.listeners.queueEvent(6, new ListenerSet.Event() { // from class: m0.n2
                public /* synthetic */ n2() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$43(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
        }
        if (isPlaying(state2) != isPlaying(state)) {
            this.listeners.queueEvent(7, new ListenerSet.Event() { // from class: m0.o2
                public /* synthetic */ o2() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$44(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
        }
        if (!state2.playbackParameters.equals(state.playbackParameters)) {
            this.listeners.queueEvent(12, new ListenerSet.Event() { // from class: m0.p2
                public /* synthetic */ p2() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$45(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
        }
        if (state2.repeatMode != state.repeatMode) {
            this.listeners.queueEvent(8, new ListenerSet.Event() { // from class: m0.q2
                public /* synthetic */ q2() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$46(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
        }
        if (state2.shuffleModeEnabled != state.shuffleModeEnabled) {
            this.listeners.queueEvent(9, new ListenerSet.Event() { // from class: m0.g0
                public /* synthetic */ g0() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$47(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
        }
        if (state2.seekBackIncrementMs != state.seekBackIncrementMs) {
            this.listeners.queueEvent(16, new ListenerSet.Event() { // from class: m0.h0
                public /* synthetic */ h0() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$48(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
        }
        if (state2.seekForwardIncrementMs != state.seekForwardIncrementMs) {
            this.listeners.queueEvent(17, new ListenerSet.Event() { // from class: m0.i0
                public /* synthetic */ i0() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$49(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
        }
        if (state2.maxSeekToPreviousPositionMs != state.maxSeekToPreviousPositionMs) {
            this.listeners.queueEvent(18, new ListenerSet.Event() { // from class: m0.j0
                public /* synthetic */ j0() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$50(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
        }
        if (!state2.audioAttributes.equals(state.audioAttributes)) {
            this.listeners.queueEvent(20, new ListenerSet.Event() { // from class: m0.l0
                public /* synthetic */ l0() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$51(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
        }
        if (!state2.videoSize.equals(state.videoSize)) {
            this.listeners.queueEvent(25, new ListenerSet.Event() { // from class: m0.m0
                public /* synthetic */ m0() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$52(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
        }
        if (!state2.deviceInfo.equals(state.deviceInfo)) {
            this.listeners.queueEvent(29, new ListenerSet.Event() { // from class: m0.n0
                public /* synthetic */ n0() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$53(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
        }
        if (!state2.playlistMetadata.equals(state.playlistMetadata)) {
            this.listeners.queueEvent(15, new ListenerSet.Event() { // from class: m0.o0
                public /* synthetic */ o0() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$54(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
        }
        if (state.newlyRenderedFirstFrame) {
            this.listeners.queueEvent(26, new p0());
        }
        if (!state2.surfaceSize.equals(state.surfaceSize)) {
            this.listeners.queueEvent(24, new ListenerSet.Event() { // from class: m0.r0
                public /* synthetic */ r0() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$55(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
        }
        if (state2.volume != state.volume) {
            this.listeners.queueEvent(22, new ListenerSet.Event() { // from class: m0.s0
                public /* synthetic */ s0() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$56(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
        }
        if (state2.deviceVolume != state.deviceVolume || state2.isDeviceMuted != state.isDeviceMuted) {
            this.listeners.queueEvent(30, new ListenerSet.Event() { // from class: m0.t0
                public /* synthetic */ t0() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$57(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
        }
        if (!state2.currentCues.equals(state.currentCues)) {
            this.listeners.queueEvent(27, new ListenerSet.Event() { // from class: m0.u0
                public /* synthetic */ u0() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$58(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
        }
        if (!state2.timedMetadata.equals(state.timedMetadata) && state.timedMetadata.presentationTimeUs != C.TIME_UNSET) {
            this.listeners.queueEvent(28, new ListenerSet.Event() { // from class: m0.v0
                public /* synthetic */ v0() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$59(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
        }
        if (!state2.availableCommands.equals(state.availableCommands)) {
            this.listeners.queueEvent(13, new ListenerSet.Event() { // from class: m0.x0
                public /* synthetic */ x0() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.lambda$updateStateAndInformListeners$60(SimpleBasePlayer.State.this, (Player.Listener) obj);
                }
            });
        }
        this.listeners.flushEvents();
    }

    @RequiresNonNull({"state"})
    private void updateStateForPendingOperation(c0<?> c0Var, z<State> zVar) {
        updateStateForPendingOperation(c0Var, zVar, false, false);
    }

    @EnsuresNonNull({"state"})
    private void verifyApplicationThreadAndInitState() {
        if (Thread.currentThread() != this.applicationLooper.getThread()) {
            throw new IllegalStateException(Util.formatInvariant("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), this.applicationLooper.getThread().getName()));
        }
        if (this.state == null) {
            this.state = getState();
        }
    }

    @Override // androidx.media3.common.Player
    public final void addListener(Player.Listener listener) {
        this.listeners.add((Player.Listener) Assertions.checkNotNull(listener));
    }

    @Override // androidx.media3.common.Player
    public final void addMediaItems(int i10, List<MediaItem> list) {
        verifyApplicationThreadAndInitState();
        Assertions.checkArgument(i10 >= 0);
        State state = this.state;
        int size = state.playlist.size();
        if (!shouldHandleCommand(20) || list.isEmpty()) {
            return;
        }
        int min = Math.min(i10, size);
        updateStateForPendingOperation(handleAddMediaItems(min, list), new z() { // from class: m0.n1

            /* renamed from: c */
            public final /* synthetic */ SimpleBasePlayer.State f28207c;

            /* renamed from: d */
            public final /* synthetic */ List f28208d;

            /* renamed from: e */
            public final /* synthetic */ int f28209e;

            public /* synthetic */ n1(SimpleBasePlayer.State state2, List list2, int min2) {
                state = state2;
                list = list2;
                min = min2;
            }

            @Override // b5.z
            public final Object get() {
                SimpleBasePlayer.State lambda$addMediaItems$3;
                lambda$addMediaItems$3 = SimpleBasePlayer.this.lambda$addMediaItems$3(state, list, min);
                return lambda$addMediaItems$3;
            }
        });
    }

    @Override // androidx.media3.common.Player
    public final void clearVideoSurface() {
        clearVideoOutput(null);
    }

    @Override // androidx.media3.common.Player
    public final void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        clearVideoOutput(surfaceHolder);
    }

    @Override // androidx.media3.common.Player
    public final void clearVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        clearVideoOutput(surfaceView);
    }

    @Override // androidx.media3.common.Player
    public final void clearVideoTextureView(@Nullable TextureView textureView) {
        clearVideoOutput(textureView);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: m0.q1.<init>(androidx.media3.common.SimpleBasePlayer$State):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // androidx.media3.common.Player
    @java.lang.Deprecated
    public final void decreaseDeviceVolume() {
        /*
            r3 = this;
            r3.verifyApplicationThreadAndInitState()
            androidx.media3.common.SimpleBasePlayer$State r0 = r3.state
            r1 = 26
            boolean r1 = r3.shouldHandleCommand(r1)
            if (r1 != 0) goto Le
            return
        Le:
            r1 = 1
            p5.c0 r1 = r3.handleDecreaseDeviceVolume(r1)
            m0.q1 r2 = new m0.q1
            r2.<init>()
            r3.updateStateForPendingOperation(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.decreaseDeviceVolume():void");
    }

    @Override // androidx.media3.common.Player
    public final Looper getApplicationLooper() {
        return this.applicationLooper;
    }

    @Override // androidx.media3.common.Player
    public final AudioAttributes getAudioAttributes() {
        verifyApplicationThreadAndInitState();
        return this.state.audioAttributes;
    }

    @Override // androidx.media3.common.Player
    public final Player.Commands getAvailableCommands() {
        verifyApplicationThreadAndInitState();
        return this.state.availableCommands;
    }

    @Override // androidx.media3.common.Player
    public final long getBufferedPosition() {
        verifyApplicationThreadAndInitState();
        return isPlayingAd() ? Math.max(this.state.adBufferedPositionMsSupplier.get(), this.state.adPositionMsSupplier.get()) : getContentBufferedPosition();
    }

    @Override // androidx.media3.common.Player
    public final long getContentBufferedPosition() {
        verifyApplicationThreadAndInitState();
        return Math.max(getContentBufferedPositionMsInternal(this.state), getContentPositionMsInternal(this.state));
    }

    @Override // androidx.media3.common.Player
    public final long getContentPosition() {
        verifyApplicationThreadAndInitState();
        return getContentPositionMsInternal(this.state);
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentAdGroupIndex() {
        verifyApplicationThreadAndInitState();
        return this.state.currentAdGroupIndex;
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentAdIndexInAdGroup() {
        verifyApplicationThreadAndInitState();
        return this.state.currentAdIndexInAdGroup;
    }

    @Override // androidx.media3.common.Player
    public final CueGroup getCurrentCues() {
        verifyApplicationThreadAndInitState();
        return this.state.currentCues;
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentMediaItemIndex() {
        verifyApplicationThreadAndInitState();
        return getCurrentMediaItemIndexInternal(this.state);
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentPeriodIndex() {
        verifyApplicationThreadAndInitState();
        return getCurrentPeriodIndexInternal(this.state, this.window, this.period);
    }

    @Override // androidx.media3.common.Player
    public final long getCurrentPosition() {
        verifyApplicationThreadAndInitState();
        return isPlayingAd() ? this.state.adPositionMsSupplier.get() : getContentPosition();
    }

    @Override // androidx.media3.common.Player
    public final Timeline getCurrentTimeline() {
        verifyApplicationThreadAndInitState();
        return this.state.timeline;
    }

    @Override // androidx.media3.common.Player
    public final Tracks getCurrentTracks() {
        verifyApplicationThreadAndInitState();
        return getCurrentTracksInternal(this.state);
    }

    @Override // androidx.media3.common.Player
    public final DeviceInfo getDeviceInfo() {
        verifyApplicationThreadAndInitState();
        return this.state.deviceInfo;
    }

    @Override // androidx.media3.common.Player
    public final int getDeviceVolume() {
        verifyApplicationThreadAndInitState();
        return this.state.deviceVolume;
    }

    @Override // androidx.media3.common.Player
    public final long getDuration() {
        verifyApplicationThreadAndInitState();
        if (!isPlayingAd()) {
            return getContentDuration();
        }
        this.state.timeline.getPeriod(getCurrentPeriodIndex(), this.period);
        Timeline.Period period = this.period;
        State state = this.state;
        return Util.usToMs(period.getAdDurationUs(state.currentAdGroupIndex, state.currentAdIndexInAdGroup));
    }

    @Override // androidx.media3.common.Player
    public final long getMaxSeekToPreviousPosition() {
        verifyApplicationThreadAndInitState();
        return this.state.maxSeekToPreviousPositionMs;
    }

    @Override // androidx.media3.common.Player
    public final MediaMetadata getMediaMetadata() {
        verifyApplicationThreadAndInitState();
        return getMediaMetadataInternal(this.state);
    }

    @ForOverride
    public MediaItemData getPlaceholderMediaItemData(MediaItem mediaItem) {
        return new MediaItemData.Builder(new PlaceholderUid()).setMediaItem(mediaItem).setIsDynamic(true).setIsPlaceholder(true).build();
    }

    @ForOverride
    public State getPlaceholderState(State state) {
        return state;
    }

    @Override // androidx.media3.common.Player
    public final boolean getPlayWhenReady() {
        verifyApplicationThreadAndInitState();
        return this.state.playWhenReady;
    }

    @Override // androidx.media3.common.Player
    public final PlaybackParameters getPlaybackParameters() {
        verifyApplicationThreadAndInitState();
        return this.state.playbackParameters;
    }

    @Override // androidx.media3.common.Player
    public final int getPlaybackState() {
        verifyApplicationThreadAndInitState();
        return this.state.playbackState;
    }

    @Override // androidx.media3.common.Player
    public final int getPlaybackSuppressionReason() {
        verifyApplicationThreadAndInitState();
        return this.state.playbackSuppressionReason;
    }

    @Override // androidx.media3.common.Player
    @Nullable
    public final PlaybackException getPlayerError() {
        verifyApplicationThreadAndInitState();
        return this.state.playerError;
    }

    @Override // androidx.media3.common.Player
    public final MediaMetadata getPlaylistMetadata() {
        verifyApplicationThreadAndInitState();
        return this.state.playlistMetadata;
    }

    @Override // androidx.media3.common.Player
    public final int getRepeatMode() {
        verifyApplicationThreadAndInitState();
        return this.state.repeatMode;
    }

    @Override // androidx.media3.common.Player
    public final long getSeekBackIncrement() {
        verifyApplicationThreadAndInitState();
        return this.state.seekBackIncrementMs;
    }

    @Override // androidx.media3.common.Player
    public final long getSeekForwardIncrement() {
        verifyApplicationThreadAndInitState();
        return this.state.seekForwardIncrementMs;
    }

    @Override // androidx.media3.common.Player
    public final boolean getShuffleModeEnabled() {
        verifyApplicationThreadAndInitState();
        return this.state.shuffleModeEnabled;
    }

    @ForOverride
    public abstract State getState();

    @Override // androidx.media3.common.Player
    public final Size getSurfaceSize() {
        verifyApplicationThreadAndInitState();
        return this.state.surfaceSize;
    }

    @Override // androidx.media3.common.Player
    public final long getTotalBufferedDuration() {
        verifyApplicationThreadAndInitState();
        return this.state.totalBufferedDurationMsSupplier.get();
    }

    @Override // androidx.media3.common.Player
    public final TrackSelectionParameters getTrackSelectionParameters() {
        verifyApplicationThreadAndInitState();
        return this.state.trackSelectionParameters;
    }

    @Override // androidx.media3.common.Player
    public final VideoSize getVideoSize() {
        verifyApplicationThreadAndInitState();
        return this.state.videoSize;
    }

    @Override // androidx.media3.common.Player
    public final float getVolume() {
        verifyApplicationThreadAndInitState();
        return this.state.volume;
    }

    @ForOverride
    public c0<?> handleAddMediaItems(int i10, List<MediaItem> list) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_CHANGE_MEDIA_ITEMS");
    }

    @ForOverride
    public c0<?> handleClearVideoOutput(@Nullable Object obj) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_VIDEO_SURFACE");
    }

    @ForOverride
    public c0<?> handleDecreaseDeviceVolume(int i10) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_ADJUST_DEVICE_VOLUME or COMMAND_ADJUST_DEVICE_VOLUME_WITH_FLAGS");
    }

    @ForOverride
    public c0<?> handleIncreaseDeviceVolume(int i10) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_ADJUST_DEVICE_VOLUME or COMMAND_ADJUST_DEVICE_VOLUME_WITH_FLAGS");
    }

    @ForOverride
    public c0<?> handleMoveMediaItems(int i10, int i11, int i12) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_CHANGE_MEDIA_ITEMS");
    }

    @ForOverride
    public c0<?> handlePrepare() {
        throw new IllegalStateException("Missing implementation to handle COMMAND_PREPARE");
    }

    @ForOverride
    public c0<?> handleRelease() {
        throw new IllegalStateException("Missing implementation to handle COMMAND_RELEASE");
    }

    @ForOverride
    public c0<?> handleRemoveMediaItems(int i10, int i11) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_CHANGE_MEDIA_ITEMS");
    }

    @ForOverride
    public c0<?> handleReplaceMediaItems(int i10, int i11, List<MediaItem> list) {
        return Util.transformFutureAsync(handleAddMediaItems(i11, list), new f() { // from class: m0.f2
            public /* synthetic */ f2() {
            }

            @Override // p5.f
            public final p5.c0 apply(Object obj) {
                p5.c0 lambda$handleReplaceMediaItems$30;
                lambda$handleReplaceMediaItems$30 = SimpleBasePlayer.lambda$handleReplaceMediaItems$30(p5.c0.this, obj);
                return lambda$handleReplaceMediaItems$30;
            }
        });
    }

    @ForOverride
    public c0<?> handleSeek(int i10, long j10, int i11) {
        throw new IllegalStateException("Missing implementation to handle one of the COMMAND_SEEK_*");
    }

    @ForOverride
    public c0<?> handleSetDeviceMuted(boolean z10, int i10) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_ADJUST_DEVICE_VOLUME or COMMAND_ADJUST_DEVICE_VOLUME_WITH_FLAGS");
    }

    @ForOverride
    public c0<?> handleSetDeviceVolume(@IntRange(from = 0) int i10, int i11) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_DEVICE_VOLUME or COMMAND_SET_DEVICE_VOLUME_WITH_FLAGS");
    }

    @ForOverride
    public c0<?> handleSetMediaItems(List<MediaItem> list, int i10, long j10) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_MEDIA_ITEM(S)");
    }

    @ForOverride
    public c0<?> handleSetPlayWhenReady(boolean z10) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_PLAY_PAUSE");
    }

    @ForOverride
    public c0<?> handleSetPlaybackParameters(PlaybackParameters playbackParameters) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_SPEED_AND_PITCH");
    }

    @ForOverride
    public c0<?> handleSetPlaylistMetadata(MediaMetadata mediaMetadata) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_PLAYLIST_METADATA");
    }

    @ForOverride
    public c0<?> handleSetRepeatMode(int i10) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_REPEAT_MODE");
    }

    @ForOverride
    public c0<?> handleSetShuffleModeEnabled(boolean z10) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_SHUFFLE_MODE");
    }

    @ForOverride
    public c0<?> handleSetTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_TRACK_SELECTION_PARAMETERS");
    }

    @ForOverride
    public c0<?> handleSetVideoOutput(Object obj) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_VIDEO_SURFACE");
    }

    @ForOverride
    public c0<?> handleSetVolume(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_VOLUME");
    }

    @ForOverride
    public c0<?> handleStop() {
        throw new IllegalStateException("Missing implementation to handle COMMAND_STOP");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: m0.c2.<init>(androidx.media3.common.SimpleBasePlayer$State):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // androidx.media3.common.Player
    @java.lang.Deprecated
    public final void increaseDeviceVolume() {
        /*
            r3 = this;
            r3.verifyApplicationThreadAndInitState()
            androidx.media3.common.SimpleBasePlayer$State r0 = r3.state
            r1 = 26
            boolean r1 = r3.shouldHandleCommand(r1)
            if (r1 != 0) goto Le
            return
        Le:
            r1 = 1
            p5.c0 r1 = r3.handleIncreaseDeviceVolume(r1)
            m0.c2 r2 = new m0.c2
            r2.<init>()
            r3.updateStateForPendingOperation(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.increaseDeviceVolume():void");
    }

    public final void invalidateState() {
        verifyApplicationThreadAndInitState();
        if (!this.pendingOperations.isEmpty() || this.released) {
            return;
        }
        updateStateAndInformListeners(getState(), false, false);
    }

    @Override // androidx.media3.common.Player
    public final boolean isDeviceMuted() {
        verifyApplicationThreadAndInitState();
        return this.state.isDeviceMuted;
    }

    @Override // androidx.media3.common.Player
    public final boolean isLoading() {
        verifyApplicationThreadAndInitState();
        return this.state.isLoading;
    }

    @Override // androidx.media3.common.Player
    public final boolean isPlayingAd() {
        verifyApplicationThreadAndInitState();
        return this.state.currentAdGroupIndex != -1;
    }

    @Override // androidx.media3.common.Player
    public final void moveMediaItems(int i10, int i11, int i12) {
        verifyApplicationThreadAndInitState();
        Assertions.checkArgument(i10 >= 0 && i11 >= i10 && i12 >= 0);
        State state = this.state;
        int size = state.playlist.size();
        if (!shouldHandleCommand(20) || size == 0 || i10 >= size) {
            return;
        }
        int min = Math.min(i11, size);
        int min2 = Math.min(i12, state.playlist.size() - (min - i10));
        if (i10 == min || min2 == i10) {
            return;
        }
        updateStateForPendingOperation(handleMoveMediaItems(i10, min, min2), new z() { // from class: m0.b2

            /* renamed from: c */
            public final /* synthetic */ SimpleBasePlayer.State f28150c;

            /* renamed from: d */
            public final /* synthetic */ int f28151d;

            /* renamed from: e */
            public final /* synthetic */ int f28152e;

            /* renamed from: f */
            public final /* synthetic */ int f28153f;

            public /* synthetic */ b2(SimpleBasePlayer.State state2, int i102, int min3, int min22) {
                state = state2;
                i10 = i102;
                min = min3;
                min2 = min22;
            }

            @Override // b5.z
            public final Object get() {
                SimpleBasePlayer.State lambda$moveMediaItems$4;
                lambda$moveMediaItems$4 = SimpleBasePlayer.this.lambda$moveMediaItems$4(state, i10, min, min2);
                return lambda$moveMediaItems$4;
            }
        });
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: m0.h2.<init>(androidx.media3.common.SimpleBasePlayer$State):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // androidx.media3.common.Player
    public final void prepare() {
        /*
            r3 = this;
            r3.verifyApplicationThreadAndInitState()
            androidx.media3.common.SimpleBasePlayer$State r0 = r3.state
            r1 = 2
            boolean r1 = r3.shouldHandleCommand(r1)
            if (r1 != 0) goto Ld
            return
        Ld:
            p5.c0 r1 = r3.handlePrepare()
            m0.h2 r2 = new m0.h2
            r2.<init>()
            r3.updateStateForPendingOperation(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.prepare():void");
    }

    @Override // androidx.media3.common.Player
    public final void release() {
        verifyApplicationThreadAndInitState();
        State state = this.state;
        if (shouldHandleCommand(32)) {
            updateStateForPendingOperation(handleRelease(), new z() { // from class: m0.w1
                public /* synthetic */ w1() {
                }

                @Override // b5.z
                public final Object get() {
                    SimpleBasePlayer.State lambda$release$13;
                    lambda$release$13 = SimpleBasePlayer.lambda$release$13(SimpleBasePlayer.State.this);
                    return lambda$release$13;
                }
            });
            this.released = true;
            this.listeners.release();
            this.state = this.state.buildUpon().setPlaybackState(1).setTotalBufferedDurationMs(PositionSupplier.ZERO).setContentBufferedPositionMs(t2.a(getContentPositionMsInternal(state))).setAdBufferedPositionMs(state.adPositionMsSupplier).setIsLoading(false).build();
        }
    }

    @Override // androidx.media3.common.Player
    public final void removeListener(Player.Listener listener) {
        verifyApplicationThreadAndInitState();
        this.listeners.remove(listener);
    }

    @Override // androidx.media3.common.Player
    public final void removeMediaItems(int i10, int i11) {
        int min;
        verifyApplicationThreadAndInitState();
        Assertions.checkArgument(i10 >= 0 && i11 >= i10);
        State state = this.state;
        int size = state.playlist.size();
        if (!shouldHandleCommand(20) || size == 0 || i10 >= size || i10 == (min = Math.min(i11, size))) {
            return;
        }
        updateStateForPendingOperation(handleRemoveMediaItems(i10, min), new z() { // from class: m0.e2

            /* renamed from: c */
            public final /* synthetic */ SimpleBasePlayer.State f28162c;

            /* renamed from: d */
            public final /* synthetic */ int f28163d;

            /* renamed from: e */
            public final /* synthetic */ int f28164e;

            public /* synthetic */ e2(SimpleBasePlayer.State state2, int i102, int min2) {
                state = state2;
                i10 = i102;
                min = min2;
            }

            @Override // b5.z
            public final Object get() {
                SimpleBasePlayer.State lambda$removeMediaItems$6;
                lambda$removeMediaItems$6 = SimpleBasePlayer.this.lambda$removeMediaItems$6(state, i10, min);
                return lambda$removeMediaItems$6;
            }
        });
    }

    @Override // androidx.media3.common.Player
    public final void replaceMediaItems(int i10, int i11, List<MediaItem> list) {
        verifyApplicationThreadAndInitState();
        Assertions.checkArgument(i10 >= 0 && i10 <= i11);
        State state = this.state;
        int size = state.playlist.size();
        if (!shouldHandleCommand(20) || i10 > size) {
            return;
        }
        int min = Math.min(i11, size);
        updateStateForPendingOperation(handleReplaceMediaItems(i10, min, list), new z() { // from class: m0.g1

            /* renamed from: c */
            public final /* synthetic */ SimpleBasePlayer.State f28171c;

            /* renamed from: d */
            public final /* synthetic */ List f28172d;

            /* renamed from: e */
            public final /* synthetic */ int f28173e;

            /* renamed from: f */
            public final /* synthetic */ int f28174f;

            public /* synthetic */ g1(SimpleBasePlayer.State state2, List list2, int min2, int i102) {
                state = state2;
                list = list2;
                min = min2;
                i10 = i102;
            }

            @Override // b5.z
            public final Object get() {
                SimpleBasePlayer.State lambda$replaceMediaItems$5;
                lambda$replaceMediaItems$5 = SimpleBasePlayer.this.lambda$replaceMediaItems$5(state, list, min, i10);
                return lambda$replaceMediaItems$5;
            }
        });
    }

    @Override // androidx.media3.common.BasePlayer
    @VisibleForTesting(otherwise = 4)
    public final void seekTo(int i10, long j10, int i11, boolean z10) {
        verifyApplicationThreadAndInitState();
        Assertions.checkArgument(i10 >= 0);
        State state = this.state;
        if (!shouldHandleCommand(i11) || isPlayingAd()) {
            return;
        }
        if (state.playlist.isEmpty() || i10 < state.playlist.size()) {
            updateStateForPendingOperation(handleSeek(i10, j10, i11), new z() { // from class: m0.d2

                /* renamed from: c */
                public final /* synthetic */ int f28158c;

                /* renamed from: d */
                public final /* synthetic */ long f28159d;

                public /* synthetic */ d2(int i102, long j102) {
                    i10 = i102;
                    j10 = j102;
                }

                @Override // b5.z
                public final Object get() {
                    SimpleBasePlayer.State lambda$seekTo$10;
                    lambda$seekTo$10 = SimpleBasePlayer.lambda$seekTo$10(SimpleBasePlayer.State.this, i10, j10);
                    return lambda$seekTo$10;
                }
            }, true, z10);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: m0.z1.<init>(androidx.media3.common.SimpleBasePlayer$State, boolean):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // androidx.media3.common.Player
    @java.lang.Deprecated
    public final void setDeviceMuted(boolean r4) {
        /*
            r3 = this;
            r3.verifyApplicationThreadAndInitState()
            androidx.media3.common.SimpleBasePlayer$State r0 = r3.state
            r1 = 26
            boolean r1 = r3.shouldHandleCommand(r1)
            if (r1 != 0) goto Le
            return
        Le:
            r1 = 1
            p5.c0 r1 = r3.handleSetDeviceMuted(r4, r1)
            m0.z1 r2 = new m0.z1
            r2.<init>()
            r3.updateStateForPendingOperation(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.setDeviceMuted(boolean):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: m0.q0.<init>(androidx.media3.common.SimpleBasePlayer$State, int):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // androidx.media3.common.Player
    @java.lang.Deprecated
    public final void setDeviceVolume(int r4) {
        /*
            r3 = this;
            r3.verifyApplicationThreadAndInitState()
            androidx.media3.common.SimpleBasePlayer$State r0 = r3.state
            r1 = 25
            boolean r1 = r3.shouldHandleCommand(r1)
            if (r1 != 0) goto Le
            return
        Le:
            r1 = 1
            p5.c0 r1 = r3.handleSetDeviceVolume(r4, r1)
            m0.q0 r2 = new m0.q0
            r2.<init>()
            r3.updateStateForPendingOperation(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.setDeviceVolume(int):void");
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItems(List<MediaItem> list, boolean z10) {
        verifyApplicationThreadAndInitState();
        setMediaItemsInternal(list, z10 ? -1 : this.state.currentMediaItemIndex, z10 ? C.TIME_UNSET : this.state.contentPositionMsSupplier.get());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: m0.f0.<init>(androidx.media3.common.SimpleBasePlayer$State, boolean):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // androidx.media3.common.Player
    public final void setPlayWhenReady(boolean r4) {
        /*
            r3 = this;
            r3.verifyApplicationThreadAndInitState()
            androidx.media3.common.SimpleBasePlayer$State r0 = r3.state
            r1 = 1
            boolean r1 = r3.shouldHandleCommand(r1)
            if (r1 != 0) goto Ld
            return
        Ld:
            p5.c0 r1 = r3.handleSetPlayWhenReady(r4)
            m0.f0 r2 = new m0.f0
            r2.<init>()
            r3.updateStateForPendingOperation(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.setPlayWhenReady(boolean):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: m0.k2.<init>(androidx.media3.common.SimpleBasePlayer$State, androidx.media3.common.PlaybackParameters):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // androidx.media3.common.Player
    public final void setPlaybackParameters(androidx.media3.common.PlaybackParameters r4) {
        /*
            r3 = this;
            r3.verifyApplicationThreadAndInitState()
            androidx.media3.common.SimpleBasePlayer$State r0 = r3.state
            r1 = 13
            boolean r1 = r3.shouldHandleCommand(r1)
            if (r1 != 0) goto Le
            return
        Le:
            p5.c0 r1 = r3.handleSetPlaybackParameters(r4)
            m0.k2 r2 = new m0.k2
            r2.<init>()
            r3.updateStateForPendingOperation(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.setPlaybackParameters(androidx.media3.common.PlaybackParameters):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: m0.s1.<init>(androidx.media3.common.SimpleBasePlayer$State, androidx.media3.common.MediaMetadata):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // androidx.media3.common.Player
    public final void setPlaylistMetadata(androidx.media3.common.MediaMetadata r4) {
        /*
            r3 = this;
            r3.verifyApplicationThreadAndInitState()
            androidx.media3.common.SimpleBasePlayer$State r0 = r3.state
            r1 = 19
            boolean r1 = r3.shouldHandleCommand(r1)
            if (r1 != 0) goto Le
            return
        Le:
            p5.c0 r1 = r3.handleSetPlaylistMetadata(r4)
            m0.s1 r2 = new m0.s1
            r2.<init>()
            r3.updateStateForPendingOperation(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.setPlaylistMetadata(androidx.media3.common.MediaMetadata):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: m0.t1.<init>(androidx.media3.common.SimpleBasePlayer$State, int):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // androidx.media3.common.Player
    public final void setRepeatMode(int r4) {
        /*
            r3 = this;
            r3.verifyApplicationThreadAndInitState()
            androidx.media3.common.SimpleBasePlayer$State r0 = r3.state
            r1 = 15
            boolean r1 = r3.shouldHandleCommand(r1)
            if (r1 != 0) goto Le
            return
        Le:
            p5.c0 r1 = r3.handleSetRepeatMode(r4)
            m0.t1 r2 = new m0.t1
            r2.<init>()
            r3.updateStateForPendingOperation(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.setRepeatMode(int):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: m0.o1.<init>(androidx.media3.common.SimpleBasePlayer$State, boolean):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // androidx.media3.common.Player
    public final void setShuffleModeEnabled(boolean r4) {
        /*
            r3 = this;
            r3.verifyApplicationThreadAndInitState()
            androidx.media3.common.SimpleBasePlayer$State r0 = r3.state
            r1 = 14
            boolean r1 = r3.shouldHandleCommand(r1)
            if (r1 != 0) goto Le
            return
        Le:
            p5.c0 r1 = r3.handleSetShuffleModeEnabled(r4)
            m0.o1 r2 = new m0.o1
            r2.<init>()
            r3.updateStateForPendingOperation(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.setShuffleModeEnabled(boolean):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: m0.m2.<init>(androidx.media3.common.SimpleBasePlayer$State, androidx.media3.common.TrackSelectionParameters):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // androidx.media3.common.Player
    public final void setTrackSelectionParameters(androidx.media3.common.TrackSelectionParameters r4) {
        /*
            r3 = this;
            r3.verifyApplicationThreadAndInitState()
            androidx.media3.common.SimpleBasePlayer$State r0 = r3.state
            r1 = 29
            boolean r1 = r3.shouldHandleCommand(r1)
            if (r1 != 0) goto Le
            return
        Le:
            p5.c0 r1 = r3.handleSetTrackSelectionParameters(r4)
            m0.m2 r2 = new m0.m2
            r2.<init>()
            r3.updateStateForPendingOperation(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.setTrackSelectionParameters(androidx.media3.common.TrackSelectionParameters):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: m0.i1.<init>(androidx.media3.common.SimpleBasePlayer$State):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // androidx.media3.common.Player
    public final void setVideoSurface(@androidx.annotation.Nullable android.view.Surface r3) {
        /*
            r2 = this;
            r2.verifyApplicationThreadAndInitState()
            androidx.media3.common.SimpleBasePlayer$State r0 = r2.state
            r1 = 27
            boolean r1 = r2.shouldHandleCommand(r1)
            if (r1 != 0) goto Le
            return
        Le:
            if (r3 != 0) goto L14
            r2.clearVideoSurface()
            return
        L14:
            p5.c0 r3 = r2.handleSetVideoOutput(r3)
            m0.i1 r1 = new m0.i1
            r1.<init>()
            r2.updateStateForPendingOperation(r3, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.setVideoSurface(android.view.Surface):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: m0.v1.<init>(androidx.media3.common.SimpleBasePlayer$State, android.view.SurfaceHolder):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // androidx.media3.common.Player
    public final void setVideoSurfaceHolder(@androidx.annotation.Nullable android.view.SurfaceHolder r4) {
        /*
            r3 = this;
            r3.verifyApplicationThreadAndInitState()
            androidx.media3.common.SimpleBasePlayer$State r0 = r3.state
            r1 = 27
            boolean r1 = r3.shouldHandleCommand(r1)
            if (r1 != 0) goto Le
            return
        Le:
            if (r4 != 0) goto L14
            r3.clearVideoSurface()
            return
        L14:
            p5.c0 r1 = r3.handleSetVideoOutput(r4)
            m0.v1 r2 = new m0.v1
            r2.<init>()
            r3.updateStateForPendingOperation(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.setVideoSurfaceHolder(android.view.SurfaceHolder):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: m0.y1.<init>(androidx.media3.common.SimpleBasePlayer$State, android.view.SurfaceView):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // androidx.media3.common.Player
    public final void setVideoSurfaceView(@androidx.annotation.Nullable android.view.SurfaceView r4) {
        /*
            r3 = this;
            r3.verifyApplicationThreadAndInitState()
            androidx.media3.common.SimpleBasePlayer$State r0 = r3.state
            r1 = 27
            boolean r1 = r3.shouldHandleCommand(r1)
            if (r1 != 0) goto Le
            return
        Le:
            if (r4 != 0) goto L14
            r3.clearVideoSurface()
            return
        L14:
            p5.c0 r1 = r3.handleSetVideoOutput(r4)
            m0.y1 r2 = new m0.y1
            r2.<init>()
            r3.updateStateForPendingOperation(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.setVideoSurfaceView(android.view.SurfaceView):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: m0.b1.<init>(androidx.media3.common.SimpleBasePlayer$State, androidx.media3.common.util.Size):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // androidx.media3.common.Player
    public final void setVideoTextureView(@androidx.annotation.Nullable android.view.TextureView r5) {
        /*
            r4 = this;
            r4.verifyApplicationThreadAndInitState()
            androidx.media3.common.SimpleBasePlayer$State r0 = r4.state
            r1 = 27
            boolean r1 = r4.shouldHandleCommand(r1)
            if (r1 != 0) goto Le
            return
        Le:
            if (r5 != 0) goto L14
            r4.clearVideoSurface()
            return
        L14:
            boolean r1 = r5.isAvailable()
            if (r1 == 0) goto L28
            androidx.media3.common.util.Size r1 = new androidx.media3.common.util.Size
            int r2 = r5.getWidth()
            int r3 = r5.getHeight()
            r1.<init>(r2, r3)
            goto L2a
        L28:
            androidx.media3.common.util.Size r1 = androidx.media3.common.util.Size.ZERO
        L2a:
            p5.c0 r5 = r4.handleSetVideoOutput(r5)
            m0.b1 r2 = new m0.b1
            r2.<init>()
            r4.updateStateForPendingOperation(r5, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.setVideoTextureView(android.view.TextureView):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: m0.u1.<init>(androidx.media3.common.SimpleBasePlayer$State, float):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // androidx.media3.common.Player
    public final void setVolume(float r4) {
        /*
            r3 = this;
            r3.verifyApplicationThreadAndInitState()
            androidx.media3.common.SimpleBasePlayer$State r0 = r3.state
            r1 = 24
            boolean r1 = r3.shouldHandleCommand(r1)
            if (r1 != 0) goto Le
            return
        Le:
            p5.c0 r1 = r3.handleSetVolume(r4)
            m0.u1 r2 = new m0.u1
            r2.<init>()
            r3.updateStateForPendingOperation(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.setVolume(float):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: m0.g2.<init>(androidx.media3.common.SimpleBasePlayer$State):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // androidx.media3.common.Player
    public final void stop() {
        /*
            r3 = this;
            r3.verifyApplicationThreadAndInitState()
            androidx.media3.common.SimpleBasePlayer$State r0 = r3.state
            r1 = 3
            boolean r1 = r3.shouldHandleCommand(r1)
            if (r1 != 0) goto Ld
            return
        Ld:
            p5.c0 r1 = r3.handleStop()
            m0.g2 r2 = new m0.g2
            r2.<init>()
            r3.updateStateForPendingOperation(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.stop():void");
    }

    public SimpleBasePlayer(Looper looper, Clock clock) {
        this.applicationLooper = looper;
        this.applicationHandler = clock.createHandler(looper, null);
        this.pendingOperations = new HashSet<>();
        this.period = new Timeline.Period();
        this.listeners = new ListenerSet<>(looper, clock, new ListenerSet.IterationFinishedEvent() { // from class: m0.r1
            public /* synthetic */ r1() {
            }

            @Override // androidx.media3.common.util.ListenerSet.IterationFinishedEvent
            public final void invoke(Object obj, FlagSet flagSet) {
                SimpleBasePlayer.this.lambda$new$0((Player.Listener) obj, flagSet);
            }
        });
    }

    @RequiresNonNull({"state"})
    private void updateStateForPendingOperation(c0<?> c0Var, z<State> zVar, boolean z10, boolean z11) {
        if (c0Var.isDone() && this.pendingOperations.isEmpty()) {
            updateStateAndInformListeners(getState(), z10, z11);
            return;
        }
        this.pendingOperations.add(c0Var);
        updateStateAndInformListeners(getPlaceholderState(zVar.get()), z10, z11);
        c0Var.addListener(new Runnable() { // from class: m0.j1

            /* renamed from: c */
            public final /* synthetic */ p5.c0 f28188c;

            public /* synthetic */ j1(p5.c0 c0Var2) {
                c0Var = c0Var2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SimpleBasePlayer.this.lambda$updateStateForPendingOperation$61(c0Var);
            }
        }, new Executor() { // from class: m0.k1
            public /* synthetic */ k1() {
            }

            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                SimpleBasePlayer.this.postOrRunOnApplicationHandler(runnable);
            }
        });
    }

    @Override // androidx.media3.common.Player
    public final void clearVideoSurface(@Nullable Surface surface) {
        clearVideoOutput(surface);
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItems(List<MediaItem> list, int i10, long j10) {
        verifyApplicationThreadAndInitState();
        if (i10 == -1) {
            State state = this.state;
            int i11 = state.currentMediaItemIndex;
            long j11 = state.contentPositionMsSupplier.get();
            i10 = i11;
            j10 = j11;
        }
        setMediaItemsInternal(list, i10, j10);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: m0.j2.<init>(androidx.media3.common.SimpleBasePlayer$State):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // androidx.media3.common.Player
    public final void decreaseDeviceVolume(int r3) {
        /*
            r2 = this;
            r2.verifyApplicationThreadAndInitState()
            androidx.media3.common.SimpleBasePlayer$State r0 = r2.state
            r1 = 34
            boolean r1 = r2.shouldHandleCommand(r1)
            if (r1 != 0) goto Le
            return
        Le:
            p5.c0 r3 = r2.handleDecreaseDeviceVolume(r3)
            m0.j2 r1 = new m0.j2
            r1.<init>()
            r2.updateStateForPendingOperation(r3, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.decreaseDeviceVolume(int):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: m0.l1.<init>(androidx.media3.common.SimpleBasePlayer$State):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // androidx.media3.common.Player
    public final void increaseDeviceVolume(int r3) {
        /*
            r2 = this;
            r2.verifyApplicationThreadAndInitState()
            androidx.media3.common.SimpleBasePlayer$State r0 = r2.state
            r1 = 34
            boolean r1 = r2.shouldHandleCommand(r1)
            if (r1 != 0) goto Le
            return
        Le:
            p5.c0 r3 = r2.handleIncreaseDeviceVolume(r3)
            m0.l1 r1 = new m0.l1
            r1.<init>()
            r2.updateStateForPendingOperation(r3, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.increaseDeviceVolume(int):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: m0.l2.<init>(androidx.media3.common.SimpleBasePlayer$State, boolean):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // androidx.media3.common.Player
    public final void setDeviceMuted(boolean r3, int r4) {
        /*
            r2 = this;
            r2.verifyApplicationThreadAndInitState()
            androidx.media3.common.SimpleBasePlayer$State r0 = r2.state
            r1 = 34
            boolean r1 = r2.shouldHandleCommand(r1)
            if (r1 != 0) goto Le
            return
        Le:
            p5.c0 r4 = r2.handleSetDeviceMuted(r3, r4)
            m0.l2 r1 = new m0.l2
            r1.<init>()
            r2.updateStateForPendingOperation(r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.setDeviceMuted(boolean, int):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: m0.p1.<init>(androidx.media3.common.SimpleBasePlayer$State, int):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // androidx.media3.common.Player
    public final void setDeviceVolume(int r3, int r4) {
        /*
            r2 = this;
            r2.verifyApplicationThreadAndInitState()
            androidx.media3.common.SimpleBasePlayer$State r0 = r2.state
            r1 = 33
            boolean r1 = r2.shouldHandleCommand(r1)
            if (r1 != 0) goto Le
            return
        Le:
            p5.c0 r4 = r2.handleSetDeviceVolume(r3, r4)
            m0.p1 r1 = new m0.p1
            r1.<init>()
            r2.updateStateForPendingOperation(r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.setDeviceVolume(int, int):void");
    }

    public static /* synthetic */ c0 lambda$handleReplaceMediaItems$30(c0 c0Var, Object obj) throws Exception {
        return c0Var;
    }
}
