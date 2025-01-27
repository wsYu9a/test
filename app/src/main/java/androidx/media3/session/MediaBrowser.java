package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaBrowser;
import androidx.media3.session.MediaController;
import androidx.media3.session.MediaLibraryService;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* loaded from: classes.dex */
public final class MediaBrowser extends MediaController {
    private static final String WRONG_THREAD_ERROR_MESSAGE = "MediaBrowser method is called from a wrong thread. See javadoc of MediaController for details.";

    @NotOnlyInitialized
    private MediaBrowserImpl impl;

    public static final class Builder {
        private androidx.media3.common.util.BitmapLoader bitmapLoader;
        private final Context context;
        private final SessionToken token;
        private Bundle connectionHints = Bundle.EMPTY;
        private Listener listener = new Listener(this) { // from class: androidx.media3.session.MediaBrowser.Builder.1
            public AnonymousClass1(Builder this) {
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ void onAvailableSessionCommandsChanged(MediaController mediaController, SessionCommands sessionCommands) {
                p0.p.a(this, mediaController, sessionCommands);
            }

            @Override // androidx.media3.session.MediaBrowser.Listener
            public /* synthetic */ void onChildrenChanged(MediaBrowser mediaBrowser, String str, int i10, MediaLibraryService.LibraryParams libraryParams) {
                p0.k.a(this, mediaBrowser, str, i10, libraryParams);
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ p5.c0 onCustomCommand(MediaController mediaController, SessionCommand sessionCommand, Bundle bundle) {
                return p0.p.b(this, mediaController, sessionCommand, bundle);
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ void onDisconnected(MediaController mediaController) {
                p0.p.c(this, mediaController);
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ void onExtrasChanged(MediaController mediaController, Bundle bundle) {
                p0.p.d(this, mediaController, bundle);
            }

            @Override // androidx.media3.session.MediaBrowser.Listener
            public /* synthetic */ void onSearchResultChanged(MediaBrowser mediaBrowser, String str, int i10, MediaLibraryService.LibraryParams libraryParams) {
                p0.k.b(this, mediaBrowser, str, i10, libraryParams);
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ void onSessionActivityChanged(MediaController mediaController, PendingIntent pendingIntent) {
                p0.p.e(this, mediaController, pendingIntent);
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ p5.c0 onSetCustomLayout(MediaController mediaController, List list) {
                return p0.p.f(this, mediaController, list);
            }
        };
        private Looper applicationLooper = Util.getCurrentOrMainLooper();

        /* renamed from: androidx.media3.session.MediaBrowser$Builder$1 */
        public class AnonymousClass1 implements Listener {
            public AnonymousClass1(Builder this) {
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ void onAvailableSessionCommandsChanged(MediaController mediaController, SessionCommands sessionCommands) {
                p0.p.a(this, mediaController, sessionCommands);
            }

            @Override // androidx.media3.session.MediaBrowser.Listener
            public /* synthetic */ void onChildrenChanged(MediaBrowser mediaBrowser, String str, int i10, MediaLibraryService.LibraryParams libraryParams) {
                p0.k.a(this, mediaBrowser, str, i10, libraryParams);
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ p5.c0 onCustomCommand(MediaController mediaController, SessionCommand sessionCommand, Bundle bundle) {
                return p0.p.b(this, mediaController, sessionCommand, bundle);
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ void onDisconnected(MediaController mediaController) {
                p0.p.c(this, mediaController);
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ void onExtrasChanged(MediaController mediaController, Bundle bundle) {
                p0.p.d(this, mediaController, bundle);
            }

            @Override // androidx.media3.session.MediaBrowser.Listener
            public /* synthetic */ void onSearchResultChanged(MediaBrowser mediaBrowser, String str, int i10, MediaLibraryService.LibraryParams libraryParams) {
                p0.k.b(this, mediaBrowser, str, i10, libraryParams);
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ void onSessionActivityChanged(MediaController mediaController, PendingIntent pendingIntent) {
                p0.p.e(this, mediaController, pendingIntent);
            }

            @Override // androidx.media3.session.MediaController.Listener
            public /* synthetic */ p5.c0 onSetCustomLayout(MediaController mediaController, List list) {
                return p0.p.f(this, mediaController, list);
            }
        }

        public Builder(Context context, SessionToken sessionToken) {
            this.context = (Context) Assertions.checkNotNull(context);
            this.token = (SessionToken) Assertions.checkNotNull(sessionToken);
        }

        public p5.c0<MediaBrowser> buildAsync() {
            MediaControllerHolder mediaControllerHolder = new MediaControllerHolder(this.applicationLooper);
            if (this.token.isLegacySession() && this.bitmapLoader == null) {
                this.bitmapLoader = new CacheBitmapLoader(new SimpleBitmapLoader());
            }
            Util.postOrRun(new Handler(this.applicationLooper), new Runnable() { // from class: androidx.media3.session.f

                /* renamed from: c */
                public final /* synthetic */ MediaBrowser f521c;

                public /* synthetic */ f(MediaBrowser mediaBrowser) {
                    mediaBrowser = mediaBrowser;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MediaControllerHolder.this.setController(mediaBrowser);
                }
            });
            return mediaControllerHolder;
        }

        @CanIgnoreReturnValue
        public Builder setApplicationLooper(Looper looper) {
            this.applicationLooper = (Looper) Assertions.checkNotNull(looper);
            return this;
        }

        @CanIgnoreReturnValue
        @UnstableApi
        public Builder setBitmapLoader(androidx.media3.common.util.BitmapLoader bitmapLoader) {
            this.bitmapLoader = (androidx.media3.common.util.BitmapLoader) Assertions.checkNotNull(bitmapLoader);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setConnectionHints(Bundle bundle) {
            this.connectionHints = new Bundle((Bundle) Assertions.checkNotNull(bundle));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setListener(Listener listener) {
            this.listener = (Listener) Assertions.checkNotNull(listener);
            return this;
        }
    }

    public interface Listener extends MediaController.Listener {
        void onChildrenChanged(MediaBrowser mediaBrowser, String str, @IntRange(from = 0) int i10, @Nullable MediaLibraryService.LibraryParams libraryParams);

        void onSearchResultChanged(MediaBrowser mediaBrowser, String str, @IntRange(from = 0) int i10, @Nullable MediaLibraryService.LibraryParams libraryParams);
    }

    public interface MediaBrowserImpl extends MediaController.MediaControllerImpl {
        p5.c0<LibraryResult<ImmutableList<MediaItem>>> getChildren(String str, int i10, int i11, @Nullable MediaLibraryService.LibraryParams libraryParams);

        p5.c0<LibraryResult<MediaItem>> getItem(String str);

        p5.c0<LibraryResult<MediaItem>> getLibraryRoot(@Nullable MediaLibraryService.LibraryParams libraryParams);

        p5.c0<LibraryResult<ImmutableList<MediaItem>>> getSearchResult(String str, int i10, int i11, @Nullable MediaLibraryService.LibraryParams libraryParams);

        p5.c0<LibraryResult<Void>> search(String str, @Nullable MediaLibraryService.LibraryParams libraryParams);

        p5.c0<LibraryResult<Void>> subscribe(String str, @Nullable MediaLibraryService.LibraryParams libraryParams);

        p5.c0<LibraryResult<Void>> unsubscribe(String str);
    }

    public MediaBrowser(Context context, SessionToken sessionToken, Bundle bundle, Listener listener, Looper looper, MediaController.ConnectionCallback connectionCallback, @Nullable androidx.media3.common.util.BitmapLoader bitmapLoader) {
        super(context, sessionToken, bundle, listener, looper, connectionCallback, bitmapLoader);
    }

    private static <V> p5.c0<LibraryResult<V>> createDisconnectedFuture() {
        return com.google.common.util.concurrent.l.m(LibraryResult.ofError(-100));
    }

    private void verifyApplicationThread() {
        Assertions.checkState(Looper.myLooper() == getApplicationLooper(), WRONG_THREAD_ERROR_MESSAGE);
    }

    public p5.c0<LibraryResult<ImmutableList<MediaItem>>> getChildren(String str, @IntRange(from = 0) int i10, @IntRange(from = 1) int i11, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        verifyApplicationThread();
        Assertions.checkNotEmpty(str, "parentId must not be empty");
        Assertions.checkArgument(i10 >= 0, "page must not be negative");
        Assertions.checkArgument(i11 >= 1, "pageSize must not be less than 1");
        return isConnected() ? ((MediaBrowserImpl) Assertions.checkNotNull(this.impl)).getChildren(str, i10, i11, libraryParams) : createDisconnectedFuture();
    }

    public p5.c0<LibraryResult<MediaItem>> getItem(String str) {
        verifyApplicationThread();
        Assertions.checkNotEmpty(str, "mediaId must not be empty");
        return isConnected() ? ((MediaBrowserImpl) Assertions.checkNotNull(this.impl)).getItem(str) : createDisconnectedFuture();
    }

    public p5.c0<LibraryResult<MediaItem>> getLibraryRoot(@Nullable MediaLibraryService.LibraryParams libraryParams) {
        verifyApplicationThread();
        return isConnected() ? ((MediaBrowserImpl) Assertions.checkNotNull(this.impl)).getLibraryRoot(libraryParams) : createDisconnectedFuture();
    }

    public p5.c0<LibraryResult<ImmutableList<MediaItem>>> getSearchResult(String str, @IntRange(from = 0) int i10, @IntRange(from = 1) int i11, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        verifyApplicationThread();
        Assertions.checkNotEmpty(str, "query must not be empty");
        Assertions.checkArgument(i10 >= 0, "page must not be negative");
        Assertions.checkArgument(i11 >= 1, "pageSize must not be less than 1");
        return isConnected() ? ((MediaBrowserImpl) Assertions.checkNotNull(this.impl)).getSearchResult(str, i10, i11, libraryParams) : createDisconnectedFuture();
    }

    public void notifyBrowserListener(Consumer<Listener> consumer) {
        Listener listener = (Listener) this.listener;
        if (listener != null) {
            Util.postOrRun(this.applicationHandler, new Runnable() { // from class: p0.j

                /* renamed from: c */
                public final /* synthetic */ MediaBrowser.Listener f29672c;

                public /* synthetic */ j(MediaBrowser.Listener listener2) {
                    listener = listener2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Consumer.this.accept(listener);
                }
            });
        }
    }

    public p5.c0<LibraryResult<Void>> search(String str, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        verifyApplicationThread();
        Assertions.checkNotEmpty(str, "query must not be empty");
        return isConnected() ? ((MediaBrowserImpl) Assertions.checkNotNull(this.impl)).search(str, libraryParams) : createDisconnectedFuture();
    }

    public p5.c0<LibraryResult<Void>> subscribe(String str, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        verifyApplicationThread();
        Assertions.checkNotEmpty(str, "parentId must not be empty");
        return isConnected() ? ((MediaBrowserImpl) Assertions.checkNotNull(this.impl)).subscribe(str, libraryParams) : createDisconnectedFuture();
    }

    public p5.c0<LibraryResult<Void>> unsubscribe(String str) {
        verifyApplicationThread();
        Assertions.checkNotEmpty(str, "parentId must not be empty");
        return isConnected() ? ((MediaBrowserImpl) Assertions.checkNotNull(this.impl)).unsubscribe(str) : createDisconnectedFuture();
    }

    @Override // androidx.media3.session.MediaController
    public MediaBrowserImpl createImpl(Context context, SessionToken sessionToken, Bundle bundle, Looper looper, @Nullable androidx.media3.common.util.BitmapLoader bitmapLoader) {
        MediaBrowserImpl mediaBrowserImplLegacy = sessionToken.isLegacySession() ? new MediaBrowserImplLegacy(context, this, sessionToken, looper, (androidx.media3.common.util.BitmapLoader) Assertions.checkNotNull(bitmapLoader)) : new MediaBrowserImplBase(context, this, sessionToken, bundle, looper);
        this.impl = mediaBrowserImplLegacy;
        return mediaBrowserImplLegacy;
    }
}
