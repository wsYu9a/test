package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionImpl;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
class MediaLibrarySessionImpl extends MediaSessionImpl {
    private static final String RECENT_LIBRARY_ROOT_MEDIA_ID = "androidx.media3.session.recent.root";
    private static final String SYSTEM_UI_PACKAGE_NAME = "com.android.systemui";
    private final MediaLibraryService.MediaLibrarySession.Callback callback;
    private final MediaLibraryService.MediaLibrarySession instance;

    @GuardedBy("lock")
    private final ArrayMap<MediaSession.ControllerCb, Set<String>> subscriptions;

    /* renamed from: androidx.media3.session.MediaLibrarySessionImpl$1 */
    public class AnonymousClass1 implements p5.x<MediaSession.MediaItemsWithStartPosition> {
        final /* synthetic */ MediaLibraryService.LibraryParams val$params;
        final /* synthetic */ com.google.common.util.concurrent.s val$settableFuture;

        public AnonymousClass1(MediaLibrarySessionImpl mediaLibrarySessionImpl, com.google.common.util.concurrent.s sVar, MediaLibraryService.LibraryParams libraryParams) {
            n10 = sVar;
            libraryParams = libraryParams;
        }

        @Override // p5.x
        public void onFailure(Throwable th2) {
            n10.set(LibraryResult.ofError(-1, libraryParams));
            Log.e(MediaSessionImpl.TAG, "Failed fetching recent media item at boot time: " + th2.getMessage(), th2);
        }

        @Override // p5.x
        public void onSuccess(MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition) {
            if (mediaItemsWithStartPosition.mediaItems.isEmpty()) {
                n10.set(LibraryResult.ofError(-2, libraryParams));
            } else {
                n10.set(LibraryResult.ofItemList(ImmutableList.of(mediaItemsWithStartPosition.mediaItems.get(Math.max(0, Math.min(mediaItemsWithStartPosition.startIndex, mediaItemsWithStartPosition.mediaItems.size() - 1)))), libraryParams));
            }
        }
    }

    public MediaLibrarySessionImpl(MediaLibraryService.MediaLibrarySession mediaLibrarySession, Context context, String str, Player player, @Nullable PendingIntent pendingIntent, MediaLibraryService.MediaLibrarySession.Callback callback, Bundle bundle, androidx.media3.common.util.BitmapLoader bitmapLoader) {
        super(mediaLibrarySession, context, str, player, pendingIntent, callback, bundle, bitmapLoader);
        this.instance = mediaLibrarySession;
        this.callback = callback;
        this.subscriptions = new ArrayMap<>();
    }

    private p5.c0<LibraryResult<ImmutableList<MediaItem>>> getRecentMediaItemAtDeviceBootTime(MediaSession.ControllerInfo controllerInfo, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        com.google.common.util.concurrent.s n10 = com.google.common.util.concurrent.s.n();
        com.google.common.util.concurrent.l.a(this.callback.onPlaybackResumption(this.instance, controllerInfo), new p5.x<MediaSession.MediaItemsWithStartPosition>(this) { // from class: androidx.media3.session.MediaLibrarySessionImpl.1
            final /* synthetic */ MediaLibraryService.LibraryParams val$params;
            final /* synthetic */ com.google.common.util.concurrent.s val$settableFuture;

            public AnonymousClass1(MediaLibrarySessionImpl this, com.google.common.util.concurrent.s n102, MediaLibraryService.LibraryParams libraryParams2) {
                n10 = n102;
                libraryParams = libraryParams2;
            }

            @Override // p5.x
            public void onFailure(Throwable th2) {
                n10.set(LibraryResult.ofError(-1, libraryParams));
                Log.e(MediaSessionImpl.TAG, "Failed fetching recent media item at boot time: " + th2.getMessage(), th2);
            }

            @Override // p5.x
            public void onSuccess(MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition) {
                if (mediaItemsWithStartPosition.mediaItems.isEmpty()) {
                    n10.set(LibraryResult.ofError(-2, libraryParams));
                } else {
                    n10.set(LibraryResult.ofItemList(ImmutableList.of(mediaItemsWithStartPosition.mediaItems.get(Math.max(0, Math.min(mediaItemsWithStartPosition.startIndex, mediaItemsWithStartPosition.mediaItems.size() - 1)))), libraryParams));
                }
            }
        }, com.google.common.util.concurrent.p.c());
        return n102;
    }

