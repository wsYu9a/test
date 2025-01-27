package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {

    /* renamed from: a */
    public static final TypeAdapterFactory f8096a = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.ObjectTypeAdapter.1
        AnonymousClass1() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.d() == Object.class) {
                return new ObjectTypeAdapter(gson);
            }
            return null;
        }
    };

    /* renamed from: b */
    private final Gson f8097b;

    /* renamed from: com.google.gson.internal.bind.ObjectTypeAdapter$1 */
    static class AnonymousClass1 implements TypeAdapterFactory {
        AnonymousClass1() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.d() == Object.class) {
                return new ObjectTypeAdapter(gson);
            }
            return null;
        }
    }

    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f8098a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f8098a = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8098a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8098a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8098a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8098a[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8098a[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* synthetic */ ObjectTypeAdapter(Gson gson, AnonymousClass1 anonymousClass1) {
        this(gson);
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public Object read2(com.google.gson.stream.a aVar) throws IOException {
        switch (a.f8098a[aVar.C().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.f();
                while (aVar.p()) {
                    arrayList.add(read2(aVar));
                }
                aVar.k();
                return arrayList;
            case 2:
                LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                aVar.g();
                while (aVar.p()) {
                    linkedTreeMap.put(aVar.w(), read2(aVar));
                }
                aVar.l();
                return linkedTreeMap;
            case 3:
                return aVar.A();
            case 4:
                return Double.valueOf(aVar.t());
            case 5:
                return Boolean.valueOf(aVar.s());
            case 6:
                aVar.y();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.m();
            return;
        }
        TypeAdapter adapter = this.f8097b.getAdapter(obj.getClass());
        if (!(adapter instanceof ObjectTypeAdapter)) {
            adapter.write(cVar, obj);
        } else {
            cVar.d();
            cVar.g();
        }
    }

    private ObjectTypeAdapter(Gson gson) {
        this.f8097b = gson;
    }
}
