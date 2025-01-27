package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media.MediaSessionManager;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Rating;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaLibraryService;
import b5.r;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Longs;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@DoNotMock
/* loaded from: classes.dex */
public class MediaSession {

    @GuardedBy("STATIC_LOCK")
    private static final HashMap<String, MediaSession> SESSION_ID_TO_SESSION_MAP;
    private static final Object STATIC_LOCK;
    private final MediaSessionImpl impl;

    public static final class Builder extends BuilderBase<MediaSession, Builder, Callback> {

        /* renamed from: androidx.media3.session.MediaSession$Builder$1 */
        public class AnonymousClass1 implements Callback {
            @Override // androidx.media3.session.MediaSession.Callback
            public /* synthetic */ p5.c0 onAddMediaItems(MediaSession mediaSession, ControllerInfo controllerInfo, List list) {
                return p0.y.a(this, mediaSession, controllerInfo, list);
            }

            @Override // androidx.media3.session.MediaSession.Callback
            public /* synthetic */ ConnectionResult onConnect(MediaSession mediaSession, ControllerInfo controllerInfo) {
                return p0.y.b(this, mediaSession, controllerInfo);
            }

            @Override // androidx.media3.session.MediaSession.Callback
            public /* synthetic */ p5.c0 onCustomCommand(MediaSession mediaSession, ControllerInfo controllerInfo, SessionCommand sessionCommand, Bundle bundle) {
                return p0.y.c(this, mediaSession, controllerInfo, sessionCommand, bundle);
            }

            @Override // androidx.media3.session.MediaSession.Callback
            public /* synthetic */ void onDisconnected(MediaSession mediaSession, ControllerInfo controllerInfo) {
                p0.y.d(this, mediaSession, controllerInfo);
            }

            @Override // androidx.media3.session.MediaSession.Callback
            public /* synthetic */ p5.c0 onPlaybackResumption(MediaSession mediaSession, ControllerInfo controllerInfo) {
                return p0.y.e(this, mediaSession, controllerInfo);
            }

            @Override // androidx.media3.session.MediaSession.Callback
            public /* synthetic */ int onPlayerCommandRequest(MediaSession mediaSession, ControllerInfo controllerInfo, int i10) {
                return p0.y.f(this, mediaSession, controllerInfo, i10);
            }

            @Override // androidx.media3.session.MediaSession.Callback
            public /* synthetic */ void onPostConnect(MediaSession mediaSession, ControllerInfo controllerInfo) {
                p0.y.g(this, mediaSession, controllerInfo);
            }

            @Override // androidx.media3.session.MediaSession.Callback
            public /* synthetic */ p5.c0 onSetMediaItems(MediaSession mediaSession, ControllerInfo controllerInfo, List list, int i10, long j10) {
                return p0.y.h(this, mediaSession, controllerInfo, list, i10, j10);
            }

            @Override // androidx.media3.session.MediaSession.Callback
            public /* synthetic */ p5.c0 onSetRating(MediaSession mediaSession, ControllerInfo controllerInfo, Rating rating) {
                return p0.y.i(this, mediaSession, controllerInfo, rating);
            }

            @Override // androidx.media3.session.MediaSession.Callback
            public /* synthetic */ p5.c0 onSetRating(MediaSession mediaSession, ControllerInfo controllerInfo, String str, Rating rating) {
                return p0.y.j(this, mediaSession, controllerInfo, str, rating);
            }
        }

