package com.wbl.ad.yzz.gson;

import com.wbl.ad.yzz.gson.stream.JsonToken;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes5.dex */
public final class a extends q<Date> {

    /* renamed from: a */
    public final Class<? extends Date> f32197a;

    /* renamed from: b */
    public final List<DateFormat> f32198b;

    public a(Class<? extends Date> cls, String str) {
        ArrayList arrayList = new ArrayList();
        this.f32198b = arrayList;
        this.f32197a = a(cls);
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    @Override // com.wbl.ad.yzz.gson.q
    /* renamed from: b */
    public Date a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
        if (aVar.t() == JsonToken.NULL) {
            aVar.q();
            return null;
        }
        Date a2 = a(aVar.r());
        Class<? extends Date> cls = this.f32197a;
        if (cls == Date.class) {
            return a2;
        }
        if (cls == Timestamp.class) {
            return new Timestamp(a2.getTime());
        }
        if (cls == java.sql.Date.class) {
            return new java.sql.Date(a2.getTime());
        }
        throw new AssertionError();
    }

    public String toString() {
        DateFormat dateFormat = this.f32198b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    public static Class<? extends Date> a(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    @Override // com.wbl.ad.yzz.gson.q
    public void a(com.wbl.ad.yzz.gson.v.b bVar, Date date) throws IOException {
        if (date == null) {
            bVar.k();
            return;
        }
        synchronized (this.f32198b) {
            bVar.d(this.f32198b.get(0).format(date));
        }
    }

    public a(Class<? extends Date> cls, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        this.f32198b = arrayList;
        this.f32197a = a(cls);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i2, i3, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i2, i3));
        }
        if (com.wbl.ad.yzz.gson.t.d.c()) {
            arrayList.add(com.wbl.ad.yzz.gson.t.g.a(i2, i3));
        }
    }

    public final Date a(String str) {
        synchronized (this.f32198b) {
            Iterator<DateFormat> it = this.f32198b.iterator();
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
    }
}
