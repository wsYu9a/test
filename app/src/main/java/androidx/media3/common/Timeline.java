package androidx.media3.common;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.Bundleable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BundleUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.InlineMe;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class Timeline implements Bundleable {
    public static final Timeline EMPTY = new Timeline() { // from class: androidx.media3.common.Timeline.1
        @Override // androidx.media3.common.Timeline
        public int getIndexOfPeriod(Object obj) {
            return -1;
        }

        @Override // androidx.media3.common.Timeline
        public Period getPeriod(int i10, Period period, boolean z10) {
            throw new IndexOutOfBoundsException();
        }

        @Override // androidx.media3.common.Timeline
        public int getPeriodCount() {
            return 0;
        }

        @Override // androidx.media3.common.Timeline
        public Object getUidOfPeriod(int i10) {
            throw new IndexOutOfBoundsException();
        }

        @Override // androidx.media3.common.Timeline
        public Window getWindow(int i10, Window window, long j10) {
            throw new IndexOutOfBoundsException();
        }

        @Override // androidx.media3.common.Timeline
        public int getWindowCount() {
            return 0;
        }
    };
    private static final String FIELD_WINDOWS = Util.intToStringMaxRadix(0);
    private static final String FIELD_PERIODS = Util.intToStringMaxRadix(1);
    private static final String FIELD_SHUFFLED_WINDOW_INDICES = Util.intToStringMaxRadix(2);

    @UnstableApi
    public static final Bundleable.Creator<Timeline> CREATOR = new Bundleable.Creator() { // from class: m0.w2
        @Override // androidx.media3.common.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            Timeline fromBundle;
            fromBundle = Timeline.fromBundle(bundle);
            return fromBundle;
        }
    };

    /* renamed from: androidx.media3.common.Timeline$1 */
    public class AnonymousClass1 extends Timeline {
        @Override // androidx.media3.common.Timeline
        public int getIndexOfPeriod(Object obj) {
            return -1;
        }

        @Override // androidx.media3.common.Timeline
        public Period getPeriod(int i10, Period period, boolean z10) {
            throw new IndexOutOfBoundsException();
        }

        @Override // androidx.media3.common.Timeline
        public int getPeriodCount() {
            return 0;
        }

        @Override // androidx.media3.common.Timeline
        public Object getUidOfPeriod(int i10) {
            throw new IndexOutOfBoundsException();
        }

        @Override // androidx.media3.common.Timeline
        public Window getWindow(int i10, Window window, long j10) {
            throw new IndexOutOfBoundsException();
        }

        @Override // androidx.media3.common.Timeline
        public int getWindowCount() {
            return 0;
        }
    }

    public static final class Period implements Bundleable {
        private AdPlaybackState adPlaybackState = AdPlaybackState.NONE;

        @UnstableApi
        public long durationUs;

        /* renamed from: id */
        @Nullable
        public Object f375id;
        public boolean isPlaceholder;

        @UnstableApi
        public long positionInWindowUs;

        @Nullable
        public Object uid;
        public int windowIndex;
        private static final String FIELD_WINDOW_INDEX = Util.intToStringMaxRadix(0);
        private static final String FIELD_DURATION_US = Util.intToStringMaxRadix(1);
        private static final String FIELD_POSITION_IN_WINDOW_US = Util.intToStringMaxRadix(2);
        private static final String FIELD_PLACEHOLDER = Util.intToStringMaxRadix(3);
        private static final String FIELD_AD_PLAYBACK_STATE = Util.intToStringMaxRadix(4);

        @UnstableApi
        public static final Bundleable.Creator<Period> CREATOR = new Bundleable.Creator() { // from class: m0.x2
            @Override // androidx.media3.common.Bundleable.Creator
            public final Bundleable fromBundle(Bundle bundle) {
                Timeline.Period fromBundle;
                fromBundle = Timeline.Period.fromBundle(bundle);
                return fromBundle;
            }
        };

        public static Period fromBundle(Bundle bundle) {
            int i10 = bundle.getInt(FIELD_WINDOW_INDEX, 0);
            long j10 = bundle.getLong(FIELD_DURATION_US, C.TIME_UNSET);
            long j11 = bundle.getLong(FIELD_POSITION_IN_WINDOW_US, 0L);
            boolean z10 = bundle.getBoolean(FIELD_PLACEHOLDER, false);
            Bundle bundle2 = bundle.getBundle(FIELD_AD_PLAYBACK_STATE);
            AdPlaybackState fromBundle = bundle2 != null ? AdPlaybackState.CREATOR.fromBundle(bundle2) : AdPlaybackState.NONE;
            Period period = new Period();
            period.set(null, null, i10, j10, j11, fromBundle, z10);
            return period;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Period.class.equals(obj.getClass())) {
                return false;
            }
            Period period = (Period) obj;
            return Util.areEqual(this.f375id, period.f375id) && Util.areEqual(this.uid, period.uid) && this.windowIndex == period.windowIndex && this.durationUs == period.durationUs && this.positionInWindowUs == period.positionInWindowUs && this.isPlaceholder == period.isPlaceholder && Util.areEqual(this.adPlaybackState, period.adPlaybackState);
        }

        public int getAdCountInAdGroup(int i10) {
            return this.adPlaybackState.getAdGroup(i10).count;
        }

        public long getAdDurationUs(int i10, int i11) {
            AdPlaybackState.AdGroup adGroup = this.adPlaybackState.getAdGroup(i10);
            return adGroup.count != -1 ? adGroup.durationsUs[i11] : C.TIME_UNSET;
        }

        public int getAdGroupCount() {
            return this.adPlaybackState.adGroupCount;
        }

        public int getAdGroupIndexAfterPositionUs(long j10) {
            return this.adPlaybackState.getAdGroupIndexAfterPositionUs(j10, this.durationUs);
        }

        public int getAdGroupIndexForPositionUs(long j10) {
            return this.adPlaybackState.getAdGroupIndexForPositionUs(j10, this.durationUs);
        }

        public long getAdGroupTimeUs(int i10) {
            return this.adPlaybackState.getAdGroup(i10).timeUs;
        }

        public long getAdResumePositionUs() {
            return this.adPlaybackState.adResumePositionUs;
        }

        @UnstableApi
        public int getAdState(int i10, int i11) {
            AdPlaybackState.AdGroup adGroup = this.adPlaybackState.getAdGroup(i10);
            if (adGroup.count != -1) {
                return adGroup.states[i11];
            }
            return 0;
        }

        @Nullable
        public Object getAdsId() {
            return this.adPlaybackState.adsId;
        }

        @UnstableApi
        public long getContentResumeOffsetUs(int i10) {
            return this.adPlaybackState.getAdGroup(i10).contentResumeOffsetUs;
        }

        public long getDurationMs() {
            return Util.usToMs(this.durationUs);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public int getFirstAdIndexToPlay(int i10) {
            return this.adPlaybackState.getAdGroup(i10).getFirstAdIndexToPlay();
        }

        public int getNextAdIndexToPlay(int i10, int i11) {
            return this.adPlaybackState.getAdGroup(i10).getNextAdIndexToPlay(i11);
        }

        public long getPositionInWindowMs() {
            return Util.usToMs(this.positionInWindowUs);
        }

        public long getPositionInWindowUs() {
            return this.positionInWindowUs;
        }

        public int getRemovedAdGroupCount() {
            return this.adPlaybackState.removedAdGroupCount;
        }

        public boolean hasPlayedAdGroup(int i10) {
            return !this.adPlaybackState.getAdGroup(i10).hasUnplayedAds();
        }

        public int hashCode() {
            Object obj = this.f375id;
            int hashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.uid;
            int hashCode2 = (((hashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.windowIndex) * 31;
            long j10 = this.durationUs;
            int i10 = (hashCode2 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
            long j11 = this.positionInWindowUs;
            return ((((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + (this.isPlaceholder ? 1 : 0)) * 31) + this.adPlaybackState.hashCode();
        }

        @UnstableApi
        public boolean isLivePostrollPlaceholder(int i10) {
            return i10 == getAdGroupCount() - 1 && this.adPlaybackState.isLivePostrollPlaceholder(i10);
        }

        @UnstableApi
        public boolean isServerSideInsertedAdGroup(int i10) {
            return this.adPlaybackState.getAdGroup(i10).isServerSideInserted;
        }

        @CanIgnoreReturnValue
        @UnstableApi
        public Period set(@Nullable Object obj, @Nullable Object obj2, int i10, long j10, long j11) {
            return set(obj, obj2, i10, j10, j11, AdPlaybackState.NONE, false);
        }

        @Override // androidx.media3.common.Bundleable
        @UnstableApi
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            int i10 = this.windowIndex;
            if (i10 != 0) {
                bundle.putInt(FIELD_WINDOW_INDEX, i10);
            }
            long j10 = this.durationUs;
            if (j10 != C.TIME_UNSET) {
                bundle.putLong(FIELD_DURATION_US, j10);
            }
            long j11 = this.positionInWindowUs;
            if (j11 != 0) {
                bundle.putLong(FIELD_POSITION_IN_WINDOW_US, j11);
            }
            boolean z10 = this.isPlaceholder;
            if (z10) {
                bundle.putBoolean(FIELD_PLACEHOLDER, z10);
            }
            if (!this.adPlaybackState.equals(AdPlaybackState.NONE)) {
                bundle.putBundle(FIELD_AD_PLAYBACK_STATE, this.adPlaybackState.toBundle());
            }
            return bundle;
        }

        @CanIgnoreReturnValue
        @UnstableApi
        public Period set(@Nullable Object obj, @Nullable Object obj2, int i10, long j10, long j11, AdPlaybackState adPlaybackState, boolean z10) {
            this.f375id = obj;
            this.uid = obj2;
            this.windowIndex = i10;
            this.durationUs = j10;
            this.positionInWindowUs = j11;
            this.adPlaybackState = adPlaybackState;
            this.isPlaceholder = z10;
            return this;
        }
    }

    @UnstableApi
    public static final class RemotableTimeline extends Timeline {
        private final ImmutableList<Period> periods;
        private final int[] shuffledWindowIndices;
        private final int[] windowIndicesInShuffled;
        private final ImmutableList<Window> windows;

        public RemotableTimeline(ImmutableList<Window> immutableList, ImmutableList<Period> immutableList2, int[] iArr) {
            Assertions.checkArgument(immutableList.size() == iArr.length);
            this.windows = immutableList;
            this.periods = immutableList2;
            this.shuffledWindowIndices = iArr;
            this.windowIndicesInShuffled = new int[iArr.length];
            for (int i10 = 0; i10 < iArr.length; i10++) {
                this.windowIndicesInShuffled[iArr[i10]] = i10;
            }
        }

        @Override // androidx.media3.common.Timeline
        public int getFirstWindowIndex(boolean z10) {
            if (isEmpty()) {
                return -1;
            }
            if (z10) {
                return this.shuffledWindowIndices[0];
            }
            return 0;
        }

        @Override // androidx.media3.common.Timeline
        public int getIndexOfPeriod(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.media3.common.Timeline
        public int getLastWindowIndex(boolean z10) {
            if (isEmpty()) {
                return -1;
            }
            return z10 ? this.shuffledWindowIndices[getWindowCount() - 1] : getWindowCount() - 1;
        }

        @Override // androidx.media3.common.Timeline
        public int getNextWindowIndex(int i10, int i11, boolean z10) {
            if (i11 == 1) {
                return i10;
            }
            if (i10 != getLastWindowIndex(z10)) {
                return z10 ? this.shuffledWindowIndices[this.windowIndicesInShuffled[i10] + 1] : i10 + 1;
            }
            if (i11 == 2) {
                return getFirstWindowIndex(z10);
            }
            return -1;
        }

        @Override // androidx.media3.common.Timeline
        public Period getPeriod(int i10, Period period, boolean z10) {
            Period period2 = this.periods.get(i10);
            period.set(period2.f375id, period2.uid, period2.windowIndex, period2.durationUs, period2.positionInWindowUs, period2.adPlaybackState, period2.isPlaceholder);
            return period;
        }

        @Override // androidx.media3.common.Timeline
        public int getPeriodCount() {
            return this.periods.size();
        }

        @Override // androidx.media3.common.Timeline
        public int getPreviousWindowIndex(int i10, int i11, boolean z10) {
            if (i11 == 1) {
                return i10;
            }
            if (i10 != getFirstWindowIndex(z10)) {
                return z10 ? this.shuffledWindowIndices[this.windowIndicesInShuffled[i10] - 1] : i10 - 1;
            }
            if (i11 == 2) {
                return getLastWindowIndex(z10);
            }
            return -1;
        }

        @Override // androidx.media3.common.Timeline
        public Object getUidOfPeriod(int i10) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.media3.common.Timeline
        public Window getWindow(int i10, Window window, long j10) {
            Window window2 = this.windows.get(i10);
            window.set(window2.uid, window2.mediaItem, window2.manifest, window2.presentationStartTimeMs, window2.windowStartTimeMs, window2.elapsedRealtimeEpochOffsetMs, window2.isSeekable, window2.isDynamic, window2.liveConfiguration, window2.defaultPositionUs, window2.durationUs, window2.firstPeriodIndex, window2.lastPeriodIndex, window2.positionInFirstPeriodUs);
            window.isPlaceholder = window2.isPlaceholder;
            return window;
        }

        @Override // androidx.media3.common.Timeline
        public int getWindowCount() {
            return this.windows.size();
        }
    }

    public static final class Window implements Bundleable {

        @UnstableApi
        public long defaultPositionUs;

        @UnstableApi
        public long durationUs;
        public long elapsedRealtimeEpochOffsetMs;
        public int firstPeriodIndex;
        public boolean isDynamic;

        @UnstableApi
        @Deprecated
        public boolean isLive;
        public boolean isPlaceholder;
        public boolean isSeekable;
        public int lastPeriodIndex;

        @Nullable
        public MediaItem.LiveConfiguration liveConfiguration;

        @Nullable
        public Object manifest;

        @UnstableApi
        public long positionInFirstPeriodUs;
        public long presentationStartTimeMs;

        @Nullable
        @UnstableApi
        @Deprecated
        public Object tag;
        public long windowStartTimeMs;
        public static final Object SINGLE_WINDOW_UID = new Object();
        private static final Object FAKE_WINDOW_UID = new Object();
        private static final MediaItem PLACEHOLDER_MEDIA_ITEM = new MediaItem.Builder().setMediaId("androidx.media3.common.Timeline").setUri(Uri.EMPTY).build();
        private static final String FIELD_MEDIA_ITEM = Util.intToStringMaxRadix(1);
        private static final String FIELD_PRESENTATION_START_TIME_MS = Util.intToStringMaxRadix(2);
        private static final String FIELD_WINDOW_START_TIME_MS = Util.intToStringMaxRadix(3);
        private static final String FIELD_ELAPSED_REALTIME_EPOCH_OFFSET_MS = Util.intToStringMaxRadix(4);
        private static final String FIELD_IS_SEEKABLE = Util.intToStringMaxRadix(5);
        private static final String FIELD_IS_DYNAMIC = Util.intToStringMaxRadix(6);
        private static final String FIELD_LIVE_CONFIGURATION = Util.intToStringMaxRadix(7);
        private static final String FIELD_IS_PLACEHOLDER = Util.intToStringMaxRadix(8);
        private static final String FIELD_DEFAULT_POSITION_US = Util.intToStringMaxRadix(9);
        private static final String FIELD_DURATION_US = Util.intToStringMaxRadix(10);
        private static final String FIELD_FIRST_PERIOD_INDEX = Util.intToStringMaxRadix(11);
        private static final String FIELD_LAST_PERIOD_INDEX = Util.intToStringMaxRadix(12);
        private static final String FIELD_POSITION_IN_FIRST_PERIOD_US = Util.intToStringMaxRadix(13);

        @UnstableApi
        public static final Bundleable.Creator<Window> CREATOR = new Bundleable.Creator() { // from class: m0.y2
            @Override // androidx.media3.common.Bundleable.Creator
            public final Bundleable fromBundle(Bundle bundle) {
                Timeline.Window fromBundle;
                fromBundle = Timeline.Window.fromBundle(bundle);
                return fromBundle;
            }
        };
        public Object uid = SINGLE_WINDOW_UID;
        public MediaItem mediaItem = PLACEHOLDER_MEDIA_ITEM;

        public static Window fromBundle(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle(FIELD_MEDIA_ITEM);
            MediaItem fromBundle = bundle2 != null ? MediaItem.CREATOR.fromBundle(bundle2) : MediaItem.EMPTY;
            long j10 = bundle.getLong(FIELD_PRESENTATION_START_TIME_MS, C.TIME_UNSET);
            long j11 = bundle.getLong(FIELD_WINDOW_START_TIME_MS, C.TIME_UNSET);
            long j12 = bundle.getLong(FIELD_ELAPSED_REALTIME_EPOCH_OFFSET_MS, C.TIME_UNSET);
            boolean z10 = bundle.getBoolean(FIELD_IS_SEEKABLE, false);
            boolean z11 = bundle.getBoolean(FIELD_IS_DYNAMIC, false);
            Bundle bundle3 = bundle.getBundle(FIELD_LIVE_CONFIGURATION);
            MediaItem.LiveConfiguration fromBundle2 = bundle3 != null ? MediaItem.LiveConfiguration.CREATOR.fromBundle(bundle3) : null;
            boolean z12 = bundle.getBoolean(FIELD_IS_PLACEHOLDER, false);
            long j13 = bundle.getLong(FIELD_DEFAULT_POSITION_US, 0L);
            long j14 = bundle.getLong(FIELD_DURATION_US, C.TIME_UNSET);
            int i10 = bundle.getInt(FIELD_FIRST_PERIOD_INDEX, 0);
            int i11 = bundle.getInt(FIELD_LAST_PERIOD_INDEX, 0);
            long j15 = bundle.getLong(FIELD_POSITION_IN_FIRST_PERIOD_US, 0L);
            Window window = new Window();
            window.set(FAKE_WINDOW_UID, fromBundle, null, j10, j11, j12, z10, z11, fromBundle2, j13, j14, i10, i11, j15);
            window.isPlaceholder = z12;
            return window;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Window.class.equals(obj.getClass())) {
                return false;
            }
            Window window = (Window) obj;
            return Util.areEqual(this.uid, window.uid) && Util.areEqual(this.mediaItem, window.mediaItem) && Util.areEqual(this.manifest, window.manifest) && Util.areEqual(this.liveConfiguration, window.liveConfiguration) && this.presentationStartTimeMs == window.presentationStartTimeMs && this.windowStartTimeMs == window.windowStartTimeMs && this.elapsedRealtimeEpochOffsetMs == window.elapsedRealtimeEpochOffsetMs && this.isSeekable == window.isSeekable && this.isDynamic == window.isDynamic && this.isPlaceholder == window.isPlaceholder && this.defaultPositionUs == window.defaultPositionUs && this.durationUs == window.durationUs && this.firstPeriodIndex == window.firstPeriodIndex && this.lastPeriodIndex == window.lastPeriodIndex && this.positionInFirstPeriodUs == window.positionInFirstPeriodUs;
        }

        public long getCurrentUnixTimeMs() {
            return Util.getNowUnixTimeMs(this.elapsedRealtimeEpochOffsetMs);
        }

        public long getDefaultPositionMs() {
            return Util.usToMs(this.defaultPositionUs);
        }

        public long getDefaultPositionUs() {
            return this.defaultPositionUs;
        }

        public long getDurationMs() {
            return Util.usToMs(this.durationUs);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public long getPositionInFirstPeriodMs() {
            return Util.usToMs(this.positionInFirstPeriodUs);
        }

        public long getPositionInFirstPeriodUs() {
            return this.positionInFirstPeriodUs;
        }

        public int hashCode() {
            int hashCode = (((217 + this.uid.hashCode()) * 31) + this.mediaItem.hashCode()) * 31;
            Object obj = this.manifest;
            int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            MediaItem.LiveConfiguration liveConfiguration = this.liveConfiguration;
            int hashCode3 = (hashCode2 + (liveConfiguration != null ? liveConfiguration.hashCode() : 0)) * 31;
            long j10 = this.presentationStartTimeMs;
            int i10 = (hashCode3 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
            long j11 = this.windowStartTimeMs;
            int i11 = (i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.elapsedRealtimeEpochOffsetMs;
            int i12 = (((((((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.isSeekable ? 1 : 0)) * 31) + (this.isDynamic ? 1 : 0)) * 31) + (this.isPlaceholder ? 1 : 0)) * 31;
            long j13 = this.defaultPositionUs;
            int i13 = (i12 + ((int) (j13 ^ (j13 >>> 32)))) * 31;
            long j14 = this.durationUs;
            int i14 = (((((i13 + ((int) (j14 ^ (j14 >>> 32)))) * 31) + this.firstPeriodIndex) * 31) + this.lastPeriodIndex) * 31;
            long j15 = this.positionInFirstPeriodUs;
            return i14 + ((int) (j15 ^ (j15 >>> 32)));
        }

        public boolean isLive() {
            Assertions.checkState(this.isLive == (this.liveConfiguration != null));
            return this.liveConfiguration != null;
        }

        @CanIgnoreReturnValue
        @UnstableApi
        public Window set(Object obj, @Nullable MediaItem mediaItem, @Nullable Object obj2, long j10, long j11, long j12, boolean z10, boolean z11, @Nullable MediaItem.LiveConfiguration liveConfiguration, long j13, long j14, int i10, int i11, long j15) {
            MediaItem.LocalConfiguration localConfiguration;
            this.uid = obj;
            this.mediaItem = mediaItem != null ? mediaItem : PLACEHOLDER_MEDIA_ITEM;
            this.tag = (mediaItem == null || (localConfiguration = mediaItem.localConfiguration) == null) ? null : localConfiguration.tag;
            this.manifest = obj2;
            this.presentationStartTimeMs = j10;
            this.windowStartTimeMs = j11;
            this.elapsedRealtimeEpochOffsetMs = j12;
            this.isSeekable = z10;
            this.isDynamic = z11;
            this.isLive = liveConfiguration != null;
            this.liveConfiguration = liveConfiguration;
            this.defaultPositionUs = j13;
            this.durationUs = j14;
            this.firstPeriodIndex = i10;
            this.lastPeriodIndex = i11;
            this.positionInFirstPeriodUs = j15;
            this.isPlaceholder = false;
            return this;
        }

        @Override // androidx.media3.common.Bundleable
        @UnstableApi
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            if (!MediaItem.EMPTY.equals(this.mediaItem)) {
                bundle.putBundle(FIELD_MEDIA_ITEM, this.mediaItem.toBundle());
            }
            long j10 = this.presentationStartTimeMs;
            if (j10 != C.TIME_UNSET) {
                bundle.putLong(FIELD_PRESENTATION_START_TIME_MS, j10);
            }
            long j11 = this.windowStartTimeMs;
            if (j11 != C.TIME_UNSET) {
                bundle.putLong(FIELD_WINDOW_START_TIME_MS, j11);
            }
            long j12 = this.elapsedRealtimeEpochOffsetMs;
            if (j12 != C.TIME_UNSET) {
                bundle.putLong(FIELD_ELAPSED_REALTIME_EPOCH_OFFSET_MS, j12);
            }
            boolean z10 = this.isSeekable;
            if (z10) {
                bundle.putBoolean(FIELD_IS_SEEKABLE, z10);
            }
            boolean z11 = this.isDynamic;
            if (z11) {
                bundle.putBoolean(FIELD_IS_DYNAMIC, z11);
            }
            MediaItem.LiveConfiguration liveConfiguration = this.liveConfiguration;
            if (liveConfiguration != null) {
                bundle.putBundle(FIELD_LIVE_CONFIGURATION, liveConfiguration.toBundle());
            }
            boolean z12 = this.isPlaceholder;
            if (z12) {
                bundle.putBoolean(FIELD_IS_PLACEHOLDER, z12);
            }
            long j13 = this.defaultPositionUs;
            if (j13 != 0) {
                bundle.putLong(FIELD_DEFAULT_POSITION_US, j13);
            }
            long j14 = this.durationUs;
            if (j14 != C.TIME_UNSET) {
                bundle.putLong(FIELD_DURATION_US, j14);
            }
            int i10 = this.firstPeriodIndex;
            if (i10 != 0) {
                bundle.putInt(FIELD_FIRST_PERIOD_INDEX, i10);
            }
            int i11 = this.lastPeriodIndex;
            if (i11 != 0) {
                bundle.putInt(FIELD_LAST_PERIOD_INDEX, i11);
            }
            long j15 = this.positionInFirstPeriodUs;
            if (j15 != 0) {
                bundle.putLong(FIELD_POSITION_IN_FIRST_PERIOD_US, j15);
            }
            return bundle;
        }
    }

    @UnstableApi
    public Timeline() {
    }

    public static Timeline fromBundle(Bundle bundle) {
        ImmutableList fromBundleListRetriever = fromBundleListRetriever(Window.CREATOR, BundleUtil.getBinder(bundle, FIELD_WINDOWS));
        ImmutableList fromBundleListRetriever2 = fromBundleListRetriever(Period.CREATOR, BundleUtil.getBinder(bundle, FIELD_PERIODS));
        int[] intArray = bundle.getIntArray(FIELD_SHUFFLED_WINDOW_INDICES);
        if (intArray == null) {
            intArray = generateUnshuffledIndices(fromBundleListRetriever.size());
        }
        return new RemotableTimeline(fromBundleListRetriever, fromBundleListRetriever2, intArray);
    }

    private static <T extends Bundleable> ImmutableList<T> fromBundleListRetriever(Bundleable.Creator<T> creator, @Nullable IBinder iBinder) {
        if (iBinder == null) {
            return ImmutableList.of();
        }
        ImmutableList.a aVar = new ImmutableList.a();
        ImmutableList<Bundle> list = BundleListRetriever.getList(iBinder);
        for (int i10 = 0; i10 < list.size(); i10++) {
            aVar.a(creator.fromBundle(list.get(i10)));
        }
        return aVar.e();
    }

    private static int[] generateUnshuffledIndices(int i10) {
        int[] iArr = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr[i11] = i11;
        }
        return iArr;
    }

    public boolean equals(@Nullable Object obj) {
        int lastWindowIndex;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Timeline)) {
            return false;
        }
        Timeline timeline = (Timeline) obj;
        if (timeline.getWindowCount() != getWindowCount() || timeline.getPeriodCount() != getPeriodCount()) {
            return false;
        }
        Window window = new Window();
        Period period = new Period();
        Window window2 = new Window();
        Period period2 = new Period();
        for (int i10 = 0; i10 < getWindowCount(); i10++) {
            if (!getWindow(i10, window).equals(timeline.getWindow(i10, window2))) {
                return false;
            }
        }
        for (int i11 = 0; i11 < getPeriodCount(); i11++) {
            if (!getPeriod(i11, period, true).equals(timeline.getPeriod(i11, period2, true))) {
                return false;
            }
        }
        int firstWindowIndex = getFirstWindowIndex(true);
        if (firstWindowIndex != timeline.getFirstWindowIndex(true) || (lastWindowIndex = getLastWindowIndex(true)) != timeline.getLastWindowIndex(true)) {
            return false;
        }
        while (firstWindowIndex != lastWindowIndex) {
            int nextWindowIndex = getNextWindowIndex(firstWindowIndex, 0, true);
            if (nextWindowIndex != timeline.getNextWindowIndex(firstWindowIndex, 0, true)) {
                return false;
            }
            firstWindowIndex = nextWindowIndex;
        }
        return true;
    }

    public int getFirstWindowIndex(boolean z10) {
        return isEmpty() ? -1 : 0;
    }

    public abstract int getIndexOfPeriod(Object obj);

    public int getLastWindowIndex(boolean z10) {
        if (isEmpty()) {
            return -1;
        }
        return getWindowCount() - 1;
    }

    public final int getNextPeriodIndex(int i10, Period period, Window window, int i11, boolean z10) {
        int i12 = getPeriod(i10, period).windowIndex;
        if (getWindow(i12, window).lastPeriodIndex != i10) {
            return i10 + 1;
        }
        int nextWindowIndex = getNextWindowIndex(i12, i11, z10);
        if (nextWindowIndex == -1) {
            return -1;
        }
        return getWindow(nextWindowIndex, window).firstPeriodIndex;
    }

    public int getNextWindowIndex(int i10, int i11, boolean z10) {
        if (i11 == 0) {
            if (i10 == getLastWindowIndex(z10)) {
                return -1;
            }
            return i10 + 1;
        }
        if (i11 == 1) {
            return i10;
        }
        if (i11 == 2) {
            return i10 == getLastWindowIndex(z10) ? getFirstWindowIndex(z10) : i10 + 1;
        }
        throw new IllegalStateException();
    }

    public final Period getPeriod(int i10, Period period) {
        return getPeriod(i10, period, false);
    }

    public abstract Period getPeriod(int i10, Period period, boolean z10);

    public Period getPeriodByUid(Object obj, Period period) {
        return getPeriod(getIndexOfPeriod(obj), period, true);
    }

    public abstract int getPeriodCount();

    @InlineMe(replacement = "this.getPeriodPositionUs(window, period, windowIndex, windowPositionUs)")
    @UnstableApi
    @Deprecated
    public final Pair<Object, Long> getPeriodPosition(Window window, Period period, int i10, long j10) {
        return getPeriodPositionUs(window, period, i10, j10);
    }

    public final Pair<Object, Long> getPeriodPositionUs(Window window, Period period, int i10, long j10) {
        return (Pair) Assertions.checkNotNull(getPeriodPositionUs(window, period, i10, j10, 0L));
    }

    public int getPreviousWindowIndex(int i10, int i11, boolean z10) {
        if (i11 == 0) {
            if (i10 == getFirstWindowIndex(z10)) {
                return -1;
            }
            return i10 - 1;
        }
        if (i11 == 1) {
            return i10;
        }
        if (i11 == 2) {
            return i10 == getFirstWindowIndex(z10) ? getLastWindowIndex(z10) : i10 - 1;
        }
        throw new IllegalStateException();
    }

    public abstract Object getUidOfPeriod(int i10);

    public final Window getWindow(int i10, Window window) {
        return getWindow(i10, window, 0L);
    }

    public abstract Window getWindow(int i10, Window window, long j10);

    public abstract int getWindowCount();

    public int hashCode() {
        Window window = new Window();
        Period period = new Period();
        int windowCount = 217 + getWindowCount();
        for (int i10 = 0; i10 < getWindowCount(); i10++) {
            windowCount = (windowCount * 31) + getWindow(i10, window).hashCode();
        }
        int periodCount = (windowCount * 31) + getPeriodCount();
        for (int i11 = 0; i11 < getPeriodCount(); i11++) {
            periodCount = (periodCount * 31) + getPeriod(i11, period, true).hashCode();
        }
        int firstWindowIndex = getFirstWindowIndex(true);
        while (firstWindowIndex != -1) {
            periodCount = (periodCount * 31) + firstWindowIndex;
            firstWindowIndex = getNextWindowIndex(firstWindowIndex, 0, true);
        }
        return periodCount;
    }

    public final boolean isEmpty() {
        return getWindowCount() == 0;
    }

    public final boolean isLastPeriod(int i10, Period period, Window window, int i11, boolean z10) {
        return getNextPeriodIndex(i10, period, window, i11, z10) == -1;
    }

    @Override // androidx.media3.common.Bundleable
    @UnstableApi
    public final Bundle toBundle() {
        ArrayList arrayList = new ArrayList();
        int windowCount = getWindowCount();
        Window window = new Window();
        for (int i10 = 0; i10 < windowCount; i10++) {
            arrayList.add(getWindow(i10, window, 0L).toBundle());
        }
        ArrayList arrayList2 = new ArrayList();
        int periodCount = getPeriodCount();
        Period period = new Period();
        for (int i11 = 0; i11 < periodCount; i11++) {
            arrayList2.add(getPeriod(i11, period, false).toBundle());
        }
        int[] iArr = new int[windowCount];
        if (windowCount > 0) {
            iArr[0] = getFirstWindowIndex(true);
        }
        for (int i12 = 1; i12 < windowCount; i12++) {
            iArr[i12] = getNextWindowIndex(iArr[i12 - 1], 0, true);
        }
        Bundle bundle = new Bundle();
        BundleUtil.putBinder(bundle, FIELD_WINDOWS, new BundleListRetriever(arrayList));
        BundleUtil.putBinder(bundle, FIELD_PERIODS, new BundleListRetriever(arrayList2));
        bundle.putIntArray(FIELD_SHUFFLED_WINDOW_INDICES, iArr);
        return bundle;
    }

    @UnstableApi
    public final Bundle toBundleWithOneWindowOnly(int i10) {
        Window window = getWindow(i10, new Window(), 0L);
        ArrayList arrayList = new ArrayList();
        Period period = new Period();
        int i11 = window.firstPeriodIndex;
        while (true) {
            int i12 = window.lastPeriodIndex;
            if (i11 > i12) {
                window.lastPeriodIndex = i12 - window.firstPeriodIndex;
                window.firstPeriodIndex = 0;
                Bundle bundle = window.toBundle();
                Bundle bundle2 = new Bundle();
                BundleUtil.putBinder(bundle2, FIELD_WINDOWS, new BundleListRetriever(ImmutableList.of(bundle)));
                BundleUtil.putBinder(bundle2, FIELD_PERIODS, new BundleListRetriever(arrayList));
                bundle2.putIntArray(FIELD_SHUFFLED_WINDOW_INDICES, new int[]{0});
                return bundle2;
            }
            getPeriod(i11, period, false);
            period.windowIndex = 0;
            arrayList.add(period.toBundle());
            i11++;
        }
    }

    @Deprecated
    @Nullable
    @InlineMe(replacement = "this.getPeriodPositionUs(window, period, windowIndex, windowPositionUs, defaultPositionProjectionUs)")
    @UnstableApi
    public final Pair<Object, Long> getPeriodPosition(Window window, Period period, int i10, long j10, long j11) {
        return getPeriodPositionUs(window, period, i10, j10, j11);
    }

    @Nullable
    public final Pair<Object, Long> getPeriodPositionUs(Window window, Period period, int i10, long j10, long j11) {
        Assertions.checkIndex(i10, 0, getWindowCount());
        getWindow(i10, window, j11);
        if (j10 == C.TIME_UNSET) {
            j10 = window.getDefaultPositionUs();
            if (j10 == C.TIME_UNSET) {
                return null;
            }
        }
        int i11 = window.firstPeriodIndex;
        getPeriod(i11, period);
        while (i11 < window.lastPeriodIndex && period.positionInWindowUs != j10) {
            int i12 = i11 + 1;
            if (getPeriod(i12, period).positionInWindowUs > j10) {
                break;
            }
            i11 = i12;
        }
        getPeriod(i11, period, true);
        long j12 = j10 - period.positionInWindowUs;
        long j13 = period.durationUs;
        if (j13 != C.TIME_UNSET) {
            j12 = Math.min(j12, j13 - 1);
        }
        return Pair.create(Assertions.checkNotNull(period.uid), Long.valueOf(Math.max(0L, j12)));
    }
}
