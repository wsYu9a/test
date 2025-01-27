package com.shu.priory.request;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.shu.priory.utils.f;
import java.net.URL;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a */
    private static volatile a f17214a;

    /* renamed from: b */
    private Context f17215b;

    /* renamed from: c */
    private SharedPreferences f17216c;

    /* renamed from: d */
    private int f17217d = 60000;

    /* renamed from: e */
    private long f17218e;

    /* renamed from: f */
    private String f17219f;

    /* renamed from: g */
    private volatile boolean f17220g;

    /* renamed from: com.shu.priory.request.a$1 */
    public class AnonymousClass1 implements c {
        public AnonymousClass1() {
        }

        @Override // com.shu.priory.request.c
        public void a(int i10) {
            a.this.f17220g = false;
        }

        @Override // com.shu.priory.request.c
        public void a(byte[] bArr) {
            try {
                String b10 = f.b(new String(bArr), "Mfv9IdVk");
                String str = com.shu.priory.param.b.f17177b;
                URL url = new URL(str);
                String[] split = b10.split(",");
                if (split.length > 0 && a.this.a(split[0])) {
                    String replaceFirst = str.replaceFirst(url.getHost(), split[0]);
                    if (!TextUtils.isEmpty(replaceFirst) && !replaceFirst.equals(a.this.f17219f)) {
                        SharedPreferences.Editor edit = a.this.f17216c.edit();
                        a.this.f17219f = replaceFirst;
                        edit.putString("server_ip", replaceFirst);
                        edit.apply();
                    }
                    if (split.length > 1) {
                        try {
                            a.this.f17217d = Integer.decode(split[1]).intValue() * 1000;
                        } catch (Exception unused) {
                        }
                    }
                    a.this.f17218e = System.currentTimeMillis();
                }
            } catch (Throwable unused2) {
            }
            a.this.f17220g = false;
        }
    }

    private a(Context context) {
        this.f17215b = context;
        this.f17216c = context.getSharedPreferences("iflyads_dns", 0);
    }

    public void b() {
        try {
            if (!this.f17220g && System.currentTimeMillis() - this.f17218e >= this.f17217d) {
                b bVar = new b();
                bVar.a(this.f17215b);
                bVar.b(0);
                bVar.a("http://119.29.29.29/d?dn=" + f.a(com.shu.priory.param.b.f17176a, "Mfv9IdVk") + "&id=8555&ttl=1", null, null);
                bVar.a(new c() { // from class: com.shu.priory.request.a.1
                    public AnonymousClass1() {
                    }

                    @Override // com.shu.priory.request.c
                    public void a(int i10) {
                        a.this.f17220g = false;
                    }

                    @Override // com.shu.priory.request.c
                    public void a(byte[] bArr) {
                        try {
                            String b10 = f.b(new String(bArr), "Mfv9IdVk");
                            String str = com.shu.priory.param.b.f17177b;
                            URL url = new URL(str);
                            String[] split = b10.split(",");
                            if (split.length > 0 && a.this.a(split[0])) {
                                String replaceFirst = str.replaceFirst(url.getHost(), split[0]);
                                if (!TextUtils.isEmpty(replaceFirst) && !replaceFirst.equals(a.this.f17219f)) {
                                    SharedPreferences.Editor edit = a.this.f17216c.edit();
                                    a.this.f17219f = replaceFirst;
                                    edit.putString("server_ip", replaceFirst);
                                    edit.apply();
                                }
                                if (split.length > 1) {
                                    try {
                                        a.this.f17217d = Integer.decode(split[1]).intValue() * 1000;
                                    } catch (Exception unused) {
                                    }
                                }
                                a.this.f17218e = System.currentTimeMillis();
                            }
                        } catch (Throwable unused2) {
                        }
                        a.this.f17220g = false;
                    }
                });
                this.f17220g = true;
            }
        } catch (Throwable unused) {
            this.f17220g = false;
        }
    }

    public static a a(Context context) {
        if (f17214a == null) {
            synchronized (a.class) {
                try {
                    if (f17214a == null) {
                        f17214a = new a(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return f17214a;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f17219f)) {
            this.f17219f = this.f17216c.getString("server_ip", "");
        }
        return this.f17219f;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(str).matches();
    }
}
