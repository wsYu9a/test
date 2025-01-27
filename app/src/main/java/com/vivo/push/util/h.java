package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* loaded from: classes4.dex */
public final class h implements BaseNotifyDataAdapter {

    /* renamed from: e */
    private static int f25118e;

    /* renamed from: f */
    private static int f25119f;

    /* renamed from: a */
    private Resources f25120a;

    /* renamed from: b */
    private String f25121b;

    /* renamed from: c */
    private String f25122c;

    /* renamed from: d */
    private String f25123d;

    private static boolean a(int i10) {
        return (i10 == -1 || i10 == 0) ? false : true;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultNotifyIcon() {
        if (a(f25118e)) {
            return f25118e;
        }
        String str = this.f25123d;
        int a10 = !a(str) ? -1 : a(str, "_notifyicon");
        f25118e = a10;
        if (a(a10)) {
            return f25118e;
        }
        for (String str2 = this.f25122c; !TextUtils.isEmpty(str2); str2 = str2.substring(0, str2.length() - 1)) {
            int identifier = this.f25120a.getIdentifier("vivo_push_rom" + str2 + "_notifyicon", "drawable", this.f25121b);
            if (identifier > 0) {
                return identifier;
            }
        }
        return this.f25120a.getIdentifier("vivo_push_notifyicon", "drawable", this.f25121b);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultSmallIconId() {
        if (a(f25119f)) {
            return f25119f;
        }
        String str = this.f25123d;
        int a10 = !a(str) ? -1 : a(str, "_icon");
        f25119f = a10;
        if (a(a10)) {
            return f25119f;
        }
        for (String str2 = this.f25122c; !TextUtils.isEmpty(str2); str2 = str2.substring(0, str2.length() - 1)) {
            int identifier = this.f25120a.getIdentifier("vivo_push_rom" + str2 + "_icon", "drawable", this.f25121b);
            if (identifier > 0) {
                return identifier;
            }
        }
        return this.f25120a.getIdentifier("vivo_push_icon", "drawable", this.f25121b);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getNotifyMode(InsideNotificationItem insideNotificationItem) {
        return 2;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final void init(Context context) {
        this.f25121b = context.getPackageName();
        this.f25120a = context.getResources();
        this.f25122c = j.a();
        this.f25123d = Build.VERSION.RELEASE;
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
                    int identifier = this.f25120a.getIdentifier(str3, "drawable", this.f25121b);
                    if (identifier > 0) {
                        p.c("DefaultNotifyDataAdapter", "find notify icon : ".concat(String.valueOf(str3)));
                        return identifier;
                    }
                }
            } catch (Exception e10) {
                p.a("DefaultNotifyDataAdapter", e10);
            }
        }
        return -1;
    }
}
