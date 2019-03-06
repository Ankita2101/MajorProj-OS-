/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifo;

/**
 *
 * @author NUTU
 */
import java.util.*;
class FIFO{
	Scanner sc = new Scanner(System.in);
	int frame_size, no_of_pages, element, next_replace = 0, page_hits = 0, page_miss = 0;
	int page_frames[];
	
	void getData(){
		System.out.println("Enter size of page frame buffer");
		frame_size = sc.nextInt();
		System.out.println("Enter number of pages");
		no_of_pages = sc.nextInt();
		page_frames = new int[frame_size];
		//for-loop to initialize every array element to -1
		for(int i = 0; i < frame_size; i++)
			page_frames[i] = -1;
		//Inputting elements one by one
		for(int i = 0; i < no_of_pages; i++)
		{
			System.out.println("Enter the element");
			element = sc.nextInt();
			//to check whether element entered is present in 'page_frames[]'
			find(element);
		}
		//to display hits, miss and ratio after all data is entered
		display();
	}
	
	void find(int element){
		int i;
		//to check element present in page_frame
		for(i = 0; i < frame_size; i++)
			//enters this if loop if element is present i.e. page hit
			if(page_frames[i] == element){
				page_hits += 1;
				break;
			}
		//if element not present 'i' will be equal to 3 i.e. pass miss 
		if(i==3){
			page_miss += 1;
			/* next_replace is the index of the next element to be replaced
			post incrementing next_replace after replacing the current element	*/
			page_frames[next_replace++] = element;
			//if next_replace reaches frame_size set it to 0 again.
			if(next_replace == frame_size)
				next_replace = 0;
		}
		//displaying frame elements
		System.out.print("Frame Elements: ");
		for(i=0; i < frame_size; i++)
			System.out.print(page_frames[i] + "\t");
		System.out.println();
	}
	//displaying hits, miss and ratio
	void display(){
		float hit_ratio, miss_ratio;
		hit_ratio = (page_hits / (float)no_of_pages) * 100;
		miss_ratio = (page_miss / (float)no_of_pages) * 100;
		System.out.println("Number of Page Hits: " + page_hits);
		System.out.println("Number of Page Miss: " + page_miss);
		System.out.println("Hit Ratio: " + hit_ratio);
		System.out.println("Miss Ratio: " + miss_ratio);
	}
	public static void main(String[] args){
		FIFO ob = new FIFO();
		ob.getData();	
	}
}

    /**
     * @param args the command line arguments
     */
   

