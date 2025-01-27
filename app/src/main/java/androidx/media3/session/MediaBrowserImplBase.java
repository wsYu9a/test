package androidx.media3.session;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.session.MediaBrowser;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.SequencedFutureManager;
import com.google.common.collect.ImmutableList;

/* loaded from: classes.dex */
class MediaBrowserImplBase extends MediaControllerImplBase implements MediaBrowser.MediaBrowserImpl {
    private final MediaBrowser instance;

    /* renamed from: androidx.media3.session.MediaBrowserImplBase$1 */
    public class AnonymousClass1 implements RemoteLibrarySessionTask {
        final /* synthetic */ MediaLibraryService.LibraryParams val$params;

        public AnonymousClass1(MediaLibraryService.LibraryParams libraryParams) {
            libraryParams = libraryParams;
        }

        @Override // androidx.media3.session.MediaBrowserImplBase.RemoteLibrarySessionTask
        public void run(IMediaSession iMediaSession, int i10) throws RemoteException {
            MediaControllerStub mediaControllerStub = MediaBrowserImplBase.this.controllerStub;
            MediaLibraryService.LibraryParams libraryParams = libraryParams;
            iMediaSession.getLibraryRoot(mediaControllerStub, i10, libraryParams == null ? null : libraryParams.toBundle());
        }
    }

    /* renamed from: androidx.media3.session.MediaBrowserImplBase$2 */
    public class AnonymousClass2 implements RemoteLibrarySessionTask {
        final /* synthetic */ MediaLibraryService.LibraryParams val$params;
        final /* synthetic */ String val$parentId;

        public AnonymousClass2(String str, MediaLibraryService.LibraryParams libraryParams) {
            str = str;
            libraryParams = libraryParams;
        }

        @Override // androidx.media3.session.MediaBrowserImplBase.RemoteLibrarySessionTask
        public void run(IMediaSession iMediaSession, int i10) throws RemoteException {
            MediaControllerStub mediaControllerStub = MediaBrowserImplBase.this.controllerStub;
            String str = str;
            MediaLibraryService.LibraryParams libraryParams = libraryParams;
            iMediaSession.subscribe(mediaControllerStub, i10, str, libraryParams == null ? null : libraryParams.toBundle());
        }
    }

    /* renamed from: androidx.media3.session.MediaBrowserImplBase$3 */
    public class AnonymousClass3 implements RemoteLibrarySessionTask {
        final /* synthetic */ String val$parentId;

        public AnonymousClass3(String str) {
            str = str;
        }

        @Override // androidx.media3.session.MediaBrowserImplBase.RemoteLibrarySessionTask
        public void run(IMediaSession iMediaSession, int i10) throws RemoteException {
            iMediaSession.unsubscribe(MediaBrowserImplBase.this.controllerStub, i10, str);
        }
    }

    /* renamed from: androidx.media3.session.MediaBrowserImplBase$4 */
    public class AnonymousClass4 implements RemoteLibrarySessionTask {
        final /* synthetic */ int val$page;
        final /* synthetic */ int val$pageSize;
        final /* synthetic */ MediaLibraryService.LibraryParams val$params;
        final /* synthetic */ String val$parentId;

        public AnonymousClass4(String str, int i10, int i11, MediaLibraryService.LibraryParams libraryParams) {
            str = str;
            i10 = i10;
            i11 = i11;
            libraryParams = libraryParams;
        }

        @Override // androidx.media3.session.MediaBrowserImplBase.RemoteLibrarySessionTask
        public void run(IMediaSession iMediaSession, int i10) throws RemoteException {
            MediaControllerStub mediaControllerStub = MediaBrowserImplBase.this.controllerStub;
            String str = str;
            int i11 = i10;
            int i12 = i11;
            MediaLibraryService.LibraryParams libraryParams = libraryParams;
            iMediaSession.getChildren(mediaControllerStub, i10, str, i11, i12, libraryParams == null ? null : libraryParams.toBundle());
        }
    }

    /* renamed from: androidx.media3.session.MediaBrowserImplBase$5 */
    public class AnonymousClass5 implements RemoteLibrarySessionTask {
        final /* synthetic */ String val$mediaId;

        public AnonymousClass5(String str) {
            str = str;
        }

        @Override // androidx.media3.session.MediaBrowserImplBase.RemoteLibrarySessionTask
        public void run(IMediaSession iMediaSession, int i10) throws RemoteException {
            iMediaSession.getItem(MediaBrowserImplBase.this.controllerStub, i10, str);
        }
    }

