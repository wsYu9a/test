package androidx.media3.session;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.session.ConnectedControllersManager;
import androidx.media3.session.MediaSession;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
final class ConnectedControllersManager<T> {

    @GuardedBy("lock")
    private final ArrayMap<T, MediaSession.ControllerInfo> controllerInfoMap = new ArrayMap<>();

    @GuardedBy("lock")
    private final ArrayMap<MediaSession.ControllerInfo, ConnectedControllerRecord<T>> controllerRecords = new ArrayMap<>();
    private final Object lock = new Object();
    private final WeakReference<MediaSessionImpl> sessionImpl;

    public interface AsyncCommand {
        p5.c0<Void> run();
    }

    public static final class ConnectedControllerRecord<T> {
        public final Deque<AsyncCommand> commandQueue = new ArrayDeque();
        public boolean commandQueueIsFlushing;
        public final T controllerKey;
        public Player.Commands playerCommands;
        public final SequencedFutureManager sequencedFutureManager;
        public SessionCommands sessionCommands;

        public ConnectedControllerRecord(T t10, SequencedFutureManager sequencedFutureManager, SessionCommands sessionCommands, Player.Commands commands) {
            this.controllerKey = t10;
            this.sequencedFutureManager = sequencedFutureManager;
            this.sessionCommands = sessionCommands;
            this.playerCommands = commands;
        }
    }

    public ConnectedControllersManager(MediaSessionImpl mediaSessionImpl) {
        this.sessionImpl = new WeakReference<>(mediaSessionImpl);
    }

