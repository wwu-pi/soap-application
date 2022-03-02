package de.wwu.acse.soap.service;

import de.wwu.acse.soap.MyNumber;
import de.wwu.acse.soap.MySum;

public interface AdderService {
	
	MySum add(MyNumber n1, MyNumber n2);
	
}
