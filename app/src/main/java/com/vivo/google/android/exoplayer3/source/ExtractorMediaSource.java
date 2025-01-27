package com.vivo.google.android.exoplayer3.source;

import android.net.Uri;
import android.os.Handler;
import com.vivo.google.android.exoplayer3.C;
import com.vivo.google.android.exoplayer3.ExoPlayer;
import com.vivo.google.android.exoplayer3.Timeline;
import com.vivo.google.android.exoplayer3.extractor.ExtractorsFactory;
import com.vivo.google.android.exoplayer3.g1;
import com.vivo.google.android.exoplayer3.k5;
import com.vivo.google.android.exoplayer3.l3;
import com.vivo.google.android.exoplayer3.m3;
import com.vivo.google.android.exoplayer3.o3;
import com.vivo.google.android.exoplayer3.r3;
import com.vivo.google.android.exoplayer3.source.MediaSource;
import com.vivo.google.android.exoplayer3.upstream.DataSource;
import com.vivo.google.android.exoplayer3.v5;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class ExtractorMediaSource implements MediaSource, MediaSource.Listener {
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_LIVE = 6;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_ON_DEMAND = 3;
    public static final int MIN_RETRY_COUNT_DEFAULT_FOR_MEDIA = -1;
    public final String customCacheKey;
    public final DataSource.Factory dataSourceFactory;
    public final Handler eventHandler;
    public final EventListener eventListener;
    public final ExtractorsFactory extractorsFactory;
    public final int minLoadableRetryCount;
    public final Timeline.Period period;
    public MediaSource.Listener sourceListener;
    public Timeline timeline;
    public boolean timelineHasDuration;
    public final Uri uri;

    public interface EventListener {
        void onLoadError(IOException iOException);
    }

    public ExtractorMediaSource(Uri uri, DataSource.Factory factory, ExtractorsFactory extractorsFactory, int i2, Handler handler, EventListener eventListener, String str) {
        this.uri = uri;
        this.dataSourceFactory = factory;
        this.extractorsFactory = extractorsFactory;
        this.minLoadableRetryCount = i2;
        this.eventHandler = handler;
        this.eventListener = eventListener;
        this.customCacheKey = str;
        this.period = new Timeline.Period();
    }

    public ExtractorMediaSource(Uri uri, DataSource.Factory factory, ExtractorsFactory extractorsFactory, Handler handler, EventListener eventListener) {
        this(uri, factory, extractorsFactory, -1, handler, eventListener, null);
    }

    public ExtractorMediaSource(Uri uri, DataSource.Factory factory, ExtractorsFactory extractorsFactory, Handler handler, EventListener eventListener, String str) {
        this(uri, factory, extractorsFactory, -1, handler, eventListener, str);
    }

    @Override // com.vivo.google.android.exoplayer3.source.MediaSource
    public o3 createPeriod(int i2, k5 k5Var, long j2) {
        g1.a(i2 == 0);
        return new l3(this.uri, this.dataSourceFactory.createDataSource(), this.extractorsFactory.createExtractors(), this.minLoadableRetryCount, this.eventHandler, this.eventListener, this, k5Var, this.customCacheKey);
    }

    @Override // com.vivo.google.android.exoplayer3.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // com.vivo.google.android.exoplayer3.source.MediaSource.Listener
    public void onSourceInfoRefreshed(Timeline timeline, Object obj) {
        boolean z = timeline.getPeriod(0, this.period).getDurationUs() != C.TIME_UNSET;
        if (!this.timelineHasDuration || z) {
            this.timeline = timeline;
            this.timelineHasDuration = z;
            this.sourceListener.onSourceInfoRefreshed(timeline, null);
        }
    }

    @Override // com.vivo.google.android.exoplayer3.source.MediaSource
    public void prepareSource(ExoPlayer exoPlayer, boolean z, MediaSource.Listener listener) {
        this.sourceListener = listener;
        r3 r3Var = new r3(C.TIME_UNSET, false);
        this.timeline = r3Var;
        listener.onSourceInfoRefreshed(r3Var, null);
    }

    @Override // com.vivo.google.android.exoplayer3.source.MediaSource
    public void releasePeriod(o3 o3Var) {
        l3 l3Var = (l3) o3Var;
        l3.d dVar = l3Var.f27652j;
        v5 v5Var = l3Var.f27651i;
        m3 m3Var = new m3(l3Var, dVar);
        v5.b<? extends v5.c> bVar = v5Var.f28155b;
        if (bVar != null) {
            bVar.a(true);
        }
        v5Var.f28154a.execute(m3Var);
        v5Var.f28154a.shutdown();
        l3Var.n.removeCallbacksAndMessages(null);
        l3Var.G = true;
    }

    @Override // com.vivo.google.android.exoplayer3.source.MediaSource
    public void releaseSource() {
        this.sourceListener = null;
    }
}
