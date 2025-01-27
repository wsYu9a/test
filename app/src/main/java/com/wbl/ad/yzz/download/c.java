package com.wbl.ad.yzz.download;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.cdo.oaps.ad.OapsWrapper;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.wbl.ad.yzz.bean.r;
import com.wbl.ad.yzz.download.h.i;
import com.wbl.ad.yzz.network.b.b.u;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: e */
    @f.b.a.d
    public static final a f31963e = new a(null);

    /* renamed from: b */
    public static final HashMap<String, i> f31960b = new HashMap<>();

    /* renamed from: c */
    public static final Map<String, b> f31961c = new LinkedHashMap();

    /* renamed from: d */
    public static final com.wbl.ad.yzz.download.h.d f31962d = new com.wbl.ad.yzz.download.h.d();

    /* renamed from: a */
    @f.b.a.d
    public static final g f31959a = new g();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bX\u0010#JA\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJS\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\f\u0010\u0016J!\u0010\f\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\f\u0010\u001aJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\f\u0010\u001cJI\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001b\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\f\u0010\u001fJ\u0019\u0010!\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010#J\u0019\u0010\f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\f\u0010\"J\u000f\u0010$\u001a\u00020\u000bH\u0002¢\u0006\u0004\b$\u0010#J\u0019\u0010%\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b%\u0010\"J\u0019\u0010$\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b$\u0010(J!\u0010\f\u001a\u00020'2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\f\u0010)J5\u0010\f\u001a\u00020'2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010+\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\f\u0010,J\u0017\u0010.\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u0004H\u0002¢\u0006\u0004\b.\u0010\"J9\u0010\f\u001a\u0004\u0018\u00010\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00142\b\u0010\u0003\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\f\u0010/JA\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u00100\u001a\u00020\u00042\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u000101H\u0002¢\u0006\u0004\b\f\u00103J+\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u001e\u001a\u0004\u0018\u000104¢\u0006\u0004\b\f\u00105J+\u00106\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010+\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b6\u00107J3\u00106\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u00108\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b6\u00109J!\u0010\f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\f\u0010:J!\u0010\f\u001a\u00020'2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000e2\b\u0010*\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\f\u0010;J!\u0010\f\u001a\u00020'2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010<J\u0017\u0010\f\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010=¢\u0006\u0004\b\f\u0010?J\r\u0010!\u001a\u00020\u000b¢\u0006\u0004\b!\u0010#J=\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000e2\b\u0010@\u001a\u0004\u0018\u00010\u00042\u0006\u0010A\u001a\u00020'2\b\u0010C\u001a\u0004\u0018\u00010B2\b\u0010+\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\f\u0010DJ3\u0010\f\u001a\u00020\u000b2\b\u0010E\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010G\u001a\u00020F2\b\u0010H\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\f\u0010IR\u0019\u0010K\u001a\u00020J8\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\b%\u0010MR&\u0010O\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00140N8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010R\u001a\u00020Q8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR:\u00102\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010U0Tj\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010U`V8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010W¨\u0006Y"}, d2 = {"com/wbl/ad/yzz/download/c$a", "", "Landroid/content/Context;", "context", "", "key", "url", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "sceneCache", "Lcom/wbl/ad/yzz/network/b/b/u$b;", "conf", "", "a", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/wbl/ad/yzz/innerconfig/d/d;Lcom/wbl/ad/yzz/network/b/b/u$b;)V", "Landroid/app/Activity;", "sceneTag", "package_name", "kpa_mda5", "Lcom/wbl/ad/yzz/bean/r;", DBDefinition.SEGMENT_INFO, "Lcom/wbl/ad/yzz/download/c$b;", "onApkListenerDelegate", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/wbl/ad/yzz/bean/r;Lcom/wbl/ad/yzz/download/c$b;)V", "yzzAdBean", "", "code", "(Lcom/wbl/ad/yzz/bean/r;I)V", "listener", "(Lcom/wbl/ad/yzz/download/c$b;)V", "Lcom/wbl/ad/yzz/bean/b;", "bean", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/wbl/ad/yzz/bean/b;Lcom/wbl/ad/yzz/bean/r;Lcom/wbl/ad/yzz/download/c$b;)V", "pkgName", "d", "(Ljava/lang/String;)V", "()V", "b", "c", "packName", "", "(Ljava/lang/String;)Z", "(Landroid/content/Context;Ljava/lang/String;)Z", "adDataBean", "onApkListener", "(Landroid/content/Context;Lcom/wbl/ad/yzz/bean/b;Lcom/wbl/ad/yzz/bean/r;Lcom/wbl/ad/yzz/download/c$b;)Z", "absolutePath", com.kwad.sdk.ranger.e.TAG, "(Ljava/lang/String;Ljava/lang/String;Lcom/wbl/ad/yzz/download/c$b;Landroid/app/Activity;)Lcom/wbl/ad/yzz/download/c$b;", "eventName", "", "map", "(Landroid/content/Context;Lcom/wbl/ad/yzz/innerconfig/d/d;Ljava/lang/String;Ljava/util/Map;)V", "Lcom/wbl/ad/yzz/network/b/b/u;", "(Landroid/app/Activity;Lcom/wbl/ad/yzz/innerconfig/d/d;Lcom/wbl/ad/yzz/network/b/b/u;)V", "startActivity", "(Landroid/app/Activity;Lcom/wbl/ad/yzz/bean/b;Lcom/wbl/ad/yzz/download/c$b;)V", "isUseLinkSkip", "(Landroid/app/Activity;Lcom/wbl/ad/yzz/bean/b;ZLcom/wbl/ad/yzz/download/c$b;)V", "(Ljava/lang/String;Lcom/wbl/ad/yzz/download/c$b;)V", "(Landroid/app/Activity;Lcom/wbl/ad/yzz/bean/b;)Z", "(Landroid/app/Activity;Ljava/lang/String;)Z", "Landroid/content/Intent;", "intent", "(Landroid/content/Intent;)V", OapsWrapper.KEY_PATH, "isUserFragment", "Lcom/wbl/ad/yzz/fragment/a;", "actForResultCallback", "(Landroid/app/Activity;Ljava/lang/String;ZLcom/wbl/ad/yzz/fragment/a;Lcom/wbl/ad/yzz/download/c$b;)V", TTDownloadField.TT_ACTIVITY, "Lcom/wbl/ad/yzz/download/h/f;", "downloadInfo", com.alipay.sdk.authjs.a.f5376c, "(Landroid/app/Activity;Ljava/lang/String;Lcom/wbl/ad/yzz/download/h/f;Lcom/wbl/ad/yzz/download/c$b;)V", "Lcom/wbl/ad/yzz/download/g;", "manager", "Lcom/wbl/ad/yzz/download/g;", "()Lcom/wbl/ad/yzz/download/g;", "", "mAppInstallMap", "Ljava/util/Map;", "Lcom/wbl/ad/yzz/download/h/d;", "mDownloadStatusCache", "Lcom/wbl/ad/yzz/download/h/d;", "Ljava/util/HashMap;", "Lcom/wbl/ad/yzz/download/h/i;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "<init>", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {

        /* renamed from: com.wbl.ad.yzz.download.c$a$a */
        public static final class RunnableC0713a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ Activity f31964a;

            /* renamed from: b */
            public final /* synthetic */ com.wbl.ad.yzz.download.h.f f31965b;

            /* renamed from: c */
            public final /* synthetic */ b f31966c;

            /* renamed from: d */
            public final /* synthetic */ String f31967d;

            public RunnableC0713a(Activity activity, com.wbl.ad.yzz.download.h.f fVar, b bVar, String str) {
                this.f31964a = activity;
                this.f31965b = fVar;
                this.f31966c = bVar;
                this.f31967d = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14611, this, null);
            }
        }

        public static final class b extends b {

            /* renamed from: b */
            public final i f31968b;

            /* renamed from: c */
            public final /* synthetic */ b f31969c;

            /* renamed from: d */
            public final /* synthetic */ String f31970d;

            /* JADX WARN: Multi-variable type inference failed */
            public b(b bVar, String str, Ref.ObjectRef objectRef) {
                this.f31969c = bVar;
                this.f31970d = str;
                this.f31968b = (i) objectRef.element;
            }

            public final b a(i iVar, b bVar) {
                return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14702, this, iVar, bVar);
            }

            @Override // com.wbl.ad.yzz.download.c.b
            public void a(int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14701, this, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.download.c.b
            public void a(com.wbl.ad.yzz.download.f fVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14704, this, fVar);
            }

            @Override // com.wbl.ad.yzz.download.c.b
            public void a(com.wbl.ad.yzz.download.h.c cVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14703, this, cVar);
            }

            @Override // com.wbl.ad.yzz.download.c.b
            public void b() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14698, this, null);
            }

            @Override // com.wbl.ad.yzz.download.c.b
            public void b(int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14697, this, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.download.c.b
            public void c() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14700, this, null);
            }

            @Override // com.wbl.ad.yzz.download.c.b
            public void d() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14699, this, null);
            }

            @Override // com.wbl.ad.yzz.download.c.b
            public void e() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14694, this, null);
            }

            @Override // com.wbl.ad.yzz.download.c.b
            public void f() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14693, this, null);
            }
        }

        /* renamed from: com.wbl.ad.yzz.download.c$a$c */
        public static final class RunnableC0714c implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f31971a;

            public RunnableC0714c(String str) {
                this.f31971a = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14696, this, null);
            }
        }

        public static final class d extends com.wbl.ad.yzz.fragment.a {

            /* renamed from: a */
            public final /* synthetic */ com.wbl.ad.yzz.fragment.a f31972a;

            public d(com.wbl.ad.yzz.fragment.a aVar) {
                this.f31972a = aVar;
            }

            @Override // com.wbl.ad.yzz.fragment.a
            public void a(int i2, Intent intent) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14692, this, Integer.valueOf(i2), intent);
            }

            @Override // com.wbl.ad.yzz.fragment.a
            public void a(boolean z) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14691, this, Boolean.valueOf(z));
            }

            @Override // com.wbl.ad.yzz.fragment.a
            public void c(int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14718, this, Integer.valueOf(i2));
            }
        }

        public static final class e extends com.wbl.ad.yzz.download.f {

            /* renamed from: c */
            public boolean f31973c;

            /* renamed from: d */
            public final /* synthetic */ r f31974d;

            /* renamed from: e */
            public final /* synthetic */ b f31975e;

            /* renamed from: f */
            public final /* synthetic */ String f31976f;

            /* renamed from: g */
            public final /* synthetic */ String f31977g;

            /* renamed from: h */
            public final /* synthetic */ String f31978h;

            /* renamed from: i */
            public final /* synthetic */ String f31979i;

            /* renamed from: com.wbl.ad.yzz.download.c$a$e$a */
            public static final class RunnableC0715a implements Runnable {

                /* renamed from: b */
                public final /* synthetic */ Ref.ObjectRef f31981b;

                /* renamed from: c */
                public final /* synthetic */ com.wbl.ad.yzz.download.h.c f31982c;

                /* renamed from: com.wbl.ad.yzz.download.c$a$e$a$a */
                public static final class C0716a extends com.wbl.ad.yzz.fragment.a {

                    /* renamed from: b */
                    public final /* synthetic */ Activity f31984b;

                    public C0716a(Activity activity) {
                        this.f31984b = activity;
                    }

                    @Override // com.wbl.ad.yzz.fragment.a
                    public void a(int i2, Intent intent) {
                        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14717, this, Integer.valueOf(i2), intent);
                    }

                    @Override // com.wbl.ad.yzz.fragment.a
                    public void a(boolean z) {
                        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14720, this, Boolean.valueOf(z));
                    }

                    @Override // com.wbl.ad.yzz.fragment.a
                    public void c(int i2) {
                        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14719, this, Integer.valueOf(i2));
                    }
                }

                public RunnableC0715a(Ref.ObjectRef objectRef, com.wbl.ad.yzz.download.h.c cVar) {
                    this.f31981b = objectRef;
                    this.f31982c = cVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14714, this, null);
                }
            }

            public e(r rVar, b bVar, String str, String str2, String str3, String str4, boolean z) {
                this.f31974d = rVar;
                this.f31975e = bVar;
                this.f31976f = str;
                this.f31977g = str2;
                this.f31978h = str3;
                this.f31979i = str4;
                this.f31973c = z;
            }

            @Override // com.wbl.ad.yzz.download.f
            public void a(int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14712, this, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.download.f
            public void a(com.wbl.ad.yzz.download.h.c cVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14711, this, cVar);
            }

            @Override // com.wbl.ad.yzz.download.f
            public void b(com.wbl.ad.yzz.download.h.c cVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14706, this, cVar);
            }

            @Override // com.wbl.ad.yzz.download.f
            public void c() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14705, this, null);
            }

            public final boolean d() {
                return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14708, this, null);
            }
        }

        public static final class f extends com.wbl.ad.yzz.download.f {

            /* renamed from: c */
            public final /* synthetic */ String f31985c;

            /* renamed from: d */
            public final /* synthetic */ Context f31986d;

            /* renamed from: e */
            public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f31987e;

            /* renamed from: f */
            public final /* synthetic */ String f31988f;

            public f(String str, Context context, com.wbl.ad.yzz.innerconfig.d.d dVar, String str2) {
                this.f31985c = str;
                this.f31986d = context;
                this.f31987e = dVar;
                this.f31988f = str2;
            }

            @Override // com.wbl.ad.yzz.download.f
            public void a(int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14707, this, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.download.f
            public void a(long j2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14670, this, Long.valueOf(j2));
            }

            @Override // com.wbl.ad.yzz.download.f
            public void a(com.wbl.ad.yzz.download.h.c cVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14669, this, cVar);
            }

            public final void a(String str, HashMap<String, String> hashMap) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14672, this, str, hashMap);
            }

            @Override // com.wbl.ad.yzz.download.f
            public void b(com.wbl.ad.yzz.download.h.c cVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14671, this, cVar);
            }

            @Override // com.wbl.ad.yzz.download.f
            public void c() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14666, this, null);
            }
        }

        public static final class g extends com.wbl.ad.yzz.download.f {

            /* renamed from: c */
            public final /* synthetic */ r f31989c;

            /* renamed from: d */
            public final /* synthetic */ String f31990d;

            /* renamed from: e */
            public final /* synthetic */ Activity f31991e;

            /* renamed from: f */
            public final /* synthetic */ String f31992f;

            /* renamed from: g */
            public final /* synthetic */ String f31993g;

            /* renamed from: h */
            public final /* synthetic */ com.wbl.ad.yzz.bean.b f31994h;

            /* renamed from: i */
            public final /* synthetic */ h f31995i;

            public g(r rVar, String str, Activity activity, String str2, String str3, com.wbl.ad.yzz.bean.b bVar, h hVar) {
                this.f31989c = rVar;
                this.f31990d = str;
                this.f31991e = activity;
                this.f31992f = str2;
                this.f31993g = str3;
                this.f31994h = bVar;
                this.f31995i = hVar;
            }

            @Override // com.wbl.ad.yzz.download.f
            public void a(int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14665, this, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.download.f
            public void a(com.wbl.ad.yzz.download.h.c cVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14668, this, cVar);
            }

            @Override // com.wbl.ad.yzz.download.f
            public void b(com.wbl.ad.yzz.download.h.c cVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14667, this, cVar);
            }

            @Override // com.wbl.ad.yzz.download.f
            public void c() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14662, this, null);
            }
        }

        public static final class h extends b {

            /* renamed from: b */
            public final /* synthetic */ b f31996b;

            public h(b bVar) {
                this.f31996b = bVar;
            }

            @Override // com.wbl.ad.yzz.download.c.b
            public void a(int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14661, this, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.download.c.b
            public void a(com.wbl.ad.yzz.download.h.c cVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14664, this, cVar);
            }

            @Override // com.wbl.ad.yzz.download.c.b
            public void b() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14663, this, null);
            }

            @Override // com.wbl.ad.yzz.download.c.b
            public void b(int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14658, this, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.download.c.b
            public void c() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14657, this, null);
            }

            @Override // com.wbl.ad.yzz.download.c.b
            public void d() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14660, this, null);
            }

            @Override // com.wbl.ad.yzz.download.c.b
            public void e() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14659, this, null);
            }

            @Override // com.wbl.ad.yzz.download.c.b
            public void f() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14686, this, null);
            }
        }

        public a() {
        }

        public final b a(String sceneTag, String package_name, b listener, Activity context) {
            return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14680, this, sceneTag, package_name, listener, context);
        }

        public final void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14679, this, null);
        }

        public final void a(Activity context, com.wbl.ad.yzz.innerconfig.d.d sceneCache, u bean) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14674, this, context, sceneCache, bean);
        }

        public final void a(Activity r3, String sceneTag, com.wbl.ad.yzz.download.h.f downloadInfo, b r6) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14673, this, r3, sceneTag, downloadInfo, r6);
        }

        public final void a(Activity context, String sceneTag, String package_name, com.wbl.ad.yzz.bean.b bean, r r7, b listener) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14676, this, context, sceneTag, package_name, bean, r7, listener);
        }

        public final void a(Activity context, String sceneTag, String package_name, String url, String kpa_mda5, r r8, b onApkListenerDelegate) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14675, this, context, sceneTag, package_name, url, kpa_mda5, r8, onApkListenerDelegate);
        }

        public final void a(Activity context, String r4, boolean isUserFragment, com.wbl.ad.yzz.fragment.a actForResultCallback, b onApkListener) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14766, this, context, r4, Boolean.valueOf(isUserFragment), actForResultCallback, onApkListener);
        }

        public final void a(Context context, com.wbl.ad.yzz.innerconfig.d.d sceneCache, String eventName, Map<String, String> map) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14765, this, context, sceneCache, eventName, map);
        }

        public final void a(Context context, String key, String url, com.wbl.ad.yzz.innerconfig.d.d sceneCache, u.b conf) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14768, this, context, key, url, sceneCache, conf);
        }

        public final void a(Intent intent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14767, this, intent);
        }

        public final void a(r yzzAdBean, int code) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14762, this, yzzAdBean, Integer.valueOf(code));
        }

        public final void a(b listener) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14761, this, listener);
        }

        public final void a(String pkgName) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14764, this, pkgName);
        }

        public final void a(String pkgName, b onApkListener) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14763, this, pkgName, onApkListener);
        }

        public final boolean a(Activity context, com.wbl.ad.yzz.bean.b adDataBean) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14758, this, context, adDataBean);
        }

        public final boolean a(Activity context, String pkgName) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14757, this, context, pkgName);
        }

        public final boolean a(Context context, com.wbl.ad.yzz.bean.b adDataBean, r r5, b onApkListener) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14760, this, context, adDataBean, r5, onApkListener);
        }

        public final boolean a(Context context, String package_name) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14759, this, context, package_name);
        }

        public final void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14754, this, null);
        }

        public final boolean b(String packName) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14753, this, packName);
        }

        public final com.wbl.ad.yzz.download.g c() {
            return (com.wbl.ad.yzz.download.g) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14756, this, null);
        }

        public final void c(String package_name) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14755, this, package_name);
        }

        public final void d() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14782, this, null);
        }

        public final void d(String pkgName) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14781, this, pkgName);
        }

        public final void e(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14784, this, str);
        }

        public final void startActivity(Activity context, com.wbl.ad.yzz.bean.b bean, b onApkListener) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14783, this, context, bean, onApkListener);
        }

        public final void startActivity(Activity context, com.wbl.ad.yzz.bean.b bean, boolean isUseLinkSkip, b onApkListener) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14778, this, context, bean, Boolean.valueOf(isUseLinkSkip), onApkListener);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static abstract class b {

        /* renamed from: a */
        public boolean f31997a;

        public abstract void a(int i2);

        public void a(f fVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14632, this, fVar);
        }

        public abstract void a(@f.b.a.d com.wbl.ad.yzz.download.h.c cVar);

        public final void a(boolean z) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14631, this, Boolean.valueOf(z));
        }

        public final boolean a() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14626, this, null);
        }

        public abstract void b();

        public abstract void b(int i2);

        public abstract void c();

        public abstract void d();

        public abstract void e();

        public abstract void f();
    }

    public static final /* synthetic */ Map a() {
        return (Map) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14777, null, null);
    }

    public static final /* synthetic */ com.wbl.ad.yzz.download.h.d b() {
        return (com.wbl.ad.yzz.download.h.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14780, null, null);
    }

    public static final /* synthetic */ g c() {
        return (g) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14779, null, null);
    }

    public static final /* synthetic */ HashMap d() {
        return (HashMap) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14774, null, null);
    }
}
