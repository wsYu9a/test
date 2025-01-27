package com.kwad.components.core.request.model;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.k.a.d;
import com.kwad.sdk.k.a.e;
import com.kwad.sdk.k.a.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.ca;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.x;
import com.umeng.analytics.pro.bt;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b implements com.kwad.sdk.core.b {
    private boolean UA;
    private List<a> UC;
    private f UD;
    private d UE;
    private com.kwad.sdk.k.a.b UF;
    private List<e> UG;
    private int Uj;
    private String Uk;
    private int Ul;
    private Long Um;
    private Long Un;
    private Long Uo;
    private Long Up;
    private String Uq;
    private String Ur;
    private long Ut;
    private String Uu;
    private String Uv;
    private long Uw;
    private String Uy;
    private String Uz;
    private List<ca.a> Us = new CopyOnWriteArrayList();
    private int Ux = -1;
    private float screenBrightness = -1.0f;
    private int UB = -1;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int UH = -1;
        public int UI = -1;
        public int UJ = -1;
        public int streamType;

        private a(int i10) {
            this.streamType = i10;
        }

        private static int aH(int i10) {
            if (i10 == 0) {
                return 0;
            }
            if (i10 == 1) {
                return 1;
            }
            if (i10 == 2) {
                return 2;
            }
            if (i10 == 3) {
                return 3;
            }
            if (i10 != 4) {
                return i10 != 5 ? 0 : 5;
            }
            return 4;
        }

        public static List<a> au(Context context) {
            AudioManager audioManager;
            int streamMinVolume;
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                return arrayList;
            }
            if (com.kwad.sdk.core.config.d.ac(256L)) {
                return arrayList;
            }
            try {
                audioManager = (AudioManager) context.getSystemService("audio");
            } catch (Exception unused) {
            }
            if (audioManager == null) {
                return arrayList;
            }
            for (int i10 = 0; i10 <= 5; i10++) {
                a aVar = new a(i10);
                int aH = aH(i10);
                aVar.UJ = audioManager.getStreamVolume(aH);
                aVar.UH = audioManager.getStreamMaxVolume(aH);
                if (Build.VERSION.SDK_INT >= 28) {
                    streamMinVolume = audioManager.getStreamMinVolume(aH);
                    aVar.UI = streamMinVolume;
                }
                arrayList.add(aVar);
            }
            return arrayList;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0041 A[Catch: Exception -> 0x0044, TryCatch #0 {Exception -> 0x0044, blocks: (B:7:0x001e, B:9:0x0024, B:15:0x0037, B:17:0x0041, B:20:0x0048, B:24:0x004e, B:27:0x0054), top: B:6:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void at(@androidx.annotation.NonNull android.content.Context r7) {
        /*
            r6 = this;
            r0 = 512(0x200, double:2.53E-321)
            boolean r0 = com.kwad.sdk.core.config.d.ac(r0)
            if (r0 == 0) goto L9
            return
        L9:
            android.content.IntentFilter r0 = new android.content.IntentFilter
            r0.<init>()
            java.lang.String r1 = "android.intent.action.ACTION_POWER_CONNECTED"
            r0.addAction(r1)
            java.lang.String r1 = "android.intent.action.ACTION_POWER_DISCONNECTED"
            r0.addAction(r1)
            java.lang.String r1 = "android.intent.action.BATTERY_CHANGED"
            r0.addAction(r1)
            r1 = 0
            android.content.Intent r7 = r7.registerReceiver(r1, r0)     // Catch: java.lang.Exception -> L44
            if (r7 == 0) goto L56
            java.lang.String r0 = "status"
            r1 = -1
            int r0 = r7.getIntExtra(r0, r1)     // Catch: java.lang.Exception -> L44
            r2 = 0
            r3 = 1
            r4 = 2
            if (r0 == r4) goto L36
            r5 = 5
            if (r0 != r5) goto L34
            goto L36
        L34:
            r0 = 0
            goto L37
        L36:
            r0 = 1
        L37:
            r6.UA = r0     // Catch: java.lang.Exception -> L44
            java.lang.String r0 = "plugged"
            int r7 = r7.getIntExtra(r0, r1)     // Catch: java.lang.Exception -> L44
            if (r7 != r4) goto L46
            r6.UB = r3     // Catch: java.lang.Exception -> L44
            goto L5a
        L44:
            r7 = move-exception
            goto L57
        L46:
            if (r7 != r3) goto L4b
            r6.UB = r4     // Catch: java.lang.Exception -> L44
            goto L5a
        L4b:
            r0 = 4
            if (r7 != r0) goto L52
            r7 = 3
            r6.UB = r7     // Catch: java.lang.Exception -> L44
            goto L5a
        L52:
            if (r7 != 0) goto L56
            r6.UB = r2     // Catch: java.lang.Exception -> L44
        L56:
            return
        L57:
            com.kwad.sdk.core.d.c.printStackTrace(r7)
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.request.model.b.at(android.content.Context):void");
    }

    private static Context getContext() {
        return ServiceProvider.MA();
    }

    @WorkerThread
    public static b rB() {
        b bVar = new b();
        bVar.Uj = bo.OU();
        bVar.Uk = AbiUtil.bU(getContext());
        bVar.Ul = bo.dq(getContext());
        bVar.Um = Long.valueOf(bo.dr(getContext()));
        bVar.Un = Long.valueOf(bo.dp(getContext()));
        bVar.Uo = Long.valueOf(bo.OR());
        bVar.Up = Long.valueOf(bo.OS());
        bVar.Uq = ba.cS(getContext());
        bVar.Ur = ba.cT(getContext());
        bVar.Us.addAll(ba.o(getContext(), 15));
        bVar.Ut = bo.OZ();
        bVar.Uw = bo.Pa();
        bVar.Uz = bo.Pb();
        bVar.Uy = bo.Pc();
        bVar.Uu = bo.Pd();
        bVar.Uv = bo.Pe();
        Context context = getContext();
        if (context != null) {
            bVar.Ux = bo.dy(context);
            bVar.UC = new CopyOnWriteArrayList(a.au(context));
            bVar.at(context);
        }
        bVar.UE = p.MT();
        bVar.UF = ba.Mk();
        bVar.UG = bg.Oy().Oz();
        bVar.UD = ba.Ml();
        return bVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        x.putValue(jSONObject, "cpuCount", this.Uj);
        x.putValue(jSONObject, "cpuAbi", this.Uk);
        x.putValue(jSONObject, "batteryPercent", this.Ul);
        x.putValue(jSONObject, "totalMemorySize", this.Um.longValue());
        x.putValue(jSONObject, "availableMemorySize", this.Un.longValue());
        x.putValue(jSONObject, "totalDiskSize", this.Uo.longValue());
        x.putValue(jSONObject, "availableDiskSize", this.Up.longValue());
        x.putValue(jSONObject, "imsi", this.Uq);
        x.putValue(jSONObject, bt.f23584aa, this.Ur);
        x.putValue(jSONObject, "wifiList", this.Us);
        x.putValue(jSONObject, "bootTime", this.Ut);
        x.putValue(jSONObject, "romName", this.Uu);
        x.putValue(jSONObject, "romVersion", this.Uv);
        x.putValue(jSONObject, "romBuildTimestamp", this.Uw);
        x.putValue(jSONObject, "ringerMode", this.Ux);
        x.putValue(jSONObject, "audioStreamInfo", this.UC);
        x.putValue(jSONObject, "baseBandVersion", this.Uy);
        x.putValue(jSONObject, "fingerPrint", this.Uz);
        x.putValue(jSONObject, "screenBrightness", this.screenBrightness);
        x.putValue(jSONObject, "isCharging", this.UA);
        x.putValue(jSONObject, "chargeType", this.UB);
        f fVar = this.UD;
        if (fVar != null) {
            x.a(jSONObject, "simCardInfo", fVar);
        }
        d dVar = this.UE;
        if (dVar != null) {
            x.a(jSONObject, "environmentInfo", dVar);
        }
        com.kwad.sdk.k.a.b bVar = this.UF;
        if (bVar != null) {
            x.a(jSONObject, "baseStationInfo", bVar);
        }
        List<e> list = this.UG;
        if (list != null) {
            x.putValue(jSONObject, "sensorEventInfoList", list);
        }
        return jSONObject;
    }
}
