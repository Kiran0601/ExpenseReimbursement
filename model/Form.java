package com.revature.ers.model;

public class Form {
         public Integer getFormNumber() {
		return formNumber;
	}
	public void setFormNumber(Integer formNumber) {
		this.formNumber = formNumber;
	}
	public Integer getAmount() {
		return amount;
	}
	public int setAmount(Integer amount) {
		return this.amount = amount;
	}
	public String getUserid() {
		return userid;
	}
	public String setUserid(String userid) {
		return this.userid = userid;
	}
	public String getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = submissionDate;
	}
	public String getResolvedDate() {
		return resolvedDate;
	}
	public void setResolvedDate(String resolvedDate) {
		this.resolvedDate = resolvedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTypeOfExpense() {
		return typeOfExpense;
	}
	public String setTypeOfExpense(String typeOfExpense) {
		return this.typeOfExpense = typeOfExpense;
	}
		Integer formNumber;
         Integer amount;
         String userid;
         String submissionDate;
         String resolvedDate;
         String status;
         String typeOfExpense;
		public Form(Integer formNumber, Integer amount, String userid, String submissionDate, String resolvedDate,
				String status, String typeOfExpense) {
			super();
			this.formNumber = formNumber;
			this.amount = amount;
			this.userid = userid;
			this.submissionDate = submissionDate;
			this.resolvedDate = resolvedDate;
			this.status = status;
			this.typeOfExpense = typeOfExpense;
		}
		public Form() {
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Form [formNumber=" + formNumber + ", amount=" + amount + ", userid=" + userid + ", submissionDate="
					+ submissionDate + ", resolvedDate=" + resolvedDate + ", status=" + status + ", typeOfExpense="
					+ typeOfExpense + "]";
		}
         
}
