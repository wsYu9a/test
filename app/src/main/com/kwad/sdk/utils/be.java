package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public final class be {
    private static Context aUr;
    private static Map<String, k> aUs = new HashMap();

    public static class a extends k<com.kwad.sdk.k.a.b> {
        private static com.kwad.sdk.k.a.b aUt;

        public a(boolean z10) {
            super(z10);
        }

        @RequiresApi(api = 17)
        @SuppressLint({"BlockedPrivateApi"})
        private static int a(CellInfo cellInfo) {
            if (cellInfo == null) {
                return -1;
            }
            try {
                return ((CellSignalStrength) w.callMethod(cellInfo, "getCellSignalStrength", new Object[0])).getLevel();
            } catch (Throwable unused) {
                return -1;
            }
        }

        @Override // com.kwad.sdk.utils.k
        /* renamed from: dj */
        public com.kwad.sdk.k.a.b cg(Context context) {
            int i10;
            int i11;
            if (az.Ob() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ac(64L)) {
                return aUt;
            }
            com.kwad.sdk.k.a.b bVar = aUt;
            if (bVar != null) {
                return bVar;
            }
            CellInfo cellInfo = null;
            if (context == null || az.Ob()) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f11106g) == -1) {
                return null;
            }
            if (bo.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f11106g) == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                CellLocation cellLocation = telephonyManager.getCellLocation();
                if (cellLocation instanceof CdmaCellLocation) {
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                    i11 = cdmaCellLocation.getBaseStationId();
                    i10 = cdmaCellLocation.getNetworkId();
                } else if (cellLocation instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    i11 = gsmCellLocation.getCid();
                    i10 = gsmCellLocation.getLac();
                } else {
                    i10 = -1;
                    i11 = -1;
                }
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
                aUt = new com.kwad.sdk.k.a.b(i11, i10, cellInfo != null ? a(cellInfo) : -1);
            }
            return aUt;
        }
    }

    public static class b extends k<com.kwad.sdk.k.a.f> {
        public b(boolean z10) {
            super(z10);
        }

        @Nullable
        private static com.kwad.sdk.k.a.f dk(Context context) {
            com.kwad.sdk.k.a.f fVar = new com.kwad.sdk.k.a.f();
            fVar.aRx = ba.cW(context);
            fVar.aRw = ba.cU(context);
            return fVar;
        }

        @Override // com.kwad.sdk.utils.k
        @Nullable
        public final /* synthetic */ com.kwad.sdk.k.a.f cg(Context context) {
            return dk(context);
        }
    }

    @Nullable
    public static com.kwad.sdk.k.a.b Mk() {
        if (Ow()) {
            return (com.kwad.sdk.k.a.b) gZ("baseStationEnable");
        }
        return null;
    }

    @Nullable
    public static com.kwad.sdk.k.a.f Ml() {
        if (Ow()) {
            return (com.kwad.sdk.k.a.f) gZ("simCardInfoEnable");
        }
        return null;
    }

    private static boolean Ow() {
        return aUr != null;
    }

    @Nullable
    private static <T> k<T> gY(String str) {
        try {
            return aUs.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    private static <T> T gZ(String str) {
        k gY = gY(str);
        if (gY != null) {
            return (T) gY.cf(aUr);
        }
        return null;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            com.kwad.sdk.core.d.c.d("SensitiveInfoCollectors", "init sdkConfigProvider is null");
            return;
        }
        if (!Ow()) {
            aUr = context.getApplicationContext();
            aUs.put("baseStationEnable", new a(hVar.zO()));
            aUs.put("simCardInfoEnable", new b(hVar.zM()));
            return;
        }
        if (aUs.containsKey("baseStationEnable")) {
            boolean zO = hVar.zO();
            k gY = gY("baseStationEnable");
            if (gY != null) {
                gY.bT(zO);
            }
        }
        if (aUs.containsKey("simCardInfoEnable")) {
            boolean zM = hVar.zM();
            k gY2 = gY("simCardInfoEnable");
            if (gY2 != null) {
                gY2.bT(zM);
            }
        }
    }
}
