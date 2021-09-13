package prob03;

import java.util.Objects;

public class Money {
	private int amount;
	
	/* 코드 작성 */
	public Money() {
		
	}
	public Money(int amount) {
		this.amount=amount;
	}
	//=========================================================================
	public Money add(Money m) {
		int amt = this.amount + m.getAmount();
		Money new_m = new Money(amt);
		return new_m;
		
	}
	
	public Money minus(Money m) {
		int amt = this.amount - m.getAmount();
		Money new_m = new Money(amt);
		return new_m;	
	}
	
	public Money multiply(Money m) {
		int amt = this.amount * m.getAmount();
		Money new_m = new Money(amt);
		return new_m;
	}
	
	public Money devide(Money m) {
		int amt = this.amount / m.getAmount();
		Money new_m = new Money(amt);
		return new_m;
	}
	//=========================================================================
	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return amount == other.amount;
	}
	
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
