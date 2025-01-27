package androidx.media;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;

/* loaded from: classes.dex */
class MediaSessionManagerImplBase implements MediaSessionManager.MediaSessionManagerImpl {

    /* renamed from: a */
    private static final String f2860a = "MediaSessionManager";

    /* renamed from: b */
    private static final boolean f2861b = MediaSessionManager.f2853b;

    /* renamed from: c */
    private static final String f2862c = "android.permission.STATUS_BAR_SERVICE";

    /* renamed from: d */
    private static final String f2863d = "android.permission.MEDIA_CONTENT_CONTROL";

    /* renamed from: e */
    private static final String f2864e = "enabled_notification_listeners";

    /* renamed from: f */
    Context f2865f;

    /* renamed from: g */
    ContentResolver f2866g;

    static class RemoteUserInfoImplBase implements MediaSessionManager.RemoteUserInfoImpl {

        /* renamed from: a */
        private String f2867a;

        /* renamed from: b */
        private int f2868b;

        /* renamed from: c */
        private int f2869c;

        RemoteUserInfoImplBase(String str, int i2, int i3) {
            this.f2867a = str;
            this.f2868b = i2;
            this.f2869c = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RemoteUserInfoImplBase)) {
                return false;
            }
            RemoteUserInfoImplBase remoteUserInfoImplBase = (RemoteUserInfoImplBase) obj;
            return TextUtils.equals(this.f2867a, remoteUserInfoImplBase.f2867a) && this.f2868b == remoteUserInfoImplBase.f2868b && this.f2869c == remoteUserInfoImplBase.f2869c;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public String getPackageName() {
            return this.f2867a;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getPid() {
            return this.f2868b;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getUid() {
            return this.f2869c;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.f2867a, Integer.valueOf(this.f2868b), Integer.valueOf(this.f2869c));
        }
    }

    MediaSessionManagerImplBase(Context context) {
        this.f2865f = context;
        this.f2866g = context.getContentResolver();
    }

    private boolean b(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl, String str) {
        return remoteUserInfoImpl.getPid() < 0 ? this.f2865f.getPackageManager().checkPermission(str, remoteUserInfoImpl.getPackageName()) == 0 : this.f2865f.checkPermission(str, remoteUserInfoImpl.getPid(), remoteUserInfoImpl.getUid()) == 0;
    }

    boolean a(@NonNull MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        String string = Settings.Secure.getString(this.f2866g, f2864e);
        if (string != null) {
            for (String str : string.split(":")) {
                ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                if (unflattenFromString != null && unflattenFromString.getPackageName().equals(remoteUserInfoImpl.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public Context getContext() {
        return this.f2865f;
    }

    @Override // androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(@NonNull MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        try {
            if (this.f2865f.getPackageManager().getApplicationInfo(remoteUserInfoImpl.getPackageName(), 0).uid == remoteUserInfoImpl.getUid()) {
                return b(remoteUserInfoImpl, f2862c) || b(remoteUserInfoImpl, f2863d) || remoteUserInfoImpl.getUid() == 1000 || a(remoteUserInfoImpl);
            }
            if (f2861b) {
                Log.d(f2860a, "Package name " + remoteUserInfoImpl.getPackageName() + " doesn't match with the uid " + remoteUserInfoImpl.getUid());
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            if (f2861b) {
                Log.d(f2860a, "Package " + remoteUserInfoImpl.getPackageName() + " doesn't exist");
            }
            return false;
        }
    }
}
