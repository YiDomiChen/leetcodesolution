class Solution:
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        if not nums or len(nums) == 0:
            return [-1,-1]
        
        start, end = 0, len(nums) - 1
        while start + 1 < end:
            mid = start + (end - start) / 2
            if (nums[mid] >= target):
                end = mid
            else:
                start = mid
        left = -1
        if nums[start] == target:
            left = start
        elif nums[end] == target:
            left = end
        else:
            return [-1,-1]
        
        start, end = 0, len(nums) - 1
        while start + 1 < end:
            mid = start + (end - start) / 2
            if (nums[mid] <= target):
                start = mid
            else:
                end = mid
        right = -1
        if nums[end] == target:
            right = end
        elif nums[start] == target:
            right = start
        
        return [left, right]