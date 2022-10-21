public class Question3 {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        StringBuilder temp= new StringBuilder();
        String[] digit = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return backtracking(res, digits.toCharArray(), temp, digit);
    }
    public List<String> backtracking(List<String> res, char[] num, StringBuilder temp, String[] digit){
        if (temp.length() == num.length){
            res.add(temp.toString());
        }
        else {
            int i = temp.length();
            // get telephone number
            int d = num[i] - '0';
            // get letter from number
            char[] letterArray = digit[d].toCharArray();
            for (char c : letterArray) {
                temp.append(c);
                backtracking(res, num, temp, digit);
                temp.deleteCharAt(temp.length()-1);
            }
        }
        return res;
    }
}
