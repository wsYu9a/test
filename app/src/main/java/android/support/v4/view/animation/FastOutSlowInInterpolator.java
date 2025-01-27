package android.support.v4.view.animation;

/* loaded from: classes7.dex */
public class FastOutSlowInInterpolator extends LookupTableInterpolator {
    private static final float[] VALUES;

    static {
        float[] fArr = new float[((Integer) new Object[]{new Integer(4879929)}[0]).intValue() ^ 4880112];
        fArr[0] = 0.0f;
        fArr[1] = 1.0E-4f;
        fArr[2] = 2.0E-4f;
        fArr[3] = 5.0E-4f;
        fArr[4] = 9.0E-4f;
        fArr[5] = 0.0014f;
        fArr[6] = 0.002f;
        fArr[7] = 0.0027f;
        fArr[8] = 0.0036f;
        fArr[9] = 0.0046f;
        fArr[10] = 0.0058f;
        fArr[11] = 0.0071f;
        fArr[12] = 0.0085f;
        fArr[13] = 0.0101f;
        fArr[14] = 0.0118f;
        fArr[15] = 0.0137f;
        fArr[16] = 0.0158f;
        fArr[17] = 0.018f;
        fArr[18] = 0.0205f;
        fArr[19] = 0.0231f;
        fArr[20] = 0.0259f;
        fArr[21] = 0.0289f;
        fArr[22] = 0.0321f;
        fArr[23] = 0.0355f;
        fArr[24] = 0.0391f;
        fArr[25] = 0.043f;
        fArr[26] = 0.0471f;
        fArr[27] = 0.0514f;
        fArr[28] = 0.056f;
        fArr[29] = 0.0608f;
        fArr[30] = 0.066f;
        fArr[31] = 0.0714f;
        fArr[32] = 0.0771f;
        fArr[33] = 0.083f;
        fArr[34] = 0.0893f;
        fArr[35] = 0.0959f;
        fArr[36] = 0.1029f;
        fArr[37] = 0.1101f;
        fArr[38] = 0.1177f;
        fArr[39] = 0.1257f;
        fArr[40] = 0.1339f;
        fArr[41] = 0.1426f;
        fArr[42] = 0.1516f;
        fArr[43] = 0.161f;
        fArr[44] = 0.1707f;
        fArr[45] = 0.1808f;
        fArr[46] = 0.1913f;
        fArr[47] = 0.2021f;
        fArr[48] = 0.2133f;
        fArr[49] = 0.2248f;
        fArr[50] = 0.2366f;
        fArr[51] = 0.2487f;
        fArr[52] = 0.2611f;
        fArr[53] = 0.2738f;
        fArr[54] = 0.2867f;
        fArr[55] = 0.2998f;
        fArr[56] = 0.3131f;
        fArr[57] = 0.3265f;
        fArr[58] = 0.34f;
        fArr[59] = 0.3536f;
        fArr[60] = 0.3673f;
        fArr[61] = 0.381f;
        fArr[62] = 0.3946f;
        fArr[63] = 0.4082f;
        fArr[64] = 0.4217f;
        fArr[65] = 0.4352f;
        fArr[66] = 0.4485f;
        fArr[67] = 0.4616f;
        fArr[68] = 0.4746f;
        fArr[69] = 0.4874f;
        fArr[70] = 0.5f;
        fArr[71] = 0.5124f;
        fArr[72] = 0.5246f;
        fArr[73] = 0.5365f;
        fArr[74] = 0.5482f;
        fArr[75] = 0.5597f;
        fArr[76] = 0.571f;
        fArr[77] = 0.582f;
        fArr[78] = 0.5928f;
        fArr[79] = 0.6033f;
        fArr[80] = 0.6136f;
        fArr[81] = 0.6237f;
        fArr[82] = 0.6335f;
        fArr[83] = 0.6431f;
        fArr[84] = 0.6525f;
        fArr[85] = 0.6616f;
        fArr[86] = 0.6706f;
        fArr[87] = 0.6793f;
        fArr[88] = 0.6878f;
        fArr[89] = 0.6961f;
        fArr[90] = 0.7043f;
        fArr[91] = 0.7122f;
        fArr[92] = 0.7199f;
        fArr[93] = 0.7275f;
        fArr[94] = 0.7349f;
        fArr[95] = 0.7421f;
        fArr[96] = 0.7491f;
        fArr[97] = 0.7559f;
        fArr[98] = 0.7626f;
        fArr[99] = 0.7692f;
        fArr[100] = 0.7756f;
        fArr[101] = 0.7818f;
        fArr[102] = 0.7879f;
        fArr[103] = 0.7938f;
        fArr[104] = 0.7996f;
        fArr[105] = 0.8053f;
        fArr[106] = 0.8108f;
        fArr[107] = 0.8162f;
        fArr[108] = 0.8215f;
        fArr[109] = 0.8266f;
        fArr[110] = 0.8317f;
        fArr[111] = 0.8366f;
        fArr[112] = 0.8414f;
        fArr[113] = 0.8461f;
        fArr[114] = 0.8507f;
        fArr[115] = 0.8551f;
        fArr[116] = 0.8595f;
        fArr[117] = 0.8638f;
        fArr[118] = 0.8679f;
        fArr[119] = 0.872f;
        fArr[120] = 0.876f;
        fArr[121] = 0.8798f;
        fArr[122] = 0.8836f;
        fArr[123] = 0.8873f;
        fArr[124] = 0.8909f;
        fArr[125] = 0.8945f;
        fArr[126] = 0.8979f;
        fArr[127] = 0.9013f;
        fArr[128] = 0.9046f;
        fArr[129] = 0.9078f;
        fArr[130] = 0.9109f;
        fArr[131] = 0.9139f;
        fArr[132] = 0.9169f;
        fArr[133] = 0.9198f;
        fArr[134] = 0.9227f;
        fArr[135] = 0.9254f;
        fArr[136] = 0.9281f;
        fArr[137] = 0.9307f;
        fArr[138] = 0.9333f;
        fArr[139] = 0.9358f;
        fArr[140] = 0.9382f;
        fArr[141] = 0.9406f;
        fArr[142] = 0.9429f;
        fArr[143] = 0.9452f;
        fArr[144] = 0.9474f;
        fArr[145] = 0.9495f;
        fArr[146] = 0.9516f;
        fArr[147] = 0.9536f;
        fArr[148] = 0.9556f;
        fArr[149] = 0.9575f;
        fArr[150] = 0.9594f;
        fArr[151] = 0.9612f;
        fArr[152] = 0.9629f;
        fArr[153] = 0.9646f;
        fArr[154] = 0.9663f;
        fArr[155] = 0.9679f;
        fArr[156] = 0.9695f;
        fArr[157] = 0.971f;
        fArr[158] = 0.9725f;
        fArr[159] = 0.9739f;
        fArr[160] = 0.9753f;
        fArr[161] = 0.9766f;
        fArr[162] = 0.9779f;
        fArr[163] = 0.9791f;
        fArr[164] = 0.9803f;
        fArr[165] = 0.9815f;
        fArr[166] = 0.9826f;
        fArr[167] = 0.9837f;
        fArr[168] = 0.9848f;
        fArr[169] = 0.9858f;
        fArr[170] = 0.9867f;
        fArr[171] = 0.9877f;
        fArr[172] = 0.9885f;
        fArr[173] = 0.9894f;
        fArr[174] = 0.9902f;
        fArr[175] = 0.991f;
        fArr[176] = 0.9917f;
        fArr[177] = 0.9924f;
        fArr[178] = 0.9931f;
        fArr[179] = 0.9937f;
        fArr[180] = 0.9944f;
        fArr[181] = 0.9949f;
        fArr[182] = 0.9955f;
        fArr[183] = 0.996f;
        fArr[184] = 0.9964f;
        fArr[185] = 0.9969f;
        fArr[186] = 0.9973f;
        fArr[187] = 0.9977f;
        fArr[188] = 0.998f;
        fArr[189] = 0.9984f;
        fArr[190] = 0.9986f;
        fArr[191] = 0.9989f;
        fArr[192] = 0.9991f;
        fArr[193] = 0.9993f;
        fArr[194] = 0.9995f;
        fArr[195] = 0.9997f;
        fArr[196] = 0.9998f;
        fArr[197] = 0.9999f;
        fArr[198] = 0.9999f;
        fArr[199] = 1.0f;
        fArr[200] = 1.0f;
        VALUES = fArr;
    }

    public FastOutSlowInInterpolator() {
        super(VALUES);
    }

    @Override // android.support.v4.view.animation.LookupTableInterpolator, android.animation.TimeInterpolator
    public /* bridge */ /* synthetic */ float getInterpolation(float f2) {
        return super.getInterpolation(f2);
    }
}
