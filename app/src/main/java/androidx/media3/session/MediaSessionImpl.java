package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.CheckResult;
import androidx.annotation.FloatRange;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.core.os.ExecutorCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
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
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionImpl;
import androidx.media3.session.PlayerInfo;
import androidx.media3.session.SequencedFutureManager;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
class MediaSessionImpl {
    private static final long DEFAULT_SESSION_POSITION_UPDATE_DELAY_MS = 3000;
    private static final SessionResult RESULT_WHEN_CLOSED = new SessionResult(1);
    public static final String TAG = "MSImplBase";
    private static final String WRONG_THREAD_ERROR_MESSAGE = "Player callback method is called from a wrong thread. See javadoc of MediaSession for details.";
    private final Handler applicationHandler;
    private final androidx.media3.common.util.BitmapLoader bitmapLoader;

    @Nullable
    @GuardedBy("lock")
    private MediaSessionServiceLegacyStub browserServiceLegacyStub;
    private final MediaSession.Callback callback;

    @GuardedBy("lock")
    private boolean closed;
    private final Context context;

    @Nullable
    private MediaSession.ControllerInfo controllerForCurrentRequest;
    private final MediaSession instance;
    protected final Object lock = new Object();
    private final Handler mainHandler;

    @Nullable
    private MediaSession.Listener mediaSessionListener;
    private final PlayerInfoChangedHandler onPlayerInfoChangedHandler;
    private final Runnable periodicSessionPositionInfoUpdateRunnable;
    private PlayerInfo playerInfo;

    @Nullable
    private PlayerListener playerListener;
    private PlayerWrapper playerWrapper;
    private PendingIntent sessionActivity;
    private final String sessionId;
    private final MediaSessionLegacyStub sessionLegacyStub;
    private long sessionPositionUpdateDelayMs;
    private final MediaSessionStub sessionStub;
    private final SessionToken sessionToken;
    private final Uri sessionUri;

    /* renamed from: androidx.media3.session.MediaSessionImpl$1 */
    public class AnonymousClass1 implements p5.x<MediaSession.MediaItemsWithStartPosition> {
        final /* synthetic */ Player val$player;

        public AnonymousClass1(MediaSessionImpl mediaSessionImpl, Player player) {
            player = player;
        }

        @Override // p5.x
        public void onFailure(Throwable th2) {
            if (th2 instanceof UnsupportedOperationException) {
                Log.w(MediaSessionImpl.TAG, "UnsupportedOperationException: Make sure to implement MediaSession.Callback.onPlaybackResumption() if you add a media button receiver to your manifest or if you implement the recent media item contract with your MediaLibraryService.", th2);
            } else {
                Log.e(MediaSessionImpl.TAG, "Failure calling MediaSession.Callback.onPlaybackResumption(): " + th2.getMessage(), th2);
            }
            Util.handlePlayButtonAction(player);
        }

        @Override // p5.x
        public void onSuccess(MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition) {
            ImmutableList<MediaItem> immutableList = mediaItemsWithStartPosition.mediaItems;
            player.setMediaItems(immutableList, mediaItemsWithStartPosition.startIndex != -1 ? Math.min(immutableList.size() - 1, mediaItemsWithStartPosition.startIndex) : 0, mediaItemsWithStartPosition.startPositionMs);
            if (player.getPlaybackState() == 1) {
                player.prepare();
            }
            player.play();
        }
    }

    public class PlayerInfoChangedHandler extends Handler {
        private static final int MSG_PLAYER_INFO_CHANGED = 1;
        private boolean excludeTimeline;
        private boolean excludeTracks;

        public PlayerInfoChangedHandler(Looper looper) {
            super(looper);
            this.excludeTimeline = true;
            this.excludeTracks = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                throw new IllegalStateException("Invalid message what=" + message.what);
            }
            MediaSessionImpl mediaSessionImpl = MediaSessionImpl.this;
            mediaSessionImpl.playerInfo = mediaSessionImpl.playerInfo.copyWithTimelineAndSessionPositionInfo(MediaSessionImpl.this.getPlayerWrapper().getCurrentTimelineWithCommandCheck(), MediaSessionImpl.this.getPlayerWrapper().createSessionPositionInfoForBundling());
            MediaSessionImpl mediaSessionImpl2 = MediaSessionImpl.this;
            mediaSessionImpl2.dispatchOnPlayerInfoChanged(mediaSessionImpl2.playerInfo, this.excludeTimeline, this.excludeTracks);
            this.excludeTimeline = true;
            this.excludeTracks = true;
        }

        public boolean hasPendingPlayerInfoChangedUpdate() {
            return hasMessages(1);
        }

