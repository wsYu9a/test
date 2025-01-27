package com.repack.asus.msa.sdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import androidx.annotation.Keep;
import com.repack.bun.supplier.SupplierListener;
import eh.a;
import nh.b;

@Keep
/* loaded from: classes3.dex */
public class SupplementaryDIDManager {
    public static boolean DEBUG = false;
    public static final String TAG = "SupplementaryDIDManager";
    public Context mContext;
    public eh.a mDidService;
    public nh.a mListener;
    public boolean isBinded = false;
    public ServiceConnection mServiceConnection = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            eh.a c0693a;
            if (SupplementaryDIDManager.DEBUG) {
                Log.i(SupplementaryDIDManager.TAG, "did service binded");
            }
            SupplementaryDIDManager supplementaryDIDManager = SupplementaryDIDManager.this;
            int i10 = a.AbstractBinderC0692a.f25908b;
            if (iBinder == null) {
                c0693a = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                c0693a = (queryLocalInterface == null || !(queryLocalInterface instanceof eh.a)) ? new a.AbstractBinderC0692a.C0693a(iBinder) : (eh.a) queryLocalInterface;
            }
            supplementaryDIDManager.mDidService = c0693a;
            SupplementaryDIDManager.this.notifyAllListeners(true);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            SupplementaryDIDManager.this.notifyAllListeners(false);
        }
    }

    public SupplementaryDIDManager(Context context) {
        this.mContext = context;
    }

    public void notifyAllListeners(boolean z10) {
        try {
            if (z10) {
                ((mh.a) this.mListener).g(this.mDidService);
            } else {
                mh.a aVar = (mh.a) this.mListener;
                SupplierListener supplierListener = aVar.f28699b;
                if (supplierListener != null) {
                    supplierListener.OnSupport(false, aVar);
                }
            }
        } catch (Exception e10) {
            if (DEBUG) {
                StringBuilder a10 = b.a("notify did bind status error :");
                a10.append(e10.getMessage());
                Log.e(TAG, a10.toString());
            }
        }
    }

    public void deInit() {
        try {
            if (!this.isBinded || this.mServiceConnection == null || this.mContext == null) {
                return;
            }
            if (DEBUG) {
                Log.i(TAG, "start to unbind did service");
            }
            this.isBinded = false;
            this.mContext.unbindService(this.mServiceConnection);
        } catch (Exception e10) {
            Log.w(TAG, e10.getMessage());
        }
    }

    public void init(nh.a aVar) {
        try {
            this.mListener = aVar;
            Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
            ComponentName componentName = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
            Intent intent2 = new Intent(intent);
            intent2.setComponent(componentName);
            if (DEBUG) {
                Log.i(TAG, "start to bind did service.");
            }
            this.isBinded = this.mContext.bindService(intent2, this.mServiceConnection, 1);
        } catch (Exception unused) {
            notifyAllListeners(false);
        }
    }

    public void showLog(boolean z10) {
        DEBUG = z10;
    }
}
