class Test1 {
    public static void main (String[] args) {
        int[] test = new int[]{4, 1, 5, 6, 2, 0};
        int leastValue; 
        for(int i = 0; i < test.length; i++) {
            leastValue = test[i];
            for(int j = 0; j < test.length; j++) {
                if(leastValue > test[j]) {
                    leastValue = test[j];
                    test[j] = test[i];
                    test[i] = test[leastValue];
                }
            }
        }
        for(int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }
}