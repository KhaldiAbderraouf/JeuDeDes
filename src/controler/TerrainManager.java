package controler;

public abstract class TerrainManager {
	private Builder machine;

	public Builder getMachine() {
		return machine;
	}

	public void setMachine(Builder machine) {
		this.machine = machine;
	}
	public abstract int[] actionCase(int num);
	public abstract void createTerrain(int n);
}
