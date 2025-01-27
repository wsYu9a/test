package com.kwai.filedownloader.b;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwai.filedownloader.b.a;

/* loaded from: classes2.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* renamed from: com.kwai.filedownloader.b.b$a$a */
        static class C0241a implements b {
            public static b aIo;
            private IBinder mRemote;

            C0241a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.kwai.filedownloader.b.b
            public final void Il() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    if (this.mRemote.transact(15, obtain, obtain2, 0) || a.Im() == null) {
                        obtain2.readException();
                    } else {
                        a.Im().Il();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final void a(com.kwai.filedownloader.b.a aVar) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.mRemote.transact(1, obtain, null, 1) || a.Im() == null) {
                        return;
                    }
                    a.Im().a(aVar);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final boolean am(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && a.Im() != null) {
                        return a.Im().am(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.kwai.filedownloader.b.b
            public final void b(com.kwai.filedownloader.b.a aVar) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.mRemote.transact(2, obtain, null, 1) || a.Im() == null) {
                        return;
                    }
                    a.Im().b(aVar);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final void b(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, com.kwai.filedownloader.c.b bVar, boolean z3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    int i5 = 1;
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeInt(z2 ? 1 : 0);
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z3) {
                        i5 = 0;
                    }
                    obtain.writeInt(i5);
                    try {
                        if (this.mRemote.transact(4, obtain, obtain2, 0) || a.Im() == null) {
                            obtain2.readException();
                        } else {
                            a.Im().b(str, str2, z, i2, i3, i4, z2, bVar, z3);
                        }
                        obtain2.recycle();
                        obtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final boolean cB(int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && a.Im() != null) {
                        return a.Im().cB(i2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final byte cC(int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && a.Im() != null) {
                        return a.Im().cC(i2);
                    }
                    obtain2.readException();
                    return obtain2.readByte();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final boolean cD(int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && a.Im() != null) {
                        return a.Im().cD(i2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final boolean cV(int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && a.Im() != null) {
                        return a.Im().cV(i2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final long cW(int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && a.Im() != null) {
                        return a.Im().cW(i2);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final long cX(int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && a.Im() != null) {
                        return a.Im().cX(i2);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final boolean isIdle() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && a.Im() != null) {
                        return a.Im().isIdle();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final void pauseAllTasks() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || a.Im() == null) {
                        obtain2.readException();
                    } else {
                        a.Im().pauseAllTasks();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final void startForeground(int i2, Notification notification) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i2);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(12, obtain, null, 1) || a.Im() == null) {
                        return;
                    }
                    a.Im().startForeground(i2, notification);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final void stopForeground(boolean z) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(13, obtain, null, 1) || a.Im() == null) {
                        return;
                    }
                    a.Im().stopForeground(z);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.kwai.filedownloader.i.IFileDownloadIPCService");
        }

        public static b Im() {
            return C0241a.aIo;
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C0241a(iBinder) : (b) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1598968902) {
                parcel2.writeString("com.kwai.filedownloader.i.IFileDownloadIPCService");
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    a(a.AbstractBinderC0239a.c(parcel.readStrongBinder()));
                    return true;
                case 2:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    b(a.AbstractBinderC0239a.c(parcel.readStrongBinder()));
                    return true;
                case 3:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    boolean am = am(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(am ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    b(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0 ? com.kwai.filedownloader.c.b.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    boolean cB = cB(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(cB ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    pauseAllTasks();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    boolean cV = cV(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(cV ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    long cW = cW(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(cW);
                    return true;
                case 9:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    long cX = cX(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(cX);
                    return true;
                case 10:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    byte cC = cC(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeByte(cC);
                    return true;
                case 11:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    boolean isIdle = isIdle();
                    parcel2.writeNoException();
                    parcel2.writeInt(isIdle ? 1 : 0);
                    return true;
                case 12:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    startForeground(parcel.readInt(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 13:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    stopForeground(parcel.readInt() != 0);
                    return true;
                case 14:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    boolean cD = cD(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(cD ? 1 : 0);
                    return true;
                case 15:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    Il();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }
    }

    void Il();

    void a(com.kwai.filedownloader.b.a aVar);

    boolean am(String str, String str2);

    void b(com.kwai.filedownloader.b.a aVar);

    void b(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, com.kwai.filedownloader.c.b bVar, boolean z3);

    boolean cB(int i2);

    byte cC(int i2);

    boolean cD(int i2);

    boolean cV(int i2);

    long cW(int i2);

    long cX(int i2);

    boolean isIdle();

    void pauseAllTasks();

    void startForeground(int i2, Notification notification);

    void stopForeground(boolean z);
}
