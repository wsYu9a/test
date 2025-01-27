package okhttp3.internal.http2;

import b5.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lokhttp3/internal/http2/Huffman;", "", "()V", "CODES", "", "CODE_BIT_COUNTS", "", "root", "Lokhttp3/internal/http2/Huffman$Node;", "addCode", "", "symbol", "", "code", "codeBitCount", "decode", "source", "Lokio/BufferedSource;", "byteCount", "", "sink", "Lokio/BufferedSink;", "encode", "Lokio/ByteString;", "encodedLength", "bytes", "Node", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Huffman {

    @k
    private static final byte[] CODE_BIT_COUNTS;

    @k
    private static final Node root;

    @k
    public static final Huffman INSTANCE = new Huffman();

    @k
    private static final int[] CODES = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, TinkerReport.KEY_LOADED_EXCEPTION_DEX, TTDownloadField.CALL_DOWNLOAD_MODEL_SHOULD_DOWNLOAD_WITH_PATCH_APPLY, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_EXECUTOR_GROUP, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_FUNNEL_TYPE, 40, 41, 42, 7, 43, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_START_TOAST, 44, 8, 9, 45, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_SDK_MONITOR_SCENE, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    static {
        byte[] bArr = {13, a.A, a.F, a.F, a.F, a.F, a.F, a.F, a.F, a.B, a.H, a.F, a.F, a.H, a.F, a.F, a.F, a.F, a.F, a.F, a.F, a.F, a.H, a.F, a.F, a.F, a.F, a.F, a.F, a.F, a.F, a.F, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, a.F, a.f1197x, a.f1199z, a.f1197x, a.f1197x, a.f1199z, a.f1199z, a.f1199z, a.A, a.f1199z, a.A, a.A, a.A, a.A, a.A, a.B, a.A, a.B, a.B, a.f1199z, a.A, a.B, a.A, a.A, a.A, a.A, a.f1198y, a.f1199z, a.A, a.f1199z, a.A, a.A, a.B, a.f1199z, a.f1198y, a.f1197x, a.f1199z, a.f1199z, a.A, a.A, a.f1198y, a.A, a.f1199z, a.f1199z, a.B, a.f1198y, a.f1199z, a.A, a.A, a.f1198y, a.f1198y, a.f1199z, a.f1198y, a.A, a.f1199z, a.A, a.A, a.f1197x, a.f1199z, a.f1199z, a.f1199z, a.A, a.f1199z, a.f1199z, a.A, a.D, a.D, a.f1197x, 19, a.f1199z, a.A, a.f1199z, a.C, a.D, a.D, a.D, a.E, a.E, a.D, a.B, a.C, 19, a.f1198y, a.D, a.E, a.E, a.D, a.E, a.B, a.f1198y, a.f1198y, a.D, a.D, a.F, a.E, a.E, a.E, a.f1197x, a.B, a.f1197x, a.f1198y, a.f1199z, a.f1198y, a.f1198y, a.A, a.f1199z, a.f1199z, a.C, a.C, a.B, a.B, a.D, a.A, a.D, a.E, a.D, a.D, a.E, a.E, a.E, a.E, a.E, a.F, a.E, a.E, a.E, a.E, a.E, a.D};
        CODE_BIT_COUNTS = bArr;
        root = new Node();
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            INSTANCE.addCode(i10, CODES[i10], CODE_BIT_COUNTS[i10]);
        }
    }

    private Huffman() {
    }

    private final void addCode(int symbol, int code, int codeBitCount) {
        Node node = new Node(symbol, codeBitCount);
        Node node2 = root;
        while (codeBitCount > 8) {
            codeBitCount -= 8;
            int i10 = (code >>> codeBitCount) & 255;
            Node[] children = node2.getChildren();
            Intrinsics.checkNotNull(children);
            Node node3 = children[i10];
            if (node3 == null) {
                node3 = new Node();
                children[i10] = node3;
            }
            node2 = node3;
        }
        int i11 = 8 - codeBitCount;
        int i12 = (code << i11) & 255;
        Node[] children2 = node2.getChildren();
        Intrinsics.checkNotNull(children2);
        ArraysKt.fill(children2, node, i12, (1 << i11) + i12);
    }

    public final void decode(@k BufferedSource source, long byteCount, @k BufferedSink sink) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        Node node = root;
        int i10 = 0;
        long j10 = 0;
        int i11 = 0;
        while (j10 < byteCount) {
            j10++;
            i10 = (i10 << 8) | Util.and(source.readByte(), 255);
            i11 += 8;
            while (i11 >= 8) {
                Node[] children = node.getChildren();
                Intrinsics.checkNotNull(children);
                node = children[(i10 >>> (i11 - 8)) & 255];
                Intrinsics.checkNotNull(node);
                if (node.getChildren() == null) {
                    sink.writeByte(node.getSymbol());
                    i11 -= node.getTerminalBitCount();
                    node = root;
                } else {
                    i11 -= 8;
                }
            }
        }
        while (i11 > 0) {
            Node[] children2 = node.getChildren();
            Intrinsics.checkNotNull(children2);
            Node node2 = children2[(i10 << (8 - i11)) & 255];
            Intrinsics.checkNotNull(node2);
            if (node2.getChildren() != null || node2.getTerminalBitCount() > i11) {
                return;
            }
            sink.writeByte(node2.getSymbol());
            i11 -= node2.getTerminalBitCount();
            node = root;
        }
    }

    public final void encode(@k ByteString source, @k BufferedSink sink) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        int size = source.size();
        long j10 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            int i12 = i10 + 1;
            int and = Util.and(source.getByte(i10), 255);
            int i13 = CODES[and];
            byte b10 = CODE_BIT_COUNTS[and];
            j10 = (j10 << b10) | i13;
            i11 += b10;
            while (i11 >= 8) {
                i11 -= 8;
                sink.writeByte((int) (j10 >> i11));
            }
            i10 = i12;
        }
        if (i11 > 0) {
            sink.writeByte((int) ((j10 << (8 - i11)) | (255 >>> i11)));
        }
    }

    public final int encodedLength(@k ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        long j10 = 0;
        for (int i10 = 0; i10 < bytes.size(); i10++) {
            j10 += CODE_BIT_COUNTS[Util.and(bytes.getByte(i10), 255)];
        }
        return (int) ((j10 + 7) >> 3);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u001d\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/http2/Huffman$Node;", "", "()V", "symbol", "", "bits", "(II)V", "children", "", "getChildren", "()[Lokhttp3/internal/http2/Huffman$Node;", "[Lokhttp3/internal/http2/Huffman$Node;", "getSymbol", "()I", "terminalBitCount", "getTerminalBitCount", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Node {

        @l
        private final Node[] children;
        private final int symbol;
        private final int terminalBitCount;

        public Node() {
            this.children = new Node[256];
            this.symbol = 0;
            this.terminalBitCount = 0;
        }

        @l
        public final Node[] getChildren() {
            return this.children;
        }

        public final int getSymbol() {
            return this.symbol;
        }

        public final int getTerminalBitCount() {
            return this.terminalBitCount;
        }

        public Node(int i10, int i11) {
            this.children = null;
            this.symbol = i10;
            int i12 = i11 & 7;
            this.terminalBitCount = i12 == 0 ? 8 : i12;
        }
    }
}
