package b8;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.comm.request.MTJsonPostParams;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libugrowth.data.AdEvent;
import com.martian.libugrowth.data.AdsEvent;
import com.martian.libugrowth.request.AdsEventRequest;
import com.sntech.ads.SNAdSdk;
import com.sntech.ads.api.event.SNEvent;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import l9.p0;
import ya.e0;

/* loaded from: classes3.dex */
public class e {

    /* renamed from: h */
    public static final String f1419h = "PREF_ENABLE_SN_SDK";

    /* renamed from: i */
    public static e f1420i = null;

    /* renamed from: j */
    public static final String f1421j = "adActions.json";

    /* renamed from: a */
    public Handler f1422a;

    /* renamed from: b */
    public HandlerThread f1423b;

    /* renamed from: c */
    public Boolean f1424c;

    /* renamed from: d */
    public boolean f1425d = true;

    /* renamed from: e */
    public WeakReference<Context> f1426e;

    /* renamed from: f */
    public List<AdsEvent> f1427f;

    /* renamed from: g */
    public boolean f1428g;

    public class a extends TypeToken<List<AdsEvent>> {
        public a() {
        }
    }

    public class b extends f9.c<Integer> {

        /* renamed from: g */
        public final /* synthetic */ List f1430g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Class cls, Context context, List list) {
            super(cls, context);
            this.f1430g = list;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            e.this.f1427f.addAll(this.f1430g);
            e.this.F();
        }

