package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.MediaBrowserCompat;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Rating;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaController;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

@DoNotMock
/* loaded from: classes.dex */
public class MediaController implements Player {

    @UnstableApi
    public static final long RELEASE_UNBIND_TIMEOUT_MS = 30000;
    private static final String TAG = "MediaController";
    private static final String WRONG_THREAD_ERROR_MESSAGE = "MediaController method is called from a wrong thread. See javadoc of MediaController for details.";
    final Handler applicationHandler;
    final ConnectionCallback connectionCallback;
    private boolean connectionNotified;

    @NotOnlyInitialized
    private final MediaControllerImpl impl;
    final Listener listener;
    private boolean released;
    private long timeDiffMs;
    private final Timeline.Window window;

    public static final class Builder {
        private androidx.media3.common.util.BitmapLoader bitmapLoader;
        private final Context context;
        private final SessionToken token;
        private Bundle connectionHints = Bundle.EMPTY;
        private Listener listener = new Listener(this) { // from class: androidx.media3.session.MediaController.Builder.1
            public AnonymousClass1(Builder this) {
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ void onAvailableSessionCommandsChanged(MediaController mediaController, SessionCommands sessionCommands) {
                p0.p.a(this, mediaController, sessionCommands);
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ p5.c0 onCustomCommand(MediaController mediaController, SessionCommand sessionCommand, Bundle bundle) {
                return p0.p.b(this, mediaController, sessionCommand, bundle);
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ void onDisconnected(MediaController mediaController) {
                p0.p.c(this, mediaController);
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ void onExtrasChanged(MediaController mediaController, Bundle bundle) {
                p0.p.d(this, mediaController, bundle);
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ void onSessionActivityChanged(MediaController mediaController, PendingIntent pendingIntent) {
                p0.p.e(this, mediaController, pendingIntent);
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ p5.c0 onSetCustomLayout(MediaController mediaController, List list) {
                return p0.p.f(this, mediaController, list);
            }
        };
        private Looper applicationLooper = Util.getCurrentOrMainLooper();

        /* renamed from: androidx.media3.session.MediaController$Builder$1 */
        public class AnonymousClass1 implements Listener {
            public AnonymousClass1(Builder this) {
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ void onAvailableSessionCommandsChanged(MediaController mediaController, SessionCommands sessionCommands) {
                p0.p.a(this, mediaController, sessionCommands);
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ p5.c0 onCustomCommand(MediaController mediaController, SessionCommand sessionCommand, Bundle bundle) {
                return p0.p.b(this, mediaController, sessionCommand, bundle);
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ void onDisconnected(MediaController mediaController) {
                p0.p.c(this, mediaController);
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ void onExtrasChanged(MediaController mediaController, Bundle bundle) {
                p0.p.d(this, mediaController, bundle);
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ void onSessionActivityChanged(MediaController mediaController, PendingIntent pendingIntent) {
                p0.p.e(this, mediaController, pendingIntent);
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ p5.c0 onSetCustomLayout(MediaController mediaController, List list) {
                return p0.p.f(this, mediaController, list);
            }
        }

        public Builder(Context context, SessionToken sessionToken) {
            this.context = (Context) Assertions.checkNotNull(context);
            this.token = (SessionToken) Assertions.checkNotNull(sessionToken);
        }

        public p5.c0<MediaController> buildAsync() {
            MediaControllerHolder mediaControllerHolder = new MediaControllerHolder(this.applicationLooper);
            if (this.token.isLegacySession() && this.bitmapLoader == null) {
                this.bitmapLoader = new CacheBitmapLoader(new SimpleBitmapLoader());
            }
            Util.postOrRun(new Handler(this.applicationLooper), new Runnable() { // from class: androidx.media3.session.l

                /* renamed from: c */
                public final /* synthetic */ MediaController f703c;

                public /* synthetic */ l(MediaController mediaController) {
                    mediaController = mediaController;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MediaControllerHolder.this.setController(mediaController);
                }
            });
            return mediaControllerHolder;
        }

        @CanIgnoreReturnValue
        public Builder setApplicationLooper(Looper looper) {
            this.applicationLooper = (Looper) Assertions.checkNotNull(looper);
            return this;
        }

        @CanIgnoreReturnValue
        @UnstableApi
        public Builder setBitmapLoader(androidx.media3.common.util.BitmapLoader bitmapLoader) {
            this.bitmapLoader = (androidx.media3.common.util.BitmapLoader) Assertions.checkNotNull(bitmapLoader);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setConnectionHints(Bundle bundle) {
            this.connectionHints = new Bundle((Bundle) Assertions.checkNotNull(bundle));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setListener(Listener listener) {
            this.listener = (Listener) Assertions.checkNotNull(listener);
            return this;
        }
    }

    public interface ConnectionCallback {
        void onAccepted();

        void onRejected();
    }

    public interface Listener {
        void onAvailableSessionCommandsChanged(MediaController mediaController, SessionCommands sessionCommands);

        p5.c0<SessionResult> onCustomCommand(MediaController mediaController, SessionCommand sessionCommand, Bundle bundle);

        void onDisconnected(MediaController mediaController);

        void onExtrasChanged(MediaController mediaController, Bundle bundle);

        @UnstableApi
        void onSessionActivityChanged(MediaController mediaController, PendingIntent pendingIntent);

        p5.c0<SessionResult> onSetCustomLayout(MediaController mediaController, List<CommandButton> list);
    }

    public interface MediaControllerImpl {
        void addListener(Player.Listener listener);

        void addMediaItem(int i10, MediaItem mediaItem);

        void addMediaItem(MediaItem mediaItem);

        void addMediaItems(int i10, List<MediaItem> list);

        void addMediaItems(List<MediaItem> list);

        void clearMediaItems();

        void clearVideoSurface();

        void clearVideoSurface(@Nullable Surface surface);

        void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder);

        void clearVideoSurfaceView(@Nullable SurfaceView surfaceView);

        void clearVideoTextureView(@Nullable TextureView textureView);

        void connect();

        void decreaseDeviceVolume();

        void decreaseDeviceVolume(int i10);

        AudioAttributes getAudioAttributes();

        Player.Commands getAvailableCommands();

        SessionCommands getAvailableSessionCommands();

        @Nullable
        MediaBrowserCompat getBrowserCompat();

        int getBufferedPercentage();

        long getBufferedPosition();

        @Nullable
        SessionToken getConnectedToken();

        long getContentBufferedPosition();

        long getContentDuration();

        long getContentPosition();

        Context getContext();

        int getCurrentAdGroupIndex();

        int getCurrentAdIndexInAdGroup();

        CueGroup getCurrentCues();

        long getCurrentLiveOffset();

        int getCurrentMediaItemIndex();

        int getCurrentPeriodIndex();

        long getCurrentPosition();

        Timeline getCurrentTimeline();

        Tracks getCurrentTracks();

        DeviceInfo getDeviceInfo();

        int getDeviceVolume();

        long getDuration();

        long getMaxSeekToPreviousPosition();

        MediaMetadata getMediaMetadata();

        int getNextMediaItemIndex();

        boolean getPlayWhenReady();

        PlaybackParameters getPlaybackParameters();

        int getPlaybackState();

        int getPlaybackSuppressionReason();

        @Nullable
        PlaybackException getPlayerError();

        MediaMetadata getPlaylistMetadata();

        int getPreviousMediaItemIndex();

        int getRepeatMode();

        long getSeekBackIncrement();

        long getSeekForwardIncrement();

        @Nullable
        PendingIntent getSessionActivity();

        boolean getShuffleModeEnabled();

        Size getSurfaceSize();

        long getTotalBufferedDuration();

        TrackSelectionParameters getTrackSelectionParameters();

        VideoSize getVideoSize();

        float getVolume();

        boolean hasNextMediaItem();

        boolean hasPreviousMediaItem();

        void increaseDeviceVolume();

        void increaseDeviceVolume(int i10);

        boolean isConnected();

        boolean isDeviceMuted();

        boolean isLoading();

        boolean isPlaying();

        boolean isPlayingAd();

        void moveMediaItem(int i10, int i11);

        void moveMediaItems(int i10, int i11, int i12);

        void pause();

        void play();

        void prepare();

        void release();

        void removeListener(Player.Listener listener);

        void removeMediaItem(int i10);

        void removeMediaItems(int i10, int i11);

        void replaceMediaItem(int i10, MediaItem mediaItem);

        void replaceMediaItems(int i10, int i11, List<MediaItem> list);

        void seekBack();

        void seekForward();

        void seekTo(int i10, long j10);

        void seekTo(long j10);

        void seekToDefaultPosition();

        void seekToDefaultPosition(int i10);

        void seekToNext();

        void seekToNextMediaItem();

        void seekToPrevious();

        void seekToPreviousMediaItem();

        p5.c0<SessionResult> sendCustomCommand(SessionCommand sessionCommand, Bundle bundle);

        void setDeviceMuted(boolean z10);

        void setDeviceMuted(boolean z10, int i10);

        void setDeviceVolume(int i10);

        void setDeviceVolume(int i10, int i11);

        void setMediaItem(MediaItem mediaItem);

        void setMediaItem(MediaItem mediaItem, long j10);

        void setMediaItem(MediaItem mediaItem, boolean z10);

        void setMediaItems(List<MediaItem> list);

        void setMediaItems(List<MediaItem> list, int i10, long j10);

        void setMediaItems(List<MediaItem> list, boolean z10);

        void setPlayWhenReady(boolean z10);

        void setPlaybackParameters(PlaybackParameters playbackParameters);

        void setPlaybackSpeed(float f10);

        void setPlaylistMetadata(MediaMetadata mediaMetadata);

        p5.c0<SessionResult> setRating(Rating rating);

        p5.c0<SessionResult> setRating(String str, Rating rating);

        void setRepeatMode(int i10);

        void setShuffleModeEnabled(boolean z10);

        void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters);

        void setVideoSurface(@Nullable Surface surface);

        void setVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder);

        void setVideoSurfaceView(@Nullable SurfaceView surfaceView);

        void setVideoTextureView(@Nullable TextureView textureView);

        void setVolume(float f10);

        void stop();
    }

    public MediaController(Context context, SessionToken sessionToken, Bundle bundle, Listener listener, Looper looper, ConnectionCallback connectionCallback, @Nullable androidx.media3.common.util.BitmapLoader bitmapLoader) {
        Assertions.checkNotNull(context, "context must not be null");
        Assertions.checkNotNull(sessionToken, "token must not be null");
        this.window = new Timeline.Window();
        this.timeDiffMs = C.TIME_UNSET;
        this.listener = listener;
        this.applicationHandler = new Handler(looper);
        this.connectionCallback = connectionCallback;
        MediaControllerImpl createImpl = createImpl(context, sessionToken, bundle, looper, bitmapLoader);
        this.impl = createImpl;
        createImpl.connect();
    }

    private static p5.c0<SessionResult> createDisconnectedFuture() {
        return com.google.common.util.concurrent.l.m(new SessionResult(-100));
    }

    public /* synthetic */ void lambda$release$0(Listener listener) {
        listener.onDisconnected(this);
    }

    public static void releaseFuture(Future<? extends MediaController> future) {
        if (future.cancel(true)) {
            return;
        }
        try {
            ((MediaController) com.google.common.util.concurrent.l.h(future)).release();
        } catch (CancellationException | ExecutionException e10) {
            Log.w(TAG, "MediaController future failed (so we couldn't release it)", e10);
        }
    }

    private void verifyApplicationThread() {
        Assertions.checkState(Looper.myLooper() == getApplicationLooper(), WRONG_THREAD_ERROR_MESSAGE);
    }

    @Override // androidx.media3.common.Player
    public final void addListener(Player.Listener listener) {
        Assertions.checkNotNull(listener, "listener must not be null");
        this.impl.addListener(listener);
    }

    @Override // androidx.media3.common.Player
    public final void addMediaItem(MediaItem mediaItem) {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.addMediaItem(mediaItem);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring addMediaItem().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void addMediaItems(List<MediaItem> list) {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.addMediaItems(list);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring addMediaItems().");
        }
    }

    @Override // androidx.media3.common.Player
    public final boolean canAdvertiseSession() {
        return false;
    }

    @Override // androidx.media3.common.Player
    public final void clearMediaItems() {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.clearMediaItems();
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring clearMediaItems().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void clearVideoSurface() {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.clearVideoSurface();
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring clearVideoSurface().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.clearVideoSurfaceHolder(surfaceHolder);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring clearVideoSurfaceHolder().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void clearVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.clearVideoSurfaceView(surfaceView);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring clearVideoSurfaceView().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void clearVideoTextureView(@Nullable TextureView textureView) {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.clearVideoTextureView(textureView);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring clearVideoTextureView().");
        }
    }

    public MediaControllerImpl createImpl(Context context, SessionToken sessionToken, Bundle bundle, Looper looper, @Nullable androidx.media3.common.util.BitmapLoader bitmapLoader) {
        return sessionToken.isLegacySession() ? new MediaControllerImplLegacy(context, this, sessionToken, looper, (androidx.media3.common.util.BitmapLoader) Assertions.checkNotNull(bitmapLoader)) : new MediaControllerImplBase(context, this, sessionToken, bundle, looper);
    }

    @Override // androidx.media3.common.Player
    @Deprecated
    public final void decreaseDeviceVolume() {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.decreaseDeviceVolume();
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring decreaseDeviceVolume().");
        }
    }

    @Override // androidx.media3.common.Player
    public final Looper getApplicationLooper() {
        return this.applicationHandler.getLooper();
    }

    @Override // androidx.media3.common.Player
    public final AudioAttributes getAudioAttributes() {
        verifyApplicationThread();
        return !isConnected() ? AudioAttributes.DEFAULT : this.impl.getAudioAttributes();
    }

    @Override // androidx.media3.common.Player
    public final Player.Commands getAvailableCommands() {
        verifyApplicationThread();
        return !isConnected() ? Player.Commands.EMPTY : this.impl.getAvailableCommands();
    }

    public final SessionCommands getAvailableSessionCommands() {
        verifyApplicationThread();
        return !isConnected() ? SessionCommands.EMPTY : this.impl.getAvailableSessionCommands();
    }

    @Override // androidx.media3.common.Player
    @IntRange(from = 0, to = MediaUtils.POSITION_DIFF_TOLERANCE_MS)
    public final int getBufferedPercentage() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getBufferedPercentage();
        }
        return 0;
    }

    @Override // androidx.media3.common.Player
    public final long getBufferedPosition() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getBufferedPosition();
        }
        return 0L;
    }

    @Nullable
    public final SessionToken getConnectedToken() {
        if (isConnected()) {
            return this.impl.getConnectedToken();
        }
        return null;
    }

    @Override // androidx.media3.common.Player
    public final long getContentBufferedPosition() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getContentBufferedPosition();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final long getContentDuration() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getContentDuration() : C.TIME_UNSET;
    }

    @Override // androidx.media3.common.Player
    public final long getContentPosition() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getContentPosition();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentAdGroupIndex() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getCurrentAdGroupIndex();
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentAdIndexInAdGroup() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getCurrentAdIndexInAdGroup();
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    public final CueGroup getCurrentCues() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getCurrentCues() : CueGroup.EMPTY_TIME_ZERO;
    }

    @Override // androidx.media3.common.Player
    public final long getCurrentLiveOffset() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getCurrentLiveOffset() : C.TIME_UNSET;
    }

    @Override // androidx.media3.common.Player
    @Nullable
    @UnstableApi
    public final Object getCurrentManifest() {
        return null;
    }

    @Override // androidx.media3.common.Player
    @Nullable
    public final MediaItem getCurrentMediaItem() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        return currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).mediaItem;
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentMediaItemIndex() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getCurrentMediaItemIndex();
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentPeriodIndex() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getCurrentPeriodIndex();
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    public final long getCurrentPosition() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getCurrentPosition();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final Timeline getCurrentTimeline() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getCurrentTimeline() : Timeline.EMPTY;
    }

    @Override // androidx.media3.common.Player
    public final Tracks getCurrentTracks() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getCurrentTracks() : Tracks.EMPTY;
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final int getCurrentWindowIndex() {
        return getCurrentMediaItemIndex();
    }

    @Override // androidx.media3.common.Player
    public final DeviceInfo getDeviceInfo() {
        verifyApplicationThread();
        return !isConnected() ? DeviceInfo.UNKNOWN : this.impl.getDeviceInfo();
    }

    @Override // androidx.media3.common.Player
    @IntRange(from = 0)
    public final int getDeviceVolume() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getDeviceVolume();
        }
        return 0;
    }

