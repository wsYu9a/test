package com.google.zxing.pdf417.encoder;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.zxing.WriterException;
import com.martian.ads.ad.AdConfig;
import com.martian.mibook.activity.ReadingRechargeActivity;
import com.martian.mibook.activity.book.BookInfoActivity;
import com.qq.e.comm.adevent.AdEventType;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.vivo.ic.BuildConfig;
import com.vivo.ic.dm.Downloads;
import org.apache.http.HttpStatus;
import org.mozilla.universalchardet.prober.g;

/* loaded from: classes.dex */
final class e {

    /* renamed from: a */
    private static final int[][] f8733a = {new int[]{27, 917}, new int[]{522, 568, 723, 809}, new int[]{g.k, 308, 436, 284, 646, 653, 428, 379}, new int[]{274, TTAdConstant.STYLE_SIZE_RADIO_9_16, 232, 755, 599, 524, 801, 132, 295, 116, 442, 428, 295, 42, 176, 65}, new int[]{361, 575, 922, 525, 176, 586, 640, 321, 536, 742, 677, 742, 687, 284, Downloads.Impl.STATUS_PAUSED_BY_APP, 517, com.umeng.commonsdk.stateless.b.f26259a, Downloads.Impl.STATUS_UNHANDLED_HTTP_CODE, 263, 147, 593, 800, 571, 320, 803, 133, 231, 390, 685, 330, 63, 410}, new int[]{539, HttpStatus.SC_UNPROCESSABLE_ENTITY, 6, 93, 862, 771, 453, 106, 610, 287, 107, HttpStatus.SC_HTTP_VERSION_NOT_SUPPORTED, 733, 877, 381, 612, 723, 476, 462, 172, 430, 609, 858, 822, 543, 376, 511, 400, 672, 762, 283, TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, 440, 35, 519, 31, 460, 594, 225, 535, 517, TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META, 605, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 651, 201, 488, HttpStatus.SC_BAD_GATEWAY, 648, 733, 717, 83, 404, 97, 280, 771, 840, 629, 4, 381, 843, 623, 264, 543}, new int[]{521, 310, 864, 547, 858, 580, 296, 379, 53, 779, 897, 444, 400, 925, 749, 415, 822, 93, 217, 208, com.google.zxing.t.a.f8820b, g.p, 583, 620, g.r, 148, 447, 631, 292, 908, Downloads.Impl.STATUS_CANCELED, 704, 516, 258, 457, 907, 594, 723, 674, 292, 272, 96, 684, 432, 686, 606, 860, 569, Downloads.Impl.STATUS_PAUSED_BY_APP, BuildConfig.VERSION_CODE, 129, 186, 236, 287, Downloads.Impl.STATUS_RUNNING, 775, 278, 173, 40, 379, 712, 463, 646, 776, 171, Downloads.Impl.STATUS_UNKNOWN_ERROR, 297, 763, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL, 732, 95, 270, 447, 90, HttpStatus.SC_INSUFFICIENT_STORAGE, 48, 228, 821, AdConfig.ERROR_CODE_AD_BLOCK, 898, 784, 663, 627, 378, 382, 262, 380, 602, 754, 336, 89, 614, 87, 432, 670, 616, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META, 374, 242, 726, 600, 269, 375, 898, 845, 454, TinkerReport.KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, org.mozilla.universalchardet.prober.n.c.m, 814, 587, 804, 34, AdEventType.VIDEO_LOADING, 330, 539, 297, 827, 865, 37, 517, 834, 315, 550, 86, 801, 4, 108, 539}, new int[]{524, 894, 75, 766, 882, 857, 74, 204, 82, 586, 708, 250, 905, 786, 138, 720, 858, Downloads.Impl.STATUS_WAITING_TO_RETRY, 311, 913, 275, Downloads.Impl.STATUS_PENDING, 375, 850, 438, 733, Downloads.Impl.STATUS_WAITING_TO_RETRY, 280, 201, 280, 828, 757, 710, 814, 919, 89, 68, 569, 11, 204, 796, 605, 540, 913, 801, 700, 799, 137, 439, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 592, 668, TinkerReport.KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 859, 370, 694, 325, g.n, 216, 257, 284, 549, 209, 884, 315, 70, 329, 793, Downloads.Impl.STATUS_CANCELED, 274, 877, 162, 749, 812, 684, 461, 334, 376, 849, 521, 307, 291, 803, 712, 19, TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 399, 908, 103, 511, 51, 8, 517, 225, 289, Downloads.Impl.STATUS_UNKNOW_FILE_ERROR, 637, 731, 66, 255, 917, 269, 463, 830, 730, 433, 848, 585, 136, 538, 906, 90, 2, 290, 743, 199, 655, 903, 329, 49, 802, 580, TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL, 588, 188, 462, 10, 134, 628, 320, 479, org.mozilla.universalchardet.prober.n.c.m, 739, 71, 263, 318, 374, 601, Downloads.Impl.STATUS_RUNNING, 605, org.mozilla.universalchardet.prober.n.a.p, 673, 687, g.f35436i, 722, 384, 177, 752, 607, 640, 455, Downloads.Impl.STATUS_PAUSED_BY_APP, 689, 707, 805, 641, 48, 60, 732, 621, 895, 544, 261, 852, 655, TinkerReport.KEY_LOADED_INFO_CORRUPTED, 697, 755, 756, 60, 231, 773, 434, 421, 726, 528, 503, 118, 49, 795, 32, 144, 500, g.l, 836, 394, 280, 566, 319, 9, 647, 550, 73, 914, 342, org.mozilla.universalchardet.prober.o.a.n, 32, 681, 331, 792, 620, 60, 609, 441, TinkerReport.KEY_APPLIED_VERSION_CHECK, 791, 893, 754, 605, 383, 228, 749, 760, AdEventType.VIDEO_PRELOAD_ERROR, 54, 297, 134, 54, 834, 299, 922, 191, 910, 532, 609, 829, 189, 20, 167, 29, 872, 449, 83, 402, 41, 656, HttpStatus.SC_HTTP_VERSION_NOT_SUPPORTED, 579, 481, 173, 404, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 688, 95, Downloads.Impl.STATUS_TOO_MANY_REDIRECTS, 555, 642, 543, 307, 159, 924, 558, 648, 55, Downloads.Impl.STATUS_TOO_MANY_REDIRECTS, 10}, new int[]{TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META, 77, 373, HttpStatus.SC_GATEWAY_TIMEOUT, 35, 599, 428, 207, 409, 574, 118, 498, 285, 380, TinkerReport.KEY_LOADED_PACKAGE_CHECK_SIGNATURE, Downloads.Impl.STATUS_FILE_ERROR, 197, 265, 920, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND, 914, 299, 229, 643, 294, 871, TinkerReport.KEY_LOADED_MISSING_PATCH_INFO, 88, 87, Downloads.Impl.STATUS_PAUSED_BY_APP, TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META, 781, 846, 75, 327, 520, 435, 543, 203, TTAdConstant.STYLE_SIZE_RADIO_2_3, 249, 346, 781, 621, 640, 268, 794, 534, 539, 781, 408, 390, 644, 102, 476, 499, 290, 632, 545, 37, 858, 916, 552, 41, 542, 289, 122, 272, 383, 800, 485, 98, 752, 472, 761, 107, 784, 860, 658, 741, 290, 204, 681, 407, 855, 85, 99, 62, 482, TinkerReport.KEY_APPLIED_VERSION_CHECK, 20, 297, TinkerReport.KEY_LOADED_INTERPRET_INTERPRET_COMMAND_ERROR, 593, 913, org.mozilla.universalchardet.prober.n.a.p, AdConfig.ERROR_CODE_AD_BLOCK, 684, 287, 536, 561, 76, 653, 899, 729, 567, 744, 390, 513, Downloads.Impl.STATUS_RUNNING, 516, 258, g.n, 518, 794, 395, 768, 848, 51, 610, 384, 168, Downloads.Impl.STATUS_PENDING, 826, 328, 596, 786, 303, 570, 381, 415, 641, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL, g.k, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_DEX_META, 429, 531, 207, 676, 710, 89, 168, 304, 402, 40, 708, 575, 162, 864, 229, 65, 861, 841, 512, 164, 477, 221, 92, TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 785, 288, TinkerReport.KEY_LOADED_PACKAGE_CHECK_RES_META, 850, 836, 827, 736, 707, 94, 8, Downloads.Impl.STATUS_UNHANDLED_HTTP_CODE, 114, 521, 2, 499, 851, 543, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_LIB_META, 729, 771, 95, 248, 361, 578, 323, 856, 797, 289, 51, 684, 466, 533, 820, 669, 45, 902, TinkerReport.KEY_LOADED_INTERPRET_TYPE_INTERPRET_OK, 167, 342, g.p, 173, 35, 463, 651, 51, 699, 591, TinkerReport.KEY_LOADED_INTERPRET_TYPE_INTERPRET_OK, 578, 37, 124, 298, 332, 552, 43, 427, 119, 662, BookInfoActivity.R, 475, 850, 764, 364, 578, 911, 283, 711, 472, 420, g.q, 288, 594, 394, 511, 327, 589, BookInfoActivity.R, 699, 688, 43, 408, 842, 383, 721, 521, 560, 644, 714, 559, 62, 145, 873, 663, 713, 159, 672, 729, 624, 59, Downloads.Impl.STATUS_PAUSED_BY_APP, 417, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 209, 563, 564, 343, 693, 109, 608, 563, 365, TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, 772, 677, 310, 248, TinkerReport.KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 708, 410, 579, 870, 617, 841, 632, 860, 289, 536, 35, BookInfoActivity.R, 618, 586, HttpStatus.SC_FAILED_DEPENDENCY, 833, 77, 597, 346, 269, 757, 632, 695, 751, 331, 247, TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, 45, 787, 680, 18, 66, 407, 369, 54, Downloads.Impl.STATUS_FILE_ERROR, 228, 613, 830, 922, 437, 519, 644, 905, 789, 420, 305, 441, 207, 300, 892, 827, 141, 537, 381, 662, 513, 56, TinkerReport.KEY_LOADED_EXCEPTION_DEX, 341, 242, 797, 838, 837, 720, 224, 307, 631, 61, 87, 560, 310, 756, 665, 397, AdConfig.ERROR_CODE_AD_BLOCK, 851, TinkerReport.KEY_LOADED_INFO_CORRUPTED, 473, 795, 378, 31, 647, 915, 459, 806, 590, 731, ReadingRechargeActivity.x0, 216, 548, 249, 321, 881, 699, 535, 673, 782, 210, 815, 905, 303, 843, 922, 281, 73, 469, 791, 660, 162, 498, 308, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND, HttpStatus.SC_UNPROCESSABLE_ENTITY, 907, 817, 187, 62, 16, ReadingRechargeActivity.x0, 535, 336, 286, 437, 375, com.umeng.commonsdk.stateless.b.f26259a, 610, 296, TinkerReport.KEY_APPLIED_LIB_EXTRACT, 923, 116, 667, 751, TinkerReport.KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 62, 366, 691, 379, 687, 842, 37, TinkerReport.KEY_LOADED_PACKAGE_CHECK_RES_META, 720, 742, 330, 5, 39, 923, 311, HttpStatus.SC_FAILED_DEPENDENCY, 242, 749, 321, 54, 669, 316, 342, 299, 534, 105, 667, 488, 640, 672, 576, 540, 316, ReadingRechargeActivity.w0, 721, 610, 46, 656, 447, 171, 616, 464, Downloads.Impl.STATUS_PENDING, 531, 297, 321, 762, 752, 533, 175, 134, 14, 381, 433, 717, 45, 111, 20, 596, 284, 736, 138, 646, 411, 877, 669, 141, 919, 45, 780, 407, 164, 332, 899, 165, 726, 600, 325, 498, 655, TinkerReport.KEY_LOADED_PACKAGE_CHECK_RES_META, 752, 768, 223, 849, 647, 63, 310, 863, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 366, 304, 282, 738, 675, 410, 389, g.p, 31, 121, 303, 263}};

