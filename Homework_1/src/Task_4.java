public class Task_4 {
    public static void main(String[] args) {
        String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
        int[]  times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };

        String[] sportsmens = sortSportsmens(names, times);
        for (int i=0; i<sportsmens.length; i++){
            System.out.println(sportsmens[i]);
        }

        String bestSportsmen = sportsmenPosition(1, sportsmens);
        String secondSportsmen = sportsmenPosition(2, sportsmens);

        System.out.println("Лучший спортсмен " + bestSportsmen);
        System.out.println("Второе место у спортсмена " + secondSportsmen);
    }

    public static String sportsmenPosition (int place, String [] sportsmens){
        String [] sportsmen = sportsmens.clone();
        return sportsmen[place];
    }

    public static String [] sortSportsmens (String[] names, int[] times){
        int arrLength= times.length;
        String [] sortedSportmens = new String[arrLength];

        for(int j = 1; j < times.length ; j++){
            for(int i = times.length - 1; i >=j; i--){
                if (times[i-1] > times[i]){
                    int tempTime = times[i - 1];
                    times[i - 1] = times[i];
                    times[i] = tempTime;
                    String tempName = names[i-1];
                    names[i-1]=names[i];
                    names[i]=tempName;
                }
            }
        }

        for (int i=0; i < times.length; i++){
            sortedSportmens[i] = Integer.toString(times[i]) + ',' + names[i];
        }
        return sortedSportmens;
    }
}