package com.sample;

import java.util.Arrays;

public class DroolFuZhu {
	public  int startI;
	public  int startJ;
	public  int endI;
	public  int endJ;
	public  String name;
	public  QiZi[][] qiZi;
	public int maxI;//定义一些辅助变量
	public int minI;
	public int maxJ;
	public int minJ;
	public boolean canMove;
	public String fangfaming;
	
	public int getStartI() {
		return startI;
	}
	public void setStartI(int startI) {
		this.startI = startI;
	}
	public int getStartJ() {
		return startJ;
	}
	public void setStartJ(int startJ) {
		this.startJ = startJ;
	}
	public int getEndI() {
		return endI;
	}
	public void setEndI(int endI) {
		this.endI = endI;
	}
	public int getEndJ() {
		return endJ;
	}
	public void setEndJ(int endJ) {
		this.endJ = endJ;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public QiZi[][] getQiZi() {
		return qiZi;
	}
	public void setQiZi(QiZi[][] qiZi) {
		this.qiZi = qiZi;
	}
	public int getMaxI() {
		return maxI;
	}
	public void setMaxI(int maxI) {
		this.maxI = maxI;
	}
	public int getMinI() {
		return minI;
	}
	public void setMinI(int minI) {
		this.minI = minI;
	}
	public int getMaxJ() {
		return maxJ;
	}
	public void setMaxJ(int maxJ) {
		this.maxJ = maxJ;
	}
	public int getMinJ() {
		return minJ;
	}
	public void setMinJ(int minJ) {
		this.minJ = minJ;
	}
	public boolean isCanMove() {
		return canMove;
	}
	public void setCanMove(boolean canMove) {
		this.canMove = canMove;
	}
	@Override
	public String toString() {
		return "DroolFuZhu [startI=" + startI + ", startJ=" + startJ + ", endI=" + endI + ", endJ=" + endJ + ", name="
				+ name + ", qiZi=" + Arrays.toString(qiZi) + ", maxI=" + maxI + ", minI=" + minI + ", maxJ=" + maxJ
				+ ", minJ=" + minJ + ", canMove=" + canMove + "]";
	}
	public String getFangfaming() {
		return fangfaming;
	}
	public void setFangfaming(String fangfaming) {
		this.fangfaming = fangfaming;
	}
	
	
}
