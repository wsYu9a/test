package com.czhj.wire;

import com.czhj.wire.Message;
import com.czhj.wire.Message.Builder;
import com.czhj.wire.ProtoAdapter;
import com.czhj.wire.WireField;
import com.czhj.wire.internal.Internal;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class RuntimeMessageAdapter<M extends Message<M, B>, B extends Message.Builder<M, B>> extends ProtoAdapter<M> {

    /* renamed from: d */
    public static final String f8879d = "██";

    /* renamed from: a */
    public final Class<M> f8880a;

    /* renamed from: b */
    public final Class<B> f8881b;

    /* renamed from: c */
    public final Map<Integer, FieldBinding<M, B>> f8882c;

    public RuntimeMessageAdapter(Class<M> cls, Class<B> cls2, Map<Integer, FieldBinding<M, B>> map) {
        super(FieldEncoding.LENGTH_DELIMITED, cls);
        this.f8880a = cls;
        this.f8881b = cls2;
        this.f8882c = map;
    }

    public static <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> a(Class<M> cls) {
        Class b10 = b(cls);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Field field : cls.getDeclaredFields()) {
            WireField wireField = (WireField) field.getAnnotation(WireField.class);
            if (wireField != null) {
                linkedHashMap.put(Integer.valueOf(wireField.tag()), new FieldBinding(wireField, field, b10));
            }
        }
        return new RuntimeMessageAdapter<>(cls, b10, Collections.unmodifiableMap(linkedHashMap));
    }

    public static <M extends Message<M, B>, B extends Message.Builder<M, B>> Class<B> b(Class<M> cls) {
        try {
            return (Class<B>) Class.forName(cls.getName() + "$Builder");
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("No builder class found for message type " + cls.getName());
        }
    }

    public Map<Integer, FieldBinding<M, B>> c() {
        return this.f8882c;
    }

    public B d() {
        try {
            return this.f8881b.newInstance();
        } catch (Throwable th2) {
            throw new AssertionError(th2);
        }
    }

    @Override // com.czhj.wire.ProtoAdapter
    public M decode(ProtoReader protoReader) throws IOException {
        B d10 = d();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return (M) d10.build();
            }
            FieldBinding<M, B> fieldBinding = this.f8882c.get(Integer.valueOf(nextTag));
            if (fieldBinding != null) {
                try {
                    fieldBinding.b(d10, (fieldBinding.b() ? fieldBinding.a() : fieldBinding.d()).decode(protoReader));
                } catch (ProtoAdapter.EnumConstantNotFoundException e10) {
                    d10.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e10.value));
                }
            } else {
                FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                d10.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
            }
        }
    }

    @Override // com.czhj.wire.ProtoAdapter
    public void encode(ProtoWriter protoWriter, M m10) throws IOException {
        for (FieldBinding<M, B> fieldBinding : this.f8882c.values()) {
            Object a10 = fieldBinding.a((FieldBinding<M, B>) m10);
            if (a10 != null) {
                fieldBinding.a().encodeWithTag(protoWriter, fieldBinding.tag, a10);
            }
        }
        protoWriter.writeBytes(m10.unknownFields());
    }

    @Override // com.czhj.wire.ProtoAdapter
    public int encodedSize(M m10) {
        int i10 = m10.cachedSerializedSize;
        if (i10 != 0) {
            return i10;
        }
        int i11 = 0;
        for (FieldBinding<M, B> fieldBinding : this.f8882c.values()) {
            Object a10 = fieldBinding.a((FieldBinding<M, B>) m10);
            if (a10 != null) {
                i11 += fieldBinding.a().encodedSizeWithTag(fieldBinding.tag, a10);
            }
        }
        int size = i11 + m10.unknownFields().size();
        m10.cachedSerializedSize = size;
        return size;
    }

    public boolean equals(Object obj) {
        return (obj instanceof RuntimeMessageAdapter) && ((RuntimeMessageAdapter) obj).f8880a == this.f8880a;
    }

    public int hashCode() {
        return this.f8880a.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.czhj.wire.ProtoAdapter
    public M redact(M m10) {
        Message.Builder newBuilder = m10.newBuilder();
        for (FieldBinding<M, B> fieldBinding : this.f8882c.values()) {
            if (fieldBinding.redacted && fieldBinding.label == WireField.Label.REQUIRED) {
                throw new UnsupportedOperationException(String.format("Field '%s' in %s is required and cannot be redacted.", fieldBinding.name, this.javaType.getName()));
            }
            boolean isAssignableFrom = Message.class.isAssignableFrom(fieldBinding.d().javaType);
            if (fieldBinding.redacted || (isAssignableFrom && !fieldBinding.label.d())) {
                Object a10 = fieldBinding.a((FieldBinding<M, B>) newBuilder);
                if (a10 != null) {
                    fieldBinding.a((FieldBinding<M, B>) newBuilder, fieldBinding.a().redact(a10));
                }
            } else if (isAssignableFrom && fieldBinding.label.d()) {
                Internal.redactElements((List) fieldBinding.a((FieldBinding<M, B>) newBuilder), fieldBinding.d());
            }
        }
        newBuilder.clearUnknownFields();
        return (M) newBuilder.build();
    }

    @Override // com.czhj.wire.ProtoAdapter
    public String toString(M m10) {
        StringBuilder sb2 = new StringBuilder();
        for (FieldBinding<M, B> fieldBinding : this.f8882c.values()) {
            Object a10 = fieldBinding.a((FieldBinding<M, B>) m10);
            if (a10 != null) {
                sb2.append(", ");
                sb2.append(fieldBinding.name);
                sb2.append('=');
                if (fieldBinding.redacted) {
                    a10 = f8879d;
                }
                sb2.append(a10);
            }
        }
        sb2.replace(0, 2, this.f8880a.getSimpleName() + '{');
        sb2.append('}');
        return sb2.toString();
    }
}
