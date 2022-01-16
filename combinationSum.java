// Time Complexity : O( target * candidatelength) 
// Space Complexity : O(n) : List

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result = new ArrayList();
        
        helper(candidates, target, 0, new ArrayList<>());
        return result; 
    }
    
    private void helper (int[] candidates, int target, int index, List<Integer> currList){
        
        // Index overflow
        if (index == candidates.length){
            return;
        }
        
        // Target < 0 - path not possible 
        if (target < 0){
            return;
        }
        
        // required case
        if (target == 0){
            // for every case, a new list must be needed
            result.add(new ArrayList<>(currList));
            return;
        }
        
        // not taken
        helper(candidates, target, index + 1 , currList);
        
        // taken case
        currList.add(candidates[index]);
        
        helper(candidates, target - candidates[index] , index, currList );
        
        // backtracking  : undo the action done (remove the element added to the currList)
        currList.remove(currList.size() - 1 );
        
    }
}