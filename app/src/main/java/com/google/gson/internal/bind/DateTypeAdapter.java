package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {

    /* renamed from: a */
    public static final TypeAdapterFactory f8085a = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.DateTypeAdapter.1
        AnonymousClass1() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.d() == Date.class) {
                return new DateTypeAdapter();
            }
            return null;
        }
    };

    /* renamed from: b */
    private final DateFormat f8086b = DateFormat.getDateTimeInstance(2, 2, Locale.US);

    /* renamed from: c */
    private final DateFormat f8087c = DateFormat.getDateTimeInstance(2, 2);

    /* renamed from: d */
    private final DateFormat f8088d = a();

    /* renamed from: com.google.gson.internal.bind.DateTypeAdapter$1 */
    static class AnonymousClass1 implements TypeAdapterFactory {
        AnonymousClass1() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.d() == Date.class) {
                return new DateTypeAdapter();
            }
            return null;
        }
    }

    private static DateFormat a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    private synchronized Date b(String str) {
        try {
            try {
                try {
                } catch (ParseException unused) {
                    return this.f8086b.parse(str);
                }
            } catch (ParseException e2) {
                throw new JsonSyntaxException(str, e2);
            }
        } catch (ParseException unused2) {
            return this.f8088d.parse(str);
        }
        return this.f8087c.parse(str);
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: c */
    public Date read2(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.C() != JsonToken.NULL) {
            return b(aVar.A());
        }
        aVar.y();
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: d */
    public synchronized void write(com.google.gson.stream.c cVar, Date date) throws IOException {
        if (date == null) {
            cVar.m();
        } else {
            cVar.z(this.f8086b.format(date));
        }
    }
}
