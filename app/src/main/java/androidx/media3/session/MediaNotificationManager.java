package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Intent;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaController;
import androidx.media3.session.MediaNotification;
import androidx.media3.session.MediaNotificationManager;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
final class MediaNotificationManager {
    private static final String TAG = "MediaNtfMng";
    private final MediaNotification.ActionFactory actionFactory;

    @Nullable
    private MediaNotification mediaNotification;
    private final MediaNotification.Provider mediaNotificationProvider;
    private final MediaSessionService mediaSessionService;
    private final NotificationManagerCompat notificationManagerCompat;
    private final Intent startSelfIntent;
    private int totalNotificationCount;
    private final Executor mainExecutor = new Executor() { // from class: androidx.media3.session.i7

        /* renamed from: b */
        public final /* synthetic */ Handler f629b;

        public /* synthetic */ i7(Handler handler) {
            handler = handler;
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            Util.postOrRun(handler, runnable);
        }
    };
    private final Map<MediaSession, p5.c0<MediaController>> controllerMap = new HashMap();
    private final Map<MediaSession, ImmutableList<CommandButton>> customLayoutMap = new HashMap();
    private boolean startedInForeground = false;

    /* renamed from: androidx.media3.session.MediaNotificationManager$1 */
    public class AnonymousClass1 implements p5.x<SessionResult> {
        final /* synthetic */ String val$action;

        public AnonymousClass1(MediaNotificationManager mediaNotificationManager, String str) {
            str = str;
        }

        @Override // p5.x
        public void onFailure(Throwable th2) {
            Log.w(MediaNotificationManager.TAG, "custom command " + str + " produced an error: " + th2.getMessage(), th2);
        }

        @Override // p5.x
        public void onSuccess(SessionResult sessionResult) {
        }
    }

    @RequiresApi(24)
    public static class Api24 {
        private Api24() {
        }

        @DoNotInline
        public static void stopForeground(MediaSessionService mediaSessionService, boolean z10) {
            mediaSessionService.stopForeground(z10 ? 1 : 2);
        }
    }

    @RequiresApi(29)
    public static class Api29 {
        private Api29() {
        }

        @DoNotInline
        public static void startForeground(MediaSessionService mediaSessionService, MediaNotification mediaNotification) {
            try {
                mediaSessionService.startForeground(mediaNotification.notificationId, mediaNotification.notification, 2);
            } catch (RuntimeException e10) {
                Log.e(MediaNotificationManager.TAG, "The service must be declared with a foregroundServiceType that includes  mediaPlayback");
                throw e10;
            }
        }
    }

    public static final class MediaControllerListener implements MediaController.Listener, Player.Listener {
        private final Map<MediaSession, ImmutableList<CommandButton>> customLayoutMap;
        private final MediaSessionService mediaSessionService;
        private final MediaSession session;

