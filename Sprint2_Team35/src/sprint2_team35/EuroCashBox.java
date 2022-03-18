package sprint2_team35;

import java.text.DecimalFormat;

public class EuroCashBox extends CashBox implements ICashBox {
	
	private static final DecimalFormat df = new DecimalFormat("0.00");	
	
	public EuroCashBox() {
		super();
	}
	
	@Override
	public int getTotal10s() {
		// TODO Auto-generated method stub
		return super.getTotal10s();
	}
	@Override
	public int getTotal20s() {
		// TODO Auto-generated method stub
		return super.getTotal20s();
	}
	@Override
	public int getTotal50s() {
		// TODO Auto-generated method stub
		return super.getTotal50s();
	}
	@Override
	public int getTotal1s() {
		// TODO Auto-generated method stub
		return super.getTotal1s();
	}
	@Override
	public int getTotal2s() {
		// TODO Auto-generated method stub
		return super.getTotal2s();
	}
	@Override
	public double getCashBoxAmount() {
		// TODO Auto-generated method stub
		return super.getCashBoxAmount();
	}
	@Override
	public void setTotal10s(int total10s) {
		// TODO Auto-generated method stub
		super.setTotal10s(total10s);
	}
	@Override
	public void setTotal20s(int total20s) {
		// TODO Auto-generated method stub
		super.setTotal20s(total20s);
	}
	@Override
	public void setTotal50s(int total50s) {
		// TODO Auto-generated method stub
		super.setTotal50s(total50s);
	}
	@Override
	public void setTotal1s(int total1s) {
		// TODO Auto-generated method stub
		super.setTotal1s(total1s);
	}
	@Override
	public void setTotal2s(int total2s) {
		// TODO Auto-generated method stub
		super.setTotal2s(total2s);
	}
	@Override
	public void setCashBoxAmount(double cashBoxAmount) {
		// TODO Auto-generated method stub
		super.setCashBoxAmount(cashBoxAmount);
	}
	@Override
	public void enterCoin(double coinEntered) {
		// TODO Auto-generated method stub
		super.enterCoin(coinEntered);
	}
	@Override
	public int[] giveChange(double moneyPaid, double actualCost) {
		// TODO Auto-generated method stub
		return super.giveChange(moneyPaid, actualCost);
	}
	@Override
	public void addTubes(int ten, int twenty, int fifty, int one, int two) {
		// TODO Auto-generated method stub
		super.addTubes(ten, twenty, fifty, one, two);
	}
	@Override
	public String toString() {
		String desc = "Total in collection box: €";
		desc += df.format(super.getCashBoxAmount());
		desc += "\nCoins in tubes: ";
		desc += "\n10c: " + getTotal10s();
		desc += "\n20c: " + getTotal20s();
		desc += "\n50c: " + getTotal50s();
		desc += "\n€1: " + getTotal1s();
		desc += "\n€2: " + getTotal2s();
		return desc;
	}
	
	
	
}
