package androidx.media3.session;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaSessionManager;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaLibraryServiceLegacyStub;
import androidx.media3.session.MediaSession;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
class MediaLibraryServiceLegacyStub extends MediaSessionServiceLegacyStub {
    private static final String TAG = "MLSLegacyStub";
    private final MediaSession.ControllerCb browserLegacyCbForBroadcast;
    private final MediaLibrarySessionImpl librarySessionImpl;

    public final class BrowserLegacyCb implements MediaSession.ControllerCb {
        private final MediaSessionManager.RemoteUserInfo remoteUserInfo;
        private final Object lock = new Object();

        @GuardedBy("lock")
        private final List<SearchRequest> searchRequests = new ArrayList();

        public BrowserLegacyCb(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.remoteUserInfo = remoteUserInfo;
        }

        public /* synthetic */ void lambda$onSearchResultChanged$0(List list) {
            int i10;
            int i11;
            int i12;
            int i13;
            for (int i14 = 0; i14 < list.size(); i14++) {
                SearchRequest searchRequest = (SearchRequest) list.get(i14);
                Bundle bundle = searchRequest.extras;
                if (bundle != null) {
                    try {
                        bundle.setClassLoader(MediaLibraryServiceLegacyStub.this.librarySessionImpl.getContext().getClassLoader());
                        i10 = searchRequest.extras.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
                        i11 = searchRequest.extras.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
                    } catch (BadParcelableException unused) {
                        searchRequest.result.sendResult(null);
                        return;
                    }
                } else {
                    i10 = 0;
                    i11 = Integer.MAX_VALUE;
                }
                if (i10 < 0 || i11 < 1) {
                    i12 = 0;
                    i13 = Integer.MAX_VALUE;
                } else {
                    i12 = i10;
                    i13 = i11;
                }
                MediaLibraryServiceLegacyStub.sendLibraryResultWithMediaItemsWhenReady(searchRequest.result, Util.transformFutureAsync(MediaLibraryServiceLegacyStub.this.librarySessionImpl.onGetSearchResultOnHandler(searchRequest.controller, searchRequest.query, i12, i13, MediaUtils.convertToLibraryParams(MediaLibraryServiceLegacyStub.this.librarySessionImpl.getContext(), searchRequest.extras)), MediaLibraryServiceLegacyStub.this.createMediaItemsToBrowserItemsAsyncFunction()));
            }
        }