    @Override // androidx.media3.common.Player
    public final long getDuration() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getDuration() : C.TIME_UNSET;
    }

    @Override // androidx.media3.common.Player
    public final long getMaxSeekToPreviousPosition() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getMaxSeekToPreviousPosition();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final MediaItem getMediaItemAt(int i10) {
        return getCurrentTimeline().getWindow(i10, this.window).mediaItem;
    }

    @Override // androidx.media3.common.Player
    public final int getMediaItemCount() {
        return getCurrentTimeline().getWindowCount();
    }

    @Override // androidx.media3.common.Player
    public final MediaMetadata getMediaMetadata() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getMediaMetadata() : MediaMetadata.EMPTY;
    }

    @Override // androidx.media3.common.Player
    public final int getNextMediaItemIndex() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getNextMediaItemIndex();
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final int getNextWindowIndex() {
        return getNextMediaItemIndex();
    }

    @Override // androidx.media3.common.Player
    public final boolean getPlayWhenReady() {
        verifyApplicationThread();
        return isConnected() && this.impl.getPlayWhenReady();
    }

    @Override // androidx.media3.common.Player
    public final PlaybackParameters getPlaybackParameters() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getPlaybackParameters() : PlaybackParameters.DEFAULT;
    }

    @Override // androidx.media3.common.Player
    public final int getPlaybackState() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getPlaybackState();
        }
        return 1;
    }

    @Override // androidx.media3.common.Player
    public final int getPlaybackSuppressionReason() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getPlaybackSuppressionReason();
        }
        return 0;
    }

    @Override // androidx.media3.common.Player
    @Nullable
    public final PlaybackException getPlayerError() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getPlayerError();
        }
        return null;
    }

    @Override // androidx.media3.common.Player
    public final MediaMetadata getPlaylistMetadata() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getPlaylistMetadata() : MediaMetadata.EMPTY;
    }

    @Override // androidx.media3.common.Player
    public final int getPreviousMediaItemIndex() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getPreviousMediaItemIndex();
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final int getPreviousWindowIndex() {
        return getPreviousMediaItemIndex();
    }

    @Override // androidx.media3.common.Player
    public final int getRepeatMode() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getRepeatMode();
        }
        return 0;
    }

    @Override // androidx.media3.common.Player
    public final long getSeekBackIncrement() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getSeekBackIncrement();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final long getSeekForwardIncrement() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getSeekForwardIncrement();
        }
        return 0L;
    }

    @Nullable
    public final PendingIntent getSessionActivity() {
        if (isConnected()) {
            return this.impl.getSessionActivity();
        }
        return null;
    }

    @Override // androidx.media3.common.Player
    public final boolean getShuffleModeEnabled() {
        verifyApplicationThread();
        return isConnected() && this.impl.getShuffleModeEnabled();
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    public final Size getSurfaceSize() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getSurfaceSize() : Size.UNKNOWN;
    }

    public final long getTimeDiffMs() {
        return this.timeDiffMs;
    }

    @Override // androidx.media3.common.Player
    public final long getTotalBufferedDuration() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getTotalBufferedDuration();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final TrackSelectionParameters getTrackSelectionParameters() {
        verifyApplicationThread();
        return !isConnected() ? TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT : this.impl.getTrackSelectionParameters();
    }

    @Override // androidx.media3.common.Player
    public final VideoSize getVideoSize() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getVideoSize() : VideoSize.UNKNOWN;
    }

    @Override // androidx.media3.common.Player
    @FloatRange(from = l5.c.f27899e, to = 1.0d)
    public final float getVolume() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getVolume();
        }
        return 1.0f;
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final boolean hasNext() {
        return hasNextMediaItem();
    }

    @Override // androidx.media3.common.Player
    public final boolean hasNextMediaItem() {
        verifyApplicationThread();
        return isConnected() && this.impl.hasNextMediaItem();
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final boolean hasNextWindow() {
        return hasNextMediaItem();
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final boolean hasPrevious() {
        return hasPreviousMediaItem();
    }

    @Override // androidx.media3.common.Player
    public final boolean hasPreviousMediaItem() {
        verifyApplicationThread();
        return isConnected() && this.impl.hasPreviousMediaItem();
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final boolean hasPreviousWindow() {
        return hasPreviousMediaItem();
    }

    @Override // androidx.media3.common.Player
    @Deprecated
    public final void increaseDeviceVolume() {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.increaseDeviceVolume();
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring increaseDeviceVolume().");
        }
    }

    @Override // androidx.media3.common.Player
    public final boolean isCommandAvailable(int i10) {
        return getAvailableCommands().contains(i10);
    }

    public final boolean isConnected() {
        return this.impl.isConnected();
    }

    @Override // androidx.media3.common.Player
    public final boolean isCurrentMediaItemDynamic() {
        verifyApplicationThread();
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).isDynamic;
    }

    @Override // androidx.media3.common.Player
    public final boolean isCurrentMediaItemLive() {
        verifyApplicationThread();
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).isLive();
    }

    @Override // androidx.media3.common.Player
    public final boolean isCurrentMediaItemSeekable() {
        verifyApplicationThread();
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).isSeekable;
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final boolean isCurrentWindowDynamic() {
        return isCurrentMediaItemDynamic();
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final boolean isCurrentWindowLive() {
        return isCurrentMediaItemLive();
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final boolean isCurrentWindowSeekable() {
        return isCurrentMediaItemSeekable();
    }

    @Override // androidx.media3.common.Player
    public final boolean isDeviceMuted() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.isDeviceMuted();
        }
        return false;
    }

    @Override // androidx.media3.common.Player
    public final boolean isLoading() {
        verifyApplicationThread();
        return isConnected() && this.impl.isLoading();
    }

    @Override // androidx.media3.common.Player
    public final boolean isPlaying() {
        verifyApplicationThread();
        return isConnected() && this.impl.isPlaying();
    }

    @Override // androidx.media3.common.Player
    public final boolean isPlayingAd() {
        verifyApplicationThread();
        return isConnected() && this.impl.isPlayingAd();
    }

    public final boolean isSessionCommandAvailable(int i10) {
        return getAvailableSessionCommands().contains(i10);
    }

    @Override // androidx.media3.common.Player
    public final void moveMediaItem(int i10, int i11) {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.moveMediaItem(i10, i11);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring moveMediaItem().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void moveMediaItems(int i10, int i11, int i12) {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.moveMediaItems(i10, i11, i12);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring moveMediaItems().");
        }
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final void next() {
        seekToNextMediaItem();
    }

    public final void notifyAccepted() {
        Assertions.checkState(Looper.myLooper() == getApplicationLooper());
        Assertions.checkState(!this.connectionNotified);
        this.connectionNotified = true;
        this.connectionCallback.onAccepted();
    }

    public final void notifyControllerListener(Consumer<Listener> consumer) {
        Assertions.checkState(Looper.myLooper() == getApplicationLooper());
        consumer.accept(this.listener);
    }

    @Override // androidx.media3.common.Player
    public final void pause() {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.pause();
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring pause().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void play() {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.play();
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring play().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void prepare() {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.prepare();
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring prepare().");
        }
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final void previous() {
        seekToPreviousMediaItem();
    }

    @Override // androidx.media3.common.Player
    public final void release() {
        verifyApplicationThread();
        if (this.released) {
            return;
        }
        this.released = true;
        this.applicationHandler.removeCallbacksAndMessages(null);
        try {
            this.impl.release();
        } catch (Exception e10) {
            Log.d(TAG, "Exception while releasing impl", e10);
        }
        if (this.connectionNotified) {
            notifyControllerListener(new Consumer() { // from class: p0.o
                public /* synthetic */ o() {
                }

                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaController.this.lambda$release$0((MediaController.Listener) obj);
                }
            });
        } else {
            this.connectionNotified = true;
            this.connectionCallback.onRejected();
        }
    }

    @Override // androidx.media3.common.Player
    public final void removeListener(Player.Listener listener) {
        verifyApplicationThread();
        Assertions.checkNotNull(listener, "listener must not be null");
        this.impl.removeListener(listener);
    }

    @Override // androidx.media3.common.Player
    public final void removeMediaItem(int i10) {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.removeMediaItem(i10);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring removeMediaItem().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void removeMediaItems(int i10, int i11) {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.removeMediaItems(i10, i11);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring removeMediaItems().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void replaceMediaItem(int i10, MediaItem mediaItem) {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.replaceMediaItem(i10, mediaItem);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring replaceMediaItem().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void replaceMediaItems(int i10, int i11, List<MediaItem> list) {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.replaceMediaItems(i10, i11, list);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring replaceMediaItems().");
        }
    }

    public final void runOnApplicationLooper(Runnable runnable) {
        Util.postOrRun(this.applicationHandler, runnable);
    }

    @Override // androidx.media3.common.Player
    public final void seekBack() {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.seekBack();
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring seekBack().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekForward() {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.seekForward();
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring seekForward().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekTo(long j10) {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.seekTo(j10);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring seekTo().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekToDefaultPosition() {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.seekToDefaultPosition();
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring seekTo().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekToNext() {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.seekToNext();
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring seekToNext().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekToNextMediaItem() {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.seekToNextMediaItem();
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring seekToNextMediaItem().");
        }
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final void seekToNextWindow() {
        seekToNextMediaItem();
    }

    @Override // androidx.media3.common.Player
    public final void seekToPrevious() {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.seekToPrevious();
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring seekToPrevious().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekToPreviousMediaItem() {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.seekToPreviousMediaItem();
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring seekToPreviousMediaItem().");
        }
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final void seekToPreviousWindow() {
        seekToPreviousMediaItem();
    }

    public final p5.c0<SessionResult> sendCustomCommand(SessionCommand sessionCommand, Bundle bundle) {
        verifyApplicationThread();
        Assertions.checkNotNull(sessionCommand, "command must not be null");
        Assertions.checkArgument(sessionCommand.commandCode == 0, "command must be a custom command");
        return isConnected() ? this.impl.sendCustomCommand(sessionCommand, bundle) : createDisconnectedFuture();
    }

    @Override // androidx.media3.common.Player
    @Deprecated
    public final void setDeviceMuted(boolean z10) {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.setDeviceMuted(z10);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring setDeviceMuted().");
        }
    }

    @Override // androidx.media3.common.Player
    @Deprecated
    public final void setDeviceVolume(@IntRange(from = 0) int i10) {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.setDeviceVolume(i10);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring setDeviceVolume().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItem(MediaItem mediaItem) {
        verifyApplicationThread();
        Assertions.checkNotNull(mediaItem, "mediaItems must not be null");
        if (isConnected()) {
            this.impl.setMediaItem(mediaItem);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring setMediaItem().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItems(List<MediaItem> list) {
        verifyApplicationThread();
        Assertions.checkNotNull(list, "mediaItems must not be null");
        for (int i10 = 0; i10 < list.size(); i10++) {
            Assertions.checkArgument(list.get(i10) != null, "items must not contain null, index=" + i10);
        }
        if (isConnected()) {
            this.impl.setMediaItems(list);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring setMediaItems().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void setPlayWhenReady(boolean z10) {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.setPlayWhenReady(z10);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setPlaybackParameters(PlaybackParameters playbackParameters) {
        verifyApplicationThread();
        Assertions.checkNotNull(playbackParameters, "playbackParameters must not be null");
        if (isConnected()) {
            this.impl.setPlaybackParameters(playbackParameters);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring setPlaybackParameters().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void setPlaybackSpeed(float f10) {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.setPlaybackSpeed(f10);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring setPlaybackSpeed().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void setPlaylistMetadata(MediaMetadata mediaMetadata) {
        verifyApplicationThread();
        Assertions.checkNotNull(mediaMetadata, "playlistMetadata must not be null");
        if (isConnected()) {
            this.impl.setPlaylistMetadata(mediaMetadata);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring setPlaylistMetadata().");
        }
    }

    public final p5.c0<SessionResult> setRating(String str, Rating rating) {
        verifyApplicationThread();
        Assertions.checkNotNull(str, "mediaId must not be null");
        Assertions.checkNotEmpty(str, "mediaId must not be empty");
        Assertions.checkNotNull(rating, "rating must not be null");
        return isConnected() ? this.impl.setRating(str, rating) : createDisconnectedFuture();
    }

    @Override // androidx.media3.common.Player
    public final void setRepeatMode(int i10) {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.setRepeatMode(i10);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring setRepeatMode().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void setShuffleModeEnabled(boolean z10) {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.setShuffleModeEnabled(z10);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring setShuffleMode().");
        }
    }

    @VisibleForTesting(otherwise = 5)
    public final void setTimeDiffMs(long j10) {
        verifyApplicationThread();
        this.timeDiffMs = j10;
    }

    @Override // androidx.media3.common.Player
    public final void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w(TAG, "The controller is not connected. Ignoring setTrackSelectionParameters().");
        }
        this.impl.setTrackSelectionParameters(trackSelectionParameters);
    }

    @Override // androidx.media3.common.Player
    public final void setVideoSurface(@Nullable Surface surface) {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.setVideoSurface(surface);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring setVideoSurface().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void setVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.setVideoSurfaceHolder(surfaceHolder);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring setVideoSurfaceHolder().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void setVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.setVideoSurfaceView(surfaceView);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring setVideoSurfaceView().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void setVideoTextureView(@Nullable TextureView textureView) {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.setVideoTextureView(textureView);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring setVideoTextureView().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void setVolume(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        verifyApplicationThread();
        Assertions.checkArgument(f10 >= 0.0f && f10 <= 1.0f, "volume must be between 0 and 1");
        if (isConnected()) {
            this.impl.setVolume(f10);
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring setVolume().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void stop() {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.stop();
        } else {
            Log.w(TAG, "The controller is not connected. Ignoring stop().");
        }
    }

    public final boolean isSessionCommandAvailable(SessionCommand sessionCommand) {
        return getAvailableSessionCommands().contains(sessionCommand);
    }

    @Override // androidx.media3.common.Player
    public final void addMediaItem(int i10, MediaItem mediaItem) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w(TAG, "The controller is not connected. Ignoring addMediaItem().");
        } else {
            this.impl.addMediaItem(i10, mediaItem);
        }
    }

    @Override // androidx.media3.common.Player
    public final void addMediaItems(int i10, List<MediaItem> list) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w(TAG, "The controller is not connected. Ignoring addMediaItems().");
        } else {
            this.impl.addMediaItems(i10, list);
        }
    }

    @Override // androidx.media3.common.Player
    public final void clearVideoSurface(@Nullable Surface surface) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w(TAG, "The controller is not connected. Ignoring clearVideoSurface().");
        } else {
            this.impl.clearVideoSurface(surface);
        }
    }

    @Override // androidx.media3.common.Player
    public final void decreaseDeviceVolume(int i10) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w(TAG, "The controller is not connected. Ignoring decreaseDeviceVolume().");
        } else {
            this.impl.decreaseDeviceVolume(i10);
        }
    }

    @Override // androidx.media3.common.Player
    public final void increaseDeviceVolume(int i10) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w(TAG, "The controller is not connected. Ignoring increaseDeviceVolume().");
        } else {
            this.impl.increaseDeviceVolume(i10);
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekTo(int i10, long j10) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w(TAG, "The controller is not connected. Ignoring seekTo().");
        } else {
            this.impl.seekTo(i10, j10);
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekToDefaultPosition(int i10) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w(TAG, "The controller is not connected. Ignoring seekTo().");
        } else {
            this.impl.seekToDefaultPosition(i10);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setDeviceMuted(boolean z10, int i10) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w(TAG, "The controller is not connected. Ignoring setDeviceMuted().");
        } else {
            this.impl.setDeviceMuted(z10, i10);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setDeviceVolume(@IntRange(from = 0) int i10, int i11) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w(TAG, "The controller is not connected. Ignoring setDeviceVolume().");
        } else {
            this.impl.setDeviceVolume(i10, i11);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItem(MediaItem mediaItem, long j10) {
        verifyApplicationThread();
        Assertions.checkNotNull(mediaItem, "mediaItems must not be null");
        if (!isConnected()) {
            Log.w(TAG, "The controller is not connected. Ignoring setMediaItem().");
        } else {
            this.impl.setMediaItem(mediaItem, j10);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItems(List<MediaItem> list, boolean z10) {
        verifyApplicationThread();
        Assertions.checkNotNull(list, "mediaItems must not be null");
        for (int i10 = 0; i10 < list.size(); i10++) {
            Assertions.checkArgument(list.get(i10) != null, "items must not contain null, index=" + i10);
        }
        if (!isConnected()) {
            Log.w(TAG, "The controller is not connected. Ignoring setMediaItems().");
        } else {
            this.impl.setMediaItems(list, z10);
        }
    }

    public final p5.c0<SessionResult> setRating(Rating rating) {
        verifyApplicationThread();
        Assertions.checkNotNull(rating, "rating must not be null");
        if (isConnected()) {
            return this.impl.setRating(rating);
        }
        return createDisconnectedFuture();
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItem(MediaItem mediaItem, boolean z10) {
        verifyApplicationThread();
        Assertions.checkNotNull(mediaItem, "mediaItems must not be null");
        if (!isConnected()) {
            Log.w(TAG, "The controller is not connected. Ignoring setMediaItems().");
        } else {
            this.impl.setMediaItem(mediaItem, z10);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItems(List<MediaItem> list, int i10, long j10) {
        verifyApplicationThread();
        Assertions.checkNotNull(list, "mediaItems must not be null");
        for (int i11 = 0; i11 < list.size(); i11++) {
            Assertions.checkArgument(list.get(i11) != null, "items must not contain null, index=" + i11);
        }
        if (!isConnected()) {
            Log.w(TAG, "The controller is not connected. Ignoring setMediaItems().");
        } else {
            this.impl.setMediaItems(list, i10, j10);
        }
    }
}
