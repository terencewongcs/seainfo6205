public class Question2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int num : nums){
            if (result.isEmpty()) result.add(List.of(num));
            else {
                List<List<Integer>> currResult = new ArrayList<>();
                for (List<Integer> list : result){
                    for(int i=0; i <= list.size(); i++){
                        List<Integer> newList = new ArrayList<>(list);
                        newList.add(i, num);
                        currResult.add(newList);
                    }
                }
                result = currResult;
            }
        }
        return result;
    }
}
