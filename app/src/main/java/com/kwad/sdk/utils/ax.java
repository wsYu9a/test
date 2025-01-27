package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class ax {
    private static Context aAp;
    private static Map<String, j> aAq = new HashMap();
    private static b aAr;

    static class a extends j<com.kwad.sdk.h.kwai.b> {
        private static com.kwad.sdk.h.kwai.b aAs;

        public a(boolean z) {
            super(z);
        }

        @RequiresApi(api = 17)
        @SuppressLint({"BlockedPrivateApi"})
        private static int a(CellInfo cellInfo) {
            if (cellInfo == null) {
                return -1;
            }
            try {
                return ((CellSignalStrength) s.a((Object) cellInfo, "getCellSignalStrength", new Object[0])).getLevel();
            } catch (Throwable unused) {
                return -1;
            }
        }

        @Override // com.kwad.sdk.utils.j
        /* renamed from: cG */
        public com.kwad.sdk.h.kwai.b bG(Context context) {
            int i2;
            int i3;
            if (at.DU() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(64L)) {
                return aAs;
            }
            com.kwad.sdk.h.kwai.b bVar = aAs;
            if (bVar != null) {
                return bVar;
            }
            CellInfo cellInfo = null;
            if (context == null || at.DU()) {
                return null;
            }
            int i4 = Build.VERSION.SDK_INT;
            int i5 = -1;
            if (i4 >= 23 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f9322g) == -1) {
                return null;
            }
            if (bd.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f9322g) == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                CellLocation cellLocation = telephonyManager.getCellLocation();
                if (cellLocation instanceof CdmaCellLocation) {
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                    i3 = cdmaCellLocation.getBaseStationId();
                    i2 = cdmaCellLocation.getNetworkId();
                } else if (cellLocation instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    i3 = gsmCellLocation.getCid();
                    i2 = gsmCellLocation.getLac();
                } else {
                    i2 = -1;
                    i3 = -1;
                }
                if (i4 >= 17) {
                    Iterator<CellInfo> it = telephonyManager.getAllCellInfo().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        CellInfo next = it.next();
                        if (next != null && next.isRegistered()) {
                            cellInfo = next;
                            break;
                        }
                    }
                    if (cellInfo != null) {
                        i5 = a(cellInfo);
                    }
                }
                aAs = new com.kwad.sdk.h.kwai.b(i3, i2, i5);
            }
            return aAs;
        }
    }

    static class b implements SensorEventListener {
        private d aAt;
        private d aAu;
        private d aAv;
        protected boolean azm = false;
        private boolean aAw = false;

        /* renamed from: com.kwad.sdk.utils.ax$b$1 */
        final class AnonymousClass1 extends c {
            final /* synthetic */ List aAx;
            final /* synthetic */ SensorManager aAy;
            final /* synthetic */ CountDownLatch asB;

            AnonymousClass1(List list, CountDownLatch countDownLatch, SensorManager sensorManager) {
                arrayList = list;
                countDownLatch = countDownLatch;
                sensorManager = sensorManager;
            }

            @Override // android.hardware.SensorEventListener
            public final void onSensorChanged(SensorEvent sensorEvent) {
                com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                arrayList.add(com.kwad.sdk.h.kwai.e.a(sensorEvent, System.currentTimeMillis()));
                countDownLatch.countDown();
                sensorManager.unregisterListener(this);
            }
        }

        /* renamed from: com.kwad.sdk.utils.ax$b$2 */
        final class AnonymousClass2 extends c {
            final /* synthetic */ List aAx;
            final /* synthetic */ SensorManager aAy;
            final /* synthetic */ CountDownLatch asB;

            AnonymousClass2(List list, CountDownLatch countDownLatch, SensorManager sensorManager) {
                arrayList = list;
                countDownLatch = countDownLatch;
                sensorManager = sensorManager;
            }

            @Override // android.hardware.SensorEventListener
            public final void onSensorChanged(SensorEvent sensorEvent) {
                com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                arrayList.add(com.kwad.sdk.h.kwai.e.a(sensorEvent, System.currentTimeMillis()));
                countDownLatch.countDown();
                sensorManager.unregisterListener(this);
            }
        }

        /* renamed from: com.kwad.sdk.utils.ax$b$3 */
        final class AnonymousClass3 extends c {
            final /* synthetic */ List aAx;
            final /* synthetic */ SensorManager aAy;
            final /* synthetic */ CountDownLatch asB;

            AnonymousClass3(List list, CountDownLatch countDownLatch, SensorManager sensorManager) {
                arrayList = list;
                countDownLatch = countDownLatch;
                sensorManager = sensorManager;
            }

            @Override // android.hardware.SensorEventListener
            public final void onSensorChanged(SensorEvent sensorEvent) {
                com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                arrayList.add(com.kwad.sdk.h.kwai.e.a(sensorEvent, System.currentTimeMillis()));
                countDownLatch.countDown();
                sensorManager.unregisterListener(this);
            }
        }

        public b(Context context) {
            try {
                cH(context);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
        }

        private List<com.kwad.sdk.h.kwai.e> Eq() {
            ArrayList arrayList = new ArrayList();
            d dVar = this.aAt;
            if (dVar != null) {
                arrayList.add(com.kwad.sdk.h.kwai.e.a(dVar.Er(), this.aAt.getTimestamp()));
            }
            d dVar2 = this.aAu;
            if (dVar2 != null) {
                arrayList.add(com.kwad.sdk.h.kwai.e.a(dVar2.Er(), this.aAu.getTimestamp()));
            }
            d dVar3 = this.aAv;
            if (dVar3 != null) {
                arrayList.add(com.kwad.sdk.h.kwai.e.a(dVar3.Er(), this.aAv.getTimestamp()));
            }
            return arrayList;
        }

        private static boolean a(SensorManager sensorManager, int i2, SensorEventListener sensorEventListener) {
            Sensor defaultSensor = sensorManager.getDefaultSensor(i2);
            if (defaultSensor == null) {
                return false;
            }
            return sensorManager.registerListener(sensorEventListener, defaultSensor, 3);
        }

        private void cH(Context context) {
            SensorManager sensorManager;
            try {
                sensorManager = (SensorManager) context.getSystemService(com.umeng.analytics.pro.am.ac);
            } catch (Exception unused) {
                sensorManager = null;
            }
            if (sensorManager == null) {
                return;
            }
            com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "accelerometerSensorAvailable: " + a(sensorManager, 1, this));
            com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "gyroscopeSensorAvailable : " + a(sensorManager, 4, this));
            com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "gravitySensorAvailable : " + a(sensorManager, 9, this));
        }

        @WorkerThread
        private synchronized List<com.kwad.sdk.h.kwai.e> cI(Context context) {
            ArrayList arrayList;
            arrayList = new ArrayList();
            SensorManager sensorManager = (SensorManager) context.getSystemService(com.umeng.analytics.pro.am.ac);
            CountDownLatch countDownLatch = new CountDownLatch(3);
            if (!a(sensorManager, 1, new c() { // from class: com.kwad.sdk.utils.ax.b.1
                final /* synthetic */ List aAx;
                final /* synthetic */ SensorManager aAy;
                final /* synthetic */ CountDownLatch asB;

                AnonymousClass1(List arrayList2, CountDownLatch countDownLatch2, SensorManager sensorManager2) {
                    arrayList = arrayList2;
                    countDownLatch = countDownLatch2;
                    sensorManager = sensorManager2;
                }

                @Override // android.hardware.SensorEventListener
                public final void onSensorChanged(SensorEvent sensorEvent) {
                    com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                    arrayList.add(com.kwad.sdk.h.kwai.e.a(sensorEvent, System.currentTimeMillis()));
                    countDownLatch.countDown();
                    sensorManager.unregisterListener(this);
                }
            })) {
                countDownLatch2.countDown();
            }
            if (!a(sensorManager2, 4, new c() { // from class: com.kwad.sdk.utils.ax.b.2
                final /* synthetic */ List aAx;
                final /* synthetic */ SensorManager aAy;
                final /* synthetic */ CountDownLatch asB;

                AnonymousClass2(List arrayList2, CountDownLatch countDownLatch2, SensorManager sensorManager2) {
                    arrayList = arrayList2;
                    countDownLatch = countDownLatch2;
                    sensorManager = sensorManager2;
                }

                @Override // android.hardware.SensorEventListener
                public final void onSensorChanged(SensorEvent sensorEvent) {
                    com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                    arrayList.add(com.kwad.sdk.h.kwai.e.a(sensorEvent, System.currentTimeMillis()));
                    countDownLatch.countDown();
                    sensorManager.unregisterListener(this);
                }
            })) {
                countDownLatch2.countDown();
            }
            if (!a(sensorManager2, 9, new c() { // from class: com.kwad.sdk.utils.ax.b.3
                final /* synthetic */ List aAx;
                final /* synthetic */ SensorManager aAy;
                final /* synthetic */ CountDownLatch asB;

                AnonymousClass3(List arrayList2, CountDownLatch countDownLatch2, SensorManager sensorManager2) {
                    arrayList = arrayList2;
                    countDownLatch = countDownLatch2;
                    sensorManager = sensorManager2;
                }

                @Override // android.hardware.SensorEventListener
                public final void onSensorChanged(SensorEvent sensorEvent) {
                    com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                    arrayList.add(com.kwad.sdk.h.kwai.e.a(sensorEvent, System.currentTimeMillis()));
                    countDownLatch.countDown();
                    sensorManager.unregisterListener(this);
                }
            })) {
                countDownLatch2.countDown();
            }
            try {
                countDownLatch2.await(2L, TimeUnit.SECONDS);
            } catch (InterruptedException unused) {
            }
            return arrayList2;
        }

        @Nullable
        @WorkerThread
        private List<com.kwad.sdk.h.kwai.e> cK(Context context) {
            if (context == null) {
                return null;
            }
            return this.aAw ? cI(context) : Eq();
        }

        @Nullable
        public final List<com.kwad.sdk.h.kwai.e> cJ(Context context) {
            if (this.azm) {
                return null;
            }
            try {
                return cK(context);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                return null;
            }
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent == null) {
                return;
            }
            int type = sensorEvent.sensor.getType();
            if (type == 1) {
                this.aAt = new d(sensorEvent);
            } else if (type == 4) {
                this.aAu = new d(sensorEvent);
            } else {
                if (type != 9) {
                    return;
                }
                this.aAv = new d(sensorEvent);
            }
        }
    }

    static abstract class c implements SensorEventListener {
        c() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }
    }

    static class d {
        private SensorEvent aAA;
        private long timestamp = System.currentTimeMillis();

        public d(SensorEvent sensorEvent) {
            this.aAA = sensorEvent;
        }

        public final SensorEvent Er() {
            return this.aAA;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }
    }

    static class e extends j<com.kwad.sdk.h.kwai.f> {
        public e(boolean z) {
            super(z);
        }

        @Nullable
        private static com.kwad.sdk.h.kwai.f cL(Context context) {
            com.kwad.sdk.h.kwai.f fVar = new com.kwad.sdk.h.kwai.f();
            fVar.axK = au.cu(context);
            fVar.axJ = au.cs(context);
            return fVar;
        }

        @Override // com.kwad.sdk.utils.j
        @Nullable
        protected final /* synthetic */ com.kwad.sdk.h.kwai.f bG(Context context) {
            return cL(context);
        }
    }

    @Nullable
    public static com.kwad.sdk.h.kwai.b Ci() {
        if (Ep()) {
            return (com.kwad.sdk.h.kwai.b) eM("baseStationEnable");
        }
        return null;
    }

    @Nullable
    public static com.kwad.sdk.h.kwai.f Cj() {
        if (Ep()) {
            return (com.kwad.sdk.h.kwai.f) eM("simCardInfoEnable");
        }
        return null;
    }

    @Nullable
    @WorkerThread
    public static List<com.kwad.sdk.h.kwai.e> Ek() {
        if (!o.CW()) {
            return null;
        }
        Context applicationContext = ServiceProvider.getContext().getApplicationContext();
        if (aAr == null) {
            aAr = new b(applicationContext);
        }
        return aAr.cJ(applicationContext);
    }

    private static boolean Ep() {
        return aAp != null;
    }

    @Nullable
    private static <T> j<T> eL(String str) {
        try {
            return aAq.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    private static <T> T eM(String str) {
        j eL = eL(str);
        if (eL != null) {
            return (T) eL.bF(aAp);
        }
        return null;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        com.kwad.sdk.service.kwai.f fVar = (com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class);
        if (fVar == null) {
            com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "init sdkConfigProvider is null");
            return;
        }
        if (!Ep()) {
            aAp = context.getApplicationContext();
            aAq.put("baseStationEnable", new a(fVar.sz()));
            aAq.put("simCardInfoEnable", new e(fVar.sx()));
            return;
        }
        if (aAq.containsKey("baseStationEnable")) {
            boolean sz = fVar.sz();
            j eL = eL("baseStationEnable");
            if (eL != null) {
                eL.aP(sz);
            }
        }
        if (aAq.containsKey("simCardInfoEnable")) {
            boolean sx = fVar.sx();
            j eL2 = eL("simCardInfoEnable");
            if (eL2 != null) {
                eL2.aP(sx);
            }
        }
    }
}
