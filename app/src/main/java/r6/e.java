package r6;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.InputDeviceCompat;
import com.alimm.tanx.core.constant.AdType;
import com.baidu.mobads.sdk.internal.ck;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.zxing.WriterException;
import com.google.zxing.pdf417.decoder.DecodedBitStreamParser;
import com.martian.ads.ad.AdConfig;
import com.martian.mibook.activity.ReadingRechargeActivity;
import com.martian.mibook.fragment.BookMarkFragment;
import com.martian.mibook.mvvm.book.activity.BookDetailActivity;
import com.qq.e.comm.adevent.AdEventType;
import com.tencent.bugly.beta.tinker.TinkerReport;
import org.mozilla.universalchardet.prober.g;
import p3.k;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a */
    public static final int[][] f30338a = {new int[]{27, AdType.BOTTOM_FLOATING}, new int[]{522, 568, 723, 809}, new int[]{g.f29291r, 308, 436, 284, 646, 653, 428, 379}, new int[]{274, TTAdConstant.STYLE_SIZE_RADIO_9_16, 232, 755, 599, 524, 801, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID, 295, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_EXECUTOR_GROUP, 442, 428, 295, 42, 176, 65}, new int[]{361, 575, DecodedBitStreamParser.f10597j, 525, 176, 586, 640, 321, 536, 742, 677, 742, 687, 284, 193, 517, com.umeng.commonsdk.stateless.b.f24569a, 494, com.sigmob.sdk.archives.tar.e.f17568m, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_NAME, 593, 800, 571, 320, 803, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_AD, 231, 390, 685, 330, 63, TTAdConstant.IMAGE_LIST_SIZE_CODE}, new int[]{539, TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, 6, 93, 862, 771, 453, 106, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 287, 107, TypedValues.PositionType.TYPE_SIZE_PERCENT, 733, 877, 381, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID, 723, 476, 462, 172, 430, TypedValues.MotionType.TYPE_POLAR_RELATIVETO, 858, 822, 543, 376, FrameMetricsAggregator.EVERY_DURATION, 400, 672, 762, 283, TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, 440, 35, 519, 31, k.f29768i, 594, 225, 535, 517, TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 651, 201, 488, TypedValues.PositionType.TYPE_DRAWPATH, 648, 733, 717, 83, 404, 97, 280, 771, 840, 629, 4, 381, ck.f7039c, 623, 264, 543}, new int[]{521, 310, 864, 547, 858, 580, 296, 379, 53, 779, 897, 444, 400, 925, 749, TTAdConstant.VIDEO_COVER_URL_CODE, 822, 93, 217, 208, 928, g.f29296w, 583, 620, g.f29298y, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NEED_INDEPENDENT_PROCESS, 447, 631, 292, 908, na.a.f28835e, TypedValues.TransitionType.TYPE_AUTO_TRANSITION, 516, 258, 457, 907, 594, 723, 674, 292, 272, 96, 684, 432, 686, TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO, 860, 569, 193, 219, 129, 186, 236, 287, 192, 775, 278, 173, 40, 379, 712, 463, 646, 776, 171, 491, 297, 763, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL, 732, 95, 270, 447, 90, TypedValues.PositionType.TYPE_PERCENT_Y, 48, 228, 821, AdConfig.ERROR_CODE_AD_BLOCK, 898, 784, 663, 627, 378, 382, 262, 380, TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE, 754, 336, 89, 614, 87, 432, 670, 616, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META, 374, 242, 726, 600, 269, 375, 898, 845, 454, TinkerReport.KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, 130, 814, 587, 804, 34, AdEventType.VIDEO_LOADING, 330, 539, 297, 827, 865, 37, 517, 834, 315, 550, 86, 801, 4, 108, 539}, new int[]{524, 894, 75, 766, 882, 857, 74, 204, 82, 586, 708, 250, TypedValues.Custom.TYPE_DIMENSION, 786, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK, 720, 858, 194, 311, 913, 275, 190, 375, 850, 438, 733, 194, 280, 201, 280, 828, 757, 710, 814, 919, 89, 68, 569, 11, 204, 796, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, 540, 913, 801, TypedValues.TransitionType.TYPE_DURATION, 799, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_APP_ICON, 439, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 592, 668, TinkerReport.KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 859, 370, 694, 325, 240, 216, 257, 284, 549, 209, 884, 315, 70, 329, 793, na.a.f28835e, 274, 877, 162, 749, 812, 684, 461, 334, 376, 849, 521, 307, 291, 803, 712, 19, TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 399, 908, 103, FrameMetricsAggregator.EVERY_DURATION, 51, 8, 517, 225, 289, 470, 637, 731, 66, 255, AdType.BOTTOM_FLOATING, 269, 463, 830, 730, 433, 848, 585, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, 538, TypedValues.Custom.TYPE_REFERENCE, 90, 2, 290, 743, BookMarkFragment.f13618i, 655, TypedValues.Custom.TYPE_STRING, 329, 49, 802, 580, TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL, 588, 188, 462, 10, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE, 628, 320, 479, 130, 739, 71, com.sigmob.sdk.archives.tar.e.f17568m, TypedValues.AttributesType.TYPE_PIVOT_TARGET, 374, 601, 192, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, 142, 673, 687, g.f29289p, 722, 384, 177, 752, TypedValues.MotionType.TYPE_PATHMOTION_ARC, 640, 455, 193, 689, TypedValues.TransitionType.TYPE_TRANSITION_FLAGS, 805, 641, 48, 60, 732, 621, 895, 544, 261, 852, 655, 309, 697, 755, 756, 60, 231, 773, 434, 421, 726, 528, TypedValues.PositionType.TYPE_PERCENT_WIDTH, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_START_TOAST, 49, 795, 32, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_HEADERS, 500, g.f29292s, 836, 394, 280, 566, 319, 9, 647, 550, 73, 914, 342, 126, 32, 681, 331, 792, 620, 60, TypedValues.MotionType.TYPE_POLAR_RELATIVETO, 441, TinkerReport.KEY_APPLIED_VERSION_CHECK, 791, 893, 754, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, 383, 228, 749, 760, AdEventType.VIDEO_PRELOAD_ERROR, 54, 297, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE, 54, 834, 299, DecodedBitStreamParser.f10597j, 191, 910, 532, TypedValues.MotionType.TYPE_POLAR_RELATIVETO, 829, 189, 20, 167, 29, 872, 449, 83, 402, 41, 656, TypedValues.PositionType.TYPE_SIZE_PERCENT, 579, 481, 173, 404, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 688, 95, 497, 555, 642, 543, 307, 159, 924, 558, 648, 55, 497, 10}, new int[]{TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META, 77, 373, 504, 35, 599, 428, 207, TTAdConstant.IMAGE_LIST_CODE, 574, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_START_TOAST, 498, 285, 380, TinkerReport.KEY_LOADED_PACKAGE_CHECK_SIGNATURE, 492, 197, 265, 920, 155, 914, 299, 229, 643, 294, 871, 306, 88, 87, 193, TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META, 781, 846, 75, 327, 520, 435, 543, 203, TTAdConstant.STYLE_SIZE_RADIO_2_3, 249, 346, 781, 621, 640, 268, 794, 534, 539, 781, TTAdConstant.INTERACTION_TYPE_CODE, 390, 644, 102, 476, 499, 290, 632, 545, 37, 858, 916, 552, 41, 542, 289, 122, 272, 383, 800, 485, 98, 752, 472, 761, 107, 784, 860, 658, 741, 290, 204, 681, 407, 855, 85, 99, 62, 482, TinkerReport.KEY_APPLIED_VERSION_CHECK, 20, 297, TinkerReport.KEY_LOADED_INTERPRET_INTERPRET_COMMAND_ERROR, 593, 913, 142, AdConfig.ERROR_CODE_AD_BLOCK, 684, 287, 536, 561, 76, 653, 899, 729, 567, 744, 390, InputDeviceCompat.SOURCE_DPAD, 192, 516, 258, 240, 518, 794, 395, 768, 848, 51, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 384, 168, 190, 826, 328, 596, 786, 303, 570, 381, TTAdConstant.VIDEO_COVER_URL_CODE, 641, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL, g.f29291r, 151, 429, 531, 207, 676, 710, 89, 168, 304, 402, 40, 708, 575, 162, 864, 229, 65, 861, 841, 512, 164, 477, 221, 92, TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 785, 288, 357, 850, 836, 827, 736, TypedValues.TransitionType.TYPE_TRANSITION_FLAGS, 94, 8, 494, 114, 521, 2, 499, 851, 543, 152, 729, 771, 95, 248, 361, 578, 323, 856, 797, 289, 51, 684, 466, 533, 820, 669, 45, 902, TinkerReport.KEY_LOADED_INTERPRET_TYPE_INTERPRET_OK, 167, 342, g.f29296w, 173, 35, 463, 651, 51, 699, 591, TinkerReport.KEY_LOADED_INTERPRET_TYPE_INTERPRET_OK, 578, 37, 124, 298, 332, 552, 43, 427, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_SDK_MONITOR_SCENE, 662, BookDetailActivity.f14048s, 475, 850, 764, 364, 578, 911, 283, 711, 472, TypedValues.CycleType.TYPE_EASING, g.f29297x, 288, 594, 394, FrameMetricsAggregator.EVERY_DURATION, 327, 589, BookDetailActivity.f14048s, 699, 688, 43, TTAdConstant.INTERACTION_TYPE_CODE, 842, 383, 721, 521, 560, 644, 714, 559, 62, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_SHOW_NOTIFICATION, 873, 663, 713, 159, 672, 729, 624, 59, 193, TTAdConstant.LIVE_FEED_URL_CODE, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 209, 563, 564, 343, 693, 109, TypedValues.MotionType.TYPE_DRAW_PATH, 563, 365, TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, 772, 677, 310, 248, TinkerReport.KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 708, TTAdConstant.IMAGE_LIST_SIZE_CODE, 579, 870, 617, 841, 632, 860, 289, 536, 35, BookDetailActivity.f14048s, 618, 586, TypedValues.CycleType.TYPE_WAVE_OFFSET, 833, 77, 597, 346, 269, 757, 632, 695, 751, 331, 247, TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, 45, 787, 680, 18, 66, 407, 369, 54, 492, 228, 613, 830, DecodedBitStreamParser.f10597j, 437, 519, 644, TypedValues.Custom.TYPE_DIMENSION, 789, TypedValues.CycleType.TYPE_EASING, 305, 441, 207, 300, 892, 827, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS, 537, 381, 662, InputDeviceCompat.SOURCE_DPAD, 56, TinkerReport.KEY_LOADED_EXCEPTION_DEX, 341, 242, 797, 838, 837, 720, 224, 307, 631, 61, 87, 560, 310, 756, 665, 397, AdConfig.ERROR_CODE_AD_BLOCK, 851, 309, 473, 795, 378, 31, 647, 915, 459, 806, 590, 731, 425, 216, 548, 249, 321, 881, 699, 535, 673, 782, 210, 815, TypedValues.Custom.TYPE_DIMENSION, 303, ck.f7039c, DecodedBitStreamParser.f10597j, 281, 73, 469, 791, 660, 162, 498, 308, 155, TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, 907, 817, 187, 62, 16, 425, 535, 336, 286, 437, 375, com.umeng.commonsdk.stateless.b.f24569a, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 296, TinkerReport.KEY_APPLIED_LIB_EXTRACT, DecodedBitStreamParser.f10596i, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_EXECUTOR_GROUP, 667, 751, TinkerReport.KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 62, 366, 691, 379, 687, 842, 37, 357, 720, 742, 330, 5, 39, DecodedBitStreamParser.f10596i, 311, TypedValues.CycleType.TYPE_WAVE_OFFSET, 242, 749, 321, 54, 669, TypedValues.AttributesType.TYPE_PATH_ROTATE, 342, 299, 534, 105, 667, 488, 640, 672, 576, 540, TypedValues.AttributesType.TYPE_PATH_ROTATE, ReadingRechargeActivity.f13117p0, 721, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 46, 656, 447, 171, 616, 464, 190, 531, 297, 321, 762, 752, 533, 175, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE, 14, 381, 433, 717, 45, 111, 20, 596, 284, 736, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK, 646, TTAdConstant.IMAGE_CODE, 877, 669, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS, 919, 45, 780, 407, 164, 332, 899, 165, 726, 600, 325, 498, 655, 357, 752, 768, 223, 849, 647, 63, 310, 863, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 366, 304, 282, 738, 675, TTAdConstant.IMAGE_LIST_SIZE_CODE, 389, g.f29296w, 31, 121, 303, com.sigmob.sdk.archives.tar.e.f17568m}};

    public static String a(CharSequence charSequence, int i10) {
        int b10 = b(i10);
        char[] cArr = new char[b10];
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = b10 - 1;
            int charAt = (charSequence.charAt(i11) + cArr[i12]) % n6.a.f28782a;
            while (i12 > 0) {
                cArr[i12] = (char) ((cArr[i12 - 1] + (929 - ((f30338a[i10][i12] * charAt) % n6.a.f28782a))) % n6.a.f28782a);
                i12--;
            }
            cArr[0] = (char) ((929 - ((charAt * f30338a[i10][0]) % n6.a.f28782a)) % n6.a.f28782a);
        }
        StringBuilder sb2 = new StringBuilder(b10);
        for (int i13 = b10 - 1; i13 >= 0; i13--) {
            char c10 = cArr[i13];
            if (c10 != 0) {
                cArr[i13] = (char) (929 - c10);
            }
            sb2.append(cArr[i13]);
        }
        return sb2.toString();
    }

    public static int b(int i10) {
        if (i10 < 0 || i10 > 8) {
            throw new IllegalArgumentException("Error correction level must be between 0 and 8!");
        }
        return 1 << (i10 + 1);
    }

    public static int c(int i10) throws WriterException {
        if (i10 <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }
        if (i10 <= 40) {
            return 2;
        }
        if (i10 <= 160) {
            return 3;
        }
        if (i10 <= 320) {
            return 4;
        }
        if (i10 <= 863) {
            return 5;
        }
        throw new WriterException("No recommendation possible");
    }
}
