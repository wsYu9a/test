package okio;

import com.baidu.mobads.sdk.internal.bu;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.cdo.oaps.ad.OapsKey;
import com.kwad.sdk.api.model.AdnName;
import com.martian.mibook.application.MiConfigSingleton;
import com.oplus.quickgame.sdk.hall.Constant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import f.b.a.d;
import f.b.a.e;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import okio.internal.ByteStringKt;
import org.mozilla.universalchardet.prober.g;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0018\b\u0016\u0018\u0000 r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001rB\u0011\b\u0000\u0012\u0006\u0010i\u001a\u000209¢\u0006\u0004\bp\u0010qJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0015J\u0017\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\fH\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0016¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010!\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0016¢\u0006\u0004\b!\u0010\u001fJ\u001f\u0010$\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0000H\u0010¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020\fH\u0016¢\u0006\u0004\b%\u0010\u000eJ\u000f\u0010&\u001a\u00020\fH\u0016¢\u0006\u0004\b&\u0010\u000eJ\u000f\u0010'\u001a\u00020\u0000H\u0016¢\u0006\u0004\b'\u0010\u0015J\u000f\u0010(\u001a\u00020\u0000H\u0016¢\u0006\u0004\b(\u0010\u0015J#\u0010,\u001a\u00020\u00002\b\b\u0002\u0010*\u001a\u00020)2\b\b\u0002\u0010+\u001a\u00020)H\u0017¢\u0006\u0004\b,\u0010-J\u0017\u00102\u001a\u00020/2\u0006\u0010.\u001a\u00020)H\u0010¢\u0006\u0004\b0\u00101J\u0018\u00105\u001a\u00020/2\u0006\u00103\u001a\u00020)H\u0087\u0002¢\u0006\u0004\b4\u00101J\u000f\u00108\u001a\u00020)H\u0010¢\u0006\u0004\b6\u00107J\u000f\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010=\u001a\u000209H\u0010¢\u0006\u0004\b<\u0010;J\u000f\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020AH\u0016¢\u0006\u0004\bB\u0010CJ'\u0010B\u001a\u00020\u00052\u0006\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020)2\u0006\u0010G\u001a\u00020)H\u0010¢\u0006\u0004\bH\u0010IJ/\u0010M\u001a\u00020L2\u0006\u0010F\u001a\u00020)2\u0006\u0010J\u001a\u00020\u00002\u0006\u0010K\u001a\u00020)2\u0006\u0010G\u001a\u00020)H\u0016¢\u0006\u0004\bM\u0010NJ/\u0010M\u001a\u00020L2\u0006\u0010F\u001a\u00020)2\u0006\u0010J\u001a\u0002092\u0006\u0010K\u001a\u00020)2\u0006\u0010G\u001a\u00020)H\u0016¢\u0006\u0004\bM\u0010OJ\u0015\u0010Q\u001a\u00020L2\u0006\u0010P\u001a\u00020\u0000¢\u0006\u0004\bQ\u0010RJ\u0015\u0010Q\u001a\u00020L2\u0006\u0010P\u001a\u000209¢\u0006\u0004\bQ\u0010SJ\u0015\u0010U\u001a\u00020L2\u0006\u0010T\u001a\u00020\u0000¢\u0006\u0004\bU\u0010RJ\u0015\u0010U\u001a\u00020L2\u0006\u0010T\u001a\u000209¢\u0006\u0004\bU\u0010SJ!\u0010W\u001a\u00020)2\u0006\u0010J\u001a\u00020\u00002\b\b\u0002\u0010V\u001a\u00020)H\u0007¢\u0006\u0004\bW\u0010XJ!\u0010W\u001a\u00020)2\u0006\u0010J\u001a\u0002092\b\b\u0002\u0010V\u001a\u00020)H\u0017¢\u0006\u0004\bW\u0010YJ!\u0010Z\u001a\u00020)2\u0006\u0010J\u001a\u00020\u00002\b\b\u0002\u0010V\u001a\u00020)H\u0007¢\u0006\u0004\bZ\u0010XJ!\u0010Z\u001a\u00020)2\u0006\u0010J\u001a\u0002092\b\b\u0002\u0010V\u001a\u00020)H\u0017¢\u0006\u0004\bZ\u0010YJ\u001a\u0010\\\u001a\u00020L2\b\u0010J\u001a\u0004\u0018\u00010[H\u0096\u0002¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020)H\u0016¢\u0006\u0004\b^\u00107J\u0018\u0010_\u001a\u00020)2\u0006\u0010J\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b_\u0010`J\u000f\u0010a\u001a\u00020\fH\u0016¢\u0006\u0004\ba\u0010\u000eJ\u0017\u00104\u001a\u00020/2\u0006\u00103\u001a\u00020)H\u0007¢\u0006\u0004\bb\u00101J\u000f\u0010d\u001a\u00020)H\u0007¢\u0006\u0004\bc\u00107R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\r\u0010e\u001a\u0004\bf\u0010\u000e\"\u0004\bg\u0010hR\u001c\u0010i\u001a\u0002098\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010;R\u0013\u0010d\u001a\u00020)8G@\u0006¢\u0006\u0006\u001a\u0004\bd\u00107R\"\u0010^\u001a\u00020)8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b^\u0010l\u001a\u0004\bm\u00107\"\u0004\bn\u0010o¨\u0006s"}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "Ljava/io/ObjectInputStream;", "in", "", "readObject", "(Ljava/io/ObjectInputStream;)V", "Ljava/io/ObjectOutputStream;", "out", "writeObject", "(Ljava/io/ObjectOutputStream;)V", "", "utf8", "()Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "string", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "base64", "md5", "()Lokio/ByteString;", "sha1", "sha256", "sha512", Constant.Param.ALGORITHM, "digest$okio", "(Ljava/lang/String;)Lokio/ByteString;", "digest", "key", "hmacSha1", "(Lokio/ByteString;)Lokio/ByteString;", "hmacSha256", "hmacSha512", "hmac$okio", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "hmac", "base64Url", "hex", "toAsciiLowercase", "toAsciiUppercase", "", "beginIndex", "endIndex", "substring", "(II)Lokio/ByteString;", "pos", "", "internalGet$okio", "(I)B", "internalGet", "index", "getByte", MonitorConstants.CONNECT_TYPE_GET, "getSize$okio", "()I", "getSize", "", "toByteArray", "()[B", "internalArray$okio", "internalArray", "Ljava/nio/ByteBuffer;", "asByteBuffer", "()Ljava/nio/ByteBuffer;", "Ljava/io/OutputStream;", "write", "(Ljava/io/OutputStream;)V", "Lokio/Buffer;", "buffer", "offset", "byteCount", "write$okio", "(Lokio/Buffer;II)V", AdnName.OTHER, "otherOffset", "", "rangeEquals", "(ILokio/ByteString;II)Z", "(I[BII)Z", "prefix", "startsWith", "(Lokio/ByteString;)Z", "([B)Z", "suffix", "endsWith", "fromIndex", "indexOf", "(Lokio/ByteString;I)I", "([BI)I", "lastIndexOf", "", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "compareTo", "(Lokio/ByteString;)I", "toString", "-deprecated_getByte", "-deprecated_size", OapsKey.KEY_SIZE, "Ljava/lang/String;", "getUtf8$okio", "setUtf8$okio", "(Ljava/lang/String;)V", MiConfigSingleton.t0, "[B", "getData$okio", "I", "getHashCode$okio", "setHashCode$okio", "(I)V", "<init>", "([B)V", "Companion", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public class ByteString implements Serializable, Comparable<ByteString> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @d
    @JvmField
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;

    @d
    private final byte[] data;
    private transient int hashCode;

    @e
    private transient String utf8;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b,\u0010-J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00020\u0002\"\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\f\u001a\u00020\u0005*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0006\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u0005*\u00020\rH\u0007¢\u0006\u0004\b\u0006\u0010\u000eJ\u0013\u0010\u0010\u001a\u00020\u0005*\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0016\u001a\u00020\u0005*\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0005*\u00020\u000fH\u0007¢\u0006\u0004\b\u0017\u0010\u0011J\u0013\u0010\u0018\u001a\u00020\u0005*\u00020\u000fH\u0007¢\u0006\u0004\b\u0018\u0010\u0011J\u001b\u0010\u001c\u001a\u00020\u0005*\u00020\u00192\u0006\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001e\u0010\u0011J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001f\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b \u0010\u0015J\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000fH\u0007¢\u0006\u0004\b!\u0010\u0011J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\rH\u0007¢\u0006\u0004\b#\u0010\u000eJ'\u0010\u0006\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b#\u0010\u000bJ\u001f\u0010\u001a\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b&\u0010\u001bR\u0016\u0010'\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006."}, d2 = {"Lokio/ByteString$Companion;", "", "", "", MiConfigSingleton.t0, "Lokio/ByteString;", "of", "([B)Lokio/ByteString;", "", "offset", "byteCount", "([BII)Lokio/ByteString;", "toByteString", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)Lokio/ByteString;", "", "encodeUtf8", "(Ljava/lang/String;)Lokio/ByteString;", "Ljava/nio/charset/Charset;", "charset", "encodeString", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lokio/ByteString;", "encode", "decodeBase64", "decodeHex", "Ljava/io/InputStream;", "read", "(Ljava/io/InputStream;I)Lokio/ByteString;", "readByteString", "string", "-deprecated_decodeBase64", "-deprecated_decodeHex", "-deprecated_encodeString", "-deprecated_encodeUtf8", "buffer", "-deprecated_of", "array", "inputstream", "-deprecated_read", "EMPTY", "Lokio/ByteString;", "", "serialVersionUID", "J", "<init>", "()V", "okio"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ ByteString encodeString$default(Companion companion, String str, Charset charset, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                charset = Charsets.UTF_8;
            }
            return companion.encodeString(str, charset);
        }

        public static /* synthetic */ ByteString of$default(Companion companion, byte[] bArr, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i2 = 0;
            }
            if ((i4 & 2) != 0) {
                i3 = bArr.length;
            }
            return companion.of(bArr, i2, i3);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeBase64()", imports = {"okio.ByteString.Companion.decodeBase64"}))
        @e
        @JvmName(name = "-deprecated_decodeBase64")
        /* renamed from: -deprecated_decodeBase64 */
        public final ByteString m1105deprecated_decodeBase64(@d String string) {
            Intrinsics.checkParameterIsNotNull(string, "string");
            return decodeBase64(string);
        }

        @d
        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeHex()", imports = {"okio.ByteString.Companion.decodeHex"}))
        @JvmName(name = "-deprecated_decodeHex")
        /* renamed from: -deprecated_decodeHex */
        public final ByteString m1106deprecated_decodeHex(@d String string) {
            Intrinsics.checkParameterIsNotNull(string, "string");
            return decodeHex(string);
        }

        @d
        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encode(charset)", imports = {"okio.ByteString.Companion.encode"}))
        @JvmName(name = "-deprecated_encodeString")
        /* renamed from: -deprecated_encodeString */
        public final ByteString m1107deprecated_encodeString(@d String string, @d Charset charset) {
            Intrinsics.checkParameterIsNotNull(string, "string");
            Intrinsics.checkParameterIsNotNull(charset, "charset");
            return encodeString(string, charset);
        }

        @d
        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encodeUtf8()", imports = {"okio.ByteString.Companion.encodeUtf8"}))
        @JvmName(name = "-deprecated_encodeUtf8")
        /* renamed from: -deprecated_encodeUtf8 */
        public final ByteString m1108deprecated_encodeUtf8(@d String string) {
            Intrinsics.checkParameterIsNotNull(string, "string");
            return encodeUtf8(string);
        }

        @d
        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "buffer.toByteString()", imports = {"okio.ByteString.Companion.toByteString"}))
        @JvmName(name = "-deprecated_of")
        /* renamed from: -deprecated_of */
        public final ByteString m1109deprecated_of(@d ByteBuffer buffer) {
            Intrinsics.checkParameterIsNotNull(buffer, "buffer");
            return of(buffer);
        }

        @d
        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "inputstream.readByteString(byteCount)", imports = {"okio.ByteString.Companion.readByteString"}))
        @JvmName(name = "-deprecated_read")
        /* renamed from: -deprecated_read */
        public final ByteString m1111deprecated_read(@d InputStream inputstream, int byteCount) {
            Intrinsics.checkParameterIsNotNull(inputstream, "inputstream");
            return read(inputstream, byteCount);
        }

        @JvmStatic
        @e
        public final ByteString decodeBase64(@d String decodeBase64) {
            Intrinsics.checkParameterIsNotNull(decodeBase64, "$this$decodeBase64");
            byte[] decodeBase64ToArray = Base64.decodeBase64ToArray(decodeBase64);
            if (decodeBase64ToArray != null) {
                return new ByteString(decodeBase64ToArray);
            }
            return null;
        }

        @d
        @JvmStatic
        public final ByteString decodeHex(@d String decodeHex) {
            Intrinsics.checkParameterIsNotNull(decodeHex, "$this$decodeHex");
            if (!(decodeHex.length() % 2 == 0)) {
                throw new IllegalArgumentException(("Unexpected hex string: " + decodeHex).toString());
            }
            int length = decodeHex.length() / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ((ByteStringKt.decodeHexDigit(decodeHex.charAt(i3)) << 4) + ByteStringKt.decodeHexDigit(decodeHex.charAt(i3 + 1)));
            }
            return new ByteString(bArr);
        }

        @d
        @JvmStatic
        @JvmName(name = "encodeString")
        public final ByteString encodeString(@d String encode, @d Charset charset) {
            Intrinsics.checkParameterIsNotNull(encode, "$this$encode");
            Intrinsics.checkParameterIsNotNull(charset, "charset");
            byte[] bytes = encode.getBytes(charset);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        @d
        @JvmStatic
        public final ByteString encodeUtf8(@d String encodeUtf8) {
            Intrinsics.checkParameterIsNotNull(encodeUtf8, "$this$encodeUtf8");
            ByteString byteString = new ByteString(Platform.asUtf8ToByteArray(encodeUtf8));
            byteString.setUtf8$okio(encodeUtf8);
            return byteString;
        }

        @d
        @JvmStatic
        @JvmName(name = "of")
        public final ByteString of(@d ByteBuffer toByteString) {
            Intrinsics.checkParameterIsNotNull(toByteString, "$this$toByteString");
            byte[] bArr = new byte[toByteString.remaining()];
            toByteString.get(bArr);
            return new ByteString(bArr);
        }

        @d
        @JvmStatic
        @JvmName(name = "read")
        public final ByteString read(@d InputStream readByteString, int i2) throws IOException {
            Intrinsics.checkParameterIsNotNull(readByteString, "$this$readByteString");
            int i3 = 0;
            if (!(i2 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + i2).toString());
            }
            byte[] bArr = new byte[i2];
            while (i3 < i2) {
                int read = readByteString.read(bArr, i3, i2 - i3);
                if (read == -1) {
                    throw new EOFException();
                }
                i3 += read;
            }
            return new ByteString(bArr);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @d
        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "array.toByteString(offset, byteCount)", imports = {"okio.ByteString.Companion.toByteString"}))
        @JvmName(name = "-deprecated_of")
        /* renamed from: -deprecated_of */
        public final ByteString m1110deprecated_of(@d byte[] array, int offset, int byteCount) {
            Intrinsics.checkParameterIsNotNull(array, "array");
            return of(array, offset, byteCount);
        }

        @d
        @JvmStatic
        public final ByteString of(@d byte... r2) {
            Intrinsics.checkParameterIsNotNull(r2, "data");
            byte[] copyOf = Arrays.copyOf(r2, r2.length);
            Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
            return new ByteString(copyOf);
        }

        @d
        @JvmStatic
        @JvmName(name = "of")
        public final ByteString of(@d byte[] toByteString, int i2, int i3) {
            Intrinsics.checkParameterIsNotNull(toByteString, "$this$toByteString");
            Util.checkOffsetAndCount(toByteString.length, i2, i3);
            return new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(toByteString, i2, i3 + i2));
        }
    }

    public ByteString(@d byte[] data) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        this.data = data;
    }

    @JvmStatic
    @e
    public static final ByteString decodeBase64(@d String str) {
        return INSTANCE.decodeBase64(str);
    }

    @d
    @JvmStatic
    public static final ByteString decodeHex(@d String str) {
        return INSTANCE.decodeHex(str);
    }

    @d
    @JvmStatic
    @JvmName(name = "encodeString")
    public static final ByteString encodeString(@d String str, @d Charset charset) {
        return INSTANCE.encodeString(str, charset);
    }

    @d
    @JvmStatic
    public static final ByteString encodeUtf8(@d String str) {
        return INSTANCE.encodeUtf8(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return byteString.indexOf(byteString2, i2);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return byteString.indexOf(bArr, i2);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i3 & 2) != 0) {
            i2 = byteString.size();
        }
        return byteString.lastIndexOf(byteString2, i2);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i3 & 2) != 0) {
            i2 = byteString.size();
        }
        return byteString.lastIndexOf(bArr, i2);
    }

    @d
    @JvmStatic
    @JvmName(name = "of")
    public static final ByteString of(@d ByteBuffer byteBuffer) {
        return INSTANCE.of(byteBuffer);
    }

    @d
    @JvmStatic
    public static final ByteString of(@d byte... bArr) {
        return INSTANCE.of(bArr);
    }

    @d
    @JvmStatic
    @JvmName(name = "of")
    public static final ByteString of(@d byte[] bArr, int i2, int i3) {
        return INSTANCE.of(bArr, i2, i3);
    }

    @d
    @JvmStatic
    @JvmName(name = "read")
    public static final ByteString read(@d InputStream inputStream, int i2) throws IOException {
        return INSTANCE.read(inputStream, i2);
    }

    private final void readObject(ObjectInputStream in) throws IOException {
        ByteString read = INSTANCE.read(in, in.readInt());
        Field field = ByteString.class.getDeclaredField(MiConfigSingleton.t0);
        Intrinsics.checkExpressionValueIsNotNull(field, "field");
        field.setAccessible(true);
        field.set(this, read.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = byteString.size();
        }
        return byteString.substring(i2, i3);
    }

    private final void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(this.data.length);
        out.write(this.data);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    @JvmName(name = "-deprecated_getByte")
    /* renamed from: -deprecated_getByte */
    public final byte m1103deprecated_getByte(int index) {
        return getByte(index);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = OapsKey.KEY_SIZE, imports = {}))
    @JvmName(name = "-deprecated_size")
    /* renamed from: -deprecated_size */
    public final int m1104deprecated_size() {
        return size();
    }

    @d
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        Intrinsics.checkExpressionValueIsNotNull(asReadOnlyBuffer, "ByteBuffer.wrap(data).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @d
    public String base64() {
        return Base64.encodeBase64$default(getData(), null, 1, null);
    }

    @d
    public String base64Url() {
        return Base64.encodeBase64(getData(), Base64.getBASE64_URL_SAFE());
    }

    @d
    public ByteString digest$okio(@d String r3) {
        Intrinsics.checkParameterIsNotNull(r3, "algorithm");
        byte[] digest = MessageDigest.getInstance(r3).digest(this.data);
        Intrinsics.checkExpressionValueIsNotNull(digest, "MessageDigest.getInstance(algorithm).digest(data)");
        return new ByteString(digest);
    }

    public final boolean endsWith(@d ByteString suffix) {
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        return rangeEquals(size() - suffix.size(), suffix, 0, suffix.size());
    }

    public boolean equals(@e Object r5) {
        if (r5 == this) {
            return true;
        }
        if (r5 instanceof ByteString) {
            ByteString byteString = (ByteString) r5;
            if (byteString.size() == getData().length && byteString.rangeEquals(0, getData(), 0, getData().length)) {
                return true;
            }
        }
        return false;
    }

    @JvmName(name = "getByte")
    public final byte getByte(int index) {
        return internalGet$okio(index);
    }

    @d
    /* renamed from: getData$okio, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* renamed from: getHashCode$okio, reason: from getter */
    public final int getHashCode() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData().length;
    }

    @e
    /* renamed from: getUtf8$okio, reason: from getter */
    public final String getUtf8() {
        return this.utf8;
    }

    public int hashCode() {
        int hashCode = getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int hashCode2 = Arrays.hashCode(getData());
        setHashCode$okio(hashCode2);
        return hashCode2;
    }

    @d
    public String hex() {
        char[] cArr = new char[getData().length * 2];
        int i2 = 0;
        for (byte b2 : getData()) {
            int i3 = i2 + 1;
            cArr[i2] = ByteStringKt.getHEX_DIGIT_CHARS()[(b2 >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = ByteStringKt.getHEX_DIGIT_CHARS()[b2 & 15];
        }
        return new String(cArr);
    }

    @d
    public ByteString hmac$okio(@d String r3, @d ByteString key) {
        Intrinsics.checkParameterIsNotNull(r3, "algorithm");
        Intrinsics.checkParameterIsNotNull(key, "key");
        try {
            Mac mac = Mac.getInstance(r3);
            mac.init(new SecretKeySpec(key.toByteArray(), r3));
            byte[] doFinal = mac.doFinal(this.data);
            Intrinsics.checkExpressionValueIsNotNull(doFinal, "mac.doFinal(data)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @d
    public ByteString hmacSha1(@d ByteString key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return hmac$okio("HmacSHA1", key);
    }

    @d
    public ByteString hmacSha256(@d ByteString key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return hmac$okio("HmacSHA256", key);
    }

    @d
    public ByteString hmacSha512(@d ByteString key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return hmac$okio("HmacSHA512", key);
    }

    @JvmOverloads
    public final int indexOf(@d ByteString byteString) {
        return indexOf$default(this, byteString, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final int indexOf(@d ByteString r2, int fromIndex) {
        Intrinsics.checkParameterIsNotNull(r2, "other");
        return indexOf(r2.internalArray$okio(), fromIndex);
    }

    @JvmOverloads
    public int indexOf(@d byte[] bArr) {
        return indexOf$default(this, bArr, 0, 2, (Object) null);
    }

    @d
    public byte[] internalArray$okio() {
        return getData();
    }

    public byte internalGet$okio(int pos) {
        return getData()[pos];
    }

    @JvmOverloads
    public final int lastIndexOf(@d ByteString byteString) {
        return lastIndexOf$default(this, byteString, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final int lastIndexOf(@d ByteString r2, int fromIndex) {
        Intrinsics.checkParameterIsNotNull(r2, "other");
        return lastIndexOf(r2.internalArray$okio(), fromIndex);
    }

    @JvmOverloads
    public int lastIndexOf(@d byte[] bArr) {
        return lastIndexOf$default(this, bArr, 0, 2, (Object) null);
    }

    @d
    public ByteString md5() {
        return digest$okio(bu.f5659a);
    }

    public boolean rangeEquals(int offset, @d ByteString r3, int otherOffset, int byteCount) {
        Intrinsics.checkParameterIsNotNull(r3, "other");
        return r3.rangeEquals(otherOffset, getData(), offset, byteCount);
    }

    public final void setHashCode$okio(int i2) {
        this.hashCode = i2;
    }

    public final void setUtf8$okio(@e String str) {
        this.utf8 = str;
    }

    @d
    public ByteString sha1() {
        return digest$okio("SHA-1");
    }

    @d
    public ByteString sha256() {
        return digest$okio("SHA-256");
    }

    @d
    public ByteString sha512() {
        return digest$okio("SHA-512");
    }

    @JvmName(name = OapsKey.KEY_SIZE)
    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(@d ByteString prefix) {
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.size());
    }

    @d
    public String string(@d Charset charset) {
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        return new String(this.data, charset);
    }

    @d
    @JvmOverloads
    public ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    @d
    @JvmOverloads
    public ByteString substring(int i2) {
        return substring$default(this, i2, 0, 2, null);
    }

    @d
    @JvmOverloads
    public ByteString substring(int beginIndex, int endIndex) {
        if (!(beginIndex >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (endIndex <= getData().length) {
            if (endIndex - beginIndex >= 0) {
                return (beginIndex == 0 && endIndex == getData().length) ? this : new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(getData(), beginIndex, endIndex));
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        throw new IllegalArgumentException(("endIndex > length(" + getData().length + ')').toString());
    }

    @d
    public ByteString toAsciiLowercase() {
        byte b2;
        for (int i2 = 0; i2 < getData().length; i2++) {
            byte b3 = getData()[i2];
            byte b4 = (byte) 65;
            if (b3 >= b4 && b3 <= (b2 = (byte) 90)) {
                byte[] data = getData();
                byte[] copyOf = Arrays.copyOf(data, data.length);
                Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i2] = (byte) (b3 + g.s);
                for (int i3 = i2 + 1; i3 < copyOf.length; i3++) {
                    byte b5 = copyOf[i3];
                    if (b5 >= b4 && b5 <= b2) {
                        copyOf[i3] = (byte) (b5 + g.s);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    @d
    public ByteString toAsciiUppercase() {
        byte b2;
        for (int i2 = 0; i2 < getData().length; i2++) {
            byte b3 = getData()[i2];
            byte b4 = (byte) 97;
            if (b3 >= b4 && b3 <= (b2 = (byte) 122)) {
                byte[] data = getData();
                byte[] copyOf = Arrays.copyOf(data, data.length);
                Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i2] = (byte) (b3 - 32);
                for (int i3 = i2 + 1; i3 < copyOf.length; i3++) {
                    byte b5 = copyOf[i3];
                    if (b5 >= b4 && b5 <= b2) {
                        copyOf[i3] = (byte) (b5 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    @d
    public byte[] toByteArray() {
        byte[] data = getData();
        byte[] copyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @d
    public String toString() {
        if (getData().length == 0) {
            return "[size=0]";
        }
        int codePointIndexToCharIndex = ByteStringKt.codePointIndexToCharIndex(getData(), 64);
        if (codePointIndexToCharIndex == -1) {
            if (getData().length <= 64) {
                return "[hex=" + hex() + ']';
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[size=");
            sb.append(getData().length);
            sb.append(" hex=");
            if (64 <= getData().length) {
                sb.append((64 == getData().length ? this : new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(getData(), 0, 64))).hex());
                sb.append("…]");
                return sb.toString();
            }
            throw new IllegalArgumentException(("endIndex > length(" + getData().length + ')').toString());
        }
        String utf8 = utf8();
        if (utf8 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = utf8.substring(0, codePointIndexToCharIndex);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String replace$default = StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(substring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
        if (codePointIndexToCharIndex >= utf8.length()) {
            return "[text=" + replace$default + ']';
        }
        return "[size=" + getData().length + " text=" + replace$default + "…]";
    }

    @d
    public String utf8() {
        String utf8 = getUtf8();
        if (utf8 != null) {
            return utf8;
        }
        String utf8String = Platform.toUtf8String(internalArray$okio());
        setUtf8$okio(utf8String);
        return utf8String;
    }

    public void write(@d OutputStream out) throws IOException {
        Intrinsics.checkParameterIsNotNull(out, "out");
        out.write(this.data);
    }

    public void write$okio(@d Buffer buffer, int offset, int byteCount) {
        Intrinsics.checkParameterIsNotNull(buffer, "buffer");
        ByteStringKt.commonWrite(this, buffer, offset, byteCount);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0030 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032 A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(@f.b.a.d okio.ByteString r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
            int r0 = r9.size()
            int r1 = r10.size()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2b
            byte r7 = r9.getByte(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.getByte(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L32
            goto L30
        L2b:
            if (r0 != r1) goto L2e
            goto L33
        L2e:
            if (r0 >= r1) goto L32
        L30:
            r3 = -1
            goto L33
        L32:
            r3 = 1
        L33:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(okio.ByteString):int");
    }

    public final boolean endsWith(@d byte[] suffix) {
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        return rangeEquals(size() - suffix.length, suffix, 0, suffix.length);
    }

    @JvmOverloads
    public int indexOf(@d byte[] r5, int fromIndex) {
        Intrinsics.checkParameterIsNotNull(r5, "other");
        int length = getData().length - r5.length;
        int max = Math.max(fromIndex, 0);
        if (max <= length) {
            while (!Util.arrayRangeEquals(getData(), max, r5, 0, r5.length)) {
                if (max != length) {
                    max++;
                }
            }
            return max;
        }
        return -1;
    }

    @JvmOverloads
    public int lastIndexOf(@d byte[] r4, int fromIndex) {
        Intrinsics.checkParameterIsNotNull(r4, "other");
        for (int min = Math.min(fromIndex, getData().length - r4.length); min >= 0; min--) {
            if (Util.arrayRangeEquals(getData(), min, r4, 0, r4.length)) {
                return min;
            }
        }
        return -1;
    }

    public boolean rangeEquals(int offset, @d byte[] r3, int otherOffset, int byteCount) {
        Intrinsics.checkParameterIsNotNull(r3, "other");
        return offset >= 0 && offset <= getData().length - byteCount && otherOffset >= 0 && otherOffset <= r3.length - byteCount && Util.arrayRangeEquals(getData(), offset, r3, otherOffset, byteCount);
    }

    public final boolean startsWith(@d byte[] prefix) {
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.length);
    }
}
