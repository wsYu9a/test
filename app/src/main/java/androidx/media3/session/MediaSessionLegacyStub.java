package androidx.media3.session;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;
import androidx.media.VolumeProviderCompat;
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
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionLegacyStub;
import com.google.common.collect.ImmutableList;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
class MediaSessionLegacyStub extends MediaSessionCompat.Callback {
    private static final int DEFAULT_CONNECTION_TIMEOUT_MS = 300000;
    private static final String DEFAULT_MEDIA_SESSION_TAG_DELIM = ".";
    private static final String DEFAULT_MEDIA_SESSION_TAG_PREFIX = "androidx.media3.session.id";
    private static final int PENDING_INTENT_FLAG_MUTABLE;
    private static final String TAG = "MediaSessionLegacyStub";
    private final String appPackageName;
    private final boolean canResumePlaybackOnStart;
    private final ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> connectedControllersManager;
    private final ConnectionTimeoutHandler connectionTimeoutHandler;
    private volatile long connectionTimeoutMs;
    private final MediaSession.ControllerCb controllerLegacyCbForBroadcast;
    private final MediaPlayPauseKeyHandler mediaPlayPauseKeyHandler;

    @Nullable
    private p5.x<Bitmap> pendingBitmapLoadCallback;

    @Nullable
    private final MediaButtonReceiver runtimeBroadcastReceiver;
    private final MediaSessionCompat sessionCompat;
    private int sessionFlags;
    private final MediaSessionImpl sessionImpl;
    private final MediaSessionManager sessionManager;

    @Nullable
    private VolumeProviderCompat volumeProviderCompat;

    /* renamed from: androidx.media3.session.MediaSessionLegacyStub$1 */
    public class AnonymousClass1 implements p5.x<MediaSession.MediaItemsWithStartPosition> {
        final /* synthetic */ MediaSession.ControllerInfo val$controller;
        final /* synthetic */ boolean val$play;

        public AnonymousClass1(MediaSession.ControllerInfo controllerInfo, boolean z10) {
            this.val$controller = controllerInfo;
            this.val$play = z10;
        }

        public /* synthetic */ void lambda$onSuccess$0(MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition, boolean z10) {
            PlayerWrapper playerWrapper = MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper();
            MediaUtils.setMediaItemsWithStartIndexAndPosition(playerWrapper, mediaItemsWithStartPosition);
            int playbackState = playerWrapper.getPlaybackState();
            if (playbackState == 1) {
                playerWrapper.prepareIfCommandAvailable();
            } else if (playbackState == 4) {
                playerWrapper.seekToDefaultPositionIfCommandAvailable();
            }
            if (z10) {
                playerWrapper.playIfCommandAvailable();
            }
        }

        @Override // p5.x
        public void onFailure(Throwable th2) {
        }

        @Override // p5.x
        public void onSuccess(MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition) {
            Util.postOrRun(MediaSessionLegacyStub.this.sessionImpl.getApplicationHandler(), MediaSessionLegacyStub.this.sessionImpl.callWithControllerForCurrentRequestSet(this.val$controller, new Runnable() { // from class: androidx.media3.session.ha

                /* renamed from: c */
                public final /* synthetic */ MediaSession.MediaItemsWithStartPosition f606c;

                /* renamed from: d */
                public final /* synthetic */ boolean f607d;

                public /* synthetic */ ha(MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition2, boolean z10) {
                    mediaItemsWithStartPosition = mediaItemsWithStartPosition2;
                    z10 = z10;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MediaSessionLegacyStub.AnonymousClass1.this.lambda$onSuccess$0(mediaItemsWithStartPosition, z10);
                }
            }));
        }
    }

    /* renamed from: androidx.media3.session.MediaSessionLegacyStub$2 */
    public class AnonymousClass2 implements p5.x<List<MediaItem>> {
        final /* synthetic */ MediaSession.ControllerInfo val$controller;
        final /* synthetic */ int val$index;

        public AnonymousClass2(MediaSession.ControllerInfo controllerInfo, int i10) {
            this.val$controller = controllerInfo;
            this.val$index = i10;
        }

        public /* synthetic */ void lambda$onSuccess$0(int i10, List list) {
            if (i10 == -1) {
                MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().addMediaItems(list);
            } else {
                MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().addMediaItems(i10, list);
            }
        }

        @Override // p5.x
        public void onFailure(Throwable th2) {
        }

        @Override // p5.x
        public void onSuccess(List<MediaItem> list) {
            Util.postOrRun(MediaSessionLegacyStub.this.sessionImpl.getApplicationHandler(), MediaSessionLegacyStub.this.sessionImpl.callWithControllerForCurrentRequestSet(this.val$controller, new Runnable() { // from class: androidx.media3.session.ia

                /* renamed from: c */
                public final /* synthetic */ int f634c;

                /* renamed from: d */
                public final /* synthetic */ List f635d;

                public /* synthetic */ ia(int i10, List list2) {
                    i10 = i10;
                    list = list2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MediaSessionLegacyStub.AnonymousClass2.this.lambda$onSuccess$0(i10, list);
                }
            }));
        }
    }

    public static class ConnectionTimeoutHandler extends Handler {
        private static final int MSG_CONNECTION_TIMED_OUT = 1001;
        private final ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> connectedControllersManager;

        public ConnectionTimeoutHandler(Looper looper, ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> connectedControllersManager) {
            super(looper);
            this.connectedControllersManager = connectedControllersManager;
        }

        public void disconnectControllerAfterTimeout(MediaSession.ControllerInfo controllerInfo, long j10) {
            removeMessages(1001, controllerInfo);
            sendMessageDelayed(obtainMessage(1001, controllerInfo), j10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MediaSession.ControllerInfo controllerInfo = (MediaSession.ControllerInfo) message.obj;
            if (this.connectedControllersManager.isConnected(controllerInfo)) {
                try {
                    ((MediaSession.ControllerCb) Assertions.checkStateNotNull(controllerInfo.getControllerCb())).onDisconnected(0);
                } catch (RemoteException unused) {
                }
                this.connectedControllersManager.removeController(controllerInfo);
            }
        }
    }

    public static final class ControllerLegacyCb implements MediaSession.ControllerCb {
        private final MediaSessionManager.RemoteUserInfo remoteUserInfo;

