package com.opos.mobad.model;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.d.d;
import com.opos.cmn.d.e;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.AppPrivacyData;
import com.opos.mobad.model.data.FloatLayerData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.model.e.a;
import com.opos.mobad.n.d.h;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.text.DecimalFormat;
import java.util.List;

/* loaded from: classes4.dex */
public class a {
    private static com.opos.mobad.n.d.a a(AppPrivacyData appPrivacyData) {
        if (appPrivacyData == null) {
            return null;
        }
        return new com.opos.mobad.n.d.a(appPrivacyData.f21708d, appPrivacyData.f21707c);
    }

    public static final h a(Context context, AdItemData adItemData, MaterialData materialData, boolean z) {
        return a(context, adItemData, materialData, z, materialData.Z());
    }

    public static final h a(Context context, AdItemData adItemData, MaterialData materialData, boolean z, boolean z2) {
        return a(context, adItemData, materialData, z, z2, 0, 0);
    }

    public static final h a(Context context, AdItemData adItemData, MaterialData materialData, boolean z, boolean z2, int i2, int i3) {
        h hVar = new h();
        hVar.a(materialData.i()).b(materialData.h()).a(adItemData.j()).c(adItemData.B()).d(a(context, materialData, z)).f(adItemData.k()).g(materialData.f21723g).a(adItemData.K() > 0 ? adItemData.K() : materialData.u(), materialData.v() * 1000).e(adItemData.b()).h(adItemData.T()).a(a(adItemData.O())).h(a(materialData.ad())).g(b(materialData.l())).e(adItemData.U()).b(z2).a(i2).b(i3).i(materialData.T() == 2 ? 1 : 0);
        MaterialFileData l = adItemData.l();
        if (l != null) {
            hVar.c(l.a(), l.b());
        }
        List<MaterialFileData> g2 = materialData.g();
        if (g2 != null && g2.size() > 0) {
            hVar.a(g2.get(0).a(), adItemData.f(), materialData.c());
        }
        List<MaterialFileData> f2 = materialData.f();
        if (f2 != null && f2.size() > 0) {
            for (MaterialFileData materialFileData : f2) {
                hVar.a(materialFileData.a(), materialFileData.b());
            }
        }
        List<MaterialFileData> j2 = materialData.j();
        if (j2 != null && j2.size() > 0) {
            hVar.d(j2.get(0).a(), j2.get(0).b());
        }
        List<MaterialFileData> F = materialData.F();
        if (F != null && F.size() > 0) {
            MaterialFileData materialFileData2 = F.get(0);
            String a2 = materialFileData2.a();
            if (adItemData.r() == 1) {
                a2 = d.a(context, materialFileData2.a());
            } else if (adItemData.r() == 2) {
                a2 = e.a(context, materialFileData2.a());
            }
            hVar.e(a2, materialFileData2.b());
        }
        hVar.d(!adItemData.D() ? 1 : 0);
        a(context, hVar, adItemData, materialData, z);
        a(hVar, adItemData, materialData);
        return hVar;
    }

    public static final h a(Context context, a.C0457a c0457a, boolean z, boolean z2) {
        return a(context, c0457a.f21744b, c0457a.f21745c, z, z2);
    }

    private static String a(long j2) {
        StringBuilder sb;
        if (j2 > 0) {
            try {
                DecimalFormat decimalFormat = new DecimalFormat("0");
                if (j2 >= 100000000) {
                    sb = new StringBuilder();
                    sb.append(decimalFormat.format(j2 / 1.0E8f));
                    sb.append("亿次");
                } else if (j2 >= 10000) {
                    sb = new StringBuilder();
                    sb.append(decimalFormat.format(j2 / 10000.0f));
                    sb.append("万次");
                }
                return sb.toString();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("", "", (Throwable) e2);
            }
        }
        return null;
    }

    public static String a(Context context, MaterialData materialData, boolean z) {
        if (materialData != null) {
            if (z) {
                return "立刻打开";
            }
            if (!TextUtils.isEmpty(materialData.Y())) {
                return materialData.Y();
            }
            switch (materialData.e()) {
                case 1:
                    return "点击查看";
                case 2:
                    return (com.opos.cmn.an.c.a.a(materialData.k()) || !com.opos.cmn.an.h.d.a.d(context, materialData.k())) ? "点击安装" : "立刻打开";
                case 3:
                    return (com.opos.cmn.an.c.a.a(materialData.k()) || !com.opos.cmn.an.h.d.a.d(context, materialData.k())) ? "立即下载" : "立刻打开";
                case 4:
                    return "立刻打开";
                case 5:
                    return "查看详情";
                case 6:
                    return "秒开";
                case 7:
                    return "打开";
            }
        }
        return "";
    }

    private static void a(Context context, h hVar, AdItemData adItemData, MaterialData materialData, boolean z) {
        MaterialFileData materialFileData;
        FloatLayerData U = materialData.U();
        if (U == null) {
            return;
        }
        hVar.k(U.c());
        hVar.l(U.b());
        hVar.k(U.c());
        hVar.j(a(context, materialData, z));
        List<MaterialFileData> d2 = U.d();
        if (d2 != null && d2.size() > 0) {
            for (MaterialFileData materialFileData2 : d2) {
                hVar.b(materialFileData2.a(), materialFileData2.b());
            }
        }
        MaterialFileData a2 = U.a();
        if (a2 != null) {
            hVar.f(a2.a(), a2.b());
        }
        List<MaterialFileData> e2 = U.e();
        if (e2 == null || e2.size() <= 0 || (materialFileData = e2.get(0)) == null) {
            return;
        }
        hVar.a(materialFileData.a(), materialFileData.b(), adItemData.f(), materialData.c());
    }

    private static void a(h hVar, AdItemData adItemData, MaterialData materialData) {
        if (com.opos.mobad.service.c.b.a().c(materialData.b()) == 0) {
            hVar.i(com.opos.mobad.service.c.b.a().d(materialData.b()));
        }
    }

    private static String b(long j2) {
        StringBuilder sb;
        if (j2 > 0) {
            try {
                DecimalFormat decimalFormat = new DecimalFormat("0");
                if (j2 >= DownloadConstants.GB) {
                    sb = new StringBuilder();
                    sb.append(decimalFormat.format(j2 / 1.0737418E9f));
                    sb.append("GB");
                } else if (j2 >= 1048576) {
                    sb = new StringBuilder();
                    sb.append(decimalFormat.format(j2 / 1048576.0f));
                    sb.append("MB");
                }
                return sb.toString();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("", "", (Throwable) e2);
            }
        }
        return null;
    }
}
