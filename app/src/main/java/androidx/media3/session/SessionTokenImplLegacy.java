package androidx.media3.session;

import android.content.ComponentName;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.Nullable;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.session.SessionToken;
import b5.r;

/* loaded from: classes.dex */
final class SessionTokenImplLegacy implements SessionToken.SessionTokenImpl {

    @Nullable
    private final ComponentName componentName;
    private final Bundle extras;

    @Nullable
    private final MediaSessionCompat.Token legacyToken;
    private final String packageName;
    private final int type;
    private final int uid;
    private static final String FIELD_LEGACY_TOKEN = Util.intToStringMaxRadix(0);
    private static final String FIELD_UID = Util.intToStringMaxRadix(1);
    private static final String FIELD_TYPE = Util.intToStringMaxRadix(2);
    private static final String FIELD_COMPONENT_NAME = Util.intToStringMaxRadix(3);
    private static final String FIELD_PACKAGE_NAME = Util.intToStringMaxRadix(4);
    private static final String FIELD_EXTRAS = Util.intToStringMaxRadix(5);
    public static final Bundleable.Creator<SessionTokenImplLegacy> CREATOR = new Bundleable.Creator() { // from class: androidx.media3.session.zd
        @Override // androidx.media3.common.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            SessionTokenImplLegacy fromBundle;
            fromBundle = SessionTokenImplLegacy.fromBundle(bundle);
            return fromBundle;
        }
    };

    public SessionTokenImplLegacy(MediaSessionCompat.Token token, String str, int i10, Bundle bundle) {
        this((MediaSessionCompat.Token) Assertions.checkNotNull(token), i10, 100, null, Assertions.checkNotEmpty(str), (Bundle) Assertions.checkNotNull(bundle));
    }

    public static SessionTokenImplLegacy fromBundle(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(FIELD_LEGACY_TOKEN);
        MediaSessionCompat.Token fromBundle = bundle2 == null ? null : MediaSessionCompat.Token.fromBundle(bundle2);
        String str = FIELD_UID;
        Assertions.checkArgument(bundle.containsKey(str), "uid should be set.");
        int i10 = bundle.getInt(str);
        String str2 = FIELD_TYPE;
        Assertions.checkArgument(bundle.containsKey(str2), "type should be set.");
        int i11 = bundle.getInt(str2);
        ComponentName componentName = (ComponentName) bundle.getParcelable(FIELD_COMPONENT_NAME);
        String checkNotEmpty = Assertions.checkNotEmpty(bundle.getString(FIELD_PACKAGE_NAME), "package name should be set.");
        Bundle bundle3 = bundle.getBundle(FIELD_EXTRAS);
        if (bundle3 == null) {
            bundle3 = Bundle.EMPTY;
        }
        return new SessionTokenImplLegacy(fromBundle, i10, i11, componentName, checkNotEmpty, bundle3);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SessionTokenImplLegacy)) {
            return false;
        }
        SessionTokenImplLegacy sessionTokenImplLegacy = (SessionTokenImplLegacy) obj;
        int i10 = this.type;
        if (i10 != sessionTokenImplLegacy.type) {
            return false;
        }
        if (i10 == 100) {
            return Util.areEqual(this.legacyToken, sessionTokenImplLegacy.legacyToken);
        }
        if (i10 != 101) {
            return false;
        }
        return Util.areEqual(this.componentName, sessionTokenImplLegacy.componentName);
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    @Nullable
    public Object getBinder() {
        return this.legacyToken;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    @Nullable
    public ComponentName getComponentName() {
        return this.componentName;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public Bundle getExtras() {
        return new Bundle(this.extras);
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public int getInterfaceVersion() {
        return 0;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public int getLibraryVersion() {
        return 0;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public String getPackageName() {
        return this.packageName;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public String getServiceName() {
        ComponentName componentName = this.componentName;
        return componentName == null ? "" : componentName.getClassName();
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public int getType() {
        return this.type != 101 ? 0 : 2;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public int getUid() {
        return this.uid;
    }

    public int hashCode() {
        return r.b(Integer.valueOf(this.type), this.componentName, this.legacyToken);
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public boolean isLegacySession() {
        return true;
    }

    @Override // androidx.media3.common.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        String str = FIELD_LEGACY_TOKEN;
        MediaSessionCompat.Token token = this.legacyToken;
        bundle.putBundle(str, token == null ? null : token.toBundle());
        bundle.putInt(FIELD_UID, this.uid);
        bundle.putInt(FIELD_TYPE, this.type);
        bundle.putParcelable(FIELD_COMPONENT_NAME, this.componentName);
        bundle.putString(FIELD_PACKAGE_NAME, this.packageName);
        bundle.putBundle(FIELD_EXTRAS, this.extras);
        return bundle;
    }

    public String toString() {
        return "SessionToken {legacyToken=" + this.legacyToken + p3.f.f29748d;
    }

    public SessionTokenImplLegacy(ComponentName componentName, int i10) {
        this(null, i10, 101, (ComponentName) Assertions.checkNotNull(componentName), componentName.getPackageName(), Bundle.EMPTY);
    }

    private SessionTokenImplLegacy(@Nullable MediaSessionCompat.Token token, int i10, int i11, @Nullable ComponentName componentName, String str, Bundle bundle) {
        this.legacyToken = token;
        this.uid = i10;
        this.type = i11;
        this.componentName = componentName;
        this.packageName = str;
        this.extras = bundle;
    }
}
