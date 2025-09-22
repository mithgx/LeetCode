class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;

        double [][] car = new double[n][2];

        for(int i =0;i<n;i++){
            car[i][0]=position[i];
            car[i][1]=(double)(target-position[i] ) / speed[i];
        }

        Arrays.sort(car,(a,b)->Double.compare(b[0],a[0]));

        int fleets=0;
        double lasttime=0;

        for(int i =0;i<n;i++){
            double currtime = car[i][1];
            if(currtime>lasttime){
                fleets++;
                lasttime = currtime;
            }

        }
        return fleets;
        
    }
}