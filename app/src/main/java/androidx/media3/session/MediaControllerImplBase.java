package androidx.media3.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.media.MediaBrowserCompat;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.BundleListRetriever;
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
import androidx.media3.common.util.BundleableUtil;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import androidx.media3.session.IMediaSession;
import androidx.media3.session.IMediaSessionService;
import androidx.media3.session.MediaController;
import androidx.media3.session.MediaControllerImplBase;
import androidx.media3.session.PlayerInfo;
import androidx.media3.session.SequencedFutureManager;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import p0.r;

/* loaded from: classes.dex */
class MediaControllerImplBase implements MediaController.MediaControllerImpl {
    private static final long RELEASE_TIMEOUT_MS = 30000;
    public static final String TAG = "MCImplBase";

    @Nullable
    private SessionToken connectedToken;
    private final Bundle connectionHints;
    private final Context context;
    protected final MediaControllerStub controllerStub;
    private long currentPositionMs;
    private final IBinder.DeathRecipient deathRecipient;
    private final FlushCommandQueueHandler flushCommandQueueHandler;

    @Nullable
    private IMediaSession iSession;
    private final MediaController instance;
    private Player.Commands intersectedPlayerCommands;
    private long lastSetPlayWhenReadyCalledTimeMs;
    private final ListenerSet<Player.Listener> listeners;

    @Nullable
    private PlayerInfo.BundlingExclusions pendingBundlingExclusions;
    private final ArraySet<Integer> pendingMaskingSequencedFutureNumbers;

    @Nullable
    private PlayerInfo pendingPlayerInfo;
    private Player.Commands playerCommandsFromPlayer;
    private Player.Commands playerCommandsFromSession;
    private boolean released;
    protected final SequencedFutureManager sequencedFutureManager;

    @Nullable
    private SessionServiceConnection serviceConnection;

    @Nullable
    private PendingIntent sessionActivity;
    private final SurfaceCallback surfaceCallback;
    private final SessionToken token;

    @Nullable
    private Surface videoSurface;

    @Nullable
    private SurfaceHolder videoSurfaceHolder;

    @Nullable
    private TextureView videoTextureView;
    private PlayerInfo playerInfo = PlayerInfo.DEFAULT;
    private Size surfaceSize = Size.UNKNOWN;
    private SessionCommands sessionCommands = SessionCommands.EMPTY;

    public class FlushCommandQueueHandler {
        private static final int MSG_FLUSH_COMMAND_QUEUE = 1;
        private final Handler handler;

        public FlushCommandQueueHandler(Looper looper) {
            this.handler = new Handler(looper, new Handler.Callback() { // from class: androidx.media3.session.e4
                public /* synthetic */ e4() {
                }

                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    boolean handleMessage;
                    handleMessage = MediaControllerImplBase.FlushCommandQueueHandler.this.handleMessage(message);
                    return handleMessage;
                }
            });
        }

