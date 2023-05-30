package post_requests;

import java.util.Arrays;

public class ProjeDeneme4 {

    public static void main(String[] args) {
        //Yalnızca 'A' ve 'B' karakterlerinden oluşan bir dizge str verildiğinde, geçiş sayıları arasındaki mutlak farkı bulun.
        //
        //Örnek:
        //
        //Girdi: "AAABAB"
        //Çıkış: 2
        //
        //Girdi: "AAAAAAAAAB"
        //Çıkış: 7
        //
        //Girdi: "BB"
        //Çıkış: 2
        //
        //Kısıtlama: 'str' içindeki tüm karakterler ya 'A' ya da 'B'dir.

//        List<Integer> tnums = new ArrayList<>();
//        for(int i=1; i<101; i=i+2){
//            tnums.add(i);
//        }
        //List<Integer> inputNums = new ArrayList<>(Arrays.asList(9,7,3));
        //        Collections.sort(inputNums);
        //        for(int i=inputNums.get(0); i<=inputNums.get(inputNums.size()-1); i=i+2){
        //            if(!inputNums.contains(i)){
        //                System.out.println(i);
        //            }
        //        }

        int[] inputNums = {1, 3, 5, 7, 9, 13, 15, 17};
        Arrays.sort(inputNums);

        for(int i=inputNums[0]; i<=inputNums[inputNums.length-1]; i=i+2){
            int finalI = i;
            if(Arrays.stream(inputNums).noneMatch(t->t== finalI)){
                System.out.println(i);
            }
        }

        System.out.println(findMissingOdd(inputNums));
    }

    public static int findMissingOdd(int[] nums) {
        int result = 0;
        Arrays.sort(nums);

        for(int i=nums[0]; i<=nums[nums.length-1]; i=i+2){
            int finalI = i;
            if(Arrays.stream(nums).noneMatch(t->t== finalI)){
                result = i;
            }
        }
        return result;
    }
}
