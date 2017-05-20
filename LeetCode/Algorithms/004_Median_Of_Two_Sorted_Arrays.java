public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int currentIndex1 = 0;
        int currentIndex2 = 0;

        int currentNumber = 1;

        while(currentNumber < Math.ceil(total/2.0)) {
        	if(nums1.length > currentIndex1) {
        		if(nums2.length > currentIndex2) {
		        	if(nums1[currentIndex1] < nums2[currentIndex2]) {
		        		currentIndex1++;
		        	} else {
		        		currentIndex2++;
		        	}
        		} else {
        			currentIndex1++;
        		}
        	} else {
        		currentIndex2++;
        	}

        	currentNumber++;
        }

        double returnValue = 0;

        if(total % 2 == 0) {
        	if(nums1.length > currentIndex1) {
        		if(nums2.length > currentIndex2) {
		        	if(nums1[currentIndex1] < nums2[currentIndex2]) {
		        		returnValue += nums1[currentIndex1];
		        		currentIndex1++;
		        	} else {
		        		returnValue += nums2[currentIndex2];
		        		currentIndex2++;
		        	}
        		} else {
        			returnValue += nums1[currentIndex1];
        			currentIndex1++;
        		}
        	} else {
        		returnValue += nums2[currentIndex2];
        		currentIndex2++;
        	}

        	if(nums1.length > currentIndex1) {
        		if(nums2.length > currentIndex2) {
		        	if(nums1[currentIndex1] < nums2[currentIndex2]) {
		        		returnValue += nums1[currentIndex1];
		        		currentIndex1++;
		        	} else {
		        		returnValue += nums2[currentIndex2];
		        		currentIndex2++;
		        	}
        		} else {
        			returnValue += nums1[currentIndex1];
        			currentIndex1++;
        		}
        	} else {
        		returnValue += nums2[currentIndex2];
        		currentIndex2++;
        	}

        	returnValue /= 2;
        } else {
        	if(nums1.length > currentIndex1) {
        		if(nums2.length > currentIndex2) {
		        	if(nums1[currentIndex1] < nums2[currentIndex2]) {
		        		returnValue = nums1[currentIndex1];
		        	} else {
		        		returnValue = nums2[currentIndex2];
		        	}
        		} else {
        			returnValue = nums1[currentIndex1];
        		}
        	} else {
        		returnValue = nums2[currentIndex2];
        	}
        }

        return returnValue;
    }
}