package com.alimm.tanx.core.utils;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.sigmob.sdk.base.mta.PointCategory;
import ug.b;
import ug.c;

/* loaded from: classes.dex */
public class DeviceIdGetUtil implements NotConfused {
    private static final int DEVICE_ID_GET_MAX_COUNT = 3;
    private static final String TAG = "DeviceIdGetUtil-";
    private static DeviceIdGetUtil instance;
    private volatile int imeiGetNowCount = 0;
    private volatile int oaidGetNowCount = 0;
    private volatile String oaid = "";
    private volatile String imei = "";

    /* renamed from: com.alimm.tanx.core.utils.DeviceIdGetUtil$1 */
    public class AnonymousClass1 implements c {
        final /* synthetic */ long tanxc_do;

        public AnonymousClass1(long j10) {
            currentTimeMillis = j10;
        }

        @Override // ug.c
        public void oaidError(Exception exc) {
            LogUtils.e("DeviceIdGetUtil-oaidGet", exc);
            if (Build.VERSION.SDK_INT >= 29) {
                TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "DeviceIdGetUtil-oaidGet", LogUtils.getStackTraceMessage(exc), "");
            }
        }

        @Override // ug.c
        public void oaidSucc(String str) {
            if (!TextUtils.isEmpty(str)) {
                DeviceIdGetUtil.this.oaid = str;
            }
            LogUtils.d("DeviceIdGetUtil-oaidGet", str + "\ntime-> " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private DeviceIdGetUtil() {
    }

    private void getImei4OnlyId(Context context, boolean z10) {
        if (TextUtils.isEmpty(this.imei)) {
            String imei = TanxCoreSdk.getConfig().getImei();
            if (!TextUtils.isEmpty(imei)) {
                this.imei = imei;
            }
            if (context == null) {
                LogUtils.e(TAG, "getImei4OnlyId 设备id工具类未初始化，或入参context为空");
                return;
            }
            if (z10) {
                this.oaid = b.h().j(context, z10);
                return;
            }
            if (TanxCoreSdk.getConfig().isImeiSwitch()) {
                if (this.imeiGetNowCount >= 3) {
                    return;
                }
                LogUtils.d(TAG, "通过api调用获取imei");
                String f10 = b.h().f(context);
                if (!TextUtils.isEmpty(f10)) {
                    this.imei = f10;
                }
                this.imeiGetNowCount++;
            }
            LogUtils.d("DeviceIdGetUtil-imeiGet", this.imei);
        }
    }

    public static DeviceIdGetUtil getInstance() {
        if (instance == null) {
            synchronized (b.class) {
                try {
                    if (instance == null) {
                        instance = new DeviceIdGetUtil();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    private void getOaid4OnlyId(Context context, boolean z10) {
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(this.oaid)) {
            String oaid = TanxCoreSdk.getConfig().getOaid();
            if (!TextUtils.isEmpty(oaid)) {
                this.oaid = oaid;
            }
            if (context == null) {
                LogUtils.e(TAG, "getOaid4OnlyId 设备id工具类未初始化，或入参context为空");
                return;
            }
            if (z10) {
                this.oaid = b.h().j(context, z10);
            } else {
                if (!TanxCoreSdk.getConfig().isOaidSwitch() || this.oaidGetNowCount >= 3) {
                    return;
                }
                LogUtils.d(TAG, "通过api调用获取oaid");
                b.h().k(context, false, new c() { // from class: com.alimm.tanx.core.utils.DeviceIdGetUtil.1
                    final /* synthetic */ long tanxc_do;

                    public AnonymousClass1(long currentTimeMillis2) {
                        currentTimeMillis = currentTimeMillis2;
                    }

                    @Override // ug.c
                    public void oaidError(Exception exc) {
                        LogUtils.e("DeviceIdGetUtil-oaidGet", exc);
                        if (Build.VERSION.SDK_INT >= 29) {
                            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "DeviceIdGetUtil-oaidGet", LogUtils.getStackTraceMessage(exc), "");
                        }
                    }

                    @Override // ug.c
                    public void oaidSucc(String str) {
                        if (!TextUtils.isEmpty(str)) {
                            DeviceIdGetUtil.this.oaid = str;
                        }
                        LogUtils.d("DeviceIdGetUtil-oaidGet", str + "\ntime-> " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                });
                this.oaidGetNowCount++;
            }
        }
    }

    public void getAllIdOnlyCache() {
        try {
            LogUtils.d(TAG, "getAllIdOnlyCache");
            getImei(true);
            getOaid(true);
        } catch (Exception e10) {
            LogUtils.e("DeviceIdGetUtil-getAllIdOnlyCache", e10);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "DeviceIdGetUtil-getAllIdOnlyCache", LogUtils.getStackTraceMessage(e10), "");
        }
    }

    public String getImei() {
        return getImei(false);
    }

    public String getOaid() {
        return getOaid(false);
    }

    public void init(Application application) {
        LogUtils.d(TAG, PointCategory.INIT);
        b.h().n(application);
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setOaid(String str) {
        this.oaid = str;
    }

    public String getImei(boolean z10) {
        return getImei(TanxCoreSdk.getApplication(), z10);
    }

    public String getOaid(boolean z10) {
        return getOaid(TanxCoreSdk.getApplication(), z10);
    }

    public String getImei(Context context, boolean z10) {
        getImei4OnlyId(context, z10);
        return this.imei;
    }

    public String getOaid(Context context, boolean z10) {
        getOaid4OnlyId(context, z10);
        return this.oaid;
    }
}