    private boolean isSubscribed(MediaSession.ControllerCb controllerCb, String str) {
        synchronized (this.lock) {
            try {
                Set<String> set = this.subscriptions.get(controllerCb);
                if (set != null && set.contains(str)) {
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    public /* synthetic */ void lambda$notifyChildrenChanged$0(String str, int i10, MediaLibraryService.LibraryParams libraryParams, MediaSession.ControllerCb controllerCb, int i11) throws RemoteException {
        if (isSubscribed(controllerCb, str)) {
            controllerCb.onChildrenChanged(i11, str, i10, libraryParams);
        }
    }

    public /* synthetic */ void lambda$notifyChildrenChanged$1(String str, int i10, MediaLibraryService.LibraryParams libraryParams, MediaSession.ControllerCb controllerCb, int i11) throws RemoteException {
        if (isSubscribed(controllerCb, str)) {
            controllerCb.onChildrenChanged(i11, str, i10, libraryParams);
        }
    }

    public /* synthetic */ void lambda$onGetChildrenOnHandler$5(p5.c0 c0Var, int i10) {
        LibraryResult<?> libraryResult = (LibraryResult) tryGetFutureResult(c0Var);
        if (libraryResult != null) {
            maybeUpdateLegacyErrorState(libraryResult);
            verifyResultItems(libraryResult, i10);
        }
    }

    public /* synthetic */ void lambda$onGetChildrenOnHandler$6(Runnable runnable) {
        Util.postOrRun(getApplicationHandler(), runnable);
    }

    public /* synthetic */ void lambda$onGetItemOnHandler$7(p5.c0 c0Var) {
        LibraryResult<?> libraryResult = (LibraryResult) tryGetFutureResult(c0Var);
        if (libraryResult != null) {
            maybeUpdateLegacyErrorState(libraryResult);
        }
    }

    public /* synthetic */ void lambda$onGetItemOnHandler$8(Runnable runnable) {
        Util.postOrRun(getApplicationHandler(), runnable);
    }

    public /* synthetic */ void lambda$onGetLibraryRootOnHandler$3(p5.c0 c0Var) {
        LibraryResult<?> libraryResult = (LibraryResult) tryGetFutureResult(c0Var);
        if (libraryResult != null) {
            maybeUpdateLegacyErrorState(libraryResult);
        }
    }

    public /* synthetic */ void lambda$onGetLibraryRootOnHandler$4(Runnable runnable) {
        Util.postOrRun(getApplicationHandler(), runnable);
    }

    public /* synthetic */ void lambda$onGetSearchResultOnHandler$13(p5.c0 c0Var, int i10) {
        LibraryResult<?> libraryResult = (LibraryResult) tryGetFutureResult(c0Var);
        if (libraryResult != null) {
            maybeUpdateLegacyErrorState(libraryResult);
            verifyResultItems(libraryResult, i10);
        }
    }

    public /* synthetic */ void lambda$onGetSearchResultOnHandler$14(Runnable runnable) {
        Util.postOrRun(getApplicationHandler(), runnable);
    }

    public /* synthetic */ void lambda$onSearchOnHandler$11(p5.c0 c0Var) {
        LibraryResult<?> libraryResult = (LibraryResult) tryGetFutureResult(c0Var);
        if (libraryResult != null) {
            maybeUpdateLegacyErrorState(libraryResult);
        }
    }

    public /* synthetic */ void lambda$onSearchOnHandler$12(Runnable runnable) {
        Util.postOrRun(getApplicationHandler(), runnable);
    }

    public /* synthetic */ void lambda$onSubscribeOnHandler$9(p5.c0 c0Var, MediaSession.ControllerCb controllerCb, String str) {
        LibraryResult libraryResult = (LibraryResult) tryGetFutureResult(c0Var);
        if (libraryResult == null || libraryResult.resultCode != 0) {
            removeSubscription(controllerCb, str);
        }
    }

    public /* synthetic */ void lambda$onUnsubscribeOnHandler$10(MediaSession.ControllerInfo controllerInfo, String str) {
        removeSubscription((MediaSession.ControllerCb) Assertions.checkStateNotNull(controllerInfo.getControllerCb()), str);
    }

    private void maybeUpdateLegacyErrorState(LibraryResult<?> libraryResult) {
        MediaLibraryService.LibraryParams libraryParams;
        PlayerWrapper playerWrapper = getPlayerWrapper();
        if (libraryResult.resultCode != -102 || (libraryParams = libraryResult.params) == null || !libraryParams.extras.containsKey("android.media.extras.ERROR_RESOLUTION_ACTION_INTENT")) {
            if (playerWrapper.getLegacyStatusCode() != 0) {
                playerWrapper.clearLegacyErrorStatus();
                getSessionCompat().setPlaybackState(playerWrapper.createPlaybackStateCompat());
                return;
            }
            return;
        }
        MediaSessionCompat sessionCompat = getSessionCompat();
        if (playerWrapper.getLegacyStatusCode() != -102) {
            playerWrapper.setLegacyErrorStatus(3, getContext().getString(R.string.authentication_required), libraryResult.params.extras);
            sessionCompat.setPlaybackState(playerWrapper.createPlaybackStateCompat());
        }
    }

    private void removeSubscription(MediaSession.ControllerCb controllerCb, String str) {
        synchronized (this.lock) {
            try {
                Set<String> set = this.subscriptions.get(controllerCb);
                if (set != null) {
                    set.remove(str);
                    if (set.isEmpty()) {
                        this.subscriptions.remove(controllerCb);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Nullable
    private static <T> T tryGetFutureResult(Future<T> future) {
        Assertions.checkState(future.isDone());
        try {
            return future.get();
        } catch (InterruptedException | CancellationException | ExecutionException e10) {
            Log.w(MediaSessionImpl.TAG, "Library operation failed", e10);
            return null;
        }
    }

    private static void verifyResultItems(LibraryResult<ImmutableList<MediaItem>> libraryResult, int i10) {
        if (libraryResult.resultCode == 0) {
            List list = (List) Assertions.checkNotNull(libraryResult.value);
            if (list.size() <= i10) {
                return;
            }
            throw new IllegalStateException("Invalid size=" + list.size() + ", pageSize=" + i10);
        }
    }

    @Override // androidx.media3.session.MediaSessionImpl
    public MediaSessionServiceLegacyStub createLegacyBrowserService(MediaSessionCompat.Token token) {
        MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub = new MediaLibraryServiceLegacyStub(this);
        mediaLibraryServiceLegacyStub.initialize(token);
        return mediaLibraryServiceLegacyStub;
    }

    @Override // androidx.media3.session.MediaSessionImpl
    public void dispatchRemoteControllerTaskWithoutReturn(MediaSessionImpl.RemoteControllerTask remoteControllerTask) {
        super.dispatchRemoteControllerTaskWithoutReturn(remoteControllerTask);
        MediaLibraryServiceLegacyStub legacyBrowserService = getLegacyBrowserService();
        if (legacyBrowserService != null) {
            try {
                remoteControllerTask.run(legacyBrowserService.getBrowserLegacyCbForBroadcast(), 0);
            } catch (RemoteException e10) {
                Log.e(MediaSessionImpl.TAG, "Exception in using media1 API", e10);
            }
        }
    }

    @Override // androidx.media3.session.MediaSessionImpl
    public List<MediaSession.ControllerInfo> getConnectedControllers() {
        List<MediaSession.ControllerInfo> connectedControllers = super.getConnectedControllers();
        MediaLibraryServiceLegacyStub legacyBrowserService = getLegacyBrowserService();
        if (legacyBrowserService != null) {
            connectedControllers.addAll(legacyBrowserService.getConnectedControllersManager().getConnectedControllers());
        }
        return connectedControllers;
    }

    @Override // androidx.media3.session.MediaSessionImpl
    public boolean isConnected(MediaSession.ControllerInfo controllerInfo) {
        if (super.isConnected(controllerInfo)) {
            return true;
        }
        MediaLibraryServiceLegacyStub legacyBrowserService = getLegacyBrowserService();
        return legacyBrowserService != null && legacyBrowserService.getConnectedControllersManager().isConnected(controllerInfo);
    }

    public void notifyChildrenChanged(String str, int i10, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        dispatchRemoteControllerTaskWithoutReturn(new MediaSessionImpl.RemoteControllerTask() { // from class: androidx.media3.session.u6

            /* renamed from: b */
            public final /* synthetic */ String f948b;

            /* renamed from: c */
            public final /* synthetic */ int f949c;

            /* renamed from: d */
            public final /* synthetic */ MediaLibraryService.LibraryParams f950d;

            public /* synthetic */ u6(String str2, int i102, MediaLibraryService.LibraryParams libraryParams2) {
                str = str2;
                i10 = i102;
                libraryParams = libraryParams2;
            }

            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i11) {
                MediaLibrarySessionImpl.this.lambda$notifyChildrenChanged$0(str, i10, libraryParams, controllerCb, i11);
            }
        });
    }

    public void notifySearchResultChanged(MediaSession.ControllerInfo controllerInfo, String str, int i10, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new MediaSessionImpl.RemoteControllerTask() { // from class: androidx.media3.session.b7

            /* renamed from: a */
            public final /* synthetic */ String f425a;

            /* renamed from: b */
            public final /* synthetic */ int f426b;

            /* renamed from: c */
            public final /* synthetic */ MediaLibraryService.LibraryParams f427c;

            public /* synthetic */ b7(String str2, int i102, MediaLibraryService.LibraryParams libraryParams2) {
                str = str2;
                i10 = i102;
                libraryParams = libraryParams2;
            }

            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i11) {
                controllerCb.onSearchResultChanged(i11, str, i10, libraryParams);
            }
        });
    }

    public p5.c0<LibraryResult<ImmutableList<MediaItem>>> onGetChildrenOnHandler(MediaSession.ControllerInfo controllerInfo, String str, int i10, int i11, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        if (Objects.equals(str, RECENT_LIBRARY_ROOT_MEDIA_ID)) {
            return !canResumePlaybackOnStart() ? com.google.common.util.concurrent.l.m(LibraryResult.ofError(-6)) : getPlayerWrapper().getPlaybackState() == 1 ? getRecentMediaItemAtDeviceBootTime(controllerInfo, libraryParams) : com.google.common.util.concurrent.l.m(LibraryResult.ofItemList(ImmutableList.of(new MediaItem.Builder().setMediaId("androidx.media3.session.recent.item").setMediaMetadata(new MediaMetadata.Builder().setIsBrowsable(Boolean.FALSE).setIsPlayable(Boolean.TRUE).build()).build()), libraryParams));
        }
        p5.c0<LibraryResult<ImmutableList<MediaItem>>> onGetChildren = this.callback.onGetChildren(this.instance, controllerInfo, str, i10, i11, libraryParams);
        onGetChildren.addListener(new Runnable() { // from class: androidx.media3.session.r6

            /* renamed from: c */
            public final /* synthetic */ p5.c0 f873c;

            /* renamed from: d */
            public final /* synthetic */ int f874d;

            public /* synthetic */ r6(p5.c0 onGetChildren2, int i112) {
                onGetChildren = onGetChildren2;
                i11 = i112;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaLibrarySessionImpl.this.lambda$onGetChildrenOnHandler$5(onGetChildren, i11);
            }
        }, new Executor() { // from class: androidx.media3.session.x6
            public /* synthetic */ x6() {
            }

            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                MediaLibrarySessionImpl.this.lambda$onGetChildrenOnHandler$6(runnable);
            }
        });
        return onGetChildren2;
    }

    public p5.c0<LibraryResult<MediaItem>> onGetItemOnHandler(MediaSession.ControllerInfo controllerInfo, String str) {
        p5.c0<LibraryResult<MediaItem>> onGetItem = this.callback.onGetItem(this.instance, controllerInfo, str);
        onGetItem.addListener(new Runnable() { // from class: androidx.media3.session.z6

            /* renamed from: c */
            public final /* synthetic */ p5.c0 f1074c;

            public /* synthetic */ z6(p5.c0 onGetItem2) {
                onGetItem = onGetItem2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaLibrarySessionImpl.this.lambda$onGetItemOnHandler$7(onGetItem);
            }
        }, new Executor() { // from class: androidx.media3.session.a7
            public /* synthetic */ a7() {
            }

            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                MediaLibrarySessionImpl.this.lambda$onGetItemOnHandler$8(runnable);
            }
        });
        return onGetItem2;
    }

    public p5.c0<LibraryResult<MediaItem>> onGetLibraryRootOnHandler(MediaSession.ControllerInfo controllerInfo, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        if (libraryParams != null && libraryParams.isRecent && Objects.equals(controllerInfo.getPackageName(), SYSTEM_UI_PACKAGE_NAME)) {
            return !canResumePlaybackOnStart() ? com.google.common.util.concurrent.l.m(LibraryResult.ofError(-6)) : com.google.common.util.concurrent.l.m(LibraryResult.ofItem(new MediaItem.Builder().setMediaId(RECENT_LIBRARY_ROOT_MEDIA_ID).setMediaMetadata(new MediaMetadata.Builder().setIsBrowsable(Boolean.TRUE).setIsPlayable(Boolean.FALSE).build()).build(), libraryParams));
        }
        p5.c0<LibraryResult<MediaItem>> onGetLibraryRoot = this.callback.onGetLibraryRoot(this.instance, controllerInfo, libraryParams);
        onGetLibraryRoot.addListener(new Runnable() { // from class: androidx.media3.session.v6

            /* renamed from: c */
            public final /* synthetic */ p5.c0 f979c;

            public /* synthetic */ v6(p5.c0 onGetLibraryRoot2) {
                onGetLibraryRoot = onGetLibraryRoot2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaLibrarySessionImpl.this.lambda$onGetLibraryRootOnHandler$3(onGetLibraryRoot);
            }
        }, new Executor() { // from class: androidx.media3.session.w6
            public /* synthetic */ w6() {
            }

            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                MediaLibrarySessionImpl.this.lambda$onGetLibraryRootOnHandler$4(runnable);
            }
        });
        return onGetLibraryRoot2;
    }

    public p5.c0<LibraryResult<ImmutableList<MediaItem>>> onGetSearchResultOnHandler(MediaSession.ControllerInfo controllerInfo, String str, int i10, int i11, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        p5.c0<LibraryResult<ImmutableList<MediaItem>>> onGetSearchResult = this.callback.onGetSearchResult(this.instance, controllerInfo, str, i10, i11, libraryParams);
        onGetSearchResult.addListener(new Runnable() { // from class: androidx.media3.session.c7

            /* renamed from: c */
            public final /* synthetic */ p5.c0 f451c;

            /* renamed from: d */
            public final /* synthetic */ int f452d;

            public /* synthetic */ c7(p5.c0 onGetSearchResult2, int i112) {
                onGetSearchResult = onGetSearchResult2;
                i11 = i112;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaLibrarySessionImpl.this.lambda$onGetSearchResultOnHandler$13(onGetSearchResult, i11);
            }
        }, new Executor() { // from class: androidx.media3.session.d7
            public /* synthetic */ d7() {
            }

            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                MediaLibrarySessionImpl.this.lambda$onGetSearchResultOnHandler$14(runnable);
            }
        });
        return onGetSearchResult2;
    }

    public p5.c0<LibraryResult<Void>> onSearchOnHandler(MediaSession.ControllerInfo controllerInfo, String str, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        p5.c0<LibraryResult<Void>> onSearch = this.callback.onSearch(this.instance, controllerInfo, str, libraryParams);
        onSearch.addListener(new Runnable() { // from class: androidx.media3.session.f7

            /* renamed from: c */
            public final /* synthetic */ p5.c0 f535c;

            public /* synthetic */ f7(p5.c0 onSearch2) {
                onSearch = onSearch2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaLibrarySessionImpl.this.lambda$onSearchOnHandler$11(onSearch);
            }
        }, new Executor() { // from class: androidx.media3.session.s6
            public /* synthetic */ s6() {
            }

            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                MediaLibrarySessionImpl.this.lambda$onSearchOnHandler$12(runnable);
            }
        });
        return onSearch2;
    }

    public p5.c0<LibraryResult<Void>> onSubscribeOnHandler(MediaSession.ControllerInfo controllerInfo, String str, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        MediaSession.ControllerCb controllerCb = (MediaSession.ControllerCb) Assertions.checkStateNotNull(controllerInfo.getControllerCb());
        synchronized (this.lock) {
            try {
                Set<String> set = this.subscriptions.get(controllerCb);
                if (set == null) {
                    set = new HashSet<>();
                    this.subscriptions.put(controllerCb, set);
                }
                set.add(str);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        p5.c0<LibraryResult<Void>> c0Var = (p5.c0) Assertions.checkNotNull(this.callback.onSubscribe(this.instance, controllerInfo, str, libraryParams), "onSubscribe must return non-null future");
        c0Var.addListener(new Runnable() { // from class: androidx.media3.session.y6

            /* renamed from: c */
            public final /* synthetic */ p5.c0 f1048c;

            /* renamed from: d */
            public final /* synthetic */ MediaSession.ControllerCb f1049d;

            /* renamed from: e */
            public final /* synthetic */ String f1050e;

            public /* synthetic */ y6(p5.c0 c0Var2, MediaSession.ControllerCb controllerCb2, String str2) {
                c0Var = c0Var2;
                controllerCb = controllerCb2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaLibrarySessionImpl.this.lambda$onSubscribeOnHandler$9(c0Var, controllerCb, str);
            }
        }, com.google.common.util.concurrent.p.c());
        return c0Var2;
    }

    public p5.c0<LibraryResult<Void>> onUnsubscribeOnHandler(MediaSession.ControllerInfo controllerInfo, String str) {
        p5.c0<LibraryResult<Void>> onUnsubscribe = this.callback.onUnsubscribe(this.instance, controllerInfo, str);
        onUnsubscribe.addListener(new Runnable() { // from class: androidx.media3.session.t6

            /* renamed from: c */
            public final /* synthetic */ MediaSession.ControllerInfo f920c;

            /* renamed from: d */
            public final /* synthetic */ String f921d;

            public /* synthetic */ t6(MediaSession.ControllerInfo controllerInfo2, String str2) {
                controllerInfo = controllerInfo2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaLibrarySessionImpl.this.lambda$onUnsubscribeOnHandler$10(controllerInfo, str);
            }
        }, com.google.common.util.concurrent.p.c());
        return onUnsubscribe;
    }

    @Override // androidx.media3.session.MediaSessionImpl
    @Nullable
    public MediaLibraryServiceLegacyStub getLegacyBrowserService() {
        return (MediaLibraryServiceLegacyStub) super.getLegacyBrowserService();
    }

    public void notifyChildrenChanged(MediaSession.ControllerInfo controllerInfo, String str, int i10, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new MediaSessionImpl.RemoteControllerTask() { // from class: androidx.media3.session.e7

            /* renamed from: b */
            public final /* synthetic */ String f507b;

            /* renamed from: c */
            public final /* synthetic */ int f508c;

            /* renamed from: d */
            public final /* synthetic */ MediaLibraryService.LibraryParams f509d;

            public /* synthetic */ e7(String str2, int i102, MediaLibraryService.LibraryParams libraryParams2) {
                str = str2;
                i10 = i102;
                libraryParams = libraryParams2;
            }

            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i11) {
                MediaLibrarySessionImpl.this.lambda$notifyChildrenChanged$1(str, i10, libraryParams, controllerCb, i11);
            }
        });
    }
}
