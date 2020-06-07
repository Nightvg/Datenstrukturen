package PVL5_Tobias;

/*
 * Beteiligte Personen:
 * 
 * Klenke, Susann
 * Geier, Annina Tara Tanita Petra
 * Allrich, Tobias
 * Porrmann, Tim
 * Lange, David
 */

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
	
	private PVL5_Group29()
	{
		data = new ArrayList<Integer>();
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
		if(toInsert == null || !(toInsert instanceof PVL5_Group29)) return null;
		Iterator<Set> iter = toInsert.iterator();
		while(iter.hasNext())
		{
			PVL5_Group29 tmp = (PVL5_Group29) iter.next();
			if(!data.contains(tmp.data.get(0))) data.add(tmp.data.get(0));
		}
		return this;
	}

	@Override
	public Set cut(Set toCutWith) {
		if(toCutWith == null || !(toCutWith instanceof PVL5_Group29)) return null;
		Iterator<Set> iter = toCutWith.iterator();
		PVL5_Group29 p = new PVL5_Group29();
		while(iter.hasNext())
		{
			PVL5_Group29 tmp = (PVL5_Group29) iter.next();
			if(data.contains(tmp.data.get(0))) p.data.add(tmp.data.get(0));
		}
		data = p.data;
		return this;
	}

	@Override
	public Set relativeComplementWith(Set sampleSet) {
		if(sampleSet == null || !(sampleSet instanceof PVL5_Group29)) return null;
		Iterator<Set> iter = sampleSet.iterator();
		while(iter.hasNext())
		{
			PVL5_Group29 tmp = (PVL5_Group29) iter.next();
			if(data.contains(tmp.data.get(0))) data.remove(tmp.data.get(0));
		}
		return this;
	}

	@Override
	public boolean isSubsetOf(Set sampleSet) {
		if(sampleSet == null || !(sampleSet instanceof PVL5_Group29)) return false;
		Iterator<Set> iter = this.iterator();
		while(iter.hasNext())
		{
			PVL5_Group29 tmp = (PVL5_Group29) iter.next();
			if(((PVL5_Group29)sampleSet).data.contains(tmp.data.get(0))) continue;
			else return false;
		}
		return true;
	}

	@Override
	public boolean equals(Set sampleSet) {
		return this.isSubsetOf(sampleSet) && sampleSet.isSubsetOf(this);
	}

	@Override
	public List<Integer> asIntList() {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < data.size(); result.add(data.get(i++)));
		return result;
	}
	
	public void print() {
		System.out.print('{');
		for(int i = 0; i < data.size() - 1; System.out.print(String.valueOf(data.get(i++)) + ", "));
		if(data.size() != 0) System.out.print(String.valueOf(data.get(data.size() - 1)));
		System.out.print("}\n");
	}

}