        public void registerSearchRequest(MediaSession.ControllerInfo controllerInfo, String str, @Nullable Bundle bundle, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
            synchronized (this.lock) {
                this.searchRequests.add(new SearchRequest(controllerInfo, controllerInfo.getRemoteUserInfo(), str, bundle, result));
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BrowserLegacyCb) {
                return Util.areEqual(this.remoteUserInfo, ((BrowserLegacyCb) obj).remoteUserInfo);
            }
            return false;
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
        public void onChildrenChanged(int i10, String str, int i11, @Nullable MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
            Bundle bundle = libraryParams != null ? libraryParams.extras : null;
            MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub = MediaLibraryServiceLegacyStub.this;
            MediaSessionManager.RemoteUserInfo remoteUserInfo = this.remoteUserInfo;
            if (bundle == null) {
                bundle = Bundle.EMPTY;
            }
            mediaLibraryServiceLegacyStub.notifyChildrenChanged(remoteUserInfo, str, bundle);
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
        public void onSearchResultChanged(int i10, String str, int i11, @Nullable MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
            ArrayList arrayList = new ArrayList();
            synchronized (this.lock) {
                try {
                    for (int size = this.searchRequests.size() - 1; size >= 0; size--) {
                        SearchRequest searchRequest = this.searchRequests.get(size);
                        if (Util.areEqual(this.remoteUserInfo, searchRequest.remoteUserInfo) && searchRequest.query.equals(str)) {
                            arrayList.add(searchRequest);
                            this.searchRequests.remove(size);
                        }
                    }
                    if (arrayList.size() == 0) {
                        return;
                    }
                    Util.postOrRun(MediaLibraryServiceLegacyStub.this.librarySessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.q6

                        /* renamed from: c */
                        public final /* synthetic */ List f854c;

                        public /* synthetic */ q6(List arrayList2) {
                            arrayList = arrayList2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            MediaLibraryServiceLegacyStub.BrowserLegacyCb.this.lambda$onSearchResultChanged$0(arrayList);
                        }
                    });
                } catch (Throwable th2) {
                    throw th2;
                }
            }
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

    public final class BrowserLegacyCbForBroadcast implements MediaSession.ControllerCb {
        private BrowserLegacyCbForBroadcast() {
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
        public void onChildrenChanged(int i10, String str, int i11, @Nullable MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
            Bundle bundle;
            if (libraryParams == null || (bundle = libraryParams.extras) == null) {
                MediaLibraryServiceLegacyStub.this.notifyChildrenChanged(str);
            } else {
                MediaLibraryServiceLegacyStub.this.notifyChildrenChanged(str, (Bundle) Util.castNonNull(bundle));
            }
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
        public void onSearchResultChanged(int i10, String str, int i11, @Nullable MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
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

        public /* synthetic */ BrowserLegacyCbForBroadcast(MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static class SearchRequest {
        public final MediaSession.ControllerInfo controller;

        @Nullable
        public final Bundle extras;
        public final String query;
        public final MediaSessionManager.RemoteUserInfo remoteUserInfo;
        public final MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result;

        public SearchRequest(MediaSession.ControllerInfo controllerInfo, MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, @Nullable Bundle bundle, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
            this.controller = controllerInfo;
            this.remoteUserInfo = remoteUserInfo;
            this.query = str;
            this.extras = bundle;
            this.result = result;
        }
    }

    public MediaLibraryServiceLegacyStub(MediaLibrarySessionImpl mediaLibrarySessionImpl) {
        super(mediaLibrarySessionImpl);
        this.librarySessionImpl = mediaLibrarySessionImpl;
        this.browserLegacyCbForBroadcast = new BrowserLegacyCbForBroadcast();
    }

    private static <T> void cancelAllFutures(List<p5.c0<T>> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (list.get(i10) != null) {
                list.get(i10).cancel(false);
            }
        }
    }

    private p5.f<LibraryResult<MediaItem>, MediaBrowserCompat.MediaItem> createMediaItemToBrowserItemAsyncFunction() {
        return new p5.f() { // from class: androidx.media3.session.b6
            public /* synthetic */ b6() {
            }

            @Override // p5.f
            public final p5.c0 apply(Object obj) {
                p5.c0 lambda$createMediaItemToBrowserItemAsyncFunction$15;
                lambda$createMediaItemToBrowserItemAsyncFunction$15 = MediaLibraryServiceLegacyStub.this.lambda$createMediaItemToBrowserItemAsyncFunction$15((LibraryResult) obj);
                return lambda$createMediaItemToBrowserItemAsyncFunction$15;
            }
        };
    }

    public p5.f<LibraryResult<ImmutableList<MediaItem>>, List<MediaBrowserCompat.MediaItem>> createMediaItemsToBrowserItemsAsyncFunction() {
        return new p5.f() { // from class: androidx.media3.session.l6
            public /* synthetic */ l6() {
            }

            @Override // p5.f
            public final p5.c0 apply(Object obj) {
                p5.c0 lambda$createMediaItemsToBrowserItemsAsyncFunction$12;
                lambda$createMediaItemsToBrowserItemsAsyncFunction$12 = MediaLibraryServiceLegacyStub.this.lambda$createMediaItemsToBrowserItemsAsyncFunction$12((LibraryResult) obj);
                return lambda$createMediaItemsToBrowserItemsAsyncFunction$12;
            }
        };
    }

    @Nullable
    private MediaSession.ControllerInfo getCurrentController() {
        return getConnectedControllersManager().getController(getCurrentBrowserInfo());
    }

    private void handleBitmapFuturesAllCompletedAndSetOutputFuture(List<p5.c0<Bitmap>> list, List<MediaItem> list2, com.google.common.util.concurrent.s<List<MediaBrowserCompat.MediaItem>> sVar) {
        Bitmap bitmap;
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            p5.c0<Bitmap> c0Var = list.get(i10);
            if (c0Var != null) {
                try {
                    bitmap = (Bitmap) com.google.common.util.concurrent.l.h(c0Var);
                } catch (CancellationException | ExecutionException e10) {
                    Log.d(TAG, "Failed to get bitmap", e10);
                }
                arrayList.add(MediaUtils.convertToBrowserItem(list2.get(i10), bitmap));
            }
            bitmap = null;
            arrayList.add(MediaUtils.convertToBrowserItem(list2.get(i10), bitmap));
        }
        sVar.set(arrayList);
    }

    private static <T> void ignoreFuture(Future<T> future) {
    }

    public static /* synthetic */ void lambda$createMediaItemToBrowserItemAsyncFunction$13(com.google.common.util.concurrent.s sVar, p5.c0 c0Var) {
        if (sVar.isCancelled()) {
            c0Var.cancel(false);
        }
    }

    public static /* synthetic */ void lambda$createMediaItemToBrowserItemAsyncFunction$14(p5.c0 c0Var, com.google.common.util.concurrent.s sVar, MediaItem mediaItem) {
        Bitmap bitmap;
        try {
            bitmap = (Bitmap) com.google.common.util.concurrent.l.h(c0Var);
        } catch (CancellationException | ExecutionException e10) {
            Log.d(TAG, "failed to get bitmap", e10);
            bitmap = null;
        }
        sVar.set(MediaUtils.convertToBrowserItem(mediaItem, bitmap));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ p5.c0 lambda$createMediaItemToBrowserItemAsyncFunction$15(LibraryResult libraryResult) throws Exception {
        V v10;
        Assertions.checkNotNull(libraryResult, "LibraryResult must not be null");
        com.google.common.util.concurrent.s n10 = com.google.common.util.concurrent.s.n();
        if (libraryResult.resultCode != 0 || (v10 = libraryResult.value) == 0) {
            n10.set(null);
            return n10;
        }
        MediaItem mediaItem = (MediaItem) v10;
        MediaMetadata mediaMetadata = mediaItem.mediaMetadata;
        if (mediaMetadata.artworkData == null) {
            n10.set(MediaUtils.convertToBrowserItem(mediaItem, null));
            return n10;
        }
        p5.c0<Bitmap> decodeBitmap = this.librarySessionImpl.getBitmapLoader().decodeBitmap(mediaMetadata.artworkData);
        n10.addListener(new Runnable() { // from class: androidx.media3.session.i6

            /* renamed from: c */
            public final /* synthetic */ p5.c0 f628c;

            public /* synthetic */ i6(p5.c0 decodeBitmap2) {
                decodeBitmap = decodeBitmap2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaLibraryServiceLegacyStub.lambda$createMediaItemToBrowserItemAsyncFunction$13(com.google.common.util.concurrent.s.this, decodeBitmap);
            }
        }, com.google.common.util.concurrent.p.c());
        decodeBitmap2.addListener(new Runnable() { // from class: androidx.media3.session.j6

            /* renamed from: c */
            public final /* synthetic */ com.google.common.util.concurrent.s f651c;

            /* renamed from: d */
            public final /* synthetic */ MediaItem f652d;

            public /* synthetic */ j6(com.google.common.util.concurrent.s n102, MediaItem mediaItem2) {
                n10 = n102;
                mediaItem = mediaItem2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaLibraryServiceLegacyStub.lambda$createMediaItemToBrowserItemAsyncFunction$14(p5.c0.this, n10, mediaItem);
            }
        }, com.google.common.util.concurrent.p.c());
        return n102;
    }

    public static /* synthetic */ void lambda$createMediaItemsToBrowserItemsAsyncFunction$10(com.google.common.util.concurrent.s sVar, List list) {
        if (sVar.isCancelled()) {
            cancelAllFutures(list);
        }
    }

    public /* synthetic */ void lambda$createMediaItemsToBrowserItemsAsyncFunction$11(AtomicInteger atomicInteger, ImmutableList immutableList, List list, com.google.common.util.concurrent.s sVar) {
        if (atomicInteger.incrementAndGet() == immutableList.size()) {
            handleBitmapFuturesAllCompletedAndSetOutputFuture(list, immutableList, sVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ p5.c0 lambda$createMediaItemsToBrowserItemsAsyncFunction$12(LibraryResult libraryResult) throws Exception {
        V v10;
        Assertions.checkNotNull(libraryResult, "LibraryResult must not be null");
        com.google.common.util.concurrent.s n10 = com.google.common.util.concurrent.s.n();
        if (libraryResult.resultCode != 0 || (v10 = libraryResult.value) == 0) {
            n10.set(null);
            return n10;
        }
        ImmutableList immutableList = (ImmutableList) v10;
        if (immutableList.isEmpty()) {
            n10.set(new ArrayList());
            return n10;
        }
        ArrayList arrayList = new ArrayList();
        n10.addListener(new Runnable() { // from class: androidx.media3.session.c6

            /* renamed from: c */
            public final /* synthetic */ List f449c;

            public /* synthetic */ c6(List arrayList2) {
                arrayList = arrayList2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaLibraryServiceLegacyStub.lambda$createMediaItemsToBrowserItemsAsyncFunction$10(com.google.common.util.concurrent.s.this, arrayList);
            }
        }, com.google.common.util.concurrent.p.c());
        d6 d6Var = new Runnable() { // from class: androidx.media3.session.d6

            /* renamed from: c */
            public final /* synthetic */ AtomicInteger f477c;

            /* renamed from: d */
            public final /* synthetic */ ImmutableList f478d;

            /* renamed from: e */
            public final /* synthetic */ List f479e;

            /* renamed from: f */
            public final /* synthetic */ com.google.common.util.concurrent.s f480f;

            public /* synthetic */ d6(AtomicInteger atomicInteger, ImmutableList immutableList2, List arrayList2, com.google.common.util.concurrent.s n102) {
                atomicInteger = atomicInteger;
                immutableList = immutableList2;
                arrayList = arrayList2;
                n10 = n102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaLibraryServiceLegacyStub.this.lambda$createMediaItemsToBrowserItemsAsyncFunction$11(atomicInteger, immutableList, arrayList, n10);
            }
        };
        for (int i10 = 0; i10 < immutableList2.size(); i10++) {
            MediaMetadata mediaMetadata = ((MediaItem) immutableList2.get(i10)).mediaMetadata;
            if (mediaMetadata.artworkData == null) {
                arrayList2.add(null);
                d6Var.run();
            } else {
                p5.c0<Bitmap> decodeBitmap = this.librarySessionImpl.getBitmapLoader().decodeBitmap(mediaMetadata.artworkData);
                arrayList2.add(decodeBitmap);
                decodeBitmap.addListener(d6Var, com.google.common.util.concurrent.p.c());
            }
        }
        return n102;
    }

    public /* synthetic */ void lambda$onCustomAction$6(String str, MediaSession.ControllerInfo controllerInfo, MediaBrowserServiceCompat.Result result, Bundle bundle) {
        SessionCommand sessionCommand = new SessionCommand(str, Bundle.EMPTY);
        if (getConnectedControllersManager().isSessionCommandAvailable(controllerInfo, sessionCommand)) {
            sendCustomActionResultWhenReady(result, this.librarySessionImpl.onCustomCommandOnHandler(controllerInfo, sessionCommand, bundle));
        } else {
            result.sendError(null);
        }
    }

    public /* synthetic */ void lambda$onGetRoot$0(AtomicReference atomicReference, MediaSession.ControllerInfo controllerInfo, MediaLibraryService.LibraryParams libraryParams, ConditionVariable conditionVariable) {
        atomicReference.set(this.librarySessionImpl.onGetLibraryRootOnHandler(controllerInfo, libraryParams));
        conditionVariable.open();
    }

    public /* synthetic */ void lambda$onLoadChildren$3(MediaSession.ControllerInfo controllerInfo, MediaBrowserServiceCompat.Result result, Bundle bundle, String str) {
        if (!getConnectedControllersManager().isSessionCommandAvailable(controllerInfo, SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN)) {
            result.sendError(null);
            return;
        }
        if (bundle != null) {
            bundle.setClassLoader(this.librarySessionImpl.getContext().getClassLoader());
            try {
                int i10 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE);
                int i11 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE);
                if (i10 >= 0 && i11 > 0) {
                    sendLibraryResultWithMediaItemsWhenReady(result, Util.transformFutureAsync(this.librarySessionImpl.onGetChildrenOnHandler(controllerInfo, str, i10, i11, MediaUtils.convertToLibraryParams(this.librarySessionImpl.getContext(), bundle)), createMediaItemsToBrowserItemsAsyncFunction()));
                    return;
                }
            } catch (BadParcelableException unused) {
            }
        }
        sendLibraryResultWithMediaItemsWhenReady(result, Util.transformFutureAsync(this.librarySessionImpl.onGetChildrenOnHandler(controllerInfo, str, 0, Integer.MAX_VALUE, null), createMediaItemsToBrowserItemsAsyncFunction()));
    }

    public /* synthetic */ void lambda$onLoadItem$4(MediaSession.ControllerInfo controllerInfo, MediaBrowserServiceCompat.Result result, String str) {
        if (getConnectedControllersManager().isSessionCommandAvailable(controllerInfo, SessionCommand.COMMAND_CODE_LIBRARY_GET_ITEM)) {
            sendLibraryResultWithMediaItemWhenReady(result, Util.transformFutureAsync(this.librarySessionImpl.onGetItemOnHandler(controllerInfo, str), createMediaItemToBrowserItemAsyncFunction()));
        } else {
            result.sendError(null);
        }
    }

    public /* synthetic */ void lambda$onSearch$5(MediaSession.ControllerInfo controllerInfo, MediaBrowserServiceCompat.Result result, String str, Bundle bundle) {
        if (!getConnectedControllersManager().isSessionCommandAvailable(controllerInfo, SessionCommand.COMMAND_CODE_LIBRARY_SEARCH)) {
            result.sendError(null);
            return;
        }
        ((BrowserLegacyCb) Assertions.checkStateNotNull(controllerInfo.getControllerCb())).registerSearchRequest(controllerInfo, str, bundle, result);
        ignoreFuture(this.librarySessionImpl.onSearchOnHandler(controllerInfo, str, MediaUtils.convertToLibraryParams(this.librarySessionImpl.getContext(), bundle)));
    }

    public /* synthetic */ void lambda$onSubscribe$1(MediaSession.ControllerInfo controllerInfo, Bundle bundle, String str) {
        if (getConnectedControllersManager().isSessionCommandAvailable(controllerInfo, SessionCommand.COMMAND_CODE_LIBRARY_SUBSCRIBE)) {
            ignoreFuture(this.librarySessionImpl.onSubscribeOnHandler(controllerInfo, str, MediaUtils.convertToLibraryParams(this.librarySessionImpl.getContext(), bundle)));
        }
    }

    public /* synthetic */ void lambda$onUnsubscribe$2(MediaSession.ControllerInfo controllerInfo, String str) {
        if (getConnectedControllersManager().isSessionCommandAvailable(controllerInfo, SessionCommand.COMMAND_CODE_LIBRARY_UNSUBSCRIBE)) {
            ignoreFuture(this.librarySessionImpl.onUnsubscribeOnHandler(controllerInfo, str));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void lambda$sendCustomActionResultWhenReady$7(p5.c0 c0Var, MediaBrowserServiceCompat.Result result) {
        try {
            result.sendResult(((SessionResult) Assertions.checkNotNull((SessionResult) c0Var.get(), "SessionResult must not be null")).extras);
        } catch (InterruptedException | CancellationException | ExecutionException e10) {
            Log.w(TAG, "Custom action failed", e10);
            result.sendError(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void lambda$sendLibraryResultWithMediaItemWhenReady$8(p5.c0 c0Var, MediaBrowserServiceCompat.Result result) {
        try {
            result.sendResult((MediaBrowserCompat.MediaItem) c0Var.get());
        } catch (InterruptedException | CancellationException | ExecutionException e10) {
            Log.w(TAG, "Library operation failed", e10);
            result.sendError(null);
        }
    }

    public static /* synthetic */ void lambda$sendLibraryResultWithMediaItemsWhenReady$9(p5.c0 c0Var, MediaBrowserServiceCompat.Result result) {
        try {
            List list = (List) c0Var.get();
            result.sendResult(list == null ? null : MediaUtils.truncateListBySize(list, 262144));
        } catch (InterruptedException | CancellationException | ExecutionException e10) {
            Log.w(TAG, "Library operation failed", e10);
            result.sendError(null);
        }
    }

    private static void sendCustomActionResultWhenReady(MediaBrowserServiceCompat.Result<Bundle> result, p5.c0<SessionResult> c0Var) {
        c0Var.addListener(new Runnable() { // from class: androidx.media3.session.o6

            /* renamed from: c */
            public final /* synthetic */ MediaBrowserServiceCompat.Result f808c;

            public /* synthetic */ o6(MediaBrowserServiceCompat.Result result2) {
                result = result2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaLibraryServiceLegacyStub.lambda$sendCustomActionResultWhenReady$7(p5.c0.this, result);
            }
        }, com.google.common.util.concurrent.p.c());
    }

    private static void sendLibraryResultWithMediaItemWhenReady(MediaBrowserServiceCompat.Result<MediaBrowserCompat.MediaItem> result, p5.c0<MediaBrowserCompat.MediaItem> c0Var) {
        c0Var.addListener(new Runnable() { // from class: androidx.media3.session.k6

            /* renamed from: c */
            public final /* synthetic */ MediaBrowserServiceCompat.Result f688c;

            public /* synthetic */ k6(MediaBrowserServiceCompat.Result result2) {
                result = result2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaLibraryServiceLegacyStub.lambda$sendLibraryResultWithMediaItemWhenReady$8(p5.c0.this, result);
            }
        }, com.google.common.util.concurrent.p.c());
    }

    public static void sendLibraryResultWithMediaItemsWhenReady(MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result, p5.c0<List<MediaBrowserCompat.MediaItem>> c0Var) {
        c0Var.addListener(new Runnable() { // from class: androidx.media3.session.e6

            /* renamed from: c */
            public final /* synthetic */ MediaBrowserServiceCompat.Result f505c;

            public /* synthetic */ e6(MediaBrowserServiceCompat.Result result2) {
                result = result2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaLibraryServiceLegacyStub.lambda$sendLibraryResultWithMediaItemsWhenReady$9(p5.c0.this, result);
            }
        }, com.google.common.util.concurrent.p.c());
    }

    @Override // androidx.media3.session.MediaSessionServiceLegacyStub
    public MediaSession.ControllerInfo createControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo, Bundle bundle) {
        return new MediaSession.ControllerInfo(remoteUserInfo, 0, 0, getMediaSessionManager().isTrustedForMediaControl(remoteUserInfo), new BrowserLegacyCb(remoteUserInfo), bundle);
    }

    public MediaSession.ControllerCb getBrowserLegacyCbForBroadcast() {
        return this.browserLegacyCbForBroadcast;
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onCustomAction(String str, Bundle bundle, MediaBrowserServiceCompat.Result<Bundle> result) {
        MediaSession.ControllerInfo currentController = getCurrentController();
        if (currentController == null) {
            result.sendError(null);
        } else {
            result.detach();
            Util.postOrRun(this.librarySessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.f6

                /* renamed from: c */
                public final /* synthetic */ String f530c;

                /* renamed from: d */
                public final /* synthetic */ MediaSession.ControllerInfo f531d;

                /* renamed from: e */
                public final /* synthetic */ MediaBrowserServiceCompat.Result f532e;

                /* renamed from: f */
                public final /* synthetic */ Bundle f533f;

                public /* synthetic */ f6(String str2, MediaSession.ControllerInfo currentController2, MediaBrowserServiceCompat.Result result2, Bundle bundle2) {
                    str = str2;
                    currentController = currentController2;
                    result = result2;
                    bundle = bundle2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MediaLibraryServiceLegacyStub.this.lambda$onCustomAction$6(str, currentController, result, bundle);
                }
            });
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: androidx.media3.session.g6.<init>(androidx.media3.session.MediaLibraryServiceLegacyStub, java.util.concurrent.atomic.AtomicReference, androidx.media3.session.MediaSession$ControllerInfo, androidx.media3.session.MediaLibraryService$LibraryParams, androidx.media3.common.util.ConditionVariable):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.session.MediaSessionServiceLegacyStub, androidx.media.MediaBrowserServiceCompat
    @androidx.annotation.Nullable
    public androidx.media.MediaBrowserServiceCompat.BrowserRoot onGetRoot(java.lang.String r10, int r11, @androidx.annotation.Nullable android.os.Bundle r12) {
        /*
            r9 = this;
            androidx.media.MediaBrowserServiceCompat$BrowserRoot r10 = super.onGetRoot(r10, r11, r12)
            r11 = 0
            if (r10 != 0) goto L8
            return r11
        L8:
            androidx.media3.session.MediaSession$ControllerInfo r10 = r9.getCurrentController()
            if (r10 != 0) goto Lf
            return r11
        Lf:
            androidx.media3.session.ConnectedControllersManager r0 = r9.getConnectedControllersManager()
            r1 = 50000(0xc350, float:7.0065E-41)
            boolean r0 = r0.isSessionCommandAvailable(r10, r1)
            if (r0 != 0) goto L1d
            return r11
        L1d:
            androidx.media3.session.MediaLibrarySessionImpl r0 = r9.librarySessionImpl
            android.content.Context r0 = r0.getContext()
            androidx.media3.session.MediaLibraryService$LibraryParams r4 = androidx.media3.session.MediaUtils.convertToLibraryParams(r0, r12)
            java.util.concurrent.atomic.AtomicReference r12 = new java.util.concurrent.atomic.AtomicReference
            r12.<init>()
            androidx.media3.common.util.ConditionVariable r6 = new androidx.media3.common.util.ConditionVariable
            r6.<init>()
            androidx.media3.session.MediaLibrarySessionImpl r0 = r9.librarySessionImpl
            android.os.Handler r7 = r0.getApplicationHandler()
            androidx.media3.session.g6 r8 = new androidx.media3.session.g6
            r0 = r8
            r1 = r9
            r2 = r12
            r3 = r10
            r5 = r6
            r0.<init>()
            androidx.media3.common.util.Util.postOrRun(r7, r8)
            r6.block()     // Catch: java.lang.InterruptedException -> L5c java.util.concurrent.ExecutionException -> L5e java.util.concurrent.CancellationException -> L60
            java.lang.Object r12 = r12.get()     // Catch: java.lang.InterruptedException -> L5c java.util.concurrent.ExecutionException -> L5e java.util.concurrent.CancellationException -> L60
            p5.c0 r12 = (p5.c0) r12     // Catch: java.lang.InterruptedException -> L5c java.util.concurrent.ExecutionException -> L5e java.util.concurrent.CancellationException -> L60
            java.lang.Object r12 = r12.get()     // Catch: java.lang.InterruptedException -> L5c java.util.concurrent.ExecutionException -> L5e java.util.concurrent.CancellationException -> L60
            androidx.media3.session.LibraryResult r12 = (androidx.media3.session.LibraryResult) r12     // Catch: java.lang.InterruptedException -> L5c java.util.concurrent.ExecutionException -> L5e java.util.concurrent.CancellationException -> L60
            java.lang.String r0 = "LibraryResult must not be null"
            java.lang.Object r12 = androidx.media3.common.util.Assertions.checkNotNull(r12, r0)     // Catch: java.lang.InterruptedException -> L5c java.util.concurrent.ExecutionException -> L5e java.util.concurrent.CancellationException -> L60
            androidx.media3.session.LibraryResult r12 = (androidx.media3.session.LibraryResult) r12     // Catch: java.lang.InterruptedException -> L5c java.util.concurrent.ExecutionException -> L5e java.util.concurrent.CancellationException -> L60
            goto L69
        L5c:
            r12 = move-exception
            goto L61
        L5e:
            r12 = move-exception
            goto L61
        L60:
            r12 = move-exception
        L61:
            java.lang.String r0 = "MLSLegacyStub"
            java.lang.String r1 = "Couldn't get a result from onGetLibraryRoot"
            androidx.media3.common.util.Log.e(r0, r1, r12)
            r12 = r11
        L69:
            if (r12 == 0) goto La3
            int r0 = r12.resultCode
            if (r0 != 0) goto La3
            V r0 = r12.value
            if (r0 == 0) goto La3
            androidx.media3.session.MediaLibraryService$LibraryParams r11 = r12.params
            if (r11 == 0) goto L7c
            android.os.Bundle r11 = androidx.media3.session.MediaUtils.convertToRootHints(r11)
            goto L81
        L7c:
            android.os.Bundle r11 = new android.os.Bundle
            r11.<init>()
        L81:
            androidx.media3.session.ConnectedControllersManager r0 = r9.getConnectedControllersManager()
            r1 = 50005(0xc355, float:7.0072E-41)
            boolean r10 = r0.isSessionCommandAvailable(r10, r1)
            java.lang.Object r0 = androidx.media3.common.util.Assertions.checkNotNull(r11)
            android.os.Bundle r0 = (android.os.Bundle) r0
            java.lang.String r1 = "android.media.browse.SEARCH_SUPPORTED"
            r0.putBoolean(r1, r10)
            androidx.media.MediaBrowserServiceCompat$BrowserRoot r10 = new androidx.media.MediaBrowserServiceCompat$BrowserRoot
            V r12 = r12.value
            androidx.media3.common.MediaItem r12 = (androidx.media3.common.MediaItem) r12
            java.lang.String r12 = r12.mediaId
            r10.<init>(r12, r11)
            return r10
        La3:
            if (r12 == 0) goto Laa
            int r10 = r12.resultCode
            if (r10 == 0) goto Laa
            goto Lac
        Laa:
            androidx.media.MediaBrowserServiceCompat$BrowserRoot r11 = androidx.media3.session.MediaUtils.defaultBrowserRoot
        Lac:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.MediaLibraryServiceLegacyStub.onGetRoot(java.lang.String, int, android.os.Bundle):androidx.media.MediaBrowserServiceCompat$BrowserRoot");
    }

    @Override // androidx.media3.session.MediaSessionServiceLegacyStub, androidx.media.MediaBrowserServiceCompat
    public void onLoadChildren(String str, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
        onLoadChildren(str, result, null);
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onLoadItem(String str, MediaBrowserServiceCompat.Result<MediaBrowserCompat.MediaItem> result) {
        MediaSession.ControllerInfo currentController = getCurrentController();
        if (currentController == null) {
            result.sendError(null);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            result.detach();
            Util.postOrRun(this.librarySessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.n6

                /* renamed from: c */
                public final /* synthetic */ MediaSession.ControllerInfo f775c;

                /* renamed from: d */
                public final /* synthetic */ MediaBrowserServiceCompat.Result f776d;

                /* renamed from: e */
                public final /* synthetic */ String f777e;

                public /* synthetic */ n6(MediaSession.ControllerInfo currentController2, MediaBrowserServiceCompat.Result result2, String str2) {
                    currentController = currentController2;
                    result = result2;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MediaLibraryServiceLegacyStub.this.lambda$onLoadItem$4(currentController, result, str);
                }
            });
            return;
        }
        Log.w(TAG, "Ignoring empty itemId from " + currentController2);
        result2.sendError(null);
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onSearch(String str, @Nullable Bundle bundle, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
        MediaSession.ControllerInfo currentController = getCurrentController();
        if (currentController == null) {
            result.sendError(null);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            if (currentController.getControllerCb() instanceof BrowserLegacyCb) {
                result.detach();
                Util.postOrRun(this.librarySessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.m6

                    /* renamed from: c */
                    public final /* synthetic */ MediaSession.ControllerInfo f741c;

                    /* renamed from: d */
                    public final /* synthetic */ MediaBrowserServiceCompat.Result f742d;

                    /* renamed from: e */
                    public final /* synthetic */ String f743e;

                    /* renamed from: f */
                    public final /* synthetic */ Bundle f744f;

                    public /* synthetic */ m6(MediaSession.ControllerInfo currentController2, MediaBrowserServiceCompat.Result result2, String str2, Bundle bundle2) {
                        currentController = currentController2;
                        result = result2;
                        str = str2;
                        bundle = bundle2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaLibraryServiceLegacyStub.this.lambda$onSearch$5(currentController, result, str, bundle);
                    }
                });
                return;
            }
            return;
        }
        Log.w(TAG, "Ignoring empty query from " + currentController2);
        result2.sendError(null);
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    @SuppressLint({"RestrictedApi"})
    public void onSubscribe(String str, Bundle bundle) {
        MediaSession.ControllerInfo currentController = getCurrentController();
        if (currentController == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            Util.postOrRun(this.librarySessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.a6

                /* renamed from: c */
                public final /* synthetic */ MediaSession.ControllerInfo f398c;

                /* renamed from: d */
                public final /* synthetic */ Bundle f399d;

                /* renamed from: e */
                public final /* synthetic */ String f400e;

                public /* synthetic */ a6(MediaSession.ControllerInfo currentController2, Bundle bundle2, String str2) {
                    currentController = currentController2;
                    bundle = bundle2;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MediaLibraryServiceLegacyStub.this.lambda$onSubscribe$1(currentController, bundle, str);
                }
            });
            return;
        }
        Log.w(TAG, "onSubscribe(): Ignoring empty id from " + currentController2);
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    @SuppressLint({"RestrictedApi"})
    public void onUnsubscribe(String str) {
        MediaSession.ControllerInfo currentController = getCurrentController();
        if (currentController == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            Util.postOrRun(this.librarySessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.p6

                /* renamed from: c */
                public final /* synthetic */ MediaSession.ControllerInfo f830c;

                /* renamed from: d */
                public final /* synthetic */ String f831d;

                public /* synthetic */ p6(MediaSession.ControllerInfo currentController2, String str2) {
                    currentController = currentController2;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MediaLibraryServiceLegacyStub.this.lambda$onUnsubscribe$2(currentController, str);
                }
            });
            return;
        }
        Log.w(TAG, "onUnsubscribe(): Ignoring empty id from " + currentController2);
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onLoadChildren(String str, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result, @Nullable Bundle bundle) {
        MediaSession.ControllerInfo currentController = getCurrentController();
        if (currentController == null) {
            result.sendError(null);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            result.detach();
            Util.postOrRun(this.librarySessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.h6

                /* renamed from: c */
                public final /* synthetic */ MediaSession.ControllerInfo f594c;

                /* renamed from: d */
                public final /* synthetic */ MediaBrowserServiceCompat.Result f595d;

                /* renamed from: e */
                public final /* synthetic */ Bundle f596e;

                /* renamed from: f */
                public final /* synthetic */ String f597f;

                public /* synthetic */ h6(MediaSession.ControllerInfo currentController2, MediaBrowserServiceCompat.Result result2, Bundle bundle2, String str2) {
                    currentController = currentController2;
                    result = result2;
                    bundle = bundle2;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MediaLibraryServiceLegacyStub.this.lambda$onLoadChildren$3(currentController, result, bundle, str);
                }
            });
            return;
        }
        Log.w(TAG, "onLoadChildren(): Ignoring empty parentId from " + currentController2);
        result2.sendError(null);
    }
}
