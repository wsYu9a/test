package androidx.media3.session;

import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import b5.r;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
final class QueueTimeline extends Timeline {
    public static final QueueTimeline DEFAULT = new QueueTimeline(ImmutableList.of(), null);
    private static final Object FAKE_WINDOW_UID = new Object();

    @Nullable
    private final QueuedMediaItem fakeQueuedMediaItem;
    private final ImmutableList<QueuedMediaItem> queuedMediaItems;

    public static final class QueuedMediaItem {
        public final long durationMs;
        public final MediaItem mediaItem;
        public final long queueId;

        public QueuedMediaItem(MediaItem mediaItem, long j10, long j11) {
            this.mediaItem = mediaItem;
            this.queueId = j10;
            this.durationMs = j11;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof QueuedMediaItem)) {
                return false;
            }
            QueuedMediaItem queuedMediaItem = (QueuedMediaItem) obj;
            return this.queueId == queuedMediaItem.queueId && this.mediaItem.equals(queuedMediaItem.mediaItem) && this.durationMs == queuedMediaItem.durationMs;
        }

        public int hashCode() {
            long j10 = this.queueId;
            int hashCode = (((217 + ((int) (j10 ^ (j10 >>> 32)))) * 31) + this.mediaItem.hashCode()) * 31;
            long j11 = this.durationMs;
            return hashCode + ((int) ((j11 >>> 32) ^ j11));
        }
    }

    private QueueTimeline(ImmutableList<QueuedMediaItem> immutableList, @Nullable QueuedMediaItem queuedMediaItem) {
        this.queuedMediaItems = immutableList;
        this.fakeQueuedMediaItem = queuedMediaItem;
    }

    public static QueueTimeline create(List<MediaSessionCompat.QueueItem> list) {
        ImmutableList.a aVar = new ImmutableList.a();
        for (int i10 = 0; i10 < list.size(); i10++) {
            MediaSessionCompat.QueueItem queueItem = list.get(i10);
            aVar.a(new QueuedMediaItem(MediaUtils.convertToMediaItem(queueItem), queueItem.getQueueId(), C.TIME_UNSET));
        }
        return new QueueTimeline(aVar.e(), null);
    }

    private QueuedMediaItem getQueuedMediaItem(int i10) {
        QueuedMediaItem queuedMediaItem;
        return (i10 != this.queuedMediaItems.size() || (queuedMediaItem = this.fakeQueuedMediaItem) == null) ? this.queuedMediaItems.get(i10) : queuedMediaItem;
    }

    public boolean contains(MediaItem mediaItem) {
        QueuedMediaItem queuedMediaItem = this.fakeQueuedMediaItem;
        if (queuedMediaItem != null && mediaItem.equals(queuedMediaItem.mediaItem)) {
            return true;
        }
        for (int i10 = 0; i10 < this.queuedMediaItems.size(); i10++) {
            if (mediaItem.equals(this.queuedMediaItems.get(i10).mediaItem)) {
                return true;
            }
        }
        return false;
    }

    public QueueTimeline copy() {
        return new QueueTimeline(this.queuedMediaItems, this.fakeQueuedMediaItem);
    }

    public QueueTimeline copyWithClearedFakeMediaItem() {
        return new QueueTimeline(this.queuedMediaItems, null);
    }

    public QueueTimeline copyWithFakeMediaItem(MediaItem mediaItem, long j10) {
        return new QueueTimeline(this.queuedMediaItems, new QueuedMediaItem(mediaItem, -1L, j10));
    }

    public QueueTimeline copyWithMovedMediaItems(int i10, int i11, int i12) {
        ArrayList arrayList = new ArrayList(this.queuedMediaItems);
        Util.moveItems(arrayList, i10, i11, i12);
        return new QueueTimeline(ImmutableList.copyOf((Collection) arrayList), this.fakeQueuedMediaItem);
    }

    public QueueTimeline copyWithNewMediaItem(int i10, MediaItem mediaItem, long j10) {
        Assertions.checkArgument(i10 < this.queuedMediaItems.size() || (i10 == this.queuedMediaItems.size() && this.fakeQueuedMediaItem != null));
        if (i10 == this.queuedMediaItems.size()) {
            return new QueueTimeline(this.queuedMediaItems, new QueuedMediaItem(mediaItem, -1L, j10));
        }
        long j11 = this.queuedMediaItems.get(i10).queueId;
        ImmutableList.a aVar = new ImmutableList.a();
        aVar.c(this.queuedMediaItems.subList(0, i10));
        aVar.a(new QueuedMediaItem(mediaItem, j11, j10));
        ImmutableList<QueuedMediaItem> immutableList = this.queuedMediaItems;
        aVar.c(immutableList.subList(i10 + 1, immutableList.size()));
        return new QueueTimeline(aVar.e(), this.fakeQueuedMediaItem);
    }

    public QueueTimeline copyWithNewMediaItems(int i10, List<MediaItem> list) {
        ImmutableList.a aVar = new ImmutableList.a();
        aVar.c(this.queuedMediaItems.subList(0, i10));
        for (int i11 = 0; i11 < list.size(); i11++) {
            aVar.a(new QueuedMediaItem(list.get(i11), -1L, C.TIME_UNSET));
        }
        ImmutableList<QueuedMediaItem> immutableList = this.queuedMediaItems;
        aVar.c(immutableList.subList(i10, immutableList.size()));
        return new QueueTimeline(aVar.e(), this.fakeQueuedMediaItem);
    }

    public QueueTimeline copyWithRemovedMediaItems(int i10, int i11) {
        ImmutableList.a aVar = new ImmutableList.a();
        aVar.c(this.queuedMediaItems.subList(0, i10));
        ImmutableList<QueuedMediaItem> immutableList = this.queuedMediaItems;
        aVar.c(immutableList.subList(i11, immutableList.size()));
        return new QueueTimeline(aVar.e(), this.fakeQueuedMediaItem);
    }

    @Override // androidx.media3.common.Timeline
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueueTimeline)) {
            return false;
        }
        QueueTimeline queueTimeline = (QueueTimeline) obj;
        return r.a(this.queuedMediaItems, queueTimeline.queuedMediaItems) && r.a(this.fakeQueuedMediaItem, queueTimeline.fakeQueuedMediaItem);
    }

    @Override // androidx.media3.common.Timeline
    public int getIndexOfPeriod(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    public MediaItem getMediaItemAt(int i10) {
        if (i10 >= getWindowCount()) {
            return null;
        }
        return getQueuedMediaItem(i10).mediaItem;
    }

    @Override // androidx.media3.common.Timeline
    public Timeline.Period getPeriod(int i10, Timeline.Period period, boolean z10) {
        QueuedMediaItem queuedMediaItem = getQueuedMediaItem(i10);
        period.set(Long.valueOf(queuedMediaItem.queueId), null, i10, Util.msToUs(queuedMediaItem.durationMs), 0L);
        return period;
    }

    @Override // androidx.media3.common.Timeline
    public int getPeriodCount() {
        return getWindowCount();
    }

    public long getQueueId(int i10) {
        if (i10 < 0 || i10 >= this.queuedMediaItems.size()) {
            return -1L;
        }
        return this.queuedMediaItems.get(i10).queueId;
    }

    @Override // androidx.media3.common.Timeline
    public Object getUidOfPeriod(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.common.Timeline
    public Timeline.Window getWindow(int i10, Timeline.Window window, long j10) {
        QueuedMediaItem queuedMediaItem = getQueuedMediaItem(i10);
        window.set(FAKE_WINDOW_UID, queuedMediaItem.mediaItem, null, C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, true, false, null, 0L, Util.msToUs(queuedMediaItem.durationMs), i10, i10, 0L);
        return window;
    }

    @Override // androidx.media3.common.Timeline
    public int getWindowCount() {
        return this.queuedMediaItems.size() + (this.fakeQueuedMediaItem == null ? 0 : 1);
    }

    @Override // androidx.media3.common.Timeline
    public int hashCode() {
        return r.b(this.queuedMediaItems, this.fakeQueuedMediaItem);
    }
}
