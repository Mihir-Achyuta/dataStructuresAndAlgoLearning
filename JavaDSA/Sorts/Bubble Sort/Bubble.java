public class Bubble {
    public static void Bubble(int[] array){
        //The outer loop can have more operations than array.length-1 but wastes more time on an already sorted array
        //you just need array.length iterations in outer loop for bubble sort (keep in mind we start at 0)
        for(int i =0; i<array.length-1; i++){
            //we are checking 1 element in front so we are forced to do array.length-1 (decreasing iterations => index out of bounds error)
            //-i to reduce swaps
            for(int j=0; j<array.length-1-i; j++){
                //Does the swap
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    //Still O(n^2) time compelxity but less swaps than traditional Bubble Sort bc we check if a swap has happened
    public static void BubbleOptimized(int[] array){
        //variable turns false if swap happens
        var noSwap = true;
        for(int i =0; i<array.length-1; i++){
            for(int j=0; j<array.length-1-i; j++){
                if(array[j]>array[j+1]){
                    noSwap = false;
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            //no swap = exit out of loop
            if(noSwap){
                break;
            }
        }
    }

    public static void main(String[] args){

        //original unsorted array
        int[] array = {9687, 4066, 8350, 7571, 2705, 6773, 5826, 7100, 6306, 5926, 4852, 4539, 8089, 4662, 8875, 1280, 9885, 1260, 2279, 5527, 145, 1685, 7527, 5770, 5867, 3903, 8103, 2318, 3407, 358, 1070, 1729, 5225, 4700, 7150, 8834, 5427, 4724, 7032, 9196, 912, 1364, 5736, 8677, 5508, 6351, 1329, 8239, 207, 9111, 5222, 658, 6763, 5016, 7370, 2879, 3050, 5136, 7539, 2189, 6944, 2608, 1595, 6839, 6909, 8799, 1033, 6099, 7830, 8419, 7371, 496, 1622, 7210, 7313, 6902, 3075, 9804, 3402, 7349, 7752, 4139, 8445, 8704, 7322, 5220, 6184, 4580, 7443, 2232, 5610, 5161, 9832, 6777, 3866, 8637, 7468, 2430, 9639, 1222, 9927, 6559, 2039, 4740, 3818, 6872, 1342, 942, 5111, 8050, 516, 9323, 9551, 4321, 7340, 7162, 8602, 465, 8803, 2159, 4313, 8315, 4530, 6340, 4827, 3152, 3087, 1867, 1617, 5995, 2252, 3302, 3174, 796, 7634, 757, 7263, 9640, 1640, 384, 2345, 579, 4253, 5625, 5728, 1350, 6926, 8684, 3345, 2528, 1420, 7170, 5668, 1609, 7315, 1506, 7906, 7888, 4514, 5829, 5970, 5368, 2397, 4271, 7235, 8919, 1811, 4945, 8400, 9119, 512, 6241, 5283, 6356, 9559, 7823, 1243, 6793, 2942, 8404, 5147, 2369, 2692, 473, 8294, 7842, 2792, 7450, 8340, 9959, 4528, 9377, 3036, 6181, 5227, 5160, 443, 817, 2186, 1375, 7921, 3540, 249, 8522, 4217, 4601, 529, 205, 5624, 9043, 4229, 5131, 5892, 5562, 9138, 705, 6885, 336, 6867, 971, 9228, 2235, 5096, 2442, 6863, 7704, 8510, 2158, 5477, 914, 184, 5969, 4797, 4020, 3226, 9692, 6948, 651, 6209, 7603, 3579, 4387, 8720, 22, 4720, 4057, 3843, 3936, 5307, 4894, 9887, 6721, 7232, 2716, 6974, 8341, 1992, 4939, 7872, 7491, 9044, 8842, 6613, 2188, 2214, 3985, 4019, 8093, 5676, 2030, 5447, 4718, 6610, 2697, 2258, 2267, 6928, 1779, 7724, 8851, 5351, 97, 3357, 2606, 2332, 896, 3451, 8072, 4234, 5121, 5202, 824, 4243, 5558, 2440, 1197, 5577, 8367, 9619, 3538, 2592, 4854, 764, 8492, 5135, 7427, 9371, 8573, 8855, 869, 8487, 9732, 5476, 8139, 8953, 3952, 3476, 6347, 6786, 8636, 7579, 6213, 791, 2671, 5775, 6941, 5384, 3006, 7604, 767, 4935, 9613, 5823, 1238, 3547, 5715, 2044, 9219, 877, 9880, 3710, 4167, 9546, 4130, 8748, 2092, 6441, 5156, 9698, 6224, 41, 9696, 5545, 2061, 251, 484, 2722, 5293, 821, 4940, 9743, 6539, 3860, 680, 9629, 3416, 3001, 5374, 4108, 4204, 1773, 9857, 761, 4649, 710, 6468, 2859, 5886, 6847, 6192, 3631, 8082, 7827, 5871, 4955, 492, 777, 9459, 4626, 8249, 7874, 3796, 1763, 665, 4304, 9229, 6623, 5320, 3819, 2611, 7945, 3634, 4251, 3488, 2915, 5032, 8416, 3474, 3428, 5089, 1762, 81, 6404, 6403, 3562, 7767, 8549, 3322, 5807, 2348, 3953, 2291, 5128, 1447, 8918, 6175, 8749, 3047, 7862, 4487, 5033, 8092, 7792, 3742, 3597, 9982, 7314, 6196, 2593, 2144, 7743, 1362, 6645, 4829, 6095, 4141, 3400, 2739, 4122, 1255, 5495, 5935, 3639, 5272, 864, 5654, 9200, 3564, 6243, 2201, 6232, 7676, 3521, 4759, 7717, 5306, 4868, 4813, 6737, 599, 4707, 3247, 4349, 6544, 9076, 1368, 977, 6233, 7037, 5663, 9527, 406, 9520, 4295, 6924, 8926, 947, 8952, 3037, 9501, 23, 5180, 6218, 5450, 8156, 5921, 7884, 655, 2048, 9417, 1103, 2402, 4264, 6431, 3378, 873, 7107, 4227, 8307, 1786, 2082, 6770, 4226, 4992, 7850, 2289, 6931, 2509, 9347, 1513, 9317, 3239, 6843, 1240, 3089, 832, 3671, 3872, 4238, 5046, 6141, 4385, 1141, 4046, 6757, 7738, 508, 6497, 6136, 8302, 9683, 9558, 4895, 8177, 4742, 3068, 1889, 1758, 2555, 7178, 6134, 9359, 564, 5503, 146, 7057, 8741, 5594, 6268, 4036, 4518, 3624, 9668, 4106, 8845, 4921, 367, 4873, 8182, 5233, 8634, 8730, 878, 6508, 1829, 6025, 9446, 683, 6271, 3651, 9899, 9786, 6368, 5243, 8766, 4833, 7556, 843, 3759, 7537, 8506, 7730, 253, 3977, 2154, 2043, 5779, 907, 8795, 3484, 9553, 2908, 7936, 822, 9220, 5043, 9561, 6565, 1787, 9385, 9197, 6, 2095, 36, 2638, 7968, 1027, 3522, 1789, 3902, 9354, 1045, 4024, 7421, 3207, 2892, 8266, 2719, 4441, 8057, 6250, 6879, 8236, 197, 9355, 5971, 9232, 7919, 697, 104, 8240, 7922, 9700, 9916, 1738, 4953, 2240, 7375, 805, 4943, 3071, 719, 1118, 7373, 2414, 7834, 4951, 9990, 2790, 2350, 2706, 2264, 3064, 9825, 4410, 2441, 7302, 4256, 5691, 9615, 9482, 8343, 9491, 991, 9122, 4399, 2115, 9772, 4119, 5958, 4526, 8768, 2572, 3698, 4465, 300, 4838, 6269, 4371, 9999, 3228, 883, 2109, 4382, 5749, 4081, 9939, 5968, 5743, 7944, 7858, 3139, 4375, 6413, 1710, 7015, 5432, 9375, 4047, 3442, 404, 7073, 4527, 3435, 5148, 4864, 5852, 3590, 8758, 5813, 9915, 5985, 5704, 2273, 1292, 7779, 2484, 3155, 4272, 2807, 6621, 7063, 7466, 3763, 7714, 329, 4785, 8666, 4946, 6484, 9918, 2805, 7233, 1647, 7, 2211, 5885, 8679, 7393, 9670, 8984, 7502, 4814, 8309, 2979, 9660, 2494, 3728, 9846, 150, 6975, 5013, 2420, 8921, 3807, 8687, 8581, 8709, 122, 4443, 9374, 144, 3222, 9917, 4870, 4478, 8627, 2161, 748, 2228, 1196, 5122, 3542, 2974, 2890, 3560, 7382, 8060, 2754, 9102, 3494, 5631, 7642, 7149, 8781, 3328, 2180, 3887, 42, 2117, 8889, 1223, 7079, 9457, 9983, 4516, 319, 9034, 9936, 8864, 4541, 3199, 7707, 2734, 714, 2208, 9142, 4053, 8005, 1164, 3252, 6609, 9757, 5260, 7659, 8009, 4847, 5617, 2205, 8598, 8163, 3591, 6348, 3274, 3955, 5820, 6496, 8996, 556, 5110, 7687, 2476, 5889, 4671, 5526, 2920, 6424, 5795, 8212, 1584, 5882, 1306, 8440, 445, 5783, 5355, 164, 147, 5554, 2132, 5037, 5523, 9773, 8644, 8828, 3320, 2738, 6322, 8242, 3931, 2917, 1631, 2811, 8974, 8226, 5699, 6369, 8827, 6133, 8735, 4515, 1360, 32, 7071, 3815, 4318, 4370, 2143, 6741, 240, 1232, 4788, 7288, 8346, 1912, 1827, 1014, 1971, 4185, 3121, 9618, 1914, 8898, 886, 9238, 4632, 1029, 2881, 598, 1581, 6414, 2406, 6546, 8777, 1099, 3129, 8836, 5842, 5659, 2166, 3360, 9858, 3168, 2677, 6940, 8825, 1578, 3009, 5044, 3531, 1323, 722, 432, 2266, 707, 7893, 9523, 4016, 2914, 6453, 5819, 8690, 2537, 1322, 7557, 1966, 3361, 4919, 4339, 4984, 2162, 9860, 8521, 9266, 215, 3854, 50, 8686, 9094, 9113, 5449, 1460, 3989, 139, 6423, 6704, 3276, 3212, 4929, 6543, 5029, 235, 6343, 8134, 8958, 2118, 3131, 9693, 4094, 5568, 4499, 477, 6927, 4651, 5332, 7165, 8211, 1511, 1863, 1780, 5152, 2410, 836, 8869, 5773, 7967, 1261, 9881, 732, 5536};
        System.out.println("Original Array");
        for(int i =0; i<array.length; i++){
            System.out.print(array[i] +" ");
        }
        System.out.println();
        System.out.println();

        System.out.println("Bubble Sorted Array");
        //Bubble Sort implemented
        Bubble(array);
        for(int i =0; i<array.length; i++){
            System.out.print(array[i] +" ");
        }
        System.out.println();
        System.out.println();

        //Optimized Bubble Sort Implemented
        System.out.println("Bubble Sort Optimized Array");
        BubbleOptimized(array);
        for(int i =0; i<array.length; i++){
            System.out.print(array[i] +" ");
        }

    }
}