        @Override // y8.h, y8.b
        public void onUDDataReceived(List<Integer> list) {
            e.this.F();
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            e.this.f1428g = z10;
        }
    }

    public static void A(AdConfig adConfig, String str) {
        B(adConfig, str, null);
    }

    public static void B(AdConfig adConfig, String str, x8.c cVar) {
        if (ConfigSingleton.D().B0()) {
            if (adConfig == null) {
                p0.c(e0.f33149f0, str);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(adConfig.getSource());
            sb2.append(hf.e.f26694a);
            sb2.append(adConfig.getPid());
            sb2.append(hf.e.f26694a);
            sb2.append(adConfig.getAdsId());
            String str2 = "";
            sb2.append(adConfig.isBidding() ? "_bidding" : "");
            sb2.append(hf.e.f26694a);
            sb2.append(adConfig.getEcpm());
            sb2.append(hf.e.f26694a);
            sb2.append(str);
            if (cVar != null) {
                str2 = hf.e.f26694a + cVar.c() + hf.e.f26694a + cVar.d();
            }
            sb2.append(str2);
            p0.c(e0.f33149f0, sb2.toString());
        }
    }

    private Context getContext() {
        WeakReference<Context> weakReference = this.f1426e;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static e s() {
        if (f1420i == null) {
            f1420i = new e();
        }
        return f1420i;
    }

    public void C() {
        HandlerThread handlerThread = this.f1423b;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.f1423b = null;
            this.f1422a = null;
        }
    }

    /* renamed from: D */
    public void v(String str, String str2, String str3, int i10) {
        if (q()) {
            SNEvent.AdPlatform t10 = t(str3);
            if (ba.l.q(str) || SNEvent.AdPlatform.UNKNOWN.equals(t10)) {
                return;
            }
            if (AdConfig.Type.CLICK.equalsIgnoreCase(str2)) {
                SNAdSdk.getEventManager().onAdClick(t10, str);
            } else {
                SNAdSdk.getEventManager().onAdShow(t10, str, i10 / 100.0d);
            }
        }
    }

    public void E(String str, String str2, String str3, int i10) {
        Handler handler = this.f1422a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: b8.b

                /* renamed from: c */
                public final /* synthetic */ String f1404c;

                /* renamed from: d */
                public final /* synthetic */ String f1405d;

                /* renamed from: e */
                public final /* synthetic */ String f1406e;

                /* renamed from: f */
                public final /* synthetic */ int f1407f;

                public /* synthetic */ b(String str4, String str22, String str32, int i102) {
                    str = str4;
                    str2 = str22;
                    str3 = str32;
                    i10 = i102;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    e.this.v(str, str2, str3, i10);
                }
            });
        }
    }

    public final void F() {
        try {
            Context context = getContext();
            if (context != null) {
                ba.g.F(context, f1421j, GsonUtils.b().toJson(this.f1427f));
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public void G(boolean z10) {
        ba.j.p(getContext(), f1419h, z10);
    }

    public void H(String str, String str2, int i10, int i11) {
        if (this.f1422a == null) {
            return;
        }
        if (Thread.currentThread() == this.f1422a.getLooper().getThread()) {
            w(str, str2, i10, i11);
        } else {
            this.f1422a.post(new Runnable() { // from class: b8.a

                /* renamed from: c */
                public final /* synthetic */ String f1399c;

                /* renamed from: d */
                public final /* synthetic */ String f1400d;

                /* renamed from: e */
                public final /* synthetic */ int f1401e;

                /* renamed from: f */
                public final /* synthetic */ int f1402f;

                public /* synthetic */ a(String str3, String str22, int i102, int i112) {
                    str = str3;
                    str2 = str22;
                    i10 = i102;
                    i11 = i112;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    e.this.w(str, str2, i10, i11);
                }
            });
        }
    }

    public void I(String str, String str2, String str3, @NonNull String str4, String str5, int i10, int i11, x8.c cVar) {
        if (this.f1422a == null) {
            return;
        }
        if (Thread.currentThread() == this.f1422a.getLooper().getThread()) {
            x(str, str2, str3, str4, str5, i10, i11, cVar);
        } else {
            this.f1422a.post(new Runnable() { // from class: b8.c

                /* renamed from: c */
                public final /* synthetic */ String f1409c;

                /* renamed from: d */
                public final /* synthetic */ String f1410d;

                /* renamed from: e */
                public final /* synthetic */ String f1411e;

                /* renamed from: f */
                public final /* synthetic */ String f1412f;

                /* renamed from: g */
                public final /* synthetic */ String f1413g;

                /* renamed from: h */
                public final /* synthetic */ int f1414h;

                /* renamed from: i */
                public final /* synthetic */ int f1415i;

                /* renamed from: j */
                public final /* synthetic */ x8.c f1416j;

                public /* synthetic */ c(String str6, String str22, String str32, String str42, String str52, int i102, int i112, x8.c cVar2) {
                    str = str6;
                    str2 = str22;
                    str3 = str32;
                    str4 = str42;
                    str5 = str52;
                    i10 = i102;
                    i11 = i112;
                    cVar = cVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    e.this.x(str, str2, str3, str4, str5, i10, i11, cVar);
                }
            });
        }
    }

    public void J(Context context) {
        List<AdsEvent> list;
        Handler handler;
        if (this.f1428g || (list = this.f1427f) == null || list.isEmpty() || (handler = this.f1422a) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: b8.d

            /* renamed from: c */
            public final /* synthetic */ Context f1418c;

            public /* synthetic */ d(Context context2) {
                context = context2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                e.this.y(context);
            }
        });
    }

    /* renamed from: h */
    public void w(String str, String str2, int i10, int i11) {
        if (this.f1427f == null) {
            z();
        }
        for (AdsEvent adsEvent : this.f1427f) {
            if (adsEvent.isPidEvent() && str.equalsIgnoreCase(adsEvent.getPid())) {
                for (AdEvent adEvent : adsEvent.getEventValues()) {
                    if (str2.equalsIgnoreCase(adEvent.getType())) {
                        adEvent.inrcValue();
                        if (i10 > 0) {
                            adEvent.increaseRequestTime(i10, i11);
                            return;
                        }
                        return;
                    }
                }
                List<AdEvent> eventValues = adsEvent.getEventValues();
                eventValues.add(p(str2, i10, i11));
                adsEvent.setEventValues(eventValues);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(p(str2, i10, i11));
        this.f1427f.add(new AdsEvent().setPid(str).setEventValues(arrayList));
    }

    public void i(AdConfig adConfig) {
        if (adConfig == null) {
            return;
        }
        k(adConfig, AdConfig.Type.CLICK, null, 0L);
        if (adConfig.isWithMisClick()) {
            k(adConfig, AdConfig.Type.MCLICK, null, 0L);
        }
        E(adConfig.getAdsId(), AdConfig.Type.CLICK, adConfig.getRealSource(), adConfig.getEcpm());
    }

    public void j(AppTask appTask) {
        if (appTask != null) {
            l(appTask.pid, appTask.f12000id, appTask.source, appTask.getGid(), AdConfig.Type.ESHOW, 0, 0);
        }
    }

    public void k(AdConfig adConfig, String str, x8.c cVar, long j10) {
        if (adConfig == null || ba.l.q(str)) {
            return;
        }
        I(adConfig.getPid(), adConfig.getAdsId(), adConfig.getSource(), adConfig.getGid(), str, adConfig.getEventEcpm(str), (int) j10, cVar);
        B(adConfig, str, cVar);
    }

    public void l(String str, String str2, String str3, String str4, String str5, int i10, int i11) {
        I(str, str2, str3, str4, str5, i10, i11, null);
    }

    /* renamed from: m */
    public void x(String str, String str2, String str3, @NonNull String str4, String str5, int i10, int i11, x8.c cVar) {
        if (ba.l.q(str2) || ba.l.q(str5) || ba.l.q(str3)) {
            return;
        }
        if (this.f1427f == null) {
            z();
        }
        for (AdsEvent adsEvent : this.f1427f) {
            if (!adsEvent.isPidEvent() && str4.equalsIgnoreCase(adsEvent.getItemId()) && str2.equalsIgnoreCase(adsEvent.getSlotId()) && str3.equalsIgnoreCase(adsEvent.getUnionType())) {
                for (AdEvent adEvent : adsEvent.getEventValues()) {
                    if (str5.equalsIgnoreCase(adEvent.getType())) {
                        adEvent.inrcValue();
                        if (i10 > 0) {
                            adEvent.increaseEcpm(i10);
                        }
                        if (i11 > 0) {
                            adEvent.increaseRequestTime(i11, 0);
                        }
                        adsEvent.increaseErrCode(cVar);
                        return;
                    }
                }
                List<AdEvent> eventValues = adsEvent.getEventValues();
                eventValues.add(o(str5, i10, i11));
                adsEvent.setEventValues(eventValues);
                adsEvent.increaseErrCode(cVar);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(o(str5, i10, i11));
        this.f1427f.add(new AdsEvent().setPid(str).setUnionType(str3).setSlotId(str2).setItemId(str4).setEventValues(arrayList));
    }

    public void n(AdConfig adConfig) {
        if (adConfig == null) {
            return;
        }
        k(adConfig, AdConfig.Type.SHOW, null, 0L);
        if (adConfig.isWithMisClick()) {
            k(adConfig, AdConfig.Type.MSHOW, null, 0L);
        }
        E(adConfig.getAdsId(), AdConfig.Type.SHOW, adConfig.getRealSource(), adConfig.getEcpm());
    }

    public final AdEvent o(String str, int i10, int i11) {
        AdEvent value = new AdEvent().setType(str).setValue(1);
        if (i10 > 0) {
            value.setEcpm(Integer.valueOf(i10));
        }
        if (i11 > 0) {
            value.increaseRequestTime(i11, 0);
        }
        return value;
    }

    public final AdEvent p(String str, int i10, int i11) {
        AdEvent value = new AdEvent().setType(str).setValue(1);
        if (i10 > 0) {
            value.increaseRequestTime(i10, i11);
        }
        return value;
    }

    public boolean q() {
        if (this.f1424c == null) {
            this.f1424c = Boolean.valueOf(ba.j.d(getContext(), f1419h, this.f1425d));
        }
        return this.f1424c.booleanValue();
    }

    public Handler r() {
        HandlerThread handlerThread = this.f1423b;
        if (handlerThread == null || !handlerThread.isAlive()) {
            HandlerThread handlerThread2 = new HandlerThread("ad");
            this.f1423b = handlerThread2;
            handlerThread2.start();
            Handler handler = this.f1422a;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.f1422a = null;
            }
        }
        if (this.f1422a == null) {
            this.f1422a = new Handler(this.f1423b.getLooper());
        }
        return this.f1422a;
    }

    public final SNEvent.AdPlatform t(String str) {
        str.hashCode();
        switch (str) {
            case "KS":
                return SNEvent.AdPlatform.KUAISHOU;
            case "BQT":
                return SNEvent.AdPlatform.BQT;
            case "CSJ":
                return SNEvent.AdPlatform.CSJ;
            case "GDT":
            case "1460":
            case "1490":
                return SNEvent.AdPlatform.YLH;
            default:
                return SNEvent.AdPlatform.UNKNOWN;
        }
    }

    public void u(Context context, boolean z10) {
        this.f1426e = new WeakReference<>(context);
        this.f1425d = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void y(Context context) {
        ArrayList arrayList = new ArrayList(this.f1427f);
        this.f1427f.clear();
        b bVar = new b(Integer.class, context, arrayList);
        AdsEventRequest adsEventRequest = new AdsEventRequest();
        adsEventRequest.setAdEvents(new ArrayList(arrayList));
        ((MTJsonPostParams) bVar.k()).setRequest(adsEventRequest);
        bVar.i();
    }

    public final void z() {
        try {
            Context context = getContext();
            if (context != null) {
                String B = ba.g.B(context, f1421j);
                if (!ba.l.q(B)) {
                    this.f1427f = (List) GsonUtils.b().fromJson(B, new a().getType());
                }
            }
        } catch (JsonSyntaxException | IOException e10) {
            e10.printStackTrace();
        }
        if (this.f1427f == null) {
            this.f1427f = new ArrayList();
        }
    }
}
