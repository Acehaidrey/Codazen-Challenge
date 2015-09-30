package codazen;

import java.util.Arrays;
import java.lang.*;

public class Main {

	/** Mergesort algorithm. Runtime: O(nlogn) where n = array length. */
	public static void mergeSort(String[] students) {
		mergeSort(students, 0, students.length);
	}

	/** Helper function to mergesort. */
	public static void mergeSort(String[] arr, int low, int high) {
		int diff = high - low;
		if (diff < 2) return;
		int mid = low + (diff/2);

		mergeSort(arr, low, mid);
		mergeSort(arr, mid, high);

		String[] temp = new String[diff];
		int i = low, j = mid;
		for (int k = 0; k < diff; k++) {
			if (i == mid) {
				temp[k] = arr[j++];
			}
			else if (j == high) {
				temp[k] = arr[i++];
			}
			else if ((arr[j]).compareTo(arr[i]) < 0) {
				temp[k] = arr[j++];
			}
			else {
				temp[k] = arr[i++];
			}
		}

		for (int k = 0; k < diff; k++) {
			arr[low + k] = temp[k];
		}
	}

	/** Find number of students in both courses. Runtime: O(m + n) if arrays are sorted. */
	public static int numMatches(String[] course1, String[] course2) {

		//protect against null array object
		if (course1 == null || course2 == null) {
			return 0;
		}

		int count = 0, pos1 = 0, pos2 = 0;
		int len1 = course1.length, len2 = course2.length;

		while(pos1 < len1 && pos2 < len2) {
			// protect against null conditions inside initiated array
			if (course1[pos1] == null || course2[pos2] == null) {
				if (course1[pos1] == null) pos1++;
				else pos2++;
				continue;
			} 
 
			if (course1[pos1].compareTo(course2[pos2]) == 0) {
				count++; pos1++; pos2++;
			} else if (course1[pos1].compareTo(course2[pos2]) > 0) {
				pos2++;
			} else {
				pos1++;
			}	
		}

		return count;
	}

	/** Main testing for this group. */
	public static void main(String[] args) {
		Student s1 = new Student("Dom", "Lim", 22);
		Student s2 = new Student("Ronak", "Vora", 21);
		Student s3 = new Student("Ace", "Haidrey", 21);
		Student s4 = new Student("Vash", "Madhavan", 20);
		Student s5 = new Student("Pat", "Murray", 21);
		Student s6 = new Student("Ace", "Ferreyra", 19);
		Student s7 = new Student("Sean", "Louglin", 23);
		Student s8 = new Student("Nader", "Azari", 5);

		String[] class1 = new String[4];
		String[] class2 = new String[6];
		String[] class3 = new String[1];

		class3[0] = s4.studentString();

		class1[0] = s1.studentString();
		class1[1] = s2.studentString();
		class1[2] = s3.studentString();
		class1[3] = s8.studentString();

		class2[0] = s2.studentString();
		class2[1] = s3.studentString();
		class2[2] = s4.studentString();
		class2[3] = s5.studentString();
		class2[4] = s6.studentString();
		class2[5] = s8.studentString();

		mergeSort(class1);
		mergeSort(class2);

		int expected_matches = 3;
		int actual_matches = numMatches(class1, class2); 

		System.out.println("Our expected number of matches is " + expected_matches + " and our actual number of matches is " + actual_matches + " !");

	}
}