        public Builder(Context context, Player player) {
            super(context, player, new Callback() { // from class: androidx.media3.session.MediaSession.Builder.1
                @Override // androidx.media3.session.MediaSession.Callback
                public /* synthetic */ p5.c0 onAddMediaItems(MediaSession mediaSession, ControllerInfo controllerInfo, List list) {
                    return p0.y.a(this, mediaSession, controllerInfo, list);
                }

                @Override // androidx.media3.session.MediaSession.Callback
                public /* synthetic */ ConnectionResult onConnect(MediaSession mediaSession, ControllerInfo controllerInfo) {
                    return p0.y.b(this, mediaSession, controllerInfo);
                }

                @Override // androidx.media3.session.MediaSession.Callback
                public /* synthetic */ p5.c0 onCustomCommand(MediaSession mediaSession, ControllerInfo controllerInfo, SessionCommand sessionCommand, Bundle bundle) {
                    return p0.y.c(this, mediaSession, controllerInfo, sessionCommand, bundle);
                }

                @Override // androidx.media3.session.MediaSession.Callback
                public /* synthetic */ void onDisconnected(MediaSession mediaSession, ControllerInfo controllerInfo) {
                    p0.y.d(this, mediaSession, controllerInfo);
                }

                @Override // androidx.media3.session.MediaSession.Callback
                public /* synthetic */ p5.c0 onPlaybackResumption(MediaSession mediaSession, ControllerInfo controllerInfo) {
                    return p0.y.e(this, mediaSession, controllerInfo);
                }

                @Override // androidx.media3.session.MediaSession.Callback
                public /* synthetic */ int onPlayerCommandRequest(MediaSession mediaSession, ControllerInfo controllerInfo, int i10) {
                    return p0.y.f(this, mediaSession, controllerInfo, i10);
                }

                @Override // androidx.media3.session.MediaSession.Callback
                public /* synthetic */ void onPostConnect(MediaSession mediaSession, ControllerInfo controllerInfo) {
                    p0.y.g(this, mediaSession, controllerInfo);
                }

                @Override // androidx.media3.session.MediaSession.Callback
                public /* synthetic */ p5.c0 onSetMediaItems(MediaSession mediaSession, ControllerInfo controllerInfo, List list, int i10, long j10) {
                    return p0.y.h(this, mediaSession, controllerInfo, list, i10, j10);
                }

                @Override // androidx.media3.session.MediaSession.Callback
                public /* synthetic */ p5.c0 onSetRating(MediaSession mediaSession, ControllerInfo controllerInfo, Rating rating) {
                    return p0.y.i(this, mediaSession, controllerInfo, rating);
                }

                @Override // androidx.media3.session.MediaSession.Callback
                public /* synthetic */ p5.c0 onSetRating(MediaSession mediaSession, ControllerInfo controllerInfo, String str, Rating rating) {
                    return p0.y.j(this, mediaSession, controllerInfo, str, rating);
                }
            });
        }

        @Override // androidx.media3.session.MediaSession.BuilderBase
        public MediaSession build() {
            if (this.bitmapLoader == null) {
                this.bitmapLoader = new CacheBitmapLoader(new SimpleBitmapLoader());
            }
            return new MediaSession(this.context, this.f377id, this.player, this.sessionActivity, this.callback, this.extras, (androidx.media3.common.util.BitmapLoader) Assertions.checkNotNull(this.bitmapLoader));
        }

        @Override // androidx.media3.session.MediaSession.BuilderBase
        @UnstableApi
        public Builder setBitmapLoader(androidx.media3.common.util.BitmapLoader bitmapLoader) {
            return (Builder) super.setBitmapLoader(bitmapLoader);
        }

        @Override // androidx.media3.session.MediaSession.BuilderBase
        public Builder setCallback(Callback callback) {
            return (Builder) super.setCallback((Builder) callback);
        }

        @Override // androidx.media3.session.MediaSession.BuilderBase
        public Builder setExtras(Bundle bundle) {
            return (Builder) super.setExtras(bundle);
        }

        @Override // androidx.media3.session.MediaSession.BuilderBase
        public Builder setId(String str) {
            return (Builder) super.setId(str);
        }

        @Override // androidx.media3.session.MediaSession.BuilderBase
        public Builder setSessionActivity(PendingIntent pendingIntent) {
            return (Builder) super.setSessionActivity(pendingIntent);
        }
    }

    public static abstract class BuilderBase<SessionT extends MediaSession, BuilderT extends BuilderBase<SessionT, BuilderT, CallbackT>, CallbackT extends Callback> {
        androidx.media3.common.util.BitmapLoader bitmapLoader;
        CallbackT callback;
        final Context context;
        Bundle extras;

        /* renamed from: id */
        String f377id;
        final Player player;

        @Nullable
        PendingIntent sessionActivity;

        public BuilderBase(Context context, Player player, CallbackT callbackt) {
            this.context = (Context) Assertions.checkNotNull(context);
            this.player = (Player) Assertions.checkNotNull(player);
            Assertions.checkArgument(player.canAdvertiseSession());
            this.f377id = "";
            this.callback = callbackt;
            this.extras = Bundle.EMPTY;
        }

        public abstract SessionT build();

        public BuilderT setBitmapLoader(androidx.media3.common.util.BitmapLoader bitmapLoader) {
            this.bitmapLoader = bitmapLoader;
            return this;
        }

