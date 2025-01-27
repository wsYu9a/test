package com.umeng.analytics.filter;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: b */
    private static final String f23366b = "Ă";

    /* renamed from: c */
    private MessageDigest f23368c;

    /* renamed from: e */
    private boolean f23370e;

    /* renamed from: a */
    private final String f23367a = "MD5";

    /* renamed from: d */
    private Set<Object> f23369d = new HashSet();

    public d(boolean z10, String str) {
        this.f23370e = z10;
        try {
            this.f23368c = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
        }
        if (str != null) {
            int i10 = 0;
            if (!z10) {
                String[] split = str.split(f23366b);
                int length = split.length;
                while (i10 < length) {
                    this.f23369d.add(split[i10]);
                    i10++;
                }
                return;
            }
            try {
                byte[] decode = Base64.decode(str.getBytes(), 0);
                while (i10 < decode.length / 4) {
                    int i11 = i10 * 4;
                    this.f23369d.add(Integer.valueOf(((decode[i11] & 255) << 24) + ((decode[i11 + 1] & 255) << 16) + ((decode[i11 + 2] & 255) << 8) + (decode[i11 + 3] & 255)));
                    i10++;
                }
            } catch (IllegalArgumentException e11) {
                e11.printStackTrace();
            }
        }
    }

    private Integer c(String str) {
        try {
            this.f23368c.update(str.getBytes());
            byte[] digest = this.f23368c.digest();
            return Integer.valueOf(((digest[0] & 255) << 24) + ((digest[1] & 255) << 16) + ((digest[2] & 255) << 8) + (digest[3] & 255));
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public boolean a(String str) {
        return this.f23370e ? this.f23369d.contains(c(str)) : this.f23369d.contains(str);
    }

    public void b(String str) {
        if (this.f23370e) {
            this.f23369d.add(c(str));
        } else {
            this.f23369d.add(str);
        }
    }

    public String toString() {
        if (!this.f23370e) {
            StringBuilder sb2 = new StringBuilder();
            for (Object obj : this.f23369d) {
                if (sb2.length() > 0) {
                    sb2.append(f23366b);
                }
                sb2.append(obj.toString());
            }
            return sb2.toString();
        }
        byte[] bArr = new byte[this.f23369d.size() * 4];
        Iterator<Object> it = this.f23369d.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            bArr[i10] = (byte) (((-16777216) & intValue) >> 24);
            bArr[i10 + 1] = (byte) ((16711680 & intValue) >> 16);
            int i11 = i10 + 3;
            bArr[i10 + 2] = (byte) ((65280 & intValue) >> 8);
            i10 += 4;
            bArr[i11] = (byte) (intValue & 255);
        }
        return new String(Base64.encode(bArr, 0));
    }

    public void a() {
        StringBuilder sb2 = new StringBuilder();
        Iterator<Object> it = this.f23369d.iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (sb2.length() > 0) {
                sb2.append(",");
            }
        }
        System.out.println(sb2.toString());
    }
}
