package androidx.media3.session;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Rating;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BundleableUtil;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.ConnectedControllersManager;
import androidx.media3.session.IMediaSession;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionStub;
import androidx.media3.session.PlayerInfo;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
final class MediaSessionStub extends IMediaSession.Stub {
    private static final String TAG = "MediaSessionStub";
    public static final int VERSION_INT = 2;
    private final ConnectedControllersManager<IBinder> connectedControllersManager;
    private int nextUniqueTrackGroupIdPrefix;
    private final WeakReference<MediaSessionImpl> sessionImpl;
    private final MediaSessionManager sessionManager;
    private final Set<MediaSession.ControllerInfo> pendingControllers = Collections.synchronizedSet(new HashSet());
    private ImmutableBiMap<TrackGroup, String> trackGroupIdMap = ImmutableBiMap.of();

    public static final class Controller2Cb implements MediaSession.ControllerCb {
        private final IMediaController iController;

        public Controller2Cb(IMediaController iMediaController) {
            this.iController = iMediaController;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != Controller2Cb.class) {
                return false;
            }
            return Util.areEqual(getCallbackBinder(), ((Controller2Cb) obj).getCallbackBinder());
        }

        public IBinder getCallbackBinder() {
            return this.iController.asBinder();
        }

        public int hashCode() {
            return ObjectsCompat.hash(getCallbackBinder());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onAudioAttributesChanged(int i10, AudioAttributes audioAttributes) {
            o7.a(this, i10, audioAttributes);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onAvailableCommandsChangedFromPlayer(int i10, Player.Commands commands) throws RemoteException {
            this.iController.onAvailableCommandsChangedFromPlayer(i10, commands.toBundle());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onAvailableCommandsChangedFromSession(int i10, SessionCommands sessionCommands, Player.Commands commands) throws RemoteException {
            this.iController.onAvailableCommandsChangedFromSession(i10, sessionCommands.toBundle(), commands.toBundle());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onChildrenChanged(int i10, String str, int i11, @Nullable MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
            this.iController.onChildrenChanged(i10, str, i11, libraryParams == null ? null : libraryParams.toBundle());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onDeviceInfoChanged(int i10, DeviceInfo deviceInfo) {
            o7.e(this, i10, deviceInfo);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onDeviceVolumeChanged(int i10, int i11, boolean z10) {
            o7.f(this, i10, i11, z10);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onDisconnected(int i10) throws RemoteException {
            this.iController.onDisconnected(i10);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onIsLoadingChanged(int i10, boolean z10) {
            o7.h(this, i10, z10);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onIsPlayingChanged(int i10, boolean z10) {
            o7.i(this, i10, z10);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onLibraryResult(int i10, LibraryResult<?> libraryResult) throws RemoteException {
            this.iController.onLibraryResult(i10, libraryResult.toBundle());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onMediaItemTransition(int i10, MediaItem mediaItem, int i11) {
            o7.k(this, i10, mediaItem, i11);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onMediaMetadataChanged(int i10, MediaMetadata mediaMetadata) {
            o7.l(this, i10, mediaMetadata);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPeriodicSessionPositionInfoChanged(int i10, SessionPositionInfo sessionPositionInfo, boolean z10, boolean z11) throws RemoteException {
            this.iController.onPeriodicSessionPositionInfoChanged(i10, sessionPositionInfo.toBundle(z10, z11));
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onPlayWhenReadyChanged(int i10, boolean z10, int i11) {
            o7.n(this, i10, z10, i11);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onPlaybackParametersChanged(int i10, PlaybackParameters playbackParameters) {
            o7.o(this, i10, playbackParameters);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onPlaybackStateChanged(int i10, int i11, PlaybackException playbackException) {
            o7.p(this, i10, i11, playbackException);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i10, int i11) {
            o7.q(this, i10, i11);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onPlayerChanged(int i10, PlayerWrapper playerWrapper, PlayerWrapper playerWrapper2) {
            o7.r(this, i10, playerWrapper, playerWrapper2);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onPlayerError(int i10, PlaybackException playbackException) {
            o7.s(this, i10, playbackException);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPlayerInfoChanged(int i10, PlayerInfo playerInfo, Player.Commands commands, boolean z10, boolean z11, int i11) throws RemoteException {
            Assertions.checkState(i11 != 0);
            boolean z12 = z10 || !commands.contains(17);
            boolean z13 = z11 || !commands.contains(30);
            if (i11 >= 2) {
                this.iController.onPlayerInfoChangedWithExclusions(i10, playerInfo.toBundle(commands, z10, z11), new PlayerInfo.BundlingExclusions(z12, z13).toBundle());
            } else {
                this.iController.onPlayerInfoChanged(i10, playerInfo.toBundle(commands, z10, true), z12);
            }
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onPlaylistMetadataChanged(int i10, MediaMetadata mediaMetadata) {
            o7.u(this, i10, mediaMetadata);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onPositionDiscontinuity(int i10, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i11) {
            o7.v(this, i10, positionInfo, positionInfo2, i11);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onRenderedFirstFrame(int i10) throws RemoteException {
            this.iController.onRenderedFirstFrame(i10);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onRepeatModeChanged(int i10, int i11) {
            o7.x(this, i10, i11);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onSearchResultChanged(int i10, String str, int i11, @Nullable MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
            this.iController.onSearchResultChanged(i10, str, i11, libraryParams == null ? null : libraryParams.toBundle());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onSeekBackIncrementChanged(int i10, long j10) {
            o7.z(this, i10, j10);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onSeekForwardIncrementChanged(int i10, long j10) {
            o7.A(this, i10, j10);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onSessionActivityChanged(int i10, PendingIntent pendingIntent) throws RemoteException {
            this.iController.onSessionActivityChanged(i10, pendingIntent);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onSessionExtrasChanged(int i10, Bundle bundle) throws RemoteException {
            this.iController.onExtrasChanged(i10, bundle);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onSessionResult(int i10, SessionResult sessionResult) throws RemoteException {
            this.iController.onSessionResult(i10, sessionResult.toBundle());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onShuffleModeEnabledChanged(int i10, boolean z10) {
            o7.E(this, i10, z10);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onTimelineChanged(int i10, Timeline timeline, int i11) {
            o7.F(this, i10, timeline, i11);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onTrackSelectionParametersChanged(int i10, TrackSelectionParameters trackSelectionParameters) {
            o7.G(this, i10, trackSelectionParameters);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onTracksChanged(int i10, Tracks tracks) {
            o7.H(this, i10, tracks);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onVideoSizeChanged(int i10, VideoSize videoSize) {
            o7.I(this, i10, videoSize);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onVolumeChanged(int i10, float f10) {
            o7.J(this, i10, f10);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void sendCustomCommand(int i10, SessionCommand sessionCommand, Bundle bundle) throws RemoteException {
            this.iController.onCustomCommand(i10, sessionCommand.toBundle(), bundle);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void setCustomLayout(int i10, List<CommandButton> list) throws RemoteException {
            this.iController.onSetCustomLayout(i10, BundleableUtil.toBundleList(list));
        }
    }

    public interface ControllerPlayerTask {
        void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo);
    }

    public interface MediaItemPlayerTask {
        void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List<MediaItem> list);
    }

    public interface MediaItemsWithStartPositionPlayerTask {
        void run(PlayerWrapper playerWrapper, MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition);
    }

    public interface SessionTask<T, K extends MediaSessionImpl> {
        T run(K k10, MediaSession.ControllerInfo controllerInfo, int i10);
    }

    public MediaSessionStub(MediaSessionImpl mediaSessionImpl) {
        this.sessionImpl = new WeakReference<>(mediaSessionImpl);
        this.sessionManager = MediaSessionManager.getSessionManager(mediaSessionImpl.getContext());
        this.connectedControllersManager = new ConnectedControllersManager<>(mediaSessionImpl);
    }

    private <K extends MediaSessionImpl> void dispatchSessionTaskWithSessionCommand(IMediaController iMediaController, int i10, int i11, SessionTask<p5.c0<Void>, K> sessionTask) {
        dispatchSessionTaskWithSessionCommand(iMediaController, i10, null, i11, sessionTask);
    }

    private String generateUniqueTrackGroupId(TrackGroup trackGroup) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = this.nextUniqueTrackGroupIdPrefix;
        this.nextUniqueTrackGroupIdPrefix = i10 + 1;
        sb2.append(Util.intToStringMaxRadix(i10));
        sb2.append("-");
        sb2.append(trackGroup.f376id);
        return sb2.toString();
    }

    private static <K extends MediaSessionImpl> SessionTask<p5.c0<SessionResult>, K> handleMediaItemsWhenReady(SessionTask<p5.c0<List<MediaItem>>, K> sessionTask, MediaItemPlayerTask mediaItemPlayerTask) {
        return new SessionTask() { // from class: androidx.media3.session.md

            /* renamed from: b */
            public final /* synthetic */ MediaSessionStub.MediaItemPlayerTask f762b;

            public /* synthetic */ md(MediaSessionStub.MediaItemPlayerTask mediaItemPlayerTask2) {
                mediaItemPlayerTask = mediaItemPlayerTask2;
            }

            @Override // androidx.media3.session.MediaSessionStub.SessionTask
            public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
                p5.c0 lambda$handleMediaItemsWhenReady$6;
                lambda$handleMediaItemsWhenReady$6 = MediaSessionStub.lambda$handleMediaItemsWhenReady$6(MediaSessionStub.SessionTask.this, mediaItemPlayerTask, mediaSessionImpl, controllerInfo, i10);
                return lambda$handleMediaItemsWhenReady$6;
            }
        };
    }

    private static <K extends MediaSessionImpl> SessionTask<p5.c0<SessionResult>, K> handleMediaItemsWithStartPositionWhenReady(SessionTask<p5.c0<MediaSession.MediaItemsWithStartPosition>, K> sessionTask, MediaItemsWithStartPositionPlayerTask mediaItemsWithStartPositionPlayerTask) {
        return new SessionTask() { // from class: androidx.media3.session.sc

            /* renamed from: b */
            public final /* synthetic */ MediaSessionStub.MediaItemsWithStartPositionPlayerTask f906b;

            public /* synthetic */ sc(MediaSessionStub.MediaItemsWithStartPositionPlayerTask mediaItemsWithStartPositionPlayerTask2) {
                mediaItemsWithStartPositionPlayerTask = mediaItemsWithStartPositionPlayerTask2;
            }

            @Override // androidx.media3.session.MediaSessionStub.SessionTask
            public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
                p5.c0 lambda$handleMediaItemsWithStartPositionWhenReady$9;
                lambda$handleMediaItemsWithStartPositionWhenReady$9 = MediaSessionStub.lambda$handleMediaItemsWithStartPositionWhenReady$9(MediaSessionStub.SessionTask.this, mediaItemsWithStartPositionPlayerTask, mediaSessionImpl, controllerInfo, i10);
                return lambda$handleMediaItemsWithStartPositionWhenReady$9;
            }
        };
    }

    private static <T, K extends MediaSessionImpl> p5.c0<Void> handleSessionTaskWhenReady(K k10, MediaSession.ControllerInfo controllerInfo, int i10, SessionTask<p5.c0<T>, K> sessionTask, Consumer<p5.c0<T>> consumer) {
        if (k10.isReleased()) {
            return com.google.common.util.concurrent.l.n();
        }
        p5.c0<T> run = sessionTask.run(k10, controllerInfo, i10);
        com.google.common.util.concurrent.s n10 = com.google.common.util.concurrent.s.n();
        run.addListener(new Runnable() { // from class: androidx.media3.session.cb

            /* renamed from: c */
            public final /* synthetic */ com.google.common.util.concurrent.s f458c;

            /* renamed from: d */
            public final /* synthetic */ Consumer f459d;

            /* renamed from: e */
            public final /* synthetic */ p5.c0 f460e;

            public /* synthetic */ cb(com.google.common.util.concurrent.s n102, Consumer consumer2, p5.c0 run2) {
                n10 = n102;
                consumer = consumer2;
                run = run2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionStub.lambda$handleSessionTaskWhenReady$16(MediaSessionImpl.this, n10, consumer, run);
            }
        }, com.google.common.util.concurrent.p.c());
        return n102;
    }

    public static /* synthetic */ p5.c0 lambda$addMediaItem$35(MediaItem mediaItem, MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
        return mediaSessionImpl.onAddMediaItemsOnHandler(controllerInfo, ImmutableList.of(mediaItem));
    }

    public static /* synthetic */ p5.c0 lambda$addMediaItemWithIndex$37(MediaItem mediaItem, MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
        return mediaSessionImpl.onAddMediaItemsOnHandler(controllerInfo, ImmutableList.of(mediaItem));
    }

    public /* synthetic */ void lambda$addMediaItemWithIndex$38(int i10, PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list) {
        playerWrapper.addMediaItems(maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i10), list);
    }

    public static /* synthetic */ p5.c0 lambda$addMediaItems$39(List list, MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
        return mediaSessionImpl.onAddMediaItemsOnHandler(controllerInfo, list);
    }

    public static /* synthetic */ p5.c0 lambda$addMediaItemsWithIndex$41(List list, MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
        return mediaSessionImpl.onAddMediaItemsOnHandler(controllerInfo, list);
    }

    public /* synthetic */ void lambda$addMediaItemsWithIndex$42(int i10, PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list) {
        playerWrapper.addMediaItems(maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i10), list);
    }

    public /* synthetic */ void lambda$connect$17(MediaSession.ControllerInfo controllerInfo, MediaSessionImpl mediaSessionImpl, IMediaController iMediaController) {
        boolean z10;
        try {
            this.pendingControllers.remove(controllerInfo);
            if (mediaSessionImpl.isReleased()) {
                try {
                    iMediaController.onDisconnected(0);
                    return;
                } catch (RemoteException unused) {
                    return;
                }
            }
            IBinder callbackBinder = ((Controller2Cb) Assertions.checkStateNotNull((Controller2Cb) controllerInfo.getControllerCb())).getCallbackBinder();
            MediaSession.ConnectionResult onConnectOnHandler = mediaSessionImpl.onConnectOnHandler(controllerInfo);
            if (!onConnectOnHandler.isAccepted && !controllerInfo.isTrusted()) {
                try {
                    iMediaController.onDisconnected(0);
                    return;
                } catch (RemoteException unused2) {
                    return;
                }
            }
            if (!onConnectOnHandler.isAccepted) {
                onConnectOnHandler = MediaSession.ConnectionResult.accept(SessionCommands.EMPTY, Player.Commands.EMPTY);
            }
            if (this.connectedControllersManager.isConnected(controllerInfo)) {
                Log.w(TAG, "Controller " + controllerInfo + " has sent connection request multiple times");
            }
            this.connectedControllersManager.addController(callbackBinder, controllerInfo, onConnectOnHandler.availableSessionCommands, onConnectOnHandler.availablePlayerCommands);
            SequencedFutureManager sequencedFutureManager = (SequencedFutureManager) Assertions.checkStateNotNull(this.connectedControllersManager.getSequencedFutureManager(controllerInfo));
            PlayerWrapper playerWrapper = mediaSessionImpl.getPlayerWrapper();
            ConnectionState connectionState = new ConnectionState(MediaLibraryInfo.VERSION_INT, 2, this, mediaSessionImpl.getSessionActivity(), onConnectOnHandler.availableSessionCommands, onConnectOnHandler.availablePlayerCommands, playerWrapper.getAvailableCommands(), mediaSessionImpl.getToken().getExtras(), generateAndCacheUniqueTrackGroupIds(playerWrapper.createPlayerInfoForBundling()));
            if (mediaSessionImpl.isReleased()) {
                try {
                    iMediaController.onDisconnected(0);
                    return;
                } catch (RemoteException unused3) {
                    return;
                }
            }
            try {
                iMediaController.onConnected(sequencedFutureManager.obtainNextSequenceNumber(), connectionState.toBundle());
                z10 = true;
            } catch (RemoteException unused4) {
                z10 = false;
            }
            try {
                mediaSessionImpl.onPostConnectOnHandler(controllerInfo);
                if (z10) {
                    return;
                }
                try {
                    iMediaController.onDisconnected(0);
                } catch (RemoteException unused5) {
                }
            } catch (Throwable th2) {
                th = th2;
                if (!z10) {
                    try {
                        iMediaController.onDisconnected(0);
                    } catch (RemoteException unused6) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            z10 = false;
        }
    }

    public /* synthetic */ void lambda$dispatchSessionTaskWithSessionCommand$15(MediaSession.ControllerInfo controllerInfo, SessionCommand sessionCommand, int i10, int i11, SessionTask sessionTask, MediaSessionImpl mediaSessionImpl) {
        if (this.connectedControllersManager.isConnected(controllerInfo)) {
            if (sessionCommand != null) {
                if (!this.connectedControllersManager.isSessionCommandAvailable(controllerInfo, sessionCommand)) {
                    sendSessionResult(controllerInfo, i10, new SessionResult(-4));
                    return;
                }
            } else if (!this.connectedControllersManager.isSessionCommandAvailable(controllerInfo, i11)) {
                sendSessionResult(controllerInfo, i10, new SessionResult(-4));
                return;
            }
            sessionTask.run(mediaSessionImpl, controllerInfo, i10);
        }
    }

    public /* synthetic */ void lambda$flushCommandQueue$64(MediaSession.ControllerInfo controllerInfo) {
        this.connectedControllersManager.flushCommandQueue(controllerInfo);
    }

    public static /* synthetic */ p5.c0 lambda$getChildren$68(String str, int i10, int i11, MediaLibraryService.LibraryParams libraryParams, MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession.ControllerInfo controllerInfo, int i12) {
        return mediaLibrarySessionImpl.onGetChildrenOnHandler(controllerInfo, str, i10, i11, libraryParams);
    }

    public static /* synthetic */ p5.c0 lambda$getItem$67(String str, MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
        return mediaLibrarySessionImpl.onGetItemOnHandler(controllerInfo, str);
    }

    public static /* synthetic */ p5.c0 lambda$getLibraryRoot$66(MediaLibraryService.LibraryParams libraryParams, MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
        return mediaLibrarySessionImpl.onGetLibraryRootOnHandler(controllerInfo, libraryParams);
    }

    public static /* synthetic */ p5.c0 lambda$getSearchResult$70(String str, int i10, int i11, MediaLibraryService.LibraryParams libraryParams, MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession.ControllerInfo controllerInfo, int i12) {
        return mediaLibrarySessionImpl.onGetSearchResultOnHandler(controllerInfo, str, i10, i11, libraryParams);
    }

    public static /* synthetic */ void lambda$handleMediaItemsWhenReady$4(MediaSessionImpl mediaSessionImpl, MediaItemPlayerTask mediaItemPlayerTask, MediaSession.ControllerInfo controllerInfo, List list) {
        if (mediaSessionImpl.isReleased()) {
            return;
        }
        mediaItemPlayerTask.run(mediaSessionImpl.getPlayerWrapper(), controllerInfo, list);
    }

    public static /* synthetic */ p5.c0 lambda$handleMediaItemsWhenReady$5(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, MediaItemPlayerTask mediaItemPlayerTask, List list) throws Exception {
        return Util.postOrRunWithCompletion(mediaSessionImpl.getApplicationHandler(), mediaSessionImpl.callWithControllerForCurrentRequestSet(controllerInfo, new Runnable() { // from class: androidx.media3.session.jd

            /* renamed from: c */
            public final /* synthetic */ MediaSessionStub.MediaItemPlayerTask f669c;

            /* renamed from: d */
            public final /* synthetic */ MediaSession.ControllerInfo f670d;

            /* renamed from: e */
            public final /* synthetic */ List f671e;

            public /* synthetic */ jd(MediaSessionStub.MediaItemPlayerTask mediaItemPlayerTask2, MediaSession.ControllerInfo controllerInfo2, List list2) {
                mediaItemPlayerTask = mediaItemPlayerTask2;
                controllerInfo = controllerInfo2;
                list = list2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionStub.lambda$handleMediaItemsWhenReady$4(MediaSessionImpl.this, mediaItemPlayerTask, controllerInfo, list);
            }
        }), new SessionResult(0));
    }

    public static /* synthetic */ p5.c0 lambda$handleMediaItemsWhenReady$6(SessionTask sessionTask, MediaItemPlayerTask mediaItemPlayerTask, MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
        return mediaSessionImpl.isReleased() ? com.google.common.util.concurrent.l.m(new SessionResult(-100)) : Util.transformFutureAsync((p5.c0) sessionTask.run(mediaSessionImpl, controllerInfo, i10), new p5.f() { // from class: androidx.media3.session.fb

            /* renamed from: b */
            public final /* synthetic */ MediaSession.ControllerInfo f540b;

            /* renamed from: c */
            public final /* synthetic */ MediaSessionStub.MediaItemPlayerTask f541c;

            public /* synthetic */ fb(MediaSession.ControllerInfo controllerInfo2, MediaSessionStub.MediaItemPlayerTask mediaItemPlayerTask2) {
                controllerInfo = controllerInfo2;
                mediaItemPlayerTask = mediaItemPlayerTask2;
            }

            @Override // p5.f
            public final p5.c0 apply(Object obj) {
                p5.c0 lambda$handleMediaItemsWhenReady$5;
                lambda$handleMediaItemsWhenReady$5 = MediaSessionStub.lambda$handleMediaItemsWhenReady$5(MediaSessionImpl.this, controllerInfo, mediaItemPlayerTask, (List) obj);
                return lambda$handleMediaItemsWhenReady$5;
            }
        });
    }

    public static /* synthetic */ void lambda$handleMediaItemsWithStartPositionWhenReady$7(MediaSessionImpl mediaSessionImpl, MediaItemsWithStartPositionPlayerTask mediaItemsWithStartPositionPlayerTask, MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition) {
        if (mediaSessionImpl.isReleased()) {
            return;
        }
        mediaItemsWithStartPositionPlayerTask.run(mediaSessionImpl.getPlayerWrapper(), mediaItemsWithStartPosition);
    }

    public static /* synthetic */ p5.c0 lambda$handleMediaItemsWithStartPositionWhenReady$8(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, MediaItemsWithStartPositionPlayerTask mediaItemsWithStartPositionPlayerTask, MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition) throws Exception {
        return Util.postOrRunWithCompletion(mediaSessionImpl.getApplicationHandler(), mediaSessionImpl.callWithControllerForCurrentRequestSet(controllerInfo, new Runnable() { // from class: androidx.media3.session.tb

            /* renamed from: c */
            public final /* synthetic */ MediaSessionStub.MediaItemsWithStartPositionPlayerTask f932c;

            /* renamed from: d */
            public final /* synthetic */ MediaSession.MediaItemsWithStartPosition f933d;

            public /* synthetic */ tb(MediaSessionStub.MediaItemsWithStartPositionPlayerTask mediaItemsWithStartPositionPlayerTask2, MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition2) {
                mediaItemsWithStartPositionPlayerTask = mediaItemsWithStartPositionPlayerTask2;
                mediaItemsWithStartPosition = mediaItemsWithStartPosition2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionStub.lambda$handleMediaItemsWithStartPositionWhenReady$7(MediaSessionImpl.this, mediaItemsWithStartPositionPlayerTask, mediaItemsWithStartPosition);
            }
        }), new SessionResult(0));
    }

    public static /* synthetic */ p5.c0 lambda$handleMediaItemsWithStartPositionWhenReady$9(SessionTask sessionTask, MediaItemsWithStartPositionPlayerTask mediaItemsWithStartPositionPlayerTask, MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
        return mediaSessionImpl.isReleased() ? com.google.common.util.concurrent.l.m(new SessionResult(-100)) : Util.transformFutureAsync((p5.c0) sessionTask.run(mediaSessionImpl, controllerInfo, i10), new p5.f() { // from class: androidx.media3.session.xa

            /* renamed from: b */
            public final /* synthetic */ MediaSession.ControllerInfo f1025b;

            /* renamed from: c */
            public final /* synthetic */ MediaSessionStub.MediaItemsWithStartPositionPlayerTask f1026c;

            public /* synthetic */ xa(MediaSession.ControllerInfo controllerInfo2, MediaSessionStub.MediaItemsWithStartPositionPlayerTask mediaItemsWithStartPositionPlayerTask2) {
                controllerInfo = controllerInfo2;
                mediaItemsWithStartPositionPlayerTask = mediaItemsWithStartPositionPlayerTask2;
            }

            @Override // p5.f
            public final p5.c0 apply(Object obj) {
                p5.c0 lambda$handleMediaItemsWithStartPositionWhenReady$8;
                lambda$handleMediaItemsWithStartPositionWhenReady$8 = MediaSessionStub.lambda$handleMediaItemsWithStartPositionWhenReady$8(MediaSessionImpl.this, controllerInfo, mediaItemsWithStartPositionPlayerTask, (MediaSession.MediaItemsWithStartPosition) obj);
                return lambda$handleMediaItemsWithStartPositionWhenReady$8;
            }
        });
    }

    public static /* synthetic */ void lambda$handleSessionTaskWhenReady$16(MediaSessionImpl mediaSessionImpl, com.google.common.util.concurrent.s sVar, Consumer consumer, p5.c0 c0Var) {
        if (mediaSessionImpl.isReleased()) {
            sVar.set(null);
            return;
        }
        try {
            consumer.accept(c0Var);
            sVar.set(null);
        } catch (Throwable th2) {
            sVar.setException(th2);
        }
    }

    public static /* synthetic */ p5.c0 lambda$onCustomCommand$25(SessionCommand sessionCommand, Bundle bundle, MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
        return mediaSessionImpl.onCustomCommandOnHandler(controllerInfo, sessionCommand, bundle);
    }

    public /* synthetic */ void lambda$play$20(MediaSession.ControllerInfo controllerInfo, PlayerWrapper playerWrapper) {
        MediaSessionImpl mediaSessionImpl = this.sessionImpl.get();
        if (mediaSessionImpl == null || mediaSessionImpl.isReleased() || !mediaSessionImpl.onPlayRequested()) {
            return;
        }
        if (playerWrapper.getMediaItemCount() == 0) {
            mediaSessionImpl.prepareAndPlayForPlaybackResumption(controllerInfo, playerWrapper);
        } else {
            Util.handlePlayButtonAction(playerWrapper);
        }
    }

    public static /* synthetic */ p5.c0 lambda$queueSessionTaskWithPlayerCommand$13(SessionTask sessionTask, MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
        return (p5.c0) sessionTask.run(mediaSessionImpl, controllerInfo, i10);
    }

    public /* synthetic */ void lambda$queueSessionTaskWithPlayerCommand$14(MediaSession.ControllerInfo controllerInfo, int i10, int i11, MediaSessionImpl mediaSessionImpl, SessionTask sessionTask) {
        if (!this.connectedControllersManager.isPlayerCommandAvailable(controllerInfo, i10)) {
            sendSessionResult(controllerInfo, i11, new SessionResult(-4));
            return;
        }
        int onPlayerCommandRequestOnHandler = mediaSessionImpl.onPlayerCommandRequestOnHandler(controllerInfo, i10);
        if (onPlayerCommandRequestOnHandler != 0) {
            sendSessionResult(controllerInfo, i11, new SessionResult(onPlayerCommandRequestOnHandler));
        } else if (i10 == 27) {
            mediaSessionImpl.callWithControllerForCurrentRequestSet(controllerInfo, new Runnable() { // from class: androidx.media3.session.xc

                /* renamed from: c */
                public final /* synthetic */ MediaSessionImpl f1030c;

                /* renamed from: d */
                public final /* synthetic */ MediaSession.ControllerInfo f1031d;

                /* renamed from: e */
                public final /* synthetic */ int f1032e;

                public /* synthetic */ xc(MediaSessionImpl mediaSessionImpl2, MediaSession.ControllerInfo controllerInfo2, int i112) {
                    mediaSessionImpl = mediaSessionImpl2;
                    controllerInfo = controllerInfo2;
                    i11 = i112;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MediaSessionStub.SessionTask.this.run(mediaSessionImpl, controllerInfo, i11);
                }
            }).run();
        } else {
            this.connectedControllersManager.addToCommandQueue(controllerInfo2, new ConnectedControllersManager.AsyncCommand() { // from class: androidx.media3.session.yc

                /* renamed from: b */
                public final /* synthetic */ MediaSessionImpl f1059b;

                /* renamed from: c */
                public final /* synthetic */ MediaSession.ControllerInfo f1060c;

                /* renamed from: d */
                public final /* synthetic */ int f1061d;

                public /* synthetic */ yc(MediaSessionImpl mediaSessionImpl2, MediaSession.ControllerInfo controllerInfo2, int i112) {
                    mediaSessionImpl = mediaSessionImpl2;
                    controllerInfo = controllerInfo2;
                    i11 = i112;
                }

                @Override // androidx.media3.session.ConnectedControllersManager.AsyncCommand
                public final p5.c0 run() {
                    p5.c0 lambda$queueSessionTaskWithPlayerCommand$13;
                    lambda$queueSessionTaskWithPlayerCommand$13 = MediaSessionStub.lambda$queueSessionTaskWithPlayerCommand$13(MediaSessionStub.SessionTask.this, mediaSessionImpl, controllerInfo, i11);
                    return lambda$queueSessionTaskWithPlayerCommand$13;
                }
            });
        }
    }

    public /* synthetic */ void lambda$release$19(IMediaController iMediaController) {
        this.connectedControllersManager.removeController((ConnectedControllersManager<IBinder>) iMediaController.asBinder());
    }

    public /* synthetic */ void lambda$removeMediaItem$43(int i10, PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo) {
        playerWrapper.removeMediaItem(maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i10));
    }

    public /* synthetic */ void lambda$removeMediaItems$44(int i10, int i11, PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo) {
        playerWrapper.removeMediaItems(maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i10), maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i11));
    }

    public static /* synthetic */ p5.c0 lambda$replaceMediaItem$47(MediaItem mediaItem, MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
        return mediaSessionImpl.onAddMediaItemsOnHandler(controllerInfo, ImmutableList.of(mediaItem));
    }

    public /* synthetic */ void lambda$replaceMediaItem$48(int i10, PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list) {
        if (list.size() == 1) {
            playerWrapper.replaceMediaItem(maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i10), (MediaItem) list.get(0));
        } else {
            playerWrapper.replaceMediaItems(maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i10), maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i10 + 1), list);
        }
    }

    public static /* synthetic */ p5.c0 lambda$replaceMediaItems$49(ImmutableList immutableList, MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
        return mediaSessionImpl.onAddMediaItemsOnHandler(controllerInfo, immutableList);
    }

    public /* synthetic */ void lambda$replaceMediaItems$50(int i10, int i11, PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list) {
        playerWrapper.replaceMediaItems(maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i10), maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i11), list);
    }

    public static /* synthetic */ p5.c0 lambda$search$69(String str, MediaLibraryService.LibraryParams libraryParams, MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
        return mediaLibrarySessionImpl.onSearchOnHandler(controllerInfo, str, libraryParams);
    }

    public /* synthetic */ void lambda$seekToDefaultPositionWithMediaItemIndex$22(int i10, PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo) {
        playerWrapper.seekToDefaultPosition(maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i10));
    }

    public /* synthetic */ void lambda$seekToWithMediaItemIndex$24(int i10, long j10, PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo) {
        playerWrapper.seekTo(maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i10), j10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void lambda$sendLibraryResultWhenReady$10(MediaSession.ControllerInfo controllerInfo, int i10, p5.c0 c0Var) {
        LibraryResult ofError;
        try {
            ofError = (LibraryResult) Assertions.checkNotNull((LibraryResult) c0Var.get(), "LibraryResult must not be null");
        } catch (InterruptedException e10) {
            e = e10;
            Log.w(TAG, "Library operation failed", e);
            ofError = LibraryResult.ofError(-1);
        } catch (CancellationException e11) {
            Log.w(TAG, "Library operation cancelled", e11);
            ofError = LibraryResult.ofError(1);
        } catch (ExecutionException e12) {
            e = e12;
            Log.w(TAG, "Library operation failed", e);
            ofError = LibraryResult.ofError(-1);
        }
        sendLibraryResult(controllerInfo, i10, ofError);
    }

    public static /* synthetic */ p5.c0 lambda$sendLibraryResultWhenReady$11(SessionTask sessionTask, MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
        return handleSessionTaskWhenReady(mediaLibrarySessionImpl, controllerInfo, i10, sessionTask, new Consumer() { // from class: androidx.media3.session.za

            /* renamed from: b */
            public final /* synthetic */ int f1081b;

            public /* synthetic */ za(int i102) {
                i10 = i102;
            }

            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                MediaSessionStub.lambda$sendLibraryResultWhenReady$10(MediaSession.ControllerInfo.this, i10, (p5.c0) obj);
            }
        });
    }

    public static /* synthetic */ p5.c0 lambda$sendSessionResultSuccess$1(ControllerPlayerTask controllerPlayerTask, MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
        if (mediaSessionImpl.isReleased()) {
            return com.google.common.util.concurrent.l.n();
        }
        controllerPlayerTask.run(mediaSessionImpl.getPlayerWrapper(), controllerInfo);
        sendSessionResult(controllerInfo, i10, new SessionResult(0));
        return com.google.common.util.concurrent.l.n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void lambda$sendSessionResultWhenReady$2(androidx.media3.session.MediaSession.ControllerInfo r2, int r3, p5.c0 r4) {
        /*
            java.lang.String r0 = "MediaSessionStub"
            java.lang.Object r4 = r4.get()     // Catch: java.lang.InterruptedException -> L11 java.util.concurrent.ExecutionException -> L13 java.util.concurrent.CancellationException -> L15
            androidx.media3.session.SessionResult r4 = (androidx.media3.session.SessionResult) r4     // Catch: java.lang.InterruptedException -> L11 java.util.concurrent.ExecutionException -> L13 java.util.concurrent.CancellationException -> L15
            java.lang.String r1 = "SessionResult must not be null"
            java.lang.Object r4 = androidx.media3.common.util.Assertions.checkNotNull(r4, r1)     // Catch: java.lang.InterruptedException -> L11 java.util.concurrent.ExecutionException -> L13 java.util.concurrent.CancellationException -> L15
            androidx.media3.session.SessionResult r4 = (androidx.media3.session.SessionResult) r4     // Catch: java.lang.InterruptedException -> L11 java.util.concurrent.ExecutionException -> L13 java.util.concurrent.CancellationException -> L15
            goto L39
        L11:
            r4 = move-exception
            goto L17
        L13:
            r4 = move-exception
            goto L17
        L15:
            r4 = move-exception
            goto L2e
        L17:
            java.lang.String r1 = "Session operation failed"
            androidx.media3.common.util.Log.w(r0, r1, r4)
            androidx.media3.session.SessionResult r0 = new androidx.media3.session.SessionResult
            java.lang.Throwable r4 = r4.getCause()
            boolean r4 = r4 instanceof java.lang.UnsupportedOperationException
            if (r4 == 0) goto L28
            r4 = -6
            goto L29
        L28:
            r4 = -1
        L29:
            r0.<init>(r4)
            r4 = r0
            goto L39
        L2e:
            java.lang.String r1 = "Session operation cancelled"
            androidx.media3.common.util.Log.w(r0, r1, r4)
            androidx.media3.session.SessionResult r4 = new androidx.media3.session.SessionResult
            r0 = 1
            r4.<init>(r0)
        L39:
            sendSessionResult(r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.MediaSessionStub.lambda$sendSessionResultWhenReady$2(androidx.media3.session.MediaSession$ControllerInfo, int, p5.c0):void");
    }

    public static /* synthetic */ p5.c0 lambda$sendSessionResultWhenReady$3(SessionTask sessionTask, MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
        return handleSessionTaskWhenReady(mediaSessionImpl, controllerInfo, i10, sessionTask, new Consumer() { // from class: androidx.media3.session.id

            /* renamed from: b */
            public final /* synthetic */ int f638b;

            public /* synthetic */ id(int i102) {
                i10 = i102;
            }

            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                MediaSessionStub.lambda$sendSessionResultWhenReady$2(MediaSession.ControllerInfo.this, i10, (p5.c0) obj);
            }
        });
    }

    public static /* synthetic */ p5.c0 lambda$setMediaItemWithResetPosition$31(MediaItem mediaItem, boolean z10, MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
        return mediaSessionImpl.onSetMediaItemsOnHandler(controllerInfo, ImmutableList.of(mediaItem), z10 ? -1 : mediaSessionImpl.getPlayerWrapper().getCurrentMediaItemIndex(), z10 ? C.TIME_UNSET : mediaSessionImpl.getPlayerWrapper().getCurrentPosition());
    }

    public static /* synthetic */ p5.c0 lambda$setMediaItemWithStartPosition$30(MediaItem mediaItem, long j10, MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
        return mediaSessionImpl.onSetMediaItemsOnHandler(controllerInfo, ImmutableList.of(mediaItem), 0, j10);
    }

    public static /* synthetic */ p5.c0 lambda$setMediaItemsWithResetPosition$32(List list, boolean z10, MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
        return mediaSessionImpl.onSetMediaItemsOnHandler(controllerInfo, list, z10 ? -1 : mediaSessionImpl.getPlayerWrapper().getCurrentMediaItemIndex(), z10 ? C.TIME_UNSET : mediaSessionImpl.getPlayerWrapper().getCurrentPosition());
    }

    public static /* synthetic */ p5.c0 lambda$setMediaItemsWithStartIndex$33(List list, int i10, long j10, MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i11) {
        int currentMediaItemIndex = i10 == -1 ? mediaSessionImpl.getPlayerWrapper().getCurrentMediaItemIndex() : i10;
        if (i10 == -1) {
            j10 = mediaSessionImpl.getPlayerWrapper().getCurrentPosition();
        }
        return mediaSessionImpl.onSetMediaItemsOnHandler(controllerInfo, list, currentMediaItemIndex, j10);
    }

    public static /* synthetic */ p5.c0 lambda$setRating$27(Rating rating, MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
        return mediaSessionImpl.onSetRatingOnHandler(controllerInfo, rating);
    }

    public static /* synthetic */ p5.c0 lambda$setRatingWithMediaId$26(String str, Rating rating, MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
        return mediaSessionImpl.onSetRatingOnHandler(controllerInfo, str, rating);
    }

    public /* synthetic */ void lambda$setTrackSelectionParameters$65(TrackSelectionParameters trackSelectionParameters, PlayerWrapper playerWrapper) {
        playerWrapper.setTrackSelectionParameters(updateOverridesUsingUniqueTrackGroupIds(trackSelectionParameters));
    }

    public static /* synthetic */ p5.c0 lambda$subscribe$71(String str, MediaLibraryService.LibraryParams libraryParams, MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
        return mediaLibrarySessionImpl.onSubscribeOnHandler(controllerInfo, str, libraryParams);
    }

    public static /* synthetic */ p5.c0 lambda$unsubscribe$72(String str, MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
        return mediaLibrarySessionImpl.onUnsubscribeOnHandler(controllerInfo, str);
    }

    private int maybeCorrectMediaItemIndex(MediaSession.ControllerInfo controllerInfo, PlayerWrapper playerWrapper, int i10) {
        return (playerWrapper.isCommandAvailable(17) && !this.connectedControllersManager.isPlayerCommandAvailable(controllerInfo, 17) && this.connectedControllersManager.isPlayerCommandAvailable(controllerInfo, 16)) ? i10 + playerWrapper.getCurrentMediaItemIndex() : i10;
    }

    private <K extends MediaSessionImpl> void queueSessionTaskWithPlayerCommand(IMediaController iMediaController, int i10, int i11, SessionTask<p5.c0<Void>, K> sessionTask) {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaSessionImpl mediaSessionImpl = this.sessionImpl.get();
            if (mediaSessionImpl != null && !mediaSessionImpl.isReleased()) {
                MediaSession.ControllerInfo controller = this.connectedControllersManager.getController(iMediaController.asBinder());
                if (controller == null) {
                    return;
                }
                Util.postOrRun(mediaSessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.dd

                    /* renamed from: c */
                    public final /* synthetic */ MediaSession.ControllerInfo f489c;

                    /* renamed from: d */
                    public final /* synthetic */ int f490d;

                    /* renamed from: e */
                    public final /* synthetic */ int f491e;

                    /* renamed from: f */
                    public final /* synthetic */ MediaSessionImpl f492f;

                    /* renamed from: g */
                    public final /* synthetic */ MediaSessionStub.SessionTask f493g;

                    public /* synthetic */ dd(MediaSession.ControllerInfo controller2, int i112, int i102, MediaSessionImpl mediaSessionImpl2, MediaSessionStub.SessionTask sessionTask2) {
                        controller = controller2;
                        i11 = i112;
                        i10 = i102;
                        mediaSessionImpl = mediaSessionImpl2;
                        sessionTask = sessionTask2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaSessionStub.this.lambda$queueSessionTaskWithPlayerCommand$14(controller, i11, i10, mediaSessionImpl, sessionTask);
                    }
                });
            }
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    private static void sendLibraryResult(MediaSession.ControllerInfo controllerInfo, int i10, LibraryResult<?> libraryResult) {
        try {
            ((MediaSession.ControllerCb) Assertions.checkStateNotNull(controllerInfo.getControllerCb())).onLibraryResult(i10, libraryResult);
        } catch (RemoteException e10) {
            Log.w(TAG, "Failed to send result to browser " + controllerInfo, e10);
        }
    }

    private static <V, K extends MediaLibrarySessionImpl> SessionTask<p5.c0<Void>, K> sendLibraryResultWhenReady(SessionTask<p5.c0<LibraryResult<V>>, K> sessionTask) {
        return new SessionTask() { // from class: androidx.media3.session.zc
            public /* synthetic */ zc() {
            }

            @Override // androidx.media3.session.MediaSessionStub.SessionTask
            public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
                p5.c0 lambda$sendLibraryResultWhenReady$11;
                lambda$sendLibraryResultWhenReady$11 = MediaSessionStub.lambda$sendLibraryResultWhenReady$11(MediaSessionStub.SessionTask.this, (MediaLibrarySessionImpl) mediaSessionImpl, controllerInfo, i10);
                return lambda$sendLibraryResultWhenReady$11;
            }
        };
    }

    private static void sendSessionResult(MediaSession.ControllerInfo controllerInfo, int i10, SessionResult sessionResult) {
        try {
            ((MediaSession.ControllerCb) Assertions.checkStateNotNull(controllerInfo.getControllerCb())).onSessionResult(i10, sessionResult);
        } catch (RemoteException e10) {
            Log.w(TAG, "Failed to send result to controller " + controllerInfo, e10);
        }
    }

    private static <K extends MediaSessionImpl> SessionTask<p5.c0<Void>, K> sendSessionResultSuccess(Consumer<PlayerWrapper> consumer) {
        return sendSessionResultSuccess(new ControllerPlayerTask() { // from class: androidx.media3.session.wc
            public /* synthetic */ wc() {
            }

            @Override // androidx.media3.session.MediaSessionStub.ControllerPlayerTask
            public final void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo) {
                Consumer.this.accept(playerWrapper);
            }
        });
    }

    private static <K extends MediaSessionImpl> SessionTask<p5.c0<Void>, K> sendSessionResultWhenReady(SessionTask<p5.c0<SessionResult>, K> sessionTask) {
        return new SessionTask() { // from class: androidx.media3.session.ad
            public /* synthetic */ ad() {
            }

            @Override // androidx.media3.session.MediaSessionStub.SessionTask
            public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
                p5.c0 lambda$sendSessionResultWhenReady$3;
                lambda$sendSessionResultWhenReady$3 = MediaSessionStub.lambda$sendSessionResultWhenReady$3(MediaSessionStub.SessionTask.this, mediaSessionImpl, controllerInfo, i10);
                return lambda$sendSessionResultWhenReady$3;
            }
        };
    }

    private TrackSelectionParameters updateOverridesUsingUniqueTrackGroupIds(TrackSelectionParameters trackSelectionParameters) {
        if (trackSelectionParameters.overrides.isEmpty()) {
            return trackSelectionParameters;
        }
        TrackSelectionParameters.Builder clearOverrides = trackSelectionParameters.buildUpon().clearOverrides();
        e5.z1<TrackSelectionOverride> it = trackSelectionParameters.overrides.values().iterator();
        while (it.hasNext()) {
            TrackSelectionOverride next = it.next();
            TrackGroup trackGroup = this.trackGroupIdMap.inverse().get(next.mediaTrackGroup.f376id);
            if (trackGroup == null || next.mediaTrackGroup.length != trackGroup.length) {
                clearOverrides.addOverride(next);
            } else {
                clearOverrides.addOverride(new TrackSelectionOverride(trackGroup, next.trackIndices));
            }
        }
        return clearOverrides.build();
    }

    @Override // androidx.media3.session.IMediaSession
    public void addMediaItem(@Nullable IMediaController iMediaController, int i10, Bundle bundle) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            queueSessionTaskWithPlayerCommand(iMediaController, i10, 20, sendSessionResultWhenReady(handleMediaItemsWhenReady(new SessionTask() { // from class: androidx.media3.session.lc
                public /* synthetic */ lc() {
                }

                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i11) {
                    p5.c0 lambda$addMediaItem$35;
                    lambda$addMediaItem$35 = MediaSessionStub.lambda$addMediaItem$35(MediaItem.this, mediaSessionImpl, controllerInfo, i11);
                    return lambda$addMediaItem$35;
                }
            }, new MediaItemPlayerTask() { // from class: androidx.media3.session.mc
                @Override // androidx.media3.session.MediaSessionStub.MediaItemPlayerTask
                public final void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list) {
                    playerWrapper.addMediaItems(list);
                }
            })));
        } catch (RuntimeException e10) {
            Log.w(TAG, "Ignoring malformed Bundle for MediaItem", e10);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void addMediaItemWithIndex(@Nullable IMediaController iMediaController, int i10, int i11, Bundle bundle) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            queueSessionTaskWithPlayerCommand(iMediaController, i10, 20, sendSessionResultWhenReady(handleMediaItemsWhenReady(new SessionTask() { // from class: androidx.media3.session.db
                public /* synthetic */ db() {
                }

                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i12) {
                    p5.c0 lambda$addMediaItemWithIndex$37;
                    lambda$addMediaItemWithIndex$37 = MediaSessionStub.lambda$addMediaItemWithIndex$37(MediaItem.this, mediaSessionImpl, controllerInfo, i12);
                    return lambda$addMediaItemWithIndex$37;
                }
            }, new MediaItemPlayerTask() { // from class: androidx.media3.session.eb

                /* renamed from: b */
                public final /* synthetic */ int f516b;

                public /* synthetic */ eb(int i112) {
                    i11 = i112;
                }

                @Override // androidx.media3.session.MediaSessionStub.MediaItemPlayerTask
                public final void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list) {
                    MediaSessionStub.this.lambda$addMediaItemWithIndex$38(i11, playerWrapper, controllerInfo, list);
                }
            })));
        } catch (RuntimeException e10) {
            Log.w(TAG, "Ignoring malformed Bundle for MediaItem", e10);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void addMediaItems(@Nullable IMediaController iMediaController, int i10, @Nullable IBinder iBinder) {
        if (iMediaController == null || iBinder == null) {
            return;
        }
        try {
            queueSessionTaskWithPlayerCommand(iMediaController, i10, 20, sendSessionResultWhenReady(handleMediaItemsWhenReady(new SessionTask() { // from class: androidx.media3.session.jc

                /* renamed from: a */
                public final /* synthetic */ List f667a;

                public /* synthetic */ jc(List list) {
                    fromBundleList = list;
                }

                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i11) {
                    p5.c0 lambda$addMediaItems$39;
                    lambda$addMediaItems$39 = MediaSessionStub.lambda$addMediaItems$39(fromBundleList, mediaSessionImpl, controllerInfo, i11);
                    return lambda$addMediaItems$39;
                }
            }, new MediaItemPlayerTask() { // from class: androidx.media3.session.kc
                @Override // androidx.media3.session.MediaSessionStub.MediaItemPlayerTask
                public final void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list) {
                    playerWrapper.addMediaItems(list);
                }
            })));
        } catch (RuntimeException e10) {
            Log.w(TAG, "Ignoring malformed Bundle for MediaItem", e10);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void addMediaItemsWithIndex(@Nullable IMediaController iMediaController, int i10, int i11, @Nullable IBinder iBinder) {
        if (iMediaController == null || iBinder == null) {
            return;
        }
        try {
            queueSessionTaskWithPlayerCommand(iMediaController, i10, 20, sendSessionResultWhenReady(handleMediaItemsWhenReady(new SessionTask() { // from class: androidx.media3.session.qb

                /* renamed from: a */
                public final /* synthetic */ List f860a;

                public /* synthetic */ qb(List list) {
                    fromBundleList = list;
                }

                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i12) {
                    p5.c0 lambda$addMediaItemsWithIndex$41;
                    lambda$addMediaItemsWithIndex$41 = MediaSessionStub.lambda$addMediaItemsWithIndex$41(fromBundleList, mediaSessionImpl, controllerInfo, i12);
                    return lambda$addMediaItemsWithIndex$41;
                }
            }, new MediaItemPlayerTask() { // from class: androidx.media3.session.rb

                /* renamed from: b */
                public final /* synthetic */ int f886b;

                public /* synthetic */ rb(int i112) {
                    i11 = i112;
                }

                @Override // androidx.media3.session.MediaSessionStub.MediaItemPlayerTask
                public final void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list) {
                    MediaSessionStub.this.lambda$addMediaItemsWithIndex$42(i11, playerWrapper, controllerInfo, list);
                }
            })));
        } catch (RuntimeException e10) {
            Log.w(TAG, "Ignoring malformed Bundle for MediaItem", e10);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void clearMediaItems(@Nullable IMediaController iMediaController, int i10) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 20, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.pd
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).clearMediaItems();
            }
        }));
    }

    public void connect(IMediaController iMediaController, int i10, int i11, String str, int i12, int i13, Bundle bundle) {
        MediaSessionManager.RemoteUserInfo remoteUserInfo = new MediaSessionManager.RemoteUserInfo(str, i12, i13);
        MediaSession.ControllerInfo controllerInfo = new MediaSession.ControllerInfo(remoteUserInfo, i10, i11, this.sessionManager.isTrustedForMediaControl(remoteUserInfo), new Controller2Cb(iMediaController), bundle);
        MediaSessionImpl mediaSessionImpl = this.sessionImpl.get();
        if (mediaSessionImpl == null || mediaSessionImpl.isReleased()) {
            try {
                iMediaController.onDisconnected(0);
            } catch (RemoteException unused) {
            }
        } else {
            this.pendingControllers.add(controllerInfo);
            Util.postOrRun(mediaSessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.gb

                /* renamed from: c */
                public final /* synthetic */ MediaSession.ControllerInfo f575c;

                /* renamed from: d */
                public final /* synthetic */ MediaSessionImpl f576d;

                /* renamed from: e */
                public final /* synthetic */ IMediaController f577e;

                public /* synthetic */ gb(MediaSession.ControllerInfo controllerInfo2, MediaSessionImpl mediaSessionImpl2, IMediaController iMediaController2) {
                    controllerInfo = controllerInfo2;
                    mediaSessionImpl = mediaSessionImpl2;
                    iMediaController = iMediaController2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MediaSessionStub.this.lambda$connect$17(controllerInfo, mediaSessionImpl, iMediaController);
                }
            });
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void decreaseDeviceVolume(@Nullable IMediaController iMediaController, int i10) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 26, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.gc
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).decreaseDeviceVolume();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void decreaseDeviceVolumeWithFlags(@Nullable IMediaController iMediaController, int i10, int i11) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 34, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.vb

            /* renamed from: a */
            public final /* synthetic */ int f986a;

            public /* synthetic */ vb(int i112) {
                i11 = i112;
            }

            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).decreaseDeviceVolume(i11);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void flushCommandQueue(@Nullable IMediaController iMediaController) {
        if (iMediaController == null) {
            return;
        }
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaSessionImpl mediaSessionImpl = this.sessionImpl.get();
            if (mediaSessionImpl != null && !mediaSessionImpl.isReleased()) {
                MediaSession.ControllerInfo controller = this.connectedControllersManager.getController(iMediaController.asBinder());
                if (controller != null) {
                    Util.postOrRun(mediaSessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.xb

                        /* renamed from: c */
                        public final /* synthetic */ MediaSession.ControllerInfo f1028c;

                        public /* synthetic */ xb(MediaSession.ControllerInfo controller2) {
                            controller = controller2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            MediaSessionStub.this.lambda$flushCommandQueue$64(controller);
                        }
                    });
                }
            }
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    public PlayerInfo generateAndCacheUniqueTrackGroupIds(PlayerInfo playerInfo) {
        ImmutableList<Tracks.Group> groups = playerInfo.currentTracks.getGroups();
        ImmutableList.a builder = ImmutableList.builder();
        ImmutableBiMap.a builder2 = ImmutableBiMap.builder();
        for (int i10 = 0; i10 < groups.size(); i10++) {
            Tracks.Group group = groups.get(i10);
            TrackGroup mediaTrackGroup = group.getMediaTrackGroup();
            String str = this.trackGroupIdMap.get(mediaTrackGroup);
            if (str == null) {
                str = generateUniqueTrackGroupId(mediaTrackGroup);
            }
            builder2.i(mediaTrackGroup, str);
            builder.a(group.copyWithId(str));
        }
        this.trackGroupIdMap = builder2.d();
        PlayerInfo copyWithCurrentTracks = playerInfo.copyWithCurrentTracks(new Tracks(builder.e()));
        if (copyWithCurrentTracks.trackSelectionParameters.overrides.isEmpty()) {
            return copyWithCurrentTracks;
        }
        TrackSelectionParameters.Builder clearOverrides = copyWithCurrentTracks.trackSelectionParameters.buildUpon().clearOverrides();
        e5.z1<TrackSelectionOverride> it = copyWithCurrentTracks.trackSelectionParameters.overrides.values().iterator();
        while (it.hasNext()) {
            TrackSelectionOverride next = it.next();
            TrackGroup trackGroup = next.mediaTrackGroup;
            String str2 = this.trackGroupIdMap.get(trackGroup);
            if (str2 != null) {
                clearOverrides.addOverride(new TrackSelectionOverride(trackGroup.copyWithId(str2), next.trackIndices));
            } else {
                clearOverrides.addOverride(next);
            }
        }
        return copyWithCurrentTracks.copyWithTrackSelectionParameters(clearOverrides.build());
    }

    @Override // androidx.media3.session.IMediaSession
    public void getChildren(@Nullable IMediaController iMediaController, int i10, String str, int i11, int i12, @Nullable Bundle bundle) throws RuntimeException {
        if (iMediaController == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "getChildren(): Ignoring empty parentId");
            return;
        }
        if (i11 < 0) {
            Log.w(TAG, "getChildren(): Ignoring negative page");
        } else if (i12 < 1) {
            Log.w(TAG, "getChildren(): Ignoring pageSize less than 1");
        } else {
            dispatchSessionTaskWithSessionCommand(iMediaController, i10, SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, sendLibraryResultWhenReady(new SessionTask() { // from class: androidx.media3.session.ra

                /* renamed from: a */
                public final /* synthetic */ String f881a;

                /* renamed from: b */
                public final /* synthetic */ int f882b;

                /* renamed from: c */
                public final /* synthetic */ int f883c;

                /* renamed from: d */
                public final /* synthetic */ MediaLibraryService.LibraryParams f884d;

                public /* synthetic */ ra(String str2, int i112, int i122, MediaLibraryService.LibraryParams libraryParams) {
                    str = str2;
                    i11 = i112;
                    i12 = i122;
                    fromBundle = libraryParams;
                }

                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i13) {
                    p5.c0 lambda$getChildren$68;
                    lambda$getChildren$68 = MediaSessionStub.lambda$getChildren$68(str, i11, i12, fromBundle, (MediaLibrarySessionImpl) mediaSessionImpl, controllerInfo, i13);
                    return lambda$getChildren$68;
                }
            }));
        }
    }

    public ConnectedControllersManager<IBinder> getConnectedControllersManager() {
        return this.connectedControllersManager;
    }

    @Override // androidx.media3.session.IMediaSession
    public void getItem(@Nullable IMediaController iMediaController, int i10, @Nullable String str) throws RuntimeException {
        if (iMediaController == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "getItem(): Ignoring empty mediaId");
        } else {
            dispatchSessionTaskWithSessionCommand(iMediaController, i10, SessionCommand.COMMAND_CODE_LIBRARY_GET_ITEM, sendLibraryResultWhenReady(new SessionTask() { // from class: androidx.media3.session.bc

                /* renamed from: a */
                public final /* synthetic */ String f436a;

                public /* synthetic */ bc(String str2) {
                    str = str2;
                }

                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i11) {
                    p5.c0 lambda$getItem$67;
                    lambda$getItem$67 = MediaSessionStub.lambda$getItem$67(str, (MediaLibrarySessionImpl) mediaSessionImpl, controllerInfo, i11);
                    return lambda$getItem$67;
                }
            }));
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void getLibraryRoot(@Nullable IMediaController iMediaController, int i10, @Nullable Bundle bundle) throws RuntimeException {
        if (iMediaController == null) {
            return;
        }
        dispatchSessionTaskWithSessionCommand(iMediaController, i10, SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, sendLibraryResultWhenReady(new SessionTask() { // from class: androidx.media3.session.uc
            public /* synthetic */ uc() {
            }

            @Override // androidx.media3.session.MediaSessionStub.SessionTask
            public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i11) {
                p5.c0 lambda$getLibraryRoot$66;
                lambda$getLibraryRoot$66 = MediaSessionStub.lambda$getLibraryRoot$66(MediaLibraryService.LibraryParams.this, (MediaLibrarySessionImpl) mediaSessionImpl, controllerInfo, i11);
                return lambda$getLibraryRoot$66;
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void getSearchResult(@Nullable IMediaController iMediaController, int i10, String str, int i11, int i12, @Nullable Bundle bundle) {
        if (iMediaController == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "getSearchResult(): Ignoring empty query");
            return;
        }
        if (i11 < 0) {
            Log.w(TAG, "getSearchResult(): Ignoring negative page");
        } else if (i12 < 1) {
            Log.w(TAG, "getSearchResult(): Ignoring pageSize less than 1");
        } else {
            dispatchSessionTaskWithSessionCommand(iMediaController, i10, SessionCommand.COMMAND_CODE_LIBRARY_GET_SEARCH_RESULT, sendLibraryResultWhenReady(new SessionTask() { // from class: androidx.media3.session.nc

                /* renamed from: a */
                public final /* synthetic */ String f790a;

                /* renamed from: b */
                public final /* synthetic */ int f791b;

                /* renamed from: c */
                public final /* synthetic */ int f792c;

                /* renamed from: d */
                public final /* synthetic */ MediaLibraryService.LibraryParams f793d;

                public /* synthetic */ nc(String str2, int i112, int i122, MediaLibraryService.LibraryParams libraryParams) {
                    str = str2;
                    i11 = i112;
                    i12 = i122;
                    fromBundle = libraryParams;
                }

                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i13) {
                    p5.c0 lambda$getSearchResult$70;
                    lambda$getSearchResult$70 = MediaSessionStub.lambda$getSearchResult$70(str, i11, i12, fromBundle, (MediaLibrarySessionImpl) mediaSessionImpl, controllerInfo, i13);
                    return lambda$getSearchResult$70;
                }
            }));
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void increaseDeviceVolume(@Nullable IMediaController iMediaController, int i10) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 26, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.ib
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).increaseDeviceVolume();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void increaseDeviceVolumeWithFlags(@Nullable IMediaController iMediaController, int i10, int i11) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 34, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.sb

            /* renamed from: a */
            public final /* synthetic */ int f904a;

            public /* synthetic */ sb(int i112) {
                i11 = i112;
            }

            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).increaseDeviceVolume(i11);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void moveMediaItem(@Nullable IMediaController iMediaController, int i10, int i11, int i12) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 20, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.hd

            /* renamed from: a */
            public final /* synthetic */ int f610a;

            /* renamed from: b */
            public final /* synthetic */ int f611b;

            public /* synthetic */ hd(int i112, int i122) {
                i11 = i112;
                i12 = i122;
            }

            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).moveMediaItem(i11, i12);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void moveMediaItems(@Nullable IMediaController iMediaController, int i10, int i11, int i12, int i13) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 20, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.zb

            /* renamed from: a */
            public final /* synthetic */ int f1082a;

            /* renamed from: b */
            public final /* synthetic */ int f1083b;

            /* renamed from: c */
            public final /* synthetic */ int f1084c;

            public /* synthetic */ zb(int i112, int i122, int i132) {
                i11 = i112;
                i12 = i122;
                i13 = i132;
            }

            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).moveMediaItems(i11, i12, i13);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void onControllerResult(@Nullable IMediaController iMediaController, int i10, @Nullable Bundle bundle) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            SessionResult fromBundle = SessionResult.CREATOR.fromBundle(bundle);
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                SequencedFutureManager sequencedFutureManager = this.connectedControllersManager.getSequencedFutureManager((ConnectedControllersManager<IBinder>) iMediaController.asBinder());
                if (sequencedFutureManager == null) {
                    return;
                }
                sequencedFutureManager.setFutureResult(i10, fromBundle);
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        } catch (RuntimeException e10) {
            Log.w(TAG, "Ignoring malformed Bundle for SessionResult", e10);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void onCustomCommand(@Nullable IMediaController iMediaController, int i10, @Nullable Bundle bundle, @Nullable Bundle bundle2) {
        if (iMediaController == null || bundle == null || bundle2 == null) {
            return;
        }
        try {
            SessionCommand fromBundle = SessionCommand.CREATOR.fromBundle(bundle);
            dispatchSessionTaskWithSessionCommand(iMediaController, i10, fromBundle, sendSessionResultWhenReady(new SessionTask() { // from class: androidx.media3.session.nb

                /* renamed from: b */
                public final /* synthetic */ Bundle f789b;

                public /* synthetic */ nb(Bundle bundle22) {
                    bundle2 = bundle22;
                }

                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i11) {
                    p5.c0 lambda$onCustomCommand$25;
                    lambda$onCustomCommand$25 = MediaSessionStub.lambda$onCustomCommand$25(SessionCommand.this, bundle2, mediaSessionImpl, controllerInfo, i11);
                    return lambda$onCustomCommand$25;
                }
            }));
        } catch (RuntimeException e10) {
            Log.w(TAG, "Ignoring malformed Bundle for SessionCommand", e10);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void pause(@Nullable IMediaController iMediaController, int i10) throws RuntimeException {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 1, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.dc
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).pause();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void play(@Nullable IMediaController iMediaController, int i10) throws RuntimeException {
        MediaSession.ControllerInfo controller;
        if (iMediaController == null || (controller = this.connectedControllersManager.getController(iMediaController.asBinder())) == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 1, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.ub

            /* renamed from: b */
            public final /* synthetic */ MediaSession.ControllerInfo f959b;

            public /* synthetic */ ub(MediaSession.ControllerInfo controller2) {
                controller = controller2;
            }

            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                MediaSessionStub.this.lambda$play$20(controller, (PlayerWrapper) obj);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void prepare(@Nullable IMediaController iMediaController, int i10) throws RuntimeException {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 2, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.vc
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).prepare();
            }
        }));
    }

    public void release() {
        Iterator<MediaSession.ControllerInfo> it = this.connectedControllersManager.getConnectedControllers().iterator();
        while (it.hasNext()) {
            MediaSession.ControllerCb controllerCb = it.next().getControllerCb();
            if (controllerCb != null) {
                try {
                    controllerCb.onDisconnected(0);
                } catch (RemoteException unused) {
                }
            }
        }
        Iterator<MediaSession.ControllerInfo> it2 = this.pendingControllers.iterator();
        while (it2.hasNext()) {
            MediaSession.ControllerCb controllerCb2 = it2.next().getControllerCb();
            if (controllerCb2 != null) {
                try {
                    controllerCb2.onDisconnected(0);
                } catch (RemoteException unused2) {
                }
            }
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void removeMediaItem(@Nullable IMediaController iMediaController, int i10, int i11) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 20, sendSessionResultSuccess(new ControllerPlayerTask() { // from class: androidx.media3.session.cd

            /* renamed from: b */
            public final /* synthetic */ int f462b;

            public /* synthetic */ cd(int i112) {
                i11 = i112;
            }

            @Override // androidx.media3.session.MediaSessionStub.ControllerPlayerTask
            public final void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo) {
                MediaSessionStub.this.lambda$removeMediaItem$43(i11, playerWrapper, controllerInfo);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void removeMediaItems(@Nullable IMediaController iMediaController, int i10, int i11, int i12) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 20, sendSessionResultSuccess(new ControllerPlayerTask() { // from class: androidx.media3.session.oa

            /* renamed from: b */
            public final /* synthetic */ int f813b;

            /* renamed from: c */
            public final /* synthetic */ int f814c;

            public /* synthetic */ oa(int i112, int i122) {
                i11 = i112;
                i12 = i122;
            }

            @Override // androidx.media3.session.MediaSessionStub.ControllerPlayerTask
            public final void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo) {
                MediaSessionStub.this.lambda$removeMediaItems$44(i11, i12, playerWrapper, controllerInfo);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void replaceMediaItem(IMediaController iMediaController, int i10, int i11, Bundle bundle) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            queueSessionTaskWithPlayerCommand(iMediaController, i10, 20, sendSessionResultWhenReady(handleMediaItemsWhenReady(new SessionTask() { // from class: androidx.media3.session.jb
                public /* synthetic */ jb() {
                }

                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i12) {
                    p5.c0 lambda$replaceMediaItem$47;
                    lambda$replaceMediaItem$47 = MediaSessionStub.lambda$replaceMediaItem$47(MediaItem.this, mediaSessionImpl, controllerInfo, i12);
                    return lambda$replaceMediaItem$47;
                }
            }, new MediaItemPlayerTask() { // from class: androidx.media3.session.lb

                /* renamed from: b */
                public final /* synthetic */ int f727b;

                public /* synthetic */ lb(int i112) {
                    i11 = i112;
                }

                @Override // androidx.media3.session.MediaSessionStub.MediaItemPlayerTask
                public final void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list) {
                    MediaSessionStub.this.lambda$replaceMediaItem$48(i11, playerWrapper, controllerInfo, list);
                }
            })));
        } catch (RuntimeException e10) {
            Log.w(TAG, "Ignoring malformed Bundle for MediaItem", e10);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void replaceMediaItems(IMediaController iMediaController, int i10, int i11, int i12, IBinder iBinder) {
        if (iMediaController == null || iBinder == null) {
            return;
        }
        try {
            queueSessionTaskWithPlayerCommand(iMediaController, i10, 20, sendSessionResultWhenReady(handleMediaItemsWhenReady(new SessionTask() { // from class: androidx.media3.session.ta
                public /* synthetic */ ta() {
                }

                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i13) {
                    p5.c0 lambda$replaceMediaItems$49;
                    lambda$replaceMediaItems$49 = MediaSessionStub.lambda$replaceMediaItems$49(ImmutableList.this, mediaSessionImpl, controllerInfo, i13);
                    return lambda$replaceMediaItems$49;
                }
            }, new MediaItemPlayerTask() { // from class: androidx.media3.session.ua

                /* renamed from: b */
                public final /* synthetic */ int f956b;

                /* renamed from: c */
                public final /* synthetic */ int f957c;

                public /* synthetic */ ua(int i112, int i122) {
                    i11 = i112;
                    i12 = i122;
                }

                @Override // androidx.media3.session.MediaSessionStub.MediaItemPlayerTask
                public final void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list) {
                    MediaSessionStub.this.lambda$replaceMediaItems$50(i11, i12, playerWrapper, controllerInfo, list);
                }
            })));
        } catch (RuntimeException e10) {
            Log.w(TAG, "Ignoring malformed Bundle for MediaItem", e10);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void search(@Nullable IMediaController iMediaController, int i10, String str, @Nullable Bundle bundle) {
        if (iMediaController == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "search(): Ignoring empty query");
        } else {
            dispatchSessionTaskWithSessionCommand(iMediaController, i10, SessionCommand.COMMAND_CODE_LIBRARY_SEARCH, sendLibraryResultWhenReady(new SessionTask() { // from class: androidx.media3.session.qd

                /* renamed from: a */
                public final /* synthetic */ String f861a;

                /* renamed from: b */
                public final /* synthetic */ MediaLibraryService.LibraryParams f862b;

                public /* synthetic */ qd(String str2, MediaLibraryService.LibraryParams libraryParams) {
                    str = str2;
                    fromBundle = libraryParams;
                }

                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i11) {
                    p5.c0 lambda$search$69;
                    lambda$search$69 = MediaSessionStub.lambda$search$69(str, fromBundle, (MediaLibrarySessionImpl) mediaSessionImpl, controllerInfo, i11);
                    return lambda$search$69;
                }
            }));
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void seekBack(IMediaController iMediaController, int i10) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 11, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.ya
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).seekBack();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void seekForward(IMediaController iMediaController, int i10) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 12, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.cc
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).seekForward();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void seekTo(@Nullable IMediaController iMediaController, int i10, long j10) throws RuntimeException {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 5, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.od

            /* renamed from: a */
            public final /* synthetic */ long f817a;

            public /* synthetic */ od(long j102) {
                j10 = j102;
            }

            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).seekTo(j10);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void seekToDefaultPosition(IMediaController iMediaController, int i10) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 4, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.rc
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).seekToDefaultPosition();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void seekToDefaultPositionWithMediaItemIndex(IMediaController iMediaController, int i10, int i11) throws RemoteException {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 10, sendSessionResultSuccess(new ControllerPlayerTask() { // from class: androidx.media3.session.va

            /* renamed from: b */
            public final /* synthetic */ int f985b;

            public /* synthetic */ va(int i112) {
                i11 = i112;
            }

            @Override // androidx.media3.session.MediaSessionStub.ControllerPlayerTask
            public final void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo) {
                MediaSessionStub.this.lambda$seekToDefaultPositionWithMediaItemIndex$22(i11, playerWrapper, controllerInfo);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void seekToNext(@Nullable IMediaController iMediaController, int i10) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 9, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.qc
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).seekToNext();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void seekToNextMediaItem(@Nullable IMediaController iMediaController, int i10) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 8, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.hb
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).seekToNextMediaItem();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void seekToPrevious(@Nullable IMediaController iMediaController, int i10) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 7, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.ld
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).seekToPrevious();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void seekToPreviousMediaItem(@Nullable IMediaController iMediaController, int i10) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 6, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.yb
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).seekToPreviousMediaItem();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void seekToWithMediaItemIndex(IMediaController iMediaController, int i10, int i11, long j10) throws RemoteException {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 10, sendSessionResultSuccess(new ControllerPlayerTask() { // from class: androidx.media3.session.bb

            /* renamed from: b */
            public final /* synthetic */ int f434b;

            /* renamed from: c */
            public final /* synthetic */ long f435c;

            public /* synthetic */ bb(int i112, long j102) {
                i11 = i112;
                j10 = j102;
            }

            @Override // androidx.media3.session.MediaSessionStub.ControllerPlayerTask
            public final void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo) {
                MediaSessionStub.this.lambda$seekToWithMediaItemIndex$24(i11, j10, playerWrapper, controllerInfo);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void setDeviceMuted(@Nullable IMediaController iMediaController, int i10, boolean z10) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 26, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.mb

            /* renamed from: a */
            public final /* synthetic */ boolean f760a;

            public /* synthetic */ mb(boolean z102) {
                z10 = z102;
            }

            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).setDeviceMuted(z10);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void setDeviceMutedWithFlags(@Nullable IMediaController iMediaController, int i10, boolean z10, int i11) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 34, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.bd

            /* renamed from: a */
            public final /* synthetic */ boolean f437a;

            /* renamed from: b */
            public final /* synthetic */ int f438b;

            public /* synthetic */ bd(boolean z102, int i112) {
                z10 = z102;
                i11 = i112;
            }

            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).setDeviceMuted(z10, i11);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void setDeviceVolume(@Nullable IMediaController iMediaController, int i10, int i11) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 25, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.kd

            /* renamed from: a */
            public final /* synthetic */ int f701a;

            public /* synthetic */ kd(int i112) {
                i11 = i112;
            }

            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).setDeviceVolume(i11);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void setDeviceVolumeWithFlags(@Nullable IMediaController iMediaController, int i10, int i11, int i12) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 33, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.hc

            /* renamed from: a */
            public final /* synthetic */ int f608a;

            /* renamed from: b */
            public final /* synthetic */ int f609b;

            public /* synthetic */ hc(int i112, int i122) {
                i11 = i112;
                i12 = i122;
            }

            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).setDeviceVolume(i11, i12);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void setMediaItem(@Nullable IMediaController iMediaController, int i10, @Nullable Bundle bundle) {
        setMediaItemWithResetPosition(iMediaController, i10, bundle, true);
    }

    @Override // androidx.media3.session.IMediaSession
    public void setMediaItemWithResetPosition(@Nullable IMediaController iMediaController, int i10, @Nullable Bundle bundle, boolean z10) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            queueSessionTaskWithPlayerCommand(iMediaController, i10, 31, sendSessionResultWhenReady(handleMediaItemsWithStartPositionWhenReady(new SessionTask() { // from class: androidx.media3.session.pb

                /* renamed from: b */
                public final /* synthetic */ boolean f839b;

                public /* synthetic */ pb(boolean z102) {
                    z10 = z102;
                }

                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i11) {
                    p5.c0 lambda$setMediaItemWithResetPosition$31;
                    lambda$setMediaItemWithResetPosition$31 = MediaSessionStub.lambda$setMediaItemWithResetPosition$31(MediaItem.this, z10, mediaSessionImpl, controllerInfo, i11);
                    return lambda$setMediaItemWithResetPosition$31;
                }
            }, new sd())));
        } catch (RuntimeException e10) {
            Log.w(TAG, "Ignoring malformed Bundle for MediaItem", e10);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void setMediaItemWithStartPosition(@Nullable IMediaController iMediaController, int i10, @Nullable Bundle bundle, long j10) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            queueSessionTaskWithPlayerCommand(iMediaController, i10, 31, sendSessionResultWhenReady(handleMediaItemsWithStartPositionWhenReady(new SessionTask() { // from class: androidx.media3.session.fd

                /* renamed from: b */
                public final /* synthetic */ long f550b;

                public /* synthetic */ fd(long j102) {
                    j10 = j102;
                }

                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i11) {
                    p5.c0 lambda$setMediaItemWithStartPosition$30;
                    lambda$setMediaItemWithStartPosition$30 = MediaSessionStub.lambda$setMediaItemWithStartPosition$30(MediaItem.this, j10, mediaSessionImpl, controllerInfo, i11);
                    return lambda$setMediaItemWithStartPosition$30;
                }
            }, new sd())));
        } catch (RuntimeException e10) {
            Log.w(TAG, "Ignoring malformed Bundle for MediaItem", e10);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void setMediaItems(@Nullable IMediaController iMediaController, int i10, @Nullable IBinder iBinder) {
        setMediaItemsWithResetPosition(iMediaController, i10, iBinder, true);
    }

    @Override // androidx.media3.session.IMediaSession
    public void setMediaItemsWithResetPosition(@Nullable IMediaController iMediaController, int i10, @Nullable IBinder iBinder, boolean z10) {
        if (iMediaController == null || iBinder == null) {
            return;
        }
        try {
            queueSessionTaskWithPlayerCommand(iMediaController, i10, 20, sendSessionResultWhenReady(handleMediaItemsWithStartPositionWhenReady(new SessionTask() { // from class: androidx.media3.session.rd

                /* renamed from: a */
                public final /* synthetic */ List f887a;

                /* renamed from: b */
                public final /* synthetic */ boolean f888b;

                public /* synthetic */ rd(List list, boolean z102) {
                    fromBundleList = list;
                    z10 = z102;
                }

                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i11) {
                    p5.c0 lambda$setMediaItemsWithResetPosition$32;
                    lambda$setMediaItemsWithResetPosition$32 = MediaSessionStub.lambda$setMediaItemsWithResetPosition$32(fromBundleList, z10, mediaSessionImpl, controllerInfo, i11);
                    return lambda$setMediaItemsWithResetPosition$32;
                }
            }, new sd())));
        } catch (RuntimeException e10) {
            Log.w(TAG, "Ignoring malformed Bundle for MediaItem", e10);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void setMediaItemsWithStartIndex(@Nullable IMediaController iMediaController, int i10, @Nullable IBinder iBinder, int i11, long j10) {
        if (iMediaController == null || iBinder == null) {
            return;
        }
        try {
            queueSessionTaskWithPlayerCommand(iMediaController, i10, 20, sendSessionResultWhenReady(handleMediaItemsWithStartPositionWhenReady(new SessionTask() { // from class: androidx.media3.session.ac

                /* renamed from: a */
                public final /* synthetic */ List f406a;

                /* renamed from: b */
                public final /* synthetic */ int f407b;

                /* renamed from: c */
                public final /* synthetic */ long f408c;

                public /* synthetic */ ac(List list, int i112, long j102) {
                    fromBundleList = list;
                    i11 = i112;
                    j10 = j102;
                }

                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i12) {
                    p5.c0 lambda$setMediaItemsWithStartIndex$33;
                    lambda$setMediaItemsWithStartIndex$33 = MediaSessionStub.lambda$setMediaItemsWithStartIndex$33(fromBundleList, i11, j10, mediaSessionImpl, controllerInfo, i12);
                    return lambda$setMediaItemsWithStartIndex$33;
                }
            }, new sd())));
        } catch (RuntimeException e10) {
            Log.w(TAG, "Ignoring malformed Bundle for MediaItem", e10);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void setPlayWhenReady(@Nullable IMediaController iMediaController, int i10, boolean z10) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 1, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.wa

            /* renamed from: a */
            public final /* synthetic */ boolean f1009a;

            public /* synthetic */ wa(boolean z102) {
                z10 = z102;
            }

            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).setPlayWhenReady(z10);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void setPlaybackParameters(@Nullable IMediaController iMediaController, int i10, Bundle bundle) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 13, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.ob
            public /* synthetic */ ob() {
            }

            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).setPlaybackParameters(PlaybackParameters.this);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void setPlaybackSpeed(@Nullable IMediaController iMediaController, int i10, float f10) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 13, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.ab

            /* renamed from: a */
            public final /* synthetic */ float f405a;

            public /* synthetic */ ab(float f102) {
                f10 = f102;
            }

            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).setPlaybackSpeed(f10);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void setPlaylistMetadata(@Nullable IMediaController iMediaController, int i10, @Nullable Bundle bundle) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            queueSessionTaskWithPlayerCommand(iMediaController, i10, 19, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.ed
                public /* synthetic */ ed() {
                }

                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    ((PlayerWrapper) obj).setPlaylistMetadata(MediaMetadata.this);
                }
            }));
        } catch (RuntimeException e10) {
            Log.w(TAG, "Ignoring malformed Bundle for MediaMetadata", e10);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void setRating(@Nullable IMediaController iMediaController, int i10, @Nullable Bundle bundle) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            dispatchSessionTaskWithSessionCommand(iMediaController, i10, SessionCommand.COMMAND_CODE_SESSION_SET_RATING, sendSessionResultWhenReady(new SessionTask() { // from class: androidx.media3.session.pa
                public /* synthetic */ pa() {
                }

                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i11) {
                    p5.c0 lambda$setRating$27;
                    lambda$setRating$27 = MediaSessionStub.lambda$setRating$27(Rating.this, mediaSessionImpl, controllerInfo, i11);
                    return lambda$setRating$27;
                }
            }));
        } catch (RuntimeException e10) {
            Log.w(TAG, "Ignoring malformed Bundle for Rating", e10);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void setRatingWithMediaId(@Nullable IMediaController iMediaController, int i10, String str, @Nullable Bundle bundle) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "setRatingWithMediaId(): Ignoring empty mediaId");
            return;
        }
        try {
            dispatchSessionTaskWithSessionCommand(iMediaController, i10, SessionCommand.COMMAND_CODE_SESSION_SET_RATING, sendSessionResultWhenReady(new SessionTask() { // from class: androidx.media3.session.ec

                /* renamed from: a */
                public final /* synthetic */ String f517a;

                /* renamed from: b */
                public final /* synthetic */ Rating f518b;

                public /* synthetic */ ec(String str2, Rating rating) {
                    str = str2;
                    fromBundle = rating;
                }

                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i11) {
                    p5.c0 lambda$setRatingWithMediaId$26;
                    lambda$setRatingWithMediaId$26 = MediaSessionStub.lambda$setRatingWithMediaId$26(str, fromBundle, mediaSessionImpl, controllerInfo, i11);
                    return lambda$setRatingWithMediaId$26;
                }
            }));
        } catch (RuntimeException e10) {
            Log.w(TAG, "Ignoring malformed Bundle for Rating", e10);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void setRepeatMode(@Nullable IMediaController iMediaController, int i10, int i11) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 15, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.ic

            /* renamed from: a */
            public final /* synthetic */ int f636a;

            public /* synthetic */ ic(int i112) {
                i11 = i112;
            }

            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).setRepeatMode(i11);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void setShuffleModeEnabled(@Nullable IMediaController iMediaController, int i10, boolean z10) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 14, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.pc

            /* renamed from: a */
            public final /* synthetic */ boolean f840a;

            public /* synthetic */ pc(boolean z102) {
                z10 = z102;
            }

            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).setShuffleModeEnabled(z10);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void setTrackSelectionParameters(@Nullable IMediaController iMediaController, int i10, Bundle bundle) throws RemoteException {
        if (iMediaController == null) {
            return;
        }
        try {
            queueSessionTaskWithPlayerCommand(iMediaController, i10, 29, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.kb

                /* renamed from: b */
                public final /* synthetic */ TrackSelectionParameters f700b;

                public /* synthetic */ kb(TrackSelectionParameters trackSelectionParameters) {
                    fromBundle = trackSelectionParameters;
                }

                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaSessionStub.this.lambda$setTrackSelectionParameters$65(fromBundle, (PlayerWrapper) obj);
                }
            }));
        } catch (RuntimeException e10) {
            Log.w(TAG, "Ignoring malformed Bundle for TrackSelectionParameters", e10);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void setVideoSurface(@Nullable IMediaController iMediaController, int i10, @Nullable Surface surface) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 27, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.tc

            /* renamed from: a */
            public final /* synthetic */ Surface f934a;

            public /* synthetic */ tc(Surface surface2) {
                surface = surface2;
            }

            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).setVideoSurface(surface);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void setVolume(@Nullable IMediaController iMediaController, int i10, float f10) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 24, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.oc

            /* renamed from: a */
            public final /* synthetic */ float f816a;

            public /* synthetic */ oc(float f102) {
                f10 = f102;
            }

            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).setVolume(f10);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void stop(@Nullable IMediaController iMediaController, int i10) throws RemoteException {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i10, 3, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.wb
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).stop();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void subscribe(@Nullable IMediaController iMediaController, int i10, String str, @Nullable Bundle bundle) {
        if (iMediaController == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "subscribe(): Ignoring empty parentId");
        } else {
            dispatchSessionTaskWithSessionCommand(iMediaController, i10, SessionCommand.COMMAND_CODE_LIBRARY_SUBSCRIBE, sendLibraryResultWhenReady(new SessionTask() { // from class: androidx.media3.session.gd

                /* renamed from: a */
                public final /* synthetic */ String f578a;

                /* renamed from: b */
                public final /* synthetic */ MediaLibraryService.LibraryParams f579b;

                public /* synthetic */ gd(String str2, MediaLibraryService.LibraryParams libraryParams) {
                    str = str2;
                    fromBundle = libraryParams;
                }

                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i11) {
                    p5.c0 lambda$subscribe$71;
                    lambda$subscribe$71 = MediaSessionStub.lambda$subscribe$71(str, fromBundle, (MediaLibrarySessionImpl) mediaSessionImpl, controllerInfo, i11);
                    return lambda$subscribe$71;
                }
            }));
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void unsubscribe(@Nullable IMediaController iMediaController, int i10, String str) {
        if (iMediaController == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "unsubscribe(): Ignoring empty parentId");
        } else {
            dispatchSessionTaskWithSessionCommand(iMediaController, i10, SessionCommand.COMMAND_CODE_LIBRARY_UNSUBSCRIBE, sendLibraryResultWhenReady(new SessionTask() { // from class: androidx.media3.session.qa

                /* renamed from: a */
                public final /* synthetic */ String f859a;

                public /* synthetic */ qa(String str2) {
                    str = str2;
                }

                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i11) {
                    p5.c0 lambda$unsubscribe$72;
                    lambda$unsubscribe$72 = MediaSessionStub.lambda$unsubscribe$72(str, (MediaLibrarySessionImpl) mediaSessionImpl, controllerInfo, i11);
                    return lambda$unsubscribe$72;
                }
            }));
        }
    }

    private <K extends MediaSessionImpl> void dispatchSessionTaskWithSessionCommand(IMediaController iMediaController, int i10, SessionCommand sessionCommand, SessionTask<p5.c0<Void>, K> sessionTask) {
        dispatchSessionTaskWithSessionCommand(iMediaController, i10, sessionCommand, 0, sessionTask);
    }

    private static <K extends MediaSessionImpl> SessionTask<p5.c0<Void>, K> sendSessionResultSuccess(ControllerPlayerTask controllerPlayerTask) {
        return new SessionTask() { // from class: androidx.media3.session.nd
            public /* synthetic */ nd() {
            }

            @Override // androidx.media3.session.MediaSessionStub.SessionTask
            public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i10) {
                p5.c0 lambda$sendSessionResultSuccess$1;
                lambda$sendSessionResultSuccess$1 = MediaSessionStub.lambda$sendSessionResultSuccess$1(MediaSessionStub.ControllerPlayerTask.this, mediaSessionImpl, controllerInfo, i10);
                return lambda$sendSessionResultSuccess$1;
            }
        };
    }

    private <K extends MediaSessionImpl> void dispatchSessionTaskWithSessionCommand(IMediaController iMediaController, int i10, @Nullable SessionCommand sessionCommand, int i11, SessionTask<p5.c0<Void>, K> sessionTask) {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaSessionImpl mediaSessionImpl = this.sessionImpl.get();
            if (mediaSessionImpl != null && !mediaSessionImpl.isReleased()) {
                MediaSession.ControllerInfo controller = this.connectedControllersManager.getController(iMediaController.asBinder());
                if (controller == null) {
                    return;
                }
                Util.postOrRun(mediaSessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.fc

                    /* renamed from: c */
                    public final /* synthetic */ MediaSession.ControllerInfo f543c;

                    /* renamed from: d */
                    public final /* synthetic */ SessionCommand f544d;

                    /* renamed from: e */
                    public final /* synthetic */ int f545e;

                    /* renamed from: f */
                    public final /* synthetic */ int f546f;

                    /* renamed from: g */
                    public final /* synthetic */ MediaSessionStub.SessionTask f547g;

                    /* renamed from: h */
                    public final /* synthetic */ MediaSessionImpl f548h;

                    public /* synthetic */ fc(MediaSession.ControllerInfo controller2, SessionCommand sessionCommand2, int i102, int i112, MediaSessionStub.SessionTask sessionTask2, MediaSessionImpl mediaSessionImpl2) {
                        controller = controller2;
                        sessionCommand = sessionCommand2;
                        i10 = i102;
                        i11 = i112;
                        sessionTask = sessionTask2;
                        mediaSessionImpl = mediaSessionImpl2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaSessionStub.this.lambda$dispatchSessionTaskWithSessionCommand$15(controller, sessionCommand, i10, i11, sessionTask, mediaSessionImpl);
                    }
                });
            }
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void release(@Nullable IMediaController iMediaController, int i10) throws RemoteException {
        if (iMediaController == null) {
            return;
        }
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaSessionImpl mediaSessionImpl = this.sessionImpl.get();
            if (mediaSessionImpl != null && !mediaSessionImpl.isReleased()) {
                Util.postOrRun(mediaSessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.sa

                    /* renamed from: c */
                    public final /* synthetic */ IMediaController f903c;

                    public /* synthetic */ sa(IMediaController iMediaController2) {
                        iMediaController = iMediaController2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaSessionStub.this.lambda$release$19(iMediaController);
                    }
                });
            }
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void connect(@Nullable IMediaController iMediaController, int i10, @Nullable Bundle bundle) throws RuntimeException {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            ConnectionRequest fromBundle = ConnectionRequest.CREATOR.fromBundle(bundle);
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            long clearCallingIdentity = Binder.clearCallingIdentity();
            if (callingPid == 0) {
                callingPid = fromBundle.pid;
            }
            try {
                connect(iMediaController, fromBundle.libraryVersion, fromBundle.controllerInterfaceVersion, fromBundle.packageName, callingPid, callingUid, fromBundle.connectionHints);
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        } catch (RuntimeException e10) {
            Log.w(TAG, "Ignoring malformed Bundle for ConnectionRequest", e10);
        }
    }
}
