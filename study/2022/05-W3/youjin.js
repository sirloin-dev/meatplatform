const removeDuplicates = (nums) => {
    let prev= nums[0];
    for(let i = 1; i < nums.length; i++){
        if(nums[i] == prev){
            prev = nums[i];
            nums.splice(i, 1);
            i -= 1;
        } else{
            prev = nums[i];
            continue;
        }
    }
};
