package org.codechimp.apprater;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a */
    private static final String f35359a = "apprater";

    /* renamed from: b */
    private static final String f35360b = "launch_count";

    /* renamed from: c */
    private static final String f35361c = "date_firstlaunch";

    /* renamed from: d */
    private static final String f35362d = "dontshowagain";

    /* renamed from: e */
    private static final String f35363e = "remindmelater";

    /* renamed from: f */
    private static final String f35364f = "app_version_name";

    /* renamed from: g */
    private static final String f35365g = "app_version_code";

    /* renamed from: h */
    private static final int f35366h = 3;

    /* renamed from: i */
    private static final int f35367i = 7;

    /* renamed from: j */
    private static int f35368j = 3;
    private static int k = 7;
    private static boolean l = false;
    private static boolean m = false;
    private static boolean n = false;
    private static boolean o = false;
    private static boolean p = false;
    private static boolean q = true;
    private static f r = new e();

    static class a implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ Context f35369a;

        /* renamed from: b */
        final /* synthetic */ SharedPreferences.Editor f35370b;

        a(Context context, SharedPreferences.Editor editor) {
            this.f35369a = context;
            this.f35370b = editor;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            b.g(this.f35369a);
            SharedPreferences.Editor editor = this.f35370b;
            if (editor != null) {
                editor.putBoolean(b.f35362d, true);
                b.e(this.f35370b);
            }
            dialogInterface.dismiss();
        }
    }

    /* renamed from: org.codechimp.apprater.b$b */
    static class DialogInterfaceOnClickListenerC0830b implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ SharedPreferences.Editor f35371a;

        DialogInterfaceOnClickListenerC0830b(SharedPreferences.Editor editor) {
            this.f35371a = editor;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (this.f35371a != null) {
                this.f35371a.putLong(b.f35361c, Long.valueOf(System.currentTimeMillis()).longValue());
                this.f35371a.putLong(b.f35360b, 0L);
                this.f35371a.putBoolean(b.f35363e, true);
                this.f35371a.putBoolean(b.f35362d, false);
                b.e(this.f35371a);
            }
            dialogInterface.dismiss();
        }
    }

    static class c implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ SharedPreferences.Editor f35372a;

        c(SharedPreferences.Editor editor) {
            this.f35372a = editor;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            SharedPreferences.Editor editor = this.f35372a;
            if (editor != null) {
                editor.putBoolean(b.f35362d, true);
                this.f35372a.putBoolean(b.f35363e, false);
                this.f35372a.putLong(b.f35361c, System.currentTimeMillis());
                this.f35372a.putLong(b.f35360b, 0L);
                b.e(this.f35372a);
            }
            dialogInterface.dismiss();
        }
    }

    public static void b(Context context) {
        c(context, 3, 7);
    }

    public static void c(Context context, int i2, int i3) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f35359a, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        org.codechimp.apprater.c a2 = org.codechimp.apprater.c.a(context);
        if (o && !a2.d().equals(sharedPreferences.getString(f35364f, com.baidu.mobads.sdk.internal.a.f5472a))) {
            edit.putString(f35364f, a2.d());
            h(context);
            e(edit);
        }
        if (p && a2.c() != sharedPreferences.getInt(f35365g, -1)) {
            edit.putInt(f35365g, a2.c());
            h(context);
            e(edit);
        }
        if (sharedPreferences.getBoolean(f35362d, false)) {
            return;
        }
        if (sharedPreferences.getBoolean(f35363e, false)) {
            i2 = f35368j;
            i3 = k;
        }
        long j2 = sharedPreferences.getLong(f35360b, 0L) + 1;
        edit.putLong(f35360b, j2);
        Long valueOf = Long.valueOf(sharedPreferences.getLong(f35361c, 0L));
        if (valueOf.longValue() == 0) {
            valueOf = Long.valueOf(System.currentTimeMillis());
            edit.putLong(f35361c, valueOf.longValue());
        }
        if (j2 >= i3 || System.currentTimeMillis() >= valueOf.longValue() + (i2 * 24 * 60 * 60 * 1000)) {
            r(context, edit);
        }
        e(edit);
    }

    public static void d(Context context, int i2, int i3, int i4, int i5) {
        n(i4);
        o(i5);
        c(context, i2, i3);
    }

    @SuppressLint({"NewApi"})
    public static void e(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT > 8) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public static f f() {
        return r;
    }

    public static void g(Context context) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", r.a(context)));
        } catch (ActivityNotFoundException unused) {
            Log.e(b.class.getSimpleName(), "Market Intent not found");
        }
    }

    public static void h(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(f35359a, 0).edit();
        edit.putBoolean(f35362d, false);
        edit.putBoolean(f35363e, false);
        edit.putLong(f35360b, 0L);
        edit.putLong(f35361c, System.currentTimeMillis());
        e(edit);
    }

    public static void i(boolean z) {
        q = z;
    }

    @TargetApi(11)
    public static void j() {
        l = true;
        m = true;
    }

    public static void k(boolean z) {
        n = z;
    }

    @TargetApi(11)
    public static void l() {
        l = false;
        m = true;
    }

    public static void m(f fVar) {
        r = fVar;
    }

    public static void n(int i2) {
        f35368j = i2;
    }

    public static void o(int i2) {
        k = i2;
    }

    public static void p(boolean z) {
        p = z;
    }

    public static void q(boolean z) {
        o = z;
    }

    @SuppressLint({"NewApi"})
    private static void r(Context context, SharedPreferences.Editor editor) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT < 11 || !m) {
            builder = new AlertDialog.Builder(context);
        } else {
            builder = new AlertDialog.Builder(context, l ? 2 : 3);
        }
        builder.setTitle(String.format(context.getString(R.string.dialog_title), org.codechimp.apprater.c.a(context).b()));
        builder.setMessage(context.getString(R.string.rate_message));
        builder.setCancelable(q);
        builder.setPositiveButton(context.getString(R.string.rate), new a(context, editor));
        builder.setNeutralButton(context.getString(R.string.later), new DialogInterfaceOnClickListenerC0830b(editor));
        if (!n) {
            builder.setNegativeButton(context.getString(R.string.no_thanks), new c(editor));
        }
        builder.show();
    }

    public static void s(Context context) {
        r(context, null);
    }
}
