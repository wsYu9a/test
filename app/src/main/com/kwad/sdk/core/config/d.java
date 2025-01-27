package com.kwad.sdk.core.config;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.config.item.e;
import com.kwad.sdk.core.config.item.f;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.config.item.o;
import com.kwad.sdk.core.config.item.r;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.h;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class d {
    private static volatile SdkConfigData axf;
    private static final AtomicBoolean axe = new AtomicBoolean(false);
    private static final Object mLock = new Object();

    /* renamed from: com.kwad.sdk.core.config.d$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ Context hB;

        public AnonymousClass1(Context context) {
            MA = context;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            d.bj(MA);
        }
    }

    public static double Aa() {
        return c.avI.getValue().floatValue();
    }

    public static boolean Ab() {
        return c.awr.getValue().booleanValue();
    }

    public static boolean Af() {
        return c.awF.getValue().booleanValue();
    }

    @Deprecated
    public static int Ag() {
        return c.auw.getValue().intValue();
    }

    public static boolean Ah() {
        return c.awJ.Eq();
    }

    public static boolean An() {
        return c.axc.getValue().booleanValue();
    }

    public static int Ao() {
        return c.axd.getValue().intValue();
    }

    public static boolean Au() {
        return c.awU.Eq();
    }

    public static boolean CS() {
        return c.aum.getValue().intValue() == 1;
    }

    public static int CT() {
        return c.aun.getValue().intValue();
    }

    public static int CU() {
        return c.auo.getValue().intValue();
    }

    public static boolean CV() {
        return c.auq.getValue().intValue() > 0;
    }

    public static boolean CW() {
        return c.auo.getValue().intValue() == 2;
    }

    public static int CX() {
        return c.aup.getValue().intValue();
    }

    public static boolean CY() {
        return c.aur.getValue().intValue() > 0;
    }

    public static boolean CZ() {
        return c.aus.getValue().intValue() == 1;
    }

    @NonNull
    public static SdkConfigData DA() {
        if (axf != null) {
            return axf;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.kwad.sdk.core.d.c.d("SdkConfigManager", "getSdkConfigData is ui thread");
            axf = DB();
        } else {
            synchronized (mLock) {
                try {
                    if (axf == null) {
                        return DB();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return axf;
    }

    private static SdkConfigData DB() {
        axf = new SdkConfigData();
        String cy = ad.cy(ServiceProvider.MA());
        if (TextUtils.isEmpty(cy)) {
            com.kwad.sdk.core.d.c.d("SdkConfigManager", "configCache is empty");
        } else {
            try {
                axf.parseJson(new JSONObject(cy));
            } catch (Exception e10) {
                com.kwad.sdk.core.d.c.printStackTrace(e10);
            }
        }
        return axf;
    }

    public static boolean DC() {
        return c.aut.getValue().intValue() == 1;
    }

    public static boolean DD() {
        return c.auu.getValue().intValue() == 1;
    }

    public static boolean DE() {
        return c.aux.getValue().booleanValue();
    }

    public static boolean DF() {
        return c.avW.getValue().intValue() == 1;
    }

    public static int DG() {
        return c.auv.getValue().intValue();
    }

    public static int DH() {
        return c.avD.getValue().intValue();
    }

    public static int DI() {
        return c.avC.getValue().intValue();
    }

    public static boolean DJ() {
        return c.avE.getValue().intValue() == 1;
    }

    public static boolean DK() {
        return c.avF.getValue().booleanValue();
    }

    public static float DL() {
        float floatValue = c.avG.getValue().floatValue();
        if (floatValue <= 0.0f || floatValue > 1.0f) {
            return 0.3f;
        }
        return floatValue;
    }

    public static float DM() {
        return c.avH.getValue().floatValue();
    }

    public static boolean DN() {
        return c.avJ.getValue().booleanValue();
    }

    public static boolean DO() {
        return c.avN.getValue().booleanValue();
    }

    public static boolean DP() {
        return c.avO.getValue().intValue() > 0;
    }

    public static boolean DQ() {
        return c.avV.getValue().intValue() == 1;
    }

    public static long DR() {
        return c.avT.getValue().longValue();
    }

    public static boolean DS() {
        return c.avZ.Eq();
    }

    public static com.kwad.sdk.core.network.idc.a.b DT() {
        return c.awb.getValue();
    }

    public static int DU() {
        return c.awc.getValue().intValue();
    }

    public static long DV() {
        return c.awd.getValue().longValue();
    }

    public static int DW() {
        return c.awe.getValue().intValue();
    }

    public static boolean DX() {
        return c.awf.getValue().floatValue() == 1.0f;
    }

    public static boolean DY() {
        return c.awg.Eq();
    }

    public static boolean DZ() {
        return c.awj.Eq();
    }

    public static int Da() {
        return c.aur.getValue().intValue();
    }

    @ForInvoker(methodId = "initConfigList")
    private static void Db() {
        com.kwad.components.ad.e.a.init();
        com.kwad.components.ad.feed.a.a.init();
        com.kwad.components.ad.fullscreen.a.a.init();
        com.kwad.components.ad.interstitial.b.a.init();
        com.kwad.components.ad.reward.a.a.init();
        com.kwad.components.ad.splashscreen.b.a.init();
    }

    public static List<String> Dc() {
        return c.auJ.getValue();
    }

    @NonNull
    public static List<String> Dd() {
        return c.auI.getValue();
    }

    public static int De() {
        return c.awh.getValue().intValue();
    }

    public static int Df() {
        return c.awi.getValue().intValue();
    }

    public static String Dg() {
        return c.auD.getValue();
    }

    public static String Dh() {
        return c.auE.getValue();
    }

    public static boolean Di() {
        return c.aui.getValue().intValue() == 1;
    }

    public static int Dj() {
        return c.auj.getValue().intValue();
    }

    public static boolean Dk() {
        return c.auk.getValue().intValue() == 1;
    }

    public static int Dl() {
        return c.aul.getValue().intValue();
    }

    public static int Dm() {
        return c.auR.getValue().intValue();
    }

    public static int Dn() {
        return c.auS.getValue().intValue();
    }

    public static int Do() {
        return c.auT.getValue().intValue();
    }

    public static long Dp() {
        return c.auU.getValue().intValue() * 60000;
    }

    public static boolean Dq() {
        return c.avd.getValue().intValue() == 1;
    }

    public static boolean Dr() {
        return c.ave.getValue().intValue() == 1;
    }

    public static int Ds() {
        return c.avl.getValue().intValue();
    }

    public static boolean Dt() {
        return c.avm.getValue().booleanValue();
    }

    public static boolean Du() {
        return com.kwad.sdk.core.g.a.HI();
    }

    public static boolean Dv() {
        return a(c.avs);
    }

    public static boolean Dw() {
        return !c.avt.getValue().booleanValue();
    }

    public static boolean Dx() {
        return a(c.avr);
    }

    public static boolean Dy() {
        return c.avv.getValue().intValue() == 1;
    }

    public static int Dz() {
        return c.avw.getValue().intValue();
    }

    public static String Ea() {
        return c.awk.getValue();
    }

    public static String Eb() {
        return c.awl.getValue();
    }

    public static String Ec() {
        return c.awm.getValue();
    }

    public static int Ed() {
        return c.awp.getValue().intValue();
    }

    public static boolean Ee() {
        return c.awt.getValue().booleanValue();
    }

    public static int Ef() {
        return c.awu.getValue().intValue();
    }

    public static boolean Eg() {
        return c.awR.Eq();
    }

    public static boolean Eh() {
        return c.awT.Eq();
    }

    public static boolean Ei() {
        return c.awY.getValue().booleanValue();
    }

    public static int Ej() {
        return c.axa.getValue().intValue();
    }

    public static int Ek() {
        return c.awZ.getValue().intValue();
    }

    public static JSONObject a(e eVar) {
        JSONObject jSONObject = (JSONObject) b(eVar);
        return jSONObject != null ? jSONObject : eVar.El();
    }

    public static boolean ac(long j10) {
        return (j10 & c.auy.getValue().longValue()) != 0;
    }

    public static <T> T b(@NonNull com.kwad.sdk.core.config.item.b<T> bVar) {
        if (!isLoaded()) {
            Context MA = ServiceProvider.MA();
            b.a(MA, bVar);
            h.execute(new bd() { // from class: com.kwad.sdk.core.config.d.1
                final /* synthetic */ Context hB;

                public AnonymousClass1(Context MA2) {
                    MA = MA2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    d.bj(MA);
                }
            });
        }
        T value = bVar.getValue();
        return value != null ? value : bVar.El();
    }

    @WorkerThread
    public static synchronized void bj(Context context) {
        synchronized (d.class) {
            AtomicBoolean atomicBoolean = axe;
            if (atomicBoolean.get()) {
                return;
            }
            com.kwad.sdk.core.d.c.d("SdkConfigManager", "loadCache");
            c.init();
            Db();
            b.bi(context);
            DA();
            atomicBoolean.set(true);
        }
    }

    public static int cc(String str) {
        return c.awX.dx(str);
    }

    public static int cd(String str) {
        Integer value = c.auO.getValue(str);
        if (value != null) {
            return value.intValue();
        }
        return 0;
    }

    public static void f(@NonNull SdkConfigData sdkConfigData) {
        synchronized (mLock) {
            axf = sdkConfigData;
        }
    }

    public static boolean gN() {
        return c.avM.getValue().booleanValue();
    }

    public static String getLogObiwanData() {
        return c.avS.getValue();
    }

    public static int getTKErrorDetailCount() {
        return c.awS.getValue().intValue();
    }

    @NonNull
    public static List<String> getTKPreloadMemCacheTemplates() {
        return c.awO.getValue();
    }

    public static String getUserAgent() {
        return c.avA.getValue();
    }

    public static boolean isLoaded() {
        return axe.get();
    }

    public static boolean xR() {
        return c.awn.getValue().booleanValue();
    }

    public static boolean zA() {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return c.auh.getValue().intValue() == 1;
    }

    public static boolean zM() {
        return c.ava.getValue().intValue() == 1;
    }

    public static boolean zO() {
        return c.avb.getValue().intValue() == 1;
    }

    public static boolean zP() {
        return c.auZ.getValue().intValue() == 1;
    }

    public static String zQ() {
        return c.avn.getImei();
    }

    public static String zR() {
        return c.avn.getOaid();
    }

    public static List<String> zS() {
        return c.auH.getValue();
    }

    public static boolean zT() {
        return c.avz.getValue().intValue() == 1;
    }

    public static boolean zU() {
        return c.avB.getValue().intValue() == 1;
    }

    public static boolean zW() {
        return c.avX.getValue().booleanValue();
    }

    public static boolean zX() {
        return c.avY.getValue().booleanValue();
    }

    public static int zY() {
        if (axf != null) {
            return axf.goodIdcThresholdMs;
        }
        return 200;
    }

    public static int zZ() {
        return c.awa.getValue().intValue();
    }

    public static int zy() {
        return c.auc.getValue().intValue();
    }

    public static boolean zz() {
        return false;
    }

    public static int a(k kVar) {
        Integer num = (Integer) b((com.kwad.sdk.core.config.item.b) kVar);
        if (num == null) {
            num = kVar.El();
        }
        return num.intValue();
    }

    public static long a(o oVar) {
        Long l10 = (Long) b(oVar);
        if (l10 == null) {
            l10 = oVar.El();
        }
        return l10.longValue();
    }

    public static boolean b(k kVar) {
        Integer num = (Integer) b((com.kwad.sdk.core.config.item.b) kVar);
        return num != null ? num.intValue() > 0 : kVar.El().intValue() > 0;
    }

    public static double a(f fVar) {
        Double d10 = (Double) b(fVar);
        if (d10 == null) {
            d10 = fVar.El();
        }
        return d10.doubleValue();
    }

    public static boolean a(com.kwad.sdk.core.config.item.d dVar) {
        Boolean bool = (Boolean) b(dVar);
        if (bool == null) {
            bool = dVar.El();
        }
        return bool.booleanValue();
    }

    public static String a(r rVar) {
        String str = (String) b(rVar);
        return str != null ? str : rVar.El();
    }
}