        public ControllerLegacyCb(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.remoteUserInfo = remoteUserInfo;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != ControllerLegacyCb.class) {
                return false;
            }
            return Util.areEqual(this.remoteUserInfo, ((ControllerLegacyCb) obj).remoteUserInfo);
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.remoteUserInfo);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onAudioAttributesChanged(int i10, AudioAttributes audioAttributes) {
            o7.a(this, i10, audioAttributes);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onAvailableCommandsChangedFromPlayer(int i10, Player.Commands commands) {
            o7.b(this, i10, commands);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onAvailableCommandsChangedFromSession(int i10, SessionCommands sessionCommands, Player.Commands commands) {
            o7.c(this, i10, sessionCommands, commands);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onChildrenChanged(int i10, String str, int i11, MediaLibraryService.LibraryParams libraryParams) {
            o7.d(this, i10, str, i11, libraryParams);
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
        public /* synthetic */ void onDisconnected(int i10) {
            o7.g(this, i10);
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
        public /* synthetic */ void onLibraryResult(int i10, LibraryResult libraryResult) {
            o7.j(this, i10, libraryResult);
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
        public /* synthetic */ void onPeriodicSessionPositionInfoChanged(int i10, SessionPositionInfo sessionPositionInfo, boolean z10, boolean z11) {
            o7.m(this, i10, sessionPositionInfo, z10, z11);
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
        public /* synthetic */ void onPlayerInfoChanged(int i10, PlayerInfo playerInfo, Player.Commands commands, boolean z10, boolean z11, int i11) {
            o7.t(this, i10, playerInfo, commands, z10, z11, i11);
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
        public /* synthetic */ void onRenderedFirstFrame(int i10) {
            o7.w(this, i10);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onRepeatModeChanged(int i10, int i11) {
            o7.x(this, i10, i11);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onSearchResultChanged(int i10, String str, int i11, MediaLibraryService.LibraryParams libraryParams) {
            o7.y(this, i10, str, i11, libraryParams);
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
        public /* synthetic */ void onSessionActivityChanged(int i10, PendingIntent pendingIntent) {
            o7.B(this, i10, pendingIntent);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onSessionExtrasChanged(int i10, Bundle bundle) {
            o7.C(this, i10, bundle);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onSessionResult(int i10, SessionResult sessionResult) {
            o7.D(this, i10, sessionResult);
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
        public /* synthetic */ void sendCustomCommand(int i10, SessionCommand sessionCommand, Bundle bundle) {
            o7.K(this, i10, sessionCommand, bundle);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void setCustomLayout(int i10, List list) {
            o7.L(this, i10, list);
        }
    }

    public final class ControllerLegacyCbForBroadcast implements MediaSession.ControllerCb {

        @Nullable
        private Uri lastMediaUri;
        private MediaMetadata lastMediaMetadata = MediaMetadata.EMPTY;
        private String lastMediaId = "";
        private long lastDurationMs = C.TIME_UNSET;

        /* renamed from: androidx.media3.session.MediaSessionLegacyStub$ControllerLegacyCbForBroadcast$1 */
        public class AnonymousClass1 implements p5.x<Bitmap> {
            final /* synthetic */ long val$newDurationMs;
            final /* synthetic */ String val$newMediaId;
            final /* synthetic */ MediaMetadata val$newMediaMetadata;
            final /* synthetic */ Uri val$newMediaUri;

            public AnonymousClass1(MediaMetadata mediaMetadata, String str, Uri uri, long j10) {
                mediaMetadataWithCommandCheck = mediaMetadata;
                str = str;
                uri2 = uri;
                durationWithCommandCheck = j10;
            }

            @Override // p5.x
            public void onFailure(Throwable th2) {
                if (this != MediaSessionLegacyStub.this.pendingBitmapLoadCallback) {
                    return;
                }
                Log.w(MediaSessionLegacyStub.TAG, MediaSessionLegacyStub.getBitmapLoadErrorMessage(th2));
            }

            @Override // p5.x
            public void onSuccess(Bitmap bitmap) {
                if (this != MediaSessionLegacyStub.this.pendingBitmapLoadCallback) {
                    return;
                }
                MediaSessionLegacyStub.setMetadata(MediaSessionLegacyStub.this.sessionCompat, MediaUtils.convertToMediaMetadataCompat(mediaMetadataWithCommandCheck, str, uri2, durationWithCommandCheck, bitmap));
                MediaSessionLegacyStub.this.sessionImpl.onNotificationRefreshRequired();
            }
        }

        public ControllerLegacyCbForBroadcast() {
        }

        private void handleBitmapFuturesAllCompletedAndSetQueue(List<p5.c0<Bitmap>> list, Timeline timeline, List<MediaItem> list2) {
            Bitmap bitmap;
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < list.size(); i10++) {
                p5.c0<Bitmap> c0Var = list.get(i10);
                if (c0Var != null) {
                    try {
                        bitmap = (Bitmap) com.google.common.util.concurrent.l.h(c0Var);
                    } catch (CancellationException | ExecutionException e10) {
                        Log.d(MediaSessionLegacyStub.TAG, "Failed to get bitmap", e10);
                    }
                    arrayList.add(MediaUtils.convertToQueueItem(list2.get(i10), i10, bitmap));
                }
                bitmap = null;
                arrayList.add(MediaUtils.convertToQueueItem(list2.get(i10), i10, bitmap));
            }
            if (Util.SDK_INT >= 21) {
                MediaSessionLegacyStub.this.sessionCompat.setQueue(arrayList);
                return;
            }
            List<MediaSessionCompat.QueueItem> truncateListBySize = MediaUtils.truncateListBySize(arrayList, 262144);
            if (truncateListBySize.size() != timeline.getWindowCount()) {
                Log.i(MediaSessionLegacyStub.TAG, "Sending " + truncateListBySize.size() + " items out of " + timeline.getWindowCount());
            }
            MediaSessionLegacyStub.this.sessionCompat.setQueue(truncateListBySize);
        }

        public /* synthetic */ void lambda$updateQueue$0(AtomicInteger atomicInteger, List list, List list2, Timeline timeline) {
            if (atomicInteger.incrementAndGet() == list.size()) {
                handleBitmapFuturesAllCompletedAndSetQueue(list2, timeline, list);
            }
        }

        private void updateMetadataIfChanged() {
            Bitmap bitmap;
            MediaItem.LocalConfiguration localConfiguration;
            PlayerWrapper playerWrapper = MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper();
            MediaItem currentMediaItemWithCommandCheck = playerWrapper.getCurrentMediaItemWithCommandCheck();
            MediaMetadata mediaMetadataWithCommandCheck = playerWrapper.getMediaMetadataWithCommandCheck();
            long durationWithCommandCheck = playerWrapper.getDurationWithCommandCheck();
            String str = currentMediaItemWithCommandCheck != null ? currentMediaItemWithCommandCheck.mediaId : "";
            Uri uri = (currentMediaItemWithCommandCheck == null || (localConfiguration = currentMediaItemWithCommandCheck.localConfiguration) == null) ? null : localConfiguration.uri;
            if (Objects.equals(this.lastMediaMetadata, mediaMetadataWithCommandCheck) && Objects.equals(this.lastMediaId, str) && Objects.equals(this.lastMediaUri, uri) && this.lastDurationMs == durationWithCommandCheck) {
                return;
            }
            this.lastMediaId = str;
            this.lastMediaUri = uri;
            this.lastMediaMetadata = mediaMetadataWithCommandCheck;
            this.lastDurationMs = durationWithCommandCheck;
            p5.c0<Bitmap> loadBitmapFromMetadata = MediaSessionLegacyStub.this.sessionImpl.getBitmapLoader().loadBitmapFromMetadata(mediaMetadataWithCommandCheck);
            if (loadBitmapFromMetadata != null) {
                MediaSessionLegacyStub.this.pendingBitmapLoadCallback = null;
                if (loadBitmapFromMetadata.isDone()) {
                    try {
                        bitmap = (Bitmap) com.google.common.util.concurrent.l.h(loadBitmapFromMetadata);
                    } catch (ExecutionException e10) {
                        Log.w(MediaSessionLegacyStub.TAG, MediaSessionLegacyStub.getBitmapLoadErrorMessage(e10));
                    }
                    MediaSessionLegacyStub.setMetadata(MediaSessionLegacyStub.this.sessionCompat, MediaUtils.convertToMediaMetadataCompat(mediaMetadataWithCommandCheck, str, uri, durationWithCommandCheck, bitmap));
                }
                MediaSessionLegacyStub.this.pendingBitmapLoadCallback = new p5.x<Bitmap>() { // from class: androidx.media3.session.MediaSessionLegacyStub.ControllerLegacyCbForBroadcast.1
                    final /* synthetic */ long val$newDurationMs;
                    final /* synthetic */ String val$newMediaId;
                    final /* synthetic */ MediaMetadata val$newMediaMetadata;
                    final /* synthetic */ Uri val$newMediaUri;

                    public AnonymousClass1(MediaMetadata mediaMetadataWithCommandCheck2, String str2, Uri uri2, long durationWithCommandCheck2) {
                        mediaMetadataWithCommandCheck = mediaMetadataWithCommandCheck2;
                        str = str2;
                        uri2 = uri2;
                        durationWithCommandCheck = durationWithCommandCheck2;
                    }

                    @Override // p5.x
                    public void onFailure(Throwable th2) {
                        if (this != MediaSessionLegacyStub.this.pendingBitmapLoadCallback) {
                            return;
                        }
                        Log.w(MediaSessionLegacyStub.TAG, MediaSessionLegacyStub.getBitmapLoadErrorMessage(th2));
                    }

                    @Override // p5.x
                    public void onSuccess(Bitmap bitmap2) {
                        if (this != MediaSessionLegacyStub.this.pendingBitmapLoadCallback) {
                            return;
                        }
                        MediaSessionLegacyStub.setMetadata(MediaSessionLegacyStub.this.sessionCompat, MediaUtils.convertToMediaMetadataCompat(mediaMetadataWithCommandCheck, str, uri2, durationWithCommandCheck, bitmap2));
                        MediaSessionLegacyStub.this.sessionImpl.onNotificationRefreshRequired();
                    }
                };
                p5.x xVar = MediaSessionLegacyStub.this.pendingBitmapLoadCallback;
                Handler applicationHandler = MediaSessionLegacyStub.this.sessionImpl.getApplicationHandler();
                Objects.requireNonNull(applicationHandler);
                com.google.common.util.concurrent.l.a(loadBitmapFromMetadata, xVar, new g0.a(applicationHandler));
            }
            bitmap = null;
            MediaSessionLegacyStub.setMetadata(MediaSessionLegacyStub.this.sessionCompat, MediaUtils.convertToMediaMetadataCompat(mediaMetadataWithCommandCheck2, str2, uri2, durationWithCommandCheck2, bitmap));
        }

        private void updateQueue(Timeline timeline) {
            List<MediaItem> convertToMediaItemList = MediaUtils.convertToMediaItemList(timeline);
            ArrayList arrayList = new ArrayList();
            ja jaVar = new Runnable() { // from class: androidx.media3.session.ja

                /* renamed from: c */
                public final /* synthetic */ AtomicInteger f662c;

                /* renamed from: d */
                public final /* synthetic */ List f663d;

                /* renamed from: e */
                public final /* synthetic */ List f664e;

                /* renamed from: f */
                public final /* synthetic */ Timeline f665f;

                public /* synthetic */ ja(AtomicInteger atomicInteger, List convertToMediaItemList2, List arrayList2, Timeline timeline2) {
                    atomicInteger = atomicInteger;
                    convertToMediaItemList = convertToMediaItemList2;
                    arrayList = arrayList2;
                    timeline = timeline2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MediaSessionLegacyStub.ControllerLegacyCbForBroadcast.this.lambda$updateQueue$0(atomicInteger, convertToMediaItemList, arrayList, timeline);
                }
            };
            for (int i10 = 0; i10 < convertToMediaItemList2.size(); i10++) {
                MediaMetadata mediaMetadata = convertToMediaItemList2.get(i10).mediaMetadata;
                if (mediaMetadata.artworkData == null) {
                    arrayList2.add(null);
                    jaVar.run();
                } else {
                    p5.c0<Bitmap> decodeBitmap = MediaSessionLegacyStub.this.sessionImpl.getBitmapLoader().decodeBitmap(mediaMetadata.artworkData);
                    arrayList2.add(decodeBitmap);
                    Handler applicationHandler = MediaSessionLegacyStub.this.sessionImpl.getApplicationHandler();
                    Objects.requireNonNull(applicationHandler);
                    decodeBitmap.addListener(jaVar, new g0.a(applicationHandler));
                }
            }
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onAudioAttributesChanged(int i10, AudioAttributes audioAttributes) {
            if (MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().getDeviceInfo().playbackType == 0) {
                MediaSessionLegacyStub.this.sessionCompat.setPlaybackToLocal(MediaUtils.getLegacyStreamType(audioAttributes));
            }
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onAvailableCommandsChangedFromPlayer(int i10, Player.Commands commands) {
            PlayerWrapper playerWrapper = MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper();
            MediaSessionLegacyStub.this.maybeUpdateFlags(playerWrapper);
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setPlaybackState(playerWrapper.createPlaybackStateCompat());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onAvailableCommandsChangedFromSession(int i10, SessionCommands sessionCommands, Player.Commands commands) {
            o7.c(this, i10, sessionCommands, commands);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onChildrenChanged(int i10, String str, int i11, MediaLibraryService.LibraryParams libraryParams) {
            o7.d(this, i10, str, i11, libraryParams);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onDeviceInfoChanged(int i10, DeviceInfo deviceInfo) {
            PlayerWrapper playerWrapper = MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper();
            MediaSessionLegacyStub.this.volumeProviderCompat = playerWrapper.createVolumeProviderCompat();
            if (MediaSessionLegacyStub.this.volumeProviderCompat != null) {
                MediaSessionLegacyStub.this.sessionCompat.setPlaybackToRemote(MediaSessionLegacyStub.this.volumeProviderCompat);
            } else {
                MediaSessionLegacyStub.this.sessionCompat.setPlaybackToLocal(MediaUtils.getLegacyStreamType(playerWrapper.getAudioAttributesWithCommandCheck()));
            }
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onDeviceVolumeChanged(int i10, int i11, boolean z10) {
            if (MediaSessionLegacyStub.this.volumeProviderCompat != null) {
                VolumeProviderCompat volumeProviderCompat = MediaSessionLegacyStub.this.volumeProviderCompat;
                if (z10) {
                    i11 = 0;
                }
                volumeProviderCompat.setCurrentVolume(i11);
            }
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onDisconnected(int i10) throws RemoteException {
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onIsLoadingChanged(int i10, boolean z10) {
            o7.h(this, i10, z10);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onIsPlayingChanged(int i10, boolean z10) throws RemoteException {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().createPlaybackStateCompat());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onLibraryResult(int i10, LibraryResult libraryResult) {
            o7.j(this, i10, libraryResult);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onMediaItemTransition(int i10, @Nullable MediaItem mediaItem, int i11) throws RemoteException {
            updateMetadataIfChanged();
            if (mediaItem == null) {
                MediaSessionLegacyStub.this.sessionCompat.setRatingType(0);
            } else {
                MediaSessionLegacyStub.this.sessionCompat.setRatingType(MediaUtils.getRatingCompatStyle(mediaItem.mediaMetadata.userRating));
            }
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().createPlaybackStateCompat());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onMediaMetadataChanged(int i10, MediaMetadata mediaMetadata) {
            updateMetadataIfChanged();
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPeriodicSessionPositionInfoChanged(int i10, SessionPositionInfo sessionPositionInfo, boolean z10, boolean z11) throws RemoteException {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().createPlaybackStateCompat());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPlayWhenReadyChanged(int i10, boolean z10, int i11) throws RemoteException {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().createPlaybackStateCompat());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPlaybackParametersChanged(int i10, PlaybackParameters playbackParameters) throws RemoteException {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().createPlaybackStateCompat());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPlaybackStateChanged(int i10, int i11, @Nullable PlaybackException playbackException) throws RemoteException {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().createPlaybackStateCompat());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPlaybackSuppressionReasonChanged(int i10, int i11) throws RemoteException {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().createPlaybackStateCompat());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPlayerChanged(int i10, @Nullable PlayerWrapper playerWrapper, PlayerWrapper playerWrapper2) throws RemoteException {
            Timeline currentTimelineWithCommandCheck = playerWrapper2.getCurrentTimelineWithCommandCheck();
            if (playerWrapper == null || !Util.areEqual(playerWrapper.getCurrentTimelineWithCommandCheck(), currentTimelineWithCommandCheck)) {
                onTimelineChanged(i10, currentTimelineWithCommandCheck, 0);
            }
            MediaMetadata playlistMetadataWithCommandCheck = playerWrapper2.getPlaylistMetadataWithCommandCheck();
            if (playerWrapper == null || !Util.areEqual(playerWrapper.getPlaylistMetadataWithCommandCheck(), playlistMetadataWithCommandCheck)) {
                onPlaylistMetadataChanged(i10, playlistMetadataWithCommandCheck);
            }
            MediaMetadata mediaMetadataWithCommandCheck = playerWrapper2.getMediaMetadataWithCommandCheck();
            if (playerWrapper == null || !Util.areEqual(playerWrapper.getMediaMetadataWithCommandCheck(), mediaMetadataWithCommandCheck)) {
                onMediaMetadataChanged(i10, mediaMetadataWithCommandCheck);
            }
            if (playerWrapper == null || playerWrapper.getShuffleModeEnabled() != playerWrapper2.getShuffleModeEnabled()) {
                onShuffleModeEnabledChanged(i10, playerWrapper2.getShuffleModeEnabled());
            }
            if (playerWrapper == null || playerWrapper.getRepeatMode() != playerWrapper2.getRepeatMode()) {
                onRepeatModeChanged(i10, playerWrapper2.getRepeatMode());
            }
            onDeviceInfoChanged(i10, playerWrapper2.getDeviceInfo());
            MediaSessionLegacyStub.this.maybeUpdateFlags(playerWrapper2);
            MediaItem currentMediaItemWithCommandCheck = playerWrapper2.getCurrentMediaItemWithCommandCheck();
            if (playerWrapper == null || !Util.areEqual(playerWrapper.getCurrentMediaItemWithCommandCheck(), currentMediaItemWithCommandCheck)) {
                onMediaItemTransition(i10, currentMediaItemWithCommandCheck, 3);
            } else {
                MediaSessionLegacyStub.this.sessionCompat.setPlaybackState(playerWrapper2.createPlaybackStateCompat());
            }
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPlayerError(int i10, @Nullable PlaybackException playbackException) {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().createPlaybackStateCompat());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onPlayerInfoChanged(int i10, PlayerInfo playerInfo, Player.Commands commands, boolean z10, boolean z11, int i11) {
            o7.t(this, i10, playerInfo, commands, z10, z11, i11);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPlaylistMetadataChanged(int i10, MediaMetadata mediaMetadata) throws RemoteException {
            CharSequence queueTitle = MediaSessionLegacyStub.this.sessionCompat.getController().getQueueTitle();
            CharSequence charSequence = mediaMetadata.title;
            if (TextUtils.equals(queueTitle, charSequence)) {
                return;
            }
            MediaSessionLegacyStub.setQueueTitle(MediaSessionLegacyStub.this.sessionCompat, charSequence);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPositionDiscontinuity(int i10, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i11) throws RemoteException {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().createPlaybackStateCompat());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onRenderedFirstFrame(int i10) {
            o7.w(this, i10);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onRepeatModeChanged(int i10, int i11) throws RemoteException {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setRepeatMode(MediaUtils.convertToPlaybackStateCompatRepeatMode(i11));
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onSearchResultChanged(int i10, String str, int i11, MediaLibraryService.LibraryParams libraryParams) {
            o7.y(this, i10, str, i11, libraryParams);
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
        public /* synthetic */ void onSessionActivityChanged(int i10, PendingIntent pendingIntent) {
            o7.B(this, i10, pendingIntent);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onSessionExtrasChanged(int i10, Bundle bundle) {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setExtras(bundle);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onSessionResult(int i10, SessionResult sessionResult) {
            o7.D(this, i10, sessionResult);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onShuffleModeEnabledChanged(int i10, boolean z10) throws RemoteException {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setShuffleMode(MediaUtils.convertToPlaybackStateCompatShuffleMode(z10));
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onTimelineChanged(int i10, Timeline timeline, int i11) throws RemoteException {
            if (timeline.isEmpty()) {
                MediaSessionLegacyStub.setQueue(MediaSessionLegacyStub.this.sessionCompat, null);
            } else {
                updateQueue(timeline);
                updateMetadataIfChanged();
            }
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
        public void sendCustomCommand(int i10, SessionCommand sessionCommand, Bundle bundle) {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().sendSessionEvent(sessionCommand.customAction, bundle);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void setCustomLayout(int i10, List<CommandButton> list) {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().createPlaybackStateCompat());
        }
    }

    public final class MediaButtonReceiver extends BroadcastReceiver {
        private MediaButtonReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            KeyEvent keyEvent;
            if (Util.areEqual(intent.getAction(), "android.intent.action.MEDIA_BUTTON")) {
                Uri data = intent.getData();
                if (Util.areEqual(data, data) && (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) != null) {
                    MediaSessionLegacyStub.this.getSessionCompat().getController().dispatchMediaButtonEvent(keyEvent);
                }
            }
        }

        public /* synthetic */ MediaButtonReceiver(MediaSessionLegacyStub mediaSessionLegacyStub, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class MediaPlayPauseKeyHandler extends Handler {
        private static final int MSG_DOUBLE_TAP_TIMED_OUT = 1002;

        public MediaPlayPauseKeyHandler(Looper looper) {
            super(looper);
        }

        public void addPendingMediaPlayPauseKey(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            sendMessageDelayed(obtainMessage(1002, remoteUserInfo), ViewConfiguration.getDoubleTapTimeout());
        }

        public void clearPendingMediaPlayPauseKey() {
            removeMessages(1002);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MediaSessionLegacyStub.this.handleMediaPlayPauseOnHandler((MediaSessionManager.RemoteUserInfo) message.obj);
        }

        public boolean hasPendingMediaPlayPauseKey() {
            return hasMessages(1002);
        }
    }

    public interface SessionTask {
        void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException;
    }

    static {
        PENDING_INTENT_FLAG_MUTABLE = Util.SDK_INT >= 31 ? DownloadExpSwitchCode.BACK_CLEAR_DATA : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0063, code lost:
    
        if (r0 != null) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MediaSessionLegacyStub(androidx.media3.session.MediaSessionImpl r8, android.net.Uri r9, android.os.Handler r10) {
        /*
            r7 = this;
            r7.<init>()
            r7.sessionImpl = r8
            android.content.Context r1 = r8.getContext()
            java.lang.String r0 = r1.getPackageName()
            r7.appPackageName = r0
            androidx.media.MediaSessionManager r0 = androidx.media.MediaSessionManager.getSessionManager(r1)
            r7.sessionManager = r0
            androidx.media3.session.MediaSessionLegacyStub$ControllerLegacyCbForBroadcast r0 = new androidx.media3.session.MediaSessionLegacyStub$ControllerLegacyCbForBroadcast
            r0.<init>()
            r7.controllerLegacyCbForBroadcast = r0
            androidx.media3.session.MediaSessionLegacyStub$MediaPlayPauseKeyHandler r0 = new androidx.media3.session.MediaSessionLegacyStub$MediaPlayPauseKeyHandler
            android.os.Handler r2 = r8.getApplicationHandler()
            android.os.Looper r2 = r2.getLooper()
            r0.<init>(r2)
            r7.mediaPlayPauseKeyHandler = r0
            androidx.media3.session.ConnectedControllersManager r0 = new androidx.media3.session.ConnectedControllersManager
            r0.<init>(r8)
            r7.connectedControllersManager = r0
            r2 = 300000(0x493e0, double:1.482197E-318)
            r7.connectionTimeoutMs = r2
            androidx.media3.session.MediaSessionLegacyStub$ConnectionTimeoutHandler r2 = new androidx.media3.session.MediaSessionLegacyStub$ConnectionTimeoutHandler
            android.os.Handler r3 = r8.getApplicationHandler()
            android.os.Looper r3 = r3.getLooper()
            r2.<init>(r3, r0)
            r7.connectionTimeoutHandler = r2
            android.content.ComponentName r0 = queryPackageManagerForMediaButtonReceiver(r1)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L50
            r4 = 1
            goto L51
        L50:
            r4 = 0
        L51:
            r7.canResumePlaybackOnStart = r4
            if (r0 != 0) goto L66
            java.lang.String r0 = "androidx.media3.session.MediaLibraryService"
            android.content.ComponentName r0 = getServiceComponentByAction(r1, r0)
            if (r0 != 0) goto L63
            java.lang.String r0 = "androidx.media3.session.MediaSessionService"
            android.content.ComponentName r0 = getServiceComponentByAction(r1, r0)
        L63:
            if (r0 == 0) goto L66
            goto L67
        L66:
            r2 = 0
        L67:
            android.content.Intent r4 = new android.content.Intent
            java.lang.String r5 = "android.intent.action.MEDIA_BUTTON"
            r4.<init>(r5, r9)
            r6 = 0
            if (r0 != 0) goto La6
            androidx.media3.session.MediaSessionLegacyStub$MediaButtonReceiver r0 = new androidx.media3.session.MediaSessionLegacyStub$MediaButtonReceiver
            r0.<init>(r7, r6)
            r7.runtimeBroadcastReceiver = r0
            android.content.IntentFilter r2 = new android.content.IntentFilter
            r2.<init>(r5)
            java.lang.String r9 = r9.getScheme()
            java.lang.Object r9 = androidx.media3.common.util.Util.castNonNull(r9)
            java.lang.String r9 = (java.lang.String) r9
            r2.addDataScheme(r9)
            androidx.media3.common.util.Util.registerReceiverNotExported(r1, r0, r2)
            java.lang.String r9 = r1.getPackageName()
            r4.setPackage(r9)
            int r9 = androidx.media3.session.MediaSessionLegacyStub.PENDING_INTENT_FLAG_MUTABLE
            android.app.PendingIntent r9 = android.app.PendingIntent.getBroadcast(r1, r3, r4, r9)
            android.content.ComponentName r0 = new android.content.ComponentName
            java.lang.Class r2 = r1.getClass()
            r0.<init>(r1, r2)
        La3:
            r4 = r9
            r3 = r0
            goto Lc8
        La6:
            r4.setComponent(r0)
            if (r2 == 0) goto Lbf
            int r9 = androidx.media3.common.util.Util.SDK_INT
            r2 = 26
            if (r9 < r2) goto Lb8
            int r9 = androidx.media3.session.MediaSessionLegacyStub.PENDING_INTENT_FLAG_MUTABLE
            android.app.PendingIntent r9 = p0.b.a(r1, r3, r4, r9)
            goto Lc5
        Lb8:
            int r9 = androidx.media3.session.MediaSessionLegacyStub.PENDING_INTENT_FLAG_MUTABLE
            android.app.PendingIntent r9 = android.app.PendingIntent.getService(r1, r3, r4, r9)
            goto Lc5
        Lbf:
            int r9 = androidx.media3.session.MediaSessionLegacyStub.PENDING_INTENT_FLAG_MUTABLE
            android.app.PendingIntent r9 = android.app.PendingIntent.getBroadcast(r1, r3, r4, r9)
        Lc5:
            r7.runtimeBroadcastReceiver = r6
            goto La3
        Lc8:
            java.lang.String r9 = "androidx.media3.session.id"
            java.lang.String r0 = r8.getId()
            java.lang.String[] r9 = new java.lang.String[]{r9, r0}
            java.lang.String r0 = "."
            java.lang.String r2 = android.text.TextUtils.join(r0, r9)
            android.support.v4.media.session.MediaSessionCompat r9 = new android.support.v4.media.session.MediaSessionCompat
            androidx.media3.session.SessionToken r0 = r8.getToken()
            android.os.Bundle r5 = r0.getExtras()
            r0 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            r7.sessionCompat = r9
            android.app.PendingIntent r8 = r8.getSessionActivity()
            if (r8 == 0) goto Lf1
            r9.setSessionActivity(r8)
        Lf1:
            r9.setCallback(r7, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.MediaSessionLegacyStub.<init>(androidx.media3.session.MediaSessionImpl, android.net.Uri, android.os.Handler):void");
    }

    private static MediaItem createMediaItemForMediaRequest(@Nullable String str, @Nullable Uri uri, @Nullable String str2, @Nullable Bundle bundle) {
        MediaItem.Builder builder = new MediaItem.Builder();
        if (str == null) {
            str = "";
        }
        return builder.setMediaId(str).setRequestMetadata(new MediaItem.RequestMetadata.Builder().setMediaUri(uri).setSearchQuery(str2).setExtras(bundle).build()).build();
    }

    private void dispatchSessionTaskWithPlayerCommand(int i10, SessionTask sessionTask, @Nullable MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        if (this.sessionImpl.isReleased()) {
            return;
        }
        if (remoteUserInfo != null) {
            Util.postOrRun(this.sessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.r9

                /* renamed from: c */
                public final /* synthetic */ int f878c;

                /* renamed from: d */
                public final /* synthetic */ MediaSessionManager.RemoteUserInfo f879d;

                /* renamed from: e */
                public final /* synthetic */ MediaSessionLegacyStub.SessionTask f880e;

                public /* synthetic */ r9(int i102, MediaSessionManager.RemoteUserInfo remoteUserInfo2, MediaSessionLegacyStub.SessionTask sessionTask2) {
                    i10 = i102;
                    remoteUserInfo = remoteUserInfo2;
                    sessionTask = sessionTask2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MediaSessionLegacyStub.this.lambda$dispatchSessionTaskWithPlayerCommand$22(i10, remoteUserInfo, sessionTask);
                }
            });
            return;
        }
        Log.d(TAG, "RemoteUserInfo is null, ignoring command=" + i102);
    }

    private void dispatchSessionTaskWithSessionCommand(int i10, SessionTask sessionTask) {
        dispatchSessionTaskWithSessionCommandInternal(null, i10, sessionTask, this.sessionCompat.getCurrentControllerInfo());
    }

    private void dispatchSessionTaskWithSessionCommandInternal(@Nullable SessionCommand sessionCommand, int i10, SessionTask sessionTask, @Nullable MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        if (remoteUserInfo != null) {
            Util.postOrRun(this.sessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.w9

                /* renamed from: c */
                public final /* synthetic */ SessionCommand f1005c;

                /* renamed from: d */
                public final /* synthetic */ int f1006d;

                /* renamed from: e */
                public final /* synthetic */ MediaSessionManager.RemoteUserInfo f1007e;

                /* renamed from: f */
                public final /* synthetic */ MediaSessionLegacyStub.SessionTask f1008f;

                public /* synthetic */ w9(SessionCommand sessionCommand2, int i102, MediaSessionManager.RemoteUserInfo remoteUserInfo2, MediaSessionLegacyStub.SessionTask sessionTask2) {
                    sessionCommand = sessionCommand2;
                    i10 = i102;
                    remoteUserInfo = remoteUserInfo2;
                    sessionTask = sessionTask2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MediaSessionLegacyStub.this.lambda$dispatchSessionTaskWithSessionCommandInternal$23(sessionCommand, i10, remoteUserInfo, sessionTask);
                }
            });
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("RemoteUserInfo is null, ignoring command=");
        Object obj = sessionCommand2;
        if (sessionCommand2 == null) {
            obj = Integer.valueOf(i102);
        }
        sb2.append(obj);
        Log.d(TAG, sb2.toString());
    }

    public static String getBitmapLoadErrorMessage(Throwable th2) {
        return "Failed to load bitmap: " + th2.getMessage();
    }

    @Nullable
    private static ComponentName getServiceComponentByAction(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            return null;
        }
        ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
        return new ComponentName(serviceInfo.packageName, serviceInfo.name);
    }

    public void handleMediaPlayPauseOnHandler(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.mediaPlayPauseKeyHandler.clearPendingMediaPlayPauseKey();
        dispatchSessionTaskWithPlayerCommand(1, new SessionTask() { // from class: androidx.media3.session.fa
            public /* synthetic */ fa() {
            }

            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.lambda$handleMediaPlayPauseOnHandler$2(controllerInfo);
            }
        }, remoteUserInfo);
    }

    private void handleMediaRequest(MediaItem mediaItem, boolean z10) {
        dispatchSessionTaskWithPlayerCommand(31, new SessionTask() { // from class: androidx.media3.session.y9

            /* renamed from: b */
            public final /* synthetic */ MediaItem f1056b;

            /* renamed from: c */
            public final /* synthetic */ boolean f1057c;

            public /* synthetic */ y9(MediaItem mediaItem2, boolean z102) {
                mediaItem = mediaItem2;
                z10 = z102;
            }

            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.lambda$handleMediaRequest$24(mediaItem, z10, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    private void handleOnAddQueueItem(@Nullable MediaDescriptionCompat mediaDescriptionCompat, int i10) {
        if (mediaDescriptionCompat == null) {
            return;
        }
        dispatchSessionTaskWithPlayerCommand(20, new SessionTask() { // from class: androidx.media3.session.j9

            /* renamed from: b */
            public final /* synthetic */ MediaDescriptionCompat f659b;

            /* renamed from: c */
            public final /* synthetic */ int f660c;

            public /* synthetic */ j9(MediaDescriptionCompat mediaDescriptionCompat2, int i102) {
                mediaDescriptionCompat = mediaDescriptionCompat2;
                i10 = i102;
            }

            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.lambda$handleOnAddQueueItem$25(mediaDescriptionCompat, i10, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    private static <T> void ignoreFuture(Future<T> future) {
    }

    public static /* synthetic */ void lambda$dispatchSessionTaskWithPlayerCommand$21(SessionTask sessionTask, MediaSession.ControllerInfo controllerInfo) {
        try {
            sessionTask.run(controllerInfo);
        } catch (RemoteException e10) {
            Log.w(TAG, "Exception in " + controllerInfo, e10);
        }
    }

    public /* synthetic */ void lambda$dispatchSessionTaskWithPlayerCommand$22(int i10, MediaSessionManager.RemoteUserInfo remoteUserInfo, SessionTask sessionTask) {
        if (this.sessionImpl.isReleased()) {
            return;
        }
        if (this.sessionCompat.isActive()) {
            MediaSession.ControllerInfo tryGetController = tryGetController(remoteUserInfo);
            if (tryGetController != null && this.connectedControllersManager.isPlayerCommandAvailable(tryGetController, i10) && this.sessionImpl.onPlayerCommandRequestOnHandler(tryGetController, i10) == 0) {
                this.sessionImpl.callWithControllerForCurrentRequestSet(tryGetController, new Runnable() { // from class: androidx.media3.session.i9

                    /* renamed from: c */
                    public final /* synthetic */ MediaSession.ControllerInfo f632c;

                    public /* synthetic */ i9(MediaSession.ControllerInfo tryGetController2) {
                        tryGetController = tryGetController2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaSessionLegacyStub.lambda$dispatchSessionTaskWithPlayerCommand$21(MediaSessionLegacyStub.SessionTask.this, tryGetController);
                    }
                }).run();
                return;
            }
            return;
        }
        Log.w(TAG, "Ignore incoming player command before initialization. command=" + i10 + ", pid=" + remoteUserInfo.getPid());
    }

    public /* synthetic */ void lambda$dispatchSessionTaskWithSessionCommandInternal$23(SessionCommand sessionCommand, int i10, MediaSessionManager.RemoteUserInfo remoteUserInfo, SessionTask sessionTask) {
        if (this.sessionImpl.isReleased()) {
            return;
        }
        if (!this.sessionCompat.isActive()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Ignore incoming session command before initialization. command=");
            sb2.append(sessionCommand == null ? Integer.valueOf(i10) : sessionCommand.customAction);
            sb2.append(", pid=");
            sb2.append(remoteUserInfo.getPid());
            Log.w(TAG, sb2.toString());
            return;
        }
        MediaSession.ControllerInfo tryGetController = tryGetController(remoteUserInfo);
        if (tryGetController == null) {
            return;
        }
        if (sessionCommand != null) {
            if (!this.connectedControllersManager.isSessionCommandAvailable(tryGetController, sessionCommand)) {
                return;
            }
        } else if (!this.connectedControllersManager.isSessionCommandAvailable(tryGetController, i10)) {
            return;
        }
        try {
            sessionTask.run(tryGetController);
        } catch (RemoteException e10) {
            Log.w(TAG, "Exception in " + tryGetController, e10);
        }
    }

    public /* synthetic */ void lambda$handleMediaPlayPauseOnHandler$2(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        Util.handlePlayPauseButtonAction(this.sessionImpl.getPlayerWrapper());
    }

    public /* synthetic */ void lambda$handleMediaRequest$24(MediaItem mediaItem, boolean z10, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        com.google.common.util.concurrent.l.a(this.sessionImpl.onSetMediaItemsOnHandler(controllerInfo, ImmutableList.of(mediaItem), -1, C.TIME_UNSET), new AnonymousClass1(controllerInfo, z10), com.google.common.util.concurrent.p.c());
    }

    public /* synthetic */ void lambda$handleOnAddQueueItem$25(MediaDescriptionCompat mediaDescriptionCompat, int i10, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        if (TextUtils.isEmpty(mediaDescriptionCompat.getMediaId())) {
            Log.w(TAG, "onAddQueueItem(): Media ID shouldn't be empty");
        } else {
            com.google.common.util.concurrent.l.a(this.sessionImpl.onAddMediaItemsOnHandler(controllerInfo, ImmutableList.of(MediaUtils.convertToMediaItem(mediaDescriptionCompat))), new AnonymousClass2(controllerInfo, i10), com.google.common.util.concurrent.p.c());
        }
    }

    public /* synthetic */ void lambda$onCommand$0(SessionCommand sessionCommand, Bundle bundle, ResultReceiver resultReceiver, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        MediaSessionImpl mediaSessionImpl = this.sessionImpl;
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        p5.c0<SessionResult> onCustomCommandOnHandler = mediaSessionImpl.onCustomCommandOnHandler(controllerInfo, sessionCommand, bundle);
        if (resultReceiver != null) {
            sendCustomCommandResultWhenReady(resultReceiver, onCustomCommandOnHandler);
        } else {
            ignoreFuture(onCustomCommandOnHandler);
        }
    }

    public /* synthetic */ void lambda$onCustomAction$1(SessionCommand sessionCommand, Bundle bundle, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        MediaSessionImpl mediaSessionImpl = this.sessionImpl;
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        ignoreFuture(mediaSessionImpl.onCustomCommandOnHandler(controllerInfo, sessionCommand, bundle));
    }

    public /* synthetic */ void lambda$onFastForward$14(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekForward();
    }

    public /* synthetic */ void lambda$onPause$5(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        Util.handlePauseButtonAction(this.sessionImpl.getPlayerWrapper());
    }

    public /* synthetic */ void lambda$onPlay$4(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        if (this.sessionImpl.onPlayRequested()) {
            PlayerWrapper playerWrapper = this.sessionImpl.getPlayerWrapper();
            if (playerWrapper.getMediaItemCount() == 0) {
                this.sessionImpl.prepareAndPlayForPlaybackResumption(controllerInfo, playerWrapper);
            } else {
                Util.handlePlayButtonAction(playerWrapper);
            }
        }
    }

    public /* synthetic */ void lambda$onPrepare$3(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().prepare();
    }

    public /* synthetic */ void lambda$onRemoveQueueItem$19(MediaDescriptionCompat mediaDescriptionCompat, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        String mediaId = mediaDescriptionCompat.getMediaId();
        if (TextUtils.isEmpty(mediaId)) {
            Log.w(TAG, "onRemoveQueueItem(): Media ID shouldn't be null");
            return;
        }
        PlayerWrapper playerWrapper = this.sessionImpl.getPlayerWrapper();
        if (!playerWrapper.isCommandAvailable(17)) {
            Log.w(TAG, "Can't remove item by id without availabe COMMAND_GET_TIMELINE");
            return;
        }
        Timeline currentTimeline = playerWrapper.getCurrentTimeline();
        Timeline.Window window = new Timeline.Window();
        for (int i10 = 0; i10 < currentTimeline.getWindowCount(); i10++) {
            if (TextUtils.equals(currentTimeline.getWindow(i10, window).mediaItem.mediaId, mediaId)) {
                playerWrapper.removeMediaItem(i10);
                return;
            }
        }
    }

    public /* synthetic */ void lambda$onRemoveQueueItemAt$20(int i10, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        if (i10 < 0) {
            Log.w(TAG, "onRemoveQueueItem(): index shouldn't be negative");
        } else {
            this.sessionImpl.getPlayerWrapper().removeMediaItem(i10);
        }
    }

    public /* synthetic */ void lambda$onRewind$15(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekBack();
    }

    public /* synthetic */ void lambda$onSeekTo$7(long j10, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekTo(j10);
    }

    public /* synthetic */ void lambda$onSetPlaybackSpeed$12(float f10, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().setPlaybackSpeed(f10);
    }

    public /* synthetic */ void lambda$onSetRating$16(Rating rating, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        MediaItem currentMediaItemWithCommandCheck = this.sessionImpl.getPlayerWrapper().getCurrentMediaItemWithCommandCheck();
        if (currentMediaItemWithCommandCheck == null) {
            return;
        }
        ignoreFuture(this.sessionImpl.onSetRatingOnHandler(controllerInfo, currentMediaItemWithCommandCheck.mediaId, rating));
    }

    public /* synthetic */ void lambda$onSetRepeatMode$17(int i10, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().setRepeatMode(MediaUtils.convertToRepeatMode(i10));
    }

    public /* synthetic */ void lambda$onSetShuffleMode$18(int i10, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().setShuffleModeEnabled(MediaUtils.convertToShuffleModeEnabled(i10));
    }

    public /* synthetic */ void lambda$onSkipToNext$8(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekToNext();
    }

    public /* synthetic */ void lambda$onSkipToNext$9(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekToNextMediaItem();
    }

    public /* synthetic */ void lambda$onSkipToPrevious$10(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekToPrevious();
    }

    public /* synthetic */ void lambda$onSkipToPrevious$11(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekToPreviousMediaItem();
    }

    public /* synthetic */ void lambda$onSkipToQueueItem$13(long j10, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekToDefaultPosition((int) j10);
    }

    public /* synthetic */ void lambda$onStop$6(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().stop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void lambda$sendCustomCommandResultWhenReady$26(p5.c0 c0Var, ResultReceiver resultReceiver) {
        SessionResult sessionResult;
        try {
            sessionResult = (SessionResult) Assertions.checkNotNull((SessionResult) c0Var.get(), "SessionResult must not be null");
        } catch (InterruptedException e10) {
            e = e10;
            Log.w(TAG, "Custom command failed", e);
            sessionResult = new SessionResult(-1);
        } catch (CancellationException e11) {
            Log.w(TAG, "Custom command cancelled", e11);
            sessionResult = new SessionResult(1);
        } catch (ExecutionException e12) {
            e = e12;
            Log.w(TAG, "Custom command failed", e);
            sessionResult = new SessionResult(-1);
        }
        resultReceiver.send(sessionResult.resultCode, sessionResult.extras);
    }

    public void maybeUpdateFlags(PlayerWrapper playerWrapper) {
        int i10 = playerWrapper.isCommandAvailable(20) ? 4 : 0;
        if (this.sessionFlags != i10) {
            this.sessionFlags = i10;
            this.sessionCompat.setFlags(i10);
        }
    }

    @Nullable
    private static ComponentName queryPackageManagerForMediaButtonReceiver(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers.size() == 1) {
            ActivityInfo activityInfo = queryBroadcastReceivers.get(0).activityInfo;
            return new ComponentName(activityInfo.packageName, activityInfo.name);
        }
        if (queryBroadcastReceivers.isEmpty()) {
            return null;
        }
        throw new IllegalStateException("Expected 1 broadcast receiver that handles android.intent.action.MEDIA_BUTTON, found " + queryBroadcastReceivers.size());
    }

    private static void sendCustomCommandResultWhenReady(ResultReceiver resultReceiver, p5.c0<SessionResult> c0Var) {
        c0Var.addListener(new Runnable() { // from class: androidx.media3.session.v9

            /* renamed from: c */
            public final /* synthetic */ ResultReceiver f983c;

            public /* synthetic */ v9(ResultReceiver resultReceiver2) {
                resultReceiver = resultReceiver2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionLegacyStub.lambda$sendCustomCommandResultWhenReady$26(p5.c0.this, resultReceiver);
            }
        }, com.google.common.util.concurrent.p.c());
    }

    private static void setMediaButtonReceiver(MediaSessionCompat mediaSessionCompat, @Nullable PendingIntent pendingIntent) {
        mediaSessionCompat.setMediaButtonReceiver(pendingIntent);
    }

    public static void setMetadata(MediaSessionCompat mediaSessionCompat, @Nullable MediaMetadataCompat mediaMetadataCompat) {
        mediaSessionCompat.setMetadata(mediaMetadataCompat);
    }

    public static void setQueue(MediaSessionCompat mediaSessionCompat, @Nullable List<MediaSessionCompat.QueueItem> list) {
        mediaSessionCompat.setQueue(list);
    }

    public static void setQueueTitle(MediaSessionCompat mediaSessionCompat, @Nullable CharSequence charSequence) {
        mediaSessionCompat.setQueueTitle(charSequence);
    }

    @Nullable
    private MediaSession.ControllerInfo tryGetController(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        MediaSession.ControllerInfo controller = this.connectedControllersManager.getController(remoteUserInfo);
        if (controller == null) {
            ControllerLegacyCb controllerLegacyCb = new ControllerLegacyCb(remoteUserInfo);
            MediaSession.ControllerInfo controllerInfo = new MediaSession.ControllerInfo(remoteUserInfo, 0, 0, this.sessionManager.isTrustedForMediaControl(remoteUserInfo), controllerLegacyCb, Bundle.EMPTY);
            MediaSession.ConnectionResult onConnectOnHandler = this.sessionImpl.onConnectOnHandler(controllerInfo);
            if (!onConnectOnHandler.isAccepted) {
                try {
                    controllerLegacyCb.onDisconnected(0);
                    return null;
                } catch (RemoteException unused) {
                    return null;
                }
            }
            this.connectedControllersManager.addController(controllerInfo.getRemoteUserInfo(), controllerInfo, onConnectOnHandler.availableSessionCommands, onConnectOnHandler.availablePlayerCommands);
            controller = controllerInfo;
        }
        this.connectionTimeoutHandler.disconnectControllerAfterTimeout(controller, this.connectionTimeoutMs);
        return controller;
    }

    public boolean canResumePlaybackOnStart() {
        return this.canResumePlaybackOnStart;
    }

    public ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> getConnectedControllersManager() {
        return this.connectedControllersManager;
    }

    public MediaSession.ControllerCb getControllerLegacyCbForBroadcast() {
        return this.controllerLegacyCbForBroadcast;
    }

    public MediaSessionCompat getSessionCompat() {
        return this.sessionCompat;
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onAddQueueItem(@Nullable MediaDescriptionCompat mediaDescriptionCompat) {
        handleOnAddQueueItem(mediaDescriptionCompat, -1);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onCommand(String str, @Nullable Bundle bundle, @Nullable ResultReceiver resultReceiver) {
        Assertions.checkStateNotNull(str);
        if (TextUtils.equals("androidx.media3.session.SESSION_COMMAND_REQUEST_SESSION3_TOKEN", str) && resultReceiver != null) {
            resultReceiver.send(0, this.sessionImpl.getToken().toBundle());
        } else {
            SessionCommand sessionCommand = new SessionCommand(str, Bundle.EMPTY);
            dispatchSessionTaskWithSessionCommand(sessionCommand, new SessionTask() { // from class: androidx.media3.session.t9

                /* renamed from: b */
                public final /* synthetic */ SessionCommand f927b;

                /* renamed from: c */
                public final /* synthetic */ Bundle f928c;

                /* renamed from: d */
                public final /* synthetic */ ResultReceiver f929d;

                public /* synthetic */ t9(SessionCommand sessionCommand2, Bundle bundle2, ResultReceiver resultReceiver2) {
                    sessionCommand = sessionCommand2;
                    bundle = bundle2;
                    resultReceiver = resultReceiver2;
                }

                @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
                public final void run(MediaSession.ControllerInfo controllerInfo) {
                    MediaSessionLegacyStub.this.lambda$onCommand$0(sessionCommand, bundle, resultReceiver, controllerInfo);
                }
            });
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onCustomAction(String str, @Nullable Bundle bundle) {
        SessionCommand sessionCommand = new SessionCommand(str, Bundle.EMPTY);
        dispatchSessionTaskWithSessionCommand(sessionCommand, new SessionTask() { // from class: androidx.media3.session.l9

            /* renamed from: b */
            public final /* synthetic */ SessionCommand f721b;

            /* renamed from: c */
            public final /* synthetic */ Bundle f722c;

            public /* synthetic */ l9(SessionCommand sessionCommand2, Bundle bundle2) {
                sessionCommand = sessionCommand2;
                bundle = bundle2;
            }

            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.lambda$onCustomAction$1(sessionCommand, bundle, controllerInfo);
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onFastForward() {
        dispatchSessionTaskWithPlayerCommand(12, new SessionTask() { // from class: androidx.media3.session.g9
            public /* synthetic */ g9() {
            }

            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.lambda$onFastForward$14(controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public boolean onMediaButtonEvent(Intent intent) {
        KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (keyEvent == null || keyEvent.getAction() != 0) {
            return false;
        }
        MediaSessionManager.RemoteUserInfo currentControllerInfo = this.sessionCompat.getCurrentControllerInfo();
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 79 && keyCode != 85) {
            if (this.mediaPlayPauseKeyHandler.hasPendingMediaPlayPauseKey()) {
                handleMediaPlayPauseOnHandler(currentControllerInfo);
            }
            return false;
        }
        if (this.appPackageName.equals(currentControllerInfo.getPackageName()) || keyEvent.getRepeatCount() != 0) {
            handleMediaPlayPauseOnHandler(currentControllerInfo);
            return true;
        }
        if (!this.mediaPlayPauseKeyHandler.hasPendingMediaPlayPauseKey()) {
            this.mediaPlayPauseKeyHandler.addPendingMediaPlayPauseKey(currentControllerInfo);
            return true;
        }
        this.mediaPlayPauseKeyHandler.clearPendingMediaPlayPauseKey();
        onSkipToNext();
        return true;
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPause() {
        dispatchSessionTaskWithPlayerCommand(1, new SessionTask() { // from class: androidx.media3.session.ga
            public /* synthetic */ ga() {
            }

            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.lambda$onPause$5(controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlay() {
        dispatchSessionTaskWithPlayerCommand(1, new SessionTask() { // from class: androidx.media3.session.da
            public /* synthetic */ da() {
            }

            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.lambda$onPlay$4(controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlayFromMediaId(String str, @Nullable Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(str, null, null, bundle), true);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlayFromSearch(String str, @Nullable Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(null, null, str, bundle), true);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlayFromUri(Uri uri, @Nullable Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(null, uri, null, bundle), true);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepare() {
        dispatchSessionTaskWithPlayerCommand(2, new SessionTask() { // from class: androidx.media3.session.u9
            public /* synthetic */ u9() {
            }

            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.lambda$onPrepare$3(controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepareFromMediaId(String str, @Nullable Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(str, null, null, bundle), false);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepareFromSearch(String str, @Nullable Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(null, null, str, bundle), false);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepareFromUri(Uri uri, @Nullable Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(null, uri, null, bundle), false);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onRemoveQueueItem(@Nullable MediaDescriptionCompat mediaDescriptionCompat) {
        if (mediaDescriptionCompat == null) {
            return;
        }
        dispatchSessionTaskWithPlayerCommand(20, new SessionTask() { // from class: androidx.media3.session.m9

            /* renamed from: b */
            public final /* synthetic */ MediaDescriptionCompat f752b;

            public /* synthetic */ m9(MediaDescriptionCompat mediaDescriptionCompat2) {
                mediaDescriptionCompat = mediaDescriptionCompat2;
            }

            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.lambda$onRemoveQueueItem$19(mediaDescriptionCompat, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onRemoveQueueItemAt(int i10) {
        dispatchSessionTaskWithPlayerCommand(20, new SessionTask() { // from class: androidx.media3.session.z9

            /* renamed from: b */
            public final /* synthetic */ int f1079b;

            public /* synthetic */ z9(int i102) {
                i10 = i102;
            }

            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.lambda$onRemoveQueueItemAt$20(i10, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onRewind() {
        dispatchSessionTaskWithPlayerCommand(11, new SessionTask() { // from class: androidx.media3.session.s9
            public /* synthetic */ s9() {
            }

            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.lambda$onRewind$15(controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSeekTo(long j10) {
        dispatchSessionTaskWithPlayerCommand(5, new SessionTask() { // from class: androidx.media3.session.ca

            /* renamed from: b */
            public final /* synthetic */ long f456b;

            public /* synthetic */ ca(long j102) {
                j10 = j102;
            }

            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.lambda$onSeekTo$7(j10, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetCaptioningEnabled(boolean z10) {
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetPlaybackSpeed(float f10) {
        dispatchSessionTaskWithPlayerCommand(13, new SessionTask() { // from class: androidx.media3.session.h9

            /* renamed from: b */
            public final /* synthetic */ float f604b;

            public /* synthetic */ h9(float f102) {
                f10 = f102;
            }

            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.lambda$onSetPlaybackSpeed$12(f10, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetRating(RatingCompat ratingCompat) {
        onSetRating(ratingCompat, null);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetRepeatMode(int i10) {
        dispatchSessionTaskWithPlayerCommand(15, new SessionTask() { // from class: androidx.media3.session.q9

            /* renamed from: b */
            public final /* synthetic */ int f858b;

            public /* synthetic */ q9(int i102) {
                i10 = i102;
            }

            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.lambda$onSetRepeatMode$17(i10, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetShuffleMode(int i10) {
        dispatchSessionTaskWithPlayerCommand(14, new SessionTask() { // from class: androidx.media3.session.ea

            /* renamed from: b */
            public final /* synthetic */ int f514b;

            public /* synthetic */ ea(int i102) {
                i10 = i102;
            }

            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.lambda$onSetShuffleMode$18(i10, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSkipToNext() {
        if (this.sessionImpl.getPlayerWrapper().isCommandAvailable(9)) {
            dispatchSessionTaskWithPlayerCommand(9, new SessionTask() { // from class: androidx.media3.session.aa
                public /* synthetic */ aa() {
                }

                @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
                public final void run(MediaSession.ControllerInfo controllerInfo) {
                    MediaSessionLegacyStub.this.lambda$onSkipToNext$8(controllerInfo);
                }
            }, this.sessionCompat.getCurrentControllerInfo());
        } else {
            dispatchSessionTaskWithPlayerCommand(8, new SessionTask() { // from class: androidx.media3.session.ba
                public /* synthetic */ ba() {
                }

                @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
                public final void run(MediaSession.ControllerInfo controllerInfo) {
                    MediaSessionLegacyStub.this.lambda$onSkipToNext$9(controllerInfo);
                }
            }, this.sessionCompat.getCurrentControllerInfo());
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSkipToPrevious() {
        if (this.sessionImpl.getPlayerWrapper().isCommandAvailable(7)) {
            dispatchSessionTaskWithPlayerCommand(7, new SessionTask() { // from class: androidx.media3.session.n9
                public /* synthetic */ n9() {
                }

                @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
                public final void run(MediaSession.ControllerInfo controllerInfo) {
                    MediaSessionLegacyStub.this.lambda$onSkipToPrevious$10(controllerInfo);
                }
            }, this.sessionCompat.getCurrentControllerInfo());
        } else {
            dispatchSessionTaskWithPlayerCommand(6, new SessionTask() { // from class: androidx.media3.session.o9
                public /* synthetic */ o9() {
                }

                @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
                public final void run(MediaSession.ControllerInfo controllerInfo) {
                    MediaSessionLegacyStub.this.lambda$onSkipToPrevious$11(controllerInfo);
                }
            }, this.sessionCompat.getCurrentControllerInfo());
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSkipToQueueItem(long j10) {
        dispatchSessionTaskWithPlayerCommand(10, new SessionTask() { // from class: androidx.media3.session.k9

            /* renamed from: b */
            public final /* synthetic */ long f696b;

            public /* synthetic */ k9(long j102) {
                j10 = j102;
            }

            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.lambda$onSkipToQueueItem$13(j10, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onStop() {
        dispatchSessionTaskWithPlayerCommand(3, new SessionTask() { // from class: androidx.media3.session.x9
            public /* synthetic */ x9() {
            }

            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.lambda$onStop$6(controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    public void release() {
        if (!this.canResumePlaybackOnStart) {
            setMediaButtonReceiver(this.sessionCompat, null);
        }
        if (this.runtimeBroadcastReceiver != null) {
            this.sessionImpl.getContext().unregisterReceiver(this.runtimeBroadcastReceiver);
        }
        this.sessionCompat.release();
    }

    public void setLegacyControllerDisconnectTimeoutMs(long j10) {
        this.connectionTimeoutMs = j10;
    }

    public void start() {
        this.sessionCompat.setActive(true);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onAddQueueItem(@Nullable MediaDescriptionCompat mediaDescriptionCompat, int i10) {
        handleOnAddQueueItem(mediaDescriptionCompat, i10);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetRating(RatingCompat ratingCompat, @Nullable Bundle bundle) {
        Rating convertToRating = MediaUtils.convertToRating(ratingCompat);
        if (convertToRating != null) {
            dispatchSessionTaskWithSessionCommand(SessionCommand.COMMAND_CODE_SESSION_SET_RATING, new SessionTask() { // from class: androidx.media3.session.p9

                /* renamed from: b */
                public final /* synthetic */ Rating f836b;

                public /* synthetic */ p9(Rating convertToRating2) {
                    convertToRating = convertToRating2;
                }

                @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
                public final void run(MediaSession.ControllerInfo controllerInfo) {
                    MediaSessionLegacyStub.this.lambda$onSetRating$16(convertToRating, controllerInfo);
                }
            });
            return;
        }
        Log.w(TAG, "Ignoring invalid RatingCompat " + ratingCompat);
    }

    private void dispatchSessionTaskWithSessionCommand(SessionCommand sessionCommand, SessionTask sessionTask) {
        dispatchSessionTaskWithSessionCommandInternal(sessionCommand, 0, sessionTask, this.sessionCompat.getCurrentControllerInfo());
    }
}
