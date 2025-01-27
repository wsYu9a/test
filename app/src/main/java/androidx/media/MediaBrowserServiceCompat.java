package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.core.util.Pair;
import androidx.media.MediaBrowserServiceCompatApi21;
import androidx.media.MediaBrowserServiceCompatApi23;
import androidx.media.MediaBrowserServiceCompatApi26;
import androidx.media.MediaSessionManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat extends Service {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_MEDIA_ITEM = "media_item";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_SEARCH_RESULTS = "search_results";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_ERROR = -1;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_OK = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_PROGRESS_UPDATE = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";

    /* renamed from: a */
    static final String f2739a = "MBServiceCompat";

    /* renamed from: b */
    static final boolean f2740b = Log.isLoggable(f2739a, 3);

    /* renamed from: c */
    private static final float f2741c = 1.0E-5f;

    /* renamed from: d */
    static final int f2742d = 1;

    /* renamed from: e */
    static final int f2743e = 2;

    /* renamed from: f */
    static final int f2744f = 4;

    /* renamed from: g */
    private MediaBrowserServiceImpl f2745g;

    /* renamed from: i */
    ConnectionRecord f2747i;
    MediaSessionCompat.Token k;

    /* renamed from: h */
    final ArrayMap<IBinder, ConnectionRecord> f2746h = new ArrayMap<>();

    /* renamed from: j */
    final ServiceHandler f2748j = new ServiceHandler();

    /* renamed from: androidx.media.MediaBrowserServiceCompat$1 */
    class AnonymousClass1 extends Result<List<MediaBrowserCompat.MediaItem>> {

        /* renamed from: g */
        final /* synthetic */ ConnectionRecord f2749g;

        /* renamed from: h */
        final /* synthetic */ String f2750h;

        /* renamed from: i */
        final /* synthetic */ Bundle f2751i;

        /* renamed from: j */
        final /* synthetic */ Bundle f2752j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Object obj, ConnectionRecord connectionRecord, String str, Bundle bundle, Bundle bundle2) {
            super(obj);
            connectionRecord = connectionRecord;
            str = str;
            bundle = bundle;
            bundle2 = bundle2;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.Result
        /* renamed from: h */
        public void f(List<MediaBrowserCompat.MediaItem> list) {
            if (MediaBrowserServiceCompat.this.f2746h.get(connectionRecord.callbacks.asBinder()) != connectionRecord) {
                if (MediaBrowserServiceCompat.f2740b) {
                    Log.d(MediaBrowserServiceCompat.f2739a, "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + connectionRecord.pkg + " id=" + str);
                    return;
                }
                return;
            }
            if ((b() & 1) != 0) {
                list = MediaBrowserServiceCompat.this.b(list, bundle);
            }
            try {
                connectionRecord.callbacks.onLoadChildren(str, list, bundle, bundle2);
            } catch (RemoteException unused) {
                Log.w(MediaBrowserServiceCompat.f2739a, "Calling onLoadChildren() failed for id=" + str + " package=" + connectionRecord.pkg);
            }
        }
    }

    /* renamed from: androidx.media.MediaBrowserServiceCompat$2 */
    class AnonymousClass2 extends Result<MediaBrowserCompat.MediaItem> {

        /* renamed from: g */
        final /* synthetic */ ResultReceiver f2753g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            resultReceiver = resultReceiver;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.Result
        /* renamed from: h */
        public void f(MediaBrowserCompat.MediaItem mediaItem) {
            if ((b() & 2) != 0) {
                resultReceiver.send(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM, mediaItem);
            resultReceiver.send(0, bundle);
        }
    }

    /* renamed from: androidx.media.MediaBrowserServiceCompat$3 */
    class AnonymousClass3 extends Result<List<MediaBrowserCompat.MediaItem>> {

        /* renamed from: g */
        final /* synthetic */ ResultReceiver f2755g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            resultReceiver = resultReceiver;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.Result
        /* renamed from: h */
        public void f(List<MediaBrowserCompat.MediaItem> list) {
            if ((b() & 4) != 0 || list == null) {
                resultReceiver.send(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS, (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
            resultReceiver.send(0, bundle);
        }
    }

    /* renamed from: androidx.media.MediaBrowserServiceCompat$4 */
    class AnonymousClass4 extends Result<Bundle> {

        /* renamed from: g */
        final /* synthetic */ ResultReceiver f2757g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            resultReceiver = resultReceiver;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.Result
        void d(Bundle bundle) {
            resultReceiver.send(-1, bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.Result
        void e(Bundle bundle) {
            resultReceiver.send(1, bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.Result
        /* renamed from: h */
        public void f(Bundle bundle) {
            resultReceiver.send(0, bundle);
        }
    }

    public static final class BrowserRoot {
        public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
        public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
        public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";

        @Deprecated
        public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";

        /* renamed from: a */
        private final String f2759a;

        /* renamed from: b */
        private final Bundle f2760b;

        public BrowserRoot(@NonNull String str, @Nullable Bundle bundle) {
            if (str == null) {
                throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
            }
            this.f2759a = str;
            this.f2760b = bundle;
        }

        public Bundle getExtras() {
            return this.f2760b;
        }

        public String getRootId() {
            return this.f2759a;
        }
    }

    private class ConnectionRecord implements IBinder.DeathRecipient {
        public final MediaSessionManager.RemoteUserInfo browserInfo;
        public final ServiceCallbacks callbacks;
        public final int pid;
        public final String pkg;
        public BrowserRoot root;
        public final Bundle rootHints;
        public final HashMap<String, List<Pair<IBinder, Bundle>>> subscriptions = new HashMap<>();
        public final int uid;

        /* renamed from: androidx.media.MediaBrowserServiceCompat$ConnectionRecord$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ConnectionRecord connectionRecord = ConnectionRecord.this;
                MediaBrowserServiceCompat.this.f2746h.remove(connectionRecord.callbacks.asBinder());
            }
        }

        ConnectionRecord(String str, int i2, int i3, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            this.pkg = str;
            this.pid = i2;
            this.uid = i3;
            this.browserInfo = new MediaSessionManager.RemoteUserInfo(str, i2, i3);
            this.rootHints = bundle;
            this.callbacks = serviceCallbacks;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            MediaBrowserServiceCompat.this.f2748j.post(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ConnectionRecord.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = ConnectionRecord.this;
                    MediaBrowserServiceCompat.this.f2746h.remove(connectionRecord.callbacks.asBinder());
                }
            });
        }
    }

    interface MediaBrowserServiceImpl {
        Bundle getBrowserRootHints();

        MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo();

        void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle);

        void notifyChildrenChanged(String str, Bundle bundle);

        IBinder onBind(Intent intent);

        void onCreate();

        void setSessionToken(MediaSessionCompat.Token token);
    }

    @RequiresApi(23)
    class MediaBrowserServiceImplApi23 extends MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompatApi23.ServiceCompatProxy {

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$1 */
        class AnonymousClass1 extends Result<MediaBrowserCompat.MediaItem> {

            /* renamed from: g */
            final /* synthetic */ MediaBrowserServiceCompatApi21.ResultWrapper f2779g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Object obj, MediaBrowserServiceCompatApi21.ResultWrapper resultWrapper) {
                super(obj);
                resultWrapper = resultWrapper;
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public void detach() {
                resultWrapper.detach();
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            /* renamed from: h */
            public void f(MediaBrowserCompat.MediaItem mediaItem) {
                if (mediaItem == null) {
                    resultWrapper.sendResult(null);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                mediaItem.writeToParcel(obtain, 0);
                resultWrapper.sendResult(obtain);
            }
        }

        MediaBrowserServiceImplApi23() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            Object createService = MediaBrowserServiceCompatApi23.createService(MediaBrowserServiceCompat.this, this);
            this.f2764b = createService;
            MediaBrowserServiceCompatApi21.onCreate(createService);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy
        public void onLoadItem(String str, MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> resultWrapper) {
            MediaBrowserServiceCompat.this.onLoadItem(str, new Result<MediaBrowserCompat.MediaItem>(str) { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23.1

                /* renamed from: g */
                final /* synthetic */ MediaBrowserServiceCompatApi21.ResultWrapper f2779g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Object str2, MediaBrowserServiceCompatApi21.ResultWrapper resultWrapper2) {
                    super(str2);
                    resultWrapper = resultWrapper2;
                }

                @Override // androidx.media.MediaBrowserServiceCompat.Result
                public void detach() {
                    resultWrapper.detach();
                }

                @Override // androidx.media.MediaBrowserServiceCompat.Result
                /* renamed from: h */
                public void f(MediaBrowserCompat.MediaItem mediaItem) {
                    if (mediaItem == null) {
                        resultWrapper.sendResult(null);
                        return;
                    }
                    Parcel obtain = Parcel.obtain();
                    mediaItem.writeToParcel(obtain, 0);
                    resultWrapper.sendResult(obtain);
                }
            });
        }
    }

    @RequiresApi(26)
    class MediaBrowserServiceImplApi26 extends MediaBrowserServiceImplApi23 implements MediaBrowserServiceCompatApi26.ServiceCompatProxy {

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$1 */
        class AnonymousClass1 extends Result<List<MediaBrowserCompat.MediaItem>> {

            /* renamed from: g */
            final /* synthetic */ MediaBrowserServiceCompatApi26.ResultWrapper f2782g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Object obj, MediaBrowserServiceCompatApi26.ResultWrapper resultWrapper) {
                super(obj);
                resultWrapper = resultWrapper;
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public void detach() {
                resultWrapper.detach();
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            /* renamed from: h */
            public void f(List<MediaBrowserCompat.MediaItem> list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList();
                    for (MediaBrowserCompat.MediaItem mediaItem : list) {
                        Parcel obtain = Parcel.obtain();
                        mediaItem.writeToParcel(obtain, 0);
                        arrayList.add(obtain);
                    }
                } else {
                    arrayList = null;
                }
                resultWrapper.sendResult(arrayList, b());
            }
        }

        MediaBrowserServiceImplApi26() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21
        void d(String str, Bundle bundle) {
            if (bundle != null) {
                MediaBrowserServiceCompatApi26.notifyChildrenChanged(this.f2764b, str, bundle);
            } else {
                super.d(str, bundle);
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f2747i;
            if (connectionRecord == null) {
                return MediaBrowserServiceCompatApi26.getBrowserRootHints(this.f2764b);
            }
            if (connectionRecord.rootHints == null) {
                return null;
            }
            return new Bundle(MediaBrowserServiceCompat.this.f2747i.rootHints);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            Object createService = MediaBrowserServiceCompatApi26.createService(MediaBrowserServiceCompat.this, this);
            this.f2764b = createService;
            MediaBrowserServiceCompatApi21.onCreate(createService);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi26.ServiceCompatProxy
        public void onLoadChildren(String str, MediaBrowserServiceCompatApi26.ResultWrapper resultWrapper, Bundle bundle) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi26.1

                /* renamed from: g */
                final /* synthetic */ MediaBrowserServiceCompatApi26.ResultWrapper f2782g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Object str2, MediaBrowserServiceCompatApi26.ResultWrapper resultWrapper2) {
                    super(str2);
                    resultWrapper = resultWrapper2;
                }

                @Override // androidx.media.MediaBrowserServiceCompat.Result
                public void detach() {
                    resultWrapper.detach();
                }

                @Override // androidx.media.MediaBrowserServiceCompat.Result
                /* renamed from: h */
                public void f(List<MediaBrowserCompat.MediaItem> list) {
                    ArrayList arrayList;
                    if (list != null) {
                        arrayList = new ArrayList();
                        for (MediaBrowserCompat.MediaItem mediaItem : list) {
                            Parcel obtain = Parcel.obtain();
                            mediaItem.writeToParcel(obtain, 0);
                            arrayList.add(obtain);
                        }
                    } else {
                        arrayList = null;
                    }
                    resultWrapper.sendResult(arrayList, b());
                }
            }, bundle);
        }
    }

    @RequiresApi(28)
    class MediaBrowserServiceImplApi28 extends MediaBrowserServiceImplApi26 {
        MediaBrowserServiceImplApi28() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f2747i;
            return connectionRecord != null ? connectionRecord.browserInfo : new MediaSessionManager.RemoteUserInfo(((MediaBrowserService) this.f2764b).getCurrentBrowserInfo());
        }
    }

    class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl {

        /* renamed from: a */
        private Messenger f2785a;

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ MediaSessionCompat.Token f2787a;

            AnonymousClass1(MediaSessionCompat.Token token) {
                token = token;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<ConnectionRecord> it = MediaBrowserServiceCompat.this.f2746h.values().iterator();
                while (it.hasNext()) {
                    ConnectionRecord next = it.next();
                    try {
                        next.callbacks.onConnect(next.root.getRootId(), token, next.root.getExtras());
                    } catch (RemoteException unused) {
                        Log.w(MediaBrowserServiceCompat.f2739a, "Connection for " + next.pkg + " is no longer valid.");
                        it.remove();
                    }
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$2 */
        class AnonymousClass2 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String f2789a;

            /* renamed from: b */
            final /* synthetic */ Bundle f2790b;

            AnonymousClass2(String str, Bundle bundle) {
                str = str;
                bundle = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<IBinder> it = MediaBrowserServiceCompat.this.f2746h.keySet().iterator();
                while (it.hasNext()) {
                    MediaBrowserServiceImplBase.this.a(MediaBrowserServiceCompat.this.f2746h.get(it.next()), str, bundle);
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$3 */
        class AnonymousClass3 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ MediaSessionManager.RemoteUserInfo f2792a;

            /* renamed from: b */
            final /* synthetic */ String f2793b;

            /* renamed from: c */
            final /* synthetic */ Bundle f2794c;

            AnonymousClass3(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
                remoteUserInfo = remoteUserInfo;
                str = str;
                bundle = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                for (int i2 = 0; i2 < MediaBrowserServiceCompat.this.f2746h.size(); i2++) {
                    ConnectionRecord valueAt = MediaBrowserServiceCompat.this.f2746h.valueAt(i2);
                    if (valueAt.browserInfo.equals(remoteUserInfo)) {
                        MediaBrowserServiceImplBase.this.a(valueAt, str, bundle);
                        return;
                    }
                }
            }
        }

        MediaBrowserServiceImplBase() {
        }

        void a(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            List<Pair<IBinder, Bundle>> list = connectionRecord.subscriptions.get(str);
            if (list != null) {
                for (Pair<IBinder, Bundle> pair : list) {
                    if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, pair.second)) {
                        MediaBrowserServiceCompat.this.e(str, connectionRecord, pair.second, bundle);
                    }
                }
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f2747i;
            if (connectionRecord == null) {
                throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            if (connectionRecord.rootHints == null) {
                return null;
            }
            return new Bundle(MediaBrowserServiceCompat.this.f2747i.rootHints);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f2747i;
            if (connectionRecord != null) {
                return connectionRecord.browserInfo;
            }
            throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(@NonNull String str, Bundle bundle) {
            MediaBrowserServiceCompat.this.f2748j.post(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.2

                /* renamed from: a */
                final /* synthetic */ String f2789a;

                /* renamed from: b */
                final /* synthetic */ Bundle f2790b;

                AnonymousClass2(String str2, Bundle bundle2) {
                    str = str2;
                    bundle = bundle2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Iterator<IBinder> it = MediaBrowserServiceCompat.this.f2746h.keySet().iterator();
                    while (it.hasNext()) {
                        MediaBrowserServiceImplBase.this.a(MediaBrowserServiceCompat.this.f2746h.get(it.next()), str, bundle);
                    }
                }
            });
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public IBinder onBind(Intent intent) {
            if (MediaBrowserServiceCompat.SERVICE_INTERFACE.equals(intent.getAction())) {
                return this.f2785a.getBinder();
            }
            return null;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            this.f2785a = new Messenger(MediaBrowserServiceCompat.this.f2748j);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void setSessionToken(MediaSessionCompat.Token token) {
            MediaBrowserServiceCompat.this.f2748j.post(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.1

                /* renamed from: a */
                final /* synthetic */ MediaSessionCompat.Token f2787a;

                AnonymousClass1(MediaSessionCompat.Token token2) {
                    token = token2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Iterator<ConnectionRecord> it = MediaBrowserServiceCompat.this.f2746h.values().iterator();
                    while (it.hasNext()) {
                        ConnectionRecord next = it.next();
                        try {
                            next.callbacks.onConnect(next.root.getRootId(), token, next.root.getExtras());
                        } catch (RemoteException unused) {
                            Log.w(MediaBrowserServiceCompat.f2739a, "Connection for " + next.pkg + " is no longer valid.");
                            it.remove();
                        }
                    }
                }
            });
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(@NonNull MediaSessionManager.RemoteUserInfo remoteUserInfo, @NonNull String str, Bundle bundle) {
            MediaBrowserServiceCompat.this.f2748j.post(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.3

                /* renamed from: a */
                final /* synthetic */ MediaSessionManager.RemoteUserInfo f2792a;

                /* renamed from: b */
                final /* synthetic */ String f2793b;

                /* renamed from: c */
                final /* synthetic */ Bundle f2794c;

                AnonymousClass3(MediaSessionManager.RemoteUserInfo remoteUserInfo2, String str2, Bundle bundle2) {
                    remoteUserInfo = remoteUserInfo2;
                    str = str2;
                    bundle = bundle2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    for (int i2 = 0; i2 < MediaBrowserServiceCompat.this.f2746h.size(); i2++) {
                        ConnectionRecord valueAt = MediaBrowserServiceCompat.this.f2746h.valueAt(i2);
                        if (valueAt.browserInfo.equals(remoteUserInfo)) {
                            MediaBrowserServiceImplBase.this.a(valueAt, str, bundle);
                            return;
                        }
                    }
                }
            });
        }
    }

    public static class Result<T> {

        /* renamed from: a */
        private final Object f2796a;

        /* renamed from: b */
        private boolean f2797b;

        /* renamed from: c */
        private boolean f2798c;

        /* renamed from: d */
        private boolean f2799d;

        /* renamed from: e */
        private boolean f2800e;

        /* renamed from: f */
        private int f2801f;

        Result(Object obj) {
            this.f2796a = obj;
        }

        private void a(Bundle bundle) {
            if (bundle != null && bundle.containsKey(MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS)) {
                float f2 = bundle.getFloat(MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS);
                if (f2 < -1.0E-5f || f2 > 1.00001f) {
                    throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
                }
            }
        }

        int b() {
            return this.f2801f;
        }

        boolean c() {
            return this.f2797b || this.f2798c || this.f2800e;
        }

        void d(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f2796a);
        }

        public void detach() {
            if (this.f2797b) {
                throw new IllegalStateException("detach() called when detach() had already been called for: " + this.f2796a);
            }
            if (this.f2798c) {
                throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.f2796a);
            }
            if (!this.f2800e) {
                this.f2797b = true;
                return;
            }
            throw new IllegalStateException("detach() called when sendError() had already been called for: " + this.f2796a);
        }

        void e(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an interim update for " + this.f2796a);
        }

        void f(T t) {
        }

        void g(int i2) {
            this.f2801f = i2;
        }

        public void sendError(Bundle bundle) {
            if (!this.f2798c && !this.f2800e) {
                this.f2800e = true;
                d(bundle);
            } else {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f2796a);
            }
        }

        public void sendProgressUpdate(Bundle bundle) {
            if (this.f2798c || this.f2800e) {
                throw new IllegalStateException("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: " + this.f2796a);
            }
            a(bundle);
            this.f2799d = true;
            e(bundle);
        }

        public void sendResult(T t) {
            if (!this.f2798c && !this.f2800e) {
                this.f2798c = true;
                f(t);
            } else {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f2796a);
            }
        }
    }

    private class ServiceBinderImpl {

        /* renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ServiceCallbacks f2803a;

            /* renamed from: b */
            final /* synthetic */ String f2804b;

            /* renamed from: c */
            final /* synthetic */ int f2805c;

            /* renamed from: d */
            final /* synthetic */ int f2806d;

            /* renamed from: e */
            final /* synthetic */ Bundle f2807e;

            AnonymousClass1(ServiceCallbacks serviceCallbacks, String str, int i2, int i3, Bundle bundle) {
                serviceCallbacks = serviceCallbacks;
                str = str;
                i2 = i2;
                i3 = i3;
                bundle = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder asBinder = serviceCallbacks.asBinder();
                MediaBrowserServiceCompat.this.f2746h.remove(asBinder);
                ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.new ConnectionRecord(str, i2, i3, bundle, serviceCallbacks);
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat.f2747i = connectionRecord;
                BrowserRoot onGetRoot = mediaBrowserServiceCompat.onGetRoot(str, i3, bundle);
                connectionRecord.root = onGetRoot;
                MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat2.f2747i = null;
                if (onGetRoot != null) {
                    try {
                        mediaBrowserServiceCompat2.f2746h.put(asBinder, connectionRecord);
                        asBinder.linkToDeath(connectionRecord, 0);
                        if (MediaBrowserServiceCompat.this.k != null) {
                            serviceCallbacks.onConnect(connectionRecord.root.getRootId(), MediaBrowserServiceCompat.this.k, connectionRecord.root.getExtras());
                            return;
                        }
                        return;
                    } catch (RemoteException unused) {
                        Log.w(MediaBrowserServiceCompat.f2739a, "Calling onConnect() failed. Dropping client. pkg=" + str);
                        MediaBrowserServiceCompat.this.f2746h.remove(asBinder);
                        return;
                    }
                }
                Log.i(MediaBrowserServiceCompat.f2739a, "No root for client " + str + " from service " + getClass().getName());
                try {
                    serviceCallbacks.onConnectFailed();
                } catch (RemoteException unused2) {
                    Log.w(MediaBrowserServiceCompat.f2739a, "Calling onConnectFailed() failed. Ignoring. pkg=" + str);
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$2 */
        class AnonymousClass2 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ServiceCallbacks f2809a;

            AnonymousClass2(ServiceCallbacks serviceCallbacks) {
                serviceCallbacks = serviceCallbacks;
            }

            @Override // java.lang.Runnable
            public void run() {
                ConnectionRecord remove = MediaBrowserServiceCompat.this.f2746h.remove(serviceCallbacks.asBinder());
                if (remove != null) {
                    remove.callbacks.asBinder().unlinkToDeath(remove, 0);
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$3 */
        class AnonymousClass3 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ServiceCallbacks f2811a;

            /* renamed from: b */
            final /* synthetic */ String f2812b;

            /* renamed from: c */
            final /* synthetic */ IBinder f2813c;

            /* renamed from: d */
            final /* synthetic */ Bundle f2814d;

            AnonymousClass3(ServiceCallbacks serviceCallbacks, String str, IBinder iBinder, Bundle bundle) {
                serviceCallbacks = serviceCallbacks;
                str = str;
                iBinder = iBinder;
                bundle = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f2746h.get(serviceCallbacks.asBinder());
                if (connectionRecord != null) {
                    MediaBrowserServiceCompat.this.a(str, connectionRecord, iBinder, bundle);
                    return;
                }
                Log.w(MediaBrowserServiceCompat.f2739a, "addSubscription for callback that isn't registered id=" + str);
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$4 */
        class AnonymousClass4 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ServiceCallbacks f2816a;

            /* renamed from: b */
            final /* synthetic */ String f2817b;

            /* renamed from: c */
            final /* synthetic */ IBinder f2818c;

            AnonymousClass4(ServiceCallbacks serviceCallbacks, String str, IBinder iBinder) {
                serviceCallbacks = serviceCallbacks;
                str = str;
                iBinder = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() {
                ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f2746h.get(serviceCallbacks.asBinder());
                if (connectionRecord == null) {
                    Log.w(MediaBrowserServiceCompat.f2739a, "removeSubscription for callback that isn't registered id=" + str);
                    return;
                }
                if (MediaBrowserServiceCompat.this.h(str, connectionRecord, iBinder)) {
                    return;
                }
                Log.w(MediaBrowserServiceCompat.f2739a, "removeSubscription called for " + str + " which is not subscribed");
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$5 */
        class AnonymousClass5 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ServiceCallbacks f2820a;

            /* renamed from: b */
            final /* synthetic */ String f2821b;

            /* renamed from: c */
            final /* synthetic */ ResultReceiver f2822c;

            AnonymousClass5(ServiceCallbacks serviceCallbacks, String str, ResultReceiver resultReceiver) {
                serviceCallbacks = serviceCallbacks;
                str = str;
                resultReceiver = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f2746h.get(serviceCallbacks.asBinder());
                if (connectionRecord != null) {
                    MediaBrowserServiceCompat.this.f(str, connectionRecord, resultReceiver);
                    return;
                }
                Log.w(MediaBrowserServiceCompat.f2739a, "getMediaItem for callback that isn't registered id=" + str);
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$6 */
        class AnonymousClass6 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ServiceCallbacks f2824a;

            /* renamed from: b */
            final /* synthetic */ String f2825b;

            /* renamed from: c */
            final /* synthetic */ int f2826c;

            /* renamed from: d */
            final /* synthetic */ int f2827d;

            /* renamed from: e */
            final /* synthetic */ Bundle f2828e;

            AnonymousClass6(ServiceCallbacks serviceCallbacks, String str, int i2, int i3, Bundle bundle) {
                serviceCallbacks = serviceCallbacks;
                str = str;
                i2 = i2;
                i3 = i3;
                bundle = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder asBinder = serviceCallbacks.asBinder();
                MediaBrowserServiceCompat.this.f2746h.remove(asBinder);
                ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.new ConnectionRecord(str, i2, i3, bundle, serviceCallbacks);
                MediaBrowserServiceCompat.this.f2746h.put(asBinder, connectionRecord);
                try {
                    asBinder.linkToDeath(connectionRecord, 0);
                } catch (RemoteException unused) {
                    Log.w(MediaBrowserServiceCompat.f2739a, "IBinder is already dead.");
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$7 */
        class AnonymousClass7 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ServiceCallbacks f2830a;

            AnonymousClass7(ServiceCallbacks serviceCallbacks) {
                serviceCallbacks = serviceCallbacks;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder asBinder = serviceCallbacks.asBinder();
                ConnectionRecord remove = MediaBrowserServiceCompat.this.f2746h.remove(asBinder);
                if (remove != null) {
                    asBinder.unlinkToDeath(remove, 0);
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$8 */
        class AnonymousClass8 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ServiceCallbacks f2832a;

            /* renamed from: b */
            final /* synthetic */ String f2833b;

            /* renamed from: c */
            final /* synthetic */ Bundle f2834c;

            /* renamed from: d */
            final /* synthetic */ ResultReceiver f2835d;

            AnonymousClass8(ServiceCallbacks serviceCallbacks, String str, Bundle bundle, ResultReceiver resultReceiver) {
                serviceCallbacks = serviceCallbacks;
                str = str;
                bundle = bundle;
                resultReceiver = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f2746h.get(serviceCallbacks.asBinder());
                if (connectionRecord != null) {
                    MediaBrowserServiceCompat.this.g(str, bundle, connectionRecord, resultReceiver);
                    return;
                }
                Log.w(MediaBrowserServiceCompat.f2739a, "search for callback that isn't registered query=" + str);
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$9 */
        class AnonymousClass9 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ServiceCallbacks f2837a;

            /* renamed from: b */
            final /* synthetic */ String f2838b;

            /* renamed from: c */
            final /* synthetic */ Bundle f2839c;

            /* renamed from: d */
            final /* synthetic */ ResultReceiver f2840d;

            AnonymousClass9(ServiceCallbacks serviceCallbacks, String str, Bundle bundle, ResultReceiver resultReceiver) {
                serviceCallbacks = serviceCallbacks;
                str = str;
                bundle = bundle;
                resultReceiver = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f2746h.get(serviceCallbacks.asBinder());
                if (connectionRecord != null) {
                    MediaBrowserServiceCompat.this.d(str, bundle, connectionRecord, resultReceiver);
                    return;
                }
                Log.w(MediaBrowserServiceCompat.f2739a, "sendCustomAction for callback that isn't registered action=" + str + ", extras=" + bundle);
            }
        }

        ServiceBinderImpl() {
        }

        public void addSubscription(String str, IBinder iBinder, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.f2748j.postOrRun(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.3

                /* renamed from: a */
                final /* synthetic */ ServiceCallbacks f2811a;

                /* renamed from: b */
                final /* synthetic */ String f2812b;

                /* renamed from: c */
                final /* synthetic */ IBinder f2813c;

                /* renamed from: d */
                final /* synthetic */ Bundle f2814d;

                AnonymousClass3(ServiceCallbacks serviceCallbacks2, String str2, IBinder iBinder2, Bundle bundle2) {
                    serviceCallbacks = serviceCallbacks2;
                    str = str2;
                    iBinder = iBinder2;
                    bundle = bundle2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f2746h.get(serviceCallbacks.asBinder());
                    if (connectionRecord != null) {
                        MediaBrowserServiceCompat.this.a(str, connectionRecord, iBinder, bundle);
                        return;
                    }
                    Log.w(MediaBrowserServiceCompat.f2739a, "addSubscription for callback that isn't registered id=" + str);
                }
            });
        }

        public void connect(String str, int i2, int i3, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            if (MediaBrowserServiceCompat.this.c(str, i3)) {
                MediaBrowserServiceCompat.this.f2748j.postOrRun(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.1

                    /* renamed from: a */
                    final /* synthetic */ ServiceCallbacks f2803a;

                    /* renamed from: b */
                    final /* synthetic */ String f2804b;

                    /* renamed from: c */
                    final /* synthetic */ int f2805c;

                    /* renamed from: d */
                    final /* synthetic */ int f2806d;

                    /* renamed from: e */
                    final /* synthetic */ Bundle f2807e;

                    AnonymousClass1(ServiceCallbacks serviceCallbacks2, String str2, int i22, int i32, Bundle bundle2) {
                        serviceCallbacks = serviceCallbacks2;
                        str = str2;
                        i2 = i22;
                        i3 = i32;
                        bundle = bundle2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IBinder asBinder = serviceCallbacks.asBinder();
                        MediaBrowserServiceCompat.this.f2746h.remove(asBinder);
                        ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.new ConnectionRecord(str, i2, i3, bundle, serviceCallbacks);
                        MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                        mediaBrowserServiceCompat.f2747i = connectionRecord;
                        BrowserRoot onGetRoot = mediaBrowserServiceCompat.onGetRoot(str, i3, bundle);
                        connectionRecord.root = onGetRoot;
                        MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
                        mediaBrowserServiceCompat2.f2747i = null;
                        if (onGetRoot != null) {
                            try {
                                mediaBrowserServiceCompat2.f2746h.put(asBinder, connectionRecord);
                                asBinder.linkToDeath(connectionRecord, 0);
                                if (MediaBrowserServiceCompat.this.k != null) {
                                    serviceCallbacks.onConnect(connectionRecord.root.getRootId(), MediaBrowserServiceCompat.this.k, connectionRecord.root.getExtras());
                                    return;
                                }
                                return;
                            } catch (RemoteException unused) {
                                Log.w(MediaBrowserServiceCompat.f2739a, "Calling onConnect() failed. Dropping client. pkg=" + str);
                                MediaBrowserServiceCompat.this.f2746h.remove(asBinder);
                                return;
                            }
                        }
                        Log.i(MediaBrowserServiceCompat.f2739a, "No root for client " + str + " from service " + getClass().getName());
                        try {
                            serviceCallbacks.onConnectFailed();
                        } catch (RemoteException unused2) {
                            Log.w(MediaBrowserServiceCompat.f2739a, "Calling onConnectFailed() failed. Ignoring. pkg=" + str);
                        }
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i32 + " package=" + str2);
        }

        public void disconnect(ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.f2748j.postOrRun(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.2

                /* renamed from: a */
                final /* synthetic */ ServiceCallbacks f2809a;

                AnonymousClass2(ServiceCallbacks serviceCallbacks2) {
                    serviceCallbacks = serviceCallbacks2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord remove = MediaBrowserServiceCompat.this.f2746h.remove(serviceCallbacks.asBinder());
                    if (remove != null) {
                        remove.callbacks.asBinder().unlinkToDeath(remove, 0);
                    }
                }
            });
        }

        public void getMediaItem(String str, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.f2748j.postOrRun(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.5

                /* renamed from: a */
                final /* synthetic */ ServiceCallbacks f2820a;

                /* renamed from: b */
                final /* synthetic */ String f2821b;

                /* renamed from: c */
                final /* synthetic */ ResultReceiver f2822c;

                AnonymousClass5(ServiceCallbacks serviceCallbacks2, String str2, ResultReceiver resultReceiver2) {
                    serviceCallbacks = serviceCallbacks2;
                    str = str2;
                    resultReceiver = resultReceiver2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f2746h.get(serviceCallbacks.asBinder());
                    if (connectionRecord != null) {
                        MediaBrowserServiceCompat.this.f(str, connectionRecord, resultReceiver);
                        return;
                    }
                    Log.w(MediaBrowserServiceCompat.f2739a, "getMediaItem for callback that isn't registered id=" + str);
                }
            });
        }

        public void registerCallbacks(ServiceCallbacks serviceCallbacks, String str, int i2, int i3, Bundle bundle) {
            MediaBrowserServiceCompat.this.f2748j.postOrRun(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.6

                /* renamed from: a */
                final /* synthetic */ ServiceCallbacks f2824a;

                /* renamed from: b */
                final /* synthetic */ String f2825b;

                /* renamed from: c */
                final /* synthetic */ int f2826c;

                /* renamed from: d */
                final /* synthetic */ int f2827d;

                /* renamed from: e */
                final /* synthetic */ Bundle f2828e;

                AnonymousClass6(ServiceCallbacks serviceCallbacks2, String str2, int i22, int i32, Bundle bundle2) {
                    serviceCallbacks = serviceCallbacks2;
                    str = str2;
                    i2 = i22;
                    i3 = i32;
                    bundle = bundle2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    IBinder asBinder = serviceCallbacks.asBinder();
                    MediaBrowserServiceCompat.this.f2746h.remove(asBinder);
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.new ConnectionRecord(str, i2, i3, bundle, serviceCallbacks);
                    MediaBrowserServiceCompat.this.f2746h.put(asBinder, connectionRecord);
                    try {
                        asBinder.linkToDeath(connectionRecord, 0);
                    } catch (RemoteException unused) {
                        Log.w(MediaBrowserServiceCompat.f2739a, "IBinder is already dead.");
                    }
                }
            });
        }

        public void removeSubscription(String str, IBinder iBinder, ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.f2748j.postOrRun(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.4

                /* renamed from: a */
                final /* synthetic */ ServiceCallbacks f2816a;

                /* renamed from: b */
                final /* synthetic */ String f2817b;

                /* renamed from: c */
                final /* synthetic */ IBinder f2818c;

                AnonymousClass4(ServiceCallbacks serviceCallbacks2, String str2, IBinder iBinder2) {
                    serviceCallbacks = serviceCallbacks2;
                    str = str2;
                    iBinder = iBinder2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f2746h.get(serviceCallbacks.asBinder());
                    if (connectionRecord == null) {
                        Log.w(MediaBrowserServiceCompat.f2739a, "removeSubscription for callback that isn't registered id=" + str);
                        return;
                    }
                    if (MediaBrowserServiceCompat.this.h(str, connectionRecord, iBinder)) {
                        return;
                    }
                    Log.w(MediaBrowserServiceCompat.f2739a, "removeSubscription called for " + str + " which is not subscribed");
                }
            });
        }

        public void search(String str, Bundle bundle, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.f2748j.postOrRun(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.8

                /* renamed from: a */
                final /* synthetic */ ServiceCallbacks f2832a;

                /* renamed from: b */
                final /* synthetic */ String f2833b;

                /* renamed from: c */
                final /* synthetic */ Bundle f2834c;

                /* renamed from: d */
                final /* synthetic */ ResultReceiver f2835d;

                AnonymousClass8(ServiceCallbacks serviceCallbacks2, String str2, Bundle bundle2, ResultReceiver resultReceiver2) {
                    serviceCallbacks = serviceCallbacks2;
                    str = str2;
                    bundle = bundle2;
                    resultReceiver = resultReceiver2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f2746h.get(serviceCallbacks.asBinder());
                    if (connectionRecord != null) {
                        MediaBrowserServiceCompat.this.g(str, bundle, connectionRecord, resultReceiver);
                        return;
                    }
                    Log.w(MediaBrowserServiceCompat.f2739a, "search for callback that isn't registered query=" + str);
                }
            });
        }

        public void sendCustomAction(String str, Bundle bundle, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.f2748j.postOrRun(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.9

                /* renamed from: a */
                final /* synthetic */ ServiceCallbacks f2837a;

                /* renamed from: b */
                final /* synthetic */ String f2838b;

                /* renamed from: c */
                final /* synthetic */ Bundle f2839c;

                /* renamed from: d */
                final /* synthetic */ ResultReceiver f2840d;

                AnonymousClass9(ServiceCallbacks serviceCallbacks2, String str2, Bundle bundle2, ResultReceiver resultReceiver2) {
                    serviceCallbacks = serviceCallbacks2;
                    str = str2;
                    bundle = bundle2;
                    resultReceiver = resultReceiver2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f2746h.get(serviceCallbacks.asBinder());
                    if (connectionRecord != null) {
                        MediaBrowserServiceCompat.this.d(str, bundle, connectionRecord, resultReceiver);
                        return;
                    }
                    Log.w(MediaBrowserServiceCompat.f2739a, "sendCustomAction for callback that isn't registered action=" + str + ", extras=" + bundle);
                }
            });
        }

        public void unregisterCallbacks(ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.f2748j.postOrRun(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.7

                /* renamed from: a */
                final /* synthetic */ ServiceCallbacks f2830a;

                AnonymousClass7(ServiceCallbacks serviceCallbacks2) {
                    serviceCallbacks = serviceCallbacks2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    IBinder asBinder = serviceCallbacks.asBinder();
                    ConnectionRecord remove = MediaBrowserServiceCompat.this.f2746h.remove(asBinder);
                    if (remove != null) {
                        asBinder.unlinkToDeath(remove, 0);
                    }
                }
            });
        }
    }

    private interface ServiceCallbacks {
        IBinder asBinder();

        void onConnect(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException;

        void onConnectFailed() throws RemoteException;

        void onLoadChildren(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException;
    }

    private static class ServiceCallbacksCompat implements ServiceCallbacks {

        /* renamed from: a */
        final Messenger f2842a;

        ServiceCallbacksCompat(Messenger messenger) {
            this.f2842a = messenger;
        }

        private void a(int i2, Bundle bundle) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i2;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.f2842a.send(obtain);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public IBinder asBinder() {
            return this.f2842a.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnect(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle2.putParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN, token);
            bundle2.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, bundle);
            a(1, bundle2);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnectFailed() throws RemoteException {
            a(2, null);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onLoadChildren(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException {
            Bundle bundle3 = new Bundle();
            bundle3.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle3.putBundle(MediaBrowserProtocol.DATA_OPTIONS, bundle);
            bundle3.putBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS, bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST, list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
            }
            a(3, bundle3);
        }
    }

    private final class ServiceHandler extends Handler {

        /* renamed from: a */
        private final ServiceBinderImpl f2843a;

        ServiceHandler() {
            this.f2843a = MediaBrowserServiceCompat.this.new ServiceBinderImpl();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                    MediaSessionCompat.ensureClassLoader(bundle);
                    this.f2843a.connect(data.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), data.getInt(MediaBrowserProtocol.DATA_CALLING_PID), data.getInt(MediaBrowserProtocol.DATA_CALLING_UID), bundle, new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 2:
                    this.f2843a.disconnect(new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 3:
                    Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                    MediaSessionCompat.ensureClassLoader(bundle2);
                    this.f2843a.addSubscription(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), bundle2, new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 4:
                    this.f2843a.removeSubscription(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 5:
                    this.f2843a.getMediaItem(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 6:
                    Bundle bundle3 = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                    MediaSessionCompat.ensureClassLoader(bundle3);
                    this.f2843a.registerCallbacks(new ServiceCallbacksCompat(message.replyTo), data.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), data.getInt(MediaBrowserProtocol.DATA_CALLING_PID), data.getInt(MediaBrowserProtocol.DATA_CALLING_UID), bundle3);
                    break;
                case 7:
                    this.f2843a.unregisterCallbacks(new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 8:
                    Bundle bundle4 = data.getBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS);
                    MediaSessionCompat.ensureClassLoader(bundle4);
                    this.f2843a.search(data.getString(MediaBrowserProtocol.DATA_SEARCH_QUERY), bundle4, (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 9:
                    Bundle bundle5 = data.getBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS);
                    MediaSessionCompat.ensureClassLoader(bundle5);
                    this.f2843a.sendCustomAction(data.getString(MediaBrowserProtocol.DATA_CUSTOM_ACTION), bundle5, (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(message.replyTo));
                    break;
                default:
                    Log.w(MediaBrowserServiceCompat.f2739a, "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                    break;
            }
        }

        public void postOrRun(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j2) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt(MediaBrowserProtocol.DATA_CALLING_UID, Binder.getCallingUid());
            data.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Binder.getCallingPid());
            return super.sendMessageAtTime(message, j2);
        }
    }

    void a(String str, ConnectionRecord connectionRecord, IBinder iBinder, Bundle bundle) {
        List<Pair<IBinder, Bundle>> list = connectionRecord.subscriptions.get(str);
        if (list == null) {
            list = new ArrayList<>();
        }
        for (Pair<IBinder, Bundle> pair : list) {
            if (iBinder == pair.first && MediaBrowserCompatUtils.areSameOptions(bundle, pair.second)) {
                return;
            }
        }
        list.add(new Pair<>(iBinder, bundle));
        connectionRecord.subscriptions.put(str, list);
        e(str, connectionRecord, bundle, null);
        this.f2747i = connectionRecord;
        onSubscribe(str, bundle);
        this.f2747i = null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void attachToBaseContext(Context context) {
        attachBaseContext(context);
    }

    List<MediaBrowserCompat.MediaItem> b(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i2 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        int i3 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        if (i2 == -1 && i3 == -1) {
            return list;
        }
        int i4 = i3 * i2;
        int i5 = i4 + i3;
        if (i2 < 0 || i3 < 1 || i4 >= list.size()) {
            return Collections.emptyList();
        }
        if (i5 > list.size()) {
            i5 = list.size();
        }
        return list.subList(i4, i5);
    }

    boolean c(String str, int i2) {
        if (str == null) {
            return false;
        }
        for (String str2 : getPackageManager().getPackagesForUid(i2)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    void d(String str, Bundle bundle, ConnectionRecord connectionRecord, ResultReceiver resultReceiver) {
        AnonymousClass4 anonymousClass4 = new Result<Bundle>(str) { // from class: androidx.media.MediaBrowserServiceCompat.4

            /* renamed from: g */
            final /* synthetic */ ResultReceiver f2757g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(Object str2, ResultReceiver resultReceiver2) {
                super(str2);
                resultReceiver = resultReceiver2;
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            void d(Bundle bundle2) {
                resultReceiver.send(-1, bundle2);
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            void e(Bundle bundle2) {
                resultReceiver.send(1, bundle2);
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            /* renamed from: h */
            public void f(Bundle bundle2) {
                resultReceiver.send(0, bundle2);
            }
        };
        this.f2747i = connectionRecord;
        onCustomAction(str2, bundle, anonymousClass4);
        this.f2747i = null;
        if (anonymousClass4.c()) {
            return;
        }
        throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str2 + " extras=" + bundle);
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    void e(String str, ConnectionRecord connectionRecord, Bundle bundle, Bundle bundle2) {
        AnonymousClass1 anonymousClass1 = new Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: androidx.media.MediaBrowserServiceCompat.1

            /* renamed from: g */
            final /* synthetic */ ConnectionRecord f2749g;

            /* renamed from: h */
            final /* synthetic */ String f2750h;

            /* renamed from: i */
            final /* synthetic */ Bundle f2751i;

            /* renamed from: j */
            final /* synthetic */ Bundle f2752j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(String str2, ConnectionRecord connectionRecord2, String str22, Bundle bundle3, Bundle bundle22) {
                super(str22);
                connectionRecord = connectionRecord2;
                str = str22;
                bundle = bundle3;
                bundle2 = bundle22;
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            /* renamed from: h */
            public void f(List<MediaBrowserCompat.MediaItem> list) {
                if (MediaBrowserServiceCompat.this.f2746h.get(connectionRecord.callbacks.asBinder()) != connectionRecord) {
                    if (MediaBrowserServiceCompat.f2740b) {
                        Log.d(MediaBrowserServiceCompat.f2739a, "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + connectionRecord.pkg + " id=" + str);
                        return;
                    }
                    return;
                }
                if ((b() & 1) != 0) {
                    list = MediaBrowserServiceCompat.this.b(list, bundle);
                }
                try {
                    connectionRecord.callbacks.onLoadChildren(str, list, bundle, bundle2);
                } catch (RemoteException unused) {
                    Log.w(MediaBrowserServiceCompat.f2739a, "Calling onLoadChildren() failed for id=" + str + " package=" + connectionRecord.pkg);
                }
            }
        };
        this.f2747i = connectionRecord2;
        if (bundle3 == null) {
            onLoadChildren(str22, anonymousClass1);
        } else {
            onLoadChildren(str22, anonymousClass1, bundle3);
        }
        this.f2747i = null;
        if (anonymousClass1.c()) {
            return;
        }
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + connectionRecord2.pkg + " id=" + str22);
    }

    void f(String str, ConnectionRecord connectionRecord, ResultReceiver resultReceiver) {
        AnonymousClass2 anonymousClass2 = new Result<MediaBrowserCompat.MediaItem>(str) { // from class: androidx.media.MediaBrowserServiceCompat.2

            /* renamed from: g */
            final /* synthetic */ ResultReceiver f2753g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Object str2, ResultReceiver resultReceiver2) {
                super(str2);
                resultReceiver = resultReceiver2;
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            /* renamed from: h */
            public void f(MediaBrowserCompat.MediaItem mediaItem) {
                if ((b() & 2) != 0) {
                    resultReceiver.send(-1, null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM, mediaItem);
                resultReceiver.send(0, bundle);
            }
        };
        this.f2747i = connectionRecord;
        onLoadItem(str2, anonymousClass2);
        this.f2747i = null;
        if (anonymousClass2.c()) {
            return;
        }
        throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str2);
    }

    void g(String str, Bundle bundle, ConnectionRecord connectionRecord, ResultReceiver resultReceiver) {
        AnonymousClass3 anonymousClass3 = new Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: androidx.media.MediaBrowserServiceCompat.3

            /* renamed from: g */
            final /* synthetic */ ResultReceiver f2755g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(Object str2, ResultReceiver resultReceiver2) {
                super(str2);
                resultReceiver = resultReceiver2;
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            /* renamed from: h */
            public void f(List<MediaBrowserCompat.MediaItem> list) {
                if ((b() & 4) != 0 || list == null) {
                    resultReceiver.send(-1, null);
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS, (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
                resultReceiver.send(0, bundle2);
            }
        };
        this.f2747i = connectionRecord;
        onSearch(str2, bundle, anonymousClass3);
        this.f2747i = null;
        if (anonymousClass3.c()) {
            return;
        }
        throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str2);
    }

    public final Bundle getBrowserRootHints() {
        return this.f2745g.getBrowserRootHints();
    }

    @NonNull
    public final MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
        return this.f2745g.getCurrentBrowserInfo();
    }

    @Nullable
    public MediaSessionCompat.Token getSessionToken() {
        return this.k;
    }

    boolean h(String str, ConnectionRecord connectionRecord, IBinder iBinder) {
        boolean z = false;
        try {
            if (iBinder == null) {
                return connectionRecord.subscriptions.remove(str) != null;
            }
            List<Pair<IBinder, Bundle>> list = connectionRecord.subscriptions.get(str);
            if (list != null) {
                Iterator<Pair<IBinder, Bundle>> it = list.iterator();
                while (it.hasNext()) {
                    if (iBinder == it.next().first) {
                        it.remove();
                        z = true;
                    }
                }
                if (list.size() == 0) {
                    connectionRecord.subscriptions.remove(str);
                }
            }
            return z;
        } finally {
            this.f2747i = connectionRecord;
            onUnsubscribe(str);
            this.f2747i = null;
        }
    }

    public void notifyChildrenChanged(@NonNull String str) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        this.f2745g.notifyChildrenChanged(str, null);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f2745g.onBind(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            this.f2745g = new MediaBrowserServiceImplApi28();
        } else if (i2 >= 26) {
            this.f2745g = new MediaBrowserServiceImplApi26();
        } else if (i2 >= 23) {
            this.f2745g = new MediaBrowserServiceImplApi23();
        } else if (i2 >= 21) {
            this.f2745g = new MediaBrowserServiceImplApi21();
        } else {
            this.f2745g = new MediaBrowserServiceImplBase();
        }
        this.f2745g.onCreate();
    }

    public void onCustomAction(@NonNull String str, Bundle bundle, @NonNull Result<Bundle> result) {
        result.sendError(null);
    }

    @Nullable
    public abstract BrowserRoot onGetRoot(@NonNull String str, int i2, @Nullable Bundle bundle);

    public abstract void onLoadChildren(@NonNull String str, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result);

    public void onLoadChildren(@NonNull String str, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result, @NonNull Bundle bundle) {
        result.g(1);
        onLoadChildren(str, result);
    }

    public void onLoadItem(String str, @NonNull Result<MediaBrowserCompat.MediaItem> result) {
        result.g(2);
        result.sendResult(null);
    }

    public void onSearch(@NonNull String str, Bundle bundle, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result) {
        result.g(4);
        result.sendResult(null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onSubscribe(String str, Bundle bundle) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onUnsubscribe(String str) {
    }

    public void setSessionToken(MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null.");
        }
        if (this.k != null) {
            throw new IllegalStateException("The session token has already been set.");
        }
        this.k = token;
        this.f2745g.setSessionToken(token);
    }

    @RequiresApi(21)
    class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl, MediaBrowserServiceCompatApi21.ServiceCompatProxy {

        /* renamed from: a */
        final List<Bundle> f2763a = new ArrayList();

        /* renamed from: b */
        Object f2764b;

        /* renamed from: c */
        Messenger f2765c;

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ MediaSessionCompat.Token f2767a;

            AnonymousClass1(MediaSessionCompat.Token token) {
                token = token;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!MediaBrowserServiceImplApi21.this.f2763a.isEmpty()) {
                    IMediaSession extraBinder = token.getExtraBinder();
                    if (extraBinder != null) {
                        Iterator<Bundle> it = MediaBrowserServiceImplApi21.this.f2763a.iterator();
                        while (it.hasNext()) {
                            BundleCompat.putBinder(it.next(), MediaBrowserProtocol.EXTRA_SESSION_BINDER, extraBinder.asBinder());
                        }
                    }
                    MediaBrowserServiceImplApi21.this.f2763a.clear();
                }
                MediaBrowserServiceCompatApi21.setSessionToken(MediaBrowserServiceImplApi21.this.f2764b, token.getToken());
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$2 */
        class AnonymousClass2 extends Result<List<MediaBrowserCompat.MediaItem>> {

            /* renamed from: g */
            final /* synthetic */ MediaBrowserServiceCompatApi21.ResultWrapper f2769g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Object obj, MediaBrowserServiceCompatApi21.ResultWrapper resultWrapper) {
                super(obj);
                resultWrapper = resultWrapper;
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public void detach() {
                resultWrapper.detach();
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            /* renamed from: h */
            public void f(List<MediaBrowserCompat.MediaItem> list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList();
                    for (MediaBrowserCompat.MediaItem mediaItem : list) {
                        Parcel obtain = Parcel.obtain();
                        mediaItem.writeToParcel(obtain, 0);
                        arrayList.add(obtain);
                    }
                } else {
                    arrayList = null;
                }
                resultWrapper.sendResult(arrayList);
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$3 */
        class AnonymousClass3 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String f2771a;

            /* renamed from: b */
            final /* synthetic */ Bundle f2772b;

            AnonymousClass3(String str, Bundle bundle) {
                str = str;
                bundle = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<IBinder> it = MediaBrowserServiceCompat.this.f2746h.keySet().iterator();
                while (it.hasNext()) {
                    MediaBrowserServiceImplApi21.this.c(MediaBrowserServiceCompat.this.f2746h.get(it.next()), str, bundle);
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$4 */
        class AnonymousClass4 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ MediaSessionManager.RemoteUserInfo f2774a;

            /* renamed from: b */
            final /* synthetic */ String f2775b;

            /* renamed from: c */
            final /* synthetic */ Bundle f2776c;

            AnonymousClass4(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
                remoteUserInfo = remoteUserInfo;
                str = str;
                bundle = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                for (int i2 = 0; i2 < MediaBrowserServiceCompat.this.f2746h.size(); i2++) {
                    ConnectionRecord valueAt = MediaBrowserServiceCompat.this.f2746h.valueAt(i2);
                    if (valueAt.browserInfo.equals(remoteUserInfo)) {
                        MediaBrowserServiceImplApi21.this.c(valueAt, str, bundle);
                    }
                }
            }
        }

        MediaBrowserServiceImplApi21() {
        }

        void a(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
            MediaBrowserServiceCompat.this.f2748j.post(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.4

                /* renamed from: a */
                final /* synthetic */ MediaSessionManager.RemoteUserInfo f2774a;

                /* renamed from: b */
                final /* synthetic */ String f2775b;

                /* renamed from: c */
                final /* synthetic */ Bundle f2776c;

                AnonymousClass4(MediaSessionManager.RemoteUserInfo remoteUserInfo2, String str2, Bundle bundle2) {
                    remoteUserInfo = remoteUserInfo2;
                    str = str2;
                    bundle = bundle2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    for (int i2 = 0; i2 < MediaBrowserServiceCompat.this.f2746h.size(); i2++) {
                        ConnectionRecord valueAt = MediaBrowserServiceCompat.this.f2746h.valueAt(i2);
                        if (valueAt.browserInfo.equals(remoteUserInfo)) {
                            MediaBrowserServiceImplApi21.this.c(valueAt, str, bundle);
                        }
                    }
                }
            });
        }

        void b(String str, Bundle bundle) {
            MediaBrowserServiceCompat.this.f2748j.post(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.3

                /* renamed from: a */
                final /* synthetic */ String f2771a;

                /* renamed from: b */
                final /* synthetic */ Bundle f2772b;

                AnonymousClass3(String str2, Bundle bundle2) {
                    str = str2;
                    bundle = bundle2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Iterator<IBinder> it = MediaBrowserServiceCompat.this.f2746h.keySet().iterator();
                    while (it.hasNext()) {
                        MediaBrowserServiceImplApi21.this.c(MediaBrowserServiceCompat.this.f2746h.get(it.next()), str, bundle);
                    }
                }
            });
        }

        void c(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            List<Pair<IBinder, Bundle>> list = connectionRecord.subscriptions.get(str);
            if (list != null) {
                for (Pair<IBinder, Bundle> pair : list) {
                    if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, pair.second)) {
                        MediaBrowserServiceCompat.this.e(str, connectionRecord, pair.second, bundle);
                    }
                }
            }
        }

        void d(String str, Bundle bundle) {
            MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.f2764b, str);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            if (this.f2765c == null) {
                return null;
            }
            ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f2747i;
            if (connectionRecord == null) {
                throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            if (connectionRecord.rootHints == null) {
                return null;
            }
            return new Bundle(MediaBrowserServiceCompat.this.f2747i.rootHints);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f2747i;
            if (connectionRecord != null) {
                return connectionRecord.browserInfo;
            }
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(String str, Bundle bundle) {
            d(str, bundle);
            b(str, bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public IBinder onBind(Intent intent) {
            return MediaBrowserServiceCompatApi21.onBind(this.f2764b, intent);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            Object createService = MediaBrowserServiceCompatApi21.createService(MediaBrowserServiceCompat.this, this);
            this.f2764b = createService;
            MediaBrowserServiceCompatApi21.onCreate(createService);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public MediaBrowserServiceCompatApi21.BrowserRoot onGetRoot(String str, int i2, Bundle bundle) {
            Bundle bundle2;
            if (bundle == null || bundle.getInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 0) == 0) {
                bundle2 = null;
            } else {
                bundle.remove(MediaBrowserProtocol.EXTRA_CLIENT_VERSION);
                this.f2765c = new Messenger(MediaBrowserServiceCompat.this.f2748j);
                bundle2 = new Bundle();
                bundle2.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
                BundleCompat.putBinder(bundle2, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER, this.f2765c.getBinder());
                MediaSessionCompat.Token token = MediaBrowserServiceCompat.this.k;
                if (token != null) {
                    IMediaSession extraBinder = token.getExtraBinder();
                    BundleCompat.putBinder(bundle2, MediaBrowserProtocol.EXTRA_SESSION_BINDER, extraBinder == null ? null : extraBinder.asBinder());
                } else {
                    this.f2763a.add(bundle2);
                }
            }
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f2747i = mediaBrowserServiceCompat.new ConnectionRecord(str, -1, i2, bundle, null);
            BrowserRoot onGetRoot = MediaBrowserServiceCompat.this.onGetRoot(str, i2, bundle);
            MediaBrowserServiceCompat.this.f2747i = null;
            if (onGetRoot == null) {
                return null;
            }
            if (bundle2 == null) {
                bundle2 = onGetRoot.getExtras();
            } else if (onGetRoot.getExtras() != null) {
                bundle2.putAll(onGetRoot.getExtras());
            }
            return new MediaBrowserServiceCompatApi21.BrowserRoot(onGetRoot.getRootId(), bundle2);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public void onLoadChildren(String str, MediaBrowserServiceCompatApi21.ResultWrapper<List<Parcel>> resultWrapper) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.2

                /* renamed from: g */
                final /* synthetic */ MediaBrowserServiceCompatApi21.ResultWrapper f2769g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(Object str2, MediaBrowserServiceCompatApi21.ResultWrapper resultWrapper2) {
                    super(str2);
                    resultWrapper = resultWrapper2;
                }

                @Override // androidx.media.MediaBrowserServiceCompat.Result
                public void detach() {
                    resultWrapper.detach();
                }

                @Override // androidx.media.MediaBrowserServiceCompat.Result
                /* renamed from: h */
                public void f(List<MediaBrowserCompat.MediaItem> list) {
                    ArrayList arrayList;
                    if (list != null) {
                        arrayList = new ArrayList();
                        for (MediaBrowserCompat.MediaItem mediaItem : list) {
                            Parcel obtain = Parcel.obtain();
                            mediaItem.writeToParcel(obtain, 0);
                            arrayList.add(obtain);
                        }
                    } else {
                        arrayList = null;
                    }
                    resultWrapper.sendResult(arrayList);
                }
            });
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void setSessionToken(MediaSessionCompat.Token token) {
            MediaBrowserServiceCompat.this.f2748j.postOrRun(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.1

                /* renamed from: a */
                final /* synthetic */ MediaSessionCompat.Token f2767a;

                AnonymousClass1(MediaSessionCompat.Token token2) {
                    token = token2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (!MediaBrowserServiceImplApi21.this.f2763a.isEmpty()) {
                        IMediaSession extraBinder = token.getExtraBinder();
                        if (extraBinder != null) {
                            Iterator<Bundle> it = MediaBrowserServiceImplApi21.this.f2763a.iterator();
                            while (it.hasNext()) {
                                BundleCompat.putBinder(it.next(), MediaBrowserProtocol.EXTRA_SESSION_BINDER, extraBinder.asBinder());
                            }
                        }
                        MediaBrowserServiceImplApi21.this.f2763a.clear();
                    }
                    MediaBrowserServiceCompatApi21.setSessionToken(MediaBrowserServiceImplApi21.this.f2764b, token.getToken());
                }
            });
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
            a(remoteUserInfo, str, bundle);
        }
    }

    public void notifyChildrenChanged(@NonNull String str, @NonNull Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if (bundle != null) {
            this.f2745g.notifyChildrenChanged(str, bundle);
            return;
        }
        throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void notifyChildrenChanged(@NonNull MediaSessionManager.RemoteUserInfo remoteUserInfo, @NonNull String str, @NonNull Bundle bundle) {
        if (remoteUserInfo == null) {
            throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
        }
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if (bundle != null) {
            this.f2745g.notifyChildrenChanged(remoteUserInfo, str, bundle);
            return;
        }
        throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    }
}
