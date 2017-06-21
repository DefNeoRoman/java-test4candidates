package ru.garant.mdp;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Model {
	
	@Id
    @GeneratedValue(strategy = AUTO)
    @Column
    private long id;
	
	@Column(length = 200, nullable = false)
    private String field0;

	@Column(length = 200, nullable = false)
    private String field1;

	@Column(length = 200, nullable = false)
    private String field2;

	@Column(length = 200, nullable = false)
    private String field3;

	@Column(length = 200, nullable = false)
    private String field4;

	@Column(length = 200, nullable = false)
    private String field5;

	@Column(length = 200, nullable = false)
    private String field6;

	@Column(length = 200, nullable = false)
    private String field7;

	@Column(length = 200, nullable = false)
    private String field8;

	@Column(length = 200, nullable = false)
    private String field9;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getField0() {
		return field0;
	}

	public void setField0(String field0) {
		this.field0 = field0;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	public String getField4() {
		return field4;
	}

	public void setField4(String field4) {
		this.field4 = field4;
	}

	public String getField5() {
		return field5;
	}

	public void setField5(String field5) {
		this.field5 = field5;
	}

	public String getField6() {
		return field6;
	}

	public void setField6(String field6) {
		this.field6 = field6;
	}

	public String getField7() {
		return field7;
	}

	public void setField7(String field7) {
		this.field7 = field7;
	}

	public String getField8() {
		return field8;
	}

	public void setField8(String field8) {
		this.field8 = field8;
	}

	public String getField9() {
		return field9;
	}

	public void setField9(String field9) {
		this.field9 = field9;
	}
}
