package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.media3.common.Bundleable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaSession;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* loaded from: classes.dex */
public abstract class MediaLibraryService extends MediaSessionService {
    public static final String SERVICE_INTERFACE = "androidx.media3.session.MediaLibraryService";

    public static final class LibraryParams implements Bundleable {

        @UnstableApi
        public final Bundle extras;
        public final boolean isOffline;
        public final boolean isRecent;
        public final boolean isSuggested;
        private static final String FIELD_EXTRAS = Util.intToStringMaxRadix(0);
        private static final String FIELD_RECENT = Util.intToStringMaxRadix(1);
        private static final String FIELD_OFFLINE = Util.intToStringMaxRadix(2);
        private static final String FIELD_SUGGESTED = Util.intToStringMaxRadix(3);

        @UnstableApi
        public static final Bundleable.Creator<LibraryParams> CREATOR = new Bundleable.Creator() { // from class: p0.t
            @Override // androidx.media3.common.Bundleable.Creator
            public final Bundleable fromBundle(Bundle bundle) {
                MediaLibraryService.LibraryParams fromBundle;
                fromBundle = MediaLibraryService.LibraryParams.fromBundle(bundle);
                return fromBundle;
            }
        };

        public static final class Builder {
            private Bundle extras = Bundle.EMPTY;
            private boolean offline;
            private boolean recent;
            private boolean suggested;

            public LibraryParams build() {
                return new LibraryParams(this.extras, this.recent, this.offline, this.suggested);
            }

            @CanIgnoreReturnValue
            @UnstableApi
            public Builder setExtras(Bundle bundle) {
                this.extras = (Bundle) Assertions.checkNotNull(bundle);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setOffline(boolean z10) {
                this.offline = z10;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setRecent(boolean z10) {
                this.recent = z10;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setSuggested(boolean z10) {
                this.suggested = z10;
                return this;
            }
        }

        public /* synthetic */ LibraryParams(Bundle bundle, boolean z10, boolean z11, boolean z12, AnonymousClass1 anonymousClass1) {
            this(bundle, z10, z11, z12);
        }

        public static LibraryParams fromBundle(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle(FIELD_EXTRAS);
            boolean z10 = bundle.getBoolean(FIELD_RECENT, false);
            boolean z11 = bundle.getBoolean(FIELD_OFFLINE, false);
            boolean z12 = bundle.getBoolean(FIELD_SUGGESTED, false);
            if (bundle2 == null) {
                bundle2 = Bundle.EMPTY;
            }
            return new LibraryParams(bundle2, z10, z11, z12);
        }

        @Override // androidx.media3.common.Bundleable
        @UnstableApi
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putBundle(FIELD_EXTRAS, this.extras);
            bundle.putBoolean(FIELD_RECENT, this.isRecent);
            bundle.putBoolean(FIELD_OFFLINE, this.isOffline);
            bundle.putBoolean(FIELD_SUGGESTED, this.isSuggested);
            return bundle;
        }

        private LibraryParams(Bundle bundle, boolean z10, boolean z11, boolean z12) {
            this.extras = new Bundle(bundle);
            this.isRecent = z10;
            this.isOffline = z11;
            this.isSuggested = z12;
        }
    }

    public static final class MediaLibrarySession extends MediaSession {

        public static final class Builder extends MediaSession.BuilderBase<MediaLibrarySession, Builder, Callback> {
            public Builder(MediaLibraryService mediaLibraryService, Player player, Callback callback) {
                super(mediaLibraryService, player, callback);
            }

            @Override // androidx.media3.session.MediaSession.BuilderBase
            public MediaLibrarySession build() {
                if (this.bitmapLoader == null) {
                    this.bitmapLoader = new CacheBitmapLoader(new SimpleBitmapLoader());
                }
                return new MediaLibrarySession(this.context, this.f377id, this.player, this.sessionActivity, this.callback, this.extras, (androidx.media3.common.util.BitmapLoader) Assertions.checkNotNull(this.bitmapLoader));
            }

            @Override // androidx.media3.session.MediaSession.BuilderBase
            @UnstableApi
            public Builder setBitmapLoader(androidx.media3.common.util.BitmapLoader bitmapLoader) {
                return (Builder) super.setBitmapLoader(bitmapLoader);
            }

            @Override // androidx.media3.session.MediaSession.BuilderBase
            public Builder setExtras(Bundle bundle) {
                return (Builder) super.setExtras(bundle);
            }

            @Override // androidx.media3.session.MediaSession.BuilderBase
            public Builder setId(String str) {
                return (Builder) super.setId(str);
            }

