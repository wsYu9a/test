package com.google.zxing.r.b;

import com.bytedance.sdk.openadsdk.TTAdConstant;
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
final class a {

    /* renamed from: a */
    private static final int[][] f8799a = {new int[]{121, 120, 127, org.mozilla.universalchardet.prober.o.a.n, 133, 132, 139, 138, 145, 144, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_DEX_META, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL, 163, 162, 169, 168, 175, 174, TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, TinkerReport.KEY_APPLIED_VERSION_CHECK, 187, 186, Downloads.Impl.STATUS_PAUSED_BY_APP, Downloads.Impl.STATUS_RUNNING, 199, Downloads.Impl.STATUS_INSUFFICIENT_SPACE_ERROR, -2, -2}, new int[]{123, 122, 129, 128, 135, 134, 141, 140, 147, 146, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_LIB_META, 159, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 165, 164, 171, 170, 177, 176, TinkerReport.KEY_APPLIED_LIB_EXTRACT, TinkerReport.KEY_APPLIED_DEX_EXTRACT, 189, 188, Downloads.Impl.STATUS_WAITING_FOR_NETWORK, Downloads.Impl.STATUS_WAITING_TO_RETRY, 201, 200, 816, -3}, new int[]{125, 124, TTAdConstant.IMAGE_MODE_SPLASH, org.mozilla.universalchardet.prober.n.c.m, 137, 136, org.mozilla.universalchardet.prober.n.a.q, org.mozilla.universalchardet.prober.n.a.p, 149, 148, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, 161, 160, 167, TTAdConstant.IMAGE_MODE_LIVE, 173, 172, 179, 178, 185, TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, 191, Downloads.Impl.STATUS_PENDING, 197, 196, 203, 202, 818, 817}, new int[]{283, 282, 277, 276, 271, 270, 265, 264, 259, 258, TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK, TinkerReport.KEY_LOADED_EXCEPTION_DEX, 247, g.r, org.mozilla.universalchardet.prober.n.c.o, g.n, g.f35437j, g.f35436i, 229, 228, 223, 222, 217, 216, AdEventType.VIDEO_LOADING, 210, 205, 204, 819, -3}, new int[]{285, 284, 279, 278, com.umeng.commonsdk.stateless.b.f26259a, 272, 267, 266, 261, 260, 255, 254, 249, 248, 243, 242, g.k, 236, 231, 230, 225, 224, BuildConfig.VERSION_CODE, 218, AdEventType.VIDEO_PRELOAD_ERROR, AdEventType.VIDEO_PRELOADED, 207, 206, 821, 820}, new int[]{287, 286, 281, 280, 275, 274, 269, 268, 263, 262, 257, 256, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 250, g.q, g.p, 239, g.l, 233, 232, 227, 226, 221, 220, 215, 214, 209, 208, 822, -3}, new int[]{289, 288, 295, 294, 301, 300, 307, TinkerReport.KEY_LOADED_MISSING_PATCH_INFO, 313, 312, 319, 318, 325, 324, 331, 330, 337, 336, 343, 342, 349, 348, TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL, TinkerReport.KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, 361, 360, 367, 366, 824, 823}, new int[]{291, 290, 297, 296, 303, 302, TinkerReport.KEY_LOADED_INFO_CORRUPTED, 308, 315, 314, 321, 320, 327, 326, 333, 332, 339, 338, 345, 344, TinkerReport.KEY_LOADED_PACKAGE_CHECK_DEX_META, TinkerReport.KEY_LOADED_PACKAGE_CHECK_SIGNATURE, TinkerReport.KEY_LOADED_PACKAGE_CHECK_RES_META, TinkerReport.KEY_LOADED_PACKAGE_CHECK_PACKAGE_META_NOT_FOUND, 363, 362, 369, 368, 825, -3}, new int[]{293, 292, 299, 298, 305, 304, 311, 310, 317, 316, 323, 322, 329, 328, 335, 334, 341, 340, 347, 346, TinkerReport.KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META, 359, TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 365, 364, 371, 370, 827, 826}, new int[]{409, 408, 403, 402, 397, 396, 391, 390, 79, 78, -2, -2, 13, 12, 37, 36, 2, -1, 44, 43, 109, 108, 385, 384, 379, 378, 373, 372, 828, -3}, new int[]{411, 410, 405, 404, 399, 398, 393, 392, 81, 80, 40, -2, 15, 14, 39, 38, 3, -1, -1, 45, 111, 110, 387, 386, 381, 380, 375, 374, 830, 829}, new int[]{413, 412, 407, 406, 401, 400, 395, 394, 83, 82, 41, -3, -3, -3, -3, -3, 5, 4, 47, 46, 113, 112, 389, 388, 383, 382, 377, 376, 831, -3}, new int[]{415, 414, 421, 420, 427, 426, 103, 102, 55, 54, 16, -3, -3, -3, -3, -3, -3, -3, 20, 19, 85, 84, 433, 432, 439, 438, 445, 444, 833, 832}, new int[]{417, 416, HttpStatus.SC_LOCKED, HttpStatus.SC_UNPROCESSABLE_ENTITY, 429, 428, 105, 104, 57, 56, -3, -3, -3, -3, -3, -3, -3, -3, 22, 21, 87, 86, 435, 434, 441, 440, 447, 446, 834, -3}, new int[]{HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, TTAdConstant.DEEPLINK_FALL_BACK_CODE, ReadingRechargeActivity.x0, HttpStatus.SC_FAILED_DEPENDENCY, 431, 430, 107, 106, 59, 58, -3, -3, -3, -3, -3, -3, -3, -3, -3, 23, 89, 88, 437, 436, 443, 442, 449, 448, 836, 835}, new int[]{481, 480, 475, 474, 469, 468, 48, -2, 30, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 0, 53, 52, 463, 462, 457, 456, TinkerReport.KEY_LOADED_INTERPRET_INTERPRET_COMMAND_ERROR, TinkerReport.KEY_LOADED_INTERPRET_GET_INSTRUCTION_SET_ERROR, 837, -3}, new int[]{483, 482, 477, 476, 471, Downloads.Impl.STATUS_UNKNOW_FILE_ERROR, 49, -1, -2, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -2, -1, 465, 464, 459, 458, 453, TinkerReport.KEY_LOADED_INTERPRET_TYPE_INTERPRET_OK, 839, 838}, new int[]{485, com.vivo.push.BuildConfig.VERSION_CODE, 479, 478, 473, 472, 51, 50, 31, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 1, -2, 42, 467, 466, 461, 460, 455, 454, 840, -3}, new int[]{487, ReadingRechargeActivity.w0, 493, Downloads.Impl.STATUS_FILE_ERROR, 499, 498, 97, 96, 61, 60, -3, -3, -3, -3, -3, -3, -3, -3, -3, 26, 91, 90, HttpStatus.SC_HTTP_VERSION_NOT_SUPPORTED, HttpStatus.SC_GATEWAY_TIMEOUT, 511, 510, 517, 516, 842, 841}, new int[]{Downloads.Impl.STATUS_CANNOT_RESUME, 488, Downloads.Impl.STATUS_HTTP_DATA_ERROR, Downloads.Impl.STATUS_UNHANDLED_HTTP_CODE, HttpStatus.SC_NOT_IMPLEMENTED, 500, 99, 98, 63, 62, -3, -3, -3, -3, -3, -3, -3, -3, 28, 27, 93, 92, HttpStatus.SC_INSUFFICIENT_STORAGE, 506, 513, 512, 519, 518, 843, -3}, new int[]{Downloads.Impl.STATUS_UNKNOWN_ERROR, Downloads.Impl.STATUS_CANCELED, Downloads.Impl.STATUS_TOO_MANY_REDIRECTS, Downloads.Impl.STATUS_HTTP_EXCEPTION, 503, HttpStatus.SC_BAD_GATEWAY, 101, 100, 65, 64, 17, -3, -3, -3, -3, -3, -3, -3, 18, 29, 95, 94, 509, 508, 515, 514, 521, 520, 845, 844}, new int[]{559, 558, 553, 552, 547, 546, 541, 540, 73, 72, 32, -3, -3, -3, -3, -3, -3, 10, 67, 66, 115, 114, 535, 534, 529, 528, 523, 522, 846, -3}, new int[]{561, 560, 555, 554, 549, 548, 543, 542, 75, 74, -2, -1, 7, 6, 35, 34, 11, -2, 69, 68, 117, 116, 537, 536, 531, 530, 525, 524, 848, 847}, new int[]{563, TTAdConstant.STYLE_SIZE_RADIO_9_16, 557, 556, 551, 550, 545, 544, 77, 76, -2, 33, 9, 8, 25, 24, -1, -2, 71, 70, 119, 118, 539, 538, 533, 532, 527, 526, 849, -3}, new int[]{565, 564, 571, 570, 577, 576, 583, 582, 589, 588, 595, 594, 601, 600, 607, 606, 613, 612, 619, 618, 625, 624, 631, 630, 637, 636, 643, 642, 851, 850}, new int[]{567, 566, 573, 572, 579, 578, 585, 584, 591, 590, 597, 596, 603, 602, 609, 608, 615, 614, 621, 620, 627, 626, 633, 632, 639, 638, 645, 644, 852, -3}, new int[]{569, 568, 575, 574, 581, 580, 587, 586, 593, 592, 599, 598, 605, 604, 611, 610, 617, 616, 623, 622, 629, 628, 635, 634, 641, 640, 647, 646, 854, 853}, new int[]{727, 726, 721, 720, 715, 714, 709, 708, 703, 702, 697, 696, 691, 690, 685, 684, 679, 678, 673, 672, 667, TTAdConstant.STYLE_SIZE_RADIO_2_3, 661, 660, 655, 654, 649, 648, 855, -3}, new int[]{729, 728, 723, 722, 717, 716, 711, 710, 705, 704, 699, 698, 693, 692, 687, 686, 681, 680, 675, 674, 669, 668, 663, 662, 657, 656, 651, 650, 857, 856}, new int[]{731, 730, 725, 724, 719, 718, 713, 712, 707, 706, 701, 700, 695, 694, 689, 688, 683, 682, 677, 676, 671, 670, 665, 664, 659, 658, 653, 652, 858, -3}, new int[]{733, 732, 739, 738, 745, 744, 751, 750, 757, 756, 763, 762, 769, 768, 775, 774, 781, 780, 787, 786, 793, 792, 799, 798, 805, 804, 811, 810, 860, 859}, new int[]{735, 734, 741, 740, 747, 746, 753, 752, 759, 758, 765, 764, 771, 770, BookInfoActivity.R, 776, 783, 782, 789, 788, 795, 794, 801, 800, 807, 806, 813, 812, 861, -3}, new int[]{737, 736, 743, 742, 749, 748, 755, 754, 761, 760, 767, 766, 773, 772, 779, 778, 785, 784, 791, 790, 797, 796, 803, 802, 809, AdConfig.ERROR_CODE_AD_BLOCK, 815, 814, 863, 862}};

    /* renamed from: b */
    private final com.google.zxing.common.b f8800b;

    a(com.google.zxing.common.b bVar) {
        this.f8800b = bVar;
    }

    byte[] a() {
        byte[] bArr = new byte[144];
        int h2 = this.f8800b.h();
        int l = this.f8800b.l();
        for (int i2 = 0; i2 < h2; i2++) {
            int[] iArr = f8799a[i2];
            for (int i3 = 0; i3 < l; i3++) {
                int i4 = iArr[i3];
                if (i4 >= 0 && this.f8800b.e(i3, i2)) {
                    int i5 = i4 / 6;
                    bArr[i5] = (byte) (((byte) (1 << (5 - (i4 % 6)))) | bArr[i5]);
                }
            }
        }
        return bArr;
    }
}
