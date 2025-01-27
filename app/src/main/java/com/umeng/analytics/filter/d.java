package com.umeng.analytics.filter;

import android.util.Base64;
import com.baidu.mobads.sdk.internal.bu;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: b */
    private static final String f25607b = "Ă";

    /* renamed from: c */
    private MessageDigest f25609c;

    /* renamed from: e */
    private boolean f25611e;

    /* renamed from: a */
    private final String f25608a = bu.f5659a;

    /* renamed from: d */
    private Set<Object> f25610d = new HashSet();

    public d(boolean z, String str) {
        int i2 = 0;
        this.f25611e = false;
        this.f25611e = z;
        try {
            this.f25609c = MessageDigest.getInstance(bu.f5659a);
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        if (str != null) {
            if (!z) {
                String[] split = str.split(f25607b);
                int length = split.length;
                while (i2 < length) {
                    this.f25610d.add(split[i2]);
                    i2++;
                }
                return;
            }
            try {
                byte[] decode = Base64.decode(str.getBytes(), 0);
                while (i2 < decode.length / 4) {
                    int i3 = i2 * 4;
                    this.f25610d.add(Integer.valueOf(((decode[i3 + 0] & 255) << 24) + ((decode[i3 + 1] & 255) << 16) + ((decode[i3 + 2] & 255) << 8) + (decode[i3 + 3] & 255)));
                    i2++;
                }
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            }
        }
    }

    private Integer c(String str) {
        try {
            this.f25609c.update(str.getBytes());
            byte[] digest = this.f25609c.digest();
            return Integer.valueOf(((digest[0] & 255) << 24) + ((digest[1] & 255) << 16) + ((digest[2] & 255) << 8) + (digest[3] & 255));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean a(String str) {
        return this.f25611e ? this.f25610d.contains(c(str)) : this.f25610d.contains(str);
    }

    public void b(String str) {
        if (this.f25611e) {
            this.f25610d.add(c(str));
        } else {
            this.f25610d.add(str);
        }
    }

    public String toString() {
        if (!this.f25611e) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : this.f25610d) {
                if (sb.length() > 0) {
                    sb.append(f25607b);
                }
                sb.append(obj.toString());
            }
            return sb.toString();
        }
        byte[] bArr = new byte[this.f25610d.size() * 4];
        Iterator<Object> it = this.f25610d.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            int i3 = i2 + 1;
            bArr[i2] = (byte) (((-16777216) & intValue) >> 24);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((16711680 & intValue) >> 16);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((65280 & intValue) >> 8);
            i2 = i5 + 1;
            bArr[i5] = (byte) (intValue & 255);
        }
        return new String(Base64.encode(bArr, 0));
    }

    public void a() {
        StringBuilder sb = new StringBuilder();
        Iterator<Object> it = this.f25610d.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (sb.length() > 0) {
                sb.append(",");
            }
        }
        System.out.println(sb.toString());
    }
}
