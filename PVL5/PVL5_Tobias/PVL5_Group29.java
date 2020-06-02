package PVL5_Tobias;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PVL5_Group29 implements Set{
	
	private ArrayList<Integer> data;
	
	public PVL5_Group29(int element)
	{
		data = new ArrayList<Integer>();
		data.add(element);
	}
	
	public PVL5_Group29()
	{
		data = new ArrayList<Integer>();
	}
	
	public PVL5_Group29(Set p)
	{
		data = new ArrayList<Integer>();
		Iterator<Set> iter = p.iterator();
		while(iter.hasNext())
		{
			PVL5_Group29 tmp = (PVL5_Group29) iter.next();
			data.add(tmp.get());
		}
	}
	
	@Override
	public Iterator<Set> iterator() {
		Iterator<Set> iter = new Iterator<Set>()
		{
			private int currInd = 0;
			@Override
			public boolean hasNext() {
				return currInd < data.size();
			}

			@Override
			public Set next() {
				Set n = hasNext() ? new PVL5_Group29(data.get(currInd++)) : null;
				return n;
			}
	
		};
		return iter;
	}

	@Override
	public Set union(Set toInsert) {
		if(toInsert == null) return null;
		Iterator<Set> iter = toInsert.iterator();
		while(iter.hasNext())
		{
			PVL5_Group29 tmp = (PVL5_Group29) iter.next();
			if(!data.contains(tmp.get())) data.add(tmp.get());
		}
		return this;
	}

	@Override
	public Set cut(Set toCutWith) {
		if(toCutWith == null) return null;
		Iterator<Set> iter = toCutWith.iterator();
		PVL5_Group29 p = new PVL5_Group29();
		while(iter.hasNext())
		{
			PVL5_Group29 tmp = (PVL5_Group29) iter.next();
			if(data.contains(tmp.get())) p.add(tmp.get());
		}
		data = (ArrayList<Integer>) p.asIntList();
		return this;
	}

	@Override
	public Set relativeComplementWith(Set sampleSet) {
		if(sampleSet == null) return null;
		Iterator<Set> iter = sampleSet.iterator();
		while(iter.hasNext())
		{
			PVL5_Group29 tmp = (PVL5_Group29) iter.next();
			if(data.contains(tmp.get())) data.remove(tmp.get());
		}
		return this;
	}

	@Override
	public boolean isSubsetOf(Set sampleSet) {
		if(sampleSet == null) return false;
		Iterator<Set> iter = this.iterator();
		while(iter.hasNext())
		{
			PVL5_Group29 tmp = (PVL5_Group29) iter.next();
			if(((PVL5_Group29)sampleSet).contains(tmp.get())) continue;
			else return false;
		}
		return true;
	}

	@Override
	public boolean equals(Set sampleSet) {
		PVL5_Group29 tmp = new PVL5_Group29(sampleSet);
		return this.isSubsetOf(sampleSet) && tmp.isSubsetOf(this);
	}

	@Override
	public List<Integer> asIntList() {
		return data;
	}
	
	private Integer get() {
		return data.size() > 0 ? data.get(0) : null;
	}
	
	private Integer get(int index) {
		if(index >= data.size()) return null;
		return data.get(index);
	}
	
	public void print() {
		System.out.print('{');
		for(int i = 0; i < data.size() - 1; System.out.print(String.valueOf(data.get(i++)) + ", "));
		System.out.print(String.valueOf(data.get(data.size() - 1)) + "}\n");
	}
	
	private Boolean contains(Integer i) {
		if(i == null) return null;
		return data.contains(i);
	}

	private void add(Integer integer) {
		if(integer == null) return;
		data.add(integer);
	}
}
