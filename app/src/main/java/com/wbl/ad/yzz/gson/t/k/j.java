package com.wbl.ad.yzz.gson.t.k;

import com.wbl.ad.yzz.gson.JsonSyntaxException;
import com.wbl.ad.yzz.gson.q;
import com.wbl.ad.yzz.gson.r;
import com.wbl.ad.yzz.gson.stream.JsonToken;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* loaded from: classes5.dex */
public final class j extends q<Date> {

    /* renamed from: b */
    public static final r f32337b = new a();

    /* renamed from: a */
    public final DateFormat f32338a = new SimpleDateFormat("MMM d, yyyy");

    public static class a implements r {
        @Override // com.wbl.ad.yzz.gson.r
        public <T> q<T> a(com.wbl.ad.yzz.gson.e eVar, com.wbl.ad.yzz.gson.u.a<T> aVar) {
            if (aVar.a() == Date.class) {
                return new j();
            }
            return null;
        }
    }

    @Override // com.wbl.ad.yzz.gson.q
    /* renamed from: b */
    public synchronized Date a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
        if (aVar.t() == JsonToken.NULL) {
            aVar.q();
            return null;
        }
        try {
            return new Date(this.f32338a.parse(aVar.r()).getTime());
        } catch (ParseException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    @Override // com.wbl.ad.yzz.gson.q
    public synchronized void a(com.wbl.ad.yzz.gson.v.b bVar, Date date) throws IOException {
        bVar.d(date == null ? null : this.f32338a.format((java.util.Date) date));
    }
}
