package sprint2_team35;

/**
 * This class is an interface for CashBox and classes that may extend from it.
 * 
 * @author ryanbeattie
 *
 */

public interface ICashBox {

	public ChangeTube[] getChangeTubes();

	public void setChangeTubes(int[] tubeAmount);

	public Currency getCurrency();

	public void setCurrency(Currency currency);

	public double getCashBoxAmount();

	public void setCashBoxAmount(double cashBoxAmount);

	public void enterCoin(double coinEntered);

	public int[] giveChange(double moneyPaid, double actualCost);

	public void addTubes(int[] coins);

	public String toString();

	public double[] getAcceptedCoins();

	public void setAcceptedCoins(double[] acceptedCoins);

}
