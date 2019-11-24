import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

public class SparseBoundedGrid2<E> extends AbstractGrid<E> {
	private Map<Location, E> occupantMap;
	private int numRows;
	private int numCols;

	public SparseBoundedGrid2(int rows, int cols)
	{
		occupantMap = new HashMap<Location, E>();
		numRows = rows;
		numCols = cols;
	} 
	
	@Override
	public int getNumRows() {
		// TODO Auto-generated method stub
		return numRows;
	}

	@Override
	public int getNumCols() {
		// TODO Auto-generated method stub
		return numCols;
	}

	@Override
	public boolean isValid(Location loc) {
		// TODO Auto-generated method stub
		return (0 <= loc.getRow() && loc.getRow() < getNumRows())&& (0 <= loc.getCol() && loc.getCol() < getNumCols()); 
	}

	@Override
	public E put(Location loc, E obj) {
		// TODO Auto-generated method stub
		if (loc == null)
			throw new NullPointerException("loc == null");
		if (obj == null)
			throw new NullPointerException("obj == null");
		return occupantMap.put(loc, obj); 
	}

	@Override
	public E remove(Location loc) {
		// TODO Auto-generated method stub
		if (loc == null)
			throw new NullPointerException("loc == null");
		return occupantMap.remove(loc);
	}

	@Override
	public E get(Location loc) {
		// TODO Auto-generated method stub
		if (loc == null)
			throw new NullPointerException("loc == null");
		return occupantMap.get(loc); 
	}

	@Override
	public ArrayList<Location> getOccupiedLocations() {
		// TODO Auto-generated method stub
		ArrayList<Location> a = new ArrayList<Location>();
			for (Location loc : occupantMap.keySet())
				a.add(loc);
		return a;
	}

}
