package android.support.v4.media;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaDescription;
import android.media.browse.MediaBrowser;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserProtocol;
import androidx.media.MediaBrowserServiceCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class MediaBrowserCompat {
    public static final String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
    public static final String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
    public static final String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
    public static final String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
    private final MediaBrowserImpl mImpl;
    static final String TAG = "MediaBrowserCompat";
    static final boolean DEBUG = Log.isLoggable(TAG, 3);

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static MediaDescription getDescription(MediaBrowser.MediaItem mediaItem) {
            return mediaItem.getDescription();
        }

        @DoNotInline
        public static int getFlags(MediaBrowser.MediaItem mediaItem) {
            return mediaItem.getFlags();
        }
    }

    public static class CallbackHandler extends Handler {
        private final WeakReference<MediaBrowserServiceCallbackImpl> mCallbackImplRef;
        private WeakReference<Messenger> mCallbacksMessengerRef;

        public CallbackHandler(MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl) {
            this.mCallbackImplRef = new WeakReference<>(mediaBrowserServiceCallbackImpl);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            WeakReference<Messenger> weakReference = this.mCallbacksMessengerRef;
            if (weakReference == null || weakReference.get() == null || this.mCallbackImplRef.get() == null) {
                return;
            }
            Bundle data = message.getData();
            MediaSessionCompat.ensureClassLoader(data);
            MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl = this.mCallbackImplRef.get();
            Messenger messenger = this.mCallbacksMessengerRef.get();
            try {
                int i10 = message.what;
                if (i10 == 1) {
                    Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                    MediaSessionCompat.ensureClassLoader(bundle);
                    mediaBrowserServiceCallbackImpl.onServiceConnected(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (MediaSessionCompat.Token) data.getParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), bundle);
                } else if (i10 == 2) {
                    mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
                } else if (i10 != 3) {
                    Log.w(MediaBrowserCompat.TAG, "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                } else {
                    Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                    MediaSessionCompat.ensureClassLoader(bundle2);
                    Bundle bundle3 = data.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS);
                    MediaSessionCompat.ensureClassLoader(bundle3);
                    mediaBrowserServiceCallbackImpl.onLoadChildren(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), data.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), bundle2, bundle3);
                }
            } catch (BadParcelableException unused) {
                Log.e(MediaBrowserCompat.TAG, "Could not unparcel the data.");
                if (message.what == 1) {
                    mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
                }
            }
        }

        public void setCallbacksMessenger(Messenger messenger) {
            this.mCallbacksMessengerRef = new WeakReference<>(messenger);
        }
    }

    public static class ConnectionCallback {
        final MediaBrowser.ConnectionCallback mConnectionCallbackFwk = new ConnectionCallbackApi21();
        ConnectionCallbackInternal mConnectionCallbackInternal;

        @RequiresApi(21)
        public class ConnectionCallbackApi21 extends MediaBrowser.ConnectionCallback {
            public ConnectionCallbackApi21() {
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnected() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.mConnectionCallbackInternal;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.onConnected();
                }
                ConnectionCallback.this.onConnected();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionFailed() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.mConnectionCallbackInternal;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.onConnectionFailed();
                }
                ConnectionCallback.this.onConnectionFailed();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionSuspended() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.mConnectionCallbackInternal;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.onConnectionSuspended();
                }
                ConnectionCallback.this.onConnectionSuspended();
            }
        }

        public interface ConnectionCallbackInternal {
            void onConnected();

            void onConnectionFailed();

            void onConnectionSuspended();
        }

        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }

        public void setInternalConnectionCallback(ConnectionCallbackInternal connectionCallbackInternal) {
            this.mConnectionCallbackInternal = connectionCallbackInternal;
        }
    }

    public static abstract class CustomActionCallback {
        public void onError(String str, Bundle bundle, Bundle bundle2) {
        }

        public void onProgressUpdate(String str, Bundle bundle, Bundle bundle2) {
        }

        public void onResult(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    public static class CustomActionResultReceiver extends ResultReceiver {
        private final String mAction;
        private final CustomActionCallback mCallback;
        private final Bundle mExtras;

        public CustomActionResultReceiver(String str, Bundle bundle, CustomActionCallback customActionCallback, Handler handler) {
            super(handler);
            this.mAction = str;
            this.mExtras = bundle;
            this.mCallback = customActionCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int i10, Bundle bundle) {
            if (this.mCallback == null) {
                return;
            }
            MediaSessionCompat.ensureClassLoader(bundle);
            if (i10 == -1) {
                this.mCallback.onError(this.mAction, this.mExtras, bundle);
                return;
            }
            if (i10 == 0) {
                this.mCallback.onResult(this.mAction, this.mExtras, bundle);
                return;
            }
            if (i10 == 1) {
                this.mCallback.onProgressUpdate(this.mAction, this.mExtras, bundle);
                return;
            }
            Log.w(MediaBrowserCompat.TAG, "Unknown result code: " + i10 + " (extras=" + this.mExtras + ", resultData=" + bundle + ")");
        }
    }

    public static abstract class ItemCallback {
        final MediaBrowser.ItemCallback mItemCallbackFwk;

        @RequiresApi(23)
        public class ItemCallbackApi23 extends MediaBrowser.ItemCallback {
            public ItemCallbackApi23() {
            }

            @Override // android.media.browse.MediaBrowser.ItemCallback
            public void onError(@NonNull String str) {
                ItemCallback.this.onError(str);
            }

            @Override // android.media.browse.MediaBrowser.ItemCallback
            public void onItemLoaded(MediaBrowser.MediaItem mediaItem) {
                ItemCallback.this.onItemLoaded(MediaItem.fromMediaItem(mediaItem));
            }
        }

        public ItemCallback() {
            if (Build.VERSION.SDK_INT >= 23) {
                this.mItemCallbackFwk = new ItemCallbackApi23();
            } else {
                this.mItemCallbackFwk = null;
            }
        }

        public void onError(@NonNull String str) {
        }

        public void onItemLoaded(MediaItem mediaItem) {
        }
    }

    public static class ItemReceiver extends ResultReceiver {
        private final ItemCallback mCallback;
        private final String mMediaId;

        public ItemReceiver(String str, ItemCallback itemCallback, Handler handler) {
            super(handler);
            this.mMediaId = str;
            this.mCallback = itemCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int i10, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.unparcelWithClassLoader(bundle);
            }
            if (i10 != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM)) {
                this.mCallback.onError(this.mMediaId);
                return;
            }
            Parcelable parcelable = bundle.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                this.mCallback.onItemLoaded((MediaItem) parcelable);
            } else {
                this.mCallback.onError(this.mMediaId);
            }
        }
    }

    public interface MediaBrowserImpl {
        void connect();

        void disconnect();

        @Nullable
        Bundle getExtras();

        void getItem(@NonNull String str, @NonNull ItemCallback itemCallback);

        @Nullable
        Bundle getNotifyChildrenChangedOptions();

        @NonNull
        String getRoot();

        ComponentName getServiceComponent();

        @NonNull
        MediaSessionCompat.Token getSessionToken();

        boolean isConnected();

        void search(@NonNull String str, Bundle bundle, @NonNull SearchCallback searchCallback);

        void sendCustomAction(@NonNull String str, Bundle bundle, @Nullable CustomActionCallback customActionCallback);

        void subscribe(@NonNull String str, @Nullable Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback);

        void unsubscribe(@NonNull String str, SubscriptionCallback subscriptionCallback);
    }

    @RequiresApi(21)
    public static class MediaBrowserImplApi21 implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl, ConnectionCallback.ConnectionCallbackInternal {
        protected final MediaBrowser mBrowserFwk;
        protected Messenger mCallbacksMessenger;
        final Context mContext;
        private MediaSessionCompat.Token mMediaSessionToken;
        private Bundle mNotifyChildrenChangedOptions;
        protected final Bundle mRootHints;
        protected ServiceBinderWrapper mServiceBinderWrapper;
        protected int mServiceVersion;
        protected final CallbackHandler mHandler = new CallbackHandler(this);
        private final ArrayMap<String, Subscription> mSubscriptions = new ArrayMap<>();

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$1 */
        public class AnonymousClass1 implements Runnable {
            final /* synthetic */ ItemCallback val$cb;
            final /* synthetic */ String val$mediaId;

            public AnonymousClass1(ItemCallback itemCallback, String str) {
                itemCallback = itemCallback;
                str = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                itemCallback.onError(str);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$2 */
        public class AnonymousClass2 implements Runnable {
            final /* synthetic */ ItemCallback val$cb;
            final /* synthetic */ String val$mediaId;

            public AnonymousClass2(ItemCallback itemCallback, String str) {
                itemCallback = itemCallback;
                str = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                itemCallback.onError(str);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$3 */
        public class AnonymousClass3 implements Runnable {
            final /* synthetic */ ItemCallback val$cb;
            final /* synthetic */ String val$mediaId;

            public AnonymousClass3(ItemCallback itemCallback, String str) {
                itemCallback = itemCallback;
                str = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                itemCallback.onError(str);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$4 */
        public class AnonymousClass4 implements Runnable {
            final /* synthetic */ SearchCallback val$callback;
            final /* synthetic */ Bundle val$extras;
            final /* synthetic */ String val$query;

            public AnonymousClass4(SearchCallback searchCallback, String str, Bundle bundle) {
                searchCallback = searchCallback;
                str = str;
                bundle = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                searchCallback.onError(str, bundle);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$5 */
        public class AnonymousClass5 implements Runnable {
            final /* synthetic */ SearchCallback val$callback;
            final /* synthetic */ Bundle val$extras;
            final /* synthetic */ String val$query;

            public AnonymousClass5(SearchCallback searchCallback, String str, Bundle bundle) {
                searchCallback = searchCallback;
                str = str;
                bundle = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                searchCallback.onError(str, bundle);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$6 */
        public class AnonymousClass6 implements Runnable {
            final /* synthetic */ String val$action;
            final /* synthetic */ CustomActionCallback val$callback;
            final /* synthetic */ Bundle val$extras;

            public AnonymousClass6(CustomActionCallback customActionCallback, String str, Bundle bundle) {
                customActionCallback = customActionCallback;
                str = str;
                bundle = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                customActionCallback.onError(str, bundle, null);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$7 */
        public class AnonymousClass7 implements Runnable {
            final /* synthetic */ String val$action;
            final /* synthetic */ CustomActionCallback val$callback;
            final /* synthetic */ Bundle val$extras;

            public AnonymousClass7(CustomActionCallback customActionCallback, String str, Bundle bundle) {
                customActionCallback = customActionCallback;
                str = str;
                bundle = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                customActionCallback.onError(str, bundle, null);
            }
        }

        public MediaBrowserImplApi21(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            this.mContext = context;
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            this.mRootHints = bundle2;
            bundle2.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            bundle2.putInt(MediaBrowserProtocol.EXTRA_CALLING_PID, Process.myPid());
            connectionCallback.setInternalConnectionCallback(this);
            this.mBrowserFwk = new MediaBrowser(context, componentName, connectionCallback.mConnectionCallbackFwk, bundle2);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            this.mBrowserFwk.connect();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            Messenger messenger;
            ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (serviceBinderWrapper != null && (messenger = this.mCallbacksMessenger) != null) {
                try {
                    serviceBinderWrapper.unregisterCallbackMessenger(messenger);
                } catch (RemoteException unused) {
                    Log.i(MediaBrowserCompat.TAG, "Remote error unregistering client messenger.");
                }
            }
            this.mBrowserFwk.disconnect();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @Nullable
        public Bundle getExtras() {
            return this.mBrowserFwk.getExtras();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(@NonNull String str, @NonNull ItemCallback itemCallback) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("mediaId is empty");
            }
            if (itemCallback == null) {
                throw new IllegalArgumentException("cb is null");
            }
            if (!this.mBrowserFwk.isConnected()) {
                Log.i(MediaBrowserCompat.TAG, "Not connected, unable to retrieve the MediaItem.");
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.1
                    final /* synthetic */ ItemCallback val$cb;
                    final /* synthetic */ String val$mediaId;

                    public AnonymousClass1(ItemCallback itemCallback2, String str2) {
                        itemCallback = itemCallback2;
                        str = str2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
                return;
            }
            if (this.mServiceBinderWrapper == null) {
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.2
                    final /* synthetic */ ItemCallback val$cb;
                    final /* synthetic */ String val$mediaId;

                    public AnonymousClass2(ItemCallback itemCallback2, String str2) {
                        itemCallback = itemCallback2;
                        str = str2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
                return;
            }
            try {
                this.mServiceBinderWrapper.getMediaItem(str2, new ItemReceiver(str2, itemCallback2, this.mHandler), this.mCallbacksMessenger);
            } catch (RemoteException unused) {
                Log.i(MediaBrowserCompat.TAG, "Remote error getting media item: " + str2);
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.3
                    final /* synthetic */ ItemCallback val$cb;
                    final /* synthetic */ String val$mediaId;

                    public AnonymousClass3(ItemCallback itemCallback2, String str2) {
                        itemCallback = itemCallback2;
                        str = str2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public String getRoot() {
            return this.mBrowserFwk.getRoot();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public ComponentName getServiceComponent() {
            return this.mBrowserFwk.getServiceComponent();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public MediaSessionCompat.Token getSessionToken() {
            if (this.mMediaSessionToken == null) {
                this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(this.mBrowserFwk.getSessionToken());
            }
            return this.mMediaSessionToken;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            return this.mBrowserFwk.isConnected();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnected() {
            try {
                Bundle extras = this.mBrowserFwk.getExtras();
                if (extras == null) {
                    return;
                }
                this.mServiceVersion = extras.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
                IBinder binder = BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
                if (binder != null) {
                    this.mServiceBinderWrapper = new ServiceBinderWrapper(binder, this.mRootHints);
                    Messenger messenger = new Messenger(this.mHandler);
                    this.mCallbacksMessenger = messenger;
                    this.mHandler.setCallbacksMessenger(messenger);
                    try {
                        this.mServiceBinderWrapper.registerCallbackMessenger(this.mContext, this.mCallbacksMessenger);
                    } catch (RemoteException unused) {
                        Log.i(MediaBrowserCompat.TAG, "Remote error registering client messenger.");
                    }
                }
                IMediaSession asInterface = IMediaSession.Stub.asInterface(BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_SESSION_BINDER));
                if (asInterface != null) {
                    this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(this.mBrowserFwk.getSessionToken(), asInterface);
                }
            } catch (IllegalStateException e10) {
                Log.e(MediaBrowserCompat.TAG, "Unexpected IllegalStateException", e10);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionFailed() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionSuspended() {
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mMediaSessionToken = null;
            this.mHandler.setCallbacksMessenger(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(Messenger messenger, String str, List<MediaItem> list, Bundle bundle, Bundle bundle2) {
            if (this.mCallbacksMessenger != messenger) {
                return;
            }
            Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                if (MediaBrowserCompat.DEBUG) {
                    Log.d(MediaBrowserCompat.TAG, "onLoadChildren for id that isn't subscribed id=" + str);
                    return;
                }
                return;
            }
            SubscriptionCallback callback = subscription.getCallback(bundle);
            if (callback != null) {
                if (bundle == null) {
                    if (list == null) {
                        callback.onError(str);
                        return;
                    }
                    this.mNotifyChildrenChangedOptions = bundle2;
                    callback.onChildrenLoaded(str, list);
                    this.mNotifyChildrenChangedOptions = null;
                    return;
                }
                if (list == null) {
                    callback.onError(str, bundle);
                    return;
                }
                this.mNotifyChildrenChangedOptions = bundle2;
                callback.onChildrenLoaded(str, list, bundle);
                this.mNotifyChildrenChangedOptions = null;
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(@NonNull String str, Bundle bundle, @NonNull SearchCallback searchCallback) {
            if (!isConnected()) {
                throw new IllegalStateException("search() called while not connected");
            }
            if (this.mServiceBinderWrapper == null) {
                Log.i(MediaBrowserCompat.TAG, "The connected service doesn't support search.");
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.4
                    final /* synthetic */ SearchCallback val$callback;
                    final /* synthetic */ Bundle val$extras;
                    final /* synthetic */ String val$query;

                    public AnonymousClass4(SearchCallback searchCallback2, String str2, Bundle bundle2) {
                        searchCallback = searchCallback2;
                        str = str2;
                        bundle = bundle2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        searchCallback.onError(str, bundle);
                    }
                });
                return;
            }
            try {
                this.mServiceBinderWrapper.search(str2, bundle2, new SearchResultReceiver(str2, bundle2, searchCallback2, this.mHandler), this.mCallbacksMessenger);
            } catch (RemoteException e10) {
                Log.i(MediaBrowserCompat.TAG, "Remote error searching items with query: " + str2, e10);
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.5
                    final /* synthetic */ SearchCallback val$callback;
                    final /* synthetic */ Bundle val$extras;
                    final /* synthetic */ String val$query;

                    public AnonymousClass5(SearchCallback searchCallback2, String str2, Bundle bundle2) {
                        searchCallback = searchCallback2;
                        str = str2;
                        bundle = bundle2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        searchCallback.onError(str, bundle);
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(@NonNull String str, Bundle bundle, @Nullable CustomActionCallback customActionCallback) {
            if (!isConnected()) {
                throw new IllegalStateException("Cannot send a custom action (" + str + ") with extras " + bundle + " because the browser is not connected to the service.");
            }
            if (this.mServiceBinderWrapper == null) {
                Log.i(MediaBrowserCompat.TAG, "The connected service doesn't support sendCustomAction.");
                if (customActionCallback != null) {
                    this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.6
                        final /* synthetic */ String val$action;
                        final /* synthetic */ CustomActionCallback val$callback;
                        final /* synthetic */ Bundle val$extras;

                        public AnonymousClass6(CustomActionCallback customActionCallback2, String str2, Bundle bundle2) {
                            customActionCallback = customActionCallback2;
                            str = str2;
                            bundle = bundle2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            customActionCallback.onError(str, bundle, null);
                        }
                    });
                }
            }
            try {
                this.mServiceBinderWrapper.sendCustomAction(str2, bundle2, new CustomActionResultReceiver(str2, bundle2, customActionCallback2, this.mHandler), this.mCallbacksMessenger);
            } catch (RemoteException e10) {
                Log.i(MediaBrowserCompat.TAG, "Remote error sending a custom action: action=" + str2 + ", extras=" + bundle2, e10);
                if (customActionCallback2 != null) {
                    this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.7
                        final /* synthetic */ String val$action;
                        final /* synthetic */ CustomActionCallback val$callback;
                        final /* synthetic */ Bundle val$extras;

                        public AnonymousClass7(CustomActionCallback customActionCallback2, String str2, Bundle bundle2) {
                            customActionCallback = customActionCallback2;
                            str = str2;
                            bundle = bundle2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            customActionCallback.onError(str, bundle, null);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(@NonNull String str, Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback) {
            Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                subscription = new Subscription();
                this.mSubscriptions.put(str, subscription);
            }
            subscriptionCallback.setSubscription(subscription);
            Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
            subscription.putCallback(bundle2, subscriptionCallback);
            ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (serviceBinderWrapper == null) {
                this.mBrowserFwk.subscribe(str, subscriptionCallback.mSubscriptionCallbackFwk);
                return;
            }
            try {
                serviceBinderWrapper.addSubscription(str, subscriptionCallback.mToken, bundle2, this.mCallbacksMessenger);
            } catch (RemoteException unused) {
                Log.i(MediaBrowserCompat.TAG, "Remote error subscribing media item: " + str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(@NonNull String str, SubscriptionCallback subscriptionCallback) {
            Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                return;
            }
            ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (serviceBinderWrapper != null) {
                try {
                    if (subscriptionCallback == null) {
                        serviceBinderWrapper.removeSubscription(str, null, this.mCallbacksMessenger);
                    } else {
                        List<SubscriptionCallback> callbacks = subscription.getCallbacks();
                        List<Bundle> optionsList = subscription.getOptionsList();
                        for (int size = callbacks.size() - 1; size >= 0; size--) {
                            if (callbacks.get(size) == subscriptionCallback) {
                                this.mServiceBinderWrapper.removeSubscription(str, subscriptionCallback.mToken, this.mCallbacksMessenger);
                                callbacks.remove(size);
                                optionsList.remove(size);
                            }
                        }
                    }
                } catch (RemoteException unused) {
                    Log.d(MediaBrowserCompat.TAG, "removeSubscription failed with RemoteException parentId=" + str);
                }
            } else if (subscriptionCallback == null) {
                this.mBrowserFwk.unsubscribe(str);
            } else {
                List<SubscriptionCallback> callbacks2 = subscription.getCallbacks();
                List<Bundle> optionsList2 = subscription.getOptionsList();
                for (int size2 = callbacks2.size() - 1; size2 >= 0; size2--) {
                    if (callbacks2.get(size2) == subscriptionCallback) {
                        callbacks2.remove(size2);
                        optionsList2.remove(size2);
                    }
                }
                if (callbacks2.size() == 0) {
                    this.mBrowserFwk.unsubscribe(str);
                }
            }
            if (subscription.isEmpty() || subscriptionCallback == null) {
                this.mSubscriptions.remove(str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(Messenger messenger) {
        }
    }

    @RequiresApi(23)
    public static class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
        public MediaBrowserImplApi23(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(@NonNull String str, @NonNull ItemCallback itemCallback) {
            if (this.mServiceBinderWrapper == null) {
                this.mBrowserFwk.getItem(str, itemCallback.mItemCallbackFwk);
            } else {
                super.getItem(str, itemCallback);
            }
        }
    }

    @RequiresApi(26)
    public static class MediaBrowserImplApi26 extends MediaBrowserImplApi23 {
        public MediaBrowserImplApi26(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(@NonNull String str, @Nullable Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback) {
            if (this.mServiceBinderWrapper != null && this.mServiceVersion >= 2) {
                super.subscribe(str, bundle, subscriptionCallback);
            } else if (bundle == null) {
                this.mBrowserFwk.subscribe(str, subscriptionCallback.mSubscriptionCallbackFwk);
            } else {
                this.mBrowserFwk.subscribe(str, bundle, subscriptionCallback.mSubscriptionCallbackFwk);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(@NonNull String str, SubscriptionCallback subscriptionCallback) {
            if (this.mServiceBinderWrapper != null && this.mServiceVersion >= 2) {
                super.unsubscribe(str, subscriptionCallback);
            } else if (subscriptionCallback == null) {
                this.mBrowserFwk.unsubscribe(str);
            } else {
                this.mBrowserFwk.unsubscribe(str, subscriptionCallback.mSubscriptionCallbackFwk);
            }
        }
    }

    public static class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {
        static final int CONNECT_STATE_CONNECTED = 3;
        static final int CONNECT_STATE_CONNECTING = 2;
        static final int CONNECT_STATE_DISCONNECTED = 1;
        static final int CONNECT_STATE_DISCONNECTING = 0;
        static final int CONNECT_STATE_SUSPENDED = 4;
        final ConnectionCallback mCallback;
        Messenger mCallbacksMessenger;
        final Context mContext;
        private Bundle mExtras;
        private MediaSessionCompat.Token mMediaSessionToken;
        private Bundle mNotifyChildrenChangedOptions;
        final Bundle mRootHints;
        private String mRootId;
        ServiceBinderWrapper mServiceBinderWrapper;
        final ComponentName mServiceComponent;
        MediaServiceConnection mServiceConnection;
        final CallbackHandler mHandler = new CallbackHandler(this);
        private final ArrayMap<String, Subscription> mSubscriptions = new ArrayMap<>();
        int mState = 1;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z10;
                MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                if (mediaBrowserImplBase.mState == 0) {
                    return;
                }
                mediaBrowserImplBase.mState = 2;
                if (MediaBrowserCompat.DEBUG && mediaBrowserImplBase.mServiceConnection != null) {
                    throw new RuntimeException("mServiceConnection should be null. Instead it is " + MediaBrowserImplBase.this.mServiceConnection);
                }
                if (mediaBrowserImplBase.mServiceBinderWrapper != null) {
                    throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + MediaBrowserImplBase.this.mServiceBinderWrapper);
                }
                if (mediaBrowserImplBase.mCallbacksMessenger != null) {
                    throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + MediaBrowserImplBase.this.mCallbacksMessenger);
                }
                Intent intent = new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE);
                intent.setComponent(MediaBrowserImplBase.this.mServiceComponent);
                MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                mediaBrowserImplBase2.mServiceConnection = mediaBrowserImplBase2.new MediaServiceConnection();
                try {
                    MediaBrowserImplBase mediaBrowserImplBase3 = MediaBrowserImplBase.this;
                    z10 = mediaBrowserImplBase3.mContext.bindService(intent, mediaBrowserImplBase3.mServiceConnection, 1);
                } catch (Exception unused) {
                    Log.e(MediaBrowserCompat.TAG, "Failed binding to service " + MediaBrowserImplBase.this.mServiceComponent);
                    z10 = false;
                }
                if (!z10) {
                    MediaBrowserImplBase.this.forceCloseConnection();
                    MediaBrowserImplBase.this.mCallback.onConnectionFailed();
                }
                if (MediaBrowserCompat.DEBUG) {
                    Log.d(MediaBrowserCompat.TAG, "connect...");
                    MediaBrowserImplBase.this.dump();
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$2 */
        public class AnonymousClass2 implements Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                Messenger messenger = mediaBrowserImplBase.mCallbacksMessenger;
                if (messenger != null) {
                    try {
                        mediaBrowserImplBase.mServiceBinderWrapper.disconnect(messenger);
                    } catch (RemoteException unused) {
                        Log.w(MediaBrowserCompat.TAG, "RemoteException during connect for " + MediaBrowserImplBase.this.mServiceComponent);
                    }
                }
                MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                int i10 = mediaBrowserImplBase2.mState;
                mediaBrowserImplBase2.forceCloseConnection();
                if (i10 != 0) {
                    MediaBrowserImplBase.this.mState = i10;
                }
                if (MediaBrowserCompat.DEBUG) {
                    Log.d(MediaBrowserCompat.TAG, "disconnect...");
                    MediaBrowserImplBase.this.dump();
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$3 */
        public class AnonymousClass3 implements Runnable {
            final /* synthetic */ ItemCallback val$cb;
            final /* synthetic */ String val$mediaId;

            public AnonymousClass3(ItemCallback itemCallback, String str) {
                itemCallback = itemCallback;
                str = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                itemCallback.onError(str);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$4 */
        public class AnonymousClass4 implements Runnable {
            final /* synthetic */ ItemCallback val$cb;
            final /* synthetic */ String val$mediaId;

            public AnonymousClass4(ItemCallback itemCallback, String str) {
                itemCallback = itemCallback;
                str = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                itemCallback.onError(str);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$5 */
        public class AnonymousClass5 implements Runnable {
            final /* synthetic */ SearchCallback val$callback;
            final /* synthetic */ Bundle val$extras;
            final /* synthetic */ String val$query;

            public AnonymousClass5(SearchCallback searchCallback, String str, Bundle bundle) {
                searchCallback = searchCallback;
                str = str;
                bundle = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                searchCallback.onError(str, bundle);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$6 */
        public class AnonymousClass6 implements Runnable {
            final /* synthetic */ String val$action;
            final /* synthetic */ CustomActionCallback val$callback;
            final /* synthetic */ Bundle val$extras;

            public AnonymousClass6(CustomActionCallback customActionCallback, String str, Bundle bundle) {
                customActionCallback = customActionCallback;
                str = str;
                bundle = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                customActionCallback.onError(str, bundle, null);
            }
        }

        public class MediaServiceConnection implements ServiceConnection {

            /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$1 */
            public class AnonymousClass1 implements Runnable {
                final /* synthetic */ IBinder val$binder;
                final /* synthetic */ ComponentName val$name;

                public AnonymousClass1(ComponentName componentName, IBinder iBinder) {
                    componentName = componentName;
                    iBinder = iBinder;
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean z10 = MediaBrowserCompat.DEBUG;
                    if (z10) {
                        Log.d(MediaBrowserCompat.TAG, "MediaServiceConnection.onServiceConnected name=" + componentName + " binder=" + iBinder);
                        MediaBrowserImplBase.this.dump();
                    }
                    if (MediaServiceConnection.this.isCurrent("onServiceConnected")) {
                        MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                        mediaBrowserImplBase.mServiceBinderWrapper = new ServiceBinderWrapper(iBinder, mediaBrowserImplBase.mRootHints);
                        MediaBrowserImplBase.this.mCallbacksMessenger = new Messenger(MediaBrowserImplBase.this.mHandler);
                        MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                        mediaBrowserImplBase2.mHandler.setCallbacksMessenger(mediaBrowserImplBase2.mCallbacksMessenger);
                        MediaBrowserImplBase.this.mState = 2;
                        if (z10) {
                            try {
                                Log.d(MediaBrowserCompat.TAG, "ServiceCallbacks.onConnect...");
                                MediaBrowserImplBase.this.dump();
                            } catch (RemoteException unused) {
                                Log.w(MediaBrowserCompat.TAG, "RemoteException during connect for " + MediaBrowserImplBase.this.mServiceComponent);
                                if (MediaBrowserCompat.DEBUG) {
                                    Log.d(MediaBrowserCompat.TAG, "ServiceCallbacks.onConnect...");
                                    MediaBrowserImplBase.this.dump();
                                    return;
                                }
                                return;
                            }
                        }
                        MediaBrowserImplBase mediaBrowserImplBase3 = MediaBrowserImplBase.this;
                        mediaBrowserImplBase3.mServiceBinderWrapper.connect(mediaBrowserImplBase3.mContext, mediaBrowserImplBase3.mCallbacksMessenger);
                    }
                }
            }

            /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$2 */
            public class AnonymousClass2 implements Runnable {
                final /* synthetic */ ComponentName val$name;

                public AnonymousClass2(ComponentName componentName) {
                    componentName = componentName;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (MediaBrowserCompat.DEBUG) {
                        Log.d(MediaBrowserCompat.TAG, "MediaServiceConnection.onServiceDisconnected name=" + componentName + " this=" + this + " mServiceConnection=" + MediaBrowserImplBase.this.mServiceConnection);
                        MediaBrowserImplBase.this.dump();
                    }
                    if (MediaServiceConnection.this.isCurrent("onServiceDisconnected")) {
                        MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                        mediaBrowserImplBase.mServiceBinderWrapper = null;
                        mediaBrowserImplBase.mCallbacksMessenger = null;
                        mediaBrowserImplBase.mHandler.setCallbacksMessenger(null);
                        MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                        mediaBrowserImplBase2.mState = 4;
                        mediaBrowserImplBase2.mCallback.onConnectionSuspended();
                    }
                }
            }

            public MediaServiceConnection() {
            }

            private void postOrRun(Runnable runnable) {
                if (Thread.currentThread() == MediaBrowserImplBase.this.mHandler.getLooper().getThread()) {
                    runnable.run();
                } else {
                    MediaBrowserImplBase.this.mHandler.post(runnable);
                }
            }

            public boolean isCurrent(String str) {
                int i10;
                MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                if (mediaBrowserImplBase.mServiceConnection == this && (i10 = mediaBrowserImplBase.mState) != 0 && i10 != 1) {
                    return true;
                }
                int i11 = mediaBrowserImplBase.mState;
                if (i11 == 0 || i11 == 1) {
                    return false;
                }
                Log.i(MediaBrowserCompat.TAG, str + " for " + MediaBrowserImplBase.this.mServiceComponent + " with mServiceConnection=" + MediaBrowserImplBase.this.mServiceConnection + " this=" + this);
                return false;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                postOrRun(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.1
                    final /* synthetic */ IBinder val$binder;
                    final /* synthetic */ ComponentName val$name;

                    public AnonymousClass1(ComponentName componentName2, IBinder iBinder2) {
                        componentName = componentName2;
                        iBinder = iBinder2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z10 = MediaBrowserCompat.DEBUG;
                        if (z10) {
                            Log.d(MediaBrowserCompat.TAG, "MediaServiceConnection.onServiceConnected name=" + componentName + " binder=" + iBinder);
                            MediaBrowserImplBase.this.dump();
                        }
                        if (MediaServiceConnection.this.isCurrent("onServiceConnected")) {
                            MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                            mediaBrowserImplBase.mServiceBinderWrapper = new ServiceBinderWrapper(iBinder, mediaBrowserImplBase.mRootHints);
                            MediaBrowserImplBase.this.mCallbacksMessenger = new Messenger(MediaBrowserImplBase.this.mHandler);
                            MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                            mediaBrowserImplBase2.mHandler.setCallbacksMessenger(mediaBrowserImplBase2.mCallbacksMessenger);
                            MediaBrowserImplBase.this.mState = 2;
                            if (z10) {
                                try {
                                    Log.d(MediaBrowserCompat.TAG, "ServiceCallbacks.onConnect...");
                                    MediaBrowserImplBase.this.dump();
                                } catch (RemoteException unused) {
                                    Log.w(MediaBrowserCompat.TAG, "RemoteException during connect for " + MediaBrowserImplBase.this.mServiceComponent);
                                    if (MediaBrowserCompat.DEBUG) {
                                        Log.d(MediaBrowserCompat.TAG, "ServiceCallbacks.onConnect...");
                                        MediaBrowserImplBase.this.dump();
                                        return;
                                    }
                                    return;
                                }
                            }
                            MediaBrowserImplBase mediaBrowserImplBase3 = MediaBrowserImplBase.this;
                            mediaBrowserImplBase3.mServiceBinderWrapper.connect(mediaBrowserImplBase3.mContext, mediaBrowserImplBase3.mCallbacksMessenger);
                        }
                    }
                });
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                postOrRun(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.2
                    final /* synthetic */ ComponentName val$name;

                    public AnonymousClass2(ComponentName componentName2) {
                        componentName = componentName2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaBrowserCompat.DEBUG) {
                            Log.d(MediaBrowserCompat.TAG, "MediaServiceConnection.onServiceDisconnected name=" + componentName + " this=" + this + " mServiceConnection=" + MediaBrowserImplBase.this.mServiceConnection);
                            MediaBrowserImplBase.this.dump();
                        }
                        if (MediaServiceConnection.this.isCurrent("onServiceDisconnected")) {
                            MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                            mediaBrowserImplBase.mServiceBinderWrapper = null;
                            mediaBrowserImplBase.mCallbacksMessenger = null;
                            mediaBrowserImplBase.mHandler.setCallbacksMessenger(null);
                            MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                            mediaBrowserImplBase2.mState = 4;
                            mediaBrowserImplBase2.mCallback.onConnectionSuspended();
                        }
                    }
                });
            }
        }

        public MediaBrowserImplBase(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            }
            if (componentName == null) {
                throw new IllegalArgumentException("service component must not be null");
            }
            if (connectionCallback == null) {
                throw new IllegalArgumentException("connection callback must not be null");
            }
            this.mContext = context;
            this.mServiceComponent = componentName;
            this.mCallback = connectionCallback;
            this.mRootHints = bundle == null ? null : new Bundle(bundle);
        }

        private static String getStateLabel(int i10) {
            if (i10 == 0) {
                return "CONNECT_STATE_DISCONNECTING";
            }
            if (i10 == 1) {
                return "CONNECT_STATE_DISCONNECTED";
            }
            if (i10 == 2) {
                return "CONNECT_STATE_CONNECTING";
            }
            if (i10 == 3) {
                return "CONNECT_STATE_CONNECTED";
            }
            if (i10 == 4) {
                return "CONNECT_STATE_SUSPENDED";
            }
            return "UNKNOWN/" + i10;
        }

        private boolean isCurrent(Messenger messenger, String str) {
            int i10;
            if (this.mCallbacksMessenger == messenger && (i10 = this.mState) != 0 && i10 != 1) {
                return true;
            }
            int i11 = this.mState;
            if (i11 == 0 || i11 == 1) {
                return false;
            }
            Log.i(MediaBrowserCompat.TAG, str + " for " + this.mServiceComponent + " with mCallbacksMessenger=" + this.mCallbacksMessenger + " this=" + this);
            return false;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            int i10 = this.mState;
            if (i10 == 0 || i10 == 1) {
                this.mState = 2;
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.1
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z10;
                        MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                        if (mediaBrowserImplBase.mState == 0) {
                            return;
                        }
                        mediaBrowserImplBase.mState = 2;
                        if (MediaBrowserCompat.DEBUG && mediaBrowserImplBase.mServiceConnection != null) {
                            throw new RuntimeException("mServiceConnection should be null. Instead it is " + MediaBrowserImplBase.this.mServiceConnection);
                        }
                        if (mediaBrowserImplBase.mServiceBinderWrapper != null) {
                            throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + MediaBrowserImplBase.this.mServiceBinderWrapper);
                        }
                        if (mediaBrowserImplBase.mCallbacksMessenger != null) {
                            throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + MediaBrowserImplBase.this.mCallbacksMessenger);
                        }
                        Intent intent = new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE);
                        intent.setComponent(MediaBrowserImplBase.this.mServiceComponent);
                        MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                        mediaBrowserImplBase2.mServiceConnection = mediaBrowserImplBase2.new MediaServiceConnection();
                        try {
                            MediaBrowserImplBase mediaBrowserImplBase3 = MediaBrowserImplBase.this;
                            z10 = mediaBrowserImplBase3.mContext.bindService(intent, mediaBrowserImplBase3.mServiceConnection, 1);
                        } catch (Exception unused) {
                            Log.e(MediaBrowserCompat.TAG, "Failed binding to service " + MediaBrowserImplBase.this.mServiceComponent);
                            z10 = false;
                        }
                        if (!z10) {
                            MediaBrowserImplBase.this.forceCloseConnection();
                            MediaBrowserImplBase.this.mCallback.onConnectionFailed();
                        }
                        if (MediaBrowserCompat.DEBUG) {
                            Log.d(MediaBrowserCompat.TAG, "connect...");
                            MediaBrowserImplBase.this.dump();
                        }
                    }
                });
            } else {
                throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + getStateLabel(this.mState) + ")");
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            this.mState = 0;
            this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.2
                public AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                    Messenger messenger = mediaBrowserImplBase.mCallbacksMessenger;
                    if (messenger != null) {
                        try {
                            mediaBrowserImplBase.mServiceBinderWrapper.disconnect(messenger);
                        } catch (RemoteException unused) {
                            Log.w(MediaBrowserCompat.TAG, "RemoteException during connect for " + MediaBrowserImplBase.this.mServiceComponent);
                        }
                    }
                    MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                    int i10 = mediaBrowserImplBase2.mState;
                    mediaBrowserImplBase2.forceCloseConnection();
                    if (i10 != 0) {
                        MediaBrowserImplBase.this.mState = i10;
                    }
                    if (MediaBrowserCompat.DEBUG) {
                        Log.d(MediaBrowserCompat.TAG, "disconnect...");
                        MediaBrowserImplBase.this.dump();
                    }
                }
            });
        }

        public void dump() {
            Log.d(MediaBrowserCompat.TAG, "MediaBrowserCompat...");
            Log.d(MediaBrowserCompat.TAG, "  mServiceComponent=" + this.mServiceComponent);
            Log.d(MediaBrowserCompat.TAG, "  mCallback=" + this.mCallback);
            Log.d(MediaBrowserCompat.TAG, "  mRootHints=" + this.mRootHints);
            Log.d(MediaBrowserCompat.TAG, "  mState=" + getStateLabel(this.mState));
            Log.d(MediaBrowserCompat.TAG, "  mServiceConnection=" + this.mServiceConnection);
            Log.d(MediaBrowserCompat.TAG, "  mServiceBinderWrapper=" + this.mServiceBinderWrapper);
            Log.d(MediaBrowserCompat.TAG, "  mCallbacksMessenger=" + this.mCallbacksMessenger);
            Log.d(MediaBrowserCompat.TAG, "  mRootId=" + this.mRootId);
            Log.d(MediaBrowserCompat.TAG, "  mMediaSessionToken=" + this.mMediaSessionToken);
        }

        public void forceCloseConnection() {
            MediaServiceConnection mediaServiceConnection = this.mServiceConnection;
            if (mediaServiceConnection != null) {
                this.mContext.unbindService(mediaServiceConnection);
            }
            this.mState = 1;
            this.mServiceConnection = null;
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mHandler.setCallbacksMessenger(null);
            this.mRootId = null;
            this.mMediaSessionToken = null;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @Nullable
        public Bundle getExtras() {
            if (isConnected()) {
                return this.mExtras;
            }
            throw new IllegalStateException("getExtras() called while not connected (state=" + getStateLabel(this.mState) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(@NonNull String str, @NonNull ItemCallback itemCallback) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("mediaId is empty");
            }
            if (itemCallback == null) {
                throw new IllegalArgumentException("cb is null");
            }
            if (!isConnected()) {
                Log.i(MediaBrowserCompat.TAG, "Not connected, unable to retrieve the MediaItem.");
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.3
                    final /* synthetic */ ItemCallback val$cb;
                    final /* synthetic */ String val$mediaId;

                    public AnonymousClass3(ItemCallback itemCallback2, String str2) {
                        itemCallback = itemCallback2;
                        str = str2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
                return;
            }
            try {
                this.mServiceBinderWrapper.getMediaItem(str2, new ItemReceiver(str2, itemCallback2, this.mHandler), this.mCallbacksMessenger);
            } catch (RemoteException unused) {
                Log.i(MediaBrowserCompat.TAG, "Remote error getting media item: " + str2);
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.4
                    final /* synthetic */ ItemCallback val$cb;
                    final /* synthetic */ String val$mediaId;

                    public AnonymousClass4(ItemCallback itemCallback2, String str2) {
                        itemCallback = itemCallback2;
                        str = str2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public String getRoot() {
            if (isConnected()) {
                return this.mRootId;
            }
            throw new IllegalStateException("getRoot() called while not connected(state=" + getStateLabel(this.mState) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public ComponentName getServiceComponent() {
            if (isConnected()) {
                return this.mServiceComponent;
            }
            throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.mState + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public MediaSessionCompat.Token getSessionToken() {
            if (isConnected()) {
                return this.mMediaSessionToken;
            }
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            return this.mState == 3;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(Messenger messenger) {
            Log.e(MediaBrowserCompat.TAG, "onConnectFailed for " + this.mServiceComponent);
            if (isCurrent(messenger, "onConnectFailed")) {
                if (this.mState == 2) {
                    forceCloseConnection();
                    this.mCallback.onConnectionFailed();
                    return;
                }
                Log.w(MediaBrowserCompat.TAG, "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(Messenger messenger, String str, List<MediaItem> list, Bundle bundle, Bundle bundle2) {
            if (isCurrent(messenger, "onLoadChildren")) {
                boolean z10 = MediaBrowserCompat.DEBUG;
                if (z10) {
                    Log.d(MediaBrowserCompat.TAG, "onLoadChildren for " + this.mServiceComponent + " id=" + str);
                }
                Subscription subscription = this.mSubscriptions.get(str);
                if (subscription == null) {
                    if (z10) {
                        Log.d(MediaBrowserCompat.TAG, "onLoadChildren for id that isn't subscribed id=" + str);
                        return;
                    }
                    return;
                }
                SubscriptionCallback callback = subscription.getCallback(bundle);
                if (callback != null) {
                    if (bundle == null) {
                        if (list == null) {
                            callback.onError(str);
                            return;
                        }
                        this.mNotifyChildrenChangedOptions = bundle2;
                        callback.onChildrenLoaded(str, list);
                        this.mNotifyChildrenChangedOptions = null;
                        return;
                    }
                    if (list == null) {
                        callback.onError(str, bundle);
                        return;
                    }
                    this.mNotifyChildrenChangedOptions = bundle2;
                    callback.onChildrenLoaded(str, list, bundle);
                    this.mNotifyChildrenChangedOptions = null;
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
            if (isCurrent(messenger, "onConnect")) {
                if (this.mState != 2) {
                    Log.w(MediaBrowserCompat.TAG, "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
                    return;
                }
                this.mRootId = str;
                this.mMediaSessionToken = token;
                this.mExtras = bundle;
                this.mState = 3;
                if (MediaBrowserCompat.DEBUG) {
                    Log.d(MediaBrowserCompat.TAG, "ServiceCallbacks.onConnect...");
                    dump();
                }
                this.mCallback.onConnected();
                try {
                    for (Map.Entry<String, Subscription> entry : this.mSubscriptions.entrySet()) {
                        String key = entry.getKey();
                        Subscription value = entry.getValue();
                        List<SubscriptionCallback> callbacks = value.getCallbacks();
                        List<Bundle> optionsList = value.getOptionsList();
                        for (int i10 = 0; i10 < callbacks.size(); i10++) {
                            this.mServiceBinderWrapper.addSubscription(key, callbacks.get(i10).mToken, optionsList.get(i10), this.mCallbacksMessenger);
                        }
                    }
                } catch (RemoteException unused) {
                    Log.d(MediaBrowserCompat.TAG, "addSubscription failed with RemoteException.");
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(@NonNull String str, Bundle bundle, @NonNull SearchCallback searchCallback) {
            if (!isConnected()) {
                throw new IllegalStateException("search() called while not connected (state=" + getStateLabel(this.mState) + ")");
            }
            try {
                this.mServiceBinderWrapper.search(str, bundle, new SearchResultReceiver(str, bundle, searchCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (RemoteException e10) {
                Log.i(MediaBrowserCompat.TAG, "Remote error searching items with query: " + str, e10);
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.5
                    final /* synthetic */ SearchCallback val$callback;
                    final /* synthetic */ Bundle val$extras;
                    final /* synthetic */ String val$query;

                    public AnonymousClass5(SearchCallback searchCallback2, String str2, Bundle bundle2) {
                        searchCallback = searchCallback2;
                        str = str2;
                        bundle = bundle2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        searchCallback.onError(str, bundle);
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(@NonNull String str, Bundle bundle, @Nullable CustomActionCallback customActionCallback) {
            if (!isConnected()) {
                throw new IllegalStateException("Cannot send a custom action (" + str + ") with extras " + bundle + " because the browser is not connected to the service.");
            }
            try {
                this.mServiceBinderWrapper.sendCustomAction(str, bundle, new CustomActionResultReceiver(str, bundle, customActionCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (RemoteException e10) {
                Log.i(MediaBrowserCompat.TAG, "Remote error sending a custom action: action=" + str + ", extras=" + bundle, e10);
                if (customActionCallback != null) {
                    this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.6
                        final /* synthetic */ String val$action;
                        final /* synthetic */ CustomActionCallback val$callback;
                        final /* synthetic */ Bundle val$extras;

                        public AnonymousClass6(CustomActionCallback customActionCallback2, String str2, Bundle bundle2) {
                            customActionCallback = customActionCallback2;
                            str = str2;
                            bundle = bundle2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            customActionCallback.onError(str, bundle, null);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(@NonNull String str, Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback) {
            Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                subscription = new Subscription();
                this.mSubscriptions.put(str, subscription);
            }
            Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
            subscription.putCallback(bundle2, subscriptionCallback);
            if (isConnected()) {
                try {
                    this.mServiceBinderWrapper.addSubscription(str, subscriptionCallback.mToken, bundle2, this.mCallbacksMessenger);
                } catch (RemoteException unused) {
                    Log.d(MediaBrowserCompat.TAG, "addSubscription failed with RemoteException parentId=" + str);
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(@NonNull String str, SubscriptionCallback subscriptionCallback) {
            Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                return;
            }
            try {
                if (subscriptionCallback != null) {
                    List<SubscriptionCallback> callbacks = subscription.getCallbacks();
                    List<Bundle> optionsList = subscription.getOptionsList();
                    for (int size = callbacks.size() - 1; size >= 0; size--) {
                        if (callbacks.get(size) == subscriptionCallback) {
                            if (isConnected()) {
                                this.mServiceBinderWrapper.removeSubscription(str, subscriptionCallback.mToken, this.mCallbacksMessenger);
                            }
                            callbacks.remove(size);
                            optionsList.remove(size);
                        }
                    }
                } else if (isConnected()) {
                    this.mServiceBinderWrapper.removeSubscription(str, null, this.mCallbacksMessenger);
                }
            } catch (RemoteException unused) {
                Log.d(MediaBrowserCompat.TAG, "removeSubscription failed with RemoteException parentId=" + str);
            }
            if (subscription.isEmpty() || subscriptionCallback == null) {
                this.mSubscriptions.remove(str);
            }
        }
    }

    public interface MediaBrowserServiceCallbackImpl {
        void onConnectionFailed(Messenger messenger);

        void onLoadChildren(Messenger messenger, String str, List<MediaItem> list, Bundle bundle, Bundle bundle2);

        void onServiceConnected(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);
    }

    public static abstract class SearchCallback {
        public void onError(@NonNull String str, Bundle bundle) {
        }

        public void onSearchResult(@NonNull String str, Bundle bundle, @NonNull List<MediaItem> list) {
        }
    }

    public static class SearchResultReceiver extends ResultReceiver {
        private final SearchCallback mCallback;
        private final Bundle mExtras;
        private final String mQuery;

        public SearchResultReceiver(String str, Bundle bundle, SearchCallback searchCallback, Handler handler) {
            super(handler);
            this.mQuery = str;
            this.mExtras = bundle;
            this.mCallback = searchCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int i10, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.unparcelWithClassLoader(bundle);
            }
            if (i10 != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS)) {
                this.mCallback.onError(this.mQuery, this.mExtras);
                return;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
            if (parcelableArray == null) {
                this.mCallback.onError(this.mQuery, this.mExtras);
                return;
            }
            ArrayList arrayList = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList.add((MediaItem) parcelable);
            }
            this.mCallback.onSearchResult(this.mQuery, this.mExtras, arrayList);
        }
    }

    public static class ServiceBinderWrapper {
        private Messenger mMessenger;
        private Bundle mRootHints;

        public ServiceBinderWrapper(IBinder iBinder, Bundle bundle) {
            this.mMessenger = new Messenger(iBinder);
            this.mRootHints = bundle;
        }

        private void sendRequest(int i10, Bundle bundle, Messenger messenger) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i10;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.mMessenger.send(obtain);
        }

        public void addSubscription(String str, IBinder iBinder, Bundle bundle, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            BundleCompat.putBinder(bundle2, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, iBinder);
            bundle2.putBundle(MediaBrowserProtocol.DATA_OPTIONS, bundle);
            sendRequest(3, bundle2, messenger);
        }

        public void connect(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
            bundle.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Process.myPid());
            bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
            sendRequest(1, bundle, messenger);
        }

        public void disconnect(Messenger messenger) throws RemoteException {
            sendRequest(2, null, messenger);
        }

        public void getMediaItem(String str, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            sendRequest(5, bundle, messenger);
        }

        public void registerCallbackMessenger(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
            bundle.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Process.myPid());
            bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
            sendRequest(6, bundle, messenger);
        }

        public void removeSubscription(String str, IBinder iBinder, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            BundleCompat.putBinder(bundle, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, iBinder);
            sendRequest(4, bundle, messenger);
        }

        public void search(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_SEARCH_QUERY, str);
            bundle2.putBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS, bundle);
            bundle2.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            sendRequest(8, bundle2, messenger);
        }

        public void sendCustomAction(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_CUSTOM_ACTION, str);
            bundle2.putBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS, bundle);
            bundle2.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            sendRequest(9, bundle2, messenger);
        }

        public void unregisterCallbackMessenger(Messenger messenger) throws RemoteException {
            sendRequest(7, null, messenger);
        }
    }

    public static class Subscription {
        private final List<SubscriptionCallback> mCallbacks = new ArrayList();
        private final List<Bundle> mOptionsList = new ArrayList();

        public SubscriptionCallback getCallback(Bundle bundle) {
            for (int i10 = 0; i10 < this.mOptionsList.size(); i10++) {
                if (MediaBrowserCompatUtils.areSameOptions(this.mOptionsList.get(i10), bundle)) {
                    return this.mCallbacks.get(i10);
                }
            }
            return null;
        }

        public List<SubscriptionCallback> getCallbacks() {
            return this.mCallbacks;
        }

        public List<Bundle> getOptionsList() {
            return this.mOptionsList;
        }

        public boolean isEmpty() {
            return this.mCallbacks.isEmpty();
        }

        public void putCallback(Bundle bundle, SubscriptionCallback subscriptionCallback) {
            for (int i10 = 0; i10 < this.mOptionsList.size(); i10++) {
                if (MediaBrowserCompatUtils.areSameOptions(this.mOptionsList.get(i10), bundle)) {
                    this.mCallbacks.set(i10, subscriptionCallback);
                    return;
                }
            }
            this.mCallbacks.add(subscriptionCallback);
            this.mOptionsList.add(bundle);
        }
    }

    public static abstract class SubscriptionCallback {
        final MediaBrowser.SubscriptionCallback mSubscriptionCallbackFwk;
        WeakReference<Subscription> mSubscriptionRef;
        final IBinder mToken = new Binder();

        @RequiresApi(21)
        public class SubscriptionCallbackApi21 extends MediaBrowser.SubscriptionCallback {
            public SubscriptionCallbackApi21() {
            }

            public List<MediaItem> applyOptions(List<MediaItem> list, Bundle bundle) {
                if (list == null) {
                    return null;
                }
                int i10 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
                int i11 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
                if (i10 == -1 && i11 == -1) {
                    return list;
                }
                int i12 = i11 * i10;
                int i13 = i12 + i11;
                if (i10 < 0 || i11 < 1 || i12 >= list.size()) {
                    return Collections.emptyList();
                }
                if (i13 > list.size()) {
                    i13 = list.size();
                }
                return list.subList(i12, i13);
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(@NonNull String str, List<MediaBrowser.MediaItem> list) {
                WeakReference<Subscription> weakReference = SubscriptionCallback.this.mSubscriptionRef;
                Subscription subscription = weakReference == null ? null : weakReference.get();
                if (subscription == null) {
                    SubscriptionCallback.this.onChildrenLoaded(str, MediaItem.fromMediaItemList(list));
                    return;
                }
                List<MediaItem> fromMediaItemList = MediaItem.fromMediaItemList(list);
                List<SubscriptionCallback> callbacks = subscription.getCallbacks();
                List<Bundle> optionsList = subscription.getOptionsList();
                for (int i10 = 0; i10 < callbacks.size(); i10++) {
                    Bundle bundle = optionsList.get(i10);
                    if (bundle == null) {
                        SubscriptionCallback.this.onChildrenLoaded(str, fromMediaItemList);
                    } else {
                        SubscriptionCallback.this.onChildrenLoaded(str, applyOptions(fromMediaItemList, bundle), bundle);
                    }
                }
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(@NonNull String str) {
                SubscriptionCallback.this.onError(str);
            }
        }

        @RequiresApi(26)
        public class SubscriptionCallbackApi26 extends SubscriptionCallbackApi21 {
            public SubscriptionCallbackApi26() {
                super();
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaBrowser.MediaItem> list, @NonNull Bundle bundle) {
                MediaSessionCompat.ensureClassLoader(bundle);
                SubscriptionCallback.this.onChildrenLoaded(str, MediaItem.fromMediaItemList(list), bundle);
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(@NonNull String str, @NonNull Bundle bundle) {
                MediaSessionCompat.ensureClassLoader(bundle);
                SubscriptionCallback.this.onError(str, bundle);
            }
        }

        public SubscriptionCallback() {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mSubscriptionCallbackFwk = new SubscriptionCallbackApi26();
            } else {
                this.mSubscriptionCallbackFwk = new SubscriptionCallbackApi21();
            }
        }

        public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaItem> list) {
        }

        public void onError(@NonNull String str) {
        }

        public void setSubscription(Subscription subscription) {
            this.mSubscriptionRef = new WeakReference<>(subscription);
        }

        public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaItem> list, @NonNull Bundle bundle) {
        }

        public void onError(@NonNull String str, @NonNull Bundle bundle) {
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            this.mImpl = new MediaBrowserImplApi26(context, componentName, connectionCallback, bundle);
        } else if (i10 >= 23) {
            this.mImpl = new MediaBrowserImplApi23(context, componentName, connectionCallback, bundle);
        } else {
            this.mImpl = new MediaBrowserImplApi21(context, componentName, connectionCallback, bundle);
        }
    }

    public void connect() {
        Log.d(TAG, "Connecting to a MediaBrowserService.");
        this.mImpl.connect();
    }

    public void disconnect() {
        this.mImpl.disconnect();
    }

    @Nullable
    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public void getItem(@NonNull String str, @NonNull ItemCallback itemCallback) {
        this.mImpl.getItem(str, itemCallback);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Bundle getNotifyChildrenChangedOptions() {
        return this.mImpl.getNotifyChildrenChangedOptions();
    }

    @NonNull
    public String getRoot() {
        return this.mImpl.getRoot();
    }

    @NonNull
    public ComponentName getServiceComponent() {
        return this.mImpl.getServiceComponent();
    }

    @NonNull
    public MediaSessionCompat.Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isConnected() {
        return this.mImpl.isConnected();
    }

    public void search(@NonNull String str, Bundle bundle, @NonNull SearchCallback searchCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("query cannot be empty");
        }
        if (searchCallback == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        this.mImpl.search(str, bundle, searchCallback);
    }

    public void sendCustomAction(@NonNull String str, Bundle bundle, @Nullable CustomActionCallback customActionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("action cannot be empty");
        }
        this.mImpl.sendCustomAction(str, bundle, customActionCallback);
    }

    public void subscribe(@NonNull String str, @NonNull SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        this.mImpl.subscribe(str, null, subscriptionCallback);
    }

    public void unsubscribe(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        this.mImpl.unsubscribe(str, null);
    }

    public void unsubscribe(@NonNull String str, @NonNull SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback != null) {
            this.mImpl.unsubscribe(str, subscriptionCallback);
            return;
        }
        throw new IllegalArgumentException("callback is null");
    }

    public void subscribe(@NonNull String str, @NonNull Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        if (bundle != null) {
            this.mImpl.subscribe(str, bundle, subscriptionCallback);
            return;
        }
        throw new IllegalArgumentException("options are null");
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() { // from class: android.support.v4.media.MediaBrowserCompat.MediaItem.1
            @Override // android.os.Parcelable.Creator
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public MediaItem[] newArray(int i10) {
                return new MediaItem[i10];
            }
        };
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final MediaDescriptionCompat mDescription;
        private final int mFlags;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem$1 */
        public class AnonymousClass1 implements Parcelable.Creator<MediaItem> {
            @Override // android.os.Parcelable.Creator
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public MediaItem[] newArray(int i10) {
                return new MediaItem[i10];
            }
        }

        public MediaItem(@NonNull MediaDescriptionCompat mediaDescriptionCompat, int i10) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            }
            if (TextUtils.isEmpty(mediaDescriptionCompat.getMediaId())) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            this.mFlags = i10;
            this.mDescription = mediaDescriptionCompat;
        }

        public static MediaItem fromMediaItem(Object obj) {
            if (obj == null) {
                return null;
            }
            MediaBrowser.MediaItem mediaItem = (MediaBrowser.MediaItem) obj;
            return new MediaItem(MediaDescriptionCompat.fromMediaDescription(Api21Impl.getDescription(mediaItem)), Api21Impl.getFlags(mediaItem));
        }

        public static List<MediaItem> fromMediaItemList(List<?> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(fromMediaItem(it.next()));
            }
            return arrayList;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NonNull
        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public int getFlags() {
            return this.mFlags;
        }

        @Nullable
        public String getMediaId() {
            return this.mDescription.getMediaId();
        }

        public boolean isBrowsable() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isPlayable() {
            return (this.mFlags & 2) != 0;
        }

        @NonNull
        public String toString() {
            return "MediaItem{mFlags=" + this.mFlags + ", mDescription=" + this.mDescription + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.mFlags);
            this.mDescription.writeToParcel(parcel, i10);
        }

        public MediaItem(Parcel parcel) {
            this.mFlags = parcel.readInt();
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }
    }
}
