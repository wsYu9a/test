package com.czhj.wire;

import com.czhj.wire.Message;
import com.czhj.wire.Message.Builder;
import com.czhj.wire.WireField;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import p1.b;

/* loaded from: classes2.dex */
final class FieldBinding<M extends Message<M, B>, B extends Message.Builder<M, B>> {

    /* renamed from: a */
    public final String f8841a;

    /* renamed from: b */
    public final String f8842b;

    /* renamed from: c */
    public final Field f8843c;

    /* renamed from: d */
    public final Field f8844d;

    /* renamed from: e */
    public final Method f8845e;

    /* renamed from: f */
    public ProtoAdapter<?> f8846f;

    /* renamed from: g */
    public ProtoAdapter<?> f8847g;

    /* renamed from: h */
    public ProtoAdapter<Object> f8848h;
    public final WireField.Label label;
    public final String name;
    public final boolean redacted;
    public final int tag;

    public FieldBinding(WireField wireField, Field field, Class<B> cls) {
        this.label = wireField.label();
        String name = field.getName();
        this.name = name;
        this.tag = wireField.tag();
        this.f8841a = wireField.keyAdapter();
        this.f8842b = wireField.adapter();
        this.redacted = wireField.redacted();
        this.f8843c = field;
        this.f8844d = a((Class<?>) cls, name);
        this.f8845e = a(cls, name, field.getType());
    }

    public ProtoAdapter<Object> a() {
        ProtoAdapter<Object> protoAdapter = this.f8848h;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> newMapAdapter = b() ? ProtoAdapter.newMapAdapter(c(), d()) : d().withLabel(this.label);
        this.f8848h = newMapAdapter;
        return newMapAdapter;
    }

    public boolean b() {
        return !this.f8841a.isEmpty();
    }

    public ProtoAdapter<?> c() {
        ProtoAdapter<?> protoAdapter = this.f8847g;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.f8841a);
        this.f8847g = protoAdapter2;
        return protoAdapter2;
    }

    public ProtoAdapter<?> d() {
        ProtoAdapter<?> protoAdapter = this.f8846f;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.f8842b);
        this.f8846f = protoAdapter2;
        return protoAdapter2;
    }

    public Object a(M m10) {
        try {
            return this.f8843c.get(m10);
        } catch (IllegalAccessException e10) {
            throw new AssertionError(e10);
        }
    }

    public void b(B b10, Object obj) {
        if (this.label.d()) {
            ((List) a((FieldBinding<M, B>) b10)).add(obj);
        } else if (this.f8841a.isEmpty()) {
            a((FieldBinding<M, B>) b10, obj);
        } else {
            ((Map) a((FieldBinding<M, B>) b10)).putAll((Map) obj);
        }
    }

    public static Field a(Class<?> cls, String str) {
        try {
            return cls.getField(str);
        } catch (NoSuchFieldException unused) {
            throw new AssertionError("No builder field " + cls.getName() + b.f29697h + str);
        }
    }

    public static Method a(Class<?> cls, String str, Class<?> cls2) {
        try {
            return cls.getMethod(str, cls2);
        } catch (NoSuchMethodException unused) {
            throw new AssertionError("No builder method " + cls.getName() + b.f29697h + str + "(" + cls2.getName() + ")");
        }
    }

    public Object a(B b10) {
        try {
            return this.f8844d.get(b10);
        } catch (IllegalAccessException e10) {
            throw new AssertionError(e10);
        }
    }

    public void a(B b10, Object obj) {
        try {
            if (this.label.b()) {
                this.f8845e.invoke(b10, obj);
            } else {
                this.f8844d.set(b10, obj);
            }
        } catch (Throwable th2) {
            throw new AssertionError(th2);
        }
    }
}
