package com.wbl.ad.yzz.gson.t.k;

import com.wbl.ad.yzz.gson.JsonSyntaxException;
import com.wbl.ad.yzz.gson.q;
import com.wbl.ad.yzz.gson.r;
import com.wbl.ad.yzz.gson.stream.JsonToken;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes5.dex */
public final class c extends q<Date> {

    /* renamed from: b */
    public static final r f32309b = new a();

    /* renamed from: a */
    public final List<DateFormat> f32310a;

    public static class a implements r {
        @Override // com.wbl.ad.yzz.gson.r
        public <T> q<T> a(com.wbl.ad.yzz.gson.e eVar, com.wbl.ad.yzz.gson.u.a<T> aVar) {
            if (aVar.a() == Date.class) {
                return new c();
            }
            return null;
        }
    }

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f32310a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (com.wbl.ad.yzz.gson.t.d.c()) {
            arrayList.add(com.wbl.ad.yzz.gson.t.g.a(2, 2));
        }
    }

    @Override // com.wbl.ad.yzz.gson.q
    /* renamed from: b */
    public Date a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
        if (aVar.t() != JsonToken.NULL) {
            return a(aVar.r());
        }
        aVar.q();
        return null;
    }

    public final synchronized Date a(String str) {
        Iterator<DateFormat> it = this.f32310a.iterator();
        while (it.hasNext()) {
            try {
                return it.next().parse(str);
            } catch (ParseException unused) {
            }
        }
        try {
            return com.wbl.ad.yzz.gson.t.k.o.a.a(str, new ParsePosition(0));
        } catch (ParseException e2) {
            throw new JsonSyntaxException(str, e2);
        }
    }

    @Override // com.wbl.ad.yzz.gson.q
    public synchronized void a(com.wbl.ad.yzz.gson.v.b bVar, Date date) throws IOException {
        if (date == null) {
            bVar.k();
        } else {
            bVar.d(this.f32310a.get(0).format(date));
        }
    }
}
