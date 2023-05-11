public int[] twoSum(int[] numbers, int target) {

    // Initialize the low pointer to the beginning of the array and the high pointer to the end of the array.
    int low = 0, high = numbers.length - 1;

    // Initialize the sum to -1, this will be used to store the sum of the numbers at low and high pointers.
    int sum = -1;

    // Use the two-pointer technique to search for the required numbers.
    while(low <= high) {

        // Calculate the sum of the numbers at the low and high indices.
        sum = numbers[low] + numbers[high];

        // If the sum is less than the target value, move the low pointer to the next index.
        if(sum < target)
            low++;

        // If the sum is greater than the target value, move the high pointer to the previous index.
        else if(sum > target)
            high--;

        // If the sum is equal to the target value, we have found the required numbers.
        else
            break;
    }

    // Return an array of indices of the two numbers whose sum equals the target value.
    return new int[]{ low + 1, high + 1 };
}
