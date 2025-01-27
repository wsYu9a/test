package org.codechimp.apprater;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import vi.d;
import vi.e;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public static final String f29205a = "apprater";

    /* renamed from: b */
    public static final String f29206b = "launch_count";

    /* renamed from: c */
    public static final String f29207c = "date_firstlaunch";

    /* renamed from: d */
    public static final String f29208d = "dontshowagain";

    /* renamed from: e */
    public static final String f29209e = "remindmelater";

    /* renamed from: f */
    public static final String f29210f = "app_version_name";

    /* renamed from: g */
    public static final String f29211g = "app_version_code";

    /* renamed from: h */
    public static final int f29212h = 3;

    /* renamed from: i */
    public static final int f29213i = 7;

    /* renamed from: j */
    public static int f29214j = 3;

    /* renamed from: k */
    public static int f29215k = 7;

    /* renamed from: l */
    public static boolean f29216l = false;

    /* renamed from: m */
    public static boolean f29217m = false;

    /* renamed from: n */
    public static boolean f29218n = false;

    /* renamed from: o */
    public static boolean f29219o = false;

    /* renamed from: p */
    public static boolean f29220p = false;

    /* renamed from: q */
    public static boolean f29221q = true;

    /* renamed from: r */
    public static e f29222r = new d();

    /* renamed from: org.codechimp.apprater.a$a */
    public static class DialogInterfaceOnClickListenerC0755a implements DialogInterface.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ Context f29223b;

        /* renamed from: c */
        public final /* synthetic */ SharedPreferences.Editor f29224c;

        public DialogInterfaceOnClickListenerC0755a(Context context, SharedPreferences.Editor editor) {
            this.f29223b = context;
            this.f29224c = editor;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            a.g(this.f29223b);
            SharedPreferences.Editor editor = this.f29224c;
            if (editor != null) {
                editor.putBoolean(a.f29208d, true);
                a.e(this.f29224c);
            }
            dialogInterface.dismiss();
        }
    }

    public static class b implements DialogInterface.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ SharedPreferences.Editor f29225b;

        public b(SharedPreferences.Editor editor) {
            this.f29225b = editor;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (this.f29225b != null) {
                this.f29225b.putLong(a.f29207c, System.currentTimeMillis());
                this.f29225b.putLong(a.f29206b, 0L);
                this.f29225b.putBoolean(a.f29209e, true);
                this.f29225b.putBoolean(a.f29208d, false);
                a.e(this.f29225b);
            }
            dialogInterface.dismiss();
        }
    }

    public static class c implements DialogInterface.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ SharedPreferences.Editor f29226b;

        public c(SharedPreferences.Editor editor) {
            this.f29226b = editor;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            SharedPreferences.Editor editor = this.f29226b;
            if (editor != null) {
                editor.putBoolean(a.f29208d, true);
                this.f29226b.putBoolean(a.f29209e, false);
                this.f29226b.putLong(a.f29207c, System.currentTimeMillis());
                this.f29226b.putLong(a.f29206b, 0L);
                a.e(this.f29226b);
            }
            dialogInterface.dismiss();
        }
    }

    public static void b(Context context) {
        c(context, 3, 7);
    }

    public static void c(Context context, int i10, int i11) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f29205a, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        vi.b a10 = vi.b.a(context);
        if (f29219o && !a10.d().equals(sharedPreferences.getString(f29210f, "none"))) {
            edit.putString(f29210f, a10.d());
            h(context);
            e(edit);
        }
        if (f29220p && a10.c() != sharedPreferences.getInt(f29211g, -1)) {
            edit.putInt(f29211g, a10.c());
            h(context);
            e(edit);
        }
        if (sharedPreferences.getBoolean(f29208d, false)) {
            return;
        }
        if (sharedPreferences.getBoolean(f29209e, false)) {
            i10 = f29214j;
            i11 = f29215k;
        }
        long j10 = sharedPreferences.getLong(f29206b, 0L) + 1;
        edit.putLong(f29206b, j10);
        long j11 = sharedPreferences.getLong(f29207c, 0L);
        Long valueOf = Long.valueOf(j11);
        if (j11 == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            valueOf = Long.valueOf(currentTimeMillis);
            edit.putLong(f29207c, currentTimeMillis);
        }
        if (j10 >= i11 || System.currentTimeMillis() >= valueOf.longValue() + (i10 * 86400000)) {
            r(context, edit);
        }
        e(edit);
    }

    public static void d(Context context, int i10, int i11, int i12, int i13) {
        n(i12);
        o(i13);
        c(context, i10, i11);
    }

    @SuppressLint({"NewApi"})
    public static void e(SharedPreferences.Editor editor) {
        editor.apply();
    }

    public static e f() {
        return f29222r;
    }

    public static void g(Context context) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", f29222r.a(context)));
        } catch (ActivityNotFoundException unused) {
            Log.e(a.class.getSimpleName(), "Market Intent not found");
        }
    }

    public static void h(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(f29205a, 0).edit();
        edit.putBoolean(f29208d, false);
        edit.putBoolean(f29209e, false);
        edit.putLong(f29206b, 0L);
        edit.putLong(f29207c, System.currentTimeMillis());
        e(edit);
    }

    public static void i(boolean z10) {
        f29221q = z10;
    }

    @TargetApi(11)
    public static void j() {
        f29216l = true;
        f29217m = true;
    }

    public static void k(boolean z10) {
        f29218n = z10;
    }

    @TargetApi(11)
    public static void l() {
        f29216l = false;
        f29217m = true;
    }

    public static void m(e eVar) {
        f29222r = eVar;
    }

    public static void n(int i10) {
        f29214j = i10;
    }

    public static void o(int i10) {
        f29215k = i10;
    }

    public static void p(boolean z10) {
        f29220p = z10;
    }

    public static void q(boolean z10) {
        f29219o = z10;
    }

    @SuppressLint({"NewApi"})
    public static void r(Context context, SharedPreferences.Editor editor) {
        AlertDialog.Builder builder;
        if (f29217m) {
            builder = new AlertDialog.Builder(context, f29216l ? 2 : 3);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setTitle(String.format(context.getString(R.string.dialog_title), vi.b.a(context).b()));
        builder.setMessage(context.getString(R.string.rate_message));
        builder.setCancelable(f29221q);
        builder.setPositiveButton(context.getString(R.string.rate), new DialogInterfaceOnClickListenerC0755a(context, editor));
        builder.setNeutralButton(context.getString(R.string.later), new b(editor));
        if (!f29218n) {
            builder.setNegativeButton(context.getString(R.string.no_thanks), new c(editor));
        }
        builder.show();
    }

    public static void s(Context context) {
        r(context, null);
    }
}