        public BuilderT setCallback(CallbackT callbackt) {
            this.callback = (CallbackT) Assertions.checkNotNull(callbackt);
            return this;
        }

        public BuilderT setExtras(Bundle bundle) {
            this.extras = new Bundle((Bundle) Assertions.checkNotNull(bundle));
            return this;
        }

        public BuilderT setId(String str) {
            this.f377id = (String) Assertions.checkNotNull(str);
            return this;
        }

        public BuilderT setSessionActivity(PendingIntent pendingIntent) {
            this.sessionActivity = (PendingIntent) Assertions.checkNotNull(pendingIntent);
            return this;
        }
    }

    public interface Callback {
        p5.c0<List<MediaItem>> onAddMediaItems(MediaSession mediaSession, ControllerInfo controllerInfo, List<MediaItem> list);

        ConnectionResult onConnect(MediaSession mediaSession, ControllerInfo controllerInfo);

        p5.c0<SessionResult> onCustomCommand(MediaSession mediaSession, ControllerInfo controllerInfo, SessionCommand sessionCommand, Bundle bundle);

        void onDisconnected(MediaSession mediaSession, ControllerInfo controllerInfo);

        @UnstableApi
        p5.c0<MediaItemsWithStartPosition> onPlaybackResumption(MediaSession mediaSession, ControllerInfo controllerInfo);

        @Deprecated
        int onPlayerCommandRequest(MediaSession mediaSession, ControllerInfo controllerInfo, int i10);

        void onPostConnect(MediaSession mediaSession, ControllerInfo controllerInfo);

        @UnstableApi
        p5.c0<MediaItemsWithStartPosition> onSetMediaItems(MediaSession mediaSession, ControllerInfo controllerInfo, List<MediaItem> list, int i10, long j10);

        p5.c0<SessionResult> onSetRating(MediaSession mediaSession, ControllerInfo controllerInfo, Rating rating);

        p5.c0<SessionResult> onSetRating(MediaSession mediaSession, ControllerInfo controllerInfo, String str, Rating rating);
    }

    public static final class ConnectionResult {
        public final Player.Commands availablePlayerCommands;
        public final SessionCommands availableSessionCommands;
        public final boolean isAccepted;

        private ConnectionResult(boolean z10, SessionCommands sessionCommands, Player.Commands commands) {
            this.isAccepted = z10;
            this.availableSessionCommands = (SessionCommands) Assertions.checkNotNull(sessionCommands);
            this.availablePlayerCommands = (Player.Commands) Assertions.checkNotNull(commands);
        }

        public static ConnectionResult accept(SessionCommands sessionCommands, Player.Commands commands) {
            return new ConnectionResult(true, sessionCommands, commands);
        }

        public static ConnectionResult reject() {
            return new ConnectionResult(false, SessionCommands.EMPTY, Player.Commands.EMPTY);
        }
    }

    public interface ControllerCb {
        void onAudioAttributesChanged(int i10, AudioAttributes audioAttributes) throws RemoteException;

        void onAvailableCommandsChangedFromPlayer(int i10, Player.Commands commands) throws RemoteException;

        void onAvailableCommandsChangedFromSession(int i10, SessionCommands sessionCommands, Player.Commands commands) throws RemoteException;

        void onChildrenChanged(int i10, String str, int i11, @Nullable MediaLibraryService.LibraryParams libraryParams) throws RemoteException;

        void onDeviceInfoChanged(int i10, DeviceInfo deviceInfo) throws RemoteException;

        void onDeviceVolumeChanged(int i10, int i11, boolean z10) throws RemoteException;

        void onDisconnected(int i10) throws RemoteException;

        void onIsLoadingChanged(int i10, boolean z10) throws RemoteException;

        void onIsPlayingChanged(int i10, boolean z10) throws RemoteException;

        void onLibraryResult(int i10, LibraryResult<?> libraryResult) throws RemoteException;

        void onMediaItemTransition(int i10, @Nullable MediaItem mediaItem, int i11) throws RemoteException;

        void onMediaMetadataChanged(int i10, MediaMetadata mediaMetadata) throws RemoteException;

        void onPeriodicSessionPositionInfoChanged(int i10, SessionPositionInfo sessionPositionInfo, boolean z10, boolean z11) throws RemoteException;

