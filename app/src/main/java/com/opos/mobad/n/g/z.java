package com.opos.mobad.n.g;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.n.a;

/* loaded from: classes4.dex */
public class z extends RelativeLayout {

    /* renamed from: a */
    private TextView f22799a;

    /* renamed from: b */
    private TextView f22800b;

    /* renamed from: c */
    private TextView f22801c;

    /* renamed from: d */
    private TextView f22802d;

    /* renamed from: e */
    private TextView f22803e;

    /* renamed from: f */
    private TextView f22804f;

    /* renamed from: g */
    private TextView f22805g;

    /* renamed from: h */
    private String f22806h;

    /* renamed from: i */
    private String f22807i;

    /* renamed from: j */
    private String f22808j;
    private String k;
    private String l;
    private a.InterfaceC0458a m;

    /* renamed from: com.opos.mobad.n.g.z$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (z.this.m != null) {
                z.this.m.c(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.z$2 */
    class AnonymousClass2 extends com.opos.mobad.n.c.g {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (z.this.m != null) {
                z.this.m.b(view, iArr);
            }
        }
    }

    public z(Context context, int i2, boolean z) {
        super(context);
        this.f22806h = "#8CFFFFFF";
        this.f22807i = "#4DFFFFFF";
        this.f22808j = "#D9FFFFFF";
        this.k = "#2F80ED";
        this.l = "#3B000000";
        a(i2, z);
    }

    public static z a(Context context) {
        return new z(context, 1, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 788
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.n.g.z.a(int, boolean):void");
    }

    public static z b(Context context) {
        return new z(context, 0, false);
    }

    public static z c(Context context) {
        return new z(context, 0, true);
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        com.opos.cmn.an.f.a.b("BlockPrivacyView", "setListener " + interfaceC0458a);
        this.m = interfaceC0458a;
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f22799a.setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f22801c.setText(str2);
    }
}
