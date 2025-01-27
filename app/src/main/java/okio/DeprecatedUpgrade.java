package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import xi.k;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Okio", "Lokio/-DeprecatedOkio;", "getOkio", "()Lokio/-DeprecatedOkio;", "Utf8", "Lokio/-DeprecatedUtf8;", "getUtf8", "()Lokio/-DeprecatedUtf8;", "okio"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "-DeprecatedUpgrade")
/* renamed from: okio.-DeprecatedUpgrade */
/* loaded from: classes4.dex */
public final class DeprecatedUpgrade {

    @k
    private static final DeprecatedOkio Okio = DeprecatedOkio.INSTANCE;

    @k
    private static final DeprecatedUtf8 Utf8 = DeprecatedUtf8.INSTANCE;

    @k
    public static final DeprecatedOkio getOkio() {
        return Okio;
    }

    @k
    public static final DeprecatedUtf8 getUtf8() {
        return Utf8;
    }
}
