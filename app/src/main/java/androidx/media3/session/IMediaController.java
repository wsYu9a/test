package androidx.media3.session;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface IMediaController extends IInterface {

    public static class Default implements IMediaController {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.media3.session.IMediaController
        public void onAvailableCommandsChangedFromPlayer(int i10, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onAvailableCommandsChangedFromSession(int i10, Bundle bundle, Bundle bundle2) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onChildrenChanged(int i10, String str, int i11, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onConnected(int i10, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onCustomCommand(int i10, Bundle bundle, Bundle bundle2) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onDisconnected(int i10) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onExtrasChanged(int i10, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onLibraryResult(int i10, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onPeriodicSessionPositionInfoChanged(int i10, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onPlayerInfoChanged(int i10, Bundle bundle, boolean z10) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onPlayerInfoChangedWithExclusions(int i10, Bundle bundle, Bundle bundle2) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onRenderedFirstFrame(int i10) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onSearchResultChanged(int i10, String str, int i11, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onSessionActivityChanged(int i10, PendingIntent pendingIntent) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onSessionResult(int i10, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onSetCustomLayout(int i10, List<Bundle> list) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IMediaController {
        private static final String DESCRIPTOR = "androidx.media3.session.IMediaController";
        static final int TRANSACTION_onAvailableCommandsChangedFromPlayer = 3009;
        static final int TRANSACTION_onAvailableCommandsChangedFromSession = 3010;
        static final int TRANSACTION_onChildrenChanged = 4001;
        static final int TRANSACTION_onConnected = 3001;
        static final int TRANSACTION_onCustomCommand = 3005;
        static final int TRANSACTION_onDisconnected = 3006;
        static final int TRANSACTION_onExtrasChanged = 3012;
        static final int TRANSACTION_onLibraryResult = 3003;
        static final int TRANSACTION_onPeriodicSessionPositionInfoChanged = 3008;
        static final int TRANSACTION_onPlayerInfoChanged = 3007;
        static final int TRANSACTION_onPlayerInfoChangedWithExclusions = 3013;
        static final int TRANSACTION_onRenderedFirstFrame = 3011;
        static final int TRANSACTION_onSearchResultChanged = 4002;
        static final int TRANSACTION_onSessionActivityChanged = 3014;
        static final int TRANSACTION_onSessionResult = 3002;
        static final int TRANSACTION_onSetCustomLayout = 3004;

        public static class Proxy implements IMediaController {
            public static IMediaController sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // androidx.media3.session.IMediaController
            public void onAvailableCommandsChangedFromPlayer(int i10, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_onAvailableCommandsChangedFromPlayer, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onAvailableCommandsChangedFromPlayer(i10, bundle);
                        obtain.recycle();
                    }
                } catch (Throwable th2) {
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onAvailableCommandsChangedFromSession(int i10, Bundle bundle, Bundle bundle2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        obtain.writeInt(1);
                        bundle2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_onAvailableCommandsChangedFromSession, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onAvailableCommandsChangedFromSession(i10, bundle, bundle2);
                        obtain.recycle();
                    }
                } catch (Throwable th2) {
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onChildrenChanged(int i10, String str, int i11, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeString(str);
                    obtain.writeInt(i11);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(4001, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onChildrenChanged(i10, str, i11, bundle);
                        obtain.recycle();
                    }
                } catch (Throwable th2) {
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onConnected(int i10, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3001, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onConnected(i10, bundle);
                        obtain.recycle();
                    }
                } catch (Throwable th2) {
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onCustomCommand(int i10, Bundle bundle, Bundle bundle2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        obtain.writeInt(1);
                        bundle2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3005, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onCustomCommand(i10, bundle, bundle2);
                        obtain.recycle();
                    }
                } catch (Throwable th2) {
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onDisconnected(int i10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    if (this.mRemote.transact(3006, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onDisconnected(i10);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onExtrasChanged(int i10, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_onExtrasChanged, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onExtrasChanged(i10, bundle);
                        obtain.recycle();
                    }
                } catch (Throwable th2) {
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onLibraryResult(int i10, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3003, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onLibraryResult(i10, bundle);
                        obtain.recycle();
                    }
                } catch (Throwable th2) {
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onPeriodicSessionPositionInfoChanged(int i10, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_onPeriodicSessionPositionInfoChanged, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onPeriodicSessionPositionInfoChanged(i10, bundle);
                        obtain.recycle();
                    }
                } catch (Throwable th2) {
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onPlayerInfoChanged(int i10, Bundle bundle, boolean z10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(z10 ? 1 : 0);
                    if (this.mRemote.transact(Stub.TRANSACTION_onPlayerInfoChanged, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onPlayerInfoChanged(i10, bundle, z10);
                        obtain.recycle();
                    }
                } catch (Throwable th2) {
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onPlayerInfoChangedWithExclusions(int i10, Bundle bundle, Bundle bundle2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        obtain.writeInt(1);
                        bundle2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_onPlayerInfoChangedWithExclusions, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onPlayerInfoChangedWithExclusions(i10, bundle, bundle2);
                        obtain.recycle();
                    }
                } catch (Throwable th2) {
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onRenderedFirstFrame(int i10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    if (this.mRemote.transact(Stub.TRANSACTION_onRenderedFirstFrame, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onRenderedFirstFrame(i10);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onSearchResultChanged(int i10, String str, int i11, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeString(str);
                    obtain.writeInt(i11);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(4002, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onSearchResultChanged(i10, str, i11, bundle);
                        obtain.recycle();
                    }
                } catch (Throwable th2) {
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onSessionActivityChanged(int i10, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_onSessionActivityChanged, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onSessionActivityChanged(i10, pendingIntent);
                        obtain.recycle();
                    }
                } catch (Throwable th2) {
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onSessionResult(int i10, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3002, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onSessionResult(i10, bundle);
                        obtain.recycle();
                    }
                } catch (Throwable th2) {
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onSetCustomLayout(int i10, List<Bundle> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeTypedList(list);
                    if (this.mRemote.transact(3004, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onSetCustomLayout(i10, list);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaController asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IMediaController)) ? new Proxy(iBinder) : (IMediaController) queryLocalInterface;
        }

        public static IMediaController getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMediaController iMediaController) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iMediaController == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMediaController;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 4001) {
                parcel.enforceInterface(DESCRIPTOR);
                onChildrenChanged(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i10 == 4002) {
                parcel.enforceInterface(DESCRIPTOR);
                onSearchResultChanged(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i10 == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 3001:
                    parcel.enforceInterface(DESCRIPTOR);
                    onConnected(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 3002:
                    parcel.enforceInterface(DESCRIPTOR);
                    onSessionResult(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 3003:
                    parcel.enforceInterface(DESCRIPTOR);
                    onLibraryResult(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 3004:
                    parcel.enforceInterface(DESCRIPTOR);
                    onSetCustomLayout(parcel.readInt(), parcel.createTypedArrayList(Bundle.CREATOR));
                    return true;
                case 3005:
                    parcel.enforceInterface(DESCRIPTOR);
                    onCustomCommand(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 3006:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDisconnected(parcel.readInt());
                    return true;
                case TRANSACTION_onPlayerInfoChanged /* 3007 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPlayerInfoChanged(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                    return true;
                case TRANSACTION_onPeriodicSessionPositionInfoChanged /* 3008 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPeriodicSessionPositionInfoChanged(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case TRANSACTION_onAvailableCommandsChangedFromPlayer /* 3009 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    onAvailableCommandsChangedFromPlayer(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case TRANSACTION_onAvailableCommandsChangedFromSession /* 3010 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    onAvailableCommandsChangedFromSession(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case TRANSACTION_onRenderedFirstFrame /* 3011 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    onRenderedFirstFrame(parcel.readInt());
                    return true;
                case TRANSACTION_onExtrasChanged /* 3012 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    onExtrasChanged(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case TRANSACTION_onPlayerInfoChangedWithExclusions /* 3013 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPlayerInfoChangedWithExclusions(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case TRANSACTION_onSessionActivityChanged /* 3014 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    onSessionActivityChanged(parcel.readInt(), parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    void onAvailableCommandsChangedFromPlayer(int i10, Bundle bundle) throws RemoteException;

    void onAvailableCommandsChangedFromSession(int i10, Bundle bundle, Bundle bundle2) throws RemoteException;

    void onChildrenChanged(int i10, String str, int i11, Bundle bundle) throws RemoteException;

    void onConnected(int i10, Bundle bundle) throws RemoteException;

    void onCustomCommand(int i10, Bundle bundle, Bundle bundle2) throws RemoteException;

    void onDisconnected(int i10) throws RemoteException;

    void onExtrasChanged(int i10, Bundle bundle) throws RemoteException;

    void onLibraryResult(int i10, Bundle bundle) throws RemoteException;

    void onPeriodicSessionPositionInfoChanged(int i10, Bundle bundle) throws RemoteException;

    void onPlayerInfoChanged(int i10, Bundle bundle, boolean z10) throws RemoteException;

    void onPlayerInfoChangedWithExclusions(int i10, Bundle bundle, Bundle bundle2) throws RemoteException;

    void onRenderedFirstFrame(int i10) throws RemoteException;

    void onSearchResultChanged(int i10, String str, int i11, Bundle bundle) throws RemoteException;

    void onSessionActivityChanged(int i10, PendingIntent pendingIntent) throws RemoteException;

    void onSessionResult(int i10, Bundle bundle) throws RemoteException;

    void onSetCustomLayout(int i10, List<Bundle> list) throws RemoteException;
}
