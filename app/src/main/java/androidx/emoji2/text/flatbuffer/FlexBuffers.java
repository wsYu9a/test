package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import kotlin.UShort;
import kotlin.text.Typography;
import l5.c;

/* loaded from: classes.dex */
public class FlexBuffers {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ReadBuf EMPTY_BB = new ArrayReadWriteBuf(new byte[]{0}, 1);
    public static final int FBT_BLOB = 25;
    public static final int FBT_BOOL = 26;
    public static final int FBT_FLOAT = 3;
    public static final int FBT_INDIRECT_FLOAT = 8;
    public static final int FBT_INDIRECT_INT = 6;
    public static final int FBT_INDIRECT_UINT = 7;
    public static final int FBT_INT = 1;
    public static final int FBT_KEY = 4;
    public static final int FBT_MAP = 9;
    public static final int FBT_NULL = 0;
    public static final int FBT_STRING = 5;
    public static final int FBT_UINT = 2;
    public static final int FBT_VECTOR = 10;
    public static final int FBT_VECTOR_BOOL = 36;
    public static final int FBT_VECTOR_FLOAT = 13;
    public static final int FBT_VECTOR_FLOAT2 = 18;
    public static final int FBT_VECTOR_FLOAT3 = 21;
    public static final int FBT_VECTOR_FLOAT4 = 24;
    public static final int FBT_VECTOR_INT = 11;
    public static final int FBT_VECTOR_INT2 = 16;
    public static final int FBT_VECTOR_INT3 = 19;
    public static final int FBT_VECTOR_INT4 = 22;
    public static final int FBT_VECTOR_KEY = 14;
    public static final int FBT_VECTOR_STRING_DEPRECATED = 15;
    public static final int FBT_VECTOR_UINT = 12;
    public static final int FBT_VECTOR_UINT2 = 17;
    public static final int FBT_VECTOR_UINT3 = 20;
    public static final int FBT_VECTOR_UINT4 = 23;

    public static class Blob extends Sized {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final Blob EMPTY = new Blob(FlexBuffers.EMPTY_BB, 1, 1);

        public Blob(ReadBuf readBuf, int i10, int i11) {
            super(readBuf, i10, i11);
        }

        public static Blob empty() {
            return EMPTY;
        }

        public ByteBuffer data() {
            ByteBuffer wrap = ByteBuffer.wrap(this.f364bb.data());
            wrap.position(this.end);
            wrap.limit(this.end + size());
            return wrap.asReadOnlyBuffer().slice();
        }

        public byte get(int i10) {
            return this.f364bb.get(this.end + i10);
        }

        public byte[] getBytes() {
            int size = size();
            byte[] bArr = new byte[size];
            for (int i10 = 0; i10 < size; i10++) {
                bArr[i10] = this.f364bb.get(this.end + i10);
            }
            return bArr;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            return this.f364bb.getString(this.end, size());
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb2) {
            sb2.append(Typography.quote);
            sb2.append(this.f364bb.getString(this.end, size()));
            sb2.append(Typography.quote);
            return sb2;
        }
    }

    public static class FlexBufferException extends RuntimeException {
        public FlexBufferException(String str) {
            super(str);
        }
    }

    public static class Key extends Object {
        private static final Key EMPTY = new Key(FlexBuffers.EMPTY_BB, 0, 0);

        public Key(ReadBuf readBuf, int i10, int i11) {
            super(readBuf, i10, i11);
        }

        public static Key empty() {
            return EMPTY;
        }

        public int compareTo(byte[] bArr) {
            byte b10;
            byte b11;
            int i10 = this.end;
            int i11 = 0;
            do {
                b10 = this.f364bb.get(i10);
                b11 = bArr[i11];
                if (b10 == 0) {
                    return b10 - b11;
                }
                i10++;
                i11++;
                if (i11 == bArr.length) {
                    return b10 - b11;
                }
            } while (b10 == b11);
            return b10 - b11;
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return key.end == this.end && key.byteWidth == this.byteWidth;
        }

        public int hashCode() {
            return this.end ^ this.byteWidth;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb2) {
            sb2.append(toString());
            return sb2;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            int i10 = this.end;
            while (this.f364bb.get(i10) != 0) {
                i10++;
            }
            int i11 = this.end;
            return this.f364bb.getString(i11, i10 - i11);
        }
    }

    public static class KeyVector {
        private final TypedVector vec;

        public KeyVector(TypedVector typedVector) {
            this.vec = typedVector;
        }

