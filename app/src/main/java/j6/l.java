package j6;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.martian.mibook.activity.ReadingRechargeActivity;
import com.martian.mibook.mvvm.book.activity.BookDetailActivity;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.vivo.push.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import ya.j1;

/* loaded from: classes2.dex */
public final class l {

    /* renamed from: a */
    public final List<int[]> f27213a = new ArrayList();

    /* renamed from: b */
    public final List<String> f27214b = new ArrayList();

    public final void a(int[] iArr, String str) {
        this.f27213a.add(iArr);
        this.f27214b.add(str);
    }

    public final synchronized void b() {
        if (this.f27213a.isEmpty()) {
            a(new int[]{0, 19}, "US/CA");
            a(new int[]{30, 39}, "US");
            a(new int[]{60, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_CLICK_TRACK_URL}, "US/CA");
            a(new int[]{300, 379}, "FR");
            a(new int[]{380}, "BG");
            a(new int[]{383}, "SI");
            a(new int[]{385}, "HR");
            a(new int[]{387}, "BA");
            a(new int[]{400, 440}, "DE");
            a(new int[]{TinkerReport.KEY_LOADED_INTERPRET_GET_INSTRUCTION_SET_ERROR, 459}, "JP");
            a(new int[]{p3.k.f29768i, 469}, "RU");
            a(new int[]{471}, "TW");
            a(new int[]{474}, "EE");
            a(new int[]{475}, "LV");
            a(new int[]{476}, "AZ");
            a(new int[]{477}, "LT");
            a(new int[]{478}, "UZ");
            a(new int[]{479}, "LK");
            a(new int[]{qe.c.f30024n}, "PH");
            a(new int[]{481}, "BY");
            a(new int[]{482}, "UA");
            a(new int[]{BuildConfig.VERSION_CODE}, "MD");
            a(new int[]{485}, "AM");
            a(new int[]{ReadingRechargeActivity.f13117p0}, "GE");
            a(new int[]{487}, "KZ");
            a(new int[]{489}, "HK");
            a(new int[]{na.a.f28835e, 499}, "JP");
            a(new int[]{500, 509}, "GB");
            a(new int[]{520}, "GR");
            a(new int[]{528}, y5.k.f33027r);
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
            a(new int[]{TypedValues.MotionType.TYPE_EASING}, "GH");
            a(new int[]{TypedValues.MotionType.TYPE_DRAW_PATH}, "BH");
            a(new int[]{TypedValues.MotionType.TYPE_POLAR_RELATIVETO}, "MU");
            a(new int[]{TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE}, "MA");
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
            a(new int[]{690, 695}, "CN");
            a(new int[]{TypedValues.TransitionType.TYPE_DURATION, 709}, "NO");
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
            a(new int[]{BookDetailActivity.f14048s}, "BO");
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
            a(new int[]{868, TTAdConstant.VALUE_CLICK_AREA_OTHER}, "TR");
            a(new int[]{870, 879}, "NL");
            a(new int[]{880}, "KR");
            a(new int[]{885}, "TH");
            a(new int[]{j1.f33256a}, "SG");
            a(new int[]{890}, "IN");
            a(new int[]{893}, "VN");
            a(new int[]{896}, "PK");
            a(new int[]{899}, "ID");
            a(new int[]{900, 919}, "AT");
            a(new int[]{930, 939}, "AU");
            a(new int[]{940, 949}, "AZ");
            a(new int[]{955}, "MY");
            a(new int[]{958}, "MO");
        }
    }

    public String c(String str) {
        int[] iArr;
        int i10;
        b();
        int parseInt = Integer.parseInt(str.substring(0, 3));
        int size = this.f27213a.size();
        for (int i11 = 0; i11 < size && parseInt >= (i10 = (iArr = this.f27213a.get(i11))[0]); i11++) {
            if (iArr.length != 1) {
                i10 = iArr[1];
            }
            if (parseInt <= i10) {
                return this.f27214b.get(i11);
            }
        }
        return null;
    }
}
