package b.c.b.a;

import android.os.Build;
import android.util.Base64;
import f.b.a.d;
import f.b.a.e;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ7\u0010\u0007\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lb/c/b/a/a;", "", "", "appVersion", "region", "adg", "aug", "getRouteData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "stringLine", "", "parseRouteData", "(Ljava/lang/String;)Ljava/util/Map;", "<init>", "()V", "lib_routedata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public static final a f4350a = new a();

    private a() {
    }

    @d
    @JvmStatic
    public static final String a(@e String str, @e String str2, @e String str3, @e String str4) {
        String str5 = "1\u0001" + str3 + "\u0001" + str + "\u0001" + Build.MODEL + "\u0001" + Build.BRAND + "\u0001" + str2 + "\u0001" + str4;
        Charset charset = Charsets.UTF_8;
        if (str5 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str5.getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] encode = Base64.encode(bytes, 2);
        Intrinsics.checkExpressionValueIsNotNull(encode, "Base64.encode(routeData.…EFAULT or Base64.NO_WRAP)");
        return new String(encode, charset);
    }
}
