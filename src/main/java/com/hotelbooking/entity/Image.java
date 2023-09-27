package com.hotelbooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Image {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int pid;

private String pname;

private String type;

@Lob
private byte[]img;

public int getPid() {
	return pid;
}

public void setPid(int pid) {
	this.pid = pid;
}

public String getPname() {
	return pname;
}

public void setPname(String pname) {
	this.pname = pname;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public byte[] getImg() {
	return img;
}

public void setImg(byte[] img) {
	this.img = img;
}


}
