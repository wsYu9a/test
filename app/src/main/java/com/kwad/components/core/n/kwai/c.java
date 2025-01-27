package com.kwad.components.core.n.kwai;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.h.kwai.e;
import com.kwad.sdk.h.kwai.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.n;
import com.kwad.sdk.utils.t;
import com.umeng.analytics.pro.am;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c implements com.kwad.sdk.core.b {
    private String OA;
    private int OB;
    private Long OC;
    private Long OD;
    private Long OE;
    private Long OF;
    private String OG;
    private String OH;
    private long OJ;
    private String OK;
    private String OL;
    private long OM;
    private String OO;
    private String OP;
    private boolean OQ;
    private List<a> OS;
    private f OT;
    private com.kwad.sdk.h.kwai.d OU;
    private com.kwad.sdk.h.kwai.b OV;
    private List<e> OW;
    private int Oz;
    private List<bp.a> OI = new ArrayList();
    private int ON = -1;
    private float screenBrightness = -1.0f;
    private int OR = -1;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public int OX = -1;
        public int OY = -1;
        public int OZ = -1;
        public int streamType;

        private a(int i2) {
            this.streamType = i2;
        }

        private static int aE(int i2) {
            if (i2 != 0) {
                if (i2 == 1) {
                    return 1;
                }
                if (i2 == 2) {
                    return 2;
                }
                if (i2 == 3) {
                    return 3;
                }
                if (i2 == 4) {
                    return 4;
                }
                if (i2 == 5) {
                    return 5;
                }
            }
            return 0;
        }

        public static List<a> ai(Context context) {
            AudioManager audioManager;
            ArrayList arrayList = new ArrayList();
            if (context == null || com.kwad.sdk.core.config.d.E(256L)) {
                return arrayList;
            }
            try {
                audioManager = (AudioManager) context.getSystemService("audio");
            } catch (Exception unused) {
            }
            if (audioManager == null) {
                return arrayList;
            }
            for (int i2 = 0; i2 <= 5; i2++) {
                a aVar = new a(i2);
                int aE = aE(i2);
                aVar.OZ = audioManager.getStreamVolume(aE);
                aVar.OX = audioManager.getStreamMaxVolume(aE);
                if (Build.VERSION.SDK_INT >= 28) {
                    aVar.OY = audioManager.getStreamMinVolume(aE);
                }
                arrayList.add(aVar);
            }
            return arrayList;
        }
    }

    private void ah(@NonNull Context context) {
        if (com.kwad.sdk.core.config.d.E(512L)) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        Intent registerReceiver = context.registerReceiver(null, intentFilter);
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.OQ = intExtra == 2 || intExtra == 5;
            int intExtra2 = registerReceiver.getIntExtra("plugged", -1);
            if (intExtra2 == 2) {
                this.OR = 1;
                return;
            }
            if (intExtra2 == 1) {
                this.OR = 2;
            } else if (intExtra2 == 4) {
                this.OR = 3;
            } else if (intExtra2 == 0) {
                this.OR = 0;
            }
        }
    }

    private static Context getContext() {
        return ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
    }

    @WorkerThread
    public static c pl() {
        c cVar = new c();
        cVar.Oz = bd.EE();
        cVar.OA = AbiUtil.bu(getContext());
        cVar.OB = bd.cQ(getContext());
        cVar.OC = Long.valueOf(bd.cR(getContext()));
        cVar.OD = Long.valueOf(bd.cP(getContext()));
        cVar.OE = Long.valueOf(bd.EC());
        cVar.OF = Long.valueOf(bd.ED());
        cVar.OG = au.cq(getContext());
        cVar.OH = au.cr(getContext());
        cVar.OI = au.m(getContext(), 15);
        cVar.OJ = bd.EI();
        cVar.OM = bd.EJ();
        cVar.OP = bd.EK();
        cVar.OO = bd.EL();
        cVar.OK = bd.EM();
        cVar.OL = bd.EN();
        Context context = getContext();
        if (context != null) {
            cVar.ON = bd.cY(context);
            cVar.OS = a.ai(context);
            cVar.ah(context);
        }
        cVar.OU = n.CS();
        cVar.OV = au.Ci();
        cVar.OW = au.Ek();
        cVar.OT = au.Cj();
        return cVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "cpuCount", this.Oz);
        t.putValue(jSONObject, "cpuAbi", this.OA);
        t.putValue(jSONObject, "batteryPercent", this.OB);
        t.putValue(jSONObject, "totalMemorySize", this.OC.longValue());
        t.putValue(jSONObject, "availableMemorySize", this.OD.longValue());
        t.putValue(jSONObject, "totalDiskSize", this.OE.longValue());
        t.putValue(jSONObject, "availableDiskSize", this.OF.longValue());
        t.putValue(jSONObject, "imsi", this.OG);
        t.putValue(jSONObject, am.aa, this.OH);
        t.putValue(jSONObject, "wifiList", this.OI);
        t.putValue(jSONObject, "bootTime", this.OJ);
        t.putValue(jSONObject, "romName", this.OK);
        t.putValue(jSONObject, "romVersion", this.OL);
        t.putValue(jSONObject, "romBuildTimestamp", this.OM);
        t.putValue(jSONObject, "ringerMode", this.ON);
        t.putValue(jSONObject, "audioStreamInfo", this.OS);
        t.putValue(jSONObject, "baseBandVersion", this.OO);
        t.putValue(jSONObject, "fingerPrint", this.OP);
        t.putValue(jSONObject, "screenBrightness", this.screenBrightness);
        t.putValue(jSONObject, "isCharging", this.OQ);
        t.putValue(jSONObject, "chargeType", this.OR);
        f fVar = this.OT;
        if (fVar != null) {
            t.a(jSONObject, "simCardInfo", fVar);
        }
        com.kwad.sdk.h.kwai.d dVar = this.OU;
        if (dVar != null) {
            t.a(jSONObject, "environmentInfo", dVar);
        }
        com.kwad.sdk.h.kwai.b bVar = this.OV;
        if (bVar != null) {
            t.a(jSONObject, "baseStationInfo", bVar);
        }
        List<e> list = this.OW;
        if (list != null) {
            t.putValue(jSONObject, "sensorEventInfoList", list);
        }
        return jSONObject;
    }
}
