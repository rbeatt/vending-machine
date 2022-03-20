package sprint2_team35;

/**
 * This class is an interface for the CashBox class and EuroCashBox class.
 * 
 * @author ryanbeattie
 *
 */

public interface ICashBox {
	
	public String getCashBoxName();

	public double[] getAcceptedCoins();

	public double getRate();

	public int getTotal10s();

	public int getTotal20s();

	public int getTotal50s();

	public int getTotal1s();

	public int getTotal2s();

	public void setRate(double rate);

	public void setTotal10s(int total10s);

	public void setTotal20s(int total20s);

	public void setTotal50s(int total50s);

	public void setTotal1s(int total1s);

	public void setTotal2s(int total2s);

	public void enterCoin(double coinEntered);

	public String toString();

}
