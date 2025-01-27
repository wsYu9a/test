package androidx.media3.session;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.media.MediaBrowserCompat;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.session.MediaBrowser;
import androidx.media3.session.MediaBrowserImplLegacy;
import androidx.media3.session.MediaLibraryService;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class MediaBrowserImplLegacy extends MediaControllerImplLegacy implements MediaBrowser.MediaBrowserImpl {
    private static final String TAG = "MB2ImplLegacy";
    private final HashMap<MediaLibraryService.LibraryParams, MediaBrowserCompat> browserCompats;
    private final MediaBrowser instance;
    private final HashMap<String, List<SubscribeCallback>> subscribeCallbacks;

    /* renamed from: androidx.media3.session.MediaBrowserImplLegacy$1 */
    public class AnonymousClass1 extends MediaBrowserCompat.ItemCallback {
        final /* synthetic */ com.google.common.util.concurrent.s val$result;

        public AnonymousClass1(MediaBrowserImplLegacy mediaBrowserImplLegacy, com.google.common.util.concurrent.s sVar) {
            n10 = sVar;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ItemCallback
        public void onError(String str) {
            n10.set(LibraryResult.ofError(-1));
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ItemCallback
        public void onItemLoaded(MediaBrowserCompat.MediaItem mediaItem) {
            if (mediaItem != null) {
                n10.set(LibraryResult.ofItem(MediaUtils.convertToMediaItem(mediaItem), null));
            } else {
                n10.set(LibraryResult.ofError(-3));
            }
        }
    }

    /* renamed from: androidx.media3.session.MediaBrowserImplLegacy$2 */
    public class AnonymousClass2 extends MediaBrowserCompat.SearchCallback {
        public AnonymousClass2() {
        }

        public /* synthetic */ void lambda$onError$1(String str, MediaBrowser.Listener listener) {
            listener.onSearchResultChanged(MediaBrowserImplLegacy.this.getInstance(), str, 0, null);
        }

        public /* synthetic */ void lambda$onSearchResult$0(String str, List list, MediaBrowser.Listener listener) {
            listener.onSearchResultChanged(MediaBrowserImplLegacy.this.getInstance(), str, list.size(), null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SearchCallback
        public void onError(String str, Bundle bundle) {
            MediaBrowserImplLegacy.this.getInstance().notifyBrowserListener(new Consumer() { // from class: androidx.media3.session.j

                /* renamed from: b */
                public final /* synthetic */ String f640b;

                public /* synthetic */ j(String str2) {
                    str = str2;
                }

                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaBrowserImplLegacy.AnonymousClass2.this.lambda$onError$1(str, (MediaBrowser.Listener) obj);
                }
            });
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SearchCallback
        public void onSearchResult(String str, Bundle bundle, List<MediaBrowserCompat.MediaItem> list) {
            MediaBrowserImplLegacy.this.getInstance().notifyBrowserListener(new Consumer() { // from class: androidx.media3.session.i

                /* renamed from: b */
                public final /* synthetic */ String f613b;

                /* renamed from: c */
                public final /* synthetic */ List f614c;

                public /* synthetic */ i(String str2, List list2) {
                    str = str2;
                    list = list2;
                }

                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaBrowserImplLegacy.AnonymousClass2.this.lambda$onSearchResult$0(str, list, (MediaBrowser.Listener) obj);
                }
            });
        }
    }

    /* renamed from: androidx.media3.session.MediaBrowserImplLegacy$3 */
    public class AnonymousClass3 extends MediaBrowserCompat.SearchCallback {
        final /* synthetic */ com.google.common.util.concurrent.s val$future;

        public AnonymousClass3(MediaBrowserImplLegacy mediaBrowserImplLegacy, com.google.common.util.concurrent.s sVar) {
            n10 = sVar;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SearchCallback
        public void onError(String str, Bundle bundle) {
            n10.set(LibraryResult.ofError(-1));
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SearchCallback
        public void onSearchResult(String str, Bundle bundle, List<MediaBrowserCompat.MediaItem> list) {
            n10.set(LibraryResult.ofItemList(MediaUtils.convertBrowserItemListToMediaItemList(list), null));
        }
    }

    public class GetChildrenCallback extends MediaBrowserCompat.SubscriptionCallback {
        private final com.google.common.util.concurrent.s<LibraryResult<ImmutableList<MediaItem>>> future;
        private final String parentId;

        public GetChildrenCallback(com.google.common.util.concurrent.s<LibraryResult<ImmutableList<MediaItem>>> sVar, String str) {
            this.future = sVar;
            this.parentId = str;
        }

        private void onChildrenLoadedInternal(String str, List<MediaBrowserCompat.MediaItem> list) {
            if (TextUtils.isEmpty(str)) {
                Log.w(MediaBrowserImplLegacy.TAG, "GetChildrenCallback.onChildrenLoaded(): Ignoring empty parentId");
                return;
            }
            MediaBrowserCompat browserCompat = MediaBrowserImplLegacy.this.getBrowserCompat();
            if (browserCompat == null) {
                this.future.set(LibraryResult.ofError(-100));
                return;
            }
            browserCompat.unsubscribe(this.parentId, this);
            if (list == null) {
                this.future.set(LibraryResult.ofError(-1));
            } else {
                this.future.set(LibraryResult.ofItemList(MediaUtils.convertBrowserItemListToMediaItemList(list), null));
            }
        }

        private void onErrorInternal() {
            this.future.set(LibraryResult.ofError(-1));
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onChildrenLoaded(String str, List<MediaBrowserCompat.MediaItem> list) {
            onChildrenLoadedInternal(str, list);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onError(String str) {
            onErrorInternal();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onChildrenLoaded(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
            onChildrenLoadedInternal(str, list);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onError(String str, Bundle bundle) {
            onErrorInternal();
        }
    }

    public class GetLibraryRootCallback extends MediaBrowserCompat.ConnectionCallback {
        private final MediaLibraryService.LibraryParams params;
        private final com.google.common.util.concurrent.s<LibraryResult<MediaItem>> result;

        public GetLibraryRootCallback(com.google.common.util.concurrent.s<LibraryResult<MediaItem>> sVar, MediaLibraryService.LibraryParams libraryParams) {
            this.result = sVar;
            this.params = libraryParams;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnected() {
            MediaBrowserCompat mediaBrowserCompat = (MediaBrowserCompat) MediaBrowserImplLegacy.this.browserCompats.get(this.params);
            if (mediaBrowserCompat == null) {
                this.result.set(LibraryResult.ofError(-1));
            } else {
                this.result.set(LibraryResult.ofItem(MediaBrowserImplLegacy.this.createRootMediaItem(mediaBrowserCompat), MediaUtils.convertToLibraryParams(MediaBrowserImplLegacy.this.context, mediaBrowserCompat.getExtras())));
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionFailed() {
            this.result.set(LibraryResult.ofError(-3));
            MediaBrowserImplLegacy.this.release();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionSuspended() {
            onConnectionFailed();
        }
    }

    public class SubscribeCallback extends MediaBrowserCompat.SubscriptionCallback {
        private final com.google.common.util.concurrent.s<LibraryResult<Void>> future;

        public SubscribeCallback(com.google.common.util.concurrent.s<LibraryResult<Void>> sVar) {
            this.future = sVar;
        }

        public /* synthetic */ void lambda$onChildrenLoadedInternal$0(String str, int i10, MediaLibraryService.LibraryParams libraryParams, MediaBrowser.Listener listener) {
            listener.onChildrenChanged(MediaBrowserImplLegacy.this.getInstance(), str, i10, libraryParams);
        }

        private void onChildrenLoadedInternal(String str, @Nullable List<MediaBrowserCompat.MediaItem> list) {
            if (TextUtils.isEmpty(str)) {
                Log.w(MediaBrowserImplLegacy.TAG, "SubscribeCallback.onChildrenLoaded(): Ignoring empty parentId");
                return;
            }
            MediaBrowserCompat browserCompat = MediaBrowserImplLegacy.this.getBrowserCompat();
            if (browserCompat == null || list == null) {
                return;
            }
            MediaBrowserImplLegacy.this.getInstance().notifyBrowserListener(new Consumer() { // from class: androidx.media3.session.k

                /* renamed from: b */
                public final /* synthetic */ String f673b;

                /* renamed from: c */
                public final /* synthetic */ int f674c;

                /* renamed from: d */
                public final /* synthetic */ MediaLibraryService.LibraryParams f675d;

                public /* synthetic */ k(String str2, int i10, MediaLibraryService.LibraryParams libraryParams) {
                    str = str2;
                    size = i10;
                    convertToLibraryParams = libraryParams;
                }

                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaBrowserImplLegacy.SubscribeCallback.this.lambda$onChildrenLoadedInternal$0(str, size, convertToLibraryParams, (MediaBrowser.Listener) obj);
                }
            });
            this.future.set(LibraryResult.ofVoid());
        }

        private void onErrorInternal() {
            this.future.set(LibraryResult.ofError(-1));
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onChildrenLoaded(String str, List<MediaBrowserCompat.MediaItem> list) {
            onChildrenLoadedInternal(str, list);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onError(String str) {
            onErrorInternal();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onChildrenLoaded(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
            onChildrenLoadedInternal(str, list);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onError(String str, Bundle bundle) {
            onErrorInternal();
        }
    }

    public MediaBrowserImplLegacy(Context context, MediaBrowser mediaBrowser, SessionToken sessionToken, Looper looper, androidx.media3.common.util.BitmapLoader bitmapLoader) {
        super(context, mediaBrowser, sessionToken, looper, bitmapLoader);
        this.browserCompats = new HashMap<>();
        this.subscribeCallbacks = new HashMap<>();
        this.instance = mediaBrowser;
    }

    private static Bundle createOptions(@Nullable MediaLibraryService.LibraryParams libraryParams) {
        return libraryParams == null ? new Bundle() : new Bundle(libraryParams.extras);
    }

    public MediaItem createRootMediaItem(MediaBrowserCompat mediaBrowserCompat) {
        String root = mediaBrowserCompat.getRoot();
        return new MediaItem.Builder().setMediaId(root).setMediaMetadata(new MediaMetadata.Builder().setIsBrowsable(Boolean.TRUE).setMediaType(20).setIsPlayable(Boolean.FALSE).setExtras(mediaBrowserCompat.getExtras()).build()).build();
    }

    private MediaBrowserCompat getBrowserCompat(MediaLibraryService.LibraryParams libraryParams) {
        return this.browserCompats.get(libraryParams);
    }

    private static Bundle getExtras(@Nullable MediaLibraryService.LibraryParams libraryParams) {
        if (libraryParams != null) {
            return libraryParams.extras;
        }
        return null;
    }

    @Override // androidx.media3.session.MediaControllerImplLegacy, androidx.media3.session.MediaController.MediaControllerImpl
    public SessionCommands getAvailableSessionCommands() {
        return getBrowserCompat() != null ? super.getAvailableSessionCommands().buildUpon().addAllLibraryCommands().build() : super.getAvailableSessionCommands();
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public p5.c0<LibraryResult<ImmutableList<MediaItem>>> getChildren(String str, int i10, int i11, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        if (!getInstance().isSessionCommandAvailable(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN)) {
            return com.google.common.util.concurrent.l.m(LibraryResult.ofError(-4));
        }
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return com.google.common.util.concurrent.l.m(LibraryResult.ofError(-100));
        }
        com.google.common.util.concurrent.s n10 = com.google.common.util.concurrent.s.n();
        browserCompat.subscribe(str, createOptions(libraryParams, i10, i11), new GetChildrenCallback(n10, str));
        return n10;
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public p5.c0<LibraryResult<MediaItem>> getItem(String str) {
        if (!getInstance().isSessionCommandAvailable(SessionCommand.COMMAND_CODE_LIBRARY_GET_ITEM)) {
            return com.google.common.util.concurrent.l.m(LibraryResult.ofError(-4));
        }
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return com.google.common.util.concurrent.l.m(LibraryResult.ofError(-100));
        }
        com.google.common.util.concurrent.s n10 = com.google.common.util.concurrent.s.n();
        browserCompat.getItem(str, new MediaBrowserCompat.ItemCallback(this) { // from class: androidx.media3.session.MediaBrowserImplLegacy.1
            final /* synthetic */ com.google.common.util.concurrent.s val$result;

            public AnonymousClass1(MediaBrowserImplLegacy this, com.google.common.util.concurrent.s n102) {
                n10 = n102;
            }

            @Override // android.support.v4.media.MediaBrowserCompat.ItemCallback
            public void onError(String str2) {
                n10.set(LibraryResult.ofError(-1));
            }

            @Override // android.support.v4.media.MediaBrowserCompat.ItemCallback
            public void onItemLoaded(MediaBrowserCompat.MediaItem mediaItem) {
                if (mediaItem != null) {
                    n10.set(LibraryResult.ofItem(MediaUtils.convertToMediaItem(mediaItem), null));
                } else {
                    n10.set(LibraryResult.ofError(-3));
                }
            }
        });
        return n102;
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public p5.c0<LibraryResult<MediaItem>> getLibraryRoot(@Nullable MediaLibraryService.LibraryParams libraryParams) {
        if (!getInstance().isSessionCommandAvailable(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT)) {
            return com.google.common.util.concurrent.l.m(LibraryResult.ofError(-4));
        }
        com.google.common.util.concurrent.s n10 = com.google.common.util.concurrent.s.n();
        MediaBrowserCompat browserCompat = getBrowserCompat(libraryParams);
        if (browserCompat != null) {
            n10.set(LibraryResult.ofItem(createRootMediaItem(browserCompat), null));
        } else {
            MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(getContext(), getConnectedToken().getComponentName(), new GetLibraryRootCallback(n10, libraryParams), MediaUtils.convertToRootHints(libraryParams));
            this.browserCompats.put(libraryParams, mediaBrowserCompat);
            mediaBrowserCompat.connect();
        }
        return n10;
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public p5.c0<LibraryResult<ImmutableList<MediaItem>>> getSearchResult(String str, int i10, int i11, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        if (!getInstance().isSessionCommandAvailable(SessionCommand.COMMAND_CODE_LIBRARY_GET_SEARCH_RESULT)) {
            return com.google.common.util.concurrent.l.m(LibraryResult.ofError(-4));
        }
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return com.google.common.util.concurrent.l.m(LibraryResult.ofError(-100));
        }
        com.google.common.util.concurrent.s n10 = com.google.common.util.concurrent.s.n();
        Bundle createOptions = createOptions(libraryParams, i10, i11);
        createOptions.putInt(MediaBrowserCompat.EXTRA_PAGE, i10);
        createOptions.putInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, i11);
        browserCompat.search(str, createOptions, new MediaBrowserCompat.SearchCallback(this) { // from class: androidx.media3.session.MediaBrowserImplLegacy.3
            final /* synthetic */ com.google.common.util.concurrent.s val$future;

            public AnonymousClass3(MediaBrowserImplLegacy this, com.google.common.util.concurrent.s n102) {
                n10 = n102;
            }

            @Override // android.support.v4.media.MediaBrowserCompat.SearchCallback
            public void onError(String str2, Bundle bundle) {
                n10.set(LibraryResult.ofError(-1));
            }

            @Override // android.support.v4.media.MediaBrowserCompat.SearchCallback
            public void onSearchResult(String str2, Bundle bundle, List<MediaBrowserCompat.MediaItem> list) {
                n10.set(LibraryResult.ofItemList(MediaUtils.convertBrowserItemListToMediaItemList(list), null));
            }
        });
        return n102;
    }

    @Override // androidx.media3.session.MediaControllerImplLegacy, androidx.media3.session.MediaController.MediaControllerImpl
    public void release() {
        Iterator<MediaBrowserCompat> it = this.browserCompats.values().iterator();
        while (it.hasNext()) {
            it.next().disconnect();
        }
        this.browserCompats.clear();
        super.release();
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public p5.c0<LibraryResult<Void>> search(String str, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        if (!getInstance().isSessionCommandAvailable(SessionCommand.COMMAND_CODE_LIBRARY_SEARCH)) {
            return com.google.common.util.concurrent.l.m(LibraryResult.ofError(-4));
        }
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return com.google.common.util.concurrent.l.m(LibraryResult.ofError(-100));
        }
        browserCompat.search(str, getExtras(libraryParams), new AnonymousClass2());
        return com.google.common.util.concurrent.l.m(LibraryResult.ofVoid());
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public p5.c0<LibraryResult<Void>> subscribe(String str, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        if (!getInstance().isSessionCommandAvailable(SessionCommand.COMMAND_CODE_LIBRARY_SUBSCRIBE)) {
            return com.google.common.util.concurrent.l.m(LibraryResult.ofError(-4));
        }
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return com.google.common.util.concurrent.l.m(LibraryResult.ofError(-100));
        }
        com.google.common.util.concurrent.s n10 = com.google.common.util.concurrent.s.n();
        SubscribeCallback subscribeCallback = new SubscribeCallback(n10);
        List<SubscribeCallback> list = this.subscribeCallbacks.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.subscribeCallbacks.put(str, list);
        }
        list.add(subscribeCallback);
        browserCompat.subscribe(str, createOptions(libraryParams), subscribeCallback);
        return n10;
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public p5.c0<LibraryResult<Void>> unsubscribe(String str) {
        if (!getInstance().isSessionCommandAvailable(SessionCommand.COMMAND_CODE_LIBRARY_UNSUBSCRIBE)) {
            return com.google.common.util.concurrent.l.m(LibraryResult.ofError(-4));
        }
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return com.google.common.util.concurrent.l.m(LibraryResult.ofError(-100));
        }
        List<SubscribeCallback> list = this.subscribeCallbacks.get(str);
        if (list == null) {
            return com.google.common.util.concurrent.l.m(LibraryResult.ofError(-3));
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            browserCompat.unsubscribe(str, list.get(i10));
        }
        return com.google.common.util.concurrent.l.m(LibraryResult.ofVoid());
    }

    private static Bundle createOptions(@Nullable MediaLibraryService.LibraryParams libraryParams, int i10, int i11) {
        Bundle createOptions = createOptions(libraryParams);
        createOptions.putInt(MediaBrowserCompat.EXTRA_PAGE, i10);
        createOptions.putInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, i11);
        return createOptions;
    }

    @Override // androidx.media3.session.MediaControllerImplLegacy
    public MediaBrowser getInstance() {
        return this.instance;
    }
}
