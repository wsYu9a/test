package okio;

import com.cdo.oaps.ad.OapsKey;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import f.b.a.d;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u000b\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0018B!\b\u0002\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000e\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u00020\t8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000e8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00058V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lokio/Options;", "Lkotlin/collections/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "index", MonitorConstants.CONNECT_TYPE_GET, "(I)Lokio/ByteString;", "", "trie", "[I", "getTrie$okio", "()[I", "", "byteStrings", "[Lokio/ByteString;", "getByteStrings$okio", "()[Lokio/ByteString;", "getSize", "()I", OapsKey.KEY_SIZE, "<init>", "([Lokio/ByteString;[I)V", "Companion", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @d
    private final ByteString[] byteStrings;

    @d
    private final int[] trie;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J[\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0013\u001a\u00020\u00122\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0011\"\u00020\tH\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u0002*\u00020\u00048B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lokio/Options$Companion;", "", "", "nodeOffset", "Lokio/Buffer;", "node", "", "byteStringOffset", "", "Lokio/ByteString;", "byteStrings", "fromIndex", "toIndex", "indexes", "", "buildTrieRecursive", "(JLokio/Buffer;ILjava/util/List;IILjava/util/List;)V", "", "Lokio/Options;", "of", "([Lokio/ByteString;)Lokio/Options;", "getIntCount", "(Lokio/Buffer;)J", "intCount", "<init>", "()V", "okio"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        private final void buildTrieRecursive(long nodeOffset, Buffer node, int byteStringOffset, List<? extends ByteString> byteStrings, int fromIndex, int toIndex, List<Integer> indexes) {
            int i2;
            int i3;
            int i4;
            int i5;
            Buffer buffer;
            int i6 = byteStringOffset;
            if (!(fromIndex < toIndex)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            for (int i7 = fromIndex; i7 < toIndex; i7++) {
                if (!(byteStrings.get(i7).size() >= i6)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            ByteString byteString = byteStrings.get(fromIndex);
            ByteString byteString2 = byteStrings.get(toIndex - 1);
            if (i6 == byteString.size()) {
                int intValue = indexes.get(fromIndex).intValue();
                int i8 = fromIndex + 1;
                ByteString byteString3 = byteStrings.get(i8);
                i2 = i8;
                i3 = intValue;
                byteString = byteString3;
            } else {
                i2 = fromIndex;
                i3 = -1;
            }
            if (byteString.getByte(i6) == byteString2.getByte(i6)) {
                int min = Math.min(byteString.size(), byteString2.size());
                int i9 = 0;
                for (int i10 = i6; i10 < min && byteString.getByte(i10) == byteString2.getByte(i10); i10++) {
                    i9++;
                }
                long intCount = nodeOffset + getIntCount(node) + 2 + i9 + 1;
                node.writeInt(-i9);
                node.writeInt(i3);
                int i11 = i6 + i9;
                while (i6 < i11) {
                    node.writeInt(byteString.getByte(i6) & 255);
                    i6++;
                }
                if (i2 + 1 == toIndex) {
                    if (!(i11 == byteStrings.get(i2).size())) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    node.writeInt(indexes.get(i2).intValue());
                    return;
                } else {
                    Buffer buffer2 = new Buffer();
                    node.writeInt(((int) (getIntCount(buffer2) + intCount)) * (-1));
                    buildTrieRecursive(intCount, buffer2, i11, byteStrings, i2, toIndex, indexes);
                    node.writeAll(buffer2);
                    return;
                }
            }
            int i12 = 1;
            for (int i13 = i2 + 1; i13 < toIndex; i13++) {
                if (byteStrings.get(i13 - 1).getByte(i6) != byteStrings.get(i13).getByte(i6)) {
                    i12++;
                }
            }
            long intCount2 = nodeOffset + getIntCount(node) + 2 + (i12 * 2);
            node.writeInt(i12);
            node.writeInt(i3);
            for (int i14 = i2; i14 < toIndex; i14++) {
                byte b2 = byteStrings.get(i14).getByte(i6);
                if (i14 == i2 || b2 != byteStrings.get(i14 - 1).getByte(i6)) {
                    node.writeInt(b2 & 255);
                }
            }
            Buffer buffer3 = new Buffer();
            while (i2 < toIndex) {
                byte b3 = byteStrings.get(i2).getByte(i6);
                int i15 = i2 + 1;
                int i16 = i15;
                while (true) {
                    if (i16 >= toIndex) {
                        i4 = toIndex;
                        break;
                    } else {
                        if (b3 != byteStrings.get(i16).getByte(i6)) {
                            i4 = i16;
                            break;
                        }
                        i16++;
                    }
                }
                if (i15 == i4 && i6 + 1 == byteStrings.get(i2).size()) {
                    node.writeInt(indexes.get(i2).intValue());
                    i5 = i4;
                    buffer = buffer3;
                } else {
                    node.writeInt(((int) (intCount2 + getIntCount(buffer3))) * (-1));
                    i5 = i4;
                    buffer = buffer3;
                    buildTrieRecursive(intCount2, buffer3, i6 + 1, byteStrings, i2, i4, indexes);
                }
                buffer3 = buffer;
                i2 = i5;
            }
            node.writeAll(buffer3);
        }

        static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j2, Buffer buffer, int i2, List list, int i3, int i4, List list2, int i5, Object obj) {
            companion.buildTrieRecursive((i5 & 1) != 0 ? 0L : j2, buffer, (i5 & 4) != 0 ? 0 : i2, list, (i5 & 16) != 0 ? 0 : i3, (i5 & 32) != 0 ? list.size() : i4, list2);
        }

        private final long getIntCount(@d Buffer buffer) {
            return buffer.size() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x00ee, code lost:
        
            continue;
         */
        @f.b.a.d
        @kotlin.jvm.JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final okio.Options of(@f.b.a.d okio.ByteString... r17) {
            /*
                Method dump skipped, instructions count: 338
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.Options.Companion.of(okio.ByteString[]):okio.Options");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }

    @d
    @JvmStatic
    public static final Options of(@d ByteString... byteStringArr) {
        return INSTANCE.of(byteStringArr);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    @d
    /* renamed from: getByteStrings$okio, reason: from getter */
    public final ByteString[] getByteStrings() {
        return this.byteStrings;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int get_size() {
        return this.byteStrings.length;
    }

    @d
    /* renamed from: getTrie$okio, reason: from getter */
    public final int[] getTrie() {
        return this.trie;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains((Object) byteString);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    @d
    public ByteString get(int i2) {
        return this.byteStrings[i2];
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf((Object) byteString);
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf((Object) byteString);
    }
}
