package androidx.media3.session;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.ResultReceiver;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.session.SessionToken;
import com.google.common.collect.ImmutableSet;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class SessionToken implements Bundleable {
    private static final int IMPL_TYPE_BASE = 0;
    private static final int IMPL_TYPE_LEGACY = 1;
    static final int TYPE_BROWSER_SERVICE_LEGACY = 101;
    public static final int TYPE_LIBRARY_SERVICE = 2;
    public static final int TYPE_SESSION = 0;
    static final int TYPE_SESSION_LEGACY = 100;
    public static final int TYPE_SESSION_SERVICE = 1;
    private static final long WAIT_TIME_MS_FOR_SESSION3_TOKEN = 500;
    private final SessionTokenImpl impl;
    private static final String FIELD_IMPL_TYPE = Util.intToStringMaxRadix(0);
    private static final String FIELD_IMPL = Util.intToStringMaxRadix(1);

    @UnstableApi
    public static final Bundleable.Creator<SessionToken> CREATOR = new Bundleable.Creator() { // from class: p0.f0
        @Override // androidx.media3.common.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            SessionToken fromBundle;
            fromBundle = SessionToken.fromBundle(bundle);
            return fromBundle;
        }
    };

    /* renamed from: androidx.media3.session.SessionToken$1 */
    public class AnonymousClass1 extends ResultReceiver {
        final /* synthetic */ Runnable val$createFallbackLegacyToken;
        final /* synthetic */ com.google.common.util.concurrent.s val$future;
        final /* synthetic */ Handler val$handler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Handler handler, Handler handler2, com.google.common.util.concurrent.s sVar, Runnable runnable) {
            super(handler);
            handler = handler2;
            n10 = sVar;
            runnable = runnable;
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i10, Bundle bundle) {
            handler.removeCallbacksAndMessages(null);
            try {
                n10.set(SessionToken.CREATOR.fromBundle(bundle));
            } catch (RuntimeException unused) {
                runnable.run();
            }
        }
    }

    public interface SessionTokenImpl extends Bundleable {
        @Nullable
        Object getBinder();

        @Nullable
        ComponentName getComponentName();

        Bundle getExtras();

        int getInterfaceVersion();

        int getLibraryVersion();

        String getPackageName();

        String getServiceName();

        int getType();

        int getUid();

        boolean isLegacySession();
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TokenType {
    }

    public SessionToken(Context context, ComponentName componentName) {
        int i10;
        Assertions.checkNotNull(context, "context must not be null");
        Assertions.checkNotNull(componentName, "serviceComponent must not be null");
        PackageManager packageManager = context.getPackageManager();
        int uid = getUid(packageManager, componentName.getPackageName());
        if (isInterfaceDeclared(packageManager, MediaLibraryService.SERVICE_INTERFACE, componentName)) {
            i10 = 2;
        } else if (isInterfaceDeclared(packageManager, MediaSessionService.SERVICE_INTERFACE, componentName)) {
            i10 = 1;
        } else {
            if (!isInterfaceDeclared(packageManager, MediaBrowserServiceCompat.SERVICE_INTERFACE, componentName)) {
                throw new IllegalArgumentException("Failed to resolve SessionToken for " + componentName + ". Manifest doesn't declare one of either MediaSessionService, MediaLibraryService, MediaBrowserService or MediaBrowserServiceCompat. Use service's full name.");
            }
            i10 = 101;
        }
        if (i10 != 101) {
            this.impl = new SessionTokenImplBase(componentName, uid, i10);
        } else {
            this.impl = new SessionTokenImplLegacy(componentName, uid);
        }
    }

    @RequiresApi(21)
    @UnstableApi
    public static p5.c0<SessionToken> createSessionToken(Context context, MediaSession.Token token) {
        return createSessionToken(context, MediaSessionCompat.Token.fromToken(token));
    }

    public static SessionToken fromBundle(Bundle bundle) {
        return new SessionToken(bundle);
    }

    public static ImmutableSet<SessionToken> getAllServiceTokens(Context context) {
        ServiceInfo serviceInfo;
        PackageManager packageManager = context.getPackageManager();
        ArrayList<ResolveInfo> arrayList = new ArrayList();
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(new Intent(MediaLibraryService.SERVICE_INTERFACE), 128);
        if (queryIntentServices != null) {
            arrayList.addAll(queryIntentServices);
        }
        List<ResolveInfo> queryIntentServices2 = packageManager.queryIntentServices(new Intent(MediaSessionService.SERVICE_INTERFACE), 128);
        if (queryIntentServices2 != null) {
            arrayList.addAll(queryIntentServices2);
        }
        List<ResolveInfo> queryIntentServices3 = packageManager.queryIntentServices(new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE), 128);
        if (queryIntentServices3 != null) {
            arrayList.addAll(queryIntentServices3);
        }
        ImmutableSet.a builder = ImmutableSet.builder();
        for (ResolveInfo resolveInfo : arrayList) {
            if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null) {
                builder.g(new SessionToken(context, new ComponentName(serviceInfo.packageName, serviceInfo.name)));
            }
        }
        return builder.e();
    }

    private static boolean isInterfaceDeclared(PackageManager packageManager, String str, ComponentName componentName) {
        ServiceInfo serviceInfo;
        Intent intent = new Intent(str);
        intent.setPackage(componentName.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 128);
        if (queryIntentServices != null) {
            for (int i10 = 0; i10 < queryIntentServices.size(); i10++) {
                ResolveInfo resolveInfo = queryIntentServices.get(i10);
                if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null && TextUtils.equals(serviceInfo.name, componentName.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static /* synthetic */ void lambda$createSessionToken$0(Context context, String str, MediaSessionCompat.Token token, MediaControllerCompat mediaControllerCompat, com.google.common.util.concurrent.s sVar) {
        sVar.set(new SessionToken(token, str, getUid(context.getPackageManager(), str), mediaControllerCompat.getSessionInfo()));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof SessionToken) {
            return this.impl.equals(((SessionToken) obj).impl);
        }
        return false;
    }

    @Nullable
    public Object getBinder() {
        return this.impl.getBinder();
    }

    @Nullable
    public ComponentName getComponentName() {
        return this.impl.getComponentName();
    }

    public Bundle getExtras() {
        return this.impl.getExtras();
    }

    @UnstableApi
    public int getInterfaceVersion() {
        return this.impl.getInterfaceVersion();
    }

    public String getPackageName() {
        return this.impl.getPackageName();
    }

    public String getServiceName() {
        return this.impl.getServiceName();
    }

    public int getSessionVersion() {
        return this.impl.getLibraryVersion();
    }

    public int getType() {
        return this.impl.getType();
    }

    public int getUid() {
        return this.impl.getUid();
    }

    public int hashCode() {
        return this.impl.hashCode();
    }

    public boolean isLegacySession() {
        return this.impl.isLegacySession();
    }

    @Override // androidx.media3.common.Bundleable
    @UnstableApi
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (this.impl instanceof SessionTokenImplBase) {
            bundle.putInt(FIELD_IMPL_TYPE, 0);
        } else {
            bundle.putInt(FIELD_IMPL_TYPE, 1);
        }
        bundle.putBundle(FIELD_IMPL, this.impl.toBundle());
        return bundle;
    }

    public String toString() {
        return this.impl.toString();
    }

    @RequiresApi(21)
    @UnstableApi
    public static p5.c0<SessionToken> createSessionToken(Context context, MediaSession.Token token, Looper looper) {
        return createSessionToken(context, MediaSessionCompat.Token.fromToken(token), looper);
    }

    private static int getUid(PackageManager packageManager, String str) {
        try {
            return packageManager.getApplicationInfo(str, 0).uid;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    @UnstableApi
    public static p5.c0<SessionToken> createSessionToken(Context context, MediaSessionCompat.Token token) {
        HandlerThread handlerThread = new HandlerThread("SessionTokenThread");
        handlerThread.start();
        p5.c0<SessionToken> createSessionToken = createSessionToken(context, token, handlerThread.getLooper());
        createSessionToken.addListener(new Runnable() { // from class: p0.g0

            /* renamed from: b */
            public final /* synthetic */ HandlerThread f29664b;

            public /* synthetic */ g0(HandlerThread handlerThread2) {
                handlerThread = handlerThread2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                handlerThread.quit();
            }
        }, com.google.common.util.concurrent.p.c());
        return createSessionToken;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: p0.h0.<init>(android.content.Context, java.lang.String, android.support.v4.media.session.MediaSessionCompat$Token, android.support.v4.media.session.MediaControllerCompat, com.google.common.util.concurrent.s):void, class status: GENERATED_AND_UNLOADED
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @androidx.media3.common.util.UnstableApi
    public static p5.c0<androidx.media3.session.SessionToken> createSessionToken(android.content.Context r9, android.support.v4.media.session.MediaSessionCompat.Token r10, android.os.Looper r11) {
        /*
            java.lang.String r0 = "context must not be null"
            androidx.media3.common.util.Assertions.checkNotNull(r9, r0)
            java.lang.String r0 = "compatToken must not be null"
            androidx.media3.common.util.Assertions.checkNotNull(r10, r0)
            com.google.common.util.concurrent.s r0 = com.google.common.util.concurrent.s.n()
            android.support.v4.media.session.MediaControllerCompat r7 = new android.support.v4.media.session.MediaControllerCompat
            r7.<init>(r9, r10)
            java.lang.String r3 = r7.getPackageName()
            android.os.Handler r8 = new android.os.Handler
            r8.<init>(r11)
            p0.h0 r11 = new p0.h0
            r1 = r11
            r2 = r9
            r4 = r10
            r5 = r7
            r6 = r0
            r1.<init>()
            r9 = 500(0x1f4, double:2.47E-321)
            r8.postDelayed(r11, r9)
            androidx.media3.session.SessionToken$1 r9 = new androidx.media3.session.SessionToken$1
            r9.<init>(r8)
            java.lang.String r10 = "androidx.media3.session.SESSION_COMMAND_REQUEST_SESSION3_TOKEN"
            r11 = 0
            r7.sendCommand(r10, r11, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.SessionToken.createSessionToken(android.content.Context, android.support.v4.media.session.MediaSessionCompat$Token, android.os.Looper):p5.c0");
    }

    public SessionToken(int i10, int i11, int i12, int i13, String str, IMediaSession iMediaSession, Bundle bundle) {
        this.impl = new SessionTokenImplBase(i10, i11, i12, i13, str, iMediaSession, bundle);
    }

    private SessionToken(MediaSessionCompat.Token token, String str, int i10, Bundle bundle) {
        this.impl = new SessionTokenImplLegacy(token, str, i10, bundle);
    }

    private SessionToken(Bundle bundle) {
        String str = FIELD_IMPL_TYPE;
        Assertions.checkArgument(bundle.containsKey(str), "Impl type needs to be set.");
        int i10 = bundle.getInt(str);
        Bundle bundle2 = (Bundle) Assertions.checkNotNull(bundle.getBundle(FIELD_IMPL));
        if (i10 == 0) {
            this.impl = SessionTokenImplBase.CREATOR.fromBundle(bundle2);
        } else {
            this.impl = SessionTokenImplLegacy.CREATOR.fromBundle(bundle2);
        }
    }
}
