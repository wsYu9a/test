package com.martian.libugrowth;

import android.content.Context;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.comm.request.MTJsonPostParams;
import com.martian.libsupport.e;
import com.martian.libsupport.k;
import com.martian.libugrowth.data.AdEvent;
import com.martian.libugrowth.data.AdsEvent;
import com.martian.libugrowth.data.Event;
import com.martian.libugrowth.request.AdsEventRequest;
import com.martian.libugrowth.request.EventRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    public static final String f10663a = "adActions.json";

    /* renamed from: b */
    public static final String f10664b = "normalActions.json";

    /* renamed from: c */
    public static final String f10665c = "first_in";

    /* renamed from: d */
    public static b f10666d;

    /* renamed from: e */
    private Context f10667e;

    /* renamed from: f */
    private List<AdsEvent> f10668f;

    /* renamed from: g */
    private List<Event> f10669g = new ArrayList();

    /* renamed from: h */
    private boolean f10670h;

    /* renamed from: i */
    private boolean f10671i;

    /* loaded from: classes3.dex */
    class a extends com.martian.libmars.c.c<Integer> {
        a(Class x0, Context x1) {
            super(x0, x1);
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            b.this.s();
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<Integer> times) {
            b.this.o();
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            b.this.f10670h = show;
        }
    }

    /* renamed from: com.martian.libugrowth.b$b */
    /* loaded from: classes3.dex */
    class C0261b extends com.martian.libmars.c.c<Integer> {

        /* renamed from: f */
        final /* synthetic */ List f10673f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0261b(Class x0, Context x1, final List val$events) {
            super(x0, x1);
            this.f10673f = val$events;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            b.this.f10668f.addAll(this.f10673f);
            b.this.r();
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<Integer> times) {
            b.this.r();
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            b.this.f10671i = show;
        }
    }

    /* loaded from: classes3.dex */
    class c extends com.google.gson.b.a<List<AdsEvent>> {
        c() {
        }
    }

    /* loaded from: classes3.dex */
    class d extends com.google.gson.b.a<List<Event>> {
        d() {
        }
    }

    private AdEvent j(String action, int ecpm) {
        AdEvent value = new AdEvent().setType(action).setValue(1);
        if (ecpm > 0) {
            value.setEcpm(Integer.valueOf(ecpm));
        }
        return value;
    }

    public static b k() {
        if (f10666d == null) {
            f10666d = new b();
        }
        return f10666d;
    }

    private void m() throws IOException, JSONException {
        Context context = this.f10667e;
        if (context == null) {
            this.f10668f = new ArrayList();
            return;
        }
        List<AdsEvent> list = (List) GsonUtils.b().fromJson(e.B(context, f10663a), new c().getType());
        this.f10668f = list;
        if (list == null) {
            this.f10668f = new ArrayList();
        }
    }

    private void n() throws IOException, JSONException {
        Context context = this.f10667e;
        if (context == null) {
            this.f10669g = new ArrayList();
            return;
        }
        List<Event> list = (List) GsonUtils.b().fromJson(e.B(context, f10664b), new d().getType());
        this.f10669g = list;
        if (list == null) {
            this.f10669g = new ArrayList();
        }
    }

    public void o() {
        this.f10669g = new ArrayList();
        s();
    }

    private void p() throws IOException, JSONException {
        Context context = this.f10667e;
        if (context != null) {
            e.E(context, f10663a, GsonUtils.b().toJson(this.f10668f));
        }
    }

    private void q() throws IOException, JSONException {
        Context context = this.f10667e;
        if (context != null) {
            e.E(context, f10664b, GsonUtils.b().toJson(this.f10669g));
        }
    }

    public void r() {
        try {
            p();
        } catch (Exception unused) {
        }
    }

    public void s() {
        try {
            q();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void v(Context context) {
        List<Event> list;
        if (this.f10670h || (list = this.f10669g) == null || list.isEmpty()) {
            return;
        }
        a aVar = new a(Integer.class, context);
        EventRequest eventRequest = new EventRequest();
        eventRequest.setEvents(new ArrayList(this.f10669g));
        ((MTJsonPostParams) aVar.k()).setRequest(eventRequest);
        aVar.execute();
    }

    public void g(String adId, String action, String unionType, String itemId, int ecpm) {
        if (k.p(adId) || k.p(action) || k.p(unionType)) {
            return;
        }
        if (this.f10668f == null) {
            this.f10668f = new ArrayList();
        }
        for (AdsEvent adsEvent : this.f10668f) {
            if (itemId.equalsIgnoreCase(adsEvent.getItemId()) && adId.equalsIgnoreCase(adsEvent.getSlotId()) && unionType.equalsIgnoreCase(adsEvent.getUnionType())) {
                for (AdEvent adEvent : adsEvent.getEventValues()) {
                    if (action.equalsIgnoreCase(adEvent.getType())) {
                        adEvent.inrcValue();
                        if (ecpm > 0) {
                            adEvent.inrcEcpm(ecpm);
                            return;
                        }
                        return;
                    }
                }
                List<AdEvent> eventValues = adsEvent.getEventValues();
                eventValues.add(j(action, ecpm));
                adsEvent.setEventValues(eventValues);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(j(action, ecpm));
        this.f10668f.add(new AdsEvent().setUnionType(unionType).setSlotId(adId).setItemId(itemId).setEventValues(arrayList));
    }

    public void h(String pid, String action) {
        for (AdsEvent adsEvent : this.f10668f) {
            if (pid.equalsIgnoreCase(adsEvent.getPid())) {
                Iterator<AdEvent> it = adsEvent.getEventValues().iterator();
                while (it.hasNext()) {
                    it.next().inrcValue();
                }
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(j(action, 0));
        this.f10668f.add(new AdsEvent().setPid(pid).setEventValues(arrayList));
    }

    public void i(String key, String value) {
        if (this.f10670h || k.p(key) || k.p(value) || value.contains("null")) {
            return;
        }
        if (this.f10669g == null) {
            this.f10669g = new ArrayList();
        }
        this.f10669g.add(new Event().setTypeId(key).setItemId(value));
    }

    public void l(Context context) {
        this.f10667e = context;
        try {
            m();
        } catch (Exception unused) {
            this.f10668f = new ArrayList();
        }
        try {
            n();
        } catch (Exception unused2) {
            this.f10669g = new ArrayList();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void t(Context context) {
        List<AdsEvent> list;
        if (this.f10671i || (list = this.f10668f) == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f10668f);
        this.f10668f.clear();
        C0261b c0261b = new C0261b(Integer.class, context, arrayList);
        AdsEventRequest adsEventRequest = new AdsEventRequest();
        adsEventRequest.setAdEvents(new ArrayList(arrayList));
        ((MTJsonPostParams) c0261b.k()).setRequest(adsEventRequest);
        c0261b.execute();
    }

    public void u(Context context) {
        t(context);
        v(context);
    }
}
