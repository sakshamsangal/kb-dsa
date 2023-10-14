package com.app.util;

public class DLLNode {
	public DLLNode prev;
	public int key;
	public int val;
	public DLLNode next;

	public DLLNode(int key, int val) {
		this.key = key;
		this.val = val;
	}
}