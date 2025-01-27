package androidx.media3.session;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.app.BundleCompat;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.session.SessionToken;
import b5.r;

/* loaded from: classes.dex */
final class SessionTokenImplBase implements SessionToken.SessionTokenImpl {

    @Nullable
    private final ComponentName componentName;
    private final Bundle extras;

    @Nullable
    private final IBinder iSession;
    private final int interfaceVersion;
    private final int libraryVersion;
    private final String packageName;
    private final String serviceName;
    private final int type;
    private final int uid;
    private static final String FIELD_UID = Util.intToStringMaxRadix(0);
    private static final String FIELD_TYPE = Util.intToStringMaxRadix(1);
    private static final String FIELD_LIBRARY_VERSION = Util.intToStringMaxRadix(2);
    private static final String FIELD_PACKAGE_NAME = Util.intToStringMaxRadix(3);
    private static final String FIELD_SERVICE_NAME = Util.intToStringMaxRadix(4);
    private static final String FIELD_COMPONENT_NAME = Util.intToStringMaxRadix(5);
    private static final String FIELD_ISESSION = Util.intToStringMaxRadix(6);
    private static final String FIELD_EXTRAS = Util.intToStringMaxRadix(7);
    private static final String FIELD_INTERFACE_VERSION = Util.intToStringMaxRadix(8);
    public static final Bundleable.Creator<SessionTokenImplBase> CREATOR = new Bundleable.Creator() { // from class: androidx.media3.session.yd
        @Override // androidx.media3.common.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            SessionTokenImplBase fromBundle;
            fromBundle = SessionTokenImplBase.fromBundle(bundle);
            return fromBundle;
        }
    };

    public SessionTokenImplBase(ComponentName componentName, int i10, int i11) {
        this(i10, i11, 0, 0, ((ComponentName) Assertions.checkNotNull(componentName)).getPackageName(), componentName.getClassName(), componentName, null, Bundle.EMPTY);
    }

    public static SessionTokenImplBase fromBundle(Bundle bundle) {
        String str = FIELD_UID;
        Assertions.checkArgument(bundle.containsKey(str), "uid should be set.");
        int i10 = bundle.getInt(str);
        String str2 = FIELD_TYPE;
        Assertions.checkArgument(bundle.containsKey(str2), "type should be set.");
        int i11 = bundle.getInt(str2);
        int i12 = bundle.getInt(FIELD_LIBRARY_VERSION, 0);
        int i13 = bundle.getInt(FIELD_INTERFACE_VERSION, 0);
        String checkNotEmpty = Assertions.checkNotEmpty(bundle.getString(FIELD_PACKAGE_NAME), "package name should be set.");
        String string = bundle.getString(FIELD_SERVICE_NAME, "");
        IBinder binder = BundleCompat.getBinder(bundle, FIELD_ISESSION);
        ComponentName componentName = (ComponentName) bundle.getParcelable(FIELD_COMPONENT_NAME);
        Bundle bundle2 = bundle.getBundle(FIELD_EXTRAS);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        return new SessionTokenImplBase(i10, i11, i12, i13, checkNotEmpty, string, componentName, binder, bundle2);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SessionTokenImplBase)) {
            return false;
        }
        SessionTokenImplBase sessionTokenImplBase = (SessionTokenImplBase) obj;
        return this.uid == sessionTokenImplBase.uid && this.type == sessionTokenImplBase.type && this.libraryVersion == sessionTokenImplBase.libraryVersion && this.interfaceVersion == sessionTokenImplBase.interfaceVersion && TextUtils.equals(this.packageName, sessionTokenImplBase.packageName) && TextUtils.equals(this.serviceName, sessionTokenImplBase.serviceName) && Util.areEqual(this.componentName, sessionTokenImplBase.componentName) && Util.areEqual(this.iSession, sessionTokenImplBase.iSession);
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    @Nullable
    public Object getBinder() {
        return this.iSession;
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
        return this.interfaceVersion;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public int getLibraryVersion() {
        return this.libraryVersion;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public String getPackageName() {
        return this.packageName;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public String getServiceName() {
        return this.serviceName;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public int getType() {
        return this.type;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public int getUid() {
        return this.uid;
    }

    public int hashCode() {
        return r.b(Integer.valueOf(this.uid), Integer.valueOf(this.type), Integer.valueOf(this.libraryVersion), Integer.valueOf(this.interfaceVersion), this.packageName, this.serviceName, this.componentName, this.iSession);
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public boolean isLegacySession() {
        return false;
    }

    @Override // androidx.media3.common.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_UID, this.uid);
        bundle.putInt(FIELD_TYPE, this.type);
        bundle.putInt(FIELD_LIBRARY_VERSION, this.libraryVersion);
        bundle.putString(FIELD_PACKAGE_NAME, this.packageName);
        bundle.putString(FIELD_SERVICE_NAME, this.serviceName);
        BundleCompat.putBinder(bundle, FIELD_ISESSION, this.iSession);
        bundle.putParcelable(FIELD_COMPONENT_NAME, this.componentName);
        bundle.putBundle(FIELD_EXTRAS, this.extras);
        bundle.putInt(FIELD_INTERFACE_VERSION, this.interfaceVersion);
        return bundle;
    }

    public String toString() {
        return "SessionToken {pkg=" + this.packageName + " type=" + this.type + " libraryVersion=" + this.libraryVersion + " interfaceVersion=" + this.interfaceVersion + " service=" + this.serviceName + " IMediaSession=" + this.iSession + " extras=" + this.extras + p3.f.f29748d;
    }

    public SessionTokenImplBase(int i10, int i11, int i12, int i13, String str, IMediaSession iMediaSession, Bundle bundle) {
        this(i10, i11, i12, i13, (String) Assertions.checkNotNull(str), "", null, iMediaSession.asBinder(), (Bundle) Assertions.checkNotNull(bundle));
    }

    private SessionTokenImplBase(int i10, int i11, int i12, int i13, String str, String str2, @Nullable ComponentName componentName, @Nullable IBinder iBinder, Bundle bundle) {
        this.uid = i10;
        this.type = i11;
        this.libraryVersion = i12;
        this.interfaceVersion = i13;
        this.packageName = str;
        this.serviceName = str2;
        this.componentName = componentName;
        this.iSession = iBinder;
        this.extras = bundle;
    }
}