        public MediaControllerListener(MediaSessionService mediaSessionService, MediaSession mediaSession, Map<MediaSession, ImmutableList<CommandButton>> map) {
            this.mediaSessionService = mediaSessionService;
            this.session = mediaSession;
            this.customLayoutMap = map;
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onAudioAttributesChanged(AudioAttributes audioAttributes) {
            m0.c0.a(this, audioAttributes);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onAudioSessionIdChanged(int i10) {
            m0.c0.b(this, i10);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
            m0.c0.c(this, commands);
        }

        @Override // androidx.media3.session.MediaController.Listener
        public /* synthetic */ void onAvailableSessionCommandsChanged(MediaController mediaController, SessionCommands sessionCommands) {
            p0.p.a(this, mediaController, sessionCommands);
        }

        public void onConnected(boolean z10) {
            if (z10) {
                this.mediaSessionService.onUpdateNotificationInternal(this.session, false);
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onCues(CueGroup cueGroup) {
            m0.c0.d(this, cueGroup);
        }

        @Override // androidx.media3.session.MediaController.Listener
        public /* synthetic */ p5.c0 onCustomCommand(MediaController mediaController, SessionCommand sessionCommand, Bundle bundle) {
            return p0.p.b(this, mediaController, sessionCommand, bundle);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
            m0.c0.f(this, deviceInfo);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onDeviceVolumeChanged(int i10, boolean z10) {
            m0.c0.g(this, i10, z10);
        }

        @Override // androidx.media3.session.MediaController.Listener
        public void onDisconnected(MediaController mediaController) {
            this.mediaSessionService.removeSession(this.session);
            this.mediaSessionService.onUpdateNotificationInternal(this.session, false);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onEvents(Player player, Player.Events events) {
            if (events.containsAny(4, 5, 14, 0)) {
                this.mediaSessionService.onUpdateNotificationInternal(this.session, false);
            }
        }

        @Override // androidx.media3.session.MediaController.Listener
        public /* synthetic */ void onExtrasChanged(MediaController mediaController, Bundle bundle) {
            p0.p.d(this, mediaController, bundle);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onIsLoadingChanged(boolean z10) {
            m0.c0.i(this, z10);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onIsPlayingChanged(boolean z10) {
            m0.c0.j(this, z10);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onLoadingChanged(boolean z10) {
            m0.c0.k(this, z10);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j10) {
            m0.c0.l(this, j10);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i10) {
            m0.c0.m(this, mediaItem, i10);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
            m0.c0.n(this, mediaMetadata);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onMetadata(Metadata metadata) {
            m0.c0.o(this, metadata);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onPlayWhenReadyChanged(boolean z10, int i10) {
            m0.c0.p(this, z10, i10);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            m0.c0.q(this, playbackParameters);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onPlaybackStateChanged(int i10) {
            m0.c0.r(this, i10);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i10) {
            m0.c0.s(this, i10);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onPlayerError(PlaybackException playbackException) {
            m0.c0.t(this, playbackException);
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
        public /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
            m0.c0.w(this, mediaMetadata);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onPositionDiscontinuity(int i10) {
            m0.c0.x(this, i10);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onRenderedFirstFrame() {
            m0.c0.z(this);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onRepeatModeChanged(int i10) {
            m0.c0.A(this, i10);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onSeekBackIncrementChanged(long j10) {
            m0.c0.B(this, j10);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onSeekForwardIncrementChanged(long j10) {
            m0.c0.C(this, j10);
        }

        @Override // androidx.media3.session.MediaController.Listener
        public /* synthetic */ void onSessionActivityChanged(MediaController mediaController, PendingIntent pendingIntent) {
            p0.p.e(this, mediaController, pendingIntent);
        }

        @Override // androidx.media3.session.MediaController.Listener
        public p5.c0<SessionResult> onSetCustomLayout(MediaController mediaController, List<CommandButton> list) {
            this.customLayoutMap.put(this.session, ImmutableList.copyOf((Collection) list));
            this.mediaSessionService.onUpdateNotificationInternal(this.session, false);
            return com.google.common.util.concurrent.l.m(new SessionResult(0));
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z10) {
            m0.c0.D(this, z10);
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
        public /* synthetic */ void onTimelineChanged(Timeline timeline, int i10) {
            m0.c0.G(this, timeline, i10);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
            m0.c0.H(this, trackSelectionParameters);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onTracksChanged(Tracks tracks) {
            m0.c0.I(this, tracks);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
            m0.c0.J(this, videoSize);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onVolumeChanged(float f10) {
            m0.c0.K(this, f10);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onCues(List list) {
            m0.c0.e(this, list);
        }

        @Override // androidx.media3.common.Player.Listener
        public /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i10) {
            m0.c0.y(this, positionInfo, positionInfo2, i10);
        }
    }

    public MediaNotificationManager(MediaSessionService mediaSessionService, MediaNotification.Provider provider, MediaNotification.ActionFactory actionFactory) {
        this.mediaSessionService = mediaSessionService;
        this.mediaNotificationProvider = provider;
        this.actionFactory = actionFactory;
        this.notificationManagerCompat = NotificationManagerCompat.from(mediaSessionService);
        this.startSelfIntent = new Intent(mediaSessionService, mediaSessionService.getClass());
    }

    @Nullable
    private MediaController getConnectedControllerForSession(MediaSession mediaSession) {
        p5.c0<MediaController> c0Var = this.controllerMap.get(mediaSession);
        if (c0Var == null) {
            return null;
        }
        try {
            return (MediaController) com.google.common.util.concurrent.l.h(c0Var);
        } catch (ExecutionException e10) {
            throw new IllegalStateException(e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$addSession$1(p5.c0 c0Var, MediaControllerListener mediaControllerListener, MediaSession mediaSession) {
        try {
            MediaController mediaController = (MediaController) c0Var.get(0L, TimeUnit.MILLISECONDS);
            mediaControllerListener.onConnected(shouldShowNotification(mediaSession));
            mediaController.addListener(mediaControllerListener);
        } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException unused) {
            this.mediaSessionService.removeSession(mediaSession);
        }
    }

    public /* synthetic */ void lambda$onCustomAction$3(MediaSession mediaSession, String str, Bundle bundle, MediaController mediaController) {
        if (this.mediaNotificationProvider.handleCustomCommand(mediaSession, str, bundle)) {
            return;
        }
        this.mainExecutor.execute(new Runnable() { // from class: androidx.media3.session.h7

            /* renamed from: c */
            public final /* synthetic */ MediaController f599c;

            /* renamed from: d */
            public final /* synthetic */ String f600d;

            public /* synthetic */ h7(MediaController mediaController2, String str2) {
                mediaController = mediaController2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaNotificationManager.this.lambda$onCustomAction$2(mediaController, str);
            }
        });
    }

    public /* synthetic */ void lambda$updateNotification$5(int i10, MediaSession mediaSession, MediaNotification mediaNotification) {
        this.mainExecutor.execute(new Runnable() { // from class: androidx.media3.session.g7

            /* renamed from: c */
            public final /* synthetic */ int f567c;

            /* renamed from: d */
            public final /* synthetic */ MediaSession f568d;

            /* renamed from: e */
            public final /* synthetic */ MediaNotification f569e;

            public /* synthetic */ g7(int i102, MediaSession mediaSession2, MediaNotification mediaNotification2) {
                i10 = i102;
                mediaSession = mediaSession2;
                mediaNotification = mediaNotification2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaNotificationManager.this.lambda$updateNotification$4(i10, mediaSession, mediaNotification);
            }
        });
    }

    public /* synthetic */ void lambda$updateNotification$7(MediaSession mediaSession, ImmutableList immutableList, MediaNotification.Provider.Callback callback, boolean z10) {
        this.mainExecutor.execute(new Runnable() { // from class: androidx.media3.session.j7

            /* renamed from: c */
            public final /* synthetic */ MediaSession f654c;

            /* renamed from: d */
            public final /* synthetic */ MediaNotification f655d;

            /* renamed from: e */
            public final /* synthetic */ boolean f656e;

            public /* synthetic */ j7(MediaSession mediaSession2, MediaNotification mediaNotification, boolean z102) {
                mediaSession = mediaSession2;
                createNotification = mediaNotification;
                z10 = z102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaNotificationManager.this.lambda$updateNotification$6(mediaSession, createNotification, z10);
            }
        });
    }

    private void maybeStopForegroundService(boolean z10) {
        MediaNotification mediaNotification;
        List<MediaSession> sessions = this.mediaSessionService.getSessions();
        for (int i10 = 0; i10 < sessions.size(); i10++) {
            if (shouldRunInForeground(sessions.get(i10), false)) {
                return;
            }
        }
        stopForeground(z10);
        if (!z10 || (mediaNotification = this.mediaNotification) == null) {
            return;
        }
        this.notificationManagerCompat.cancel(mediaNotification.notificationId);
        this.totalNotificationCount++;
        this.mediaNotification = null;
    }

    /* renamed from: onNotificationUpdated */
    public void lambda$updateNotification$4(int i10, MediaSession mediaSession, MediaNotification mediaNotification) {
        if (i10 == this.totalNotificationCount) {
            lambda$updateNotification$6(mediaSession, mediaNotification, shouldRunInForeground(mediaSession, false));
        }
    }

    /* renamed from: sendCustomCommandIfCommandIsAvailable */
    public void lambda$onCustomAction$2(MediaController mediaController, String str) {
        SessionCommand sessionCommand;
        e5.z1<SessionCommand> it = mediaController.getAvailableSessionCommands().commands.iterator();
        while (true) {
            if (!it.hasNext()) {
                sessionCommand = null;
                break;
            }
            sessionCommand = it.next();
            if (sessionCommand.commandCode == 0 && sessionCommand.customAction.equals(str)) {
                break;
            }
        }
        if (sessionCommand == null || !mediaController.getAvailableSessionCommands().contains(sessionCommand)) {
            return;
        }
        com.google.common.util.concurrent.l.a(mediaController.sendCustomCommand(sessionCommand, Bundle.EMPTY), new p5.x<SessionResult>(this) { // from class: androidx.media3.session.MediaNotificationManager.1
            final /* synthetic */ String val$action;

            public AnonymousClass1(MediaNotificationManager this, String str2) {
                str = str2;
            }

            @Override // p5.x
            public void onFailure(Throwable th2) {
                Log.w(MediaNotificationManager.TAG, "custom command " + str + " produced an error: " + th2.getMessage(), th2);
            }

            @Override // p5.x
            public void onSuccess(SessionResult sessionResult) {
            }
        }, com.google.common.util.concurrent.p.c());
    }

    private boolean shouldShowNotification(MediaSession mediaSession) {
        MediaController connectedControllerForSession = getConnectedControllerForSession(mediaSession);
        return (connectedControllerForSession == null || connectedControllerForSession.getCurrentTimeline().isEmpty() || connectedControllerForSession.getPlaybackState() == 1) ? false : true;
    }

    private void startForeground(MediaNotification mediaNotification) {
        ContextCompat.startForegroundService(this.mediaSessionService, this.startSelfIntent);
        if (Util.SDK_INT >= 29) {
            Api29.startForeground(this.mediaSessionService, mediaNotification);
        } else {
            this.mediaSessionService.startForeground(mediaNotification.notificationId, mediaNotification.notification);
        }
        this.startedInForeground = true;
    }

    private void stopForeground(boolean z10) {
        int i10 = Util.SDK_INT;
        if (i10 >= 24) {
            Api24.stopForeground(this.mediaSessionService, z10);
        } else {
            this.mediaSessionService.stopForeground(z10 || i10 < 21);
        }
        this.startedInForeground = false;
    }

    /* renamed from: updateNotificationInternal */
    public void lambda$updateNotification$6(MediaSession mediaSession, MediaNotification mediaNotification, boolean z10) {
        if (Util.SDK_INT >= 21) {
            mediaNotification.notification.extras.putParcelable(NotificationCompat.EXTRA_MEDIA_SESSION, (MediaSession.Token) mediaSession.getSessionCompat().getSessionToken().getToken());
        }
        this.mediaNotification = mediaNotification;
        if (z10) {
            startForeground(mediaNotification);
        } else {
            this.notificationManagerCompat.notify(mediaNotification.notificationId, mediaNotification.notification);
            maybeStopForegroundService(false);
        }
    }

    public void addSession(MediaSession mediaSession) {
        if (this.controllerMap.containsKey(mediaSession)) {
            return;
        }
        this.customLayoutMap.put(mediaSession, ImmutableList.of());
        MediaControllerListener mediaControllerListener = new MediaControllerListener(this.mediaSessionService, mediaSession, this.customLayoutMap);
        p5.c0<MediaController> buildAsync = new MediaController.Builder(this.mediaSessionService, mediaSession.getToken()).setListener(mediaControllerListener).setApplicationLooper(Looper.getMainLooper()).buildAsync();
        this.controllerMap.put(mediaSession, buildAsync);
        buildAsync.addListener(new Runnable() { // from class: androidx.media3.session.n7

            /* renamed from: c */
            public final /* synthetic */ p5.c0 f779c;

            /* renamed from: d */
            public final /* synthetic */ MediaNotificationManager.MediaControllerListener f780d;

            /* renamed from: e */
            public final /* synthetic */ MediaSession f781e;

            public /* synthetic */ n7(p5.c0 buildAsync2, MediaNotificationManager.MediaControllerListener mediaControllerListener2, MediaSession mediaSession2) {
                buildAsync = buildAsync2;
                mediaControllerListener = mediaControllerListener2;
                mediaSession = mediaSession2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaNotificationManager.this.lambda$addSession$1(buildAsync, mediaControllerListener, mediaSession);
            }
        }, this.mainExecutor);
    }

    public boolean isStartedInForeground() {
        return this.startedInForeground;
    }

    public void onCustomAction(MediaSession mediaSession, String str, Bundle bundle) {
        MediaController connectedControllerForSession = getConnectedControllerForSession(mediaSession);
        if (connectedControllerForSession == null) {
            return;
        }
        Util.postOrRun(new Handler(mediaSession.getPlayer().getApplicationLooper()), new Runnable() { // from class: androidx.media3.session.k7

            /* renamed from: c */
            public final /* synthetic */ MediaSession f690c;

            /* renamed from: d */
            public final /* synthetic */ String f691d;

            /* renamed from: e */
            public final /* synthetic */ Bundle f692e;

            /* renamed from: f */
            public final /* synthetic */ MediaController f693f;

            public /* synthetic */ k7(MediaSession mediaSession2, String str2, Bundle bundle2, MediaController connectedControllerForSession2) {
                mediaSession = mediaSession2;
                str = str2;
                bundle = bundle2;
                connectedControllerForSession = connectedControllerForSession2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaNotificationManager.this.lambda$onCustomAction$3(mediaSession, str, bundle, connectedControllerForSession);
            }
        });
    }

    public void removeSession(MediaSession mediaSession) {
        this.customLayoutMap.remove(mediaSession);
        p5.c0<MediaController> remove = this.controllerMap.remove(mediaSession);
        if (remove != null) {
            MediaController.releaseFuture(remove);
        }
    }

    public boolean shouldRunInForeground(MediaSession mediaSession, boolean z10) {
        MediaController connectedControllerForSession = getConnectedControllerForSession(mediaSession);
        return connectedControllerForSession != null && (connectedControllerForSession.getPlayWhenReady() || z10) && (connectedControllerForSession.getPlaybackState() == 3 || connectedControllerForSession.getPlaybackState() == 2);
    }

    public void updateNotification(MediaSession mediaSession, boolean z10) {
        if (!this.mediaSessionService.isSessionAdded(mediaSession) || !shouldShowNotification(mediaSession)) {
            maybeStopForegroundService(true);
            return;
        }
        int i10 = this.totalNotificationCount + 1;
        this.totalNotificationCount = i10;
        Util.postOrRun(new Handler(mediaSession.getPlayer().getApplicationLooper()), new Runnable() { // from class: androidx.media3.session.m7

            /* renamed from: c */
            public final /* synthetic */ MediaSession f746c;

            /* renamed from: d */
            public final /* synthetic */ ImmutableList f747d;

            /* renamed from: e */
            public final /* synthetic */ MediaNotification.Provider.Callback f748e;

            /* renamed from: f */
            public final /* synthetic */ boolean f749f;

            public /* synthetic */ m7(MediaSession mediaSession2, ImmutableList immutableList, MediaNotification.Provider.Callback callback, boolean z102) {
                mediaSession = mediaSession2;
                immutableList = immutableList;
                callback = callback;
                z10 = z102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaNotificationManager.this.lambda$updateNotification$7(mediaSession, immutableList, callback, z10);
            }
        });
    }
}