        public Key get(int i10) {
            if (i10 >= size()) {
                return Key.EMPTY;
            }
            TypedVector typedVector = this.vec;
            int i11 = typedVector.end + (i10 * typedVector.byteWidth);
            TypedVector typedVector2 = this.vec;
            ReadBuf readBuf = typedVector2.f364bb;
            return new Key(readBuf, FlexBuffers.indirect(readBuf, i11, typedVector2.byteWidth), 1);
        }

        public int size() {
            return this.vec.size();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            for (int i10 = 0; i10 < this.vec.size(); i10++) {
                this.vec.get(i10).toString(sb2);
                if (i10 != this.vec.size() - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    public static class Map extends Vector {
        private static final Map EMPTY_MAP = new Map(FlexBuffers.EMPTY_BB, 1, 1);

        public Map(ReadBuf readBuf, int i10, int i11) {
            super(readBuf, i10, i11);
        }

        private int binarySearch(KeyVector keyVector, byte[] bArr) {
            int size = keyVector.size() - 1;
            int i10 = 0;
            while (i10 <= size) {
                int i11 = (i10 + size) >>> 1;
                int compareTo = keyVector.get(i11).compareTo(bArr);
                if (compareTo < 0) {
                    i10 = i11 + 1;
                } else {
                    if (compareTo <= 0) {
                        return i11;
                    }
                    size = i11 - 1;
                }
            }
            return -(i10 + 1);
        }

        public static Map empty() {
            return EMPTY_MAP;
        }

        public Reference get(String str) {
            return get(str.getBytes(StandardCharsets.UTF_8));
        }

        public KeyVector keys() {
            int i10 = this.end - (this.byteWidth * 3);
            ReadBuf readBuf = this.f364bb;
            int indirect = FlexBuffers.indirect(readBuf, i10, this.byteWidth);
            ReadBuf readBuf2 = this.f364bb;
            int i11 = this.byteWidth;
            return new KeyVector(new TypedVector(readBuf, indirect, FlexBuffers.readInt(readBuf2, i10 + i11, i11), 4));
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector, androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb2) {
            sb2.append("{ ");
            KeyVector keys = keys();
            int size = size();
            Vector values = values();
            for (int i10 = 0; i10 < size; i10++) {
                sb2.append(Typography.quote);
                sb2.append(keys.get(i10).toString());
                sb2.append("\" : ");
                sb2.append(values.get(i10).toString());
                if (i10 != size - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append(" }");
            return sb2;
        }

        public Vector values() {
            return new Vector(this.f364bb, this.end, this.byteWidth);
        }

        public Reference get(byte[] bArr) {
            KeyVector keys = keys();
            int size = keys.size();
            int binarySearch = binarySearch(keys, bArr);
            return (binarySearch < 0 || binarySearch >= size) ? Reference.NULL_REFERENCE : get(binarySearch);
        }
    }

    public static abstract class Object {

        /* renamed from: bb */
        ReadBuf f364bb;
        int byteWidth;
        int end;

        public Object(ReadBuf readBuf, int i10, int i11) {
            this.f364bb = readBuf;
            this.end = i10;
            this.byteWidth = i11;
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        public abstract StringBuilder toString(StringBuilder sb2);
    }

    public static class Reference {
        private static final Reference NULL_REFERENCE = new Reference(FlexBuffers.EMPTY_BB, 0, 1, 0);

        /* renamed from: bb */
        private ReadBuf f365bb;
        private int byteWidth;
        private int end;
        private int parentWidth;
        private int type;

        public Reference(ReadBuf readBuf, int i10, int i11, int i12) {
            this(readBuf, i10, i11, 1 << (i12 & 3), i12 >> 2);
        }

        public Blob asBlob() {
            if (!isBlob() && !isString()) {
                return Blob.empty();
            }
            ReadBuf readBuf = this.f365bb;
            return new Blob(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
        }

        public boolean asBoolean() {
            return isBoolean() ? this.f365bb.get(this.end) != 0 : asUInt() != 0;
        }

        public double asFloat() {
            int i10 = this.type;
            if (i10 == 3) {
                return FlexBuffers.readDouble(this.f365bb, this.end, this.parentWidth);
            }
            if (i10 == 1) {
                return FlexBuffers.readInt(this.f365bb, this.end, this.parentWidth);
            }
            if (i10 != 2) {
                if (i10 == 5) {
                    return Double.parseDouble(asString());
                }
                if (i10 == 6) {
                    ReadBuf readBuf = this.f365bb;
                    return FlexBuffers.readInt(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
                }
                if (i10 == 7) {
                    ReadBuf readBuf2 = this.f365bb;
                    return FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth);
                }
                if (i10 == 8) {
                    ReadBuf readBuf3 = this.f365bb;
                    return FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth);
                }
                if (i10 == 10) {
                    return asVector().size();
                }
                if (i10 != 26) {
                    return c.f27899e;
                }
            }
            return FlexBuffers.readUInt(this.f365bb, this.end, this.parentWidth);
        }

        public int asInt() {
            long readUInt;
            int i10 = this.type;
            if (i10 == 1) {
                return FlexBuffers.readInt(this.f365bb, this.end, this.parentWidth);
            }
            if (i10 == 2) {
                readUInt = FlexBuffers.readUInt(this.f365bb, this.end, this.parentWidth);
            } else {
                if (i10 == 3) {
                    return (int) FlexBuffers.readDouble(this.f365bb, this.end, this.parentWidth);
                }
                if (i10 == 5) {
                    return Integer.parseInt(asString());
                }
                if (i10 == 6) {
                    ReadBuf readBuf = this.f365bb;
                    return FlexBuffers.readInt(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
                }
                if (i10 != 7) {
                    if (i10 == 8) {
                        ReadBuf readBuf2 = this.f365bb;
                        return (int) FlexBuffers.readDouble(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth);
                    }
                    if (i10 == 10) {
                        return asVector().size();
                    }
                    if (i10 != 26) {
                        return 0;
                    }
                    return FlexBuffers.readInt(this.f365bb, this.end, this.parentWidth);
                }
                ReadBuf readBuf3 = this.f365bb;
                readUInt = FlexBuffers.readUInt(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.parentWidth);
            }
            return (int) readUInt;
        }

        public Key asKey() {
            if (!isKey()) {
                return Key.empty();
            }
            ReadBuf readBuf = this.f365bb;
            return new Key(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
        }

        public long asLong() {
            int i10 = this.type;
            if (i10 == 1) {
                return FlexBuffers.readLong(this.f365bb, this.end, this.parentWidth);
            }
            if (i10 == 2) {
                return FlexBuffers.readUInt(this.f365bb, this.end, this.parentWidth);
            }
            if (i10 == 3) {
                return (long) FlexBuffers.readDouble(this.f365bb, this.end, this.parentWidth);
            }
            if (i10 == 5) {
                try {
                    return Long.parseLong(asString());
                } catch (NumberFormatException unused) {
                    return 0L;
                }
            }
            if (i10 == 6) {
                ReadBuf readBuf = this.f365bb;
                return FlexBuffers.readLong(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            if (i10 == 7) {
                ReadBuf readBuf2 = this.f365bb;
                return FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.parentWidth);
            }
            if (i10 == 8) {
                ReadBuf readBuf3 = this.f365bb;
                return (long) FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth);
            }
            if (i10 == 10) {
                return asVector().size();
            }
            if (i10 != 26) {
                return 0L;
            }
            return FlexBuffers.readInt(this.f365bb, this.end, this.parentWidth);
        }

        public Map asMap() {
            if (!isMap()) {
                return Map.empty();
            }
            ReadBuf readBuf = this.f365bb;
            return new Map(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
        }

        public String asString() {
            if (isString()) {
                int indirect = FlexBuffers.indirect(this.f365bb, this.end, this.parentWidth);
                ReadBuf readBuf = this.f365bb;
                int i10 = this.byteWidth;
                return this.f365bb.getString(indirect, (int) FlexBuffers.readUInt(readBuf, indirect - i10, i10));
            }
            if (!isKey()) {
                return "";
            }
            int indirect2 = FlexBuffers.indirect(this.f365bb, this.end, this.byteWidth);
            int i11 = indirect2;
            while (this.f365bb.get(i11) != 0) {
                i11++;
            }
            return this.f365bb.getString(indirect2, i11 - indirect2);
        }

        public long asUInt() {
            int i10 = this.type;
            if (i10 == 2) {
                return FlexBuffers.readUInt(this.f365bb, this.end, this.parentWidth);
            }
            if (i10 == 1) {
                return FlexBuffers.readLong(this.f365bb, this.end, this.parentWidth);
            }
            if (i10 == 3) {
                return (long) FlexBuffers.readDouble(this.f365bb, this.end, this.parentWidth);
            }
            if (i10 == 10) {
                return asVector().size();
            }
            if (i10 == 26) {
                return FlexBuffers.readInt(this.f365bb, this.end, this.parentWidth);
            }
            if (i10 == 5) {
                return Long.parseLong(asString());
            }
            if (i10 == 6) {
                ReadBuf readBuf = this.f365bb;
                return FlexBuffers.readLong(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            if (i10 == 7) {
                ReadBuf readBuf2 = this.f365bb;
                return FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth);
            }
            if (i10 != 8) {
                return 0L;
            }
            ReadBuf readBuf3 = this.f365bb;
            return (long) FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.parentWidth);
        }

        public Vector asVector() {
            if (isVector()) {
                ReadBuf readBuf = this.f365bb;
                return new Vector(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            int i10 = this.type;
            if (i10 == 15) {
                ReadBuf readBuf2 = this.f365bb;
                return new TypedVector(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth, 4);
            }
            if (!FlexBuffers.isTypedVector(i10)) {
                return Vector.empty();
            }
            ReadBuf readBuf3 = this.f365bb;
            return new TypedVector(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth, FlexBuffers.toTypedVectorElementType(this.type));
        }

        public int getType() {
            return this.type;
        }

        public boolean isBlob() {
            return this.type == 25;
        }

        public boolean isBoolean() {
            return this.type == 26;
        }

        public boolean isFloat() {
            int i10 = this.type;
            return i10 == 3 || i10 == 8;
        }

        public boolean isInt() {
            int i10 = this.type;
            return i10 == 1 || i10 == 6;
        }

        public boolean isIntOrUInt() {
            return isInt() || isUInt();
        }

        public boolean isKey() {
            return this.type == 4;
        }

        public boolean isMap() {
            return this.type == 9;
        }

        public boolean isNull() {
            return this.type == 0;
        }

        public boolean isNumeric() {
            return isIntOrUInt() || isFloat();
        }

        public boolean isString() {
            return this.type == 5;
        }

        public boolean isTypedVector() {
            return FlexBuffers.isTypedVector(this.type);
        }

        public boolean isUInt() {
            int i10 = this.type;
            return i10 == 2 || i10 == 7;
        }

        public boolean isVector() {
            int i10 = this.type;
            return i10 == 10 || i10 == 9;
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        public Reference(ReadBuf readBuf, int i10, int i11, int i12, int i13) {
            this.f365bb = readBuf;
            this.end = i10;
            this.parentWidth = i11;
            this.byteWidth = i12;
            this.type = i13;
        }

        public StringBuilder toString(StringBuilder sb2) {
            int i10 = this.type;
            if (i10 != 36) {
                switch (i10) {
                    case 0:
                        sb2.append("null");
                        return sb2;
                    case 1:
                    case 6:
                        sb2.append(asLong());
                        return sb2;
                    case 2:
                    case 7:
                        sb2.append(asUInt());
                        return sb2;
                    case 3:
                    case 8:
                        sb2.append(asFloat());
                        return sb2;
                    case 4:
                        Key asKey = asKey();
                        sb2.append(Typography.quote);
                        StringBuilder key = asKey.toString(sb2);
                        key.append(Typography.quote);
                        return key;
                    case 5:
                        sb2.append(Typography.quote);
                        sb2.append(asString());
                        sb2.append(Typography.quote);
                        return sb2;
                    case 9:
                        return asMap().toString(sb2);
                    case 10:
                        return asVector().toString(sb2);
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        throw new FlexBufferException("not_implemented:" + this.type);
                    case 25:
                        return asBlob().toString(sb2);
                    case 26:
                        sb2.append(asBoolean());
                        return sb2;
                    default:
                        return sb2;
                }
            }
            sb2.append(asVector());
            return sb2;
        }
    }

    public static abstract class Sized extends Object {
        protected final int size;

        public Sized(ReadBuf readBuf, int i10, int i11) {
            super(readBuf, i10, i11);
            this.size = FlexBuffers.readInt(this.f364bb, i10 - i11, i11);
        }

        public int size() {
            return this.size;
        }
    }

    public static class TypedVector extends Vector {
        private static final TypedVector EMPTY_VECTOR = new TypedVector(FlexBuffers.EMPTY_BB, 1, 1, 1);
        private final int elemType;

        public TypedVector(ReadBuf readBuf, int i10, int i11, int i12) {
            super(readBuf, i10, i11);
            this.elemType = i12;
        }

        public static TypedVector empty() {
            return EMPTY_VECTOR;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector
        public Reference get(int i10) {
            if (i10 >= size()) {
                return Reference.NULL_REFERENCE;
            }
            return new Reference(this.f364bb, this.end + (i10 * this.byteWidth), this.byteWidth, 1, this.elemType);
        }

        public int getElemType() {
            return this.elemType;
        }

        public boolean isEmptyVector() {
            return this == EMPTY_VECTOR;
        }
    }

    public static class Unsigned {
        public static int byteToUnsignedInt(byte b10) {
            return b10 & 255;
        }

        public static long intToUnsignedLong(int i10) {
            return i10 & 4294967295L;
        }

        public static int shortToUnsignedInt(short s10) {
            return s10 & UShort.MAX_VALUE;
        }
    }

    public static class Vector extends Sized {
        private static final Vector EMPTY_VECTOR = new Vector(FlexBuffers.EMPTY_BB, 1, 1);

        public Vector(ReadBuf readBuf, int i10, int i11) {
            super(readBuf, i10, i11);
        }

        public static Vector empty() {
            return EMPTY_VECTOR;
        }

        public Reference get(int i10) {
            long size = size();
            long j10 = i10;
            if (j10 >= size) {
                return Reference.NULL_REFERENCE;
            }
            return new Reference(this.f364bb, this.end + (i10 * this.byteWidth), this.byteWidth, Unsigned.byteToUnsignedInt(this.f364bb.get((int) (this.end + (size * this.byteWidth) + j10))));
        }

        public boolean isEmpty() {
            return this == EMPTY_VECTOR;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb2) {
            sb2.append("[ ");
            int size = size();
            for (int i10 = 0; i10 < size; i10++) {
                get(i10).toString(sb2);
                if (i10 != size - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append(" ]");
            return sb2;
        }
    }

    @Deprecated
    public static Reference getRoot(ByteBuffer byteBuffer) {
        return getRoot(byteBuffer.hasArray() ? new ArrayReadWriteBuf(byteBuffer.array(), byteBuffer.limit()) : new ByteBufferReadWriteBuf(byteBuffer));
    }

    public static int indirect(ReadBuf readBuf, int i10, int i11) {
        return (int) (i10 - readUInt(readBuf, i10, i11));
    }

    public static boolean isTypeInline(int i10) {
        return i10 <= 3 || i10 == 26;
    }

    public static boolean isTypedVector(int i10) {
        return (i10 >= 11 && i10 <= 15) || i10 == 36;
    }

    public static boolean isTypedVectorElementType(int i10) {
        return (i10 >= 1 && i10 <= 4) || i10 == 26;
    }

    public static double readDouble(ReadBuf readBuf, int i10, int i11) {
        if (i11 == 4) {
            return readBuf.getFloat(i10);
        }
        if (i11 != 8) {
            return -1.0d;
        }
        return readBuf.getDouble(i10);
    }

    public static int readInt(ReadBuf readBuf, int i10, int i11) {
        return (int) readLong(readBuf, i10, i11);
    }

    public static long readLong(ReadBuf readBuf, int i10, int i11) {
        int i12;
        if (i11 == 1) {
            i12 = readBuf.get(i10);
        } else if (i11 == 2) {
            i12 = readBuf.getShort(i10);
        } else {
            if (i11 != 4) {
                if (i11 != 8) {
                    return -1L;
                }
                return readBuf.getLong(i10);
            }
            i12 = readBuf.getInt(i10);
        }
        return i12;
    }

    public static long readUInt(ReadBuf readBuf, int i10, int i11) {
        if (i11 == 1) {
            return Unsigned.byteToUnsignedInt(readBuf.get(i10));
        }
        if (i11 == 2) {
            return Unsigned.shortToUnsignedInt(readBuf.getShort(i10));
        }
        if (i11 == 4) {
            return Unsigned.intToUnsignedLong(readBuf.getInt(i10));
        }
        if (i11 != 8) {
            return -1L;
        }
        return readBuf.getLong(i10);
    }

    public static int toTypedVector(int i10, int i11) {
        if (i11 == 0) {
            return i10 + 10;
        }
        if (i11 == 2) {
            return i10 + 15;
        }
        if (i11 == 3) {
            return i10 + 18;
        }
        if (i11 != 4) {
            return 0;
        }
        return i10 + 21;
    }

    public static int toTypedVectorElementType(int i10) {
        return i10 - 10;
    }

    public static Reference getRoot(ReadBuf readBuf) {
        int limit = readBuf.limit();
        byte b10 = readBuf.get(limit - 1);
        int i10 = limit - 2;
        return new Reference(readBuf, i10 - b10, b10, Unsigned.byteToUnsignedInt(readBuf.get(i10)));
    }
}