    public /* synthetic */ void lambda$flushCommandQueue$1(AtomicBoolean atomicBoolean, ConnectedControllerRecord connectedControllerRecord, AtomicBoolean atomicBoolean2) {
        synchronized (this.lock) {
            try {
                if (atomicBoolean.get()) {
                    atomicBoolean2.set(true);
                } else {
                    flushCommandQueue(connectedControllerRecord);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public /* synthetic */ void lambda$flushCommandQueue$2(AsyncCommand asyncCommand, AtomicBoolean atomicBoolean, ConnectedControllerRecord connectedControllerRecord, AtomicBoolean atomicBoolean2) {
        asyncCommand.run().addListener(new Runnable() { // from class: androidx.media3.session.b

            /* renamed from: c */
            public final /* synthetic */ AtomicBoolean f411c;

            /* renamed from: d */
            public final /* synthetic */ ConnectedControllersManager.ConnectedControllerRecord f412d;

            /* renamed from: e */
            public final /* synthetic */ AtomicBoolean f413e;

            public /* synthetic */ b(AtomicBoolean atomicBoolean3, ConnectedControllersManager.ConnectedControllerRecord connectedControllerRecord2, AtomicBoolean atomicBoolean22) {
                atomicBoolean = atomicBoolean3;
                connectedControllerRecord = connectedControllerRecord2;
                atomicBoolean2 = atomicBoolean22;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ConnectedControllersManager.this.lambda$flushCommandQueue$1(atomicBoolean, connectedControllerRecord, atomicBoolean2);
            }
        }, com.google.common.util.concurrent.p.c());
    }

    public static /* synthetic */ void lambda$removeController$0(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo) {
        if (mediaSessionImpl.isReleased()) {
            return;
        }
        mediaSessionImpl.onDisconnectedOnHandler(controllerInfo);
    }

    public void addController(T t10, MediaSession.ControllerInfo controllerInfo, SessionCommands sessionCommands, Player.Commands commands) {
        synchronized (this.lock) {
            try {
                MediaSession.ControllerInfo controller = getController(t10);
                if (controller == null) {
                    this.controllerInfoMap.put(t10, controllerInfo);
                    this.controllerRecords.put(controllerInfo, new ConnectedControllerRecord<>(t10, new SequencedFutureManager(), sessionCommands, commands));
                } else {
                    ConnectedControllerRecord connectedControllerRecord = (ConnectedControllerRecord) Assertions.checkStateNotNull(this.controllerRecords.get(controller));
                    connectedControllerRecord.sessionCommands = sessionCommands;
                    connectedControllerRecord.playerCommands = commands;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void addToCommandQueue(MediaSession.ControllerInfo controllerInfo, AsyncCommand asyncCommand) {
        synchronized (this.lock) {
            try {
                ConnectedControllerRecord<T> connectedControllerRecord = this.controllerRecords.get(controllerInfo);
                if (connectedControllerRecord != null) {
                    connectedControllerRecord.commandQueue.add(asyncCommand);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void flushCommandQueue(MediaSession.ControllerInfo controllerInfo) {
        synchronized (this.lock) {
            try {
                ConnectedControllerRecord<T> connectedControllerRecord = this.controllerRecords.get(controllerInfo);
                if (connectedControllerRecord != null && !connectedControllerRecord.commandQueueIsFlushing && !connectedControllerRecord.commandQueue.isEmpty()) {
                    connectedControllerRecord.commandQueueIsFlushing = true;
                    flushCommandQueue(connectedControllerRecord);
                }
            } finally {
            }
        }
    }

    @Nullable
    public Player.Commands getAvailablePlayerCommands(MediaSession.ControllerInfo controllerInfo) {
        synchronized (this.lock) {
            try {
                ConnectedControllerRecord<T> connectedControllerRecord = this.controllerRecords.get(controllerInfo);
                if (connectedControllerRecord == null) {
                    return null;
                }
                return connectedControllerRecord.playerCommands;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public ImmutableList<MediaSession.ControllerInfo> getConnectedControllers() {
        ImmutableList<MediaSession.ControllerInfo> copyOf;
        synchronized (this.lock) {
            copyOf = ImmutableList.copyOf((Collection) this.controllerInfoMap.values());
        }
        return copyOf;
    }

    @Nullable
    public MediaSession.ControllerInfo getController(T t10) {
        MediaSession.ControllerInfo controllerInfo;
        synchronized (this.lock) {
            controllerInfo = this.controllerInfoMap.get(t10);
        }
        return controllerInfo;
    }

    @Nullable
    public SequencedFutureManager getSequencedFutureManager(MediaSession.ControllerInfo controllerInfo) {
        ConnectedControllerRecord<T> connectedControllerRecord;
        synchronized (this.lock) {
            connectedControllerRecord = this.controllerRecords.get(controllerInfo);
        }
        if (connectedControllerRecord != null) {
            return connectedControllerRecord.sequencedFutureManager;
        }
        return null;
    }

    public boolean isConnected(MediaSession.ControllerInfo controllerInfo) {
        boolean z10;
        synchronized (this.lock) {
            z10 = this.controllerRecords.get(controllerInfo) != null;
        }
        return z10;
    }

    public boolean isPlayerCommandAvailable(MediaSession.ControllerInfo controllerInfo, int i10) {
        ConnectedControllerRecord<T> connectedControllerRecord;
        synchronized (this.lock) {
            connectedControllerRecord = this.controllerRecords.get(controllerInfo);
        }
        MediaSessionImpl mediaSessionImpl = this.sessionImpl.get();
        return connectedControllerRecord != null && connectedControllerRecord.playerCommands.contains(i10) && mediaSessionImpl != null && mediaSessionImpl.getPlayerWrapper().getAvailableCommands().contains(i10);
    }

    public boolean isSessionCommandAvailable(MediaSession.ControllerInfo controllerInfo, SessionCommand sessionCommand) {
        ConnectedControllerRecord<T> connectedControllerRecord;
        synchronized (this.lock) {
            connectedControllerRecord = this.controllerRecords.get(controllerInfo);
        }
        return connectedControllerRecord != null && connectedControllerRecord.sessionCommands.contains(sessionCommand);
    }

    public void removeController(T t10) {
        MediaSession.ControllerInfo controller = getController(t10);
        if (controller != null) {
            removeController(controller);
        }
    }

    public void updateCommandsFromSession(MediaSession.ControllerInfo controllerInfo, SessionCommands sessionCommands, Player.Commands commands) {
        synchronized (this.lock) {
            try {
                ConnectedControllerRecord<T> connectedControllerRecord = this.controllerRecords.get(controllerInfo);
                if (connectedControllerRecord != null) {
                    connectedControllerRecord.sessionCommands = sessionCommands;
                    connectedControllerRecord.playerCommands = commands;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void removeController(MediaSession.ControllerInfo controllerInfo) {
        synchronized (this.lock) {
            try {
                ConnectedControllerRecord<T> remove = this.controllerRecords.remove(controllerInfo);
                if (remove == null) {
                    return;
                }
                this.controllerInfoMap.remove(remove.controllerKey);
                remove.sequencedFutureManager.release();
                MediaSessionImpl mediaSessionImpl = this.sessionImpl.get();
                if (mediaSessionImpl == null || mediaSessionImpl.isReleased()) {
                    return;
                }
                Util.postOrRun(mediaSessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.c

                    /* renamed from: c */
                    public final /* synthetic */ MediaSession.ControllerInfo f440c;

                    public /* synthetic */ c(MediaSession.ControllerInfo controllerInfo2) {
                        controllerInfo = controllerInfo2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        ConnectedControllersManager.lambda$removeController$0(MediaSessionImpl.this, controllerInfo);
                    }
                });
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Nullable
    public SequencedFutureManager getSequencedFutureManager(T t10) {
        ConnectedControllerRecord<T> connectedControllerRecord;
        synchronized (this.lock) {
            try {
                MediaSession.ControllerInfo controller = getController(t10);
                connectedControllerRecord = controller != null ? this.controllerRecords.get(controller) : null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (connectedControllerRecord != null) {
            return connectedControllerRecord.sequencedFutureManager;
        }
        return null;
    }

    public boolean isSessionCommandAvailable(MediaSession.ControllerInfo controllerInfo, int i10) {
        ConnectedControllerRecord<T> connectedControllerRecord;
        synchronized (this.lock) {
            connectedControllerRecord = this.controllerRecords.get(controllerInfo);
        }
        return connectedControllerRecord != null && connectedControllerRecord.sessionCommands.contains(i10);
    }

    @GuardedBy("lock")
    private void flushCommandQueue(ConnectedControllerRecord<T> connectedControllerRecord) {
        MediaSessionImpl mediaSessionImpl = this.sessionImpl.get();
        if (mediaSessionImpl == null) {
            return;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        while (atomicBoolean.get()) {
            atomicBoolean.set(false);
            AsyncCommand poll = connectedControllerRecord.commandQueue.poll();
            if (poll == null) {
                connectedControllerRecord.commandQueueIsFlushing = false;
                return;
            } else {
                AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
                Util.postOrRun(mediaSessionImpl.getApplicationHandler(), mediaSessionImpl.callWithControllerForCurrentRequestSet(getController(connectedControllerRecord.controllerKey), new Runnable() { // from class: androidx.media3.session.a

                    /* renamed from: c */
                    public final /* synthetic */ ConnectedControllersManager.AsyncCommand f379c;

                    /* renamed from: d */
                    public final /* synthetic */ AtomicBoolean f380d;

                    /* renamed from: e */
                    public final /* synthetic */ ConnectedControllersManager.ConnectedControllerRecord f381e;

                    /* renamed from: f */
                    public final /* synthetic */ AtomicBoolean f382f;

                    public /* synthetic */ a(ConnectedControllersManager.AsyncCommand poll2, AtomicBoolean atomicBoolean22, ConnectedControllersManager.ConnectedControllerRecord connectedControllerRecord2, AtomicBoolean atomicBoolean3) {
                        poll = poll2;
                        atomicBoolean2 = atomicBoolean22;
                        connectedControllerRecord = connectedControllerRecord2;
                        atomicBoolean = atomicBoolean3;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        ConnectedControllersManager.this.lambda$flushCommandQueue$2(poll, atomicBoolean2, connectedControllerRecord, atomicBoolean);
                    }
                }));
                atomicBoolean22.set(false);
            }
        }
    }
}
