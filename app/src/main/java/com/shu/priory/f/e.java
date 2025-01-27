package com.shu.priory.f;

import android.os.Build;
import android.text.TextUtils;
import com.shu.priory.f.c;

/* loaded from: classes3.dex */
final class e implements c.b {
    @Override // com.shu.priory.f.c.b
    public void a(String str) {
        System.loadLibrary(str);
    }

    @Override // com.shu.priory.f.c.b
    public void b(String str) {
        System.load(str);
    }

    @Override // com.shu.priory.f.c.b
    public String c(String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }

    @Override // com.shu.priory.f.c.b
    public String d(String str) {
        return str.substring(3, str.length() - 3);
    }

    @Override // com.shu.priory.f.c.b
    public String[] a() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            return strArr;
        }
        String str = Build.CPU_ABI2;
        return !TextUtils.isEmpty(str) ? new String[]{Build.CPU_ABI, str} : new String[]{Build.CPU_ABI};
    }
}
