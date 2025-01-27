package y0;

import android.text.TextUtils;
import com.repack.bun.lib.sysParamters;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public static String f32940a;

    public static String a() {
        if (!TextUtils.isEmpty(f32940a)) {
            return f32940a;
        }
        StringBuilder a10 = nh.b.a("miitmdid(sdkv_");
        a10.append(sysParamters.a().e());
        a10.append(")");
        String sb2 = a10.toString();
        f32940a = sb2;
        return sb2;
    }
}
