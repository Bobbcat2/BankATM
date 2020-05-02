
package BankATMCommon;

import java.util.ArrayList

public interface DailyReport {
  
  public ArrayList<Transaction> dailyReport(ArrayList<Transactions> transactions, Date time);
  
}
