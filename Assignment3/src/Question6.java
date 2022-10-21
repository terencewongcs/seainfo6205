public class Question6 {
    public static List<List<Integer>> getSubset(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> list = new LinkedList<>();
        list.add(new LinkedList<Integer>());
        list.add(new LinkedList<Integer>());
        list.get(0).add(S[0]);

        for (int j = 1; j < S.length; j++) {
            int length = list.size();
            for (int i = 0; i < length; i++) {
                LinkedList<Integer> l = (LinkedList) ((LinkedList) list.get(i)).clone();
                l.add(S[j]);
                list.add(l);

            }
        }

        return list;
    }
}
