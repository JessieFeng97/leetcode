/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        Queue<Interval> heap = new PriorityQueue<Interval>(
            (n1, n2) -> n1.start - n2.start);
        Iterator i = schedule.iterator();
        while (i.hasNext()) {
            List l = (List)i.next();
            Iterator iter = l.iterator();
            while (iter.hasNext()) {
                heap.add((Interval)iter.next());
            }
        }
        
        ArrayList<Interval> result = new ArrayList<Interval>();
        int last = Integer.MIN_VALUE;
        while (!heap.isEmpty()) {
            Interval cu = heap.poll();
            if (cu.start > last && last > Integer.MIN_VALUE){
                result.add(new Interval(last, cu.start));
            }
            if (cu.end > last) last = cu.end;
        }
        return result;
    }
}
