import java.util.*;

/**
 * Created by arsenykogan on 08/05/14.
 */
public class Rand {
    public static void main(String[] args) {
        final Integer[] places = new Integer[] {424, 425, 426, 430, 431, 435, 436, 437, 438, 439, 444, 445, 446, 450, 451, 460, 461, 462, 463, 464, 470, 471, 477, 478, 483, 484, 494, 495, 496, 499, 500, 501, 504, 505, 506, 507, 508, 509, 510, 511, 514, 515, 516, 520, 521, 522, 529, 530, 531, 532, 533, 534, 535, 539, 540, 541, 542, 546, 547, 548, 549, 552, 553, 554, 565, 566, 567, 569, 570, 571, 573, 574, 575, 576, 577, 578, 579, 580, 581, 584, 585, 586, 590, 591, 592, 598, 599, 600, 601, 602, 603, 604, 605, 609, 610, 611, 612, 616, 617, 618, 619, 620, 622, 623, 624, 635, 636, 637, 638, 639, 640, 643, 644, 645, 650, 651, 652, 654, 655, 656, 660, 661, 662, 668, 669, 670, 679, 680, 681, 682, 683, 686, 687, 688, 689, 690, 692, 693, 694, 706, 707, 708, 709, 710, 713, 714, 720, 721, 722, 724, 725, 726, 730, 731, 732, 737, 738, 739, 748, 749, 750, 751, 752, 753, 756, 757, 758, 759, 760, 761, 762, 763, 764, 777, 778, 779, 782, 783, 784, 790, 791, 792, 794, 795, 796, 800, 801, 802, 807, 808, 809, 818, 819, 820, 821, 822, 823, 826, 827, 828, 829, 830, 831, 832, 833, 834, 847, 848, 849, 853, 854, 855, 860, 861, 862, 864, 865, 866, 870, 871, 872, 878, 879, 880, 888, 889, 890, 891, 892, 893, 894, 896, 897, 898, 900, 901, 902, 903, 904, 917, 918, 919, 923, 924, 925, 926, 929, 930, 931, 934, 935, 936, 937, 939, 940, 941, 948, 949, 950, 951, 953, 954, 955, 957, 958, 959, 960, 961, 962, 963, 964, 966, 967, 968, 971, 972, 973, 974, 987, 988, 989, 994, 995, 996, 997, 998, 999, 1000, 1001, 1005, 1006, 1007, 1008, 1009, 1010, 1011, 1019, 1020, 1021, 1022, 1023, 1024, 1025, 1026, 1027, 1028, 1029, 1032, 1033, 1034, 1036, 1037, 1038, 1041, 1042, 1043, 1044, 1057, 1058, 1059, 1065, 1066, 1067, 1068, 1069, 1070, 1076, 1077, 1078, 1079, 1080, 1090, 1091, 1092, 1093, 1094, 1095, 1097, 1098, 1103, 1104, 1107, 1108, 1112, 1113, 1114, 1137, 1148, 1162};
        final String[] types = new String[] {"маленькую", "маленькую", "маленькую", "маленькую", "маленькую", "маленькую", "маленькую", "среднюю", "маленькую", "маленькую", "маленькую", "маленькую", "маленькую", "маленькую", "маленькую", "маленькую", "маленькую", "среднюю", "маленькую", "маленькую", "маленькую", "маленькую", "маленькую", "маленькую", "маленькую", "маленькую", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "среднюю", "среднюю", "среднюю", "среднюю", "среднюю", "маленькую", "маленькую", "среднюю", "маленькую", "маленькую", "среднюю", "маленькую", "маленькую", "среднюю", "среднюю", "среднюю", "среднюю", "среднюю", "маленькую", "маленькую", "среднюю", "большую", "маленькую", "маленькую", "среднюю", "большую", "маленькую", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "маленькую", "среднюю", "среднюю", "маленькую", "маленькую", "среднюю", "среднюю", "маленькую", "маленькую", "маленькую", "среднюю", "среднюю", "среднюю", "маленькую", "среднюю", "маленькую", "среднюю", "среднюю", "маленькую", "маленькую", "среднюю", "среднюю", "маленькую", "маленькую", "маленькую", "маленькую", "маленькую", "маленькую", "большую", "большую", "среднюю", "маленькую", "среднюю", "большую", "среднюю", "маленькую", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "среднюю", "среднюю", "среднюю", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "среднюю", "маленькую", "маленькую", "среднюю", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "среднюю", "среднюю", "среднюю", "маленькую", "маленькую", "среднюю", "большую", "большую", "среднюю", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "большую", "среднюю", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "маленькую", "маленькую", "среднюю", "маленькую", "среднюю", "среднюю", "маленькую", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "маленькую", "маленькую", "среднюю", "маленькую", "маленькую", "среднюю", "среднюю", "среднюю", "среднюю", "маленькую", "маленькую", "среднюю", "среднюю", "среднюю", "большую", "маленькую", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "маленькую", "маленькую", "среднюю", "маленькую", "среднюю", "среднюю", "маленькую", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "маленькую", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "среднюю", "маленькую", "маленькую", "среднюю", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "большую", "среднюю", "среднюю", "большую", "среднюю", "маленькую", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "среднюю", "среднюю", "среднюю", "маленькую", "среднюю", "маленькую", "маленькую", "среднюю", "среднюю", "маленькую", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "среднюю", "маленькую", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "среднюю", "маленькую", "маленькую", "маленькую", "маленькую", "маленькую", "среднюю", "среднюю", "маленькую", "маленькую", "среднюю", "среднюю", "маленькую", "маленькую", "среднюю", "среднюю", "маленькую", "большую", "большую", "среднюю", "маленькую", "среднюю", "маленькую", "маленькую", "среднюю", "среднюю", "среднюю", "среднюю", "среднюю", "среднюю", "маленькую", "среднюю", "среднюю", "среднюю", "среднюю", "среднюю", "среднюю", "маленькую", "среднюю", "среднюю", "среднюю", "среднюю", "среднюю", "среднюю", "среднюю", "маленькую", "маленькую", "среднюю", "маленькую", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "среднюю", "маленькую", "среднюю", "большую", "среднюю", "маленькую", "маленькую", "маленькую", "маленькую", "среднюю", "среднюю", "среднюю", "маленькую", "маленькую", "маленькую", "среднюю", "среднюю", "среднюю", "маленькую", "маленькую", "среднюю", "среднюю", "среднюю", "маленькую", "маленькую", "маленькую", "маленькую", "маленькую", "маленькую", "маленькую", "маленькую", "маленькую", "среднюю", "маленькую", "маленькую", "маленькую", "маленькую"};
        final Random random = new Random(10);

        final List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < places.length; i++) {
            pairs.add(new Pair(places[i], types[i]));
        }
        Collections.shuffle(pairs, random);
        for (Pair pair : pairs) {
            System.out.print(pair.place + ", ");
        }
        System.out.println();
        for (Pair pair : pairs) {
            System.out.print(pair.type + ", ");
        }
    }

    public static class Pair {
        public final Integer place;
        public final String type;

        public Pair(final Integer place, final String type) {
            this.place = place;
            this.type = type;
        }
    }
}
