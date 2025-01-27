package com.wbl.ad.yzz.gson.t.k;

import com.wbl.ad.yzz.gson.internal.LinkedTreeMap;
import com.wbl.ad.yzz.gson.q;
import com.wbl.ad.yzz.gson.r;
import com.wbl.ad.yzz.gson.stream.JsonToken;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public final class h extends q<Object> {

    /* renamed from: b */
    public static final r f32318b = new a();

    /* renamed from: a */
    public final com.wbl.ad.yzz.gson.e f32319a;

    public static class a implements r {
        @Override // com.wbl.ad.yzz.gson.r
        public <T> q<T> a(com.wbl.ad.yzz.gson.e eVar, com.wbl.ad.yzz.gson.u.a<T> aVar) {
            if (aVar.a() == Object.class) {
                return new h(eVar);
            }
            return null;
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f32320a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f32320a = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32320a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32320a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32320a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32320a[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32320a[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public h(com.wbl.ad.yzz.gson.e eVar) {
        this.f32319a = eVar;
    }

    @Override // com.wbl.ad.yzz.gson.q
    public Object a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
        switch (b.f32320a[aVar.t().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.i()) {
                    arrayList.add(a(aVar));
                }
                aVar.f();
                return arrayList;
            case 2:
                LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                aVar.b();
                while (aVar.i()) {
                    linkedTreeMap.put(aVar.p(), a(aVar));
                }
                aVar.g();
                return linkedTreeMap;
            case 3:
                return aVar.r();
            case 4:
                return Double.valueOf(aVar.m());
            case 5:
                return Boolean.valueOf(aVar.l());
            case 6:
                aVar.q();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.wbl.ad.yzz.gson.q
    public void a(com.wbl.ad.yzz.gson.v.b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.k();
            return;
        }
        q a2 = this.f32319a.a((Class) obj.getClass());
        if (a2 instanceof h) {
            bVar.d();
            bVar.f();
        } else {
            a2.a(bVar, obj);
        }
    }
}
