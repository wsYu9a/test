package cn.vlion.ad.inland.base;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.vlion.ad.inland.ad.config.VlionCustomAdActiveType$VlionCustomTarget;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorBean;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorManagerHelper;
import cn.vlion.ad.inland.ad.view.active.VlionDownloadProgressBar;
import cn.vlion.ad.inland.ad.view.text.VlionDownloadBottomTextView;
import cn.vlion.ad.inland.base.a3;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class y2 extends v0 implements d {
    public VlionAdapterADConfig A;
    public q0 B;
    public DownloadApkData C;
    public boolean D;
    public boolean E;
    public c3 F;
    public boolean G;
    public boolean H;

    /* renamed from: h */
    public TextView f3509h;

    /* renamed from: i */
    public LinearLayout f3510i;

    /* renamed from: j */
    public LinearLayout f3511j;

    /* renamed from: k */
    public LinearLayout f3512k;

    /* renamed from: l */
    public LinearLayout f3513l;

    /* renamed from: m */
    public ImageView f3514m;

    /* renamed from: n */
    public TextView f3515n;

    /* renamed from: o */
    public VlionDownloadProgressBar f3516o;

    /* renamed from: p */
    public ImageView f3517p;

    /* renamed from: q */
    public VlionDownloadBottomTextView f3518q;

    /* renamed from: r */
    public int f3519r;

    /* renamed from: s */
    public VlionAdapterADConfig f3520s;

    /* renamed from: t */
    public VlionSensorBean f3521t;

    /* renamed from: u */
    public boolean f3522u;

    /* renamed from: v */
    public i0 f3523v;

    /* renamed from: w */
    public boolean f3524w;

    /* renamed from: x */
    public float f3525x;

    /* renamed from: y */
    public View f3526y;

    /* renamed from: z */
    public VlionCustomParseAdData f3527z;

    public y2(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        super(context);
        this.f3522u = false;
        this.f3524w = false;
        this.f3525x = 0.5625f;
        this.D = false;
        this.E = false;
        this.G = false;
        this.H = false;
        this.f3520s = vlionAdapterADConfig;
    }

    public static void b(y2 y2Var, VlionADClickType vlionADClickType) {
        y2Var.getClass();
        try {
            LogVlion.e("VlionCustomFeedAdLayout adAreaClickAction isOpenHot" + VlionServiceConfigParse.getInstance().isHotspot());
            y2Var.B.a(y2Var.getContext(), y2Var.f3527z.getDp(), y2Var.D, new u2(y2Var, vlionADClickType));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0328 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0298 A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #1 {all -> 0x0023, blocks: (B:2:0x0000, B:9:0x000e, B:11:0x0018, B:14:0x0027, B:18:0x003a, B:21:0x005c, B:23:0x0061, B:26:0x0070, B:30:0x009d, B:32:0x0094, B:36:0x00bc, B:37:0x00c7, B:44:0x00e1, B:45:0x01a5, B:47:0x01c8, B:48:0x01d5, B:51:0x01e6, B:53:0x01ec, B:55:0x01f8, B:57:0x01fc, B:59:0x020d, B:61:0x01ff, B:63:0x020b, B:67:0x0210, B:69:0x0215, B:71:0x021b, B:72:0x021d, B:74:0x0225, B:75:0x0227, B:77:0x022d, B:79:0x0233, B:81:0x0239, B:83:0x023f, B:88:0x0253, B:89:0x025a, B:91:0x0280, B:92:0x02f2, B:93:0x02ff, B:95:0x035c, B:97:0x0368, B:111:0x0355, B:112:0x0287, B:114:0x0291, B:115:0x02fa, B:116:0x0298, B:119:0x02be, B:121:0x02c8, B:122:0x02d1, B:124:0x02db, B:125:0x02e2, B:127:0x02ec, B:130:0x02b7, B:131:0x00ea, B:133:0x00f3, B:134:0x00fc, B:136:0x0107, B:138:0x0111, B:140:0x011f, B:145:0x0149, B:146:0x0150, B:148:0x0156, B:150:0x0160, B:152:0x016e, B:157:0x0198, B:158:0x01a0, B:85:0x0247, B:118:0x02ab, B:154:0x0185, B:142:0x0136, B:101:0x0328, B:104:0x032d, B:106:0x0333, B:107:0x033c), top: B:1:0x0000, inners: #0, #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a A[Catch: all -> 0x0023, TryCatch #1 {all -> 0x0023, blocks: (B:2:0x0000, B:9:0x000e, B:11:0x0018, B:14:0x0027, B:18:0x003a, B:21:0x005c, B:23:0x0061, B:26:0x0070, B:30:0x009d, B:32:0x0094, B:36:0x00bc, B:37:0x00c7, B:44:0x00e1, B:45:0x01a5, B:47:0x01c8, B:48:0x01d5, B:51:0x01e6, B:53:0x01ec, B:55:0x01f8, B:57:0x01fc, B:59:0x020d, B:61:0x01ff, B:63:0x020b, B:67:0x0210, B:69:0x0215, B:71:0x021b, B:72:0x021d, B:74:0x0225, B:75:0x0227, B:77:0x022d, B:79:0x0233, B:81:0x0239, B:83:0x023f, B:88:0x0253, B:89:0x025a, B:91:0x0280, B:92:0x02f2, B:93:0x02ff, B:95:0x035c, B:97:0x0368, B:111:0x0355, B:112:0x0287, B:114:0x0291, B:115:0x02fa, B:116:0x0298, B:119:0x02be, B:121:0x02c8, B:122:0x02d1, B:124:0x02db, B:125:0x02e2, B:127:0x02ec, B:130:0x02b7, B:131:0x00ea, B:133:0x00f3, B:134:0x00fc, B:136:0x0107, B:138:0x0111, B:140:0x011f, B:145:0x0149, B:146:0x0150, B:148:0x0156, B:150:0x0160, B:152:0x016e, B:157:0x0198, B:158:0x01a0, B:85:0x0247, B:118:0x02ab, B:154:0x0185, B:142:0x0136, B:101:0x0328, B:104:0x032d, B:106:0x0333, B:107:0x033c), top: B:1:0x0000, inners: #0, #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061 A[Catch: all -> 0x0023, TryCatch #1 {all -> 0x0023, blocks: (B:2:0x0000, B:9:0x000e, B:11:0x0018, B:14:0x0027, B:18:0x003a, B:21:0x005c, B:23:0x0061, B:26:0x0070, B:30:0x009d, B:32:0x0094, B:36:0x00bc, B:37:0x00c7, B:44:0x00e1, B:45:0x01a5, B:47:0x01c8, B:48:0x01d5, B:51:0x01e6, B:53:0x01ec, B:55:0x01f8, B:57:0x01fc, B:59:0x020d, B:61:0x01ff, B:63:0x020b, B:67:0x0210, B:69:0x0215, B:71:0x021b, B:72:0x021d, B:74:0x0225, B:75:0x0227, B:77:0x022d, B:79:0x0233, B:81:0x0239, B:83:0x023f, B:88:0x0253, B:89:0x025a, B:91:0x0280, B:92:0x02f2, B:93:0x02ff, B:95:0x035c, B:97:0x0368, B:111:0x0355, B:112:0x0287, B:114:0x0291, B:115:0x02fa, B:116:0x0298, B:119:0x02be, B:121:0x02c8, B:122:0x02d1, B:124:0x02db, B:125:0x02e2, B:127:0x02ec, B:130:0x02b7, B:131:0x00ea, B:133:0x00f3, B:134:0x00fc, B:136:0x0107, B:138:0x0111, B:140:0x011f, B:145:0x0149, B:146:0x0150, B:148:0x0156, B:150:0x0160, B:152:0x016e, B:157:0x0198, B:158:0x01a0, B:85:0x0247, B:118:0x02ab, B:154:0x0185, B:142:0x0136, B:101:0x0328, B:104:0x032d, B:106:0x0333, B:107:0x033c), top: B:1:0x0000, inners: #0, #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bc A[Catch: all -> 0x0023, TryCatch #1 {all -> 0x0023, blocks: (B:2:0x0000, B:9:0x000e, B:11:0x0018, B:14:0x0027, B:18:0x003a, B:21:0x005c, B:23:0x0061, B:26:0x0070, B:30:0x009d, B:32:0x0094, B:36:0x00bc, B:37:0x00c7, B:44:0x00e1, B:45:0x01a5, B:47:0x01c8, B:48:0x01d5, B:51:0x01e6, B:53:0x01ec, B:55:0x01f8, B:57:0x01fc, B:59:0x020d, B:61:0x01ff, B:63:0x020b, B:67:0x0210, B:69:0x0215, B:71:0x021b, B:72:0x021d, B:74:0x0225, B:75:0x0227, B:77:0x022d, B:79:0x0233, B:81:0x0239, B:83:0x023f, B:88:0x0253, B:89:0x025a, B:91:0x0280, B:92:0x02f2, B:93:0x02ff, B:95:0x035c, B:97:0x0368, B:111:0x0355, B:112:0x0287, B:114:0x0291, B:115:0x02fa, B:116:0x0298, B:119:0x02be, B:121:0x02c8, B:122:0x02d1, B:124:0x02db, B:125:0x02e2, B:127:0x02ec, B:130:0x02b7, B:131:0x00ea, B:133:0x00f3, B:134:0x00fc, B:136:0x0107, B:138:0x0111, B:140:0x011f, B:145:0x0149, B:146:0x0150, B:148:0x0156, B:150:0x0160, B:152:0x016e, B:157:0x0198, B:158:0x01a0, B:85:0x0247, B:118:0x02ab, B:154:0x0185, B:142:0x0136, B:101:0x0328, B:104:0x032d, B:106:0x0333, B:107:0x033c), top: B:1:0x0000, inners: #0, #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01c8 A[Catch: all -> 0x0023, TryCatch #1 {all -> 0x0023, blocks: (B:2:0x0000, B:9:0x000e, B:11:0x0018, B:14:0x0027, B:18:0x003a, B:21:0x005c, B:23:0x0061, B:26:0x0070, B:30:0x009d, B:32:0x0094, B:36:0x00bc, B:37:0x00c7, B:44:0x00e1, B:45:0x01a5, B:47:0x01c8, B:48:0x01d5, B:51:0x01e6, B:53:0x01ec, B:55:0x01f8, B:57:0x01fc, B:59:0x020d, B:61:0x01ff, B:63:0x020b, B:67:0x0210, B:69:0x0215, B:71:0x021b, B:72:0x021d, B:74:0x0225, B:75:0x0227, B:77:0x022d, B:79:0x0233, B:81:0x0239, B:83:0x023f, B:88:0x0253, B:89:0x025a, B:91:0x0280, B:92:0x02f2, B:93:0x02ff, B:95:0x035c, B:97:0x0368, B:111:0x0355, B:112:0x0287, B:114:0x0291, B:115:0x02fa, B:116:0x0298, B:119:0x02be, B:121:0x02c8, B:122:0x02d1, B:124:0x02db, B:125:0x02e2, B:127:0x02ec, B:130:0x02b7, B:131:0x00ea, B:133:0x00f3, B:134:0x00fc, B:136:0x0107, B:138:0x0111, B:140:0x011f, B:145:0x0149, B:146:0x0150, B:148:0x0156, B:150:0x0160, B:152:0x016e, B:157:0x0198, B:158:0x01a0, B:85:0x0247, B:118:0x02ab, B:154:0x0185, B:142:0x0136, B:101:0x0328, B:104:0x032d, B:106:0x0333, B:107:0x033c), top: B:1:0x0000, inners: #0, #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0215 A[Catch: all -> 0x0023, TryCatch #1 {all -> 0x0023, blocks: (B:2:0x0000, B:9:0x000e, B:11:0x0018, B:14:0x0027, B:18:0x003a, B:21:0x005c, B:23:0x0061, B:26:0x0070, B:30:0x009d, B:32:0x0094, B:36:0x00bc, B:37:0x00c7, B:44:0x00e1, B:45:0x01a5, B:47:0x01c8, B:48:0x01d5, B:51:0x01e6, B:53:0x01ec, B:55:0x01f8, B:57:0x01fc, B:59:0x020d, B:61:0x01ff, B:63:0x020b, B:67:0x0210, B:69:0x0215, B:71:0x021b, B:72:0x021d, B:74:0x0225, B:75:0x0227, B:77:0x022d, B:79:0x0233, B:81:0x0239, B:83:0x023f, B:88:0x0253, B:89:0x025a, B:91:0x0280, B:92:0x02f2, B:93:0x02ff, B:95:0x035c, B:97:0x0368, B:111:0x0355, B:112:0x0287, B:114:0x0291, B:115:0x02fa, B:116:0x0298, B:119:0x02be, B:121:0x02c8, B:122:0x02d1, B:124:0x02db, B:125:0x02e2, B:127:0x02ec, B:130:0x02b7, B:131:0x00ea, B:133:0x00f3, B:134:0x00fc, B:136:0x0107, B:138:0x0111, B:140:0x011f, B:145:0x0149, B:146:0x0150, B:148:0x0156, B:150:0x0160, B:152:0x016e, B:157:0x0198, B:158:0x01a0, B:85:0x0247, B:118:0x02ab, B:154:0x0185, B:142:0x0136, B:101:0x0328, B:104:0x032d, B:106:0x0333, B:107:0x033c), top: B:1:0x0000, inners: #0, #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x022d A[Catch: all -> 0x0023, TryCatch #1 {all -> 0x0023, blocks: (B:2:0x0000, B:9:0x000e, B:11:0x0018, B:14:0x0027, B:18:0x003a, B:21:0x005c, B:23:0x0061, B:26:0x0070, B:30:0x009d, B:32:0x0094, B:36:0x00bc, B:37:0x00c7, B:44:0x00e1, B:45:0x01a5, B:47:0x01c8, B:48:0x01d5, B:51:0x01e6, B:53:0x01ec, B:55:0x01f8, B:57:0x01fc, B:59:0x020d, B:61:0x01ff, B:63:0x020b, B:67:0x0210, B:69:0x0215, B:71:0x021b, B:72:0x021d, B:74:0x0225, B:75:0x0227, B:77:0x022d, B:79:0x0233, B:81:0x0239, B:83:0x023f, B:88:0x0253, B:89:0x025a, B:91:0x0280, B:92:0x02f2, B:93:0x02ff, B:95:0x035c, B:97:0x0368, B:111:0x0355, B:112:0x0287, B:114:0x0291, B:115:0x02fa, B:116:0x0298, B:119:0x02be, B:121:0x02c8, B:122:0x02d1, B:124:0x02db, B:125:0x02e2, B:127:0x02ec, B:130:0x02b7, B:131:0x00ea, B:133:0x00f3, B:134:0x00fc, B:136:0x0107, B:138:0x0111, B:140:0x011f, B:145:0x0149, B:146:0x0150, B:148:0x0156, B:150:0x0160, B:152:0x016e, B:157:0x0198, B:158:0x01a0, B:85:0x0247, B:118:0x02ab, B:154:0x0185, B:142:0x0136, B:101:0x0328, B:104:0x032d, B:106:0x0333, B:107:0x033c), top: B:1:0x0000, inners: #0, #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0368 A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #1 {all -> 0x0023, blocks: (B:2:0x0000, B:9:0x000e, B:11:0x0018, B:14:0x0027, B:18:0x003a, B:21:0x005c, B:23:0x0061, B:26:0x0070, B:30:0x009d, B:32:0x0094, B:36:0x00bc, B:37:0x00c7, B:44:0x00e1, B:45:0x01a5, B:47:0x01c8, B:48:0x01d5, B:51:0x01e6, B:53:0x01ec, B:55:0x01f8, B:57:0x01fc, B:59:0x020d, B:61:0x01ff, B:63:0x020b, B:67:0x0210, B:69:0x0215, B:71:0x021b, B:72:0x021d, B:74:0x0225, B:75:0x0227, B:77:0x022d, B:79:0x0233, B:81:0x0239, B:83:0x023f, B:88:0x0253, B:89:0x025a, B:91:0x0280, B:92:0x02f2, B:93:0x02ff, B:95:0x035c, B:97:0x0368, B:111:0x0355, B:112:0x0287, B:114:0x0291, B:115:0x02fa, B:116:0x0298, B:119:0x02be, B:121:0x02c8, B:122:0x02d1, B:124:0x02db, B:125:0x02e2, B:127:0x02ec, B:130:0x02b7, B:131:0x00ea, B:133:0x00f3, B:134:0x00fc, B:136:0x0107, B:138:0x0111, B:140:0x011f, B:145:0x0149, B:146:0x0150, B:148:0x0156, B:150:0x0160, B:152:0x016e, B:157:0x0198, B:158:0x01a0, B:85:0x0247, B:118:0x02ab, B:154:0x0185, B:142:0x0136, B:101:0x0328, B:104:0x032d, B:106:0x0333, B:107:0x033c), top: B:1:0x0000, inners: #0, #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.view.View r11, cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r12, cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData r13, cn.vlion.ad.inland.base.a3.a.C0023a r14) {
        /*
            Method dump skipped, instructions count: 898
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.y2.a(android.view.View, cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig, cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData, cn.vlion.ad.inland.base.a3$a$a):void");
    }

    public final void c() {
        try {
            if (this.G) {
                VlionSensorManagerHelper.getInstance().unregisterShakeListener(this.f3521t);
                LogVlion.e("端策略 :  ---移除摇一摇监听---= ");
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void d() {
        Resources resources;
        int i10;
        Resources resources2;
        int i11;
        try {
            VlionDownloadProgressBar vlionDownloadProgressBar = this.f3516o;
            if (vlionDownloadProgressBar == null) {
                return;
            }
            if (this.D) {
                if (this.E) {
                    if (this.G) {
                        resources2 = getResources();
                        i11 = R.string.vlion_custom_ad_download_now_shake_open;
                        vlionDownloadProgressBar.setShakeStyle(resources2.getString(i11), true);
                        return;
                    } else {
                        resources = getResources();
                        i10 = R.string.vlion_custom_ad_deeplink_open;
                        vlionDownloadProgressBar.setShakeStyle(resources.getString(i10), false);
                    }
                }
                if (this.G) {
                    resources2 = getResources();
                    i11 = R.string.vlion_custom_ad_download_now_shake;
                    vlionDownloadProgressBar.setShakeStyle(resources2.getString(i11), true);
                    return;
                } else {
                    resources = getResources();
                    i10 = R.string.vlion_custom_ad_download_now;
                    vlionDownloadProgressBar.setShakeStyle(resources.getString(i10), false);
                }
            }
            if (this.f3527z == null || !q.a(getContext(), this.f3527z.getDp())) {
                if (this.G) {
                    vlionDownloadProgressBar = this.f3516o;
                    resources2 = getResources();
                    i11 = R.string.vlion_custom_ad_click_now_shake_look;
                    vlionDownloadProgressBar.setShakeStyle(resources2.getString(i11), true);
                    return;
                }
                vlionDownloadProgressBar = this.f3516o;
                resources = getResources();
                i10 = R.string.vlion_custom_ad_look_detail;
                vlionDownloadProgressBar.setShakeStyle(resources.getString(i10), false);
            }
            if (this.G) {
                vlionDownloadProgressBar = this.f3516o;
                resources2 = getResources();
                i11 = R.string.vlion_custom_ad_download_now_shake_open;
                vlionDownloadProgressBar.setShakeStyle(resources2.getString(i11), true);
                return;
            }
            vlionDownloadProgressBar = this.f3516o;
            resources = getResources();
            i10 = R.string.vlion_custom_ad_deeplink_open;
            vlionDownloadProgressBar.setShakeStyle(resources.getString(i10), false);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.v0, cn.vlion.ad.inland.base.d
    public final void destroy() {
        super.destroy();
        try {
            i0 i0Var = this.f3523v;
            if (i0Var != null) {
                i0Var.a();
                this.f3523v = null;
            }
            View view = this.f3526y;
            if (view != null) {
                if (view instanceof h5) {
                    LogVlion.e(" 222 destroy--=");
                    ((h5) this.f3526y).destroy();
                } else if (view instanceof a7) {
                    LogVlion.e(" 1111 destroy--=");
                    ((a7) this.f3526y).destroy();
                }
            }
            removeAllViews();
            DownloadApkData downloadApkData = this.C;
            if (downloadApkData != null) {
                downloadApkData.cancelSchedule();
                this.C.setAdClosed(true);
                if (this.C.isInstallComplete()) {
                    s0.a(this.C.getDownloadId());
                }
            }
            q0 q0Var = this.B;
            if (q0Var != null) {
                q0Var.a();
                this.B = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        VlionADEventManager.getParameterShow(this.f3520s, "VlionCustomFeedAdLayout");
    }

    @Override // cn.vlion.ad.inland.base.v0, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        LinearLayout linearLayout;
        super.onLayout(z10, i10, i11, i12, i13);
        try {
            LogVlion.e("VlionCustomFeedAdLayout onLayout--: ");
            if (this.f3522u) {
                return;
            }
            switch (this.f3519r) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                    linearLayout = this.f3510i;
                    break;
                case 6:
                    a(this.f3510i);
                    a(this.f3511j);
                    linearLayout = this.f3512k;
                    break;
                default:
                    return;
            }
            a(linearLayout);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    public void settingLayoutStyle(int i10) {
        LayoutInflater from;
        int i11;
        View findViewById;
        try {
            if (getContext() == null) {
                return;
            }
            switch (i10) {
                case 1:
                    from = LayoutInflater.from(getContext());
                    i11 = R.layout.vlion_cn_ad_feed_layout1;
                    from.inflate(i11, (ViewGroup) this, true);
                    break;
                case 2:
                    from = LayoutInflater.from(getContext());
                    i11 = R.layout.vlion_cn_ad_feed_layout2;
                    from.inflate(i11, (ViewGroup) this, true);
                    break;
                case 3:
                    from = LayoutInflater.from(getContext());
                    i11 = R.layout.vlion_cn_ad_feed_layout3;
                    from.inflate(i11, (ViewGroup) this, true);
                    break;
                case 4:
                    LayoutInflater.from(getContext()).inflate(R.layout.vlion_cn_ad_feed_layout4, (ViewGroup) this, true);
                    findViewById = findViewById(R.id.vlion_ll_info_layout);
                    this.f3513l = (LinearLayout) findViewById;
                    break;
                case 5:
                    LayoutInflater.from(getContext()).inflate(R.layout.vlion_cn_ad_feed_layout5, (ViewGroup) this, true);
                    findViewById = findViewById(R.id.vlion_ll_info_layout);
                    this.f3513l = (LinearLayout) findViewById;
                    break;
                case 6:
                    LayoutInflater.from(getContext()).inflate(R.layout.vlion_cn_ad_feed_layout6, (ViewGroup) this, true);
                    this.f3511j = (LinearLayout) findViewById(R.id.vlion_img_showimage_2);
                    this.f3512k = (LinearLayout) findViewById(R.id.vlion_img_showimage_3);
                    break;
                case 7:
                    LayoutInflater.from(getContext()).inflate(R.layout.vlion_cn_ad_feed_layout7, (ViewGroup) this, true);
                    break;
                default:
                    from = LayoutInflater.from(getContext());
                    i11 = R.layout.vlion_cn_ad_feed_layout1;
                    from.inflate(i11, (ViewGroup) this, true);
                    break;
            }
            this.f3509h = (TextView) findViewById(R.id.vlion_tv_title_info);
            this.f3510i = (LinearLayout) findViewById(R.id.vlion_img_showimage);
            this.f3514m = (ImageView) findViewById(R.id.vlion_img_showappicon);
            this.f3515n = (TextView) findViewById(R.id.vlion_tv_appName);
            this.f3516o = (VlionDownloadProgressBar) findViewById(R.id.vlion_tv_action);
            this.f3517p = (ImageView) findViewById(R.id.vlion_img_close);
            this.f3518q = (VlionDownloadBottomTextView) findViewById(R.id.vlionBottomTextView);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(LinearLayout linearLayout) {
        if (linearLayout != null) {
            try {
                ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                float width = linearLayout.getWidth();
                float f10 = this.f3525x;
                int i10 = (int) (width * f10);
                View view = this.f3526y;
                if (view != null && (view instanceof f5)) {
                    f5 f5Var = (f5) view;
                    float f11 = f5Var.f2801c / f5Var.f2800b;
                    if (f10 > f11) {
                        i10 = (int) (linearLayout.getWidth() * f11);
                    }
                }
                layoutParams.width = linearLayout.getWidth();
                layoutParams.height = i10;
                linearLayout.setLayoutParams(layoutParams);
                LinearLayout linearLayout2 = this.f3513l;
                if (linearLayout2 != null) {
                    ViewGroup.LayoutParams layoutParams2 = linearLayout2.getLayoutParams();
                    layoutParams2.height = i10;
                    this.f3513l.setLayoutParams(layoutParams2);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                return;
            }
        }
        this.f3522u = true;
    }

    public static void a(y2 y2Var, VlionADClickType vlionADClickType) {
        y2Var.getClass();
        try {
            VlionCustomAdActiveType$VlionCustomTarget a10 = y2Var.B.a(y2Var.getContext(), y2Var.A, y2Var.f3527z, new v2(y2Var));
            if (a10 != null && vlionADClickType != null) {
                vlionADClickType.setTarget(a10.toString());
            }
            if (vlionADClickType != null) {
                q0 q0Var = y2Var.B;
                Context context = y2Var.getContext();
                VlionCustomParseAdData vlionCustomParseAdData = y2Var.f3527z;
                q0Var.getClass();
                vlionADClickType.setIsCanOpenDp(q0.a(context, vlionCustomParseAdData));
            }
            c3 c3Var = y2Var.F;
            if (c3Var != null) {
                ((a3.a.C0023a) c3Var).a(vlionADClickType);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.v0
    public final void a(boolean z10) {
        try {
            super.a(z10);
            LogVlion.e("VlionCustomDrawAdLayout isResume=" + z10 + " isRectVisible=" + b());
            if (z10 && b()) {
                try {
                    View view = this.f3526y;
                    if (view != null && (view instanceof a7)) {
                        a7 a7Var = (a7) view;
                        a7Var.setExposurePlay(true);
                        try {
                            LogVlion.e("VlionVideoViewBaseGroup  startVideo");
                            e1 e1Var = a7Var.f2623f;
                            if (e1Var != null) {
                                e1Var.f();
                            }
                        } catch (Throwable th2) {
                            VlionSDkManager.getInstance().upLoadCatchException(th2);
                        }
                    }
                } catch (Throwable th3) {
                    VlionSDkManager.getInstance().upLoadCatchException(th3);
                }
                try {
                    if (this.G) {
                        VlionSensorManagerHelper.getInstance().registerShakeListener(VlionSDkManager.getInstance().getApplication(), this.f3521t);
                        LogVlion.e("端策略 :  ---注册摇一摇监听---= ");
                        return;
                    }
                    return;
                } catch (Throwable th4) {
                    VlionSDkManager.getInstance().upLoadCatchException(th4);
                    return;
                }
            }
            try {
                View view2 = this.f3526y;
                if (view2 != null && (view2 instanceof a7)) {
                    a7 a7Var2 = (a7) view2;
                    a7Var2.setExposurePlay(false);
                    try {
                        LogVlion.e("VlionVideoViewBaseGroup  stopVideo ");
                        e1 e1Var2 = a7Var2.f2623f;
                        if (e1Var2 != null) {
                            e1Var2.h();
                        }
                    } catch (Throwable th5) {
                        VlionSDkManager.getInstance().upLoadCatchException(th5);
                    }
                }
            } catch (Throwable th6) {
                VlionSDkManager.getInstance().upLoadCatchException(th6);
            }
            c();
            return;
        } catch (Throwable th7) {
            VlionSDkManager.getInstance().upLoadCatchException(th7);
        }
        VlionSDkManager.getInstance().upLoadCatchException(th7);
    }

    public final void a(LinearLayout linearLayout, View view, float f10) {
        try {
            this.f3525x = f10;
            if (linearLayout != null && view != null) {
                try {
                    linearLayout.removeAllViews();
                    j0.a(view);
                    linearLayout.addView(view, new LinearLayout.LayoutParams(-1, -1));
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }
}
