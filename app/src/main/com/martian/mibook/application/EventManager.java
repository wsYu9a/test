package com.martian.mibook.application;

import android.content.Context;
import android.text.TextUtils;
import b8.e;
import ba.g;
import ba.l;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.comm.request.MTJsonPostParams;
import com.martian.libugrowth.data.Event;
import com.martian.libugrowth.request.EventRequest;
import com.martian.mibook.lib.account.request.BookEventRequest;
import com.martian.mibook.lib.account.response.BookEvent;
import com.martian.mibook.lib.model.data.TYBookItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import l9.p0;

/* loaded from: classes3.dex */
public class EventManager {

    /* renamed from: g */
    public static final String f13204g = "normalActions.json";

    /* renamed from: h */
    public static final String f13205h = "book_push_click";

    /* renamed from: i */
    public static final String f13206i = "book_push_source";

    /* renamed from: j */
    public static final String f13207j = "local_continue";

    /* renamed from: k */
    public static final String f13208k = "ad_company";

    /* renamed from: l */
    public static final String f13209l = "ad_click_title";

    /* renamed from: m */
    public static final String f13210m = "bookEvents.json";

    /* renamed from: n */
    public static final int f13211n = 0;

    /* renamed from: o */
    public static final int f13212o = 1;

    /* renamed from: p */
    public static final int f13213p = 2;

    /* renamed from: q */
    public static final int f13214q = 3;

    /* renamed from: r */
    public static final int f13215r = 5;

    /* renamed from: s */
    public static final int f13216s = 6;

    /* renamed from: t */
    public static final int f13217t = 7;

    /* renamed from: u */
    public static final int f13218u = 9;

    /* renamed from: a */
    public final Context f13219a;

    /* renamed from: b */
    public long f13220b = -1;

    /* renamed from: c */
    public List<Event> f13221c;

    /* renamed from: d */
    public boolean f13222d;

    /* renamed from: e */
    public List<BookEvent> f13223e;

    /* renamed from: f */
    public boolean f13224f;

    public class a extends TypeToken<List<Event>> {
        public a() {
        }
    }

    public class b extends f9.c<Integer> {

        /* renamed from: g */
        public final /* synthetic */ List f13226g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Class cls, Context context, List list) {
            super(cls, context);
            this.f13226g = list;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            EventManager.this.f13221c.addAll(this.f13226g);
            EventManager.this.q();
        }

