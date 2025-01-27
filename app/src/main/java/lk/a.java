package lk;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.czhj.sdk.common.utils.RomUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a */
    public IBinder f28142a;

    public a() {
        Method declaredMethod;
        this.f28142a = null;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            if (!((String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, RomUtils.f8687z, "")).contains("360UI") || (declaredMethod = Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class)) == null) {
                return;
            }
            this.f28142a = (IBinder) declaredMethod.invoke(null, "qikuid");
        } catch (Exception e10) {
            Log.e("QikuIdmanager", "Failure get qikuid service", e10);
        }
    }

    public final boolean a() {
        if (this.f28142a != null) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                this.f28142a.transact(2, obtain, obtain2, 0);
                return obtain2.readInt() == 1;
            } catch (RemoteException e10) {
                e10.printStackTrace();
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
        }
        return false;
    }
}
