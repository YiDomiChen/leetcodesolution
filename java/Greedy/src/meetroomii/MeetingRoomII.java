package meetroomii;

import java.util.*;
import util.*;

public class MeetingRoomII {
	
	public int minMeetingRooms(Interval[] intervals) {
		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		for (int i = 0; i < starts.length; i++) {
			starts[i] = intervals[i].start;
			ends[i] = intervals[i].end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		int index = 0, rooms = 0;
		for (int i = 0; i < starts.length; i++) {
			if (starts[i] < ends[index]) {
				rooms++;
			} else {
				index++;
			}
			
		}
		
		return rooms;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
