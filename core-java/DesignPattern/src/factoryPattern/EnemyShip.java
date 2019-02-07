package factoryPattern;

public abstract 	class EnemyShip {
	
	private String name;
	private double demage;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDemage() {
		return demage;
	}
	public void setDemage(double demage) {
		this.demage = demage;
	}
	
	public void show() {
		System.out.println("ship name : "+this.name+" demage done:"+this.demage);
	}
}
