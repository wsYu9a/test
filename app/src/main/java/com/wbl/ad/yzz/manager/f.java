package com.wbl.ad.yzz.manager;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.help.e;
import com.wbl.ad.yzz.network.b.b.u;
import com.wbl.ad.yzz.util.NetworkUtils;
import java.util.HashMap;

/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a */
    public final HashMap<Integer, Integer> f32887a = new HashMap<>();

    /* renamed from: b */
    public final HashMap<Integer, e.b> f32888b = new HashMap<>();

    /* renamed from: c */
    @f.b.a.e
    public Dialog f32889c;

    /* renamed from: d */
    @f.b.a.e
    public com.wbl.ad.yzz.dialog.j f32890d;

    /* renamed from: e */
    public u.d f32891e;

    /* renamed from: f */
    public u.d f32892f;

    /* renamed from: g */
    public u.c f32893g;

    /* renamed from: h */
    public NetworkUtils.NetworkType f32894h;

    /* renamed from: i */
    @f.b.a.e
    public Context f32895i;

    /* renamed from: j */
    public boolean f32896j;
    public u.b k;

    public static final class a implements DialogInterface.OnDismissListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12289, this, dialogInterface);
        }
    }

    public final e.b a(int i2, String str) {
        return (e.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12292, this, Integer.valueOf(i2), str);
    }

    public final com.wbl.ad.yzz.help.e a() {
        return (com.wbl.ad.yzz.help.e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12291, this, null);
    }

    public final com.wbl.ad.yzz.help.e a(com.wbl.ad.yzz.bean.b bVar) {
        return (com.wbl.ad.yzz.help.e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12318, this, bVar);
    }

    public final u.d a(String str) {
        return (u.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12317, this, str);
    }

    public final void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12320, this, Integer.valueOf(i2));
    }

    public final void a(int i2, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12319, this, Integer.valueOf(i2), Boolean.valueOf(z));
    }

    public final void a(Dialog dialog) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12314, this, dialog);
    }

    public final void a(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12313, this, context);
    }

    public final void a(Context context, String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12316, this, context, str, str2);
    }

    public final void a(com.wbl.ad.yzz.dialog.j jVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12315, this, jVar);
    }

    public final void a(u.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12310, this, bVar);
    }

    public final boolean a(Integer num) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12309, this, num);
    }

    public final e.b b(int i2) {
        return (e.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12312, this, Integer.valueOf(i2));
    }

    public final com.wbl.ad.yzz.help.e b() {
        return (com.wbl.ad.yzz.help.e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12311, this, null);
    }

    public final boolean b(int i2, String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12306, this, Integer.valueOf(i2), str);
    }

    public final boolean b(String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12305, this, str);
    }

    public final com.wbl.ad.yzz.help.e c() {
        return (com.wbl.ad.yzz.help.e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12308, this, null);
    }

    public final String c(String str) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12307, this, str);
    }

    public final boolean c(int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12398, this, Integer.valueOf(i2));
    }

    public final com.wbl.ad.yzz.help.e d() {
        return (com.wbl.ad.yzz.help.e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12397, this, null);
    }

    public final boolean d(int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12400, this, Integer.valueOf(i2));
    }

    public final void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12399, this, null);
    }

    public final boolean e(int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12394, this, Integer.valueOf(i2));
    }

    public final void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12393, this, null);
    }

    public final boolean f(int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12396, this, Integer.valueOf(i2));
    }

    public final String g() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12395, this, null);
    }

    public final boolean g(int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12390, this, Integer.valueOf(i2));
    }

    public final boolean h() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12389, this, null);
    }

    public final boolean h(int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12392, this, Integer.valueOf(i2));
    }

    public final String i() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12391, this, null);
    }

    public final void i(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12386, this, Integer.valueOf(i2));
    }

    public final Dialog j() {
        return (Dialog) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12385, this, null);
    }

    public final void j(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12388, this, Integer.valueOf(i2));
    }

    public final com.wbl.ad.yzz.dialog.j k() {
        return (com.wbl.ad.yzz.dialog.j) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12387, this, null);
    }

    public final NetworkUtils.NetworkType l() {
        return (NetworkUtils.NetworkType) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12414, this, null);
    }

    public final String m() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12413, this, null);
    }

    public final boolean n() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12416, this, null);
    }

    public final boolean o() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12415, this, null);
    }

    public final void p() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12410, this, null);
    }
}
