package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import androidx.annotation.RequiresApi;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;

@RequiresApi(28)
/* loaded from: classes.dex */
class MediaSessionManagerImplApi28 extends MediaSessionManagerImplApi21 {

    /* renamed from: h */
    android.media.session.MediaSessionManager f2858h;

    MediaSessionManagerImplApi28(Context context) {
        super(context);
        this.f2858h = (android.media.session.MediaSessionManager) context.getSystemService("media_session");
    }

    @Override // androidx.media.MediaSessionManagerImplApi21, androidx.media.MediaSessionManagerImplBase, androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        if (remoteUserInfoImpl instanceof RemoteUserInfoImplApi28) {
            return this.f2858h.isTrustedForMediaControl(((RemoteUserInfoImplApi28) remoteUserInfoImpl).f2859a);
        }
        return false;
    }

    static final class RemoteUserInfoImplApi28 implements MediaSessionManager.RemoteUserInfoImpl {

        /* renamed from: a */
        final MediaSessionManager.RemoteUserInfo f2859a;

        RemoteUserInfoImplApi28(String str, int i2, int i3) {
            this.f2859a = new MediaSessionManager.RemoteUserInfo(str, i2, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RemoteUserInfoImplApi28) {
                return this.f2859a.equals(((RemoteUserInfoImplApi28) obj).f2859a);
            }
            return false;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public String getPackageName() {
            return this.f2859a.getPackageName();
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getPid() {
            return this.f2859a.getPid();
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getUid() {
            return this.f2859a.getUid();
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.f2859a);
        }

        RemoteUserInfoImplApi28(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f2859a = remoteUserInfo;
        }
    }
}
