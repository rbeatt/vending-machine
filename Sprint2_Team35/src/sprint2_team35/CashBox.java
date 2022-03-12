package sprint2_team35;

import java.text.DecimalFormat;

public class CashBox implements ICashBox {

	public int Total10s;
	public int Total20s;
	public int Total50s;
	public int TotalPounds;
	public int Total2Pounds;
	public double CashBoxAmount;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	/**
	 * This method is used to add coins to the cash box
	 * @param CoinEntered - the coin amount
	 */
	
	public void EnterCoin(double CoinEntered) {
	
	 		//When a 10p is entered, the total 10p coins goes up by 1
			if (CoinEntered == 0.1 && Total10s < 50) {
		
				Total10s += 1;
		
				}
				//If there are more than 50 20ps, it will be sent to the Cashbox
				else if (CoinEntered == 0.1 && Total20s >= 50) {
		
					CashBoxAmount += 0.1;
		
		
				}
			
			
			 //When a 20p is entered, the total 20p coins goes up by 1
			if (CoinEntered == 0.2 && Total20s < 50) {
				
				Total20s += 1;
				
				}
			//If there are more than 50 20ps, it will be sent to the Cashbox
			else if (CoinEntered == 0.2 && Total20s >= 50) {
				
				CashBoxAmount += 0.2;
				
				
			}
			
			
			
			
			//When a 50p is entered, the total 50p coins goes up by 1
			if (CoinEntered == 0.5 && Total50s < 50) {
					
					Total50s += 1;
					
					}
			
			
			else if (CoinEntered == 0.5 && Total50s >= 50) {
							
							CashBoxAmount += 0.5;
							
							
						}
			
			
			//When a £1 is entered, the total �1 coins goes up by 1
			if (CoinEntered == 1 && TotalPounds < 50) {
				
				TotalPounds += 1;
				
				}
			
			else if (CoinEntered == 1 && TotalPounds >= 50) {
				
				CashBoxAmount += 1;
				
				
			}
			//When a £2 is entered, the total �2 coins goes up by 1
			if (CoinEntered == 2 && Total2Pounds < 50) {
				
				Total2Pounds += 1;
				
				}
			
			else if (CoinEntered == 2 && Total2Pounds >= 50) {
						
						CashBoxAmount += 2;
						
						
					}
	
			
	} 
	
	/**
	 * toString method for cash box to display total amount stored inside
	 */
			
	public String toString() {
		String desc = "Total in collection box: £";
		desc += df.format(CashBoxAmount);
		desc += "\nCoins in tubes: ";
		desc += "\n10p: " + Total10s;
		desc += "\n20p: " + Total20s;
		desc += "\n50p: " + Total50s;
		desc += "\n£1: " + TotalPounds;
		desc += "\n£2: " + Total2Pounds;
		return desc;
	}
			
}			