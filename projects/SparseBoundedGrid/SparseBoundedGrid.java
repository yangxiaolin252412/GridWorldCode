import java.util.ArrayList;

import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

public class SparseBoundedGrid<E> extends  AbstractGrid<E>{

	private SparseGridNode[] occupantArray; 
	 private int numCols;
	 private int numRows; 
	 
	 public SparseBoundedGrid(int rows, int cols)
	 {
		 if (rows <= 0)
			 throw new IllegalArgumentException("rows <= 0");
		 if (cols <= 0)
			 throw new IllegalArgumentException("cols <= 0");
		 numCols = cols;
		 numRows = rows;
		 occupantArray = new SparseGridNode[rows];
	 }

	@Override
	public int getNumRows() {
		// TODO Auto-generated method stub
		return  numRows;
	}

	@Override
	public int getNumCols() {
		// TODO Auto-generated method stub
		return  numCols;
	}

	@Override
	public boolean isValid(Location loc) {
		// TODO Auto-generated method stub
		return (0 <= loc.getRow() && loc.getRow() < getNumRows())&& (0 <= loc.getCol()&& loc.getCol() < getNumCols());
	}

	@Override
	public ArrayList<Location>  getOccupiedLocations() {
		// TODO Auto-generated method stub
		ArrayList<Location> Locations = new ArrayList<Location>();
		for (int r = 0; r < getNumRows(); r++)
		{
			SparseGridNode p = occupantArray[r]; //get the row linked list
			while(p != null) //traverse the row
			{
				Location loc1 = new Location(r, p.getCol());
				Locations.add(loc1);
				p = p.getNext();
			}
		}
		return Locations;
	}

	@Override
	public E remove(Location loc) {
		// TODO Auto-generated method stub
		if (!isValid(loc))
			throw new IllegalArgumentException("Location " + loc+ " is not valid");
		E obj = get(loc);
		if (obj == null) return null; 
		SparseGridNode p = occupantArray[loc.getRow()];
		if(p != null)
		{
			if(p.getCol() == loc.getCol()) 
				occupantArray[loc.getRow()] = p.getNext();
			else
			{
				SparseGridNode q = p.getNext();
				while(q!= null && q.getCol() != loc.getCol())
				{
					p = p.getNext();
					q = q.getNext();
				}
				if(q != null)
					p.setNext(q.getNext());
			}
		}
			 return obj;
	}

	@Override
	public E get(Location loc) {
		// TODO Auto-generated method stub
		if (!isValid(loc))
		throw new IllegalArgumentException("Location " + loc+ " is not valid");

		SparseGridNode p = occupantArray[loc.getRow()]; 
		while(p != null) 
		{
			if(loc.getCol() == p.getCol())
				return (E)p.getOccupant();
			p = p.getNext();
		}
		return null;
	}

	@Override
	public E put(Location loc, E obj) {
		// TODO Auto-generated method stub
		if (!isValid(loc))
			throw new IllegalArgumentException("Location " + loc+ " is not valid");
		if (obj == null)
			 throw new NullPointerException("obj == null");
		E oldOccupant = remove(loc);
		SparseGridNode p = occupantArray[loc.getRow()];
		occupantArray[loc.getRow()] = new SparseGridNode(obj,
		loc.getCol(), p);
		return oldOccupant; 
	}

	
	
}
