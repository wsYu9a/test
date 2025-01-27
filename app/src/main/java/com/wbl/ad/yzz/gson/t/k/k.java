package com.wbl.ad.yzz.gson.t.k;

import com.wbl.ad.yzz.gson.JsonSyntaxException;
import com.wbl.ad.yzz.gson.q;
import com.wbl.ad.yzz.gson.r;
import com.wbl.ad.yzz.gson.stream.JsonToken;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes5.dex */
public final class k extends q<Time> {

    /* renamed from: b */
    public static final r f32339b = new a();

    /* renamed from: a */
    public final DateFormat f32340a = new SimpleDateFormat("hh:mm:ss a");

    public static class a implements r {
        @Override // com.wbl.ad.yzz.gson.r
        public <T> q<T> a(com.wbl.ad.yzz.gson.e eVar, com.wbl.ad.yzz.gson.u.a<T> aVar) {
            if (aVar.a() == Time.class) {
                return new k();
            }
            return null;
        }
    }

    @Override // com.wbl.ad.yzz.gson.q
    /* renamed from: b */
    public synchronized Time a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
        if (aVar.t() == JsonToken.NULL) {
            aVar.q();
            return null;
        }
        try {
            return new Time(this.f32340a.parse(aVar.r()).getTime());
        } catch (ParseException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    @Override // com.wbl.ad.yzz.gson.q
    public synchronized void a(com.wbl.ad.yzz.gson.v.b bVar, Time time) throws IOException {
        bVar.d(time == null ? null : this.f32340a.format((Date) time));
    }
}
