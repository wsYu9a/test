package androidx.media3.session;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.common.Player;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.IMediaController;
import androidx.media3.session.MediaControllerStub;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.PlayerInfo;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
class MediaControllerStub extends IMediaController.Stub {
    private static final String TAG = "MediaControllerStub";
    public static final int VERSION_INT = 3;
    private final WeakReference<MediaControllerImplBase> controller;

    public interface ControllerTask<T extends MediaControllerImplBase> {
        void run(T t10);
    }

    public MediaControllerStub(MediaControllerImplBase mediaControllerImplBase) {
        this.controller = new WeakReference<>(mediaControllerImplBase);
    }

    private <T extends MediaControllerImplBase> void dispatchControllerTaskOnHandler(ControllerTask<T> controllerTask) {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaControllerImplBase mediaControllerImplBase = this.controller.get();
            if (mediaControllerImplBase == null) {
                return;
            }
            Util.postOrRun(mediaControllerImplBase.getInstance().applicationHandler, new Runnable() { // from class: androidx.media3.session.q5

                /* renamed from: c */
                public final /* synthetic */ MediaControllerStub.ControllerTask f852c;

                public /* synthetic */ q5(MediaControllerStub.ControllerTask controllerTask2) {
                    controllerTask = controllerTask2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MediaControllerStub.lambda$dispatchControllerTaskOnHandler$12(MediaControllerImplBase.this, controllerTask);
                }
            });
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    public static /* synthetic */ void lambda$dispatchControllerTaskOnHandler$12(MediaControllerImplBase mediaControllerImplBase, ControllerTask controllerTask) {
        if (mediaControllerImplBase.isReleased()) {
            return;
        }
        controllerTask.run(mediaControllerImplBase);
    }

    public static /* synthetic */ void lambda$onChildrenChanged$11(String str, int i10, Bundle bundle, MediaBrowserImplBase mediaBrowserImplBase) {
        mediaBrowserImplBase.notifyChildrenChanged(str, i10, bundle == null ? null : MediaLibraryService.LibraryParams.CREATOR.fromBundle(bundle));
    }

    public static /* synthetic */ void lambda$onDisconnected$1(MediaControllerImplBase mediaControllerImplBase) {
        MediaController mediaControllerImplBase2 = mediaControllerImplBase.getInstance();
        MediaController mediaControllerImplBase3 = mediaControllerImplBase.getInstance();
        Objects.requireNonNull(mediaControllerImplBase3);
        mediaControllerImplBase2.runOnApplicationLooper(new p0.q(mediaControllerImplBase3));
    }

    public static /* synthetic */ void lambda$onSearchResultChanged$10(String str, int i10, Bundle bundle, MediaBrowserImplBase mediaBrowserImplBase) {
        mediaBrowserImplBase.notifySearchResultChanged(str, i10, bundle == null ? null : MediaLibraryService.LibraryParams.CREATOR.fromBundle(bundle));
    }

    private <T> void setControllerFutureResult(int i10, T t10) {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaControllerImplBase mediaControllerImplBase = this.controller.get();
            if (mediaControllerImplBase == null) {
                return;
            }
            mediaControllerImplBase.setFutureResult(i10, t10);
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    public void destroy() {
        this.controller.clear();
    }

    @Override // androidx.media3.session.IMediaController
    public void onAvailableCommandsChangedFromPlayer(int i10, Bundle bundle) {
        try {
            dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.o5
                public /* synthetic */ o5() {
                }

                @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                public final void run(MediaControllerImplBase mediaControllerImplBase) {
                    mediaControllerImplBase.onAvailableCommandsChangedFromPlayer(Player.Commands.this);
                }
            });
        } catch (RuntimeException e10) {
            Log.w(TAG, "Ignoring malformed Bundle for Commands", e10);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onAvailableCommandsChangedFromSession(int i10, Bundle bundle, Bundle bundle2) {
        try {
            try {
                dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.r5

                    /* renamed from: b */
                    public final /* synthetic */ Player.Commands f871b;

                    public /* synthetic */ r5(Player.Commands commands) {
                        fromBundle2 = commands;
                    }

                    @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                    public final void run(MediaControllerImplBase mediaControllerImplBase) {
                        mediaControllerImplBase.onAvailableCommandsChangedFromSession(SessionCommands.this, fromBundle2);
                    }
                });
            } catch (RuntimeException e10) {
                Log.w(TAG, "Ignoring malformed Bundle for Commands", e10);
            }
        } catch (RuntimeException e11) {
            Log.w(TAG, "Ignoring malformed Bundle for SessionCommands", e11);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onChildrenChanged(int i10, String str, int i11, @Nullable Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "onChildrenChanged(): Ignoring empty parentId");
            return;
        }
        if (i11 >= 0) {
            dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.t5

                /* renamed from: a */
                public final /* synthetic */ String f916a;

                /* renamed from: b */
                public final /* synthetic */ int f917b;

                /* renamed from: c */
                public final /* synthetic */ Bundle f918c;

                public /* synthetic */ t5(String str2, int i112, Bundle bundle2) {
                    str = str2;
                    i11 = i112;
                    bundle = bundle2;
                }

                @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                public final void run(MediaControllerImplBase mediaControllerImplBase) {
                    MediaControllerStub.lambda$onChildrenChanged$11(str, i11, bundle, (MediaBrowserImplBase) mediaControllerImplBase);
                }
            });
            return;
        }
        Log.w(TAG, "onChildrenChanged(): Ignoring negative itemCount: " + i112);
    }

    @Override // androidx.media3.session.IMediaController
    public void onConnected(int i10, Bundle bundle) {
        try {
            dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.x5
                public /* synthetic */ x5() {
                }

                @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                public final void run(MediaControllerImplBase mediaControllerImplBase) {
                    mediaControllerImplBase.onConnected(ConnectionState.this);
                }
            });
        } catch (RuntimeException e10) {
            Log.w(TAG, "Malformed Bundle for ConnectionResult. Disconnected from the session.", e10);
            onDisconnected(i10);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onCustomCommand(int i10, Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            Log.w(TAG, "Ignoring custom command with null args.");
            return;
        }
        try {
            dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.v5

                /* renamed from: a */
                public final /* synthetic */ int f975a;

                /* renamed from: b */
                public final /* synthetic */ SessionCommand f976b;

                /* renamed from: c */
                public final /* synthetic */ Bundle f977c;

                public /* synthetic */ v5(int i102, SessionCommand sessionCommand, Bundle bundle22) {
                    i10 = i102;
                    fromBundle = sessionCommand;
                    bundle2 = bundle22;
                }

                @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                public final void run(MediaControllerImplBase mediaControllerImplBase) {
                    mediaControllerImplBase.onCustomCommand(i10, fromBundle, bundle2);
                }
            });
        } catch (RuntimeException e10) {
            Log.w(TAG, "Ignoring malformed Bundle for SessionCommand", e10);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onDisconnected(int i10) {
        dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.s5
            @Override // androidx.media3.session.MediaControllerStub.ControllerTask
            public final void run(MediaControllerImplBase mediaControllerImplBase) {
                MediaControllerStub.lambda$onDisconnected$1(mediaControllerImplBase);
            }
        });
    }

    @Override // androidx.media3.session.IMediaController
    public void onExtrasChanged(int i10, Bundle bundle) {
        dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.w5

            /* renamed from: a */
            public final /* synthetic */ Bundle f998a;

            public /* synthetic */ w5(Bundle bundle2) {
                bundle = bundle2;
            }

            @Override // androidx.media3.session.MediaControllerStub.ControllerTask
            public final void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.onExtrasChanged(bundle);
            }
        });
    }

    @Override // androidx.media3.session.IMediaController
    public void onLibraryResult(int i10, Bundle bundle) {
        try {
            setControllerFutureResult(i10, LibraryResult.UNKNOWN_TYPE_CREATOR.fromBundle(bundle));
        } catch (RuntimeException e10) {
            Log.w(TAG, "Ignoring malformed Bundle for LibraryResult", e10);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onPeriodicSessionPositionInfoChanged(int i10, Bundle bundle) {
        try {
            dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.y5
                public /* synthetic */ y5() {
                }

                @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                public final void run(MediaControllerImplBase mediaControllerImplBase) {
                    mediaControllerImplBase.notifyPeriodicSessionPositionInfoChanged(SessionPositionInfo.this);
                }
            });
        } catch (RuntimeException e10) {
            Log.w(TAG, "Ignoring malformed Bundle for SessionPositionInfo", e10);
        }
    }

    @Override // androidx.media3.session.IMediaController
    @Deprecated
    public void onPlayerInfoChanged(int i10, Bundle bundle, boolean z10) {
        onPlayerInfoChangedWithExclusions(i10, bundle, new PlayerInfo.BundlingExclusions(z10, true).toBundle());
    }

    @Override // androidx.media3.session.IMediaController
    public void onPlayerInfoChangedWithExclusions(int i10, Bundle bundle, Bundle bundle2) {
        try {
            try {
                dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.p5

                    /* renamed from: b */
                    public final /* synthetic */ PlayerInfo.BundlingExclusions f828b;

                    public /* synthetic */ p5(PlayerInfo.BundlingExclusions bundlingExclusions) {
                        fromBundle2 = bundlingExclusions;
                    }

                    @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                    public final void run(MediaControllerImplBase mediaControllerImplBase) {
                        mediaControllerImplBase.onPlayerInfoChanged(PlayerInfo.this, fromBundle2);
                    }
                });
            } catch (RuntimeException e10) {
                Log.w(TAG, "Ignoring malformed Bundle for BundlingExclusions", e10);
            }
        } catch (RuntimeException e11) {
            Log.w(TAG, "Ignoring malformed Bundle for PlayerInfo", e11);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onRenderedFirstFrame(int i10) {
        dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.m5
            @Override // androidx.media3.session.MediaControllerStub.ControllerTask
            public final void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.onRenderedFirstFrame();
            }
        });
    }

    @Override // androidx.media3.session.IMediaController
    public void onSearchResultChanged(int i10, String str, int i11, @Nullable Bundle bundle) throws RuntimeException {
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "onSearchResultChanged(): Ignoring empty query");
            return;
        }
        if (i11 >= 0) {
            dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.n5

                /* renamed from: a */
                public final /* synthetic */ String f771a;

                /* renamed from: b */
                public final /* synthetic */ int f772b;

                /* renamed from: c */
                public final /* synthetic */ Bundle f773c;

                public /* synthetic */ n5(String str2, int i112, Bundle bundle2) {
                    str = str2;
                    i11 = i112;
                    bundle = bundle2;
                }

                @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                public final void run(MediaControllerImplBase mediaControllerImplBase) {
                    MediaControllerStub.lambda$onSearchResultChanged$10(str, i11, bundle, (MediaBrowserImplBase) mediaControllerImplBase);
                }
            });
            return;
        }
        Log.w(TAG, "onSearchResultChanged(): Ignoring negative itemCount: " + i112);
    }

    @Override // androidx.media3.session.IMediaController
    public void onSessionActivityChanged(int i10, PendingIntent pendingIntent) throws RemoteException {
        dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.u5

            /* renamed from: a */
            public final /* synthetic */ int f945a;

            /* renamed from: b */
            public final /* synthetic */ PendingIntent f946b;

            public /* synthetic */ u5(int i102, PendingIntent pendingIntent2) {
                i10 = i102;
                pendingIntent = pendingIntent2;
            }

            @Override // androidx.media3.session.MediaControllerStub.ControllerTask
            public final void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.onSetSessionActivity(i10, pendingIntent);
            }
        });
    }

    @Override // androidx.media3.session.IMediaController
    public void onSessionResult(int i10, Bundle bundle) {
        try {
            setControllerFutureResult(i10, SessionResult.CREATOR.fromBundle(bundle));
        } catch (RuntimeException e10) {
            Log.w(TAG, "Ignoring malformed Bundle for SessionResult", e10);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onSetCustomLayout(int i10, List<Bundle> list) {
        try {
            dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.z5

                /* renamed from: a */
                public final /* synthetic */ int f1071a;

                /* renamed from: b */
                public final /* synthetic */ List f1072b;

                public /* synthetic */ z5(int i102, List list2) {
                    i10 = i102;
                    fromBundleList = list2;
                }

                @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                public final void run(MediaControllerImplBase mediaControllerImplBase) {
                    mediaControllerImplBase.onSetCustomLayout(i10, fromBundleList);
                }
            });
        } catch (RuntimeException e10) {
            Log.w(TAG, "Ignoring malformed Bundle for CommandButton", e10);
        }
    }
}
