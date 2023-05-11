/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let low = 0, high = nums.length - 1, mid = -1;
    while(low <= high) {
        mid = low + Math.floor((high - low) / 2);
        if(nums[mid] == target)
            return mid;
        if(nums[mid] < target)
            low = mid + 1;
        else
            high = mid - 1;
    }

    return -1;
};