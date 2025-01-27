package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.media.MediaSessionManagerImplApi28;
import androidx.media.MediaSessionManagerImplBase;

/* loaded from: classes.dex */
public final class MediaSessionManager {

    /* renamed from: a */
    static final String f2852a = "MediaSessionManager";

    /* renamed from: b */
    static final boolean f2853b = Log.isLoggable(f2852a, 3);

    /* renamed from: c */
    private static final Object f2854c = new Object();

    /* renamed from: d */
    private static volatile MediaSessionManager f2855d;

    /* renamed from: e */
    MediaSessionManagerImpl f2856e;

    interface MediaSessionManagerImpl {
        Context getContext();

        boolean isTrustedForMediaControl(RemoteUserInfoImpl remoteUserInfoImpl);
    }

    interface RemoteUserInfoImpl {
        String getPackageName();

        int getPid();

        int getUid();
    }

    private MediaSessionManager(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            this.f2856e = new MediaSessionManagerImplApi28(context);
        } else if (i2 >= 21) {
            this.f2856e = new MediaSessionManagerImplApi21(context);
        } else {
            this.f2856e = new MediaSessionManagerImplBase(context);
        }
    }

    @NonNull
    public static MediaSessionManager getSessionManager(@NonNull Context context) {
        MediaSessionManager mediaSessionManager = f2855d;
        if (mediaSessionManager == null) {
            synchronized (f2854c) {
                mediaSessionManager = f2855d;
                if (mediaSessionManager == null) {
                    f2855d = new MediaSessionManager(context.getApplicationContext());
                    mediaSessionManager = f2855d;
                }
            }
        }
        return mediaSessionManager;
    }

    Context getContext() {
        return this.f2856e.getContext();
    }

    public boolean isTrustedForMediaControl(@NonNull RemoteUserInfo remoteUserInfo) {
        if (remoteUserInfo != null) {
            return this.f2856e.isTrustedForMediaControl(remoteUserInfo.f2857a);
        }
        throw new IllegalArgumentException("userInfo should not be null");
    }

    public static final class RemoteUserInfo {
        public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";

        /* renamed from: a */
        RemoteUserInfoImpl f2857a;

        public RemoteUserInfo(@NonNull String str, int i2, int i3) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f2857a = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(str, i2, i3);
            } else {
                this.f2857a = new MediaSessionManagerImplBase.RemoteUserInfoImplBase(str, i2, i3);
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RemoteUserInfo) {
                return this.f2857a.equals(((RemoteUserInfo) obj).f2857a);
            }
            return false;
        }

        @NonNull
        public String getPackageName() {
            return this.f2857a.getPackageName();
        }

        public int getPid() {
            return this.f2857a.getPid();
        }

        public int getUid() {
            return this.f2857a.getUid();
        }

        public int hashCode() {
            return this.f2857a.hashCode();
        }

        @RequiresApi(28)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteUserInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f2857a = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(remoteUserInfo);
        }
    }
}
