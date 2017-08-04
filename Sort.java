package practice;

import java.util.Arrays;

class Sort {
	
	private int[] array;
	
	private void swap(int n1, int n2){
		int temp = array[n1];
		array[n1] = array[n2];
		array[n2] = temp;
	}
	
	private int[] quickSort(int[] arr) {
		this.array = arr;
		return quickSort(0,array.length-1);
	}
	
	private int[] quickSort(int lo,int hi){
		int p = quickPartition(lo,hi);
		if (lo<p-1) quickSort(lo, p-1);
		if (p<hi) quickSort(p,hi);
		return array;
	}
	
	private int quickPartition(int left,int right) {
		int i = left;
		int j = right;
		int pivot = array[(left+right)/2];
		while (i<=j){
			while (array[i]<pivot) i++;
			while (array[j]>pivot) j--;
			if (i<=j) {
				swap(i,j);
				i++;
				j--;
			}
		}
		return i;
	}
	
	void mergeSort(int[] arr) {
		this.array = arr;
		mergeSort(0,arr.length-1);
	}
	
	private void mergeSort(int lo, int hi) {
		if (lo<hi){
			int mid = (lo+hi)/2;
			mergeSort(lo, mid);
			mergeSort(mid+1,hi);
			merge(lo,mid,hi);
		}
	}
	
	private void merge(int lo, int mid, int hi) {
		int[] left = Arrays.copyOfRange(array, lo, mid+1);
		int[] right = Arrays.copyOfRange(array, mid+1, hi+1);
		int i = 0;
		int j = 0;
		int k = lo;
		while (i< left.length && j<right.length){
			if (left[i]< right[j]) array[k++] = left[i++];
			else array[k++] = right[j++]; 
		}
		while (i<left.length) array[k++] = left[i++];
		while (j<right.length) array[k++] = right[j++];
	}

}
