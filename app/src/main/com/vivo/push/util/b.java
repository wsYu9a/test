package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    protected Context f25111a;

    /* renamed from: b */
    private String f25112b;

    /* renamed from: c */
    private volatile SharedPreferences f25113c;

    /* renamed from: d */
    private HashMap<String, String> f25114d = new HashMap<>();

    /* renamed from: e */
    private HashMap<String, Long> f25115e = new HashMap<>();

    /* renamed from: f */
    private HashMap<String, Integer> f25116f = new HashMap<>();

    /* renamed from: g */
    private HashMap<String, Boolean> f25117g = new HashMap<>();

    private List<String> c(String str) {
        Object a10;
        String[] split;
        if (this.f25111a == null) {
            p.c("BaseSharePreference", " parsLocalIv error mContext is null ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            Context context = this.f25111a;
            a10 = z.a(context, context.getPackageName(), str);
        } catch (Exception e10) {
            p.c("BaseSharePreference", " parsLocalIv error e =" + e10.getMessage());
            e10.printStackTrace();
        }
        if (a10 == null) {
            return null;
        }
        String str2 = new String(Base64.decode(a10.toString(), 2));
        if (!TextUtils.isEmpty(str2) && (split = str2.split(",#@")) != null && split.length >= 4) {
            for (String str3 : split) {
                arrayList.add(str3.replace(",#@", ""));
            }
            if (arrayList.size() >= 4) {
                return arrayList;
            }
        }
        return null;
    }

    public final void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("sharedFileName can't be null");
        }
        this.f25112b = str;
        this.f25113c = context.getSharedPreferences(str, 0);
        this.f25111a = context;
        List<String> c10 = c("local_iv");
        if (c10 == null || c10.size() < 4) {
            p.a("BaseSharePreference", " initSecureCode error list is null ");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("com.vivo.push.secure_sub_iv", c10.get(1));
        hashMap.put("com.vivo.push.secure_sub_key", c10.get(2));
        hashMap.put("com.vivo.push.secure_cache_iv", c10.get(3));
        hashMap.put("com.vivo.push.secure_cache_key", c10.get(0));
        a(hashMap);
    }

    public final String b(String str, String str2) {
        String str3 = this.f25114d.get(str);
        if (str3 != null) {
            return str3;
        }
        b();
        if (this.f25113c != null) {
            str3 = this.f25113c.getString(str, str2);
            if (!TextUtils.isEmpty(str3) && !str3.equals(str2)) {
                this.f25114d.put(str, str3);
            }
        }
        return str3;
    }

    public final long b(String str, long j10) {
        Long l10 = this.f25115e.get(str);
        if (l10 != null) {
            return l10.longValue();
        }
        b();
        if (this.f25113c != null) {
            l10 = Long.valueOf(this.f25113c.getLong(str, j10));
            if (!l10.equals(Long.valueOf(j10))) {
                this.f25115e.put(str, l10);
            }
        }
        return l10.longValue();
    }

    public final void a(String str, String str2) {
        this.f25114d.put(str, str2);
        b();
        if (this.f25113c != null) {
            SharedPreferences.Editor edit = this.f25113c.edit();
            edit.putString(str, str2);
            a(edit);
        }
    }

    public final void b(String str) {
        this.f25115e.remove(str);
        this.f25116f.remove(str);
        this.f25117g.remove(str);
        this.f25114d.remove(str);
        b();
        if (this.f25113c != null) {
            SharedPreferences.Editor edit = this.f25113c.edit();
            if (this.f25113c.contains(str)) {
                edit.remove(str);
                a(edit);
            }
        }
    }

    private void a(Map<String, String> map) {
        if (map.size() > 0) {
            b();
            if (this.f25113c != null) {
                SharedPreferences.Editor edit = this.f25113c.edit();
                for (String str : map.keySet()) {
                    String str2 = map.get(str);
                    this.f25114d.put(str, str2);
                    edit.putString(str, str2);
                }
                a(edit);
            }
        }
    }

    private void b() {
        if (this.f25113c == null) {
            Context context = this.f25111a;
            if (context != null) {
                this.f25113c = context.getSharedPreferences(this.f25112b, 0);
                return;
            }
            throw new RuntimeException("SharedPreferences is not init", new Throwable());
        }
    }

    public final void a(String str, int i10) {
        this.f25116f.put(str, Integer.valueOf(i10));
        b();
        if (this.f25113c != null) {
            SharedPreferences.Editor edit = this.f25113c.edit();
            edit.putInt(str, i10);
            a(edit);
        }
    }

    public final void a(String str, long j10) {
        this.f25115e.put(str, Long.valueOf(j10));
        b();
        if (this.f25113c != null) {
            SharedPreferences.Editor edit = this.f25113c.edit();
            edit.putLong(str, j10);
            a(edit);
        }
    }

    public final int a(String str) {
        Integer num = this.f25116f.get(str);
        if (num != null) {
            return num.intValue();
        }
        b();
        if (this.f25113c != null) {
            num = Integer.valueOf(this.f25113c.getInt(str, 0));
            if (!num.equals(0)) {
                this.f25116f.put(str, num);
            }
        }
        return num.intValue();
    }

    public static void a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public final void a() {
        this.f25115e.clear();
        this.f25116f.clear();
        this.f25117g.clear();
        this.f25114d.clear();
        b();
        if (this.f25113c != null) {
            SharedPreferences.Editor edit = this.f25113c.edit();
            edit.clear();
            a(edit);
        }
    }
}
