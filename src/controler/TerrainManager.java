package controler;

public abstract class TerrainManager {
	private Builder machine;

	public Builder getMachine() {
		return machine;
	}

	public void setMachine(Builder machine) {
		this.machine = machine;
	}
	public abstract int[] actionCase(int num)throws IndexOutOfBoundsException;
	public abstract void createTerrain(int n);
	public abstract String getColor(int num);
	
}
