package androidx.media3.session;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.Nullable;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaSessionManager;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaSession;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
class MediaSessionServiceLegacyStub extends MediaBrowserServiceCompat {
    private static final String TAG = "MSSLegacyStub";
    private final ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> connectedControllersManager;
    private final MediaSessionManager manager;
    private final MediaSessionImpl sessionImpl;

    public MediaSessionServiceLegacyStub(MediaSessionImpl mediaSessionImpl) {
        this.manager = MediaSessionManager.getSessionManager(mediaSessionImpl.getContext());
        this.sessionImpl = mediaSessionImpl;
        this.connectedControllersManager = new ConnectedControllersManager<>(mediaSessionImpl);
    }

    public /* synthetic */ void lambda$onGetRoot$0(AtomicReference atomicReference, MediaSession.ControllerInfo controllerInfo, ConditionVariable conditionVariable) {
        atomicReference.set(this.sessionImpl.onConnectOnHandler(controllerInfo));
        conditionVariable.open();
    }

    public MediaSession.ControllerInfo createControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo, Bundle bundle) {
        return new MediaSession.ControllerInfo(remoteUserInfo, 0, 0, this.manager.isTrustedForMediaControl(remoteUserInfo), null, bundle);
    }

    public final ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> getConnectedControllersManager() {
        return this.connectedControllersManager;
    }

    public final MediaSessionManager getMediaSessionManager() {
        return this.manager;
    }

    public void initialize(MediaSessionCompat.Token token) {
        attachToBaseContext(this.sessionImpl.getContext());
        onCreate();
        setSessionToken(token);
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    @Nullable
    public MediaBrowserServiceCompat.BrowserRoot onGetRoot(String str, int i10, @Nullable Bundle bundle) {
        MediaSessionManager.RemoteUserInfo currentBrowserInfo = getCurrentBrowserInfo();
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        MediaSession.ControllerInfo createControllerInfo = createControllerInfo(currentBrowserInfo, bundle);
        AtomicReference atomicReference = new AtomicReference();
        ConditionVariable conditionVariable = new ConditionVariable();
        Util.postOrRun(this.sessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.na

            /* renamed from: c */
            public final /* synthetic */ AtomicReference f785c;

            /* renamed from: d */
            public final /* synthetic */ MediaSession.ControllerInfo f786d;

            /* renamed from: e */
            public final /* synthetic */ ConditionVariable f787e;

            public /* synthetic */ na(AtomicReference atomicReference2, MediaSession.ControllerInfo createControllerInfo2, ConditionVariable conditionVariable2) {
                atomicReference = atomicReference2;
                createControllerInfo = createControllerInfo2;
                conditionVariable = conditionVariable2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionServiceLegacyStub.this.lambda$onGetRoot$0(atomicReference, createControllerInfo, conditionVariable);
            }
        });
        try {
            conditionVariable2.block();
            MediaSession.ConnectionResult connectionResult = (MediaSession.ConnectionResult) atomicReference2.get();
            if (!connectionResult.isAccepted) {
                return null;
            }
            this.connectedControllersManager.addController(currentBrowserInfo, createControllerInfo2, connectionResult.availableSessionCommands, connectionResult.availablePlayerCommands);
            return MediaUtils.defaultBrowserRoot;
        } catch (InterruptedException e10) {
            Log.e(TAG, "Couldn't get a result from onConnect", e10);
            return null;
        }
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onLoadChildren(String str, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
        result.sendResult(null);
    }
}
