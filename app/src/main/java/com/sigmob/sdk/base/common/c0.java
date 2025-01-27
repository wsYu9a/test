package com.sigmob.sdk.base.common;

import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class c0 implements s {

    /* renamed from: b */
    public boolean f17720b;

    /* renamed from: c */
    public int f17721c;

    /* renamed from: a */
    public int f17719a = 0;

    /* renamed from: d */
    public int f17722d = 0;

    public class a implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ HashMap f17723a;

        public a(HashMap hashMap) {
            this.f17723a = hashMap;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setOptions(this.f17723a);
            }
        }
    }

    public class b implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ int f17725a;

        /* renamed from: b */
        public final /* synthetic */ String f17726b;

        /* renamed from: c */
        public final /* synthetic */ BaseAdUnit f17727c;

        public b(int i10, String str, BaseAdUnit baseAdUnit) {
            this.f17725a = i10;
            this.f17726b = str;
            this.f17727c = baseAdUnit;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                c0 c0Var = c0.this;
                pointEntitySigmob.setVtime(c0Var.a(c0Var.f17719a));
                c0 c0Var2 = c0.this;
                pointEntitySigmob.setSkip_show_time(c0Var2.a(c0Var2.f17721c));
                pointEntitySigmob.setCurrent_time(c0.this.a(this.f17725a));
                pointEntitySigmob.setPlay_process(String.valueOf((this.f17725a * 1.0d) / c0.this.a()));
                if (this.f17726b.equals("start")) {
                    pointEntitySigmob.setScene_id(this.f17727c.getAd_scene_id());
                    pointEntitySigmob.setScene_desc(this.f17727c.getAd_scene_desc());
                    pointEntitySigmob.setBid_token(this.f17727c.getBid_token());
                }
                pointEntitySigmob.setPlay_time(c0.this.b(this.f17725a));
                pointEntitySigmob.setSet_close_time(String.format("%d", Integer.valueOf(c0.this.f17722d)));
                pointEntitySigmob.setIs_truncation(c0.this.b() ? "1" : "0");
                pointEntitySigmob.setIs_force(c0.this.f17720b ? "1" : "0");
            }
        }
    }

    @Override // com.sigmob.sdk.base.common.s
    public boolean a(BaseAdUnit baseAdUnit) {
        return true;
    }

    public final String b(int i10) {
        return i10 == 0 ? "0" : String.valueOf(i10 / 1000);
    }

    public final String a(int i10) {
        return i10 == 0 ? "0" : String.format("%.2f", Float.valueOf(i10 / 1000.0f));
    }

    @Override // com.sigmob.sdk.base.common.s
    public boolean b(BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.network.f.a(baseAdUnit, "ad_close");
        a(baseAdUnit, "ad_close", a(), null);
        return true;
    }

    public final void a(BaseAdUnit baseAdUnit, String str, int i10, String str2) {
        b0.a(str, str2, baseAdUnit, new b(i10, str, baseAdUnit));
    }

    public final void b(BaseAdUnit baseAdUnit, String str, int i10) {
        a(baseAdUnit, str, i10, null);
    }

    public final int a() {
        int i10;
        int i11 = this.f17722d;
        return (i11 <= 0 || (i10 = i11 * 1000) >= this.f17719a) ? this.f17719a : i10;
    }

    public final boolean b() {
        int i10 = this.f17722d;
        return i10 > 0 && i10 * 1000 < this.f17719a;
    }

    @Override // com.sigmob.sdk.base.common.s
    public boolean a(BaseAdUnit baseAdUnit, int i10, int i11) {
        this.f17719a = i10;
        this.f17722d = baseAdUnit.getEndTime();
        SigMacroCommon macroCommon = baseAdUnit.getMacroCommon();
        if (!(macroCommon instanceof SigMacroCommon)) {
            return true;
        }
        macroCommon.addMarcoKey(SigMacroCommon._VIDEOTIME_, b(this.f17719a));
        return true;
    }

    @Override // com.sigmob.sdk.base.common.s
    public boolean a(BaseAdUnit baseAdUnit, boolean z10, int i10) {
        this.f17720b = z10;
        this.f17721c = i10;
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0509 A[Catch: all -> 0x0029, TryCatch #0 {all -> 0x0029, blocks: (B:3:0x0008, B:6:0x001d, B:11:0x0161, B:15:0x024b, B:17:0x016e, B:19:0x017b, B:22:0x082e, B:24:0x018c, B:26:0x0199, B:28:0x01a8, B:30:0x01b5, B:32:0x01c4, B:34:0x01d1, B:38:0x07b8, B:40:0x01e5, B:42:0x01eb, B:46:0x0201, B:49:0x020b, B:50:0x020f, B:52:0x021a, B:55:0x0220, B:56:0x022b, B:58:0x0243, B:62:0x0252, B:63:0x0258, B:65:0x0263, B:68:0x0272, B:70:0x027a, B:73:0x0289, B:74:0x0294, B:77:0x02af, B:78:0x02b3, B:81:0x02c1, B:83:0x02c5, B:85:0x02fa, B:86:0x0307, B:88:0x0313, B:89:0x0322, B:91:0x032e, B:92:0x033d, B:95:0x034f, B:96:0x035a, B:101:0x036f, B:102:0x0373, B:105:0x0389, B:107:0x038d, B:109:0x03c0, B:110:0x03cb, B:112:0x03d7, B:113:0x03e4, B:115:0x03f0, B:116:0x03fd, B:119:0x040f, B:120:0x041c, B:126:0x0437, B:127:0x043d, B:130:0x044d, B:132:0x0457, B:135:0x0494, B:136:0x04f0, B:137:0x0503, B:139:0x0509, B:140:0x0514, B:142:0x0520, B:143:0x052d, B:145:0x0539, B:146:0x0546, B:149:0x0558, B:150:0x056d, B:151:0x04c1, B:153:0x04cf, B:154:0x04f4, B:156:0x0573, B:158:0x05cb, B:159:0x0621, B:160:0x0624, B:162:0x05f5, B:164:0x0603, B:169:0x0688, B:170:0x068c, B:173:0x069c, B:175:0x06a6, B:177:0x06d9, B:178:0x06e4, B:180:0x06f0, B:181:0x06fd, B:183:0x0709, B:184:0x0716, B:187:0x0728, B:188:0x0739, B:193:0x0748, B:194:0x074e, B:196:0x075f, B:199:0x076c, B:200:0x077b, B:205:0x0784, B:211:0x0794, B:217:0x07a1, B:222:0x07af, B:225:0x07bd, B:227:0x07cd, B:230:0x07da, B:231:0x07e5, B:233:0x07ea, B:235:0x07fc, B:238:0x082b, B:240:0x002d, B:243:0x0039, B:246:0x0045, B:249:0x0051, B:252:0x005d, B:255:0x0066, B:258:0x006f, B:261:0x0078, B:264:0x0081, B:267:0x008d, B:270:0x0099, B:273:0x00a5, B:276:0x00b1, B:279:0x00bc, B:282:0x00c7, B:285:0x00d0, B:288:0x00db, B:291:0x00e6, B:294:0x00f1, B:297:0x00fb, B:300:0x0104, B:303:0x010f, B:306:0x011a, B:309:0x0125), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0520 A[Catch: all -> 0x0029, TryCatch #0 {all -> 0x0029, blocks: (B:3:0x0008, B:6:0x001d, B:11:0x0161, B:15:0x024b, B:17:0x016e, B:19:0x017b, B:22:0x082e, B:24:0x018c, B:26:0x0199, B:28:0x01a8, B:30:0x01b5, B:32:0x01c4, B:34:0x01d1, B:38:0x07b8, B:40:0x01e5, B:42:0x01eb, B:46:0x0201, B:49:0x020b, B:50:0x020f, B:52:0x021a, B:55:0x0220, B:56:0x022b, B:58:0x0243, B:62:0x0252, B:63:0x0258, B:65:0x0263, B:68:0x0272, B:70:0x027a, B:73:0x0289, B:74:0x0294, B:77:0x02af, B:78:0x02b3, B:81:0x02c1, B:83:0x02c5, B:85:0x02fa, B:86:0x0307, B:88:0x0313, B:89:0x0322, B:91:0x032e, B:92:0x033d, B:95:0x034f, B:96:0x035a, B:101:0x036f, B:102:0x0373, B:105:0x0389, B:107:0x038d, B:109:0x03c0, B:110:0x03cb, B:112:0x03d7, B:113:0x03e4, B:115:0x03f0, B:116:0x03fd, B:119:0x040f, B:120:0x041c, B:126:0x0437, B:127:0x043d, B:130:0x044d, B:132:0x0457, B:135:0x0494, B:136:0x04f0, B:137:0x0503, B:139:0x0509, B:140:0x0514, B:142:0x0520, B:143:0x052d, B:145:0x0539, B:146:0x0546, B:149:0x0558, B:150:0x056d, B:151:0x04c1, B:153:0x04cf, B:154:0x04f4, B:156:0x0573, B:158:0x05cb, B:159:0x0621, B:160:0x0624, B:162:0x05f5, B:164:0x0603, B:169:0x0688, B:170:0x068c, B:173:0x069c, B:175:0x06a6, B:177:0x06d9, B:178:0x06e4, B:180:0x06f0, B:181:0x06fd, B:183:0x0709, B:184:0x0716, B:187:0x0728, B:188:0x0739, B:193:0x0748, B:194:0x074e, B:196:0x075f, B:199:0x076c, B:200:0x077b, B:205:0x0784, B:211:0x0794, B:217:0x07a1, B:222:0x07af, B:225:0x07bd, B:227:0x07cd, B:230:0x07da, B:231:0x07e5, B:233:0x07ea, B:235:0x07fc, B:238:0x082b, B:240:0x002d, B:243:0x0039, B:246:0x0045, B:249:0x0051, B:252:0x005d, B:255:0x0066, B:258:0x006f, B:261:0x0078, B:264:0x0081, B:267:0x008d, B:270:0x0099, B:273:0x00a5, B:276:0x00b1, B:279:0x00bc, B:282:0x00c7, B:285:0x00d0, B:288:0x00db, B:291:0x00e6, B:294:0x00f1, B:297:0x00fb, B:300:0x0104, B:303:0x010f, B:306:0x011a, B:309:0x0125), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0539 A[Catch: all -> 0x0029, TryCatch #0 {all -> 0x0029, blocks: (B:3:0x0008, B:6:0x001d, B:11:0x0161, B:15:0x024b, B:17:0x016e, B:19:0x017b, B:22:0x082e, B:24:0x018c, B:26:0x0199, B:28:0x01a8, B:30:0x01b5, B:32:0x01c4, B:34:0x01d1, B:38:0x07b8, B:40:0x01e5, B:42:0x01eb, B:46:0x0201, B:49:0x020b, B:50:0x020f, B:52:0x021a, B:55:0x0220, B:56:0x022b, B:58:0x0243, B:62:0x0252, B:63:0x0258, B:65:0x0263, B:68:0x0272, B:70:0x027a, B:73:0x0289, B:74:0x0294, B:77:0x02af, B:78:0x02b3, B:81:0x02c1, B:83:0x02c5, B:85:0x02fa, B:86:0x0307, B:88:0x0313, B:89:0x0322, B:91:0x032e, B:92:0x033d, B:95:0x034f, B:96:0x035a, B:101:0x036f, B:102:0x0373, B:105:0x0389, B:107:0x038d, B:109:0x03c0, B:110:0x03cb, B:112:0x03d7, B:113:0x03e4, B:115:0x03f0, B:116:0x03fd, B:119:0x040f, B:120:0x041c, B:126:0x0437, B:127:0x043d, B:130:0x044d, B:132:0x0457, B:135:0x0494, B:136:0x04f0, B:137:0x0503, B:139:0x0509, B:140:0x0514, B:142:0x0520, B:143:0x052d, B:145:0x0539, B:146:0x0546, B:149:0x0558, B:150:0x056d, B:151:0x04c1, B:153:0x04cf, B:154:0x04f4, B:156:0x0573, B:158:0x05cb, B:159:0x0621, B:160:0x0624, B:162:0x05f5, B:164:0x0603, B:169:0x0688, B:170:0x068c, B:173:0x069c, B:175:0x06a6, B:177:0x06d9, B:178:0x06e4, B:180:0x06f0, B:181:0x06fd, B:183:0x0709, B:184:0x0716, B:187:0x0728, B:188:0x0739, B:193:0x0748, B:194:0x074e, B:196:0x075f, B:199:0x076c, B:200:0x077b, B:205:0x0784, B:211:0x0794, B:217:0x07a1, B:222:0x07af, B:225:0x07bd, B:227:0x07cd, B:230:0x07da, B:231:0x07e5, B:233:0x07ea, B:235:0x07fc, B:238:0x082b, B:240:0x002d, B:243:0x0039, B:246:0x0045, B:249:0x0051, B:252:0x005d, B:255:0x0066, B:258:0x006f, B:261:0x0078, B:264:0x0081, B:267:0x008d, B:270:0x0099, B:273:0x00a5, B:276:0x00b1, B:279:0x00bc, B:282:0x00c7, B:285:0x00d0, B:288:0x00db, B:291:0x00e6, B:294:0x00f1, B:297:0x00fb, B:300:0x0104, B:303:0x010f, B:306:0x011a, B:309:0x0125), top: B:2:0x0008 }] */
    @Override // com.sigmob.sdk.base.common.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.sigmob.sdk.base.models.BaseAdUnit r26, java.lang.String r27, int r28) {
        /*
            Method dump skipped, instructions count: 2262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.c0.a(com.sigmob.sdk.base.models.BaseAdUnit, java.lang.String, int):boolean");
    }
}