        private void flushCommandQueue() {
            try {
                MediaControllerImplBase.this.iSession.flushCommandQueue(MediaControllerImplBase.this.controllerStub);
            } catch (RemoteException unused) {
                Log.w(MediaControllerImplBase.TAG, "Error in sending flushCommandQueue");
            }
        }

        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                flushCommandQueue();
            }
            return true;
        }

        public void release() {
            if (this.handler.hasMessages(1)) {
                flushCommandQueue();
            }
            this.handler.removeCallbacksAndMessages(null);
        }

        public void sendFlushCommandQueueMessage() {
            if (MediaControllerImplBase.this.iSession == null || this.handler.hasMessages(1)) {
                return;
            }
            this.handler.sendEmptyMessage(1);
        }
    }

    public static final class PeriodInfo {
        private final int index;
        private final long periodPositionUs;

        public PeriodInfo(int i10, long j10) {
            this.index = i10;
            this.periodPositionUs = j10;
        }
    }

    public interface RemoteSessionTask {
        void run(IMediaSession iMediaSession, int i10) throws RemoteException;
    }

    public class SessionServiceConnection implements ServiceConnection {
        private final Bundle connectionHints;

        public SessionServiceConnection(Bundle bundle) {
            this.connectionHints = bundle;
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            MediaController mediaControllerImplBase = MediaControllerImplBase.this.getInstance();
            MediaController mediaControllerImplBase2 = MediaControllerImplBase.this.getInstance();
            Objects.requireNonNull(mediaControllerImplBase2);
            mediaControllerImplBase.runOnApplicationLooper(new p0.q(mediaControllerImplBase2));
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                if (MediaControllerImplBase.this.token.getPackageName().equals(componentName.getPackageName())) {
                    IMediaSessionService asInterface = IMediaSessionService.Stub.asInterface(iBinder);
                    if (asInterface == null) {
                        Log.e(MediaControllerImplBase.TAG, "Service interface is missing.");
                        return;
                    } else {
                        asInterface.connect(MediaControllerImplBase.this.controllerStub, new ConnectionRequest(MediaControllerImplBase.this.getContext().getPackageName(), Process.myPid(), this.connectionHints).toBundle());
                        return;
                    }
                }
                Log.e(MediaControllerImplBase.TAG, "Expected connection to " + MediaControllerImplBase.this.token.getPackageName() + " but is connected to " + componentName);
            } catch (RemoteException unused) {
                Log.w(MediaControllerImplBase.TAG, "Service " + componentName + " has died prematurely");
            } finally {
                MediaController mediaControllerImplBase = MediaControllerImplBase.this.getInstance();
                MediaController mediaControllerImplBase2 = MediaControllerImplBase.this.getInstance();
                Objects.requireNonNull(mediaControllerImplBase2);
                mediaControllerImplBase.runOnApplicationLooper(new p0.q(mediaControllerImplBase2));
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            MediaController mediaControllerImplBase = MediaControllerImplBase.this.getInstance();
            MediaController mediaControllerImplBase2 = MediaControllerImplBase.this.getInstance();
            Objects.requireNonNull(mediaControllerImplBase2);
            mediaControllerImplBase.runOnApplicationLooper(new p0.q(mediaControllerImplBase2));
        }
    }

    public class SurfaceCallback implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
        private SurfaceCallback() {
        }

        public /* synthetic */ void lambda$onSurfaceTextureAvailable$2(IMediaSession iMediaSession, int i10) throws RemoteException {
            MediaControllerImplBase mediaControllerImplBase = MediaControllerImplBase.this;
            iMediaSession.setVideoSurface(mediaControllerImplBase.controllerStub, i10, mediaControllerImplBase.videoSurface);
        }

        public /* synthetic */ void lambda$onSurfaceTextureDestroyed$3(IMediaSession iMediaSession, int i10) throws RemoteException {
            iMediaSession.setVideoSurface(MediaControllerImplBase.this.controllerStub, i10, null);
        }

        public /* synthetic */ void lambda$surfaceCreated$0(IMediaSession iMediaSession, int i10) throws RemoteException {
            MediaControllerImplBase mediaControllerImplBase = MediaControllerImplBase.this;
            iMediaSession.setVideoSurface(mediaControllerImplBase.controllerStub, i10, mediaControllerImplBase.videoSurface);
        }

        public /* synthetic */ void lambda$surfaceDestroyed$1(IMediaSession iMediaSession, int i10) throws RemoteException {
            iMediaSession.setVideoSurface(MediaControllerImplBase.this.controllerStub, i10, null);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
            if (MediaControllerImplBase.this.videoTextureView == null || MediaControllerImplBase.this.videoTextureView.getSurfaceTexture() != surfaceTexture) {
                return;
            }
            MediaControllerImplBase.this.videoSurface = new Surface(surfaceTexture);
            MediaControllerImplBase.this.dispatchRemoteSessionTaskWithPlayerCommandAndWaitForFuture(new RemoteSessionTask() { // from class: androidx.media3.session.h4
                public /* synthetic */ h4() {
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i12) {
                    MediaControllerImplBase.SurfaceCallback.this.lambda$onSurfaceTextureAvailable$2(iMediaSession, i12);
                }
            });
            MediaControllerImplBase.this.maybeNotifySurfaceSizeChanged(i10, i11);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (MediaControllerImplBase.this.videoTextureView != null && MediaControllerImplBase.this.videoTextureView.getSurfaceTexture() == surfaceTexture) {
                MediaControllerImplBase.this.videoSurface = null;
                MediaControllerImplBase.this.dispatchRemoteSessionTaskWithPlayerCommandAndWaitForFuture(new RemoteSessionTask() { // from class: androidx.media3.session.i4
                    public /* synthetic */ i4() {
                    }

                    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                    public final void run(IMediaSession iMediaSession, int i10) {
                        MediaControllerImplBase.SurfaceCallback.this.lambda$onSurfaceTextureDestroyed$3(iMediaSession, i10);
                    }
                });
                MediaControllerImplBase.this.maybeNotifySurfaceSizeChanged(0, 0);
            }
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
            if (MediaControllerImplBase.this.videoTextureView == null || MediaControllerImplBase.this.videoTextureView.getSurfaceTexture() != surfaceTexture) {
                return;
            }
            MediaControllerImplBase.this.maybeNotifySurfaceSizeChanged(i10, i11);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
            if (MediaControllerImplBase.this.videoSurfaceHolder != surfaceHolder) {
                return;
            }
            MediaControllerImplBase.this.maybeNotifySurfaceSizeChanged(i11, i12);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (MediaControllerImplBase.this.videoSurfaceHolder != surfaceHolder) {
                return;
            }
            MediaControllerImplBase.this.videoSurface = surfaceHolder.getSurface();
            MediaControllerImplBase.this.dispatchRemoteSessionTaskWithPlayerCommandAndWaitForFuture(new RemoteSessionTask() { // from class: androidx.media3.session.f4
                public /* synthetic */ f4() {
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.SurfaceCallback.this.lambda$surfaceCreated$0(iMediaSession, i10);
                }
            });
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            MediaControllerImplBase.this.maybeNotifySurfaceSizeChanged(surfaceFrame.width(), surfaceFrame.height());
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (MediaControllerImplBase.this.videoSurfaceHolder != surfaceHolder) {
                return;
            }
            MediaControllerImplBase.this.videoSurface = null;
            MediaControllerImplBase.this.dispatchRemoteSessionTaskWithPlayerCommandAndWaitForFuture(new RemoteSessionTask() { // from class: androidx.media3.session.g4
                public /* synthetic */ g4() {
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.SurfaceCallback.this.lambda$surfaceDestroyed$1(iMediaSession, i10);
                }
            });
            MediaControllerImplBase.this.maybeNotifySurfaceSizeChanged(0, 0);
        }

        public /* synthetic */ SurfaceCallback(MediaControllerImplBase mediaControllerImplBase, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public MediaControllerImplBase(Context context, MediaController mediaController, SessionToken sessionToken, Bundle bundle, Looper looper) {
        Player.Commands commands = Player.Commands.EMPTY;
        this.playerCommandsFromSession = commands;
        this.playerCommandsFromPlayer = commands;
        this.intersectedPlayerCommands = createIntersectedCommands(commands, commands);
        this.listeners = new ListenerSet<>(looper, Clock.DEFAULT, new ListenerSet.IterationFinishedEvent() { // from class: androidx.media3.session.a3
            public /* synthetic */ a3() {
            }

            @Override // androidx.media3.common.util.ListenerSet.IterationFinishedEvent
            public final void invoke(Object obj, FlagSet flagSet) {
                MediaControllerImplBase.this.lambda$new$0((Player.Listener) obj, flagSet);
            }
        });
        this.instance = mediaController;
        Assertions.checkNotNull(context, "context must not be null");
        Assertions.checkNotNull(sessionToken, "token must not be null");
        this.context = context;
        this.sequencedFutureManager = new SequencedFutureManager();
        this.controllerStub = new MediaControllerStub(this);
        this.pendingMaskingSequencedFutureNumbers = new ArraySet<>();
        this.token = sessionToken;
        this.connectionHints = bundle;
        this.deathRecipient = new IBinder.DeathRecipient() { // from class: androidx.media3.session.b3
            public /* synthetic */ b3() {
            }

            @Override // android.os.IBinder.DeathRecipient
            public final void binderDied() {
                MediaControllerImplBase.this.lambda$new$1();
            }
        };
        this.surfaceCallback = new SurfaceCallback();
        this.serviceConnection = sessionToken.getType() != 0 ? new SessionServiceConnection(bundle) : null;
        this.flushCommandQueueHandler = new FlushCommandQueueHandler(looper);
        this.currentPositionMs = C.TIME_UNSET;
        this.lastSetPlayWhenReadyCalledTimeMs = C.TIME_UNSET;
    }

    private void addMediaItemsInternal(int i10, List<MediaItem> list) {
        if (list.isEmpty()) {
            return;
        }
        if (this.playerInfo.timeline.isEmpty()) {
            setMediaItemsInternal(list, -1, C.TIME_UNSET, false);
        } else {
            updatePlayerInfo(maskPlaybackInfoForAddedItems(this.playerInfo, Math.min(i10, this.playerInfo.timeline.getWindowCount()), list), 0, 1, false, 5, this.playerInfo.timeline.isEmpty(), 3);
        }
    }

    private void clearSurfacesAndCallbacks() {
        TextureView textureView = this.videoTextureView;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(null);
            this.videoTextureView = null;
        }
        SurfaceHolder surfaceHolder = this.videoSurfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.surfaceCallback);
            this.videoSurfaceHolder = null;
        }
        if (this.videoSurface != null) {
            this.videoSurface = null;
        }
    }

    private static int convertRepeatModeForNavigation(int i10) {
        if (i10 == 1) {
            return 0;
        }
        return i10;
    }

    private static Player.Commands createIntersectedCommands(Player.Commands commands, Player.Commands commands2) {
        Player.Commands.Builder builder = new Player.Commands.Builder();
        builder.add(32);
        for (int i10 = 0; i10 < commands.size(); i10++) {
            if (commands2.contains(commands.get(i10))) {
                builder.add(commands.get(i10));
            }
        }
        return builder.build();
    }

    private static Timeline createMaskingTimeline(List<Timeline.Window> list, List<Timeline.Period> list2) {
        return new Timeline.RemotableTimeline(new ImmutableList.a().c(list).e(), new ImmutableList.a().c(list2).e(), MediaUtils.generateUnshuffledIndices(list.size()));
    }

    private static Timeline.Period createNewPeriod(int i10) {
        return new Timeline.Period().set(null, null, i10, C.TIME_UNSET, 0L, AdPlaybackState.NONE, true);
    }

    private static Timeline.Window createNewWindow(MediaItem mediaItem) {
        return new Timeline.Window().set(0, mediaItem, null, 0L, 0L, 0L, true, false, null, 0L, C.TIME_UNSET, -1, -1, 0L);
    }

    private p5.c0<SessionResult> dispatchRemoteSessionTask(@Nullable IMediaSession iMediaSession, RemoteSessionTask remoteSessionTask, boolean z10) {
        if (iMediaSession == null) {
            return com.google.common.util.concurrent.l.m(new SessionResult(-4));
        }
        SequencedFutureManager.SequencedFuture createSequencedFuture = this.sequencedFutureManager.createSequencedFuture(new SessionResult(1));
        int sequenceNumber = createSequencedFuture.getSequenceNumber();
        if (z10) {
            this.pendingMaskingSequencedFutureNumbers.add(Integer.valueOf(sequenceNumber));
        }
        try {
            remoteSessionTask.run(iMediaSession, sequenceNumber);
        } catch (RemoteException e10) {
            Log.w(TAG, "Cannot connect to the service or the session is gone", e10);
            this.pendingMaskingSequencedFutureNumbers.remove(Integer.valueOf(sequenceNumber));
            this.sequencedFutureManager.setFutureResult(sequenceNumber, new SessionResult(-100));
        }
        return createSequencedFuture;
    }

    private void dispatchRemoteSessionTaskWithPlayerCommand(RemoteSessionTask remoteSessionTask) {
        this.flushCommandQueueHandler.sendFlushCommandQueueMessage();
        dispatchRemoteSessionTask(this.iSession, remoteSessionTask, true);
    }

    public void dispatchRemoteSessionTaskWithPlayerCommandAndWaitForFuture(RemoteSessionTask remoteSessionTask) {
        p5.c0<SessionResult> dispatchRemoteSessionTask = dispatchRemoteSessionTask(this.iSession, remoteSessionTask, true);
        try {
            MediaUtils.getFutureResult(dispatchRemoteSessionTask, 3000L);
        } catch (ExecutionException e10) {
            throw new IllegalStateException(e10);
        } catch (TimeoutException e11) {
            if (dispatchRemoteSessionTask instanceof SequencedFutureManager.SequencedFuture) {
                int sequenceNumber = ((SequencedFutureManager.SequencedFuture) dispatchRemoteSessionTask).getSequenceNumber();
                this.pendingMaskingSequencedFutureNumbers.remove(Integer.valueOf(sequenceNumber));
                this.sequencedFutureManager.setFutureResult(sequenceNumber, new SessionResult(-1));
            }
            Log.w(TAG, "Synchronous command takes too long on the session side.", e11);
        }
    }

    private p5.c0<SessionResult> dispatchRemoteSessionTaskWithSessionCommand(int i10, RemoteSessionTask remoteSessionTask) {
        return dispatchRemoteSessionTaskWithSessionCommandInternal(i10, null, remoteSessionTask);
    }

    private p5.c0<SessionResult> dispatchRemoteSessionTaskWithSessionCommandInternal(int i10, @Nullable SessionCommand sessionCommand, RemoteSessionTask remoteSessionTask) {
        return dispatchRemoteSessionTask(sessionCommand != null ? getSessionInterfaceWithSessionCommandIfAble(sessionCommand) : getSessionInterfaceWithSessionCommandIfAble(i10), remoteSessionTask, false);
    }

    private static int getCurrentMediaItemIndexInternal(PlayerInfo playerInfo) {
        int i10 = playerInfo.sessionPositionInfo.positionInfo.mediaItemIndex;
        if (i10 == -1) {
            return 0;
        }
        return i10;
    }

    private static int getNewPeriodIndexWithoutRemovedPeriods(Timeline timeline, int i10, int i11, int i12) {
        if (i10 == -1) {
            return i10;
        }
        while (i11 < i12) {
            Timeline.Window window = new Timeline.Window();
            timeline.getWindow(i11, window);
            i10 -= (window.lastPeriodIndex - window.firstPeriodIndex) + 1;
            i11++;
        }
        return i10;
    }

    @Nullable
    private PeriodInfo getPeriodInfo(Timeline timeline, int i10, long j10) {
        if (timeline.isEmpty()) {
            return null;
        }
        Timeline.Window window = new Timeline.Window();
        Timeline.Period period = new Timeline.Period();
        if (i10 == -1 || i10 >= timeline.getWindowCount()) {
            i10 = timeline.getFirstWindowIndex(getShuffleModeEnabled());
            j10 = timeline.getWindow(i10, window).getDefaultPositionMs();
        }
        return getPeriodInfo(timeline, window, period, i10, Util.msToUs(j10));
    }

    private static Timeline.Period getPeriodWithNewWindowIndex(Timeline timeline, int i10, int i11) {
        Timeline.Period period = new Timeline.Period();
        timeline.getPeriod(i10, period);
        period.windowIndex = i11;
        return period;
    }

    private boolean isPlayerCommandAvailable(int i10) {
        if (this.intersectedPlayerCommands.contains(i10)) {
            return true;
        }
        Log.w(TAG, "Controller isn't allowed to call command= " + i10);
        return false;
    }

    public /* synthetic */ void lambda$addMediaItem$30(MediaItem mediaItem, IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.addMediaItem(this.controllerStub, i10, mediaItem.toBundleIncludeLocalConfiguration());
    }

    public /* synthetic */ void lambda$addMediaItem$31(int i10, MediaItem mediaItem, IMediaSession iMediaSession, int i11) throws RemoteException {
        iMediaSession.addMediaItemWithIndex(this.controllerStub, i11, i10, mediaItem.toBundleIncludeLocalConfiguration());
    }

    public /* synthetic */ void lambda$addMediaItems$32(List list, IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.addMediaItems(this.controllerStub, i10, new BundleListRetriever(BundleableUtil.toBundleList(list, new r())));
    }

    public /* synthetic */ void lambda$addMediaItems$33(int i10, List list, IMediaSession iMediaSession, int i11) throws RemoteException {
        iMediaSession.addMediaItemsWithIndex(this.controllerStub, i11, i10, new BundleListRetriever(BundleableUtil.toBundleList(list, new r())));
    }

    public /* synthetic */ void lambda$clearMediaItems$36(IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.clearMediaItems(this.controllerStub, i10);
    }

    public /* synthetic */ void lambda$clearVideoSurface$67(IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.setVideoSurface(this.controllerStub, i10, null);
    }

    public /* synthetic */ void lambda$decreaseDeviceVolume$59(IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.decreaseDeviceVolume(this.controllerStub, i10);
    }

    public /* synthetic */ void lambda$decreaseDeviceVolume$60(int i10, Player.Listener listener) {
        listener.onDeviceVolumeChanged(i10, this.playerInfo.deviceMuted);
    }

    public /* synthetic */ void lambda$decreaseDeviceVolume$61(int i10, IMediaSession iMediaSession, int i11) throws RemoteException {
        iMediaSession.decreaseDeviceVolumeWithFlags(this.controllerStub, i11, i10);
    }

    public /* synthetic */ void lambda$decreaseDeviceVolume$62(int i10, Player.Listener listener) {
        listener.onDeviceVolumeChanged(i10, this.playerInfo.deviceMuted);
    }

    public /* synthetic */ void lambda$increaseDeviceVolume$55(IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.increaseDeviceVolume(this.controllerStub, i10);
    }

    public /* synthetic */ void lambda$increaseDeviceVolume$56(int i10, Player.Listener listener) {
        listener.onDeviceVolumeChanged(i10, this.playerInfo.deviceMuted);
    }

    public /* synthetic */ void lambda$increaseDeviceVolume$57(int i10, IMediaSession iMediaSession, int i11) throws RemoteException {
        iMediaSession.increaseDeviceVolumeWithFlags(this.controllerStub, i11, i10);
    }

    public /* synthetic */ void lambda$increaseDeviceVolume$58(int i10, Player.Listener listener) {
        listener.onDeviceVolumeChanged(i10, this.playerInfo.deviceMuted);
    }

    public /* synthetic */ void lambda$moveMediaItem$37(int i10, int i11, IMediaSession iMediaSession, int i12) throws RemoteException {
        iMediaSession.moveMediaItem(this.controllerStub, i12, i10, i11);
    }

    public /* synthetic */ void lambda$moveMediaItems$38(int i10, int i11, int i12, IMediaSession iMediaSession, int i13) throws RemoteException {
        iMediaSession.moveMediaItems(this.controllerStub, i13, i10, i11, i12);
    }

    public /* synthetic */ void lambda$new$0(Player.Listener listener, FlagSet flagSet) {
        listener.onEvents(getInstance(), new Player.Events(flagSet));
    }

    public /* synthetic */ void lambda$new$1() {
        MediaController mediaControllerImplBase = getInstance();
        MediaController mediaControllerImplBase2 = getInstance();
        Objects.requireNonNull(mediaControllerImplBase2);
        mediaControllerImplBase.runOnApplicationLooper(new p0.q(mediaControllerImplBase2));
    }

    public /* synthetic */ void lambda$onAvailableCommandsChangedFromPlayer$115(Player.Listener listener) {
        listener.onAvailableCommandsChanged(this.intersectedPlayerCommands);
    }

    public /* synthetic */ void lambda$onAvailableCommandsChangedFromSession$113(Player.Listener listener) {
        listener.onAvailableCommandsChanged(this.intersectedPlayerCommands);
    }

    public /* synthetic */ void lambda$onAvailableCommandsChangedFromSession$114(SessionCommands sessionCommands, MediaController.Listener listener) {
        listener.onAvailableSessionCommandsChanged(getInstance(), sessionCommands);
    }

    public /* synthetic */ void lambda$onCustomCommand$85(SessionCommand sessionCommand, Bundle bundle, int i10, MediaController.Listener listener) {
        sendControllerResultWhenReady(i10, (p5.c0) Assertions.checkNotNull(listener.onCustomCommand(getInstance(), sessionCommand, bundle), "ControllerCallback#onCustomCommand() must not return null"));
    }

    public /* synthetic */ void lambda$onExtrasChanged$117(Bundle bundle, MediaController.Listener listener) {
        listener.onExtrasChanged(getInstance(), bundle);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$100(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onDeviceVolumeChanged(playerInfo.deviceVolume, playerInfo.deviceMuted);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$101(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onPlayWhenReadyChanged(playerInfo.playWhenReady, playerInfo.playWhenReadyChangedReason);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$102(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onPlaybackSuppressionReasonChanged(playerInfo.playbackSuppressionReason);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$103(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onPlaybackStateChanged(playerInfo.playbackState);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$104(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onIsPlayingChanged(playerInfo.isPlaying);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$105(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onIsLoadingChanged(playerInfo.isLoading);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$106(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onVideoSizeChanged(playerInfo.videoSize);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$107(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onPositionDiscontinuity(playerInfo.oldPositionInfo, playerInfo.newPositionInfo, playerInfo.discontinuityReason);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$108(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onMediaMetadataChanged(playerInfo.mediaMetadata);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$109(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onSeekBackIncrementChanged(playerInfo.seekBackIncrementMs);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$110(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onSeekForwardIncrementChanged(playerInfo.seekForwardIncrementMs);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$111(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onMaxSeekToPreviousPositionChanged(playerInfo.maxSeekToPreviousPositionMs);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$112(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onTrackSelectionParametersChanged(playerInfo.trackSelectionParameters);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$86(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onPlayerErrorChanged(playerInfo.playerError);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$87(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onPlayerError(playerInfo.playerError);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$88(MediaItem mediaItem, PlayerInfo playerInfo, Player.Listener listener) {
        listener.onMediaItemTransition(mediaItem, playerInfo.mediaItemTransitionReason);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$89(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onTracksChanged(playerInfo.currentTracks);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$90(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onPlaybackParametersChanged(playerInfo.playbackParameters);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$91(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onRepeatModeChanged(playerInfo.repeatMode);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$92(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onShuffleModeEnabledChanged(playerInfo.shuffleModeEnabled);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$93(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onTimelineChanged(playerInfo.timeline, 1);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$94(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onPlaylistMetadataChanged(playerInfo.playlistMetadata);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$95(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onVolumeChanged(playerInfo.volume);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$96(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onAudioAttributesChanged(playerInfo.audioAttributes);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$97(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onCues(playerInfo.cueGroup.cues);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$98(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onCues(playerInfo.cueGroup);
    }

    public static /* synthetic */ void lambda$onPlayerInfoChanged$99(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onDeviceInfoChanged(playerInfo.deviceInfo);
    }

    public /* synthetic */ void lambda$onSetCustomLayout$116(List list, int i10, MediaController.Listener listener) {
        sendControllerResultWhenReady(i10, (p5.c0) Assertions.checkNotNull(listener.onSetCustomLayout(getInstance(), list), "MediaController.Listener#onSetCustomLayout() must not return null"));
    }

    public /* synthetic */ void lambda$onSetSessionActivity$118(PendingIntent pendingIntent, MediaController.Listener listener) {
        listener.onSessionActivityChanged(getInstance(), pendingIntent);
    }

    public /* synthetic */ void lambda$pause$6(IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.pause(this.controllerStub, i10);
    }

    public /* synthetic */ void lambda$play$5(IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.play(this.controllerStub, i10);
    }

    public /* synthetic */ void lambda$prepare$7(IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.prepare(this.controllerStub, i10);
    }

    public /* synthetic */ void lambda$release$4() {
        SessionServiceConnection sessionServiceConnection = this.serviceConnection;
        if (sessionServiceConnection != null) {
            this.context.unbindService(sessionServiceConnection);
            this.serviceConnection = null;
        }
        this.controllerStub.destroy();
    }

    public /* synthetic */ void lambda$removeMediaItem$34(int i10, IMediaSession iMediaSession, int i11) throws RemoteException {
        iMediaSession.removeMediaItem(this.controllerStub, i11, i10);
    }

    public /* synthetic */ void lambda$removeMediaItems$35(int i10, int i11, IMediaSession iMediaSession, int i12) throws RemoteException {
        iMediaSession.removeMediaItems(this.controllerStub, i12, i10, i11);
    }

    public /* synthetic */ void lambda$replaceMediaItem$39(int i10, MediaItem mediaItem, IMediaSession iMediaSession, int i11) throws RemoteException {
        if (((SessionToken) Assertions.checkNotNull(this.connectedToken)).getInterfaceVersion() >= 2) {
            iMediaSession.replaceMediaItem(this.controllerStub, i11, i10, mediaItem.toBundleIncludeLocalConfiguration());
        } else {
            iMediaSession.addMediaItemWithIndex(this.controllerStub, i11, i10 + 1, mediaItem.toBundleIncludeLocalConfiguration());
            iMediaSession.removeMediaItem(this.controllerStub, i11, i10);
        }
    }

    public /* synthetic */ void lambda$replaceMediaItems$40(List list, int i10, int i11, IMediaSession iMediaSession, int i12) throws RemoteException {
        BundleListRetriever bundleListRetriever = new BundleListRetriever(BundleableUtil.toBundleList(list, new r()));
        if (((SessionToken) Assertions.checkNotNull(this.connectedToken)).getInterfaceVersion() >= 2) {
            iMediaSession.replaceMediaItems(this.controllerStub, i12, i10, i11, bundleListRetriever);
        } else {
            iMediaSession.addMediaItemsWithIndex(this.controllerStub, i12, i11, bundleListRetriever);
            iMediaSession.removeMediaItems(this.controllerStub, i12, i10, i11);
        }
    }

    public /* synthetic */ void lambda$seekBack$12(IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.seekBack(this.controllerStub, i10);
    }

    public /* synthetic */ void lambda$seekForward$13(IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.seekForward(this.controllerStub, i10);
    }

    public /* synthetic */ void lambda$seekTo$10(long j10, IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.seekTo(this.controllerStub, i10, j10);
    }

    public /* synthetic */ void lambda$seekTo$11(int i10, long j10, IMediaSession iMediaSession, int i11) throws RemoteException {
        iMediaSession.seekToWithMediaItemIndex(this.controllerStub, i11, i10, j10);
    }

    public /* synthetic */ void lambda$seekToDefaultPosition$8(IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.seekToDefaultPosition(this.controllerStub, i10);
    }

    public /* synthetic */ void lambda$seekToDefaultPosition$9(int i10, IMediaSession iMediaSession, int i11) throws RemoteException {
        iMediaSession.seekToDefaultPositionWithMediaItemIndex(this.controllerStub, i11, i10);
    }

    public /* synthetic */ void lambda$seekToNext$44(IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.seekToNext(this.controllerStub, i10);
    }

    public /* synthetic */ void lambda$seekToNextMediaItem$42(IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.seekToNextMediaItem(this.controllerStub, i10);
    }

    public /* synthetic */ void lambda$seekToPrevious$43(IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.seekToPrevious(this.controllerStub, i10);
    }

    public /* synthetic */ void lambda$seekToPreviousMediaItem$41(IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.seekToPreviousMediaItem(this.controllerStub, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$sendControllerResultWhenReady$84(p5.c0 c0Var, int i10) {
        SessionResult sessionResult;
        try {
            sessionResult = (SessionResult) Assertions.checkNotNull((SessionResult) c0Var.get(), "SessionResult must not be null");
        } catch (InterruptedException e10) {
            e = e10;
            Log.w(TAG, "Session operation failed", e);
            sessionResult = new SessionResult(-1);
        } catch (CancellationException e11) {
            Log.w(TAG, "Session operation cancelled", e11);
            sessionResult = new SessionResult(1);
        } catch (ExecutionException e12) {
            e = e12;
            Log.w(TAG, "Session operation failed", e);
            sessionResult = new SessionResult(-1);
        }
        sendControllerResult(i10, sessionResult);
    }

    public /* synthetic */ void lambda$sendCustomCommand$21(SessionCommand sessionCommand, Bundle bundle, IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.onCustomCommand(this.controllerStub, i10, sessionCommand.toBundle(), bundle);
    }

    public /* synthetic */ void lambda$setDeviceMuted$63(boolean z10, IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.setDeviceMuted(this.controllerStub, i10, z10);
    }

    public /* synthetic */ void lambda$setDeviceMuted$64(boolean z10, Player.Listener listener) {
        listener.onDeviceVolumeChanged(this.playerInfo.deviceVolume, z10);
    }

    public /* synthetic */ void lambda$setDeviceMuted$65(boolean z10, int i10, IMediaSession iMediaSession, int i11) throws RemoteException {
        iMediaSession.setDeviceMutedWithFlags(this.controllerStub, i11, z10, i10);
    }

    public /* synthetic */ void lambda$setDeviceMuted$66(boolean z10, Player.Listener listener) {
        listener.onDeviceVolumeChanged(this.playerInfo.deviceVolume, z10);
    }

    public /* synthetic */ void lambda$setDeviceVolume$51(int i10, IMediaSession iMediaSession, int i11) throws RemoteException {
        iMediaSession.setDeviceVolume(this.controllerStub, i11, i10);
    }

    public /* synthetic */ void lambda$setDeviceVolume$52(int i10, Player.Listener listener) {
        listener.onDeviceVolumeChanged(i10, this.playerInfo.deviceMuted);
    }

    public /* synthetic */ void lambda$setDeviceVolume$53(int i10, int i11, IMediaSession iMediaSession, int i12) throws RemoteException {
        iMediaSession.setDeviceVolumeWithFlags(this.controllerStub, i12, i10, i11);
    }

    public /* synthetic */ void lambda$setDeviceVolume$54(int i10, Player.Listener listener) {
        listener.onDeviceVolumeChanged(i10, this.playerInfo.deviceMuted);
    }

    public /* synthetic */ void lambda$setFutureResult$83(int i10) {
        this.pendingMaskingSequencedFutureNumbers.remove(Integer.valueOf(i10));
    }

    public /* synthetic */ void lambda$setMediaItem$22(MediaItem mediaItem, IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.setMediaItem(this.controllerStub, i10, mediaItem.toBundleIncludeLocalConfiguration());
    }

    public /* synthetic */ void lambda$setMediaItem$23(MediaItem mediaItem, long j10, IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.setMediaItemWithStartPosition(this.controllerStub, i10, mediaItem.toBundleIncludeLocalConfiguration(), j10);
    }

    public /* synthetic */ void lambda$setMediaItem$24(MediaItem mediaItem, boolean z10, IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.setMediaItemWithResetPosition(this.controllerStub, i10, mediaItem.toBundleIncludeLocalConfiguration(), z10);
    }

    public /* synthetic */ void lambda$setMediaItems$25(List list, IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.setMediaItems(this.controllerStub, i10, new BundleListRetriever(BundleableUtil.toBundleList(list, new r())));
    }

    public /* synthetic */ void lambda$setMediaItems$26(List list, boolean z10, IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.setMediaItemsWithResetPosition(this.controllerStub, i10, new BundleListRetriever(BundleableUtil.toBundleList(list, new r())), z10);
    }

    public /* synthetic */ void lambda$setMediaItems$27(List list, int i10, long j10, IMediaSession iMediaSession, int i11) throws RemoteException {
        iMediaSession.setMediaItemsWithStartIndex(this.controllerStub, i11, new BundleListRetriever(BundleableUtil.toBundleList(list, new r())), i10, j10);
    }

    public /* synthetic */ void lambda$setPlayWhenReady$14(boolean z10, IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.setPlayWhenReady(this.controllerStub, i10, z10);
    }

    public /* synthetic */ void lambda$setPlaybackParameters$15(PlaybackParameters playbackParameters, IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.setPlaybackParameters(this.controllerStub, i10, playbackParameters.toBundle());
    }

    public /* synthetic */ void lambda$setPlaybackSpeed$17(float f10, IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.setPlaybackSpeed(this.controllerStub, i10, f10);
    }

    public /* synthetic */ void lambda$setPlaylistMetadata$28(MediaMetadata mediaMetadata, IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.setPlaylistMetadata(this.controllerStub, i10, mediaMetadata.toBundle());
    }

    public /* synthetic */ void lambda$setRating$19(String str, Rating rating, IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.setRatingWithMediaId(this.controllerStub, i10, str, rating.toBundle());
    }

    public /* synthetic */ void lambda$setRating$20(Rating rating, IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.setRating(this.controllerStub, i10, rating.toBundle());
    }

    public /* synthetic */ void lambda$setRepeatMode$45(int i10, IMediaSession iMediaSession, int i11) throws RemoteException {
        iMediaSession.setRepeatMode(this.controllerStub, i11, i10);
    }

    public /* synthetic */ void lambda$setShuffleModeEnabled$47(boolean z10, IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.setShuffleModeEnabled(this.controllerStub, i10, z10);
    }

    public /* synthetic */ void lambda$setTrackSelectionParameters$73(TrackSelectionParameters trackSelectionParameters, IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.setTrackSelectionParameters(this.controllerStub, i10, trackSelectionParameters.toBundle());
    }

    public /* synthetic */ void lambda$setVideoSurface$68(Surface surface, IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.setVideoSurface(this.controllerStub, i10, surface);
    }

    public /* synthetic */ void lambda$setVideoSurfaceHolder$69(Surface surface, IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.setVideoSurface(this.controllerStub, i10, surface);
    }

    public /* synthetic */ void lambda$setVideoSurfaceHolder$70(IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.setVideoSurface(this.controllerStub, i10, null);
    }

    public /* synthetic */ void lambda$setVideoTextureView$71(IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.setVideoSurface(this.controllerStub, i10, null);
    }

    public /* synthetic */ void lambda$setVideoTextureView$72(IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.setVideoSurface(this.controllerStub, i10, this.videoSurface);
    }

    public /* synthetic */ void lambda$setVolume$49(float f10, IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.setVolume(this.controllerStub, i10, f10);
    }

    public /* synthetic */ void lambda$stop$2(IMediaSession iMediaSession, int i10) throws RemoteException {
        iMediaSession.stop(this.controllerStub, i10);
    }

    public static /* synthetic */ void lambda$updatePlayerInfo$75(PlayerInfo playerInfo, int i10, Player.Listener listener) {
        listener.onMediaItemTransition(playerInfo.getCurrentMediaItem(), i10);
    }

    public static /* synthetic */ void lambda$updatePlayerInfo$76(PlayerInfo playerInfo, int i10, Player.Listener listener) {
        listener.onPositionDiscontinuity(playerInfo.oldPositionInfo, playerInfo.newPositionInfo, i10);
    }

    public static /* synthetic */ void lambda$updatePlayerInfo$77(PlayerInfo playerInfo, int i10, Player.Listener listener) {
        listener.onTimelineChanged(playerInfo.timeline, i10);
    }

    public static /* synthetic */ void lambda$updatePlayerInfo$78(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onPlaybackStateChanged(playerInfo.playbackState);
    }

    public static /* synthetic */ void lambda$updatePlayerInfo$79(PlayerInfo playerInfo, int i10, Player.Listener listener) {
        listener.onPlayWhenReadyChanged(playerInfo.playWhenReady, i10);
    }

    public static /* synthetic */ void lambda$updatePlayerInfo$80(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onPlaybackSuppressionReasonChanged(playerInfo.playbackSuppressionReason);
    }

    public static /* synthetic */ void lambda$updatePlayerInfo$81(PlayerInfo playerInfo, Player.Listener listener) {
        listener.onIsPlayingChanged(playerInfo.isPlaying);
    }

    private static PlayerInfo maskPlaybackInfoForAddedItems(PlayerInfo playerInfo, int i10, List<MediaItem> list) {
        int i11;
        Timeline timeline = playerInfo.timeline;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i12 = 0;
        for (int i13 = 0; i13 < timeline.getWindowCount(); i13++) {
            arrayList.add(timeline.getWindow(i13, new Timeline.Window()));
        }
        for (int i14 = 0; i14 < list.size(); i14++) {
            arrayList.add(i14 + i10, createNewWindow(list.get(i14)));
        }
        rebuildPeriods(timeline, arrayList, arrayList2);
        Timeline createMaskingTimeline = createMaskingTimeline(arrayList, arrayList2);
        if (playerInfo.timeline.isEmpty()) {
            i11 = 0;
        } else {
            int i15 = playerInfo.sessionPositionInfo.positionInfo.mediaItemIndex;
            if (i15 >= i10) {
                i15 += list.size();
            }
            i12 = i15;
            i11 = playerInfo.sessionPositionInfo.positionInfo.periodIndex;
            if (i11 >= i10) {
                i11 += list.size();
            }
        }
        return maskTimelineAndPositionInfo(playerInfo, createMaskingTimeline, i12, i11, 5);
    }

    private static PlayerInfo maskPlayerInfoForRemovedItems(PlayerInfo playerInfo, int i10, int i11) {
        int i12;
        PlayerInfo maskTimelineAndPositionInfo;
        Timeline timeline = playerInfo.timeline;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i13 = 0;
        for (int i14 = 0; i14 < timeline.getWindowCount(); i14++) {
            if (i14 < i10 || i14 >= i11) {
                arrayList.add(timeline.getWindow(i14, new Timeline.Window()));
            }
        }
        rebuildPeriods(timeline, arrayList, arrayList2);
        Timeline createMaskingTimeline = createMaskingTimeline(arrayList, arrayList2);
        int currentMediaItemIndexInternal = getCurrentMediaItemIndexInternal(playerInfo);
        int i15 = playerInfo.sessionPositionInfo.positionInfo.periodIndex;
        Timeline.Window window = new Timeline.Window();
        boolean z10 = currentMediaItemIndexInternal >= i10 && currentMediaItemIndexInternal < i11;
        if (createMaskingTimeline.isEmpty()) {
            i12 = -1;
        } else if (z10) {
            i12 = resolveSubsequentMediaItemIndex(playerInfo.repeatMode, playerInfo.shuffleModeEnabled, currentMediaItemIndexInternal, timeline, i10, i11);
            if (i12 == -1) {
                i12 = createMaskingTimeline.getFirstWindowIndex(playerInfo.shuffleModeEnabled);
            } else if (i12 >= i11) {
                i12 -= i11 - i10;
            }
            i13 = createMaskingTimeline.getWindow(i12, window).firstPeriodIndex;
        } else if (currentMediaItemIndexInternal >= i11) {
            i13 = getNewPeriodIndexWithoutRemovedPeriods(timeline, i15, i10, i11);
            i12 = currentMediaItemIndexInternal - (i11 - i10);
        } else {
            i13 = i15;
            i12 = currentMediaItemIndexInternal;
        }
        if (!z10) {
            maskTimelineAndPositionInfo = maskTimelineAndPositionInfo(playerInfo, createMaskingTimeline, i12, i13, 4);
        } else if (i12 == -1) {
            maskTimelineAndPositionInfo = maskTimelineAndPositionInfo(playerInfo, createMaskingTimeline, SessionPositionInfo.DEFAULT_POSITION_INFO, SessionPositionInfo.DEFAULT, 4);
        } else {
            Timeline.Window window2 = createMaskingTimeline.getWindow(i12, new Timeline.Window());
            long defaultPositionMs = window2.getDefaultPositionMs();
            long durationMs = window2.getDurationMs();
            Player.PositionInfo positionInfo = new Player.PositionInfo(null, i12, window2.mediaItem, null, i13, defaultPositionMs, defaultPositionMs, -1, -1);
            maskTimelineAndPositionInfo = maskTimelineAndPositionInfo(playerInfo, createMaskingTimeline, positionInfo, new SessionPositionInfo(positionInfo, false, SystemClock.elapsedRealtime(), durationMs, defaultPositionMs, MediaUtils.calculateBufferedPercentage(defaultPositionMs, durationMs), 0L, C.TIME_UNSET, durationMs, defaultPositionMs), 4);
        }
        int i16 = maskTimelineAndPositionInfo.playbackState;
        return (i16 == 1 || i16 == 4 || i10 >= i11 || i11 != timeline.getWindowCount() || currentMediaItemIndexInternal < i10) ? maskTimelineAndPositionInfo : maskTimelineAndPositionInfo.copyWithPlaybackState(4, null);
    }

    private PlayerInfo maskPositionInfo(PlayerInfo playerInfo, Timeline timeline, PeriodInfo periodInfo) {
        int i10 = playerInfo.sessionPositionInfo.positionInfo.periodIndex;
        int i11 = periodInfo.index;
        Timeline.Period period = new Timeline.Period();
        timeline.getPeriod(i10, period);
        Timeline.Period period2 = new Timeline.Period();
        timeline.getPeriod(i11, period2);
        boolean z10 = i10 != i11;
        long j10 = periodInfo.periodPositionUs;
        long msToUs = Util.msToUs(getCurrentPosition()) - period.getPositionInWindowUs();
        if (!z10 && j10 == msToUs) {
            return playerInfo;
        }
        Assertions.checkState(playerInfo.sessionPositionInfo.positionInfo.adGroupIndex == -1);
        Player.PositionInfo positionInfo = new Player.PositionInfo(null, period.windowIndex, playerInfo.sessionPositionInfo.positionInfo.mediaItem, null, i10, Util.usToMs(period.positionInWindowUs + msToUs), Util.usToMs(period.positionInWindowUs + msToUs), -1, -1);
        timeline.getPeriod(i11, period2);
        Timeline.Window window = new Timeline.Window();
        timeline.getWindow(period2.windowIndex, window);
        Player.PositionInfo positionInfo2 = new Player.PositionInfo(null, period2.windowIndex, window.mediaItem, null, i11, Util.usToMs(period2.positionInWindowUs + j10), Util.usToMs(period2.positionInWindowUs + j10), -1, -1);
        PlayerInfo copyWithPositionInfos = playerInfo.copyWithPositionInfos(positionInfo, positionInfo2, 1);
        if (z10 || j10 < msToUs) {
            return copyWithPositionInfos.copyWithSessionPositionInfo(new SessionPositionInfo(positionInfo2, false, SystemClock.elapsedRealtime(), window.getDurationMs(), Util.usToMs(period2.positionInWindowUs + j10), MediaUtils.calculateBufferedPercentage(Util.usToMs(period2.positionInWindowUs + j10), window.getDurationMs()), 0L, C.TIME_UNSET, C.TIME_UNSET, Util.usToMs(period2.positionInWindowUs + j10)));
        }
        long max = Math.max(0L, Util.msToUs(copyWithPositionInfos.sessionPositionInfo.totalBufferedDurationMs) - (j10 - msToUs));
        long j11 = j10 + max;
        return copyWithPositionInfos.copyWithSessionPositionInfo(new SessionPositionInfo(positionInfo2, false, SystemClock.elapsedRealtime(), window.getDurationMs(), Util.usToMs(j11), MediaUtils.calculateBufferedPercentage(Util.usToMs(j11), window.getDurationMs()), Util.usToMs(max), C.TIME_UNSET, C.TIME_UNSET, Util.usToMs(j11)));
    }

    private static PlayerInfo maskTimelineAndPositionInfo(PlayerInfo playerInfo, Timeline timeline, int i10, int i11, int i12) {
        MediaItem mediaItem = timeline.getWindow(i10, new Timeline.Window()).mediaItem;
        Player.PositionInfo positionInfo = playerInfo.sessionPositionInfo.positionInfo;
        Player.PositionInfo positionInfo2 = new Player.PositionInfo(null, i10, mediaItem, null, i11, positionInfo.positionMs, positionInfo.contentPositionMs, positionInfo.adGroupIndex, positionInfo.adIndexInAdGroup);
        boolean z10 = playerInfo.sessionPositionInfo.isPlayingAd;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        SessionPositionInfo sessionPositionInfo = playerInfo.sessionPositionInfo;
        return maskTimelineAndPositionInfo(playerInfo, timeline, positionInfo2, new SessionPositionInfo(positionInfo2, z10, elapsedRealtime, sessionPositionInfo.durationMs, sessionPositionInfo.bufferedPositionMs, sessionPositionInfo.bufferedPercentage, sessionPositionInfo.totalBufferedDurationMs, sessionPositionInfo.currentLiveOffsetMs, sessionPositionInfo.contentDurationMs, sessionPositionInfo.contentBufferedPositionMs), i12);
    }

    public void maybeNotifySurfaceSizeChanged(int i10, int i11) {
        if (this.surfaceSize.getWidth() == i10 && this.surfaceSize.getHeight() == i11) {
            return;
        }
        this.surfaceSize = new Size(i10, i11);
        this.listeners.sendEvent(24, new ListenerSet.Event() { // from class: androidx.media3.session.t

            /* renamed from: a */
            public final /* synthetic */ int f907a;

            /* renamed from: b */
            public final /* synthetic */ int f908b;

            public /* synthetic */ t(int i102, int i112) {
                i10 = i102;
                i11 = i112;
            }

            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((Player.Listener) obj).onSurfaceSizeChanged(i10, i11);
            }
        });
    }

    private void maybeUpdateCurrentPositionMs() {
        long j10 = this.lastSetPlayWhenReadyCalledTimeMs;
        PlayerInfo playerInfo = this.playerInfo;
        SessionPositionInfo sessionPositionInfo = playerInfo.sessionPositionInfo;
        boolean z10 = j10 < sessionPositionInfo.eventTimeMs;
        if (!playerInfo.isPlaying) {
            if (z10 || this.currentPositionMs == C.TIME_UNSET) {
                this.currentPositionMs = sessionPositionInfo.positionInfo.positionMs;
                return;
            }
            return;
        }
        if (z10 || this.currentPositionMs == C.TIME_UNSET) {
            long timeDiffMs = getInstance().getTimeDiffMs() != C.TIME_UNSET ? getInstance().getTimeDiffMs() : SystemClock.elapsedRealtime() - this.playerInfo.sessionPositionInfo.eventTimeMs;
            PlayerInfo playerInfo2 = this.playerInfo;
            SessionPositionInfo sessionPositionInfo2 = playerInfo2.sessionPositionInfo;
            long j11 = sessionPositionInfo2.positionInfo.positionMs + ((long) (timeDiffMs * playerInfo2.playbackParameters.speed));
            long j12 = sessionPositionInfo2.durationMs;
            if (j12 != C.TIME_UNSET) {
                j11 = Math.min(j11, j12);
            }
            this.currentPositionMs = j11;
        }
    }

    private void moveMediaItemsInternal(int i10, int i11, int i12) {
        Timeline timeline = this.playerInfo.timeline;
        int windowCount = timeline.getWindowCount();
        int min = Math.min(i11, windowCount);
        int i13 = min - i10;
        int min2 = Math.min(i12, windowCount - i13);
        if (i10 >= windowCount || i10 == min || i10 == min2) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i14 = 0; i14 < windowCount; i14++) {
            arrayList.add(timeline.getWindow(i14, new Timeline.Window()));
        }
        Util.moveItems(arrayList, i10, min, min2);
        rebuildPeriods(timeline, arrayList, arrayList2);
        Timeline createMaskingTimeline = createMaskingTimeline(arrayList, arrayList2);
        if (createMaskingTimeline.isEmpty()) {
            return;
        }
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        int i15 = (currentMediaItemIndex < i10 || currentMediaItemIndex >= min) ? (min > currentMediaItemIndex || min2 <= currentMediaItemIndex) ? (min <= currentMediaItemIndex || min2 > currentMediaItemIndex) ? currentMediaItemIndex : currentMediaItemIndex + i13 : currentMediaItemIndex - i13 : (currentMediaItemIndex - i10) + min2;
        Timeline.Window window = new Timeline.Window();
        updatePlayerInfo(maskTimelineAndPositionInfo(this.playerInfo, createMaskingTimeline, i15, createMaskingTimeline.getWindow(i15, window).firstPeriodIndex + (this.playerInfo.sessionPositionInfo.positionInfo.periodIndex - timeline.getWindow(currentMediaItemIndex, window).firstPeriodIndex), 5), 0, 1, false, 5, false, 0);
    }

    private static void rebuildPeriods(Timeline timeline, List<Timeline.Window> list, List<Timeline.Period> list2) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            Timeline.Window window = list.get(i10);
            int i11 = window.firstPeriodIndex;
            int i12 = window.lastPeriodIndex;
            if (i11 == -1 || i12 == -1) {
                window.firstPeriodIndex = list2.size();
                window.lastPeriodIndex = list2.size();
                list2.add(createNewPeriod(i10));
            } else {
                window.firstPeriodIndex = list2.size();
                window.lastPeriodIndex = list2.size() + (i12 - i11);
                while (i11 <= i12) {
                    list2.add(getPeriodWithNewWindowIndex(timeline, i11, i10));
                    i11++;
                }
            }
        }
    }

    private void removeMediaItemsInternal(int i10, int i11) {
        int windowCount = this.playerInfo.timeline.getWindowCount();
        int min = Math.min(i11, windowCount);
        if (i10 >= windowCount || i10 == min || windowCount == 0) {
            return;
        }
        boolean z10 = getCurrentMediaItemIndex() >= i10 && getCurrentMediaItemIndex() < min;
        PlayerInfo maskPlayerInfoForRemovedItems = maskPlayerInfoForRemovedItems(this.playerInfo, i10, min);
        int i12 = this.playerInfo.sessionPositionInfo.positionInfo.mediaItemIndex;
        updatePlayerInfo(maskPlayerInfoForRemovedItems, 0, 1, z10, 4, i12 >= i10 && i12 < min, 3);
    }

    private void replaceMediaItemsInternal(int i10, int i11, List<MediaItem> list) {
        int windowCount = this.playerInfo.timeline.getWindowCount();
        if (i10 > windowCount) {
            return;
        }
        if (this.playerInfo.timeline.isEmpty()) {
            setMediaItemsInternal(list, -1, C.TIME_UNSET, false);
            return;
        }
        int min = Math.min(i11, windowCount);
        PlayerInfo maskPlayerInfoForRemovedItems = maskPlayerInfoForRemovedItems(maskPlaybackInfoForAddedItems(this.playerInfo, min, list), i10, min);
        int i12 = this.playerInfo.sessionPositionInfo.positionInfo.mediaItemIndex;
        boolean z10 = i12 >= i10 && i12 < min;
        updatePlayerInfo(maskPlayerInfoForRemovedItems, 0, 1, z10, 4, z10, 3);
    }

    private boolean requestConnectToService() {
        int i10 = Util.SDK_INT >= 29 ? 4097 : 1;
        Intent intent = new Intent(MediaSessionService.SERVICE_INTERFACE);
        intent.setClassName(this.token.getPackageName(), this.token.getServiceName());
        if (this.context.bindService(intent, this.serviceConnection, i10)) {
            return true;
        }
        Log.w(TAG, "bind to " + this.token + " failed");
        return false;
    }

    private boolean requestConnectToSession(Bundle bundle) {
        try {
            IMediaSession.Stub.asInterface((IBinder) Assertions.checkStateNotNull(this.token.getBinder())).connect(this.controllerStub, this.sequencedFutureManager.obtainNextSequenceNumber(), new ConnectionRequest(this.context.getPackageName(), Process.myPid(), bundle).toBundle());
            return true;
        } catch (RemoteException e10) {
            Log.w(TAG, "Failed to call connection request.", e10);
            return false;
        }
    }

    private static int resolveSubsequentMediaItemIndex(int i10, boolean z10, int i11, Timeline timeline, int i12, int i13) {
        int windowCount = timeline.getWindowCount();
        for (int i14 = 0; i14 < windowCount && (i11 = timeline.getNextWindowIndex(i11, i10, z10)) != -1; i14++) {
            if (i11 < i12 || i11 >= i13) {
                return i11;
            }
        }
        return -1;
    }

    private void seekToInternal(int i10, long j10) {
        PlayerInfo maskPositionInfo;
        long j11;
        Timeline timeline;
        Timeline timeline2 = this.playerInfo.timeline;
        if ((timeline2.isEmpty() || i10 < timeline2.getWindowCount()) && !isPlayingAd()) {
            int i11 = getPlaybackState() == 1 ? 1 : 2;
            PlayerInfo playerInfo = this.playerInfo;
            PlayerInfo copyWithPlaybackState = playerInfo.copyWithPlaybackState(i11, playerInfo.playerError);
            PeriodInfo periodInfo = getPeriodInfo(timeline2, i10, j10);
            if (periodInfo == null) {
                Player.PositionInfo positionInfo = new Player.PositionInfo(null, i10, null, null, i10, j10 == C.TIME_UNSET ? 0L : j10, j10 == C.TIME_UNSET ? 0L : j10, -1, -1);
                PlayerInfo playerInfo2 = this.playerInfo;
                Timeline timeline3 = playerInfo2.timeline;
                boolean z10 = this.playerInfo.sessionPositionInfo.isPlayingAd;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                SessionPositionInfo sessionPositionInfo = this.playerInfo.sessionPositionInfo;
                long j12 = sessionPositionInfo.durationMs;
                if (j10 == C.TIME_UNSET) {
                    timeline = timeline3;
                    j11 = 0;
                } else {
                    j11 = j10;
                    timeline = timeline3;
                }
                maskPositionInfo = maskTimelineAndPositionInfo(playerInfo2, timeline, positionInfo, new SessionPositionInfo(positionInfo, z10, elapsedRealtime, j12, j11, 0, 0L, sessionPositionInfo.currentLiveOffsetMs, sessionPositionInfo.contentDurationMs, j10 == C.TIME_UNSET ? 0L : j10), 1);
            } else {
                maskPositionInfo = maskPositionInfo(copyWithPlaybackState, timeline2, periodInfo);
            }
            PlayerInfo playerInfo3 = maskPositionInfo;
            boolean z11 = (this.playerInfo.timeline.isEmpty() || playerInfo3.sessionPositionInfo.positionInfo.mediaItemIndex == this.playerInfo.sessionPositionInfo.positionInfo.mediaItemIndex) ? false : true;
            boolean z12 = z11 || playerInfo3.sessionPositionInfo.positionInfo.positionMs != this.playerInfo.sessionPositionInfo.positionInfo.positionMs;
            if (z12) {
                updatePlayerInfo(playerInfo3, 0, 1, z12, 1, z11, 2);
            }
        }
    }

    private void seekToInternalByOffset(long j10) {
        long currentPosition = getCurrentPosition() + j10;
        long duration = getDuration();
        if (duration != C.TIME_UNSET) {
            currentPosition = Math.min(currentPosition, duration);
        }
        seekToInternal(getCurrentMediaItemIndex(), Math.max(currentPosition, 0L));
    }

    private void sendControllerResult(int i10, SessionResult sessionResult) {
        IMediaSession iMediaSession = this.iSession;
        if (iMediaSession == null) {
            return;
        }
        try {
            iMediaSession.onControllerResult(this.controllerStub, i10, sessionResult.toBundle());
        } catch (RemoteException unused) {
            Log.w(TAG, "Error in sending");
        }
    }

    private void sendControllerResultWhenReady(int i10, p5.c0<SessionResult> c0Var) {
        c0Var.addListener(new Runnable() { // from class: androidx.media3.session.z2

            /* renamed from: c */
            public final /* synthetic */ p5.c0 f1067c;

            /* renamed from: d */
            public final /* synthetic */ int f1068d;

            public /* synthetic */ z2(p5.c0 c0Var2, int i102) {
                c0Var = c0Var2;
                i10 = i102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaControllerImplBase.this.lambda$sendControllerResultWhenReady$84(c0Var, i10);
            }
        }, com.google.common.util.concurrent.p.c());
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setMediaItemsInternal(java.util.List<androidx.media3.common.MediaItem> r62, int r63, long r64, boolean r66) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.MediaControllerImplBase.setMediaItemsInternal(java.util.List, int, long, boolean):void");
    }

    private void updatePlayerInfo(PlayerInfo playerInfo, int i10, int i11, boolean z10, int i12, boolean z11, int i13) {
        PlayerInfo playerInfo2 = this.playerInfo;
        this.playerInfo = playerInfo;
        if (z11) {
            this.listeners.queueEvent(1, new ListenerSet.Event() { // from class: androidx.media3.session.w3

                /* renamed from: b */
                public final /* synthetic */ int f996b;

                public /* synthetic */ w3(int i132) {
                    i13 = i132;
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplBase.lambda$updatePlayerInfo$75(PlayerInfo.this, i13, (Player.Listener) obj);
                }
            });
        }
        if (z10) {
            this.listeners.queueEvent(11, new ListenerSet.Event() { // from class: androidx.media3.session.x3

                /* renamed from: b */
                public final /* synthetic */ int f1018b;

                public /* synthetic */ x3(int i122) {
                    i12 = i122;
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplBase.lambda$updatePlayerInfo$76(PlayerInfo.this, i12, (Player.Listener) obj);
                }
            });
        }
        if (!playerInfo2.timeline.equals(playerInfo.timeline)) {
            this.listeners.queueEvent(0, new ListenerSet.Event() { // from class: androidx.media3.session.y3

                /* renamed from: b */
                public final /* synthetic */ int f1044b;

                public /* synthetic */ y3(int i102) {
                    i10 = i102;
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplBase.lambda$updatePlayerInfo$77(PlayerInfo.this, i10, (Player.Listener) obj);
                }
            });
        }
        if (playerInfo2.playbackState != playerInfo.playbackState) {
            this.listeners.queueEvent(4, new ListenerSet.Event() { // from class: androidx.media3.session.z3
                public /* synthetic */ z3() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplBase.lambda$updatePlayerInfo$78(PlayerInfo.this, (Player.Listener) obj);
                }
            });
        }
        if (playerInfo2.playWhenReady != playerInfo.playWhenReady) {
            this.listeners.queueEvent(5, new ListenerSet.Event() { // from class: androidx.media3.session.a4

                /* renamed from: b */
                public final /* synthetic */ int f391b;

                public /* synthetic */ a4(int i112) {
                    i11 = i112;
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplBase.lambda$updatePlayerInfo$79(PlayerInfo.this, i11, (Player.Listener) obj);
                }
            });
        }
        if (playerInfo2.playbackSuppressionReason != playerInfo.playbackSuppressionReason) {
            this.listeners.queueEvent(6, new ListenerSet.Event() { // from class: androidx.media3.session.b4
                public /* synthetic */ b4() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplBase.lambda$updatePlayerInfo$80(PlayerInfo.this, (Player.Listener) obj);
                }
            });
        }
        if (playerInfo2.isPlaying != playerInfo.isPlaying) {
            this.listeners.queueEvent(7, new ListenerSet.Event() { // from class: androidx.media3.session.c4
                public /* synthetic */ c4() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplBase.lambda$updatePlayerInfo$81(PlayerInfo.this, (Player.Listener) obj);
                }
            });
        }
        this.listeners.flushEvents();
    }

    private void updateSessionPositionInfoIfNeeded(SessionPositionInfo sessionPositionInfo) {
        if (this.pendingMaskingSequencedFutureNumbers.isEmpty()) {
            SessionPositionInfo sessionPositionInfo2 = this.playerInfo.sessionPositionInfo;
            if (sessionPositionInfo2.eventTimeMs >= sessionPositionInfo.eventTimeMs || !MediaUtils.areSessionPositionInfosInSamePeriodOrAd(sessionPositionInfo, sessionPositionInfo2)) {
                return;
            }
            this.playerInfo = this.playerInfo.copyWithSessionPositionInfo(sessionPositionInfo);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void addListener(Player.Listener listener) {
        this.listeners.add(listener);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void addMediaItem(MediaItem mediaItem) {
        if (isPlayerCommandAvailable(20)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.q1

                /* renamed from: b */
                public final /* synthetic */ MediaItem f845b;

                public /* synthetic */ q1(MediaItem mediaItem2) {
                    mediaItem = mediaItem2;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$addMediaItem$30(mediaItem, iMediaSession, i10);
                }
            });
            addMediaItemsInternal(getCurrentTimeline().getWindowCount(), Collections.singletonList(mediaItem2));
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void addMediaItems(List<MediaItem> list) {
        if (isPlayerCommandAvailable(20)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.m0

                /* renamed from: b */
                public final /* synthetic */ List f732b;

                public /* synthetic */ m0(List list2) {
                    list = list2;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$addMediaItems$32(list, iMediaSession, i10);
                }
            });
            addMediaItemsInternal(getCurrentTimeline().getWindowCount(), list2);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void clearMediaItems() {
        if (isPlayerCommandAvailable(20)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.w2
                public /* synthetic */ w2() {
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$clearMediaItems$36(iMediaSession, i10);
                }
            });
            removeMediaItemsInternal(0, Integer.MAX_VALUE);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void clearVideoSurface() {
        if (isPlayerCommandAvailable(27)) {
            clearSurfacesAndCallbacks();
            dispatchRemoteSessionTaskWithPlayerCommandAndWaitForFuture(new RemoteSessionTask() { // from class: androidx.media3.session.s0
                public /* synthetic */ s0() {
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$clearVideoSurface$67(iMediaSession, i10);
                }
            });
            maybeNotifySurfaceSizeChanged(0, 0);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        if (isPlayerCommandAvailable(27) && surfaceHolder != null && this.videoSurfaceHolder == surfaceHolder) {
            clearVideoSurface();
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void clearVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        if (isPlayerCommandAvailable(27)) {
            clearVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void clearVideoTextureView(@Nullable TextureView textureView) {
        if (isPlayerCommandAvailable(27) && textureView != null && this.videoTextureView == textureView) {
            clearVideoSurface();
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void connect() {
        boolean requestConnectToService;
        if (this.token.getType() == 0) {
            this.serviceConnection = null;
            requestConnectToService = requestConnectToSession(this.connectionHints);
        } else {
            this.serviceConnection = new SessionServiceConnection(this.connectionHints);
            requestConnectToService = requestConnectToService();
        }
        if (requestConnectToService) {
            return;
        }
        MediaController mediaControllerImplBase = getInstance();
        MediaController mediaControllerImplBase2 = getInstance();
        Objects.requireNonNull(mediaControllerImplBase2);
        mediaControllerImplBase.runOnApplicationLooper(new p0.q(mediaControllerImplBase2));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    @Deprecated
    public void decreaseDeviceVolume() {
        if (isPlayerCommandAvailable(26)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.d0
                public /* synthetic */ d0() {
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$decreaseDeviceVolume$59(iMediaSession, i10);
                }
            });
            int i10 = this.playerInfo.deviceVolume - 1;
            if (i10 >= getDeviceInfo().minVolume) {
                PlayerInfo playerInfo = this.playerInfo;
                this.playerInfo = playerInfo.copyWithDeviceVolume(i10, playerInfo.deviceMuted);
                this.listeners.queueEvent(30, new ListenerSet.Event() { // from class: androidx.media3.session.e0

                    /* renamed from: b */
                    public final /* synthetic */ int f495b;

                    public /* synthetic */ e0(int i102) {
                        i10 = i102;
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.this.lambda$decreaseDeviceVolume$60(i10, (Player.Listener) obj);
                    }
                });
                this.listeners.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public AudioAttributes getAudioAttributes() {
        return this.playerInfo.audioAttributes;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public Player.Commands getAvailableCommands() {
        return this.intersectedPlayerCommands;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public SessionCommands getAvailableSessionCommands() {
        return this.sessionCommands;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    @Nullable
    public MediaBrowserCompat getBrowserCompat() {
        return null;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getBufferedPercentage() {
        return this.playerInfo.sessionPositionInfo.bufferedPercentage;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getBufferedPosition() {
        return this.playerInfo.sessionPositionInfo.bufferedPositionMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    @Nullable
    public SessionToken getConnectedToken() {
        return this.connectedToken;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getContentBufferedPosition() {
        return this.playerInfo.sessionPositionInfo.contentBufferedPositionMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getContentDuration() {
        return this.playerInfo.sessionPositionInfo.contentDurationMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getContentPosition() {
        SessionPositionInfo sessionPositionInfo = this.playerInfo.sessionPositionInfo;
        return !sessionPositionInfo.isPlayingAd ? getCurrentPosition() : sessionPositionInfo.positionInfo.contentPositionMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public Context getContext() {
        return this.context;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getCurrentAdGroupIndex() {
        return this.playerInfo.sessionPositionInfo.positionInfo.adGroupIndex;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getCurrentAdIndexInAdGroup() {
        return this.playerInfo.sessionPositionInfo.positionInfo.adIndexInAdGroup;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public CueGroup getCurrentCues() {
        return this.playerInfo.cueGroup;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getCurrentLiveOffset() {
        return this.playerInfo.sessionPositionInfo.currentLiveOffsetMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getCurrentMediaItemIndex() {
        return getCurrentMediaItemIndexInternal(this.playerInfo);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getCurrentPeriodIndex() {
        return this.playerInfo.sessionPositionInfo.positionInfo.periodIndex;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getCurrentPosition() {
        maybeUpdateCurrentPositionMs();
        return this.currentPositionMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public Timeline getCurrentTimeline() {
        return this.playerInfo.timeline;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public Tracks getCurrentTracks() {
        return this.playerInfo.currentTracks;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public DeviceInfo getDeviceInfo() {
        return this.playerInfo.deviceInfo;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getDeviceVolume() {
        return this.playerInfo.deviceVolume;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getDuration() {
        return this.playerInfo.sessionPositionInfo.durationMs;
    }

    public MediaController getInstance() {
        return this.instance;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getMaxSeekToPreviousPosition() {
        return this.playerInfo.maxSeekToPreviousPositionMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public MediaMetadata getMediaMetadata() {
        return this.playerInfo.mediaMetadata;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getNextMediaItemIndex() {
        if (this.playerInfo.timeline.isEmpty()) {
            return -1;
        }
        return this.playerInfo.timeline.getNextWindowIndex(getCurrentMediaItemIndex(), convertRepeatModeForNavigation(this.playerInfo.repeatMode), this.playerInfo.shuffleModeEnabled);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean getPlayWhenReady() {
        return this.playerInfo.playWhenReady;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public PlaybackParameters getPlaybackParameters() {
        return this.playerInfo.playbackParameters;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getPlaybackState() {
        return this.playerInfo.playbackState;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getPlaybackSuppressionReason() {
        return this.playerInfo.playbackSuppressionReason;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    @Nullable
    public PlaybackException getPlayerError() {
        return this.playerInfo.playerError;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public MediaMetadata getPlaylistMetadata() {
        return this.playerInfo.playlistMetadata;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getPreviousMediaItemIndex() {
        if (this.playerInfo.timeline.isEmpty()) {
            return -1;
        }
        return this.playerInfo.timeline.getPreviousWindowIndex(getCurrentMediaItemIndex(), convertRepeatModeForNavigation(this.playerInfo.repeatMode), this.playerInfo.shuffleModeEnabled);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getRepeatMode() {
        return this.playerInfo.repeatMode;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getSeekBackIncrement() {
        return this.playerInfo.seekBackIncrementMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getSeekForwardIncrement() {
        return this.playerInfo.seekForwardIncrementMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public PendingIntent getSessionActivity() {
        return this.sessionActivity;
    }

    @Nullable
    public IMediaSession getSessionInterfaceWithSessionCommandIfAble(int i10) {
        Assertions.checkArgument(i10 != 0);
        if (this.sessionCommands.contains(i10)) {
            return this.iSession;
        }
        Log.w(TAG, "Controller isn't allowed to call command, commandCode=" + i10);
        return null;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean getShuffleModeEnabled() {
        return this.playerInfo.shuffleModeEnabled;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public Size getSurfaceSize() {
        return this.surfaceSize;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getTotalBufferedDuration() {
        return this.playerInfo.sessionPositionInfo.totalBufferedDurationMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public TrackSelectionParameters getTrackSelectionParameters() {
        return this.playerInfo.trackSelectionParameters;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public VideoSize getVideoSize() {
        return this.playerInfo.videoSize;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public float getVolume() {
        return this.playerInfo.volume;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean hasNextMediaItem() {
        return getNextMediaItemIndex() != -1;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean hasPreviousMediaItem() {
        return getPreviousMediaItemIndex() != -1;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    @Deprecated
    public void increaseDeviceVolume() {
        if (isPlayerCommandAvailable(26)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.g3
                public /* synthetic */ g3() {
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$increaseDeviceVolume$55(iMediaSession, i10);
                }
            });
            int i10 = this.playerInfo.deviceVolume + 1;
            int i11 = getDeviceInfo().maxVolume;
            if (i11 == 0 || i10 <= i11) {
                PlayerInfo playerInfo = this.playerInfo;
                this.playerInfo = playerInfo.copyWithDeviceVolume(i10, playerInfo.deviceMuted);
                this.listeners.queueEvent(30, new ListenerSet.Event() { // from class: androidx.media3.session.h3

                    /* renamed from: b */
                    public final /* synthetic */ int f590b;

                    public /* synthetic */ h3(int i102) {
                        i10 = i102;
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.this.lambda$increaseDeviceVolume$56(i10, (Player.Listener) obj);
                    }
                });
                this.listeners.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean isConnected() {
        return this.iSession != null;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean isDeviceMuted() {
        return this.playerInfo.deviceMuted;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean isLoading() {
        return this.playerInfo.isLoading;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean isPlaying() {
        return this.playerInfo.isPlaying;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean isPlayingAd() {
        return this.playerInfo.sessionPositionInfo.isPlayingAd;
    }

    public boolean isReleased() {
        return this.released;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void moveMediaItem(int i10, int i11) {
        if (isPlayerCommandAvailable(20)) {
            Assertions.checkArgument(i10 >= 0 && i11 >= 0);
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.v

                /* renamed from: b */
                public final /* synthetic */ int f965b;

                /* renamed from: c */
                public final /* synthetic */ int f966c;

                public /* synthetic */ v(int i102, int i112) {
                    i10 = i102;
                    i11 = i112;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i12) {
                    MediaControllerImplBase.this.lambda$moveMediaItem$37(i10, i11, iMediaSession, i12);
                }
            });
            moveMediaItemsInternal(i102, i102 + 1, i112);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void moveMediaItems(int i10, int i11, int i12) {
        if (isPlayerCommandAvailable(20)) {
            Assertions.checkArgument(i10 >= 0 && i10 <= i11 && i12 >= 0);
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.q2

                /* renamed from: b */
                public final /* synthetic */ int f847b;

                /* renamed from: c */
                public final /* synthetic */ int f848c;

                /* renamed from: d */
                public final /* synthetic */ int f849d;

                public /* synthetic */ q2(int i102, int i112, int i122) {
                    i10 = i102;
                    i11 = i112;
                    i12 = i122;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i13) {
                    MediaControllerImplBase.this.lambda$moveMediaItems$38(i10, i11, i12, iMediaSession, i13);
                }
            });
            moveMediaItemsInternal(i102, i112, i122);
        }
    }

    public void notifyPeriodicSessionPositionInfoChanged(SessionPositionInfo sessionPositionInfo) {
        if (isConnected()) {
            updateSessionPositionInfoIfNeeded(sessionPositionInfo);
        }
    }

    public void onAvailableCommandsChangedFromPlayer(Player.Commands commands) {
        if (isConnected() && !Util.areEqual(this.playerCommandsFromPlayer, commands)) {
            this.playerCommandsFromPlayer = commands;
            Player.Commands commands2 = this.intersectedPlayerCommands;
            this.intersectedPlayerCommands = createIntersectedCommands(this.playerCommandsFromSession, commands);
            if (!Util.areEqual(r3, commands2)) {
                this.listeners.sendEvent(13, new ListenerSet.Event() { // from class: androidx.media3.session.s
                    public /* synthetic */ s() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.this.lambda$onAvailableCommandsChangedFromPlayer$115((Player.Listener) obj);
                    }
                });
            }
        }
    }

    public void onAvailableCommandsChangedFromSession(SessionCommands sessionCommands, Player.Commands commands) {
        boolean z10;
        if (isConnected()) {
            boolean z11 = !Util.areEqual(this.playerCommandsFromSession, commands);
            boolean z12 = !Util.areEqual(this.sessionCommands, sessionCommands);
            if (z11 || z12) {
                if (z11) {
                    this.playerCommandsFromSession = commands;
                    Player.Commands commands2 = this.intersectedPlayerCommands;
                    Player.Commands createIntersectedCommands = createIntersectedCommands(commands, this.playerCommandsFromPlayer);
                    this.intersectedPlayerCommands = createIntersectedCommands;
                    z10 = !Util.areEqual(createIntersectedCommands, commands2);
                } else {
                    z10 = false;
                }
                if (z12) {
                    this.sessionCommands = sessionCommands;
                }
                if (z10) {
                    this.listeners.sendEvent(13, new ListenerSet.Event() { // from class: androidx.media3.session.p
                        public /* synthetic */ p() {
                        }

                        @Override // androidx.media3.common.util.ListenerSet.Event
                        public final void invoke(Object obj) {
                            MediaControllerImplBase.this.lambda$onAvailableCommandsChangedFromSession$113((Player.Listener) obj);
                        }
                    });
                }
                if (z12) {
                    getInstance().notifyControllerListener(new Consumer() { // from class: androidx.media3.session.q

                        /* renamed from: b */
                        public final /* synthetic */ SessionCommands f842b;

                        public /* synthetic */ q(SessionCommands sessionCommands2) {
                            sessionCommands = sessionCommands2;
                        }

                        @Override // androidx.media3.common.util.Consumer
                        public final void accept(Object obj) {
                            MediaControllerImplBase.this.lambda$onAvailableCommandsChangedFromSession$114(sessionCommands, (MediaController.Listener) obj);
                        }
                    });
                }
            }
        }
    }

    public void onConnected(ConnectionState connectionState) {
        if (this.iSession != null) {
            Log.e(TAG, "Cannot be notified about the connection result many times. Probably a bug or malicious app.");
            getInstance().release();
            return;
        }
        this.iSession = connectionState.sessionBinder;
        this.sessionActivity = connectionState.sessionActivity;
        this.sessionCommands = connectionState.sessionCommands;
        Player.Commands commands = connectionState.playerCommandsFromSession;
        this.playerCommandsFromSession = commands;
        Player.Commands commands2 = connectionState.playerCommandsFromPlayer;
        this.playerCommandsFromPlayer = commands2;
        this.intersectedPlayerCommands = createIntersectedCommands(commands, commands2);
        this.playerInfo = connectionState.playerInfo;
        try {
            connectionState.sessionBinder.asBinder().linkToDeath(this.deathRecipient, 0);
            this.connectedToken = new SessionToken(this.token.getUid(), 0, connectionState.libraryVersion, connectionState.sessionInterfaceVersion, this.token.getPackageName(), connectionState.sessionBinder, connectionState.tokenExtras);
            getInstance().notifyAccepted();
        } catch (RemoteException unused) {
            getInstance().release();
        }
    }

    public void onCustomCommand(int i10, SessionCommand sessionCommand, Bundle bundle) {
        if (isConnected()) {
            getInstance().notifyControllerListener(new Consumer() { // from class: androidx.media3.session.d3

                /* renamed from: b */
                public final /* synthetic */ SessionCommand f469b;

                /* renamed from: c */
                public final /* synthetic */ Bundle f470c;

                /* renamed from: d */
                public final /* synthetic */ int f471d;

                public /* synthetic */ d3(SessionCommand sessionCommand2, Bundle bundle2, int i102) {
                    sessionCommand = sessionCommand2;
                    bundle = bundle2;
                    i10 = i102;
                }

                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaControllerImplBase.this.lambda$onCustomCommand$85(sessionCommand, bundle, i10, (MediaController.Listener) obj);
                }
            });
        }
    }

    public void onExtrasChanged(Bundle bundle) {
        if (isConnected()) {
            getInstance().notifyControllerListener(new Consumer() { // from class: androidx.media3.session.h2

                /* renamed from: b */
                public final /* synthetic */ Bundle f588b;

                public /* synthetic */ h2(Bundle bundle2) {
                    bundle = bundle2;
                }

                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaControllerImplBase.this.lambda$onExtrasChanged$117(bundle, (MediaController.Listener) obj);
                }
            });
        }
    }

    public void onPlayerInfoChanged(PlayerInfo playerInfo, PlayerInfo.BundlingExclusions bundlingExclusions) {
        PlayerInfo.BundlingExclusions bundlingExclusions2;
        if (isConnected()) {
            PlayerInfo playerInfo2 = this.pendingPlayerInfo;
            if (playerInfo2 != null && (bundlingExclusions2 = this.pendingBundlingExclusions) != null) {
                Pair<PlayerInfo, PlayerInfo.BundlingExclusions> mergePlayerInfo = MediaUtils.mergePlayerInfo(playerInfo2, bundlingExclusions2, playerInfo, bundlingExclusions, this.intersectedPlayerCommands);
                PlayerInfo playerInfo3 = (PlayerInfo) mergePlayerInfo.first;
                bundlingExclusions = (PlayerInfo.BundlingExclusions) mergePlayerInfo.second;
                playerInfo = playerInfo3;
            }
            this.pendingPlayerInfo = null;
            this.pendingBundlingExclusions = null;
            if (!this.pendingMaskingSequencedFutureNumbers.isEmpty()) {
                this.pendingPlayerInfo = playerInfo;
                this.pendingBundlingExclusions = bundlingExclusions;
                return;
            }
            PlayerInfo playerInfo4 = this.playerInfo;
            PlayerInfo playerInfo5 = (PlayerInfo) MediaUtils.mergePlayerInfo(playerInfo4, PlayerInfo.BundlingExclusions.NONE, playerInfo, bundlingExclusions, this.intersectedPlayerCommands).first;
            this.playerInfo = playerInfo5;
            PlaybackException playbackException = playerInfo4.playerError;
            PlaybackException playbackException2 = playerInfo5.playerError;
            if (playbackException != playbackException2 && (playbackException == null || !playbackException.errorInfoEquals(playbackException2))) {
                this.listeners.queueEvent(10, new ListenerSet.Event() { // from class: androidx.media3.session.e1
                    public /* synthetic */ e1() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$86(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
                if (playerInfo5.playerError != null) {
                    this.listeners.queueEvent(10, new ListenerSet.Event() { // from class: androidx.media3.session.p1
                        public /* synthetic */ p1() {
                        }

                        @Override // androidx.media3.common.util.ListenerSet.Event
                        public final void invoke(Object obj) {
                            MediaControllerImplBase.lambda$onPlayerInfoChanged$87(PlayerInfo.this, (Player.Listener) obj);
                        }
                    });
                }
            }
            MediaItem currentMediaItem = playerInfo4.getCurrentMediaItem();
            MediaItem currentMediaItem2 = playerInfo5.getCurrentMediaItem();
            if (!Util.areEqual(currentMediaItem, currentMediaItem2)) {
                this.listeners.queueEvent(1, new ListenerSet.Event() { // from class: androidx.media3.session.y1

                    /* renamed from: b */
                    public final /* synthetic */ PlayerInfo f1040b;

                    public /* synthetic */ y1(PlayerInfo playerInfo52) {
                        playerInfo5 = playerInfo52;
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$88(MediaItem.this, playerInfo5, (Player.Listener) obj);
                    }
                });
            }
            if (!Util.areEqual(playerInfo4.currentTracks, playerInfo52.currentTracks)) {
                this.listeners.queueEvent(2, new ListenerSet.Event() { // from class: androidx.media3.session.z1
                    public /* synthetic */ z1() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$89(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
            }
            if (!Util.areEqual(playerInfo4.playbackParameters, playerInfo52.playbackParameters)) {
                this.listeners.queueEvent(12, new ListenerSet.Event() { // from class: androidx.media3.session.a2
                    public /* synthetic */ a2() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$90(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
            }
            if (playerInfo4.repeatMode != playerInfo52.repeatMode) {
                this.listeners.queueEvent(8, new ListenerSet.Event() { // from class: androidx.media3.session.c2
                    public /* synthetic */ c2() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$91(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
            }
            if (playerInfo4.shuffleModeEnabled != playerInfo52.shuffleModeEnabled) {
                this.listeners.queueEvent(9, new ListenerSet.Event() { // from class: androidx.media3.session.d2
                    public /* synthetic */ d2() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$92(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
            }
            if (!Util.areEqual(playerInfo4.timeline, playerInfo52.timeline)) {
                this.listeners.queueEvent(0, new ListenerSet.Event() { // from class: androidx.media3.session.e2
                    public /* synthetic */ e2() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$93(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
            }
            if (!Util.areEqual(playerInfo4.playlistMetadata, playerInfo52.playlistMetadata)) {
                this.listeners.queueEvent(15, new ListenerSet.Event() { // from class: androidx.media3.session.f2
                    public /* synthetic */ f2() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$94(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
            }
            if (playerInfo4.volume != playerInfo52.volume) {
                this.listeners.queueEvent(22, new ListenerSet.Event() { // from class: androidx.media3.session.g2
                    public /* synthetic */ g2() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$95(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
            }
            if (!Util.areEqual(playerInfo4.audioAttributes, playerInfo52.audioAttributes)) {
                this.listeners.queueEvent(20, new ListenerSet.Event() { // from class: androidx.media3.session.f1
                    public /* synthetic */ f1() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$96(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
            }
            if (!playerInfo4.cueGroup.cues.equals(playerInfo52.cueGroup.cues)) {
                this.listeners.queueEvent(27, new ListenerSet.Event() { // from class: androidx.media3.session.g1
                    public /* synthetic */ g1() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$97(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
                this.listeners.queueEvent(27, new ListenerSet.Event() { // from class: androidx.media3.session.h1
                    public /* synthetic */ h1() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$98(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
            }
            if (!Util.areEqual(playerInfo4.deviceInfo, playerInfo52.deviceInfo)) {
                this.listeners.queueEvent(29, new ListenerSet.Event() { // from class: androidx.media3.session.i1
                    public /* synthetic */ i1() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$99(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
            }
            if (playerInfo4.deviceVolume != playerInfo52.deviceVolume || playerInfo4.deviceMuted != playerInfo52.deviceMuted) {
                this.listeners.queueEvent(30, new ListenerSet.Event() { // from class: androidx.media3.session.j1
                    public /* synthetic */ j1() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$100(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
            }
            if (playerInfo4.playWhenReady != playerInfo52.playWhenReady) {
                this.listeners.queueEvent(5, new ListenerSet.Event() { // from class: androidx.media3.session.k1
                    public /* synthetic */ k1() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$101(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
            }
            if (playerInfo4.playbackSuppressionReason != playerInfo52.playbackSuppressionReason) {
                this.listeners.queueEvent(6, new ListenerSet.Event() { // from class: androidx.media3.session.l1
                    public /* synthetic */ l1() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$102(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
            }
            if (playerInfo4.playbackState != playerInfo52.playbackState) {
                this.listeners.queueEvent(4, new ListenerSet.Event() { // from class: androidx.media3.session.m1
                    public /* synthetic */ m1() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$103(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
            }
            if (playerInfo4.isPlaying != playerInfo52.isPlaying) {
                this.listeners.queueEvent(7, new ListenerSet.Event() { // from class: androidx.media3.session.n1
                    public /* synthetic */ n1() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$104(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
            }
            if (playerInfo4.isLoading != playerInfo52.isLoading) {
                this.listeners.queueEvent(3, new ListenerSet.Event() { // from class: androidx.media3.session.o1
                    public /* synthetic */ o1() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$105(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
            }
            if (!Util.areEqual(playerInfo4.videoSize, playerInfo52.videoSize)) {
                this.listeners.queueEvent(25, new ListenerSet.Event() { // from class: androidx.media3.session.r1
                    public /* synthetic */ r1() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$106(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
            }
            if (!Util.areEqual(playerInfo4.oldPositionInfo, playerInfo52.oldPositionInfo) || !Util.areEqual(playerInfo4.newPositionInfo, playerInfo52.newPositionInfo)) {
                this.listeners.queueEvent(11, new ListenerSet.Event() { // from class: androidx.media3.session.s1
                    public /* synthetic */ s1() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$107(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
            }
            if (!Util.areEqual(playerInfo4.mediaMetadata, playerInfo52.mediaMetadata)) {
                this.listeners.queueEvent(14, new ListenerSet.Event() { // from class: androidx.media3.session.t1
                    public /* synthetic */ t1() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$108(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
            }
            if (playerInfo4.seekBackIncrementMs != playerInfo52.seekBackIncrementMs) {
                this.listeners.queueEvent(16, new ListenerSet.Event() { // from class: androidx.media3.session.u1
                    public /* synthetic */ u1() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$109(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
            }
            if (playerInfo4.seekForwardIncrementMs != playerInfo52.seekForwardIncrementMs) {
                this.listeners.queueEvent(17, new ListenerSet.Event() { // from class: androidx.media3.session.v1
                    public /* synthetic */ v1() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$110(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
            }
            if (playerInfo4.maxSeekToPreviousPositionMs != playerInfo52.maxSeekToPreviousPositionMs) {
                this.listeners.queueEvent(18, new ListenerSet.Event() { // from class: androidx.media3.session.w1
                    public /* synthetic */ w1() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$111(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
            }
            if (!Util.areEqual(playerInfo4.trackSelectionParameters, playerInfo52.trackSelectionParameters)) {
                this.listeners.queueEvent(19, new ListenerSet.Event() { // from class: androidx.media3.session.x1
                    public /* synthetic */ x1() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.lambda$onPlayerInfoChanged$112(PlayerInfo.this, (Player.Listener) obj);
                    }
                });
            }
            this.listeners.flushEvents();
        }
    }

    public void onRenderedFirstFrame() {
        this.listeners.sendEvent(26, new m0.p0());
    }

    public void onSetCustomLayout(int i10, List<CommandButton> list) {
        SessionCommand sessionCommand;
        int i11;
        if (isConnected()) {
            ArrayList arrayList = new ArrayList();
            for (int i12 = 0; i12 < list.size(); i12++) {
                CommandButton commandButton = list.get(i12);
                if (this.intersectedPlayerCommands.contains(commandButton.playerCommand) || (((sessionCommand = commandButton.sessionCommand) != null && this.sessionCommands.contains(sessionCommand)) || ((i11 = commandButton.playerCommand) != -1 && this.sessionCommands.contains(i11)))) {
                    arrayList.add(commandButton);
                }
            }
            getInstance().notifyControllerListener(new Consumer() { // from class: androidx.media3.session.j3

                /* renamed from: b */
                public final /* synthetic */ List f646b;

                /* renamed from: c */
                public final /* synthetic */ int f647c;

                public /* synthetic */ j3(List arrayList2, int i102) {
                    arrayList = arrayList2;
                    i10 = i102;
                }

                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaControllerImplBase.this.lambda$onSetCustomLayout$116(arrayList, i10, (MediaController.Listener) obj);
                }
            });
        }
    }

    public void onSetSessionActivity(int i10, PendingIntent pendingIntent) {
        if (isConnected()) {
            this.sessionActivity = pendingIntent;
            getInstance().notifyControllerListener(new Consumer() { // from class: androidx.media3.session.y2

                /* renamed from: b */
                public final /* synthetic */ PendingIntent f1042b;

                public /* synthetic */ y2(PendingIntent pendingIntent2) {
                    pendingIntent = pendingIntent2;
                }

                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaControllerImplBase.this.lambda$onSetSessionActivity$118(pendingIntent, (MediaController.Listener) obj);
                }
            });
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void pause() {
        if (isPlayerCommandAvailable(1)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.f3
                public /* synthetic */ f3() {
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$pause$6(iMediaSession, i10);
                }
            });
            setPlayWhenReady(false, 0, 1);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void play() {
        if (isPlayerCommandAvailable(1)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.o3
                public /* synthetic */ o3() {
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$play$5(iMediaSession, i10);
                }
            });
            setPlayWhenReady(true, 0, 1);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void prepare() {
        if (isPlayerCommandAvailable(2)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.r3
                public /* synthetic */ r3() {
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$prepare$7(iMediaSession, i10);
                }
            });
            PlayerInfo playerInfo = this.playerInfo;
            if (playerInfo.playbackState == 1) {
                updatePlayerInfo(playerInfo.copyWithPlaybackState(playerInfo.timeline.isEmpty() ? 4 : 2, null), 0, 1, false, 5, false, 0);
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void release() {
        IMediaSession iMediaSession = this.iSession;
        if (this.released) {
            return;
        }
        this.released = true;
        this.connectedToken = null;
        this.flushCommandQueueHandler.release();
        this.iSession = null;
        if (iMediaSession != null) {
            int obtainNextSequenceNumber = this.sequencedFutureManager.obtainNextSequenceNumber();
            try {
                iMediaSession.asBinder().unlinkToDeath(this.deathRecipient, 0);
                iMediaSession.release(this.controllerStub, obtainNextSequenceNumber);
            } catch (RemoteException unused) {
            }
        }
        this.listeners.release();
        this.sequencedFutureManager.lazyRelease(30000L, new Runnable() { // from class: androidx.media3.session.n2
            public /* synthetic */ n2() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaControllerImplBase.this.lambda$release$4();
            }
        });
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void removeListener(Player.Listener listener) {
        this.listeners.remove(listener);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void removeMediaItem(int i10) {
        if (isPlayerCommandAvailable(20)) {
            Assertions.checkArgument(i10 >= 0);
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.t2

                /* renamed from: b */
                public final /* synthetic */ int f912b;

                public /* synthetic */ t2(int i102) {
                    i10 = i102;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i11) {
                    MediaControllerImplBase.this.lambda$removeMediaItem$34(i10, iMediaSession, i11);
                }
            });
            removeMediaItemsInternal(i102, i102 + 1);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void removeMediaItems(int i10, int i11) {
        if (isPlayerCommandAvailable(20)) {
            Assertions.checkArgument(i10 >= 0 && i11 >= i10);
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.d1

                /* renamed from: b */
                public final /* synthetic */ int f465b;

                /* renamed from: c */
                public final /* synthetic */ int f466c;

                public /* synthetic */ d1(int i102, int i112) {
                    i10 = i102;
                    i11 = i112;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i12) {
                    MediaControllerImplBase.this.lambda$removeMediaItems$35(i10, i11, iMediaSession, i12);
                }
            });
            removeMediaItemsInternal(i102, i112);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void replaceMediaItem(int i10, MediaItem mediaItem) {
        if (isPlayerCommandAvailable(20)) {
            Assertions.checkArgument(i10 >= 0);
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.k0

                /* renamed from: b */
                public final /* synthetic */ int f677b;

                /* renamed from: c */
                public final /* synthetic */ MediaItem f678c;

                public /* synthetic */ k0(int i102, MediaItem mediaItem2) {
                    i10 = i102;
                    mediaItem = mediaItem2;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i11) {
                    MediaControllerImplBase.this.lambda$replaceMediaItem$39(i10, mediaItem, iMediaSession, i11);
                }
            });
            replaceMediaItemsInternal(i102, i102 + 1, ImmutableList.of(mediaItem2));
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void replaceMediaItems(int i10, int i11, List<MediaItem> list) {
        if (isPlayerCommandAvailable(20)) {
            Assertions.checkArgument(i10 >= 0 && i10 <= i11);
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.i3

                /* renamed from: b */
                public final /* synthetic */ List f621b;

                /* renamed from: c */
                public final /* synthetic */ int f622c;

                /* renamed from: d */
                public final /* synthetic */ int f623d;

                public /* synthetic */ i3(List list2, int i102, int i112) {
                    list = list2;
                    i10 = i102;
                    i11 = i112;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i12) {
                    MediaControllerImplBase.this.lambda$replaceMediaItems$40(list, i10, i11, iMediaSession, i12);
                }
            });
            replaceMediaItemsInternal(i102, i112, list2);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekBack() {
        if (isPlayerCommandAvailable(11)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.c3
                public /* synthetic */ c3() {
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$seekBack$12(iMediaSession, i10);
                }
            });
            seekToInternalByOffset(-getSeekBackIncrement());
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekForward() {
        if (isPlayerCommandAvailable(12)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.t0
                public /* synthetic */ t0() {
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$seekForward$13(iMediaSession, i10);
                }
            });
            seekToInternalByOffset(getSeekForwardIncrement());
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekTo(long j10) {
        if (isPlayerCommandAvailable(5)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.r0

                /* renamed from: b */
                public final /* synthetic */ long f864b;

                public /* synthetic */ r0(long j102) {
                    j10 = j102;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$seekTo$10(j10, iMediaSession, i10);
                }
            });
            seekToInternal(getCurrentMediaItemIndex(), j102);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekToDefaultPosition() {
        if (isPlayerCommandAvailable(4)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.c1
                public /* synthetic */ c1() {
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$seekToDefaultPosition$8(iMediaSession, i10);
                }
            });
            seekToInternal(getCurrentMediaItemIndex(), C.TIME_UNSET);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekToNext() {
        if (isPlayerCommandAvailable(9)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.x2
                public /* synthetic */ x2() {
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$seekToNext$44(iMediaSession, i10);
                }
            });
            Timeline currentTimeline = getCurrentTimeline();
            if (currentTimeline.isEmpty() || isPlayingAd()) {
                return;
            }
            if (hasNextMediaItem()) {
                seekToInternal(getNextMediaItemIndex(), C.TIME_UNSET);
                return;
            }
            Timeline.Window window = currentTimeline.getWindow(getCurrentMediaItemIndex(), new Timeline.Window());
            if (window.isDynamic && window.isLive()) {
                seekToInternal(getCurrentMediaItemIndex(), C.TIME_UNSET);
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekToNextMediaItem() {
        if (isPlayerCommandAvailable(8)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.z
                public /* synthetic */ z() {
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$seekToNextMediaItem$42(iMediaSession, i10);
                }
            });
            if (getNextMediaItemIndex() != -1) {
                seekToInternal(getNextMediaItemIndex(), C.TIME_UNSET);
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekToPrevious() {
        if (isPlayerCommandAvailable(7)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.u2
                public /* synthetic */ u2() {
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$seekToPrevious$43(iMediaSession, i10);
                }
            });
            Timeline currentTimeline = getCurrentTimeline();
            if (currentTimeline.isEmpty() || isPlayingAd()) {
                return;
            }
            boolean hasPreviousMediaItem = hasPreviousMediaItem();
            Timeline.Window window = currentTimeline.getWindow(getCurrentMediaItemIndex(), new Timeline.Window());
            if (window.isDynamic && window.isLive()) {
                if (hasPreviousMediaItem) {
                    seekToInternal(getPreviousMediaItemIndex(), C.TIME_UNSET);
                }
            } else if (!hasPreviousMediaItem || getCurrentPosition() > getMaxSeekToPreviousPosition()) {
                seekToInternal(getCurrentMediaItemIndex(), 0L);
            } else {
                seekToInternal(getPreviousMediaItemIndex(), C.TIME_UNSET);
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekToPreviousMediaItem() {
        if (isPlayerCommandAvailable(6)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.b2
                public /* synthetic */ b2() {
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$seekToPreviousMediaItem$41(iMediaSession, i10);
                }
            });
            if (getPreviousMediaItemIndex() != -1) {
                seekToInternal(getPreviousMediaItemIndex(), C.TIME_UNSET);
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public p5.c0<SessionResult> sendCustomCommand(SessionCommand sessionCommand, Bundle bundle) {
        return dispatchRemoteSessionTaskWithSessionCommand(sessionCommand, new RemoteSessionTask() { // from class: androidx.media3.session.b1

            /* renamed from: b */
            public final /* synthetic */ SessionCommand f417b;

            /* renamed from: c */
            public final /* synthetic */ Bundle f418c;

            public /* synthetic */ b1(SessionCommand sessionCommand2, Bundle bundle2) {
                sessionCommand = sessionCommand2;
                bundle = bundle2;
            }

            @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
            public final void run(IMediaSession iMediaSession, int i10) {
                MediaControllerImplBase.this.lambda$sendCustomCommand$21(sessionCommand, bundle, iMediaSession, i10);
            }
        });
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    @Deprecated
    public void setDeviceMuted(boolean z10) {
        if (isPlayerCommandAvailable(26)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.s3

                /* renamed from: b */
                public final /* synthetic */ boolean f894b;

                public /* synthetic */ s3(boolean z102) {
                    z10 = z102;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$setDeviceMuted$63(z10, iMediaSession, i10);
                }
            });
            PlayerInfo playerInfo = this.playerInfo;
            if (playerInfo.deviceMuted != z102) {
                this.playerInfo = playerInfo.copyWithDeviceVolume(playerInfo.deviceVolume, z102);
                this.listeners.queueEvent(30, new ListenerSet.Event() { // from class: androidx.media3.session.t3

                    /* renamed from: b */
                    public final /* synthetic */ boolean f914b;

                    public /* synthetic */ t3(boolean z102) {
                        z10 = z102;
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.this.lambda$setDeviceMuted$64(z10, (Player.Listener) obj);
                    }
                });
                this.listeners.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    @Deprecated
    public void setDeviceVolume(int i10) {
        if (isPlayerCommandAvailable(25)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.b0

                /* renamed from: b */
                public final /* synthetic */ int f415b;

                public /* synthetic */ b0(int i102) {
                    i10 = i102;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i11) {
                    MediaControllerImplBase.this.lambda$setDeviceVolume$51(i10, iMediaSession, i11);
                }
            });
            DeviceInfo deviceInfo = getDeviceInfo();
            PlayerInfo playerInfo = this.playerInfo;
            if (playerInfo.deviceVolume == i102 || deviceInfo.minVolume > i102) {
                return;
            }
            int i11 = deviceInfo.maxVolume;
            if (i11 == 0 || i102 <= i11) {
                this.playerInfo = playerInfo.copyWithDeviceVolume(i102, playerInfo.deviceMuted);
                this.listeners.queueEvent(30, new ListenerSet.Event() { // from class: androidx.media3.session.c0

                    /* renamed from: b */
                    public final /* synthetic */ int f442b;

                    public /* synthetic */ c0(int i102) {
                        i10 = i102;
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.this.lambda$setDeviceVolume$52(i10, (Player.Listener) obj);
                    }
                });
                this.listeners.flushEvents();
            }
        }
    }

    public <T> void setFutureResult(int i10, T t10) {
        this.sequencedFutureManager.setFutureResult(i10, t10);
        getInstance().runOnApplicationLooper(new Runnable() { // from class: androidx.media3.session.k3

            /* renamed from: c */
            public final /* synthetic */ int f683c;

            public /* synthetic */ k3(int i102) {
                i10 = i102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaControllerImplBase.this.lambda$setFutureResult$83(i10);
            }
        });
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setMediaItem(MediaItem mediaItem) {
        if (isPlayerCommandAvailable(31)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.x0

                /* renamed from: b */
                public final /* synthetic */ MediaItem f1014b;

                public /* synthetic */ x0(MediaItem mediaItem2) {
                    mediaItem = mediaItem2;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$setMediaItem$22(mediaItem, iMediaSession, i10);
                }
            });
            setMediaItemsInternal(Collections.singletonList(mediaItem2), -1, C.TIME_UNSET, true);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setMediaItems(List<MediaItem> list) {
        if (isPlayerCommandAvailable(20)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.v0

                /* renamed from: b */
                public final /* synthetic */ List f968b;

                public /* synthetic */ v0(List list2) {
                    list = list2;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$setMediaItems$25(list, iMediaSession, i10);
                }
            });
            setMediaItemsInternal(list2, -1, C.TIME_UNSET, true);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setPlayWhenReady(boolean z10) {
        if (isPlayerCommandAvailable(1)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.u

                /* renamed from: b */
                public final /* synthetic */ boolean f936b;

                public /* synthetic */ u(boolean z102) {
                    z10 = z102;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$setPlayWhenReady$14(z10, iMediaSession, i10);
                }
            });
            setPlayWhenReady(z102, 0, 1);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        if (isPlayerCommandAvailable(13)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.p0

                /* renamed from: b */
                public final /* synthetic */ PlaybackParameters f820b;

                public /* synthetic */ p0(PlaybackParameters playbackParameters2) {
                    playbackParameters = playbackParameters2;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$setPlaybackParameters$15(playbackParameters, iMediaSession, i10);
                }
            });
            if (this.playerInfo.playbackParameters.equals(playbackParameters2)) {
                return;
            }
            this.playerInfo = this.playerInfo.copyWithPlaybackParameters(playbackParameters2);
            this.listeners.queueEvent(12, new ListenerSet.Event() { // from class: androidx.media3.session.q0
                public /* synthetic */ q0() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).onPlaybackParametersChanged(PlaybackParameters.this);
                }
            });
            this.listeners.flushEvents();
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setPlaybackSpeed(float f10) {
        if (isPlayerCommandAvailable(13)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.k2

                /* renamed from: b */
                public final /* synthetic */ float f681b;

                public /* synthetic */ k2(float f102) {
                    f10 = f102;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$setPlaybackSpeed$17(f10, iMediaSession, i10);
                }
            });
            PlaybackParameters playbackParameters = this.playerInfo.playbackParameters;
            if (playbackParameters.speed != f102) {
                PlaybackParameters withSpeed = playbackParameters.withSpeed(f102);
                this.playerInfo = this.playerInfo.copyWithPlaybackParameters(withSpeed);
                this.listeners.queueEvent(12, new ListenerSet.Event() { // from class: androidx.media3.session.l2
                    public /* synthetic */ l2() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        ((Player.Listener) obj).onPlaybackParametersChanged(PlaybackParameters.this);
                    }
                });
                this.listeners.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setPlaylistMetadata(MediaMetadata mediaMetadata) {
        if (isPlayerCommandAvailable(19)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.u0

                /* renamed from: b */
                public final /* synthetic */ MediaMetadata f938b;

                public /* synthetic */ u0(MediaMetadata mediaMetadata2) {
                    mediaMetadata = mediaMetadata2;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$setPlaylistMetadata$28(mediaMetadata, iMediaSession, i10);
                }
            });
            if (this.playerInfo.playlistMetadata.equals(mediaMetadata2)) {
                return;
            }
            this.playerInfo = this.playerInfo.copyWithPlaylistMetadata(mediaMetadata2);
            this.listeners.queueEvent(15, new ListenerSet.Event() { // from class: androidx.media3.session.w0
                public /* synthetic */ w0() {
                }

                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).onPlaylistMetadataChanged(MediaMetadata.this);
                }
            });
            this.listeners.flushEvents();
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public p5.c0<SessionResult> setRating(String str, Rating rating) {
        return dispatchRemoteSessionTaskWithSessionCommand(SessionCommand.COMMAND_CODE_SESSION_SET_RATING, new RemoteSessionTask() { // from class: androidx.media3.session.y0

            /* renamed from: b */
            public final /* synthetic */ String f1037b;

            /* renamed from: c */
            public final /* synthetic */ Rating f1038c;

            public /* synthetic */ y0(String str2, Rating rating2) {
                str = str2;
                rating = rating2;
            }

            @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
            public final void run(IMediaSession iMediaSession, int i10) {
                MediaControllerImplBase.this.lambda$setRating$19(str, rating, iMediaSession, i10);
            }
        });
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setRepeatMode(int i10) {
        if (isPlayerCommandAvailable(15)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.w

                /* renamed from: b */
                public final /* synthetic */ int f991b;

                public /* synthetic */ w(int i102) {
                    i10 = i102;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i11) {
                    MediaControllerImplBase.this.lambda$setRepeatMode$45(i10, iMediaSession, i11);
                }
            });
            PlayerInfo playerInfo = this.playerInfo;
            if (playerInfo.repeatMode != i102) {
                this.playerInfo = playerInfo.copyWithRepeatMode(i102);
                this.listeners.queueEvent(8, new ListenerSet.Event() { // from class: androidx.media3.session.x

                    /* renamed from: a */
                    public final /* synthetic */ int f1012a;

                    public /* synthetic */ x(int i102) {
                        i10 = i102;
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        ((Player.Listener) obj).onRepeatModeChanged(i10);
                    }
                });
                this.listeners.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setShuffleModeEnabled(boolean z10) {
        if (isPlayerCommandAvailable(14)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.r2

                /* renamed from: b */
                public final /* synthetic */ boolean f867b;

                public /* synthetic */ r2(boolean z102) {
                    z10 = z102;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$setShuffleModeEnabled$47(z10, iMediaSession, i10);
                }
            });
            PlayerInfo playerInfo = this.playerInfo;
            if (playerInfo.shuffleModeEnabled != z102) {
                this.playerInfo = playerInfo.copyWithShuffleModeEnabled(z102);
                this.listeners.queueEvent(9, new ListenerSet.Event() { // from class: androidx.media3.session.s2

                    /* renamed from: a */
                    public final /* synthetic */ boolean f892a;

                    public /* synthetic */ s2(boolean z102) {
                        z10 = z102;
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        ((Player.Listener) obj).onShuffleModeEnabledChanged(z10);
                    }
                });
                this.listeners.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        if (isPlayerCommandAvailable(29)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.f0

                /* renamed from: b */
                public final /* synthetic */ TrackSelectionParameters f523b;

                public /* synthetic */ f0(TrackSelectionParameters trackSelectionParameters2) {
                    trackSelectionParameters = trackSelectionParameters2;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$setTrackSelectionParameters$73(trackSelectionParameters, iMediaSession, i10);
                }
            });
            PlayerInfo playerInfo = this.playerInfo;
            if (trackSelectionParameters2 != playerInfo.trackSelectionParameters) {
                this.playerInfo = playerInfo.copyWithTrackSelectionParameters(trackSelectionParameters2);
                this.listeners.queueEvent(19, new ListenerSet.Event() { // from class: androidx.media3.session.g0
                    public /* synthetic */ g0() {
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        ((Player.Listener) obj).onTrackSelectionParametersChanged(TrackSelectionParameters.this);
                    }
                });
                this.listeners.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setVideoSurface(@Nullable Surface surface) {
        if (isPlayerCommandAvailable(27)) {
            clearSurfacesAndCallbacks();
            this.videoSurface = surface;
            dispatchRemoteSessionTaskWithPlayerCommandAndWaitForFuture(new RemoteSessionTask() { // from class: androidx.media3.session.l0

                /* renamed from: b */
                public final /* synthetic */ Surface f705b;

                public /* synthetic */ l0(Surface surface2) {
                    surface = surface2;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$setVideoSurface$68(surface, iMediaSession, i10);
                }
            });
            int i10 = surface2 == null ? 0 : -1;
            maybeNotifySurfaceSizeChanged(i10, i10);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        if (isPlayerCommandAvailable(27)) {
            if (surfaceHolder == null) {
                clearVideoSurface();
                return;
            }
            if (this.videoSurfaceHolder == surfaceHolder) {
                return;
            }
            clearSurfacesAndCallbacks();
            this.videoSurfaceHolder = surfaceHolder;
            surfaceHolder.addCallback(this.surfaceCallback);
            Surface surface = surfaceHolder.getSurface();
            if (surface == null || !surface.isValid()) {
                this.videoSurface = null;
                dispatchRemoteSessionTaskWithPlayerCommandAndWaitForFuture(new RemoteSessionTask() { // from class: androidx.media3.session.a1
                    public /* synthetic */ a1() {
                    }

                    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                    public final void run(IMediaSession iMediaSession, int i10) {
                        MediaControllerImplBase.this.lambda$setVideoSurfaceHolder$70(iMediaSession, i10);
                    }
                });
                maybeNotifySurfaceSizeChanged(0, 0);
            } else {
                this.videoSurface = surface;
                dispatchRemoteSessionTaskWithPlayerCommandAndWaitForFuture(new RemoteSessionTask() { // from class: androidx.media3.session.z0

                    /* renamed from: b */
                    public final /* synthetic */ Surface f1064b;

                    public /* synthetic */ z0(Surface surface2) {
                        surface = surface2;
                    }

                    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                    public final void run(IMediaSession iMediaSession, int i10) {
                        MediaControllerImplBase.this.lambda$setVideoSurfaceHolder$69(surface, iMediaSession, i10);
                    }
                });
                Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
                maybeNotifySurfaceSizeChanged(surfaceFrame.width(), surfaceFrame.height());
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        if (isPlayerCommandAvailable(27)) {
            setVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setVideoTextureView(@Nullable TextureView textureView) {
        if (isPlayerCommandAvailable(27)) {
            if (textureView == null) {
                clearVideoSurface();
                return;
            }
            if (this.videoTextureView == textureView) {
                return;
            }
            clearSurfacesAndCallbacks();
            this.videoTextureView = textureView;
            textureView.setSurfaceTextureListener(this.surfaceCallback);
            SurfaceTexture surfaceTexture = textureView.getSurfaceTexture();
            if (surfaceTexture == null) {
                dispatchRemoteSessionTaskWithPlayerCommandAndWaitForFuture(new RemoteSessionTask() { // from class: androidx.media3.session.i0
                    public /* synthetic */ i0() {
                    }

                    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                    public final void run(IMediaSession iMediaSession, int i10) {
                        MediaControllerImplBase.this.lambda$setVideoTextureView$71(iMediaSession, i10);
                    }
                });
                maybeNotifySurfaceSizeChanged(0, 0);
            } else {
                this.videoSurface = new Surface(surfaceTexture);
                dispatchRemoteSessionTaskWithPlayerCommandAndWaitForFuture(new RemoteSessionTask() { // from class: androidx.media3.session.j0
                    public /* synthetic */ j0() {
                    }

                    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                    public final void run(IMediaSession iMediaSession, int i10) {
                        MediaControllerImplBase.this.lambda$setVideoTextureView$72(iMediaSession, i10);
                    }
                });
                maybeNotifySurfaceSizeChanged(textureView.getWidth(), textureView.getHeight());
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setVolume(float f10) {
        if (isPlayerCommandAvailable(24)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.u3

                /* renamed from: b */
                public final /* synthetic */ float f942b;

                public /* synthetic */ u3(float f102) {
                    f10 = f102;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$setVolume$49(f10, iMediaSession, i10);
                }
            });
            PlayerInfo playerInfo = this.playerInfo;
            if (playerInfo.volume != f102) {
                this.playerInfo = playerInfo.copyWithVolume(f102);
                this.listeners.queueEvent(22, new ListenerSet.Event() { // from class: androidx.media3.session.v3

                    /* renamed from: a */
                    public final /* synthetic */ float f973a;

                    public /* synthetic */ v3(float f102) {
                        f10 = f102;
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        ((Player.Listener) obj).onVolumeChanged(f10);
                    }
                });
                this.listeners.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void stop() {
        if (isPlayerCommandAvailable(3)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.p3
                public /* synthetic */ p3() {
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$stop$2(iMediaSession, i10);
                }
            });
            PlayerInfo playerInfo = this.playerInfo;
            SessionPositionInfo sessionPositionInfo = this.playerInfo.sessionPositionInfo;
            Player.PositionInfo positionInfo = sessionPositionInfo.positionInfo;
            boolean z10 = sessionPositionInfo.isPlayingAd;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            SessionPositionInfo sessionPositionInfo2 = this.playerInfo.sessionPositionInfo;
            long j10 = sessionPositionInfo2.durationMs;
            long j11 = sessionPositionInfo2.positionInfo.positionMs;
            int calculateBufferedPercentage = MediaUtils.calculateBufferedPercentage(j11, j10);
            SessionPositionInfo sessionPositionInfo3 = this.playerInfo.sessionPositionInfo;
            PlayerInfo copyWithSessionPositionInfo = playerInfo.copyWithSessionPositionInfo(new SessionPositionInfo(positionInfo, z10, elapsedRealtime, j10, j11, calculateBufferedPercentage, 0L, sessionPositionInfo3.currentLiveOffsetMs, sessionPositionInfo3.contentDurationMs, sessionPositionInfo3.positionInfo.positionMs));
            this.playerInfo = copyWithSessionPositionInfo;
            if (copyWithSessionPositionInfo.playbackState != 1) {
                this.playerInfo = copyWithSessionPositionInfo.copyWithPlaybackState(1, copyWithSessionPositionInfo.playerError);
                this.listeners.queueEvent(4, new ListenerSet.Event() { // from class: androidx.media3.session.q3
                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        ((Player.Listener) obj).onPlaybackStateChanged(1);
                    }
                });
                this.listeners.flushEvents();
            }
        }
    }

    private p5.c0<SessionResult> dispatchRemoteSessionTaskWithSessionCommand(SessionCommand sessionCommand, RemoteSessionTask remoteSessionTask) {
        return dispatchRemoteSessionTaskWithSessionCommandInternal(0, sessionCommand, remoteSessionTask);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public p5.c0<SessionResult> setRating(Rating rating) {
        return dispatchRemoteSessionTaskWithSessionCommand(SessionCommand.COMMAND_CODE_SESSION_SET_RATING, new RemoteSessionTask() { // from class: androidx.media3.session.h0

            /* renamed from: b */
            public final /* synthetic */ Rating f585b;

            public /* synthetic */ h0(Rating rating2) {
                rating = rating2;
            }

            @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
            public final void run(IMediaSession iMediaSession, int i10) {
                MediaControllerImplBase.this.lambda$setRating$20(rating, iMediaSession, i10);
            }
        });
    }

    private void setPlayWhenReady(boolean z10, int i10, int i11) {
        PlayerInfo playerInfo = this.playerInfo;
        if (playerInfo.playWhenReady == z10 && playerInfo.playbackSuppressionReason == i10) {
            return;
        }
        maybeUpdateCurrentPositionMs();
        this.lastSetPlayWhenReadyCalledTimeMs = SystemClock.elapsedRealtime();
        updatePlayerInfo(this.playerInfo.copyWithPlayWhenReady(z10, i11, i10), 0, i11, false, 5, false, 0);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void addMediaItems(int i10, List<MediaItem> list) {
        if (isPlayerCommandAvailable(20)) {
            Assertions.checkArgument(i10 >= 0);
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.e3

                /* renamed from: b */
                public final /* synthetic */ int f499b;

                /* renamed from: c */
                public final /* synthetic */ List f500c;

                public /* synthetic */ e3(int i102, List list2) {
                    i10 = i102;
                    list = list2;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i11) {
                    MediaControllerImplBase.this.lambda$addMediaItems$33(i10, list, iMediaSession, i11);
                }
            });
            addMediaItemsInternal(i102, list2);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekTo(int i10, long j10) {
        if (isPlayerCommandAvailable(10)) {
            Assertions.checkArgument(i10 >= 0);
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.l3

                /* renamed from: b */
                public final /* synthetic */ int f709b;

                /* renamed from: c */
                public final /* synthetic */ long f710c;

                public /* synthetic */ l3(int i102, long j102) {
                    i10 = i102;
                    j10 = j102;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i11) {
                    MediaControllerImplBase.this.lambda$seekTo$11(i10, j10, iMediaSession, i11);
                }
            });
            seekToInternal(i102, j102);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekToDefaultPosition(int i10) {
        if (isPlayerCommandAvailable(10)) {
            Assertions.checkArgument(i10 >= 0);
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.o

                /* renamed from: b */
                public final /* synthetic */ int f796b;

                public /* synthetic */ o(int i102) {
                    i10 = i102;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i11) {
                    MediaControllerImplBase.this.lambda$seekToDefaultPosition$9(i10, iMediaSession, i11);
                }
            });
            seekToInternal(i102, C.TIME_UNSET);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setMediaItems(List<MediaItem> list, boolean z10) {
        if (isPlayerCommandAvailable(20)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.v2

                /* renamed from: b */
                public final /* synthetic */ List f971b;

                /* renamed from: c */
                public final /* synthetic */ boolean f972c;

                public /* synthetic */ v2(List list2, boolean z102) {
                    list = list2;
                    z10 = z102;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$setMediaItems$26(list, z10, iMediaSession, i10);
                }
            });
            setMediaItemsInternal(list2, -1, C.TIME_UNSET, z102);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void addMediaItem(int i10, MediaItem mediaItem) {
        if (isPlayerCommandAvailable(20)) {
            Assertions.checkArgument(i10 >= 0);
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.d4

                /* renamed from: b */
                public final /* synthetic */ int f473b;

                /* renamed from: c */
                public final /* synthetic */ MediaItem f474c;

                public /* synthetic */ d4(int i102, MediaItem mediaItem2) {
                    i10 = i102;
                    mediaItem = mediaItem2;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i11) {
                    MediaControllerImplBase.this.lambda$addMediaItem$31(i10, mediaItem, iMediaSession, i11);
                }
            });
            addMediaItemsInternal(i102, Collections.singletonList(mediaItem2));
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void clearVideoSurface(@Nullable Surface surface) {
        if (isPlayerCommandAvailable(27) && surface != null && this.videoSurface == surface) {
            clearVideoSurface();
        }
    }

    @Nullable
    public IMediaSession getSessionInterfaceWithSessionCommandIfAble(SessionCommand sessionCommand) {
        Assertions.checkArgument(sessionCommand.commandCode == 0);
        if (!this.sessionCommands.contains(sessionCommand)) {
            Log.w(TAG, "Controller isn't allowed to call custom session command:" + sessionCommand.customAction);
            return null;
        }
        return this.iSession;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setMediaItem(MediaItem mediaItem, long j10) {
        if (isPlayerCommandAvailable(31)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.m2

                /* renamed from: b */
                public final /* synthetic */ MediaItem f735b;

                /* renamed from: c */
                public final /* synthetic */ long f736c;

                public /* synthetic */ m2(MediaItem mediaItem2, long j102) {
                    mediaItem = mediaItem2;
                    j10 = j102;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$setMediaItem$23(mediaItem, j10, iMediaSession, i10);
                }
            });
            setMediaItemsInternal(Collections.singletonList(mediaItem2), -1, j102, false);
        }
    }

    private static PlayerInfo maskTimelineAndPositionInfo(PlayerInfo playerInfo, Timeline timeline, Player.PositionInfo positionInfo, SessionPositionInfo sessionPositionInfo, int i10) {
        return new PlayerInfo.Builder(playerInfo).setTimeline(timeline).setOldPositionInfo(playerInfo.sessionPositionInfo.positionInfo).setNewPositionInfo(positionInfo).setSessionPositionInfo(sessionPositionInfo).setDiscontinuityReason(i10).build();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setDeviceMuted(boolean z10, int i10) {
        if (isPlayerCommandAvailable(34)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.o2

                /* renamed from: b */
                public final /* synthetic */ boolean f801b;

                /* renamed from: c */
                public final /* synthetic */ int f802c;

                public /* synthetic */ o2(boolean z102, int i102) {
                    z10 = z102;
                    i10 = i102;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i11) {
                    MediaControllerImplBase.this.lambda$setDeviceMuted$65(z10, i10, iMediaSession, i11);
                }
            });
            PlayerInfo playerInfo = this.playerInfo;
            if (playerInfo.deviceMuted != z102) {
                this.playerInfo = playerInfo.copyWithDeviceVolume(playerInfo.deviceVolume, z102);
                this.listeners.queueEvent(30, new ListenerSet.Event() { // from class: androidx.media3.session.p2

                    /* renamed from: b */
                    public final /* synthetic */ boolean f823b;

                    public /* synthetic */ p2(boolean z102) {
                        z10 = z102;
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.this.lambda$setDeviceMuted$66(z10, (Player.Listener) obj);
                    }
                });
                this.listeners.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setMediaItems(List<MediaItem> list, int i10, long j10) {
        if (isPlayerCommandAvailable(20)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.a0

                /* renamed from: b */
                public final /* synthetic */ List f384b;

                /* renamed from: c */
                public final /* synthetic */ int f385c;

                /* renamed from: d */
                public final /* synthetic */ long f386d;

                public /* synthetic */ a0(List list2, int i102, long j102) {
                    list = list2;
                    i10 = i102;
                    j10 = j102;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i11) {
                    MediaControllerImplBase.this.lambda$setMediaItems$27(list, i10, j10, iMediaSession, i11);
                }
            });
            setMediaItemsInternal(list2, i102, j102, false);
        }
    }

    @Nullable
    private static PeriodInfo getPeriodInfo(Timeline timeline, Timeline.Window window, Timeline.Period period, int i10, long j10) {
        Assertions.checkIndex(i10, 0, timeline.getWindowCount());
        timeline.getWindow(i10, window);
        if (j10 == C.TIME_UNSET) {
            j10 = window.getDefaultPositionUs();
            if (j10 == C.TIME_UNSET) {
                return null;
            }
        }
        int i11 = window.firstPeriodIndex;
        timeline.getPeriod(i11, period);
        while (i11 < window.lastPeriodIndex && period.positionInWindowUs != j10) {
            int i12 = i11 + 1;
            if (timeline.getPeriod(i12, period).positionInWindowUs > j10) {
                break;
            }
            i11 = i12;
        }
        timeline.getPeriod(i11, period);
        return new PeriodInfo(i11, j10 - period.positionInWindowUs);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void decreaseDeviceVolume(int i10) {
        if (isPlayerCommandAvailable(34)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.n0

                /* renamed from: b */
                public final /* synthetic */ int f765b;

                public /* synthetic */ n0(int i102) {
                    i10 = i102;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i11) {
                    MediaControllerImplBase.this.lambda$decreaseDeviceVolume$61(i10, iMediaSession, i11);
                }
            });
            int i11 = this.playerInfo.deviceVolume - 1;
            if (i11 >= getDeviceInfo().minVolume) {
                PlayerInfo playerInfo = this.playerInfo;
                this.playerInfo = playerInfo.copyWithDeviceVolume(i11, playerInfo.deviceMuted);
                this.listeners.queueEvent(30, new ListenerSet.Event() { // from class: androidx.media3.session.o0

                    /* renamed from: b */
                    public final /* synthetic */ int f798b;

                    public /* synthetic */ o0(int i112) {
                        i11 = i112;
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.this.lambda$decreaseDeviceVolume$62(i11, (Player.Listener) obj);
                    }
                });
                this.listeners.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void increaseDeviceVolume(int i10) {
        if (isPlayerCommandAvailable(34)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.m3

                /* renamed from: b */
                public final /* synthetic */ int f738b;

                public /* synthetic */ m3(int i102) {
                    i10 = i102;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i11) {
                    MediaControllerImplBase.this.lambda$increaseDeviceVolume$57(i10, iMediaSession, i11);
                }
            });
            int i11 = this.playerInfo.deviceVolume + 1;
            int i12 = getDeviceInfo().maxVolume;
            if (i12 == 0 || i11 <= i12) {
                PlayerInfo playerInfo = this.playerInfo;
                this.playerInfo = playerInfo.copyWithDeviceVolume(i11, playerInfo.deviceMuted);
                this.listeners.queueEvent(30, new ListenerSet.Event() { // from class: androidx.media3.session.n3

                    /* renamed from: b */
                    public final /* synthetic */ int f769b;

                    public /* synthetic */ n3(int i112) {
                        i11 = i112;
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.this.lambda$increaseDeviceVolume$58(i11, (Player.Listener) obj);
                    }
                });
                this.listeners.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setDeviceVolume(int i10, int i11) {
        if (isPlayerCommandAvailable(33)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.i2

                /* renamed from: b */
                public final /* synthetic */ int f618b;

                /* renamed from: c */
                public final /* synthetic */ int f619c;

                public /* synthetic */ i2(int i102, int i112) {
                    i10 = i102;
                    i11 = i112;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i12) {
                    MediaControllerImplBase.this.lambda$setDeviceVolume$53(i10, i11, iMediaSession, i12);
                }
            });
            DeviceInfo deviceInfo = getDeviceInfo();
            PlayerInfo playerInfo = this.playerInfo;
            if (playerInfo.deviceVolume == i102 || deviceInfo.minVolume > i102) {
                return;
            }
            int i12 = deviceInfo.maxVolume;
            if (i12 == 0 || i102 <= i12) {
                this.playerInfo = playerInfo.copyWithDeviceVolume(i102, playerInfo.deviceMuted);
                this.listeners.queueEvent(30, new ListenerSet.Event() { // from class: androidx.media3.session.j2

                    /* renamed from: b */
                    public final /* synthetic */ int f644b;

                    public /* synthetic */ j2(int i102) {
                        i10 = i102;
                    }

                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        MediaControllerImplBase.this.lambda$setDeviceVolume$54(i10, (Player.Listener) obj);
                    }
                });
                this.listeners.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setMediaItem(MediaItem mediaItem, boolean z10) {
        if (isPlayerCommandAvailable(31)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.y

                /* renamed from: b */
                public final /* synthetic */ MediaItem f1034b;

                /* renamed from: c */
                public final /* synthetic */ boolean f1035c;

                public /* synthetic */ y(MediaItem mediaItem2, boolean z102) {
                    mediaItem = mediaItem2;
                    z10 = z102;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i10) {
                    MediaControllerImplBase.this.lambda$setMediaItem$24(mediaItem, z10, iMediaSession, i10);
                }
            });
            setMediaItemsInternal(Collections.singletonList(mediaItem2), -1, C.TIME_UNSET, z102);
        }
    }
}