        @Override // y8.h, y8.b
        public void onUDDataReceived(List<Integer> list) {
            EventManager.this.q();
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            EventManager.this.f13222d = z10;
        }
    }

    public class c extends TypeToken<List<BookEvent>> {
        public c() {
        }
    }

    public class d extends f9.c<Integer> {

        /* renamed from: g */
        public final /* synthetic */ List f13229g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Class cls, Context context, List list) {
            super(cls, context);
            this.f13229g = list;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            EventManager.this.f13223e.addAll(this.f13229g);
            EventManager.this.p();
        }

        @Override // y8.h, y8.b
        public void onUDDataReceived(List<Integer> list) {
            MiConfigSingleton.b2().u2().P(true);
            EventManager.this.p();
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            EventManager.this.f13224f = z10;
        }
    }

    public EventManager(Context context) {
        this.f13219a = context;
    }

    public void g(int i10, String str, String str2, String str3, String str4, String str5) {
        h(i10, str, str2, str3, str4, str5, 1, -1, "", false);
    }

    public void h(int i10, String str, String str2, String str3, String str4, String str5, int i11, int i12, String str6, boolean z10) {
        if (l.q(str) || l.q(str2)) {
            return;
        }
        if (this.f13223e == null) {
            n();
        }
        if (!l.q(str4)) {
            ac.a.K(this.f13219a, str4, str5);
        }
        if ((i10 == 6 || i10 == 9) && i12 >= 0) {
            for (BookEvent bookEvent : this.f13223e) {
                if (bookEvent != null && bookEvent.getEventType().intValue() == i10 && str2.equalsIgnoreCase(bookEvent.getSourceId())) {
                    bookEvent.incrValue(i11);
                    bookEvent.setChapterIndex(Integer.valueOf(i12));
                    bookEvent.addChapterId(str6);
                    bookEvent.setFirstRead(Boolean.valueOf(z10));
                    return;
                }
            }
        }
        this.f13223e.add(new BookEvent().setEventType(Integer.valueOf(i10)).setSourceName(str).setSourceId(str2).setValue(Integer.valueOf(i11)).setRecommendId(str3).setChapterIndex(Integer.valueOf(i12)).addChapterId(str6).setFirstRead(Boolean.valueOf(z10)).setT(Long.valueOf(System.currentTimeMillis())));
    }

    public void i(TYBookItem tYBookItem) {
        if (tYBookItem == null) {
            return;
        }
        if (!l.q(tYBookItem.getRecommend())) {
            ac.a.K(this.f13219a, tYBookItem.getRecommend(), "展示");
        }
        g(0, tYBookItem.getSourceName(), tYBookItem.getSourceId(), tYBookItem.getRecommendId(), "", "展示");
    }

    public void j(List<TYBookItem> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean z10 = false;
        for (TYBookItem tYBookItem : list) {
            if (!z10 && !l.q(tYBookItem.getRecommend())) {
                ac.a.K(this.f13219a, tYBookItem.getRecommend(), "展示");
                z10 = true;
            }
            g(0, tYBookItem.getSourceName(), tYBookItem.getSourceId(), tYBookItem.getRecommendId(), "", "展示");
        }
    }

    public void k(String str, String str2) {
        l(str, str2, 0);
    }

    public void l(String str, String str2, int i10) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.f13221c == null) {
            o();
        }
        for (Event event : this.f13221c) {
            if (str.equalsIgnoreCase(event.getTypeId()) && str2.equalsIgnoreCase(event.getItemId())) {
                event.increaseCount();
                event.increaseValue(i10);
                return;
            }
        }
        this.f13221c.add(new Event().setTypeId(str).setItemId(str2).setValue(Integer.valueOf(i10)));
    }

    public final boolean m() {
        long j10 = this.f13220b;
        return j10 < 0 || j10 + 10000 < System.currentTimeMillis();
    }

    public final void n() {
        try {
            this.f13223e = (List) GsonUtils.b().fromJson(g.B(this.f13219a, f13210m), new c().getType());
        } catch (JsonSyntaxException | IOException e10) {
            p0.b(e10.getMessage());
        }
        if (this.f13223e == null) {
            this.f13223e = new ArrayList();
        }
    }

    public final void o() {
        try {
            this.f13221c = (List) GsonUtils.b().fromJson(g.B(this.f13219a, f13204g), new a().getType());
        } catch (Exception e10) {
            p0.b(e10.getMessage());
        }
        if (this.f13221c == null) {
            this.f13221c = new ArrayList();
        }
    }

    public final void p() {
        try {
            g.F(this.f13219a, f13210m, GsonUtils.b().toJson(new ArrayList(this.f13223e)));
        } catch (IOException e10) {
            p0.b(e10.getMessage());
        }
    }

    public final void q() {
        try {
            g.F(this.f13219a, f13204g, GsonUtils.b().toJson(this.f13221c));
        } catch (IOException e10) {
            p0.b(e10.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void r(Context context) {
        List<BookEvent> list;
        if (this.f13224f || (list = this.f13223e) == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f13223e);
        this.f13223e.clear();
        d dVar = new d(Integer.class, context, arrayList);
        BookEventRequest bookEventRequest = new BookEventRequest();
        bookEventRequest.setEvents(arrayList);
        if (MiConfigSingleton.b2().F2() && MiConfigSingleton.b2().G1().p() != null) {
            ((MTJsonPostParams) dVar.k()).setUid(MiConfigSingleton.b2().G1().p().getUid());
            ((MTJsonPostParams) dVar.k()).setToken(MiConfigSingleton.b2().G1().p().getToken());
        }
        if (!MiConfigSingleton.b2().u2().x()) {
            ((MTJsonPostParams) dVar.k()).setImei(MiConfigSingleton.b2().A());
            ((MTJsonPostParams) dVar.k()).setOaid(MiConfigSingleton.b2().M());
        }
        ((MTJsonPostParams) dVar.k()).setRequest(bookEventRequest);
        dVar.execute();
    }

    public void s(Context context) {
        if (m()) {
            this.f13220b = System.currentTimeMillis();
            e.s().J(context);
            r(context);
            t(context);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t(Context context) {
        List<Event> list;
        if (this.f13222d || (list = this.f13221c) == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f13221c);
        this.f13221c.clear();
        b bVar = new b(Integer.class, context, arrayList);
        EventRequest eventRequest = new EventRequest();
        eventRequest.setEvents(new ArrayList(arrayList));
        ((MTJsonPostParams) bVar.k()).setRequest(eventRequest);
        bVar.execute();
    }
}
