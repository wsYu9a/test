package com.czhj.wire;

import com.czhj.wire.Message;
import com.czhj.wire.WireField;
import com.czhj.wire.okio.Buffer;
import com.czhj.wire.okio.BufferedSink;
import com.czhj.wire.okio.BufferedSource;
import com.czhj.wire.okio.ByteString;
import com.czhj.wire.okio.Okio;
import com.czhj.wire.okio.Utf8;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class ProtoAdapter<E> {
    public static final ProtoAdapter<Boolean> BOOL;
    public static final ProtoAdapter<ByteString> BYTES;
    public static final ProtoAdapter<Double> DOUBLE;
    public static final ProtoAdapter<Integer> FIXED32;
    public static final ProtoAdapter<Long> FIXED64;
    private static final int FIXED_32_SIZE = 4;
    private static final int FIXED_64_SIZE = 8;
    private static final int FIXED_BOOL_SIZE = 1;
    public static final ProtoAdapter<Float> FLOAT;
    public static final ProtoAdapter<Integer> INT32;
    public static final ProtoAdapter<Long> INT64;
    public static final ProtoAdapter<Integer> SFIXED32;
    public static final ProtoAdapter<Long> SFIXED64;
    public static final ProtoAdapter<Integer> SINT32;
    public static final ProtoAdapter<Long> SINT64;
    public static final ProtoAdapter<String> STRING;
    public static final ProtoAdapter<Integer> UINT32;
    public static final ProtoAdapter<Long> UINT64;
    private final FieldEncoding fieldEncoding;
    final Class<?> javaType;
    ProtoAdapter<List<E>> packedAdapter;
    ProtoAdapter<List<E>> repeatedAdapter;

    /* renamed from: com.czhj.wire.ProtoAdapter$1 */
    public class AnonymousClass1 extends ProtoAdapter<Boolean> {
        public AnonymousClass1(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Boolean decode(ProtoReader protoReader) throws IOException {
            int readVarint32 = protoReader.readVarint32();
            if (readVarint32 == 0) {
                return Boolean.FALSE;
            }
            if (readVarint32 == 1) {
                return Boolean.TRUE;
            }
            throw new IOException(String.format("Invalid boolean value 0x%02x", Integer.valueOf(readVarint32)));
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Boolean bool) throws IOException {
            protoWriter.writeVarint32(bool.booleanValue() ? 1 : 0);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Boolean bool) {
            return 1;
        }
    }

    /* renamed from: com.czhj.wire.ProtoAdapter$10 */
    public class AnonymousClass10 extends ProtoAdapter<Float> {
        public AnonymousClass10(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Float decode(ProtoReader protoReader) throws IOException {
            return Float.valueOf(Float.intBitsToFloat(protoReader.readFixed32()));
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Float f10) throws IOException {
            protoWriter.writeFixed32(Float.floatToIntBits(f10.floatValue()));
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Float f10) {
            return 4;
        }
    }

    /* renamed from: com.czhj.wire.ProtoAdapter$11 */
    public class AnonymousClass11 extends ProtoAdapter<Double> {
        public AnonymousClass11(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Double decode(ProtoReader protoReader) throws IOException {
            return Double.valueOf(Double.longBitsToDouble(protoReader.readFixed64()));
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Double d10) throws IOException {
            protoWriter.writeFixed64(Double.doubleToLongBits(d10.doubleValue()));
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Double d10) {
            return 8;
        }
    }

    /* renamed from: com.czhj.wire.ProtoAdapter$12 */
    public class AnonymousClass12 extends ProtoAdapter<String> {
        public AnonymousClass12(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public String decode(ProtoReader protoReader) throws IOException {
            return protoReader.readString();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, String str) throws IOException {
            protoWriter.writeString(str);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(String str) {
            return (int) Utf8.size(str);
        }
    }

    /* renamed from: com.czhj.wire.ProtoAdapter$13 */
    public class AnonymousClass13 extends ProtoAdapter<ByteString> {
        public AnonymousClass13(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public ByteString decode(ProtoReader protoReader) throws IOException {
            return protoReader.readBytes();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, ByteString byteString) throws IOException {
            protoWriter.writeBytes(byteString);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(ByteString byteString) {
            return byteString.size();
        }
    }

    /* renamed from: com.czhj.wire.ProtoAdapter$14 */
    public class AnonymousClass14 extends ProtoAdapter<List<E>> {
        public AnonymousClass14(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public List<E> decode(ProtoReader protoReader) throws IOException {
            return Collections.singletonList(ProtoAdapter.this.decode(protoReader));
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, List<E> list) throws IOException {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                ProtoAdapter.this.encode(protoWriter, (ProtoWriter) list.get(i10));
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encodeWithTag(ProtoWriter protoWriter, int i10, List<E> list) throws IOException {
            if (list.isEmpty()) {
                return;
            }
            super.encodeWithTag(protoWriter, i10, (int) list);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(List<E> list) {
            int size = list.size();
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                i10 += ProtoAdapter.this.encodedSize(list.get(i11));
            }
            return i10;
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSizeWithTag(int i10, List<E> list) {
            if (list.isEmpty()) {
                return 0;
            }
            return super.encodedSizeWithTag(i10, (int) list);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public List<E> redact(List<E> list) {
            return Collections.emptyList();
        }
    }

    /* renamed from: com.czhj.wire.ProtoAdapter$15 */
    public class AnonymousClass15 extends ProtoAdapter<List<E>> {
        public AnonymousClass15(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public List<E> decode(ProtoReader protoReader) throws IOException {
            return Collections.singletonList(ProtoAdapter.this.decode(protoReader));
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, List<E> list) {
            throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encodeWithTag(ProtoWriter protoWriter, int i10, List<E> list) throws IOException {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                ProtoAdapter.this.encodeWithTag(protoWriter, i10, list.get(i11));
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(List<E> list) {
            throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSizeWithTag(int i10, List<E> list) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                i11 += ProtoAdapter.this.encodedSizeWithTag(i10, list.get(i12));
            }
            return i11;
        }

        @Override // com.czhj.wire.ProtoAdapter
        public List<E> redact(List<E> list) {
            return Collections.emptyList();
        }
    }

    /* renamed from: com.czhj.wire.ProtoAdapter$2 */
    public class AnonymousClass2 extends ProtoAdapter<Integer> {
        public AnonymousClass2(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Integer decode(ProtoReader protoReader) throws IOException {
            return Integer.valueOf(protoReader.readVarint32());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Integer num) throws IOException {
            protoWriter.f(num.intValue());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Integer num) {
            return ProtoWriter.c(num.intValue());
        }
    }

    /* renamed from: com.czhj.wire.ProtoAdapter$3 */
    public class AnonymousClass3 extends ProtoAdapter<Integer> {
        public AnonymousClass3(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Integer decode(ProtoReader protoReader) throws IOException {
            return Integer.valueOf(protoReader.readVarint32());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Integer num) throws IOException {
            protoWriter.writeVarint32(num.intValue());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Integer num) {
            return ProtoWriter.e(num.intValue());
        }
    }

    /* renamed from: com.czhj.wire.ProtoAdapter$4 */
    public class AnonymousClass4 extends ProtoAdapter<Integer> {
        public AnonymousClass4(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Integer decode(ProtoReader protoReader) throws IOException {
            return Integer.valueOf(ProtoWriter.a(protoReader.readVarint32()));
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Integer num) throws IOException {
            protoWriter.writeVarint32(ProtoWriter.b(num.intValue()));
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Integer num) {
            return ProtoWriter.e(ProtoWriter.b(num.intValue()));
        }
    }

    /* renamed from: com.czhj.wire.ProtoAdapter$5 */
    public class AnonymousClass5 extends ProtoAdapter<Integer> {
        public AnonymousClass5(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Integer decode(ProtoReader protoReader) throws IOException {
            return Integer.valueOf(protoReader.readFixed32());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Integer num) throws IOException {
            protoWriter.writeFixed32(num.intValue());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Integer num) {
            return 4;
        }
    }

    /* renamed from: com.czhj.wire.ProtoAdapter$6 */
    public class AnonymousClass6 extends ProtoAdapter<Long> {
        public AnonymousClass6(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Long decode(ProtoReader protoReader) throws IOException {
            return Long.valueOf(protoReader.readVarint64());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Long l10) throws IOException {
            protoWriter.writeVarint64(l10.longValue());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Long l10) {
            return ProtoWriter.c(l10.longValue());
        }
    }

    /* renamed from: com.czhj.wire.ProtoAdapter$7 */
    public class AnonymousClass7 extends ProtoAdapter<Long> {
        public AnonymousClass7(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Long decode(ProtoReader protoReader) throws IOException {
            return Long.valueOf(protoReader.readVarint64());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Long l10) throws IOException {
            protoWriter.writeVarint64(l10.longValue());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Long l10) {
            return ProtoWriter.c(l10.longValue());
        }
    }

    /* renamed from: com.czhj.wire.ProtoAdapter$8 */
    public class AnonymousClass8 extends ProtoAdapter<Long> {
        public AnonymousClass8(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Long decode(ProtoReader protoReader) throws IOException {
            return Long.valueOf(ProtoWriter.a(protoReader.readVarint64()));
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Long l10) throws IOException {
            protoWriter.writeVarint64(ProtoWriter.b(l10.longValue()));
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Long l10) {
            return ProtoWriter.c(ProtoWriter.b(l10.longValue()));
        }
    }

    /* renamed from: com.czhj.wire.ProtoAdapter$9 */
    public class AnonymousClass9 extends ProtoAdapter<Long> {
        public AnonymousClass9(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Long decode(ProtoReader protoReader) throws IOException {
            return Long.valueOf(protoReader.readFixed64());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Long l10) throws IOException {
            protoWriter.writeFixed64(l10.longValue());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Long l10) {
            return 8;
        }
    }

    public static final class EnumConstantNotFoundException extends IllegalArgumentException {
        public final int value;

        public EnumConstantNotFoundException(int i10, Class<?> cls) {
            super("Unknown enum tag " + i10 + " for " + cls.getCanonicalName());
            this.value = i10;
        }
    }

    public static final class MapEntryProtoAdapter<K, V> extends ProtoAdapter<Map.Entry<K, V>> {

        /* renamed from: a */
        public final ProtoAdapter<K> f8854a;

        /* renamed from: b */
        public final ProtoAdapter<V> f8855b;

        public MapEntryProtoAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
            super(FieldEncoding.LENGTH_DELIMITED, Map.Entry.class);
            this.f8854a = protoAdapter;
            this.f8855b = protoAdapter2;
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Map.Entry<K, V> decode(ProtoReader protoReader) {
            throw new UnsupportedOperationException();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Map.Entry<K, V> entry) throws IOException {
            this.f8854a.encodeWithTag(protoWriter, 1, entry.getKey());
            this.f8855b.encodeWithTag(protoWriter, 2, entry.getValue());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Map.Entry<K, V> entry) {
            return this.f8854a.encodedSizeWithTag(1, entry.getKey()) + this.f8855b.encodedSizeWithTag(2, entry.getValue());
        }
    }

    public static final class MapProtoAdapter<K, V> extends ProtoAdapter<Map<K, V>> {

        /* renamed from: a */
        public final MapEntryProtoAdapter<K, V> f8856a;

        public MapProtoAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
            super(FieldEncoding.LENGTH_DELIMITED, Map.class);
            this.f8856a = new MapEntryProtoAdapter<>(protoAdapter, protoAdapter2);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Map<K, V> decode(ProtoReader protoReader) throws IOException {
            long beginMessage = protoReader.beginMessage();
            K k10 = null;
            V v10 = null;
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    break;
                }
                if (nextTag == 1) {
                    k10 = this.f8856a.f8854a.decode(protoReader);
                } else if (nextTag == 2) {
                    v10 = this.f8856a.f8855b.decode(protoReader);
                }
            }
            protoReader.endMessage(beginMessage);
            if (k10 == null) {
                throw new IllegalStateException("Map entry with null key");
            }
            if (v10 != null) {
                return Collections.singletonMap(k10, v10);
            }
            throw new IllegalStateException("Map entry with null value");
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Map<K, V> map) {
            throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encodeWithTag(ProtoWriter protoWriter, int i10, Map<K, V> map) throws IOException {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                this.f8856a.encodeWithTag(protoWriter, i10, it.next());
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Map<K, V> map) {
            throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSizeWithTag(int i10, Map<K, V> map) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            int i11 = 0;
            while (it.hasNext()) {
                i11 += this.f8856a.encodedSizeWithTag(i10, it.next());
            }
            return i11;
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Map<K, V> redact(Map<K, V> map) {
            return Collections.emptyMap();
        }
    }

    static {
        FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        BOOL = new ProtoAdapter<Boolean>(fieldEncoding, Boolean.class) { // from class: com.czhj.wire.ProtoAdapter.1
            public AnonymousClass1(FieldEncoding fieldEncoding2, Class cls) {
                super(fieldEncoding2, cls);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public Boolean decode(ProtoReader protoReader) throws IOException {
                int readVarint32 = protoReader.readVarint32();
                if (readVarint32 == 0) {
                    return Boolean.FALSE;
                }
                if (readVarint32 == 1) {
                    return Boolean.TRUE;
                }
                throw new IOException(String.format("Invalid boolean value 0x%02x", Integer.valueOf(readVarint32)));
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Boolean bool) throws IOException {
                protoWriter.writeVarint32(bool.booleanValue() ? 1 : 0);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(Boolean bool) {
                return 1;
            }
        };
        INT32 = new ProtoAdapter<Integer>(fieldEncoding2, Integer.class) { // from class: com.czhj.wire.ProtoAdapter.2
            public AnonymousClass2(FieldEncoding fieldEncoding2, Class cls) {
                super(fieldEncoding2, cls);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public Integer decode(ProtoReader protoReader) throws IOException {
                return Integer.valueOf(protoReader.readVarint32());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Integer num) throws IOException {
                protoWriter.f(num.intValue());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(Integer num) {
                return ProtoWriter.c(num.intValue());
            }
        };
        UINT32 = new ProtoAdapter<Integer>(fieldEncoding2, Integer.class) { // from class: com.czhj.wire.ProtoAdapter.3
            public AnonymousClass3(FieldEncoding fieldEncoding2, Class cls) {
                super(fieldEncoding2, cls);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public Integer decode(ProtoReader protoReader) throws IOException {
                return Integer.valueOf(protoReader.readVarint32());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Integer num) throws IOException {
                protoWriter.writeVarint32(num.intValue());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(Integer num) {
                return ProtoWriter.e(num.intValue());
            }
        };
        SINT32 = new ProtoAdapter<Integer>(fieldEncoding2, Integer.class) { // from class: com.czhj.wire.ProtoAdapter.4
            public AnonymousClass4(FieldEncoding fieldEncoding2, Class cls) {
                super(fieldEncoding2, cls);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public Integer decode(ProtoReader protoReader) throws IOException {
                return Integer.valueOf(ProtoWriter.a(protoReader.readVarint32()));
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Integer num) throws IOException {
                protoWriter.writeVarint32(ProtoWriter.b(num.intValue()));
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(Integer num) {
                return ProtoWriter.e(ProtoWriter.b(num.intValue()));
            }
        };
        FieldEncoding fieldEncoding2 = FieldEncoding.FIXED32;
        AnonymousClass5 anonymousClass5 = new ProtoAdapter<Integer>(fieldEncoding2, Integer.class) { // from class: com.czhj.wire.ProtoAdapter.5
            public AnonymousClass5(FieldEncoding fieldEncoding22, Class cls) {
                super(fieldEncoding22, cls);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public Integer decode(ProtoReader protoReader) throws IOException {
                return Integer.valueOf(protoReader.readFixed32());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Integer num) throws IOException {
                protoWriter.writeFixed32(num.intValue());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(Integer num) {
                return 4;
            }
        };
        FIXED32 = anonymousClass5;
        SFIXED32 = anonymousClass5;
        INT64 = new ProtoAdapter<Long>(fieldEncoding2, Long.class) { // from class: com.czhj.wire.ProtoAdapter.6
            public AnonymousClass6(FieldEncoding fieldEncoding22, Class cls) {
                super(fieldEncoding22, cls);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public Long decode(ProtoReader protoReader) throws IOException {
                return Long.valueOf(protoReader.readVarint64());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Long l10) throws IOException {
                protoWriter.writeVarint64(l10.longValue());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(Long l10) {
                return ProtoWriter.c(l10.longValue());
            }
        };
        UINT64 = new ProtoAdapter<Long>(fieldEncoding22, Long.class) { // from class: com.czhj.wire.ProtoAdapter.7
            public AnonymousClass7(FieldEncoding fieldEncoding22, Class cls) {
                super(fieldEncoding22, cls);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public Long decode(ProtoReader protoReader) throws IOException {
                return Long.valueOf(protoReader.readVarint64());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Long l10) throws IOException {
                protoWriter.writeVarint64(l10.longValue());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(Long l10) {
                return ProtoWriter.c(l10.longValue());
            }
        };
        SINT64 = new ProtoAdapter<Long>(fieldEncoding22, Long.class) { // from class: com.czhj.wire.ProtoAdapter.8
            public AnonymousClass8(FieldEncoding fieldEncoding22, Class cls) {
                super(fieldEncoding22, cls);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public Long decode(ProtoReader protoReader) throws IOException {
                return Long.valueOf(ProtoWriter.a(protoReader.readVarint64()));
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Long l10) throws IOException {
                protoWriter.writeVarint64(ProtoWriter.b(l10.longValue()));
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(Long l10) {
                return ProtoWriter.c(ProtoWriter.b(l10.longValue()));
            }
        };
        FieldEncoding fieldEncoding3 = FieldEncoding.FIXED64;
        AnonymousClass9 anonymousClass9 = new ProtoAdapter<Long>(fieldEncoding3, Long.class) { // from class: com.czhj.wire.ProtoAdapter.9
            public AnonymousClass9(FieldEncoding fieldEncoding32, Class cls) {
                super(fieldEncoding32, cls);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public Long decode(ProtoReader protoReader) throws IOException {
                return Long.valueOf(protoReader.readFixed64());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Long l10) throws IOException {
                protoWriter.writeFixed64(l10.longValue());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(Long l10) {
                return 8;
            }
        };
        FIXED64 = anonymousClass9;
        SFIXED64 = anonymousClass9;
        FLOAT = new ProtoAdapter<Float>(fieldEncoding22, Float.class) { // from class: com.czhj.wire.ProtoAdapter.10
            public AnonymousClass10(FieldEncoding fieldEncoding22, Class cls) {
                super(fieldEncoding22, cls);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public Float decode(ProtoReader protoReader) throws IOException {
                return Float.valueOf(Float.intBitsToFloat(protoReader.readFixed32()));
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Float f10) throws IOException {
                protoWriter.writeFixed32(Float.floatToIntBits(f10.floatValue()));
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(Float f10) {
                return 4;
            }
        };
        DOUBLE = new ProtoAdapter<Double>(fieldEncoding32, Double.class) { // from class: com.czhj.wire.ProtoAdapter.11
            public AnonymousClass11(FieldEncoding fieldEncoding32, Class cls) {
                super(fieldEncoding32, cls);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public Double decode(ProtoReader protoReader) throws IOException {
                return Double.valueOf(Double.longBitsToDouble(protoReader.readFixed64()));
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Double d10) throws IOException {
                protoWriter.writeFixed64(Double.doubleToLongBits(d10.doubleValue()));
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(Double d10) {
                return 8;
            }
        };
        FieldEncoding fieldEncoding4 = FieldEncoding.LENGTH_DELIMITED;
        STRING = new ProtoAdapter<String>(fieldEncoding4, String.class) { // from class: com.czhj.wire.ProtoAdapter.12
            public AnonymousClass12(FieldEncoding fieldEncoding42, Class cls) {
                super(fieldEncoding42, cls);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public String decode(ProtoReader protoReader) throws IOException {
                return protoReader.readString();
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, String str) throws IOException {
                protoWriter.writeString(str);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(String str) {
                return (int) Utf8.size(str);
            }
        };
        BYTES = new ProtoAdapter<ByteString>(fieldEncoding42, ByteString.class) { // from class: com.czhj.wire.ProtoAdapter.13
            public AnonymousClass13(FieldEncoding fieldEncoding42, Class cls) {
                super(fieldEncoding42, cls);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public ByteString decode(ProtoReader protoReader) throws IOException {
                return protoReader.readBytes();
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, ByteString byteString) throws IOException {
                protoWriter.writeBytes(byteString);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(ByteString byteString) {
                return byteString.size();
            }
        };
    }

    public ProtoAdapter(FieldEncoding fieldEncoding, Class<?> cls) {
        this.fieldEncoding = fieldEncoding;
        this.javaType = cls;
    }

    public static <M extends Message> ProtoAdapter<M> get(M m10) {
        return get(m10.getClass());
    }

    public static <E extends WireEnum> RuntimeEnumAdapter<E> newEnumAdapter(Class<E> cls) {
        return new RuntimeEnumAdapter<>(cls);
    }

    public static <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
        return new MapProtoAdapter(protoAdapter, protoAdapter2);
    }

    public static <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls) {
        return RuntimeMessageAdapter.a(cls);
    }

    public final ProtoAdapter<List<E>> a() {
        FieldEncoding fieldEncoding = this.fieldEncoding;
        FieldEncoding fieldEncoding2 = FieldEncoding.LENGTH_DELIMITED;
        if (fieldEncoding != fieldEncoding2) {
            return new ProtoAdapter<List<E>>(fieldEncoding2, List.class) { // from class: com.czhj.wire.ProtoAdapter.14
                public AnonymousClass14(FieldEncoding fieldEncoding22, Class cls) {
                    super(fieldEncoding22, cls);
                }

                @Override // com.czhj.wire.ProtoAdapter
                public List<E> decode(ProtoReader protoReader) throws IOException {
                    return Collections.singletonList(ProtoAdapter.this.decode(protoReader));
                }

                @Override // com.czhj.wire.ProtoAdapter
                public void encode(ProtoWriter protoWriter, List<E> list) throws IOException {
                    int size = list.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        ProtoAdapter.this.encode(protoWriter, (ProtoWriter) list.get(i10));
                    }
                }

                @Override // com.czhj.wire.ProtoAdapter
                public void encodeWithTag(ProtoWriter protoWriter, int i10, List<E> list) throws IOException {
                    if (list.isEmpty()) {
                        return;
                    }
                    super.encodeWithTag(protoWriter, i10, (int) list);
                }

                @Override // com.czhj.wire.ProtoAdapter
                public int encodedSize(List<E> list) {
                    int size = list.size();
                    int i10 = 0;
                    for (int i11 = 0; i11 < size; i11++) {
                        i10 += ProtoAdapter.this.encodedSize(list.get(i11));
                    }
                    return i10;
                }

                @Override // com.czhj.wire.ProtoAdapter
                public int encodedSizeWithTag(int i10, List<E> list) {
                    if (list.isEmpty()) {
                        return 0;
                    }
                    return super.encodedSizeWithTag(i10, (int) list);
                }

                @Override // com.czhj.wire.ProtoAdapter
                public List<E> redact(List<E> list) {
                    return Collections.emptyList();
                }
            };
        }
        throw new IllegalArgumentException("Unable to pack a length-delimited type.");
    }

    public final ProtoAdapter<List<E>> asPacked() {
        ProtoAdapter<List<E>> protoAdapter = this.packedAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<List<E>> a10 = a();
        this.packedAdapter = a10;
        return a10;
    }

    public final ProtoAdapter<List<E>> asRepeated() {
        ProtoAdapter<List<E>> protoAdapter = this.repeatedAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<List<E>> b10 = b();
        this.repeatedAdapter = b10;
        return b10;
    }

    public final ProtoAdapter<List<E>> b() {
        return new ProtoAdapter<List<E>>(this.fieldEncoding, List.class) { // from class: com.czhj.wire.ProtoAdapter.15
            public AnonymousClass15(FieldEncoding fieldEncoding, Class cls) {
                super(fieldEncoding, cls);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public List<E> decode(ProtoReader protoReader) throws IOException {
                return Collections.singletonList(ProtoAdapter.this.decode(protoReader));
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, List<E> list) {
                throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encodeWithTag(ProtoWriter protoWriter, int i10, List<E> list) throws IOException {
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ProtoAdapter.this.encodeWithTag(protoWriter, i10, list.get(i11));
                }
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(List<E> list) {
                throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSizeWithTag(int i10, List<E> list) {
                int size = list.size();
                int i11 = 0;
                for (int i12 = 0; i12 < size; i12++) {
                    i11 += ProtoAdapter.this.encodedSizeWithTag(i10, list.get(i12));
                }
                return i11;
            }

            @Override // com.czhj.wire.ProtoAdapter
            public List<E> redact(List<E> list) {
                return Collections.emptyList();
            }
        };
    }

    public abstract E decode(ProtoReader protoReader) throws IOException;

    public final E decode(BufferedSource bufferedSource) throws IOException {
        Preconditions.a(bufferedSource, "source == null");
        return decode(new ProtoReader(bufferedSource));
    }

    public abstract void encode(ProtoWriter protoWriter, E e10) throws IOException;

    public final void encode(BufferedSink bufferedSink, E e10) throws IOException {
        Preconditions.a(e10, "value == null");
        Preconditions.a(bufferedSink, "sink == null");
        encode(new ProtoWriter(bufferedSink), (ProtoWriter) e10);
    }

    public void encodeWithTag(ProtoWriter protoWriter, int i10, E e10) throws IOException {
        if (e10 == null) {
            return;
        }
        protoWriter.writeTag(i10, this.fieldEncoding);
        if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
            protoWriter.writeVarint32(encodedSize(e10));
        }
        encode(protoWriter, (ProtoWriter) e10);
    }

    public abstract int encodedSize(E e10);

    public int encodedSizeWithTag(int i10, E e10) {
        if (e10 == null) {
            return 0;
        }
        int encodedSize = encodedSize(e10);
        if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
            encodedSize += ProtoWriter.e(encodedSize);
        }
        return encodedSize + ProtoWriter.d(i10);
    }

    public E redact(E e10) {
        return null;
    }

    public String toString(E e10) {
        return e10.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoAdapter<?> withLabel(WireField.Label label) {
        return label.d() ? label.c() ? asPacked() : asRepeated() : this;
    }

    public static <M> ProtoAdapter<M> get(Class<M> cls) {
        try {
            return (ProtoAdapter) cls.getField("ADAPTER").get(null);
        } catch (Throwable th2) {
            throw new IllegalArgumentException("failed to access " + cls.getName() + "#ADAPTER", th2);
        }
    }

    public final E decode(ByteString byteString) throws IOException {
        Preconditions.a(byteString, "bytes == null");
        return decode(new Buffer().write(byteString));
    }

    public final void encode(OutputStream outputStream, E e10) throws IOException {
        Preconditions.a(e10, "value == null");
        Preconditions.a(outputStream, "stream == null");
        BufferedSink buffer = Okio.buffer(Okio.sink(outputStream));
        encode(buffer, (BufferedSink) e10);
        buffer.emit();
    }

    public static ProtoAdapter<?> get(String str) {
        try {
            int indexOf = str.indexOf(35);
            return (ProtoAdapter) Class.forName(str.substring(0, indexOf)).getField(str.substring(indexOf + 1)).get(null);
        } catch (Throwable th2) {
            throw new IllegalArgumentException("failed to access " + str, th2);
        }
    }

    public final E decode(InputStream inputStream) throws IOException {
        Preconditions.a(inputStream, "stream == null");
        return decode(Okio.buffer(Okio.source(inputStream)));
    }

    public final byte[] encode(E e10) {
        Preconditions.a(e10, "value == null");
        Buffer buffer = new Buffer();
        try {
            encode((BufferedSink) buffer, (Buffer) e10);
            return buffer.readByteArray();
        } catch (IOException e11) {
            throw new AssertionError(e11);
        }
    }

    public final E decode(byte[] bArr) throws IOException {
        Preconditions.a(bArr, "bytes == null");
        return decode(new Buffer().write(bArr));
    }
}
