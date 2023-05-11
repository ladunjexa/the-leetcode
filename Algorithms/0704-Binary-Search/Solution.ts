function search(nums: number[], target: number): number {
    let low: number = 0, high: number = nums.length - 1, mid: number = -1;

    while(low <= high) {
        mid = low + Math.floor((high - low) / 2);
        if(nums[mid] === target)
            return mid;
        else if(nums[mid] < target)
            low = mid + 1;
        else
            high = mid - 1;
    }

    return -1;
};