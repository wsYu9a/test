package androidx.media3.session;

import android.os.Bundle;
import androidx.media3.common.Bundleable;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;

/* loaded from: classes.dex */
class ConnectionRequest implements Bundleable {
    public final Bundle connectionHints;
    public final int controllerInterfaceVersion;
    public final int libraryVersion;
    public final String packageName;
    public final int pid;
    private static final String FIELD_LIBRARY_VERSION = Util.intToStringMaxRadix(0);
    private static final String FIELD_PACKAGE_NAME = Util.intToStringMaxRadix(1);
    private static final String FIELD_PID = Util.intToStringMaxRadix(2);
    private static final String FIELD_CONNECTION_HINTS = Util.intToStringMaxRadix(3);
    private static final String FIELD_CONTROLLER_INTERFACE_VERSION = Util.intToStringMaxRadix(4);
    public static final Bundleable.Creator<ConnectionRequest> CREATOR = new Bundleable.Creator() { // from class: androidx.media3.session.d
        @Override // androidx.media3.common.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            ConnectionRequest lambda$static$0;
            lambda$static$0 = ConnectionRequest.lambda$static$0(bundle);
            return lambda$static$0;
        }
    };

    public ConnectionRequest(String str, int i10, Bundle bundle) {
        this(MediaLibraryInfo.VERSION_INT, 3, str, i10, new Bundle(bundle));
    }

    public static /* synthetic */ ConnectionRequest lambda$static$0(Bundle bundle) {
        int i10 = bundle.getInt(FIELD_LIBRARY_VERSION, 0);
        int i11 = bundle.getInt(FIELD_CONTROLLER_INTERFACE_VERSION, 0);
        String str = (String) Assertions.checkNotNull(bundle.getString(FIELD_PACKAGE_NAME));
        String str2 = FIELD_PID;
        Assertions.checkArgument(bundle.containsKey(str2));
        int i12 = bundle.getInt(str2);
        Bundle bundle2 = bundle.getBundle(FIELD_CONNECTION_HINTS);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        return new ConnectionRequest(i10, i11, str, i12, bundle2);
    }

    @Override // androidx.media3.common.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_LIBRARY_VERSION, this.libraryVersion);
        bundle.putString(FIELD_PACKAGE_NAME, this.packageName);
        bundle.putInt(FIELD_PID, this.pid);
        bundle.putBundle(FIELD_CONNECTION_HINTS, this.connectionHints);
        bundle.putInt(FIELD_CONTROLLER_INTERFACE_VERSION, this.controllerInterfaceVersion);
        return bundle;
    }

    private ConnectionRequest(int i10, int i11, String str, int i12, Bundle bundle) {
        this.libraryVersion = i10;
        this.controllerInterfaceVersion = i11;
        this.packageName = str;
        this.pid = i12;
        this.connectionHints = bundle;
    }
}
