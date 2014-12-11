package gr.iti.mklab.framework.common.domain;

public class RankedObject<K> implements Comparable<RankedObject<K>> {

	public K object;
	public Double score;
	
	public RankedObject(K obj, Double score) {
		this.object = obj;
		this.score = score;
	}

	@Override
	public int compareTo(RankedObject<K> other) {
		if(this.score > other.score) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
}
