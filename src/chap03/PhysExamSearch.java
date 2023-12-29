import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysExamSearch {
    static class PhysData{
        private String name;
        private int height;
        private double vision;

        public PhysData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        @Override
        public String toString() {
            return "PhysData{" +
                    "name='" + name + '\'' +
                    ", height=" + height +
                    ", vision=" + vision +
                    '}';
        }

        public static final Comparator<PhysData> HEIGHT_ORDER = new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhysData> {
            @Override
            public int compare(PhysData o1, PhysData o2) { //compare에 사용됟 프로퍼티를 찾는다.
                return (o1.vision > o2.vision) ? -1 :
                        (o1.vision < o2.vision) ? 1 : 0;
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            PhysData[] datas = {
                    new PhysData("박준서", 175, 2.0),
                    new PhysData("유서범", 171, 1.5),
                    new PhysData("장경오", 174, 1.2),
                    new PhysData("황지안", 169, 0.8),
                    new PhysData("김찬우", 173, 0.7),
                    new PhysData("이수연", 168, 0.4),
                    new PhysData("강민하", 162, 0.3),
            };

            System.out.print("시력이 몇인 사람을 찾고있나요?");
            double keyVision = sc.nextDouble();
            //3번째인수: 배열을 실제로 이렇게 정렬해주는 것이 아니라
            //단지 현재의 배열이 이렇게 정렬돼있다고 binarySearch에알려주는 것
            int idx = Arrays.binarySearch(
                    datas,
                    new PhysData("", 0, keyVision),
                    PhysData.HEIGHT_ORDER);

            if(idx < 0)
                System.out.println("해당 값의 요소가 없습니다.");
            else
                System.out.println("찾은 데이터: " + datas[idx]);
        }
    }
}