        public void sendPlayerInfoChangedMessage(boolean z10, boolean z11) {
            boolean z12 = false;
            this.excludeTimeline = this.excludeTimeline && z10;
            if (this.excludeTracks && z11) {
                z12 = true;
            }
            this.excludeTracks = z12;
            if (hasMessages(1)) {
                return;
            }
            sendEmptyMessage(1);
        }
    }

    public static class PlayerListener implements Player.Listener {
        private final WeakReference<PlayerWrapper> player;
        private final WeakReference<MediaSessionImpl> session;

        public PlayerListener(MediaSessionImpl mediaSessionImpl, PlayerWrapper playerWrapper) {
            this.session = new WeakReference<>(mediaSessionImpl);
            this.player = new WeakReference<>(playerWrapper);
        }

        @Nullable
        private MediaSessionImpl getSession() {
            return this.session.get();
        }

        public static /* synthetic */ void lambda$onPlaybackStateChanged$4(int i10, PlayerWrapper playerWrapper, MediaSession.ControllerCb controllerCb, int i11) throws RemoteException {
            controllerCb.onPlaybackStateChanged(i11, i10, playerWrapper.getPlayerError());
        }

        @Override // androidx.media3.common.Player.Listener
        public void onAudioAttributesChanged(AudioAttributes audioAttributes) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithAudioAttributes(audioAttributes);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.q8
                public /* synthetic */ q8() {
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                    controllerCb.onAudioAttributesChanged(i10, AudioAttributes.this);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onAudioSessionIdChanged(int i10) {
            m0.c0.b(this, i10);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onAvailableCommandsChanged(Player.Commands commands) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.handleAvailablePlayerCommandsChanged(commands);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onCues(List list) {
            m0.c0.e(this, list);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onDeviceInfoChanged(DeviceInfo deviceInfo) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithDeviceInfo(deviceInfo);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.m8
                public /* synthetic */ m8() {
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                    controllerCb.onDeviceInfoChanged(i10, DeviceInfo.this);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onDeviceVolumeChanged(int i10, boolean z10) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithDeviceVolume(i10, z10);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.z8

                /* renamed from: a */
                public final /* synthetic */ int f1076a;

                /* renamed from: b */
                public final /* synthetic */ boolean f1077b;

                public /* synthetic */ z8(int i102, boolean z102) {
                    i10 = i102;
                    z10 = z102;
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i11) {
                    controllerCb.onDeviceVolumeChanged(i11, i10, z10);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onEvents(Player player, Player.Events events) {
            m0.c0.h(this, player, events);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onIsLoadingChanged(boolean z10) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithIsLoading(z10);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.k8

                /* renamed from: a */
                public final /* synthetic */ boolean f694a;

                public /* synthetic */ k8(boolean z102) {
                    z10 = z102;
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                    controllerCb.onIsLoadingChanged(i10, z10);
                }
            });
            session.schedulePeriodicSessionPositionInfoChanges();
        }

        @Override // androidx.media3.common.Player.Listener
        public void onIsPlayingChanged(boolean z10) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithIsPlaying(z10);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.t8

                /* renamed from: a */
                public final /* synthetic */ boolean f925a;

                public /* synthetic */ t8(boolean z102) {
                    z10 = z102;
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                    controllerCb.onIsPlayingChanged(i10, z10);
                }
            });
            session.schedulePeriodicSessionPositionInfoChanges();
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onLoadingChanged(boolean z10) {
            m0.c0.k(this, z10);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onMaxSeekToPreviousPositionChanged(long j10) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithMaxSeekToPreviousPositionMs(j10);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onMediaItemTransition(@Nullable MediaItem mediaItem, int i10) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithMediaItemTransitionReason(i10);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.y8

                /* renamed from: b */
                public final /* synthetic */ int f1054b;

                public /* synthetic */ y8(int i102) {
                    i10 = i102;
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i11) {
                    controllerCb.onMediaItemTransition(i11, MediaItem.this, i10);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithMediaMetadata(mediaMetadata);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.v8
                public /* synthetic */ v8() {
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                    controllerCb.onMediaMetadataChanged(i10, MediaMetadata.this);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onMetadata(Metadata metadata) {
            m0.c0.o(this, metadata);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlayWhenReadyChanged(boolean z10, int i10) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithPlayWhenReady(z10, i10, session.playerInfo.playbackSuppressionReason);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.d9

                /* renamed from: a */
                public final /* synthetic */ boolean f484a;

                /* renamed from: b */
                public final /* synthetic */ int f485b;

                public /* synthetic */ d9(boolean z102, int i102) {
                    z10 = z102;
                    i10 = i102;
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i11) {
                    controllerCb.onPlayWhenReadyChanged(i11, z10, i10);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithPlaybackParameters(playbackParameters);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.s8
                public /* synthetic */ s8() {
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                    controllerCb.onPlaybackParametersChanged(i10, PlaybackParameters.this);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlaybackStateChanged(int i10) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            PlayerWrapper playerWrapper = this.player.get();
            if (playerWrapper == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithPlaybackState(i10, playerWrapper.getPlayerError());
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.o8

                /* renamed from: a */
                public final /* synthetic */ int f809a;

                /* renamed from: b */
                public final /* synthetic */ PlayerWrapper f810b;

                public /* synthetic */ o8(int i102, PlayerWrapper playerWrapper2) {
                    i10 = i102;
                    playerWrapper = playerWrapper2;
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i11) {
                    MediaSessionImpl.PlayerListener.lambda$onPlaybackStateChanged$4(i10, playerWrapper, controllerCb, i11);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlaybackSuppressionReasonChanged(int i10) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithPlayWhenReady(session.playerInfo.playWhenReady, session.playerInfo.playWhenReadyChangedReason, i10);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.f9

                /* renamed from: a */
                public final /* synthetic */ int f537a;

                public /* synthetic */ f9(int i102) {
                    i10 = i102;
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i11) {
                    controllerCb.onPlaybackSuppressionReasonChanged(i11, i10);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlayerError(PlaybackException playbackException) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithPlayerError(playbackException);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.c9
                public /* synthetic */ c9() {
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                    controllerCb.onPlayerError(i10, PlaybackException.this);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
            m0.c0.u(this, playbackException);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onPlayerStateChanged(boolean z10, int i10) {
            m0.c0.v(this, z10, i10);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            session.playerInfo = session.playerInfo.copyWithPlaylistMetadata(mediaMetadata);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.i8
                public /* synthetic */ i8() {
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                    controllerCb.onPlaylistMetadataChanged(i10, MediaMetadata.this);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onPositionDiscontinuity(int i10) {
            m0.c0.x(this, i10);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onRenderedFirstFrame() {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            session.dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media3.session.x8
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                    controllerCb.onRenderedFirstFrame(i10);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onRepeatModeChanged(int i10) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithRepeatMode(i10);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.u8

                /* renamed from: a */
                public final /* synthetic */ int f953a;

                public /* synthetic */ u8(int i102) {
                    i10 = i102;
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i11) {
                    controllerCb.onRepeatModeChanged(i11, i10);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onSeekBackIncrementChanged(long j10) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithSeekBackIncrement(j10);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.a9

                /* renamed from: a */
                public final /* synthetic */ long f403a;

                public /* synthetic */ a9(long j102) {
                    j10 = j102;
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                    controllerCb.onSeekBackIncrementChanged(i10, j10);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onSeekForwardIncrementChanged(long j10) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithSeekForwardIncrement(j10);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.w8

                /* renamed from: a */
                public final /* synthetic */ long f1003a;

                public /* synthetic */ w8(long j102) {
                    j10 = j102;
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                    controllerCb.onSeekForwardIncrementChanged(i10, j10);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onShuffleModeEnabledChanged(boolean z10) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithShuffleModeEnabled(z10);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.l8

                /* renamed from: a */
                public final /* synthetic */ boolean f719a;

                public /* synthetic */ l8(boolean z102) {
                    z10 = z102;
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                    controllerCb.onShuffleModeEnabledChanged(i10, z10);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z10) {
            m0.c0.E(this, z10);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onSurfaceSizeChanged(int i10, int i11) {
            m0.c0.F(this, i10, i11);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onTimelineChanged(Timeline timeline, int i10) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            PlayerWrapper playerWrapper = this.player.get();
            if (playerWrapper == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithTimelineAndSessionPositionInfo(timeline, playerWrapper.createSessionPositionInfoForBundling());
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(false, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.p8

                /* renamed from: b */
                public final /* synthetic */ int f834b;

                public /* synthetic */ p8(int i102) {
                    i10 = i102;
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i11) {
                    controllerCb.onTimelineChanged(i11, Timeline.this, i10);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithTrackSelectionParameters(trackSelectionParameters);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media3.session.j8
                public /* synthetic */ j8() {
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                    controllerCb.onTrackSelectionParametersChanged(i10, TrackSelectionParameters.this);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onTracksChanged(Tracks tracks) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithCurrentTracks(tracks);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, false);
            session.dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media3.session.n8
                public /* synthetic */ n8() {
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                    controllerCb.onTracksChanged(i10, Tracks.this);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onVideoSizeChanged(VideoSize videoSize) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            session.playerInfo = session.playerInfo.copyWithVideoSize(videoSize);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.e9
                public /* synthetic */ e9() {
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                    controllerCb.onVideoSizeChanged(i10, VideoSize.this);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onVolumeChanged(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            session.playerInfo = session.playerInfo.copyWithVolume(f10);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.r8

                /* renamed from: a */
                public final /* synthetic */ float f876a;

                public /* synthetic */ r8(float f102) {
                    f10 = f102;
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                    controllerCb.onVolumeChanged(i10, f10);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onCues(CueGroup cueGroup) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = new PlayerInfo.Builder(session.playerInfo).setCues(cueGroup).build();
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i10) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithPositionInfos(positionInfo, positionInfo2, i10);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.b9

                /* renamed from: b */
                public final /* synthetic */ Player.PositionInfo f430b;

                /* renamed from: c */
                public final /* synthetic */ int f431c;

                public /* synthetic */ b9(Player.PositionInfo positionInfo22, int i102) {
                    positionInfo2 = positionInfo22;
                    i10 = i102;
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i11) {
                    controllerCb.onPositionDiscontinuity(i11, Player.PositionInfo.this, positionInfo2, i10);
                }
            });
        }
    }

    public interface RemoteControllerTask {
        void run(MediaSession.ControllerCb controllerCb, int i10) throws RemoteException;
    }

    public MediaSessionImpl(MediaSession mediaSession, Context context, String str, Player player, @Nullable PendingIntent pendingIntent, MediaSession.Callback callback, Bundle bundle, androidx.media3.common.util.BitmapLoader bitmapLoader) {
        this.context = context;
        this.instance = mediaSession;
        MediaSessionStub mediaSessionStub = new MediaSessionStub(this);
        this.sessionStub = mediaSessionStub;
        this.sessionActivity = pendingIntent;
        this.mainHandler = new Handler(Looper.getMainLooper());
        Handler handler = new Handler(player.getApplicationLooper());
        this.applicationHandler = handler;
        this.callback = callback;
        this.bitmapLoader = bitmapLoader;
        this.playerInfo = PlayerInfo.DEFAULT;
        this.onPlayerInfoChangedHandler = new PlayerInfoChangedHandler(player.getApplicationLooper());
        this.sessionId = str;
        Uri build = new Uri.Builder().scheme(MediaSessionImpl.class.getName()).appendPath(str).appendPath(String.valueOf(SystemClock.elapsedRealtime())).build();
        this.sessionUri = build;
        this.sessionToken = new SessionToken(Process.myUid(), 0, MediaLibraryInfo.VERSION_INT, 2, context.getPackageName(), mediaSessionStub, bundle);
        this.sessionLegacyStub = new MediaSessionLegacyStub(this, build, handler);
        PlayerWrapper playerWrapper = new PlayerWrapper(player);
        this.playerWrapper = playerWrapper;
        Util.postOrRun(handler, new Runnable() { // from class: androidx.media3.session.h8

            /* renamed from: c */
            public final /* synthetic */ PlayerWrapper f602c;

            public /* synthetic */ h8(PlayerWrapper playerWrapper2) {
                playerWrapper = playerWrapper2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionImpl.this.setPlayerInternal(null, playerWrapper);
            }
        });
        this.sessionPositionUpdateDelayMs = 3000L;
        this.periodicSessionPositionInfoUpdateRunnable = new Runnable() { // from class: androidx.media3.session.q7
            public /* synthetic */ q7() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionImpl.this.notifyPeriodicSessionPositionInfoChangesOnHandler();
            }
        };
        Util.postOrRun(handler, new Runnable() { // from class: androidx.media3.session.r7
            public /* synthetic */ r7() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionImpl.this.schedulePeriodicSessionPositionInfoChanges();
            }
        });
    }

    private void dispatchOnPeriodicSessionPositionInfoChanged(SessionPositionInfo sessionPositionInfo) {
        ConnectedControllersManager<IBinder> connectedControllersManager = this.sessionStub.getConnectedControllersManager();
        ImmutableList<MediaSession.ControllerInfo> connectedControllers = this.sessionStub.getConnectedControllersManager().getConnectedControllers();
        for (int i10 = 0; i10 < connectedControllers.size(); i10++) {
            MediaSession.ControllerInfo controllerInfo = connectedControllers.get(i10);
            dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new RemoteControllerTask() { // from class: androidx.media3.session.w7

                /* renamed from: b */
                public final /* synthetic */ boolean f1001b;

                /* renamed from: c */
                public final /* synthetic */ boolean f1002c;

                public /* synthetic */ w7(boolean z10, boolean z11) {
                    isPlayerCommandAvailable = z10;
                    isPlayerCommandAvailable2 = z11;
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i11) {
                    controllerCb.onPeriodicSessionPositionInfoChanged(i11, SessionPositionInfo.this, isPlayerCommandAvailable, isPlayerCommandAvailable2);
                }
            });
        }
        try {
            this.sessionLegacyStub.getControllerLegacyCbForBroadcast().onPeriodicSessionPositionInfoChanged(0, sessionPositionInfo, true, true);
        } catch (RemoteException e10) {
            Log.e(TAG, "Exception in using media1 API", e10);
        }
    }

    public void dispatchOnPlayerInfoChanged(PlayerInfo playerInfo, boolean z10, boolean z11) {
        int i10;
        PlayerInfo generateAndCacheUniqueTrackGroupIds = this.sessionStub.generateAndCacheUniqueTrackGroupIds(playerInfo);
        ImmutableList<MediaSession.ControllerInfo> connectedControllers = this.sessionStub.getConnectedControllersManager().getConnectedControllers();
        for (int i11 = 0; i11 < connectedControllers.size(); i11++) {
            MediaSession.ControllerInfo controllerInfo = connectedControllers.get(i11);
            try {
                ConnectedControllersManager<IBinder> connectedControllersManager = this.sessionStub.getConnectedControllersManager();
                SequencedFutureManager sequencedFutureManager = connectedControllersManager.getSequencedFutureManager(controllerInfo);
                if (sequencedFutureManager != null) {
                    i10 = sequencedFutureManager.obtainNextSequenceNumber();
                } else if (!isConnected(controllerInfo)) {
                    return;
                } else {
                    i10 = 0;
                }
                ((MediaSession.ControllerCb) Assertions.checkStateNotNull(controllerInfo.getControllerCb())).onPlayerInfoChanged(i10, generateAndCacheUniqueTrackGroupIds, MediaUtils.intersect(connectedControllersManager.getAvailablePlayerCommands(controllerInfo), getPlayerWrapper().getAvailableCommands()), z10, z11, controllerInfo.getInterfaceVersion());
            } catch (DeadObjectException unused) {
                onDeadObjectException(controllerInfo);
            } catch (RemoteException e10) {
                Log.w(TAG, "Exception in " + controllerInfo.toString(), e10);
            }
        }
    }

    private p5.c0<SessionResult> dispatchRemoteControllerTask(MediaSession.ControllerInfo controllerInfo, RemoteControllerTask remoteControllerTask) {
        int i10;
        p5.c0<SessionResult> c0Var;
        try {
            SequencedFutureManager sequencedFutureManager = this.sessionStub.getConnectedControllersManager().getSequencedFutureManager(controllerInfo);
            if (sequencedFutureManager != null) {
                SequencedFutureManager.SequencedFuture createSequencedFuture = sequencedFutureManager.createSequencedFuture(RESULT_WHEN_CLOSED);
                i10 = createSequencedFuture.getSequenceNumber();
                c0Var = createSequencedFuture;
            } else {
                if (!isConnected(controllerInfo)) {
                    return com.google.common.util.concurrent.l.m(new SessionResult(-100));
                }
                i10 = 0;
                c0Var = com.google.common.util.concurrent.l.m(new SessionResult(0));
            }
            MediaSession.ControllerCb controllerCb = controllerInfo.getControllerCb();
            if (controllerCb != null) {
                remoteControllerTask.run(controllerCb, i10);
            }
            return c0Var;
        } catch (DeadObjectException unused) {
            onDeadObjectException(controllerInfo);
            return com.google.common.util.concurrent.l.m(new SessionResult(-100));
        } catch (RemoteException e10) {
            Log.w(TAG, "Exception in " + controllerInfo.toString(), e10);
            return com.google.common.util.concurrent.l.m(new SessionResult(-1));
        }
    }

    public void dispatchRemoteControllerTaskToLegacyStub(RemoteControllerTask remoteControllerTask) {
        try {
            remoteControllerTask.run(this.sessionLegacyStub.getControllerLegacyCbForBroadcast(), 0);
        } catch (RemoteException e10) {
            Log.e(TAG, "Exception in using media1 API", e10);
        }
    }

    public void handleAvailablePlayerCommandsChanged(Player.Commands commands) {
        this.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(false, false);
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media3.session.a8
            public /* synthetic */ a8() {
            }

            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                controllerCb.onAvailableCommandsChangedFromPlayer(i10, Player.Commands.this);
            }
        });
        dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.b8
            public /* synthetic */ b8() {
            }

            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                MediaSessionImpl.this.lambda$handleAvailablePlayerCommandsChanged$16(controllerCb, i10);
            }
        });
    }

    public /* synthetic */ void lambda$callWithControllerForCurrentRequestSet$3(MediaSession.ControllerInfo controllerInfo, Runnable runnable) {
        this.controllerForCurrentRequest = controllerInfo;
        runnable.run();
        this.controllerForCurrentRequest = null;
    }

    public /* synthetic */ void lambda$handleAvailablePlayerCommandsChanged$16(MediaSession.ControllerCb controllerCb, int i10) throws RemoteException {
        controllerCb.onDeviceInfoChanged(i10, this.playerInfo.deviceInfo);
    }

    public /* synthetic */ void lambda$onNotificationRefreshRequired$12() {
        MediaSession.Listener listener = this.mediaSessionListener;
        if (listener != null) {
            listener.onNotificationRefreshRequired(this.instance);
        }
    }

    public /* synthetic */ void lambda$onPlayRequested$13(com.google.common.util.concurrent.s sVar) {
        sVar.set(Boolean.valueOf(onPlayRequested()));
    }

    public /* synthetic */ void lambda$release$2() {
        PlayerListener playerListener = this.playerListener;
        if (playerListener != null) {
            this.playerWrapper.removeListener(playerListener);
        }
    }

    public void notifyPeriodicSessionPositionInfoChangesOnHandler() {
        synchronized (this.lock) {
            try {
                if (this.closed) {
                    return;
                }
                SessionPositionInfo createSessionPositionInfoForBundling = this.playerWrapper.createSessionPositionInfoForBundling();
                if (!this.onPlayerInfoChangedHandler.hasPendingPlayerInfoChangedUpdate() && MediaUtils.areSessionPositionInfosInSamePeriodOrAd(createSessionPositionInfoForBundling, this.playerInfo.sessionPositionInfo)) {
                    dispatchOnPeriodicSessionPositionInfoChanged(createSessionPositionInfoForBundling);
                }
                schedulePeriodicSessionPositionInfoChanges();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void onDeadObjectException(MediaSession.ControllerInfo controllerInfo) {
        this.sessionStub.getConnectedControllersManager().removeController(controllerInfo);
    }

    public void schedulePeriodicSessionPositionInfoChanges() {
        this.applicationHandler.removeCallbacks(this.periodicSessionPositionInfoUpdateRunnable);
        if (this.sessionPositionUpdateDelayMs > 0) {
            if (this.playerWrapper.isPlaying() || this.playerWrapper.isLoading()) {
                this.applicationHandler.postDelayed(this.periodicSessionPositionInfoUpdateRunnable, this.sessionPositionUpdateDelayMs);
            }
        }
    }

    public void setPlayerInternal(@Nullable PlayerWrapper playerWrapper, PlayerWrapper playerWrapper2) {
        this.playerWrapper = playerWrapper2;
        if (playerWrapper != null) {
            playerWrapper.removeListener((Player.Listener) Assertions.checkStateNotNull(this.playerListener));
        }
        PlayerListener playerListener = new PlayerListener(this, playerWrapper2);
        playerWrapper2.addListener(playerListener);
        this.playerListener = playerListener;
        dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.e8

            /* renamed from: b */
            public final /* synthetic */ PlayerWrapper f511b;

            public /* synthetic */ e8(PlayerWrapper playerWrapper22) {
                playerWrapper2 = playerWrapper22;
            }

            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                controllerCb.onPlayerChanged(i10, PlayerWrapper.this, playerWrapper2);
            }
        });
        if (playerWrapper == null) {
            this.sessionLegacyStub.start();
        }
        this.playerInfo = playerWrapper22.createPlayerInfoForBundling();
        handleAvailablePlayerCommandsChanged(playerWrapper22.getAvailableCommands());
    }

    public void verifyApplicationThread() {
        if (Looper.myLooper() != this.applicationHandler.getLooper()) {
            throw new IllegalStateException(WRONG_THREAD_ERROR_MESSAGE);
        }
    }

    public void broadcastCustomCommand(SessionCommand sessionCommand, Bundle bundle) {
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media3.session.g8

            /* renamed from: b */
            public final /* synthetic */ Bundle f571b;

            public /* synthetic */ g8(Bundle bundle2) {
                bundle = bundle2;
            }

            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                controllerCb.sendCustomCommand(i10, SessionCommand.this, bundle);
            }
        });
    }

    @CheckResult
    public Runnable callWithControllerForCurrentRequestSet(@Nullable MediaSession.ControllerInfo controllerInfo, Runnable runnable) {
        return new Runnable() { // from class: androidx.media3.session.t7

            /* renamed from: c */
            public final /* synthetic */ MediaSession.ControllerInfo f923c;

            /* renamed from: d */
            public final /* synthetic */ Runnable f924d;

            public /* synthetic */ t7(MediaSession.ControllerInfo controllerInfo2, Runnable runnable2) {
                controllerInfo = controllerInfo2;
                runnable = runnable2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionImpl.this.lambda$callWithControllerForCurrentRequestSet$3(controllerInfo, runnable);
            }
        };
    }

    public boolean canResumePlaybackOnStart() {
        return this.sessionLegacyStub.canResumePlaybackOnStart();
    }

    public void clearMediaSessionListener() {
        this.mediaSessionListener = null;
    }

    public void connectFromService(IMediaController iMediaController, int i10, int i11, String str, int i12, int i13, Bundle bundle) {
        this.sessionStub.connect(iMediaController, i10, i11, str, i12, i13, (Bundle) Assertions.checkStateNotNull(bundle));
    }

    public MediaSessionServiceLegacyStub createLegacyBrowserService(MediaSessionCompat.Token token) {
        MediaSessionServiceLegacyStub mediaSessionServiceLegacyStub = new MediaSessionServiceLegacyStub(this);
        mediaSessionServiceLegacyStub.initialize(token);
        return mediaSessionServiceLegacyStub;
    }

    public void dispatchRemoteControllerTaskWithoutReturn(RemoteControllerTask remoteControllerTask) {
        ImmutableList<MediaSession.ControllerInfo> connectedControllers = this.sessionStub.getConnectedControllersManager().getConnectedControllers();
        for (int i10 = 0; i10 < connectedControllers.size(); i10++) {
            dispatchRemoteControllerTaskWithoutReturn(connectedControllers.get(i10), remoteControllerTask);
        }
        try {
            remoteControllerTask.run(this.sessionLegacyStub.getControllerLegacyCbForBroadcast(), 0);
        } catch (RemoteException e10) {
            Log.e(TAG, "Exception in using media1 API", e10);
        }
    }

    public Handler getApplicationHandler() {
        return this.applicationHandler;
    }

    public androidx.media3.common.util.BitmapLoader getBitmapLoader() {
        return this.bitmapLoader;
    }

    public List<MediaSession.ControllerInfo> getConnectedControllers() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.sessionStub.getConnectedControllersManager().getConnectedControllers());
        arrayList.addAll(this.sessionLegacyStub.getConnectedControllersManager().getConnectedControllers());
        return arrayList;
    }

    public Context getContext() {
        return this.context;
    }

    @Nullable
    public MediaSession.ControllerInfo getControllerForCurrentRequest() {
        return this.controllerForCurrentRequest;
    }

    public String getId() {
        return this.sessionId;
    }

    @Nullable
    public MediaSessionServiceLegacyStub getLegacyBrowserService() {
        MediaSessionServiceLegacyStub mediaSessionServiceLegacyStub;
        synchronized (this.lock) {
            mediaSessionServiceLegacyStub = this.browserServiceLegacyStub;
        }
        return mediaSessionServiceLegacyStub;
    }

    public IBinder getLegacyBrowserServiceBinder() {
        MediaSessionServiceLegacyStub mediaSessionServiceLegacyStub;
        synchronized (this.lock) {
            try {
                if (this.browserServiceLegacyStub == null) {
                    this.browserServiceLegacyStub = createLegacyBrowserService(this.instance.getSessionCompat().getSessionToken());
                }
                mediaSessionServiceLegacyStub = this.browserServiceLegacyStub;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return mediaSessionServiceLegacyStub.onBind(new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE));
    }

    public PlayerWrapper getPlayerWrapper() {
        return this.playerWrapper;
    }

    @Nullable
    public PendingIntent getSessionActivity() {
        return this.sessionActivity;
    }

    public MediaSessionCompat getSessionCompat() {
        return this.sessionLegacyStub.getSessionCompat();
    }

    public SessionToken getToken() {
        return this.sessionToken;
    }

    public Uri getUri() {
        return this.sessionUri;
    }

    public boolean isConnected(MediaSession.ControllerInfo controllerInfo) {
        return this.sessionStub.getConnectedControllersManager().isConnected(controllerInfo) || this.sessionLegacyStub.getConnectedControllersManager().isConnected(controllerInfo);
    }

    public boolean isReleased() {
        boolean z10;
        synchronized (this.lock) {
            z10 = this.closed;
        }
        return z10;
    }

    public p5.c0<List<MediaItem>> onAddMediaItemsOnHandler(MediaSession.ControllerInfo controllerInfo, List<MediaItem> list) {
        return (p5.c0) Assertions.checkNotNull(this.callback.onAddMediaItems(this.instance, controllerInfo, list), "Callback.onAddMediaItems must return a non-null future");
    }

    public MediaSession.ConnectionResult onConnectOnHandler(MediaSession.ControllerInfo controllerInfo) {
        return (MediaSession.ConnectionResult) Assertions.checkNotNull(this.callback.onConnect(this.instance, controllerInfo), "Callback.onConnect must return non-null future");
    }

    public p5.c0<SessionResult> onCustomCommandOnHandler(MediaSession.ControllerInfo controllerInfo, SessionCommand sessionCommand, Bundle bundle) {
        return (p5.c0) Assertions.checkNotNull(this.callback.onCustomCommand(this.instance, controllerInfo, sessionCommand, bundle), "Callback.onCustomCommandOnHandler must return non-null future");
    }

    public void onDisconnectedOnHandler(MediaSession.ControllerInfo controllerInfo) {
        this.callback.onDisconnected(this.instance, controllerInfo);
    }

    public void onNotificationRefreshRequired() {
        Util.postOrRun(this.mainHandler, new Runnable() { // from class: androidx.media3.session.s7
            public /* synthetic */ s7() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionImpl.this.lambda$onNotificationRefreshRequired$12();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onPlayRequested() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            MediaSession.Listener listener = this.mediaSessionListener;
            if (listener != null) {
                return listener.onPlayRequested(this.instance);
            }
            return true;
        }
        com.google.common.util.concurrent.s n10 = com.google.common.util.concurrent.s.n();
        this.mainHandler.post(new Runnable() { // from class: androidx.media3.session.u7

            /* renamed from: c */
            public final /* synthetic */ com.google.common.util.concurrent.s f952c;

            public /* synthetic */ u7(com.google.common.util.concurrent.s n102) {
                n10 = n102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionImpl.this.lambda$onPlayRequested$13(n10);
            }
        });
        try {
            return ((Boolean) n102.get()).booleanValue();
        } catch (InterruptedException | ExecutionException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public int onPlayerCommandRequestOnHandler(MediaSession.ControllerInfo controllerInfo, int i10) {
        return this.callback.onPlayerCommandRequest(this.instance, controllerInfo, i10);
    }

    public void onPostConnectOnHandler(MediaSession.ControllerInfo controllerInfo) {
        this.callback.onPostConnect(this.instance, controllerInfo);
    }

    public p5.c0<MediaSession.MediaItemsWithStartPosition> onSetMediaItemsOnHandler(MediaSession.ControllerInfo controllerInfo, List<MediaItem> list, int i10, long j10) {
        return (p5.c0) Assertions.checkNotNull(this.callback.onSetMediaItems(this.instance, controllerInfo, list, i10, j10), "Callback.onSetMediaItems must return a non-null future");
    }

    public p5.c0<SessionResult> onSetRatingOnHandler(MediaSession.ControllerInfo controllerInfo, String str, Rating rating) {
        return (p5.c0) Assertions.checkNotNull(this.callback.onSetRating(this.instance, controllerInfo, str, rating), "Callback.onSetRating must return non-null future");
    }

    public void prepareAndPlayForPlaybackResumption(MediaSession.ControllerInfo controllerInfo, Player player) {
        verifyApplicationThread();
        p5.c0 c0Var = (p5.c0) Assertions.checkNotNull(this.callback.onPlaybackResumption(this.instance, controllerInfo), "Callback.onPlaybackResumption must return a non-null future");
        com.google.common.util.concurrent.l.a(c0Var, new p5.x<MediaSession.MediaItemsWithStartPosition>(this) { // from class: androidx.media3.session.MediaSessionImpl.1
            final /* synthetic */ Player val$player;

            public AnonymousClass1(MediaSessionImpl this, Player player2) {
                player = player2;
            }

            @Override // p5.x
            public void onFailure(Throwable th2) {
                if (th2 instanceof UnsupportedOperationException) {
                    Log.w(MediaSessionImpl.TAG, "UnsupportedOperationException: Make sure to implement MediaSession.Callback.onPlaybackResumption() if you add a media button receiver to your manifest or if you implement the recent media item contract with your MediaLibraryService.", th2);
                } else {
                    Log.e(MediaSessionImpl.TAG, "Failure calling MediaSession.Callback.onPlaybackResumption(): " + th2.getMessage(), th2);
                }
                Util.handlePlayButtonAction(player);
            }

            @Override // p5.x
            public void onSuccess(MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition) {
                ImmutableList<MediaItem> immutableList = mediaItemsWithStartPosition.mediaItems;
                player.setMediaItems(immutableList, mediaItemsWithStartPosition.startIndex != -1 ? Math.min(immutableList.size() - 1, mediaItemsWithStartPosition.startIndex) : 0, mediaItemsWithStartPosition.startPositionMs);
                if (player.getPlaybackState() == 1) {
                    player.prepare();
                }
                player.play();
            }
        }, c0Var.isDone() ? com.google.common.util.concurrent.p.c() : ExecutorCompat.create(getApplicationHandler()));
    }

    public void release() {
        synchronized (this.lock) {
            try {
                if (this.closed) {
                    return;
                }
                this.closed = true;
                this.applicationHandler.removeCallbacksAndMessages(null);
                try {
                    Util.postOrRun(this.applicationHandler, new Runnable() { // from class: androidx.media3.session.p7
                        public /* synthetic */ p7() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            MediaSessionImpl.this.lambda$release$2();
                        }
                    });
                } catch (Exception e10) {
                    Log.w(TAG, "Exception thrown while closing", e10);
                }
                this.sessionLegacyStub.release();
                this.sessionStub.release();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public p5.c0<SessionResult> sendCustomCommand(MediaSession.ControllerInfo controllerInfo, SessionCommand sessionCommand, Bundle bundle) {
        return dispatchRemoteControllerTask(controllerInfo, new RemoteControllerTask() { // from class: androidx.media3.session.d8

            /* renamed from: b */
            public final /* synthetic */ Bundle f483b;

            public /* synthetic */ d8(Bundle bundle2) {
                bundle = bundle2;
            }

            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                controllerCb.sendCustomCommand(i10, SessionCommand.this, bundle);
            }
        });
    }

    public void setAvailableCommands(MediaSession.ControllerInfo controllerInfo, SessionCommands sessionCommands, Player.Commands commands) {
        if (!this.sessionStub.getConnectedControllersManager().isConnected(controllerInfo)) {
            this.sessionLegacyStub.getConnectedControllersManager().updateCommandsFromSession(controllerInfo, sessionCommands, commands);
            return;
        }
        this.sessionStub.getConnectedControllersManager().updateCommandsFromSession(controllerInfo, sessionCommands, commands);
        dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new RemoteControllerTask() { // from class: androidx.media3.session.y7

            /* renamed from: b */
            public final /* synthetic */ Player.Commands f1052b;

            public /* synthetic */ y7(Player.Commands commands2) {
                commands = commands2;
            }

            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                controllerCb.onAvailableCommandsChangedFromSession(i10, SessionCommands.this, commands);
            }
        });
        this.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(false, false);
    }

    public p5.c0<SessionResult> setCustomLayout(MediaSession.ControllerInfo controllerInfo, List<CommandButton> list) {
        return dispatchRemoteControllerTask(controllerInfo, new RemoteControllerTask() { // from class: androidx.media3.session.x7

            /* renamed from: a */
            public final /* synthetic */ List f1022a;

            public /* synthetic */ x7(List list2) {
                list = list2;
            }

            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                controllerCb.setCustomLayout(i10, list);
            }
        });
    }

    public void setLegacyControllerConnectionTimeoutMs(long j10) {
        this.sessionLegacyStub.setLegacyControllerDisconnectTimeoutMs(j10);
    }

    public void setMediaSessionListener(MediaSession.Listener listener) {
        this.mediaSessionListener = listener;
    }

    public void setPlayer(Player player) {
        if (player == this.playerWrapper.getWrappedPlayer()) {
            return;
        }
        setPlayerInternal(this.playerWrapper, new PlayerWrapper(player));
    }

    @UnstableApi
    public void setSessionActivity(PendingIntent pendingIntent) {
        if (Objects.equals(this.sessionActivity, pendingIntent)) {
            return;
        }
        this.sessionActivity = pendingIntent;
        this.sessionLegacyStub.getSessionCompat().setSessionActivity(pendingIntent);
        ImmutableList<MediaSession.ControllerInfo> connectedControllers = this.sessionStub.getConnectedControllersManager().getConnectedControllers();
        for (int i10 = 0; i10 < connectedControllers.size(); i10++) {
            MediaSession.ControllerInfo controllerInfo = connectedControllers.get(i10);
            if (controllerInfo.getControllerVersion() >= 3) {
                dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new RemoteControllerTask() { // from class: androidx.media3.session.c8

                    /* renamed from: a */
                    public final /* synthetic */ PendingIntent f453a;

                    public /* synthetic */ c8(PendingIntent pendingIntent2) {
                        pendingIntent = pendingIntent2;
                    }

                    @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                    public final void run(MediaSession.ControllerCb controllerCb, int i11) {
                        controllerCb.onSessionActivityChanged(i11, pendingIntent);
                    }
                });
            }
        }
    }

    public void setSessionExtras(Bundle bundle) {
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media3.session.z7

            /* renamed from: a */
            public final /* synthetic */ Bundle f1075a;

            public /* synthetic */ z7(Bundle bundle2) {
                bundle = bundle2;
            }

            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                controllerCb.onSessionExtrasChanged(i10, bundle);
            }
        });
    }

    public void setSessionPositionUpdateDelayMsOnHandler(long j10) {
        verifyApplicationThread();
        this.sessionPositionUpdateDelayMs = j10;
        schedulePeriodicSessionPositionInfoChanges();
    }

    public void setCustomLayout(List<CommandButton> list) {
        this.playerWrapper.setCustomLayout(ImmutableList.copyOf((Collection) list));
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media3.session.f8

            /* renamed from: a */
            public final /* synthetic */ List f536a;

            public /* synthetic */ f8(List list2) {
                list = list2;
            }

            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                controllerCb.setCustomLayout(i10, list);
            }
        });
    }

    public void setSessionExtras(MediaSession.ControllerInfo controllerInfo, Bundle bundle) {
        if (this.sessionStub.getConnectedControllersManager().isConnected(controllerInfo)) {
            dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new RemoteControllerTask() { // from class: androidx.media3.session.v7

                /* renamed from: a */
                public final /* synthetic */ Bundle f980a;

                public /* synthetic */ v7(Bundle bundle2) {
                    bundle = bundle2;
                }

                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i10) {
                    controllerCb.onSessionExtrasChanged(i10, bundle);
                }
            });
        }
    }

    public p5.c0<SessionResult> onSetRatingOnHandler(MediaSession.ControllerInfo controllerInfo, Rating rating) {
        return (p5.c0) Assertions.checkNotNull(this.callback.onSetRating(this.instance, controllerInfo, rating), "Callback.onSetRating must return non-null future");
    }

    public void dispatchRemoteControllerTaskWithoutReturn(MediaSession.ControllerInfo controllerInfo, RemoteControllerTask remoteControllerTask) {
        int i10;
        try {
            SequencedFutureManager sequencedFutureManager = this.sessionStub.getConnectedControllersManager().getSequencedFutureManager(controllerInfo);
            if (sequencedFutureManager != null) {
                i10 = sequencedFutureManager.obtainNextSequenceNumber();
            } else if (!isConnected(controllerInfo)) {
                return;
            } else {
                i10 = 0;
            }
            MediaSession.ControllerCb controllerCb = controllerInfo.getControllerCb();
            if (controllerCb != null) {
                remoteControllerTask.run(controllerCb, i10);
            }
        } catch (DeadObjectException unused) {
            onDeadObjectException(controllerInfo);
        } catch (RemoteException e10) {
            Log.w(TAG, "Exception in " + controllerInfo.toString(), e10);
        }
    }
}
