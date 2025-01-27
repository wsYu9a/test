package okio;

import com.baidu.mobads.sdk.internal.bu;
import com.oplus.quickgame.sdk.hall.Constant;
import com.tencent.open.SocialConstants;
import f.b.a.d;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0019\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017B!\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0019J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0013\u0010\u000b\u001a\u00020\b8G@\u0006¢\u0006\u0006\u001a\u0004\b\u000b\u0010\n¨\u0006\u001b"}, d2 = {"Lokio/HashingSource;", "Lokio/ForwardingSource;", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "Lokio/ByteString;", "-deprecated_hash", "()Lokio/ByteString;", "hash", "Ljava/security/MessageDigest;", "messageDigest", "Ljava/security/MessageDigest;", "Ljavax/crypto/Mac;", "mac", "Ljavax/crypto/Mac;", "Lokio/Source;", SocialConstants.PARAM_SOURCE, "", Constant.Param.ALGORITHM, "<init>", "(Lokio/Source;Ljava/lang/String;)V", "key", "(Lokio/Source;Lokio/ByteString;Ljava/lang/String;)V", "Companion", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class HashingSource extends ForwardingSource {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\u0006J\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000e\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000f\u0010\r¨\u0006\u0012"}, d2 = {"Lokio/HashingSource$Companion;", "", "Lokio/Source;", SocialConstants.PARAM_SOURCE, "Lokio/HashingSource;", "md5", "(Lokio/Source;)Lokio/HashingSource;", "sha1", "sha256", "sha512", "Lokio/ByteString;", "key", "hmacSha1", "(Lokio/Source;Lokio/ByteString;)Lokio/HashingSource;", "hmacSha256", "hmacSha512", "<init>", "()V", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        @d
        @JvmStatic
        public final HashingSource hmacSha1(@d Source r3, @d ByteString key) {
            Intrinsics.checkParameterIsNotNull(r3, "source");
            Intrinsics.checkParameterIsNotNull(key, "key");
            return new HashingSource(r3, key, "HmacSHA1");
        }

        @d
        @JvmStatic
        public final HashingSource hmacSha256(@d Source r3, @d ByteString key) {
            Intrinsics.checkParameterIsNotNull(r3, "source");
            Intrinsics.checkParameterIsNotNull(key, "key");
            return new HashingSource(r3, key, "HmacSHA256");
        }

        @d
        @JvmStatic
        public final HashingSource hmacSha512(@d Source r3, @d ByteString key) {
            Intrinsics.checkParameterIsNotNull(r3, "source");
            Intrinsics.checkParameterIsNotNull(key, "key");
            return new HashingSource(r3, key, "HmacSHA512");
        }

        @d
        @JvmStatic
        public final HashingSource md5(@d Source r3) {
            Intrinsics.checkParameterIsNotNull(r3, "source");
            return new HashingSource(r3, bu.f5659a);
        }

        @d
        @JvmStatic
        public final HashingSource sha1(@d Source r3) {
            Intrinsics.checkParameterIsNotNull(r3, "source");
            return new HashingSource(r3, "SHA-1");
        }

        @d
        @JvmStatic
        public final HashingSource sha256(@d Source r3) {
            Intrinsics.checkParameterIsNotNull(r3, "source");
            return new HashingSource(r3, "SHA-256");
        }

        @d
        @JvmStatic
        public final HashingSource sha512(@d Source r3) {
            Intrinsics.checkParameterIsNotNull(r3, "source");
            return new HashingSource(r3, "SHA-512");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(@d Source source, @d String algorithm) {
        super(source);
        Intrinsics.checkParameterIsNotNull(source, "source");
        Intrinsics.checkParameterIsNotNull(algorithm, "algorithm");
        this.messageDigest = MessageDigest.getInstance(algorithm);
        this.mac = null;
    }

    @d
    @JvmStatic
    public static final HashingSource hmacSha1(@d Source source, @d ByteString byteString) {
        return INSTANCE.hmacSha1(source, byteString);
    }

    @d
    @JvmStatic
    public static final HashingSource hmacSha256(@d Source source, @d ByteString byteString) {
        return INSTANCE.hmacSha256(source, byteString);
    }

    @d
    @JvmStatic
    public static final HashingSource hmacSha512(@d Source source, @d ByteString byteString) {
        return INSTANCE.hmacSha512(source, byteString);
    }

    @d
    @JvmStatic
    public static final HashingSource md5(@d Source source) {
        return INSTANCE.md5(source);
    }

    @d
    @JvmStatic
    public static final HashingSource sha1(@d Source source) {
        return INSTANCE.sha1(source);
    }

    @d
    @JvmStatic
    public static final HashingSource sha256(@d Source source) {
        return INSTANCE.sha256(source);
    }

    @d
    @JvmStatic
    public static final HashingSource sha512(@d Source source) {
        return INSTANCE.sha512(source);
    }

    @d
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hash", imports = {}))
    @JvmName(name = "-deprecated_hash")
    /* renamed from: -deprecated_hash */
    public final ByteString m1117deprecated_hash() {
        return hash();
    }

    @d
    @JvmName(name = "hash")
    public final ByteString hash() {
        byte[] result;
        MessageDigest messageDigest = this.messageDigest;
        if (messageDigest != null) {
            result = messageDigest.digest();
        } else {
            Mac mac = this.mac;
            if (mac == null) {
                Intrinsics.throwNpe();
            }
            result = mac.doFinal();
        }
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return new ByteString(result);
    }

    @Override // okio.ForwardingSource, okio.Source
    public long read(@d Buffer sink, long byteCount) throws IOException {
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        long read = super.read(sink, byteCount);
        if (read != -1) {
            long size = sink.size() - read;
            long size2 = sink.size();
            Segment segment = sink.head;
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            while (size2 > size) {
                segment = segment.prev;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                size2 -= segment.limit - segment.pos;
            }
            while (size2 < sink.size()) {
                int i2 = (int) ((segment.pos + size) - size2);
                MessageDigest messageDigest = this.messageDigest;
                if (messageDigest != null) {
                    messageDigest.update(segment.data, i2, segment.limit - i2);
                } else {
                    Mac mac = this.mac;
                    if (mac == null) {
                        Intrinsics.throwNpe();
                    }
                    mac.update(segment.data, i2, segment.limit - i2);
                }
                size2 += segment.limit - segment.pos;
                segment = segment.next;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                size = size2;
            }
        }
        return read;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(@d Source source, @d ByteString key, @d String algorithm) {
        super(source);
        Intrinsics.checkParameterIsNotNull(source, "source");
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(algorithm, "algorithm");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            this.mac = mac;
            this.messageDigest = null;
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
