package com.wbl.ad.yzz.help;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.cdo.oaps.ad.OapsKey;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.wbl.ad.yzz.bean.p;
import com.wbl.ad.yzz.bean.r;
import com.wbl.ad.yzz.config.IAdParams;
import com.wbl.ad.yzz.download.c;
import com.wbl.ad.yzz.network.b.b.u;
import com.wbl.ad.yzz.network.c.d;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class l {

    /* renamed from: d */
    public static int f32692d;

    /* renamed from: a */
    public boolean f32695a;

    /* renamed from: b */
    public com.wbl.ad.yzz.download.k.a f32696b;

    /* renamed from: c */
    public c.b f32697c;

    /* renamed from: f */
    @f.b.a.d
    public static final a f32694f = new a(null);

    /* renamed from: e */
    public static final j f32693e = new j();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bN\u0010!J5\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0011J-\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u000f\u0010\u0015J#\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\n\u0010\u0017J+\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0018J\u0019\u0010\u000f\u001a\u00020\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u001aJ+\u0010\u000f\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u000f\u0010\u001fJ5\u0010\u000f\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u000f\u0010 J\r\u0010\n\u001a\u00020\u0019¢\u0006\u0004\b\n\u0010!J\r\u0010\"\u001a\u00020\b¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u000f\u001a\u00020\u00192\b\u0010$\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u000f\u0010%J3\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010$\u001a\u0004\u0018\u00010\u001d2\b\u0010&\u001a\u0004\u0018\u00010\u00122\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b\u000f\u0010)J!\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010&\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000f\u0010\u0017J)\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010&\u001a\u0004\u0018\u00010\u00122\u0006\u0010*\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010+J+\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\n\u0010\u0015J!\u0010,\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b,\u0010\u0017J!\u0010/\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b/\u00100J+\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000f\u00101J3\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u000bJ!\u0010\"\u001a\u00020\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\"\u00102J\u0017\u00103\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b3\u00104J\u0017\u0010,\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b,\u00104J\u0015\u00105\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b5\u00104J\u0017\u00106\u001a\u00020\u00192\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b6\u00107J\u0017\u0010\n\u001a\u00020\u00122\b\u00108\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u00109J\u0017\u0010\u000f\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010:J\u0017\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000f\u00104J\u0019\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010;J\u0019\u0010\"\u001a\u0004\u0018\u00010\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\"\u00109J\u0017\u0010\u000f\u001a\u00020\b2\b\u0010=\u001a\u0004\u0018\u00010<¢\u0006\u0004\b\u000f\u0010>J\u0017\u0010?\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b?\u00104J!\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010@J\u0017\u0010\u000f\u001a\u00020\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000f\u0010AJ\u0017\u0010\n\u001a\u00020\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\n\u0010AJ\r\u0010\u000f\u001a\u00020\u0019¢\u0006\u0004\b\u000f\u0010!R\u0016\u0010B\u001a\u00020'8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020'8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\bD\u0010CR\u0016\u0010E\u001a\u00020'8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\bE\u0010CR\u0016\u0010F\u001a\u00020'8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bF\u0010CR\u0016\u0010G\u001a\u00020\u00128\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020'8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bI\u0010CR\u0016\u0010J\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010CR\u0016\u0010L\u001a\u00020K8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010M¨\u0006O"}, d2 = {"com/wbl/ad/yzz/help/l$a", "", "Landroid/content/Context;", "context", "Lcom/wbl/ad/yzz/bean/b;", "adDataBean", "Lcom/wbl/ad/yzz/bean/r;", "bean", "", "isInstallApp", "b", "(Landroid/content/Context;Lcom/wbl/ad/yzz/bean/b;Lcom/wbl/ad/yzz/bean/r;Z)Z", "Lcom/wbl/ad/yzz/bean/p;", "link", "yzzAdBean", "a", "(Landroid/content/Context;Lcom/wbl/ad/yzz/bean/p;Lcom/wbl/ad/yzz/bean/b;Lcom/wbl/ad/yzz/bean/r;)Z", "(Landroid/content/Context;Lcom/wbl/ad/yzz/bean/p;)Z", "", DBDefinition.PACKAGE_NAME, "class_name", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z", "scheme", "(Landroid/content/Context;Ljava/lang/String;)Z", "(Landroid/content/Context;Lcom/wbl/ad/yzz/bean/p;Lcom/wbl/ad/yzz/bean/r;)Z", "", "(Landroid/content/Context;)V", "url", "position", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "scene", "(Ljava/lang/String;Ljava/lang/String;Lcom/wbl/ad/yzz/innerconfig/d/d;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/wbl/ad/yzz/bean/b;Lcom/wbl/ad/yzz/innerconfig/d/d;)V", "()V", "c", "()Z", "sceneCache", "(Lcom/wbl/ad/yzz/innerconfig/d/d;)V", "uri", "", "vipType", "(Landroid/content/Context;Lcom/wbl/ad/yzz/innerconfig/d/d;Ljava/lang/String;I)Z", "newTask", "(Landroid/content/Context;Ljava/lang/String;Z)Z", "d", "Landroid/content/Intent;", "intent", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;)Z", "(Landroid/content/Context;Lcom/wbl/ad/yzz/bean/b;Lcom/wbl/ad/yzz/bean/r;)Z", "(Landroid/content/Context;Ljava/lang/String;)V", OapsKey.KEY_GRADE, "(Lcom/wbl/ad/yzz/bean/r;)Z", "f", "h", "(Lcom/wbl/ad/yzz/bean/r;)V", "yzz", "(Lcom/wbl/ad/yzz/bean/r;)Ljava/lang/String;", "(Lcom/wbl/ad/yzz/bean/b;)Z", "(Lcom/wbl/ad/yzz/bean/b;)Lcom/wbl/ad/yzz/bean/r;", "Lcom/wbl/ad/yzz/network/b/b/u$b;", "conf", "(Lcom/wbl/ad/yzz/network/b/b/u$b;)Z", com.kwad.sdk.ranger.e.TAG, "(Landroid/content/Context;Lcom/wbl/ad/yzz/bean/b;)Z", "(Ljava/lang/String;)V", "SCHEME_TYPE_FEED_VIP", "I", "SCHEME_TYPE_GUIDE_VIP", "SCHEME_TYPE_NONE", "SHOW_INSTALLATION_TIPS", "TAG", "Ljava/lang/String;", "TYPE_IS_DOWNLOAD", "currentSchemeType", "Lcom/wbl/ad/yzz/help/j;", "mInstallStatusHelper", "Lcom/wbl/ad/yzz/help/j;", "<init>", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {

        /* renamed from: com.wbl.ad.yzz.help.l$a$a */
        public static final class C0748a implements IAdParams {

            /* renamed from: a */
            public final /* synthetic */ boolean f32698a;

            /* renamed from: b */
            public final /* synthetic */ boolean f32699b;

            public C0748a(boolean z, boolean z2) {
                this.f32698a = z;
                this.f32699b = z2;
            }

            @Override // com.wbl.ad.yzz.config.IAdParams
            public boolean isOpenActivity() {
                return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13819, this, null);
            }

            @Override // com.wbl.ad.yzz.config.IAdParams
            public boolean isOpenShare() {
                return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13814, this, null);
            }
        }

        public a() {
        }

        public final void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13813, this, null);
        }

        public final void a(Context context) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13816, this, context);
        }

        public final void a(com.wbl.ad.yzz.innerconfig.d.d sceneCache) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13815, this, sceneCache);
        }

        public final void a(String r3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13810, this, r3);
        }

        public final void a(String url, String position, com.wbl.ad.yzz.bean.b adDataBean, com.wbl.ad.yzz.innerconfig.d.d scene) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13809, this, url, position, adDataBean, scene);
        }

        public final void a(String url, String position, com.wbl.ad.yzz.innerconfig.d.d scene) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13812, this, url, position, scene);
        }

        public final boolean a(Context context, com.wbl.ad.yzz.bean.b adDataBean) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13811, this, context, adDataBean);
        }

        public final boolean a(Context context, com.wbl.ad.yzz.bean.b adDataBean, r bean) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13774, this, context, adDataBean, bean);
        }

        public final boolean a(Context context, com.wbl.ad.yzz.bean.b adDataBean, r yzzAdBean, boolean isInstallApp) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13773, this, context, adDataBean, yzzAdBean, Boolean.valueOf(isInstallApp));
        }

        public final boolean a(Context context, p link) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13776, this, context, link);
        }

        public final boolean a(Context context, p link, com.wbl.ad.yzz.bean.b adDataBean, r yzzAdBean) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13775, this, context, link, adDataBean, yzzAdBean);
        }

        public final boolean a(Context context, p link, r yzzAdBean) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13770, this, context, link, yzzAdBean);
        }

        public final boolean a(Context context, com.wbl.ad.yzz.innerconfig.d.d sceneCache, String uri, int vipType) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13769, this, context, sceneCache, uri, Integer.valueOf(vipType));
        }

        public final boolean a(Context context, String uri) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13772, this, context, uri);
        }

        public final boolean a(Context context, String r4, String class_name) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13771, this, context, r4, class_name);
        }

        public final boolean a(Context context, String uri, boolean newTask) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13766, this, context, uri, Boolean.valueOf(newTask));
        }

        public final boolean a(com.wbl.ad.yzz.bean.b bean) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13765, this, bean);
        }

        public final boolean a(r yzzAdBean) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13768, this, yzzAdBean);
        }

        public final boolean a(u.b conf) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13767, this, conf);
        }

        public final r b(com.wbl.ad.yzz.bean.b bean) {
            return (r) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13762, this, bean);
        }

        public final String b(r yzz) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13761, this, yzz);
        }

        public final void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13764, this, null);
        }

        public final void b(String r3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13763, this, r3);
        }

        public final boolean b(Context context, com.wbl.ad.yzz.bean.b adDataBean, r bean, boolean isInstallApp) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13790, this, context, adDataBean, bean, Boolean.valueOf(isInstallApp));
        }

        public final boolean b(Context context, String scheme) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13789, this, context, scheme);
        }

        public final boolean b(Context context, String url, String scene) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13792, this, context, url, scene);
        }

        public final String c(r yzzAdBean) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13791, this, yzzAdBean);
        }

        public final void c(Context context, String scene) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13786, this, context, scene);
        }

        public final boolean c() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13785, this, null);
        }

        public final boolean d(Context context, String url) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13788, this, context, url);
        }

        public final boolean d(r yzzAdBean) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13787, this, yzzAdBean);
        }

        public final boolean e(r rVar) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13782, this, rVar);
        }

        public final boolean f(r yzzAdBean) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13781, this, yzzAdBean);
        }

        public final boolean g(r rVar) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13784, this, rVar);
        }

        public final void h(r yzzAdBean) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13783, this, yzzAdBean);
        }

        public final boolean startActivity(Context context, Intent intent) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13778, this, context, intent);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements d.b0<Object> {
        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onFailed(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13777, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onSuccess(String str, Object obj) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13780, this, str, obj);
        }
    }

    public static final class c extends c.b {

        /* renamed from: b */
        @f.b.a.d
        public final WeakReference<Activity> f32700b;

        /* renamed from: c */
        @f.b.a.d
        public final WeakReference<com.wbl.ad.yzz.adapter.c.b> f32701c;

        /* renamed from: e */
        public final /* synthetic */ r f32703e;

        /* renamed from: f */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32704f;

        /* renamed from: g */
        public final /* synthetic */ String f32705g;

        /* renamed from: h */
        public final /* synthetic */ int f32706h;

        /* renamed from: i */
        public final /* synthetic */ String f32707i;

        /* renamed from: j */
        public final /* synthetic */ String f32708j;
        public final /* synthetic */ String k;
        public final /* synthetic */ boolean l;
        public final /* synthetic */ com.wbl.ad.yzz.adapter.c.b m;

        public c(r rVar, com.wbl.ad.yzz.bean.b bVar, String str, int i2, String str2, String str3, String str4, boolean z, Activity activity, com.wbl.ad.yzz.adapter.c.b bVar2) {
            this.f32703e = rVar;
            this.f32704f = bVar;
            this.f32705g = str;
            this.f32706h = i2;
            this.f32707i = str2;
            this.f32708j = str3;
            this.k = str4;
            this.l = z;
            this.m = bVar2;
            this.f32700b = new WeakReference<>(activity);
            this.f32701c = new WeakReference<>(bVar2);
        }

        @Override // com.wbl.ad.yzz.download.c.b
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13779, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.download.c.b
        public void a(com.wbl.ad.yzz.download.h.c cVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12846, this, cVar);
        }

        @Override // com.wbl.ad.yzz.download.c.b
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12845, this, null);
        }

        @Override // com.wbl.ad.yzz.download.c.b
        public void b(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12848, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.download.c.b
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12847, this, null);
        }

        @Override // com.wbl.ad.yzz.download.c.b
        public void d() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12842, this, null);
        }

        @Override // com.wbl.ad.yzz.download.c.b
        public void e() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12841, this, null);
        }

        @Override // com.wbl.ad.yzz.download.c.b
        public void f() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12844, this, null);
        }
    }

    public static final /* synthetic */ j b() {
        return (j) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12837, null, null);
    }

    public final void a(Activity activity, com.wbl.ad.yzz.bean.b bVar, r rVar, String str, int i2, String str2, String str3, String str4, boolean z, com.wbl.ad.yzz.adapter.c.b bVar2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12840, this, activity, bVar, rVar, str, Integer.valueOf(i2), str2, str3, str4, Boolean.valueOf(z), bVar2);
    }

    public final void a(@f.b.a.e Activity activity, @f.b.a.e com.wbl.ad.yzz.bean.b bVar, @f.b.a.e r rVar, @f.b.a.d String channel, int i2, @f.b.a.d String actionType, @f.b.a.d String adType, @f.b.a.d String clickType, boolean z, boolean z2, boolean z3, @f.b.a.e com.wbl.ad.yzz.adapter.c.b bVar2) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(clickType, "clickType");
        if (bVar == null || activity == null) {
            return;
        }
        a aVar = f32694f;
        if (aVar.a(bVar)) {
            bVar.a(false);
            c cVar = new c(rVar, bVar, channel, i2, adType, clickType, actionType, z3, activity, bVar2);
            this.f32697c = cVar;
            a(activity, bVar, z, cVar);
            return;
        }
        this.f32697c = null;
        try {
            aVar.a(activity, bVar, rVar);
            if (bVar2 != null) {
                bVar2.a(bVar, channel, String.valueOf(i2), actionType, adType, clickType);
            }
        } catch (Throwable th) {
            Log.e("StartUpHelper", "clickCus = " + th.getMessage());
        }
    }

    public final void a(Activity activity, com.wbl.ad.yzz.bean.b bVar, boolean z, c.b bVar2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12839, this, activity, bVar, Boolean.valueOf(z), bVar2);
    }

    public final void a(Activity activity, r rVar, String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12834, this, activity, rVar, str, str2);
    }

    public final void a(u.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12833, this, bVar);
    }

    public final boolean b(int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12836, this, Integer.valueOf(i2));
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12835, this, null);
    }

    public final boolean c(int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12862, this, Integer.valueOf(i2));
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12861, this, null);
    }
}