            @Override // androidx.media3.session.MediaSession.BuilderBase
            public Builder setSessionActivity(PendingIntent pendingIntent) {
                return (Builder) super.setSessionActivity(pendingIntent);
            }
        }

        public interface Callback extends MediaSession.Callback {
            @Override // androidx.media3.session.MediaSession.Callback
            MediaSession.ConnectionResult onConnect(MediaSession mediaSession, MediaSession.ControllerInfo controllerInfo);

            p5.c0<LibraryResult<ImmutableList<MediaItem>>> onGetChildren(MediaLibrarySession mediaLibrarySession, MediaSession.ControllerInfo controllerInfo, String str, @IntRange(from = 0) int i10, @IntRange(from = 1) int i11, @Nullable LibraryParams libraryParams);

            p5.c0<LibraryResult<MediaItem>> onGetItem(MediaLibrarySession mediaLibrarySession, MediaSession.ControllerInfo controllerInfo, String str);

            p5.c0<LibraryResult<MediaItem>> onGetLibraryRoot(MediaLibrarySession mediaLibrarySession, MediaSession.ControllerInfo controllerInfo, @Nullable LibraryParams libraryParams);

            p5.c0<LibraryResult<ImmutableList<MediaItem>>> onGetSearchResult(MediaLibrarySession mediaLibrarySession, MediaSession.ControllerInfo controllerInfo, String str, @IntRange(from = 0) int i10, @IntRange(from = 1) int i11, @Nullable LibraryParams libraryParams);

            p5.c0<LibraryResult<Void>> onSearch(MediaLibrarySession mediaLibrarySession, MediaSession.ControllerInfo controllerInfo, String str, @Nullable LibraryParams libraryParams);

            p5.c0<LibraryResult<Void>> onSubscribe(MediaLibrarySession mediaLibrarySession, MediaSession.ControllerInfo controllerInfo, String str, @Nullable LibraryParams libraryParams);

            p5.c0<LibraryResult<Void>> onUnsubscribe(MediaLibrarySession mediaLibrarySession, MediaSession.ControllerInfo controllerInfo, String str);
        }

        public MediaLibrarySession(Context context, String str, Player player, @Nullable PendingIntent pendingIntent, MediaSession.Callback callback, Bundle bundle, androidx.media3.common.util.BitmapLoader bitmapLoader) {
            super(context, str, player, pendingIntent, callback, bundle, bitmapLoader);
        }

        public void notifyChildrenChanged(MediaSession.ControllerInfo controllerInfo, String str, @IntRange(from = 0) int i10, @Nullable LibraryParams libraryParams) {
            Assertions.checkArgument(i10 >= 0);
            getImpl().notifyChildrenChanged((MediaSession.ControllerInfo) Assertions.checkNotNull(controllerInfo), Assertions.checkNotEmpty(str), i10, libraryParams);
        }

        public void notifySearchResultChanged(MediaSession.ControllerInfo controllerInfo, String str, @IntRange(from = 0) int i10, @Nullable LibraryParams libraryParams) {
            Assertions.checkArgument(i10 >= 0);
            getImpl().notifySearchResultChanged((MediaSession.ControllerInfo) Assertions.checkNotNull(controllerInfo), Assertions.checkNotEmpty(str), i10, libraryParams);
        }

        @Override // androidx.media3.session.MediaSession
        public MediaLibrarySessionImpl createImpl(Context context, String str, Player player, @Nullable PendingIntent pendingIntent, MediaSession.Callback callback, Bundle bundle, androidx.media3.common.util.BitmapLoader bitmapLoader) {
            return new MediaLibrarySessionImpl(this, context, str, player, pendingIntent, (Callback) callback, bundle, bitmapLoader);
        }

        @Override // androidx.media3.session.MediaSession
        public MediaLibrarySessionImpl getImpl() {
            return (MediaLibrarySessionImpl) super.getImpl();
        }

        public void notifyChildrenChanged(String str, @IntRange(from = 0) int i10, @Nullable LibraryParams libraryParams) {
            Assertions.checkArgument(i10 >= 0);
            getImpl().notifyChildrenChanged(Assertions.checkNotEmpty(str), i10, libraryParams);
        }
    }

    @Override // androidx.media3.session.MediaSessionService, android.app.Service
    @Nullable
    public IBinder onBind(@Nullable Intent intent) {
        if (intent == null) {
            return null;
        }
        return SERVICE_INTERFACE.equals(intent.getAction()) ? getServiceBinder() : super.onBind(intent);
    }

    @Override // androidx.media3.session.MediaSessionService
    @Nullable
    public abstract MediaLibrarySession onGetSession(MediaSession.ControllerInfo controllerInfo);
}