        void onPlayWhenReadyChanged(int i10, boolean z10, int i11) throws RemoteException;

        void onPlaybackParametersChanged(int i10, PlaybackParameters playbackParameters) throws RemoteException;

        void onPlaybackStateChanged(int i10, int i11, @Nullable PlaybackException playbackException) throws RemoteException;

        void onPlaybackSuppressionReasonChanged(int i10, int i11) throws RemoteException;

        void onPlayerChanged(int i10, @Nullable PlayerWrapper playerWrapper, PlayerWrapper playerWrapper2) throws RemoteException;

        void onPlayerError(int i10, @Nullable PlaybackException playbackException) throws RemoteException;

        void onPlayerInfoChanged(int i10, PlayerInfo playerInfo, Player.Commands commands, boolean z10, boolean z11, int i11) throws RemoteException;

        void onPlaylistMetadataChanged(int i10, MediaMetadata mediaMetadata) throws RemoteException;

        void onPositionDiscontinuity(int i10, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i11) throws RemoteException;

        void onRenderedFirstFrame(int i10) throws RemoteException;

        void onRepeatModeChanged(int i10, int i11) throws RemoteException;

        void onSearchResultChanged(int i10, String str, int i11, @Nullable MediaLibraryService.LibraryParams libraryParams) throws RemoteException;

        void onSeekBackIncrementChanged(int i10, long j10) throws RemoteException;

        void onSeekForwardIncrementChanged(int i10, long j10) throws RemoteException;

        void onSessionActivityChanged(int i10, PendingIntent pendingIntent) throws RemoteException;

        void onSessionExtrasChanged(int i10, Bundle bundle) throws RemoteException;

        void onSessionResult(int i10, SessionResult sessionResult) throws RemoteException;

        void onShuffleModeEnabledChanged(int i10, boolean z10) throws RemoteException;

        void onTimelineChanged(int i10, Timeline timeline, int i11) throws RemoteException;

        void onTrackSelectionParametersChanged(int i10, TrackSelectionParameters trackSelectionParameters) throws RemoteException;

        void onTracksChanged(int i10, Tracks tracks) throws RemoteException;

        void onVideoSizeChanged(int i10, VideoSize videoSize) throws RemoteException;

        void onVolumeChanged(int i10, float f10) throws RemoteException;

        void sendCustomCommand(int i10, SessionCommand sessionCommand, Bundle bundle) throws RemoteException;

        void setCustomLayout(int i10, List<CommandButton> list) throws RemoteException;
    }

    public static final class ControllerInfo {

        @UnstableApi
        public static final int LEGACY_CONTROLLER_INTERFACE_VERSION = 0;
        public static final int LEGACY_CONTROLLER_VERSION = 0;
        private final Bundle connectionHints;

        @Nullable
        private final ControllerCb controllerCb;
        private final int interfaceVersion;
        private final boolean isTrusted;
        private final int libraryVersion;
        private final MediaSessionManager.RemoteUserInfo remoteUserInfo;

        public ControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo, int i10, int i11, boolean z10, @Nullable ControllerCb controllerCb, Bundle bundle) {
            this.remoteUserInfo = remoteUserInfo;
            this.libraryVersion = i10;
            this.interfaceVersion = i11;
            this.isTrusted = z10;
            this.controllerCb = controllerCb;
            this.connectionHints = bundle;
        }

        public static ControllerInfo createLegacyControllerInfo() {
            return new ControllerInfo(new MediaSessionManager.RemoteUserInfo(MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER, -1, -1), 0, 0, false, null, Bundle.EMPTY);
        }

