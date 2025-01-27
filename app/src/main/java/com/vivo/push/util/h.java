package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* loaded from: classes4.dex */
public final class h implements BaseNotifyDataAdapter {

    /* renamed from: e */
    private static int f31082e;

    /* renamed from: f */
    private static int f31083f;

    /* renamed from: a */
    private Resources f31084a;

    /* renamed from: b */
    private String f31085b;

    /* renamed from: c */
    private String f31086c;

    /* renamed from: d */
    private String f31087d;

    private static boolean a(int i2) {
        return (i2 == -1 || i2 == 0) ? false : true;
    }

    private static boolean a(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        p.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
        return false;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultNotifyIcon() {
        if (a(f31082e)) {
            return f31082e;
        }
        String str = this.f31087d;
        int a2 = !a(str) ? -1 : a(str, "_notifyicon");
        f31082e = a2;
        if (a(a2)) {
            return f31082e;
        }
        for (String str2 = this.f31086c; !TextUtils.isEmpty(str2); str2 = str2.substring(0, str2.length() - 1)) {
            int identifier = this.f31084a.getIdentifier("vivo_push_rom" + str2 + "_notifyicon", "drawable", this.f31085b);
            if (identifier > 0) {
                return identifier;
            }
        }
        return this.f31084a.getIdentifier("vivo_push_notifyicon", "drawable", this.f31085b);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultSmallIconId() {
        if (a(f31083f)) {
            return f31083f;
        }
        String str = this.f31087d;
        int a2 = !a(str) ? -1 : a(str, "_icon");
        f31083f = a2;
        if (a(a2)) {
            return f31083f;
        }
        for (String str2 = this.f31086c; !TextUtils.isEmpty(str2); str2 = str2.substring(0, str2.length() - 1)) {
            int identifier = this.f31084a.getIdentifier("vivo_push_rom" + str2 + "_icon", "drawable", this.f31085b);
            if (identifier > 0) {
                return identifier;
            }
        }
        return this.f31084a.getIdentifier("vivo_push_icon", "drawable", this.f31085b);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getNotifyMode(InsideNotificationItem insideNotificationItem) {
        return Build.VERSION.SDK_INT >= 21 ? 2 : 1;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final void init(Context context) {
        this.f31085b = context.getPackageName();
        this.f31084a = context.getResources();
        this.f31086c = j.a();
        this.f31087d = Build.VERSION.RELEASE;
    }

    private int a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] split = str.split("\\.");
            if (split != null && split.length > 0) {
                str = split[0];
            }
            try {
                for (int parseInt = Integer.parseInt(str); parseInt > 0; parseInt--) {
                    String str3 = "vivo_push_ard" + parseInt + str2;
                    p.c("DefaultNotifyDataAdapter", "get notify icon : ".concat(String.valueOf(str3)));
                    int identifier = this.f31084a.getIdentifier(str3, "drawable", this.f31085b);
                    if (identifier > 0) {
                        p.c("DefaultNotifyDataAdapter", "find notify icon : ".concat(String.valueOf(str3)));
                        return identifier;
                    }
                }
            } catch (Exception e2) {
                p.a("DefaultNotifyDataAdapter", e2);
            }
        }
        return -1;
    }
}