    /* renamed from: androidx.media3.session.MediaBrowserImplBase$6 */
    public class AnonymousClass6 implements RemoteLibrarySessionTask {
        final /* synthetic */ MediaLibraryService.LibraryParams val$params;
        final /* synthetic */ String val$query;

        public AnonymousClass6(String str, MediaLibraryService.LibraryParams libraryParams) {
            str = str;
            libraryParams = libraryParams;
        }

        @Override // androidx.media3.session.MediaBrowserImplBase.RemoteLibrarySessionTask
        public void run(IMediaSession iMediaSession, int i10) throws RemoteException {
            MediaControllerStub mediaControllerStub = MediaBrowserImplBase.this.controllerStub;
            String str = str;
            MediaLibraryService.LibraryParams libraryParams = libraryParams;
            iMediaSession.search(mediaControllerStub, i10, str, libraryParams == null ? null : libraryParams.toBundle());
        }
    }

    /* renamed from: androidx.media3.session.MediaBrowserImplBase$7 */
    public class AnonymousClass7 implements RemoteLibrarySessionTask {
        final /* synthetic */ int val$page;
        final /* synthetic */ int val$pageSize;
        final /* synthetic */ MediaLibraryService.LibraryParams val$params;
        final /* synthetic */ String val$query;

        public AnonymousClass7(String str, int i10, int i11, MediaLibraryService.LibraryParams libraryParams) {
            str = str;
            i10 = i10;
            i11 = i11;
            libraryParams = libraryParams;
        }

        @Override // androidx.media3.session.MediaBrowserImplBase.RemoteLibrarySessionTask
        public void run(IMediaSession iMediaSession, int i10) throws RemoteException {
            MediaControllerStub mediaControllerStub = MediaBrowserImplBase.this.controllerStub;
            String str = str;
            int i11 = i10;
            int i12 = i11;
            MediaLibraryService.LibraryParams libraryParams = libraryParams;
            iMediaSession.getSearchResult(mediaControllerStub, i10, str, i11, i12, libraryParams == null ? null : libraryParams.toBundle());
        }
    }

    public interface RemoteLibrarySessionTask {
        void run(IMediaSession iMediaSession, int i10) throws RemoteException;
    }

    public MediaBrowserImplBase(Context context, MediaBrowser mediaBrowser, SessionToken sessionToken, Bundle bundle, Looper looper) {
        super(context, mediaBrowser, sessionToken, bundle, looper);
        this.instance = mediaBrowser;
    }

    private <V> p5.c0<LibraryResult<V>> dispatchRemoteLibrarySessionTask(int i10, RemoteLibrarySessionTask remoteLibrarySessionTask) {
        IMediaSession sessionInterfaceWithSessionCommandIfAble = getSessionInterfaceWithSessionCommandIfAble(i10);
        if (sessionInterfaceWithSessionCommandIfAble == null) {
            return com.google.common.util.concurrent.l.m(LibraryResult.ofError(-4));
        }
        SequencedFutureManager.SequencedFuture createSequencedFuture = this.sequencedFutureManager.createSequencedFuture(LibraryResult.ofError(1));
        try {
            remoteLibrarySessionTask.run(sessionInterfaceWithSessionCommandIfAble, createSequencedFuture.getSequenceNumber());
        } catch (RemoteException e10) {
            Log.w(MediaControllerImplBase.TAG, "Cannot connect to the service or the session is gone", e10);
            this.sequencedFutureManager.setFutureResult(createSequencedFuture.getSequenceNumber(), LibraryResult.ofError(-100));
        }
        return createSequencedFuture;
    }

    public /* synthetic */ void lambda$notifyChildrenChanged$1(String str, int i10, MediaLibraryService.LibraryParams libraryParams, MediaBrowser.Listener listener) {
        listener.onChildrenChanged(getInstance(), str, i10, libraryParams);
    }

