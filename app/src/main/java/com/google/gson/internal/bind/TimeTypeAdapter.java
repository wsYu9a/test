package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public final class TimeTypeAdapter extends TypeAdapter<Time> {

    /* renamed from: a */
    public static final TypeAdapterFactory f8115a = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TimeTypeAdapter.1
        AnonymousClass1() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.d() == Time.class) {
                return new TimeTypeAdapter();
            }
            return null;
        }
    };

    /* renamed from: b */
    private final DateFormat f8116b = new SimpleDateFormat("hh:mm:ss a");

    /* renamed from: com.google.gson.internal.bind.TimeTypeAdapter$1 */
    static class AnonymousClass1 implements TypeAdapterFactory {
        AnonymousClass1() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.d() == Time.class) {
                return new TimeTypeAdapter();
            }
            return null;
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: a */
    public synchronized Time read2(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.C() == JsonToken.NULL) {
            aVar.y();
            return null;
        }
        try {
            return new Time(this.f8116b.parse(aVar.A()).getTime());
        } catch (ParseException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: b */
    public synchronized void write(com.google.gson.stream.c cVar, Time time) throws IOException {
        cVar.z(time == null ? null : this.f8116b.format((Date) time));
    }
}
