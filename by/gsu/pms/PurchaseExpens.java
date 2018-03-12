package by.gsu.pms;

public class PurchaseExpens extends AbstractPurchase{

        private int expenses;

        public PurchaseExpens() {
        }

        public PurchaseExpens(Commodity commodity, int count, int expenses) {
            super(commodity,count);
            this.expenses = expenses;
        }
        public int getExpenses() {
        return expenses;
         }

         public void setExpenses(int expenses) {
             this.expenses = expenses;
         }

        @Override
        public int getCost() {
            return getCommodity().getPrice()*getCount()+expenses;
        }
        @Override
        public String toString() {
            return fieldsToString()+';'+Convert.convertToByn(expenses,100,2)+';'+Convert.convertToByn(getCost(),100,2);

        }


    }

