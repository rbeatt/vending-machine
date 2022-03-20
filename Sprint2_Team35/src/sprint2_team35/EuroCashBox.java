package sprint2_team35;

import java.text.DecimalFormat;

public class EuroCashBox extends CashBox implements ICashBox {
	private static final DecimalFormat df = new DecimalFormat("0.00");
	private double rate;
	private double[] acceptedCoins = { 0.10, 0.20, 0.50, 1.00, 2.00 };
	private String cashBoxName;
	private String[] cashBoxSymbols = { "€", "c" };

	public EuroCashBox() {
		super();
		this.rate = 1.19;
		this.cashBoxName = "EUR";
	}

	
	@Override
	public String[] getCashBoxSymbols() {
		return this.cashBoxSymbols;
	}
	
	@Override
	public String getCashBoxName() {
		return this.cashBoxName;
	}

	@Override
	public double[] getAcceptedCoins() {
		return this.acceptedCoins;
	}
	
	@Override
	public double getRate() {
		return this.rate;
	}
	
	@Override
	public void setRate(double rate) {
		this.rate = rate;
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
	public void addTubes(int[] coins) {
		// TODO Auto-generated method stub
		super.addTubes(coins);
	}

	@Override
	public String toString() {
		String desc = "Total in collection box: " + this.cashBoxSymbols[0];
		desc += df.format(this.getCashBoxAmount());
		desc += "\nCoins in tubes: ";
		desc += "\n10" + this.cashBoxSymbols[1] + ": " + getTotal10s();
		desc += "\n20" + this.cashBoxSymbols[1] + ": " + +getTotal20s();
		desc += "\n50" + this.cashBoxSymbols[1] + ": " + +getTotal50s();
		desc += "\n" + this.cashBoxSymbols[0] + "1: " + getTotal1s();
		desc += "\n" + this.cashBoxSymbols[0] + "2: " + getTotal2s();
		return desc;
	}

}
