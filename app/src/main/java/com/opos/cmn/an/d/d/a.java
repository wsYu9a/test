package com.opos.cmn.an.d.d;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private SharedPreferences f16375a;

    public a(Context context, String str, int i2) {
        this.f16375a = null;
        if (context == null || com.opos.cmn.an.c.a.a(str)) {
            return;
        }
        this.f16375a = context.getSharedPreferences(str, i2);
        com.opos.cmn.an.f.a.b("SPEngine", "context.getSharedPreferences name=" + str + ",mode=" + i2);
    }

    private boolean a(SharedPreferences.Editor editor, String str, Object obj) {
        boolean z = false;
        if (editor != null && !com.opos.cmn.an.c.a.a(str) && obj != null && this.f16375a != null) {
            try {
                if (obj instanceof Boolean) {
                    editor.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Float) {
                    editor.putFloat(str, ((Float) obj).floatValue());
                } else if (obj instanceof Integer) {
                    editor.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    editor.putLong(str, ((Long) obj).longValue());
                } else if (obj instanceof String) {
                    editor.putString(str, (String) obj);
                } else if (obj instanceof Set) {
                    editor.putStringSet(str, (Set) obj);
                }
                z = true;
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("SPEngine", "put", e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("put key=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(",value=");
        if (obj == null) {
            obj = "null";
        }
        sb.append(obj);
        sb.append(",result=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("SPEngine", sb.toString());
        return z;
    }

    public long a(String str, long j2) {
        SharedPreferences sharedPreferences;
        if (!com.opos.cmn.an.c.a.a(str) && (sharedPreferences = this.f16375a) != null) {
            try {
                j2 = sharedPreferences.getLong(str, j2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("SPEngine", "getLong", e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getLong key=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(",value=");
        sb.append(j2);
        com.opos.cmn.an.f.a.b("SPEngine", sb.toString());
        return j2;
    }

    public Map<String, ?> a() {
        SharedPreferences sharedPreferences = this.f16375a;
        Map<String, ?> all = sharedPreferences != null ? sharedPreferences.getAll() : null;
        StringBuilder sb = new StringBuilder();
        sb.append("getAll=");
        sb.append(all != null ? Integer.valueOf(all.size()) : "null");
        com.opos.cmn.an.f.a.b("SPEngine", sb.toString());
        return all;
    }

    public void a(String str) {
        SharedPreferences sharedPreferences;
        StringBuilder sb = new StringBuilder();
        sb.append("removeAndApply key=");
        sb.append(str != null ? str : "null");
        com.opos.cmn.an.f.a.b("SPEngine", sb.toString());
        if (com.opos.cmn.an.c.a.a(str) || (sharedPreferences = this.f16375a) == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove(str);
            edit.commit();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("SPEngine", "removeAndCommit", e2);
        }
    }

    public void a(String str, Object obj) {
        SharedPreferences sharedPreferences;
        StringBuilder sb = new StringBuilder();
        sb.append("putAndApply key=");
        sb.append(str != null ? str : "null");
        sb.append(",value=");
        sb.append(obj != null ? obj : "null");
        com.opos.cmn.an.f.a.b("SPEngine", sb.toString());
        if (com.opos.cmn.an.c.a.a(str) || obj == null || (sharedPreferences = this.f16375a) == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (a(edit, str, obj)) {
                edit.apply();
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("SPEngine", "putAndApply", e2);
        }
    }

    public boolean a(String str, boolean z) {
        SharedPreferences sharedPreferences;
        if (!com.opos.cmn.an.c.a.a(str) && (sharedPreferences = this.f16375a) != null) {
            try {
                z = sharedPreferences.getBoolean(str, z);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("SPEngine", "getBoolean", e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getInt key=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(",value=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("SPEngine", sb.toString());
        return z;
    }
}
