package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* loaded from: classes.dex */
public final class SqlDateTypeAdapter extends TypeAdapter<Date> {

    /* renamed from: a */
    public static final TypeAdapterFactory f8113a = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.SqlDateTypeAdapter.1
        AnonymousClass1() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.d() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };

    /* renamed from: b */
    private final DateFormat f8114b = new SimpleDateFormat("MMM d, yyyy");

    /* renamed from: com.google.gson.internal.bind.SqlDateTypeAdapter$1 */
    static class AnonymousClass1 implements TypeAdapterFactory {
        AnonymousClass1() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.d() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: a */
    public synchronized Date read2(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.C() == JsonToken.NULL) {
            aVar.y();
            return null;
        }
        try {
            return new Date(this.f8114b.parse(aVar.A()).getTime());
        } catch (ParseException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: b */
    public synchronized void write(com.google.gson.stream.c cVar, Date date) throws IOException {
        cVar.z(date == null ? null : this.f8114b.format((java.util.Date) date));
    }
}