        @VisibleForTesting(otherwise = 2)
        public static ControllerInfo createTestOnlyControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo, int i10, int i11, boolean z10, Bundle bundle) {
            return new ControllerInfo(remoteUserInfo, i10, i11, z10, null, bundle);
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof ControllerInfo)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ControllerInfo controllerInfo = (ControllerInfo) obj;
            ControllerCb controllerCb = this.controllerCb;
            return (controllerCb == null && controllerInfo.controllerCb == null) ? this.remoteUserInfo.equals(controllerInfo.remoteUserInfo) : Util.areEqual(controllerCb, controllerInfo.controllerCb);
        }

        public Bundle getConnectionHints() {
            return new Bundle(this.connectionHints);
        }

        @Nullable
        public ControllerCb getControllerCb() {
            return this.controllerCb;
        }

        public int getControllerVersion() {
            return this.libraryVersion;
        }

        @UnstableApi
        public int getInterfaceVersion() {
            return this.interfaceVersion;
        }

        public String getPackageName() {
            return this.remoteUserInfo.getPackageName();
        }

        public MediaSessionManager.RemoteUserInfo getRemoteUserInfo() {
            return this.remoteUserInfo;
        }

        public int getUid() {
            return this.remoteUserInfo.getUid();
        }

        public int hashCode() {
            return r.b(this.controllerCb, this.remoteUserInfo);
        }

        public boolean isTrusted() {
            return this.isTrusted;
        }

        public String toString() {
            return "ControllerInfo {pkg=" + this.remoteUserInfo.getPackageName() + ", uid=" + this.remoteUserInfo.getUid() + "})";
        }
    }

    public interface Listener {
        void onNotificationRefreshRequired(MediaSession mediaSession);

        boolean onPlayRequested(MediaSession mediaSession);
    }

    @UnstableApi
    public static final class MediaItemsWithStartPosition {
        public final ImmutableList<MediaItem> mediaItems;
        public final int startIndex;
        public final long startPositionMs;

        public MediaItemsWithStartPosition(List<MediaItem> list, int i10, long j10) {
            this.mediaItems = ImmutableList.copyOf((Collection) list);
            this.startIndex = i10;
            this.startPositionMs = j10;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MediaItemsWithStartPosition)) {
                return false;
            }
            MediaItemsWithStartPosition mediaItemsWithStartPosition = (MediaItemsWithStartPosition) obj;
            return this.mediaItems.equals(mediaItemsWithStartPosition.mediaItems) && Util.areEqual(Integer.valueOf(this.startIndex), Integer.valueOf(mediaItemsWithStartPosition.startIndex)) && Util.areEqual(Long.valueOf(this.startPositionMs), Long.valueOf(mediaItemsWithStartPosition.startPositionMs));
        }

        public int hashCode() {
            return (((this.mediaItems.hashCode() * 31) + this.startIndex) * 31) + Longs.k(this.startPositionMs);
        }
    }

    static {
        MediaLibraryInfo.registerModule("media3.session");
        STATIC_LOCK = new Object();
        SESSION_ID_TO_SESSION_MAP = new HashMap<>();
    }

    public MediaSession(Context context, String str, Player player, @Nullable PendingIntent pendingIntent, Callback callback, Bundle bundle, androidx.media3.common.util.BitmapLoader bitmapLoader) {
        synchronized (STATIC_LOCK) {
            HashMap<String, MediaSession> hashMap = SESSION_ID_TO_SESSION_MAP;
            if (hashMap.containsKey(str)) {
                throw new IllegalStateException("Session ID must be unique. ID=" + str);
            }
            hashMap.put(str, this);
        }
        this.impl = createImpl(context, str, player, pendingIntent, callback, bundle, bitmapLoader);
    }

    @Nullable
    public static MediaSession getSession(Uri uri) {
        synchronized (STATIC_LOCK) {
            try {
                for (MediaSession mediaSession : SESSION_ID_TO_SESSION_MAP.values()) {
                    if (Util.areEqual(mediaSession.getUri(), uri)) {
                        return mediaSession;
                    }
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void broadcastCustomCommand(SessionCommand sessionCommand, Bundle bundle) {
        Assertions.checkNotNull(sessionCommand);
        Assertions.checkNotNull(bundle);
        Assertions.checkArgument(sessionCommand.commandCode == 0, "command must be a custom command");
        this.impl.broadcastCustomCommand(sessionCommand, bundle);
    }

    public final void clearListener() {
        this.impl.clearMediaSessionListener();
    }

    public MediaSessionImpl createImpl(Context context, String str, Player player, @Nullable PendingIntent pendingIntent, Callback callback, Bundle bundle, androidx.media3.common.util.BitmapLoader bitmapLoader) {
        return new MediaSessionImpl(this, context, str, player, pendingIntent, callback, bundle, bitmapLoader);
    }

    @UnstableApi
    public final androidx.media3.common.util.BitmapLoader getBitmapLoader() {
        return this.impl.getBitmapLoader();
    }

    public final List<ControllerInfo> getConnectedControllers() {
        return this.impl.getConnectedControllers();
    }

    @Nullable
    public final ControllerInfo getControllerForCurrentRequest() {
        return this.impl.getControllerForCurrentRequest();
    }

    public final String getId() {
        return this.impl.getId();
    }

    public MediaSessionImpl getImpl() {
        return this.impl;
    }

    public final IBinder getLegacyBrowserServiceBinder() {
        return this.impl.getLegacyBrowserServiceBinder();
    }

    public final Player getPlayer() {
        return this.impl.getPlayerWrapper().getWrappedPlayer();
    }

    @Nullable
    public final PendingIntent getSessionActivity() {
        return this.impl.getSessionActivity();
    }

    public final MediaSessionCompat getSessionCompat() {
        return this.impl.getSessionCompat();
    }

    @UnstableApi
    public final MediaSessionCompat.Token getSessionCompatToken() {
        return this.impl.getSessionCompat().getSessionToken();
    }

    public final SessionToken getToken() {
        return this.impl.getToken();
    }

    @VisibleForTesting
    public final Uri getUri() {
        return this.impl.getUri();
    }

    public final void handleControllerConnectionFromService(IMediaController iMediaController, int i10, int i11, String str, int i12, int i13, Bundle bundle) {
        this.impl.connectFromService(iMediaController, i10, i11, str, i12, i13, bundle);
    }

    public final boolean isReleased() {
        return this.impl.isReleased();
    }

    public final void release() {
        try {
            synchronized (STATIC_LOCK) {
                SESSION_ID_TO_SESSION_MAP.remove(this.impl.getId());
            }
            this.impl.release();
        } catch (Exception unused) {
        }
    }

    public final p5.c0<SessionResult> sendCustomCommand(ControllerInfo controllerInfo, SessionCommand sessionCommand, Bundle bundle) {
        Assertions.checkNotNull(controllerInfo);
        Assertions.checkNotNull(sessionCommand);
        Assertions.checkNotNull(bundle);
        Assertions.checkArgument(sessionCommand.commandCode == 0, "command must be a custom command");
        return this.impl.sendCustomCommand(controllerInfo, sessionCommand, bundle);
    }

    public final void setAvailableCommands(ControllerInfo controllerInfo, SessionCommands sessionCommands, Player.Commands commands) {
        Assertions.checkNotNull(controllerInfo, "controller must not be null");
        Assertions.checkNotNull(sessionCommands, "sessionCommands must not be null");
        Assertions.checkNotNull(commands, "playerCommands must not be null");
        this.impl.setAvailableCommands(controllerInfo, sessionCommands, commands);
    }

    public final p5.c0<SessionResult> setCustomLayout(ControllerInfo controllerInfo, List<CommandButton> list) {
        Assertions.checkNotNull(controllerInfo, "controller must not be null");
        Assertions.checkNotNull(list, "layout must not be null");
        return this.impl.setCustomLayout(controllerInfo, list);
    }

    public final void setLegacyControllerConnectionTimeoutMs(long j10) {
        this.impl.setLegacyControllerConnectionTimeoutMs(j10);
    }

    public final void setListener(Listener listener) {
        this.impl.setMediaSessionListener(listener);
    }

    public final void setPlayer(Player player) {
        Assertions.checkNotNull(player);
        Assertions.checkArgument(player.canAdvertiseSession());
        Assertions.checkArgument(player.getApplicationLooper() == getPlayer().getApplicationLooper());
        Assertions.checkState(player.getApplicationLooper() == Looper.myLooper());
        this.impl.setPlayer(player);
    }

    @UnstableApi
    public final void setSessionActivity(PendingIntent pendingIntent) {
        this.impl.setSessionActivity(pendingIntent);
    }

    public final void setSessionExtras(Bundle bundle) {
        Assertions.checkNotNull(bundle);
        this.impl.setSessionExtras(bundle);
    }

    @VisibleForTesting
    public final void setSessionPositionUpdateDelayMs(long j10) {
        this.impl.setSessionPositionUpdateDelayMsOnHandler(j10);
    }

    public final void setSessionExtras(ControllerInfo controllerInfo, Bundle bundle) {
        Assertions.checkNotNull(controllerInfo, "controller must not be null");
        Assertions.checkNotNull(bundle);
        this.impl.setSessionExtras(controllerInfo, bundle);
    }

    public final void setCustomLayout(List<CommandButton> list) {
        Assertions.checkNotNull(list, "layout must not be null");
        this.impl.setCustomLayout(list);
    }
}
