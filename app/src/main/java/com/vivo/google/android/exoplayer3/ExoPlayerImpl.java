package com.vivo.google.android.exoplayer3;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.vivo.google.android.exoplayer3.ExoPlayer;
import com.vivo.google.android.exoplayer3.Timeline;
import com.vivo.google.android.exoplayer3.b;
import com.vivo.google.android.exoplayer3.source.MediaSource;
import com.vivo.google.android.exoplayer3.source.TrackGroupArray;
import com.vivo.google.android.exoplayer3.trackselection.TrackSelection;
import com.vivo.google.android.exoplayer3.trackselection.TrackSelectionArray;
import com.vivo.google.android.exoplayer3.trackselection.TrackSelector;
import com.vivo.google.android.exoplayer3.util.Util;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes4.dex */
public final class ExoPlayerImpl implements ExoPlayer {
    public static final String TAG = "ExoPlayerImpl";
    public final TrackSelectionArray emptyTrackSelections;
    public final Handler eventHandler;
    public final b internalPlayer;
    public boolean isLoading;
    public final CopyOnWriteArraySet<ExoPlayer.EventListener> listeners;
    public Object manifest;
    public int maskingPeriodIndex;
    public int maskingWindowIndex;
    public long maskingWindowPositionMs;
    public int pendingPrepareAcks;
    public int pendingSeekAcks;
    public final Timeline.Period period;
    public boolean playWhenReady;
    public b.C0566b playbackInfo;
    public PlaybackParameters playbackParameters;
    public int playbackState;
    public final Renderer[] renderers;
    public Timeline timeline;
    public TrackGroupArray trackGroups;
    public TrackSelectionArray trackSelections;
    public final TrackSelector trackSelector;
    public boolean tracksSelected;
    public final Timeline.Window window;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ExoPlayerImpl.this.handleEvent(message);
        }
    }

    @SuppressLint({"HandlerLeak"})
    public ExoPlayerImpl(Renderer[] rendererArr, TrackSelector trackSelector, e eVar) {
        String str = "Init ExoPlayerLib/2.4.4 [" + Util.DEVICE_DEBUG_INFO + "]";
        g1.b(rendererArr.length > 0);
        this.renderers = (Renderer[]) g1.a(rendererArr);
        this.trackSelector = (TrackSelector) g1.a(trackSelector);
        this.playWhenReady = false;
        this.playbackState = 1;
        this.listeners = new CopyOnWriteArraySet<>();
        TrackSelectionArray trackSelectionArray = new TrackSelectionArray(new TrackSelection[rendererArr.length]);
        this.emptyTrackSelections = trackSelectionArray;
        this.timeline = Timeline.EMPTY;
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        this.trackGroups = TrackGroupArray.EMPTY;
        this.trackSelections = trackSelectionArray;
        this.playbackParameters = PlaybackParameters.DEFAULT;
        a aVar = new a(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.eventHandler = aVar;
        b.C0566b c0566b = new b.C0566b(0, 0L);
        this.playbackInfo = c0566b;
        this.internalPlayer = new b(rendererArr, trackSelector, eVar, this.playWhenReady, aVar, c0566b, this);
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public void addListener(ExoPlayer.EventListener eventListener) {
        this.listeners.add(eventListener);
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public void blockingSendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        this.internalPlayer.a(exoPlayerMessageArr);
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public int getBufferedPercentage() {
        if (this.timeline.isEmpty()) {
            return 0;
        }
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == C.TIME_UNSET || duration == C.TIME_UNSET) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return Util.constrainValue((int) ((bufferedPosition * 100) / duration), 0, 100);
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public long getBufferedPosition() {
        if (this.timeline.isEmpty() || this.pendingSeekAcks > 0) {
            return this.maskingWindowPositionMs;
        }
        this.timeline.getPeriod(this.playbackInfo.f27191a, this.period);
        return this.period.getPositionInWindowMs() + C.usToMs(this.playbackInfo.f27194d);
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public Object getCurrentManifest() {
        return this.manifest;
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public int getCurrentPeriodIndex() {
        return (this.timeline.isEmpty() || this.pendingSeekAcks > 0) ? this.maskingPeriodIndex : this.playbackInfo.f27191a;
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public long getCurrentPosition() {
        if (this.timeline.isEmpty() || this.pendingSeekAcks > 0) {
            return this.maskingWindowPositionMs;
        }
        this.timeline.getPeriod(this.playbackInfo.f27191a, this.period);
        return this.period.getPositionInWindowMs() + C.usToMs(this.playbackInfo.f27193c);
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public Timeline getCurrentTimeline() {
        return this.timeline;
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public TrackGroupArray getCurrentTrackGroups() {
        return this.trackGroups;
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public TrackSelectionArray getCurrentTrackSelections() {
        return this.trackSelections;
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public int getCurrentWindowIndex() {
        return (this.timeline.isEmpty() || this.pendingSeekAcks > 0) ? this.maskingWindowIndex : this.timeline.getPeriod(this.playbackInfo.f27191a, this.period).windowIndex;
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public long getDuration() {
        return this.timeline.isEmpty() ? C.TIME_UNSET : this.timeline.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public boolean getPlayWhenReady() {
        return this.playWhenReady;
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public PlaybackParameters getPlaybackParameters() {
        return this.playbackParameters;
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public int getPlaybackState() {
        return this.playbackState;
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public int getRendererCount() {
        return this.renderers.length;
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public int getRendererType(int i2) {
        return this.renderers[i2].getTrackType();
    }

    public void handleEvent(Message message) {
        switch (message.what) {
            case 0:
                this.pendingPrepareAcks--;
                return;
            case 1:
                this.playbackState = message.arg1;
                Iterator<ExoPlayer.EventListener> it = this.listeners.iterator();
                while (it.hasNext()) {
                    it.next().onPlayerStateChanged(this.playWhenReady, this.playbackState);
                }
                return;
            case 2:
                this.isLoading = message.arg1 != 0;
                Iterator<ExoPlayer.EventListener> it2 = this.listeners.iterator();
                while (it2.hasNext()) {
                    it2.next().onLoadingChanged(this.isLoading);
                }
                return;
            case 3:
                if (this.pendingPrepareAcks == 0) {
                    i5 i5Var = (i5) message.obj;
                    this.tracksSelected = true;
                    this.trackGroups = i5Var.f27509a;
                    this.trackSelections = i5Var.f27510b;
                    this.trackSelector.onSelectionActivated(i5Var.f27511c);
                    Iterator<ExoPlayer.EventListener> it3 = this.listeners.iterator();
                    while (it3.hasNext()) {
                        it3.next().onTracksChanged(this.trackGroups, this.trackSelections);
                    }
                    return;
                }
                return;
            case 4:
                int i2 = this.pendingSeekAcks - 1;
                this.pendingSeekAcks = i2;
                if (i2 == 0) {
                    this.playbackInfo = (b.C0566b) message.obj;
                    if (message.arg1 != 0) {
                        Iterator<ExoPlayer.EventListener> it4 = this.listeners.iterator();
                        while (it4.hasNext()) {
                            it4.next().onPositionDiscontinuity();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.pendingSeekAcks == 0) {
                    this.playbackInfo = (b.C0566b) message.obj;
                    Iterator<ExoPlayer.EventListener> it5 = this.listeners.iterator();
                    while (it5.hasNext()) {
                        it5.next().onPositionDiscontinuity();
                    }
                    return;
                }
                return;
            case 6:
                b.d dVar = (b.d) message.obj;
                this.pendingSeekAcks -= dVar.f27201d;
                if (this.pendingPrepareAcks == 0) {
                    this.timeline = dVar.f27198a;
                    this.manifest = dVar.f27199b;
                    this.playbackInfo = dVar.f27200c;
                    Iterator<ExoPlayer.EventListener> it6 = this.listeners.iterator();
                    while (it6.hasNext()) {
                        it6.next().onTimelineChanged(this.timeline, this.manifest);
                    }
                    return;
                }
                return;
            case 7:
                PlaybackParameters playbackParameters = (PlaybackParameters) message.obj;
                if (this.playbackParameters.equals(playbackParameters)) {
                    return;
                }
                this.playbackParameters = playbackParameters;
                Iterator<ExoPlayer.EventListener> it7 = this.listeners.iterator();
                while (it7.hasNext()) {
                    it7.next().onPlaybackParametersChanged(playbackParameters);
                }
                return;
            case 8:
                ExoPlaybackException exoPlaybackException = (ExoPlaybackException) message.obj;
                Iterator<ExoPlayer.EventListener> it8 = this.listeners.iterator();
                while (it8.hasNext()) {
                    it8.next().onPlayerError(exoPlaybackException);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public boolean isCurrentWindowDynamic() {
        return !this.timeline.isEmpty() && this.timeline.getWindow(getCurrentWindowIndex(), this.window).isDynamic;
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public boolean isCurrentWindowSeekable() {
        return !this.timeline.isEmpty() && this.timeline.getWindow(getCurrentWindowIndex(), this.window).isSeekable;
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public boolean isLoading() {
        return this.isLoading;
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public void prepare(MediaSource mediaSource) {
        prepare(mediaSource, true, true);
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public void prepare(MediaSource mediaSource, boolean z, boolean z2) {
        if (z2) {
            if (!this.timeline.isEmpty() || this.manifest != null) {
                this.timeline = Timeline.EMPTY;
                this.manifest = null;
                Iterator<ExoPlayer.EventListener> it = this.listeners.iterator();
                while (it.hasNext()) {
                    it.next().onTimelineChanged(this.timeline, this.manifest);
                }
            }
            if (this.tracksSelected) {
                this.tracksSelected = false;
                this.trackGroups = TrackGroupArray.EMPTY;
                this.trackSelections = this.emptyTrackSelections;
                this.trackSelector.onSelectionActivated(null);
                Iterator<ExoPlayer.EventListener> it2 = this.listeners.iterator();
                while (it2.hasNext()) {
                    it2.next().onTracksChanged(this.trackGroups, this.trackSelections);
                }
            }
        }
        this.pendingPrepareAcks++;
        this.internalPlayer.f27176f.obtainMessage(0, z ? 1 : 0, 0, mediaSource).sendToTarget();
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public void release() {
        this.internalPlayer.d();
        this.eventHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public void removeListener(ExoPlayer.EventListener eventListener) {
        this.listeners.remove(eventListener);
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public void seekTo(int i2, long j2) {
        if (i2 < 0 || (!this.timeline.isEmpty() && i2 >= this.timeline.getWindowCount())) {
            throw new d(this.timeline, i2, j2);
        }
        this.pendingSeekAcks++;
        this.maskingWindowIndex = i2;
        if (this.timeline.isEmpty()) {
            this.maskingPeriodIndex = 0;
        } else {
            this.timeline.getWindow(i2, this.window);
            long defaultPositionUs = j2 == C.TIME_UNSET ? this.window.getDefaultPositionUs() : j2;
            Timeline.Window window = this.window;
            int i3 = window.firstPeriodIndex;
            long positionInFirstPeriodUs = window.getPositionInFirstPeriodUs() + C.msToUs(defaultPositionUs);
            Timeline timeline = this.timeline;
            while (true) {
                long durationUs = timeline.getPeriod(i3, this.period).getDurationUs();
                if (durationUs == C.TIME_UNSET || positionInFirstPeriodUs < durationUs || i3 >= this.window.lastPeriodIndex) {
                    break;
                }
                positionInFirstPeriodUs -= durationUs;
                timeline = this.timeline;
                i3++;
            }
            this.maskingPeriodIndex = i3;
        }
        if (j2 == C.TIME_UNSET) {
            this.maskingWindowPositionMs = 0L;
            this.internalPlayer.f27176f.obtainMessage(3, new b.c(this.timeline, i2, C.TIME_UNSET)).sendToTarget();
            return;
        }
        this.maskingWindowPositionMs = j2;
        this.internalPlayer.f27176f.obtainMessage(3, new b.c(this.timeline, i2, C.msToUs(j2))).sendToTarget();
        Iterator<ExoPlayer.EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPositionDiscontinuity();
        }
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public void seekTo(long j2) {
        seekTo(getCurrentWindowIndex(), j2);
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public void seekToDefaultPosition() {
        seekToDefaultPosition(getCurrentWindowIndex());
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public void seekToDefaultPosition(int i2) {
        seekTo(i2, C.TIME_UNSET);
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public void sendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        b bVar = this.internalPlayer;
        if (bVar.r || bVar.s) {
            return;
        }
        bVar.x++;
        bVar.f27176f.obtainMessage(11, exoPlayerMessageArr).sendToTarget();
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public void setPlayWhenReady(boolean z) {
        if (this.playWhenReady != z) {
            this.playWhenReady = z;
            this.internalPlayer.f27176f.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
            Iterator<ExoPlayer.EventListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onPlayerStateChanged(z, this.playbackState);
            }
        }
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public void setPlaybackParameters(@Nullable PlaybackParameters playbackParameters) {
        if (playbackParameters == null) {
            playbackParameters = PlaybackParameters.DEFAULT;
        }
        this.internalPlayer.f27176f.obtainMessage(4, playbackParameters).sendToTarget();
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer
    public void stop() {
        this.internalPlayer.f27176f.sendEmptyMessage(5);
    }
}
