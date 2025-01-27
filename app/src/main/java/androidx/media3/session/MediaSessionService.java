package androidx.media3.session;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.view.KeyEvent;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaSessionManager;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.session.DefaultMediaNotificationProvider;
import androidx.media3.session.IMediaSessionService;
import androidx.media3.session.MediaNotification;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class MediaSessionService extends Service {
    public static final String SERVICE_INTERFACE = "androidx.media3.session.MediaSessionService";
    private static final String TAG = "MSSImpl";

    @GuardedBy("lock")
    private DefaultActionFactory actionFactory;

    @Nullable
    @GuardedBy("lock")
    private Listener listener;

    @GuardedBy("lock")
    private MediaNotificationManager mediaNotificationManager;

    @GuardedBy("lock")
    private MediaNotification.Provider mediaNotificationProvider;

    @Nullable
    @GuardedBy("lock")
    private MediaSessionServiceStub stub;
    private final Object lock = new Object();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    @GuardedBy("lock")
    private final Map<String, MediaSession> sessions = new ArrayMap();
    private boolean defaultMethodCalled = false;

    @RequiresApi(31)
    public static final class Api31 {
        private Api31() {
        }

        @DoNotInline
        public static boolean instanceOfForegroundServiceStartNotAllowedException(IllegalStateException illegalStateException) {
            return p0.n.a(illegalStateException);
        }
    }

    @UnstableApi
    public interface Listener {
        @RequiresApi(31)
        void onForegroundServiceStartNotAllowedException();
    }

    public final class MediaSessionListener implements MediaSession.Listener {
        private MediaSessionListener() {
        }

        @Override // androidx.media3.session.MediaSession.Listener
        public void onNotificationRefreshRequired(MediaSession mediaSession) {
            MediaSessionService.this.onUpdateNotificationInternal(mediaSession, false);
        }

        @Override // androidx.media3.session.MediaSession.Listener
        public boolean onPlayRequested(MediaSession mediaSession) {
            int i10 = Util.SDK_INT;
            if (i10 < 31 || i10 >= 33 || MediaSessionService.this.getMediaNotificationManager().isStartedInForeground()) {
                return true;
            }
            return MediaSessionService.this.onUpdateNotificationInternal(mediaSession, true);
        }

        public /* synthetic */ MediaSessionListener(MediaSessionService mediaSessionService, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static final class MediaSessionServiceStub extends IMediaSessionService.Stub {
        private final Handler handler;
        private final MediaSessionManager mediaSessionManager;
        private final Set<IMediaController> pendingControllers;
        private final WeakReference<MediaSessionService> serviceReference;

        public MediaSessionServiceStub(MediaSessionService mediaSessionService) {
            this.serviceReference = new WeakReference<>(mediaSessionService);
            Context applicationContext = mediaSessionService.getApplicationContext();
            this.handler = new Handler(applicationContext.getMainLooper());
            this.mediaSessionManager = MediaSessionManager.getSessionManager(applicationContext);
            this.pendingControllers = Collections.synchronizedSet(new HashSet());
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public /* synthetic */ void lambda$connect$0(androidx.media3.session.IMediaController r20, androidx.media.MediaSessionManager.RemoteUserInfo r21, androidx.media3.session.ConnectionRequest r22, boolean r23, int r24, int r25) {
            /*
                r19 = this;
                r1 = r19
                r10 = r20
                r0 = r22
                java.util.Set<androidx.media3.session.IMediaController> r2 = r1.pendingControllers
                r2.remove(r10)
                r11 = 0
                r2 = 1
                java.lang.ref.WeakReference<androidx.media3.session.MediaSessionService> r3 = r1.serviceReference     // Catch: java.lang.Throwable -> L59
                java.lang.Object r3 = r3.get()     // Catch: java.lang.Throwable -> L59
                androidx.media3.session.MediaSessionService r3 = (androidx.media3.session.MediaSessionService) r3     // Catch: java.lang.Throwable -> L59
                if (r3 != 0) goto L1b
                r10.onDisconnected(r11)     // Catch: android.os.RemoteException -> L1a
            L1a:
                return
            L1b:
                androidx.media3.session.MediaSession$ControllerInfo r4 = new androidx.media3.session.MediaSession$ControllerInfo     // Catch: java.lang.Throwable -> L59
                int r14 = r0.libraryVersion     // Catch: java.lang.Throwable -> L59
                int r15 = r0.controllerInterfaceVersion     // Catch: java.lang.Throwable -> L59
                android.os.Bundle r5 = r0.connectionHints     // Catch: java.lang.Throwable -> L59
                r17 = 0
                r12 = r4
                r13 = r21
                r16 = r23
                r18 = r5
                r12.<init>(r13, r14, r15, r16, r17, r18)     // Catch: java.lang.Throwable -> L59
                androidx.media3.session.MediaSession r4 = r3.onGetSession(r4)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
                if (r4 != 0) goto L39
                r10.onDisconnected(r11)     // Catch: android.os.RemoteException -> L38
            L38:
                return
            L39:
                r3.addSession(r4)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
                int r5 = r0.libraryVersion     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
                int r6 = r0.controllerInterfaceVersion     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
                java.lang.String r7 = r0.packageName     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
                android.os.Bundle r9 = r0.connectionHints     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
                r2 = r4
                r3 = r20
                r4 = r5
                r5 = r6
                r6 = r7
                r7 = r24
                r8 = r25
                r2.handleControllerConnectionFromService(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
                r2 = 0
                goto L63
            L53:
                r0 = move-exception
                r2 = 0
                goto L69
            L56:
                r0 = move-exception
                r2 = 0
                goto L5c
            L59:
                r0 = move-exception
                goto L69
            L5b:
                r0 = move-exception
            L5c:
                java.lang.String r3 = "MSSImpl"
                java.lang.String r4 = "Failed to add a session to session service"
                androidx.media3.common.util.Log.w(r3, r4, r0)     // Catch: java.lang.Throwable -> L59
            L63:
                if (r2 == 0) goto L68
                r10.onDisconnected(r11)     // Catch: android.os.RemoteException -> L68
            L68:
                return
            L69:
                if (r2 == 0) goto L6e
                r10.onDisconnected(r11)     // Catch: android.os.RemoteException -> L6e
            L6e:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.MediaSessionService.MediaSessionServiceStub.lambda$connect$0(androidx.media3.session.IMediaController, androidx.media.MediaSessionManager$RemoteUserInfo, androidx.media3.session.ConnectionRequest, boolean, int, int):void");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: androidx.media3.session.ma.<init>(androidx.media3.session.MediaSessionService$MediaSessionServiceStub, androidx.media3.session.IMediaController, androidx.media.MediaSessionManager$RemoteUserInfo, androidx.media3.session.ConnectionRequest, boolean, int, int):void, class status: GENERATED_AND_UNLOADED
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
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
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
        @Override // androidx.media3.session.IMediaSessionService
        public void connect(@androidx.annotation.Nullable androidx.media3.session.IMediaController r12, @androidx.annotation.Nullable android.os.Bundle r13) {
            /*
                r11 = this;
                if (r12 == 0) goto L5e
                if (r13 != 0) goto L5
                goto L5e
            L5:
                androidx.media3.common.Bundleable$Creator<androidx.media3.session.ConnectionRequest> r0 = androidx.media3.session.ConnectionRequest.CREATOR     // Catch: java.lang.RuntimeException -> L56
                androidx.media3.common.Bundleable r13 = r0.fromBundle(r13)     // Catch: java.lang.RuntimeException -> L56
                r4 = r13
                androidx.media3.session.ConnectionRequest r4 = (androidx.media3.session.ConnectionRequest) r4     // Catch: java.lang.RuntimeException -> L56
                java.lang.ref.WeakReference<androidx.media3.session.MediaSessionService> r13 = r11.serviceReference
                java.lang.Object r13 = r13.get()
                if (r13 != 0) goto L1b
                r13 = 0
                r12.onDisconnected(r13)     // Catch: android.os.RemoteException -> L1a
            L1a:
                return
            L1b:
                int r13 = android.os.Binder.getCallingPid()
                int r7 = android.os.Binder.getCallingUid()
                long r8 = android.os.Binder.clearCallingIdentity()
                if (r13 == 0) goto L2b
            L29:
                r6 = r13
                goto L2e
            L2b:
                int r13 = r4.pid
                goto L29
            L2e:
                androidx.media.MediaSessionManager$RemoteUserInfo r3 = new androidx.media.MediaSessionManager$RemoteUserInfo
                java.lang.String r13 = r4.packageName
                r3.<init>(r13, r6, r7)
                androidx.media.MediaSessionManager r13 = r11.mediaSessionManager
                boolean r5 = r13.isTrustedForMediaControl(r3)
                java.util.Set<androidx.media3.session.IMediaController> r13 = r11.pendingControllers
                r13.add(r12)
                android.os.Handler r13 = r11.handler     // Catch: java.lang.Throwable -> L51
                androidx.media3.session.ma r10 = new androidx.media3.session.ma     // Catch: java.lang.Throwable -> L51
                r0 = r10
                r1 = r11
                r2 = r12
                r0.<init>()     // Catch: java.lang.Throwable -> L51
                r13.post(r10)     // Catch: java.lang.Throwable -> L51
                android.os.Binder.restoreCallingIdentity(r8)
                return
            L51:
                r12 = move-exception
                android.os.Binder.restoreCallingIdentity(r8)
                throw r12
            L56:
                r12 = move-exception
                java.lang.String r13 = "MSSImpl"
                java.lang.String r0 = "Ignoring malformed Bundle for ConnectionRequest"
                androidx.media3.common.util.Log.w(r13, r0, r12)
            L5e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.MediaSessionService.MediaSessionServiceStub.connect(androidx.media3.session.IMediaController, android.os.Bundle):void");
        }

        public void release() {
            this.serviceReference.clear();
            this.handler.removeCallbacksAndMessages(null);
            Iterator<IMediaController> it = this.pendingControllers.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onDisconnected(0);
                } catch (RemoteException unused) {
                }
            }
        }
    }

    private DefaultActionFactory getActionFactory() {
        DefaultActionFactory defaultActionFactory;
        synchronized (this.lock) {
            try {
                if (this.actionFactory == null) {
                    this.actionFactory = new DefaultActionFactory(this);
                }
                defaultActionFactory = this.actionFactory;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return defaultActionFactory;
    }

    @Nullable
    private Listener getListener() {
        Listener listener;
        synchronized (this.lock) {
            listener = this.listener;
        }
        return listener;
    }

    public MediaNotificationManager getMediaNotificationManager() {
        MediaNotificationManager mediaNotificationManager;
        synchronized (this.lock) {
            try {
                if (this.mediaNotificationManager == null) {
                    if (this.mediaNotificationProvider == null) {
                        this.mediaNotificationProvider = new DefaultMediaNotificationProvider.Builder(getApplicationContext()).build();
                    }
                    this.mediaNotificationManager = new MediaNotificationManager(this, this.mediaNotificationProvider, getActionFactory());
                }
                mediaNotificationManager = this.mediaNotificationManager;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return mediaNotificationManager;
    }

    public /* synthetic */ void lambda$addSession$0(MediaNotificationManager mediaNotificationManager, MediaSession mediaSession) {
        mediaNotificationManager.addSession(mediaSession);
        mediaSession.setListener(new MediaSessionListener());
    }

    public /* synthetic */ void lambda$onForegroundServiceStartNotAllowedException$2() {
        Listener listener = getListener();
        if (listener != null) {
            listener.onForegroundServiceStartNotAllowedException();
        }
    }

    public static /* synthetic */ void lambda$removeSession$1(MediaNotificationManager mediaNotificationManager, MediaSession mediaSession) {
        mediaNotificationManager.removeSession(mediaSession);
        mediaSession.clearListener();
    }

    @RequiresApi(31)
    private void onForegroundServiceStartNotAllowedException() {
        this.mainHandler.post(new Runnable() { // from class: p0.z
            public /* synthetic */ z() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionService.this.lambda$onForegroundServiceStartNotAllowedException$2();
            }
        });
    }

    public final void addSession(MediaSession mediaSession) {
        MediaSession mediaSession2;
        Assertions.checkNotNull(mediaSession, "session must not be null");
        boolean z10 = true;
        Assertions.checkArgument(!mediaSession.isReleased(), "session is already released");
        synchronized (this.lock) {
            mediaSession2 = this.sessions.get(mediaSession.getId());
            if (mediaSession2 != null && mediaSession2 != mediaSession) {
                z10 = false;
            }
            Assertions.checkArgument(z10, "Session ID should be unique");
            this.sessions.put(mediaSession.getId(), mediaSession);
        }
        if (mediaSession2 == null) {
            Util.postOrRun(this.mainHandler, new Runnable() { // from class: androidx.media3.session.la

                /* renamed from: c */
                public final /* synthetic */ MediaNotificationManager f724c;

                /* renamed from: d */
                public final /* synthetic */ MediaSession f725d;

                public /* synthetic */ la(MediaNotificationManager mediaNotificationManager, MediaSession mediaSession3) {
                    mediaNotificationManager = mediaNotificationManager;
                    mediaSession = mediaSession3;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MediaSessionService.this.lambda$addSession$0(mediaNotificationManager, mediaSession);
                }
            });
        }
    }

    @UnstableApi
    public final void clearListener() {
        synchronized (this.lock) {
            this.listener = null;
        }
    }

    public IBinder getServiceBinder() {
        IBinder asBinder;
        synchronized (this.lock) {
            asBinder = ((MediaSessionServiceStub) Assertions.checkStateNotNull(this.stub)).asBinder();
        }
        return asBinder;
    }

    public final List<MediaSession> getSessions() {
        ArrayList arrayList;
        synchronized (this.lock) {
            arrayList = new ArrayList(this.sessions.values());
        }
        return arrayList;
    }

    public final boolean isSessionAdded(MediaSession mediaSession) {
        boolean containsKey;
        synchronized (this.lock) {
            containsKey = this.sessions.containsKey(mediaSession.getId());
        }
        return containsKey;
    }

    @Override // android.app.Service
    @Nullable
    @CallSuper
    public IBinder onBind(@Nullable Intent intent) {
        String action;
        MediaSession onGetSession;
        if (intent == null || (action = intent.getAction()) == null) {
            return null;
        }
        if (action.equals(SERVICE_INTERFACE)) {
            return getServiceBinder();
        }
        if (!action.equals(MediaBrowserServiceCompat.SERVICE_INTERFACE) || (onGetSession = onGetSession(MediaSession.ControllerInfo.createLegacyControllerInfo())) == null) {
            return null;
        }
        addSession(onGetSession);
        return onGetSession.getLegacyBrowserServiceBinder();
    }

    @Override // android.app.Service
    @CallSuper
    public void onCreate() {
        super.onCreate();
        synchronized (this.lock) {
            this.stub = new MediaSessionServiceStub(this);
        }
    }

    @Override // android.app.Service
    @CallSuper
    public void onDestroy() {
        super.onDestroy();
        synchronized (this.lock) {
            try {
                MediaSessionServiceStub mediaSessionServiceStub = this.stub;
                if (mediaSessionServiceStub != null) {
                    mediaSessionServiceStub.release();
                    this.stub = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Nullable
    public abstract MediaSession onGetSession(MediaSession.ControllerInfo controllerInfo);

    @Override // android.app.Service
    @CallSuper
    public int onStartCommand(@Nullable Intent intent, int i10, int i11) {
        String customAction;
        if (intent == null) {
            return 1;
        }
        DefaultActionFactory actionFactory = getActionFactory();
        Uri data = intent.getData();
        MediaSession session = data != null ? MediaSession.getSession(data) : null;
        if (actionFactory.isMediaAction(intent)) {
            if (session == null) {
                session = onGetSession(MediaSession.ControllerInfo.createLegacyControllerInfo());
                if (session == null) {
                    return 1;
                }
                addSession(session);
            }
            KeyEvent keyEvent = actionFactory.getKeyEvent(intent);
            if (keyEvent != null) {
                session.getSessionCompat().getController().dispatchMediaButtonEvent(keyEvent);
            }
        } else {
            if (session == null || !actionFactory.isCustomAction(intent) || (customAction = actionFactory.getCustomAction(intent)) == null) {
                return 1;
            }
            getMediaNotificationManager().onCustomAction(session, customAction, actionFactory.getCustomActionExtras(intent));
        }
        return 1;
    }

    @Deprecated
    public void onUpdateNotification(MediaSession mediaSession) {
        this.defaultMethodCalled = true;
    }

    public boolean onUpdateNotificationInternal(MediaSession mediaSession, boolean z10) {
        try {
            onUpdateNotification(mediaSession, getMediaNotificationManager().shouldRunInForeground(mediaSession, z10));
            return true;
        } catch (IllegalStateException e10) {
            if (Util.SDK_INT < 31 || !Api31.instanceOfForegroundServiceStartNotAllowedException(e10)) {
                throw e10;
            }
            Log.e(TAG, "Failed to start foreground", e10);
            onForegroundServiceStartNotAllowedException();
            return false;
        }
    }

    public final void removeSession(MediaSession mediaSession) {
        Assertions.checkNotNull(mediaSession, "session must not be null");
        synchronized (this.lock) {
            Assertions.checkArgument(this.sessions.containsKey(mediaSession.getId()), "session not found");
            this.sessions.remove(mediaSession.getId());
        }
        Util.postOrRun(this.mainHandler, new Runnable() { // from class: androidx.media3.session.ka

            /* renamed from: c */
            public final /* synthetic */ MediaSession f698c;

            public /* synthetic */ ka(MediaSession mediaSession2) {
                mediaSession = mediaSession2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionService.lambda$removeSession$1(MediaNotificationManager.this, mediaSession);
            }
        });
    }

    @UnstableApi
    public final void setListener(Listener listener) {
        synchronized (this.lock) {
            this.listener = listener;
        }
    }

    @UnstableApi
    public final void setMediaNotificationProvider(MediaNotification.Provider provider) {
        Assertions.checkNotNull(provider);
        synchronized (this.lock) {
            this.mediaNotificationProvider = provider;
        }
    }

    public void onUpdateNotification(MediaSession mediaSession, boolean z10) {
        onUpdateNotification(mediaSession);
        if (this.defaultMethodCalled) {
            getMediaNotificationManager().updateNotification(mediaSession, z10);
        }
    }
}
