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
    protected Context f31075a;

    /* renamed from: b */
    private String f31076b;

    /* renamed from: c */
    private volatile SharedPreferences f31077c;

    /* renamed from: d */
    private HashMap<String, String> f31078d = new HashMap<>();

    /* renamed from: e */
    private HashMap<String, Long> f31079e = new HashMap<>();

    /* renamed from: f */
    private HashMap<String, Integer> f31080f = new HashMap<>();

    /* renamed from: g */
    private HashMap<String, Boolean> f31081g = new HashMap<>();

    private List<String> c(String str) {
        Object a2;
        String[] split;
        if (this.f31075a == null) {
            p.c("BaseSharePreference", " parsLocalIv error mContext is null ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            Context context = this.f31075a;
            a2 = z.a(context, context.getPackageName(), str);
        } catch (Exception e2) {
            p.c("BaseSharePreference", " parsLocalIv error e =" + e2.getMessage());
            e2.printStackTrace();
        }
        if (a2 == null) {
            return null;
        }
        String str2 = new String(Base64.decode(a2.toString(), 2));
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
        this.f31076b = str;
        this.f31077c = context.getSharedPreferences(str, 0);
        this.f31075a = context;
        List<String> c2 = c("local_iv");
        if (c2 == null || c2.size() < 4) {
            p.a("BaseSharePreference", " initSecureCode error list is null ");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("com.vivo.push.secure_sub_iv", c2.get(1));
        hashMap.put("com.vivo.push.secure_sub_key", c2.get(2));
        hashMap.put("com.vivo.push.secure_cache_iv", c2.get(3));
        hashMap.put("com.vivo.push.secure_cache_key", c2.get(0));
        a(hashMap);
    }

    public final String b(String str, String str2) {
        String str3 = this.f31078d.get(str);
        if (str3 != null) {
            return str3;
        }
        b();
        if (this.f31077c != null) {
            str3 = this.f31077c.getString(str, str2);
            if (!TextUtils.isEmpty(str3) && !str3.equals(str2)) {
                this.f31078d.put(str, str3);
            }
        }
        return str3;
    }

    public final long b(String str, long j2) {
        Long l = this.f31079e.get(str);
        if (l != null) {
            return l.longValue();
        }
        b();
        if (this.f31077c != null) {
            l = Long.valueOf(this.f31077c.getLong(str, j2));
            if (!l.equals(Long.valueOf(j2))) {
                this.f31079e.put(str, l);
            }
        }
        return l.longValue();
    }

    public final void a(String str, String str2) {
        this.f31078d.put(str, str2);
        b();
        if (this.f31077c != null) {
            SharedPreferences.Editor edit = this.f31077c.edit();
            edit.putString(str, str2);
            a(edit);
        }
    }

    public final void b(String str) {
        this.f31079e.remove(str);
        this.f31080f.remove(str);
        this.f31081g.remove(str);
        this.f31078d.remove(str);
        b();
        if (this.f31077c != null) {
            SharedPreferences.Editor edit = this.f31077c.edit();
            if (this.f31077c.contains(str)) {
                edit.remove(str);
                a(edit);
            }
        }
    }

    private void a(Map<String, String> map) {
        if (map.size() > 0) {
            b();
            if (this.f31077c != null) {
                SharedPreferences.Editor edit = this.f31077c.edit();
                for (String str : map.keySet()) {
                    String str2 = map.get(str);
                    this.f31078d.put(str, str2);
                    edit.putString(str, str2);
                }
                a(edit);
            }
        }
    }

    private void b() {
        if (this.f31077c == null) {
            Context context = this.f31075a;
            if (context != null) {
                this.f31077c = context.getSharedPreferences(this.f31076b, 0);
                return;
            }
            throw new RuntimeException("SharedPreferences is not init", new Throwable());
        }
    }

    public final void a(String str, int i2) {
        this.f31080f.put(str, Integer.valueOf(i2));
        b();
        if (this.f31077c != null) {
            SharedPreferences.Editor edit = this.f31077c.edit();
            edit.putInt(str, i2);
            a(edit);
        }
    }

    public final void a(String str, long j2) {
        this.f31079e.put(str, Long.valueOf(j2));
        b();
        if (this.f31077c != null) {
            SharedPreferences.Editor edit = this.f31077c.edit();
            edit.putLong(str, j2);
            a(edit);
        }
    }

    public final int a(String str) {
        Integer num = this.f31080f.get(str);
        if (num != null) {
            return num.intValue();
        }
        b();
        if (this.f31077c != null) {
            num = Integer.valueOf(this.f31077c.getInt(str, 0));
            if (!num.equals(0)) {
                this.f31080f.put(str, num);
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
        this.f31079e.clear();
        this.f31080f.clear();
        this.f31081g.clear();
        this.f31078d.clear();
        b();
        if (this.f31077c != null) {
            SharedPreferences.Editor edit = this.f31077c.edit();
            edit.clear();
            a(edit);
        }
    }
}
