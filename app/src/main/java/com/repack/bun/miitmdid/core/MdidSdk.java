package com.repack.bun.miitmdid.core;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.repack.bun.supplier.IIdentifierListener;
import com.repack.bun.supplier.IdSupplier;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;
import gh.b;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jh.c;
import jh.d;
import oi.a;
import y0.b;

@Keep
/* loaded from: classes3.dex */
public class MdidSdk implements SupplierListener {
    private String _AddId;
    private IIdentifierListener _InnerListener;
    private a _setting;

    public static class C0046a {
        public static final int[] f118a;

        static {
            int[] iArr = new int[b.b(17).length];
            f118a = iArr;
            try {
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f118a[13] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f118a[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f118a[1] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f118a[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f118a[12] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f118a[5] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f118a[6] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f118a[7] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f118a[8] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f118a[9] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f118a[10] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f118a[16] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f118a[11] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f118a[14] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f118a[15] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    @Keep
    public MdidSdk() {
        try {
            c.d(true);
        } catch (Exception e10) {
            c.c(e10);
        }
    }

    private void SaveAddid(String str) {
    }

    private int _InnerFailed(int i10, IdSupplier idSupplier) {
        OnSupport(idSupplier != null ? idSupplier.isSupported() : false, idSupplier);
        return i10;
    }

    public String CreateAdditionalId(List<String> list, List<String> list2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    stringBuffer.append(str);
                }
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            for (String str2 : list2) {
                if (!TextUtils.isEmpty(str2)) {
                    stringBuffer.append(str2);
                }
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        if (TextUtils.isEmpty(stringBuffer2)) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(stringBuffer2.getBytes("UTF-8"));
            stringBuffer2 = d.a(messageDigest.digest());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | Exception unused) {
        }
        this._AddId = stringBuffer2;
        return stringBuffer2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x0142, code lost:
    
        if (r10 == false) goto L224;
     */
    @androidx.annotation.Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int InitSdk(android.content.Context r9, com.repack.bun.supplier.IIdentifierListener r10) {
        /*
            Method dump skipped, instructions count: 522
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.repack.bun.miitmdid.core.MdidSdk.InitSdk(android.content.Context, com.repack.bun.supplier.IIdentifierListener):int");
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.String>] */
    @Override // com.repack.bun.supplier.SupplierListener
    public void OnSupport(boolean z10, IdSupplier idSupplier) {
        String str;
        String str2;
        String str3;
        IIdentifierListener iIdentifierListener = this._InnerListener;
        if (iIdentifierListener != null) {
            iIdentifierListener.OnSupport(z10, idSupplier);
        }
        y0.b bVar = new y0.b();
        if (idSupplier != null) {
            str = idSupplier.getOAID();
            str2 = idSupplier.getVAID();
            str3 = idSupplier.getAAID();
            if (idSupplier instanceof InnerIdSupplier) {
                ((InnerIdSupplier) idSupplier).shutDown();
            }
        } else {
            str = "";
            str2 = str;
            str3 = str2;
        }
        String str4 = this._AddId;
        if (str4 == null) {
            str4 = "";
        }
        try {
            String a10 = ni.a.a(String.format("UDID=%s&OAID=%s&VAID=%s&AAID=%s&ADDID=%s", "", str, str2, str3, str4));
            jh.b.a();
            y0.c cVar = new y0.c();
            Map<String, String> a11 = bVar.a();
            if (a11 != null && !((HashMap) a11).isEmpty()) {
                cVar.f32947f.putAll(a11);
            }
            cVar.f32947f.put("support", String.valueOf(z10 ? 1 : 0));
            cVar.f32944c = a10;
            cVar.f32942a = "http://sdk.api.oaid.wocloud.cn/stat";
            cVar.f32948g = "POST";
            cVar.f32943b = new b.a();
            cVar.e();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void UnInitSdk() {
    }

    @Keep
    public MdidSdk(boolean z10) {
        try {
            c.d(z10);
        } catch (Exception e10) {
            c.c(e10);
        }
    }
}
