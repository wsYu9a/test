package com.shu.priory.utils.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class h extends b {
    public h(Context context) {
        super(context);
    }

    private String f() {
        try {
            Signature[] signatureArr = this.f17277a.getPackageManager().getPackageInfo(this.f17277a.getPackageName(), 64).signatures;
            if (signatureArr == null || signatureArr.length <= 0) {
                return null;
            }
            byte[] digest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
            StringBuilder sb2 = new StringBuilder();
            for (byte b10 : digest) {
                sb2.append(Integer.toHexString((b10 & 255) | 256).substring(1, 3));
            }
            return sb2.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.shu.priory.utils.a.a.b
    public String a() {
        return "com.heytap.openid.IOpenID";
    }

    @Override // com.shu.priory.utils.a.a.b
    public int b() {
        return 1;
    }

    @Override // com.shu.priory.utils.a.a.b
    public boolean c() {
        if (super.c()) {
            try {
                if (this.f17277a.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @Override // com.shu.priory.utils.a.a.b
    public Intent d() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        return intent;
    }

    @Override // com.shu.priory.utils.a.a.b
    public String[] e() {
        return new String[]{this.f17277a.getPackageName(), f(), "OUID"};
    }
}