    public /* synthetic */ void lambda$notifySearchResultChanged$0(String str, int i10, MediaLibraryService.LibraryParams libraryParams, MediaBrowser.Listener listener) {
        listener.onSearchResultChanged(getInstance(), str, i10, libraryParams);
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public p5.c0<LibraryResult<ImmutableList<MediaItem>>> getChildren(String str, int i10, int i11, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        return dispatchRemoteLibrarySessionTask(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, new RemoteLibrarySessionTask() { // from class: androidx.media3.session.MediaBrowserImplBase.4
            final /* synthetic */ int val$page;
            final /* synthetic */ int val$pageSize;
            final /* synthetic */ MediaLibraryService.LibraryParams val$params;
            final /* synthetic */ String val$parentId;

            public AnonymousClass4(String str2, int i102, int i112, MediaLibraryService.LibraryParams libraryParams2) {
                str = str2;
                i10 = i102;
                i11 = i112;
                libraryParams = libraryParams2;
            }

            @Override // androidx.media3.session.MediaBrowserImplBase.RemoteLibrarySessionTask
            public void run(IMediaSession iMediaSession, int i102) throws RemoteException {
                MediaControllerStub mediaControllerStub = MediaBrowserImplBase.this.controllerStub;
                String str2 = str;
                int i112 = i10;
                int i12 = i11;
                MediaLibraryService.LibraryParams libraryParams2 = libraryParams;
                iMediaSession.getChildren(mediaControllerStub, i102, str2, i112, i12, libraryParams2 == null ? null : libraryParams2.toBundle());
            }
        });
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public p5.c0<LibraryResult<MediaItem>> getItem(String str) {
        return dispatchRemoteLibrarySessionTask(SessionCommand.COMMAND_CODE_LIBRARY_GET_ITEM, new RemoteLibrarySessionTask() { // from class: androidx.media3.session.MediaBrowserImplBase.5
            final /* synthetic */ String val$mediaId;

            public AnonymousClass5(String str2) {
                str = str2;
            }

            @Override // androidx.media3.session.MediaBrowserImplBase.RemoteLibrarySessionTask
            public void run(IMediaSession iMediaSession, int i10) throws RemoteException {
                iMediaSession.getItem(MediaBrowserImplBase.this.controllerStub, i10, str);
            }
        });
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public p5.c0<LibraryResult<MediaItem>> getLibraryRoot(@Nullable MediaLibraryService.LibraryParams libraryParams) {
        return dispatchRemoteLibrarySessionTask(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, new RemoteLibrarySessionTask() { // from class: androidx.media3.session.MediaBrowserImplBase.1
            final /* synthetic */ MediaLibraryService.LibraryParams val$params;

            public AnonymousClass1(MediaLibraryService.LibraryParams libraryParams2) {
                libraryParams = libraryParams2;
            }

            @Override // androidx.media3.session.MediaBrowserImplBase.RemoteLibrarySessionTask
            public void run(IMediaSession iMediaSession, int i10) throws RemoteException {
                MediaControllerStub mediaControllerStub = MediaBrowserImplBase.this.controllerStub;
                MediaLibraryService.LibraryParams libraryParams2 = libraryParams;
                iMediaSession.getLibraryRoot(mediaControllerStub, i10, libraryParams2 == null ? null : libraryParams2.toBundle());
            }
        });
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public p5.c0<LibraryResult<ImmutableList<MediaItem>>> getSearchResult(String str, int i10, int i11, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        return dispatchRemoteLibrarySessionTask(SessionCommand.COMMAND_CODE_LIBRARY_GET_SEARCH_RESULT, new RemoteLibrarySessionTask() { // from class: androidx.media3.session.MediaBrowserImplBase.7
            final /* synthetic */ int val$page;
            final /* synthetic */ int val$pageSize;
            final /* synthetic */ MediaLibraryService.LibraryParams val$params;
            final /* synthetic */ String val$query;

            public AnonymousClass7(String str2, int i102, int i112, MediaLibraryService.LibraryParams libraryParams2) {
                str = str2;
                i10 = i102;
                i11 = i112;
                libraryParams = libraryParams2;
            }

            @Override // androidx.media3.session.MediaBrowserImplBase.RemoteLibrarySessionTask
            public void run(IMediaSession iMediaSession, int i102) throws RemoteException {
                MediaControllerStub mediaControllerStub = MediaBrowserImplBase.this.controllerStub;
                String str2 = str;
                int i112 = i10;
                int i12 = i11;
                MediaLibraryService.LibraryParams libraryParams2 = libraryParams;
                iMediaSession.getSearchResult(mediaControllerStub, i102, str2, i112, i12, libraryParams2 == null ? null : libraryParams2.toBundle());
            }
        });
    }

    public void notifyChildrenChanged(String str, int i10, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        if (isConnected()) {
            getInstance().notifyBrowserListener(new Consumer() { // from class: androidx.media3.session.h

                /* renamed from: b */
                public final /* synthetic */ String f581b;

                /* renamed from: c */
                public final /* synthetic */ int f582c;

                /* renamed from: d */
                public final /* synthetic */ MediaLibraryService.LibraryParams f583d;

                public /* synthetic */ h(String str2, int i102, MediaLibraryService.LibraryParams libraryParams2) {
                    str = str2;
                    i10 = i102;
                    libraryParams = libraryParams2;
                }

                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaBrowserImplBase.this.lambda$notifyChildrenChanged$1(str, i10, libraryParams, (MediaBrowser.Listener) obj);
                }
            });
        }
    }

    public void notifySearchResultChanged(String str, int i10, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        if (isConnected()) {
            getInstance().notifyBrowserListener(new Consumer() { // from class: androidx.media3.session.g

                /* renamed from: b */
                public final /* synthetic */ String f552b;

                /* renamed from: c */
                public final /* synthetic */ int f553c;

                /* renamed from: d */
                public final /* synthetic */ MediaLibraryService.LibraryParams f554d;

                public /* synthetic */ g(String str2, int i102, MediaLibraryService.LibraryParams libraryParams2) {
                    str = str2;
                    i10 = i102;
                    libraryParams = libraryParams2;
                }

                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaBrowserImplBase.this.lambda$notifySearchResultChanged$0(str, i10, libraryParams, (MediaBrowser.Listener) obj);
                }
            });
        }
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public p5.c0<LibraryResult<Void>> search(String str, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        return dispatchRemoteLibrarySessionTask(SessionCommand.COMMAND_CODE_LIBRARY_SEARCH, new RemoteLibrarySessionTask() { // from class: androidx.media3.session.MediaBrowserImplBase.6
            final /* synthetic */ MediaLibraryService.LibraryParams val$params;
            final /* synthetic */ String val$query;

            public AnonymousClass6(String str2, MediaLibraryService.LibraryParams libraryParams2) {
                str = str2;
                libraryParams = libraryParams2;
            }

            @Override // androidx.media3.session.MediaBrowserImplBase.RemoteLibrarySessionTask
            public void run(IMediaSession iMediaSession, int i10) throws RemoteException {
                MediaControllerStub mediaControllerStub = MediaBrowserImplBase.this.controllerStub;
                String str2 = str;
                MediaLibraryService.LibraryParams libraryParams2 = libraryParams;
                iMediaSession.search(mediaControllerStub, i10, str2, libraryParams2 == null ? null : libraryParams2.toBundle());
            }
        });
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public p5.c0<LibraryResult<Void>> subscribe(String str, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        return dispatchRemoteLibrarySessionTask(SessionCommand.COMMAND_CODE_LIBRARY_SUBSCRIBE, new RemoteLibrarySessionTask() { // from class: androidx.media3.session.MediaBrowserImplBase.2
            final /* synthetic */ MediaLibraryService.LibraryParams val$params;
            final /* synthetic */ String val$parentId;

            public AnonymousClass2(String str2, MediaLibraryService.LibraryParams libraryParams2) {
                str = str2;
                libraryParams = libraryParams2;
            }

            @Override // androidx.media3.session.MediaBrowserImplBase.RemoteLibrarySessionTask
            public void run(IMediaSession iMediaSession, int i10) throws RemoteException {
                MediaControllerStub mediaControllerStub = MediaBrowserImplBase.this.controllerStub;
                String str2 = str;
                MediaLibraryService.LibraryParams libraryParams2 = libraryParams;
                iMediaSession.subscribe(mediaControllerStub, i10, str2, libraryParams2 == null ? null : libraryParams2.toBundle());
            }
        });
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public p5.c0<LibraryResult<Void>> unsubscribe(String str) {
        return dispatchRemoteLibrarySessionTask(SessionCommand.COMMAND_CODE_LIBRARY_UNSUBSCRIBE, new RemoteLibrarySessionTask() { // from class: androidx.media3.session.MediaBrowserImplBase.3
            final /* synthetic */ String val$parentId;

            public AnonymousClass3(String str2) {
                str = str2;
            }

            @Override // androidx.media3.session.MediaBrowserImplBase.RemoteLibrarySessionTask
            public void run(IMediaSession iMediaSession, int i10) throws RemoteException {
                iMediaSession.unsubscribe(MediaBrowserImplBase.this.controllerStub, i10, str);
            }
        });
    }

    @Override // androidx.media3.session.MediaControllerImplBase
    public MediaBrowser getInstance() {
        return this.instance;
    }
}
