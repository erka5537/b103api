package post_requests;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ProjeDeneme3 {

    public static void main(String[] args) {
        //Biri hariç m'den n'ye kadar tüm tek sayıları içeren m'den n'ye kadar bir pozitif tam sayılar dizimiz olduğunu varsayalım.
        //Listede eksik olan tek sayıyı bulan bir fonksiyon yazınız.
        //Örnek:
        //Giriş: [1, 3, 5, 7, 9, 13, 15, 17]
        //Çıkış: 11
        //Giriş: [9, 7, 3]
        //Çıkış: 5
        //Kısıtlamalar:
        //1 < giriş listesinin uzunluğu (sayılar) < 100 Her zaman tek bir eksik sayı vardır.
        //Dizi azalan veya artan şekilde sıralanır.

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
                //System.out.println(i);
            }
        }

//        int[] odd = {9,3,7,5,13};
//        Arrays.sort(odd);
//        int wanted;
//        for(int i=1; i<odd.length; i++){
//            wanted = odd[i-1] + 2;
//            if(odd[i] != wanted){
//                System.out.println(wanted);
//                break;
//            }
//        }

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
