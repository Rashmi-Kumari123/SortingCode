public class EggDropping {
    public int calculateRecursive(int eggs, int floors){
        if(eggs == 1){
            return floors;
        }
        if(floors == 0){
            return 0;
        }
        int min = 1000;
        for(int i=1; i <= floors; i++){
            int val = 1 + Math.max(calculateRecursive(eggs-1, i-1),calculateRecursive(eggs, floors-i));
            if(val < min){
                min = val;
            }
        }
        return min;
    }
    public static void main(String args[]){
        EggDropping ed = new EggDropping();
        int r = ed.calculateRecursive(2,6);
        System.out.println(r);
    }
}

    