package com.google.zxing.oned;

import com.martian.mibook.activity.ReadingRechargeActivity;
import com.martian.mibook.activity.book.BookInfoActivity;
import com.opos.acs.st.STManager;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.vivo.ic.dm.Downloads;
import com.vivo.push.BuildConfig;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class l {

    /* renamed from: a, reason: collision with root package name */
    private final List<int[]> f8577a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final List<String> f8578b = new ArrayList();

    l() {
    }

    private void a(int[] iArr, String str) {
        this.f8577a.add(iArr);
        this.f8578b.add(str);
    }

    private synchronized void b() {
        if (this.f8577a.isEmpty()) {
            a(new int[]{0, 19}, "US/CA");
            a(new int[]{30, 39}, "US");
            a(new int[]{60, 139}, "US/CA");
            a(new int[]{300, 379}, "FR");
            a(new int[]{380}, "BG");
            a(new int[]{383}, "SI");
            a(new int[]{385}, "HR");
            a(new int[]{387}, "BA");
            a(new int[]{400, 440}, "DE");
            a(new int[]{TinkerReport.KEY_LOADED_INTERPRET_GET_INSTRUCTION_SET_ERROR, 459}, "JP");
            a(new int[]{460, 469}, "RU");
            a(new int[]{471}, STManager.REGION_OF_TW);
            a(new int[]{474}, "EE");
            a(new int[]{475}, "LV");
            a(new int[]{476}, "AZ");
            a(new int[]{477}, "LT");
            a(new int[]{478}, "UZ");
            a(new int[]{479}, "LK");
            a(new int[]{480}, STManager.REGION_OF_PH);
            a(new int[]{481}, "BY");
            a(new int[]{482}, "UA");
            a(new int[]{BuildConfig.VERSION_CODE}, "MD");
            a(new int[]{485}, "AM");
            a(new int[]{ReadingRechargeActivity.w0}, "GE");
            a(new int[]{487}, "KZ");
            a(new int[]{Downloads.Impl.STATUS_CANNOT_RESUME}, "HK");
            a(new int[]{Downloads.Impl.STATUS_CANCELED, 499}, "JP");
            a(new int[]{500, 509}, "GB");
            a(new int[]{520}, "GR");
            a(new int[]{528}, com.google.zxing.client.result.k.f8257c);
            a(new int[]{529}, "CY");
            a(new int[]{531}, "MK");
            a(new int[]{535}, "MT");
            a(new int[]{539}, "IE");
            a(new int[]{540, 549}, "BE/LU");
            a(new int[]{560}, "PT");
            a(new int[]{569}, "IS");
            a(new int[]{570, 579}, "DK");
            a(new int[]{590}, "PL");
            a(new int[]{594}, "RO");
            a(new int[]{599}, "HU");
            a(new int[]{600, 601}, "ZA");
            a(new int[]{603}, "GH");
            a(new int[]{608}, "BH");
            a(new int[]{609}, "MU");
            a(new int[]{611}, "MA");
            a(new int[]{613}, "DZ");
            a(new int[]{616}, "KE");
            a(new int[]{618}, "CI");
            a(new int[]{619}, "TN");
            a(new int[]{621}, "SY");
            a(new int[]{622}, "EG");
            a(new int[]{624}, "LY");
            a(new int[]{625}, "JO");
            a(new int[]{626}, "IR");
            a(new int[]{627}, "KW");
            a(new int[]{628}, "SA");
            a(new int[]{629}, "AE");
            a(new int[]{640, 649}, "FI");
            a(new int[]{690, 695}, STManager.REGION_OF_CN);
            a(new int[]{700, 709}, "NO");
            a(new int[]{729}, "IL");
            a(new int[]{730, 739}, "SE");
            a(new int[]{740}, "GT");
            a(new int[]{741}, "SV");
            a(new int[]{742}, "HN");
            a(new int[]{743}, "NI");
            a(new int[]{744}, "CR");
            a(new int[]{745}, "PA");
            a(new int[]{746}, "DO");
            a(new int[]{750}, "MX");
            a(new int[]{754, 755}, "CA");
            a(new int[]{759}, "VE");
            a(new int[]{760, 769}, "CH");
            a(new int[]{770}, "CO");
            a(new int[]{773}, "UY");
            a(new int[]{775}, "PE");
            a(new int[]{BookInfoActivity.R}, "BO");
            a(new int[]{779}, "AR");
            a(new int[]{780}, "CL");
            a(new int[]{784}, "PY");
            a(new int[]{785}, "PE");
            a(new int[]{786}, "EC");
            a(new int[]{789, 790}, "BR");
            a(new int[]{800, 839}, "IT");
            a(new int[]{840, 849}, "ES");
            a(new int[]{850}, "CU");
            a(new int[]{858}, "SK");
            a(new int[]{859}, "CZ");
            a(new int[]{860}, "YU");
            a(new int[]{865}, "MN");
            a(new int[]{867}, "KP");
            a(new int[]{868, 869}, "TR");
            a(new int[]{870, 879}, "NL");
            a(new int[]{880}, "KR");
            a(new int[]{885}, STManager.REGION_OF_TH);
            a(new int[]{888}, "SG");
            a(new int[]{890}, STManager.REGION_OF_IN);
            a(new int[]{893}, STManager.REGION_OF_VN);
            a(new int[]{896}, "PK");
            a(new int[]{899}, STManager.REGION_OF_ID);
            a(new int[]{900, 919}, "AT");
            a(new int[]{930, 939}, "AU");
            a(new int[]{940, 949}, "AZ");
            a(new int[]{955}, STManager.REGION_OF_MY);
            a(new int[]{958}, "MO");
        }
    }

    String c(String str) {
        int[] iArr;
        int i2;
        b();
        int parseInt = Integer.parseInt(str.substring(0, 3));
        int size = this.f8577a.size();
        for (int i3 = 0; i3 < size && parseInt >= (i2 = (iArr = this.f8577a.get(i3))[0]); i3++) {
            if (iArr.length != 1) {
                i2 = iArr[1];
            }
            if (parseInt <= i2) {
                return this.f8578b.get(i3);
            }
        }
        return null;
    }
}
