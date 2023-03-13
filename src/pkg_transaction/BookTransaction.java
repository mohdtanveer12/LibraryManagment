package pkg_transaction;

import java.io.Serializable;

public class BookTransaction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int isbn;
	private int rollNo;
	private String issueDate;
	private String returnDate;
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollno(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getIssudate() {
		return issueDate;
	}
	public void setIssudate(String issuDate) {
		this.issueDate = issuDate;
	}
	public String getReturndate() {
		return returnDate;
	}
	public void setReturndate(String returndate) {
		this.returnDate = returndate;
	}
	public BookTransaction(int isbn, int rollNo, String issuedate, String returndate, String issueDate,String returnDate) {
		super();
		this.isbn = isbn;
		this.rollNo = rollNo;
		this.issueDate = issueDate;
		this.returnDate = returndate;
	}
	public BookTransaction() {
		super();
	}
	@Override
	public String toString() {
		return "BookTransction [isbn=" + isbn + ", rollNo=" + rollNo + ", issudate=" + issueDate + ", returnDate="
				+ returnDate + "]";
	}

}
