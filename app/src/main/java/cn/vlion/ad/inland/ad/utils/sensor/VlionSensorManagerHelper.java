package cn.vlion.ad.inland.ad.utils.sensor;

import android.content.Context;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VlionSensorManagerHelper {
    private static volatile VlionSensorManagerHelper sInstance;
    private a vlionSensorManagerListener;

    private VlionSensorManagerHelper() {
    }

    public static VlionSensorManagerHelper getInstance() {
        if (sInstance == null) {
            synchronized (VlionSensorManagerHelper.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new VlionSensorManagerHelper();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    public synchronized void registerShakeListener(Context context, VlionSensorBean vlionSensorBean) {
        try {
            if (this.vlionSensorManagerListener == null && context != null) {
                this.vlionSensorManagerListener = new a(context);
            }
            a aVar = this.vlionSensorManagerListener;
            if (aVar != null) {
                synchronized (aVar) {
                    if (vlionSensorBean != null) {
                        try {
                            if (!vlionSensorBean.equals(aVar.f2823e)) {
                                aVar.f2823e = vlionSensorBean;
                                try {
                                    aVar.f2825g = -1L;
                                    aVar.f2826h = -1L;
                                    aVar.f2827i = new ArrayList();
                                    aVar.f2828j = new ArrayList();
                                    aVar.f2829k = -1L;
                                    aVar.f2820b = new float[4];
                                    aVar.f2821c = false;
                                    aVar.f2822d = new float[4];
                                    aVar.d();
                                } catch (Throwable th2) {
                                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                                }
                            }
                        } finally {
                        }
                    }
                }
            }
        } finally {
        }
    }

    public synchronized void unregisterShakeListener(VlionSensorBean vlionSensorBean) {
        try {
            a aVar = this.vlionSensorManagerListener;
            if (aVar != null) {
                synchronized (aVar) {
                    if (vlionSensorBean != null) {
                        try {
                            if (vlionSensorBean.equals(aVar.f2823e)) {
                                aVar.f2823e = null;
                                try {
                                    aVar.f2825g = -1L;
                                    aVar.f2826h = -1L;
                                    aVar.f2827i = new ArrayList();
                                    aVar.f2828j = new ArrayList();
                                    aVar.f2829k = -1L;
                                    aVar.f2820b = new float[4];
                                    aVar.f2821c = false;
                                    aVar.f2822d = new float[4];
                                    aVar.d();
                                } catch (Throwable th2) {
                                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                                }
                            }
                        } finally {
                        }
                    }
                }
            }
        } finally {
        }
    }
}
