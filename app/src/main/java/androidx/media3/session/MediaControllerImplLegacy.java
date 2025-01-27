package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.session.MediaController;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.FlagSet;
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
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaController;
import androidx.media3.session.MediaControllerImplLegacy;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
class MediaControllerImplLegacy implements MediaController.MediaControllerImpl {
    private static final long AGGREGATES_CALLBACKS_WITHIN_TIMEOUT_MS = 500;
    private static final String TAG = "MCImplLegacy";
    private final androidx.media3.common.util.BitmapLoader bitmapLoader;

    @Nullable
    private MediaBrowserCompat browserCompat;
    private boolean connected;
    final Context context;

    @Nullable
    private MediaControllerCompat controllerCompat;
    private final ControllerCompatCallback controllerCompatCallback;
    private final MediaController instance;
    private final ListenerSet<Player.Listener> listeners;
    private boolean released;
    private final SessionToken token;
    private LegacyPlayerInfo legacyPlayerInfo = new LegacyPlayerInfo();
    private LegacyPlayerInfo pendingLegacyPlayerInfo = new LegacyPlayerInfo();
    private ControllerInfo controllerInfo = new ControllerInfo();

    /* renamed from: androidx.media3.session.MediaControllerImplLegacy$1 */
    public class AnonymousClass1 extends ResultReceiver {
        final /* synthetic */ com.google.common.util.concurrent.s val$result;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MediaControllerImplLegacy mediaControllerImplLegacy, Handler handler, com.google.common.util.concurrent.s sVar) {
            super(handler);
            n10 = sVar;
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i10, Bundle bundle) {
            com.google.common.util.concurrent.s sVar = n10;
            if (bundle == null) {
                bundle = Bundle.EMPTY;
            }
            sVar.set(new SessionResult(i10, bundle));
        }
    }

    public class ConnectionCallback extends MediaBrowserCompat.ConnectionCallback {
        private ConnectionCallback() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnected() {
            MediaBrowserCompat browserCompat = MediaControllerImplLegacy.this.getBrowserCompat();
            if (browserCompat != null) {
                MediaControllerImplLegacy.this.connectToSession(browserCompat.getSessionToken());
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionFailed() {
            MediaControllerImplLegacy.this.getInstance().release();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionSuspended() {
            MediaControllerImplLegacy.this.getInstance().release();
        }

        public /* synthetic */ ConnectionCallback(MediaControllerImplLegacy mediaControllerImplLegacy, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public final class ControllerCompatCallback extends MediaControllerCompat.Callback {
        private static final int MSG_HANDLE_PENDING_UPDATES = 1;
        private final Handler pendingChangesHandler;

        public ControllerCompatCallback(Looper looper) {
            this.pendingChangesHandler = new Handler(looper, new Handler.Callback() { // from class: androidx.media3.session.j5
                public /* synthetic */ j5() {
                }

                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    boolean lambda$new$0;
                    lambda$new$0 = MediaControllerImplLegacy.ControllerCompatCallback.this.lambda$new$0(message);
                    return lambda$new$0;
                }
            });
        }

        public /* synthetic */ boolean lambda$new$0(Message message) {
            if (message.what == 1) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                mediaControllerImplLegacy.handleNewLegacyParameters(false, mediaControllerImplLegacy.pendingLegacyPlayerInfo);
            }
            return true;
        }

        public /* synthetic */ void lambda$onCaptioningEnabledChanged$3(boolean z10, MediaController.Listener listener) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("androidx.media3.session.ARGUMENT_CAPTIONING_ENABLED", z10);
            MediaControllerImplLegacy.ignoreFuture(listener.onCustomCommand(MediaControllerImplLegacy.this.getInstance(), new SessionCommand("androidx.media3.session.SESSION_COMMAND_ON_CAPTIONING_ENABLED_CHANGED", Bundle.EMPTY), bundle));
        }

        public /* synthetic */ void lambda$onExtrasChanged$2(Bundle bundle, MediaController.Listener listener) {
            listener.onExtrasChanged(MediaControllerImplLegacy.this.getInstance(), bundle);
        }

        public /* synthetic */ void lambda$onSessionEvent$1(String str, Bundle bundle, MediaController.Listener listener) {
            MediaControllerImplLegacy.ignoreFuture(listener.onCustomCommand(MediaControllerImplLegacy.this.getInstance(), new SessionCommand(str, Bundle.EMPTY), bundle));
        }

        private void startWaitingForPendingChanges() {
            if (this.pendingChangesHandler.hasMessages(1)) {
                return;
            }
            this.pendingChangesHandler.sendEmptyMessageDelayed(1, 500L);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onAudioInfoChanged(MediaControllerCompat.PlaybackInfo playbackInfo) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            mediaControllerImplLegacy.pendingLegacyPlayerInfo = mediaControllerImplLegacy.pendingLegacyPlayerInfo.copyWithPlaybackInfoCompat(playbackInfo);
            startWaitingForPendingChanges();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onCaptioningEnabledChanged(boolean z10) {
            MediaControllerImplLegacy.this.getInstance().notifyControllerListener(new Consumer() { // from class: androidx.media3.session.i5

                /* renamed from: b */
                public final /* synthetic */ boolean f626b;

                public /* synthetic */ i5(boolean z102) {
                    z10 = z102;
                }

                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaControllerImplLegacy.ControllerCompatCallback.this.lambda$onCaptioningEnabledChanged$3(z10, (MediaController.Listener) obj);
                }
            });
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onExtrasChanged(Bundle bundle) {
            MediaControllerImplLegacy.this.getInstance().notifyControllerListener(new Consumer() { // from class: androidx.media3.session.k5

                /* renamed from: b */
                public final /* synthetic */ Bundle f686b;

                public /* synthetic */ k5(Bundle bundle2) {
                    bundle = bundle2;
                }

                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaControllerImplLegacy.ControllerCompatCallback.this.lambda$onExtrasChanged$2(bundle, (MediaController.Listener) obj);
                }
            });
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            mediaControllerImplLegacy.pendingLegacyPlayerInfo = mediaControllerImplLegacy.pendingLegacyPlayerInfo.copyWithMediaMetadataCompat(mediaMetadataCompat);
            startWaitingForPendingChanges();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            mediaControllerImplLegacy.pendingLegacyPlayerInfo = mediaControllerImplLegacy.pendingLegacyPlayerInfo.copyWithPlaybackStateCompat(MediaControllerImplLegacy.convertToSafePlaybackStateCompat(playbackStateCompat));
            startWaitingForPendingChanges();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onQueueChanged(@Nullable List<MediaSessionCompat.QueueItem> list) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            mediaControllerImplLegacy.pendingLegacyPlayerInfo = mediaControllerImplLegacy.pendingLegacyPlayerInfo.copyWithQueue(MediaControllerImplLegacy.convertToNonNullQueueItemList(list));
            startWaitingForPendingChanges();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onQueueTitleChanged(CharSequence charSequence) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            mediaControllerImplLegacy.pendingLegacyPlayerInfo = mediaControllerImplLegacy.pendingLegacyPlayerInfo.copyWithQueueTitle(charSequence);
            startWaitingForPendingChanges();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onRepeatModeChanged(int i10) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            mediaControllerImplLegacy.pendingLegacyPlayerInfo = mediaControllerImplLegacy.pendingLegacyPlayerInfo.copyWithRepeatMode(i10);
            startWaitingForPendingChanges();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onSessionDestroyed() {
            MediaControllerImplLegacy.this.getInstance().release();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onSessionEvent(String str, Bundle bundle) {
            MediaControllerImplLegacy.this.getInstance().notifyControllerListener(new Consumer() { // from class: androidx.media3.session.l5

                /* renamed from: b */
                public final /* synthetic */ String f713b;

                /* renamed from: c */
                public final /* synthetic */ Bundle f714c;

                public /* synthetic */ l5(String str2, Bundle bundle2) {
                    str = str2;
                    bundle = bundle2;
                }

                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaControllerImplLegacy.ControllerCompatCallback.this.lambda$onSessionEvent$1(str, bundle, (MediaController.Listener) obj);
                }
            });
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onSessionReady() {
            if (!MediaControllerImplLegacy.this.connected) {
                MediaControllerImplLegacy.this.onConnected();
                return;
            }
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            mediaControllerImplLegacy.pendingLegacyPlayerInfo = mediaControllerImplLegacy.pendingLegacyPlayerInfo.copyWithExtraBinderGetters(MediaControllerImplLegacy.convertToSafePlaybackStateCompat(MediaControllerImplLegacy.this.controllerCompat.getPlaybackState()), MediaControllerImplLegacy.this.controllerCompat.getRepeatMode(), MediaControllerImplLegacy.this.controllerCompat.getShuffleMode());
            onCaptioningEnabledChanged(MediaControllerImplLegacy.this.controllerCompat.isCaptioningEnabled());
            this.pendingChangesHandler.removeMessages(1);
            MediaControllerImplLegacy mediaControllerImplLegacy2 = MediaControllerImplLegacy.this;
            mediaControllerImplLegacy2.handleNewLegacyParameters(false, mediaControllerImplLegacy2.pendingLegacyPlayerInfo);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onShuffleModeChanged(int i10) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            mediaControllerImplLegacy.pendingLegacyPlayerInfo = mediaControllerImplLegacy.pendingLegacyPlayerInfo.copyWithShuffleMode(i10);
            startWaitingForPendingChanges();
        }

        public void release() {
            this.pendingChangesHandler.removeCallbacksAndMessages(null);
        }
    }

    public MediaControllerImplLegacy(Context context, MediaController mediaController, SessionToken sessionToken, Looper looper, androidx.media3.common.util.BitmapLoader bitmapLoader) {
        this.listeners = new ListenerSet<>(looper, Clock.DEFAULT, new ListenerSet.IterationFinishedEvent() { // from class: androidx.media3.session.t4
            public /* synthetic */ t4() {
            }

            @Override // androidx.media3.common.util.ListenerSet.IterationFinishedEvent
            public final void invoke(Object obj, FlagSet flagSet) {
                MediaControllerImplLegacy.this.lambda$new$0((Player.Listener) obj, flagSet);
            }
        });
        this.context = context;
        this.instance = mediaController;
        this.controllerCompatCallback = new ControllerCompatCallback(looper);
        this.token = sessionToken;
        this.bitmapLoader = bitmapLoader;
    }

    private void addQueueItems(List<MediaItem> list, int i10) {
        ArrayList arrayList = new ArrayList();
        a5 a5Var = new Runnable() { // from class: androidx.media3.session.a5

            /* renamed from: c */
            public final /* synthetic */ AtomicInteger f393c;

            /* renamed from: d */
            public final /* synthetic */ List f394d;

            /* renamed from: e */
            public final /* synthetic */ List f395e;

            /* renamed from: f */
            public final /* synthetic */ int f396f;

            public /* synthetic */ a5(AtomicInteger atomicInteger, List list2, List arrayList2, int i102) {
                atomicInteger = atomicInteger;
                list = list2;
                arrayList = arrayList2;
                i10 = i102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaControllerImplLegacy.this.lambda$addQueueItems$4(atomicInteger, list, arrayList, i10);
            }
        };
        for (int i11 = 0; i11 < list2.size(); i11++) {
            byte[] bArr = list2.get(i11).mediaMetadata.artworkData;
            if (bArr == null) {
                arrayList2.add(null);
                a5Var.run();
            } else {
                p5.c0<Bitmap> decodeBitmap = this.bitmapLoader.decodeBitmap(bArr);
                arrayList2.add(decodeBitmap);
                Handler handler = getInstance().applicationHandler;
                Objects.requireNonNull(handler);
                decodeBitmap.addListener(a5Var, new g0.a(handler));
            }
        }
    }

    private static ControllerInfo buildNewControllerInfo(boolean z10, LegacyPlayerInfo legacyPlayerInfo, ControllerInfo controllerInfo, LegacyPlayerInfo legacyPlayerInfo2, long j10, boolean z11, int i10, long j11, @Nullable String str) {
        int findQueueItemIndex;
        MediaMetadata convertToMediaMetadata;
        SessionCommands sessionCommands;
        ImmutableList<CommandButton> immutableList;
        List<MediaSessionCompat.QueueItem> list = legacyPlayerInfo.queue;
        List<MediaSessionCompat.QueueItem> list2 = legacyPlayerInfo2.queue;
        boolean z12 = list != list2;
        QueueTimeline create = z12 ? QueueTimeline.create(list2) : ((QueueTimeline) controllerInfo.playerInfo.timeline).copy();
        boolean z13 = legacyPlayerInfo.mediaMetadataCompat != legacyPlayerInfo2.mediaMetadataCompat || z10;
        long activeQueueId = getActiveQueueId(legacyPlayerInfo.playbackStateCompat);
        long activeQueueId2 = getActiveQueueId(legacyPlayerInfo2.playbackStateCompat);
        boolean z14 = activeQueueId != activeQueueId2 || z10;
        long convertToDurationMs = MediaUtils.convertToDurationMs(legacyPlayerInfo2.mediaMetadataCompat);
        if (z13 || z14 || z12) {
            findQueueItemIndex = findQueueItemIndex(legacyPlayerInfo2.queue, activeQueueId2);
            MediaMetadataCompat mediaMetadataCompat = legacyPlayerInfo2.mediaMetadataCompat;
            boolean z15 = mediaMetadataCompat != null;
            convertToMediaMetadata = (z15 && z13) ? MediaUtils.convertToMediaMetadata(mediaMetadataCompat, i10) : (z15 || !z14) ? controllerInfo.playerInfo.mediaMetadata : findQueueItemIndex == -1 ? MediaMetadata.EMPTY : MediaUtils.convertToMediaMetadata(legacyPlayerInfo2.queue.get(findQueueItemIndex).getDescription(), i10);
            if (findQueueItemIndex != -1 || !z13) {
                if (findQueueItemIndex != -1) {
                    create = create.copyWithClearedFakeMediaItem();
                    if (z15) {
                        create = create.copyWithNewMediaItem(findQueueItemIndex, MediaUtils.convertToMediaItem(((MediaItem) Assertions.checkNotNull(create.getMediaItemAt(findQueueItemIndex))).mediaId, legacyPlayerInfo2.mediaMetadataCompat, i10), convertToDurationMs);
                    }
                }
                findQueueItemIndex = 0;
            } else if (z15) {
                Log.w(TAG, "Adding a fake MediaItem at the end of the list because there's no QueueItem with the active queue id and current Timeline should have currently playing MediaItem.");
                create = create.copyWithFakeMediaItem(MediaUtils.convertToMediaItem(legacyPlayerInfo2.mediaMetadataCompat, i10), convertToDurationMs);
                findQueueItemIndex = create.getWindowCount() - 1;
            } else {
                create = create.copyWithClearedFakeMediaItem();
                findQueueItemIndex = 0;
            }
        } else {
            PlayerInfo playerInfo = controllerInfo.playerInfo;
            findQueueItemIndex = playerInfo.sessionPositionInfo.positionInfo.mediaItemIndex;
            convertToMediaMetadata = playerInfo.mediaMetadata;
        }
        int i11 = findQueueItemIndex;
        QueueTimeline queueTimeline = create;
        CharSequence charSequence = legacyPlayerInfo.queueTitle;
        CharSequence charSequence2 = legacyPlayerInfo2.queueTitle;
        MediaMetadata convertToMediaMetadata2 = charSequence == charSequence2 ? controllerInfo.playerInfo.playlistMetadata : MediaUtils.convertToMediaMetadata(charSequence2);
        int convertToRepeatMode = MediaUtils.convertToRepeatMode(legacyPlayerInfo2.repeatMode);
        boolean convertToShuffleModeEnabled = MediaUtils.convertToShuffleModeEnabled(legacyPlayerInfo2.shuffleMode);
        PlaybackStateCompat playbackStateCompat = legacyPlayerInfo.playbackStateCompat;
        PlaybackStateCompat playbackStateCompat2 = legacyPlayerInfo2.playbackStateCompat;
        if (playbackStateCompat != playbackStateCompat2) {
            sessionCommands = MediaUtils.convertToSessionCommands(playbackStateCompat2, z11);
            immutableList = MediaUtils.convertToCustomLayout(legacyPlayerInfo2.playbackStateCompat);
        } else {
            sessionCommands = controllerInfo.availableSessionCommands;
            immutableList = controllerInfo.customLayout;
        }
        SessionCommands sessionCommands2 = sessionCommands;
        ImmutableList<CommandButton> immutableList2 = immutableList;
        MediaControllerCompat.PlaybackInfo playbackInfo = legacyPlayerInfo2.playbackInfoCompat;
        Player.Commands convertToPlayerCommands = MediaUtils.convertToPlayerCommands(legacyPlayerInfo2.playbackStateCompat, playbackInfo != null ? playbackInfo.getVolumeControl() : 0, j10, z11);
        PlaybackException convertToPlaybackException = MediaUtils.convertToPlaybackException(legacyPlayerInfo2.playbackStateCompat);
        long convertToCurrentPositionMs = MediaUtils.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j11);
        long convertToBufferedPositionMs = MediaUtils.convertToBufferedPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j11);
        int convertToBufferedPercentage = MediaUtils.convertToBufferedPercentage(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j11);
        long convertToTotalBufferedDurationMs = MediaUtils.convertToTotalBufferedDurationMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j11);
        boolean convertToIsPlayingAd = MediaUtils.convertToIsPlayingAd(legacyPlayerInfo2.mediaMetadataCompat);
        PlaybackParameters convertToPlaybackParameters = MediaUtils.convertToPlaybackParameters(legacyPlayerInfo2.playbackStateCompat);
        AudioAttributes convertToAudioAttributes = MediaUtils.convertToAudioAttributes(legacyPlayerInfo2.playbackInfoCompat);
        boolean convertToPlayWhenReady = MediaUtils.convertToPlayWhenReady(legacyPlayerInfo2.playbackStateCompat);
        int convertToPlaybackState = MediaUtils.convertToPlaybackState(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j11);
        boolean convertToIsPlaying = MediaUtils.convertToIsPlaying(legacyPlayerInfo2.playbackStateCompat);
        DeviceInfo convertToDeviceInfo = MediaUtils.convertToDeviceInfo(legacyPlayerInfo2.playbackInfoCompat, str);
        int convertToDeviceVolume = MediaUtils.convertToDeviceVolume(legacyPlayerInfo2.playbackInfoCompat);
        boolean convertToIsDeviceMuted = MediaUtils.convertToIsDeviceMuted(legacyPlayerInfo2.playbackInfoCompat);
        PlayerInfo playerInfo2 = controllerInfo.playerInfo;
        return createControllerInfo(queueTimeline, convertToMediaMetadata, i11, convertToMediaMetadata2, convertToRepeatMode, convertToShuffleModeEnabled, sessionCommands2, convertToPlayerCommands, immutableList2, convertToPlaybackException, convertToDurationMs, convertToCurrentPositionMs, convertToBufferedPositionMs, convertToBufferedPercentage, convertToTotalBufferedDurationMs, convertToIsPlayingAd, convertToPlaybackParameters, convertToAudioAttributes, convertToPlayWhenReady, convertToPlaybackState, convertToIsPlaying, convertToDeviceInfo, convertToDeviceVolume, convertToIsDeviceMuted, playerInfo2.seekBackIncrementMs, playerInfo2.seekForwardIncrementMs);
    }

    private static int calculateCurrentItemIndexAfterAddItems(int i10, int i11, int i12) {
        return i10 < i11 ? i10 : i10 + i12;
    }

    private static int calculateCurrentItemIndexAfterRemoveItems(int i10, int i11, int i12) {
        int i13 = i12 - i11;
        if (i10 < i11) {
            return i10;
        }
        if (i10 < i12) {
            return -1;
        }
        return i10 - i13;
    }

    private static Pair<Integer, Integer> calculateDiscontinuityAndTransitionReason(LegacyPlayerInfo legacyPlayerInfo, ControllerInfo controllerInfo, LegacyPlayerInfo legacyPlayerInfo2, ControllerInfo controllerInfo2, long j10) {
        Integer num;
        boolean isEmpty = controllerInfo.playerInfo.timeline.isEmpty();
        boolean isEmpty2 = controllerInfo2.playerInfo.timeline.isEmpty();
        Integer num2 = null;
        if (!isEmpty || !isEmpty2) {
            if (!isEmpty || isEmpty2) {
                MediaItem mediaItem = (MediaItem) Assertions.checkStateNotNull(controllerInfo.playerInfo.getCurrentMediaItem());
                if (!((QueueTimeline) controllerInfo2.playerInfo.timeline).contains(mediaItem)) {
                    num2 = 4;
                    num = 3;
                } else if (mediaItem.equals(controllerInfo2.playerInfo.getCurrentMediaItem())) {
                    long convertToCurrentPositionMs = MediaUtils.convertToCurrentPositionMs(legacyPlayerInfo.playbackStateCompat, legacyPlayerInfo.mediaMetadataCompat, j10);
                    long convertToCurrentPositionMs2 = MediaUtils.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j10);
                    if (convertToCurrentPositionMs2 == 0 && controllerInfo2.playerInfo.repeatMode == 1) {
                        num2 = 0;
                        num = 0;
                    } else if (Math.abs(convertToCurrentPositionMs - convertToCurrentPositionMs2) > 100) {
                        num2 = 5;
                        num = null;
                    }
                } else {
                    num2 = 0;
                    num = 1;
                }
            } else {
                num2 = 0;
                num = 3;
            }
            return Pair.create(num2, num);
        }
        num = null;
        return Pair.create(num2, num);
    }

    private void connectToService() {
        getInstance().runOnApplicationLooper(new Runnable() { // from class: androidx.media3.session.d5
            public /* synthetic */ d5() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaControllerImplLegacy.this.lambda$connectToService$3();
            }
        });
    }

    public void connectToSession(MediaSessionCompat.Token token) {
        getInstance().runOnApplicationLooper(new Runnable() { // from class: androidx.media3.session.b5

            /* renamed from: c */
            public final /* synthetic */ MediaSessionCompat.Token f423c;

            public /* synthetic */ b5(MediaSessionCompat.Token token2) {
                token = token2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaControllerImplLegacy.this.lambda$connectToSession$1(token);
            }
        });
        getInstance().applicationHandler.post(new Runnable() { // from class: androidx.media3.session.c5
            public /* synthetic */ c5() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaControllerImplLegacy.this.lambda$connectToSession$2();
            }
        });
    }

    public static List<MediaSessionCompat.QueueItem> convertToNonNullQueueItemList(@Nullable List<MediaSessionCompat.QueueItem> list) {
        return list == null ? Collections.emptyList() : MediaUtils.removeNullElements(list);
    }

    @Nullable
    public static PlaybackStateCompat convertToSafePlaybackStateCompat(@Nullable PlaybackStateCompat playbackStateCompat) {
        if (playbackStateCompat == null) {
            return null;
        }
        if (playbackStateCompat.getPlaybackSpeed() > 0.0f) {
            return playbackStateCompat;
        }
        Log.w(TAG, "Adjusting playback speed to 1.0f because negative playback speed isn't supported.");
        return new PlaybackStateCompat.Builder(playbackStateCompat).setState(playbackStateCompat.getState(), playbackStateCompat.getPosition(), 1.0f, playbackStateCompat.getLastPositionUpdateTime()).build();
    }

    private static ControllerInfo createControllerInfo(QueueTimeline queueTimeline, MediaMetadata mediaMetadata, int i10, MediaMetadata mediaMetadata2, int i11, boolean z10, SessionCommands sessionCommands, Player.Commands commands, ImmutableList<CommandButton> immutableList, @Nullable PlaybackException playbackException, long j10, long j11, long j12, int i12, long j13, boolean z11, PlaybackParameters playbackParameters, AudioAttributes audioAttributes, boolean z12, int i13, boolean z13, DeviceInfo deviceInfo, int i14, boolean z14, long j14, long j15) {
        SessionPositionInfo sessionPositionInfo = new SessionPositionInfo(createPositionInfo(i10, queueTimeline.getMediaItemAt(i10), j11, z11), z11, C.TIME_UNSET, j10, j12, i12, j13, C.TIME_UNSET, j10, j12);
        Player.PositionInfo positionInfo = SessionPositionInfo.DEFAULT_POSITION_INFO;
        return new ControllerInfo(new PlayerInfo(playbackException, 0, sessionPositionInfo, positionInfo, positionInfo, 0, playbackParameters, i11, z10, VideoSize.UNKNOWN, queueTimeline, mediaMetadata2, 1.0f, audioAttributes, CueGroup.EMPTY_TIME_ZERO, deviceInfo, i14, z14, z12, 1, 0, i13, z13, false, mediaMetadata, j14, j15, 0L, Tracks.EMPTY, TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT), sessionCommands, commands, immutableList);
    }

    private static Player.PositionInfo createPositionInfo(int i10, @Nullable MediaItem mediaItem, long j10, boolean z10) {
        return new Player.PositionInfo(null, i10, mediaItem, null, i10, j10, j10, z10 ? 0 : -1, z10 ? 0 : -1);
    }

    private static SessionPositionInfo createSessionPositionInfo(Player.PositionInfo positionInfo, boolean z10, long j10, long j11, int i10, long j12) {
        return new SessionPositionInfo(positionInfo, z10, SystemClock.elapsedRealtime(), j10, j11, i10, j12, C.TIME_UNSET, j10, j11);
    }

    private static int findQueueItemIndex(@Nullable List<MediaSessionCompat.QueueItem> list, long j10) {
        if (list != null && j10 != -1) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                if (list.get(i10).getQueueId() == j10) {
                    return i10;
                }
            }
        }
        return -1;
    }

    private static long getActiveQueueId(@Nullable PlaybackStateCompat playbackStateCompat) {
        if (playbackStateCompat == null) {
            return -1L;
        }
        return playbackStateCompat.getActiveQueueItemId();
    }

    private static Bundle getOrEmptyBundle(@Nullable Bundle bundle) {
        return bundle == null ? Bundle.EMPTY : bundle;
    }

    @Nullable
    private static String getRoutingControllerId(MediaControllerCompat mediaControllerCompat) {
        MediaController.PlaybackInfo playbackInfo;
        String volumeControlId;
        if (Util.SDK_INT < 30 || (playbackInfo = ((android.media.session.MediaController) mediaControllerCompat.getMediaController()).getPlaybackInfo()) == null) {
            return null;
        }
        volumeControlId = playbackInfo.getVolumeControlId();
        return volumeControlId;
    }

    private void handleBitmapFuturesAllCompletedAndAddQueueItems(List<p5.c0<Bitmap>> list, List<MediaItem> list2, int i10) {
        Bitmap bitmap;
        for (int i11 = 0; i11 < list.size(); i11++) {
            p5.c0<Bitmap> c0Var = list.get(i11);
            if (c0Var != null) {
                try {
                    bitmap = (Bitmap) com.google.common.util.concurrent.l.h(c0Var);
                } catch (CancellationException | ExecutionException e10) {
                    Log.d(TAG, "Failed to get bitmap", e10);
                }
                this.controllerCompat.addQueueItem(MediaUtils.convertToMediaDescriptionCompat(list2.get(i11), bitmap), i10 + i11);
            }
            bitmap = null;
            this.controllerCompat.addQueueItem(MediaUtils.convertToMediaDescriptionCompat(list2.get(i11), bitmap), i10 + i11);
        }
    }

    public void handleNewLegacyParameters(boolean z10, LegacyPlayerInfo legacyPlayerInfo) {
        if (this.released || !this.connected) {
            return;
        }
        ControllerInfo buildNewControllerInfo = buildNewControllerInfo(z10, this.legacyPlayerInfo, this.controllerInfo, legacyPlayerInfo, this.controllerCompat.getFlags(), this.controllerCompat.isSessionReady(), this.controllerCompat.getRatingType(), getInstance().getTimeDiffMs(), getRoutingControllerId(this.controllerCompat));
        Pair<Integer, Integer> calculateDiscontinuityAndTransitionReason = calculateDiscontinuityAndTransitionReason(this.legacyPlayerInfo, this.controllerInfo, legacyPlayerInfo, buildNewControllerInfo, getInstance().getTimeDiffMs());
        updateControllerInfo(z10, legacyPlayerInfo, buildNewControllerInfo, (Integer) calculateDiscontinuityAndTransitionReason.first, (Integer) calculateDiscontinuityAndTransitionReason.second);
    }

    private boolean hasMedia() {
        return !this.controllerInfo.playerInfo.timeline.isEmpty();
    }

    public static <T> void ignoreFuture(Future<T> future) {
    }

    private void initializeLegacyPlaylist() {
        Timeline.Window window = new Timeline.Window();
        Assertions.checkState(isPrepared() && hasMedia());
        PlayerInfo playerInfo = this.controllerInfo.playerInfo;
        QueueTimeline queueTimeline = (QueueTimeline) playerInfo.timeline;
        int i10 = playerInfo.sessionPositionInfo.positionInfo.mediaItemIndex;
        MediaItem mediaItem = queueTimeline.getWindow(i10, window).mediaItem;
        if (queueTimeline.getQueueId(i10) == -1) {
            MediaItem.RequestMetadata requestMetadata = mediaItem.requestMetadata;
            if (requestMetadata.mediaUri != null) {
                if (this.controllerInfo.playerInfo.playWhenReady) {
                    MediaControllerCompat.TransportControls transportControls = this.controllerCompat.getTransportControls();
                    MediaItem.RequestMetadata requestMetadata2 = mediaItem.requestMetadata;
                    transportControls.playFromUri(requestMetadata2.mediaUri, getOrEmptyBundle(requestMetadata2.extras));
                } else {
                    MediaControllerCompat.TransportControls transportControls2 = this.controllerCompat.getTransportControls();
                    MediaItem.RequestMetadata requestMetadata3 = mediaItem.requestMetadata;
                    transportControls2.prepareFromUri(requestMetadata3.mediaUri, getOrEmptyBundle(requestMetadata3.extras));
                }
            } else if (requestMetadata.searchQuery != null) {
                if (this.controllerInfo.playerInfo.playWhenReady) {
                    MediaControllerCompat.TransportControls transportControls3 = this.controllerCompat.getTransportControls();
                    MediaItem.RequestMetadata requestMetadata4 = mediaItem.requestMetadata;
                    transportControls3.playFromSearch(requestMetadata4.searchQuery, getOrEmptyBundle(requestMetadata4.extras));
                } else {
                    MediaControllerCompat.TransportControls transportControls4 = this.controllerCompat.getTransportControls();
                    MediaItem.RequestMetadata requestMetadata5 = mediaItem.requestMetadata;
                    transportControls4.prepareFromSearch(requestMetadata5.searchQuery, getOrEmptyBundle(requestMetadata5.extras));
                }
            } else if (this.controllerInfo.playerInfo.playWhenReady) {
                this.controllerCompat.getTransportControls().playFromMediaId(mediaItem.mediaId, getOrEmptyBundle(mediaItem.requestMetadata.extras));
            } else {
                this.controllerCompat.getTransportControls().prepareFromMediaId(mediaItem.mediaId, getOrEmptyBundle(mediaItem.requestMetadata.extras));
            }
        } else if (this.controllerInfo.playerInfo.playWhenReady) {
            this.controllerCompat.getTransportControls().play();
        } else {
            this.controllerCompat.getTransportControls().prepare();
        }
        if (this.controllerInfo.playerInfo.sessionPositionInfo.positionInfo.positionMs != 0) {
            this.controllerCompat.getTransportControls().seekTo(this.controllerInfo.playerInfo.sessionPositionInfo.positionInfo.positionMs);
        }
        if (getAvailableCommands().contains(20)) {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < queueTimeline.getWindowCount(); i11++) {
                if (i11 != i10 && queueTimeline.getQueueId(i11) == -1) {
                    arrayList.add(queueTimeline.getWindow(i11, window).mediaItem);
                }
            }
            addQueueItems(arrayList, 0);
        }
    }

    private boolean isPrepared() {
        return this.controllerInfo.playerInfo.playbackState != 1;
    }

    public /* synthetic */ void lambda$addQueueItems$4(AtomicInteger atomicInteger, List list, List list2, int i10) {
        if (atomicInteger.incrementAndGet() == list.size()) {
            handleBitmapFuturesAllCompletedAndAddQueueItems(list2, list, i10);
        }
    }

    public /* synthetic */ void lambda$connectToService$3() {
        MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(this.context, this.token.getComponentName(), new ConnectionCallback(), null);
        this.browserCompat = mediaBrowserCompat;
        mediaBrowserCompat.connect();
    }

    public /* synthetic */ void lambda$connectToSession$1(MediaSessionCompat.Token token) {
        MediaControllerCompat mediaControllerCompat = new MediaControllerCompat(this.context, token);
        this.controllerCompat = mediaControllerCompat;
        mediaControllerCompat.registerCallback(this.controllerCompatCallback, getInstance().applicationHandler);
    }

    public /* synthetic */ void lambda$connectToSession$2() {
        if (this.controllerCompat.isSessionReady()) {
            return;
        }
        onConnected();
    }

    public /* synthetic */ void lambda$new$0(Player.Listener listener, FlagSet flagSet) {
        listener.onEvents(getInstance(), new Player.Events(flagSet));
    }

    public /* synthetic */ void lambda$updateControllerInfo$12(Player.Listener listener) {
        listener.onMediaMetadataChanged(this.controllerInfo.playerInfo.mediaMetadata);
    }

    public static /* synthetic */ void lambda$updateControllerInfo$13(ControllerInfo controllerInfo, Player.Listener listener) {
        listener.onPlaybackStateChanged(controllerInfo.playerInfo.playbackState);
    }

    public static /* synthetic */ void lambda$updateControllerInfo$14(ControllerInfo controllerInfo, Player.Listener listener) {
        listener.onPlayWhenReadyChanged(controllerInfo.playerInfo.playWhenReady, 4);
    }

    public static /* synthetic */ void lambda$updateControllerInfo$15(ControllerInfo controllerInfo, Player.Listener listener) {
        listener.onIsPlayingChanged(controllerInfo.playerInfo.isPlaying);
    }

    public static /* synthetic */ void lambda$updateControllerInfo$16(ControllerInfo controllerInfo, Player.Listener listener) {
        listener.onPlaybackParametersChanged(controllerInfo.playerInfo.playbackParameters);
    }

    public static /* synthetic */ void lambda$updateControllerInfo$17(ControllerInfo controllerInfo, Player.Listener listener) {
        listener.onRepeatModeChanged(controllerInfo.playerInfo.repeatMode);
    }

    public static /* synthetic */ void lambda$updateControllerInfo$18(ControllerInfo controllerInfo, Player.Listener listener) {
        listener.onShuffleModeEnabledChanged(controllerInfo.playerInfo.shuffleModeEnabled);
    }

    public static /* synthetic */ void lambda$updateControllerInfo$19(ControllerInfo controllerInfo, Player.Listener listener) {
        listener.onAudioAttributesChanged(controllerInfo.playerInfo.audioAttributes);
    }

    public static /* synthetic */ void lambda$updateControllerInfo$20(ControllerInfo controllerInfo, Player.Listener listener) {
        listener.onDeviceInfoChanged(controllerInfo.playerInfo.deviceInfo);
    }

    public static /* synthetic */ void lambda$updateControllerInfo$21(ControllerInfo controllerInfo, Player.Listener listener) {
        PlayerInfo playerInfo = controllerInfo.playerInfo;
        listener.onDeviceVolumeChanged(playerInfo.deviceVolume, playerInfo.deviceMuted);
    }

    public static /* synthetic */ void lambda$updateControllerInfo$22(ControllerInfo controllerInfo, Player.Listener listener) {
        listener.onAvailableCommandsChanged(controllerInfo.availablePlayerCommands);
    }

    public /* synthetic */ void lambda$updateControllerInfo$23(ControllerInfo controllerInfo, MediaController.Listener listener) {
        listener.onAvailableSessionCommandsChanged(getInstance(), controllerInfo.availableSessionCommands);
    }

    public /* synthetic */ void lambda$updateControllerInfo$24(ControllerInfo controllerInfo, MediaController.Listener listener) {
        ignoreFuture(listener.onSetCustomLayout(getInstance(), controllerInfo.customLayout));
    }

    public /* synthetic */ void lambda$updateControllerInfo$5(ControllerInfo controllerInfo, MediaController.Listener listener) {
        ignoreFuture(listener.onSetCustomLayout(getInstance(), controllerInfo.customLayout));
    }

    public static /* synthetic */ void lambda$updateControllerInfo$6(ControllerInfo controllerInfo, Player.Listener listener) {
        listener.onTimelineChanged(controllerInfo.playerInfo.timeline, 0);
    }

    public static /* synthetic */ void lambda$updateControllerInfo$7(ControllerInfo controllerInfo, Player.Listener listener) {
        listener.onPlaylistMetadataChanged(controllerInfo.playerInfo.playlistMetadata);
    }

    public static /* synthetic */ void lambda$updateControllerInfo$8(ControllerInfo controllerInfo, ControllerInfo controllerInfo2, Integer num, Player.Listener listener) {
        listener.onPositionDiscontinuity(controllerInfo.playerInfo.sessionPositionInfo.positionInfo, controllerInfo2.playerInfo.sessionPositionInfo.positionInfo, num.intValue());
    }

    public static /* synthetic */ void lambda$updateControllerInfo$9(ControllerInfo controllerInfo, Integer num, Player.Listener listener) {
        listener.onMediaItemTransition(controllerInfo.playerInfo.getCurrentMediaItem(), num.intValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void seekToInternal(int r25, long r26) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.MediaControllerImplLegacy.seekToInternal(int, long):void");
    }

    private void updateControllerInfo(boolean z10, LegacyPlayerInfo legacyPlayerInfo, ControllerInfo controllerInfo, @Nullable Integer num, @Nullable Integer num2) {
        LegacyPlayerInfo legacyPlayerInfo2 = this.legacyPlayerInfo;
        ControllerInfo controllerInfo2 = this.controllerInfo;
        if (legacyPlayerInfo2 != legacyPlayerInfo) {
            this.legacyPlayerInfo = new LegacyPlayerInfo(legacyPlayerInfo);
        }
        this.pendingLegacyPlayerInfo = this.legacyPlayerInfo;
        this.controllerInfo = controllerInfo;
        if (z10) {
            getInstance().notifyAccepted();
            if (controllerInfo2.customLayout.equals(controllerInfo.customLayout)) {
                return;
            }
            getInstance().notifyControllerListener(new Consumer() { // from class: androidx.media3.session.e5

                /* renamed from: b */
                public final /* synthetic */ MediaControllerImplLegacy.ControllerInfo f503b;

                public /* synthetic */ e5(MediaControllerImplLegacy.ControllerInfo controllerInfo3) {
                    controllerInfo = controllerInfo3;
                }

                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaControllerImplLegacy.this.lambda$updateControllerInfo$5(controllerInfo, (MediaController.Listener) obj);
                }
            });
            return;
        }
        if (!controllerInfo2.playerInfo.timeline.equals(controllerInfo3.playerInfo.timeline)) {
            this.listeners.queueEvent(0, new ListenerSet.Event() { // from class: androidx.media3.session.q4
                public /* synthetic */ q4() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$6(MediaControllerImplLegacy.ControllerInfo.this, (Player.Listener) obj);
                }
            });
        }
        if (!Util.areEqual(legacyPlayerInfo2.queueTitle, legacyPlayerInfo.queueTitle)) {
            this.listeners.queueEvent(15, new ListenerSet.Event() { // from class: androidx.media3.session.r4
                public /* synthetic */ r4() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$7(MediaControllerImplLegacy.ControllerInfo.this, (Player.Listener) obj);
                }
            });
        }
        if (num != null) {
            this.listeners.queueEvent(11, new ListenerSet.Event() { // from class: androidx.media3.session.s4

                /* renamed from: b */
                public final /* synthetic */ MediaControllerImplLegacy.ControllerInfo f896b;

                /* renamed from: c */
                public final /* synthetic */ Integer f897c;

                public /* synthetic */ s4(MediaControllerImplLegacy.ControllerInfo controllerInfo3, Integer num3) {
                    controllerInfo = controllerInfo3;
                    num = num3;
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$8(MediaControllerImplLegacy.ControllerInfo.this, controllerInfo, num, (Player.Listener) obj);
                }
            });
        }
        if (num2 != null) {
            this.listeners.queueEvent(1, new ListenerSet.Event() { // from class: androidx.media3.session.u4

                /* renamed from: b */
                public final /* synthetic */ Integer f944b;

                public /* synthetic */ u4(Integer num22) {
                    num2 = num22;
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$9(MediaControllerImplLegacy.ControllerInfo.this, num2, (Player.Listener) obj);
                }
            });
        }
        if (!MediaUtils.areEqualError(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo.playbackStateCompat)) {
            PlaybackException convertToPlaybackException = MediaUtils.convertToPlaybackException(legacyPlayerInfo.playbackStateCompat);
            this.listeners.queueEvent(10, new ListenerSet.Event() { // from class: androidx.media3.session.v4
                public /* synthetic */ v4() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).onPlayerErrorChanged(PlaybackException.this);
                }
            });
            if (convertToPlaybackException != null) {
                this.listeners.queueEvent(10, new ListenerSet.Event() { // from class: androidx.media3.session.w4
                    public /* synthetic */ w4() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        ((Player.Listener) obj).onPlayerError(PlaybackException.this);
                    }
                });
            }
        }
        if (legacyPlayerInfo2.mediaMetadataCompat != legacyPlayerInfo.mediaMetadataCompat) {
            this.listeners.queueEvent(14, new ListenerSet.Event() { // from class: androidx.media3.session.x4
                public /* synthetic */ x4() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.this.lambda$updateControllerInfo$12((Player.Listener) obj);
                }
            });
        }
        if (controllerInfo2.playerInfo.playbackState != controllerInfo3.playerInfo.playbackState) {
            this.listeners.queueEvent(4, new ListenerSet.Event() { // from class: androidx.media3.session.y4
                public /* synthetic */ y4() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$13(MediaControllerImplLegacy.ControllerInfo.this, (Player.Listener) obj);
                }
            });
        }
        if (controllerInfo2.playerInfo.playWhenReady != controllerInfo3.playerInfo.playWhenReady) {
            this.listeners.queueEvent(5, new ListenerSet.Event() { // from class: androidx.media3.session.z4
                public /* synthetic */ z4() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$14(MediaControllerImplLegacy.ControllerInfo.this, (Player.Listener) obj);
                }
            });
        }
        if (controllerInfo2.playerInfo.isPlaying != controllerInfo3.playerInfo.isPlaying) {
            this.listeners.queueEvent(7, new ListenerSet.Event() { // from class: androidx.media3.session.f5
                public /* synthetic */ f5() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$15(MediaControllerImplLegacy.ControllerInfo.this, (Player.Listener) obj);
                }
            });
        }
        if (!controllerInfo2.playerInfo.playbackParameters.equals(controllerInfo3.playerInfo.playbackParameters)) {
            this.listeners.queueEvent(12, new ListenerSet.Event() { // from class: androidx.media3.session.g5
                public /* synthetic */ g5() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$16(MediaControllerImplLegacy.ControllerInfo.this, (Player.Listener) obj);
                }
            });
        }
        if (controllerInfo2.playerInfo.repeatMode != controllerInfo3.playerInfo.repeatMode) {
            this.listeners.queueEvent(8, new ListenerSet.Event() { // from class: androidx.media3.session.h5
                public /* synthetic */ h5() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$17(MediaControllerImplLegacy.ControllerInfo.this, (Player.Listener) obj);
                }
            });
        }
        if (controllerInfo2.playerInfo.shuffleModeEnabled != controllerInfo3.playerInfo.shuffleModeEnabled) {
            this.listeners.queueEvent(9, new ListenerSet.Event() { // from class: androidx.media3.session.j4
                public /* synthetic */ j4() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$18(MediaControllerImplLegacy.ControllerInfo.this, (Player.Listener) obj);
                }
            });
        }
        if (!controllerInfo2.playerInfo.audioAttributes.equals(controllerInfo3.playerInfo.audioAttributes)) {
            this.listeners.queueEvent(20, new ListenerSet.Event() { // from class: androidx.media3.session.k4
                public /* synthetic */ k4() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$19(MediaControllerImplLegacy.ControllerInfo.this, (Player.Listener) obj);
                }
            });
        }
        if (!controllerInfo2.playerInfo.deviceInfo.equals(controllerInfo3.playerInfo.deviceInfo)) {
            this.listeners.queueEvent(29, new ListenerSet.Event() { // from class: androidx.media3.session.l4
                public /* synthetic */ l4() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$20(MediaControllerImplLegacy.ControllerInfo.this, (Player.Listener) obj);
                }
            });
        }
        PlayerInfo playerInfo = controllerInfo2.playerInfo;
        int i10 = playerInfo.deviceVolume;
        PlayerInfo playerInfo2 = controllerInfo3.playerInfo;
        if (i10 != playerInfo2.deviceVolume || playerInfo.deviceMuted != playerInfo2.deviceMuted) {
            this.listeners.queueEvent(30, new ListenerSet.Event() { // from class: androidx.media3.session.m4
                public /* synthetic */ m4() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$21(MediaControllerImplLegacy.ControllerInfo.this, (Player.Listener) obj);
                }
            });
        }
        if (!controllerInfo2.availablePlayerCommands.equals(controllerInfo3.availablePlayerCommands)) {
            this.listeners.queueEvent(13, new ListenerSet.Event() { // from class: androidx.media3.session.n4
                public /* synthetic */ n4() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$22(MediaControllerImplLegacy.ControllerInfo.this, (Player.Listener) obj);
                }
            });
        }
        if (!controllerInfo2.availableSessionCommands.equals(controllerInfo3.availableSessionCommands)) {
            getInstance().notifyControllerListener(new Consumer() { // from class: androidx.media3.session.o4

                /* renamed from: b */
                public final /* synthetic */ MediaControllerImplLegacy.ControllerInfo f805b;

                public /* synthetic */ o4(MediaControllerImplLegacy.ControllerInfo controllerInfo3) {
                    controllerInfo = controllerInfo3;
                }

                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaControllerImplLegacy.this.lambda$updateControllerInfo$23(controllerInfo, (MediaController.Listener) obj);
                }
            });
        }
        if (!controllerInfo2.customLayout.equals(controllerInfo3.customLayout)) {
            getInstance().notifyControllerListener(new Consumer() { // from class: androidx.media3.session.p4

                /* renamed from: b */
                public final /* synthetic */ MediaControllerImplLegacy.ControllerInfo f826b;

                public /* synthetic */ p4(MediaControllerImplLegacy.ControllerInfo controllerInfo3) {
                    controllerInfo = controllerInfo3;
                }

                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaControllerImplLegacy.this.lambda$updateControllerInfo$24(controllerInfo, (MediaController.Listener) obj);
                }
            });
        }
        this.listeners.flushEvents();
    }

    private void updateStateMaskedControllerInfo(ControllerInfo controllerInfo, @Nullable Integer num, @Nullable Integer num2) {
        updateControllerInfo(false, this.legacyPlayerInfo, controllerInfo, num, num2);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void addListener(Player.Listener listener) {
        this.listeners.add(listener);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void addMediaItem(MediaItem mediaItem) {
        addMediaItems(Integer.MAX_VALUE, Collections.singletonList(mediaItem));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void addMediaItems(List<MediaItem> list) {
        addMediaItems(Integer.MAX_VALUE, list);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void clearMediaItems() {
        removeMediaItems(0, Integer.MAX_VALUE);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void clearVideoSurface() {
        Log.w(TAG, "Session doesn't support clearing Surface");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        Log.w(TAG, "Session doesn't support clearing SurfaceHolder");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void clearVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        Log.w(TAG, "Session doesn't support clearing SurfaceView");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void clearVideoTextureView(@Nullable TextureView textureView) {
        Log.w(TAG, "Session doesn't support clearing TextureView");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void connect() {
        if (this.token.getType() == 0) {
            connectToSession((MediaSessionCompat.Token) Assertions.checkStateNotNull(this.token.getBinder()));
        } else {
            connectToService();
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    @Deprecated
    public void decreaseDeviceVolume() {
        decreaseDeviceVolume(1);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public AudioAttributes getAudioAttributes() {
        return this.controllerInfo.playerInfo.audioAttributes;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public Player.Commands getAvailableCommands() {
        return this.controllerInfo.availablePlayerCommands;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public SessionCommands getAvailableSessionCommands() {
        return this.controllerInfo.availableSessionCommands;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    @Nullable
    public MediaBrowserCompat getBrowserCompat() {
        return this.browserCompat;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getBufferedPercentage() {
        return this.controllerInfo.playerInfo.sessionPositionInfo.bufferedPercentage;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getBufferedPosition() {
        return this.controllerInfo.playerInfo.sessionPositionInfo.bufferedPositionMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    @Nullable
    public SessionToken getConnectedToken() {
        if (this.connected) {
            return this.token;
        }
        return null;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getContentBufferedPosition() {
        return getBufferedPosition();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getContentDuration() {
        return getDuration();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getContentPosition() {
        return getCurrentPosition();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public Context getContext() {
        return this.context;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getCurrentAdGroupIndex() {
        return -1;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getCurrentAdIndexInAdGroup() {
        return -1;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public CueGroup getCurrentCues() {
        Log.w(TAG, "Session doesn't support getting Cue");
        return CueGroup.EMPTY_TIME_ZERO;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getCurrentLiveOffset() {
        return C.TIME_UNSET;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getCurrentMediaItemIndex() {
        return this.controllerInfo.playerInfo.sessionPositionInfo.positionInfo.mediaItemIndex;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getCurrentPeriodIndex() {
        return getCurrentMediaItemIndex();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getCurrentPosition() {
        return this.controllerInfo.playerInfo.sessionPositionInfo.positionInfo.positionMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public Timeline getCurrentTimeline() {
        return this.controllerInfo.playerInfo.timeline;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public Tracks getCurrentTracks() {
        return Tracks.EMPTY;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public DeviceInfo getDeviceInfo() {
        return this.controllerInfo.playerInfo.deviceInfo;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getDeviceVolume() {
        return this.controllerInfo.playerInfo.deviceVolume;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getDuration() {
        return this.controllerInfo.playerInfo.sessionPositionInfo.durationMs;
    }

    public MediaController getInstance() {
        return this.instance;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getMaxSeekToPreviousPosition() {
        return 0L;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public MediaMetadata getMediaMetadata() {
        MediaItem currentMediaItem = this.controllerInfo.playerInfo.getCurrentMediaItem();
        return currentMediaItem == null ? MediaMetadata.EMPTY : currentMediaItem.mediaMetadata;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getNextMediaItemIndex() {
        return -1;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean getPlayWhenReady() {
        return this.controllerInfo.playerInfo.playWhenReady;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public PlaybackParameters getPlaybackParameters() {
        return this.controllerInfo.playerInfo.playbackParameters;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getPlaybackState() {
        return this.controllerInfo.playerInfo.playbackState;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getPlaybackSuppressionReason() {
        return 0;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    @Nullable
    public PlaybackException getPlayerError() {
        return this.controllerInfo.playerInfo.playerError;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public MediaMetadata getPlaylistMetadata() {
        return this.controllerInfo.playerInfo.playlistMetadata;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getPreviousMediaItemIndex() {
        return -1;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getRepeatMode() {
        return this.controllerInfo.playerInfo.repeatMode;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getSeekBackIncrement() {
        return this.controllerInfo.playerInfo.seekBackIncrementMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getSeekForwardIncrement() {
        return this.controllerInfo.playerInfo.seekForwardIncrementMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    @Nullable
    public PendingIntent getSessionActivity() {
        return this.controllerCompat.getSessionActivity();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean getShuffleModeEnabled() {
        return this.controllerInfo.playerInfo.shuffleModeEnabled;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public Size getSurfaceSize() {
        Log.w(TAG, "Session doesn't support getting VideoSurfaceSize");
        return Size.UNKNOWN;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getTotalBufferedDuration() {
        return this.controllerInfo.playerInfo.sessionPositionInfo.totalBufferedDurationMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public TrackSelectionParameters getTrackSelectionParameters() {
        return TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public VideoSize getVideoSize() {
        Log.w(TAG, "Session doesn't support getting VideoSize");
        return VideoSize.UNKNOWN;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public float getVolume() {
        return 1.0f;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean hasNextMediaItem() {
        return this.connected;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean hasPreviousMediaItem() {
        return this.connected;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    @Deprecated
    public void increaseDeviceVolume() {
        increaseDeviceVolume(1);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean isConnected() {
        return this.connected;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean isDeviceMuted() {
        return this.controllerInfo.playerInfo.deviceMuted;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean isLoading() {
        return false;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean isPlaying() {
        return this.controllerInfo.playerInfo.isPlaying;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean isPlayingAd() {
        return this.controllerInfo.playerInfo.sessionPositionInfo.isPlayingAd;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void moveMediaItem(int i10, int i11) {
        moveMediaItems(i10, i10 + 1, i11);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void moveMediaItems(int i10, int i11, int i12) {
        Assertions.checkArgument(i10 >= 0 && i10 <= i11 && i12 >= 0);
        QueueTimeline queueTimeline = (QueueTimeline) this.controllerInfo.playerInfo.timeline;
        int windowCount = queueTimeline.getWindowCount();
        int min = Math.min(i11, windowCount);
        int i13 = min - i10;
        int i14 = windowCount - i13;
        int i15 = i14 - 1;
        int min2 = Math.min(i12, i14);
        if (i10 >= windowCount || i10 == min || i10 == min2) {
            return;
        }
        int calculateCurrentItemIndexAfterRemoveItems = calculateCurrentItemIndexAfterRemoveItems(getCurrentMediaItemIndex(), i10, min);
        if (calculateCurrentItemIndexAfterRemoveItems == -1) {
            calculateCurrentItemIndexAfterRemoveItems = Util.constrainValue(i10, 0, i15);
            Log.w(TAG, "Currently playing item will be removed and added back to mimic move. Assumes item at " + calculateCurrentItemIndexAfterRemoveItems + " would be the new current item");
        }
        PlayerInfo copyWithTimelineAndMediaItemIndex = this.controllerInfo.playerInfo.copyWithTimelineAndMediaItemIndex(queueTimeline.copyWithMovedMediaItems(i10, min, min2), calculateCurrentItemIndexAfterAddItems(calculateCurrentItemIndexAfterRemoveItems, min2, i13));
        ControllerInfo controllerInfo = this.controllerInfo;
        updateStateMaskedControllerInfo(new ControllerInfo(copyWithTimelineAndMediaItemIndex, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout), null, null);
        if (isPrepared()) {
            ArrayList arrayList = new ArrayList();
            for (int i16 = 0; i16 < i13; i16++) {
                arrayList.add(this.legacyPlayerInfo.queue.get(i10));
                this.controllerCompat.removeQueueItem(this.legacyPlayerInfo.queue.get(i10).getDescription());
            }
            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                this.controllerCompat.addQueueItem(((MediaSessionCompat.QueueItem) arrayList.get(i17)).getDescription(), i17 + min2);
            }
        }
    }

    public void onConnected() {
        if (this.released || this.connected) {
            return;
        }
        this.connected = true;
        handleNewLegacyParameters(true, new LegacyPlayerInfo(this.controllerCompat.getPlaybackInfo(), convertToSafePlaybackStateCompat(this.controllerCompat.getPlaybackState()), this.controllerCompat.getMetadata(), convertToNonNullQueueItemList(this.controllerCompat.getQueue()), this.controllerCompat.getQueueTitle(), this.controllerCompat.getRepeatMode(), this.controllerCompat.getShuffleMode()));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void pause() {
        PlayerInfo playerInfo = this.controllerInfo.playerInfo;
        if (playerInfo.playWhenReady) {
            PlayerInfo copyWithPlayWhenReady = playerInfo.copyWithPlayWhenReady(false, 1, 0);
            ControllerInfo controllerInfo = this.controllerInfo;
            updateStateMaskedControllerInfo(new ControllerInfo(copyWithPlayWhenReady, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout), null, null);
            if (isPrepared() && hasMedia()) {
                this.controllerCompat.getTransportControls().pause();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void play() {
        PlayerInfo playerInfo = this.controllerInfo.playerInfo;
        if (playerInfo.playWhenReady) {
            return;
        }
        PlayerInfo copyWithPlayWhenReady = playerInfo.copyWithPlayWhenReady(true, 1, 0);
        ControllerInfo controllerInfo = this.controllerInfo;
        updateStateMaskedControllerInfo(new ControllerInfo(copyWithPlayWhenReady, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout), null, null);
        if (isPrepared() && hasMedia()) {
            this.controllerCompat.getTransportControls().play();
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void prepare() {
        PlayerInfo playerInfo = this.controllerInfo.playerInfo;
        if (playerInfo.playbackState != 1) {
            return;
        }
        PlayerInfo copyWithPlaybackState = playerInfo.copyWithPlaybackState(playerInfo.timeline.isEmpty() ? 4 : 2, null);
        ControllerInfo controllerInfo = this.controllerInfo;
        updateStateMaskedControllerInfo(new ControllerInfo(copyWithPlaybackState, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout), null, null);
        if (hasMedia()) {
            initializeLegacyPlaylist();
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void release() {
        if (this.released) {
            return;
        }
        this.released = true;
        MediaBrowserCompat mediaBrowserCompat = this.browserCompat;
        if (mediaBrowserCompat != null) {
            mediaBrowserCompat.disconnect();
            this.browserCompat = null;
        }
        MediaControllerCompat mediaControllerCompat = this.controllerCompat;
        if (mediaControllerCompat != null) {
            mediaControllerCompat.unregisterCallback(this.controllerCompatCallback);
            this.controllerCompatCallback.release();
            this.controllerCompat = null;
        }
        this.connected = false;
        this.listeners.release();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void removeListener(Player.Listener listener) {
        this.listeners.remove(listener);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void removeMediaItem(int i10) {
        removeMediaItems(i10, i10 + 1);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void removeMediaItems(int i10, int i11) {
        Assertions.checkArgument(i10 >= 0 && i11 >= i10);
        int windowCount = getCurrentTimeline().getWindowCount();
        int min = Math.min(i11, windowCount);
        if (i10 >= windowCount || i10 == min) {
            return;
        }
        QueueTimeline copyWithRemovedMediaItems = ((QueueTimeline) this.controllerInfo.playerInfo.timeline).copyWithRemovedMediaItems(i10, min);
        int calculateCurrentItemIndexAfterRemoveItems = calculateCurrentItemIndexAfterRemoveItems(getCurrentMediaItemIndex(), i10, min);
        if (calculateCurrentItemIndexAfterRemoveItems == -1) {
            calculateCurrentItemIndexAfterRemoveItems = Util.constrainValue(i10, 0, copyWithRemovedMediaItems.getWindowCount() - 1);
            Log.w(TAG, "Currently playing item is removed. Assumes item at " + calculateCurrentItemIndexAfterRemoveItems + " is the new current item");
        }
        PlayerInfo copyWithTimelineAndMediaItemIndex = this.controllerInfo.playerInfo.copyWithTimelineAndMediaItemIndex(copyWithRemovedMediaItems, calculateCurrentItemIndexAfterRemoveItems);
        ControllerInfo controllerInfo = this.controllerInfo;
        updateStateMaskedControllerInfo(new ControllerInfo(copyWithTimelineAndMediaItemIndex, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout), null, null);
        if (isPrepared()) {
            while (i10 < min && i10 < this.legacyPlayerInfo.queue.size()) {
                this.controllerCompat.removeQueueItem(this.legacyPlayerInfo.queue.get(i10).getDescription());
                i10++;
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void replaceMediaItem(int i10, MediaItem mediaItem) {
        replaceMediaItems(i10, i10 + 1, ImmutableList.of(mediaItem));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void replaceMediaItems(int i10, int i11, List<MediaItem> list) {
        Assertions.checkArgument(i10 >= 0 && i10 <= i11);
        int windowCount = ((QueueTimeline) this.controllerInfo.playerInfo.timeline).getWindowCount();
        if (i10 > windowCount) {
            return;
        }
        int min = Math.min(i11, windowCount);
        addMediaItems(min, list);
        removeMediaItems(i10, min);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekBack() {
        this.controllerCompat.getTransportControls().rewind();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekForward() {
        this.controllerCompat.getTransportControls().fastForward();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekTo(long j10) {
        seekToInternal(getCurrentMediaItemIndex(), j10);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekToDefaultPosition() {
        seekToInternal(getCurrentMediaItemIndex(), 0L);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekToNext() {
        this.controllerCompat.getTransportControls().skipToNext();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekToNextMediaItem() {
        this.controllerCompat.getTransportControls().skipToNext();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekToPrevious() {
        this.controllerCompat.getTransportControls().skipToPrevious();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekToPreviousMediaItem() {
        this.controllerCompat.getTransportControls().skipToPrevious();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public p5.c0<SessionResult> sendCustomCommand(SessionCommand sessionCommand, Bundle bundle) {
        if (this.controllerInfo.availableSessionCommands.contains(sessionCommand)) {
            this.controllerCompat.getTransportControls().sendCustomAction(sessionCommand.customAction, bundle);
            return com.google.common.util.concurrent.l.m(new SessionResult(0));
        }
        com.google.common.util.concurrent.s n10 = com.google.common.util.concurrent.s.n();
        this.controllerCompat.sendCommand(sessionCommand.customAction, bundle, new ResultReceiver(this, getInstance().applicationHandler) { // from class: androidx.media3.session.MediaControllerImplLegacy.1
            final /* synthetic */ com.google.common.util.concurrent.s val$result;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(MediaControllerImplLegacy this, Handler handler, com.google.common.util.concurrent.s n102) {
                super(handler);
                n10 = n102;
            }

            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i10, Bundle bundle2) {
                com.google.common.util.concurrent.s sVar = n10;
                if (bundle2 == null) {
                    bundle2 = Bundle.EMPTY;
                }
                sVar.set(new SessionResult(i10, bundle2));
            }
        });
        return n102;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    @Deprecated
    public void setDeviceMuted(boolean z10) {
        setDeviceMuted(z10, 1);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    @Deprecated
    public void setDeviceVolume(int i10) {
        setDeviceVolume(i10, 1);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setMediaItem(MediaItem mediaItem) {
        setMediaItem(mediaItem, C.TIME_UNSET);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setMediaItems(List<MediaItem> list) {
        setMediaItems(list, 0, C.TIME_UNSET);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setPlayWhenReady(boolean z10) {
        if (z10) {
            play();
        } else {
            pause();
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        if (!playbackParameters.equals(getPlaybackParameters())) {
            PlayerInfo copyWithPlaybackParameters = this.controllerInfo.playerInfo.copyWithPlaybackParameters(playbackParameters);
            ControllerInfo controllerInfo = this.controllerInfo;
            updateStateMaskedControllerInfo(new ControllerInfo(copyWithPlaybackParameters, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout), null, null);
        }
        this.controllerCompat.getTransportControls().setPlaybackSpeed(playbackParameters.speed);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setPlaybackSpeed(float f10) {
        if (f10 != getPlaybackParameters().speed) {
            PlayerInfo copyWithPlaybackParameters = this.controllerInfo.playerInfo.copyWithPlaybackParameters(new PlaybackParameters(f10));
            ControllerInfo controllerInfo = this.controllerInfo;
            updateStateMaskedControllerInfo(new ControllerInfo(copyWithPlaybackParameters, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout), null, null);
        }
        this.controllerCompat.getTransportControls().setPlaybackSpeed(f10);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setPlaylistMetadata(MediaMetadata mediaMetadata) {
        Log.w(TAG, "Session doesn't support setting playlist metadata");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public p5.c0<SessionResult> setRating(String str, Rating rating) {
        if (str.equals(this.legacyPlayerInfo.mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID))) {
            this.controllerCompat.getTransportControls().setRating(MediaUtils.convertToRatingCompat(rating));
        }
        return com.google.common.util.concurrent.l.m(new SessionResult(0));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setRepeatMode(int i10) {
        if (i10 != getRepeatMode()) {
            PlayerInfo copyWithRepeatMode = this.controllerInfo.playerInfo.copyWithRepeatMode(i10);
            ControllerInfo controllerInfo = this.controllerInfo;
            updateStateMaskedControllerInfo(new ControllerInfo(copyWithRepeatMode, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout), null, null);
        }
        this.controllerCompat.getTransportControls().setRepeatMode(MediaUtils.convertToPlaybackStateCompatRepeatMode(i10));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setShuffleModeEnabled(boolean z10) {
        if (z10 != getShuffleModeEnabled()) {
            PlayerInfo copyWithShuffleModeEnabled = this.controllerInfo.playerInfo.copyWithShuffleModeEnabled(z10);
            ControllerInfo controllerInfo = this.controllerInfo;
            updateStateMaskedControllerInfo(new ControllerInfo(copyWithShuffleModeEnabled, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout), null, null);
        }
        this.controllerCompat.getTransportControls().setShuffleMode(MediaUtils.convertToPlaybackStateCompatShuffleMode(z10));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setVideoSurface(@Nullable Surface surface) {
        Log.w(TAG, "Session doesn't support setting Surface");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        Log.w(TAG, "Session doesn't support setting SurfaceHolder");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        Log.w(TAG, "Session doesn't support setting SurfaceView");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setVideoTextureView(@Nullable TextureView textureView) {
        Log.w(TAG, "Session doesn't support setting TextureView");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setVolume(float f10) {
        Log.w(TAG, "Session doesn't support setting player volume");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void stop() {
        PlayerInfo playerInfo = this.controllerInfo.playerInfo;
        if (playerInfo.playbackState == 1) {
            return;
        }
        SessionPositionInfo sessionPositionInfo = playerInfo.sessionPositionInfo;
        Player.PositionInfo positionInfo = sessionPositionInfo.positionInfo;
        long j10 = sessionPositionInfo.durationMs;
        long j11 = positionInfo.positionMs;
        PlayerInfo copyWithSessionPositionInfo = playerInfo.copyWithSessionPositionInfo(createSessionPositionInfo(positionInfo, false, j10, j11, MediaUtils.calculateBufferedPercentage(j11, j10), 0L));
        PlayerInfo playerInfo2 = this.controllerInfo.playerInfo;
        if (playerInfo2.playbackState != 1) {
            copyWithSessionPositionInfo = copyWithSessionPositionInfo.copyWithPlaybackState(1, playerInfo2.playerError);
        }
        ControllerInfo controllerInfo = this.controllerInfo;
        updateStateMaskedControllerInfo(new ControllerInfo(copyWithSessionPositionInfo, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout), null, null);
        this.controllerCompat.getTransportControls().stop();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void addMediaItem(int i10, MediaItem mediaItem) {
        addMediaItems(i10, Collections.singletonList(mediaItem));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void addMediaItems(int i10, List<MediaItem> list) {
        Assertions.checkArgument(i10 >= 0);
        if (list.isEmpty()) {
            return;
        }
        QueueTimeline queueTimeline = (QueueTimeline) this.controllerInfo.playerInfo.timeline;
        if (queueTimeline.isEmpty()) {
            setMediaItems(list);
            return;
        }
        int min = Math.min(i10, getCurrentTimeline().getWindowCount());
        PlayerInfo copyWithTimelineAndMediaItemIndex = this.controllerInfo.playerInfo.copyWithTimelineAndMediaItemIndex(queueTimeline.copyWithNewMediaItems(min, list), calculateCurrentItemIndexAfterAddItems(getCurrentMediaItemIndex(), min, list.size()));
        ControllerInfo controllerInfo = this.controllerInfo;
        updateStateMaskedControllerInfo(new ControllerInfo(copyWithTimelineAndMediaItemIndex, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout), null, null);
        if (isPrepared()) {
            addQueueItems(list, min);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void clearVideoSurface(@Nullable Surface surface) {
        Log.w(TAG, "Session doesn't support clearing Surface");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void decreaseDeviceVolume(int i10) {
        int deviceVolume = getDeviceVolume() - 1;
        if (deviceVolume >= getDeviceInfo().minVolume) {
            PlayerInfo copyWithDeviceVolume = this.controllerInfo.playerInfo.copyWithDeviceVolume(deviceVolume, isDeviceMuted());
            ControllerInfo controllerInfo = this.controllerInfo;
            updateStateMaskedControllerInfo(new ControllerInfo(copyWithDeviceVolume, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout), null, null);
        }
        this.controllerCompat.adjustVolume(-1, i10);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void increaseDeviceVolume(int i10) {
        int deviceVolume = getDeviceVolume();
        int i11 = getDeviceInfo().maxVolume;
        if (i11 == 0 || deviceVolume + 1 <= i11) {
            PlayerInfo copyWithDeviceVolume = this.controllerInfo.playerInfo.copyWithDeviceVolume(deviceVolume + 1, isDeviceMuted());
            ControllerInfo controllerInfo = this.controllerInfo;
            updateStateMaskedControllerInfo(new ControllerInfo(copyWithDeviceVolume, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout), null, null);
        }
        this.controllerCompat.adjustVolume(1, i10);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekTo(int i10, long j10) {
        seekToInternal(i10, j10);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekToDefaultPosition(int i10) {
        seekToInternal(i10, 0L);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setDeviceMuted(boolean z10, int i10) {
        if (Util.SDK_INT < 23) {
            Log.w(TAG, "Session doesn't support setting mute state at API level less than 23");
            return;
        }
        if (z10 != isDeviceMuted()) {
            PlayerInfo copyWithDeviceVolume = this.controllerInfo.playerInfo.copyWithDeviceVolume(getDeviceVolume(), z10);
            ControllerInfo controllerInfo = this.controllerInfo;
            updateStateMaskedControllerInfo(new ControllerInfo(copyWithDeviceVolume, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout), null, null);
        }
        this.controllerCompat.adjustVolume(z10 ? -100 : 100, i10);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setDeviceVolume(int i10, int i11) {
        DeviceInfo deviceInfo = getDeviceInfo();
        int i12 = deviceInfo.minVolume;
        int i13 = deviceInfo.maxVolume;
        if (i12 <= i10 && (i13 == 0 || i10 <= i13)) {
            PlayerInfo copyWithDeviceVolume = this.controllerInfo.playerInfo.copyWithDeviceVolume(i10, isDeviceMuted());
            ControllerInfo controllerInfo = this.controllerInfo;
            updateStateMaskedControllerInfo(new ControllerInfo(copyWithDeviceVolume, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout), null, null);
        }
        this.controllerCompat.setVolumeTo(i10, i11);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setMediaItem(MediaItem mediaItem, long j10) {
        setMediaItems(ImmutableList.of(mediaItem), 0, j10);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setMediaItems(List<MediaItem> list, boolean z10) {
        setMediaItems(list);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setMediaItem(MediaItem mediaItem, boolean z10) {
        setMediaItem(mediaItem);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setMediaItems(List<MediaItem> list, int i10, long j10) {
        if (list.isEmpty()) {
            clearMediaItems();
            return;
        }
        PlayerInfo copyWithTimelineAndSessionPositionInfo = this.controllerInfo.playerInfo.copyWithTimelineAndSessionPositionInfo(QueueTimeline.DEFAULT.copyWithNewMediaItems(0, list), createSessionPositionInfo(createPositionInfo(i10, list.get(i10), j10 == C.TIME_UNSET ? 0L : j10, false), false, C.TIME_UNSET, 0L, 0, 0L));
        ControllerInfo controllerInfo = this.controllerInfo;
        updateStateMaskedControllerInfo(new ControllerInfo(copyWithTimelineAndSessionPositionInfo, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout), null, null);
        if (isPrepared()) {
            initializeLegacyPlaylist();
        }
    }

    public static class ControllerInfo {
        public final Player.Commands availablePlayerCommands;
        public final SessionCommands availableSessionCommands;
        public final ImmutableList<CommandButton> customLayout;
        public final PlayerInfo playerInfo;

        public ControllerInfo() {
            this.playerInfo = PlayerInfo.DEFAULT.copyWithTimeline(QueueTimeline.DEFAULT);
            this.availableSessionCommands = SessionCommands.EMPTY;
            this.availablePlayerCommands = Player.Commands.EMPTY;
            this.customLayout = ImmutableList.of();
        }

        public ControllerInfo(PlayerInfo playerInfo, SessionCommands sessionCommands, Player.Commands commands, ImmutableList<CommandButton> immutableList) {
            this.playerInfo = playerInfo;
            this.availableSessionCommands = sessionCommands;
            this.availablePlayerCommands = commands;
            this.customLayout = immutableList;
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public p5.c0<SessionResult> setRating(Rating rating) {
        this.controllerCompat.getTransportControls().setRating(MediaUtils.convertToRatingCompat(rating));
        return com.google.common.util.concurrent.l.m(new SessionResult(0));
    }

    public static final class LegacyPlayerInfo {

        @Nullable
        public final MediaMetadataCompat mediaMetadataCompat;

        @Nullable
        public final MediaControllerCompat.PlaybackInfo playbackInfoCompat;

        @Nullable
        public final PlaybackStateCompat playbackStateCompat;
        public final List<MediaSessionCompat.QueueItem> queue;

        @Nullable
        public final CharSequence queueTitle;
        public final int repeatMode;
        public final int shuffleMode;

        public LegacyPlayerInfo() {
            this.playbackInfoCompat = null;
            this.playbackStateCompat = null;
            this.mediaMetadataCompat = null;
            this.queue = Collections.emptyList();
            this.queueTitle = null;
            this.repeatMode = 0;
            this.shuffleMode = 0;
        }

        @CheckResult
        public LegacyPlayerInfo copyWithExtraBinderGetters(@Nullable PlaybackStateCompat playbackStateCompat, int i10, int i11) {
            return new LegacyPlayerInfo(this.playbackInfoCompat, playbackStateCompat, this.mediaMetadataCompat, this.queue, this.queueTitle, i10, i11);
        }

        @CheckResult
        public LegacyPlayerInfo copyWithMediaMetadataCompat(@Nullable MediaMetadataCompat mediaMetadataCompat) {
            return new LegacyPlayerInfo(this.playbackInfoCompat, this.playbackStateCompat, mediaMetadataCompat, this.queue, this.queueTitle, this.repeatMode, this.shuffleMode);
        }

        @CheckResult
        public LegacyPlayerInfo copyWithPlaybackInfoCompat(@Nullable MediaControllerCompat.PlaybackInfo playbackInfo) {
            return new LegacyPlayerInfo(playbackInfo, this.playbackStateCompat, this.mediaMetadataCompat, this.queue, this.queueTitle, this.repeatMode, this.shuffleMode);
        }

        @CheckResult
        public LegacyPlayerInfo copyWithPlaybackStateCompat(@Nullable PlaybackStateCompat playbackStateCompat) {
            return new LegacyPlayerInfo(this.playbackInfoCompat, playbackStateCompat, this.mediaMetadataCompat, this.queue, this.queueTitle, this.repeatMode, this.shuffleMode);
        }

        @CheckResult
        public LegacyPlayerInfo copyWithQueue(List<MediaSessionCompat.QueueItem> list) {
            return new LegacyPlayerInfo(this.playbackInfoCompat, this.playbackStateCompat, this.mediaMetadataCompat, list, this.queueTitle, this.repeatMode, this.shuffleMode);
        }

        @CheckResult
        public LegacyPlayerInfo copyWithQueueTitle(@Nullable CharSequence charSequence) {
            return new LegacyPlayerInfo(this.playbackInfoCompat, this.playbackStateCompat, this.mediaMetadataCompat, this.queue, charSequence, this.repeatMode, this.shuffleMode);
        }

        @CheckResult
        public LegacyPlayerInfo copyWithRepeatMode(int i10) {
            return new LegacyPlayerInfo(this.playbackInfoCompat, this.playbackStateCompat, this.mediaMetadataCompat, this.queue, this.queueTitle, i10, this.shuffleMode);
        }

        @CheckResult
        public LegacyPlayerInfo copyWithShuffleMode(int i10) {
            return new LegacyPlayerInfo(this.playbackInfoCompat, this.playbackStateCompat, this.mediaMetadataCompat, this.queue, this.queueTitle, this.repeatMode, i10);
        }

        public LegacyPlayerInfo(@Nullable MediaControllerCompat.PlaybackInfo playbackInfo, @Nullable PlaybackStateCompat playbackStateCompat, @Nullable MediaMetadataCompat mediaMetadataCompat, List<MediaSessionCompat.QueueItem> list, @Nullable CharSequence charSequence, int i10, int i11) {
            this.playbackInfoCompat = playbackInfo;
            this.playbackStateCompat = playbackStateCompat;
            this.mediaMetadataCompat = mediaMetadataCompat;
            this.queue = (List) Assertions.checkNotNull(list);
            this.queueTitle = charSequence;
            this.repeatMode = i10;
            this.shuffleMode = i11;
        }

        public LegacyPlayerInfo(LegacyPlayerInfo legacyPlayerInfo) {
            this.playbackInfoCompat = legacyPlayerInfo.playbackInfoCompat;
            this.playbackStateCompat = legacyPlayerInfo.playbackStateCompat;
            this.mediaMetadataCompat = legacyPlayerInfo.mediaMetadataCompat;
            this.queue = legacyPlayerInfo.queue;
            this.queueTitle = legacyPlayerInfo.queueTitle;
            this.repeatMode = legacyPlayerInfo.repeatMode;
            this.shuffleMode = legacyPlayerInfo.shuffleMode;
        }
    }
}