    private e() {
    }

    static String a(CharSequence charSequence, int i2) {
        int b2 = b(i2);
        char[] cArr = new char[b2];
        int length = charSequence.length();
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = b2 - 1;
            int charAt = (charSequence.charAt(i3) + cArr[i4]) % com.google.zxing.t.a.f8819a;
            while (i4 > 0) {
                cArr[i4] = (char) ((cArr[i4 - 1] + (929 - ((f8733a[i2][i4] * charAt) % com.google.zxing.t.a.f8819a))) % com.google.zxing.t.a.f8819a);
                i4--;
            }
            cArr[0] = (char) ((929 - ((charAt * f8733a[i2][0]) % com.google.zxing.t.a.f8819a)) % com.google.zxing.t.a.f8819a);
        }
        StringBuilder sb = new StringBuilder(b2);
        for (int i5 = b2 - 1; i5 >= 0; i5--) {
            if (cArr[i5] != 0) {
                cArr[i5] = (char) (929 - cArr[i5]);
            }
            sb.append(cArr[i5]);
        }
        return sb.toString();
    }

    static int b(int i2) {
        if (i2 < 0 || i2 > 8) {
            throw new IllegalArgumentException("Error correction level must be between 0 and 8!");
        }
        return 1 << (i2 + 1);
    }

    static int c(int i2) throws WriterException {
        if (i2 <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }
        if (i2 <= 40) {
            return 2;
        }
        if (i2 <= 160) {
            return 3;
        }
        if (i2 <= 320) {
            return 4;
        }
        if (i2 <= 863) {
            return 5;
        }
        throw new WriterException("No recommendation possible");
    }
}
