package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MethodCallsLogger {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Integer> f2621a = new HashMap();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean approveCall(String str, int i2) {
        Integer num = this.f2621a.get(str);
        int intValue = num != null ? num.intValue() : 0;
        boolean z = (intValue & i2) != 0;
        this.f2621a.put(str, Integer.valueOf(i2 | intValue));
        return !z;
    }
}
